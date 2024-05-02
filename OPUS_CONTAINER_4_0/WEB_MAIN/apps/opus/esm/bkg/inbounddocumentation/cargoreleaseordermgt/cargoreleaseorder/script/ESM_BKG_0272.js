﻿/*=========================================================
****Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0272.js
*@FileTitle  :   Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
/** Event handler processing by button name
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function processButtonClick()
{
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObj=document.form;
    try 
    {
        var srcName=ComGetEvent("name");
        switch(srcName) 
        {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject,formObj,IBSEARCH);
                break;
            case "btn_DownExcel":
                doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
                break;
            case "btn_CNTRMvmt":
                funcCTMCall(sheetObject);
                break;
            case "btn_Remark":
                if(!funcCheckRowValid(sheetObject)) return;
                // prohibiting to select data 2 times
                var sRowStr=sheetObject.GetSelectionRows("|");
            	var sRowArr=sRowStr.split("|");
                if (sRowStr == "0" ) {
                	return;
                } else if (sRowArr.length > 1) {
            		//Select Only one row.
            		ComShowCodeMessage("BKG40075");
            		return;
                }
                funcGetSelectRowData(formObj, sheetObject);
                funcRemarkPopup(sheetObject);
                break;
            case "btn_EMail":
                if(!funcCheckRowValid(sheetObject)) return;
                formObj.in_checktype.value="M";
                //"/" getting selected sequence by connecting divider, result :"3/4/5"
                var sRowStr=sheetObject.GetSelectionRows("/");
                //making list
                var arr=sRowStr.split("/");
                for(i=0; i<arr.length; i++) 
                { var deTermCd  = sheetObject.GetCellValue(arr[i],"de_term_cd");
                
                
                if(deTermCd == 'D'){
                	ComShowCodeMessage("BKG95046");
                    return false;
                }
                
                }
                
                var chkMail=fnChkEMail(sheetObject, formObj);
                if (chkMail == true) {
                	var sXml=IBS_GetDataSearchXml(sheetObjects[1]);
                    document.form.mailXml.value=sXml;
                	funcSendMailPopup(formObj);
                }
                break;
            case "btn_EDI":
                //no support[check again]CLT 
            	for(i=1; i<sheetObject.Rows; i++) 
                {
                    sheetObject.SetRowStatus(i,"R");
                }
                var validOk=true;
                if(!funcCheckRowValid(sheetObject)) return;
                formObj.in_checktype.value="E";                
                //"/" getting selected sequence by connecting divider, result :"3/4/5"
                var sRowStr=sheetObject.GetSelectionRows("/");
                //making list
                var arr=sRowStr.split("/");
                for(i=0; i<arr.length; i++) 
                {
                	var cntrNo=sheetObject.GetCellValue(arr[i], "cntr_no");
                	var pkupDt=sheetObject.GetCellValue(arr[i], "cgo_pkup_dt");
                	var ydCd=sheetObject.GetCellValue(arr[i], "yd_cd");
                	var doNoYn=sheetObject.GetCellValue(arr[i], "do_no_yn");
                	var bkgCgoTpCd=sheetObject.GetCellValue(arr[i], "bkg_cgo_tp_cd");
                	var uqVslIdNo=sheetObject.GetCellValue(arr[i], "uq_vsl_id_no");
                	var pinNo=sheetObject.GetCellValue(arr[i], "pin_no");
                	var coBdgId=sheetObject.GetCellValue(arr[i], "co_bdg_id");
                	var rlseExpDt=sheetObject.GetCellValue(arr[i], "rlse_exp_dt");
                    var toDay=ComGetNowInfo("ymd")+ComGetNowInfo("hm");
                    var cgoCrrId=sheetObject.GetCellValue(arr[i], "cgo_crr_id");
                    var bkgTrspModCd = sheetObject.GetCellValue(arr[i],"bkg_trsp_mod_cd");
                    var deTermCd  = sheetObject.GetCellValue(arr[i],"de_term_cd");
                    
                    
                    if(deTermCd == 'D'){
                    	ComShowCodeMessage("BKG95046");
                        return false;
                    }
                    
                    if(ydCd == null || ydCd == '')
                    {
                        ComShowCodeMessage("BKG40100", "pickup yard", cntrNo);
                        return false;
                    }
                    if(ydCd.length != 7)
                    {
                        ComShowCodeMessage("BKG40102","pickup yard" + "["+ ydCd + "]",cntrNo);
                        validOk=false;
                        break;
                    }
                    if(pkupDt == null || pkupDt == ''  )
                    {
                        ComShowCodeMessage("BKG40100", "pickup date", cntrNo);
                        return false;
                    }
                    if(pkupDt.length != 8)
                    {
                        ComShowCodeMessage("BKG40102","pickup date" + "["+ pkupDt + "]",cntrNo);
                        validOk=false;
                        break;
                    }
                    if(bkgTrspModCd == null || bkgTrspModCd == '')
                    {
                        ComShowCodeMessage("BKG40100", "T-Mode", cntrNo);
                        return false;
                    }
                    if((uqVslIdNo != null && uqVslIdNo != '') && uqVslIdNo.length < 5)
                    {
                        ComShowCodeMessage("BKG95018", "UVI No.", "5digit");
                        validOk=false;
                        break;
                    }
//                  if((pinNo != null && pinNo != '') && pinNo.length < 4)
                    if((pinNo != null && pinNo != '') && pinNo.length < 3)  // 2014.08.13 3~7자리 랜덤으로 변경 (안진응)
                  {
//                      ComShowCodeMessage("BKG95018", "PIN", "4digit");
                      ComShowCodeMessage("BKG95018", "PIN", "3digit ~ 7digit");
                      validOk = false;
                      break;
                  }                    
                    
                    if((coBdgId != null && coBdgId != '') && coBdgId.length < 3)
                    {
                        ComShowCodeMessage("BKG95018", "Badge Code", "3");
                        validOk=false;
                        break;
                    }
                    toDay=ComReplaceStr(toDay, "-", ""); 
                    toDay=ComReplaceStr(toDay, ":", ""); 
                    if(rlseExpDt != '' && rlseExpDt.substr(0,8) < toDay.substr(0,8)) 
                    {
                        ComShowCodeMessage("COM12131", "Release Expiry Date");
                        validOk=false;
                        break;
                    }
                    if((cgoCrrId != null && cgoCrrId != '') && cgoCrrId.length < 3)
                    {
                        ComShowCodeMessage("BKG06065", "Trucker code/Name");
                        validOk=false;
                        break;
                    }
					sheetObject.SetRowStatus(arr[i],"U");
                }
                if(!validOk) return;
                //transmitting EDI 
                if(!ComShowCodeConfirm("BKG01070")) return;
                doActionIBSheet(sheetObject,formObj,MULTI01);
                break;
            case "btn_CargoRelease":
            	fnGoCargoRelease(sheetObjects[0]);
                break;
            case "btn_Print":
                if(!funcCheckRowValid(sheetObject)) return;
                sheetObject.DoPrint();
                break;
            case "rad_vvd":
                funcChangeRadio(formObj, 'VVD');
                break;
            case "rad_bl":
                funcChangeRadio(formObj, 'BL')
                break;
            case "btn_Save":
            	//
            	for(i=1; i<sheetObject.Rows; i++) 
                {
                    sheetObject.SetRowStatus(i,"R");
                }
            	
            	var validOk=true;
            	if(!funcCheckRowValid(sheetObject)) return;
            	var sRowStr=sheetObject.GetSelectionRows("/");
                //making list
                var arr=sRowStr.split("/");
                
                for(i=0; i<arr.length; i++) 
                {

                	
                	var pinNo=sheetObject.GetCellValue(arr[i], "pin_no");
                	
                	if((pinNo != null && pinNo != '') && pinNo.length < 3)  // 2014.08.13 3~7자리 랜덤으로 변경 (안진응)
	                {
	                    ComShowCodeMessage("BKG95018", "PIN", "3digit ~ 7digit");
	                    validOk = false;
	                    break;
	                }                    
	                    
	                sheetObject.SetRowStatus(arr[i],"U");
                }
                if(!validOk) return;
                
                if(!ComShowCodeConfirm("BKG00350")) return;
                doActionIBSheet(sheetObject,formObj,MULTI03);
       } // end switch
    }
    catch(e) 
    {
        if( e == "[object Error]") 
        {
        	 ComShowCodeMessage("BKG40101");
        } 
        else 
        {
            ComShowMessage(e);
        }
    }
}
/**
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj)
{
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet<br>
 * implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function loadPage() 
{
    for(i=0;i<sheetObjects.length;i++)
    {
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
    
    //@ Test Code Start ----------
//    	document.form.in_bl_no.value = "SIN400569300";
	//@ Test Code End   ----------
    if(document.form.in_bl_no.value.length > 0)
    {
        funcChangeRadio(document.form, 'BL', document.form.in_bl_no);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    else
    {
        funcChangeRadio(document.form, 'VVD', document.form.in_vvd);
    }
}
/**
 * initializing  : registering event .<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function initControl() 
{
    var formObject=document.form;
    //Axon event catch
    axon_event.addListenerForm ('focus'  ,'obj_activate',    formObject); //- focus in
//    axon_event.addListenerFormat('keypress'        ,'obj_keypress', document.form);
//    axon_event.addListenerFormat('keyup'           ,'keyupcheck',      formObject);
    axon_event.addListener      ('keydown'         ,'ComKeyEnter',         'form');
}
/**
 * <br>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01 
 */
