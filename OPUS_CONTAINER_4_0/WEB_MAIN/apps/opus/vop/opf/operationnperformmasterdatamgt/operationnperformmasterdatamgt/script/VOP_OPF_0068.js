/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0068.js
*@FileTitle  : TPR Target Ports Register
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
   	/* Developer performance	*/
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         　
        var sheetObject1=sheetObjects[0];   //t1sheet1
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
						case "btn_Retrieve":
								doActionIBSheet(sheetObjects, formObject, IBSEARCH);
								break;
						case "btn_Save":
								doActionIBSheet(sheetObjects, formObject, IBSAVE);
								break;
						case "btn_Add":
							if(ComIsBtnEnable("btn_Save")){
								sheet_closs(sheetObjects[0], sheetObjects[1], sheetObjects[0].GetSelectRow(), "sheet1_", "sheet2_", "Y");
							}
								break;
						case "btn_Delete":
							if(ComIsBtnEnable("btn_Save")){
								sheet_closs(sheetObjects[1], sheetObjects[0], sheetObjects[1].GetSelectRow(), "sheet2_", "sheet1_", "N");
							}
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
	//register IBCombo Object created on page to comboObjects array
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage(strOfcCd) {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		doActionIBSheet(sheetObjects,document.form,IBSEARCH);
 		var ofcCd=strOfcCd;
// 		if(ofcCd == "SELCOL"){
 			ComEnableObject(document.all.btn_Delete, true);
 			ComEnableObject(document.all.btn_Add, true);
 			ComBtnEnable("btn_Save");
// 		}else{
// 			ComEnableObject(document.all.btn_Delete, false);
// 			ComEnableObject(document.all.btn_Add, false); 			
// 			ComBtnDisable("btn_Save");
// 			
// 			
// 		}
    }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
				with (sheetObj) {

	                var HeadTitle1="|All M/V Calling Ports|All M/V Calling Ports|All M/V Calling Ports|All M/V Calling Ports";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                var prefix="sheet1_";
	
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                    {Type:"Seq",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"no" },
	                    {Type:"Text",   Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",   Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vop_port_rhq_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",   Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"vop_port_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoSum", Hidden:1, Width:50,   Align:"Center"}];
	                 
	                InitColumns(cols);
	                SetWaitImageVisible(0);
	                SetCountPosition(0);
	                SetSheetHeight(322);
				}
				break;
            case "sheet2":
				with (sheetObj) {

	                var HeadTitle1="|TPR Target Ports|TPR Target Ports|TPR Target Ports|TPR Target Ports";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                var prefix="sheet2_";
	
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                       {Type:"Seq",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"no" },
	                       {Type:"Text", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text", Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vop_port_rhq_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text", Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"vop_port_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	   {Type:"AutoSum", Hidden:1, Width:50,   Align:"Center"}];
	                InitColumns(cols);
	                SetWaitImageVisible(0);
	                SetCountPosition(0);
	                SetSheetHeight(322);
				}
				break;
		}
    }
	function initCombo(comboObj, comboNo) {
		switch(comboObj.options.id) {
			case "rhq":    //R/D Term-post
				var i=0;
				with(comboObj) {
					InsertItem(i++,  "ALL",		"%");
					Code="%";
					comboObj.SetSelectText("ALL");
				}
				break;
		}
	}
  // handling process related Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBCLEAR:
    	        formObj.f_cmd.value=INIT;
    	        var sXml=sheetObj.GetSearchData("VOP_OPF_0068GS.do", FormQueryString(formObj));
    	        var arrXml=sXml.split("|$$|");
    	        ComXml2ComboItem(arrXml[0], rhq, "vop_port_rhq_cd", "vop_port_rhq_cd");
				break;
			case IBSEARCH:      //Retrieve
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				var arr=new Array("sheet1_","sheet2_");
				document.form.conti_cd.value=rhq.GetSelectCode();
				var sXml=sheetObjects[0].GetSearchData("VOP_OPF_0068GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
				var arrXml=sXml.split("|$$|");
				for(var i=0; i < arrXml.length; i++){ 
					sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
				}
				break;
			case IBSAVE:        //save
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}//end if
				formObj.f_cmd.value=MULTI;
				var sParam=ComGetSaveString(sheetObjects);
				if (sParam == "") return;
				sParam += "&" + FormQueryString(formObj);
				var sXml=sheetObjects[0].GetSaveData("VOP_OPF_0068GS.do", sParam);
				sheetObjects[0].LoadSaveData(sXml);
				sXml=ComDeleteMsg(sXml);
				sheetObjects[1].LoadSaveData(sXml);
				break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
    
	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg)
	{
		ComOpenWait(false);
		with(sheetObj)
		{
			SetSumText(2, RowCount());
			SetSumText(1, "TOTAL");
			SetCellAlign(LastRow(), "loc_cd","Right");
		}
	}
	function sheet2_OnSearchEnd(sheetObj, code, ErrMsg)
	{
		with(sheetObj)
		{
			SetSumText(2, RowCount());
			SetSumText(1, "TOTAL");
			SetCellAlign(LastRow(), "loc_cd","Right");
		}
	}
	function sheet1_OnDblClick(sheetObj, Row, Col){
		if(ComIsBtnEnable("btn_Save")){
			sheet_closs(sheetObj, sheetObjects[1], Row, "sheet1_", "sheet2_", "Y");
		}
	}
	function sheet2_OnDblClick(sheetObj, Row, Col){
		if(ComIsBtnEnable("btn_Save")){
			sheet_closs(sheetObj, sheetObjects[0], Row, "sheet2_", "sheet1_", "N");
		}
	}
	function sheet_closs(sheetOrg, sheetCopy, Row, prefixOrg, prefixCopy, vopPortFlg){
		var loc_cd=sheetOrg.GetCellValue(Row, prefixOrg + "loc_cd");
		var vop_port_rhq_cd=sheetOrg.GetCellValue(Row, prefixOrg + "vop_port_rhq_cd");
		sheetOrg.RowDelete(Row, false);
		var insert_row=sheetCopy.DataInsert(-1);
		sheetCopy.SetCellValue(insert_row, prefixCopy + "loc_cd",loc_cd);
		sheetCopy.SetCellValue(insert_row, prefixCopy + "vop_port_rhq_cd",vop_port_rhq_cd);
		sheetCopy.SetCellValue(insert_row, prefixCopy + "vop_port_flg",vopPortFlg);
		sheetOrg.SetSumText(0, 2,sheetOrg.RowCount());
		sheetCopy.SetSumText(0, 2,sheetCopy.RowCount());
	}
	//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
	
	function rhq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		document.form.conti_cd.value=rhq.GetSelectCode();
		doActionIBSheet(sheetObjects, document.form, IBSEARCH);
	}
	
	function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg) {
	 ComOpenWait(false);// always exist at first line
	 if(Code == 0){
	  ComShowCodeMessage("COM132601");
	}
	}
	/* Developer performance  end */
