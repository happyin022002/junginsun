/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_DMT_4108.jsp
*@FileTitle : DEM/DET Email Send( selected sending target of Fax/Email (pop-up))
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
    /**
     * @extends 
     * @class EES_DMT_4108 :  business script for EES_DMT_4108.
     */
    function EES_DMT_4108() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	// Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	// RD
	var rdObjects=new Array();
	var rdCnt=0;
	var ROWMARK="|";
	var FIELDMARK="=";
	var IBEMAILSEND=51;
	
	var IS_DIGITAL_SIGN = false; //2016.03.24 Add
	var opener=window.dialogArguments;
	if (!opener) opener=window.opener;  //이 코드 추가할것
	if (!opener) opener=parent;               // 기존 가이드 부분
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		/***** case in Sheet count are more two by Tab, defining adding sheet *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
	    		case "btn_email":
	        		doActionIBSheet(sheetObject1,formObject,IBEMAILSEND);
					break;
                case "btn_close":
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
    	var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                 var HeadTitle="|Seq.|ATTN|Fax|E-mail|Tel.|Sheet|Send|cust_cntc_pnt_seq";
                 var headCount=ComCountHeadTitle(HeadTitle);

                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                 var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"SEQ",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"payr_cntc_pnt_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"payr_cntc_pnt_fax_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"payr_cntc_pnt_eml",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"payr_cntc_pnt_phn_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Radio",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sheet",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"send",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_cntc_pnt_seq" } ];
                  
                 InitColumns(cols);

                 SetEditable(1);
                 SetEllipsis(1);
                 SetCountPosition(0);
                 SetSheetHeight(142);
                }
                break;
        }
    }
	// Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:
				if (sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					if (validateForm(sheetObj,formObj,sAction)) {
						sheetObj.DoSearch("EES_DMT_4104GS.do", FormQueryString(formObj) );
					}
				}
				break;
        	case IBEMAILSEND:
        		var payr_emails="";
        		var sheetObj=sheetObjects[0];
        		//var opener=window.dialogArguments;
        		//if (!opener) opener=window.opener;  //이 코드 추가할것
        		//if (!opener) opener=parent;               // 기존 가이드 부분
        		var openerFormObj="";
        		switch(ComGetObjValue(formObj.jspno)) {
        			case "4002":
        			case "4003":
        			case "4004":
        			case "3108":
        			case "3109":
        			case "3007":
        			case "4011":
        			case "4012":
        				openerFormObj=opener.document.form;
        				break;
        			case "4016":
        				openerFormObj=opener.document.form;
        				break;
        		}
        		var send_cnt=0;
        		var total_row=sheetObj.GetTotalRows();
        		for(var i=1; i < total_row+1 ; i++) 
        		{
        			if(sheetObj.GetCellValue(i, "send") == "1")
					{
						send_cnt++;
						if(sheetObj.GetCellValue(i, "payr_cntc_pnt_eml") == "")	continue;
						var dup_check=0;
						for(var j=i+1 ;  j < total_row+1 ; j++) 
						{
							if(sheetObj.GetCellValue(j, "send") == 1)
							{
								if(sheetObj.GetCellValue(j, "payr_cntc_pnt_eml") == "")	continue;
								if(sheetObj.GetCellValue(i, "payr_cntc_pnt_eml") == sheetObj.GetCellValue(j, "payr_cntc_pnt_eml")){
									dup_check++;
								}
							}
						}
						if(dup_check == 0) 
						{
							payr_emails += sheetObj.GetCellValue(i, "payr_cntc_pnt_eml") +";";
						}
					}
				}
        		
        		var tmpMsg = "E-mail";
        		
        		//2016.03.24 Add 조건 추가.
        		if(IS_DIGITAL_SIGN == false){
	        		if(payr_emails == "") {
	        			ComShowCodeMessage("DMT01091");
	        			return;
	        		}
        		}else{
        			tmpMsg = "Digital Sgin Data";
        		}
        		
        		if(send_cnt == 0){
        			ComShowCodeMessage("DMT01150",tmpMsg);
        			return;
        		}
        		
        		var rcvr_emails=payr_emails;
        		ComSetObjValue(formObj.invno,					openerFormObj.invno.value);
    			ComSetObjValue(formObj.payc,					openerFormObj.payc.value);
        		ComSetObjValue(formObj.rd_fxeml_sys_cd,			openerFormObj.rd_fxeml_sys_cd.value);
    			ComSetObjValue(formObj.rd_fxeml_file_name,		openerFormObj.rd_fxeml_file_name.value);
    			ComSetObjValue(formObj.rd_fxeml_bat_flg,		openerFormObj.rd_fxeml_bat_flg.value);
    			ComSetObjValue(formObj.rd_fxeml_title,			openerFormObj.rd_fxeml_title.value);
    			ComSetObjValue(formObj.rd_fxeml_rd_param,		openerFormObj.rd_fxeml_rd_param.value);
    			ComSetObjValue(formObj.rd_fxeml_fax_no,			"");
    			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	openerFormObj.rd_fxeml_fax_sndr_id.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	openerFormObj.rd_fxeml_eml_sndr_nm.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_fixed,	openerFormObj.rd_fxeml_eml_sndr_fixed.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	rcvr_emails);
    			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	openerFormObj.rd_fxeml_eml_atch_file.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_templt,		openerFormObj.rd_fxeml_eml_templt.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,openerFormObj.rd_fxeml_eml_tmplt_param.value);
    			ComSetObjValue(formObj.rd_fxeml_doc_tp,			openerFormObj.rd_fxeml_doc_tp.value);
                //ComOpenWait Start
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                if(ComGetObjValue(formObj.jspno) == "4011" || ComGetObjValue(formObj.jspno) == "4012"){//Check the attachment in a OTSscreen case, the fax transmission is called once more.
                	if(ComGetObjValue(formObj.s_cust_seq) == "Y") {
                		ComSetObjValue(formObj.creof,			openerFormObj.creof.value);
                		ComSetObjValue(formObj.f_cmd, SEARCH07);
                	}else {
                		ComSetObjValue(formObj.f_cmd, SEARCH06);
                	}
        		}else{
        			ComSetObjValue(formObj.f_cmd, SEARCH06);
        		}
                var sXml=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                sheetObj.LoadSaveData(sXml,{Sync:1} );
//        		ComShowMessage(dmtGetMsgText(sXml));
                //ComOpenWait End
                ComOpenWait(false);
                ComClosePopup(); 
        		break;

			case COMMAND17:
				var param="f_cmd=" + COMMAND17; 
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", param);
				
				var varUsrCntCd = ComGetEtcData(sXml, "USR_CNT_CD");
				
				initDigitalSignInvoice(varUsrCntCd);
				
				break;	
        }
    }
	/*
	 * initializing
	 */
	function initControl(){
		var formObj=document.form;
		var opener=window.dialogArguments;
		if (!opener) opener=window.opener;  //이 코드 추가할것
		if (!opener) opener=parent;               // 기존 가이드 부분
		var attn="";
		switch(ComGetObjValue(formObj.jspno)){
			case "4002":
			case "4004":
				attn=opener.form.org_dmdt_payr_cntc_pnt_nm.value;
				break;
			case "4016":
				attn=opener.form.org_dmdt_payr_cntc_pnt_nm.value;
				break;
			case "4003":
			case "3108":
			case "3109":
			case "3007":
			case "4011":
				attn=opener.form.dmdt_payr_cntc_pnt_nm.value;
				break;
			case "4012":
				attn=opener.form.atn_val.value;
				break;
		}
		ComSetObjValue(formObj.s_attn, attn);
        //ofc_cd setting
        ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.s_ofc_cd));
        //Main 
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

	}
	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
		if(ErrMsg == '') {
			var formObj=document.form;
			var fCmd=formObj.f_cmd.value;
			if(fCmd == SEARCH) {
				ComEtcDataToForm(formObj, sheetObj);
				//DEFALUT CHECK - SHEET, SEND(ATTN, TEL, FAX, E-MAIL
				var attn=ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm);
				var tel=ComGetObjValue(formObj.dmdt_payr_phn_no);
				var fax=ComGetObjValue(formObj.dmdt_payr_fax_no);
				var email=ComGetObjValue(formObj.dmdt_payr_n1st_eml);
				// 앞Values ??passed in front of the screen
				var p_attn=ComGetObjValue(formObj.s_attn);
				var p_tel=ComGetObjValue(formObj.s_telno);
				var p_fax=ComGetObjValue(formObj.s_faxno);
				var p_email=ComGetObjValue(formObj.s_email);
				var p_cust_seq=ComGetObjValue(formObj.s_cust_seq);
				var checkOk=false;
				if(ComGetObjValue(formObj.jspno) == "4002" ||
				   ComGetObjValue(formObj.jspno) == "4003" || 
				   ComGetObjValue(formObj.jspno) == "4004" || 
				   ComGetObjValue(formObj.jspno) == "4016") 
				{
					for(var i=1; i < sheetObj.GetTotalRows()+1 ; i++)
					{
						if(p_cust_seq == "")
						{
							sheetObj.SetCellValue(1, "sheet",1,0);
							checkOk=true;
							break;
						}else{
							if(p_cust_seq == sheetObj.GetCellValue(i, "cust_cntc_pnt_seq"))
							{
								sheetObj.SetCellValue(i, "sheet",1,0);
								checkOk=true;
								break;
							}
						}
					}
					if(!checkOk) {sheetObj.SetCellValue(1, "sheet",1,0);}
				}else{
					for(var i=1; i < sheetObj.GetTotalRows()+1 ; i++) {
						if(p_attn == sheetObj.GetCellValue(i, "payr_cntc_pnt_nm")
							&& p_tel == sheetObj.GetCellValue(i, "payr_cntc_pnt_phn_no")
							&& p_fax == sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no")
							&& p_email == sheetObj.GetCellValue(i, "payr_cntc_pnt_eml")) {
								sheetObj.SetCellValue(i, "sheet",1,0);
								checkOk=true;
								break;
						}
					}
					if(!checkOk) {
						for(var i=1; i < sheetObj.GetTotalRows()+1 ; i++) {
							if(attn == sheetObj.GetCellValue(i, "payr_cntc_pnt_nm")
							&& tel == sheetObj.GetCellValue(i, "payr_cntc_pnt_phn_no")
							&& fax == sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no")
							&& email == sheetObj.GetCellValue(i, "payr_cntc_pnt_eml")) {
								sheetObj.SetCellValue(i, "sheet",1,0);
								break;
							}
						}
					}
				}
				sheetObj.CheckAll("send",1,1);
			}
			
			//2016.03.24 Add Login Ofc_cd의 Country Code 조회.
			//2016.05.13 FTP 처리 부분 임시 주석 처리.
