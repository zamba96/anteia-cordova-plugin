import ListResult from './ListResult';

export default class ExternalQueryResult {
  result: boolean = false;
  externalEntityName: string | undefined = undefined;
  externalEntityId: string | undefined = undefined;
  idConsultado: string | undefined = undefined;
  tipoIdConsultado: string | undefined = undefined;
  risk: boolean = false;
  warning: boolean = false;
  numConsultedLists: number = -1;
  numResultsWithRisk: number = -1;
  listResults: ListResult[] = [];
}
