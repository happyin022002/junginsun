/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0012.js
*@FileTitle  : Prepayments
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables 
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event*/
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
     var sheetObject1=sheetObjects[0];
     var sheetObject2=sheetObjects[1];
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_execute":
            	doActionIBSheet(sheetObject2,formObject,IBSEARCH);
                break;
            case "btn_delete":
            	if(checkBoxCheckYn(sheetObject2, "inv_DelChk")) {
            		rowRemove(sheetObject2, "inv_");
            	}
                break;
			case "btn_new":					
				if(!initConfirm()) return;
				formObject.pay_hir_no.readOnly = true;					
				clearAll();
			
                break;
			case "btn_save":
				doActionIBSheet(sheetObject2,formObject,IBSAVE);
                break;
			case "btn_delete2":
				doActionIBSheet(sheetObject2,formObject,IBDELETE);
                break;
			case "btn_invoice":
				var vsl_eng_nm=formObject.vsl_eng_nm.value;
				ComOpenPopup("ESM_FMS_0075.do?pgm_id=esm_fms_0012&vsl_eng_nm="+vsl_eng_nm, 650, 150, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0075");
                break;
			case "btn_vslpop" :
				ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0022");
        		break;
			case "contract_no":
				if(formObject.vsl_cd.value == "") {
					ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01138'));
					return;
				}
				//NYK Modify 2014.10.17
				clearAll("CTRT");
				
				ComOpenPopup("ESM_FMS_0023.do?typeFlag=TI|TO&vsl_cd=" + formObject.vsl_cd.value, 520, 415,"setContractNo", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0023");
				 break;
			case "ef_dt": 
				var cal=new ComCalendar();
				cal.select(form.eff_dt, 'yyyy-MM-dd');
			 break;
			case "ex_dt":
				var cal=new ComCalendar();
				cal.select(form.exp_dt, 'yyyy-MM-dd');	
				 break;
        } // end switch
	} catch(e) {
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
 * Registering IBMultiCombo Object generated on Page to comboObject Array <br>
 * @param {ibmulticombo} combo_obj    IBMultiCombo Object
 **/
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=form.pay_hir_no2;                
   //comboObjects[comboCnt++] = combo_obj;
}
/**
 * initializing sheet 
 * implementing onLoad event handler in body tag 
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    /*for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }*/
        initControl();
    }
   
     /**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
 * @return N/A
 * @author 
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetObj.id) {
    	case "sheet1":      //sheet1 init
            with(sheetObj){
	            var prefix="oli_";
	            var HeadTitle="Item Name|From Date|To Date|Cur|Amount";
	            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	            var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:0 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ 
	                 {Type:"Text",      Hidden:0,  Width:700,  Align:"Left",    ColMerge:0,   SaveName:prefix+"acct_itm_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
	                 {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:prefix+"otr_expn_amt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 } ];
	           
	            InitColumns(cols);
	            SetSheetHeight(120);
	            SetEditable(0);
	            //FitColWidth("30|15|15|10|20");
                }
            break;
        case "sheet2":      //t1sheet1 init
            with(sheetObj){
            var prefix="inv_";
             var HeadTitle="|Sel|Seq|Item Name|Account Code|Cur 1|Amount|Cur 2|Amount|Approval|Description|FletCtrtNo|FletIssTpCd|InvSeq|InvDtlSeq|AcctItmSeq|Ori Amount|Ori Amount2|Inv Usd Dys|Sort Key|Fir Amount|Fir Amount2||||";
             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);
             var cols = [ 
                 {Type:"Status",     Hidden:1, Width:30,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                 {Type:"DummyCheck", Hidden:0, Width:40,  Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
                 {Type:"Seq",       Hidden:0, Width:33,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
                 {Type:"Text",      Hidden:0, Width:220,  Align:"Left",    ColMerge:0,   SaveName:prefix+"acct_itm_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:93,   Align:"Center",  ColMerge:0,   SaveName:prefix+"acct_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0, Width:99,   Align:"Right",   ColMerge:0,   SaveName:prefix+"inv_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0, Width:99,   Align:"Right",   ColMerge:0,   SaveName:prefix+"inv_amt2",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slp_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"inv_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:prefix+"flet_ctrt_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:prefix+"flet_iss_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_dtl_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:prefix+"acct_itm_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Right",   ColMerge:0,   SaveName:prefix+"ori_inv_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Right",   ColMerge:0,   SaveName:prefix+"ori_inv_amt2",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_usd_dys",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sort_key",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Right",   ColMerge:0,   SaveName:prefix+"fir_inv_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Right",   ColMerge:0,   SaveName:prefix+"fir_inv_amt2",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                 
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Right",   ColMerge:0,   SaveName:prefix+"ori_inv_desc",   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Right",   ColMerge:0,   SaveName:prefix+"eff_dt",   	  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,   Align:"Right",   ColMerge:0,   SaveName:prefix+"exp_dt",   	  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
             InitColumns(cols);
//	             SetSheetHeight(160);
             resizeSheet();
             SetEditable(1);
          }
        break;
    }
}
/**
 * Handling IBSheet's process(Retrieve, Save) <br>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {form}    formObj Mandatory html form object
 * @param {int}     sAction mandatory,Constant Variable
 * @param {String}  gubun     	gubun value
 **/  
function doActionIBSheet(sheetObj,formObj,sAction,kind) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
    	case IBSEARCH:      
    		if(!validateForm(sheetObj,formObj,sAction))  return true;
    	   	if(formObj.flet_ctrt_no.value == "") {
    	   		ComAlertFocus(formObj.flet_ctrt_no, ComGetMsg('FMS01052'));
    	   		return;
       		} 
    	   	if(formObj.condition[0].checked) {
    	   		if( formObj.pay_hir_no.value == "" || parseInt(formObj.pay_hir_no.value) == 0) {        	   			
    	   				formObj.pay_hir_no.value="";        	   	
         	   		formObj.pay_hir_no.value = "";    			
         	   		ComAlertFocus(formObj.pay_hir_no, ComGetMsg('FMS01183'));
                	//----------------------------------------             	   		
         	   		return;
             	} else {
             		formObj.pay_hir_no.readOnly=true;                 		
             	}
    	   		document.all.btn_delete2.style.display="none";
    	   		declaration_click();
    	   		formObj.f_cmd.value=SEARCH;
    	   		var aryPrefix=new Array("inv_", "");
    	   	} else {
    	   		formObj.chk_pay_hir_no.value=pay_hir_no2.GetSelectText();        	   		
    	   		if(pay_hir_no2.GetSelectText()== "") {
    	   			ComShowCodeMessage("FMS01183");
    	   			return;
    	   		}
    	   		if(!ComIsNumber(formObj.chk_pay_hir_no)) {
    	   			ComShowCodeMessage("FMS01184");
    	   			return;
    	   		}
     	   		var itemIndex=pay_hir_no2.FindItem(pay_hir_no2.GetSelectText(), 0);
    	   		if(itemIndex == -1) {
    	   			ComShowCodeMessage("FMS01185");
    	   			return;
    	   		}
    	   		formObj.f_cmd.value=SEARCH01;
    	   		var aryPrefix=new Array("oli_", "inv_", "");
    	   	}
     	   	var sXml=sheetObj.GetSearchData("ESM_FMS_0012GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");
			if(formObj.condition[0].checked) {
				if (arrXml.length > 0) {	
					var varChkDurationFlg = ComGetEtcData(arrXml[0], "CHK_FLG");
		   			
		   			if(typeof varChkDurationFlg != "undefined" && varChkDurationFlg != "" && varChkDurationFlg == "N") {
		   				if(CoFmsShowXmlMessage(arrXml[0]) != "") {
		   					ComShowMessage(CoFmsShowXmlMessage(arrXml[0]));
		   				}
		   				return;
					}else{
						
						sheetObjects[1].LoadSearchData(arrXml[0],{Sync:2} );
						   
						var list=ComFmsSheetXml2ListMap(arrXml[1]);
						var totalAmtHtml=ComFmsMakeTotalAmtHtml(list);
						var arrTotalAmtHtml=totalAmtHtml.split("|$$|");
						if (arrTotalAmtHtml.length > 0) {
							document.all.totalAmount.style.display="";
							document.all.totalAmount1.innerHTML=arrTotalAmtHtml[0];
							document.all.totalAmount2.innerHTML=arrTotalAmtHtml[1];
						}
					}
				}
			} 
			else {
    			if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:2} );
    			if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:2} );
    			
