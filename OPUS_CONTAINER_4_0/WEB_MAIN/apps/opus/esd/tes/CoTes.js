﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoTes.js
*@FileTitle  : Tes common 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/********************************************************************
 * 1. TES 관련 메세지
 * 2. TES Common Script 
 * 3. TES Invoice Common Script
 * 4. TES Guarantee Common Script
 *******************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 메시지코드와 각종 메시지 처리 관련 함수가 정의되어 있다.
 * @author 
 */
/********************************************************************
 * 	// 1. TES 관련 메세지 (상당히 많은 분량이 중복됨)
 * 	// var msgs = new Array();
 * 	// TES50000 Agreement Creation 관련 Message 추가 - 2009-08-28
 * 
 * 
 ********************************************************************/
msgs['TES10001'] = 'Please enter Agreement No.';
msgs['TES10002'] = 'This is incorrect Agreement No. format.\n\n Please try again.';
msgs['TES10003'] = 'There is no Agreement to be deleted.';
msgs['TES10004'] = 'There is lack of data for pop-up display.';
msgs['TES10005'] = 'There is no mandatory item.\n\n Please check again.';
msgs['TES10006'] = 'Please select Cost Code for Throughput Rate.';
msgs['TES10007'] = 'Agreement header information is not entered/saved.\n\n Please check again.';
msgs['TES10008'] = 'Please check Agreement information again.';
msgs['TES10009'] = 'Please enter Yard Code.';
msgs['TES10010'] = 'There is no Yard Code Name.\n\n Please enter Yard Code again.';
msgs['TES10011'] = 'Please enter Service Provider Code.';
msgs['TES10012'] = 'Please enter Effective Date.';
msgs['TES10013'] = 'Date is not correct.';
msgs['TES10014'] = 'Please check Auto Ext.';
msgs['TES10015'] = 'Already registered Agreement as same Yard and Service Provider.\n\n Eo you want to register another Agreement?';
msgs['TES10016'] = 'Please select Cost code.';
msgs['TES10017'] = 'Please select Vol. UOM.';
msgs['TES10018'] = 'Please select Currency.';
msgs['TES10019'] = 'There is no registered Cost Code with the Throughput Rate.\n\n Do you want to register now?';
msgs['TES10020'] = 'There is no Agreement header information.\n\n Please check again.';
msgs['TES10021'] = 'Please enter Yard.';
msgs['TES10022'] = 'Please enter Service Provider.';
msgs['TES10023'] = 'Please enter Contract Office.';
msgs['TES10024'] = 'Please enter Effective Date.';
msgs['TES10025'] = 'Please select Cost code.';
msgs['TES10026'] = 'Please select container Type/Size.';
msgs['TES10027'] = 'Please enter Rate.';
msgs['TES10028'] = 'There is no data to Save.\n\n Please check again.';
msgs['TES10029'] = 'Verification is not completed.\n\n Please check Verify again.';
msgs['TES10030'] = 'There is no data on Load EXCEL.\n\n Please check again.';
msgs['TES10031'] = 'Please modify Terminal Rate List Sheet Data.';
msgs['TES10032'] = 'Terminal Rate List Verify has been completed.';
msgs['TES10033'] = 'Please check Terminal Agreement again.';
msgs['TES10034'] = 'There is no necessary data for Verify.\n\n Please check again.';
msgs['TES10035'] = 'Terminal Rate List Data save/modify/delete is not completed.\n\n Please complete Data save/modify/delete.';
msgs['TES10036'] = 'This is Confirmed Terminal Rate List.';
msgs['TES10037'] = 'Please select SR AGMT Type.';
msgs['TES10038'] = 'Please select Cost code.';
msgs['TES10039'] = 'Please select Vol. UOM.';
msgs['TES10040'] = 'Please enter Commence Time.';
msgs['TES10041'] = 'Please enter Commence Time as HH:MM format.';
msgs['TES10042'] = 'Please select Free Days/Rate.';
msgs['TES10043'] = 'Please select DG Class.';
msgs['TES10044'] = 'Please select DG, NODG.';
msgs['TES10045'] = 'Please check DG Class.';
msgs['TES10046'] = 'Please enter Days.';
msgs['TES10047'] = 'Please check No of Volume Tier.';
msgs['TES10048'] = 'Please check Cal. Period.';
msgs['TES10049'] = 'Please enter FP TEU.';
msgs['TES10050'] = 'Storage Rate List Data save/modify/delete is not completed.\n\n Please complete Data save/modify/delete.';
msgs['TES10051'] = 'This is Confirmed Storage Rate List.';
msgs['TES10052'] = 'This is Cost Code for Storage Rate List.';
msgs['TES10053'] = 'This is Cost Code for Terminal Rate List.';
msgs['TES10054'] = 'This Cost Code can not be used for Agreement Cost Code.';
msgs['TES10055'] = 'Please check Auto Calc. ';
msgs['TES10056'] = 'Please select Bound.';
msgs['TES10057'] = 'Please select IPC/Ocean.';
msgs['TES10058'] = 'Please select Applied Date.';
msgs['TES10059'] = 'Please select Lane.';
msgs['TES10060'] = 'Please select DG Class.';
msgs['TES10061'] = 'Please check No of Volume Tier.';
msgs['TES10062'] = 'Please enter No of Volume Tier.';
msgs['TES10063'] = 'Please check No of Overtime Shift.';
msgs['TES10064'] = 'Please enter No of Overtime Shift.';
msgs['TES10065'] = 'Please select Terminal Handling Charge.';
msgs['TES10066'] = 'This is invalid Yard Code.';
msgs['TES10067'] = 'This is invalid Service Provider Code.';
msgs['TES10068'] = 'There is no Agreement.\n\n Do you want to register?';
msgs['TES10069'] = 'Agreement header information Save has been completed.';
msgs['TES10070'] = 'Terminal Agreement information interim Save has been processed.';
msgs['TES10071'] = 'Storage Agreement information interim Save has been processed.';
msgs['TES10072'] = 'Agreement is saved successfully.';
msgs['TES10073'] = 'Terminal Rate List interim Save has been processed.';
msgs['TES10074'] = 'Register Agreement has been processed.';
msgs['TES10075'] = 'Storage Rate List interim Save has been processed.';
msgs['TES10076'] = 'Register Storage Agreement has been processed.';
msgs['TES10077'] = 'Save Fail {?msg1}';
msgs['TES10078'] = 'There is no data to Print.';
msgs['TES10079'] = 'Please enter correct data on Effective On.';
msgs['TES10080'] = 'You select Summary header Line.\n\n Please select Agreement data line.';
msgs['TES10081'] = 'Please select correct Agreement Data.';
msgs['TES10083'] = 'Please enter Agreement No. and Agreement Version().';
msgs['TES10084'] = 'Please select Agreement Copy line.';
msgs['TES10085'] = 'There is no header information on Agreement Creation & Correction screen.\n\n Please check again.';
msgs['TES10086'] = 'Please check correct Agreement Copy data.';
msgs['TES10087'] = 'Please load Excel File.';
msgs['TES10088'] = 'Please modify sheet.';
msgs['TES10089'] = 'Verify has been completed and data will be list up on AGMT.';
msgs['TES10090'] = 'Please load Excel file.';
msgs['TES10091'] = 'Please modify sheet.';
msgs['TES10092'] = 'Verify has been completed and data will be list up on AGMT.';
msgs['TES10093'] = 'Register Throughput Cost Code has been saved.';
msgs['TES10094'] = 'This is invalid Password.\n\n Please try again.';
msgs['TES10095'] = 'These are saving canceled Yard code and vendor SEQ.\n\n Please check again.';
msgs['TES10096'] = 'Please check Agreement after Retrieve.';
msgs['TES10097'] = 'There is no date to delete.\n\n Please check again.';
msgs['TES10098'] = 'Terminal Rate List Verify has not been completed.';
msgs['TES10099'] = 'Throughput Cost Code and Volume Accumulated Method has not been registered.\n\n Please check again.';
msgs['TES10100'] = 'Cost Code related with Throughput Rate has not been registered.\n\n Please check again.';
msgs['TES10101'] = 'Volume Accumulate Method related with Tier Vol. adaption has not been registered.\n\n Please check again.';
msgs['TES10102'] = 'Saving/Modification of Terminal Rate List Data has not been completed.\n\n Please complete saving/modification the Data.';
msgs['TES10103'] = 'Please modify Storage Rate List Sheet Data.';
msgs['TES10104'] = 'Storage Rate List Verify has been completed.';
msgs['TES10105'] = 'Please check Storage Agreement again.';
msgs['TES10106'] = 'Storage Rate List Verify has not been completed.';
msgs['TES10107'] = 'Please enter correct Yard information.';
msgs['TES10108'] = 'Numbers can be entered on vendor information.\n\n Please enter numbers.';
msgs['TES10109'] = 'Saving/modification of Storage Rate List Data has not been completed.\n\n Please complete saving/modification the Data.';
msgs['TES10110'] = 'Interim saving of Agreement Rate List has been processed.';
msgs['TES10111'] = 'Agreement HEADER information and Agreement Rate List has been saved.';
msgs['TES10112'] = 'Start date must be earlier than end date.';
msgs['TES10113'] = 'There is registered Agreement with same Yard, Vendor.';
msgs['TES10114'] = 'Header input data and Agreement List data are modified as the same time.\n\n Please modify Agreement List data after modify and adapt upper input data.';
msgs['TES10115'] = 'There is no modified data on Header input data and Agreement List.\n\n Please check again.';
msgs['TES10116'] = 'There is no Agreement.\n\n Do you want to create new one?';
msgs['TES10117'] = 'There is same condition rate.\n\n Please check the Agreement.';
msgs['TES10118'] = 'This is Registered Agreement.\n\n Do you want to modify?';
msgs['TES10119'] = 'There are {?msg1} duplicate rows total.\n\n Please check again.';
msgs['TES10120'] = 'Verify has been completed.\n\n There is Terminal Agreement Rate List.\n\n Please click OK in case of addition to the current Rate List or click Cancel in case of replacing the existing Rate List.';
msgs['TES10121'] = 'Verify has been completed.\n\n There is Storage Agreement Rate List.\n\n Please click OK in case of addition to the current Rate List or click Cancel in case of replacing the existing Rate List.';
msgs['TES10122'] = 'Please enter Period.';
msgs['TES10123'] = 'Please check Cost Code For Volume Accumulate.';
msgs['TES10124'] = 'This is Registered Agreement.\n\n Do you want to modify?';
msgs['TES10125'] = 'Terminal/Storage Rate List Data have not been saved/modified.\n\n Please complete save/modify Data.';
msgs['TES10126'] = 'There is no Rate List Data.\n\n Please check again.';
msgs['TES10127'] = 'Terminal/Storage/EQ Storage Rate List Data have not been saved/modified.\n\n Please complete save/modify Data.';
msgs['TES10128'] = 'EQ Storage Rate List Verify has been completed.';
msgs['TES10129'] = 'Please check EQ Storage Agreement again.';
msgs['TES10130'] = 'EQ Storage Rate List Verify has not been completed.';
msgs['TES10131'] = 'Verify has been completed.\n\n There is EQ Storage Agreement Rate List.\n\n Please click OK in case of addition to the current Rate List or click Cancel in case of replacing the existing Rate List.';

