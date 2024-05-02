/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : esm_bkg_0659.js
*@FileTitle : DG Cargo Detail Pop-up
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * business script for esm_bkg_0567
	 */
    function esm_bkg_0659() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event  */
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
                case "btn_close":
                	ComClosePopup(); 
                    break;
            } // end switch
        } catch(e) {
            if ( e == "[object Error]") {
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
     * @param sheet_obj IBSheet Object
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
        for (var i=0;i<sheetObjects.length;i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     * @param sheetObj sheet Object
     * @param sheetNo 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
             var HeadTitle="Seq.|IMO \nClass|UN No.|Proper Shipping Name|Technical Name|Save ID|File Path|Attach \nFile";

             SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cgo_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"prp_shp_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"hzd_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
                 {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"file_sav_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"file_path_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"file_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 } ];
              
             InitColumns(cols);
             SetSheetHeight(220);
             }
             break;
        }
    }
    /**
     * Sheet process handling
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
            case IBSEARCH:      //Retrieve
            	if(!validateForm(sheetObj,formObj,sAction)) return;
                ComOpenWait(true);
            	formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESM_BKG_0659GS.do", FormQueryString(formObj) );
            	ComOpenWait(false);
                break;
        }
    }
    /**
	* handling process for input validation
	* @param sheetObj sheet Object
	* @param formObj  form Object
	* @param sAction 
	*/
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
        //Retrieve
        case IBSEARCH:
        	//1.Validation Basic
        	if (!ComChkValid(formObj)) return false;
        	//2.Validation Business
        	with(formObj) {
            }
        	break;
        }
        return true;
    }
    /**
     * Sheet1 click event handling
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnClick(sheetObj,Row,Col,Value){
    	with(sheetObj) {
        	switch (ColSaveName(Col)) {
        	case "file_nm":
        		if (GetCellValue(Row, "file_sav_id") != "") {
        			location.href="/opuscntr/FileDownload?key="+GetCellValue(Row, "file_sav_id");
        		}
        		break;
        	}
    	}
    }
    /**
	 * handling process after ending sheet1 retrieve
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        with(sheetObj) {
        	var idx=0;
            for (var i=0; i<RowCount(); i++) {
            	idx=i+1;
            	if (GetCellValue(idx,"file_sav_id") != "") {
            		InitCellProperty(idx, "file_nm",{ Type:"Popup"} );
                }
            }
        }
    }
