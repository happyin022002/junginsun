/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_3001.js
*@FileTitle  : Controlling Party Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	var sheetObjects=new Array();
    var sheetCnt=0;
    
    var dblClickStatus=0;
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** using extra sheet valuable if there are more 2 sheets *****/
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	var sheetObject3=sheetObjects[2];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
   			case "btn_retrieve":
   				
   				var SaveStr1 = sheetObjects[0].GetSaveString(0);
				var SaveStr2 = sheetObjects[1].GetSaveString(0);
				var SaveStr3 = sheetObjects[2].GetSaveString(0);
				if(SaveStr1 != "" || SaveStr2 != ""  || SaveStr3 != ""){
					if(ComShowCodeConfirm('BKG00254')){
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
					}
				}
				
   				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   				break;
   			case "btn_save":
   				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
   			case "btn_RowAdd1":
				addRow(sheetObjects[0]);
				break;
			case "btn_RowDel1":
//				var sRow = sheetObjects[0].FindCheckedRow("chk");
//				sheetObjects[0].SetRowHidden(sRow, 1);
				
				deleteRow(sheetObjects[0]);
				break;
			case "btn_RowAdd2":
				if(dblClickStatus == 1){
					addRow(sheetObjects[1]);
				}else if (dblClickStatus != 1){
					ComShowMessage("This Row Add Button is available only when you did double click parents table's Row.");
   				}
				break;
			case "btn_RowDel2":
//				var sRow = sheetObjects[1].FindCheckedRow("chk");
//				sheetObjects[1].SetRowHidden(sRow, 1);
				
				deleteRow(sheetObjects[1]);
				break;
			case "btn_RowAdd3":
				if(dblClickStatus == 1){
					addRow(sheetObjects[2]);
				}else if (dblClickStatus != 1){
					ComShowMessage("This Row Add Button is available only when you did double click parents table's Row.");
   				}
				break;
			case "btn_RowDel3":
				
