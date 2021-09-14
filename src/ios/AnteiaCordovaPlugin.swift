import Foundation
import Anteia

class AnteiaCordovaPlugin: CDVPlugin {
    private var command : CDVInvokedUrlCommand?
    
    @objc(coolMethod:)
    func coolMethod(command : CDVInvokedUrlCommand) //this method will be called web app
    {
        let result = prepareResult()
        self.commandDelegate.send(result, callbackId: command.callbackId)
    }
    
    @objc(launchTermsAndConditions:)
    func launchTermsAndConditions(command : CDVInvokedUrlCommand) //this method will be called web app
    {
        self.command = command
        let vc = TermsAndConditionsModule.build()
        bridge?.presentVC(vc, animated: true, completion: nil)
    }
    
    @objc(launchDataEntry:)
    func launchDataEntry(command : CDVInvokedUrlCommand) //this method will be called web app
    {
        self.command = command
        let vc = AnteiaUserFormModule.build()
        bridge?.presentVC(vc, animated: true, completion: nil)
    }
    
    @objc(launchConfirmEmail:)
    func launchConfirmEmail(command : CDVInvokedUrlCommand) //this method will be called web app
    {
        self.command = command
        let vc = OtpModule.build()
        bridge?.presentVC(vc, animated: true, completion: nil)
    }
    
    @objc(launchConfirmPhone:)
    func launchConfirmPhone(command : CDVInvokedUrlCommand) //this method will be called web app
    {
        self.command = command
        let vc = OtpModule.build(from: .phone)
        bridge?.presentVC(vc, animated: true, completion: nil)
    }
    
    @objc(launchBiometrics:)
    func launchBiometrics(command : CDVInvokedUrlCommand) //this method will be called web app
    {
        self.command = command
        let vc = MLViewModule.build()
        bridge?.presentVC(vc, animated: true, completion: nil)
    }
    
    @objc(executeLists:)
    func executeLists(command : CDVInvokedUrlCommand) //this method will be called web app
    {
        self.command = command
    }
    
    @objc(setCredentials:)
    func setCredentials(command : CDVInvokedUrlCommand) //this method will be called web app
    {}
}


extension AnteiaCordovaPlugin: RegistrationDelegate {
    public func getRegistrationProcessInfo(from data: [String : String]) {
        let result = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: data)
        self.commandDelegate.send(result, callbackId: command.callbackId)
    }
}
