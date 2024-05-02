/*=========================================================
* History
* 2011.12.12 김상수 [CHM-201115107-01] MNR Repair SPP Upload 기능 Verify Result 기능 강화
*                                      - Error 발생시 사용자 메세지 팝업창 수정
*                                      - Confirm시 Fail일때, 원인내용 표기
* 2011.12.16 신혜정 [CHM-201115121-01] 유저아이디 Office Change 로 로긴정보 중 RHQ 변경 안되는 로직 보완
* 2012.01.12 신혜정 [CHM-201215612-01] MNR00367 메세지 추가
* 2012.04.05 신혜정 [CHM-201217201] Disposal Invoice Issue 화면내 [Confirm], [Cancel] 처리시, invoice no 체크 로직 추가
*                                   - MNR00370, MNR00371 메세지 추가
* 2012.04.26 신혜정 [CHM-201217485] MNR00373 메세지 추가 
* 2013.01.03 조경완 [CHM-201222154-01] MNR00383 메세지 추가                       
* 2013.05.09 조경완 [CHM-201324479-01][MNR] Repair Estimate 처리시 이미 처리된 Data를 재 Save, Request, Approval 할 경우 발생하는 SQL Error 처리
* 2013.07.23 조경완 [CHM-201325776-01] ALPS MNR-Total - Total Loss Request시에 TLL DATE에 대한 Validation 구현 요청
* 2013.08.07 조경완 [CHM-201326069-01] [MNR-자체개선] Write off Request 기능 보완      
* 2013.09.27 조경완 [CHM-201326609-01] ALPS MNR-Disposal-Disposal Management에서 비딩 결과를 이메일로 통보해주는 기능 
* 2013.11.01 JongHee HAN [CHM-201327244] ALPS-MNR-TOTAL LOSS-WRITE OFF REQUST시 "Save" Button Click 시 경고 메시지 요청 MNR00395 추가
* 2013.11.27 이혜민 [CHM-201327675-01] Sold Date를 오늘 날짜 이상은 입력 불가능 하도록 입력 날짜 Validation MNR00396 추가 
* 2014-02-26 Jonghee HAN Live malfunction fixed
* 2014.03.03 최덕우 [CHM-201428942-01] Write Off Apprival Route Manager Selection의 PIC 공백 체크 Validation MNR00399 추가 
=========================================================*/

