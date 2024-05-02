/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoDmt.js
*@FileTitle  : DEM/DET 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
//AS-IS message
	if(msgs == undefined){
		msgs = new Array();
	}
msgs['DMT00001']="Data was saved successfully.";
msgs['DMT00002']="Data was retrieved successfully";
msgs['DMT00003']="Failed to save {?msg1}. Please try it again.";
msgs['DMT00004']="Failed to delete {?msg1}. Please try it again.";
msgs['DMT00005']="BKG No. is invalid";
msgs['DMT00006']="Failed to retrieve {?msg1}. Please try it again.";
msgs['DMT00007']='Saved successfully!';
msgs['DMT00008']="Failed to {?msg1}. Please try it again.";
msgs['DMT00009']="At least one row needs to be selected";
msgs['DMT01001']="There is an invoice issued for this container. Please cancel the issued invoice first and change DR data!";
msgs['DMT01002']='Already Invoiced';
msgs['DMT01003']='DR Date must be later than current date !';
msgs['DMT01010']='You can only transfer Finished status charge to the other RHQ!';
msgs['DMT01019']='Only Finished, Long staying status can be transferred!';
msgs['DMT01020']='To date should be same or later than From date';
msgs['DMT01021']='Choose Should Read(Office)!';
msgs['DMT01022']='Date for split payment must be earlier than the current date!';
msgs['DMT01023']='Date should be between the From date and next To date!';
msgs['DMT01024']="It's already interfaced to A/R!";
msgs['DMT01025']="For this container, it's already invoiced. Will you make a revised invoice with split amount?";
msgs['DMT01026']="It's already invoiced. You can't delete it!";
msgs['DMT01027']='MT Notification will be canceled. Do you want to change the TO Date?';
msgs['DMT01028']='To Date must be between From Date and Next To Date!! Please Check the Date!!';
msgs['DMT01029']='Invoiced Container should have charge';
msgs['DMT01030']='There is a balance charge !';
msgs['DMT01031']='{?msg1} should be same or later than {?msg2}';
msgs['DMT01032']='{?msg1} Up to should be larger than From number';
msgs['DMT01036']='There is an invoice issued for this container. Please cancel the issued invoice first and change DR data!';
msgs['DMT01037']='Are you sure to cancel the Web Empty Notification?';
msgs['DMT01038']='Input the reason in remark(more than 10 letters)!';
msgs['DMT01039']='Are you sure to delete all Balance charge for this cntr?';
msgs['DMT01040']='There are no Finished, Confirmed, Invoiced, Long Staying or Unfinished cntr for Demand.';
msgs['DMT01041']='There are no Confirmed cntr for billing!';
msgs['DMT01042']='Pls select cntr in Deleted status';
msgs['DMT01043']='There is a balance charge in Invoiced status. Please cancel the issued invoice first before deleting balance charges!';
msgs['DMT01044']='Choose Should Read(Other Office)!';
msgs['DMT01045']='Input the reason!';
msgs['DMT01046']='Date should be earlier than the current date, if last To MVMT Status is DR';
msgs['DMT01047']='Date should be between the From date and next To date!';
msgs['DMT01048']='To date should be same or later than From date';
msgs['DMT01049']='Please select exemption reason on the list!';
msgs['DMT01050']='Input the reason in remark(more than 10 letters)!';
msgs['DMT01051']='Pls update Payer code and Tax Rate first!';
msgs['DMT01052']='Pls update Payer code first!';
msgs['DMT01053']='Calculation Type discrepancy! [{?msg1}] – [Combined]';
msgs['DMT01054']='Charge already generated!';
msgs['DMT01055']='Gap with ETA date is allowed upto 10 days. CNTR [{?msg1}]';
msgs['DMT01056']='Manual batch program will run to generate charges based on your from date entries. Are you sure to proceed?';
msgs['DMT01057']='There is already a balance charge!';
msgs['DMT01058']='Balance Charge can be created only for Finished, Confirmed, Invoiced charge with D/R(Delivery & Return) Date';
msgs['DMT01059']='D/R date should be later than From date';
msgs['DMT01060']='Please check the charge status! D/R date can be updated only for Finished charge with D/R date, Unfinished and Long Staying cntrs';
msgs['DMT01061']='Charge not generated!';
msgs['DMT01062']='From Date should be same or later than current date';
msgs['DMT01063']='Do you want to cancel exemption?';
msgs['DMT01064']='{?msg1} missing! CNTR [{?msg2}]';
msgs['DMT01065']='CNTR [{?msg1}] is duplicated!';
msgs['DMT01066']='Please select one office at a time';
msgs['DMT01067']="Only one of 'Long Staying' and 'All Long Staying' can be selected";
msgs['DMT01068']="It's already invoiced. You can't {?msg1} it!";
msgs['DMT01069']="Balance Charge will be created. Are you sure to proceed?";
msgs['DMT01070']="First row cannot be deleted!";
msgs['DMT01071']="Only inserted rows can be deleted! Pls use D/R cancel for balance charge deletion.";
msgs['DMT01073']="Date should be between the F/T End date and next To date!";
msgs['DMT01074']="Office Tranfer was successful!";
msgs['DMT01075']="Vessel's schedule is not found!";
msgs['DMT01076']="Please check the status. Only confirmed cntrs can be selected for {?msg1}";
msgs['DMT01077']="Please check the status. Error, No Charge or Deleted cntrs cannot be selected for Demand";
msgs['DMT01078']="D/R Date should be later than from date for balance charge!";
msgs['DMT01079']='Gap with ETA date is allowed upto 10 days. VVD [{?msg1}]';
msgs['DMT01080']='Limited up to {?msg1} at a time!';
msgs['DMT02001']='Dual Type Exception already applied in S/C Exception Tariff or Before Booking DAR. Pls delete S/C Exception Tariff or cancel/reject Before Booking DAR before deleting Dual Type Exception customer[{?msg1}]! S/C Proposal No[{?msg2}], Before BKG[{?msg3}]';
msgs['DMT02002']='{?msg1} Missing!';
msgs['DMT02003']='Pls recheck Seq. {?msg1}. Calculation Type discrepancy! [{?msg2}] - [Dual]';
msgs['DMT02004']='Pls recheck Seq. {?msg1}. Only one of Add day or Total day can be input';
msgs['DMT02005']='Pls recheck Seq. {?msg1}. The last “Up to” CNTR Q’ty of Tiered Free Time should be null!';
msgs['DMT02006']='Pls recheck Seq. {?msg1}. The last “Up to” Over Day of Rate Adjustment should be null!';
msgs['DMT02007']='Will you delete this version?';
msgs['DMT02008']='Discrepancy with Coverage continent!';
msgs['DMT02009']='This is an approved row. If you delete this row, it won’t be effective any more. Are you sure to proceed ?';
msgs['DMT02010']='Pls check the Type option!';
msgs['DMT02011']='Pls recheck Seq. {?msg1}. Free Time or D/C Amount or Ratio is mandatory!';
msgs['DMT02012']='Pls recheck Seq. {?msg1}. Only one of D/C Amount or Ratio can be input';
msgs['DMT02013']='Pls recheck Seq. {?msg1}. Duplicated BKG. DAR No. [{?msg2}]';
msgs['DMT02015']='Pls recheck Seq. {?msg1}. CNTR[XXXX] with Balance Charge cannot be applied of this DAR! Pls contact DEM/DET Office [XXXXX]';
msgs['DMT02016']='Please input the [Tariff Type] first.';
msgs['DMT02017']='Duplicated! DEM/DET Office [{?msg1}] for ID [{?msg2}]';
msgs['DMT02018']='Please input country code or port code !';
msgs['DMT02028']='Pls recheck Seq. {?msg1}. Free Time or Rate Adjustment should be selected!';
msgs['DMT02029']='There is no charge found!';
msgs['DMT02030']='There is no BKG No. or B/L No. found!';
msgs['DMT02031']='Dual Type Exception already applied in S/C Exception Tariff. Pls delete S/C Exception Tariff before deleting Dual Type Exception customer [{?msg1}]!   S/C Proposal No. [{?msg2}]';
msgs['DMT02032']='Dual Type Exception already applied in Before Booking DAR. Pls cancel/reject Before Booking DAR before deleting Dual Type Exception customer [{?msg1}]!   DAR [{?msg2}]';
msgs['DMT03017']="Failed to retrieve {?msg1}. Please try it again.";
msgs['DMT03018']='Please check the status before you confirm it. You can confirm only Finished status';
msgs['DMT03022']='Already interfaced Invoice No!';
msgs['DMT03024']='Only Issue Office({?msg1}) can cancel the invoice. Please recheck your login Office code.( ""{?msg2}""=> Issue Office Code)"';
msgs['DMT03025']='Will you cancel this invoice?';
msgs['DMT03026']='Do you want to interface this invoice?';
msgs['DMT03027']='A/R I/F Success! Invoice No:{?msg1}';
msgs['DMT03028']='{?msg1} missing!';
msgs['DMT03033']='Pls load excel the necessary data before auditing. {?msg1} is mandatory item.';
msgs['DMT03051']='Get To MVMT already done. Are you sure to proceed?';
msgs['DMT03052']='Calculate already done. Are you sure to proceed?';
msgs['DMT03053']='Pls click Get To MVMT first!';
msgs['DMT03054']='Charge needs to be calculated in advance!';
msgs['DMT03055']='Charge is not in Finished status!';
msgs['DMT03056']='No Invoice No.! Pls create invoice first!';
msgs['DMT03057']='Only for DEM/DET Manual Invoice!';
msgs['DMT03069']='{?msg1} blocked for Dual Type Exception!';
msgs['DMT03071']='Please check Seq. {?msg1}. DEM/DET office not under your authorization.';
msgs['DMT04001']='Dual Type Exception already applied in S/C Exception Tariff or Before Booking DAR. Pls correct the expiration date in S/C Exception Tariff or Before Booking DAR before expiring Dual Type Exception customer[{?msg1}]! S/C Proposal No[{?msg2}], Before BKG[{?msg3}]!';
msgs['DMT04011']='Dual Type Exception already applied in S/C Exception Tariff. Pls correct the expiration date in S/C Exception Tariff expiring Dual Type Exception customer [{?msg1}]!   S/C Proposal No. [{?msg2}]';
msgs['DMT04012']='Dual Type Exception already applied in Before Booking DAR. Pls correct the expiration date in Before Booking DAR before deleting Dual Type Exception customer Dual Type Exception customer [{?msg1}]!   DAR [{?msg2}]';
msgs['DMT05014']='Pls input {?msg1}!';
msgs['DMT05015']='Only country or location code!';
msgs['DMT06001']='No Data Found!';
msgs['DMT06015']='"No Data", "Do you want to reuse Last year\'s table?"';
//add message
msgs['DMT00101']='Please enter a valid date format for({?msg1}) : MMDD';
msgs['DMT00102']='Please enter {?msg1}';
msgs['DMT00103']='Period cannot be over 3 weeks!';
msgs['DMT00104']='{?msg1} cannot be over {?msg2} bytes!';
msgs['DMT00105']='PERIOD OVERLAPPED DATA EXISTS!';
msgs['DMT00106']='Clock Stop is already cancelled!';
msgs['DMT00107']='You can inquire \'Sub Office\' for one office code at a time';
msgs['DMT00108']='Pls recheck Seq.{?msg1}. {?msg2} missing!'
msgs['DMT00109']='Holiday duplicated! [{?msg1}]';
msgs['DMT00110']='Invalid {?msg1} Code';
msgs['DMT00111']='Pls update holiday before saving';
msgs['DMT00112']='No authority to cancel';
msgs['DMT00113']='Pls recheck Seq. {?msg1}. Total Day only for Dual Type Exception!';
msgs['DMT00114']='Pls recheck Seq. {?msg1}. Rate Adjustment mandatory for Dual Type Exception!';
msgs['DMT00115']='Pls recheck Seq. {?msg1}. {?msg2} must be over 2 rows!';
msgs['DMT00116']='Pls expire the previous tariff first!';
msgs['DMT00117']='Expiration Date different! Pls create tariff group separately!';
msgs['DMT00118']='Already confirmed!';
msgs['DMT00119']='{?msg1} must be {?msg2} characters long.';
msgs['DMT00120']='{?msg1} must be {?msg2} numbers long.';
msgs['DMT00121']='Pls create tariff for all 10 CNTR & Cargo Types!';
msgs['DMT00122']='Are you sure to confirm?';
msgs['DMT00123']='Not in confirmed staus!';
msgs['DMT00124']='Only for future tariff!';
msgs['DMT00125']='Already expired!';
msgs['DMT00126']='Pls make sure to create new tariff!';
msgs['DMT00127']='Effective Date different! Pls update tariff group separately!';
msgs['DMT00128']='No data for saving!';
msgs['DMT00129']='Pls recheck Seq. {?msg1}. Rate Adjustment mandatory for Dual Type Exception!';
msgs['DMT00130']='At First, Pls choose Coverage CN';
msgs['DMT00131']='Pls save the data after update!';
msgs['DMT00132']='Pls recheck Seq. {?msg1}. Calculation Type discrepancy! [{?msg2}] - [Combined]';
msgs['DMT00133']='Do you want to update the data?';
msgs['DMT00134']='Maximun 2 characters are allowed';
msgs['DMT00135']='Do you want to {?msg1}?';
msgs['DMT00136']='Pls make sure to click Request button for request!';
msgs['DMT00137']='Do not delete this row if you need to keep it effective. Are you sure to delete this row?';
msgs['DMT00138']='Pls recheck Seq. {?msg1}. Duplicate data Found! {?msg2}';
msgs['DMT00139']='This version is not requested. Do you want to close without requesting it?';
msgs['DMT00140']='Pls select {?msg1}';
msgs['DMT00143']='Are you sure to delete ?';
msgs['DMT00144']='Duplicated {?msg1}!';
msgs['DMT00145']='Will you delete Commodity ?';
msgs['DMT00146']='Effective Date must be later than today for {?msg1}!';
msgs['DMT00147']='Data was changed. Do you want to close without saving it?';
msgs['DMT00148']='At First, Pls enter {?msg1}';
msgs['DMT00149']='The last [Up to] CNTR Q\'ty of Free Time should be null!';
msgs['DMT00150']='The last [Up to] Over Day of Rate should be null!';
msgs['DMT00151']='Pls select comment to input your comment';
msgs['DMT00152']='Pls recheck Seq. {?msg1}. Free Time mandatory for Dual Type Exception!';
msgs['DMT00153']='To Tariff already exists!';
msgs['DMT00154']='Pls select dual type exception to {?msg1} on the list!';
msgs['DMT00155']='Pls recheck Seq. {?msg1}. Tariff Type/BKG No. is duplicated with DAR No. [{?msg2}]';
msgs['DMT00156']='There is no Finished charge!';
msgs['DMT00157']='Number of containers exceeds maximum number 1,000.';
msgs['DMT00158']='Period cannot be over {?msg1} year!';
msgs['DMT00159']='Pls recheck Seq. {?msg1}. Different S/C or RFA No! Different DAR should be made for this BKG';
msgs['DMT00160']='DAR is {?msg1}';
msgs['DMT00161']='Pls recheck Seq. {?msg1}. Tariff Type/BKG No. is duplicated';
msgs['DMT00162']='Period cannot be over {?msg1}!';
msgs['DMT00163']='Customer Code is not valid!';
msgs['DMT00164']='Demand note should have CNTR!';
msgs['DMT00165']='{?msg1} is invalid!';
msgs['DMT00166']='Please enter DAR No. or APVL No.';
msgs['DMT00167']='It\'s already interfaced to A/R!\nAre you sure to request adjustment?';
msgs['DMT00168']='Pls recheck Seq. {?msg1}. input D/C Amount or Ratio';
msgs['DMT00169']='Invoice should have billable amount';
msgs['DMT00170']='Invoice was updated successfully';
msgs['DMT00171']='Pls check {?msg1}';
msgs['DMT00172']='F/T CMNC date should be same or next day of From Date';
msgs['DMT00173']='Please select invoice cancel reason on the list!';
msgs['DMT00174']='Duplicated CNTR No[{?msg1}]!';
msgs['DMT00175']='Calling port unmatch!';
msgs['DMT00176']='[{?msg1}] was already deleted';
msgs['DMT00177']='Data will be replaced. Do you want to copy?';
msgs['DMT00178']='Pls select one row';
msgs['DMT00179']='Detail for Live status only!';
msgs['DMT00180']='Please enter only one of S/C No. or RFA No. or Proposal No. or DAR No. or APVL No.';
msgs['DMT00181']='Please enter only one of S/C No. or RFA No. or Proposal No. or DAR No. or APVL No. or BKG No. or B/L No.';
msgs['DMT00182']='Pls update Payer code first!';
msgs['DMT00183']='Invoice should have billing amount!';
msgs['DMT00184']='Discrepancy found in Tax Rate between Invoice and Sheet Option. Are you sure to save?';
msgs['DMT00185']='Pls use Customer code as payer!';
msgs['DMT00186']='Do you want to interface the selected invoices?';
msgs['DMT00187']='Attention Info for Invoice sheet cannot be deleted!';
msgs['DMT00188']='Please recheck Seq. {?msg1}. Attention/Tel./Fax/E-mail duplicated!';
msgs['DMT01081']='This has been done already.';
msgs['DMT01089']='{?msg1} should be later than {?msg2}';
msgs['DMT01090']='Fax No missing! Pls input Fax No in Payer Info';
msgs['DMT01091']='E-mail address missing! Pls input E-mail address in Payer Info';
msgs['DMT01092']='Do you want to send fax? \nFax No.:{?msg1}';
msgs['DMT01093']='Do you want to send e-mail? \nEmail No.:{?msg1}';
msgs['DMT01094']='Pls recheck seq. :{?msg1}\nInvoice No already created! Pls go to detail screen to update data';
msgs['DMT01095']='Please select one DEM/DET office at a time';
msgs['DMT01096']='Please create Sheet Set first!';
msgs['DMT01097']='Pls recheck seq. :{?msg1}\nNo Invoice No.! Pls create invoice first!';
msgs['DMT01098']='Pls recheck Seq. :{?msg1}\nAlready interfaced Invoice No.';
msgs['DMT01099']='Sender E-mail address missing!';
msgs['DMT01100']='[Maximum Period is [3 Months or 12 weeks]';
msgs['DMT01101']='OTS Sheet should have invoices.';
msgs['DMT01102']='When Credit Term is 0, Due Date should be either Issue Date or *******';
msgs['DMT01103']='Only Issue Office can save the data!';
msgs['DMT01104']='Tariff Type Duplicated for Credit Term';
msgs['DMT01105']='Tariff Type Duplicated for Customized Title [{?msg1}]';
msgs['DMT01106']='Input the reason in remark(more than 10 letters)!';
msgs['DMT01107']='Please select invoice hold reason on the list!';
msgs['DMT01108']='Pls go to SZPBB DEM Billing menu to {?msg1}';
msgs['DMT01109']='Payer Code was updated successfully!';
msgs['DMT01110']='Tariff Type missing for {?msg1}';
msgs['DMT01111']='Seq.{?msg1} 가 {?msg2} 되었습니다. 저장 하시겠습까?';
msgs['DMT01112']='Data was changed. Do you want to {?msg1}?';
msgs['DMT01113']='There is no changed data';
msgs['DMT01114']='When the new version is accepted, version [{?msg1}] will be deleted. Do you want to update to the new version?';
msgs['DMT01115']='먼저, 변경된 내용을 저장하세요.';
msgs['DMT01116']='Data was {?msg1} successfully.';
msgs['DMT01117']='There are no data for {?msg1}';
msgs['DMT01118']='There are no data. Do you want to delete this version?';
msgs['DMT01119']='This is the last row. Do you want to delete this version?';
msgs['DMT01120']='Please create Sheet Set first! {?msg1}';
msgs['DMT01121']='Same version cannot be copied!';
msgs['DMT01122']='When the new version is approved, Approved version [{?msg1}] will be cancelled. Do you want to update to the new version?';
msgs['DMT01123']='Last row cannot be deleted. Cancel this version if necessary';
msgs['DMT01124']='{?msg1}. duplicated. Are you sure proceed?';
msgs['DMT01125']='Unexpected system error occurred during data processing';
msgs['DMT01126']='Do you want to save(cancel)?';
msgs['DMT01127']='Clock Stop will be immediately cancelled. Are you sure to proceed?';
msgs['DMT01128']='{?msg1} should be larger than {?msg2}';
msgs['DMT01129']='Location code is not in your area';
msgs['DMT01130']='Approval cannot be cancelled. Do you want to approve?';
msgs['DMT01131']='Do you want to expire this tariff group?';
msgs['DMT01132']='Do you want to save this sheet set?';
msgs['DMT01133']='Only Issue Office can save the data!';
msgs['DMT01134']='Are you sure to delete this sheet set?';
msgs['DMT01135']='Only Issue Office can delete the data!';
msgs['DMT01136']='Data was changed. Do you want to approve with changed data?';
msgs['DMT01137']='Do you want to cancel confirmation?';
msgs['DMT01138']='Free Time is 0. Do you want to save?';
msgs['DMT01139']='Do you want to send E-mail to selected payers?';
msgs['DMT01140']='Do you want to send Fax to selected payers?';
msgs['DMT01141']='Limited up to 100 invoices at a time';
msgs['DMT01142']='System performance can be slow with "No Charge" included.\nDo you want to proceed?';
msgs['DMT01143']='Please check payer code';
msgs['DMT01144']='{?msg1} cannot be the same country as Coverage';
msgs['DMT01145']='You have no authority to {?msg1}!';
msgs['DMT01146']='Please enter {?msg1} route or use common VVD CFDRYYMME';
msgs['DMT01147']='Are you sure to delete this tariff group?';
msgs['DMT01148']='Version()status has changed. Please click {?msg1} button';
msgs['DMT01149']='Is this tariff group correct? If not, instead of expiration, pls contact system manager to delete the data';
msgs['DMT01150']='Please select {?msg1} to send!';
msgs['DMT01151']="S/C party can't be inputted here";
msgs['DMT01152']="There is no B/L No";
msgs['DMT01153']="The case is requested for deletion, so it can't be transferred to other office.";
msgs['DMT01154']="The case is requested for deletion, so it can't be invoiced.";
msgs['DMT01155']="The case is requested for deletion.";
msgs['DMT01156']="There is no TPB Customer for the Vendor. Please create TPB customer first in MDA Vendor.";
msgs['DMT01157']="Payer is not actual customer.";

