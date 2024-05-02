/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0061.js
*@FileTitle  : Inquiry By BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
/* Developer's task */
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
    /***** Specify additional sheet variable in case of using more than two sheet per tab *****/
    /*******************************************************/
    var formObject=document.form;
    try { 
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheet1,formObject,IBSEARCH);
                break;
            case "btn_downexcel":
                doActionIBSheet(sheet1,formObject,IBDOWNEXCEL);
                break;
            case "btng_costdetail":
                if(sheet1.RowCount()>2 && sheet1.GetSelectRow()== 2){ //Select "All" when the route_no is more than two
                    ComShowMessage(ComGetMsg("COA10032"));
                } else {
                    doActionIBSheet(sheet3,formObject,IBSEARCH);
                }
                break;
            case "bu_zoom_in":
            	sheet3.SetSheetHeight(200);
                div_zoom_in.style.display="none";
                div_zoom_out.style.display="inline";
                break;
            case "bu_zoom_out":
                sheet3.SetSheetHeight(400);
                div_zoom_in.style.display="inline";
                div_zoom_out.style.display="none";  
                break;
            case "btns_remarks":
                btng_remarks_OnClick(sheet2);
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
    * initializing sheet
    * implementing onLoad event handler in body tag
    * adding first-served functions after loading screen.
*/
function loadPage() {
    var title="";
    var formObject=document.form;
    loadingMode=true; 
    doActionIBSheet(sheet1,document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k], k+1);
    }
    for(i=0;i<sheetObjects.length;i++){
        //Sheet configuration setting function(start)
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1, title);
        //Sheet configuration setting function(end)
        ComEndConfigSheet(sheetObjects[i]);
    }       
    getProLev();
    if (formObject.s_pro_vw.value !=null&&formObject.s_pro_vw.value !=""){
        setRetrieveAction()         
    }       
    ComSetFocus(formObject.f_bkg_no);
    loadingMode=false;
}
 /**
  * Multi-combo handling
        * initializing Tab
        * setting Tab items
 */
