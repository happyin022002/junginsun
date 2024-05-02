/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0038.js
*@FileTitle  : USA Rail Invoice Register and Confirm
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/

var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var beforetab2=1;
var sheetObjects=new Array();
var sheetCnt=0;
var minCount=0;
var parmObj=new Array();
var fromObj=new Array();
var rdObj=new Array();
var rail_road_codeCode;
var rail_road_codeText;
document.onclick=processButtonClick;
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var sheetObject2=sheetObjects[2];
	var sheetObject3=sheetObjects[3];
	var formObject=document.form;
	var checkflag=false;
	var confirmflag=false;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_close": {
				ComClosePopup();
				break;
			}
			case "btn_retrieve": {
				if ( ComIsEmpty(formObject.inv_no)) {
					formErrMsg("Invoice No");
					formObject.inv_no.focus();
					return;
				}
				if ( ComIsEmpty(formObject.rail_road_name)) {
					formErrMsg("Rail Road");
					return;
				}
				doActionIBSheet(sheetObject,formObject,IBSEARCH); 
				formObject.inv_no.readOnly=true ;
				formObject.currency.disabled=true;
				rail_road_code.SetEnable(0);
				break;
			}
			case "btn_reset":    
				formObject.editflag.value = "";
				formObject.reset();
				formObject.sts_cd.value = "";
				rail_road_code.SetSelectText("");
				formObject.inv_no.readOnly=false ;
				formObject.currency.disabled=false;
				rail_road_code.SetEnable(true);
				formObject.sts_cd.value == ""; 
				formObject.issue_dt.value = today;
				formObject.receive_dt.value = today;
				
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				sheetObject3.RemoveAll();
				
				if(!sheetObject.GetEditable()) {
					sheetObject.SetEditable(true);
				}
				if(!sheetObject1.GetEditable()) {
					sheetObject1.SetEditable(true);
				}
				if(!sheetObject2.GetEditable()) {
					sheetObject2.SetEditable(true);
				}
				if(!sheetObject3.GetEditable()) {
					sheetObject3.SetEditable(true);
				}
				break;
			case "btn_minimize":  {
				if(document.all.MiniLayer.style.display != "none") {
			        document.all.MiniLayer.style.display="none";                
			    } else {
			        document.all.MiniLayer.style.display="";                
			    }
				var selectTabIndex = tabObjects[0].GetSelectedIndex();
				if(selectTabIndex == 0) {
					ComResizeSheet(sheetObjects[0], 60);
				} else if(selectTabIndex == 1) {
					ComResizeSheet(sheetObjects[1], 60);
				} else {
					
				}
							    			
				break;
			}
			case "btns_provider":   // Service provider popup
				if ( ! ComIsEmpty(formObject.editflag))    return;
				rep_OnPopupClick();
				break;
			case "btns_calendar1":  // Receive DT 
				if ( ! ComIsEmpty(formObject.editflag))    return;
				var cal=new ComCalendar();
				cal.select(formObject.receive_dt, 'yyyy-MM-dd');
				break;
			case "btns_calendar2":  // Issue DT
				if ( ! ComIsEmpty(formObject.editflag))    return;
				var cal=new ComCalendar();
				cal.select(formObject.issue_dt, 'yyyy-MM-dd');
				break;
			case "t1btng_invoicefileimport":   // file import popup
			case "t2btng_invoicefileimport":
			case "t3btng_invoicefileimport":
				if ( ! ComIsEmpty(formObject.editflag))    return;
				if (formObject.sts_cd.value == "FI" || formObject.sts_cd.value == "SV") {
					ComShowMessage(ComGetMsg("TRS90008"));
					return false;
				}
				if (chkComfirm(formObject)) return false;
				if ( ComIsEmpty(formObject.inv_no)) {
					formErrMsg("Invoice No");
					formObject.inv_no.focus();
					return false;
				}
				if ( ComIsEmpty(formObject.rail_road_name)) {
					formErrMsg("Rail Road");
					return false;
				}
				var url='?inv_no='+formObject.inv_no.value;
				url += '&rail_road_code='+ rail_road_code.GetSelectCode();
				url += '&rail_road_name='+formObject.rail_road_name.value;
				url += '&payment_vndr_code='+formObject.payment_vndr_code.value;
				url += '&payment_vndr_name='+formObject.payment_vndr_name.value;
				url += '&receive_dt='+formObject.receive_dt.value;
				url += '&issue_dt='+formObject.issue_dt.value;
				url += '&invoice_amt='+formObject.invoice_amt.value;
				url += '&vat_amt='+formObject.vat_amt.value;
				url += '&currency='+formObject.currency.value;
				ComOpenPopup('ESD_TRS_0923.do'+url, 930, 450, '', "1,0,1,1,1,1,1,1,1,1,1,1", false);
				break;
			case "t1btng_paymenthistory":       // Payment History
			case "t2btng_paymenthistory":
			case "t3btng_paymenthistory":
				if ( srcName == "t1btng_paymenthistory") {
					checkflag=chkCntr(sheetObject);   
				}
				if ( srcName == "t2btng_paymenthistory") {
					checkflag=chkCntr(sheetObject1);    
				}
				if ( srcName == "t3btng_paymenthistory") {
					checkflag=chkCntr(sheetObject2);
				}
				if (checkflag) {
					ComShowMessage(ComGetMsg("COM12177"));
					return false;
				}
				ComOpenPopup('ESD_TRS_0929.do', 900, 400, '', 'none', true);
				break;
			case "t2btng_move": {
				if ( formObject.editflag.value == "N")    return;
				if (chkComfirm(formObject)) return;                     
				moveSheetData( sheetObject1, sheetObject, "sel");      
				break;
			}
			case "t1btng_reaudit":
				if ( formObject.editflag.value == "N")    return;
				if (chkComfirm(formObject)) return;                     
				if(sheetObject.CheckedRows('sel') == 0){
					ComShowMessage(ComGetMsg("COM12176" ));
					return;
				}
				var myOption="width=900; height=770; help=no; status=no; resizable=no; scroll=no;";
				ComOpenWindow('ESD_TRS_0925.do?mode=search&sel_sheet_idx=0', "ESD_TRS_0925", myOption ,false);
				break;
			case "t2btng_reaudit":
				if ( formObject.editflag.value == "N")    return;
				if (chkComfirm(formObject)) return;                   
				if(sheetObject1.CheckedRows('sel') == 0) {
					ComShowMessage(ComGetMsg("COM12176" ));
					return;
				}
				var myOption="width=900; height=770; help=no; status=no; resizable=no; scroll=no;";
				ComOpenWindow('ESD_TRS_0925.do?mode=search&sel_sheet_idx=1', "ESD_TRS_0925",myOption,false);
				break;
			case "t3btng_reaudit":
				if ( formObject.editflag.value == "N")    return;
				if (chkComfirm(formObject)){
					return;                     
				}
				if(!checkWaybillDate(sheetObject2)) return;
				if(sheetObject2.CheckedRows('sel') == 0) {
					ComShowMessage(ComGetMsg("COM12176" ));
					return;
				}
				var myOption="width=900; height=770; help=no; status=no; resizable=no; scroll=no;";
				ComOpenWindow('ESD_TRS_0925.do?mode=apply&sel_sheet_idx=2', 'ESD_TRS_0925', myOption,false);
				break;
			case "t3btng_rowadd":
				if ( formObject.editflag.value == "N")    return;
				if (chkComfirm(formObject)) return;                      
				doActionIBSheet2(sheetObject2,formObject,IBINSERT);     
				break;   
			case "t1btng_save": 
			case "t2btng_save":
			case "t3btng_save":
				if ( formObject.editflag.value == "N")    return false;
				if (chkComfirm(formObject)) return;                 
				if (checkInputData(formObject)) {					
					if ( sheetObjects[0].RowCount()== 0 && sheetObjects[1].RowCount()== 0 && sheetObjects[2].RowCount()== 0  && sheetObjects[3].RowCount() == 0 ){
						ComShowMessage(ComGetMsg("TRS90381"));
						return false;						
					} else {
						doActionIBSheet(sheetObject, formObject, IBSAVE, "SV");      		
					}
				}
				break;
			case "t1btng_confirm":            
			case "t2btng_confirm":
			case "t3btng_confirm": 
				if ( formObject.editflag.value == "N")    {
					return false;
				}
				if (chkComfirm(formObject)) {
					return false;
				}
				if (checkInputData(formObject)) {
					if ( sheetObjects[0].RowCount()== 0 && sheetObjects[1].RowCount() == 0 && sheetObjects[2].RowCount()== 0  && sheetObjects[3].RowCount() == 0 ){
						ComShowMessage(ComGetMsg("TRS90411"));
						return false;
					} else {
						if (checkSheetData()) return false;	
						if( !checkDuplicateSoSeq()) return false;
						if (Number(ComTrimAll(formObject.invoice_amt.value,",")) == Number(formObject.total_amt_for_payment.value)) {
							// Total Amt=Coincidence + Discrepancy + Invoice Only
							doActionIBSheet(sheetObject,formObject,IBSAVE , "CF");    
						} else {                                                      
							ComShowMessage(ComGetMsg("TRS90006"));
							return false;
						}
					}
				}
				break;
			case "t1btng_print":                           
			case "t2btng_print":
			case "t3btng_print": 
				var pTitle = "";
				if (srcName == "t1btng_print")  {
					rdObj[0]=sheetObject;     // Coincidence
					formObject.ptitle.value = "Coincidence";
				} else if (srcName == "t2btng_print") {
					rdObj[0]=sheetObject1;    // Discrepancy 
					formObject.ptitle.value = "Discrepancy";
				} else if(srcName == "t3btng_print") {
					rdObj[0]=sheetObject2;    // Invoice Only 
					formObject.ptitle.value = "Invoice Only ";
				}
				if ( rdObj[0].RowCount() == "0")  {
					ComShowMessage(ComGetMsg("TRS90001"));
					return;
				}
				
				fromObj[0]=formObject;  
				parmObj[0]="1";
				parmObj[1]="";
				parmObj[2]="N";
				parmObj[3]=RD_path+"apps/opus/esd/trs/invoicemanage/railinvoiceaudit/report/ESD_TRS_0926.mrd";
				parmObj[4]=rdObj;
				parmObj[5]=fromObj;
				rdObjModaless(RdReport, parmObj , 1000 ,700);
				break;   
			case "t4btng_downexce": {
				doActionIBSheet2(sheetObject3,formObject,IBDOWNEXCEL);
				break;
			}
			case 'btng_downexcel_1': {
				doActionIBSheet2(sheetObject,formObject,IBDOWNEXCEL);
				break;
			}
			case 'btng_downexcel_2': {
				doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
				break;
			}
			case 'btng_downexcel_3': {
				doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
				break;
			}
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	var formObj=document.form;
	formObj.receive_dt.value = today;
	formObj.issue_dt.value = today;
	
	for(var i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
		tabObjects[k].SetSelectedIndex(0);
	}
	ComEnableObject(document.form.payment_vndr_code, false);
	ComEnableObject(document.form.payment_vndr_name, false);
	ComSetObjValue(document.getElementById("cntr_vndr_svc_cd"),	"RAIL");
 	ComSetObjValue(document.getElementById("vndr_cost_cd"), "TR");
 	ComSetObjValue(document.getElementById("vndr_cnt_cd"), "US,CA");
 	
 	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
 	getRailVendorComboList(rail_road_code , rail_road_codeCode , rail_road_codeText , ''); // Service Provider 
 	initVendorCombo(rail_road_code); 
 	var hidInvNo = formObj.hid_inv_no.value;
 	var hidInvVndrSeq = formObj.hid_inv_vndr_seq.value;

 	if(!ComIsEmpty(hidInvNo) && !ComIsEmpty(hidInvVndrSeq)) {
 	 	setAuditInquiry(hidInvNo, hidInvVndrSeq); 		
 	}
 	formObj.inv_no.focus();
}
/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var flag=false;
	if (sheetNo == 1 ){           // Coincidence 
		 flag=false ;
	} else {                      // Discrepancy 
		 flag=true;
	}
	switch(sheetNo) {
		case 1:   
		case 2: 
		    with(sheetObj){
			      var HeadTitle="Del.|STS||Pay|CNTR No.|TP/SZ|Full\nEmpty|From Node|From Node|To Node|To Node|OPUS\nCurrency|OPUS Fuel\nSurcharge|OPUS HzdMtrl\nSurcharge|OPUS ETC\nSurcharge|OPUS Overweight\nSurcharge|OPUS Total\nAmount";
			      HeadTitle += "|Invoice\nOrigin|Invoice \nDestination|Invoice\nCurrency|Billed \nAmount|Additional \nAmount|Invoice \nAmount";
			      HeadTitle += "|Rail Billing\nDate|Waybill\nDate|Waybill\nNo|COP\nExecuted Time|Outgate Date|Ingate Date|Internal\nRemark|Internal\nRemark|Invoice Remark|Originally|Verify\nResult|Sub Invioce\nSeq";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:7, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ 
			             {Type:"DelCheck",  Hidden:0,  Width:30,    Align:"Center",  ColMerge:1,   SaveName:"dflag",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck: 0 },
			             {Type:"Status",    Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sel",						 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pay_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	TrueValue:"Y", 	FalseValue: "N" },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd1",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd1",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"fuel_scg_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"hzd_mtrl_scg_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"etc_add_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ovr_wgt_scg_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ttl_amt",                    KeyField:0,   CalcLogic:"|bzc_amt|+|fuel_scg_amt|+|hzd_mtrl_scg_amt|+|etc_add_amt|+|ovr_wgt_scg_amt|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_org_nod_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_dest_nod_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_bil_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_etc_add_amt",            KeyField:0,   CalcLogic:"|inv_bzc_amt|-|inv_bil_amt|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_bzc_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rail_bil_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wbl_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wbl_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"wo_exe_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"org_gate_out_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"dest_gate_in_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Image",		Hidden:0,  Width:20,   Align:"Center",	ColMerge:0,   SaveName:"pop_img",				     UpdateEdit:0, InsertEdit:0,   ImgHeight:20,         ImgWidth:19 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"inv_rmk",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"org_trsp_rail_inv_aud_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"result",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sub_inv_seq" },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crnt_trsp_rail_inv_aud_cd" },
			             {Type:"Seq",       Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_seq" },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sub_rail_seq" },
			             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_tp_cd" },
			             {Type:"Text",      Hidden:1,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"org_inv_bzc_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bzc_amt",                    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_co_ind_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
						InitColumns(cols);
						SetEditable(1);
						SetImageList(1, "img/btns_search_g.gif");
						SetColProperty('cgo_tp_cd', {ComboText:"|"+cgo_tp_cdText, ComboCode:"|"+cgo_tp_cdCode} );
						SetColProperty('inv_curr_cd', {ComboText:"|"+inv_curr_cdText, ComboCode:"|"+inv_curr_cdCode} );
						SetColProperty('curr_cd', {ComboText:"|"+inv_curr_cdText, ComboCode:"|"+inv_curr_cdCode} );
			      }
			break;
		case 3:      //sheet 3 init
		    with(sheetObj){
			      var HeadTitle  ="Del.|STS||Pay|CNTR No.|TP/SZ|Full\nEmpty|From Node|From Node|To Node|To Node|OPUS\nCurrency|OPUS Fuel\nSurcharge|OPUS HzdMtrl\nSurcharge|OPUS ETC\nSurcharge";
			      	  HeadTitle +=	"|OPUS Overweight\nSurcharge|OPUS Total\nAmount|Invoice\nOrigin|Invoice \nDestination";
			      	  HeadTitle += "|Invoice\nCurrency|Billed \nAmount|Additional \nAmount|Invoice \nAmount|Rail Billing\nDate|Waybill\nDate|Waybill\nNo|Invoice Remark|Originally|Verify\nResult|Sub Invioce\nSeq";

			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:7, DataRowMerge:1 } );

			      var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);

			      var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dflag",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, HeaderCheck: 0 },
			             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sel" },
			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pay_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd1",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd1",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"fuel_scg_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"hzd_mtrl_scg_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"etc_add_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ovr_wgt_scg_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ttl_amt",                    KeyField:0,   CalcLogic:"|bzc_amt|+|fuel_scg_amt|+|hzd_mtrl_scg_amt|+|etc_add_amt|+|ovr_wgt_scg_amt|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_org_nod_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_dest_nod_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_bil_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_etc_add_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"inv_bzc_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rail_bil_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wbl_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wbl_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"inv_rmk",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"org_trsp_rail_inv_aud_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"result",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sub_inv_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crnt_trsp_rail_inv_aud_cd" },
			             {Type:"Seq",       Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_seq" },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sub_rail_seq" },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_tp_cd" },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"org_inv_bzc_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bzc_amt",                    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_co_ind_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				        InitColumns(cols);
				        SetEditable(1);
						SetColProperty('cgo_tp_cd', {ComboText:"|"+cgo_tp_cdText, ComboCode:"|"+cgo_tp_cdCode} );
						SetColProperty('inv_curr_cd', {ComboText:"|"+inv_curr_cdText, ComboCode:"|"+inv_curr_cdCode} );
						SetColProperty('curr_cd', {ComboText:"|"+inv_curr_cdText, ComboCode:"|"+inv_curr_cdCode} );
						SetSheetHeight(370);
	
			      }
		    break;
		case 4:      //sheet 3 init
            with(sheetObj){
		      var HeadTitle="Del.";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 } ];
		      InitColumns(cols);		
		      SetEditable(0);
		      SetVisible(false);
            }
			break;
		case 5:      //sheet 4 init
		    with(sheetObj){
			      var HeadTitle="eq_seq|eq_no|result|sts";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wbl_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"result",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			       
			      InitColumns(cols);	      
			      SetEditable(1);
			      SetVisible(false);
			      SetSheetHeight(300);
	            }
			break;
		case 6:      //sheet 4 init
		    with(sheetObj){    
	      var HeadTitle="";
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	      var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sheetNo",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"row",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eq_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	       
			      InitColumns(cols);
			      SetEditable(1);
			      SetVisible(false);
	       	}
		    break;
	}
}
/**
 * Invoice Only
 */
