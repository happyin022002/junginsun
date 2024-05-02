/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0021.js
*@FileTitle  : Off-Hire CNTR List - Send to Lessor 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class EES_LSE_0021 : business script for EES_LSE_0021
	 */
	function EES_LSE_0021() {
		this.processButtonClick=processButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.sheet1_OnLoadFinish=sheet1_OnLoadFinish;
		this.initSheet=initSheet;
		this.doActionIBSheet=doActionIBSheet;
		this.sheet1_OnMouseMove=sheet1_OnMouseMove;
		this.openPopup=openPopup;
		this.callbackSendMail=callbackSendMail;
		this.getBackEndJobStatus=getBackEndJobStatus;
		this.getBackEndJobLoadFile=getBackEndJobLoadFile;
		this.delayActionIBSheet=delayActionIBSheet;
		this.validateForm=validateForm; 
	}
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sendFlag=false;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
    function processButtonClick(){
        /**********/
		var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObj=document.form;
    	try {
			var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_save":
        			doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
                	break;
				case "btn_email":
					openPopup("1");
					break;
				case "btn_downexcel":
						if(sheetObject.FindCheckedRow("del_chk") == "") {
							ComShowMessage("There is no contents to save.");
		    				return false;
						} else {
							var vSkipRows="";
							for(var i=0; i <= sheetObject.RowCount()+1; i++) {
								if(sheetObject.GetCellValue(i, "del_chk") != 0) {
									vSkipRows += i+"|";
								}
							}
							if(sheetObject.RowCount() < 1){//no data
								ComShowCodeMessage("COM132501");
							}else{
								sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject),DownRows:vSkipRows, SheetDesign:1,Merge:1 });
							}
							
						}
					break;
                case "btn_close":
                	if(sendFlag == true) {
//    					opener.callbackPopupMail(500);
    					parent.callbackPopupMail(500);
                	}
                		ComClosePopup(); 
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
    
    function sheet1_OnSaveEnd(sheetObj , code, ErrMsg) { 
    	var formObj=document.form;
    	ComShowCodeMessage("COM130102", "Data");
    	sendFlag = true;
    	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
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
        sheet1_OnLoadFinish(sheet1);
    }
	/**
	 * calling event after Load-Finish
	 */
    function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		//doActionIBSheet(sheetObj, formObj, IBSEARCH);
		doActionIBSheet(sheetObj, formObj, IBBATCH);
		
    }
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetid=sheetObj.id;
		var formObj=document.form;
        switch(sheetid) {
            case "sheet1":
				with (sheetObj) {
	                var HeadTitle1="";
	                if(/2|3/.test(formObj.loc_case.value)) {//Location Case is Lane or Port
	                HeadTitle1="|SEL.||Lessor|Lessor||AGMT No.|||Lease\nTerm|Ref No.|Year Build|TP/SZ|CNTR No.|VVD|Current\nYard|Return\nYard|Off-Hire\nYard|Off-Hire\nDue Date|RU Label Type|RU Label Value|MT/Full|MVMT\nState|MVMT\nDate|On-Hire\nYard|On-Hire\nDate|Min On-Hire\nDays|Used\nDays|Free\nDays|Stay Day|Reefer Unit Maker|Auth No|M&R Cost|BKG No.|B/L No.|POL|POD|DEL|Consignee|Haulage|R.Office|ETD-DT|ETA-DT|";
	                } else {
	                HeadTitle1="|SEL.||Lessor|Lessor||AGMT No.|||Lease\nTerm|Ref No.|Year Build|TP/SZ|CNTR No.|Current\nYard|Return\nYard|Off-Hire\nYard|Off-Hire\nDue Date|RU Label Type|RU Label Value|MT/Full|MVMT\nState|MVMT\nDate|On-Hire\nYard|On-Hire\nDate|Min On-Hire\nDays|Used\nDays|Free\nDays|Stay Day|Reefer Unit Maker|Auth No|M&R Cost|BKG No.|B/L No.|POL|POD|DEL|Consignee|Haulage|R.Office|ETD-DT|ETA-DT|VVD|";
	                }
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                //(headCount, 13, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                          {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
	                          {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:70,  Align:"Center",    ColMerge:1,   SaveName:"yr_bld",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                   if(/2|3/.test(formObj.loc_case.value)) {//Location Case is Lane or Port
	                cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                }
	                cols.push({Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"mty_rtn_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"off_hire_yard",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"off_hire_due_date",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"rstr_usg_lbl_tp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }),
	                cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"rstr_usg_lbl_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }),
   	                cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"full_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"onh_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Int",       Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"min_onh_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"used_days",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"onh_free_dys",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                
	                cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"stay_dys",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rf_ut_mkr",          KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cntr_auth_no",       KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });

	                cols.push({Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_cost",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                
	                cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cnee_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hlg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });

	                cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"evnt_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"pol_etd_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"pod_eta_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                if(!/2|3/.test(formObj.loc_case.value)) {//Location Case is Lane or Port
	                cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                }
	                cols.push({Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"complex_pk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	              
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
	                SetSheetHeight(270);
				}
				break;
        }
    }
  	// handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:
				if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("EES_LSE_0021GS.do",FormQueryString(formObj) );
				}
				break;
			case IBBATCH:      //retrieving for BackEndJob
				if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=COMMAND01;
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					var sXml=sheetObj.GetSearchData("EES_LSE_0021GS.do", FormQueryString(formObj));
					var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
					if (backendJobKey.length > 0) {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.SetWaitTimeOut(10000);
						timer1=setInterval(getBackEndJobStatus, 3000);
					}
				}
				break;
			case IBSAVE:
                if(validateForm(sheetObj, formObj, sAction)) {
                    if(sheetObj.id == "sheet1") {
                        formObj.f_cmd.value = MULTI01;
                        sheetObj.DoSave("EES_LSE_0021GS.do", FormQueryString(formObj), -1, false);
                        //
                    }
                }
                break;
        }
    }
	/**
	 * handling event when OnMouseMove Sheet.
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			Row=MouseRow();
			Col=MouseCol();
			if(Row >= HeaderRows()&& ColSaveName(Col) == "vndr_seq") {
				sText=GetCellText(Row,Col);
//no support[check again]CLT 				MouseToolTipText=GetCellText(Row,"vndr_lgl_eng_nm");
			} else {
//no support[check again]CLT 				MouseToolTipText="";
			}
		}
	}
	/**
     * handing process Pop-up<br>
     * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
     * @param object
     * @param Row index
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	if ( type == "1" ) {
			with(sheetObj) {
				if(FindCheckedRow("del_chk") == "") {
					ComShowMessage("There is no contents to save.");
				} else {
					var vCntrItems="";
					for(var i=HeaderRows(), cnt=1; i <= RowCount()+1; i++) {
						if(GetCellValue(i, "del_chk") == 1) {
		            		vCntrItems += "<tr align='center'><td>"+ cnt++ +"</td>";
		            		vCntrItems += "<td>"+ GetCellValue(i, "cntr_no") +"</td>";
		            		vCntrItems += "<td>"+ GetCellValue(i, "off_hire_yard") +"</td>";
		            		vCntrItems += "<td>"+ GetCellValue(i, "off_hire_due_date") +"</td>";
		            		vCntrItems += "<td></td></tr>";
						}
					}
					formObj.argument.value="send_dt;"+ formObj.curr_dt.value;
		    		formObj.argument.value += ",cntr_list;" + vCntrItems;
		    		var vFeatures="status=no, resizable=no, scrollbars=no, width=" + 770
							  	  + ", height=" + 780 + ", left=" + (screen.width -770) / 2
							  	  + ", top=" + (screen.height -780) / 2;
		    		window = this;
	    			ComPostOpenWindow("/opuscntr/EES_LSE_0021_01.do?f_cmd=", "EES_LSE_0021_01", vFeatures);
				}
			}
    	}
    	return;
    }
	/**
	 * calling after E-mail
	 */
	function callbackSendMail(interval) {
		timer2=setInterval(delayActionIBSheet, interval);
	}
	/**
	 * retrieving status 3 for BackEndJob result
	 */
	function getBackEndJobStatus() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_cmd.value=COMMAND02;
		var sXml=sheetObj.GetSearchData("EES_LSE_0021GS.do", FormQueryString(formObj));
		var jobState=ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			document.body.style.overflow="hidden";
			getBackEndJobLoadFile();
			clearInterval(timer1);
		} else if (jobState == "4") {
			ComShowCodeMessage("LSE01124");
			ComOpenWait(false);
			sheetObj.SetWaitImageVisible(1);
			clearInterval(timer1);
		} else if (jobState == "5") {
			ComShowCodeMessage("LSE01125");
			clearInterval(timer1);
		}
	}
	/**
	 * downloading result file of BackEndJob
	 */
	function getBackEndJobLoadFile() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_cmd.value=COMMAND03;
		var sXml=sheetObj.GetSearchData("EES_LSE_0021GS.do", FormQueryString(form));
		sheetObj.LoadSearchData(sXml,{Sync:0} );
		ComOpenWait(false);
		sheetObj.SetWaitImageVisible(1);
	}
	/**
	 * handling process for delay Sheet
	 */
	function delayActionIBSheet() {
		var formObj=document.form;
		doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
		clearInterval(timer2);
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    			case IBSEARCH:
    			case IBBATCH:      	//retrieving for BackEndJob
    				return ComChkValid(formObj, false);
    				break;
				default :	//do nothing
    		}
    	}
	    with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:
	    			return true;
	    			break;
	    		default : 	//do nothing
    		}
    	}
        return true;
    }
	/* end of developer job */
