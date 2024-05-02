/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0034_01.js
*@FileTitle : AccountReceivableInvoiceMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.17 정휘택
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
* 2011.08.04 오요한 [CHM-201111930] Invoice Issue 프로그램 개선
* 2011.11.11 권   민 [CHM-201113617] [INV]SVAT Reg. No for CMBSC SVAT Reg. NO 입력/저장 기능 개발 INVOICE에 SEQUENC NO가 출력되지 않는 문제 원인을
* 2012.02.01 권   민 [CHM-201215781-01] [INV] ALPS INV 중복 발행 시 알림창 pop up 
* 2012.03.12 권   민 [CHM-201216480] SAOSC의 인보이스 이슈 기능 개발 요청
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
     * fns_inv_0034_01 : fns_inv_0034_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     fns_inv_0034_01()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 정휘택
     * @version 2009.10.20
     */
    function fns_inv_0034_01() {
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

 				case "btn_paperissue": 	
                    
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
 									formObject.email_flag.value = "N";
 			 						
 				 					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
 								}else{
 									return;
 								}
 							}else{
 								if(ComShowCodeConfirm("INV00154", bl_nos)){
 									formObject.email_flag.value = "N";
 			 						
 				 					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
 								}else{
 									return;
 								}
 							}
 						}else{
 							formObject.email_flag.value = "N";
 	 						
 		 					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
 						}
 						//ComBtnDisable("btn_goto");
 
 						//////////////////////////////////////////////////////////// 2012.02.01 주석처리 한 부분 start
 						//formObject.email_flag.value = "N";
 						
	 					//doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
	 					/////////////////////////////////////////////////////////// 2012.02.01 주석처리 한 부분 end