function t3sheet1_OnClick(sheetObj, row , col) {
	if( sheetObj.GetCellProperty(row, col, dpDataType)== 6 ) {
		if( sheetObj.ColSaveName(col) == "fm_nod_cd2" ) {
			value=ComTrimAll(sheetObj.GetCellValue(row, "fm_nod_cd1"), " ");
			if( value.length > 0 ) {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
			} else {
				sheetObj.SetCellValue(row, "fm_nod_cd1","",0);
			}
		} else if( sheetObj.ColSaveName(col) == "to_nod_cd2" ) {
			value=ComTrimAll(sheetObj.GetCellValue(row, "to_nod_cd1"), " ");
			if( value.length > 0 ) {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
			} else {
				sheetObj.SetCellValue(row, "to_nod_cd1","",0);
			}
		} 
	}
}
/**
 * Coincidence - Sheet Event 
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 * @returns
 */
function t1sheet1_OnChange(sheetObj, row, col, value) {
	var formObj=document.form;
	var colName=sheetObj.ColSaveName(col);
	switch(colName) {
		case 'inv_bzc_amt':
			if( sheetObj.GetCellValue(row , "pay_flg") == 1 ){
				setTotalAmtForPaymentBySheetChange(row, 0, 0);
			} else {
				setTotalAmtForPaymentBySheetChange(row, 0, 0);
			}
			break;
		case 'pay_flg':
			setTotalAmtForPaymentBySheetChange(row, 0, 0);
			break;
	}
}
/**
 * Discrepancy  - Sheet Event  
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 * @returns
 */
