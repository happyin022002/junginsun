/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4107.js
*@FileTitle  : DEM/DET Fax Send(Fax / Email sent when mailed to the ability to select the target(pop-up))
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
   	/* Developer's task	*/
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	// RD
	var rdObjects=new Array();
	var rdCnt=0;
	var ROWMARK="|";
	var FIELDMARK="=";
	var IBFAXSEND=51;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		/***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
//    	try {
    		var srcName=ComGetEvent("name");
    		switch(srcName) {
	    		case "btn_fax":
	        		doActionIBSheet(sheetObject1,formObject,IBFAXSEND);
					break;
                case "btn_close":
                	ComClosePopup(); 
                    break;                      
            } // end switch
//    	}catch(e) {
//    		if( e == "[object Error]") {
//    			ComShowMessage(OBJECT_ERROR);
//    		} else {
//    			ComShowMessage(e);
//    		}
//    	}
    }
    /**
     * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
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
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
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
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"payr_cntc_pnt_fax_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"payr_cntc_pnt_eml",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"payr_cntc_pnt_phn_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Radio",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sheet",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"send",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_cntc_pnt_seq" } ];
                 InitColumns(cols);
                 SetEditable(1);
                 SetEllipsis(1);
                 SetSheetHeight(142);
                }
                break;
        }
    }
	// Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:
				if (sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					if (validateForm(sheetObj,formObj,sAction)) {
						sheetObj.DoSearch("EES_DMT_4104GS.do", FormQueryString(formObj) );
						ComEtcDataToForm(formObj, sheetObj);
						//DEFALUT CHECK - SHEET, SEND(ATTN, TEL, FAX, E-MAIL
						var attn=ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm);
						var tel=ComGetObjValue(formObj.dmdt_payr_phn_no);
						var fax=ComGetObjValue(formObj.dmdt_payr_fax_no);
						var email=ComGetObjValue(formObj.dmdt_payr_n1st_eml);
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
							if(!checkOk)	sheetObj.SetCellValue(1, "sheet",1,0);
						}else{
							for(var i=1; i < sheetObj.GetTotalRows()+1 ; i++)
							{
								if(p_attn == sheetObj.GetCellValue(i, "payr_cntc_pnt_nm")
								&& p_tel == sheetObj.GetCellValue(i, "payr_cntc_pnt_phn_no")
								&& p_fax == sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no")
								&& p_email == sheetObj.GetCellValue(i, "payr_cntc_pnt_eml"))
								{
									sheetObj.SetCellValue(i, "sheet",1,0);
									checkOk=true;
									break;
								}
							}
							if(!checkOk) 
							{
								for(var i=1; i < sheetObj.GetTotalRows()+1 ; i++)
								{
									if(attn == sheetObj.GetCellValue(i, "payr_cntc_pnt_nm")
									&& tel == sheetObj.GetCellValue(i, "payr_cntc_pnt_phn_no")
									&& fax == sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no")
									&& email == sheetObj.GetCellValue(i, "payr_cntc_pnt_eml"))
									{
										sheetObj.SetCellValue(i, "sheet",1,0);
										break;
									}
								}
							}
						}
						sheetObj.CheckAll("send",1,1);
					}
				}
				break;
        	case IBFAXSEND:
        		var payr_faxnos="";
        		var sheetObj=sheetObjects[0];
        		var opener=window.dialogArguments;
        		if (!opener) opener=window.opener;  //이 코드 추가할것
        		if (!opener) opener=parent;               // 기존 가이드 부분
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
						if(sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no") == "")	continue;
						var dup_check=0;
						for(var j=i+1 ;  j < total_row+1 ; j++) 
						{
							if(sheetObj.GetCellValue(j, "send") == 1)
							{
								if(sheetObj.GetCellValue(j, "payr_cntc_pnt_fax_no") == "")	continue;
								if(sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no") == sheetObj.GetCellValue(j, "payr_cntc_pnt_fax_no")){
									dup_check++;
								}
							}
						}
						if(dup_check == 0) 
						{
							payr_faxnos += sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no") +";";
						}
					}
				}
        		if(send_cnt == 0){
        			ComShowCodeMessage("DMT01150","Fax");
        			return;
        		}
        		if(payr_faxnos == "") {
        			ComShowCodeMessage("DMT01090");
        			return;
        		}
//        		var rcvr_fax_no	= "";
//        		var msg1		= "";
//        		
//        		//RCV
//        		var arr_faxnos 	= payr_faxnos.split(";");
//        		var re_faxnos	= "";
//        		
//        		for(var i=0; i< arr_faxnos.length; i++) {
//        			re_faxnos	+= ComGetObjValue(formObj.s_cust_cd)+";"+arr_faxnos[i];
//        			msg1		+= arr_faxnos[i] +"\n\t";
//        		}
//        		if (!ComShowCodeConfirm("DMT01092", msg1))	return;
        		ComSetObjValue(formObj.invno,					openerFormObj.invno.value);
    			ComSetObjValue(formObj.payc,					openerFormObj.payc.value);
        		ComSetObjValue(formObj.rd_fxeml_sys_cd,			openerFormObj.rd_fxeml_sys_cd.value);
    			ComSetObjValue(formObj.rd_fxeml_file_name,		openerFormObj.rd_fxeml_file_name.value);
    			ComSetObjValue(formObj.rd_fxeml_bat_flg,		openerFormObj.rd_fxeml_bat_flg.value);
    			ComSetObjValue(formObj.rd_fxeml_title,			openerFormObj.rd_fxeml_title.value);
    			ComSetObjValue(formObj.rd_fxeml_rd_param,		openerFormObj.rd_fxeml_rd_param.value);
    			ComSetObjValue(formObj.rd_fxeml_fax_no,			payr_faxnos);
    			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	openerFormObj.rd_fxeml_fax_sndr_id.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	openerFormObj.rd_fxeml_eml_sndr_nm.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	openerFormObj.rd_fxeml_eml_rcvr_add.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	openerFormObj.rd_fxeml_eml_atch_file.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_templt,		openerFormObj.rd_fxeml_eml_templt.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,openerFormObj.rd_fxeml_eml_tmplt_param.value);
    			ComSetObjValue(formObj.rd_fxeml_doc_tp,			openerFormObj.rd_fxeml_doc_tp.value);
    			ComSetObjValue(formObj.f_cmd, SEARCH05);
                //ComOpenWait Start
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                var sXml=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                sheetObj.LoadSaveData(sXml,{Sync:1} );
        		if(ComGetObjValue(formObj.jspno) == "4011" && ComGetObjValue(formObj.jspno) == "4012") {
        			if(ComGetObjValue(formObj.s_cust_seq) == "Y"){
	        			ComSetObjValue(formObj.rd_fxeml_file_name,		openerFormObj.rd_fxeml_file_name2.value);
	        			ComSetObjValue(formObj.rd_fxeml_rd_param,		openerFormObj.rd_fxeml_rd_param2.value);
	        			sXml=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
	        			sheetObj.LoadSaveData(sXml,{Sync:1} );
        			}
        		}
//        		ComShowMessage(dmtGetMsgText(sXml));
                //ComOpenWait End
                ComOpenWait(false);
                ComClosePopup(); 
        		break;
        }
    }
	function initControl(){
		var formObj=document.form;
		var opener=window.dialogArguments;
		if (!opener) opener=window.opener;  //이 코드 추가할것
		if (!opener) opener=parent;               // 기존 가이드 부분
		var attn="";
		switch(ComGetObjValue(formObj.jspno)){
			case "4002":
			case "4004":
//				attn=opener.document.form.org_dmdt_payr_cntc_pnt_nm.value;
				attn=opener.form.org_dmdt_payr_cntc_pnt_nm.value;
				break;
			case "4016":
//				attn=opener.document.form2.org_dmdt_payr_cntc_pnt_nm.value;
				attn=opener.form.org_dmdt_payr_cntc_pnt_nm.value;
				break;
			case "4003":
			case "3108":
			case "3109":
			case "3007":
			case "4011":
//				attn=opener.document.form.dmdt_payr_cntc_pnt_nm.value;
				attn=opener.form.dmdt_payr_cntc_pnt_nm.value;
				break;
			case "4012":
//				attn=opener.document.form.atn_val.value;
				attn=opener.form.atn_val.value;
				break;
		}
		ComSetObjValue(formObj.s_attn, attn);
        //ofc_cd setting
        ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.s_ofc_cd));
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
		}
	}
    /**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
//
//    		switch(sAction) {
//    			case IBSAVE:
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
////    				var dupRow = sheetObj.ColValueDup("payr_cntc_pnt_nm|payr_cntc_pnt_phn_no|payr_cntc_pnt_fax_no|payr_cntc_pnt_eml", false);
////    				
////    				if(dupRow != -1 ) {
////    					ComShowCodeMessage("DMT00188", dupRow);
////    					return false;
////    				}
//    				
//    				if(ComGetLenByByte(ComGetObjValue(formObj.dmdt_payr_addr)) > 100) {
//    					ComShowCodeMessage("COM131901", "Address");
//    					return false;
//    				}
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