msgs['TES15001'] = 'Please enter Cost Code which will be deleted.';
msgs['TES15002'] = 'Please enter correct Cost Code which will be deleted.';
msgs['TES15003'] = 'English character and numbers can be entered.';
msgs['TES15004'] = 'Please enter Cost Code.';
msgs['TES15005'] = 'Please enter correct Cost Code.';
msgs['TES15006'] = 'Please enter Full name of Cost Code.';
msgs['TES15007'] = 'Please enter Cost Code cost abbr nm.';
msgs['TES15008'] = 'Please enter Cost Code cost opt no.';
msgs['TES15009'] = 'Numbers can be entered.\n\n Please enter numbers.';
msgs['TES15010'] = 'Please enter Carrier Code.';
msgs['TES15011'] = 'Please enter Carrier Full Name.';
msgs['TES21001'] = 'Rejected Invoice';
msgs['TES21002'] = 'Confirmed Invoice';
msgs['TES21003'] = 'There is a lack of data for pop-up display.';
msgs['TES21004'] = 'Please click VVD Delete Button';
msgs['TES21005'] = 'The Terminal Invoice Header is not saved.';
msgs['TES21006'] = 'The VVD No. does not exist.';
msgs['TES21007'] = 'Do you want to delete all Container List Data on VVD NO : {?msg1} Verification, Discrepancy Tab? ';
msgs['TES21008'] = 'There is no data to convert.';
msgs['TES21009'] = 'There is no selected data.';
msgs['TES21010'] = 'The Terminal Invoice Header is not saved.';
msgs['TES21011'] = 'There are undated Container List data.\n\n Please save Container List Data first.';
msgs['TES21012'] = 'There is no data to calculate.';
msgs['TES21013'] = 'There is no Discrepancy Container List Data!';
msgs['TES21014'] = 'There is no Cost Calc data to save.';
msgs['TES21015'] = 'Cost Calculation is not processed.\n\n Please confirm after Cost Calculation.';
msgs['TES21016'] = 'INV AMT and calculated AMT do not match.';
msgs['TES21017'] = 'There is no data.';
msgs['TES21018'] = 'Do you want to add VVD?';
msgs['TES21019'] = 'VVD is 9 characters long.';
msgs['TES21020'] = 'There is no data to delete.';
msgs['TES21021'] = 'Do you want to delete VVD?';
msgs['TES21022'] = 'This is initial page.';
msgs['TES21023'] = 'This is final page.';
msgs['TES21024'] = 'Yard Code must be entered first.';
msgs['TES21025'] = 'The service is not available now';
msgs['TES21026'] = '{?msg1} is not entered.';
msgs['TES21027'] = '{?msg1} is not selected.';
msgs['TES21028'] = '{?msg1} is not selected.';
msgs['TES21029'] = 'On-dock Rail Invoice duplicate.';
msgs['TES21030'] = 'Off Dock Cy Invoice duplicate.';
msgs['TES21031'] = 'Marine Terminal Storage Invoice duplicate.';
msgs['TES21032'] = '[ERR] multi header data are retrieved.';
msgs['TES21033'] = 'The Invoice confirmation is required.';
msgs['TES21034'] = 'There is no data saved.';
msgs['TES21035'] = 'ERR';
msgs['TES21036'] = 'This Yard Code does not match Cost OFC.';
msgs['TES21037'] = 'An ERR occurred while confirming Yard Code of Cost OFC.';
msgs['TES21038'] = 'This is invalid Cost OFC.';
msgs['TES21039'] = 'This is invalid Yard Code.';
msgs['TES21040'] = 'This is invalid Service Provider Code.';
msgs['TES21041'] = 'Please enter numbers only';
msgs['TES21042'] = 'Service Provider Code is 6 characters long.';
msgs['TES21043'] = 'VVD is 9 characters long.';
msgs['TES21044'] = 'There is no VVD.';
msgs['TES21045'] = 'Cost Code is not selected';
msgs['TES21046'] = 'You can only delete Manual Calculation Type costs.';
msgs['TES21047'] = 'Wrong VVD format is entered.';
msgs['TES21048'] = 'Wrong Date is entered.';
msgs['TES21049'] = '{?msg1}';
//	msgs['TES21050'] = 'No authority to correct/delete selected invoice - Invoice office mismatch!';
msgs['TES21050'] = 'No authority to correct / delete the invoice with your log-in office.';
msgs['TES21051'] = 'No authority to make inquiry to the invoice with your log-in office.';
msgs['TES21052'] = 'This Invoice No is duplicated in ERP(A/P). \n\nPlz, change to another Invoice No.';
msgs['TES21053'] = 'Please select F/M.';
msgs['TES21054'] = 'Do not select F/M.';
msgs['TES21055'] = 'Please select Sub Trade.';
msgs['TES21056'] = 'Do not select Sub Trade.';
// TES - Marine Terminal Invoice Container List 조회화면 관련 메세지
msgs['TES21501'] = 'Please Input Invoice No & Service Provider Code!';
msgs['TES21502'] = 'Please Input Invoice No!';
msgs['TES21503'] = 'Please Input Service Provider Code!';
msgs['TES21504'] = 'Invaid Service Provider Code!';
msgs['TES21505'] = 'No Data for Inv No : {?msg1} & Service Provider Code: {?msg2}';
msgs['TES21506'] = 'The service is not available now';
msgs['TES21507'] = '{?msg1}';
msgs['TES21508'] = 'This is not Marine Terminal Type Invoice.';
msgs['TES21509'] = 'This is initial page.';
msgs['TES21510'] = 'This is final page.';
msgs['TES21511'] = 'This is invalid Service Provider Code.';
// TES - Revised Vol. Pop(TM&ON)
msgs['TES21601'] = 'There is no modified item.';
msgs['TES21602'] = '[Cost Code] is mandatory item.';
msgs['TES21603'] = '[container No.] is mandatory item.';
// TES - 3rd Pop
msgs['TES21701'] = 'Mandatory item is not entered. \n\n Please check it up.';
// TES - Invice Summary Inquiry 관련 메세지
msgs['TES21901'] = 'Please enter Yard.';
msgs['TES21902'] = 'Please enter correct Yard information.';
msgs['TES21903'] = 'Retrieve option : Please enter start date.';
msgs['TES21904'] = 'Retrieve option : Please enter end date.';
msgs['TES21905'] = 'No Data Found';
msgs['TES21906'] = 'There is lack of data for pop-up display.';
msgs['TES21907'] = 'No Row Selected';
msgs['TES21908'] = 'There is no row selected.';
msgs['TES21909'] = 'The service is not available now';
msgs['TES21910'] = 'This Service Provider Code is invalid.';
msgs['TES21911'] = '{?msg1}';
// TES - On-dock Rail Invoice Creation&Correction 관련 메세지
msgs['TES22001'] = 'Rejected Invoice !!';
msgs['TES22002'] = 'Confirmed Invoice !!';
msgs['TES22003'] = 'There is a lack of data for pop-up display.';
msgs['TES22004'] = 'Yard Code must be entered first.';
msgs['TES22005'] = 'The Terminal Invoice Header is not saved.';
msgs['TES22006'] = 'Do you want to delete all Container List Data on Verification, Discrepancy Tab?';
msgs['TES22007'] = 'There is no data to convert.';
msgs['TES22008'] = 'There is no data selected.';
msgs['TES22009'] = 'There is changed Container List data. \n\n Please save Container List Data first.';
msgs['TES22010'] = 'There is no data to calculate.';
msgs['TES22011'] = 'Not Exist Discrepancy Container List Data!';
msgs['TES22012'] = 'Please confirm after calculate Cost for changed Container List data.';
msgs['TES22013'] = 'Cost Calculation is not processed.\n\n Please confirm after Cost Calculation.';
msgs['TES22014'] = 'INV AMT and Calculated AMT do not match.';
msgs['TES22015'] = 'The service is not available now.';
msgs['TES22016'] = '{?msg1}';
msgs['TES22017'] = '{?msg1} is not entered.';
msgs['TES22018'] = '{?msg1} is not selected.';
msgs['TES22019'] = 'This is invalid Cost OFC.';
msgs['TES22020'] = 'This is invalid Yard Code.';
msgs['TES22021'] = 'This is invalid Service Provider Code.';
msgs['TES22022'] = 'Please enter numbers only';
msgs['TES22023'] = 'Service Provider Code is 6 characters long.';
msgs['TES22024'] = '[ERR] Multi header data are retrieved.';
msgs['TES22025'] = 'There is no data saved.';
msgs['TES22026'] = 'Marine Terminal Invoice duplicate.';
msgs['TES22027'] = 'Off Dock Cy Invoice duplicate.';
msgs['TES22028'] = 'Marine Terminal Storage Invoice duplicate.';
msgs['TES22029'] = 'This is Confirmed Invoice.\n\n Do you want to modify?';
msgs['TES22030'] = 'ERR';
msgs['TES22031'] = 'Cost Code is not selected.';
msgs['TES22032'] = 'Type/Size is not selected.';
msgs['TES22033'] = 'DG is not selected.';
msgs['TES22034'] = 'Revised Vol. is not selected.';
msgs['TES22035'] = 'It is possible when Calculation Type is Manual.';
msgs['TES22036'] = 'Wrong date is entered.';
msgs['TES22037'] = '{?msg1} is mandatory item.';
msgs['TES22038'] = '';
msgs['TES22039'] = '';
msgs['TES22040'] = '';
msgs['TPB90015'] = 'Please select a kind of 3rd Party.';
// TES - On-dock Rail Charge Container List Inquiry
msgs['TES22501'] = 'Please input Invoice No & Service Provider Code!';
msgs['TES22502'] = 'Please Input Invoice No!';
msgs['TES22503'] = 'Please Input Service Provider Code!';
msgs['TES22504'] = 'Invalid Service Provider Code!';
msgs['TES22505'] = 'No Data for Inv No: {?msg1} & Service Provider Code: {?msg2}';
msgs['TES22506'] = '';
msgs['TES22507'] = '{?msg1}';
msgs['TES22508'] = 'This is invalid Service Provider Code.';
msgs['TES22509'] = '';
msgs['TES22510'] = '';
// TES - File Import 화면-On-Dock Rail Charge
msgs['TES22601'] = 'EXCEL FILE SOURCE DATA is wrong.';
msgs['TES22602'] = 'Verify is not processed.';
msgs['TES23001'] = 'Processed normally.';
msgs['TES23001'] = 'Cost OFC and Yard Code do not match.';
msgs['TES23002'] = 'Error occurred while confirming the Yard Code of CostOFC.';
msgs['TES23003'] = '';
msgs['TES23004'] = 'Delete all sheets and modify yd, Cost OFC, calc. Storage Combo Items.';
msgs['TES23005'] = 'Hold Remarks is not entered.';
msgs['TES23006'] = 'This is invalid {?msg1}.';
msgs['TES23007'] = '{?msg1} is not entered.';
msgs['TES23008'] = '{?msg1} is invalid.';
msgs['TES23009'] = '{?msg1} has error.';
msgs['TES23010'] = 'You must select {?msg2}item when you check {?msg1}.';
msgs['TES23011'] = 'Date format is wrong.';
msgs['TES23012'] = 'Start date must be earlier than end date.';
msgs['TES23013'] = 'There is a SHEET to check before saving.\n\n Do you want to move?';
msgs['TES23014'] = 'There is a lack of data for pop-up display.';
msgs['TES23015'] = 'There is no data to delete.';
msgs['TES23016'] = 'Please enter the start date and end date of Period.';
msgs['TES23017'] = 'This is error of basic information';
msgs['TES23018'] = 'There is no modified item.';
msgs['TES23019'] = 'There is no selected row.';
msgs['TES23020'] = 'There is not saved data.\n\n Please save first.';
msgs['TES23021'] = 'There is modified data.\n\n Please save first.';
msgs['TES23022'] = 'Please enter the start date of Period.';
msgs['TES23023'] = 'There is no calculation type.';
msgs['TES23024'] = 'There is no data to process.';
msgs['TES23025'] = 'There is no data to delete.';
msgs['TES23026'] = 'There is no data to print.';
msgs['TES23027'] = 'Already confirmed.';
msgs['TES23028'] = 'The service is not available now.';
msgs['TES23029'] = 'This is invalid column.';
msgs['TES23030'] = '{?msg1} duplicate.';
msgs['TES23031'] = 'Multi HEADER is retrieved.\n\n Please contact system manager.';
msgs['TES23032'] = 'You must enter {?msg1} and {?msg2}.';
msgs['TES23033'] = 'There is no data to confirm.';
msgs['TES23034'] = 'There is modified data on Verification/Discrepancy tab.\n\n Do you want to ignore and confirm?';
msgs['TES23035'] = '{?msg1} is modified.\n\n Please save basic data first.';
msgs['TES23036'] = 'Error occurred on Cost Group Code';
msgs['TES23037'] = 'Saved {?msg1} and calculated {?msg2} do not match.';
msgs['TES23038'] = 'Period date and saved date do not match.\n\n Please save or modify the Period.';
msgs['TES23039'] = 'This is confirmed status.\n\n Do you want to cancel and modify confirmed status?';
msgs['TES23040'] = 'This is Approval Request processed status.';
msgs['TES23041'] = 'This is A/P Interface processed status.';
msgs['TES23042'] = 'This is rejected status.\n\n Do you want to cancel and save rejected status?';
msgs['TES23043'] = 'Multi HEADER is retrieved.\n\n Please contact system manager.';
msgs['TES23044'] = 'Confirm processed status';
msgs['TES23045'] = 'Please select Cost Code.';
msgs['TES23046'] = 'There is no Cost Group code.';
msgs['TES23047'] = 'There is no container no.';
msgs['TES23048'] = 'There is no important DATA TYPE.\n\n Please contact system manager.';
msgs['TES23049'] = 'An error occurred on a mandatory item.';
msgs['TES23050'] = 'It can not be processed anymore because an error occurred on {?msg1}.';
msgs['TES23051'] = 'There is no data to verify.';
msgs['TES23052'] = 'Verify completed status';
msgs['TES23053'] = 'Do you want to delete all data on Verification, Discrepancy, Cost Calc.(TMNL), Cost Calc.(SR by FD) Tab?';
msgs['TES23054'] = 'There is invalid row.\n\n Do you want to delete?';
msgs['TES23055'] = '{?msg1} wrong data are found.\n\n Please modify them on file and reload it.';
msgs['TES23056'] = 'It cannot be processed anymore because an error occurred on {?msg1}.';
msgs['TES23057'] = 'Please upload data.';
msgs['TES23058'] = 'Verification of {?msg1}.\n\n List has been completed.';
msgs['TES23059'] = 'Duplicate';
msgs['TES23060'] = 'There is new data.\n\n Please save first.';
msgs['TES23061'] = 'Please enter cost code first.';
msgs['TES23062'] = 'Yard Code has been changed.\n\n Do you want to delete all data on Verification, Discrepancy, Cost Calc.(SR by FD)and Cost Calc.(SR by FP) and Cost Calc.(SR by EQ) Tab?';
msgs['TES23063'] = 'Reject process completed.';
msgs['TES23064'] = 'End date on Period does not match. Can not process';
msgs['TES23065'] = 'There is error on Period.';
msgs['TES23066'] = 'Please delete all sheets and modify Yard, Cost OFC, and calc Storage Combo Items';
msgs['TES23068'] = 'Do you want to move to Verification?';
msgs['TES23069'] = 'Do you want to move to Discrepancy?';
msgs['TES23070'] = 'Auto Calculation Data on Cal Tab will be cleared.\n\n Do you want to modify?';
msgs['TES23071'] = 'There is entered data already.\n\n Do you want to retrieve?';
msgs['TES24001'] = 'Cost OFC does not match Yard Code.';
msgs['TES24002'] = 'An error occurred while confirming Yard Code of Cost OFC.';
msgs['TES24003'] = '';
msgs['TES24004'] = 'Please delete all sheets and modify Yard, Cost OFC and calc Storage Combo Items';
msgs['TES24005'] = 'There is no Remarks at Hold.';
msgs['TES24006'] = 'This is invalid {?msg1}.';
msgs['TES24007'] = '{?msg1} is not entered.';
msgs['TES24008'] = '{?msg1} was invalid.';
msgs['TES24009'] = 'An error occurred on {?msg1}.';
msgs['TES24010'] = 'You must select {?msg2} item when you check {?msg1}.';
msgs['TES24011'] = 'Date format is wrong.';
msgs['TES24012'] = 'Start date must be earlier than end date.';
msgs['TES24013'] = 'There is Sheet to confirm before saving. DO you want to move?';
msgs['TES24014'] = 'There is a lack of data for pop-up display.';
msgs['TES24015'] = 'There is no data to delete.';
msgs['TES24016'] = 'Please enter start date & end date of Period.';
msgs['TES24017'] = 'Basic data error';
msgs['TES24018'] = 'There is no data modified.';
msgs['TES24019'] = 'There is no row selected.';
msgs['TES24020'] = 'There is data to save.\n\n Please save first.';
msgs['TES24021'] = 'There is data modified.\n\n Please save first.';
msgs['TES24022'] = 'You must enter start date of Period.';
msgs['TES24023'] = 'There is no calculation type.';
msgs['TES24024'] = 'There is no data to process.';
msgs['TES24025'] = 'There is no data to delete.';
msgs['TES24026'] = 'There is no data to print.';
msgs['TES24027'] = 'Already confirmed.';
msgs['TES24028'] = 'The service is not available now.';
msgs['TES24029'] = 'This is invalid column.';
msgs['TES24030'] = '{?msg1} duplicated.';
msgs['TES24031'] = 'Multi HEADER is retrieved.\n\n Please contact system manager.';
msgs['TES24032'] = 'You must enter {?msg1} and {?msg2}.';
msgs['TES24033'] = 'There is no data to confirm.';
msgs['TES24034'] = 'There is modified data on Verification/Discrepancy tab.\n\n Do you want to ignore and confirm?';
msgs['TES24035'] = '{?msg1} has been changed.\n\n Please save basic data.';
msgs['TES24036'] = 'Error occurred on Cost Group Code';
msgs['TES24037'] = 'Saved {?msg1} and calculated {?msg1} do not match.';
msgs['TES24038'] = 'Period date and saved date do not match.\n\n Please save or modify Period.';
msgs['TES24039'] = 'Confirmed status.\n\n Do you want to cancel confirm status and modify them?';
msgs['TES24040'] = 'Approval Request processed status.';
msgs['TES24041'] = 'A/P Interface processed status.';
msgs['TES24042'] = 'Rejected status.\n\n Do you want to cancel reject status and modify them?';
msgs['TES24043'] = 'Multi HEADER is retrieved.\n\n Please contact system manager.';
msgs['TES24044'] = 'Confirm processed status';
msgs['TES24045'] = 'Please select Cost Code.';
msgs['TES24046'] = 'There is no Cost Group code.';
msgs['TES24047'] = 'There is no container No.';
msgs['TES24048'] = 'There is no important DATA TYPE.\n\n Please contact system manager.';
msgs['TES24049'] = 'An error occurred on mandatory item.';
msgs['TES24050'] = 'It cannot be processed anymore because an error occurred on {?msg1}.';
msgs['TES24051'] = 'There is no data to verify.';
msgs['TES24052'] = 'Verify completed status';
msgs['TES24053'] = 'Do you want to delete all data on Verification, Discrepancy, Cost Calc.(TMNL), Cost Calc.(SR by FD) Tab?';
msgs['TES24054'] = 'This is invalid row.\n\n Do you want to delete?';
msgs['TES24055'] = 'There is {?msg1} wrong data.\n\n Please modify the file and reload.';
msgs['TES24056'] = 'It cannot be processed anymore because an error occurred on {?msg1}.';
msgs['TES24057'] = 'Please upload data.';
msgs['TES24058'] = '{?msg1} List has been verified.';
msgs['TES24059'] = 'Duplicate';
msgs['TES24060'] = 'There is new data.\n\n Please save first.';
msgs['TES24061'] = 'Please enter cost code first.';
msgs['TES24062'] = 'Yard Code has been changed.\n\n Do you want to delete all data on Verification, Discrepancy, Cost Calc.(SR by FD)and Cost Calc.(SR by FP) Tab?';
msgs['TES24063'] = 'Reject process has been completed.';
msgs['TES24064'] = 'End date on Period does not match.\n\n Can not process';
msgs['TES24065'] = 'Error occurred on period';
msgs['TES24066'] = 'Delete all sheets and modify Yard, Cost OFC and calc Storage Combo Items.';
msgs['TES24067'] = 'Do you want to delete all data on Cost Calc.(SR by EQ) Tab?';
msgs['TES24068'] = 'Do you want to move to Verification?';
msgs['TES24069'] = 'Do you want to move to Discrepancy?';
msgs['TES24070'] = 'Cal Tab Auto Calculation Data will be cleared.\n\n Do you want to modify?';
msgs['TES24071'] = 'There are entered data.\n\n Do you want to retrieve?';
msgs['TES25001'] = 'There is no invoice no checked.\n\n Please check again.';
msgs['TES25002'] = 'Please select evidence type.';
msgs['TES25003'] = 'Please enter input items on Tax accounts of evidence or Accounts popup screen.';
msgs['TES25004'] = 'There is no data to process.';
msgs['TES25005'] = 'There is no CSR_NO paid.';
msgs['TES25006'] = 'There is no data retrieved.';
msgs['TES25007'] = 'Multi HEADER is retrieved.\n\n Please contact system manager.';
msgs['TES25008'] = 'Invoice No toal tax amount differs from the entered tax amount.\n\n Please check again.';
msgs['TES25009'] = 'Invoice No consultation amount differs from entered total amount.\n\n Please check again.';
msgs['TES25010'] = 'Please check tax account No. again.';
msgs['TES25011'] = 'Please check Profit/Loss type.';
msgs['TES25012'] = 'Please check Tax Type.';
msgs['TES25013'] = 'This is a worng company registration No.\n\n Please check again.';
msgs['TES25014'] = 'There is no names of goods and amount entered for tax accounts.\n\n Please check again.';
msgs['TES25015'] = 'Tax accounts items have been saved.';
msgs['TES25016'] = 'Accounts items have been saved.';
msgs['TES25017'] = 'Please select data row on Sheet.';
msgs['TES25018'] = 'Could not use CSR Creation screen because there is no country code on session information.';
msgs['TES25019'] = 'If you select others there is no contents to enter.';
msgs['TES25020'] = 'There is no Approval Step.\n\n Please check again.';
msgs['TES25021'] = 'Approval Request has been completed.';
msgs['TES25022'] = 'Total amount is more than 0.\n\n Please check profit.';
msgs['TES25023'] = 'Total amount is less than 0.\n\n Please check loss.';
msgs['TES25024'] = 'Tax amount is 0.\n\n Please check free of tax.';
msgs['TES25025'] = 'Tax amount is more than 0.\n\n Please check taxable.';
msgs['TES25026'] = 'There is no commodity name entered.\n\n Please check again.';
msgs['TES25027'] = 'It is impossible to create anymore.';
msgs['TES25028'] = 'Issue date is out of range.\n\n Please check again.';
msgs['TES25029'] = 'Entered issue date is wrong.\n\n Please check again.';
msgs['TES25030'] = 'Please check No. of the accounts.';
msgs['TES25031'] = 'There is no commodity name and amount for the accounts.\n\n Please check again.';
msgs['TES31001'] = 'Do you want to process reject?';
msgs['TES40001'] = 'There is no relevant data.\n\n Do you want to create data with the Inv. No.?';
msgs['TES40002'] = '{?msg1} has not been saved.';
msgs['TES40003'] = 'Agreement status has not been retrieved.\n\n Please contact PIC of Agreement.';
msgs['TES40004'] = 'Agreement is being modified.\n\n Please contact PIC of Agreement.';
msgs['TES40005'] = 'Agreement does not exist.\n\n Please contact PIC of Agreement.';
msgs['TES40006'] = 'Approval Request has been processed.';
msgs['TES40007'] = 'CNTR LIST has not been saved.\n\n Please enter new VVD after save CNTR LIST.';
msgs['TES40008'] = 'CNTR Type Size, F/M, DG and Working Date are mandatory items.\n\n Please check.';
msgs['TES40009'] = 'Auto Calculation result on Cal Tab will clear.\n\n Do you want to process?';
msgs['TES40010'] = 'Has been Confirmed.';
msgs['TES40011'] = 'Please select one among Cost Calc. Method.';
msgs['TES40012'] = 'Do you want to delete all data on Cost Calc.(SR by FP) Tab?';
msgs['TES40013'] = 'Cost Calculation result has not been saved.\n\n Please enter new VVD after save.';
msgs['TES40014'] = 'Cost Calculation has not been done.\n\n Please enter new VVD after caluculation & saving.';
msgs['TES40015'] = '{?msg1} has been omitted.';
msgs['TES40016'] = 'Please enter all {?msg1}.';
msgs['TES40017'] = 'File has not been imported.';
msgs['TES40018'] = 'There is no Cost Code on the Manual Input row.';
msgs['TES40019'] = 'This is Rejected Invoice.\n\n Do you want to do Reject Lift?';
msgs['TES40020'] = 'This is not Rejected invoice.';
msgs['TES40021'] = 'In case of SVXJO, Revised Vol. Popup could not be used.';
msgs['TES40022'] = 'Revised Vol / 3rd Party / Carrier are mandatory items on SVXXJO.';
msgs['TES40023'] = 'Do you want to select TPB target?';
msgs['TES40024'] = 'Please select TPB target.';
msgs['TES40025'] = 'Please enter {?msg1}.';
msgs['TES40026'] = '{?msg1} has not been entered.';
msgs['TES40027'] = 'Yard Code has been modified.\n\n Do you want to delete all data on Verification, Discrepancy, Cost Calc. Tab?';
msgs['TES40028'] = 'Currency code {?msg1} registered on agreement does not match currency code {?msg2} on current S/O header.';
msgs['TES40029'] = 'Currency code on agreement is being retrieved.\n\n Please calculate again.';
msgs['TES40030'] = 'Currency code on agreement could not be retrieved.';
msgs['TES40031'] = 'Invoice number does not exist.\n\n Would you like to create it as a new invoice?';
msgs['TES40032'] = 'Do you want to delete all data on {?msg1}?';
msgs['TES40033'] = '{?msg1} has been modified.\n\n You have to recalculate after clear calculated result.\n\n Do you want to process it?';
msgs['TES40034'] = '{?msg1} could not be deleted.';
msgs['TES40035'] = 'Status of reject';
msgs['TES40036'] = 'There is no ATB on S/O header.';
msgs['TES40037'] = 'Last date of the period on S/O header has not been saved.';
msgs['TES40038'] = 'Last date of the period on S/O header has not been entered.';
msgs['TES40039'] = 'Currency code of S/O header has not been selected.';
msgs['TES40040'] = 'Currency code of S/O header has not been saved.';
msgs['TES40041'] = '{?msg1} has been omitted.';
msgs['TES40042'] = 'An error occurred on {?msg1}.';
msgs['TES40043'] = 'Numbers of List has been verified.';
msgs['TES40044'] = 'Please contact your manager.';
msgs['TES40045'] = 'Status of basic data not saved.';
msgs['TES40046'] = 'Numbers of confirm data have been retrieved.\n\n Please contact your manager.';
msgs['TES40047'] = 'Numbers of reject header data have been retrieved.\n\n Please contact your manager.';
msgs['TES40048'] = 'There is no CSR No. on selected row.';
msgs['TES40049'] = 'There is no breakdown of modification.';
msgs['TES40050'] = 'These are registered data on {?msg1}.';
msgs['TES40051'] = 'This is invalid invoice status.\n\n Please contact your manager.';
msgs['TES40052'] = 'This is invalid {?msg1}.';
msgs['TES40053'] = 'There was calculated result already.\n\n Please calculate after delete the calculated result.';
msgs['TES40054'] = 'Entered VVD does not match VVD on CNTR List.';
msgs['TES40055'] = 'Auto/Manual Code has been omitted.';
msgs['TES40056'] = 'There is no data to save.';
msgs['TES40057'] = 'Do you want to save?';
msgs['TES40058'] = 'This is not exist {?msg1}.';
msgs['TES40059'] = 'Interim saving has been completed.';
msgs['TES40060'] = 'Duplicated';
msgs['TES40061'] = 'An error occurred on important factor.';
msgs['TES40062'] = 'There is no relevant data.\n\n Do you want to create it with the Invoice No.?';
msgs['TES40063'] = 'This is not confirmed {?msg1}.';
msgs['TES40064'] = 'Do you want to delete all data on Cost Calc.(SR by EQ) Tab?';
// TES - Agreement Creation
msgs['TES50101'] = 'No authority to correct/delete the agreement - Creation office mismatch!';
msgs['TES50102'] = 'Please insert correct time';
msgs['TES50103'] = 'code: {?msg1}, description: {?msg2}';
// TES - Agreement Inquiry ( Summary )
msgs['TES50201'] = 'No authority to correct/delete the agreement - Contract office mismatch!';
msgs['TES50202'] = 'No authority to make inquiry to the agreement with your log-in office. Only agreement details of yards in your region can be retrieved.';
msgs['TES50203'] = 'No authority to correct / delete the agreement with your log-in office.';
msgs['TES50204'] = 'No authority to make copy to the agreement with your log-in office. Only agreement of yards in your region can be selected.';
// TES - Agreement Inquiry ( Detail )
msgs['TES50301'] = 'Insert Agreement No & Agreement Version()Information!';
msgs['TES50302'] = 'Insert Agreement No!';
msgs['TES50303'] = 'Insert Correct Agreement No!';
msgs['TES50304'] = 'Insert Agreement Version()Information!';
msgs['TES50305'] = 'Insert Correct Agreement Version()Information!';
msgs['TES50306'] = 'No data at the Terminal Rate List';
msgs['TES50307'] = 'No data at the Storate Rate List';
//TES - Off-Dock
msgs['TES60101'] = 'Amount should be less than Total Amount.';
msgs['TES60102'] = 'Amount should be greater than 0.';
msgs['TES60103'] = 'Do you want to delete 3rd party?';
msgs['TES60104'] = 'You must enter {?msg1}.';
msgs['TES60105'] = '{?msg1} wrong data are found.';
msgs['TES60106'] = 'You must put same Fuel Rate as others.';
msgs['TES60107'] = '{?msg1} Row [{?msg2}]is mandantory item.';
// TES - Guarantee Creation
msgs['TES70101'] = 'Please enter Reference Number.';
msgs['TES70102'] = 'Please enter Customer Code.';
msgs['TES70103'] = 'Please enter CY Code.';
msgs['TES70104'] = 'Please enter Container No.';
msgs['TES70105'] = 'Please enter Amount.';
msgs['TES70106'] = 'Please enter Container List start date.';
msgs['TES70107'] = 'Please enter Container List end date.';
msgs['TES70108'] = 'TPB I/F IRR.';
msgs['TES70109'] = 'Please check length Reference Number.';
msgs['TES70110'] = 'Please check Guarantee after Retrieve.';
msgs['TES70111'] = 'This is invalid Customer Code.';
msgs['TES70112'] = 'Save Guarantee before proceeding.';
msgs['TES70113'] = 'Do you want to delete Guarantee?';
msgs['TES70114'] = 'TPB exists already. Please have it deleted first at TPB';
msgs['TES70115'] = 'Irregular exists already.';
msgs['TES70116'] = 'This is invalid Container No.';
msgs['TES70117'] = 'Container No. : {?msg1}, Booking No. : {?msg2} exists already.';
msgs['TES70118'] = 'Already Deleted.';
msgs['TES70119'] = 'Guarantee should be either TPB I/F Or Irregular to print out.';
msgs['TES70120'] = "More than one of CNTR has already been interfaced to TPB. Please check TPB status. \n\n(If you want to delete the data, all of CNTR's TPB status should be Non-TPB.)";
msgs['TES70121'] = 'No authority to correct/delete the Guarantee - Creation office mismatch!';
// Guarantee Inquiry
msgs['TES70201'] = 'Ref No, Office Code, or User ID is Mandatory';
msgs['TES70202'] = 'Send process is completed.';
msgs['TES70203'] = 'You must enter {?msg1} or {?msg2}.';
msgs['TES70204'] = 'This is invalid Office Code.';
msgs['TES70205'] = 'Check Vaild Office Code.';
// TES - Irregular Creation
msgs['TES70601'] = 'Please check Irregular after Retrieve.';
msgs['TES70602'] = 'Please enter Irregular Type.';
msgs['TES70603'] = 'This is invalid Depart.';
msgs['TES70604'] = 'Do you want to delete Irregular?';
msgs['TES70605'] = 'The service is not available.';
msgs['TES70606'] = 'No authority to correct/delete the Irregular - Creation office mismatch!';
msgs['TES70607'] = 'The cost was not calculated automatically at the invoice!';
msgs['TES70608'] = 'There is no calculation data at the invoice!';
// TES - Irregular Inquiry
msgs['TES70701'] = 'This Is Not A Guarantee.';
// TES - TPB If
msgs['TES70801'] = "You can't I/F minus amount";
msgs['TES70802'] = 'Please check charge type. The charge type is not registered on TPB.';
msgs['TES70803'] = '[multiTerminalInvoiceDetail] 3rd party is not exist.';
//TES - ON-DOCK
msgs['TES80101'] = 'Please enter MGSET.';
msgs['TES80102'] = 'Do you want to delete all data on Cost Calc.(Chassis/MG Set) Tab?';
//TES - Cost Manage
msgs['TES90101'] = 'Not Acceptable Cost Code. Try Again.';
// FileUpload
msgs['TES90102'] = 'It is NOT PDF file!';
msgs['TES90103'] = 'No file is selected'
msgs['TES90104'] = "{?msg1} are duplicated.";
msgs['TES90105'] = "Please select the location in China";
msgs['TES90106'] = "You can't change this data. Please delete first and insert if you want to change.";
msgs['TES90107'] = "There is modified data.Do you want to continue?";
msgs['TES90108'] = "Data saved successfully";
msgs['TES90109'] = "POD and POL are same.";

