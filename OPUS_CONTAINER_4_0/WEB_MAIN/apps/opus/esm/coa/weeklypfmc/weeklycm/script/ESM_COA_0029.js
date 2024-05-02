/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0029.js
*@FileTitle  : Target VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
var popup;
var ibStatus ;
var sheet_height=200; // sheet height
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Contents : Event handler processing by button name <br>
 * <b>Example : </b>
 * <pre>
 *    processButtonClick()
 * </pre>
 * @see #Link
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
            case "btn_Rowadd":
                doActionIBSheet(sheetObject,formObject,IBINSERT);
                break;
            case "btn_Save":
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
            case "btn_Auto":
                doActionIBSheet(sheetObject,formObject,IBBATCH);
                break;
            case "btn_Tsqty":
                doActionIBSheet(sheetObject,formObject,IBRESET);
                break;
            case "btn_Creation":
                    ComOpenPopup("ESM_COA_0113.do",  370, 150, "skdInquiryCallBack", "0,1", true);
                break;
            case "btn_Skdinquiry":
                var vsl_cd="";
                var classId="COM_ENS_0B1";
                var param="";
                if( sheetObject.RowCount()> 0){
                    if(sheetObject.GetSelectRow()> 1){
                        vsl_cd=ComTrim(sheetObject.GetCellValue(sheetObject.GetSelectRow(), "vsl_cd")) + ComTrim(sheetObject.GetCellValue(sheetObject.GetSelectRow(), "skd_voy_no")) + ComTrim(sheetObject.GetCellValue(sheetObject.GetSelectRow(), "dir_cd"));
                    }else{
                        //[COM12113] : Select a VVD
                        ComShowMessage(ComGetMsg("COM12113","VVD",""));
                        return false;
                    }
                    param='?vvd_cd='+vsl_cd+'&classId='+classId;
                    ComOpenPopup("/opuscntr/COM_ENS_0B1.do"+param, 620, 440, "", "0,0,1,1,1,1,1,1,1,1", false);
                } else {
                    ComShowCodeMessage("COA10040");
                }
                break;
            case "btn_Vvdcheck":
                if(!validateForm(sheetObject,formObject,IBSEARCH)) return false;
                popVvdCheck();
                break;
            case "btn_Monthvvd":
                if(!validateMonthVvd()) return false;
                var display="0,1";
                var f_cost_yr=document.form.f_year.value   ;
                var f_cost_fm_mon=document.form.f_fm_mon.value;
                var f_cost_to_mon=document.form.f_to_mon.value;
                var getMthdArg="f_cost_yr="+f_cost_yr+"&f_cost_fm_mon="+f_cost_fm_mon;
                //ComOpenPopup("ESM_COA_0112.do?"+getMthdArg, 800, 520, "Month VVD I/F", display, false, false);
                break;
            case "btn_Downexcel":
                if(sheetObject.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                }
                break;
            case "bu_zoom_in":
                sheetObject.SetSheetHeight( sheet_height * 2  );
                div_zoom_in.style.display="none";
                div_zoom_out.style.display="inline";
                break;
            case "bu_zoom_out":
                sheetObject.SetSheetHeight( sheet_height );
                div_zoom_in.style.display="inline";
                div_zoom_out.style.display="none";
                break;
            case "btn_Apply_bsa":
                doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg("COM12111"));
        } else {
            ComShowMessage(e);
        }
    }
}
/**
 * Contents :  Sheet default setting and Initialize <br>
 *          implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen.<br>
 * <br><b>Example : </b>
 * <pre>
 *     loadPage()
 * </pre>
 * @param 
 * @see #Link
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        //Sheet configuration setting function(start)
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        //Sheet configuration setting function(end)
        ComEndConfigSheet(sheetObjects[i]);
    }
    loadingMode=true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    // handling multi-combo object
    //---------------------------------------------
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }	
    loadingMode=false;
    
    btnEnable();		//SJH.20150106.ADD
}
/**
 * Initializing IBCOMBO<br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} comboObj Mandatory IBMultiCombo Object
 * @param {int} comboNo Mandatory IBMultiCombo's Sequence
 * @return N/A
 * @author SJH.20150106.MOD
 */ 
