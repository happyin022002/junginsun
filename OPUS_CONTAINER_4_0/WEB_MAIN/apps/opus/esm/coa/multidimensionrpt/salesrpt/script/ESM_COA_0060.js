/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0060.js
*@FileTitle  : Inquiry by Customized Condition
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/ 
/*------------------Code for JSDoc creation below ------------------*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;

document.onclick=processButtonClick;
/**
 * Event handler processing by button name
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
            case "btn_Downexcel":
                doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;
            case "bu_prev":
                sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, 40));
                div_toggle_prev.style.display="none";
                div_toggle_next.style.display="inline";
                break;
            case "bu_next":
                sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, 12));
                div_toggle_prev.style.display="inline";
                div_toggle_next.style.display="none";
                break;
                
            case "btn_form":
            	 ComOpenWindow2('ESM_COA_0059.do','', 'width=620,height=540,menubar=0,status=0,scrollbars=0,resizable=1');
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
function loadPage(title, col_nm) {
    var formObject=document.form;
    loadingMode=true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    // handling multi-combo object
    //---------------------------------------------
    for(k=0;k<comboObjects.length;k++){
        //initCombo(comboObjects[k], k+1);
        initCombo(comboObjects[k],comboObjects[k].options.id);
    }
    loadingMode=false;
    f_pro_vw.SetEnable(0);
    f_pro_lvl.SetEnable(0);
    f_pro_lvl.SetSelectCode("C", false);
    f_type_cd.SetSelectCode("A", true);		//SJH.20141112.ADD    
    
    for(i=0;i<sheetObjects.length;i++){
        //Sheet configuration setting function(start)
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i+1, title, col_nm);
        //Sheet configuration setting function(end)
        ComEndConfigSheet(sheetObjects[i]);
    }
    sheet_hidden(sheetObjects[0]);			//SJH.20141112.ADD
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo, title, col_nm) {
    var cnt=0;
    var colCnt=0;
    var varCnt=0;
    var colTotNum=0;
    var aryTitle=new Array();
    var t1="";
    var colWidth=0;
    var colWidth1=0;
    var formObj=document.form;
    var colTmp=0;
    if(title != ""){
        var tNM=title.split("|");
        var tCnt=tNM.length;
        for(var j=0; j<tCnt ; j++) {
            t1=t1+ tNM[j] + "|";
        }
    }
    aryTitle=col_nm.split("|");
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
                if(t1 != "") colCnt=aryTitle.length;
                colTotNum=colCnt + 19 + varCnt ;	//SJH.20141112.MOD
                colTotNum=colTotNum + colTmp
                colWidth1=110;
                var HeadTitle="R.MONTH|S.MONTH|WEEK|" + t1  ;
                //SJH.20141112.ADD
//                var sUnit=(formObj.f_view_tpsz[0].checked?"BOX":"TEU");
                HeadTitle=HeadTitle + "BOUND|TP/SZ|QUANTITY|TEU|REV TTL|CM COST TTL A|CM TTL A|CM COST TTL B|CM TTL B|RPB(TEU)|CM CPB(TEU) A|CMB(TEU) A|CM CPB(TEU) B|CMB(TEU) B" ;		//20160318.MOD
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sls_yrmon",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                for(var j=0; j<colCnt ; j++) {
                    if (aryTitle[j] == "CMDT_DESC" ||aryTitle[j] == "SC_DESC"||aryTitle[j] == "SHPR_CNT_CD" ){
                        cols.push({Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:1,   SaveName:aryTitle[j],    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 });
                    }  else if (aryTitle[j] == "BKG_CGO_WGT"){
                        cols.push({Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:aryTitle[j],    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 });
                    }  else if (aryTitle[j] == "BKG_NO" || aryTitle[j] == "BL_NO" || aryTitle[j] == "REP_CMDT_DESC" || aryTitle[j] == "SC_CUST_NM" || aryTitle[j] == "BKG_SHPR_NM" || aryTitle[j] == "SHPR_NM" || aryTitle[j] == "CNEE_NM" || aryTitle[j] == "NTFY_NM"){
                        cols.push({Type:"Text",      Hidden:0,  Width:colWidth1,Align:"Left",    ColMerge:1,   SaveName:aryTitle[j],    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 });
                    }else {
                        cols.push({Type:"Text",      Hidden:0,  Width:colWidth1,Align:"Center",  ColMerge:1,   SaveName:aryTitle[j],    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 });
                    }
                }
                //SJH.20141112.MOD
                cols.push({Type:"Text",      Hidden:0,  Width:60,   	Align:"Center",  ColMerge:1,   SaveName:"bound_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:0,  Width:60,   	Align:"Center",  ColMerge:1,   SaveName:"tpsz_code",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0,  Width:colWidth1,Align:"Right",   ColMerge:1,   SaveName:"quantity",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0,  Width:colWidth1,Align:"Right",   ColMerge:1,   SaveName:"teu",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0,  Width:colWidth1,Align:"Right",   ColMerge:1,   SaveName:"rev",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0,  Width:120,		Align:"Right",   ColMerge:1,   SaveName:"cmc_a",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0,  Width:80,		Align:"Right",   ColMerge:1,   SaveName:"cm_a",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0,  Width:120,		Align:"Right",   ColMerge:1,   SaveName:"cmc_b",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0,  Width:80,		Align:"Right",   ColMerge:1,   SaveName:"cm_b",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Float",     Hidden:0,  Width:colWidth1,Align:"Right",   ColMerge:1,   SaveName:"g_rpb",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
//                cols.push({Type:"AutoSum",   Hidden:0,  Width:colWidth1,Align:"Right",   ColMerge:1,   SaveName:"cm_cost_a",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Float",     Hidden:0,  Width:140,		Align:"Right",   ColMerge:1,   SaveName:"cmcost_a",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Float",     Hidden:0,  Width:colWidth1,Align:"Right",   ColMerge:1,   SaveName:"cmb_a",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
//                cols.push({Type:"AutoSum",   Hidden:0,  Width:colWidth1,Align:"Right",   ColMerge:1,   SaveName:"cm_cost_b",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Float",     Hidden:0,  Width:140,		Align:"Right",   ColMerge:1,   SaveName:"cmcost_b",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Float",     Hidden:0,  Width:colWidth1,Align:"Right",   ColMerge:1,   SaveName:"cmb_b",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                
                InitColumns(cols);
                
                SetEditable(0);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
                //SJH.20141112.ADD,MOD, 20160318.MOD
//                SetColHidden("cm_cost_a",1);
//                SetColHidden("cm_cost_b",1);
                SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
                viewBound();
                viewWeek();
            }
            break;
    }
}
/**
 * Setting multicombo items
 */