/*****************************************************************
 * 	이 JS FILE은 외부에서 TES공통기능을 호출하는 function을 구성
 ******************************************************************/
String.prototype.trim = function() {
        return this.replace(/(^\s*)|(\s*$)/g, "");
    }
    
/********************************************************************
 * 	// 2. TES Common Script
 * 
 ********************************************************************/
 
/*** 2009-08-17: tes_getComboItem()와 tes_getInputValue()에서 사용하는 iframe Id를 구성하기 위한 변수 ***/
var ifr_cnt = 1;

/**
 * 인자로 받은 문자열 중 HTML에서 변환문자를 특수문자로 바꿔서 결과를 리턴한다. <br>
 * @param {string,object} obj   필수,문자열 또는 HTML태그(Object)
 * @returns string <br>
 */
function ComToString(obj) {
    try {
        //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
        var str = getArgValue(obj);
        str = str.replace(/&amp;/g, '&');
        str = str.replace(/&lt;/g, '<');
        str = str.replace(/&gt;/g, '>');
        str = str.replace(/&#44;/g, ',');
        str = str.replace(/&quot;/g, '\"');
        str = str.replace(/&apos;/g, '\'');
        str = str.replace(/&ffd;/g, '\n');
        str = str.replace(/&cgrtn;/g, '\r');
        return str;
    } catch (err) {
        ComFuncErrMsg(err.message);
    }
}

/**
 * 2009-07-17 : 필수값 표시 땜질.<br>
 * 젠장 OPUS에서는 *를 제거하고 입력란 자체를 퍼렇게 칠해서 할 수 없이 꽁수로 무조건 필요한 만큼 (TEXT INPUT만) 무조건 퍼렇게 설정하기..<br>
 * 기존 enableObject/diisableObject어쩌구저쩌구를 실행한 후 본 function을 설정한다.<br>
 * 
 * @param {Object}	formObj  	Form Object
 * @param {String}	eleNms		Element Names
 */
function tes_set_man_input_item(formObj, eleNms) {
    if (eleNms == undefined || eleNms == null ||
        formObj == undefined || formObj == null) {
        return false;
    }
    var numOfEle = formObj.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        for (var j = 0; eleNms != null && j < eleNms.length; j++) {
            if (formObj.elements[i].name == eleNms[j]) {
                formObj.elements[i].className = "input1";
            }
        }
    }
}

/**
 * 내부적으로 tes_getComboItem()와 tes_getInputValue()에서 생성한 모든 iframe들을 사용 완료 후 제거한다.<br>
 **/
function tes_removeTESCommonALLIframes() {
    /*******************
     2009-08-17: 내부적으로 tes_getComboItem()와 tes_getInputValue()에서 생성한 모든 iframe들을 사용 완료 후 제거한다.
     *******************/
    try {
        var f = document.frames;
        var elt;
        for (var i = 0; i <= ifr_cnt; i++) {
            elt = document.getElementById('tes_com_frame_' + i);
            if (elt != 'undefined' && elt != null) {
                //elt.removeNode(true);
                elt.parentNode.removeChild(elt);
            }
        }
    } catch (e) {}
}

/**
 * 내부적으로 tes_getComboItem()와 tes_getInputValue()에서 인자로 주어진 ifrId로 생성된 iframe을 사용 완료 후 제거한다.<br>
 * remove~ function호출 이후 완전히 제거되는데는 수초가 걸릴수도 있다.<br>
 * 
 * @param {String}		ifrId  			Id
 **/
function tes_removeTESCommonIframe(ifrId) {
    /*******************
     2009-08-17: 내부적으로 tes_getComboItem()와 tes_getInputValue()에서 인자로 주어진 ifrId로 생성된 iframe을 사용 완료 후 제거한다.
    			 remove~ function호출 이후 완전히 제거되는데는 수초가 걸릴수도 있다.
     *******************/
    try {
        var elt;
        if (ifrId != null && ifrId != '') {
            elt = document.getElementById(ifrId);
            if (elt != 'undefined' && elt != null) {
                //elt.removeNode(true);
                elt.parentNode.removeChild(elt);
            }
        }
    } catch (e) {}
}

/**
 * TES Common Select 값을 조회 설정 처리한다. 
 * 
 * @param {String}		coid  			coid
 * @param {int,String}	idx  			index
 * @param {String}		f_cmd  			Form Command
 * @param {String}		def  			def
 * @param {String}		paramName  		SC 처리할 Name
 * @param {String}		functionName	호출할 Function Name
 **/
function tes_getComboItem(coid, idx, f_cmd, def, paramName, functionName) {
    if (coid == undefined) {
        coid = '';
    } else if (idx == undefined) {
        idx = '';
    } else if (f_cmd == undefined) {
        f_cmd = '';
    } else if (def == undefined) {
        def = '';
    } else if (paramName == undefined) {
        paramName = '';
    } else if (functionName == undefined) {
        functionName = '';
    }
    var f = document.frames;
    var ifr = "tes_com_frame_" + (ifr_cnt++);
    var o = document.createElement("DIV");
    o.style.display = "none";
    o.innerHTML = '<iframe name="' + ifr + '"  id="' + ifr + '" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
    document.body.appendChild(o);
    var param = '';
    arr_param = paramName.split('|');
    for (var i = 0; i < arr_param.length; i++) {
        if (arr_param[i] != "") {
            param = param + "&" + arr_param[i] + "=" + eval("document.all." + arr_param[i]).value;
        }
    }
    eval("document." + ifr).location.href = "TESCommon.screen?mode=COMBO&coid=" + coid + "&idx=" + idx + "&f_cmd=" + f_cmd + "&def=" + def + "&functionName=" + functionName + "&ifrId=" + ifr + "&" + param;
}

/**
 * TES Common Input 값을 조회 설정 처리한다. 
 * 
 * @param {String}  	coid			coid
 * @param {String}		f_cmd  			Form Command
 * @param {String}		paramName		SC 처리할 Name
 * @param {String}		functionName	호출할 Function Name
 **/
function tes_getInputValue(coid, f_cmd, paramName, functionName) {
    if (coid == undefined) {
        coid = '';
    } else if (f_cmd == undefined) {
        f_cmd = '';
    } else if (paramName == undefined) {
        paramName = '';
    } else if (functionName == undefined) {
        functionName = '';
    }
    var f = document.frames;
    var ifr = "tes_com_frame_" + (ifr_cnt++);
    var o = document.createElement("DIV");
    o.style.display = "none";
    o.innerHTML = '<iframe name="' + ifr + '"  id="' + ifr + '" scrolling="no" frameborder="" width="100" height="100"></iframe>';
    document.body.appendChild(o);
    var param = '';
    arr_param = paramName.split('|');
    for (var i = 0; i < arr_param.length; i++) {
        if (arr_param[i] != "") {
            param = param + "&" + arr_param[i] + "=" + eval("document.all." + arr_param[i]).value;
        }
    }
    if (eval("document." + ifr) == undefined) {
        eval("window." + ifr).location.href = "TESCommon.screen?mode=INPUT&coid=" + coid + "&f_cmd=" + f_cmd + "&functionName=" + functionName + "&ifrId=" + ifr + "&" + param;
    } else {
        eval("document." + ifr).location.href = "TESCommon.screen?mode=INPUT&coid=" + coid + "&f_cmd=" + f_cmd + "&functionName=" + functionName + "&ifrId=" + ifr + "&" + param;
    }
}

/**
 * TES Common 우측 문자 붙이기. 
 * 
 * @param {String}		src		Source
 * @param {int,String}  len		길이(Length)
 * @param {int,String}	pad		pad 값
 **/
function tes_rpad(src, len, pad) {
    try {
        if (src == undefined || src == null || isNaN(len) || pad == undefined || pad == null) {
            return (src == undefined || src == null ? '' : src);
        }
        src = new String(src);
        src = ComTrim(src);
        pad = new String(pad);
        pad = ComTrim(pa);
        if (ComTrim(src) == '' || ComTrim(pad) == '') {
            return (src == undefined || src == null ? '' : src);
        }
        var retval = '';
        var padCnt = Number(len) - src.length;
        for (var i = 0; i < padCnt; i++) {
            retval += pad;
        }
        retval = src + retval;
    } catch (e) {
        return src; //'';
    }
    return retval;
}

/**
 * TES Common 좌측 문자 붙이기. 
 * 
 * @param {String}		src		Source
 * @param {int,String}  len		길이(Length)
 * @param {int,String}	pad		pad 값
 **/