//	 					var state = formObject.state.value;  
//	 					var r_invs = formObject.inv_nos.value;  
//	 					
//	 					if (state == "S" && r_invs != "") {	 						
//
//							var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
//							formObject.ar_ofc_cd2.value = arrStr2[1];	                    
//		                    var v_f_inv = formObject.f_inv.value;
//		            		var v_t_inv = formObject.t_inv.value;
//		                	var arrStr = r_invs.split("|");
//		                	var v_copy_cnt = formObject.copy_cnt.value;  
//		                	
//		                	rdObjects[0].SetAppendReport(1);
//							for(var i=0; i<arrStr.length-1; i++){
//		
//								rdOpen(rdObjects[0], arrStr[i], 15, formObject.user_nm.value, formObject.ar_ofc_cd2.value, "ORIGINAL", "", "", "N");
//								for(var j=0; j<v_copy_cnt; j++) {  						
//									rdOpen(rdObjects[0], arrStr[i], 15, formObject.user_nm.value, formObject.ar_ofc_cd2.value, "COPY", "", "", "N");
//								}
//								
//							}  
//							rdObjects[0].CMPrint (); //인쇄 시작
//							rdObjects[0].SetAppendReport(0);   	
//                        }
					 					
					} else {
						return;
					}
 					break;

 				case "btn_new":
 					initField();
 					setRevType();
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
 					
 					if(formObject.f_inv.value != "" & formObject.t_inv.value != ""){
 						var ar_ofc_cd = formObject.ar_ofc_cd2.value;
 				    	if (ar_ofc_cd == "SZPSC" || ar_ofc_cd == "XMNSC" || ar_ofc_cd == "CANSO") { 
 				    		ComOpenWindowCenter("FNS_INV_0037.do?issueGubn=I", "pop", 1010, 750);
 				    	} else {  
 				    		ComOpenWindowCenter("FNS_INV_0034_02.do?issueGubn=I", "pop", 1010, 750);
 				    	}
 					}else{
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
 					}	
 					
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
   	 function rdOpen(Rdviewer, inv_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, paperYn){
    	 
        var formObject = document.form; 
		var rdFile = "";		
 		
		if (ofc_cd == "HAMSC" || ofc_cd == "HAMRU") {
			rdFile = "FNS_INV_0503.mrd";
		} else if (ofc_cd == "GOASC") {
			rdFile = "FNS_INV_0504.mrd";
		} else if (ofc_cd == "ANRSO") {
			rdFile = "FNS_INV_0505.mrd";
		} else if (ofc_cd == "BUDSC") {
			rdFile = "FNS_INV_0506.mrd";
		} else if (ofc_cd == "RTMSC") {
			rdFile = "FNS_INV_0507.mrd";
		} else if (ofc_cd == "GDYSC") {
			rdFile = "FNS_INV_0508.mrd";
		} else if (ofc_cd == "PRGSC") {
			rdFile = "FNS_INV_0509.mrd";
		} else if (ofc_cd == "VLCSC") {
			rdFile = "FNS_INV_0510.mrd";
		} else if (ofc_cd == "SINSC") {
			rdFile = "FNS_INV_0511.mrd";
		} else if (ofc_cd == "PKGSC") {
			rdFile = "FNS_INV_0512.mrd";
		} else if (ofc_cd == "CMBSC") {
			rdFile = "FNS_INV_0513.mrd";
		} else if (ofc_cd == "BOMSC") {
			rdFile = "FNS_INV_0548.mrd";	//2017.07.31 인도 GST 세법 변경 관련 보완
		} else if (ofc_cd == "SYDSC") {
			if(document.form.exrate_type[0].checked == true){
				rdFile = "FNS_INV_0515.mrd";			
			} else {
				rdFile = "FNS_INV_0545.mrd";			
			}
		} else if (ofc_cd == "SHASC" || ofc_cd == "SHARC") {
			rdFile = "FNS_INV_0516.mrd";
		} else if (ofc_cd == "HKGSC") {
			rdFile = "FNS_INV_0518.mrd";
		} else if (ofc_cd == "FXTSC" || ofc_cd == "LONBC1") {
			rdFile = "FNS_INV_0521.mrd";
		} else if (ofc_cd == "LEHSC") {
			rdFile = "FNS_INV_0522.mrd";
//		} else if (ofc_cd == "SGNSC") {
//			rdFile = "FNS_INV_0520.mrd";
		} else if (ofc_cd == "JKTSC") {
			rdFile = "FNS_INV_0527.mrd";
		} else if (ofc_cd == "DXBSC") {
			rdFile = "FNS_INV_0530.mrd";
		} else if (ofc_cd == "BKKSC") {
			rdFile = "FNS_INV_0540.mrd";
		} else if (ofc_cd == "DACSC") {
			rdFile = "FNS_INV_0541.mrd";
		} else if (ofc_cd == "SAOSC") {
			rdFile = "FNS_INV_0542.mrd";
		} 
		/*else if (ofc_cd == "MNLBA") {
			rdFile = "FNS_INV_0512.mrd";
		}*/
		
		var issue_type = "";		
		if(ofc_cd == "DXBSC"){
			if(document.form.issue_type[0].checked == true){
				issue_type = "P";
			}else{
				issue_type = "F";
			}
		}
		
		if (ofc_cd == "BOMSC" || ofc_cd == "SYDSC" || ofc_cd == "FXTSC" || ofc_cd == "LEHSC") {
			ofc_cd = document.form.login_ofc_cd.value;
		}
		//2011.11.11 요청처리
		//ofc_cd = document.form.login_ofc_cd.value;
		rdParam = "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+user_nm+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num ["+line_num+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_paper_yn ["+paperYn+"] frm1_issue_type["+issue_type+"] frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";

		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";	
		
 		// 열고자 하는 RD 파일을 지정한다.		
		Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
    
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
    	 sheetObj.SelectCell(1,0,false);
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
    	 
    	 var ar_ofc_cd = document.form.ar_ofc_cd.text;
    	 var dodBlNos = document.form.dodBlNos.value;
    	 var dodOfcCd = document.form.dodOfcCd.value;
    	 if (ar_ofc_cd == "SZPSC" || ar_ofc_cd == "XMNSC" || ar_ofc_cd == "CANSO") {
    		 //document.all.btnPaper.style.display = "none";
    		 ComBtnDisable("btn_paperissue"); 
    	 }  
    	 
    	 if(dodBlNos !=""){
    		 document.form.ar_ofc_cd.text = dodOfcCd;
    		 arrDodBlnoSearch();
    		
 
    	 }
    	 
    	 //2017.07.20 인도 GST 세법 변경 관련 보완
    	 if(document.form.ar_ofc_cd.text == "BOMSC") {
    		 document.all.ind_opt.style.display = "";
    	 } else {
    		 document.all.ind_opt.style.display = "none";
    	 }
     }
      
    
 	/**
 	 * Invoice Search (DOD에서 BL NO 넘어온 경우) <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *     openFnsInv0106()
 	 * </pre>
 	 * @param rowArray
 	 * @return 없음
 	 * @author 정휘택
 	 * @version 2009.10.20
 	 */ 
 	function arrDodBlnoSearch() {
 		var sheetObj = sheetObjects[0];
 		var arrDodBlno = document.form.dodBlNos.value.split(",");
  		var cnt = 0;
 		for (var i=1; i<=sheetObj.RowCount; i++) {
 			for (var j=0; j<5; j++) {
 				sheetObj.CellValue(i, j) = arrDodBlno[cnt++];
 			}
 		}
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
     	setRevType();
     	
     	//2017.07.20 인도 GST 세법 변경 관련 보완
	   	if(document.form.ar_ofc_cd.text == "BOMSC") {
	   		document.all.ind_opt.style.display = "";
	   	} else {
	   		document.all.ind_opt.style.display = "none";
	   	}
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
			initInvNO();
			var v_cust_cnt_cd = formObject.cust_cnt_cd.value;
 	    	if (v_cust_cnt_cd.length == 2) {
 	    		formObject.cust_seq.focus(); 	    		
 	    	}
		break;			
		case "from_dt":
			initInvNO();
			var v_from_dt = formObject.from_dt.value
 	    	if (v_from_dt.length == 8) {
 	    		formObject.to_dt.focus();
 	    		
 	    	}
		break;
		case "to_dt":
			initInvNO();			
		break;
		case "bnd":
			initInvNO();			
		break;
		case "ar_ofc_cd":
			initInvNO();			
		break;
		case "vvd":
			initInvNO();			
		break;
		case "scp":
			initInvNO();			
		break;
		case "port":
			initInvNO();			
		break;
		case "cust_cnt_cd":
			initInvNO();			
		break;
		case "cust_seq":
			initInvNO();			
		break;
		case "rev_type":
			initInvNO();			
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
    	 formObj.f_inv.value = "";
    	 formObj.t_inv.value = "";
    	 formObj.tot_inv_cnt.value = "";
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
    	 formObj.f_inv.value = "";
    	 formObj.t_inv.value = "";
    	 formObj.tot_inv_cnt.value = "";
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
			 
			 formObj.bnd.disabled = true;
			 formObj.bnd.selectedIndex = 0;
			 
	    	 formObj.from_dt.className ="input";
	    	 formObj.to_dt.className ="input";
    		 
    	 } else {
    		 	 
    		 sheetObjects[0].RemoveAll();    		 
			 for(var i=0; i<40; i++){
				 sheetObjects[0].DataInsert(-1);
			 }
			 setColor(sheetObj, "D");
			 sheetObj.Editable = false;    
			 sheetObjects[0].SelectCell(1,0);
			 
			 formObj.bnd.disabled = false;
			 ComSetFocus(formObj.chk_blno);
			 sheetObjects[0].SelectCell(0,0,false);
			 
        	 if ((formObj.chk_userid.checked == true) & (formObj.chk_cust.checked != true) & (formObj.chk_vvd.checked != true) & 
        			 (formObj.chk_blno.checked != true) & (formObj.chk_all.checked != true)){
    	    	 formObj.from_dt.className ="input1";
    	    	 formObj.to_dt.className ="input1";
    		 }
    	 }
    	 formObj.f_inv.value = "";
    	 formObj.t_inv.value = "";
    	 formObj.tot_inv_cnt.value = "";
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
    	 formObj.f_inv.value = "";
    	 formObj.t_inv.value = "";
    	 formObj.tot_inv_cnt.value = "";
    	 

     
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
    	 if (formObj.chk_all.checked) {
    		 if(!ComShowCodeConfirm("INV00125")){
    			 formObj.chk_all.checked = false;
    			 return false;
    		 }
    	 }     	 
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

		 formObj.chk_vvd.checked = false;
		 formObj.chk_cust.checked = false;
		 formObj.chk_blno.checked = false;
		 formObj.chk_userid.checked = false;
		 
    	 if (formObj.chk_all.checked) {
			 formObj.chk_vvd.disabled = true;
			 formObj.chk_cust.disabled = true;
			 formObj.chk_blno.disabled = true;
			 formObj.chk_userid.disabled = true;			 
			 formObj.from_dt.className ="input1";
			 formObj.to_dt.className ="input1";
		 } else {
			 formObj.chk_vvd.disabled = false;
			 formObj.chk_cust.disabled = false;
			 formObj.chk_blno.disabled = false;
			 formObj.chk_userid.disabled = false;
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
         	 for (var j=0; j<5; j++) {
         	 	 if (key == "E") {        			
         			 sheetObj.CellBackColor(i,j) = sheetObj.RgbColor(255,255,255); 
         		 } else {
         			 sheetObj.CellBackColor(i,j) = sheetObj.RgbColor(232,231,236);             			
         		 }    		        		
        	 }               	
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
    	form.f_inv.value = "";
		form.t_inv.value = "";
		form.tot_inv_cnt.value = "";
    	 blNoDupChk(sheetObj,Value);
         
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
         	 for (var j=0; j<5; j++) {
        		 if (Value != "" && Value == sheetObj.CellValue(i, j)) {        			
        			 cnt++;
        			 if (cnt > 1) {
        				 ComShowCodeMessage("INV00017");
        				 sheetObj.CellValue(i, j) = "";
        				 return;
        			 }
        		 }        		        		
        	 }               	
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
	            initInvNO();
	        	break;
	        	
	        case "to_dt":
	        	// 입력Validation 확인 및 마스킹 처리
	            ComChkObjValid(event.srcElement);
	            initInvNO();
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
			
			f_inv.value = "";
			t_inv.value = "";
			tot_inv_cnt.value = "";
			copy_cnt.value = "";
			ar_ofc_cd2.value = "";
			if_user_id.value = "";
			
			//2017.07.20 인도 GST 세법 변경 관련 보완
			ind_iss_tp_cd[0].checked = true;
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
     * inv_dup_flg : Y이면 rev_type 활성화, 아니면 비활성화 <br>
     * <br><b>Example :</b>
     * <pre>
     *     openEmail()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 정휘택
     * @version 2009.10.20
     */ 
    function setRevType(){
    	var formObj = document.form;
    	var inv_dup_flg = formObj.inv_dup_flg.value;
    	if(inv_dup_flg == "Y"){
    		formObj.rev_type.disabled = false;
			formObj.rev_type.selectedIndex = 0;
    	}else{
    		formObj.rev_type.disabled = true;
			formObj.rev_type.selectedIndex = 0;
    	}
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
            	 WaitImageVisible = false;

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
                 InitColumnInfo(5, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false, false);

                 var HeadTitle = "1|2|3|4|5";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtData,     160,    daCenter,   false,   "1",   		false,    "",      dfNone,	0,     true,   true,  12,  12);
				 InitDataProperty(0, cnt++ , dtData,   	 160,    daCenter,   false,   "2",   		false,    "",      dfNone,	0,     true,   true,  12,  12);
                 InitDataProperty(0, cnt++ , dtData,   	 160,    daCenter,   false,   "3",  		false,    "",      dfNone,	0,     true,   true,  12,  12);
				 InitDataProperty(0, cnt++ , dtData,   	 160,    daCenter,   false,   "4",   		false,    "",      dfNone,	0,     true,   true,  12,  12);
				 InitDataProperty(0, cnt++ , dtData,   	 160,    daCenter,   false,   "5",   		false,    "",      dfNone,	0,     true,   true,  12,  12);

				 InitDataValid(0, 0, vtEngUpOther, "0123456789");
				 InitDataValid(0, 1, vtEngUpOther, "0123456789");
				 InitDataValid(0, 2, vtEngUpOther, "0123456789");
				 InitDataValid(0, 3, vtEngUpOther, "0123456789");
				 InitDataValid(0, 4, vtEngUpOther, "0123456789");
				 
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
				var sXml = sheetObj.GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(formObj));
				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
				var arrStr = sStr.split("|");
				
				MakeComboObject(formObj.ar_ofc_cd, arrStr);
				
				var arrStr2 = arrStr[1].split("^");
				var ar_ofc_cd = arrStr2[3];
		        formObj.copy_cnt.value = ComGetEtcData(sXml,"copy_cnt");		        
		        
		        formObj.ar_ofc_cd.text = ar_ofc_cd;		  
		        
		        var sStr = ComGetEtcData(sXml,"inv_prn_dvc_nm");
        		formObj.print_nm.value = sStr;
		        break;    
		        
	      	case IBSEARCH_ASYNC10: // Number of copy invoice 조회
		      	var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	         	formObj.ar_ofc_cd2.value = arrStr2[1];
	         	formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(formObj));
	         	
				formObj.copy_cnt.value = ComGetEtcData(sXml,"copy_cnt");
	            
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

 			case IBINSERT:      //입력

