Registro das correções e implementações feitas no projeto sistema-cursos (API REST de cursos e módulos — Spring Boot).

Controllers
CursoController
Corrigido CursoService.findById → cursoService.findById (uso do campo injetado, não da classe).
Adicionado o import de CursoStatus.
updateCurso passou a ter o return que faltava.
@Positive aplicado aos @PathVariable Long id.
ModuloController
Removido o @RequestMapping("/api/modulos") da classe.
Rotas reescritas para o formato aninhado: /api/cursos/{cursoId}/modulos (criar/listar) e /api/modulos/{id} (buscar/deletar).
cursoId corrigido de @RequestParam para @PathVariable (causa do erro "No static resource").
create passou a receber o cursoId pela URL.
Services
Criados os ServiceImpl com injeção de dependência por construtor.
ModuloServiceImpl
Injetado também o CursoRepository.
create(cursoId, request) busca o curso e associa o módulo a ele.
findByCursoId retorna 404 quando o curso não existe.
Removido o método findModuloId (sobra que quebrava o @Override).
findById passou a lançar ResourceNotFoundException em vez de RuntimeException.
update reescrito para atualizar a entidade existente (sem setId).
Corrigido o parâmetro Curso status → CursoStatus status na interface.
DTOs, Mapper e Validação
DTOs em record para request/response; ModuloResponse expõe cursoId (sem aninhar o curso).
Mappers utilitários (construtor privado, apenas toResponse).
Constraint customizada @MultipleOf (anotação + ConstraintValidator) para cargaHoraria.
Tratamento de erros
Criados ResourceNotFoundException, ErrorResponse e ValidationErrorResponse.
GlobalExceptionHandler com handlers para 404, 400 (validação) e 500 (catch-all).
Entidades e status (bônus)
Curso: @OneToMany com cascade = ALL e orphanRemoval = true; status inicial RASCUNHO; setStatus manual com validação de transição.
CursoStatus: enum com máquina de estados (RASCUNHO → PUBLICADO → ARQUIVADO).
Novo endpoint PATCH /api/cursos/{id}/status para alterar o status.