function tes_lpad(src, len, pad) {
    try {
        if (src == undefined || src == null || isNaN(len) || pad == undefined || pad == null) {
            return (src == undefined || src == null ? '' : src);
        }
        src = new String(src);
        src = src.trim();
        pad = new String(pad);
        pad = pad.trim();
        if (src == '' || pad == '') {
            return (src == undefined || src == null ? '' : src);
        }
        var retval = '';
        var padCnt = Number(len) - src.length;
        for (var i = 0; i < padCnt; i++) {
            retval += pad;
        }
        retval = retval + src;
    } catch (e) {
        return src; //'';
    }
    return retval;
}

/**
 * TES Common 툴팁 박스 설정. 
 * 
 * @param {sheet}	sheetObj	IBSheet Object
 * @param {String}	col_arg		Column Argument
 **/
function setTooltip(sheetObj, col_arg) {
    try {
        if (sheetObj != null && sheetObj.RowCount() > 0 && col_arg != undefined && col_arg != null && col_arg != '') {
            var col_arr = col_arg.split('|');
            for (var j = 0; col_arr != null && j < col_arr.length; j++) {
                for (var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
                    if (sheetObj.GetCellValue(i, col_arr[j]) != undefined && sheetObj.GetCellValue(i, col_arr[j]) != null && sheetObj.GetCellValue(i, col_arr[j]) != '') {
                        sheetObj.SetToolTipText(i, col_arr[j], sheetObj.GetCellValue(i, col_arr[j]));
                    }
                }
            }
        }
    } catch (e) { //혹시 오류가 발생해도 나머지 src에 영향을 주지 않기 위해 아무것도 하지않는당.. 아무 이유 없어~
    }
}

/**
 * TES Common 해당하는 월의 요일수 구하기. 
 * 
 * @param {String}	sdate	Date
 **/
function tes_getMonthLength(sdate) {
    sdate = new String(sdate);
    sdate = sdate.substring(0, 8);
    var tyy = sdate.substring(0, 4);
    var tmm = sdate.substring(4, 6) - 1;
    var tdd = sdate.substring(6, 8);
    switch (tmm) {
        case 1:
            if ((tyy % 4 == 0 && tyy % 100 != 0) || tyy % 400 == 0)
            //if ((tyy%4==0) && (tyy%100!=0 || tyy%400==0))
                return 29; // leap year
            else
                return 28;
        case 3:
            return 30;
        case 5:
            return 30;
        case 8:
            return 30;
        case 10:
            return 30
        default:
            return 31;
    }
}

/**
 * TES Common Sheet Row 복사하기.<br>
 * Sheet To Sheet 소스 IBSheet에서 목적 IBSheet로 Row Copy/Move.<br> 
 *  
 * @param {ibsheet}		orig_obj	Row를 이동할 소스 Sheet
 * @param {ibsheet}		dest_obj	Row를 이동할 목적 Sheet
 * @param {int,string}	chkColName	대상이 되는 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
 * @param {String}		queryStr	각자 알아서 넘길것들을 정의
 * @param {boolean}		bRowDel		선택,대상행삭제여부, default=false
 * @param {boolean}		bRowDel		선택,대상행삭제여부, default=false
 * @param {boolean}    	allSave     필수,sheet 전체를 xml string으로 만들지 여부[true/false]
 **/
function tes_copy_rows_to(src_obj, dest_obj, chkColName, queryStr, bRowDel, allSave) {
    if (src_obj == undefined || src_obj == null) {
        return false;
    }
    
    if (dest_obj == undefined || dest_obj == null) {
        return false;
    }
    
    if (chkColName == undefined || chkColName == null) {
        return false;
    }
    
    if (queryStr == undefined || queryStr == null) {
        queryStr = '';
    }
    
    if (bRowDel == undefined || bRowDel == null || bRowDel != false) {
        bRowDel = true;
    }
    
    if (allSave == undefined || allSave == null || allSave != true) {
        allSave = false;
    }
    
    var arrColParams = queryStr.split("\&");
    var colNames = "";
    
    for (var i = 0; i < arrColParams.length; i++) {
        var arrColNms = arrColParams[i].split("=", 2);
        if (i == 0) {
            colNames = arrColNms[0];
        } else {
            colNames = colNames + "|" + arrColNms[0];
        }
    }
    // CoObjcet.js (ComMakeSearchXml) 참고
    var sXml = ComMakeSearchXml(src_obj, allSave, chkColName, colNames, bRowDel);
    dest_obj.LoadSearchData(sXml, { Append: 1, Sync: 1 });
 }
 
/**
 * 
 * @param dest_obj
 * @param queryStr
 * @param appendMode
 * @return
 */
function tes_copy_rows_to2(dest_obj, queryStr, appendMode) {
    /*****
    <주> 반드시 ibflag을 넘겨야 제대로 동작한데이...  prefix를 쓰는경우는 prefix를 request로 넘겨야 하구 없으면 넘기지 말구..
    dest_obj: row를 이동할 목적 sheet, queryStr: 각자 알아서 넘길것들을 정의, appendMode: true이면 뒤에 붙인다.
    ******/
    if (dest_obj == undefined || dest_obj == null) {
        return false;
    }
    if (queryStr == undefined || queryStr == null) {
        queryStr = '';
    }
    if (appendMode == undefined || appendMode == null || appendMode != true) {
        appendMode = false;
    }
    dest_obj.DoSearch("TESCommon2GS.do", queryStr + "&f_cmd=" + SEARCHLIST08 + "&coid=1", { Append: appendMode });
}

/**
 * TES Common Agreement Sheet Row 복사하기.<br>
 * Sheet To Sheet 소스 IBSheet에서 목적 IBSheet로 Row Copy/Move.<br> 
 *  
 * @param {ibsheet}		orig_obj	Row를 이동할 소스 Sheet
 * @param {ibsheet}		dest_obj	Row를 이동할 목적 Sheet
 * @param {String}		queryStr	각자 알아서 넘길것들을 정의
 * @param {boolean}		bRowDel		선택,대상행삭제여부, default=false
 * @param {boolean}    	allSave     필수,sheet 전체를 xml string으로 만들지 여부[true/false]
 * @param {string}    	sheetNo     필수,sheet No.
 **/
function tes_agmt_copy_rows_to(src_obj, dest_obj, queryStr, bRowDel, allSave, sheetNo) {
    if (src_obj == undefined || src_obj == null) {
        return false;
    }
    if (dest_obj == undefined || dest_obj == null) {
        return false;
    }
    if (queryStr == undefined || queryStr == null) {
        queryStr = '';
    }
    if (bRowDel == undefined || bRowDel == null || bRowDel != false) {
        bRowDel = true;
    }
    if (allSave == undefined || allSave == null || allSave != true) {
        allSave = false;
    }
    // CoObjcet.js (ComMakeSearchXml) 참고
    var allXml = "";
    var sColOrder = "";
    var colNames = "";
    for (var i = 0; i <= src_obj.LastCol(); i++) {
        // Remark 표시용 추가. ( 2010-05-10 )
        if (src_obj.ColSaveName(i) == "3agmt_dtl_rmk" ||
            src_obj.ColSaveName(i) == "5agmt_dtl_rmk"
        ) {
            colNames = colNames + "|" + sheetNo + "remark";
        }
        colNames = colNames + "|" + src_obj.ColSaveName(i);
    }
    if (colNames != undefined && colNames != null && colNames != "") {
        sColOrder = " COLORDER='" + colNames + "' ";
    }
    allXml = "<?xml version='1.0'  ?>\n" + "<SHEET>\n"
    allXml += "  <DATA TOTAL='" + src_obj.GetTotalRows() + "' " + sColOrder + ">\n";
    var aryTR = new Array(src_obj.LastRow() - src_obj.HeaderRows());
    var aryTD = new Array(src_obj.LastCol());
    for (ir = src_obj.HeaderRows(); ir <= src_obj.LastRow(); ir++) {
        var strTD = "";
        for (ic = 0; ic <= src_obj.LastCol(); ic++) {
            // Remark 표시용 추가. ( 2010-05-10 )
            if (src_obj.ColSaveName(ic) == "3agmt_dtl_rmk" ||
                src_obj.ColSaveName(ic) == "5agmt_dtl_rmk"
            ) {
                strTD = strTD + "<TD><![CDATA[" + String(src_obj.GetCellValue(ir, ic)) + "]]></TD>";
            }
            //TD-셀의 값을 변수에 저장한다.
            strTD = strTD + "<TD><![CDATA[" + String(src_obj.GetCellValue(ir, ic)) + "]]></TD>";
        }
        // 앞 한셀은 빈값 채워주기 위해 (STS값 안넣어주면 제대로 들어가지 않는다.) 2009-10-13
        aryTR[ir - src_obj.HeaderRows()] = "    <TR><TD></TD>" + strTD + "</TR>";
    }
    if (bRowDel) src_obj.RemoveAll();
    allXml += aryTR.join("\n");
    allXml += "  </DATA>\n" + "</SHEET>";
    dest_obj.LoadSearchData(allXml, { Append: 1, Sync: 1 });
}

/**
 * TES Common Enter Check.
 * 
 * @param {String}	funcNm	Function Name
 **/
function tes_enterCheck(funcNm) {
    if (funcNm == undefined || funcNm == null || ComTrim(funcNm) == '') {
        return false;
    }
    if (event.keyCode == 13) {
        eval(funcNm + '()');
    }
}

/**
 * [Period] 유효성 체크
 * @param {string]	obj		날짜
 * @return
 */
function tes_validateDateObj(obj) {
    if (obj.readOnly == true) {
        return false;
    }
    obj.value = ComTrim(obj.value);
    if (obj.value == null || ComTrim(obj.value) == '') {
        return false;
    }
    if (!tes_checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value, '-')) {
        return false;
    }
    return true;
}

/**
 * TES Common regular expression을 통과해도 진짜 날짜 유형 객체에 적합한지 검사한다.<br>  
 * 사용예: 2006-11-00은 정규식은 통과하지만, 사실상 유효하지 않는 날짜이다.<br>
 * 
 * @param {String}	str_date	Date
 * @param {String}	del			delete 구분자
 **/
function tes_isValidDateObject(str_date, del) {
    if (del == undefined || del == null || ComTrim(del) == '') {
        del = '-';
    }
    var arr_date = str_date.split(del);
    var obj_date = new Date(arr_date[0], arr_date[1] - 1, arr_date[2]);
    var result = (1 * arr_date[0] == obj_date.getFullYear() && 1 * arr_date[1] == (obj_date.getMonth() + 1) && 1 * arr_date[2] == obj_date.getDate());
    if (result) {
        return true;
    } else {
        return false;
    }
}

/**
 * Period 형식 체크
 * @param {string}	obj	날짜
 * @return
 */
function tes_checkPeriodFormat(obj) {
    var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
    if (!tes_checkFormat2(obj, date_regexp)) {
        return false;
    } else {
        return true;
    }
}

/**
 * TES Common Check Format  .<br>
 * 사용예:  regexp = "^(\\d{4}-\\d{2}-\\d{2})$";.<br>
 * 
 * @param {String}	src		Source String
 * @param {String}	regexp	정규표현식
 **/
function tes_checkFormat(src, regexp) {
    if (src == null || src == '' || regexp == null || regexp == '') {
        return false;
    }
    re = new RegExp(regexp, "gi");
    if (!re.test(src)) {
        return false;
    } else {
        return true;
    }
}

/**
 * TES Common Check Format.<br>  
 * 사용예:  regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;.<br.
 * 
 * @param {String}	src		Source String
 * @param {String}	regexp	정규표현식
 **/
function tes_checkFormat2(src, regexp) {
    if (src == null || src == '' || regexp == null || regexp == '') {
        return false;
    }
    result = (regexp.test(src));
    if (!result) {
        return false;
    } else {
        return true;
    }
}

/**
 * TES Common 주어진 sheet에서 하나라도 신규data가 있는지 확인
 * 
 * @param {ibsheet}		sheets		IBSheet Objects
 **/
function tes_isAllDataSaved(sheets) {
    var tes_isAllDataSaved = true;
    for (var i = 0; i < sheets.length; i++) {
        for (var j = 1; j <= sheets[i].RowCount(); j++) {
            if (sheets[i].GetCellValue(j, 'ibflag') == 'I') {
                tes_isAllDataSaved = false;
                break;
            }
        }
    }
    return tes_isAllDataSaved;
}

/**
 * TES Common 주어진 sheet 에서 하나라도 수정되거나 신규data가 있는지 확인.<br> 
 * 단 sheet 에 status 를 확인할 column 이 존재하야 한다.<br>
 * 
 * @param {sheet}	sheets		IBSheet Objects
 * @param {String}	params		parameters
 **/
function tes_isModified(sheets, params) {
    var returnValue = false;
    for (i = 0; i < sheets.length; i++) {
        if (sheets[i].IsDataModified() && params[i].length > 0)
            returnValue = true;
    }
    return returnValue;
}

/**
 * TES Common 주어진 sheet에서 하나라도 수정되거나 신규data가 있는지 확인.<br> 
 * 단 sheet에 status를 확인할 col이 존재하야 한다.<br>
 * 
 * @param {sheet}	sheets		IBSheet Objects
 **/
function tes_isModified2(sheets) {
    var returnValue = false;
    for (i = 0; i < sheets.length; i++) {
        if (sheets[i].IsDataModified())
            returnValue = true;
    }
    return returnValue;
}

/**
 * TES Common Focus 이동
 * 사용예: onKeyup="javascript:tes_moveFocus(this, this.form.to_prd_dt, 10);"
 * 
 * @param {Object}		fromFormElement		from Form Element
 * @param {Object}		toFormElement		이동할 요소
 * @param {int,String}	numleng				number length
 **/
function tes_moveFocus(fromFormElement, toFormElement, numleng) {
    var eleLeng = fromFormElement.value.length;
    if (eleLeng >= numleng) {
        toFormElement.focus();
    }
}

/**
 * TES Common Popup 창 위치 설정.<br>
 * ex) window.open('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=hld_rmk','popup_remarks',tes_getPopupPosition(300,150)+'width=300px, height=150px, location=0, status=0, resizable=1');.<br>
 * 
 * @param {int,String}	winWidth		Window Width
 * @param {int,String}	winHeight		Window Height
 **/
function tes_getPopupPosition(winWidth, winHeight) {
    TopPosition = (screen.height) ? (screen.height - winHeight) / 2 : 0;
    LeftPosition = (screen.width) ? (screen.width - winWidth) / 2 : 0;
    var position = 'top=' + TopPosition + ', left=' + LeftPosition + ', ';
    return position;
}

/**
 * TES Common Readonly Text Type 배경색 설정
 * 
 * @param {String}	formObj		Form Object
 **/
//	function tes_setBackColorAllTextTypeReadonly(formObj) {
//		var numOfEle = formObj.elements.length;
//		for (var i = 0; i < numOfEle; i++){
//			if (formObj.elements[i].type == 'text'){
////				set_TextReadonly(formObj.elements[i], formObj.elements[i].readOnly);
//				ComEnableObject(formObj.elements[i], true)
//			}
//		}
//	}
function tes_setBackColorAllTextTypeReadonly(formObj, eleNms) {
    var numOfEle = formObj.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        if (formObj.elements[i].type == 'text') {
            //2009.09.07 추가 - 이정혜
            formObj.elements[i].className = "input";
            ComEnableObject(formObj.elements[i], formObj.elements[i].readOnly == true ? false : true);
            //set_TextReadonly(formObj.elements[i], formObj.elements[i].readOnly);
            for (var j = 0; eleNms != null && j < eleNms.length; j++) {
                /* 2009-07-17 : opus에서 필수값 표현 변경으로 무조건 필수 CLASS적용하기 추가 */
                if (formObj.elements[i].name == eleNms[j]) {
                    formObj.elements[i].className = "input1";
                }
            }
        }
    }
}

/**
 * TES Common Input 값 체크
 * 
 * @param {String}	obj		체크할 Input Object
 **/
function tes_chkInput(obj) {
    if (obj.maxLength < tes_getStrLen(obj.value)) {
        obj.value = '';
        obj.focus();
        return false;
    }
}

/**
 * TES Common Currency 소수점 이하 제거
 * 
 * @param {String}	currCD		CURRENCY CDDE(통화 코드)
 **/
function tes_isNoDecimalPointCurrCD(currCD) {
    var arr_curr = new Array('KRW', 'JPY', 'TWD'); //소숫점 이하 제한 통화 단위들
    for (var i = 0; currCD != undefined && currCD != null && arr_curr != null && i < arr_curr.length; i++) {
        if (arr_curr[i] != undefined && arr_curr[i] == currCD) {
            return true;
        }
    }
    return false;
}

/**
 * TES Common 통화만 사용 -> 숫자,.까지  + 소숫점 이하 2자리만 허용
 * 
 * @param {Object}	obj			Object
 * @param {String}	isChkFmt	Format Check 할지 여부(Y/N)
 * @param {String}	curr_cd		CURRENCY CODE(통화 코드)
 **/
function tes_isMon(obj, isChkFmt, curr_cd) {
    if (!ComIsNumber(obj, '-.,')) {
        obj.value = '';
    }
    if (isChkFmt != undefined && isChkFmt != null && isChkFmt == 'Y') {
        var src = tes_deleteComma(obj.value);
        //if (curr_cd!=undefined && curr_cd!=null && (curr_cd=='KRW' || curr_cd=='JPY')){
        if (curr_cd != undefined && curr_cd != null && tes_isNoDecimalPointCurrCD(curr_cd)) {
            if (src.indexOf('.') != -1) {
                src = src.substring(0, src.indexOf('.'));
            }
            obj.value = tes_chkAmtFmt(src, curr_cd);
        } else {
            if (src.indexOf('.') != -1) {
                if (src.length - 1 > src.indexOf('.') + 2) {
                    src = src.substring(0, src.indexOf('.') + 3);
                    obj.value = tes_chkAmtFmt(src, curr_cd);
                }
                if (src.indexOf('.') != src.lastIndexOf('.')) {
                    src = src.substring(0, src.lastIndexOf('.'));
                    obj.value = tes_chkAmtFmt(src, curr_cd);
                }
            }
        }
    }
}

