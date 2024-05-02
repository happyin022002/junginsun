/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2035.js
*@FileTitle  : Payable Invoice Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10 
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cgm_2035 : ees_cgm_2035 business script for
     */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
    var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name <br>
     * @param
     * @return 
     * @author 
     * @version 
     */ 
	function processButtonClick(){
		/***** use additional sheet var in case of more than 2 tap each sheet *****/
		var sheetObject1=sheetObjects[0];
	  	var sheetObject2=sheetObjects[1];         
	  	/*******************************************************/
	  	var formObject=document.form;
	    try {
	    	var srcName=ComGetEvent("name");
	    	if(ComGetBtnDisable(srcName)) return false;
	        switch(srcName) {
	        	case "btn_Retrieve":
	        		if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {	
		        		// retrieve Action
	    				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	        		}
					break;
				case "btn_New":
					initControl();
					break;
				case "btn_Save":
					if(validateForm(sheetObject1,formObject,IBSAVE) != false) {	
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
					}
					break;
				case "btn_Cancel":
					doActionIBSheet(sheetObject1, formObject, IBRESET);
					break;	
				case "btns_office":	// Office Code getting popup
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 510, "ofc_cd:cost_ofc_cd", "1,0,1,1,1,1,1,1", true);
					break;
				case "btns_cost_yrmon":
	    			var cal=new ComCalendar();
					cal.setDisplayType('month');
				    cal.select(formObject.cost_yrmon, "yyyy-MM");	
    				break;
				case "btns_inv_rcv_dt":
					var cal=new ComCalendar();
		    		cal.select(formObject.inv_rcv_dt, "yyyy-MM-dd");
					break;
				case "btns_inv_iss_dt":
					var cal=new ComCalendar();
		    		cal.select(formObject.inv_iss_dt, "yyyy-MM-dd");
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
     * registering IBSheet Object as list <br>
     * @param  {object} sheetObj	
     * @return 
     * @author 
     * @version 
     */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */
	function loadPage() {
		// axon event regist
  //  	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
  //  	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
    	axon_event.addListener('focusout', 'obj_focusout', 'inv_rcv_dt'); 
    	axon_event.addListener('focusout', 'obj_focusout', 'inv_iss_dt'); 
    	axon_event.addListener('focusout', 'obj_focusout', 'cost_yrmon'); 
		for(i=0;i<sheetObjects.length;i++){
	        //
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i+1);
	        //
	        ComEndConfigSheet(sheetObjects[i]);
	    }
		//IBMultiComboreset
		comboObjects[comboCnt++]=vndr_seq;
		comboObjects[comboCnt++]=chss_mgst_inv_sts_cd;
		for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k]);
	    }
		/*
		// Option retrieve
		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC03);
		*/
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		// Control reset
		initControl();
		
		// Set disable button.