//	    			ComEtcDataToForm2(formObj,sheetObjects[0],"hir_",true);
//	    			ComEtcDataToForm2(formObj,sheetObjects[0],"",true);
    			
    			formObj.flet_ctrt_no.value = ComGetEtcData(arrXml[0],"fletCtrtNo");
    			formObj.vsl_cd.value = ComGetEtcData(arrXml[0],"vslCd");
    			formObj.vsl_eng_nm.value = ComGetEtcData(arrXml[0],"vslEngNm");
    			formObj.flet_ctrt_tp_cd.value = ComGetEtcData(arrXml[0],"fletCtrtTpCd");		    			
    			formObj.cust_cnt_cd.value = ComGetEtcData(arrXml[0],"custCntCd");
    			formObj.cust_seq.value = ComGetEtcData(arrXml[0],"custSeq");
    			formObj.vndr_lgl_eng_nm.value = ComGetEtcData(arrXml[0],"vndrLglEngNm");
    			formObj.ownr_nm.value = ComGetEtcData(arrXml[0],"ownrNm");
				formObj.eff_dt.value = ComGetEtcData(arrXml[0],"effDt");
				formObj.from_time.value = ComGetEtcData(arrXml[0],"fromTime");
				formObj.exp_dt.value = ComGetEtcData(arrXml[0],"expDt");
				formObj.to_time.value = ComGetEtcData(arrXml[0],"toTime");
				formObj.inv_usd_dys.value = ComGetEtcData(arrXml[0],"invUsdDys");
    			formObj.acmm_rt_amt.value = ComGetEtcData(arrXml[0],"acmmRtAmt");		    			
    			formObj.flet_brog_rt_amt.value = ComGetEtcData(arrXml[0],"fletBrogRtAmt");
    			formObj.acmm_flg.value = ComGetEtcData(arrXml[0],"acmmFlg");
    			formObj.brog_flg.value = ComGetEtcData(arrXml[0],"brogFlg");
				formObj.inv_seq.value = ComGetEtcData(arrXml[0],"invSeq");
