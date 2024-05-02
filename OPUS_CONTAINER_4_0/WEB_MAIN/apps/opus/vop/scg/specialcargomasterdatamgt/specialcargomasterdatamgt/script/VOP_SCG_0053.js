/*=========================================================
 * 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_0053.js
*@FileTitle  : Target Lane for SPCL CGO APVL (Inquiry)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
             MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
             OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0053 : vop_scg_0053 business script for
     */
    function vop_scg_0053() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    } 
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var gRow=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
    	var sheetObject=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    		case "btn_retrieve":
    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    			break;
    		case "btn1_Excel":
    			if(sheetObjects[0].RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            		}else{
            			doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
            		}
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
    	doActionIBSheet( sheetObj,document.form,IBSEARCH);
    } 
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	switch(sheetNo) {
    		case 1:      //t1sheet1 init
    			with (sheetObj) {

	    	        (5, 0, 0, true);
	    	        var HeadTitle="|No.|Target Lane|Full Name|Service Type";
	    	        var prefix="sheet1_";
	
	    	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	    	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    	        InitHeaders(headers, info);
	
	    	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	    	               {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
	    	               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    	               {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_slan_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	               {Type:"Text",      Hidden:0,  Width:430,  Align:"Left",    ColMerge:1,   SaveName:prefix+"svc_type_name", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	    	         
	    	        InitColumns(cols);
	
	    	        SetEditable(0);
	    	        SetBasicImeMode(2);
	    	        //SetSheetHeight(460);
	    	        resizeSheet();
    			}
    			break;
    	}
    }
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }

    // Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      //retrieve
    			formObj.f_cmd.value=SEARCH;
    			var aryPrefix=new Array("sheet1_");
    			var param=FormQueryString(formObj) +"&spcl_cgo_rqst_tgt_lane_flg=Y" +"&" + ComGetPrefixParam( aryPrefix );
    			var sXml=sheetObj.GetSearchData("VOP_SCG_0053GS.do", param);
    			sheetObj.RenderSheet(0);
    			sheetObj.LoadSearchData(sXml,{Sync:0} );
    			sheetObj.RenderSheet(1);
    			break;
    		case IBDOWNEXCEL:      // delete
                var paramObj=new Object();
                paramObj.title="Target Lane for SPCL CGO APVL";
                paramObj.orientation="Portrait";
//                paramObj.columnwidth="2:10|3:40|4:30";
//                var url=ComScgGetPgmTitle(sheetObj, paramObj); 
//                sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				var sheetExcelObj = sheetObj;
                paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
                paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
                paramObj.datarowheight="0:25";
                var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
                
                if(sheetExcelObj.RowCount() < 1){//no data
            		  ComShowCodeMessage("COM132501");
    	       	}else{
       	       		var str = sheetExcelObj.GetSearchData(url);
       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
       	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
    	       	}                
    			break;   					
    	}
    }
    /** 
     * Sheet vsl_slan_cd data retrieve <br>
     * @param 
     * @return 
     * @author 
     * @version 
     */  
    function sheet1_OnChange(sheetObj, row, col) {
    	if( sheetObj.ColSaveName(col) == "sheet1_vsl_slan_cd" ){
    		getVslSlanCd(sheetObj, row, col );
    	}
    }
    /** 
     * Sheet vsl_slan_cd data retrieve <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */  
    function getVslSlanCd(sheetObj, row, col) {
    	var vsl_slan_cd=sheetObj.GetCellValue(row,"sheet1_vsl_slan_cd");
    	document.form.f_cmd.value=SEARCH01;
    	var aryPrefix=new Array("sheet1_");
    	var sXml=sheetObj.GetSearchData("VOP_SCG_0035GS.do", FormQueryString(document.form)+"&vsl_slan_cd="+vsl_slan_cd+"&tml_prod_rpt_flg=N"+"&" + ComGetPrefixParam( aryPrefix ) );
    	var VslSlanCd_info=ComGetEtcData(sXml,"VslSlanCd");   
    	setVslSlanCd(row, VslSlanCd_info);
    }
    /** 
     * VslSlanCd  result handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */  
    function setVslSlanCd(cRow, VslSlanCd_info) {
    	var sheetObject=sheetObjects[0];
    	var aVslSlanCd_info=VslSlanCd_info.split("|");
    	sheetObject.SetCellValue(cRow,"sheet1_vsl_slan_cd",aVslSlanCd_info[0],0);
    	sheetObject.SetCellValue(cRow,"sheet1_vsl_slan_nm",aVslSlanCd_info[1],0);
    	sheetObject.SetCellValue(cRow,"sheet1_svc_type_name",aVslSlanCd_info[2],0);
    	if( aVslSlanCd_info != 0 ){
    		// sheetObject.CellValue2(cRow,"sheet1_del_chk")          =  1;
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
    	}
    	return true;
    }
    function sheet1_OnPopupClick(sheetObj, Row, Col)
    {
    	with(sheetObj)
    	{
    		gRow=Row;
    		ComOpenPopup('/opuscntr/VOP_VSK_0202.do', 426, 455, "setVslSlanCdPopup", "0,0", true, false, Row, Col, 0);
    	}
    }
    /** 
     * Setting value selected from VslSlanCd poppup <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */       
    function setVslSlanCdPopup(aryPopupData){
   	   var sheetObject=sheetObjects[0];
	   sheetObject.SetCellValue(gRow,"sheet1_vsl_slan_cd",aryPopupData[0][1],0);
	   sheetObject.SetCellValue(gRow,"sheet1_vsl_slan_nm"    ,aryPopupData[0][2],0);
	   sheetObject.SetCellValue(gRow,"sheet1_vsl_svc_tp_cd"  ,aryPopupData[0][3],0);
	   sheetObject.SelectCell(gRow, "sheet1_vsl_slan_cd");
	   //doActionIBSheet( sheetObject,document.form,IBSEARCH_ASYNC01, gRow, aryPopupData[0][1] );
   	   gRow=0;
    }  		
