package poll.software.pollservice.application.services;

import poll.software.pollservice.application.repositories.CandidateRepository;
import poll.software.pollservice.application.usecases.CandidateService;
import poll.software.pollservice.domain.models.Candidate;
import poll.software.pollservice.Util;

import java.util.List;

public class CandidateServiceImp implements CandidateService {
  private CandidateRepository candidateRepository;
  public CandidateServiceImp(CandidateRepository candidateRepository) {
    this.candidateRepository = candidateRepository;
  }
  @Override
  public List<Candidate> getCandidates() {
    return candidateRepository.getCandidatesByShiftTime(Util.getShiftTime());
  }
}
