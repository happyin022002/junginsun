/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : COMMON_0430.js
*@FileTitle  : CNTR History Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================*/
// common global variables
// sheet2 : variables for deleting
var delConfirm=true;
// sheet2 : global variables for setting ID as final value when inputting
var maxId="";
var maxYr="";
// sheet2 : variables for tracking modification
var maxIa=[["",""],["",""],["",""]]; 

// function processButtonClick() (S) ============================== //
function btn2Retrieve() {
    if (!checkFormField()) return;
    doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
}

function btn2Save() {
    if (!checkFormField()) return;
    sheetObjects[0].SetWaitImageVisible(0);
    sheetObjects[1].SetWaitImageVisible(0);
    for (Row=1; Row <= sheetObjects[1].LastRow(); Row++) {
        if (sheetObjects[1].GetCellEditable(Row, "mty_pln_no") == 1 && sheetObjects[1].GetCellValue(Row, "mty_pln_no") == '' && sheetObjects[1].CellSearchValue(Row, "mty_pln_no") != '') {
        	ComShowCodeMessage("CTM10049", "EQR Ref. No");
        	sheetObjects[1].SelectCell(Row, "mty_pln_no", true);
        	return false;
        }
        
        if( "I"==sheetObjects[1].GetCellValue(Row, "ibflag") || "U"==sheetObjects[1].GetCellValue(Row, "ibflag") ){
            var newValue = "";
            var rtnValue = "";
            var svrChk = "";
            var param=sheetObjects[1].GetCellValue(Row, "org_yd_cd");
            if (param == "") {
                rtnValue="S";
                svrChk="S";
            } else {
                newValue=param.substring(0,5);
                var rtmXml=sheetObjects[1].GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH14 + "&p_yard1=" + param);
                rtnValue=ComGetEtcData(rtmXml, "rtnValue");
                svrChk=ComGetEtcData(rtmXml, "svrChk");
            }
            if (rtnValue != "S" || svrChk != "S") {
            	sheetObjects[1].SetCellValue(Row, "org_yd_cd",sheetObjects[1].CellSearchValue(Row, "org_yd_cd"),0);
            	clearStatus(sheetObjects[1], Row);
            	sheetObjects[1].SelectCell(Row, "org_yd_cd", true);
                return;
            }
        }
    }
    doActionIBSheet(sheetObjects[1], document.form, MULTI);   
    sheetObjects[1].SetWaitImageVisible(1);
    sheetObjects[0].SetWaitImageVisible(1);
}

function btn2Delete() {
    with (sheetObjects[1]) {
        var sRowStr=FindCheckedRow("del_chk");
        var arr=sRowStr.split("|");
        // prohibiting to delete in case of first row (exclude NEW MT)
        if (arr[0] == 1 && (GetCellValue(arr[0], "mvmt_sts_cd") != "MT" || GetCellValue(arr[0], "cnmv_seq") != 1 || GetCellValue(arr[0], "cnmv_cyc_no") != 1)) {
            ComShowCodeMessage("CTM10031", "first row");
            return;
        } else {
            for (var i=0; i<arr.length; i++) {
                if (GetRowEditable(arr[i])) {
                    var sts=GetCellValue(arr[i], "mvmt_sts_cd");
                    // auto deleting Status after VD
                    if (sts == "VD" || sts == "CD") {
                        if (sts == "VD") {
                            for (var x=Number(arr[i])+1; x<LastRow(); x++) {
                                if (GetCellValue(x, "mvmt_cre_tp_cd") != "C") {
                                    ComShowCodeMessage("CTM20093");
                                    for (var k=0; k<arr.length - 1; k++) {
                                        SetCellValue(arr[k], "del_chk",0,0);
                                    }
                                    return;
                                } else if (GetCellValue(Number(arr[i])+1, "mvmt_cre_tp_cd") == "C" && GetCellValue(Number(arr[i])+1, "mvmt_sts_cd") == "MT" && GetCellValue(Number(arr[i])+2, "mvmt_cre_tp_cd") == "C" && GetCellValue(Number(arr[i])+2, "mvmt_sts_cd") == "XX") {
                                	SetCellValue(arr[i], "del_chk",0,0);
                                    SetRowStatus(arr[i],"R");
                                    ComShowCodeMessage("CTM20120");
                                    return;
                                }
                            }
                        }
                        // stopping in case of no Remark
                        if (GetCellValue(arr[i], "cnmv_rmk") == "") {
                            SetCellValue(arr[i], "del_chk",0,0);
                            SetRowStatus(arr[i],"R");
                            ComShowCodeMessage("CTM20094");
                            SelectCell(arr[i], "cnmv_rmk");
                            return;
                        } else {
                            // deleting all auto created history after VD
                            // copying remark
                            for (var j=arr[i]; j<=LastRow(); j++) {
                                if (j == arr[i] || GetCellValue(j, "mvmt_cre_tp_cd") == "C") {
                                    SetCellValue(j, "cnmv_rmk",GetCellValue(arr[i], "cnmv_rmk"));
                                    SetCellValue(j, "lst_flg","1");
                                    SetRowStatus(j,"D");
                                    SetRowHidden(j,1);
                                } else {
                                    break;
                                }
                            }
                        }
                    } else if (sts == "OP" && arr[i] != LastRow()) {
                        for (var x=Number(arr[i])+1; x<=LastRow(); x++) {
                            if (GetCellValue(x, "del_chk") != 1 && GetCellValue(x, "mvmt_cre_tp_cd") != "C") {
                                ComShowCodeMessage("CTM20109");
                                for (var k=0; k<arr.length - 1; k++) {
                                    SetCellValue(arr[k], "del_chk",0,0);
                                }
                                return;
                            }
                        }
                        deleteRow(sheetObjects[1], arr[i]);
                    // prohibiting to delete in case of NEW MT & existed history after creation
                    } else if (sts == "MT" && GetCellValue(arr[i], "cnmv_seq") == 1 && GetCellValue(arr[i], "cnmv_cyc_no") == 1 && arr[arr.length - 2] < LastRow()) {
                        SetCellValue(arr[i], "del_chk",0,0);
                        SetRowStatus(arr[i],"R");
                        ComShowCodeMessage("CTM20103");
                        return;
                    } else if (sts == "ID" && GetCellValue(Number(arr[i])+1, "mvmt_cre_tp_cd") == "C" && GetCellValue(Number(arr[i])+1, "mvmt_sts_cd") == "XX") {
                    	if (Number(arr[i])+1 != LastRow()) {
                    		ComShowCodeMessage("CTM20121");
                    		for (var k=0; k<arr.length - 1; k++) {
                    			SetCellValue(arr[k], "del_chk",0,0);
                    		}
                    		return;
	                  	} else {
	                    	SetCellValue(arr[i], "del_chk",0,0);
	                        SetRowStatus(arr[i],"R");
	                        ComShowCodeMessage("CTM20120");
	                        return;
	                  	}
                    } else if ((sts == "TN" || sts == "EN") && GetCellValue(Number(arr[i])+1, "mvmt_cre_tp_cd") == "C" && GetCellValue(Number(arr[i])+1, "mvmt_sts_cd") == "XX") {
                    	if (Number(arr[i])+1 != LastRow()) {
                    		ComShowCodeMessage("CTM20122");
                    		for (var k=0; k<arr.length - 1; k++) {
                    			SetCellValue(arr[k], "del_chk",0,0);
                    		}
                    		return;
	                  	} else {
	                  		SetCellValue(arr[i], "del_chk",0,0);
	                        SetRowStatus(arr[i],"R");
	                        ComShowCodeMessage("CTM20120");
	                        return;
	                  	}
//                        // stopping in case of no Remark
//                        if (GetCellValue(arr[i], "cnmv_rmk") == "") {
//                            SetCellValue(arr[i], "del_chk",0,0);
//                            SetRowStatus(arr[i],"R");
//                            ComShowCodeMessage("CTM20094");
//                            SelectCell(arr[i], "cnmv_rmk");
//                            return;
//                        } else {
//                            // deleting all auto created history after TN/EN (SOC)
//                            // copying remark
//                            for (var j=arr[i]; j<=LastRow(); j++) {
//                                if (j == arr[i] || GetCellValue(j, "mvmt_cre_tp_cd") == "C") {
//                                    SetCellValue(j, "cnmv_rmk",GetCellValue(arr[i], "cnmv_rmk"));
//                                    SetCellValue(j, "lst_flg","1");
//                                    SetRowStatus(j,"D");
//                                    SetRowHidden(j,1);
//                                } else {
//                                    break;
//                                }
//                            }
//                        }
                    } else {
                        deleteRow(sheetObjects[1], arr[i]);
                    }
                }
            }
        }
        // handling OP as last deleted item in case all status after OP deleted
        for (var i=LastRow(); i >= 1; i--) {
            if (GetRowStatus(i) != "D") {
                break;
            } else {
            if (GetCellValue(i, "mvmt_sts_cd") == "OP") {
                    SetCellValue(i, "lst_flg","1",0);
                    break;
                }
            }
        }
        delConfirm=true;
    }
}