//*************** MNR MESSAGE START ***************//
//MNR COMMON MESSAGE
msgs['MNR00001'] = 'Unexpected system error took place during data processing. Please try again.';
msgs['MNR00002'] = 'Failed to display import result.  Please try again.';
msgs['MNR00003'] = 'Mandatory field is missing. Please enter {?msg1}.';
msgs['MNR00005'] = '{?msg1} doesn\'t exist';
msgs['MNR00006'] = '{?msg1} is duplicated.';
msgs['MNR00007'] = 'The changed data is found. Do you want to retrieve it again ?';
msgs['MNR00008'] = 'Failed to save {?msg1}.  Please try again.';
msgs['MNR00009'] = '{?msg1} was saved successfully.';
msgs['MNR00010'] = '{?msg1} is invalid.';
msgs['MNR00011'] = 'Failed to open {?msg1}.  Please try again.';
msgs['MNR00012'] = 'Warranty Period format is From and To, Please enter a valid date format.';
msgs['MNR00014'] = 'Please input Remark.';
msgs['MNR00015'] = 'Date format is wrong. Please enter a valid date format(YYYY-MM-DD).';
msgs['MNR00016'] = 'EQ No. is invalid.';
msgs['MNR00017'] = '{?msg1} is wrong with field length.';
msgs['MNR00018'] = 'Error data found in the selected rows.  Please check it again.';
msgs['MNR00020'] = 'Data deleted successfully.';
msgs['MNR00021'] = 'Failed to open File Dialog.';
msgs['MNR00023'] = 'Data saved successfully.';
msgs['MNR00024'] = 'The selected data is not found.';
msgs['MNR00025'] = '{?msg1} is not available, Please check again.';
msgs['MNR00026'] = 'Do you want to delete it ?';
msgs['MNR00027'] = 'Failed to delete the data.';
msgs['MNR00028'] = 'Failed to (value), Please try again.';
msgs['MNR00030'] = '{?msg1} doesn\'t exist.';
msgs['MNR00031'] = 'Please input vessel code.';
msgs['MNR00032'] = 'Tariff No. is duplicated.';
msgs['MNR00033'] = 'The data exists in other tab.  Do you want to delete it ?';
msgs['MNR00034'] = 'Tariff was requested successfully.';
msgs['MNR00035'] = 'Only one {?msg1} can be selected.';
msgs['MNR00036'] = 'Please select {?msg1} data.';
msgs['MNR00037'] = 'Any error was found while searching for Repair Code.  ';
msgs['MNR00038'] = 'Please select the data  first.';
msgs['MNR00039'] = 'Do you want to {?msg1} the selected tariff ?';
msgs['MNR00040'] = 'The taiff was retrieved successfully.';
msgs['MNR00041'] = 'Unexpected error took place while data processing. Please try again.';
msgs['MNR00042'] = 'Please input a numeric value on tariff material.';
msgs['MNR00044'] = 'Data was created successfully.';
msgs['MNR00046'] = 'Do you want to delete this agreement ?';
msgs['MNR00046'] = 'Do you want to delete this agreement ?';
msgs['MNR00047'] = 'Please retrieve the agreement to delete first.';
msgs['MNR00048'] = 'Failed to delete {?msg1}.  Please try again.';
msgs['MNR00051'] = 'Expense Plan was created successfully.';
msgs['MNR00052'] = 'Expense Plan was adjusted successfully.';
msgs['MNR00054'] = 'Please retrieve the estimate to delete first.';
msgs['MNR00055'] = '[This estimate] was requested successfully.';
msgs['MNR00056'] = 'Failed to retrieve agreement inforamtion.  Please try again.';
msgs['MNR00057'] = 'Failed to retrieve {?msg1}. Please try again.';
msgs['MNR00058'] = 'Yard code is invalid.';
msgs['MNR00059'] = 'Row which isn\'t calculated in this estimate was found. Please calculate target row in advance.';
msgs['MNR00060'] = '[Counteroffer of this estimate] was saved successfully.';
msgs['MNR00061'] = '[This estimate] was rejected successfully.';
msgs['MNR00062'] = 'Do you want to request approval of this estimate to your Upper Office by Repair Approval Authority Rule ?';
msgs['MNR00063'] = 'Failed to retrieve Repair Approval Authority Office.';
msgs['MNR00064'] = 'Target data which have to be arranged into TPB system in this estimate was found. Do you want to arrange TPB Request after Approval ?';
msgs['MNR00065'] = 'Estimate was approved. Do you want to create work Order ?';
msgs['MNR00066'] = 'Approval of this estiamte has requeted to your upper office.';
msgs['MNR00067'] = 'Failed to approve (VALUE).';
msgs['MNR00068'] = 'Failed to calculate {?msg1}. Please try again.';
msgs['MNR00069'] = '{?msg1} was calculated successfully.';
msgs['MNR00070'] = 'Estimates were rejected by group auduting.';
msgs['MNR00071'] = 'Failed to save group auditing.';
msgs['MNR00072'] = 'Please select target data to create work order.';
msgs['MNR00073'] = 'Work Order created successfully.';
msgs['MNR00074'] = 'Failed to create work order.';
msgs['MNR00075'] = 'Work order was sent successfully.';
msgs['MNR00076'] = 'Failed to send work order.';
msgs['MNR00078'] = 'Repair Creation was saved successfully.';
msgs['MNR00079'] = 'At least one row needs to be selected. ';
msgs['MNR00080'] = 'Cost code and cost detail code are unmatched. Do you still want to initialize it ?';
msgs['MNR00081'] = 'Please select the work order to delete first.';
msgs['MNR00082'] = 'Work order was deleted successfully.';
msgs['MNR00083'] = 'This work order must be caculated before creating it. Pleases click  Caculation Button.';
msgs['MNR00084'] = 'Mandatory field is missing. Please input EQ No..';
msgs['MNR00085'] = 'M&R Invoice was created successfully.';
msgs['MNR00086'] = 'M&R Invoice was confirmed successfully.';
msgs['MNR00087'] = 'Failed to save {?msg1}. Please try again.';
msgs['MNR00088'] = 'Do you want to delete this invoice ?';
msgs['MNR00089'] = 'Please select the invoice to delete first.';
msgs['MNR00090'] = '{?msg1} was deleted successfully.';
msgs['MNR00091'] = 'Failed to delete {?msg1}. Please try again.';
msgs['MNR00092'] = 'Do you want to reject this web invoice ? ';
msgs['MNR00093'] = 'Reject of Web Invoice is available.';
msgs['MNR00094'] = 'The web invoice was rejected successfully.';
msgs['MNR00095'] = 'Failed to reject the web invoice. Please try again.';
msgs['MNR00096'] = 'Please select service provider to file import.';
msgs['MNR00097'] = 'Please select target Invoice data to verify.';
msgs['MNR00098'] = '{?msg1} and {?msg2} are unmatched. Please check again.';
msgs['MNR00099'] = 'Service Provider is mandatory field to search work order.';
msgs['MNR00100'] = 'Please select only one row in case of correction in web invoice.';
msgs['MNR00101'] = 'Failed to input vessel code.  Please try again.';
msgs['MNR00102'] = 'Cancellation is available in case of inputting estimate type only.';
msgs['MNR00103'] = 'Do you want to cancel approval of the estimate ?';
msgs['MNR00104'] = 'Data cancelled successfully.';
msgs['MNR00105'] = 'Repair Work Order and Estimate were deleted successfully.';
msgs['MNR00106'] = 'This extra disposal was already created. ';
msgs['MNR00107'] = 'This extra disposal was already confirmed. ';
msgs['MNR00108'] = '[Extra Disposal] was saved successfully.';
msgs['MNR00109'] = '[Extra Disposal] was confirmed successfully.';
msgs['MNR00110'] = '[Extra Disposal] was cancelled successfully.';
msgs['MNR00111'] = '[Disposal Candidate] was created successfully.';
msgs['MNR00112'] = 'Please input 11 digit sequence in case of Container EQ.';
msgs['MNR00113'] = '[Disposal Plan] was saved successfully.';
msgs['MNR00114'] = '[Disposal Plan] was confirmed successfully.';
msgs['MNR00115'] = '[Disposal Tariff] was saved successfully.';
msgs['MNR00116'] = '[Disposal Tariff] was confirmed successfully.';
msgs['MNR00117'] = 'Location Code is invalid.';
msgs['MNR00118'] = 'Currency Code is invalid.';
msgs['MNR00119'] = 'Please select EQ Type';
msgs['MNR00120'] = 'Please select Tariff Type';
msgs['MNR00121'] = 'Please connect Customer Code';
msgs['MNR00122'] = '[Buyer Information] was saved successfully.';
msgs['MNR00123'] = 'Please save it before confirming Buyer.';
msgs['MNR00124'] = '[Buyer Confirmation] was created successfully.';
msgs['MNR00125'] = 'Failed to confirm Buyer. Please try again.';
msgs['MNR00126'] = 'Please retrieve the Buyer to delete.';
msgs['MNR00127'] = '[Buyer] was deleted successfully.';
msgs['MNR00128'] = 'Pls select Buyer to search the detail information.';
msgs['MNR00129'] = '[Disposal Information] was saved successfully.';
msgs['MNR00130'] = '[Disposal Information] was created successfully.';
msgs['MNR00131'] = 'This Disposal was requested successfully';
msgs['MNR00132'] = 'Please select Disposal to delete.';
msgs['MNR00133'] = 'This Disposal was deleted successfully';
msgs['MNR00134'] = 'Unexpected error took place while Disposal deleting. Please try again.';
msgs['MNR00135'] = 'There is no the detail information of this Disposal.  ';
msgs['MNR00136'] = 'Failed to calculate by Tariff, Please try again.';
msgs['MNR00137'] = 'Disposal was rejected successfully.';
msgs['MNR00138'] = 'Disposal was approved successfully.';
msgs['MNR00139'] = 'Disposal was confirmed successfully.';
msgs['MNR00140'] = 'Please select the successful buyer for this bidding. ';
msgs['MNR00141'] = 'Sold Creation was saved successfully.';
msgs['MNR00142'] = 'Please select Disposal to save Sold Creation.';
msgs['MNR00143'] = 'Please select upper {?msg1}.';
msgs['MNR00144'] = 'This disposal come out re-bidding.';
msgs['MNR00145'] = '[Guideline & Information] was created successfully.';
msgs['MNR00147'] = 'Please input {?msg1} after search.';
msgs['MNR00148'] = '{?msg1} doesn\'t exist in the upper location code.';
msgs['MNR00150'] = 'Please select target data to delete.';
msgs['MNR00151'] = 'Data was confirmed.\n\n (Success: {?msg1} / Fail: {?msg2})';
msgs['MNR00152'] = 'Total Loss was created successfully.';
msgs['MNR00153'] = 'Data was saved successfully.';
msgs['MNR00154'] = 'Total Loss was {?msg1} successfully.';
msgs['MNR00156'] = 'Only numeric value is allowed.';
msgs['MNR00157'] = 'Please click verify button now, and then change the data.';
msgs['MNR00158'] = 'Data was verified successfully.';
msgs['MNR00159'] = 'Failed to Verify{?msg1}.  Please try again.';
msgs['MNR00160'] = 'Do you want to save it ?';
msgs['MNR00161'] = 'Please enter {?msg1} in either English letters or numbers.';
msgs['MNR00162'] = 'Please check the period.';
msgs['MNR00163'] = '{?msg1} has been duplicated. ';
msgs['MNR00165'] = '{?msg1} doesn\'t exist, Please check again.';
msgs['MNR00166'] = 'Value1 must be lower than Value2.';
msgs['MNR00167'] = 'Please input Field Quality Audit Result Data.';
msgs['MNR00168'] = 'The only same user can delete the inputted FQA Information.';
msgs['MNR00172'] = 'Please input {?msg1}.';
msgs['MNR00173'] = 'Value1 must be higher than Value2.';
msgs['MNR00175'] = '{?msg1} should be above 0(zero).';
msgs['MNR00176'] = 'There is no first volume applicable to the same spec.  Please recheck.';
msgs['MNR00177'] = 'Failed to modify {?msg1}.';
msgs['MNR00178'] = '{?msg1} of {?msg2} is already exist. Inputting is not impossible. \n {?msg3}';
msgs['MNR00180'] = 'Failed to upgrade current version ?';
msgs['MNR00181'] = 'You have no authority to inquire {?msg1}.';
msgs['MNR00182'] = 'Please select target agreement for version-up first.';
msgs['MNR00183'] = 'Do you want to save this agreement ?';
msgs['MNR00185'] = 'FQA Result Date of the Service Provider/Yard is duplicated. ';
msgs['MNR00186'] = '{?msg1} Duplication occurred.';
msgs['MNR00187'] = 'Cost CTRL office is mandatory. Please enter office.';
msgs['MNR00188'] = 'Operation Office and Upper Office must be not same.';
msgs['MNR00189'] = 'S/P code is invalid.';
msgs['MNR00190'] = 'The data was already confirmed.';
msgs['MNR00191'] = 'You can\'t retrieve {?msg1} in version-up status.';
msgs['MNR00192'] = 'Do you want to initialize data ?';
msgs['MNR00193'] = 'You can\'t delete {?msg1} in version-up status.';
msgs['MNR00194'] = 'The state is already Version Up';
msgs['MNR00195'] = 'At least one rate needs to be inputted.';
msgs['MNR00196'] = '{?msg1} must be lower than {?msg2}.';
msgs['MNR00197'] = 'Do you want to confirm ?';
msgs['MNR00198'] = 'EQ type is unknown, Please select service provider.';
msgs['MNR00199'] = 'Please retrieve (value) first.';
msgs['MNR00201'] = '{?msg1} is mandatory. Please enter {?msg1}.';
msgs['MNR00202'] = 'Tariff No. doesn\'t exist, Are you sure to save it ?';
msgs['MNR00203'] = 'Currency of Agreement and Currency of Tariff are unmatched. Please check again.';
msgs['MNR00204'] = 'There is no data to search.';
msgs['MNR00205'] = 'Please select cost type.';
msgs['MNR00206'] = 'Please modify madatory column only.';
msgs['MNR00207'] = 'At least one item needs to be inputted.';
msgs['MNR00208'] = '{?msg1} information is already changed to {?msg2}';
msgs['MNR00210'] = 'Request Status of the Tariff can be rejected only.';
msgs['MNR00211'] = 'There is the Estimate which is under proceeding.';
msgs['MNR00212'] = 'Are you sure to Request?';
msgs['MNR00213'] = 'Please search the Estimate to request first.';
msgs['MNR00214'] = 'There is not additional volume under the same spec. Please try again.';
msgs['MNR00215'] = 'Please input Location or EQ No.';
msgs['MNR00216'] = 'There is the guideline to delete. Are you sure to delete?';
msgs['MNR00217'] = 'This file is invalid. Please select the other files.';
msgs['MNR00218'] = 'The selected agreement is old version. The latest vesion of the agreement will be re-connected. ';
msgs['MNR00219'] = 'Please search the estimate to counteroffer first.';
msgs['MNR00220'] = 'Please search the estimate to reject first.';
msgs['MNR00221'] = 'Please search the estimate to approve first.';
msgs['MNR00222'] = 'Work Order was changed successfully.';
msgs['MNR00223'] = 'Please enter either Yard Code or EQ No in inquiry field.';
msgs['MNR00224'] = 'QTY must be higher than zero.';
msgs['MNR00225'] = 'Failed to open Cost Code .';
msgs['MNR00226'] = 'Please input EQ No. first.';
msgs['MNR00227'] = 'Please carry out Cacuation first.';
msgs['MNR00228'] = 'In Service Sub Type, EQ No must not be duplicated. ';
msgs['MNR00229'] = 'It is in the process of invoice issuance. You can not delete or change it!';
msgs['MNR00230'] = 'You are now issuing the invoice. Are you sure to search it ?';
msgs['MNR00231'] = '{?msg1} must be lower than {?msg2}.';
msgs['MNR00232'] = 'The changed data is found. Are you sure to proceed ?';
msgs['MNR00233'] = 'Issue Date must be equal or smaller than today.';
msgs['MNR00234'] = 'Issue Date must be equal or smaller than Received Date.';
msgs['MNR00235'] = 'Received Date must be equal or smaller than today.';
msgs['MNR00236'] = 'The saved data is remained. Please re-check the data.';
msgs['MNR00237'] = 'Repair Creation Date must be equal or smaller than today.';
msgs['MNR00238'] = 'There is no the saved data. Pls try again after saving.';
msgs['MNR00239'] = 'Please select at least one.';
msgs['MNR00240'] = 'You can find the detail of the estimate only.';
msgs['MNR00241'] = 'Effective Date of the Agreement is expired.';
msgs['MNR00242'] = 'Do you want to create the Estimate as well as approval ? If yes, The Estimate will be directly moved to Work Order step.';
msgs['MNR00243'] = 'Please search the data to print first.';
msgs['MNR00244'] = 'Are you sure to cancel?';
msgs['MNR00245'] = 'Price must be higher than Zero.';
msgs['MNR00246'] = 'Please select more than one.';
msgs['MNR00247'] = 'Please input more than one.';
msgs['MNR00248'] = 'Please search it first.';
msgs['MNR00249'] = 'EQ Detail Information will be initialized. Do you still want to change it?';
msgs['MNR00250'] = 'Please search Disposal to approve.';
msgs['MNR00251'] = 'Please search Disposal to reject.';
msgs['MNR00252'] = 'Are you sure to reject?';
msgs['MNR00253'] = 'Are you sure to approve?';
msgs['MNR00254'] = '{?msg2} does not exist in {?msg1}. Pls try again.';
msgs['MNR00255'] = 'Confirm QTY exceeds the fixed number of EQ disposal.';
msgs['MNR00256'] = 'Confirm QTY exceeds the bidding number of Buyer.';
msgs['MNR00257'] = 'Confirm QTY will be initialized after changing the fixed number of EQ Disposal.';
msgs['MNR00258'] = 'This EQ has the Repair Record by the same Service Provider inside 3 Months.';
msgs['MNR00259'] = 'This EQ has the Repair Record by the same Componenet Code inside 6 Months.';
msgs['MNR00260'] = 'Please search Total Loss to delete first.';
msgs['MNR00261'] = 'Please search Total Loss to save first.';
msgs['MNR00262'] = 'EQ No. is unmatched with ERP-FA.';
msgs['MNR00263'] = 'Please select Total Loss Detail Data to add in collection.';
msgs['MNR00264'] = 'You have to input at least one information amoung Input Date, EQ No, or Work Order No, or EST No.';
msgs['MNR00265'] = 'All EQ No Columns have values.';
msgs['MNR00266'] = 'Selected EQ number exceeds the number of EQ to input. ';
msgs['MNR00267'] = '[Buyer] was rejected successfully.';
msgs['MNR00268'] = 'Failed to reject buyer.';
msgs['MNR00269'] = '[Buyer] was expired successfully.';
msgs['MNR00270'] = 'Failed to expire buyer.';
msgs['MNR00271'] = 'Please select Service Provider First.';
msgs['MNR00272'] = 'Cost CTRL office is already included. Please check again.';
msgs['MNR00273'] = 'Disposal Tariff was deleted successfully.';
msgs['MNR00274'] = 'Please input one sale type between Unit Sale and Bulk Sale.';
msgs['MNR00275'] = 'Do you want to {?msg2} this {?msg1} ?'
msgs['MNR00276'] = 'Participation Information will be initialized. Are you sure to change it?';
msgs['MNR00277'] = 'Confirming QTY is not matched with Bidding QTY. Are you sure to confirm it ?';
msgs['MNR00278'] = 'Do you want to save(or request) this Tariff? Before save(or request), Please re-check Currency and Eff.from.';
msgs['MNR00279'] = 'Currency and Eff.From exactly did you enter?';
msgs['MNR00280'] = 'Invoice Total Amount Invaild Error! \nInvoice Total = SML Amount + V.A.Tax - W.H.Tax\n ';
msgs['MNR00281'] = 'Please carry out Verify first.';
msgs['MNR00282'] = 'Please select Row to copy.';
msgs['MNR00284'] = 'Please remove Hanger Flag first.';
msgs['MNR00285'] = 'Scrapping and Donation are available for Own EQ only.';
msgs['MNR00286'] = 'Please save it first.';
msgs['MNR00287'] = '{?msg1} does not exist';
msgs['MNR00288'] = 'Excel, please input the portion of the yellow cells.';
msgs['MNR00289'] = 'Pls carry out Confirmation/Deletion first.';
msgs['MNR00290'] = 'Please search the data to confirm first.';
msgs['MNR00291'] = 'This Total Loss was rejected successfully';
msgs['MNR00292'] = 'This Total Loss was confirmed successfully';
msgs['MNR00293'] = 'Row QTY of Disposal Detail List must be lower than Total QTY of Disposal List.';
msgs['MNR00294'] = 'EQ No for {?msg1} does not exist';
msgs['MNR00295'] = 'Repair Date does not exsit in W/O. Please check and input the Repair Date.';
msgs['MNR00297'] = 'Current Disposal Candidate Information will be initialized. Do you still want to change it?';
msgs['MNR00298'] = 'This disposal was already confirmed.';
msgs['MNR00299'] = 'Do you want to cancel ?';
msgs['MNR00300'] = 'M&R Invoice was canceled successfully.';
msgs['MNR00301'] = 'Verify the presence of Data is not successful.';
msgs['MNR00302'] = '{?msg1} is Already Diposal Processed';
msgs['MNR00303'] = 'You can not confirm Re-bidding while disposal selling.';
msgs['MNR00304'] = 'Hanger Rack Code {?msg1} is unmatched. Please check again.';
msgs['MNR00305'] = 'This EQ of Disposal is not available because of "XX" movement status.';
msgs['MNR00306'] = 'Data completed successfully.';
msgs['MNR00307'] = '[This estimate] was approvaled successfully.';
msgs['MNR00309'] = 'Please select Row.';
msgs['MNR00310'] = 'Please select Row to print. ';
msgs['MNR00311'] = 'Already Total Loss Processed';
msgs['MNR00312'] = 'You have no authority to {?msg1}.';
msgs['MNR00313'] = 'Data was confirmed successfully.';
msgs['MNR00314'] = 'Data was rejected successfully.';
msgs['MNR00315'] = 'Data was approved successfully.';
msgs['MNR00316'] = 'The lookup service providers will need to enter a period of views.';
msgs['MNR00317'] = 'In case of bulk sale for bidding, Plealse input one EQ TP/SZ';
msgs['MNR00318'] = 'Not Found EQ Information';
msgs['MNR00319'] = 'Collection Info is available in case of  ERP Interfaced status only.';
msgs['MNR00320'] = 'Disposal related to this partner does exists.';
msgs['MNR00321'] = 'Disposal Release Order was sent successfully.';
msgs['MNR00322'] = 'You can not Re-bidding contract disposal ';
msgs['MNR00323'] = 'already invoice processing can\'t take cancel or delete';
msgs['MNR00324'] = 'Result Info does not exists ';
msgs['MNR00325'] = '{?msg1} exceeds maximum duration {?msg2}.';
msgs['MNR00326'] = 'Flag Date must be equal or bigger than Event Date.';
msgs['MNR00327'] = 'There are changed some data except material cost.  Please do input material cost.';
msgs['MNR00328'] = 'Do you want to convert {?msg1} into {?msg2} ?';
msgs['MNR00329'] = 'Third Party Amount must be greater than 0(Zero).';
msgs['MNR00330'] = ' Do you want to {?msg1} ?';
msgs['MNR00331'] = 'Cannot select Permanent Hanger Rack_Single';
msgs['MNR00332'] = 'lease input 7 digit sequence in case of P/Up Yard.';
msgs['MNR00333'] = 'Please click calculation button now, and then change the data.';
msgs['MNR00334'] = 'Data was calculated successfully.';
msgs['MNR00335'] = 'input date can not be more than 30 days.';
msgs['MNR00336'] = 'Please input Total Loss History.';
msgs['MNR00337'] = 'Please click verify button now.';
msgs['MNR00338'] = 'You can\'t retrieve previous data';
msgs['MNR00339'] = 'Please input EQ in D.V Expense';
msgs['MNR00340'] = 'M&R estimated settlement began. This work may take a few minutes depending on the Execute Month.';
msgs['MNR00341'] = 'Complete need to enter all EQ close type.';
msgs['MNR00342'] = 'Can\'t Delete this Agreement due to following used  Estimate list \n\n{?msg1}';
msgs['MNR00343'] = 'Can\'t Version Up this Agreement due to following not Approved  Estimate list \n\n{?msg1}';
msgs['MNR00344'] = 'BackEndJob Request Fail!';
msgs['MNR00345'] = 'It was already created. Please check it again.';
msgs['MNR00346'] = 'The start date should be less than the end date !';
msgs['MNR00347'] = 'The end date should be greater than start date !';
msgs['MNR00348'] = 'Please Check Insert Row [Control Office & Buyer Contact Info]';
msgs['MNR00349'] = 'Bids must be in units of 25 ';
msgs['MNR00350'] = 'Bid can not be over 3 times';
msgs['MNR00351'] = 'Hangr Bar Offer Qty can\'t exceed Perchasing Qty';
msgs['MNR00352'] = 'Hangr Bar Offer Qty must be equal Perchasing Qty';
msgs['MNR00353'] = 'Please input Hanger Offer Info';
msgs['MNR00354'] = '{?msg1} Hanger bar was already Installed,Please remove first';
msgs['MNR00355'] = '{?msg1} Hanger bar was already Removed,Please install first';
msgs['MNR00356'] = 'Installation Bar Qty not equals Sound + Repairable + Missing + Disposal';
msgs['MNR00357'] = 'MEXBA office Estimate could not be created anymore ';
msgs['MNR00358'] = 'From 08:00 until 19:00 Bid possible.';
msgs['MNR00359'] = 'Please input install bar Qty';
msgs['MNR00360'] = 'Please input EQ No or Location and TP/SZ';
msgs['MNR00361'] = 'Sold Status already exist!';
msgs['MNR00362'] = '{?msg1} {?msg2} creation already Exist';
msgs['MNR00363'] = 'Nothing selected';
msgs['MNR00364'] = 'Bidding time over!';
msgs['MNR00365'] = 'W/O can not choice over 1000';
msgs['MNR00366'] = 'Less than 1000 data will be uploaded';
msgs['MNR00367'] = 'Confirm Processing is not available, Please check Bidding End Date.';
msgs['MNR00368'] = 'Do you want to change "invoice no" ?';
msgs['MNR00369'] = 'There is no data to change';
msgs['MNR00370'] = 'Already Invoice Confirmed.';
msgs['MNR00371'] = 'Already Invoice Canceled.';
msgs['MNR00372'] = '1000 row can be selected under!';
msgs['MNR00373'] = 'EQ Type is wrong. Please check again.';
msgs['MNR00374'] = 'Data was calculated.\n\n (Success: {?msg1} / Fail: {?msg2})';
msgs['MNR00375'] = 'Please input INV No. first.';
msgs['MNR00376'] = 'Do you want to delete selected disposal no?';
msgs['MNR00377'] = 'There is no EQ to request write-off.';
msgs['MNR00378'] = 'There is no Write-off to delete';
msgs['MNR00379'] = 'You should define approval step first to request EQ Write-off';
msgs['MNR00380'] = 'Select EQ to save or request';
msgs['MNR00381'] = 'Approval Step does not exist(BB)';
msgs['MNR00382'] = 'Please Check Approval Step';
msgs['MNR00383'] = 'input date can not be more than 3 years';
msgs['MNR00384'] = 'My Offer must be higher than Starting Price.';
msgs['MNR00385'] = 'My Offer must be in units of 10';
msgs['MNR00386'] = 'Unexpected system error took place during FA processing. Please contact person in Charge in SELCON.';
msgs['MNR00387'] = 'Unexpected system error took place during AR Invoice processing. Data state will be changed as Default Save Status.  Please contact person in charge in SELCON.';
msgs['MNR00388'] = 'EQ already exists in {?msg1}. Please check again.';
msgs['MNR00389'] = 'EQ No "{?msg1}" has been already processed. Please check again.';
msgs['MNR00390'] = 'There is same Invoice No has been confirmed. Please contact person in Charge in SELCON.';
msgs['MNR00391'] = 'Please check total loss date, it must be equal or earlier than today.';
msgs['MNR00392'] = 'Please check total loss date, it must be within 100 days.';
msgs['MNR00393'] = '{?msg1} doesn\'t exist. Please contact person in Charge in SELCON.';
msgs['MNR00394'] = 'Email was sent successfully';
msgs['MNR00395'] = 'Now, it is just saved. If you want to request it, please click OK button!';
msgs['MNR00396'] = 'Please check {?msg1} date, it must be equal or earlier than today.';
msgs['MNR00397'] = 'Office is already existing in Approval Step.';
msgs['MNR00398'] = 'To add approval step, please contact MNR PIC in CyberLogitec.';
msgs['MNR00399'] = '{?msg1} row,  {?msg2}, PIC{?msg3} is Empty!';
msgs['MNR00400'] = '{?msg1} must be bigger than {?msg2}.';
msgs['MNR00401'] = '{?msg1} and {?msg2} must be equal.';
msgs['MNR00402'] = 'The estimate of repair for this EQ({?msg1}) was created by the same S/P less than 15 days ago. Are you sure to proceed?';
msgs['MNR00403'] = 'Please attach the file.';
msgs['MNR00404'] = 'At lease One Attachment must be attached. Please attach the replacement before delete it.';
msgs['MNR00405'] = 'The attachment was not uploaded properly.';
msgs['MNR00406'] = 'Please check the zip file.\n Zip file that has image files only can be attached.';
msgs['MNR00407'] = 'exceeds limit of 5485760';
msgs['MNR00408'] = 'unexpected end of part';
msgs['MNR00409'] = 'only DEFLATED entries can have EXT descriptor';
msgs['MNR00410'] = 'Uploading attachment(s) is not complete yet.';
msgs['MNR00411'] = '{?msg1} does not exist or it is not a total loss by Accident.';
msgs['MNR00412'] = 'Please choose one or more Inspector Type.';
msgs['MNR00413'] = 'Failed to save. (S/Provider, Yard or Inspection Date is changed.) ';
msgs['MNR00414'] = 'This Equipment already has a Disposal No.';
msgs['MNR00415'] = 'Please Check Disposal No Again';
msgs['MNR00416'] = 'This Equipment has been sold.';
msgs['MNR00417'] = 'Below sold Equipment(s) can not be requested. {?msg1}';
msgs['MNR00418'] = 'Please use [Total Loss Request By Accident]\nto choose Main Reason: TT Club Case.';
msgs['MNR00419'] = 'P/Up Yard & Current CY are different';
msgs['MNR00420'] = 'Candidate EAC, Please remark';
msgs['MNR00421'] = 'This Service Accounting Code is not valid code. Please check it again.';
msgs['MNR00422'] = 'Enter the reason why the verify result value appears as error';