//					formObj.pay_hir_no.value = ComGetEtcData(arrXml[0],"payHirNo");													
				formObj.hir_eff_dt.value = ComGetEtcData(arrXml[0],"hirEffDt");
				formObj.hir_eff_dt_time.value = ComGetEtcData(arrXml[0],"hirEffDtTime");
				formObj.hir_exp_dt.value = ComGetEtcData(arrXml[0],"hirExpDt");
				formObj.hir_exp_dt_time.value = ComGetEtcData(arrXml[0],"hirExpDtTime");
				formObj.hir_hir_curr_n1st_cd.value = ComGetEtcData(arrXml[0],"hirHirCurrN1stCd");
				formObj.hir_hir_rt_n1st_amt.value = ComGetEtcData(arrXml[0],"hirHirRtN1stAmt");
				formObj.hir_hir_curr_n2nd_cd.value = ComGetEtcData(arrXml[0],"hirHirCurrN2ndCd");
				formObj.hir_hir_rt_n2nd_amt.value = ComGetEtcData(arrXml[0],"hirHirRtN2ndAmt");			    			
    			
    			if(typeof sheetObjects[0].GetEtcData("acmmFlg") != "undefined") {
    				if(sheetObjects[0].GetEtcData("acmmFlg") == "Y") {
    					formObj.acmm_flg.checked=true;
    				} else {
    					formObj.acmm_flg.checked=false;
    				}
    			}
    			if(typeof sheetObjects[0].GetEtcData("brogFlg") != "undefined") {
    				if(sheetObjects[0].GetEtcData("brogFlg") == "Y") {
    					formObj.brog_flg.checked=true;
    				} else {
    					formObj.brog_flg.checked=false;
    				}
    			}
    			if (arrXml.length > 0) {		
					sheetObjects[1].LoadSearchData(arrXml[1],{Sync:2} );   
					var list=ComFmsSheetXml2ListMap(arrXml[2]);	
					var totalAmtHtml=ComFmsMakeTotalAmtHtml(list);
					var arrTotalAmtHtml=totalAmtHtml.split("|$$|");
					if (arrTotalAmtHtml.length > 0) {
						document.all.totalAmount.style.display="";
						document.all.totalAmount1.innerHTML=arrTotalAmtHtml[0];
						document.all.totalAmount2.innerHTML=arrTotalAmtHtml[1];
					}						
				}
    			setHireInvoiceBtn();
			}
			setContractNoBtn();
			setDurationReadOnly();
			//controlScrollBar();
            break;
		 case IBSAVE:       
		 	 var  rowCount =0;
	    	 for(var ir=1; ir<=sheetObj.LastRow(); ir++) {
			     if(sheetObj.GetRowHidden(ir)==false) {
				     rowCount=1;
					 break;
				 }
			 }
	    	 if(rowCount==0){
	    		 rowCount = sheetObj.RowCount("D");
			 }
	    	 if(rowCount== 0) {
	    		 ComShowCodeMessage("FMS00007");
	    		 return;
	    	 }
			 if(!validateForm(sheetObj,formObj,sAction))  return true;
	 		 
			 if(formObj.condition[0].checked) {
				 formObj.f_cmd.value=MULTI;
				 if(formObj.ibflag.value == "I") {
					 for (var ir=1; ir<=sheetObj.LastRow(); ir++){
						 if(sheetObjects[1].GetRowStatus(ir) == "D") continue;
						 sheetObjects[1].SetRowStatus(ir,"I");
					 }
				 }
			 } else {
				formObj.f_cmd.value=MULTI01;
				formObj.ibflag.value="U";
			 }
			 var arrSheets=new Array(sheetObjects[1]);
			 var sParam=ComGetSaveString(arrSheets);
			 if (sParam == "") return;
			 if(formObj.condition[0].checked) {
				 var aryPrefix=new Array("oli_", "inv_", "");
    	   	 } else {
    	   		 var aryPrefix=new Array("inv_", "");
    	   	 }
			 sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
			 var sXml=sheetObj.GetSaveData("ESM_FMS_0012GS.do", sParam);
			 var arrXml=sXml.split("|$$|");
			 if(formObj.condition[0].checked) {
				 //UI개선(201408 민정호)					 
				 //if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				 //if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );

				 if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0]);
				 if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1]);

				 //ComEtcDataToForm2(formObj,sheetObjects[0],"hir_",true);
				 //ComEtcDataToForm2(formObj,sheetObjects[0],"",true);
				 
				//UI개선(201408 민정호) 
    			formObj.flet_ctrt_no.value = ComGetEtcData(arrXml[0],"fletCtrtNo");
    			formObj.vsl_cd.value = ComGetEtcData(arrXml[0],"vslCd");
    			formObj.vsl_eng_nm.value = ComGetEtcData(arrXml[0],"vslEngNm");
    			formObj.flet_ctrt_tp_cd.value = ComGetEtcData(arrXml[0],"fletCtrtTpCd");		    			
    			formObj.cust_cnt_cd.value = ComGetEtcData(arrXml[0],"custCntCd");
    			formObj.cust_seq.value = ComGetEtcData(arrXml[0],"custSeq");
    			formObj.vndr_lgl_eng_nm.value = ComGetEtcData(arrXml[0],"vndrLglEngNm");
    			formObj.ownr_nm.value = ComGetEtcData(arrXml[0],"ownrNm");
				formObj.eff_dt.value = ComGetEtcData(arrXml[0],"effDt");
				formObj.from_time.value = ComGetEtcData(arrXml[0],"fromTime");
				formObj.exp_dt.value = ComGetEtcData(arrXml[0],"expDt");
				formObj.to_time.value = ComGetEtcData(arrXml[0],"toTime");
				formObj.inv_usd_dys.value = ComGetEtcData(arrXml[0],"invUsdDys");
    			formObj.acmm_rt_amt.value = ComGetEtcData(arrXml[0],"acmmRtAmt");		    			
    			formObj.flet_brog_rt_amt.value = ComGetEtcData(arrXml[0],"fletBrogRtAmt");
    			formObj.acmm_flg.value = ComGetEtcData(arrXml[0],"acmmFlg");
    			formObj.brog_flg.value = ComGetEtcData(arrXml[0],"brogFlg");
				formObj.inv_seq.value = ComGetEtcData(arrXml[0],"invSeq");
				//formObj.pay_hir_no.value = ComGetEtcData(arrXml[0],"payHirNo");													
				formObj.hir_eff_dt.value = ComGetEtcData(arrXml[0],"hirEffDt");
				formObj.hir_eff_dt_time.value = ComGetEtcData(arrXml[0],"hirEffDtTime");
				formObj.hir_exp_dt.value = ComGetEtcData(arrXml[0],"hirExpDt");
				formObj.hir_exp_dt_time.value = ComGetEtcData(arrXml[0],"hirExpDtTime");
				formObj.hir_hir_curr_n1st_cd.value = ComGetEtcData(arrXml[0],"hirHirCurrN1stCd");
				formObj.hir_hir_rt_n1st_amt.value = ComGetEtcData(arrXml[0],"hirHirRtN1stAmt");
				formObj.hir_hir_curr_n2nd_cd.value = ComGetEtcData(arrXml[0],"hirHirCurrN2ndCd");
				formObj.hir_hir_rt_n2nd_amt.value = ComGetEtcData(arrXml[0],"hirHirRtN2ndAmt");						 
				
				//if(typeof sheetObjects[0].EtcData("payHirNo") != "undefined") {
				//	var comboText = sheetObjects[0].EtcData("payHirNo");
				//	
				// 	setCombo(pay_hir_no2, 1, comboText);
				//}
				 if(typeof ComGetEtcData(arrXml[0],"invSeq") != "undefined") {
					 formObj.inv_seq.value=ComGetEtcData(arrXml[0],"invSeq");
				 }
				 if(typeof ComGetEtcData(arrXml[0],"acmmFlg") != "undefined") {
					 if(ComGetEtcData(arrXml[0],"acmmFlg") == "Y") {
						 formObj.acmm_flg.checked=true;
					 } else {
						 formObj.acmm_flg.checked=false;
					 }
				 }
				 if(typeof ComGetEtcData(arrXml[0],"brogFlg") != "undefined") {
					 if(ComGetEtcData(arrXml[0],"brogFlg")== "Y") {
						 formObj.brog_flg.checked=true;
					 } else {
						 formObj.brog_flg.checked=false;
					 }
				 }
				 if (arrXml.length > 0) {		
						// UI 개발(101308 민정호)  
    					var list=ComFmsSheetXml2ListMap(arrXml[2]);	
    					var totalAmtHtml=ComFmsMakeTotalAmtHtml(list);
						var arrTotalAmtHtml=totalAmtHtml.split("|$$|");
						if (arrTotalAmtHtml.length > 0) {
							document.all.totalAmount.style.display="";
							document.all.totalAmount1.innerHTML=arrTotalAmtHtml[0];
							document.all.totalAmount2.innerHTML=arrTotalAmtHtml[1];
						}						 
    				}
			 } else {
				 if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
			 }

			 if(formObj.condition[0].checked) {
				 formObj.condition[0].checked=false;
				 formObj.condition[1].checked=true;
				 setHireInvoiceBtn();
			 }
			 
			 //무조건 Inquiry 조건으로 셋팅한다.
			 setConditonBtnText("I");				 
			 				 				 
			 if(formObj.condition[1].checked) {
				 //UI개선(201408 민정호)
				 //if(typeof sheetObjects[0].GetEtcData("payHirNo") != "undefined") {
				 //		var comboText=sheetObjects[0].GetEtcData("payHirNo");
				 //		setCombo(pay_hir_no2, 1, comboText);
				 //}
				 					 										 
				 if(typeof ComGetEtcData(arrXml[0],"payHirNo") != "undefined") {
					 var comboText=ComGetEtcData(arrXml[0],"payHirNo");
					 setCombo(pay_hir_no2, 1, comboText);
				 }					 
				 formObj.eff_dt.readOnly=true;
				 formObj.from_time.readOnly=true;
				 formObj.exp_dt.readOnly=true;
				 formObj.to_time.readOnly=true;
				 formObj.acmm_flg.disabled=true;
				 formObj.brog_flg.disabled=true;
				 formObj.ef_dt.style.cursor="default";
				 formObj.ex_dt.style.cursor="default";
				 //document.images["ef_dt"].name="no_ef_dt";
				 //document.images["ex_dt"].name="no_ex_dt";
				
				 document.all.c_ppay_hir_no.style.display="none";
				 document.all.i_ppay_hir_no.style.display="";
	         }
			 if(document.all.btn_delete2.style.display == "none") {
				 document.all.btn_delete2.style.display="";
			 }
			 
			 //Inquiry 후 저장시 재조회한다.
			 if(MULTI01 == formObj.f_cmd.value){
				 doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);
			 }
			 break;	 
		 case IBROWSEARCH:      
	        	if(kind == "Vessel") {
	        		sheetObj.SetWaitImageVisible(0);
	        		if(formObj.vsl_cd.value == "") {
			    		formObj.vsl_eng_nm.value="";
			    		return;
			    	}
	        		formObj.f_cmd.value=SEARCH01;
		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
						formObj.vsl_eng_nm.value=vslEngNm;
						formObj.vsl_cd.readOnly=true;
		   				formObj.btn_vslpop.style.cursor="default";
//			   				document.images["btn_vslpop"].name="no_btn_vslpop";
		   				document.getElementById("btn_vslpop").name = "no_btn_vslpop";
		   				
			   		    initDefaultContractNo();//NYK Modify 2014.10.16
					} else {
						formObj.vsl_cd.value="";
						formObj.vsl_eng_nm.value="";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01056'));
						return;
					}
		   			sheetObj.SetWaitImageVisible(1);
	        	} else if(kind == "Contract") {		        		
	        		sheetObj.SetWaitImageVisible(0);
	        		if(formObj.flet_ctrt_no.value == "") return;
	        		if(form.condition[0].checked) {
				    	formObj.f_cmd.value=SEARCH01;
				    	var aryPrefix=new Array("oli_");
		        	   	var sXml=sheetObj.GetSearchData("ESM_FMS_0001GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
		    			var arrXml=sXml.split("|$$|");
		    					    						    			
		    			//if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		    			if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0] );
		    			
		    			// UI개선(201408 민정호)	
//			    			ComEtcDataToForm2(formObj,sheetObjects[0],"hir_",true);
//			    			ComEtcDataToForm2(formObj,sheetObjects[0],"",true);
						/*
						<SHEET>
						<ETC-DATA>
						<ETC KEY='fletCtrtNo'><![CDATA[FOS7TI201408005]]></ETC>
						<ETC KEY='vslCd'><![CDATA[FOS7]]></ETC>
						<ETC KEY='vslEngNm'><![CDATA[Five Ocean Shipping 7 USNYC-ESVLC]]></ETC>
						<ETC KEY='fletCtrtTpCd'><![CDATA[T/C In]]></ETC>
						<ETC KEY='custCntCd'><![CDATA[]]></ETC>
						<ETC KEY='custSeq'><![CDATA[802555]]></ETC>
						<ETC KEY='vndrLglEngNm'><![CDATA[FOS Vendor YANTIAN,GUANGDONG]]></ETC>
						<ETC KEY='ownrNm'><![CDATA[Maersk]]></ETC>
						<ETC KEY='effDt'><![CDATA[2014-08-01]]></ETC>
						<ETC KEY='fromTime'><![CDATA[00:00]]></ETC>
						<ETC KEY='expDt'><![CDATA[2014-08-16]]></ETC>
						<ETC KEY='toTime'><![CDATA[00:00]]></ETC>
						<ETC KEY='invUsdDys'><![CDATA[15.0000]]></ETC>
						<ETC KEY='acmmRtAmt'><![CDATA[]]></ETC>
						<ETC KEY='fletBrogRtAmt'><![CDATA[]]></ETC>
						<ETC KEY='acmmFlg'><![CDATA[N]]></ETC>
						<ETC KEY='brogFlg'><![CDATA[N]]></ETC>
						<ETC KEY='invSeq'><![CDATA[]]></ETC>
						<ETC KEY='payHirNo'><![CDATA[1]]></ETC>
						<ETC KEY='hirEffDt'><![CDATA[2014-08-01]]></ETC>
						<ETC KEY='hirEffDtTime'><![CDATA[00:00]]></ETC>
						<ETC KEY='hirExpDt'><![CDATA[2015-08-31]]></ETC>
						<ETC KEY='hirExpDtTime'><![CDATA[00:00]]></ETC>
						<ETC KEY='hirHirCurrN1stCd'><![CDATA[USD]]></ETC>
						<ETC KEY='hirHirRtN1stAmt'><![CDATA[13,000.00]]></ETC>
						<ETC KEY='hirHirCurrN2ndCd'><![CDATA[]]></ETC>
						<ETC KEY='hirHirRtN2ndAmt'><![CDATA[]]></ETC>
						<ETC KEY='TRANS_RESULT_KEY'><![CDATA[S]]></ETC>
						<ETC KEY='Exception'><![CDATA[]]></ETC>
						</ETC-DATA>
							<DATA  TOTAL='0'>
							</DATA>
						</SHEET>
						 */					    			
		    			formObj.flet_ctrt_no.value = ComGetEtcData(arrXml[0],"fletCtrtNo");
		    			formObj.vsl_cd.value = ComGetEtcData(arrXml[0],"vslCd");
		    			formObj.vsl_eng_nm.value = ComGetEtcData(arrXml[0],"vslEngNm");
		    			formObj.flet_ctrt_tp_cd.value = ComGetEtcData(arrXml[0],"fletCtrtTpCd");		    			
		    			formObj.cust_cnt_cd.value = ComGetEtcData(arrXml[0],"custCntCd");
		    			formObj.cust_seq.value = ComGetEtcData(arrXml[0],"custSeq");
		    			formObj.vndr_lgl_eng_nm.value = ComGetEtcData(arrXml[0],"vndrLglEngNm");
		    			formObj.ownr_nm.value = ComGetEtcData(arrXml[0],"ownrNm");
						formObj.eff_dt.value = ComGetEtcData(arrXml[0],"effDt");
						formObj.from_time.value = ComGetEtcData(arrXml[0],"fromTime");
						formObj.exp_dt.value = ComGetEtcData(arrXml[0],"expDt");
						formObj.to_time.value = ComGetEtcData(arrXml[0],"toTime");
						formObj.inv_usd_dys.value = ComGetEtcData(arrXml[0],"invUsdDys");
		    			formObj.acmm_rt_amt.value = ComGetEtcData(arrXml[0],"acmmRtAmt");		    			
		    			formObj.flet_brog_rt_amt.value = ComGetEtcData(arrXml[0],"fletBrogRtAmt");
		    			formObj.acmm_flg.value = ComGetEtcData(arrXml[0],"acmmFlg");
		    			formObj.brog_flg.value = ComGetEtcData(arrXml[0],"brogFlg");
						formObj.inv_seq.value = ComGetEtcData(arrXml[0],"invSeq");
						formObj.pay_hir_no.value = ComGetEtcData(arrXml[0],"payHirNo");													
						formObj.hir_eff_dt.value = ComGetEtcData(arrXml[0],"hirEffDt");
						formObj.hir_eff_dt_time.value = ComGetEtcData(arrXml[0],"hirEffDtTime");
						formObj.hir_exp_dt.value = ComGetEtcData(arrXml[0],"hirExpDt");
						formObj.hir_exp_dt_time.value = ComGetEtcData(arrXml[0],"hirExpDtTime");
						formObj.hir_hir_curr_n1st_cd.value = ComGetEtcData(arrXml[0],"hirHirCurrN1stCd");
						formObj.hir_hir_rt_n1st_amt.value = ComGetEtcData(arrXml[0],"hirHirRtN1stAmt");
						formObj.hir_hir_curr_n2nd_cd.value = ComGetEtcData(arrXml[0],"hirHirCurrN2ndCd");
						formObj.hir_hir_rt_n2nd_amt.value = ComGetEtcData(arrXml[0],"hirHirRtN2ndAmt");									
		    			//-----------------------------------------------------------------------------------------------------------------		    			
		    			
		    			if(typeof ComGetEtcData(arrXml[0],"acmmFlg") != "undefined") {
							 if(ComGetEtcData(arrXml[0],"acmmFlg") == "Y") {
								 formObj.acmm_flg.checked=true;
							 } else {
								 formObj.acmm_flg.checked=false;
							 }
						 }
						 if(typeof ComGetEtcData(arrXml[0],"brogFlg") != "undefined") {
							 if(ComGetEtcData(arrXml[0],"brogFlg") == "Y") {
								 formObj.brog_flg.checked=true;
							 } else {
								 formObj.brog_flg.checked=false;
							 }
						 }
		    			if(formObj.vsl_cd.value == "" || formObj.vsl_cd.value == "undefined") {
		    				ComShowMessage(ComGetMsg('FMS01165'));
		    				clearAll();
		    				return;
	    				} else if(formObj.inv_usd_dys.value == "" || formObj.inv_usd_dys.value == "undefined") {
	    					ComShowMessage(ComGetMsg('FMS01166'));
		    				clearAll("CTRT");//NYK Modify 2014.10.17
		    				return;
	    				}
		    			formObj.ibflag.value="I";
		    			formObj.ori_eff_dt.value=formObj.eff_dt.value.trimAll("-") + formObj.from_time.value.trimAll(":");
		    			formObj.ori_exp_dt.value=formObj.exp_dt.value.trimAll("-") + formObj.to_time.value.trimAll(":");
		    			formObj.ori_inv_usd_dys.value=formObj.inv_usd_dys.value;
		    			var fletCtrtTpCd="";
		    			if(formObj.flet_ctrt_tp_cd.value == "T/C In") {
		    				fletCtrtTpCd="TI";
		    			} else {
		    				fletCtrtTpCd="TO";
		    			}
		    			formObj.flet_ctrt_tp_gb.value=fletCtrtTpCd;
		    			formObj.pay_hir_no.readOnly=false;			    			
		    			sheetObj.SetWaitImageVisible(1);
	        		} else {
	        			sheetObj.SetWaitImageVisible(0);
	        			formObj.f_cmd.value=SEARCH06;
	        			var sXml=sheetObj.GetSearchData("ESM_FMS_0001GS.do" , FormQueryString(formObj));
		    			var arrXml=sXml.split("|$$|");
//			    			if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		    			if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0]);			    			
		    						    			
		    			if(   typeof ComGetEtcData(arrXml[0],"payHirNo") != "undefined"
		    			   && ComGetEtcData(arrXml[0],"payHirNo") != "") {
		    				var comboText=ComGetEtcData(arrXml[0],"payHirNo");
		    				setCombo(pay_hir_no2, 1, comboText);
		    			} else {
		    				ComShowMessage(ComGetMsg('FMS01168'));
		    				clearAll("CTRT");//NYK Modify 2014.10.17
		    				return;
		    			}
		    			if(   typeof ComGetEtcData(arrXml[0],"fletCtrtTpCd") != "undefined"
		    			   && ComGetEtcData(arrXml[0],"fletCtrtTpCd") != "") {
		    				formObj.flet_ctrt_tp_gb.value=ComGetEtcData(arrXml[0],"fletCtrtTpCd");
		    			}
		    			sheetObj.SetWaitImageVisible(1);
	        		}
	        	} else if(kind == "HireNo") {
	        		if(   formObj.pay_hir_no.value == ""		        		
	         	   	   || parseInt(formObj.pay_hir_no.value) == 0) {
	         	   		formObj.pay_hir_no.value="";
	         	   		return;
	             	}
	        		formObj.ppay_hir_no.value=formObj.pay_hir_no.value;
//-----------------------------------------------
	        		
	        		formObj.f_cmd.value=SEARCH02;
		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0012GS.do" , FormQueryString(formObj));
		   			var hireNo=ComGetEtcData(sXml, "hireNo");
		   			if(hireNo == "Y" ) {
		   				formObj.pay_hir_no.value="";
		   				formObj.ppay_hir_no.value="";
		   				ComAlertFocus(formObj.pay_hir_no, ComGetMsg('FMS01188'));
					}
	        	}
	   			break;
		case IBINSERT:     
            break;
		case IBDELETE:      
			if(!validateForm(sheetObj,formObj,sAction,"Y"))  return true;
			if(!delConfirm()) return;
			formObj.f_cmd.value=REMOVE;
			formObj.ibflag.value="D";
			var sFormParam=FormQueryString(formObj);
			var sParam=sFormParam;
			var sXml=sheetObj.GetSaveData("ESM_FMS_0012GS.do", sParam);
			sheetObj.LoadSaveData(sXml);
			//화면 초기화
			clearAll("DEL");
            break;
        	
		case IBSEARCH_ASYNC02: //NYK Modify 2014.10.16				
			if(formObj.vsl_cd.value == "") return;				
			var f_query = "";					
			f_query += "f_cmd=" + SEARCH01; 
			f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
			f_query += "&type_flag="+gFletCtrtTpCdAll;
			
			if(formObj.condition[0].checked) {//Creation	 			
				f_query += "&cond_flag=Y";
			}
			
			var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
   			
   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
				formObj.flet_ctrt_no.value = varFletCtrtNo;
			}else{
				ComShowCodeMessage("FMS20001","Agreement");
				clearAll();
				return;
			}
			if(formObj.flet_ctrt_no.value != ""){
				contract_no_change();
			}
			break;
    }
}
/**
 * Loading Event of HTML_Control existing on page dynamically <br>
 * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence of sheetObjects array
 **/