//	        doActionIBSheet(sheetObjects[0],document.form,COMMAND17);
		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
//
//    		switch(sAction) {
//    			case IBSAVE:
//    				
//    				for( var i = 1; i < sheetObj.RowCount + 1; i++) {
//    					var pnt_nm = sheetObj.CellValue(i, "payr_cntc_pnt_nm");
//    					var phn_no = sheetObj.CellValue(i, "payr_cntc_pnt_phn_no");
//    					var fax_no = sheetObj.CellValue(i, "payr_cntc_pnt_fax_no");
//    					var eml    = sheetObj.CellValue(i, "payr_cntc_pnt_eml");
//    					
//    					for( j = i+1 ; j < sheetObj.RowCount + 1 ; j++) {
//    						if(pnt_nm == sheetObj.CellValue(j, "payr_cntc_pnt_nm") 
//    								&& phn_no == sheetObj.CellValue(j, "payr_cntc_pnt_phn_no")
//    								&& fax_no == sheetObj.CellValue(j, "payr_cntc_pnt_fax_no")
//    								&& eml    == sheetObj.CellValue(j, "payr_cntc_pnt_eml")
//    									) {
//    							ComShowCodeMessage("DMT00188", j);
//    							return false;
//    						}
//    					}
//    				}
//    			
////    				var dupRow = sheetObj.ColValueDup("payr_cntc_pnt_nm|payr_cntc_pnt_phn_no|payr_cntc_pnt_fax_no|payr_cntc_pnt_eml", false);
////    				
////    				if(dupRow != -1 ) {
////    					ComShowCodeMessage("DMT00188", dupRow);
////    					return false;
////    				}
//    				
//    		
//    				if(ComGetLenByByte(ComGetObjValue(formObj.dmdt_payr_addr)) > 100) {
//    					ComShowCodeMessage("COM131901", "Address");
//    					return false;
//    				}
//    				
//    			
//    				for( var i = 1; i < sheetObj.RowCount + 1; i++) {
//    					if(sheetObj.CellValue(i, "payr_cntc_pnt_nm") == "" 
//    							&& sheetObj.CellValue(i, "payr_cntc_pnt_phn_no") == ""
//    							&& sheetObj.CellValue(i, "payr_cntc_pnt_fax_no") == ""
//    							&& sheetObj.CellValue(i, "payr_cntc_pnt_eml") == ""
//    							) {
//    						sheetObj.RowStatus(i) = "R";
//    					}
//    				}
//    				
//    				
//    				break;
//    		}
//        }		
//
        return true;
    }
//	function dmtGetMsgText(xmlStr){
//	    try {
//	        var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
//	        xmlDoc.loadXML(xmlStr);
//	        var xmlRoot=xmlDoc.documentElement;
//	        if(xmlRoot == null) return;
//	        var msgNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
//	        if(msgNode == null) 
//	         return;
//	        else
//	         return msgNode.firstChild.nodeValue;
//	   } catch(err) { ComFuncErrMsg(err.message); }
//	} 
    
    //2016.03.24 Add
    function initDigitalSignInvoice(varUsrCntCd){
		var openerFormObj 	= opener.document.form;
		var rdFxemlDocTp 	= openerFormObj.rd_fxeml_doc_tp.value;
		var sheetObj		= sheetObjects[0];
		
		if(varUsrCntCd == "IN" && rdFxemlDocTp =="I"){
			IS_DIGITAL_SIGN = true;
			for(var i = sheetObj.HeaderRows() ; i <= sheetObj.LastRow(); i++){
				sheetObj.SetCellValue(i, "payr_cntc_pnt_eml", "", 0);
			}
		}else{
			IS_DIGITAL_SIGN = false;
		}
		
    }
