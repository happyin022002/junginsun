/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoLse.js
*@FileTitle  : LSE business common js 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
//LSE COMMON MESSAGE Start
	if(msgs == undefined){
		msgs=new Array();
	}
msgs['LSE01005']='Data {?msg1} is duplicated. Please check data again.';
msgs['LSE01006']='Please input Agreement No. !';
msgs['LSE01007']='The Agreement No. is not found !';
msgs['LSE01008']='TP/SZ is duplicated.';
msgs['LSE01009']='Please input Lease Term Code !';
msgs['LSE01010']='Please input Effective Date !';
msgs['LSE01011']='Please input Expire Date !'; 
msgs['LSE01012']='Please input Currency Code !';
msgs['LSE01013']='Please input Reference No.'; 
msgs['LSE01014']='Please input Quantity data.';
msgs['LSE01015']='Please input TP/SZ !'; 
msgs['LSE01018']='Do you want to create Agreement No. New Version() Sequence ?';
msgs['LSE01019']='Lessor doesn\'t exist.';
msgs['LSE01020']='Please input correct effective date(YYYY-MM-DD).';
msgs['LSE01021']='You must input within 300 letters in Remark Column.';
msgs['LSE01024']='You must input within 200 letters in Remark Column.';
msgs['LSE01025']='Please input operation option.';
msgs['LSE01026']='Please input correct expiry date(YYYY-MM-DD).';
msgs['LSE01029']='You can input 4 locations only.';
msgs['LSE01030']='Office Code is duplicated. Please check again.';
msgs['LSE01031']='Duplication occurred in items : Year, Month, Manufacturer, Delivery LOC, TP/SZ, Delivery Month.';
msgs['LSE01033']='Updated data is not found. Please check again.';
msgs['LSE01035']='Invaild User Office !';
msgs['LSE01036']='Please input Plan Year !';
msgs['LSE01037']='Location Code doesn\'t exist.';
msgs['LSE01038']='TP/SZ is not available.';
msgs['LSE01039']='Agreement No. is not available.';
msgs['LSE01040']='You can\'t create new agreement for OW/LP/OL/LT/ST/OF Term.';
msgs['LSE01041']='The plan is not found.';
msgs['LSE01042']='Please select approval mode.';
msgs['LSE01043']='Please input date.';
msgs['LSE01044']='Please input Lessor Code.';
msgs['LSE01045']='Please select a row.';
msgs['LSE01046']='Please input Location Code !';
msgs['LSE01047']='Auth No. is not found !';
msgs['LSE01048']='There is no data to search.';
msgs['LSE01049']='Please input Pick Up Due Date !';
msgs['LSE01050']='Please input Auth No. !';
msgs['LSE01051']='Expire date should be later than effective date !';
msgs['LSE01052']='Please input Contract No. !';
msgs['LSE01055']='Agreement No. is duplicated !';
msgs['LSE01056']='Please input Lease Term !';
msgs['LSE01057']='You can input Long Term Agreement only !';
msgs['LSE01058']='Charge creation of this agreement was already done.\nPlease delete payable charge first !';
msgs['LSE01059']='Location code is duplicated !';
msgs['LSE01060']='No. of Box is duplicated !';
msgs['LSE01061']='There is no Approval Quantity. Please input Approval Quantity.';
msgs['LSE01062']='Create New Version()Sequence ?';
msgs['LSE01063']='Out date is mandantory. Please input Out date !';
msgs['LSE01064']='Please input Container No. !';
msgs['LSE01065']='New Pick up date\' is later than \'old pick up date';
msgs['LSE01066']='Effective Date of new version in agreement must be later than Expire Date of old version.';
msgs['LSE01067']='Activity Date must be input within previous month from now.';
msgs['LSE01068']='Please input OW/LP/OL only.';
msgs['LSE01069']='Year, Month, Manufacturer, Delivery LOC, TP/SZ, Delivery Month are duplicated. Please check again.';
msgs['LSE01070']='Please input mandantory item !';
msgs['LSE01071']='Agreement No. already exists. Please check again !';
msgs['LSE01072']='There is no change of Before & After Agreement !';
msgs['LSE01073']='The quantity is incorrect. Please check again and input correct quantity.';
msgs['LSE01074']='The input container doesn\'t exist. Please check again.';
msgs['LSE01075']='Container No. [for Mis used Request } is duplicated !';
msgs['LSE01077']='Please select Request No. !';
msgs['LSE01080']='The start date should be earlier than the end date !';
msgs['LSE01081']='The end date should be later than the start date !';
msgs['LSE01082']='The start date should be earlier than the end date !';
msgs['LSE01083']='The verification was completed successfully !';
msgs['LSE01084']='Please check \'Verify\'.';
msgs['LSE01085']='Please input Version()No.';
msgs['LSE01086']='The On-Hire Date is unmatched.';
msgs['LSE01087']='The Off-Hire Date is unmatched.';
msgs['LSE01088']='Please input Off-Hire Date !';
msgs['LSE01089']='Please select correct Audit Type !';
msgs['LSE01090']='The period is over a year. Please input period again.';
msgs['LSE01091']='Please check S/N Range and input again.';
msgs['LSE01092']='The container No. is duplicated.';
msgs['LSE01093']='Please input the Reference No.';
msgs['LSE01096']='The contract is not found !';
msgs['LSE01097']='This file is invalid !  Please check Lessor\'s file again.';
msgs['LSE01098']='Please input Cost Month !';
msgs['LSE01099']='User can only delete the calculated charge data. Please check again.';
msgs['LSE01100']='Charge Delete Error ! - Invoice Audit Data';
msgs['LSE01101']='Failed to update Invoice No. !';
msgs['LSE01102']='Failed to audit Invoice No. !';
msgs['LSE01103']='You can insert upto 10 rows.';
msgs['LSE01104']='Please input Invoice No. !';
msgs['LSE01105']='Please input Register No. !';
msgs['LSE01106']='The Off-Hire Yard is mamdatory. Please input Off-Hire yard !';
msgs['LSE01107']='The Off-Hire Due Date is mandantory. Please input Off-Hire Due Date !';
msgs['LSE01108']='Invaild format of Send to E-mail !';
msgs['LSE01109']='The VVD Code is not found. Please check VVD Code again !';
msgs['LSE01110']='You can select the same customer(vendor) code. Please check again.';
msgs['LSE01111']='The Invoice issue date is mandatory. Please input Invoice issue date !';
msgs['LSE01112']='The Invoice due date is mandatory. Please input Invoice due date !';
msgs['LSE01113']='You can select same vendor\'s agreement. Please check vendor code again.';
msgs['LSE01115']='The start(from) date should be earlier than the end(to) date !';
msgs['LSE01116']='Do you want to create Payable Charge ?';
msgs['LSE01117']='Do you want to delete Payable Charge ?';
msgs['LSE01118']='The Off-Hire Due Date should be later than yesterday.';
msgs['LSE01119']='There is no data to audit. Please check again.';
msgs['LSE01120']='Do you want to create Invoice?';
msgs['LSE01121']='The Invoice was created sucessfully.';
msgs['LSE01122']='The Pay Term is mandantory. Please input Pay Term !';
msgs['LSE01123']='The Invoice Receive Date is mandantory. Please input Invoice Receive Date !';
msgs['LSE01124']='Failed to invoke the Back-End Job. Please try again after closing all screens. If same error occures, please contact system help desk.';
msgs['LSE01125']='Back-End Job error took place while processing data. Please try again after closing all screens. If same error occures, please contact system help desk.';
msgs['LSE01126']='REPL Value is mandantory. Please input REPL Value !';
msgs['LSE01127']='Lessor has changed. Do you want to create other Lessor\'s invoice ?';
msgs['LSE01129']='Activity Date[allow {?msg1} Month !]is invalid !';
msgs['LSE01130']='Lessor is invalid. Please check again.';
msgs['LSE01132']='Charge Type is mandantory. Please input Charge Type !';
msgs['LSE01133']='Select Lessor Invoice file !';
msgs['LSE01134']='{?msg1} Complete !';
msgs['LSE01135']='{?msg1} Fail !';
msgs['LSE01136']='You can\'t upload the Invoice again because charge was already created and aduited.';
msgs['LSE01137']='Invalid Plan Year !';
msgs['LSE01138']='Do you want to upload excel file after deleting current data ?';
msgs['LSE01140']='Requested CNTR exists already. [Container No : {?msg1}]';
msgs['LSE01141']='Fail to save ! Agreement TP/SZ not registered.!{?msg1}{?msg2}';
msgs['LSE01142']='Please input Max Depr !';
msgs['LSE01143']='Please input URL !';
msgs['LSE01144']='Please input Depr Level !';
msgs['LSE01145']='Please input Depr !';
msgs['LSE01146']='User can\'t input over a year. Please input period again.';
msgs['LSE01147']='User can input 10,000 units as serial range. Please input 10,000 units again.';
msgs['LSE01148']='User can\'t confirm due to limitation of DOL.Please check DOL again.';
msgs['LSE01152']='The DOL in SCC is NIL or Over. Do you want to confirm Off-Hiring?';
msgs['LSE01153']='Exchange rate is invalid. \n It exceeds monthly company ex. Rate is more than 50%. Please check and try again.'
msgs['LSE01154']='Please input Customer Country Code !'
msgs['LSE01155']='Please input Customer No. !'
msgs['LSE01156']='Do you want to save data?'
msgs['LSE01157']='There is no selected marking. Please check again.\n';
msgs['LSE01158']='Do you want to delete ?\n';
msgs['LSE01159']='TP/SZ is incorrect. \nPlease check TP/SZ again.\n';
msgs['LSE01160']='Please input Vessel Port !';
msgs['LSE01161']='Please input Vessel Lane !';
msgs['LSE01162']='Activity date should be same or later than current date.';
msgs['LSE01163']='You must input within 1,000 containers in data column.';
msgs['LSE01164']='Please save data before modification.';
msgs['LSE01165']='TP/SZ, Level, Place are duplicated. Please check again.';
msgs['LSE01166']='Please save data before Invoice Creation.'

