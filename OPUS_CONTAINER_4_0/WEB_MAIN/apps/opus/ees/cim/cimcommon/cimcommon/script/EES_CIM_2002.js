/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0091.js
*@FileTitle  : Agreement No. Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ees_lse_0091 : business script for ees_lse_0091
     */
   	/* developer job */
	// common global variables
	// Sheet Object Array
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var curEventElement = "";
	var comboCnt=0;
	var appendPageNo = 1;
   	var appendCondParam = "";
   	var rtv_total = 0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		/**********/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var comboObject1=comboObjects[0];
        var formObj=document.form;
        try {
        	var srcName=ComGetEvent("name");
        	switch(srcName) {
	        	case "btn_Calendar":
	                var cal=new ComCalendarFromTo();
	                cal.select(formObj.p_date1, formObj.p_date2, "yyyy-MM-dd");
	            break;
        		case "btn_OK":
        			comPopOK(sheetObject1,formObj); 
        			break;
        		case "btn_Close":
        			ComClosePopup(); 
        			break;
        		case "btn_New":
        			ComResetAll();
        			//setInitData();
        			
        			ComBtnDisable("btn_more");
        			for ( var k=0 ; k < comboObjects.length ; k++ ) {
        				initCombo(comboObjects[k], comboObjects[k].options.id);
        			}
        			
        			axon_event.addListenerForm('blur', 'obj_onkeyup', document.form);
        		    // CTM-COMMON (& exception)
        		    setEventProcess("cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvd_combo", "vvdcd_change");
        		    
        		    // OnKeyPress event (common function)
        		    axon_event.addListener("keypress", "obj_keypress", "cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvdcd_change");
        		    // OnKeyUp event
        		    axon_event.addListener("keyup", "obj_onkeyup", "cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvdcd_change");
        		    // OnChange event 
        		    axon_event.addListener("change", "obj_onchange", "vvdsts_change_combo");
        		    
        		    with (document.form) {
        		        // Request Setting
        		        vvd_combo.value=vvdCombo.value;
        		        if (cntrFullStsCd.value != "") cntr_full_sts_cd.value=cntrFullStsCd.value;
        		        vvd_combo.value=vvdCombo.value;
        		        mvmt_edi_rslt_cd.value=mvmtEdiRsltCd.value;
        		        if (rtyKnt.value != "") rty_knt.value=rtyKnt.value;
        		        // retrieving server ID with office code of login user
        		        doActionIBSheet(sheetObjects[0], document.form, SEARCH16);
        		        // retrieving in case parameter exists as Request
        		        if (requestYN.value == "Y") doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        		        // focusing on page loading
        		        p_date1.focus();
        		        p_date2.focus();
        		    }
        			//comboObjects[0].SetSelectText("ALL");// Initial Setting
        			break;
        		case "btn_Retrieve":
        			doActionIBSheet(sheetObject1,formObj,IBSEARCH);
        			break;
        		case "btns_Calendar": //calendar button
	            	var cal=new ComCalendarFromTo();
	            	cal.select(formObj.idx_cre_locl_fm_dt,formObj.idx_cre_locl_to_dt, 'yyyy-MM-dd');
	            	break;	
        		case "btn_more":
	                doActionIBSheet1(sheetObjects[0], formObj, IBSEARCHAPPEND, appendCondParam, appendPageNo);
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
	
	function comPopOK(sheetObj,formObject) {
		var formObject=document.form;
		var checkRows;
		var colsCnt=sheetObj.LastCol()+ 1;
 		var rows=sheetObj.RowCount();
		var rArray=null; //list containing row data
		var cArray=null; // list containing col data
		var return_val=formObject.returnval.value;
		checkRows=sheetObj.CheckedRows("check");
		
		if(checkRows == 0) {
			ComShowCodeMessage("CIM30011", ""); 
			return;
		} else {
			var idx=0;
			var chkval="";
			rArray=new Array(checkRows);
			for(var i=1; i < rows+1; i++) {
				if(sheetObj.GetCellValue(i, "check") == 1) {
					cArray=new Array(colsCnt);
					for(var j=0; j<cArray.length; j++) {
						chkval=sheetObj.GetCellValue(i, 'cntr_no');
						if(chkval=="") {  
							ComShowCodeMessage("CIM21001", "CNTR NO"); 
							return;
						}
						cArray[j]=chkval;
					}
					chkval=sheetObj.GetCellValue(i, 'cntr_no');
					rArray[idx++]=chkval;
				}
			}
		}
		
		var xxx=sheetObj.FindCheckedRow("check");
		var xxxRow=xxx.split("|");
		var errcnt=0;
		var dupcnt=0;
		
		if(Number(checkRows) <= 10000) {
			/*for(var i=1; i < xxxRow.length-1; i++){
				for(var j=i+1; j < xxxRow.length-1; j++){
					if(sheetObj.GetCellValue(xxxRow[i],'cntr_no') == sheetObj.GetCellValue(xxxRow[j],'cntr_no')){
						//sheetObj.SetRowBackColor(xxxRow[j],"#FFFF00");
						if(errcnt == 0){
							dupcnt=xxxRow[j];
						}
						errcnt++;
					}
				}
			}*/
			
			if(errcnt > 0){       
				ComShowCodeMessage("CIM21001", "CNTR NO"); 
				return false;
			}else{     
				opener.getCim_Cntri(rArray,return_val);  //호출하는 부모js에 getLse_Multi 붙여넣으면됩니다.
				ComClosePopup(); 
			}	
		}else{
			//ComShowCodeMessage("CIM21001", "CNTR NO!"); 
			ComShowCodeMessage("CIM30030","10000");
			return false;
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
     * registering IBMultiCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++]=combo_obj;
	}
	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
	 */
	function loadPage() {
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
			initCombo(comboObjects[k], comboObjects[k].options.id);
		}
		
		/* initializing IBSheet */
		for( var i=0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		/* Axon Control Setting*/
		initControl();
		//setInitData();
		//ComSetFocus(document.form.agmt_seq);
		ComBtnDisable("btn_more");
		
		axon_event.addListenerForm('blur', 'obj_onkeyup', document.form);
	    // CTM-COMMON (& exception)
	    setEventProcess("cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvd_combo", "vvdcd_change");
	    
	    // OnKeyPress event (common function)
	    axon_event.addListener("keypress", "obj_keypress", "cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvdcd_change");
	    // OnKeyUp event
	    axon_event.addListener("keyup", "obj_onkeyup", "cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvdcd_change");
	    // OnChange event 
	    axon_event.addListener("change", "obj_onchange", "vvdsts_change_combo");
	    
	    with (document.form) {
	        // Request Setting
	        vvd_combo.value=vvdCombo.value;
	        if (cntrFullStsCd.value != "") cntr_full_sts_cd.value=cntrFullStsCd.value;
	        vvd_combo.value=vvdCombo.value;
	        mvmt_edi_rslt_cd.value=mvmtEdiRsltCd.value;
	        if (rtyKnt.value != "") rty_knt.value=rtyKnt.value;
	        // retrieving server ID with office code of login user
	        doActionIBSheet(sheetObjects[0], document.form, SEARCH16);
	        // retrieving in case parameter exists as Request
	        if (requestYN.value == "Y") doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	        // focusing on page loading
	        p_date1.focus();
	        p_date2.focus();
	    }
	    
		sheet1_OnLoadFinish(sheet1);
	 }
	
	
	 function setInitData(){
        var formObj=document.form;       
        var todate=new Date();
        var calToDate=new Date(new Date(Date.parse(todate)-3*1000*60*60*24));
        ComSetObjValue(formObj.idx_cre_locl_fm_dt, ""+calToDate.getFullYear()+"-"+ComLpad(calToDate.getMonth()+1,2,"0")+"-"+ComLpad(calToDate.getDate(),2,"0"));
        ComSetObjValue(formObj.idx_cre_locl_to_dt, ComGetNowInfo("yy")+"-"+ComLpad(ComGetNowInfo("mm"),2,"0")+"-"+ComLpad(ComGetNowInfo("dd"),2,"0"));
    }
	
	//Aregistering initial event
	function initControl() {
		var formObj=document.form;
		//axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
		//axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 
		//axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키보드 입력할때
		//axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
	}
	
	

	/**
	 * handling Location blur event
	 **/
	function obj_blur(){
	    switch(ComGetEvent("name")){
	        case "agmt_seq":
	            //checking number
	            ComChkObjValid(ComGetEvent(), true, false, false);
	            break;
	        default:
	            //checking Validation
	            ComChkObjValid(ComGetEvent());
	    }
	}
	
	
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
 		var sheetID=sheetObj.id;
 		switch(sheetID) {
 			case "sheet1":
 			    with(sheetObj){
 		      var HeadTitle1="||Receving Date|CNTR No|T/S|STS|Org Yd|Event Date|Message|GATE I/O|" +
 		      		"Sight|Full STS|RCV TP|Booking No.|BL No.||Call Sign|Lloyd";
 		      
 		      var headCount=ComCountHeadTitle(HeadTitle1);
 		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

 		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
 		      var headers = [ { Text:HeadTitle1, Align:"Center"}];
 		      InitHeaders(headers, info);

 		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
 		             {Type:"CheckBox",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"check",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 		             {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"cre_locl_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		            {Type:"Text",       Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"edi_mvmt_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:1,   SaveName:"evnt_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"evnt_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:200,   Align:"Left",  ColMerge:1,   SaveName:"mvmt_edi_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:1,   SaveName:"edi_gate_io_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_edi_sght_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"cntr_full_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rcv_tp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0, Width:120,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0, Width:120,   Align:"Left",    ColMerge:1,   SaveName:"bl_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:1,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"call_sgn_lloyd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"call_sgn_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lloyd_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
 		       
 		      InitColumns(cols);
 		      //SetSheetHeight(270);
 		      ComResizeSheet(sheetObj);
 		      SetEditable(1);
 		      }
 				break;
 		}
	}
	/**
     * initializing IBMultiCombo
	 */
	function initCombo(comboObj, comboId) {
	    var frmObj=document.form;
	    with (comboObj) {
	        //no support[check again]CLT UseCode=true;
	        switch (comboId) {
		        /*case "mvmt_edi_msg_area_cd":
		        	with(comboObj) {
		            	//BackColor = "cyan";
		            	SetDropHeight(250);
		            	SetMultiSelect(0);
		            	//MaxSelect = 1;
		            	SetUseAutoComplete(1);
		            	ValidChar(2);
		            }
		        	break;*/
		        	
		        case "tpszCombo":
	                SetMultiSelect(1);
	                SetDropHeight(160);
	                // calling code_get in coCtm.js
	                var rtnValues=code_get("CNTR_TPSZ_CD", "'N' AND CNTR_TPSZ_CD  NOT IN ('Q2', 'Q4')", "DELT_FLG", "MDM_CNTR_TP_SZ");
	                // creating cntr_tpsz_cd IBMulticombo (CoCtm.js)
	                parseMultiCombo(comboObj, "^#^" + rtnValues, "ALL^#^" + rtnValues);
	                if (frmObj.cntr_tpsz_cd.value != "") {
	                    Text=frmObj.cntr_tpsz_cd.value;
	                } else {
	                    Text="ALL";
	                }
	                break;
	
	            case "statusCombo":    // ComboObject Value Settting
	                SetMultiSelect(1);
	                SetDropHeight(160);
	                InsertItem(0, "ALL", "");
	                InsertItem(1, "OP", "OP");
	                InsertItem(2, "EN", "EN");
	                InsertItem(3, "TN", "TN");
	                InsertItem(4, "OC", "OC");
	                InsertItem(5, "VL", "VL");
	                InsertItem(6, "VD", "VD");
	                InsertItem(7, "IC", "IC");
	                InsertItem(8, "ID", "ID");
	                InsertItem(9, "TS", "TS");
	                InsertItem(10, "MT", "MT");
	                InsertItem(11, "ER", "ER");
	                InsertItem(12, "CP", "CP");
	                InsertItem(13, "CT", "CT");
	                InsertItem(14, "CE", "CE");
	                InsertItem(15, "CO", "CO");
	                InsertItem(16, "CI", "CI");
	                InsertItem(17, "CD", "CD");
	                InsertItem(18, "CM", "CM");
	                InsertItem(19, "ZZ", "ZZ");
	                if (frmObj.edi_mvmt_sts_cd.value != "") {
	                    Text=ComReplaceStr(frmObj.edi_mvmt_sts_cd.value, "'", "");
	                } else {
	                    Text="ALL";
	                }
	                SetSelectIndex(0);
	                break;
	
	            case "mvmt_edi_msg_tp_id":    // ComboObject Value Settting
	                SetDropHeight(160);
	                InsertItem(0, "322", "322");
	                InsertItem(1, "COD", "COD");
	                InsertItem(2, "PRV", "PRV");
	                InsertItem(3, "ALL", "ALL");
	                Code=frmObj.mvmtEdiMsgTpId.value;
	                SetSelectIndex(3);
	                break;
	
	            case "ioStatusCombo":    // ComboObject Value Settting
	                SetMultiSelect(1);
	                SetDropHeight(160);
	                InsertItem(0, "ALL", "");
	                InsertItem(1, "I|In-Gate", "I");
	                InsertItem(2, "O|Out-Gate", "O");
	                InsertItem(3, "AE|Loaded On Vessel", "AE");
	                InsertItem(4, "UV|Unloaded From Vessel", "UV");
	                InsertItem(5, "A|Arrived. Shipment has arrived at the location specified", "A");
	                InsertItem(6, "AL|Loaded On Rail", "AL");
	                InsertItem(7, "AO|Loaded On Barge", "AO");
	                InsertItem(8, "B|Bad Order (Inoperative or Damaged). Shipment was on a piece of equipment that failed", "B");
	                InsertItem(9, "D|Completed Unloading At Delivery Location. Shipment was delivered to the consignee or receiver", "D");
	                InsertItem(10, "N|No Paperwork Received With Shipment or Equipment", "N");
	                InsertItem(11, "OA|Out-Gate", "OA");
	                InsertItem(12, "P|Departed Terminal Location. Shipment has left the carrier's terminal or other control point", "P");
	                InsertItem(13, "R|Interchange received", "R");
	                InsertItem(14, "RL|Rail Departure From Origin Intermodal Ramp", "RL");
	                InsertItem(15, "UR|Unloaded From A Rail Car", "UR");
	                if (frmObj.edi_gate_io_cd.value != "") {
	                    Text=ComReplaceStr(frmObj.edi_gate_io_cd.value, "'", "");
	                } else {
	                    Text="ALL";
	                }
	                SetSelectIndex(0);
	                break;
		    }
		}
	}
	
	/**
	 * handling process for Sheet
	 */
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg(false);
         switch(sAction) {
	         case IBCREATE:		//Lease Term Form Combo Item Setting
	         	sheetObj.SetWaitImageVisible(0);
	         	formObj.f_cmd.value=SEARCH02;
	 	        var sXml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj));
	            if ( sXml != "" ) {
	            	// "ALL" Item Insert
		            ComXml2ComboItem(sXml, comboObjects[0], "code_nm", "code_nm", "|");
		            comboObjects[0].SetSelectText("ALL");// Initial Setting
	            }
		        sheetObj.SetWaitImageVisible(1);
	            break;
         	case IBSEARCH:
         			formObj.f_cmd.value=SEARCH;
         			ComOpenWait(true);
         			rowTotal = 0;
    				rtv_total=rowTotal;					
    				if(Number(rowTotal) > formObj.pagerows.value) {
    					ComBtnEnable("btn_more");
    				}else{
    					ComBtnDisable("btn_more");
    				}
    				
    				appendPageNo=1;
    				var getDaysBetween=ComGetDaysBetween(formObj.p_date1.value, formObj.p_date2.value);
    				formObj.p_date3.value="";
                    if (getDaysBetween < 5) {
                        for (var i=0; i<=getDaysBetween; i++) {
                            if (i > 0) {
                            	formObj.p_date3.value=formObj.p_date3.value + ", ";
                            }
                            formObj.p_date3.value=formObj.p_date3.value + "'" + ComGetUnMaskedValue(ComGetDateAdd(formObj.p_date1.value, "D", i), "ymd") + "'";
                        }
                    }
    				appendCondParam = FormQueryString(formObj);	
                    
          			sheetObj.DoSearch("EES_CIM_2002GS.do",FormQueryString(formObj) );
         			ComOpenWait(false);
         		break;
            case IBSEARCH_ASYNC08:
				formObj.f_cmd.value=SEARCH01;
				var intgCdId='CD30029';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:1} );
				   return;
			    } 
				if (xml != "") {
					var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
					var arrStr=sCntrMtrlCdNm.split("@");					
					var arrCode=arrStr[0].split("|");
					formObj.pagerows.value=100;
					
				}
				break;
            case SEARCH16:
                // retrieving server ID for login user
            	formObj.user_svr_id.value=ComGetEtcData(sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH16), "rtnValue");
                if (formObj.mvmtEdiMsgAreaCd.value != "") {
                	formObj.mvmt_edi_msg_area_cd.value=frmObj.mvmtEdiMsgAreaCd.value;
                } else {
                    var userSvrId=formObj.user_svr_id.value;
                    if (userSvrId == "KOR" || userSvrId == "CHN" || userSvrId == "SWA" || userSvrId == "EUR" || userSvrId == "USA") {
                    	formObj.mvmt_edi_msg_area_cd.value=formObj.user_svr_id.value;
                    } else {
                    	formObj.mvmt_edi_msg_area_cd.value="";
                    }
                }
                break;
         }
	}
	
	
	/**
     * handling process for Sheet
     */    
    function doActionIBSheet1(sheetObj, formObj, sAction, CondParam, PageNo) {
    	switch(sAction) {
    	case IBSEARCHAPPEND:
    		if(!validateForm(sheetObj,formObj,sAction)) return;
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);     	
			sheetObj.SetWaitImageVisible(0);		
			
			sheetObj.DoSearch("EES_CIM_2002GS.do", CondParam+"&"+ "iPage="+ appendPageNo,{Append:true} );  	   
 			
	        
			break;
    	}
    }
	
	
	 function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC08); //페이징 갯수 가져오기
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}
	
	 /**
	     * handling process after retrieving screen
	 */
		function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
			var formObj = document.form;
			
			var lstTotal = sheetObj.GetEtcData("rtv_total");
	    	if (sheetObj.RowCount()< lstTotal) {
	            // setting page number for APPEND retrieving
	            appendPageNo=Math.ceil(sheetObj.RowCount()/ formObj.pagerows.value) + 1;
	            ComBtnEnable("btn_more");
	        } else {
	        	appendPageNo = 1;
	            ComBtnDisable("btn_more");
	        }		
	    	
			ComOpenWait(false); 
	}
		
	/**
	 * combo1_OnChange
	 */
	function combo1_OnChange(comboObj, Index_Code, Text) {
		var formObj=document.form;
	}
     /**
      * handing process Pop-up<br>
      * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
      * @param object
      * @param Row index
      */	
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		var formObj=document.form;
    		var sUrl='/opuscntr/COM_ENS_071.do';
			var iWidth=822;
			var iHeight=480;
			var sTargetObjList="ofc_cd:ofc_cd";
			var sDisplay="1,0,1,1,1,1,1,1";
			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
    	}
    }
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction) {
		return true;
	}
	/* end of developer job */
	
	/**
	 * IBMulti Combo Item Setting
	 * param : comboObj ==> Combo Object
	 * param : arrStrNm ==> Combo Item Text Array
	 * param : arrStrCd ==> Combo Item Code Array
	 */
	function ComMakeComboObject(comboObj, arrStrText, arrStrCode) {
		var itemCnt=comboObj.GetItemCount();
		for ( var i=0 ; i < arrStrCode.length ; i++ ) {
			comboObj.InsertItem((i+itemCnt), arrStrText[i], arrStrCode[i]);
		}
	}
	/**
	 * IBMulti Combo Item Setting
	 * Combo Item의 Text와 Code를 Delimeter로 split하여 그 배열로 Combo Item 생성
	 * param : comboObj ==> Combo Object
	 * param : sTextNm ==> Combo Item Text
	 * param : sCodeNm ==> Combo Item Code
	 * delim : delim   ==> Combo Item Text/Code Delimeter
	 */
	function ComText2ComboItem(comboObj, strText, strCode, delim) {
	   var arrStrText=strText.split(delim);
	   var arrStrCode=strCode.split(delim);
	   ComMakeComboObject(comboObj, arrStrText, arrStrCode);
	}
	/**
	 * IBMulti Combo Item Setting
	 * XML의 ETC Data에 담겨진 Combo Item의 Text와 Code를 Delimeter로 split하여 그 배열로 Combo Item 생성
	 * param : sXml     ==> IBSheet 결과 XML
	 * param : comboObj ==> Combo Object
	 * param : sTextNm  ==> Combo Item Text Name in XML ETC Date
	 * param : sCodeNm  ==> Combo Item Code Name in XML ETC Date
	 * delim : delim    ==> Combo Item Text/Code Name Delimeter
	 */
	function ComXml2ComboItem(sXml, comboObj, sTextNm, sCodeNm, delim) {
		var strText=ComGetEtcData(sXml, sTextNm);
	    var strCode=ComGetEtcData(sXml, sCodeNm);
	    ComText2ComboItem(comboObj, strText, strCode, delim);
	}
	
	
	/**
	 * Value, Column, Table을 Param으로 받아서 Value(rows data)를 가져옴
	 * param : code_value, column_nm, table_nm
	 */
	function code_get(Return, Value, Column, Table) {
	    if (!Value || !Column || !Table) return false;
	    var sheetObj=sheetObjects[0];
	    var rtnValue=ComSearchEtcData(sheetObj, "CTMCommonGS.do", "f_cmd=" + SEARCH18 + "&return_nm=" + Return + "&code_value=" + Value + "&column_nm=" + Column + "&table_nm=" + Table, "rtnValue");
	    if (rtnValue == null) {
	        return "";
	    } else {
	        return rtnValue.trim();
	    }
	}
	
	/**
	* String으로 받은 Code값과 Text로 IBMultiCombo 생성
	* Param ComboObj    : [ComboObject]
	* Param CodeString    : [Combo의 Code값 (연결문자 : ^#^)]
	* Param TextString    : [Combo의 Code값 (연결문자 : ^#^)]
	*/
	function parseMultiCombo(ComboObj, CodeString, TextString) {
	    var ComboCodeList=CodeString.split("^#^");
	    var ComboTextList=TextString.split("^#^");
	    ComboObj.RemoveAll();
	    for (var w=0; w<ComboCodeList.length-1; w++) {
	        ComboObj.InsertItem(w, ComboTextList[w], ComboCodeList[w]);
	    }
	}

	
	/**
	 * handling OnKeyUp event in HTML Object
	 */
	function obj_onkeyup(event) {
	    srcValue = event.srcElement.value;  
	    var frmObj = document.form;
	    var sheetObj = sheetObjects[0];
	    switch(event.srcElement.name) {
	        case "cntrno_disp":
	            frmObj.cntrno_disp.value = frmObj.cntrno_disp.value.toUpperCase();
	            var cntrnoDisp = frmObj.cntrno_disp;
	            if (cntrnoDisp.value.length > 1) {
	                frmObj.p_cntrno.value = cntrnoDisp.value;
	                if (cntrnoDisp.value.length > 9) {
	                    // calling cntr_search in CTM common function in case p_cntrno is 10 characters
	                    if (!cntr_search()) {
	                        cntrnoDisp.select();
	                        cntrnoDisp.focus();
	                    } else {
	                        setFocusIndex(event.srcElement, 1);
	                    }
	                } else {
	                    frmObj.check_digit.value = "";
	                }
	            } else {
	                frmObj.p_cntrno.value = "";
	                frmObj.check_digit.value = "";
	            }
	            break;

	        case "yd_cd_disp":
	            var ydCdDisp = frmObj.yd_cd_disp;
	            if (ydCdDisp.value.length > 1) {
	                frmObj.p_yard1.value = ydCdDisp.value;
	                if (ydCdDisp.value.length > 4) {
	                      // calling yard_search() in CTM common function in case p_yard1 is 5 characters
	                      if (!yard_search()) {
	                            ydCdDisp.select();
	                            ydCdDisp.focus();
	                      } else {
	                    	  frmObj.p_yard2.focus();
	                      }
	                } else {
	                    p_yard2.RemoveAll();
	                }
	            } else {
	                frmObj.p_yard1.value = "";
	                p_yard2.RemoveAll();
	            }
	            break;

	        case "vvdcd_change":
//	        	if (frmObj.vvdsts_change_combo.value == "VVD") {
//		            var vvdCd = frmObj.vvdcd_change;
//		            if (vvdCd.value.length > 8) {
//		                var xml = sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH12 + "&vvdcode=" + vvdCd.value);
//		                var rtnValue = ComGetEtcData(xml, "rtnValue");
//		                if (rtnValue) {
//		                    if (sheetObj.CheckedRows("Sel") < 1) return;
//		                    if (sheetObj.RowCount < 1) return;
//		                } else {
//		                    sheetObj.LoadSearchData(xml);
//		                    vvdCd.select();
//		                    vvdCd.focus();
//		                }
//		            }
//		            break;
//	        	} else {
	        		break; 
//	        	}

	        case "lcc_cd":
	        case "rcc_cd":
	            var loc_cd = event.srcElement;
	            // calling code_search() in CTM common function in case 5 characters entered in lcc_cd or rcc_cd 
	            if (loc_cd.value.length > 4) {
	                // focusing on current element in case result is false means no value in Table
	                if (!code_search(loc_cd.value, "LOC_CD", "MDM_LOCATION")) {
	                    event.srcElement.select();
	                    event.srcElement.focus();
	                //  focusing on next element
	                } else {
	                    setFocusIndex(loc_cd, 1);
	                }
	            }
	          break;
	    }
	    onShowErrMsg = false;    
	}
	
	/**
	 * handling OnChange event in HTML Object
	 */
	function obj_onchange(event) {
	    var frmObj=document.form;
	    switch(ComGetEvent("name")) {
	        case "vvdsts_change_combo":
	            var vvdStsCombo=frmObj.vvdsts_change_combo;
	            frmObj.vvdcd_change.style.width="120px";
	            
	            if (vvdStsCombo.value == "STATUS") {
	                frmObj.stscd_change.style.display="inline";
	                frmObj.vvdcd_change.style.display="none";
	                frmObj.vvdcd_change.value="";
	                frmObj.stscd_change.focus();
	            } else {
	                frmObj.vvdcd_change.style.display="inline";
	                frmObj.stscd_change.style.display="none";
	                frmObj.stscd_change.selectedIndex=0;
	                frmObj.vvdcd_change.value="";
	                if (vvdStsCombo.value == "CNTR") {
	                	frmObj.vvdcd_change.maxLength = 11;
	                } else if (vvdStsCombo.value == "YARD") {
	                	frmObj.vvdcd_change.maxLength = 7;
	                } else if (vvdStsCombo.value == "BKG") {
	                	frmObj.vvdcd_change.maxLength = 13;
	                } else if (vvdStsCombo.value == "VVD") {
	                	var vvdCd = frmObj.vvdcd_change;
	    	            if (vvdCd.value.length > 8) {
	    	                var xml = sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH12 + "&vvdcode=" + vvdCd.value);
	    	                var rtnValue = ComGetEtcData(xml, "rtnValue");
	    	                if (rtnValue) {
	    	                    if (sheetObj.CheckedRows("Sel") < 1) return;
	    	                    if (sheetObj.RowCount < 1) return;
	    	                } else {
	    	                    sheetObj.LoadSearchData(xml);
	    	                    vvdCd.select();
	    	                    vvdCd.focus();
	    	                }
	    	            }
	    	            break;
	                	frmObj.vvdcd_change.maxLength = 9;
	                } else if (vvdStsCombo.value == "FM") {
	                	frmObj.vvdcd_change.maxLength = 2;
	                	
	                }else if (vvdStsCombo.value == "REMARK") {
	                	frmObj.vvdcd_change.maxLength = 200;
	                	frmObj.vvdcd_change.style.width="250px";
	                }
	                
	                frmObj.vvdcd_change.focus();
	            }
	            break;
	    }
	    onShowErrMsg=false;
	}
	
	
	/**
	 * handling MultiSelection OnCheckClick event in tpszCombo
	 */
	function tpszCombo_OnCheckClick(comboObj, index, code) {
	    // coCtm multiComboOnCheckClick
	    multiComboOnCheckClick(comboObj, index, document.form.cntr_tpsz_cd);
	}
	//tpszCombo
	function tpszCombo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	    //document.form.tpszCombo_text.value = newCode;
	}

	function tpszCombo_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	    //document.form.tpszCombo_text.value = tpszCombo.GetSelectCode();
	}
	/**
	 * handling MultiSelection OnCheckClick event in    
	 */
	function statusCombo_OnCheckClick(comboObj, index, code) {
	    // CoCtm.js multiComboOnCheckClick
	    multiComboOnCheckClick(comboObj, index, document.form.edi_mvmt_sts_cd);
	}

	function vvd_combo_onchange() {
	    form.vvd_value.value = "";
	}

	/**
	 * mvmt_edi_msg_tp_id??MultiSelection OnChange ??벤??처리
	 */
	function mvmt_edi_msg_tp_id_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	    var mvmtEdiRsltCd=document.form.mvmt_edi_rslt_cd;
	    if (oldIndex == "SPP") {
	        mvmtEdiRsltCd.value="Y";
	        ComEnableObject(mvmtEdiRsltCd, false);
	    } else {
	        mvmtEdiRsltCd.value="N";
	        ComEnableObject(mvmtEdiRsltCd, true);
	    }
	}

	/**
	 * handling MultiSelection OnCheckClick event in ioStatusCombo
	 */
	function ioStatusCombo_OnCheckClick(comboObj, index, code) {
	    // coCtm??multiComboOnCheckClick ??출
	    multiComboOnCheckClick(comboObj, index, document.form.edi_gate_io_cd);
	}

	/**
	 * MultiCombo(MultiSelection허용)의 MultiSelection OnCheckClick 이벤트 처리
	 *  HTML object가 있을경우 쿼리의 In 조건에 사용가능한 "('A', 'B', 'C')" 형식을 setting
	 */
	function multiComboOnCheckClick(comboObj, index, htmlObj) {
	    // 선택된 Index가 없을 경우는 0번 Index 강제 선택
	    if (comboObj.GetSelectText()== null || comboObj.GetSelectText()== "") {
	        comboObj.SetItemCheck(0,1,false);
	        if (typeof(htmlObj) == "object") htmlObj.value="";
	    } else {
	        // Index 0번이 선택된 경우는 다른 모든 Index체크를 해제
	        if (index == 0) {
	            for(var i=1; i<comboObj.GetItemCount(); i++) {
	                comboObj.SetItemCheck(i,0,false);
	            }
	            // Submit할 내용도 Clear
	            if (typeof(htmlObj) == "object") htmlObj.value="";
	        // 다른Index가 선택된 경우는 Index 0을 해제
	        } else {
	            comboObj.SetItemCheck(0,0,false);
	            // Submit할 내용 Define
	            if (typeof(htmlObj) == "object") htmlObj.value="'" + ComReplaceStr(comboObj.GetSelectCode(), ",", "', '") + "'";
	        }
	    }
	}
	
	
	/***********************************************************************
	 * 메소드를 새로 만들면서 위에 정의된 메소드는 대부분 사용하지 않으나  *
	 * 기본적인 메소드는 사용중이기 때문에 삭제하면 안됨                   *
	 ***********************************************************************/
	/**
	 * FORM의 모든 객체에 대하여 Enter값을 처리하기 위한 KeyDown Event 설정.
	 * eventObj 제외 대상
	 */
	function setEventProcess(eventObj) {
	    var docForm=document.form;
	    var len=docForm.elements.length - 1;
	    var formElement=null;
	    var elementName=null; 
	    for (i=0 ; i <= len ; i++) {
	        /** 전체 Element 객체중 현재 커서가 가있는 Element 를 얻어온다. */
	        formElement=docForm.elements[i];
	        elementName=getSrcElementName(formElement);
	        if (elementName=="") continue;
	        /**************************************************************************
	         *   EVENT를 선택적으로 타게 하기 위해 eventObj와 elementName을 비교하고  *
	         *  동일한 Element에 대해서 Event Skip                                    *
	         **************************************************************************/
	        isFind=false;
	        switch(elementName){
	            case "sheet":
	            case "sheet1":
	            case "sheet2":
	                if (BrowserDetect.browser == "Explorer") {
	                    formElement.attachEvent("onblur", eval( elementName + "_blur"));
	                } else {
	                    formElement.addEventListener("blur", eval( elementName + "_blur"), false);
	                }
	                isFind=true;
	                break;
	            default:
	                if(arguments.length) {
	                    for (j=0; j <= arguments.length; j++) {
	                        if (elementName == arguments[j]) {
	                            isFind=true;
	                            break;
	                        }
	                    }
	                }
	                break;
	        }        
	        if (isFind == true)  continue;
	        
	        switch(formElement.type){
	            case "password":
	            case "text":
	            case "textarea":
	                /** 이벤트를 설정하기 위하여 Element List를 생성한다. */
	                /** 이벤트는 KeyPress 와 KeyUp만 사용하도록 지정한다. */
	                //formElement.value="111111";
	                if (BrowserDetect.browser == "Explorer") {
	                    formElement.attachEvent("onkeypress", obj_keypress);
	                    formElement.attachEvent("onkeyup", obj_keyup);
	                    formElement.attachEvent("onkeydown", obj_keydown);
	                    formElement.attachEvent("onfocus", date_focus);
	                    formElement.attachEvent("onblur", obj_blur);
	                } else {
	                    formElement.addEventListener("keypress", obj_keypress, false);
	                    formElement.addEventListener("keyup", obj_keyup, false);
	                    formElement.addEventListener("keydown", obj_keydown, false);
	                    formElement.addEventListener("focus", date_focus, false);
	                    formElement.addEventListener("blur", obj_blur, false);

	                }
	                break;
	        }
	        
	    }
	}
	
	
	/**
	 * Container No 이벤트
	 * param : combo_obj ==> 콤보오브젝트
	 */
	function cntr_search() {
	    frmObj=document.form;
	    cntrno=frmObj.p_cntrno.value.toUpperCase();
	    if (cntrno == "") {
	        return;
	    }
	    if (cntrno.length < 10) {
	        if (typeof(frmObj.check_digit) == "object") frmObj.check_digit.value="";
	        if (typeof(frmObj.ctnr_tpsz_cd) == "object") frmObj.ctnr_tpsz_cd.value="";
	    }
	    if (onShowErrMsg) {
	        onShowErrMsg=false; //이미 동일한 오브젝트에 동일한 내용으로 이벤트를 수행 하였다.
	        return false;
	    }
	    onShowErrMsg=true;
	    var sheetObj=sheetObjects[0];
	    xml=sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH10 + "&p_cntrno=" + cntrno);
	    rtnValue=ComGetEtcData(xml, "rtnValue");
	    if (rtnValue == null) {
	        if (typeof(frmObj.check_digit) == "object") frmObj.check_digit.value="";
	        if (typeof(frmObj.ctnr_tpsz_cd) == "object") frmObj.ctnr_tpsz_cd.value="";
	        sheetObj.LoadSearchData(xml,{Sync:1} );
	        return false;
	    }
	    frmObj.check_digit.value="";
	    parseCTNRNo(rtnValue, frmObj);
	    return true;
	}
	
	/**
	 * 객체를 받아 객체의 이름을 리턴한다.
	 */
	function getSrcElementName(formElement) {
	    return formElement.name || formElement.id;
	}
	
	/**
	 * KeyPress에 대한 이벤트 처리
	 */
	function obj_keypress(event) {
	    /** 대소문자, 숫자등 타입에 관련된 내용을 실행한다. */
	    obj_FormatString(event);
	    /** 엔터키가 입력되거나 탭키가 입력 되었을 경우의 이벤트를 처리한다. */
	    obj_enterProcess(event);
	}
	
	/*************************************************
	 * Key Event를 감지하고 길이에 의한 Validation.  *
	 * 또는 Key Code에 의한 Validation을 실행한다    *
	 *************************************************/
	function obj_keyup(event) {
	    /** 입력된 내용의 길이를 구하고 최대값과 동일하면 자동 이벤트를 부른다 */
	    var eventElement=ComGetEvent();
	    //try {
	        if (eventElement == null) return;
	        if (eventElement.type != "text") return;
	        var elementName=getSrcElementName(eventElement);
	        var maxLength=eventElement.getAttribute("maxlength");
	        var curValue=eventElement.value;
	        // Focus를 넘길 것인지 결정하는 Boolean변수
	        var flgNext=false;
	        if (curEventElement == elementName && curEventElementEvent == event.type) {
	            if (curEventElementEvent == "blur") {
	                onShowErrMsg=false; // 동일 이벤트로 리턴 처리 했음.
	                return;
	            }
	            curEventElementEvent=event.type;
	        } else {
	            curEventElementEvent=event.type;
	        }
	        curEventElement=elementName;
	        /** 날짜에 관련 된 내용들이다. 날짜 처리를 해주도록 한다 */
	        if (elementName.substring(0, 6) == "p_date") {
	            obj=ComGetEvent();
	            objValue=ComReplaceStr(obj.value,"-","");
	            curKeyCode="";
	            if (objValue.length == 8) {
	                checkDateFormat(obj, elementName);
	                dateFormatFalse=0;
	                cancelDate=true;
	            } else {
	                cancelDate=false;
	            }
	            return;
	        }
	        // 입력된 내용이 null이고 Key Code가 Tab이면  포커스를 이동시키지 않고
	        // 현재 위치에 고정하기 위해 TabIndex를 현재값으 -1로 처리해서 Focus를 넘겨준다
	        if (curValue == null || curValue == "") {
	            if (curKeyCode == "9") {
	                tmp=GetObjectByTabIndex(eventElement.tabIndex-1);
	                if (tmp == null) GetObjectByTabIndex(1);
	                curValue=tmp.value;
	            } else {
	            }
	            onShowErrMsg=false; // 길이 제한으로 리턴 처리 했음.
	            if (curValue.length < 10) {
	                if (typeof(form.check_digit) == "object") document.form.check_digit.value="";
	                if (typeof(form.ctnr_tpsz_cd) == "object") document.form.ctnr_tpsz_cd.value="";
	                if (curKeyCode != "9") return;
	            }
	            return;
	        }
	        if (srcValue != null && srcValue == curValue) {
	            // 기존 문자열이 이미 존재 하고 있었다. 문자열이 완전히 바뀔 때까지 모든 이벤트 중지
	            srcV=srcValue.substring(srcValue.length -1);
	            curV=curValue.substring(curValue.length -1);
	            // 마지막 문자가 동일하다. 이벤트를 보류하고 리턴한다. 그렇지 않은 경우 다음으로 진행
	            // 그러나 키가 탭이라면 예외로 처리한다.
	            if (curKeyCode == "9") {
	                if (srcValue == curValue) {
	                    onShowErrMsg=false;    // 동일 문자열 리턴처리.
	                    //document.form.p_vvdcd.value ="3 " + event.type;
	                    return;
	                }
	            } else if(srcV == curV) {
	                onShowErrMsg=false;    // 마지막 문자열이 동일 리턴처리.
	                //document.form.p_vvdcd.value ="4 " + event.type;
	                return;
	            }
	        }
	        if (maxLength == curValue.length || curKeyCode == "13") {
	            if (srcValue == curValue) return;
	            /** 입력된 문자열이 최대값과 동일함. 문자열에 따른 포맷 변환 */
	            switch(elementName) {
	                case "p_cntrno" :
	                    flgNext=cntr_search();
	                    break;
	                case "p_yard1":
	                    flgNext=yard_search();
	                    break;
	                default :
	                    flgNext=true;
	                    break;
	            }
	            /** 이벤트가 종료 된 후 다음으로 포커스를 옮겨준다 */
	            if (flgNext) {
	                if (curKeyCode == "9") {
	                    // 탭키가 실행되어진 상태이다. 초기화 시키고 종료한다.
	                    curKeyCode="";
	                } else {
	                    if (elementName == "p_yard1") {
	                        p_yard2.Focus();
	                    }
	                    else {
	                        objTmp=setFocusIndex(eventElement, 1);
	                        try {
	                            objTmp.focus();
	                        } catch (e) {}
	                    }
	                    curKeyCode="";
	                    return;
	                }
	            } else {
	                if (curKeyCode == "9") {
	                    // 탭키가 실행되어진 상태이다. 초기화 시키고 종료한다.
	                    curKeyCode="";
	                    try {
	                        eventElement.select();
	                        eventElement.focus();
	                    } catch (e) {}
	                } else {
	                    curKeyCode="";
	                    try {
	                        eventElement.select();
	                        eventElement.focus();
	                    } catch (e) {}
	                }
	            }
	        } else {
	            switch(elementName) {
	                case "p_cntrno" :
	                    if (curValue.length < 10) {
	                        if (typeof(form.check_digit) == "object") document.form.check_digit.value="";
	                        if (typeof(form.ctnr_tpsz_cd) == "object") document.form.ctnr_tpsz_cd.value="";
	                        if (curKeyCode != "9") return;
	                    }
	                    break;
	                case "p_yard1":
	                    if (curValue.length < 5) {
	                        if (typeof(p_yard2) == "undefined" ) break;
	                        if (typeof(p_yard2) == "object") p_yard2.RemoveAll();
	                    }
	                    break;
	                default :
	                    flgNext=true;
	                    break;
	            }
	        }
	        //event.cancelbubble = true;
	    //} catch (e) {
	    //    ComFuncErrMsg ("오류가 발생 했음 :" + e + ":" + eventElement.name);
	    //}
	}
	
	/**
	 * Key Down에 대한 이벤트. TAB을 제외한 모든 키는 무시한다
	 * tab이 눌려진 Object의 이름이 cntr_no이거나 date이면
	 * 포맷 체크를 실행한다.
	 * date가 from-to로 구성된경우도 포맷체크를 실행한다.
	 */
	function obj_keydown(event) {
	     if (ComGetEvent("keycode") == "9") {
	        curKeyCode="9";
	        try {
	            formElement=ComGetEvent();
	            formElement.value=formElement.value.toUpperCase();
	            elementName=getSrcElementName(formElement);
	            if (elementName == "p_cntrno") {
	                if (cntr_search()) {
	                    return;
	                } else {
	                    tmp=setFocusIndex (formElement, 0);
	                    formElement.select();
	                    formElement.focus();
	                    return false;
	                }
	            } else if (elementName.substring(0, 6) == "p_date") {
	                if (formElement.value.length == 8) {
	                    formElement.value=ComGetMaskedValue(formElement.value, "ymd");
	                    dateFormatFalse=0;
	                    cancelDate=true;
	                }
	            } else {
	                obj_keyup (event);
	            }
	            return;
	        } catch (e) {}
	    }else if (ComGetEvent("keycode") == "8") {
	        try {
	            formElement=ComGetEvent();
	            elementName=getSrcElementName(formElement);
	            if (elementName == "p_cntrno") {
	                frmObj=document.form;
	                cntrno=frmObj.p_cntrno.value.toUpperCase();
	                if (cntrno == "") {
	                    if (typeof(frmObj.check_digit) == "object") frmObj.check_digit.value="";
	                    if (typeof(frmObj.ctnr_tpsz_cd) == "object") frmObj.ctnr_tpsz_cd.value="";
	                    return;
	                }
	            }
	        } catch (e) {}
	    }
	}
	/******************************************
	 * FOCUS가 빠져나갈 때 포맷체크를 실행한다*
	// ******************************************/
	function obj_blur(event) {
	    try {
	        formElement=ComGetEvent();
	        formElement.value=formElement.value.toUpperCase();
	        var elementName=getSrcElementName(formElement);
	        if (elementName.substring(0, 6) == "p_date") {
	            if (formElement.value.length < 8 && cancelDate == false) {
	                rtn=checkDateFormat(formElement, elementName);
	                dateFormatFalse=0;
	            } else {
	                formElement.value=ComGetMaskedValue(formElement.value, "ymd");
	                return;
	            }
	        } else {
	            obj_keyup(event);
	        }
	    } catch (e) {}
	}
	
	/**
	 * 달력INPUT에 focus시 선택한 상태로 바꿈.
	 */
	function date_focus(event) {
	    try {
	        cancelDate=false;
	        curKeyCode="";
	        getFocus(event);
	        ComGetEvent().select();
	    } catch (e) {
	    }
	}
	
	/**
	 * 서버에서 넘겨받은 컨테이너정보중 Type Size , Check Digit를 Input에 입력하기 위해 사용함.
	 * @param CTNRNO  : 서버에서 리턴된 컨테이너 정보 String
	 * @param formObj : form object
	 */
	function parseCTNRNo(CTNRNO, formObj) {
	    if (!CTNRNO) return;
	    var CtnrVal=CTNRNO.split("|");
	    if (CtnrVal.length >= 3) {
	        if (formObj.check_digit) {
	            formObj.check_digit.value=CtnrVal[0].substring(10,11);
	        }
	        if (formObj.ctnr_sts_cd) {
	            formObj.ctnr_sts_cd.value=CtnrVal[1];
	        }
	        if (formObj.ctnr_tpsz_cd) {
	            formObj.ctnr_tpsz_cd.value=CtnrVal[2];
	        }
	    } else {
	        if (formObj.check_digit) {
	            formObj.check_digit.value="";
	        }
	        if (formObj.ctnr_sts_cd) {
	            formObj.ctnr_sts_cd.value="";
	        }
	        if (formObj.ctnr_tpsz_cd) {
	            formObj.ctnr_tpsz_cd.value="";
	        }
	    }
	}
	
	/**
	 *탭 인덱스를 + 시키거나 - 시키도록 지정한다.
	 */
	function setFocusIndex(obj, idx) {
	    var tmp=null;
	    tmp=GetObjectByTabIndex(Number(obj.tabIndex) + Number(idx), idx);
	    if (tmp != null) {
	        tmp.focus();
	    } else {
	        tmp=GetObjectByTabIndex(1, 0);
	    }
	    return tmp;
	}
	
	/**
	 * 이벤트 종료시 자동으로 탭을 옮겨 준다.
	 */
	function GetObjectByTabIndex(index, idx) {
	    for (i=0; i < document.forms[0].length; i++) {
	        tmp=document.forms[0].elements[i];
	        if (tmp.tabIndex == index)
	        {
	            if (tmp.getAttribute("display") == "none") {
	                index=Number(index) + Number(idx);
	            } else
	                return tmp;
	        }
	    }
	    return null;
	}
	
	/**
	 * YARD 이벤트
	 * Yard Code Change혹은 Focus Out으로 발생하고 리턴은 true/ false만 해준다.
	 */
	function yard_search() {
	    formObj=document.form;
	    p_yard=formObj.p_yard1.value;
	    if (p_yard.length == 5) {
	        if (onShowErrMsg) {
	            onShowErrMsg=false; //이미 동일한 오브젝트에 동일한 내용으로 이벤트를 수행 하였다.
	            return false;
	        }
	        onShowErrMsg=true; // 체크 로직을 수행한다.
	        var sheetObj=sheetObjects[0];
	        formObj.f_cmd.value=SEARCH11;
	        xml=sheetObj.GetSearchData("CTMCommonGS.do", FormQueryString(formObj));
	        rtnValue=ComGetEtcData(xml, "rtnValue");
	        svrChk=ComGetEtcData(xml, "svrChk");
	        obj= p_yard2;
	        if (obj == null || obj == 'null') return false;
	        if (rtnValue == null) {
	            obj.RemoveAll();
	            sheetObj.LoadSearchData(xml,{Sync:1} );
	            return false;
	        } else {
	            parseYardMultiCombo(rtnValue, obj);
	            return true;
	        }
	    } else return false;
	}
	
	/**
	 * IBCombo 멀티콤보 데이터 세팅
	 * @param YardCode
	 * @param comboObj : 여러개의 Multi Combo가 있을 수 있기 때문에 ComboObject를 받아서 처리하도록 한다
	 */
	function parseYardMultiCombo(YardCode, comboObj) {
	    if (!YardCode) return;
	    var YardList=YardCode.split("^");
	    comboObj.RemoveAll();
	    for (i=0; i <= YardList.length; i++) {
	        if (YardList[i]) {
	            YardValue=YardList[i].split("|");
	            comboObj.InsertItem(i, YardValue[0] + "|" + YardValue[1], YardValue[0]);
	        }
	    }
	    comboObj.SetUseAutoComplete(1);
	    //지원안함[확인요망]HANJIN: comboObj.ValidChar(2, 1);    // 영대문자 + 숫자만 입력
	}