//*************** MNR MESSAGE END ******************//

//*************** MNR CONSTANT START ***************//
//MNR COMMON PROPERT
//선택시 배경색 R 하늘색
var SelectBackColorR = '240';
//선택시 배경색 G 하늘색
var SelectBackColorG = '255';
//선택시 배경색 B 하늘색
var SelectBackColorB = '255';

//IBSheet 디폴트 배경색 R (수정불가모드) 진한 남청색
var SheetNoEditBackColorR = '239';
//IBSheet 디폴트 배경색 G (수정불가모드) 진한 남청색
var SheetNoEditBackColorG = '235';
//IBSheet 디폴트 배경색 B (수정불가모드) 진한 남청색
var SheetNoEditBackColorB = '239';

//IBSheet 디폴트 배경색 R (수정가능모드) 하얀색
var SheetEditBackColorR = '255';
//IBSheet 디폴트 배경색 G (수정가능모드) 하얀색
var SheetEditBackColorG = '255';
//IBSheet 디폴트 배경색 B (수정가능모드) 하얀색
var SheetEditBackColorB = '255';

//IBSheet 에러컬럼  옇은 분홍색
var ErrorColBackColorR  = '247';
//IBSheet 에러컬럼  옇은 분홍색
var ErrorColBackColorG  = '229';
//IBSheet 에러컬럼  옇은 분홍색
var ErrorColBackColorB  = '255';

//IBSheet 신규 추가 컬럼 색상 연노란색
var InsRowBackRolorR = '251';
var InsRowBackRolorG = '251';
var InsRowBackRolorB = '187';

var coMnrFlgHangerTypeCd = 'HGR';
var coMnrFlgDamageTypeCd = 'DMG';

//*************** MNR CONSTANT END    ***************//

//*************** MNR FUNCUTION START ***************//
//MNR COMMON FUNCUTION
/**
 * ComXml2ComboString 를 수정
 * </pre>
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {string} codeCol 필수, Combo의 Code컬럼명.
 * @param {string} textCol 필수, Combo의 Text컬럼명.
 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
 * @see 	#ComXml2ComboString
 * @author 박명신
 * @version 2009.05.13
 */
function MnrXml2ComboString(xmlStr, codeCol, textCol) {
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}

		var colListIdx = Array();
		for ( var i = 0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0] = i;
			}
			if (colArr[i] == textCol) {
				colListIdx[1] = i;
			}
		}

		var retStr = "";

		for ( var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

			retStr = arrData[colListIdx[0]] + '|'  + arrData[colListIdx[1]];
			rtnArr.push(retStr);
		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}

/**
 * xml중 특정항목 데이타만 1차원 배열로 리턴
 * </pre>
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {string} codeCol 필수, 배열로만들 컬럼명.
 */
function MnrXmlToOneDimArray(xmlStr, codeCol) {
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return;
	}
	if (codeCol == null || codeCol == "") {
		return;
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}

		var colListIdx = 0;
		for ( var i = 0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx = i;
			}
		}

		var retStr = "";

		for ( var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

			retStr = arrData[colListIdx];
			rtnArr.push(retStr);
		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}

/**
 * 조회결과 xml을 입력받아 Array 로 반환
 * js sample)
 * var sXml = sheetObj.GetSearchXml("EES_MNR_0213GS.do","",FormQueryString(formObj),true);
 * var arrResult = MnrXmlToArray(sXml);
 *
 * if(arrResult != null){
 * 	formObj.fm_warr_dt.value = "Fm " +  arrResult[0][5];
 * 	formObj.to_warr_dt.value = "To " +  arrResult[0][0];
 * 	formObj.eq_mkr_nm.value = arrResult[0][2];
 * 	formObj.eq_mdl_nm.value = arrResult[0][4];
 * 	formObj.warr_rmk.value = arrResult[0][3];
 * }
 * </pre>
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
 * @see 	#ComXml2ComboString
 * @author 박명신
 * @version 2009.06.01
 */
function MnrXmlToArray(xmlStr) {
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return;
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}

		var retStr = "";

		for ( var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
			rtnArr.push(arrData);
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}

/**
 * 조회결과 xml을 입력받아 Array 로 반환
 * js sample)
 * var sXml = sheetObj.GetSearchXml("EES_MNR_0213GS.do","",FormQueryString(formObj),true);
 * var arrResult = MnrXmlToArray(sXml);
 *
 * if(arrResult != null){
 * 	formObj.fm_warr_dt.value = "Fm " +  arrResult[0][5];
 * 	formObj.to_warr_dt.value = "To " +  arrResult[0][0];
 * 	formObj.eq_mkr_nm.value = arrResult[0][2];
 * 	formObj.eq_mdl_nm.value = arrResult[0][4];
 * 	formObj.warr_rmk.value = arrResult[0][3];
 * }
 * </pre>
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @return array   해당 Row의 List로 반환
 * @author 노영현
 * @version 2014.12.10
 */
