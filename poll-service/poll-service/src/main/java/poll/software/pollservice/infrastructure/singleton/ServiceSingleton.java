package poll.software.pollservice.infrastructure.singleton;

import poll.software.pollservice.application.services.CandidateServiceImp;
import poll.software.pollservice.application.services.VoteServiceImp;
import poll.software.pollservice.application.usecases.CandidateService;
import poll.software.pollservice.application.usecases.VoteService;
import poll.software.pollservice.infrastructure.persistence.repositories.CandidateRepositoryJdbcAdapter;
import poll.software.pollservice.infrastructure.persistence.repositories.VoteRepositoryJdbcAdapter;

public class ServiceSingleton {
  private static ServiceSingleton instance;
  private CandidateService candidateService;
  private VoteService voteService;

  private ServiceSingleton() {
    candidateService = new CandidateServiceImp(new CandidateRepositoryJdbcAdapter());
    voteService = new VoteServiceImp(new VoteRepositoryJdbcAdapter(new CandidateRepositoryJdbcAdapter()));
  }

  public static ServiceSingleton getInstance() {
    if (instance == null) {
      instance = new ServiceSingleton();
    }
    return instance;
  }
  public CandidateService getCandidateService() {
    return candidateService;
  }
  public VoteService getVoteService() {
    return voteService;
  }
}
