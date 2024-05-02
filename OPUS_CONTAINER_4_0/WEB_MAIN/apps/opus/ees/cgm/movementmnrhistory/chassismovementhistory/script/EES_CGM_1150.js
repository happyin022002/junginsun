/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1150.js
*@FileTitle  : Shipper's Chassis Movement Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_CGM_1150 : EES_CGM_1150 business script for
     */

   	/* developer job	*/
 	// common global variables
 	var tabObjects=new Array();
 	var tabCnt=0 ;
 	var beforetab=1;
 	var sheetObjects=new Array();
 	var sheetCnt=0;
 	// Event handler processing by button click event */
 	document.onclick=processButtonClick;
 	// Event handler processing by button name */
    function processButtonClick(){
		/***** use additional sheet var in case of more than 2 tap each sheet *****/
 		var sheetObj=sheetObjects[0];
        /*******************************************************/
        var formObj=document.form;
     	try {
     		var srcObj=ComGetEvent();
     		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
            	case "btn_Retrieve":
					if(ComChkValid(formObj) == true) {
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					}
					break;
				case "btn_New":
					ComResetAll();
					ComSetFocus(formObj.p_chss_no);
					break;
            	case "btns_calendar":		// Activity Date
					if ( srcObj.style.filter == "" ) {
						var cal=new ComCalendar();
		                cal.select(formObj.p_mvmt_dt, "yyyy-MM-dd");
					}
					break;
				case "btn_delete":
					alert("개발중");
 					break;
 				case "btn_downexcel":
 					if(sheetObj.RowCount() < 1){//no data
 	 					ComShowCodeMessage("COM132501");
 	 				}else{
 	 					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
 	 				}
 					break;
				case "btns_search1":	//Form LOC retrieve popup
					openPopup("1");
 					break;
				case "btns_search2": 	// Form Yard retrieve popup
 					openPopup("2");
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
          	//
            ComEndConfigSheet(sheetObjects[i]);
		}
		
		sheet1_OnLoadFinish(sheet1);
	}
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* Axon Control Setting*/
    	initControl();
    	/*  Focus Setting */
    	ComSetFocus(formObj.p_chss_no);
    }
	// Axon event handling
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
		axon_event.addListenerForm	('change',   	'obj_change',  	formObj); 
  	}
	// 2. event handlingfunction -- Start
  	/**
  	 * Validation check in case of HTML Control focus out .
	 **/
	function obj_blur() {
		var obj=ComGetEvent();
		var formObj=document.form;
	    switch(ComGetEvent("name")) {
	    	default:
	            ComChkObjValid(obj);
	        	break;
	    }
	}
	function obj_change() {
		var obj=ComGetEvent();
		var formObj=document.form;
  		switch(ComGetEvent("name")) {
  			case "p_chss_no":	//Chss No
				if ( ComTrim(obj.value) != "" ) {
	        		//doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
  				}
				break;
  			case "p_loc_cd":	//LOC Code
				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
				break;
			case "p_yd_cd":		//Yard Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
  				}
  				break;
		}
	}
  	//2. event handlingfunction -- End
   	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
        switch(sheetNo) {
			case 1:      //sheet1 init
				with(sheetObj){
			      var HeadTitle="||Seq|CHSS No|MVMT Date|Yard||I/O||Container 1||Container 2||";
			      var headCount=ComCountHeadTitle(HeadTitle);
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			             {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"chss_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gate_io_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sys_seq_01",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no_01",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sys_seq_02",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no_02",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lst_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
			      SetColProperty(0,"mvmt_dt", {Format:"####-##-####:##"} );
			      SetColHidden("del_chk",1);
			      SetCountFormat("[SELECTDATAROW / TOTALROWS]");
//			      SetSheetHeight(420);
			      resizeSheet( );
		    	}
			break;
		}
	}
	function resizeSheet(){
		ComResizeSheet( sheetObjects[0] );
	}
   	// handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction, CondParam, PageNo) {
     	switch(sAction) {
			case IBSEARCH:      //retrieve
	 			if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH;
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						sheetObj.DoSearch("EES_CGM_1150GS.do",FormQueryString(formObj) );
						ComOpenWait(false);
						sheetObj.SetWaitImageVisible(1);
					}
				}
 				break;
 			case IBSEARCH_ASYNC01:	// LOC retrieve
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param="f_cmd="+SEARCH+"&loc_cd="+ComGetObjValue(formObj.p_loc_cd)
 								  + "&loc_nm=&un_loc_ind_cd=&cnt_cd=&loc_eq_ofc=&select=&rcc_cd=&lcc_cd=&loc_state=";
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("COM_ENS_051GS.do", param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetTotalRows(sXml) == 1 ) {
							ComSetNextFocus(formObj.p_loc_cd);
						} else {
							ComShowCodeMessage("CGM10012");
							formObj.p_loc_cd.value="";
							ComSetFocus(formObj.p_loc_cd);
						}
					}
				}
 				break;
 			case IBSEARCH_ASYNC02:	// Yard retrieve
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param="f_cmd="+SEARCH+"&node_cd="+ComGetObjValue(formObj.p_yd_cd)
 								  + "&mode=yard";
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("COM_ENS_061GS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetTotalRows(sXml) == 1 ) {
							ComSetNextFocus(formObj.p_yd_cd);
						} else {
							ComShowCodeMessage("CGM10012");
							formObj.p_yd_cd.value="";
							ComSetFocus(formObj.p_yd_cd);
						}
					}
				}
 				break;
 			case IBSEARCH_ASYNC03:	// Chss No retrieve
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param="f_cmd="+SEARCH+"&eq_no="+ComGetObjValue(formObj.p_chss_no)
 								  + "&eq_knd_cd=Z";
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("CGM_CHS_MASTERGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetTotalRows(sXml) == 1 ) {
							ComSetNextFocus(formObj.p_chss_no);
						} else {
							ComShowCodeMessage('CGM10009','Chassis No');
							formObj.p_chss_no.value="";
							ComSetFocus(formObj.p_chss_no);
						}
					}
				}
				break;
 			case IBSEARCHAPPEND:	//retrieve(paging handling)
				formObj.f_cmd.value=SEARCH;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				sheetObj.DoSearch("EES_CGM_1150GS.do", CondParam+"&"+ "iPage="+ PageNo,{Append:true} );
				ComOpenWait(false);
				sheetObj.SetWaitImageVisible(1);
				break;
     	}
    }
	/**
	 * Sheet의 OnScrollNext Event handling.<br>
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRows
	 */
//	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
//		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
//	}
	
	var iPageNo = 1;
	function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
	    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
	    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
	}
	
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {//LOC
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"loc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    	} else if ( type == "2" ) {//Yard
    		ComOpenPopupWithTarget("/opuscntr/COM_ENS_061.do", 805, 530,"yd_cd:p_yd_cd", "1,0,1,1,1,1,1,1", true);
    	}
    	return;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //retrieve
    				if(formObj.p_chss_no.value == "" && formObj.p_mvmt_dt.value == "" &&
    				   formObj.p_loc_cd.value == "" && formObj.p_yd_cd.value == "") {
    					ComShowCodeMessage("CGM10004", "Chss No.");
    					ComSetFocus(formObj.p_chss_no);
						return false;
    				}
    				return ComChkValid(formObj, true);
    				break;
				default :	//do nothing
    		}
    	}
    	with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:		//saving
	    			return true;
	    			break;
	    		default : 	//do nothing
    		}
    	}
        return true;
    }
	/* developer job end */