/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0139.js
*@FileTitle : AccountReceivableInvoiceMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2014.08.27 최도순
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2014.08.26 최도순 [CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
* 2014.10.07 최도순[CHM-201432279] 미주지역 invoice Issue 메뉴 보완 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * FNS_INV_0139 : FNS_INV_0139 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     FNS_INV_0139()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 정휘택
     * @version 2009.10.20
     */
    function FNS_INV_0139() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
	 /* 개발자 작업 */
	
	 // 공통전역변수
	
	 var tabObjects = new Array();
	 var tabCnt = 0 ;
	 var beforetab = 1;
	
	 var sheetObjects = new Array();
	 var sheetCnt = 0;
	 
	 var rdObjects = new Array();
	 var rdCnt = 0;
	 
	 var timer = null;

     // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 	 document.onclick = processButtonClick;

     /**
      * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
      * <br><b>Example :</b>
      * <pre>
      *     processButtonClick()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];
          
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");     		
     		
             switch(srcName) {
             	
             	case "btn_retrieve":
             		
             		// User ID Option으로 조회시 Date (From, To) 입력토록 수정       
 					if ((formObject.chk_userid.checked) & (formObject.chk_cust.checked != true) & (formObject.chk_vvd.checked != true) &
 					    (formObject.chk_blno.checked != true) & (formObject.chk_all.checked != true))
 					{
 						var from_dt = formObject.from_dt.value;
 						var to_dt = formObject.to_dt.value;
 						if (from_dt == "" & to_dt == ""){
 							ComShowCodeMessage("INV00165");
 							return;
 						}
 		            }
 					
             		if(validateForm(sheetObjects[0],document.form,"")){
             			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
             		}
             		break;
             		
             	case "btn_preview":
        			//alert("btn_preview");
        			invPreview(sheetObject1, formObject);
        			break; 
        			
 				case "btn_paperissue": 	
                    
 					
 					var sRow = sheetObject1.FindCheckedRow(0);
 			      	if (sRow == "") {
 			      		ComShowCodeMessage("INV00025");
 			      		return false;
 			      	}  
 					
 					// User ID Option으로 조회시 Date (From, To) 입력토록 수정       
 					if ((formObject.chk_userid.checked) & (formObject.chk_cust.checked != true) & (formObject.chk_vvd.checked != true) &
 					    (formObject.chk_blno.checked != true) & (formObject.chk_all.checked != true))
 					{
 						var from_dt = formObject.from_dt.value;
 						var to_dt = formObject.to_dt.value;
 						if (from_dt == "" & to_dt == ""){
 							ComShowCodeMessage("INV00165");
 							return;
 						}
 		            }
 					
 					if(validateForm(sheetObjects[0],document.form,"")){
 						
 						var chkStampObj = document.getElementsByName('stamp_type');
 						var chkStamp = "";
 						
 			            for(var i = 0; i < chkStampObj.length; i++) {
 			              if(chkStampObj[i].checked) {
 			            	 chkStamp = chkStampObj[i].value;
 			                   break;
 			              }
 			           }
 			            
						
 						var bkg_nos = ""; 						
		    			
 						for (var i = 0; i < sheetObjects[0].RowCount; i++) {
 					    	if(sheetObjects[0].CellValue(i+1, 0) == "1"){
 					    		if (sheetObjects[0].CellValue(i+1, 4) != ""){
 					    			bkg_nos = bkg_nos + "'"+ sheetObjects[0].CellValue(i+1, 4) + "',";
 					    		}
 					    	}
 					    } 
 						
 						if (0 < bkg_nos.indexOf(",")){
	    					bkg_nos = bkg_nos.substring(0, bkg_nos.length - 1);
 						}
 					    
 					   formObject.bkg_nos.value = bkg_nos; 					   				
 						
 					   if (bkg_nos != "") {
 							
 							var arrStr2 = form.ar_ofc_cd.Code.split("^");
 							form.ar_ofc_cd2.value = arrStr2[1];	 
 			            	
 			            	rdOpen(rdObjects[0], bkg_nos, form.ar_ofc_cd2.value, chkStamp);
 							//프린트세팅
 					    	 var print_nm = form.print_nm.value;
 					    	 if(print_nm != ""){
 					    		 rdObjects[0].SetPrintInfo (print_nm, 1, 1, 4);
 					    	 }
 							rdObjects[0].CMPrint(); //인쇄 시작
 							
 							sendFaxEml(sheetObject1,'P');
 							
 		            	}
					 					
					} else {
						return;
					}
 					break;

 				case "btn_new":
 					initField();
 					//setRevType();
 					break; 
 					
 				case "btn_fax":
 					
 					var arrRow = ComFindText(sheetObject1, "chk", 1);
					if (arrRow && 0<arrRow.length) {
						var cust_code = sheetObject1.CellValue(arrRow[0],"cust_code");
						var fax_no = sheetObject1.CellValue(arrRow[0],"cust_fax_no");
						var loop_cust_code;
						var loop_fax_no;
						for (var i=0; i<arrRow.length; i++) {
							loop_cust_code = sheetObject1.CellValue(arrRow[i],"cust_code");
							loop_fax_no = sheetObject1.CellValue(arrRow[i],"cust_fax_no");
							if (""==loop_fax_no || cust_code != loop_cust_code || fax_no != loop_fax_no) {
								ComShowCodeMessage("COM12114","Customer & FAX");
								return false;
							}
						}
						
					}
					
					
					sendFaxEml(sheetObject1,'F');
				break;
				
				case "btn_eml":
					//sendFaxEml(sheetObject1,'E');
					
					
    				if (0==sheetObject1.CheckedRows("chk")) {
    					ComShowCodeMessage("INV00025");
    					return false;
    				}
    				
    				var arrRow = ComFindText(sheetObject1, "chk", 1);
					if (arrRow && 0<arrRow.length) {
						var cust_code = sheetObject1.CellValue(arrRow[0],"cust_code");
						var email = sheetObject1.CellValue(arrRow[0],"cust_eml");
						var loop_cust_code;
						var loop_email;
						for (var i=0; i<arrRow.length; i++) {
							loop_cust_code = sheetObject1.CellValue(arrRow[i],"cust_code");
							loop_email = sheetObject1.CellValue(arrRow[i],"cust_eml");
							if (""==loop_email || cust_code != loop_cust_code || email != loop_email) {
								ComShowCodeMessage("COM12114","Customer & E-Mail");
								return false;
							}
						}
						
					}
					
					//var arrRow = ComFindText(sheetObject1, "chk", 1);
					//var bkg_no_list = "";
					var edt_to_eml = "";
					var edt_subject = "";
					if (arrRow && 0<arrRow.length) {
						//for (var i=0; i<arrRow.length; i++) {
						//	bkg_no_list += sheetObject1.CellValue(arrRow[i],"bkg_no")+'|';
						//}
						//if (0<bkg_no_list.indexOf("|")) bkg_no_list = bkg_no_list.substring(0,bkg_no_list.length-1);
						edt_to_eml = sheetObject1.CellValue(arrRow[0],"cust_eml");
						edt_subject = "["+ComGetNowInfo("dd")+"-"+ ComLpad(ComGetNowInfo("mm"),2,"0") + "-"+ ComGetNowInfo("yy") +"] "+"Payment Request Mail for "+sheetObject1.CellValue(arrRow[0],"cust_nm");
						ComOpenWindowCenter("/hanjin/FNS_INV_0140.do?edt_to_eml="+edt_to_eml+"&edt_subject="+edt_subject, "FNS_INV_0140", 700, 670, true);
					}
					
				break;

 				case "btn_goto":
                    // User ID Option으로 조회시 Date (From, To) 입력토록 수정       
 					if ((formObject.chk_userid.checked) & (formObject.chk_cust.checked != true) & (formObject.chk_vvd.checked != true) &
 					    (formObject.chk_blno.checked != true) & (formObject.chk_all.checked != true))
 					{
 						var from_dt = formObject.from_dt.value;
 						var to_dt = formObject.to_dt.value;
 						if (from_dt == "" & to_dt == ""){
 							ComShowCodeMessage("INV00165");
 							return;
 						}
 		            }
 					
 					//if(formObject.f_inv.value != "" & formObject.t_inv.value != ""){
 					//	var ar_ofc_cd = formObject.ar_ofc_cd2.value;
 				    //	if (ar_ofc_cd == "SZPSC" || ar_ofc_cd == "XMNSC" || ar_ofc_cd == "CANSO") { 
 				   // 		ComOpenWindowCenter("FNS_INV_0037.do?issueGubn=I", "pop", 1010, 750);
 				    //	} else {  
 				   // 		ComOpenWindowCenter("FNS_INV_0034_02.do?issueGubn=I", "pop", 1010, 750);
 				    //	}
 					//}else{
	 					if(validateForm(sheetObjects[0],document.form,"")){

	 					// issue 여부 체크
	 					/*
						   [CHM-201215781]
							중복 발행 허용하는 OFC에 한해서 중복발행시 ALERT 메시지 POP-UP 처리
							1) B/L NO 1건으로 이슈 하는 경우 , 해당 B/L NO 에 대해서 이미 INVOICE NO 가 존재하면			
								Invoice was issued already. Please select “YES” if you want to issue again with a new Invoice No		
							2) B/L NO 여러 개를 한번에 이슈하거나 또는 기간 으로 이슈하여 대상 B/L 이 복수개인 경우			
								Invoice for B/L #1, B/L #2, B/L #3 …. was issued already. Please select “YES” if you want to issue again with a new Invoice No		
								메시지박스의 버튼은 YES, NO			
								YES 는 기존 이슈 로직을 수행하면 되고			
								NO 는 STOP 한다 (이슈하면 안됨)
						 */
							var bl_nos	= checkIssuedBlNo(sheetObjects[0]);
	 						
	 						if(bl_nos != ''){
	 							var len	= bl_nos.split(',').length;
	 							
	 							if(len == 1){
	 								if(ComShowCodeConfirm("INV00153")){
	 									var ar_ofc_cd = formObject.ar_ofc_cd2.value;
				 						if (ar_ofc_cd == "DXBSC") {
				 							formObject.email_flag.value = "Y";
				 							var bl_nos = "";
				 						    for (var i = 0; i < sheetObjects[0].RowCount; i++) {
				 						    	for (var j = 0; j < 5; j++) {
				 						    		if (sheetObjects[0].CellValue(i+1, j) != ""){
				 						    			bl_nos = bl_nos + "'"+ sheetObjects[0].CellValue(i+1, j) + "',";
				 						    		}
				 						    	}
				 						    } 			    
				 						    if (bl_nos != ""){
				 						    	bl_nos = bl_nos + "''";
				 						    } 
				 						    formObject.bl_nos.value = bl_nos;
				 						    
				 						    var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
				 						    formObject.svr_id.value = arrStr2[7]; 	
				 						   	formObject.ots_smry_cd.value = arrStr2[13]; 	
				 						   	formObject.inv_dup_flg.value = arrStr2[14]; 
				 						   	formObject.inv_mlt_bl_iss_flg.value = arrStr2[15]; 
				 						
				 							var param = FormQueryString(formObject);
				 							ComOpenWindowCenter("FNS_INV_0110.do?"+param, "pop", 830, 350);
				 							//FNS_INV_0110 에서 issue ok 되면 호출 -  getFnsInv0110()
				 						}else{
					 						//ComBtnDisable("btn_goto");
					 
					 						formObject.email_flag.value = "Y";
					 						
						 					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
						 					 
						 					var state = formObject.state.value;  
						 					var r_invs = formObject.inv_nos.value;  
						 					var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
											formObject.ar_ofc_cd2.value = arrStr2[1];	
				 						}
	 								}else{
	 									return;
	 								}
	 							}else{
	 								if(ComShowCodeConfirm("INV00154", bl_nos)){
	 									var ar_ofc_cd = formObject.ar_ofc_cd2.value;
				 						if (ar_ofc_cd == "DXBSC") {
				 							formObject.email_flag.value = "Y";
				 							var bl_nos = "";
				 						    for (var i = 0; i < sheetObjects[0].RowCount; i++) {
				 						    	for (var j = 0; j < 5; j++) {
				 						    		if (sheetObjects[0].CellValue(i+1, j) != ""){
				 						    			bl_nos = bl_nos + "'"+ sheetObjects[0].CellValue(i+1, j) + "',";
				 						    		}
				 						    	}
				 						    } 			    
				 						    if (bl_nos != ""){
				 						    	bl_nos = bl_nos + "''";
				 						    } 
				 						    formObject.bl_nos.value = bl_nos;
				 						    
				 						    var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
				 						    formObject.svr_id.value = arrStr2[7]; 	
				 						   	formObject.ots_smry_cd.value = arrStr2[13]; 	
				 						   	formObject.inv_dup_flg.value = arrStr2[14]; 
				 						   	formObject.inv_mlt_bl_iss_flg.value = arrStr2[15]; 
				 						
				 							var param = FormQueryString(formObject);
				 							ComOpenWindowCenter("FNS_INV_0110.do?"+param, "pop", 830, 350);
				 							//FNS_INV_0110 에서 issue ok 되면 호출 -  getFnsInv0110()
				 						}else{
					 						//ComBtnDisable("btn_goto");
					 
					 						formObject.email_flag.value = "Y";
					 						
						 					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
						 					 
						 					var state = formObject.state.value;  
						 					var r_invs = formObject.inv_nos.value;  
						 					var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
											formObject.ar_ofc_cd2.value = arrStr2[1];	
				 						}
	 								}else{
	 									return;
	 								}
	 							}
	 						}else{
	 							var ar_ofc_cd = formObject.ar_ofc_cd2.value;
		 						if (ar_ofc_cd == "DXBSC") {
		 							formObject.email_flag.value = "Y";
		 							var bl_nos = "";
		 						    for (var i = 0; i < sheetObjects[0].RowCount; i++) {
		 						    	for (var j = 0; j < 5; j++) {
		 						    		if (sheetObjects[0].CellValue(i+1, j) != ""){
		 						    			bl_nos = bl_nos + "'"+ sheetObjects[0].CellValue(i+1, j) + "',";
		 						    		}
		 						    	}
		 						    } 			    
		 						    if (bl_nos != ""){
		 						    	bl_nos = bl_nos + "''";
		 						    } 
		 						    formObject.bl_nos.value = bl_nos;
		 						    
		 						    var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
		 						    formObject.svr_id.value = arrStr2[7]; 	
		 						   	formObject.ots_smry_cd.value = arrStr2[13]; 	
		 						   	formObject.inv_dup_flg.value = arrStr2[14]; 
		 						   	formObject.inv_mlt_bl_iss_flg.value = arrStr2[15]; 
		 						
		 							var param = FormQueryString(formObject);
		 							ComOpenWindowCenter("FNS_INV_0110.do?"+param, "pop", 830, 350);
		 							//FNS_INV_0110 에서 issue ok 되면 호출 -  getFnsInv0110()
		 						}else{
			 						//ComBtnDisable("btn_goto");
			 
			 						formObject.email_flag.value = "Y";
			 						
				 					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
				 					 
				 					var state = formObject.state.value;  
				 					var r_invs = formObject.inv_nos.value;  
				 					var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
									formObject.ar_ofc_cd2.value = arrStr2[1];	
		 						}
		 						
			//	 					if (state == "S" && r_invs != "") {	 						
			//
			//							var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
			//							formObject.ar_ofc_cd2.value = arrStr2[1];	                    
			//		                    var v_f_inv = formObject.f_inv.value;
			//		            		var v_t_inv = formObject.t_inv.value;
			//		                	var arrStr = r_invs.split("|");
			//		                	var v_copy_cnt = formObject.copy_cnt.value;  
			//		                	
			//		 					var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
			//							formObject.ar_ofc_cd2.value = arrStr2[1];	
			//
			//                        }
	 						}
						} else {
							return;
						} 		
 					//}	
 					
 					break; 
 					
                case "btns_calendar1":
                	var cal = new ComCalendar();
               	 	cal.setDisplayType('date');
					cal.select(form.from_dt, 'yyyy-MM-dd');
               	 	break;
                
                case "btns_calendar2":
                	var cal = new ComCalendar();
               	 	cal.setDisplayType('date');
					cal.select(form.to_dt, 'yyyy-MM-dd');
               	 	break;
 					

             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }

     /**
      * RD File 오픈 <br>
      * <br><b>Example :</b>
      * <pre>
      *     rdOpen(Rdviewer, inv_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, paperYn)
      * </pre>
      * @param {rdviewer} rdObject Rdviewer Object
      * @param {String} inv_no Invoice number
      * @param {String} line_num Description lile 수 
      * @param {String} user_nm 사용자명
      * @param {String} ofc_cd office code
      * @param {String} logo logo 명
      * @param {String} vvd vvd
      * @param {String} port_cd port code
      * @param {String} attach letter wording 첨부 flag
      * @param {String} paperYn print, email 구분
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */ 
   	 function rdOpen(Rdviewer, bkgNo, arOfcCd, stampType){
    	 
        var formObject = document.form; 
		var rdFile = "";		
 		
		rdFile = "FNS_INV_0139.mrd";
		
		
		//2011.11.11 요청처리
		//ofc_cd = document.form.login_ofc_cd.value;
		//rdParam = "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+user_nm+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num ["+line_num+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_paper_yn ["+paperYn+"] frm1_issue_type["+issue_type+"] frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";
		
		rdParam = "/rv form_bkgNo[( " + bkgNo + " )] ";
		rdParam += " form_type[2] ";
		rdParam += " form_dataOnly[N] ";
		rdParam += " form_manifest[N] ";
		rdParam += " form_usrId["+form.user_id.value+"] ";
		rdParam += " form_hiddeData[N] ";
		rdParam += " form_level[(1)] ";
		rdParam += " form_remark[] ";
		rdParam += " form_Cntr[1] ";
		rdParam += " form_mainOnly[N]";
		rdParam += " form_CorrNo[]";
		rdParam += " form_his_cntr[BKG_CONTAINER]";
		rdParam += " form_his_bkg[BKG_BOOKING] ";
		rdParam += " form_his_mkd[BKG_BL_MK_DESC]";
		rdParam += " form_his_xpt[BKG_XPT_IMP_LIC]";
		rdParam += " form_his_bl[BKG_BL_DOC] ";
		rdParam += " form_arofccd[" + arOfcCd + "] ";
		rdParam += " form_stamp_type[" + stampType + "] ";
		rdParam += " /rp [] ";
		rdParam += " /riprnmargin /rpypos [0]";
		
		
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";	
		
 		// 열고자 하는 RD 파일을 지정한다.		
		Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam);
    
 	}     
     
     /**
      * IBSheet Object를 배열로 등록 <br>
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
      * 배열은 소스 상단에 정의 <br>
      * <br><b>Example :</b>
      * <pre>
      *     setSheetObject(sheetObj)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function setSheetObject(sheetObj){

        sheetObjects[sheetCnt++] = sheetObj;

     }

     /**
      * Sheet 기본 설정 및 초기화 <br>
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();         
 		 //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 		 
 		 initRdConfig(rdObjects[0]);
 		 
     }
      
     /**
      * 업무 자바스크립트 sheet1_OnLoadFinish 이벤트 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     sheet1_OnLoadFinish(sheetObj);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function sheet1_OnLoadFinish(sheetObj) {
    	 for(var i=0; i<40; i++){
    		 sheetObj.DataInsert(-1);
		 }
    	 sheetObj.SelectCell(1,1,false);
    	 
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
    	 
     }
      
     /**
      * RD Object 초기화 <br>
      * <br><b>Example :</b>
      * <pre>
      *     initRdConfig(rdObject)
      * </pre>
      * @param {rdviewer} rdObject Rdviewer Object
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */ 
     function initRdConfig(rdObject){
 	     var Rdviewer = rdObject;
 	     Rdviewer.style.height = 0;
 	     Rdviewer.style.width = 0;
 	    
 	     Rdviewer.AutoAdjust = true;
 	     Rdviewer.ViewShowMode(0);
 	    
 		 Rdviewer.setbackgroundcolor(128,128,128);
 		 Rdviewer.SetPageLineColor(128,128,128);
 		 
 		 
 	 }
     
     /**
      * Office Combo 초기화 <br>
      * <br><b>Example :</b>
      * <pre>
      *     MakeComboObject(cmbObj, arrStr);
      * </pre>
      * @param {ibCombo} cmbObj 필수 IBCombo Object
      * @param {String} 콤보 리스트 스트링
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function MakeComboObject(cmbObj, arrStr) {
    	cmbObj.RemoveAll(); 
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		cmbObj.BackColor = "#CCFFFD";
		cmbObj.DropHeight = 190;
	 }     

     /**
      * Office 변경시 이벤트 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     ar_ofc_cd_OnChange(comboObj,value,text);
      * </pre>
      * @param {ibCombo} cmbObj 필수 IBCombo Object
      * @param {String} value cmbObj value
      * @param {String} text cmbObj text
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function ar_ofc_cd_OnChange(comboObj,value,text) {
     	getCopyCnt();
     	
     	var arrStr2 = document.form.ar_ofc_cd.Code.split("^");	
     	document.form.inv_dup_flg.value = arrStr2[14];
     	//setRevType();
     }
     
     /**
      * Number of copy invoice 조회 <br>
      * <br><b>Example :</b>
      * <pre>
      *     getCopyCnt();
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function getCopyCnt() {
 	    var sheetObject = sheetObjects[0];
 	    var formObject = document.form;		    
     	doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC10);	    	
     	//sheetObjects[0].SelectCell(1,0,false);
     }

     /**
      * 업무 자바스크립트 onfocusout 이벤트 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *    getCustNm()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function getCustNm() {
        var sheetObject = sheetObjects[0];
 	    var formObject = document.form;
 	    doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);	 	     	    
     } 

     /**
      * 업무 자바스크립트 OnKeyUp 이벤트 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *    objKeyup()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function objKeyup() {
 	    var formObject = document.form;
 	   switch (event.srcElement.name) {
		case "cust_cnt_cd":
			//initInvNO();
			var v_cust_cnt_cd = formObject.cust_cnt_cd.value;
 	    	if (v_cust_cnt_cd.length == 2) {
 	    		formObject.cust_seq.focus(); 	    		
 	    	}
		break;			
		case "from_dt":
			//initInvNO();
			var v_from_dt = formObject.from_dt.value
 	    	if (v_from_dt.length == 8) {
 	    		formObject.to_dt.focus();
 	    		
 	    	}
		break;
		case "to_dt":
			//initInvNO();			
		break;
		case "bnd":
			//initInvNO();			
		break;
		case "ar_ofc_cd":
			//initInvNO();			
		break;
		case "vvd":
			//initInvNO();			
		break;
		case "scp":
			//initInvNO();			
		break;
		case "port":
			//initInvNO();			
		break;
		case "cust_cnt_cd":
			//initInvNO();			
		break;
		case "cust_seq":
			//initInvNO();			
		break;
		case "rev_type":
			//initInvNO();			
		break;		
 	   } 	
 	}     
     
     function initInvNO(){
     	var formObj = document.form;
    	 	formObj.f_inv.value = "";
    	 	formObj.t_inv.value = "";
    	 	formObj.tot_inv_cnt.value = "";
     }
     
     /**
      * Customer Information Inquiry 화면 오픈 <br>
      * <br><b>Example :</b>
      * <pre>
      *     openFnsInv0013()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */ 
     function openFnsInv0013() { 	
      	var formObject = document.form;
      	if(formObject.cust_cnt_cd.value != "" && formObject.cust_seq.value != "") {
 	     	var param = '?cust_cnt_cd='+formObject.cust_cnt_cd.value+'&cust_seq='+formObject.cust_seq.value+'&pop_yn=Y';
 	 		ComOpenPopup('/hanjin/FNS_INV_0013.do' + param, 900, 650, 'getPopData', '0,0', false, false, "", "", 0);    
      	}
      
     }
     
     /**
      * Quick Customer Search 화면 오픈 <br>
      * <br><b>Example :</b>
      * <pre>
      *     openFnsInv0086()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */ 
     function openFnsInv0086() {
 		var classId = "FNS_INV_0086";

 		ComOpenPopup('/hanjin/FNS_INV_0086.do', 900, 400, 'getFnsInv0086', '1,0,1,1,1', false, false);
      	
     }    
     
     /**
      * Quick Customer Search 팝업에서 호출하는 함수 <br>
      * <br><b>Example :</b>
      * <pre>
      *     getFnsInv0086()
      * </pre>
      * @param rowArray
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */ 
  	 function getFnsInv0086(rowArray) {
 		 var colArray = rowArray[0];
 		
 		 var formObject = document.form;
 		
 		 formObject.cust_cnt_cd.value = colArray[8];
 		 formObject.cust_seq.value = ComLpad(colArray[9], 6, '0');
 		 formObject.cust_nm.value = colArray[4];
 	
  	 }    
     
     /**
      * VVD 클릭시 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     clickVvd()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */ 
     function clickVvd() {
    	 var formObj = document.form;
    	 if (formObj.chk_vvd.checked) {
    		 formObj.vvd.readOnly = false;
    		 formObj.scp.readOnly = false;
    		 formObj.port.readOnly = false;
    		 formObj.vvd.className ="input1";
    		 formObj.scp.className ="input";
    		 formObj.port.className ="input";
    		 
	    	 formObj.from_dt.className ="input";
	    	 formObj.to_dt.className ="input";
    		 
    	 } else {
    		 formObj.vvd.readOnly = true;
    		 formObj.scp.readOnly = true;
    		 formObj.port.readOnly = true;    		 
    		 formObj.vvd.value = "";
    		 formObj.scp.value = "";
    		 formObj.port.value = "";
    		 formObj.vvd.className ="input2";
    		 formObj.scp.className ="input2";
    		 formObj.port.className ="input2";
    		 
        	 if ((formObj.chk_userid.checked == true) & (formObj.chk_cust.checked != true) & (formObj.chk_vvd.checked != true) & 
        			 (formObj.chk_blno.checked != true) & (formObj.chk_all.checked != true)){
    	    	 formObj.from_dt.className ="input1";
    	    	 formObj.to_dt.className ="input1";
    		 }
    	 }
    	 //formObj.f_inv.value = "";
    	// formObj.t_inv.value = "";
    	 //formObj.tot_inv_cnt.value = "";
     }

     /**
      * Customer 클릭시 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     clickCust()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */ 
     function clickCust() {
    	 var formObj = document.form;
    	 if (formObj.chk_cust.checked) {
    		 formObj.cust_cnt_cd.readOnly = false;
    		 formObj.cust_seq.readOnly = false;
    		 formObj.cust_cnt_cd.className ="input1";
    		 formObj.cust_seq.className ="input1";
    		 formObj.popup1.disabled = false;
    		 formObj.popup2.disabled = false;
    		 
	    	 formObj.from_dt.className ="input";
	    	 formObj.to_dt.className ="input";
	    	 
    	 } else {
    		 formObj.cust_cnt_cd.readOnly = true;
    		 formObj.cust_seq.readOnly = true;
    		 formObj.cust_cnt_cd.value = "";
    		 formObj.cust_seq.value = "";
    		 formObj.cust_nm.value = "";
    		 formObj.cust_rgst_no.value = "";
    		 formObj.cr_curr_cd.value = "";
    		 formObj.cr_amt.value = "";
    		 formObj.phn_no.value = "";
    		 formObj.fax_no.value = "";
    		 formObj.cntc_pson_nm.value = "";
    		 formObj.cust_cnt_cd.className ="input2";
    		 formObj.cust_seq.className ="input2";
    		 formObj.popup1.disabled = true;
    		 formObj.popup2.disabled = true;
    		 
        	 if ((formObj.chk_userid.checked == true) & (formObj.chk_cust.checked != true) & (formObj.chk_vvd.checked != true) & 
        			 (formObj.chk_blno.checked != true) & (formObj.chk_all.checked != true)){
    	    	 formObj.from_dt.className ="input1";
    	    	 formObj.to_dt.className ="input1";
    		 }
    	 }
    	// formObj.f_inv.value = "";
    	// formObj.t_inv.value = "";
    	// formObj.tot_inv_cnt.value = "";
     }
     
     /**
      * B/L No 클릭시 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     clickCust()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */ 
     function clickBlno() {
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 if (formObj.chk_blno.checked) {
    		 sheetObjects[0].RemoveAll();    		 
			 for(var i=0; i<40; i++){
				 sheetObjects[0].DataInsert(-1);
			 }
			 setColor(sheetObj, "E");			 
			 sheetObj.Editable = true;
			 sheetObjects[0].SelectCell(1,0);
			 
			 //formObj.bnd.disabled = true;
			 formObj.bnd.selectedIndex = 0;
			 
	    	 formObj.from_dt.className ="input";
	    	 formObj.to_dt.className ="input";
    		 
    	 } else {
    		 	 
    		 sheetObjects[0].RemoveAll();    		 
			 for(var i=0; i<40; i++){
				 sheetObjects[0].DataInsert(-1);
			 }
			 setColor(sheetObj, "E");
			 sheetObj.Editable = true;    
			 sheetObjects[0].SelectCell(1,0);
			 
			 //formObj.bnd.disabled = true;
			 ComSetFocus(formObj.chk_blno);
			 //sheetObjects[0].SelectCell(0,0,false);
			 
        	 if ((formObj.chk_userid.checked == true) & (formObj.chk_cust.checked != true) & (formObj.chk_vvd.checked != true) & 
        			 (formObj.chk_blno.checked != true) & (formObj.chk_all.checked != true)){
    	    	 formObj.from_dt.className ="input1";
    	    	 formObj.to_dt.className ="input1";
    		 }
    	 }
    	// formObj.f_inv.value = "";
    	// formObj.t_inv.value = "";
    	// formObj.tot_inv_cnt.value = "";
     }
     
     /**
      * User ID 클릭시 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     clickCust()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function clickUserid() {
    	 var formObj = document.form;

    	 if (formObj.chk_userid.checked) {
    		 formObj.if_user_id.value = formObj.user_id.value;
        	 if ((formObj.chk_cust.checked != true) & (formObj.chk_vvd.checked != true) & (formObj.chk_blno.checked != true) & (formObj.chk_all.checked != true)){
    	    	 formObj.from_dt.className ="input1";
    	    	 formObj.to_dt.className ="input1";
    		 }
    	 } else {
    		 formObj.if_user_id.value = "";
        	 if (formObj.chk_all.checked != true){
    	    	 formObj.from_dt.className ="input";
    	    	 formObj.to_dt.className ="input";
    		 }
    	 }
    	 //formObj.f_inv.value = "";
    	 //formObj.t_inv.value = "";
    	 //formObj.tot_inv_cnt.value = "";
    	 

     
     }
     
     /**
      * All 클릭시 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     clickCust()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function clickAll() {
    	 var formObj = document.form;
    	 /*if (formObj.chk_all.checked) {
    		 if(!ComShowCodeConfirm("INV00125")){
    			 formObj.chk_all.checked = false;
    			 return false;
    		 }
    	 }   */  	 
