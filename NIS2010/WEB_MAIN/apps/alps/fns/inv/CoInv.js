/**
===============================================================================
프로그램  명  : INV 공통 자바스크립트
프로그램개요  : INV모듈내 공통 메시지 및 스크립트 함수를 정의한다.
작   성   자  : 
작   성   일  : 2009-05-14
===============================================================================
수정자/수정일 : 2010-01-18
수정사유/내역 : 메세지 추가 (INV00124)
* 2011.01.24 최도순 [CHM-201108418] 베트남지역 ALPS INVOICE 변경 요청
* 2012.03.21 권  민 [CHM-201216481] ONBOARD DATE 적용 개별환율 화주 일괄 업데이트 관련 개발 요청 메세지 추가 (INV00156)
* 2012.07.02 김상현 [선처리] Max interface No. 중복 문제 처리 요청. (INV00158)
=========================================================*/

	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 메시지코드와 각종 메시지 처리 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */
	
	// var msgs = new Array();
	// INV 공통
	msgs['INV00001'] = 'There is no Account Exchange Rate.';
	msgs['INV00002'] = 'There is no Vessel Port Schedule Information.';
	msgs['INV00003'] = 'Invalid B/L No!  Please check B/L No.';								
	msgs['INV00004'] = 'Please check mandatory item.';
	msgs['INV00005'] = 'VVD is invalid!  It doesn\'t exist.';
	msgs['INV00006'] = 'Service scope not existed.';
	msgs['INV00007'] = 'VVD, PORT are invalid!  It\'s not existed in vessel schedule.';
	msgs['INV00008'] = 'Customer code is invalid!  It doesn\'t exist.';
	msgs['INV00009'] = 'Revenue type  is invalid!';
	msgs['INV00010'] = 'Container count is unmatched.';
	msgs['INV00011'] = 'S/A date doesn\'t existed.';
	msgs['INV00012'] = 'Charge type is invalid!';
	msgs['INV00013'] = 'There are missing items.';								
	msgs['INV00014'] = 'Can not delete this item.';
	msgs['INV00015'] = 'G/L month was closed.  Please check.';
	msgs['INV00016'] = '{?msg1} Exchange rate is invalid! \n It exceeds monthly company ex. Rate by more than 50%. Please check and try again.';
	msgs['INV00017'] = 'B/L No. is duplicated.';
	msgs['INV00018'] = 'There is no records transmitted with that message no.';
	msgs['INV00019'] = 'It\'s not correct for invoice no rule.';
	msgs['INV00020'] = 'The range is incorrect.';
	msgs['INV00021'] = 'INV No. is duplicated.';
	msgs['INV00022'] = 'You can\'t use this Invoice type in combined invoice.(Available Type : FRT, THC, DHF)';
	msgs['INV00023'] = '\'Check Digit\' you entered is wrong.  Please sum up all the figures in exchange  rate again.';								
	msgs['INV00024'] = 'The date you input is out of the range.';
	msgs['INV00025'] = 'Nothing was selected.';
	msgs['INV00026'] = 'Invoice can\'t be issued for that customer.';
	msgs['INV00027'] = 'Incurred amounts are not correct with total amounts.';
	msgs['INV00028'] = 'Do you really want to delete?';
	msgs['INV00029'] = 'The charge is not registered.';
	msgs['INV00030'] = 'It\'s already cancelled.';
	msgs['INV00031'] = 'You don\'t need to save it.  Customer was not changed.';
	msgs['INV00032'] = 'Customer was changed.  Move to next page?';
	msgs['INV00033'] = 'Amount for split wasn\'t inputted.';								
	msgs['INV00034'] = 'Customer is duplicated.';
	msgs['INV00035'] = 'Master Total and Split Total amount should be same.';
	msgs['INV00036'] = 'Split customer is office rep. customer code.';
	msgs['INV00037'] = 'Data applied with exchange rate existed.';
	msgs['INV00038'] = 'Sales office is invalid!';
	msgs['INV00039'] = 'VVD is invalid!';
	msgs['INV00040'] = 'Bank Account is duplicated.';
	msgs['INV00041'] = '{?msg1} is not available.';
	msgs['INV00042'] = 'Please check the period. {?msg1}/{?msg2}';
	msgs['INV00043'] = 'Please check entered Data. Date is out of bounds.';
	msgs['INV00044'] = 'Template Name is duplicated.';
	msgs['INV00045'] = 'Do you want to save this report with new report ID?  Then, Please select \'Yes\'.';
	msgs['INV00046'] = 'You should select template name first. Please click \'Create Template\' button.';
	msgs['INV00047'] = 'Exchange Rate is already existed. Do you really want to update it ? ';
	msgs['INV00048'] = 'For multi cust option, please retrieve first before inputting it.';
	msgs['INV00049'] = 'Data was downloaded successfully. Do you want to open it now ?';
	msgs['INV00050'] = 'Invalid Port!';
	msgs['INV00051'] = 'Data was saved successfully!';
	msgs['INV00052'] = 'Data is duplicated.';
	msgs['INV00053'] = 'Failed to save data. {?msg1}';
	msgs['INV00054'] = 'Invalid Customer!  Please check Customer Code.';
	msgs['INV00055'] = '{?msg1} Good Date must be required.';
	msgs['INV00056'] = '{?msg1} Invalid Container No!';
	msgs['INV00057'] = 'Data was deleted successfully!';
	msgs['INV00058'] = 'New office is same with old office.';
	msgs['INV00059'] = 'Unable to use \'411911\' or \'411915\' or \'957112\' or \'954111\' or \'422011\' or \'710111\' with other account code(except V.A.T.).';
	msgs['INV00060'] = 'It\'s a deleted Customer Code! Please check Customer Code.';
	msgs['INV00061'] = 'Unable to get Charge Account List.';
	msgs['INV00062'] = 'Unable to get Auto B/L No. Please check Office.';
	msgs['INV00063'] = 'Mandatory field is missing. Please enter \'I/F No.\'.';
	msgs['INV00064'] = 'DR amount is unmatched with CR amount. Please check again.';
	msgs['INV00065'] = 'It was transmitted successfully.\n(Successfully Sended E-mail/Fax or Printed Invoice Count : {?msg1})';
	msgs['INV00066'] = 'Failed to send it. Please try again.';
	msgs['INV00067'] = 'There is no data.  Please check key data {?msg1}.';
	msgs['INV00068'] = 'Container No. is duplicated! Please check data.';
	msgs['INV00069'] = 'Data was modified!  Do you want to clear it?';
	msgs['INV00070'] = 'No data created in INV for this B/L No. \nPlease select bound. \n\nFor O/B, Click \'OK\' button.\nFor I/B, Click \'Cancel\'button.';
	msgs['INV00071'] = 'Please input Invoice No.';
	msgs['INV00072'] = 'Please input Charge Information.';
	msgs['INV00073'] = '\'Remark\' field is mandatory.';	
	msgs['INV00074'] = 'Failed to interface dato into ERP. \n Please contact system administrator.';	
	msgs['INV00075'] = 'Can not Find Information of user Office. ';	
	msgs['INV00076'] = 'Tax amount can be adjusted : from -10  to 10.';	
	msgs['INV00077'] = 'Please check Office : You can\'t input Exchange Rate by date.';	
	msgs['INV00078'] = 'The limit of applicable Count : less than 100.';
	msgs['INV00079'] = 'Please check No. of Split : Minimun Count is 2 and Maximun Count is 5.';
	msgs['INV00080'] = 'Split is not allowed for this data. Please check data.';
	msgs['INV00081'] = 'Security amount is not same with credit amount.';
	msgs['INV00082'] = 'Invoice search is available for \'single\' option only. Please check.';
	msgs['INV00083'] = 'Max charge code for 1 invoice is 5.';
	msgs['INV00084'] = 'Amount wasn\'t inputted. Please check.';
	msgs['INV00085'] = 'It is not entered in charge for tax invoice. Please enter it first.';
	msgs['INV00086'] = 'Data was sent into E-Service center successfully!';
	msgs['INV00087'] = 'Failed to send it. (GERP)';
	msgs['INV00088'] = 'Please Check B/L NO. Invalid B/L.';
	msgs['INV00089'] = 'BackEndJob Failed.';
	msgs['INV00090'] = 'Already Read Result File Of BackEndJob.';
	msgs['INV00091'] = 'There is no data to save.';
	msgs['INV00092'] = 'No data for system clear. Please check again.';
	msgs['INV00093'] = 'Manual system clear is successful.';
	msgs['INV00094'] = 'Value beyond the decimal point is not allowed for this currency. Please try again.';
	msgs['INV00095'] = 'There is no data to search.'
	msgs['INV00096'] = 'Please check VVD Exchange Rate or Customer code or Good status of {?msg1}.';
	msgs['INV00097'] = 'There is no data for issue.';
	msgs['INV00098'] = 'There is no Exchange Rate.';
	msgs['INV00099'] = 'Please check E-mail address(Fax number) of {?msg1}.';
    msgs['INV00100'] = 'Customer Option is mandatory for save.';
  	msgs['INV00101'] = 'Please check your Entered Data. \n In \'IV\' type, you can only plus amount!';
    msgs['INV00102'] = 'Please check your Entered Data. \n In \'IC\' type, you can only minus amount!';
    msgs['INV00103'] = 'Amt is larger than BL\'s amt.';
    msgs['INV00104'] = 'Please check E-mail address or Fax no.'	;
    msgs['INV00105'] = 'Please check your Entered Data.\n In \'Rated As\', you can enter plus only!';
   	msgs['INV00106'] = 'WHF only for \'WC\', \'OC\' type. Please check again.';
  	msgs['INV00107'] = 'OTS, DTS only for \'TS\' type. Please check again.' ;
   	msgs['INV00108'] = 'CRC only for \'EQ\' type. Please check again.';
   	msgs['INV00109'] = 'Please Check REV SRC & CHG Type!';
   	msgs['INV00110'] = 'There is no item for new template.';
   	msgs['INV00111'] = 'Process Success.';
  	msgs['INV00112'] = 'Failed to {?msg1}. Please try again.';  		
  	msgs['INV00113'] = 'Save failed due to interface error to invoice system.';  	
  	msgs['INV00114'] = 'This charge code is not allowed in MRI.\nPlease go to correct system and do a necessary action there.';  
  	msgs['INV00115'] = 'Unable to get N.China Agent List.';
  	msgs['INV00116'] = 'Please define S/C or RFA or Customer code.';
  	msgs['INV00117'] = 'Please define VVD or Period.';
  	msgs['INV00118'] = 'Please check your Enterd data. Local charge currency is {?msg1}.';
  	msgs['INV00119'] = 'Can\'t found Revenue VVD or Revenue lane.';
  	msgs['INV00120'] = 'Charge code CFR/JOP/TVA are only allowed for \'TN\' type. Please check again.';
  	msgs['INV00121'] = 'Invalid Local VVD! \'USAC\' + YYMM + \'M\' only for \'EQ\' type.';
  	msgs['INV00122'] = 'Can\'t found effective date. G/L Period is not opend. Please contact  H/O!';
  	msgs['INV00123'] = 'Office rep customer code is not allowed. Please change the customer code.';
  	msgs['INV00124'] = 'You can attach only 1 document in your PC. \nAttached file will be replaced by that one you\'re going to select. Are you sure to go ahead?';
  	msgs['INV00125'] = 'All of the invoices belonging to the period you set will be issued. Are you sure to go ahead?';
  	msgs['INV00126'] = 'Are you sure you want to update this ex. rate?';
  	msgs['INV00127'] = 'You may choose either Charge break-down by S/C (RFA) or relevant items of CNTR Per Charge Type-Vertical Style.';
  	msgs['INV00128'] = 'Please check master item and relevant items.{?msg1}.';
  	msgs['INV00129'] = 'Please input LPO No or selcet NONE';
  	msgs['INV00130'] = 'Please check your Enterd data. Invalid Account code!';
  	msgs['INV00131'] = 'Please check location code(mandatory item). You Should input more one location.';
  	msgs['INV00132'] = 'Can\'t found Sailing Date. Please check Data.';
  	msgs['INV00133'] = 'Location code is invalid!  It doesn\'t exist.';
  	msgs['INV00134'] = 'Currency code is invalid! EUR is available only for local charge.';
  	msgs['INV00135'] = 'You should select wording for this \'send by\'option. Please try again.';
  	msgs['INV00136'] = 'No Vietnamese name for \'{?msg1}\'. \n Please go to \'(Vietnam)Charge names in Vietnamese\' for update';
  	msgs['INV00137'] = 'Can\'t apply \'Charge break-down by S/C (RFA)\' without S/C No or RFA No';
  	msgs['INV00138'] = 'You cannot choose this item with \'Charge break-down by S/C (RFA)\'.';
  	msgs['INV00139'] = 'You cannot choose this item in case \'CNTR Per Charge Type-Vertical Style\' has already been selected.';
  	msgs['INV00140'] = 'TVA cannot be added alone without any related charge.';
  	msgs['INV00141'] = 'There is no \'{?msg1}\' charge. Please go the BKG&DOC to check the charge column of the BL. If you want to continue the invoice issue, please click Yes';
  	msgs['INV00142'] = 'There is no \'{?msg1}\' charge for \'{?msg2}\'. Please go the BKG&DOC to check the charge column of the BL. If you want to continue the invoice issue, please click Yes';
  	msgs['INV00143'] = 'You cannot change the customer code because the invoice amount is zero';
  	msgs['INV00144'] = 'Please input Customer Code or check';
  	msgs['INV00145'] = 'Please input SVAT Reg. No. or check';
  	msgs['INV00146'] = 'Please input the Tax Payer ID in MDM first';
  	msgs['INV00147'] = 'Please input SVAT Reg. No.';
  	msgs['INV00148'] = '{?msg1} was updated successfully';
  	msgs['INV00149'] = 'Please input prefix more than 2 character';
  	msgs['INV00150'] = 'Please check invoice no. The invoice no you input is out of the range';
  	msgs['INV00151'] = 'Please check the credit end date';
  	msgs['INV00152'] = 'This is not a credit account';
  	msgs['INV00153'] = 'Invoice was issued already.\nPlease select \'YES\' if you want to issue again with a new Invoice No';
  	msgs['INV00154'] = 'Invoice for {?msg1} was issued already.\nPlease select \'YES\' if you want to issue again with a new Invoice No';
	msgs['INV00155'] = 'TVA is allowed for AR currency only. \nPlease try again';
	msgs['INV00156'] = 'This customer doesn\'t use its individual exchange rate based on Onboard date.';
	msgs['INV00157'] = 'Order number doesn\'t exist for {?msg1}';
	msgs['INV00158'] = 'New Interface No is created by other clerk during correction items. Please retrieve again.';
	msgs['INV00159'] = 'IVA Rate As is invalid! (VLCSC Available values : 18, 21)';
	msgs['INV00160'] = 'The inputed split no is over than charge count. Please check it.';
	msgs['INV00161'] = 'Unable to split invoice. Please check office.';
	msgs['INV00162'] = 'Invalid rate value. It\'s not allowed other value except 0(zero).';
	msgs['INV00163'] = 'You cannot input VAT charge in MOC creation. \nPlease contact FAR if you want to adjust VAT';
    msgs['INV00164'] = 'There is no location code for this  BL. Please register it at Philips EDI Location Code Entry function first.';
    msgs['INV00165'] = 'Please input the period or choose more options from VVD/Customer/BL No. Otherwise, it will take a long time and might result in system failure.';
    msgs['INV00166'] = 'You have to send paper invoice for the revised amount. ({?msg1}).';
    msgs['INV00167'] = 'Invalid Charge Description!  Please check Charge Description.';
    msgs['INV00168'] = 'Invalid Office Code!  Please check Office Code.';
    msgs['INV00169'] = 'Invalid Charge Code!  Please check Charge Code.';
    msgs['INV00170'] = 'Invalid Charge Name!  Please check Charge Name.';
	msgs['INV00171'] = 'Trunk VVD is invalid!  It doesn\'t exist.';
	msgs['INV00172'] = 'Import Error! It\'s not allowed BL count more than 500. ';
	msgs['INV00173'] = 'Search Option Error!  Please input another option except ALL office.';
	msgs['INV00174'] = 'Search Option Error!  You cannot retrieve sales customer of all offices. It\'s exceed limt of system.';
	msgs['INV00175'] = 'Please input detailed reason(more than 10 characters) for MIC invoice in Description column to save this data';
	msgs['INV00176'] = 'Exchange rates for 3rd currencies have not been updated yet.Please try again after update.({?msg1})';
	msgs['INV00177'] = '{?msg1} is being used as local charge code at {?msg2}. Please select another one for this..';
	msgs['INV00178'] = 'Transfer slip has to be approved by a proper approver following Company procedure.\n(발행된 대체전표는 전표관리절차에 따라 결재 및 처리 바랍니다.)';
    /**
	 * 조회한 xml데이터의 MESSAGE를 가져온다.<br>
	 * 
	 * @param {string} sXml 필수
	 * @return xml의 <MESSAGE> Node 값
	 * @version 2009.09.01
	 */
    function CoInvShowXmlMessage(sXml) {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(sXml);
        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) {
        	return "";
        }
		var messageNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
		if(messageNode == null) {
			return "";
		}
		
		var message = messageNode.text;
		return message;
    }
    	
    /** 
  	 * INVCommonGS.do 에서 off_cd 콤보박스 출력시 사용<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
  	 * @param sheetObj : 그리드객체, formObj : 폼객체, cmbObj : 콤보대상객체, allYn : ALL 추가여부(Y)
  	 * @return 없음
  	 * @see #
  	 * @author 한동훈
  	 * @version 2009.10.19
  	 */
	function ComboObject_OfcCd(sheetObj, formObj, cmbObj, all, select_yn) {
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
		
		var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
		var arrStr = sStr.split("|");
		MakeComboObject_OfcCd(cmbObj, arrStr, all);

		var arrStr2 = arrStr[1].split("^");
		var ar_ofc_cd = arrStr2[3];
		if(select_yn != "N"){
			cmbObj.text = ar_ofc_cd;
		}
        cmbObj.DropHeight = 190;
   	 }
	//INVCommonGS.do 에서 off_cd 콤보박스 출력시 사용(cmbObj : 대상객체, arrStr : 데이타 배열, allYn : ALL 추가여부(Y)
	/** 
  	 * off_cd 콤보박스 출력시 사용-콤보박스 세팅<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
  	 * @param cmbObj : 대상객체, arrStr : 데이타 배열, allYn : ALL 추가여부(Y)
  	 * @return 없음
  	 * @see #
  	 * @author 한동훈
  	 * @version 2009.10.19
  	 */
	function MakeComboObject_OfcCd(cmbObj, arrStr, allYn) {
		cmbObj.RemoveAll(); 
   		for (var i = 1; i < arrStr.length;i++ ) {
   			var arrStr2 = arrStr[i].split("^");
   			var ar_ofc_cd = arrStr2[1];
   			cmbObj.InsertItem(i-1, ar_ofc_cd, ar_ofc_cd);
   		}
   		if(allYn=='Y'){
   		cmbObj.InsertItem(0, "ALL", "ALL");
   		}
   		cmbObj.BackColor = "#CCFFFD";
   	 }
	
	/** 
  	 * off_cd 콤보박스 출력시 사용-콤보박스 세팅<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
  	 * @param cmbObj : 대상객체, arrStr : 데이타 배열, allYn : ALL 추가여부(Y)
  	 * @return 없음
  	 * @see #
  	 * @author 한동훈
  	 * @version 2009.10.19
  	 */
	function MakeComboObject_OfcCd_Re(cmbObj, arrStr, allYn) {
		cmbObj.RemoveAll(); 
   		for (var i = 1; i < arrStr.length;i++ ) {
   			var arrStr2 = arrStr[i].split("^");
   			var ar_ofc_cd = arrStr2[1];
   			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
   		}
   		if(allYn=='Y'){
   		cmbObj.InsertItem(0, "ALL", "ALL^ALL");
   		}
   		cmbObj.BackColor = "#CCFFFD";
   	 }
	
	 //그리드에서  SelectRow/RowCount 보여준다. sheetObj, formObj, gubun(search, delete), delNum:삭제한 갯수
	/** 
  	 * 그리드에서  SelectRow/RowCount 보여준다<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
  	 * @param sheetObj, formObj, gubun(search, delete), delNum:삭제한 갯수
  	 * @return 없음
  	 * @see #
  	 * @author 한동훈
  	 * @version 2009.10.19
  	 */
	 function getCountFormat(sheetObj, formObj, gubun, delNum){
		 var dis_count = "";
		 if(gubun == "search"){
			 formObj.delCount.value = "0";
			dis_count = "["+ sheetObj.SelectRow + " / " + sheetObj.RowCount +"]";
		 }else if(gubun == "delete"){
			var delCount = Number(formObj.delCount.value);
			if(delCount == "") delCount = 0;
			//var selNum = sheetObj.SelectRow-delNum - delCount;
			var selNum = 1;
			var totNum = sheetObj.RowCount-delNum - delCount;
			dis_count = "["+ selNum + " / " + totNum+"]";
			formObj.delCount.value = delNum + delCount;
		 }
		 sheetObj.CountFormat = dis_count;
	 }
    
	 /**
	   * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
	   * IBMultiCombo의 item으로 insert 해준다.ComBkgXml2ComboItem 참조<br>
	   * <b>Example :</b>
	   *
	   * <pre> 
	   * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
	   * var arrData = ComPriXml2ComboItem(xmlStr, combo1, &quot;cd&quot;, &quot;nm&quot;);
	   *
	   * </pre>
	   *
	   * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	   * @param {object} cmbObj 필수, insert하고자 하는 IBMultiCombo Object.
	   * @param {string} codeCol 필수, Combo의 Code컬럼명.
	   * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
	   * @param {boolean} bClear 선택, Combo의 기존 내용을 Clear할지 여부(combo.RemoveAll()). 기본값=true.
	   * @return 없음.
	   * @author 김현화
	   * @version 2011.03.10
	   */	 
	 
	  function ComInvXml2ComboItem(xmlStr, cmbObj, codeCol, textCol, textCol2) {
	      if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
	          return;
	      }
	      if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
	          return;
	      }

	      try {
	          cmbObj.RemoveAll();

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
	              if (colArr[i] == textCol2) {
	                  colListIdx[2] = i;
	              }
	          }

	          for ( var i = 0; i < dataChildNodes.length; i++) {
	              if (dataChildNodes[i].nodeType != 1) {
	                  continue;
	              }
	              var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

	              var item = arrData[colListIdx[0]] + "|" + arrData[colListIdx[1]] + "|" + arrData[colListIdx[2]];
	              cmbObj.InsertItem(i, item, arrData[colListIdx[0]]);
	          }

	      } catch (err) {
	          ComFuncErrMsg(err.message);
	      }
	  }
