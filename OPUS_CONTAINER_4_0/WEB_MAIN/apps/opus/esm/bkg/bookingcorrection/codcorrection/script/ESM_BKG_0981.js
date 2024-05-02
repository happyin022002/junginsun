/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0981.js
*@FileTitle : COD Application at BKG Office
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
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
var prefix1="sheet1_";
var sheetObjects=new Array();
var sheetCnt=0;
//var rdObjects=new Array();
var rdCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
		 var rdObject= viewer;
         /*******************************************************/
         var formObject=document.form;
		 var param="";
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
					case "btn_print":
						param=RdParam(sheetObjects[0],formObject);
					    rdOpen(viewer, formObject,param);
					break; 
					case "btn_close":
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
//		initRdConfig(rdObjects[0]);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);  
    }
	/*
	*Rd setting
	*/
//	function initRdConfig(rdObject){
//		var Rdviewer=rdObject;
//		Rdviewer.AutoAdjust=true;
//		Rdviewer.ViewShowMode(0); 
//		Rdviewer.SetBackgroundColor(128,128,128);
//		Rdviewer.SetPageLineColor(128,128,128);
//		Rdviewer.ApplyLicense("0.0.0.0");
//	}
  /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
					var HeadTitle="|Now Read|Previous|By|By|Office|Date";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
					{Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:prefix1+"now",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:prefix1+"pre",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"usr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"iss_ofc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Format:"####-##-####:##" } ];
					
					InitColumns(cols);
					SetSheetHeight(170);
					SetEditable(1);
				}
           break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		var arrPreFix=new Array("sheet1_");
        switch(sAction) {
          case IBSEARCH:      //retrieve
	         formObj.f_cmd.value=SEARCH; 
 			 var sXml=sheetObj.GetSearchData("ESM_BKG_0981GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
			 sheetObj.RenderSheet(0);
			 sheetObj.LoadSearchData(sXml,{Sync:1} );
			 sheetObj.RenderSheet(1);
			 break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
//        }
        return true;
    }
	/*
	* Rd function
	*/
	function RdParam(sheetObject,formObj) { 
		var strResult=""; 
		var strParam="";
		strParam="'"+ComGetObjValue(formObj.bkg_no)+"'~"+ComGetObjValue(formObj.cod_rqst_seq);
		strResult=rdParamSet(strParam);	
		return strResult; 
	}
	/*
	* Rd open
	*/
	function rdOpen(viewer, formObject, param){
		var Rdviewer= viewer;
		var rdParam="/rp " + param + " /riprnmargin /rwait";
		// 열고자 하는 RD 파일을 지정한다.
		var strPath=RD_path+"apps/opus/esm/bkg/bookingcorrection/codcorrection/report/ESM_BKG_0888.mrd";
		//alert(rdParam + "\n\n" + strPath);
//		Rdviewer.ApplyLicense("0.0.0.0");
//		Rdviewer.openFile(strPath, RDServer + rdParam,{timeout:3000});
		//Rdviewer.CMPrint();
//		viewer.print({isServerSide:true});
		
		var appendReport = [];
		var mrdPath = RD_path+"apps/opus/esm/bkg/bookingcorrection/codcorrection/report/ESM_BKG_0888.mrd";
		var mrdParam = RDServer + rdParam;
		appendReport.push({mrdPath:mrdPath,mrdParam:mrdParam});
		directReportDownload(appendReport);
	}    
