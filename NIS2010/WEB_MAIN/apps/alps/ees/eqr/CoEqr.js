/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CoEqr.js
*@FileTitle : EQR 공통 Script
*Open Issues : Util.js, DataSheet.js 통합
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.03 이행지
* 1.0 최초 생성
=========================================================*/

/* Change history  -------------------BackEndJobBackEndJob------------------------------------------------
 * No.	Ver.	Modifier			modifier date	explanation
 * 1	1.1		Admin				2006-09-22		신규 생성
 * 2	1.63	shin yongchan		2008-04-0		CSR No - R200804035815 - ENIS / BMS 웹서버(SunOne) 로그상에 Invalid URL에 대한
													지속적인 404에러 발생(/hanjin/none) 으로 인해소스 수정됨.   none ---> default
 * 3	1.64	chae chang ho		2008-05-28		Project - 신규장비(F5-40ft H/C Flat Rack)발주에 따른 NIS상에 F5등록
 * 4	1.67	Haeng-ji,Lee		2009-05-18		CSR No : R200905150001 - 한글메세지 영문으로 수정
 * 2010.09.07 남궁진호 [CHM-201005850-01] 신규 메세지 추가[ EQR90232]
--------------------------------------------------------------------------------------*/

// eqr 추가 메시지

  msgs['EQR90001'] = 'Please input {?msg1}.';
  msgs['EQR90002'] = 'Not Found Scenario ID';
  msgs['EQR90003'] = 'There is no relevant ECC Code.';
  msgs['EQR90004'] = 'The service is not available now';
  msgs['EQR90005'] = 'Not Found Repo Plan ID';
  msgs['EQR90006'] = 'Duplicated Repo Plan ID No';
  msgs['EQR90007'] = 'No use in Repo Plan ID';
  msgs['EQR90008'] = 'There is no contents to save.';
  msgs['EQR90009'] = 'Data Duplicated';
  msgs['EQR90010'] = 'Please retrieve {?msg1}.';
  msgs['EQR90011'] = 'Year must be 4 numbers.';
  msgs['EQR90012'] = 'Please retrieve {?msg1}.';
  msgs['EQR90013'] = 'Please enter Scenario Year and Week.';
  msgs['EQR90014'] = 'Please enter Scenario SEQ.';
  msgs['EQR90015'] = 'Can not be deleted.';
  msgs['EQR90016'] = 'Please select {?msg1}.';
  msgs['EQR90017'] = 'Please enter {?msg1} year';
  msgs['EQR90018'] = 'Please enter {?msg1} week';
  msgs['EQR90019'] = 'There is no data modified!';
  msgs['EQR90020'] = 'O/B Total must be equal to or greater than {?msg1}.';
  msgs['EQR90021'] = 'I/B Total must be equal to or greater than {?msg1}.';
  msgs['EQR90022'] = 'Please enter under {?msg1} weeks.';
  msgs['EQR90023'] = 'There is no new scenario ID.';
  msgs['EQR90024'] = 'You can not modify this scenario.';
  msgs['EQR90025'] = '000 can not be saved.';
  msgs['EQR90026'] = 'There is duplicate ECC.';
  msgs['EQR90027'] = 'Please enter under {?msg2} weeks of {?msg1}.';
  msgs['EQR90028'] = 'Please enter this item greater than or same as Plan Week.';
  msgs['EQR90029'] = 'Please enter this item later than or same as {?msg1}.';
  msgs['EQR90030'] = 'Can not use Adjust because Company has been selected Both';
  msgs['EQR90031'] = 'Please select newly created Repo Plan ID';
  msgs['EQR90032'] = 'There is no T/S information';
  msgs['EQR90033'] = 'To Week must larger than From Week ! ';
  msgs['EQR90034'] = 'Please input data From week at line {?msg1}';
  msgs['EQR90035'] = 'Please input data To Week at line {?msg1}';
  msgs['EQR90036'] = 'This is modified item.\n\n Do you want to save?';
  msgs['EQR90037'] = 'Please insert scenario ID value ';
  msgs['EQR90038'] = 'Scenario ID status type is not true !';
  msgs['EQR90039'] = 'There is no data to be downloaded.';
  msgs['EQR90040'] = 'Please select Plan Row.';
  msgs['EQR90041'] = 'Please select REPO BKG Row.';
  msgs['EQR90042'] = 'Selected data is not relevant Repo BKG target.';
  msgs['EQR90043'] = 'Please select Execute Row.';
  msgs['EQR90044'] = 'There is no row checked with S/O Send.';
  msgs['EQR90045'] = '{?msg1} can be operated when ALL TP/SZ is retrieved.';
  msgs['EQR90046'] = 'Do you want to execute S/O Send of selected data?';
  msgs['EQR90047'] = 'Selected data are not target of S/O Cancel.';
  msgs['EQR90048'] = '{?msg1} Vol must be equal to or greater than {?msg1} container Vol {?msg2}. ';
  msgs['EQR90049'] = 'This REPO Plan can not be Distributed.\n\n Can not be retrieved.';
  msgs['EQR90050'] = 'Total value 0 can not be entered.';
  msgs['EQR90051'] = 'There is no data retrieved.';
  msgs['EQR90052'] = 'Please select Plan Row to be Combine target.';
  msgs['EQR90053'] = 'Do you want to execute REPO BKG of selected data?';
  msgs['EQR90054'] = 'Do you want to execute S/O Send of selected data?';
  msgs['EQR90055'] = 'Do you want to execute S/O Cancel of selected data?';
  msgs['EQR90056'] = 'Please input week data format!';
  msgs['EQR90057'] = 'To Week must be larger than From Week!';
  msgs['EQR90058'] = '{?msg1} line Contract must be 4 characters long at least.';
  msgs['EQR90059'] = '{?msg1} line Contract first 3 digits must be English characters.';
  msgs['EQR90060'] = '{?msg1} line Contract from 4th digit must be numbers.';
  msgs['EQR90061'] = 'Percentage is zero ';
  msgs['EQR90062'] = 'Quantity is zero ';
  msgs['EQR90063'] = 'There is no data selected.';
  msgs['EQR90064'] = 'LOC is not be selected on LINE {?msg1} completely.';
  msgs['EQR90065'] = 'LOC {?msg2} items on LINE {?msg1} LOC {?msg2} are same ECC.\n\n Could not enter.';
  msgs['EQR90066'] = 'LOC {?msg2} items on LINE {?msg1} LOC {?msg2} are different ECC.\n\n Could not enter.';
  msgs['EQR90067'] = 'There is no data to apply.';
  msgs['EQR90068'] = 'Please share after retrieve.';
  msgs['EQR90069'] = 'Please enter after retrieve.';
  msgs['EQR90070'] = 'To week value must be equal to or greater than {?msg1}.';
  msgs['EQR90071'] = 'Please enter data under {?msg2} of {?msg1}.';
  msgs['EQR90072'] = 'Please retrieve after Apply';
  msgs['EQR90073'] = 'Holiday Data will be saved first.';
  msgs['EQR90074'] = 'There is no VVD';
  msgs['EQR90075'] = 'There is no ETD , ETA.';
  msgs['EQR90076'] = 'Please enter value between FROM weeks';
  msgs['EQR90077'] = 'ETD must be earlier than ETA.';
  msgs['EQR90078'] = 'Please enter {?msg1} digits long data.';
  msgs['EQR90079'] = 'Please enter data between Plan Week and retrieve TO week.';
  msgs['EQR90080'] = 'To Date must be greater than From Date. ';
  msgs['EQR90081'] = 'Please save modified data first';
  msgs['EQR90082'] = 'Please enter data between retrieve weeks.';
  msgs['EQR90083'] = 'This is not a distributed Plan.';
  msgs['EQR90084'] = 'Data Select2 must differ from Data Select1.';
  msgs['EQR90085'] = 'Must select DIR';
  msgs['EQR90086'] = 'Must Input From';
  msgs['EQR90087'] = 'Must Input To';
  msgs['EQR90088'] = 'Must check One More';
  msgs['EQR90089'] = 'To week must be later than From week.';
  msgs['EQR90090'] = 'End week must be under {?msg1} week.';
  msgs['EQR90091'] = 'There is {?msg2} on {?msg1} row. ';
  msgs['EQR90092'] = 'Please check Container No and enter again.';
  msgs['EQR90093'] = '{?msg1} exist on same REPO Plan ID';
  msgs['EQR90094'] = 'There is Container No ({?msg1}) saved.';
  msgs['EQR90095'] = 'There is no data to Print.';
  msgs['EQR90096'] = 'Upper Data Share.\n\n Lower Data are not saved.';
  msgs['EQR90097'] = 'User {?msg1} is being used from {?msg2}\n\n. Do you want to continue?';
  msgs['EQR90098'] = 'Entered ECC can not be used.';
  msgs['EQR90099'] = 'It is greater than fixed quantity {?msg3} on POL : {?msg2} of VVD :{?msg1}.\n\n Please check.';
  msgs['EQR90100'] = 'It is less than fixed quantity {?msg3} on POL : {?msg2} of VVD :{?msg1}.\n\n Please check.';
  msgs['EQR90101'] = 'Please enter either FROM or TO.';
  msgs['EQR90102'] = 'Please delete or fill FROM period.';
  msgs['EQR90103'] = 'Please delete or fill TO period.';
  msgs['EQR90104'] = 'Start week must be earlier than end week.';
  msgs['EQR90105'] = '{?msg1} is wrong data.';
  msgs['EQR90106'] = 'Saving has been completed.';
  msgs['EQR90107'] = 'Saving has not been completed.';
  msgs['EQR90108'] = 'Please save after {?msg1} .';
  msgs['EQR90109'] = '{?msg1} being validation.';
  msgs['EQR90110'] = 'Retrieved {?msg1} Year differs from {?msg2}.';
  msgs['EQR90111'] = 'Please enter end week under {?msg1} week.';
  msgs['EQR90112'] = 'Start week starts from {?msg1}.';
  msgs['EQR90113'] = '{?msg1} is wrong.';
  msgs['EQR90114'] = 'TO Week must be equal to or greater than FROM Week.';
  msgs['EQR90115'] = 'Please enter number equal to or less than {?msg1} week.';
  msgs['EQR90116'] = 'Please enter number equal to or greater than {?msg1} week.';
  msgs['EQR90117'] = 'Lower Data save.\n\n Upper Data are not saved.';
  msgs['EQR90118'] = 'Modified data are not saved.\n\n Please save first.';
  msgs['EQR90119'] = 'Do you want to execute selected Repo BKG as Repo BKG?';
  msgs['EQR90120'] = 'Do you want to save modified items on TAB {?msg1}? ';
  msgs['EQR90121'] = 'Selected MTY Repo BKG differs from Company, Load LOC, VVD data.';
  msgs['EQR90122'] = 'Selecting of non-VVD MTY REPO BKG is not permitted.';
  msgs['EQR90123'] = 'There is no target of checked Repo BKG.';
  msgs['EQR90124'] = 'This REPO PLAN is not executed Distribution.\n\n It is impossible to add Plan.';
  msgs['EQR90125'] = 'It is impossible to retrieve At on {?msg1}.\n\n Please select FM/TO. ';
  msgs['EQR90126'] = 'Please select LINE {?msg1}, {?msg2} data.';
  msgs['EQR90127'] = 'Week can not be eaxrlier than {?msg1} or later than {?msg2}.';
  msgs['EQR90128'] = 'Row {?msg1} Total Vol = 0 status.\n\n It is possible to enter and modify.';
  msgs['EQR90129'] = 'Selecting on LINE {?msg1} LOC is not completed.';
  msgs['EQR90130'] = 'LINE {?msg1} 3 LOC are same ECC.\n\n It is impossible to enter.';
  msgs['EQR90131'] = 'LINE {?msg1} 3 LOC are different ECC.\n\n It is impossible to enter.';
  msgs['EQR90132'] = 'Are you going to update distruibuted Repo Plan ID {?msg1} ?';
  msgs['EQR90133'] = '{?msg1} week is wrong.';
  msgs['EQR90134'] = 'Quantity differ from\n{?msg1}';
  msgs['EQR90135'] = '{?msg1} is modifying.';
  msgs['EQR90136'] = 'TO week must be later than FROM week.';
  msgs['EQR90137'] = 'Confirm has been processed already.';
  msgs['EQR90138'] = 'Do you want to execute Re-run?';
  msgs['EQR90139'] = 'ETD must be earlier than ETB.';
  msgs['EQR90140'] = 'You can modify it on ECC Info sheet2.';
  msgs['EQR90141'] = '{?msg1} must be later than {?msg2} or earlier than {?msg3}.';
  msgs['EQR90142'] = 'Could not cancel S/O, because S/O had been sent already.';
  msgs['EQR90143'] = 'Please enter FROM Yard and TO Yard.';
  msgs['EQR90144'] = 'Please select ETD between week ({?msg1} ~ {?msg2}).';
  msgs['EQR90145'] = 'Please enter 4 digit-To Year.';
  msgs['EQR90146'] = 'Please enter 2 digit-To Week.';
  msgs['EQR90147'] = 'Could not Cancel.';
  msgs['EQR90148'] = 'Please enter the date later than {?msg1} of prior calling port.';
  msgs['EQR90149'] = 'Please eneter the date earlier than {?msg1} of next calling port.';
  msgs['EQR90150'] = 'There is no {?msg1} for the week.\n\n Please enter Week again.';
  msgs['EQR90151'] = '{?msg1} must be {?msg2}, {?msg3} week.' ;
  msgs['EQR90152'] = '{?msg1} can be added 1 Row by one.';
  msgs['EQR90153'] = 'Retrieving option Week [{?msg1}] differs from Data week [{?msg2}].\n\n Please try again.';
  msgs['EQR90154'] = '{?msg1} has been distributed.';
  msgs['EQR90155'] = 'There are inserted data.\n\n Please check again.\n';
  msgs['EQR90156'] = 'There are inserted data.\n\n Please check again.\n\n Do you want to save them as they are?';
  msgs['EQR90157'] = '{?msg2} Are you going to update distruibuted RepoPlan ID {?msg1}?';
  msgs['EQR90158'] = 'It is possible by RCC, by LCC only.'
  msgs['EQR90159'] = 'Please assign another REPO BKG No for Repositioning empty volume over 500 units';
  msgs['EQR90160'] = 'You can take a necessary action under {?msg1} {?msg2}({?msg3}). ';
  msgs['EQR90161'] = 'VD Add(Booking Split) row can\'t be saved with {?msg1} Button.';
  msgs['EQR90162'] = 'Do you want to {?msg1}?';
  msgs['EQR90163'] = 'Please assign  Senator company S/O Send for Repositioning empty volume over 100 units ';
  msgs['EQR90164'] = 'Please input value over {?msg1}';
  msgs['EQR90165'] = 'Please note the same date/route of the input data will be disregarded.';
  msgs['EQR90166'] = 'selected the fixed volume at present. Do you want to insert the fixed volume ?';
  msgs['EQR90167'] = 'Please input the mandatory items from previous field  in turn !';
  msgs['EQR90168'] = 'The ETB of VD Add(Fixed Plan) should be the same week of plan.';
  msgs['EQR90169'] = 'Please select ETB between week({?msg1}~{?msg2}).';
  msgs['EQR90170'] = 'You can not input the same ECC Link information.';
  msgs['EQR90171'] = 'Please input yard code under {?msg1} ECC.';
  msgs['EQR90172'] = 'OK. Execution Plan data was already transmitted to TRS. \nDo you want to create S/O & W/O Data ?';
  msgs['EQR90173'] = 'Please input Eexecution data for VVD in T.VVD/D.VVD screen !';
  msgs['EQR90174'] = 'The input Data(VVD/POL/POD) is available in Plan ID {?msg1}!.\n\n Do you want to insert the input data additionally?';
  msgs['EQR90175'] = 'You can not input [ All ] on From/To location field simultaneously !';
  msgs['EQR90176'] = 'Please cross-check this data with Rule code ({?msg1} )!';
  msgs['EQR90177'] = 'No calling port in NIS. Do you confirm to insert ?' ;
  msgs['EQR90178'] = 'ETA must be earlier than ETB.';
  msgs['EQR90179'] = 'Pls press [ Interface ] button, instead of [Save], when you click [I/F] box.';
  msgs['EQR90180'] = 'Pls click [I/F] box, before pressing [Interface] button.';
  msgs['EQR90181'] = 'Please input {?msg1}({?msg2} \'\s line).';
  msgs['EQR90182'] = 'Container[ {?msg1} ]\'\s container type size not yet applied.\nWaiting for a moment and click "Apply" button.';
  msgs['EQR90183'] = 'Please select another scenario seq number. "000" seq is not allowed to Run Optimizer.';
  msgs['EQR90184'] = 'Waiting for a moment and click "Retrieve" button again.';
  msgs['EQR90185'] = 'This VVD isn\'t available.';
  msgs['EQR90186'] = 'There isn\'t exist Bay Port for VVD({?msg1})';
  msgs['EQR90187'] = 'Can not use "Row Copy" button when no rows in list.';
  msgs['EQR90188'] = 'The VVD No.({?msg1}) does not exist in VSL SKED.';
  msgs['EQR90189'] = 'The VVD No.({?msg1}) exist already  in Scenario VSL SKED.';
  msgs['EQR90190'] = 'Service Lane code for VVD No.({?msg1}) is empty.';
  msgs['EQR90191'] = '{?msg1} is a mandatory item for inquiry.';
  msgs['EQR90192'] = 'Do you want to save?';
  msgs['EQR90193'] = 'Do you want to delete?';
  msgs['EQR90194'] = 'The same POD exists.';
  msgs['EQR90195'] = 'Period(YYYY-WW) is a mandatory item for inquiry.';
  msgs['EQR90196'] = 'Lane Code is a mandatory item for inquiry.';
  msgs['EQR90197'] = 'There is no such lane code';
  msgs['EQR90198'] = 'VVD Code is a mandatory item for inquiry.';
  msgs['EQR90199'] = 'There is no such VVD code.';
  msgs['EQR90200'] = 'You can remark within 1,000 bytes.';
  msgs['EQR90201'] = 'RCC code is invalid.';
  msgs['EQR90202'] = 'LCC code is invalid.';
  msgs['EQR90203'] = 'ECC code is invalid.';
  msgs['EQR90204'] = 'SCC code is invalid.';
  msgs['EQR90205'] = 'Port code is invalid.';
  msgs['EQR90206'] = 'Yard code is invalid.';
  msgs['EQR90207'] = 'Country code is invalid.';
  msgs['EQR90208'] = 'Do you want to save?';
  msgs['EQR90209'] = 'Do you want to delete?';
  msgs['EQR90210'] = 'The port code exists already.';
  msgs['EQR90211'] = '{?msg1} :  Date format is wrong';
  msgs['EQR90212'] = 'OPT still exists. Please revert it to designated ports for save.';
  msgs['EQR90213'] = '{?msg1} is a mandatory item for inquiry.';
  msgs['EQR90214'] = 'There is no selected row for Row Delete';
  msgs['EQR90215'] = 'End date must be greater than start date.';
  msgs['EQR90216'] = 'Max period is 12 months or 26 weeks';
  msgs['EQR90217'] = 'Max period is 3 months or 12 weeks ';
  msgs['EQR90218'] = 'Yard code is invalid.';
  msgs['EQR90219'] = 'Certain to delete the current MTY COD Confirmation of {?msg1} ?';
  msgs['EQR90220'] = '{?msg1} Vol unmatch between Onboard Total and Discharge Total.';
  msgs['EQR90221'] = 'Max Period is 12 Months';
  msgs['EQR90222'] = 'Date format is wrong.  Please enter a valid date format. [{?msg1}]';
  msgs['EQR90223'] = 'End date must be greater than start date.';
  msgs['EQR90224'] = 'No data found.';
  msgs['EQR90225'] = 'There is no data to save.';
  msgs['EQR90226'] = 'If you change the data of the BASE ITEM with Exceptional cases will be deleted.';
  msgs['EQR90227'] = 'Remark is Empty.';
  msgs['EQR90228'] = 'Date period is over seven days. please reselect date.';
  msgs['EQR90229'] = 'Currently the data is searching. And again, please click on the button "CNTR Input".';
  msgs['EQR90230'] = 'There is no {?msg1}.';
  msgs['EQR90231'] = 'Do you want to execute Optimizer Engine ?';
  msgs['EQR90232'] = 'Repo. Plan ID is not {?msg1}.\nStill need to distribute this Repo. Plan?';
  msgs['EQR90233'] = 'BackEndJob Request Fail!';
  msgs['EQR90234'] = 'It was already created. Please check it again.';
  msgs['EQR90235'] = 'Please input LCC level first';

  msgs['EQR70001'] = 'Certain to save?  FCST Revision for Accuracy Evaluation only available by 17:00, Friday';
  msgs['EQR70002'] = 'Saved Successfully';
  msgs['EQR70003'] = 'Invalid yard with the ECC';
  msgs['EQR70007'] = 'Max Period is 12weeks';
  msgs['EQR70008'] = 'Please check period. The maximum period is 3 months';


  // ============================================================================ //
  ///////////////////////////// TMO 장비 회송 프로젝트 MSG (S) /////////////////////////
  // ============================================================================ //

  msgs['EQR01001'] = 'Saved Successfully.';
  msgs['EQR01002'] = 'Saving has not been completed.';
  msgs['EQR01003'] = 'Please input LCC level first';
  msgs['EQR01004'] = 'RCC code is invalid.';
  msgs['EQR01005'] = 'LCC code is invalid.';
  msgs['EQR01006'] = 'ECC code is invalid.'; 
  msgs['EQR01007'] = 'SCC code is invalid.'; 
  msgs['EQR01008'] = 'Port code is invalid.'; 
  msgs['EQR01009'] = 'Yard code is invalid.'; 
  msgs['EQR01010'] = 'Max Period is 20 weeks';
  msgs['EQR01011'] = 'Max Period is 20 months';
  msgs['EQR01012'] = '{?msg1} is wrong.';
  msgs['EQR01013'] = 'End date must be greater than start date.';  
  msgs['EQR01014'] = 'There are duplicated row with same yard cod and same ETB.\nPlease update data on the pre-created row.';  
  msgs['EQR01015'] = 'There are duplicated row with same condition.\nPlease update data on the pre-created row.';
  msgs['EQR01016'] = 'Insert data already exist. Please retrieve again.';
  msgs['EQR01017'] = 'Update data non-exist. Please retrieve again.';
  msgs['EQR01018'] = 'Max Period is {?msg1}.';  
  msgs['EQR01019'] = 'Total Quantity is zero.';
  msgs['EQR01020'] = '{?msg1} Successfully.';
  msgs['EQR01021'] = 'Only Saved row can be Requested.';
  msgs['EQR01022'] = 'Only Requested row can be Request Canceled.';
  msgs['EQR01023'] = 'Data was changed by others. Please retrieve again.';
  msgs['EQR01024'] = 'Only New row and Saved row can be Deleted.';
  msgs['EQR01025'] = 'Do you want to select row Request ?';
  msgs['EQR01026'] = 'Do you want to select row Request Cancel ?';
  msgs['EQR01027'] = 'LCC is not in [{?msg1}].';
  msgs['EQR01028'] = 'Do you want to proceed with selected row?.';
  msgs['EQR01029'] = 'Please retrieve {?msg1}.';
  msgs['EQR01030'] = 'Want to update MT loading plan with input volume accroding to MT repo guideline?';
  msgs['EQR01031'] = 'No authority to change.';
  msgs['EQR01032'] = 'Create OFC Conti Code Not Found Exception!';
  msgs['EQR01033'] = 'Login OFC Not Found Exception!';
  msgs['EQR01034'] = "Please put VVD first or select VVD after hitting 'VVD search' button for the filtering condition." ;
  
  msgs['EQR01101'] = 'Please input {?msg1}.';
  msgs['EQR01102'] = 'Please select {?msg1}.';
  msgs['EQR01103'] = '{?msg1} is invalid.';
  msgs['EQR01104'] = 'There is no data retrieved.'; 
  msgs['EQR01105'] = '{?msg1} is missing.';
  msgs['EQR01106'] = 'Maximum period is {?msg1}.';
  msgs['EQR01107'] = 'There is no data to save.';  
  msgs['EQR01108'] = 'Could not confirm cancel.'; 
  msgs['EQR01109'] = 'The service is not available now.';
  msgs['EQR01110'] = 'Please input {?msg1}.';
  msgs['EQR01111'] = '{?msg1} :  Date format is wrong';
  msgs['EQR01112'] = 'Amendment is only available for confirmed guideline.';
  msgs['EQR01113'] = '{?msg1} There are duplicated lane.';
  msgs['EQR01114'] = 'There is duplicate POD.';
  msgs['EQR01115'] = 'POD is invalid.';
  msgs['EQR01116'] = 'Confirmed guideline cannot be amended.';
  msgs['EQR01117'] = 'This is not the latest confirmed guideline.';
  msgs['EQR01118'] = 'From date must be earlier than To date.';
  msgs['EQR01119'] = 'To week must be later than From week.';
  
  msgs['EQR01121'] = '{?msg1} is invalid.'; 
  msgs['EQR01122'] = 'Selected data is already exist Repo BKG No.';
  msgs['EQR01123'] = 'Please select REPO BKG(VL) Row.';
  msgs['EQR01124'] = 'Please save inserted data first';
  msgs['EQR01125'] = 'ETB must be later than ETD.';  
  msgs['EQR01126'] = 'Please select POD';  
  msgs['EQR01127'] = 'Vd Split must have bkg no.';  
  msgs['EQR01128'] = 'Please select Trunk Item.';   
  msgs['EQR01129'] = 'VVD Code is a mandatory item for inquiry.';
  msgs['EQR01130'] = 'Row {?msg1} Total Vol = 0 status.\n\n It is possible to enter and modify.';
  msgs['EQR01131'] = 'This VVD isn\'t available.';  
  msgs['EQR01132'] = 'Load Excel will reset grid. \n\n Do you want to load Excel ?';    
  msgs['EQR01133'] = 'Please input VVD Code value.';
  msgs['EQR01134'] = 'POD Yard must be later than POL Yard.';   
  msgs['EQR01135'] = 'Please input Trunk VVD.';   
  
  msgs['EQR01136'] = 'Impossible to update past week data.';   
  msgs['EQR01137'] = 'FCAST cannot be updated this time. \n Plz contact CTY-EQ for FCST Revision.';     
  msgs['EQR01138'] = 'FCST revision for accuracy evaluation only available by 17:00, Friday.';     
  
  msgs['EQR01139'] = 'Could not found VVD (bound to Asia Area) ';  
  msgs['EQR01140'] = 'There is duplicate user id';    
  msgs['EQR01141'] = 'This user id isn\'t available.';  
  msgs['EQR01142'] = 'Please check email address format';  
  
 
  // ============================================================================ //
  ///////////////////////////// TMO 장비 회송 프로젝트 MSG (E) /////////////////////////
  // ============================================================================ //

  msgs['EQR01143'] = 'Please fill in \'%\' column';  
  msgs['EQR01144'] = 'Total value in \'%\' should be 100%';  
  msgs['EQR01145'] = 'Applied Successfully.';   

  // 공통전역변수
  var noSaveData	= 'There is no contents to save';
  var dfUpperChar	= 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

  var red		= '245';
  var green	= '225';
  var blue	= '209';
  var func;
  var grid_savemsg	= "";
  var grid_searcherr	= "";
  var row2modify		= 0;
  var window_orgw		= 1024;
  var window_orgh		= 768;
  var grid_resize_w	= new Array();
  var grid_resize_h	= new Array();
  var grid_resize_wh	= new Array();


	/**
	 * 설  명 : From To 주차의 mandatory 입력할 경우 validation check. <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     chkFromToWeek(formObj,'fmPlnYr','fmPlnWk','FROM')
	 * </pre>
	 * @param {form}	formObj
	 * @param {object}	obj1 - 년도
	 * @param {object}	obj2 - 주차
	 * @param {string}	gubun - String으로 Message출력하기 위한 변수(FROM, TO)
	 * @returns boolean, validation check가 이상없을 경우 true, 아니면 false
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */

	function chkFromToWeek(formObj, obj1, obj2, gubun) {
		if(eval("formObj."+obj1).value.length != 4) {
			ComShowCodeMessage("EQR90017",gubun);
			eval("formObj."+obj1).focus();
			return false;
		}
		if(eval("formObj."+obj2).value.length != 2) {
			ComShowCodeMessage("EQR90018",gubun);
			eval("formObj."+obj2).focus();
			return false;
		}
		return true;
	}

	/**
	 * 설  명 : From To 주차를  Optional 입력할 경우 validation check. <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     chkFromToOptWeek(formObj, 'fmFmPlnYr_2', 'fmFmPlnWk_2', 'fmToPlnYr_2', 'fmToPlnWk_2',
	 *     					'toFmPlnYr_2', 'toFmPlnWk_2', 'toToPlnYr_2', 'toToPlnWk_2')
	 * </pre>
	 * @param {form}	formObj
	 * @param {object}	obj1 - from line 의 객체명.
	 * @param {object}	obj2 - from line 의 객체명.
	 * @param {object}	obj3 - from line 의 객체명.
	 * @param {object}	obj4 - from line 의 객체명.
	 * @param {object}	obj5 - to line 의 객체명.
	 * @param {object}	obj6 - to line 의 객체명.
	 * @param {object}	obj7 - to line 의 객체명.
	 * @param {object}	obj8 - to line 의 객체명.
	 * @returns boolean, validation check가 이상없을 경우 true, 아니면 false
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function chkFromToOptWeek(formObj, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8) {
		var fromChk = eval("formObj."+obj1).value.length + eval("formObj."+obj2).value.length + eval("formObj."+obj3).value.length + eval("formObj."+obj4).value.length;
		var toChk = eval("formObj."+obj5).value.length + eval("formObj."+obj6).value.length + eval("formObj."+obj7).value.length + eval("formObj."+obj8).value.length;

		if(fromChk != '12' && toChk != '12') {
			ComShowCodeMessage("EQR90101");
			eval("formObj."+obj1).focus();
			return false;
		}
		if(fromChk != '0' && fromChk != '12' ) {
			ComShowCodeMessage("EQR90102");
			eval("formObj."+obj1).focus();
			return false;
		}
		if(toChk != '0' && toChk != '12' ) {
			ComShowCodeMessage("EQR90103");
			eval("formObj."+obj5).focus();
			return false;
		}

		return true;
	}

	/**
	 * 설  명 : Period 입력할 경우 validation check. <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     chkPeriodField(formObj , 'st_year' ,'st_weekly')
	 * </pre>
	 * @param {form}	formObj
	 * @param {object}	obj1 - 년도
	 * @param {object}	obj2 - 주차
	 * @returns boolean, validation check가 이상없을 경우 true, 아니면 false
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function chkPeriodField(formObj, obj1, obj2) {
		if(eval("formObj."+obj1).value.length != 4) {
			ComShowCodeMessage("EQR90001","Period");
			eval("formObj."+obj1).focus();
			return false;
		}
		if(eval("formObj."+obj2).value.length != 2) {
			ComShowCodeMessage("EQR90001","Period");
			eval("formObj."+obj2).focus();
			return false;
		}

		return true;
	}

     /*
     * 설  명 : Pln Id or Scnr Id 가 없는 화면중 주차가 있는 화면(madatory)
     * 인자 1 : form객체명.
     * 인자 2 : obj1, obj2, obj3, obj4 : 주차 년월 순서대로.
     * 리턴값 :
     * 예제파일: EES_EQR_071.js 의 validateForm()
     */
    function chkPeriodField2(formObj, obj1, obj2, obj3, obj4) {
        if(eval("formObj."+obj1).value.length != 4) {
        	ComShowCodeMessage("EQR90001","Period");
            eval("formObj."+obj1).focus();
            return false;
        }
        if(eval("formObj."+obj2).value.length != 2) {
        	ComShowCodeMessage("EQR90001","Period");
            eval("formObj."+obj2).focus();
            return false;
        }
        if(eval("formObj."+obj3).value.length != 4) {
        	ComShowCodeMessage("EQR90001","Period");
            eval("formObj."+obj3).focus();
            return false;
        }
        if(eval("formObj."+obj4).value.length != 2) {
        	ComShowCodeMessage("EQR90001","Period");
            eval("formObj."+obj4).focus();
            return false;
        }

        if( ( (eval("formObj."+obj1).value+eval("formObj."+obj2).value).length == 6) &&
            ( (eval("formObj."+obj3).value+eval("formObj."+obj4).value).length == 6) ){
              var fmWk = parseInt(eval("formObj."+obj1).value + eval("formObj."+obj2).value);
              var toWk = parseInt(eval("formObj."+obj3).value + eval("formObj."+obj4).value);

              if(toWk - fmWk < 0){
            	  ComShowCodeMessage("EQR90104");
                eval("formObj."+obj3).focus();
                return false;
              }
        }

        return true;
    }

    /*
     * 설  명 : 주차만 있는 화면에서 한진주차의 validation
     *         from 주차 onChange시 가져온 데이타값으로
     *         to 주차의 onBlur시 사용.
     * 인자 1 : obj1, obj2, obj3, obj4 : 주차 년월 순서대로.
     * 인자 2 : obj5 : frame 명 : 첫문자가 숫자면 안됨. 042frame(X), F042frame(O)
     * 리턴값 :
     * 예제파일: EES_EQR_042.js 의 validateForm()
     */
    function maxPeriodCheck(obj1, obj2, obj3, obj4, obj5){
      if((obj1.value +obj2.value).length != 6){
    	  ComShowCodeMessage("EQR90018","FROM");
          obj1.focus();
          return false;
      }
      if(obj3.value.length == 4 && obj4.value.length == 2){
        var yrwk_e = eval(obj5).document.form.yrwk_e.value;
        var stYrWk  = obj1.value + obj2.value;
        var endYrWk = obj3.value + obj4.value;

        if(yrwk_e.indexOf(endYrWk) == -1){
        	ComShowCodeMessage("EQR90027",stYrWk,eval(obj5).document.form.checkMaxWk.value);
          obj3.value='';
          obj4.value='';
          obj3.focus();
          return false;
        }
      }
    }

    /*
     * 설  명 : 주차만 있는 화면에서 한진주차의 validation
     *         from 주차 onChange시 가져온 데이타값으로
     *         to 주차의 onBlur시 사용. -8주차 체크시 사용
     * 인자 1 : obj1, obj2, obj3, obj4 : 주차 년월 순서대로.
     * 인자 2 : obj5 : frame 명 : 첫문자가 숫자면 안됨. 042frame(X), F042frame(O)
     * 리턴값 :
     * 예제파일: EES_EQR_042.js 의 validateForm()
     */
    function maxBeforePeriodCheck(obj1, obj2, obj3, obj4, obj5){
       if((obj1.value +obj2.value).length != 6){
    	   ComShowCodeMessage("EQR90018","FROM");
          obj1.focus();
          return false;
      }
      if(obj3.value.length == 4 && obj4.value.length == 2){
        var yrwk_e = eval(obj5).document.form.yrwk_e.value;
        var stYrWk  = obj1.value + obj2.value;
        var endYrWk = obj3.value + obj4.value;

        if(yrwk_e.indexOf(endYrWk) == -1){
          ComShowCodeMessage("EQR90027",stYrWk,eval(obj5).document.form.checkMaxWk.value);
          obj3.value='';
          obj4.value='';
          obj3.focus();
          return false;
        }
      }
    }


     /*
     * 설  명 : PlnId 있는 화면에서 한진주차의 validation(from, to 화면.)
     *         from 주차 onChange시 가져온 데이타값으로
     *         to 주차의 onBlur시 사용.
     * 인자 1 : obj1, obj2, obj3, obj4 : 주차 년월 순서대로.
     * 인자 2 : obj5 : frame 명 : 첫문자가 숫자면 안됨. 042frame(X), F042frame(O)
     * 인자 3 : flag : FM or TO or AT
     * 인자 4 : maxWeekly, term, plnyyyyww : maxValueCheck 를 호출하기 위한 값들.
     * 리턴값 :
     * 예제파일: EES_EQR_051.jsp, EES_EQR_051.js
     * TO의 시작주차값은 max 값 체크없이  plan 의 주차보다 크거나 같고  + 9 만 되면 된다.
     * 따라서 maxPeriodSelectOptPlnId 으로 서버에 다녀온 후 validation 체크한다.--> maxPeriodCheckOptPlnId(...)
     * 시작 주차를 변경하지 않는 경우는 서버에 다녀오지 않으므로 planId의 remark 가져올때 가져온 주차 체크값으로 validation 한다.
     * --> maxValueCheck(...)
     */
    function maxPeriodCheckOptPlnId(obj1, obj2, obj3, obj4, periorIframe, flag, maxWeekly, term, plnyyyyww){
      if((obj1.value +obj2.value).length != 6){
    	  ComShowCodeMessage("EQR90018","FROM");
          obj1.focus();
          return false;
      }

      var yrwk_e;
      var checkMaxWk;

      //from 은 plan 주차와 같을때는 Plan id 에서 가져온 값으로 체크한다.
       if(plnyyyyww.value == obj1.value+obj2.value){
         maxValueCheck(obj1, obj2, obj3, obj4,maxWeekly, term, plnyyyyww);
       }else{
           if(flag.toUpperCase() == 'FM'){
            yrwk_e = eval(periorIframe.nam + ".document.form.fm_yrwk_e.value");
            checkMaxWk = eval(periorIframe.name + ".document.form.checkMaxWkFm.value");
          }
          if(flag.toUpperCase() == 'TO'){
            yrwk_e = eval(periorIframe.name + ".document.form.to_yrwk_e.value");
            checkMaxWk = eval(periorIframe.name + ".document.form.checkMaxWkTo.value");
          }
          if(flag.toUpperCase() == 'AT'){
            yrwk_e = eval(pTeriorIframe.name + ".document.form.at_yrwk_e.value");
            checkMaxWk = eval(periorIframe.name + ".document.form.checkMaxWkAt.value");
          }

          if(obj3.value.length == 4 && obj4.value.length == 2){
            var stYrWk  = obj1.value + obj2.value;
            var endYrWk = obj3.value + obj4.value;

            if(yrwk_e.indexOf(endYrWk) == -1){
            	ComShowCodeMessage("EQR90027",stYrWk,checkMaxWk);
                obj3.value='';
                obj4.value='';
                obj3.focus();
                return false;
            }
          }
       }
    }

    /*
     * FM 주차를 변경시 서버 Data 가져오기.(pln id 있는 경우)
     * fm,to,at 의 객체를 모두 넘긴다.
     * gijun : FM or TO or AT
     * objFmSYr, objFmSWk, objFmEYr, objFmEWk : FM 객체.
     * objToSYr, objToSWk, objToEYr, objToEWk : TO 객체.
     * objAtSYr, objAtSWk, objAtEYr, objAtEWk : AT 객체.
     * plnyyyyww : plan 주차 객체.
     * 서버에 가기전에 plan 주차보다 크거나 같은지 체크한다.
     */
    function maxPeriodSelectOptPlnId(gijun, objFmSYr, objFmSWk, objFmEYr, objFmEWk, objToSYr, objToSWk, objToEYr, objToEWk, objAtSYr, objAtSWk, objAtEYr, objAtEWk, plnyyyyww){
        fm_yrwk = objFmSYr.value + objFmSWk.value;
        to_yrwk = objToSYr.value + objToSWk.value;
        at_yrwk = objAtSYr.value + objAtSWk.value;

        var lengthObj;
        var nullEYr;
        var nullEWk;
        var checkSYr;
        var checkSWk;

        if(gijun.toUpperCase() == 'FM'){
          lengthObj = 'fm_yrwk';
          nullEYr = 'objFmEYr';
          nullEWk = 'objFmEWk';
          checkSYr = 'objFmSYr';
          checkSWk = 'objFmSWk';
        }
        if(gijun.toUpperCase() == 'TO'){
          lengthObj = 'to_yrwk';
          nullEYr = 'objToEYr';
          nullEWk = 'objToEWk';
          checkSYr = 'objToSYr';
          checkSWk = 'objToSWk';
        }
        if(gijun.toUpperCase() == 'AT'){
          lengthObj = 'at_yrwk';
          nullEYr = 'objAtEYr';
          nullEWk = 'objAtEWk';
          checkSYr = 'objAtSYr';
          checkSWk = 'objAtSWk';
        }

        if(eval(lengthObj).length == 6){

          if(parseInt(eval(checkSYr).value + eval(checkSWk).value) < parseInt(plnyyyyww.value)){
        	  ComShowCodeMessage("EQR90028");
  	           eval(checkSYr).value = '';
  	           eval(checkSWk).value = '';
      	  		 eval(checkSYr).focus();
      	  		 return;
          }

          //edit 시 to 주차는 초기화.(onblur 시 이전 max값을 가지고 잇는 것을 방지)
          eval(nullEYr).value = '';
          eval(nullEWk).value = '';

          var result = "";
  	      document.form.f_cmd.value = SEARCHLIST15;
          document.form.target="periorIframe";
          //default로 현재일자의 주차에서 +9주차까지를 조회조건에 입력한다.
          document.form.action="EES_CHECK_PERIOD.do?gapmonth=4&gubun=FMTOAT&editmonth=9&fm_yrwk="+fm_yrwk+"&to_yrwk="+to_yrwk+"&at_yrwk="+at_yrwk;
          result = document.form.submit();
        }
    }

     /*
     * 설  명 : 주차만 있는 화면에서 한진주차의 validation(from, to 중 하나만 입력하는 화면.)
     *         from 주차 onChange시 가져온 데이타값으로
     *         to 주차의 onBlur시 사용.
     * 인자 1 : obj1, obj2, obj3, obj4 : 주차 년월 순서대로.
     * 인자 2 : obj5 : frame 명 : 첫문자가 숫자면 안됨. 042frame(X), F042frame(O)
     * 인자 3 : flag : FM or TO or AT
     * 리턴값 :
     * 예제파일: EES_EQR_037.jsp, EES_EQR_037.js
     */
    function maxPeriodCheckOpt(obj1, obj2, obj3, obj4, obj5, flag){
      if((obj1.value +obj2.value).length != 6){
    	  ComShowCodeMessage("EQR90018","FROM");
          obj1.focus();
          return false;
      }

      var yrwk_e;
      var checkMaxWk;

      if(flag.toUpperCase() == 'FM'){
        yrwk_e = eval(obj5.name + ".document.form.fm_yrwk_e.value");
        checkMaxWk = eval(obj5.name + ".document.form.checkMaxWkFm.value");
      }
      if(flag.toUpperCase() == 'TO'){
        yrwk_e = eval(obj5.name + ".document.form.to_yrwk_e.value");
        checkMaxWk = eval(obj5.name + ".document.form.checkMaxWkTo.value");
      }
      if(flag.toUpperCase() == 'AT'){
        yrwk_e = eval(obj5.name + ".document.form.at_yrwk_e.value");
        checkMaxWk = eval(obj5.name + ".document.form.checkMaxWkAt.value");
      }

      //fm을 고치치 않고 to만 고친경우는 default 를 참조.
      if(checkMaxWk == ''){
        yrwk_e = eval(obj5.name + ".document.form.yrwk_e.value");
        checkMaxWk = eval(obj5.name + ".document.form.checkMaxWk.value");
      }

      if(obj3.value.length == 4 && obj4.value.length == 2){
        var stYrWk  = obj1.value + obj2.value;
        var endYrWk = obj3.value + obj4.value;

        if(yrwk_e.indexOf(endYrWk) == -1){
        	ComShowCodeMessage("EQR90027",stYrWk,checkMaxWk);
          obj3.value='';
          obj4.value='';
          obj3.focus();
          return ;
        }
      }
    }

    /*
     * FM 주차를 변경시 서버 Data 가져오기.
     * fm,to,at 의 객체를 모두 넘긴다.
     * gijun : FM or TO or AT
     * objFmSYr, objFmSWk, objFmEYr, objFmEWk : FM 객체.
     * objToSYr, objToSWk, objToEYr, objToEWk : TO 객체.
     * objAtSYr, objAtSWk, objAtEYr, objAtEWk : AT 객체.
     */
    function maxPeriodSelectOpt(gijun, objFmSYr, objFmSWk, objFmEYr, objFmEWk, objToSYr, objToSWk, objToEYr, objToEWk, objAtSYr, objAtSWk, objAtEYr, objAtEWk){
        fm_yrwk = objFmSYr.value + objFmSWk.value;
        to_yrwk = objToSYr.value + objToSWk.value;
        at_yrwk = objAtSYr.value + objAtSWk.value;

        var lengthObj;
        var nullEYr;
        var nullEWk;

        if(gijun.toUpperCase() == 'FM'){
          lengthObj = 'fm_yrwk';
          nullEYr = 'objFmEYr';
          nullEWk = 'objFmEWk';
        }
        if(gijun.toUpperCase() == 'TO'){
          lengthObj = 'to_yrwk';
          nullEYr = 'objToEYr';
          nullEWk = 'objToEWk';
        }
        if(gijun.toUpperCase() == 'AT'){
          lengthObj = 'at_yrwk';
          nullEYr = 'objAtEYr';
          nullEWk = 'objAtEWk';
        }

        if(eval(lengthObj).length == 6){

          //edit 시 to 주차는 초기화.(onblur 시 이전 max값을 가지고 잇는 것을 방지)
          eval(nullEYr).value = '';
          eval(nullEWk).value = '';

          var result = "";
  	      document.form.f_cmd.value = SEARCHLIST15;
          document.form.target="periorIframe";
          //default로 현재일자의 주차에서 +4주차까지를 조회조건에 입력한다.
          document.form.action="EES_CHECK_PERIOD.do?gapmonth=4&gubun=FMTOAT&editmonth=4&fm_yrwk="+fm_yrwk+"&to_yrwk="+to_yrwk+"&at_yrwk="+at_yrwk;
          result = document.form.submit();
        }
    }

    /*
     * CSR No : N200805150003 - Execution Performance & Feedback Inquiry 화면 보완
     * FM 주차를 변경시 서버 Data 가져오기.
     * fm,to,at 의 객체를 모두 넘긴다.
     * gijun : FM or TO or AT
     * objFmSYr, objFmSWk, objFmEYr, objFmEWk : FM 객체.
     * objToSYr, objToSWk, objToEYr, objToEWk : TO 객체.
     * objAtSYr, objAtSWk, objAtEYr, objAtEWk : AT 객체.
     */
    function maxPeriodSelectOpt_Gap(gijun, objFmSYr, objFmSWk, objFmEYr, objFmEWk, objToSYr, objToSWk, objToEYr, objToEWk, objAtSYr, objAtSWk, objAtEYr, objAtEWk, gapValue1, gapValue2){
        fm_yrwk = objFmSYr.value + objFmSWk.value;
        to_yrwk = objToSYr.value + objToSWk.value;
        at_yrwk = objAtSYr.value + objAtSWk.value;

        var lengthObj;
        var nullEYr;
        var nullEWk;

        if(gijun.toUpperCase() == 'FM'){
          lengthObj = 'fm_yrwk';
          nullEYr = 'objFmEYr';
          nullEWk = 'objFmEWk';
        }
        if(gijun.toUpperCase() == 'TO'){
          lengthObj = 'to_yrwk';
          nullEYr = 'objToEYr';
          nullEWk = 'objToEWk';
        }
        if(gijun.toUpperCase() == 'AT'){
          lengthObj = 'at_yrwk';
          nullEYr = 'objAtEYr';
          nullEWk = 'objAtEWk';
        }

        if(eval(lengthObj).length == 6){

          //edit 시 to 주차는 초기화.(onblur 시 이전 max값을 가지고 잇는 것을 방지)
          eval(nullEYr).value = '';
          eval(nullEWk).value = '';

          var result = "";
  	      document.form.f_cmd.value = SEARCHLIST15;
          document.form.target="periorIframe";
          //default로 현재일자의 주차에서 +4주차까지를 조회조건에 입력한다.
          document.form.action="EES_CHECK_PERIOD.do?gapmonth="+gapValue1+"&gubun=FMTOAT&editmonth="+gapValue2+"&fm_yrwk="+fm_yrwk+"&to_yrwk="+to_yrwk+"&at_yrwk="+at_yrwk;
          result = document.form.submit();
        }
    }


    /**
     * Inquire ID List 에서 주차 체크.
     * 00-53주까지 입력여부 확인.
     * TO주차가 FROM 주차보다 큰지 확인.
     * EES_EQR_002.jsp 참고.(002,045,106,107)
     */
    function checkWeekInqireList(sYear, sWeek, eYear, eWeek){
        if((sYear.value +sWeek.value).length == 6){
            if(parseInt(sWeek.value) > 53){
            	ComShowCodeMessage("EQR90113","Weekly");
              sWeek.value = '';
              sWeek.focus();
              return false;
            }
        }
        if((eYear.value +eWeek.value).length == 6){
            if(parseInt(eWeek.value) > 53){
              ComShowCodeMessage("EQR90113","Weekly");
              eWeek.value = '';
              eWeek.focus();
              return false;
            }
        }
        if( (sYear.value +sWeek.value).length == 6 && (eYear.value +eWeek.value).length == 6 ){
          if(parseInt(sYear.value + sWeek.value) > parseInt(eYear.value + eWeek.value)){
        	  ComShowCodeMessage("EQR90114");
            eYear.value = '';
            eWeek.value = '';
            eYear.focus();
            return false;
          }
        }
    }

    function chkPlanId(formObj, obj1, obj2) {
        if(eval("formObj."+obj1).value.length != 6) {
		   // CSR No : R200905150001 - 한글메세지 영문으로 수정
		   // modified by Haeng-ji,Lee 2009-05-18
        	ComShowCodeMessage("EQR90001","Plan ID");
            eval("formObj."+obj1).focus();
            return false;
        }
        if(eval("formObj."+obj2).value.length != 3) {
			// CSR No : R200905150001 - 한글메세지 영문으로 수정
		    // modified by Haeng-ji,Lee 2009-05-18
        	ComShowCodeMessage("EQR90001","Plan ID");
            eval("formObj."+obj2).focus();
            return false;
        }
        return true;
    }

    function chkScenarioId(formObj, obj1, obj2) {
        if(eval("formObj."+obj1).value.length != 6) {
        	ComShowCodeMessage("EQR90001","Scenario ID");
            eval("formObj."+obj1).focus();
            return false;
        }
        if(eval("formObj."+obj2).value.length != 3) {
        	ComShowCodeMessage("EQR90001","Scenario ID");
            eval("formObj."+obj2).focus();
            return false;
        }
        return true;
    }

    function chkRepoplanId(formObj, obj1, obj2) {
        if(eval("formObj."+obj1).value.length != 6) {
        	ComShowCodeMessage("EQR90001","Repoplan ID");
            eval("formObj."+obj1).focus();
            return false;
        }
        if(eval("formObj."+obj2).value.length != 3) {
        	ComShowCodeMessage("EQR90001","Repoplan ID");
            eval("formObj."+obj2).focus();
            return false;
        }
        return true;
    }

    function checkTpszCombo(index) {
        if(comboObjects[index] != null && comboObjects[index].Code == "") {
        	ComShowCodeMessage("EQR90016","TP/SZ");
            comboObjects[index].focus();
            return false;
        }
        return true;
    }

    function checkLocItem(formObj, obj1, obj2) {
        if(!eval("formObj."+obj1).options[eval("formObj."+obj1).selectedIndex].value == "") {
            if(trim(eval("formObj."+obj2).value) == "") {
            	ComShowCodeMessage("EQR90001","Location");
                eval("formObj."+obj2).value = "";
                eval("formObj."+obj2).focus();
                return false;
            }
        }
        return true;
    }

    /*
     * 설  명 : 14개 tpsz일 경우 O2선택시 A2, F2선택시 S2를 넣어준다.
     * 인자 1 : index - tpsz의 Combo index.
     * 각 화면에 hidden 으로 있어야할 객체명 : <input type="hidden" name="oddtpsz" value="">
     * doActionIBSheet의   case IBSEARCH: 부분에서  oddTpsz(0)을 호출한다.
     * 이후 조회및 저장시 oddtpsz을 가지고 가야한다.
     * 리턴값 :
     * 예제파일:
     */
    function oddTpsz(index){
      tpsz = comboObjects[index].Code;
      if(tpsz.search('O2') != -1){
        tpsz = tpsz + ',A2';
      }
      if(tpsz.search('O4') != -1){
        tpsz = tpsz + ',A4';
      }
      if(tpsz.search('F2') != -1){
        tpsz = tpsz + ',S2';
      }
      if(tpsz.search('F4') != -1){
        tpsz = tpsz + ',F5,S4';        // Project - 신규장비(F5-40ft H/C Flat Rack)발주에 따른 NIS상에 F5등록
      }


      document.form.oddtpsz.value = tpsz;
    }

    /*
     * 설  명 : input박스에서 maxlength만큼 적으면 다른 input박스로 이동시 사용
     * 인자 1 : obj1 - this, obj2 - 이동할 필드이름
     * 리턴값 :
     * 예제파일: EES_EQR_007.jsp
     */
  	function moveTab(obj1, obj2){
  		if(obj1.maxLength == obj1.value.length) {
  		    obj2.value = '';
  			obj2.focus();
  		}
  	}

  	    /*
     * 설  명 : input박스에서 maxlength만큼 적으면 다른 input박스로 이동시 사용
     * 인자 1 : obj1 - this, obj2 - 이동할 필드이름
     * 리턴값 :
     * 예제파일: EES_EQR_007.jsp
     */
  	function moveTabNormal(obj1, obj2){
  		if(obj1.maxLength == obj1.value.length) {
  			obj2.focus();
  		}
  	}


  	 /*
     * 설  명 :REPO PLN 에서 디폴트 4주, MAX 12주 입력시. to의 주차가 12주 이내인지 체크할때 사용.
	 * 인자 1 : obj1 - FROM의 입력년도
     * 인자 2 : obj2 - FROM의 입력주차.
     * 인자 3 : obj3 - TO의 입력년도
     * 인자 4 : obj4 - TO의 입력주차.
     * 인자 5 : obj5 - Max check 기준년도+주차.
     * 인자 6 : check - 체크할 주차수(ex. '12')
     * 인자 7 : obj6 - Plan ID 의 주차. (ex. REPO200636W001 이라면, obj6 = 200636)
     * 리턴값 :
     * 예제파일: EES_EQR_112.jsp
     */
	function maxValueCheck(obj1, obj2, obj3, obj4, obj5, check, obj6){

  	    fromVal  = obj1.value + obj2.value;
		inputVal = obj3.value + obj4.value;
        maxVal = obj5.value;
  	  	plnVal   = obj6.value;
  	  	inputCheck = true;

        if(fromVal.length == 6 && inputVal.length == 6){
          //scenario, repo pln 각 화면에 있는 객체.(,로 연결된 주차값들)

          var maxWkStr;

          if(document.form.maxWkStr != null){//REPO_PLN
                maxWkStr = document.form.maxWkStr.value;
          }else{//SCNR
                maxWkStr = document.form.perfix_weekly.value;
          }

          if(maxWkStr.search(fromVal) == -1 ){
        	  ComShowCodeMessage("EQR90133","FROM ");
              obj1.value = '';
  	          obj2.value = '';
  	          obj1.focus();
          }

          if(maxWkStr.search(inputVal) == -1 ){
        	  ComShowCodeMessage("EQR90133","TO ");
              obj3.value = '';
      	  	  obj4.value = '';
      	  	  obj3.focus();
          }

          //fm 주차가 pln 주차보다 크거나 같도, max주차보다 작거나 같게.
  	      if(parseInt(fromVal) < parseInt(plnVal)){
  	    	   ComShowCodeMessage("EQR90028");
  	           obj1.value = '';
  	           obj2.value = '';
      	  	   obj1.focus();
  	      }else if(parseInt(fromVal) > parseInt(maxVal)){
  	    	  ComShowCodeMessage("EQR90115",maxVal);
  	           obj1.value = '';
  	           obj2.value = '';
      	  	   obj1.focus();
  	      }else if(parseInt(fromVal) > parseInt(inputVal)) {
  	    	  ComShowCodeMessage("EQR90116",fromVal);
      	  		obj3.value = '';
      	  		obj4.value = '';
      	  		obj3.focus();
      		}else if(parseInt(inputVal) > parseInt(maxVal)) {

      			ComShowCodeMessage("EQR90071",plnVal ,check);
      		    obj3.value = '';
      		    obj4.value = '';
      			obj3.focus();
      		}
        }
  	}

    /*
     * 설  명 : 필드의 값을 대문자로 바꾼 후 세팅한다.
     *          onblur 이벤트에서 사용함.
     * 인자 1 :
     * 리턴값 :
     * 예제파일: COM_ENS_011.jsp
     */
    function upperCase() {
    	var obj = event.srcElement;

		//백스페이스 및 방향키등등..일경우.. 리턴처리
		if (window.event.keyCode==8 || window.event.keyCode==9 ||
			window.event.keyCode==16 || window.event.keyCode==35 ||
            window.event.keyCode==36 || window.event.keyCode==37 ||
            window.event.keyCode==39 || window.event.keyCode==46){
			return;
		}

		var ret = /[^a-zA-Z|\,]/g;
		var val = obj.value.replace(ret,'');
		obj.value = val.toUpperCase();
    }

    /*
     * 설  명 : 필드의 값을 대문자로 바꾼 후 세팅한다.
     *          0-9 까지의 정수도 수용한다.
     *          onblur 이벤트에서 사용함.
     * 인자 1 :
     * 리턴값 :
     * 예제파일: EES_EQR_059.jsp
     */
    function upperCase_Num() {
    	var obj = event.srcElement;

		//백스페이스 및 방향키등등..일경우.. 리턴처리
		if (window.event.keyCode==8 || window.event.keyCode==9 ||
			window.event.keyCode==16 || window.event.keyCode==35 ||
            window.event.keyCode==36 || window.event.keyCode==37 ||
            window.event.keyCode==39 || window.event.keyCode==46){
			return;
		}

		var ret = /[^a-zA-Z^0-9|\,]/g;
		var val = obj.value.replace(ret,'');
		obj.value = val.toUpperCase();
    }

    /*
     * 설  명 : CRE_DT , UPD_DT 차이가 있으면 해당 row 의 색깔을 변경.(timegap ='Y')
     *          화면에서 차이컬럼의 이름을 timegap 으로 가져와야함.
     * 인자 1 : sheetObj
     * 인자 2 : type : 헤더가 2줄이면 '2', 헤더가 한줄이면 '1'
     * 예제파일: EES_EQR_117.jsp
     */