function t2sheet1_OnChange(sheetObj, row, col, value) {
	var formObj=document.form;
	var colName=sheetObj.ColSaveName(col);
	switch(colName){
		case 'inv_bzc_amt':
			if( sheetObj.GetCellValue(row , "pay_flg") == 1 ){
				setTotalAmtForPaymentBySheetChange(0, row, 0);
			}else{
				setTotalAmtForPaymentBySheetChange(0, row, 0);
			}
		break;
		case 'pay_flg':
			setTotalAmtForPaymentBySheetChange(0, row, 0);
		break;
	}
}

/**
 * Invoice Only 
 */
function t3sheet1_OnChange(sheetObj , row , col , value)
{
	var colSaveName=sheetObj.ColSaveName(col);
	if ( colSaveName == "fm_nod_cd1")
	{
		if(value.length != "5")
		{
			errMsg=ComGetMsg("COM12174", "From Node" , "5" );
			ComShowMessage(errMsg);
			sheetObj.SetCellValue(row, "fm_nod_cd1","",0);
			sheetObj.SetCellValue(row, "fm_nod_cd2","",0);
			return;
		} else{
			sheetObj.SetCellValue(row, col,value.toUpperCase(),0);
		}
	} else if (colSaveName == "to_nod_cd1"){
		if(value.length != "5")
		{
			errMsg=ComGetMsg("COM12174", "To Node" , "5" );
			ComShowMessage(errMsg);
			sheetObj.SetCellValue(row, "to_nod_cd1","",0);
			sheetObj.SetCellValue(row, "to_nod_cd2","",0);
			return;
		} else{
			sheetObj.SetCellValue(row, col,value.toUpperCase(),0);
		}
	}
   if( colSaveName == "fm_nod_cd1" || colSaveName == "fm_nod_cd2" || colSaveName == "to_nod_cd1" || colSaveName == "to_nod_cd2")
   {
	   sheetObj.SetCellValue(row , "fm_nod_cd",sheetObj.GetCellValue(row , "fm_nod_cd1")+sheetObj.GetCellValue(row , "fm_nod_cd2"),0);
	   sheetObj.SetCellValue(row , "to_nod_cd",sheetObj.GetCellValue(row , "to_nod_cd1")+sheetObj.GetCellValue(row , "to_nod_cd2"),0);
   }
   switch(colSaveName){
		case 'eq_no':
			findRow=sheetObjects[0].FindText("eq_no" , value , sheetObjects[0].HeaderRows());
			if ( findRow != "-1")
			{
				errMsg=ComGetMsg("TRS90009" , value);
				ComShowMessage(errMsg);
				sheetObj.SetCellValue(row , col,"",0);
				return;
			}
			document.form.cntr_no.value=value;
			document.form.seq.value=row;
			doActionIBSheet2(sheetObjects[2] , document.form , IBROWSEARCH);
		break;
		case 'inv_bzc_amt':
			if( sheetObj.GetCellValue(row , "pay_flg") == 1 ){
				setTotalAmtForPaymentBySheetChange(0, 0, row);
			}else{
				setTotalAmtForPaymentBySheetChange(0, 0, row);
			}
		break;
		case 'pay_flg':
			setTotalAmtForPaymentBySheetChange(0, 0, row);
		break;
	}
}