function initCombo (comboObj, comboNo) {
     with (comboObj) {
        SetDropHeight(300);
        SetSelectIndex(0);
    }
} 
/**
        * setting sheet initial values and header
        * param : sheetObj, sheetNo
        * adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo, title) {
    var cnt=0;
    var colCnt=0;
    var colTotNum=0;
    var aryTitle=new Array();
    var t1="";
    if (title != ""){
        t1=title;
        aryTitle=title.split("|");
    }
    switch(sheetNo) {
        case 1:     //sheet1 init
            with(sheetObj){
                var HeadTitle="H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|" +
                "Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|T/Time";
                //SJH.20141027.ADD
                var HeadTitle1="H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|Route No|Mty Pkup ECC|POR|Inter Change|POL|Lane|1st T/S|Lane|2nd T/S|Lane|3rd T/S|Lane|POD|Inter Change|DEL|Mty Rtn ECC|(day)" ;
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
				SetConfig( { SearchMode:2, Page:100, DataRowMerge:0, MergeSheet:7  } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pctl_no" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sls_ofc_cd" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"shipper" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vvd" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_de_term_cd" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcv_term_cd" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rep_cmdt_cd" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"shpr_nm" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clt_ofc_cd" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_dg_cgo_flg" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_bb_cgo_flg" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_awk_cgo_flg" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_rc_flg" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"soc_flg" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sls_yrmon" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bkg_cgo_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_wgt_tp_cd" },
                            {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"cost_rout_no" },
                            {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cost_rout_no2" },
                            {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mty_pkup_ecc" },		//SJH.20141027.ADD
                            {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd" },
                            {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ob_itchg_ctnt" },
                            {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd" },
                            {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_rlane_cd" },
                            {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n1st_ts_port_cd" },
                            {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_rlane_cd" },
                            {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n2nd_ts_port_cd" },
                            {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_rlane_cd" },
                            {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3rd_ts_port_cd" },
                            {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4rd_rlane_cd" },
                            {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd" },
                            {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ib_itchg_ctnt" },                            
                            {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd" },
                            {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mty_rtn_ecc" },		//SJH.20141027.ADD
                            {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hrs",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                                                                   
                InitColumns(cols);
                
                SetEditable(0);
                SetCountPosition(0);
                //SetRangeBackColor(1, 27, 1, 39,"#DEFBF8");
                SetHeaderRowHeight(10);
                SetSheetHeight(140);
            }

            break;
        case 2:     //sheet2 init
            with (sheetObj) {
                var tot="";
                var colWidth1=0;
                if (t1 != ""){
                    colCnt=aryTitle.length;
                    colTotNum=colCnt + 2;
                    t1=t1 + '|';
                } else {
                    colTotNum=2;
                }

                SheetWidth=mainTable1.clientWidth;

                if (colTotNum == 2) {
                    colWidth1=140;
                } else {
                    colWidth1=SheetWidth / colTotNum;
                }
                var HeadTitle="TP/SZ|"+t1+"Total" ;
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:1, DataRowMerge:0 } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                //SJH.20141201.MOD : Width mod
                var cols = [ {Type:"Text",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd" } ];
                if (t1 != "") {
                    for (var i=0; i<colCnt ; i++) {
                        cols.push({Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:aryTitle[i],     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 });
                    }
                }
                cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"b0",            KeyField:0,   CalcLogic:tot,  Format:"NullFloat",   PointCount:2 });
                
                InitColumns(cols);
                
                SetEditable(0);
                SetCountPosition(0);
                SetSheetHeight(205);
            }
                
            break;
        case 3:     //sheet3 init
            with(sheetObj){
                var HeadTitle="Node Link|Activity Group|Activity Group|Activity Group|Cost Group/Cost Element|Cost Group/Cost Element|Feeder Term|Feeder Term|Amount|lvl" ;
                var HeadTitle1="Node Link|Activity Group|Activity Group|Activity Group|Cost Group/Cost Element|Cost Group/Cost Element|Rev_Term|Del_Term|Amount|lvl" ;
                
//                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
				SetConfig( { SearchMode:2, Page:100, DataRowMerge:0, MergeSheet:7  } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"nod_cd" },
                            {Type:"Text",     Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"grp" },
                            {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"dw_nod_cd" },
                            {Type:"Text",     Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dw_grp" },
                            //SJH.20141103 : 원복
                            {Type:"Text",     Hidden:0,  Width:220,  Align:"Left",    ColMerge:1,   SaveName:"tree_col" , TreeCol:1 },
//                          {Type:"Text",     Hidden:0,  Width:220,  Align:"Left",    ColMerge:0,   SaveName:"tree_col" },
                            {Type:"Text",     Hidden:0,  Width:220,  Align:"Left",    ColMerge:0,   SaveName:"dw_tree_col" },
                            {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"wtr_rcv_term_cd" },
                            {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"wtr_de_term_cd" },
                            {Type:"AutoSum",  Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"amt", KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2 },
                            {Type:"Text",     Hidden:1, Width:80,   Align:"Center",   ColMerge:1,   SaveName:"lvl" } ];
                                                                   
                InitColumns(cols);
                
                SetEditable(0);
                SetCountPosition(0);
                //SetRangeBackColor(1, 6, 1, 7,"#DEFBF8");
                //InitTreeInfo("tree_col", "", "#0000FFNAN");
                SetSheetHeight(200);
                SetColHidden("nod_cd",0);
                SetColHidden("grp",0);
                SetColHidden("tree_col",0);
                SetColHidden("dw_nod_cd",1);
                SetColHidden("dw_grp",1);
                SetColHidden("dw_tree_col",1);
            }

            break;
    }
}
/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
} 
function f_pro_vw_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
	comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
} 
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
*/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/*To retrieve when the screen is loaded */
function setRetrieveAction(){
    formObj=document.form;
    formObj.f_cmd.value=SEARCHLIST01;       
    doActionIBSheet(sheet1,formObj,IBSEARCH);
}   
/**
 *  window
 */
function chgOption() {
    var formObj=document.form;
    formObj.f_cmd.value=SEARCHLIST03;
}
/**
 * Check mandatory input when searching
 */
function colView(){
    var formObject=document.form;
    doActionIBSheet(sheet3,formObject,IBSEARCH);
}
/**
 * Getting a variable
 */ 
 function getProLev() {
     var formObj=document.form;
     if (formObj.s_pro_vw.value==null||formObj.s_pro_vw.value==""){
     } else {   
         ComSetObjValue(f_pro_vw,formObj.s_pro_vw.value); 
     }
     if (formObj.s_pro_lvl.value==null||formObj.s_pro_lvl.value==""){
    	 f_pro_lvl.SetSelectCode("C", false);
     } else {
         ComSetObjValue(f_pro_lvl,formObj.s_pro_lvl.value);  
     }
     
 }
