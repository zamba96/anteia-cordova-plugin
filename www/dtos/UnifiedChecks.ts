import UnifiedCheck from './UnifiedCheck';

export default class UnifiedChecks {
  ocrCheck: UnifiedCheck = new UnifiedCheck();
  gpsCheck: UnifiedCheck = new UnifiedCheck();
  otpCheck: UnifiedCheck = new UnifiedCheck();
  emailCheck: UnifiedCheck = new UnifiedCheck();
  facematchCheck: UnifiedCheck = new UnifiedCheck();
  documentValidityCheck: UnifiedCheck = new UnifiedCheck();
  documentMatchCheck: UnifiedCheck = new UnifiedCheck();
  governmentDataMatchCheck: UnifiedCheck = new UnifiedCheck();
  listsCheck: UnifiedCheck = new UnifiedCheck();
  deviceIdCheck: UnifiedCheck = new UnifiedCheck();
  documentCaptureCheck: UnifiedCheck = new UnifiedCheck();
}
