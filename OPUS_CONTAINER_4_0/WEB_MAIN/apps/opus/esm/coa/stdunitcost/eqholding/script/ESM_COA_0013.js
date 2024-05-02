/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0013.js
*@FileTitle  : EQ Holding Cost
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
/**
 * @extends 
 * @class ESM_COA_0013 : ESM_COA_0013 Business script for the UI
 */
//var calPop = new calendarPopupGrid();
var curTab=1;
var beforetab=0;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array(); // IB Combo variable
var comboCnt=0;
var loadingMode=false;
//var EXCEL_LOAD_FLG=false;   //check excell loading
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
    /***** Specify additional sheet variable in case of using more than two sheet per tab *****/
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
        case "btn_retrieve":
            if(sheetObject.IsDataModified()){
                doActionIBSheet(sheetObject,formObject,IBSAVE);
            }
            if(sheetObject1.IsDataModified()){
                doActionIBSheet(sheetObject1,formObject,IBSAVE);
            }
            if(RadioLayer.style.display == "none"){
                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            } else {
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
            }
            break;
        case "btn_downexcel":
        	// checked Container radio button
        	if(document.getElementById("f_calc_term_cd1").checked) {
        		if(sheetObject.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                }
        	}
        	// checked CHZ radio button
        	else {
        		if(sheetObject1.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                }
        	}
            break;
        case "btng_save":
            doActionIBSheet(sheetObject,formObject,IBSAVE);
            break;
        case "btng_save1":
            doActionIBSheet(sheetObject1,formObject,IBSAVE);
            break;
        case "btng_add":
            var new_row=sheetObject.DataInsert(-1);
            if (f_cntr_tpsz_cd.GetSelectCode()!="") sheetObject.SetCellValue(new_row,'eq_tpsz_cd',f_cntr_tpsz_cd.GetSelectCode(),0);
        break;
        case "btng_add1":
            var new_row=sheetObject1.DataInsert(-1);