msgs['LSE10003']='The selected row was deleted sucessfully !';
msgs['LSE10004']='Version()Up Complete !';
/* OLD VERSION. 확인요청 */
msgs['LSE01078']='Insert Start Date !';
msgs['LSE01079']='Insert End Date !';
msgs['LSE01131']='Please check the Issue Date {?msg1} vs AR Closing Month !';
msgs['LSE10001']='Save Complete !';
msgs['LSE10002']='Update Complete !';
msgs['LSE10007']='[Only {?msg1} Term]Invaild Lease Term !';
msgs['LSE10008']='Please input Build Down Date.';
msgs['LSE10009']='Please confirm payable amount first !';
msgs['LSE10010']='{?msg1} can\'t be processed since it is in Total Loss !';
msgs['LSE10011']='{?msg1} can\'t be processed since it is in Disposal !';
msgs['LSE10012']='Some Total Loss and Disposal containers exist or activity date is invalid. \nPlease check again.';
msgs['LSE10013']='Please input {?msg1} !';
msgs['LSE10014']='Before registering DPP, please save this Lease Agreement first !';
msgs['LSE10015']='{?msg1} can\'t be processed since activity date is invalid!';
msgs['LSE10016']='Please input Tax ratio from 0 to 100.';
msgs['LSE10017']='Pick Up Due Date should fall between AGMT\'s Effective Date.';
msgs['LSE10018']='Activity Date should fall between AGMT\'s Effective Date.';
msgs['LSE10019']='Please input Tax amount from 0 to {?msg1}.';
msgs['LSE10020']= 'The Invoice already exists. Please change to new Invoice No.';
msgs['LSE10021']= 'Please input Payment Type.';
msgs['LSE10022']= 'If you want to delete all rows, please use Delete function.';
msgs['LSE10023']= 'Please select Lessor that belongs to LP/OL.';
msgs['LSE10024']= 'Selected invoice\'s currency does not match. Please select invoice again. ';
msgs['LSE10025']= 'Tax Amount has exceeded Per-Diem Amount. \n Please check again. ';
msgs['LSE10026']= '{?msg1}';
msgs['LSE10027']= 'Invoice No. doesn\'t exist. Please check again.';
msgs['LSE10028']= 'Agreement No. doesn\'t exist. Please check again.';
msgs['LSE10029']= 'Among checked invoices, total {?msg1} invoice\'s payable amount is 0. \nPlease check related invoice again.';
msgs['LSE10030']= 'Please register place where Off hire Flags are checked. ';
msgs['LSE10031']= 'Type doesn\'t match with Lease Term. Please check again.';
msgs['LSE10032']= 'Please check Place again.';
msgs['LSE10033']= 'Lease term doesn\'t match with Auth No.\'s lease term.\n Please check again.';
msgs['LSE10034']= 'User can only retrieve lease terms for MI and MO.\nPlease check again.';
msgs['LSE10035']= 'Term doesn\'t match with Auth No.\'s lease term.\n Please check again.';
msgs['LSE10036']= 'Current Yard and Off-Hire Yard should be same. \nPlease check again.';
msgs['LSE10037']= 'Monthly Charge Creation is processing.  Please wait until the processing is completed';