function obj_activate()
{
    var form=document.form;
    var srcName=ComGetEvent("name");
    switch(srcName)
    {
    case 'in_vvd':
        funcChangeRadio(form, "VVD");
        break;
    case 'in_pod':
        funcChangeRadio(form, "VVD",form.in_pod);
        break;
    case 'in_bl_no':
        funcChangeRadio(form, "BL");
        break;
    }
}
/**
 * in case of inputting value completely, moving focus to next object 
 * @param {void}
 * @return void
 */
//function keyupcheck()
//{
//    var form=document.form;
//    var key=event.keyCode;
//    var srcValue=event.srcElement.getAttribute("value");
//    var dtaLength=event.srcElement.getAttribute("maxlength");
//    var srcLength=srcValue.length; 
//    var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//    var srcName=event.srcElement.getAttribute("name");
//    if(srcLength < dtaLength) return;
//    switch(srcName)
//    {
//    case 'in_vvd':
//        form.in_pod.focus();
//        break;
//    case 'in_pod':
//        form.in_cntr_no.focus();
//        break;
//    case 'in_bl_no':
//        form.in_cntr_no.focus();
//        break;
//    }
//}
/**
 * handling process for input validation<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj mandatory, Sheet
 * @param {Object} formObj mandatory, form object
 * @param {int} sAction mandatory, code
 * @param {String} CondParam mandatory, 
 * @param {int} PageNo option, page number
 * @return void
 * @author
 * @version 2009.10.01
 */