function MnrXmlToArray2(xmlStr) {
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return;
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}

		var retStr = "";
		for ( var i = 0; i < dataChildNodes.length; i++) {
			
			
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var rowObj = new Object();
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
			for( var j = 0; j < colArr.length; j++){
				rowObj[colArr[j]] = arrData[j];
			}
			rtnArr.push(rowObj);
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}
/**
 * MNR 공통 코드 콤보 조회 함수 - 멀티지원
 * 여러개의 IB콤보를 사용시 콤보들에 들어갈 콤보 스트링을 가져온다.
 * 주의사항
 * 1.데이타가 코드 코드디스크립션인 패턴의 경우에만 사용
 * 2.인자값을 정확하게 기술하여야 한다.
 *
 * ************ 변경 콤보 sCondition ******************
 * 1. MNR_GEN_CD
 * 1.1 조회조건 : PRNT_CD_ID
 * new Array("MnrGenCd","CD00001", "COMMON")
 * 1.2 조회조건 : MNR_CD_GRP_NO
 * new Array("MnrGenCd","1", "CUSTOM1")
 * 1.3 조회조건 : PRNT_CD_ID||EQ_KND_CD
 * new Array("MnrGenCd","CCZ", "CUSTOM2")
 * 1.4 조회조건 UGRC
 * new Array("MnrGenCd",eq_type + "G" + display_type, "CUSTOM3")
 * 1.5 조회조건 EQ_KND_CD <-(기존 MnrEqKindCdCombo)
 * new Array("MnrGenCd","","CUSTOM9")
 * 1.6 조회조건 : sorting
 * 2010-02-11 서미진 ; CD_ID로 Description을, CD_DESC로 DpDesc를 가져온다. (EES_MNR_0023참고)
 * new Array("MnrGenCd","CD#####","CUSTOM10")
 *
 * 2. MDM_CURRENCY(searchMdmCurrencyData)mnr_flg_inp_tp_cd
 * new Array("MdmCurrency","","COMMON")
 * 3. MDM_VENDOR(searchMdmVendorData)
 * new Array("MdmVendor","11","COMMON")
 * 4. MDM_CNTR_TP_SZ(searchEqTpSzData)
 * new Array("EqTpSz","U","COMMON")
 * 5. COM_USER(searchComUserData)
 * new Array("ComUser","MNR_SELOPB","COMMON")
 * 6. MNR_EQ_CMPO_CD(searchMnrEqCmpoCdData)
 * new Array("MnrEqCmpoCd","3","COMMON")                       => 그룹타입에 따라 전부다
 * new Array("MnrEqCmpoCdByEqType","3",formObj.eq_knd_cd.Code) => EQ_type Flag 체크된 것만
 * 7. MNR_CEDEX_OTH_CD(searchMnrCedexOthCdData)
 * new Array("MnrCedexOthCd","RPR","COMMON")
 * 8. MNR_EQ_LOC_CD(searchMnrEqLocCdData)
 * new Array("MnrEqLocCd","1","COMMON")
 * 9. MNR_FLD_QLTY_AUD_RSLT(searchMnrFldQltyAudRsltData)
 * new Array("MnrFldQltyAudRslt","CHISC000003","COMMON")
 * 10. MNR_AGMT_HDR(searchMnrAgmtHdrData)
 * new Array("MnrAgmtHdr","CHI000003",office_code)
 * 11. MNR_OFC_GEN_INFO(searchOfcComboCodeListData)
 * new Array("MnrOfcGenInfo","OFC_CODE","AGMT")      <-- Agreement(MnrAGMTOfficeCombo) OFC_CODE "" 		넣을시   account로 넣어줌
 * new Array("MnrOfcGenInfo","RHQ_OFC_CODE","DISP")  <-- Disposal(MnrDISPOfficeCombo)  RHQ_OFC_CODE "" 	넣을시 	account로 넣어줌
 * 12. MNR_CD_RLT(searchMnrDivisionCodeData)
 * new Array("MnrDivCd",'Component + Rpr code',"COMMON")
 * new Array("MnrDivCd",'Component + Rpr code' + ',' +  'cost_cd의 앞3자리',"COMMON1")
 * new Array("MnrRprCd",'Component code',"COMMON")  => Component 코드로 Repair 코드 가져오기
 * 13. MDM_ORGANIZATION
 * 1) RHQ_OFC 조회해옴
 * new Array("MdmOrganization","RHQ","TRUE")		HQ_OFC(SELOPB) 포함 		      기존 -> MnrOfficeComboInit(RHQ,true)
 * new Array("MdmOrganization","RHQ","FALSE") 	    HQ_OFC(SELOPB) 포함하지 않음   기존 -> MnrOfficeComboInit(RHQ,false)
 * new Array("MdmOrganization","RHQ","ALLFALSE")    SELOPB,SELHO   포함하지 않음
 * new Array("MdmOrganization","RHQ","TRUESELHOFALSE") HQ_OFC(SELOPB) 포함하나 SELHO   포함하지 않음
 * 2) [rhq_ofc_cd] 밑에 오피스 코드 조회해옴
 * new Array("MdmOrganization","SEARCH",[rhq_ofc_cd])      기존 -> (EES_MNR_0212GS.do -> SEARCH)
 * 3) RPR Invoce OFC  조회해옴
 * new Array("MdmOrganization","RPRINV",[ofc_cd])
 * 4) RHQ Office Change 조회해옴
 * new Array("MdmOrganization","RHQCHG","")
 * 5) RHQ Office 로 conuntry 조회해옴
 * new Array("MdmOrganization","COUNTRY",[rhq_ofc_cd])
 * 6) conuntry 로 OFC 조회해옴
 * new Array("MdmOrganization","OFCBYCOUNTRY",[country] + ',' + [rhq_ofc_cd])
 * 14. MDM_VENDOR(searchPrntVndrSeqData)
 * new Array("PrntVndrSeq","11","COMMON")


 ****************************************************
 * PARAM VALUE :  Array[][] sCondition
 * 샘플 및 설명 (조회의 콤보의 갯수만큼)
 * var sCondition = new Array (
 * 		new Array("MnrGenCd","CD00001", "COMMON")
 * )
 * MnrGenCd    ==> 서버에서 조회할 테이블의 테이블명(카멜표기법)
 * CD00001     ==> 서버에서 조회할 테이블의 키값의 값 위에 'CD00001' 에 매칭되는값
 * COMMON      ==> 사용자정의 예약어
 *
 * RETURN VALUE
 * IBMuliCobo용  코드|코드디스크립션의 배열의 배열을 리턴한다.
 *
 *  JS USE SAMPLE
 *  CASE1 All 아이템 사용 않할때
 *  var comboList = MnrComSearchCombo(sheetObj,sCondition);
 *  for(var i = 0; i < comboList.length;i++){
 *		comboObjects[i].RemoveAll();
 *
 *		if(comboList[i] != null){
 *			for(var j = 0; j < comboList[i].length;j++){
 *				comboObjects[i].InsertItem(j, comboList[i][j] ,j + '');
 *			}
 *		}
 *		comboObjects[i].Code = 0;
 *	}
 * CASE2 All 아이템 사용 할때
 * for(var i = 0; i < comboList.length;i++){
 *		comboObjects[i].RemoveAll();
 *		comboObjects[i].InsertItem(0, 'All | All retrieve' ,'0');
 *
 *		if(comboList[i] != null){
 *			for(var j = 0; j < comboList[i].length;j++){
 *				comboObjects[i].InsertItem(j + 1, comboList[i][j] ,j + 1 + '');
 *			}
 *		}
 *		comboObjects[i].Code = 0;
 * }
 *
 * CASE3 시트내의 여러개의 콤보적용시
 *
 *	var sCondition = new Array (
 *	 	new Array("MnrGenCd","CD00001", "COMMON"),
 *	 	new Array("MnrGenCd","CD00002", "COMMON")
 *	)
 *  var comboList = MnrComSearchCombo(sheetObj,sCondition);
 *
 *  var sheetComboText = "";
 *	var sheetComboCode = "";
 *	var sheetComboDefault = "";
 *
 *	var comboSaveNames = new Array();
 *	comboSaveNames[0] = "eq_cmpo_cd";
 *	comboSaveNames[1] = "eq_rpr_cd";
 *
 *	for(var i = 0; i < comboList.length;i++){
 *	 	if(comboList[i] != null){
 *
 *			sheetComboText = "";
 *			sheetComboCode = "";
 *			sheetComboDefault = "";
 *
 *	 		for(var j = 0; j < comboList[i].length;j++){
 *				var tempText = comboList[i][j].split("|");
 *
 *				sheetComboText +=  tempText[1] + "|";
 *				sheetComboCode +=  tempText[0] + "|";
 *				if(j ==0){
 *					sheetComboDefault = tempText[0];
 *				}
 *			}
 *			//탭별 쉬트 콤보 설정
 *			for(var k=0; k<sheetObjects.length-1; k++) {
 *				sheetObjects[k].InitDataCombo (0, comboSaveNames[i], sheetComboCode, sheetComboCode ,sheetComboDefault);
 *			}
 *		}
 *	 }
 *
 * @param	{Array[][]}	sCondition 서버에서 조회할 조회조건과 값의 배열
 * @return  {Array[][]} 코드|코드디스크립션의 배열의 배열을 리턴한다.
 */
function MnrComSearchCombo(sheetObj,sCondition){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH + '&';

	for (var i = 0;i < sCondition.length; i++){
		f_query += 'ibflag=X&';
		f_query += 'del_chk=0&';
		f_query += 'searchinfo' + '=' + sCondition[i][0] + '&';
		f_query += 'searchkey' + '=' + sCondition[i][1] + '&';
		f_query += 'searchcon' + '=' + sCondition[i][2] + '&';
	}
	//마지막에 &를 없애기 위함
	f_query = MnrDelLastDelim(f_query);

	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	var arrXml = sXml.split("|$$|");

	var retValue = new Array();
	for(var i = 0; i < arrXml.length; i++){
		retValue[i] =  MnrXml2ComboString(arrXml[i], "cd_id", "cd_desc");
	}

	return	retValue;
}

function MnrComCdSearch(sheetObj,sCondition){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH + '&';

	for (var i = 0;i < sCondition.length; i++){
		f_query += 'ibflag=X&';
		f_query += 'del_chk=0&';
		f_query += 'searchinfo' + '=' + sCondition[i][0] + '&';
		f_query += 'searchkey' + '=' + sCondition[i][1] + '&';
		f_query += 'searchcon' + '=' + sCondition[i][2] + '&';
	}
	//마지막에 &를 없애기 위함
	f_query = MnrDelLastDelim(f_query);

	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	var arrXml = sXml.split("|$$|");
	return	MnrXmlToArray(arrXml);
//	var retValue = new Array();
//	var sColSep = "☜☞";
//	for(var i = 0; i < arrXml.length; i++){
//		 
//		retValue[i].pair_cd_desc = arrXml[i];
//	}
//
//	return	retValue;
}

/**
 * MNR 공통 코드 체크 로직
 * 한건에 대한 벨리데이션 체크용
 * 1] checkType 은  밑에 세가지중 택일 (개발자 추가 개발시 작성요망)
 * 1.OFC  (오피스 코드)
 * 2.EQN  (EQ NUMBER)
 * 3.DSPEQN (Disposal + EQ NUMBER)
 * 4.YARD (YARD)
 * 4.5 SLDYARD
 * 5.LOC  (CONTAINER LOCATION CODE)
 * 6.MLOC (MDM LOCATION)
 * 7.COMP (COMPONENT CODE)
 * 8.WORKORD (Work Order)
 * 9.CNT (COUNTRY CODE)
 * 2] checkValue 검색해볼 타입의 데이타 값
 * ************************************************************
 * checkType OFC 일 경우
 * CASE1 OFC만 체크할경우 checkValue에 오피스코드만 입력
 * retArray = MnrGeneralCodeCheck(sheetObj,"OFC","SZPSC");
 *
 * CASE2 OFC와 헤드쿼터를 체크할경우 checkValue에 오피스코드,헤드쿼터오피스
 * "오피스코드,헤드쿼터오피스" 이렇게 넣는다.
 * retArray = MnrGeneralCodeCheck(sheetObj,"OFC","SZPSC,SELHO");
 * *************************************************************
 * checkType EQN 일 경우
 * CASE1 Eqtype 무시하고 체크
 * MnrGeneralCodeCheck(sheetObj,"EQN","GESU8050851");
 *
 * CASE2 Eqtype 같이 체크
 * MnrGeneralCodeCheck(sheetObj,"EQN","GESU8050851,U");
 *
 * checkType ESTEQN 일 경우
 * EQN과 동일 ACIAC_DIV_CD 조건을 제거
 * *************************************************************
 * checkType DSPEQN
 * CASE1
 * MnrGeneralCodeCheck(sheetObj,"DSPEQN","GESU8050851,U,disp_no");
 * disp_no가 없을 경우 NEW를 입력
 * CASE2 EqTypeSize 같이 체크
 * MnrGeneralCodeCheck(sheetObj,"DSPEQN","GESU8050851,U,disp_no,D2");
 *
 *************************************************************
 * checkType WORKORD  워크오더 디테일 테이블에 실제로 존재하는지 확인
 * MnrGeneralCodeCheck(sheetObj,"WORKORD","mnr_ord_ofc_cty_cd,mnr_ord_seq");
 * **************************************************************
 *  js sample
 *  retArray = MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
 *	if(retArray == null){
 *		ComShowCodeMessage("MNR00165",checkYard,"YARD");
 *		sheetObj.CellValue2(Row ,Col) = "";
 *		sheetObj.SelectCell(Row ,Col);
 *	} else {
 *		return;
 *	}
 *
 * @param	{String}	sCondition 서버에서 조회할 조회조건과 값의 배열
 * @param	{String}	sCondition 서버에서 조회할 조회조건과 값의 배열
 * @return  {Array[]}   조회결과의 cd_id|cd_desc 리턴값 (값이 있다면 한개만 조회)
 */
function MnrGeneralCodeCheck(sheetObj,checkType,checkValue){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + COMMAND01 + '&';

	f_query += 'ibflag=X&';
	f_query += 'del_chk=0&';
	f_query += 'check_type' + '=' + checkType + '&';
	f_query += 'check_value' + '=' + checkValue;

	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	var retValue = MnrXml2ComboString(sXml, "cd_id", "cd_desc");
	return	retValue;
}

/**
 * Service Provider Detail Information 를 가져온다.
 * 1) vndr_seq 없을시 해당 리스트를 다가져옴
 *
 * 2) vndr_seq 입력시  MNR_PARTER 테이블을 조회해서 ETC 데이타로 가져온다.
 * sample)
 * var sXml = MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");
 *
 * if(ComGetEtcData(sXml, "vndr_seq") != null){
 * 	//Vender nm 세팅
 * 	ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
 * 	//Curr 세팅
 * 	comboObjects[1].Code  = ComGetEtcData(sXml, "pay_curr_cd");
 * 	//PAY TERM 세팅
 * 	var tempPayTerm = ComGetEtcData(sXml, "gen_pay_term_cd");
 *
 * 	if(tempPayTerm != null){
 * 		if("O60" == tempPayTerm || "O45" == tempPayTerm){
 * 			ComSetObjValue(formObj.pay_term_dys,"0");
 * 		} else if ("IN" == tempPayTerm){
 * 			ComSetObjValue(formObj.pay_term_dys,"5");
 * 		} else if ("OUT" == tempPayTerm){
 * 			ComSetObjValue(formObj.pay_term_dys,"60");
 * 		} else {
 * 			ComSetObjValue(formObj.pay_term_dys,tempPayTerm);
 * 		}
 * 	}
 * } else {
 * 	ComShowCodeMessage("MNR00005", "Service Provider");
 * 	ComSetObjValue(formObj.vndr_nm, "");
 * 	ComSetObjValue(formObj.vndr_seq, "");
 * 	ComSetFocus(formObj.vndr_seq);
 * }
 *
 * if(ComGetEtcData(sXml, "mnr_prnr_seq") != null){
 * 	//Parnter 세팅
 * 	ComSetObjValue(formObj.edi_id, ComGetEtcData(sXml, "edi_id"));
 * 	ComSetObjValue(formObj.sp_ptal_id, ComGetEtcData(sXml, "sp_ptal_id"));
 * 	ComSetObjValue(formObj.phn_no, ComGetEtcData(sXml, "phn_no"));
 * 	ComSetObjValue(formObj.fax_no, ComGetEtcData(sXml, "fax_no"));
 * 	ComSetObjValue(formObj.mnr_prnr_eml, ComGetEtcData(sXml, "mnr_prnr_eml"));
 * 	comboObjects[4].Code  = ComGetEtcData(sXml, "trsm_mod_cd");
 * 	formObj.mnr_prnr_rmk.value =  ComGetEtcData(sXml, "mnr_prnr_rmk");
 * }
 *
 * @param	{IBSheet}	sheetObj 	IBSheet
 * @param	{String}	vendSeq 	mnr_prnr_seq
 * @param   {String}   	grpTpCd     mnr_grp_tp_cd
 * @return  {Xml}   	sXml
 */
function MnrGetPartner(sheetObj,vendSeq,grpTpCd){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH06 + '&';
	f_query += 'mnr_prnr_seq=' + vendSeq + '&';
	f_query += 'mnr_grp_tp_cd=' + grpTpCd;

	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	return  sXml;
}

/**
 * MNR_PARTNER 에서 매각 바이어의 OFC_CD를 가져온다
 * SPP S304,S301 에서 사용하기 위한 함수
 *
 * @param	{IBSheet}	sheetObj 	IBSheet
 * @param	{String}	spPotalId 	SPP 유저 아이디
 * @return  {Xml}   	sXml
 */