function initControl() {
	DATE_SEPARATOR="-";
    axon_event.addListener  ('click', 'declaration_click', 'acmm_flg', 'brog_flg');    	//Whether Check declaration
    //axon_event.addListener  ('keypress', 'eng_keypress', 'cust_cnt_cd', 'vsl_cnt_cd', 'oa_rsv_curr_cd');
    //axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd'); //- Input only Upper case English or Numeric when inserting Veesel Code
    //axon_event.addListener  ('keypress', 'num_keypress'  , 'pay_hir_no');
    axon_event.addListener  ('change', 'cust_seq_change', 'cust_seq');					//Getting Name information after inserting Owner Code
    axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');						//Getting Name information after inserting Vessel Code
    axon_event.addListener  ('change', 'pay_hir_no_change', 'pay_hir_no');				//- Getting Name information after inserting Currency Code
    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			//- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
    //axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); 			//- form Code Handling to onkeypress Event of All Controls having dataformat attribute
}

/**
 * Checking Validation in onblur Event of HTML Control <br>
 **/
function obj_deactivate(){
	//if (ComGetEvent().getAttribute("required") != null) return;
	switch(ComGetEvent("name")){
    	case "shp_spd_qty": 
    	case "vsl_dznd_capa": 
    	case "bse_14ton_vsl_capa": 
    	case "rf_cntr_plg_qty": 
    	case "ddwt_cgo_capa_qty": 
    	case "grs_wgt": 
    	case "nrt_wgt":
    	case "cust_seq":
    	case "pay_hir_no":	
    		//ComChkObjValid(obj, bMsg, bTrim, bMasked)
    		if(ComGetEvent("name") == "pay_hir_no") {
    			if(form.condition[0].checked) {
    				ComChkObjValid(ComGetEvent(), true, false, false);
    			}
    		} else {
    			ComChkObjValid(ComGetEvent(), true, false, false);
    		}
			break;
    	case "eff_dt":
    	case "exp_dt":
    	case "from_time":
    	case "to_time":
    		ComChkObjValid(ComGetEvent());
    		getInvUsdDys();
			break;
		default:
			ComChkObjValid(ComGetEvent());
	}
}
/**
 * Getting Name relevant to the CustSeq when CustSeq is changed <br>
 **/
function cust_seq_change() {
	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Owner');
}
/**
 * Getting Name relevant to the VslCd when VslCd is changed <br>
 **/
function vsl_cd_change() {
	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Vessel');
}
function vsl_cd_onblur() {
	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Vessel');
}
/**
 * Checking whether Hire No is existing when changing Hire No. <br>
 **/
function pay_hir_no_change() {
	if(form.condition[0].checked) {
		doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'HireNo');
	}
}
/**
 * Getting relevant Name when selecting Contract No <br>
 **/
function contract_no_change() {
	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Contract');
}
/**
 * Getting Duration <br>
 **/
function inv_usd_dys_change() {
	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Duration');
}
//Axon Event Handling2. Event Handling Function --- end

/**
 * Handling process for input validation <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {form}    formObj     Form Object
 * @param {int}     sAction      Action Code(Example:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL)
 **/
