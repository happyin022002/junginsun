/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9254.js
*@FileTitle  : business script for MR Storage Container List - 3rd Party Interface
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/20
=========================================================*/

/**
 * @extends Tes
 * @class ESD_TES_9254 : business script for MR Storage Container List - 3rd Party Interface
 */

	function ESD_TES_9254() {
		this.processButtonClick = processButtonClick;
		this.setSheetObject = setSheetObject;
		this.setComboObject = setComboObject;
		this.setTabObject = setTabObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.initTab = initTab;
		this.doActionIBSheet = doActionIBSheet;
		this.validateForm = validateForm;
	}

	//global variable
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Event handler processing by button click event
	document.onclick = processButtonClick;

	/**
	 * Event handler processing by button name
	 * @return
	 */
    function processButtonClick(){
         var sheetObj = sheetObjects[0];
         var formObject = document.form;
    	 try {
    		 var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObj,formObject,IBINSERT);
        	        break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 * @return     
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
   /**
     * setting sheet initial values and header
     * param : sheetObj ==> , sheetNo ==>  
     * adding case as numbers of counting sheets
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
				var HeadTitle = "|Container No.|Billing Case|Amount|3rd Party|3rd Party|Remark";
				SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",	Hidden:1, Width:30,   Align:"Center",	ColMerge:1,   SaveName:"ibflag",							KeyField:0,   CalcLogic:"" },
		        		{Type:"Text",		Hidden:0,	Width:100,	Align:"Left",			ColMerge:0,   SaveName:"cntr_no",						KeyField:1,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:0,	Width:100,	Align:"Left",			ColMerge:0,   SaveName:"n3pty_bil_tp_cd",			KeyField:1,   CalcLogic:"",   Format:"",			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",		Hidden:0,	Width:60,		Align:"Right",		ColMerge:0,   SaveName:"if_amt",						KeyField:0,   CalcLogic:"",   Format:"Float",	PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Combo",Hidden:0, Width:80,	Align:"Left",			ColMerge:1,   SaveName:"vndr_cust_div_cd",			KeyField:0,   CalcLogic:"",   Format:"",			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Popup",	Hidden:0,	Width:100,	Align:"Left",			ColMerge:1,   SaveName:"trd_party_val",				KeyField:0,   CalcLogic:"",   Format:"" ,			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",		Hidden:0,	Width:100,	Align:"Left",			ColMerge:0,   SaveName:"if_rmk",						KeyField:0,   CalcLogic:"",   Format:"" ,			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"vndr_cnt_cd",				KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"vndr_seq",					KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"n3pty_vndr_seq",			KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"cust_cnt_cd",				KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"cust_seq",						KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"n3pty_ofc_cd",				KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"tml_if_ofc_cd",				KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"tml_if_seq",					KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"tml_so_ofc_cty_cd",		KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"tml_so_seq",					KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"tml_so_cntr_list_seq",	KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"tml_so_dtl_seq",			KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"tml_so_dtl_seq3",			KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"lgs_cost_cd",				KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"cntr_tpsz_cd",				KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"io_bnd_cd",					KeyField:0,   CalcLogic:"",   Format:"" },
	                    {Type:"Text",		Hidden:1,	Width:65,		Align:"Right",		ColMerge:1,   SaveName:"calc_cost_grp_cd",		KeyField:0,   CalcLogic:"",   Format:"" } ];
				InitColumns(cols);
				SetColProperty("vndr_cust_div_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
				SetEditable(0);
				resizeSheet();
				InitComboNoMatchText(true);
		    }
			break;
		}
	}
     /**
      * handling sheet process
 	 * @param {ibsheet} sheetObj 	IBSheet Object
 	 * @param {form} 	formObj		Form Object
 	 * @param {int}	sAction		
      * @return
      */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		   case IBSEARCH:
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
				formObj.f_cmd.value = SEARCHLIST;
				sheetObj.DoSearch("ESD_TES_9254Popup.do", tesFrmQryStr(formObj));
			    break;
		}
    }
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!ComIsNumber(iPage)) {
//
//                return false;
//            }
        }
        return true;
    }
    /**
     * UI 표준화관련 하단 여백 설정
     */
    function resizeSheet() {
    	ComResizeSheet(sheetObjects[0]);
    }