// 			    var bl_nos = "";
// 			    for (var i = 0; i < 6; i++) {
// 			    	for (var j = 0; j < 5; j++) {
// 			    		if (sheetObj.CellValue(i+1, j) != ""){
// 			    			bl_nos = bl_nos + "'"+ sheetObj.CellValue(i+1, j) + "',";
// 			    		}
// 			    	}
// 			    } 			    
// 			    if (bl_nos != ""){
// 			    	bl_nos = bl_nos + "''";
// 			    } 
// 			    formObj.bl_nos.value = bl_nos;
// 			    
// 			    var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
//	         	formObj.svr_id.value = arrStr2[7]; 	
//	         	formObj.ots_smry_cd.value = arrStr2[13]; 	
//	         	formObj.inv_dup_flg.value = arrStr2[14]; 
//	         	formObj.inv_mlt_bl_iss_flg.value = arrStr2[15]; 	         	
//
//				formObj.f_cmd.value = MULTI;
//				var sXml = sheetObj.GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(formObj)); 
//				sheetObj.LoadSearchXml(sXml); 
//									
//				var sStr = ComGetEtcData(sXml,"inv_nos");				
//				formObj.inv_nos.value = sStr;
//				
//				var arrStr = sStr.split("|");
//				
//				if (arrStr.length > 1) {
//			        formObj.f_inv.value = arrStr[0];	
//			        formObj.t_inv.value = arrStr[arrStr.length - 2];
//			        formObj.tot_inv_cnt.value = arrStr.length - 1;
//					
//				} 			
//				
//				var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
//				formObj.state.value = state;
 			
 				
 				
			    var bl_nos = "";
			    for (var i = 0; i < sheetObjects[0].RowCount; i++) {
			    	for (var j = 0; j < 5; j++) {
			    		if (sheetObj.CellValue(i+1, j) != ""){
			    			bl_nos = bl_nos + "'"+ sheetObj.CellValue(i+1, j) + "',";
			    		}
			    	}
			    } 			    
			    if (bl_nos != ""){
			    	bl_nos = bl_nos + "''";
			    } 
			    formObj.bl_nos.value = bl_nos;
			    //alert(formObj.bl_nos.value);
			    
			    var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	         	formObj.svr_id.value = arrStr2[7]; 	
	         	formObj.ots_smry_cd.value = arrStr2[13]; 	
	         	formObj.inv_dup_flg.value = arrStr2[14]; 
	         	formObj.inv_mlt_bl_iss_flg.value = arrStr2[15]; 
	         	var ar_ofc_cd = formObj.ar_ofc_cd2.value;

	         	if(ar_ofc_cd =="SINSC"){
		         	formObj.f_cmd.value = SEARCH06;
			      	var sXml	= sheetObj.GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(formObj)); 
			      	