function MnrGetSPPPartnerOFC(sheetObj,spPotalId){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH18 + '&';
	f_query += 'sp_ptal_id=' + spPotalId;

	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	return  ComGetEtcData(sXml,"SPPOFCCD");
}


/**
 * @param	{IBSheet}	sheetObj 	IBSheet
 * @param   {String}   	currCd     	커런시 코드
 * @param   {String}   	trfTpCd     타리프 타입 코드
 * @param   {String}   	eqTpszCd    TP/SZ
 * @param   {String}   	crntYdCd    YARD or LOCATION
 * @param   {String}   	requestDt   '2010-10-29'
 * @return  {String}   	price
 *
 * 요청한 currCd 로 경리환률로 변환하여 Disposal 타리프 가격을 가져온다.
 */
function MnrGetDISPEQUnitPrice(sheetObj,currCd,eqTpszCd,crntYdCd,requestDt){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH14 + '&';
	f_query += 'curr_cd=' + currCd + '&';
	f_query += 'eq_tpsz_cd=' + eqTpszCd + '&';
	f_query += 'crnt_yd_cd=' + crntYdCd + '&';
	f_query += 'request_dt=' + requestDt;

	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	return  ComGetEtcData(sXml,"price");
}

/**
 * MNR_AGMT_APLY_OFC 테이블에서 자기 자신의 로그인 오피스 코드를
 * 포함한 Agreement 정보 가져오기
 * @param	{String}	ofc_cd 자기 자신의 로그인 오피스 코드
 * @return  {Xml}       조회결과의 xml
 */
function MnrAGMTHdrCombo(sheetObj,ofc_cd){
	var f_query = '';
	//쿼리 스트링 조합시작

	f_query += 'f_cmd=' + SEARCH02;
	f_query += '&'+'ibflag=X';
	f_query += '&'+'del_chk=0';
	f_query += '&'+'ofc_cd=' + ofc_cd;

	var sXml = sheetObj.GetSearchXml("MNR_COM_CUSTOM2GS.do","" ,f_query,true);
	return	sXml;
}

/**
 * MNR_AGMT_APLY_OFC 테이블에서 자기 자신의 로그인 오피스 코드를
 * 포함한 Agreement 정보 가져오기 - Estimate 화면에서 사용
 * @param	{String}	ofc_cd 자기 자신의 로그인 오피스 코드
 * @return  {Xml}       조회결과의 xml
 */
function MnrEstAGMTHdrCombo(sheetObj,ofc_cd){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd=' + SEARCH02;
	f_query += '&'+'ibflag=X';
	f_query += '&'+'del_chk=0';
	f_query += '&'+'ofc_cd=' + ofc_cd;
	f_query += '&'+'tp_cd=EST';

	var sXml = sheetObj.GetSearchXml("MNR_COM_CUSTOM2GS.do","" ,f_query,true);
	return  sXml;
}

/**
 * 워런티 얼럿 조회용
 * @param	{String}	eq_number
 * @return  {Xml}       조회결과의 xml
 */
function MnrWarrantyAlertInfo(sheetObj,eq_no){
	var f_query = '';
	//쿼리 스트링 조합시작

	f_query += 'f_cmd' + '=' + SEARCH	+ '&';

	f_query += 'ibflag=X&';
	f_query += 'del_chk=0&';
	f_query += 'eq_no' + '=' + eq_no;

	var sXml = sheetObj.GetSearchXml("EES_MNR_0213GS.do","" ,f_query,true);
	return	sXml;
}

/**
 * 1. EQ_TYPE 별로 TP/SZ 을 가져온다.   sComCodeName:type_size_search_ind
 * 컨테이너/샤시/MGSET 의 순서로 가져온다.
 *
 * 2. FQA Result Description Code 을 가져온다
 *
 * MNR 공통 코드 그리드 조회 함수 - 멀티지원
 *     여러개의 IB시트를 사용시 시트들에 들어갈 시트 스트링을 가져온다.
 * @param	{String}	sComCodeName 서버에서 조회할 스트링 코드명
 * @param	{String}	sOrderByColNm 서버에서 조회할 정렬 유무
 * @return  {Xml[]}     arrXml 코드,코드디스크립션의 xml을 리턴한다.
 *
 * 사용예 :     var arrXml = MnrComSearchGrid(sheetObj,"type_size_search_ind");
 *
 *			   var retValue = new Array();
 *			   for(var i = 0; i < arrXml.length; i++){
 *			   		retValue[i] =  MnrXml2ComboString(arrXml[i], "cd_id", "cd_desc");
 *			   }
 * ********************************************************************************
 *  sComCodeName: "type_size_search_ind" - typeSize(타입사이즈 코드)
 *			      "com_code_search_ind"  - FQA Result Description Code
 *
 *                추가시 수정할 부분
 *                VO - GeneralCodeSearchINVO 에 해당코드와 필요변수 추가
 *                     costCodeSearchInd
 *                BC - searchCommonInitDataListBasic 에 해당코드 추가
 *                     else if(generalCodeSearchGRPVO.getGeneralCodeSearchINVO().getCostCodeSearchInd().equals("Y")) {
 *                         ....
 *                     }
 *                DAO - GeneralCodeSearchMgtDBDAO 에 해당 메소드 추가
 *                      searchCostCodeListData() {
 *                          ....
 *                      }
 *                SQL - 해당 쿼리 생성
 *                      GeneralCodeSearchMgtDAOsearchCostCodeListDataRSQL
*/
 function MnrComSearchGrid(sheetObj,sComCodeName,sOrderByColNm){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH01 + '&';
	f_query += sComCodeName + '=Y&';
	f_query += sOrderByColNm + '=Y';
	sheetObj.WaitImageVisible=false;
	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	sheetObj.WaitImageVisible=true;
	var arrXml = sXml.split("|$$|");
	return arrXml;
}

 /**
  * MnrComSearchGrid 에서 사용하는 함수에서 code_type 을 추가함.
  *
  *	1. disposal type size
  * MnrComSearchGrid2(sheetObjects[0], "DSPTypeSize");
  * 2. active type size
  * MnrComSearchGrid2(sheetObjects[0], "ACTTypeSize");
  *
  * MNR 공통 코드 그리드 조회 함수 - 멀티지원
  *     여러개의 IB시트를 사용시 시트들에 들어갈 시트 스트링을 가져온다.
  * @param	{String}	sComCodeName 서버에서 조회할 스트링 코드명
  * @param	{String}	sOrderByColNm 서버에서 조회할 정렬 유무
  * @return  {Xml[]}     arrXml 코드,코드디스크립션의 xml을 리턴한다.
  *
 */
  function MnrComSearchGrid2(sheetObj,sComCodeName,sOrderByColNm){
 	var f_query = '';
 	//쿼리 스트링 조합시작
 	f_query += 'f_cmd' + '=' + SEARCH01 + '&';
 	f_query += 'code_type' + '=' + sComCodeName + '&';
 	f_query += sOrderByColNm + '=Y';
 	sheetObj.WaitImageVisible=false;
 	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
 	sheetObj.WaitImageVisible=true;
 	var arrXml = sXml.split("|$$|");
 	return arrXml;
 }

/**
 * 멀티선택 팝업호출
 * @param	{window.event.srcElement.getAttribute("name")}	값을 넘겨 받을 input 명
 * @author 박명신
 * @version 2009.05.27
 * @see #ees_mnr_0122.js
 *
 * 1) 부모 js에서 getMnr_Multi 구현 샘플
 * function getMnr_Multi(rowArray,return_val) {
 *		var formObj = document.form;
 *		var tempText = "";
 *		//초기화
 *		eval("document.form." + return_val + ".value = '';");
 *		for(var i=0; i<rowArray.length; i++) {
 *			tempText +=  rowArray[i] + ',';
 *		}
 *		//마지막에 ,를 없애기 위함
 *		if (tempText != "")
 *	        tempText = tempText.substr(0, tempText.length -1);
 *
 *		eval("document.form." + return_val + ".value = '" + tempText + "';");
 *	}
 * 2) DAO에서 ,넘어온 값을 처리 샘플
 * List<String> tpszCds = new ArrayList();
 * String[] arrYdCd =  eQFlagListINVO.getEqTpszCd().split(",");
 * for(int i = 0; i < arrYdCd.length; i ++){
 * 	tpszCds.add(arrYdCd[i]);
 * }
 * velParam.put("tpszCds", tpszCds);
 *
 * 3) 쿼리문중 foreach 샘플
 *
 * #if (${tpszCds} != '')
 * 	AND	A.EQ_TPSZ_CD IN (
 * 		#foreach ($user_tpszCds IN ${tpszCds})
 * 			#if($velocityCount < $tpszCds.size())
 * 				'$user_tpszCds',
 * 			#else
 * 				'$user_tpszCds'
 * 			#end
 * 		#end
 * 	)
 * #end
 */

