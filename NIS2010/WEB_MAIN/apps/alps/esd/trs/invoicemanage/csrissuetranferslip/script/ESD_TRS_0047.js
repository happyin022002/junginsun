/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0047.js
*@FileTitle : TRS CSR I/F Status Inquiry 
*@History
* N200902170070 2009-02-23 : CSR Check Mailing Address
* N200903030070 2009-03-04 : CSR IF Inquriy Downexcel
* 
* 2014.11.04 10만불비용결재 관련 수정- 항목명 변경 cost_ofc_cd를 inv_ofc_cd로 변경하고 새로 cost_ofc_cd 추가함.
* 2014.11.26 최종혁 김현화[CHM-201432901]Split 01-비용지급 전표 결재건 
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @class ESD_TRS_0047 : 
 */
function ESD_TRS_0047() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

document.onclick = processButtonClick;

    function processButtonClick(){
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];

         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");


            switch(srcName) {

                case "btns_multisearch":
                    OnPopupClick();
                break;
                
                case "btns_calendar":
                    getCalendar();
                     break;
                     
                case "btn_retrieve":
                	if (ComIsEmpty(formObject.mult_csr_no)){  
                    	if(ComIsEmpty(formObject.fm_eff_dt)){
                        	ComShowCodeMessage("COM12114" , "From");
                        	return;
                    	}
                     	if(ComIsEmpty(formObject.to_eff_dt)){
                        	ComShowCodeMessage("COM12114" , "To");
                        	return;
                    	}
                    }else{
                    	if(ComIsContainsChars(formObject.mult_csr_no.value,"!`()-+|<>?/.'*&^%$#@~;")){
                    		formObject.mult_csr_no.value ="";
                    		formObject.mult_csr_no.focus();
                    		ComShowCodeMessage("COM12114" , "CSR No");
                    		return;
                    	}
                    }
                	
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);

                break;

				case "btn_new":
					sheetObject.RemoveAll();
					formObject.reset();
					document.all.btng_apro_step.style.visibility = "hidden"; 
					document.form.apro_step.value = "";
					ComBtnEnable("btng_csrcancel");
					ComBtnEnable("btng_approvalrequest");
					break;

                case "btng_viewapprovalstep":  

            	    var selRow = sheetObject.SelectRow;
        	        
        	        if(selRow == 0) {
        	            ComShowCodeMessage("COM12176");
        	            return;
        	        }
        	        
        	        var height = screen.height; 
                	var width = screen.width;
        	                          
      	            var w = 615;
                    var h = 280;
                    var leftpos = width/2 - w/2; 
                	var toppos = height/2 - h/2; 
                	if(leftpos<0) leftpos=0;
                	if(toppos<0) toppos=0;
                	
					if (   sheetObject.CellValue(selRow, 'csr_number') == undefined 
					    || sheetObject.CellValue(selRow, 'csr_number') == null ){
                        errMsg = ComGetMsg("TRS90199");
                        ComShowMessage(errMsg);
						return false;
					}  
					
                	var apro_rqst_no = sheetObject.CellValue(selRow, "apro_rqst_no");    
                	
					if (apro_rqst_no == undefined || apro_rqst_no == null || apro_rqst_no == ''){

						ComShowCodeMessage("TRS90621","Approval Request No");
						return false;
					}
// 10만불 비용 결재관련- POP UP 변경					
//                    var url = "/hanjin/COM_ENS_0W1.do?apro_rqst_no="+apro_rqst_no;
//                    window.showModalDialog(url, window, "dialogWidth:640px; dialogHeight:290px; help:no; status:no; resizable:yes; scroll:no");
//                    
                    var param = "?apro_rqst_no="+apro_rqst_no+"&btn_flag=N";
					ComOpenPopup("COM_CSR_0020.do" + param, 615, 280, "", "1,0,1,1,1", true);

        	        break;
