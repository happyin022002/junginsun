/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0745.js
*@FileTitle  : NCM Code Creation
*@author     : CLT
*@version    : 1.0
*@since      : 
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_bkg_0745 : business script for esm_bkg_0745
     */
    
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
	    /***** using extra sheet valuable if there are more 2 sheets *****/
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
				case "btn2_RowAdd":
					sheetObject1.DataInsert(-1);
					break;
				case "btn2_Delete":
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
					break;
				case "btn_Save":
                	doActionIBSheet(sheetObject1,formObject,IBSAVE);
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
	    sheet1_OnLoadFinish();
	    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	/**
	 * event after page loaded
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;

	}   
	/**
	 * setting focus in case of page Loading
	 * @return
	 */
	function initFocus() {
	    var formObj=document.form;
	    ComSetFocus(formObj.cmdt_cd);
	}
	/**
	 * setting sheet initial values and header
	 * @param sheetObj
	 * @param sheetNo
	 * @return
	 */
	function initSheet(sheetObj,sheetNo) {
	    	var cnt=0;
			var sheetID=sheetObj.id;
			switch(sheetID) {
				case "sheet1":
				    with(sheetObj){
			        
			      var HeadTitle1="|Sel.|Del|Seq|Harmonized Tariff Code|Description|Category|User ID|Office|Update Date";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      (headCount, 0, 0, true);

			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);

			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_check" },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0, Width:170,  Align:"Left",    ColMerge:1,   SaveName:"brz_cmdt_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
			             {Type:"Text",      Hidden:0, Width:450,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:220,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_cate_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"office",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
				      InitColumns(cols);
				      SetEditable(1);
				      SetWaitImageVisible(0);
				      SetEllipsis(1);
				      SetSheetHeight(450);
				      SetCountFormat("[SELECTDATAROW / TOTALROWS]");
//				      InitViewFormat(0, "upd_dt", "yyyy-mm-dd")
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
			case IBDOWNEXCEL:
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				//sheetObj.Down2Excel({ HiddenColumn:1});
//				sheetObj.SetHeaderBackColor("#CCCCCC");
				sheetObj.Down2Excel({DownCols:makeHiddenSkipCol(sheetObj)});   
//				sheetObj.SetHeaderBackColor("#333333");
				
				ComOpenWait(false);
				break;
			case IBDELETE:	// Row Delete
				if (!validateForm(sheetObj, formObj, sAction))	return;
				if(ComShowCodeConfirm('BKG03037')){
					ComRowHideDelete(sheetObj, "del_check");
                	sheetObj.CheckAll("del_check",0,1);
				}
				break;
			case IBSAVE :
 				if(!validateForm(sheetObj,formObj,sAction)) return false;
 				formObj.f_cmd.value=MULTI;
 				var sParam=sheetObj.GetSaveString();
 				if (sheetObj.IsDataModified()== false || sParam == "") {
 					ComShowCodeMessage('BKG00260');
 					return;
 				}
 				sParam=sParam + "&f_cmd="+MULTI;
 				ComOpenWait(true);
 				var sXml=sheetObj.GetSaveData("ESM_BKG_0745GS.do", sParam);
				ComOpenWait(false);
				if (ComBkgErrMessage(sheetObj, sXml)) {
					sheetObj.LoadSaveData(sXml,{Sync:1} );
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
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
			case IBDOWNEXCEL : { 
				if(sheetObj.RowCount()== 0) {
					ComShowCodeMessage('BKG00389');
					return false;
				}
				break;
			}
			case IBDELETE : // Row Delete
				var sheet1RowCnt=sheetObj.RowCount();
			    var selCnt=0;
				if(sheet1RowCnt == 0) {
					ComShowCodeMessage('BKG00389');
					return false;
				}
				for(var i=1; i<=sheet1RowCnt; i++) {
					if(sheetObj.GetCellValue(i, "del_check") == 1) {
						selCnt++;
					}
					if(selCnt > 0) break;
				}
				if(selCnt == 0) {
					ComShowCodeMessage('BKG00442');
					return false;
				}
				break;
	    }
	    return true;
	}
    /**
     * process when input retrieve keyword
     */
    
     /**
      * event after retrieve
      * @param sheetObj
      * @param ErrMsg
      * @return
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
// 		sheetObj.checkAll2("del_check")=0;
    	sheetObj.CheckAll("del_check", 0);
     }
      /**
       * process when click sheet
       */
      function sheet1_OnClick(sheetObj, row, col) {
      	var rowCnt = sheetObj.RowCount();
		var check = sheetObj.GetCellValue(row, "del_check");
		var actFlg = sheetObj.GetCellValue(row, "act_flg");
		
      	var colSaveName=sheetObj.ColSaveName(col);
      	
      	switch(colSaveName) {
      		case "cmdt_desc" :
      		case "cmdt_cate_ctnt" :
      			ComShowMemoPad(sheetObj, null, null, false, 300, 100);
      			break;
      		case "del_check" :
      			if(actFlg == "Y") {
      				sheetObj.SetCellValue(row, "del_check",1,0);
      			}
      			break;
      	} // end switch
      }