function rep_Multiful_inquiry(input_obj)
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getMnr_Multi";
		var xx1=input_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('EES_MNR_MULTI.do' + param, 400, 330, 'getMnr_Multi', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * 멀티  confirm
 * @author 박명신
 * @version 2009.09.04
 * @see #ees_mnr_0019.js
 *
 * returntitle <== 질문할거
 * btnNms <== 경우 케이스 버튼 (콤마로 구분) btnNms=approval,request,cancle
 * scrWidth <== 버튼의 갯수에 따라 넓이가 틀려지므로 알아서 입력
 * scrHieht <== 질문의 줄바꿈에 따라 달라짐 알아서 입력
 *
 * 필수) 밑에 함수 구현 (리턴값은 btnNms 에서 입력한 버튼의 순서대로 0,1,2,3,.... 식이다.
 * getMnr_Confirm(returnVal){
 *     if(returnVal == "0"){
 *
 *     } else if(returnVal == "1"){
 *
 *     }
 * }
*/

function req_Multiful_confirm(returntitle,btnNms,scrWidth,scrHieht){
	var param = "?returntitle=" + returntitle +
				"&btnNms=" + btnNms +
				"&scrWidth=" + scrWidth;

	var hieght = parseInt(scrHieht,10);
	ComOpenPopup('EES_MNR_CONFIRM.do' + param, 400, hieght, 'getMnr_Confirm', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * EQ General Info 그리드 조회 함수 - 멀티지원
 *     여러개의 IB시트를 사용시 시트들에 들어갈 시트 스트링을 가져온다.
 * @param	{String}	sEqType 		서버에서 조회할 스트링 EQ_TYPE(U:Container,Z:CHASSIS,G:GENSET)
 * @param	{String}	sEqNo 			서버에서 조회할 스트링 EQ_NO
 * @param	{String}	sTotalLossDate	서버에서 조회할 DV_VALUE를 구하는 인자로 사용된다.
 * @return  {Xml[]}     arrXml  		서버에서 조회된 xml을 리턴한다.
 *
 * 사용예 :      var eqType 			= "U";
 *				var eqNo   			= "SMCU7830661";
 *				var totalLossDate	= "2006-11-03";
 *
 * 				var arrXml = MnrComEqGenInfoSearch(sheetObj,eqType,eqNo,totalLossDate);
 *
 * 				for(var i = 0; i < arrXml.length; i++){
 *					sheetObjects[i].LoadSearchXml(arrXml[i]);
 *				}
*/
function MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH02 + '&';
	f_query += 'eq_type=' + sEqType +'&';
	f_query += 'eq_no=' + sEqNo +'&';
	f_query += 'total_loss_date=' + sTotalLossDate+'&';
	f_query += 'cost_type=' + sCostType;

	sheetObj.WaitImageVisible = false;
	var sXml = sheetObj.GetSearchXml("MNR_COM_CUSTOM1GS.do","" ,f_query,true);
	sheetObj.WaitImageVisible = true;
	return sXml;
}


/**
* Agreement Rate 그리드 조회 함수 - 멀티지원
* 여러개의 IB시트를 사용시 시트들에 들어갈 시트 스트링을 가져온다.
* @param	{String}	sAgmtOfcCtyCd 		서버에서 조회할 스트링 AGMT_OFC_CTY_CD(U:Container,Z:CHASSIS,G:GENSET)
* @param	{String}	sAgmtSeq 			서버에서 조회할 스트링 AGMT_SEQ
* @param	{String}	sAgmtVerNo	서버에서 조회할 스트링 AGMT_VER_NO
* @param	{String}	sCostCd	    서버에서 조회할 스트링 COST_CD
* @param	{String}	sCostDtlCd	서버에서 조회할 스트링 COST_DTL_CD
* @param	{String}	sMnrRtTpCd	서버에서 조회할 스트링 MNR_RT_TP_CD
* @return  {Xml[]}     arrXml  		서버에서 조회된 xml을 리턴한다.
*
* 사용예 :       var eqType 			= "U";
*				var eqNo   			= "SMCU7830661";
*				var totalLossDate	= "2006-11-03";
*
* 				var arrXml = MnrAgmtRateInfoSearch(sheetObj,sAgmtOfcCtyCd,sAgmtSeq,sAgmtVerNo,sCostCd,sCostDtlCd,sMnrRtTpCd);
*
* 				for(var i = 0; i < arrXml.length; i++){
*					sheetObjects[i].LoadSearchXml(arrXml[i]);
*				}
*/
function MnrAgmtRateInfoSearch(sheetObj,sAgmtOfcCtyCd,sAgmtSeq,sAgmtVerNo,sCostCd,sCostDtlCd,sMnrRtTpCd){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH09 + '&';
	f_query += 'agmt_ofc_cty_cd=' + sAgmtOfcCtyCd +'&';
	f_query += 'agmt_seq=' + sAgmtSeq +'&';
	f_query += 'agmt_ver_no=' + sAgmtVerNo +'&';
	f_query += 'cost_cd=' + sCostCd +'&';
	f_query += 'cost_dtl_cd=' + sCostDtlCd +'&';
	f_query += 'mnr_rt_tp_cd=' + sMnrRtTpCd;

	sheetObj.WaitImageVisible = false;
	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	sheetObj.WaitImageVisible = true;
	return sXml;
}

/**
* Vessel Info 그리드 조회 함수 - 멀티지원
*     여러개의 IB시트를 사용시 시트들에 들어갈 시트 스트링을 가져온다.
* @param	{String}	sVslCd 		서버에서 조회할 스트링 Vessel Code
* @return  {Xml[]}     arrXml  		서버에서 조회된 xml을 리턴한다.
*
* 사용예 :      var sVslCd 			= "CADM";
* 				var arrXml = MnrComVesselInfoSearch(sheetObj,sVslCd);
*
* 				for(var i = 0; i < arrXml.length; i++){
*					sheetObjects[i].LoadSearchXml(arrXml[i]);
*				}
*/
function MnrComVesselInfoSearch(sheetObj,sVslCd){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH12 + '&';
	f_query += 'vsl_cd=' + sVslCd ;

	sheetObj.WaitImageVisible = false;
	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	sheetObj.WaitImageVisible = true;
	return sXml;
}
/**
* Customer Info 그리드 조회 함수 - 멀티지원
*     여러개의 IB시트를 사용시 시트들에 들어갈 시트 스트링을 가져온다.
* @param	{String}	custCntCd 		서버에서 조회할 스트링 CUST_CNT_CD-고객고분코드
* @param	{String}	custSeq 			서버에서 조회할 스트링 CUST_SEQ-고객 시퀀스
* @return  {Xml[]}     arrXml  		서버에서 조회된 xml을 리턴한다.
*
* 사용예 :      var custCntCd 		= "AE";
*               var custSeq 			= "000001";
* 				var arrXml = MnrComCustomerInfoSearch(sheetObj,custCntCd,custSeq);
*
* 				for(var i = 0; i < arrXml.length; i++){
*					sheetObjects[i].LoadSearchXml(arrXml[i]);
*				}
*/
function MnrComCustomerInfoSearch(sheetObj,custCntCd,custSeq){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH15 + '&';
	f_query += 'cust_cnt_cd=' + custCntCd + '&' ;
	f_query += 'cust_seq=' + custSeq;
	sheetObj.WaitImageVisible = false;
	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	sheetObj.WaitImageVisible = true;
	return sXml;
}

/**
* Standard Tarrif에서  EqType별 default unit of Measure를 구한다.
* @param	{IBSheet}	sheetObj 		IBSheet
* @param	{String}	eqKndCd 		EQ_TYPE
* @return  	{String}    measure  		Default UnitOf Measure
*
* 사용예 : var arrXml = MnrDefaultUnitOfMeasure(sheetObj,eq_knd_cd);
*/
function MnrDefaultUnitOfMeasure(sheetObj,eqKndCd){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH04 + '&';
	f_query += 'eq_knd_cd=' + eqKndCd;
	sheetObj.WaitImageVisible = false;
	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	sheetObj.WaitImageVisible = true;

	var measure = MnrNullToBlank(ComGetEtcData(sXml, "Measure"));
	return measure;
}

/**
 * Hidden된 RowCount를 제외한 DisPlay된 RowCount만 계산하여 반환하는 함수
 * 주의)최종 RowCount + 1 을 반환하므로, 따로 +1 해줄 필요가 없다.
 *
 * 사용예 :  function doActionIBSheet(sheetObj,formObj,sAction) {
 *               ...
 *               switch(sAction) {
 *			        case IBINSERT:
 *                      var Row = sheetObj.DataInsert(-1);
 *                      ...
 *                      ======================================================================
 *                      sheetObj.CellValue2(Row, "mnr_cd_dp_seq") = MnrGetViewRowCnt(sheetObj);
 *                      ======================================================================
 *                      ...
 *               }
 *               ...
 *           }
 * @param {Sheet} sheetObj  화면에서 계산되어질 sheet
 * @author 박명신
 * @version 2009.06.04
 */
function MnrGetViewRowCnt(sheetObj){
	var cnt = 0;
	for(var i = 1 ; i <= sheetObj.RowCount; i++){
		if(sheetObj.RowHidden(i) == false){
			cnt++;
		}
	}
	return cnt;
}

/**
 * 반복문으로  생성된 라스트 Delim을 제거
 * ex)
 * '1,2,3,4,5,' => '1,2,3,4,5'
 * @param {String} str 		제거 대상 String
 * @return {String} str 	제거된 String
 * @author 박명신
 * @version 2009.06.04
 */
function MnrDelLastDelim(str){
	//마지막에 &를 없애기 위함
	if (str != ""){
		 str = str.substr(0, str.length - 1);
	}
	return str;
}

/**
 * 2차원 배열의 특정항목을 딜리미터로 연결
 * 1차원 배열은 ComGetAryJoin 을 사용하라.
 * @param {Array} aryData 		조인대상
 * @return {String} retStr		조인결과
 * @see ComGetAryJoin
 * @author 박명신
 * @version 2009.06.04
 */
function MnrGetTwoDimAryJoin(aryData, sDelim, ArrayPoint){
    var retStr = "";
	try {
        if (aryData.constructor==Array) {
        	for(var i = 0;i < aryData.length;i++){
				retStr += aryData[i][ArrayPoint] + sDelim;
			}
        } else {
            return  retStr;
        }
    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * 폼오브젝트의 항목들의 readOnly 속성을 바꾼다.
 * 폼오브젝트의 적용안대는 개체가 있다면 추가하세요
 * sample)
 * var changeVal = false;
 * if(ComGetEtcData(arrXml[0], "agmt_lst_ver_flg") == "N"){
 *	changVal = true;
 * }
 * MnrFormSetReadOnly(formObj,changeVal,"agmt_no|vndr_nm");
 *
 * @param {Form} formObj 		대상 폼
 * @param {Boolean} changVal    바꿀 값 true/false
 * @param {String} extraObj     바꿀 폼오브젝트의 네임을 "|" 로 연결
 * @author 박명신
 * @version 2009.06.18
 */
function MnrFormSetReadOnly(formObj,changeVal,objNames){
	if(objNames != ""){
		var arrObjNames = objNames.split("|");
	} else {
		return;
	}

	for (var i = 0; i < arrObjNames.length; i++) {
		var textName = arrObjNames[i];
		var tagObj = document.all[textName];

		if (tagObj.tagName.toLowerCase() == "input" && tagObj.type.toLowerCase() == "radio") {
			changeClassType = "radio";
		} else if (tagObj.tagName.toLowerCase() == "input" && tagObj.type.toLowerCase() == "text") {
			changeClassType = "input";
		} else if (tagObj.tagName.toLowerCase() == "input" && tagObj.type.toLowerCase() == "checkbox") {
			changeClassType = "trans";
		} else if (tagObj.tagName.toLowerCase() == "textarea") {
			changeClassType = "textarea";
		}

		//체크 박스는 디저블만  시킨다.
		if(tagObj.tagName.toLowerCase() == "input" && tagObj.type.toLowerCase() == "checkbox"){
			tagObj.disabled = changeVal;
		} else {
			tagObj.readOnly = changeVal;

			if(changeVal){
				//readonly 2
				tagObj.className = changeClassType + "2";
			} else {
				var attriVal = tagObj.getAttribute("required");

				if(attriVal != null){
					//필수 1
					tagObj.className = changeClassType + "1";
				} else {
					//필수 아님 0
					tagObj.className = changeClassType;
				}
			}
		}
	}
}

/**
 * 로우를 추가시킨다. (추가된 로우에 배경색깔을 바까줌)
 * sample)
 * var Row = MnrSheetDataInsert(sheetObj);
 *
 * @param  {IBsheet} sheetObj 	쉬트
 * @return {Integer} InsRow     추가된 로우
 * @author 박명신
 * @version 2009.06.26
 */
function MnrSheetDataInsert(sheetObj){
	var InsRow = sheetObj.DataInsert(-1);
	sheetObj.RowBackColor(InsRow) = sheetObj.RgbColor(InsRowBackRolorR,InsRowBackRolorG,InsRowBackRolorB);
	return InsRow;
}

/**
 * ComRowHideDelete 변형 체크된 로우를 쉬트에서 완전 삭제한다.
 * <br><b>Example :</b>
 * <pre>
 *     MnrRowDelete(sheetObj, "del_check");	//"del_check"  체크된 행을 완전 삭제한다.
 * <pre>
 * </pre>
 * @param {ibsheet} 	sheetObj    필수,IBSheet Object
 * @param {int,string} 	col    		필수,삭제처리할 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
 * @returns int<br>
 *          -1 :   삭제 실패한 경우<br>
 *          그외  : 삭제 성공한 경우 처리된 행의 개수로 0개 이상의 값을 리턴한다.<br>
 */
function MnrRowDelete(sheetObj, col) {
	var org_col = col;
	//컬럼Index가 아닌 경우 SaveName인 경우 -> 컬럼Index를 가져온다.
	col = ComIsNumber(col)?ComParseInt(col):sheetObj.SaveNameCol(col);

	//컬럼 인자의 유효성 확인하기
	if (col< 0 || col > sheetObj.LastCol) {
		ComShowMessage("[ComRowHideDelete] '" + sheetObj.id + "'의 '" + org_col + "' 컬럼은 존재하지 않습니다.");
		return -1;
	}

	//체크박스에 체크된 행 전체를 문자열로 가져온다. 결과 : "1|3|5|"
	var sRow = sheetObj.FindCheckedRow(col);
	if (sRow == "") return 0;

	//가져온 행을 배열로 만들기
	var arrRow = sRow.split("|"); //결과 : "1|3|5|"

	sheetObj.RedrawSum = false;	//합계 계산하지 않기, dtAutoSumEx가 있는 경우를 대비

	//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
	for (var idx=arrRow.length - 2; idx>=0; idx--){
		var row = arrRow[idx];
		sheetObj.RowDelete(row, false);  	//완전 삭제
	}

	sheetObj.RedrawSum = true;	//합계 계산하기

	return arrRow.length - 1;
}
 /**
  * IBSheet에 특정 컬럼이 체크된 데이터행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
  * 부모창에서 팝업으로 창을 열때 체크된 데이터 또는 모든 데이터행을 팝업창의 IBSheet로 넘기기위해 사용한다. <br>
  * 또는 왼쪽IBSheet에서 오른쪽IBSheet로 데이터를 이동할때도 사용할 수 있다. <br>
  * bRowDel인자를 true로 설정하면 XML생성에 대상이된 행을 삭제처리까지 할수 있다. <br>
  * <br><b>Example :</b>
  * <pre>
  *     sXml = MnrMakeSearchXml(sheetObj, false, "chkBox","trd_cd|rlane_cd|dir_cd");
  * </pre>
  * @param {ibsheet} 	sheet_obj   필수,IBSheet Object ID
  * @param {int,string}	col     	필수,대상이 되는 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
  * @param {string}  	saveColName 필수,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
  * @param {string}  	nSaveColName필수,COLORDER 지정을 위한 SaveName을 "|"로 연결한 문자열 설정
  * @param {bool}    	bRowDel     선택,대상행삭제여부, default=false
  * @return string,Sheet의 데이터를 조회XML로 구성한 문자열
  */
 function MnrMakeSearchXmls(sheet_obj, col, saveColName, nSaveColName, sCol, sGubun)  {
     try {
         //함수 인자 유효성 확인
         if (typeof sheet_obj != "object" || sheet_obj.tagName != "OBJECT") {
             ComShowMessage("ComMakeSearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
             return "";
         }
         var result = new Array( );

         var gubuns = sGubun.split("|");

         var allXml = "";
         var sColSep = "☜☞";
         var sColOrder = "";
         if (nSaveColName!=undefined && nSaveColName != null && nSaveColName!="") {
             sColOrder = " COLORDER='" + nSaveColName + "' ";
         }

         for(var i =0;i<gubuns.length ;i++){
        	 result[i] = "<?xml version='1.0'  ?>\n" + "<SHEET>\n"
           	 result[i] += "  <DATA" + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
        }

         if(col != ""){
             var findRows = sheet_obj.FindCheckedRow(col);
             if(findRows != ""){
                 findRows = findRows.substring(0, findRows.length - 1); //맨끝의 "|"제거
                 var arrRow = findRows.split("|");
                 var arrCol = saveColName.split("|");

                 var aryTD = new Array(arrCol.length);
                 for(var ir = 0; ir<arrRow.length; ir++){
                    for(var ic = 0; ic<arrCol.length; ic++){
                         //TD-셀의 값을 변수에 저장한다.
                   	 	aryTD[ic] = String(sheet_obj.CellValue(arrRow[ir], arrCol[ic]));
                    }
                    for(var i =0;i< gubuns.length ;i++){
                 		if(sheet_obj.CellValue(arrRow[ir], sCol)== gubuns[i]){
                 			result[i] += "\n<TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
                 		}
                 	}
                 }
             }
         }

         for(var i =0;i<gubuns.length ;i++){
        	 result[i] += "  </DATA>\n" +  "</SHEET>";
         }

         return result;
     } catch(err) { ComFuncErrMsg(err.message); }
 }

  /**
   * IBSheet에 특정 컬럼이 체크된 데이터행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
   * 부모창에서 팝업으로 창을 열때 체크된 데이터 또는 모든 데이터행을 팝업창의 IBSheet로 넘기기위해 사용한다. <br>
   * 또는 왼쪽IBSheet에서 오른쪽IBSheet로 데이터를 이동할때도 사용할 수 있다. <br>
   * bRowDel인자를 true로 설정하면 XML생성에 대상이된 행을 삭제처리까지 할수 있다. <br>
   * <br><b>Example :</b>
   * <pre>
   *     sXml = ComMakeSearchXml(sheetObj, false, "chkBox","trd_cd|rlane_cd|dir_cd");
   * </pre>
   * @param {ibsheet} 	sheet_obj   필수,IBSheet Object ID
   * @param {string}  	saveColName 필수,COLORDER 지정을 위한 SaveName을 "|"로 연결한 문자열 설정
   * @param {bool}    	bRowDel     선택,대상행삭제여부, default=false
   * @return string,Sheet의 데이터를 조회XML로 구성한 문자열
   */
  function MnrMakeSearchXml(sheet_objs, saveColName, bRowDel)  {
      try {
          //함수 인자 유효성 확인
          var allXml = "";
          var sColSep = "•";
          var sColOrder = "";
          if (saveColName!=undefined && saveColName != null && saveColName!="") {
              sColOrder = " COLORDER='" + saveColName + "' ";
          }

          allXml = "<?xml version='1.0'  ?>\n"
                 + "<SHEET>\n"
          allXml += "  <DATA " + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";

         var aryTRs  = new Array(sheet_objs.length);
         for (var i in sheet_objs) {
             var sheetXml = sheet_objs[i].GetRangeText(sheet_objs[i].HeaderRows,0,sheet_objs[i].LastRow,sheet_objs[i].LastCol,sColSep,"^");
             aryTRs[i] = "<TR><![CDATA["+sheetXml.replace(/\^/gi, "]]></TR>\n<TR><![CDATA[")+"]]></TR>";
             if (bRowDel) sheet_objs[i].RemoveAll();
          }
          allXml += aryTRs.join("\n");
          allXml += "  </DATA>\n"
                 +  "</SHEET>";
          return allXml;
      } catch(err) { ComFuncErrMsg(err.message); }
  }

 /**
  * Xml에서 데이타가 있는지 없는지만 판단 <br>
  * true ==> 데이타 없음 / false ==> 데이타 있음
  * <br><b>Example :</b>
  * <pre>
  *   if(MnrIsEmptyXml(xmlStr)){
  *   	//do anything
  *   }
  * </pre>
  * @param  {Xml} 	    xmlStr      필수,조회결과 xml
  * @return {bool}    	            true ==> 데이타 없음 / false ==> 데이타 있음
  */
 function MnrIsEmptyXml(xmlStr) {
 	var rtnArr = new Array();

 	if (xmlStr == null || xmlStr == "") {
 		return true;
 	}

 	try {
 		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
 		xmlDoc.loadXML(xmlStr);

 		var xmlRoot = xmlDoc.documentElement;
 		if (xmlRoot == null) {
 			return true;
 		}

 		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
 		if (dataNode == null || dataNode.attributes.length < 3) {
 			return true;
 		}

 		var dataChildNodes = dataNode.childNodes;
 		if (dataChildNodes == null) {
 			return true;
 		}
 	} catch (err) {
 		ComFuncErrMsg(err.message);
 	}

 	return false;
 }

 /**
 * IBSheet의 GetSearchXml 함수 또는 GetSaveXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 MESSAGE 값을 리턴한다.
 * @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
 * @return  string, MESSAGE의 값
 */
 function MnrComGetErrMsg(xmlStr){
    if ( xmlStr == null  || xmlStr == "" ) return;

    try {
        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;

        var msgDataNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
        if(msgDataNode == null) return;

        return msgDataNode.firstChild.nodeValue;
    } catch(err) { ComFuncErrMsg(err.message); }
 }

 /**
  * RHQ Office Level 검색
  *
  * @param	String	ofc_cd  로그인유저의 Office Code
  * @param	String	rhq_ofc_cd  로그인유저의 RHQ Office Code
  * @return  String   strMnrOfficeLevel  HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴
  */
  function MnrOfficeLevelBackUp(ofc_cd,rhq_ofc_cd){

		var sCondition = new Array (
				new Array("MnrGenCd","HOOFC", "COMMON"),  //Head Office Code
				new Array("MdmOrganization","RHQCHG","")  //RHQ Office Change
			);
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);

		var HOOfc = "";
		if(comboList[0] != null){
			var xmlVal = comboList[0][0].split("|");
		    HOOfc =  xmlVal[0];
		}

		if(comboList[1] != null){
			for(var j = 0; j < comboList[1].length;j++){
				var tempText = comboList[1][j].split("|");
				if(ofc_cd==tempText[0]){
					ofc_cd = tempText[1];
					break;
				}
			}
		}

		if(ofc_cd == HOOfc){
			strMnrOfficeLevel="L1";
		}else if(ofc_cd == rhq_ofc_cd){
			strMnrOfficeLevel="L2";
		}else{
			strMnrOfficeLevel="L3";
		}
 }

  /**
   * MnrOfficeLevel 셋팅
   * @param ofc_cd
   * @param rhq_ofc_cd
   */
  function MnrOfficeLevel(ofc_cd, rhq_ofc_cd){	

	  	var hqOfc = MnrHqOfcByOfc(sheetObjects[0], ofc_cd); // office 의 RHQ office 코드
	  	
		var sCondition =  new Array("MnrGenCd","HOOFC", "COMMON");

		var f_query = '';
		// 쿼리 스트링 조합시작
		f_query += 'f_cmd' + '=' + SEARCH + '&';
		f_query += 'ibflag=X&';
		f_query += 'del_chk=0&';
		f_query += 'searchinfo' + '=' + sCondition[0] + '&';
		f_query += 'searchkey' + '=' + sCondition[1] + '&';
		f_query += 'searchcon' + '=' + sCondition[2] + '&';

		//마지막에 &를 없애기 위함
		if (f_query != "")
		    f_query = f_query.substr(0, f_query.length - 1);

		var sXml = sheetObjects[0].GetSearchXml("MNR_COMGS.do","" ,f_query,true);
		var comboList = MnrXml2ComboString(sXml, "cd_id", "cd_desc");

		if(comboList != null){
			var xmlVal = comboList[0].split("|");
		    HOOfc =  xmlVal[0];
			if(ofc_cd == xmlVal[0]){
				strMnrOfficeLevel="L1";
			}else if(ofc_cd == rhq_ofc_cd || ofc_cd == hqOfc){
				strMnrOfficeLevel="L2";
			}else{
				strMnrOfficeLevel="L3";
			}
		}else{
			if(ofc_cd == rhq_ofc_cd || ofc_cd == hqOfc){
				strMnrOfficeLevel="L2";
			}else{
				strMnrOfficeLevel="L3";
			}
		}
 }

  /**
   * MDM_ORGANIZATION 테이블에서 오피스 코드의 해당 Rhq 코드 정보 가져오기
   * @param sheetObj
   * @param ofc_cd
   * @returns hq office 코드
   */
  function MnrHqOfcByOfc(sheetObj, ofc_cd){
  	var f_query = '';
  	//쿼리 스트링 조합시작
  	f_query += 'f_cmd' + '=' + SEARCH19	+ '&';
  	f_query += 'ofc_cd' + '=' + ofc_cd;

  	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
  	return ComGetEtcData(sXml,"hq_ofc_by_ofc");

  }  
  
 /**
  * INITSHEET
  * //SELECT 로우 배경색
  *	SelectionMode = smSelectionRow;
  *	SelectHighLight = false;
  *	SelectFontBold = false;
  *	SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
  *	EditableColorDiff = true;
  *
  * 선택시 로우 색깔을 바꾸지 않고 특정컬럼 선택시 로우 색깔변경
  * sample)
  * MnrCheckRowColChange(sheetObj,sheetObj.CellValue(Row,"del_chk"),Row);
  * @param {Ibsheet} 	sheetObj    필수,IBSheet Object ID
  * @param {Int} 		checked     필수,기준이 될 체크박스의 값 0 or -1
  * @param {Int}			Row     	필수,대상이 되는 로우
  */
 function MnrCheckRowColChange(sheetObj,checked,Row){
	with(sheetObj){
		if(checked == 1){
			RowBackColor(Row) = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
		} else {
			for(var i = 0; i <= LastCol; i++){
				if(CellEditable(Row,i)){
					CellBackColor(Row, i) =  RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
				} else {
					CellBackColor(Row, i) =  RgbColor(SheetNoEditBackColorR,SheetNoEditBackColorG,SheetNoEditBackColorB);
				}
			}
		}
	}
 }

 /**
 * 파일업로드 리스트를 조회한다.
 * sample)
 *  //파일 리스트 조회
 *	var fileSeq = ComGetEtcData(sXml,"file_seq");
 *	if(fileSeq != "" && fileSeq != null){
 *		var fileXml = SearchFileUpload(sheetObj,fileSeq);
 *		sheetObjects[10].LoadSearchXml(fileXml);
 *	}
 * @param {Ibsheet} 	sheetObj    필수,IBSheet Object ID
 * @param   {String} 	sheetObj    필수,IBSheet Object ID
 * @return  {Xml}       sXml        조회 xml
 */
 function SearchFileUpload(sheetObj,fileSeq){
	var sParam = "f_cmd="+SEARCH;
	sParam += "&file_seq=" + fileSeq;

	var sXml = sheetObj.GetSearchXml("MNR_INTGS.do","" ,sParam,true);
 	return sXml;
 }

 /**
 * 선택된 파일업로드 리스트를 삭제.
 * sample)
 * RemoveFileUpload(sheetObj);
 * @param {Ibsheet} 	sheetObj    필수,IBSheet Object ID
 */
 function RemoveFileUpload(sheetObj){
 	//빈데이타는 미리 삭제한다.
	var sRow = sheetObj.FindCheckedRow("del_chk");
	if (sRow != ""){
		//가져온 행을 배열로 만들기
		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
		sheetObj.RedrawSum = false;	//합계 계산하지 않기, dtAutoSumEx가 있는 경우를 대비
		//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
		for (var idx=arrRow.length - 2; idx>=0; idx--){
			var row = arrRow[idx];
			if(sheetObj.CellValue(row,"org_file_nm") == ""){
				sheetObj.RowDelete(row, false);  	//완전 삭제
			}
		}
	}

	var SaveStr = sheetObj.GetSaveString(false, true, "del_chk");
	var sParam = "f_cmd=" + REMOVE;
	sParam = sParam + '&' + SaveStr;

	//해당 쉬트에서 삭제
	MnrRowDelete(sheetObj,"del_chk");
	//서버에서 삭제
	//변경 사항이 있는경우만
	if(SaveStr != ""){
		var sXml = sheetObj.GetSearchXml("MNR_INTGS.do","" ,sParam,true);
	}
 }

 /**
 * 멀티콤보 클릭 이벤트  <br>
 * <b>Example :</b>
 *
 * @param comboObj	멀티콤보 오브젝트
 * @param index		멀티콤보 index
 */
 function MnrAllChkMultiCombo(comboObj,index) {
	//All 인 경우
    if(index == 0) {
    	//checked
    	if(comboObj.CheckIndex(index)) {
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.checkIndex(i) = true;
    		}

    	} else {
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.checkIndex(i) = false;
    		}
    	}
	//All 이 아닌 경우
    } else {
    	var checkCnt = 0;
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			if(comboObj.checkIndex(i)) {
				checkCnt++;
			}
		}
		if(checkCnt == comboObj.GetCount() - 1) {
			comboObj.checkIndex(0) = true;
		}else{
			comboObj.checkIndex(0) = false;
		}
    }
 }

 /**
 * 모든 버튼의 스타일을 Enable 상태로 한다.  <br>
 * <br><b>Example : </b>
 * <pre>
 *    MnrWaitControl(true);
 * </pre>
 * @param {boolean} option 필수 (true or false)
 * @returns void
 */
 function MnrWaitControl(option){
 	if(option == true){
		MnrBtnDisable();
	} else {
		MnrBtnEnable();
	}
 }