/**
 * TES Common 숫자만 사용
 * 
 * @param {Object}	obj		Comma 사용할 Object
 **/
function tes_isNum(obj) {
    if (!ComIsNumber(obj)) {
        obj.value = '';
    }
}

/**
 * TES Common 영문과 숫자만 사용
 *  
 * @param {Object}	obj   체크할 Object
 **/
function tes_isApNum(obj) {
    //영문과 숫자만
    if (!ComIsAlphabet(obj, 'n')) {
        obj.value = '';
    }
}

/**
 * TES Common Date Type '-'와 숫자만 사용
 * 
 * @param {Object}	obj			Object
 * @param {String}	isChkFmt	Format Check 할지 여부(Y/N)
 * @param {String}	int_str		integer String
 **/
function tes_isNumD(obj, isChkFmt, int_str) {
    if (isChkFmt == undefined || isChkFmt == null || ComTrim(isChkFmt) == '') {
        // 단순히 숫자와 '-'만 허용
        if (!ComIsNumber(obj, "-")) {
            obj.value = '';
        }
    } else if (isChkFmt != undefined && isChkFmt != null && isChkFmt == 'Y') {
        var int_char = (int_str != undefined && int_str != null & ComTrim(int_str) != '' ? ComTrim(int_str) : '-');
        var src = obj.value;
        for (var i = 0; src != null && i < src.length; i++) {
            if ((i != 4 && i != 7 && !ComIsNumber(src.charAt(i))) || ((i == 4 || i == 7) && !ComIsNumber(src.charAt(i), "-"))) {
                src = src.substring(0, i) + src.substring(i + 1, src.length);
            } else {
                if ((i == 4 || i == 7) && (src.charAt(i) != int_char)) {
                    src = src.substring(0, i) + int_char + src.substring(i, src.length);
                }
            }
        }
        obj.value = src;
    }
    return true;
}

/**
 * TES Common Amount Format Check
 * 
 * @param {String}	obj			Source Object
 * @param {String}	curr_cd		Currency Code(통화 코드)
 **/
function tes_chkAmtFmtObj(obj, curr_cd) {
    if (obj == undefined || obj.value == null || ComTrim(obj.value) == '') {
        return false;
    }
    obj.value = tes_chkAmtFmt(obj.value, curr_cd);
}

/**
 * TES Common Amount Format Check
 * 
 * @param {String}	src			Source Object
 * @param {String}	curr_cd		Currency Code(통화 코드)
 **/
function tes_chkAmtFmt(src, curr_cd) {
    src = new String(src);
    if (src == undefined || src == null || src.trim() == '') {
        return '';
    }
    src = tes_deleteComma(src);
    //if (curr_cd!=undefined && curr_cd!=null && (curr_cd=='KRW' || curr_cd=='JPY')){
    if (curr_cd != undefined && curr_cd != null && tes_isNoDecimalPointCurrCD(curr_cd)) {
        if (src.indexOf('.') != -1) {
            src = src.substring(0, src.indexOf('.'));
        }
        src = tes_addComma(src);
    } else {
        if (src.indexOf('.') == -1) {
            src = tes_addComma(src) + '.00'
        } else {
            var temp = src.split(".");
            if (temp.length == 2) {
                if (temp[1] == null || ComTrim(temp[1]) == '') {
                    temp[1] = '00';
                }
                if (temp[1].length == 1) {
                    temp[1] = temp[1] + '0';
                } else if (temp[1].length == 2) {} else if (temp[1].length > 2) {
                    temp[1] = temp[1].substring(0, 2);
                }
                src = tes_addComma(temp[0]) + '.' + temp[1];
            } else if (temp.length > 2) {
                // 두번째 .부터 .를 다 삭제하고 재계산하기 
                var tmp_str = '';
                for (var i = 1; i < temp.length; i++) {
                    tmp_str = tmp_str + new String(temp[i]);
                }
                if (tmp_str == null || ComTrim(tmp_str) == '') {
                    tmp_str = '00';
                }
                if (tmp_str.length == 1) {
                    tmp_str = tmp_str + '0';
                } else if (tmp_str.length == 2) {} else if (tmp_str.length > 2) {
                    tmp_str = tmp_str.substring(0, 2);
                }
                src = tes_addComma(temp[0]) + '.' + tmp_str;
            } else {
                //ComShowMessage('ERR!');
                return false;
            }
        }
    }
    return src;
}

/**
 * TES Common Comma 제거
 * 
 * @param {String}	obj		Comma 제거할 Object
 **/
function tes_deleteCommaObj(obj) {
    obj.value = tes_deleteComma(obj.value);
}

/**
 * TES Common Comma 제거 후 다시 Comma 적용
 * 
 * @param {String}	curr_cd		Currency Code(통화 코드)
 **/
function tes_addCommaObj(obj) {
    // 
    var tmp = obj.value;
    if (tmp == undefined || tmp == null || ComTrim(tmp) == '') {
        return false;
    }
    tmp = tes_deleteComma(tmp);
    obj.value = tes_addComma(tmp);
}

/**
 * TES Common Comma 제거
 * 
 * @param {String}	src		Comma 삭제할 Source String
 **/
function tes_deleteComma(src) {
    var src = String(src);
    if (src == null || ComTrim(src) == '') {
        return '';
    }
    return src.replace(/,/gi, '');
}

/**
 * TES Common comma를 3자리마다 끼워넣기
 * 
 * @param {int,String}	src		Source Value
 **/
function tes_addComma(src) {
    var src = String(src);
    if (src == null || ComTrim(src) == '') {
        return '';
    }
    var re = /(-?\d+)(\d{3})/;
    while (re.test(src)) {
        src = src.replace(re, "$1,$2");
    }
    return src;
}

/**
 * TES Common 한글 및 영문 str의 길이를 구함
 * 
 * @param {String}	src		길이를 구할 Source String
 **/
function tes_getStrLen(src) {
    src = new String(src);
    var byteLength = 0;
    for (var inx = 0; inx < src.length; inx++) {
        var oneChar = escape(src.charAt(inx));
        if (oneChar.length == 1) {
            byteLength++;
        } else if (oneChar.indexOf("%u") != -1) {
            byteLength = byteLength + 2;
        } else if (oneChar.indexOf("%") != -1) {
            byteLength = byteLength + oneChar.length / 3;
        }
    }
    return byteLength;
}

/**
 * TES Common 한글 및 영문 str의 길이를 구함
 * 
 * @param {String}	sdate		YYYYMMDD 형식의 문자열
 * @param {String}	sdiff		차이값
 * @param {String}	stype		'Y' - 년
 * 								'M' - 월
 * 								'D'/NULL/''/이외  - 일
 **/
function tes_getDiffDate(sdate, sdiff, stype) {
    var tyy = sdate.substring(0, 4);
    var tmm = sdate.substring(4, 6) - 1;
    var tdd = sdate.substring(6, 8);
    if (stype == "M") tdd = "01";
    var currdate = new Date(tyy, tmm, tdd);
    switch (stype) {
        case "Y":
            diffdate = new Date(currdate.getFullYear() + sdiff, currdate.getMonth(), currdate.getDate());
            break;
        case "M":
            diffdate = new Date(currdate.getFullYear(), currdate.getMonth() + sdiff, currdate.getDate());
            break;
        default:
            diffdate = new Date(currdate.getFullYear(), currdate.getMonth(), currdate.getDate() + sdiff);
            break;
    }
    var tmpyy = diffdate.getFullYear();
    var ls_yy = (tmpyy > 99) ? tmpyy : 1900 + tmpyy;
    var tmpmm = diffdate.getMonth();
    var ls_mm = (tmpmm < 9) ? "0" + (tmpmm + 1) : tmpmm + 1;
    var tmpdd = diffdate.getDate();
    var ls_dd = (tmpdd < 10) ? "0" + tmpdd : tmpdd;
    switch (stype) {
        case "M":
            return ls_yy.toString() + ls_mm.toString();
        default:
            return ls_yy.toString() + ls_mm.toString() + ls_dd.toString();
    }
}

/**
 * TES Common 입력값을 콤마가 포함된 문자열로 변환하여 리턴.<br>
 * 
 * @param {int,String}	src		Source Value
 **/
function tes_addComma2(src) {
    var ret;
    var chars = ".,0123456789";
    if (!containsCharsOnly2(src, chars)) {
        ComShowMessage("숫자만 입력하십시오.");
        return;
    } // end if
    var numstr = src;
    numstr = tes_deleteComma(numstr);
    var rxSplit = new RegExp('([0-9])([0-9][0-9][0-9][,.])');
    var arrNumber = numstr.split('.');
    arrNumber[0] = arrNumber[0] + '.';
    do {
        arrNumber[0] = arrNumber[0].replace(rxSplit, '$1,$2');
    }
    while (rxSplit.test(arrNumber[0]));
    if (arrNumber.length > 1) {
        ret = arrNumber.join('');
    } else {
        ret = arrNumber[0].split('.')[0];
    } // end if
    return ret;
}

/**
 * 입력값이 알파벳인지 체크
 * 
 * @param {Object}	obj   체크할 Object
 * @return true 알파벳일 경우
 */
function tes_isAlphabet(obj) {
    //영문과 숫자만
    if (!ComIsAlphabet(obj)) {
        obj.value = '';
    }
}

/**
 * Total Amount 소수점 계산 위한 함수 ( 2009-06-04 )
 * 
 * @param {String}		val			값
 * @param {int,String}	precision	소숫점 자릿수
 */
function tes_round(val, precision) {
    val = val * Math.pow(10, precision);
    val = Math.round(val);
    return val / Math.pow(10, precision);
}

/**
 * 입력받은 시작일과 마지막일의 유효성 체크.<br>
 * 마지막일은 시작일보다 작으면 false 그렇지 않으면 true.<br>
 * @param {string}	fmDt	시작일
 * @param {string}	toDt	마지막일
 * @return true 유효한 일자인 경우.
 */
function tes_isValFmTo(fmDt, toDt) {
    if (fmDt == undefined || fmDt == null || ComTrim(fmDt) == '' ||
        toDt == undefined || toDt == null || ComTrim(toDt) == '') {
        return false;
    }
    var str_fmDt = fmDt.replace(/-/gi, '');
    var str_toDt = toDt.replace(/-/gi, '');
    if (isNaN(str_fmDt) || isNaN(str_toDt) || ComTrim(str_fmDt).length != 8 || ComTrim(str_toDt).length != 8) {
        return false;
    }
    if ((parseInt(str_toDt, 10) - parseInt(str_fmDt, 10)) <= 0) {
        return false;
    }
    return true;
}

/********************************************************************
 * 	// 3. TES Invoice Common Script
 * 
 *******************************************************************/
/********************************************************************
 * 이 JS FILE은 외부에서 TES INVOICE의 공통기능을 호출하는 function 을 구성
 *******************************************************************/
/*** 2009-08-17: tes_getInputValueInvoice()에서 사용하는 iframe Id를 구성하기 위한 변수 ***/
var ifr_inv_cnt = 1;
//Invoice 상태 
var tes_Inv_Sts = new Array();
tes_Inv_Sts[0] = ["RC", "Received"];
tes_Inv_Sts[1] = ["CF", "Confirmed"];
tes_Inv_Sts[2] = ["AR", "Approval Requested"];
tes_Inv_Sts[3] = ["AP", "AP Interfaced"];
tes_Inv_Sts[4] = ["PD", "Paid"];
tes_Inv_Sts[5] = ["R", "Received"];
tes_Inv_Sts[6] = ["C", "Confirmed"];
tes_Inv_Sts[7] = ["A", "Approval Requested"];
tes_Inv_Sts[8] = ["P", "AP Interfaced"];
tes_Inv_Sts[9] = ["D", "Paid"];
//Invoice Reject 상태
var tes_Inv_Reject_Sts = new Array();
tes_Inv_Reject_Sts[0] = ["NL", "Normal"];
tes_Inv_Reject_Sts[1] = ["RJ", "Rejected"];
tes_Inv_Reject_Sts[2] = ["RL", "Reject Lifted"];
//Verify Result(Off-dock CY / Marine Storage Invoice)

/**
 * Invoice Status Full Name 조회. 
 * 인자로 'RC','CF','AR','AP','PD' / 'R','C','A','P','D' 중 하나로 받는다.
 * 
 * @param {src}  	Source Code 
 **/
function tes_getInvStsFullNm(src) {
    try {
        if (src != undefined && src != null) {
            src = new String(src);
            src = ComTrim(src);
            for (var i = 0; src != '' && tes_Inv_Sts != null && i < tes_Inv_Sts.length; i++) {
                if (src == tes_Inv_Sts[i][0]) {
                    return tes_Inv_Sts[i][1];
                }
            }
        }
    } catch (e) {
        return src;
    }
    return src;
}

/**
 * Invoice Reject Status Full Name 조회. 
 * 인자로 'NL','RJ','RL' 중 하나로 받는다
 * 
 * @param {src}  	Source Code 
 **/
function tes_getInvRejectStsFullNm(src) {
    try {
        if (src != undefined && src != null) {
            src = new String(src);
            src = ComTrim(src);
            for (var i = 0; src != '' && tes_Inv_Reject_Sts != null && i < tes_Inv_Reject_Sts.length; i++) {
                if (src == tes_Inv_Reject_Sts[i][0]) {
                    return tes_Inv_Reject_Sts[i][1];
                }
            }
        }
    } catch (e) {
        return src;
    }
    return src;
}



function tes_removeTESInvoiceCommonALLIframes() {
    /*******************
     2009-08-17: 내부적으로 tes_getComboItem()와 tes_getInputValue()에서 생성한 모든 iframe들을 사용 완료 후 제거한다.
     *******************/
    try {
        var f = document.frames;
        var elt;
        for (var i = 0; i <= ifr_inv_cnt; i++) {
            elt = document.getElementById('tes_com_inv_frame_' + i);
            if (elt != 'undefined' && elt != null) {
                //elt.removeNode(true);
                elt.parentNode.removeChild(elt);
            }
        }
    } catch (e) {}
}

function tes_removeTESInvoiceCommonIframe(ifrId) {
    /*******************
		 2009-08-17: 내부적으로 tes_getInputValueInvoice()에서 생성한 iframe을 사용 완료 후 제거한다.
 					 remove~ function호출 이후 완전히 제거되는데는 수초가 걸릴수도 있다.
		 *******************/
    var elt;
    if (ifrId != null && ifrId != '') {
        elt = document.getElementById(ifrId);
        if (elt != 'undefined' && elt != null) {
            //elt.removeNode(true);
            elt.parentNode.removeChild(elt);
        }
    }
}

/**
 * Invoice Input Value 조회. 
 * 
 * @param {Id}  			Id 
 * @param {f_cmd}  			Form Command
 * @param {paramName}  		Parameter Name
 * @param {functionName}  	조회후 실행될 Function Name 
 **/
function tes_getInputValueInvoice(coid, f_cmd, paramName, functionName) {
    if (coid == undefined) {
        coid = '';
    } else if (f_cmd == undefined) {
        f_cmd = '';
    } else if (paramName == undefined) {
        paramName = '';
    } else if (functionName == undefined) {
        functionName = '';
    }
    var f = document.frames;
    var ifr = "tes_com_inv_frame_" + (ifr_inv_cnt++);
    var o = document.createElement("DIV");
    o.style.display = "none";
    o.innerHTML = '<iframe name="' + ifr + '" id="' + ifr + '" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
    document.body.appendChild(o);
    var param = '';
    arr_param = paramName.split('|');
    for (var i = 0; i < arr_param.length; i++) {
        if (arr_param[i] != "") {
            param = param + "&" + arr_param[i] + "=" + eval("document.all." + arr_param[i]).value;
        }
    }
    eval("document." + ifr).location.href = "TESInvoiceCommon.screen?mode=INPUT&coid=" + coid + "&f_cmd=" + f_cmd + "&functionName=" + functionName + "&ifrId=" + ifr + "&" + param;
}

/**
 * TEU단위로 환산하여 비율 구하기
 * 
 * @param {vol_tr_ut_cd}  	Volume Trunk Unit Code 
 * @param {cntr_tpsz_cd}  	Container Type Size Code
 */
function tes_getTEUconv(vol_tr_ut_cd, cntr_tpsz_cd) {
    try {
        if (cntr_tpsz_cd == undefined || cntr_tpsz_cd == null || ComTrim(cntr_tpsz_cd) == '' || cntr_tpsz_cd.length != 2) {
            return 1;
        }
        if (vol_tr_ut_cd == undefined || vol_tr_ut_cd == null || ComTrim(vol_tr_ut_cd) == '') {
            return 1;
        } else if (ComTrim(vol_tr_ut_cd) == 'T') {
            switch (ComTrim(cntr_tpsz_cd)) {
                case 'D7':
                    return 2.25;
                case 'D8':
                    return 2.4;
                case 'D9':
                    return 2.4;
                case 'DW':
                    return 2.65;
                case 'DX':
                    return 2.25;
                default:
                    return (cntr_tpsz_cd != undefined && cntr_tpsz_cd != null && cntr_tpsz_cd.substring(2, 1) == 2 ? 1 : 2);
            }
        } else {
            return 1;
        }
    } catch (e) {
        return 1; //뭔일이 생겨도 일단 호출하는데서 문제가 없게 무조건 1로 넘긴다.
    }
}

/**
 * vndr_cust_div_cd 값에 따라 3rd Party를 조회하는 함수
 * sheet에서 호출시 사용
 *
 * @param {val}  		vndr_cust_div_cd 
 * @param {Row}  		Row
 * @param {Col}  		Column 
 * @param {sheetObj}  	Sheet Object
 */