function validateForm(sheetObj,formObj,sAction)
{
    switch(sAction)
    {
        case IBSEARCH:
            if(formObj.in_option.value == 'VVD')
            {
                if(!ComChkObjValid(formObj.in_vvd)) return false;
                if(!ComChkObjValid(formObj.in_pod)) return false;
             }
            else
            {
                if(!ComChkObjValid(formObj.in_bl_no)) 
                {
                    formObj.in_bl_no.focus();
                    return false;
                }
            }
            break;
    }
    return true;
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}


/**
 * setting sheet initial values and header<br>
 * param : sheetObj, sheetNo<br>
 * adding case as numbers of counting sheets<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj mandatory, Sheet object
 * @param {int} sheetNo Sheet Index sequence
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function initSheet(sheetObj,sheetNo) 
{
    var cnt=0;
    switch(sheetNo) 
    {
        case 1:      //sheet1 init
            with(sheetObj)
            {
		          
//		          (35, 0, 0, true);
		          var HeadTitle1="||Seq.|Err|B/L No.|BKG No.|Container|TP/SZ|Consignee|Full Release Yard|MT Return Yard|T/VVD|POL|POD|D/O|D/O No|PIN|Pin No sent|RlseSeq|ATB#|Badge Code|Release Expiry Date|Trucker Code/Name|Vehicle Registration|R.H.I.D.S Code|UVI No.|Fax No.|T-Mode|ATP No.|P/Up DT|CNXL|Del. Term|Full Release Sent|Yard Name|Email|Phone No|Vessel Name|Location|do_iss_dt|bkg_cgo_tp_cd|content|pod_nm";
		
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"err",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mty_rtn_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"do_no_yn",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"do_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pin_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pin_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:7 },
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"snd_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlse_ord_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:155,  Align:"Center",  ColMerge:1,   SaveName:"msg_acpt_ref_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, // ATB# 추가
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"co_bdg_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"rlse_exp_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cgo_crr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		                 {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"veh_rgst_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"road_hlg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"uq_vsl_id_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"fax_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cstms_voy_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cgo_pkup_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cxl_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"sent_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"yd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"yd_eml",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"phn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"vsl_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"loc_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"do_iss_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"bkg_cgo_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"content",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"pod_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
		           
		          InitColumns(cols);
		
		          SetEditable(1);
		          SetColProperty("bkg_trsp_mod_cd", {ComboText:evtValue, ComboCode:evtCode} );
		          SetColProperty("cxl_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
		          SetColProperty("co_bdg_id", {AcceptKeys:"E", InputCaseSensitive:1} );
		          SetColProperty("yd_cd", {InputCaseSensitive:1} );
		          SetColProperty("mty_rtn_yd_cd", {InputCaseSensitive:1} );
	              SetColProperty("pin_no", {AcceptKeys:"N|E", ExceptKeys:"[B,I,O,S]", InputCaseSensitive:1} );
	              SetColProperty("road_hlg_id", {AcceptKeys:"N"});
	              SetColProperty("uq_vsl_id_no", {AcceptKeys:"N"});
//		          SetSheetHeight(440);
	              resizeSheet();
          }
        break;
        case 2:
            with(sheetObj)
            	{	         
//		          (20, 0, 0, true);
		          var HeadTitle1="|B/L No.|BKG No.|Container|POD|Yard|P/Up DT|Yard Name|Email|Phone No|Fax No.|diff_rmk|vsl_nm|vvd|loc_nm|cust_nm|bkg_trsp_mod_cd|send_date|do_no|do_iss_dt|pin_no|snd_flg|rlse_ord_seq|msg_acpt_ref_no|content|pod_nm|rlse_exp_dt";
		
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cgo_pkup_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"yd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"yd_eml",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"phn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"fax_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"vsl_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"loc_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"send_date",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"do_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"do_iss_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pin_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"snd_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlse_ord_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"msg_acpt_ref_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, // ATB# 추가
		                 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"content",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"pod_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"rlse_exp_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
		                 ];
		           
		          InitColumns(cols);		
		          SetEditable(1);
		          SetColProperty("bkg_trsp_mod_cd", {ComboText:evtValue, ComboCode:evtCode} );
		          SetVisible(false);
          }


        break;
    }
}
/**
 * handling of Sheet <br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj mandatory, 
 * @param {Object} formObj mandatory, 
 * @param {String} sAction mandatory, 
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj, formObj, sAction) 
{
    var status='';
    switch(sAction) 
    {
        case IBSEARCH:      
            formObj.f_cmd.value=SEARCH;
            if(!validateForm(sheetObj,formObj,sAction)) return;
            sheetObj.DoSearch("ESM_BKG_0272GS.do", FormQueryString(formObj) );
            break;
        case IBDOWNEXCEL:
        	if(sheetObj.RowCount() < 1){//no data	
        		ComShowCodeMessage("COM132501");
        	}else{	
//        		 sheetObj.Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
        		 sheetObj.Down2Excel({ HiddenColumn:1,SheetDesign:1, Merge:1,AutoSizeColumn:1,SheetName:"FullCargoRelease"});
        	}	
    	   break;

        	
         
        case MULTI01:
            //EDI 
            formObj.f_cmd.value=MULTI01;           
            var saveStr=sheetObj.GetSaveString();
            var xml=sheetObj.GetSaveData("ESM_BKG_0272GS.do", FormQueryString(formObj) + "&" + saveStr);
	        var rMsg=ComResultMessage(xml);
            if(rMsg != ''){
            	var State=ComGetEtcData(xml, ComWebKey.Trans_Result_Key);
				if(State == "S"){
					 ComShowCodeMessage("BKG00101");
					 
					 formObj.f_cmd.value=SEARCH;
			         sheetObj.DoSearch("ESM_BKG_0272GS.do", FormQueryString(formObj) );	
				} else {
					ComShowMessage(rMsg);
				}
			 }           
             break;     

        case MULTI03:
            //SAVE 
            formObj.f_cmd.value=MULTI03;           
            var saveStr=sheetObj.GetSaveString();
            
            var xml=sheetObj.GetSaveData("ESM_BKG_0272GS.do", FormQueryString(formObj) + "&" + saveStr);
	        var rMsg=ComResultMessage(xml);
            if(rMsg != ''){
            	var State=ComGetEtcData(xml, ComWebKey.Trans_Result_Key);
				if(State == "S"){
					 ComShowCodeMessage("BKG00102");	

					 formObj.f_cmd.value=SEARCH;
			         sheetObj.DoSearch("ESM_BKG_0272GS.do", FormQueryString(formObj) );					 
				} else {
					ComShowMessage(rMsg);
				}
			 }           
             break;     
    
    }
}
/**
 * onkeypress.<br>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
//function obj_keypress()
//{
//    var key=event.keyCode;
//    switch(event.srcElement.dataformat)
//    {
//        case "float":
//            //number+"."
//            ComKeyOnlyNumber(event.srcElement, ".");
//            break;
//        case "eng":
//            //only alphabet, alphabet + number -> ComKeyOnlyAlphabet('num');
//            ComKeyOnlyAlphabet('uppernum');
//            break;
//        case "engdn":
//            //only alphabet lower case, only alphabet lower case + number -> ComKeyOnlyAlphabet('lowernum');
//            ComKeyOnlyAlphabet('lower');
//            break;
//        case "engup":
//            //only alphabet upper case, alphabet upper case + number -> ComKeyOnlyAlphabet('uppernum');
//            ComKeyOnlyAlphabet('upper');
//            break;
//        default:    
//            //only number (inteager, date, time)
//            ComKeyOnlyNumber(event.srcElement);
//    }
//}
/**
 *  activating or deactivating as option of HTML <br>
 * @param {Object} formObj option, page number
 * @param {String} isvvd   in case of VVD, inputting "VVD" 
 * @param {Object} obj Form의 Object
 * @return {void} 
 * @author
 * @version 2009.10.01
 */
