/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_BKG_0745.js
*@FileTitle  : ESM_BKG_0745 
*@author     : CLT
*@version    : 1.0
*@since      : 29/04/2014
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// public variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
	    /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
	    var sheetObject1=sheetObjects[0];
	    /*******************************************************/
	    var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
                case "btn_DownExcel":
                	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                	break;
				case "btn_Select":
                	doActionIBSheet(sheetObject1,formObject,IBROWSEARCH);
					break;
				case "btn_Close":
		    	   	ComClosePopup(); 
		    	    break;
	        } // end switch
			}catch(e) {
				if( e == "[object Error]") {
					ComShowMessage(OBJECT_ERROR);
				} else {
					ComShowMessage(e);
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
		var formObj=document.form;
	    for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	    
	    if(formObj.brz_cmdt_cd.value != null && formObj.brz_cmdt_cd.value != "") {
	    	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    }
	    else {
	    	sheet1_OnLoadFinish();
	    }
	    
	    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	/**
	 * event after screen loading
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;

	 }   
	/**
	 * As page Loading, focus setting
	 * @return
	 */
	function initFocus() {
	    var formObj=document.form;
	    ComSetFocus(formObj.cmdt_cd);
	}
	/**
	 * setting sheet initial values and header
	 * 
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
		var sheetID=sheetObj.id;
			switch(sheetID) {
				case "sheet1":
		            with(sheetObj){
                    var HeadTitle1="| |Harmonized Tariff Code|Description|Category";
                    var headCount=ComCountHeadTitle(HeadTitle1);
                    (headCount, 0, 0, true);
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			         {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			         {Type:"Text",      Hidden:0, Width:170,  Align:"Left",    ColMerge:1,   SaveName:"brz_cmdt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			         {Type:"Text",      Hidden:0, Width:500,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			         {Type:"Text",      Hidden:0, Width:220,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_cate_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                     InitColumns(cols);
		             SetEditable(1);
		             SetWaitImageVisible(0);
		             SetCountFormat("[SELECTDATAROW / TOTALROWS]");
		             SetSheetHeight(300);
              }
			break;
		}
	}
	/**
	 * handling sheet process
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				var sParam=FormQueryString(formObj);
				sheetObj.DoSearch("ESM_BKG_0745GS.do",sParam );
				ComOpenWait(false);
				break;
			case IBDOWNEXCEL:   // Excel
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				//sheetObj.Down2Excel({ HiddenColumn:1}); 
//				sheetObj.SetHeaderBackColor("#CCCCCC");
				sheetObj.Down2Excel({DownCols:makeHiddenSkipCol(sheetObj)});   
//				sheetObj.SetHeaderBackColor("#333333");
				
				ComOpenWait(false);
				break;
			case IBROWSEARCH:	// row search
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				sheet1_OnDblClick(sheetObj,sheetObj.GetSelectRow(),'');
				break;
	    }
	}
	/**
	 * handling process for input validation
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function validateForm(sheetObj,formObj,sAction){
	    switch(sAction) {
			case IBSEARCH: { // retrieve
				var brzCmdtCd=formObj.brz_cmdt_cd.value;
				var cmdtDesc=formObj.cmdt_desc.value;
				if(brzCmdtCd.trim() == "" && cmdtDesc.trim() == "") {
					ComShowCodeMessage("BKG06045" );
					ComSetFocus(formObj.brz_cmdt_cd);
					return false;
				}
				break;
			}
			case IBDOWNEXCEL : { // Excel
				if(sheetObj.RowCount()== 0) {
					ComShowCodeMessage('BKG00389');
					return false;
				}
				break;
			}
			case IBROWSEARCH : { // row select 
				if(sheetObj.RowCount()== 0) {
					//ComShowMessage("선택할 data가 없습니다.")
					ComShowCodeMessage('BKG00889');
					return false;
				}
				break;
			}
	    }
	    return true;
	}
    /**
     * Cell DblClick Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnDblClick(sheetObj,Row,Col) {
        try{    	
			var obj=new Object(); 
			obj.cd=sheetObj.GetCellValue(Row, "brz_cmdt_cd");
			obj.nm=sheetObj.GetCellValue(Row, "cmdt_desc");
			if(opener) {
				$(opener.document).sheet1_SetValues(obj);
			}
			if(parent) {
				parent.sheet1_SetValues(obj);
			}
			ComClosePopup();			
       }catch(e){}    
    }
    /**
     * process when you enter retrieve condition
     */
    function obj_KeyUp() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	var srcValue=window.event.srcElement.getAttribute("value");
    	if (srcName == "brz_cmdt_cd" && ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