//    	 if (formObj.chk_all.checked) {
//    		 formObj.chk_vvd.checked = true;
//    		 formObj.chk_cust.checked = true;
//    		 formObj.chk_blno.checked = true;
//    		 formObj.chk_userid.checked = true;
//    	 } else {
//    		 formObj.chk_vvd.checked = false;
//    		 formObj.chk_cust.checked = false;
//    		 formObj.chk_blno.checked = false;
//    		 formObj.chk_userid.checked = false;
//    	 }
//    	 clickVvd();
//    	 clickCust();
//    	 clickBlno();
//    	 clickUserid();

//		 formObj.chk_vvd.checked = false;
//		 formObj.chk_cust.checked = false;
//		 formObj.chk_blno.checked = false;
//		 formObj.chk_userid.checked = false;
		 
    	 if (formObj.chk_all.checked) {
//			 formObj.chk_vvd.disabled = true;
//			 formObj.chk_cust.disabled = true;
//			 formObj.chk_blno.disabled = true;
//			 formObj.chk_userid.disabled = true;			 
			 formObj.from_dt.className ="input1";
			 formObj.to_dt.className ="input1";
		 } else {
//			 formObj.chk_vvd.disabled = false;
//			 formObj.chk_cust.disabled = false;
//			 formObj.chk_blno.disabled = false;
//			 formObj.chk_userid.disabled = false;
			 formObj.from_dt.className ="input";
			 formObj.to_dt.className ="input";
		 }
    	 
    	 clickVvd();
		 clickCust();
		 clickBlno();
		 clickUserid();
    	 
     }
     
     /**
      * 시트 컬러 변경 <br>
      * <br><b>Example :</b>
      * <pre>
      *     setColor(sheetObj, key);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {String} key color 구분자
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */       
     function setColor(sheetObj, key){
         for (var i=1; i<=sheetObj.RowCount; i++) {
         	 //for (var j=0; j<5; j++) {
         	 	 if (key == "E") {        			
         			 sheetObj.CellBackColor(i,1) = sheetObj.RgbColor(255,255,255); 
         		 } else {
         			 sheetObj.CellBackColor(i,1) = sheetObj.RgbColor(232,231,236);             			
         		 }    		        		
        	// }               	
         }            
     } 

     /**
      * 시트값 변경시 이벤트 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     sheet1_OnChange(sheetObj,Row,Col,Value);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row ibsheet 해당 row
      * @param {int} Col ibsheet 해당 col
      * @param {String} value ibsheet 해당 row, col의 값
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */   
     function sheet1_OnChange(sheetObj,Row,Col,Value){
    	 //blNoValChk(sheetObj,Row,Col,Value);
    	//form.f_inv.value = "";
		//form.t_inv.value = "";
		//form.tot_inv_cnt.value = "";
    	 if(Col==1){
    		 blNoDupChk(sheetObj,Value);
    	 }
         
     }
     
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 /*var rowCnt = sheetObj.RowCount
    	 if(rowCnt < 40){
    		 for(var i=0; i<40-rowCnt ; i++){
    			 sheetObj.DataInsert(-1);
			 }    		 
    	 }
    	 
    	 sheetObj.SelectCell(1,1);*/
     }

     /**
      * B/L 번호 중복 체크 <br>
      * <br><b>Example :</b>
      * <pre>
      *     blNoDupChk(sheetObj,Value);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {String} value ibsheet 해당 row, col의 값
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */     
     function blNoDupChk(sheetObj,Value){
         var cnt = 0;
         for (var i=1; i<=sheetObjects[0].RowCount; i++) {
         	 //for (var j=0; j<5; j++) {
        		 if (Value != "" && Value == sheetObj.CellValue(i, 1)) {        			
        			 cnt++;
        			 if (cnt > 1) {
        				 ComShowCodeMessage("INV00017");
        				 sheetObj.CellValue(i, 1) = "";
        				 return;
        			 }
        		 }        		        		
        	// }               	
         }
         
     }     

     /**
      * B/L 번호 체크 <br>
      * <br><b>Example :</b>
      * <pre>
      *     blNoValChk(sheetObj,Row,Col,Value);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row ibsheet 해당 row
      * @param {int} Col ibsheet 해당 col
      * @param {String} value ibsheet 해당 row, col의 값
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */  
     function blNoValChk(sheetObj,Row,Col,Value){

    	 if(Value != "") {             	 
         
	         var v_bl_no = Value;
	         var sum = 0;
	         var v1 = 0;
	                
	         //alert(v_bl_no.length); 
	         if(v_bl_no.length < 6) {
	        	 ComShowCodeMessage("INV00003");
	        	 sheetObj.CellValue(Row,Col) = "";
	        	 return false;
	         } else if(v_bl_no.length == 12){
	        	 
	        	 for(var i = 0; i < v_bl_no.length - 1; i++){
	        		 if(v_bl_no.charAt(i) >= 0 && v_bl_no.charAt(i) <= 9){
	        			 sum = sum + parseInt(v_bl_no.charAt(i));
	        		 } else {
	        			 if(v_bl_no.charAt(i).charCodeAt(0) >= "A".charCodeAt(0) && v_bl_no.charAt(i).charCodeAt(0) <= "Z".charCodeAt(0)){
	        				 v1 = v_bl_no.charAt(i).charCodeAt(0) - 64;
	        				 if(String(v1).length != 1){
	        					 v1 = parseInt(String(v1).charAt(0)) + parseInt(String(v1).charAt(1));   
	        				 }
	        				 sum = sum + v1;            				 
	        				 
	        			 } else {
	        				 ComShowCodeMessage("INV00002");
	        				 sheetObj.CellValue(Row,Col) = "";
	        	        	 return false;
	        			 }        			 
	        		 }        		 
	        	 } // for      
	        	 
		         var bl_ck = v_bl_no.charAt(11);
		         var bl_rtn = sum % 7; 
		         
		         if(parseInt(bl_ck) != bl_rtn && parseInt(bl_ck) != bl_rtn + 1 ){
		        	 ComShowCodeMessage("INV00001");
		        	 sheetObj.CellValue(Row,Col) = "";
		        	 return false;        	 
		         }	        	 
	        	 
	         }
	              
    	 }

     }     
     
     /**
      * 업무 자바스크립트 OnKeyPress 이벤트 Catch <br>
      * <br><b>Example :</b>
      * <pre>
      *    initControl()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function initControl() {
         // Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListenerFormat ('keypress', 'objKeypress', document.form);
         axon_event.addListenerFormat ('beforeactivate', 'objActivate', document.form);
         axon_event.addListenerForm ('beforedeactivate', 'objDeactivate', document.form);
         axon_event.addListenerForm ('keyup', 'objKeyup', document.form); 
         axon_event.addListener('keydown', 'ufRetrieveByEnterKey', 'form');

     }
     
     function ufRetrieveByEnterKey() {
         if (13!=event.keyCode) return;
         document.getElementById("btn_retrieve").fireEvent("onclick");
  	}
     /**
      * 업무 자바스크립트 OnKeyPress 이벤트 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *    objKeypress()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function objKeypress() {
     	switch(event.srcElement.dataformat){
     	    
     	    case "float":
     	        // 숫자+"."입력하기
     	        ComKeyOnlyNumber(event.srcElement, "."); break;
     	    break;
     	    case "int":
     	        // 숫자만 입력하기
     	        ComKeyOnlyNumber(event.srcElement); break;
     	    break;    
     	    case "engup":
     	    	//영문대문자만입력하기		    	        
                //ComKeyOnlyAlphabet('upper'); break;		
     	    	
     	    	switch(event.srcElement.name){

     	    	    case "vvd":	    	        	
     	    	    	//영문대문자+숫자 입력하기
     	    	    	ComKeyOnlyAlphabet('uppernum'); break;		
     	    	    case "port":	    	        	
    	    	    	//영문대문자+숫자 입력하기
    	    	    	ComKeyOnlyAlphabet('uppernum'); break;		   
     	    	    default:	
 		    	        //영문대문자만입력하기		    	        
 		                ComKeyOnlyAlphabet('upper'); break;		                

     	    	}
                
             break;              

     	     default:
     	        // 숫자만입력하기
     	        ComKeyOnlyNumber(event.srcElement);
     	     break;
     	}
     }  
     
    /**
     * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    objDeactivate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 정휘택
     * @version 2009.10.20
     */
    function objActivate() {
        // 마스크 구분자 없애기
    	ComClearSeparator (event.srcElement);
    }

    /**
     * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    objDeactivate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 정휘택
     * @version 2009.10.20
     */
    function objDeactivate(){
        switch(event.srcElement.name){
	        case "from_dt":
	        	// 입력Validation 확인 및 마스킹 처리
	            ComChkObjValid(event.srcElement);
	            //initInvNO();
	        	break;
	        	
	        case "to_dt":
	        	// 입력Validation 확인 및 마스킹 처리
	            ComChkObjValid(event.srcElement);
	            //initInvNO();
	        	break;
	        	
	        case "cust_seq":	        	
	            //자리수 채우기	            
	        	var formObject = document.form;	 
	        	var v_tmp = "";
	            if (formObject.cust_seq.value.length != 0 && formObject.cust_seq.value.length < 6) {
	        		//alert(formObject.cust_seq.value.length);
	            	for(i = 0; i < 6 - formObject.cust_seq.value.length; i++){
	            		v_tmp = v_tmp + "0";
	            	}
	        		document.form.cust_seq.value = v_tmp+document.form.cust_seq.value;
	        	}	        		            
	            
	            break;       
	            
	        default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(event.srcElement);
	        break;
        }
        
    } 
    
    
    /**
     * New 버튼 클릭시 필드 초기화  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initField()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 정휘택
     * @version 2009.10.20
     */ 
    function initField() {
    	    	
    	var formObj = document.form;
  	  
		with(formObj){
			chk_vvd.checked  = false;
			chk_cust.checked  = false;
			chk_blno.checked  = true;
			chk_userid.checked  = false;
			chk_all.checked  = false;
			chk_vvd.disabled = false;
			chk_cust.disabled = false;
			chk_blno.disabled = false;
			chk_userid.disabled = false;
			chk_all.disabled = false;
			bnd.value = "A";
			dt_option[0].checked  = true;
			from_dt.value = "";
			to_dt.value = ""; 
			from_dt.className ="input";
			to_dt.className ="input";
			vvd.value = "";
			scp.value = "";
			port.value = "";
			vvd.readOnly = true;
			scp.readOnly = true;
			port.readOnly = true;
			vvd.className ="input2";
			scp.className ="input2";
			port.className ="input2";			
			cust_cnt_cd.value = "";
			cust_seq.value = "";
			cust_nm.value = "";
			cust_rgst_no.value = "";
			cr_curr_cd.value = "";
			cr_amt.value = "";
			phn_no.value = "";
			fax_no.value = "";
			cntc_pson_nm.value = "";
			cust_cnt_cd.readOnly = true;
			cust_seq.readOnly = true;
			cust_cnt_cd.className ="input2";
			cust_seq.className ="input2";
			
			//f_inv.value = "";
			//t_inv.value = "";
			//tot_inv_cnt.value = "";
			//copy_cnt.value = "";
			ar_ofc_cd2.value = "";
			if_user_id.value = "";
		}

		sheetObjects[0].RemoveAll();
		for(var i=0; i<40; i++){
			sheetObjects[0].DataInsert(-1);
		}				
		sheetObjects[0].Editable = true;
		sheetObjects[0].SelectCell(1,0);
		
		ComBtnEnable("btn_paperissue");
		ComBtnEnable("btn_goto");
  	  
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		getCopyCnt();
		
 
    }
    
    
     /**
      * Invoice Issue (Email) 화면 오픈 <br>
      * <br><b>Example :</b>
      * <pre>
      *     openEmail()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */ 
 	 function openEmail() {
    	var ar_ofc_cd = document.form.ar_ofc_cd2.value;
    	if (ar_ofc_cd == "SZPSC" || ar_ofc_cd == "XMNSC" || ar_ofc_cd == "CANSO") {
    		ComOpenWindowCenter("FNS_INV_0037.do?issueGubn=I", "pop", 1010, 700);
    	} else {
    		ComOpenWindowCenter("FNS_INV_0034_02.do?issueGubn=I", "pop", 1010, 700);
    	}
     }

     /**
      * 시트 초기설정값, 헤더 정의 <br> 
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
      * <br><b>Example :</b>
      * <pre>
      *     initSheet(sheetObj, 0)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호 
      * @return 없음 
      * @author 정휘택
      * @version 2009.10.20     
      */  
     function initSheet(sheetObj,sheetNo) {

	  var cnt = 0;
	  var sheetID = sheetObj.id;
      switch(sheetID) {
		case "sheet1":      
             with (sheetObj) {
            	 WaitImageVisible = true;

                 // 높이 설정
                 style.height = 140;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msNone;

                 //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 1, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(12, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false)

                 var HeadTitle = "|B/L No.|S/A Date|Due Date|Bkg No.|Cust. Code|Fax No.|E-mail||||";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtCheckBox,    40,  daCenter,  true,	"chk"      );
                 InitDataProperty(0, cnt++ , dtData,     100,    daCenter,   false,   "bl_src_no",   		false,    "",      dfNone,	0,     true,   true,  12,  12);
				 InitDataProperty(0, cnt++ , dtData,   	 80,    daCenter,   false,   "sail_arr_dt",   		false,    "",      dfNone,	0,     false,   false);
                 InitDataProperty(0, cnt++ , dtData,   	 80,    daCenter,   false,   "due_dt",  		false,    "",      dfNone,	0,     false,   false);
                 InitDataProperty(0, cnt++ , dtData,   	 100,    daCenter,   false,   "bkg_no",  		false,    "",      dfNone,	0,     false,   false);
                 InitDataProperty(0, cnt++ , dtData,   	 100,    daCenter,   false,   "cust_code",  		false,    "",      dfNone,	0,     false,   false);
                 InitDataProperty(0, cnt++ , dtData,   	 150,    daCenter,   false,   "cust_fax_no",  		false,    "",      dfNone,	0,     true,   false);
                 InitDataProperty(0, cnt++ , dtData,   	 150,    daLeft,   false,   "cust_eml",  		false,    "",      dfNone,	0,     true,   false);
                 InitDataProperty(0, cnt++ , dtHidden,   	 0,    daLeft,   false,   "cust_nm",  		false,    "",      dfNone,	0,     true,   false);
                 InitDataProperty(0, cnt++ , dtHidden,   	 0,    daLeft,   false,   "cr_amt",  		false,    "",      dfNone,	0,     true,   false);
                 InitDataProperty(0, cnt++ , dtHidden,   	 0,    daLeft,   false,   "ttl_amt",  		false,    "",      dfNone,	0,     true,   false);
                 InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    daCenter,	true,	"ibflag");
                 
				 InitDataValid(0, 1, vtEngUpOther, "0123456789");
				 
            }
            break;                  

         }
     }

     /**
      * Sheet관련 프로세스 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 html form object
      * @param {int} sAction 필수 프로세스 플래그 상수
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

	      	case IBSEARCH: // 화면 로딩시 AR Office & Number of copy invoice 조회
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0139GS.do", FormQueryString(formObj));
				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
				var arrStr = sStr.split("|");
				
				MakeComboObject(formObj.ar_ofc_cd, arrStr);
				
				var arrStr2 = arrStr[1].split("^");
				var ar_ofc_cd = arrStr2[3];
		        //formObj.copy_cnt.value = ComGetEtcData(sXml,"copy_cnt");		        
		        
		        formObj.ar_ofc_cd.text = ar_ofc_cd;		  
		        
		        var sStr = ComGetEtcData(sXml,"inv_prn_dvc_nm");
        		formObj.print_nm.value = sStr;
		        break;    
		        
	    	case IBSEARCH_ASYNC02: // Retrieve
	    		
	    		var bl_nos = "";
	    		
	    		if (formObj.chk_blno.checked) {
				    for (var i = 0; i < sheetObj.RowCount; i++) {
			    		if (sheetObj.CellValue(i+1, 1) != ""){
			    			bl_nos = bl_nos + "'"+ sheetObj.CellValue(i+1, 1) + "',";
			    		}
				    } 			    
				    if (bl_nos != ""){
				    	bl_nos = bl_nos + "''";
				    } 
	    		}
			    formObj.bl_nos.value = bl_nos;
				    
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("FNS_INV_0139GS.do", FormQueryString(formObj));
		        break;    
		        
	      	case IBSEARCH_ASYNC10: // Number of copy invoice 조회
		      	var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	         	formObj.ar_ofc_cd2.value = arrStr2[1];
	         	formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0139GS.do", FormQueryString(formObj));
	         	
				//formObj.copy_cnt.value = ComGetEtcData(sXml,"copy_cnt");
	            
	         	break;
	         	
			case IBSEARCH_ASYNC20: // customer name 조회
				if (formObj.cust_cnt_cd.value != "" && formObj.cust_seq.value != ""){
					
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
					formObj.ar_ofc_cd2.value = arrStr2[1];
				
					formObj.f_cmd.value = SEARCH03;
				
					var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));	
					
					var cust_nm = ComGetEtcData(sXml,"cust_eng_nm"); 
					
					if (cust_nm != undefined) {
						formObj.cust_nm.value = cust_nm;
					} else {
						formObj.cust_nm.value = "";
					}		
						        	
					var cust_rgst_no = ComGetEtcData(sXml,"cust_rgst_no");    
					if (cust_rgst_no != undefined) {
						formObj.cust_rgst_no.value = cust_rgst_no;
					} else {
						formObj.cust_rgst_no.value = "";
					}
					
					var cr_curr_cd = ComGetEtcData(sXml,"cr_curr_cd");    
					if (cr_curr_cd != undefined) {
						formObj.cr_curr_cd.value = cr_curr_cd;
					} else {
						formObj.cr_curr_cd.value = "";
					}
					
					var cr_amt = ComGetEtcData(sXml,"cr_amt");    
					if (cr_amt != undefined) {
						formObj.cr_amt.value = cr_amt;
					} else {
						formObj.cr_amt.value = "";
					}

					var cntc_pson_nm = ComGetEtcData(sXml,"cntc_pson_nm");    
					if (cntc_pson_nm != undefined) {
						formObj.cntc_pson_nm.value = cntc_pson_nm;
					} else {
						formObj.cntc_pson_nm.value = "";
					}
					
					var bnd = formObj.bnd.value;
					
					if (bnd == "I") {
						
						var phn_no = ComGetEtcData(sXml,"ib_phn_no");    
						if (phn_no != undefined) {
							formObj.phn_no.value = phn_no;
						} else {
							formObj.phn_no.value = "";
						}

						var fax_no = ComGetEtcData(sXml,"ib_fax_no");    
						if (fax_no != undefined) {
							formObj.fax_no.value = fax_no;
						} else {
							formObj.fax_no.value = "";
						}						
						
					} else {
						
						var phn_no = ComGetEtcData(sXml,"ob_phn_no");    
						if (phn_no != undefined) {
							formObj.phn_no.value = phn_no;
						} else {
							formObj.phn_no.value = "";
						}

						var fax_no = ComGetEtcData(sXml,"ob_fax_no");    
						if (fax_no != undefined) {
							formObj.fax_no.value = fax_no;
						} else {
							formObj.fax_no.value = "";
						}			
						
					}					
			
			    }
	        	
	        	break;	         	

 			case IBSAVE:        //저장
                //if(validateForm(sheetObj,formObj,sAction))
                //alert (" Save .. ");
                break;


			case IBINSERT:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					var sendFlg = formObj.send_flag.value;
					
					formObj.f_cmd.value = MULTI;
					
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
					formObj.ar_ofc_cd2.value = arrStr2[1];
					
		            
					var sParam = sheetObj.GetSaveString(false, true, 0);
					var sParam1 = FormQueryString(formObj);
					
					if (sParam == "") {
						return;
					}
					else {
						sParam = ComSetPrifix(sParam, "sheet1_") + "&" + sParam1 ;
					}
					
					//alert(sParam);
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0139GS.do", sParam );
					
					if (sXml.indexOf("ERROR") < 1){
						
						var sndNum = ComGetEtcData(sXml,"snd_num");
						
						ComShowCodeMessage("INV00065", sndNum);
					}
					else {
						ComShowCodeMessage("INV00053");
					}
				}
			break;
 			
 			case IBSEARCH_ASYNC01:      // issued bl_no 조회
 			
			    var bl_nos = "";
			    for (var i = 0; i < sheetObj.RowCount; i++) {
			    	//for (var j = 0; j < 5; j++) {
			    		if (sheetObj.CellValue(i+1, 1) != ""){
			    			bl_nos = bl_nos + "'"+ sheetObj.CellValue(i+1, 1) + "',";
			    		}
			    	//}
			    } 			    
			    if (bl_nos != ""){
			    	bl_nos = bl_nos + "''";
			    } 
			    formObj.bl_nos.value = bl_nos;
			    
			    var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	         	
			    formObj.svr_id.value = arrStr2[7]; 	
	         	formObj.ots_smry_cd.value = arrStr2[13]; 	
	         	formObj.inv_dup_flg.value = arrStr2[14]; 
	         	formObj.inv_mlt_bl_iss_flg.value = arrStr2[15]; 
	         	
	         	formObj.f_cmd.value = SEARCH05;
				
	         	var sXml	= sheetObj.GetSearchXml("FNS_INV_0139GS.do", FormQueryString(formObj)); 
	         	var r_bl_nos= ComGetEtcData(sXml,"bl_nos");
	         	return r_bl_nos;
	         	
			break;
         }
         
     }
      
    

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     validateForm(sheetObj, document.form, IBSEARCH)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 html form object
      * @param {int} sAction 필수 프로세스 플래그 상수
      * @return boolean
      * @author 정휘택
      * @version 2009.10.20
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){    
        	         	 
        	 if (!(formObj.chk_vvd.checked || formObj.chk_cust.checked || formObj.chk_blno.checked || formObj.chk_userid.checked || formObj.chk_all.checked)) {
    			 ComShowCodeMessage("INV00004");
    			 formObj.chk_blno.checked = true;
    			 clickBlno();
    			 return false;

        	 }
        	 
        	 if (formObj.chk_all.checked) {
        		 if (formObj.from_dt.value == "") {
        			 ComShowCodeMessage("INV00004");
        			 formObj.from_dt.focus();
        			 return false;
        		 }
        		 if (formObj.to_dt.value == "") {
        			 ComShowCodeMessage("INV00004");
        			 formObj.to_dt.focus();
        			 return false;
        		 }
        	 }
        	 
        	 if (formObj.chk_vvd.checked) {
        		 if (formObj.vvd.value == "") {
        			 ComShowCodeMessage("INV00004");
        			 formObj.vvd.focus();
        			 return false;
        		 }
        	 }
        	 
        	 if (formObj.chk_cust.checked) {
        		 if (formObj.cust_cnt_cd.value == "") {
        			 ComShowCodeMessage("INV00004");
        			 formObj.cust_cnt_cd.focus();
        			 return false;
        		 }
        		 
        		 if (formObj.cust_seq.value == "") {
        			 ComShowCodeMessage("INV00004");
        			 formObj.cust_seq.focus();
        			 return false;
        		 }
        	 }
        	 
        	 if (formObj.chk_blno.checked) {
        		 
  			    var cnt = 0;
 			    for (var i = 0; i < sheetObj.RowCount; i++) {
 			    	//for (var j = 0; j < 5; j++) {
 			    		if(sheetObj.CellValue(i+1, 1) != "") {

 			    			cnt++;
     			    		
 			    		}
 			    	//}
 			    }
 			    
        		if (cnt == 0) {
        			ComShowCodeMessage("INV00004");        			
        			sheetObj.SelectCell(1,0);
        			return false;
        		} 

        	 }        	 

         }

         return true;
     }
     
     
      /**
 	  * ISSUE 중복 여부 check 함수 <br>
 	  * <br><b>Example :</b>
 	  * @param	sheetObj
 	  * @return
 	  * @author 권 민
 	  * @version 2012.02.01
 	  */
      function checkIssuedBlNo(sheetObj){
 		  var bl_nos	= doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
 		  return bl_nos;
      }
            
      
      
      

      /**
       * RD Preview(FNS_INV_0034_02_prev) 화면 오픈 <br>
       * <br><b>Example :</b>
       * <pre>
       *     invPreview(sheetObj, formObj)
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {form} formObj 필수 html form object
       * @return 없음
       * @author 정휘택
       * @version 2009.10.20
       */
      function invPreview(sheetObj, formObj) {

      	var sRow = sheetObj.FindCheckedRow(0);
      	if (sRow == "") {
      		ComShowCodeMessage("INV00025");
      		return false;
      	}  

      	var rdFiles = "FNS_INV_0139.mrd|";
      	
      	var rdParam = "";

      	var chkStampObj = document.getElementsByName('stamp_type');
			var chkStamp = "";
			
        for(var i = 0; i < chkStampObj.length; i++) {
           if(chkStampObj[i].checked) {
         	 chkStamp = chkStampObj[i].value;
                break;
           }
        }
         
		
		var bkg_nos = ""; 						
	
		for (var i = 0; i < sheetObjects[0].RowCount; i++) {
	    	if(sheetObjects[0].CellValue(i+1, 0) == "1"){
	    		if (sheetObjects[0].CellValue(i+1, 4) != ""){
	    			bkg_nos = bkg_nos + "'"+ sheetObjects[0].CellValue(i+1, 4) + "',";
	    		}
	    	}
	    } 
		
		if (0 < bkg_nos.indexOf(",")){
		bkg_nos = bkg_nos.substring(0, bkg_nos.length - 1);
		}
	    
		formObj.bkg_nos.value = bkg_nos; 					   				
		
	   if (bkg_nos != "") {
			
			var arrStr2 = form.ar_ofc_cd.Code.split("^");
			form.ar_ofc_cd2.value = arrStr2[1];	 			
     	
	   	
		   rdParam = "/rv form_bkgNo[( " + bkg_nos + " )] ";
			rdParam += " form_type[2] ";
			rdParam += " form_dataOnly[N] ";
			rdParam += " form_manifest[N] ";
			rdParam += " form_usrId["+form.user_id.value+"] ";
			rdParam += " form_hiddeData[N] ";
			rdParam += " form_level[(1)] ";
			rdParam += " form_remark[] ";
			rdParam += " form_Cntr[1] ";
			rdParam += " form_mainOnly[N]";
			rdParam += " form_CorrNo[]";
			rdParam += " form_his_cntr[BKG_CONTAINER]";
			rdParam += " form_his_bkg[BKG_BOOKING] ";
			rdParam += " form_his_mkd[BKG_BL_MK_DESC]";
			rdParam += " form_his_xpt[BKG_XPT_IMP_LIC]";
			rdParam += " form_his_bl[BKG_BL_DOC] ";
			rdParam += " form_arofccd[" + form.ar_ofc_cd2.value + "] ";
			rdParam += " form_stamp_type[" + chkStamp + "] ";
			rdParam += " /rp [] ";
			rdParam += " /riprnmargin /rpypos [0]" +"|";
			
		
	   }
      //alert(rdParam);

      		formObj.com_mrdPath.value = rdFiles ;
      		formObj.com_mrdArguments.value = rdParam;


      	ComOpenWindowCenter("FNS_INV_0034_02_prev.do?view_flag=I", "pop3", 800, 700);

      }
      
      
      /**
  	 * Send/Fax 발송 function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * 
  	 * </pre>
  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
  	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
  	 * @return 없음
       * @see #
       * @author 박정진
       * @version 2009.05.04
  	 */ 
  	function sendFaxEml(sheetObj, sendFlg) {
  		
  		var formObj = document.form; 
  		formObj.send_flag.value=sendFlg;
  		
  		var sRow = sheetObj.FindCheckedRow(0);
      	if (sRow == "") {
      		ComShowCodeMessage("INV00025");
      		return false;
      	}  
      	
      	var arrRow = sRow.split("|");
      	
      	var bkg_nos = ""; 						
		
					
      	
      	for (var idx = 0; idx < arrRow.length - 1; idx++){
      		
      		bkg_nos = bkg_nos + "'"+ sheetObj.CellValue(arrRow[idx], 4) + "',";
      		
    		if(sendFlg=='F'){
	    		if (sheetObj.CellValue(arrRow[idx], "cust_fax_no") == ""){
	    			ComShowCodeMessage("INV00104");
	    			sheetObj.SelectCell(arrRow[idx],"cust_fax_no");
	    			return false;
	    		}
    		}else if (sendFlg=='M'){
    			if (sheetObj.CellValue(arrRow[idx], "cust_eml") == ""){
    				ComShowCodeMessage("INV00104");
    				sheetObj.SelectCell(arrRow[idx], "cust_eml");
    				return false;
    			}
    		}
	    } 
      	
      	if (0 < bkg_nos.indexOf(",")){
			bkg_nos = bkg_nos.substring(0, bkg_nos.length - 1);
		}
		    
      	formObj.bkg_nos.value = bkg_nos; 
  		
  		doActionIBSheet(sheetObj,formObj,IBINSERT);
  	}
  	
  	
    function ComFindText(sheetObj, colName, colValue){
        //함수 인자 유효성 확인
        if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT")
          return alert("ComFindText 함수의 sheetObj 인자는 IBSheet가 아닙니다.");

        var idxs = new Array();
        for(yn=sheetObj.HeaderRows ;yn<=sheetObj.LastRow ;yn++ ) {
          if(sheetObj.RowStatus(yn) != 'D' && sheetObj.CellValue(yn, colName) == colValue){
            idxs.push(''+yn);
          }
        }
        return idxs;
      }
  	      
 /* 개발자 작업  끝 */