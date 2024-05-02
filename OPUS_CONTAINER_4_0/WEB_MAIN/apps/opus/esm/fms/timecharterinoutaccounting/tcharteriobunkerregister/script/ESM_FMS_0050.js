/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0050.js
*@FileTitle  : BunkerDataManagement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class BunkerDataManagement : BunkerDataManagement definition of biz script for creation screen
     */
    // common global variables 
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var vslCombo="";
    var vvdCombo="";
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_retrieve":
                	if(!initConfirm()) return;
                	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
				case "btn_new":
					if(!initConfirm()) return;
					vslCombo="";
					clearAll();
                    break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
				case "btn_savetofile":
 					if(sheetObject.RowCount() < 1){//no data	
 						ComShowCodeMessage("COM132501");
 					}else{	
 						sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1});
 					}	
                    break;
				case "btn_add":
					if(!validateForm(sheetObject,formObject)) return;
					setVslCdCombo(row);
					var row=sheetObject.DataInsert(-1);
					sheetObject.SetCellText(row,"flet_ctrt_no" ,formObject.flet_ctrt_no.value);
					inputReadOnly();
                    break;
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					setVslCdCombo(row);
					var row=sheetObject.DataInsert();
					sheetObject.SetCellText(row,"flet_ctrt_no" ,formObject.flet_ctrt_no.value);
					inputReadOnly();
					break;
				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "DelChk")) {
						rowRemove(sheetObject);
					}
                    break;
				case "btn_vslpop":
					clearAll("VSL");//NYK Modify 2014.10.21
					ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0022");
					break;
				case "contract_no":
					 if(formObject.vsl_cd.value == "") {
						 ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01231'));
						 return;
					 }
					 clearAll("CTRT");//NYK Modify 2014.10.21
					 ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value, 520, 415,"setContractNo", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0023");
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
        	ComConfigSheet (sheetObjects[i]);
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
     * adding first-served functions after loading screen. 
     */
    function sheet1_OnLoadFinish(sheetObj) { 
    	sheetObj.SetWaitImageVisible(0);
		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");
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
            case 1:      //sheet1 init
                with(sheetObj){
//		              (18, 0, 0, true);
		              var HeadTitle="|Seq|Sel|Type|Vessel Code|Acct Code|Item|Del/Re Date|Del/Re Port|UOM|Quantity|Price(USD)|Amount|VVD|Contract No|Bnk Seq|Account Item|Bnk Yrmon|slp_tp_cd";
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
		                     {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"bnk_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:4,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Popup",     Hidden:0, Width:200,   Align:"Left",    ColMerge:0,   SaveName:"acct_itm_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"bnk_dt",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"port_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                     {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"flet_meas_ut_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"bnk_qty",          KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
		                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"bnk_prc_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:17 },
		                     {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"bnk_amt",          KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:17 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bunker_vvd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:"flet_ctrt_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:"bnk_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:"acct_itm_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:"bnk_yrmon",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:"slp_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              //FitColWidth("1.8|3|7|7|10|15.6|9.5|8.7|5|7|11.5|9.5|10|0");
		              SetColProperty("bnk_dt", {Format:"####-##-## ##:##", AcceptKeys:"N"} );
		              SetColProperty("port_cd", {InputCaseSensitive:1} );		              		              
		              SetDataLinkMouse("acct_itm_nm",1);
		              SetDataLinkMouse("port_cd",1);
		              SetShowButtonImage(1);
//		              SetSheetHeight(470);
		              resizeSheet();
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
        	   	  	var sXml=sheetObj.GetSearchData("ESM_FMS_0050GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
       	   	  		var arrXml=sXml.split("|$$|");
       	   	  		inputReadOnly("Search");
		       	   	var vslCd=ComGetEtcData(sXml, "vslCd");
			   		if(typeof vslCd != "undefined" && vslCd != "") {
		  				var comboText=vslCd;
		  				setVslCdMakeCombo(sheetObj, comboText);
		  			}
			   		if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
       	   	  	}
       	   	  	sheetObj.SetSumText(0,"bnk_prc_amt","Sub-Total Amount");
       	   	  	break;
        	case IBSAVE:        
        		if(validateForm(sheetObj,formObj,sAction)) {
        			formObj.f_cmd.value=MULTI;
        			sheetObj.DoSave("ESM_FMS_0050GS.do", FormQueryString(formObj));
        		}
                break;
			case IBROWSEARCH:   	
				if(gubun != "ComCd") {
					if(formObj.vsl_cd.value == "") return;
				}
				if(gubun == "vslCd") {
					if (vslCombo != "") return;
					formObj.f_cmd.value=SEARCH01;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0050GS.do" , FormQueryString(formObj));
		   			var vslCd=ComGetEtcData(sXml, "vslCd");
		   			if(typeof vslCd != "undefined" && vslCd != "") {
	    				var comboText=vslCd;
	    				setVslCdMakeCombo(sheetObj, comboText, row);
	    			}
				} else if(gubun == "Vvd") {
					if (vvdCombo != "") return;
					formObj.f_cmd.value=SEARCH02;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0050GS.do" , FormQueryString(formObj));
		   			var vvd=ComGetEtcData(sXml, "vvd");
		   			if(typeof vvd != "undefined" && vvd != "") {
	    				var comboText=vvd;
	    				setVvdMakeCombo(sheetObj, comboText, row);
	    			} else {
	    				ComShowMessage(ComGetMsg('FMS01232'));
	    				sheetObj.SelectCell(row, "vsl_cd");
	    			}
				} else if(gubun == "LocCd") {
					formObj.f_cmd.value=SEARCH03;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0050GS.do" , FormQueryString(formObj));
		   			var locCd=ComGetEtcData(sXml, "locCd");
		   			if(typeof locCd == "undefined" || locCd == "") {
		   				ComShowMessage(ComGetMsg('FMS01233'));
                        sheetObj.SetCellValue(row,"port_cd","",0);
                        sheetObj.SelectCell(row,"port_cd");
	    			}
				} else if(gubun == "Contract") {
					formObj.f_cmd.value=SEARCH04;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0050GS.do" , FormQueryString(formObj));
		   			var ctrtType=ComGetEtcData(sXml, "ctrtType");
		   			if(typeof ctrtType != "undefined" && ctrtType != "") {
		   				formObj.flet_ctrt_tp_cd.value=ctrtType;
	    			}
				} else if(gubun == "ComCd") {
					formObj.f_cmd.value=SEARCH05;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0050GS.do" , FormQueryString(formObj));
		   			var bnkType=ComGetEtcData(sXml, "bnkType");
		   			var uomCode=ComGetEtcData(sXml, "uomCode");
		   			var uomText=ComGetEtcData(sXml, "uomText");
		   			if(typeof bnkType != "undefined" && bnkType != "") {
	    				var comboText=bnkType;
	    				setTypeMakeCombo(sheetObj, comboText);
	    			}
		   			if(typeof uomCode != "undefined" && uomCode != "") {
	    				var comboCode=uomCode;
	    				var comboText=uomText;
	    				setUomMakeCombo(sheetObj, comboText, comboCode);
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
        }
    }
    /**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	 form Object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	sheetObj insert value
     * @return {boolean} bool
     * @see #ComChkValid
     **/
    function validateForm(sheetObj,formObj,sAction) {
        if (!ComChkValid(formObj)) return false;
        
        return true;
    }
    /**
     * Calculating Sum of IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} sheetObj    IBSheet Row
     **/
	function sheet1_OnChangeSum(sheetObj, Row) {
 		sheetObj.SetSumText(0,"Seq","");
 		sheetObj.SetSumText(0,"DelChk","");
 		sheetObj.SetSumText(0,"bnk_tp_cd","");
 		sheetObj.SetSumText(0,"bnk_prc_amt","Sub-Total Amount");
	}
	/**
	 * Vessel Code Input Part <br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value=aryPopupData[0][2];
		form.vsl_eng_nm.value=aryPopupData[0][3];
		axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			// Getting Name information after inserting Vessel Code
		
		//NYK Modify 2014.10.21
		if(form.vsl_cd.value != ""){
			vsl_cd_change();
		}
	}
	/**
     * Calling Popup(Item Name) <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	selected Row of sheetObj
     * @param {ibsheet} Col     	selected Col of sheetObj
     * @see #setProgramNo
     **/
	function sheet1_OnPopupClick(sheetObj,Row,Col){
    	if (sheetObj.ColSaveName(Col) == "acct_itm_nm") {
    		ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=BU", 550, 450, "setProgramNo", "1,0,1,1,1,1", true, false, Row, Col, 0, "ESM_FMS_0076");
    	} else {
    		ComOpenPopup("COM_ENS_051.do", 820, 480, "setPortCd", "1,0,1,1,1,1", true, false, Row, Col, 0, "COM_ENS_051");
    	}
	}
    /**
	 * programNo Input Part<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setProgramNo(aryPopupData, row, col, sheetIdx){
		sheetObjects[0].SetCellValue(row,col,aryPopupData[0][2],0);
		sheetObjects[0].SetCellValue(row,"acct_cd",aryPopupData[0][3],0);
		sheetObjects[0].SetCellValue(row,"acct_itm_seq",aryPopupData[0][4],0);
	}
	/**
	 * Del/Re Port Input Part<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setPortCd(aryPopupData, row, col, sheetIdx){
		sheetObjects[0].SetCellValue(row,col,aryPopupData[0][3],0);
	}
	/**
     * Deleting IBSheet Row  <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     **/
	function rowRemove(sheetObj) {
		ComRowHideDelete(sheetObj, "DelChk");
	}
	/**
     * Initializing screen <br>
     * @return none
     * @see #ComResetAll
     **/
	function clearAll(flag) {
		//ComResetAll();
		//NYK Modify 2014.10.17
		switch(flag){
			case "YRMON":
				ComResetAll();
				break;
			case "VSL":
				ComResetAll();
				break;
			case "CTRT":
				var tmpVslCd = form.vsl_cd.value;
				var tmpVslEngNm = form.vsl_eng_nm.value;
				ComResetAll();
				form.vsl_cd.value = tmpVslCd;
				form.vsl_eng_nm.value = tmpVslEngNm;
				break;
				
			default :
				ComResetAll();
				inputReadOnly("New");
				break;		
		}
		//inputReadOnly("New");
	}
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="-";
        axon_event.addListener  ('blur'  , 'vsl_cd_change', 'vsl_cd');			//- Getting Name information after inserting Vessel Code

    }


    /**
     *  Getting relevant Name when Changing VslCd <br>
     **/
    function vsl_cd_change() {
    	form.vsl_eng_nm.value="";
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
    }
    /**
     * Getting vslCd information <br>
     * @param {ibsheet} row     	selected Row of sheetObj
     **/
    function setVslCdCombo(row) {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "vslCd", row);
    }
    /**
     * Making vslCd Combo box <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Code value of vslCd
     * @param {ibsheet} row     	selected Row of sheetObj
     **/
    function setVslCdMakeCombo(sheetObj, comboText, row) {
    	if(comboText != "" ) {
    		var vslCdCode=comboText.substring(0,comboText.length-1);
    		var valCdText=vslCdCode;
        	var comboList=comboText.split("|");
        	vslCombo=vslCdCode;
        	sheetObj.SetColProperty("vsl_cd", {ComboText:valCdText, ComboCode:vslCdCode} );
    	}
    }
    /**
     * Handling Screen by Event <br>
     * @param {String} flag     	Event Separator
     **/
    function inputReadOnly(flag) {
    	if(flag == "New") {
	    	form.vsl_cd.readOnly=false;
	    	form.contract_no.readOnly = false;//NYK Modify 2014.10.21
	    	form.contract_no.name="contract_no";
	    	form.btn_vslpop.name="btn_vslpop";
	    	form.contract_no.style.cursor="hand";
	    	form.btn_vslpop.style.cursor="hand";
    	} else {
    		//NYK Modify 2014.10.21
	    	if(sheetObjects[0].RowCount()== 0 && flag == "Search") {
		    	form.vsl_cd.readOnly=true;
		    	form.contract_no.readOnly = true;//NYK Modify 2014.10.21
		    	form.contract_no.name="no_contract_no";
		    	form.btn_vslpop.name="no_btn_vslpop";
		    	form.contract_no.style.cursor="default";
		    	form.btn_vslpop.style.cursor="default";
	    	}
    	}
    }
    /**
     * Event occurred when value of cell is changed <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	selected Row of sheetObj
     * @param {ibsheet} col     	selected Col of sheetObj
     **/
	function sheet1_OnChange(sheetObj, row, col, value, OldValue, RaiseFlag) {
		if(sheetObj.ColSaveName(col)=="bnk_dt") {
			var bnkDtCol=sheetObj.SaveNameCol("bnk_dt");
			var bnkDtValue=sheetObj.GetCellValue(row,bnkDtCol);
    		//var bnkYrmon=form.bnk_yrmon.value.trimAll("-");
    		if(bnkDtValue.length < 8) {
    			//ComShowCodeMessage('FMS01235');
    			//sheetObj.SelectCell(row, "bnk_dt", true, "");
    			sheetObj.SelectCell(row,"bnk_dt");
    			sheetObj.SetCellValue(row,"bnk_dt","");
    			
        		initSheetByBunkerVvd(sheetObj, row,col);
    			return false;
    			//sheetObj.ValidateFail = true;
    		}
    		dateTimeOnChange(sheetObj,row,col,value);
    		
    		setVvdData(sheetObj,row,col);
    		//sheetObj.SetCellValue(row,"bunker_vvd","");
			//sheetObj.SetCellEditable(row, "bunker_vvd",0);
 			//sheetObj.InitCellProperty(row, "bunker_vvd",{ Type:"Data"} );
		} else if(sheetObj.ColSaveName(col)=="vsl_cd") {
			
			setVvdData(sheetObj,row,col);
			//sheetObj.SetCellValue(row,"bunker_vvd","");
			//sheetObj.SetCellEditable(row, "bunker_vvd",0);
 			//sheetObj.InitCellProperty(row, "bunker_vvd",{ Type:"Data"} );
		} else if(sheetObj.ColSaveName(col)=="port_cd") {
			var portCdCol=sheetObj.SaveNameCol("port_cd");
			var portCdValue=sheetObj.GetCellValue(row,portCdCol);
    		if(portCdValue == "") return;
    		form.curr_port_cd.value=portCdValue;
			setLocationCd(row);
		} else if(sheetObj.ColSaveName(col)=="bnk_qty" || sheetObj.ColSaveName(col)=="bnk_prc_amt") {
			if (sheetObj.GetCellValue(row, "bnk_qty") != "" && sheetObj.GetCellValue(row, "bnk_prc_amt") != "") {
				var tmpBnkAmt = ComTrunc(sheetObj.GetCellValue(row, "bnk_qty")*sheetObj.GetCellValue(row, "bnk_prc_amt") , 2);
				sheetObj.SetCellValue(row, "bnk_amt", tmpBnkAmt);
     		} else {
     			sheetObj.SetCellValue(row, "bnk_amt","");
     		}
    	}
	}
    /**
     * Handling Date Effectiveness Varification Process IBSheet about inserted value <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	selected Row of sheetObj
     * @param {ibsheet} col     	selected Col of sheetObj
     * @param {String}  value    	sheetObj insert value
     * @param {String}  prefix   	variable separator
     * @see #sheet_chekPeriod
     **/
 	function dateTimeOnChange(sheetObj,row,col,value) {
 		//UI개선(201408 민정호)
 		if (value=="") return;
 		var sText=sheetObj.GetCellText(row,col);
 		if(value.length != 12){
 			ComShowMessage(ComGetMsg('FMS01066', sheetObj.GetCellText(row,col)));
			sheetObj.SetCellValue(row,col,"",0); 						
 			return;
 		} 		
 	}
	/**
     * Event occured when clicking Cell <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	selected Row of sheetObj
     * @param {ibsheet} col     	selected Col of sheetObj
     **/
 	function sheet1_OnClick(sheetObj, row, col) {
 		if(sheetObj.GetCellValue(row, "slp_tp_cd") == "Y") return;
 		
    	if(sheetObj.ColSaveName(col)=="bunker_vvd") {
    		var bnkDtValue=sheetObj.GetCellValue(row,"bnk_dt");
    		if(bnkDtValue == "" || bnkDtValue.length < 8) {
    			ComShowMessage(ComGetMsg('FMS01235'));
    			sheetObj.SelectCell(row, "bnk_dt", true, "");
    			sheetObj.ValidateFail(true);
    			return;
    		}
    		//var iType=sheetObj.GetCellProperty(row, "bunker_vvd", dpDataType);
    		//if(iType == 6) return;
    		var vslCdValue=sheetObj.GetCellValue(row, "vsl_cd");
    		form.curr_vsl_cd.value=vslCdValue;
    		form.bunker_dt.value=bnkDtValue.substring(0,8);
    		setVvdCombo(row);
    	}
    }
    
    function setVvdData(sheetObj, Row, Col){
    	
    	var tmpBnkDt = sheetObj.GetCellValue(Row,"bnk_dt");
    	if(tmpBnkDt == "" || tmpBnkDt < 8){
    		initSheetByBunkerVvd(sheetObj, Row, Col);
    		return;
    	}
    	
    	var tmpVslCde = sheetObj.GetCellValue(Row, "vsl_cd");
    	if(tmpVslCde == ""){
    		initSheetByBunkerVvd(sheetObj, Row, Col);
    		return;
    	}
    	
    	document.form.curr_vsl_cd.value = tmpVslCde;
    	document.form.bunker_dt.value = tmpBnkDt.substring(0,8);
    
    	setVvdCombo(Row);
    }
    
    function initSheetByBunkerVvd(sheetObj, Row, Col){
    	sheetObj.SetCellValue(Row,"bunker_vvd","");
		sheetObj.SetCellEditable(Row, "bunker_vvd",0);
		sheetObj.InitCellProperty(Row, "bunker_vvd",{ Type:"Data"} );
    }
    
    /**
     * Getting Vvd information <br>
     * @param {ibsheet} row     	selected Row of sheetObj
     **/
    function setVvdCombo(row) {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "Vvd", row);
    }
    /**
     * Making Vvd Combo box <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Code Value of Vvd 
     * @param {ibsheet} row     	selected Row of sheetObj
     **/
    function setVvdMakeCombo(sheetObj, comboText, row) {
    	if(comboText != "" ) {
    		var vvdCode=comboText.substring(0,comboText.length-1);
    		var vvdText=vvdCode;
        	var comboList=comboText.split("|");
        	var iType = sheetObj.GetCellProperty(row, "bunker_vvd", "Type");
        	if(iType!="Combo"){
        		sheetObj.InitCellProperty(row, "bunker_vvd",{ Type:"Combo"} );
        	}
        	
        	sheetObj.SetCellEditable(row, "bunker_vvd",1);
        	sheetObj.CellComboItem(row,"bunker_vvd", {ComboText:vvdText, ComboCode:vvdCode} );
        	
        	sheetObj.SetCellValue(row, "bunker_vvd", comboList[0], 0);
    	}
    }
    /**
     * Making Type Combo Box <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Code Value of Type
     **/
    function setTypeMakeCombo(sheetObj, comboText) {
    	if(comboText != "" ) {
    		var typeCode=comboText.substring(0,comboText.length-1);
    		var typeText=typeCode;
        	var comboList=comboText.split("|");
        	sheetObj.SetColProperty("bnk_tp_cd", {ComboText:typeText, ComboCode:typeCode} );
    	}
    }
    /**
     * Making Uom Combo Box <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Name relevant to Code of Type
     * @param {String}  comboCode   Code Value of Type
     **/
    function setUomMakeCombo(sheetObj, comboText, comboCode) {
    	if(comboText != "" ) {
    		var typeText=comboText.substring(0,comboText.length-1);
    		var typeCode=comboCode.substring(0,comboCode.length-1);
        	sheetObj.SetColProperty("flet_meas_ut_cd", {ComboText:typeText, ComboCode:typeCode} );
    	}
    }
    /**
     * Getting Location Code information <br>
     * @param {ibsheet} row     	selected Row of sheetObj
     **/
    function setLocationCd(row) {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'LocCd', row);
    }
    /**
	 * Input part of Contract No .<br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value=aryPopupData[0][3];
		contract_no_change();
	}
	/**
     * Getting Name when selecting Contract No <br>
     **/
    function contract_no_change() {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'Contract');
    }
    /**
     * Checking whether implementing when Event is occurred  <br>
     * @return {boolean} okYn   In case of clicking OK button on Message confirm window okYn:true,  else okYn:false
     **/
    function initConfirm() {
    	var okYn=true;
    	if(ComIsModifiedSheets(sheetObjects[0])) {
    		var okYn=confirm(ComGetMsg('FMS00002'));
    	}
    	//if(sheetObjects[0].isDataModified) {
    		//var okYn = confirm("입력 및 변경된 데이터가 있습니다.\n\n계속 진행하시겠습니까?");
    	//}
    	return okYn;
    }
    /**
     * Checking whether changing data is existing when Event is occurred <br>
     * @return {boolean} changeYn   In case changing of row is occurred changeYn:true,  else changeYn:false
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
     * Event occurred after complting search by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     	sheetObj.SetSumText(0,"Seq","");
     	sheetObj.SetSumText(0,"DelChk","");

     	for(var ir=1; ir<=sheetObj.LastRow(); ir++){
	     	if(sheetObj.GetCellValue(ir, "slp_tp_cd") == "Y") { 
	     		sheetObj.SetCellEditable(ir, "DelChk",0);
    			sheetObj.SetCellEditable(ir, "bnk_tp_cd",0);
    			sheetObj.SetCellEditable(ir, "vsl_cd",0);
    			sheetObj.SetCellEditable(ir, "acct_cd",0);
    			sheetObj.SetCellEditable(ir, "acct_itm_nm",0);
    			sheetObj.SetCellEditable(ir, "bnk_dt",0);
    			sheetObj.SetCellEditable(ir, "port_cd",0);
    			sheetObj.SetCellEditable(ir, "flet_meas_ut_cd",0);
    			sheetObj.SetCellEditable(ir, "bnk_qty",0);
    			sheetObj.SetCellEditable(ir, "bnk_prc_amt",0);
    			sheetObj.SetCellEditable(ir, "bnk_amt",0);
    			sheetObj.SetCellEditable(ir, "bunker_vvd",0);
	     	}
     	}
 	}
 	
 	function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
 		sheetObj.SetSumText(0,"Seq","");
     	sheetObj.SetSumText(0,"DelChk","");

     	for(var ir=1; ir<=sheetObj.LastRow(); ir++){
	     	if(sheetObj.GetCellValue(ir, "slp_tp_cd") == "Y") { 
	     		sheetObj.SetCellEditable(ir, "DelChk",0);
    			sheetObj.SetCellEditable(ir, "bnk_tp_cd",0);
    			sheetObj.SetCellEditable(ir, "vsl_cd",0);
    			sheetObj.SetCellEditable(ir, "acct_cd",0);
    			sheetObj.SetCellEditable(ir, "acct_itm_nm",0);
    			sheetObj.SetCellEditable(ir, "bnk_dt",0);
    			sheetObj.SetCellEditable(ir, "port_cd",0);
    			sheetObj.SetCellEditable(ir, "flet_meas_ut_cd",0);
    			sheetObj.SetCellEditable(ir, "bnk_qty",0);
    			sheetObj.SetCellEditable(ir, "bnk_prc_amt",0);
    			sheetObj.SetCellEditable(ir, "bnk_amt",0);
    			sheetObj.SetCellEditable(ir, "bunker_vvd",0);
	     	}
     	}
 	}


    //NYK Modify 2014.10.16
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }
 	
 	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	}
