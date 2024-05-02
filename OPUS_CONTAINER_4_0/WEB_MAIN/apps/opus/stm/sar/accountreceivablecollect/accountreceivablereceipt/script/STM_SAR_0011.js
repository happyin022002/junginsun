/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAR_0011.js
*@FileTitle  : Receipt Deposit Search Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
     	try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
 				case "btn_OK":
 					comPopupOK();
 					break;
 				case "btn_Close":
 					ComClosePopup(); 
 					break;
				case "btns_calendar1":
					var cal=new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.rct_from_dt, 'yyyy-MM-dd');
					break;	
				case "btns_calendar2":
					var cal=new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.rct_to_dt, 'yyyy-MM-dd');
					break;	
				case "btns_cust":
					var cust_cnt_cd=formObj.rct_cust_cnt_cd.value;
					var cust_seq=formObj.rct_cust_seq.value;
					var classId="STM_SAR_9003";
					var param='?cust_cnt_cd='+cust_cnt_cd+'&cust_seq='+cust_seq+'&pop_yn=Y&classId='+classId;
					ComOpenPopup('/opuscntr/STM_SAR_9003.do' + param, 900, 400, 'getSTM_SAR_9003', '0,0', true, false);
					break;	
				case "btns_user":
					var fm_rct_dt=formObj.rct_from_dt.value;
					var to_rct_dt=formObj.rct_to_dt.value;
					var classId="STM_SAR_0014";
					var param='?fm_rct_dt='+fm_rct_dt+'&to_rct_dt='+to_rct_dt+'&pop_yn=Y&classId='+classId;
					ComOpenPopup('/opuscntr/STM_SAR_0014.do' + param, 600, 520, 'getSTM_SAR_0014', '0,0', true, false);
					break;	
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
		}
	}
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * registering IBCombo Object as list
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		document.form.rct_cust_cnt_cd.focus();
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      // sheet1 init
			    with(sheetObj){
		      var HeadTitle1="|Cheque No|Receipt Date|Receipt No|Customer|Customer Name|Office|Receipt Amount|Unidentified|Unapplied|Remark|Created User|Created User Name";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"chq_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rct_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"rct_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rct_cust_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rct_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"rct_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"uniden_amt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"unappl_amt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"rct_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cre_usr_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetColProperty("rct_dt", {Format:"####-##-##"} );
		      SetSheetHeight(300);
		      }
			    break;
		}
	}
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		 comPopupOK();
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH_ASYNC01: 
				//retrieve Local Time
				formObj.f_cmd.value=SEARCH07;
 				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml,"lcl_time");
				formObj.rct_from_dt.value=ComGetMaskedValue(sStr, "ymd");
				formObj.rct_to_dt.value=ComGetMaskedValue(sStr, "ymd");
				//retrieve Currency Code
				formObj.f_cmd.value=SEARCH08;
 				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml,"curr_cd_list");
				var arrStr=sStr.split("|");
				MakeCurrCdComboObject(curr_cd, arrStr);
				break;
			case IBSEARCH_ASYNC02:	//Search Customer Info
				formObj.f_cmd.value=SEARCH06;
				formObj.cust_cnt_cd.value=formObj.rct_cust_cnt_cd.value;
				formObj.cust_seq.value=formObj.rct_cust_seq.value;
 				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				if(SarShowXmlMessage(sXml) != "") {
     				ComShowMessage(SarShowXmlMessage(sXml));
     				ComClearObject(formObj.rct_cust_cnt_cd);
     				ComClearObject(formObj.rct_cust_seq);
     				ComClearObject(formObj.cust_nm);
     				formObj.rct_cust_cnt_cd.focus();
     			}else{
					formObj.cust_nm.value=ComGetEtcData(sXml,"cust_nm");
     			}
				break;
			case IBSEARCH: // RETRIEVE 
				if(validateForm(sheetObj, formObj, sAction)){
					sheetObj.WaitImageVisible=false; 
					ComOpenWait(true);  
					setTimeout( function () { 
						formObj.f_cmd.value=SEARCH;
						formObj.rct_curr_cd.value=curr_cd.GetSelectText();
	 					var sXml=sheetObj.GetSearchData("STM_SAR_0011GS.do", FormQueryString(formObj));
						sheetObj.LoadSearchData(sXml,{Sync:1} );
						ComOpenWait(false);   
				    } , 100);	 	
				}
				break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: //retrieve
				if(ComIsEmpty(formObj.rct_ofc_cd)){
					ComShowCodeMessage("COM130403", "Office");
					return false;
				}
				break;
		}
		return true;
	}
	/**
	 * loading HTML Control event <br>
	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sequence number in sheetObjects array
	 **/
	function initControl() {
		var formObj=document.form;
		axon_event.addListenerForm ('change', 'obj_onchange', formObj);
	}

    /** 
     * handling Keypress event of Object  <br>
     * checking validation of input value by dataformat of object  <br>
     */ 
	function obj_onchange(){
		var formObj=document.form;
		var sheetObject=sheetObjects[0];
		switch(ComGetEvent("name")){
			case "rct_cust_cnt_cd":
				if (formObj.rct_cust_cnt_cd.value == '') {
					formObj.rct_cust_seq.value = "";
					formObj.cust_nm.value = "";
				}
				break;
				
			case "rct_cust_seq":
				if (formObj.rct_cust_cnt_cd.value != '' && formObj.rct_cust_seq.value != '') {
					var valueCustSeq=formObj.rct_cust_seq.value;
					formObj.rct_cust_seq.value=ComLpad(valueCustSeq,6,"0");
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC02);
				} else {
					formObj.cust_nm.value = "";
				}
				break;
		}
	}
	/** 
	 * call method when select event on popup(STM_SAR_9003)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function getSTM_SAR_9003(rowArray) {
		var colArray=rowArray[0];
		var formObj=document.form;
		formObj.rct_cust_cnt_cd.value=colArray[8];
		formObj.rct_cust_seq.value=ComLpad(colArray[9], 6, '0');
		formObj.cust_nm.value=colArray[4];
	}
	/** 
	 * call method when select event on popup(STM_SAR_0014)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function getSTM_SAR_0014(rowArray) {
		var colArray=rowArray[0];
		var formObj=document.form;
		formObj.cre_usr_id.value=colArray[1];
	}
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeCurrCdComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function MakeCurrCdComboObject(cmbObj, arrStr) {
		for (var i=1; i < arrStr.length; i++ ) {
			cmbObj.InsertItem(i-1, arrStr[i], arrStr[i]);			 
		}
		cmbObj.SetDropHeight(190);
	}  
