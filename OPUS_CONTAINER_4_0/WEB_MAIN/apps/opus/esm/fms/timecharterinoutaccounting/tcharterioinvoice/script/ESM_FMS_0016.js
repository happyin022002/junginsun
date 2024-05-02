/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0016.js
*@FileTitle  : Charterer's Expenses
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Charterer's Account : Charterer's Account definition of biz script for creation screen
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
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if (!ComIsBtnEnable(srcName)) return;             //버튼 상태를 확인을 합니다.
            switch(srcName) {
            	case "btn_sdms":
            		if(!validateForm(sheetObject,formObject)) return;
            		initCheckBox(sheetObject, "inv_");
            		for (var ir=sheetObject.LastRow(); ir>=sheetObject.HeaderRows(); ir--) {
            			if(sheetObject.GetCellValue(ir,"inv_pop_gb") == "SDMS") {
	        				sheetObject.SetCellValue(ir,"inv_DelChk",1,0);
	        				rowRemove(sheetObject, "inv_");
	        			}
	        		}
            		sheetObjects[1].RemoveAll();
            		var flet_ctrt_no=formObject.flet_ctrt_no.value;
            		var vsl_cd=formObject.vsl_cd.value;
            		var vsl_eng_nm=formObject.vsl_eng_nm.value;
            		var ownr_nm=formObject.ownr_nm.value;
            		var cust_cnt_cd=formObject.cust_cnt_cd.value;
            		var cust_seq=formObject.cust_seq.value;
            		ComOpenPopup("ESM_FMS_0017.do?flet_ctrt_no="+flet_ctrt_no+"&vsl_cd="+vsl_cd+"&vsl_eng_nm="+vsl_eng_nm+"&ownr_nm="+escape(ownr_nm)+"&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq, 1150, 520,"setSDMS", "0,1", true, false, 0, 0, 0, "ESM_FMS_0017");
                    break;
				case "btn_add":
					if(!validateForm(sheetObject,formObject)) return;
					var row=sheetObject.DataInsert(-1);
					sheetObject.SetCellText(row,"inv_slp_tp_cd" ,"N");
					sheetObject.SetCellText(row,"inv_flet_ctrt_no" ,formObject.flet_ctrt_no.value);
					var inv_dtl_seq=getMaxInvDtlSeq(sheetObject);
					if(inv_dtl_seq == "") {
						inv_dtl_seq=1;
					} else {
						inv_dtl_seq=parseInt(inv_dtl_seq) + 1;
					}
					sheetObject.SetCellText(row,"inv_inv_dtl_seq" ,inv_dtl_seq);
					sheetObject.SetCellText(row,"inv_inv_seq" ,"1");
					inputReadOnly();
                    break;
				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "inv_DelChk")) {
						rowRemove(sheetObject,"inv_");
					}
                    break;
				case "btn_retrieve":
					if(!initConfirm()) return;
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
				case "btn_new":
					if(!initConfirm()) return;
					ComBtnEnable("btn_sdms");
					clearAll();
                    break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
				case "btn_savetofile":
					if(sheetObject.RowCount() < 1){//no data	
						ComShowCodeMessage("COM132501");
					}else{	
						 sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
					}	
                    break;
				case "from_inv_dt": 
					var cal=new ComCalendar();
					cal.select(form.from_chtr_inv_dt, 'yyyy-MM-dd');
					break;
				case "to_inv_dt":
					var cal=new ComCalendar();
					cal.select(form.to_chtr_inv_dt, 'yyyy-MM-dd');	
					break;
				case "btn_vslpop":
					clearAll(); //NYK Modify 2014.10.21
					ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0022");
					break;
				case "contract_no":
					if(formObject.vsl_cd.value == "") {
						ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01138'));
						return;
					}
					
					clearAll("CTRT");//NYK Modify 2014.10.21
					
					ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value, 520, 415,"setContractNo", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0023");
					break;
				case "item_name":
					ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=CH", 550, 450, "setItemNm", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0076");
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
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        initControl();
        $("#vsl_cd").blur(function(){
        	vsl_cd.onchange();
        });
        
        //resizeSheet();        
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
            case 1:      //sheet1 init
                with(sheetObj){
		                var prefix="inv_";
//		              (19, 0, 0, true);
		              var HeadTitle="|Sel|Seq|Item Name|Account Code|Curr|Amount|Approval|Invoice DT|Invoice No.|VVD CD|Description|Acct Item Seq|Contract No|FletIssTpCd|InvSeq|InvDtlSeq|SDMS No|PopGb";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
		                     {Type:"Popup",     Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"acct_itm_nm",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:97,   Align:"Center",  ColMerge:0,   SaveName:prefix+"acct_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                     {Type:"Float",     Hidden:0,  Width:88,   Align:"Right",   ColMerge:0,   SaveName:prefix+"inv_amt",        KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slp_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix+"chtr_inv_dt",    KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"to_inv_no",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_vvd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"inv_desc",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"acct_itm_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"flet_ctrt_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"flet_iss_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_dtl_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sdms_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pop_gb",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetDataLinkMouse(prefix + "acct_itm_nm",1);
		              SetShowButtonImage(2);
		              //SetSheetHeight(410);
		              SetColProperty(prefix+"curr_cd", {AcceptKeys:"E" , InputCaseSensitive:1} );
					  resizeSheet();
              }
                break;
            case 2:      //sheet2 init
                with(sheetObj){
		                var prefix="sdms_";
		              var HeadTitle="| |SDMS No.|Currency|Amount|INV No.|SDMS Date|Description|Status Cd|SHP_OWNR_CO_NM|PAY_ACCT_NO|CRE_USR_ID";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"DelChk" },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_locl_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bil_inv_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                     {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_stl_proc_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"shp_ownr_co_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_acct_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
//		              SetSheetHeight(410);
//		              resizeSheet();
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
    function doActionIBSheet(sheetObj,formObj,sAction,gubun,row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:     
        		if(validateForm(sheetObj,formObj,sAction)){
       	   	  		formObj.f_cmd.value=SEARCH;
       	   	  		var aryPrefix=new Array("inv_", "");
       	   	  		var sXml=sheetObj.GetSearchData("ESM_FMS_0016GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));       	   	  		       	   	  		
       	   	  		var arrXml=sXml.split("|$$|");
			   		if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );			   		
			   		var totalAmount1="";
			   		if (arrXml.length > 0) {		
						var list=ComFmsSheetXml2ListMap(arrXml[1]);
						totalAmount1=ComFmsMakeTotalAmtHtml(list, "1");			   							   				   		
					}			   					   		
			   		if((typeof totalAmount1 != "undefined" && totalAmount1 != "")) {
			   			setTotalAmount(totalAmount1);
	 				} else {
	 					document.all.totalAmount.style.display="none";
	 				}
			   		inputReadOnly();
       	   	  	}
                 break;
			 case IBSAVE:       
				 if(validateForm(sheetObj,formObj,sAction)) {
				     formObj.f_cmd.value=MULTI;
				     var arrSheets=new Array(sheetObjects[0], sheetObjects[1]);
					 var sParam=ComGetSaveString(arrSheets);
					 if (sParam == "") return;
					 setItemClear();
					 //var aryPrefix = new Array("inv_", "sdms_");
				     var aryPrefix=new Array("inv_", "", "sdms_");
				     sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
				     var sXml=sheetObj.GetSaveData("ESM_FMS_0016GS.do", sParam);
				     var arrXml=sXml.split("|$$|");
				     if (arrXml.length > 0) {
				    	 sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				    	 sheetObjects[1].RemoveAll();
				     }
				     var totalAmount1="";
			   		 if (arrXml.length > 0) {		
					     var list=ComFmsSheetXml2ListMap(arrXml[1]);
					     totalAmount1=ComFmsMakeTotalAmtHtml(list, "1");					   	
					 }
				     if((typeof totalAmount1 != "undefined" && totalAmount1 != "")) {
				    	 setTotalAmount(totalAmount1);
	 				 } else {
	 				     document.all.totalAmount.style.display="none";
	 				 }
				 }
				 break;
			 case IBROWSEARCH:  
				if(gubun == "Vvd") {
					formObj.f_cmd.value=SEARCH01;
					var sXml=sheetObj.GetSearchData("ESM_FMS_0016GS.do" , FormQueryString(formObj));
		   			var vvd=ComGetEtcData(sXml, "vvd");
		   			if(typeof vvd != "undefined" && vvd != "") {
		   				var iType = sheetObj.GetCellProperty(row, "inv_bunker_vvd", "Type");
		   				if(iType!="Combo"){
		   	        		sheetObj.SetCellText(row, "inv_bunker_vvd" ,"");
		   	        	}
		   				
	    				var comboText=vvd;
	    				setVvdMakeCombo(sheetObj, comboText, row);
	    			} else {
	    				ComShowMessage(ComGetMsg('FMS01144'));
	    				sheetObj.SelectCell(row, "inv_chtr_inv_dt");
	    			}
				} else if(gubun == "Contract") {
					var acctItmNm=form.acct_itm_nm.value;
    				var acctCd=form.acct_cd.value;
    				var acctItmSeq=form.acct_itm_seq.value;
    				var fromChtrInvDt=form.from_chtr_inv_dt.value;
    				var toChtrInvDt=form.to_chtr_inv_dt.value;
					formObj.f_cmd.value=SEARCH05;
					var sXml=sheetObj.GetSearchData("ESM_FMS_0001GS.do" , FormQueryString(formObj));
		   			var arrXml=sXml.split("|$$|");
	    			if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	    			ComEtcDataToForm2(formObj,sheetObjects[0],"",true);
	    			formObj.chkItemName.checked=true;
	    			if(acctItmNm != "") {
	    				form.acct_itm_nm.value=acctItmNm;
	    				form.acct_cd.value=acctCd;
	    				form.acct_itm_seq.value=acctItmSeq;
	    			}
	    			if(fromChtrInvDt != "") {
	    				form.from_chtr_inv_dt.value=fromChtrInvDt;
	    			}
	    			if(toChtrInvDt != "") {
	    				form.to_chtr_inv_dt.value=toChtrInvDt;
	    			}
				} else if(gubun == "CurrCd") {
					var prefix="inv_";
					formObj.f_cmd.value=SEARCH01;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0076GS.do" , FormQueryString(formObj));
		   			var currCd=ComGetEtcData(sXml, "currCd");
		   			if(typeof currCd == "undefined" || currCd == "") {
		   				ComShowMessage(ComGetMsg('FMS01142'));
                        sheetObj.SetCellValue(row,prefix+"curr_cd","",0);
                        
                        sheetObj.SelectCell(row,prefix+"curr_cd");
	    			} else {
	    				var currCd=sheetObj.GetCellValue(row, prefix + "curr_cd");
	    				ComFmsSetInitCellProperty(sheetObj, row, 6, prefix+"inv_amt", currCd, prefix, 2);
	    				//InitCellProperty(sheetObj, row,{ Type:"6",Align:"inv_amt",Format:"2"} );
	   				}
				} else {
					formObj.f_cmd.value=SEARCH01;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value=vslEngNm;
		   				
		   				initDefaultContractNo(); //NYK Modify 2014.10.21
					} else {
						formObj.vsl_cd.value="";
						formObj.vsl_eng_nm.value="";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01234'));
						return;
					}
				}
				break;
			case IBINSERT:      
                break;
            	
			case IBSEARCH_ASYNC02: //NYK Modify 2014.10.21				
				if(formObj.vsl_cd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdAll; 
				
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
            	
			case IBSEARCH_ASYNC03: //NYK Modify 2015.09.02				
				var f_query = "";			
				var invChtrInvDt = sheetObj.GetCellValue(row, "inv_chtr_inv_dt");
				f_query += "f_cmd=" + SEARCH04; 
				f_query += "&flet_ctrt_no="+formObj.flet_ctrt_no.value;	 			
				f_query += "&eff_dt="+invChtrInvDt; 
				
				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

	   			var vvds = ComGetEtcData(sXml, "vvds");
	   			
	   			if(typeof vvds != "undefined" && vvds != "" ) {
	   				setVvdMakeCombo(sheetObj, vvds+"|", row);
				}
				break;
        }
    }
    /**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	  form Object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	Inserted value of sheetObj
     * @return {boolean} bool
     * @see #ComChkValid
     **/
    function validateForm(sheetObj,formObj,sAction){
    	if(form.vsl_cd.value == "") {
    		ComAlertFocus(form.vsl_cd, ComGetMsg('FMS01138'));
    		return false;
    	}
    	if(form.from_chtr_inv_dt.value != "" && form.to_chtr_inv_dt.value == "") {
    		ComAlertFocus(form.to_chtr_inv_dt, ComGetMsg('FMS01139'));
    		return false;
    	}
    	if(form.from_chtr_inv_dt.value == "" && form.to_chtr_inv_dt.value != "") {
    		ComAlertFocus(form.from_chtr_inv_dt, ComGetMsg('FMS01140'));
    		return false;
    	}
    	if(form.from_chtr_inv_dt.value != "" && form.to_chtr_inv_dt.value != "") {
    		if(form.from_chtr_inv_dt.value.trimAll("-") > form.to_chtr_inv_dt.value.trimAll("-")) {
    			ComAlertFocus(form.to_chtr_inv_dt, ComGetMsg('FMS01141'));
    			return false;
    		}
    	}
        if (!ComChkValid(formObj)) return false;
        return true;
    }
    /**
     * Getting Sum of IBSheet Object <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} sheetObj    IBSheet Row
     **/
	function sheet1_OnChangeSum( sheetObj, Row ) {

	}
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="-";
    }

    /**
     * Getting Name relevant to the VslCd when VslCd is changed <br>
     **/
    function vsl_cd_change() {
    	form.flet_ctrt_no.value="";
    	form.vsl_eng_nm.value="";
    	if(form.vsl_cd.value != ""){
    		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
    	}
    }
    /**
     * Inserting Vessel Code <br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		//axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value=aryPopupData[0][2];
		form.vsl_eng_nm.value=aryPopupData[0][3];
		//axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			//Getting Name information after inserting Vessel Code
		
		//NYK Modify 2014.10.21
		if(form.vsl_cd.value != ""){
			vsl_cd_change();
		}
	}
	/**
	 * Inserting Contract No <br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value=aryPopupData[0][3];
		contract_no_change();
	}
	/**
     * Getting Name corresponding to Contract No when selecting Contract No <br>
     **/
    function contract_no_change() {
    	/* [UI개선_수정(DO-HYUN KIM) - 2014.08.04] : 초기화를 방지하기 위해 조회 주석처리*/
    	/* [NYK Modify 2014.10.21] : 자동검색을 하기 위해 다시 주석을 풀음.*/
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'Contract');
    }
    /**
	 * Inserting setItemNm <br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setItemNm(aryPopupData, row, col, sheetIdx){
		form.acct_itm_nm.value=aryPopupData[0][2];
		form.acct_cd.value=aryPopupData[0][3];
		form.acct_itm_seq.value=aryPopupData[0][4];
		form.chkItemName.disabled=false;
		form.chkItemName.checked=true;
	}
	/**
	 * Inserting setGridItemNm <br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setGridItemNm(aryPopupData, row, col, sheetIdx){
		sheetObjects[0].SetCellValue(row,col,aryPopupData[0][2],0);
		sheetObjects[0].SetCellValue(row,"inv_acct_cd",aryPopupData[0][3],0);
		sheetObjects[0].SetCellValue(row,"inv_acct_itm_seq",aryPopupData[0][4],0);
	}
	/**
     * Handling by Event <br>
     * @param {String} flag     	Event Separator
     **/
    function inputReadOnly(flag) {
    	if(flag == "New") {
	    	form.vsl_cd.readOnly=false;
	    	document.all.name="contract_no";
	    	document.all.name="btn_vslpop";
	    	form.contract_no.style.cursor="hand";
	    	form.btn_vslpop.style.cursor="hand";
	    	form.chkItemName.disabled=true;
    	} else {
	    	if(sheetObjects[0].RowCount()> 0) {
		    	form.vsl_cd.readOnly=true;
		    	document.all.name="no_contract_no";
	    		document.all.name="no_btn_vslpop";
		    	form.contract_no.style.cursor="default";
		    	form.btn_vslpop.style.cursor="default";
	    	}
    	}
    }
    /**
     * Initializing Screen <br>
     * @return none
     * @see #ComResetAll
     **/
	function clearAll(flag) {
		//ComResetAll();
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
		document.all.totalAmount.style.display="none";
		if(flag != "CTRT") inputReadOnly("New");
	}
	/**
     * Checking implemetation when Event is occurred <br>
     * @return {boolean} okYn   In case of clicking confirm button? okYn:true else okYn:false
     **/
    function initConfirm() {
    	var okYn=true;
    	//if(sheetObjects[0].RowCount > 0 && rowChangeYn()) {
    	if(sheetObjects[0].IsDataModified()) {
    		var okYn=confirm(ComGetMsg('FMS00002'));
    	}
    	return okYn;
    }
    /**
     * Checking any change when Event is occurred <br>
     * @return {boolean} changeYn   any change of row ? changeYn:true else changeYn:false
     **/
    function rowChangeYn() {
    	var changeYn=false;
    	for(var ir=1; ir<=sheetObjects[0].LastRow(); ir++){
    		if(sheetObjects[0].GetRowStatus(ir) != "R") {
    			changeYn=true;
    			break;
    		}
		}
    	return changeYn;
    }
    /**
     * Handling Date Effectiveness Verification Process about input Value of IBSheet <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @see #ComRowHideDelete
     **/
	function rowRemove(sheetObj, prefix) {
		ComRowHideDelete(sheetObj, prefix + "DelChk");
	}
	/**
     * Calling Popup(Item Name) <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     * @see #setProgramNo
     **/
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=CH", 500, 450, "setGridItemNm", "1,0,1,1,1,1", true, false, Row, Col, 0, "ESM_FMS_0076");
	}
	/**
     * Event occurred when value of cell is changed <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     **/
	function sheet1_OnChange(sheetObj,row,col, Value, OldValue, RaiseFlag) {
		if(Value == OldValue) return;
		
		if(sheetObj.ColSaveName(col)=="inv_curr_cd") {
			var currCdCol=sheetObj.SaveNameCol("inv_curr_cd");
			var currCdValue=sheetObj.GetCellValue(row,currCdCol);
    		if(currCdValue == "") return;
    		form.curr_cd.value=currCdValue;
			setCurrCd(row);
		} else if(sheetObj.ColSaveName(col)=="inv_chtr_inv_dt") {
			sheetObj.SetCellValue(row,"inv_bunker_vvd","");
			sheetObj.SetCellEditable(row, "inv_bunker_vvd",0);
 			sheetObj.InitCellProperty(row, "inv_bunker_vvd",{ Type:"Text"} );
 			
 			//2015.09.02 NYK Add
    		//TI,TO에 따른 VVD 조회.
    		doActionIBSheet(sheetObj,document.form, IBSEARCH_ASYNC03, "", row);
		}
	}
	/**
     * Getting Currency Code information <br>
     * @param {ibsheet} row     	Selected Row of sheetObj
     **/
    function setCurrCd(row) {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'CurrCd', row);
    }
    /**
     * Event occurring when clicking Cell <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     **/
    function sheet1_OnClick(sheetObj, row, col) {
    	var prefix="inv_";
    	if(sheetObj.GetCellValue(row, prefix + "pop_gb") != "SDMS") {
	    	if(sheetObj.ColSaveName(col)== prefix + "bunker_vvd") {
	    		if(   (   sheetObj.GetCellValue(row, prefix + "slp_tp_cd") == "Y"
	    			|| sheetObj.GetCellValue(row, prefix + "sdms_no") != "")
	    		   && sheetObj.GetCellEditable(row, prefix + "bunker_vvd") == false) return;
	    		var chtrInvDtValue=sheetObj.GetCellValue(row, prefix + "chtr_inv_dt");
	    		if(chtrInvDtValue == "" || chtrInvDtValue.length < 8) {
	    			ComShowMessage(ComGetMsg('FMS01143'));
	    			sheetObj.SelectCell(row, prefix + "chtr_inv_dt", true, "");
	    			sheetObj.ValidateFail(true);
	    			return;
	    		}
	    		var iType=sheetObj.GetCellProperty(row, prefix + "bunker_vvd", "Type");
	    		if(iType == "Combo") return;
	    		form.rev_yrmon.value=chtrInvDtValue;
	    		setVvdCombo(row);
	    	}
    	}
    }
    /**
     * Getting Vvd information <br>
     * @param {ibsheet} row     	Selected Row of sheetObj
     **/
    function setVvdCombo(row) {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "Vvd", row);
    }
    /**
     * Making Vvd Combo Box <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Code Value of Vvd 
     * @param {ibsheet} row     	Selected Row of sheetObj
     **/
    function setVvdMakeCombo(sheetObj, comboText, row) {
    	if(comboText != "" ) {
    		
//        	var dfCode=comboList[0];
    		var vvdCode=comboText.substring(0,comboText.length-1);
    		var vvdText=vvdCode;
        	
        	var iType = sheetObj.GetCellProperty(row, 10, "Type");
        	if(iType!="Combo"){
        		sheetObj.InitCellProperty(row, "inv_bunker_vvd",{ Type:"Combo"} );
        		
        	}
        	sheetObj.SetCellEditable(row, "inv_bunker_vvd",1);
        	sheetObj.CellComboItem(row,"inv_bunker_vvd", {ComboText:vvdText, ComboCode:vvdCode} );
        	
        	var arrVvdCd=vvdCode.split("|");
        	if(arrVvdCd.length > 0){
          		sheetObj.SetCellValue(row, "inv_bunker_vvd", arrVvdCd[0], 0);
          	}
        	
    	}
    }
    /**
     * Initializing Invoice Date and Item Name <br>
     **/
    function setItemClear() {
    	form.from_chtr_inv_dt.value="";
    	form.to_chtr_inv_dt.value="";
    	form.acct_itm_nm.value="";
    	form.acct_cd.value="";
    	form.acct_itm_seq.value="";
    }
    /**
     * Initializing Grid Data when Charterer / Owner is changed <br>
     **/
    function setDataClear(val) {
    	sheetObjects[0].RemoveAll();
    	sheetObjects[1].RemoveAll();
    	document.all.totalAmount.style.display="none";
    	if(val == "P") {
    		ComBtnEnable("btn_sdms");
    	} else {
    		ComBtnDisable("btn_sdms");
    	}
    }
	/**
     * Showing Currency Amount by each Currency  <br>
     * @param {String}  totalAmount1   Currency Amount by each Currency
     **/
	function setTotalAmount(totalAmount1) {
		document.all.totalAmount.style.display="";
		document.all.totalAmount1.innerHTML=totalAmount1;
		document.all.totalAmount2.innerHTML="&nbsp;";
	}
	/**
     * Initializing Item Name <br>
     **/
	function setItemNameClear() {
		if(!form.chkItemName.checked) {
			form.acct_itm_nm.value="";
			form.acct_cd.value="";
			form.acct_itm_seq.value="";
		}
	}
    /**
     * Initializing Check Box <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	Variable Separator
     * @return none
     **/
	function initCheckBox(sheetObj, prefix) {
		for (var ir=1; ir<=sheetObj.LastRow(); ir++) {
			sheetObj.SetCellValue(ir,prefix+"DelChk",0,0);
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
  			arrInvDtlSeq[i++]=sheetObj.GetCellText(ir,"inv_inv_dtl_seq");
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
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix="inv_";
    	for(var ir=1; ir<=sheetObj.LastRow(); ir++){
    		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + "curr_cd"))) {
 				sheetObj.InitCellProperty(ir, 6,{ Type:"Int",Align:"Right",Format:"NullInteger"} );
			}
    		if(sheetObj.GetCellValue(ir, prefix + "slp_tp_cd") == "Y") {    			
    			sheetObj.SetCellEditable(ir, prefix + "DelChk",0);
    			sheetObj.SetCellEditable(ir, prefix + "acct_itm_nm",0);
    			sheetObj.SetCellEditable(ir, prefix + "curr_cd",0);
    			sheetObj.SetCellEditable(ir, prefix + "inv_amt",0);
    			sheetObj.SetCellEditable(ir, prefix + "chtr_inv_dt",0);
    			sheetObj.SetCellEditable(ir, prefix + "to_inv_no",0);
    			sheetObj.SetCellEditable(ir, prefix + "bunker_vvd",0);
    			sheetObj.SetCellEditable(ir, prefix + "inv_desc",0);
    		} else {    			
    			if(sheetObj.GetCellValue(ir, prefix + "sdms_no") != "") {    				
    				//sheetObj.CellEditable(ir, prefix + "DelChk") = false;
        			sheetObj.SetCellEditable(ir, prefix + "acct_itm_nm",0);
        			sheetObj.SetCellEditable(ir, prefix + "curr_cd",0);
        			sheetObj.SetCellEditable(ir, prefix + "inv_amt",0);
        			sheetObj.SetCellEditable(ir, prefix + "chtr_inv_dt",0);
        			sheetObj.SetCellEditable(ir, prefix + "to_inv_no",0);
        			sheetObj.SetCellEditable(ir, prefix + "bunker_vvd",0);
        			sheetObj.SetCellEditable(ir, prefix + "inv_desc",0);
    			}
    		}
    	}    	
	
	}

    //NYK Modify 2014.10.21
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }	

 	function resizeSheet(){
 	    //for (i=0; i<sheetObjects.length; i++){
 	        ComResizeSheet(sheetObjects[0], 130);
 	    //}
 	}
 	