function initCombo(comboObj, comboId) {
    with (comboObj) {
    	ValidChar(2,1);			//SJH.20150106.ADD
    	
        if (comboId ==  "f_key_acct_group_cd"){
            SetColAlign(0, "left");
            SetColWidth(0, "345");
            SetSelectText("All",false);
         }else if (comboId ==  "f_key_acct_indvl_cd"){       
            SetColAlign(0, "left");
            SetColAlign(1, "left");
            SetColWidth(0, "80");
            SetColWidth(1, "300");
            SetSelectText("All",false);
         }else if (comboId ==  "f_mlt_trd_group_cd"){
            SetColAlign(0, "left");
            SetColWidth(0, "345");
            SetSelectText("All",false);
         }else if (comboId ==  "f_mlt_trd_indvl_cd"){       
            SetColAlign(0, "left");
            SetColAlign(1, "left");
            SetColWidth(0, "80");
            SetColWidth(1, "300");
            SetSelectText("All",false);      
//         }else if (comboId ==  "f_cmdt_cd"){     		//20160115.MOD  
//            SetColAlign(0, "left");
//            SetColAlign(1, "left");
//            SetColWidth(0, "80");
//            SetColWidth(1, "300");
//            SetSelectText("All",false);
         }else if (comboId ==  "f_rlane_cd"){   
        	 SetSelectText("All",false);
         }else if (comboId ==  "f_cntr_tpsz_cd"){
            SetMultiSelect(1);
            SetMultiSeparator(",");
            SetSelectText("All",false);
         //SJH.20141112.ADD
         }else if (comboId ==  "f_selgroup"){   
        	InsertItem(0, " ", " ");
         }else if (comboId ==  "f_svc_scp_cd"){       
             SetColAlign(0, "left");
             SetColAlign(1, "left");
             SetColWidth(0, "80");
             SetColWidth(1, "300");
             SetSelectText("All",false);
          }
         //SetDropHeight(200);
         if (comboId !=  "f_selgroup"){
            SetSelectIndex(0);
         }
     }
    f_selgroup.SetSelectIndex(0);
 }   