msgs['DMT01165'] = "Manual Calculation for BKG No.[{?msg1}] / CNTR No. [{?msg2}] executed.";
msgs['DMT01166'] = "Do you want to calulate free time for BKG No.[{?msg1}] / CNTR No. [{?msg2}] ?";
msgs['DMT01167'] = "No data is found to calulate free time for BKG No.[{?msg1}] / CNTR No. [{?msg2}] now.";
msgs['DMT01168'] = 'Invoiced Container should have charge. Invoice no [{?msg1}].';
msgs['DMT01169'] = 'Invalid character! Only [{?msg1}] accepted.';

	/**
	 *
	 * 초기값 날짜 셋팅 :ex)21 : 오늘부터 21일 전 날짜. <br>
	 * <b>Example :</b>
	 *
	 * <pre>
	 *  var set_day = 21;
	 *  var formObject = document.form ;
	 *  var data = getDefaultDate(set_day).split(&quot;|&quot;);
	 * formObject.fm_dt.value = data[1];
	 * formObject.to_dt.value = data[0];
	 * &lt;pre&gt;
	 * @return 현재날짜 | 과거날짜
	 * @see #링크연결
	 * @author 최성환
	 * @version 2009.05.13
	 *
	 */
	function getDefaultDate(set_day) {
		var default_set_day=set_day;
		var today=new Date();
		var year=today.getYear();
		var month=today.getMonth() + 1;
		var day=today.getDate();
		if (month < 10) {
			month="0" + month;
		}
		if (day < 10) {
			day="0" + day;
		}
		var currDate=year + "-" + month + "-" + day;// 현재 날짜 생성
		var beforeDate=new Date(today.valueOf()
				- (default_set_day * 24 * 60 * 60 * 1000)); // default_set_day * 24*60*60*1000
		var beforeyear=beforeDate.getYear();
		var beforemonth=beforeDate.getMonth() + 1;
		var beforeday=beforeDate.getDate();
		if (beforemonth < 10) {
			beforemonth="0" + beforemonth;
		}
		if (beforeday < 10) {
			beforeday="0" + beforeday;
		}
		var beforeDate=beforeyear + "-" + beforemonth + "-" + beforeday;
		// 날짜 생성
		return currDate + "|" + beforeDate;
	}
	/**
	 * 	 * 멀티콤보 클릭 이벤트  <br>
	 * <b>Example :</b>
	 *
	 * @param comboObj	멀티콤보 오브젝트
	 * @param index		멀티콤보 index
	 * @param code		멀티콤보 code
	 * @return
	 */
	function setMultiCombo(comboObj, index, code) {
	    var idx = parseInt(index);
	    
	    //All인경우
	    if(index == 0) {
	        if(comboObj.GetItemCheck(index)) {           
	           var count = parseInt(comboObj.GetItemCount());
	            for(var i=1 ; i < count ; i++) {    
	                comboObj.SetItemCheck(i,true, null, null, false);
	            }
	        } else {
	            for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
	                comboObj.SetItemCheck(i,false, null, null, false);
	            }
	        }
	    } else {
	   //All 아닌경우
	        var checkCnt=0;
	        var count = parseInt(comboObj.GetItemCount())
	        for(var i = 1 ; i <  count; i++) {
	            if(comboObj.GetItemCheck(i)) {
	                checkCnt++;
	            }
	        }
	        // alert("checkCnt=="+checkCnt+"count=="+count);
	        if(checkCnt == count-1) {
	            // alert("0 checked")
	            comboObj.SetItemCheck(0,true, null, null, false);
	        }else{
	            // alert("0 unchecked")
	            comboObj.SetItemCheck(0,false, null, null, false);
	        }
	    }
	}
	/**
	 * 키보드입력 값이 대문자인 경우 true 아니면 false
	 * @return
	 * @author:김태균
	 * @version:2009.06.16
	 */
	function isAlpha() {
		var keyValue=ComGetEvent("keycode");
		if(keyValue >= 65 && keyValue <= 90){            //대문자
			return true;
        }else{
        	return false;
        }
	}
	/**
	 * 기존 ComKeyOnlyAlphabet(sFlag) 함수기능에서 예외문자 입력가능 기능 추가
	 * @param {string} sFlag 	선택,영문모드, default=""
     *                              영문모드+특수문자+숫자+공백 ("upperchar")
     * @param {string} sSubChar 선택,숫자이외의 부가 글자
     * @returns 없음
     * @author: 황효근
	 */
	function DmtComKeyOnlyAlphabet(sFlag, sSubChar)
    {
        try {
	        var keyValue=ComGetEvent("keycode");
            var bCanNum=false;
            //ComDebug('key  = '+keyValue);
            if (sFlag==undefined || sFlag==null || sFlag.constructor!=String) sFlag="";
            sFlag=sFlag.toLowerCase();
            if(sFlag == 'upperall') {
            	if(keyValue >= 97 && keyValue <= 122){
            		event.keyCode=keyValue + 65 - 97;
            		event.returnValue=true;
            	} 
            	return;
            }else if(sFlag == "upperchar") {
            	if(keyValue >= 97 && keyValue <= 122){
            		event.keyCode=keyValue + 65 - 97;
            		event.returnValue=true;
            	} else if (keyValue >= 33 && keyValue <= 47){//
            		event.returnValue=true;
            	} else if(keyValue >= 48 && keyValue <= 57) {//숫자
            		event.returnValue=true;
            	} else if (keyValue >= 58 && keyValue <= 64){//
            		event.returnValue=true;
            	} else if (keyValue >= 91 && keyValue <= 96){//
            		event.returnValue=true;
            	} else if (keyValue >= 123 && keyValue <= 127){//
            		event.returnValue=true;
            	} 
            	return;
            }
            if (sFlag.length >= 3){
                if (sFlag.substr(sFlag.length-3)=="num") bCanNum=true;
                if (sFlag.length > 5) sFlag=sFlag.substr(0,5);
            }
        	if(keyValue >= 97 && keyValue <= 122){           //소문자
                if (sFlag=="upper") event.keyCode=keyValue + 65 - 97;
                event.returnValue=true;
            } else if(keyValue >= 65 && keyValue <= 90){            //대문자
                if (sFlag=="lower") event.keyCode=keyValue + 97 - 65;
                event.returnValue=true;
            } else if(bCanNum && keyValue >= 48 && keyValue <= 57) {//숫자
                event.returnValue=true;
            } else if(sSubChar != undefined && sSubChar != null && sSubChar.constructor==String && sSubChar.length > 0) {
            	//SubChar가 여러개 설정된 경우 여러개 글자 모두 처리한다.
            	for(var i=0; i<sSubChar.length; i++) {
            		//ComDebug("sSubChar.charAt(" + i + ")=" + sSubChar.charAt(i));
            		if (keyValue == sSubChar.charCodeAt(i)) {
		                event.returnValue=true;
		                return;
            		}
            	}
                event.returnValue=false;
            } else {
                event.returnValue=false;
            }
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
	/**
	 * 여러개의 버튼 스타일을 Enable/Disable 상태로 한다.
	 * @param bEnable	boolean (true:Enable, false:Disable)
	 * @param objs		String (버튼 name)
	 * @return	없음
	 * @author	황효근
	 */
	function DmtComEnableManyBtns(bEnable, objs) {
        try {
            var args=arguments;
            if (args.length < 2) return;
            if(bEnable) {
				for(var i=1; i<args.length; i++) {
					ComBtnEnable(args[i]);
				}
            } else {
				for(var i=1; i<args.length; i++) {
					ComBtnDisable(args[i]);
				}
            }
        } catch(err) { ComFuncErrMsg(err.message); }
	}
	/**
	 * 여러 HTML Object의 Style Sheet ClassName을 지정한다.
	 * @param clsNm
	 * @param objs
	 * @return 없음
	 * @author	황효근
	 */
	function DmtComSetClassManyObjects(clsNm, objs) {
        try {
            var args=arguments;
            if (args.length < 2) return;
            for(var i=1; i<args.length; i++) {
                if (args[i].tagName != undefined) {
                	args[i].className=clsNm;
                }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
     * 입력값이 알파벳인지 여부를 확인한다. sFlag 인자는 다음과 같이 설정한다.<br>
     * sFlag="u" : 문자열이 모두 알파벳 대문자 인지 여부를 확인한다.<br>
     * sFlag="l" : 문자열이 모두 알파벳 소문자 인지 여부를 확인한다.<br>
     * sFlag="n" : 문자열이 알파벳과 숫자로만 구성된지 여부를 확인한다.<br>
     * sFlag="nl": 문자열이 알파벳 소문자과 숫자로만 구성된지 여부를 확인한다.<br>
     * sFlag="nu": 문자열이 알파벳 대문자과 숫자로만 구성된지 여부를 확인한다.<br>
     * sFlag=""  : 문자열이 모두 알파벳인지 여부를 확인한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ret = ComIsAlphabet("abcABC")       // 결과 : true
     *     ret = ComIsAlphabet("abcdef", "l")  // 결과 : true
     *     ret = ComIsAlphabet("ABCDEF", "u")  // 결과 : true
     *     ret = ComIsAlphabet("abc123", "n")  // 결과 : true
     *     ret = ComIsAlphabet("abc123")       // 결과 : false
     *     ret = ComIsAlphabet(txtName)        // 결과 : false
     * </pre>
     * @param {string,object} obj   필수,문자열 또는 HTML태그(Object)
     * @param {string}        sFlag 선택,결과선택인자, default=""
     * @returns bool<br>
     *          true-알파벳일 경우<br>
     *          false-알파벳이 아닐 경우
     * @see #ComIsKorean
     */
    function DMTComIsAlphabet(obj, sFlag) {
        try {
            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var sVal=getArgValue(obj);
            if (sVal=="") return false;
            var re;
            if (sFlag==undefined || sFlag==null) sFlag="";
            switch (sFlag.toLowerCase())
            {
                case "u":   //only upper
                    re=/[^A-Z]/;
                    break;
                case "l":   //only lower
                    re=/[^a-z]/;
                    break;
                case "n":   //alpha number
                    re=/[^a-z|A-Z|0-9|]/;
                    break;
                case "nl":   //alpha number
                    re=/[^a-z|0-9|]/;
                    break;
                case "nu":   //alpha number
                    re=/[^A-Z|0-9|]/;
                    break;
                default:    //alphabet
                    re=/[^a-z|A-Z]/;
                    break;
            }
            return !re.test(sVal)
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
     * currency에 따라 금액처리(trunc, round)
     * @param curr_cd
     * @param amt
     * @return tmp_amt
	 * @author	김태균
     */
    function DMTtrimCurrencyAmount(curr_cd, amt) {
    	var prm_cur="";
    	var prm_amt=0.0;
    	var tmp_amt=0.0;
		prm_cur=curr_cd;
		prm_amt=amt;
		if	(	prm_cur == "KRW" || prm_cur == "JPY" ||
				prm_cur == "BEF" || prm_cur == "DJF" ||
				prm_cur == "ESP" || prm_cur == "GRD" ||
				prm_cur == "ITL" || prm_cur == "LAK" ||
				prm_cur == "MGF" || prm_cur == "MRO" ||
				prm_cur == "MXP" || prm_cur == "PTE" ||
				prm_cur == "SDD" || prm_cur == "MXN" ){
			tmp_amt=ComTrunc(prm_amt, 0);
		}
		else if( prm_cur == "TWD" || prm_cur == "IDR" || prm_cur == "VND" ) {
			tmp_amt=ComRound(prm_amt, 0);
		}
		else {
		    var tmm_amt2=0.0;
		    tmm_amt2=ComRound(prm_amt, 3);
		    tmp_amt=ComRound(tmm_amt2, 2);
		}
		return tmp_amt;
    }
     /**
      * 요청 데이타에서 포맷 지정.
      * @param data
      * @return ComAddComma2(ComRound(data, 2)+'' ,"#,###.00")
 	  * @author	최성환
      */
	function DmtComSetComma(data){
		return ComAddComma2(ComRound(data, 2)+'' ,"#,###.00");
	}
	/**
	 * Payer Code를 입력시 Payer Name을 조회하는 함수
	 * @param {ibsheet}	sheet_obj
	 * @param {form}	formObj
	 * @param {object}	obj_code
	 * @param {object}	obj_name
	 * @author	김태균
	 */
	function DmtComPayer(sheetObj, formObj, obj_code, obj_name) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(obj_code)));
		if(cust_len == 0){
			ComSetObjValue(obj_code, "");
			ComSetObjValue(obj_name, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_cust_gubun, "");
			return;
		}
		var cre_cnt_cd="";
		if(cust_len > 2) {
			var char_chk=ComGetObjValue(obj_code).substring(0,2);
			//2자리가 영문자이면 CUSTOMER 조회
			if(ComIsAlphabet(char_chk)) {
				ComSetObjValue(formObj.s_cust_gubun, "2");
			//아니면 VENDOR 조회
			}else{
				ComSetObjValue(formObj.s_cust_gubun, "1");
			}
		}else{
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetObjValue(obj_code, "");
			ComSetObjValue(obj_name, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_cust_gubun, "");
			return;
		}
		ComSetObjValue(formObj.f_cmd, "SEARCH20");
		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		var cust_cd=ComGetEtcData(sXml, "PAYER_CODE");
		var cust_nm=ComGetEtcData(sXml, "PAYER_NM");
		var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
		if(cust_nm == null || cust_nm == "") {
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(obj_code, "");
			ComSetObjValue(obj_name, "");
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetFocus(obj_code);
		}else{
			ComSetObjValue(obj_code, cust_cd);
			ComSetObjValue(obj_name, cust_nm);
		}
	    sheetObj.SetWaitImageVisible(1);
	}
	/**
	 * Payer Code를 입력시 Payer Name을 조회하는 함수(입력화면용)
	 * @param {ibsheet}	sheet_obj
	 * @param {form}	formObj
	 * @param {object}	obj_code				PAYER_CODE
	 * @param {object}	obj_name				PAYER_NAME
	 * @param {string} session_cnt_cd			SESSION 국가코드
	 * @param {string} invoice_create_cnt_cd	INVOICE CREATE 국가코드
	 */
	function DmtComPayerModify(sheetObj, formObj, obj_code, obj_name, session_cnt_cd, invoice_create_cnt_cd) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
			var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(obj_code)));
			if(cust_len == 0){
				ComSetObjValue(obj_code, "");
				ComSetObjValue(obj_name, "");
				ComSetObjValue(formObj.s_cust_cd, "");
				ComSetObjValue(formObj.s_cust_gubun, "");
				return;
			}
			var cre_cnt_cd="";
			if(cust_len > 2) {
				//Invoice 생성전
				if(ComGetObjValue(formObj.invoice_issue) == "1" ) {
					cre_cnt_cd=session_cnt_cd;
				//Invoice 생성후
				}else if(ComGetObjValue(formObj.invoice_issue) == "2" ) {
					cre_cnt_cd=invoice_create_cnt_cd;
				}
//				//vendor, customer 조회 가능
//				if(cre_cnt_cd == "CA" || cre_cnt_cd == "US") {
//					var char_chk = ComGetObjValue(obj_code).substring(0,2);
//					//2자리가 영문자이면 CUSTOMER 조회
//					if(ComIsAlphabet(char_chk)) {
//						if(cust_len == 8){
//							ComSetObjValue(formObj.s_cust_gubun, "2");
//						}else{
//							ComShowCodeMessage("DMT00165", "Payer");
//							return;
//						}
//					//아니면 VENDOR 조회
//					}else{
//						if(cust_len == 6){
//							ComSetObjValue(formObj.s_cust_gubun, "1");
//						}else{
//							ComShowCodeMessage("DMT00165", "Payer");
//							return;
//						}
//					}
//				//customer 만 조회 가능
//				}else{
//					//2자리가 영문자이면 CUSTOMER 조회
//					if(ComIsAlphabet(char_chk)) {
//						ComSetObjValue(formObj.s_cust_gubun, "2");
//					//아니면 에러
//					}else{
//						ComShowCodeMessage("DMT00165", "Payer");
//						return;
//					}
//				}
				//2011.02.14 미주지역 체크로직 제외
				//2자리가 영문자이면 CUSTOMER 조회
				if(ComIsAlphabet(char_chk)) {
					ComSetObjValue(formObj.s_cust_gubun, "2");
				//아니면 에러
				}else{
					ComShowCodeMessage("DMT00165", "Payer");
					return;
				}
			}else{
				ComShowCodeMessage("DMT00165", "Payer");
				ComSetObjValue(formObj.s_cust_gubun, "");
				ComSetObjValue(formObj.s_cust_cd, "");
				ComSetObjValue(obj_code, "");
				ComSetObjValue(obj_name, "");
				return;
			}
			ComSetObjValue(formObj.f_cmd, "SEARCH20");
			var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
			var cust_cd=ComGetEtcData(sXml, "PAYER_CODE");
			var cust_nm=ComGetEtcData(sXml, "PAYER_NM");
			var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
			if(cust_nm == null || cust_nm == "") {
				ComSetObjValue(formObj.s_cust_gubun, "");
				ComSetObjValue(formObj.s_cust_cd, "");
				ComSetObjValue(obj_code, "");
				ComSetObjValue(obj_name, "");
				ComShowCodeMessage("DMT00165", "Payer");
				ComSetFocus(obj_code);
			}else{
				ComSetObjValue(obj_code, cust_cd);
				ComSetObjValue(obj_name, cust_nm);
			}
	    sheetObj.SetWaitImageVisible(1);
	}
	
	/**
	 * 로그인 사용자의 Office 에 해당되는 현재 날짜를 조회 합니다.
	 * @param {form}	formObj
	 * @return {string} ofc_curr_day
	 * @author 이성훈
	 */	 
	function DmtComOfficeCurrDate(sheetObj, formObj) {
		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		ComSetObjValue(formObj.f_cmd, SEARCHLIST11);
		// Waiting Image 비활성화
		sheetObj.SetWaitImageVisible(0);
		//2.조회조건으로 조회실행
		var ofcCurrDay=ComSearchEtcData(sheetObj, "DMTCommonFinderGS.do", FormQueryString(formObj), "OFC_CURR_DAY");
		
		// Waiting Image 활성화
		sheetObj.SetWaitImageVisible(1);
		//3.조회결과를 설정해준다.
	    if (ofcCurrDay != undefined && ofcCurrDay != "")
	    	return ComGetMaskedValue(ofcCurrDay, "ymd");
	    else
	    	return ComGetNowInfo();
	}	

	//중복이벤트를 방지하기 위한 변수
	var bMultiComboDupEventFlag = false;
	/**
	 * 멀티콤보의 OnCheckClick 이벤트의 기능을 대신처리해주는 함수
	 * @param {form}	comboObj
	 * @param {int}		index
	 * @param {string}	code
	 * @param {check}	checkObj
	 * @author 이성훈
	 */	 
	function DmtComMultiCombo_OnChange(comboObj, index, code, checkObj) {

		 //중복이벤트일 경우, 로직을 실행하지 않는다.
		 if (bMultiComboDupEventFlag) return;
		 
		 if (typeof(index) != "undefined") {
			 
			 if (checkObj.checked) {
				 
				 var itemChkVal = comboObj.GetItemCheck(index) ? 0 : 1;
				 
				 //콤보에 값을 설정할 때, 중복이벤트가 발생되지 않도록 처리한다.
				 bMultiComboDupEventFlag = true;
				 comboObj.SetItemCheck(index, itemChkVal);
				 bMultiComboDupEventFlag = false;
				 
				 ComShowCodeMessage('DMT00107');
				 return;
			 }
			 
			 if (comboObj.GetText(index, 0) == "All") {
				 ComSetMultiCombo(comboObj, index, code);
			 }
		 }
	}
	
	/**
	 * Status 멀티콤보의 OnCheckClick 이벤트의 기능을 대신처리해주는 함수
	 * @param {object}	comboObj
	 * @param {int}		index
	 * @author 이성훈
	 */	 
	function DmtComMultiComboStatus_OnChange(formObj, comboObj, index) {
		
		//중복이벤트일 경우, 로직을 실행하지 않는다.
		if (bMultiComboDupEventFlag) return;
		
		var itemChk = comboObj.GetItemCheck(0);
		var itemCnt = comboObj.GetItemCount();
		var codes   = comboObj.GetSelectCode();

		if (codes.indexOf('L') != -1 && codes.indexOf('R') != -1) {
			bMultiComboDupEventFlag = true;
			comboObj.SetItemCheck(index, 0);
			bMultiComboDupEventFlag = false;
			
			ComShowCodeMessage('DMT01067');
			return;
		}

		if (index == 0) {
			for (var i = 0; i < itemCnt; i++) {
				//코드값으로 비교를 해야되나, ibsheet 에서 기능지원이 안되어서, 일단, 코드텍스트로 비교함.
				//추후, 기능패치가 완료되면 코드값으로 변경하도록 수정할 예정임. 2014.08.22
				var itemText = comboObj.GetText(i, 0);
				
				if (itemText != 'All Long Staying') {
					bMultiComboDupEventFlag = true;
					comboObj.SetItemCheck(i, itemChk);
					bMultiComboDupEventFlag = false;
				}
				// 전체가 선택된 경우, 'All Long Staying' 이 선택된 경우 선택해제를 해준다.
				else if (itemChk && comboObj.GetItemCheck(i)) {
					bMultiComboDupEventFlag = true;
					comboObj.SetItemCheck(i, false);
					bMultiComboDupEventFlag = false;					
				}
			}
		}
		// All 이외의 항목이 해제된 경우, All 항목도 해제한다.
		else if (itemChk) {
			bMultiComboDupEventFlag = true;
			comboObj.SetItemCheck(0, false);
			bMultiComboDupEventFlag = false;
		}
		// 'R' 이외의 모든값이 선택된 경우, All 항목을 체크한다.
		else if (DmtComIsComboAllCheck(comboObj)) {
			bMultiComboDupEventFlag = true;
			comboObj.SetItemCheck(0, true);
			bMultiComboDupEventFlag = false;
		}

		with (formObj) {
			if (codes == '' || codes == 'R') {
				ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar);
				DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1);
			}
			else if (ComGetObjValue(cond_type) == 'date') {
				ComEnableManyObjects(true, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar);
				DmtComSetClassManyObjects('input1', fm_mvmt_dt1, to_mvmt_dt1);
			}
		}		
	}
	
	/**
	 * 멀티콤보항목중 전체선택과 특정항목 1개를 제외한 이외의 모든 항목이 체크되었을 경우
	 * 전체체크되었다고 반환해주는 함수
	 * @param {object}	comboObj
	 * @return boolean
	 * @author 이성훈
	 */	 	
	function DmtComIsComboAllCheck(comboObj) {
		
		var itemAllCnt   = comboObj.GetItemCount();	// 전체항목 수
		var itemChkCnt   = 0;	// 전체항목에서 선택된 항목 수
		var itemMinusCnt = 0;
		
		for (var i = 0; i < itemAllCnt; i++) {
			var itemText = comboObj.GetText(i, 0);
			
			if (itemText == 'All' || itemText == 'All Long Staying') {
				itemMinusCnt++;
			}
			else if (comboObj.GetItemCheck(i)) {
				itemChkCnt++;
			}
		}
		return itemChkCnt >= (itemAllCnt - itemMinusCnt);
	}
	
	/** 
	 * 영문, 숫자, 키보드 특수문자만 허용
	 * @param value
	 * @return
	 */ 
	function checkSpecialValue(value) {
		var srcCharValue = value; 
		var re_value = srcCharValue; 
		var pattern = /[^(a-zA-Z0-9 `~!@#$%^&*()\[\]\{\}\\_+-=:;\/|<>?\"\'\,\.)]/gi;   // 특수문자 제거 
		if(pattern.test(srcCharValue)){ 
			re_value = srcCharValue.replace(pattern,"");
			ComShowCodeMessage('DMT01169', 'English, number, and special characters in keyboard');
		}
		return re_value; 
	}
	
	/** 
	 * 영문 대문자, 숫자, 키보드 특수문자, 엔터값(\n)만 허용
	 * @param value
	 * @return
	 */ 
	function checkSpecial(value) {
		var srcCharValue = value.toUpperCase(); 
		var re_value = srcCharValue; 
		var pattern = /[^(a-zA-Z0-9 `~!@#$%^&*()\[\]\{\}\\_+-=:;\/|<>?\"\'\,\.\n)]/gi;   // 특수문자 제거 
		if(pattern.test(srcCharValue)){ 
			re_value = srcCharValue.replace(pattern,"");
			ComShowCodeMessage('DMT01169', 'Uppercase english, number, and special characters in keyboard');
		} else {
			re_value = value.toUpperCase();
		}
		return re_value; 
	}