function initCombo(comboObj, comboNo) {
	with(comboObj) {
    	
        SetDropHeight(300);
        SetMultiSelect(0);
        SetMaxSelect(1);
        InsertItem(0, 'All' ,'');
        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고        
        SetSelectIndex(0);        
        
        switch(comboObj.options.id) {
        case "f_seltrade":
            SetMaxLength(3);
            break;
        case "f_selrlane":
            SetMaxLength(5);
            break;             
        case "f_selslane":
            SetMaxLength(3);
            break;   
        case "f_seldir":
            SetMaxLength(1);
            break; 
        case "f_selioc":
            SetMaxLength(1);
            break;
        }        
    }  	
}
/**
 * Contents :  Initialize sheet and define header info <br>
 *          adding case as numbers of counting sheets<br>
 * <br><b>Example : </b>
 * <pre>
 *     initSheet(sheetObj,sheetNo,tpszValue)
 * </pre>
 * @param {object}  sheetObj - Sheet Object
 * @param {Number}  sheetNo  - Sheet Number (A sequence No that is assigned in the sheet object tag ID)
 * @param {String}  Trade  - Trade
 * @see #Link
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var formObj=document.form;
    switch(sheetNo) {
        case 1:      //sheet2 init
            with(sheetObj){
              var HeadTitle0="Del.|SEL|BSA\nFLAG|STS|SEQ|Revenue\nYYYY-MM|Sales\nYYYY-MM|Week|Trade|Sub Trade|S. Lane|Lane|Type|Vessel|Voy.|BND|IOC|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Weekly|Weekly|Monthly\nStatus" ;
              var HeadTitle1="Del.|SEL|BSA\nFLAG|STS|SEQ|Revenue\nYYYY-MM|Sales\nYYYY-MM|Week|Trade|Sub Trade|S. Lane|Lane|Type|Vessel|Voy.|BND|IOC|Port|ETD|S.Lane\n 1st Port ETD|Status|Auto/Mnl|Monthly\nStatus" ;

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:0, ComboMaxHeight:450 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle0, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);
              
              //SJH.20141027.MOD : mon_tgt_flg Hidden 처리
              var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibDel" },
                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibSel" },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_zr_flg" },
                     {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",             KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sls_yrmon",              KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",                KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lst_lodg_port_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                     {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"lst_lodg_port_etd_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n1st_lodg_port_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"wky_tgt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wky_mnl_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mon_tgt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);//Editkind[optional,Defaultfalse]
              SetCountPosition(4);			//SJH.20150105.MOD
//              SetColProperty("lst_lodg_port_etd_dt", {AcceptKeys:"N", Format:"####-##-## 00:00:00"} );
              SetColProperty("lst_lodg_port_etd_dt", {Format:"YmdHms"} );
              SetColProperty("n1st_lodg_port_etd_dt", {Format:"YmdHms"} );
              SetHeaderRowHeight(10);
              sheet_height = 430;
//              SetSheetHeight(sheet_height) ;
			  resizeSheet();
              SetColProperty(0 ,"trd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              SetColProperty(0 ,"vsl_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              SetColProperty(0 ,"skd_voy_no" , {AcceptKeys:"N"});
              SetColProperty(0 ,"lst_lodg_port_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              SetColProperty(0 ,"wky_tgt_flg" , {AcceptKeys:"[YESNO]", InputCaseSensitive:1});
              SetColProperty(0 ,"mon_tgt_flg" , {AcceptKeys:"[YESNO]", InputCaseSensitive:1});
              chgViewColumn();
              InitComboNoMatchText(1,"",1);
          }


            break;
    }
}
/**
 * Contents : Registering IBSheet Object as list <br>
 *         adding process for list in case of needing batch processing with other items<br>
 *         defining list on the top of source<br>
 * <b>Example : </b>
 * <pre>
 *    setSheetObject(sheet_obj)
 *    </pre>
 * @param {object}  sheet_obj - Sheet Object
 * @see #Link
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
 * Setting a data in the combo object of the IBSheet <br>
 */
