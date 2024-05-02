/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0004_06.js
*@FileTitle  : S/C Proposal GOH Charge Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    				break;
              } // end switch
     	} catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
    }
    /**
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	resizeSheet();
      	pageOnLoadFinish();
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	switch (sheetID) {
    		case "sheet1":
    		    with(sheetObj){
    			      var HeadTitle="Seq.|Type|Point|Description|Bar Type|Per|Currency|Proposal|C.Offer|Final|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date||||||";
    			      var headCount=ComCountHeadTitle(HeadTitle);

    			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

    			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
    			      InitHeaders(headers, info);

    			      var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
    			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
    			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
    			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
    			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_hngr_bar_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
    			             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
    			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"" },
    			             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
    			             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"coffr_frt_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
    			             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
    			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd" },
    			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd" },
    			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
    			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
    			             {Type:"Text",     Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm" },
    			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd" },
    			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
    			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
    			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
    			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"goh_chg_seq" },
    			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
    			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id" } ];
    			       
    			      InitColumns(cols);

    			      SetEditable(0);
		                SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
		                SetWaitImageVisible(0);
		                //SetAutoRowHeight(0);
		      			SetColProperty("prc_hngr_bar_tp_cd", {ComboText:prcHngrBarTpCdText, ComboCode:prcHngrBarTpCdValue} );
		    			SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
		    			SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
		    			SetColProperty("prc_prog_sts_cd", {ComboText:PrcProgStsCdText, ComboCode:PrcProgStsCdValue} );
		    			resizeSheet(); //SetSheetHeight(310);
    			      }
    			break;
    	}
    }
    
    function resizeSheet() {
    	ComResizeSheet(sheetObjects[0]);
    }
    
    /**
	 * loading HTML Control event in the page <br>
	 * initializing IBSheet Object calling from {@link #loadPage} function <br>
	 **/
 	function initControl() {
 		DATE_SEPARATOR="/";
 		//Axon event handling 1. event catch
 		//axon_event.addListenerForm  ('click', 'obj_click', form);  
 	}
 	/**
     * Handling sheet process <br>
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
	     	case IBSEARCH:	//retrieve
	     		ComOpenWait(true);
	     		if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
	     		formObj.f_cmd.value=SEARCH01;
 				sheetObj.DoSearch("ESM_PRI_0004_06GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
	     		break;
		}
	}
    /**
     * calling function when occurring OnClick Event in sheet1<br>
     */
 	function sheet1_OnClick(sheetObj, Row, Col, Value) {
 		//showing memopad when clicking desc cell (MemoPad editable)
 		var colname=sheetObj.ColSaveName(Col);
 		switch (colname) {
 			case "acpt_usr_nm":
                 if (Value != "") {
                	 ComUserPopup(sheetObj.GetCellValue(Row,"acpt_usr_id"));
                 }
                 break;
 		}
 	}
 	/**
     * calling function when Page Loading <br>
     */ 
   function pageOnLoadFinish() {
    	initControl();
    	sheetObjects[0].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE1[1] , ComboCode:LOCATION_TYPE1[0]} );
    	parent.loadTabPage();
    }
    /**
     * calling function when clicking parent's screen tab <br>
     * showing retrieved data<br>
     */ 
	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd) {
		var formObject=document.form;
	 	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
	 		formObject.prop_no.value=sPropNo;
	 		formObject.amdt_seq.value=sAmdtSeq;
	 		formObject.svc_scp_cd.value=sSvcScpCd;
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
	 	}
	}
	/**
     * initializing parent's screen tab control <br>
     */ 		 
 	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";
		sheetObjects[0].RemoveAll();
	}
	var enableFlag=true;
	/**
     * calling function from main screen <br>
     * prohibiting insert, update, delete in case or Confirmation = YES  <br>
     */
	function tabEnableSheet(flag) {
		var formObject=document.form;	
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
	}
	/**
     * checking validation process of inputed form data <br>
     */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH: // retrieve			
				if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				}
				return true;
 				break;
		}
		return true;
	}