/* NEW VERSION. 확인요청 */
//msgs['LSE01078'] = 'Please input {?msg1} (YYYY-MM-DD).';
//msgs['LSE01079'] = 'Please input {?msg1} (YYYY-MM-DD).';
//msgs['LSE01131'] = 'Please check the issue date and AR Closing date and Input correct Data.';
//msgs['LSE10001'] = '{?msg1} was saved sucessfully !';
//msgs['LSE10002'] = '{?msg1} was updated successfully !';
//msgs['LSE10007'] = 'You can select MO Term for Mis used out Container Only.';
/* 미사용중인 메세지 주석처리(2009.12.14) */
//msgs['LSE01016'] = 'New Effective Date must be greater than old one.';
//msgs['LSE01017'] = 'Effective Date of new version in agreement must be later than Expire Date of old version.';
//msgs['LSE01022'] = 'Load 하는 파일이 현재의 Column Head 가 맞지 않을 경우 에러 메시지를 보낸다.';
//msgs['LSE01023'] = 'File format for upload is incorrect.  Please check file format again.';
//msgs['LSE01027'] = 'Please input cost month and lease term.';
//msgs['LSE01028'] = '5번의 Check box 가 하나도 Check 되어 있지 않으면 Check 하라는 메시지를 보낸다';
//msgs['LSE01032'] = 'You should input all mandatory items:  Year, AGMT No., Delivery LOC, TP/SZ, & Delivery Month.';
//msgs['LSE01034'] = 'The same data has been already created.';
//msgs['LSE01053'] = 'Lump Sum Rate Delete and DPP Rate Insert?';
//msgs['LSE01054'] = 'DPP Delete and Lump Sum Rate  Insert?';
//msgs['LSE01076'] = 'Failed to save {?msg1}. {?msg2} already exists.';
//msgs['LSE01094'] = 'The Invoice already exist. Please change new invoice No.';
//msgs['LSE01095'] = 'The created Invoice already exist !';
//msgs['LSE01114'] = 'The Charge Creation Data doesn\'t exist. Do you want to create \'Charge Creation\' again ?';
//LSE COMMON MESSAGE End
//LSE COMMON FUNCUTION
/* Sheet Select Back Color */
var LSE_SELECT_BACK_COLOR="#99FFFF";
/* Sheet Total Column Back Color */
var LSE_TOTCOL_BACK_COLOR="#EFEBEF";
/* Sheet Mandatory Header Font Color */
var LSE_MANDATORY_FONT_COLOR="#3333CC";
/* Go OPUS CNTR Main Body Page */
var LSE_INIT_BODY_PAGE="/opuscntr/body.htm";
/**
 * IBMulti Combo Item Setting
 * param : comboObj ==> Combo Object
 * param : arrStrNm ==> Combo Item Text Array
 * param : arrStrCd ==> Combo Item Code Array
 */
function LseComMakeComboObject(comboObj, arrStrText, arrStrCode) {
	var itemCnt=comboObj.GetItemCount();
	for ( var i=0 ; i < arrStrCode.length ; i++ ) {
		comboObj.InsertItem((i+itemCnt), arrStrText[i], arrStrCode[i]);
	}
}
/**
 * IBMulti Combo Item Setting
 * Combo Item의 Text와 Code를 Delimeter로 split하여 그 배열로 Combo Item 생성
 * param : comboObj ==> Combo Object
 * param : sTextNm ==> Combo Item Text
 * param : sCodeNm ==> Combo Item Code
 * delim : delim   ==> Combo Item Text/Code Delimeter
 */
function LseComText2ComboItem(comboObj, strText, strCode, delim) {
   var arrStrText=strText.split(delim);
   var arrStrCode=strCode.split(delim);
   LseComMakeComboObject(comboObj, arrStrText, arrStrCode);
}
/**
 * IBMulti Combo Item Setting
 * XML의 ETC Data에 담겨진 Combo Item의 Text와 Code를 Delimeter로 split하여 그 배열로 Combo Item 생성
 * param : sXml     ==> IBSheet 결과 XML
 * param : comboObj ==> Combo Object
 * param : sTextNm  ==> Combo Item Text Name in XML ETC Date
 * param : sCodeNm  ==> Combo Item Code Name in XML ETC Date
 * delim : delim    ==> Combo Item Text/Code Name Delimeter
 */
function LseComXml2ComboItem(sXml, comboObj, sTextNm, sCodeNm, delim) {
	var strText=ComGetEtcData(sXml, sTextNm);
    var strCode=ComGetEtcData(sXml, sCodeNm);
    LseComText2ComboItem(comboObj, strText, strCode, delim);
}
/**
 * IBMulti Combo Item Remove
 * param : comboObj ==> Combo Object
 * param : arrStrCd ==> 제거할 Combo Item Code
 */