//				var sRow = sheetObjects[2].FindCheckedRow("chk");
//				sheetObjects[2].SetRowHidden(sRow, 1);
				deleteRow(sheetObjects[2]);
				break;
			case "btn_new":
				var SaveStr1 = sheetObjects[0].GetSaveString(0);
				var SaveStr2 = sheetObjects[1].GetSaveString(0);
				var SaveStr3 = sheetObjects[2].GetSaveString(0);
				if(SaveStr1 != "" || SaveStr2 != ""  || SaveStr3 != ""){
					if(ComShowCodeConfirm('BKG00254')){
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
					}
				}
				initControl();
				break;
			case "cust_pop":
				ComOpenPopup('COM_ENS_041.do', 770, 470, "callBackCustCd", "1,0,1,1,1,1,1", true);
				break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    function callBackCustCd(rArray){
		var custCd = rArray[0][3];
		document.form.cust_cnt_cd.value = custCd.substring(0,2);
		document.form.cust_seq.value = custCd.substring(2,custCd.length);
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
    	initControl();
    }
    function initControl() {
    	var formObj = document.form;
   	 
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		formObj.ctrl_pty_seq.value = "";
		formObj.ctrl_pty_nm.value = "";
		formObj.ctrl_pty_desc.value = "";
    	 
		formObj.cust_cnt_cd.value = "";
		formObj.cust_seq.value = "";
		formObj.bl_grp_nm.value = "";
		
		ComBtnEnable("btn_RowAdd1");
		ComBtnEnable("btn_RowDel1");
		ComBtnDisable("btn_RowAdd2");
		ComBtnDisable("btn_RowDel2");
		ComBtnDisable("btn_RowAdd3");
		ComBtnDisable("btn_RowDel3");
    }
    /**
      * setting sheet initial values and header
      * @param sheetObj
      * @param sheetNo
      * @return
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
            	with(sheetObj){                
                
	                var HeadTitle = "|Sel.|Seq|row_idx|ctrl_pty_seq|Controlling Party Name|Description|Update DT|Update User";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                     {Type:"DummyCheck",Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
			                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"row_idx" },
			                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_pty_seq"},
			                     {Type:"Text",      Hidden:0, Width:150,  Align:"Left",  ColMerge:1,   SaveName:"ctrl_pty_nm",	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200, InputCaseSensitive:1 },
			                     {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ctrl_pty_desc",	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:"upd_dt", Format:"Ymd", UpdateEdit:0, InsertEdit:0},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:"upd_usr_id", UpdateEdit:0,   InsertEdit:0}
			                     ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetWaitImageVisible(0);                
	                SetAutoRowHeight(0);
	                SetDataRowHeight(22);
	                SetSheetHeight(170);
                }
            break;
            case 2:      // sheet2 init
                with(sheetObj){	                
            		//no support[chk again]CLT 	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	            	var HeadTitle = "|Sel.|Seq|row_idx|ctrl_pty_seq|cust_cnt_cd|cust_seq|old_cust_cd|Customer Code|Company|Update DT|Update User";
	            	var headCount=ComCountHeadTitle(HeadTitle);
		
	            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
	            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	InitHeaders(headers, info);
		
	            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                     {Type:"DummyCheck",Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
			                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"row_idx" },
			                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_pty_seq"},
			                     {Type:"Text",      Hidden:1, Width:80,  Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd"},
			                     {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"cust_seq"},
			                     {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"old_cust_cd"},
			                     {Type:"Popup",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cust_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
			                     {Type:"Text",      Hidden:0, Width:220,  Align:"left",  ColMerge:1,   SaveName:"cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:"upd_dt", Format:"Ymd", UpdateEdit:0, InsertEdit:0},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:"upd_usr_id", UpdateEdit:0, InsertEdit:0}
			                     ];
		               
	            	InitColumns(cols);
		
	            	SetEditable(1);
	            	SetWaitImageVisible(0);	              
	            	SetAutoRowHeight(0);
	            	SetDataRowHeight(22);
	            	SetSheetHeight(170);
              	}


                break;
            case 3:      // sheet2 init
                with(sheetObj){	                
            		//no support[check again]CLT 	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	            	var HeadTitle1 = "|Sel.|Seq|row_idx|ctrl_pty_seq|old_bl_grp_seq|bl_grp_seq|BL Group|View|View|View|View|Proof|Proof|Print|Print|Print|Notify|Notify|Notify|Delivery";
	            	var HeadTitle2 = "|Sel.|Seq|row_idx|ctrl_pty_seq|old_bl_grp_seq|bl_grp_seq|BL Group|Unfreighted|Freighted|PPD Only|CCT Only|OBL|Waybill|OBL|Waybill|N/N|Ready for Proof|Ready for Print|Auto Push Waybill|Alternate Delivery";
	            	HeadTitle1 += '|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery|Delivery';
	            	HeadTitle2 += '|FTP Server Name|FTP Server User Name|FTP Server Password|FTP Server Directory|Retry count|Retry Interval (min)|Email Customer|Email Customer|Email PDF Admin|Email PDF Admin|B/L Type|Naming Rule|Move Dir|FTP OBL Dir|FTP SWB Dir|NN Copy Dir|PDF Error Notice|PDF Success Noitce|Update DT|Update User';
	            	
	            	var headCount=ComCountHeadTitle(HeadTitle1);
		
	            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
	            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle1, Align:"Center"} , { Text:HeadTitle2, Align:"Center"} ];
	            	InitHeaders(headers, info);
		   
	            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                     {Type:"DummyCheck",Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
			                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"row_idx" },
			                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_pty_seq"},
			                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"old_bl_grp_seq"},
			                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bl_grp_seq"},
			                     {Type:"Popup",     Hidden:0, Width:100,  Align:"left",    ColMerge:1,   SaveName:"bl_grp_nm",			KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
			                     {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_vw_rt_tp_cd1",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_vw_rt_tp_cd2",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_vw_rt_tp_cd3",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",	Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_vw_rt_tp_cd4",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",	Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"obl_prf_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",	Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wbl_prf_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",	Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"obl_prn_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",	Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wbl_prn_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",	Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"non_nego_prn_flg",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",	Hidden:1, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"ntfy_prf_flg",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",	Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"ntfy_prn_flg",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",	Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"ntfy_auto_wbl_flg",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",	Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"altn_de_flg",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"Text",  	Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ftp_svr_nm",   		UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",  	Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"ftp_svr_usr_nm",   	UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",  	Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"ftp_svr_pwd",   		UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",  	Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"ftp_svr_dir_nm",   	UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Int", 		Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rty_knt",   			UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",  	Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rty_itval_no",   	UpdateEdit:0,   InsertEdit:0},
			                     {Type:"CheckBox",  Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eml_cust_flg",   	UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eml_cust_addr",   	UpdateEdit:0,   InsertEdit:0},
			                     {Type:"CheckBox",  Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eml_pdf_flg",   		UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eml_pdf_addr",  		UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Combo", 	Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_tp_cd",   		UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Combo",	    Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"xpt_file_nm",        UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",	    Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ftp_dir_ctnt",       UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",	    Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ftp_dir_ctnt2",      UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",	    Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ftp_dir_ctnt3",      UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",	    Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ftp_dir_ctnt4",      UpdateEdit:0,   InsertEdit:0},
			                     {Type:"CheckBox",  Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"err_ntc_flg",        UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"CheckBox",	Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"scs_ntc_flg",        UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			                     {Type:"Text",  	Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",   			UpdateEdit:0,   InsertEdit:0, Format:"Ymd", UpdateEdit:0, InsertEdit:0},
			                     {Type:"Text",  	Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",   		UpdateEdit:0,   InsertEdit:0, UpdateEdit:0, InsertEdit:0}
			                     ];
		               
	            	
	            	InitColumns(cols);
	            	SetColProperty("bl_tp_cd", {ComboText:"Original Sea waybill + Original BL|Original Sea waybill + NN Original|Original BL + Copy Sea waybill|Copy Sea waybill + NN Original", ComboCode:"1|2|3|4"} );
	            	SetColProperty("xpt_file_nm", {ComboText:"BDP|K&N|Standard", ComboCode:"BDP|KNN|STD"} );
	            	SetEditable(1);
	            	SetWaitImageVisible(0);	              
	            	SetAutoRowHeight(0);
	            	SetDataRowHeight(22);
	            	SetSheetHeight(210);
              	}


                break;
        }
    }
    
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(0);
        switch(sAction) {
           case IBSEARCH:
				ComOpenWait(true);
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				formObj.ctrl_pty_seq.value = "";
				formObj.f_cmd.value=SEARCH;
				var sParam = FormQueryString(formObj);
 				sheetObj.DoSearch("ESM_BKG_3001GS.do",sParam );
				ComOpenWait(false);
				break;
			case SEARCH01:
				formObj.f_cmd.value=SEARCH01;
				ComOpenWait(true);
				var sParam = "f_cmd=" + SEARCH01 + "&ctrl_pty_seq=" + formObj.ctrl_pty_seq.value;
				sheetObj.DoSearch("ESM_BKG_3001GS.do",sParam );
				ComOpenWait(false);
				dblClickStatus = 1;
	            break;
			case SEARCH02:      //retrieve
				formObj.f_cmd.value=SEARCH02;
				ComOpenWait(true);
				var sParam=FormQueryString(formObj);
				sheetObj.DoSearch("ESM_BKG_3001GS.do",sParam );
				var sXml = sheetObj.GetSearchData("ESM_BKG_3001GS.do", sParam );
				sheetObj.LoadSearchData(sXml, {Sync:1});
				formObj.inet_ftp_auth_flg.value = ComGetEtcData(sXml, "INET_FTP_AUTH_FLG");
//				alert(formObj.inet_ftp_auth_flg.value);
				ComOpenWait(false);
				break;
			case IBSAVE:

				if(!validateForm(sheetObj,formObj,sAction)) {
		            return;
		        }
				
				
        	   sheetObj.WaitImageVisible=false;
        	   ComOpenWait(true);
        	   
        	   formObj.f_cmd.value = MULTI;
        	   
        	   var sParam1 = sheetObjects[0].GetSaveString(true); 
        	   var sParam2 = sheetObjects[1].GetSaveString(true); 
        	   var sParam3 = sheetObjects[2].GetSaveString(true); 

        	   sParam1 = ComSetPrifix(sParam1, "sheet1_") + "&";
        	   sParam2 = ComSetPrifix(sParam2, "sheet2_") + "&";
        	   sParam3 = ComSetPrifix(sParam3, "sheet3_") + "&";
				
        	   var sParam = FormQueryString(formObj) + "&" + sParam1 + sParam2 + sParam3;
        	   
        	   var sXml = sheetObj.GetSaveData("ESM_BKG_3001GS.do", sParam);
        	   if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
        		   ComShowCodeMessage('BKG00102');
        		   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        	   }else{
        		   ComShowCodeMessage('BKG06087');
        	   }	   
        	   ComOpenWait(false);	
        	   break;
				
           case IBDELETE:
        	   
        	   if(sheetObj.id == "sheet1"){
            	   formObj.f_cmd.value = REMOVE;
        	   }else if(sheetObj.id == "sheet2"){
            	   formObj.f_cmd.value = REMOVE01;
        	   }else{
            	   formObj.f_cmd.value = REMOVE02;
        	   }
        	   
    		   if(!ComShowCodeConfirm('BKG00535'))	return;
    		   
        	   sheetObj.WaitImageVisible=false;
        	   ComOpenWait(true);
        	   
        	   var sParam1 = ComSetPrifix(sheetObj.GetSaveString(false), "sheet1_");
        	   var sParam = FormQueryString(formObj) + "&" + sParam1;
        	   sheetObj.GetSaveData("ESM_BKG_3001GS.do", sParam);
        	   ComOpenWait(false);	
        	   
        	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        	   
        	   break;
        }
    }
    
    function validateForm(sheetObj, formObj, sAction){
   	 	for (var i=1 ; i < sheetObjects[0].RowCount()+1 ; i++){
   	 		if (sheetObjects[0].GetCellValue(i,5) == ''){
   	 			ComShowCodeMessage("BKG43064", "Controlling Party Name");
   	 			sheetObjects[0].SelectCell(i, 5, true, '');
	    		return false;
	    	}else if(sheetObjects[0].GetCellValue(i,6) == ''){
	    		ComShowCodeMessage("BKG43064", "Description");
	    		sheetObjects[0].SelectCell(i, 6, true, '');
	    		return false;
	    	}
   	 	}
   	 	
   	 	for (var i=1 ; i < sheetObjects[1].RowCount()+1 ; i++){
	 		if (sheetObjects[1].GetCellValue(i,"cust_cd") == ''){
	 			ComShowCodeMessage("BKG43064", "Customer Code");
	 			sheetObjects[1].SelectCell(i, "cust_cd", true, '');
	    		return false;
	    	}
	 	}
   	 	
   	 	for (var i=2 ; i < sheetObjects[2].RowCount()+2 ; i++){
	 		if (sheetObjects[2].GetCellValue(i, 'bl_grp_nm') == ''){
	 			ComShowCodeMessage("BKG43064", "BL Group");
	 			sheetObjects[2].SelectCell(i, 7, true, '');
	    		return false;
	    	}
	 	}
   	 	
   	 	var sRow = sheetObjects[1].FindStatusRow("I|U");
   	 	if(sRow != ""){
	   	 	var arrow = new Array();
	   	 	if(sRow.indexOf(";") > 0){
	   	 		arrow = sRow.split(";");
	   	 	}else{
	   	 		arrow[0] = sRow
	   	 	}
	   	
	   	 	for (var i = 0; i < arrow.length; i++) {
	   	 		var cnt_cd = sheetObjects[1].GetCellValue(arrow[i], "cust_cd");
	   	 		var sParam = "f_cmd=" + SEARCH01 + "&cust_cnt_cd=" + cnt_cd;
	   	 		var sXml = sheetObjects[1].GetSearchData("ESM_BKG_3001GS.do", sParam );
		   	 	if(ComGetSelectSingleNode(sXml, "TOTAL") > 0){
		   	 		ComShowCodeMessage('BKG43065', cnt_cd);
		   	 		return false;
		   	 	}
	   	 	}
   	 	}
   	 	
   	 	for (var i=1 ; i < sheetObjects[2].RowCount()+1 ; i++){
   	 		var valueCk = sheetObjects[2].GetCellValue(i, "altn_de_flg");
   	 		var valCk = false;
   	 		var colNm = "";
   	 		if(valueCk == 1){
   	 			if(sheetObjects[2].GetCellValue(i, "ftp_svr_nm") == ""){
   	 				sheetObjects[2].SelectCell(i, "ftp_svr_nm", true, '');
   	 				colNm = "FTP Server Name";
   	 				valCk = true;
   	 			}
   	 			
   	 			if(colNm == "" && sheetObjects[2].GetCellValue(i, "ftp_svr_usr_nm") == ""){
   	 				sheetObjects[2].SelectCell(i, "ftp_svr_usr_nm", true, '');
   	 				colNm = "FTP Server User Name";
   	 				valCk = true;
	 			}
   	 			if(colNm == "" && sheetObjects[2].GetCellValue(i, "ftp_svr_pwd") == ""){
   	 				sheetObjects[2].SelectCell(i, "ftp_svr_pwd", true, '');
   	 				colNm = "FTP Server Password";
   	 				valCk = true;
   	 			}
   	 			if(colNm == "" && sheetObjects[2].GetCellValue(i, "ftp_svr_dir_nm") == ""){
   	 				sheetObjects[2].SelectCell(i, "ftp_svr_dir_nm", true, '');
   	 				colNm = "FTP Server Directory";
   	 				valCk = true;
   	 			}
   	 			if(colNm == "" && sheetObjects[2].GetCellValue(i, "rty_knt") == ""){
   	 				sheetObjects[2].SelectCell(i, "rty_knt", true, '');
   	 				colNm = "Retry count";
   	 				valCk = true;
   	 			}
   	 			if(colNm == "" && sheetObjects[2].GetCellValue(i, "rty_itval_no") == ""){
   	 				sheetObjects[2].SelectCell(i, "rty_itval_no", true, '');
   	 				colNm = "Retry Interval (min)";
   	 				valCk = true;
   	 			}
//   	 			if(colNm == "" && sheetObjects[2].GetCellValue(i, "eml_cust_flg") == 0){
//   	 				sheetObjects[2].SelectCell(i, "eml_cust_flg", true, '');
//   	 				colNm = "Email Customer Flg";
//   	 				valCk = true;
//   	 			}
   	 			if(colNm == "" && sheetObjects[2].GetCellValue(i, "eml_cust_addr") == ""){
   	 				sheetObjects[2].SelectCell(i, "eml_cust_addr", true, '');
   	 				colNm = "Email Customer";
   	 				valCk = true;
   	 			}
//   	 			if(colNm == "" && sheetObjects[2].GetCellValue(i, "eml_pdf_flg") == 0){
//   	 				sheetObjects[2].SelectCell(i, "eml_pdf_flg", true, '');
//   	 				colNm = "Email PDF Admin Flg";
//   	 				valCk = true;
//   	 			}
   	 			if(colNm == "" && sheetObjects[2].GetCellValue(i, "eml_pdf_addr") == ""){
   	 				sheetObjects[2].SelectCell(i, "eml_pdf_addr", true, '');
   	 				colNm = "Email PDF Admin";
   	 				valCk = true;
   	 			}
   	 		}
   	 		
	 		if (valCk){
	 			ComShowCodeMessage("BKG00104", colNm);
	    		return false;
	    	}
	 		
	 		var dupBlGrpNm = sheetObjects[2].ColValueDupRows("bl_grp_nm", false, true);
			if (dupBlGrpNm != null && dupBlGrpNm != "") {	//msgs['BKG00764']="{?msg1} is duplicated."
				ComShowCodeMessage("BKG00764","BL Group Name");
				return false;
			}     
	 	}
   	 	
   	 	return true;
   }
    
    function sheet1_OnSearchEnd(sheetObj, code, message){
    	if(sheetObj.RowCount() == 1){
    		var formObj = document.form;
			formObj.ctrl_pty_seq.value = sheetObj.GetCellValue(1, "ctrl_pty_seq");
			doActionIBSheet(sheetObjects[1],formObj,SEARCH01);
			doActionIBSheet(sheetObjects[2],formObj,SEARCH02);	
            ComBtnEnable("btn_RowAdd2");
            ComBtnEnable("btn_RowDel2");
            ComBtnEnable("btn_RowAdd3");
            ComBtnEnable("btn_RowDel3");
    	}
    }  
    
    function sheet3_OnSearchEnd(sheetObj, code, message){
        var formObj = document.form;
    	for (var i = sheetObj.HeaderRows(); i < (sheetObj.RowCount() + sheetObj.HeaderRows()); i++) {
    		if(sheetObj.GetCellValue(i, 'altn_de_flg') == 1){
    			altnDeFlgCheck(sheetObj, i ,1);
    		}
		}
    	if(ComGetObjValue(formObj.inet_ftp_auth_flg) == "1"){
    		var info = {ComboText:"Original Sea waybill + Original BL|Original Sea waybill + NN Original|Original BL + Copy Sea waybill|Copy Sea waybill + NN Original", ComboCode:"1|2|3|4"};
    		sheetObj.SetColProperty("bl_tp_cd", info);
    	}else{
    		var info = {ComboText:"Original Sea waybill + NN Original|Copy Sea waybill + NN Original", ComboCode:"2|4"};
    		sheetObj.SetColProperty("bl_tp_cd", info);
    	}
    }    

    function searchDetailSheet(sheetObj){
        var formObj = document.form;
    	
    	if(sheetObj.RowCount() > 0){
    		formObj.ctrl_pty_seq.value = sheetObj.SetCellValue(sheetObj.GetSelectRow(), "ctrl_pty_seq");
            ComBtnEnable("btn_RowAdd2");
            ComBtnEnable("btn_RowDel2");
            ComBtnEnable("btn_RowAdd3");
            ComBtnEnable("btn_RowDel3");

    	}else{
    		formObj.ctrl_pty_seq.value = "";
            ComBtnDisable("btn_RowAdd2");
            ComBtnDisable("btn_RowDel2");
            ComBtnDisable("btn_RowAdd3");
            ComBtnDisable("btn_RowDel3");
    	}
    	doActionIBSheet(sheetObjects[1],formObj,SEARCH01);
    	doActionIBSheet(sheetObjects[2],formObj,SEARCH02);
    }

     /**
      * add Row of sheet1 and sheet2
      * @param SheetObj
      * @param sheetNo
      */ 
    function addRow(sheetObj) {
    	var formObj=document.form;
    	switch(sheetObj.id) {
	    	case "sheet1" :
	    		with (sheetObjects[0]) {
	    			var nowRow=GetSelectRow();
	    			nowRow=DataInsert(-1);
	    			SetCellValue(nowRow, "row_idx", nowRow);
	    	  	}
    	  		if(sheetObjects[0].RowCount() > 0){
    	            ComBtnEnable("btn_RowAdd2");
    	            ComBtnEnable("btn_RowDel2");
    	            ComBtnEnable("btn_RowAdd3");
    	            ComBtnEnable("btn_RowDel3");
    	    	}
    	    	//Detail 행 삭제
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				
				formObj.f_cmd.value = SEARCH03;
				var sParam = FormQueryString(formObj)
				
				var sXml = sheetObj.GetSearchData("ESM_BKG_3001GS.do", sParam);
				var ctrl_pty_seq = ComGetEtcData(sXml,"ctrl_pty_seq");
				sheetObj.SetCellValue(nowRow, "ctrl_pty_seq", ctrl_pty_seq);
				formObj.ctrl_pty_seq.value = ctrl_pty_seq;    	  		
	    	  		
			break;
	    	case "sheet2" :
	    		with (sheetObjects[1]) {
	    			var nowRow = sheetObjects[1].DataInsert(-1);
	    			SetCellValue(nowRow, "ctrl_pty_seq", sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ctrl_pty_seq"));
	    		}
	        break;
        
	    	case "sheet3" : 
	    		with (sheetObjects[2]) {
	      	  		var nowRow = sheetObjects[2].DataInsert(-1);
					SetCellValue(nowRow, "ctrl_pty_seq", sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ctrl_pty_seq"));
	    		}
	    	break;
       }
    }
    /**
     * delete Row of sheet1 and sheet2
     * @param SheetObj
     * @param sheetNo
     */  
    function deleteRow(sheetObj) {    	 
     	var isRetreive	= false;
    	var formObj 	= document.form;

    	 
     	switch(sheetObj.id){
	     	case "sheet1" : 
				if(sheetObj.RowCount() < 1){
					ComShowCodeMessage('BKG00546');
					return;
				}
	     		
				with (sheetObj) {
					var sRow = sheetObj.FindCheckedRow("chk");
					var deleteRow = sRow.split("|");
					for (var i = 0; i < deleteRow.length; i++) {
						if(deleteRow[i] != ""){
							var row = deleteRow[i];
							if(GetRowStatus(row) == "R" || GetRowStatus(row) == "U"){
								SetRowStatus(row, "D");
								SetRowHidden(row, 1);
							}else if(GetRowStatus(row) == "I"){
								RowDelete(row, 0);
							}
						}
					}
				}
			break;
	     	case "sheet2" : 
	     		if(sheetObj.RowCount() < 1){
//					ComShowCodeMessage('BKG00546');
					return;
				}
				with (sheetObj) {
					var sRow = sheetObj.FindCheckedRow("chk");
					var deleteRow = sRow.split("|");
					for (var i = 0; i < deleteRow.length; i++) {
						if(deleteRow[i] != ""){
							var row = deleteRow[i];
							if(GetRowStatus(row) == "R" || GetRowStatus(row) == "U"){
								SetRowStatus(row, "D");
								SetRowHidden(row, 1);
							}else if(GetRowStatus(row) == "I"){
								RowDelete(row, 0);
							}
						}
					}
				}
			case "sheet3" : 
				if(sheetObj.RowCount() < 1){
//					ComShowCodeMessage('BKG00546');
					return;
				}
				with (sheetObj) {
					var sRow = sheetObj.FindCheckedRow("chk");
					var deleteRow = sRow.split("|");
					for (var i = 0; i < deleteRow.length; i++) {
						if(deleteRow[i] != ""){
							var row = deleteRow[i];
							if(GetRowStatus(row) == "R" || GetRowStatus(row) == "U"){
								SetRowStatus(row, "D");
								SetRowHidden(row, 1);
							}else if(GetRowStatus(row) == "I"){
								RowDelete(row, 0);
							}
						}
					}
				}
			break;		
     	}         
    }

	function sheet2_OnPopupClick(sheetObj, row, col){
		
        var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {
			case "cust_cd":
				ComOpenPopup('COM_ENS_041.do', 770, 470, "callBackCust", "1,0,1,1,1,1,1", true);
			break;  
		}		
	}    
	function sheet3_OnPopupClick(sheetObj, row, col){
		
        var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {
			case "bl_grp_nm":
				ComOpenPopup("ESM_BKG_3003.do", 800, 340, "callBackBlGrp","0,1", true);
			break;
				
		}		
	}    
	
	function callBackCust(rArray)
	{
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cust_cd", rArray[0][3]);
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cust_nm", rArray[0][4]);
	}
	function callBackBlGrp(rArray)
	{
		sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "bl_grp_seq", rArray[0][3]);
		sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "bl_grp_nm", rArray[0][4]);
	}
	
	function sheet1_OnClick(SheetObj, Row, Col) {
		var formObj = document.form;
		
		if(SheetObj.ColSaveName(Col)=="ctrl_pty_nm"||SheetObj.ColSaveName(Col)=="seq"){
			if(SheetObj.GetCellValue(Row,"ctrl_pty_seq")!="" && SheetObj.GetCellValue(Row,"ctrl_pty_nm")!=""){ 
				var SaveStr1 = sheetObjects[1].GetSaveString(0);
				var SaveStr2 = sheetObjects[2].GetSaveString(0);
				if(SaveStr1 != "" || SaveStr2 != ""){
					if(ComShowCodeConfirm('BKG00254')){
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
					}
				}
				
				var nowRow = SheetObj.GetSelectRow();
				formObj.ctrl_pty_seq.value = SheetObj.GetCellValue(nowRow, "ctrl_pty_seq");
				doActionIBSheet(sheetObjects[1],formObj,SEARCH01);
				doActionIBSheet(sheetObjects[2],formObj,SEARCH02);	
				
			}
		}
        ComBtnEnable("btn_RowAdd2");
        ComBtnEnable("btn_RowDel2");
        ComBtnEnable("btn_RowAdd3");
        ComBtnEnable("btn_RowDel3");
		
	}

	function sheet3_OnBeforeCheck(sheetObj, Row, Col) {
		var col_name = sheetObj.ColSaveName(Col);
		if(col_name=="bl_vw_rt_tp_cd1" || col_name=="bl_vw_rt_tp_cd2" || col_name=="bl_vw_rt_tp_cd3" ||col_name=="bl_vw_rt_tp_cd4" )
		{
			if(sheetObj.GetCellValue(Row, Col) == 1){//unchecked
				return;
			}else{//checked
				sheetObj.SetCellValue(Row, "bl_vw_rt_tp_cd1", 0);
				sheetObj.SetCellValue(Row, "bl_vw_rt_tp_cd2", 0);
				sheetObj.SetCellValue(Row, "bl_vw_rt_tp_cd3", 0);
				sheetObj.SetCellValue(Row, "bl_vw_rt_tp_cd4", 0);
			}
		}
		/**/
		else if(col_name=="altn_de_flg"){
			var editMd = 0;
			/* editor = true */
			if(sheetObj.GetCellValue(Row, Col) == 0){
				editMd = 1;
			}
			/* editor = false */
			else if(sheetObj.GetCellValue(Row, Col) == 1){
				editMd = 0;
			}
			altnDeFlgCheck(sheetObj, Row, editMd);
		}
		else if(col_name == "wbl_prn_flg"){
			var valueCk = sheetObj.GetCellValue(Row, "wbl_prn_flg");
			if(valueCk == 1){
				sheetObj.SetCellValue(Row, "ntfy_auto_wbl_flg", 0);
				sheetObj.SetCellEditable(Row, "ntfy_auto_wbl_flg", 0); 
			}else{
				sheetObj.SetCellEditable(Row, "ntfy_auto_wbl_flg", 1); 
			}
		}
	} 
	
	/**
	 * 
	 * @param editMd
	 */
	function altnDeFlgCheck(sheetObj, Row ,editMd){
		sheetObj.SetCellEditable(Row, 'eml_cust_addr', 	editMd);
		sheetObj.SetCellEditable(Row, 'eml_pdf_addr', 	editMd);
		sheetObj.SetCellEditable(Row, 'ftp_svr_nm', 	editMd);
		sheetObj.SetCellEditable(Row, 'ftp_svr_usr_nm', editMd);
		sheetObj.SetCellEditable(Row, 'ftp_svr_pwd', 	editMd);
		sheetObj.SetCellEditable(Row, 'ftp_svr_dir_nm', editMd);
		sheetObj.SetCellEditable(Row, 'rty_knt', 		editMd);
		sheetObj.SetCellEditable(Row, 'rty_itval_no',	editMd);
		sheetObj.SetCellEditable(Row, 'eml_cust_flg', 	editMd);
		sheetObj.SetCellEditable(Row, 'eml_pdf_flg', 	editMd);
		sheetObj.SetCellEditable(Row, 'bl_tp_cd', 		editMd);
		sheetObj.SetCellEditable(Row, 'xpt_file_nm',	editMd);
		sheetObj.SetCellEditable(Row, 'ftp_dir_ctnt',	editMd);
		sheetObj.SetCellEditable(Row, 'err_ntc_flg', 	editMd);
		sheetObj.SetCellEditable(Row, 'scs_ntc_flg', 	editMd);
		sheetObj.SetCellEditable(Row, 'ftp_dir_ctnt2',	editMd);
		sheetObj.SetCellEditable(Row, 'ftp_dir_ctnt3',	editMd);
		sheetObj.SetCellEditable(Row, 'ftp_dir_ctnt4',	editMd);
	}    