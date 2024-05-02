/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoEqr.js
*@FileTitle  : EQR common Script
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	if(msgs == undefined){
		msgs = new Array();
	}
	  msgs['EQR90001'] = 'Please input {?msg1}.';
	  msgs['EQR90002'] = 'Scenario ID not found. ';
	  msgs['EQR90003'] = 'There is no relevant ECC Code.';
	  msgs['EQR90004'] = 'The service is not available now.';
	  msgs['EQR90005'] = 'Repo Plan ID not found';
	  msgs['EQR90006'] = 'Repo Plan ID No. is duplicated.';
	  msgs['EQR90007'] = 'Repo Plan ID is not in use.';
	  msgs['EQR90008'] = 'There is no contents to save.';
	  msgs['EQR90009'] = 'Data duplicated.';
	  msgs['EQR90010'] = 'Please retrieve {?msg1}.';
	  msgs['EQR90011'] = 'Year should be 4 digit.';
	  msgs['EQR90012'] = 'Please retrieve {?msg1}.';
	  msgs['EQR90013'] = 'Please input Scenario Year and Week.';
	  msgs['EQR90014'] = 'Please input Scenario sequence.';
	  msgs['EQR90015'] = 'Cannot be deleted.';
	  msgs['EQR90016'] = 'Please select {?msg1}.';
	  msgs['EQR90017'] = 'Please input {?msg1} year';
	  msgs['EQR90018'] = 'Please input {?msg1} week';
	  msgs['EQR90019'] = 'There is no data to modify !';
	  msgs['EQR90020'] = 'O/B Total should be equal or greater than {?msg1}.';
	  msgs['EQR90021'] = 'I/B Total should be equal to or greater than {?msg1}.';
	  msgs['EQR90022'] = 'Please enter under {?msg1} weeks.';
	  msgs['EQR90023'] = 'There is no new Scenario ID.';
	  msgs['EQR90024'] = 'You cannot modify this scenario.';
	  msgs['EQR90025'] = '000 cannot be saved.';
	  msgs['EQR90026'] = 'ECC is duplicated.';
	  msgs['EQR90027'] = 'Please enter under {?msg2} weeks of {?msg1}.';
	  msgs['EQR90028'] = 'Please enter this item same or later than Plan week.';
	  msgs['EQR90029'] = 'Please enter this item same or later than {?msg1}.';
	  msgs['EQR90030'] = 'Cannot use Adjust, because Company has been selected both.';
	  msgs['EQR90031'] = 'Please select newly created Repo Plan ID.';
	  msgs['EQR90032'] = 'There is no T/S information.';
	  msgs['EQR90033'] = 'To Week should be later than From Week ! ';
	  msgs['EQR90034'] = 'Please input data From week at line {?msg1}.';
	  msgs['EQR90035'] = 'Please input data To Week at line {?msg1}.';
	  msgs['EQR90036'] = 'This is modified item.\n\n Do you want to save?';
	  msgs['EQR90037'] = 'Please insert scenario ID value.';
	  msgs['EQR90038'] = 'Scenario ID status type is not true !';
	  msgs['EQR90039'] = 'There is no data to download.';
	  msgs['EQR90040'] = 'Please select Plan row.';
	  msgs['EQR90041'] = 'Please select REPO BKG row.';
	  msgs['EQR90042'] = 'Selected data is not relevant to Repo BKG target.';
	  msgs['EQR90043'] = 'Please select Execute row.';
	  msgs['EQR90044'] = 'Row is not checked in S/O Send.';
	  msgs['EQR90045'] = '{?msg1} can be operated when all TP/SZ is retrieved.';
	  msgs['EQR90046'] = 'Do you want to execute S/O Send of selected data ?';
	  msgs['EQR90047'] = 'Selected data is not target of S/O cancel.';
	  msgs['EQR90048'] = '{?msg1} Vol should be same or greater than {?msg1} container vol {?msg2}. ';
	  msgs['EQR90049'] = 'This REPO Plan cannot be distributed.\n\n Cannot be retrieved.';
	  msgs['EQR90050'] = 'Total value 0 cannot be entered.';
	  msgs['EQR90051'] = 'There is no data to retrieve.';
	  msgs['EQR90052'] = 'Please select Plan row to be combined target.';
	  msgs['EQR90053'] = 'Do you want to execute REPO BKG of selected data ?';
	  msgs['EQR90054'] = 'Do you want to execute S/O Send of selected data ?';
	  msgs['EQR90055'] = 'Do you want to execute S/O Cancel of selected data ?';
	  msgs['EQR90056'] = 'Please input week data format !';
	  msgs['EQR90057'] = 'To Week should be later than From Week !';
	  msgs['EQR90058'] = '{?msg1} line Contract should be at least 4 digits.';
	  msgs['EQR90059'] = '{?msg1} line Contract first 3 digits should be in english.';
	  msgs['EQR90060'] = '{?msg1} line Contract from 4th digit should be number.';
	  msgs['EQR90061'] = 'Percentage is zero.';
	  msgs['EQR90062'] = 'Quantity is zero.';
	  msgs['EQR90063'] = 'There is no data selected.';
	  msgs['EQR90064'] = 'LOC is not selected in line {?msg1} completely.';
	  msgs['EQR90065'] = 'LOC {?msg2} items in line {?msg1} LOC {?msg2} are same ECC.\n\n Could not enter.';
	  msgs['EQR90066'] = 'LOC {?msg2} items in line {?msg1} LOC {?msg2} are different ECC.\n\n Could not enter.';
	  msgs['EQR90067'] = 'There is no data to apply.';
	  msgs['EQR90068'] = 'Please share after retrieve.';
	  msgs['EQR90069'] = 'Please input after retrieve.';
	  msgs['EQR90070'] = 'To week value should be same or greater than {?msg1}.';
	  msgs['EQR90071'] = 'Please input data under {?msg2} of {?msg1}.';
	  msgs['EQR90072'] = 'Please retrieve after Apply';
	  msgs['EQR90073'] = 'Holiday Data will be saved first.';
	  msgs['EQR90074'] = 'There is no VVD';
	  msgs['EQR90075'] = 'There is no ETD, ETA.';
	  msgs['EQR90076'] = 'Please input value between FROM weeks.';
	  msgs['EQR90077'] = 'ETD should be earlier than ETA.';
	  msgs['EQR90078'] = 'Please input data by {?msg1} digits.';
	  msgs['EQR90079'] = 'Please input data between Plan Week and retrieve TO week.';
	  msgs['EQR90080'] = 'To Date should be greater than From Date.';
	  msgs['EQR90081'] = 'Please save modified data first.';
	  msgs['EQR90082'] = 'Please input data between retrieved weeks.';
	  msgs['EQR90083'] = 'This is not a distributed plan.';
	  msgs['EQR90084'] = 'Select2 data should differ from Select1 data.';
	  msgs['EQR90085'] = 'Please select DIR.';
	  msgs['EQR90086'] = 'Please input From.';
	  msgs['EQR90087'] = 'Please input To.';
	  msgs['EQR90088'] = 'Please check one more.';
	  msgs['EQR90089'] = 'To week should be later than From week.';
	  msgs['EQR90090'] = 'End week should be under {?msg1} week.';
	  msgs['EQR90091'] = 'There is {?msg2} on {?msg1} row. ';
	  msgs['EQR90092'] = 'Please check Container No. and input again.';
	  msgs['EQR90093'] = '{?msg1} exist on same REPO Plan ID';
	  msgs['EQR90094'] = 'There is Container No. ({?msg1}) saved.';
	  msgs['EQR90095'] = 'There is no data to print.';
	  msgs['EQR90096'] = 'Upper data is shared.\n\n Lower data is not saved.';
	  msgs['EQR90097'] = 'User {?msg1} is being used from {?msg2}\n\n. Do you want to continue?';
	  msgs['EQR90098'] = 'Entered ECC can not be used.';
	  msgs['EQR90099'] = 'It is greater than fixed quantity {?msg3} on POL : {?msg2} of VVD : {?msg1}.\n\n Please check again.';
	  msgs['EQR90100'] = 'It is less than fixed quantity {?msg3} on POL : {?msg2} of VVD : {?msg1}.\n\n Please check again.';
	  msgs['EQR90101'] = 'Please input either FROM or TO.';
	  msgs['EQR90102'] = 'Please delete or fill FROM period.';
	  msgs['EQR90103'] = 'Please delete or fill TO period.';
	  msgs['EQR90104'] = 'Start week should be earlier than End week.';
	  msgs['EQR90105'] = '{?msg1} is wrong data.';
	  msgs['EQR90106'] = 'Saving has been completed.';
	  msgs['EQR90107'] = 'Saving has not been completed.';
	  msgs['EQR90108'] = 'Please save after {?msg1} .';
	  msgs['EQR90109'] = '{?msg1} being validation.';
	  msgs['EQR90110'] = 'Retrieved {?msg1} year differs from {?msg2}.';
	  msgs['EQR90111'] = 'Please input end week under {?msg1} week.';
	  msgs['EQR90112'] = 'Start week starts from {?msg1}.';
	  msgs['EQR90113'] = '{?msg1} is wrong.';
	  msgs['EQR90114'] = 'TO Week should be same or later than FROM Week.';
	  msgs['EQR90115'] = 'Please input number same or less than {?msg1} week.';
	  msgs['EQR90116'] = 'Please input number same or greater than {?msg1} week.';
	  msgs['EQR90117'] = 'Lower Data is saved.\n\n Upper Data is not saved.';
	  msgs['EQR90118'] = 'Modified data is not saved.\n\n Please save first.';
	  msgs['EQR90119'] = 'Do you want to execute selected Repo BKG as Repo BKG ?';
	  msgs['EQR90120'] = 'Do you want to save modified items on TAB {?msg1} ? ';
	  msgs['EQR90121'] = 'Selected MTY Repo BKG differs from Company, Load LOC, and VVD data.';
	  msgs['EQR90122'] = 'Selecting non-VVD of MTY REPO BKG is not permitted.';
	  msgs['EQR90123'] = 'There is no target of checked Repo BKG.';
	  msgs['EQR90124'] = 'This REPO PLAN is not executed distribution.\n\n It is impossible to add plan.';
	  msgs['EQR90125'] = 'It is impossible to retrieve at on {?msg1}.\n\n Please select FM/TO. ';
	  msgs['EQR90126'] = 'Please select line {?msg1}, {?msg2} data.';
	  msgs['EQR90127'] = 'Week cannot be earlier than {?msg1} or later than {?msg2}.';
	  msgs['EQR90128'] = 'Row {?msg1} Total Vol = 0 status.\n\n It is possible to input and modify.';
	  msgs['EQR90129'] = 'Selecting in line {?msg1} LOC is not completed.';
	  msgs['EQR90130'] = 'LINE {?msg1} 3 LOC are same ECC.\n\n It is impossible to input.';
	  msgs['EQR90131'] = 'LINE {?msg1} 3 LOC are different ECC.\n\n It is impossible to input.';
	  msgs['EQR90132'] = 'Are you going to update distruibuted Repo Plan ID {?msg1} ?';
	  msgs['EQR90133'] = '{?msg1} week is wrong.';
	  msgs['EQR90134'] = 'Quantity differs from\n{?msg1}';
	  msgs['EQR90135'] = '{?msg1} is modifying.';
	  msgs['EQR90136'] = 'TO week should be later than FROM week.';
	  msgs['EQR90137'] = 'Confirm has been processed already.';
	  msgs['EQR90138'] = 'Do you want to execute Re-run ?';
	  msgs['EQR90139'] = 'ETD should be earlier than ETB.';
	  msgs['EQR90140'] = 'You can modify it on ECC Info sheet2.';
	  msgs['EQR90141'] = '{?msg1} should be later than {?msg2} or earlier than {?msg3}.';
	  msgs['EQR90142'] = 'You cannot cancel S/O, because S/O has been sent already.';
	  msgs['EQR90143'] = 'Please input FROM Yard and TO Yard.';
	  msgs['EQR90144'] = 'Please select ETD between week ({?msg1} ~ {?msg2}).';
	  msgs['EQR90145'] = 'Please input 4 digit-To Year.';
	  msgs['EQR90146'] = 'Please input 2 digit-To Week.';
	  msgs['EQR90147'] = 'Not available to cancel.';
	  msgs['EQR90148'] = 'Please input the date later than {?msg1} of prior calling port.';
	  msgs['EQR90149'] = 'Please input the date earlier than {?msg1} of next calling port.';
	  msgs['EQR90150'] = 'There is no {?msg1} for the week.\n\n Please enter week again.';
	  msgs['EQR90151'] = '{?msg1} should be {?msg2}, {?msg3} week.' ;
	  msgs['EQR90152'] = '{?msg1} can be added 1 row by one.';
	  msgs['EQR90153'] = 'Retrieving option week [{?msg1}] differs from data week [{?msg2}].\n\n Please try again.';
	  msgs['EQR90154'] = '{?msg1} has been distributed.';
	  msgs['EQR90155'] = 'There is inserted data.\n\n Please check again.\n';
	  msgs['EQR90156'] = 'There is inserted data.\n\n Please check again.\n\n Do you want to save them as they are?';
	  msgs['EQR90157'] = '{?msg2} Are you going to update distruibuted Repo Plan ID {?msg1}?';
	  msgs['EQR90158'] = 'It is only possible by RCC and LCC.'
	  msgs['EQR90159'] = 'Please assign another REPO BKG No. for repositioning empty volume over 500 units.';
	  msgs['EQR90160'] = 'You can take a necessary action under {?msg1} {?msg2}({?msg3}). ';
	  msgs['EQR90161'] = 'VD Add(Booking Split) row can\'t be saved with {?msg1} button.';
	  msgs['EQR90162'] = 'Do you want to {?msg1}?';
	  msgs['EQR90163'] = 'Please assign Senator company S/O Send for Repositioning empty volume over 100 units.';
	  msgs['EQR90164'] = 'Please input value over {?msg1}';
	  msgs['EQR90165'] = 'Please note that the same date/route of the input data will be disregarded.';
	  msgs['EQR90166'] = 'Selected the fixed volume at present. Do you want to insert the fixed volume ?';
	  msgs['EQR90167'] = 'Please input mandatory items from previous field in turn !';
	  msgs['EQR90168'] = 'The ETB of VD Add(Fixed Plan) should be same week of planning.';
	  msgs['EQR90169'] = 'Please select ETB between week({?msg1} ~ {?msg2}).';
	  msgs['EQR90170'] = 'You cannot input same ECC Link information.';
	  msgs['EQR90171'] = 'Please input yard code under {?msg1} ECC.';
	  msgs['EQR90172'] = 'OK. Execution Plan data was already transmitted to TRS. \nDo you want to create S/O & W/O Data ?';
	  msgs['EQR90173'] = 'Please input execution data for VVD in T.VVD/D.VVD screen !';
	  msgs['EQR90174'] = 'The input Data(VVD/POL/POD) is available in Plan ID {?msg1}!.\n\n Do you want to insert the input data additionally?';
	  msgs['EQR90175'] = 'You cannot input [ All ] on From/To location field simultaneously !';
	  msgs['EQR90176'] = 'Please cross-check this data with Rule code ({?msg1} )!';
	  msgs['EQR90177'] = 'No calling port in NIS. Do you wish to insert ?' ;
	  msgs['EQR90178'] = 'ETA should be earlier than ETB.';
	  msgs['EQR90179'] = 'Please press [ Interface ] button, instead of [Save], when you click [I/F] box.';
	  msgs['EQR90180'] = 'Please click [I/F] box, before pressing [Interface] button.';
	  msgs['EQR90181'] = 'Please input {?msg1}({?msg2} \'\s line).';
	  msgs['EQR90182'] = 'Container[ {?msg1} ]\'\s TP/SZ is yet applied.\nWait for a moment and click "Apply" button.';
	  msgs['EQR90183'] = 'Please select another scenario seq no. "000" seq is not allowed to Run optimizer.';
	  msgs['EQR90184'] = 'Wait for a moment and click "Retrieve" button again.';
	  msgs['EQR90185'] = 'This VVD isn\'t available.';
	  msgs['EQR90186'] = 'There isn\'t existing Bay Port for VVD({?msg1})';
	  msgs['EQR90187'] = 'There should be at least one row in list to use "Row Copy" button.';
	  msgs['EQR90188'] = 'The VVD No.({?msg1}) does not exists in VSL SKED.';
	  msgs['EQR90189'] = 'The VVD No.({?msg1}) exist already in Scenario VSL SKED.';
	  msgs['EQR90190'] = 'Service Lane code for VVD No.({?msg1}) is empty.';
	  msgs['EQR90191'] = '{?msg1} is a mandatory item for inquiry.';
	  msgs['EQR90192'] = 'Do you want to save ?';
	  msgs['EQR90193'] = 'Do you want to delete ?';
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
	  msgs['EQR90208'] = 'Do you want to save ?';
	  msgs['EQR90209'] = 'Do you want to delete ?';
	  msgs['EQR90210'] = 'The port code exists already.';
	  msgs['EQR90211'] = '{?msg1} : Date format is wrong.';
	  msgs['EQR90212'] = 'OPT still exists. Please revert to designated ports to save.';
	  msgs['EQR90213'] = '{?msg1} is a mandatory item for inquiry.';
	  msgs['EQR90214'] = 'There is no selected row for Row Delete';
	  msgs['EQR90215'] = 'End date should be later than Start date.';
	  msgs['EQR90216'] = 'Max period is 12 months or 26 weeks.';
	  msgs['EQR90217'] = 'Max period is 3 months or 12 weeks.';
	  msgs['EQR90218'] = 'Yard code is invalid.';
	  msgs['EQR90219'] = 'Certain to delete the current MTY COD Confirmation of {?msg1} ?';
	  msgs['EQR90220'] = '{?msg1} Vol unmatch between Onboard total and Discharge total.';
	  msgs['EQR90221'] = 'Max period is 12 Months.';
	  msgs['EQR90222'] = 'Date format is wrong. Please enter valid date format. [{?msg1}]';
	  msgs['EQR90223'] = 'End date should be later than Start date.';
	  msgs['EQR90224'] = 'No data found.';
	  msgs['EQR90225'] = 'There is no data to save.';
	  msgs['EQR90226'] = 'If you change the data of BASE ITEM with exceptional cases, it will be deleted.';
	  msgs['EQR90227'] = 'Remark is empty.';
	  msgs['EQR90228'] = 'Date period is over 7 days. Please reselect date.';
	  msgs['EQR90229'] = 'Currently the data are being searched. Please click button "CNTR Input".';
	  msgs['EQR90230'] = 'There is no {?msg1}.';
	  msgs['EQR90231'] = 'Do you want to execute Optimizer Engine ?';
	  msgs['EQR90232'] = 'Repo. Plan ID is not {?msg1}.\nStill need to distribute this Repo Plan ?';
	  msgs['EQR90233'] = 'BackEndJob Request Fail !';
	  msgs['EQR90234'] = 'It was already created. Please check again.';
	  msgs['EQR90235'] = 'Please input LCC level first.';
	  msgs['EQR90236'] = 'Do you want to save modified "Repo Plan ID name" ?';
	  msgs['EQR90237'] = 'Repo Plan ID not found.\nDo you want to make "New Repo Plan Id" ?';
	  msgs['EQR90238'] = 'You have no authority to create inland Repo Plan (LOC:{?msg1})';
	  msgs['EQR90239'] = 'You have no authority to update Inland Execution plan (From:{?msg1}) \r\n Please check your authorization.';
	  msgs['EQR90240'] = 'You have no authority to create On-Hire & Off-Hire Repo Plan (Location : {?msg1})';
	  msgs['EQR90241'] = 'You have no authority to create On-Hire & Off-Hire Execution Plan (Location : {?msg1}) \r\n Please check your authorization.';
	  msgs['EQR90242'] = 'You have no authority to create ECC International. (Location : {?msg1}) \r\n Please check your authorization.';
	  msgs['EQR90243'] = 'You have no authority to update ECC International. (Location : {?msg1}) \r\n Please check your authorization.';
	  msgs['EQR90244'] = 'You have no authority to create ocean execution plan. (POL : {?msg1}) \r\n Please check your authorization.';
	  msgs['EQR90245'] = 'You have no authority to split booking. (POD : {?msg1}) \r\n Please check your authorization.';
	  msgs['EQR90246'] = 'You have no authority to create LCC International. (Location : {?msg1}) \r\n Please check your authorization.';
	  msgs['EQR90247'] = 'You have no authority to update LCC International. (Location : {?msg1}) \r\n Please check your authorization.';
	  msgs['EQR90248'] = 'VD split is not required since MT Repo Booking has not been created with this Repo BKG record.';

	  msgs['EQR70001'] = 'Certain to save? FCST Revision for Accuracy Evaluation is only available by 17:00, Friday.';
	  msgs['EQR70002'] = 'Saved Successfully.';
	  msgs['EQR70003'] = 'Invalid yard with ECC.';
	  msgs['EQR70007'] = 'Max Period is 12 weeks.';
	  msgs['EQR70008'] = 'Please check period. Max period is 3 months.';	  
	  msgs['EQR70009'] = 'You have no authority to create Repo Plan. (POD : {?msg1}) \nPlease check your authorization.';
	  msgs['EQR70010'] = 'You have to retrieve again to include changed condition. \nDo you want to retrieve again ?';
	  msgs['EQR70011'] = 'Please check Repo Plan ID format.';
	  msgs['EQR70012'] = 'LCC info (LCC Code : {?msg1}) does not exist. \nPlease check EQ Organization Chart.';
	  msgs['EQR70013'] = 'ECC info (ECC Code : {?msg1}) does not exist. \nPlease check EQ Organization Chart.';
	  msgs['EQR70014'] = 'Yard (Yard Code : {?msg1}) does not exist. \nPlease check again.';
	  msgs['EQR70015'] = 'From/To yard are not in same LCC. \nPlease check again.';
	  msgs['EQR70016'] = 'Some containers ({?msg1} vol.) are already attached to this Repo Plan`s week or not suitable. \nPlease check again.';
	  msgs['EQR70017'] = 'Please make use of LCC Internal tab \nif you are creating Inland movement within \n(LOC : {?msg1}).';
	  
	  

	  // ============================================================================ //
	  ///////////////////////////// TMO MSG (S) /////////////////////////
	  // ============================================================================ //

	  msgs['EQR01001'] = 'Saved Successfully.';
	  msgs['EQR01002'] = 'Saving has not been completed.';
	  msgs['EQR01003'] = 'Please input LCC level first.';
	  msgs['EQR01004'] = 'RCC code is invalid.';
	  msgs['EQR01005'] = 'LCC code is invalid.';
	  msgs['EQR01006'] = 'ECC code is invalid.'; 
	  msgs['EQR01007'] = 'SCC code is invalid.'; 
	  msgs['EQR01008'] = 'Port code is invalid.'; 
	  msgs['EQR01009'] = 'Yard code is invalid.'; 
	  msgs['EQR01010'] = 'Max Period is 20 weeks.';
	  msgs['EQR01011'] = 'Max Period is 20 months.';
	  msgs['EQR01012'] = '{?msg1} is wrong.';
	  msgs['EQR01013'] = 'End date should be later than Start date.';  
	  msgs['EQR01014'] = 'There are duplicated rows with same yard code and same ETB.\nPlease update data on pre-created row.';  
	  msgs['EQR01015'] = 'There are duplicated row with same condition.\nPlease update data on pre-created row.';
	  msgs['EQR01016'] = 'Insert data already exists. Please retrieve again.';
	  msgs['EQR01017'] = 'Update data doesn\'t exists. Please retrieve again.';
	  msgs['EQR01018'] = 'Max period is {?msg1}.';  
	  msgs['EQR01019'] = 'Total Quantity is zero.';
	  msgs['EQR01020'] = '{?msg1} Successfully.';
	  msgs['EQR01021'] = 'Only saved row can be Requested.';
	  msgs['EQR01022'] = 'Only requested row can be Request Cancelled.';
	  msgs['EQR01023'] = 'Data was changed by others. Please retrieve again.';
	  msgs['EQR01024'] = 'Only New row and Saved row can be deleted.';
	  msgs['EQR01025'] = 'Do you want to select row Request ?';
	  msgs['EQR01026'] = 'Do you want to select row Request Cancel ?';
	  msgs['EQR01027'] = 'LCC is not in [{?msg1}].';
	  msgs['EQR01028'] = 'Do you want to proceed with selected row ?';
	  msgs['EQR01029'] = 'Please retrieve {?msg1}.';
	  msgs['EQR01030'] = 'Do you want to update MT loading plan with input volume accroding to MT repo guideline ?';
	  msgs['EQR01031'] = 'No authority to change.';
	  msgs['EQR01032'] = 'Create OFC Conti Code not found exception !';
	  msgs['EQR01033'] = 'Login OFC not found exception!';
	  msgs['EQR01034'] = "Please put VVD first or select VVD after hitting 'VVD search' button for the filtering condition." ;
	  
	  msgs['EQR01101'] = 'Please input {?msg1}.';
	  msgs['EQR01102'] = 'Please select {?msg1}.';
	  msgs['EQR01103'] = '{?msg1} is invalid.';
	  msgs['EQR01104'] = 'There is no data retrieved.'; 
	  msgs['EQR01105'] = '{?msg1} is missing.';
	  msgs['EQR01106'] = 'Maximum period is {?msg1}.';
	  msgs['EQR01107'] = 'There is no data to save.';  
	  msgs['EQR01108'] = 'Could not confirm cancel.'; 
	  msgs['EQR01109'] = 'Service is not available now.';
	  msgs['EQR01110'] = 'Please input {?msg1}.';
	  msgs['EQR01111'] = '{?msg1} :  Date format is wrong';
	  msgs['EQR01112'] = 'Amendment is only available for confirmed guideline.';
	  msgs['EQR01113'] = '{?msg1} There is duplicated lane.';
	  msgs['EQR01114'] = 'There is duplicate POD.';
	  msgs['EQR01115'] = 'POD is invalid.';
	  msgs['EQR01116'] = 'Confirmed guideline cannot be amended.';
	  msgs['EQR01117'] = 'This is not the latest confirmed guideline.';
	  msgs['EQR01118'] = 'From date should be earlier than To date.';
	  msgs['EQR01119'] = 'To week should be later than From week.';
	  
	  msgs['EQR01121'] = '{?msg1} is invalid.'; 
	  msgs['EQR01122'] = 'Selected data already exists in Repo BKG No.';
	  msgs['EQR01123'] = 'Please select REPO BKG Row.';
	  msgs['EQR01124'] = 'Please save inserted data first.';
	  msgs['EQR01125'] = 'ETB should be later than ETD.';  
	  msgs['EQR01126'] = 'Please select POD.';  
	  msgs['EQR01127'] = 'Vd Split should have Booking no.';  
	  msgs['EQR01128'] = 'Please select Trunk Item.';   
	  msgs['EQR01129'] = 'VVD Code is mandatory item for inquiry.';
	  msgs['EQR01130'] = 'Row {?msg1} Total Vol = 0 status.\n\n It is possible to enter and modify.';
	  msgs['EQR01131'] = 'This VVD isn\'t available.';  
	  msgs['EQR01132'] = 'Load Excel will reset grid. \n\n Do you want to load Excel ?';    
	  msgs['EQR01133'] = 'Please input VVD Code value.';
	  msgs['EQR01134'] = 'POD Yard should be later than POL Yard.';   
	  msgs['EQR01135'] = 'Please input Trunk VVD.';   
	  
	  msgs['EQR01136'] = 'Impossible to update past week data.';   
	  msgs['EQR01137'] = 'FCAST cannot be updated this time. \n Please contact CTY-EQ for FCST Revision.';     
	  msgs['EQR01138'] = 'FCST revision for accuracy evaluation is only available by 17:00, Friday.';     
	  
	  msgs['EQR01139'] = 'Could not found VVD (bound to Asia Area). ';  
	  msgs['EQR01140'] = 'There is duplicate user id.';    
	  msgs['EQR01141'] = 'This user id isn\'t available.';  
	  msgs['EQR01142'] = 'Please check email address format.';
	  msgs['EQR01143'] = 'Code is invalid.';
	  msgs['EQR01144'] = 'ETD/ETA should always be later than current week.';
	  msgs['EQR01145'] = 'Difference between Week End Date and Week Start Date should be 7 days. \nPlease check again.';
	  msgs['EQR01146'] = 'Would you like to create Rail/Truck plan with IRG information? ';
	  msgs['EQR01147'] = 'The service is not available now. \nPlease try again later.';
	  msgs['EQR01148'] = 'Please check Delete check box before creating MTY Repo BKG.';
	  msgs['EQR01149'] = 'This Repo. Plan ID doesn\'t exist. \nPlease use Create button to make new ID.';
	  msgs['EQR01150'] = 'This plan has been updated. \nPlease retrieve again to check status.';
	  msgs['EQR01151'] = 'Repo. Plan ID has been deleted successfully.';
	  msgs['EQR01152'] = 'Container Vol. cannot exceed more then {?msg1} containers planned TO Japan({?msg2}). \nPlease check Total Vol of container. ';
	  msgs['EQR01153'] = 'Exec Record with same VVD, Load Location and Discharge Location exists in {?msg1}.';
	  msgs['EQR01154'] = 'Please input VVD when item is Water';
	  msgs['EQR01155'] = 'Execution Add can be operated when all Vol Selection is retrieved.'; 
	  // ============================================================================ //
	  ///////////////////////////// TMO MSG (E) /////////////////////////
	  // ============================================================================ //
  // common static variable
  var noSaveData='There is no contents to save.';
  var dfUpperChar='ABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
  var red='245';
  var green='225';
  var blue='209';
  var func;
  var grid_savemsg="";
  var grid_searcherr="";
  var row2modify=0;
  var window_orgw=1024;
  var window_orgh=768;
  var grid_resize_w=new Array();
  var grid_resize_h=new Array();
  var grid_resize_wh=new Array();
	/**
	 * 설  명 : From To week mandatory validation check. <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     chkFromToWeek(formObj,'fmPlnYr','fmPlnWk','FROM')
	 * </pre>
	 * @param {form}	formObj
	 * @param {object}	obj1 - year
	 * @param {object}	obj2 - week
	 * @param {string}	gubun - for showing Message(FROM, TO)
	 * @returns boolean
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
	 * Optional validation check. <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     chkFromToOptWeek(formObj, 'fmFmPlnYr_2', 'fmFmPlnWk_2', 'fmToPlnYr_2', 'fmToPlnWk_2',
	 *     					'toFmPlnYr_2', 'toFmPlnWk_2', 'toToPlnYr_2', 'toToPlnWk_2')
	 * </pre>
	 * @param {form}	formObj
	 * @param {object}	obj1 - from line .
	 * @param {object}	obj2 - from line .
	 * @param {object}	obj3 - from line .
	 * @param {object}	obj4 - from line .
	 * @param {object}	obj5 - to line .
	 * @param {object}	obj6 - to line .
	 * @param {object}	obj7 - to line .
	 * @param {object}	obj8 - to line .
	 * @returns boolean, validation check --> true or false
	 * @see 
	 * @author 
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
	 * 설  명 : Period validation check. <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     chkPeriodField(formObj , 'st_year' ,'st_weekly')
	 * </pre>
	 * @param {form}	formObj
	 * @param {object}	obj1 - year
	 * @param {object}	obj2 - week
	 * @returns boolean
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
     * checking period field
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
              var fmWk=parseInt(eval("formObj."+obj1).value + eval("formObj."+obj2).value);
              var toWk=parseInt(eval("formObj."+obj3).value + eval("formObj."+obj4).value);
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
        var yrwk_e=eval(obj5).document.form.yrwk_e.value;
        var stYrWk=obj1.value + obj2.value;
        var endYrWk=obj3.value + obj4.value;
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
            yrwk_e=eval(periorIframe.nam + ".document.form.fm_yrwk_e.value");
            checkMaxWk=eval(periorIframe.name + ".document.form.checkMaxWkFm.value");
          }
          if(flag.toUpperCase() == 'TO'){
            yrwk_e=eval(periorIframe.name + ".document.form.to_yrwk_e.value");
            checkMaxWk=eval(periorIframe.name + ".document.form.checkMaxWkTo.value");
          }
          if(flag.toUpperCase() == 'AT'){
            yrwk_e=eval(pTeriorIframe.name + ".document.form.at_yrwk_e.value");
            checkMaxWk=eval(periorIframe.name + ".document.form.checkMaxWkAt.value");
          }
          if(obj3.value.length == 4 && obj4.value.length == 2){
            var stYrWk=obj1.value + obj2.value;
            var endYrWk=obj3.value + obj4.value;
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
        fm_yrwk=objFmSYr.value + objFmSWk.value;
        to_yrwk=objToSYr.value + objToSWk.value;
        at_yrwk=objAtSYr.value + objAtSWk.value;
        var lengthObj;
        var nullEYr;
        var nullEWk;
        var checkSYr;
        var checkSWk;
        if(gijun.toUpperCase() == 'FM'){
          lengthObj='fm_yrwk';
          nullEYr='objFmEYr';
          nullEWk='objFmEWk';
          checkSYr='objFmSYr';
          checkSWk='objFmSWk';
        }
        if(gijun.toUpperCase() == 'TO'){
          lengthObj='to_yrwk';
          nullEYr='objToEYr';
          nullEWk='objToEWk';
          checkSYr='objToSYr';
          checkSWk='objToSWk';
        }
        if(gijun.toUpperCase() == 'AT'){
          lengthObj='at_yrwk';
          nullEYr='objAtEYr';
          nullEWk='objAtEWk';
          checkSYr='objAtSYr';
          checkSWk='objAtSWk';
        }
        if(eval(lengthObj).length == 6){
          if(parseInt(eval(checkSYr).value + eval(checkSWk).value) < parseInt(plnyyyyww.value)){
        	  ComShowCodeMessage("EQR90028");
  	           eval(checkSYr).value='';
  	           eval(checkSWk).value='';
      	  		 eval(checkSYr).focus();
      	  		 return;
          }
          //edit 시 to 주차는 초기화.(onblur 시 이전 max값을 가지고 잇는 것을 방지)
          eval(nullEYr).value='';
          eval(nullEWk).value='';
          var result="";
  	      document.form.f_cmd.value=SEARCHLIST15;
          document.form.target="periorIframe";
          //default로 현재일자의 주차에서 +9주차까지를 조회조건에 입력한다.
          document.form.action="EES_CHECK_PERIOD.do?gapmonth=4&gubun=FMTOAT&editmonth=9&fm_yrwk="+fm_yrwk+"&to_yrwk="+to_yrwk+"&at_yrwk="+at_yrwk;
          result=document.form.submit();
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
        yrwk_e=eval(obj5.name + ".document.form.fm_yrwk_e.value");
        checkMaxWk=eval(obj5.name + ".document.form.checkMaxWkFm.value");
      }
      if(flag.toUpperCase() == 'TO'){
        yrwk_e=eval(obj5.name + ".document.form.to_yrwk_e.value");
        checkMaxWk=eval(obj5.name + ".document.form.checkMaxWkTo.value");
      }
      if(flag.toUpperCase() == 'AT'){
        yrwk_e=eval(obj5.name + ".document.form.at_yrwk_e.value");
        checkMaxWk=eval(obj5.name + ".document.form.checkMaxWkAt.value");
      }
      //fm을 고치치 않고 to만 고친경우는 default 를 참조.
      if(checkMaxWk == ''){
        yrwk_e=eval(obj5.name + ".document.form.yrwk_e.value");
        checkMaxWk=eval(obj5.name + ".document.form.checkMaxWk.value");
      }
      if(obj3.value.length == 4 && obj4.value.length == 2){
        var stYrWk=obj1.value + obj2.value;
        var endYrWk=obj3.value + obj4.value;
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
        fm_yrwk1 = objFmSYr.value + objFmSWk.value;
        to_yrwk1 = objToSYr.value + objToSWk.value;
        at_yrwk1 = objAtSYr.value + objAtSWk.value;

        var lengthObj;
        var nullEYr;
        var nullEWk;

        if(gijun.toUpperCase() == 'FM'){
          lengthObj = fm_yrwk1;
          nullEYr = objFmEYr;
          nullEWk = objFmEWk;
        }
        if(gijun.toUpperCase() == 'TO'){
          lengthObj = to_yrwk1;
          nullEYr =objToEYr;
          nullEWk = objToEWk;
        }
        if(gijun.toUpperCase() == 'AT'){
          lengthObj = at_yrwk1;
          nullEYr = objAtEYr;
          nullEWk = objAtEWk;
        }
        
        if(lengthObj.length == 6){

          //edit 시 to 주차는 초기화.(onblur 시 이전 max값을 가지고 잇는 것을 방지)
          nullEYr.value = '';
          nullEWk.value = '';
          var result = "";
          
          document.form.gubun.value     = "FMTOAT";
          document.form.gapmonth.value  = gapValue1;
          document.form.editmonth.value = gapValue2;
          document.form.fm_yrwk.value = fm_yrwk1;
          document.form.to_yrwk.value = to_yrwk1;
          document.form.at_yrwk.value = at_yrwk1;
  	      document.form.f_cmd.value = SEARCHLIST15;
          document.form.target="periorIframe";
          //default로 현재일자의 주차에서 +4주차까지를 조회조건에 입력한다.
          
          document.form.action="EES_CHECK_PERIOD.do";
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
        	ComShowCodeMessage("EQR90001","Plan ID");
            eval("formObj."+obj1).focus();
            return false;
        }
        if(eval("formObj."+obj2).value.length != 4) {
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
        if(eval("formObj."+obj2).value.length != 4) {
        	ComShowCodeMessage("EQR90001","Repoplan ID");
            eval("formObj."+obj2).focus();
            return false;
        }
        return true;
    }    
    function checkTpszCombo(index) {
        if(comboObjects[index] != null && comboObjects[index].GetSelectCode()== "") {
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
                eval("formObj."+obj2).value="";
                eval("formObj."+obj2).focus();
                return false;
            }
        }
        return true;
    }
    /*
     * converting odd tpsz
     */    
    function oddTpsz(index){
      tpsz=comboObjects[index].GetSelectCode();
      if(tpsz.search('O2') != -1){
        tpsz=tpsz + ',A2';
      }
      if(tpsz.search('O4') != -1){
        tpsz=tpsz + ',A4';
      }
      if(tpsz.search('F2') != -1){
        tpsz=tpsz + ',S2';
      }
      if(tpsz.search('F4') != -1){
        tpsz=tpsz + ',F5,S4';            }
      document.form.oddtpsz.value=tpsz;
    }
    /*
     * in case of filling input box as maxlength, moving to next input box
     */
  	function moveTab(obj1, obj2){
  		if(obj1.maxLength == obj1.value.length) {
  		    obj2.value='';
  			obj2.focus();
  		}
  	}
  	    /*
     * in case of filling input box as maxlength, moving to next input box
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
     * converting to upper case
     */
    function upperCase() {
    	//alert("use that code : dataformat='enguponly' ");
    
    }  	
    /*
     * converting to upper case
     */
    function upperCase_Num() {
    	//alert("use that code : dataformat='engup' ");
    }  	    
    /*
     * in case of difference beween CRE_DT and UPD_DT, changing row color
     */