/**
 * Coincidence Tab IBSheet OnClick Event
 */
function t1sheet1_OnClick(sheetObj, Row, Col, Value)
{
	if(sheetObj.ColSaveName(Col) == "pop_img" && sheetObj.GetCellValue(Row, "cgo_tp_cd") == 'F') {
		var lvbkg=sheetObj.GetCellValue(Row, "bkg_no");
		var lveqno=sheetObj.GetCellValue(Row, "eq_no");
		var lvsono=sheetObj.GetCellValue(Row, "trsp_so_ofc_cty_cd") + sheetObj.GetCellValue(Row, "trsp_so_seq") 
		var url="ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&so_no=" + lvsono + "&inter_rmk_cd=I" + "&rail_chk=Y";
		ComOpenWindowCenter(url, "compopup", 1000, 570, true);
	}
}

/**
 * Discrepancy Tab IBSheet OnClick Event
 */
function t2sheet1_OnClick(sheetObj, Row, Col, Value)
{
	if( sheetObj.ColSaveName(Col) == "chk3" )  {
		if( sheetObj.GetCellValue(Row, "lastchk") == "Y" ) {
			parmOfccd="";
			parmSoseq="";
			parmOfccd=sheetObj.GetCellValue(Row, "trsp_so_ofc_cty_cd");
			parmSoseq=sheetObj.GetCellValue(Row, "trsp_so_seq");
		}
	} else if(sheetObj.ColSaveName(Col) == "pop_img" && sheetObj.GetCellValue(Row, "cgo_tp_cd") == 'F') {
		var lvbkg=sheetObj.GetCellValue(Row, "bkg_no");
		var lveqno=sheetObj.GetCellValue(Row, "eq_no");
		var lvsono=sheetObj.GetCellValue(Row, "trsp_so_ofc_cty_cd") + sheetObj.GetCellValue(Row, "trsp_so_seq") 
		var url="ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&so_no=" + lvsono + "&inter_rmk_cd=I" + "&rail_chk=Y";
		ComOpenWindowCenter(url, "compopup", 1000, 570, true);
	}
}

function doActionIBSheet(sheetObj,formObj,sAction , flag) {
	switch(sAction) {
	   case IBSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH;
 			var sXml=sheetObj.GetSearchData("ESD_TRS_0038GS.do", TrsFrmQryString(formObj));
			var arrXml=sXml.split("|$$|");			
			setEtcData(sheetObj, arrXml);
			break;
	   case IBSAVE:      //Save
			 formObj.f_cmd.value=MODIFY;
			 issue_dt=formObj.issue_dt.value.replace(/\/|\-|\./g , "");
			 receive_dt=formObj.receive_dt.value.replace(/\/|\-|\./g , "");
			 formObj.issue_dt.value=issue_dt;
			 formObj.receive_dt.value=receive_dt;
			 formObj.invoice_amt.value=ComTrimAll(formObj.invoice_amt.value,",");
			 formObj.vat_amt.value=ComTrimAll(formObj.vat_amt.value,",");
			 formObj.total_amt.value=ComTrimAll(formObj.total_amt.value,",");
			 formObj.sts_cd.value=flag;
			 setCntrRailInvAudCd();
			 var SaveStr=sheetObjects[0].GetSaveString(true, true);
			 var SaveStr1=sheetObjects[1].GetSaveString(true, true);
			 var SaveStr2=sheetObjects[2].GetSaveString(true, true);
 			 var sXml=sheetObjects[beforetab].GetSaveData("ESD_TRS_0038GS.do",TrsFrmQryString(formObj)+"&"+SaveStr+"&"+SaveStr1+"&"+SaveStr2);
 			 sheetObjects[4].LoadSaveData(sXml, false);
		   break;
	   case IBROWSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH10;
			sheetObj.DoSearch ("ESD_TRS_0038GS.do", TrsFrmQryString(formObj),{Sync:2});
			ComEtcDataToForm(formObj ,sheetObj);
			var flag = sheetObj.GetEtcData("flag");
			var payment_vndr_code = sheetObj.GetEtcData("payment_vndr_code");
			var payment_vndr_name = sheetObj.GetEtcData("payment_vndr_name");
			var flag=sheetObj.GetEtcData("flag");
			if(!ComIsNull(payment_vndr_code)) {
				formObj.payment_vndr_code.value= payment_vndr_code;
				formObj.payment_vndr_name.value= payment_vndr_name;
				if (flag >  0){
					formObj.inv_no.value="";
					errMsg=ComGetMsg("TRS90126" );
					ComShowMessage(errMsg);
				}
			} else {
				formObj.payment_vndr_code.value= "";
				formObj.payment_vndr_name.value= "";
				formObj.inv_no.value="";
			}
			
			sheetObj.RemoveEtcData();
			break;
		case IBSEARCH_ASYNC01:
			formObj.f_cmd.value=SEARCH;
 	    	var sXml=sheetObj.GetSearchData("ESD_TRS_0999GS.do", FormQueryString(formObj));
	    	rail_road_codeCode=ComGetEtcData(sXml, "rail_vndr_code");
	    	rail_road_codeText=ComGetEtcData(sXml, "rail_vndr_desc");
	    	break;
	}
}
function doActionIBSheet2(sheetObj,formObj,sAction) {
	switch(sAction) {
	   case IBSEARCH:      //Retrieve
			break;
	   case IBINSERT:      //Insert
			var row=sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(row , "org_trsp_rail_inv_aud_cd","I",0);
			sheetObj.SetCellValue(row , "crnt_trsp_rail_inv_aud_cd","I",0);
			sheetObj.SetCellValue(row , "trsp_inv_tp_cd","M",0);
			sheetObj.SetCellValue(row , "inv_curr_cd",formObj.currency.options[formObj.currency.selectedIndex].value,0);
			break;
	   case IBSAVE:      //Save
			break;
	   case IBROWSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH20;
			sheetObj.DoRowSearch ("ESD_TRS_0038GS.do", TrsFrmQryString(formObj));
			if ( sheetObj.GetCellValue( formObj.seq.value , "eq_tpsz_cd") == "") {
				sheetObj.SetCellValue( formObj.seq.value , "eq_no","",0);
			}
			break;
	   case IBDOWNEXCEL:        //Excel upload		
		  if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			} else {
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), SheetDesign:1, Merge:1 });	
			}
		  break;
	}
}
 /**
 * Coincidence
 */