/**
 * 모든 버튼의 스타일을 Enable 상태로 한다.  <br>
 * <br><b>Example : </b>
 * <pre>
 *    MnrBtnEnable();
 * </pre>
 * @param {string} name   필수, 버튼 name 문자열
 * @returns void
 * @see #MnrBtnDisable
 */
 function MnrBtnEnable(){
 	var tds = document.getElementsByTagName("td");
 	for ( var i = 0; i < tds.length; i++) {
 		var td = tds[i];

		if (td.name != undefined && td.className.length > 0 && td.name.indexOf('no_btn_') != -1) {
			if (td.className.indexOf('_1') > 0)
				td.className = td.className.replace(/_1/i, "");
			td.name = td.name.replace(/no_/i, "");
		}
 	}
 }

/**
 * 모든 버튼의 스타일을 Disable 상태로 한다.  <br>
 * <br><b>Example : </b>
 * <pre>
 *    MnrBtnDisable();
 * </pre>
 * @param {string} name   필수, 버튼 name 문자열
 * @returns void
 * @see #MnrBtnEnable
 */
 function MnrBtnDisable(){
	var tds = document.getElementsByTagName("td");
	for(var i = 0; i < tds.length; i++) {
	    var td=tds[i];
		var name = td.name;
	    if (name != undefined && td.className.length > 0 && name.indexOf('btn_') == 0){
	    	if(td.className.indexOf('_1') == -1)
	    		td.className += "_1";
    		td.name = "no_" + name;
	    }
	}
 }

