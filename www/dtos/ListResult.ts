export default class ListResult {
  listName: string | undefined= undefined;
  resultDetails: string[] = [];
  result: boolean = false;
  risk: boolean = false;
  warning: boolean = false;
  errorString: string | undefined= undefined;
  isBlocking: boolean = false;
  nameMatch: boolean = false;
  documentMatch: boolean = false;
}
