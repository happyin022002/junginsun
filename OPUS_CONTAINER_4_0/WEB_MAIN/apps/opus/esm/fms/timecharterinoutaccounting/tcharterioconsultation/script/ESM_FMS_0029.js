/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0029.js
*@FileTitle  : Tax Evidence
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_FMS_0029 : ESM_FMS_0029 definition of biz script for creation screen
     */
	// common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
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

    		if (!ComIsBtnEnable(srcName)) return;             //버튼 상태를 확인을 합니다.
    		
			switch(srcName) {
	        	case "btn_rowAdd":
	        		if(sheetObjects[0].RowCount()< 4) {
	        			var row=sheetObject.DataInsert(-1);
	        		}
					break;
				case "btn_rowDel":
					//if(checkBoxCheckYn(sheetObject, "DelChk")) {
	            	rowRemove(sheetObject, "txd_");
	            	//}
					break;
				case "btn_confirm":
					if(form.tax_iss_cd[0].checked == false
			           && form.tax_iss_cd[1].checked == false) {
			        	ComShowCodeMessage("FMS01479");
			        	return false;
			        }
					if(!ComChkValid(formObject)) return false;
					if(sheetObjects[0].RowCount()== 0) {
						ComShowCodeMessage("FMS00007");
						return;
					}
					if(!validateForm()) return false; 
					var prefix="tax_";
					if(opener.sheetObjects[1].RowCount()> 0) {
						opener.sheetObjects[1].RemoveAll();
						opener.sheetObjects[2].RemoveAll();
					}
					var row=opener.sheetObjects[1].DataInsert(-1);
					opener.sheetObjects[1].SetCellValue(row,prefix+"tax_inv_yrmon",formObject.tax_inv_yrmon.value);
					opener.sheetObjects[1].SetCellValue(row,prefix+"ofc_cd",formObject.ofc_cd.value);
					var tax_iss_cd="ELECTRONIC";
					if(formObject.tax_iss_cd[0].checked) {
						tax_iss_cd=formObject.tax_iss_cd[0].value;
					} else {
						tax_iss_cd=formObject.tax_iss_cd[1].value;
					}
					opener.sheetObjects[1].SetCellValue(row,prefix+"tax_iss_cd",tax_iss_cd);
					var tax_vat_tp_cd="1";
					if(formObject.tax_vat_tp_cd[0].checked) {
						tax_vat_tp_cd=formObject.tax_vat_tp_cd[0].value;
					} else {
						tax_vat_tp_cd=formObject.tax_vat_tp_cd[1].value;
					}
					opener.sheetObjects[1].SetCellValue(row,prefix+"tax_vat_tp_cd",tax_vat_tp_cd);
					opener.sheetObjects[1].SetCellValue(row,prefix+"tax_naid_flg","N");
					var tax_div_cd="1";
					if(formObject.tax_div_cd[0].checked) {
						tax_div_cd=formObject.tax_div_cd[0].value;
					} else {
						tax_div_cd=formObject.tax_div_cd[1].value;
					}
					opener.sheetObjects[1].SetCellValue(row,prefix+"tax_div_cd",tax_div_cd);
					opener.sheetObjects[1].SetCellValue(row,prefix+"fa_flg","N");
					if(formObject.evid_tp_cd.value == "1") {
						var tax_pl_cd="1";
						if(formObject.tax_pl_cd[0].checked) {
							tax_pl_cd=formObject.tax_pl_cd[0].value;
						} else {
							tax_pl_cd=formObject.tax_pl_cd[1].value;
						}
						opener.sheetObjects[1].SetCellValue(row,prefix+"tax_pl_cd",tax_pl_cd);
					}
					opener.sheetObjects[1].SetCellValue(row,prefix+"tax_nsl_flg","N");
					opener.sheetObjects[1].SetCellValue(row,prefix+"spl_rgst_no",formObject.spl_rgst_no.value);
					opener.sheetObjects[1].SetCellValue(row,prefix+"ownr_nm",formObject.ownr_nm.value);
					opener.sheetObjects[1].SetCellValue(row,prefix+"co_nm",formObject.co_nm.value);
					opener.sheetObjects[1].SetCellValue(row,prefix+"bzct_nm",formObject.bzct_nm.value);
					opener.sheetObjects[1].SetCellValue(row,prefix+"bztp_nm",formObject.bztp_nm.value);
					opener.sheetObjects[1].SetCellValue(row,prefix+"spl_addr",formObject.spl_addr.value);
					opener.sheetObjects[1].SetCellValue(row,prefix+"iss_dt",formObject.iss_dt.value);
					opener.sheetObjects[1].SetCellValue(row,prefix+"spl_amt",formObject.spl_amt.value);
					opener.sheetObjects[1].SetCellValue(row,prefix+"tax_amt",formObject.tax_amt.value);
					opener.sheetObjects[1].SetCellValue(row,prefix+"total_amt",formObject.total_amt.value);
					prefix="txd_";
					for(var ir=1; ir<=sheetObjects[0].LastRow(); ir++) {
						var row=opener.sheetObjects[2].DataInsert(-1);
					opener.sheetObjects[2].SetCellValue(row,prefix+"itm_nm",sheetObjects[0].GetCellValue(ir,prefix+"itm_nm"));
					opener.sheetObjects[2].SetCellValue(row,prefix+"spl_amt",sheetObjects[0].GetCellValue(ir,prefix+"spl_amt"));
					opener.sheetObjects[2].SetCellValue(row,prefix+"tax_amt",sheetObjects[0].GetCellValue(ir,prefix+"tax_amt"));
					opener.sheetObjects[2].SetCellValue(row,prefix+"total_amt",sheetObjects[0].GetCellValue(ir,prefix+"total_amt"));
					}
					opener.form.evid_tp_cd.disabled=true;
					opener.form.csr_curr_cd.readOnly=true;
					ComClosePopup(); 
					break;
				case "btn_new":
					ComResetAll();
					setOfcCd();
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
				case "tax_inv_yrmon_cal" :
					 var cal=new ComCalendar();
					 cal.setDisplayType('month');
	                 cal.select(form.tax_inv_yrmon, 'yyyy-MM');
	                 break;
				case "iss_dt_cal": 
	        		var cal=new ComCalendar();
	        		cal.select(form.iss_dt, 'yyyy-MM-dd');
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
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        initControl();
        sheet1_OnLoadFinish(sheet1);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * * adding first-served functions after loading screen. 
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	
//    	CoFmsGetBizCombo('FORM', document.form, sheetObj, 'ofc_cd', 'ofc_nm', '11', 'ESM_FMS_0022GS.do', '');
        if(opener.sheetObjects[1].RowCount()> 0) {
        	setTaxEvidenceData();
        } else {
        	setOfcCd();
        }
		sheetObj.SetWaitImageVisible(1);
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
        switch(sheetNo) {
            case 1:
                with(sheetObj){
                var prefix="txd_";
              
              var HeadTitle1=" |Sel|순번|품명|공급가액|세액|합계";
              var headCount=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"DelChk" },
                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_dtl_ser_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:580,  Align:"Left",    ColMerge:1,   SaveName:prefix+"itm_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"spl_amt",        KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"tax_amt",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"total_amt",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetSheetHeight(120);
                    }


                break;
        }
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     **/ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBROWSEARCH:      
				if(!ComIsSaupjaNo(formObj.spl_rgst_no)) {
					formObj.spl_rgst_no.value="";
					return false;
				}
		    	formObj.f_cmd.value=SEARCH12;
		    	var queryString=FormQueryString(formObj);
		    	var sXml = sheetObj.GetSearchData("ESM_FMS_0022GS.do",queryString);
