/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0135.js
*@FileTitle  : Cargo Release Order E-D/O inquery_E-D/O Issue Application Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/01
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
     * @class esm_bkg_0135 : esm_bkg_0964 business script for
     */
    function esm_bkg_0135() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
    }
    ﻿
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
        /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
        /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
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
        

var HeadTitle1="|bl_no|edo_rct_dt|edo_ack_cd|edo_ack_dt|edo_rct_loc_cd|edo_ack_usr_id|edo_skd_voy_no|edo_skd_dir_cd|edo_vsl_nm|vsl_arr_dt|diff_rmk|edo_rct_loc_nm";
var prefix="sheet1_";

SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );

var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
var headers = [ { Text:HeadTitle1, Align:"Center"} ];
InitHeaders(headers, info);

var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rct_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_ack_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_ack_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rct_loc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_ack_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_skd_voy_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_skd_dir_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_vsl_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_arr_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"diff_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"edo_rct_loc_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
 
InitColumns(cols);

SetEditable(1);
SetCountPosition(0);
SetVisible(0);
                        }
break;
        case "sheet2":
with(sheetObj){
      //sheetHidden init

var HeadTitle=" |arr_area_no|arr_area_vndr_nm|arr_cstms_no|arr_cstms_vndr_nm|pck_qty|pck_tp_cd|cntr_no|gds_desc1|gds_desc2|gds_desc3|gds_desc4|ttl_wgt|wgt_ut_cd|rqst_trsp_dt|inv_amt|inv_curr_cd";
var prefix="sheet2_";

SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
var headers = [ { Text:HeadTitle, Align:"Center"} ];
InitHeaders(headers, info);

var cols = [ {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_area_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_area_vndr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_cstms_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_cstms_vndr_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"gds_desc1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"gds_desc2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"gds_desc3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"gds_desc4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ttl_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rqst_trsp_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];

InitColumns(cols);

SetEditable(1);
SetCountPosition(0);
SetVisible(0);
                }
break;
        case "sheet3":      //sheetHidden init
with(sheetObj){


var HeadTitle=" |pty_rgst_no|pty_nm1|pty_nm2|pty_cntc_pson_nm|phn_no|edo_pty_cd|pty_rep_nm|pty_addr1|pty_addr2|pty_addr3";
var prefix="sheet3_";

SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
var headers = [ { Text:HeadTitle, Align:"Center"} ];
InitHeaders(headers, info);

var cols = [ {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pty_rgst_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pty_nm1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pty_nm2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pty_cntc_pson_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"phn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"edo_pty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pty_rep_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pty_addr1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pty_addr2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pty_addr3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];

InitColumns(cols);

SetEditable(1);
SetCountPosition(0);
SetVisible(0);
                }
break;





        }
    }
    /**
     * Sheet handling process
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //Retrieve
				formObj.f_cmd.value=SEARCH;
                //Multiple retrieve
                var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_"); //prefix string array
                
                var sXml=sheetObjects[1].GetSearchData("ESM_BKG_0135GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
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
     * calling event after retrieving sheet1 
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj=document.form;
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                var prefix="sheet1_"; 
formObj.bl_no.value=sheetObj.GetCellValue(1, prefix + "bl_no");
formObj.edo_rct_dt.value=sheetObj.GetCellValue(1,prefix + "edo_rct_dt");
if (sheetObj.GetCellValue(1,prefix + "edo_ack_cd") == "A") {
formObj.edo_ack_dt_a.value=sheetObj.GetCellValue(1,prefix + "edo_ack_dt");
         		} else {
formObj.edo_ack_dt_r.value=sheetObj.GetCellValue(1,prefix + "edo_ack_dt");
         		}
formObj.edo_rct_loc_cd.value=sheetObj.GetCellValue(1,prefix + "edo_rct_loc_cd");
formObj.edo_rct_loc_nm.value=sheetObj.GetCellValue(1,prefix + "edo_rct_loc_nm");
formObj.edo_ack_usr_id.value=sheetObj.GetCellValue(1,prefix + "edo_ack_usr_id");
formObj.skd_nm.value=sheetObj.GetCellValue(1,prefix + "edo_skd_voy_no") + sheetObj.GetCellValue(1,prefix + "edo_skd_dir_cd");
formObj.edo_vsl_nm.value=sheetObj.GetCellValue(1,prefix + "edo_vsl_nm");
formObj.vsl_arr_dt.value=sheetObj.GetCellValue(1,prefix + "vsl_arr_dt");
formObj.diff_rmk.value=sheetObj.GetCellValue(1,prefix + "diff_rmk");
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }
    /**
    * calling event after retrieving sheet2 
    */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj=document.form;
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                var prefix="sheet2_"; 
formObj.arr_area_no.value=sheetObj.GetCellValue(1, prefix + "arr_area_no");
formObj.arr_area_vndr_nm.value=sheetObj.GetCellValue(1,prefix + "arr_area_vndr_nm");
formObj.arr_cstms_no.value=sheetObj.GetCellValue(1,prefix + "arr_cstms_no");
formObj.arr_cstms_vndr_nm.value=sheetObj.GetCellValue(1,prefix + "arr_cstms_vndr_nm");
formObj.pck_qty.value=ComAddComma2(sheetObj.GetCellValue(1,prefix + "pck_qty"), "#,###");
formObj.pck_tp_cd.value=sheetObj.GetCellValue(1,prefix + "pck_tp_cd");
formObj.gds_desc1.value=sheetObj.GetCellValue(1,prefix + "gds_desc1");
formObj.gds_desc2.value=sheetObj.GetCellValue(1,prefix + "gds_desc2");
formObj.gds_desc3.value=sheetObj.GetCellValue(1,prefix + "gds_desc3");
formObj.gds_desc4.value=sheetObj.GetCellValue(1,prefix + "gds_desc4");
formObj.ttl_wgt.value=ComAddComma2(sheetObj.GetCellValue(1, prefix + "ttl_wgt"), "#,###.00");
formObj.rqst_trsp_dt.value=sheetObj.GetCellValue(1,prefix + "rqst_trsp_dt");
formObj.inv_amt.value=ComAddComma2(sheetObj.GetCellValue(1, prefix + "inv_amt"), "#,###.0");
formObj.cntr_no.value=ComAddComma(sheetObj.GetCellValue(1, prefix + "cntr_no"));
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }
    /**
    * calling event after retrieving sheet3 
    */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg){
       	var formObj=document.form;
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
	            var prefix="sheet3_";
	            for(var i=1; i<=sheetObj.RowCount(); i++) {
if (sheetObj.GetCellValue(i,prefix + "edo_pty_cd") == "MS") {
if (sheetObj.GetCellValue(i,prefix + "pty_rgst_no").length == 10) {
formObj.ms_pty_rgst_no.value=sSaupFormat(sheetObj.GetCellValue(i,prefix + "pty_rgst_no"));
	                    } else {
formObj.ms_pty_rgst_no.value=sheetObj.GetCellValue(i,prefix + "pty_rgst_no");
	                    }
formObj.ms_pty_nm.value=sheetObj.GetCellValue(i, prefix + "pty_nm1")+sheetObj.GetCellValue(i, prefix + "pty_nm2");
formObj.ms_pty_nm2.value=sheetObj.GetCellValue(i, prefix + "pty_nm1")+sheetObj.GetCellValue(i, prefix + "pty_nm2");
formObj.ms_pty_cntc_pson_nm.value=sheetObj.GetCellValue(i,prefix + "pty_cntc_pson_nm");
formObj.ms_phn_no.value=sheetObj.GetCellValue(i,prefix + "phn_no");
}else if (sheetObj.GetCellValue(i,prefix + "edo_pty_cd") == "GA") {
formObj.ga_pty_rgst_no.value=sheetObj.GetCellValue(i,prefix + "pty_rgst_no");
formObj.ga_pty_nm.value=sheetObj.GetCellValue(i, prefix + "pty_nm1")+sheetObj.GetCellValue(i, prefix + "pty_nm2");
}else if (sheetObj.GetCellValue(i,prefix + "edo_pty_cd") == "AS") {
formObj.as_pty_nm.value=sheetObj.GetCellValue(i, prefix + "pty_nm1")+sheetObj.GetCellValue(i, prefix + "pty_nm2");
if (sheetObj.GetCellValue(i,prefix + "pty_rgst_no").length == 10) {
formObj.as_pty_rgst_no.value=sSaupFormat(sheetObj.GetCellValue(i,prefix + "pty_rgst_no"));
	    	        	} else {
formObj.as_pty_rgst_no.value=sheetObj.GetCellValue(i,prefix + "pty_rgst_no");
	    	        	}
formObj.as_pty_rep_nm.value=sheetObj.GetCellValue(i,prefix + "pty_rep_nm");
formObj.as_phn_no.value=sheetObj.GetCellValue(i,prefix + "phn_no");
formObj.as_pty_addr1.value=sheetObj.GetCellValue(i,prefix + "pty_addr1");
formObj.as_pty_addr2.value=sheetObj.GetCellValue(i,prefix + "pty_addr2");
formObj.as_pty_addr3.value=sheetObj.GetCellValue(i,prefix + "pty_addr3");
}else if (sheetObj.GetCellValue(i,prefix + "edo_pty_cd") == "CN") {
formObj.cn_pty_nm.value=sheetObj.GetCellValue(i, prefix + "pty_nm1")+sheetObj.GetCellValue(i, prefix + "pty_nm2");
if (sheetObj.GetCellValue(i,prefix + "pty_rgst_no").length == 10) {
formObj.cn_pty_rgst_no.value=sSaupFormat(sheetObj.GetCellValue(i,prefix + "pty_rgst_no"));
	    	           	} else {
formObj.cn_pty_rgst_no.value=sheetObj.GetCellValue(i,prefix + "pty_rgst_no");
	    	           	}
}else if (sheetObj.GetCellValue(i,prefix + "edo_pty_cd") == "NI") {
formObj.ni_pty_nm.value=sheetObj.GetCellValue(i, prefix + "pty_nm1")+sheetObj.GetCellValue(i, prefix + "pty_nm2");
if (sheetObj.GetCellValue(i,prefix + "pty_rgst_no").length == 10) {
formObj.ni_pty_rgst_no.value=sSaupFormat(sheetObj.GetCellValue(i,prefix + "pty_rgst_no"));
	    	        	} else {
formObj.ni_pty_rgst_no.value=sheetObj.GetCellValue(i,prefix + "pty_rgst_no");
	    	        	}
	                }
	            }	                
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }
    /**
     * The format of the Business Registration Number
     */
    function sSaupFormat(sValue) {
    	 var sDelim="-";
         var re=null;
         var sResultVal=null;
  		 re=new RegExp('([0-9][0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9][0-9])');
  		 sResultVal=sValue.replace(re,'$1' + sDelim + '$2' + sDelim + '$3');
  		 return sResultVal;
    }                  