function validateForm(sheetObj,formObj,sAction,delYn){
	if(delYn != "D") { 
		if(formObj.condition[0].checked) {
			if (!ComChkValid(formObj)) return false;
		}
	}
    if(formObj.condition[0].checked) {        	
    	formObj.ppay_hir_no.value=formObj.pay_hir_no.value;
    	
    	if(   ComChkPeriod(form.eff_dt.value.trimAll("-"), form.exp_dt.value.trimAll("-")) < 1
    	   || form.inv_usd_dys.value == "") {
    		if(delYn == "D") {
    			ComShowMessage(ComGetMsg('FMS01159'));
    		} else {
    			if(form.eff_dt.value == "") {
    				ComAlertFocus(form.eff_dt, ComGetMsg('FMS01159'));
    			} else if(form.from_time.value == "") {
    				ComAlertFocus(form.from_time, ComGetMsg('FMS01159'));
    			} else if(form.exp_dt.value == "") {
    				ComAlertFocus(form.exp_dt, ComGetMsg('FMS01159'));
    			} else {
    				ComAlertFocus(form.to_time, ComGetMsg('FMS01159'));
    			}
    		}
			return;
		}
    	if(parseFloat(form.inv_usd_dys.value) <= 0) {
    		ComAlertFocus(form.to_time, ComGetMsg('FMS01175'));
    		return;
    	}
    	var fromDate=formObj.eff_dt.value.trimAll("-") + formObj.from_time.value.trimAll(":");
    	var toDate=formObj.exp_dt.value.trimAll("-") + formObj.to_time.value.trimAll(":");
    	var oriFromDate=formObj.ori_eff_dt.value;
    	var oriToDate=formObj.ori_exp_dt.value;
    	var formatFromDate=oriFromDate.substring(0,4)+"-"+oriFromDate.substring(4,6)+"-"+oriFromDate.substring(6,8)+" "+oriFromDate.substring(8,10)+":"+oriFromDate.substring(10,12);
    	var formatToDate=oriToDate.substring(0,4)+"-"+oriToDate.substring(4,6)+"-"+oriToDate.substring(6,8)+" "+oriToDate.substring(8,10)+":"+oriToDate.substring(10,12);
    	if(parseInt(fromDate) < parseInt(oriFromDate)) {
    		ComAlertFocus(formObj.eff_dt, ComGetMsg('FMS01172', formatFromDate));
    		return;
    	}
    	if(parseFloat(form.inv_usd_dys.value) > gOneYearDay) {
    		ComAlertFocus(form.exp_dt, ComGetMsg('FMS01174'));
    		return;
    	}
    	if(formObj.eff_dt.value != "" && formObj.from_time.value != "") {
    		formObj.ori_eff_dt.value=fromDate;
        }
        if(formObj.exp_dt.value != "" && formObj.to_time.value != "") {
        	formObj.ori_exp_dt.value=toDate;
        }
    } else {
    	formObj.ppay_hir_no.value=ComGetObjValue(formObj.pay_hir_no2);
    }
    if(delYn == "Y") {
    	var prefix="inv_";
    	for (var ir=1; ir<=sheetObj.LastRow(); ir++){
    		if(sheetObj.GetCellValue(ir, prefix+"slp_tp_cd") == "Y") {
    			ComShowMessage(ComGetMsg('FMS01160'));
    			return;
    			break;
    		}
    	}
    }
    return true;
}
/**
 * Event occurred after searching by DoSearch <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	ErrMsg    	Error Message
 **/
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var prefix="oli_";
	sheetObj.FitColWidth("32|13|13|8|34");
	sheetObj.SetColFontColor(0,"#532FC3");
	//InitCellProperty(sheetObj, prefix,{ Type:"curr_cd",Align:"otr_expn_amt"} );
	
	var formObj = document.form;		
	if(formObj.vsl_cd.value == "" || formObj.vsl_cd.value == "undefined") {
		sheetObjects[0].RemoveAll();
	} else if(formObj.inv_usd_dys.value == "" || formObj.inv_usd_dys.value == "undefined") {
		sheetObjects[0].RemoveAll();
	}								
}
/**
 * Event occurring when clicking Cell <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {string}  prefix     	Variable Separator
 * @param {string}  curSaveName currency saveName
 * @param {string}  amtSaveName amt saveName
 **/
//InitCellProperty(sheetObj, prefix, { Type:"curSaveName",Align:"amtSaveName"} );
/*function setInitCellProperty(sheetObj, prefix, curSaveName, amtSaveName, col) {
	for(var ir=1; ir<=sheetObj.LastRow(); ir++) {
		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + curSaveName))) {
			if(col == null || col == "") {
				sheetObj.InitCellProperty(ir, 8,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
			} else {
				sheetObj.InitCellProperty(ir, col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
			}
		}
	}
}*/

/**
 * Event occurred after searching by DoSearch <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	ErrMsg    	Error Message
 **/
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	var prefix="inv_";
	if (sheetObj.SearchRows()<=0) return;
	for (var ir=1; ir<=sheetObj.LastRow(); ir++){
		if(sheetObj.GetCellValue(ir, prefix+"curr_cd") == "" || sheetObj.GetCellValue(ir, prefix+"slp_tp_cd") == "Y") {
			sheetObj.SetCellEditable(ir, prefix+"inv_amt",0);
		}
		if(sheetObj.GetCellValue(ir, prefix+"curr_cd2") == ""  || sheetObj.GetCellValue(ir, prefix+"slp_tp_cd") == "Y") {
			sheetObj.SetCellEditable(ir, prefix+"inv_amt2",0);
		}
		if(sheetObj.GetCellValue(ir, prefix+"slp_tp_cd") == "Y") {
			sheetObj.SetCellEditable(ir, prefix+"DelChk",0);
		}
		/*
		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + "curr_cd"))) {
			sheetObj.InitCellProperty(ir, prefix+"inv_amt",{ Type:"Float",Align:"Right",Format:"NullFloat", PointCount:2} );
		}
		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + "curr_cd2"))) {
			sheetObj.InitCellProperty(ir, prefix+"inv_amt2",{ Type:"Float",Align:"Right",Format:"NullFloat", PointCount:2} );
		}*/
	}
	
	var formObj = document.form;		
	if(formObj.vsl_cd.value == "" || formObj.vsl_cd.value == "undefined") {
		sheetObjects[1].RemoveAll();
	} else if(formObj.inv_usd_dys.value == "" || formObj.inv_usd_dys.value == "undefined") {
		sheetObjects[1].RemoveAll();
	}			    	
}
/**
 * Calculating Sum of Grid <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	Selected Row of sheetObj
 * @return none
 **/
function sheet2_OnChangeSum(sheetObj, Row) {
	sheetObj.SetSumText(0,"acct_cd","Total Amount");
	sheetObj.SetCellAlign(sheetObj.LastRow(),"acct_cd","Center");
}
/**
 * Initializing Screen <br>
 * @param {String} flag   Event flag
 * @return none
 **/
function clearAll(flag) {
	//var flag;
	var val;
	
	if(typeof flag == "undefined" || flag == "" || flag == "ALL"){
		form.condition[0].checked = true;
	}
	if(form.condition[0].checked) {
		val=form.condition[0].value; 
	} else {
		val=form.condition[1].value; 
	}	
	//NYK Modify 2014.10.17
	if(flag != "DEL" && flag != "CTRT") {
		flag="ALL";
	}		
	setHireNo(val, flag);
	sheetObjects[1].CheckAll("inv_DelChk",0);
	document.all.btn_invoice.style.display="none";
	setContractNoBtn("V");		
	setVslCdBtn();		
	controlScrollBar();		
}
/**
 * Deleting Row <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	prefix   	Variable Separator
 * @return none
 **/
function rowRemove(sheetObj, prefix) {
	var sRow=sheetObj.FindCheckedRow(prefix + "DelChk");
	if (sRow == "") return;
	var arrRow=sRow.split("|"); 
	for (var idx=arrRow.length-1; idx>=0; idx--){		
		var row=arrRow[idx];
		if(sheetObj.GetCellValue(row, prefix+"slp_tp_cd") == "Y") {
			ComShowMessage(ComGetMsg('FMS01160'));
			sheetObj.CheckAll(prefix+"DelChk",0);
		} else {
			sheetObj.SetRowHidden(row,1);
			sheetObj.SetRowStatus(row,"D");
			//sheetObj.RowDelete(row, 0);				
		}
	}
}
/**
 * Setting by changing Condition <br>
 * @param {String} val    Condition 
 * @param {String} flag   Event flag
 * @see #ComResetAll
 *      #setDurationReadOnly
 * @return none
 **/