function LseComRemoveComboItem(comboObj, strCode, delim) {
	var arrStrCode=strCode.split(delim);
	for ( var i=0 ; i < arrStrCode.length ; i++ ) {
		comboObj.DeleteItem( arrStrCode[i]);
	}
}
/**
 * Button Enable/Disable Setting
 * param : btnNames ==> Button Names
 * param : enable   ==> true : Enable, false : Disable
 */
function LseComBtnControl(bEnable, btnNames) {
	var arrBtnName=btnNames.split("|");
	for ( var i=0 ; i < arrBtnName.length ; i++ ) {
		var btnObj =document.getElementById(arrBtnName[i]);
		ComEnableObject(btnObj ,bEnable);
		
	}
}
/**
 * IBSheet의 GetSearchXml 함수 또는 GetSaveXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 MESSAGE 값을 리턴한다.
 * @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
 * @return  string, MESSAGE의 값
 */
function LseComGetErrMsg(xmlStr){
    if ( xmlStr == null  || xmlStr == "" ) return "";
    return ComGetSelectSingleNode(xmlStr, "MESSAGE");
}

/**
 * Form의 Field들을 Enable/Disable 처리한다.
 * @param bEnable 필수, ture : enable, false : disable
 * @param formObj 필수, Form Object
 * @param expObjs 필수, Enable/Disable 예외필드
 */
function LseComEnableForm(bEnable, formObj, expObjs) {
	var arrInput = formObj.getElementsByTagName("input");

	for (var i=0; i<arrInput.length; i++) {
		if (arrInput[i].name == "") continue;

		if (expObjs.match(arrInput[i].name) == null) {
			ComEnableObject(arrInput[i], bEnable);
		}

		try {
			eval(arrInput[i].name).SetEnable(bEnable);
		} catch (error) {}
/*
		if (eval(arrInput[i].name).multiComboElements) {
			eval(arrInput[i].name).SetEnable(bEnable);
		}
*/
	}

	// Textarea Tag Enable/Disable
	var arrTarea = formObj.getElementsByTagName("textarea");

	for (var i=0; i<arrTarea.length; i++ ) {
		if (expObjs.match(arrTarea[i].name) == null) {
			ComEnableObject(arrTarea[i], bEnable);
		}
	}

	// img Tag Enable/Disable
	var arrBtn = formObj.getElementsByTagName("img");
	for (var i=0; i<arrBtn.length; i++) {
		if (expObjs.match(arrBtn[i].name) == null) {
			if ((arrBtn[i].name).match("btns_")) {
				ComEnableObject(arrBtn[i], bEnable);
			}
		}
	}

	// Button Tag Enable/Disable
	var arrBtn = formObj.getElementsByTagName("button");
	for (var i=0; i<arrBtn.length; i++) {
		if (expObjs.match(arrBtn[i].name) == null) {
			if ((arrBtn[i].name).match("btns_")) {
				ComEnableObject(arrBtn[i], bEnable);
			}
		}
	}

/*
	var arrExpObjs=expObjs.split("|");
//	var formObj.getElementsByTagName("input")

	for (var i=0; i<arrExpObjs.length; i++) {
		if (window[arrExpObjs[i]] == undefined || window[arrExpObjs[i]] == null) {
			var expObj = document.getElementsByName(arrExpObjs[i])[0];
			ComEnableObject(expObj, bEnable);
		} else if (window[arrExpObjs[i]].multiComboElements) {
			eval(arrExpObjs[i]).SetEnable(bEnable);
		}
	}
*/
}
function LseComMndtForm(formObj, mndtObjs) {
	/* Mendantory Field Setting */
	var arrMndtObj=mndtObjs.split("|");
	var mndtObj;
	//var sCss = new Array("mult_combo", "mult_combo1", "mult_combo1_1", "mult_combo2", "mult_combo2_1");
	for ( var i=0 ; i < arrMndtObj.length ; i++ ) {
		var mndtObj=eval('formObj.'+arrMndtObj[i]);
		if ( (mndtObj.id).match("combo") ) {
			eval('mndtObj.className="mult_combo1";');
			//mndtObj.className = "mult_combo1";
		} else {
			eval('mndtObj.readOnly=false;');
			eval('mndtObj.className="input1";');
			//mndtObj.readOnly = false;
			//mndtObj.className = "input1";
		}
	}
}
function LseComMndtForm2(bEnable, formObj, mndtObjs) {
	/* Mendantory Field Setting */
	var arrMndtObj=mndtObjs.split("|");
	var mndtObj;
	for ( var i=0 ; i < arrMndtObj.length ; i++ ) {
		var mndtObj=eval('formObj.'+arrMndtObj[i]);
		if ( arrMndtObj[i].search("combo") > 0 ) {
			if ( bEnable ) {
				//eval('mndtObj.className = "mult_combo1";');
				window[arrMndtObj[i]].SetBackColor("#CCFFFD");
				window[arrMndtObj[i]].SetFontColor("#606060");
			} else {
				//eval('mndtObj.className = "mult_combo";');
				window[arrMndtObj[i]].SetBackColor("#CCFFFD");
				window[arrMndtObj[i]].SetFontColor("#606060");
			}
		} else {
			if ( bEnable ) {
				eval('mndtObj.readOnly=false;');
				eval('mndtObj.className="input1";');
			} else {
				eval('mndtObj.readOnly=false;');
				eval('mndtObj.className="input";');
			}
		}
	}
}

