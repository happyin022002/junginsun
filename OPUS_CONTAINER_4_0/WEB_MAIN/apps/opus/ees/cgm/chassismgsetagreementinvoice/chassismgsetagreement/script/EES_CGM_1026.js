/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1026.jsp
*@FileTitle  : Lease Term Change
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* developer job	*/
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * @param
     * @return 
     * @author 
     * @version 2009.06.23
     */
    function processButtonClick(){
        /***** use additional sheet var in case of more than 2 tap each sheet *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
            	case "btn_Loadexcel":
        			var formObj=document.form;
        	     	var sheetObj=sheetObjects[0];
            		if (sheetObj.id == "sheet1") {
            			sheetObj.RemoveAll();
             			sheetObj.LoadExcel();
            		}
            		
            		 break;
 				case "btn_rowadd":
 					if(ComIsBtnEnable(srcName)){
 						doActionIBSheet(sheetObject1,formObject,IBINSERT);
 					}
 					break;
 				case "btn_rowdelete":
 					if(ComIsBtnEnable(srcName)){
 						doActionIBSheet(sheetObject1,formObject,IBRESET);
 					}
 					break;
 				case "btn_downexcel":
 					if(ComIsBtnEnable(srcName)){
 						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 					}
 					break;
 				case "btn_Retrieve":
 					if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
 						// Retrieve 
 						doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 						// button ENABLE setting
 						doActionBtnEnable("btn_Retrieve");
 					}
 					break;
 				case "btn_New":
 					// Control reset
 					initControl();
 					// button ENABLE setting
					doActionBtnEnable("btn_New");
 					break;
 				case "btn_Save":
 					if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
 						// saving
 						//doActionIBSheet(sheetObject1, formObject, IBSAVE);
 						doActionIBSheet(sheetObject1, formObject, IBBATCH);
 					}
 					break;
 				case "btns_Calendar_activityDt" :		// Activity Date
					var cal=new ComCalendar();
 				    cal.setEndFunction("processEndCal");
			    	cal.select(formObject.sts_evnt_dt, "yyyy-MM-dd");
		    		break;
 				case "btns_agmtno":			// Agreement No getting popup
 					if(!formObject.btns_agmtno.disabled){
	 					ComOpenPopupWithTarget(
							'/opuscntr/EES_CGM_1117.do', 820, 420,
							"agmt_ofc_cty_cd:old_agmt_ofc_cty_cd|" +
							"agmt_seq:old_agmt_seq|" +
							"agmt_ver_no:old_agmt_ver_no|" +
							"agmt_no:old_agmt_no|" +
							"agmt_ref_no:old_agmt_ref_no|" +
							"agmt_lstm_cd:old_agmt_lstm_cd|" +
							"vndr_seq:old_vndr_seq|" +
							"vndr_lgl_eng_nm:old_vndr_lgl_eng_nm",
							"1,0,1,1,1,1,1,1,1", true);
 					}
 					break;
 				case "btns_new_agmtno":		// New Agreement No getting popup
 					ComOpenPopupWithTarget(
 						'/opuscntr/EES_CGM_1117.do', 820, 420,
 						"agmt_ofc_cty_cd:new_agmt_ofc_cty_cd|" +
						"agmt_seq:new_agmt_seq|" +
						"agmt_ver_no:new_agmt_ver_no|" +
 						"agmt_no:new_agmt_no|" +
 						"agmt_ref_no:new_agmt_ref_no|" +
 						"agmt_lstm_cd:new_agmt_lstm_cd|" +
 						"vndr_seq:new_vndr_seq|" +
 						"vndr_lgl_eng_nm:new_vndr_lgl_eng_nm",
 						"1,0,1,1,1,1,1,1,1", true);
					break;
 				case "btns_office":	// Office Code getting popup
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 480, "ofc_cd:sts_evnt_ofc_cd", "1,0,1,1,1,1,1,1", true);
					break;
            } // end switch
            tRoleApply();
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
     * @version 2009.06.23
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
     * @version 2009.06.23
     */
    function loadPage() {
    	// axon event regist
//      axon_event.addListenerFormat('keypress', 'obj_keypress', form);
//      axon_event.addListenerFormat('keydown', 'obj_keydown', form);
//        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
//        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
//        axon_event.addListener('change', 'obj_change', 'old_agmt_no');
//        axon_event.addListener('change', 'obj_change', 'new_agmt_no');
//        axon_event.addListener('change', 'obj_change', 'sts_evnt_ofc_cd');
//        axon_event.addListenerForm 	 ('focusout', 'obj_focusout',   form);
    	for(i=0;i<sheetObjects.length;i++){
        //
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //
            ComEndConfigSheet(sheetObjects[i]);
        }
        // Form Object reset
     	initControl();
     	tRoleApply();
    }
    /**
     * init control of form <br>
     * @param  
     * @return 
     * @author 
     * @version 2009.06.23
     */
    function initControl(){
    	// Form object
      	formObj=document.form;
    	var sysDate=new Date();
    	var year=sysDate.getFullYear();
    	var month=sysDate.getMonth()+1;
    	var date=sysDate.getDate();
    	var today=ComLpad(year, 4, "0") + "-" + ComLpad(month, 2, "0") + "-" + ComLpad(date, 2, "0");
    	// Form Object reset
        with(formObj){
        	ComCgmSetObjectValue(sts_evnt_dt, today);
        	ComCgmSetObjectValue(sts_evnt_ofc_cd, ofc_cd.value);
        	ComCgmSetObjectValue(old_agmt_no);
        	ComCgmSetObjectValue(old_agmt_ref_no);
        	ComCgmSetObjectValue(old_agmt_lstm_cd);
        	ComCgmSetObjectValue(old_vndr_seq);
        	ComCgmSetObjectValue(old_vndr_lgl_eng_nm);
        	ComCgmSetObjectValue(new_agmt_no);
        	ComCgmSetObjectValue(new_agmt_ref_no);
        	ComCgmSetObjectValue(new_agmt_lstm_cd);
        	ComCgmSetObjectValue(new_vndr_seq);
        	ComCgmSetObjectValue(new_vndr_lgl_eng_nm);
        }
        formObj.old_agmt_no.readOnly=false;
        formObj.old_agmt_no.className="input";
        ComCgmEnableObject(formObj.btns_agmtno, true);
        // Sheet Object reset
        sheetObjects[0].RemoveAll();
        //  focus
//        formObj.old_agmt_no.focus();
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {int} sheetNo
     * @return 
     * @author 
     * @version 2009.06.23
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
		            var HeadTitle="||A/I|Chassis No.|Type/Size|Term|Office|Yard|Lessor|Agreement No.|Reference No.|Status|||||Status Date";
		            var headCount=ComCountHeadTitle(HeadTitle);
		            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		            var headers = [ { Text:HeadTitle, Align:"Center"} ];
		            InitHeaders(headers, info);
		            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"aciac_div_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eq_aset_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_loc_cd" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no" },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		            InitColumns(cols);
		            SetEditable(1);
		            SetColProperty(0, "sts_evnt_dt", {Format:"####-##-##"} );
		            SetColProperty(0, "eq_no", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		            SetFocusEditMode(1);
		            //SetSheetHeight(240);
                    //conversion of function[check again]CLT  					InitDataValid(0, "eq_no", vtEngUpOther, "1234567890");
		            resizeSheet();
            }
            break;
            case 2:
                with(sheetObj){
		          var HeadTitle1="";
		          var headCount=ComCountHeadTitle(HeadTitle1);
		
		          SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(202);
            }
        	break;
        }
    }
    function resizeSheet(){
    	ComResizeSheet( sheetObjects[0], 130 );
    }    
    /**
     * Action button의 enable/disable setting. <br>
     * @param  
     * @return 
     * @author 
     * @version 2009.06.23
     */
    function doActionBtnEnable (srcName){
    	switch(srcName){
    		case "btn_Retrieve":
    			ComBtnDisable("btn_rowadd");
    			ComBtnDisable("btn_rowdelete");
    			ComBtnEnable("btn_downexcel");
    			ComBtnDisable("btn_Loadexcel");
    			break;
    		case "btn_New":
    			ComBtnEnable("btn_rowadd");
    			ComBtnEnable("btn_rowdelete");
    			ComBtnDisable("btn_downexcel");
    			ComBtnEnable("btn_Loadexcel");
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
	            // Form Object value setting
            	formObj.f_cmd.value=SEARCH;
            	formObj.agmt_no.value=formObj.old_agmt_no.value;
	     		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
         		sheetObj.SetWaitImageVisible(0);
		 	    ComOpenWait(true);
	     		// retrieve
 	     		var sXml=sheetObj.GetSearchData("EES_CGM_1026GS.do" , FormQueryString(formObj), '', true);
	     		sheetObj.LoadSearchData(sXml,{Sync:1} );
	     		ComOpenWait(false);
	     		// Form Object reset (New Agreement)
	     		formObj.new_agmt_no.value="";
	 			formObj.new_agmt_ofc_cty_cd.value="";
	 			formObj.new_agmt_seq.value="";
	 			formObj.new_agmt_ver_no.value="";
	 			formObj.new_agmt_ref_no.value="";
	 			formObj.new_agmt_lstm_cd.value="";
	 			formObj.new_vndr_seq.value="";
	 			formObj.new_vndr_lgl_eng_nm.value="";
	 			break;
 			case IBSAVE:        //saving
 				var stsRows=sheetObj.FindStatusRow("I|U");
 				var chkRows=sheetObj.FindCheckedRow("del_chk");
 				var arrStsRows=stsRows.split(";");
 				var arrChkRows=chkRows.split("|");
 				var chk;
 				var dt=ComReplaceStr(form.sts_evnt_dt.value,"-","");
 				for(i=1; i<=sheetObj.rowCount; i++){
				if(sheetObj.GetCellValue(i, "del_chk") == "1"){
				if(dt<sheetObj.GetCellValue(i, "sts_evnt_dt")){
				ComShowCodeMessage('CGM10060',sheetObj.GetCellValue(i, "eq_no"));
 							return false;
 							break;
 						}
 					}
 				}
 				for(i=0; i < arrStsRows.length-1; i++){
 					chk=false;
 					for(k=0; k < arrChkRows.length-1; k++){
 						if(arrStsRows[i] == arrChkRows[k]){
 							chk=true;
 							break;
 						}
 					}
 					if(!chk){
 						sheetObj.SetRowStatus(arrStsRows[i],"");
 					}
 				}
 				if(arrChkRows.length-1 > 0){
	 				// saving
	 				formObj.f_cmd.value=MULTI;
	 				formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
	 				var sParam=sheetObjects[0].GetSaveString();
	 				sParam=ComSetPrifix(sParam, "sheet1") + "&" + FormQueryString(formObj);
	 				sheetObj.SetWaitImageVisible(0);
			 	    ComOpenWait(true);
 	 				var sXml=sheetObj.GetSaveData("EES_CGM_1026GS.do", sParam);
 	 				sheetObjects[0].LoadSaveData(sXml);
	 				ComOpenWait(false);
 				} else {
 					ComShowCodeMessage('CGM10009','checkbox');
 				}
//
 				break;
 			case IBBATCH:      //saving-BackEndJob
				var stsRows=sheetObj.FindStatusRow("I|U");
 				var chkRows=sheetObj.FindCheckedRow("del_chk");
 				var arrStsRows=stsRows.split(";");
 				var arrChkRows=chkRows.split("|");
 				var chk;
 				var dt=ComReplaceStr(form.sts_evnt_dt.value,"-","");
 				if(chkRows == ""){
 					ComShowCodeMessage("CGM10008");
 					return false;
 				}
 					
 				for(i=1; i<=sheetObj.RowCount(); i++){
 					if(sheetObj.GetCellValue(i, "del_chk") == "1"){
 						if(dt<sheetObj.GetCellValue(i, "sts_evnt_dt")){
 							ComShowCodeMessage('CGM10060',sheetObj.GetCellValue(i, "eq_no"));
 							return false;
 							break;
 						}
 					}
 				}
 				for(i=0; i < arrStsRows.length; i++){
 					chk=false;
 					for(k=0; k < arrChkRows.length; k++){
 						if(arrStsRows[i] == arrChkRows[k]){
 							chk=true;
 							break;
 						}
 					}
 					if(!chk){
 						sheetObj.SetRowStatus(arrStsRows[i],"");
 					}
 				}
 				if(arrChkRows.length > 0){
	 				// saving
	 				formObj.f_cmd.value=COMMAND01;
	 				formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
	 				var sParam=sheetObjects[0].GetSaveString();
	 				sParam=ComSetPrifix(sParam, "sheet1") + "&" + FormQueryString(formObj);
	 				sheetObj.SetWaitImageVisible(0);
			 	    ComOpenWait(true);
 			 	    var sXml=sheetObj.GetSaveData("EES_CGM_1026GS.do", sParam);
					var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
					if (backendJobKey.length > 0) {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.SetWaitTimeOut(10000);
						timer1=setInterval(getBackEndJobStatus, 3000);
					}
 				} else {
 					ComShowCodeMessage('CGM10009','checkbox');
 				}
//
 				break;
 			case IBSEARCH_ASYNC01:	// Office Code  Validation check
	        	formObj.f_cmd.value=COMMAND01;
	        	formObj.ofc_cd.value=formObj.sts_evnt_ofc_cd.value;
 	        	var sXml=sheetObjects[1].GetSearchData("CgmValidationGS.do", FormQueryString(formObj), '', true);
	        	var sCheckResult=ComGetEtcData(sXml,"checkResult");
	        	if(sCheckResult == COM_VALIDATION_FALSE){
	        		ComShowCodeMessage('CGM10009','Office');
	        		formObj.sts_evnt_ofc_cd.value="";
//	        		formObj.sts_evnt_ofc_cd.focus();
	        	}
	        	break;
 			case IBSEARCH_ASYNC02:
 				formObj.f_cmd.value=SEARCH12;
 				formObj.agmt_no.value=formObj.old_agmt_no.value;
 				formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
  				var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do" , FormQueryString(formObj), '', true);
		 		// data count
				var dataCount=ComGetTotalRows(sXml);
				// data existing
				if(dataCount>0){
					formObj.old_agmt_ofc_cty_cd.value=DomXml2String(sXml,"agmt_ofc_cty_cd");
		 			formObj.old_agmt_seq.value=DomXml2String(sXml,"agmt_seq");
		 			formObj.old_agmt_ver_no.value=DomXml2String(sXml,"agmt_ver_no");
		 			formObj.old_agmt_ref_no.value=DomXml2String(sXml,"agmt_ref_no");
		 			formObj.old_agmt_lstm_cd.value=DomXml2String(sXml,"agmt_lstm_cd");
		 			formObj.old_vndr_seq.value=DomXml2String(sXml,"vndr_seq");
		 			formObj.old_vndr_lgl_eng_nm.value=DomXml2String(sXml,"vndr_lgl_eng_nm");
		 			return true;
		 		} else {
	        		return false;
		 		}
 				break;
 			case IBSEARCH_ASYNC03:
 				formObj.f_cmd.value=SEARCH12;
 				formObj.agmt_no.value=formObj.new_agmt_no.value;
 				formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
  				var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do" , FormQueryString(formObj), '', true);
		 		// data count
		 		var dataCount=ComGetTotalRows(sXml);
		 		// data existing
				if(dataCount > 0){
					formObj.new_agmt_ofc_cty_cd.value=DomXml2String(sXml,"agmt_ofc_cty_cd");
		 			formObj.new_agmt_seq.value=DomXml2String(sXml,"agmt_seq");
		 			formObj.new_agmt_ver_no.value=DomXml2String(sXml,"agmt_ver_no");
		 			formObj.new_agmt_ref_no.value=DomXml2String(sXml,"agmt_ref_no");
		 			formObj.new_agmt_lstm_cd.value=DomXml2String(sXml,"agmt_lstm_cd");
		 			formObj.new_vndr_seq.value=DomXml2String(sXml,"vndr_seq");
		 			formObj.new_vndr_lgl_eng_nm.value=DomXml2String(sXml,"vndr_lgl_eng_nm");
		 			return true;
		 		} else {
	        		return false;
		 		}
 				break;
 			case IBINSERT:      // row add
 				sheetObj.DataInsert(-1);
 				formObj.old_agmt_no.readOnly=true;
 				formObj.old_agmt_no.className="input2";
 				ComCgmEnableObject(formObj.btns_agmtno, false);
                break;
 			case IBRESET:	 	// 
 				ComRowHideDelete(sheetObj,"del_chk");
 				break;
 			case IBDOWNEXCEL:
 				if(sheetObj.RowCount() < 1){//no data
 					ComShowCodeMessage("COM132501");
 				}else{
 					sheetObj.Down2Excel({ HiddenColumn:1,TreeLevel:false, DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1});
 				}
 				break;
        }
    }
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction){
    	 		case IBSEARCH:	// retrieve
	    	 		if(old_agmt_no.value == ''){
	    	 			ComShowCodeMessage('CGM10004','Agreement No.');
//	    	 			old_agmt_no.focus();
	    	 			return false;
	                } else {
	                	return true;
	                }
    	 			break;
    	 		case IBSAVE:	// saving
	    	 		if(sts_evnt_dt.value == ''){
	    	 			ComShowCodeMessage('CGM10004','Activity Date');
//	    	 			sts_evnt_dt.focus();
	    	 			return false;
	    	 		} else if(sts_evnt_ofc_cd.value == ''){
	    	 			ComShowCodeMessage('CGM10004','Office');
//	    	 			sts_evnt_ofc_cd.focus();
	    	 			return false;
	    	 		} else if(new_agmt_no.value == ''){
		    	 		ComShowCodeMessage('CGM10004','Agreement No.');
//		    	 		new_agmt_no.focus();
		    	 		return false;
		    	 	}
	    	 		if(old_agmt_no.value == new_agmt_no.value){
	    	 			ComShowCodeMessage('CGM10035');
	    	 			// Form Object reset (New Agreement)
	    	     		new_agmt_no.value="";
	    	 			new_agmt_ofc_cty_cd.value="";
	    	 			new_agmt_seq.value="";
	    	 			new_agmt_ver_no.value="";
	    	 			new_agmt_ref_no.value="";
	    	 			new_agmt_lstm_cd.value="";
	    	 			new_vndr_seq.value="";
	    	 			new_vndr_lgl_eng_nm.value="";
//	    	 			new_agmt_no.focus();
	    	 			return false;
	    	 		}
            		for(count_i=1; count_i<sheetObj.RowCount()+1; count_i++){
						var grid_agmt_seq=sheetObj.GetCellValue(count_i, "agmt_seq");
						var grid_agmt_ofc_cty_cd=sheetObj.GetCellValue(count_i, "agmt_ofc_cty_cd");
            			if( (grid_agmt_seq == new_agmt_seq.value)
	    	 				&& (grid_agmt_ofc_cty_cd == new_agmt_ofc_cty_cd.value)
	    	 			)
	    	 			{
		    	 			ComShowCodeMessage('CGM10035');
		    	 			// Form Object reset (New Agreement)
		    	     		new_agmt_no.value="";
		    	 			new_agmt_ofc_cty_cd.value="";
		    	 			new_agmt_seq.value="";
		    	 			new_agmt_ver_no.value="";
		    	 			new_agmt_ref_no.value="";
		    	 			new_agmt_lstm_cd.value="";
		    	 			new_vndr_seq.value="";
		    	 			new_vndr_lgl_eng_nm.value="";
//		    	 			new_agmt_no.focus();
		    	 			return false;
	    	 			}
            		}
    	 			break;
        	}
        }
        return true;
    }
    function obj_keypress(){
      	obj=event.srcElement;
      	if(obj.dataformat == null) return;
      	window.defaultStatus=obj.dataformat;
      	switch(obj.dataformat) {
      	 	case "ym": case "ymd":
      	 		ComKeyOnlyNumber(obj);
      	 		break;
      	 	case "int":
      	    	ComKeyOnlyNumber(obj);
      	        break;
      	 	case "float":
 	            ComKeyOnlyNumber(obj, "-.");
 	            break;
      	    case "eng":
      	        ComKeyOnlyAlphabet();
      	        break;
      	    case "engup":
      	        if(obj.name=="sts_evnt_ofc_cd") ComKeyOnlyAlphabet('uppernum');
      	        else if(obj.name=="old_agmt_no") ComKeyOnlyAlphabet('uppernum');
      	        else if(obj.name=="new_agmt_no") ComKeyOnlyAlphabet('uppernum');
      	        else ComKeyOnlyAlphabet('upper');
      	        break;
      	    case "engdn":
      	        ComKeyOnlyAlphabet('lower');
      	        break;
      	}
    }
    function obj_keydown(){
    	var obj=event.srcElement;
    	var sheetObj=sheetObjects[0];
    	var formObj=document.form;
    	switch(ComGetEvent("name")){
    		case 'old_agmt_no':
    			var keyValue=null;
            	if(event == undefined || event == null) {
            		keyValue=13;
            	} else {
            		keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    			}
    			if(keyValue != 13) return;
    			var agmtNo=formObj.old_agmt_no.value;
    	 		var result=true;
    	 		if(agmtNo != ""){
    	 			if(agmtNo.length <= 3){
	    	 			result=false;
	    	 		} else {
	    	 			if(ComIsNumber(agmtNo.substring(3))==false){
	    	 				result=false;
	    	 			}
	    	 		}
    	 		} else {
    	 			result=true;
    	 		}
    	 		if(!result){
    	 			ComShowCodeMessage('CGM10004','Agreement No.');
    	 			formObj.old_agmt_no.value="";
    	 			ComSetFocus(formObj.old_agmt_no);
    	 		} else {
    	 			if(!doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02)){
//	 					formObj.old_agmt_no.focus();
    	 			} else {
    	 				ComKeyEnter();
    	 			}
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
     	var evtObj=ComGetEvent();
     	if(evtObj.name == 'sts_evnt_dt'){
     		ComChkObjValid(evtObj);
     	}
    }
    /**
     * Object change event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */
    function obj_change(){
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	obj=ComGetEvent("name");
    	switch(obj){
    	 	case "old_agmt_no":
    	 	case "new_agmt_no":
    	 		var result=true;
    	 		var agmtNo="";
    	 		if(obj == 'old_agmt_no')		
    	 			agmtNo=formObj.old_agmt_no.value;
    	 			
    	 		else if(obj == 'new_agmt_no')	
    	 			agmtNo=formObj.new_agmt_no.value;
    	 		if(agmtNo != ""){
    	 			result=true;
    	 			if(agmtNo.length <= 3){
	    	 			result=false;
	    	 		} else {
	    	 			if(ComIsNumber(agmtNo.substring(3))==false){
	    	 				result=false;
	    	 			}
	    	 		}
	    	 		if(!result){
	    	 			ComShowCodeMessage('CGM10004','Agreement No.');
	    	 			if(obj == 'old_agmt_no'){
	    	 				// Sheet Object reset
	    	 				sheetObj.RemoveAll();
	    	 				// Form Object reset
	    	 				formObj.old_agmt_no.value="";
	    	 				formObj.old_agmt_ofc_cty_cd.value="";
	    		 			formObj.old_agmt_seq.value="";
	    		 			formObj.old_agmt_ver_no.value="";
	    		 			formObj.old_agmt_ref_no.value="";
	    		 			formObj.old_agmt_lstm_cd.value="";
	    		 			formObj.old_vndr_seq.value="";
	    		 			formObj.old_vndr_lgl_eng_nm.value="";
		    	 			ComSetFocus(formObj.old_agmt_no);
		    	 			doActionBtnEnable("btn_New");
	    	 			} else if(obj == 'new_agmt_no'){
	    	 				// Form Object reset
	    	 				formObj.new_agmt_no.value="";
	    	 				formObj.new_agmt_ofc_cty_cd.value="";
	    		 			formObj.new_agmt_seq.value="";
	    		 			formObj.new_agmt_ver_no.value="";
	    		 			formObj.new_agmt_ref_no.value="";
	    		 			formObj.new_agmt_lstm_cd.value="";
	    		 			formObj.new_vndr_seq.value="";
	    		 			formObj.new_vndr_lgl_eng_nm.value="";
		    	 			ComSetFocus(formObj.new_agmt_no);
	    	 			}
	    	 		} else {
	    	 			if(obj == 'old_agmt_no'){
	    	 				sheetObj.RemoveAll();
	    	 				if(!doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC02)){
	    	 					ComShowCodeMessage('CGM10009','Agreement No.');
	    	 					// Sheet Object reset
	    			 			sheetObjects[0].RemoveAll();
	    			 			// Form Object reset
	    			 			formObj.old_agmt_no.value="";
	    			 			formObj.old_agmt_ofc_cty_cd.value="";
	    			 			formObj.old_agmt_seq.value="";
	    			 			formObj.old_agmt_ver_no.value="";
	    			 			formObj.old_agmt_ref_no.value="";
	    			 			formObj.old_agmt_lstm_cd.value="";
	    			 			formObj.old_vndr_seq.value="";
	    			 			formObj.old_vndr_lgl_eng_nm.value="";
	    			 			// Focus
	    	 					ComSetFocus(formObj.old_agmt_no);
	    	 					doActionBtnEnable("btn_New");
	    	 				} else {
	    	 					formObj.old_agmt_no.value = formObj.old_agmt_no.value.substring(0,3)+ComLpad(formObj.old_agmt_no.value.substring(3),6,"0");
	    	 					doActionBtnEnable("btn_Retrieve");
	    	 				}
	    	 			} else if(obj == 'new_agmt_no'){
	    	 				if(!doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC03)){
	    	 					ComShowCodeMessage('CGM10009','Agreement No.');
	    	 					// Form Object reset
	    			 			formObj.new_agmt_no.value="";
	    			 			formObj.new_agmt_ofc_cty_cd.value="";
	    			 			formObj.new_agmt_seq.value="";
	    			 			formObj.new_agmt_ver_no.value="";
	    			 			formObj.new_agmt_ref_no.value="";
	    			 			formObj.new_agmt_lstm_cd.value="";
	    			 			formObj.new_vndr_seq.value="";
	    			 			formObj.new_vndr_lgl_eng_nm.value="";
	    	 					ComSetFocus(formObj.new_agmt_no);
	    	 				}
	    	 				else{
	    	 					formObj.new_agmt_no.value = formObj.new_agmt_no.value.substring(0,3)+ComLpad(formObj.new_agmt_no.value.substring(3),6,"0");
	    	 				}
	    	 			}
	    	 		}
    	 		}
    	 		break;
    	 	case "sts_evnt_ofc_cd":
    	 		if(formObj.sts_evnt_ofc_cd.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
    	 		}
    	 		break;
    	}
    }
    /**
     * Sheet1 change event handling  <br>
     * @param  sheetObj
     * @param  Row
     * @param  Col
     * @return 
     * @author 
     * @version 2009.06.23
     */
    function sheet1_OnChange(sheetObj, Row, Col){
    	var formObj=document.form;
     	var sheetObj=sheetObjects[0];
     	var targetCol=sheetObj.SaveNameCol("eq_no");
     	var eqNo=sheetObj.GetCellValue(Row, "eq_no");
     	if(Col == targetCol && eqNo != ''){
     		//var checkDup = sheetObj.ColValueDup("eq_no", false);
            var checkDup=-1;
     		var cellValue=sheetObj.GetCellValue(Row, Col);
     		for(i=1; i<sheetObj.rowCount+1; i++){
     			if(sheetObj.GetCellValue(i, "eq_no")== cellValue && Row != i )
				{
					checkDup=1;
				}
			}
     		if(checkDup == -1){
		     	formObj.f_cmd.value=SEARCH01;
				formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
				formObj.eq_no.value=eqNo;
 		 		var sXml=sheetObjects[1].GetSearchData("EES_CGM_1026GS.do" , FormQueryString(formObj), '', true);
		 		// data count
		 		var dataCount=ComGetTotalRows(sXml);
		 		// data existing
				if(dataCount > 0){
					if(ComGetEtcData(sXml,"aciac_div_cd") == 'I'){
						sheetObj.SetCellEditable(Row, "del_chk",0);
						sheetObj.SetRowFontColor(Row,"#FF0000");
					} else {
						sheetObj.SetCellEditable(Row, "del_chk",1);
						sheetObj.SetRowFontColor(Row,"#000000");
					}
		 			sheetObj.SetCellValue(Row,"eq_no",ComGetEtcData(sXml,"eq_no"));
			     	sheetObj.SetCellValue(Row,"eq_tpsz_cd",ComGetEtcData(sXml,"eq_tpsz_cd"));
			     	sheetObj.SetCellValue(Row,"agmt_lstm_cd",ComGetEtcData(sXml,"agmt_lstm_cd"));
			     	sheetObj.SetCellValue(Row,"sts_evnt_ofc_cd",ComGetEtcData(sXml,"sts_evnt_ofc_cd"));
			     	sheetObj.SetCellValue(Row,"sts_evnt_yd_cd",ComGetEtcData(sXml,"sts_evnt_yd_cd"));
			     	sheetObj.SetCellValue(Row,"vndr_seq",ComGetEtcData(sXml,"vndr_seq"));
			     	sheetObj.SetCellValue(Row,"agmt_no",ComGetEtcData(sXml,"agmt_no"));
			     	sheetObj.SetCellValue(Row,"agmt_ref_no",ComGetEtcData(sXml,"agmt_ref_no"));
			     	sheetObj.SetCellValue(Row,"aciac_div_cd",ComGetEtcData(sXml,"aciac_div_cd"));
			     	sheetObj.SetCellValue(Row,"eq_aset_sts_cd",ComGetEtcData(sXml,"eq_aset_sts_cd"));
			     	sheetObj.SetCellValue(Row,"sts_evnt_loc_cd",ComGetEtcData(sXml,"sts_evnt_loc_cd"));
			     	sheetObj.SetCellValue(Row,"agmt_ofc_cty_cd",ComGetEtcData(sXml,"agmt_ofc_cty_cd"));
			     	sheetObj.SetCellValue(Row,"agmt_seq",ComGetEtcData(sXml,"agmt_seq"));
			     	sheetObj.SetCellValue(Row,"agmt_ver_no",ComGetEtcData(sXml,"agmt_ver_no"));
			     	sheetObj.SetCellValue(Row,"sts_evnt_dt",ComGetEtcData(sXml,"sts_evnt_dt"));
	     		} else {
	     			ComShowCodeMessage('CGM10012');
	     			sheetObj.SetCellEditable(Row, "del_chk",1);
					sheetObj.SetRowFontColor(Row,"#000000");
	     			sheetObj.SetCellValue(Row,"eq_no","");
			     	sheetObj.SetCellValue(Row,"eq_tpsz_cd","");
			     	sheetObj.SetCellValue(Row,"agmt_lstm_cd","");
			     	sheetObj.SetCellValue(Row,"sts_evnt_ofc_cd","");
			     	sheetObj.SetCellValue(Row,"sts_evnt_yd_cd","");
			     	sheetObj.SetCellValue(Row,"vndr_seq","");
			     	sheetObj.SetCellValue(Row,"agmt_no","");
			     	sheetObj.SetCellValue(Row,"agmt_ref_no","");
			     	sheetObj.SetCellValue(Row,"aciac_div_cd","");
			     	sheetObj.SetCellValue(Row,"eq_aset_sts_cd","");
			     	sheetObj.SetCellValue(Row,"sts_evnt_loc_cd","");
			     	sheetObj.SetCellValue(Row,"agmt_ofc_cty_cd","");
			     	sheetObj.SetCellValue(Row,"agmt_seq","");
			     	sheetObj.SetCellValue(Row,"agmt_ver_no","");
			     	sheetObj.SetCellValue(Row,"sts_evnt_dt","");
//			     	sheetObj.focus();
			     	sheetObj.SelectCell(Row,3,1);
	     		}
     		} else {
     			ComShowCodeMessage('CGM10017','Chassis No.');
     			sheetObj.SetCellEditable(Row, "del_chk",1);
				sheetObj.SetRowFontColor(Row,"#000000");
     			sheetObj.SetCellValue(Row,"eq_no","");
		     	sheetObj.SetCellValue(Row,"eq_tpsz_cd","");
		     	sheetObj.SetCellValue(Row,"agmt_lstm_cd","");
		     	sheetObj.SetCellValue(Row,"sts_evnt_ofc_cd","");
		     	sheetObj.SetCellValue(Row,"sts_evnt_yd_cd","");
		     	sheetObj.SetCellValue(Row,"vndr_seq","");
		     	sheetObj.SetCellValue(Row,"agmt_no","");
		     	sheetObj.SetCellValue(Row,"agmt_ref_no","");
		     	sheetObj.SetCellValue(Row,"aciac_div_cd","");
		     	sheetObj.SetCellValue(Row,"eq_aset_sts_cd","");
		     	sheetObj.SetCellValue(Row,"sts_evnt_loc_cd","");
		     	sheetObj.SetCellValue(Row,"agmt_ofc_cty_cd","");
		     	sheetObj.SetCellValue(Row,"agmt_seq","");
		     	sheetObj.SetCellValue(Row,"agmt_ver_no","");
		     	sheetObj.SetCellValue(Row,"sts_evnt_dt","");
//		     	sheetObj.focus();
		     	sheetObj.SelectCell(Row,"eq_no",true);
     		}
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
 		 var formObj=document.form;
 		 if(errMsg =='') {
 			ComShowCodeMessage('CGM00003');
 			// retrieve
     		formObj.old_agmt_no.value=formObj.new_agmt_no.value;
     		formObj.old_agmt_ref_no.value=formObj.new_agmt_ref_no.value;
     		formObj.old_agmt_lstm_cd.value=formObj.new_agmt_lstm_cd.value;
     		formObj.old_vndr_seq.value=formObj.new_vndr_seq.value;
     		formObj.old_vndr_lgl_eng_nm.value=formObj.new_vndr_lgl_eng_nm.value;
     		formObj.new_agmt_no.value="";
     		formObj.new_agmt_ref_no.value="";
     		formObj.new_agmt_lstm_cd.value="";
     		formObj.new_vndr_seq.value="";
     		formObj.new_vndr_lgl_eng_nm.value="";
     		formObj.old_agmt_no.readOnly=false;
     		formObj.old_agmt_no.className="input";
     		var obj=document.getElementById("btn_Retrieve");
        	obj.fireEvent("onclick");
 		}
 	}
    function processEndCal(){
   	 var form=document.form;
   	 var dt=ComReplaceStr(form.form_day.value,"-","");
   	 var dt2=ComReplaceStr(form.sts_evnt_dt.value,"-","");
        if(dt2 > dt){
       	 form.sts_evnt_dt.value="";
//       	 form.sts_evnt_dt.focus();
		 ComShowCodeMessage('CGM10059');
       	 return ;
	    }
    }
    // work javascript OnFocusOut event handling
    function obj_focusout() {
    	switch(event.srcElement.name){
    	case "sts_evnt_dt":
    		 var form=document.form;
	    	 var dt=ComReplaceStr(form.form_day.value,"-","");
	    	 var dt2=ComReplaceStr(form.sts_evnt_dt.value,"-","");;
	         if(form.sts_evnt_dt.value!="" &&  dt2 > dt){
	        	 form.sts_evnt_dt.value="";
//	        	 form.sts_evnt_dt.focus();
	        	 ComShowCodeMessage('CGM10059');
	        	 return;
	 	    }
	 		break;
    	}
    }
	function getBackEndJobStatus() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_cmd.value=COMMAND02;
 		var sXml=sheetObj.GetSearchData("EES_CGM_1026GS.do", FormQueryString(formObj));
		var jobState=ComGetEtcData(sXml, "jb_sts_flg");
		var jobErrMsg = ComGetEtcData(sXml, "jb_usr_err_msg");
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer1);
		} else if (jobState == "4") {
			ComShowMessage(jobErrMsg);
			ComOpenWait(false);
			sheetObj.SetWaitImageVisible(1);
			clearInterval(timer1);
		} else if (jobState == "5") {
			ComShowCodeMessage("CGM20038");
			clearInterval(timer1);
		}
	}
	function getBackEndJobLoadFile() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		
		ComShowCodeMessage("CGM00003");
		// retrieve
 		formObj.old_agmt_no.value=formObj.new_agmt_no.value;
 		formObj.old_agmt_ref_no.value=formObj.new_agmt_ref_no.value;
 		formObj.old_agmt_lstm_cd.value=formObj.new_agmt_lstm_cd.value;
 		formObj.old_vndr_seq.value=formObj.new_vndr_seq.value;
 		formObj.old_vndr_lgl_eng_nm.value=formObj.new_vndr_lgl_eng_nm.value;
 		formObj.new_agmt_no.value="";
 		formObj.new_agmt_ref_no.value="";
 		formObj.new_agmt_lstm_cd.value="";
 		formObj.new_vndr_seq.value="";
 		formObj.new_vndr_lgl_eng_nm.value="";
 		formObj.old_agmt_no.readOnly=false;
 		formObj.old_agmt_no.className="input";
 		
 		if(validateForm(sheetObj,formObj,IBSEARCH) != false) {
			// Retrieve 
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			// button ENABLE setting
			doActionBtnEnable("btn_Retrieve");
		}
	}
	/**
	 * function(ex:btn_save) role(trole) apply  <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version 
	 */
	 function tRoleApply() {
//	  	var formObj=document.form;
//	  	if(formObj.trole.value == "Authenticated") {
//			//do nothing
//	  	}else {
//		  	ComBtnDisable("btn_rowadd");
//		  	ComBtnDisable("btn_rowdelete");
//		  	ComBtnDisable("btn_Save");
//	  	}
	 }
	 
	 function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
		var formObj = document.form;
		if(sheetObj.RowCount()>0)
		{
				formObj.old_agmt_no.readOnly=true;
				formObj.old_agmt_no.className="input2";
				ComCgmEnableObject(formObj.btns_agmtno, false);
		}
		for(count_i=1; count_i<sheetObj.RowCount()+1; count_i++){
			var eqNo=sheetObj.GetCellValue(count_i, "eq_no");
	     	if(eqNo != ''){
	     		// Chassis No. Duplicate check
	     		//var checkDup = sheetObj.ColValueDup("eq_no", false);
	            var checkDup=-1;
	     		var cellValue=sheetObj.GetCellValue(count_i, "eq_no");
	     		for(i=1; i<sheetObj.RowCount()+1; i++){
	     			if(sheetObj.GetCellValue(i, "eq_no")== cellValue && count_i != i )
					{
						checkDup=1;
					}
				}
	     		if(checkDup == -1){
			     	formObj.f_cmd.value=SEARCH01;
					formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
					formObj.eq_no.value=eqNo;
 			 		var sXml=sheetObjects[1].GetSearchData("EES_CGM_1026GS.do" , FormQueryString(formObj), '', true);
			 		// data count
			 		var dataCount=ComGetTotalRows(sXml);
			 		// data existing
					if(dataCount > 0){
						if(ComGetEtcData(sXml,"aciac_div_cd") == 'I'){
							sheetObj.SetCellEditable(count_i, "del_chk",0);
							sheetObj.SetRowFontColor(count_i,"#FF0000");//
						} else {
							sheetObj.SetCellEditable(count_i, "del_chk",1);
							sheetObj.SetRowFontColor(count_i,"#000000");//
						}
			 			sheetObj.SetCellValue(count_i,"eq_no",ComGetEtcData(sXml,"eq_no"));
				     	sheetObj.SetCellValue(count_i,"eq_tpsz_cd",ComGetEtcData(sXml,"eq_tpsz_cd"));
				     	sheetObj.SetCellValue(count_i,"agmt_lstm_cd",ComGetEtcData(sXml,"agmt_lstm_cd"));
				     	sheetObj.SetCellValue(count_i,"sts_evnt_ofc_cd",ComGetEtcData(sXml,"sts_evnt_ofc_cd"));
				     	sheetObj.SetCellValue(count_i,"sts_evnt_yd_cd",ComGetEtcData(sXml,"sts_evnt_yd_cd"));
				     	sheetObj.SetCellValue(count_i,"vndr_seq",ComGetEtcData(sXml,"vndr_seq"));
				     	sheetObj.SetCellValue(count_i,"agmt_no",ComGetEtcData(sXml,"agmt_no"));
				     	sheetObj.SetCellValue(count_i,"agmt_ref_no",ComGetEtcData(sXml,"agmt_ref_no"));
				     	sheetObj.SetCellValue(count_i,"aciac_div_cd",ComGetEtcData(sXml,"aciac_div_cd"));
				     	sheetObj.SetCellValue(count_i,"eq_aset_sts_cd",ComGetEtcData(sXml,"eq_aset_sts_cd"));
				     	sheetObj.SetCellValue(count_i,"sts_evnt_loc_cd",ComGetEtcData(sXml,"sts_evnt_loc_cd"));
				     	sheetObj.SetCellValue(count_i,"agmt_ofc_cty_cd",ComGetEtcData(sXml,"agmt_ofc_cty_cd"));
				     	sheetObj.SetCellValue(count_i,"agmt_seq",ComGetEtcData(sXml,"agmt_seq"));
				     	sheetObj.SetCellValue(count_i,"agmt_ver_no",ComGetEtcData(sXml,"agmt_ver_no"));
				     	sheetObj.SetCellValue(count_i,"sts_evnt_dt",ComGetEtcData(sXml,"sts_evnt_dt"));
		     		} else {
		     			ComShowCodeMessage('CGM10012');
		     			sheetObj.SetCellEditable(count_i, "del_chk",1);
						sheetObj.SetRowFontColor(count_i,"#000000");
		     			sheetObj.SetCellValue(count_i,"eq_no","");
				     	sheetObj.SetCellValue(count_i,"eq_tpsz_cd","");
				     	sheetObj.SetCellValue(count_i,"agmt_lstm_cd","");
				     	sheetObj.SetCellValue(count_i,"sts_evnt_ofc_cd","");
				     	sheetObj.SetCellValue(count_i,"sts_evnt_yd_cd","");
				     	sheetObj.SetCellValue(count_i,"vndr_seq","");
				     	sheetObj.SetCellValue(count_i,"agmt_no","");
				     	sheetObj.SetCellValue(count_i,"agmt_ref_no","");
				     	sheetObj.SetCellValue(count_i,"aciac_div_cd","");
				     	sheetObj.SetCellValue(count_i,"eq_aset_sts_cd","");
				     	sheetObj.SetCellValue(count_i,"sts_evnt_loc_cd","");
				     	sheetObj.SetCellValue(count_i,"agmt_ofc_cty_cd","");
				     	sheetObj.SetCellValue(count_i,"agmt_seq","");
				     	sheetObj.SetCellValue(count_i,"agmt_ver_no","");
				     	sheetObj.SetCellValue(count_i,"sts_evnt_dt","");
//				     	sheetObj.focus();
				     	sheetObj.SelectCell(count_i,"eq_no",true);
		     		}
	     		} else {
	     			ComShowCodeMessage('CGM10017','Chassis No.');
	     			sheetObj.SetCellEditable(count_i, "del_chk",1);
					sheetObj.SetRowFontColor(count_i,"#000000");
	     			sheetObj.SetCellValue(count_i,"eq_no","");
			     	sheetObj.SetCellValue(count_i,"eq_tpsz_cd","");
			     	sheetObj.SetCellValue(count_i,"agmt_lstm_cd","");
			     	sheetObj.SetCellValue(count_i,"sts_evnt_ofc_cd","");
			     	sheetObj.SetCellValue(count_i,"sts_evnt_yd_cd","");
			     	sheetObj.SetCellValue(count_i,"vndr_seq","");
			     	sheetObj.SetCellValue(count_i,"agmt_no","");
			     	sheetObj.SetCellValue(count_i,"agmt_ref_no","");
			     	sheetObj.SetCellValue(count_i,"aciac_div_cd","");
			     	sheetObj.SetCellValue(count_i,"eq_aset_sts_cd","");
			     	sheetObj.SetCellValue(count_i,"sts_evnt_loc_cd","");
			     	sheetObj.SetCellValue(count_i,"agmt_ofc_cty_cd","");
			     	sheetObj.SetCellValue(count_i,"agmt_seq","");
			     	sheetObj.SetCellValue(count_i,"agmt_ver_no","");
			     	sheetObj.SetCellValue(count_i,"sts_evnt_dt","");
	     		}
	     	}
		}
	 }
	/* developer job end */