/**
 * 버튼명을 변경한다. <br>
 * <br><b>Example : MnrBtnRename("btn_Apinterface","btn_Cancel","AP Cancel");</b>
 * <pre>
 *    MnrBtnDisable();
 * </pre>
 * @param	String	oldClassName  이전 버튼명
 * @param	String	newClassName  변경할 버튼명
 * @param	String	newName  변경할 버튼Text
 * @see #MnrBtnRename
 */
 function MnrBtnRename(oldName,newName,newText){
	var tds = document.getElementsByTagName("td");
	for(var i = 0; i < tds.length; i++) {
	    var td=tds[i];
	    if (td.className.length > 0 && td.name == oldName){
    		td.name = newName;
			td.innerText=newText;
			return;
	    }
	}
 }

 /**
 * CostCd를 구한다.
 * sample)
 *	var costCd = MnrGetCostCd(sheetObj,"D5","RBS");
 * @param   {Ibsheet} 	sheetObj    필수,IBSheet Object ID
 * @param   {String} 	eqKndCd     필수,EQ KIND
 * @param   {String} 	tpSz        필수,EQ 타입사이즈
 * @param   {String} 	CmpoCd      필수,컴포넌트 코드
 * @return  {String}    costCd      costCd
 */
 function MnrGetCostCd(sheetObj,eqKndCd,tpSz,cmpoCd){
 	tpSz = tpSz.toUpperCase();

	if(eqKndCd == "U"){
		if(tpSz.substr(0, 1) ==	"D"){
			return "MRDRRC";
		} else if(tpSz.substr(0, 1) ==	"R"){
			var f_query = '';
			//쿼리 스트링 조합시작
			f_query += 'f_cmd' + '=' + SEARCH10 + '&';
			f_query += 'tp_sz=' + tpSz +'&';
			f_query += 'cmpo_cd=' + cmpoCd;

			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
			sheetObj.WaitImageVisible = true;

			var arrResult = MnrXmlToArray(sXml);
			if(arrResult != null){
				return arrResult[0][2];
			} else {
				ComShowCodeMessage("MNR00225");
				return;
			}
		} else {
			return "MRDSRC";
		}
	} else if(eqKndCd == "G"){
		return "MRGSRC";
	} else {
		return "MRZSRC";
	}
 }

 /**
 * NULL을 '' 문자열로 변환
 * @param   {String} 	sStr      변환될값
 * @return  {String}    sStr      costCd
 */
 function MnrNullToBlank(sStr){
	if( sStr==null || sStr=='null' || sStr=='undefined' || sStr==undefined || typeof sStr=='undefined'){
		return '';
	} else {
		return sStr;
	}
 }

 /**
 * NULL을 '0' 문자열로 변환
 * @param   {String} 	sStr      변환될값
 * @return  {String}    sStr      costCd
 */
 function MnrNullToZero(sStr){
	if( sStr==null || sStr=='null' || sStr=='' || sStr=='undefined' || sStr==undefined || typeof sStr == 'undefined'){
		return '0';
	} else {
		return sStr;
	}
 }

 /**
 * Total Loss Status History 조회
 * @param {Ibsheet} 	sheetObj    필수,IBSheet Object ID
 * @param   {String} 	sheetObj    필수,IBSheet Object ID
 * @return  {Xml}       sXml        조회 xml
 */
 function MnrStatusHistorySearch(sheetObj, sMnrStsRefNo) {
	//쿼리 스트링 조합시작
	var f_query = '';
	f_query += 'f_cmd' + '=' + SEARCH13 + '&';
	f_query += 'mnr_sts_ref_no=' + sMnrStsRefNo ;

	sheetObj.WaitImageVisible = false;
	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	sheetObj.WaitImageVisible = true;
	return sXml;
 }

/**
 * 대량의 데이터 저장시 ComGetSaveString 대신에 사용한다.
 * @param sheetObj
 * @param TrimComma
 * @param Status
 * @param prefix
 * @return
 */
function MnrGetAllSaveText(sheetObj, TrimComma, Status, prefix) {
	if (TrimComma==undefined || TrimComma==null) TrimComma = false;
	if (Status==undefined || Status==null) Status = "ibflag";
	if (prefix==undefined || prefix==null) prefix = "";
	var arrSave = new Array();
	for ( var i = 0 ; i <= sheetObj.LastCol ; i++ ) {
		arrSave[i] = sheetObj.ColSaveName(i);
	}
	var str = sheetObj.GetRangeText(sheetObj.HeaderRows, 0, sheetObj.LastRow, sheetObj.LastCol, "|", "^");
	if ( TrimComma ) str = str.replace(/\,/gi, "");
	var arrStr = str.split("^");
	for ( var i = 0 in arrStr ) {
		var arrCol = arrStr[i].split("|");
		for ( var j = 0 in arrCol ) {
			if ( arrSave[j] == Status ) {
				switch(arrCol[j]) {
					case "INS": arrCol[j] = "I"; break;
					case "UPD": arrCol[j] = "U"; break;
					case "DEL": arrCol[j] = "D"; break;
					default:    arrCol[j] = "R"; break;
				}
			}
			arrCol[j] = prefix + arrSave[j]+"="+arrCol[j];
		}
		arrStr[i] =  arrCol.join("&");
	}
	return  arrStr.join("&");
}

/**
 * form컨트롤의 Date형식의 Validation을 확인후 메시지 출력
 * @param formObj
 * @param msgTitle
 * @return
 */
function MnrChkDateValid(formObj, msgTitle){
	if(!ComIsDate(formObj.value)) {
		ComShowCodeMessage("COM12134", msgTitle);
		formObj.value="";
		return false;
	}
}

/**
 * ComOpenWait와 동일하나 ComBtnsEnable(false) 삭제;
 * @param {bool}   flag         필수,키보드나 마우스를 대기상태(true)/일반상태(false)
 * @param {bool}   bOpenLayer   선택,대기이미지(Waiting) 표시 여부, default=true
 * @return
 */
function MNRComOpenWait(flag, bOpenLayer){
    try {
        if(waitDoc.getElementById(WAIT_DIV_NAME)==null && !flag) return;
        if(waitDoc.getElementById(WAIT_DIV_NAME)==null && flag) initWaitFrame();

        var divobj  = waitDoc.getElementById(WAIT_DIV_NAME);
        var waitImg = waitDoc.getElementById(WAIT_FRAME_NAME);

        if(flag)
        {
            //인자를 설정하지 않은 경우 default=true로 설정하기 위함
            if (bOpenLayer==undefined || bOpenLayer==null) bOpenLayer = true;
            if(bOpenLayer)  {
                //브라우저의 크기가 변경될수 있으므로 iFrame의 위치를 수정한다.
                var leftPos=(divobj.clientWidth-waitW)/2;       if(leftPos<0)   leftPos=0;
                var topPos =(divobj.clientHeight-wiatH)/2;      if(topPos<0)    topPos=0;
                waitImg.style.left = leftPos;
                waitImg.style.top  = topPos;
                waitImg.style.display="inline";
            } else {
                waitImg.style.display="none";
            }

			//스크롤바를 없애는것은 대기이미지가 그려지지 않은 영역으로 움직이지 않도록 하기 위함
            waitDoc.body.scroll = "no";

            //위치를 바뀌주고, visible후 focus를 설정해주어야 대기이미지가 잘 보임
            divobj.style.left = waitDoc.body.scrollLeft;
            divobj.style.top =  waitDoc.body.scrollTop + 1;

            divobj.style.visibility="visible";
            divobj.focus();

            window.defaultStatus="Processing......";
            window.status="Processing......";
            top.window.document.body.style.cursor="wait";
            window.document.body.style.cursor="wait";
            try { window.event.cancelBubble=true; } catch(ex) {;}

        } else {
            top.window.document.body.style.cursor="default";
            window.document.body.style.cursor="default";
            window.defaultStatus="";
            window.status="";

            divobj.style.visibility="hidden";
            divobj.style.left = 0;
            divobj.style.top = 0;
            waitDoc.body.scroll = "yes";
            ComBtnsEnable(true);
        }
    } catch(err) { ComFuncErrMsg(err.message); }
}

function MnrQexeRun(sheetObj,sCondition){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH + '&';

	for (var i = 0;i < sCondition.length; i++){
		f_query += 'ibflag=X&';
		f_query += 'del_chk=0&';
		f_query += 'searchinfo' + '=' + sCondition[i][0] + '&';
		f_query += 'searchkey' + '=' + sCondition[i][1] + '&';
		f_query += 'searchcon' + '=' + sCondition[i][2] + '&';
	}
	//마지막에 &를 없애기 위함
	f_query = MnrDelLastDelim(f_query);

	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	return	sXml;
}

/**
 * From Date 2010-04-01 체크
 * @param	{String}	fromdt 		From Date
 * @param	{String}	chkKind   "TIRE" 일때 Tire Performance
 * @return  {String}   	2010-04-01 보다 작을때 false
 */
function MnrChkFromDate(fromdt, chkKind){
	var setDate="";

	if(chkKind=="TIRE"){
		setDate = "2010-01-01"  //Tire Performance
	}else{
		setDate = "2010-04-01"  //General Performance
	}

	var ret = ComGetDaysBetween(fromdt.value, setDate);
	if(ret > 0){
		ComShowCodeMessage("MNR00338");
		fromdt.value = setDate;
		return false;
	}
	return true;
}

/**
 * From Date 2010-04-01 보다 작을때 2010-04-01로 셋팅
 * @param	{String}	fromdt 		From Date
 * @param	{String}	chkKind   "TIRE" 일때 Tire Performance
 * @return
 */
function MnrSetFromDate(fromdt, chkKind){
	var setDate="";

	if(chkKind=="TIRE"){
		setDate = "2010-01-01"  //Tire Performance
	}else{
		setDate = "2010-04-01"  //General Performance
	}

	var ret = ComGetDaysBetween(fromdt.value, setDate);
	if(ret > 0){
		fromdt.value = setDate;
	}else{
		fromdt.value = fromdt.value;
	}
}

/**
 * Curr Exchange Rate 정보 조회
 * @param	{String}	xchRt 		기준년월
 * @param   {String}   	currCd     	Curr 코드
 * @param   {String}   	xchCurrCd   Exchange Curr 코드
 * @param   {String}   	dpCurrCd    DpPrcs를 가져오고 싶은 Curr 코드(없으면 currCd)가져옴
 * @return  {String}   	xchRt
 */
function MnrGetCurrXchRt(sheetObj,xchRt,currCd,xchCurrCd,xchAmt){
	var f_query = '';
	//쿼리 스트링 조합시작
	if(xchAmt==undefined){
		xchAmt = "1";
	}

	f_query += 'f_cmd' + '=' + SEARCH16 + '&';
	f_query += 'xch_rt=' + xchRt + '&';
	f_query += 'curr_cd=' + currCd + '&';
 	f_query += 'xch_curr_cd=' + xchCurrCd + '&';
 	f_query += 'xch_amt=' + xchAmt + '&';
 	f_query += 'dp_prcs_curr_cd=' + currCd;

	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	return  ComGetEtcData(sXml,"XchRt") + "," + ComGetEtcData(sXml,"DpPrcsKnt");
}

/**
 * Curr Exchange Rate 정보 조회
 * @param	{String}	xchRt 		기준년월
 * @param   {String}   	currCd     	Curr 코드
 * @param   {String}   	xchCurrCd   Exchange Curr 코드
 * @param   {String}   	dpCurrCd    DpPrcs를 가져오고 싶은 Curr 코드(없으면 currCd)가져옴
 * @return  {String}   	xchRt
 */
function MnrGetCurrXchRt2(sheetObj,xchRt,currCd,xchCurrCd,xchAmt){
	var f_query = '';
	//쿼리 스트링 조합시작
	if(xchAmt==undefined){
		xchAmt = "1";
	}

	f_query += 'f_cmd' + '=' + SEARCH16 + '&';
	f_query += 'xch_rt=' + xchRt + '&';
	f_query += 'curr_cd=' + currCd + '&';
 	f_query += 'xch_curr_cd=' + xchCurrCd + '&';
 	f_query += 'xch_amt=' + xchAmt + '&';
 	f_query += 'dp_prcs_curr_cd=' + xchCurrCd;

	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	return  ComGetEtcData(sXml,"XchRt") + "," + ComGetEtcData(sXml,"DpPrcsKnt");
}


/**
 * OFFICE 별 로칼 날짜(YYYY-MM-DD)를 조회
 * @param	{String}	ofcCd 		로칼 시간을 조회해올 OFFICE
 * @return  {String}   	날짜			YYYY-MM-DD
 */
function MnrGetLocalDate(sheetObj,ofcCd){
	var f_query = '';

	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH17 + '&';
	f_query += 'ofc_cd=' + ofcCd;

	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	return  ComGetEtcData(sXml,"LCLDATE");
}

/**
 * OFFICE별 로칼 시간으로 근무 시간(08  19) 인지를 조회
 * @param	{String}	ofcCd 		로칼 시간을 조회해올 OFFICE
 * @return  {String}   	날짜			YYYY-MM-DD
 */
function MnrGetIsWorkTime(sheetObj,ofcCd){
	var f_query = '';

	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH17 + '&';
	f_query += 'ofc_cd=' + ofcCd;

	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	return  ComGetEtcData(sXml,"WORKENABLE");
}
 
 /**
 * Approval Step 조회
 * @param {Ibsheet} 	sheetObj    필수,IBSheet Object ID
 * @param   {String} 	sheetObj    필수,IBSheet Object ID
 * @return  {Xml}       sXml        조회 xml
 */
function MnrApprovalStepSearch(sheetObj, sOfcCd, sWrtfNo) {
	//쿼리 스트링 조합시작
	var f_query = '';
	f_query += 'f_cmd' + '=' + SEARCH21 + '&';
	f_query += 'ofc_cd=' + sOfcCd + '&';
	f_query += 'wrtf_no=' + sWrtfNo ;

	sheetObj.WaitImageVisible = false;
	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	sheetObj.WaitImageVisible = true;
	return sXml;
}

/**
 * Office Code, Vendor Seq, SAC Code를 통한 India GST 세율 정보 조회
 * @param 	{Ibsheet} 	sheetObj
 * @param 	{String} 	idaSacCd
 * @return  {String}
 */
function MnrChkSacCdValid(sheetObj, idaSacCd ) {
	//쿼리 스트링 조합시작
	var f_query = '';
	f_query += 'f_cmd' + '=' + SEARCH22 + '&';
	f_query += 'ida_sac_cd=' + idaSacCd + '&';

	sheetObj.WaitImageVisible = false;
	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	return  ComGetEtcData(sXml,"err_flg");
}

/**
 * Office Code, Vendor Seq, SAC Code를 통한 India GST 세율 정보 조회
 * @param 	{Ibsheet} 	sheetObj
 * @param 	{String} 	ofcCd
 * @param 	{String} 	vndrSeq
 * @param 	{String} 	idaSacCd
 * @return  {String}
 */
function MnrGetIdaGstRto(sheetObj, ofcCd, vndrSeq, idaSacCd ) {
	//쿼리 스트링 조합시작
	var f_query = '';
	f_query += 'f_cmd' + '=' + SEARCH23 + '&';
	f_query += 'ofc_cd=' + ofcCd + '&';
	f_query += 'vndr_seq=' + vndrSeq + '&';
	f_query += 'ida_sac_cd=' + idaSacCd + '&';

	sheetObj.WaitImageVisible = false;
	var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
	return  ComGetEtcData(sXml,"ida_gst_rt");
}

//*************** MNR FUNCUTION END ***************//