/**
 * It is retrieved by clicking the remark button
 */
function btng_remarks_OnClick(sheetObj){
    document.form.f_cmd.value=SEARCHLIST01;
    //SJH.20141107.MOD : SIZE MOD
    ComOpenWindow2('ESM_COA_0170.do?' 
    + coaFormQueryString(document.form), '_RMK', 'width=1000,height=660,menubar=0,status=0,scrollbars=0,resizable=1');
}
/**
 * Setting the top of the information after retrieved sheet1
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    ComOpenWait(false);
    if(sheetObj.RowCount("R") != 0){
        var fObj=document.form;
        fObj.f_bkg_split.value=sheetObj.GetCellValue(2, "bkg_no");
        fObj.f_ofc.value=sheetObj.GetCellValue(2, "sls_ofc_cd");
        fObj.f_shipper.value=sheetObj.GetCellValue(2, "shipper");
        fObj.f_ioc.value=sheetObj.GetCellValue(2, "ioc_cd");
        fObj.f_rlane.value=sheetObj.GetCellValue(2, "rlane_cd");
        fObj.f_vvd.value=sheetObj.GetCellValue(2, "vvd");
        fObj.f_dterm.value=sheetObj.GetCellValue(2, "bkg_de_term_cd");
        fObj.f_rterm.value=sheetObj.GetCellValue(2, "bkg_rcv_term_cd");
        fObj.f_rcmdt.value=sheetObj.GetCellValue(2, "rep_cmdt_cd");
        fObj.f_cost_yrmon.value=sheetObj.GetCellValue(2, "cost_yrmon");
        fObj.f_sls_yrmon.value=sheetObj.GetCellValue(2, "sls_yrmon");
        fObj.f_cost_wk.value=sheetObj.GetCellValue(2, "cost_wk");
        fObj.f_clt_ofc_cd.value=sheetObj.GetCellValue(2, "clt_ofc_cd");
        if(sheetObj.GetCellValue(2, "spcl_dg_cgo_flg") == 'Y' || sheetObj.GetCellValue(2, "spcl_dg_cgo_flg") == '1') fObj.f_spcl_dg.checked=true;
        else fObj.f_spcl_dg.checked=false;
        if(sheetObj.GetCellValue(2, "spcl_bb_cgo_flg") == 'Y' || sheetObj.GetCellValue(2, "spcl_bb_cgo_flg") == '1') fObj.f_spcl_bb.checked=true;
        else fObj.f_spcl_bb.checked=false;
        if(sheetObj.GetCellValue(2, "spcl_awk_cgo_flg") == 'Y' || sheetObj.GetCellValue(2, "spcl_awk_cgo_flg") == '1') fObj.f_spcl_ak.checked=true;
        else fObj.f_spcl_ak.checked=false;
        if(sheetObj.GetCellValue(2, "spcl_rc_flg") == 'Y' || sheetObj.GetCellValue(2, "spcl_rc_flg") == '1') fObj.f_spcl_rf.checked=true;
        else fObj.f_spcl_rf.checked=false;
        if(sheetObj.GetCellValue(2, "soc_flg") == 'Y' || sheetObj.GetCellValue(2, "soc_flg") == '1') fObj.f_soc_flg.checked=true;
        else fObj.f_soc_flg.checked=false;
        if(sheetObj.GetCellValue(2, "bkg_cgo_tp_cd") == 'R' || sheetObj.GetCellValue(2, "bkg_cgo_tp_cd") == '1') fObj.f_mt_rev.checked=true;
        else fObj.f_mt_rev.checked=false;
        fObj.f_bkg_cgo_wgt.value=sheetObj.GetCellValue(2, "bkg_cgo_wgt");
        fObj.f_bkg_wgt_tp_cd.value=sheetObj.GetCellValue(2, "bkg_wgt_tp_cd");
        fObj.bkg_sts.value=sheetObj.GetCellValue(2, "bkg_sts_cd");
        ComChkObjValid(fObj.f_bkg_cgo_wgt);
        document.getElementById("div_shipper").innerHTML=sheetObj.GetCellValue(2, "shpr_nm");
    } else {// form reset
        document.form.reset();
        f_pro_lvl.SetSelectCode("C", false);			//SJH.20141027.ADD
        f_pro_vw.SetSelectCode("P", false);			//SJH.20141027.ADD
    }
}
function sheet1_OnDblClick(sheetObj , row, col , value) {
    // Prohibit button click when a business transaction is processing 
    sheetObj.SetWaitImageVisible(0);
    ComOpenWait(true);
    var formObj=document.form;
    formObj.f_cmd.value=SEARCHLIST02;
    formObj.f_rout_no.value=sheetObj.GetCellValue(row, "cost_rout_no");
    formObj.f_pctl_no.value=sheetObj.GetCellValue(row, "pctl_no");
    var sXml=sheet2.GetSearchData("ESM_COA_0061GS2.do", coaFormQueryString(formObj));
    var header=searchEtcData("header", sXml);
    if(header != ""){
    	sheetObjects[1].RemoveAll();
    	sheetObjects[1]=sheetObjects[1].Reset();	//SJH.20141103 : 엑셀다운로드시 reset할땐 그객체에 다시 받아줘야함.
        initSheet(sheetObjects[1], 2, header);
        sheet2.LoadSearchData(sXml,{Sync:1} );
    }
    // Initializing sheet3
    sheet3.RemoveAll();
    ComOpenWait(false);
}
/**
* calculate total data after sheet2 is retrieved
*/
function sheet2_OnSearchEnd(sheetObj, ErrMsg){
    ComOpenWait(false);
    //SJH.20141223.MOD : FOR문으로 수정..
    //setting total value   
    for(var Rw = sheetObj.HeaderRows(); Rw <= sheetObj.LastRow(); Rw++) {
    	var totVal=0.00;    
        for(var Col = 1 ; Col <= sheetObj.LastCol()-1 ; Col++) {
        	totVal += parseFloat(sheetObj.GetCellValue(Rw, Col));
        }
        sheetObj.SetCellValue(Rw,sheetObj.LastCol(),totVal,0);
    }
    if(getIbComboObjValue(f_pro_lvl) == "C"){
    	sheetObj.SetRowHidden(5,1);
    }
    sheetObj.FitColWidth();
}
/**
Folding tree level
*/
function sheet3_OnSearchEnd(sheetObj, errMessge) {
    ComOpenWait(false);
    
	for (i=1;i<=sheetObj.RowCount()+1;i++) {
		if (sheetObj.GetCellValue(i,"lvl") == "1") {
			sheetObj.SetCellValue(i,"tree_col", "+ " + sheetObj.GetCellValue(i,"tree_col"));
		} else if (sheetObj.GetCellValue(i,"lvl") == "2") {		//child 데이터는 ' -'를 앞에 달고, 최초에는 숨기기
			sheetObj.SetCellValue(i,"tree_col", "  └ " + sheetObj.GetCellValue(i,"tree_col"));
			sheetObj.SetRowHidden(i,1);
		}
	}
	sheetObj.ShowTreeLevel(0, 1);		//SJH.20141201.MOD
	//sheetObj.ShowTreeLevel(-1);
    sheetObj.SetSumText(0, "TOTAL");
	sheetObj.SetDataMerge();
    sheetObj.FitColWidth();
}
// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR: //Inquiry
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            //setTimeout( function () {					//SJH.20140904.MOD
	            formObj.f_cmd.value=INIT;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0061GS.do", coaFormQueryString(formObj)); 
	            var arrXml=sXml.split("|$$|");
	            formObj.f_ofc_cd.value=ComGetEtcData(arrXml[0], "ofc_cd"); 
	            formObj.f_ofc_lvl.value=ComGetEtcData(arrXml[0], "ofc_lvl"); 
	            if (arrXml.length > 0)
	                ComXml2ComboItem(arrXml[0], f_pro_vw, "code", "name");
	            	f_pro_vw.SetSelectIndex(0);
	            if (arrXml.length > 1)
	                ComXml2ComboItem(arrXml[1], f_pro_lvl, "code", "name");
	            	f_pro_lvl.SetSelectIndex(1);
	            	f_pro_lvl.SetEnable(false);
	            if (arrXml.length > 2)
	                ComXml2ComboItem(arrXml[2], p_cntr_tpsz_cd, "code", "code");
	            	p_cntr_tpsz_cd.SetSelectIndex(0);
	            	
				//SJH.20141015.ADD
				p_type_cd.InsertItem(0, "EPP A", "A");
				p_type_cd.InsertItem(1, "EPP B", "B");
				p_type_cd.SetSelectIndex(0);	            	
	            ComOpenWait(false);
            //}, 100);									//SJH.20140904.MOD
            break;
        case IBSEARCH:      //Inquiry
            if(validateForm(sheetObj,formObj,sAction))
            {
            	//SJH.20141029.ADD
            	formObj.f_type_cd.value = getComboObjValue(p_type_cd);
            	formObj.f_cntr_tpsz_cd.value = getComboObjValue(p_cntr_tpsz_cd);
                if ( sheetObj.id == "sheet1" ) {
                    // Prohibit button click when a business transaction is processing 
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    setTimeout( function () {
	                    formObj.f_cmd.value=SEARCHLIST01;
	                    sheetObj.DoSearch("ESM_COA_0061GS.do", coaFormQueryString(formObj) ,{Sync:2} );
	                    // Form Data setting
	                    //------------------------------------
	                    ComEtcDataToForm(formObj, sheetObj);
	                    sheetObj.RemoveEtcData();
	                    //------------------------------------
	                    sheet2.RemoveAll();
	                    sheet3.RemoveAll();
	                    ComOpenWait(false);
                    }, 100);
                }
                else if ( sheetObj.id == "sheet2" ) {
                    // Prohibit button click when a business transaction is processing 
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    setTimeout( function () {
	                    formObj.f_cmd.value=SEARCHLIST02;
	                    formObj.f_pctl_no.value=sheet2.cellValue(1, "pctl_no");
	                    var sXml=sheetObj.GetSearchData("ESM_COA_0061GS2.do", coaFormQueryString(formObj) , {Sync:2});
	                    var header=searchEtcData("header", sXml);
	                    if(header != ""){
	                        // Initializing header info
	                        //-------------------------
	                        //sheetObj.RenderSheet(0);
	                        sheetObj.RemoveAll();
	                        sheetObj = sheetObj.Reset();
	                        initSheet(sheetObj, 2, header);
	                        //sheetObj.RenderSheet(1);
	                        // Loading data
	                        //-------------------------
	                        sheetObj.LoadSearchData(sXml,{Sync:1} );
	                        //-------------------------
	                    }
	                    ComOpenWait(false);
                    }, 100);
                }
                else if ( sheetObj.id == "sheet3" ) {
                    // Prohibit button click when a business transaction is processing 
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    setTimeout( function () {
	                    formObj.f_cmd.value=SEARCHLIST03;
	                    sheetObj.DoSearch("ESM_COA_0061GS2.do", coaFormQueryString(formObj) ,{Sync:2} );
	                    ComOpenWait(false);
                    }, 100);
                }
            }
            break;
        case IBSAVE:        //Save
            break;
        case IBINSERT:      // Insert
            sheetObj.DataInsert();
            break;
        case IBCOPYROW:     // Row copy
            sheetObj.DataCopy();
            break;
        case IBDOWNEXCEL:       // Excell download
			if(sheetObjects[0].RowCount() < 1){//no data
				  ComShowCodeMessage("COM132501");
				  return;
			}        	
        	var excelType=selectDownExcelMethod(sheetObj);
            break;
        case IBLOADEXCEL:       // Excel upload
            sheetObj.LoadExcel();
            break;
    }
}

