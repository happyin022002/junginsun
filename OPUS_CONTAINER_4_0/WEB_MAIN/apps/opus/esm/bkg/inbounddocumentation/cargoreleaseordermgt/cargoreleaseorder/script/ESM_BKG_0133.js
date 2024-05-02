/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0133.js
*@FileTitle  : Cargo Release Order_E-D/O inquiry _Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
     * @author
     */
    /**
     * @extends
     * @class esm_bkg_0133 : business script for esm_bkg_0964
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
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
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
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
            case "sheet1":      //sheetHidden init
                with(sheetObj){
		             var HeadTitle1="|bl_no|edo_rct_dt|edo_ack_cd|edo_skd_voy_no|edo_skd_dir_cd|edo_ack_dt|vsl_arr_dt|edo_ack_usr_id|edo_rct_loc_cd|edo_vsl_nm|diff_rmk|edo_rct_loc_cd";
		             var prefix="sheet1_";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataGetRowMerge:1 } );
		             var info={ Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		             var headers=[ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols=[ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rct_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_ack_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_skd_voy_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_skd_dir_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_ack_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_arr_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_ack_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rct_loc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_vsl_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"diff_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rct_loc_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		             InitColumns(cols);
		             SetEditable(1);
		             SetVisible(false);
                      }
                break;
            case "sheet2":      //sheetHidden init
                with(sheetObj){
		              var HeadTitle=" |payr_nm|pay_amt_ctnt|pay_curr_cd|payr_bank_nm|payr_bank_acct_no|rqst_edo_iss_dt";
		              var prefix="sheet2_";
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataGetRowMerge:1 } );
		              var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers=[ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols=[ {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"payr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pay_amt_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pay_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"payr_bank_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"payr_bank_acct_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rqst_edo_iss_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetVisible(false);
                    }
                break;
            case "sheet3":      //sheetHidden init
                with(sheetObj){
			             var HeadTitle=" |pty_rgst_no|pty_nm1|pty_nm2|pty_cntc_pson_nm|phn_no|edo_pty_cd";
			             var prefix="sheet3_";
			             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataGetRowMerge:1 } );
			             var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			             var headers=[ { Text:HeadTitle, Align:"Center"} ];
			             InitHeaders(headers, info);
			             var cols=[ {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pty_rgst_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pty_nm1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pty_nm2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pty_cntc_pson_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"phn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"edo_pty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			             InitColumns(cols);
			             SetEditable(1);
			             SetVisible(false);
                      }
	            break;
        }
    }
    /**
     * Sheet handling process
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //Retrieve
				formObj.f_cmd.value=SEARCH;
                //Multiple retrieve
                var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_"); //prefix string array
                var sXml=sheetObjects[1].GetSearchData("ESM_BKG_0133GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                var arrXml=sXml.split("|$$|");
                for(var idx=0; idx < arrXml.length; idx++){
                    sheetObjects[idx].RenderSheet(0);
                    if(idx > 0) {
                        sheetObjects[idx].SetWaitImageVisible(0);
                    }
                    sheetObjects[idx].LoadSearchData(arrXml[idx],{Sync:1} );
                    sheetObjects[idx].RenderSheet(1);
                }
			break;
        }
    }     
    /**
     * handling process after ending sheet1 retrieve
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj=document.form;
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                 //Grid  Data -> Html  argument Copy.
                var prefix="sheet1_"; 
                formObj.bl_no.value=sheetObj.GetCellValue(1, prefix + "bl_no");
                formObj.edo_rct_dt.value=sheetObj.GetCellValue(1,prefix + "edo_rct_dt");
                if (sheetObj.GetCellValue(1,prefix + "edo_ack_cd") == "A") {
                	formObj.edo_ack_dt_a.value=sheetObj.GetCellValue(1,prefix + "edo_ack_dt");
                } else if (sheetObj.GetCellValue(1,prefix + "edo_ack_cd") == "R") {
                	formObj.edo_ack_dt_r.value=sheetObj.GetCellValue(1,prefix + "edo_ack_dt");
         		}
                formObj.skd_nm.value=sheetObj.GetCellValue(1,prefix + "edo_skd_voy_no") + sheetObj.GetCellValue(1,prefix + "edo_skd_dir_cd");
                formObj.vsl_arr_dt.value=sheetObj.GetCellValue(1,prefix + "vsl_arr_dt");
                formObj.edo_ack_usr_id.value=sheetObj.GetCellValue(1,prefix + "edo_ack_usr_id");
                formObj.edo_rct_loc_cd.value=sheetObj.GetCellValue(1,prefix + "edo_rct_loc_cd");
                formObj.edo_rct_loc_nm.value=sheetObj.GetCellValue(1,prefix + "edo_rct_loc_nm");
                formObj.edo_vsl_nm.value=sheetObj.GetCellValue(1,prefix + "edo_vsl_nm");
                formObj.diff_rmk.value=sheetObj.GetCellValue(1,prefix + "diff_rmk");
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }
    /**
    * handling process after ending sheet2 retrieve
    */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj=document.form;
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
            	//Grid  Data -> Html  argument Copy.
                var prefix="sheet2_"; 
                formObj.rqst_edo_iss_dt.value=sheetObj.GetCellValue(1, prefix + "rqst_edo_iss_dt");
                formObj.payr_nm.value=sheetObj.GetCellValue(1,prefix + "payr_nm");
                formObj.pay_amt_ctnt.value=ComAddComma(sheetObj.GetCellValue(1,prefix + "pay_amt_ctnt"));
                formObj.pay_curr_cd.value=sheetObj.GetCellValue(1,prefix + "pay_curr_cd");
                formObj.payr_bank_nm.value=sheetObj.GetCellValue(1,prefix + "payr_bank_nm");
                formObj.payr_bank_acct_no.value=sheetObj.GetCellValue(1,prefix + "payr_bank_acct_no");
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }
    /**
    * handling process after ending sheet3 retrieve
    */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg){
       	var formObj=document.form;
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
            	//Grid  Data -> Html  argument Copy.
	            var prefix="sheet3_";
	            for(var i=1; i<=sheetObj.RowCount(); i++) {
	            	if (sheetObj.GetCellValue(i,prefix + "edo_pty_cd") == "MS") {
	            		formObj.ms_pty_nm.value=sheetObj.GetCellValue(i, prefix + "pty_nm1")+sheetObj.GetCellValue(i, prefix + "pty_nm2");
	            		formObj.ms_pty_cntc_pson_nm.value=sheetObj.GetCellValue(i,prefix + "pty_cntc_pson_nm");
	            		formObj.ms_phn_no.value=sheetObj.GetCellValue(i,prefix + "phn_no");
	            		if (sheetObj.GetCellValue(i,prefix + "pty_rgst_no").length == 10) {
	            			formObj.ms_pty_rgst_no.value=sSaupFormat(sheetObj.GetCellValue(i,prefix + "pty_rgst_no"));
	    	           	} else {
	    	           		formObj.ms_pty_rgst_no.value=sheetObj.GetCellValue(i,prefix + "pty_rgst_no");
	    	           	}
	            	}else if (sheetObj.GetCellValue(i,prefix + "edo_pty_cd") == "AS") {
	            		formObj.as_pty_nm.value=sheetObj.GetCellValue(i, prefix + "pty_nm1")+sheetObj.GetCellValue(i, prefix + "pty_nm2");
	            		if (sheetObj.GetCellValue(i,prefix + "pty_rgst_no").length == 10) {
	            			formObj.as_pty_rgst_no.value=sSaupFormat(sheetObj.GetCellValue(i,prefix + "pty_rgst_no"));
	    	           	} else {
	    	           		formObj.as_pty_rgst_no.value=sheetObj.GetCellValue(i,prefix + "pty_rgst_no");
	    	           	}
	            	}else if (sheetObj.GetCellValue(i,prefix + "edo_pty_cd") == "PR") {
	            		formObj.pr_pty_nm.value=sheetObj.GetCellValue(i, prefix + "pty_nm1")+sheetObj.GetCellValue(i, prefix + "pty_nm2");
	            		if (sheetObj.GetCellValue(i,prefix + "pty_rgst_no").length == 10) {
	            			formObj.pr_pty_rgst_no.value=sSaupFormat(sheetObj.GetCellValue(i,prefix + "pty_rgst_no"));
	    	           	} else {
	    	           		formObj.pr_pty_rgst_no.value=sheetObj.GetCellValue(i,prefix + "pty_rgst_no");
	    	           	}
	                }
	            }	                
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }
    /**
     * Set the format of the input field.
     */
    function sSaupFormat(sValue) {
       	var sDelim="-";
        var re=null;
        var sResultVal=null;
        re=new RegExp('([0-9][0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9][0-9])');
     	sResultVal=sValue.replace(re,'$1' + sDelim + '$2' + sDelim + '$3');
     	return sResultVal;
    }         