//            if (f_cntr_tpsz_cd.GetSelectCode()!="") {
//            	sheetObject1.SetCellValue(new_row,'eq_tpsz_cd',f_cntr_tpsz_cd.GetSelectCode(),0);
//            }
            sheetObject1.SetCellValue(new_row,"eq_tpsz_cd", "BOX"); 
			sheetObject1.SetCellEditable(new_row, "eq_tpsz_cd",0);
            break;          
        case "btn_LoadExcel":
            if (formObject.f_calc_term_cd[0].checked){
                doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
            } else {
                doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
            }
            break;          
        } // end switch
    } catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg(OBJECT_ERROR));
        } else {
            ComShowMessage(e);
        }
    }
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        //Sheet configuration setting function(start)
        ComConfigSheet(sheetObjects[i]);
        document.getElementById("RadioLayer1").style.display="inline";
        initSheet(sheetObjects[i],i+1);
        document.getElementById("RadioLayer1").style.display="none";
        //Sheet configuration setting function(end)
        ComEndConfigSheet(sheetObjects[i]);
    }
    loadingMode=true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);    
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].options.id);
    }
    loadingMode=false;
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
//              var HeadTitle="Del.|STS|No.|TP/SZ|C/A Code|C/A Code|PDM|AMT|Box Count|Holding Days|H_CHSS|H_CA|CTRT/AVG" ;
              var HeadTitle="Del.|STS|No.|TP/SZ|C/A Code|C/A Code|PDM|AMT|Box Count|Holding Days|CTRT/AVG" ;

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
                     {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"stnd_cost_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"stnd_cost_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",   	Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"chss_hld_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:25 },
                     {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"ttl_hld_amt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
                     {Type:"AutoAvg",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"eq_bx_knt",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                     {Type:"AutoAvg",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"eq_hld_dys",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5  },
//                   {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"chss_usa_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//                   {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cost_ass_bse_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cost_ass_bse_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];		//SJH.20150312.MOD
               
              InitColumns(cols);

              SetEditable(1);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
			  resizeSheet();
//              InitComboNoMatchText(1,"",1);			//SJH.20150205.MOD : 엑셀업로드, 조회시 매핑안되게..
          }


            break;
        case 2: //sheet2 init
            with(sheetObj){
//              var HeadTitle="Del.|STS|No.|TP/SZ|C/A Code|C/A Code|Unit Cost|AMT|H|H|US Vol.|H_CTRT/AVG|CTRT/AVG" ;
        	  var HeadTitle="Del.|STS|No.|TP/SZ|C/A Code|C/A Code|Unit Cost|AMT|US Vol.|CTRT/AVG" ;

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
                     {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"stnd_cost_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"stnd_cost_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"chss_hld_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"ttl_hld_amt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:27 },
//                   {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"eq_bx_knt",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
//                   {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"eq_hld_dys",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoAvg",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"chss_usa_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//                   {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cost_ass_bse_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cost_ass_bse_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(1);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
			  resizeSheet();
              SetSumText(0,1,"");
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
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Setting multicombo items
 * SJH.20150106.MOD
 */
function initCombo(comboObj, comboId) {
     with (comboObj) { 
         SetDropHeight(300);
         SetMultiSelect(0);
         SetMaxSelect(1);
         InsertItem(0, 'All' ,'');
         ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
         SetSelectIndex(0);         
     }
}

function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    ComOpenWait(false);
    sheetObj.SetSumValue(0, "cost_ass_bse_cd",ComAddThreeDigitComma(eval(sheetObj.GetSumValue(0, "ttl_hld_amt")        + "/" + sheetObj.GetSumValue(0, "eq_bx_knt")).toFixed(0)));
    sheetObj.SetSumText(0,1,"");
    sheetObj.SetSumText(0,3,"TOTAL" );
}
function sheet2_OnSearchEnd(sheetObj,ErrMsg){
    ComOpenWait(false);
    sheetObj.SetSumText(0,1,"");
    sheetObj.SetSumText(0,3,"TOTAL" );
}

function sheet1_OnChange(sheetObj, Row,Col,Value) {	
    var sName=sheetObj.ColSaveName(Col);    
    var cValue=0;							//SJH.20150107.ADD
    if(sName == "eq_bx_knt") {
        //Setting same values per cntr_tpsz_cd
        var sValue=sheetObj.GetCellValue(Row,"eq_bx_knt");
        var row1=0;
        for(var k=0; k<=sheetObj.RowCount(); k++){
            row1=sheetObj.FindText("eq_tpsz_cd", sheetObj.GetCellValue(Row,"eq_tpsz_cd"), k);
            sheetObj.SetCellValue(row1, "eq_bx_knt",sValue,0);
            //SJH.20150107.ADD
            if(parseFloat(sheetObj.GetCellValue(row1,"eq_bx_knt")) > 0 && parseFloat(sheetObj.GetCellValue(row1,"eq_hld_dys")) > 0) {
            	cValue = parseFloat(sheetObj.GetCellValue(row1,"ttl_hld_amt"))/(parseFloat(sheetObj.GetCellValue(row1,"eq_bx_knt"))*parseFloat(sheetObj.GetCellValue(row1,"eq_hld_dys")));
                sheetObj.SetCellValue(row1, "chss_hld_uc_amt", cValue.toFixed(3));
            }	
            if(row1>k) k=row1;
        }
    } else if(sName == 'ttl_hld_amt'){        
    	//SJH.20150107.ADD
    	if(parseFloat(sheetObj.GetCellValue(Row,"eq_bx_knt")) > 0 && parseFloat(sheetObj.GetCellValue(Row,"eq_hld_dys")) > 0) {
    		cValue = parseFloat(sheetObj.GetCellValue(Row,"ttl_hld_amt"))/(parseFloat(sheetObj.GetCellValue(Row,"eq_bx_knt"))*parseFloat(sheetObj.GetCellValue(Row,"eq_hld_dys"))); 
            sheetObj.SetCellValue(Row, "chss_hld_uc_amt", cValue.toFixed(3));
    	}	
    } else if(sName == 'stnd_cost_cd'){
        // To get a description
        var sText=sheetObj.GetComboInfo(Row, Col, "Text");
        var arrText=sText.split("|");                   
        var sIdx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
        var sDesc=arrText[sIdx].split("\t");
        sheetObj.SetCellValue(Row, "stnd_cost_nm",sDesc[1],0);
    } else if(sName == 'eq_hld_dys'){
        var sValue=sheetObj.GetCellValue(Row,"eq_hld_dys");
        var row1=0;
        for(var k=0; k<=sheetObj.RowCount(); k++){
            row1=sheetObj.FindText("eq_tpsz_cd", sheetObj.GetCellValue(Row,"eq_tpsz_cd"), k);
            sheetObj.SetCellValue(row1, "eq_hld_dys",sValue,0);
            //SJH.20150107.ADD
            if(parseFloat(sheetObj.GetCellValue(row1,"eq_bx_knt")) > 0 && parseFloat(sheetObj.GetCellValue(row1,"eq_hld_dys")) > 0) {
            	cValue = parseFloat(sheetObj.GetCellValue(row1,"ttl_hld_amt"))/(parseFloat(sheetObj.GetCellValue(row1,"eq_bx_knt"))*parseFloat(sheetObj.GetCellValue(row1,"eq_hld_dys")));
                sheetObj.SetCellValue(row1, "chss_hld_uc_amt", cValue.toFixed(3));
            }	
            if(row1>k) k=row1;
        }
        //Recalculating the values of the corresponding row of the PDM and setting
    }
    sheetObj.SetSumText(0,1,"");
}

function sheet2_OnChange(sheetObj, Row,Col,Value) {	
	var sName=sheetObj.ColSaveName(Col);
    if ( sName == "chss_usa_qty") {
    	//SJH.20150107.MOD/ADD
    	if(parseFloat(Value) > 0)
    		sheetObj.SetCellValue(Row, "chss_hld_uc_amt",(parseFloat(sheetObj.GetCellValue(Row,"ttl_hld_amt"))/parseFloat(Value)).toFixed(2),0);
    } else if( sName== "ttl_hld_amt"){
    	//SJH.20150107.MOD/ADD
    	if(parseFloat(sheetObj.GetCellValue(Row,"chss_usa_qty")) > 0)
    		sheetObj.SetCellValue(Row, "chss_hld_uc_amt",(parseFloat(Value)/parseFloat(sheetObj.GetCellValue(Row,"chss_usa_qty"))).toFixed(2),0);
    } else if(sName == 'stnd_cost_cd'){
        // // To get a description
        var sText=sheetObj.GetComboInfo(Row, Col, "Text");
        var arrText=sText.split("|");                   
        var sIdx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
        var sDesc=arrText[sIdx].split("\t");
        sheetObj.SetCellValue(Row, "stnd_cost_nm",sDesc[1],0);
    }
    sheetObjects[1].SetSumText(0,1,"");
}

function sheet2_OnChangeSum(sheetObj, Row ) {
    sheetObj.SetSumText(0,1,"");
}

// window display
function LayerView( kind ){
    if ( kind == "1" ){
        document.getElementById("RadioLayer").style.display="inline";
        document.getElementById("RadioLayer1").style.display="none";
        
		f_cntr_tpsz_cd.SetEnable(true);
    } else if ( kind == "2") {
        document.getElementById("RadioLayer1").style.display="inline";
        document.getElementById("RadioLayer").style.display="none";
        
        f_cntr_tpsz_cd.SetSelectIndex(0);
        f_cntr_tpsz_cd.SetEnable(false);
    }
    ComSetFocus(document.form.f_cost_yrmon);
	resizeSheet();
}

// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:          //Inquiry
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=INIT;
            var sXml=sheetObj.GetSearchData("ESM_COA_0013GS.do", FormQueryString(formObj));
            var arrXml=sXml.split("|$$|");              
            if (arrXml.length > 0){ // container type size
                ComXml2ComboItem(arrXml[0], f_cntr_tpsz_cd, "code", "code");
                var tpsz=ComXml2ComboString(arrXml[0],"code","name")
                sheetObj.SetColProperty("eq_tpsz_cd", {ComboText:tpsz[0], ComboCode:tpsz[0]} );
                f_cntr_tpsz_cd.SetSelectIndex(0);   
            }
            if (arrXml.length > 1){ // container c/a code coa_cost_src_cd
                ComCoaSetIBCombo(sheetObj, arrXml[1], "stnd_cost_cd", true, 0, 0,"","", true);
            }
            if (arrXml.length > 2){ // chzz c/a code
                ComCoaSetIBCombo(sheetObjects[1], arrXml[2], "stnd_cost_cd", true, 0, 0,"","", true);
            }
            if (arrXml.length > 3) { // contract/average indicator
            	//SJH.20150205.ADD
                var ctrl_avg_cd1=CoaXml2ComboString(arrXml[3],"code", "name", "P"); 
                var ctrl_avg_cd2=CoaXml2ComboString(arrXml[3],"code", "name", "F");
                sheetObjects[0].SetColProperty("cost_ass_bse_cd", {ComboText:ctrl_avg_cd1[1], ComboCode:ctrl_avg_cd1[0]} );
                sheetObjects[1].SetColProperty("cost_ass_bse_cd", {ComboText:ctrl_avg_cd2[1], ComboCode:ctrl_avg_cd2[0]} );
            }
            if (arrXml.length > 4){ // chzz eq type size
                var chs_tpsz=ComXml2ComboString(arrXml[4],"code","name");
                sheetObjects[1].SetColProperty("eq_tpsz_cd", {ComboText:chs_tpsz[0], ComboCode:chs_tpsz[0]} );
            }               
            setYrMon();
            ComOpenWait(false);
            break;
        case IBSEARCH://Inquiry
            if(validateForm(sheetObj,formObj,sAction)){
                // Prohibit button click when a business transaction is processing 
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESM_COA_0013GS.do", coaFormQueryString(formObj) );
            }
            break;
        case IBSAVE:    //Save
            if(validateForm(sheetObj,formObj,sAction)){
                // Prohibit button click when a business transaction is processing 
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
   
                formObj.f_cmd.value=MULTI;
                sheetObj.DoSave("ESM_COA_0013GS.do", coaFormQueryString(formObj));
                
                ComOpenWait(false);
            }
            break;
        case IBCOPYROW: // Row copy
            sheetObj.DataCopy();
            break;
        case IBDOWNEXCEL:   // Excell download
        	if(document.getElementById("f_calc_term_cd1").checked) {
        		selectDownExcelMethod(sheetObj,0);
        	}
        	// checked CHZ radio button
        	else {
        		selectDownExcelMethod(sheetObj,1);
        	}
            break;
        case IBINSERT:          // Insert
            var new_row=sheetObj.DataInsert();
            sheetObj.SetCellEditable(new_row, "eq_tpsz_cd",1);
            break;      
        case IBLOADEXCEL: 
    		//20150716.MOD/ADD/DEL
    		sheetObj.SetWaitImageVisible(0);
        	sheetObj.RemoveAll();
        	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
            break;                  
    }
}

