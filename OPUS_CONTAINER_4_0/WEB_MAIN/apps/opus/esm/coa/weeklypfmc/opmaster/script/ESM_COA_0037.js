/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0037.js
*@FileTitle  : Create Vessel table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var sheet_height=200; // sheet height
var comboCnt=0;
var loadingMode=false;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 *  Event handler processing by button name
 */
function processButtonClick(){
     var sheetObject=sheetObjects[0];
     var formObject=document.form;
     
    try {
    	var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        
        switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
            case "btn_Save":
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
            case "btn_Downexcel":
                if(sheetObject.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                }
                break;
            case "btn_SubTrade":
                //var rtn=window.showModalDialog ("ESM_COA_0038.do", window,"dialogWidth:400px;dialogHeight:370px;center:1; scroll:0; help:0; status:0;");
                ComOpenWindow2('ESM_COA_0038.do','', 'width=450,height=370,menubar=0,status=1,scrollbars=0,resizable=0');
                break;
            case "btn_Rowadd":
                doActionIBSheet(sheetObject,formObject,IBINSERT);
                break;
            case "btng_Crrinfo":
            	//SJH.20141226.ADD
                var pVslCd = formObject.f_vsl_cd.value;
                if(pVslCd == "" && sheetObject.GetSelectRow() > 0){
            	   pVslCd = sheetObject.GetCellValue(sheetObject.GetSelectRow(), "vsl_cd");
                }
                ComOpenWindow2('ESM_COA_0123.do?f_vsl_cd='+pVslCd,'', 'width=650,height=420,menubar=0,status=1,scrollbars=0,resizable=0');
                break;
            case "bu_zoom_in":
                if ( sheetObject.RowCount() < 1 ) return;
                sheetObject.SetSheetHeight( sheetObject.GetSheetHeight(sheet_height) * 2 );
                div_zoom_in.style.display="none";
                div_zoom_out.style.display="inline";
                if (parent && parent.syncHeight) {
                    parent.syncHeight();
                }
                break;
            case "bu_zoom_out":
                if ( sheetObject.RowCount() < 1 ) return;
                //sheetObject.SetSheetHeight( 390 );
                resizeSheet();										//SJH.20141222.MOD
                div_zoom_in.style.display="inline";
                div_zoom_out.style.display="none";
                if (parent && parent.syncHeight) {
                    parent.syncHeight();
                }
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}
function chgView(){
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if(formObj.f_chkdel.checked){
        sheetObj.SetColHidden(0,1);
        sheetObj.SetColHidden(1,0);
    }else{
        sheetObj.SetColHidden(0,0);
        sheetObj.SetColHidden(1,1);
    }// end if
}
/**
 * Popup function
 */
function Popup(str){
    ComOpenWindow2("ESM_COA_0146.do?" + str,'','width=1100, height=520, menubar=no, status=no,scrollbars=no, resizable=yes');
}
function retrieve(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    doActionIBSheet(sheetObj,formObj,IBSEARCH);
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
 */
function loadPage() {
    loadingMode=true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);       
    loadingMode=false;
//    btn_Retrieve.focus();
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo, vslSubTrade) {
    var cnt=0;
    var aryCD=[];
    if (vslSubTrade) {
        aryCD=vslSubTrade.split("|");
    }
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
                var HeadTitle0="Del.|CHK|STS|VSL|T/P|OPR\n(Operation)|OPR2\n(Owner)|Flag|VSL\nClass|Designed\nCapa.|Standard \nLoadable Capa.|CRR\nCode";
                for (var j=0; j<aryCD.length; j++) {
                  HeadTitle0 += "|Loadable Capa. By Sub Trade";
                }
                HeadTitle0 += "|VSL Price|EXP Ratio|VSL Apply Period|VSL Apply Period|VSL Retaining Period|VSL Retaining Period|Del Mark|History \nFlag|||";			//SJH.20150202.ADD
                var HeadTitle1="Del.|CHK|STS|VSL|T/P|OPR\n(Operation)|OPR2\n(Owner)|Flag|VSL\nClass|Designed\nCapa.|Standard \nLoadable Capa.|CRR\nCode";
                for (var j=0; j<aryCD.length; j++) {
                  HeadTitle1 += "|"+aryCD[j];
                }
                HeadTitle1 += "|VSL Price|EXP Ratio|From|To|From|To|Del Mark|History \nFlag|||";		//SJH.20141128.MOD
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle0, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
                            {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_delt" },
                            {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
                            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                            {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vop_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                            {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"vsl_oshp_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_rgst_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                            {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"vsl_clss_capa",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                            {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"vsl_dznd_capa",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                            {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"stnd_ldb_capa",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                            //SJH.20140926.MOD : CRR_CD UPDATE EDIT TRUE
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 } ];
                for (var j=0; j<aryCD.length; j++) {
                    cols.push({Type:"AutoSum",   Hidden:0, Width:110,   Align:"Right",   ColMerge:1,   SaveName:aryCD[j],           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
                }
                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"vsl_prc",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 });
                cols.push({Type:"Float",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_prc_rto",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
                //SJH.20141128.MOD
                cols.push({Type:"Date",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_aply_fm_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
                cols.push({Type:"Date",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_aply_to_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
                cols.push({Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_retn_fm_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_retn_to_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 });
                cols.push({Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_vsl_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 });
                cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lst_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                
                InitColumns(cols);
                
                SetEditable(1);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
                SetWaitImageVisible(0);
                SetHeaderRowHeight(10);
//                SetSheetHeight(430);
				resizeSheet();
//                SetRangeBackColor(1,11,1,25,"#555555");				//SJH.20141222.MOD : 색의밍벗음 제외시키기..
//                SetRangeBackColor(1,28,1,31,"#555555");
                SetColProperty(0 ,"delt_flg"   , {AcceptKeys:"[Other Char]"});
                SetColProperty(0 ,"vsl_cd"     , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetColProperty(0 ,"vsl_tp_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
                SetColProperty(0 ,"crr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetColProperty(0 ,"vsl_rgst_cnt_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                chgView();
            }
            break;
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
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    ComOpenWait(false);

    var formObj=document.form;
    if (0==ComGetObjValue(formObj.f_cmd)) {
        chgView();
        sheetObj.SetSumText(0,1,"");
        sheetObj.SetSumText(0,2,"TOTAL");
    }
}
/*
 * 1. Shows the decimal point as the percentage in case of changing the vsl_prc_rto
 * 2. Activate the trd_chk_flg in case of selecting the itself for inputting the trade loadable capacity, the trade 
 *                  or deactivate in case of not selecting
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
    if(sheetObj.ColSaveName(Col) == "vsl_prc_rto" ) {
        sheetObj.SetCellValue(Row, Col,Value * 100,0);
    } else if (sheetObj.ColSaveName(Col) == "trd_chk_flg") {
        for(i=12; i<22; i++){
            if(Value == 1){
                sheetObj.SetCellEditable(Row, i,1);
            }else{
                sheetObj.SetCellEditable(Row, i,0);
            } // end if
        }//end for
    } 
    else if (sheetObj.ColSaveName(Col) == "stnd_ldb_capa") {
        // Initialize the trade value as the stnd_ldb_capa's value in case of changing the stnd_ldb_capa,  If the company is not the OPR2 only.
        //-----------------------------------------------
        if(sheetObj.GetCellValue(Row, "vop_cd") != ConstantMgr.getCompanyCode()){
            var num=0;
            var header=document.form.f_header.value;
            var subTrade=header.split("|");
            if(header != "") num=subTrade.length;
            for(j=0;j<num; j++){
                sheetObj.SetCellValue(Row, subTrade[j],sheetObj.GetCellValue(Row, "stnd_ldb_capa"));
            }
        }
        //-----------------------------------------------
    }
    //-----------------------------------------------
    // To use again the deleted Vessel, assign the delt_flg to the 'N'
    //-----------------------------------------------
    if(sheetObj.ColSaveName(Col) == "chg_delt"){
        if (Value == "1") sheetObj.SetCellValue(Row, "delt_flg","N");
        else sheetObj.SetCellValue(Row, "delt_flg","Y");
    }
    //-----------------------------------------------
    // It can't be inputted newly in case of creating newly if there is a vessel currently.
    //-----------------------------------------------
    if(sheetObj.ColSaveName(Col) == "vsl_cd"){
        var current_vsl_code=sheetObj.GetCellValue(Row, "vsl_cd");
        for(var i=1; i<sheetObj.LastRow(); i++){
            if(i != Row){
                if(current_vsl_code == sheetObj.GetCellValue(i, "vsl_cd")){
                    ComShowMessage(ComGetMsg("COA10043", current_vsl_code));
                }
            }
        }
    }
    //-----------------------------------------------
    // Inquiry again the combolist in case of changing the OPR(Operation)
    //-----------------------------------------------
    if(sheetObj.ColSaveName(Col) == "vop_cd"){
        if(Value == "") {
            sheetObj.SetCellValue(Row, "vsl_oshp_cd","");
            sheetObj.CellComboItem(Row,"vsl_oshp_cd", {ComboText:"|", ComboCode:"|"} );
        } else {
            var param="";
            param=param+"&f_cmd="+SEARCHLIST03;
            param=param+"&f_vop_cd="+sheetObj.GetCellValue(Row,Col);
            var sXml=sheetObjects[0].GetSearchData("ESM_COA_0037GS2.do", param);
            var arrXml=sXml.split("|$$|");
            if (arrXml.length > 0)
                ComCoaSetIBCombo(sheetObj, arrXml[0], "vsl_oshp_cd", true,0,Row);
        }
    }
}
/**
* Open popup in case of double clicking sheet1
*/
function sheet1_OnDblClick(sheetObj , row, col){
    var str="f_vsl_cd=" + sheetObj.GetCellValue(row, "vsl_cd") + "&sysCommUiTitle=Vessel History";
    var existCapa="";
    if ( sheetObj.GetCellValue(row, "ibflag") == "U" && sheetObj.GetCellValue(row, "bsa_vsl_flg") == "N"){
        existCapa="Y";
        str=str + "&existCapa="+existCapa;
    }
    Popup(str);
}
/**
 * Handling process about the sheet object
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:          //Inquiry
            ComOpenWait(true);
            formObj.f_cmd.value=INIT;
            var sXml=sheetObj.GetSearchData("ESM_COA_0037GS2.do", coaFormQueryString(formObj));
            var arrXml=sXml.split("|$$|");
            if (arrXml.length > 0) {
                ComConfigSheet(sheetObj);
                initSheet(sheetObj, 1, ComXml2ComboString(arrXml[0], "code", "name")[0]);
                formObj.f_header.value=ComXml2ComboString(arrXml[0], "code", "name")[0];
                ComEndConfigSheet(sheetObj);
            }
            if (arrXml.length > 1)ComCoaSetIBCombo(sheetObj, arrXml[1], "vop_cd", true, 0);
            ComOpenWait(false);
            break;  
        case IBSEARCH:      //Inquiry
            if (sheetObj.IsDataModified() && ComShowCodeConfirm("COM130504")) {
                //validation check
                if(!doActionIBSheet(sheetObj,formObj,IBSAVE)) { 
                    return false;
                }
            }      
            // Prohibit button click when a business transaction is processing 
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=SEARCHLIST01;
	            var xml=sheetObj.GetSearchData("ESM_COA_0037GS.do", coaFormQueryString(formObj));
//	            sheetObj.SetVisible(0);
//	            sheetObj.RemoveAll();
	            loadPage();
	            sheetObj.SetVisible(1);
	            sheetObj.LoadSearchData(xml,{Sync:1} );
	            sheetObj.RemoveEtcData();
	            ComOpenWait(false);
            } , 100);
            break;
        case IBSAVE:        //Save
            if(!chkValidCreate(sheetObj,formObj)) return false;
            // Prohibit button click when a business transaction is processing 
            ComOpenWait(true);
            formObj.f_cmd.value=MULTI01;
            sheetObj.DoSave("ESM_COA_0037GS.do", coaFormQueryString(formObj), -1, false);
            ComOpenWait(false);
            break;
        case IBINSERT:      // Insert
            sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(sheetObj.LastRow()-1, "delt_flg","N",0);
            sheetObj.SetCellValue(sheetObj.LastRow()-1, "bsa_vsl_flg","N",0);
            sheetObj.SetCellValue(sheetObj.LastRow()-1, "vsl_seq","1",0);// Initial value
            break;
        case IBDOWNEXCEL:        // Excell download
            //sheetObj.SpeedDown2Excel(-1);
        	var excelType=selectDownExcelMethod(sheetObj);
       
            break;
    }
}

function callBackExcelMethod(excelType){
	 switch (excelType) {
	     case "AY":
	    	 sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	         break;
	     case "AN":
	    	 sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		    	break;
	     case "DY":
	    	 sheetObjects[0].Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	     	break;
	     case "DN":
	    	 sheetObjects[0].Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;
 }
}

//SJH.20150205.MOD
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);
    if(ErrMsg == ""){
        // [COA10006] : The processes was completed
        ComShowMessage(ComGetMsg("COA10006"));
    }else{
        ComShowMessage(ComGetMsg("COM132101"));
    }	
    doActionIBSheet(sheetObj,document.form,IBSEARCH);
}

/**
 * Handling process for form object input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if(formObj.f_vsl_cd.value != ""){
            if (!ComIsAlphabet(formObj.f_vsl_cd)) {
                ComShowMessage(ComGetMsg("COM12114", "Vessel"));
                formObj.f_vsl_cd.select();
                return false;
            }// end if
        }// end if
    }
    return true;
}
/**
 *
 */
function chkValidCreate(sheetObj,formObj){
    var strRowNum=sheetObj.FindStatusRow("I|U");
    var arrRow=strRowNum.split(";");
    var cnt=0;
    if(strRowNum != "") cnt=arrRow.length-1;
    with(formObj){
        // Check if the VSL retaining period exists
        //---------------------------------------------------------            
        for(i=0; i<cnt; i++){
            if(sheetObj.GetCellValue(arrRow[i], "vsl_retn_fm_dt") == "" || sheetObj.GetCellValue(arrRow[i], "vsl_retn_to_dt") == ""){
                // [COM12114] : Check the VSL retaining period
                ComShowMessage(ComGetMsg("COM12114", "VSL Retaining Period"));
                if(sheetObj.GetCellValue(arrRow[i], "vsl_retn_fm_dt") == "")sheetObj.SelectCell(arrRow[i], "vsl_retn_fm_dt");
                if(sheetObj.GetCellValue(arrRow[i], "vsl_retn_to_dt") == "")sheetObj.SelectCell(arrRow[i], "vsl_retn_to_dt");
                return false;
            }
        } 
    }
    //-----------------------------------------------
    // It can't be inputted newly in case of creating newly If there is a vessel currently.
    //-----------------------------------------------
    var dupYn="N";
    var dupVesselCd="";
    for(var i=1; i<sheetObj.LastRow(); i++){
        var current_vsl_code="";
        if(sheetObj.GetCellValue(i, "ibflag") == "I"){
            current_vsl_code=sheetObj.GetCellValue(i, "vsl_cd");
            for(var j=1; j<sheetObj.LastRow(); j++){
                if(j!=1 && sheetObj.GetCellValue(j, "ibflag") != "I" && current_vsl_code == sheetObj.GetCellValue(j, "vsl_cd")){
                    dupYn="Y";
                    dupVesselCd=current_vsl_code;
                    break;
                }
            }
        }
    }
    if(dupYn == "Y") {
        ComShowMessage(ComGetMsg("COA10043", dupVesselCd));
        return false;
    }
    return true;
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}