/**
* Handling process for form object input validation
*/
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if (f_bkg_no.value == "") {
            ComAlertFocus(f_bkg_no, ComGetMsg("COA10002", "bkg_no", ""));
            return false;
        }
    }
    return true;
}
function getIbComboObjValue(obj){
    if (ComGetObjValue(obj) == "All" ){
        return "";
    }
    return ComGetObjValue(obj);
 } 

function sheet3_OnClick(sheetObj, row, col){
	switch(sheetObj.ColSaveName(col)){
	case "tree_col":
		var mark=sheetObj.GetCellValue(row, "lvl");
		var status=sheetObj.GetRowStatus(row);
		if(mark == "3"){
			var startRow = row + 1;
			var endRow = sheetObj.GetMergedEndCell(row+1, "lvl").split(",")[0];
			sheetObj.SetCellValue(row,"tree_col", "+"+sheetObj.GetCellValue(row,"tree_col").substr(1));
			sheetObj.SetCellValue(row,"lvl","1");
			for(;startRow <= endRow;startRow++){
				sheetObj.SetRowHidden(startRow,1);
			}
		}
		else if(mark == "1"){
			var startRow = row + 1;
			var endRow = sheetObj.GetMergedEndCell(row+1, "lvl").split(",")[0];
			sheetObj.SetCellValue(row,"tree_col", "-"+sheetObj.GetCellValue(row,"tree_col").substr(1));
			sheetObj.SetCellValue(row, "lvl", "3");
			for(;startRow <= endRow;startRow++){
				sheetObj.SetRowHidden(startRow,0);
			}
		}
		sheetObj.SetDataMerge();
		break;
	}
}
/* Developer's task ends */