//20150716.ADD
function sheet1_OnLoadFileSelect(sheetObj){
    ComOpenWait(true);
}
function sheet2_OnLoadFileSelect(sheetObj){
    ComOpenWait(true);
}

//SJH.20150109.MOD
function sheet1_OnLoadExcel(sheetObj, result, code, msg) {	
	ComOpenWait(false);									//20150602.MOD
	if(isExceedMaxRow(msg)) return;						//20150716.MOD
	
	if (sheetObj.RowCount() > 0) {						//20150501.COMMON MOD		
		if(sheetLoadExcel(sheet1)) {
            for(var k=0; k<=sheetObj.RowCount(); k++){
            	sheet1_OnChange(sheetObj, k, sheetObj.SaveNameCol("eq_hld_dys"), sheetObj.GetCellValue(k, "eq_hld_dys"));
            	if(k>=sheetObj.HeaderRows()) sheetObj.SetCellValue(k,"cost_ass_bse_cd","P");			//Per Diem ::: 무조건
            }			
		}
	}
}
//SJH.20150109.MOD
function sheet2_OnLoadExcel(sheetObj, result, code, msg) {
	ComOpenWait(false);									//20150602.MOD
	if(isExceedMaxRow(msg)) return;						//20150716.MOD
	
	if (sheetObj.RowCount() > 0) {						//20150501.COMMON MOD		
		if(sheetLoadExcel(sheet2)) {
            for(var k=0; k<=sheetObj.RowCount(); k++){
            	sheet2_OnChange(sheetObj, k, sheetObj.SaveNameCol("chss_usa_qty"), sheetObj.GetCellValue(k, "chss_usa_qty"));
            	if(k>=sheetObj.HeaderRows()) sheetObj.SetCellValue(k,"cost_ass_bse_cd","F");			//Fixed Unit ::: 무조건
            }			
		}
	}	
}
function sheetLoadExcel(sheetObj) {
	var lastRow = sheetObj.GetCellText(sheetObj.LastRow()-1, 3);	 
	if(lastRow == "" || lastRow == "TOTAL") {
		sheetObj.RowDelete(sheetObj.LastRow()-1, false);
	}
    sheetObj.SetSumText(0,1, "");
    sheetObj.SetSumText(0,3, "TOTAL");
    
    checkValidationAllData(sheetObj);
    sheetObj.LoadExcelBuffer(false);
    
    return true;
}

