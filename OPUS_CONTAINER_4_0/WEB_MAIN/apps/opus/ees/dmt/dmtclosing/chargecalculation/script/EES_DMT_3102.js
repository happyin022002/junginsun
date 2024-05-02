/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3102.jsp
*@FileTitle  : Split Payment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_DMT_3102 :  business script for EES_DMT_3102.
     */
 // Common Global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Yard Code Validation
 var IBCHKYARDCD=99;
 var DEF_SHEET_HEIGHT = 220;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** case in Sheet count are more two by Tab, defining adding sheet *****/
          var sheetObj=sheetObjects[0];
          /*******************************************************/
          var formObj=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
 				case "btn_RowInsert":
 					processRowInsert(sheetObj);
 					break;
 				case "btn_Delete":
 					processRowDel(sheetObj);
 					break;
 				case "btn_Update":
 					processUpdate();
 					break;
 				case "btn_Save":
 					doActionIBSheet(sheetObj,formObj,IBSAVE);
 					break;
 				case "btn_Close":
 					ComClosePopup(); 
 					break;
 				case "btns_calendar": //Calendar button
					var cal=new ComCalendar();
					cal.select(formObj.upd_dt, 'yyyy-MM-dd');
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
      * IBSheet Grid capabilities to handle the RowAdd button.
      */
     function processRowInsert(sheetObj) {
    	 sheetObj.SetDataAutoTrim(0);
    	 with(sheetObj) {
    		 // check not enter the "To Date" 
    		 for(var i=GetTopRow(); i < LastRow(); i++) {
    			 if(GetCellValue(i, "to_mvmt_dt") == '') {
 	 				ComShowCodeMessage('DMT02002', 'To Date');
	 				SelectCell(i, "to_mvmt_dt");
	 				return;
 	 			}
    			 if(GetCellValue(i, "to_mvmt_yd_cd") == '') {
 	 				ComShowCodeMessage('DMT02002', 'To Yard');
	 				SelectCell(i, "to_mvmt_yd_cd");
	 				return;
 	 			}
    		 }
    		 var currRow=GetSelectRow();
    		 if(GetCellValue(currRow, "dmdt_ar_if_cd") == 'Y') {
    			 ComShowCodeMessage('DMT01024');
    			 return;
    		 }
    		 if(GetCellValue(currRow, "dmdt_chg_sts_cd") == 'I' && GetCellValue(currRow, "dmdt_ar_if_cd") == 'N') {
    			 if(!ComShowCodeConfirm('DMT01025'))
    				 return;
    			 SetCellValue(currRow, "partial_mark",'Y',0);
    		 }
    		 var newRow=DataCopy();
        	 currRow=newRow-1;
        	 SetCellEditable(currRow, "to_mvmt_dt",1);
        	 SetCellEditable(currRow, "to_mvmt_yd_cd",1);
        	 var toMvmtDt=GetCellValue(currRow, "to_mvmt_dt");
        	 var toMvmtYdCd=GetCellValue(currRow, "to_mvmt_yd_cd");
        	 var toMvmtStsCd=GetCellValue(currRow, "to_mvmt_sts_cd");
	    	 SetCellValue(currRow, "to_mvmt_dt",'',0);
	    	 SetCellValue(currRow, "to_mvmt_sts_cd","DR",0);
	    	 if(toMvmtYdCd == '') {
	    		 var fmMvmtYdCd=GetCellValue(currRow, "fm_mvmt_yd_cd");
	    		 SetCellValue(currRow, "to_mvmt_yd_cd",fmMvmtYdCd,0);
	    		 toMvmtYdCd=fmMvmtYdCd;
	    	 }
	    	 // Row added an item to be set.
	    	 SetCellValue(newRow, "fm_mvmt_dt",'',0);
	    	 SetCellValue(newRow, "fm_mvmt_yd_cd",toMvmtYdCd);
	    	 SetCellValue(newRow, "fm_mvmt_sts_cd",'DR',0);
	    	 SetCellValue(newRow, "to_mvmt_dt",toMvmtDt,0);
	    	 SetCellValue(newRow, "to_mvmt_sts_cd",toMvmtStsCd,0);
	    	 SetCellValue(newRow, "chg_type",'B',0);
	    	 SetCellValue(newRow, "partial_mark",'',0);
//	    	 CellValue2(newRow, "ofc_trns_flg")		= 'N';
//	    	 CellValue2(newRow, "act_cnt_cd")		= '';
//	    	 CellValue2(newRow, "bzc_trf_aply_dt")	= '';
	    	 SetCellValue(newRow, "calc_dt",'',0);
	    	 SetCellValue(newRow, "cfm_dt",'',0);
	    	 SetCellValue(newRow, "cfm_ofc_cd",'',0);
	    	 SetCellValue(newRow, "cfm_usr_id",'',0);
	    	 SetCellValue(newRow, "chg_seq",'',0);
	    	 SetCellValue(newRow, "corr_rmk",'',0);
	    	 SetCellValue(newRow, "cre_dt",'',0);
	    	 SetCellValue(newRow, "cre_ofc_cd",'',0);
	    	 SetCellValue(newRow, "cre_usr_id",'',0);
	    	 //CellValue2(newRow, "cust_seq")			= '';
	    	 SetCellValue(newRow, "dmdt_ar_if_cd",'',0);
	    	 SetCellValue(newRow, "dmdt_chg_sts_cd",'',0);
	    	 SetCellValue(newRow, "dmdt_inv_no",'',0);
	    	 SetCellValue(newRow, "mvmt_umch_seq",'',0);
	    	 SetCellValue(newRow, "rfa_expt_mapg_seq",'',0);
	    	 SetCellValue(newRow, "rfa_expt_ver_seq",'',0);
	    	 SetCellValue(newRow, "sc_rfa_expt_aply_dt",'',0);
	    	 SetCellValue(newRow, "web_cre_dt",'',0);
	    	 SetCellValue(newRow, "web_cre_usr_id",'',0);
	    	 SetCellValue(newRow, "web_ind_flg",'',0);
	    	 SetCellValue(newRow, "web_mty_dt",'',0);
	    	 SetCellValue(newRow, "web_ntfy_pic_nm",'',0);
	    	 SetCellValue(newRow, "web_ntfy_pic_telcm_no",'',0);
	    	 SelectCell(currRow, "to_mvmt_dt");
    	 }
     }
     /**
      * IBSheet Grid capabilities to handle the RowDelete button.
      */
     function processRowDel(sheetObj) {
    	 with(sheetObj) {
	    	 var delRow=GetSelectRow();
	    	 if(delRow == GetTopRow()) {
	    		 ComShowCodeMessage('DMT01070');
				return;
	    	 }
	    	 if(GetCellValue(delRow, "dmdt_chg_sts_cd") == 'I') {
	    		 ComShowCodeMessage('DMT01026');
	    		 return;
	    	 }
	    	 if(GetCellValue(delRow, "cre_usr_id") != '') {
	    		 ComShowCodeMessage('DMT01071');
	    		 return;
	    	 }
	    	 // To Delete Row If the last Row, prior Row entries should Setting. 
	    	 if(delRow == LastRow()) {
	    		 var prevRow=delRow-1;
	    		 SetCellValue(prevRow, "to_mvmt_dt",GetCellValue(delRow, "to_mvmt_dt"),0);
	    		 SetCellValue(prevRow, "to_mvmt_yd_cd",GetCellValue(delRow, "to_mvmt_yd_cd"),0);
	    		 SetCellValue(prevRow, "to_mvmt_sts_cd",GetCellValue(delRow, "to_mvmt_sts_cd"),0);
	    		 //CellValue2(prevRow, "dmdt_chg_sts_cd")	= CellValue(delRow, "dmdt_chg_sts_cd");
	    	 } else {
	    		 // To Delete Row If not the last Row, Row to delete some of the items directly to the next row Setting.
	    		 var nextRow=delRow + 1;
	    		 SetCellValue(nextRow, "fm_mvmt_dt",GetCellValue(delRow, "fm_mvmt_dt"),0);
	    		 SetCellValue(nextRow, "fm_mvmt_yd_cd",GetCellValue(delRow, "fm_mvmt_yd_cd"),0);
	    		 SetCellValue(nextRow, "fm_mvmt_sts_cd",GetCellValue(delRow, "fm_mvmt_sts_cd"),0);
	    		 //CellValue2(nextRow, "dmdt_chg_sts_cd")	= CellValue(delRow, "dmdt_chg_sts_cd");
	    	 }
	    	 RowDelete(delRow, false);
	    	 if(GetCellEditable(LastRow(), "to_mvmt_dt")) {
	    		 SetCellEditable(LastRow(), "to_mvmt_dt",0);
	    		 SetCellEditable(LastRow(), "to_mvmt_yd_cd",0);
	    	 }
    	 }
     }
     /**
      * Update button Function is processed.
      */
     function processUpdate() {
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0];
    	 var updDt=ComGetUnMaskedValue(formObj.upd_dt, "ymd");
    	 if(updDt != '') {
    		 //ComShowCodeMessage('DMT00102', 'Update Date');
    		 //return;
	    	 /*
	    	 ComChkPeriod(fromDate, toDate)
	    	 0 : fromDate > toDate
	    	 1 : fromDate < toDate
	    	 2 : fromDate=toDate
	    	 */
    		 //var currDt = ComGetNowInfo();
    		 var currDt=DmtComOfficeCurrDate(sheetObj, formObj);
    		 if(ComChkPeriod(updDt, currDt) != 1) {
	  			ComShowCodeMessage('DMT01022');
	  			ComSetFocus(formObj.upd_dt);
	  			return;
    		 }
    		 for(var i=sheetObj.GetTopRow(); i <= sheetObj.LastRow(); i++) {
    			 sheetObj.SetCellValue(i, "to_mvmt_dt",updDt);
    		 }
    	 }
    	 var updYdCd=ComGetObjValue(formObj.upd_yd_cd);
    	 if(updYdCd != '') {
    		 for(var i=sheetObj.GetTopRow(); i <= sheetObj.LastRow(); i++) {
    			 sheetObj.SetCellValue(i, "to_mvmt_yd_cd",updYdCd);
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
         doInit();
	}
	function doInit() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		/*
		var dmdtTrfCd=ComGetObjValue(formObj.dmdt_trf_cd);
		var toMvmtStsCds; 
		switch(dmdtTrfCd) {
			case "DMIF" :
				toMvmtStsCds='ID|EN|TN|DR';
				break;
			case "DMOF" :
				toMvmtStsCds='VL|EN|TN|DR';
				break;
			case "DTIC" :
				toMvmtStsCds='MT|DR';
				break;
			case "DTOC" :
				toMvmtStsCds='OC|DR';
				break;
			case "CTIC" :
				toMvmtStsCds='MT|DR';
				break;
			case "CTOC" :
				toMvmtStsCds='VL|DR';
				break;
		} */
		//sheetObj.InitDataCombo(0,  "to_mvmt_sts_cd", toMvmtStsCds, toMvmtStsCds);
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		//var toMvmtYdCd = sheetObj.CellValue(sheetObj.TopRow, "to_mvmt_yd_cd")
		//ComSetObjValue(formObj.upd_yd_cd, toMvmtYdCd);
	}
	function initControl() {
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- out of focus
		axon_event.addListenerFormat('focus',	'obj_focus',	form); // Get focus
		axon_event.addListenerFormat('keypress','obj_keypress', form); //- on press keyboard
		//axon_event.addListener('blur',	'sheet_blur', 'sheet1'); //- sheet focus out
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		//axon_event.addListenerForm('keydown', 'ComKeyEnter', document.form, 'corr_rmk');
	}
	// out of focus
	function obj_blur(){
		//check inputing Validation + Inserting separator 
		var obj=event.srcElement;
		ComChkObjValid(obj);
	}
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
        ComClearSeparator(event.srcElement);
    }
	//business javascript OnKeyPress event handling
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
         	case "engup":
		    	// upper case + numbers 
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        //only numbers
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	default:
	         	// only numbers(integer, date, time)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
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
		        
		      var HeadTitle="|Seq.|CNTR No.|T/S|G/B|Office|From|From|From|To|To|To|INV No.|Split|A/R";
		      var HeadTitle1="|Seq.|CNTR No.|T/S|G/B|Office|Date|Yard|STS|Date|Yard|STS|INV No.|Split|A/R";

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"},
		                  { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_type",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1,  ToolTipText:"General/Balance Charge Type"},
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"partial_mark",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_ar_if_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"corr_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mvmt_umch_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_yr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_split_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_yr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_split_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_grp_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rfa_expt_apro_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rfa_expt_dar_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rfa_rqst_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"aft_expt_apro_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"aft_expt_dar_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"aft_expt_adj_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sc_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sc_expt_ver_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sc_expt_grp_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"act_cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"act_cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cfm_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cfm_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cfm_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ofc_trns_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"calc_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"web_ind_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"web_cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"web_cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"web_ntfy_pic_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"web_ntfy_pic_telcm_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"web_mty_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svr_id",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"inv_dtl_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dul_tp_expt_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cxl_bkg_chg_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ofc_rhq_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetSheetHeight(DEF_SHEET_HEIGHT);
		      SetEditable(1);
		      SetColProperty(0 ,"to_mvmt_yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		      //no support[check again]CLT 					ToolTipOption="balloon:true;width:50;";
		      } // with end


				break;
         } // switch end
     }
	// Process of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
	     sheetObj.ShowDebugMsg(false);
	     switch(sAction) {
	        case IBSEARCH:     // Search
	        	//if(!validateForm(sheetObj,formObj,sAction)) return;
	        	sheetObj.SetWaitImageVisible(1);
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("EES_DMT_3102GS.do", FormQueryString(formObj) );
                break;
	        case IBSAVE:        // save
	        	if(!validateForm(sheetObj,formObj,sAction)) return;
				//formObj.f_cmd.value = MULTI;
				//sheetObj.DoAllSave("EES_DMT_3102GS.do", FormQueryString(formObj));
	        	sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
	         	formObj.f_cmd.value=COMMAND01;
	         	ComSetObjValue(formObj.backendjob_id, "PARTIAL");
	         	var params=sheetObj.GetSaveString(true, true) + "&" + FormQueryString(formObj);
	         	var sXml=sheetObj.GetSaveData("EES_DMT_3102GS.do", params);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitImageVisible(0);
					sheetObj.SetWaitTimeOut(10000);
					timer=setInterval(getBackEndJobStatus, 3000); // After three seconds, running getBackEndJobStatus function - a recursive call
				}
	        	break;
	        case IBCHKYARDCD:
	        	formObj.f_cmd.value=SEARCH14;
	        	sheetObj.SetWaitImageVisible(0);
	        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
	    		sheetObj.SetWaitImageVisible(1);
	    		var data=ComGetEtcData(sXml, "YD");
	    		if (data != undefined && data != '') {
					ComSetObjValue(formObj.yd_cd1, "Y");
				} else {
					ComSetObjValue(formObj.yd_cd1, "N");
				}
	        	break;
	     }
     }
	 /**
	 * Status of BackEndJob a '3 'to make sure when.
	 */
	 function getBackEndJobStatus() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[0];
	 	//It gets a status of backendjob. 2
	 	ComSetObjValue(formObj.f_cmd, COMMAND02);
	 	var params="f_cmd=" + COMMAND02 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml=sheetObj.GetSearchData("EES_DMT_3102GS.do", params);
	 	var jobState=ComGetEtcData(sXml, "jb_sts_flg");
	 	// jobState == "2" BackEndJob Progress......
	 	if (jobState == "3") {
	 		clearInterval(timer);
	 		// BackEndJob success.
	 		getBackEndJobLoadFile();
	 	}
	 	else if (jobState == "4") {
	 		clearInterval(timer);
	 		// Failure BackEndJob.
	 		var jbUsrErrMsg=ComGetEtcData(sXml, "jb_usr_err_msg");
	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
	 			ComShowMessage(jbUsrErrMsg);
	 		else
	 			ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	 	else if (jobState == "5") {
	 		clearInterval(timer);
	 		// BackEndJob already have read the resulting file.
	 		ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	 }
	//At the end of BackEndJob success is a reflection of the resulting data.
	function getBackEndJobLoadFile() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[0];
	 	var fCmd=MULTI;
	 	ComSetObjValue(formObj.f_cmd, fCmd);
	 	var params="f_cmd=" + fCmd + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml=sheetObj.GetSaveData("EES_DMT_3102GS.do", params);
		sheetObj.LoadSaveData(sXml, {Sync:1});
	 	ComOpenWait(false);
	}
	/*
	function sheet_blur() {
		var sheetObj=sheetObjects[0];
		sheet1_OnSelectCell(sheetObj, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), 0, 0);
	}
	function sheet1_OnSelectCell(sheetObj, row, col, newRow, newCol) {
		with(sheetObj) {
			var colName=ColSaveName(col);
			if(colName != 'to_mvmt_dt') return;
			if(row == LastRow()|| newRow == LastRow()) return;
var value=GetCellValue(row, col);
			if(ComIsEmpty(value)) {
				ComShowCodeMessage('DMT03028', 'To date');
				SelectCell(row, col);
				return;
			}
		}
	}*/
	 /*
	  * That occurs when the cell value is changed Event OnAfterEdit
	  */
	  function sheet1_OnChange(sheetObj, row, col, value) {
		 with(sheetObj) {
			 SetDataAutoTrim(0);
			 if(row == LastRow()) return;
			 var colName=ColSaveName(col);
			 if(colName == 'to_mvmt_dt' || colName == 'to_mvmt_yd_cd' || colName == 'to_mvmt_sts_cd') {
				 var formObj=document.form;
				 var childRow=row+1;
				 if(colName == 'to_mvmt_dt') {
					 var fmMvmtDt=GetCellValue(row, "fm_mvmt_dt");
					 var toMvmtDt=GetCellValue(childRow, "to_mvmt_dt");
					if(toMvmtDt == '' && childRow == LastRow()) {
						//toMvmtDt = ComGetNowInfo();
						toMvmtDt=DmtComOfficeCurrDate(sheetObj, formObj);
					}
					if(ComChkPeriod(fmMvmtDt, value) != 1 || ComChkPeriod(value, toMvmtDt) == -1) {
			  			ComShowCodeMessage('DMT01023');
			  			SetCellValue(row, "to_mvmt_dt","",0);// input date clear
			  			SelectCell(row, "to_mvmt_dt");
			  			return;
		    		}
					// 'G' split
					if(row == GetTopRow()) {
						fmMvmtDt=GetCellValue(row, "ft_end_dt");
						/*
				    	 ComChkPeriod(fromDate, toDate)
				    	 0 : fromDate > toDate
				    	 1 : fromDate < toDate
				    	 2 : fromDate=toDate
				    	 */
						if(ComChkPeriod(fmMvmtDt, value) != 1 || ComChkPeriod(value, toMvmtDt) == -1) {
							ComShowCodeMessage('DMT01073');
				  			SetCellValue(row, "to_mvmt_dt","",0);// input date clear
				  			SelectCell(row, "to_mvmt_dt");
				  			return;
			    		 }
					}
					SetCellValue(childRow, 'fm_mvmt_dt',value,0);
				 } else if(colName == 'to_mvmt_yd_cd') {
					 var isValid=true;
					 if(value == '') {
						 SetCellValue(row, 'to_mvmt_yd_cd','',0);
						 SetCellValue(childRow, 'fm_mvmt_yd_cd','',0);
						 return;
					 } else if(value.length < 7) {
						 isValid=false;
					 } else {
						 ComSetObjValue(formObj.yd_cd1, value);
						 // To Yard Code Validaion
						 doActionIBSheet(sheetObj, formObj, IBCHKYARDCD);
						 if(ComGetObjValue(formObj.yd_cd1) == 'N')
							 isValid=false;
					 }
					 if(!isValid) {
						 ComShowCodeMessage('DMT00110', 'Yard');
						 SetCellValue(row, 'to_mvmt_yd_cd','',0);
						 SetCellValue(childRow, 'fm_mvmt_yd_cd','',0);
						 return;
					 }
					 SetCellValue(childRow, 'fm_mvmt_yd_cd',value,0);
				 } else
					 SetCellValue(childRow, 'fm_mvmt_sts_cd',value,0);
			 }
		 }
	 }
	 /*
	  * searching function is complete, the query raised by an Event
	  */
	function sheet1_OnSearchEnd(sheetObj, code,  ErrMsg) {
		var formObj=document.form;
		var cntrTpszCd=ComGetObjValue(formObj.cntr_tpsz_cd);	
		with(sheetObj) {
			for(var i=2; i <= LastRow(); i ++) {
				SetCellValue(i, "cntr_tpsz_cd",cntrTpszCd,0);
				//CellEditable(Row, Col) = true;
			}
		}
	}
	/**
     * After saving handling
     */
    function sheet1_OnSaveEnd(sheetObj, code, ErrMsg) {
    	// handling success
    	if(ErrMsg != '') return;
		ComShowCodeMessage('DMT00007');
		var opener=window.dialogArguments;
		if (!opener) opener=parent;
		opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
		ComClosePopup(); 
    }
	/**
	  * handling process for input validation
	  */
	 function validateForm(sheetObj,formObj,sAction){
		 with(formObj){
	    	 var chgStsCd=ComGetObjValue(dmdt_chg_sts_cd);
	    	 switch(sAction) {
	    	 	case IBSAVE:
	    	 		for(var i=sheetObj.GetTopRow(); i < sheetObj.LastRow(); i++) {
	    	 			if(sheetObj.GetCellValue(i, "to_mvmt_dt") == '') {
	    	 				ComShowCodeMessage('DMT02002', 'To Date');
	    	 				sheetObj.SelectCell(i, "to_mvmt_dt");
	    	 				return false;
	    	 			}
	    	 			if(sheetObj.GetCellValue(i, "to_mvmt_yd_cd") == '') {
	    	 				ComShowCodeMessage('DMT02002', 'To Yard');
	    	 				sheetObj.SelectCell(i, "to_mvmt_yd_cd");
	    	 				return false;
	    	 			}
	    	 			var arIfCd=sheetObj.GetCellValue(i, "dmdt_ar_if_cd");
	    	 			if(arIfCd == 'Y') {
	    	 				ComShowCodeMessage('DMT01024');
	    	 				return false;
	    	 			}
	    	 			if(chgStsCd == 'I' && arIfCd == 'N') {
	    	 				if(!ComShowCodeConfirm('DMT01025'))
	    	 					return false;
	    	 			}
	    	 			// Web MT Notification is being processed, To Movement Status is "DR", then 
	    	 			// After the message output "YES" if you select the Web Indicator to "N" Save Setting and progress
	    	 			var webIndFlg=sheetObj.GetCellValue(i, "web_ind_flg");
	    	 			var toMvmtStsCd=sheetObj.GetCellValue(i, "to_mvmt_sts_cd");
	    	 			if(webIndFlg == 'Y' && toMvmtStsCd == 'DR') {
	    	 				if(ComShowCodeConfirm('DMT01027')) {
	    	 					sheetObj.SetCellValue(i, "web_ind_flg","N",0);
	    	 				} else
	    	 					return false;
	    	 			}
	    	 		} // for - end
	    	 		if(sheetObj.GetCellValue(sheetObj.LastRow(), "to_mvmt_sts_cd") == "DR") {
	    	 			//var lastToMvmtDt = sheetObj.CellValue(sheetObj.LastRow, "to_mvmt_dt");
	    	 			//var currDt = ComGetNowInfo();
	    	 			var currDt=DmtComOfficeCurrDate(sheetObj, formObj);
	    	 			for(var i=sheetObj.GetTopRow(); i < sheetObj.LastRow(); i++) {
	    	 				var toMvmtDt=sheetObj.GetCellValue(i, "to_mvmt_dt");
		    	    		 if(ComChkPeriod(toMvmtDt, currDt) != 1) {
		    		  			ComShowCodeMessage('DMT01046');
		    		  			return false;
		    	    		 }
		    	 		}
	    	 			 /*
	    		    	 ComChkPeriod(fromDate, toDate)
	    		    	 0 : fromDate > toDate
	    		    	 1 : fromDate < toDate
	    		    	 2 : fromDate=toDate
	    		    	 */
	    	 		}
	    	 		with(sheetObj) {
		    	 		for(var i=GetTopRow(); i <= LastRow(); i++) {
		    	 			// adding Row
		    	 			if(GetCellValue(i, "cre_usr_id") == '') {
		    	 				if(GetCellValue(i, "to_mvmt_dt") != '')
		    	 					SetCellValue(i, "dmdt_chg_sts_cd",'F',0);
		    	 				else
		    	 					SetCellValue(i, "dmdt_chg_sts_cd",'L',0);
		    	 			}
		    	 		}
	    	 		}
	    	 		break;
	    	 } // switch - end
	     } // with -end
		 //return false;
	     return true;
	 }