// 2014.11.04 10만불 비용 결재 수정으로 해당 기능 사용 하지 않음. 
//                case "btng_editapprovalstep":  
//            	    var selRow = sheetObject.SelectRow;
//        	        
//        	        if(selRow == 0) {
//        	            ComShowCodeMessage("COM12176");    //??? row? ????.
//        	            return;
//        	        }
//        	        
//        	        var height = screen.height; 
//                	var width = screen.width;
//        	                          
//      	            var w = 615;
//                    var h = 280;
//                    var leftpos = width/2 - w/2; 
//                	var toppos = height/2 - h/2; 
//                	if(leftpos<0) leftpos=0;
//                	if(toppos<0) toppos=0;
//                	
//					if (   sheetObject.CellValue(selRow, 'csr_number') == undefined 
//					    || sheetObject.CellValue(selRow, 'csr_number') == null ){
//                        errMsg = ComGetMsg("TRS90199");
//                        ComShowMessage(errMsg);
//						return false;
//					}                	
//                	
//                	var apro_rqst_no = sheetObject.CellValue(selRow, "apro_rqst_no");                	
//					if (apro_rqst_no == undefined || apro_rqst_no == null || apro_rqst_no == ''){
//						ComShowCodeMessage('TRS90394','Approval Request No');
//						return false;
//					}                	
//                	
//                    var v_if_sts = sheetObjects[0].CellValue(selRow, 'if_sts_indicator');
//
//                    if(v_if_sts == 'AR') {
//                        var v_csr_no = sheetObject.CellValue(selRow, 'csr_number');
//                        var v_ofc_cd = document.form.inv_ofc_cd.value;
//                       
//                        var param = '?mode=save&ofc_cd='+v_ofc_cd+'&csr_no='+v_csr_no+'&sub_sys_cd=TRS&classId=COM_ENS_0T1&target_obj_nm=apro_step';
//                        ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);
//                        
//                    }else{
//                        ComShowCodeMessage('COM12113','Approval Request Status');
//                    }
//        	        break;

                case "btng_csrformat":
                    if (sheetObjects[0].RowCount <= 0){
						return false;
					}

					if (sheetObjects[0].SelectRow == undefined || sheetObjects[0].SelectRow == null || sheetObjects[0].SelectRow == 0){
                        errMsg = ComGetMsg("TRS90036");
                        ComShowMessage(errMsg);
						return false;
					}
					if (   sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 'csr_number') == undefined 
					    || sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 'csr_number') == null ){
                        errMsg = ComGetMsg("TRS90199");
                        ComShowMessage(errMsg);
						return false;
					}
					
                    doActionIBSheet1(sheetObject2, formObject, IBSEARCH);

                    break;

                case "btng_invoicelistinquiry":
                    if (sheetObjects[0].RowCount <= 0){
						return false;
					}

					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
                        errMsg = ComGetMsg("TRS90036" );
                        ComShowMessage(errMsg);
						return false;
					}
					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_number')==undefined || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_number')==null) {
                        errMsg = ComGetMsg("TRS90199" );
                        ComShowMessage(errMsg);
						return false;
					}
					ComOpenPopup('ESD_TRS_0960.do?csr_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 'csr_number')+'&mode=trs', 800, 495, '','1,0,1,1,1,1,1,1', false);

					break;

                case "btng_csrcancel":
                
                    if (sheetObjects[0].RowCount <= 0){
						return false;
					}

					if (sheetObjects[0].SelectRow == undefined || sheetObjects[0].SelectRow == null || sheetObjects[0].SelectRow == 0){
                        errMsg = ComGetMsg("TRS90036" );
                        ComShowMessage(errMsg);
						return false;
					}

					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 'csr_number') == undefined || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 'csr_number') == null ){
                        errMsg = ComGetMsg("TRS90199" );
                        ComShowMessage(errMsg);
						return false;
					}
					
		            /** CSR INTERFACE STATUS CODE LIST
		             * --------------------------------
		             * DA
		             * AR
		             * IF_SUCCESS
		             * IF_ERROR
		             * AP_REJECTED
		             */
				    var ifStatIndicator = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 'if_sts_indicator');
				    var csr_apro_tp_cd =  sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "csr_apro_tp_cd");
				    
				    if (csr_apro_tp_cd == 'AL' ){
				    /* AP_REJECTED + DA */
					    if ( ifStatIndicator == 'AP_REJECTED' || ifStatIndicator == 'DA' )
					    {
							ComOpenPopup('ESD_TRS_0048.do?csr_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 'csr_number')+"&rows="+sheetObjects[0].SelectRow, 795,455,'', '1,0,1,1,1,1,1,1', true);
	                    /* IF_ERROR */
					    } else if ( ifStatIndicator == 'IF_ERROR' ){
					        if(confirm('Selected CSR will cancel.\n\nAre you sure to proceed?')){
					            doActionIBSheet(sheetObject, formObject, IBSAVE);    
					        }
							return false;
					    /* AR + IF_SUCCESS + 'Approved' */
					    } else if ( ifStatIndicator == 'AR' || ifStatIndicator =="RA" ){
					        if(confirm('Selected CSR will cancel.\n\nAre you sure to proceed?')){
					            doActionIBSheet(sheetObject, formObject, 'IBSAVE2');    
					        }
							return false;
					    /* IF_SUCCESS + 'Approved' */
					    }else{
	                        errMsg = ComGetMsg("TRS90206" );
	                        ComShowMessage(errMsg);
	                        return false;
					    }
				    }else{
 			    	  //GW 인 경우 
				    	if(ifStatIndicator !='AR' && ifStatIndicator != 'IF_SUCCESS'){ 
				    	
					        if(confirm('Selected CSR will cancel.\n\nAre you sure to proceed?')){
					            doActionIBSheet(sheetObject, formObject, IBSAVE);    
					        }
						return false;
				    	}
				    }
				    break;
				//N200903030070 2009-03-04 : CSR IF Inquriy Downexcel 
				case "btng_downexcel1":
					sheetObject.SpeedDown2Excel(true);
				break;
				case "btng_approvalrequest":

					if (sheetObjects[0].RowCount <= 0){
						ComShowCodeMessage("TRS90390");//ComShowMessage('조회된 data가 없습니다.');
						return false;
					}

					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
						ComShowCodeMessage("TRS90382");//ComShowMessage('선택된 row가 없습니다.');
						return false;
					}

					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"csr_number")==undefined || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"csr_number")==null || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"csr_number").trim()==''){
						ComShowCodeMessage("TRS90622"); //ComShowMessage('선택된 row에 CSR No.가 없습니다.');
						return false;
					}
					
				///*** 2014.11.03 10만불 관련 Aproval 로직 추가	
					var ifStatus = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"if_sts");
					var tpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"csr_apro_tp_cd");