function callBackExcelMethod(excelType) {	
    var sheetObj = sheetObjects[excelType[1]];
    switch (excelType[0]) {
	    case "AY":
	        sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	        break;
	    case "AN":
	    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	    	break;
	    case "DY":
	    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	break;
	    case "DN":
	    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	break;
	}            
}

//SJH.20150107.ADD : 저장후 메시지 추가
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);
    if(ErrMsg == ""){
        // [COM130102] : Success
    	ComShowMessage(ComGetMsg("COM130102","Data"));
    }else{
        ComShowMessage(ComGetMsg("COM132101"));
    }	
    doActionIBSheet(sheetObj,document.form,IBSEARCH);
} 

function sheet1_OnDownFinish(sheetObj, downloadType, result) {
    ComOpenWait(false);
}

//SJH.20150107.MOD : 저장후 메시지 수정
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
    if(ErrMsg == ""){
        // [COM130102] : Success
    	ComShowMessage(ComGetMsg("COM130102","Data"));
    }else{
        ComShowMessage(ComGetMsg("COM132101"));
    }	
    doActionIBSheet(sheetObj,document.form,IBSEARCH);
}

function sheet2_OnDownFinish(sheetObj, downloadType, result) {
    ComOpenWait(false);
}

/**
* Handling process for form object input validation
*/
function validateForm(sheetObj,formObj,sAction){
    if(!isValidYYYYMM(formObj.f_cost_yrmon , false, '-', false)){
        return false;
    }
    switch (sAction) {
        case IBSAVE:
//            var dr=sheetObj.ColValueDup("eq_tpsz_cd|stnd_cost_cd|cost_ass_bse_cd");
        	var dr=sheetObj.ColValueDup("eq_tpsz_cd|stnd_cost_cd");							//SJH.20150312.MOD
            if(dr>0){               
//                ComShowCodeMessage('COM12115', 'Type/Size, C/A Code, CTRT/AVG');	
            	ComShowCodeMessage('COM12115', 'Type/Size, C/A Code');						//SJH.20150312.MOD
                sheetObj.SelectCell(dr,"eq_tpsz_cd");
                return false;
            }
            //SJH.20150109.MOD
            for(var k=0; k<=sheetObj.RowCount(); k++){
            	if (formObj.f_calc_term_cd[0].checked){
	            	if(parseFloat(sheetObj.GetCellValue(k,"eq_bx_knt")) == 0) {
	            		ComShowCodeMessage('COA10002', "a number greater than 0 in 'Box Count'");
	                    sheetObj.SelectCell(k,"eq_bx_knt");
	                    return false;
	                    break;
	            	}
	            	if(parseFloat(sheetObj.GetCellValue(k,"eq_hld_dys")) == 0) {
	            		ComShowCodeMessage('COA10002', "a number greater than 0 in 'Holding Days'");
	                    sheetObj.SelectCell(k,"eq_hld_dys");
	                    return false;
	                    break;
	            	}
            	} else {
	            	if(parseFloat(sheetObj.GetCellValue(k,"chss_usa_qty")) == 0) {
	            		ComShowCodeMessage('COA10002', "a number greater than 0 in 'US Vol.'");
	            		sheetObj.SelectCell(k,"chss_usa_qty");
	                    return false;
	                    break;
	            	}            		
            	}
            }
            break;
    }

    return true;
}
/**
 * Function to check in case of saving the upload data<br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @return nothing
 */