// function processButtonClick() (E) ============================== //
// function initSheet() (S) ======================================= //
function initSheet2() {
    var cnt=0;
    with(sheetObjects[1]){
        var HeadTitle="|Sel.|CYC|C|STS|A/F|Origin YD|Return YD|Event Date|VVD Code|Booking No.|EQR Ref. No." +
                      "|F/M|I/O|MSG|TP|D|E|R|R|SP|DM|DM Flg DT|DM Unflg DT" +
                      "|Service Provider|Service Provider|SCAC|EDI STOWAGE|Mode|Chassis No.|M.G Set|Seal No.|Waybill|Pick Up No.|Update Date(L)|Creation Date(L)|Update Date(S)|Creation Date(S)" +
                      "|Office|User Name|Remark(s)|ID|SEQ|NO|CNTR_NO|BKG_SPLIT|BKG_KNT|BL_NO|BL_NO_TYPE|BL_NO_CHK|YEAR|FLG|TPSZ|MAX SEQ|CNTR_SVR ID|SVR_ID|EDI1|EDI2|EDI3|EDI4|VVD";
        var sTipAF="[ Auto Flag ]" +
        "<br>A : Missing status automatically created by system" +
        "<br>C : (International) \"TS, IC, MT\" status automatically created after \"VD\"" +
        "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      (USA domestic) \"CM\" status automatically created after \"CD\"" +
        "<br>N : When \"A\" status is modified manually, \"A\" becomes \"N\" status" +
        "<br>M : Added status" + 
        "<br>U : Status updated due to the next status" +
        "<br>E : Status created by Master/Lease" +
        "<br>S : When \"A\" status is modified by EDI message, \"A\" becomes \"S\" status";
        
        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );
        
        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        InitHeaders(headers, info);
        
        var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",               KeyField:0,   CalcLogic:"",   Format:"" },
                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_co_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_cre_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1, ToolTipText:sTipAF },
                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                    {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",          KeyField:1,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
                    // mty_pln_no(ref_no) 추가 start by 2015/06/12 황미연 
                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"mty_pln_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    // mty_pln_no 추가 end
                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fcntr_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                    {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ob_cntr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 , ToolTipText:"Bound indicator"},
                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
                    {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 , ToolTipText:"Cargo type, F: Full, P: Reposition, R: Revenue"},
                    {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_disp_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 , ToolTipText:"Disposal Candidate, Y"},
                    {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"imdt_ext_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 , ToolTipText:"Immediate Exit, Y"},
                    {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_xch_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 , ToolTipText:"Re-stuffing, F(From), T(To)"},
                    {Type:"Text",      Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_rfub_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 , ToolTipText:"Re-furbishing, Y"},
                    {Type:"Text",      Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 , ToolTipText:"Special, Y"},
                    {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_dmg_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 , ToolTipText:"Damage, Y"},
                    {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dmg_flg_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:16 ,ToolTipText:"Damage Flag Date"},
                    {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dmg_unflg_dt",          KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:16 ,ToolTipText:"Damage Unflag Date"},
                    {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 },
                    {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"usa_edi_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_stwg_psn_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mgst_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                    {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"wbl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                    {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"upd_locl_dt",           KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt",           KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"usr_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_id_no" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_seq" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_split_no" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_knt" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_tp" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_chk" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_yr" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"flg" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vr_seq" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_svr_id" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svr_id" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_tp_cd" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_area_cd" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_yrmondy" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_seq" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd" },
                    {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_seq" },
                    {Type:"Text",      Hidden:1,  Width:160,  Align:"Center",  ColMerge:0,   SaveName:"lst_flg" } ];
                               
        InitColumns(cols);

        SetEditable(1);
        //SetColProperty("cnmv_evnt_dt", {Format:"####-##-## ##:##"} );
        //SetColProperty("upd_locl_dt", {Format:"####-##-## ##:##"} );
        //SetColProperty("cre_locl_dt", {Format:"####-##-## ##:##"} );
        //SetColProperty("upd_dt", {Format:"####-##-## ##:##"} );
        //SetColProperty("cre_dt", {Format:"####-##-## ##:##"} );
      //  SetCountPosition(0);
                    SetColProperty(0, "mvmt_sts_cd", {AcceptKeys:"E" , InputCaseSensitive:1});
                    SetColProperty(0, "org_yd_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
                    SetColProperty(0, "dest_yd_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
                    SetColProperty(0, "cntr_id",{AcceptKeys:"E|N" , InputCaseSensitive:1});
                    SetColProperty(0, "fcntr_flg",{AcceptKeys:"E" , InputCaseSensitive:1});
                    SetColProperty(0, "ob_cntr_flg",{AcceptKeys:"E" , InputCaseSensitive:1});
                    SetColProperty(0, "mvmt_edi_msg_tp_id",{AcceptKeys:"E|N" , InputCaseSensitive:1});
                    SetColProperty(0, "bkg_cgo_tp_cd", {AcceptKeys:"E" , InputCaseSensitive:1});
                    SetColProperty(0, "cntr_dmg_flg", {AcceptKeys:"E" , InputCaseSensitive:1});
                    SetColProperty(0, "cntr_disp_flg", {AcceptKeys:"E" , InputCaseSensitive:1});
                    SetColProperty(0, "imdt_ext_flg", {AcceptKeys:"E" , InputCaseSensitive:1});
                    SetColProperty(0, "imdt_ext_flg", {AcceptKeys:"E" , InputCaseSensitive:1});
                    SetColProperty(0, "cntr_xch_cd", {AcceptKeys:"E" , InputCaseSensitive:1});
                    SetColProperty(0, "cntr_rfub_flg", {AcceptKeys:"E" , InputCaseSensitive:1});
                    SetColProperty(0, "spcl_cgo_flg",{AcceptKeys:"E" , InputCaseSensitive:1});
                    SetColProperty(0, "vndr_seq",{AcceptKeys:"N"});
                    SetColProperty(0, "mvmt_trsp_mod_cd",{AcceptKeys:"E|N" , InputCaseSensitive:1});
                    SetColProperty(0, "cntr_seal_no",{AcceptKeys:"E|N" , InputCaseSensitive:1});
                    SetColProperty(0, "wbl_no",{AcceptKeys:"E|N" , InputCaseSensitive:1});
                    SetColProperty(0, "pkup_no",{AcceptKeys:"E|N" , InputCaseSensitive:1});
                    
                    
        SetSheetHeight(354);
    }

}

// function initSheet() (E) ======================================= //
/**
 * handling OnChange event in Sheet2
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
    var rtnXml="";
    var rtnValue="";
    var rtnName="";
    with (sheetObj) {
        var preStatus=GetCellValue(Row-1, "mvmt_sts_cd");
        var curStatus=GetCellValue(Row, "mvmt_sts_cd");
        var nexStatus=GetCellValue(Row+1, "mvmt_sts_cd");
        switch (ColSaveName(Col)) {
            case "cnmv_evnt_dt":
                var nowEvent=GetCellText(Row, Col);
                // checking data format after modifying Event Date
                if (!ComIsDateTime(nowEvent, "", "hm")) {
                    ComShowCodeMessage("CTM00001");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                }
                // comparing EventDate in case Event Date changed
                var befEvent=GetCellText(Row-1, Col);
                var aftEvent=GetCellText(Row+1, Col);
                var mRow=LastRow();
                var nextCreCd=GetCellValue(Row+1, "mvmt_cre_tp_cd");
                if (nextCreCd == "C") aftEvent="";
                for (var i=Row+1; i <= mRow; i++) {
                    atStatus=GetCellValue(i, "mvmt_cre_tp_cd");
                    if (atStatus != "C") {
                        aftEvent=GetCellText(i, Col);
                        break;
                    }
                }
                if (aftEvent == null || aftEvent == "") aftEvent=nowEvent;
                if (nowEvent > aftEvent) {
                    ComShowCodeMessage("CTM20087");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                }
                copyValue2NextRow(sheetObj, Row, Col, Value);    
                if (Row == 1 && Row == mRow) {
                    changeColor(sheetObj, Row);
                } else if (nowEvent > aftEvent && Row == 1) {
                    ComShowCodeMessage("CTM20087");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                } else if (befEvent > nowEvent && Row == mRow) {
                    ComShowCodeMessage("CTM20087");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                } else if ((befEvent > nowEvent || nowEvent > aftEvent) && (Row != mRow && Row != 1)) {
                    ComShowCodeMessage("CTM20087");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                }
                changeColor(sheetObj, Row);
                preSts=GetCellValue(Row - 1, "mvmt_sts_cd");
                if (GetCellValue(Row, "mvmt_sts_cd") == "OC" && (preSts != "EN" && preSts != "TN")) {
                    SetCellValue(Row, "lst_flg","O",0);
                }
                break;
            case "mvmt_sts_cd":
                // prohibiting OP, OC status after IC, ID, VD in case Status is before VL
                rtnXml=GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH09 + "&mvmt_sts_cd=" + curStatus);
                rtnValue=ComGetEtcData(rtnXml, "rtnValue");
                if (rtnValue == "0" || rtnValue == "") {
                    ComShowCodeMessage("CTM20102");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                }
                var AfCd=GetCellText(Row, "mvmt_cre_tp_cd");
                var preAfCd=GetCellText(Row-1, "mvmt_cre_tp_cd");
                if (AfCd == "C") {
                    for (var i=Row - 1; i > 0; i--) {
                        AfC=GetCellText(i, "mvmt_cre_tp_cd");
                        if (AfC != "C") {
                            preStatus=GetCellText(i, "mvmt_sts_cd");
                            AfCd=GetCellText(i, "mvmt_cre_tp_cd");
                            break;
                        }
                    }
                }
                
                // ID/MT 다음 OP/OC 이면 cyc 1 증가
                for(var i=1;i<LastRow();i++){ //[CHM-201222045] CHM-201220798 보완 
                	if( "I"==GetCellValue(i, "ibflag") || "U"==GetCellValue(i, "ibflag") ){
                		// ID/MT - OP/OC
                		if (( "ID" == GetCellValue(i-1, "mvmt_sts_cd") || "MT" == GetCellValue(i-1, "mvmt_sts_cd") )
                			&& ( "OP" == GetCellValue(i, "mvmt_sts_cd") || "OC" == GetCellValue(i, "mvmt_sts_cd") )){
                			var nextCycNo = 0;
                			var nextOriRow = 0; 
                			for(var j=i;j<=LastRow();j++){ // 원래 있던 다음 줄의 cnmv_cyc_no 값 찾기
                				if(GetCellValue(j, "ibflag") != "I"){
                					nextCycNo = GetCellText(j, "cnmv_cyc_no")*1;
                					nextOriRow = j;
                					break;
                				}
                			}
        					copyValueFromToRow(sheetObj,i,nextOriRow); // 아랫줄에서 booking 정보 복사 해옴 //[CHM-201222045]
            				if(GetCellText(i-1, "cnmv_cyc_no")*1 < nextCycNo){ // cyc 1 증가
            					SetCellValue(i, "cnmv_cyc_no", GetCellText(i-1, "cnmv_cyc_no")*1+1, 0);
            				}
                		}else if(i > 1) { // Don't copy from upper row when row number is 1
                			copyValueFromToRow(sheetObj,i,i-1);//윗줄에서 booking 정보 복사 해옴 
                			SetCellValue(i, "cnmv_cyc_no", GetCellText(i-1, "cnmv_cyc_no")*1, 0); // 윗줄에서 cyc 복사 
                		}
                	}
                }
                
                SetCellEditable(Row, "mty_pln_no", 0);
                
                if (curStatus == "XX") {
                    ComShowCodeMessage("CTM20088");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                } else if (((preStatus == "TS" || preStatus == "IC") && preAfCd == "C") && (curStatus == "OP" || curStatus == "OC")) {
                    ComShowCodeMessage("CTM10029");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                } else if (CellSearchValue(Row, Col) == "ID" && (curStatus == "OP" || curStatus == "OC")) {
                    ComShowCodeMessage("CTM10055");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                } else if (nexStatus == "VL" && (curStatus == "IC" || curStatus == "ID")) {
                    ComShowCodeMessage("CTM10029");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                } else if (nexStatus == "XX") {
                    ComShowCodeMessage("CTM20090");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                } else if (curStatus == "VL" || curStatus == "VD") {
                    ComShowCodeMessage("CTM20091");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                } else if ((curStatus == "MT" && (preStatus == "EN" || preStatus == "TN")) || ((curStatus == "EN" || curStatus == "TN") && preStatus == "MT")) {
                    //**************//
                    //** ROW copy **//
                    //**************//
                    for (x=19; x <= 20; x++) { // cntr_rfub_flg ~ spcl_cgo_flg 
                        SetCellValue(Row, x,"",0);
                    }
                    for (x=24; x <= 31; x++) { // vndr_seq  ~ cntr_seal_no 
                        SetCellValue(Row, x,"",0);
                    }
                    SetCellValue(Row, "fcntr_flg","M",0);
                    SetCellValue(Row, "bkg_cgo_tp_cd","",0);
//                    SetCellValue(Row, "mvmt_edi_msg_tp_id","",0);
                    for (x=44; x <= 49; x++) { // cntr_no ~ bl_no_chk  
                        SetCellValue(Row, x,"",0);
                    }
                    SetCellValue(Row, "cntr_no", GetCellValue(Row-1, "cntr_no"),0);
                    SetCellValue(Row, "vvd_cd","",0);
                    
                    SetCellEditable(Row, "mty_pln_no", 1);
                } else if (curStatus == "MT" && (preStatus == "ID" || preStatus == "IC")) {
                    SetCellValue(Row, "fcntr_flg","M",0);
                } else if (curStatus == "OP"){ // [CLT-121108470] 
                    SetCellValue(Row, "fcntr_flg","M",0);
                    SetCellValue(Row, "ob_cntr_flg","O",0);
                }
                
                //////////////////////////////////////////////////////////////////////////////////////

                if (curStatus == "OC" || (preStatus == "OC" && (curStatus == "TN" || curStatus == "EN"))){ //[CHM-201220807]
                    SetCellValue(Row, "fcntr_flg","F",0);
                    SetCellValue(Row, "ob_cntr_flg","O",0);
                }
                // Add 2014.07.22 Validation
                if (Row == LastRow()){
					 if (curStatus == "OC" && CellSearchValue(Row, Col) == "MT"){
						  if(preStatus == "ID"){
							  ComShowCodeMessage("CTM20102");
							  SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
							  clearStatus(sheetObj, Row); // NO METHOD
							  SelectCell(Row, Col, true);
							  return;
						  }else if(preStatus == "OP"){
							   if(preStatus == "OP"){
								   //CellValue2(Row, "cnmv_cyc_no") = CellText(Row -1, "cnmv_cyc_no")*1;
				                   SetCellValue(Row, "cnmv_cyc_no",GetCellText(Row -1, "cnmv_cyc_no")*1,0);
								   //CellValue2(Row, "bkg_no") = CellText(Row -1, "bkg_no");
				                   SetCellValue(Row, "bkg_no",GetCellText(Row -1, "bkg_no"),0);
								   //CellValue2(Row, "bkg_cgo_tp_cd") = "F";
				                   SetCellValue(Row, "bkg_cgo_tp_cd","F",0);
				                   
				                   var queryString="f_cmd=" + SEARCH17 + "&p_bkg_no=" + GetCellValue(Row, "bkg_no");
				 	               xml=GetSearchData("CTMCommonGS.do", queryString);
				 	               rtnValue=ComGetEtcData(xml, "rtnValue");
				 	               if (rtnValue == null || rtnValue == "") {
				 	              	  SetCellValue(Row, "bl_no", "");
				 	               } else {
				 	            	  var rtnStr = rtnValue.split("||");
				 	            	  SetCellValue(Row, "bl_no", rtnStr[4]);
					                  SetCellValue(Row, "bkg_knt", "1");
				 	               }
							   }
							   // dead process
							   // TODO delete below logic
							   else{
								   ComShowCodeMessage("CTM20102");
								   //CellValue2(Row, Col) = CellSearchValue(Row, Col);
				                   SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
								   clearStatus(sheetObj, Row); // NO METHOD
								   //SelectCell(Row, Col, true);
								   SelectCell(Row, Col, true);
								   return;
							   }
						  }else if(preStatus == "EN"||preStatus == "TN"){
							  if(GetCellText(Row -1, "fcntr_flg") == "M" && GetCellText(Row -1, "bkg_cgo_tp_cd") == "" && GetCellText(Row -1, "bkg_no") == ""){
								  //CellValue2(Row -1, "mvmt_sts_cd") = "OP";
				                  SetCellValue(Row -1, "mvmt_sts_cd","OP",0);
								  //CellValue2(Row -1, "cnmv_cyc_no") = CellText(Row -1, "cnmv_cyc_no")*1+1;
				                  SetCellValue(Row -1, "cnmv_cyc_no",GetCellText(Row -1, "cnmv_cyc_no")*1+1,0);
								  //CellValue2(Row -1, "bkg_cgo_tp_cd") = "F";
				                  SetCellValue(Row -1, "bkg_cgo_tp_cd","F",0);
								  //CellValue2(Row -1, "ob_cntr_flg") = "O";
				                  SetCellValue(Row -1, "ob_cntr_flg","O",0);
								  //CellValue2(Row -1, "bkg_no") = CellText(Row, "bkg_no");
				                  SetCellValue(Row -1, "bkg_no",GetCellText(Row, "bkg_no"),0);

								  //CellValue2(Row, "cnmv_cyc_no") = CellText(Row -1, "cnmv_cyc_no")*1;
				                  SetCellValue(Row, "cnmv_cyc_no",GetCellText(Row -1, "cnmv_cyc_no")*1,0);
								  //CellValue2(Row, "bkg_cgo_tp_cd") = "F";
				                  SetCellValue(Row, "bkg_cgo_tp_cd","F",0);
									 
								  if (GetCellText(Row -1, "bkg_no") == "" || GetCellText(Row, "bkg_no") == ""){                      
									  ComShowCodeMessage("CTM10012");
									  SelectCell(Row, "bkg_no", true);
									  return;
								  }						 
		                       }else{
		                    	   ComShowCodeMessage("CTM20102");
		                    	   //CellValue2(Row, Col) = CellSearchValue(Row, Col);
				                   SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
		                    	   clearStatus(sheetObj, Row); // NO METHOD
		                    	   SelectCell(Row, Col, true);
		                    	   return;
		                       }
						  }
					 } else if (curStatus == "OP" && (CellSearchValue(Row, Col) == "TN" || CellSearchValue(Row, Col) == "EN")){
						  if(preStatus == "ID" || preStatus == "MT"){
							  SetCellValue(Row, "cnmv_cyc_no", GetCellText(Row-1, "cnmv_cyc_no")*1+1, 0);
//							  return;
						  }
					 }
                }else if(Row == LastRow() -1){
					 if (curStatus == "OP" && (CellSearchValue(Row, Col) == "EN" || CellSearchValue(Row, Col) == "TN")){
						 //CellEditable(Row, "bkg_no") = true;
		                 SetCellEditable(Row, "bkg_no",true);
						 //CellValue2(Row, "cnmv_cyc_no") = CellText(Row, "cnmv_cyc_no")*1+1;
		                 SetCellValue(Row, "cnmv_cyc_no",GetCellText(Row, "cnmv_cyc_no")*1+1,0);
						 //CellValue2(Row +1, "cnmv_cyc_no") = CellText(Row, "cnmv_cyc_no")*1;
		                 SetCellValue(Row +1, "cnmv_cyc_no",GetCellText(Row, "cnmv_cyc_no")*1,0);
						 //CellValue2(Row, "bkg_cgo_tp_cd") = "F";
		                 SetCellValue(Row, "bkg_cgo_tp_cd","F",0);
						 if (GetCellText(Row, "bkg_no") == "")
							//CellValue2(Row, "bkg_no") = CellText(Row +1, "bkg_no");
		                 	SetCellValue(Row, "bkg_no",GetCellText(Row +1, "bkg_no"),0);
					 }
                }
                // Add 2014.08.07 Validation
                if (curStatus == "OP" && GetCellText(Row, "bkg_no") == ""){
                    ComShowCodeMessage("CTM10012");
                    SetCellEditable(Row, "bkg_no",true);
                    SelectCell(Row, "bkg_no", true);
                    return;
                }
                //////////////////////////////////////////////////////////////////////////////////////
                changeColor(sheetObj, Row);
                break;
            case "cntr_id":
                // VVD should be existed in BKG_VVD two.
                // in case of VL -> POL_CD
                // in case of VD -> POD_CD
                // VVD -> VSL_CD, SKD_VOY_NO, SKD_DIR_CD
                var orgYard=GetCellText(Row, "org_yd_cd");
                var vvdCode=GetCellText(Row, Col);
                if (vvdCode == "") {
                    rtnValue = "S"
                } else {
                	var rtnXml = "";
                	if(GetCellValue(Row, "cntr_id")!="" && GetCellValue(Row, "cntr_id").length==7){
                		if(confirm("Is OSCAR VVD right?")){
                		    strQuery="f_cmd=" + SEARCH06 + "&p_vvd=" + GetCellValue(Row, "cntr_id");
                		    rtnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do", strQuery);
                		    rtnValue=ComGetEtcData(rtnXml, "rtnStr");
                		    
                		    if(rtnValue!=null && rtnValue!="" && rtnValue.length==9){
                		    	document.form.osca_bkg_flg.value = "Y";
                		    	SetCellValue(Row, "cntr_id", rtnValue.trim());
                		    	SetCellEditable(Row, "cntr_id", false);
                		    }
                    	}else{
                    		SelectCell(Row, "cntr_id", true);
                    		return;
                    	}	
                	}else{
                		rtnXml=GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH12 + "&p_yard1=" + orgYard + "&vvdcode=" + vvdCode + "&p_vvd_type=" + curStatus + "&osca_bkg_flg="+document.form.osca_bkg_flg.value);	
                		document.form.osca_bkg_flg.value = "N";
                	}
                    
                    rtnValue=ComGetEtcData(rtnXml, "rtnValue");
                }
                if (rtnValue != "S" && rtnXml.indexOf("ERROR")>-1) {
//                    LoadSearchData(rtnXml,{Sync:1} );
                	alert("VVD doesn't exist.");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                }
                // VVD should be same VL, VD in case of VL, VD
                var curVVD=GetCellText(Row, Col);
                if (curStatus == "VL") {
                    if (confirm(ComGetMsg("CTM20100"))) {
                        SetCellValue(Row+1, "cntr_id",curVVD,0);
                        changeColor(sheetObj, Row+1);
                    } else {
                        SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    }
                } else if (curStatus == "VD") {
                    if (confirm(ComGetMsg("CTM20101"))) {
                        SetCellValue(Row -1, Col,curVVD,0);
                        changeColor(sheetObj, Row-1);
                    } else {
                        SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                        clearStatus(sheetObj, Row);
                        SelectCell(Row, Col, true);
                        return;
                    }
                }
                changeColor(sheetObj, Row);
                break;
            case "org_yd_cd":
            case "dest_yd_cd":
                var newValue="";
                var param=Value;
                if (param == "") {
                    rtnValue="S";
                    svrChk="S";
                } else {
                    newValue=param.substring(0,5);
                    rtmXml=GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH14 + "&p_yard1=" + param);
                    rtnValue=ComGetEtcData(rtmXml, "rtnValue");
                    svrChk=ComGetEtcData(rtmXml, "svrChk");
                }
                if (rtnValue != "S") {
                    ComShowCodeMessage ("CTM10001");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                } else if (svrChk != "S") {
                    ComShowCodeMessage("CTM20072");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                }
                // in case of VL/VD
                if (curStatus == "VL" || curStatus == "VD") {
                    if (param != CellSearchValue(Row, Col)) {
                        if (newValue != CellSearchValue(Row, Col).substring(0, 5)) {
                            ComShowCodeMessage("CTM20092");
                            if (GetRowBackColor(Row) != "#7CFC00") {
                                SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                                clearStatus(sheetObj, Row);
                                SelectCell(Row, Col, true);
                                return;
                            }
                        }
                        changeColor(sheetObj, Row);
                    }
                } else {
                    changeColor(sheetObj, Row);
                }
                var nowYard=Value;
                if (ColSaveName(Col) == "org_yd_cd" && nowYard != GetCellValue(Row+1, Col)) {
                    copyValue2NextRow(sheetObj, Row, Col, Value);   
                }
                break;
            case "fcntr_flg":
                if (Value == "F" || Value == "M") {
                    changeColor(sheetObj, Row);
                    copyValue2NextRow(sheetObj, Row, Col, Value);    
                } else {
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                }
                break;
            case "ob_cntr_flg":
                if (Value == "I" || Value == "O") {
                    changeColor(sheetObj, Row);
                    copyValue2NextRow(sheetObj, Row, Col, Value);    
                } else {
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                }
                break;
            case "vndr_seq":
                if (Value == "") {
                    rtnValue="S";
                    rtnName="";
                } else {
                    rtmXml=GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH15 + "&p_vender=" + Value);
                    rtnValue=ComGetEtcData(rtmXml, "rtnValue");
                    rtnName=ComGetEtcData(rtmXml, "rtnName");
                }
                if (rtnValue != "S") {
                    LoadSearchData(rtmXml,{Sync:1} );
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                    return;
                } else {
                	rtnStr=rtnName.split("|");
                    SetCellValue(Row, "vndr_abbr_nm",rtnStr[0],0);
                    SetCellValue(Row, "usa_edi_cd",rtnStr[1],0);
                    changeColor(sheetObj, Row);
                }
                break;
            case "cntr_dmg_flg":
            case "cntr_disp_flg":
            case "imdt_ext_flg":
            case "cntr_xch_cd":
            case "cntr_rfub_flg":
            case "spcl_cgo_flg":
                if ((Value != "Y" && Value != "")) {
                    SetCellValue(Row, Col,"Y",0);
                    changeColor(sheetObj, Row);
                }
                break;
            case "mvmt_trsp_mod_cd":
                if (Value != "T" && Value != "R" && Value != "B") {
                    ComShowCodeMessage("CTM10016");
                    SetCellValue(Row, Col,CellSearchValue(Row, Col),0);
                    clearStatus(sheetObj, Row);
                    SelectCell(Row, Col, true);
                }
                break; 
            case "mty_pln_no":
                mty_pln_no=GetCellValue(Row, "mty_pln_no");

                if (mty_pln_no == '') {
                	ComShowCodeMessage("CTM10049", "EQR Ref. No");
                	SelectCell(Row, Col, true);
                }
                //Activate after 1st August
//                var queryString="f_cmd=" + SEARCH29 + "&mty_pln_no=" + mty_pln_no;
//                xml=GetSearchData("CTMCommonGS.do", queryString);
//                rtnValue=ComGetEtcData(xml, "rtnValue");
//                if (rtnValue == "N") {
//                    ComShowCodeMessage("CTM20998");
//                	SetCellValue(Row, "mty_pln_no", "");
//                    SelectCell(Row, Col, true);
//                    return;
//                }
                break; 
            case "bkg_no":
            	bkg_no=GetCellValue(Row, "bkg_no");
            	
            	var queryString="f_cmd=" + SEARCH17 + "&p_bkg_no=" + bkg_no;
	              xml=GetSearchData("CTMCommonGS.do", queryString);
	              rtnValue=ComGetEtcData(xml, "rtnValue");
	              if (rtnValue == null || rtnValue == "") {
	              	SetCellValue(Row, "bl_no", "");
	              } else {
	            	  var rtnStr = rtnValue.split("||");
	            	  SetCellValue(Row, "bl_no", rtnStr[4]);
	              }
            	break;
            default:
                changeColor(sheetObj, Row);
                break;
        }
    }
}

