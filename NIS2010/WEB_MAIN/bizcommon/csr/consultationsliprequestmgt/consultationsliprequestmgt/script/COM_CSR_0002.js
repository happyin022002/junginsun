/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : com_csr_0002.js
*@FileTitle : CSR Creation(Detail)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.13
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2009.07.02 함대성
* 1.0 Creation
*----------------------------------------------------------
* History
* 2013.02.13 [CHM-201322900]                   CSR Approval Step 결재선 변경 기능 추가
* 2014.07.10 김영신 [CHM-201430993] Files 버튼 추가 및 활성화 기능 
* 2014.09.29 김영신 [CHM-201432136] Files 버튼 제거, Approval Step 사용안함
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
     * @extends
     * @class com_csr_0002 : com_csr_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function com_csr_0002() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/
    // 공통전역변수
    var tabObjects = new Array();
    var beforetab = 1;

    var rdObjects = new Array();
    var rdCnt = 0;
    var queryStr = "";

	var sheetCnt = 0;
	var Mincount = 0;
	var comboCnt = 0;

    var sheetObjects = new Array();
    var comboObjects = new Array();

	var approvalFlg = "";
	var asaNoCurrCodeArr = "";
	var asaNoCurrCode = "";

	var edi_inv_yn = false;

    //New button click시에 IBCombo들의 change이벤트를 타지 못하도록 하기 위함
    var gNew = false;
    var gCurRow = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	var time_out = false;
	function chkTimeOut(){
	   time_out = false;
	}

    function setAttenCC(){
    	 var formObj = document.form;
	   	//formObj.atten.value = at1;
   }
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];
    	/*******************************************************/
    	var formObject = document.form;
    	var rdObject = rdObjects[0];

    	try {
    		var cal = new ComCalendar();
    		var srcName = window.event.srcElement.getAttribute("name");
    			
    		switch (srcName) {
            /*
    		case "apro_route_btn":
            	with(document.form)
            	{
            	    var v_ofc_cd = "";
            	    var v_sub_sys_cd = inv_sub_sys_cd.value;
            	    var v_apro_step  = document.form.apro_step.value;
    				if(document.form.ofc_tp[0].checked){
    					v_ofc_cd = document.form.cost_ofc_cd.value;
    				}else if (document.form.ofc_tp[1].checked){
    					v_ofc_cd = document.form.inv_ofc_cd.value;
    				}
                    var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&apro_step="+encodeURIComponent(v_apro_step)+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";
                    
                    //"?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&classId=COM_ENS_0T1"+"&target_obj_nm=apro_step";
      				ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 915, 522, '', 'none', true);
    	            break;
            	}
                break;
				*/
    		case "btn_retrieve":
    			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    			break;

    		case "btn_main":
    			var inv_sub_sys_cd  = document.form.inv_sub_sys_cd.value;
    			var detailUrl 		= "";
    			if(inv_sub_sys_cd == 'TLL') inv_sub_sys_cd = 'MNR';
    			
    			if(inv_sub_sys_cd == 'MNR'){
    				detailUrl = "EES_MNR_0301.do?INV_SUB_SYS_CD=MNR&MENU=Y&pgmNo=EES_MNR_0301";
    			}else if(inv_sub_sys_cd == 'CHS'){
    				detailUrl = "EES_CGM_1148.do?INV_SUB_SYS_CD=CHS&MENU=Y&pgmNo=EES_CGM_1148";
    			}else if(inv_sub_sys_cd == 'LSE'){
    				detailUrl = "EES_LSE_0041.do?INV_SUB_SYS_CD=LSE&MENU=Y&pgmNo=EES_LSE_0041";
    			}else if(inv_sub_sys_cd == 'PSO'){
    				detailUrl = "VOP_PSO_1001.do?INV_SUB_SYS_CD=PSO&MENU=Y&pgmNo=VOP_PSO_1001";
    			}else if(inv_sub_sys_cd == 'MGS'){
    				detailUrl = "EES_CGM_2208.do?INV_SUB_SYS_CD=MGS&MENU=Y&pgmNo=EES_CGM_2208";
    			}else if(inv_sub_sys_cd == 'CNI'){
    				detailUrl = "EES_CGM_2208.do?INV_SUB_SYS_CD=CNI&MENU=Y&pgmNo=CPS_CNI_0046";
    			}
    			location.href = detailUrl;
    			break;

    		case "btn_save":
    			doActionIBSheet(sheetObject1, formObject, IBSAVE);
    		break;

    		case "btn_downExcel":
    			sheetObject1.Down2Excel();
    		break;

			case "btn_evidence":
				//ASA No. mode로 넘어온 경우 반드시 ASA No.를 선택해야 button시 동작하도록 합니다.
				if (formObject.asanogb.value!=undefined && formObject.asanogb.value!=null && formObject.asanogb.value=="ASA"){
					if (comboObjects[0].Code==undefined || comboObjects[0].Code==null || comboObjects[0].Code==''){
						ComShowCodeMessage( "COM12113", " ASA No."  );
						return false;
					}
				}
				if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){
						ComShowCodeMessage( "COM12114", " row"  );
						return false;
				}
				
				//param 모듈셋팅
				var inv_sub_sys_cd  = formObject.inv_sub_sys_cd.value;
				
				//if(document.form.eviInputFlg.value!="Y"){
				var leftpos = (screen.width - 1040)/2;    if(leftpos<0) leftpos=0;
			    var toppos  = (screen.height- 700)/2;   if(toppos<0)  toppos=0;
				if(approvalFlg==""){
						if(formObject.evi_gb.value=="1"){	//세금계산서
							//ComOpenWindow("/hanjin/COM_CSR_0004.do?", "window", "toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=yes,alwaysRaised,dependent,titlebar=no,width=790,height=620,left="+leftpos+",top="+toppos);
							window.showModalDialog("/hanjin/COM_CSR_0004.do?inv_sub_sys_cd="+inv_sub_sys_cd, window, "dialogWidth:790px; dialogHeight:540px; help:no; status:no; resizable:no; scroll:no");
						}else if(formObject.evi_gb.value=="2"){	//계산서
							window.showModalDialog("/hanjin/COM_CSR_0005.do?inv_sub_sys_cd="+inv_sub_sys_cd, window, "dialogWidth:790px; dialogHeight:500px; help:no; status:no; resizable:no; scroll:no");
							//ComOpenWindow("/hanjin/COM_CSR_0005.do", "window", "toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=yes,alwaysRaised,dependent,titlebar=no,width=790,height=590,left="+leftpos+",top="+toppos);
						}else if(formObject.evi_gb.value=="3"){
								//showErrMessage(getMsg('CSR25019'));
						}else{
								showErrMessage(getMsg('CSR25002'));
						}
				}
				//}else{
				//		showErrMessage("이미 저장된 증빙 입력항목사항이 있습니다. 새로운 CSR No를 발행받아서 입력하세요.");
				//}
				break;

			case "btn_preview":
					//ASA No. mode로 넘어온 경우 반드시 ASA No.를 선택해야 button시 동작하도록 합니다.
					if (formObject.asanogb.value!=undefined && formObject.asanogb.value!=null && formObject.asanogb.value=="ASA"){
						if (formObject.asaListFlg.value == "N"){
							showErrMessage(getMsg('CSR25035'));
							return false;
						}
						if (comboObjects[0].Code==undefined || comboObjects[0].Code==null || comboObjects[0].Code==''){
							showErrMessage(getMsg('CSR40025','ASA No.'));
							return false;
						}
					}
					/*
					if (formObject.iss_dt.value!=null && formObject.iss_dt.value.trim()!='' &&
						formObject.payment_due_dt.value!=null && formObject.payment_due_dt.value.trim()!='' &&
						!isValIssDueDt()){
						showErrMessage('Issue date이 payment due date보다 작거나 같아야 합니다.'); //showErrMessage('Issue date must be earlier than payment due date.');
						return false;
					}
					*/

					if(approvalFlg==""){
							if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){
									showErrMessage(getMsg('CSR25001'));
									return false;
							}

							/*
							if(formObject.apro_step.value==""){
									showErrMessage(getMsg('CSR25020'));
									return false;
							}*/
							
							//Invoice 삭제 여부 체크
							if(!isValidApproval(sheetObject)){
								return;
							}
							
							//if(formObject.asanogb.value=="A/P" && formObject.cnt_cd.value=="KR"){
							if(cnt_cd == "KR"){
									if(formObject.evi_gb.value == ""){
											showErrMessage(getMsg('CSR25002'));
											return false;
									}else{
											if(formObject.evi_gb.value!="3"){
													if(document.form.eviInputFlg.value == "" && document.form.s_eviInputFlg.value == ""){
															showErrMessage(getMsg('CSR25003'));
															return false;
													}
											}
									}
							}
							var csr_amt=0;
							for(var i=0;i<sheetObject.RowCount;i++){
									if(sheetObject.CellValue(i+1,1)==1){
											csr_amt = parseFloat(sheetObject.CellValue(i+1,"inv_ttl_amt")*100)+parseFloat(csr_amt);
									}
							}
							formObject.csr_amt.value=roundXL((csr_amt/100), 2);
							
							//날짜셋팅
							dateUnMask();
							
							sheetObject1.RemoveAll();
							sheetObject2.RemoveAll();
							doActionIBSheet1(sheetObject2,formObject,IBSEARCH);
					}
					break;

			//XML 방식 RD
			case "btn_print":
				//ASA No. mode로 넘어온 경우 반드시 ASA No.를 선택해야 button시 동작하도록 합니다.
				if (formObject.asanogb.value!=undefined && formObject.asanogb.value!=null && formObject.asanogb.value=="ASA"){
					if (comboObjects[0].Code==undefined || comboObjects[0].Code==null || comboObjects[0].Code==''){
						showErrMessage(getMsg('CSR40025','ASA No.'));
						return false;
					}
				}
				var fromObj = new Array();
				var rdObj  	= new Array();
				var parmObj = new Array();
				fromObj[0] = formObject;                            // RD 로 보내기 위해 배열로담는다
				rdObj[0] = sheetObjects[0];     					// Coincidence 에 sheet를 RD로 보내기 위해 배열로 담는다

				parmObj[0] = "1";
				parmObj[1] = "";
				parmObj[2] = "N";
				var realYn = true;
			    if (realYn){
			    	parmObj[3] = RD_path+"bizcommon/csr/consultationsliprequestmgt/consultationsliprequestmgt/report/COM_CSR_00121.mrd";
			    }else{
			        parmObj[3] = "http://localhost:7001/hanjin/bizcommon/csr/consultationsliprequestmgt/consultationsliprequestmgt/report/COM_CSR_00121.mrd";     // RD 화면
			    }

				parmObj[4] = rdObj;
				parmObj[5] = fromObj;

				//rdObjModaless("bizcommon/csr/consultationsliprequestmgt/consultationsliprequestmgt/jsp/rdReport.jsp" , parmObj , 1000 ,700);
			break;
			/*
			//쿼리 방식 RD
			case "btn_print":
				//rdObjects[0] = sheetObjects[0];
	            initRdConfig(rdObjects[0]);
	            rdOpen(rdObjects[0], document.form);
            break;
			*/
			case "btn_approvalrequest":
					/*
					 * Invoice Office 기준으로 createApInvHDR, createApInvDTRB 의 로컬타임변경한다 
					 */
					if (time_out){
						return;
					}
					//ASA No. mode로 넘어온 경우 반드시 ASA No.를 선택해야 button시 동작하도록 합니다.
					
					if (formObject.asanogb.value!=undefined && formObject.asanogb.value!=null && formObject.asanogb.value=="ASA"){
						if (formObject.asaListFlg.value == "N"){
							showErrMessage(getMsg('CSR25035'));
							return false;
						}
						if (comboObjects[0].Code==undefined || comboObjects[0].Code==null || comboObjects[0].Code==''){
							showErrMessage(getMsg('CSR22018','ASA No.'));
							return false;
						}
						if(formObject.curr_cd.value != comboObjects[0].Code.substring(11,14)){
							showErrMessage(getMsg('CSR25032'));
						}

					}
					
					if(approvalFlg==""){
							/*
							if(formObject.apro_step.value==""){
									showErrMessage(getMsg('CSR25020'));
									return false;
							}
							*/

							if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){
									showErrMessage(getMsg('CSR25001'));
									return false;
							}

							if(cnt_cd=="KR"){
									if(formObject.evi_gb.value == ""){
											showErrMessage(getMsg('CSR25002'));
											return false;
									}else{
										if(formObject.evi_gb.value!="3"){
												if(document.form.eviInputFlg.value == "Y" || document.form.s_eviInputFlg.value == "Y"){
												}else{
														showErrMessage(getMsg('CSR25003'));
														return false;
												}
										}
									}
							}

							//zu_openRunning(true);

							var csr_amt=0;
							for(var i=0;i<sheetObject.RowCount;i++){
									if(sheetObject.CellValue(i+1,1)==1){
											csr_amt = parseFloat(sheetObject.CellValue(i+1,"inv_ttl_amt")*100)+parseFloat(csr_amt);
									}
							}

							formObject.csr_amt.value=roundXL((csr_amt/100), 2);

							eviData();
							
							//날짜셋팅
							dateUnMask();
							
							//인보이스 삭제여부 체크
							if(isValidApproval(sheetObject)){
								doActionIBSheet1(sheetObject, formObject, IBSAVE);
							}
							
							time_out = true;
							window.setTimeout('chkTimeOut()',3000);

							//zu_openRunning(false);
					}
					/*
					//체크박스활성화 
					var rows = sheetObjects[0].Rows;
					for(var i=0; i < rows; i++ ){
						if(i!=sheetObjects[0].SelectRow){
							sheetObjects[0].CellEditable(i,"chk") = true;
						}
					} */
				break;
				
			/*
			case "btn_files": //files button 추가 
		        
				FilesPopup();

				break;	*/
				
    		} // end switch
    	} catch (e) {
    		if (e == "[object Error]") {
    			ComShowCodeMessage('CSR90002');
    		} else {
    			ComShowMessage(e);
    		}
    		time_out = true;
    	}
    }
    		
    /**
     * Action 버튼의 활성/비활성을 설정한다. <br>
     * @param  invStatus String
     * @param  statusCd String
     * @return 없음
     * @author 김창식
     * @version 2009.10.12
     */	
     /*
    function doActionBtnEnable (invStatus){
    	 
    	// Invoice Confirm 버튼 활성/비활성
    	if(invStatus == 'S'){
    		ComBtnEnable("btn_approvalrequest");
    	} else {
    		ComBtnDisable("btn_approvalrequest");
    	}
    }*/
    		
    function dateUnMask(){
    	var formObject = document.form;
        var iss_dt =  ComGetUnMaskedValue( formObject.max_iss_dt.value, "ymdhms", "-");
        var rcv_dt =  ComGetUnMaskedValue( formObject.max_rcv_dt.value, "ymdhms", "-");
        var payment_due_dt =  ComGetUnMaskedValue( formObject.payment_due_dt.value, "ymdhms", "-");
        var evi_inv_dt = ComGetUnMaskedValue( formObject.evi_inv_dt.value, "ymdhms", "-");
        
        formObject.max_iss_dt.value = iss_dt;
        formObject.max_rcv_dt.value = rcv_dt;
        formObject.payment_due_dt.value = payment_due_dt;
        formObject.evi_inv_dt.value = evi_inv_dt;
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
    	sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
     	for (i = 0; i < sheetObjects.length; i++) {

     		//khlee-시작 환경 설정 함수 이름 변경
     		ComConfigSheet(sheetObjects[i]);

     		initSheet(sheetObjects[i], i + 1);
     		//khlee-마지막 환경 설정 함수 추가
     		ComEndConfigSheet(sheetObjects[i]);
     	}

     	//combo 초기화
     	for(var k=0;k<comboObjects.length;k++){
     	    initCombo(comboObjects[k], k+1);
     	}

     	var formObj = document.form;
// 2012.05.14 조회조건 추가를 위해 list 조회이후로 변경함.     	
//    	//asa_no 콤보 
//    	doActionIBCombo(sheetObjects[0] , document.form ,IBSEARCH , comboObjects[0], SEARCHLIST01 ,"asa_no");

    	//cnt_cd 국가 코드체크
    	var asanogb = formObj.asanogb.value;
    	var currCd  = formObj.curr_cd.value;
    	if(asanogb=="A/P" && cnt_cd=="KR" && currCd != "KRW"){
  		  document.all.item("srLayer")[0].style.display = "none";
  		  document.all.item("srLayer")[1].style.display = "inline";
  		  document.all.item("srLayer")[2].style.display = "none";
  		  document.all.item("btLayer")[1].style.display = "none";
  		  document.all.item("btLayer")[0].style.display = "none";
  		  document.all.item("btLayer")[2].style.display = "inline";
  		  
		  document.form.evi_gb1.options[2].selected = true ;
		  document.form.evi_gb1.disabled = true;
  		}else if(asanogb=="A/P" && cnt_cd=="KR" && currCd == "KRW"){
		  document.all.item("srLayer")[0].style.display = "none";
		  document.all.item("srLayer")[1].style.display = "inline";
		  document.all.item("srLayer")[2].style.display = "none";
		  document.all.item("btLayer")[1].style.display = "inline";
		  document.all.item("btLayer")[0].style.display = "none";
		  document.all.item("btLayer")[2].style.display = "none";
		  
		  document.form.evi_gb1.options[0].selected = true ;
		  document.form.evi_gb1.disabled = false;
		}else if(asanogb=="ASA" && cnt_cd!="KR"){
		  document.all.item("srLayer")[0].style.display = "inline";
		  document.all.item("srLayer")[1].style.display = "none";
		  document.all.item("srLayer")[2].style.display = "none";
		  document.all.item("btLayer")[1].style.display = "none";
		  document.all.item("btLayer")[0].style.display = "inline";
		  document.all.item("btLayer")[2].style.display = "none";
		}else if(asanogb=="A/P" && cnt_cd!="KR"){
		  document.all.item("srLayer")[0].style.display = "none";
		  document.all.item("srLayer")[1].style.display = "none";
		  document.all.item("srLayer")[2].style.display = "none";
		  document.all.item("btLayer")[1].style.display = "none";
		  document.all.item("btLayer")[0].style.display = "inline";
		  document.all.item("btLayer")[2].style.display = "none";
		} 
		 
    	//document.all.item("srLayer")[0].style.display = "inline";
		disableObject(formObj.cost_ofc_cd);
		//disableObject(document.form.inv_cfm_dt); 
		disableObject(formObj.vndr_seq);
		disableObject(formObj.vndr_seq_name);
		disableObject(formObj.cnt_inv);
		disableObject(formObj.curr_cd);         
		disableObject(formObj.total_amt);
		disableObject(formObj.max_iss_dt);
		disableObject(formObj.max_rcv_dt);
		disableObject(formObj.gen_pay_term_desc);
		//disableObject(formObj.apro_step);	
		disableObject(formObj.csr_no);	
		
		var inv_sub_sys_cd  = formObj.inv_sub_sys_cd.value;
		var gen_pay_term_cd = formObj.gen_pay_term_cd.value;
		//05전표이면서 O60이면 PAMENT DUE DT 수정되도록 -> 05전표는 CSR('MNR', 'TLL', 'LSE', 'PSO', 'CHS', 'MGS', 'CNI') 모듈인경우에만 해당됨
		if(inv_sub_sys_cd=="MNR" || inv_sub_sys_cd=="TLL" || inv_sub_sys_cd=="LSE" || inv_sub_sys_cd=="PSO" || inv_sub_sys_cd=="CHS" || inv_sub_sys_cd=="MGS" || inv_sub_sys_cd=="CNI"){
			if (gen_pay_term_cd!=null && gen_pay_term_cd.trim()!='' && (gen_pay_term_cd.substring(0,1)=='O' || gen_pay_term_cd.substring(0,1)=='I')){
				if(gen_pay_term_cd.substring(0,3)!='O60'){
					disableObject(formObj.payment_due_dt);
				}
			}
		}
		
		initControl();
		//리스트 조회
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	
    	//asa_no 콤보.  2012.05.14 조회조건 추가를 위해 list 조회이후로 변경함.    
    	doActionIBCombo(sheetObjects[0] , document.form ,IBSEARCH , comboObjects[0], SEARCHLIST01 ,"asa_no");
    	
    	/**
    	 * 2013.02.13 조인영 [CHM-201322900]
    	 * Cost Office 와 Log-in Office 가 동일할 경우 Radio 버튼 비활성화
    	 */
    	/*
    	if(document.form.cost_ofc_cd.value ==document.form.inv_ofc_cd.value) {
    		ComEnableObject(document.form.ofc_tp[0], false);
    		ComEnableObject(document.form.ofc_tp[1], false);
    	}else{
    		ComEnableObject(document.form.ofc_tp[0], true);
    		ComEnableObject(document.form.ofc_tp[1], true);
    	}*/
    	
    	//csr_no이 없는 초기 화면은 file 버튼 비활성화
    	//if(formObj.csr_no.value.length == 0 || formObj.csr_no.value == "") {
    	//	ComBtnDisable("btn_files");
    	//}
    	
     }
 
     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
  	function initControl() {
  	    //Axon 이벤트 처리1. 이벤트catch
  		var formObject = document.form;
  	    //axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
  		//axon_event.addListenerFormat('change',	 'obj_change',	 formObject); //- 변경될때.

    	//axon_event.addListener  ('keypress', 'payment_due_dt_keypress' , 'payment_due_dt');
        //axon_event.addListener  ('change'  , 'payment_due_dt_change'   , 'payment_due_dt');
    }

      /**
	   * ASA No를 변경하면, ASA TO_DATE를 Effect Date로 세팅한다.
	   */
	function asa_no_OnChange(){
		var formObj = document.form;
		var asaNoStr = comboObjects[0].Code;
		formObj.asa_no_s.value =  asaNoStr.substr(0,10);
	}

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var pnt = 0;
        var currCd = document.form.curr_cd.value;
        if(currCd == "KRW" || currCd == "JPY" ){
        	pnt = 0;
        }else{
        	pnt = 2;
        }

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 320;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(21, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "Seq.||Invoice No.|Payment Term|Currency|Net Amount|Tax Amount|W.H.T|Total Amount|Issue Date|Receive Date|Confirm Date" ;
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    	[ROW, COL,  DATATYPE,   			WIDTH, DATAALIGN, 		COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC,   DATAFORMAT,        POINTCOUNT,     UPDATEEDIT,     INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

					InitDataProperty(0, cnt++ , dtSeq,	 				30,		daCenter,		false,    "",				false,			"",			dfNone,					0,			false,			false,   false,     false,  false	);
					InitDataProperty(0, cnt++ , dtCheckBox, 			50,		daCenter,		false,    "chk",			false,			"",			dfNone,					0,			true,			true,    false,     false,  false	);
					InitDataProperty(0, cnt++ , dtData,	 				100,	daLeft,			false,    "inv_no",			false,			"",			dfNone,					0,			false,			false,   false,     false,  true	);
					InitDataProperty(0, cnt++ , dtData,	 				90,		daCenter,		false,    "vndr_term_nm",	false,			"",			dfNone,					0,			false,			false,   false,     false,  true	);
					InitDataProperty(0, cnt++ , dtData,	 				60,		daCenter,		false,    "inv_curr_cd",	false,			"",			dfNone,					0,			false,			false,   false,     false,  false	);
					
				if(pnt == 0){	//KRW, TWD, JPY
					InitDataProperty(0, cnt++ , dtData,	 				100,	daRight,		false,    "inv_net_amt",	false,			"",		dfInteger,				0,			false,			false,   false,     false,  true	);
					InitDataProperty(0, cnt++ , dtData,	 				100,	daRight,		false,    "inv_vat_amt",	false,			"",		dfInteger,				0,			false,			false,   false,     false,  true	);
					InitDataProperty(0, cnt++ , dtData,	 				100,	daRight,		false,    "whld_tax_amt",	false,			"",		dfInteger,				0,			false,			false,   false,     false,  true	);
					InitDataProperty(0, cnt++ , dtData,	 				100,	daRight,		false,    "inv_ttl_amt",	false,			"",		dfInteger,				0,			false,			false,   false,     false,  true	);
				}else{	//USD
					InitDataProperty(0, cnt++ , dtData,	 				100,	daRight,		false,    "inv_net_amt",	false,			"",		dfNullFloat,			2,			false,			false,   false,     false,  true	);
					InitDataProperty(0, cnt++ , dtData,	 				100,	daRight,		false,    "inv_vat_amt",	false,			"",		dfNullFloat,			2,			false,			false,   false,     false,  true	);
					InitDataProperty(0, cnt++ , dtData,	 				100,	daRight,		false,    "whld_tax_amt",	false,			"",		dfNullFloat,			2,			false,			false,   false,     false,  true	);
					InitDataProperty(0, cnt++ , dtData,	 				100,	daRight,		false,    "inv_ttl_amt",	false,			"",		dfNullFloat,			2,			false,			false,   false,     false,  true	);
				}
					
					InitDataProperty(0, cnt++ , dtData,	 				80,		daRight,		false,    "iss_dt",			false,			"",			dfNone,					0,			false,			false,   false,     false,  true	);
					InitDataProperty(0, cnt++ , dtData,	 				80,		daRight,		false,    "rcv_dt",			false,			"",			dfNone,					0,			false,			false,   false,     false,  true	);
					InitDataProperty(0, cnt++ , dtData,	 				80,		daRight,		false,    "inv_cfm_dt",		false,			"",			dfNone,					0,			false,			false,   false,     false,  true	);
					
					InitDataProperty(0, cnt++ , dtHidden,	 			80,		daCenter,		false,    "pso_trns_slp_ctnt",	false,		"",			dfNone,					0,			false,			false,   false,     false,  true	);
					InitDataProperty(0, cnt++ , dtHidden,	 			80,		daCenter,		false,    "pay_due_dt",		false,			"",			dfNone,					0,			false,			false,   false,     false,  true	);
					
					//Hidden
					InitDataProperty(0, cnt++ , dtHidden,	 			40,		daRight,		false,    "ttl_lss_div_cd",	false,			"",			dfNone,					0,			false,			false,   false,     false,  false	);
					
					InitDataProperty(0, cnt++ , dtHidden,	 			200,	daLeft,			false,    "inv_rgst_no",	false,			"",			dfNone,					0,			false,			false,   false,     false,  false	);
					InitDataProperty(0, cnt++ , dtHidden,	 			1,		daRight,		false,    "inv_ofc_cd",		false,			"",			dfNone,					0,			false,			false,   false,     false,  false	);
					InitDataProperty(0, cnt++ , dtHidden,	 			1,		daRight,		false,    "vndr_seq",		false,			"",			dfNone,					0,			false,			false,   false,     false,  false	);
					InitDataProperty(0, cnt++ , dtHidden,	 			1,		daRight,		false,    "asa_no",			false,			"",			dfNone,					0,			false,			false,   false,     false,  false	);
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 		1,		daRight,		false,    "ibflag",			false,			"",			dfNone,					0,			false,			false,   false,     false,  false	);
					InitDataProperty(0, cnt++ , dtHidden,	 			1,		daRight,		false,    "edi_flg",		false,			"",			dfNone,					0,			false,			false,   false,     false,  false	);

               }
                break;

           case 2:      //sheet1 init
           with (sheetObj) {
               // 높이 설정
               style.height = GetSheetHeight(13);
               //전체 너비 설정
               SheetWidth = mainTable.clientWidth;

               //Host정보 설정[필수][HostIp, Port, PagePath]
               if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

               //전체Merge 종류 [선택, Default msNone]
               MergeSheet = msHeaderOnly;

              //전체Edit 허용 여부 [선택, Default false]
               Editable = true;

               //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
               InitRowInfo( 1, 1, 9, 100);

               //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
               InitColumnInfo(23, 1, 0, true);

               // 해더에서 처리할 수 있는 각종 기능을 설정한다
               InitHeadMode(true, true, false, true, false,false);

               var HeadTitle = "csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt|pay_curr_cd|pay_amt|title|chk_addr1|chk_addr2|chk_addr3|chk_cty_nm|chk_ste_cd|chk_zip_cd|chk_cnt_cd" ;

               //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
               InitHeadRow(0, HeadTitle, true);

               //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
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
				InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_amt",					false,			"",			dfNone,				0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_curr_cd",	false,			"",			dfNone,				0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_amt",			false,			"",			dfNone,				0,			false,			false	);

				//InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "apro_step",				false,			"",			dfNone,				0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_title",				false,			"",			dfNone,				0,			false,			false	);
                // CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)
				InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_addr1",				false,			"",			dfNone,				0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_addr2",				false,			"",			dfNone,				0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_addr3",				false,			"",			dfNone,				0,			false,			false	);

				InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_cty_nm",				false,			"",			dfNone,				0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_ste_cd",				false,			"",			dfNone,				0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_zip_cd",				false,			"",			dfNone,				0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_cnt_cd",				false,			"",			dfNone,				0,			false,			false	);

          }
           break;

           case 3:      //sheet1 init
           with (sheetObj) {
               // 높이 설정
               style.height = GetSheetHeight(13);
               //전체 너비 설정
               SheetWidth = mainTable.clientWidth;

               //Host정보 설정[필수][HostIp, Port, PagePath]
               if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

               //전체Merge 종류 [선택, Default msNone]
               MergeSheet = msHeaderOnly;

              //전체Edit 허용 여부 [선택, Default false]
               Editable = true;

               //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
               InitRowInfo( 1, 1, 9, 100);

               //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
               InitColumnInfo(10, 1, 0, true);

               // 해더에서 처리할 수 있는 각종 기능을 설정한다
               InitHeadMode(true, true, false, true, false,false)

               var HeadTitle = "char of account|account name|gl date|city|inv no|desc|debit|credit|debit2|credit2" ;

               //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
               InitHeadRow(0, HeadTitle, true);

               //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  								KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "pre_chart_of_account",		false,			"",			dfNone,					0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData, 			80,			daCenter,		false,    "pre_account_name",				false,			"",			dfNone,					0,			true,			true	);
				InitDataProperty(0, cnt++ , dtData,	 			80,			daLeft,			false,    "pre_gl_date",						false,			"",			dfNone,					0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_city",								false,			"",			dfNone,					0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_inv_no",							false,			"",			dfNone,					0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_desc",								false,			"",			dfNone,					0,			false,			false	);
				
				InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_debit",							false,			"",			dfNone,					0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_credit",							false,			"",			dfNone,					0,			false,			false	);
 
				InitDataProperty(0, cnt++ , dtHidden,	 		0,			daRight,		false,    "pre_debit2",							false,			"",			dfNone,					0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,	 		0,			daRight,		false,    "pre_credit2",						false,			"",			dfNone,					0,			false,			false	);

           }
           break;

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch (sAction) {

    	case IBSEARCH: //조회
    			formObj.f_cmd.value = SEARCH;
    	
				//파라미터 명시적인 생성
				var formParams = "";
				formParams+="f_cmd="+ComGetObjValue(formObj.f_cmd);
				formParams+="&pagerows="+ComGetObjValue(formObj.pagerows);
				formParams+="&iPage="+ComGetObjValue(formObj.iPage);
				formParams+="&ofc_cd="+ComGetObjValue(formObj.ofc_cd);
				formParams+="&inv_sub_sys_cd="+ComGetObjValue(formObj.inv_sub_sys_cd);
				formParams+="&inv_ofc_cd="+ComGetObjValue(formObj.inv_ofc_cd);
				formParams+="&cnt_cd="+ComGetObjValue(formObj.cnt_cd);
				formParams+="&asanogb="+ComGetObjValue(formObj.asanogb);
				formParams+="&pay_group_cd="+ComGetObjValue(formObj.pay_group_cd);
				formParams+="&csr_amt="+ComGetObjValue(formObj.csr_amt);
				formParams+="&iss_dt="+ComGetObjValue(formObj.iss_dt);
				formParams+="&rcv_dt="+ComGetObjValue(formObj.rcv_dt);
				formParams+="&gen_pay_term_cd="+ComGetObjValue(formObj.gen_pay_term_cd);
				formParams+="&temp_payment_due_dt="+ComGetObjValue(formObj.temp_payment_due_dt);
				formParams+="&pay_term_tp_cd="+ComGetObjValue(formObj.pay_term_tp_cd);
				formParams+="&ap_ofc_cd="+ComGetObjValue(formObj.ap_ofc_cd);
				formParams+="&usr_eml="+ComGetObjValue(formObj.usr_eml);
				formParams+="&usr_nm="+ComGetObjValue(formObj.usr_nm);
				formParams+="&cre_usr_id="+ComGetObjValue(formObj.cre_usr_id);
				formParams+="&csr_tp_cd="+ComGetObjValue(formObj.csr_tp_cd);
				formParams+="&evi_gb="+ComGetObjValue(formObj.evi_gb);
				formParams+="&inv_knt="+ComGetObjValue(formObj.inv_knt);
				formParams+="&inv_cfm_dt="+ComGetObjValue(formObj.inv_cfm_dt);
				formParams+="&pso_trns_slp_ctnt="+ComGetObjValue(formObj.pso_trns_slp_ctnt);
				formParams+="&tax_naid_flg="+ComGetObjValue(formObj.tax_naid_flg);
				formParams+="&finance_flg="+ComGetObjValue(formObj.finance_flg);
				formParams+="&fa_flg="+ComGetObjValue(formObj.fa_flg);
				formParams+="&tax_type="+ComGetObjValue(formObj.tax_type);
				formParams+="&tax_nsl_flg="+ComGetObjValue(formObj.tax_nsl_flg);
				formParams+="&evi_inv_dt="+ComGetObjValue(formObj.evi_inv_dt);
				formParams+="&evi_comp_no="+ComGetObjValue(formObj.evi_comp_no);
				formParams+="&evi_total_net_amt="+ComGetObjValue(formObj.evi_total_net_amt);
				formParams+="&evi_tax_no2="+ComGetObjValue(formObj.evi_tax_no2);
				formParams+="&evi_total_tax_amt="+ComGetObjValue(formObj.evi_total_tax_amt);
				formParams+="&evi_ctnt1="+ComGetObjValue(formObj.evi_ctnt1);
				formParams+="&evi_ctnt2="+ComGetObjValue(formObj.evi_ctnt2);
				formParams+="&evi_ctnt3="+ComGetObjValue(formObj.evi_ctnt3);
				formParams+="&evi_ctnt4="+ComGetObjValue(formObj.evi_ctnt4);
				formParams+="&evi_ctnt5="+ComGetObjValue(formObj.evi_ctnt5);
				formParams+="&evi_ctnt6="+ComGetObjValue(formObj.evi_ctnt6);
				formParams+="&evi_ctnt7="+ComGetObjValue(formObj.evi_ctnt7);
				formParams+="&evi_ctnt8="+ComGetObjValue(formObj.evi_ctnt8);
				formParams+="&evi_ctnt9="+ComGetObjValue(formObj.evi_ctnt9);
				formParams+="&evi_ctnt10="+ComGetObjValue(formObj.evi_ctnt10);
				formParams+="&evi_ctnt11="+ComGetObjValue(formObj.evi_ctnt11);
				formParams+="&evi_ctnt12="+ComGetObjValue(formObj.evi_ctnt12);
				formParams+="&evi_tax_no="+ComGetObjValue(formObj.evi_tax_no);
				formParams+="&evi_tax_code="+ComGetObjValue(formObj.evi_tax_code);
				formParams+="&s_tax_naid_flg="+ComGetObjValue(formObj.s_tax_naid_flg);
				formParams+="&s_finance_flg="+ComGetObjValue(formObj.s_finance_flg);
				formParams+="&s_fa_flg="+ComGetObjValue(formObj.s_fa_flg);
				formParams+="&s_tax_type="+ComGetObjValue(formObj.s_tax_type);
				formParams+="&s_tax_nsl_flg="+ComGetObjValue(formObj.s_tax_nsl_flg);
				formParams+="&s_evi_inv_dt="+ComGetObjValue(formObj.s_evi_inv_dt);
				formParams+="&s_evi_comp_no="+ComGetObjValue(formObj.s_evi_comp_no);
				formParams+="&s_evi_total_net_amt="+ComGetObjValue(formObj.s_evi_total_net_amt);
				formParams+="&s_evi_tax_no2="+ComGetObjValue(formObj.s_evi_tax_no2);
				formParams+="&s_evi_total_tax_amt="+ComGetObjValue(formObj.s_evi_total_tax_amt);
				formParams+="&s_evi_ctnt1="+ComGetObjValue(formObj.s_evi_ctnt1);
				formParams+="&s_evi_ctnt2="+ComGetObjValue(formObj.s_evi_ctnt2);
				formParams+="&s_evi_ctnt3="+ComGetObjValue(formObj.s_evi_ctnt3);
				formParams+="&s_evi_ctnt4="+ComGetObjValue(formObj.s_evi_ctnt4);
				formParams+="&s_evi_ctnt5="+ComGetObjValue(formObj.s_evi_ctnt5);
				formParams+="&s_evi_ctnt6="+ComGetObjValue(formObj.s_evi_ctnt6);
				formParams+="&s_evi_ctnt7="+ComGetObjValue(formObj.s_evi_ctnt7);
				formParams+="&s_evi_ctnt8="+ComGetObjValue(formObj.s_evi_ctnt8);
				formParams+="&s_evi_ctnt9="+ComGetObjValue(formObj.s_evi_ctnt9);
				formParams+="&s_evi_ctnt10="+ComGetObjValue(formObj.s_evi_ctnt10);
				formParams+="&s_evi_ctnt11="+ComGetObjValue(formObj.s_evi_ctnt11);
				formParams+="&s_evi_ctnt12="+ComGetObjValue(formObj.s_evi_ctnt12);
				formParams+="&s_evi_tax_no="+ComGetObjValue(formObj.s_evi_tax_no);
				formParams+="&s_evi_tax_code="+ComGetObjValue(formObj.s_evi_tax_code);
				formParams+="&ttl_lss_div_cd="+ComGetObjValue(formObj.ttl_lss_div_cd);
				formParams+="&inv_rgst_no="+ComGetObjValue(formObj.inv_rgst_no);
				formParams+="&eviInputFlg="+ComGetObjValue(formObj.eviInputFlg);
				formParams+="&s_eviInputFlg="+ComGetObjValue(formObj.s_eviInputFlg);
				formParams+="&apopen="+ComGetObjValue(formObj.apopen);
				formParams+="&com_mrdPath="+ComGetObjValue(formObj.com_mrdPath);
				formParams+="&com_mrdArguments="+ComGetObjValue(formObj.com_mrdArguments);
				formParams+="&asa_no_s="+ComGetObjValue(formObj.asa_no_s);
				//formParams+="&aproSeqKey="+ComGetObjValue(formObj.aproSeqKey);
				formParams+="&key="+ComGetObjValue(formObj.key);
				formParams+="&cost_ofc_cd="+ComGetObjValue(formObj.cost_ofc_cd);
				formParams+="&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
				formParams+="&cnt_inv="+ComGetObjValue(formObj.cnt_inv);
				formParams+="&curr_cd="+ComGetObjValue(formObj.curr_cd);
				formParams+="&inv_curr_cd="+ComGetObjValue(formObj.curr_cd);
				formParams+="&total_amt="+ComGetObjValue(formObj.total_amt);
				formParams+="&max_iss_dt="+ComGetObjValue(formObj.max_iss_dt);
				formParams+="&max_rcv_dt="+ComGetObjValue(formObj.max_rcv_dt);
				formParams+="&gen_pay_term_desc="+ComGetObjValue(formObj.gen_pay_term_desc);
				formParams+="&payment_due_dt="+ComGetObjValue(formObj.payment_due_dt);
				//formParams+="&apro_step="+ComGetObjValue(formObj.apro_step);
				formParams+="&csr_no="+ComGetObjValue(formObj.csr_no);

    			var sXml = sheetObjects[2].GetSearchXml("COM_CSR_0002GS.do", formParams);
				//alert(FormQueryString(formObj));
    			//var sXml = sheetObjects[2].GetSearchXml("COM_CSR_0002GS.do", FormQueryString(formObj),"",true);
    			var arrXml = sXml.split("|$$|");
    			sheetObj.LoadSearchXml(arrXml);
    		break;
    	}
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet1(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch (sAction) {

        case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH01;
        
			//파라미터 명시적인 생성
			var formParams = "";
			formParams+="f_cmd="+ComGetObjValue(formObj.f_cmd);
			formParams+="&pagerows="+ComGetObjValue(formObj.pagerows);
			formParams+="&iPage="+ComGetObjValue(formObj.iPage);
			formParams+="&ofc_cd="+ComGetObjValue(formObj.ofc_cd);
			formParams+="&inv_sub_sys_cd="+ComGetObjValue(formObj.inv_sub_sys_cd);
			formParams+="&inv_ofc_cd="+ComGetObjValue(formObj.inv_ofc_cd);
			formParams+="&cnt_cd="+ComGetObjValue(formObj.cnt_cd);
			formParams+="&asanogb="+ComGetObjValue(formObj.asanogb);
			formParams+="&pay_group_cd="+ComGetObjValue(formObj.pay_group_cd);
			formParams+="&csr_amt="+ComGetObjValue(formObj.csr_amt);
			formParams+="&iss_dt="+ComGetObjValue(formObj.iss_dt);
			formParams+="&rcv_dt="+ComGetObjValue(formObj.rcv_dt);
			formParams+="&gen_pay_term_cd="+ComGetObjValue(formObj.gen_pay_term_cd);
			formParams+="&temp_payment_due_dt="+ComGetObjValue(formObj.temp_payment_due_dt);
			formParams+="&pay_term_tp_cd="+ComGetObjValue(formObj.pay_term_tp_cd);
			formParams+="&ap_ofc_cd="+ComGetObjValue(formObj.ap_ofc_cd);
			formParams+="&usr_eml="+ComGetObjValue(formObj.usr_eml);
			formParams+="&usr_nm="+ComGetObjValue(formObj.usr_nm);
			formParams+="&cre_usr_id="+ComGetObjValue(formObj.cre_usr_id);
			formParams+="&csr_tp_cd="+ComGetObjValue(formObj.csr_tp_cd);
			formParams+="&evi_gb="+ComGetObjValue(formObj.evi_gb);
			formParams+="&inv_knt="+ComGetObjValue(formObj.inv_knt);
			formParams+="&inv_cfm_dt="+ComGetObjValue(formObj.inv_cfm_dt);
			formParams+="&pso_trns_slp_ctnt="+ComGetObjValue(formObj.pso_trns_slp_ctnt);
			formParams+="&tax_naid_flg="+ComGetObjValue(formObj.tax_naid_flg);
			formParams+="&finance_flg="+ComGetObjValue(formObj.finance_flg);
			formParams+="&fa_flg="+ComGetObjValue(formObj.fa_flg);
			formParams+="&tax_type="+ComGetObjValue(formObj.tax_type);
			formParams+="&tax_nsl_flg="+ComGetObjValue(formObj.tax_nsl_flg);
			formParams+="&evi_inv_dt="+ComGetObjValue(formObj.evi_inv_dt);
			formParams+="&evi_comp_no="+ComGetObjValue(formObj.evi_comp_no);
			formParams+="&evi_total_net_amt="+ComGetObjValue(formObj.evi_total_net_amt);
			formParams+="&evi_tax_no2="+ComGetObjValue(formObj.evi_tax_no2);
			formParams+="&evi_total_tax_amt="+ComGetObjValue(formObj.evi_total_tax_amt);
			formParams+="&evi_ctnt1="+ComGetObjValue(formObj.evi_ctnt1);
			formParams+="&evi_ctnt2="+ComGetObjValue(formObj.evi_ctnt2);
			formParams+="&evi_ctnt3="+ComGetObjValue(formObj.evi_ctnt3);
			formParams+="&evi_ctnt4="+ComGetObjValue(formObj.evi_ctnt4);
			formParams+="&evi_ctnt5="+ComGetObjValue(formObj.evi_ctnt5);
			formParams+="&evi_ctnt6="+ComGetObjValue(formObj.evi_ctnt6);
			formParams+="&evi_ctnt7="+ComGetObjValue(formObj.evi_ctnt7);
			formParams+="&evi_ctnt8="+ComGetObjValue(formObj.evi_ctnt8);
			formParams+="&evi_ctnt9="+ComGetObjValue(formObj.evi_ctnt9);
			formParams+="&evi_ctnt10="+ComGetObjValue(formObj.evi_ctnt10);
			formParams+="&evi_ctnt11="+ComGetObjValue(formObj.evi_ctnt11);
			formParams+="&evi_ctnt12="+ComGetObjValue(formObj.evi_ctnt12);
			formParams+="&evi_tax_no="+ComGetObjValue(formObj.evi_tax_no);
			formParams+="&evi_tax_code="+ComGetObjValue(formObj.evi_tax_code);
			formParams+="&s_tax_naid_flg="+ComGetObjValue(formObj.s_tax_naid_flg);
			formParams+="&s_finance_flg="+ComGetObjValue(formObj.s_finance_flg);
			formParams+="&s_fa_flg="+ComGetObjValue(formObj.s_fa_flg);
			formParams+="&s_tax_type="+ComGetObjValue(formObj.s_tax_type);
			formParams+="&s_tax_nsl_flg="+ComGetObjValue(formObj.s_tax_nsl_flg);
			formParams+="&s_evi_inv_dt="+ComGetObjValue(formObj.s_evi_inv_dt);
			formParams+="&s_evi_comp_no="+ComGetObjValue(formObj.s_evi_comp_no);
			formParams+="&s_evi_total_net_amt="+ComGetObjValue(formObj.s_evi_total_net_amt);
			formParams+="&s_evi_tax_no2="+ComGetObjValue(formObj.s_evi_tax_no2);
			formParams+="&s_evi_total_tax_amt="+ComGetObjValue(formObj.s_evi_total_tax_amt);
			formParams+="&s_evi_ctnt1="+ComGetObjValue(formObj.s_evi_ctnt1);
			formParams+="&s_evi_ctnt2="+ComGetObjValue(formObj.s_evi_ctnt2);
			formParams+="&s_evi_ctnt3="+ComGetObjValue(formObj.s_evi_ctnt3);
			formParams+="&s_evi_ctnt4="+ComGetObjValue(formObj.s_evi_ctnt4);
			formParams+="&s_evi_ctnt5="+ComGetObjValue(formObj.s_evi_ctnt5);
			formParams+="&s_evi_ctnt6="+ComGetObjValue(formObj.s_evi_ctnt6);
			formParams+="&s_evi_ctnt7="+ComGetObjValue(formObj.s_evi_ctnt7);
			formParams+="&s_evi_ctnt8="+ComGetObjValue(formObj.s_evi_ctnt8);
			formParams+="&s_evi_ctnt9="+ComGetObjValue(formObj.s_evi_ctnt9);
			formParams+="&s_evi_ctnt10="+ComGetObjValue(formObj.s_evi_ctnt10);
			formParams+="&s_evi_ctnt11="+ComGetObjValue(formObj.s_evi_ctnt11);
			formParams+="&s_evi_ctnt12="+ComGetObjValue(formObj.s_evi_ctnt12);
			formParams+="&s_evi_tax_no="+ComGetObjValue(formObj.s_evi_tax_no);
			formParams+="&s_evi_tax_code="+ComGetObjValue(formObj.s_evi_tax_code);
			formParams+="&ttl_lss_div_cd="+ComGetObjValue(formObj.ttl_lss_div_cd);
			formParams+="&inv_rgst_no="+ComGetObjValue(formObj.inv_rgst_no);
			formParams+="&eviInputFlg="+ComGetObjValue(formObj.eviInputFlg);
			formParams+="&s_eviInputFlg="+ComGetObjValue(formObj.s_eviInputFlg);
			formParams+="&apopen="+ComGetObjValue(formObj.apopen);
			formParams+="&com_mrdPath="+ComGetObjValue(formObj.com_mrdPath);
			formParams+="&com_mrdArguments="+ComGetObjValue(formObj.com_mrdArguments);
			formParams+="&asa_no_s="+ComGetObjValue(formObj.asa_no_s);
			//formParams+="&aproSeqKey="+ComGetObjValue(formObj.aproSeqKey);
			formParams+="&key="+ComGetObjValue(formObj.key);
			formParams+="&cost_ofc_cd="+ComGetObjValue(formObj.cost_ofc_cd);
			formParams+="&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
			formParams+="&cnt_inv="+ComGetObjValue(formObj.cnt_inv);
			formParams+="&curr_cd="+ComGetObjValue(formObj.curr_cd);
			formParams+="&total_amt="+ComGetObjValue(formObj.total_amt);
			formParams+="&max_iss_dt="+ComGetObjValue(formObj.max_iss_dt);
			formParams+="&max_rcv_dt="+ComGetObjValue(formObj.max_rcv_dt);
			formParams+="&gen_pay_term_desc="+ComGetObjValue(formObj.gen_pay_term_desc);
			formParams+="&payment_due_dt="+ComGetObjValue(formObj.payment_due_dt);
			//formParams+="&apro_step="+encodeURIComponent(ComGetObjValue(formObj.apro_step));
			formParams+="&csr_no="+ComGetObjValue(formObj.csr_no);
			
			var param = sheetObjects[0].GetSaveString(false,true,1);
			var sXml = sheetObjects[2].GetSearchXml("COM_CSR_0002GS.do", param+'&'+formParams,"",true);
		
   			var arrXml = sXml.split("|$$|");
   			sheetObjects[1].LoadSearchXml(arrXml[0]);	//플릿폼
   			sheetObjects[2].LoadSearchXml(arrXml[1]);	//리스트
        break;

        case IBSAVE:      //저장
			var sRow = sheetObj.FindCheckedRow(1);
			var arrRow = sRow.split("|");
	
			formObj.inv_knt.value = arrRow.length-1;
        	formObj.f_cmd.value = MULTI01;
        	var param = sheetObj.GetSaveString(false,true,1);
        	
			//파라미터 명시적인 생성
			var formParams = "";
			formParams+="f_cmd="+ComGetObjValue(formObj.f_cmd);
			formParams+="&pagerows="+ComGetObjValue(formObj.pagerows);
			formParams+="&iPage="+ComGetObjValue(formObj.iPage);
			formParams+="&ofc_cd="+ComGetObjValue(formObj.ofc_cd);
			formParams+="&inv_sub_sys_cd="+ComGetObjValue(formObj.inv_sub_sys_cd);
			formParams+="&inv_ofc_cd="+ComGetObjValue(formObj.inv_ofc_cd);
			formParams+="&cnt_cd="+ComGetObjValue(formObj.cnt_cd);
			formParams+="&asanogb="+ComGetObjValue(formObj.asanogb);
			formParams+="&pay_group_cd="+ComGetObjValue(formObj.pay_group_cd);
			formParams+="&csr_amt="+ComGetObjValue(formObj.csr_amt);
			formParams+="&iss_dt="+ComGetObjValue(formObj.iss_dt);
			formParams+="&rcv_dt="+ComGetObjValue(formObj.rcv_dt);
			formParams+="&gen_pay_term_cd="+ComGetObjValue(formObj.gen_pay_term_cd);
			formParams+="&temp_payment_due_dt="+ComGetObjValue(formObj.temp_payment_due_dt);
			formParams+="&pay_term_tp_cd="+ComGetObjValue(formObj.pay_term_tp_cd);
			formParams+="&ap_ofc_cd="+ComGetObjValue(formObj.ap_ofc_cd);
			formParams+="&usr_eml="+ComGetObjValue(formObj.usr_eml);
			formParams+="&usr_nm="+ComGetObjValue(formObj.usr_nm);
			formParams+="&cre_usr_id="+ComGetObjValue(formObj.cre_usr_id);
			formParams+="&csr_tp_cd="+ComGetObjValue(formObj.csr_tp_cd);
			formParams+="&evi_gb="+ComGetObjValue(formObj.evi_gb);
			formParams+="&inv_knt="+ComGetObjValue(formObj.inv_knt);
			formParams+="&inv_cfm_dt="+ComGetObjValue(formObj.inv_cfm_dt);
			formParams+="&pso_trns_slp_ctnt="+ComGetObjValue(formObj.pso_trns_slp_ctnt);
			formParams+="&tax_naid_flg="+ComGetObjValue(formObj.tax_naid_flg);
			formParams+="&finance_flg="+ComGetObjValue(formObj.finance_flg);
			formParams+="&fa_flg="+ComGetObjValue(formObj.fa_flg);
			formParams+="&tax_type="+ComGetObjValue(formObj.tax_type);
			formParams+="&tax_nsl_flg="+ComGetObjValue(formObj.tax_nsl_flg);
			formParams+="&evi_inv_dt="+ComGetObjValue(formObj.evi_inv_dt);
			formParams+="&evi_comp_no="+ComGetObjValue(formObj.evi_comp_no);
			formParams+="&evi_total_net_amt="+ComGetObjValue(formObj.evi_total_net_amt);
			formParams+="&evi_tax_no2="+ComGetObjValue(formObj.evi_tax_no2);
			formParams+="&evi_total_tax_amt="+ComGetObjValue(formObj.evi_total_tax_amt);
			formParams+="&evi_ctnt1="+ComGetObjValue(formObj.evi_ctnt1);
			formParams+="&evi_ctnt2="+ComGetObjValue(formObj.evi_ctnt2);
			formParams+="&evi_ctnt3="+ComGetObjValue(formObj.evi_ctnt3);
			formParams+="&evi_ctnt4="+ComGetObjValue(formObj.evi_ctnt4);
			formParams+="&evi_ctnt5="+ComGetObjValue(formObj.evi_ctnt5);
			formParams+="&evi_ctnt6="+ComGetObjValue(formObj.evi_ctnt6);
			formParams+="&evi_ctnt7="+ComGetObjValue(formObj.evi_ctnt7);
			formParams+="&evi_ctnt8="+ComGetObjValue(formObj.evi_ctnt8);
			formParams+="&evi_ctnt9="+ComGetObjValue(formObj.evi_ctnt9);
			formParams+="&evi_ctnt10="+ComGetObjValue(formObj.evi_ctnt10);
			formParams+="&evi_ctnt11="+ComGetObjValue(formObj.evi_ctnt11);
			formParams+="&evi_ctnt12="+ComGetObjValue(formObj.evi_ctnt12);
			formParams+="&evi_tax_no="+ComGetObjValue(formObj.evi_tax_no);
			formParams+="&evi_tax_code="+ComGetObjValue(formObj.evi_tax_code);
			formParams+="&s_tax_naid_flg="+ComGetObjValue(formObj.s_tax_naid_flg);
			formParams+="&s_finance_flg="+ComGetObjValue(formObj.s_finance_flg);
			formParams+="&s_fa_flg="+ComGetObjValue(formObj.s_fa_flg);
			formParams+="&s_tax_type="+ComGetObjValue(formObj.s_tax_type);
			formParams+="&s_tax_nsl_flg="+ComGetObjValue(formObj.s_tax_nsl_flg);
			formParams+="&s_evi_inv_dt="+ComGetObjValue(formObj.s_evi_inv_dt);
			formParams+="&s_evi_comp_no="+ComGetObjValue(formObj.s_evi_comp_no);
			formParams+="&s_evi_total_net_amt="+ComGetObjValue(formObj.s_evi_total_net_amt);
			formParams+="&s_evi_tax_no2="+ComGetObjValue(formObj.s_evi_tax_no2);
			formParams+="&s_evi_total_tax_amt="+ComGetObjValue(formObj.s_evi_total_tax_amt);
			formParams+="&s_evi_ctnt1="+ComGetObjValue(formObj.s_evi_ctnt1);
			formParams+="&s_evi_ctnt2="+ComGetObjValue(formObj.s_evi_ctnt2);
			formParams+="&s_evi_ctnt3="+ComGetObjValue(formObj.s_evi_ctnt3);
			formParams+="&s_evi_ctnt4="+ComGetObjValue(formObj.s_evi_ctnt4);
			formParams+="&s_evi_ctnt5="+ComGetObjValue(formObj.s_evi_ctnt5);
			formParams+="&s_evi_ctnt6="+ComGetObjValue(formObj.s_evi_ctnt6);
			formParams+="&s_evi_ctnt7="+ComGetObjValue(formObj.s_evi_ctnt7);
			formParams+="&s_evi_ctnt8="+ComGetObjValue(formObj.s_evi_ctnt8);
			formParams+="&s_evi_ctnt9="+ComGetObjValue(formObj.s_evi_ctnt9);
			formParams+="&s_evi_ctnt10="+ComGetObjValue(formObj.s_evi_ctnt10);
			formParams+="&s_evi_ctnt11="+ComGetObjValue(formObj.s_evi_ctnt11);
			formParams+="&s_evi_ctnt12="+ComGetObjValue(formObj.s_evi_ctnt12);
			formParams+="&s_evi_tax_no="+ComGetObjValue(formObj.s_evi_tax_no);
			formParams+="&s_evi_tax_code="+ComGetObjValue(formObj.s_evi_tax_code);
			formParams+="&attr_ctnt8="+ComGetObjValue(formObj.attr_ctnt8);
			formParams+="&ttl_lss_div_cd="+ComGetObjValue(formObj.ttl_lss_div_cd);
			formParams+="&inv_rgst_no="+ComGetObjValue(formObj.inv_rgst_no);
			formParams+="&eviInputFlg="+ComGetObjValue(formObj.eviInputFlg);
			formParams+="&s_eviInputFlg="+ComGetObjValue(formObj.s_eviInputFlg);
			formParams+="&apopen="+ComGetObjValue(formObj.apopen);
			formParams+="&com_mrdPath="+ComGetObjValue(formObj.com_mrdPath);
			formParams+="&com_mrdArguments="+ComGetObjValue(formObj.com_mrdArguments);
			formParams+="&asa_no_s="+ComGetObjValue(formObj.asa_no_s);
			//formParams+="&aproSeqKey="+ComGetObjValue(formObj.aproSeqKey);
			formParams+="&key="+ComGetObjValue(formObj.key);
			formParams+="&cost_ofc_cd="+ComGetObjValue(formObj.cost_ofc_cd);
			formParams+="&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
			formParams+="&cnt_inv="+ComGetObjValue(formObj.cnt_inv);
			formParams+="&curr_cd="+ComGetObjValue(formObj.curr_cd);
			formParams+="&total_amt="+ComGetObjValue(formObj.total_amt);
			formParams+="&max_iss_dt="+ComGetObjValue(formObj.max_iss_dt);
			formParams+="&max_rcv_dt="+ComGetObjValue(formObj.max_rcv_dt);
			formParams+="&gen_pay_term_desc="+ComGetObjValue(formObj.gen_pay_term_desc);
			formParams+="&payment_due_dt="+ComGetObjValue(formObj.payment_due_dt);
			//formParams+="&apro_step="+encodeURIComponent(ComGetObjValue(formObj.apro_step));
			formParams+="&csr_no="+ComGetObjValue(formObj.csr_no);					
			
			var sXml = sheetObj.GetSearchXml("COM_CSR_0002GS.do", param+'&'+formParams);
			var key = ComGetEtcData(sXml,"key");

	        if (key.length > 0) {
				gRefresh = true; // 결과 file에서 조회해야함
	            formObj.key.value = key;
	            sheetObj.WaitImageVisible = false;
	            ComOpenWait(true);
	            sheetObj.RequestTimeOut = 1000;
	            timer = setInterval(UF_getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
	        }
		break;
		
		//BackEndJob Status 와 JB_ERR_MSG 조회
		case IBSEARCH_ASYNC02:
		    formObj.f_cmd.value = SEARCHLIST;
		    var param = sheetObj.GetSaveString(false,true,1);

			//파라미터 명시적인 생성
			var formParams = "";
			formParams+="f_cmd="+ComGetObjValue(formObj.f_cmd);
			formParams+="&pagerows="+ComGetObjValue(formObj.pagerows);
			formParams+="&iPage="+ComGetObjValue(formObj.iPage);
			formParams+="&ofc_cd="+ComGetObjValue(formObj.ofc_cd);
			formParams+="&inv_sub_sys_cd="+ComGetObjValue(formObj.inv_sub_sys_cd);
			formParams+="&inv_ofc_cd="+ComGetObjValue(formObj.inv_ofc_cd);
			formParams+="&cnt_cd="+ComGetObjValue(formObj.cnt_cd);
			formParams+="&asanogb="+ComGetObjValue(formObj.asanogb);
			formParams+="&pay_group_cd="+ComGetObjValue(formObj.pay_group_cd);
			formParams+="&csr_amt="+ComGetObjValue(formObj.csr_amt);
			formParams+="&iss_dt="+ComGetObjValue(formObj.iss_dt);
			formParams+="&rcv_dt="+ComGetObjValue(formObj.rcv_dt);
			formParams+="&gen_pay_term_cd="+ComGetObjValue(formObj.gen_pay_term_cd);
			formParams+="&temp_payment_due_dt="+ComGetObjValue(formObj.temp_payment_due_dt);
			formParams+="&pay_term_tp_cd="+ComGetObjValue(formObj.pay_term_tp_cd);
			formParams+="&ap_ofc_cd="+ComGetObjValue(formObj.ap_ofc_cd);
			formParams+="&usr_eml="+ComGetObjValue(formObj.usr_eml);
			formParams+="&usr_nm="+ComGetObjValue(formObj.usr_nm);
			formParams+="&cre_usr_id="+ComGetObjValue(formObj.cre_usr_id);
			formParams+="&csr_tp_cd="+ComGetObjValue(formObj.csr_tp_cd);
			formParams+="&evi_gb="+ComGetObjValue(formObj.evi_gb);
			formParams+="&inv_knt="+ComGetObjValue(formObj.inv_knt);
			formParams+="&inv_cfm_dt="+ComGetObjValue(formObj.inv_cfm_dt);
			formParams+="&pso_trns_slp_ctnt="+ComGetObjValue(formObj.pso_trns_slp_ctnt);
			formParams+="&tax_naid_flg="+ComGetObjValue(formObj.tax_naid_flg);
			formParams+="&finance_flg="+ComGetObjValue(formObj.finance_flg);
			formParams+="&fa_flg="+ComGetObjValue(formObj.fa_flg);
			formParams+="&tax_type="+ComGetObjValue(formObj.tax_type);
			formParams+="&tax_nsl_flg="+ComGetObjValue(formObj.tax_nsl_flg);
			formParams+="&evi_inv_dt="+ComGetObjValue(formObj.evi_inv_dt);
			formParams+="&evi_comp_no="+ComGetObjValue(formObj.evi_comp_no);
			formParams+="&evi_total_net_amt="+ComGetObjValue(formObj.evi_total_net_amt);
			formParams+="&evi_tax_no2="+ComGetObjValue(formObj.evi_tax_no2);
			formParams+="&evi_total_tax_amt="+ComGetObjValue(formObj.evi_total_tax_amt);
			formParams+="&evi_ctnt1="+ComGetObjValue(formObj.evi_ctnt1);
			formParams+="&evi_ctnt2="+ComGetObjValue(formObj.evi_ctnt2);
			formParams+="&evi_ctnt3="+ComGetObjValue(formObj.evi_ctnt3);
			formParams+="&evi_ctnt4="+ComGetObjValue(formObj.evi_ctnt4);
			formParams+="&evi_ctnt5="+ComGetObjValue(formObj.evi_ctnt5);
			formParams+="&evi_ctnt6="+ComGetObjValue(formObj.evi_ctnt6);
			formParams+="&evi_ctnt7="+ComGetObjValue(formObj.evi_ctnt7);
			formParams+="&evi_ctnt8="+ComGetObjValue(formObj.evi_ctnt8);
			formParams+="&evi_ctnt9="+ComGetObjValue(formObj.evi_ctnt9);
			formParams+="&evi_ctnt10="+ComGetObjValue(formObj.evi_ctnt10);
			formParams+="&evi_ctnt11="+ComGetObjValue(formObj.evi_ctnt11);
			formParams+="&evi_ctnt12="+ComGetObjValue(formObj.evi_ctnt12);
			formParams+="&evi_tax_no="+ComGetObjValue(formObj.evi_tax_no);
			formParams+="&evi_tax_code="+ComGetObjValue(formObj.evi_tax_code);
			formParams+="&s_tax_naid_flg="+ComGetObjValue(formObj.s_tax_naid_flg);
			formParams+="&s_finance_flg="+ComGetObjValue(formObj.s_finance_flg);
			formParams+="&s_fa_flg="+ComGetObjValue(formObj.s_fa_flg);
			formParams+="&s_tax_type="+ComGetObjValue(formObj.s_tax_type);
			formParams+="&s_tax_nsl_flg="+ComGetObjValue(formObj.s_tax_nsl_flg);
			formParams+="&s_evi_inv_dt="+ComGetObjValue(formObj.s_evi_inv_dt);
			formParams+="&s_evi_comp_no="+ComGetObjValue(formObj.s_evi_comp_no);
			formParams+="&s_evi_total_net_amt="+ComGetObjValue(formObj.s_evi_total_net_amt);
			formParams+="&s_evi_tax_no2="+ComGetObjValue(formObj.s_evi_tax_no2);
			formParams+="&s_evi_total_tax_amt="+ComGetObjValue(formObj.s_evi_total_tax_amt);
			formParams+="&s_evi_ctnt1="+ComGetObjValue(formObj.s_evi_ctnt1);
			formParams+="&s_evi_ctnt2="+ComGetObjValue(formObj.s_evi_ctnt2);
			formParams+="&s_evi_ctnt3="+ComGetObjValue(formObj.s_evi_ctnt3);
			formParams+="&s_evi_ctnt4="+ComGetObjValue(formObj.s_evi_ctnt4);
			formParams+="&s_evi_ctnt5="+ComGetObjValue(formObj.s_evi_ctnt5);
			formParams+="&s_evi_ctnt6="+ComGetObjValue(formObj.s_evi_ctnt6);
			formParams+="&s_evi_ctnt7="+ComGetObjValue(formObj.s_evi_ctnt7);
			formParams+="&s_evi_ctnt8="+ComGetObjValue(formObj.s_evi_ctnt8);
			formParams+="&s_evi_ctnt9="+ComGetObjValue(formObj.s_evi_ctnt9);
			formParams+="&s_evi_ctnt10="+ComGetObjValue(formObj.s_evi_ctnt10);
			formParams+="&s_evi_ctnt11="+ComGetObjValue(formObj.s_evi_ctnt11);
			formParams+="&s_evi_ctnt12="+ComGetObjValue(formObj.s_evi_ctnt12);
			formParams+="&s_evi_tax_no="+ComGetObjValue(formObj.s_evi_tax_no);
			formParams+="&s_evi_tax_code="+ComGetObjValue(formObj.s_evi_tax_code);
			formParams+="&ttl_lss_div_cd="+ComGetObjValue(formObj.ttl_lss_div_cd);
			formParams+="&inv_rgst_no="+ComGetObjValue(formObj.inv_rgst_no);
			formParams+="&eviInputFlg="+ComGetObjValue(formObj.eviInputFlg);
			formParams+="&s_eviInputFlg="+ComGetObjValue(formObj.s_eviInputFlg);
			formParams+="&apopen="+ComGetObjValue(formObj.apopen);
			formParams+="&com_mrdPath="+ComGetObjValue(formObj.com_mrdPath);
			formParams+="&com_mrdArguments="+ComGetObjValue(formObj.com_mrdArguments);
			formParams+="&asa_no_s="+ComGetObjValue(formObj.asa_no_s);
			//formParams+="&aproSeqKey="+ComGetObjValue(formObj.aproSeqKey);
			formParams+="&key="+ComGetObjValue(formObj.key);
			formParams+="&cost_ofc_cd="+ComGetObjValue(formObj.cost_ofc_cd);
			formParams+="&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
			formParams+="&cnt_inv="+ComGetObjValue(formObj.cnt_inv);
			formParams+="&curr_cd="+ComGetObjValue(formObj.curr_cd);
			formParams+="&total_amt="+ComGetObjValue(formObj.total_amt);
			formParams+="&max_iss_dt="+ComGetObjValue(formObj.max_iss_dt);
			formParams+="&max_rcv_dt="+ComGetObjValue(formObj.max_rcv_dt);
			formParams+="&gen_pay_term_desc="+ComGetObjValue(formObj.gen_pay_term_desc);
			formParams+="&payment_due_dt="+ComGetObjValue(formObj.payment_due_dt);
			//formParams+="&apro_step="+ComGetObjValue(formObj.apro_step);
			formParams+="&csr_no="+ComGetObjValue(formObj.csr_no);
		    
		    var sXml = sheetObj.GetSearchXml("COM_CSR_0002GS.do", param+'&'+formParams);
		    var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		    var jobError = ComGetEtcData(sXml, "jb_usr_err_msg");

		    if (jobState == "3") {
		        ComOpenWait(false);
		        //ComShowCodeMessage("CSR25021");
		        if (gRefresh)
		        	doActionIBSheet1(sheetObj, formObj, IBSEARCH_ASYNC03);
		        clearInterval(timer);
		        
		    } else if (jobState == "4") {
		        ComOpenWait(false);
		        clearInterval(timer);
		        // BackEndJob을 실패 하였습니다.
		        //ComShowMessage(jobError);
		        CsrComShowWarningMessage(jobError);
		    } else if (jobState == "5") {
		        ComOpenWait(false);
		        clearInterval(timer);
		        // 이미 BackEndJob 결과 파일을 읽었습니다.
		        ComShowCodeMessage('JOO00152');
		    }
			
			break;

		//BackEndJob 결과 조회 : CSR_NO 조회
		case IBSEARCH_ASYNC03:
            sheetObj.WaitImageVisible = true;
            var param = sheetObj.GetSaveString(false,true,1);
		    formObj.f_cmd.value = SEARCHLIST03;
		    
			//파라미터 명시적인 생성
			var formParams = "";
			formParams+="f_cmd="+ComGetObjValue(formObj.f_cmd);
			formParams+="&pagerows="+ComGetObjValue(formObj.pagerows);
			formParams+="&iPage="+ComGetObjValue(formObj.iPage);
			formParams+="&ofc_cd="+ComGetObjValue(formObj.ofc_cd);
			formParams+="&inv_sub_sys_cd="+ComGetObjValue(formObj.inv_sub_sys_cd);
			formParams+="&inv_ofc_cd="+ComGetObjValue(formObj.inv_ofc_cd);
			formParams+="&cnt_cd="+ComGetObjValue(formObj.cnt_cd);
			formParams+="&asanogb="+ComGetObjValue(formObj.asanogb);
			formParams+="&pay_group_cd="+ComGetObjValue(formObj.pay_group_cd);
			formParams+="&csr_amt="+ComGetObjValue(formObj.csr_amt);
			formParams+="&iss_dt="+ComGetObjValue(formObj.iss_dt);
			formParams+="&rcv_dt="+ComGetObjValue(formObj.rcv_dt);
			formParams+="&gen_pay_term_cd="+ComGetObjValue(formObj.gen_pay_term_cd);
			formParams+="&temp_payment_due_dt="+ComGetObjValue(formObj.temp_payment_due_dt);
			formParams+="&pay_term_tp_cd="+ComGetObjValue(formObj.pay_term_tp_cd);
			formParams+="&ap_ofc_cd="+ComGetObjValue(formObj.ap_ofc_cd);
			formParams+="&usr_eml="+ComGetObjValue(formObj.usr_eml);
			formParams+="&usr_nm="+ComGetObjValue(formObj.usr_nm);
			formParams+="&cre_usr_id="+ComGetObjValue(formObj.cre_usr_id);
			formParams+="&csr_tp_cd="+ComGetObjValue(formObj.csr_tp_cd);
			formParams+="&evi_gb="+ComGetObjValue(formObj.evi_gb);
			formParams+="&inv_knt="+ComGetObjValue(formObj.inv_knt);
			formParams+="&inv_cfm_dt="+ComGetObjValue(formObj.inv_cfm_dt);
			formParams+="&pso_trns_slp_ctnt="+ComGetObjValue(formObj.pso_trns_slp_ctnt);
			formParams+="&tax_naid_flg="+ComGetObjValue(formObj.tax_naid_flg);
			formParams+="&finance_flg="+ComGetObjValue(formObj.finance_flg);
			formParams+="&fa_flg="+ComGetObjValue(formObj.fa_flg);
			formParams+="&tax_type="+ComGetObjValue(formObj.tax_type);
			formParams+="&tax_nsl_flg="+ComGetObjValue(formObj.tax_nsl_flg);
			formParams+="&evi_inv_dt="+ComGetObjValue(formObj.evi_inv_dt);
			formParams+="&evi_comp_no="+ComGetObjValue(formObj.evi_comp_no);
			formParams+="&evi_total_net_amt="+ComGetObjValue(formObj.evi_total_net_amt);
			formParams+="&evi_tax_no2="+ComGetObjValue(formObj.evi_tax_no2);
			formParams+="&evi_total_tax_amt="+ComGetObjValue(formObj.evi_total_tax_amt);
			formParams+="&evi_ctnt1="+ComGetObjValue(formObj.evi_ctnt1);
			formParams+="&evi_ctnt2="+ComGetObjValue(formObj.evi_ctnt2);
			formParams+="&evi_ctnt3="+ComGetObjValue(formObj.evi_ctnt3);
			formParams+="&evi_ctnt4="+ComGetObjValue(formObj.evi_ctnt4);
			formParams+="&evi_ctnt5="+ComGetObjValue(formObj.evi_ctnt5);
			formParams+="&evi_ctnt6="+ComGetObjValue(formObj.evi_ctnt6);
			formParams+="&evi_ctnt7="+ComGetObjValue(formObj.evi_ctnt7);
			formParams+="&evi_ctnt8="+ComGetObjValue(formObj.evi_ctnt8);
			formParams+="&evi_ctnt9="+ComGetObjValue(formObj.evi_ctnt9);
			formParams+="&evi_ctnt10="+ComGetObjValue(formObj.evi_ctnt10);
			formParams+="&evi_ctnt11="+ComGetObjValue(formObj.evi_ctnt11);
			formParams+="&evi_ctnt12="+ComGetObjValue(formObj.evi_ctnt12);
			formParams+="&evi_tax_no="+ComGetObjValue(formObj.evi_tax_no);
			formParams+="&evi_tax_code="+ComGetObjValue(formObj.evi_tax_code);
			formParams+="&s_tax_naid_flg="+ComGetObjValue(formObj.s_tax_naid_flg);
			formParams+="&s_finance_flg="+ComGetObjValue(formObj.s_finance_flg);
			formParams+="&s_fa_flg="+ComGetObjValue(formObj.s_fa_flg);
			formParams+="&s_tax_type="+ComGetObjValue(formObj.s_tax_type);
			formParams+="&s_tax_nsl_flg="+ComGetObjValue(formObj.s_tax_nsl_flg);
			formParams+="&s_evi_inv_dt="+ComGetObjValue(formObj.s_evi_inv_dt);
			formParams+="&s_evi_comp_no="+ComGetObjValue(formObj.s_evi_comp_no);
			formParams+="&s_evi_total_net_amt="+ComGetObjValue(formObj.s_evi_total_net_amt);
			formParams+="&s_evi_tax_no2="+ComGetObjValue(formObj.s_evi_tax_no2);
			formParams+="&s_evi_total_tax_amt="+ComGetObjValue(formObj.s_evi_total_tax_amt);
			formParams+="&s_evi_ctnt1="+ComGetObjValue(formObj.s_evi_ctnt1);
			formParams+="&s_evi_ctnt2="+ComGetObjValue(formObj.s_evi_ctnt2);
			formParams+="&s_evi_ctnt3="+ComGetObjValue(formObj.s_evi_ctnt3);
			formParams+="&s_evi_ctnt4="+ComGetObjValue(formObj.s_evi_ctnt4);
			formParams+="&s_evi_ctnt5="+ComGetObjValue(formObj.s_evi_ctnt5);
			formParams+="&s_evi_ctnt6="+ComGetObjValue(formObj.s_evi_ctnt6);
			formParams+="&s_evi_ctnt7="+ComGetObjValue(formObj.s_evi_ctnt7);
			formParams+="&s_evi_ctnt8="+ComGetObjValue(formObj.s_evi_ctnt8);
			formParams+="&s_evi_ctnt9="+ComGetObjValue(formObj.s_evi_ctnt9);
			formParams+="&s_evi_ctnt10="+ComGetObjValue(formObj.s_evi_ctnt10);
			formParams+="&s_evi_ctnt11="+ComGetObjValue(formObj.s_evi_ctnt11);
			formParams+="&s_evi_ctnt12="+ComGetObjValue(formObj.s_evi_ctnt12);
			formParams+="&s_evi_tax_no="+ComGetObjValue(formObj.s_evi_tax_no);
			formParams+="&s_evi_tax_code="+ComGetObjValue(formObj.s_evi_tax_code);
			formParams+="&ttl_lss_div_cd="+ComGetObjValue(formObj.ttl_lss_div_cd);
			formParams+="&inv_rgst_no="+ComGetObjValue(formObj.inv_rgst_no);
			formParams+="&eviInputFlg="+ComGetObjValue(formObj.eviInputFlg);
			formParams+="&s_eviInputFlg="+ComGetObjValue(formObj.s_eviInputFlg);
			formParams+="&apopen="+ComGetObjValue(formObj.apopen);
			formParams+="&com_mrdPath="+ComGetObjValue(formObj.com_mrdPath);
			formParams+="&com_mrdArguments="+ComGetObjValue(formObj.com_mrdArguments);
			formParams+="&asa_no_s="+ComGetObjValue(formObj.asa_no_s);
			//formParams+="&aproSeqKey="+ComGetObjValue(formObj.aproSeqKey);
			formParams+="&key="+ComGetObjValue(formObj.key);
			formParams+="&cost_ofc_cd="+ComGetObjValue(formObj.cost_ofc_cd);
			formParams+="&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
			formParams+="&cnt_inv="+ComGetObjValue(formObj.cnt_inv);
			formParams+="&curr_cd="+ComGetObjValue(formObj.curr_cd);
			formParams+="&total_amt="+ComGetObjValue(formObj.total_amt);
			formParams+="&max_iss_dt="+ComGetObjValue(formObj.max_iss_dt);
			formParams+="&max_rcv_dt="+ComGetObjValue(formObj.max_rcv_dt);
			formParams+="&gen_pay_term_desc="+ComGetObjValue(formObj.gen_pay_term_desc);
			formParams+="&payment_due_dt="+ComGetObjValue(formObj.payment_due_dt);
			//formParams+="&apro_step="+ComGetObjValue(formObj.apro_step);
			formParams+="&csr_no="+ComGetObjValue(formObj.csr_no);
		    
		    var sXml = sheetObj.GetSearchXml("COM_CSR_0002GS.do", param+'&'+formParams);
		    formObj.csr_no.value = ComGetEtcData(sXml,"csr_no");

		    if(formObj.csr_no.value.length > 1 && formObj.csr_no.value != ""){
			    ///////////////onSaveEnd로직 
		    	//if (errMsg != "") return false; 
		    	showErrMessage('CSR has been created');
		    	
				var chkRow = sheetObj.FindCheckedRow ("chk");
				var arrRow = chkRow.split("|");
				for (var idx=0; idx<arrRow.length-1; idx++){  
					sheetObj.CellEditable(arrRow[idx] , "chk") = false;
					sheetObj.CellValue(arrRow[idx] , "chk") = 0;
					sheetObj.RowBackColor(arrRow[idx]) = sheetObj.RgbColor(128, 128, 128);
				}
		        deleteCheck();
				/*  'Approval Request'가 성공하면 일단 증빙 data는 다 초기화하고 다시 증빙을 하게 해야 한데이...  */
				//document.form.eviInputFlg.value = '';
				resetEviData();

				if(formObj.apopen.value == "Y"){
					formObj.apopen.value = "N";
					var previewFlg = "";
					var pre_curr_cd			= sheetObjects[1].CellValue(1,"pre_curr_cd");
			        if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY" || pre_curr_cd=="TWD"){
			         		previewFlg = "krjp";
			        }
	                sheetObjects[1].CellValue(1,"pre_csr_no") 	= formObj.csr_no.value;
	                //var apro_step_arr = document.form.apro_step.value.split("-");
	                //sheetObjects[1].CellValue(1,"apro_step") = apro_step_arr[0]; //2007-05-06  CSR DETAIL에서는 무조건 APRO_STEP을 보이지 않은다.
	                myWin = null;
	                //sheetObjects[0].RemoveAll();
					window.showModalDialog("/hanjin/COM_CSR_0006.do?previewFlg="+previewFlg+"&previewFlgYN=N", window, "dialogWidth:775px; dialogHeight:750px; help:no; status:no; scroll:no; resizable:no;");
				}
				
				//btn_files 버튼 빨간색으로 활성화, files 화면 팝업
				//ComBtnEnableRed("btn_files");
				//FilesPopup();
				
				//Approval Step지정을 하겠습니까? Yes면 CSR조회 화면으로 , No면 CSR을 계속 생성하도록 현재 화면
				var inv_sub_sys_cd  = document.form.inv_sub_sys_cd.value;
    			var inquiryUrl 		= "";
    			if(inv_sub_sys_cd == 'TLL') inv_sub_sys_cd = 'MNR';
    			
    			if(inv_sub_sys_cd == 'MNR'){
    				inquiryUrl = "EES_MNR_0302.do?INV_SUB_SYS_CD=MNR&MENU=Y&pgmNo=EES_MNR_0302&if_status=RA&csr_no="+formObj.csr_no.value;
    			}else if(inv_sub_sys_cd == 'CHS'){
    				inquiryUrl = "EES_CGM_1147.do?INV_SUB_SYS_CD=CHS&MENU=Y&pgmNo=EES_CGM_1147&if_status=RA&csr_no="+formObj.csr_no.value;
    			}else if(inv_sub_sys_cd == 'LSE'){
    				inquiryUrl = "EES_LSE_0042.do?INV_SUB_SYS_CD=LSE&MENU=Y&pgmNo=EES_LSE_0042&if_status=RA&csr_no="+formObj.csr_no.value;
    			}else if(inv_sub_sys_cd == 'PSO'){
    				inquiryUrl = "VOP_PSO_1002.do?INV_SUB_SYS_CD=PSO&MENU=Y&pgmNo=VOP_PSO_1002&if_status=RA&csr_no="+formObj.csr_no.value;
    			}else if(inv_sub_sys_cd == 'MGS'){
    				inquiryUrl = "EES_CGM_2207.do?INV_SUB_SYS_CD=MGS&MENU=Y&pgmNo=EES_CGM_2207&if_status=RA&csr_no="+formObj.csr_no.value;
    			}else if(inv_sub_sys_cd == 'CNI'){
    				inquiryUrl = "CPS_CNI_0047.do?INV_SUB_SYS_CD=CNI&MENU=Y&pgmNo=CPS_CNI_0047&if_status=RA&csr_no="+formObj.csr_no.value;
    			}
    			
    			/*16.01.06 SY SHIM CSR 결재 유형 변경 오피스 확인 로직 -> GW 결재가 없어졌으므로 해당 로직 주석처리 */
//			    var csrNo = formObj.csr_no.value;
//			    var aproTpParam = "f_cmd="+SEARCH03+"&csr_no="+csrNo;
//			    var sXml = sheetObj.GetSearchXml("COM_CSR_0002GS.do", aproTpParam);
//			    var chkOfc = ComGetEtcData(sXml,"CN_OFC_CHK");
//			    
//			    if(chkOfc == "Y"){
//			    	var csrNo = formObj.csr_no.value;
//	    			ComOpenPopup('/hanjin/COM_CSR_0016.do?csr_no='+csrNo, 300, 150, '', 'none', true);
//			    }
    			/*---------------------------------------------------*/
		        if(ComShowConfirm("Do you want to select Approval Step?")) {
		        	location.href = inquiryUrl;
		        }
			}
			break;
			
    	}
    }
    
    /**
     * Combo 기본 설정
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
  // combo object 초기화
     // combo object 초기화
     function initCombo(comboObj, comboNo) {
         var formObject = document.form
         switch(comboNo) {
         	case 1:
                 with (comboObj) {
      				MultiSelect 	= false;
      				UseAutoComplete = true;
      				SetColAlign("left|left");
      				SetColWidth("276|0");
     				ValidChar(2,0);//영문대문자만 입력가능
     				MaxLength		= 3;
       				DropHeight 		= 160;
       		    }
       			break;

         	case 2:
                 with (comboObj) {
      				MultiSelect 	= false;
      				UseAutoComplete = true;
      				SetColAlign("left|left");
      				SetColWidth("276|0");
     				ValidChar(2,0);//영문대문자만 입력가능
     				MaxLength		= 3;
       				DropHeight 		= 160;
       		    }
       			break;
         }
     }

    // 조회조건필드인 Lane SVC Type 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
	   switch(sAction) {

	      case IBSEARCH:

			if (sComboObj.id == "asa_no") {
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();

				formObj.f_cmd.value = sComboAction;
				//formObj.code.value = formObj.jo_crr_cd.text;
				//formObj.super_cd1.value = formObj.jo_crr_cd.text;
				var sXml = sheetObj.GetSearchXml("COM_CSR_0002GS.do", FormQueryString(formObj));
				//Trade setting comboItems
				var comboItems = ComGetEtcData(sXml, sComboKey).split("|");
				 if (comboItems[0] === ""){
					 formObj.asaListFlg.value  = "N"
				 }else{
					 formObj.asaListFlg.value  = "Y" 
				 }
				addComboItem(sComboObj,comboItems);
			}
	        break;
	   }
    }


    /**
     * 콤보필드에 데이터를 추가해준다.
     */
    function addComboItem(comboObj,comboItems) {
    	
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(",");
    		//alert("0:"+comboItem[0]);
    		//alert("1:"+comboItem[1]);
    		comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
    	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch (sAction) {
    		case IBCREATE: //저장용 조회
    		case IBSEARCH: //조회

    			break;

    		case IBSAVE:   //저장
    			var cnt = 0;
    			for (var inx=1; inx <= sheetObj.LastRow; inx++){
    				if (sheetObj.CellValue(inx, "ibflag") == "R")
    					continue;

    				cnt++;
    				/*
    				if (sheetObj.CellValue(inx, "vsl_cd").length < 4){
    					ComShowMessage("["+inx+"] Input a Vessel (length=4)");
    					sheetObj.SelectCell(inx, "vsl_cd", true);
    					return false;
    				}
    				if (sheetObj.CellValue(inx, "skd_voy_no").length < 4){
    					ComShowMessage("["+inx+"] Input a Voyage (length=4)");
    					sheetObj.SelectCell(inx, "skd_voy_no", true);
    					return false;
    				}
    				if (sheetObj.CellValue(inx, "skd_dir_cd").length < 1){
    					ComShowMessage("["+inx+"] Input a Direction (length=1)");
    					sheetObj.SelectCell(inx, "skd_dir_cd", true);
    					return false;
    				}
    				if (sheetObj.CellValue(inx, "rev_dir_cd").length < 1){
    					ComShowMessage("["+inx+"] Select a revenue direction");
    					sheetObj.SelectCell(inx, "rev_dir_cd", true);
    					return false;
    				}
    				if (sheetObj.CellValue(inx, "stl_locl_amt").length == 0){
    					ComShowMessage("["+inx+"] Input Amount.");
    					sheetObj.SelectCell(inx, "stl_locl_amt", true);
    					return false;
    				}
    				if (sheetObj.CellValue(inx, "ibflag")=="D" && sheetObj.CellValue(inx, "cre_dt") != ""){
    					ComShowMessage("["+inx+"] Cannot Remove the data because it has a slip number...["+sheetObj.CellValue(inx, "cre_dt")+"]");
    					sheetObj.SelectCell(inx, "del_chk", true);
    					return false;
    				}
    				*/
    			}

    			if (cnt==0){
    				ComShowMessage("There is no data to save");
    				return false;
    			}
    			break;
    	}
    	return true;
    }
    
    //Invoice Delete 여부 체크
    function isValidApproval(sheetObj){
    	var formObj = document.form;
    	var rtnVal= true;
    	
		formObj.f_cmd.value = SEARCH02;
		
		var param = sheetObj.GetSaveString(false,true,"chk");
		var sXml = sheetObj.GetSearchXml("COM_CSR_0002GS.do", param+"&"+FormQueryString(formObj),"",true);
		var inv_no= ComGetEtcData(sXml, "inv_no");
		if(inv_no !=""){
			ComShowMessage("Invoice status has been changed(INV NO:"+inv_no+")");
			rtnVal= false;			
		}
		return rtnVal;
    	
    }
    
     function sheet1_OnSearchEnd(sheetObj,errMsg){
    	 //2009-07-15 asaNoString, asaNoCurrCodeArr 는 로직상 주석해도 문제없을 것으로 보여 주석, apOfcCd는 COM_CSR_0001 앞단에서 받아오는 것으로 처리, csrNo 셋팅은 무의미한것으로 보임

         //var asaNoString = sheetObj.EtcData("asaNoString");
         //var csrNo = sheetObj.EtcData("csrNo");
         //var apOfcCd = sheetObj.EtcData("apOfcCd");
         //asaNoCurrCodeArr = sheetObj.EtcData("asaCurrCdstring").split("|");

         //document.form.csr_no.value = csrNo;
         //document.form.ap_ofc_cd.value = apOfcCd;
         /*
         for(p=0;p< comboObjects.length;p++){
             initCombo (comboObjects[p],p+1, asaNoString);
         }
		 */
 		/* eBilling - 원본 invoice를 조회 하는 button 보이기 여부 파악 */
 		sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
 		for (var i=1; i<=sheetObj.RowCount; i++) {
 			if (sheetObj.CellValue(i,'edi_flg')) {
 				edi_inv_yn = true;
 			}
 		}
 		if (edi_inv_yn){
 			document.all.EDILayer01.style.display = "inline";
 		} else {
 			document.all.EDILayer01.style.display = "none";
 		} 
     }

