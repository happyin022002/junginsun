/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0014.js
*@FileTitle  : Off-Hire Expenses
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends FMS
     * @class Off-Hire Expenses : Charter/Hire Out definition of biz script for creation screen
     */
    
    // common global variables 
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var bunker_vvd="";
    var effDt="";
	var expDt="";
	var preEffDt="";
	var preExpDt="";
	var queryStr="";
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
	            case "btn_add":
	            	if(form.search_yn.value != "Y") return;
	            	//UI개선(201408 민정호)
	            	var bunker_vvd=document.form.bunker_vvd[document.form.bunker_vvd.selectedIndex].value.substring(0,9);
	            	var eff_dt=formObject.eff_dt.value;
	            	var exp_dt=formObject.exp_dt.value;
	            	var to_time=formObject.to_time.value;
	            	if(to_time == "00:00") {
	            		exp_dt=ComGetDateAdd(exp_dt, 'D', -1);
	            	}
					var row=sheetObject2.DataInsert(-1);
					sheetObject2.SetDataLinkMouse("inv_acct_itm_nm",1);
					sheetObject2.SetCellEditable(row, "inv_curr_cd",1);
					sheetObject2.SetCellEditable(row, "inv_inv_amt2",0);
					sheetObject2.SetCellEditable(row, "inv_inv_desc",1);
					
					sheetObject2.SetCellValue(row,"inv_flet_ctrt_no" ,formObject.flet_ctrt_no.value);
					sheetObject2.SetCellValue(row,"inv_slp_tp_cd" ,"N");
					sheetObject2.SetCellValue(row,"inv_inv_seq" ,formObject.inv_seq.value);
					sheetObject2.SetCellValue(row,"inv_flet_iss_tp_cd" ,"OFF");
					sheetObject2.SetCellValue(row,"inv_inv_desc" ,"Off-hire "+bunker_vvd+" ("+eff_dt+" ~ "+exp_dt+")");
					
					var inv_dtl_seq=getMaxInvDtlSeq(sheetObject2);
					if(inv_dtl_seq == "") {
						inv_dtl_seq=1;
					} else {
						inv_dtl_seq=parseInt(inv_dtl_seq) + 1;
					}
					sheetObject2.SetCellValue(row,"inv_inv_dtl_seq" ,inv_dtl_seq);
                    break;
	            case "btn_del":
	            	if(checkBoxCheckYn(sheetObject2, "inv_DelChk")) {
	            		rowRemove(sheetObject2, "inv_");
	            	}
                    break;
                case "btn_delete":
                	rowRemove(sheetObject2, "inv_");
                    break;
				case "btn_new":
					if(!initConfirm()) return;
					clearAll("NEW");
					durationReset();
					setPrintBtn("H");
                    break;
				case "btn_save":
					doActionIBSheet(sheetObject2,formObject,IBSAVE);
                    break;
				case "btn_delete2":
					doActionIBSheet(sheetObject2,formObject,IBDELETE);
                    break;
				case "btn_print":
					//RD Open
					rdOpen(formObject);
                    break;
				case "btn_vslpop" :
					ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0022");
            		break;
				case "contract_no":
					if(formObject.vsl_cd.value == "") {
						ComAlertFocus(vsl_cd, ComGetMsg('FMS01138'));
						return;
					}
					
					clearAll("CTRT"); //NYK Modify 2014.10.17
					
					ComOpenPopup("ESM_FMS_0023.do?typeFlag=TI&vsl_cd=" + formObject.vsl_cd.value, 520, 415,"setContractNo", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0023");
					 break;
				case "duration":
					if(!formObject.condition[1].checked) return;
					if(formObject.vsl_cd.value == "") {
						ComAlertFocus(vsl_cd, ComGetMsg('FMS01138'));
						return;
					} else if(formObject.flet_ctrt_no.value == "") {
						ComShowMessage(ComGetMsg('FMS01154'));
						return;
					}
					if(formObject.inv_seq.value != "") {
						if(formObject.eff_dt.value == "") {
							comboReset();
						}
						gridReset();
						document.all.totalAmount.style.display="none";
						document.all.btn_print.style.display="none";
					}
					ComOpenPopup("ESM_FMS_0078.do?flet_ctrt_no=" + formObject.flet_ctrt_no.value, 500, 375, "setDuration", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0078");
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
       comboObjects[comboCnt++]=combo_obj;
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
        sheet2_OnLoadFinish(sheet2);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * adding first-served functions after loading screen.
     */
    function sheet2_OnLoadFinish(sheetObj) {   
    	sheetObj.SetWaitImageVisible(0);
		CoFmsGetCombo('FORM', document.form, sheetObj, 'CD01523', 'flet_offh_rsn_cd', 'flet_offh_rsn_nm');
		sheetObj.SetWaitImageVisible(1);
    }

    /**
     * Initializing IBMultiCombo Object <br>
     * In case there are serveral IBMultiCombo, adding case as number of IBMultiCombo  <br>
     * This function is called by {@link #loadPage} to initialize IBMultiCombo <br>
     * @param {ibmulticombo}    comboObj      IBTab Object
     * @param {int}             comboNo       Sequence number of comboObjects Array
     **/
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "boo_rcv_term_cd1":    //R/D Term
            case "pay_hir_no": 
                var i=0;
                comboObj.InsertItem(i++, "Y|CY",            "Y");
                comboObj.InsertItem(i++, "D|Door",          "D");
                comboObj.InsertItem(i++, "S|CFS",           "S");
                comboObj.InsertItem(i++, "H|C' Haul on CY", "H");
                comboObj.InsertItem(i++, "T|Tackle",        "T");
                comboObj.InsertItem(i++, "I|Free In",       "I");
                comboObj.InsertItem(i++, "M|Mixed",         "M");
                comboObj.SetSelectCode("Y");
                break;            
            case "boo_usa_cstms_file_cd":   //Filer
            case "boo_cnd_cstms_file_cd":
                var i=0;
                comboObj.InsertItem(i++, "1|Carrier Filing NVO", "1");
                comboObj.InsertItem(i++, "2|Self Filing NVO", "2");
                comboObj.InsertItem(i++, "3|Not Application", "3");
                comboObj.SetSelectCode("1");
                break;
        }
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
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Text",      Hidden:0,  Width:750,  Align:"Left",    ColMerge:0,   SaveName:prefix+"acct_itm_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                 {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:prefix+"otr_expn_amt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 } ];		           
		          InitColumns(cols);		
		          SetEditable(0);
		          //FitColWidth("32|13|13|8|34");
		          SetSheetHeight(120);
                }
            break;
            case "sheet2":      //t1sheet1 init
                with(sheetObj){
		                var prefix="inv_";
		              var HeadTitle="|Sel|Seq|Item Name|Account Code|Cur 1|Amount|Cur 2|Amount|Approval|Description|FletCtrtNo|FletIssTpCd|InvSeq|InvDtlSeq|AcctItmSeq|Ori Amount|Ori Amount2|From Date|To Date|Inv Usd Dys|Sort Key|Fir Amount|Fir Amount2";
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
		                     {Type:"Seq",        Hidden:0, Width:33,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
		                     {Type:"Popup",      Hidden:0, Width:203,  Align:"Left",    ColMerge:0,   SaveName:prefix+"acct_itm_nm",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",       Hidden:0, Width:93,   Align:"Center",  ColMerge:0,   SaveName:prefix+"acct_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",       Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		                     {Type:"Float",      Hidden:0, Width:99,   Align:"Right",   ColMerge:0,   SaveName:prefix+"inv_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
		                     {Type:"Text",       Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		                     {Type:"Float",      Hidden:0, Width:99,   Align:"Right",   ColMerge:0,   SaveName:prefix+"inv_amt2",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
		                     {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slp_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",       Hidden:0, Width:247,  Align:"Left",    ColMerge:0,   SaveName:prefix+"inv_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
		                     {Type:"Text",       Hidden:1, Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"flet_ctrt_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",       Hidden:1, Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"flet_iss_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",       Hidden:1, Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",       Hidden:1, Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_dtl_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",       Hidden:1, Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"acct_itm_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",       Hidden:1, Width:99,   Align:"Right",   ColMerge:0,   SaveName:prefix+"ori_inv_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",       Hidden:1, Width:99,   Align:"Right",   ColMerge:0,   SaveName:prefix+"ori_inv_amt2",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",       Hidden:1, Width:99,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",       Hidden:1, Width:99,   Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",       Hidden:1, Width:99,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_usd_dys",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",       Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sort_key",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",       Hidden:1, Width:99,   Align:"Right",   ColMerge:0,   SaveName:prefix+"fir_inv_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",       Hidden:1, Width:99,   Align:"Right",   ColMerge:0,   SaveName:prefix+"fir_inv_amt2",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 }];		               
		              InitColumns(cols);		
		              SetEditable(1);
		              SetShowButtonImage(1);
//		              SetSheetHeight(160);
		              resizeSheet();
					  SetColProperty(prefix+"curr_cd", {AcceptKeys:"E" , InputCaseSensitive:1} );
					  SetColProperty(prefix+"curr_cd2", {AcceptKeys:"E" , InputCaseSensitive:1} );					  
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
    function doActionIBSheet(sheetObj,formObj,sAction,kind,row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      
        		if(!validateForm(sheetObj,formObj,sAction,""))  return true;
        	   	if(formObj.condition[1].checked) {
        	   		formObj.f_cmd.value=SEARCH01;
        	   		var aryPrefix=new Array("inv_", "");
        	   	} else {
        	   		var length=document.form.bunker_vvd.options.length;
        	   		if(length < 1) {
        	   			ComShowMessage(ComGetMsg('FMS01155'));
        	   			return;
        	   		}
        	   		document.all.btn_delete2.style.display="none";
        	   		declaration_click();
        	   		formObj.f_cmd.value=SEARCH;
        	   		var aryPrefix=new Array("inv_", "");
        	   	}
        	   	var sXml=sheetObj.GetSearchData("ESM_FMS_0014GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
    			var arrXml=sXml.split("|$$|");
    			if (arrXml.length > 0){
    				var varDupFlg = ComGetEtcData(arrXml[0], "DUP_FLG");
    	   			
    	   			if(typeof varDupFlg != "undefined" && varDupFlg != "" && varDupFlg == "Y") {
    	   				ComShowMessage(ComGetMsg('FMS20006')); //Offhire data is duplicated. please check the duration.
    	   				//ComShowMessage("Your input offhire data is duplicated in data base. aaa");
    	   				return;
    				}else{
    					sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
    				}
    			}
    			if (arrXml.length > 0) {    				
					var list=ComFmsSheetXml2ListMap(arrXml[1]);
					var totalAmtHtml=ComFmsMakeTotalAmtHtml(list);
					var arrTotalAmtHtml=totalAmtHtml.split("|$$|");
					if (arrTotalAmtHtml.length > 0) {
						document.all.totalAmount.style.display="";
						document.all.totalAmount1.innerHTML=arrTotalAmtHtml[0];
						document.all.totalAmount2.innerHTML=arrTotalAmtHtml[1];
					}    		
				}
    			formObj.search_yn.value="Y";
    			var val="";
    			if(formObj.condition[1].checked) {
    				val="I";
    				setPrintBtn();
    			}
    			setDurationReadOnly(val);
                break;
			case IBSAVE:
				if(!validateForm(sheetObj,formObj,sAction))  return true;				
				var length=document.form.bunker_vvd.options.length;				
    	   		if(length < 1) {
    	   			ComShowMessage(ComGetMsg('FMS01155'));
    	   			return;
    	   		}
    	   		if(formObj.search_yn.value != "Y") {
					ComShowMessage(ComGetMsg('FMS01230'));
					return;
				}
    	   		if(!formObj.condition[1].checked && !gridDataCount()) {
    	   			ComShowMessage(ComGetMsg('FMS01169'));
    	   			return;
    	   		}    	   		
				var fromDate=ComTrimAll(formObj.eff_dt.value,"-") + ComTrimAll(formObj.from_time.value,":");
	        	var toDate=ComTrimAll(formObj.exp_dt.value,"-") + ComTrimAll(formObj.to_time.value,":");
	        	formObj.ori_eff_dt.value=fromDate;
	            formObj.ori_exp_dt.value=toDate;
				formObj.f_cmd.value=MULTI;								
				//--------------------------------------------------------------------------------------
				if(formObj.condition[1].checked) {
					formObj.ibflag.value="U";
					//UI개선(201408 민정호)
					if(bunker_vvd != formObj.bunker_vvd[formObj.bunker_vvd.selectedIndex].value) {
						for (var ir=1; ir<=sheetObj.LastRow(); ir++){
							if(sheetObjects[1].GetRowStatus(ir) == "R") {
								sheetObjects[1].SetRowStatus(ir,"U");
							}
						}
						var chg_bunker_vvd=formObj.bunker_vvd[formObj.bunker_vvd.selectedIndex].value;
						var eff_dt=formObj.eff_dt.value;
						var exp_dt=formObj.exp_dt.value;
						eff_dt += " "+formObj.from_time.value;
						exp_dt += " "+formObj.to_time.value;
						formObj.inv_desc.value="Off-hire "+chg_bunker_vvd+" ("+eff_dt+" ~ "+exp_dt+")";
						bunker_vvd=chg_bunker_vvd;
					}
					/*T-P
					} else if(formObj.condition[1].checked) { 
					for (var ir=1; ir<=sheetObj.LastRow(); ir++){
						if(sheetObj.GetRowHidden(ir)==false) {
							sheetObj.SetRowStatus(ir,"I");
						}
					}
					*/
        		} else {
					if(formObj.ibflag.value == "I") {
						for (var ir=1; ir<=sheetObj.LastRow(); ir++){
							if(sheetObj.GetRowHidden(ir)==false) {
								sheetObj.SetRowStatus(ir,"I");
							}
						}
					}
				}
				var arrSheets=new Array(sheetObjects[1]);				
				var sParam=ComGetSaveString(arrSheets, true, true);				
				//var sParam = sheetObj.GetSaveString(); 
				if (sheetObj.IsDataModified()&& sParam == "") {
					return; 
				}
				if(formObj.condition[1].checked) {
					var aryPrefix=new Array("inv_", "");
        	   	} else {
        	   		var aryPrefix=new Array("inv_", "");
        	   	}				
				sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
 				var sXml=sheetObj.GetSaveData("ESM_FMS_0014GS.do", sParam);
				var arrXml=sXml.split("|$$|");
				//T-P if(   formObj.condition[0].checked
				//   || formObj.condition[1].checked) {
								
				if(formObj.condition[0].checked) {	
					if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
					if(typeof sheetObjects[1].GetEtcData("invSeq") != "undefined") {
						formObj.inv_seq.value=sheetObjects[1].GetEtcData("invSeq");
					}
					if(typeof sheetObjects[1].GetEtcData("acmmFlg") != "undefined") {
						if(sheetObjects[1].GetEtcData("acmmFlg") == "Y") {
							formObj.acmm_flg.checked=true;
						} else {
							formObj.acmm_flg.checked=false;
						}
					}
					if(typeof sheetObjects[1].GetEtcData("brogFlg") != "undefined") {
						if(sheetObjects[1].GetEtcData("brogFlg") == "Y") {
							formObj.brog_flg.checked=true;
						} else {
							formObj.brog_flg.checked=false;
						}
					}
					if (arrXml.length > 0) {		
						//UI 개발(101308 민정호) 
						var list=ComFmsSheetXml2ListMap(arrXml[1]);
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
					if (arrXml.length > 0) {		
						//UI 개발(101308 민정호)    								
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
			    //Creation/Creation From VMS check then, click Save Button(START)
				if(!formObj.condition[1].checked) {
					formObj.condition[0].checked=false;
					//T-P formObj.condition[1].checked = false;
					formObj.condition[1].checked=true;
					formObj.duration.style.cursor="hand";
					//document.images["duration"].name="duration";
					formObj.duration.name="duration";
					bunker_vvd.disabled=false;
					form.flet_offh_rsn_cd.disabled=false;
					
				}
				
				setConditonBtnText("I");//무조건 Inquiry 조건으로 셋팅한다.
				
			    /*T-P
			    if(formObj.condition[1].checked) {
					formObj.eff_dt.readOnly=true;
					formObj.from_time.readOnly=true;
					formObj.exp_dt.readOnly=true;
					formObj.to_time.readOnly=true;
					formObj.acmm_flg.disabled=true;
					formObj.brog_flg.disabled=true;
					formObj.ef_dt.style.cursor="default";
					formObj.ex_dt.style.cursor="default";
					document.images["ef_dt"].name="no_ef_dt";
					document.images["ex_dt"].name="no_ex_dt";
    	        } */
				if(document.all.btn_delete2.style.display == "none") {
					document.all.btn_delete2.style.display="";
				}
				setPrintBtn();
			    //Creation check then, click Save Button(END)
				break;	 
			 case IBROWSEARCH:     
				 	if(kind == "Vessel") {
		        		if(formObj.vsl_cd.value == "") {
				    		formObj.vsl_eng_nm.value="";
				    		return;
				    	}
		        		sheetObj.SetWaitImageVisible(0);
				    	formObj.f_cmd.value=SEARCH01;
 			   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
			   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
			   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
							formObj.vsl_eng_nm.value=vslEngNm;
							formObj.vsl_cd.readOnly=true;
			   				formObj.btn_vslpop.style.cursor="default";
			   				//document.images["btn_vslpop"].name="no_btn_vslpop";
							formObj.btn_vslpop.name="no_btn_vslpop";
							initDefaultContractNo();//NYK Modify 2014.10.16
						} else {
							formObj.vsl_cd.value="";
							formObj.vsl_eng_nm.value="";
							ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01056'));
							return;
						}
			   			sheetObj.SetWaitImageVisible(1);
		        	} else if(kind == "Contract") {
		        		if(formObj.flet_ctrt_no.value == "") return;
		        		sheetObj.SetWaitImageVisible(0);
		        		var effDt=formObj.eff_dt.value;
		        		var fromTime=formObj.from_time.value;
		        		var expDt=formObj.exp_dt.value;
		        		var toTime=formObj.to_time.value;
		        		var invUsdDys=formObj.inv_usd_dys.value;
				    	formObj.f_cmd.value=SEARCH02;
				    	var aryPrefix=new Array("oli_");
 		        	   	var sXml=sheetObj.GetSearchData("ESM_FMS_0001GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
		    			var arrXml=sXml.split("|$$|");
		    			
		    			//if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		    			if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1});
		    			
		    			// UI개선(201408 민정호)		
						//ComEtcDataToForm2(formObj,sheetObjects[0],"",true);
						//ComEtcDataToForm2(formObj,sheetObjects[0],"hir_",true);
		    			
		    			/*		    			
		    			<SHEET>
		    			<ETC-DATA>
		    			<ETC KEY='fletCtrtNo'><![CDATA[FOS7TI201309002]]></ETC>
		    			<ETC KEY='vslCd'><![CDATA[FOS7]]></ETC>
		    			<ETC KEY='vslEngNm'><![CDATA[Five Ocean Shipping 7 USNYC-ESVLC]]></ETC>
		    			<ETC KEY='fletCtrtTpCd'><![CDATA[T/C In]]></ETC>
		    			<ETC KEY='custCntCd'><![CDATA[]]></ETC>
		    			<ETC KEY='custSeq'><![CDATA[802570]]></ETC>
		    			<ETC KEY='vndrLglEngNm'><![CDATA[FOS Vendor DEHAM]]></ETC>
		    			<ETC KEY='ownrNm'><![CDATA[aaaaaa]]></ETC>
		    			<ETC KEY='acmmRtAmt'><![CDATA[]]></ETC>
		    			<ETC KEY='fletBrogRtAmt'><![CDATA[2.50]]></ETC>
		    			<ETC KEY='acmmFlg'><![CDATA[N]]></ETC>
		    			<ETC KEY='brogFlg'><![CDATA[Y]]></ETC>
		    			<ETC KEY='effDt'><![CDATA[2013-02-01]]></ETC>
		    			<ETC KEY='effDtTime'><![CDATA[00:00]]></ETC>
		    			<ETC KEY='expDt'><![CDATA[2024-08-31]]></ETC>
		    			<ETC KEY='expDtTime'><![CDATA[00:00]]></ETC>
		    			<ETC KEY='hirCurrN1stCd'><![CDATA[USD]]></ETC>
		    			<ETC KEY='hirRtN1stAmt'><![CDATA[12,000.00]]></ETC>
		    			<ETC KEY='hirCurrN2ndCd'><![CDATA[]]></ETC>
		    			<ETC KEY='hirRtN2ndAmt'><![CDATA[]]></ETC>
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
		    			formObj.acmm_rt_amt.value = ComGetEtcData(arrXml[0],"acmmRtAmt");		    			
		    			formObj.flet_brog_rt_amt.value = ComGetEtcData(arrXml[0],"fletBrogRtAmt");
		    			formObj.acmm_flg.value = ComGetEtcData(arrXml[0],"acmmFlg");
		    			formObj.brog_flg.value = ComGetEtcData(arrXml[0],"brogFlg");		    			
		    			formObj.hir_eff_dt.value = ComGetEtcData(arrXml[0],"effDt");
		    			formObj.hir_eff_dt_time.value = ComGetEtcData(arrXml[0],"effDtTime");		    			
		    			formObj.hir_exp_dt.value = ComGetEtcData(arrXml[0],"expDt");		    						    			
		    			formObj.hir_exp_dt_time.value = ComGetEtcData(arrXml[0],"expDtTime");		    			
		    			formObj.hir_hir_curr_n1st_cd.value = ComGetEtcData(arrXml[0],"hirCurrN1stCd");
		    			formObj.hir_hir_rt_n1st_amt.value = ComGetEtcData(arrXml[0],"hirRtN1stAmt");
		    			formObj.hir_hir_curr_n2nd_cd.value = ComGetEtcData(arrXml[0],"hirCurrN2ndCd");
		    			formObj.hir_hir_rt_n2nd_amt.value = ComGetEtcData(arrXml[0],"hirRtN2ndAmt");			    			
		    				    			
//-----------------------------------------------------------------------------------------------------------------		    			
		    					    			
		    			formObj.eff_dt.value="";
		    			formObj.exp_dt.value="";
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
		    			if(formObj.vsl_cd.value == "") {
		    				ComShowMessage(ComGetMsg('FMS01156'));
		    				clearAll();
		    				return;
	    				}
		    			formObj.ibflag.value="I";
		    			var fletCtrtTpCd="";
		    			if(formObj.flet_ctrt_tp_cd.value == "T/C In") {
		    				fletCtrtTpCd="TI"
		    			} else {
		    				fletCtrtTpCd="TO"
		    			}
		    			formObj.flet_ctrt_tp_gb.value=fletCtrtTpCd;
		    			formObj.eff_dt.value=effDt;
		        		formObj.from_time.value=fromTime;
		        		formObj.exp_dt.value=expDt;
		        		formObj.to_time.value=toTime;
		        		formObj.inv_usd_dys.value=invUsdDys;
		        		sheetObj.SetWaitImageVisible(1);
		        	} else if(kind == "Duration") {
		        		if(!validateForm(sheetObj,formObj,sAction,"D"))  return true;
		        		sheetObj.SetWaitImageVisible(0);
				    	formObj.f_cmd.value=SEARCH10;
 			   			var sXml=sheetObj.GetSearchData("ESM_FMS_0014GS.do" , FormQueryString(formObj));
			   			var invUsdDys=ComGetEtcData(sXml, "invUsdDys");
			   			if(typeof invUsdDys != "undefined" && invUsdDys != "" ) {
							formObj.inv_usd_dys.value=invUsdDys;
						}	
			   			sheetObj.SetWaitImageVisible(1);
		        	} else if(kind == "currCd") {
		        		sheetObj.SetWaitImageVisible(0);
		        		formObj.f_cmd.value=SEARCH01;
 		        		var sXml=sheetObj.GetSearchData("ESM_FMS_0076GS.do" , FormQueryString(formObj));
			   			var currCd=ComGetEtcData(sXml, "currCd");
			   			if(typeof currCd == "undefined" || currCd == "") {
			   				ComShowMessage(ComGetMsg('FMS01142'));
			   				var prefix="inv_";
		   					var currCdCol=sheetObj.SaveNameCol(prefix + "curr_cd");
		   					sheetObj.SetCellValue(row,currCdCol,"",0);
		   					sheetObj.SelectCell(row,currCdCol);
			   			} else {
		   					var prefix="inv_";
		   					var currCd=sheetObj.GetCellValue(row, prefix + "curr_cd");
		   					sheetObj.InitCellProperty(sheetObj, row,{ Type:"Float",Align:"Center",Format:"NullFloat"} );
		   				}
			   			sheetObj.SetWaitImageVisible(1);
		        	}
		   			break;
			case IBINSERT:      
                break;
			case IBDELETE:      
				if(!validateForm(sheetObj,formObj,sAction,"Y"))  return true;
				if(!(formObj.condition[1].checked && sheetObj.RowCount()> 0)) return;
				if(!delConfirm()) return;
				formObj.f_cmd.value=REMOVE;
				formObj.ibflag.value="D";
				var sFormParam=FormQueryString(formObj);
				var sParam=sFormParam;
 				var sXml=sheetObj.GetSaveData("ESM_FMS_0014GS.do", sParam);
 				sheetObj.LoadSaveData(sXml);
				clearAll("DEL");
				setPrintBtn("H");
                break;
            	
			case IBSEARCH_ASYNC02: //NYK Modify 2014.10.16
				if(formObj.vsl_cd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdTI; //TI Only
				
				if(formObj.condition[0].checked) {//Creation	 			
					f_query += "&cond_flag=Y";
				}
				
				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

	   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
	   			
	   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
					formObj.flet_ctrt_no.value = varFletCtrtNo;
				}else{
					ComShowCodeMessage("FMS20001","Agreement");
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
		//Axon Event Handling1. Event Catch
		axon_event.addListener  ('click', 'declaration_click', 'acmm_flg', 'brog_flg');    	//Whether Check declaration
		axon_event.addListener  ('click', 'bunker_vvd_click', 'bunker_vvd');    			//bunker_vvd Check
		//axon_event.addListener  ('keypress', 'eng_keypress', 'cust_cnt_cd', 'vsl_cnt_cd', 'oa_rsv_curr_cd');
		//axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd'); //- Input only Upper case English or Numeric when inserting Veesel Code
        axon_event.addListener  ('change', 'cust_seq_change', 'cust_seq');		//Getting Name information after inserting Owner Code
        axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');			//Getting Name information after inserting Vessel Code
        axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); //- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form Code Handling to OnBeforeDeactivate Event of All Controls having dataformat attribute
        //axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form Code Handling to onkeypress Event of All Controls having dataformat attribute
        //CoFmsGetCombo('FORM', document.form, sheetObjects[0], 'CD01523', 'flet_offh_rsn_cd', 'flet_offh_rsn_nm');    	  
    }
    //Axon Event Handling2. Event Handling Function --- start
    /**
     * Bunker Vvd setting <br>
     * @return none
     **/
    function bunker_vvd_click() {
    	var fletCtrtNo=form.flet_ctrt_no.value;
    	var vslCd=form.vsl_cd.value;
    	effDt=form.eff_dt.value;
    	expDt=form.exp_dt.value;
    	if(vslCd == "") {
    		ComAlertFocus(form.vsl_cd, ComGetMsg('FMS01138'));
    		return;
    	} else if(fletCtrtNo == "") {
    		ComShowMessage(ComGetMsg('FMS01154'));
    		return;
    	} else if(effDt.length < 10) {
    		ComAlertFocus(form.eff_dt, ComGetMsg('FMS01157'));
    		return;
    	} else if(expDt.length < 10) {
    		ComAlertFocus(form.exp_dt, ComGetMsg('FMS01157'));
    		return;
    	}
    	setBunkerVvd();
    }
    /**
     * Checking Validation in onblur Event of HTML Control <br>
     **/
    function obj_deactivate(){
    	switch(ComGetEvent("name")){
	    	case "shp_spd_qty": 
	    	case "vsl_dznd_capa": 
	    	case "bse_14ton_vsl_capa": 
	    	case "rf_cntr_plg_qty": 
	    	case "ddwt_cgo_capa_qty": 
	    	case "grs_wgt": 
	    	case "nrt_wgt":
	    	case "cust_seq":
	    		//ComChkObjValid(obj, bMsg, bTrim, bMasked)
    			ComChkObjValid(ComGetEvent(), true, false, false);
    			break;
	    	case "eff_dt":
	    	case "exp_dt":
	    	case "from_time":
	    	case "to_time":
	    		ComChkObjValid(ComGetEvent());
	    		getInvUsdDys();
	    		
	    		if(!form.condition[0].checked) {
	    			setBunkerVvd('C');
	    		}else{
	    			setBunkerVvd();
	    		}
	    		
    			break;
    		default:
    			//ComAddSeparator(ComGetEvent());
    			ComChkObjValid(ComGetEvent());
    	}
    }
    /**
     * Removing Mask Separator in onfocus Event of HTML Control <br>
     **/
    function obj_activate(){
        ComClearSeparator(ComGetEvent());
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
     * Event when click Tab
     * Activiating elements of selected tab
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- Important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
    /**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     Action Code(Example:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL )
     **/
    function validateForm(sheetObj,formObj,sAction,delYn){
    	if(delYn != "D") {	
    		if (!ComChkValid(formObj)) return false;
    	}
    	if(formObj.flet_ctrt_no.value == "") {
 		   ComAlertFocus(formObj.flet_ctrt_no, ComGetMsg('FMS01052'));
 		   return;
    	} 
        if(formObj.condition[1].checked) {
        	if(form.eff_dt.value == "") {
        		ComOpenPopup("ESM_FMS_0078.do?flet_ctrt_no=" + formObj.flet_ctrt_no.value, 500, 375, "setDuration", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0078");
				//ComAlertFocus(form.eff_dt, ComGetMsg('FMS01159'));
				return;
        	}
        } else {
        	if(delYn != "Y") {
	        	if(   ComChkPeriod(ComTrimAll(form.eff_dt.value,"-"), ComTrimAll(form.exp_dt.value,"-")) < 1
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
        	}
        	if(parseFloat(form.inv_usd_dys.value) <= 0) {
        		ComAlertFocus(form.to_time, ComGetMsg('FMS01175'));
        		return;
        	}
        	var fromDate=ComTrimAll(formObj.eff_dt.value,"-") + ComTrimAll(formObj.from_time.value,":");
        	var toDate=ComTrimAll(formObj.exp_dt.value,"-") + ComTrimAll(formObj.to_time.value,":");
        	if(   formObj.eff_dt.value != "" 
               && formObj.from_time.value != "") {
        		formObj.ori_eff_dt.value=fromDate;
            }
            if(   formObj.exp_dt.value != "" 
               && formObj.to_time.value != "") {
            	formObj.ori_exp_dt.value=toDate;
            }
            if(fromDate > toDate) {
            	if(formObj.condition[0].checked) {
            		ComAlertFocus(form.eff_dt, ComGetMsg('FMS01157'));
            	//T-P } else if(formObj.condition[1].checked) {
            	//	ComShowMessage(ComGetMsg('FMS01159'));
            	}
        		return;
        	}
        }
        if(delYn == "Y") {
        	var prefix="inv_";
        	//if (sheetObj.SearchRows <=0) return;
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
		//sheetObj.FitColWidth("32|13|13|8|34");
		//sheetObj.SetColProperty(prefix,{ Type:"curr_cd",Align:"otr_expn_amt"});
		//InitCellProperty(sheetObj, prefix,{ Type:"curr_cd",Align:"otr_expn_amt"} );
	}
	/**
     * Event occurring when clicking Cell <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {string}  prefix     	Variable Separator
     * @param {string}  curSaveName currency saveName
     * @param {string}  amtSaveName amt saveName
     **/
	
	function setInitCellProperty(sheetObj, prefix, curSaveName, amtSaveName, col) {
		for(var ir=1; ir<=sheetObj.LastRow(); ir++) {
			if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + curSaveName))) {
				if(col == null || col == "") {
					sheetObj.InitCellProperty(ir, 8,{ Type:"Null",Align:"Right",Format:"NullInteger"} );
				} else {
					sheetObj.InitCellProperty(ir, col,{ Type:"Null",Align:"Right",Format:"NullInteger"} );
				}
			}
		}
    }
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
    		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + "curr_cd"))) {
 				sheetObj.InitCellProperty(ir, 6,{ Type:"Null",Align:"Right",Format:"NullInteger"} );
			}
    		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + "curr_cd2"))) {
 				sheetObj.InitCellProperty(ir, 8,{ Type:"Null",Align:"Right",Format:"NullInteger"} );
			}
    	}
	}
    /**
     * Getting Biggest unhidden value in IBSheet Grid input values <br>
     * @param {ibsheet} 	sheetObj    IBSheet Object
     * @return {arrExpDt} 	arrExpDt	Biggest To Date
     **/ 
 	function getMaxInvDtlSeq(sheetObj){
 		var arrInvDtlSeq=new Array();
 		var i=0;
 		for (var ir=sheetObj.HeaderRows(); ir<=sheetObj.LastRow(); ir++){
 			arrInvDtlSeq[i++]=sheetObj.GetCellValue(ir,"inv_inv_dtl_seq");
 		}
 		for(var j=0; j<arrInvDtlSeq.length; j++) {
 			for(var k=j; k<arrInvDtlSeq.length; k++) {
 				if(arrInvDtlSeq[j]<arrInvDtlSeq[k]) {
 					var tmp=arrInvDtlSeq[j];
 					arrInvDtlSeq[j]=arrInvDtlSeq[k];
 					arrInvDtlSeq[k]=tmp;
 				}
 			}
 		}
 		return arrInvDtlSeq[0];
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
    	initPreDuration();
		var val;
		var flag;
		if(form.condition[0].checked) {
			val=form.condition[0].value; 
		//T-P } else {
		//	val = form.condition[1].value; 
		}
		if(flag != "DEL" && flag != "CTRT") {
			flag="ALL";
		}
		setCondition(val, flag);
		//sheetObjects[1].CheckAll("inv_DelChk",0);
		form.vsl_cd.readOnly=false;
		form.btn_vslpop.style.cursor="hand";
		//document.images["btn_vslpop"].name="btn_vslpop";
		form.btn_vslpop.name="btn_vslpop";
		form.contract_no.style.cursor="hand";
		//document.images["contract_no"].name="contract_no";
		form.contract_no.name="contract_no";
	    if(flag == "ALL" && flag == "DEL") {
	    	form.duration.style.cursor="hand";
	    	//document.images["duration"].name="duration";
			form.duration.name="duration";
	    }
	    effDt="";
	    expDt="";
	    bunker_vvd.disabled=false;
	    form.flet_offh_rsn_cd.disabled=false;
	    setBunkerVvd('C');
	    document.all.btn_delete2.style.display="none";
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
		// UI개선(201408 민정호)	
		// for (var idx=arrRow.length-2; idx>=0; idx--){
		for (var idx=arrRow.length-1; idx>=0; idx--){			
			var row=arrRow[idx];
			if(sheetObj.GetCellValue(row, prefix+"slp_tp_cd") == "Y") {
				//ComShowMessage("row : ["+row+"] 이미 전표가 생성되었습니다.");
				ComShowMessage(ComGetMsg('FMS01160'));
				sheetObj.CheckAll(prefix+"DelChk",0);
			} else {				
				sheetObj.SetRowHidden(row,1);
				sheetObj.SetRowStatus(row,"D");
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
	function setCondition(val, flag) {
    	initPreDuration();
    	setPrintBtn("H");
		bunker_vvd="";
		form.offh_seq.value="";
		if(flag == "ALL" || flag == "DEL" || flag == "CTRT" ) {//NYK Modify 2014.10.17
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
				val = "C";
			}
			if(flag == "DEL") {
				durationReset();
			}
		} else {
			gridReset();
			durationReset();
		}
		sheetObjects[1].CheckAll("inv_DelChk",0);
		//document.all.btn_delete2.style.display="";

		setConditonBtnText(val);
		
		if(val == "C") {
			//document.getElementById("btn_execute").innerText = "Execute";
			form.eff_dt.readOnly=false;
			form.from_time.readOnly=false;
			form.exp_dt.readOnly=false;
			form.to_time.readOnly=false;
			form.acmm_flg.disabled=false;
			form.brog_flg.disabled=false;
			form.ef_dt.disabled=false;
			form.ex_dt.disabled=false;
			//document.images["ef_dt"].name="ef_dt";
			//document.images["ex_dt"].name="ex_dt";
			form.ef_dt.name="ef_dt";
			form.ex_dt.name="ex_dt";
			form.ef_dt.style.cursor="hand";
			form.ex_dt.style.cursor="hand";
			form.eff_dt.className="input";
	    	form.from_time.className="input";
	    	form.exp_dt.className="input";
	    	form.to_time.className="input";
	    	form.duration.style.cursor="default";
	    	//document.images["duration"].name="no_duration";
			form.duration.name="no_duration";
			document.all.totalAmount.style.display="none";
			form.inv_seq.value="";
			durationReset();
			
			document.all.btn_delete2.style.display = "none";//NYK Modify 2014.10.17
		} else {
			//document.getElementById("btn_execute").innerText = "Search";
			if(flag == "ALL" || flag == "DEL") {
				form.eff_dt.readOnly=false;
				form.from_time.readOnly=false;
				form.exp_dt.readOnly=false;
				form.to_time.readOnly=false;
				form.acmm_flg.disabled=false;
				form.brog_flg.disabled=false;
				form.ef_dt.disabled=false;
				form.ex_dt.disabled=false;
				//document.images["ef_dt"].name="ef_dt";
				//document.images["ex_dt"].name="ex_dt";
				form.ef_dt.name="ef_dt";
				form.ex_dt.name="ex_dt";
				form.ef_dt.style.cursor="hand";
				form.ex_dt.style.cursor="hand";
				form.eff_dt.className="input";
		    	form.from_time.className="input";
		    	form.exp_dt.className="input";
		    	form.to_time.className="input";
		    	form.duration.style.cursor="default";
		    	//document.images["duration"].name="no_duration";
				form.duration.name="no_duration";
		    	document.all.totalAmount.style.display="none";
			} else {
				setDurationReadOnly(val);
				document.all.totalAmount.style.display="none";
			}
			document.all.btn_delete2.style.display = "";//NYK Modify 2014.10.17
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
	  * Inserting Duration <br>
	  * @param {arry} aryPopupData
	  */
	function setDuration(aryPopupData){				
		form.inv_seq.value=aryPopupData[0][5];
		form.eff_dt.value=aryPopupData[0][7];
		form.from_time.value=aryPopupData[0][9];
		form.exp_dt.value=aryPopupData[0][8];
		form.to_time.value=aryPopupData[0][10];
		form.inv_usd_dys.value=aryPopupData[0][11];
		bunker_vvd=aryPopupData[0][6];		
		var length=document.form.bunker_vvd.options.length;
		if(length > 0) {
		    for(var i=0; i<length; i++){ 
		    	document.form.bunker_vvd.options.remove(0); 
		    }
		}		
		setBunkerVvd(bunker_vvd);			
		var flet_offh_rsn_cd=aryPopupData[0][4];		
		//UI개선(201408 민정호)
		var length=form.flet_offh_rsn_cd.length;
		if(length > 0) {
			for(var i=0; i<length; i++) {
				if(form.flet_offh_rsn_cd.options[i].value == flet_offh_rsn_cd) {
					form.flet_offh_rsn_cd.selectedIndex=i;
					break;
				}
			}
		}
		
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
	}
	/**
	  * Inserting Duration (Off-Hire Expenses from VMS)<br>
	  * @param {arry} aryPopupData
	  */
	function setVmsDuration(aryPopupData){
		form.offh_seq.value=aryPopupData[0][16];
		var eff_dt=aryPopupData[0][3];
		var from_time=aryPopupData[0][4];
		var exp_dt=aryPopupData[0][5];
		var to_time=aryPopupData[0][6];
		var inv_usd_dys=aryPopupData[0][7];
		form.eff_dt.value=eff_dt.substring(0,4)+"-"+eff_dt.substring(4,6)+"-"+eff_dt.substring(6,8);
		form.from_time.value=from_time.substring(0,2)+":"+from_time.substring(2,4);
		form.exp_dt.value=exp_dt.substring(0,4)+"-"+exp_dt.substring(4,6)+"-"+exp_dt.substring(6,8);
		form.to_time.value=to_time.substring(0,2)+":"+to_time.substring(2,4);
		getInvUsdDys();
		/*
		if(inv_usd_dys.indexOf(".") == -1) {
			inv_usd_dys=inv_usd_dys+".0000";
		} 
		form.inv_usd_dys.value=inv_usd_dys;
		*/
		setBunkerVvd();
	}
	/**
     * Address Comm / Brokerage Setting <br>
     * @return none
     **/
	function declaration_click() {
    	if(form.acmm_flg.checked) {
    		if(   form.acmm_rt_amt.value == "" 
    		   || form.acmm_rt_amt.value <= 0) {
    			ComAlertFocus(form.acmm_flg, ComGetMsg('FMS01161'));
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
        switch(comboObj.id) {
            case "pay_hir_no":    //HireNo
            	comboObj.RemoveAll();
            	comboObj.SetDropHeight(80);
            	if(comboText != "" ) {
	            	var comboList=comboText.split("|");
	            	for(var i=0; i < comboList.length-1; i++) {
	            		comboObj.InsertItem(i, comboList[i], comboList[i]);
	            	}
	            	comboObj.SetSelectCode(comboList[0]);
            	}
                break;
        } 
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
		var sFromDate=ComTrimAll(form.eff_dt.value,"-") + ComTrimAll(form.from_time.value,":");
		var sToDate=ComTrimAll(form.exp_dt.value,"-") + ComTrimAll(form.to_time.value,":");
		try {
			//In case of String Sequence or HTML Tag(Object)
			var sFromDate=getArgValue(sFromDate);
			var sToDate=getArgValue(sToDate);
			if(sFromDate.length != sToDate.length) return NaN;
			var iFromTime=getDateObj(sFromDate);
			var iToTime=getDateObj(sToDate);
			var differTime=(iToTime - iFromTime) / (60*60*24*1000);
			form.inv_usd_dys.value=differTime.toFixed(4);
			if(form.condition[0].checked) {
				if(preEffDt != "") {
					if(   preEffDt != ComTrimAll(form.eff_dt.value,"-") 
					   || preExpDt != ComTrimAll(form.exp_dt.value,"-")) {
						var length=form.bunker_vvd.options.length;
						if(length > 0) {
						    for(var i=0; i<length; i++){ 
						    	form.bunker_vvd.options.remove(0); 
						    }
						}
					}
				}
			}
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
    	if(ComChkPeriod(ComTrimAll(form.eff_dt.value,"-"), ComTrimAll(form.exp_dt.value,"-")) < 1) {
    		ComShowMessage(ComGetMsg('FMS01159'));
			return;
		}
    	return true;
	}
	/**
     * Duration Setting <br>
     **/
	function setDurationReadOnly(val) {
		form.eff_dt.readOnly=true;
		form.from_time.readOnly=true;
		form.exp_dt.readOnly=true;
		form.to_time.readOnly=true;
		if(val == "V") {
			form.acmm_flg.disabled=false;
			form.brog_flg.disabled=false;
			form.inv_seq.value="";
		} else {
			form.acmm_flg.disabled=true;
			form.brog_flg.disabled=true;
		}
		form.ef_dt.style.cursor="default";
		form.ex_dt.style.cursor="default";
		form.duration.style.cursor="default";
		//document.images["ef_dt"].name="no_ef_dt";
		//document.images["ex_dt"].name="no_ex_dt";
		//document.images["duration"].name="no_duration";
		form.ef_dt.name="no_ef_dt";
		form.ex_dt.name="no_ex_dt";
		form.duration.name="no_duration";
    	form.eff_dt.className="input2";
    	form.from_time.className="input2";
    	form.exp_dt.className="input2";
    	form.to_time.className="input2";
    	if(form.search_yn.value == "Y") {
    		form.contract_no.style.cursor="default";
    		//document.images["contract_no"].name="no_contract_no";
    	}
	    if(val == "I") {
	    	//document.images["duration"].name="duration";
	    	form.duration.name="duration";
	    	form.duration.style.cursor="hand";
	    	bunker_vvd.disabled=false;
	    	form.flet_offh_rsn_cd.disabled=false;
	    } else {
	    	if(val == "C") {
	    		bunker_vvd.disabled=true;
	    		form.flet_offh_rsn_cd.disabled=true;
	    	} else {
	    		if(form.vsl_cd.value == "") {
					ComAlertFocus(form.vsl_cd, ComGetMsg('FMS01138'));
					//T-P form.condition[1].checked = false;
					return;
				} else if(form.flet_ctrt_no.value == "") {
					ComShowMessage(ComGetMsg('FMS01052'));
					//T-P form.condition[1].checked = false;
					return;
				}
	    		if(val == "V" || form.search_yn.value == "") {
		    		var flet_ctrt_no=form.flet_ctrt_no.value;
		    		var vsl_cd=form.vsl_cd.value;
		    		var vsl_eng_nm=form.vsl_eng_nm.value;
		    		//ComOpenPopup("ESM_FMS_0073.do?flet_ctrt_no=" + flet_ctrt_no + "&vsl_cd=" + vsl_cd + "&vsl_eng_nm=" + vsl_eng_nm, 920, 480, "setVmsDuration", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0073");
	    		}
	    	}
	    }
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
		var acctItmNmValue=sheetObj.GetCellValue(row, prefix + "acct_itm_nm");
		var invDtlSeqValue=sheetObj.GetCellValue(row, prefix + "inv_dtl_seq");
		if(acctItmNmValue == "") {
			ComShowMessage(ComGetMsg('FMS01164'));
			sheetObj.SelectCell(row,prefix + "acct_itm_nm");
			sheetObj.ValidateFail(true);
			return;
		} else if(invDtlSeqValue == "") {
			var invAmtValue=ComTrimAll(sheetObj.GetCellValue(row, prefix + "inv_amt"),",");
			var currCdValue=sheetObj.GetCellValue(row, prefix + "curr_cd");
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
				var invAmtValue=ComTrimAll(sheetObj.GetCellValue(row, prefix + "inv_amt"),",");
				var currCdValue=sheetObj.GetCellValue(row, prefix + "curr_cd");
				var sortKeyValue=sheetObj.GetCellValue(row, prefix + "sort_key");
				var firInvAmtValue= ComTrimAll(sheetObj.GetCellValue(row, prefix + "fir_inv_amt"),",");
				/*
				if(currCdValue != "" && (invAmtValue == "" || invAmtValue <= 0)) {
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
				}*/
			} else if(sheetObj.ColSaveName(col)==prefix + "inv_amt2") {
				var invAmt2Value=ComTrimAll(sheetObj.GetCellValue(row, prefix + "inv_amt2"),",");
				var currCd2Value=sheetObj.GetCellValue(row, prefix + "curr_cd2");
				var sortKeyValue=sheetObj.GetCellValue(row, prefix + "sort_key");
				var firInvAmt2Value=ComTrimAll(sheetObj.GetCellValue(row, prefix + "fir_inv_amt2"),",");
				/*if(currCd2Value != "" && (invAmt2Value == "" || invAmt2Value <= 0)) {
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
				}*/
				/*
				if(currCd2Value != "" && (invAmt2Value == "" || invAmt2Value <= 0)) {
					ComShowMessage(ComGetMsg('FMS01163'));
					sheetObj.SelectCell(row,col);
					sheetObj.ValidateFail(true);
				}
				*/
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
		currencyOnChange(sheetObj,row,col,value,"inv_");
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
		if(sheetObj.GetRowStatus(row) == "I") return;
		var prefix="inv_";
		var colAlias=sheetObj.ColSaveName(col);
		if (colAlias==(prefix + "inv_amt")) {
			var oriInvAmtValue=ComTrimAll(sheetObj.GetCellValue(row, prefix + "ori_inv_amt"),",");
			var invAmtValue=ComTrimAll(sheetObj.GetCellValue(row, prefix + "inv_amt"),",");
			var sortKeyValue=sheetObj.GetCellValue(row, prefix + "sort_key");
			var firInvAmtValue=ComTrimAll(sheetObj.GetCellValue(row, prefix + "fir_inv_amt"),",");
			var invDtlSeqValue=sheetObj.GetCellValue(row, prefix + "inv_dtl_seq");
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
			//if(sheetObj.GetCellValue(row, prefix + "acct_cd") != gAcctCdByBrokerage) {
				var currCdValue=sheetObj.GetCellValue(row, prefix + "curr_cd").toLowerCase();
				//NYK Modify 2014.10.30
				var tmpObjId = currCdValue+"_inv_amt";
				var totalAmount=ComTrimAll(ComGetObjAttr(tmpObjId, "value"),",");
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
					ComSetObjAttr(tmpObjId, "value", ComAddComma(parseInt(ComTrimAll(totalInvAmount,","))));
				} else {
					ComSetObjAttr(tmpObjId, "value", totalInvAmount);
				}
				sheetObj.SetCellValue(row,oriInvAmtCol ,invAmtValue, 0);
			//}
		} else if(colAlias==(prefix + "inv_amt2")) {
			var oriInvAmt2Value=ComTrimAll(sheetObj.GetCellValue(row, prefix + "ori_inv_amt2"),",");
			var invAmt2Value=ComTrimAll(sheetObj.GetCellValue(row, prefix + "inv_amt2"),",");
			var sortKeyValue=sheetObj.GetCellValue(row, prefix + "sort_key");
			var firInvAmt2Value=ComTrimAll(sheetObj.GetCellValue(row, prefix + "fir_inv_amt2"),",");
			var invDtlSeqValue=sheetObj.GetCellValue(row, prefix + "inv_dtl_seq");
			/*
			if(sortKeyValue != "3" && (invAmt2Value == "" || invAmt2Value <= 0)) {
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
			}
			*/
			//if(sheetObj.GetCellValue(row, prefix + "acct_cd") != gAcctCdByBrokerage) {
				var currCd2Value=sheetObj.GetCellValue(row, prefix + "curr_cd2").toLowerCase();
				
				//NYK Modify 2014.10.30
				var tmpObj2Id = currCd2Value+"_inv_amt2";
				var totalAmount=ComTrimAll(ComGetObjAttr(tmpObj2Id, "value"),",");
				
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
					ComSetObjAttr(tmpObj2Id, "value", ComAddComma(parseInt(ComTrimAll(totalInvAmount,","))));
				} else {
					//NYK Modify 2014.10.30
					ComSetObjAttr(tmpObj2Id, "value", totalInvAmount);
				}
				sheetObj.SetCellValue(row,oriInvAmt2Col ,invAmt2Value, 0);
			//}
			/*
			if(invAmt2Value == "" || invAmt2Value <= 0) {
				ComShowMessage(ComGetMsg('FMS01163'));
				sheetObj.SelectCell(row,col);
				return;
			}
			var currCd2Col=sheetObj.SaveNameCol(prefix + "curr_cd2");
			var currCd2Value=sheetObj.GetCellValue(row,currCd2Col).toLowerCase();
			var totalAmount=eval("form."+currCd2Value+"_inv_amt2").value.trimAll(",");
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
			eval("form."+currCd2Value+"_inv_amt2").value=totalInvAmount.toFixed(2);
			sheetObj.SetCellValue(row,oriInvAmt2Col ,invAmt2Value);
			*/
		}
	}
	/**
     * Deciding whether Currency Code value is existing in IBSheet input values <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String} 	value    	Inserted value of sheetObj
     * @param {String} 	prefix   	Variable Separator
     * @return none
     * @see #setCurrCd
     **/
    function currencyOnChange(sheetObj,row,col,value,prefix) {
    	if (sheetObj.ColSaveName(col)==(prefix + "curr_cd")) {
            var currCdCol=sheetObj.SaveNameCol(prefix + "curr_cd");
            var currCdValue=sheetObj.GetCellValue(row,currCdCol);
            if(currCdValue == "") return;
            if(currCdValue.length < 3) {
    			ComShowMessage(ComGetMsg('FMS01077'));
	    		sheetObj.SetCellValue(row,currCdCol,"",0);
				sheetObj.SelectCell(row,currCdCol);
				return;
    		}
    		form.curr_cd.value=currCdValue;
    		doActionIBSheet(sheetObjects[1], document.form, IBROWSEARCH, "currCd", row);
    	}
	}
	/**
     * Controlling Scroll bar automatically when searching data  <br>
     **/
    function controlScrollBar() {
		try{
			top.syncHeight()
		} catch(err){ComFuncErrMsg(err.message);}
	}
	/**
     * Checking implemetation when Event is occurred <br>
     * @return {boolean} okYn    okYn:true or okYn:false
     **/
    function initConfirm() {
    	var okYn=true;
    	//if(sheetObjects[0].RowCount > 0 && rowChangeYn()) {
    	if(sheetObjects[1].IsDataModified()) {
    		var okYn=confirm(ComGetMsg('FMS00002'));
    	}
    	return okYn;
    }
    /**
     * Getting Voyage information <br>
     * @param {String} flag    	Initializing(I)
     * @see #CoFmsGetBizCombo
     **/
    function setBunkerVvd(flag) {    	    	
    	if(!checkDuration()) return;
    	var changeYn="Y";
    	var curEffDt=form.eff_dt.value;
    	var curExpDt=form.exp_dt.value;
    	var length= form.bunker_vvd.options.length;
    	if(!form.condition[0].checked) {
    		if(curEffDt != "" && length != 0) return;
    	}
    	if(curEffDt != "") {
	    	if(effDt == curEffDt && expDt == curExpDt) {
	    		changeYn="N";
	    	}
    	}
    	//var length = bunker_vvd.options.length;
    	if(flag == "C" && changeYn == "Y") {
	    	for(var i=0; i<length; i++){ 
	    		form.bunker_vvd.options.remove(0); 
	    	}
	    	return;
    	} else {
    		if(length > 0) return;
    	}    	
    	CoFmsGetBizCombo('FORM', document.form, sheetObjects[0], 'bunker_vvd', 'bunker_vvd_text', '2', 'ESM_FMS_0014GS.do', 'FMS01232');
    	if(form.condition[0].checked) {
    		preEffDt=ComTrimAll(form.eff_dt.value,"-");
        	preExpDt=ComTrimAll(form.exp_dt.value,"-");
    	}    	
    	if(typeof flag != "undefined") {
	    	if(flag.length == 10) {
    			for(var i=0; i<flag.length; i++) {
    				if(form.bunker_vvd.options[i].value == flag) {
    					form.bunker_vvd.selectedIndex=i;
    					break;
    				}
    			}
	    	}
    	}    	
    }
    /**
     * Calling Popup(Item Name) <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     * @see #setProgramNo
     **/
	function sheet2_OnPopupClick(sheetObj,Row,Col){
		if(sheetObj.GetRowStatus(Row) == "I") {
			ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=OF", 550, 450, "setProgramNo", "1,0,1,1,1,1", true, false, Row, Col, 0);
		} else {
			return;
		}
	}
	/**
	 * Inserting programNo<br>
	 * @param {arry} aryPopupData
	 */
	function setProgramNo(aryPopupData, row, col, sheetIdx){
		//UI개선(201408 민정호)
		
		sheetObjects[1].SetCellValue(row,col,aryPopupData[0][2],0);
	    sheetObjects[1].SetCellValue(row,"inv_acct_cd",aryPopupData[0][3],0);
	    sheetObjects[1].SetCellValue(row,"inv_acct_itm_seq",aryPopupData[0][4],0);
	}
	/**
     * Initializing all Object in document <br>
     * IBSheet.RemoveAll()처리한다.<br>
     * @return none
     * @see #ComClearManyObjects
     */
    function gridReset(){
        try {
        	sheetObjects[1].RemoveAll();
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
     * Initializing ComboBox in document (VVD CD/Accident Type)<br>
     * @return none
     * @see #ComClearManyObjects
     */
    function comboReset(){
        try {
        	if(typeof bunker_vvd.options != "undefined"){
        		var length=bunker_vvd.options.length;
		    	for(var i=0; i<length; i++){ 
		    		bunker_vvd.options.remove(0); 
		    	}
        	}
	    	form.flet_offh_rsn_cd.selectedIndex=0;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
     * Initializing Object relevant to Duration in document <br>
     * @return none
     */
    function durationReset() {
    	form.eff_dt.value="";
    	form.from_time.value="";
    	form.exp_dt.value="";
    	form.to_time.value="";
    	form.inv_usd_dys.value="";
    	var length=document.form.bunker_vvd.options.length;
    	for(var i=0; i<length; i++){ 
    		document.form.bunker_vvd.options.remove(i); 
    	}
    	document.form.flet_offh_rsn_cd.selectedIndex=0;
    }
    /**
     * Checking Duration <br>
     * @return boolean true:inserted, false:not inserted
     */
    function checkDuration() {
    	if(form.inv_usd_dys.value != "") {
    		return true;
    	} else {
    		return false;
    	}
    }
    /**
     * Checking saving data <br>
     * @return boolean true:Existing, false:not Existing
     */ 
    function gridDataCount() {
    	if(sheetObjects[1].RowCount()> 0) {
    		for(var ir=sheetObjects[1].HeaderRows(); ir<=sheetObjects[1].LastRow(); ir++) {
				if(sheetObjects[1].GetRowHidden(ir)==false) {
					return true;
					break;
				}
			}
    		return false;
    	} else {
    		return false;
    	}
    }
    /**
     * Controlling Print Button <br>
     */ 
    function setPrintBtn(flag) {
    	if(flag == "H") {
    		document.all.btn_print.style.display="none";
    	} else {
	    	if(form.condition[1].checked && sheetObjects[1].RowCount()> 0) {
	    		document.all.btn_print.style.display="";
	    	}
    	}
    }
    /**
     * Initializing History Duration <br>
     */ 
    function initPreDuration() {
    	preEffDt="";
    	preExpDt="";
    }
    /**
     * Printing RD <br>
     * @param  {ibsheet} rdObject    IBSheet Object
     * @param  {Object}  formObject  FormObject 
     * @return none
     **/
	function rdOpen(formObject){
		//Accident Type
		formObject.flet_offh_rsn_nm.value=form.flet_offh_rsn_cd.options[form.flet_offh_rsn_cd.selectedIndex].text;
  		
 		var rdParam = '/rv '+ RD_FormQueryString(formObject,1);
		var rdFile = 'apps/opus/esm/fms/timecharterinoutaccounting/tcharterioinvoice/report/ESM_FMS_015.mrd';

 		formObject.com_mrdPath.value = rdFile;
 		formObject.com_mrdArguments.value = rdParam;
 	    ComOpenRDPopup();
	}	

    //NYK Modify 2014.10.16
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }
    
	function test(){
		bunker_vvd_click();
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[1], 60);
	}
	
	
	