function t1sheet1_OnSaveEnd( sheetObj, code, errmsg) {
	if(code < 0 ) {
		ComShowMessage(errmsg);
		return false;
	} else {
		if ( document.form.sts_cd.value=="CF")	{
			 for(var i=0 ; i < sheetObjects[0].RowCount()+1 ; i++) {
				  sheetObjects[0].SetCellEditable(i , "inv_bzc_amt",0);
			 }
			 for(var i=0 ; i < sheetObjects[1].RowCount()+1 ; i++)  {
				  sheetObjects[1].SetCellEditable(i , "inv_bzc_amt",0);
			 }
			 for(var i=0 ; i < sheetObjects[2].RowCount()+1 ; i++) {
				  sheetObjects[2].SetCellEditable(i , "inv_bzc_amt",0);
			 }
		 } 
		document.form.receive_dt.focus();
		document.form.issue_dt.focus();
		document.form.invoice_amt.focus();
		document.form.vat_amt.focus();
		document.form.vat_amt.blur();
		doActionIBSheet(sheetObjects[0] ,document.form , IBSEARCH );
	}
}

function sheet2_OnSaveEnd(sheetObj, code, errmsg) {
	var formObj=document.form;
	if( code < 0 ) {
		ComShowMessage(errmsg);
	} else {
		if(formObj.f_cmd.value == MODIFY) {
			var msgStr = null;
			if( formObj.sts_cd.value == 'CF'){
				msgStr = 'Confirm';
				formObj.editflag.value = 'N';
				sheetObjects[0].SetEditable(0);
				sheetObjects[1].SetEditable(0);
				sheetObjects[2].SetEditable(0);
				sheetObjects[3].SetEditable(0);
			} else {
				msgStr = 'Save';
			}
			ComShowCodeMessage('COM12116', msgStr);
		}
	}
}

/**
 * Discrepancy Tab IBSheet OnSearchEnd Event
 */
function t2sheet1_OnSearchEnd(sheetObj, code, errmsg) {
	if( code < 0 ) return false;
	document.form.insflag.value="false";       
}

function sheet2_OnSearchEnd(sheetObj, code, errmsg) {
	if ( code < 0 ) return false;
	for ( i=sheetObj.HeaderRows(); i < sheetObj.RowCount()+1 ; i++) {
		findidx=sheetObjects[0].FindText("eq_no" , sheetObj.GetCellValue( i , "eq_no") , sheetObj.HeaderRows());
		if( findidx != "-1") {
			if( sheetObjects[0].SetCellValue( findidx , "wbl_dt")= sheetObj.GetCellValue(i , "wbl_dt")) {
				sheetObjects[0].SetCellValue( findidx , "result",sheetObj.GetCellValue(i , "result"),0);
			}
		}
		findidx=sheetObjects[1].FindText("eq_no" , sheetObj.GetCellValue( i , "eq_no") , sheetObj.HeaderRows());
		if( findidx != "-1") {
		   if( sheetObjects[1].SetCellValue( findidx , "wbl_dt")=sheetObj.GetCellValue(i , "wbl_dt"))
		   {
			   sheetObjects[1].SetCellValue( findidx , "result",sheetObj.GetCellValue(i , "result"),0);
		   }
	   }
	   findidx=sheetObjects[2].FindText("eq_no" , sheetObj.GetCellValue( i , "eq_no") , sheetObj.HeaderRows());
	   if( findidx != "-1") {
		   if( sheetObjects[2].SetCellValue( findidx , "wbl_dt")=sheetObj.GetCellValue(i , "wbl_dt"))
		   {
			   sheetObjects[2].SetCellValue( findidx , "result",sheetObj.GetCellValue(i , "result"),0);
		   }
	   }
	}
}
 /**
 * ETC data
 */
function setEtcData(sheetObj, arrXml) {
	if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
	if (arrXml.length > 2) sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
	if ( sheetObjects[0].GetEtcData('trsp_inv_aud_sts_cd') != "CF"){
		sheetObjects[0].SetEtcData('payment_vndr_code',document.form.payment_vndr_code.value);
	}
	ComEtcDataToForm(document.form ,sheetObj);
	sheetObj.RemoveEtcData();
	document.form.receive_dt.focus();
	document.form.issue_dt.focus();
	document.form.invoice_amt.focus();
	document.form.vat_amt.focus();
	document.form.vat_amt.blur();
}
 /**
 * ETC data : undefined to "" 
 */
function setEtcEmptyCheck(etcData) {
	if ( etcData == "undefined") {
		return "";
	} else {
		return etcData ;
	}
}

function checkInputData(formObject) {
	 if ( ComIsEmpty(formObject.inv_no)) {
		formErrMsg("Invoice No");
		formObject.inv_no.focus();
		return false;
	 }
	 if ( ComIsEmpty(formObject.receive_dt)) {
		formErrMsg("Receive Date");
		formObject.receive_dt.focus();
		return false;
	 }
	 if ( ComIsEmpty(formObject.issue_dt)) {
		formErrMsg("Issus Date");
		formObject.issue_dt.focus();
		return false;
	 }
	 if ( ComIsEmpty(formObject.rail_road_name)) {
		formErrMsg("Rail Road");
		return false;
	 }
	 if ( ComIsEmpty(formObject.invoice_amt)) {
		formErrMsg("Invoice AMT");
		formObject.invoice_amt.focus();
		return false;
	 }
	 if ( ComIsEmpty(formObject.vat_amt)) {
		formErrMsg("V.A.T AMT");
		formObject.vat_amt.focus();
		return false;
	 }
	 return true;
}
 /**
 * sheet 
 */
function checkSheetData(){
	var checkList=sheetObjects[2].FindCheckedRow('pay_flg');
	var checkArray=checkList.split('|');
	
	if(checkList != ''){
		for (var idx=0; idx<checkArray.length; idx++){
			if(ComTrim(sheetObjects[2].GetCellValue( checkArray[idx] , "eq_no")) == "") {
				ComShowMessage(ComGetMsg("COM12120" ,  checkArray[idx] , "CNTR No."));
				sheetObjects[2].SelectCell( checkArray[idx], "eq_no");
				return true;
			}
			if (ComTrim(sheetObjects[2].GetCellValue( checkArray[idx] , "cgo_tp_cd")) == "") {
				ComShowMessage(ComGetMsg("COM12130" ,  sheetObjects[2].GetCellValue(checkArray[idx] , "eq_no") , "Full/Empty"));
				sheetObjects[2].SelectCell( checkArray[idx], "cgo_tp_cd" , true);
				return true;
			 }
			if (ComTrim(sheetObjects[2].GetCellValue( checkArray[idx] , "fm_nod_cd1")) == "") {
				ComShowMessage(ComGetMsg("COM12130" ,  sheetObjects[2].GetCellValue(checkArray[idx] , "eq_no") , "From Node"));
				sheetObjects[2].SelectCell( checkArray[idx], "fm_nod_cd1" , true);
				return true;
			 }
			if (ComTrim(sheetObjects[2].GetCellValue( checkArray[idx] , "to_nod_cd1")) == "") {
				ComShowMessage(ComGetMsg("COM12130" ,  sheetObjects[2].GetCellValue(checkArray[idx] , "eq_no") , "To Node"));
				sheetObjects[2].SelectCell( checkArray[idx], "to_nod_cd1", true);
				return true;
			}
			if (sheetObjects[2].GetCellValue( checkArray[idx] , "inv_bzc_amt") <= 0) {
				ComShowMessage(ComGetMsg("TRS90005" ,  sheetObjects[2].GetCellValue(checkArray[idx] , "eq_no") , "Invoice Amount"));
				sheetObjects[2].SelectCell( checkArray[idx], "inv_bzc_amt", true);
				return true;
			 }
		}
	}
	return false;
}
function chkCntr(sheetObj) {
	var chk_row="" ;
	if(sheetObj.CheckedRows('sel') != "1")  {
		return true;
	} else {
		chk_row=sheetObj.FindCheckedRow('sel');
		document.form.cntr_no.value=sheetObj.GetCellValue(chk_row,'eq_no');
		if (document.form.cntr_no.value == "") {
			return true;
		}
		return false;
	}
}
/**
  * Registering IBTab Object as array
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * Setting Tab 
 * Setting the Items of Tab 
 */
