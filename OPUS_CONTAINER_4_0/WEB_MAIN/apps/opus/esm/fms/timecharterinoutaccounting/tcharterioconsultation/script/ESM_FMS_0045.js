/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0045.js
*@FileTitle  : Sublet Revenue Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_fms_0045 : esm_fms_0045 definition of biz script for creation screen
     */
    // common global variables 
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    // Event handler processing by button name */
	function processButtonClick(){
	    var sheetObject=sheetObjects[0];
	    var sheetObject1=sheetObjects[1];
	    var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_Retrieve":
						if(validateForm(sheetObject,formObject,IBSEARCH)) {
							if(form.to_inv_no1.value == "") {
								form.to_inv_no.value="";
							} else {
								form.to_inv_no.value=form.to_inv_no1.value;
							}
							form.curr_cd.value="";
							form.csr_amt.value="";
							sheetObject1.RemoveAll();
							doActionIBSheet(sheetObject,document.form,IBSEARCH);
						}
						break;
					case "btn_New":
						//ComResetAll();
						//inputReadOnly();
						clearAll();//NYK Modify 2014.10.21
						break;
					case "btn_vslCd":
	     				ComOpenPopup("ESM_FMS_0022.do", 520, 470, "setVslCd", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0022");
	     				break;
	    			case "btn_fletCtrtNo":
	    				if(form.vsl_cd.disabled == true) {
	    					return;
	    				}
	     				if(formObject.vsl_cd.value == "") {
	     					ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01231'));
	     					return;
	     				}
	     				
	     				clearAll("CTRT"); //NYK Modify 2014.10.21
	     				
	     				var param="typeFlag=" + "TO" + "&vsl_cd=" + formObject.vsl_cd.value;
	     				ComOpenPopup("ESM_FMS_0023.do?" + param, 520, 405, "setContractNo", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0023");
	     				break;
	    			case "btn_condition":
	    				inputReadOnly();
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
	 * registering IBSheet Object as list 
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet 
	 * implementing onLoad event handler in body tag 
	 * * adding first-served functions after loading screen. 
	 */
	function loadPage() {
	    for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	    initControl();
	    inputReadOnly();
	    $("#vsl_cd").blur(function(){
	    	vsl_cd_change();
	    })
	    resizeSheet();
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
	    var sheetID=sheetObj.id;
	    switch(sheetID) {
	        case "sheet1":
	            with(sheetObj){
			          var HeadTitle1="Seq|Invoice No.|VVD CD|Currency|CSR Amount|CSR Description|CSR No.";
			          var headCount=ComCountHeadTitle(HeadTitle1);
			          (headCount, 0, 0, true);
		
			          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
			          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			          InitHeaders(headers, info);
		
			          var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"to_inv_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"csr_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"csr_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"csr_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"csr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];
			           
			          InitColumns(cols);
		
			          SetEditable(1);
			          SetDataLinkMouse("to_inv_no",1);
			          SetDataLinkMouse("vvd_cd",1);
			          SetDataLinkMouse("csr_curr_cd",1);
			          SetDataLinkMouse("csr_amt",1);
			          SetDataLinkMouse("csr_desc",1);
			          SetSheetHeight(120);
	            }
	            break;
	        case "sheet2":
	            with(sheetObj){
			          var HeadTitle1="Seq|Acct Code|Customer Code|Customer Code|Center Code|City|Effective Date|Slip Amount";
			          var HeadTitle2="Seq|Description|Description|Description|Description|Description|VVD Code|Key Number";
			          var headCount=ComCountHeadTitle(HeadTitle1);
			          (headCount, 0, 0, true);
			          cnt=0;
			          SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
			          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"},
			                      { Text:HeadTitle2, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [ [{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			                 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"acct_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"ctr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"slp_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"csr_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 ],[
			                 {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq1" },
			                 {Type:"Text",      Hidden:0,  Width:125,  Align:"Left",    ColMerge:1,   SaveName:"csr_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"csr_desc1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"csr_desc2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"csr_desc3",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"csr_desc4",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"to_inv_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
			                 ]];
			           
//			          InitColumns(cols);
			          InitColumns(cols , 2);
			          SetEditable(1);
			          SetSheetHeight(260);
	          }
	            break;
	    }
	}
    /**
	 * Handling IBSheet's process<br>
	 */
	function doActionIBSheet(sheetObj, formObj, sAction, objNm) {
		sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	    	case IBSEARCH:      
		    	if(objNm == "flet_ctrt_tp_nm") {
		 			formObj.f_cmd.value=SEARCH04;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0050GS.do", FormQueryString(formObj));
		   			var ctrtType=ComGetEtcData(sXml, "ctrtType");
		   			if(typeof ctrtType != "undefined" && ctrtType != "") {
		   				formObj.flet_ctrt_tp_nm.value=ctrtType;
					}
				} else if(objNm == "vsl_cd") {
	    			formObj.f_cmd.value=SEARCH01;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", FormQueryString(formObj));
		   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value=vslEngNm;
		   				form.flet_ctrt_no.value="";
	     				form.flet_ctrt_tp_nm.value="";
	     				
	     				initDefaultContractNo(); //NYK Modify 2014.10.21
					} else {
						formObj.vsl_cd.value="";
						form.flet_ctrt_no.value="";
	     				form.flet_ctrt_tp_nm.value="";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00006", "Vessel Code"));
					}
				} else if(objNm == "vvd_cd") {
					formObj.f_cmd.value=SEARCH06;
					var param="f_cmd=" + formObj.f_cmd.value + "&vvd_cd=" + formObj.vvd_cd.value;
 					var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", param);
					if(CoFmsShowXmlMessage(sXml) != "") {
						formObj.vvd_cd.value="";
						ComAlertFocus(formObj.vvd_cd, CoFmsShowXmlMessage(sXml));
					}
				} else {
					if(validateForm(sheetObj,formObj,sAction)) {
						if(sheetObj.id == "sheet1") {
							formObj.f_cmd.value=SEARCH;
 							sheetObj.DoSearch("ESM_FMS_0045GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(new Array("sheet1_")) );
						} else if(sheetObj.id == "sheet2") {
							formObj.f_cmd.value=SEARCH01;
 							sheetObj.DoSearch("ESM_FMS_0045GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(new Array("sheet2_")) );
						}
					}
				}
	    		break;
	    	case IBSAVE:        
	    		if(validateForm(sheetObj,formObj,sAction))
	    			alert (" Save .. ");
	            break;
	    	case IBINSERT:      
	            break;
            	
			case IBSEARCH_ASYNC02: //NYK Modify 2014.10.21				
				if(formObj.vsl_cd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdTO; 
				
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
     * Handling process for input validation<br>
     */
	function validateForm(sheetObj,formObj,sAction) {
	    var exptElems="";
	    if(form.btn_condition[0].checked) {
	    	exptElems="vvd_cd|to_inv_no1";
	    } else  if(form.btn_condition[1].checked) {
	    	exptElems="to_inv_no1|vsl_cd|flet_ctrt_no";
	    } else  if(form.btn_condition[2].checked) {
	    	exptElems="vsl_cd|flet_ctrt_no|vvd_cd";
	    }
	    if (!ComFmsChkValid(formObj, exptElems)) {
	    	return false;
	    }
	    
	    if( sAction == IBSEARCH){
     		if(form.btn_condition[0].checked) {
        		if(ComIsEmpty(form.vsl_cd.value) ){
        			ComShowCodeMessage("FMS00004", "Vessel Code");
	    			return false;
        		}else if(ComIsEmpty(form.flet_ctrt_no.value)){
        			ComShowCodeMessage("FMS00004", "Contract No.");
	    			return false;
        		}
        	} else if(form.btn_condition[1].checked) {
        		if(ComIsEmpty(form.vvd_cd.value)){
        			ComShowCodeMessage("FMS00004", "VVD");
	    			return false;
        		}
        	} else if(form.btn_condition[2].checked) {
        		if(ComIsEmpty(form.to_inv_no1.value)){
        			ComShowCodeMessage("FMS00004", "Invoice No.");
	    			return false;
        		}
        	}
     		
     	}
	    
	    return true;
	}
	/**
 	 * Loading Event of HTML_Control existing on page dynamically <br>
 	 * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {int}     sheetNo     sequence of sheetObjects array
 	 **/
 	function initControl() {
 		//Axon Event Handling1. Event catch
// 		axon_event.addListenerForm  ('blur'		, 'obj_blur'	, form);	//- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
// 		axon_event.addListenerForm  ('keypress'	, 'eng_keypress', form); 	//- form Code Handling to onkeypress Event of All Controls
// 		axon_event.addListenerForm  ('change', 'vsl_cd_change', form); 	//- form Code Handling to OnChange Event of All Controls
 	}
 	/**
     * Checking Validation in ondeactive Event of HTML Control<br>
     **/
//    function obj_blur(){
//    	ComChkObjValid(ComGetEvent());
//    }
    /**
     * Only insert English and Numefic by onkeypress Event of HTML Control<br>
     **/
//    function eng_keypress() {
//    	if(event.srcElement.name == "csr_curr_cd") {
//    		ComKeyOnlyAlphabet('upper');
//    	}else if(event.srcElement.name == "vsl_cd") {
//    		ComKeyOnlyAlphabet('uppernum');
//    	}else if(event.srcElement.name == "vvd_cd") {
//    		ComKeyOnlyAlphabet('upper', '48|49|50|51|52|53|54|55|56|57');
//    	} else if(event.srcElement.name == "to_inv_no1") {
//    		ComKeyOnlyAlphabet('upper', '48|49|50|51|52|53|54|55|56|57');
//    	}
//    }
    /**
     * Checking Validation of Vessel Code in onchange Event of HTML Control<br>
     */
	function vsl_cd_change() {
		if((ComGetEvent("name") == "vsl_cd")) {
			if(form.vsl_cd.value.length == 4) {
		    	form.vsl_eng_nm.value="";
		    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
			}
		}
	}
	/**
 	 * Setting Vessel information selected in Vessel Code PopUp into Form item <br>
 	 * @param {arry} aryPopupData
 	 */
 	function setVslCd(aryPopupData) {
 		form.vsl_cd.value=aryPopupData[0][2];
 		form.vsl_eng_nm.value=aryPopupData[0][3];
 		
 		//NYK Modify 2014.10.21
		if(form.vsl_cd.value != ""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
		}
 	}
 	/**
	 * Setting Contract No. selected in Contract Code PopUp into Form item <br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value=aryPopupData[0][3];
		
		contract_no_change();
		
	}	
	//NYK Modify 2014.10.21
    function contract_no_change() {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"flet_ctrt_tp_nm");
    }
    
	/**
	 * Retrieving Detail information corresponding to Invoicd No <br>
	 */ 
	function sheet1_OnClick(sheetObj, row, col, cellX, cellY, cellW, cellH) {
		form.to_inv_no.value=sheetObj.GetCellValue(row, "to_inv_no");
		form.curr_cd.value=sheetObj.GetCellValue(row, "csr_curr_cd");
		form.csr_no.value=sheetObj.GetCellValue(row, "csr_no");
		form.csr_amt.value=ComAddComma(sheetObj.GetCellValue(row, "csr_amt"), 2);
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
	}
	/**
	 * Setting whether to use the Object by Condition<br>
	 **/
    function inputReadOnly() {
    	if(form.btn_condition[0].checked) {
    		form.vsl_cd.setAttribute('required', ''); 
    		form.vsl_cd.disabled=false;
   			form.vsl_cd.className="input";
//	    	document.images["btn_vslCd"].name="btn_vslCd";
	    	form.btn_vslCd.name="btn_vslCd";
	    	form.btn_vslCd.style.cursor="hand";
//	    	document.images["btn_fletCtrtNo"].name="btn_fletCtrtNo";
	    	form.btn_fletCtrtNo.name="btn_fletCtrtNo";
	    	form.btn_fletCtrtNo.style.cursor="hand";
	    	form.vvd_cd.disabled=true;
   			form.vvd_cd.value="";
   			form.vvd_cd.className="input2";
	    	form.to_inv_no1.disabled=true;
   			form.to_inv_no1.value="";
   			form.to_inv_no1.className="input2";
   			if(form.vsl_cd.value == "") {
   				sheetObjects[0].RemoveAll();
   				sheetObjects[1].RemoveAll();
   			}
    	} else if(form.btn_condition[1].checked) {
    		form.vsl_cd.removeAttribute('required'); 
    		form.vvd_cd.disabled=false;
   			form.vvd_cd.className="input1";
   			form.vsl_cd.disabled=true;
   			form.vsl_cd.value="";
   			form.vsl_cd.className="input2";
//	    	document.images["btn_vslCd"].name="no_btn_vslCd";
	    	form.btn_vslCd.name="no_btn_vslCd";
	    	form.btn_vslCd.style.cursor="default";
//	    	document.images["btn_fletCtrtNo"].name="no_btn_fletCtrtNo";
	    	form.btn_fletCtrtNo.name="no_btn_fletCtrtNo";
	    	form.btn_fletCtrtNo.style.cursor="default";
	    	form.to_inv_no1.disabled=true;
   			form.to_inv_no1.value="";
   			form.to_inv_no1.className="input2";
   			form.vsl_eng_nm.value="";
   			form.flet_ctrt_no.value="";
   			form.flet_ctrt_tp_nm.value="";
   			if(form.vvd_cd.value == "") {
   				sheetObjects[0].RemoveAll();
   				sheetObjects[1].RemoveAll();
   			}
    	} else if(form.btn_condition[2].checked) {
    		form.vsl_cd.removeAttribute('required'); 
    		form.to_inv_no1.disabled=false;
   			form.to_inv_no1.className="input1";
    		form.vsl_cd.disabled=true;
   			form.vsl_cd.value="";
   			form.vsl_cd.className="input2";
//	    	document.images["btn_vslCd"].name="no_btn_vslCd";
	    	form.btn_vslCd.name="no_btn_vslCd";
	    	form.btn_vslCd.style.cursor="default";
//	    	document.images["btn_fletCtrtNo"].name="no_btn_fletCtrtNo";
	    	form.btn_fletCtrtNo.name="no_btn_fletCtrtNo";
	    	form.btn_fletCtrtNo.style.cursor="default";
	    	form.vvd_cd.disabled=true;
   			form.vvd_cd.value="";
   			form.vvd_cd.className="input2";
   			form.vsl_eng_nm.value="";
   			form.flet_ctrt_no.value="";
   			form.flet_ctrt_tp_nm.value="";
   			if(form.to_inv_no1.value == "") {
   				sheetObjects[0].RemoveAll();
   				sheetObjects[1].RemoveAll();
   			}
    	}
    }
    /**
     * Retrieving Detail Information of first Row in case onSearchEnd Evant in Sheet1 is occurred<br>
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
		form.to_inv_no.value=sheetObj.GetCellValue(1, "to_inv_no");
		form.csr_no.value	=sheetObj.GetCellValue(1, "csr_no");
		var curr_cd_val 	=sheetObj.GetCellValue(1, "csr_curr_cd");
		var csr_amt_val 	=ComAddComma(sheetObj.GetCellValue(1, "csr_amt"), 2);
		if(curr_cd_val != "-1" && csr_amt_val != "-1"){
			form.curr_cd.value=curr_cd_val;
			form.csr_amt.value=csr_amt_val;
		}
		
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
  	}
    /**
     * Changing Font of VVD Code and City in case OnSearchEnd Event in Sheet2 is occurred <br>
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg) {
    	for(var i=2; i<=sheetObj.LastRow(); i++) {
    		if(i%2 > 0) {
    			sheetObj.SetCellFont("FontName", i, "vvd_cd","Courier New");
    		} else {
    			sheetObj.SetCellFont("FontName", i, "slp_loc_cd","Courier New");
    		}
    	}
    }
	
 	function clearAll(flag){
 		//NYK Modify 2014.10.21
		switch(flag){
			case "CTRT" :
				var tmpVslCd = form.vsl_cd.value;
				var tmpVslEngNm = form.vsl_eng_nm.value;
				ComResetAll();
				form.vsl_cd.value = tmpVslCd;
				form.vsl_eng_nm.value = tmpVslEngNm;
				break;
			default :
				ComResetAll();
				break;
		}
		inputReadOnly();
 	}

    //NYK Modify 2014.10.21
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }
    
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[1], 70);
    }