/**
* copying Cellvalue in the next row in case of special condition when Onchange event in sheet2
*/
function copyValue2NextRow(sheetObj, Row, Col, Value) {
    with (sheetObj) {
        var preStatus=GetCellValue(Row-1, "mvmt_sts_cd");
        var curStatus=GetCellValue(Row, "mvmt_sts_cd");
        var nexStatus=GetCellValue(Row+1, "mvmt_sts_cd");
        var nextCreCd=GetCellValue(Row+1, "mvmt_cre_tp_cd");
        // in case of XX(C) on next row of ID status
        if (curStatus == "ID" && (nextCreCd == "C" && nexStatus == "XX")) {
            SetCellValue(Row+1, Col,Value,0);
            changeColor(sheetObj, Row+1)
        // in case of XX(C) on next row of TN/EN status
        } else if ((curStatus == "TN" || curStatus == "EN") && (nextCreCd == "C" && nexStatus == "XX")) {
            SetCellValue(Row+1, Col,Value,0);
            changeColor(sheetObj, Row+1)
        // VD, CD
        } else if ((curStatus == "VD" || curStatus == "CD") && (nexStatus == "ID" || nexStatus == "CM" || nexStatus == "IC" || nexStatus == "TS" || nexStatus == "MT")) {
            for (var i=Row+1; i <= LastRow(); i++) {
                var tempCreCd=GetCellValue(i, "mvmt_cre_tp_cd");
                var tempStatus=GetCellValue(i, "mvmt_sts_cd");
                if (tempCreCd == "C" && (tempStatus == "ID" || tempStatus == "CM" || tempStatus == "IC" || tempStatus == "TS" || tempStatus == "MT" || tempStatus == "XX")) {
                    SetCellValue(i, Col,Value,0);
                    changeColor(sheetObj, i);
                } else {
                    break;
                }
            }
        }
    }
}

