/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0305.js
*@FileTitle  : ESM_BKG_0305
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/05
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class ESM_BKG_0305 : ESM_BKG_0305 - task script definition for screen
     */
    function ESM_BKG_0305() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
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
         //var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);					
					break;
				case "btn_downexcel":
                	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
				case "btn_Select":
                	doActionIBSheet(sheetObject1,formObject,COMMAND01);
					break;
				case "btn_Detail":
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//Event needed for screen
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
		   
		      var HeadTitle="|Abbr. Code|Customs Code|Bond Code|Warehouse Name|LOC|Phone|P.I.C|Fax|cnt_cd|loc_nm|wh_addr|diff_rmk";
		      var headCount=ComCountHeadTitle(HeadTitle);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wh_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cstms_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bd_area_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"wh_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"phn_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"pson_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"fax_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"wh_addr",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"diff_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		      SetWaitImageVisible(0);
		      SetSheetHeight(162);
				}
				break;
		}
	}
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //retrieve
        		if(!validateForm(sheetObj,formObj,sAction)) return false;
        		ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
         		var sXml=sheetObj.GetSearchData("ESM_BKG_0305GS.do" , FormQueryString(formObj) );
        		sheetObj.LoadSearchData(sXml,{Sync:2} );
        		ComOpenWait(false);
        		break;
			case IBDOWNEXCEL:      // EXCEL
        		if(!validateForm(sheetObj,formObj,sAction)) return false;
        		ComOpenWait(true);
 				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				ComOpenWait(false);
				break;
        	case COMMAND01:      //select button
				if(!validateForm(sheetObj,formObj,sAction)) return false;
                select(sheetObj, sheetObj.GetSelectRow(), '');
                break;
        	case IBROWSEARCH:	// detail button
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				sheet1_OnDblClick(sheetObj,sheetObj.GetSelectRow(),'');
				break;
        } // end switch
    }
    /**
     * select button click
     * 
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function select(sheetObj,Row,Col) {
        try{    	
			var obj=new Object(); 
			obj.cd=sheetObj.GetCellValue(Row, "cstms_cd");
			obj.nm=sheetObj.GetCellValue(Row, "bd_area_cd");
			//window.returnValue=obj;
			
			ComPopUpReturnValue(obj);
			ComClosePopup(); 
       }catch(e){}    
    }
    /**
     * cell double click Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnDblClick(sheetObj,Row,Col) {
		var cntCd=sheetObj.GetCellValue(Row, "cnt_cd");
		var whCd=sheetObj.GetCellValue(Row, "wh_cd");
		var cstmsCd=sheetObj.GetCellValue(Row, "cstms_cd");
		var whNm=sheetObj.GetCellValue(Row, "wh_nm");
		var whAddr=sheetObj.GetCellValue(Row, "wh_addr");
		var locCd=sheetObj.GetCellValue(Row, "loc_cd");
		var locNm=sheetObj.GetCellValue(Row, "loc_nm");
		var psonNm=sheetObj.GetCellValue(Row, "pson_nm");
		var phnNo=sheetObj.GetCellValue(Row, "phn_no");
		var faxNo=sheetObj.GetCellValue(Row, "fax_no");
		var diffRmk=sheetObj.GetCellValue(Row, "diff_rmk");
		var sUrl="/opuscntr/ESM_BKG_0982.do?";
		var sParam="&cntCd=" + cntCd
					+ "&whCd=" + whCd
					+ "&cstmsCd="+cstmsCd
					+ "&whNm=" + whNm
					+ "&whAddr=" + whAddr
					+ "&locCd=" + locCd
					+ "&locNm=" + locNm
					+ "&psonNm=" + psonNm
					+ "&phnNo=" + phnNo
					+ "&faxNo=" + faxNo
					+ "&diffRmk=" + diffRmk;
		ComOpenWindowCenter(sUrl+sParam, "ESM_BKG_0982", 560, 400, true);
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
     	switch(sAction) {
	 		case IBSEARCH :
				if (!ComChkValid(formObj)) return false;
    			var cntCd=formObj.cnt_cd.value;
    			var locCd=formObj.loc_cd.value;
    			if(cntCd == "" && locCd == "") {
					//ComShowMessage("Country Code또는Location 중 반드시 1개 이상 입력해야합니다.");
     				ComShowCodeMessage("BKG06094");
					ComSetFocus(formObj.cnt_cd);
					return false;
    			}
	 			break;
	 		case IBDOWNEXCEL:
     			if(sheetObj.RowCount()== 0) {
     				//ComShowMessage("retrieve된 데이타가 없습니다.");
     				ComShowCodeMessage("BKG00889");
     				return false;
     			}
	 			break;
	 		case COMMAND01:
     			if(sheetObj.RowCount()== 0) {
     				//ComShowMessage("retrieve된 데이타가 없습니다.");
     				ComShowCodeMessage("BKG00889");
     				return false;
     			}
	 			break;
	 		case IBROWSEARCH:
     			if(sheetObj.RowCount()== 0) {
     				//ComShowMessage("retrieve된 데이타가 없습니다.");
     				ComShowCodeMessage("BKG00889");
     				return false;
     			}
     			break;
     	}
     	return true;
    }