function funcChangeRadio(formObj, isvvd, obj)
{
    if(isvvd == 'VVD')
    {
        formObj.rad_vvd.checked=true;
        formObj.rad_bl.checked=false;
        formObj.in_option.value='VVD';
        formObj.in_vvd.className="input1";
        formObj.in_pod.className="input1";
        formObj.in_bl_no.className="input11";
        if(obj == null){
        	if(formObj.in_vvd.value.length < 9){
        		formObj.in_vvd.focus();
        	}
        }else{ 
        	obj.focus();
        }
        
    }
    else
    {
        formObj.rad_vvd.checked=false;
        formObj.rad_bl.checked=true;
        formObj.in_vvd.className="input11";
        formObj.in_pod.className="input11";
        formObj.in_bl_no.className="input1";
        formObj.in_option.value='BL';
        if(obj == null)formObj.in_bl_no.focus();
        else obj.focus();
    }
}
/**
 * copy data in sheet to form<br>
 * @param {Object} formObj option, page number
 * @param {Object} sheetObj mandatory, Sheet object
 * @return {void} 
 * @author
 * @version 2009.10.01
 */
function funcGetSelectRowData(formObj, sheetObj)
{
    var rowIndex=sheetObj.GetSelectRow();
    formObj.p_diff_rmk.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("diff_rmk"));
    formObj.p_err.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("err"));
    formObj.p_bl_no.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("bl_no"));
    formObj.p_bkg_no.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("bkg_no"));
    formObj.p_cntr_no.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("cntr_no"));
    formObj.p_cntr_tpsz_cd.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("cntr_tpsz_cd"));
    formObj.p_yd_cd.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("yd_cd"));
    formObj.p_cust_nm.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("cust_nm"));
    formObj.p_vvd.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("vvd"));
    formObj.p_pol_cd.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("pol_cd"));
    formObj.p_pod_cd.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("pod_cd"));
    formObj.p_do_no_yn.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("do_no_yn"));
    formObj.p_do_no.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("do_no"));
    formObj.p_do_iss_dt.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("do_iss_dt"));
    formObj.p_fax_no.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("fax_no"));
    formObj.p_bkg_trsp_mod_cd.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("bkg_trsp_mod_cd"));
    formObj.p_cgo_pkup_dt.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("cgo_pkup_dt"));
    formObj.p_cxl_flg.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("cxl_flg"));
    formObj.p_de_term_cd.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("de_term_cd"));
    formObj.p_sent_flg.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("sent_flg"));
    formObj.p_yd_nm.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("yd_nm"));
    formObj.p_yd_eml.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("yd_eml"));
    formObj.p_phn_no.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("phn_no"));
    formObj.p_vsl_nm.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("vsl_nm"));
    formObj.p_loc_nm.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("loc_nm"));
    formObj.p_pin_no.value=sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("pin_no"));
    sheetObj.SetRowStatus(rowIndex,"U");
}
/**
 *  calling BL Editing Pop up .<br>
 * @param {Object} sheetObj mandatory, Sheet object
 * @return {void} 
 * @author
 * @version 2009.10.01
 */