function tes_get3rdParty_sheet(val, Row, Col, sheetObj) {
    var strTrd_party = val;
    if (strTrd_party == 'C') {
        //    		ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 480, 'tes_getCustomer_sheet', '1,0,1,1,1,1,1,1'	, Row, Col, true);
        ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 480, 'tes_getCustomer_sheet', '1,0,1,1,1,1,1,1', true, false, Row, Col, 0);
    } else if (strTrd_party == 'S') {
        //    		ComOpenPopup('/opuscntr/COM_ENS_091.do', 770, 580, 'tes_getStaff_sheet', '1,0,1,1,1,1,1,1', Row, Col, true, true);
        ComOpenPopup('/opuscntr/COM_ENS_091.do', 770, 560, 'tes_getStaff_sheet', '1,0,1,1,1,1,1,1', true, false, Row, Col, 0);
    } else if (strTrd_party == 'V') {
        //    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 620, 480, 'tes_getVendor_sheet', '1,0,1,1,1,1,1,1', Row, Col, true);
        ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 706, 560, 'tes_getVendor_sheet', '1,0,1,1,1,1,1,1', true, false, Row, Col, 0);
    } else {
        ComShowMessage(ComGetMsg('TPB90015'));
    }
}

/**
 * 3rd Party Customer popup close시 호출되는 함수
 * Sheet에서 popup 호출하였을 경우
 * 
 * @param {rArray}  	rArray
 * @param {Row}  		Row
 * @param {Col}  		Column 
 */
function tes_getCustomer_sheet(rArray, row, col) {
    var sheetObj = sheetObjects[0];
    var colArray = rArray[0];
    sheetObj.SetCellValue(row, col, colArray[3], 0);
    sheetObj.SetCellValue(row, 'cust_cnt_cd', colArray[3].substring(0, 2), 0);
    sheetObj.SetCellValue(row, 'cust_seq', colArray[3].substring(2), 0);
    sheetObj.SetCellValue(row, 'n3pty_ofc_cd', '', 0);
    sheetObj.SetCellValue(row, 'vndr_cnt_cd', '', 0);
    sheetObj.SetCellValue(row, 'n3pty_vndr_seq', '', 0);
    getThirdParySheetAfter(sheetObj, row);
}

/**
 * 3rd Party Staff popup close시 호출되는 함수
 * Sheet에서 popup 호출하였을 경우
 * 
 * @param {rArray}  	rArray
 * @param {Row}  		Row
 * @param {Col}  		Column 
 */
function tes_getStaff_sheet(rArray, row, col) {
    var sheetObj = sheetObjects[0];
    var colArray = rArray[0];
    sheetObj.SetCellValue(row, col, colArray[3], 0);
    sheetObj.SetCellValue(row, 'n3pty_ofc_cd', colArray[3], 0);
    sheetObj.SetCellValue(row, 'cust_cnt_cd', '', 0);
    sheetObj.SetCellValue(row, 'cust_seq', '', 0);
    sheetObj.SetCellValue(row, 'vndr_cnt_cd', '', 0);
    sheetObj.SetCellValue(row, 'n3pty_vndr_seq', '', 0);
    getThirdParySheetAfter(sheetObj, row);
}

/**
 * 3rd Party popup 호출 후 처리 
 */
function getThirdParySheetAfter(sheetObj, Row) {
    try {
        if (ComTrim(sheetObj.GetCellValue(Row, 'trd_party_val')) != '') {
            if (ComTrim(sheetObj.GetCellValue(Row, 'vndr_cust_div_cd')) != "") {
                sheetObj.SetCellEditable(Row, "cfm_flg_y", 1);
                getTPBGenCombo('Void_ThirdParty_Sheet', 'checkTrdParty', 'V', '', '', new Array("s_trd_party_val", "s_vndr_cust_div_cd"), Row); // Added In 2008-03-07
            }
            if (sheetObj.GetCellValue(Row, 'curr_cd') == "" || parseFloat(sheetObj.GetCellValue(Row, 'cfm_amt')) == 0) {
                sheetObj.SetCellEditable(Row, "cfm_flg_y", 0);
                sheetObj.SetCellValue(Row, "cfm_flg_y", "0", 0);
            }
        } else {
            sheetObj.SetCellEditable(Row, "cfm_flg_y", 0);
            sheetObj.SetCellValue(Row, "cfm_flg_y", "0", 0);
            sheetObj.SetCellValue(Row, "trd_party_val", "", 0);
        }
    } catch (e) {
        // ComShowMessage(e.toString());
    }
}

/**
 * 3rd Party Vendor popup close시 호출되는 함수
 * Sheet에서 popup 호출하였을 경우
 * 
 * @param {rArray}  	rArray
 * @param {Row}  		Row
 * @param {Col}  		Column 
 */
function tes_getVendor_sheet(rArray, row, col) {
    var sheetObj = sheetObjects[0];
    var colArray = rArray[0];
    sheetObj.SetCellValue(row, col, colArray[2], 0);
    sheetObj.SetCellValue(row, 'vndr_cnt_cd', colArray[2].substring(0, 2));
    //sheetObj.SetCellValue(row, 'vndr_cnt_cd',colArray[7],0); //ComShowMessage(colArray[7]);
    sheetObj.SetCellValue(row, 'n3pty_vndr_seq', colArray[2], 0);
    try {
        var temp = colArray[2];
        var tmp1 = temp;
        var tmp2 = "";
        for (var k = 0; k < temp.length; k++) {
            tmp2 = tmp1.substring(0, 1);
            if (tmp2 == "0") {
                tmp1 = tmp1.substring(1);
            } else {
                temp = tmp1;
                break;
            }
        }
        sheetObj.SetCellValue(row, 'n3pty_vndr_seq', temp, 0);
        sheetObj.SetCellValue(row, col, temp, 0);
    } catch (e) {
        alert(e);
    }
    sheetObj.SetCellValue(row, 'n3pty_ofc_cd', '', 0);
    sheetObj.SetCellValue(row, 'cust_cnt_cd', '', 0);
    sheetObj.SetCellValue(row, 'cust_seq', '', 0);
    getThirdParySheetAfter(sheetObj, row);
}

/*****
 *
 * TPB I/F에서 사용하는 TPB Billing Case ComboBox 만들기.
 * 
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{String}		srcObj		TPB 에서 가져온 Billing Case 조합
 * @param{String}		colObjName	ComboBox 설정 Parameter Column Name
 * @param{String}		paramNm		기본 설정외에 추가할 ComboBox Text	(Ex : JO|CC )
 * @param{String}		paramVal	기본 설정외에 추가할 ComboBox Value	(Ex : JO|Container Cleaning )
 * @param{String}		funcName	tes_tpbBillcaseCode 함수 실행 후 호출할 함수명
 *****/
function tes_tpbBillcaseCode(sheetObj, srcObj, colObjName, paramNm, paramVal, funcName) {
    var arrBill = srcObj.split("|$|");
    var arrBillCase;
    var comboNm = "";
    var comboVal = "";
    for (i = 1; i < arrBill.length; i++) {
        arrBillCase = arrBill[i].split("--");
        comboNm = comboNm + arrBillCase[1] + "|";
        comboVal = comboVal + arrBillCase[0] + "|";
    }
    if (paramNm != null && paramNm != '') {
        comboNm = comboNm + paramNm;
    }
    if (paramVal != null && paramVal != '') {
        comboVal = comboVal + paramVal;
    }
    sheetObj.SetColProperty(colObjName, {
        ComboText: comboNm,
        ComboCode: comboVal
    });
    if (funcName != null && funcName != "") eval(funcName + "()");
}

/*****
 *
 * TPB I/F에서 사용하는 TPB Billing Case ComboBox Name 만들기.
 * 
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{String}		srcObj		TPB 에서 가져온 Billing Case 조합
 * @param{String}		paramNm		기본 설정외에 추가할 ComboBox Text	(Ex : JO|CC )
 *****/
function tes_tpbBillcaseCodeNm(srcObj) {
    var arrBill = srcObj.split("--");
    var arrBillCase;
    var comboNm = "";
    for (i = 1; i < arrBill.length; i++) {
        arrBillCase = arrBill[i].split("|");
        comboNm = comboNm + arrBillCase[0] + "|";
    }
    return comboNm;
}

/*****
 *
 * TPB I/F에서 사용하는 TPB Billing Case ComboBox Value 만들기.
 * 
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{String}		srcObj		TPB 에서 가져온 Billing Case 조합
 * @param{String}		paramVal	기본 설정외에 추가할 ComboBox Value	(Ex : JO|Container Cleaning )
 *****/
function tes_tpbBillcaseCodeVal(srcObj) {
    var arrBill = srcObj.split("--");
    var arrBillCase;
    var comboVal = "";
    for (i = 1; i < arrBill.length; i++) {
        arrBillCase = arrBill[i].split("|");
        comboVal = comboVal + arrBillCase[1] + "|";
    }
    return comboVal;
}

/********************************************************************
 * 	// 4. TES Guarantee Common Script
 * 
 ********************************************************************/
/*** 2009-08-17: tes_getComboItem()와 tes_getInputValueGuarantee()에서 사용하는 iframe Id를 구성하기 위한 변수 ***/
var ifr_gnte_cnt = 1;

/**
 * 내부적으로 tes_getComboItem()와 tes_getInputValueGuarantee()에서 생성한 모든 iframe들을 사용 완료 후 제거한다.<br>
 **/
function tes_removeTESGuaranteeCommonALLIframes() {
    /*******************
     2009-08-17: 내부적으로 tes_getComboItem()와 tes_getInputValueGuarantee()에서 생성한 모든 iframe들을 사용 완료 후 제거한다.
     *******************/
    try {
        var f = document.frames;
        var elt;
        for (var i = 0; i <= ifr_gnte_cnt; i++) {
            elt = document.getElementById('tes_com_gnte_frame_' + i);
            if (elt != 'undefined' && elt != null) {
                //elt.removeNode(true);
                elt.parentNode.removeChild(elt);
            }
        }
    } catch (e) {}
}

/**
 * 내부적으로 tes_getComboItem()와 tes_getInputValue()에서 인자로 주어진 ifrId로 생성된 iframe을 사용 완료 후 제거한다.<br>
 * remove~ function호출 이후 완전히 제거되는데는 수초가 걸릴수도 있다.<br>
 * 
 * @param {String}		ifrId  			Id
 **/
function tes_removeTESGuaranteeCommonIframe(ifrId) {
    /*******************
		 2009-08-17: 내부적으로 tes_getInputValueGuarantee()에서 생성한 iframe을 사용 완료 후 제거한다.
 					 remove~ function호출 이후 완전히 제거되는데는 수초가 걸릴수도 있다.
		 *******************/
    var elt;
    if (ifrId != null && ifrId != '') {
        elt = document.getElementById(ifrId);
        if (elt != 'undefined' && elt != null) {
            //elt.removeNode(true);
            elt.parentNode.removeChild(elt);
        }
    }
}

/**
 * TES Common Input 값을 조회 설정 처리한다. 
 * 
 * @param {String}  	oid				oid
 * @param {String}		f_cmd  			Form Command
 * @param {String}		paramName		SC 처리할 Name
 * @param {String}		functionName	호출할 Function Name
 **/
function tes_getInputValueGuarantee(oid, f_cmd, paramName, functionName) {
    if (oid == undefined) {
        oid = '';
    } else if (f_cmd == undefined) {
        f_cmd = '';
    } else if (paramName == undefined) {
        paramName = '';
    } else if (functionName == undefined) {
        functionName = '';
    }
    var f = document.frames;
    var ifr = "tes_com_gnte_frame_" + (ifr_gnte_cnt++);
    var o = document.createElement("DIV");
    o.style.display = "";
    o.innerHTML = '<iframe name="' + ifr + '"  id="' + ifr + '" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
    document.body.appendChild(o);
    var param = '';
    arr_param = paramName.split('|');
    for (var i = 0; i < arr_param.length; i++) {
        if (arr_param[i] != "") {
            param = param + "&" + arr_param[i] + "=" + eval("document.all." + arr_param[i]).value;
        }
    }
    eval("document." + ifr).location.href = "GuaranteeCommon.screen?tes_mode=INPUT&oid=" + oid + "&f_cmd=" + f_cmd + "&functionName=" + functionName + "&ifrId=" + ifr + "&" + param;
}

/**
 * TES Common Select 값을 조회 설정 처리한다. 
 * 
 * @param {String}		oid  			oid
 * @param {int,String}	idx  			index
 * @param {String}		f_cmd  			Form Command
 * @param {String}		def  			def
 * @param {String}		paramName  		SC 처리할 Name
 * @param {String}		functionName	호출할 Function Name
 * @param {ibsheet}		sheetObj		IBSHEET Object
 **/
function tes_getComboItemGuarantee(oid, idx, f_cmd, def, paramName, functionName, sheetObj) {
    if (oid == undefined) {
        oid = '';
    } else if (idx == undefined) {
        idx = '';
    } else if (f_cmd == undefined) {
        f_cmd = '';
    } else if (def == undefined) {
        def = '';
    } else if (paramName == undefined) {
        paramName = '';
    } else if (functionName == undefined) {
        functionName = '';
    } else if (sheetObj == undefined) {
        sheetObj = '';
    }
    var f = document.frames;
    var ifr = "tes_com_gnte_frame_" + (ifr_gnte_cnt++);
    var o = document.createElement("DIV");
    o.style.display = "";
    o.innerHTML = '<iframe name="' + ifr + '"  id="' + ifr + '" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
    document.body.appendChild(o);
    var param = '';
    arr_param = paramName.split('|');
    for (var i = 0; i < arr_param.length; i++) {
        if (arr_param[i] != "") {
            param = param + "&" + arr_param[i] + "=" + eval("document.all." + arr_param[i]).value;
        }
    }
    eval("document." + ifr).location.href = "GuaranteeCommon.screen?tes_mode=COMBO&oid=" + oid + "&idx=" + idx + "&f_cmd=" + f_cmd + "&def=" + def + "&functionName=" + functionName + "&ifrId=" + ifr + "&" + param + "&sheetObj=" + sheetObj;
}

/**
 * 컨테이너 번호 Check 함수.<br>
 * @param{object}	obj		Object.
 */
function cntrCheck(obj) {
    obj.value = cntrCheckDigit(obj.value);
}

/**
 * 컨테이너 번호 Check Digit 계산 함수.<br>
 * @param{string}	cntrNo	Container No.
 */
function cntrCheckDigit(cntrNo) {
    if (cntrNo.length != 10) {
        return cntrNo;
    }
    var sum = 0;
    cntrNo = cntrNo.toUpperCase();
    for (var i = 0; i < 10; i++) {
        sum = sum + productValue(cntrNo.charAt(i), i);
    }
    var mod = sum % 11;
    if (mod == 10) mod = 0;
    if (isNaN(mod)) return cntrNo;
    return cntrNo + mod;
}

/**
 * 컨테이너 번호 Check Digit 계산 함수 -product Value 계산 하는 로직을 포함한 메소드
 * @param{string}	str			Container No String
 * @param{string}	position	
 */
function productValue(str, position) {
    var strMap = new Array("10", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "34", "35", "36", "37", "38");
    var num = new Number(str);
    if (isNaN(num)) {
        var index = new Number(str.charCodeAt(0) - 65);
        var strNum = strMap[index];
        return strNum * Math.pow(2, position);
    } else {
        return num * Math.pow(2, position);
    }
}

/**
 * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. 빈값은 넣어주지 않는다.<br>
 * @param{form}	str	 Form 객체  
 * @param{exElmNms}	str	  exElmNms값들은 form elemente name으로 구성하지 않을 값들이다. 
 */
function tesFrmQryStr(form, exElmNms) {

    if (typeof form != "object") {
        ComShowMessage("Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag.");
        return "";
    }

    var name = new Array(form.elements.length);
    var value = new Array(form.elements.length);
    var j = 0;
    var plain_text = "";

    //사용가능한 컨트롤을 배열로 생성한다.
    len = form.elements.length;
    for (i = 0; i < len; i++) {
        switch (form.elements[i].type) {
            case "button":
            case "reset":
            case "submit":
                break;
            case "radio":
            case "checkbox":
                if (form.elements[i].checked == true) {
                    name[j] = form.elements[i].name;
                    value[j] = form.elements[i].value;
                    j++;
                }
                break;
            case "select-one":
                name[j] = form.elements[i].name;
                var ind = form.elements[i].selectedIndex;
                if (ind >= 0) {
                    if (form.elements[i].options[ind].value != '')
                        value[j] = form.elements[i].options[ind].value;
                    else
                        value[j] = '';
                } else {
                    value[j] = "";
                }
                j++;
                break;
            case "select-multiple":
                name[j] = form.elements[i].name;
                var llen = form.elements[i].length;
                var increased = 0;
                for (k = 0; k < llen; k++) {
                    if (form.elements[i].options[k].selected) {
                        name[j] = form.elements[i].name;
                        if (form.elements[i].options[k].value != '')
                            value[j] = form.elements[i].options[k].value;
                        else
                            value[j] = '';
                        j++;
                        increased++;
                    }
                }
                if (increased > 0) {
                    j--;
                } else {
                    value[j] = "";
                }
                j++;
                break;
            default:
                if (form.elements[i].value.length > 0) {
                    if (exElmNms != null && exElmNms != '' && exElmNms != undefined) {
                        if (!checkExElm(form.elements[i].name, exElmNms)) {
                            name[j] = form.elements[i].name;
                            value[j] = form.elements[i].value;
                            j++;
                        }
                    } else {
                        name[j] = form.elements[i].name;
                        value[j] = form.elements[i].value;
                        j++;
                    }
                }
        }
    }

    for (i = 0; i < j; i++) {
        if (name[i] != '') plain_text += name[i] + "=" + encodeURIComponent(value[i]) + "&";
    }

    //마지막에 &를 없애기 위함
    if (plain_text != "")
        plain_text = plain_text.substr(0, plain_text.length - 1);
    return plain_text;
}

/**
 * TES MR Invoice 생성시 특정 Cost Code 에 대해 Detail 내역 수동 입력할 때 Calculation 탭의 Type/Size 반드시 입력하도록 validation 하는 함수 
 * Invoice 저장시에 반드시 입력 확인
 **/
