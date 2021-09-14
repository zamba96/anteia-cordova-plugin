import BiometricResponse from './BiometricResponse';
import ExternalQueryResult from './ExternalQueryResult';
import GovernmentData from './GovernmentData';
import InitialData from './InitialData';
import QuestionResponse from './QuestionResponse';
import UnifiedChecks from './UnifiedChecks';
import UserDeviceInfo from './UserDeviceInfo';
import UserLocation from './UserLocation';

export default class Registration {
  projectId: string | undefined = undefined;
  clientId: string | undefined = undefined;
  userId: string | undefined = undefined;
  userIdType: string | undefined = undefined;
  userIdentification: string | undefined = undefined;
  idConfirmed: boolean = false;
  idMatch: boolean = false;
  isNaturalPerson: boolean = true;
  name: string | undefined = undefined;
  lastName: string | undefined = undefined;
  nit: string | undefined = undefined;
  startDatetime: Date | undefined = undefined;
  email: string | undefined = undefined;
  phone: string | undefined = undefined;
  endDatetime: Date | undefined = undefined;
  videoPath: string | undefined = undefined;
  txHash: string | undefined = undefined;
  result: Boolean = false;
  questionResponses: QuestionResponse[] = [];
  bioResponses: BiometricResponse[] = [];
  devices: UserDeviceInfo[] = [];
  location: UserLocation | undefined = undefined;
  externalQueryResults: ExternalQueryResult[] = [];
  redirectionUrl: string | undefined = undefined;
  needsManualRevision: boolean = false;
  hasAlerts: boolean = false;
  faceMatchPercent: number = 0.0;
  voiceSaved: boolean = false;
  needsPhonePhoto: boolean = false;
  country: string | undefined = undefined;
  governmentData: GovernmentData | undefined = undefined;
  governmentDataCheck: boolean = false;
  documentValidityCheck: boolean = true;
  blockingListsAlert: boolean = false;
  customData: {} = {};
  initialData: InitialData | undefined = undefined;
  initialDataCheck: boolean | undefined = undefined;
  phoneConfirmed: boolean = false;
  emailConfirmed: boolean = false;
  dataDone: boolean = false;
  unifiedChecks: UnifiedChecks | undefined = undefined;
  unifiedChecksOk: boolean = false;
  rut: string | undefined = undefined;
  wrongDataUrl: string | undefined = undefined;
  wrongDataWebhook: string | undefined = undefined;
  codeUsed: string | undefined = undefined;
  currentStep: string | undefined = undefined;
  acceptedTyC: boolean = false;
}