/**
 * Reseting sheet
 */
function initHeader(sheetObj, formObj){
  //--------------------------------------------------
  // Initializing and Setting the sheet due to change the header
  //sheetObj.RenderSheet(0);
  //sheetObj.RemoveAll();
  sheetObjects[0] = sheetObj.Reset();
  initSheet(sheetObjects[0], 1, formObj.f_header.value, formObj.f_headernm.value);
  
  //sheetObj.RenderSheet(1);
  //--------------------------------------------------
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
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
/**
 *
 */
function sheet1_OnDblClick(sheetObj, row, col, value){
    if(sheetObj.SaveNameCol("BKG_NO")>=0 ){
        var display="0,1";
        var formObj=document.form;
        var bkg_no=sheetObj.GetCellValue(row, "BKG_NO");
        var param="?f_pro_vw="  +getIbComboObjValue(formObj.f_pro_vw)
                   +"&f_pro_lvl=" +getIbComboObjValue(formObj.f_pro_lvl)
                   +"&f_s_bkg_no="+bkg_no
                   +"&pgmNo=ESM_COA_0061";
        ComOpenWindow('ESM_COA_0061POP.do'+param,'Inquiry by BKG', 'width=1150,height=760,menubar=0,status=1,scrollbars=1,resizable=1');
    }
}
/**
 * Recalculate some of the total item after inquiry
 */
function sheet1_OnSearchEnd(sheetObj, errMsg){
	//SJH.20141112.MOD
    var formObj=document.form;
    if(eval(sheetObj.GetSumValue(0, "teu")) > 0){
        sheetObj.SetSumValue(0, "g_rpb",eval(sheetObj.GetSumValue(0, "rev")       	+ "/" + sheetObj.GetSumValue(0, "teu")).toFixed(2));
        sheetObj.SetSumValue(0, "cmcost_a",eval(sheetObj.GetSumValue(0, "cmc_a")+ "/" + sheetObj.GetSumValue(0, "teu")).toFixed(2));			//20160318.MOD
        sheetObj.SetSumValue(0, "cmcost_b",eval(sheetObj.GetSumValue(0, "cmc_b")+ "/" + sheetObj.GetSumValue(0, "teu")).toFixed(2));			//20160318.MOD
        sheetObj.SetSumValue(0, "opcost",eval(sheetObj.GetSumValue(0, "op_cost")   	+ "/" + sheetObj.GetSumValue(0, "teu")).toFixed(2));
        sheetObj.SetSumValue(0, "cmb_a",eval(sheetObj.GetSumValue(0, "cm_a")        + "/" + sheetObj.GetSumValue(0, "teu")).toFixed(2));
        sheetObj.SetSumValue(0, "cmb_b",eval(sheetObj.GetSumValue(0, "cm_b")        + "/" + sheetObj.GetSumValue(0, "teu")).toFixed(2));
        sheetObj.SetSumValue(0, "opb",eval(sheetObj.GetSumValue(0, "op")        	+ "/" + sheetObj.GetSumValue(0, "teu")).toFixed(2));
    } else {
        sheetObj.SetSumValue(0, "g_rpb","0");
        sheetObj.SetSumValue(0, "cmcost_a","0");
        sheetObj.SetSumValue(0, "cmcost_b","0");
        sheetObj.SetSumValue(0, "opcost","0");
        sheetObj.SetSumValue(0, "cmb_a","0");
        sheetObj.SetSumValue(0, "cmb_b","0");
        sheetObj.SetSumValue(0, "opb","0");
    }
    sheet_hidden(sheetObj);		//SJH.20141112.ADD
    sheetObj.SetSumText(0,3, "TOTAL");
}

//SJH.20141111.ADD : HIDDEN
function sheet_hidden(sheetObj) {	
	for ( var Col = 0 ; Col <= sheetObj.LastCol() ; Col++) {
		if(sheetObj.GetCellValue(0, Col).indexOf("EPP A") > -1 || sheetObj.GetCellValue(0, Col).indexOf("EPP B") > -1) sheetObj.SetColHidden(Col, 0);
		if(ComGetObjValue(f_type_cd) == "A") {
			if(sheetObj.GetCellValue(0, Col).indexOf("EPP B") > -1) sheetObj.SetColHidden(Col, 1);
		}else if(ComGetObjValue(f_type_cd) == "B") {
			if(sheetObj.GetCellValue(0, Col).indexOf("EPP A") > -1) sheetObj.SetColHidden(Col, 1);
		}
	}
}

/**
 * Handling process about the sheet object
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:          //Inquiry
        	//SJH.20150106.ADD/MOD
        	formObj.f_yearM.value=ComGetNowInfo("yy");
            formObj.f_year.value=ComGetNowInfo("yy");
            formObj.f_fm_mon.value=ComGetNowInfo("mm").lpad(2, "0");
            formObj.f_to_mon.value=ComGetNowInfo("mm").lpad(2, "0");
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            var sXml=document.form.sXml.value; 
            var arrXml=sXml.split("|$$|");

            if (ComGetEtcData(arrXml[0], "ofc_cd") == undefined){
                ComShowMessage(OBJECT_ERROR);
                ComOpenWait(false);
                return;
            }
            document.form.sXml.value="";
            formObj.ofc_cd.value=ComGetEtcData(arrXml[0], "ofc_cd"); 
            formObj.ofc_lvl.value=ComGetEtcData(arrXml[0], "ofc_lvl"); 
            //SJH.20150106.ADD/MOD
            formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
            formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY"); 
            formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
            formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
            document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";
            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], f_pro_vw, "code", "name");
            if (arrXml.length > 1)
                ComXml2ComboItem(arrXml[1], f_ofc_vw, "code", "name");
            if (arrXml.length > 2)
                ComXml2ComboItem(arrXml[2], f_pro_lvl, "code", "name");
            if (arrXml.length > 3)
                ComXml2ComboItem(arrXml[3], f_rhq_cd, "code", "name");
            if (arrXml.length > 4)
                ComXml2ComboItem(arrXml[4], f_sls_ofc_cd, "code", "code");
            if (arrXml.length > 5)
                ComXml2ComboItem(arrXml[5], f_trd_cd, "code", "code");
            if (arrXml.length > 6)
                ComXml2ComboItem(arrXml[6], f_rlane_cd, "code", "code");
            if (arrXml.length > 7)
                ComXml2ComboItem(arrXml[7], f_skd_dir_cd, "code", "code");
            if (arrXml.length > 8)
                ComXml2ComboItem(arrXml[8], f_key_acct_group_cd, "code", "name");
            if (arrXml.length > 9)
                ComXml2ComboItem(arrXml[9], f_key_acct_indvl_cd, "code", "code|name");
            //20160115.MOD : 하위수정
//            if (arrXml.length > 10)
//                ComXml2ComboItem(arrXml[10], f_cmdt_cd, "code", "code|name");
            if (arrXml.length > 10)
                ComXml2ComboItem(arrXml[10], f_usa_bkg_mod_cd, "code", "code");
            if (arrXml.length > 11)
                ComXml2ComboItem(arrXml[11], f_cntr_tpsz_cd, "code", "code");
            if (arrXml.length > 12)
            	ComXml2ComboItem(arrXml[12], f_svc_scp_cd, "code", "code|name");
            if (arrXml.length > 13)
            	ComXml2ComboItem(arrXml[13], f_selgroup, "code", "name");
            if (arrXml.length > 14)
            	ComXml2ComboItem(arrXml[14], f_mlt_trd_group_cd, "code", "name");
            if (arrXml.length > 15)
            	ComXml2ComboItem(arrXml[15], f_mlt_trd_indvl_cd, "code", "code|name");
                
            //SJH.20141112.ADD : 나중 교체!!!!!!!!!!!!!!!!!!!!!!!
            //if (arrXml.length > 16)
            //	ComXml2ComboItem(arrXml[16], f_type_cd, "code", "code");
	        f_type_cd.InsertItem(0, "All", "All");
	        f_type_cd.InsertItem(1, "EPP A", "A");
	        f_type_cd.InsertItem(2, "EPP B", "B");            
            ComOpenWait(false);
            break;
        case IBSEARCH:          //Inquiry
            if(!validateForm(sheetObj, formObj, sAction)) return false;
            // Prohibit button click when a business transaction is processing 
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=SEARCHLIST01;
	            formObj.f_shipper.value=formObj.txtShipper.value;
	            // Using mass data[LoadSearchXml4Sax]
	            //---------------------------------------------------------------------------
	            var sParam=coaFormQueryString(formObj);
	            var sXml=sheetObj.GetSearchData("ESM_COA_0060GS.do", sParam);
	            sheetObj.LoadSearchData(sXml,{Sync:1} );
	            ComOpenWait(false);
            }, 100);
            break;
        case IBRESET:          //Inquiry header infomation
            formObj.f_cmd.value=SEARCH01;
            //sheetObj.DoSearch("ESM_COA_0060GS3.do", coaFormQueryString(formObj) );
        	var sXml=sheetObj.GetSearchData("ESM_COA_0060GS3.do", coaFormQueryString(formObj));
        	if (sXml != "") {
        		sheetObj.LoadSearchData(sXml,{Sync:1} );
        	}
        	        	
            formObj.f_header.value=ComGetEtcData(sXml,"header");
            formObj.f_headernm.value=ComGetEtcData(sXml,"headerNM");
            sheetObj.RemoveEtcData();
            initHeader(sheetObj, formObj);
            break;
        case IBDOWNEXCEL:       // Excell download
            var excelType=selectDownExcelMethod(sheetObj);
            break;
    }
}

function callBackExcelMethod(excelType){
    var sheetObj = sheetObjects[0];
    switch (excelType) {
	    case "AY":
	        sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	        break;
	    case "AN":
	    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	    	break;
	    case "DY":
	    	sheetObj.Down2Excel({HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	break;
	    case "DN":
	    	sheetObj.Down2Excel({HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	break;
    }
}

/**
 * Handling process for form object input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if (f_year.value == "") {
            // [COM12114] : Check for year value
            ComShowMessage(ComGetMsg("COM12114", "Year"));
            f_year.focus();
            return false;
        }
        if(f_chkprd[1].checked){
            if( f_fm_mon.value == "" && f_to_mon.value == ""){
                // [COM12114] : Check month
                ComShowMessage(ComGetMsg("COM12114", "Month"));
                f_fm_mon.focus();
                return false;
            }
            if ( f_to_mon.value - f_fm_mon.value > 2 ) {
                // [COA10038] = Duration is under 3 months 
                ComShowMessage(ComGetMsg("COA10038","3 Months"));
                formObj.f_to_mon.focus();
                return false;
            }
        }
        if(f_chkprd[0].checked ){
            if ( f_fm_wk.value == ""  && f_to_wk.value == ""){
                // [COM12114] : Check Week
                ComShowMessage(ComGetMsg("COM12114", "Week"));
                f_fm_wk.focus();
                return false;
            }
            if ( f_to_wk.value - f_fm_wk.value > 14 ) {
                // [COA10038] = Duration is under 15 weeks
                ComShowMessage(ComGetMsg("COA10038","15 Weeks"));
                f_to_wk.focus();
                return false;
            }
        }
        //if(!isValidYear(f_year,false,true)) return false;
        if(!ComChkObjValid(f_year, null, null, "yyyy")) return false;
        if(!chkValidSearch()) return false;
        if(f_fm_mon.value == "" && f_fm_wk.value == ""){
            // [COM12138] : Input either week or month item
            ComShowMessage(ComGetMsg("COM12138", "Month", "Week"));
            return false;
        }
        if(getIbComboObjValue(ofc_lvl) == '1'){
            if(parseInt(getIbComboObjValue(f_rhq_cd)) == 1){ //to select trade in case of head office
                  if(sheetObj.SaveNameCol("BKG_NO")>=0 ){
                     if(getIbComboObjValue(f_trd_cd) == ""){
                         ComShowMessage(ComGetMsg('COM12114','Trade'));
                         ComSetFocus(f_trd_cd);     
                         return false;
                     }
                 }
            }
            if(parseInt(getIbComboObjValue(f_rhq_cd)) == 2  ){ //to select office in case of Regional Group
                  if(sheetObj.SaveNameCol("BKG_NO")>=0 ){
                      if(getIbComboObjValue(f_sls_ofc_cd) == "" && getIbComboObjValue(f_trd_cd) == ""){
                         ComShowMessage(ComGetMsg('COM12114','Trade'));
                         ComSetFocus(f_trd_cd);     
                         return false;
                      }
                  }
            }
            if(parseInt(getIbComboObjValue(f_rhq_cd)) == 3  ){ //to select trade in case of sub Regional Group
                  if(sheetObj.SaveNameCol("BKG_NO")>=0 ){
                      if(getIbComboObjValue(f_sls_ofc_cd) == "" && getIbComboObjValue(f_trd_cd) == ""){
                         ComShowMessage(ComGetMsg('COM12114','Trade'));
                         ComSetFocus(f_trd_cd);     
                         return false;
                      }
                  }
            }
            if(parseInt(getIbComboObjValue(f_rhq_cd)) == 4  ){ //to select trade in case of area
                  if(sheetObj.SaveNameCol("BKG_NO")>=0){
                      if(getIbComboObjValue(f_sls_ofc_cd) == "" && getIbComboObjValue(f_trd_cd) == ""){
                         ComShowMessage(ComGetMsg('COM12114','Trade'));
                         ComSetFocus(f_trd_cd);     
                         return false;
                      }
                  }
            }
            if(parseInt(getIbComboObjValue(f_rhq_cd)) == 5  ){ //to select trade in case of Sales Office
                  if(sheetObj.SaveNameCol("BKG_NO")>=0){
                      if(getIbComboObjValue(f_sls_ofc_cd) == "" && getIbComboObjValue(f_trd_cd) == ""){
                         ComShowMessage(ComGetMsg('COM12114','Trade'));
                         ComSetFocus(f_trd_cd);     
                         return false;
                      }
                  }
            }
        }
        if(f_chkprd[0].checked){
            if(f_fm_wk.value == "") {
                ComShowMessage(ComGetMsg("COM12114","From Week",""));
                f_fm_wk.focus();
                return false;
            }
            if(f_fm_wk.value.length != 2) {
                ComShowMessage(ComGetMsg("COM12114","From Week",""));
                f_fm_wk.focus();
                return false;
            }
            if(f_to_wk.value == "") {
                ComShowMessage(ComGetMsg("COM12114","To Week",""));
                f_to_wk.focus();
                return false;
            }
            if(f_to_wk.value.length != 2) {
                ComShowMessage(ComGetMsg("COM12114","To Week",""));
                f_to_wk.focus();
                return false;
            }
        }
        else{
            if(f_fm_mon.value == "") {
                ComShowMessage(ComGetMsg("COM12114","From Month",""));
                f_fm_mon.focus();
                return false;
            }
            if(f_fm_mon.value.length != 2) {
                ComShowMessage(ComGetMsg("COM12114","From Month",""));
                f_fm_mon.focus();
                return false;
            }
            if(f_to_mon.value == "") {
                ComShowMessage(ComGetMsg("COM12114","To Month",""));
                f_to_mon.focus();
                return false;
            }
            if(f_to_mon.value.length != 2) {
                ComShowMessage(ComGetMsg("COM12114","To Month",""));
                f_to_mon.focus();
                return false;
            }
        }
    }
    return true;
}

/**
 * Change period when the month, week changed
 */
function setPeriod(obj){
     ComCoaSetPeriod(obj); 
}
/**
 * Change the sheet header infomation in case of changing the group combo
 */
function chgHeader(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    doActionIBSheet(sheetObj,formObj,IBRESET);
}
/**
 * Change the group combo after closing the popup
 */
function chgGroup(param){
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    formObj.f_cmd.value=SEARCHLIST12;
    var sXml=sheetObj.GetSearchData("ESM_COA_0060GS.do", coaFormQueryString(formObj));
    var arrXml=sXml.split("|$$|");
    if (arrXml.length > 0) {
    	ComXml2ComboItem(arrXml[0], f_selgroup, "code", "name");
    	ComSetObjValue(f_selgroup,param);
    }
 }
 /**
  * Change Header information of the sheet when the f_selgroup is changed
  */
 function f_selgroup_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	 
     if (loadingMode == true) return; 
     chgHeader();
 }
