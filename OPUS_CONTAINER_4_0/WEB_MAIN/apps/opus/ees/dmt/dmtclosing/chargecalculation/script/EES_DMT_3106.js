/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3106.js
*@FileTitle  : Manual Batch by POD ETA
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var IBGETPODETA=99;
var IBGETVDMVMT=98;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
          var sheetObj=sheetObjects[0];
          /*******************************************************/
          var formObj=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
             	case "btn_GetVDMVMT":
             		doActionIBSheet(sheetObj,formObj,IBGETVDMVMT);
					break;
 				case "btn_Save":
 					doActionIBSheet(sheetObj,formObj,IBSAVE);
 					break;
 				case "btn_Update":
 					processUpdate();
 					break;
 				case "btn_Close":
 					ComClosePopup(); 
 					break;
 				case "btns_calendar": 
					var cal=new ComCalendar();
					cal.select(formObj.upd_fm_dt, 'yyyy-MM-dd');
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
      * Register as an array IBSheet Object
      * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
      * Array defined at the top of the source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
         doInit();
         sheet1_OnLoadFinish();
     }
     function initControl() {
 		axon_event.addListener('blur',		'obj_blur',		'upd_fm_dt'); 
// 		axon_event.addListener('focus',		'obj_focus',	'upd_fm_dt'); 
 		//axon_event.addListener('keypress',	'obj_keypress',	'upd_fm_dt');
     }
     function obj_blur(){
    	ComChkObjValid(ComGetEvent());
     }
     /**
      * HTML Control Foucs in
      */
	function obj_focus(){
		var obj=ComGetEvent();
		ComClearSeparator(obj);
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
	}
	function obj_keypress() {
    	 switch(ComGetEvent().dataformat){
         	case "int":
    	        ComKeyOnlyNumber(ComGetEvent());
    	        break;
         	default:
	            ComKeyOnlyNumber(ComGetEvent());
    	 }
     }
     /**
      * initializing handling
      */
     function doInit() {
 		var formObj=document.form;
 		var sheetObj=sheetObjects[0];
 		var opener=window.dialogArguments;
 		if(!opener) opener=window.opener;
 		if(!opener) opener=parent;
 		var opnSheetObj=opener.sheet1;
 		var sXml=ComMakeSearchXml(opnSheetObj, false, "chk", "cntr_no|cntr_tpsz_cd|fm_mvmt_yd_cd|fm_mvmt_dt|bkg_no|bl_no|vvd_cd|svr_id|cntr_cyc_no|ar_act_cd|cnee_cd|ntfy_cd");
 		sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
 		var callFlag=ComGetObjValue(formObj.call_flag);
 		if(callFlag == 'bybkg') {
 			var opnFormObj=opener;
 			var bkgNo=ComGetObjValue(opnFormObj.form.bkg_no);
 			var blNo=ComGetObjValue(opnFormObj.form.bl_no);
 			var vvdCd=ComGetObjValue(opnFormObj.form.vvd_cd);
 			var arActCd=ComGetObjValue(opnFormObj.form.ar_act_cd);
 			var cneeCd=ComGetObjValue(opnFormObj.form.cnee_cd);
 			var ntfyCd=ComGetObjValue(opnFormObj.form.ntfy_cd);
 			for(var i=sheetObj.GetTopRow(); i <= sheetObj.LastRow(); i++) {
     			sheetObj.SetCellValue(i, "bkg_no",bkgNo,0);
     			sheetObj.SetCellValue(i, "bl_no",blNo,0);
     			sheetObj.SetCellValue(i, "vvd_cd",vvdCd,0);
     			sheetObj.SetCellValue(i, "ar_act_cd",arActCd,0);
     			sheetObj.SetCellValue(i, "cnee_cd",cneeCd,0);
     			sheetObj.SetCellValue(i, "ntfy_cd",ntfyCd,0);
     		}
 		}
  	}
	function sheet1_OnLoadFinish() {
  		var formObj=document.form
  		var sheetObj=sheetObjects[0];
  		sheetObj.SetWaitImageVisible(0);
  		doActionIBSheet(sheetObj,formObj,IBGETPODETA);
//   		sheetObj.CheckAll("chk",1);
   		DmtComEnableManyBtns(false, "btn_Save", "btn_Update");
   		sheetObj.SetWaitImageVisible(1);
	}  
   /**
      * Sheet the initial setting, the header definition
      * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
      * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      // sheet1 init
            	    with(sheetObj){
	               var HeadTitle="||Seq.|CNTR No.|T/S|From YD|From DT|BKG No.|B/L No.|VVD CD|ETA";
	               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                      {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
	                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                      {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fm_mvmt_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                      {Type:"Date",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ar_act_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cnee_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ntfy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                
	               InitColumns(cols);
	               SetEditable(1);
	               SetShowButtonImage(2);
	               SetSheetHeight(300);
               } // with - end
                 break;
             case 2:      // sheet1 init
                 with(sheetObj){
		              var HeadTitle="|Seq.|CNTR No.|From YD|From DT|BKG No.";
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                  {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fm_mvmt_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fm_mvmt_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
                       } // with - end


                 break;    
         } // swith - end
     }
   // Sheet processing-related processes
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         	case IBGETPODETA:	
				formObj.f_cmd.value=MULTI01;
				sheetObj.DoAllSave("EES_DMT_3106GS.do", FormQueryString(formObj));
				break;
 			case IBGETVDMVMT:
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				formObj.f_cmd.value=MULTI02;
 				var sheetObj2=sheetObjects[1];
 				sheetObj2.DoAllSave("EES_DMT_3106GS.do", FormQueryString(formObj));
 				break;
 			case IBSAVE:		
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				//formObj.f_cmd.value = MULTI;
 				//sheetObj.DoSave("EES_DMT_3106GS.do", FormQueryString(formObj),"chk");
	 			ComOpenWait(true);
	         	sheetObj.SetWaitImageVisible(0);
	         	formObj.f_cmd.value=COMMAND01;
	         	ComSetObjValue(formObj.backendjob_id, "MPODETA");
	         	var params=sheetObj.GetSaveString(false, true, "chk") + "&" + FormQueryString(formObj);
 	         	var sXml=sheetObj.GetSaveData("EES_DMT_3106GS.do", params);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitImageVisible(0);
					sheetObj.SetWaitTimeOut(10000);
					timer=setInterval(getBackEndJobStatus, 3000); 
				}
 				break;
         }
     }
   function getBackEndJobStatus() {
 	 	var formObj=document.form;
 	 	var sheetObj=sheetObjects[0];
 	 	//It gets a status of backendjob. 2
 	 	ComSetObjValue(formObj.f_cmd, COMMAND02);
 	 	var params="f_cmd=" + COMMAND02 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
  	 	var sXml=sheetObj.GetSearchData("EES_DMT_3106GS.do", params);
 	 	var jobState=ComGetEtcData(sXml, "jb_sts_flg");
 	 	// jobState == "2" BackEndJob running......
 	 	if (jobState == "3") {
 	 		clearInterval(timer);
 	 		// BackEndJob success
 	 		getBackEndJobLoadFile();
 	 	}
 	 	else if (jobState == "4") {
 	 		clearInterval(timer);
 	 		// BackEndJob failed
 	 		var jbUsrErrMsg=ComGetEtcData(sXml, "jb_usr_err_msg");
 	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
 	 			ComShowMessage(jbUsrErrMsg);
 	 		else
 	 			ComShowCodeMessage("DMT01125");
 	 		ComOpenWait(false);
 	 	}
 	 	else if (jobState == "5") {
 	 		clearInterval(timer);
 	 		ComShowCodeMessage("DMT01125");
 	 		ComOpenWait(false);
 	 	}
	}
 	function getBackEndJobLoadFile() {
 	 	var formObj=document.form;
 	 	var sheetObj=sheetObjects[0];
 	 	//It returns a result. 3
 	 	ComOpenWait(false);
 	 	var fCmd=MULTI;
 	 	ComSetObjValue(formObj.f_cmd, fCmd);
 	 	var params="f_cmd=" + fCmd + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
  	 	var sXml=sheetObj.GetSaveData("EES_DMT_3106GS.do", params);
  	 	sheetObj.LoadSaveData(sXml);
 	}
	function sheet1_OnClick(sheetObj, row, col, Value){
 		if(sheetObj.ColSaveName(col) == "chk")
 			ComSyncAllCheck(sheetObj, col, Value);
 	}
	function sheet1_OnPopupClick(sheetObj, row,col){
		if (sheetObj.ColSaveName(col) == "fm_mvmt_dt") {
			var cal=new ComCalendarGrid("myCal");
			cal.select(sheetObj, row, col, 'yyyy-MM-dd');
		}
	}
  	function sheet1_OnSaveEnd(sheetObj, code, ErrMsg) {
  		if(ErrMsg == '') {
  			if(document.form.f_cmd.value == MULTI) {
				ComPopUpReturnValue("Y");
  			}
  			sheetObj.CheckAll("chk",1);
  		}
  	}
  	function sheet2_OnSaveEnd(sheetObj, code, ErrMsg) {
  		if(ErrMsg == '') {
  			var formObj=document.form;
  			var sheetObj1=sheetObjects[0];
  			for(var i=sheetObj.GetTopRow(); i <= sheetObj.LastRow(); i++) {
  				var fmMvmtDt=sheetObj.GetCellValue(i, "fm_mvmt_dt");
  				var seq=sheetObj.GetCellValue(i, "seq");
  				var rowIdx=sheetObj1.FindText("seq", seq);
  				if(rowIdx != -1)
  					sheetObj1.SetCellValue(rowIdx, "fm_mvmt_dt",fmMvmtDt);
  			}
  			DmtComEnableManyBtns(true, "btn_Save", "btn_Update");
  		}
  	}
     function processUpdate() {
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0];
    	 if(!ComIsDate(formObj.upd_fm_dt, "ymd")) {
    		 ComShowCodeMessage('DMT02002', 'Update From Date');
    		 ComSetFocus(formObj.upd_fm_dt);
    		 return;
    	 }
    	 /*
    	 ComChkPeriod(fromDate, toDate)
    	 0 : fromDate > toDate
    	 1 : fromDate < toDate
    	 2 : fromDate=toDate
    	 */
    	 var updFmDt=ComGetUnMaskedValue(formObj.upd_fm_dt, "ymd");
    	 var ofcCurrDate=DmtComOfficeCurrDate(sheetObj, formObj);
		 if(ComChkPeriod(updFmDt, ofcCurrDate) == 1) {
  			ComShowCodeMessage('DMT01062');
  			ComSetFocus(formObj.upd_fm_dt);
  			return;
		 }
		 if(sheetObj.CheckedRows("chk") == 0) {
  			ComShowCodeMessage('COM12113', 'CNTR');
  			return;
		 }
		 var chkRows=sheetObj.FindCheckedRow("chk").split("|");
		 for(var i=0; i < chkRows.length; i++) {
			 sheetObj.SetCellValue(chkRows[i], "fm_mvmt_dt",updFmDt);
		 }
     }     
     /**
      * Screen input form validation process for handling
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction) {
        	 	case IBGETVDMVMT:
        	 		if(sheetObj.CheckedRows("chk") == 0) {
        	  			ComShowCodeMessage('COM12113', 'CNTR');
        	  			return false;
        			 }
        	 		var sheetObj2=sheetObjects[1];
        	 		var sXml=ComMakeSearchXml(sheetObj, false, "chk", "seq|cntr_no|fm_mvmt_yd_cd|bkg_no");
        	 		sheetObj2.RemoveAll();
        	 		sheetObj2.LoadSearchData(sXml,{Append:1 , Sync:1} );
	    	 		break;
	    	 	case IBSAVE:
	    	 		var chkRows=sheetObj.CheckedRows("chk");
	    	 		if(chkRows == 0) {
             			ComShowCodeMessage('COM12113', 'CNTR');
             			return false;
             		} else if(chkRows > 100) {
             			ComShowCodeMessage('DMT01080', '100 cntrs');
             			return false;
             		}
             		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length; i++) {
             			var chkRow=chkRows[i];
             			var fmMvmtDt=sheetObj.GetCellValue(chkRow, "fm_mvmt_dt");
             			var cntrNo=sheetObj.GetCellValue(chkRow, "cntr_no");
         				if(fmMvmtDt == '') {
         					ComShowCodeMessage('DMT01064', 'From Date', cntrNo);
         					sheetObj.SetSelectRow(chkRow);
         					return false;
         				}
         		    	 /*
         		    	 ComChkPeriod(fromDate, toDate)
         		    	 0 : fromDate > toDate
         		    	 1 : fromDate < toDate
         		    	 2 : fromDate=toDate
         		    	 */
         		    	 var ofcCurrDate=DmtComOfficeCurrDate(sheetObj, formObj);
         				 if(ComChkPeriod(fmMvmtDt, ofcCurrDate) == 1) {
         		  			ComShowCodeMessage('DMT01062');
         		  			sheetObj.SetSelectRow(chkRow);
         		  			return false;
         				 }
         				 var etaDt=sheetObj.GetCellValue(chkRow, "vps_eta_dt");
         				 var dtGap=ComGetDaysBetween(fmMvmtDt, etaDt);
         				 if(Math.abs(dtGap) > 10) {
         					ComShowCodeMessage('DMT01055', cntrNo);
         					sheetObj.SetSelectRow(chkRow);
         					return false;
         				 }
             		}
            		var dupRows = sheetObj.ColValueDupRows("chk|cntr_no");
            		if(dupRows != '') {
    	        		var arrRow=dupRows.split(",");
    	        		for(var i=0; i<arrRow.length; i++) {
    	        			var chk=sheetObj.GetCellValue(arrRow[i], "chk");
    	        			if(chk == '0')
    	        				continue;
    	        			else {
    	        				var dupCntrNo=sheetObj.GetCellValue(arrRow[i], "cntr_no");
    	    		        	ComShowCodeMessage('DMT01065', dupCntrNo);
    	    		        	sheetObj.SetSelectRow(arrRow[i]);
    	    		        	return false;
    	        			}
    	        		}
            		}
             		if(!ComShowCodeConfirm('DMT01056'))
             			return false;
	    	 		break;
        	 }		
         }
         return true;
     }
	/* Developer's task end */