function setHireNo(val, flag) {						
	document.all.totalAmount.style.display="none";
	//NYK Modify 2014.10.17
	if(flag == "CTRT"){
		var tmpVslCd = form.vsl_cd.value;
		var tmpVslEngNm = form.vsl_eng_nm.value;
		ComResetAll();
		form.vsl_cd.value = tmpVslCd;
		form.vsl_eng_nm.value = tmpVslEngNm;
	}else{
		ComResetAll();
		if("DEL" == flag){
			val = "C";
		}
	}
	
	sheetObjects[1].CheckAll("inv_DelChk",0);
	document.all.btn_delete2.style.display="";
	setContractNoBtn("V");
	setVslCdBtn();
	
	setConditonBtnText(val);
	if(val == "C") {
		//document.getElementById("btn_execute").innerText = "Execute";
		document.all.c_ppay_hir_no.style.display="";
		document.all.i_ppay_hir_no.style.display="none";
		form.eff_dt.readOnly=false;
		form.from_time.readOnly=false;
		form.exp_dt.readOnly=false;
		form.to_time.readOnly=false;
		form.acmm_flg.disabled=false;
		form.brog_flg.disabled=false;
		form.ef_dt.disabled=false;
		form.ex_dt.disabled=false;
		document.getElementById("ef_dt").name="ef_dt";
    	document.getElementById("ex_dt").name="ex_dt";
		form.ef_dt.style.cursor="hand";
		form.ex_dt.style.cursor="hand";
		form.eff_dt.className="input";
    	form.from_time.className="input";
    	form.exp_dt.className="input";
    	form.to_time.className="input";
    	pay_hir_no2.RemoveAll();
    	
		document.all.totalAmount.style.display="none";
		setHireInvoiceBtn();
	} else {
		//document.getElementById("btn_execute").innerText = "Retrieve";
		if(flag == "ALL" || flag == "DEL") {
			form.eff_dt.readOnly=false;
			form.from_time.readOnly=false;
			form.exp_dt.readOnly=false;
			form.to_time.readOnly=false;
			form.acmm_flg.disabled=false;
			form.brog_flg.disabled=false;
			form.ef_dt.disabled=false;
			form.ex_dt.disabled=false;
			document.getElementById("ef_dt").name="ef_dt";
        	document.getElementById("ex_dt").name="ex_dt";
			form.ef_dt.style.cursor="hand";
			form.ex_dt.style.cursor="hand";
			document.all.c_ppay_hir_no.style.display="";
			document.all.i_ppay_hir_no.style.display="none";
			form.eff_dt.className="input";
	    	form.from_time.className="input";
	    	form.exp_dt.className="input";
	    	form.to_time.className="input";
	    	document.all.totalAmount.style.display="none";
		} else {							
			document.all.c_ppay_hir_no.style.display="none";				
			document.all.i_ppay_hir_no.style.display="";				
			pay_hir_no2.SetEnable(0);
			form.condition[1].checked=true;
			setDurationReadOnly();
			document.all.totalAmount.style.display="none";
		}
	}
}

function setConditonBtnText(val){		
	if(val == "C") {
		document.getElementById("btn_execute").innerText = "Execute";
	}else{
		document.getElementById("btn_execute").innerText = "Retrieve";
	}
}

/**
 * Inserting Vessel Code <br>
 * @param {arry} aryPopupData
 */
function setVslCd(aryPopupData){
	axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
	form.vsl_cd.value=aryPopupData[0][2];
	form.vsl_eng_nm.value=aryPopupData[0][3];
	axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			//Getting Name information after inserting Vessel Code
	form.vsl_cd.readOnly=true;
	form.btn_vslpop.style.cursor="default";
	//document.images["btn_vslpop"].name="no_btn_vslpop";
	form.btn_vslpop.style.cursor="hand";
}
/**
 * Inserting Contract No<br>
 * @param {arry} aryPopupData
 */
function setContractNo(aryPopupData){
	form.flet_ctrt_no.value=aryPopupData[0][3];
	contract_no_change();
}
/**
 * Address Comm / Brokerage Setting <br>
 * @return none
 **/
function declaration_click() {
	if(form.acmm_flg.checked) {
		if(   form.acmm_rt_amt.value == "" 
		   || form.acmm_rt_amt.value <= 0) {
			ComAlertFocus(form.acmm_flg, ComGetMsg('FMS00013', 'Address Comm.'));
			form.acmm_flg.checked=false;
		} else {
			form.acmm_flg.value='Y';
		}
	} else {
		form.acmm_flg.value='N';
	}
	if(form.brog_flg.checked) {
		if(   form.flet_brog_rt_amt.value == "" 
 		   || form.flet_brog_rt_amt.value <= 0) {
 			ComAlertFocus(form.brog_flg, ComGetMsg('FMS01162'));
 			form.brog_flg.checked=false;
 		} else {
 			form.brog_flg.value='Y';
 		}
	} else {
		form.brog_flg.value='N';
	}
}
/**
 * Setting Hire No <br>
 * @param {ibsheet} comboObj    IBSheet Object
 * @param {String} 	comboNo    	comboNo
 * @param {String} 	comboText   combo Html String
 * @return none
 **/
function setCombo(comboObj, comboNo, comboText) {
	//UI개선(201408 민정호)				
    switch(comboObj.options.id) {
        case "pay_hir_no2":    //HireNo
        	comboObj.RemoveAll();
        	comboObj.SetDropHeight(80);
        	if(comboText != "" ) {
            	var comboList=comboText.split("|");
            	for(var i=0; i < comboList.length-1; i++) {
            		comboObj.InsertItem(i, comboList[i], comboList[i]);
            	}
            	comboObj.SetSelectCode(comboList[0]);
            	comboObj.SetBackColor("#CCFFFD");
            	comboObj.SetEnable(1);
        	}
         break;
    } 
        	   
	/*		
    	if(comboText != "" ) {
        	var comboList=comboText.split("|");
        	for(var i=0; i < comboList.length-1; i++) {
        		pay_hir_no2.InsertItem(i, comboList[i], comboList[i]);
        	}
        	pay_hir_no2.SetSelectCode(comboList[0]);
        	pay_hir_no2.SetBackColor("#CCFFFD");
        	pay_hir_no2.SetEnable(1);
    	}
	*/    	            	            	
}
/**
 * Calculating Duration <br>
 * @param {String} sFromDate    From Date
 * @param {String} sToDate   	To Date
 * @return none
 * @see #getArgValue
 * 		#getDateObj
 **/
function getInvUsdDys(sFromDate, sToDate) {
	if(!durationDayCheck()) return;
	var sFromDate 	= ComTrim(form.eff_dt.value, "-") + ComTrim(form.from_time.value, ":");
	var sToDate 	= ComTrim(form.exp_dt.value, "-") + ComTrim(form.to_time.value, ":");
	//var sFromDate=form.eff_dt.value.trimAll("-") + form.from_time.value.trimAll(":");
	//var sToDate=form.exp_dt.value.trimAll("-") + form.to_time.value.trimAll(":");
	try {
	    //In case of String Sequence or HTML Tag(Object)
		var sFromDate=getArgValue(sFromDate);
		var sToDate=getArgValue(sToDate);
		if(sFromDate.length != sToDate.length) return NaN;
		var iFromTime=getDateObj(sFromDate);
		var iToTime=getDateObj(sToDate);
		var differTime=(iToTime - iFromTime) / (60*60*24*1000);
		form.inv_usd_dys.value=differTime.toFixed(4);
		return;
	} catch(err) {ComFuncErrMsg(err.message);}
}
/**
 * Checking Duration <br>
 **/
function durationDayCheck() {
	if(   form.eff_dt.value == "" 
	   || form.from_time.value == ""
	   || form.exp_dt.value == ""
	   || form.to_time.value == "") {
		form.inv_usd_dys.value="";
		return;
	}
	if(ComChkPeriod(form.eff_dt.value.trimAll("-"), form.exp_dt.value.trimAll("-")) < 1) {
		ComShowMessage(ComGetMsg('FMS01159'));
		return;
	}
	return true;
}
/**
 * Duration Setting <br>
 **/
function setDurationReadOnly() {
	form.eff_dt.readOnly=true;
	form.from_time.readOnly=true;
	form.exp_dt.readOnly=true;
	form.to_time.readOnly=true;
	form.acmm_flg.disabled=true;
	form.brog_flg.disabled=true;
	
	form.ef_dt.style.cursor="default";
	form.ex_dt.style.cursor="default";
	
	form.eff_dt.className="input2";
	form.from_time.className="input2";
	
	form.exp_dt.className="input2";
	form.to_time.className="input2";
}
/**
 * Deciding deletion of Date <br>
 * @return {boolean} okYn bool
 **/
function delConfirm() {
	var okYn=confirm(ComGetMsg('FMS01076'));
	return okYn;
}
/**
 * Event called to check Validation just before Saving by Saving Function <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} row     	Selected Row of sheetObj
 * @param {ibsheet} col     	Selected Col of sheetObj
 * @param {String}  value    	Inserted value of sheetObj
 **/
