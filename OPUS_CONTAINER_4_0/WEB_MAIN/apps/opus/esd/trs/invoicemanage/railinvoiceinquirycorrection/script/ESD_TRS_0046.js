/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0046.js
*@FileTitle  : Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var rail_road_codeCode, rail_road_codeText;
document.onclick=processButtonClick;
function processButtonClick(){
	 var sheetObject=sheetObjects[0];
	 var sheetObject2=sheetObjects[1];
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
	    if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;
			case "btn_reset":
				sheetObject.RemoveAll();
				formObject.reset();
			break;
			case "btn_minimize": {
                if(document.all.MiniLayer.style.display != "none") {
                    document.all.MiniLayer.style.display="none";                
                } else {
                    document.all.MiniLayer.style.display="";                
                }
                ComResizeSheet(sheetObject);
                break;
			}
			case "btns_calendar":
				var cal2=new ComCalendarFromTo();
				cal2.displayType="date";
				cal2.select(document.form.fmdate, document.form.todate, 'yyyyMMdd');
			break;
			case 'btns_no_cd':
				rep_Multiful_inquiry(srcName);
			break;
			case 'btng_provider':
				rep_OnPopupClick();
			break;
			case "btng_downinexcel1": {
				if(sheetObject.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				}
				break;
			}
			case "btng_downexcel2": {
				if(sheetObject.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					var chkRowCount=sheetObject.CheckedRows("ibcheck");
					if ( chkRowCount == 0){
						ComShowCodeMessage('COM12176');
						return false;
					}
					doActionIBSheet2(sheetObject2,formObject, IBDOWNEXCEL);
				}
				break;
			}
			case "btng_holdsave": {
				var checkRows=sheetObject.CheckedRows('ibcheck');
				if (checkRows == 0) {
					ComShowCodeMessage('TRS90036');
					return false;
				}
				
				var trspInvAudStsCd = "";
				var invHldFlg = "";
				var checkArray=sheetObject.FindCheckedRow('ibcheck').split('|');
				for(var i=0; i< checkArray.length; i++){
					trspInvAudStsCd = sheetObject.GetCellValue(checkArray[i], 'trsp_inv_aud_sts_cd');
					invHldFlg = sheetObject.GetCellValue(checkArray[i], 'inv_hld_flg');
					if(trspInvAudStsCd != 'RC' && trspInvAudStsCd != 'SV' && trspInvAudStsCd != 'CF' && invHldFlg == 1){			
						ComShowCodeMessage('TRS90473');
						return;
					}
				}
				if(checkReject()){
					ComShowCodeMessage('COM12113', 'not Rejected Invoice');
					return;
				}
				doActionIBSheet(sheetObject,formObject, IBSEARCH_ASYNC01);
				break;
			}
            case "btng_invoicedelete": {
                var stsRow="";
                var chkRow=sheetObject.FindCheckedRow("ibcheck");
                var arrRow=chkRow.split("|");
                for (idx=0; idx < arrRow.length; idx++){
                	stsRow=sheetObject.GetCellValue(arrRow[idx] , "trsp_inv_aud_sts_cd");
                    if(!(stsRow == "SV" || stsRow == "CF" || stsRow == "RC" )){
                        ComShowCodeMessage("TRS90058");
                        return false;
                    }
                }
                doActionIBSheet(sheetObject,formObject,IBDELETE);
                break;
            }
			case "btng_invconfrimcancel": {
				var checkRows=sheetObject.CheckedRows('ibcheck');
				if (checkRows == 0) {
					ComShowCodeMessage('TRS90036');
					return false;
				}				
                var arrRow=sheetObject.FindCheckedRow("ibcheck").split("|");
                for (idx=0; idx<arrRow.length; idx++){
                    if(sheetObject.GetCellValue(arrRow[idx] , "trsp_inv_aud_sts_cd") != "CF"){
                         ComShowCodeMessage("TRS90144");
                        return false;
                    }
                }
                
                doActionIBSheet2(sheetObject,formObject,IBSAVE );
				break;
			}
			case "btng_invaudit":
				 invoiceAuditInquiry(sheetObject , 'Y');
			break;
			case "btng_detailinquiry":
				 invoiceAuditInquiry(sheetObject , 'N');
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * IBSheet Object
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * onLoad
 */
function loadPage() {
	for(var i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initRailRoad();
}

/**
 * Init Rail Road
 */
function initRailRoad() {
 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
    getRailVendorComboList(combo_svc_provider , rail_road_codeCode , rail_road_codeText , '');                           // Serveic Provider ?? ?? (Rail Load) ??
    initVendorCombo(combo_svc_provider);
}

/**
 * param : sheetObj, sheetNo
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:  {
			with(sheetObj) {
				var HeadTitle="|Status|Hold|Invoice No|Payment S/P|Payment S/P|W/O\nCurrency|W/O Fuel\nAmount|W/O Total\nAmount|Invoice\nCurrency|Invoice\nBasic Amount|Invoice\nTotal Amount|Date|Date|Date|Date|Date|CSR No|Payment\nMethod|Check/\nT.T No|Invoice Remark|Invoice Creation|Invoice Creation" ;
				var HeadTitle1="|Status|Hold|Invoice No|Code|Name|W/O\nCurrency|W/O Fuel\nAmount|W/O Total\nAmount|Invoice\nCurrency|Invoice\nBasic Amount|Invoice\nTotal Amount|Issue|Received|Paid|G/L|Status\nUpdated|CSR No|Payment\nMethod|Check/\nT.T No|Invoice Remark|Office|User ID" ;
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"trsp_inv_aud_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"inv_hld_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"inv_vndr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"fuel_scg_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"wo_tot_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_bzc_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"inv_ttl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_iss_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_rcv_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gl_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_pay_mzd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_chk_trns_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"inv_remark",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Status",    Hidden:1,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_aud_sts_cd" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rgst_no" } ];
		       
				InitColumns(cols);
				SetEditable(1);
				SetRangeBackColor(1, 12, 1, 23,"#555555");
				ComResizeSheet(sheetObj);
			}
			break;
		}
		case 2:  {
			with(sheetObj) {
				var HeadTitle  ="Status|Hold|Invoice No|Payment S/P|Payment S/P|Rail Road|Rail Road|Equipment No|TP/SZ|W/O|W/O|W/O|W/O|Invoice|Invoice|Invoice|Date|Date|Date|Date|Date|CSR No|Payment\nMethod|Check/\nT.T No|Invoice Remark|Invoice Creation|Invoice Creation" ;
				var HeadTitle1 ="Status|Hold|Invoice No|Code|Name|Code|Name|Equipment No|TP/SZ|Currency|Basic|Surcharge|Total|Currency|Basic|Total|Issue|Received|Paid|G/L|Status\nUpdated|CSR No|Payment\nMethod|Check/\nT.T No|Invoice Remark|Office|User ID" ;
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"trsp_inv_aud_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",  	Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"inv_hld_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"inv_vndr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"wo_vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"wo_vndr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",          	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd", 	       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bzc_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"fuel_scg_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"wo_ttl_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_bzc_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_ttl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_iss_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_rcv_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"pay_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"gl_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_pay_mzd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_chk_trns_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"inv_remark",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"cre_usr_id",       	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
		             ];
				InitColumns(cols);
				SetVisible(false);
			}
			break;
		}		
	}
}
// Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:  {    
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESD_TRS_0046GS.do", TrsFrmQryString(formObj),{Sync:2});
			break;
		}
		case IBDELETE: {
			formObj.f_cmd.value=REMOVE;
			sheetObj.DoSave("ESD_TRS_0046GS.do", TrsFrmQryString(formObj) , "ibcheck" , false);
			break;
		}
		case IBDOWNEXCEL: {
		   sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), SheetDesign:1, Merge:1 });	
		   break;
		}
		case IBSEARCH_ASYNC01: {
			formObj.f_cmd.value=MULTI01;
			sheetObj.DoSave("ESD_TRS_0046GS.do", TrsFrmQryString(formObj) , -1 , false);
			break;
		}
		case IBSEARCH_ASYNC02: {
			var param = 'f_cmd='+SEARCH +'&cntr_vndr_svc_cd=RAIL&vndr_cost_cd=TR&vndr_cnt_cd=US,CA';
 	    	var sXml=sheetObj.GetSearchData("ESD_TRS_0999GS.do", param);
	    	rail_road_codeCode=ComGetEtcData(sXml, "rail_vndr_code");
	    	rail_road_codeText=ComGetEtcData(sXml, "rail_vndr_desc");
	    	break;
		}
	}
}
// Sheet
function doActionIBSheet2(sheetObj, formObj, sAction ) {
	switch(sAction) {
		case IBSAVE: {      
			formObj.f_cmd.value=MULTI02;
			formObj.inv_aud_sts_cd.value='SV';
			sheetObj.DoSave("ESD_TRS_0046GS.do", TrsFrmQryString(formObj) ,"ibcheck" , false);
			break;
		}
       case IBDELETE: {
			formObj.f_cmd.value=REMOVE;
			sheetObj.DoSave("ESD_TRS_0046GS.do", TrsFrmQryString(formObj) , "ibcheck" , false);
			break;
       }
	   case IBDOWNEXCEL:  {     
		   formObj.f_cmd.value=SEARCH02;
		   var query=sheetObjects[0].GetSaveString(false, true, 'ibcheck');
		   sheetObj.DoSearch("ESD_TRS_0046GS.do", query+"&"+ TrsFrmQryString(formObj),{Append:false} );
		   break;
	   }
	}
}
function sheet1_OnSaveEnd(sheetObj , errMsg){
    if (errMsg == 0){
        doActionIBSheet(sheetObj , document.form, IBSEARCH);
    }
}

function sheet1_OnChange(sheetObj , row , col , value){
    if(sheetObj.ColSaveName(col) == "inv_hld_flg"){
    	if (sheetObj.GetCellValue(row , "trsp_inv_aud_sts_cd") != "CF"){
            ComShowCodeMessage("TRS90144");
            sheetObj.SetCellValue(row , "inv_hld_flg",0,0);
            return;
	    }
	}
}
function invoiceAuditInquiry(sheetObj ,  editflag){
   var chkRowCount=sheetObj.CheckedRows("ibcheck");
   if ( chkRowCount!= "1"){
       ComShowCodeMessage("TRS90141");
       return false;
   }
   var chkRow=sheetObj.FindCheckedRow("ibcheck");
   chkRow=chkRow.substring(0 , chkRow.length);
   if ( editflag == "Y" ){
	   if (!( sheetObj.GetCellValue( chkRow , "trsp_inv_aud_sts_cd") == 'SV' ||  sheetObj.GetCellValue( chkRow , "trsp_inv_aud_sts_cd") == 'DA'  )){
           ComShowCodeMessage("TRS90059");
           return false;
       }
   }
   document.AuditForm.inv_no.value=sheetObj.GetCellValue(chkRow , "inv_no");
   document.AuditForm.inv_vndr_seq.value=sheetObj.GetCellValue(chkRow , "inv_vndr_seq");
   document.AuditForm.editflag.value=editflag ;
   window.open('', 'OpenAudit', "scroll:no,status:no,help:no,width=1100,Height=700");
   document.AuditForm.target="OpenAudit";
   document.AuditForm.action='ESD_TRS_0038_POP.screen?parentPgmNo=ESD_TRS_M001&mainPage=false';
   document.AuditForm.submit();
}
/**
 * rep_commodity
 */
function rep_Multiful_inquiry(btn_obj){
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val="";  
	var cmdt_desc_val="";   
	var classId="getTRS_ENS_906";
	var xx1=btn_obj;  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var param="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+ "&pgmNo=ESD_TRS_0046";
	ComOpenPopup('ESD_TRS_0906.do' + param,420, 390, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * Location 
 */
function getTRS_ENS_906(rowArray, x1) {
	var obj=eval('document.form.'+x1.substring(x1.indexOf('btns_')+5));
	obj.value=rowArray;
}
/**
 * 
 * @param combo
 */
function combo_svc_provider_OnBlur(combo) {
	var finded = combo.FindItem(combo.GetSelectCode(), 0);
	if(finded  >= 0) {
		if (document.form.svc_provider.value == combo.GetText(finded, 1)) {
			return false;
		}
		document.form.svc_provider.value = combo.GetText(combo.GetSelectCode(), 1);
	}
}

/**
 * service provider combo 
 **/
function combo_svc_provider_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){
	document.form.svc_provider.value=comboObj.GetText(newcode, 1);
}
/**
 * rep_commodity
 */
function rep_OnPopupClick(){
	var formObject=document.form;
	var cmdt_cd_val="";  
	var rep_cmdt_cd_val="";  
	var cmdt_desc_val="";  
	var classId="getCOM_ENS_rep";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * rep_commodity
 */
function getCOM_ENS_rep(rowArray) {
	var formObj=document.form;
	var comboObj=document.combo_svc_provider;
	for(var i=0; i<rowArray.length; i++){
		var colArray=rowArray[0];
		var colArray2=colArray[2];
		var colArray3=colArray[4];
		comboObj.InsertItem(comboObj.GetItemCount(), colArray2+'|'+colArray3, colArray2);
		comboObj.SetSelectText(colArray2);
		document.form.svc_provider.value=comboObj.GetText(comboObj.GetSelectText(), 1);
	}
}

function chkDaysBetween(){
	var formObj=document.form;
    var fmDt = formObj.fmdate.value;
    var toDt = formObj.todate.value;

    if(fmDt != "" && toDt != ""){
		var days_between=ComGetDaysBetween(fmDt , toDt) ;  
		if( days_between   < 0) {
			ComShowCodeMessage("TRS90118");
			formObj.fmdate.focus();
			return;
		}
    }
}

function funcRadioOnChange(obj) {
	document.getElementById("no_cd").value = '';
	if(obj.value == 'csr') {
		document.getElementById("no_cd").setAttribute("dataformat", "engup");
	} else {
		document.getElementById("no_cd").setAttribute("dataformat", "engupetc");
	}
}

/**
 * sheet2_OnSearchEnd
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	var formObj=document.form;
	if( errMsg != '' ) {
		if(formObj.f_cmd.value == SEARCH02){
			ComOpenWait(false);
		}
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == SEARCH02){
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), SheetDesign:1, Merge:1 });	
		}
	}
}

function checkReject(){
	var sheetObj=sheetObjects[0];
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	var value=null;
	var returnFlag=false;
	for(var i=0; i<checkArray.length; i++){
		value=sheetObj.GetCellValue(checkArray[i], 'trsp_inv_aud_sts_cd');
		if(value == 'RJ'){
			returnFlag=true;
			break;
		}
	}
	return returnFlag;
}