/**
        * Initialize sheet to change sheet's header
 */
function chgInitSheet(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    initHeader(sheetObj, formObj);
}
/**
 * Sheet is shown depending on the exist of the Bound column
 */
function viewBound(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    if(formObj.f_dir_sts.checked){
        sheetObj.SetColHidden("bound_cd",0);
    } else {
        sheetObj.SetColHidden("bound_cd",1);
    }
    //sheetObj.RemoveAll();
}
function viewWeek(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    if(formObj.f_wk_sts.checked){
        sheetObj.SetColHidden("cost_yrmon",0);
        sheetObj.SetColHidden("sls_yrmon",0);
        sheetObj.SetColHidden("cost_wk",0);
    } else {
        sheetObj.SetColHidden("cost_yrmon",1);
        sheetObj.SetColHidden("sls_yrmon",1);
        sheetObj.SetColHidden("cost_wk",1);
    }
    //sheetObj.RemoveAll();
}
/**
 * Change the header information depending on type per TEU,BOX
 */
function changeType(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    initHeader(sheetObj, formObj);
}
// handling combo object
//--------------------------------------------------------------------
/**
 * Change the key acctount combo in case of changing key acctount group
 */
function f_key_acct_group_cd_OnChange(obj, code){
    if (loadingMode == true) return; 
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if(obj.GetSelectText()!= ""){
        formObj.f_cmd.value=SEARCHLIST10;
        var sXml=sheetObj.GetSearchData("ESM_COA_0060GS.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
        ComXml2ComboItem(arrXml[0], f_key_acct_indvl_cd, "code", "code|name");
        f_key_acct_indvl_cd.SetSelectIndex(0);
    }
}
/**
 * Change the M/A indvl combo in case of changing M/A group
 */
function f_mlt_trd_group_cd_OnChange(obj, code){
    if (loadingMode == true) return; 
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if(obj.GetSelectText()!= ""){
        formObj.f_cmd.value=SEARCHLIST14;
        var sXml=sheetObj.GetSearchData("ESM_COA_0060GS.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
        ComXml2ComboItem(arrXml[0], f_mlt_trd_indvl_cd, "code", "code|name");
        f_mlt_trd_indvl_cd.SetSelectIndex(0);
    }
}
/**
 * Change the office combo in case of changing the office level
 */
function f_rhq_cd_OnChange(obj, oldindx , oldtext, oldcode , newindex, newtext , code){
     if (loadingMode == true) return;  
     chgOffice(obj);
}
/**
 * In case of changing the H/Q office
 */
function chgOffice(obj){
     var formObj=document.form;
     var sheetObj=sheetObjects[0];
     if(obj.GetSelectText()!= ""){
        formObj.f_cmd.value=SEARCHLIST13;
        var sXml=sheetObj.GetSearchData("ESM_COA_0060GS.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
        ComXml2ComboItem(arrXml[0], f_sls_ofc_cd, "code", "code");
        f_sls_ofc_cd.SetSelectIndex(0);
     }
}
 /*
 * Getting a list of the ofc_cd in case of changing on year and month values
 */
function changeCostYrmon(val){
    if(val != '') chgOffice(f_rhq_cd);
}
//changeCostYrmon
/**
 * Display R.Lane by ifram
 */
function f_trd_cd_OnChange(obj) {
    if (loadingMode == true) return; 
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
//    if(obj.GetSelectText()!= ""){					//20150602.MOD
        formObj.f_cmd.value=SEARCHLIST11;
        var sXml=sheetObj.GetSearchData("ESM_COA_0060GS.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
        ComXml2ComboItem(arrXml[0], f_rlane_cd, "code", "code");
        f_rlane_cd.SetSelectIndex(0);
//    }   
}
//SJH.20141112.ADD
function f_type_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
	 sheet_hidden(sheetObjects[0]);		//SJH.20141112.ADD	 
}
/**
 * Popup for S/C,RFA
 */
function comPopupLoc(flag, value) {
    display="1,0,1,1,1,1,1,1";
    var cont_tp="";
    var cont_no="";
    if(value != ""){
        cont_tp=value.substring(0,3);
        cont_no=value.substring(3);
    }
    var param="?cont_tp="+cont_tp+"&cont_no="+cont_no+"&flag="+flag;
    if(flag == 1){
        var targetFun="getCOM_ENS_021_1";
    }
    ComOpenPopup('/opuscntr/COM_ENS_021.do' + param, 780, 480, targetFun, display, true);    // radio PopUp
}
/**
 * Return S/C results
 */
function getCOM_ENS_021_1(rowArray) {
    var colArray=rowArray[0];
//        ComShowMessage(rowArray.length+" ::::: " + colArray[0]+":"+colArray[1]+":"+colArray[2]+":"+colArray[3]+":"+colArray[4]+":"+colArray[5]+":"+colArray[6]+":"+colArray[7]+":"+colArray[8]);
    document.all.f_sc_no.value=colArray[2];
}
/**
 * Open the window
 *
 */
function ShipperPopUp(){
    var formObj=document.form;
    var param="";
    var tmp=formObj.txtShipper.value;
    formObj.f_cmd.value="";
    if(tmp.length == 0){
        param="?f_cust_cnt_cd=&f_cust_seq="
    }
    if(tmp.length >0 && tmp.length< 3){
        param="?f_cust_cnt_cd=" + tmp +"&f_cust_seq=";
    } else if(tmp.length>2) {
        param="?f_cust_cnt_cd=" + tmp.substring(0,2);
        param=param + "&f_cust_seq=" + tmp.substring(2);
    }
    //ComOpenWindow2('ESM_COA_0144.do'+param,'', 'width=600,height=450,menubar=0,status=1,scrollbars=0,resizable=0');
    display="1,0,1,1,1,1,1,1";
    ComOpenPopup('ESM_COA_0144.do' + param, 600, 460, getShipperCode, display, false);
}

function getShipperCode(rowArray) {
	document.form.txtShipper.value = rowArray;
}
/**
 * Check all when the Type/Size  combo is clicked
 * @param comboObj
 * @param index
 * @param code
 * @return
 */
function f_cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    if (code == "" || code == "All") {
        var bChk=comboObj.GetItemCheck(index);
        for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
            comboObj.SetItemCheck(i,bChk);
        }
    }else{
        //comboObj.SetItemCheck(0,0);
    }
    comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
}

function getIbComboObjValue(obj){
    if (ComGetObjValue(obj) == "All" ){
        return "";
    }
    return ComGetObjValue(obj);
} 

/*
 * Each common pop-up function calls 
 */
function openPopup(flag, arg) {
		
	var sheetObj = sheet1;
	var formObj	= document.form;
		
	with(sheetObj) {
		switch(flag) {	  			
			case 'f_bkg_no':		// BKG No. Multi-Input pop-up calls
				// Specify the details of multi-input pop-up title
				var returntitle = '';
				if(flag == 'f_bkg_no')
					returntitle = 'BKG No.';
	  				
				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
				ComOpenPopup('EES_DMT_MULTI.do'+param, 420, 435, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
				break;		  				
		} // switch - end
	} // with(sheetObj) - end
		
}

/*
 * Multi-input pop-up page is closed, then the function is invoked Opener
 * - Set in a field allows multiple inputs.
 * SJH.20140904.ADD
 */
function getDmt_Multi(rArray, return_val) {
	var targObj = eval("document.form." + return_val);
 	var retStr = rArray.toString().toUpperCase();
 	
 	ComSetObjValue(targObj, retStr);
}

/**
 * Open the window
*  20160115.ADD
*/
function CommodityPopUp(){
    ComOpenPopup('/opuscntr/COM_ENS_0K1.do', 780, 480, "getCOM_ENS_0K1_1", "1,0,1,1,1,1,1,1", true);
}
/**
 * Setting Commodity
 */
function getCOM_ENS_0K1_1(rowArray) {
    var colArray=rowArray[0];
    document.all.f_cmdt_cd.value=colArray[3];
}
//--------------------------------------------------------------------E