//					
//					if(ifStatus=='Requesting Approval') {
//						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC02);	
//					}else{
//						return false;
//					}
					
					/*Approval Type 변경 시 저장 로직 우선... SY SHIM*/
					if (sheetObjects[0].RowCount > 0){
	    				if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'ibflag')=='U'){
	    					document.form.csr_no.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_number');
		    				var csrNo = document.form.csr_no.value;
		    		    	var param = "f_cmd="+MULTI+"&csr_no="+csrNo+"&apro_tp_cd="+tpCd;
		    			    var sXml = sheetObjects[0].GetSaveXml("COM_CSR_0016GS.do", param);
	    				}
		    		}
					/*---------------------------------------------------------------------------------*/
					
					if(ifStatus=="Requesting Approval" && tpCd=="GW") {
						
						doActionIBSheet(sheetObjects[0], formObject , IBSEARCH_ASYNC02);
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					} else if(ifStatus=="Requesting Approval" && tpCd=="AL") {
						
						if(formObject.apro_step.value==undefined || formObject.apro_step.value==null || formObject.apro_step.value.trim()==''){
							ComShowMessage(ComGetMsg('TRS90100'));
							return false;
						} else {
						   doActionIBSheet(sheetObjects[0], formObject , IBSEARCH_ASYNC03);
						   doActionIBSheet(sheetObjects[0],formObject,IBSEARCH); 
						}   
					} else{
						return false;
					}
			   //***** 
					break;
			   //*** 2014.11.03 10만불 관련 Aproval 로직 추가- 3만불 이하 Case 사용 
                  case "btng_search":

					var v_ofc_cd = ""; 
					if(document.form.ofc_tp[0].checked){
						v_ofc_cd = document.form.cost_ofc_cd.value;
					}else if (document.form.ofc_tp[1].checked){
						v_ofc_cd = document.form.inv_ofc_cd.value;
					}
					
					var v_sub_sys_cd = "TRS";      
					var v_apro_step = document.form.apro_step.value;
					var param = "?mode=set&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&apro_step="+encodeURIComponent(v_apro_step)+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";            

					ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);		
					break;
					
  				case "btng_agreement":

					if (sheetObjects[0].RowCount <= 0){
						ComShowMessage(ComGetMsg('TRS90390'));//ComShowMessage('조회된 data가 없습니다.');
						return false;
					}
					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
						ComShowMessage(ComGetMsg('TRS90382'));//ComShowMessage('선택된 row가 없습니다.');
						return false;
					}
					
					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_number')==undefined || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_number')==null || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_number').trim()==''){
						ComShowMessage(ComGetMsg('TRS90622')); //ComShowMessage('선택된 row에 CSR No.가 없습니다.');
						return false;
					}

					var v_csr_no = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_number');
					
					var ifStatus = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_sts');
					var tpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_apro_tp_cd');
					
					openPopupAgmtFiles(v_csr_no, ifStatus, tpCd);
					
					break;	
	
					
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                errMsg = ComGetMsg("TRS90392" );
                ComShowMessage(errMsg);
            } else {
                ComShowMessage(e);
            }
        }
    }

    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;
    }

    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        document.all.btng_apro_step.style.visibility = "hidden"; 
        
        var formObj = document.form;

        if(ComTrimAll(formObj.if_sts)!=""){
        	formObj.if_status.value = formObj.if_sts.value ;
        }
        
        if(ComTrimAll(formObj.mult_csr_no)!=""){
        	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);	
        } 
        
    }

    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    style.height = GetSheetHeight(13);
                    SheetWidth = mainTable.clientWidth;

                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    MergeSheet = msHeaderOnly;

                    //Editable = false;
                    Editable = true;

                    InitRowInfo( 1, 1, 9, 100);

                    InitColumnInfo(28, 1, 0, true);

                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "CSR No.|Payment S/P|Payment S/P|I/F\nStatus|I/F Status\nUpdated Time|Error Reason|No of Invoice|Currency|Total\nAmount|USD\nAmount|Payment\nDue Date|Payment\nGroup|Date Of Tax|ASA No.|Mst. Inv File|GW\nContract|Contract|Files|Apro Type" ;

                    //[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,      125,   daCenter,   false,    "csr_number",       false,      "",     dfNone,         0,          false,          false   ); //true,          true   );
                    InitDataProperty(0, cnt++ , dtData,       45,   daCenter,   false,    "vndr_no",          false,      "",     dfNone,         0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtData,      160,   daLeft,     false,    "vndr_nm",          false,      "",     dfNone,         0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtData,      110,   daLeft,     false,    "if_sts",           false,      "",     dfNone,         0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtData,      110,   daCenter,   false,    "if_sts_dt",        false,      "",     dfUserFormat2,  0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtData,      130,   daLeft,     false,    "if_err_rsn",       false,      "",     dfNone,         0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtData,       80,   daCenter,   false,    "inv_cnt",          false,      "",     dfNone,         0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtData,       60,   daCenter,   false,    "csr_curr_cd",      false,      "",     dfNone,         0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtData,       70,   daRight,    false,    "csr_amt",          false,      "",     dfNullFloat,    2,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtHidden,     80,   daRight,	false,    "csr_usd_amt",	  false,	  "",	  dfNullFloat,	  2,		  false,	  	false	);
                    InitDataProperty(0, cnt++ , dtData,       70,   daCenter,   false,    "py_due_dt",        false,      "",     dfDateYmd,      0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtData,       105,  daCenter,   false,    "pay_grp_lu_cd",    false,      "",     dfNone,         0,          false,          false   );//true,          true   );                    
                    InitDataProperty(0, cnt++ , dtData,       80,   daCenter,   false,    "date_of_tax",      false,      "",     dfDateYmd,      0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtData,       70,   daCenter,   false,    "asa_no",           false,      "",     dfNone,         0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,   false,    "mst_inv_file_flg", false,      "",     dfNone,         0,          false,          false   );//true,          true   );

                    InitDataProperty(0, cnt++ , dtPopup,60, daCenter,			false,    "agmt_doc_cfm_cd",	false,			"",			dfNone,			0,			true,			true	);
					InitDataProperty(0, cnt++ , dtPopup,60, daCenter,			false,    "agmt_file_cfm_cd",	false,			"",			dfNone,			0,			true,			true	);
					InitDataProperty(0, cnt++ , dtPopup,50, daCenter,			false,    "file_upld_flg",		false,			"",			dfNone,			0,			true,			true	);

                    InitDataProperty(0, cnt++ , dtCombo,      60,   daCenter,   false,    "csr_apro_tp_cd",   false,      "",     dfNone,         0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtHidden,     10,   daCenter,   false,    "mst_inv_file_id",  false,      "",     dfNone,         0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtHidden,     10,   daCenter,   false,    "if_sts_indicator", false,      "",     dfNone,         0,          false,          false   );//true,          true   );
                    InitDataProperty(0, cnt++ , dtHidden,	  10,   daLeft,		false,    "apro_rqst_no",	  false,	  "",	  dfNone,		  0,		  false,		 false	);
                    InitDataProperty(0, cnt++ , dtHidden,	  10,   daLeft,		false,    "csr_cost_ofc_cd",  false,	  "",	  dfNone,		  0,  		  false,		 false	);
					InitDataProperty(0, cnt++ , dtHidden,	  10,   daLeft,		false,    "iss_dt",			  false,	  "",	  dfNone,	      0,		  false,		 false	);
					InitDataProperty(0, cnt++ , dtHidden,	  10,   daLeft,		false,    "rcv_dt",			  false,	  "",	  dfNone,		  0,          false,		 false	);
					InitDataProperty(0, cnt++ , dtHidden,	  10,   daLeft,		false,    "acct_xch_rt_yrmon",	false,	  "",	  dfNone,		  0,		  false,	  	 false	);
					InitDataProperty(0, cnt++ , dtHidden,	  10,   daLeft,		false,    "apro_type_flg",    false,	  "",	  dfNone,		  0,		  false,	  	 false	);
					InitDataProperty(0, cnt++ , dtHiddenStatus,20,  daCenter ,  false,    "ibflag",           false,          "");
					
					InitDataCombo(0, "csr_apro_tp_cd", "G/W|ALPS", "GW|AL");
 
                    InitUserFormat2(0, "if_sts_dt", "####-##-## ##:##:##", "-|:" );
                    
                    PopupImage  =  "/hanjin/img/btns_search.gif";
                    ShowButtonImage = 2;
               }
                break;
           case 2:      //sheet1 init
                with (sheetObj) {

                    style.height = GetSheetHeight(13);

                    SheetWidth = mainTable.clientWidth;

                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    MergeSheet = msHeaderOnly;

                    Editable = true;

                    InitRowInfo( 1, 1, 9, 100);

                    InitColumnInfo(25, 1, 0, true);

                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt" ;

                    //[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,	 				70,	daLeft,			false,    "pre_csr_no",				false,			"",			dfNone,				0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_office",				false,			"",			dfNone,				0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_prpd_dy",			false,			"",			dfNone,				0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_to",				false,			"",			dfNone,				0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_csr_type",			false,			"",			dfNone,				0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_desc",					false,			"",			dfNone,				0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_group",		false,			"",			dfNone,				0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_evi_tp",				false,			"",			dfNone,				0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_due_date",			false,			"",			dfNone,				0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_asa_no",				false,			"",			dfNone,				0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_inv_dt",				false,			"",			dfNone,				0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_curr_cd",			false,			"",			dfNone,				0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_amt",					false,			"",			dfNullFloat,				2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_curr_cd",	false,			"",			dfNone,				0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_amt",			false,			"",			dfNullFloat,				2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "apro_step",				false,			"",			dfNone,				0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_title",				false,			"",			dfNone,				0,			false,			false	);					
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_mail",				false,			"",			dfNone,				0,			false,			false	);					
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_mail1",				false,			"",			dfNone,				0,			false,			false	);					
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_mail2",				false,			"",			dfNone,				0,			false,			false	);					
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_mail3",				false,			"",			dfNone,				0,			false,			false	);					
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_mail4",				false,			"",			dfNone,				0,			false,			false	);					
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_mail5",				false,			"",			dfNone,				0,			false,			false	);					
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_mail6",				false,			"",			dfNone,				0,			false,			false	);					
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_mail7",				false,			"",			dfNone,				0,			false,			false	);					
					


               }
                break; 

            case 3:      //sheet1 init
                with (sheetObj) {
                    style.height = GetSheetHeight(13);
                    SheetWidth = mainTable.clientWidth;

                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    MergeSheet = msHeaderOnly;

                    Editable = true;

                    //[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 1, 0, true);

                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "char of account|account name|gl date|city|inv no|desc|debit|credit|total amt" ;

                    //[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  								KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "pre_chart_of_account",		false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData, 			80,			daCenter,		false,    "pre_account_name",				false,			"",			dfNone,					0,			true,			true	);
					InitDataProperty(0, cnt++ , dtData,	 			80,			daLeft,			false,    "pre_gl_date",						false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_city",								false,			"",			dfNone,					2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_inv_no",							false,			"",			dfNone,					2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_desc",								false,			"",			dfNone,					2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_debit",							false,			"",			dfNullFloat,					2,			false,			false	); 
					InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_credit",							false,			"",			dfNullFloat,					2,			false,			false	);										


               }
                break;      
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:

                formObj.f_cmd.value = SEARCHLIST;
			    sheetObj.DoSearch4Post("ESD_TRS_0047GS.do", TrsFrmQryString(formObj));
			    break;

            case IBSAVE:        //if err cancel
   				formObj.f_cmd.value = MULTI19;
				formObj.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_number');
				
				var sXml = sheetObj.GetSaveXml("ESD_TRS_0047GS.do", TrsFrmQryString(formObj));
				sheetObj.LoadSaveXml(sXml,true);
                break;

            case 'IBSAVE2':    //approval request cancel
   				formObj.f_cmd.value = MULTI20;
				formObj.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_number');
				//CHM-201534969 CSR Cancel 이력 관리 2015.04.16
				formObj.csr_tp_cd.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_apro_tp_cd');
				
				var sXml = sheetObj.GetSaveXml("ESD_TRS_0047GS.do", TrsFrmQryString(formObj));

				sheetObj.LoadSaveXml(sXml,true);
                break;

           case IBINSERT:
                sheetObj.DataInsert();
                break;

           case IBCOPYROW:
              sheetObj.DataCopy();
              break;

           case IBDOWNEXCEL:
              sheetObj.Down2Excel(-1, false, false, true);

              break;

           case IBLOADEXCEL:
              sheetObj.LoadExcel();
              break;
              
           case IBSEARCH_ASYNC02:	//GW 결재 요청
        	   if (!validateForm(sheetObj,formObj,sAction)){
        		   return false;
        	   }
        	   
        	   formObj.f_cmd.value = MULTI10;
        	   formObj.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,"csr_number");
        	   var param = "?inv_sub_sys_cd=TRS";

        	   var sXml = sheetObj.GetSearchXml("COM_CSR_00081GS.do"+param, FormQueryString(formObj),"",true);   			

        	   var gwUrl = ComGetEtcData(sXml , "GW_URL");

        	   if (ComIsNull(gwUrl)) {
        		   ComShowMessage("There is no data.");
        		   return;
        	   }

        	   //window.setTimeout(false, 3000);
        	   ComOpenPopup(gwUrl, 900, 780, "", "1,0,1,1,1", true);

        	   break;
        	   
            case IBSEARCH_ASYNC03:        //결재요청(ALPS)
				if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
				
                formObj.f_cmd.value = MULTI11;
				
				formObj.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_number');
				
				//CSR Create 화면에서 사용하는 input name과 동일하게 변수명을 설정해야 Apro Step 정보 생성시 값이 저장된다.
				formObj.vndr_seq.value = sheetObj.CellValue(sheetObj.SelectRow,'vndr_no');
				formObj.inv_knt.value = sheetObj.CellValue(sheetObj.SelectRow,'inv_cnt');
				formObj.curr_cd.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_curr_cd');   
				formObj.total_amt.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_amt');
				formObj.max_iss_dt.value = sheetObj.CellValue(sheetObj.SelectRow,'iss_dt');
				formObj.max_rcv_dt.value = sheetObj.CellValue(sheetObj.SelectRow,'rcv_dt');
				formObj.payment_due_dt.value = sheetObj.CellValue(sheetObj.SelectRow,'py_due_dt');
				var param = "?inv_sub_sys_cd=TRS";

				var sXml = sheetObj.GetSaveXml("COM_CSR_00081GS.do"+param, FormQueryString(formObj));
				sheetObj.LoadSaveXml(sXml,true);
              break;   
        	   
        }
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param {ibsheet} sheetObj	ibsheet object
     * @param {form} 	formObj		form object
     * @param {String}	sAction		action value
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }

    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:
                formObj.csr_no.value    = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 'csr_number');
               	formObj.f_cmd.value     = SEARCH01;                  
                sheetObjects[2].DoSearch4Post("ESD_TRS_0047PreView.do", TrsFrmQryString(formObj));     
                break;        
       }
    } 
    
    function sheet1_OnSaveEnd(sheetObj , ErrMsg)
    {
        if ( ErrMsg != "") return;
        doActionIBSheet(sheetObj , document.form, IBSEARCH);
    }
    
    function sheet3_OnSearchEnd(sheetObj,errMsg){

        if(errMsg!=null){
            ComShowMessage(errMsg);
        }
        
        var previewFlg 			= "";
        var pre_title   		= "";
        
		var pre_csr_no			= sheetObj.EtcData("pre_csr_no");			
		var pre_office			= sheetObj.EtcData("pre_office");				
		var pre_prpd_dy			= sheetObj.EtcData("pre_prpd_dy");			
		var pre_pay_to			= sheetObj.EtcData("pre_pay_to");				
		var pre_csr_type		= sheetObj.EtcData("pre_csr_type");		
		var pre_desc				= sheetObj.EtcData("pre_desc");					
		var pre_pay_group		= sheetObj.EtcData("pre_pay_group");		
		var pre_evi_tp			= sheetObj.EtcData("pre_evi_tp");				
		var pre_due_date		= sheetObj.EtcData("pre_due_date");			
		var pre_asa_no			= sheetObj.EtcData("pre_asa_no");				
		var pre_inv_dt			= sheetObj.EtcData("pre_inv_dt");				
		var pre_curr_cd			= sheetObj.EtcData("pre_curr_cd");			
		var pre_amt					= sheetObj.EtcData("pre_amt");
		var pre_evi_tp_count  = sheetObj.EtcData("pre_evi_tp_count");
		var apro_step      = sheetObj.EtcData("pre_appro_by");
		//N200902170070 2009-02-23 : CSR Check Mailing Address
		var chk_mail        = sheetObj.EtcData("chk_mail");
		var chk_mail1        = sheetObj.EtcData("chk_mail1");
		var chk_mail2        = sheetObj.EtcData("chk_mail2");
		var chk_mail3        = sheetObj.EtcData("chk_mail3");
		var chk_mail4        = sheetObj.EtcData("chk_mail4");
		var chk_mail5        = sheetObj.EtcData("chk_mail5");
		var chk_mail6        = sheetObj.EtcData("chk_mail6");
		var chk_mail7        = sheetObj.EtcData("chk_mail7");

		if(pre_amt==0 || pre_amt=="0" || pre_amt=="0.00"){
				pre_title  = "TRANSFER SLIP";
		}else{
				pre_title  = "CONSULTATION SLIP";
		}	
		
		sheetObjects[1].RemoveAll();   

		sheetObjects[1].DataInsert(-1);     
         
        sheetObjects[1].CellValue(1,"pre_csr_no") 	= pre_csr_no;
        sheetObjects[1].CellValue(1,"pre_office") 	= pre_office;
        sheetObjects[1].CellValue(1,"pre_prpd_dy") 	= pre_prpd_dy; 
        sheetObjects[1].CellValue(1,"pre_pay_to") 	= pre_pay_to;
        sheetObjects[1].CellValue(1,"pre_csr_type") = pre_csr_type;
        sheetObjects[1].CellValue(1,"pre_desc") 		= pre_desc;
        sheetObjects[1].CellValue(1,"pre_pay_group")= pre_pay_group; 
        sheetObjects[1].CellValue(1,"pre_evi_tp") 	= pre_evi_tp+"/"+pre_evi_tp_count;
        sheetObjects[1].CellValue(1,"pre_due_date") = pre_due_date;
        sheetObjects[1].CellValue(1,"pre_asa_no") 	= pre_asa_no; 
        sheetObjects[1].CellValue(1,"pre_inv_dt") 	= pre_inv_dt; 
        sheetObjects[1].CellValue(1,"pre_curr_cd") 	= pre_curr_cd; 
        sheetObjects[1].CellValue(1,"pre_amt") 			= pre_amt; 
        sheetObjects[1].CellValue(1,"apro_step") 			= apro_step; 
        sheetObjects[1].CellValue(1,"pre_title") 		= pre_title;
        //N200902170070 2009-02-23 : CSR Check Mailing Address
        sheetObjects[1].CellValue(1,"chk_mail")         = chk_mail;
        sheetObjects[1].CellValue(1,"chk_mail1")         = chk_mail1;
        sheetObjects[1].CellValue(1,"chk_mail2")         = chk_mail2;
        sheetObjects[1].CellValue(1,"chk_mail3")         = chk_mail3;
        sheetObjects[1].CellValue(1,"chk_mail4")         = chk_mail4;
        sheetObjects[1].CellValue(1,"chk_mail5")         = chk_mail5;
        sheetObjects[1].CellValue(1,"chk_mail6")         = chk_mail6;
        sheetObjects[1].CellValue(1,"chk_mail7")         = chk_mail7;

        if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY"){
         		previewFlg = "krjp";
        }
        
		ComOpenPopup('/hanjin/ESD_TRS_0036.do?previewFlg='+previewFlg, 800,720,'', '1,0,1,1,1,1,1,1');

    }			
    
	function OnPopupClick()
	{
			var formObject = document.form;
			var cmdt_cd_val ="";
			var rep_cmdt_cd_val ="";
			var cmdt_desc_val ="";
			var classId ="getCOM_ENS_so";
			var xx1="";  //CONTI
			var xx2="";  //SUB CONTI
			var xx3="";  //COUNTRY
			var xx4="";  //STATE
			var xx5="";  //CONTROL OFFIC
			var xx6="";  //LOC CODE
			var xx7="";  //LOC NAME
			var xx8="";
			var xx9="";
	        var title = "CSR NO.";
			var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title;
			ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 412, 330, 'getCOM_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');

	}

	function getTRS_ENS_906(rowArray,returnval) {

		var formObject = document.form;

			var x1=document.form.mult_csr_no.value;
			if(x1==""){
				document.form.mult_csr_no.value = rowArray;
				formObject.mult_csr_no.focus();
			}else{
				document.form.mult_csr_no.value = document.form.mult_csr_no.value+","+rowArray;
				formObject.mult_csr_no.focus();
			}
	}

    function Minimize(nItem)
    {

        var objs = document.all.item("showMin");

        if ( nItem == "1" )
        {
            objs.style.display = "none";

            sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
            sheetObjects[0].focus();
            sheetObjects[0].ViewRows  =20;
        }
        else
        {
            objs.style.display = "inline";

            sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
            sheetObjects[0].focus();
            sheetObjects[0].ViewRows  =10;
        }
    }
    