function initTab(tabObj , tabNo) {
	 switch(tabNo) {
		 case 1:
			with (tabObj) {
				var cnt=0 ;
				InsertItem( "Coincidence " , "");
				InsertItem( "Discrepancy " , "");
//				InsertItem( "Invoice Only" , "");
			}
		 break;
	 }
}
/**
  * Event clicking a tab
  * Activating the selected tab 
 */
function tab1_OnChange(tabObj , nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";	
	for(var i = 0; i < objs.length; i++){
		if(i != nItem){
			objs[i].style.display="none";
			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		}
	}
	beforetab=nItem;
	if(nItem == 0) {
		ComResizeSheet(sheetObjects[0], 60);
	} else  {
		ComResizeSheet(sheetObjects[1], 60);
	}
}
function rail_road_code_OnBlur (combo) {
 	var finded=combo.FindItem(combo.GetSelectCode(), 0);
	 if ( document.form.rail_road_name.value ==  combo.GetText(finded,1))  return;
	document.form.rail_road_name.value=combo.GetText(combo.GetSelectCode(), 1);
	searchVendorName(combo);
}
/**
* Rail Road combo 
**/
function rail_road_code_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	if ( ! ComIsEmpty(document.form.editflag) ) return ;
	if ( document.form.rail_road_name.value == newText )  return;
	document.form.rail_road_name.value=comboObj.GetText(newCode,1);
	doActionIBSheet(sheetObjects[0] , document.form , IBROWSEARCH);
}
function searchVendorName(combo) {
	if ( ! ComIsEmpty(document.form.editflag) ) return ;
	var formObject=document.form;
	document.form.rail_road_code.value=combo.GetText(combo.GetSelectCode(),1);
	if ( rail_road_code.GetSelectCode()!= "") {
		  doActionIBSheet(sheetObjects[0] , document.form , IBROWSEARCH);
	} else {
		document.form.payment_vndr_code.value="";
		document.form.payment_vndr_name.value="";
	}
}
function chkComfirm(formObj) {
	 if (formObj.trsp_inv_aud_sts_cd.value == "CF") {
		ComShowMessage(ComGetMsg("TRS90002"));
		return true;
	 }
	 return false;
}
function checkWaybillDate(sheetObj){
	var checkList=sheetObj.FindCheckedRow('sel');
	var checkArray=checkList.split('|');
	for(var k=0; k<checkArray.length; k++){
		if(sheetObj.GetCellValue(checkArray[k], 'wbl_dt').length != 8){
			ComShowCodeMessage('COM12114', 'Waybill Date');
			sheetObj.SelectCell(checkArray[k], 'wbl_dt');
			return false;
		}
	}
	return true;
}
/**
 * Error Msg
 */
 function formErrMsg(checkName) {
	ComShowMessage(ComGetMsg("COM12114", checkName ));
	return ;
 }
/**
 * Calling rep_commodity pop-up
 */
function rep_OnPopupClick()
{
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
*  moveSheetData(mySheet1, mySheet2, 2);
*/
function moveSheetData(fromSheet, toSheet, chkCol) {
	var toRow = toSheet.RowCount();
	for (ir = fromSheet.RowCount(); ir >= 1; ir--) {
		if (fromSheet.GetCellValue(ir, chkCol) == '0') {
			continue;
		}
		toRow = toSheet.DataInsert(toRow);
		for (ic = 0; ic <= fromSheet.LastCol(); ic++) {
			if (fromSheet.ColSaveName(ic) == chkCol)
				continue;
			var colNm = fromSheet.ColSaveName(ic);
			var colValue = fromSheet.GetCellValue(ir, ic);
			if (colNm == "crnt_trsp_rail_inv_aud_cd") {
				toSheet.SetCellValue(toRow, colNm, "C");
			} else if(colNm == 'ibflag') {
				
			} else {
				toSheet.SetCellValue(toRow, colNm, colValue);
			}
		}
//		toSheet.SetRowStatus(toRow, fromSheet.GetRowStatus(ir));
		// Removing from origin
		fromSheet.SetCellValue(ir, "pay_flg", 0);
		fromSheet.RowDelete(ir, false);
		toRow--;
	}
}
 function setAuditInquiry( inv_no , inv_vndr_seq){
	if ( ComIsEmpty(document.form.editflag))    return;
	sheetObjects[0].SetWaitImageVisible(0);
	ComOpenWait(true);
	ComEnableObject(document.form.inv_no, false);
	ComEnableObject(document.form.receive_dt, false);
	ComEnableObject(document.form.issue_dt, false);
	ComEnableObject(document.form.total_amt, false);
	ComEnableObject(document.form.rail_road_name, false);
	ComEnableObject(document.form.currency, false);
	rail_road_code.SetEnable(false);
	document.form.inv_no.value=inv_no;
	document.form.payment_vndr_code.value=inv_vndr_seq;
	rail_road_code.SetItemCheck(inv_vndr_seq,true);

	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	calAmt();
	setTotalAmtForPayment();
	ComOpenWait(false);
	sheetObjects[0].SetWaitImageVisible(1);
 }
/**
 * Calling rep_commodity pop-up : The case selecting one item at pop-up page
 */
function getCOM_ENS_rep(rowArray) {
	var formObj=document.form;
	var comboObj=rail_road_code;
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[0];
		var colArray2=colArray[2];
		var colArray3=colArray[4];
		comboObj.InsertItem(comboObj.GetItemCount(), colArray2+'|'+colArray3, colArray2);
		comboObj.SetSelectText(colArray2);
		document.form.rail_road_name.value=comboObj.GetText(comboObj.GetSelectCode(), 1);
	}
}

function checkDateFormat(dt){
	var date_regexp="^(\\d{4}-\\d{2}-\\d{2})$";
	if (!checkFormat(dt, date_regexp)){
		return false;
	}
	return true;
}	
function BlurDate(obj){
   if (obj.value == "") {
	   return;
   }
   if ( !ComIsDate(obj) ){
		errMsg=ComGetMsg("COM12179");
		ComShowMessage(errMsg);
		obj.focus();
		return ;
	} else {
	   rsdate=addBar(obj.value);
	   obj.value=rsdate;
	}
}