function funcRemarkPopup(sheetObj)
{
    var rowIndex=sheetObj.GetSelectRow();
    var colIndex=sheetObj.SaveNameCol("diff_rmk");
    var celValue=sheetObj.GetCellValue(rowIndex, colIndex);
    document.form.p_row.value=rowIndex;
    document.form.p_diff_rmk.value=celValue;
    var condition="?pgmNo=ESM_BKG_1052&";
    condition += FormQueryString(document.form);
    ComOpenPopup("/opuscntr/ESM_BKG_1052.do" + condition, 600, 300, "t0002", "1,0", false);
}
/**
 * calling BL Editing Pop up.<br>
 * @param {int} rowIdx mandatory, selected row of Sheet 
 * @param {String} remark value mandatory,  Remark 
 * @return {void} 
 * @author
 * @version 2009.10.01
 */
function funcSetRemark(rowIdx, remarkvalue)
{
    var sheetObj=sheetObjects[0];
    var i_row=parseInt(rowIdx);
    sheetObj.SetCellValue(i_row, sheetObj.SaveNameCol("diff_rmk"),remarkvalue);
}
/**
 * calling pop up for mail.<br>
 * @param {Object} formObj mandatory, Form object
 * @return {void} 
 * @author
 * @version 2009.10.01
 */