function checkValidationAllData(sheetObj) {
    var formObj=document.form;
    var err_cd="Type Size\t\tCost Code\t\tBase Cd\n";
    //Check items value validation of the window
    for ( var i=sheetObj.HeaderRows(); i < sheetObj.LastRow(); i++) {
        if (sheetObj.GetCellValue(i, "eq_tpsz_cd") == "") {
            sheetObj.SetCellText(i, "eq_tpsz_cd" ,"");
        }
        if (sheetObj.GetCellValue(i, "stnd_cost_cd") == "") {
            sheetObj.SetCellText(i, "stnd_cost_cd" ,"");
            sheetObj.SetCellValue(i, "stnd_cost_nm","");
        }
        //SJH.20150312.MOD ::: 성수석님 요청
//        if (sheetObj.GetCellValue(i, "cost_ass_bse_cd") == "") {
//            sheetObj.SetCellText(i, "cost_ass_bse_cd" ,"");
//        }       
    }
    return false;
}   
/**
 * Setting this month
 * setYrMon()
 *
 * @param NONE
 * @return NONE
 */
function setYrMon(){
    var formObj=document.form;
    with(formObj){
        var nowYear=ComGetNowInfo("yy");
        var nowMon=ComGetNowInfo("mm");
        if ( nowMon.length == 1 ) nowMon="0" + nowMon; // conversion : 1month -> 01month 
        var nowYrMon=nowYear+"-"+nowMon;
        f_cost_yrmon.value=nowYrMon;
        if(!ComAddSeparator(f_cost_yrmon)) return false;
    }
}