function checkInvoiceName() {
	document.form.inv_no.value=document.form.inv_no.value.toUpperCase()
	if ( ! ComIsEmpty(document.form.editflag) ) {
		return false;
	}
	if ( ComIsEmpty(document.form.inv_no) || rail_road_code.GetSelectCode()== "" ) {
		return;
	} else {
		doActionIBSheet(sheetObjects[0] , document.form , IBROWSEARCH);        // Invoice No + Payment Vndr  check
	}
}
// yyyy-mm-dd
function addBar(dt) {
	var dat="";
	if( dt.length == 8 ) {
		dat=dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	return dat; 
}
function fun_Focus_del(obj)
{
	date=obj.value.replace(/\/|\-|\./g , "");
	obj.value=date;
}
function checkFormat(object, regexp){
	if (object == null || object == ""){
		return false;
	} else {
		re=new RegExp(regexp,"gi"); //'gi' is for case-insensitive global match
		if (!re.test(object)){
			return false;
		}
	}
	return true;
}
function getSaveString(params){
	var saveString=null;
	if(params == null){
		saveString="";
	}else{
		saveString=params.join("&");
	}
	return saveString;
}
function setTotalAmtForPayment(){
	var sheetObj_01=sheetObjects[0];
	var sheetObj_02=sheetObjects[1];
	var sheetObj_03=sheetObjects[2];
	var formObj=document.form;
	var checkList=sheetObj_01.FindCheckedRow('pay_flg');
	var checkArray=checkList.split('|');
	var total_amt=0.00;
	var total_coincidence=0.00;
	var total_discrepancy=0.00;
	var total_invoice_only=0.00;
	
	if(checkList !=""){
		for(var i=0; i < checkArray.length; i++){
			sheetObj_01.SetCellValue(checkArray[i], 'org_inv_bzc_amt',sheetObj_01.GetCellValue(checkArray[i], 'inv_bzc_amt'));
			total_amt += Number(sheetObj_01.GetCellValue(checkArray[i], 'inv_bzc_amt'));
			total_coincidence += Number(sheetObj_01.GetCellValue(checkArray[i], 'inv_bzc_amt'));
		}
	}
	formObj.total_amt_coincidence.value=chkAmtPos(total_coincidence);
	
	checkList=sheetObj_02.FindCheckedRow('pay_flg');
	checkArray=checkList.split('|');
	if(checkList !=""){
		for(var i=0; i<checkArray.length; i++){
			sheetObj_02.SetCellValue(checkArray[i], 'org_inv_bzc_amt',sheetObj_02.GetCellValue(checkArray[i], 'inv_bzc_amt'));
			total_amt += Number(sheetObj_02.GetCellValue(checkArray[i], 'inv_bzc_amt'));
			total_discrepancy += Number(sheetObj_02.GetCellValue(checkArray[i], 'inv_bzc_amt'));
		}
	}
	formObj.total_amt_discrepancy.value=chkAmtPos(total_discrepancy);
	
	checkList=sheetObj_03.FindCheckedRow('pay_flg');
	checkArray=checkList.split('|');
	if(checkList !=""){
		for(var i=0; i<checkArray.length; i++){
			sheetObj_03.SetCellValue(checkArray[i], 'org_inv_bzc_amt',sheetObj_03.GetCellValue(checkArray[i], 'inv_bzc_amt'));
			total_amt += Number(sheetObj_03.GetCellValue(checkArray[i], 'inv_bzc_amt'));
			total_invoice_only += Number(sheetObj_03.GetCellValue(checkArray[i], 'inv_bzc_amt'));
		}
	}
	formObj.total_amt_invoice_only.value=chkAmtPos(total_invoice_only);
	formObj.total_amt_for_payment.value=chkAmtPos(total_amt);
}
function setTotalAmtForPaymentBySheetChange( row1, row2, row3 ){
	var sheetObj_01=sheetObjects[0];
	var sheetObj_02=sheetObjects[1];
	var sheetObj_03=sheetObjects[2];
	var formObj=document.form;
	if( row1 != 0 ){
		if( sheetObj_01.GetCellValue(row1, 'pay_flg') == 1 ){
			if( sheetObj_01.GetCellValue(row1, 'org_inv_bzc_amt') != sheetObj_01.GetCellValue(row1, 'inv_bzc_amt') ){
				formObj.total_amt_coincidence.value=chkAmtPos( Number( formObj.total_amt_coincidence.value ) - Number(sheetObj_01.GetCellValue(row1, 'org_inv_bzc_amt')) );
				sheetObj_01.SetCellValue(row1, 'org_inv_bzc_amt',sheetObj_01.GetCellValue(row1, 'inv_bzc_amt'));
				formObj.total_amt_coincidence.value=chkAmtPos( Number( formObj.total_amt_coincidence.value ) + Number(sheetObj_01.GetCellValue(row1, 'inv_bzc_amt')) );
			}else{
				sheetObj_01.SetCellValue(row1, 'org_inv_bzc_amt',sheetObj_01.GetCellValue(row1, 'inv_bzc_amt'));
				formObj.total_amt_coincidence.value=chkAmtPos( Number( formObj.total_amt_coincidence.value ) + Number(sheetObj_01.GetCellValue(row1, 'inv_bzc_amt')) );
			}
		}else if( sheetObj_01.GetCellValue(row1, 'pay_flg') == 0 ){
			if( sheetObj_01.GetCellValue(row1, 'org_inv_bzc_amt') != sheetObj_01.GetCellValue(row1, 'inv_bzc_amt') ){
				sheetObj_01.SetCellValue(row1, 'org_inv_bzc_amt',sheetObj_01.GetCellValue(row1, 'inv_bzc_amt'));
			}else{
				formObj.total_amt_coincidence.value=chkAmtPos( Number( formObj.total_amt_coincidence.value ) - Number(sheetObj_01.GetCellValue(row1, 'inv_bzc_amt')) );
			}							
		}		
	}
	if( row2 != 0 ){
		if( sheetObj_02.GetCellValue(row2, 'pay_flg') == 1 ){
			if( sheetObj_02.GetCellValue(row2, 'org_inv_bzc_amt') != sheetObj_02.GetCellValue(row2, 'inv_bzc_amt') ){
				formObj.total_amt_discrepancy.value=chkAmtPos( Number( formObj.total_amt_discrepancy.value ) - Number(sheetObj_02.GetCellValue(row2, 'org_inv_bzc_amt')) );
				sheetObj_02.SetCellValue(row2, 'org_inv_bzc_amt',sheetObj_02.GetCellValue(row2, 'inv_bzc_amt'));
				formObj.total_amt_discrepancy.value=chkAmtPos( Number( formObj.total_amt_discrepancy.value ) + Number(sheetObj_02.GetCellValue(row2, 'inv_bzc_amt')) );
			}else{
				sheetObj_02.SetCellValue(row2, 'org_inv_bzc_amt',sheetObj_02.GetCellValue(row2, 'inv_bzc_amt'));
				formObj.total_amt_discrepancy.value=chkAmtPos( Number( formObj.total_amt_discrepancy.value ) + Number(sheetObj_02.GetCellValue(row2, 'inv_bzc_amt')) );
			}
		}else if( sheetObj_02.GetCellValue(row2, 'pay_flg') == 0 ){
			if( sheetObj_02.GetCellValue(row2, 'org_inv_bzc_amt') != sheetObj_02.GetCellValue(row2, 'inv_bzc_amt') ){
				sheetObj_02.SetCellValue(row2, 'org_inv_bzc_amt',sheetObj_02.GetCellValue(row2, 'inv_bzc_amt'));
			}else{
				formObj.total_amt_discrepancy.value=chkAmtPos( Number( formObj.total_amt_discrepancy.value ) - Number(sheetObj_02.GetCellValue(row2, 'inv_bzc_amt')) );
			}							
		}		
	}
	if( row3 != 0 ){
		if( sheetObj_03.GetCellValue(row3, 'pay_flg') == 1 ){
			if( sheetObj_03.GetCellValue(row3, 'org_inv_bzc_amt') != sheetObj_03.GetCellValue(row3, 'inv_bzc_amt') ){
				formObj.total_amt_invoice_only.value=chkAmtPos( Number( formObj.total_amt_invoice_only.value ) - Number(sheetObj_03.GetCellValue(row3, 'org_inv_bzc_amt')) );
				sheetObj_03.SetCellValue(row3, 'org_inv_bzc_amt',sheetObj_03.GetCellValue(row3, 'inv_bzc_amt'));
				formObj.total_amt_invoice_only.value=chkAmtPos( Number( formObj.total_amt_invoice_only.value ) + Number(sheetObj_03.GetCellValue(row3, 'inv_bzc_amt')) );
			}else{
				sheetObj_03.SetCellValue(row3, 'org_inv_bzc_amt',sheetObj_03.GetCellValue(row3, 'inv_bzc_amt'));
				formObj.total_amt_invoice_only.value=chkAmtPos( Number( formObj.total_amt_invoice_only.value ) + Number(sheetObj_03.GetCellValue(row3, 'inv_bzc_amt')) );
			}			
		}else if( sheetObj_03.GetCellValue(row3, 'pay_flg') == 0 ){
			if( sheetObj_03.GetCellValue(row3, 'org_inv_bzc_amt') != sheetObj_03.GetCellValue(row3, 'inv_bzc_amt') ){
				sheetObj_03.SetCellValue(row3, 'org_inv_bzc_amt',sheetObj_03.GetCellValue(row3, 'inv_bzc_amt'));
			}else{
				formObj.total_amt_invoice_only.value=chkAmtPos( Number( formObj.total_amt_invoice_only.value ) - Number(sheetObj_03.GetCellValue(row3, 'inv_bzc_amt')) );
			}			
		}		
	}
	formObj.total_amt_for_payment.value=chkAmtPos( Number(formObj.total_amt_coincidence.value) + Number(formObj.total_amt_discrepancy.value) + Number(formObj.total_amt_invoice_only.value) );
}
function setCntrRailInvAudCd(){
	var sheetObj0=sheetObjects[0];
	var sheetObj1=sheetObjects[1];
	var sheetObj2=sheetObjects[2];
	for(var i=1; i< sheetObj0.RowCount()+1; i++){
		sheetObj0.SetCellValue(i, 'crnt_trsp_rail_inv_aud_cd','C',0);
	}
	for(var i=1; i< sheetObj1.RowCount()+1; i++){
		sheetObj1.SetCellValue(i, 'crnt_trsp_rail_inv_aud_cd','D',0);
	}
	for(var i=1; i< sheetObj2.RowCount()+1; i++){
		sheetObj2.SetCellValue(i, 'crnt_trsp_rail_inv_aud_cd','I',0);
	}
}
function checkDuplicateSoSeq(){
	var sheetObj0=sheetObjects[0];
	var sheetObj1=sheetObjects[1];
	var sheetObj2=sheetObjects[2];
	if(sheetObj0.CheckedRows('pay_flg') == 0  && sheetObj1.CheckedRows('pay_flg') == 0) {
		ComShowCodeMessage('TRS90476');
		return false;
	}
	var checkArray0=sheetObj0.FindCheckedRow('pay_flg').split('|');
	var checkArray1=sheetObj1.FindCheckedRow('pay_flg').split('|');
	var checkArray2=sheetObj2.FindCheckedRow('pay_flg').split('|');
	var queryStr='';
	
	for(var i=0; i < checkArray0.length-1; i++){
		if(sheetObj0.GetCellValue(checkArray0[i], 'trsp_so_seq') != ''){
			queryStr += '&ibflag=R&sheetNo=0';
			queryStr += '&row='+checkArray0[i];
			queryStr += '&eq_no='+sheetObj0.GetCellValue(checkArray0[i], 'eq_no');
			queryStr += '&trsp_so_ofc_cty_cd_seq='+sheetObj0.GetCellValue(checkArray0[i], 'trsp_so_ofc_cty_cd') + sheetObj0.GetCellValue(checkArray0[i], 'trsp_so_seq');
		}
	}
	
	for(var i=0; i < checkArray1.length-1; i++){
		if(sheetObj1.GetCellValue(checkArray1[i], 'trsp_so_seq') != ''){
			queryStr += '&ibflag=R&sheetNo=1';
			queryStr += '&row='+checkArray1[i];
			queryStr += '&eq_no='+sheetObj1.GetCellValue(checkArray1[i], 'eq_no');
			queryStr += '&trsp_so_ofc_cty_cd_seq='+sheetObj1.GetCellValue(checkArray1[i], 'trsp_so_ofc_cty_cd') + sheetObj1.GetCellValue(checkArray1[i], 'trsp_so_seq');
		}
	}
	for(var i=0; i< checkArray2.length-1; i++){
		if(sheetObj2.GetCellValue(checkArray2[i], 'trsp_so_seq') != ''){
			queryStr += '&ibflag=R&sheetNo=2';
			queryStr += '&row='+checkArray2[i];
			queryStr += '&eq_no='+sheetObj2.GetCellValue(checkArray2[i], 'eq_no');
			queryStr += '&trsp_so_ofc_cty_cd_seq='+sheetObj2.GetCellValue(checkArray2[i], 'trsp_so_ofc_cty_cd') + sheetObj2.GetCellValue(checkArray2[i], 'trsp_so_seq');
		}
	}
	if(queryStr != '') {
		sheetObjects[5].RemoveAll();
	 	sheetObjects[5].DoSearch("ESD_TRS_0969.screen", 'a=a'+"&"+queryStr,{Sync:2,Append:true} );
		var searchRow=sheetObjects[5].ColValueDup('trsp_so_ofc_cty_cd_seq');
		if(searchRow != -1){
			var srcRow=sheetObjects[5].GetCellValue(searchRow, 'row');
			ComShowCodeMessage('COM12115', 'SO SEQ')+'['+sheetObjects[5].GetCellValue(searchRow, 'eq_no')+']';
			return false;
		}
	} 
	return true;
}

/**** AMOUNT ****/
function calAmt(){
	var formObj=document.form;
	var invoice_amt=deleteComma(formObj.invoice_amt.value);
	var vat_amt=deleteComma(formObj.vat_amt.value);
	var total_amt=Number(invoice_amt) + Number(vat_amt);
	formObj.invoice_amt.value=chkAmtPos(invoice_amt)
	formObj.vat_amt.value=chkAmtPos(vat_amt);
	formObj.total_amt.value=chkAmtPos(total_amt);
	formObj.invoice_amt.value=ComAddComma(formObj.invoice_amt.value);
	formObj.vat_amt.value=ComAddComma(formObj.vat_amt.value);
	formObj.total_amt.value=ComAddComma(formObj.total_amt.value);        
}

function initAmt(obj) {    
    if(obj.value == '0.00' || obj.value == '0'){
        obj.value='';
        obj.focus();
        return false;
    }
}