function setIBMultiCombo(sheetObj, sXml ,objName){
    if (sXml == undefined || sXml == ""){
        return;
    }
    var arrData=ComCoaXml2SheetMultiComboString(sXml, "code", "code");
    sheetObj.SetColProperty(objName, {ComboText:arrData[1], ComboCode:arrData[0]} );
}
/**
 * Contents : Handling process about the sheet object <br>
 * <br><b>Example : </b>
 * <pre>
 *     doActionIBSheet(sheetObj,formObj,sAction)
 * </pre>
 * @param {object}  sheetObj - Sheet Object
 * @param {form}    formObj  - From Object
 * @param {String}  sAction  - Kinds of processes 
 * @see #Link
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    sheetObj.SetWaitImageVisible(0);// Prohibit button click when a business transaction is processing
    ibStatus=sAction;
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
            
          	//SJH.20150106.ADD/MOD
            formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
            formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY"); 
            formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
            formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW"); 
            document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";  
            
            if (arrXml.length > 0) 
                ComXml2ComboItem(arrXml[0], f_seltrade, "code", "code");
            if (arrXml.length > 1)
                ComXml2ComboItem(arrXml[1], f_selrlane, "code", "code");
            if (arrXml.length > 2)
                ComXml2ComboItem(arrXml[2], f_selslane, "code", "code");
            if (arrXml.length > 3) 
                ComXml2ComboItem(arrXml[3], f_seldir, "code", "code");
            if (arrXml.length > 4) 
                ComXml2ComboItem(arrXml[4], f_selioc, "code", "code");
            if (arrXml.length > 5)
                ComCoaSetIBCombo(sheetObj, arrXml[5], "trd_cd", true, 0);
            if (arrXml.length > 6)
                ComCoaSetIBCombo(sheetObj, arrXml[6], "sub_trd_cd", true,0);
            if (arrXml.length > 7)
                ComCoaSetIBCombo(sheetObj, arrXml[7], "slan_cd",true,0);
            if (arrXml.length > 8)
                ComCoaSetIBCombo(sheetObj, arrXml[8], "rlane_cd",true,0);
            if (arrXml.length > 9)
                ComCoaSetIBCombo(sheetObj, arrXml[9], "vsl_lane_tp_cd",true,0);
            if (arrXml.length > 10)
                ComCoaSetIBCombo(sheetObj, arrXml[10], "dir_cd",true,0);
            if (arrXml.length > 11)
                ComCoaSetIBCombo(sheetObj, arrXml[11], "ioc_cd",true,0);
            if (arrXml.length > 12)
                ComCoaSetIBCombo(sheetObj, arrXml[12], "wky_mnl_flg",true,0);
            document.form.sXml.value="";
            f_seltrade.SetSelectIndex(0);
            f_seldir.SetSelectIndex(0);
            f_selioc.SetSelectIndex(0);
            ComOpenWait(false);
            break;
        case IBSEARCH:      //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            if (sheetObj.IsDataModified()&& ComShowCodeConfirm("COM130504")) {
                //validation check
                if(!doActionIBSheet(sheetObj,formObj,IBSAVE)) { 
                    return false;
                }
            }
            ComOpenWait(true);
            setTimeout( function () {
	            if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value=fillZero(formObj.f_fm_mon.value, 2, '0','left');
	            if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value=fillZero(formObj.f_to_mon.value, 2, '0','left');
	            if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value=fillZero(formObj.f_fm_wk.value, 2, '0','left');
	            if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value=fillZero(formObj.f_to_wk.value, 2, '0','left');
	            /*--------------------------------------------*/
	            formObj.f_cmd.value=SEARCHLIST11;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0029GS.do", coaFormQueryString(formObj));
	            var arrXml=sXml.split("|$$|");
	            if (arrXml.length > 0)
	                ComCoaSetIBCombo(sheetObj, arrXml[0], "sub_trd_cd", true,0);
	            if (arrXml.length > 1)
	                ComCoaSetIBCombo(sheetObj, arrXml[1], "slan_cd",true,0);
	            if (arrXml.length > 2)
	                ComCoaSetIBCombo(sheetObj, arrXml[2], "rlane_cd",true,0);
	            /*--------------------------------------------*/
	            formObj.f_cmd.value=SEARCHLIST01;
	            var sParam=coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date');
	            sheetObj.DoSearch("ESM_COA_0029GS.do", sParam );
	            /*--------------------------------------------*/
	            ComOpenWait(false);
            }, 100);
            break;
        case IBSAVE:        //Save
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            ComOpenWait(true);
            formObj.f_cmd.value=MULTI01;
            sheetObj.DoSave("ESM_COA_0029GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date'), -1, false);
            ComOpenWait(false);
            break;
        case IBBATCH:      //Manual batch SJH.20150106.MOD
            if(!validateBatch()) return false;
            
//            if (sheetObj.RowCount()> 0) {							//20150716.DEL
                if (ComShowConfirm(ComGetMsg('COA10025')) == true) { 
                    ComOpenWait(true);                       
                    
                    //SJH.20141223.MOD : 수정 및 정리
                    setTimeout( function () {
                    	setFmToDate(); // Setting from/to date
                    	formObj.f_cmd.value=MULTI03;
                        var sParam = sheetObj.GetSaveString(1);
                        if (sheetObj.IsDataModified() && sParam == "") return;
                        sParam = sParam + "&" + FormQueryString(formObj);
                        var sXml = sheetObj.GetSaveData("ESM_COA_0029GS.do", sParam );
        	            sheetObj.LoadSaveData(sXml, {Sync:1});
                        
                        var err_cd = ComGetEtcData(sXml, "err_cd");
                        var err_msg = ComGetEtcData(sXml, "err_msg");	                        
        	            if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined ){
        	                return false;
        	            }	                
                        if (err_cd == "00000") {
                            ComShowMessage(ComGetMsg('COA10018','BATCH')); 
                        } else if (err_cd == "00028") {
                            ComShowMessage("ERROR(COA00028): " + err_msg);                            
                        } else {
                            ComShowMessage("["+err_cd+"]:"+err_msg);
                        }
                        sheetObj.SetEtcData("err_cd","");
                        sheetObj.SetEtcData("err_msg","");
                        
                        ComOpenWait(false);
                    }, 100);
                }