function CostCdValidForCalcTpSz(costCd, tpsz) {
    var arr_cost = new Array('SVSCRF', 'TMRFGO', 'TMRFMO', 'TMRFPL', 'TMRFPT', 'TMRFXX');

    for (var i = 0; costCd != undefined && costCd != null && arr_cost != null && i < arr_cost.length; i++) {
        if (arr_cost[i] != undefined && arr_cost[i] == costCd && (!(tpsz.length == 2 && tpsz.substring(0, 1) == 'R'))) {
            return false;
        }
    }
}

function checkExElm(elmNm, exElmNms) {
    var arr_exElmNms = '';
    var rstTF = false;

    try {
        if (exElmNms != null && exElmNms != '' && exElmNms != undefined) {
            arr_exElmNms = exElmNms.split('|');

            for (var i = 0; i < arr_exElmNms.length; i++) {
                if (arr_exElmNms[i] != "") {
                    if (elmNm == null || elmNm == '' || elmNm == undefined) {
                        rstTF = true;
                        break;
                    } else if (elmNm == arr_exElmNms[i]) {
                        rstTF = true;
                        break;
                    }
                }
            }
        }
    } catch (e) {
        rstTF = true;
    }
    return rstTF;
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* 공통영역 재정의 함수 Start !!! */

var codeSheet=null;
$(document).ready(function(){
	createCodeSheetObject();
});

/**
 * CommonNew 에서 사용되는 Sheet 정의 <br>
 **/
function createCodeSheetObject(){
    if(codeSheet != null){
        return;
    }

    var sTag="";
    var id="codeSheet";
    
    var divElement=document.createElement("DIV");
    divElement.id = "CODE_HIDDEN_SHEET";
    divElement.style.display="none";
    divElement.innerHTML=sTag;
    document.body.appendChild(divElement);
    ComGetSheetDivObjectTag(CODE_HIDDEN_SHEET,id);
    ComConfigSheet(codeSheet);

    with(codeSheet){
		var HeadTitle="Status|Seq.|Code|Name|Index";
		var cnt=0;

		SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, FrozenCol:0, DataRowMerge:0 } );

		var info    = { Sort:0, ColMove:1, ColResize:1, HeaderCheck:1 };
		var headers = [ { Text:HeadTitle, Align:"Center"} ];
		InitHeaders(headers, info);

		var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"stat",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"code",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"text",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"flag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		 
		InitColumns(cols);

		SetSheetWidth(300);
		SetSheetHeight(150 );
		SetEditable(1);
		SetVisible(0);
	}
    ComEndConfigSheet(codeSheet);
}

/**
 * Empty Check
 * param : 1.arguement
 * return : 1.true : 정의 되지 않거나 null 또는 공백인 경우
 *           2.false : 값이 있는 경우
 */
function tesIsEmpty(arg){
	if(arg == "undefined" || arg == null || arg == ""){
		return true;
	} else {
		return false;
	} 
	
}

/**
 * Customer Code 유효성 검증. <br>
 **/
function gnte_validatCustomerCode() {    
    var formObj = document.form;
    var sGnteCustCd = formObj.gnte_cust_cd.value;
    
    if (tesIsEmpty(sGnteCustCd)) {
        formObj.gnte_cust_cd_name.value = "";
    }

    //20100618 CUST_CD 유효성 체크
//    if (sGnteCustCd.length == 8) {
//        if (ComIsAlphabet(sGnteCustCd.substring(0, 2)) == false) {
//            ComShowCodeMessage('TES70111');
//            return false;
//        }
//        if (ComIsNumber(sGnteCustCd.substring(2, 8)) == false) {
//            ComShowCodeMessage('TES70111');
//            return false;
//        }
//    }

    if (!tesIsEmpty(formObj.gnte_cust_cd.value)) {
        formObj.f_cmd.value = SEARCH05;
        var searchXml = codeSheet.GetSearchData("ESD_TES_2001GS.do", tesFrmQryStr(formObj));
        var custNm = ComGetEtcData(searchXml, "cust_nm");

        if (tesIsEmpty(custNm)) {
            formObj.gnte_cust_cd_name.value = "";
            ComShowCodeMessage('TES70111'); // This is invalid Customer Code.            
            //formObj.gnte_cust_cd.focus();            
            return false;
        } else {
            formObj.gnte_cust_cd_name.value = custNm;
        }

        searchXml = null;
    }
    return true;
}

/**
 * 입력된 vndr_seq 값을 Validation 하는 함수
 */
function gnte_validateVndrSeq() {    
    var formObj = document.form;
    var sVndrSeq = formObj.vndr_seq.value;
    
    if (tesIsEmpty(sVndrSeq)) {
        formObj.vndr_seq_name.value = "";
    }

//    if (sVndrSeq.length < 6) {
//        formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
//    }

    if (!tesIsEmpty(sVndrSeq)) {
        formObj.f_cmd.value = SEARCH17;
        var searchXml = codeSheet.GetSearchData("ESD_TES_0017GS.do", tesFrmQryStr(formObj));
        var vndrNm = ComGetEtcData(searchXml, "vndr_nm");

        if (tesIsEmpty(vndrNm)) {
            formObj.vndr_seq_name.value = "";
            ComShowCodeMessage('TES21040'); // This is invalid Service Provider Code.  
            //formObj.vndr_seq.focus();     
            return false;         
        } else {
            formObj.vndr_seq_name.value = vndrNm;
        }
        searchXml = null;
    }
    return true;
}

/**
 * 입력된 yard code 값을 Validation 하는 함수
 */
function gnte_validateYardCode() {    
    var formObj = document.form;
    var sYdCd = formObj.yd_cd.value;
    
    if (tesIsEmpty(sYdCd)) {
        formObj.yd_nm.value = "";
    }

    if (!tesIsEmpty(sYdCd)) {
        formObj.f_cmd.value = SEARCH06;
        var searchXml = codeSheet.GetSearchData("ESD_TES_2001GS.do", tesFrmQryStr(formObj));
        var sYdNm = ComGetEtcData(searchXml, "yd_nm");

        if (tesIsEmpty(sYdNm)) {
            formObj.yd_nm.value = "";
            ComShowCodeMessage('TES10066'); // This is invalid Yard Code.        
            //formObj.yd_cd.focus();    
            return false;
        } else {
            formObj.yd_nm.value = sYdNm;
        }
        searchXml = null;
    }
    return true;
}

/**
 * 입력된 ofc code 값을 Validation 하는 함수
 */
function gnte_validateOfficeCode() {    
    var formObj = document.form;
    var sOfcCd = formObj.dept_no.value;
 
    if (!tesIsEmpty(sOfcCd)) {
        formObj.f_cmd.value = SEARCH06;
        var searchXml = codeSheet.GetSearchData("GuaranteeComGS.do", tesFrmQryStr(formObj));
        var sOfcYn = ComGetEtcData(searchXml, "ofc_yn");

        if (sOfcYn == "N") {            
            ComShowCodeMessage('TES70204'); // This is invalid Office Code.            
            //formObj.dept_no.focus();
            return false;
        }
        searchXml = null;
    }
    return true;
}

/**
 * 코드 Name 조회 
 * 
 * @param sVal : current Value 
 * @param sCd : Code Array
 * @param sText : Code Name Array 
 * return Code Name
 **/
 function getCodeName(sVal, sCd, sText) {
	if (!tesIsEmpty(sVal)) {
		var sCode = sCd.split("|");
		var sCdNm = sText.split("|");
		
		for (var i = 0; i < sCode.length; i++) {
			if(sCode[i] == sVal){
				return sCdNm[i];     	
			} 
		}        
	}    
} 

/**
 * Currency List 조회 
 * Office 기본 Currency 값을 가져오려면 Jsp 파일에 ofc_cd 로 값이 정의 되어 있어야 한다.
 * 
 * param : 0.aObjNum : Combo Object Index Number
 *           1.aWidth 
 *           2.aHeigh
 * return : 0.해당 Office의 기본 Currency
 *           1.Currency List 
 */
function getCurrencyList(aObjNum, aWidth, aHeigh) {    
    var formObj = document.form;
    var cnt = 0;
    var nWidth = 85;
    var nHeigh = 200;
    var tmpList = "";
    
    if(!tesIsEmpty(aWidth)){
    	nWidth = aWidth;
    }
    
    if(!tesIsEmpty(aWidth)){
    	nHeight = aHeigh;
    }
    
    formObj.f_cmd.value = COMMAND11;
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));
    var sIndex = ComGetEtcData(searchXml, "INDEX");
    var sCurCdList = ComGetEtcData(searchXml, "CURCD");
    
    if(aObjNum >= 0){    	 
    	comboObjects[aObjNum].SetColAlign(0, "center");
        comboObjects[aObjNum].SetColWidth(0, nWidth);
        comboObjects[aObjNum].SetDropHeight(nHeigh);
       
        if (!tesIsEmpty(sCurCdList)) {
            tmpList = sCurCdList.split('|');
        }
        
        for (var i = 0;  i < tmpList.length; i++) {            
            comboObjects[aObjNum].InsertItem(cnt++, tmpList[i], tmpList[i]);
        }
        
        if (!tesIsEmpty(sIndex)) {
            comboObjects[aObjNum].SetSelectCode(sIndex, true);
        }
   }
   return true;
}

var CNTR_TPSZ_CD = "";
var MT_A_LGS_COST_CD = "";
var ON_A_LGS_COST_CD = "";
var OT_A_LGS_COST_CD = "";
var OS_A_LGS_COST_CD = "";
var ST_A_LGS_COST_CD = "";
var CARR_CD = "";
var EQ_TPSZ_CD = "";

/**
 * Common Code List 조회
 * 
 * return : 0.CNTR_TPSZ_CD
 *           1.MT_A_LGS_COST_CD 
 *           2.ON_A_LGS_COST_CD
 *           3.OT_A_LGS_COST_CD
 *           4.OS_A_LGS_COST_CD
 *           5.ST_A_LGS_COST_CD
 *           6.CARR_CD
 *           7.EQ_TPSZ_CD 
 */
function getComCdList() {    
    var formObj = document.form;
    formObj.f_cmd.value = COMMAND12;
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));
    
    CNTR_TPSZ_CD = ComGetEtcData(searchXml, "CNTR_TPSZ_CD");
    MT_A_LGS_COST_CD = ComGetEtcData(searchXml, "MT_A_LGS_COST_CD");
    ON_A_LGS_COST_CD = ComGetEtcData(searchXml, "ON_A_LGS_COST_CD");
    OT_A_LGS_COST_CD = ComGetEtcData(searchXml, "OT_A_LGS_COST_CD");
    OS_A_LGS_COST_CD = ComGetEtcData(searchXml, "OS_A_LGS_COST_CD");
    ST_A_LGS_COST_CD = ComGetEtcData(searchXml, "ST_A_LGS_COST_CD");
    CARR_CD = ComGetEtcData(searchXml, "CARR_CD");
    EQ_TPSZ_CD = ComGetEtcData(searchXml, "EQ_TPSZ_CD");
    
   	return true;
}

var WHLD_TAX_READONLY_MODE = true;

/**
 * WHLD_TAX_READONLY_MODE 조회 
 * Office Code 가 Jsp 파일에 ofc_cd 로 값이 정의 되어 있어야 한다.
 * 
 * return : WHLD_TAX_AMT_MODE
 */
function getWhldTaxAmtMode() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND13;
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));
    var sWhldTaxAmtMode = ComGetEtcData(searchXml, "WHLD_TAX_AMT_MODE");
    
    if (sWhldTaxAmtMode == 'Y') {
        WHLD_TAX_READONLY_MODE = false;
    } else {
        WHLD_TAX_READONLY_MODE = true;
    }    
}

var MANUAL_LGS_COST_CD = "";

/**
 * MANUAL_LGS_COST_CD List 조회 
 * MT, ON, OT, OS, ST 가 Jsp 파일에 calc_cost_grp_cd 로 값이 정의 되어 있어야 한다.
 * 
 * return : MANUAL_LGS_COST_CD
 */
function getManualLgsCostCd() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND14;
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));
    MANUAL_LGS_COST_CD = ComGetEtcData(searchXml, "MANUAL_LGS_COST_CD");
    return true;
}

var IS_VALID_VNDR_SEQ = "";

/**
 * Service Provider Name 조회 
 * Service Provider Code 가 Jsp 파일에 vndr_seq 로 값이 정의 되어 있어야 한다.
 * Service Provider Name 이 Jsp 파일에 vndr_seq_nm 로 값이 정의 되어 있어야 한다. 
 * 
 * param : Column 명
 * 
 * return : 0.IS_VALID_VNDR_SEQ
 *           1.Service Provider Name
 */
function getVndrSeqNm(argColNm) {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND15;
    
    var sVndrLglEngNm = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));
    IS_VALID_VNDR_SEQ = ComGetEtcData(searchXml, "IS_VALID_VNDR_SEQ");
    sVndrLglEngNm = ComGetEtcData(searchXml, "VNDR_LGL_ENG_NM");
    
    if (!tesIsEmpty(sVndrLglEngNm)) {
    	if (tesIsEmpty(argColNm)) {
    		formObj.vndr_seq_nm.value = sVndrLglEngNm;
    	} else {
    		document.getElementById(argColNm).value = sVndrLglEngNm;
    	}
    } else {
    	ComShowMessage(ComGetMsg('TES21040')); // This is invalid Service Provider Code.
    }
    
    return IS_VALID_VNDR_SEQ;
}

/**
 * Invoice Duplicate YN 조회 
 * Service Provider Code 가 Jsp 파일에 vndr_seq 로 값이 정의 되어 있어야 한다.
 * Invoice Number 가 Jsp 파일에 inv_no 로 값이 정의 되어 있어야 한다.
 * 
 * return : 1.Y -- 존재할 경우 
 *           2.N -- 존재하지 않을 경우
 */
function getInvDupYN() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND16;
    
    var sInvDupYN = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sInvDupYN = ComGetEtcData(searchXml, "INV_DUP_YN");
    
    if (sInvDupYN == "Y") {
    	ComShowMessage(ComGetMsg('TES21052')); //This Invoice No. is duplicated. Plz, change to another Invoice No.
    	return false;
    } else {
    	return true;
    }    
}

/**
 * Error Invoice Validation YN 조회 
 * tml_inv_tp_cd 가 Jsp 파일에 tml_inv_tp_cd 로 값이 정의 되어 있어야 한다.
 * Yard Code 가 Jsp 파일에 yd_cd 로 값이 정의 되어 있어야 한다. 
 * Service Provider 가 Jsp 파일에 vndr_seq 로 값이 정의 되어 있어야 한다. 
 * Error Invoice 가 Jsp 파일에 err_inv_no 로 값이 정의 되어 있어야 한다. 
 * 
 * return : 1.Y -- 존재할 경우 
 *           2.N -- 존재하지 않을 경우
 */
function getErrInvValidYN() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND17;
    
    var sErrInvValidYN = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sErrInvValidYN = ComGetEtcData(searchXml, "ERR_INV_VALID_YN");
    
    if (sErrInvValidYN == "N") {
    	ComShowMessage(ComGetMsg('TES40058', 'ERR INV.NO')); // This is not exist {?msg1}
    	return false;
    } else {
    	return true;
    }    
}

/**
 * Yard Code Validation & Cost Code List 조회 
 * Yard Code 가 Jsp 파일에 yd_cd 로 값이 정의 되어 있어야 한다. 
 * 
 * return : 0.YD_CD_EXISTING 
 *           1.YD_CD
 *           2.YD_NM
 *           3.YD_CHR_CD
 *           4.YD_FCTY_TP_MRN_TML_FLG
 *           5.YD_FCTY_TP_CY_FLG
 *           6.YD_FCTY_TP_CFS_FLG
 *           7.YD_FCTY_TP_RAIL_RMP_FLG
 *           8.YD_OSHP_CD
 *           9.COST_CD_MT
 *          10.COST_CD_ON
 *          11.COST_CD_OT
 *          12.COST_CD_OS
 *          13.COST_CD_ST
 *          14.COST_CD_SE
 *          15.COST_CD_OE
 */
function getYdCdCostCdList() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND18;
    
    var sYdCdExisting = "";
	var sYdCd = "";
	var sYdNm = "";
	var sYdChrCd = "";
	var sYdFctyTpMrnTmlFlg = "";
	var sYdFctyTpCyFlg = "";
	var sYdFctyTpCfsFlg = "";
	var sYdFctyTpRailRmpFlg = "";
	var sYdOshpCd = "";
	var sCostCdMt = "";
	var sCostCdOn = "";
	var sCostCdOt = "";
	var sCostCdOs = "";
	var sCostCdSt = "";
	var sCostCdSe = "";
	var sCostCdOe = "";		
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    
    sYdCdExisting = ComGetEtcData(searchXml, "YD_CD_EXISTING");
    sYdCd = ComGetEtcData(searchXml, "YD_CD");
    sYdNm = ComGetEtcData(searchXml, "YD_NM");
    sYdChrCd = ComGetEtcData(searchXml, "YD_CHR_CD");
    sYdFctyTpMrnTmlFlg = ComGetEtcData(searchXml, "YD_FCTY_TP_MRN_TML_FLG");
    sYdFctyTpCyFlg = ComGetEtcData(searchXml, "YD_FCTY_TP_CY_FLG");
    sYdFctyTpCfsFlg = ComGetEtcData(searchXml, "YD_FCTY_TP_CFS_FLG");
    sYdFctyTpRailRmpFlg = ComGetEtcData(searchXml, "YD_FCTY_TP_RAIL_RMP_FLG");
    sYdOshpCd = ComGetEtcData(searchXml, "YD_OSHP_CD");
    sCostCdMt = ComGetEtcData(searchXml, "COST_CD_MT");
    sCostCdOn = ComGetEtcData(searchXml, "COST_CD_ON");
    sCostCdOt = ComGetEtcData(searchXml, "COST_CD_OT");
    sCostCdOs = ComGetEtcData(searchXml, "COST_CD_OS");
    sCostCdSt = ComGetEtcData(searchXml, "COST_CD_ST");
    sCostCdSe = ComGetEtcData(searchXml, "COST_CD_SE");
    sCostCdOe = ComGetEtcData(searchXml, "COST_CD_OE");
    
    var rtnValue = sYdCdExisting + "--" + sYdCd + "--" + sYdNm + "--" + sYdChrCd + "--" + sYdFctyTpMrnTmlFlg + "--" + sYdFctyTpCyFlg + "--" + sYdFctyTpCfsFlg + "--" + sYdFctyTpRailRmpFlg + "--" + sYdOshpCd + "--" + sCostCdMt + "--" + sCostCdOn + "--" + sCostCdOt + "--" + sCostCdOs + "--" + sCostCdSt + "--" + sCostCdSe + "--" + sCostCdOe;
    
    return rtnValue;
}