//		ComBtnDisable('btn_Save');
//		ComBtnDisable('btn_Cancel');
	}
	
	function firstDayInPreviousMonth(yourDate) {
        var d=new Date(yourDate);
        d.setDate(1);
        d.setMonth(d.getMonth() - 1);
        return d;
    }
	/**
     * init control of form <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */
    function initControl(){
//    	var formObj=document.form;
//    	var d=new Date(); //firstDayInPreviousMonth(new Date());
//    	var y=d.getYear() + 1900; 
//    	var m="";
//    	var mtmp=d.getMonth()+1;
//		if(mtmp<10)	m='0'+mtmp; 
//		else m=''+ mtmp;
//		var costYrmon=y+"-"+m;
//     	formObj.cost_yrmon.value=costYrmon;
    	var formObj=document.form;
    	var d=firstDayInPreviousMonth(new Date()); //firstDayInPreviousMonth(new Date());
    	var y=d.getFullYear(); 
    	var m="";
    	var mtmp=d.getMonth()+1;
		if(mtmp<10)	m='0'+mtmp; 
		else m=''+ mtmp;
		var costYrmon=y+ '-' + m;
    	// COST YMO
    	document.form.cost_yrmon.value=costYrmon;
     	// Multi Combo reset		
		comboObjects[0].SetSelectText("ALL",false);
		comboObjects[0].SetSelectCode("ALL",false);
		comboObjects[1].SetSelectText("ALL",false);
		// Sheet Object reset
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
    	// Cost Office Code retrieve 
    	doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC01);
    	// button disable setting
    	doActionBtnEnable('-1','-1');
    	// S.Provider retrieve
    	doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC02);
        // ALL reset
    	comboObjects[1].SetSelectText("ALL",false);
   }
     /**
      * setting sheet initial values and header <br>
      * adding case as numbers of counting sheets <br>
      * @param  {object} sheetObj		 Sheet Object
      * @param  {int} sheetNo
      * @return 
      * @author 
      * @version 
      */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	switch(sheetID) {
	    	case "sheet1":
	    		with (sheetObj) {

		            var HeadTitle1="|Seq.|CHK|Cost Month|Cost Office|Invoice No.|Net Amount|Tax Div.|Tax|CSR No.|Total Amount|Status||||||||||";
		            var headCount=ComCountHeadTitle(HeadTitle1);
//		            (headCount, 0, 0, true);
	
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		            InitHeaders(headers, info);
	
		            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                   {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                   {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",            KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cost_ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"chg_smry_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_tax_clt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_tax_rt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_smry_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"status",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pay_inv_seq" },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_cre_seq" },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ofc_cty_cd" },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq" },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ver_no" },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chss_mgst_inv_knd_cd" },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chss_mgst_inv_sts_cd" },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"status_cd" },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq" },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"inv_rgst_no" } ];
		             
		            InitColumns(cols);
	
		            SetEditable(1);
		            SetColProperty(0,"inv_tax_clt_tp_cd", {ComboText:"V.A.T|W.H.T", ComboCode:"VAT|WHT"} );
		            SetSheetHeight(170);
				}
				break;
	        case "sheet2":
	            with (sheetObj) {

		            var HeadTitle1="|Agreement No.|EQ No.|Tp/Sz|Charge Type|Cost Code|Account|Currency|Tax|Credit Amount|Amount";
		            var headCount=ComCountHeadTitle(HeadTitle1);
//		            (headCount, 0, 0, true);
	
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		            InitHeaders(headers, info);
	
		            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"pay_tax_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0 },
		                {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"pay_cr_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0 },
		                {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"pay_lse_chg_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0 } ];
		             
		            InitColumns(cols);
	
		            SetEditable(0);
		            SetCountPosition(0);
		            SetSheetHeight(240);
				}
				break;
	        case "sheet3":
	        	with (sheetObj) {
		            var HeadTitle1="";
		            var headCount=ComCountHeadTitle(HeadTitle1);
		            (1, 0, 0, true);
	
		            SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
		            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		            InitHeaders(headers, info);
	
		            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
		             
		            InitColumns(cols);

		            SetEditable(1);
		            SetSheetHeight(202);
				}
        		break;
	        	break;
	    }
	}
    /**
     * handling process for Sheet <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type
     * @return 
     * @author 
     * @version 
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
			case IBSEARCH:      //retrieve
				formObj.f_cmd.value=SEARCH;
				formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml=sheetObj.GetSearchData("EES_CGM_2035GS.do" , FormQueryString(formObj), '', true);
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				sheetObjects[1].RemoveAll();
				ComOpenWait(false);	
				break;
			case IBSEARCH_ASYNC04:	// detail retrieve
				formObj.f_cmd.value=SEARCH01;
				formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml=sheetObj.GetSearchData("EES_CGM_2035GS.do" , FormQueryString(formObj), '', true);
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				ComOpenWait(false);	
				break;
			case IBSAVE:        // Invoice Confirm
				var iCheckRow=sheetObj.CheckedRows("del_chk");
	    		if(iCheckRow > 0){
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);	
					formObj.f_cmd.value=MULTI01;
		     		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
		     		var sParam=sheetObjects[0].GetSaveString(false);
		     		sParam=ComSetPrifix(sParam, "sheet1");
		         	sParam=sParam + "&";
		         	sParam=sParam + FormQueryString(formObj);
		         	var sXml=sheetObj.GetSaveData("EES_CGM_2035GS.do", sParam);
		     		sheetObj.LoadSearchData(sXml,{Sync:0} );
					ComOpenWait(false);	
	    		} else {
	    			ComShowCodeMessage('CGM10008');
	    		}
				break;
			case IBRESET:
				var iCheckRow=sheetObj.CheckedRows("del_chk");
	    		if(iCheckRow > 0){
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI02;
		     		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
		     		var sParam=sheetObjects[0].GetSaveString(false);
		     		sParam=ComSetPrifix(sParam, "sheet1");
		         	sParam=sParam + "&";
		         	sParam=sParam + FormQueryString(formObj);
		         	var sXml=sheetObj.GetSaveData("EES_CGM_2035GS.do", sParam);
		         	sheetObj.LoadSaveData(sXml);
		     		sheetObjects[1].RemoveAll();
		     		ComOpenWait(false);		     		
	    		} else {
	    			ComShowCodeMessage('CGM10008');
	    		}
				break;
			case IBSEARCH_ASYNC01:	// Cost Office Code retrieve
				formObj.f_cmd.value=SEARCH18;
				var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				var sOfcCd=ComGetEtcData(sXml,"ofc_cd");
				document.form.cost_ofc_cd.value=sOfcCd;
				break;
			case IBSEARCH_ASYNC02:	// S.Provider retrieve
				formObj.f_cmd.value=SEARCH19;
				formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
				var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				vndr_seq.RemoveAll();
	     	  	if(ComGetTotalRows(sXml) > 0 ){
	     	  		var cols=ComCgmXml2ComboString(sXml, "code1", "desc1");
	     	  		ComCgmMakeMultiCombo(vndr_seq, cols[0], cols[1], 1);
	     	  	}
				break;
			case IBSEARCH_ASYNC03:	// Option retrieve 
				formObj.f_cmd.value=SEARCH;
				formObj.intg_cd_id.value=COM_CD_TYPE_CD02355;
				var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				var sStr=ComGetEtcData(sXml,"comboList");    			
	    		var arrStr=sStr.split("@");
	    		// combo control, result string, Text Index, Code Index
	   			MakeComboObject(chss_mgst_inv_sts_cd, arrStr, 1, 0);
	   			break;
			case IBSEARCH_ASYNC05:	// Local Time retrieve
				formObj.f_cmd.value=SEARCH20;
 				var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				var sLocalDate=ComGetEtcData(sXml,"local_date");
				document.form.local_date.value=sLocalDate;
				break;
			case  IBSEARCH_ASYNC06:	// Pay Term info retrieve
				formObj.f_cmd.value=SEARCH07;
         		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
        		var genPayTermCd=ComGetEtcData(sXml,"gen_pay_term_cd");
        		document.form.gen_pay_term_cd.value=genPayTermCd;
        		break;
        	case IBCLEAR:
        		var idx=0
        		var sXml2=document.form2.sXml.value;
        		var arrXml=sXml2.split("|$$|");
        		//Option
        		if ( arrXml[idx] == null ) {return;}
        		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
        	    var arrStr1=new Array();
        	    var vListData=new Array();
        	    var j = 0;
        		for ( var i=0; i < vArrayListData.length; i++) {
        		    vListData=vArrayListData[i];
//        		    console.log(vArrayListData[i]);
        		    //arrStr1[i]=vArrayListData[i]["code1"] + "|" + vArrayListData[i]["desc1"];
        		    if (vListData != undefined && vListData != null) {
        		    	arrStr1[j++] = vListData['code1'] + "|" + vListData["desc1"];
        		    }
        		}
        		MakeComboObject(chss_mgst_inv_sts_cd, arrStr1, 1, 0);      
        		idx++;        		
		  		break;           	
	    }
	}
	/**
     * handling process for input validation <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type
     * @return {boolean}			false => validation check error, true => validation check succes
     * @author 
     * @version 
     */  
	function validateForm(sheetObj,formObj,sAction){
    	var formObj=document.form;
    	switch(sAction) {
    		case IBSEARCH:
    			if(formObj.cost_ofc_cd.value == ''){
    				ComShowCodeMessage('CGM10004','Cost Office');
    				formObj.cost_ofc_cd.focus();
    				return false;
    			} else if(vndr_seq.GetSelectText()== ''){
    				ComShowCodeMessage('CGM10004','S.Provider');
    				return false;
    			} else if(formObj.cost_yrmon.value == ''){
    				ComShowCodeMessage('CGM10004','Cost Month');
    				formObj.cost_yrmon.focus();
    				return false;
    			}
    			break;
    		case IBSAVE:
    			if(formObj.cost_ofc_cd.value == ''){
    				ComShowCodeMessage('CGM10004','Cost Office');
    				formObj.cost_ofc_cd.focus();
    				return false;
    			} else if(vndr_seq.GetSelectText()== ''){
    				ComShowCodeMessage('CGM10004','S.Provider');
    				return false;
    			} else if(formObj.cost_yrmon.value == ''){
    				ComShowCodeMessage('CGM10004','Cost Month');
    				formObj.cost_yrmon.focus();
    				return false;
    			} else if(formObj.inv_rcv_dt.value == ''){
    				ComShowCodeMessage('CGM10004','RCV Date');
    				formObj.inv_rcv_dt.focus();
    				return false;
    			} else if(formObj.inv_iss_dt.value == ''){
    				ComShowCodeMessage('CGM10004','Issue Date');
    				formObj.inv_iss_dt.focus();
    				return false;
    			}
    			break;
    	}
		return true;
	}
    /**
     * Action button enable/disable setting. <br>
     * @param  invStatus String
     * @param  statusCd String
     * @return 
     * @author 
     * @version
     */	
    function doActionBtnEnable (invStatus,  statusCd){
     	// Invoice Confirm button enable/disable
//     	alert("invStatus,  statusCd :" + invStatus +", "+ statusCd);
    	if(invStatus == 'S'){
     		ComBtnEnable("btn_Save");
     	} else {
     		ComBtnDisable("btn_Save");
     	}
     	// Cancel button enable/disable
     	switch(statusCd){
     		case "C":
     		case "R":
     		case "J":
     		case "E":
     		case "X":
     			ComBtnEnable("btn_Cancel");
     			break;
     		default:
     			ComBtnDisable("btn_Cancel");
     			break;
     	}
    }     
	/** 
     * MultiCombo reset  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */ 
    function initCombo(comboObj) {
    	//alert(comboObj);
    	switch(comboObj.options.id) {
	        case "vndr_seq":
	            var cnt=0;
	            with(comboObj) {
	            	Code="";
	            	Text="";
	            	SetBackColor("#CCFFFD");
	            	SetDropHeight(100);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetEnable(1);
	            }
	            break;
	        case "chss_mgst_inv_sts_cd":
	            var cnt=0;
	            with(comboObj) {
	            	Code="";
	            	Text="";
	            	SetBackColor("#FFFFFF");
	            	SetDropHeight(100);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetEnable(1);
	            }
	            break;
	    }
	}

    /** 
     * Object activate event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */
    function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
    /** 
     * Object deactivate event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */ 
    function obj_deactivate(){
    	var formObj=document.form;
    	obj=ComGetEvent();
    	switch(ComGetEvent("name")) {
	    	case "cost_yrmon":	
	    	case "inv_rcv_dt":
	    	case "inv_iss_dt":
	    		ComChkObjValid(ComGetEvent());
	    		break;
    	}
	}
    /** 
     * Object focusout event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */  
    function obj_focusout(){
    	var formObj=document.form;
	    var invRcvDt=ComReplaceStr(formObj.inv_rcv_dt.value,"-","");
	    var invIssDt=ComReplaceStr(formObj.inv_iss_dt.value,"-","");
    	obj=ComGetEvent();
    	switch(ComGetEvent("name")) {
    	 	case "inv_rcv_dt":
    	 		// Effective Date 
    	 		if(invIssDt != ''){
	    	     	if(invRcvDt != '' && invRcvDt<invIssDt){
	    	 	    	ComShowCodeMessage('CGM10050');
	    	 	    	formObj.inv_rcv_dt.value="";
	    	 	    	formObj.inv_eff_dt.value="";
	    	 	    	formObj.inv_rcv_dt.focus();
	    	 	    	break;
	    	 	    }
    	 		}
    	 		// Effective Date 
    	 		formObj.inv_eff_dt.value="";
    	 		if(invRcvDt != ''){
    	         	// Local Time setting
    	         	//doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_ASYNC05);
    	         	var sysMonth="";
    	         	//if(formObj.local_date.value != ''){
    	         		var sysDate=new Date();
    	            	var year=sysDate.getFullYear();
    	            	var month=sysDate.getMonth()+1;
    	            	var date=sysDate.getDate();
    	         		//if(formObj.local_date.value == 'undefined'){
    	         		//	sysMonth = ComLpad(year, 4, "0") + ComLpad(month, 2, "0") + '01';
    	         		//} else {
    	         		//	sysMonth = ComTrim(formObj.local_date.value).substring(0,6) + '01';
    	         		//}
    	            	sysMonth=ComLpad(year, 4, "0") + ComLpad(month, 2, "0") + '01';
    	         		if(invRcvDt < sysMonth){
        	     			formObj.inv_eff_dt.value=sysMonth.substring(0,4) + "-" + sysMonth.substring(4,6) + "-" + "01";
        	     		} else {
        	     			formObj.inv_eff_dt.value=invRcvDt.substring(0,4) + "-" + invRcvDt.substring(4,6) + "-" + invRcvDt.substring(6,8);
        	     		}
    	         	//}
    	     	}
    	 		break;
    	 	case "inv_iss_dt":
    	 		if(invRcvDt != ''){
	    	  	    if(invIssDt != '' && invRcvDt<invIssDt){
	    	  	    	ComShowCodeMessage('CGM10050');
	    	  	    	formObj.inv_iss_dt.value="";
	    	  	    	formObj.inv_iss_dt.focus();
	    	  	    }
    	 		}
    	 		break;
    	 	case "cost_yrmon":
    	 		// S.Provider retrieve
    			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC02);
    	 		break;
    	}
    } 
    /**
 	 * Sheet1 Change Event -> inv_smry_amt value setting <br>
 	 * @author 
 	 * @version
 	 */ 
    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	if(sheetObj.ColSaveName(Col) == 'inv_tax_clt_tp_cd' || sheetObj.ColSaveName(Col) == 'inv_tax_rt'){
    		if(sheetObj.ColSaveName(Col) == 'inv_tax_clt_tp_cd'){
    			if(sheetObj.GetCellValue(Row, "inv_tax_clt_tp_cd") == 'VAT'){
    				ComShowCodeMessage("CGM20041");
    			}else if(sheetObj.GetCellValue(Row, "inv_tax_clt_tp_cd") == 'WHT'){
    				ComShowCodeMessage("CGM20042");
    			}
    		}
    		
    		var iChgSmryAmt=Number(sheetObj.GetCellValue(Row, "chg_smry_amt"));
    		var iInvTaxRt=Number(sheetObj.GetCellValue(Row, "inv_tax_rt"));
    		if(sheetObj.GetCellValue(Row, "inv_tax_clt_tp_cd") == 'VAT'){
        		var tmpInvTaxRt=Number(sheetObj.GetCellValue(Row, "inv_tax_rt")); 	 
        		iInvTaxRt=Math.abs(tmpInvTaxRt);							
        		sheetObj.SetCellValue(Row,"inv_tax_rt",iInvTaxRt);					
    			sheetObj.SetCellValue(Row, "inv_smry_amt",iChgSmryAmt + (iChgSmryAmt * iInvTaxRt / 100));
    		} else if(sheetObj.GetCellValue(Row, "inv_tax_clt_tp_cd") == 'WHT'){
    			sheetObj.SetCellValue(Row, "inv_smry_amt",iChgSmryAmt - iInvTaxRt);
    		}
    	}
    }
	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
		if(sheetObj.ColSaveName(Col) == 'del_chk'){
			var vndrSeq=sheetObj.GetCellValue(Row,"vndr_seq"); 
			if(vndrSeq == '132466' || vndrSeq == '105026'){
				vndrSeq="105621";
			}
			for(var i=1; i <= sheetObj.RowCount(); i++){
				var cellVndrSeq=sheetObj.GetCellValue(i,"vndr_seq");
				if(cellVndrSeq == '132466' || cellVndrSeq == '105026'){
					cellVndrSeq="105621";
				}
				if(vndrSeq == cellVndrSeq){
					if(Row != i){
						sheetObj.SetCellValue(i,"del_chk",sheetObj.GetCellValue(Row,"del_chk")==0?1:0);
					}
				} else {
					sheetObj.SetCellValue(i,"del_chk",0);
				}
			}	
			// button enable/disable
			var invStatus=sheetObj.GetCellValue(Row,"chss_mgst_inv_sts_cd");
			var statusCd=sheetObj.GetCellValue(Row,"status_cd");
			if( sheetObj.GetCellValue(Row,"del_chk") == 1 )
				doActionBtnEnable(invStatus, statusCd);
			else
				doActionBtnEnable('-1','-1');
		}
	}
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
    	if(sheetObj.ColSaveName(Col) != 'del_chk'){
	    	document.form.pay_inv_seq.value=sheetObj.GetCellValue(Row, "pay_inv_seq");
	    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC04);
    	}
    }
	/**
	 * Sheet1 OnSaveEnd event handling <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {string} ErrMsg		 String
	 * @return 
	 * @version
	 */ 
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
		}
	} 
	/**
	 * Sheet1 OnSaveEnd event handling <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {string} ErrMsg		 String
	 * @return 
	 * @version
	 */ 
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			for(var row=1; row <= sheetObj.RowCount(); row++){
				if(sheetObj.GetCellValue(row, "chss_mgst_inv_sts_cd") == 'S'){
					sheetObj.SetCellEditable(row, "rev_vvd",1);
					sheetObj.SetCellEditable(row, "inv_tax_clt_tp_cd",1);
					sheetObj.SetCellEditable(row, "inv_tax_rt",1);
				} else {
					sheetObj.SetCellEditable(row, "rev_vvd",0);
					sheetObj.SetCellEditable(row, "inv_tax_clt_tp_cd",0);
					sheetObj.SetCellEditable(row, "inv_tax_rt",0);
				}
			}
		}
	}	 
    /**
	 * S.Provier MultiCombo  OnChange event handling <br>
	 * @param  {object} comboObj	mandatory	 Sheet Object
	 * @param  {string} Index_Code	mandatory String
	 * @param  {string} Text		mandatory String
	 * @return 
	 * @version
	 */
	//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
    function vndr_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	if(comboObj.GetSelectText()!= ''){
    		// Pay Term retrieve
    		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC06);
    	}
    }
    function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
     	cmbObj.RemoveAll();
     	cmbObj.InsertItem(0,"ALL","ALL");
     	for (var i=0; i < arrStr.length;i++ ) {
     		var arrCode=arrStr[i].split("|");
     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
     	}
     	//cmbObj.Index2 = "" ;
    }
	/* developer job end */