//            } else {
//                ComShowMessage(ComGetMsg('COA10017'));
//            }
            break;
        case IBCREATE:			//SJH.20150106.MOD
            if(!validateCreation()) return false;
            
                if (ComShowConfirm(ComGetMsg('COA10020')) == true) { 
                    ComOpenWait(true);                       
                    
                    //SJH.20141223.MOD : 수정 및 정리
                    setTimeout( function () {
                    	formObj.f_cmd.value=MULTI02;
                        var sParam = sheetObj.GetSaveString(1);
                        if (sheetObj.IsDataModified() && sParam == "") return;
                        sParam = sParam + "&" + FormQueryString(formObj);
                        var sXml = sheetObj.GetSaveData("ESM_COA_0029GS.do", sParam );
        	            sheetObj.LoadSaveData(sXml, {Sync:1});
                        
                        var err_cd = ComGetEtcData(sXml, "err_cd");
                        var err_msg = ComGetEtcData(sXml, "err_msg");	                        
        	            if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined ){
        	                return false;
        	            }	                
                        if (err_cd == "00000") {
        	                if(sheetObj.GetEtcData("vsl_cd") == ""){
        	                    // [COA10006] : The processes was completed
        	                    ComShowMessage(ComGetMsg("COA10006"));
        	                }else{
        	                    // [COA10022] : Check the vssel value. There is a data in the saved vessel
        	                    ComShowMessage(ComGetMsg("COA10022", sheetObj.GetEtcData("vsl_cd")));
        	                }
        	                // In case of weekly creation
        	                if(formObj.f_type_cd.value == "Weekly"){
        	                    popVvdCheck();
        	                }
                        } else {
                            ComShowMessage("["+err_cd+"]:"+err_msg);
                        }
                        sheetObj.SetEtcData("err_cd","");
                        sheetObj.SetEtcData("err_msg","");
                        
                        ComOpenWait(false);
                    }, 100);
                }
            doActionIBSheet(sheetObj,formObj,IBSEARCH);
            break;
        case IBRESET: //TS/QTY Create	SJH.20150106.MOD
            if(!validateCreation()) return false;
            
            if (sheetObj.RowCount()> 0) {
                if (ComShowConfirm(ComGetMsg('COA10020')) == true) { 
                    ComOpenWait(true);                       
                    
                    //SJH.20141223.MOD : 수정 및 정리
                    setTimeout( function () {
                    	formObj.f_cmd.value=MULTI04;
                        var sParam = sheetObj.GetSaveString(1);
                        if (sheetObj.IsDataModified() && sParam == "") return;
                        sParam = sParam + "&" + FormQueryString(formObj);
                        var sXml = sheetObj.GetSaveData("ESM_COA_0029GS.do", sParam );
        	            sheetObj.LoadSaveData(sXml, {Sync:1});
                        
                        var err_cd = ComGetEtcData(sXml, "err_cd");
                        var err_msg = ComGetEtcData(sXml, "err_msg");	                        
        	            if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined ){
        	                return false;
        	            }	                
                        if (err_cd == "00000") {
                            ComShowMessage(ComGetMsg('COA10018','TS QTY')); 
                        } else {
                        	ComShowMessage("ERROR(COA00028): " + err_msg);
                        }
                        sheetObj.SetEtcData("err_cd","");
                        sheetObj.SetEtcData("err_msg","");
                        
                        ComOpenWait(false);
                    }, 100);
                }
            } else {
                ComShowMessage(ComGetMsg('COA10017'));
            }
            break;
        case IBINSERT:                  // Insert
            if(sheetObj.GetSelectRow()>0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cost_yrmon") != ""){
                var new_row = sheetObj.DataInsert(-1);
                sheetObj.SetCellValue(new_row, "cost_yrmon",sheetObj.GetCellValue(new_row-1, "cost_yrmon"));
                sheetObj.SetCellValue(new_row, "cost_wk",sheetObj.GetCellValue(new_row-1, "cost_wk"));
                sheetObj.SetCellValue(new_row, "wky_tgt_flg","NO");
                sheetObj.SetCellValue(new_row, "mon_tgt_flg","NO");
                sheetObj.SetCellValue(new_row, "delt_flg","NO");
                
            }
            break;
        case IBSEARCH_ASYNC01:          // Setting the BSA values of the VVD to '0' which is selected by the BSA Flag SJH.20150106.MOD
            if(sheetObj.RowCount()<1){
                ComShowMessage( "There is no data to search" );
                return false;
            }
            if(!validateCreation()) return false;
            
            if (sheetObj.RowCount()> 0) {
                if (ComShowConfirm(ComGetMsg('COA10036')) == true) { 
                    ComOpenWait(true);                       
                    
                    //SJH.20141223.MOD : 수정 및 정리
                    setTimeout( function () {
                    	formObj.f_cmd.value=MULTI05;
                        var sParam = sheetObj.GetSaveString(1);
                        if (sheetObj.IsDataModified() && sParam == "") return;
                        sParam = sParam + "&" + FormQueryString(formObj);
                        var sXml = sheetObj.GetSaveData("ESM_COA_0029GS.do", sParam );
        	            sheetObj.LoadSaveData(sXml, {Sync:1});
                        
                        var err_cd = ComGetEtcData(sXml, "err_cd");
                        var err_msg = ComGetEtcData(sXml, "err_msg");	                        
        	            if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined ){
        	                return false;
        	            }	                
                        if (err_cd == "00000") {
                            ComShowMessage(ComGetMsg('COA10018','Apply BSA 0')); 
                        } else {
                            ComShowMessage("["+err_cd+"]:"+err_msg);
                        }
                        sheetObj.SetEtcData("err_cd","");
                        sheetObj.SetEtcData("err_msg","");
                        
                        ComOpenWait(false);
                    }, 100);
                }
            } else {
                ComShowMessage(ComGetMsg('COA10017'));
            }
            break;
        case IBDOWNEXCEL:        // Excell download
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
/**
 * Contents : Event after inquiry <br>
 * <br><b>Example : </b>
 * <pre>
 *     sheet1_OnSearchEnd(sheetObj, errMsg)
 * </pre>
 * @param {object}  sheetObj - sheet
 * @param {String}  errMsg  - Message after inquiry
 * @see #Link
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    ComOpenWait(false);
}
/**
 * Contents : The event is called after it's saved <br>
 * <br><b>Example : </b>
 * <pre>
 *     sheet1_OnSaveEnd(sheetObj, errMsg)
 * </pre>
 * @param {object}  sheetObj - sheet
 * @param {String}  errMsg  - Message after saving
 * @see #Link
 */
