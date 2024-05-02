/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0061.js
*@FileTitle  : Cargo Tracking EDI Save/Send - individual
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var selRow=0;
var isFirst1=0;
var isFirst2=0;
var rowCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject0=sheetObjects[0];
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	switch(srcName) {
        	    case "btn_save":       	    	
        	    	doActionIBSheet0(sheetObject0,formObject,IBSAVE);
        	    break;
        	    case "btng_edisend":
        	    	doActionIBSheet0(sheetObject0,formObject,IBINSERT);
        	    break;
        	    case "btn_close":
        	    	ComClosePopup(); 
        	    break;
    	}
    }
    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); 
        }  
        return str;      
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
        doActionIBSheet0(sheetObjects[0],document.form,IBSEARCH);
    }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:     //sheet2 init
                with(sheetObj){
            	         var HeadTitle="SEQ|Cust STS|Location|Actual Date|Actual Date|EDI Date(KST)|EDI Date(LCL)|Updated by|RESULT|FF REF NO|";
            	         SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
            	         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	         var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	         InitHeaders(headers, info);
            	         var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		            	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_sts",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
		            	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"nod",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
		            	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"act_dt_day",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
		            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"act_dt_hour",      KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
		            	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"edi_prc_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		            	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"edi_prc_dt2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		            	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"upd_by",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rslt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"flt_file_ref_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		            	             {Type:"Status",    Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ibflg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	          
            	         InitColumns(cols);
            	         SetEditable(1);
            	         SetColProperty("cust_sts", {ComboText:"|"+CUST_EDI_STS_CDText, ComboCode:"|"+CUST_EDI_STS_CDCode} );
//            	         SetSheetHeight(200);
            	         resizeSheet();
            	   }
                break;
        }
    }
// handling sheet process
    function doActionIBSheet0(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:          
        	    sheetObj.RemoveEtcData();
		        formObj.f_cmd.value=SEARCH01;
//			    sheetObj.DoSearch("ESD_SCE_0061GS.do", SceFrmQryString(formObj), );
			    var sXml = sheetObj.GetSearchData("ESD_SCE_0061GS.do", FormQueryString(formObj));
		        if(sXml != null) sheetObj.LoadSearchData(sXml,{Sync:1})
			    
			    //IBS_EtcDataToForm2(formObj,sheetObj) ;
			    ComEtcDataToForm(formObj,sheetObj);
			    sheetObj.DataInsert(-1);
			    rowCnt=sheetObj.GetSelectionRows();
			    sheetObj.GetCellValue(rowCnt,0)=rowCnt;
                break;
           case IBSAVE:               
		        formObj.f_cmd.value=MULTI01;
		        var insnum=sheetObj.FindStatusRow("I").split(";")[0];
		        if(insnum > 0){
					//if ( sheetObj.CellText(insnum,1) == '' ){
		        	if ( sheetObj.GetCellValue(insnum,1) == '' ){
						alert("Please, Insert CustSTS");
						return false;
					}else if ( sheetObj.GetCellText(insnum,2) == '' || sheetObj.GetCellText(insnum,2).length < 5 ){
						alert("Please, Insert Location");
						return false;
					}else{
						if (sheetObj.GetCellText(insnum,3) == '' || sheetObj.GetCellText(insnum,4) == ''){
							alert("Please, Insert Time");
							return false
						}
					}
					if(formObj.dtl_nod_cd.value != ''){
						if(  formObj.dtl_nod_cd.value.indexOf(sheetObj.GetCellText(insnum,2)) == -1){
							if(!ComShowConfirm(ComGetMsg('SCE90048',''))){
								return;
							}
						}
					}	
					formObj.cust_st.value=sheetObj.GetCellValue(sheetObj.LastRow(), "cust_sts");
					sheetObj.DoAllSave("ESD_SCE_0061GS.do", SceFrmQryString(formObj));
//                    ComEtcDataToForm(formObj,sheetObj) ; //ETC_DATA Insert Function.
//				    if(formObj.TRANS_RESULT_KEY.value != "F"){
//						sheetObj.DataInsert(-1);
//					    rowCnt=sheetObj.GetSelectionRows();
//					    sheetObj.GetCellValue(rowCnt,0)=rowCnt;
//				    }
		        }
                break;
           case IBINSERT:                
		        formObj.f_cmd.value=MULTI02;
		        var insnum=sheetObj.FindStatusRow("I").split(";")[0];
		        if(insnum > 0){
		        	if ( sheetObj.GetCellValue(insnum,1) == '' ){
						alert("Please, Insert CustSTS");
						return false;
					}else if ( sheetObj.GetCellText(insnum,2) == '' || sheetObj.GetCellText(insnum,2).length < 5 ){
						alert("Please, Insert Location");
						return false;
					}else{
						if (sheetObj.GetCellText(insnum,3) == '' || sheetObj.GetCellText(insnum,4) == ''){
							alert("Please, Insert Time");
							return false
						}
					}
					if(formObj.dtl_nod_cd.value != ''){
						if(  formObj.dtl_nod_cd.value.indexOf(sheetObj.GetCellText(insnum,2)) == -1){
							if(!ComShowConfirm(ComGetMsg('SCE90048',''))){
								return;
							}
						}
					}		
					formObj.cust_st.value=sheetObj.GetCellValue(sheetObj.LastRow(), "cust_sts");
					sheetObj.DoAllSave("ESD_SCE_0061GS.do", SceFrmQryString(formObj));
                    
		        }
                break;
        }
    }
    
  function t1sheet_OnSaveEnd(sheetObj,ErrMsg){
	    var formObj = document.form;
        with (sheetObj) {
        	doActionIBSheet0(sheetObjects[0],document.form,IBSEARCH);
        	
        	ComEtcDataToForm(formObj,sheetObj) ; 					
		    if(formObj.TRANS_RESULT_KEY.value != "F"){
			    sheetObj.DataInsert(-1);
			    rowCnt=sheetObj.GetSelectionRows();
			    sheetObj.GetCellValue(rowCnt,0)=rowCnt;
		    }
       }
  }
  
  function resizeSheet(){ // auto-sizing
      ComResizeSheet(sheetObjects[0]);
  } 
    