//     var lColor = "#F5E1D1"; 
     function setColor(sheetObj,type)
     {
        var lColor= COLOR_DIFF_1;
        var rowCnt = sheetObj.RowCount('');
        if(type=='2'){
          for(var row=2; row <= rowCnt +1 ; row++){
        	  if(sheetObj.GetCellValue(row, 'timegap') == 'Y'){
               sheetObj.SetRowBackColor(row,lColor);
             }
          }  
        }else{
             for(var row=1; row <= rowCnt ; row++){
            	 if(sheetObj.GetCellValue(row, 'timegap') == 'Y'){
               sheetObj.SetRowBackColor(row,lColor);
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
          var sRow=sheetObj.FindSubSumRow(stdCol);
          var arrRow=sRow.split("|");
          for (idx=0; idx<arrRow.length-1; idx++){
            sheetObj.SetRowBackColor(arrRow[idx],COLOR_SUB_SUM);
          }
      }

      
    /*
     * available only number
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
     * available only number and dot
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
     * trimming string
     */      
	function trim(inStr) { // string null (trim)
		var re=/ /gi;
		inStr=inStr.replace(re, "");
		return inStr;
	}
	/*
	 *  gubun1 = seperator 
	 *  gubun2 = word to be 
	 */
	function replaceAll(Str ,gubun1 ,gubun2){
		var Strname=Str.split(gubun1);
		var returnStr="";
		for(i=0 ; i < Strname.length ; i++) {
			if ( i == Strname.length-1 ){
				returnStr=returnStr + Strname[i];  
			} else {
				returnStr=returnStr + Strname[i]+gubun2;
			}
		}
		return returnStr;
	}
	
	function toggleSheetSize(hideA1 , hideA2 , hideA3 , hideA4 , hideA5){
		var obj = ComGetEvent();
		var area = obj;
		var status="N";
		var zoomA1 = "";
		var zoomA2 = "";
		var zoomA3 = "";
		var zoomA4 = "";
		var zoomA5 = "";
		if(obj.maxStatus == undefined || obj.maxStatus == "N"){
			status="M";
		}
		var sheetId=obj.getAttributeNode("sheetId").value;

		if(sheetId == undefined ) return;
		var sheetObj=eval(sheetId);
		var isSheet=(( sheetObj) || ( sheetObj.IBSheetVersion)) ;
		var curRow=0;
		if(isSheet){
			curRow=sheetObj.GetSelectRow();
		}
		
		var posTop=0;
		if (hideA1 == undefined || hideA1 == null)	hideA1 = "zoomarea";
		if (hideA2 == undefined || hideA2 == null)	hideA2= "";
		if (hideA3 == undefined || hideA3 == null)	hideA3= "";
		if (hideA4 == undefined || hideA4 == null)	hideA4= "";
		if (hideA5 == undefined || hideA5 == null)	hideA5= "";
		
		zoomA1 = document.getElementById(hideA1)
		if (hideA2 != "") zoomA2 = document.getElementById(hideA2)
		if (hideA3 != "") zoomA3 = document.getElementById(hideA3)
		if (hideA4 != "") zoomA4 = document.getElementById(hideA4)
		if (hideA5 != "") zoomA5 = document.getElementById(hideA5)
		
		posTop=posTop + zoomA1.offsetHeight;
		
		if(status == "M"){
			var etcHeight=zoomA1.offsetHeight ;
			var sizeHeight = document.body.clientHeight ;
			
			zoomA1.style.display = "none";
			if(zoomA2 != "" ) zoomA2.style.display = "none";
			if(zoomA3 != "" ) zoomA3.style.display = "none";
			if(zoomA4 != "" ) zoomA4.style.display = "none";
			if(zoomA5 != "" ) zoomA5.style.display = "none";
			
			area.sheetHeight=sheetObj.GetSheetHeight();
			sheetObj.SetSheetHeight(sizeHeight -20);
			obj.maxStatus="M";
			obj.className="btn_up";
		}
		else{
			sheetObj.SetSheetHeight(area.sheetHeight);
			
			zoomA1.style.display = "";
			if(zoomA2 != "" ) zoomA2.style.display = "";
			if(zoomA3 != "" ) zoomA3.style.display = "";
			if(zoomA4 != "" ) zoomA4.style.display = "";
			if(zoomA5 != "" ) zoomA5.style.display = "";
			
			obj.maxStatus="N";
			obj.className="btn_down";
		}	currSheet=sheetObj;
		if(isSheet){
			setTimeout("scrollToCurRow()", 1);
		}
	}
	
	/* DataSheet.js */

	function dsColSaveName(obj,Col) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Col==null)	Col =  obj.GetSelectCol();

		return(obj.ColSaveName(Col));
	}

	function dsGetRowStatus(obj,Row) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Row==null)	Row = obj.GetSelectRow();

		return(obj.GetRowStatus(Row));
	}

	function dsGetSelectRow(obj) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);

		return(obj.GetSelectRow());
	}

	function dsSetValue(obj,Value,Row,Col) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Row==null)	Row=obj.GetSelectRow();
		if (Col==null)	Col=obj.GetSelectCol();
		obj.SetCellValue(Row, Col,Value,0);
	}

	function dsGetValue(obj,Row,Col) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Row==null)	Row=obj.GetSelectRow();
		if (Col==null)	Col=obj.GetSelectCol();
		return(obj.GetCellValue(Row, Col));

	}

	function dsIsInit(obj) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);

		return eval(obj.id + '_common').isinit;
	}

	function dsRowCount(obj,Status) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Status==null)
			return(obj.RowCount());
		else
			return(obj.RowCount(Status));
	}

	function dsSelectCell(obj,Row,Col,EditMode) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Row==null)	Row=obj.GetSelectRow();
		if (Col==null)	Col=obj.GetSelectCol();
		if (EditMode==null)	EditMode=true;
		obj.SelectCell(Row,Col,EditMode);
	}

	function dsSetRowStatus(obj,Status,Row) {
		if (typeof obj=="string")	obj = eval('document.all.'+obj);
		if (Row==null)	Row=obj.GetSelectRow();
		obj.SetRowStatus(Row,Status);
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
		var codeparam="";
		var gridCodeResetInfo=new Array("compcd","cvid","grpcd","detailcd","wkdt","locatecd","inwhere","tabwhere","cdid","cdnm","incd","param1","param2","param3","param4","param5","initvalue","inittext","savename","viewdetailcd");
		var gridCodeInfoName=new Array();
		var gridCodeInfoValue=new Array();
	 	codeinfo=replace(codeinfo,"&amp;","¤amp;");
		var tmpCodeInfo=codeinfo.split("&");
		for (var i=0; i<tmpCodeInfo.length; i++) {
	 		tmpCodeInfo[i]=replace(tmpCodeInfo[i],"¤amp;","&amp;");
			var tmp=tmpCodeInfo[i].split("=");
			gridCodeInfoName[i]=tmp[0];
			gridCodeInfoValue[i]="";
			for (var j=1; j<tmp.length; j++) {
				gridCodeInfoValue[i] += "=" + tmp[j];
			}
			gridCodeInfoValue[i]=gridCodeInfoValue[i].substring(1);
		}
		for (var i=0; i<gridCodeResetInfo.length; i++) {
			var isexist=false;
			var tmpparam="";
			for (var j=0; j<tmpCodeInfo.length; j++) {
				if (gridCodeResetInfo[i] == gridCodeInfoName[j]) {
					tmpparam=gridCodeInfoName[j] + "=" + encodeURI(parseCodeUrl(gridCodeInfoValue[j]));
					isexist=true;
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
		var colcnt=obj.LastCol();
		if ((eval(obj.id+'_common').checkcode=="0")&&(eval(obj.id+'_common').codeparam != "")){
			var sXml = obj.GetSearchData("/GridCodeRetrieveAction.do",parseCodeUrl(eval(obj.id+'_common').codeparam));
			obj.LoadSearchData(sXml , {Sync:1 , Append:true} )
			for (i=0; i <= colcnt; i++) {
				vdatatype=obj.GetCellProperty(0, i, 'Type');
				if ((vdatatype =="Combo")||(vdatatype =="ComboEdit")) {
					savename=obj.ColSaveName(i);
					codenamestr=obj.GetEtcData("codename_"+savename);
					codestr=obj.GetEtcData("code_"+savename);
					tdefault=obj.GetEtcData("tdefault_"+savename);
					vdefault=obj.GetEtcData("vdefault_"+savename);
					if ((codestr!="") && (codestr!=null)) {
						obj.SetColProperty(savename, {ComboText:codenamestr, ComboCode:codestr} );
					}
				}
			}
			if (eval(obj.id+'_common').codeparam.indexOf('[$') >= 0)
				eval(obj.id+'_common').checkcode="0";
			else
				eval(obj.id+'_common').checkcode="1";
		}
	}


	function setFreeform2Grid(obj,formname) {
		if (typeof obj=="string")	obj=eval('document.all.'+obj);
		// 전체 발리데이션 체크
		var bool=checkValidation(formname);
		if (!bool){
			obj.SelectCell(row2modify,1,false);
			return false;
		}
		else {
			var colcnt=obj.LastCol();
			for (i=0; i <= colcnt; i++) {
				var field=eval('document.'+formname+'.'+obj.ColSaveName(i));
				if(field != null) {
					obj.SetCellValue(row2modify,i,field.value,0);
				}
			}
			return true;
		}
	}


/*	function setGrid2Freeform(obj,formname,isParent) {
	 	var selcnt=0;
	 	if (isParent) {
	 		if (typeof obj=="string")	obj=eval('parent.document.all.'+obj);
			if (!dsIsInit(obj)) {
				parent.makeSelectList(obj);
				selcnt=parent.eval(obj.id + '_sellst').count;
			}
	 	} else {
	 		if (typeof obj=="string")	obj=eval('document.all.'+obj);
			if (!dsIsInit(obj)) {
				makeSelectList(obj);
				selcnt=eval(obj.id + '_sellst').count;
		 	}
		}
		if (selcnt > 0) {
			var	row=obj.GetSelectRow();
			row2modify=row;
			var colcnt=obj.LastCol();
			for (i=0; i <= colcnt; i++) {
				if (obj.ColSaveName(i) == null || obj.ColSaveName(i) == "") {
				}else{
					//var field = eval('document.'+formname+'.'+obj.ColSaveName(i));
					var field=eval('document.'+formname+'.elements(\''+obj.ColSaveName(i)+'\')');
					if(field != null) {
						var value=obj.GetCellValue(row,i);
						if(field.type=='checkbox'){
						// 필드가 체크박스는 무조건 YN 또는 10 이다.
						if (value=='Y'||value==1||field.value==value) {
								field.checked=true;
							} else {
								field.checked=false;
							}
						} else if(field.type==null && field[0].type=='checkbox'){
						// 필드가 체크박스가 여러개 값이 'aaa','bbb','ccc' 또는 aaa|bbb|ccc 이렇게 있다.
						var arr=null;
							if (value.indexOf('\',\'') >-1) {
								arr=eval('new Array('+value+')');
							} else if (value.indexOf('|') >-1) {
								arr=value.split('|');
							} else {
								arr=new Array(value);
							}
							for (var j=0; j< field.length; j++) {
								field[j].checked=false;
							}
							for (var i=0; i< arr.length; i++) {
								for (var j=0; j< field.length; j++) {
									if (arr[i]==field[j].value) field[j].checked=true;
								}
							}
						} else if(field.type=='radio'){
						// 필드가 라디오 버튼인 경우.
						if (field.value==value) {
								field.checked=true;
							} else {
								field.checked=false;
							}
						} else if(field.type==null && field[0].type=='radio'){
						// 필드가 여러개의 라디오 버튼인 경우.
						if (value=='') {
								for(var j=0;j<field.length;j++) {
									field[j].checked=false;
								}
							} else {
								for(var j=0;j<field.length;j++) {
									if (field[j].value == value) field[j].checked=true;
									else field[j].checked=false;
								}
							}
						} else if(field.type=='select-one'){
						// 필드가 셀렉트박스인경우.
						if (value=='') {
								field.value='';
							} else {
								for(var j=0;j<field.options.length;j++) {
									if (field.options[j].value == value) field.options[j].selected=true;
								}
							}
						} else {
						// 기타 다른 필드인경우.
						field.value=value;
						}
						var fieldview=eval('document.'+formname+'.'+obj.ColSaveName(i)+'View');
						if(fieldview != null) {
							if (obj.GetCellProperty(0, i, dpDataFormat")==2) { // 년월 날짜인경우
							fieldview.value=getYearMonth(parseInputYearMonth(value));
						} else if (obj.GetCellProperty(0, i, dpDataFormat")==1) { // 년월일 날짜인경우
							fieldview.value=getDate(parseInputDate(value));
						} else if ((obj.GetCellProperty(0, i, dpDataType""")==6)||(obj.GetCellProperty(0, i, dpDataType)==7)||(obj.GetCellProperty(0, i, dpDataType)==8)){ // 콤보인경우
							fieldview.value=obj.GetCellText(row, i);
							}
						}
					}
				}
			}
		}
		// 직원검색 프리폼에 상세정보를 보여줌.
		var emparray=null;
		if (isParent) {
			emparray=eval('parent.'+obj.id+'_common.empsavename');
		} else {
			emparray=eval(obj.id+'_common.empsavename');
		}
		for(var k=0;k<emparray.length;k++) {
			var field=eval('document.'+formname+'.'+emparray[k]+'View');
			if(field != null) {
				// empid / jobgrdnm / deptnm
				field.value=obj.GetCellValue(row, emparray[k]+'empid') + '/' + obj.GetCellValue(row, emparray[k]+'jobgrdnm') + '/' + obj.GetCellValue(row, emparray[k]+'deptnm');
			}
		}
	}
*/


	
    /*
     * showing first row data on sheet
     */	
    function EqrXml2SheetRows(xmlStr, sheetObj, StartRow) {
    	if (xmlStr == null || xmlStr == "" || sheetObj == null || sheetObj == "") {
    		return;
    	}
    	if (StartRow == null || StartRow == "" ) {
    		return;
    	}
    	try {
            var xmlDoc = ComGetXmlDoc(xmlStr);
            if (xmlDoc == null) return;
            var xmlRoot = xmlDoc.documentElement;
            
    		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
    		if (dataNode == null || dataNode.attributes.length < 3) {
    			return;
    		}
    		var col=dataNode.getAttribute("COLORDER");
    		var colArr=col.split("|");
    		var sep=dataNode.getAttribute("COLSEPARATOR");
    		var total=dataNode.getAttribute("TOTAL");
    		var dataChildNodes=dataNode.getElementsByTagName("TR"); //dataNode.childNodes;
    		if (dataChildNodes == null) {
    			return;
    		}
    		for (var i=0; i < dataChildNodes.length; i++) {
    			if (dataChildNodes[i].nodeType != 1) {
    				continue;
    			}
    			//ComDebug(dataChildNodes[i].firstChild.nodeValue);
    			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
    			var item="";
    			for (var j=0 in colArr) {
    				var colid=sheetObj.SaveNameCol(colArr[j]) ;
    				if(colid != -1)
    					sheetObj.SetCellValue(StartRow+i,colid,arrData[j].trim(),0);
    			}
    		}
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}
    }
	/*
	 * showing error message when called EqrXml2SheetRows 
	 */	
    function EqrGetMsgText(xmlStr){
    	return ComGetSelectSingleNode(xmlStr, "MESSAGE");
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
		//var plusyear  = (anniday.getYear()<100)?"19"+anniday.getYear():anniday.getYear();
		var plusyear  = (anniday.getFullYear()<100)?"19"+anniday.getFullYear():anniday.getFullYear();
		var plusday   = anniday.getDate();

		return plusyear+"-"+fullZero(plusmonth,2)+"-"+fullZero(plusday,2) ;

	}
	
	/**
	* fill '0'
	**/
	function fullZero(str,icount)
	{
		var slength=(""+str).length;
		var s="";
		for (i=0 ; i < icount - slength ; i++){
			s=s + "0";
		}
		return s + str;
	}
	/**
     * replacing string
     */
    function replaceStr(str, find, replace)
    {
        var pos=0;
        pos=str.indexOf(find);
        while(pos != -1) {
            pre_str=str.substring(0, pos);
            post_str=str.substring(pos + find.length, str.length);
            str=pre_str + replace + post_str;
            pos=str.indexOf(find);
        } // end while
        return str;
    }
    /**
	* removing charater in string 
	**/
	function delete_Char(source,char1)
	{
		if (typeof(source) == "string") {
			return replaceStr(source,char1,'');
		}
		else if (typeof(source) == "object") {
			source.value=replaceStr(source.value,char1,'');
		}
		else {
			alert("It's not be supported form");
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
	* checking character value
	**/
	function chkCharValue(value, pchar, upper, maxLen){
		var newValue="" ;
		var oneChar=null ;
		for(i=0;i<value.length; i++){
			oneChar=value.charAt(i) ;
			if(pchar.indexOf(oneChar)!=-1 && (maxLen==null || newValue.length<maxLen)){
				newValue += oneChar ;
			}
		}
		newValue=upper ? newValue.toUpperCase() : newValue ;
		return newValue ;
	}
	/**
	* checking date value
	**/
	function chkDateValue(value){
		var yyyy=value.substring(0,4) ;
		var mm=value.substring(4,6) ;
		var dd=value.substring(6) ;
		var daysInMonth=new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31) ;
		// month
		if(mm>12) {
			return false ;
		}
		if(mm==2){
			daysInMonth[1]=yyyy%400==0 || ((yyyy%4==0) && (yyyy%100!=0)) ? 29 : 28 ; 
		}
		// date
		if(dd!="" && mm!="" && dd>daysInMonth[mm-1]){
			return false ;
		}
		return true ;
	}

	
	
		/**
		 * making form query string
		 */	 
	 function eqrFormQryStr(form, exElmNms) {

	     if (typeof form != "object") {
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
	     	  //전송전에 폼의 마스크를 제거한다.
//	     	  ComClearSeparator(form.elements[i]);
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
	     }
	     
	     for (i=0; i < j; i++) {
	         if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
	     }
	     
	   //마지막에 &를 없애기 위함
	   if (plain_text != "")
	     plain_text=plain_text.substr(0, plain_text.length -1);
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

//============================================================================ //
///////////////////////////// TMO 장비 회송 프로젝트 MSG (S) /////////////////////////
//============================================================================ //

function getCodeXmlList(cmd, param){
	var rtn=new Array();
    rtn[0]="";
    rtn[1]="";
    createCodeSheetObject();
    with(codeSheet){
        ShowDebugMsg = false;
        var sXml = GetSearchData("EES_EQR_CODGS.do", "f_cmd="+SEARCHLIST02+"&mcode="+cmd+"&"+param);
        var xml  = sXml.substring(sXml.indexOf("<SHEET>"), sXml.indexOf("</SHEET>") + 8);
    }
    return xml;
} 
var codeSheet=null;
$(document).ready(function(){
	createCodeSheetObject();
});


function createCodeSheetObject(){
    if(codeSheet != null){
        return;
    }
    var baseCode="";
    var objs =$("[id^='DIV_']");
    for(var i = 0 ; i < objs.length ; i++){
    	baseCode="";
        break;
    }
    
    
    var sTag="";
    var id="codeSheet";

    var divElement=document.createElement("DIV");
    divElement.id = "MAKE_HIDDEN_SHEET";
    divElement.style.display="none";
    divElement.innerHTML=sTag;
    document.body.appendChild(divElement);
    ComGetSheetDivObjectTag(MAKE_HIDDEN_SHEET,id);
    ComConfigSheet(codeSheet);
    
    with(codeSheet){
       var HeadTitle="Status|Seq.|Code|Name";

       SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, FrozenCol:1, DataRowMerge:0 } );

       var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
       var headers = [ { Text:HeadTitle, Align:"Center"} ];
       InitHeaders(headers, info);

       var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"FLG",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"CODE",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"TEXT",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
        
       InitColumns(cols);

		SetSheetWidth(300);
		SetSheetHeight(150 );
		SetEditable(1);
		SetVisible(0);
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

	var obj=window[elemName];

	var rtn = getCodeXmlList("TradeCombo", "");

	obj.SetTitle("Trade|Description");
	obj.SetColWidth(0, "50");
	obj.SetColWidth(1, "200");
	obj.SetMultiSelect(isMulti);
	if(isMulti == true){
		obj.SetMultiSeparator(",");
	}
	ComXml2ComboItem(rtn, obj, "trd_cd", "trd_cd|trd_nm");
	obj.SetDropHeight(obj.GetItemCount()*(obj.GetItemHeight()+0.5));
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
	
	var obj=window[elemName];
	if(trdCd == null || trdCd == ""){
		var rtn = getCodeXmlList("SubTradeCombo", "");
	}else{
		var rtn = getCodeXmlList("SubTradeCombo", "trdCd=" + trdCd);
	}
	
	obj.SetTitle("Trade|SubTrade|Description|");
	obj.SetMultiSelect(isMulti);
	if(isMulti == true){
		obj.SetMultiSeparator(",");
	}
	obj.SetColWidth(0, "50");
	obj.SetColWidth(1, "60");
	obj.SetColWidth(2, "200");
	//obj.SetColWidth(3, "0");
	obj.SetDropHeight(190);
	//obj.ShowCol(3);

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

	var obj=window[elemName];
	if(reCdValue == null || reCdValue == ''){
		var rtn = getCodeXmlList("SLaneCombo", "" );
	}else{
		var rtn = getCodeXmlList("SLaneCombo",  "locTrdCd=" + locTrdCd+ "&locSubTrdCd=" + locSubTrdCd);
	}

	obj.SetTitle("Trade|SubTrade|Lane|Description");
	obj.SetColWidth(0, "50");
	obj.SetColWidth(1, "60");
	obj.SetColWidth(2, "60");
	obj.SetColWidth(3, "250");
	obj.SetMultiSelect(isMulti);
	if(isMulti == true){
		obj.SetMultiSeparator(",");
	}
	obj.SetDropHeight(190);
	//obj.ShowCol(2);

	ComXml2ComboItem(rtn, obj, "val_cd", "trd_cd|sub_trd_cd|lane_cd|lane_nm");

//  lane 수정용(미적용상태)	
//	obj.ShowCol(4);
//
//	ComXml2ComboItem(rtn, obj, "val_cd", "trd_cd|sub_trd_cd|lane_cd|lane_nm|val_cd");	

}

function changeViewCombo(sheetObj, sXml) {
    var xmlDoc = ComGetXmlDoc(sXml);
    var xmlRoot = xmlDoc.documentElement;
    var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
    
    if (dataNode == null) {
        return;
    }
    
    var trDataChildNodes = dataNode.childNodes;
    
    for (var i=0; i<trDataChildNodes.length; i++) {
    	if (trDataChildNodes[i] == null) {
    		return;
    	} else {
    		if (trDataChildNodes[i].nodeName == "TR") {
    			var tdDataChildNodes = trDataChildNodes[i].childNodes;
    			var targetRow = trDataChildNodes[i].getAttribute("ROW");
    			
    			for (var j=0; i<tdDataChildNodes.length; j++) {
    				if (tdDataChildNodes[j] == null) {
    					return;
    				} else {
    					if (tdDataChildNodes[j].nodeName == "TD") {
        					var targetCol = tdDataChildNodes[j].getAttribute("COL");
        					var dataType = tdDataChildNodes[j].getAttribute("DATA-TYPE");
        					
        					if (targetCol == null || dataType == null) {
        						return;
        					} else {
        						if (dataType == "dtComboEdit") {
                					var comboCode = tdDataChildNodes[j].getAttribute("COMBO-CODE");
                					var comboText = tdDataChildNodes[j].getAttribute("COMBO-TEXT");
                					sheetObj.InitCellProperty(targetRow , targetCol , {Type:"Combo", ComboCode:comboCode, ComboText:comboCode});
                					if(targetCol == "t1_fm_yd_cd") {
                						var arrCombo = comboCode.split("|");
                						var arrComboSize = arrCombo.length;
                						sheetObj.SetCellValue(targetRow, targetCol, arrCombo[0], 0);
                					}
        						} else if (dataType == "dtCombo") {
                					var comboCode = tdDataChildNodes[j].getAttribute("COMBO-CODE");
                					var comboText = tdDataChildNodes[j].getAttribute("COMBO-TEXT");
        							sheetObj.InitCellProperty(targetRow , targetCol , {Type:"Combo", ComboCode:comboCode, ComboText:comboCode});
        						} else if (dataType == "dtData") {
        							
        							var tdValNode = tdDataChildNodes[j].childNodes;
        							var tdVal = tdValNode[0].nodeValue;
        							sheetObj.SetCellValue(targetRow, targetCol, tdVal, 0);
        							
        							if(targetCol == "t1_fm_yd_cd") {
        								sheetObj.InitCellProperty(targetRow , targetCol , {Type:"Combo", ComboCode:tdVal, ComboText:tdVal});
        							}
        						} else {
        							return;
        						}
        					}
    					}
    				}
    			}
    		}
    	}
    }
    
}

function changeViewText(sheetObj, sXml, Col) {
    var xmlDoc = ComGetXmlDoc(sXml);
    var xmlRoot = xmlDoc.documentElement;
    var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
    
    if (dataNode == null) {
        return;
    }
    
    var trDataChildNodes = dataNode.childNodes;
    
    for (var i=0; i<trDataChildNodes.length; i++) {
    	if (trDataChildNodes[i] == null) {
    		return;
    	} else {
    		if (trDataChildNodes[i].nodeName == "TR") {
    			var tdDataChildNodes = trDataChildNodes[i].childNodes;
    			var targetRow = trDataChildNodes[i].getAttribute("ROW");
    			
    			for (var j=0; i<tdDataChildNodes.length; j++) {
    				if (tdDataChildNodes[j] == null) {
    					return;
    				} else {
    					if (tdDataChildNodes[j].nodeName == "TD") {
        					var targetCol = tdDataChildNodes[j].getAttribute("COL");
        					var dataType = tdDataChildNodes[j].getAttribute("DATA-TYPE");
        					
        					if (targetCol == null || dataType == null) {
        						return;
        					} else {
        						if (dataType == "dtComboEdit") {
                					var comboCode = tdDataChildNodes[j].getAttribute("COMBO-CODE");
                					var comboText = tdDataChildNodes[j].getAttribute("COMBO-TEXT");
        							sheetObj.InitCellProperty(targetRow , targetCol , {Type:"ComboEdit", ComboCode:comboCode, ComboText:comboCode});
        						} else if (dataType == "dtCombo") {
                					var comboCode = tdDataChildNodes[j].getAttribute("COMBO-CODE");
                					var comboText = tdDataChildNodes[j].getAttribute("COMBO-TEXT");
        							//sheetObj.InitCellProperty(targetRow , targetCol , {Type:"Combo", ComboCode:comboCode, ComboText:comboCode});
                					sheetObj.SetCellValue(targetRow, targetCol, comboText, 0);
        						} else if (dataType == "dtData") {
        							var tdValNode = tdDataChildNodes[j].childNodes;
        							var tdVal = tdValNode[0].nodeValue;
        							sheetObj.SetCellValue(targetRow, targetCol, tdVal, 0);
        						} else {
        							return;
        						}
        					}
    					}
    				}
    			}
    		}
    	}
    }
    
}


function isValidDate(param) {
    try
    {
        param = param.replace(/-/g,'');

        // 자리수가 맞지않을때
        if( isNaN(param) || param.length!=8 ) {
            return false;
        }
         
        var year = Number(param.substring(0, 4));
        var month = Number(param.substring(4, 6));
        var day = Number(param.substring(6, 8));

        var dd = day / 0;

         
        if( month<1 || month>12 ) {
            return false;
        }
         
        var maxDaysInMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
        var maxDay = maxDaysInMonth[month-1];
         
        // 윤년 체크
        if( month==2 && ( year%4==0 && year%100!=0 || year%400==0 ) ) {
            maxDay = 29;
        }
         
        if( day<=0 || day>maxDay ) {
            return false;
        }
        return true;

    } catch (err) {
        return false;
    }                       
}

// ============================================================================ //
///////////////////////////// TMO 장비 회송 프로젝트 MSG (E) /////////////////////////
// ============================================================================ //


function chkLocationVol(vCode,vCodeNm,fmYdLoc,toYdLoc,volTotal) {
	var arrVCode = "";
	var arrVCodeNm = "";
	if(vCode != "") {
		arrVCode = vCode.split("|");
		arrVCodeNm = vCodeNm.split("|");
		
		for(var j=0;j<arrVCode.length;j++) {	
			if (toYdLoc.substring(0,2) != fmYdLoc.substring(0,2)) {
				if(toYdLoc.substring(0,2) == arrVCode[j]) {
					if(Number(volTotal) > Number(arrVCodeNm[j])) {
						ComShowCodeMessage("EQR01152",arrVCodeNm[j],arrVCode[j]);
						return false;
					}
				}
			}
		}
	}
}