/**
	 * regular expression을 통과해도 진짜 날짜 유형 객체에 적합한지 검사한다.<br>  
	 * 사용예: 2006-11-00은 정규식은 통과하지만, 사실상 유효하지 않는 날짜이다.<br>
	 * 
	 * @param {String}	str_date	Date
	 * @param {String}	del			delete 구분자
	 **/
function isValidDateObject(str_date, del){
    if (del==undefined || del==null || del.trim()==''){del = '-';}
    var arr_date = str_date.split(del);
    var obj_date = new Date(arr_date[0],arr_date[1]-1,arr_date[2]);
    var result = (1*arr_date[0]==obj_date.getFullYear() && 1*arr_date[1]==(obj_date.getMonth()+1) && 1*arr_date[2]==obj_date.getDate());
    if (result){return true;
    } else {return false; 
    }
}


	function validateDateObj(obj){
		if (obj.readOnly==true){return false;}
		obj.value = ComTrim(obj.value);
		if (obj.value==null || ComTrim(obj.value)==''){return false;}
		if (!checkPeriodFormat(obj.value) || !isValidDateObject(obj.value,'-')){
                errMsg = ComGetMsg("TRS90070" );
                ComShowMessage(errMsg);
			obj.focus();
			return false;
		}
		var formObj = document.form;
		if (formObj.fm_eff_dt.value!=null && ComTrim(formObj.fm_eff_dt.value)!='' && 
			formObj.to_eff_dt.value!=null && ComTrim(formObj.to_eff_dt.value)!='' && 
			!isValFmTo(formObj.fm_eff_dt.value, formObj.to_eff_dt.value)){
                errMsg = ComGetMsg("TRS90118" );
                ComShowMessage(errMsg);
			return false;
		}
		return true;
	}
    
	function isValFmTo(fmDt, toDt){
		if (fmDt==undefined || fmDt==null || ComTrim(fmDt)=='' || toDt==undefined || toDt==null || ComTrim(toDt)==''){
			return false;
		}
		var str_fmDt = fmDt.replace(/-/gi,'');
		var str_toDt = toDt.replace(/-/gi,'');
		if (isNaN(str_fmDt) || isNaN(str_toDt) || ComTrim(str_fmDt).length!=8 || ComTrim(str_toDt).length!=8) {
			return false;
		}
		if (parseInt(str_toDt,10) - parseInt(str_fmDt,10) <= 0){
			return false;
		}
		return true;
	}

	function checkPeriodFormat(prd_dt){
		var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
		if (!checkFormat(prd_dt, date_regexp)){	return false;
		} else { return true;
		}
	}
	
    function checkFormat(src, regexp){
		if (src==null || src=='' || regexp==null || regexp==''){return false;}
		result = (regexp.test(src));
		if (!result){return false;
		} else {return true;
		}
	}
    
    function getCalendar() {
		var cal = new ComCalendarFromTo();
    	cal.displayType = "date";
    	cal.select(document.form.fm_eff_dt, document.form.to_eff_dt, 'yyyy-MM-dd');
    }

    function isNum(obj){
    	if (!ComIsNumber(obj)){
    		obj.value = '';
    	}
    }
    
    /**
     * PDT 화면에서 호출하여 사용
     * Common Approval Inquiry화면에서 Preview화면 호출시 사용함.
     * TRS에서 사용하지 않음.
     * 2014.07.18 BY SHIN DONG IL(Requested by 비용 전표 상신용 Approval 구축 프로젝트)
     */
    function doPaymentSlip() {

    	var formObj = document.form;
 
    	formObj.csr_no.value    =  parent.document.form.csr_no.value;
        formObj.f_cmd.value     = SEARCH01;                  
        sheetObjects[2].DoSearch4Post("ESD_TRS_0047PreView.do", TrsFrmQryString(formObj));  
		
    }   
    
    /**
     * Sheet관련 프로세스 처리
     * 
     * @param {ibsheet} sheet1	ibsheet ojbect
     * @param {String}  Row, Col      
     * @return
     */
	function sheet1_OnChange(sheet1, Row, Col){
		/*결재 유형 변경시 이벤트  SY SHIM*/
		if(sheet1.CellValue(Row, 'csr_apro_tp_cd') == 'GW'){
			document.all.btng_apro_step.style.visibility = "hidden"; 
		}else{
			document.all.btng_apro_step.style.visibility = "visible";
		}
		
		sheet1_OnClick(sheet1, Row, Col, "");
	}

    /**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheet    IBSheet Object
     * @param {ibsheet} row     	sheet 선택된 row
     * @param {ibsheet} col     	sheet 선택된 col
     * @param {String} 	value     	파일명
     **/
    function sheet1_OnClick(sheet,row,col,value){

    	var formObj = document.form;
		if(sheet.RowCount > 0){
			
	        ComBtnEnable("btng_csrcancel");
			ComBtnEnable("btng_approvalrequest");

			if(sheet.CellValue(row,"if_sts")=="Requesting Approval"  && sheet.CellValue(row, "csr_apro_tp_cd")=="AL") {
				document.all.btng_apro_step.style.visibility = "visible"; 
				
				var cost_ofc_cd = (sheet.CellValue(row,"csr_cost_ofc_cd"));
				//formObj.cost_ofc_cd.value	= cost_ofc_cd ;
				//Cost Office 와 Log-in Office 가 동일할 경우 Radio 버튼 비활성화
  				if(cost_ofc_cd == formObj.inv_ofc_cd.value) { 
  					ComEnableObject(formObj.ofc_tp[0], false);
  					ComEnableObject(formObj.ofc_tp[1], false);			
  				}else{
  					ComEnableObject(formObj.ofc_tp[0], true);
  					ComEnableObject(formObj.ofc_tp[1], true);			
  				}
  				
				
    			  //Apro Step 정보를 AproUtil에서 조회한다.
    				formObj.f_cmd.value = SEARCH10;
    				formObj.cost_ofc_cd.value = cost_ofc_cd;
    				var param = "?inv_sub_sys_cd=TRS";

			        var sXml = sheetObjects[0].GetSearchXml("COM_CSR_00081GS.do?"+param , FormQueryString(form)); 
	
			        var apro_seq_key = ComGetEtcData(sXml,"apro_seq_key");
			        var cost_apro_step = ComGetEtcData(sXml,"cost_apro_step");
			        var login_apro_step = ComGetEtcData(sXml,"login_apro_step");
			        
			        formObj.aproSeqKey.value = apro_seq_key;
			        formObj.cost_apro_step.value = cost_apro_step;
			        formObj.login_apro_step.value = login_apro_step;
			        formObj.apro_step.value = login_apro_step;
					
			        formObj.ofc_tp[1].checked = true ;

			} else {
				document.all.btng_apro_step.style.visibility = "hidden"; 
				
				if(sheet.CellValue(row, "csr_apro_tp_cd")=="GW"){
					ComBtnDisable("btng_viewapprovalstep");
					var ifSts = sheet.CellValue(row,"if_sts");
					
					if(ifSts == "Requesting Approval"){
						ComBtnEnable("btng_csrcancel");
						ComBtnEnable("btng_approvalrequest");
					}else if (ifSts == "Disapproved" || ifSts == "I/F Error" ||ifSts == "A/P Rejected"){	
						ComBtnEnable("btng_csrcancel");
						ComBtnDisable("btng_approvalrequest");
					}else{
						ComBtnDisable("btng_csrcancel");
						ComBtnDisable("btng_approvalrequest");
					}
				}else{
					ComBtnEnable("btng_viewapprovalstep");
				}
				
			}
		}
    	
    	
    	if (sheet.ColSaveName(col) != "mst_inv_file_flg")  {
    		return;
    	}

    	if(sheet.CellText(row, "mst_inv_file_flg") == "") {
    		return;
    	}
    	
    	var frm1 = document.form1;
    	frm1.target = "iframe";
    	frm1.action = "/hanjin/FileDownload?key="+sheet.CellText(row, "mst_inv_file_id");
    	frm1.submit();
    	

    	
    	
    	return;
    }
    
	/**
	 * Cost Office, Log-in Office Radio 버튼 클릭시 Approval Step 변경
	 */
	function ofcChange(){
		var formObj = document.form;

		var apro_step = "";
		if(formObj.ofc_tp[0].checked){
			apro_step = formObj.cost_apro_step.value;
		}else if (formObj.ofc_tp[1].checked){
			apro_step = formObj.login_apro_step.value;
		}
		formObj.apro_step.value = apro_step;
	}
	
	function sheet1_OnSearchEnd(sheet1, ErrMsg){//alert("start sheet1_OnSearchEnd");
   	 
//		if (sheet1.RowCount > 0){	
//			for (var i=1; i<=sheet1.RowCount; i++){
//				if (sheet1.CellValue(i,'aft_act_flg')!=null && (sheet1.CellValue(i,'aft_act_flg')=='N' || sheet1.CellValue(i,'aft_act_flg')=='X')){
//					sheet1.RowBackColor(i) = sheet1.RgbColor(255, 153, 153);
//				}			
//			}			
//		}
		
		sheet1.SelectHighLight = false;
		
		// 첫번째 row 가 클릭된 되었을대와 동일하게 되도록 함.
		if (sheet1.RowCount > 0){
		   sheet1_OnClick(sheet1,1,1,"");
		}else{
		   document.all.btng_apro_step.style.visibility = "hidden"; 
		}  

		if (sheet1.RowCount > 0){
			for (var i=1; i<=sheet1.RowCount; i++){

				/*결재 유형 변경 콤보 유무 제공  SY SHIM*/
				/*var csrNo = sheet1.CellValue(i,'csr_number');
				document.form.csr_no.value = csrNo;
				document.form.f_cmd.value = SEARCH03;
			    var sXml = sheet1.GetSearchXml("COM_CSR_0002GS.do", FormQueryString(document.form));
			    var chkOfc = ComGetEtcData(sXml,"CN_OFC_CHK");
			    if('Y' == chkOfc){
			    	sheet1.CellEditable(i, 'csr_apro_tp_cd') = true;
			    	sheet1.InitCellProperty(i,'csr_apro_tp_cd', dtCombo);
			    	sheet1.CellComboItem(i, 'csr_apro_tp_cd', 'ALPS|G/W', 'AL|GW'); 
			    }*/
			    
			    
			    //apro_type_flg
				if(sheet1.CellValue(i,'apro_type_flg') == 'Y'){
			    	sheet1.CellEditable(i, 'csr_apro_tp_cd') = true;
			    	sheet1.InitCellProperty(i,'csr_apro_tp_cd', dtCombo);
			    	sheet1.CellComboItem(i, 'csr_apro_tp_cd', 'ALPS|G/W', 'AL|GW'); 
			    }
			}
		}
	}
	
	
	/**
	 * Sheet popup 
	 * 
     * @param {ibsheet} sheet1	ibsheet ojbect
     * @param {String}  row,col    
	 * @return
	 */
	function sheet1_OnPopupClick(sheet1, Row, Col) {
		var colName = sheet1.ColSaveName(Col);

	   	if (colName == "agmt_doc_cfm_cd" || colName == "agmt_file_cfm_cd" || colName == "file_upld_flg") {
	   		if (sheet1.RowCount > 0){
	   			var v_csr_no = sheet1.CellValue(Row, "csr_number");
	   			var ifStatus = sheet1.CellValue(Row, "if_sts");
				var tpCd = sheet1.CellValue(Row, "csr_apro_tp_cd");
				
				openPopupAgmtFiles(v_csr_no, ifStatus, tpCd);
	   		}
	   	}
	}
	
	/**
	 * Agreement File popup
	 * 
	 * @param v_csr_no
	 * @param ifStatus
	 * @param tpCd
	 */
	function openPopupAgmtFiles(v_csr_no, ifStatus, tpCd){
//    	var height = screen.height; 
//     	var width = screen.width;
//	                          
//     	var w = 800;
//        var h = 370;
//        var leftpos = width/2 - w/2; 
//     	var toppos = height/2 - h/2; 
//     	if(leftpos<0) leftpos=0;
//     	if(toppos<0) toppos=0;
     	
     	var tabStatus = "";
     	var readOnly = "";
     	if(ifStatus=="Requesting Approval") {
			readOnly = "N";
		} else {
			readOnly = "Y";
		}

		if(tpCd=='GW') {
			tabStatus = "1|0|1";
		} else {
			tabStatus = "1|1|1";
		}
     	
     	var url = "/hanjin/COM_CSR_0023.do?csr_no="+v_csr_no+"&tabStatus="+tabStatus+"&readOnly="+readOnly;
        //window.open(url, "stepPop", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);
        ComOpenPopup(url, 1020, 580, '', 'none', true); 

        //var url = "/hanjin/COM_CSR_0023.do?csr_no="+v_csr_no;
        //window.open(url, "stepPop", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos); 
        
     }