//		    	alert("sXml=="+sXml);
//		    	var ownrNm=ComGetEtcData(sXml,'ownrNm');
//		    	var coNm=ComGetEtcData(sXml,'coNm');
// 	   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
// 	   			alert("sXml=="+sXml);
//	   			var ownrNm=ComGetEtcData(sXml, "ownrNm");
//	   			var coNm=ComGetEtcData(sXml, "coNm");
//	   			var bzctNm=ComGetEtcData(sXml, "bzctNm");
//	   			var bztpNm=ComGetEtcData(sXml, "bztpNm");
//	   			var splAddr=ComGetEtcData(sXml, "splAddr");
//	   			var vndrSeq=ComGetEtcData(sXml, "vndrSeq");
	   			if(typeof vndrSeq == "undefined" || vndrSeq == "" ) {
	   				formObj.spl_rgst_no.value="";
	   				ComAlertFocus(formObj.spl_rgst_no, ComGetMsg("FMS01453"));
	   				return;
	   			}
	   			if(typeof ownrNm != "undefined" && ownrNm != "" ) {
					formObj.ownr_nm.value=ownrNm;
				} else {
					formObj.ownr_nm.value="";
					return;
				}
	   			if(typeof coNm != "undefined" && coNm != "" ) {
					formObj.co_nm.value=coNm;
				} else {
					formObj.co_nm.value="";
					return;
				}
	   			if(typeof bzctNm != "undefined" && bzctNm != "" ) {
					formObj.bzct_nm.value=bzctNm;
				} else {
					formObj.bzct_nm.value="";
					return;
				}
	   			if(typeof bztpNm != "undefined" && bztpNm != "" ) {
					formObj.bztp_nm.value=bztpNm;
				} else {
					formObj.bztp_nm.value="";
					return;
				}
	   			if(typeof splAddr != "undefined" && splAddr != "" ) {
					formObj.spl_addr.value=splAddr;
				} else {
					formObj.spl_addr.value="";
					return;
				}
	   			break;
        }
    }
    /**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="-";
    	//Axon Event Handling1. Event catch
    	axon_event.addListener  ('change', 'spl_rgst_no_change', 'spl_rgst_no');	// Getting Name information after inserting Vessel Code
        axon_event.addListenerForm  ('blur'            ,'obj_deactivate', form); 	//- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
        axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); 	//- form Code Handling to onkeypress Event of All Controls having dataformat attribute
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , form); 	//- form Code Handling to onkeypress Event of All Controls having dataformat attribute
        if(form.evid_tp_cd.value == "4") {
        	document.all.l_evid_tp_cd.style.display="none";
        	form.tax_pl_cd[0].checked=true;
        	sheetObjects[0].SetColHidden("txd_tax_amt",1);
        }
        /*
        CoFmsGetBizCombo('FORM', document.form, sheetObjects[0], 'ofc_cd', 'ofc_nm', '11', 'ESM_FMS_0022GS.do', '');
        if(opener.sheetObjects[1].RowCount()> 0) {
        	setTaxEvidenceData();
        } else {
        	setOfcCd();
        }
        */
    }
    //Axon Event Handling2. Event Handling Function --- start
    /**
     * Only insert Numeric by onkeypress Event of HTML Control <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
			default:
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    /**
     * Only insert English and Numefic by onkeypress Event of HTML Control <br>
     **/
    function eng_keypress() {
        ComKeyOnlyAlphabet('upper');
    }
    /**
     * Only insert English and Numefic by onkeypress Event of HTML Control <br>
     **/
    function eng_num_keypress() {
        ComKeyOnlyAlphabet('uppernum');
    }
    /**
     * Checking Validation in onblur Event of HTML Control <br>
     **/
    function obj_deactivate(){
    	if(event.srcElement.name == "iss_dt") {
    		var tax_inv_yrmon=form.tax_inv_yrmon.value.trimAll('-');
    		if(tax_inv_yrmon == "") {
    			ComAlertFocus(form.tax_inv_yrmon, ComGetMsg('FMS01469'));
    			form.iss_dt.value="";
    			return;
    		} else {
	    		var iss_dt=form.iss_dt.value.trimAll('-');
	    		if(iss_dt != "") {
		    		if(tax_inv_yrmon.substring(0,6) != iss_dt.substring(0,6)) {
		    			form.iss_dt.value="";
		    			ComAlertFocus(form.iss_dt, ComGetMsg('FMS01468'));
		    			return;
		    		}
	    		}
    		}
    	}
    	switch(event.srcElement.name){
	    	case "tax_inv_yrmon": 
	    	case "iss_dt": 	
	    	case "spl_rgst_no":
//	    		ComChkObjValid(event.srcElement);
    		break;
    	}
    }
    /**
     * Removing Mask Separator in onfocus Event of HTML Control <br>
     **/
    function obj_activate(){
    	ComClearSeparator(event.srcElement);
    }
    /**
     * Checking in case of changing registration of enterpreneur Number <br>
     **/
    function spl_rgst_no_change() {
    	ComChkObjValid(event.srcElement);
    	form.ownr_nm.value="";
   		form.co_nm.value="";
   		form.bzct_nm.value="";
   		form.bztp_nm.value="";
   		form.spl_addr.value="";
    	if (form.spl_rgst_no.value != "") {
    		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'spl_rgst_no');
       	}
    }
    /**
     * Calculating Sum of IBSheet Object <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} sheetObj    IBSheet Row
     **/
 	function sheet1_OnChangeSum(sheetObj, Row) {
 		//sheetObj.SumText(0,"Seq") = "";
// alert("sum=>"+sheetObj.GetSumText(0,"txd_spl_amt"));
 		//sheetObj.SumText(0,"bnk_prc_amt") = "Sub-Total Amount";
 	}
 	/**
     * Event occurred when value of cell is changed <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	selected Row of sheetObj
     * @param {ibsheet} col     	selected Col of sheetObj
     **/
	function sheet1_OnChange(sheetObj,row,col,value) {
		var prefix="txd_";
		if(sheetObj.ColSaveName(col)==prefix + "spl_amt") {
	  		var splAmtCol=sheetObjects[0].SaveNameCol(prefix+"spl_amt");
	  		var splAmtValue=sheetObjects[0].GetCellValue(row,splAmtCol);
	  		if(form.tax_pl_cd[0].checked) {
	  			sheetObjects[0].SetCellValue(row,prefix+"tax_amt",0);
	  			sheetObjects[0].SetCellValue(row,prefix+"total_amt",sheetObjects[0].GetCellValue(row,prefix+"spl_amt"));
	  		} else {
	  			sheetObjects[0].SetCellValue(row,prefix+"tax_amt",sheetObjects[0].GetCellValue(row,prefix+"spl_amt") * 0.1);
	  			sheetObjects[0].SetCellValue(row,prefix+"total_amt",parseInt(sheetObjects[0].GetCellValue(row,prefix+"spl_amt")) + parseInt(sheetObjects[0].GetCellValue(row,prefix+"spl_amt")) * 0.1);
	  		}
		}
		setCalculation(prefix, col);
	}
    /**
     * Event occurred when value of cell is changed <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {string}  prefix     	sheetObj's separator
     * @param {ibsheet} col     	selected Col of sheetObj
     * @return none
     **/
    function setCalculation(prefix, col) {
    	var total_spl_amt=0;
		for(var ir=1; ir<=sheetObjects[0].LastRow(); ir++) {
			if(sheetObjects[0].ColSaveName(col)==prefix + "spl_amt") {
		  		var splAmtCol=sheetObjects[0].SaveNameCol(prefix+"spl_amt");
var splAmtValue=sheetObjects[0].GetCellValue(ir,splAmtCol);
		  		total_spl_amt += parseInt(splAmtValue);
			}
		}
		form.spl_amt.value=ComAddComma(total_spl_amt);
		if(form.tax_pl_cd[0].checked) {
			form.tax_amt.value=0;
			form.total_amt.value=ComAddComma(total_spl_amt);
		} else {
			form.tax_amt.value=ComAddComma(total_spl_amt * 0.1);
			form.total_amt.value=ComAddComma(total_spl_amt + total_spl_amt * 0.1);
		}
    }
    /**
     * Handling process for input validation <br>
     * @return {boolean}
     **/
    function validateForm(){
    	var prefix="txd_"; 
        for(var ir=1; ir<=sheetObjects[0].LastRow(); ir++) {
    		var itmNmCol=sheetObjects[0].SaveNameCol(prefix+"itm_nm");
    		var itmNmValue=sheetObjects[0].GetCellValue(ir,itmNmCol);
	  		var splAmtCol=sheetObjects[0].SaveNameCol(prefix+"spl_amt");
	  		var splAmtValue=sheetObjects[0].GetCellValue(ir,splAmtCol);
	  		if(itmNmValue == "") {
	  			ComShowCodeMessage("FMS01449");
	  			sheetObjects[0].SelectCell(ir,prefix+"itm_nm");
	  			sheetObjects[0].ValidateFail(true);
	  			return;
	  		} else if(splAmtValue == "") {
	  			ComShowCodeMessage("FMS01450");
	  			sheetObjects[0].SelectCell(ir,prefix+"spl_amt");
	  			sheetObjects[0].ValidateFail(true);
	  			return;
	  		} else if(itmNmValue != "") {
	  			if(form.tax_div_cd[0].checked) {
	  				if(parseInt(splAmtValue) <= 0) {
			  			ComShowCodeMessage("FMS01451");
			  			sheetObjects[0].SelectCell(ir,prefix+"spl_amt");
			  			sheetObjects[0].ValidateFail(true);
			  			return;	
	  				}
	  			} else {
	  				if(parseInt(splAmtValue) >= 0) {
			  			ComShowCodeMessage("FMS01452");
			  			sheetObjects[0].SelectCell(ir,prefix+"spl_amt");
			  			sheetObjects[0].ValidateFail(true);
			  			return;	
	  				}
	  			}
	  		}
    	}
        if(form.tax_iss_cd[0].checked == false
           && form.tax_iss_cd[1].checked == false) {
        	ComShowCodeMessage("FMS01479");
        	return;
        }
        var tax_inv_yrmon=form.tax_inv_yrmon.value.trimAll('-');
        var iss_dt=form.iss_dt.value.trimAll('-');
        if(tax_inv_yrmon.substring(0,6) != iss_dt.substring(0,6)) {
			form.iss_dt.value="";
			ComAlertFocus(form.iss_dt, ComGetMsg('FMS01468'));
			return;
		}
        return true;
    }
    /**
     * Deleting row <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	variable separator
     * @return none
     **/
 	function rowRemove(sheetObj, prefix) {
 		var sRow=sheetObj.FindCheckedRow(prefix + "DelChk");
 		if (sRow == "") return;
 		var arrRow=sRow.split("|"); //result : "1|3|5|"
 		for (var idx=arrRow.length-2; idx>=0; idx--){
 			var row=arrRow[idx];
 			sheetObj.SetRowHidden(row,1);
 			sheetObj.SetRowStatus(row,"D");
 		}
 		setCalculation(prefix, 4);
 	}
    /**
     * Initializing Grid  <br>
     * @return none
     **/
    function gridReset() {
    	sheetObjects[0].RemoveAll();
    }
    /**
     * Setting Office Code  <br>
     * @return none
     **/
    function setOfcCd() {
    	var length=form.ofc_cd.length;
		if(length > 0) {
			for(var i=0; i<length; i++) {
				if(form.ofc_cd.options[i].value == "SELFAC") {
					form.ofc_cd.selectedIndex=i;
					break;
				}
			}
		}
    }
    /**
     * Setting Hidden Data of Main Page <br>
     * @return none
     **/
    function setTaxEvidenceData() {
    	var prefix="tax_";
    	var csr_no=opener.form.csr_no.value;
    	form.tax_inv_yrmon.value=opener.sheetObjects[1].GetCellText(1,prefix+"tax_inv_yrmon");
    	var ofc_cd=opener.sheetObjects[1].GetCellValue(1,prefix+"ofc_cd")
    	var length=form.ofc_cd.length;
		if(length > 0) {
			for(var i=0; i<length; i++) {
				if(form.ofc_cd.options[i].value == ofc_cd) {
					form.ofc_cd.selectedIndex=i;
					break;
				}
			}
		}
var tax_iss_cd=opener.sheetObjects[1].GetCellValue(1,prefix+"tax_iss_cd");
		if(tax_iss_cd == "PAPER") {
			form.tax_iss_cd[1].checked=true;
		} else {
			form.tax_iss_cd[0].checked=true;
		}
var tax_vat_tp_cd=opener.sheetObjects[1].GetCellValue(1,prefix+"tax_vat_tp_cd");
		if(tax_vat_tp_cd == "1") {
			form.tax_vat_tp_cd[0].checked=true;
		} else {
			form.tax_vat_tp_cd[1].checked=true;
		}
var tax_div_cd=opener.sheetObjects[1].GetCellValue(1,prefix+"tax_div_cd");
		if(tax_div_cd == "1") {
			form.tax_div_cd[0].checked=true;
		} else {
			form.tax_div_cd[1].checked=true;
		}
		if(form.evid_tp_cd.value == "1") {
var tax_pl_cd=opener.sheetObjects[1].GetCellValue(1,prefix+"tax_pl_cd");
			if(tax_pl_cd == "1") {
				form.tax_pl_cd[0].checked=true;
			} else {
				form.tax_pl_cd[1].checked=true;
			}
		}
		form.spl_rgst_no.value=opener.sheetObjects[1].GetCellText(1,prefix+"spl_rgst_no");
		form.ownr_nm.value=opener.sheetObjects[1].GetCellValue(1,prefix+"ownr_nm");
		form.co_nm.value=opener.sheetObjects[1].GetCellValue(1,prefix+"co_nm");
		form.bzct_nm.value=opener.sheetObjects[1].GetCellValue(1,prefix+"bzct_nm");
		form.bztp_nm.value=opener.sheetObjects[1].GetCellValue(1,prefix+"bztp_nm");
		form.spl_addr.value=opener.sheetObjects[1].GetCellValue(1,prefix+"spl_addr");
		form.iss_dt.value=opener.sheetObjects[1].GetCellText(1,prefix+"iss_dt");
		form.spl_amt.value=opener.sheetObjects[1].GetCellText(1,prefix+"spl_amt");
		form.tax_amt.value=opener.sheetObjects[1].GetCellText(1,prefix+"tax_amt");
		form.total_amt.value=opener.sheetObjects[1].GetCellText(1,prefix+"total_amt");
		prefix="txd_";
		for(var ir=1; ir<=opener.sheetObjects[2].LastRow(); ir++) {
			var row=sheetObjects[0].DataInsert(-1);
			if(csr_no != "") {
				ComBtnDisable("btn_rowAdd");
				ComBtnDisable("btn_rowDel");
				ComBtnDisable("btn_confirm");
				ComBtnDisable("btn_new");
				form.tax_inv_yrmon.readOnly=true;
				form.spl_rgst_no.readOnly=true;
				form.iss_dt.readOnly=true;
				form.ofc_cd.disabled=true;
				form.tax_vat_tp_cd[0].disabled=true;
				form.tax_div_cd[0].disabled=true;
				form.tax_pl_cd[0].disabled=true;
				form.tax_vat_tp_cd[1].disabled=true;
				form.tax_div_cd[1].disabled=true;
				form.tax_pl_cd[1].disabled=true;
				document.images["iss_dt_cal"].name="no_iss_dt_cal";
		    	form.iss_dt_cal.style.cursor="default";
		    	document.images["tax_inv_yrmon_cal"].name="no_tax_inv_yrmon_cal";
		    	form.tax_inv_yrmon_cal.style.cursor="default";
				sheetObjects[0].SetCellEditable(ir,prefix+"DelChk",0);
				sheetObjects[0].SetCellValue(ir,prefix+"itm_nm",opener.sheetObjects[2].GetCellValue(ir,prefix+"itm_nm"));
				sheetObjects[0].SetCellValue(ir,prefix+"spl_amt",opener.sheetObjects[2].GetCellValue(ir,prefix+"spl_amt"));
				sheetObjects[0].SetCellEditable(ir, prefix+"itm_nm",0);
				sheetObjects[0].SetCellEditable(ir, prefix+"spl_amt",0);
			} else {
				sheetObjects[0].SetCellValue(ir,prefix+"itm_nm",opener.sheetObjects[2].GetCellValue(ir,prefix+"itm_nm"));
				sheetObjects[0].SetCellValue(ir,prefix+"spl_amt",opener.sheetObjects[2].GetCellValue(ir,prefix+"spl_amt"));
			}
			sheetObjects[0].SetCellValue(ir,prefix+"tax_amt",opener.sheetObjects[2].GetCellValue(ir,prefix+"tax_amt"));
			sheetObjects[0].SetCellValue(ir,prefix+"total_amt",opener.sheetObjects[2].GetCellValue(ir,prefix+"total_amt"));
		}
    }
