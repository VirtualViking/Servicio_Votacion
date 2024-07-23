package poll.software.pollservice.application.services;

import poll.software.pollservice.application.exceptions.VoteException;
import poll.software.pollservice.application.repositories.VoteRepository;
import poll.software.pollservice.application.usecases.VoteService;
import poll.software.pollservice.domain.models.Candidate;

import java.util.Map;

public class VoteServiceImp implements VoteService {
  private final VoteRepository voteRepository;
  public VoteServiceImp(VoteRepository voteRepository) {
    this.voteRepository = voteRepository;
  }
  @Override
  public void vote(String studentDocument, Long candidateId) {

    validateNotRepeatedVote(studentDocument);

    voteRepository.saveVote(studentDocument, candidateId);

  }

  @Override
  public Map<Candidate, Integer> getVoteStatistics() {
    return voteRepository.getVoteStatistics();
  }

  private void validateNotRepeatedVote(String studentDocument) {
    if (voteRepository.existsVoteByStudentDocument(studentDocument)) {
      throw new VoteException("El estudiante ya ha votado");
    }
  }
}