function sheet2_OnValidation(sheetObj,row,col,value) {
	var prefix="inv_";
	var invDtlSeqCol=sheetObj.SaveNameCol(prefix + "inv_dtl_seq");
	var invDtlSeqValue=sheetObj.GetCellText(row,invDtlSeqCol);
	if(invDtlSeqValue == "") {
		var invAmtCol=sheetObj.SaveNameCol(prefix + "inv_amt");
		var invAmtValue=sheetObj.GetCellText(row,invAmtCol).trimAll(",");
		var currCdCol=sheetObj.SaveNameCol(prefix + "curr_cd");
		var currCdValue=sheetObj.GetCellText(row,currCdCol);
		if(currCdValue == "") {
			ComShowMessage(ComGetMsg('FMS01077'));
			sheetObj.SelectCell(row,prefix + "curr_cd");
			sheetObj.ValidateFail(true);
		} else if(invAmtValue == "" || invAmtValue <= 0) {
			ComShowMessage(ComGetMsg('FMS01163'));
			sheetObj.SelectCell(row,prefix + "inv_amt");
			sheetObj.ValidateFail(true);
		}
		return;
	} else if(invDtlSeqValue != "") {
		//var prefix = "inv_";
		if(sheetObj.ColSaveName(col)==prefix + "inv_amt") {
			var invAmtCol=sheetObj.SaveNameCol(prefix + "inv_amt");
			var invAmtValue=sheetObj.GetCellText(row,invAmtCol).trimAll(",");
			var currCdCol=sheetObj.SaveNameCol(prefix + "curr_cd");
			var currCdValue=sheetObj.GetCellText(row,currCdCol);
			var sortKeyCol=sheetObj.SaveNameCol(prefix + "sort_key");
			var sortKeyValue=sheetObj.GetCellText(row,sortKeyCol);
			var firInvAmtCol=sheetObj.SaveNameCol(prefix + "fir_inv_amt");
			var firInvAmtValue=sheetObj.GetCellText(row,firInvAmtCol).trimAll(",");
			if(currCdValue != "" && invAmtValue == "" ) {
				if(sortKeyValue != "3" && firInvAmtValue == "") {
					ComShowMessage(ComGetMsg('FMS01163'));
					sheetObj.SelectCell(row,col);
					sheetObj.ValidateFail(true);
				} else if(sortKeyValue == "" && firInvAmtValue > 0) {
					ComShowMessage(ComGetMsg('FMS01163'));
					sheetObj.SelectCell(row,col);
					sheetObj.ValidateFail(true);
				} else {
					if(invAmtValue == "" || invAmtValue == 0) {
						ComShowMessage(ComGetMsg('FMS01171'));
						sheetObj.SelectCell(row,col);
						sheetObj.ValidateFail(true);
					}
				}
			} else if(currCdValue != "" && (invAmtValue == "" || invAmtValue > 0)) {
				if((sortKeyValue == "3" || firInvAmtValue < 0) && invAmtValue > 0) {
					ComShowMessage(ComGetMsg('FMS01171'));
					sheetObj.SelectCell(row,col);
					sheetObj.ValidateFail(true);
				}
			}
		} else if(sheetObj.ColSaveName(col)==prefix + "inv_amt2") {
			var invAmt2Col=sheetObj.SaveNameCol(prefix + "inv_amt2");
			var invAmt2Value=sheetObj.GetCellText(row,invAmt2Col).trimAll(",");
			var currCd2Col=sheetObj.SaveNameCol(prefix + "curr_cd2");
			var currCd2Value=sheetObj.GetCellText(row,currCd2Col);
			var sortKeyCol=sheetObj.SaveNameCol(prefix + "sort_key");
			var sortKeyValue=sheetObj.GetCellText(row,sortKeyCol);
			var firInvAmt2Col=sheetObj.SaveNameCol(prefix + "fir_inv_amt2");
			var firInvAmt2Value=sheetObj.GetCellText(row,firInvAmt2Col).trimAll(",");
			//if(currCd2Value != "" && (invAmt2Value == "" || invAmt2Value <= 0)) {
			if(currCd2Value != "" && invAmt2Value == "" ) {
				if(sortKeyValue != "3" && firInvAmt2Value == "") {
					ComShowMessage(ComGetMsg('FMS01163'));
					sheetObj.SelectCell(row,col);
					sheetObj.ValidateFail(true);
				} else if(sortKeyValue == "" && firInvAmt2Value > 0) {
					ComShowMessage(ComGetMsg('FMS01163'));
					sheetObj.SelectCell(row,col);
					sheetObj.ValidateFail(true);
				} else {
					if(invAmt2Value == "" || invAmt2Value == 0) {
						ComShowMessage(ComGetMsg('FMS01171'));
						sheetObj.SelectCell(row,col);
						sheetObj.ValidateFail(true);
					}
				}
			} else if(currCd2Value != "" && (invAmt2Value == "" || invAmt2Value > 0)) {
				if((sortKeyValue == "3" || firInvAmt2Value < 0) && invAmt2Value > 0) {
					ComShowMessage(ComGetMsg('FMS01171'));
					sheetObj.SelectCell(row,col);
					sheetObj.ValidateFail(true);
				}
			}
		}
	}
}
/**
 * Event occurred when value of cell is changed <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} row     	Selected Row of sheetObj
 * @param {ibsheet} col     	Selected Col of sheetObj
 * @param {String} value    	Inserted value of sheetObj
 **/
function sheet2_OnChange(sheetObj,row,col,value) {
	invAmtOnChange(sheetObj,row,col,value);
}
/**
 * Event occurred when value of cell is changed(Calculating Sum) <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} row     	Selected Row of sheetObj
 * @param {ibsheet} col     	Selected Col of sheetObj
 * @param {String} value    	Inserted value of sheetObj
 **/
