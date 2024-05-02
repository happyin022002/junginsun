/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1084.js
*@FileTitle  : TPB Issue Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_1068 : business script for ESM_BKG_1068 
     */
    // Common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /* */
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_GotoTPB":
            	doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC01);
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
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        sheet1_OnLoadFinish(sheet1);
    }
	function sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObj,document.form,IBSEARCH);
     }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
            		var HeadTitle1="|Sel.|Seq.|Bkg No.|CNTR No.|CNTR No.|CGO|S/O|MVMT|Incurred Charges|TPB No.";
            		var headCount=ComCountHeadTitle(HeadTitle1);
            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            		             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
            		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no" },
            		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cgo",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"so_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            		             {Type:"Int",       Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"if_amt",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"tpb_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
   
            		InitColumns(cols);
            		SetCountPosition(0);
            		SetEditable(1);
            		SetSheetHeight(200);
            	}
            break;
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        case IBSEARCH:      //retrieve
            if(validateForm(sheetObj,formObj,sAction) == false) break;
	        formObj.f_cmd.value=SEARCH;
	        sheetObj.DoSearch("ESM_BKG_1084GS.do", FormQueryString(formObj) );
            break;
        case IBSEARCH_ASYNC01:        
        	if(validateForm(sheetObj,formObj,sAction) == false) break;
     	    if (sheetObj.RowCount()== 0) {
    		    ComShowCodeMessage("BKG00109"); 
    	        break;
    	    }
     	    var iCheckRow=sheetObj.CheckedRows("chk");
       	    if (iCheckRow < 1) {
        		ComShowCodeMessage("BKG00249");
        		break;
        	}
        	var param="";
        	var p_cnt=0;
        	var p_bkg_no=formObj.bkg_no.value;
        	var p_bl_no=formObj.bl_no.value;
        	var p_trd_party_val=formObj.cust_cd.value;
        	var p_curr_cd="USD";
        	var p_eq_no="";
        	var p_if_amt="";
        	var p_eq_tpsz_cd="";
        	for(var i=0; i<sheetObj.RowCount(); i++) {
        		if(sheetObj.GetCellValue(i+1, "chk") == "1") {
            		p_cnt++;
            		if (p_cnt > 1) p_eq_no += "|$|"; 
            		p_eq_no += sheetObj.GetCellValue(i+1, "cntr_no");
            		if (p_cnt > 1) p_eq_tpsz_cd += "|$|"; 
            		p_eq_tpsz_cd += sheetObj.GetCellValue(i+1, "cntr_tpsz_cd");
            		if (p_cnt > 1) p_if_amt += "|$|"; 
            		p_if_amt += sheetObj.GetCellValue(i+1, "if_amt");
            	}
        	}
        	param="p_bkg_no="        + p_bkg_no        + "&" +
        	        "p_eq_no="         + p_eq_no         + "&" +
        	        "p_if_amt="        + p_if_amt        + "&" +
        	        "p_eq_tpsz_cd="    + p_eq_tpsz_cd    + "&" +
        	        "p_bl_no="         + p_bl_no         + "&" +
//        	        "p_trd_party_val=" + p_trd_party_val + "&" +
        	        "p_curr_cd=USD";
//        	var rtnValue = ComOpenPopupWithTarget('/opuscntr/ESD_TPB_0103.do?pgmNo=ESD_TPB_0103&' + param, 1200, 485, "", "none", true); 
			var width	=1300;
			var height	=633;

        	var pgmNo="ESD_TPB_0103";
			var pgmUrl="/opuscntr/ESD_TPB_0103.do?";
			var parentPgmNo=pgmNo.substring(0, 8) + 'M001';   
//			var src="&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo +"&" + param;
			var src="&pgmNo=" + pgmNo +"&" + param;
			var sFeatures="status=no, width=1024, height=768, resizable=yes, scrollbars=yes";   
//			var winObj = window.open("opusMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);
//			ComOpenWindowCenter("opusMain.screen?parentPgmNo=" + parentPgmNo + src,"ESD_TPB_0103",1024,768,true,"scrollbars=no,resizeable=no")
//			ComOpenWindowCenter(pgmUrl + src, pgmNo, 1024,768, false);
			ComOpenWindowCenter(pgmUrl + src, pgmNo, width,height, false);
			
        	/*if (rtnValue != null) {
        		var arrList=rtnValue.split("|$|");
            	if (arrList != null && arrList.length > 0) {
            		var idx=0;
                	for(var i=0; i<sheetObj.RowCount(); i++) {
                    	if (idx == arrList.length) break;
							if(sheetObj.GetCellValue(i+1, "chk") == "1") {
                    		sheetObj.SetCellValue(i+1, "n3pty_bil_no",arrList[idx++]);
                    	}
                	}
                    formObj.f_cmd.value=MULTI;
                    var sParam=FormQueryString(formObj);
                    var sParamSheet=sheetObj.GetSaveString(false, true, "chk");
                    if (sParamSheet != "") {
                        sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
                    }
                    sheetObj.DoSave("ESM_BKG_1068GS.do", sParam, -1, false);
            	}
        	}*/
        	break;
        }
    }
    // handling event after retrieving
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//    	with (sheetObj) {
//        	for (var i=0; i<RowCount; i++) {
//        		if (CellValue(i+1, "n3pty_bil_yn") == "Y") {
//        			RowEditable(i+1) = false;
//        		}
//        	}
//    	}
    }    
    // handling event after saving
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if (ErrMsg == "") {    	
    		ComBkgSaveCompleted();
    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(sheetObj) {
            switch(sAction) {
          	case IBSEARCH:
       	    	if (!ComChkValid(formObj)) return false;
       	    	break;
            case IBSEARCH_ASYNC01:
            	for(var i=0; i<RowCount(); i++) {
            		if(GetCellValue(i+1, "chk") == "1") {
            			if (GetCellValue(i+1, "if_amt") == "") {
                			ComShowCodeMessage("BKG40088");
                			return false;
                		}
                	}
            	}
            	break;
            }
        }
        return true;
    }    