/**
 * event when clicking cell in IBSheet data part
 * @param {sheetObj} String :  IBSheet cell name
 * @param {Row} Long : cell Row Index
 * @param {Col} Long : cell Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : cell x-coordinate
 * @param {CellY} Long : cell y-coordinate
 * @param {CellW} Long : cell width
 * @param {CellH} Long : cell length
 */
function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    with(sheetObj) {
        if (ColSaveName(Col) != "del_chk") {
            var sRowStr=GetSelectionRows("/");
            var arr=sRowStr.split("/");
            if (arr.length > 1) {
                for (i=0; i<arr.length; i++) {
                    if (GetRowEditable(arr[i])) {
                        SetCellValue(arr[i], "del_chk","1");// checking check box in selected row
                        SetRowStatus(arr[i],"R");
                    }
                }
            }
        }
        if (!GetRowEditable(Row) && !GetRowEditable(Row + 1)) {
            ComBtnDisable("btn2_add");
        } else {
            ComBtnEnable("btn2_add");
        }
    }
}

/**
* handling to add row in sheet2
* adding new row
*/
function addRow() {
    with (sheetObjects[1]) {
        if (SearchRows()< 1) return;
        var nowRow=GetSelectRow();
        var maxRow=LastRow();
        var Sts=GetCellText(nowRow, "mvmt_sts_cd");
        if (Sts == "VL" || Sts == "VD") {
            ComShowCodeMessage("CTM20083");
            return false;
        } else if (nowRow == maxRow) {
            ComShowCodeMessage("CTM20084");
            return false;
        } else {
            // retrieving last information of current ID
            var curId=GetCellText(nowRow, "cnmv_seq");
            var uprDpi=GetCellText(nowRow, "cnmv_split_no");
            var cyclNo=GetCellText(nowRow, "cnmv_cyc_no");
            var compNo=GetCellText(nowRow, "cnmv_co_cd");
            var nowSel=DataInsert();
            var curYear=GetCellText(nowRow, "cnmv_yr");
            // RowBackColor(nowSel) = "#7CFC00";
            var maxId="";
            for (i=0; i < 3; i++) {
                if (maxIa[i][0] == curYear) {
                    maxIa[i][1]=Number(maxIa[i][1]) + 1;
                    maxId=maxIa[i][1];
                    break;
                }
            }
            SetCellValue(nowRow+1, "cnmv_id_no",maxId,0);
            //**************/
            //** ROW copy **/
            //**************/
            var usrOffice=document.form.usr_office.value;
            for (x=15; x <= 19; x++) { // bkg_cgo_tp_cd ~ cntr_rfub_flg
                SetCellValue(nowRow+1, x,GetCellText(nowRow, x),0);
            }
            for (x=20; x <= 32; x++) { // spcl_cgo_flg ~ wbl_no
                SetCellValue(nowRow+1, x,GetCellText(nowRow, x),0);
            }
            if (GetCellText(nowRow, 21) == "N") {
            	SetCellValue(nowRow+1, 22,"",0);
            	SetCellValue(nowRow+1, 23,"",0)
            }
            SetCellValue(nowRow+1, "fcntr_flg",GetCellText(nowRow, "fcntr_flg"),0);
            SetCellValue(nowRow+1, "ob_cntr_flg",GetCellText(nowRow, "ob_cntr_flg"),0);
            for (x=41; x <= 54; x++) { //cnmv_id_no ~ cntr_svr_id
                SetCellValue(nowRow+1, x,GetCellText(nowRow, x),0);
            }
            SetCellValue(nowRow+1, "vvd_cd",GetCellText(nowRow, "vvd_cd"),0);
            SetCellValue(nowRow+1, "ctrt_seq",GetCellText(nowRow, "ctrt_seq"),0);
            SetCellValue(nowRow+1, "cnmv_cyc_no",cyclNo,0);
            SetCellValue(nowRow+1, "cnmv_co_cd",compNo,0);
            maxId++;
            SetCellValue(nowRow+1, "cnmv_seq",curId,0);
            SetCellValue(nowRow+1, "cnmv_yr",curYear,0);
            SetCellValue(nowRow+1, "flg","Y",0);
            SetCellValue(nowRow+1, "mvmt_cre_tp_cd","M",0);
            SetCellValue(nowRow+1, "ofc_cd",usrOffice,0);
            // setting A, B in case SPLIT is NULL(2 Space)
            if (uprDpi == "  " || uprDpi == ""|| uprDpi == " ") {
                SetCellValue(nowRow, "cnmv_split_no","A",0);
                SetCellValue(nowRow+1, "cnmv_split_no","B",0);
                if (GetRowStatus(nowRow) != "I" && GetRowStatus(nowRow) != "D")
                    SetRowStatus(nowRow,"U");
            } else {
                // add 1 in ascii value
                var chrCode=uprDpi.charCodeAt(0) + 1;
                for (var i=nowRow+1; i <= LastRow(); i++) {
                    if ((GetCellText(i, "cnmv_seq") == curId)) {
                        SetCellValue(i, "cnmv_split_no",String.fromCharCode(chrCode),0);
                        var curSts=GetRowStatus(i);
                        if (curSts != "I" && curSts != "D") {
                            SetRowStatus(i,"U");
                        }
                        chrCode++;
                    } else break;
                }
            }
            changeColor(sheetObjects[1] , nowSel);
            return true;
        }
    }
}

