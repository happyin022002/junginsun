/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0017.js
*@FileTitle  : SDMS - Windows
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
// common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var localopener=window.dialogArguments;
	if (!localopener) localopener=window.opener;  //이 코드 추가할것
	if (!localopener) localopener=parent; //이 코드 추가할것
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
            	case "btn_save":
            		alert("btn_save");
                    break;
				case "btn_confirm":
					var sRow=sheetObject.FindCheckedRow("DelChk");
		    		if (sRow == "") {
		    			ComShowCodeMessage('COM12189');
		    			return;
		    		}
		    		doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
				case "btn_new":
					if(!initConfirm()) return;
					formReset();
                    break;
				case "btn_close":
					ComClosePopup(); 
                    break;
				case "from_dt_cal": 
					var cal=new ComCalendar();
					cal.select(form.from_pay_dt, 'yyyy-MM-dd');
					break;
				case "to_dt_cal":
					var cal=new ComCalendar();
					cal.select(form.to_pay_dt, 'yyyy-MM-dd');	
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
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
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {
                var HeadTitle1="| |SDMS No.|VVD|VVD|VVD|Port|Damage\nType|Last Updated\nStatus|Currency|Amount|INV No.|SDMS Date|INV\nStatus|Description|Status Cd|SHP_OWNR_CO_NM|PAY_ACCT_NO|CRE_USR_ID|Org SDMS Date";
                var HeadTitle2="| |SDMS No.|VSL Code|Direction|Rev. Dir|Port|Damage\nType|Last Updated\nStatus|Currency|Amount|INV No.|SDMS Date|INV\nStatus|Description|Status Cd|SHP_OWNR_CO_NM|PAY_ACCT_NO|CRE_USR_ID|Org SDMS Date";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                    {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"DelChk" },
                    {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"stv_dmg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"direction",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rev_dir_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"stv_dmg_prt_cate_cd",      KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"last_update_status",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pay_curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 ,InputCaseSensitive:1, AcceptKeys:"E" },
                    {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pay_locl_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
                    {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"bil_inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                    {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"imsi_pay_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inv_status",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:310,  Align:"Left",    ColMerge:1,   SaveName:"stv_dmg_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
                    {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"stv_dmg_stl_proc_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"shp_ownr_co_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pay_acct_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pay_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                InitColumns(cols);
                SetEditable(1);
                SetRangeBackColor(1, 3, 1, 5,"#555555");
                //SetSheetHeight(300);
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
     **/ 
    function doActionIBSheet(sheetObj,formObj,sAction,row,col) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      
        		if(!validateForm(sheetObj,formObj,sAction))  return true;
  				formObj.f_cmd.value=SEARCH;
  				sheetObj.DoSearch("ESM_FMS_0017GS.do", FormQueryString(formObj) );
                break;
			 case IBSAVE:        
			    formObj.f_cmd.value=MULTI;
			    var chkArrSheets=new Array(sheetObjects[0]);
			    var chkParam=sheetObj.GetSaveString();
				if (sheetObj.IsDataModified()&& chkParam == "") {
				    return; 
				}
				var prefix="inv_";
				var prefix2="sdms_";
			 	for (var ir=1; ir<=sheetObj.LastRow(); ir++){
			 		if(sheetObj.GetCellValue(ir,"DelChk") == 1) {
						sheetObj.SetRowStatus(ir,"I");
						var row=localopener.sheetObjects[0].DataInsert(-1);
						localopener.sheetObjects[0].SetCellValue(row,prefix+"curr_cd",sheetObj.GetCellValue(ir,"pay_curr_cd"),0);
						var currCd=sheetObj.GetCellValue(ir,"pay_curr_cd");
//						InitCellProperty(localopener.sheetObjects[0], row,{ Type:"6",Align:"inv_amt",Format:"2"} );
						//UI개선(201408 민정호)	
						ComFmsSetInitCellProperty(localopener.sheetObjects[0], row, 6, "inv_amt", currCd, prefix, 2);
						
						localopener.sheetObjects[0].SetCellValue(row,prefix+"inv_amt",sheetObj.GetCellValue(ir,"pay_locl_amt"),0);
						localopener.sheetObjects[0].SetCellValue(row,prefix+"slp_tp_cd","N",0);
						localopener.sheetObjects[0].SetCellValue(row,prefix+"chtr_inv_dt",sheetObj.GetCellValue(ir,"pay_dt"),0);
						localopener.sheetObjects[0].SetCellValue(row,prefix+"to_inv_no",sheetObj.GetCellValue(ir,"bil_inv_no"),0);
						localopener.sheetObjects[0].SetCellValue(row,prefix+"bunker_vvd",sheetObj.GetCellValue(ir,"vsl_cd")+sheetObj.GetCellValue(ir,"direction")+sheetObj.GetCellValue(ir,"rev_dir_cd"),0);
						localopener.sheetObjects[0].SetCellValue(row,prefix+"inv_desc",sheetObj.GetCellValue(ir,"stv_dmg_rmk"),0);
						localopener.sheetObjects[0].SetCellValue(row,prefix+"sdms_no",sheetObj.GetCellValue(ir,"stv_dmg_no"),0);
						localopener.sheetObjects[0].SetCellValue(row,prefix+"flet_ctrt_no",formObj.flet_ctrt_no.value,0);
						
						localopener.sheetObjects[0].SetCellValue(row,prefix+"inv_seq","1",0);
						localopener.sheetObjects[0].SetCellValue(row,prefix+"pop_gb","SDMS",0);
						localopener.sheetObjects[0].SetCellEditable(row, prefix+"DelChk",1);
						localopener.sheetObjects[0].SetCellEditable(row, prefix+"curr_cd",0);
						localopener.sheetObjects[0].SetCellEditable(row, prefix+"inv_amt",0);
						localopener.sheetObjects[0].SetCellEditable(row, prefix+"chtr_inv_dt",0);
						localopener.sheetObjects[0].SetCellEditable(row, prefix+"to_inv_no",0);
						localopener.sheetObjects[0].InitCellProperty(row, prefix+"bunker_vvd",{ Type:"Data"} );
						localopener.sheetObjects[0].SetCellEditable(row, prefix+"bunker_vvd",0);
						localopener.sheetObjects[0].SetCellEditable(row, prefix+"inv_desc",1);
						var idx=localopener.sheetObjects[1].DataInsert(-1);
						localopener.sheetObjects[1].SetCellValue(idx, prefix2+"stv_dmg_no",sheetObj.GetCellValue(ir,"stv_dmg_no"),0);
						localopener.sheetObjects[1].SetCellValue(idx, prefix2+"pay_curr_cd",sheetObj.GetCellValue(ir,"pay_curr_cd"),0);
						localopener.sheetObjects[1].SetCellValue(idx, prefix2+"pay_locl_amt",sheetObj.GetCellValue(ir,"pay_locl_amt"),0);
						localopener.sheetObjects[1].SetCellValue(idx, prefix2+"bil_inv_no",sheetObj.GetCellValue(ir,"bil_inv_no"),0);
						localopener.sheetObjects[1].SetCellValue(idx, prefix2+"pay_dt",sheetObj.GetCellValue(ir,"pay_dt"),0);
						localopener.sheetObjects[1].SetCellValue(idx, prefix2+"stv_dmg_rmk",sheetObj.GetCellValue(ir,"stv_dmg_rmk"),0);
						localopener.sheetObjects[1].SetCellValue(idx, prefix2+"stv_dmg_stl_proc_sts_cd","P",0);
						localopener.sheetObjects[1].SetCellValue(idx, prefix2+"shp_ownr_co_nm",formObj.ownr_nm.value,0);
						localopener.sheetObjects[1].SetCellValue(idx, prefix2+"pay_acct_no",formObj.cust_cnt_cd.value + formObj.cust_seq.value,0);
						localopener.sheetObjects[1].SetCellValue(idx, prefix2+"cre_usr_id",formObj.usr_id.value,0);
						localopener.inputReadOnly();
					} else {
						sheetObj.SetRowStatus(ir,"R");
					}
				}
			 	var arrSheets=new Array(sheetObjects[0]);
			    var sParam=sheetObj.GetSaveString();
				if (sheetObj.IsDataModified()&& sParam == "") {
				    return; 
				}
				ComClosePopup(); 
                break;
			case IBROWSEARCH:      
				if(col == "curr_cd") {
					formObj.f_cmd.value=SEARCH01;
					var sXml=sheetObj.GetSearchData("ESM_FMS_0076GS.do" , FormQueryString(formObj));
	    			var currCd=ComGetEtcData(sXml, "currCd");
	    			if(typeof currCd == "undefined" || currCd == "") {
	    				ComShowMessage(ComGetMsg('FMS01142'));
						var currCdCol=sheetObj.SaveNameCol("pay_curr_cd");
						sheetObj.SetCellValue(row,currCdCol,"",0);
						sheetObj.SelectCell(row,currCdCol);
	    			} else {
	    				var currCd=sheetObj.GetCellValue(row, "pay_curr_cd");
	    				//InitCellProperty(sheetObj, row,{ Type:"10",Align:"pay_locl_amt",Format:"2"} );
	   				}
				} else if(col == "inv_no") {
					formObj.f_cmd.value=SEARCH01;
					var sXml=sheetObj.GetSearchData("ESM_FMS_0017GS.do" , FormQueryString(formObj));
	    			var invNo=ComGetEtcData(sXml, "invNo");
	    			if(typeof invNo != "undefined" && invNo != "") {
	    				ComShowMessage(ComGetMsg('FMS01181'));
						var invNoCol=sheetObj.SaveNameCol("bil_inv_no");
						sheetObj.SetCellValue(row,invNoCol,"",0);
						sheetObj.SelectCell(row,invNoCol);
	    			}
				} else {
					formObj.f_cmd.value=SEARCH02;
					var sXml=sheetObj.GetSearchData("ESM_FMS_0076GS.do" , FormQueryString(formObj));
		   			var vvd=ComGetEtcData(sXml, "vvd");
		   			if(typeof vvd != "undefined" && vvd != "") {
		   				var iType = sheetObj.GetCellProperty(row, "rev_dir_cd", "Type");
		   				if(iType!="Combo"){
		   	        		sheetObj.SetCellText(row, "rev_dir_cd" ,"");
		   	        	}
	    				var comboText=vvd;
	    				setVvdMakeCombo(sheetObj, comboText, row);
	    			} else {
	    				ComShowMessage(ComGetMsg('FMS01144'));
	    				sheetObj.SelectCell(row, "rev_dir_cd");
	    			}
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
    }
    /**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     Action Code(Example:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL )
     **/
    function validateForm(sheetObj,formObj,sAction) {
        if(formObj.from_pay_dt.value != "") {
        	if(formObj.to_pay_dt.value == "") {
        		ComAlertFocus(formObj.to_pay_dt, ComGetMsg("FMS01150"));
        		return false;
        	}
        }
        if(formObj.to_pay_dt.value != "") {
        	if(formObj.from_pay_dt.value == "") {
        		ComAlertFocus(formObj.from_pay_dt, ComGetMsg("FMS01151"));
        		return false;
        	}
        }
        if(parseInt(formObj.from_pay_dt.value.trimAll('-')) > parseInt(formObj.to_pay_dt.value.trimAll('-'))) {
        	ComAlertFocus(formObj.to_pay_dt, ComGetMsg("FMS01177"));
    		return false;
        }
        return true;
    }
    /**
     * Checking implemetation when Event is occurred <br>
     * @return {boolean} okYn   In case of clicking Confirm Button? okYn:true else okYn:false
     **/
    function initConfirm() {
    	var okYn=true;
     	if(sheetObjects[0].IsDataModified()) {
     		var okYn=confirm(ComGetMsg('FMS00002'));
     	}
     	return okYn;
    }
    /**
     * Initializing Screen <br>
     * @return none
     * @see #ComResetAll
     **/
	function formReset() {
		sheetObjects[0].RemoveAll();
		form.from_pay_dt.value="";
		form.to_pay_dt.value="";
		form.app_flg.selectedIndex=0;
	}
	/**
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet}	sheetObj    IBSheet Object
     * @param {String}  ErrMsg    	Error Message
     **/
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	for(var ir=1; ir<=sheetObj.LastRow(); ir++){
    		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, "pay_curr_cd"))) {
    			sheetObj.InitCellProperty(ir, "pay_locl_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
			}

    		var tmpRevDirCd = sheetObj.GetCellValue(ir, "rev_dir_cd");
    		if(tmpRevDirCd  != ""){
    			setVvdMakeCombo(sheetObj, tmpRevDirCd+"|", ir);
    		}
    		
    		if(sheetObj.GetCellValue(ir,"inv_status") == "Yes") {
    			sheetObj.SetCellEditable(ir, "DelChk",0);
    			sheetObj.SetCellEditable(ir, "rev_dir_cd",0);
    			sheetObj.SetCellEditable(ir, "pay_curr_cd",0);
    			sheetObj.SetCellEditable(ir, "pay_locl_amt",0);
    			sheetObj.SetCellEditable(ir, "bil_inv_no",0);
    			sheetObj.SetCellEditable(ir, "imsi_pay_dt",0);
    			sheetObj.SetCellEditable(ir, "stv_dmg_rmk",0);
    		}
    	}
 	}
    /**
     * Event occurring when clicking Cell <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     **/
    function sheet1_OnClick(sheetObj, row, col) {
    	if(sheetObj.GetCellValue(row,"inv_status") == "Yes") return;
    	if(sheetObj.ColSaveName(col)=="rev_dir_cd") {
    		//alert(sheetObj.CellEditable(row, "rev_dir_cd"));
    		//if(sheetObj.CellEditable(row, "rev_dir_cd") == false) return;
    		
    		var payDtValue=sheetObj.GetCellValue(row, "imsi_pay_dt");
    		if(payDtValue == "" || payDtValue.length < 8) {
    			ComShowMessage(ComGetMsg('FMS01182'));
    			sheetObj.SelectCell(row, "imsi_pay_dt", true, "");
    			sheetObj.ValidateFail(true);
    			return;
    		}
    		var iType=sheetObj.GetCellProperty(row, "rev_dir_cd", "Type");
    		if(iType == "Combo") return;
    		var direction=sheetObj.GetCellValue(row,"direction");
    		form.direction.value=direction;
    		form.rev_yrmon.value=payDtValue.substring(0,6);
    		setVvdCombo(row);
    	}
    }
    /**
     * Getting Vvd Information <br>
     * @param {ibsheet} row     	Selected Row of sheetObj
     **/
    function setVvdCombo(row) {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, row, "Vvd");
    }
    /**
     * Making Vvd Combo Box <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Code Value of Vvd
     * @param {ibsheet} row     	Selected Row of sheetObj
     **/
    function setVvdMakeCombo(sheetObj, comboText, row) {
    	if(comboText != "" ) {
    		var vvdCode=comboText.substring(0,comboText.length-1);
    		var vvdText=vvdCode;
        	
        	var iType = sheetObj.GetCellProperty(row, "rev_dir_cd", "Type");
        	if(iType!="Combo"){
        		sheetObj.InitCellProperty(row, "rev_dir_cd",{ Type:"Combo"} );
        	}
        	sheetObj.CellComboItem(row,"rev_dir_cd", {ComboText:vvdText, ComboCode:vvdCode} );
        	sheetObj.SetCellEditable(row, "rev_dir_cd",1);
        	

        	var arrVvdCd=vvdCode.split("|");
        	if(arrVvdCd.length > 0){
          		sheetObj.SetCellValue(row, "rev_dir_cd", arrVvdCd[0], 0);
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
	function sheet1_OnChange(sheetObj,row,col,value) {
		if (sheetObj.ColSaveName(col)==("pay_curr_cd")) {
            var currCdCol=sheetObj.SaveNameCol("pay_curr_cd");
            var currCdValue=sheetObj.GetCellValue(row,currCdCol);
            if(currCdValue == "") return;
            if(currCdValue.length < 3) {
    			ComShowMessage(ComGetMsg('FMS01077'));
	    		sheetObj.SetCellValue(row,currCdCol,"",0);
				sheetObj.SelectCell(row,currCdCol);
				return;
    		}
    		form.curr_cd.value=currCdValue;
    		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, row, "curr_cd");
    	} else if(sheetObj.ColSaveName(col)==("pay_locl_amt")) {
    		var payLoclAmtCol=sheetObj.SaveNameCol("pay_locl_amt");
    		var payLoclAmtValue=sheetObj.GetCellValue(row,payLoclAmtCol);
			if(payLoclAmtValue <= 0) {
				ComShowMessage(ComGetMsg('FMS01163'));
	    		sheetObj.SetCellValue(row,payLoclAmtCol,"",0);
				sheetObj.SelectCell(row,payLoclAmtCol);
				return;
			}
    	} else if (sheetObj.ColSaveName(col)==("bil_inv_no")) {
            var invNoCol=sheetObj.SaveNameCol("bil_inv_no");
            var invNoValue=sheetObj.GetCellValue(row,invNoCol);
            if(invNoValue == "") return;
    		form.inv_no.value=invNoValue;
    		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, row, "inv_no");
    	} else if(sheetObj.ColSaveName(col)=="imsi_pay_dt") {
			sheetObj.SetCellValue(row,"rev_dir_cd","");
			sheetObj.SetCellEditable(row, "rev_dir_cd",0);
			sheetObj.InitCellProperty(row, "rev_dir_cd",{ Type:"Data"} );
		}
	}
    /**
     * Event called to check Validation just before Saving by Saving Function <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     **/
	function sheet1_OnValidation(sheetObj,row,col,value) {
		if(sheetObj.GetCellValue(row,"DelChk") == 1) {
			if(sheetObj.GetCellValue(row,"rev_dir_cd") == "") {
				ComShowMessage(ComGetMsg('FMS01178'));
				sheetObj.ValidateFail(true);
				sheetObj.SelectCell(row,"rev_dir_cd");
				return false;
			}
			if(sheetObj.GetCellValue(row,"pay_curr_cd") == "") {
				ComShowMessage(ComGetMsg('FMS01077'));
				sheetObj.ValidateFail(true);
				sheetObj.SelectCell(row,"pay_curr_cd");
				return false;
			}
			if(sheetObj.GetCellValue(row,"pay_locl_amt") == "") {
				ComShowMessage(ComGetMsg('FMS01179'));
				sheetObj.ValidateFail(true);
				sheetObj.SelectCell(row,"pay_locl_amt");
				return false;
			}
			var payLoclAmtCol=sheetObj.SaveNameCol("pay_locl_amt");
			var payLoclAmtValue=sheetObj.GetCellValue(row,payLoclAmtCol);
			if(payLoclAmtValue <= 0) {
				ComShowMessage(ComGetMsg('FMS01163'));
	    		sheetObj.SetCellValue(row,payLoclAmtCol,"",0);
				sheetObj.SelectCell(row,payLoclAmtCol);
				return;
			}
			if(sheetObj.GetCellValue(row,"bil_inv_no") == "") {
				ComShowMessage(ComGetMsg('FMS01180'));
				sheetObj.ValidateFail(true);
				sheetObj.SelectCell(row,"bil_inv_no");
				return false;
			}
			if(sheetObj.GetCellValue(row,"stv_dmg_rmk") == "") {
				ComShowMessage(ComGetMsg('FMS01444'));
				sheetObj.ValidateFail(true);
				sheetObj.SelectCell(row,"stv_dmg_rmk");
				return false;
			}
		}
	}
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