//     var lColor = sheetObj.RgbColor(red,green,blue);
     function setColor(sheetObj,type)
     {
        var lColor = sheetObj.RgbColor(red,green,blue);
        var rowCnt = sheetObj.RowCount('');
        if(type=='2'){
          for(var row = 2; row <= rowCnt +1 ; row++){
             if(sheetObj.CellValue(row, 'timegap') == 'Y'){
               sheetObj.RowBackColor(row) = lColor;
             }
          }
        }else{
             for(var row = 1; row <= rowCnt ; row++){
             if(sheetObj.CellValue(row, 'timegap') == 'Y'){
               sheetObj.RowBackColor(row) = lColor;
             }
          }
        }
      }

     /*
     * 설  명 : SubSumColor를 별도로 변경시킬경우.
     * 인자 1 : sheetObj
     * 인자 2 : 소계를 계산할 기준 컬럼명.
     * ex. setSubSumColor(docObjects[1], "fm_rcc_cd");
     * 예제파일: EES_EQR_090.js
     */
      function setSubSumColor(sheetObj, stdCol) {

          var sRow = sheetObj.FindSubSumRow(stdCol);
          var arrRow = sRow.split("|");
          for (idx=0; idx<arrRow.length-1; idx++){
            sheetObj.RowBackColor(arrRow[idx])  =  sheetObj.RgbColor(232,255,198);
          }

      }

    /*
     * 숫자만 입력.
     * onKeyPress="return onlyNumberInput(event)"
     */
  	function onlyNumberInput( e)
    {
    	var obj = event.srcElement;

		//백스페이스 및 방향키등등..일경우.. 리턴처리
		if (window.event.keyCode==8 || window.event.keyCode==9 ||
			window.event.keyCode==16 || window.event.keyCode==35 ||
            window.event.keyCode==36 || window.event.keyCode==37 ||
            window.event.keyCode==39 || window.event.keyCode==46){
			return;
		}

		var ret = /[^0-9]/g;
		var val = obj.value.replace(ret,'');
		obj.value = val;

    }


    /*
     * 숫자 + .
     * onKeyPress="return onlyNumberInputDot(event)"
     */
    function onlyNumberInputDot( e)
    {
    	var obj = event.srcElement;

		//백스페이스 및 방향키등등..일경우.. 리턴처리
		if (window.event.keyCode==8 || window.event.keyCode==9 ||
			window.event.keyCode==16 || window.event.keyCode==35 ||
            window.event.keyCode==36 || window.event.keyCode==37 ||
            window.event.keyCode==39 || window.event.keyCode==46){
			return;
		}

		var ret = /[^0-9|\.]/g;
		var val = obj.value.replace(ret,'');

		//마지막 '.'만 남기고 나머지 '.'는 제거
		if(val.indexOf('.') != -1) {
			var dotIdx = val.indexOf('.');
			if (dotIdx != val.length) {
				val = obj.value.replace(/[\.]/g,'');
				val = val.substring(0, dotIdx) + '.' + val.substring(dotIdx, val.length);
			}
		}
        obj.value = val;

    }

    /*
     * 설  명 : string의 앞뒤 공백을 제거
     * 인  자 : string
     * 리턴값 : 공백제거된 inStr
     * 예제파일: COM_ENS_105.jsp
     */
	function trim(inStr) { // string null (trim)
		var re = / /gi;
		inStr = inStr.replace(re, "");
		return inStr;
	}



	/*
	 *  gubun1 = 구분자
	 *  gubun2 = 바뀔문자
	 */
	function replaceAll(Str ,gubun1 ,gubun2){
		var Strname  = Str.split(gubun1);
		var returnStr ="";

		for(i=0 ; i < Strname.length ; i++) {
			if ( i == Strname.length-1 ){
				returnStr = returnStr + Strname[i];
			} else {
				returnStr = returnStr + Strname[i]+gubun2;
			}
		}
		return returnStr;
	}





	//-----------------------------------------------------------------------------------
	// 공통스크립트 파일에 toggleSheetSize() 메소드 추가
	//-----------------------------------------------------------------------------------
	function toggleSheetSize(){
		var obj = event.srcElement;
		var status = "N";
		if(obj.maxStatus == undefined || obj.maxStatus == "N"){
			status = "M";
		}
		var sheetId = obj.sheetId;
		var sheetObj = document.getElementById(sheetId);
		var type = obj.type;
		if(sheetId == undefined || type == undefined) return;
		var area = obj.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement;

		var main = document.getElementById('main');
		var tables = main.children;
		var titleArea = tables[1];
		var posTop = titleArea.offsetTop + titleArea.offsetHeight;
		for(var i = 0 ; i < tables.length ; i++){
			if(tables[i].className == "title" || tables[i].className == "button" || tables[i] == area){
				continue;
			}
			if(status == "M"){
				tables[i].orgDisplay = tables[i].style.display;
				tables[i].style.display = "none";
			}
			else{
				tables[i].style.display = tables[i].orgDisplay;
			}
		}
		if(status == "M"){
			var etcHeight = area.offsetHeight - sheetObj.offsetHeight;

			var tableObj = document.getElementsByTagName('TABLE');
			var copyArea = tableObj[1];

			var sizeHeight = document.body.clientHeight - posTop - etcHeight - copyArea.rows[1].offsetHeight - 50;
			area.sheetHeight = sheetObj.style.height;
			sheetObj.style.height = sizeHeight;
			obj.maxStatus = "M";
			obj.src = "/hanjin/img/bu_prev01.gif";
		}
		else{
			sheetObj.style.height = area.sheetHeight;
			obj.maxStatus = "N";
			obj.src = "/hanjin/img/bu_next01.gif";
		}
	}

	/* DataSheet.js */

	function dsColSaveName(obj,Col) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Col==null)	Col = obj.SelectCol;

		return(obj.ColSaveName(Col));
	}

	function dsGetRowStatus(obj,Row) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Row==null)	Row = obj.SelectRow;

		return(obj.RowStatus(Row));
	}

	function dsGetSelectRow(obj) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);

		return(obj.SelectRow);
	}

	function dsSetValue(obj,Value,Row,Col) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Row==null)	Row = obj.SelectRow;
		if (Col==null)	Col = obj.SelectCol;
		obj.CellValue2(Row, Col) = Value;
	}

	function dsGetValue(obj,Row,Col) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Row==null)	Row = obj.SelectRow;
		if (Col==null)	Col = obj.SelectCol;

		return(obj.CellValue(Row, Col));
	}

	function dsIsInit(obj) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);

		return eval(obj.id + '_common').isinit;
	}

	function dsRowCount(obj,Status) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Status==null)
			return(obj.RowCount);
		else
			return(obj.RowCount(Status));
	}

	function dsSelectCell(obj,Row,Col,EditMode) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Row==null)	Row = obj.SelectRow;
		if (Col==null)	Col = obj.SelectCol;
		if (EditMode==null)	EditMode = true;
		obj.SelectCell(Row,Col,EditMode);
	}

	function dsSetRowStatus(obj,Status,Row) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Row==null)	Row = obj.SelectRow;
		obj.RowStatus(Row) = Status;
	}

	function initSelectList(obj) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		eval(obj.id + '_sellst').count = 0;
		eval(obj.id + '_common').isinit = true;
	}

	function makeSelectList(obj) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);

		var sRowStr = obj.GetSelectionRows();
		var sRowArr = sRowStr.split("|");

		var selcnt = eval(obj.id + '_sellst').count;

		eval(obj.id + '_sellst').index = sRowArr;
		eval(obj.id + '_sellst').count = sRowArr.length;
		eval(obj.id + '_common').isinit = false;

		return sRowArr;
	}

	function makeCodeParam(codeinfo) {
		var codeparam = "";
		var gridCodeResetInfo = new Array("compcd","cvid","grpcd","detailcd","wkdt","locatecd","inwhere","tabwhere","cdid","cdnm","incd","param1","param2","param3","param4","param5","initvalue","inittext","savename","viewdetailcd");
		var gridCodeInfoName = new Array();
		var gridCodeInfoValue = new Array();

	 	codeinfo = replace(codeinfo,"&amp;","¤amp;");
		var tmpCodeInfo = codeinfo.split("&");
		for (var i=0; i<tmpCodeInfo.length; i++) {
	 		tmpCodeInfo[i] = replace(tmpCodeInfo[i],"¤amp;","&amp;");
			var tmp = tmpCodeInfo[i].split("=");
			gridCodeInfoName[i] = tmp[0];
			gridCodeInfoValue[i] = "";
			for (var j=1; j<tmp.length; j++) {
				gridCodeInfoValue[i] += "=" + tmp[j];
			}
			gridCodeInfoValue[i] = gridCodeInfoValue[i].substring(1);
		}

		for (var i=0; i<gridCodeResetInfo.length; i++) {
			var isexist = false;
			var tmpparam = "";
			for (var j=0; j<tmpCodeInfo.length; j++) {

				if (gridCodeResetInfo[i] == gridCodeInfoName[j]) {
					tmpparam = gridCodeInfoName[j] + "=" + encodeURI(parseCodeUrl(gridCodeInfoValue[j]));
					isexist = true;
				}
			}

			if (i==0)	codeparam += "";
			else		codeparam += "&";

			if (isexist)	codeparam += tmpparam;
			else			codeparam += gridCodeResetInfo[i] + "=";
		}

		return codeparam;
	}

	function retrieveCode(obj) {
		var i, condparam="", codenamestr="",codestr="",vdefault="",tdefault="",savename="";
		var colcnt = obj.LastCol;

		if ((eval(obj.id+'_common').checkcode=="0")&&(eval(obj.id+'_common').codeparam != "")){

			obj.DoSearch("/GridCodeRetrieveAction.do",parseCodeUrl(eval(obj.id+'_common').codeparam),"",true);
			for (i=0; i <= colcnt; i++) {

				vdatatype = obj.ReadDataProperty(0, i, dpDataType);

				if ((vdatatype == 6)||(vdatatype == 7)) {

					savename = obj.ColSaveName(i);
					codenamestr = obj.EtcData("codename_"+savename);
					codestr = obj.EtcData("code_"+savename);
					tdefault = obj.EtcData("tdefault_"+savename);
					vdefault = obj.EtcData("vdefault_"+savename);

					if ((codestr!="") && (codestr!=null)) {
						obj.InitDataCombo(0,savename,codenamestr,codestr,tdefault,vdefault);
					}
				}
			}
			if (eval(obj.id+'_common').codeparam.indexOf('[$') >= 0)
				eval(obj.id+'_common').checkcode = "0";
			else
				eval(obj.id+'_common').checkcode = "1";
		}
	}

	function setFreeform2Grid(obj,formname) {

		if (typeof obj=="string")	obj = eval('document.all.'+obj);

		// 전체 발리데이션 체크
		var bool = checkValidation(formname);
		if (!bool){
			obj.SelectCell(row2modify,1,false);
			return false;
		}
		else {
			var colcnt = obj.LastCol;
			for (i=0; i <= colcnt; i++) {
				var field = eval('document.'+formname+'.'+obj.ColSaveName(i));
				if(field != null) {
					obj.CellValue2(row2modify,i) = field.value;
				}
			}
			return true;
		}
	}

	function setGrid2Freeform(obj,formname,isParent) {

	 	var selcnt = 0;
	 	if (isParent) {
	 		if (typeof obj=="string")	obj = eval('parent.document.all.'+obj);
			if (!dsIsInit(obj)) {
				parent.makeSelectList(obj);
				selcnt = parent.eval(obj.id + '_sellst').count;
			}
	 	} else {
	 		if (typeof obj=="string")	obj = eval('document.all.'+obj);
			if (!dsIsInit(obj)) {
				makeSelectList(obj);
				selcnt = eval(obj.id + '_sellst').count;
		 	}
		}

		if (selcnt > 0) {
			var	row = obj.SelectRow;
			row2modify = row;
			var colcnt = obj.LastCol;

			for (i=0; i <= colcnt; i++) {
				if (obj.ColSaveName(i) == null || obj.ColSaveName(i) == "") {
				}else{
					//var field = eval('document.'+formname+'.'+obj.ColSaveName(i));
					var field = eval('document.'+formname+'.elements(\''+obj.ColSaveName(i)+'\')');
					if(field != null) {
						var value = obj.CellValue(row,i);
						if(field.type=='checkbox'){
						// 필드가 체크박스는 무조건 YN 또는 10 이다.
						if (value=='Y'||value==1||field.value==value) {
								field.checked = true;
							} else {
								field.checked = false;
							}
						} else if(field.type==null && field[0].type=='checkbox'){
						// 필드가 체크박스가 여러개 값이 'aaa','bbb','ccc' 또는 aaa|bbb|ccc 이렇게 있다.
						var arr = null;
							if (value.indexOf('\',\'') >-1) {
								arr = eval('new Array('+value+')');
							} else if (value.indexOf('|') >-1) {
								arr = value.split('|');
							} else {
								arr = new Array(value);
							}
							for (var j=0; j< field.length; j++) {
								field[j].checked = false;
							}
							for (var i=0; i< arr.length; i++) {
								for (var j=0; j< field.length; j++) {
									if (arr[i]==field[j].value) field[j].checked = true;
								}
							}
						} else if(field.type=='radio'){
						// 필드가 라디오 버튼인 경우.
						if (field.value==value) {
								field.checked = true;
							} else {
								field.checked = false;
							}
						} else if(field.type==null && field[0].type=='radio'){
						// 필드가 여러개의 라디오 버튼인 경우.
						if (value=='') {
								for(var j=0;j<field.length;j++) {
									field[j].checked = false;
								}
							} else {
								for(var j=0;j<field.length;j++) {
									if (field[j].value == value) field[j].checked = true;
									else field[j].checked = false;
								}
							}
						} else if(field.type=='select-one'){
						// 필드가 셀렉트박스인경우.
						if (value=='') {
								field.value='';
							} else {
								for(var j=0;j<field.options.length;j++) {
									if (field.options[j].value == value) field.options[j].selected = true;
								}
							}
						} else {
						// 기타 다른 필드인경우.
						field.value	= value;
						}

						var fieldview = eval('document.'+formname+'.'+obj.ColSaveName(i)+'View');
						if(fieldview != null) {
							if (obj.ReadDataProperty(0, i, dpDataFormat)==2) { // 년월 날짜인경우
							fieldview.value = getYearMonth(parseInputYearMonth(value));
							} else if (obj.ReadDataProperty(0, i, dpDataFormat)==1) { // 년월일 날짜인경우
							fieldview.value = getDate(parseInputDate(value));
							} else if ((obj.ReadDataProperty(0, i, dpDataType)==6)||(obj.ReadDataProperty(0, i, dpDataType)==7)||(obj.ReadDataProperty(0, i, dpDataType)==8)){ // 콤보인경우
							fieldview.value = obj.CellText(row, i);
							}
						}
					}
				}
			}
		}
		// 직원검색 프리폼에 상세정보를 보여줌.
		var emparray = null;
		if (isParent) {
			emparray = eval('parent.'+obj.id+'_common.empsavename');
		} else {
			emparray = eval(obj.id+'_common.empsavename');
		}

		for(var k=0;k<emparray.length;k++) {
			var field = eval('document.'+formname+'.'+emparray[k]+'View');
			if(field != null) {
				// empid / jobgrdnm / deptnm
				field.value = obj.CellValue(row, emparray[k]+'empid') + '/' + obj.CellValue(row, emparray[k]+'jobgrdnm') + '/' + obj.CellValue(row, emparray[k]+'deptnm');
			}
		}
	}

    /*
     * 설  명 : sheet에서 시작위치에 데이타를 보여주는 기능
     * 인자 1 : xml 문자열
     * 인자 2 : sheet객체
     * 인자 3 : 시작 Row
     * 예제파일: EES_EQR_5001.js
     */
    function EqrXml2SheetRows(xmlStr, sheetObj, StartRow) {
    	if (xmlStr == null || xmlStr == "" || sheetObj == null || sheetObj == "") {
    		return;
    	}
    	if (StartRow == null || StartRow == "" ) {
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

    		for (var i = 0; i < dataChildNodes.length; i++) {
    			if (dataChildNodes[i].nodeType != 1) {
    				continue;
    			}
    			//ComDebug(dataChildNodes[i].firstChild.nodeValue);
    			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

    			var item = "";
    			for (var j = 0 in colArr) {
    				var colid = sheetObj.SaveNameCol(colArr[j]) ;
    				if(colid != -1)
    					sheetObj.CellValue2(StartRow+i,colid) = arrData[j];

    			}
    		}

    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}
    }

	/*
	 * 설  명 : EqrXml2SheetRows 호출시 에러 메세지를 보여주는 기능
	 * 인자 1 : xml 문자열
	 * 예제파일: EES_EQR_5001.js
	 */
    function EqrGetMsgText(xmlStr){

        try {
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
            xmlDoc.loadXML(xmlStr);

            var xmlRoot = xmlDoc.documentElement;
            if(xmlRoot == null) return;

            var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
            if(msgNode == null)
            	return;
            else
            	return msgNode.firstChild.nodeValue;
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
	* @param	: str=> 기준일자
	*			: thedate => N일수
	*			: flag => true/false (+/-)일수
	* sample	: calc_Date("1974-01-01","5",true); calc_Date("1974-01-01","5",false);
	* @return 	: +일수 /-일수
	* 설명		: 기준일자의 이후/이전 날짜
	**/
	function calc_Date(str,thedate,flag)
	{
		arg = delete_Char(str,'-');
		if(arg.length != 8)
		{
			return "";
		}
		var mm = arg.substring(4,6);
	    var day = arg.substring(6,8);
	    var year = arg.substring(0,4);

		plann=eval(thedate);         //+ 몇일

		var dayStr = mm+"-"+day+"-"+year;
		var Meet = new Date(dayStr);

		if(flag == true) {
			//annitime = Meet.getTime()+plann*1000*3600*24-1
			annitime = Meet.getTime()+plann*1000*3600*24;
		}
		else {
			//annitime = Meet.getTime()-plann*1000*3600*24-1
			annitime = Meet.getTime()-plann*1000*3600*24;
		}
		var anniday = new Date();
		anniday.setTime(annitime);

		var plusmonth = anniday.getMonth()+1;
		var plusyear  = (anniday.getYear()<100)?"19"+anniday.getYear():anniday.getYear();
		var plusday   = anniday.getDate();

		return plusyear+"-"+fullZero(plusmonth,2)+"-"+fullZero(plusday,2) ;

	}
	/**
	* @param     : str => String
	*		: icount => 전체 문자 갯수
	* sample	: fullZero("123",5);
	* @return 	: String
	* 설명		: 전체 문자 만큼 앞에 0을 채워준다
	**/
	function fullZero(str,icount)
	{
		var slength = (""+str).length;
		var s="";
		for (i=0 ; i < icount - slength ; i++){
			s = s + "0";
		}
		return s + str;
	}
	/**
     * 문자열에 포함된 모든 변환대상 패턴을 변경하여 리턴
     * @param str   문자열
     * @return ret  변경된 문자열
     */
    function replaceStr(str, find, replace)
    {
        var pos = 0;
        pos = str.indexOf(find);

        while(pos != -1) {
            pre_str = str.substring(0, pos);
            post_str = str.substring(pos + find.length, str.length);
            str = pre_str + replace + post_str;
            pos = str.indexOf(find);
        } // end while
        return str;
    }
    /**
	* @param     : source => string 또는 obj 둘다 지원
	*		: char => 없애고 싶은 단어나 문장
	* sample	: delete_Char(this,',')   => this.value 가 3,3,3, 일때 이함수를 이용하면 333으로 나옴
	* @return 	:
	* 설명		: 문자를 없앨때 쓰는 함수
	**/
	function delete_Char(source,char1)
	{
		if (typeof(source) == "string") {
			return replaceStr(source,char1,'');
		}
		else if (typeof(source) == "object") {
			source.value = replaceStr(source.value,char1,'');
		}
		else {
			alert("지원하지 않는 형태입니다.");
		}

	}

	function dateFormatValue2(obj, next_flg, next_date) {
		var value = obj.value ;
		var oldValue = chkCharValue(value, "0123456789", false) ;
		var newValue = "" ;
		var chkValue = "" ;
		var oneChar  = null ;
		var format = "-";
		var maxLen   = 8 + (format.length*2);

		for(i=0; i<oldValue.length; i++){
			oneChar = oldValue.charAt(i) ;

			if(newValue.length<maxLen){
				if(i==4){
					if(oneChar>1){
						newValue = newValue + format + "0" + oneChar ;
					}
					else{
						newValue = newValue + format + oneChar ;
					}
				}
				else if(i==6){
					if(oneChar>3){
						newValue = newValue + format + "0" + oneChar ;
					}
					else{
						newValue = newValue + format + oneChar ;
					}
				}
				else if(i==5 || i==7){
					if( oldValue.charAt(i-1) == 0 && oneChar == 0 ){
						newValue = newValue;
					}
					else {
						newValue += oneChar ;
						if(i == 7 ){
							if ( next_flg == 'Y' ) {
								formObject.to_dt.focus();
								formObject.to_dt.value = calc_Date(oldValue,next_date,true);
							} else if ( next_flg == 'N' ) {
								formObject.to_dt.focus();
							}
						}
					}
				}
				else {
				newValue += oneChar ;
				}
			}
		}
		chkValue = oldValue.substring(0,8) ;
		if(!chkDateValue(chkValue)){
			newValue = newValue.substring(0, newValue.length-1) ;
		}

		obj.value = newValue;
		//return newValue ;
	}

	/**
	* @param    : value
	* sample	: chkCharValue(value, "0123456789", false)
	* @return 	: newValue
	* 설명		:
	**/
	function chkCharValue(value, pchar, upper, maxLen){
		var newValue = "" ;
		var oneChar  = null ;

		for(i=0;i<value.length; i++){
			oneChar = value.charAt(i) ;
			if(pchar.indexOf(oneChar)!=-1 && (maxLen==null || newValue.length<maxLen)){
				newValue += oneChar ;
			}
		}

		newValue = upper ? newValue.toUpperCase() : newValue ;

		return newValue ;
	}

	/**
	* @param    : value
	* sample	: chkDateValue(value)
	* @return 	: boolean ( true, false )
	* 설명		: 해당 날짜의 적합성 여부
	**/
	function chkDateValue(value){
		var yyyy = value.substring(0,4) ;
		var mm   = value.substring(4,6) ;
		var dd   = value.substring(6) ;

		var daysInMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31) ;

		// 월체크
		if(mm>12) {
			return false ;
		}

		// 윤달
		if(mm==2){
			daysInMonth[1] = yyyy%400==0 || ((yyyy%4==0) && (yyyy%100!=0)) ? 29 : 28 ;
		}

		// 일체크
		if(dd!="" && mm!="" && dd>daysInMonth[mm-1]){
			return false ;
		}

		return true ;
	}
	/**
	 * 대상 Img Object를 enable 시킨다.
	 * @param  obj   대상 폼태그(Object)
	 * @return
	 */
	function bntImgEnable(obj, gb) {
		var objNm = obj.name;

		var btnStyle = eval("document."+objNm+".style");

		if (gb){
			obj.disabled = false;
			btnStyle.cursor = "hand";
			btnStyle.filter="";
		} else {
			obj.disabled = true;
			//	      modified by shin yongchan - 20080403
			//	      CSR No : R200804035815
			//	      ENIS / BMS 웹서버(SunOne) 로그상에 Invalid URL에 대한 지속적인 404에러 발생(/hanjin/none) 으로 인해
			//	      소스 수정됨.   none ---> default
			//	      btnStyle.cursor = "none";
			btnStyle.cursor = "default";
			btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
		}
	}

		/**
		 * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. 빈값은 넣어주지 않는다.<br>
		 * @param{form}	str	 Form 객체
		 * @param{exElmNms}	str	  exElmNms값들은 form elemente name으로 구성하지 않을 값들이다.
		 */
    function eqrFormQryStr(form, exElmNms) {

		     if (typeof form != "object" || form.tagName != "FORM") {
		         alert("Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag.");
		         return "";
		     }

		     var name = new Array(form.elements.length);
		     var value = new Array(form.elements.length);
		     var j = 0;
		     var plain_text="";

		     //사용가능한 컨트롤을 배열로 생성한다.
		     len = form.elements.length;
		     for (i = 0; i < len; i++) {
		       //클래스 아이디로 제품을 구분함-아래는 HTMl제품
		       if(form.elements[i].classid==undefined){
		     	  //전송전에 폼의 마스크를 제거한다.
//		     	  ComClearSeparator(form.elements[i]);
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
		                     if(ind >= 0) {
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
		                     for( k = 0; k < llen; k++) {
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
		                     if(increased > 0) {
		                         j--;
		                     } else {
		                         value[j] = "";
		                     }
		                     j++;
		                     break;
		                 default :
		                     if(form.elements[i].value.length >0 ) {
		                    	 if(exElmNms!=null && exElmNms!='' && exElmNms!=undefined){
		                    		 if(!checkExElm(form.elements[i].name, exElmNms)){
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
		 	  	//전송후에 폼의 마스크를 다시 셋팅한다.
//		       ComAddSeparator(form.elements[i]);
		     //IB에서 제공하는 컨트롤의 값을 조합한다.
		     }else{
		       switch(form.elements[i].classid){
		         case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":  // IBMaskEdit 경우
		           name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
		                 value[j] = form.elements[i].Value;
		                 j++;
		           break;
		         case CLSID_IBMCOMBO: // IBMultiCombo 경우
		           name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
		           		if(form.elements[i].UseCode)
		           			value[j] = form.elements[i].Code;
		           		else
		           			value[j] = form.elements[i].Text;
		                 j++;
		                 break;
		       }
		     }
		     }

		     // QueryString을 조합한다.
		     //   1) Explorer 5.5 이상일 경우, encodeURIComponent() 를 이용하여 URL Encode
		     //   2) 기타 경우는 IB Sheet 를 이용하여 URL Encode
		     var webBrowserName = navigator.appName;
		     var webBrowserVer  = navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE") + 5,
		                                                         navigator.appVersion.indexOf("MSIE") + 8)

		     if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
		         for (i = 0; i < j; i++) {
		             // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
		             if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
		         }
		     } else {
		         var tmpUrlEncodeSheet    = document.getElementById("formquerystring");

		         if( tmpUrlEncodeSheet == undefined || tmpUrlEncodeSheet == null || tmpUrlEncodeSheet == '')
		         {
		             //인코딩을 위해 숨겨진IBSheet를 만든다.
		             var sTag = ComGetSheetObjectTag("formquerystring");
		             form.insertAdjacentHTML('afterEnd', sTag);
		         }

		         for (i = 0; i < j; i++) {
		             // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
		             if (name[i] != '') plain_text += name[i]+ "=" + formquerystring.UrlEncoding(value[i]) + "&";
		         }
		     }


		   //마지막에 &를 없애기 위함
		   if (plain_text != "")
		     plain_text = plain_text.substr(0, plain_text.length -1);
		     return plain_text;
		 }

	 function checkExElm(elmNm, exElmNms){
		 var arr_exElmNms = '';
		 var rstTF = false;

		try{
			 if(exElmNms != null && exElmNms != '' && exElmNms != undefined){
					arr_exElmNms = exElmNms.split('|');

					for(var i =0; i < arr_exElmNms.length; i++){
						if(arr_exElmNms[i] != "") {
							if(elmNm==null || elmNm=='' || elmNm==undefined){
								rstTF = true;
								break;
							}else if(elmNm == arr_exElmNms[i]){
								rstTF = true;
								break;
							}
						}
					}

				 }
		}catch(e){
			rstTF = true;
		}


		 return rstTF;
	 }

// ============================================================================ //
///////////////////////////// TMO 장비 회송 프로젝트 MSG (S) /////////////////////////
// ============================================================================ //

function getCodeXmlList(cmd, param){
	var rtn = new Array();
    rtn[0] = "";
    rtn[1] = "";

    createCodeSheetObject();

    with(codeSheet){
        ShowDebugMsg = false;
        var sXml = GetSearchXml("EES_EQR_CODGS.do", "f_cmd="+SEARCHLIST02+"&mcode="+cmd+"&"+param);
        var xml  = sXml.substring(sXml.indexOf("<SHEET>"), sXml.indexOf("</SHEET>") + 8);
    }
    return xml;
}

/*
 *
 */
var codeSheet = null;
function createCodeSheetObject(){
    if(codeSheet != null){
        return;
    }
    var objs = document.getElementsByTagName("OBJECT");
    var baseCode = "";
    for(var i = 0 ; i < objs.length ; i++){
    	  if(objs[i].classid == CLSID_IBSHEET){ //바뀐 사용자환경
            baseCode = "";
            break;
        }
    }
    var sTag = "";
    var id = "codeSheet";
    sTag = ComGetSheetObjectTag(id);
    var divElement = document.createElement("DIV");
    divElement.style.display = "none";
    divElement.innerHTML = sTag;
    document.body.appendChild(divElement);
    codeSheet = divElement.children(0);
    ComConfigSheet(codeSheet);
    with(codeSheet){
        style.height = 150 ;
        //전체 너비 설정
        SheetWidth = 300;

        //Host정보 설정[필수][HostIp, Port, PagePath]
        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

        //전체Merge 종류 [선택, Default msNone]
        MergeSheet = msPrevColumnMerge;

       //전체Edit 허용 여부 [선택, Default false]
        Editable = true;

        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        InitRowInfo( 1, 1, 9, 100);
		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(4, 0 , 0, true);

         var HeadTitle = "Status|Seq.|Code|Name";

        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        InitHeadRow(0, HeadTitle);
        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        InitColumnInfo(10, 1 , 0, false);
       var cnt = 0;
        InitDataProperty(0, cnt++ , dtStatus, 50, daCenter,   true,    "FLG",                 false,    "",         dfNone,   0,          false,       false);
        InitDataProperty(0, cnt++ , dtSeq,       50,    daCenter,   true,    "SEQ",                 false,    "",         dfNone,   0,          false,       false);
        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,   true,    "CODE",                 false,    "",         dfNone,   0,          true,       true);
        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,   true,    "TEXT",                 false,    "",         dfNone,   0,          true,       true);
    }
    ComEndConfigSheet(codeSheet);

}

/**
 * 조회 조건의 Trade 설정.
 * @param{elemName} str 필수, Object Name
 * @param{isAll} Boolean 선택, 모든 Trade 조건 추가 여부, default = true.
 * @param{isRepTrade} Boolean 선택, Rep Trade 조건 추가 여부, default = false.
 * @param{del} str 선택, 삭제 플레그 조건 추가 여부
 */
function searchOptionTrade(elemName, isAll, isRepTrade, del, isSelect, isPus, isMulti) {

	if(isMulti == undefined || isMulti == null){
		isMulti = false;
	}

	var obj = document.getElementById(elemName);

	var rtn = getCodeXmlList("TradeCombo", "");

	obj.setTitle("Trade|Description");
	obj.SetColWidth("50|200");
	obj.MultiSelect = isMulti;
	obj.DropHeight = 190;

	ComXml2ComboItem(rtn, obj, "trd_cd", "trd_cd|trd_nm");

}

/**
 * 조회 조건의 Sub Trade 설정.
 * @param{elemName} str 필수, Object Name
 * @param{isAll} Boolean 선택, 모든 Sub Trade 조건 추가 여부, default = true.
 * @param{isRepTrade} Boolean 선택, Rep Trade 조건 추가 여부, default = false.
 * @param{del} str 선택, 삭제 플레그 조건 추가 여부
 */
function searchOptionSubTrade(elemName, isAll, isRepTrade, del, ipc ,trdCd, isPus,isMulti) {
	
	if(isMulti == undefined || isMulti == null|| isMulti == ""){
		isMulti = false;
	}
	
	var obj = document.getElementById(elemName);
	if(trdCd == null || trdCd == ""){
		var rtn = getCodeXmlList("SubTradeCombo", "");
	}else{
		var rtn = getCodeXmlList("SubTradeCombo", "trdCd=" + trdCd);
	}
	
	obj.setTitle("Trade|SubTrade|Description|");
	obj.MultiSelect = isMulti;
	obj.SetColWidth("50|60|200|0");
	obj.DropHeight = 190;
	obj.ShowCol(3);

	ComXml2ComboItem(rtn, obj, "val_cd", "trd_cd|sub_trd_cd|sub_trd_nm|val_cd");

}

/**
 * 조회 조건의 Lane 설정.
 * @param{elemName} str 필수, Object Name
 * @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = true
 * @param{ipc} Boolean 선택, Rep Trade 조건 추가 여부, true 시 ipc 구간이므로 Rep Trade 조건
 *             제외. Default = false.
 * @param{del} str 선택, 삭제 플레그 조건 추가 여부
 */
function searchOptionLane(elemName, isAll, ipc, del,locTrdCd,locSubTrdCd,reCdValue, isPus, isMulti) {

	if(isMulti == undefined || isMulti == null){
		isMulti = false;
	}

	var obj = document.getElementById(elemName);
	if(reCdValue == null || reCdValue == ''){
		var rtn = getCodeXmlList("SLaneCombo", "" );
	}else{
		var rtn = getCodeXmlList("SLaneCombo",  "locTrdCd=" + locTrdCd+ "&locSubTrdCd=" + locSubTrdCd);
	}
/*
	obj.setTitle("Trade|SubTrade|Lane|Description");
	obj.SetColWidth("50|60|60|250|0");
	obj.MultiSelect = isMulti;
	obj.DropHeight = 190;
	obj.ShowCol(2);

	ComXml2ComboItem(rtn, obj, "val_cd", "trd_cd|sub_trd_cd|lane_cd|lane_nm");
*/
	obj.setTitle("Lane|Description");
	obj.SetColWidth("60|250|0");
	obj.MultiSelect = isMulti; 
	obj.DropHeight = 190;
	obj.ShowCol(0);

	ComXml2ComboItem(rtn, obj, "val_cd", "lane_cd|lane_nm");	
	
	
	
	
	
	
	
//  lane 수정용(미적용상태)	
//	obj.ShowCol(4);
//
//	ComXml2ComboItem(rtn, obj, "val_cd", "trd_cd|sub_trd_cd|lane_cd|lane_nm|val_cd");	

}

  // ============================================================================ //
  ///////////////////////////// TMO 장비 회송 프로젝트 MSG (E) /////////////////////////
  // ============================================================================ //