/**
* handling to delete row in sheet2
* param : sheetObj , Row ==> Sheet Object line number
* deleting selected current row
*/
function deleteRow(sheetObj, Row) {
    with (sheetObj) {
var rmValue=GetCellValue(Row, "cnmv_rmk");
var status=GetCellValue(Row, "mvmt_sts_cd");
var autoFlag=GetCellValue(Row, "mvmt_cre_tp_cd");
if (GetCellValue(Row, "flg") == "Y") {
            RowDelete(Row);
            return;
        }
        if ((status == "VL" || status == "VD" || autoFlag == "C") && Row != LastRow()) {
            if (Row != LastRow()&& GetCellValue(LastRow(), "mvmt_cre_tp_cd") != "C") {
                SetCellValue(Row, "del_chk",0,0);
                SetRowStatus(Row,"R");
                ComShowCodeMessage("CTM20093");
            } else {
                SetRowStatus(Row,"D");
                SetRowHidden(Row,1);
                if (autoFlag == "C") {
                    SetCellValue(LastRow(), "cnmv_rmk",GetCellValue(Row, "cnmv_rmk"));
                    SetRowStatus(LastRow(),"D");
                    SetRowHidden(LastRow(),1);
                }
            }
        } else if (Row == LastRow()&& autoFlag == "C") {
            SetRowStatus(Row,"D");
            SetRowHidden(Row,1);
        } else if (rmValue == "") {
            SetCellValue(Row, "del_chk",0,0);
            SetRowStatus(Row,"R");
            if (delConfirm) {
                ComShowCodeMessage("CTM20094");
                delConfirm=false;
            }
            SelectCell(Row, "cnmv_rmk", true);
        } else if (status == "XX" || autoFlag == "E" || (status == "MT" && deleteCondition(rmValue.substring(0, 3)))) {    // MT일때는 deleteCondition함수호출
            SetCellValue(Row, "del_chk",0,0);
            SetRowStatus(Row,"R");
            ComShowCodeMessage("CTM20095");
//        } else if ((Row == LastRow()- 1 && status == "ID") && (GetCellValue(LastRow(), "mvmt_cre_tp_cd") == "C" && GetCellValue(LastRow(), "mvmt_sts_cd") == "XX")) {
//        	SetCellValue(LastRow(), "cnmv_rmk",GetCellValue(Row, "cnmv_rmk"));
//            SetRowStatus(Row,"D");
//            SetRowHidden(Row,1);
//            SetRowStatus(LastRow(),"D");
//            SetRowHidden(LastRow(),1);
        } else {
            SetRowStatus(Row,"D");
            SetRowHidden(Row,1);
        }
    }
}