function invAmtOnChange(sheetObj,row,col,value) {
    //if (value=="") return;
	var prefix="inv_";
	var colAlias=sheetObj.ColSaveName(col);
	if (colAlias==(prefix + "inv_amt")) {
		var oriInvAmtCol=sheetObj.SaveNameCol(prefix + "ori_inv_amt");
		var oriInvAmtValue=sheetObj.GetCellText(row,oriInvAmtCol).trimAll(",");
		var invAmtCol=sheetObj.SaveNameCol(prefix + "inv_amt");
		var invAmtValue=sheetObj.GetCellText(row,invAmtCol).trimAll(",");
		var sortKeyCol=sheetObj.SaveNameCol(prefix + "sort_key");
		var sortKeyValue=sheetObj.GetCellText(row,sortKeyCol);
		var firInvAmtCol=sheetObj.SaveNameCol(prefix + "fir_inv_amt");
		var firInvAmtValue=sheetObj.GetCellText(row,firInvAmtCol).trimAll(",");
		var invDtlSeqCol=sheetObj.SaveNameCol(prefix + "inv_dtl_seq");
		var invDtlSeqValue=sheetObj.GetCellText(row,invDtlSeqCol);
		/* 
		if(sortKeyValue != "3" && (invAmtValue == "" || invAmtValue <= 0)) {
			if(firInvAmtValue == "" || firInvAmtValue > 0) {
				ComShowMessage(ComGetMsg('FMS01163'));
				sheetObj.SelectCell(row,col);
				return;
			}
		} else if(sortKeyValue != "3" && (invAmtValue == "" || invAmtValue > 0)) {
			if(firInvAmtValue < 0) {
				ComShowMessage(ComGetMsg('FMS01171'));
				sheetObj.SelectCell(row,col);
				return;
			}
		} else if(sortKeyValue == "3" && (invAmtValue == "" || invAmtValue >= 0)) {
			ComShowMessage(ComGetMsg('FMS01171'));
			sheetObj.SelectCell(row,col);
			return;
		}
		*/
        // if(sheetObj.CellText(row, prefix + "acct_cd") != gAcctCdByBrokerage) {
			var formObj = document.form;
			var currCdCol=sheetObj.SaveNameCol(prefix + "curr_cd");
			var currCdValue=sheetObj.GetCellText(row,currCdCol).toLowerCase();
			//NYK Modify 2014.10.30
			var tmpObjId = currCdValue+"_inv_amt";
			var totalAmount=ComGetObjAttr(tmpObjId, "value").trimAll(",");
			//var totalAmount=eval("form."+currCdValue+"_inv_amt").value.trimAll(",");
			
			var totalInvAmount=parseFloat(totalAmount)-parseFloat(oriInvAmtValue)+parseFloat(invAmtValue);
			totalInvAmount=ComAddComma(totalInvAmount.toFixed(2));
			if(totalInvAmount.indexOf(".") == -1) {
				totalInvAmount=totalInvAmount+".00";
			} else {
				var lastIndex=totalInvAmount.lastIndexOf(".");
				var floatVal=totalInvAmount.substring(lastIndex+1,totalInvAmount.length);
				if(floatVal.length == 1) {
					totalInvAmount=totalInvAmount+"0";
				}
			}
			if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(row, prefix + "curr_cd"))) {
				//NYK Modify 2014.10.30
				//$("#"+tmpObjId).attr("value",ComAddComma(parseInt(totalInvAmount.trimAll(","))));
				//$("#"+tmpObjId).val(ComAddComma(parseInt(totalInvAmount.trimAll(","))));
				ComSetObjAttr(tmpObjId, "value", ComAddComma(parseInt(totalInvAmount.trimAll(","))));
				//eval("document.all."+currCdValue+"_inv_amt").value=ComAddComma(parseInt(totalInvAmount.trimAll(",")));
			} else {
				//NYK Modify 2014.10.30
				//$("#"+tmpObjId).attr("value",totalInvAmount);
				//$("#"+tmpObjId).val(totalInvAmount);
				ComSetObjAttr(tmpObjId, "value", totalInvAmount);
				//eval("document.all."+currCdValue+"_inv_amt").value=totalInvAmount;
				
			}
			sheetObj.SetCellText(row,oriInvAmtCol ,invAmtValue);
		 //}
	} else {
		var oriInvAmt2Col=sheetObj.SaveNameCol(prefix + "ori_inv_amt2");
		var oriInvAmt2Value=sheetObj.GetCellText(row,oriInvAmt2Col).trimAll(",");
		var invAmt2Col=sheetObj.SaveNameCol(prefix + "inv_amt2");
		var invAmt2Value=sheetObj.GetCellText(row,invAmt2Col).trimAll(",");
		var sortKeyCol=sheetObj.SaveNameCol(prefix + "sort_key");
		var sortKeyValue=sheetObj.GetCellText(row,sortKeyCol);
		var firInvAmt2Col=sheetObj.SaveNameCol(prefix + "fir_inv_amt2");
		var firInvAmt2Value=sheetObj.GetCellText(row,firInvAmt2Col).trimAll(",");
		var invDtlSeqCol=sheetObj.SaveNameCol(prefix + "inv_dtl_seq");
		var invDtlSeqValue=sheetObj.GetCellText(row,invDtlSeqCol);
		/*if(sortKeyValue != "3" && (invAmt2Value == "" || invAmt2Value <= 0)) {
			if(firInvAmt2Value == "" || firInvAmt2Value > 0) {
				ComShowMessage(ComGetMsg('FMS01163'));
				sheetObj.SelectCell(row,col);
				return;
			}
		} else if(sortKeyValue != "3" && (invAmt2Value == "" || invAmt2Value > 0)) {
			if(firInvAmt2Value < 0) {
				ComShowMessage(ComGetMsg('FMS01171'));
				sheetObj.SelectCell(row,col);
				return;
			}
		} else if(sortKeyValue == "3" && (invAmt2Value == "" || invAmt2Value >= 0)) {
			ComShowMessage(ComGetMsg('FMS01171'));
			sheetObj.SelectCell(row,col);
			return;
		}*/
		//if(sheetObj.GetCellText(row, prefix + "acct_cd") != gAcctCdByBrokerage) {
			var currCd2Col=sheetObj.SaveNameCol(prefix + "curr_cd2");
			var currCd2Value=sheetObj.GetCellText(row,currCd2Col).toLowerCase();
			
			//NYK Modify 2014.10.30
			var tmpObj2Id = currCd2Value+"_inv_amt2";
			var totalAmount=ComGetObjAttr(tmpObj2Id, "value").trimAll(",");
			//var totalAmount=eval("form."+currCd2Value+"_inv_amt2").value.trimAll(",");
			
			var totalInvAmount=parseFloat(totalAmount)-parseFloat(oriInvAmt2Value)+parseFloat(invAmt2Value);
			totalInvAmount=ComAddComma(totalInvAmount.toFixed(2));
			if(totalInvAmount.indexOf(".") == -1) {
				totalInvAmount=totalInvAmount+".00";
			} else {
				var lastIndex=totalInvAmount.lastIndexOf(".");
				var floatVal=totalInvAmount.substring(lastIndex+1,totalInvAmount.length);
				if(floatVal.length == 1) {
					totalInvAmount=totalInvAmount+"0";
				}
			}
			if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(row, prefix + "curr_cd2"))) {
				//NYK Modify 2014.10.30
				//$("#"+tmpObj2Id).val(ComAddComma(parseInt(totalInvAmount.trimAll(","))));
				ComSetObjAttr(tmpObj2Id, "value", ComAddComma(parseInt(totalInvAmount.trimAll(","))));
				//eval("form."+currCd2Value+"_inv_amt2").value=ComAddComma(parseInt(totalInvAmount.trimAll(",")));
				
			} else {
				//NYK Modify 2014.10.30
				ComSetObjAttr(tmpObj2Id, "value",totalInvAmount);
				//eval("form."+currCd2Value+"_inv_amt2").value=totalInvAmount;
			}
			sheetObj.SetCellText(row,oriInvAmt2Col ,invAmt2Value);
		//}
	}
	/*
	if (colAlias==(prefix + "inv_amt")) {
		var oriInvAmtCol=sheetObj.SaveNameCol(prefix + "ori_inv_amt");
		var oriInvAmtValue=sheetObj.GetCellText(row,oriInvAmtCol).trimAll(",");
		var invAmtCol=sheetObj.SaveNameCol(prefix + "inv_amt");
		var invAmtValue=sheetObj.GetCellText(row,invAmtCol).trimAll(",");
		if(invAmtValue == "" || invAmtValue <= 0) {
			ComShowMessage(ComGetMsg('FMS01163'));
			sheetObj.SelectCell(row,col);
			return;
		}
		var currCdCol=sheetObj.SaveNameCol(prefix + "curr_cd");
		var currCdValue=sheetObj.GetCellText(row,currCdCol).toLowerCase();
		var totalAmount=eval("form."+currCdValue+"_inv_amt").value.trimAll(",");
		var totalInvAmount=parseFloat(totalAmount)-parseFloat(oriInvAmtValue)+parseFloat(invAmtValue);
		totalInvAmount=ComAddComma(totalInvAmount);
		if(totalInvAmount.indexOf(".") == -1) {
			totalInvAmount=totalInvAmount+".00";
		} else {
			var lastIndex=totalInvAmount.lastIndexOf(".");
			var floatVal=totalInvAmount.substring(lastIndex+1,totalInvAmount.length);
			if(floatVal.length == 1) {
				totalInvAmount=totalInvAmount+"0";
			}
		}
		eval("form."+currCdValue+"_inv_amt").value=totalInvAmount;
		sheetObj.SetCellText(row,oriInvAmtCol ,invAmtValue);
	} else {
		var oriInvAmt2Col=sheetObj.SaveNameCol(prefix + "ori_inv_amt2");
		var oriInvAmt2Value=sheetObj.GetCellText(row,oriInvAmt2Col).trimAll(",");
		var invAmt2Col=sheetObj.SaveNameCol(prefix + "inv_amt2");
		var invAmt2Value=sheetObj.GetCellText(row,invAmt2Col).trimAll(",");
		if(invAmt2Value == "" || invAmt2Value <= 0) {
			ComShowMessage(ComGetMsg('FMS01163'));
			sheetObj.SelectCell(row,col);
			return;
		}
		var currCd2Col=sheetObj.SaveNameCol(prefix + "curr_cd2");
		var currCd2Value=sheetObj.GetCellText(row,currCd2Col).toLowerCase();
		var totalAmount=eval("form."+currCd2Value+"_inv_amt2").value.trimAll(",");
		var totalInvAmount=parseFloat(totalAmount)-parseFloat(oriInvAmt2Value)+parseFloat(invAmt2Value);
		totalInvAmount=ComAddComma(totalInvAmount);
		if(totalInvAmount.indexOf(".") == -1) {
			totalInvAmount=totalInvAmount+".00";
		} else {
			var lastIndex=totalInvAmount.lastIndexOf(".");
			var floatVal=totalInvAmount.substring(lastIndex+1,totalInvAmount.length);
			if(floatVal.length == 1) {
				totalInvAmount=totalInvAmount+"0";
			}
		}
		eval("form."+currCd2Value+"_inv_amt2").value=totalInvAmount;
		sheetObj.SetCellText(row,oriInvAmt2Col ,invAmt2Value);
	}
	*/
}
/**
 * Controlling Scroll bar automatically when searching data  <br>
 **/
function controlScrollBar() {
	try{
		// top.syncHeight()
	} catch(err){ComFuncErrMsg(err.message);}
}
/**
 * Controlling HireInvoice Button by Contract TP value <br>
 **/
function setHireInvoiceBtn() {
	var fletCtrtTpCd=form.flet_ctrt_tp_cd.value;
	if(fletCtrtTpCd == "T/C In") {
		document.all.btn_invoice.style.display="none";
	} else {
		if(form.condition[0].checked) {
			document.all.btn_invoice.style.display="none";
		} else {
			document.all.btn_invoice.style.display="";
		}
	}
}
/**
 * Controlling Contract Search Button after retrieving <br>
 **/
function setContractNoBtn(flag) {
	if(flag == "V") {
		form.contract_no.style.cursor="hand";
		//document.getElementById("contract_no").name="contract_no";
		form.contract_no.style.cursor="hand";
	} else {
		form.contract_no.style.cursor="default";
		//document.getElementById("contract_no").name="no_contract_no";
		form.contract_no.style.cursor="hand";
	}
}
/**
 * Controlling VslCd Button when Initializing/Deleting <br>
 **/
function setVslCdBtn() {
	form.vsl_cd.readOnly=false;
	form.btn_vslpop.style.cursor="hand";
	document.getElementById("btn_vslpop").name="btn_vslpop";
}
 /**
  * Checking implemetation when Event is occurred <br>
  * @return {boolean} okYn    okYn:true or okYn:false
  **/
 function initConfirm() {
 	var okYn=true;
 	if(sheetObjects[1].IsDataModified()) {
 		var okYn=ComShowCodeConfirm(ComGetMsg('FMS00002'));
 	}
 	return okYn;
 }
  /**
   * Initializing all Object of document  <br>
   * IBSheet.RemoveAll()<br>
   * @return none
   * @see #ComClearManyObjects
   */
  function gridReset(){
      try {
      	sheetObjects[1].RemoveAll();
      } catch(err) { ComFuncErrMsg(err.message); }
  }
  /**
   * Event occurring when selected Item is changed
   * @param comboObj
   * @param KeyCode
   * @param Shift OnKeyUp
   * @return
   */
  function pay_hir_no_OnKeyUp(comboObj, KeyCode, Shift) {
	  var sText=comboObj.GetSelectText();
	  if ((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105) ) {
		  if (sText.length < 4) {
			  comboObj.SetSelectCode(sText);
  		  } else {
  			  comboObj.SetSelectText("");
  		  }
  	  } else { 
  		  //comboObj.Text = ""; 
  	  }
  }
   	
function resizeSheet(){
    ComResizeSheet(sheetObjects[1], 80);
}

//NYK Modify 2014.10.16
function initDefaultContractNo(){
  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
}