//SJH.20150106.ADD : 저장후 메시지 추가
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if(document.form.f_cmd.value==MULTI01) {
	    if(ErrMsg == ""){
	        // [COM130102] : Success
	    	ComShowMessage(ComGetMsg("COM130102","Data"));
	    }else{
	        ComShowMessage(ComGetMsg("COM132101"));
	    }	
	    doActionIBSheet(sheetObj,document.form,IBSEARCH);		
	}
} 

function sheet1_OnDownFinish(sheetObj, downloadType, result) {
    ComOpenWait(false);
}

/**
 *  Contents : The event is called when the cell value is changed <br>
 * <br><b>Example : </b>
 * <pre>
 *     sheet1_OnChange(sheetObj, Row, Col, Val)
 * </pre>
 * @param {object}  sheetObj - sheet
 * @param {Long}    Row  - Row Index
 * @param {Long}    Col  - Column Index
 * @param {String}  Val  - Changed value
 * @see #Link
 */
function sheet1_OnChange(sheetObj, Row, Col, value){
    var formObj=document.form;
    var param;
    if(sheetObj.ColSaveName(Col) == "trd_cd"){
        param=param+"&f_cmd="+SEARCHLIST11;
        param=param+"&f_seltrade="+sheetObj.GetCellValue(Row,Col);
        var sXml=sheetObj.GetSearchData("ESM_COA_0029GS.do", param);
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
            ComCoaSetIBCombo(sheetObj, arrXml[0], "sub_trd_cd", true,0,Row);
        if (arrXml.length > 1)
            ComCoaSetIBCombo(sheetObj, arrXml[1], "slan_cd",true,0,Row);
        if (arrXml.length > 2)
            ComCoaSetIBCombo(sheetObj, arrXml[2], "rlane_cd",true,0,Row);
    }
}
/**
 *  Contents : Handling process for form object input validation <br>
 * <br><b>Example : </b>
 * <pre>
 *     validateForm(sheetObj,formObj,sAction)
 * </pre>
 * @param {object}  sheetObj - Sheet Object
 * @param {form}    formObj  - From Object
 * @param {String}  sAction  - Kinds of processes 
 * @see #Link
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if(!chkValidSearch()) return false;        
    }
    return true;
}
/**
 *  Contents : Handling process for form object input validation <br>
 *           Function that is called by the button of the "MONTH VVD I/F" <br>
 * <b>Example : </b>
 * <pre>
 *     validateMonthVvd()
 * </pre>
 * @see #Link
 * SJH.20150106.MOD
 */