/**
* changing edit status in Row after retrieving Sheet2
*/
function row_Editable4Sheet2() {
    var rowDiableCount=0;    // counting in case GetRowEditablesetting is false
    with (sheetObjects[1]) {
        //RenderSheet(0);
        if (RowCount()< 2) {
            // making delete button enable in case of 1 case & New MT
//            if (GetCellValue(LastRow(), "mvmt_sts_cd") == "MT" && GetCellValue(LastRow(), "cnmv_seq") == 1 && GetCellValue(LastRow(), "cnmv_cyc_no") == 1) {
//                ComBtnEnable("btn2_delete");
//            } else {
                ComBtnDisable("btn2_delete");
//            }
        } else {
            ComBtnEnable("btn2_delete");
        }
        // Editable
        for (i=0; i < 3; i++) {
            maxIa[i][0]="";
            maxIa[i][1]="";
        }
        var lastCyc=GetCellText(LastRow(), "cnmv_cyc_no");
        for (i=1; i <= LastRow(); i++) {
            if (GetCellValue(i, "svr_id") != "1") {
                SetRowEditable(i,0);
                rowDiableCount++;
            } else if (GetCellValue(i, "mvmt_cre_tp_cd") == "C") {    // Disable in case auto created Flag is C
                SetRowEditable(i,0);
                rowDiableCount++;
            } else {
                var currCyc=GetCellText(i, "cnmv_cyc_no");
                SetRowEditable(i,1);
            	SetCellEditable(i, "mty_pln_no", 0);
            	
                if ((lastCyc - currCyc) < 3) {    
                    var status=GetCellValue(i, "mvmt_sts_cd");
                    var prvsts=GetCellValue(i-1, "mvmt_sts_cd");
                    var autoFlag=GetCellValue(i, "mvmt_cre_tp_cd");
                    if (status == "XX" || autoFlag == "E" || (status == "MT" && deleteCondition(GetCellValue(i, "cnmv_rmk").substring(0, 3)))) {    // MT일때는 deleteCondition함수호출
                        for (var j=0; j<=LastCol(); j++) {
//                            if (ColSaveName(j) == "cnmv_evnt_dt") {
//                                SetCellEditable(i, j,1);
//                            } else {
                                SetCellEditable(i, j,0);
//                            }
                        }
                    } else if (status == "VL" || status == "VD") {
                        // prohibiting to modify status in case of VL, VD
                        SetCellEditable(i, "mvmt_sts_cd",0);
                    } else if ((status == "MT" || status == "TN" || status == "EN") && (prvsts == "MT" || prvsts == "TN" || prvsts == "EN" || prvsts == "CM" ) && GetCellText(i, "fcntr_flg") == "M") {
                    	SetCellEditable(i, "mty_pln_no", 1);
                    }
                } else {
                    SetRowEditable(i,0);
                    rowDiableCount++;
                }
            }
            // getting last ID by year
            for (var x0=0; x0 < 3; x0++) {
                if (maxIa[x0][0] == "") {
                    maxIa[x0][0]=GetCellValue(i, "cnmv_yr");
                    maxIa[x0][1]=GetCellValue(i, "vr_seq");
                    break;
                } else if (maxIa[x0][0] == GetCellValue(i, "cnmv_yr")) {
                    maxIa[x0][1]=GetCellValue(i, "vr_seq");
                    break;
                }
            }
        }
        if (LastRow()> 1) {
            SetCellValue(LastRow(), "lst_flg","1",0);
            SetRowStatus(LastRow(),"R");
        }
        if (GetCellValue(LastRow()- 1, "mvmt_sts_cd") == "VD") {
            SetCellValue(LastRow()- 1, "lst_flg","1",0);
            SetRowStatus(LastRow()- 1,"R");
        }
        SelectCell(LastRow(), 0);
        if (RowCount()<= rowDiableCount) {
            ComBtnDisable("btn2_add");
        } else {
            ComBtnEnable("btn2_add");
        }
        //RenderSheet(1);
    }
}