function getComboObjValue(obj){
	 	if (ComGetObjValue(obj) == "All") return "";
	 	return ComGetObjValue(obj);
} 

//SJH.20141104.ADD
function callBackExcelMethod(excelType){
	var sheetObj = sheetObjects[0];
	sheetObjects[0].Down2ExcelBuffer(true);
    switch (excelType) {
        case "AY":
            if ( sheetObjects[0].RowCount()> 0 ) sheetObjects[0].Down2Excel({FileName:'Inquiry by BKG',SheetName:'sheet1', HiddenColumn:0, SheetDesign:1, Merge:1}); 
            if ( sheetObjects[1].RowCount()> 0 ) sheetObjects[1].Down2Excel({FileName:'Inquiry by BKG',SheetName:'sheet2', HiddenColumn:0, SheetDesign:1, Merge:1}); 
            if ( sheetObjects[2].RowCount()> 0 ) sheetObjects[2].Down2Excel({FileName:'Inquiry by BKG',SheetName:'sheet3', HiddenColumn:0, SheetDesign:1, Merge:1, DownTreeHide:1}); 	//SJH.20141201.ADD : 트리펼쳐서 다운           
            break;
        case "AN":
        	if ( sheetObjects[0].RowCount()> 0 ) sheetObjects[0].Down2Excel({FileName:'Inquiry by BKG',SheetName:'sheet1', HiddenColumn:0, SheetDesign:0, Merge:0}); 
            if ( sheetObjects[1].RowCount()> 0 ) sheetObjects[1].Down2Excel({FileName:'Inquiry by BKG',SheetName:'sheet2', HiddenColumn:0, SheetDesign:0, Merge:0}); 
            if ( sheetObjects[2].RowCount()> 0 ) sheetObjects[2].Down2Excel({FileName:'Inquiry by BKG',SheetName:'sheet3', HiddenColumn:0, SheetDesign:0, Merge:0, DownTreeHide:1});	//SJH.20141201.ADD : 트리펼쳐서 다운
	    	break;
        case "DY":
        	if ( sheetObjects[0].RowCount()> 0 ) sheetObjects[0].Down2Excel({FileName:'Inquiry by BKG',SheetName:'sheet1', HiddenColumn:1, SheetDesign:1, Merge:1}); 
            if ( sheetObjects[1].RowCount()> 0 ) sheetObjects[1].Down2Excel({FileName:'Inquiry by BKG',SheetName:'sheet2', HiddenColumn:1, SheetDesign:1, Merge:1}); 
            if ( sheetObjects[2].RowCount()> 0 ) sheetObjects[2].Down2Excel({FileName:'Inquiry by BKG',SheetName:'sheet3', HiddenColumn:1, SheetDesign:1, Merge:1, DownTreeHide:1});  	//SJH.20141201.ADD : 트리펼쳐서 다운
        	break;
        case "DN":
        	if ( sheetObjects[0].RowCount()> 0 ) sheetObjects[0].Down2Excel({FileName:'Inquiry by BKG',SheetName:'sheet1', HiddenColumn:1, SheetDesign:0, Merge:0}); 
            if ( sheetObjects[1].RowCount()> 0 ) sheetObjects[1].Down2Excel({FileName:'Inquiry by BKG',SheetName:'sheet2', HiddenColumn:1, SheetDesign:0, Merge:0}); 
            if ( sheetObjects[2].RowCount()> 0 ) sheetObjects[2].Down2Excel({FileName:'Inquiry by BKG',SheetName:'sheet3', HiddenColumn:1, SheetDesign:0, Merge:0, DownTreeHide:1});	//SJH.20141201.ADD : 트리펼쳐서 다운
	    	break;
    } 
	sheetObjects[0].Down2ExcelBuffer(false);              
}