/**
 * Office Code 조회 
 * Yard Code 가 Jsp 파일에 yd_cd 로 값이 정의 되어 있어야 한다. 
 * 
 * return : Office code
 */
function getOfcCdByYardCd() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND19;
    
    var sOfcCd = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sOfcCd = ComGetEtcData(searchXml, "OFC_CD");
    
    return sOfcCd;
}

/**
 * Sub Trade Code List 조회 
 * 
 * return : Sub Trade Code 
 */
function getSubTrdCd() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND20;
    
    var sSubTrdCd = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sSubTrdCd = ComGetEtcData(searchXml, "SUB_TRD_CD");
    
    return sSubTrdCd;
}

/**
 * Agreement Cost Code List 조회 
 * Yard Code 가 Jsp 파일에 yd_cd 로 값이 정의 되어 있어야 한다.
 * Service Provider 가 Jsp 파일에 vndr_seq 로 값이 정의 되어 있어야 한다.
 * agmt_ftr_inv_tp_cd 가 Jsp 파일에 agmt_ftr_inv_tp_cd 로 값이 정의 되어 있어야 한다.
 * atb_dt  가 Jsp 파일에 atb_dt 로 값이 정의 되어 있어야 한다.
 * fm_prd_dt 가 Jsp 파일에 fm_prd_dt 로 값이 정의 되어 있어야 한다.
 * to_prd_dt 가 Jsp 파일에 to_prd_dt 로 값이 정의 되어 있어야 한다.
 * min_wrk_dt 가 Jsp 파일에 min_wrk_dt 로 값이 정의 되어 있어야 한다.
 * 
 * param : 0.aObjNum : Combo Object Index Number
 *           1.aWidth 
 *           2.aHeigh
 *           3.aIndex 콤보에 체크표시할 대상
 * 
 * return : 0.COST_CODE
 */
function getAgmtCostCdList(aObjNum, aWidth, aHeigh, aIndex) {    
    var formObj = document.form;
    var cnt = 0;
    var nWidth = 85;
    var nHeigh = 200;
    var tmpList = "";
    
    comboObjects[aObjNum].RemoveAll();
    
    if(!tesIsEmpty(aWidth)){
    	nWidth = aWidth;
    }
    
    if(!tesIsEmpty(aWidth)){
    	nHeight = aHeigh;
    }
    
    formObj.f_cmd.value = COMMAND21;
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));
    var sAgmtCostCdList = ComGetEtcData(searchXml, "AGMT_COST_CODE");
    
    if(aObjNum >= 0){    	 
    	comboObjects[aObjNum].SetColAlign(0, "center");
        comboObjects[aObjNum].SetColWidth(0, nWidth);
        comboObjects[aObjNum].SetDropHeight(nHeigh);
        comboObjects[aObjNum].SetMultiSelect(true);
       
        if (!tesIsEmpty(sAgmtCostCdList)) {
            tmpList = sAgmtCostCdList.split('|');
        }
        
        for (var i = 0;  i < tmpList.length; i++) {            
            comboObjects[aObjNum].InsertItem(cnt++, tmpList[i], tmpList[i]);
        }
        
        if (!tesIsEmpty(aIndex)) {
	       	var tmpArr = aIndex.split("|");

	        for (var i = 0; i < tmpArr.length; i++) {	            
	            comboObjects[aObjNum].SetSelectCode(tmpArr[i], true);
	        }            
        }   
   }
   return true;
}

/**
 * Agreement Status Code 조회 
 * Yard Code 가 Jsp 파일에 yd_cd 로 값이 정의 되어 있어야 한다.
 * Service Provider 가 Jsp 파일에 vndr_seq 로 값이 정의 되어 있어야 한다.
 * from_date 가 Jsp 파일에 from_date 로 값이 정의 되어 있어야 한다.
 * to_date  가 Jsp 파일에 to_date 로 값이 정의 되어 있어야 한다.
 * 
 * return : 0.EX
 *           1.Status 
 */
function getAgmtStatusCd() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND22;
    
    var sEx = "";
    var sStatus = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sEx = ComGetEtcData(searchXml, "EX");
    sStatus = ComGetEtcData(searchXml, "ST");
    var rtnVal = sEx + "|" + sStatus
    return rtnVal;
}

/**
 * Lane Code 조회 
 * Yard Code 가 Jsp 파일에 yd_cd 로 값이 정의 되어 있어야 한다.
 * vvd 가 Jsp 파일에 vvd 로 값이 정의 되어 있어야 한다.
 * vsl_cd_sub 가 Jsp 파일에 vsl_cd_sub 로 값이 정의 되어 있어야 한다.
 * 
 * return : 0.Lane Code
 * 
 */
function getSLaneCd() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND23;
    
    var sSLanCd = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sSLanCd = ComGetEtcData(searchXml, "SLAN_CD");
    return sSLanCd;
}

/**
 * Cost Office Validation YN 조회 
 * Yard Code 가 Jsp 파일에 yd_cd 로 값이 정의 되어 있어야 한다.
 * Cost Office 가 Jsp 파일에 cost_ofc_cd 로 값이 정의 되어 있어야 한다.
 * 
 * return : 0.IS_EXISTING_OFC_CD
 *           1.IS_VALID_YD_CD
 * 
 */
function getCostOfcValidYN() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND24;
    
    var sOfcCdValidYN = "";
    var sYdCdValidYN = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sOfcCdValidYN = ComGetEtcData(searchXml, "IS_EXISTING_OFC_CD");
    sYdCdValidYN = ComGetEtcData(searchXml, "IS_VALID_YD_CD");
    
    if (sOfcCdValidYN == "N") {
    	if(tesIsEmpty(sYdCdValidYN)){
    		ComShowMessage(ComGetMsg('TES21037')); // An ERR occurred while confirming Yard Code of Cost OFC
    		return false;	
    	} else {
    		ComShowMessage(ComGetMsg('TES21038')); // This is invalid Cost OFC.
    		return false;    	
    	}
    } else if (sOfcCdValidYN == "Y")  {
    	if(sYdCdValidYN != "Y"){
    		ComShowMessage(ComGetMsg('TES21036')); // This Yard Code does not match Cost OFC.
    		return false;    
    	} else {
    		return true;
    	}
    }       
}

/**
 * Agreement CURR_CD 조회 
 * Yard Code 가 Jsp 파일에 yd_cd 로 값이 정의 되어 있어야 한다.
 * Service Provider 가 Jsp 파일에 vndr_seq 로 값이 정의 되어 있어야 한다. * 
 * 
 * return : 0.CURR_CD
 * 
 */
function getAgmtCurrCd() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND25;
    
    var sAgmtCurrCd = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sAgmtCurrCd = ComGetEtcData(searchXml, "CURR_CD");
    return sAgmtCurrCd;
}

/**
 * Equipment Type Size 조회 
 * Equipment 가 Jsp 파일에 eq_no 로 값이 정의 되어 있어야 한다. * 
 * 
 * return : 0.eq_tpsz_cd
 *           1.eq_knd_cd
 * 
 */
function getEquipTypeCd() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND26;
    
    var sEquipTypeCd = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sEquipTypeCd = ComGetEtcData(searchXml, "EQ_TPSZ_CD");
    return sEquipTypeCd;
}

/**
 * Auth Ofc Cd 조회 
 * act_tp 로 값이 정의 되어 있어야 한다.
 * no_ofc_cd 로 값이 정의 되어 있어야 한다.  
 * cre_ofc_cd 로 값이 정의 되어 있어야 한다.
 * no_yd_cd 로 값이 정의 되어 있어야 한다.
 * 
 * return : 0.AUTH_OFCS (Y or N1 or N2 or X)
 * 
 */
function getAuthOfcCd() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND27;
    
    var sAuthOfc = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sAuthOfc = ComGetEtcData(searchXml, "AUTH_OFCS");
    return sAuthOfc;
}

/**
 * Yard Code Validation 조회 
 * Yard Code 가 Jsp 파일에 yd_cd 로 값이 정의 되어 있어야 한다. 
 * 
 * param : Column Name
 * 
 * return : 0.YD_CD_EXISTING 
 *           1.YD_CD
 *           2.YD_NM
 *           3.YD_CHR_CD
 *           4.YD_FCTY_TP_MRN_TML_FLG
 *           5.YD_FCTY_TP_CY_FLG
 *           6.YD_FCTY_TP_CFS_FLG
 *           7.YD_FCTY_TP_RAIL_RMP_FLG
 *           8.YD_OSHP_CD
 *           9.DELT_FLG
 */
function getYdCdValid(argColNm) {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND28;
    
    var sYdCdExisting = "";
	var sYdCd = "";
	var sYdNm = "";
	var sYdChrCd = "";
	var sYdFctyTpMrnTmlFlg = "";
	var sYdFctyTpCyFlg = "";
	var sYdFctyTpCfsFlg = "";
	var sYdFctyTpRailRmpFlg = "";
	var sYdOshpCd = "";
	var sDelFlg = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    
    sYdCdExisting = ComGetEtcData(searchXml, "YD_CD_EXISTING");
    sYdCd = ComGetEtcData(searchXml, "YD_CD");
    sYdNm = ComGetEtcData(searchXml, "YD_NM");
    sYdChrCd = ComGetEtcData(searchXml, "YD_CHR_CD");
    sYdFctyTpMrnTmlFlg = ComGetEtcData(searchXml, "YD_FCTY_TP_MRN_TML_FLG");
    sYdFctyTpCyFlg = ComGetEtcData(searchXml, "YD_FCTY_TP_CY_FLG");
    sYdFctyTpCfsFlg = ComGetEtcData(searchXml, "YD_FCTY_TP_CFS_FLG");
    sYdFctyTpRailRmpFlg = ComGetEtcData(searchXml, "YD_FCTY_TP_RAIL_RMP_FLG");
    sYdOshpCd = ComGetEtcData(searchXml, "YD_OSHP_CD");
    sDelFlg = ComGetEtcData(searchXml, "DELT_FLG");
    
    if(!tesIsEmpty(argColNm)){    	
    	document.getElementById(argColNm).value = sYdNm;
    }
    
    var rtnValue = sYdCdExisting + "|" + sYdCd + "|" + sYdNm + "|" + sYdChrCd + "|" + sYdFctyTpMrnTmlFlg + "|" + sYdFctyTpCyFlg + "|" + sYdFctyTpCfsFlg + "|" + sYdFctyTpRailRmpFlg + "|" + sYdOshpCd + "|" + sDelFlg ;
    
    return rtnValue;
}

/**
 * Vendor Code Validation 조회 
 * Yard Code 가 Jsp 파일에 vndr_seq 로 값이 정의 되어 있어야 한다. 
 * 
 * param : Column Name
 * 
 * return : 0.VNDR_SEQ_EXISTING 
 *           1.VNDR_LGL_ENG_NM
 *           2.DELT_FLG
 */
function getVndrSeqValid(argColNm) {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND29;
    
    var sVndrSeqExisting = "";
	var sVndrSeqNm = "";
	var sDelFlg = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    
    sVndrSeqExisting = ComGetEtcData(searchXml, "VNDR_SEQ_EXISTING");
    sVndrSeqNm = ComGetEtcData(searchXml, "VNDR_LGL_ENG_NM");
    sDelFlg = ComGetEtcData(searchXml, "DELT_FLG");
    
    if(!tesIsEmpty(argColNm)){    	
    	document.getElementById(argColNm).value = sVndrSeqNm;
    }
    
    var rtnValue = sVndrSeqExisting + "|" + sVndrSeqNm + "|" + sDelFlg;
    
    return rtnValue;
}

/**
 * DB Date 조회 
 *  
 * return : 0.CURR_DATE
 */
function getDBDate() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND30;
    
    var sCurrDate = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    
    sCurrDate = ComGetEtcData(searchXml, "CURR_DATE");   
    
    return sCurrDate;
}

/**
 * Cost Office Validation Delete YN 조회 
 * Yard Code 가 Jsp 파일에 yd_cd 로 값이 정의 되어 있어야 한다.
 * Cost Office 가 Jsp 파일에 cost_ofc_cd 로 값이 정의 되어 있어야 한다.
 * 
 * return : 0.IS_EXISTING_OFC_CD
 *           1.IS_VALID_YD_CD
 *           2.DELT_FLG
 * 
 */
function getCostOfcValidDelYN() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND31;
    
    var sIsExistingOfcCd = "";
    var sIsValidYdCd = "";
    var sDelFlg = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sIsExistingOfcCd = ComGetEtcData(searchXml, "IS_EXISTING_OFC_CD");
    sIsValidYdCd = ComGetEtcData(searchXml, "IS_VALID_YD_CD");
    sDelFlg = ComGetEtcData(searchXml, "DELT_FLG");
    
    var rtnVal = sIsExistingOfcCd + "|" + sIsValidYdCd + "|" + sDelFlg;
    
    return rtnVal;
}

/**
 * Invoice Office Validation Delete YN 조회 
 * Yard Code 가 Jsp 파일에 yd_cd 로 값이 정의 되어 있어야 한다.
 * Invoice Office 가 Jsp 파일에 inv_ofc_cd 로 값이 정의 되어 있어야 한다.
 * 
 * return : 0.IS_EXISTING_OFC_CD
 *           1.IS_VALID_YD_CD
 *           2.DELT_FLG
 * 
 */
function getInvOfcValidDelYN() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND32;
    
    var sIsExistingOfcCd = "";
    var sIsValidYdCd = "";
    var sDelFlg = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sIsExistingOfcCd = ComGetEtcData(searchXml, "IS_EXISTING_OFC_CD");
    sIsValidYdCd = ComGetEtcData(searchXml, "IS_VALID_YD_CD");
    sDelFlg = ComGetEtcData(searchXml, "DELT_FLG");
    
    var rtnVal = sIsExistingOfcCd + "|" + sIsValidYdCd + "|" + sDelFlg;
    
    return rtnVal;
}

/**
 * Cost Code ComboObject 셋팅 
 * 
 * return : 0.COST_CODE
 * 
 */
function getCostCodeCombo(argObject) {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND33;
    
    var sCostCode = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    sCostCode = ComGetEtcData(searchXml, "COST_CODE");
    
    if(!tesIsEmpty(sCostCode)){   	
		argObject.SetColAlign(0, "center");
		argObject.SetColWidth(0, 260);
		argObject.SetDropHeight(200);
		argObject.SetMultiSelect(true);
		
		var sCode = sCostCode.split("|");
			
		for (var i = 0;  i < sCode.length; i++) {	
		    argObject.InsertItem(i, sCode[i], sCode[i]);
		} 
	}
}

/**
 * Agreement Cost Code List 조회 
 * Yard Code 가 Jsp 파일에 loc_cd 로 값이 정의 되어 있어야 한다.
 * 
 * param : 0.aObjNum : Combo Object Index Number
 *           1.aWidth 
 *           2.aHeigh
 *           3.aIndex 콤보에 체크표시할 대상
 * 
 * return : 0.NOD_CD
 */
function getNodeCdList(aObjNum, aWidth, aHeigh, aIndex) {    
    var formObj = document.form;
    var cnt = 0;
    var nWidth = 46;
    var nHeigh = 100;
    var tmpList = "";
    
    comboObjects[aObjNum].RemoveAll();
    
    if(!tesIsEmpty(aWidth)){
    	nWidth = aWidth;
    }
    
    if(!tesIsEmpty(aWidth)){
    	nHeight = aHeigh;
    }
    
    formObj.f_cmd.value = COMMAND34;
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));
    var sNodeCd = ComGetEtcData(searchXml, "NOD_CD");
    
    if(aObjNum >= 0){    	 
    	comboObjects[aObjNum].SetColAlign(0, "center");
        comboObjects[aObjNum].SetColWidth(0, nWidth);
        comboObjects[aObjNum].SetDropHeight(nHeigh);
        comboObjects[aObjNum].SetMultiSelect(false);
       
        if (!tesIsEmpty(sNodeCd)) {
            tmpList = sNodeCd.split('|');
        }
        
        for (var i = 0;  i < tmpList.length; i++) {            
            comboObjects[aObjNum].InsertItem(cnt++, tmpList[i], tmpList[i]);
        }
        
        if (!tesIsEmpty(aIndex)) {
        	//var tmpArr = aIndex.split("|");
	        //for (var i = 0; i < tmpArr.length; i++) {	            
	            comboObjects[aObjNum].SetSelectCode(aIndex, true);
	        //}            
        }   
   }
   return true;
}

/**
 * Container Type Size 조회 
 *  
 * return : 0.CNTR_TPSZ_CD
 */
function getCntrTpSz() {    
    var formObj = document.form;
    
    formObj.f_cmd.value = COMMAND35;
    
    var sCntrTpSz = "";
    
    var searchXml = codeSheet.GetSearchData("TESCommonNewGS.do", tesFrmQryStr(formObj));    
    
    sCntrTpSz = ComGetEtcData(searchXml, "CNTR_TPSZ_CD");   
    
    return sCntrTpSz;
}

/* 공통영역 재정의 함수 End !!! */