/**
 * validating RowDepte possibility in case of MT
 */
function deleteCondition(rmSubstr) {
    if (rmSubstr == "LSI" ||
        rmSubstr == "DII" ||
        rmSubstr == "SBI" ||
        rmSubstr == "SBR" ||
        rmSubstr == "MUI" ||
        rmSubstr == "MUR" ||
        rmSubstr == "SRI" ||
        rmSubstr == "SRR" ||
        rmSubstr == "TTL" ||
        rmSubstr == "TLL" ||
        rmSubstr == "SCR" ||
        rmSubstr == "DON" ||
        rmSubstr == "SLD" ||
        rmSubstr == "FND") {
        return true;
    } else {
        return false;
    }
}
    
/**
 * FrRow 의 Booking 관련 정보 등을 ToRow 로 복사한다. //copyValueFromNextRow
 */    
    function copyValueFromToRow(sheetObj,ToRow,FrRow){ //FrRow 의 값을 ToRow 로 복사한다
		with (sheetObj) {
			SetCellValue(ToRow, "bkg_no", GetCellText(FrRow, "bkg_no"), 0);
			SetCellValue(ToRow, "bkg_split_no", GetCellText(FrRow, "bkg_split_no"), 0);
			SetCellValue(ToRow, "bkg_knt", GetCellText(FrRow, "bkg_knt"), 0);
			SetCellValue(ToRow, "bl_no", GetCellText(FrRow, "bl_no"), 0);
			SetCellValue(ToRow, "bl_no_tp", GetCellText(FrRow, "bl_no_tp"), 0);
			SetCellValue(ToRow, "bl_no_chk", GetCellText(FrRow, "bl_no_chk"), 0);
			
			SetCellValue(ToRow, "vvd_cd", GetCellText(FrRow, "vvd_cd"), 0);
			SetCellValue(ToRow, "ctrt_seq", GetCellText(FrRow, "ctrt_seq"), 0);
		}
	}