function LseComMndtForm3(bEnable, formObj, mndtObjs) {
	/* Mendantory Field Setting */
	var arrMndtObj=mndtObjs.split("|");
	var mndtObj;
	for ( var i=0 ; i < arrMndtObj.length ; i++ ) {
		var mndtObj=eval('formObj.'+arrMndtObj[i]);
		if ( arrMndtObj[i].search("combo") > 0 ) {
			if ( bEnable ) {
				//eval('mndtObj.className = "mult_combo1";');
				window[arrMndtObj[i]].SetBackColor("#CCFFFD");
				window[arrMndtObj[i]].SetFontColor("#606060");
			} else {
				//eval('mndtObj.className = "mult_combo";');
				window[arrMndtObj[i]].SetBackColor("#CCFFFD");
				window[arrMndtObj[i]].SetFontColor("#606060");
			}
		} else {
			if ( bEnable ) {
				eval('mndtObj.readOnly=false;');
				//eval('mndtObj.className="input1";');
				eval('mndtObj.className="input1";');
			} else {
				eval('mndtObj.readOnly=false;');
				eval('mndtObj.className="input";');
			}
		}
	}
}

function LseComDateDiff(input1, input2, type) {
	var date1=new Date(input1.substr(0,4),input1.substr(4,2)-1,input1.substr(6,2));
	var date2=new Date(input2.substr(0,4),input2.substr(4,2)-1,input2.substr(6,2));
	var interval=date2 - date1;
	var day=1000*60*60*24;
	var month=day*30;
	var year=month*12;
	//document.write("기간 날짜수: "+parseInt(interval/day)+"일><br>기간 개월수: 약 "+parseInt(interval/month)+"개월><br>기간 개년수: 약 "+parseInt(interval/year)+"개년");
	var retVal;
	if ( type == "D" ) {
		retVal=parseInt(interval/day);
	} else if ( type == "M" ) {
		alert(interval/month);
		retVal=parseInt(interval/month);
	} else if ( type == "Y" ) {
		retVal=parseInt(interval/year);
	}
	return retVal;
}
function LseComGetMonthsDateDiff(input1, input2) {
    var sdate=new Date(input1.substr(0,4),input1.substr(4,2)-1,input1.substr(6,2));
    var edate=new Date(input2.substr(0,4),input2.substr(4,2)-1,input2.substr(6,2));
    var sDate=sdate.getDate();
    var count=0;
    while ( Date.parse(edate) >= Date.parse(sdate) ) {
        if ( sdate.getDate() == sDate ) {
          //해당 요일과 같다면...
          count++;
        }
        sdate.setDate(sdate.getDate()+1); //요일을 계속 증가
    }
    return count;
}
/**
 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
 * 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
 * <b>Example :</b>
 *
 * <pre>
 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
 * var arrData = LseXmlString(xmlStr, nm);
 *
 * </pre>
 *
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {string} Text컬럼명.
 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
  * @author 박성수
  * @version 2009.04.22
 */
function LseXmlString(xmlStr, codeCol) {
	var rtnArr=new Array();
	if (xmlStr == null || xmlStr == "") {
		return rtnArr;
	}
	if (codeCol == null || codeCol == "") {
		return rtnArr;
	}
	try {
        var xmlDoc = ComGetXmlDoc(xmlStr);
        if (xmlDoc == null) return;
        var xmlRoot = xmlDoc.documentElement;
        
		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return rtnArr;
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return rtnArr;
		}
		var colListIdx=Array();
		for ( var i=0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0]=i;
			}
		}
		var sCode="";
		for ( var i=0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			sCode += arrData[colListIdx[0]];
			if (i != dataChildNodes.length - 1) {
				sCode += "|";
			}
		}
		rtnArr.push(sCode);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return rtnArr;
}
/**
 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
 * 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
 * <b>Example :</b>
 *
 * <pre>
 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
 * var arrData = LseXmlString(xmlStr, nm);
 *
 * </pre>
 *
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {string} Text컬럼명.
 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
  * @author 박성수
  * @version 2009.04.22
 */
