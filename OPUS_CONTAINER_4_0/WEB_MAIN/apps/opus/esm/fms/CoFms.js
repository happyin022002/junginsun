/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoFms.js
*@FileTitle  : FMS 공통 자바스크립트
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	if(msgs == undefined){
		msgs=new Array();
	}
	// FMS 공통
	var gFletCtrtTpCdAll 		= "TI|TO"; //NYK Modify 2014.10.16
	var gFletCtrtTpCdTI 		= "TI"; //NYK Modify 2014.10.16
	var gFletCtrtTpCdTO 		= "TO"; //NYK Modify 2014.10.16
	var gOrderPriorityTO 		= "TO"; //NYK Modify 2014.10.16
	var gOrderPriorityTI 		= "TI"; //NYK Modify 2014.10.16
	
	var gCallSlipTpCdPayment 	= "P";//NYK Modify 2014.10.22
	var gCallSlipTpCdRevenue 	= "R";//NYK Modify 2014.10.22
	
	var gBnkTpCdAll 			= "BOR|BOD"; //NYK Modify 2014.10.22
	var gBnkTpCdBOR 			= "BOR"; //NYK Modify 2014.10.22
	var gBnkTpCdBOD 			= "BOD"; //NYK Modify 2014.10.22 
	
	var gEvidenceClassTaxCode 	= "AP TAX CODE";//NYK Modify 2014.11.11
	var gEvidenceClassTaxE3 	= "E3"; //2014.11.07 NYK Add.
	var gEvidenceClassTaxF0 	= "F0"; //2014.11.07 NYK Add.
	
	var gAcctCdByHire 			= "510911";//2015.11.10
	var gAcctCdByHirePrepayment = "111431";//2015.11.18 T/C Hire Prepayment
	var gAcctCdByCntrOa			= "111071";//2015.11.18 ACCOUNT RECEIVABLE - CONTAINER O/A
	var gAcctCdByBrokerage 		= "512641";//2015.07.31 Brokerage
	var gAcctCdByDebit 			= "110811";//2015.10.13 타사 채권(Other Companies Bond) : 차변 계정(FMS 내부에서만 사용됨) 110811
	var gAcctCdByHireRevenue 	= "411211";//2015.11.10 "954112" > "411211" //2015.10.13 타사 채권(Other Companies Bond) 954112
	var gAcctCdByBunker 		= "411915";////2015.11.10 "954111" > "411915" //2015.10.13 BOD/BOR AcctCd 954111
	
	var gAcctCateCdByTC 		= "TC";//2015.11.19 T/C In hre (510911:Time Charter Hire) - Setup contract Item Account
	var gAcctCateCdByTO 		= "TO";//2015.11.19 T/C Out hre (110811:Time Charter Out Hire) - Setup contract Item Account
	var gAcctCateCdByAD 		= "AD";//2015.11.19 Address Commission (510911:Address Commission) - Setup contract Item Account
	var gAcctCateCdByBR 		= "BR";//2015.11.19 Brokerage (512641:Brokerage) - Setup contract Item Account
	var gAcctCateCdByPR 		= "PR";//2015.11.19 T/C Out hre (111431:T/C Hire Prepayment) - Setup advance payment account of T/C in hire
	
	var gOneYearDay 			= 365;
	
	
	msgs['FMS00002']='Do you want to continue?';
	msgs['FMS00003']='Do you want to delete?';								
	msgs['FMS00004']='{?msg1} is mandatory. Please enter {?msg1}.';
	msgs['FMS00006']='There is no existed {?msg1}.';
	msgs['FMS00007']='There is no contents to save.';
	msgs['FMS00008']='The Same {?msg1} is existed.';
	msgs['FMS00009']='There is contents to {?msg1}';
	msgs['FMS00010']='{?msg1} must be larger than {?msg2}.';
	msgs['FMS00011']='Please input the exact {?msg1}.';
	msgs['FMS00012']='Do you want to delete {?msg1} all?';
	msgs['FMS00013']='{?msg1} must be larger than 0.';
	msgs['FMS00014']='The same range target as{?msg1} size is existed.';
	msgs['FMS00015']='There is no data to print. Please retrieve data.';
	msgs['FMS00016']='As there is no result retrieved, it\'s impossible to download in the [EXCEL] format.';
	msgs['FMS00017']='Do you want to save?';
	msgs['FMS00018']='{?msg1} cannot be larger than {?msg2}.';
	msgs['FMS00019']='There is no data to search';
	msgs['FMS00020']='You can\'t input 0 or Null in {?msg1}.';
	msgs['FMS01138']='Please input 4 digit sequence of number in Vessel Code.';
	msgs['FMS01139']='Please input Invoice Date To.';
	msgs['FMS01140']='Please input Invoice Date From.';
	msgs['FMS01141']='To must be larger than From on Invoice Date.';
	msgs['FMS01142']='Currency Code doesn\'t exist.';
	msgs['FMS01143']='Please input Invoice DT exactly.';
	msgs['FMS01144']='There is no VVD in field.';
	msgs['FMS01230']='Please operate Retrieve first.';
	msgs['FMS01231']='Please input Vessel Code exactly.';
	msgs['FMS01232']='VVD doesn\'t exist.';
	msgs['FMS01233']='There is no existed Location Code.';
	msgs['FMS01234']='Vessel Code doesn\'t exist.';
	msgs['FMS01235']='Please input Del/Re data exactly.';
	msgs['FMS01236']='Year and month in Del/Re data must be same as in Target Month data.';
	msgs['FMS01237']='There is no existed Lane.';
	msgs['FMS01331']='Please input 3 letters at least on Search Keyword.';
	msgs['FMS01333']='Please input 2 letters at least on Search Keyword.';
	msgs['FMS01334']='Failed to retrieve Vendor Code.';
	msgs['FMS01335']='Failed to retrieve Customer Code.';
	msgs['FMS01336']='Failed to retrieve Account Code.';
	msgs['FMS01340']='Item Name on {?msg1} row is duplicated with Item Name on  {?msg2} row.';
	msgs['FMS01506']='Effective Date is mandatory.';
	msgs['FMS01507']='Description is mandatory.';
	msgs['FMS01508']='DR and CR Amount must be same.';
	msgs['FMS01511']='There is no data to print in Credit type CSR.';
	msgs['FMS01565']='Failed to check Effective Date.';
	msgs['FMS01708']='Phase Out Date cannot be larger than From D/dock Date.';
	msgs['FMS01709']='From D/dock Date cannot be larger than To D/dock Date.';
	msgs['FMS01710']='From D/dock Date cannot be smaller than Phase Out Date.';
	msgs['FMS01711']='To D/dock Date cannot be smaller than From D/dock Date.';
	msgs['FMS01712']='To D/dock Date cannot be larger than Phase In Date.';
	msgs['FMS01713']='Phase In Date cannot be smaller than To D/dock Date.';
	msgs['FMS01714']='From Vessel Size cannot be larger than To Vessel Size.';
	msgs['FMS01715']='From Duration cannot be larger than To Duration.';
	msgs['FMS01716']='Maxium duration must be 3 years.';
	msgs['FMS01052']='Please input the Contract No.';
	msgs['FMS01053']='Please input the exact owner code by second digit sequence in engish.';
	msgs['FMS01054']='Please input the Customer Sequence.';
	msgs['FMS01055']='There is no existed Owner Code.';
	msgs['FMS01056']='There is no existed Vessel Code.';
	msgs['FMS01057']='There is no existed Flag Code.';
	msgs['FMS01058']='There is no existed Currency Code.';
	msgs['FMS01059']='Please input the exact \'From / To\' CP period.';
	msgs['FMS01060']='From Date on Payterm tab must be equal or smaller than From Date on the first Hire tab.';
	msgs['FMS01061']='To Date on Payterm tab must be equal or larger than to Date on the last Hire tab.';
	msgs['FMS01062']='From Date on Payterm tab must be equal or smaller than From Date on the first Other Exp tab.';
	msgs['FMS01063']='To Date on Payterm tab must be equal or larger than to Date on the last Other Exp tab.';
	msgs['FMS01064']='It is not permitted to input the duplicated Vessel Code. {?msg1}';
	msgs['FMS01065']='{?msg1} is not valid date-time format. Please input a correct date-time. \n\n Format : YYYY-MM-DD.';
	msgs['FMS01066']='{?msg1} is not valid date-time format. Please input a correct date-time. \n\n Format : YYYY-MM-DD HH24:MI.';
	msgs['FMS01067']='To Date must be equal or Larger than to From Date.';
	msgs['FMS01068']='Please input Vessel Code.';
	msgs['FMS01069']='Please input CP File Upload.';
	msgs['FMS01070']='Please input Certi File Upload.';
	msgs['FMS01071']='Please input From Date.';
	msgs['FMS01072']='Please input To Date.';
	msgs['FMS01073']='Please input Account Code.';
	msgs['FMS01074']='Please select file.';
	msgs['FMS01075']='[setFileUpload] The file path is not correct.';
	msgs['FMS01076']='Do you want to delete?';
	msgs['FMS01077']='Please input 3 digit sequence of alphabet in Currency Code.';
	msgs['FMS01078']='Please input 4 digit sequence of number in Vessel Code.';
	msgs['FMS01079']='Port Code inquiry is failed.';
	msgs['FMS01080']='Please input 1 letter at least in Carrier Name.';
	msgs['FMS01081']='Please input 1 letter at least in Lane Code or Lane Name.';
	msgs['FMS01082']='You can\'t delete Actual.';
	msgs['FMS01083']='Please input \'O/A Reversed Amount\'';
	msgs['FMS01084']='Please input \'O/A Reversed Currency Code\'';
	msgs['FMS01085']='You can choose only 1 Activate item.';
	msgs['FMS01086']='Please input the correct \'From Date\' \n\n Format : YYYY-MM-DD(01/16) 00:00';
	msgs['FMS01087']='Please input the correct \'To Date\' \n\n Format : YYYY-MM-DD(01/16) 00:00';
	msgs['FMS01088']='Date and time must be equal wih From Date.';
	msgs['FMS01089']='Please input Flag Code.';
	msgs['FMS01090']='Agreement';
	msgs['FMS01091']='Please input one or more condition to retrieve.';
	msgs['FMS01092']='There is no existed Carrier Code.';
	msgs['FMS01093']='Start Date cannot be larger than End Date.';
	msgs['FMS01094']='End Date cannot be smaller than Start Date.';
	msgs['FMS01096']='Month term is permitted to enter the date by 28th on month.';
	msgs['FMS01146']='Please input E-mail Address.';
	msgs['FMS01147']='Please input e-mail Address exactly.';
	msgs['FMS01148']='File saving is failed. Please try it again [Row : {?msg1}].';
	msgs['FMS01149']='Data saving is failed due to discrepency of DR and CR. Please try it again.';
	msgs['FMS01150']='Please input Period(To) exactly.';
	msgs['FMS01151']='Please input Period(From) exactly.';
	msgs['FMS01152']='Please input Period((From ~ To) exactly.';
	msgs['FMS01153']='Please select a row.';
	msgs['FMS01154']='Please input Contract No.';
	msgs['FMS01155']='Please input VVD.';
	msgs['FMS01156']='There is no information of Payment Term.';
	msgs['FMS01157']='Please input Duration From exactly.';
	msgs['FMS01158']='Please input Duration To exactly.';
	msgs['FMS01159']='Please input Duration(From ~ To) exactly.';
	msgs['FMS01160']='CSR is already created.';
	msgs['FMS01161']='Address Comm. must be larger than 0.';
	msgs['FMS01162']='Brokerage must be larger than 0.';
	msgs['FMS01163']='Amount must be larger than 0.';
	msgs['FMS01164']='Please input Item Name.';
	msgs['FMS01165']='There is no Payment term.';
	msgs['FMS01166']='There is no information of Hire.';
	msgs['FMS01168']='There is no information of Invoice.';
	msgs['FMS01169']='There is no data to save.';
	msgs['FMS01170']='There is no data to delete.';
	msgs['FMS01171']='Please input data smaller than 0.';
	msgs['FMS01172']='Duration(From) must be equal or larger than {?msg1}.';
	msgs['FMS01173']='Duration(To) must be equal or smaller than {?msg1}.';
	msgs['FMS01174']='Please enter less than one year.';
	msgs['FMS01175']='Duration must be larger than 0.';
	msgs['FMS01177']='Period To Date must be equal or larger than Period From Date.';
	msgs['FMS01178']='Please input Fin Dist.';
	msgs['FMS01179']='Please input Amount.';
	msgs['FMS01180']='Please input INV No.';
	msgs['FMS01181']='There is already existed INV No.';
	msgs['FMS01182']='Please input SDMS Date.';
	msgs['FMS01183']='Please input Hire No.';
	msgs['FMS01184']='Hire No is only premitted to input number.';
	msgs['FMS01185']='There is no registered Hire No.';
	msgs['FMS01188']='Already registered Hire No.';
	msgs['FMS01343']='Do you want to delete all?';
	msgs['FMS01430']='Please input Effective From Date.';
	msgs['FMS01431']='Please input Effective To Date.';
	msgs['FMS01432']='Effective To Date must be equal or larger than Effective From Date.';
	msgs['FMS01433']='Please input CSR From Date.';
	msgs['FMS01434']='Please input CSR To Date.';
	msgs['FMS01435']='CSR To Date must be equal or larger than CSR From Date.';
	msgs['FMS01436']='Please input Effective Date or CSR No.';
	msgs['FMS01437']='CSR No requires at least 3 digit number to input.';
	msgs['FMS01438']='Request Date must be equal or larger than CSR Date.';
	msgs['FMS01439']='Please input Account Code with 6 digit number.';
	msgs['FMS01440']='Please input Center Code with 6 digit number.';
	msgs['FMS01441']='Center Code doesn\'t existed.';
	msgs['FMS01442']='Please input VVD Code with 10 digit number.';
	msgs['FMS01443']='VVD doesn\'t exist.';
	msgs['FMS01444']='Please input Description.';
	msgs['FMS01445']='Please input Prepayments\' data before retrieve.';
	msgs['FMS01446']='Account Code 510911, 111431, 111071 is not available in Prepayment type CSR.';
	msgs['FMS01447']='Owner Code doesn\'t existed.';
	msgs['FMS01448']='Please input the correct Slip Amount except 0.';
	msgs['FMS01449']='Please input Tax item name.';
	msgs['FMS01450']='Please input Tax supply amount.';
	msgs['FMS01451']='Tax supply amount must be larger than 0 (surplus).';
	msgs['FMS01452']='Tax supply amount must be smaller than 0 (deficit).';
	msgs['FMS01453']='Tax Registration Number doesn\'t exist.';
	msgs['FMS01454']='Account Code 111431, 111071 is not available.';
	msgs['FMS01456']='Please input Key Number.';
	msgs['FMS01457']='Please check {?msg1} in VAT Apply box.';
	msgs['FMS01458']='Please input Tax Evidence.';
	msgs['FMS01459']='Tax surplus must be larger than 0 in Slip Amount.';
	msgs['FMS01460']='Tax deficit must be smaller than 0 in Slip Amount.';
	msgs['FMS01462']='Account Code 111071 is not available to use in Prepayment type CSR.';
	msgs['FMS01463']='Account Code 1xxxxx is only available to use one in Prepayment type CSR.';
	msgs['FMS01464']='Account Code 111431 is not available to use one in Standard type CSR.';
	msgs['FMS01465']='Account Code 1xxxxx is not available to use one in Credit Memo CSR.';
	msgs['FMS01466']='Balance Amount must be equal or larger than 0 in Standard type CSR.';
	msgs['FMS01467']='Balance Amount must be smaller than 0 in Credit Memo CSR.';
	msgs['FMS01468']='Tax Statement number must be same as issued date with year and month.';
	msgs['FMS01469']='Please input Tax Inv YYYY-MM.';
	msgs['FMS01470']='Balance Amount must be equal or larger than 0 in Prepayment type CSR.';
	msgs['FMS01471']='Balance Amount must be equal or larger than 0.';
	msgs['FMS01472']='You can only choose the same Customer Code.';
	msgs['FMS01473']='Account Code and VVD level doesn\'t match.';
	msgs['FMS01475']='Currency KRW can be only available to use 111811.';
	msgs['FMS01476']='Currency KRW / JPY / PAB are not available to input a (decimal) point.';
	msgs['FMS01477']='Do you want to create Invoice in Sublet Revenue?';
	msgs['FMS01479']='전자계산서 혹은 종이계산서인지 선택하십시오.';
	msgs['FMS01255']='ENG U E Failed to delete Ship Yard Sequence due to use FMS_NEW_BLD_SKD.';
	msgs['FMS01190']='Is more than 500 Bytes..!!';
	msgs['FMS01191']='Please input Subject.';
	msgs['FMS20000']='Total Amount must be larger than 0';
	msgs['FMS20001']='There is no {?msg1}.';
	msgs['FMS20002']="There is no CSR information to CSR Reject.";
	msgs['FMS20003']="You can make 'Reject CSR' after approval.";
	msgs['FMS20004']="Are you sure to reject it?";
	msgs['FMS20005']="Please click the row that you want to reject.";
	msgs['FMS20006']="Offhire data is duplicated. please check the duration.";
	msgs['FMS20007']="{?msg1} Must be checked or \nOnly One Item is allowed to check.";
	msgs['FMS20008']="{?msg1} data is duplicated.";
	msgs['FMS20009']="[{?msg1}] is closed month.  And it doesn't exist open month after the month.";
	msgs['FMS20010']="The month of Eff. Date [{?msg1}] was closed. \nDo you want to replace the Eff. Date with opened month's 1st date [{?msg2}]?";
    msgs['FMS20011']="Two or more un-closed month exist ! Do you want ignore it ?";
	msgs['FMS20012']="There doesn't exist month {?msg1} in AP_PERIOD.";
	msgs["FMS20013"]="Please input {?msg2} as {?msg1}"; //{?msg1}을(를) {?msg2}(으)로 입력해 주시기 바랍니다
	msgs['FMS20014']='There is no data {?msg1}.';
    /**
     * Type Combo 박스를 만든다 <br>
     * @param {String} 	flag    	FORM/GRID 구분값
     * @param {form} 	formObj    	Form Object
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  cdId   		코드 Id
     * @param {String}  comboCode   코드 값
     * @param {String}  comboText   코드 명칭
     * @param {String}  nullYn   	콤보에 Null이 들어가야 할 경우 'Y'로 넣어줌
     **/
    function CoFmsGetCombo(flag, formObj, sheetObj, cdId, comboCode, comboText, nullYn) {
    	sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value=SEARCH02;
		var param="&cd_id="+cdId+"&com_code="+comboCode
					+"&com_text="+comboText;
 		var sXml=sheetObj.GetSearchData("ESM_FMS_0006GS.do" , FormQueryString(formObj)+param);
		var arrCode=comboCode.split(":");
		var arrText=comboText.split(":");
		var arrLen=arrCode.length;
		if (flag == 'FORM') {//Form
			for (i=0;i<arrCode.length;i++) {
				CoFmsSetMakeCondCombo(formObj, ComGetEtcData(sXml, arrText[i]), ComGetEtcData(sXml, arrCode[i]), arrCode[i], '', nullYn);
			}
		} else {//Grid
			for (i=0;i<arrCode.length;i++) {
				CoFmsSetMakeCombo(sheetObj, ComGetEtcData(sXml, arrText[i]), ComGetEtcData(sXml, arrCode[i]), arrCode[i], '', nullYn);
			}
		}	
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * Tax Type Combo 박스를 만든다 <br>
     * @param {String} 	flag    	FORM/GRID 구분값
     * @param {form} 	formObj    	Form Object
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  cdId   		코드 Id
     * @param {String}  comboCode   코드 값
     * @param {String}  comboText   코드 명칭
     * @param {String}  nullYn   	콤보에 Null이 들어가야 할 경우 'Y'로 넣어줌
     **/
    function CoFmsGetTaxCombo(flag, formObj, sheetObj, cdId, comboCode, comboText, nullYn) {
    	sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value=SEARCH03;
		var param ="&code="+cdId;
		    param +="&com_code="+comboCode;
		    param +="&com_text="+comboText;
 		var sXml=sheetObj.GetSearchData("FMS_COMGS.do" , FormQueryString(formObj)+param);
		var arrCode=comboCode.split(":");
		var arrText=comboText.split(":");
		var arrLen=arrCode.length;
		if (flag == 'FORM') {//Form
			for (i=0;i<arrCode.length;i++) {
				CoFmsSetMakeCondCombo(formObj, ComGetEtcData(sXml, arrText[i]), ComGetEtcData(sXml, arrCode[i]), arrCode[i], '', nullYn);
			}
		} else {//Grid
			for (i=0;i<arrCode.length;i++) {
				CoFmsSetMakeCombo(sheetObj, ComGetEtcData(sXml, arrText[i]), ComGetEtcData(sXml, arrCode[i]), arrCode[i], '', nullYn);
			}
		}	
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * Type Combo 박스를 만든다(업무용) <br>
     * @param {String} 	flag    	FORM/GRID 구분값
     * @param {form} 	formObj    	Form Object
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  cdId   		코드 Id
     * @param {String}  comboCode   코드 값
     * @param {String}  comboText   코드 명칭
     * @param {String}  formCmd     Command 구분값
     * @param {String}  actionUrl   Action Url
     * @param {String}  msgCd   	Message 코드값
     **/
    function CoFmsGetBizCombo(flag, formObj, sheetObj, comboCode, comboText, formCmd, actionUrl, msgCd) {
    	if(formCmd == "1") {
    		formObj.f_cmd.value=SEARCH01;
    	} else if(formCmd == "2") {
    		formObj.f_cmd.value=SEARCH02;
    	} else if(formCmd == "3") {
    		formObj.f_cmd.value=SEARCH03;
    	} else if(formCmd == "4") {
    		formObj.f_cmd.value=SEARCH04;
    	} else if(formCmd == "5") {
    		formObj.f_cmd.value=SEARCH05;
    	} else if(formCmd == "6") {
    		formObj.f_cmd.value=SEARCH06;
    	} else if(formCmd == "7") {
    		formObj.f_cmd.value=SEARCH07;
    	} else if(formCmd == "8") {
    		formObj.f_cmd.value=SEARCH08;
    	} else if(formCmd == "9") {
    		formObj.f_cmd.value=SEARCH09;
    	} else if(formCmd == "10") {
    		formObj.f_cmd.value=SEARCH10;
    	} else if(formCmd == "11") {
    		formObj.f_cmd.value=SEARCH11;
    	} else {
    		formObj.f_cmd.value=SEARCH;
    	}
		var param="&com_code="+comboCode
					+"&com_text="+comboText;
  		var sXml=sheetObj.GetSearchData(actionUrl , FormQueryString(formObj)+param);
		var arrCode=comboCode.split(":");
		var arrText=comboText.split(":");
		var arrLen=arrCode.length;
		if (flag == 'FORM') {//Form
			for (i=0;i<arrCode.length;i++) {
				CoFmsSetMakeCondCombo(formObj, ComGetEtcData(sXml, arrText[i]), ComGetEtcData(sXml, arrCode[i]), arrCode[i], msgCd);
			}
		} else {//Grid
			for (i=0;i<arrCode.length;i++) {
				CoFmsSetMakeCombo(sheetObj, ComGetEtcData(sXml, arrText[i]), ComGetEtcData(sXml, arrCode[i]), arrCode[i], msgCd);
			}
		}	
    }
    /**
     * Search 조건에 있는 Type Combo 박스를 만든다 <br>
     * @param {ibsheet} formObj    	Form Object
     * @param {String}  comboCode   Type 의 코드값
     * @param {String}  comboText   Type 의 명칭
     * @param {String}  col   		column name
     * @param {String}  msgCd   	Message 코드값
     **/
    function CoFmsSetMakeCondCombo(formObj, comboText, comboCode, Col, msgCd, nullYn) {
		if(typeof comboCode != "undefined" && comboCode != "") {
     		var objCombo=eval("document." + formObj.name+"."+Col);
     		var arrcomboCode=comboCode.split("|");
     		var arrcomboText=comboText.split("|");
			if (nullYn == 'Y') {
	     		var objOptionItem=document.createElement("option");
				objOptionItem.text='';
				objOptionItem.value='';
				objCombo.add(objOptionItem, objCombo.length);
			}
			var arrlen=arrcomboCode.length - 1;
     		for (ii=0;ii<arrlen;ii++) {
	     		var objOptionItem=document.createElement("option");
				objOptionItem.text=arrcomboText[ii];
				objOptionItem.value=arrcomboCode[ii];
				objCombo.add(objOptionItem, objCombo.length);
			}
    	} else {
    		if(msgCd != "") {
    			ComShowMessage(ComGetMsg(msgCd));
    		}
    	}
    }
    /**
     * Type Combo 박스를 만든다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboCode   Type 의 코드값
     * @param {String}  comboText   Type 의 명칭
     * @param {String}  col   		column name
     * @param {String}  msgCd   	Message 코드값
     **/
    function CoFmsSetMakeCombo(sheetObj, comboText, comboCode, Col, msgCd, nullYn) {
		if(typeof comboCode != "undefined" && comboCode != "") {
			if (nullYn == 'Y') {
				comboText=' |' + comboText;
				comboCode='|' + comboCode;
			}
        	sheetObj.SetColProperty(Col, {ComboText:'|'+comboText.substring(0 ,comboText.length-1), ComboCode:'|'+comboCode.substring(0,comboCode.length-1)} );
    	} else {
    		if(msgCd != "") {
    			ComShowMessage(ComGetMsg(msgCd));
    		}
    	}
    }
    /**
     * 이벤트 발생시 실행여부 확인 <br>
     * @return {boolean} okYn   메세지 확인창에서 확인버튼 클릭하면 okYn:true 아니면 okYn:false
     **/
    function CoFmsInitConfirm(sheetObj) {
    	var okYn=true;
    	if(sheetObj.IsDataModified()) {
    		var okYn=confirm(ComGetMsg('FMS00002'));
    	}
    	return okYn;
    }
    /**
 	 * 한 화면에 여러개의 Sheet가 있는 경우, SaveString에 prefix를 붙여준다 <br>
 	 * 
 	 * @param {string} sStr 필수, QueryString from IBSheet.GetSaveString().
 	 * @param {string} sPrefix 필수, Prefix.
 	 * @return string 쿼리스트링의 각 name앞에, 주어진 prefix가 붙여진 쿼리스트링.
 	 * @author 최우석
 	 * @version 2009.05.07
 	 */
 	function ComFmsSetPrifix(sStr, sPrefix) {
 		if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
 			return sStr;
 		}
 		var regexp=RegExp(/&/g);
 		sStr=sPrefix + sStr.replace(regexp, "&" + sPrefix);
 		return sStr;
 	}
    /**
	 * 조회한 xml데이터의 MESSAGE를 가져온다.<br>
	 * 
	 * @param {string} sXml 필수
	 * @return xml의 <MESSAGE> Node 값
	 * @author 최우석
	 * @version 2009.05.07
	 */
    function CoFmsShowXmlMessage(sXml) {
		return ComGetSelectSingleNode(sXml, "MESSAGE");
    }
	/**
	 * 특정 소수점 자리에서 반올림을 한다.<br>
	 * 
	 * @param {float} n 필수(금액)
	 * @param {int} digits 필수(반올림 할 자리수)
	 * @return 특정소수점 자리에서 반올림 된 float값
	 * @author 최우석
	 * @version 2009.05.07
	 */ 
	function CoFmsRound(n, digits) {
	    if (digits >= 0) return parseFloat(n.toFixed(digits)); // 소수부 반올림
        digits=Math.pow(10, digits); // 정수부 반올림
        var t=Math.round(n * digits) / digits;
        return parseFloat(t.toFixed(0));
	}
	/**
	 * 폼 개체 안에 모든 컨트롤의 Validation을 확인한다. <br>
	 * 모든 컨트롤이 아닌 특정 하나의 컨트롤을 체크하고자 한다면 {@link #ComChkObjValid} 함수를 이용한다. <br>
	 * bMsg 인자가 true이면 Validation이 정확하지 않은 경우 경고 메시지를 표시한다. <br>
	 * bTrim 인자가 true이면 obj.value 확인 시 값을 trim하여 validation을 확인한다. <br>
	 * bMasked 인자가 true이면 Validation이 정확한 경우 Format에 맞게 Masking 한값을 obj.value에 설정한다. <br>
	 * Validation을 확인하기 위해서는 각 컨트롤 태그에 maxlength속성과 사용자 정의 속성인 required, minlength, caption, dataformat, fullfill, cofield, maxnum, minnum속성을 설정해주어야 한다. 다음과 같이 설정한다. <br>
	 *     &lt;input type="text" name="txtDate" <font color="red">caption="입사일" maxlength="10" dataformat="ymd" required  fullfill maxnum="100" minnum="0" cofield="" </font>&gt; <br>
	 * 위와 같은 속성을 설정함으로써 이 함수는 다음과 같은 처리를 한다. <br>
	 * (1) maxlength  : 입력 최대 길이 확인, UTF-8기준으로 길이를 체크하므로, 한글은 3Byte로 된다.<br>
	 * (2) minlength  : 입력 최소 길이 확인, 값이 있다면 최소 길이만큼 입력해야 한다. <br>
	 * (3) dataformat : 데이타 포멧으로 Validation 확인<br>
	 * <pre>
	 *  - "ymd"      : yyyy-mm-dd
	 *  - "ym"       : yyyy-mm
	 *  - "hms"      : hh:mm:ss
	 *  - "hm"       : hh:mm
	 *  - "saupja"   : ###-##-#####
	 *  - "jumin"    : ######-#######
	 *  - "int"      : #,###
	 *  - "float"    : #,###.###
	 *  - "eng"      : 영문만
	 *  - "engup"    : 영문 대문자만
	 *  - "engdn"    : 영문 소문자만
	 * </pre>
	 * (4) required  : 필수입력 여부 확인, 값이 ""이면 에러 메시지 표시<br>
	 * (5) caption   : EndUser를 위한 메시지 처리를 위한 컨트롤 표시 title<br>
	 * (6) fullfill  : maxlength속성 만큼 글자를 모두 입력해야 하는 경우, 값이 ""이면 체크 안함<br>
	 * (7) pointcount: dataformat="float" 인 경우 소숫점 아랫자리 수<br>
	 * (8) maxnum    : 숫자인 경우 최대값<br>
	 * (9) minnum    : 숫자인 경우 최소값<br>
	 * (10) cofield  : 기간인 경우 시작일과 종료일 html태그에 이 속성을 설정해야 하며, 시작일은 종료일 name을 종료일은 시작일 name을 설정한다. <br>
	 * <br>
	 * &lt;input type="radio"&gt;의 경우 같은 name으로 여러개를 만든다면 첫번째 태그에만 위 속성을 설정해준다. 예를 들어 다음과 같다. <br>
	 *     &lt;input type="radio" name="rdoCity" value="01" required caption="도시"&gt;서울<br>
	 *     &lt;input type="radio" name="rdoCity" value="02"&gt;대전<br>
	 *     &lt;input type="radio" name="rdoCity" value="03"&gt;대구<br>
	 * 위 속성은 필요한것만 골라서 사용한다. 굳이 모든 속성을 다 설정할 필요는 없다. 그러나 속성을 하나라도 추가 한다면 caption속성은 설정해야 메시지 처리에 가독성을 높일수 있다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     if(!ComChkValid(document.frmMaster)) return;   //frmMaster폼안에 모든 오브젝트의 Validation을 확인한다.
	 * </pre>
	 * @param {form}   frm          필수,대상 Form 오브젝트
	 * @param {string} exptElems    선택,제외대상 오브젝트명
	 * @param {bool}   bMsg         선택,각종메시지 표시 여부, default=true
	 * @param {bool}   bTrim        선택,데이터 Trim후 확인할지 여부, default=true
	 * @param {bool}   bMasked      선택,Validation이 정확하면 Format에 맞게 Masking한 값을 obj.value에 설정하지 여부, default=false
	 * @returns bool <br>
	 *          false - Validation이 정확하지 않은 경우<br>
	 *          true  - Validation이 정확한 경우
	 * @see #ComChkObjValid
	 * @see #ComChkRequired
	 */
	function ComFmsChkValid(frm, exptElems, bMsg, bTrim, bMasked){
	    try {
	        var elems=frm.elements;
	        if (bMsg==undefined || bMsg==null)          bMsg=true;
	        if (bTrim==undefined || bTrim==null)        bTrim=true;
	        if (bMasked==undefined || bMasked==null)    bMasked=false;
	        for(var i=0; i < elems.length; i++) {
	            var elem=elems[i];
	            // 제외대상 오브젝트명을 포함하고 있으면  validation체크를 하지 않는다.
	            if(exptElems.indexOf(elem.name) >= 0) {
	            	continue;
	            }
	            //radio인 경우 같은 이름으로 여러개 있는 경우
	            if (elem.type =="radio") {
	                if (elem.name == null || elem.name=="") continue;
	                var elem=document.all[elem.name];
	                //첫번째 radio만 "required"속성이 있는지 체크한다. 나머지 건너뛰기
	                if(elem.length>1) i += (elem.length-1);
	            }
	            //Validation을 체크하여 false가 나오면 종료함
	            if (!ComChkObjValid(elem, bMsg, bTrim, bMasked)) return false;
	        }
	    } catch(err) { ComFuncErrMsg(err.message); }
	    return true;
	}
	/**
	 * 특정 Node의 속성값을 가져온다.
	 * @param {string}	xmlStr
	 * @param {string}	nodeName
	 * @param {string}	attrName
	 * @return
	 */
    function ComFmsGetAttr(xmlStr, nodeName, attrName) {
        if(xmlStr == null  || xmlStr == "" || nodeName == null  || nodeName == "" || attrName == null  || attrName == "") return;
        try {
            var xmlDoc = ComGetXmlDoc(xmlStr);
            if (xmlDoc == null) return;
            var xmlRoot = xmlDoc.documentElement;
            return xmlRoot.getElementsByTagName(nodeName)[0].getAttribute(attrName);
        } catch(err) { ComFuncErrMsg(err.message); }
    }
	/**
     * Row Del 버튼 클릭 시 선택여부 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {string}  saveName    IBSheet SaveName
     * @return {boolean} true:선택, false:미선택
     **/
 	function checkBoxCheckYn(sheetObj, saveName) {
 		var sRow=sheetObj.FindCheckedRow(saveName);
		if(sRow == "") {
			ComShowCodeMessage('COM12189');
			return false;
		} else {
			ComShowCodeMessage('COM12188');
			return true;
		}
 	}
    /**
     * Row Del 버튼 클릭 시 선택여부 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {string}  saveName    IBSheet SaveName
     * @return {boolean} true:선택, false:미선택
     **/
  	function ComFmsCheckBoxCheckYn(sheetObj, saveName) {
  		var sRow=sheetObj.FindCheckedRow(saveName);
 		if(sRow == "") {
 			ComShowCodeMessage('COM12189');
 			return false;
 		} else {
 			ComShowCodeMessage('COM12188');
 			return true;
 		}
  	}
    /**
     * IBSheet XML에서 XML 문자열을 파싱하여 그 안의 파라미터 항목 값을 리턴한다 <br>
     * @param {string} xmlStr    IBSheet를 통해 받아온 xml 문자열
     * @param {string} dataNode  파싱할 항목
     * @return {string} xmlValue
     **/
  	function ComFmsGetXMLData(xmlStr, dataNode) {
  		return ComGetSelectSingleNode (xmlStr, dataNode);
  	}
    /**
     * Currency Code 입력시 금액 입력란 기본 옵션 설정하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {string}  saveName    IBSheet SaveName
     * @param {string}  currCd    	IBSheet 입력한 Currency Code 값
     * @param {String}  prefix   	변수 구분값
     * @param {String}  pointCount  금액 소수점 이하 자리수
     * @return {없음}
     * @author 정윤태
	 * @version 1.0
     **/
  	function ComFmsSetInitCellProperty(sheetObj, row, col, saveName, currCd, prefix, pointCount) {
    	if(ComFmsCheckCurrencyYn(currCd)) {
 			sheetObj.InitCellProperty(row, col,{ Type:"Int",Align:"Right",Format:"NullInteger"} );
		} else {
 			sheetObj.InitCellProperty(row, col,{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:pointCount} );
		}
  	}
    /**
     * Currency Code 가 'KRW or JPY or PAB' 해당되는지 여부 체크 <br>
     * @param {string}  currCd    Currency Code
     * @return {boolean} true:해당, false:해당사항 없음
     * @author 정윤태
	 * @version 1.0
     **/
  	function ComFmsCheckCurrencyYn(currCd) {
    	if(currCd == "KRW" || currCd == "JPY" || currCd == "PAB") {
    		return true;
    	} else {
    		return false;
    	}
  	}
    /**
     * Vo List를 array[array[name]]형태로 변환 
     * @param  {string} xmlStr    IBSheet를 통해 받아온 xml 문자열(SC에서 setRsVoList , setRsVo 호출시)
     * @return {array} rtnArr
     * @author 정윤태
 	 * @version 1.0
     */
    function ComFmsSheetXml2ListMap(xmlStr) {
    	var rtnArr=new Array();
    	if (xmlStr == null || xmlStr == "") {
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
    		var colArr=col.split("|"); //4
    		var sep=dataNode.getAttribute("COLSEPARATOR");
    		var total=dataNode.getAttribute("TOTAL");
    		if (total == 0) {
    			return rtnArr;
    		}
    		var dataChileNodes=dataNode.childNodes;
    		if (dataChileNodes == null) {
    			return rtnArr;
    		}
    		
            var totalAry = new Array();
            var l = 0;
            for(var k=0; k < dataChileNodes.length; k++){
            	if(k%2==1){
            		totalAry[l] = dataChileNodes[k];
            		l++;
            	}
            }
    		
    		for ( var i=0; i < totalAry.length; i++) {
    			/*if (totalAry[i].nodeType != 1) {
    				continue;
    			}*/
    			var arrData=totalAry[i].firstChild.nodeValue.split(sep);
    			var subDataArr=new Array();
    			for ( var j=0; j < arrData.length; j++) {
    				//if(j < 2){
    					subDataArr[colArr[j]]=arrData[j];
    				//}
    			}
    			rtnArr[i]=(subDataArr);
    		}            
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}
    	return rtnArr;
    }
    /**
     * IBSheet XML에서 XML 문자열을 파싱하여 그 안의 Data 항목을 HTML로 변환하여 리턴한다 <br>
     * @param {array} list
     * @param {string} flag : null이 아니면 totalAmt 1개(CHT)용 아니면 2개(PRE, OFF)
     * @return {string} totalAmtHtml
     * @author 정윤태
 	 * @version 1.0
     **/
  	function ComFmsMakeTotalAmtHtml(list, flag) {
  		var totalAmtHtml="";
  		var totalAmount1="";
  		var totalAmount2="";
  		var sDat1="";
		var sDat2="";
		var sBnk1="";
		var sBnk2="";
		var i=0;
		var j=0;
		var k=0;
		for(var m=0; m < list.length; m++) {
			k++;
			var invoiceVO=list[m];
			if(   typeof invoiceVO["curr_cd"] != "undefined"
			   && invoiceVO["curr_cd"] != "") {
				i++;
				sDat1 += "<table>\n";
				sDat1 += "<tr>\n";
				if(flag == "1") {
					sDat1 += "<td><input type='text' style='width:45px;text-align:center;' class='input2' value='"+invoiceVO["curr_cd"]+"' name='curr_inv_cd"+i+"' id='curr_inv_cd"+i+"' readonly>&nbsp;<input type='text' style='width:84px;text-align:right' class='input2' name='"+invoiceVO["curr_cd"].toLowerCase()+"_inv_amt' id='"+invoiceVO["curr_cd"].toLowerCase()+"_inv_amt' value='"+ComTrim(invoiceVO["inv_amt"])+"' readonly></td>\n";
				} else {
					sDat1 += "<td><input type='text' style='width:45px;text-align:center;' class='input2' value='"+invoiceVO["curr_cd"]+"' name='curr_inv_cd"+i+"' id='curr_inv_cd"+i+"' readonly>&nbsp;<input type='text' style='width:94px;text-align:right' class='input2' name='"+invoiceVO["curr_cd"].toLowerCase()+"_inv_amt' id='"+invoiceVO["curr_cd"].toLowerCase()+"_inv_amt' value='"+ComTrim(invoiceVO["inv_amt"])+"' readonly></td>\n";
				}
				sDat1 += "</tr>\n";
				sDat1 += "</table>\n";
			}
			if(flag != "1") {
				if(   typeof invoiceVO["curr_cd2"] != "undefined"
				   && invoiceVO["curr_cd2"] != "") {
					j++;
					sDat2 += "<table>\n";
					sDat2 += "<tr>\n";
					sDat2 += "<td><input type='text' style='width:45px;text-align:center;' class='input2' value='"+invoiceVO["curr_cd2"]+"' name='curr_inv2_cd"+j+"' id='curr_inv2_cd"+j+"' readonly>&nbsp;<input type='text' style='width:94px;text-align:right' class='input2' name='"+invoiceVO["curr_cd2"].toLowerCase()+"_inv_amt2' id='"+invoiceVO["curr_cd2"].toLowerCase()+"_inv_amt2' value='"+ComTrim(invoiceVO["inv_amt2"])+"' readonly></td>\n";
					sDat2 += "</tr>\n";
					sDat2 += "</table>\n";
				}
			}
		}
		for(var n=0; n<(k-i); n++) {
			sBnk1 += "<table>\n";
			sBnk1 += "<tr>\n";
			sBnk1 += "<td>&nbsp;</td>\n";
			sBnk1 += "</tr>\n";
			sBnk1 += "<table>\n";
		}
		if(flag != "1") {
			for(var m=0; m<(k-j); m++) {
				sBnk2 += "<table>\n";
				sBnk2 += "<tr>\n";
				sBnk2 += "<td>&nbsp;</td>\n";
				sBnk2 += "</tr>\n";
				sBnk2 += "<table>\n";
			}
		}
		totalAmount1=sDat1 + sBnk1;
		totalAmount2=sDat2 + sBnk2;
		if(flag != "1") {
			totalAmtHtml=totalAmount1 + "|$$|" + totalAmount2;
		} else {
			totalAmtHtml=totalAmount1;
		}
		return totalAmtHtml;
  	}
    
    //NYK Modify 2014.10.14
    function ComFmsCurrentDate() {
    	 var now=new Date();
         var y=now.getFullYear()+"";
         var M=now.getMonth()+1;
         if (M < 10) M='0'+M+""; else M=M +"";
         
         var d=now.getDate();
         if (d < 10) d='0'+d+""; else d=d +"";

       return ComGetMaskedValue(y+M+d, "ymd","-");
	}  
    
    function ComGetObjAttr(objId, attr){
    	var rtn = "";
    	
		rtn = ComGetObj(objId).attr(attr.toString());
		
    	return rtn;
    }
    
    function ComSetObjAttr(objId, attr, val){
   		ComGetObj(objId).attr(attr.toString(),val);	
    }

    function setToday( obj, format )
    {
    	var today=new Date();
    	var year=today.getFullYear();
    	var month=today.getMonth()+1;
    	if( (''+month).charAt(1) == '' ) month='0' + month;
    	var date=today.getDate();
    	if( (''+date).charAt(1) == '' ) date='0' + date;
    	var hour=today.getHours();
    	if( (''+hour).charAt(1) == '' ) hour='0' + hour;
    	var minute=today.getMinutes();
    	if( (''+minute).charAt(1) == '' ) minute='0' + minute;
    	var sec=today.getSeconds();
    	if( (''+sec).charAt(1) == '' ) sec='0' + sec;
    	var theDay=year
    	switch(format){
    	case "y" : 
    		theDay;
    		break;
    	case "ym" : 
    		theDay += '-' + month;
    		break;
    	case "ymd" :
    		theDay += '-' + month + '-' + date;
    		break;
    	default :
    		theDay += '-' + month + '-' + date;
    	break;
    	}
    	obj.value=theDay;
    	return;  
    }

    function setDateAdd(obj, sFormat, diif){
    	obj.value = getDateAdd(obj, sFormat, diif);
    }

    function getDateAdd(obj, sFormat, diif){
    	var sDate = ComGetDateAdd(null, sFormat, diif);
    	sDate = sDate.replace(/\/|\-|\.|\:|\ /g,"");
    	switch(sFormat){
    		case "Y" :
    			if(sDate.length >= 4){
    				sDate = sDate.substr(0,4)
    				sDate = ComGetMaskedValue(sDate,"yyyy");
    			}else{
    				sDate = "";
    			}
    			break;
    		case "M" :
    			if(sDate.length >= 6){
    				sDate = sDate.substr(0,6)
    				sDate = ComGetMaskedValue(sDate,"ym");
    			}else{
    				sDate = "";
    			}
    			break;
    		case "D" :
    			if(sDate.length >= 8){
    				sDate = sDate.substr(0,8)
    				sDate = ComGetMaskedValue(sDate,"ymd");
    			}else{
    				sDate = "";
    			}
    			break;			
    	}
    	return sDate;
    }   

	/**
	 * 포맷이 없는 value로 넘어 와야 한다.
	 * @param srcCharValue
	 * @param sFormat
	 * @returns {String}
	 */
	function gf_GetDateFormat(obj, sFormat){
		var sVal = String(getArgValue(obj));
		sVal = sVal.replace(/\/|\-|\.|\:|\ /g,"");
		
	    if (ComIsEmpty(sVal)) return "";
	    
		var retValue = "";
		switch(sFormat){
		    	
			case "ymd":		//yyyy-mm-dd 10	            
			case "mdy":		//mm-dd-yyyy 10
				retValue = sVal.substring(0,8);
				break;     	            
		    case "ym":		//yyyy-mm 7
		    case "yw":		//yyyy-mm 7
		    case "hms":     //hh:mm:ss 8
				retValue = sVal.substring(0,6);
				break;     	            
		    case "yyyy":     //yyyy 4   	            
		    case "hm":      //hh:mm 5
				retValue = sVal.substring(0,4);
				break;
		    case "ymdhms":     //yyyy-mm-dd hh:mm:ss 19
				retValue = sVal.substring(0,14);
				break;    	            
		    case "ymdhm":     //yyyy-mm-dd hh:mm 16
				retValue = sVal.substring(0,12);
				break;
			}
	
		retValue = ComGetMaskedValue(retValue,sFormat);
		return retValue;
	}
	
	function FmsRowHideDelete(sheetObj, col, isMsg) {
		if (isMsg==undefined || isMsg==null) isMsg=true;
		var org_col=col;
		col=ComIsNumber(col)?ComParseInt(col):sheetObj.SaveNameCol(col);
		if (col< 0 || col > sheetObj.LastCol()) {
			ComShowMessage("[FmsRowHideDelete] '" + sheetObj.id + "' ['" + org_col + "'] is column not exist.");
			return -1;
		}
		//result : "1|3|5|"
		var sRow=sheetObj.FindCheckedRow(col);
		if (sRow == "") {
			if(isMsg) ComShowCodeMessage("COM12189");
			return 0;
		}
		var arrRow=sRow.split("|"); //result : "1|3|5|"
		sheetObj.RenderSheet(0);//for existing dtAutoSumEx
		if (sheetObj.GetCellProperty(0, col, "Type")== "DelCheck") {
			for (var idx=arrRow.length-1; idx>=0; idx--){
				var row=arrRow[idx];
				sheetObj.SetRowHidden(row,1);
			}
		} else {
			for (var idx=arrRow.length-1; idx>=0; idx--){
				var row=arrRow[idx];
				if (sheetObj.GetRowStatus(row) == "I"){
					sheetObj.RowDelete(row, false);
				}else{
					sheetObj.SetCellValue(row, col,0,0);
					sheetObj.SetRowHidden(row,1);
					sheetObj.SetRowStatus(row,"D");
				}
			}
		}
		sheetObj.RenderSheet(1);
		return arrRow.length-1;
	}	
	
	function FmsRowHideDelete2(sheetObj, col, isMsg) {
		if (isMsg==undefined || isMsg==null) isMsg=true;
		var org_col=col;
		col=ComIsNumber(col)?ComParseInt(col):sheetObj.SaveNameCol(col);
		if (col< 0 || col > sheetObj.LastCol()) {
			ComShowMessage("[FmsRowHideDelete2] '" + sheetObj.id + "' ['" + org_col + "'] is column not exist.");
			return -1;
		}
		//result : "1|3|5|"
		var sRow=sheetObj.FindCheckedRow(col);
		if (sRow == "") {
			if(isMsg) ComShowCodeMessage("COM12189");
			return 0;
		}
		var arrRow=sRow.split("|"); //result : "1|3|5|"
		sheetObj.RenderSheet(0);//for existing dtAutoSumEx
		if (sheetObj.GetCellProperty(0, col, "Type")== "DelCheck") {
			for (var idx=arrRow.length-1; idx>=0; idx--){
				var row=arrRow[idx];
				sheetObj.SetRowHidden(row,1);
			}
		} else {
			for (var idx=arrRow.length-1; idx>=0; idx--){
				var row=arrRow[idx];
				if (sheetObj.GetRowStatus(row) == "I"){
					sheetObj.SetCellValue(row, col,0,0);
					sheetObj.SetRowHidden(row,1);
					sheetObj.SetRowStatus(row,"D");
				}else{
					sheetObj.SetCellValue(row, col,0,0);
					sheetObj.SetRowHidden(row,1);
					sheetObj.SetRowStatus(row,"D");
				}
			}
		}
		sheetObj.RenderSheet(1);
		return arrRow.length-1;
	}	
    
    /**
     * scrollBar를 초기화 한다 <br>
     * @author 정윤태
 	 * @version 1.0
     **/
    try {
    	top.showFlashMenu();
    	top.document.body.scrollTop=0;
    } catch(err) { }