//			      	var sStr = ComGetEtcData(sXml,"threeRdCheck");	
			      	var blNos = ComGetEtcData(sXml,"blNos");

	                if (blNos != "") {
	                	
//	                	if(blNos.length > 5){
	                		ComShowCodeMessage("INV00176", blNos);
							return false;
//	                	}
					}
	         	}
//	         	formObj.f_cmd.value = SEARCH04;
//				var sXml = sheetObj.GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(formObj)); 
//				var sStr = ComGetEtcData(sXml,"bl_nos");				
//                //alert(sStr);
//				
//				if (sStr != "") {
//					ComShowCodeMessage("INV00096", sStr);
//					if (formObj.chk_vvd.checked || formObj.chk_cust.checked ) {
//						return;
//					}
//				}
				
				//formObj.f_cmd.value = MULTI02;
	         	formObj.f_cmd.value = MULTI;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(formObj)); 
				var arrXml = sXml.split("|$$|");
				sheetObj.LoadSearchXml(arrXml[0]);

				var backEndJobKey = ComGetEtcData(arrXml[0], "BackEndJobKey")
					if(backEndJobKey.length > 0) {
						formObj.backendjob_key.value = backEndJobKey;
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						sheetObj.RequestTimeOut = 10000;
						timer = setInterval(getBackEndJobStatus, 3000);
						//ComOpenWait(false);
					}
								
		     break;
 			
 			case IBSEARCH_ASYNC01:      // issued bl_no 조회
 			
			    var bl_nos = "";
			    for (var i = 0; i < sheetObjects[0].RowCount; i++) {
			    	for (var j = 0; j < 5; j++) {
			    		if (sheetObj.CellValue(i+1, j) != ""){
			    			bl_nos = bl_nos + "'"+ sheetObj.CellValue(i+1, j) + "',";
			    		}
			    	}
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
				
	         	var sXml	= sheetObj.GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(formObj)); 
	         	var r_bl_nos= ComGetEtcData(sXml,"bl_nos");
	         	return r_bl_nos;
	         	
			break;
		  }
     }
      
     /**
      * BackEndJob 관련 Status='3' 이 될때까지 확인한다 <br>
      * <br><b>Example :</b>
      * <pre>
      *     getBackEndJobStatus();
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */      
     function getBackEndJobStatus() {
  		form.f_cmd.value = SEARCH02;
  		var sXml = sheetObjects[1].GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(form));
  		var arrXml = sXml.split("|$$|");
  		var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg")
  		if(jobState == "3") {
  			clearInterval(timer);
  			getBackEndJobLoadFile();
  			ComOpenWait(false);

  	    } else if(jobState == "4") {
  	    	clearInterval(timer);
  	    	// BackEndJob을 실패 하였습니다.
  	    	ComShowCodeMessage("INV00089");
  	    	ComOpenWait(false);

  	    } else if(jobState == "5") {
  	    	clearInterval(timer);
  	    	// 이미 BackEndJob 결과 파일을 읽었습니다.
  	    	ComShowCodeMessage("INV00090");
  	    	ComOpenWait(false);
  	    	
  	    }
     }
     
     /**
      * BackEndJob의 결과가 완료되면 결과를 조회한다 <br>
      * <br><b>Example :</b>
      * <pre>
      *     getBackEndJobLoadFile();
      * </pre>
      * @param 없음
      * @return 없음
      * @author 정휘택
      * @version 2009.10.20
      */
     function getBackEndJobLoadFile() {
      	form.f_cmd.value = SEARCH03;
      	var sXml = sheetObjects[1].GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(form));
		
      	var errStr = ComGetEtcData(sXml,"Exception");
		if (errStr != null && errStr !="") {
			ComShowCodeMessage("INV00074");
		} else {
	      	var arrXml = sXml.split("|$$|");
	      	if(arrXml.length > 0) {
	      		//sheetObjects[0].LoadSearchXml(arrXml[0]);
	      		form.backendjob_key.value = "";
	      		
				var sStr = ComGetEtcData(sXml,"inv_nos");

				var sStr2 = sStr.split("&");
				var arrStr = sStr2[0].split("|");
				
				if (arrStr.length > 1) {
					form.f_inv.value = arrStr[0];	
					form.t_inv.value = arrStr[arrStr.length - 2];
					form.tot_inv_cnt.value = ComAddComma2(arrStr.length - 1, "#,###");
				} 			
				
				var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				var r_invs = arrStr[0];
				
				if (r_invs == "") {
					ComShowCodeMessage("INV00097");
					form.f_inv.value = "";
					form.t_inv.value = "";
					form.tot_inv_cnt.value = "";
					return false;
				}
			
				if (state == "S" && r_invs != "") {	 						
	                //alert(r_invs);
					var arrStr2 = form.ar_ofc_cd.Code.split("^");
					form.ar_ofc_cd2.value = arrStr2[1];	                    
	                var v_f_inv = form.f_inv.value;
	        		var v_t_inv = form.t_inv.value;
	            	var arrStr3 = sStr2[0].split("|");
	            	//alert(arrStr3);
	            	var v_copy_cnt = form.copy_cnt.value;  
	            	
	            	if (form.email_flag.value == "N") {
		            	rdObjects[0].SetAppendReport(0);
		            	
						for(var i=0; i<arrStr3.length -1; i++){
							//alert(arrStr3[i]);
							rdOpen(rdObjects[0], arrStr3[i], 15, form.user_nm.value, form.ar_ofc_cd2.value, "ORIGINAL", "", "", "N", "Y");
							rdObjects[0].SetAppendReport(1);
							for(var j=0; j<v_copy_cnt; j++) {  						
								rdOpen(rdObjects[0], arrStr3[i], 15, form.user_nm.value, form.ar_ofc_cd2.value, "COPY", "", "", "N", "Y");
							}
							
						}  					
						
						rdObjects[0].SetAppendReport(0); 
						//프린트세팅
				    	 var print_nm = form.print_nm.value;
				    	 if(print_nm != ""){
				    		 rdObjects[0].SetPrintInfo (print_nm, 1, 1, 4);
				    	 }
						rdObjects[0].CMPrint(); //인쇄 시작
						
	            	} else {
	            		openEmail();
	            	}
	            } 
			}
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
 			    	for (var j = 0; j < 5; j++) {
 			    		if(sheetObj.CellValue(i+1, j) != "") {

 			    			cnt++;
     			    		
 			    		}
 			    	}
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
      * DXBSC 일 경우, FNS_INV_0110 팝업화면을 호출 후, ISSUE OK 되면 호출되는 함수 <br>
      * <br><b>Example :</b>
      * @param
      * @return
      * @author 정휘택
      * @version 2009.10.20
      */
     function getFnsInv0110(){
    	 var formObject = document.form;
    	 formObject.email_flag.value = "Y";
			
		doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
		 
		var state = formObject.state.value;  
		var r_invs = formObject.inv_nos.value;  
		var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
		formObject.ar_ofc_cd2.value = arrStr2[1];	
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
            
 /* 개발자 작업  끝 */