function LseXmlStringOfItmCnt(xmlStr, codeCol, itmcnt) {
	var rtnArr=new Array();
	if (xmlStr == null || xmlStr == "") {
		return rtnArr;
	}
	if (codeCol == null || codeCol == "") {
		return rtnArr;
	}
	try {
        var xmlDoc = ComGetXmlDoc(xmlStr);
        if (xmlDoc == null) return;
        var xmlRoot = xmlDoc.documentElement;
        
		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return rtnArr;
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return rtnArr;
		}
		var colListIdx=Array();
		for ( var i=0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0]=i;
			}
		}
		var sCode="";
		for ( var i=0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			//sCode += arrData[colListIdx[0]];
			//if (i != dataChildNodes.length - 1) {
			//	sCode += "|";
			//}
			if (itmcnt == i){
				sCode=arrData[colListIdx[0]];
			}
		}
		rtnArr.push(sCode);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return rtnArr;
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
     * @param {string}  	saveColName 필수,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
     * @param {bool}    	bRowDel     선택,대상행삭제여부, default=false
     * @return string,Sheet의 데이터를 조회XML로 구성한 문자열
     */
    function LseMakeSearchXml(sheet_objs, saveColName, bRowDel)  {
        try {
            //함수 인자 유효성 확인
             var allXml="";
            var sColSep="^|^";
            var sColOrder="";
            if (saveColName!=undefined && saveColName != null && saveColName!="") {
                sColOrder=" COLORDER='" + saveColName + "' ";
            }
            allXml="<?xml version='1.0'  ?>\n"
                   + "<SHEET>\n"
            allXml += "  <DATA " + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
           var aryTRs=new Array(sheet_objs.length);
           for (var i in sheet_objs) {
                var aryTR=new Array(sheet_objs[i].LastRow()- sheet_objs[i].HeaderRows());
                var aryTD=new Array(sheet_objs[i].LastCol());
                for (ir=sheet_objs[i].HeaderRows(); ir <= sheet_objs[i].LastRow(); ir++) {
                    for (ic=0; ic<= sheet_objs[i].LastCol(); ic++) {
                        //TD-셀의 값을 변수에 저장한다.
                    	aryTD[ic]=String(sheet_objs[i].GetCellValue(ir,ic));
                    }
                    aryTR[ir-sheet_objs[i].HeaderRows()]="    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
                }
                if (bRowDel) sheet_objs[i].RemoveAll();
                aryTRs[i]=aryTR.join("\n");
            }
            allXml += aryTRs.join("\n");
            allXml += "  </DATA>\n"
                   +  "</SHEET>";
            return allXml;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
     /**
      * Effective Date Validation 처리 부분<br>
      */
     function checkEffectiveDate( eff_dt , exp_dt ) {
     	/* Effective Date Validation(eff_dt) */
     	if( ComGetObjValue(eff_dt) == "" ) {
     		ComShowCodeMessage("LSE01010");
     		ComSetFocus(eff_dt);
     		return false;
     	} else if ( !ComIsDate(eff_dt) ) {
     		ComShowCodeMessage("LSE01020");
     		ComSetObjValue(eff_dt,"");
     		ComSetFocus(eff_dt);
     		return false;
     	}
     	/* Effective Date Validation(exp_dt) */
     	if( ComGetObjValue(exp_dt) == "" ) {
     		ComShowCodeMessage("LSE01011");
     		ComSetFocus(exp_dt);
     		return false;
     	} else if ( !ComIsDate(exp_dt) ) {
     		ComShowCodeMessage("LSE01026");
     		ComSetObjValue(exp_dt,"");
     		ComSetFocus(exp_dt);
     		return false;
     	}
     	/* Effective Date Validation(eff_dt < exp_dt) */
     	var vEffDt=ComReplaceStr(ComGetObjValue(eff_dt),"-","");
     	var vExpDt=ComReplaceStr(ComGetObjValue(exp_dt),"-","");
     	if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
     		ComShowCodeMessage("LSE01051");
     		ComSetObjValue(exp_dt,"");
     		ComSetFocus(exp_dt);
     		return false;
     	}
     	return true;
     }
	/**
	 * Effective Date Validation 처리 부분<br>
	 */
	function checkDatePeriod( eff_dt , exp_dt , sFlag ) {
		if ( sFlag == undefined || sFlag == null || sFlag == "" ) {
			sFlag="ymd";
		}
		/* From Date Validation(eff_dt) */
		if( ComGetObjValue(eff_dt) == "" ) {
      		ComShowCodeMessage("LSE01078");
      		ComSetFocus(eff_dt);
      		return false;
      	}
		if ( !ComIsDate(eff_dt, sFlag) ) {
      		ComShowCodeMessage("LSE01080");
      		ComSetObjValue(eff_dt,"");
      		ComSetFocus(eff_dt);
      		return false;
      	}
      	/* To Date Validation(exp_dt) */
      	if( ComGetObjValue(exp_dt) == "" ) {
      		ComShowCodeMessage("LSE01079");
      		ComSetFocus(exp_dt);
      		return false;
      	}
      	if ( !ComIsDate(exp_dt, sFlag) ) {
      		ComShowCodeMessage("LSE01081");
      		ComSetObjValue(exp_dt,"");
      		ComSetFocus(exp_dt);
      		return false;
      	}
      	/* Period Validation(eff_dt < exp_dt) */
  		var vEffDt="";
  		var vExpDt="";
      	switch(sFlag.toLowerCase()) {
      		case "ym":
      			vEffDt=ComReplaceStr(ComGetObjValue(eff_dt),"-","")+"01";
		      	vExpDt=ComReplaceStr(ComGetObjValue(exp_dt),"-","")+"01";
      			break;
      		default:
		      	vEffDt=ComReplaceStr(ComGetObjValue(eff_dt),"-","");
		      	vExpDt=ComReplaceStr(ComGetObjValue(exp_dt),"-","");
		      	break;
      	}
      	if ( ComChkPeriod(vEffDt, vExpDt) < 1 ) {
      		ComShowCodeMessage("LSE01082");
      		ComSetObjValue(exp_dt,"");
      		ComSetFocus(exp_dt);
      		return false;
      	}
      	return true;
	}
	function LseGetAllSaveText(sheetObj, TrimComma, Status, prefix) {
		if (TrimComma==undefined || TrimComma==null) TrimComma=false;
		if (Status==undefined || Status==null) Status="ibflag";
		if (prefix==undefined || prefix==null) prefix="";
		var arrSave=new Array();
		for ( var i=0 ; i <= sheetObj.LastCol(); i++ ) {
			if (arrSave[i] != undefined)
			arrSave[i]=sheetObj.ColSaveName(i);
		}
		var str=sheetObj.GetRangeText(sheetObj.HeaderRows(), 0, sheetObj.LastRow(), sheetObj.LastCol(), "|", "^");
		if ( TrimComma ) str=str.replace(/\,/gi, "");
		var arrStr=str.split("^");
		var len = arrStr == null ? 0 : arrStr.length;
//		for ( var i=0 in arrStr ) {
		for (var i = 0; i < len; i++) {
			var arrCol=arrStr[i].split("|");
			var colLen = arrCol == null ? 0 : arrCol.length;
			for ( var j=0; j < colLen; j++) {
				if ( arrSave[j] == Status ) {
					switch(arrCol[j]) {
						case "INS": arrCol[j]="I"; break;
						case "UPD": arrCol[j]="U"; break;
						case "DEL": arrCol[j]="D"; break;
						default:    arrCol[j]="R"; break;
					}
				}
				arrCol[j]=prefix + arrSave[j]+"="+arrCol[j];
			}
			arrStr[i]=arrCol.join("&");
		}
		return  arrStr.join("&");
	}
	/**
	* IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
	* IBSheet의 Combo에 연결할수 있는 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
	* Return되는 배열의 0번째는 Code문자열, 1번째는 Text문자열이 담겨있다.
	* <b>Example :</b>
	*
	* <pre>
	* var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
	* var arrData = ComXml2ComboString(xmlStr, &quot;cd&quot;, &quot;nm&quot;);
	*
	* </pre>
	*
	* @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	* @param {string} codeCol 필수, Combo의 Code컬럼명.
	* @param {string} textCol 필수, Combo의 Text컬럼명. (구분자 '|')
	* @param {string} separator 선택, 구분자
	* @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
	* @author 김창식
	* @version 
	*/
	function ComLseXml2ComboString(xmlStr, codeCol, textCol, separator) {
		var rtnArr=new Array();
		if (xmlStr == null || xmlStr == "") {
			return "";
		}
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
			return "";
		}
		try {

	          var xmlDoc = ComGetXmlDoc(xmlStr);
	          if (xmlDoc == null) return;
	          var xmlRoot = xmlDoc.documentElement;

			var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return "";
			}
			var col=dataNode.getAttribute("COLORDER");
			var colArr=col.split("|");
			var sep=dataNode.getAttribute("COLSEPARATOR");
			var total=dataNode.getAttribute("TOTAL");
			var dataChildNodes=dataNode.childNodes;
			if (dataChildNodes == null) {
				return "";
			}
			var textColList=textCol.split("|");
			var textIdx=0;
			var colListIdx=Array();
			var textListIdx=Array();
			for ( var i=0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0]=i;
				}
			}
			for(var k=0; k < textColList.length; k++){
				for ( var i=0; i < colArr.length; i++) {
					if (colArr[i] == textColList[k]) {
						textListIdx[textIdx]=i;
						textIdx=textIdx + 1;
					}
				}
			}
			var sCode="";
			var sText="";
			for ( var i=0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
				sCode += arrData[colListIdx[0]];
				for(var m=0; m < textListIdx.length; m++){
					sText += arrData[textListIdx[m]];
					if (m != textListIdx.length - 1) {
						sText += separator;
					}
				}
				if (i != dataChildNodes.length - 1) {
					sCode += "|";
					sText += "|";
				}
			}
			rtnArr.push(sCode);
			rtnArr.push(sText);
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
		return rtnArr;
	}
    /**
    *   jsp에서 페이지 최초 로딩시 아래와 같이 combo를 위한 값을 구성하고 script에서 multi combo에 값을 assign 하고자 할경우
    *   그 값을 파싱해 multi combo에 assign 해준다.
    *   JSP의 Value 예시)
    *    var appOfcCdComboText = "HAMUR  EUROPE REGIONAL HEADQUARTERS|NYCNA  AMERICA REGIONAL HEADQUARTERS|SAOBB San Paulo Branch Office|SELSKM  KEY ACCOUNT GROUP|SELSTA    Trans-pacific Trade Group|SELSTE    European Trade Group|SELSTI Intra-Asia Trade Group|SHAAS    ASIA REGIONAL HEADQUARTERS";
    *    var appOfcCdComboValue = "HAMUR|NYCNA|SAOBB|SELSKM|SELSTA|SELSTE|SELSTI|SHAAS";
    *
    *    var profitViewComboText = "Trade Profit|Office Profit";
    *    var profitViewComboValue = "P|R";
    *  사용 예시
    * <pre>
    *    ComPriTextCode2ComboItem(appOfcCdComboValue,appOfcCdComboText, formObj.frm_svc_scp_cd ,"|","\t" );
    *    ComPriTextCode2ComboItem(profitViewComboValue,profitViewComboText, formObj.prop_apro_ofc_cd);
    * </pre>
    *
    * @param {string} codeStr MultiCombo에 assign될 rowSeparator(아래 예제에서는 '|')로 구분된 Code String
    *                 <BR> 예) "HAMUR|NYCNA|SAOBB|SELSKM|SELSTA|SELSTE|SELSTI|SHAAS";
    * @param {string} textStr MultiCombo에 assign될 rowSeparator과 colSeparator로 구분된 Text String
    *                 <BR> combo를 다중컬럼으로 보여줄경우 colSeparator로 구분해서 값을 구성한다.
    *                 <BR> 예) 1. 하나의 컬럼일경우 textStr값
    *                            "Trade Profit|Office Profit";
    *                 <BR>     2. 다중컬럼으로 구성했을경우 textStr값
    *                 <BR>       이때의 rowSeparator는 '|'이되고 colSeparator는 '\t"가 된다.
    *                              "HAMUR    EUROPE REGIONAL HEADQUARTERS|NYCNA  AMERICA REGIONAL HEADQUARTERS|SAOBB San Paulo Branch Office|SELSKM  KEY ACCOUNT GROUP|SELSTA    Trans-pacific Trade Group|SELSTE    European Trade Group|SELSTI Intra-Asia Trade Group|SHAAS    ASIA REGIONAL HEADQUARTERS";
    *
    * @param {object} cmbObj 해당 ComboObject
    * @param (stirng) rowSeparator code,text에서 공통으로 쓰이는 구분자로 combo의 row를 구분하는 구분자 default : '|'
    * @param (stirng) colSeparator combo의 text에서만 사용하는 구분자로 다중컬럼을 보여줄때 각 컬럼의 값을 구분하는 구분자다 default : '\t'
    * @param (stirng) showCellIdx  textStr의 값은 colSeparator로 구분된 여러 값이 들어 있으나 다중컬럼으로 보여주지 않고
    *                 <BR>  showCellIdx번째 cell을 보여주고자 할때 사용한다., 0부터 시작,  default : 넘어온 textStr의 컬럼 갯수만큼 컬럼을 보여줌
    * @author 송민석
    * @version 2009.08.14
    */
   function ComLseTextCode2ComboItem(codeStr,textStr, cmbObj,rowSeparator,colSeparator,showCellIdx ){
       if( rowSeparator  == undefined ){
           rowSeparator="|"
       }
       if( colSeparator  == undefined ){
           colSeparator="\t"
       }
       var isSplit=true;
       var isShowSpclCol=false;
       var arrCode=codeStr.split(rowSeparator);
       var arrText=textStr.split(rowSeparator);
       if( colSeparator == "|"){
           isSplit=false;
       }
       if( showCellIdx != undefined && ( ComIsNumber(showCellIdx) ||  showCellIdx == "0")
               && showCellIdx < (arrText[0].split(colSeparator)).length ){
           isShowSpclCol=true;
       }
       for(var idx=0;idx < arrCode.length; idx++ ){
           var text=arrText[idx];
           var code=arrCode[idx];
           //특정 Text값을 보여준다.
           if( isShowSpclCol ){
               text=text.split(colSeparator)[showCellIdx];
               code=code.split(colSeparator)[showCellIdx];
           }else if( isSplit ){
                   text=text.replace(colSeparator,"|");
                   code=code.replace(colSeparator,"|");
           }
             cmbObj.InsertItem(-1, code+"|"+text, arrCode[idx]);
       }
   }
   /**
    * ComboObjects Array에서 Object ID로 Combo Object를 가져온다.<br>
    * <b>Example :</b>
    * <pre>
    * comboObj = getComboObject(comboObjects, "combo1");
    * </pre>
    *
    * @param {array} comboObjs 필수 ComboObject 배열
    * @param {string} objId 필수 해당 ComboObject의 id
    * @return {object} comboObject 해당 ComboObject
    * @author 문동규
    * @version 2009.07.17
    */
   function getComboObject(comboObjs, objId) {
       if (comboObjs != null) {
           for (var i=0, n=comboObjs.length ; i < n ; i++) {
               if (comboObjs[i].options.id == objId) {
                   return comboObjs[i];
               }
           }
       }
       return null;
   }   
   
   /**
    * 멀티선택 팝업호출
    * 
    * @param {window.event.srcElement.getAttribute("name")}
    *            값을 넘겨 받을 input 명
    * @author 박명신
    * @version 2009.05.27
    * @see #ees_lse_0005.js
    * 
    * 1) 부모 js에서 getLse_Multi 구현 샘플 function getLse_Multi(rowArray,return_val) {
    * var formObj = document.form; var tempText = ""; //초기화 eval("document.form." +
    * return_val + ".value = '';"); for(var i=0; i<rowArray.length; i++) {
    * tempText += rowArray[i] + ','; } //마지막에 ,를 없애기 위함 if (tempText != "")
    * tempText = tempText.substr(0, tempText.length -1);
    * 
    * eval("document.form." + return_val + ".value = '" + tempText + "';"); } 2)
    * DAO에서 ,넘어온 값을 처리 샘플 List<String> tpszCds = new ArrayList(); String[] arrYdCd =
    * eQFlagListINVO.getEqTpszCd().split(","); for(int i = 0; i < arrYdCd.length; i
    * ++){ tpszCds.add(arrYdCd[i]); } velParam.put("tpszCds", tpszCds);
    * 
    * 3) 쿼리문중 foreach 샘플
    * 
    * #if (${tpszCds} != '') AND A.EQ_TPSZ_CD IN ( #foreach ($user_tpszCds IN
    * ${tpszCds}) #if($velocityCount < $tpszCds.size()) '$user_tpszCds', #else
    * '$user_tpszCds' #end #end ) #end
    */

   function rep_Multiful_inquiry(input_obj) {
   	var formObject = document.form;
   	var cmdt_cd_val = ""; // 향후 사용가능 예정변수
   	var rep_cmdt_cd_val = ""; // 향후 사용가능 예정변수
   	var cmdt_desc_val = ""; // 향후 사용가능 예정변수
   	var classId = "getLse_Multi";
   	var xx1 = input_obj; // CONTI
   	var xx2 = ""; // SUB CONTI
   	var xx3 = ""; // COUNTRY
   	var xx4 = ""; // STATE
   	var xx5 = ""; // CONTROL OFFIC
   	var xx6 = ""; // LOC CODE
   	var xx7 = ""; // LOC NAME
   	var xx8 = "";
   	var xx9 = "";

   	var param = "?returnval=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3
   			+ "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6
   			+ "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
   	ComOpenPopup('EES_LSE_1002.do' + param, 400, 330, 'getLse_Multi',
   			'1,0,1,1,1,1,1,1,1,1,1,1');
   }
   
   /**
    * 반복문으로 생성된 라스트 Delim을 제거 ex) '1,2,3,4,5,' => '1,2,3,4,5'
    * 
    * @param {String}
    *            str 제거 대상 String
    * @return {String} str 제거된 String
    * @author 박명신
    * @version 2009.06.04
    */
   function LseDelLastDelim(str) {
   	// 마지막에 &를 없애기 위함
   	if (str != "") {
   		str = str.substr(0, str.length - 1);
   	}
   	return str;
   }
   
   function leftPad(str, fillChar, length) {
	   if (fillChar.length != 1) {
		   alert('fillChar must be a single character');
		   return "";
		   }

		   if (str.length > length)
		   return str;

		   var returnStr = "";
		   var i;
		   for (i = str.length; i < length; i++) {
		   returnStr = returnStr + fillChar;
		   }

		   returnStr = returnStr + str;

		   return returnStr;	   
   }

   
   function rightPad(str, fillChar, length) {
	   if (fillChar.length != 1) {
		   alert('fillChar must be a single character');
		   return "";
		   }

		   if (str.length > length)
		   return str;

		   var returnStr = str;
		   var i;
		   for (i = str.length; i < length; i++) {
		   returnStr = returnStr + fillChar;
		   }

		   return returnStr;
   }  
   
   function LseMakeRound(num, cnt){
		var powCnt = Math.pow(10, cnt);
		return (Math.round(num*powCnt)/powCnt).toFixed(cnt);
	}
 
   function LseComGetMonthsDateDiffNew(input1, input2) {
		var sdate=new Date(input1.substr(0,4),input1.substr(4,2)-1,"01");
		var edate=new Date(input2.substr(0,4),input2.substr(4,2)-1,"01");
			
		var sDate  = sdate.getDate();
		var count=0;
		while (Date.parse(edate)>=Date.parse(sdate))
		{
		    if(sdate.getDate() == sDate)
		    {
		        count++;
		    }
		    sdate.setDate(sdate.getDate()+1);
		}			
	    return count;
	    
	}   
   
