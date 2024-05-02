/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_5922.js
*@FileTitle  : Application Request & Approval Status - DG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
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
     			case "btn_Retrieve":
     				doActionIBSheet(sheetObject,document.form,IBSEARCH);
     				break;
     			case "btn_DownExcel":
                    var paramObj=new Object();
                    
                	var bkgSrch = (formObject.bkg_srch.value).substring(0, 1);
                	var subTitle = "";
                	if(bkgSrch == "1"){
                		subTitle = "Arrival";
                	}else if(bkgSrch == "2"){
                		subTitle = "Discharge";
                	}else if(bkgSrch == "3"){
                		subTitle = "Load";
                	}else if(bkgSrch == "4"){
                		subTitle = "Departure";
                	}
                    
                    paramObj.title="Port Limit Booking Details - "+subTitle;
                    paramObj.orientation="Portrait";
                    paramObj.columnwidth=ComScgGetExcelDown(sheetObject);
                    paramObj.cols=ComScgGetExcelDownCols(sheetObject);
                    var url=ComScgGetPgmTitle(sheetObject, paramObj);
                    if(sheetObject.RowCount() < 1){//no data
                    	ComShowCodeMessage("COM132501");
                	}else{
                		var str = sheetObject.GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1,ReportXML:str});
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
    	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	bkg_srch_OnChange();
    	initControl();
     }
    
    /**
     * Loading the event of HTML Control <br>
     * {@link #loadPage} Initializing IBSheet Object <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     The order number of sheetObjects array
     **/
    function initControl() {
    	var formObj=document.form;
    	axon_event.addListener('change', 	'bkg_srch_OnChange', 'bkg_srch');
    }
    
    /**
     * Processing to be retrieved when onChange event occurred <br>
     **/
    function bkg_srch_OnChange(){
    	
    	var formObj = document.form;
    	var bkgSrch = ComGetObjValue(formObj.bkg_srch).substring(0, 1);
    	
    	
    	var openerObj	= window.dialogArguments;
    	if(!openerObj) var openerObj= parent;
    	
    	var oSheetObj 	= openerObj.sheetObjects[0];
    	
    	//alert('parent obj <<< '+oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "arrival_bkg_no")+' >>>');
    	
//    	if(bkgSrch == "1"){
//    		formObj.bkg_nos.value = formObj.bkg_nos1.value;
//    	}else if(bkgSrch == "2"){
//    		formObj.bkg_nos.value = formObj.bkg_nos2.value;
//    	}else if(bkgSrch == "3"){
//    		formObj.bkg_nos.value = formObj.bkg_nos3.value;
//    	}else if(bkgSrch == "4"){
//    		formObj.bkg_nos.value = formObj.bkg_nos4.value;
//    	}
    	
    	if(bkgSrch == "1"){
    		formObj.bkg_nos.value = oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "arrival_bkg_no");
    	}else if(bkgSrch == "2"){
    		formObj.bkg_nos.value = oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "discharge_bkg_no");
    	}else if(bkgSrch == "3"){
    		formObj.bkg_nos.value = oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "load_bkg_no");
    	}else if(bkgSrch == "4"){
    		formObj.bkg_nos.value = oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "departure_bkg_no");
    	}
    	
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	switch(sheetObj.id) {
    		case "sheet1":      //t1sheet1 init
    		    with(sheetObj){
	    	      var HeadTitle ="Seq|Cargo\nOperator|VVD CD|VVD CD|VVD CD|BKG No.|PORT|PORT|POL|POL|POL|POD|POD|POD|Sequence|Sequence|Class|UN No/Seq|UN No/Seq|TP/SZ|CNTR\nQTY|Weight(KGS)|Weight(KGS)|Weight(KGS)|DG Ref No|Appr DT(S)|";
	    	      var HeadTitle1="Seq|Cargo\nOperator|VVD CD|VVD CD|VVD CD|BKG No.|PORT|PORT|POL|POL|POL|POD|POD|POD|CNTR|CGO|Class|UN No/Seq|UN No/Seq|TP/SZ|CNTR\nQTY|Gross|Net|Net Powder|DG Ref No|Appr DT(S)|";
	    	      
	              var headCount=ComCountHeadTitle(HeadTitle);

	              SetConfig( { SearchMode:2, MergeSheet:9, Page:20, DataRowMerge:0 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"},
	                            { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	    	      var cols = 
	    	    	  	[
	    	    	  	 {Type:"Seq",       Hidden:0, Width:30,    Align:"Center",  ColMerge:1,   SaveName:"seq_no"	 },
	    	    	  	 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cgo_opr_cd",     KeyField:0,   CalcLogic:"",   Format:"",	Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",         KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",     KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             
	    	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"plmt_port_cd",         KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"plmt_clpt_ind_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
	    	             
	    	             
	    	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
     	                 {Type:"Text",     Hidden:0, Width:15,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
     	                 {Type:"Text",     Hidden:0, Width:15,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dg_cntr_seq",    KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cgo_seq",   KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",   KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",     KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no_seq", KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"AutoSum",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_qty",       KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"AutoSum",      Hidden:0,  Width:85,   Align:"Right",  ColMerge:0,   SaveName:"grs_wgt",        KeyField:0,   CalcLogic:"",   Format:"Float",   Wrap:1,  PointCount:2 },
	    	             {Type:"AutoSum",      Hidden:0,  Width:85,   Align:"Right",  ColMerge:0,   SaveName:"net_wgt",        KeyField:0,   CalcLogic:"",   Format:"Float",   Wrap:1,  PointCount:2 },
	    	             {Type:"AutoSum",      Hidden:0,  Width:85,   Align:"Right",  ColMerge:0,   SaveName:"net_explo_wgt",        KeyField:0,   CalcLogic:"",   Format:"Float",   Wrap:1,  PointCount:2 },
	    	             {Type:"Text",      Hidden:0,  Width:105,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ref_no",    KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"auth_dt",        KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	             {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",         Wrap:1 },
	    	             {Type:"Text",      Hidden:1,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"lmt_wgt_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",   Wrap:1 },
	    	            ];
	    	       	  
		    	      InitColumns(cols);
		
		    	      SetEditable(0);
		    	      SetHeaderRowHeight(20);
		    	      SetSheetHeight(400);
    		}


    			break;
    	}
    }
    // Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction) {
//    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      //retrieve
				 if(!validateForm(sheetObj,formObj,sAction))	return;
				 
				 if(formObj.bkg_nos.value == '') {formObj.bkg_nos.value = '*';} //해당 bkg_no가 없을 경우, dummy값으로 조회함
				 //ComOpenWait(true); 		
				 formObj.f_cmd.value=SEARCH;
				 //formObj.port_cd.value = ComGetObjValue(formObj.bkg_srch).substring(0, 1) + formObj.org_port_cd.value;
 				 sheetObj.DoSearch("VOP_SCG_5922GS.do", FormQueryString(formObj) );
//				 setBkgStatus(sheetObj);
				 break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }
     function sheet1_OnSearchEnd(sheetObj, code, ErrMsg)
     {
    	 with(sheetObj){
	     	 if (RowCount() > 0) {
	     		 ReDraw=false;
	             SetCellText(LastRow(), "grs_wgt", "T");
	             SetCellText(LastRow(), "net_wgt", "T");
	             SetCellText(LastRow(), "net_explo_wgt", "T");
	             SetMergeCell(LastRow(),1,1,4)
	             ReDraw=true;
	             SetSumText(1,1,"Total");
	          }
	     	var merge = 1;
	     	var compare = "";
	     	
	     	var glbActualColor="#0AAD0A";
			var glbDepartureColor="#80E7F9";
			var glbInitialColor="#D0D0D0";
	     	
	     	for (var checkRow=HeaderRows(); checkRow <= LastRow(); checkRow++) {
	     		
	     		/* GR, NT, NP */
	     		if(GetCellValue(checkRow, "lmt_wgt_tp_cd") == "GR"){
	     			SetCellBackColor(checkRow, "grs_wgt",glbDepartureColor);
	     		}else if(GetCellValue(checkRow, "lmt_wgt_tp_cd") == "NT"){
	     			SetCellBackColor(checkRow, "net_wgt",glbDepartureColor);
	     		}else if(GetCellValue(checkRow, "lmt_wgt_tp_cd") == "NP"){
	     			SetCellBackColor(checkRow, "net_explo_wgt",glbDepartureColor);
	     		}
	     		
	 			var key = GetCellValue(checkRow, "cgo_opr_cd") + GetCellValue(checkRow, "vsl_cd")
	 			        + GetCellValue(checkRow, "skd_voy_no") + GetCellValue(checkRow, "skd_dir_cd")
	 			        + GetCellValue(checkRow, "bkg_no") + GetCellValue(checkRow, "pol_cd")
	 			        + GetCellValue(checkRow, "pod_cd");
	 			
//	 			if(key != compare) {
//	 				compare = key;
//	 				if(merge > 1) {
//	 					SetMergeCell(checkRow-merge, 14, merge, 1);
//	 				}
//	 				merge = 1;
//	 			} else {
//	 				SetCellValue(checkRow, 14, 0, 0);
//	 				merge++;
//	 			}
	    	 }
    	 }
    	 ShowSum();
  	     ComOpenWait(false);
     }
     function sheet1_OnClick(sheetObj, Row, Col, Val)
     {
     }