function funcSendMailPopup(formObj)
{	
	formObj.mailSendYn.value="";
    var condition="?";
    formObj.f_cmd.value=REPLY;    //creating Mail Content 
    ComOpenPopup("/opuscntr/ESM_BKG_0272_1.do", 600, 680, "funcReQuery", "1,0", false);
}

function funcReQuery(sendYn)
{
	if (sendYn == "Y" ) {    
		var formObj=document.form;
		var sheetObject=sheetObjects[0];
	    formObj.f_cmd.value=SEARCH;
	    sheetObject.DoSearch("ESM_BKG_0272GS.do", FormQueryString(formObj) );
	}
}

/**
 * calling screen of CTM pop up .<br>
 * @param {Object} sheetObj mandatory, Form object
 * @return {void} 
 * @author
 * @version 2009.10.01
 */
function funcCTMCall(sheetObj)
{
    if(!funcCheckRowValid(sheetObj)) return;
    var sRowStr=sheetObj.GetSelectionRows("|");
    var sRowArr=sRowStr.split("|");
    var cntrNo="";
    var tpszCd="";
    if (sRowStr != "0" ) {
    	if (sRowArr.length > 1) {
    		//Select Only one row.
    		ComShowCodeMessage("BKG08040");
    		return;
    	}
    	cntrNo=sheetObj.GetCellValue(sRowArr[0], "cntr_no");
    	tpszCd=sheetObj.GetCellValue(sRowArr[0], "cntr_tpsz_cd");
    }
	var condition="?pgmNo=EES_CTM_0411"
    	           + "&cntrNo=" + cntrNo
                   + "&typeSize=" + tpszCd;
    ComOpenPopup("/opuscntr/EES_CTM_0411_POP.do" + condition, 1020, 660, "t0002", "1,0", false);
}
/**
 * calling EU Cargo Release.<br>
 * @param {Object} sheetObj mandatory, Form object
 * @return {void} 
 * @author
 * @version 2009.11.03
 */
function fnGoCargoRelease(sheetObj) {
    if(!funcCheckRowValid(sheetObj)) return;
    var sRowStr=sheetObj.GetSelectionRows("|");
    var sRowArr=sRowStr.split("|");
    var bkgNo="";
    if (sRowStr != "0" ) {
    	if (sRowArr.length > 1) {
    		//Select Only one row.
    		ComShowCodeMessage("BKG08040");
    		return;
    	}
    	bkgNo=sheetObj.GetCellValue(sRowArr[0], "bkg_no");
    }
    var condition="?pgmNo=ESM_BKG_0938"
        + "&bkg_no=" + bkgNo;
//	ComOpenPopup("/opuscntr/ESM_BKG_0938_POP.do" + condition, 1100, 700, "t0002", "1,0", false, null, null, null, null, null, "yes");
	ComOpenWindowCenter("/opuscntr/ESM_BKG_0938_POP.do" + condition,"ESM_BKG_0938",1150,700,false);//팝업
}
/**
 *  changing type String to Date<br>
 * @param {String} sDate mandatory, date
 * @return {Date}  Date 
 * @author
 * @version 2009.10.01
 */