/*
	function initUpload(){
		myUpload.Initialize({
			SaveUrl:'/opuscntr/MNR_INTGS.do',
			Files:[
				
			],
			AfterSaveStatus : function(event) {
				pSheetObj.SetCellValue(pRow, "file_seq",ComGetEtcData(sXml,"seqValue"),0);
			}
 		,AfterAddFile:function(){
			pSheetObj.SetCellValue(pRow, "org_file_nm",fileName,0);
			var fileName=(이벤트 가이드 예정);
			pSheetObj.SetCellValue(pRow, pCol,fileName,0);
			pSheetObj.SetCellValue(pRow, 'file_dw','1',0);
			var file_seq=pSheetObj.GetCellValue(pRow, 'file_seq');
			var file_dtl_seq=pSheetObj.GetCellValue(pRow, 'file_dtl_seq');
			if(file_dtl_seq=="") file_dtl_seq="1";
			var ibflag='U';
			if(file_seq=="") ibflag='I';
			var sParam="f_cmd="+COMMAND01;
			sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code
			sParam+= "&file_seq=" + file_seq;    // Existed file sequence
			sParam+= "&file_dtl_seq=" + file_dtl_seq;    // Existed file sequence
			sParam+= "&org_file_nm=" + fileName; // Fileupload file name
			sParam+= "&ibflag=" + ibflag;        // I : First time file upload, U : modify file
			myUpload.SaveStatus();
		}
		});
	}
	
	
	function sheet1_OnMouseMove(sheetObj, e) {
	var row     = sheet1.MouseRow(),
	col     = sheet1.MouseCol(),
	info    = null;
	if (row > 0 &&col == 5) {

		info = sheet1.GetCellElement(row, col, 1);
		
		pSheetObj = sheetObj;
		pRow = row;
		pCol = col;

		myUpload.SetFileUploadElement(info);
		
	} 
	}*/
	

function resizeSheet(){
	if(document.getElementById("f_calc_term_cd1").checked) {
		ComResizeSheet(sheetObjects[0]);
	} else {
		ComResizeSheet(sheetObjects[1]);
	}
}
/* Developer's task ends */