function validateMonthVvd(){
    var formObj=document.form;
    with(formObj){   	
        if(!f_chkprd[1].checked) {
            // [COM12114] : From Check month
            ComShowMessage(ComGetMsg("COM12114", "W/M"));
            return false;
        }
        if(!chkValidSearch()) return false;
    }
    return true;
}
/**
 *  Contents : Handling process for form object input validation <br>
    * Function that is called by the creation button at the bottom <br>
 * <b>Example : </b>
 * <pre>
 *     validateCreation()
 * </pre>
 * @see #Link
 * SJH.20150106.MOD
 */
function validateCreation(){
    var formObj=document.form;
    with(formObj){    	
        if(!f_chkprd[0].checked){
            // [COM12114] : Check the 'W/M'
            ComShowMessage(ComGetMsg("COM12114", "W/M"));
            return false;
        }
        if(!chkValidSearch()) return false;
        if(f_type_cd.value == "Creation"){
            if(f_fm_wk.value != "" && f_to_wk.value != ""){
                if((f_to_wk.value - f_fm_wk.value)>16){
                    // [COA10003] : The BSA can be handled within 16 weeks
                    ComShowMessage(ComGetMsg("COA10003", "BSA", "16 weeks"));
                    f_to_wk.focus();
                    return false;
                }
            }
        }
    }
    return true;
}
/**
 *  Contents : Handling process for form object input validation <br>
    * Function that is called by the auto creation button at the bottom <br>
 * <b>Example : </b>
 * <pre>
 *     validateBatch()
 * </pre>
 * @see #Link
 * SJH.20150106.MOD
 */