function strToDate(sDate) 
{
    try 
    {
        sDate=sDate.replace(/\/|\-|\.|\:|\ /g,"");  //deleting date divider, time divider, space 
        var arr=ComNumberArray(7);
        var iLen=sDate.length;
        if (iLen>=4) arr[0]=sDate.substr(0,4);        //year
        if (iLen>=6) arr[1]=sDate.substr(4,2)-1;        //month
        if (iLen>=8) arr[2]=sDate.substr(6,2);        //day
        if (iLen>=10) arr[3]=sDate.substr(8,2);        //hours
        if (iLen>=12) arr[4]=sDate.substr(10,2);        //minutes
        if (iLen>=14) arr[5]=sDate.substr(12,2);        //seconds
        if (iLen<=17) arr[6]=sDate.substr(14);        //hour
        return new Date(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
    } catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * checking validation of Sheet<br>
 * @param {Object} sheetObj mandatory, Sheet object
 * @return {boolean} valid 
 * @author
 * @version 2009.10.01
 */
function funcCheckRowValid(sheetObj)
{
    var rowIndex=sheetObj.GetSelectRow();
    if(rowIndex < 1 || isNaN(rowIndex))
    {
        ComShowCodeMessage("BKG95010");
        return false;
    }
    return true;
}
/**
 *  handling data when sheet is double clicked<br>
 * @param {Object} sheetObj mandatory, Sheet object
 * @param {int} row mandatory, row of Sheet
 * @param {int} col mandatory, column of Sheet
 * @return {void} 
 * @author
 * @version 2009.10.01
 */
function sheet1_OnDblClick(sheetObj,row,col)
{
    formObj=document.form;
    with(sheetObj)
    {
        if(row >= 1)
        {
        	var bl_no=sheetObj.GetCellValue(row, sheetObj.SaveNameCol("bl_no"));
        	var cntr_no=sheetObj.GetCellValue(row, sheetObj.SaveNameCol("cntr_no"));
            var condition="?pgmNo=ESM_BKG_0273&bl_no=" + bl_no + "&cntr_no=" + cntr_no;
            ComOpenPopup("/opuscntr/ESM_BKG_0273_POP.do" + condition, 1024, 660, "t0002", "1,0", false);
        }
    }
}
 /**
  * sheet1 after saving,modifying, deleting Operation, Refreshing screen
  */
function sheet1_OnSaveEnd(sheetObj, ErrMsg){	  
	  // prohibiting retrieving after transmitting EDI
	  //doActionIBSheet(sheetObj, document.form,IBSEARCH);
}
function fnChkEMail(sheetObj, formObj) {
	var sRowStr=sheetObj.GetSelectionRows();
	var arr=sRowStr.split("|");
	var colIndex="";
	var rowIndex="";
	var now="";
	var dateValue="";
	var celValue="";
	var row7=0;
	sheetObjects[1].RemoveAll();
	var now=new Date();
	var sendDate=formatDate(now, "dd / MMM / yy - hh:mm a");
	for (i=0; i<arr.length; i++) {
    	colIndex=sheetObj.SaveNameCol("yd_cd");
        rowIndex=arr[i];
        if(isNaN(colIndex)) 
        {
            ComShowCodeMessage("BKG00155");
            return false;
        }
        celValue=sheetObj.GetCellValue(rowIndex, colIndex);
        if(celValue == null || celValue == '')
        {
        	ComShowCodeMessage("BKG40100", "pickup yard", sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("cntr_no")));
            return false;
        }
        if(celValue.length != 7)
        {
            ComShowCodeMessage("COM132201","pickup yard" + "["+ celValue + "]");
            validOk=false;
            break;
        }          
        colIndex=sheetObj.SaveNameCol("cgo_pkup_dt");
        if(isNaN(colIndex))
        {
            ComShowCodeMessage("BKG00155");
            return false;
        }
        celValue=sheetObj.GetCellValue(rowIndex, colIndex);
        if(celValue==null || celValue == '')
        {
        	ComShowCodeMessage("BKG40100", "pickup date", sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("cntr_no")));
             return false;
        }
        if(celValue.length != 8)
        {
        	 ComShowCodeMessage("COM132201","pickup date" + "["+ celValue + "]");
        	 return false;
        }
        colIndex=sheetObj.SaveNameCol("bkg_trsp_mod_cd");
        if(isNaN(colIndex))
        {
            ComShowCodeMessage("BKG00155");
            return false;
        }
        celValue=sheetObj.GetCellValue(rowIndex, colIndex);
        if(celValue==null || celValue == '')
        {
        	ComShowCodeMessage("BKG40100", "T-Mode", sheetObj.GetCellValue(rowIndex, sheetObj.SaveNameCol("cntr_no")));
             return false;
        }
        row7=sheetObjects[1].DataInsert(-1);           //adding row at last column
        sheetObjects[1].SetCellValue(row7, "bl_no",sheetObjects[0].GetCellValue(rowIndex, "bl_no"),0);
        sheetObjects[1].SetCellValue(row7, "bkg_no",sheetObjects[0].GetCellValue(rowIndex, "bkg_no"),0);
        sheetObjects[1].SetCellValue(row7, "cntr_no",sheetObjects[0].GetCellValue(rowIndex, "cntr_no"),0);
        sheetObjects[1].SetCellValue(row7, "pod_cd",sheetObjects[0].GetCellValue(rowIndex, "pod_cd"),0);
        sheetObjects[1].SetCellValue(row7, "yd_cd",sheetObjects[0].GetCellValue(rowIndex, "yd_cd"),0);
        sheetObjects[1].SetCellValue(row7, "cgo_pkup_dt",sheetObjects[0].GetCellValue(rowIndex, "cgo_pkup_dt"),0);
        sheetObjects[1].SetCellValue(row7, "yd_nm",sheetObjects[0].GetCellValue(rowIndex, "yd_nm"),0);
        sheetObjects[1].SetCellValue(row7, "yd_eml",sheetObjects[0].GetCellValue(rowIndex, "yd_eml"),0);
        sheetObjects[1].SetCellValue(row7, "phn_no",sheetObjects[0].GetCellValue(rowIndex, "phn_no"),0);
        sheetObjects[1].SetCellValue(row7, "fax_no",sheetObjects[0].GetCellValue(rowIndex, "fax_no"),0);
        sheetObjects[1].SetCellValue(row7, "diff_rmk",sheetObjects[0].GetCellValue(rowIndex, "diff_rmk"),0);
        sheetObjects[1].SetCellValue(row7, "vsl_nm",sheetObjects[0].GetCellValue(rowIndex, "vsl_nm"),0);
        sheetObjects[1].SetCellValue(row7, "vvd",sheetObjects[0].GetCellValue(rowIndex, "vvd"),0);
        sheetObjects[1].SetCellValue(row7, "loc_nm",sheetObjects[0].GetCellValue(rowIndex, "loc_nm"),0);
        sheetObjects[1].SetCellValue(row7, "cust_nm",sheetObjects[0].GetCellValue(rowIndex, "cust_nm"),0);
        sheetObjects[1].SetCellValue(row7, "bkg_trsp_mod_cd",sheetObjects[0].GetCellValue(rowIndex, "bkg_trsp_mod_cd"),0);
        sheetObjects[1].SetCellValue(row7, "send_date",sendDate,0);
        sheetObjects[1].SetCellValue(row7, "do_no",sheetObjects[0].GetCellValue(rowIndex, "do_no"),0);
        sheetObjects[1].SetCellValue(row7, "do_iss_dt",sheetObjects[0].GetCellValue(rowIndex, "do_iss_dt"),0);
        sheetObjects[1].SetCellValue(row7, "pin_no",sheetObjects[0].GetCellValue(rowIndex, "pin_no"),0);
        sheetObjects[1].SetCellValue(row7, "snd_flg",sheetObjects[0].GetCellValue(rowIndex, "snd_flg"),0);
        sheetObjects[1].SetCellValue(row7, "rlse_ord_seq",sheetObjects[0].GetCellValue(rowIndex, "rlse_ord_seq"),0);
        sheetObjects[1].SetCellValue(row7, "msg_acpt_ref_no",sheetObjects[0].GetCellValue(rowIndex, "msg_acpt_ref_no"),0);
        sheetObjects[1].SetCellValue(row7, "content",sheetObjects[0].GetCellValue(rowIndex, "content"),0);
        sheetObjects[1].SetCellValue(row7, "pod_nm",sheetObjects[0].GetCellValue(rowIndex, "pod_nm"),0);
        sheetObjects[1].SetCellValue(row7, "rlse_exp_dt",sheetObjects[0].GetCellValue(rowIndex, "rlse_exp_dt"),0);
        
	}
	return true;
}
 