//    function sheet1_OnSaveEnd(sheetObj, errMsg){
//    	if (errMsg != "") return false; 
//    	showErrMessage(getMsg('CSR25021')); 
//    	/*
//		var csr_no = sheetObj.EtcData("csr_no");
//		document.form.csr_no.value = csr_no;
//		sheetObj.RemoveEtcData ();*/
//    	alert('1');
//		var chkRow = sheetObj.FindCheckedRow ("chk");
//		var arrRow = chkRow.split("|");
//		//for (idx=0; idx<arrRow.length-1; idx++){
//		for (var idx=0; idx<arrRow.length; idx++){  
//			alert('2');
//			sheetObj.CellEditable(arrRow[idx] , "chk") = false;
//			sheetObj.CellValue(arrRow[idx] , "chk") = 0;
//			sheetObj.RowBackColor(arrRow[idx]) = sheetObj.RgbColor(128, 128, 128);
//		}
//        deleteCheck(); 
//		/*  'Approval Request'가 성공하면 일단 증빙 data는 다 초기화하고 다시 증빙을 하게 해야 한데이...  */
//		//document.form.eviInputFlg.value = '';
//		resetEviData();
//
//		 if ( myWin != null){
//             if(!myWin.closed){
//                    sheetObjects[1].CellValue(1,"pre_csr_no") 	= csr_no;
//                    var apro_step_arr = document.form.apro_step.value.split("-");
////                    sheetObjects[1].CellValue(1,"apro_step") = apro_step_arr[0]; //2007-05-06  CSR DETAIL에서는 무조건 APRO_STEP을 보이지 않은다.
//                    myWin = null;
//                    //sheetObjects[0].RemoveAll();
//					//if (errMsg==null || errMsg.trim()==''){
//					//	noRtnPopup('COM_CSR_0006.do?previewFlgYN=Y', 'width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0');
//					//}
//             }
//         }//else{
//          	//sheetObjects[0].RemoveAll();
//          	//deleteCheck();
//        		//showErrMessage(getMsg('CSR25021'));
//
//         //}
//    }


	function asa_no_OnComboClick(Row, Col, Value){
		
		alert('asa_no_OnClick');
		
	}
	
	function asa_no_OnComboChange(Row, Col, sCode, sText){
		
		alert('asa_no_OnComboChange');
		
	}	

    function sheet1_OnChange(sheetObj , row , col, value)
    {
    	
    	var formObj = document.form;
		var sName 	= sheetObj.ColSaveName(col);
		var rows 	= sheetObj.Rows;
		var pi 		= 0;
		
		//기존 로직 
		if (sName == "chk") {
			resetEviData();
		   	 
   			if(row > 0 && row < rows) {
   				if(sheetObj.cellvalue(row,"chk") == 1) {	 //Check
   					document.form.csr_no.value = "";
   					//버튼 활성
   					//doActionBtnEnable('S');
   					
   					//btn_files 버튼 비활성화
   					//ComBtnDisable("btn_files");
   					
   				}
   			}
		}
		
        var chkRow 			= sheetObj.FindCheckedRow (1);
        var arrRow 			= chkRow.split("|");
        var chkRowCount 	= 0;
        var chkRowCount2 	= 0; 	/* checkbox checked 상태갯수(chkRowCount) 맨마지막에 1회 Event발생을 위한 변수 */
        
        var maxIss 			= 0;
        var maxRcv 			= 0;
        var total_amt 		= 0;
        var vat_amt   		= 0;
        //PSO 전도금 관련 변수
        var pso_trns_slp_ctnt_var 	= "";
        var pay_due_dt 				= 0;
        var maxPayDueDt 			= 0;
        
        /* checkbox checked 상태갯수추출을 위한 loop */
        for (inx=0; inx<arrRow.length-1; inx++)
        {
	          chkRowCount2++;
        }        
        
        //alert('chkRowCount2 ==> '+ chkRowCount2);
        
        for (idx=0; idx<arrRow.length-1; idx++)
        {
	          var iss_dt_var 		=  ComGetUnMaskedValue( sheetObj.Cellvalue( arrRow[idx] , "iss_dt")		, "ymdhms", "-");
	          var rcv_dt     		=  ComGetUnMaskedValue( sheetObj.Cellvalue( arrRow[idx] , "rcv_dt")		, "ymdhms", "-");
	          //PSO 관련
	          pso_trns_slp_ctnt_var =  sheetObj.Cellvalue( arrRow[idx] , "pso_trns_slp_ctnt");
	          var pay_due_dt 		=  ComGetUnMaskedValue( sheetObj.Cellvalue( arrRow[idx] , "pay_due_dt")	, "ymdhms", "-");
	          
	          if(maxPayDueDt < pay_due_dt){
	        	  maxPayDueDt =  pay_due_dt;
	          }

	          if( maxIss < iss_dt_var)
	          {
	              maxIss =  iss_dt_var;
	          }
	          
	          if( maxRcv < rcv_dt)
	          {
	              maxRcv =  rcv_dt;
	          }

	          total_amt = parseFloat(sheetObj.CellValue( arrRow[idx],"inv_ttl_amt")*100)+parseFloat(total_amt)*100;
	          vat_amt   = parseFloat(sheetObj.CellValue( arrRow[idx],"inv_vat_amt")*100)+parseFloat(vat_amt)*100;
	          total_amt = total_amt/100;
	          vat_amt   = vat_amt/100 ;
	          chkRowCount++;
	          
	          

	          

        }
        
        
        
    	  //alert('chkRowCount2 ==> '+ chkRowCount2);
      	  //alert('chkRowCount ==> '+ chkRowCount);
      	  
        
        if(chkRowCount2 == chkRowCount){

      	  
      	  //alert('iss_dt_var => '+iss_dt_var+', maxIss => '+maxIss);
      	  doActionIBCombo(sheetObjects[0], document.form ,IBSEARCH , comboObjects[0], SEARCHLIST01, "asa_no");
        }        

        //--::JSK::--//
        //alert('iss_dt_var => '+iss_dt_var+', maxIss => '+maxIss);
        
        //--::jsk::--doActionIBCombo(sheetObjects[0] , document.form ,IBSEARCH , comboObjects[0], SEARCHLIST01 ,"asa_no");
        

        if ( maxIss == "0")  maxIss ="";
        if ( maxRcv == "0")  maxRcv ="";
        if ( chkRowCount == "0")  chkRowCount ="";

        formObj.max_iss_dt.value = maxIss;
        formObj.max_rcv_dt.value = maxRcv;
        
        var pre_curr_cd = document.form.curr_cd.value;
        
		if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY" || pre_curr_cd=="TWD"){
			 formObj.total_amt.value = roundXL(total_amt, 2);
			 formObj.total_amt.value  = ComAddComma(total_amt);
		}else{
			 formObj.total_amt.value = csr_chkAmtFmt(roundXL(total_amt, 2));
		}
        
        ComReplaceStr(formObj.max_iss_dt,"-","");
        ComReplaceStr(formObj.max_rcv_dt,"-","");
         
        formObj.cnt_inv.value = chkRowCount;

        var total_amt = ComReplaceStr(formObj.total_amt,",","");
       
        if(total_amt >= 0){
				formObj.csr_tp_cd.value = "S";
		}else{
				formObj.csr_tp_cd.value = "C";
		}
        
        var gen_pay_term_cd = formObj.gen_pay_term_cd.value;
        
        if(pso_trns_slp_ctnt_var == "GO"){	//전도금인 경우
        	formObj.pso_trns_slp_ctnt_var.value = pso_trns_slp_ctnt_var;
        	formObj.payment_due_dt.value = maxPayDueDt;
        }else{
	        if(gen_pay_term_cd == "IN"){
	        	formObj.payment_due_dt.value = getAddDate(formObj.max_iss_dt.value, 5);
	        }else if(gen_pay_term_cd == "OUT"){
	        	formObj.payment_due_dt.value = getAddDate(formObj.max_iss_dt.value, 60);
	        }else  if(gen_pay_term_cd == "" || gen_pay_term_cd == "O60" || gen_pay_term_cd == "O45"){
	        	formObj.payment_due_dt.value = maxIss;
	        	//formObj.gen_pay_term_desc.value = 0;
	        }else{
	        	formObj.payment_due_dt.value = getAddDate(formObj.max_iss_dt.value, Number(gen_pay_term_cd));
	        	
	    		var sFromDate = formObj.max_iss_dt.value;
	    		var sToDate   = formObj.payment_due_dt.value; 
				var gen_pay_term_desc = ComGetDaysBetween(sFromDate, sToDate);
				formObj.gen_pay_term_desc.value = gen_pay_term_desc;
	        }
        }
        
        var sToDate = ComGetMaskedValue(formObj.payment_due_dt.value, "ymd");
        formObj.payment_due_dt.value = sToDate; 
        
        maxIss = ComGetMaskedValue( maxIss, "ymd");
        maxRcv = ComGetMaskedValue( maxRcv, "ymd");
        formObj.max_iss_dt.value = maxIss;
        formObj.max_rcv_dt.value = maxRcv;
        
	    formObj.inv_rgst_no.value = sheetObj.CellValue(row,"inv_rgst_no");
	    
    	var asanogb = formObj.asanogb.value;
        var currCd = formObj.curr_cd.value;
        if(asanogb=="A/P" && cnt_cd=="KR" && currCd == "KRW"){ //원화이면서 한국지역인경우엔 기타 -> 증빙없음
			document.form.evi_gb1.options[0].selected = true ;
			document.form.evi_gb1.disabled = false;
			eviGbSelect(1);
        }else if(asanogb=="A/P" && cnt_cd=="KR" && currCd != "KRW"){
			document.form.evi_gb1.options[2].selected = true ;
			document.form.evi_gb1.disabled = true;
			eviGbSelect(1);
        }
        
        /******************************************TLL로직 START**********************************************/
	    if(formObj.inv_sub_sys_cd.value == "TLL" || (formObj.inv_sub_sys_cd.value == "CNI" && sheetObj.CellValue(row,"ttl_lss_div_cd") == "CP") || (formObj.inv_sub_sys_cd.value == "CNI" && formObj.csr_tp_cd.value == "C")){  
		  	formObj.ttl_lss_div_cd.value = sheetObj.CellValue(row,"ttl_lss_div_cd");
		  	var ttl_lss_div_cd = formObj.ttl_lss_div_cd.value;
		  	
		  	if(ttl_lss_div_cd == "PO" || ttl_lss_div_cd == "PL" || ttl_lss_div_cd == "CP"){
		  		formObj.csr_tp_cd.value = "P";
		  	}
			/* 
			 * 1 PO PL GO GL 한건만 선택
			 * 2 CNI모듈이면서 ttl_lss_div_cd가 CP인 경우도 한건만 선택 (2010-02-12)
			 */	
		   	 switch (sName) {
		   	 //1 
		   		case "chk" : 
		   			if(row > 0 && row < rows) {
		   				if(sheetObj.cellvalue(row,"chk") == 0) {	//unCheck
		         			for(var i=0; i < rows; i++ ){
		         				if(i!=row){
		             				sheetObj.CellEditable(i,"chk") = true; 
		         				}
		         			}
	   						return;
		   				}
		   				if(sheetObj.cellvalue(row,"chk") == 1) {	 //Check
		           			for(var i=0; i < rows; i++ ){
		           				if(i!=row){
		           					sheetObj.CellEditable(i,"chk") = false; 
		           					
		             				document.form.evi_gb1.options[2].selected = true ;
		             				document.form.evi_gb1.disabled = true;
		            				eviGbSelect(1);
		           				}
		           			}
		   					return;
		   				}
		   			}
		   			break;
		   	 }
	    }
	    /******************************************TLL로직 END**********************************************/
    
    } 

    function sheet3_OnSearchEnd(sheetObj,errMsg){
		var srcName = window.event.srcElement.getAttribute("name");
        var previewFlg      	= "";
		var pre_csr_no			= sheetObjects[1].CellValue(1,"pre_csr_no");
		var pre_office			= document.form.cost_ofc_cd.value; //sheetObjects[1].CellValue(1,"pre_office");
		var pre_prpd_dy			= sheetObjects[1].CellValue(1,"pre_prpd_dy");
		var pre_pay_to			= sheetObjects[1].CellValue(1,"pre_pay_to");
		var pre_csr_type		= sheetObjects[1].CellValue(1,"pre_csr_type");
		var pre_desc			= sheetObjects[1].CellValue(1,"pre_desc"); 
		var pre_pay_group		= sheetObjects[1].CellValue(1,"pre_pay_group");
		var pre_evi_tp			= sheetObjects[1].CellValue(1,"pre_evi_tp");
		var pre_due_date		= sheetObjects[1].CellValue(1,"pre_due_date");
		//var apro_step			= sheetObjects[1].CellValue(1,"apro_step");
		if(document.form.asa_no.value != "" || comboObjects[0].Code != ""){
			var pre_asa_no	= document.form.asa_no_s.value; //comboObjects[0].Code;
		}else{
			var pre_asa_no	= sheetObjects[1].CellValue(1,"pre_asa_no");
		}
		var pre_inv_dt			= sheetObjects[1].CellValue(1,"pre_inv_dt");
		var pre_curr_cd			= sheetObjects[1].CellValue(1,"pre_curr_cd");
		var pre_amt				= sheetObjects[1].CellValue(1,"pre_amt");
		// CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)
		var chk_addr1	    	= sheetObjects[1].CellValue(1,"chk_addr1");
		var chk_addr2	    	= sheetObjects[1].CellValue(1,"chk_addr2");
		var chk_addr3	    	= sheetObjects[1].CellValue(1,"chk_addr3");
		var chk_cty_nm	    	= sheetObjects[1].CellValue(1,"chk_cty_nm");
		var chk_ste_cd	    	= sheetObjects[1].CellValue(1,"chk_ste_cd");
		var chk_zip_cd	    	= sheetObjects[1].CellValue(1,"chk_zip_cd");
		var chk_cnt_cd	    	= sheetObjects[1].CellValue(1,"chk_cnt_cd");
		var pre_evi_tp_count    = "";
		var pre_title			= "";
		
		pre_due_date  =  document.form.payment_due_dt.value;
/*
		if(pre_amt==0 || comboObjects[0].Code != ""){
				pre_title  = "TRANSFER SLIP";
		}else{
				pre_title  = "CONSULTATION SLIP";
		}
*/
		pre_title  = "CONSULTATION SLIP";
		var pre_evi_tp

		if(cnt_cd =="KR"){
				pre_evi_tp_count ="1";
				pre_evi_tp  = pre_evi_tp;
		}else{
				var sRow = sheetObjects[0].FindCheckedRow(1);
				var arrRow = sRow.split("|");
				pre_evi_tp_count =arrRow.length-1;

				pre_evi_tp = pre_evi_tp+"/"+pre_evi_tp_count;
		}

		if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY" || pre_curr_cd=="TWD"){
				pre_amt = pre_amt;
		}else{
				pre_amt = csr_chkAmtFmt(pre_amt);
		}

        if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY" || pre_curr_cd=="TWD"){
         		previewFlg = "krjp";
        }
        
		sheetObjects[1].RemoveAll();

		sheetObjects[1].DataInsert(-1);

        if(srcName=="btn_preview"){
         		pre_csr_no  = "";
        }

        sheetObjects[1].CellValue(1,"pre_csr_no") 	= pre_csr_no;
        sheetObjects[1].CellValue(1,"pre_office") 	= pre_office;
        sheetObjects[1].CellValue(1,"pre_prpd_dy") 	= pre_prpd_dy;
        sheetObjects[1].CellValue(1,"pre_pay_to") 	= pre_pay_to;
        sheetObjects[1].CellValue(1,"pre_csr_type") = pre_csr_type;
        sheetObjects[1].CellValue(1,"pre_desc") 	= pre_desc;
        sheetObjects[1].CellValue(1,"pre_pay_group")= pre_pay_group;
        sheetObjects[1].CellValue(1,"pre_evi_tp") 	= pre_evi_tp;
        sheetObjects[1].CellValue(1,"pre_due_date") = pre_due_date;
        sheetObjects[1].CellValue(1,"pre_asa_no") 	= pre_asa_no;
        sheetObjects[1].CellValue(1,"pre_inv_dt") 	= pre_inv_dt;
        sheetObjects[1].CellValue(1,"pre_curr_cd") 	= pre_curr_cd;
        sheetObjects[1].CellValue(1,"pre_amt") 	    = ComReplaceStr(pre_amt,",","");
        sheetObjects[1].CellValue(1,"pre_title") 	= pre_title;
		// CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)
        sheetObjects[1].CellValue(1,"chk_addr1")    = chk_addr1;
        sheetObjects[1].CellValue(1,"chk_addr2")    = chk_addr2;
        sheetObjects[1].CellValue(1,"chk_addr3")    = chk_addr3;
        sheetObjects[1].CellValue(1,"chk_cty_nm")   = chk_cty_nm;
        sheetObjects[1].CellValue(1,"chk_ste_cd")   = chk_ste_cd;
        sheetObjects[1].CellValue(1,"chk_zip_cd")   = chk_zip_cd;
        sheetObjects[1].CellValue(1,"chk_cnt_cd")   = chk_cnt_cd;
        //sheetObjects[1].CellValue(1,"apro_step")    = apro_step;
        /**
        for(var i = 0;i<sheetObjects[2].Rowcount;i++){
         		sheetObjects[2].CellValue(i+1,"pre_debit") = csr_chkAmtFmt(sheetObjects[2].CellValue(i+1,"pre_debit"));
         		sheetObjects[2].CellValue(i+1,"pre_credit") = csr_chkAmtFmt(sheetObjects[2].CellValue(i+1,"pre_credit"));
        }
        **/
		if (errMsg==null || errMsg.trim()==''){
			window.showModalDialog("/hanjin/COM_CSR_0006.do?previewFlg="+previewFlg+"&previewFlgYN=Y", window, "dialogWidth:775px; dialogHeight:750px; help:no; status:no; scroll:no; resizable:no;");
		}
		 
    }

    function approvalrequest(){
 		var sheetObject = sheetObjects[0];
 		var formObject = document.form;

 			/*
			if(formObject.apro_step.value==""){
					showErrMessage(getMsg('CSR25020'));
					return false;
			}
			*/

			if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){
					showErrMessage(getMsg('CSR25001'));
					return false;
			}

			//if(formObject.asanogb.value=="A/P" && formObject.cnt_cd.value=="KR"){
			//if(formObject.asanogb.value=="A/P"){
			if(cnt_cd=="KR"){
					if(formObject.evi_gb.value == ""){
							showErrMessage(getMsg('CSR25002'));
							return false;
					}else{
							if(formObject.evi_gb.value!="3"){
									if(document.form.eviInputFlg.value == "" && document.form.s_eviInputFlg.value == ""){
											showErrMessage(getMsg('CSR25003'));
											return false;
									}
							}
					}
			}
			//zu_openRunning(true);

			var csr_amt=0;
			for(var i=0;i<sheetObject.RowCount;i++){
					if(sheetObject.CellValue(i+1,1)==1){
							csr_amt = parseFloat(sheetObject.CellValue(i+1,"inv_ttl_amt")*100)+parseFloat(csr_amt);
					}
			}
			formObject.csr_amt.value=roundXL((csr_amt/100), 2);

			eviData();
			
			formObject.apopen.value="Y";
			doActionIBSheet1(sheetObject,formObject,IBSAVE);

			//zu_openRunning(false);
    }
			
    function roundXL(n, digits) {
	  if (digits >= 0) return parseFloat(n.toFixed(digits)); // 소수부 반올림
	
	  digits = Math.pow(10, digits); // 정수부 반올림
	  var t = Math.round(n * digits) / digits;
	
	  return parseFloat(t.toFixed(0));
    }

 	function eviGbSelect(evi_gb){
 		var formObj = document.form;
 		
 		if(evi_gb==1){
 			formObj.evi_gb.value=formObj.evi_gb1.value;
 		}else if(evi_gb==2){
			formObj.evi_gb.value=formObj.evi_gb2.value;
 		} 
 		
		//전자&종이 계산서 리셋
		formObj.attr_ctnt8.value        = "";
 		
 		/*
 		if(formObj.evi_ctnt1.value!="" && evi_gb ==1){
 			var gb = confirm("증빙구분을 변경하면 이미 저장되어 있는 정보가 삭제 됩니다.\n\n증빙구분을 변경하시겠습니까?");
 		}

 		if(gb){
				formObj.tax_naid_flg.value      = "";
				formObj.finance_flg.value       = "";
				formObj.fa_flg.value            = "";
				formObj.tax_type.value          = "";
				formObj.tax_nsl_flg.value       = "";
				
				formObj.s_tax_naid_flg.value    = "";
				formObj.s_finance_flg.value	  	= "";
				formObj.s_fa_flg.value		  	= "";
				formObj.s_tax_type.value		= "";
				formObj.s_tax_nsl_flg.value     = "";

				formObj.evi_inv_dt.value        = "";
				formObj.evi_comp_no.value       = "";
				formObj.evi_total_net_amt.value = "";
				formObj.evi_tax_no2.value       = "";
				formObj.evi_total_tax_amt.value = "";
				formObj.evi_ctnt1.value         = "";
				formObj.evi_ctnt2.value         = "";
				formObj.evi_ctnt3.value         = "";
				formObj.evi_ctnt4.value         = "";
				formObj.evi_ctnt5.value         = "";
				formObj.evi_ctnt6.value         = "";
				formObj.evi_ctnt7.value         = "";
				formObj.evi_ctnt8.value         = "";
				formObj.evi_ctnt9.value         = "";
				formObj.evi_ctnt10.value        = "";
				formObj.evi_ctnt11.value        = "";
				formObj.evi_ctnt12.value        = "";
				formObj.evi_tax_no.value        = "";
				formObj.evi_tax_code.value		= "";
				
		}else{
				return false;
		}
		*/
	}

	function resetEviData(){ 
		var formObj = document.form;
 
		formObj.eviInputFlg.value = '';

		formObj.tax_naid_flg.value      = '';
		formObj.finance_flg.value       = '';
		formObj.fa_flg.value            = '';
		formObj.tax_type.value          = '';
		formObj.tax_nsl_flg.value       = '';

		formObj.s_tax_naid_flg.value    = '';
		formObj.s_finance_flg.value	  	= '';
		formObj.s_fa_flg.value		  	= '';
		formObj.s_tax_type.value		= '';
		formObj.s_tax_nsl_flg.value     = '';
		
		//전자&종이 계산서 리셋
		formObj.attr_ctnt8.value        = "";
		
		for (var i = 0; i < formObj.elements.length; i++){
			try {
				if ((formObj.elements[i].name.length >= 4 && formObj.elements[i].name.substring(0,4) == 'evi_') ||
					(formObj.elements[i].name.length >= 6 && formObj.elements[i].name.substring(0,6) == 's_evi_'))
				{
					formObj.elements[i].value = '';
				}
			}
			catch (e){
				//ComShowMessage(e); //여길 그냥 통과해야 한다..
			}
		}
		
	} 
	
 	function eviData(){
 		if(	document.form.evi_gb.value==2){

					document.form.tax_naid_flg.value      = document.form.s_tax_naid_flg.value;
					document.form.finance_flg.value       = document.form.s_finance_flg.value ;
					document.form.fa_flg.value            = document.form.s_fa_flg.value;
					document.form.tax_type.value          = document.form.s_tax_type.value;
					document.form.tax_nsl_flg.value       = document.form.s_tax_nsl_flg.value;

					document.form.evi_inv_dt.value        = document.form.s_evi_inv_dt.value;
					document.form.evi_comp_no.value       = document.form.s_evi_comp_no.value;
					document.form.evi_total_net_amt.value = document.form.s_evi_total_net_amt.value;
					document.form.evi_tax_no2.value       = document.form.s_evi_tax_no2.value;
					document.form.evi_total_tax_amt.value = document.form.s_evi_total_tax_amt.value;
					document.form.evi_ctnt1.value         = document.form.s_evi_ctnt1.value;
					document.form.evi_ctnt2.value         = document.form.s_evi_ctnt2.value;
					document.form.evi_ctnt3.value         = document.form.s_evi_ctnt3.value;
					document.form.evi_ctnt4.value         = document.form.s_evi_ctnt4.value;
					document.form.evi_ctnt5.value         = document.form.s_evi_ctnt5.value;
					document.form.evi_ctnt6.value         = document.form.s_evi_ctnt6.value;
					document.form.evi_ctnt7.value         = document.form.s_evi_ctnt7.value;
					document.form.evi_ctnt8.value         = document.form.s_evi_ctnt8.value;
					document.form.evi_ctnt9.value         = document.form.s_evi_ctnt9.value;
					document.form.evi_ctnt10.value        = document.form.s_evi_ctnt10.value;
					document.form.evi_ctnt11.value        = document.form.s_evi_ctnt11.value;
					document.form.evi_ctnt12.value        = document.form.s_evi_ctnt12.value;
					document.form.evi_tax_no.value        = document.form.s_evi_tax_no.value;
					document.form.evi_tax_code.value		 	= document.form.s_evi_tax_code.value;

 		}

}

	function validateDateObj(obj){
		if (obj.readOnly==true){return false;}
		obj.value = obj.value.trim();
		if (obj.value==null || obj.value.trim()==''){return false;}
		if (!checkPeriodFormat(obj.value) || !csr_isValidDateObject(obj.value,'-')){
			showErrMessage(getMsg('CSR23011'));	//showErrMessage('날짜 형식이 잘못되었습니다.');
			obj.focus();
			return false;
		}
		return true;
	}

	function validateDateObj2(obj){
		if (obj.readOnly==true){return false;}
		obj.value = obj.value.trim();
		if (obj.value==null || obj.value.trim()==''){return false;}
		if (!checkPeriodFormat(obj.value) || !csr_isValidDateObject(obj.value,'-')){
			showErrMessage(getMsg('CSR23011'));	//showErrMessage('날짜 형식이 잘못되었습니다.');//
			obj.focus();
			return false;
		}
		var formObj = document.form;
		/*****************************************************************************************
			payment_due_dt가 입력가능한 경우는 gen_pay_term_cd가 영문대문자 'O'로 시작하는 경우가 아닌 경우 뿐이며,
			MAX_ISS_DT 이전 날짜나 100이상날짜도 허용하지 않는다.
		*****************************************************************************************/
		
		if(formObj.pso_trns_slp_ctnt_var.value == "GO"){	//전도금인경우 
			if (formObj.max_iss_dt.value!=null && formObj.max_iss_dt.value.trim()!='' &&
			formObj.payment_due_dt.value!=null && formObj.payment_due_dt.value.trim()!=''){
				if (getDaysBetween2(formObj.max_iss_dt.value, formObj.payment_due_dt.value) > 100){
					formObj.payment_due_dt.value = getAddDate(formObj.max_iss_dt.value, 100);
				}
				
				if(getDaysBetween2(formObj.max_iss_dt.value, formObj.payment_due_dt.value) > 0){
					formObj.gen_pay_term_cd.value	= getDaysBetween2(formObj.max_iss_dt.value, formObj.payment_due_dt.value);
					formObj.gen_pay_term_desc.value = getDaysBetween2(formObj.max_iss_dt.value, formObj.payment_due_dt.value);
				}
			}
	
		}else{
		
			if (formObj.max_iss_dt.value!=null && formObj.max_iss_dt.value.trim()!='' &&
			formObj.payment_due_dt.value!=null && formObj.payment_due_dt.value.trim()!=''){
				if (getDaysBetween2(formObj.max_iss_dt.value, formObj.payment_due_dt.value) < 0){
					formObj.payment_due_dt.value = formObj.max_iss_dt.value;
				}
				if (getDaysBetween2(formObj.max_iss_dt.value, formObj.payment_due_dt.value) > 100){
					formObj.payment_due_dt.value = getAddDate(formObj.max_iss_dt.value, 100);
				}
				formObj.gen_pay_term_cd.value	= getDaysBetween2(formObj.max_iss_dt.value, formObj.payment_due_dt.value);
				formObj.gen_pay_term_desc.value = getDaysBetween2(formObj.max_iss_dt.value, formObj.payment_due_dt.value);
			}
	
			if (formObj.max_iss_dt.value!=null && formObj.max_iss_dt.value.trim()!='' &&
				formObj.payment_due_dt.value!=null && formObj.payment_due_dt.value.trim()!='' &&
				!isValIssDueDt()){
				showErrMessage('Issue date must be earlier than payment due date.');	//showErrMessage('Issue date이 payment due date보다 작거나 같아야 합니다.');
				return false;
			}
		}

		return true;
	}

	function isValIssDueDt(){
		var str_issDt = document.form.max_iss_dt.value.replace(/-/gi,'');
		var str_dueDt = document.form.payment_due_dt.value.replace(/-/gi,'');
		if (isNaN(str_issDt) || isNaN(str_dueDt) || str_issDt.trim().length!=8 || str_dueDt.trim().length!=8) {
			return false;
		}
		if (parseInt(str_issDt,10) - parseInt(str_dueDt,10) > 0){
			return false;
		}
		return true;
	}

	function checkPeriodFormat(prd_dt){
		var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
		if (!csr_checkFormat2(prd_dt, date_regexp)){	return false;
		} else { return true;
		}
	}

	function deleteCheck(){
		var k = 0;

 	  for(var i=0;i<sheetObjects[0].RowCount;i++){
		if(sheetObjects[0].CellValue(i+1,1)==1){
			sheetObjects[0].RowDelete(i+1, false);
			k++;
			i = i-k;
		}
 	  }

 	  if(sheetObjects[0].RowCount==0){
 	  		approvalFlg  = "Y";
 	  }
	}

	 function initRdConfig(rdObject){
	     var Rdviewer = rdObject ;
	     Rdviewer.style.height = 0;
	     Rdviewer.AutoAdjust = true;
	     Rdviewer.ViewShowMode(0);
	     Rdviewer.setbackgroundcolor(128,128,128);
	     Rdviewer.SetPageLineColor(128,128,128);
	 }

	 function rdOpen(rdObject,formObject){
	     var formObj = document.form;
	     //rdObj[0] = sheetObjects[0];
	     var Rdviewer = rdObject ;

	     queryStr="";

	    if( !setQueryStr() ){
	         return;
	    }

	     var rdParam = '/rp '+queryStr;
	     var strServer = "";
	     var realYn = true;
	     /*
	     if (realYn){
	         strServer = RD_path;
	     }else{
	         strServer = "http://localhost:7001/hanjin/"
	     }*/
	    //로컬테스트
	     //var strPath   =  "http://localhost:7001/hanjin/bizcommon/csr/consultationsliprequestmgt/consultationsliprequestmgt/report/COM_CSR_0012.mrd";
	    //Real
	    var strPath   =  "/bizcommon/csr/consultationsliprequestmgt/consultationsliprequestmgt/report/COM_CSR_0012.mrd";
	    // 열고자 하는 RD 파일을 지정한다.
	    // Rdviewer.FileOpen( strPath, RDServerBAT + rdParam);
	    formObject.com_mrdPath.value = strPath;
	    formObject.com_mrdArguments.value = rdParam;
	    ComOpenRDPopup();

	     //Rdviewer.CMPrint();
	     //Rdviewer.PrintDialog();
	 }

	 function setQueryStr(){
		 var formObj = document.form;

	     queryStr += " ["+formObj.cost_ofc_cd.value+"]";
	     queryStr += " [TESTDT]";
	     queryStr += " ["+formObj.vndr_seq.value+"]";

	     return true;
	 }
	 
	 function UF_getBackEndJobStatus() {
			//alert("UF_getBackEndJobStatus");
			doActionIBSheet1(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	}
	 
 /*
  * 2013.02.12 조인영 [CHM-201322900]
  * Cost Office, Log-in Office Radio 버튼 클릭시 Approval Step 변경
  * 2014.09.29 Kim Young Shin [CHM-201432136] 
  * Approval Step을 사용하지 않으므로 OnChange에서 사용하지 않음
  */
 /*
 function ofcChange(){
 	var formObj = document.form;

 	var apro_step = "";
 	var aproSeqKey = "";
 	if(formObj.ofc_tp[0].checked){
 		apro_step = formObj.cost_apro_step.value;
 		aproSeqKey = formObj.cost_aproSeqKey.value;
 	}else if (formObj.ofc_tp[1].checked){
 		apro_step = formObj.login_apro_step.value;
 		aproSeqKey = formObj.login_aproSeqKey.value;
 	}
 	formObj.apro_step.value = apro_step;
 	formObj.aproSeqKey.value = aproSeqKey;
 }*/
 
 	/**
	 * 버튼의 스타일을 red색의 Enable 상태로 한다.  <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    ComBtnEnableRed("btn_add") //btn_add 버튼을 red색으로 Enable
	 * </pre>
	 * @param {string} name   필수, 버튼 name 문자열
	 * @returns 없슴
	 * @see #ComBtnDisable
	 */
 	function ComBtnEnableRed(name) {
		var tds = document.getElementsByTagName("td"); 
		for ( var i = 0; i < tds.length; i++) { 
			var td = tds[i];
			if (td.className.length > 0 && td.name == "no_"+name) {				
				if (td.className.indexOf('_1') > 0) 					
					td.className = td.className.replace(/_1/i, "_3");
				td.name=name; 
			}
		}
 	}
 	
 	/**
     * 메시지 표시한다. alert()함수 대신 이 함수를 사용한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     CsrComShowWarningMessage(errMsg);  //메시지를 표시한다.
     * errMsg = APP<||>CSR10014<||>W<||>Please select one more approval step.<||>
 	 * # Warning Type : APP(CSR10014)
 	 * # Warning Message : Please select one more approval step.
     * <pre>
     * @param {string} sMsg 필수,메시지 문자열
     * @return 없음
     * @see #ComShowCodeMessage
     */	
    function CsrComShowWarningMessage(sMsg)
    {
        try {
            if (sMsg.length < 1) return;
            
            var msgArr = sMsg.split("<||>");
            var msgStr = "# Warning Type : "+msgArr[0]+"("+msgArr[1]+")"+"\n"+"# Warning Message : "+msgArr[3];           
            alert(msgStr);
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
	 * Files management 화면을 popup 한다. <br>
	 * 
	 * @returns 없슴
	 * @see #FilesOpen
	 */
 	function FilesPopup() {
	    var height = screen.height; 
		var width = screen.width;
	                      
		var w = 800;
	    var h = 500;
	    var leftpos = width/2 - w/2; 
		var toppos = height/2 - h/2; 
		if(leftpos<0) leftpos=0;
		if(toppos<0) toppos=0;
		
	    var url = "/hanjin/COM_CSR_0021.do?csr_no="+document.form.csr_no.value;
	    window.open(url, "stepPop", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);
	    //ComOpenPopup(url, w, h, "", "1,0,1,1,1", true);
 	}
	/* 개발자 작업  끝 */