function validateBatch(){
    var formObj=document.form;
    with(formObj){
        
        if(!f_chkprd[0].checked){
            // [COM12114] : Check the 'W/M'
            ComShowMessage(ComGetMsg("COM12114", "W/M"));
            return false;
        }
        if(!chkValidSearch()) return false;        
        // Maximum input weeks :  2nd argument
        if (ComTrim(f_fm_wk.value) != "" && ComTrim(f_to_wk.value) != "") {
            if((ComParseInt(f_to_wk.value) - ComParseInt(f_fm_wk.value)) >= 22){
                ComShowMessage(ComGetMsg('COA10007','22'));
                f_fm_wk.focus();
                return false;
            }
        }
    }
    return true;
}
/**
 *  Contents : Calculate the From and the To Date for batch job <br>
 * <br><b>Example : </b>
 * <pre>
 *     setFmToDate()
 * </pre>
 * @see #Link
 */
function setFmToDate() {
    var formObj=document.form;
    var period=div_period.innerHTML;
    with(formObj) {
        period=div_period.innerHTML.replace(/-|\(|\)/g,'').split('~');
        fm_date.value=ComTrim(period[0]);
        to_date.value=ComTrim(period[1]);
    }   
}
/**
 * Reflash the rLane list when a trade code is changed
 */
function f_seltrade_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    if (loadingMode == true) return; 
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    formObj.f_cmd.value=SEARCHLIST10;
    var sXml=sheetObj.GetSearchData("ESM_COA_0029GS.do", coaFormQueryString(formObj));
    var arrXml=sXml.split("|$$|");
    if (arrXml.length > 0)
        ComXml2ComboItem(arrXml[0], f_selrlane, "code", "name");	//SJH.20141223.MOD : code -> name
    if (arrXml.length > 1)
        ComXml2ComboItem(arrXml[1], f_selslane, "code", "name");
    f_selslane.SetSelectIndex(0);
    f_selrlane.SetSelectIndex(0);
}   

/**
 * Open the window<br>
 * <b>Example : </b>
 * <pre>
 *    popVvdCheck()
 * </pre>
 * @see #Link
 */
function popVvdCheck(){
    var formObj=document.form;
    var param="?" + coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date');
    //SJH.20141223.ADD
    ComOpenWindowCenter('ESM_COA_0142.do'+param, '', 1030, 529, true, 0);
}
/**
 * Contents : Change the column in case of selecting deleted data.<br>
 *          Change the delete column to the check column
 * <b>Example : </b>
 * <pre>
 *    chgViewColumn()
 * </pre>
 * @see #Link
 */
function chgViewColumn(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    if(formObj.f_chkdel.checked){
        sheetObj.SetColHidden("ibDel",1);
        sheetObj.SetColHidden("ibSel",0);
    } else {
        sheetObj.SetColHidden("ibDel",0);
        sheetObj.SetColHidden("ibSel",1);
    }
    sheetObj.RemoveAll();
}
/**
 *  Contents :  Change period when the month, week changed <br>
 * <br><b>Example : </b>
 * <pre>
 *     setPeriod(obj)
 * </pre>
 * @param (object) obj - Document Object
 * @see #Link
 */
function setPeriod(obj){	
	btnEnable();
    ComCoaSetPeriod(obj);
}

function skdInquiryCallBack(rtnValue){
	document.form.f_type_cd.value = rtnValue;
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}

//SJH.20150106.ADD
function btnEnable(){	
    if(document.form.f_chkprd[0].checked){
        ComBtnDisable("btn_Tsqty");
        ComBtnEnable("btn_Creation");
        ComBtnEnable("btn_Auto");        
    } else {
        ComBtnDisable("btn_Tsqty");
        ComBtnDisable("btn_Creation");
        ComBtnDisable("btn_Auto");      	 
    }
}
