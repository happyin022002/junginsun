/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_8005.js
*@FileTitle : Break Bulk Cargo Pricing Application
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.12 문동선
* 1.0 Creation
=========================================================
* History 
* 2013.06.26 이혜민 [CHM-201325215] Special cargo Quotation System 수정 요청 - Approval, Application 화면에 Approver Name 추가, Request ID는 Requester Name으로 변경, Application 필수 입력 사항 추가-Sales rep/Customer/Commodity
* 2013.06.27 송호진 [CHM-201324720] Special Cargo Quotation System 수정 - C/Offer 확인 메시지표시. BB 화면 Text 변경
* 2013.07.03 송호진 [CHM-201324872] Counter Offer Cancel 기능 추가
* 2013.07.25 송호진 [CHM-201325102] Approval Cancel 기능 추가
* 2013.08.12 송호진 [CHM-201325335] Container Type & Q'ty 정보 Historical 관리 & Route 별 비용 Local Currency 적용
* 2014.03.20 송호진 [CHM-201429287] Request 이후 Send Mail Enable 되도록 수정 
* 2014.04.01 송호진 [CHM-201429302] SCQ내 BB cargo application의 Excel 변환 기능 개발 요청
* 2014.09.11 송호진 [CHM-201431718] SCQ System 기능 추가 개발 요청 - Actual Customer란
* 2015.01.20 송호진 [CHM-201432778] SCQ AWK/BB Cargo application에서 Approval Office 선택에 대한 제한 설정
* 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
* 2015.08.23 최성환 [CHM-201537109] Split19-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
* 2015.01.05 [CHM-201639660] SELCMR로 변경 Requested by SELCMR/Pilkyung Jun
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
     * @class ESM_PRI_8005 : ESM_PRI_8005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_8005() {
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
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	
	// combo Object 계수 Constant 
	// 차후 Combo Object 가 추가되더라도 순번을 미는 작업을 줄이기 위해 선언 2015.01.15 
	var SREP_CMB_ID = 0;
	var AOFC_CMB_ID = 1;
	var VERN_CMB_ID = 2;
	var SSCP_CMB_ID = 3;
	var TVVD_CMB_ID = 4;
	var RTRM_CMB_ID = 5;
	var DTRM_CMB_ID = 6;
	var BFLG_CMB_ID = 7;
	var MEAS_CMB_ID = 8;
	var LCUR_CMB_ID = 9;
	var DCUR_CMB_ID = 10;
	var SCUR_CMB_ID = 11;
	
   	/* 개발자 작업	*/
    var rdObjects = new Array();
    var rdCnt = 0;

	var preStsCd = "";  // prog 수행 전 후의 sts_cd 구분을 위한 변수
	var liveVerNo = ""; // delt_flg 달리지 않은 가장큰 ver_no, 이 ver_no 에서만 대부분의 prog 가능
	var tmpRqstNo = "";
	var firstProgUsrId = ""; // 최초 생성자를 저장할 변수
	var lastCntrGrpUsrId = ""; // 마지막으로 Container 정보를 저장한 User ID 
	var countoffer_flg = false;

	// Counter Offer 시에 변경된 값을 체크하기 위해 조회 field 저장 ( Duration ) 
	var p_date1_origin = "";
	var p_date2_origin = "";
	var prop_rt_amt_origin ;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Calendar1":
                	if(window.event.srcElement.style.cursor == "hand"){
	                    var cal = new ComCalendarFromTo();
	                    cal.select(formObj.p_date1, formObj.p_date2, 'yyyy-MM-dd');
                    }
                    break;
                    
                case "btn_Calendar2":
               		if(window.event.srcElement.style.cursor == "hand"){
                    	var cal = new ComCalendarFromTo();
                    	cal.select(formObj.a_date1, formObj.a_date2, 'yyyy-MM-dd');
                    }
                    break;    

                case "btn_new":
                	formObj.prop_rmk.value = "";
					formObj.apro_rmk.value = "";
					formObj.apro_usr_nm.value = "";
					formObj.pol_rmk.value = "";
                    formObj.pod_rmk.value = "";
                    formObj.ts_rmk.value = "";
                    document.getElementById("pol_cost_id").innerText = "";
                    document.getElementById("pod_cost_id").innerText = "";
                    document.getElementById("ts_cost_id").innerText = "";
					
                	sheetObjects[2].RemoveAll();
                	sheetObjects[1].RemoveAll();
                	sheetObjects[0].RemoveAll();
					sheetObjects[3].removeAll();
					sheetObjects[4].removeAll();
					sheetObjects[5].removeAll();
                	formObj.scq_rqst_no.value = "";
                	formObj.scq_ver_no.value = "";
                	comboObjects[VERN_CMB_ID].RemoveAll();
                	formObj.cmb_svc_scp_cd.RemoveAll();
                	updateForm();
	                liveVerNo = "";
	                preStsCd = "";
	                doActionIBSheet(sheetObjects[0],document.form,IBCREATE); // 히든 헤더 시트에 초기값 세팅
	                toggleButtons("NEW");
	                toggleForms("NEW");
	                toggleSheets("NEW");
	                break;
	            case "btn_copy":
                	preStsCd = "";
                	sheetObjects[0].CellValue(1,"pre_prog_sts_cd") = "";
                	formObj.apro_rmk.value = "";
                	formObj.apro_rt_amt.value = "";
                	formObj.a_date1.value = "";
                	formObj.a_date2.value = "";
                	formObj.apro_usr_nm.value = "";
                	formObj.first_cre_usr_nm.value = "";
                	document.form.rqst_ofc_cd.value = document.form.in_usr_ofc_cd.value;
					doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
					doActionIBSheet(sheetObjects[0],document.form,SEARCH06);
                	sheetObjects[0].RemoveAll();
                	sheetObjects[0].DataInsert(0);
					sheetObjects[0].CellValue(1,"prog_sts_cd") = "T";
                	sheetObjects[0].CellValue(1,"pg_prog_sts_cd") = "T";
                	for(var i=sheetObjects[1].HeaderRows; i<sheetObjects[1].HeaderRows+sheetObjects[1].RowCount; i++){
                		if(sheetObjects[1].CellValue(i,"ibflag") != "D"){
                			sheetObjects[1].CellValue(i,"ibflag") = "I";
                		}
                	}
                	for(var i=sheetObjects[2].HeaderRows; i<sheetObjects[2].HeaderRows+sheetObjects[2].RowCount; i++){
                		if(sheetObjects[2].CellValue(i,"ibflag") != "D"){
                			sheetObjects[2].CellValue(i,"ibflag") = "I";
                		}
                	}
                	formObj.scq_rqst_no.value = "";
                	formObj.scq_ver_no.value = "";
                	formObj.prog_sts_nm.value = "";
                	formObj.apro_rmk.value = "";
                	sheetObjects[3].RemoveAll();
                	sheetObjects[4].RemoveAll();
                	sheetObjects[5].RemoveAll();
                	formObj.pol_rmk.value = "";
                	formObj.pod_rmk.value = "";
                	formObj.ts_rmk.value = "";
                	document.getElementById("pol_cost_id").innerText = "";
                	document.getElementById("pod_cost_id").innerText = "";
                	document.getElementById("ts_cost_id").innerText = "";
                	doActionIBSheet(sheetObjects[0],document.form,SEARCH05);
                	//comboObjects[SSCP_CMB_ID].Text = sheetObjects[0].CellValue(1,"svc_scp_cd");
                	comboObjects[VERN_CMB_ID].RemoveAll();
                	toggleButtons("CREATE");
	                toggleForms("CREATE");
	                toggleSheets("CREATE");
	                break;	
                case "btn_retrieve":
                	formObj.scq_ver_no.value = comboObjects[VERN_CMB_ID].Code;
                	ComOpenWait(true);
                	doActionIBSheet(sheetObjects[0], document.form, SEARCH05); // Ver 콤보 조회
                	doActionIBSheet(sheetObjects[0], document.form, SEARCH01); // 히든 헤더 sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH02); // Cargo sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH03); // CNTR sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH06);
					doActionIBSheet(sheetObjects[0], document.form, SEARCH07); // Rout Cost sheet 조회
					updateForm();
					ComOpenWait(false);
					toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					
					break;	
				case "btn_save":
					ComOpenWait(true);
					if(sheetObjects[0].CellValue(1,"prog_sts_cd")==""){
						preStsCd = "";
						sheetObjects[0].CellValue(1,"pre_prog_sts_cd") = "";
					}else{
                		preStsCd = sheetObjects[0].CellValue(1,"prog_sts_cd");
                		sheetObjects[0].CellValue(1,"pre_prog_sts_cd") = sheetObjects[0].CellValue(1,"prog_sts_cd");
					}
					sheetObjects[0].CellValue(1,"prog_sts_cd") = "T";
                	sheetObjects[0].CellValue(1,"pg_prog_sts_cd") = "T";
                	if ( doActionIBSheet(sheetObjects[0],document.form, MULTI01) ) {
	                	doActionIBSheet(sheetObjects[0], document.form, SEARCH07); // Rout Cost sheet 조회
	                	ComOpenWait(false);
	                	toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
						toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
						toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
	            	}
	                break;		
                case "btn_request":
                	ComOpenWait(true);
                	preStsCd = sheetObjects[0].CellValue(1,"prog_sts_cd");
                	sheetObjects[0].CellValue(1,"pre_prog_sts_cd") = sheetObjects[0].CellValue(1,"prog_sts_cd");
                	sheetObjects[0].CellValue(1,"prog_sts_cd") = "S";
                	sheetObjects[0].CellValue(1,"pg_prog_sts_cd") = "S";
                	doActionIBSheet(sheetObjects[0],document.form,MULTI01);
					doActionIBSheet(sheetObjects[0], document.form, SEARCH07); // Rout Cost sheet 조회
                	ComOpenWait(false);
                	toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					break;	
				case "btn_countoffer":
					if ( sheetObjects[1].isDataModified != true && 
						 sheetObjects[2].isDataModified != true && 
						 sheetObjects[3].isDataModified != true && 
						 sheetObjects[4].isDataModified != true && 
						 sheetObjects[5].isDataModified != true &&
						 p_date1_origin == formObj.p_date1.value &&
						 p_date2_origin == formObj.p_date2.value &&
						 prop_rt_amt_origin == formObj.prop_rt_amt.value
						 ){
						if ( ComShowCodeConfirm("PRI09023") == false ) {
		            		return;
		            	}
					}
					countoffer_flg = true;
					ComOpenWait(true);
					preStsCd = sheetObjects[0].CellValue(1,"prog_sts_cd");
					sheetObjects[0].CellValue(1,"pre_prog_sts_cd") = sheetObjects[0].CellValue(1,"prog_sts_cd");
                	sheetObjects[0].CellValue(1,"prog_sts_cd") = "O";
                	sheetObjects[0].CellValue(1,"pg_prog_sts_cd") = "O";
                	
                	/* Approval 내용 기록 삭제 를 하지 않도록 수정 한다. 
					formObj.apro_rmk.value = "";
                	formObj.apro_rt_amt.value = "";
                	formObj.a_date1.value = "";
                	formObj.a_date2.value = "";
                	*/
                	
                	/* 새로운 Version No 로 생성되는 데이터 이므로 */
                	/* CNTR Sheet 의 Group Version No 를 1 로 세팅 한다. */
                	for ( var i = 0; i <= sheetObjects[2].RowCount; i++ ) {
                		sheetObjects[2].CellValue2(i, "cntr_grp_ver_no" ) = "1";
                	}
                	
                	var rst = doActionIBSheet(sheetObjects[0],document.form,MULTI01);
                	////////////
                	if(rst){
	                	for(var j=0;j<3;j++){
		                	var shtObj = "";
		                	if(j == 0){
								formObj.rout_seq.value = 1;  
								shtObj = sheetObjects[3];
								shtObj.CellValue(1,"rout_rmk") = formObj.pol_rmk.value;
							}else if(j == 1){
								formObj.rout_seq.value = 2;  
								shtObj = sheetObjects[4];
								shtObj.CellValue(1,"rout_rmk") = formObj.pod_rmk.value;
							}
		                	/* T/S Port Cost 는 화면 크기 문제로 화면에서 사라졌기 때문에 당분간 처리 대상에서 제외 한다. 2013.12.05. 송호진 
							else if(j == 2){
								formObj.rout_seq.value = 3;  
								shtObj = sheetObjects[5];
								shtObj.CellValue(1,"rout_rmk") = formObj.ts_rmk.value;
							}
							*/
							else{
								break;
							}
							
							var ibFlg = "";
							ibFlg = "I";
							shtObj.CellValue(1,"cfm_flg") = "Y";
							
		                	for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
		                		if(true){
		                			shtObj.CellValue(i,"ibflag")        = ibFlg;
		                			shtObj.CellValue(i,"scq_rqst_no")   = formObj.scq_rqst_no.value;
		                			shtObj.CellValue(i,"scq_ver_no")    = formObj.scq_ver_no.value;
		                			shtObj.CellValue(i,"rout_seq")      = formObj.rout_seq.value;
		                			shtObj.CellValue(i,"rout_cost_seq") = shtObj.CellValue(i,"bb_cgo_tp_seq");
		                		}
		                	}
		                	doActionIBSheet(shtObj,document.form,MULTI02);
						}
					}
                	////////////
					doActionIBSheet(sheetObjects[0], document.form, SEARCH07); // Rout Cost sheet 조회
                	ComOpenWait(false);
                	toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					countoffer_flg = false;
					break;	
				case "btn_cancel":
					if ( !ComShowCodeConfirm("PRI00015") )return;
					ComOpenWait(true);
					
					//rout sheet 내용 삭제
					for(var j=3; j<=5; j++){
						var shtObj = sheetObjects[j];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.CellValue(i,"cost_amt") = "";
							shtObj.CellValue(i,"cfm_flg") = "";
							shtObj.CellValue(i,"rout_rmk") = "";
							shtObj.CellValue2(i,"locl_curr_cd") = "";
							shtObj.CellValue2(i,"locl_curr_amt") = "";
						}
					}
					formObj.pol_rmk.value = "";
					formObj.pod_rmk.value = "";
					formObj.ts_rmk.value = "";
					formObj.rout_seq.value = 1;// pol route cost Update
					doActionIBSheet(sheetObjects[0],document.form,MULTI02);
					formObj.rout_seq.value = 2;// pod route cost Update
					doActionIBSheet(sheetObjects[0],document.form,MULTI02);
					formObj.rout_seq.value = 3;// ts route cost Update
					doActionIBSheet(sheetObjects[0],document.form,MULTI02);
					
					//prog Update
					preStsCd = sheetObjects[0].CellValue(1,"prog_sts_cd");
					sheetObjects[0].CellValue(1,"pre_prog_sts_cd") = sheetObjects[0].CellValue(1,"prog_sts_cd");
                	sheetObjects[0].CellValue(1,"prog_sts_cd") = "C";
                	sheetObjects[0].CellValue(1,"pg_prog_sts_cd") = "C";
                	doActionIBSheet(sheetObjects[0],document.form,MULTI01);
					doActionIBSheet(sheetObjects[0],document.form,SEARCH07);//Route sheet 재조회
					ComOpenWait(false);
					
					toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					
					break;		
				case "btn_delete":
					ComOpenWait(true);
					preStsCd = sheetObjects[0].CellValue(1,"prog_sts_cd");
					sheetObjects[0].CellValue(1,"pre_prog_sts_cd") = sheetObjects[0].CellValue(1,"prog_sts_cd");
                	sheetObjects[0].CellValue(1,"ibflag") = "D";
                	sheetObjects[0].CellValue(1,"prog_sts_cd") = "D";
                	// 히든 헤더 시트의 ibflag D 로 해서 저장 하면  main 테이블 delt flag 에 Y, 
                	// prog 테이블에 기존과 동일 prog_sts_cd 로 저장 (remark 위함)
					doActionIBSheet(sheetObjects[0],document.form,MULTI01);
					doActionIBSheet(sheetObjects[0], document.form, SEARCH07); // Rout Cost sheet 조회
					ComOpenWait(false);
                	toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					break;

                case "btn_pol_info":
                case "btn_pod_info":
                    if (validateForm(sheetObj, formObj)) {
                    	var sUrl = "/hanjin/VOP_VSK_0509.do?";
	                    sUrl += "pop_mode=Y&";
	                    if(srcName == "btn_pol_info") {
                            sUrl += "loc_cd="+formObj.pol_cd.value;
                        }else if(srcName == "btn_pod_info") {
                            sUrl += "loc_cd="+formObj.pod_cd.value;
                        }
	                    ComPriOpenWindowCenter(sUrl, "", 1020, 765, true);
                    }
                    break;

                case "btn_close":
                    window.close();
                    break;
                    
                case "btn_rowadd_1":
                	//addRow();
                	var row = sheetObjects[1].DataInsert(-1);
                	sheetObjects[1].CellValue(row,"wgt_ut_cd") = "KGS";
                	sheetObjects[1].CellValue(row,"not_sum_row") = "1";
                	break;    
				case "btn_rowdel_1":
					for(var i=1; i<=sheetObjects[1].LastRow; i++){
						if(sheetObjects[1].CellValue(i,"del_chk")=="1"){
							if(sheetObjects[1].CellValue(i,"ibflag")=="I"){
								sheetObjects[1].RowDelete(i, false);
								i--;
							}else{
								sheetObjects[1].RowHidden(i) = true;
								sheetObjects[1].CellValue(i,"ibflag")="D";
							}
						}
					}
					break;
                case "btn_copy_1":
                	var row = sheetObjects[1].DataCopy();
                	break;    
				case "btn_rowadd_2":
                	var row = sheetObjects[2].DataInsert(-1);
                	var max_cntr_grp_no = 0;
                	if ( sheetObjects[0].RowCount < 1 || sheetObjects[0].CellValue(1, "max_cntr_grp_no") == "" ) {
                		max_cntr_grp_no = 1;
                	} else {
                		max_cntr_grp_no = sheetObjects[0].CellValue(1, "max_cntr_grp_no");
                	}
                	
                	sheetObjects[2].CellValue2 ( row, "cntr_grp_ver_no") = max_cntr_grp_no;
                	break;    
				
				case "btn_rowdel_2":
					for(var i=1; i<=sheetObjects[2].LastRow; i++){
						if(sheetObjects[2].CellValue(i,"del_chk")=="1"){
							if(sheetObjects[2].CellValue(i,"ibflag")=="I"){
								sheetObjects[2].RowDelete(i, false);
								i--;
							}else{
								sheetObjects[2].RowHidden(i) = true;
								sheetObjects[2].CellValue(i,"ibflag")="D";
							}
						}
					}
					break;
					
				case "btn_save_2":
					var msg_no="";
					if ( sheetObjects[2].IsDataModified ) {
						msg_no = "PRI00001";
					} else {
						msg_no = "PRI09023";
					}
					if ( sheetObjects[2].RowCount == sheetObjects[2].RowCount("D")) {
	  					ComShowCodeMessage("PRI09012"); //Container Information is Mandatory.
	  					return false;						
					}
					if ( ComShowCodeConfirm(msg_no) == false ) {
	            		return;
	            	}
                	doActionIBSheet(sheetObjects[0], document.form, MULTI03);
                	
                	doActionIBSheet(sheetObjects[0], document.form, SEARCH05); // Ver 콤보 조회
                	doActionIBSheet(sheetObjects[0], document.form, SEARCH01); // 히든 헤더 sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH02); // Cargo sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH03); // CNTR sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH07); // Rout Cost sheet 조회
					updateForm();
                	ComOpenWait(false);
                	toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
                	break;    
				
				case "btn_productCatalog":
					var sUrl = "/hanjin/ESM_PRI_8102.do?";
                    sUrl += "pop_mode=Y";
                    sUrl += "&bb_flag=Y";
                    sUrl += "&pol_port_cd="+form.pol_cd.value;
                    sUrl += "&pod_port_cd="+form.pod_cd.value;
                    
                    var rtnVal = ComOpenPopup(sUrl,1020,470,"","0,1", true);
                    
                    if ( rtnVal != null && rtnVal.length > 0 ) {
    					formObj.pol_cd.value = rtnVal[0].ob_yd_cd.substring(0,5);
    					formObj.pol_yd_cd.value = rtnVal[0].ob_yd_cd.substring(5,7);
    					formObj.lane_cd.value = rtnVal[1].lane_cd;
    					if(rtnVal.length > 2){
	    					formObj.ts_loc_cd.value = rtnVal[1].ob_yd_cd.substring(0,5);
	    					formObj.ts_yd_cd.value = rtnVal[1].ob_yd_cd.substring(5,7);
    					}else{
    						formObj.ts_loc_cd.value = "";
	    					formObj.ts_yd_cd.value = "";
    					}
    					formObj.pod_cd.value = rtnVal[rtnVal.length-1].ib_yd_cd.substring(0,5);
    					formObj.pod_yd_cd.value = rtnVal[rtnVal.length-1].ib_yd_cd.substring(5,7);
                  	}
                  	doActionIBSheet(sheetObjects[0],document.form,SEARCH06);
					break;
				
                case "btn_pol_cd":
                case "btn_pod_cd":
                case "btn_ts_cd":
                	//ESM_PRI_0108_02.js 참조
                	if(window.event.srcElement.style.cursor == "hand"){
	                    var sUrl = "/hanjin/ESM_PRI_4026.do?";
	                    sUrl += "group_cmd=" + PRI_SP_SCP;
	                    sUrl += "&location_cmd=L";
	                    var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	                    if (rtnVal != null){
	                        if(srcName == "btn_por_cd") {
	                            form.por_cd.value = rtnVal.cd;
	                        }else if(srcName == "btn_pol_cd"){
	                            form.pol_cd.value = rtnVal.cd;
	                        }else if(srcName == "btn_pod_cd"){
	                            form.pod_cd.value = rtnVal.cd;
	                        }else if(srcName == "btn_ts_cd"){
	                            form.ts_loc_cd.value = rtnVal.cd;
	                        }
	                    }
                    }
                    break;
                
                case "btn_save_pol":
                case "btn_save_pod":
                case "btn_save_ts":
					ComOpenWait(true);
                	var shtObj = "";
                	if(srcName == "btn_save_pol"){
						formObj.rout_seq.value = 1;  
						shtObj = sheetObjects[3];
						shtObj.CellValue(1,"rout_rmk") = formObj.pol_rmk.value;
					}else if(srcName == "btn_save_pod"){
						formObj.rout_seq.value = 2;  
						shtObj = sheetObjects[4];
						shtObj.CellValue(1,"rout_rmk") = formObj.pod_rmk.value;
					}else if(srcName == "btn_save_ts"){
						formObj.rout_seq.value = 3;  
						shtObj = sheetObjects[5];
						shtObj.CellValue(1,"rout_rmk") = formObj.ts_rmk.value;
					}else{
						break;
					}
					
					var ibFlg = "";
					if(shtObj.CellValue(1,"rout_cost_seq") == "" || shtObj.CellValue(1,"cfm_flg") == "Y"){ // 기존 저장된 데이터 없거나, confirm 후 다시 Save 이면
						ibFlg = "I";
					}else{
						ibFlg = "U";
					}
					
					shtObj.CellValue(1,"cfm_flg") = "";
					
                	for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
                		if(true){
                			shtObj.CellValue(i,"ibflag")        = ibFlg;
                			shtObj.CellValue(i,"scq_rqst_no")   = formObj.scq_rqst_no.value;
                			shtObj.CellValue(i,"scq_ver_no")    = formObj.scq_ver_no.value;
                			shtObj.CellValue(i,"rout_seq")      = formObj.rout_seq.value;
                			//shtObj.CellValue(i,"rout_rmk")      = formObj.pol_rmk.value;
                			shtObj.CellValue(i,"rout_cost_seq") = shtObj.CellValue(i,"bb_cgo_tp_seq");
                		}
                	}
                	doActionIBSheet(shtObj,document.form,MULTI02);
                	
                	doActionIBSheet(sheetObjects[0], document.form, SEARCH05); // Ver 콤보 조회
                	doActionIBSheet(sheetObjects[0], document.form, SEARCH01); // 히든 헤더 sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH02); // Cargo sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH03); // CNTR sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH07); // Rout Cost sheet 조회
					updateForm();
                	ComOpenWait(false);
                	toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
                	break;
                
                case "btn_confirm_pol":
				case "btn_confirm_pod":
				case "btn_confirm_ts":
					ComOpenWait(true);
					var shtObj = "";
                	if(srcName == "btn_confirm_pol"){
						formObj.rout_seq.value = 1;  
						shtObj = sheetObjects[3];
						shtObj.CellValue(1,"rout_rmk") = formObj.pol_rmk.value;
					}else if(srcName == "btn_confirm_pod"){
						formObj.rout_seq.value = 2;  
						shtObj = sheetObjects[4];
						shtObj.CellValue(1,"rout_rmk") = formObj.pod_rmk.value;
					}else if(srcName == "btn_confirm_ts"){
						formObj.rout_seq.value = 3;  
						shtObj = sheetObjects[5];
						shtObj.CellValue(1,"rout_rmk") = formObj.ts_rmk.value;
					}else{
						break;
					}
					
					var ibFlg = "U";
					if(shtObj.CellValue(1,"rout_cost_seq") == "" || shtObj.CellValue(1,"cfm_flg") == "Y"){ // 기존 저장된 데이터 없거나, confirm 후 다시 Save 이면
						ibFlg = "I";
					}else{
						ibFlg = "U";
					}
					
					shtObj.CellValue(1,"cfm_flg") = "Y"; 
					
                	for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
                		if(true){
                			
                			shtObj.CellValue(i,"ibflag")        = ibFlg;
                			shtObj.CellValue(i,"scq_rqst_no")   = formObj.scq_rqst_no.value;
                			shtObj.CellValue(i,"scq_ver_no")    = formObj.scq_ver_no.value;
                			shtObj.CellValue(i,"rout_seq")      = formObj.rout_seq.value;
                			shtObj.CellValue(i,"rout_cost_seq") = shtObj.CellValue(i,"bb_cgo_tp_seq");
                		}
                	}
                	doActionIBSheet(shtObj,document.form,MULTI02);
					
					if((sheetObjects[3].CellValue(1,"cfm_flg")=="Y" && sheetObjects[4].CellValue(1,"cfm_flg")=="Y") ) {
						/* T/S Port Cost 는 화면 크기 문제로 화면에서 사라졌기 때문에 당분간 체크 대상에서 제외 한다. 2013.08.13. 송호진 */
						/* &&(sheetObjects[5].CellValue(1,"cfm_flg")=="Y"||formObj.ts_loc_cd.value=="")){ */
						
						preStsCd = sheetObjects[0].CellValue(1,"prog_sts_cd");
						sheetObjects[0].CellValue(1,"pre_prog_sts_cd") = sheetObjects[0].CellValue(1,"prog_sts_cd");
	                	sheetObjects[0].CellValue(1,"prog_sts_cd") = "Q";
	                	sheetObjects[0].CellValue(1,"pg_prog_sts_cd") = "Q";
	                	doActionIBSheet(sheetObjects[0],document.form,MULTI01);
	                	toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
						toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					}
					doActionIBSheet(sheetObjects[0], document.form, SEARCH05); // Ver 콤보 조회
                	doActionIBSheet(sheetObjects[0], document.form, SEARCH01); // 히든 헤더 sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH02); // Cargo sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH03); // CNTR sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH07); // Rout Cost sheet 조회
					updateForm();
					
					ComOpenWait(false);
					toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					break;
                    
                case "btn_customer":
                	if(window.event.srcElement.style.cursor == "hand"){
		                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_8105.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.cust_cnt_cd.value+"&cust_seq="+formObj.cust_seq.value, "", 640, 465, true);
		            	if (rtnVal != null){
		                    formObj.cust_cnt_cd.value = rtnVal.custCntCd;
		                    formObj.cust_seq.value = rtnVal.custSeq;
		                    formObj.ctrt_pty_nm.value = rtnVal.custNm;  
		                    
		                    if ( sheetObjects[0] != null && sheetObjects[0].RowCount > 0 ) {
			                    sheetObjects[0].CellValue2(1, "cust_cnt_cd")     = rtnVal.custCntCd;
			                    sheetObjects[0].CellValue2(1, "cust_lgl_eng_nm") = rtnVal.custNm;
			           	     	com_change_sheet( sheetObjects[0], "cust_seq");
		                    }
		                }
					}
	                break;  
	               
                case "btn_customer2":
                	if(window.event.srcElement.style.cursor == "hand"){
		                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_8105.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.act_cust_cnt_cd.value+"&cust_seq="+formObj.act_cust_seq.value, "", 640, 465, true);
		            	if (rtnVal != null){
		                    formObj.act_cust_cnt_cd.value = rtnVal.custCntCd;
		                    formObj.act_cust_seq.value = rtnVal.custSeq;
		                    formObj.act_cust_nm.value = rtnVal.custNm;  
		                    
		                    if ( sheetObjects[0] != null && sheetObjects[0].RowCount > 0 ) {
			                    sheetObjects[0].CellValue2(1, "act_cust_cnt_cd") = rtnVal.custCntCd;
			                    sheetObjects[0].CellValue2(1, "act_cust_nm")     = rtnVal.custNm;
			           	     	com_change_sheet( sheetObjects[0], "act_cust_seq");
		                    }
		                }
					}
	                break;     
                    
				case "btn_sendmail":
					sendMail();
					break;
				
				case "btn_attachfile":
					var urlParam = "ESM_PRI_8101.do?p_scq_rqst_no="+formObj.scq_rqst_no.value
									+"&p_spcl_cgo_tp_cd=BB";
        			if(checkAuth()){
						urlParam += "&p_editable=Y";        			
        			}
    				ComOpenPopup(urlParam, 525, 440, "", "0,0,1,1,1,1,1", true);
					break;
				case "btn_commonattach": 
					ComOpenPopup("VOP_SCG_0080.do", 1024, 600, "", "0,0,1,1,1,1,1", false, "", "", "", "", "Special Cargo Guidanace", "yes");
					break;
				case "btn_previous":
					
					document.form.scq_rqst_no.value = prev_rqstno;
					document.form.scq_ver_no.value = prev_verno;
					ComOpenWait(true);
		        	doActionIBSheet(sheetObjects[0], document.form, SEARCH05); // Ver No 조회
                	doActionIBSheet(sheetObjects[0], document.form, SEARCH01); // 히든 헤더 sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH02); // Cargo sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH03); // CNTR sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH06);
					doActionIBSheet(sheetObjects[0], document.form, SEARCH07); // Rout Cost sheet 조회
					updateForm();
					ComOpenWait(false);
					toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					
					setPreviousNextBtn();
					
					break;	
				case "btn_next":
//					var opener = window.dialogArguments;
//					var temprqstno = opener.sheetObjects[0].CellValue(3,"scq_rqst_no");
//					
//					var shtObj = opener.sheetObjects[0]; //8001번 화면의 sheet
//					for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
//						if(shtObj.CellValue(i,"tp_cd")=="BB" 
//							&& shtObj.CellValue(3,"scq_rqst_no")==formObj.scq_rqst_no.value){
//						
//						}
//					}
//					alert(temprqstno);
					
					document.form.scq_rqst_no.value = next_rqstno;
					document.form.scq_ver_no.value = next_verno;
					ComOpenWait(true);
		        	doActionIBSheet(sheetObjects[0], document.form, SEARCH05); // Ver No 조회
                	doActionIBSheet(sheetObjects[0], document.form, SEARCH01); // 히든 헤더 sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH02); // Cargo sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH03); // CNTR sheet 조회
					doActionIBSheet(sheetObjects[0], document.form, SEARCH06);
					doActionIBSheet(sheetObjects[0], document.form, SEARCH07); // Rout Cost sheet 조회
					updateForm();
					ComOpenWait(false);
					toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
					
					setPreviousNextBtn();
					
					break;		
				/*
				case "btn_ofc_hierarchy":
					if(window.event.srcElement.style.cursor == "hand"){
	                    if (validateForm(sheetObj, formObj)) {
	                    	var sUrl = "/hanjin/ESM_PRI_8104.do?";
		                    var rtnVal = ComPriOpenWindowCenter(sUrl, "", 450, 520, true);
		                    if ( rtnVal != null && rtnVal.length > 0 ) {
		                    	formObj.apro_ofc_cd.value = rtnVal;
		                    }
	                    }
	                }
                    break;	
                    */
					
				case "btn_saveasxls":
					if ( formObj.scq_rqst_no.value == "" || formObj.scq_ver_no.value == "" ) return;
					//controlTools(formObj);
			    	rdOpen(rdObjects[0], document.form);
					break;
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
 
//  ===================================================================================
//  Axson Event Handler
//  ===================================================================================
    /** 
     * Object 의 Keypress 이벤트핸들러 <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function obj_keypress(){
        var obj = event.srcElement;
        if(obj.dataformat == null) return;
        window.defaultStatus = obj.dataformat;
        
        switch(obj.dataformat){
            case "ymd": //날짜 입력하기
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "int": //숫자만 입력
                ComKeyOnlyNumber(obj);
                break;
            case "engup":
                ComKeyOnlyAlphabet('upper');
                break;
            case "uppernum":
                ComKeyOnlyAlphabet('uppernum');
                break;
            default:
                //ComKeyOnlyNumber(obj);
                break;
        }
	}
	function obj_onkeyup(){
        var formObj = document.form;
        var eleName = event.srcElement.name; 

        switch(eleName){
        	case "scq_rqst_no":
            	if(formObj.scq_rqst_no.value.length == 15 && event.keyCode!=67 && event.keyCode!=17 // ctrl+C/V 사용 시 고려
            		&& event.keyCode!=37 && event.keyCode!=38 && event.keyCode!=39 && event.keyCode!=40 && event.keyCode!=8 && event.keyCode!=46  && event.keyCode!=9){ // 방향키, BackSpace, Delete 키
            		formObj.scq_ver_no.value = "";
	            	doActionIBSheet(sheetObjects[0], document.form, SEARCH05);

	            	if(comboObjects[VERN_CMB_ID].Text != ""){
	            		ComOpenWait(true);
	            		formObj.scq_ver_no.value = comboObjects[VERN_CMB_ID].Text;
	                	doActionIBSheet(sheetObjects[0], document.form, SEARCH01); // 히든 헤더 sheet 조회
						doActionIBSheet(sheetObjects[0], document.form, SEARCH02); // Cargo sheet 조회
						doActionIBSheet(sheetObjects[0], document.form, SEARCH03); // CNTR sheet 조회
						doActionIBSheet(sheetObjects[0], document.form, SEARCH06); // SVC SCP 조회
						doActionIBSheet(sheetObjects[0], document.form, SEARCH07); // Rout Cost sheet 조회
						updateForm();
						ComOpenWait(false);
						toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
						toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
						toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
	            	}
                }
                break;         
        	default:
                break;
        }
    } 



    /**
     * focusout  event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_focusout()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */   
     function obj_focusout() {
    	 
    	 var eleName = event.srcElement.name;

         switch(eleName){
             case "p_date1":
             case "p_date2":
            	if ( !ComIsNull(event.srcElement) && !ComIsDate ( event.srcElement ) ) {
            		ComShowCodeMessage ( "COM132201", "Proposal Duration " + ( eleName == "p_date1" ?  "From" : "To" ) + " Date");
            		event.srcElement.value = "";
            	}
    	    	break;
             case "vps_eta_dt":
            	 if ( !ComIsNull(event.srcElement) && !ComIsDateTime ( event.srcElement,"","hm") ) {
             		ComShowCodeMessage ( "COM132201", "ETA Date");
            		event.srcElement.value = "";
            	 }
            	 break;
         }
         
     }    
     

	/**
    * 초기 이벤트 등록 
    */
    function initControl() {
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        axon_event.addListenerForm('focusout', 'obj_focusout', document.form);
        axon_event.addListenerForm('dblclick', 'obj_dblclick', document.form);
        axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
		axon_event.addListener('keyup', 'obj_onkeyup', 'scq_rqst_no', '');
    }
    
	/**
	* RD Viewer 를 초기화하기 위하여 사용함
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     initRdConfig(rdObject)
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/	    
    function initRdConfig(rdObject){
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0); 
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
		Rdviewer.SetNoDataDialogInfo(0, "", "");	
//		Rdviewer.DisableToolbar (1); Print button enable 2010.11.09 - HJSONG
    }

	/**
	* 특정 RD 파일에 대하여 RD Viewer 를 기동하기 위해 수행
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     rdOpen(rdObject,formObj)
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/	    
    function rdOpen(rdObject,formObj){

    	var Rdviewer = rdObject ;
    	// 열고자 하는 RD 파일을 지정한다.
    	
    	var path  = "apps/alps/esm/pri/specialcargoquotation/scqbreakbulk/report/ESM_PRI_8005.mrd";
    	var param = " /rp [" + formObj.scq_rqst_no.value + "] ["+formObj.scq_ver_no.value +"] /rxlspagezoom [95]";
//    	RD_path = "http://127.0.0.1:7701/hanjin/";
    	var df_save_nm = "";
    	df_save_nm = formObj.scq_rqst_no.value+"_"+formObj.scq_ver_no.value;
    	
    	Rdviewer.SetSaveDialogEx ("C:\\", df_save_nm, "xls@pdf@ppt@doc", "xls");

    	Rdviewer.FileOpen(RD_path + path, RDServer + param);
		Rdviewer.SetSaveExcelOption (1); 
		Rdviewer.SaveAsDialog ();
		
		 
    }
	/**
	* RD Viewer 에서 Viewer 의 속성을 변경하기 위하여 사용
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     controlTools(formObj);
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/		
	function controlTools(formObj){
        var formObject = document.form;
        var Rdviewer = rdObjects[0];
		var file_nm = formObj.scq_rqst_no.value+"_"+formObj.scq_ver_no.value;
		Rdviewer.SetSaveDialogEx ("c:\\Documents and Settings\\", file_nm, "pdf@xls@doc@ppt", "xls");						
	}

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
	
	/**
    * IBMulti Combo Object를 배열로 등록 <br>
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
    * 배열은 소스 상단에 정의 <br>
    * <br><b>Example :</b>
    * <pre>
    *     setComboObject(combo_obj);
    * </pre>
    * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
    * @return 없음
    * @author 
    * @version 2009.04.17
    */      
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
   
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        for(var k = 0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        
        initControl();
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
        ComPriTextCode2ComboItem(prcScqAproOfcCdValue, prcScqAproOfcCdText, getComboObject(comboObjects, 'apro_ofc_cd') ,"|","\t" );
        ComPriTextCode2ComboItem(measSysCdValue, measSysCdText, getComboObject(comboObjects, 'meas_sys_cd') ,"|","\t" );
        
		//p_rqstno 있으면 조회, p_verno 있으면 그 VerNo 로 조회하고, 없으면 liveNo 를 조회함
		if (document.form.p_rqstno.value){
			document.form.scq_rqst_no.value = document.form.p_rqstno.value;
			document.form.scq_ver_no.value = document.form.p_verno.value;
			ComOpenWait(true);
        	doActionIBSheet(sheetObjects[0], document.form, SEARCH05); // Ver No 조회
        	doActionIBSheet(sheetObjects[0], document.form, SEARCH01); // 히든 헤더 sheet 조회
			doActionIBSheet(sheetObjects[1], document.form, SEARCH02); // Cargo sheet 조회
			doActionIBSheet(sheetObjects[2], document.form, SEARCH03); // CNTR sheet 조회
			doActionIBSheet(sheetObjects[0], document.form, SEARCH06); // SVC SCP 조회
			doActionIBSheet(sheetObjects[0], document.form, SEARCH07); // Rout Cost sheet 조회
			updateForm();
			ComOpenWait(false);
			toggleButtons(sheetObjects[0].CellValue(1,"prog_sts_cd"));
			toggleForms(sheetObjects[0].CellValue(1,"prog_sts_cd"));
			toggleSheets(sheetObjects[0].CellValue(1,"prog_sts_cd"));
		}else{
			doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
			toggleButtons("NEW");
			toggleForms("NEW");
			toggleSheets("NEW");
		}
		setPreviousNextBtn();
	   	//RD
    	initRdConfig(rdObjects[0]);
    }
    
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var meas_sys_cd = "";
        if ( sheetObjects.length > 0 && sheetObjects[0].RowCount > 0 ) {
        	meas_sys_cd = sheetObjects[0].CellValue ( 1, "meas_sys_cd");
        }

        switch(sheetNo) {
        	case 1:      //sheet3 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 100;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle1 = "ibflag|scq_rqst_no|scq_ver_no|prog_sts_cd|rqst_ofc_cd|rqst_srep_cd|rqst_srep_nm|pol_cd|pol_yd_cd|pod_cd|pod_yd_cd|svc_scp_cd|cust_cnt_cd|cust_seq|rcv_term_cd|"+
                    				 "de_term_cd|prop_eff_dt|prop_exp_dt|apro_eff_dt|apro_exp_dt|delt_flg|cre_usr_id|cre_dt|upd_usr_id|upd_dt|ts_loc_cd|ts_yd_cd|prop_rt_amt|apro_rt_amt|apro_ofc_cd|"+
                    				 "spcl_cgo_tp_cd|prog_seq|pg_prog_sts_cd|prog_ofc_cd|prog_usr_id|prog_usr_nm|prog_dt|prog_rmk|cust_lgl_eng_nm|prog_sts_nm|pre_prog_sts_cd|auth|rslt_flg|last_flg|"+
                    				 "max_cntr_grp_no|last_cntr_grp_usr_id|lane_cd|vvd_cd|vps_eta_dt|act_cust_cnt_cd|act_cust_seq|act_cust_nm|scq_bid_flg|meas_sys_cd";

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                    InitHeadMode(false, false, true, true, false,false);

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW, COL,  DATATYPE,  WIDTH, DATAALIGN, COLMERGE,     SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,    60,	daCenter,	true,	 "ibflag");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "scq_rqst_no");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "scq_ver_no");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "prog_sts_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "rqst_ofc_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "rqst_srep_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "rqst_srep_nm");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "pol_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "pol_yd_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "pod_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "pod_yd_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "svc_scp_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "cust_cnt_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "cust_seq");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "rcv_term_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "de_term_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "prop_eff_dt");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "prop_exp_dt");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "apro_eff_dt");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "apro_exp_dt");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "delt_flg");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "cre_usr_id");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "cre_dt");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "upd_usr_id");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "upd_dt");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "ts_loc_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "ts_yd_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "prop_rt_amt");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "apro_rt_amt");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "apro_ofc_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "spcl_cgo_tp_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "prog_seq");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "pg_prog_sts_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "prog_ofc_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "prog_usr_id");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "prog_usr_nm");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "prog_dt");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "prog_rmk"); 
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "cust_lgl_eng_nm");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "prog_sts_nm");  
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "pre_prog_sts_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "auth");               
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "rslt_flg");               
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "last_flg");               
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "max_cntr_grp_no");               
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "last_cntr_grp_usr_id");               
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "lane_cd");               
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "vvd_cd");               
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "vps_eta_dt");     
					
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "act_cust_cnt_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "act_cust_seq");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "act_cust_nm" );
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "scq_bid_flg");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "meas_sys_cd");
                    
                    CountPosition = 0;
                
                    sheetObj.DataInsert(-1);
                }
                break;
        	
             case 2:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, true, true, false, false);

					var HeadTitle1 = "||Seq.|cmdt_cd|Commodity|Length|Width|Height|Grs Weight||scq_rqst_no|scq_ver_no|cgo_seq|not_sum_row";
 
                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtHiddenStatus,	0,	  	daLeft,		false,	"ibflag");
                    InitDataProperty(0, cnt++,    dtCheckBox,		20,		daCenter,	false,	"del_chk",		false,	"",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtDataSeq,		30,		daCenter,	false,	"seq",			false,	"",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,  		65, 	daCenter,   true,   "cmdt_cd",      false,  "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtPopup,  		190,	daLeft,   	true,   "cmdt_nm",      true,   "",    dfNone,    0,    true,    true);
                    
                    if ( meas_sys_cd == "M" || meas_sys_cd == "" ) {
	                    InitDataProperty(0, cnt++,    dtData,    		60,		daCenter,	false,	"ttl_dim_len",	true,	"",    dfNone,    0,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    		60,		daCenter,	false,	"ttl_dim_wdt",	true,	"",    dfNone,    0,    true,    true);                    
	                    InitDataProperty(0, cnt++,    dtData,    		60,		daCenter,	false,	"ttl_dim_hgt",	true,	"",    dfNone,    0,    true,    true);
	                    InitDataProperty(0, cnt++,    dtAutoSum,   		70,		daCenter,	false,	"grs_wgt",		true,	"",    dfNone,    0,    true,    true);
                    } else if ( meas_sys_cd == "I" ) {
	                    InitDataProperty(0, cnt++,    dtData,    		60,		daCenter,	false,	"ttl_dim_len",	true,	"",    dfNullFloat,    2,    true,    true);
	                    InitDataProperty(0, cnt++,    dtData,    		60,		daCenter,	false,	"ttl_dim_wdt",	true,	"",    dfNullFloat,    2,    true,    true);                    
	                    InitDataProperty(0, cnt++,    dtData,    		60,		daCenter,	false,	"ttl_dim_hgt",	true,	"",    dfNullFloat,    2,    true,    true);
	                    InitDataProperty(0, cnt++,    dtAutoSum,   		70,		daCenter,	false,	"grs_wgt",		true,	"",    dfNullFloat,    2,    true,    true);                    	
                    }
                    InitDataProperty(0, cnt++,    dtHidden,    		30,		daCenter,	false,	"wgt_ut_cd",	false,	"",    dfNone,    0,    true,    true);
                  	InitDataProperty(0, cnt++,    dtHidden, 	 	60,     daRight,    false,  "scq_rqst_no",  false,  "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden, 	 	60,     daRight,    false,  "scq_ver_no",  	false,  "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden, 	 	60,     daRight,    false,  "cgo_seq",  	false,  "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,    		30,		daCenter,	false,	"not_sum_row",	false,	"",    dfNone,    0,    true,    true);
                   
                    CountPosition = 0; // total count 안보임
                    ShowButtonImage = 1; // editable 인 경우만 돋보기 버튼 보임
					SelectHighLight = false;
                    WaitImageVisible = false;
                    
					// 영문,숫자만 입력하기
                    if ( meas_sys_cd != "I" ) {
						InitDataValid(0, "ttl_dim_len", vtNumericOnly);
						InitDataValid(0, "ttl_dim_wdt", vtNumericOnly);
						InitDataValid(0, "ttl_dim_hgt", vtNumericOnly);
						InitDataValid(0, "grs_wgt", vtNumericOnly);
                    }
                }
                break;

             case 3:      //sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 122;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 자동 트림하여 조회
                    DataAutoTrim = true;

					var HeadTitle1 = "||TP/SZ|BKG Q'ty|Cntr Q'ty|scq_rqst_no|scq_ver_no|cntr_seq|cntr_grp_ver_no|cre_usr_id";
 
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, true, true, false, false);

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                	InitDataProperty(0, cnt++,    dtHiddenStatus,	 0,	daLeft,		false,	"ibflag");
                    InitDataProperty(0, cnt++,    dtCheckBox,		20,	daCenter,	false,	"del_chk",	false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtCombo,    		55,	daCenter,	false,	"cntr_tpsz_cd",		true,     "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,    		65,	daCenter,	false,	"bkg_qty",	false,     "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    		55,	daCenter,	false,	"cntr_qty",	true,     "",    dfNone,    0,    true,    true);
                    
                    InitDataProperty(0, cnt++,    dtHidden, 	 60,     daRight,    false,    "scq_rqst_no",  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden, 	 60,     daRight,    false,    "scq_ver_no",  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden, 	 60,     daRight,    false,    "cntr_seq",  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden, 	 60,     daRight,    false,    "cntr_grp_ver_no",  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden, 	 60,     daRight,    false,    "cre_usr_id",  false,    "",    dfNone,    0,    true,    true);
                    
                    CountPosition = 0;
                    SelectHighLight = false;
                    WaitImageVisible = false;
                    
                    InitDataValid(0, "bkg_qty", vtNumericOnly);
					InitDataValid(0, "cntr_qty", vtNumericOnly);
                }
                break;
            
            case 4:      //
                with (sheetObj) {

                    // 높이 설정
                    style.height = 122;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 자동 트림하여 조회
                    DataAutoTrim = true;

					var HeadTitle1 = "||Items of Cost|Curr.|Cost (Local)|Cost (USD)|scq_rqst_no|scq_ver_no|rout_seq|rout_seq_ver_no|rout_tp_cd|rout_rmk|cfm_flg|rout_cost_seq|upd_usr_id|ex_rate";
 
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, true, true, false, false);

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;
                    
                    // 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtHiddenStatus,   30,	daLeft,	 false,	"ibflag");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daCenter,false,	"bb_cgo_tp_seq",	false,     "",    dfNone,    0,    false,   false);
                    InitDataProperty(0, cnt++,    dtData,    		230,daLeft,  false,	"bb_cgo_desc",		false,     "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,    		60,	daCenter,false,	"locl_curr_cd",		false,     "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtAutoSum,   		90, daRight, false,	"locl_curr_amt");
                    InitDataProperty(0, cnt++,    dtAutoSum,   		55, daRight, false,	"cost_amt",		    false,     "",    dfNone,    0,    false,   false);
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"scq_rqst_no");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,	 false,	"scq_ver_no");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"rout_seq");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,	 false,	"rout_seq_ver_no");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"rout_tp_cd");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,	 false,	"rout_rmk");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"cfm_flg");                    
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"rout_cost_seq");       
                    InitDataProperty(0, cnt++,    dtHidden, 	    60, daLeft,  false, "upd_usr_id");
                    InitDataProperty(0, cnt++,    dtHidden, 	    60, daLeft,  false, "ex_rate");
                    
                    CountPosition = 0;
                    SelectHighLight = false;
                    WaitImageVisible = false;
                }
                break;
                
			case 5:      //
               with (sheetObj) {

                    // 높이 설정
                    style.height = 122;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 자동 트림하여 조회
                    DataAutoTrim = true;

					var HeadTitle1 = "||Items of Cost|Curr.|Cost (Local)|Cost (USD)|scq_rqst_no|scq_ver_no|rout_seq|rout_seq_ver_no|rout_tp_cd|rout_rmk|cfm_flg|rout_cost_seq|upd_usr_id|ex_rate";
 
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, true, true, false, false);

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;
                    
                    // 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtHiddenStatus,  	30,	daLeft,	 false,	"ibflag");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daCenter,false,	"bb_cgo_tp_seq",	false,     "",    dfNone,    0,    false,   false);
                    InitDataProperty(0, cnt++,    dtData,    		230,daLeft,  false,	"bb_cgo_desc",		false,     "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,    		60,	daCenter,false,	"locl_curr_cd",		false,     "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtAutoSum,   		90, daRight, false,	"locl_curr_amt");
                    InitDataProperty(0, cnt++,    dtAutoSum,   		55, daRight, false,	"cost_amt",		    false,     "",    dfNone,    0,    false,   false);
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"scq_rqst_no");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,	 false,	"scq_ver_no");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"rout_seq");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,	 false,	"rout_seq_ver_no");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"rout_tp_cd");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,	 false,	"rout_rmk");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"cfm_flg");                    
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"rout_cost_seq");       
                    InitDataProperty(0, cnt++,    dtHidden, 	    60, daLeft,  false, "upd_usr_id");
                    InitDataProperty(0, cnt++,    dtHidden, 	    60, daLeft,  false, "ex_rate");
                    
                    CountPosition = 0;
                    SelectHighLight = false;
                    WaitImageVisible = false;
                }
                break;
                
            case 6:      //
                with (sheetObj) {

                    // 높이 설정
                    style.height = 122;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 자동 트림하여 조회
                    DataAutoTrim = true;

					var HeadTitle1 = "||Items of Cost|Curr.|Cost (Local)|Cost (USD)|scq_rqst_no|scq_ver_no|rout_seq|rout_seq_ver_no|rout_tp_cd|rout_rmk|cfm_flg|rout_cost_seq|upd_usr_id|ex_rate";
 
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, true, true, false, false);

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;
                    
                    // 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtHiddenStatus,  	30,	daLeft,	 false,	"ibflag");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daCenter,false,	"bb_cgo_tp_seq",	false,     "",    dfNone,    0,    false,   false);
                    InitDataProperty(0, cnt++,    dtData,    		230,daLeft,  false,	"bb_cgo_desc",		false,     "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,    		60,	daCenter,false,	"locl_curr_cd",		false,     "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtAutoSum,   		90, daRight, false,	"locl_curr_amt");
                    InitDataProperty(0, cnt++,    dtAutoSum,   		55, daRight, false,	"cost_amt",		    false,     "",    dfNone,    0,    false,   false);
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"scq_rqst_no");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,	 false,	"scq_ver_no");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"rout_seq");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,	 false,	"rout_seq_ver_no");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"rout_tp_cd");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,	 false,	"rout_rmk");
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"cfm_flg");                    
                    InitDataProperty(0, cnt++,    dtHidden,    		30,	daLeft,  false,	"rout_cost_seq");       
                    InitDataProperty(0, cnt++,    dtHidden, 	    60, daLeft,  false, "upd_usr_id");
                    InitDataProperty(0, cnt++,    dtHidden, 	    60, daLeft,  false, "ex_rate");
                    
                    CountPosition = 0;
                    SelectHighLight = false;
                    WaitImageVisible = false;
                }
                break;                
        }
    }
 
 
     function initCombo(comboObj, comboNo) {

    	switch(comboObj.id) {
            case "cmb_rqst_srep_cd":
                var i=0;
                with(comboObj) {
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 1);
                    MaxLength = 5;
                    SetColWidth("50|150|0");
                }
                break;
//            case "scq_rqst_no":
//                var i=0;
//                with(comboObj) {
//                    DropHeight = 200;
//                    MultiSelect = false;
//                    MaxSelect = 1;
//                    IMEMode = 0;
//                    UseAutoComplete = true;
//                    ValidChar(2, 1);
//                    MaxLength = 5;
//                    SetColWidth("50|150|0");
//                }
//                break;  
			case "cmb_scq_ver_no":
                var i=0;
                with(comboObj) {
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(1, 3);
                    MaxLength = 5;
                    SetColWidth("40|100|60|50");
                }
                break;
            case "cmb_svc_scp_cd":
            	var i=0;
                with(comboObj) {
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(1, 1);
                    MaxLength = 5;
                    SetColWidth("70|0");
                }
                break;  
            case "cmb_rcv_term_cd":
            	var i=0;
                with(comboObj) {
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(1, 1);
                    MaxLength = 5;
                    SetColWidth("20|70");
                    
                }
                break;    
            case "cmb_de_term_cd":
                var i=0;
                with(comboObj) {
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(1, 1);
                    MaxLength = 5;
                    SetColWidth("20|70");
                    
                }
                break;        
            case "cmb_vvd_cd":
                var i=0;
                with(comboObj) {
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 1);
                    MaxLength = 5;
                    SetColWidth("100|170");
                    
                }
                break;        
            case "curr_cd_pol":
            case "curr_cd_pod":
            case "curr_cd_ts":
                var i=0;
                with(comboObj) {
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                    MaxLength = 5;
                    SetColWidth("40|130");
                }
                break;
                
            case "scq_bid_flg":
                var i=0;
                with(comboObj) {
                    DropHeight = 100;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 1);
                    InsertItem(i++, "", "");
                    InsertItem(i++, "Yes", "Y");
                    InsertItem(i++, "No", "N");
                }     
                break;
                
            case "apro_ofc_cd":
            	var i=0;
                with(comboObj) {
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(1, 1);
                    MaxLength = 6;
                    SetColWidth("70|0");
                    
                }
                break;    
            case "meas_sys_cd":
            	var i=0;
                with(comboObj) {
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(1, 1);
                    MaxLength = 6;
                    SetColWidth("120");
                    
                }
                break;    
       }
    }   

    function obj_deactivate() {
        var formObj = document.form;
        var sheetObj = sheetObjects[2]; 
        var sheetObj1 = sheetObjects[0];    
        var eleName = event.srcElement.name;

        switch(eleName){
        /*
            case "apro_ofc_cd":
            	if(sheetObjects[2].CellValue(1,"prog_sts_cd") == ""){
//            		toggleButtons("CREATE");  
//            		toggleForms("CREATE");
                }
   	    		formObj.f_cmd.value = SEARCH14;						
				sheetObjects[0].WaitImageVisible = false;				
				var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));				
				var ofcArr = new Array();
				ofcArr = ComPriXml2Array(sXml, "cd");
				for(var i=0; i<=ofcArr.length; i++){
					if(i==ofcArr.length){
						ComShowCodeMessage("PRI09017"); //Invaild Office Code.
						formObj.apro_ofc_cd.value = "";
						break
					}
					if(ofcArr[i] == formObj.apro_ofc_cd.value){
						break;
					}
				}

                break;
                */    
                
            case "pol_cd":
            	doActionIBSheet(sheetObjects[0], document.form, SEARCH06); 
                break;
            case "pod_cd":
            	doActionIBSheet(sheetObjects[0], document.form, SEARCH06);
                break;
            
            case "p_date1":
            case "p_date2":
            	if(eleName == "p_date1") {  
	   	    		var tdate = formObj.p_date1.value;                                                                                                                                                                                                                                                                                                                                                                                                                                  
	   	    		if (tdate.length >= 8) {                                                                                                                                                                                                                                                                                                                                                                                                                                           
	   	    			formObj.p_date1.value = tdate.substring(0, 4) + "-" + tdate.substring(4, 6) + "-" + tdate.substring(6, 8);    
	   	    		}                                                                                                                                                                                                                                                                                                                                            
   	    		}else if(eleName == "p_date2"){
   	    			var tdate = formObj.p_date2.value;                                                                                                                                                                                                                                                                                                                                                                                                                                  
	   	    		if (tdate.length >= 8) {  
   	    				formObj.p_date2.value = tdate.substring(0, 4) + "-" + tdate.substring(4, 6) + "-" + tdate.substring(6, 8);
   	    			}
   	    		}
   	    		break; 
   	    	case "a_date1":
            case "a_date2":
            	if(eleName == "a_date1") {  
	   	    		var tdate = formObj.a_date1.value;                                                                                                                                                                                                                                                                                                                                                                                                                                  
	   	    		if (tdate.length >= 8) {                                                                                                                                                                                                                                                                                                                                                                                                                                           
	   	    			formObj.a_date1.value = tdate.substring(0, 4) + "-" + tdate.substring(4, 6) + "-" + tdate.substring(6, 8);    
	   	    		}                                                                                                                                                                                                                                                                                                                                            
   	    		}else if(eleName == "a_date2"){
   	    			var tdate = formObj.a_date2.value;                                                                                                                                                                                                                                                                                                                                                                                                                                  
	   	    		if (tdate.length >= 8) {  
   	    				formObj.a_date2.value = tdate.substring(0, 4) + "-" + tdate.substring(4, 6) + "-" + tdate.substring(6, 8);
   	    			}
   	    		}	
   	    		break;
            case "vps_eta_dt":
        		var vpsEtaDt = formObj.vps_eta_dt.value;                                                                                                                                                                                                                                                                                                                                                                                                                                  
   	    		if (vpsEtaDt.length >= 12) {                                                                                                                                                                                                                                                                                                                                                                                                                                           
   	    			formObj.vps_eta_dt.value = vpsEtaDt.substring(0, 4) + "-" + vpsEtaDt.substring(4, 6) + "-" + vpsEtaDt.substring(6, 8) + 
   	    			                           " " + vpsEtaDt.substring(8, 10) + ":" + vpsEtaDt.substring(10,12);    
   	    		}
	   	    	break;
	   	    	
            case "prop_rmk":
            case "apro_rmk":
            case "pol_rmk":
            case "pod_rmk":
            case "ts_rmk":
            	var taObj = event.srcElement;
	       		var strNote = taObj.value;
	       		var taName;
	       		if ( eleName == "prop_rmk" ) {
	       			taName = "Req. ";
	       		}else if( eleName == "apro_rmk" ) {
	       			taName = "Appr. "
	       		}else if( eleName == "pol_rmk" ) {
	       			taName = "POL ";
	       		}else if( eleName == "pod_rmk" ) {
	       			taName = "POD ";
	       		}else if( eleName == "ts_rmk" ) {
	       			taName = "T/S ";
	       		}
	       		taName += "Remark";
	    		if(ComGetLenByByte(taObj) > 4000){
	    			ComShowCodeMessage("PRI09024", taName );
	    			taObj.value = strNote.substring( 0, 4000 );
	    		}
	    		break;
            case "cust_cnt_cd":
                //cust name find
                if (sheetObj1.CellValue(1, "cust_cnt_cd") != formObj.cust_cnt_cd.value){
                	if (formObj.cust_cnt_cd.value == ""){
                		clearCustName();
                	}else{
                    	custNameFind(eleName);
                	}
                }
                ComChkObjValid(event.srcElement);
              
                break;          
            case "cust_seq":
                var custSeq = formObj.cust_seq.value;
                if (custSeq.length < 6 && custSeq.length != 0 ){
                    formObj.cust_seq.value = ComLpad(custSeq, 6, "0");
                }
                //cust name find
                if (ComParseInt(sheetObj.CellValue(1, "cust_seq")) != ComParseInt(formObj.cust_seq.value)){                    
                    if (formObj.cust_seq.value =="" || !ComIsNumber(formObj.cust_seq.value)){  //[CHM-201323647] 숫자가 아닌 경우 clear   
                    	clearCustName();
                    }else{	
                        custNameFind(eleName);
                    }
                }
                break;
                            
            case "act_cust_cnt_cd":
                //cust name find
                if (sheetObj1.CellValue(1, "act_cust_cnt_cd") != formObj.act_cust_cnt_cd.value){
                	if (formObj.act_cust_cnt_cd.value == ""){
                		clearActCustName();
                	}else{
                    	actCustNameFind(eleName);
                	}
                }
                ComChkObjValid(event.srcElement);
              
                break;          
            case "act_cust_seq":
                var actCustSeq = formObj.act_cust_seq.value;
                if (actCustSeq.length < 6 && actCustSeq.length != 0 ){
                    formObj.actCustSeq.value = ComLpad(actCustSeq, 6, "0");
                }
                //cust name find
                if (ComParseInt(sheetObj.CellValue(1, "act_cust_seq")) != ComParseInt(formObj.act_cust_seq.value)){                    
                    if (formObj.act_cust_seq.value =="" || !ComIsNumber(formObj.act_cust_seq.value)){  //[CHM-201323647] 숫자가 아닌 경우 clear   
                    	clearActCustName();
                    }else{	
                        actCustNameFind(eleName);
                    }
                }
                break;
                            
	    		
            default:
            	break;
        }
        
    }     

    function obj_activate() {
        var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        ComClearSeparator (event.srcElement);

        switch(srcName){
	        case "scq_rqst_no":
	                tmpRqstNo = formObj.scq_rqst_no.value;
	                break;
        	case "p_date1":
        	case "p_date2":
		        if(srcName == "p_date1") {                                                                                                                                                                                                                                                                                                                                                                                                                                               
			    	formObj.p_date1.value = formObj.p_date1.value.replace(RegExp(/-/ig), "");                                                                                                                                                                                                                                                                                                                                                                                             
			    } else if(srcName == "p_date2") {                                                                                                                                                                                                                                                                                                                                                                                                                                        
			    	formObj.p_date2.value = formObj.p_date2.value.replace(RegExp(/-/ig), "");                                                                                                                                                                                                                                                                                                                                                                                             
			    }
			    break;
			case "a_date1":
        	case "a_date2":
		        if(srcName == "a_date1") {                                                                                                                                                                                                                                                                                                                                                                                                                                               
			    	formObj.a_date1.value = formObj.a_date1.value.replace(RegExp(/-/ig), "");                                                                                                                                                                                                                                                                                                                                                                                             
			    } else if(srcName == "a_date2") {                                                                                                                                                                                                                                                                                                                                                                                                                                        
			    	formObj.a_date2.value = formObj.a_date2.value.replace(RegExp(/-/ig), "");                                                                                                                                                                                                                                                                                                                                                                                             
			    }
			    break; 
        	case "vps_eta_dt":
		        formObj.vps_eta_dt.value = formObj.vps_eta_dt.value.replace(RegExp(/[-: ]/ig), "");                                                                                                                                                                                                                                                                                                                                                                                             
			    break; 
	    }
    }

    function obj_dblclick() {
        var formObj = document.form;
        var eleName = event.srcElement.name;

        switch(eleName){
            case "prop_rmk":
            case "apro_rmk":
            case "pol_rmk":
            case "pod_rmk":
            case "ts_rmk":
	       		var strNote = event.srcElement.value;
	       		var edit_flag = "";
	       		if ( event.srcElement.readOnly == true ) {
	       			edit_flag = "N";
	       		} else {
	       			edit_flag = "Y";
	       		}
				var sUrl = "/hanjin/ESM_PRI_8106.do?";
                sUrl += "rmk_text=" + encodeURIComponent(strNote.replace(RegExp(/\r/ig), "").replace(RegExp(/\n/ig), "\\n"));
                sUrl += "&edit_flag=" + edit_flag;
                
                var rtnVal = ComOpenPopup(sUrl,1020,425,"","0,1", true);
                
                if ( rtnVal != null && rtnVal.length > 0 ) {
                	event.srcElement.value = rtnVal;
              	}
	    		break;
            default:
            	break;
        }
        
    }     
    
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
        	case IBCLEAR: // 초기 화면 open
        		formObj.f_cmd.value = SEARCH19; // 공통코드 조회
				formObj.cd.value="CD02070";		// PRICING RECEIVING TERM CODE		
				sheetObjects[0].WaitImageVisible = false;				
				var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, formObj.cmb_rcv_term_cd, "cd", "cd|nm");
                formObj.cmb_rcv_term_cd.InsertItem(0, "", "");
                formObj.cmb_rcv_term_cd.Code = "";
                
				formObj.cd.value="CD02071";		// PRICING DELIVERY TERM CODE				
				sheetObjects[0].WaitImageVisible = false;				
				var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));				
				ComPriXml2ComboItem(sXml, formObj.cmb_de_term_cd, "cd", "cd|nm");
                formObj.cmb_de_term_cd.InsertItem(0, "", "");
                formObj.cmb_de_term_cd.Code = "";
                
        		formObj.f_cmd.value = SEARCH04; // MDM_CNTR_TP_SZ
        		sheetObjects[0].WaitImageVisible = false;				
				var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_8005GS.do", FormQueryString(formObj));				
                ComSetIBCombo(sheetObjects[2],sXml,"cntr_tpsz_cd",true,0);

                
        		formObj.f_cmd.value = COMMAND16; // CURRENCY CODE
				sheetObjects[0].WaitImageVisible = false;				
				var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				
				/*
                ComSetIBCombo(sheetObjects[3],sXml,"locl_curr_cd",true,0);
                ComSetIBCombo(sheetObjects[4],sXml,"locl_curr_cd",true,0);
                ComSetIBCombo(sheetObjects[5],sXml,"locl_curr_cd",true,0);
                */
				
                var arrData = ComPriXml2ComboString(sXml, "cd", "etc1");
                var currCdComboValue = "|" + arrData[0];
                var arrCurrCd = arrData[0].split("|");
                var arrCurrTxt = arrData[1].split("|");
                var currCdComboText = "";
                for ( var i = 0; i<arrCurrCd.length; i++){
                	currCdComboText += "|" + arrCurrCd[i] + "\t" + arrCurrTxt[i];
                }
                ComPriTextCode2ComboItem(currCdComboValue, currCdComboText, getComboObject(comboObjects, 'curr_cd_pol'), "|", "\t" );
                ComPriTextCode2ComboItem(currCdComboValue, currCdComboText, getComboObject(comboObjects, 'curr_cd_pod'), "|", "\t" );
                ComPriTextCode2ComboItem(currCdComboValue, currCdComboText, getComboObject(comboObjects, 'curr_cd_ts'),  "|", "\t" );
                
                comboObjects[MEAS_CMB_ID].Code = "M";

				break; 
        	
        	case IBCREATE: // 신규생성 (New 버튼)
        		// Sales Rep. 조회
        		formObj.rqst_ofc_cd.value = formObj.in_usr_ofc_cd.value;
				var params = "f_cmd=" + SEARCH15 + "&etc1=" + formObj.rqst_ofc_cd.value; 
                var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do?", params);
                formObj.cmb_rqst_srep_cd.RemoveAll();
                ComPriXml2ComboItem(sXml, formObj.cmb_rqst_srep_cd, "cd", "cd|nm");
                formObj.cmb_rqst_srep_cd.InsertItem(0, "", "");
                formObj.rqst_srep_nm.value = "";
        	
        		document.form.rqst_ofc_cd.value = document.form.in_usr_ofc_cd.value;
        		//sheetObjects[2].CellValue(1,"scq_ver_no")= "000";
        		//sheetObjects[0].CellValue(1,"spcl_cgo_tp_cd")= "BB";
        		//document.form.rqst_ofc_cd.value = sheetObjects[0].CellValue(1,"rqst_ofc_cd");
        		var meas_sys_cd = "M";
        		if ( sheetObjects.length > 0 && sheetObjects[0].RowCount > 0 ) {
        			meas_sys_cd = sheetObjects[0].CellValue(1,"meas_sys_cd"); 
        			if ( meas_sys_cd == "" ) {
        				meas_sys_cd = "M";
        			}
        		}
                comboObjects[MEAS_CMB_ID].Code = meas_sys_cd; 
                break;
        	
        	case MULTI01: // 헤더 시트, cargo 시트, route 시트 저장 ///////////////////////////////////////////////////
        		//Hidden Header sheet 셋팅
      			updateHdrSheet();
				if (!validateForm(sheetObj, formObj, sAction)) {
					sheetObjects[0].CellValue(1,"prog_sts_cd") = preStsCd;
                	sheetObjects[0].CellValue(1,"pg_prog_sts_cd") = preStsCd;
					ComOpenWait(false);
					return false;
				}
      			
        		if(sheetObjects[0].CellValue(1,"ibflag") != "I"){
	        		sheetObjects[0].CellValue(1,"ibflag") = "U";
    			}
    			//Cargo Sheet 셋팅
    			var cgoEditRow = 0;
				if((preStsCd==""&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="T")
					||(preStsCd=="T"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="S")
					||(preStsCd=="A"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="O")
					||(preStsCd=="R"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="O")){
					// Request no 가 새로 생성 되어, 해당 no 로 cargo 정보 새롭게 저장
					for(var i=1;i<=sheetObjects[1].LastRow;i++){//scq_rqst_no
						sheetObjects[1].CellValue(i,"scq_rqst_no") = sheetObjects[0].CellValue(1,"scq_rqst_no");
        				sheetObjects[1].CellValue(i,"scq_ver_no") = sheetObjects[0].CellValue(1,"scq_ver_no");
        				// 신규 생성에 맞도록 ibflag 조정
        				if(sheetObjects[1].CellValue(i,"ibflag")!="D"){
        					sheetObjects[1].CellValue(i,"ibflag") = "I";
							cgoEditRow++;
						}else if(sheetObjects[1].CellValue(i,"ibflag")=="D"){
							sheetObjects[1].CellValue(i,"ibflag") = "";
						}
					}
				}else if((preStsCd=="T"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="T")
					||(preStsCd=="C"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="S")
					||(preStsCd=="Q"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="A")
					||(preStsCd=="Q"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="R")
					||(preStsCd=="Q"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="P")){
					// Request no 가 유지 되어, 해당 no 에 cargo 정보 갱신 
					for(var i=1;i<=sheetObjects[1].LastRow;i++){
        				// row add 된 부분에만 request no, ver no 복사
        				if(sheetObjects[1].CellValue(i,"ibflag")=="I"){
        					sheetObjects[1].CellValue(i,"scq_rqst_no") = sheetObjects[0].CellValue(1,"scq_rqst_no");
        					sheetObjects[1].CellValue(i,"scq_ver_no") = sheetObjects[0].CellValue(1,"scq_ver_no");
							cgoEditRow++;
						}else if(sheetObjects[1].CellValue(i,"ibflag")=="U"||sheetObjects[1].CellValue(i,"ibflag")=="D"){
							cgoEditRow++;
						}
					}
				}
    			//Cntr Sheet 셋팅
    			var cntrEditRow = 0;
				if((preStsCd==""&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="T")
					||(preStsCd=="T"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="S")
					||(preStsCd=="A"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="O")
					||(preStsCd=="R"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="O")){
					// Request no 가 새로 생성 되어, 해당 no 로 cargo 정보 새롭게 저장
					for(var i=1;i<=sheetObjects[2].LastRow;i++){//scq_rqst_no
						sheetObjects[2].CellValue(i,"scq_rqst_no") = sheetObjects[0].CellValue(1,"scq_rqst_no");
        				sheetObjects[2].CellValue(i,"scq_ver_no") = sheetObjects[0].CellValue(1,"scq_ver_no");
        				// 신규 생성에 맞도록 ibflag 조정
        				if(sheetObjects[2].CellValue(i,"ibflag")!="D"){
        					sheetObjects[2].CellValue(i,"ibflag") = "I";
							cntrEditRow++;
						}else if(sheetObjects[2].CellValue(i,"ibflag")=="D"){
							sheetObjects[2].CellValue(i,"ibflag") = "";
						}
					}
				}else if((preStsCd=="T"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="T")
					||(preStsCd=="C"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="S")
					||(preStsCd=="Q"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="A")
					||(preStsCd=="Q"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="R")
					||(preStsCd=="Q"&&sheetObjects[0].CellValue(1,"prog_sts_cd")=="P")){
					// Request no 가 유지 되어, 해당 no 에 cargo 정보 갱신 
					for(var i=1;i<=sheetObjects[2].LastRow;i++){
        				// row add 된 부분에만 request no, ver no 복사
        				if(sheetObjects[2].CellValue(i,"ibflag")=="I"){
        					sheetObjects[2].CellValue(i,"scq_rqst_no") = sheetObjects[0].CellValue(1,"scq_rqst_no");
        					sheetObjects[2].CellValue(i,"scq_ver_no") = sheetObjects[0].CellValue(1,"scq_ver_no");
							cntrEditRow++;
						}else if(sheetObjects[2].CellValue(i,"ibflag")=="U"||sheetObjects[2].CellValue(i,"ibflag")=="D"){
							cntrEditRow++;
						}
					}
				}
    			// sParam 셋팅
        		formObj.f_cmd.value = MULTI01;
				var sParam = FormQueryString(formObj);
        		var sParamSheet1 = sheetObjects[0].GetSaveString();
				if (sParamSheet1 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
				}
				var sParamSheet2 = sheetObjects[1].GetSaveString();
				if (sParamSheet2 != "" && cgoEditRow != 0) {
					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
				}
				var sParamSheet3 = sheetObjects[2].GetSaveString();
				if (sParamSheet3 != "" && cntrEditRow != 0) {
					sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
				}
//				if (!supressConfirm && !ComPriConfirmSave()) {
//					return false;
//				}
				
				
				var sXml = sheetObj.GetSaveXml("ESM_PRI_8005GS.do", sParam);
				sheetObjects[0].LoadSearchXml(sXml);
	
				if(sheetObjects[0].CellValue(1,"rslt_flg")=='Changed'){
					// Please retrieve this [Request] again as other user changed the data.
					ComShowCodeMessage("PRI01135","Request");
					return false;
					break;
				}
				
				formObj.scq_rqst_no.value = sheetObjects[0].CellValue(1,"scq_rqst_no");
	       		formObj.scq_ver_no.value = sheetObjects[0].CellValue(1,"scq_ver_no");
	       		doActionIBSheet(sheetObjects[0],document.form,SEARCH05); //VerNo 콤보 재 조회
	       		doActionIBSheet(sheetObjects[0],document.form,SEARCH01); //헤더 재 조회
	       		doActionIBSheet(sheetObjects[0],document.form,SEARCH02); //카고 재 조회
	       		doActionIBSheet(sheetObjects[0],document.form,SEARCH03); //컨테이너 재 조회
	       		updateForm();
        		break;
        	
        	case SEARCH01:	// 헤더 정보 조회
	 			formObj.f_cmd.value = SEARCH01;
	 			var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_8005GS.do", FormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                if (arrXml.length > 0) {
		 			sheetObjects[0].LoadSearchXml(arrXml[0]);
		 			
		 			var prop_rmk_ok = false;
		 			var apro_rmk_ok = false;
		 			formObj.prop_rmk.value = "";
		 			formObj.apro_rmk.value = "";
		 			var delt_flg ;
		 			var del_pg_prog_sts_cd;
		 			for(var i=1;i<=sheetObjects[0].LastRow;i++){
		 				if ( i == 1 ) { 
		 					delt_flg = sheetObjects[0].CellValue(i,"delt_flg");
			 				if( delt_flg == "Y" ) {
								formObj.apro_rmk.value = sheetObjects[0].CellValue(i,"prog_rmk");
								apro_rmk_ok = true;	 					
								del_pg_prog_sts_cd = sheetObjects[0].CellValue(i,"pg_prog_sts_cd");
			 				}
		 				}
		 				var sts_cd = sheetObjects[0].CellValue(i,"pg_prog_sts_cd");
		 				if (delt_flg == "Y" ) {
		 					if ( i != 1 && !prop_rmk_ok && sts_cd == del_pg_prog_sts_cd ) {
		 						formObj.prop_rmk.value = sheetObjects[0].CellValue(i,"prog_rmk");
		 						prop_rmk_ok = true;
		 					}
		 				} else {
							if(!prop_rmk_ok&&(sts_cd=="T"||sts_cd=="S"||sts_cd=="C"||sts_cd=="O")){
								formObj.prop_rmk.value = sheetObjects[0].CellValue(i,"prog_rmk");
								prop_rmk_ok = true;
							}else if(!apro_rmk_ok&&(sts_cd=="A"||sts_cd=="R"||sts_cd=="P")){
								formObj.apro_rmk.value = sheetObjects[0].CellValue(i,"prog_rmk");
								apro_rmk_ok = true;
							}
		 				}
					}
					
					var stsCd = sheetObjects[0].CellValue(1,"prog_sts_cd");
					if((stsCd=="Q"||stsCd=="C"||stsCd=="A"||stsCd=="R")
						&&(sheetObjects[2].CellValue(1,"cre_usr_id") == document.form.in_usr_id.value)){
						formObj.rqst_ofc_cd.value = formObj.in_usr_ofc_cd.value;
						formObj.pol_cd.value = sheetObjects[0].CellValue(1,"pol_cd");
						formObj.pod_cd.value = sheetObjects[0].CellValue(1,"pod_cd");
						doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
						doActionIBSheet(sheetObjects[0],document.form,SEARCH06);
					}
					if(stsCd=="T"){
						formObj.rqst_ofc_cd.value = formObj.in_usr_ofc_cd.value;
						formObj.pol_cd.value = sheetObjects[0].CellValue(1,"pol_cd");
						formObj.pod_cd.value = sheetObjects[0].CellValue(1,"pod_cd");
						doActionIBSheet(sheetObjects[0],formObj,IBCREATE);
						doActionIBSheet(sheetObjects[0],formObj,SEARCH06);
					}
					
					firstProgUsrId = sheetObjects[0].CellValue(sheetObjects[0].LastRow, "prog_usr_id");
					lastCntrGrpUsrId = sheetObjects[0].CellValue(sheetObjects[0].LastRow, "last_cntr_grp_usr_id");
					
					if(sheetObjects[0].RowCount == 0){
						ComShowCodeMessage("PRI09014");//Request No / Request Ver is Invalid
					}
                }
                if ( arrXml.length > 1) {
                	ComPriXml2ComboItem(arrXml[1], formObj.cmb_vvd_cd, "cd", "cd|nm");      
                    formObj.cmb_vvd_cd.InsertItem(0, "", "");
                    formObj.cmb_vvd_cd.Code = sheetObjects[0].CellValue(1,"vvd_cd");
                }
               
				// Header 의 MEAS_SYS_CD 와 관련하여 sheet 재 정림
             	var sXml = "";
             	sheetObjects[1].Redraw = false;
             	
             	if ( sheetObjects[1].RowCount > 0 ){
                     sXml = ComPriSheet2Xml ( sheetObjects[1], null, "not_sum_row", "1"  );
             	}	
             	var meas_sys_cd = "";
             	if ( sheetObjects[0].RowCount > 0 ){
             		meas_sys_cd = sheetObjects[0].CellValue ( 1, "meas_sys_cd");
             	}
             	
                ComConfigSheet(sheetObjects[1]);
             	initSheet ( sheetObjects[1], 2 );   	
                ComEndConfigSheet(sheetObjects[1]);
                 
             	if ( sXml != "" ) {
             		ComPriXml2Sheet ( sheetObjects[1], sXml);
             		sXml = "";
             	}

                mergeTotalLine(sheetObjects[1]);
             	sheetObjects[1].Redraw = true;
			
				break;
        	
            case SEARCH02:  //CARGO SHEET 조회
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_8005GS.do", FormQueryString(formObj));
	 			sheetObjects[1].LoadSearchXml(sXml);
	 			break;
	 		
	 		case SEARCH03:	//CNTR SHEET 조회
	 			formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_8005GS.do", FormQueryString(formObj));
	 			sheetObjects[2].LoadSearchXml(sXml);
				document.getElementById("cntr_upd_usr_id").innerText = "( " + lastCntrGrpUsrId + " )";
				break;  
				  
			case SEARCH05:	// Ver No 조회
				if (!validateForm(sheetObj, document.form, sAction)) {
					return false;
				}
	 			formObj.f_cmd.value = SEARCH05;
	 			var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_8005GS.do", FormQueryString(formObj));
	 			sheetObjects[0].LoadSearchXml(sXml);
				
				comboObjects[VERN_CMB_ID].RemoveAll();
                ComPriXml2ComboItem(sXml, comboObjects[VERN_CMB_ID], "scq_ver_no", "scq_ver_no|prog_sts_cd|delt_flg");
				
                liveVerNo = "";
                
				for(var i=1; i<=sheetObjects[0].LastRow; i++){
					if(sheetObjects[0].CellValue(i,"delt_flg")==""){
						liveVerNo = sheetObjects[0].CellValue(i,"scq_ver_no");
						break;
					}
				}
				if(formObj.scq_ver_no.value !=""){
					formObj.scq_ver_no.value = formObj.scq_ver_no.value;
					comboObjects[VERN_CMB_ID].Text = formObj.scq_ver_no.value;
				}else if(liveVerNo!=""){
					formObj.scq_ver_no.value = liveVerNo;
					comboObjects[VERN_CMB_ID].Text = liveVerNo;
				}else{
					formObj.scq_ver_no.value = sheetObjects[0].CellValue(1,"scq_ver_no");
					comboObjects[VERN_CMB_ID].Text = sheetObjects[0].CellValue(1,"scq_ver_no");
				}
				
				if(sheetObjects[0].RowCount == 0){
					sheetObjects[0].DataInsert(0);
				}
				break;
				
			case SEARCH06:	// svc scp 조회
				var arrXml;
				if (!validateForm(sheetObj, document.form, sAction)) {
					return false;
				}
				if(formObj.pol_cd.value.length == 5 && formObj.pod_cd.value.length == 5){
		 			formObj.f_cmd.value = SEARCH06;
		 			var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_8005GS.do", FormQueryString(formObj));
		 			arrXml = sXml.split("|$$|");
					formObj.cmb_svc_scp_cd.RemoveAll();
	                ComPriXml2ComboItem(arrXml[0], formObj.cmb_svc_scp_cd, "svc_scp_cd", "svc_scp_cd");
				}
				comboObjects[SSCP_CMB_ID].Text = sheetObjects[0].CellValue(1,"svc_scp_cd");
				comboObjects[SSCP_CMB_ID].Code = sheetObjects[0].CellValue(1,"svc_scp_cd");
				if ( arrXml.length > 1 ){
                	ComPriXml2ComboItem(arrXml[1], formObj.cmb_vvd_cd, "cd", "cd|nm");      
                    formObj.cmb_vvd_cd.InsertItem(0, "", "");
                    formObj.cmb_vvd_cd.Code2 = "";
                }
				break;
			
			case SEARCH07:	//ROUT COST SHEET 조회
			
	 			formObj.f_cmd.value = SEARCH07;
	 			var sXml = sheetObjects[3].GetSearchXml("ESM_PRI_8005GS.do", FormQueryString(formObj));
	 			var arrXml = sXml.split("|$$|");
	 			if ( arrXml.length > 0 ) {
	 				sheetObjects[3].LoadSearchXml(arrXml[0]);
	 				formObj.pol_rmk.value = sheetObjects[3].CellValue(1,"rout_rmk");
	 				formObj.curr_cd_pol.Code2 = sheetObjects[3].CellValue(1, "locl_curr_cd");
	 				formObj.curr_cd_pol_exrate.value = sheetObjects[3].CellValue(1, "ex_rate");
	 			}
				
	 			if ( arrXml.length > 1 ) {
	 				sheetObjects[4].LoadSearchXml(arrXml[1]);
	 				formObj.pod_rmk.value = sheetObjects[4].CellValue(1,"rout_rmk");
	 				formObj.curr_cd_pod.Code2 = sheetObjects[4].CellValue(1, "locl_curr_cd");
	 				formObj.curr_cd_pod_exrate.value = sheetObjects[4].CellValue(1, "ex_rate");
	 			}
	 			/* T/S Port Cost 는 화면 크기 문제로 화면에서 사라졌기 때문에 당분간 처리 대상에서 제외 한다. 2013.12.05. 송호진 
	 			if ( arrXml.length > 2 ) {
	 				sheetObjects[5].LoadSearchXml(arrXml[2]);
					formObj.ts_rmk.value = sheetObjects[5].CellValue(1,"rout_rmk");					
					formObj.curr_cd_ts.Code2 = sheetObjects[5].CellValue(1, "locl_curr_cd");
	 				formObj.curr_cd_ts_exrate.value = sheetObjects[5].CellValue(1, "ex_rate");
	 			}
	 			*/
				break;
			
			case MULTI02:	//ROUT COST SHEET 저장
	 			formObj.f_cmd.value = MULTI02;
				var sParam = FormQueryString(formObj);
	 			var sParamSheet = "";
	 			if(formObj.rout_seq.value==1){
	 				sParamSheet = sheetObjects[3].GetSaveString();
				}else if(formObj.rout_seq.value==2){
					sParamSheet = sheetObjects[4].GetSaveString();
				}
	 			/* T/S Port Cost 는 화면 크기 문제로 화면에서 사라졌기 때문에 당분간 처리 대상에서 제외 한다. 2013.12.05. 송호진 
				else if(formObj.rout_seq.value==3){
					sParamSheet = sheetObjects[5].GetSaveString();
				}
				*/
				sParam += "&"+ComPriSetPrifix(sParamSheet, "");
				var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_8005GS.do", sParam);
				
				break;	 	
				
			case MULTI03:	//CNTR SHEET New Version Number 저장
				// sParam 셋팅
	 			formObj.f_cmd.value = MULTI03;
				var sParam = FormQueryString(formObj);
	    		var sParamSheet1 = sheetObjects[0].GetSaveString(true);
				if (sParamSheet1 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
				}
	 			var sParamSheet3 = sheetObjects[2].GetSaveString(true);
				if (sParamSheet3 != "" && cntrEditRow != 0) {
					sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
				}
				var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_8005GS.do", sParam);
				break;	 	
        }
        return true;
    }

	function toggleButtons(mode) {
		if (checkAuth()){//권한 있는 경우
			switch (mode) {
				case "NEW":
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnDisable("btn_copy");
					ComBtnEnable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnDisable("btn_delete");
					ComBtnDisable("btn_cancel");
					ComBtnDisable("btn_sendmail");
					ComBtnDisable("btn_attachfile");
					ComBtnEnable("btn_productCatalog");
					ComBtnDisable("btn_saveasxls");
					break;
					
				case "CREATE":
					ComBtnDisable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnDisable("btn_copy");
					ComBtnEnable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnDisable("btn_delete");
					ComBtnDisable("btn_cancel");
					ComBtnDisable("btn_sendmail");
					ComBtnDisable("btn_attachfile");
					ComBtnEnable("btn_productCatalog");
					ComBtnEnable("btn_saveasxls");
					break;
					
				case "T"://최초생성자만 request,delete 가능
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnEnable("btn_copy");
					ComBtnEnable("btn_save");
					if(firstProgUsrId == document.form.in_usr_id.value){
						ComBtnEnable("btn_request");
						ComBtnEnable("btn_delete");
					}else{
						ComBtnDisable("btn_request");
						ComBtnDisable("btn_delete");
					}
					ComBtnDisable("btn_countoffer");
					ComBtnDisable("btn_cancel");
					ComBtnDisable("btn_sendmail");
					ComBtnEnable("btn_attachfile");
					ComBtnEnable("btn_productCatalog");
					ComBtnEnable("btn_saveasxls");
					break;
				
				case "Q":
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnEnable("btn_copy");
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnDisable("btn_delete");
					ComBtnEnable("btn_cancel");
					ComBtnEnable("btn_sendmail");
					ComBtnEnable("btn_attachfile");
					ComBtnEnable("btn_productCatalog");
					ComBtnEnable("btn_saveasxls");
					break;
					
				case "S":	
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnEnable("btn_copy");
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnEnable("btn_delete");
					ComBtnEnable("btn_cancel");
					ComBtnEnable("btn_sendmail");
					ComBtnEnable("btn_attachfile");
					ComBtnDisable("btn_productCatalog");
					ComBtnEnable("btn_saveasxls");
					break;
				
				case "O":
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnEnable("btn_copy");
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnDisable("btn_delete");
					ComBtnEnable("btn_cancel");
					ComBtnEnable("btn_sendmail");
					ComBtnEnable("btn_attachfile");
					ComBtnDisable("btn_productCatalog");
					ComBtnEnable("btn_saveasxls");
					break;	
					
				case "P":
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnEnable("btn_copy");
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnEnable("btn_delete");
					ComBtnDisable("btn_cancel");
					ComBtnEnable("btn_sendmail");
					ComBtnEnable("btn_attachfile");
					ComBtnDisable("btn_productCatalog");
					ComBtnEnable("btn_saveasxls");
					break;	
					
				case "C":
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnEnable("btn_copy");
					ComBtnDisable("btn_save");
					ComBtnEnable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnEnable("btn_delete");
					ComBtnDisable("btn_cancel");
					ComBtnEnable("btn_sendmail");
					ComBtnEnable("btn_attachfile");
					ComBtnEnable("btn_productCatalog");
					ComBtnEnable("btn_saveasxls");
					break;	
				
				case "A":
				case "R":
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnEnable("btn_copy");
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnEnable("btn_countoffer");
					ComBtnDisable("btn_delete");
					ComBtnDisable("btn_cancel");
					ComBtnEnable("btn_sendmail");
					ComBtnEnable("btn_attachfile");
					ComBtnEnable("btn_productCatalog");
					ComBtnEnable("btn_saveasxls");
					break;
					
				default :
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnDisable("btn_copy");
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnDisable("btn_delete");
					ComBtnDisable("btn_cancel");
					ComBtnDisable("btn_sendmail");
					ComBtnDisable("btn_attachfile");
					ComBtnDisable("btn_productCatalog");
					ComBtnDisable("btn_saveasxls");
					break;	
			}		
		}else{//권한 없는 경우
			switch (mode) {
				case "NEW":
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnDisable("btn_copy");
					ComBtnEnable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnDisable("btn_delete");
					ComBtnDisable("btn_cancel");
					ComBtnDisable("btn_sendmail");
					ComBtnDisable("btn_attachfile");
					ComBtnEnable("btn_productCatalog");
					ComBtnDisable("btn_saveasxls");
					break;
					
				case "CREATE":
					ComBtnDisable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnDisable("btn_copy");
					ComBtnEnable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnDisable("btn_delete");
					ComBtnDisable("btn_cancel");
					ComBtnDisable("btn_sendmail");
					ComBtnDisable("btn_attachfile");
					ComBtnEnable("btn_productCatalog");
					ComBtnEnable("btn_saveasxls");
					break;
				
				case "T":
				case "S":	
				case "Q":
				case "C":
				case "O":
				case "P":
				case "A":
				case "R":
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnEnable("btn_copy");
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnDisable("btn_delete");
					if ( mode == "A" && checkApprovalAuth() ) {
						ComBtnEnable("btn_cancel");
					} else {
						ComBtnDisable("btn_cancel");
					}
					if ( mode == "T" ) {
						ComBtnDisable("btn_sendmail");
					} else {
						ComBtnEnable("btn_sendmail");
					}
					ComBtnEnable("btn_attachfile");
					ComBtnDisable("btn_productCatalog");
					ComBtnEnable("btn_saveasxls");
					break;
					
					
				default:
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnDisable("btn_copy");
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnDisable("btn_delete");
					ComBtnDisable("btn_cancel");
					ComBtnDisable("btn_sendmail");
					ComBtnDisable("btn_attachfile");
					ComBtnDisable("btn_productCatalog");
					ComBtnDisable("btn_saveasxls");
					break;
			}
		}
	}
	
	function toggleForms(mode) {
		
		var formObj = document.form;
		
		toggleFormsClass(formObj.btn_Calendar2, 2);
		//return true;
		
		if(mode == "CREATE"){//Copy 후에는 혼동 방지 위해 Request no 등 비활성
			comboObjects[VERN_CMB_ID].removeAll();
			formObj.scq_rqst_no.value = "";
			//formObj.scq_ver_no.value = "";
			toggleFormsClass(formObj.scq_rqst_no, 2);
			comboObjects[VERN_CMB_ID].enable = false;
		}else{
			toggleFormsClass(formObj.scq_rqst_no, 0);
			comboObjects[VERN_CMB_ID].enable = true;
		}
		switch (mode) {
			case "NEW":
			case "CREATE":
			case "":
				//수정가능
				toggleFormsClass(formObj.rqst_ofc_cd, 2);
				//toggleFormsClass(formObj.apro_ofc_cd, 1);
				toggleFormsClass(formObj.pol_cd, 1); 
				toggleFormsClass(formObj.pol_yd_cd, 0);    
				toggleFormsClass(formObj.pod_cd, 1);
				toggleFormsClass(formObj.pod_yd_cd, 0);   
				toggleFormsClass(formObj.ts_loc_cd, 0);
				toggleFormsClass(formObj.ts_yd_cd, 0); 
				toggleFormsClass(formObj.btn_pol_cd, 0); 
				toggleFormsClass(formObj.btn_pod_cd, 0);
				toggleFormsClass(formObj.btn_ts_cd, 0); 
				//toggleFormsClass(formObj.cust_cnt_cd, 0);      
				//toggleFormsClass(formObj.cust_seq, 0); 
				toggleFormsClass(formObj.btn_customer, 0);
				toggleFormsClass(formObj.btn_customer2, 0);
				toggleFormsClass(formObj.p_date1, 1); 
				toggleFormsClass(formObj.p_date2, 1);  
				toggleFormsClass(formObj.a_date1, 2);  
				toggleFormsClass(formObj.a_date2, 2);
				toggleFormsClass(formObj.prop_rmk, 0);
				toggleFormsClass(formObj.apro_rmk, 2);
				toggleFormsClass(formObj.btn_Calendar1, 0);
				toggleFormsClass(formObj.prop_rt_amt, 0);
				// toggleFormsClass(formObj.btn_ofc_hierarchy, 0);
				comboObjects[SREP_CMB_ID].enable = true;
				comboObjects[SSCP_CMB_ID].enable = true;
				comboObjects[RTRM_CMB_ID].enable = true;
				comboObjects[DTRM_CMB_ID].enable = true;
				comboObjects[BFLG_CMB_ID].enable = true;
				comboObjects[MEAS_CMB_ID].enable = true;
				comboObjects[AOFC_CMB_ID].enable = true;
				break;
			case "T":
			case "C":
			case "A":
			case "R":
				// 수정 가능
				if(checkAuth()){				
					toggleFormsClass(formObj.rqst_ofc_cd, 2);
					//toggleFormsClass(formObj.apro_ofc_cd, 1);
					toggleFormsClass(formObj.pol_cd, 1); 
					toggleFormsClass(formObj.pol_yd_cd, 0);    
					toggleFormsClass(formObj.pod_cd, 1);
					toggleFormsClass(formObj.pod_yd_cd, 0);   
					toggleFormsClass(formObj.ts_loc_cd, 0);
					toggleFormsClass(formObj.ts_yd_cd, 0); 
					toggleFormsClass(formObj.btn_pol_cd, 0); 
					toggleFormsClass(formObj.btn_pod_cd, 0);
					toggleFormsClass(formObj.btn_ts_cd, 0); 
					//toggleFormsClass(formObj.cust_cnt_cd, 0);      
					//toggleFormsClass(formObj.cust_seq, 0); 
					toggleFormsClass(formObj.btn_customer, 0);
					toggleFormsClass(formObj.btn_customer2, 0);
					toggleFormsClass(formObj.p_date1, 1); 
					toggleFormsClass(formObj.p_date2, 1);  
					toggleFormsClass(formObj.a_date1, 2);  
					toggleFormsClass(formObj.a_date2, 2);
					toggleFormsClass(formObj.prop_rmk, 0);
					toggleFormsClass(formObj.apro_rmk, 2);
					toggleFormsClass(formObj.btn_Calendar1, 0);
					toggleFormsClass(formObj.prop_rt_amt, 0);
					// toggleFormsClass(formObj.btn_ofc_hierarchy, 0);
					comboObjects[SREP_CMB_ID].enable = true;
					comboObjects[SSCP_CMB_ID].enable = true;
					comboObjects[RTRM_CMB_ID].enable = true;
					comboObjects[DTRM_CMB_ID].enable = true;
					comboObjects[BFLG_CMB_ID].enable = true;
					comboObjects[MEAS_CMB_ID].enable = true;
					comboObjects[AOFC_CMB_ID].enable = true;
				}else{
					toggleFormsClass(formObj.rqst_ofc_cd, 2);
					// toggleFormsClass(formObj.apro_ofc_cd, 2);
					toggleFormsClass(formObj.pol_cd, 2); 
					toggleFormsClass(formObj.pol_yd_cd, 2);    
					toggleFormsClass(formObj.pod_cd, 2);
					toggleFormsClass(formObj.pod_yd_cd, 2);   
					toggleFormsClass(formObj.ts_loc_cd, 2);
					toggleFormsClass(formObj.ts_yd_cd, 2); 
					toggleFormsClass(formObj.btn_pol_cd, 2); 
					toggleFormsClass(formObj.btn_pod_cd, 2);
					toggleFormsClass(formObj.btn_ts_cd, 2); 
					toggleFormsClass(formObj.cust_cnt_cd, 2);      
					toggleFormsClass(formObj.cust_seq, 2); 
					toggleFormsClass(formObj.btn_customer, 2);
					toggleFormsClass(formObj.act_cust_cnt_cd, 2);      
					toggleFormsClass(formObj.act_cust_seq, 2); 
					toggleFormsClass(formObj.act_cust_nm, 2); 
					toggleFormsClass(formObj.btn_customer2, 2);
					toggleFormsClass(formObj.p_date1, 2); 
					toggleFormsClass(formObj.p_date2, 2);  
					toggleFormsClass(formObj.a_date1, 2);  
					toggleFormsClass(formObj.a_date2, 2);
					toggleFormsClass(formObj.prop_rmk, 2);
					toggleFormsClass(formObj.apro_rmk, 2);
					toggleFormsClass(formObj.btn_Calendar1, 2);
					toggleFormsClass(formObj.prop_rt_amt, 2);
					// toggleFormsClass(formObj.btn_ofc_hierarchy, 2);
					comboObjects[SREP_CMB_ID].enable = false;
					comboObjects[SSCP_CMB_ID].enable = false;
					comboObjects[RTRM_CMB_ID].enable = false;
					comboObjects[DTRM_CMB_ID].enable = false;
					comboObjects[BFLG_CMB_ID].enable = false;
					comboObjects[MEAS_CMB_ID].enable = false;
					comboObjects[AOFC_CMB_ID].enable = false;
				}
				break;
				
			case "S":	
			case "Q":
			case "O":
			case "P":
			default:
				//수정 불가
				toggleFormsClass(formObj.rqst_ofc_cd, 2);
				// toggleFormsClass(formObj.apro_ofc_cd, 2);
				toggleFormsClass(formObj.pol_cd, 2); 
				toggleFormsClass(formObj.pol_yd_cd, 2);    
				toggleFormsClass(formObj.pod_cd, 2);
				toggleFormsClass(formObj.pod_yd_cd, 2);   
				toggleFormsClass(formObj.ts_loc_cd, 2);
				toggleFormsClass(formObj.ts_yd_cd, 2); 
				toggleFormsClass(formObj.btn_pol_cd, 2); 
				toggleFormsClass(formObj.btn_pod_cd, 2);
				toggleFormsClass(formObj.btn_ts_cd, 2); 
				toggleFormsClass(formObj.cust_cnt_cd, 2);      
				toggleFormsClass(formObj.cust_seq, 2); 
				toggleFormsClass(formObj.btn_customer, 2);
				toggleFormsClass(formObj.act_cust_cnt_cd, 2);      
				toggleFormsClass(formObj.act_cust_seq, 2); 
				toggleFormsClass(formObj.act_cust_nm, 2); 
				toggleFormsClass(formObj.btn_customer2, 2);
				toggleFormsClass(formObj.p_date1, 2); 
				toggleFormsClass(formObj.p_date2, 2);  
				toggleFormsClass(formObj.a_date1, 2);  
				toggleFormsClass(formObj.a_date2, 2);
				toggleFormsClass(formObj.prop_rmk, 2);
				toggleFormsClass(formObj.apro_rmk, 2);
				toggleFormsClass(formObj.btn_Calendar1, 2);
				toggleFormsClass(formObj.prop_rt_amt, 2);
				// toggleFormsClass(formObj.btn_ofc_hierarchy, 2);
				comboObjects[SREP_CMB_ID].enable = false;
				comboObjects[SSCP_CMB_ID].enable = false;
				comboObjects[RTRM_CMB_ID].enable = false;
				comboObjects[DTRM_CMB_ID].enable = false;
				comboObjects[BFLG_CMB_ID].enable = false;
				comboObjects[MEAS_CMB_ID].enable = true;
				comboObjects[AOFC_CMB_ID].enable = false;
				break;	
			}
		
	}	
	
	function toggleFormsClass(obj, classType) { // classType: 0-일반입력, 1-필수입력, 2-입력불가
		var newClass = "";
		if(obj.type == "text"){
			if(classType == "0"){
				newClass = "input";
				obj.readOnly = false;
			}else if(classType == "1"){
				newClass = "input1";
				obj.readOnly = false;
			}else if(classType == "2"){
				newClass = "input2";
				obj.readOnly = true;
			}	
		}else if(obj.type == "textarea"){
			if(classType == "0"){
				newClass = "textarea";
				obj.readOnly = false;
			}else if(classType == "1"){
				newClass = "textarea1";
				obj.readOnly = false;
			}else if(classType == "2"){
				newClass = "textarea2";
				obj.readOnly = true;
			}
		}else if(obj.tagName=="IMG") {
            if (classType == "0" || classType == "1"){
                obj.style.cursor = "hand";
                obj.style.filter="";
            } else if(classType == "2"){
                obj.style.cursor = "default";
                obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
            }
        }
		if(newClass != ""){
			obj.className = newClass;
		}
    }
    
	function sendMail() {
		var date = new Date();
		var content = "";
		var formObj = document.form;
		var meas_sys_cd = comboObjects[MEAS_CMB_ID].Code;
		var len_unit = "";
		var wgt_unit = "";
		if ( meas_sys_cd == "M" || meas_sys_cd == "" ) {
			len_unit = "cm";
			wgt_unit = "kgs";
		} else if ( meas_sys_cd == "I" ) {
			len_unit = "inch";
			wgt_unit = "lbs";
		}
		
		// ALPS link // Live 반영 전 반드시 수정 !!!
		/*
		content += "<br><br> --- ALPS link -------------------------------- "
				+ "<br>"
				+ "<a href='" + server_url + "hanjin/ESM_PRI_8005.do?p_rqstno="+formObj.scq_rqst_no.value+"'>"
				+ "Click Here</a><br>";
		*/
		// form 내용
		content += "<br>	--- Basic Information of Request ------------------------"
				+ "<br>                                   "
				+ "<br>  1.  Request No.                 : <a href='" + server_url + "hanjin/ESM_PRI_8005.do?p_rqstno="+formObj.scq_rqst_no.value+"' style=\"color:#ff0000\" target=\"_blank\" >"+formObj.scq_rqst_no.value +"</a>"
				+ "<br>  2.  Request Office              : "+formObj.rqst_ofc_cd.value
				+ "<br>  3.  Sales Rep                   : "+formObj.rqst_srep_nm.value
				+ "<br>  4.  Approval Office             : "+formObj.apro_ofc_cd.Code
				+ "<br>  5.  POL                         : "+formObj.pol_cd.value
				+ "<br>  6.  POD                         : "+formObj.pod_cd.value
				+ "<br>  7.  Target Lane                 : "+formObj.lane_cd.value
				+ "<br>  8.  Target VVD / ETA            : "+formObj.cmb_vvd_cd.Code + " / " + form.vps_eta_dt.value
				+ "<br>  9.  Customer Name               : "+formObj.ctrt_pty_nm.value
				+ "<br> 10.  Actual Customer Name        : "+formObj.act_cust_nm.value
				+ "<br> 11.  Break Bulk Term             : "+formObj.cmb_rcv_term_cd.Text+" / "+formObj.cmb_de_term_cd.Text
				+ "<br> 12.  Proposal Duration           : "+( formObj.p_date1.value != "" ? formObj.p_date1.value+" ~ "+formObj.p_date2.value : "" )
				+ "<br> 13.  Approval Duration           : "+( formObj.a_date1.value != "" ? formObj.a_date1.value+" ~ "+formObj.a_date2.value : "" )
				+ "<br> 14.  Total Handling Cost at POL  : "+sheetObjects[3].CellValue(sheetObjects[3].LastRow,"cost_amt") +" USD"
				+ "<br> 15.  Total Handling Cost at POD  : "+sheetObjects[4].CellValue(sheetObjects[3].LastRow,"cost_amt") +" USD" 
				+ "<br> 16.  Proposal Rate (USD)         : "+formObj.prop_rt_amt.value
				+ "<br> 17.  Approval Rate (USD)         : "+formObj.apro_rt_amt.value;
		var    propRmk = formObj.prop_rmk.value;
		if ( propRmk.indexOf( "\r\n" ) > 0 ){
			propRmk = propRmk.replace(RegExp(/\r/ig), "").replace(RegExp(/\n/ig), "<br>");
			propRmk = "<br>" +propRmk;
		}
		content += "<br> 18.  Request Remark              : "+propRmk
				+  "<br>                                   ";
		var    aproRmk = formObj.apro_rmk.value;
		if ( aproRmk.indexOf( "\r\n" ) > 0 ){
			aproRmk = aproRmk.replace(RegExp(/\r/ig), "").replace(RegExp(/\n/ig), "<br>");
			aproRmk = "<br>" +aproRmk;
		}
		content += "<br> 19.  Approval Remark             : "+aproRmk
				+  "<br>                                   ";
		
		
		var tempcontent;
		
		// CGO sheet
		tempcontent = "";
		tempcontent += "<br> --- Detail Information for Cargo ---------------------------------- ";
		for(var i=sheetObjects[1].HeaderRows; i<sheetObjects[1].LastRow; i++){			
			if(i>sheetObjects[1].HeaderRows){
				tempcontent += "<br> - - - - - - - - - - - - - - - - - - - - - - - - - - - - ";
			}
			tempcontent +=
			 "<br>            "
			+"<br> 1. Cargo SEQ.                  : " + sheetObjects[1].CellValue(i,'seq') +" / "+ (sheetObjects[1].LastRow - 1)  
			+"<br> 2. Commodity                   : " + sheetObjects[1].CellValue(i,'cmdt_nm')
			+"<br> 3. Overall Dimension (in "+len_unit+")   : " + sheetObjects[1].CellValue(i,'ttl_dim_len') + " x " 
			                                          + sheetObjects[1].CellValue(i,'ttl_dim_wdt') + " x "
			                                          + sheetObjects[1].CellValue(i,'ttl_dim_hgt') + " (Length x Width x Height)"
			+"<br> 4. Weight                      : " + sheetObjects[1].CellValue(i,'grs_wgt') + " "+ wgt_unit 
			+"<br> ";
		}
		content = content + tempcontent;
		
		// CNTR sheet
		tempcontent = "";
		tempcontent += "<br> --- Container Type & Q'ty ---------------------------------- ";
		for(var i=sheetObjects[2].HeaderRows; i<=sheetObjects[2].LastRow; i++){			
			if(i>sheetObjects[2].HeaderRows){
				tempcontent += "<br> - - - - - - - - - - - - - - - - - - - - - - - - - - - - ";
			}
			tempcontent +=
			 "<br>            "
			+"<br> 1. Container Type              : " + sheetObjects[2].CellValue(i,'cntr_tpsz_cd')
			+"<br> 2. Container Q'ty              : " + sheetObjects[2].CellValue(i,'cntr_qty')
			+"<br> ";
		}
		content = content + tempcontent;
		
		var j;
		//POL
		tempcontent = "";
		j=1;
		for(var i=sheetObjects[3].HeaderRows; i<sheetObjects[3].LastRow; i++){
			if(sheetObjects[3].CellValue(i,'cost_amt')!=''&&sheetObjects[3].CellValue(i,'cost_amt')!=0){
				tempcontent += "<br> "+ j + ". " + sheetObjects[3].CellValue(i,'bb_cgo_desc') 
				+" : "+ sheetObjects[3].CellValue(i,'cost_amt') +" USD"
				j++;
			}
		}
		if(formObj.pol_rmk.value!=''){
			var polRmk = formObj.pol_rmk.value;
			if ( polRmk.indexOf("\r\n") > 0) {
				polRmk = polRmk.replace(RegExp(/\r/ig), "").replace(RegExp(/\n/ig), "<br>");
				polRmk = "<br>" +polRmk;				
			}
			tempcontent += "<br> "+ j + ". " +"Remark : "+polRmk;
			j++;
		}

		if(j!=1 && sheetObjects[3].CellValue(sheetObjects[3].LastRow,'cost_amt')!=''&& sheetObjects[3].CellValue(sheetObjects[3].LastRow,'cost_amt')!=0){
			content += "<br> --- Handling Cost at POL -------------------------------- <br>" + tempcontent 
			+"<br> "+ j +". Total : "+sheetObjects[3].CellValue(sheetObjects[3].LastRow,'cost_amt') +" USD <br>";
		}
	    
	    //POD
	    tempcontent = "";
		j=1;
		for(var i=sheetObjects[4].HeaderRows; i<sheetObjects[4].LastRow; i++){
			if(sheetObjects[4].CellValue(i,'cost_amt')!=''&&sheetObjects[4].CellValue(i,'cost_amt')!=0){
				tempcontent += "<br> "+ j + ". " + sheetObjects[4].CellValue(i,'bb_cgo_desc') 
				+" : "+ sheetObjects[4].CellValue(i,'cost_amt') +" USD"
				j++;
			}
		}
		if(formObj.pod_rmk.value!=''){
			var podRmk = formObj.pod_rmk.value;
			if ( podRmk.indexOf("\r\n") > 0) {
				podRmk = podRmk.replace(RegExp(/\r/ig), "").replace(RegExp(/\n/ig), "<br>");
				podRmk = "<br>" +podRmk;				
			}
			tempcontent += "<br> "+ j + ". " +"Remark : "+podRmk;
			j++;
		}

		if(j!=1 && sheetObjects[4].CellValue(sheetObjects[4].LastRow,'cost_amt')!=''&& sheetObjects[4].CellValue(sheetObjects[4].LastRow,'cost_amt')!=0){
			content += "<br> --- Handling Cost at POD -------------------------------- <br>" + tempcontent 
			+"<br> "+ j +". Total : "+sheetObjects[4].CellValue(sheetObjects[4].LastRow,'cost_amt') +" USD <br>";
		}
	    
	    /* T/S Port Cost 는 화면 크기 문제로 화면에서 사라졌기 때문에 당분간 처리 대상에서 제외 한다. 2013.12.05. 송호진 
	    //TS 
	    tempcontent = "";
		j=1;
		for(var i=sheetObjects[5].HeaderRows; i<sheetObjects[5].LastRow; i++){
			if(sheetObjects[5].CellValue(i,'cost_amt')!=''&&sheetObjects[5].CellValue(i,'cost_amt')!=0){
				tempcontent += "<br> "+ j + ". " + sheetObjects[5].CellValue(i,'bb_cgo_desc') 
				+" : "+ sheetObjects[5].CellValue(i,'cost_amt') +" USD"
				j++;
			}
		}
		if(formObj.ts_rmk.value!=''){
			var tsRmk = formObj.ts_rmk.value;
			if ( tsRmk.indexOf("\r\n") > 0) {
				tsRmk = tsRmk.replace(RegExp(/\r/ig), "").replace(RegExp(/\n/ig), "<br>");
				tsRmk = "<br>" +tsRmk;				
			}
			tempcontent += "<br> "+ j + ". " +"Remark : "+tsRmk;
			j++;
		}

		if(j!=1 && sheetObjects[5].CellValue(sheetObjects[3].LastRow,'cost_amt')!=''&& sheetObjects[5].CellValue(sheetObjects[5].LastRow,'cost_amt')!=0){
			content += "<br> --- Handling Cost at T/S Port -------------------------------- <br>" + tempcontent 
			+"<br> "+ j +". Total : "+sheetObjects[5].CellValue(sheetObjects[5].LastRow,'cost_amt') +" USD <br>";
		}
		*/
		content = content + "<br> --- End ----------------------------------------------- ";
		formObj.gw_contents.value = content;
		//메일 제목
		var mailtitle = "Break Bulk Cargo Quotation for "+formObj.scq_rqst_no.value+" / POL : "+formObj.pol_cd.value+" POD : "+formObj.pod_cd.value + " / " + formObj.ctrt_pty_nm.value.substring ( 0, 15 );
		formObj.gw_subject.value = mailtitle;
	    ComOpenGroupwareMail(sheetObjects[0],formObj);
	}   
	
    function updateHdrSheet(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        
        if(sheetObj.RowCount == 0){
        	sheetObj.DataInsert(0);
        }
		//PRI_SCQ_AWK_MN 를 위한 값
		
    	sheetObj.CellValue(1,"rqst_ofc_cd") = formObj.rqst_ofc_cd.value; 
		//sheetObj.CellValue(1,"apro_ofc_cd") = formObj.apro_ofc_cd.value;       
		sheetObj.CellValue(1,"pol_cd")      = formObj.pol_cd.value;       
		sheetObj.CellValue(1,"pol_yd_cd")   = formObj.pol_yd_cd.value;       
		sheetObj.CellValue(1,"pod_cd")      = formObj.pod_cd.value;       
		sheetObj.CellValue(1,"pod_yd_cd")   = formObj.pod_yd_cd.value;       
		sheetObj.CellValue(1,"cust_cnt_cd") = formObj.cust_cnt_cd.value;
		if(formObj.cust_seq.value != ""){
		sheetObj.CellValue(1,"cust_seq") = ComLtrim(formObj.cust_seq.value, "0");       
		}
		sheetObj.CellValue(1,"prop_eff_dt") = formObj.p_date1.value;       
		sheetObj.CellValue(1,"prop_exp_dt") = formObj.p_date2.value;       
		sheetObj.CellValue(1,"apro_eff_dt") = formObj.a_date1.value;       
		sheetObj.CellValue(1,"apro_exp_dt") = formObj.a_date2.value; 
		
		sheetObj.CellValue(1,"ts_loc_cd") = formObj.ts_loc_cd.value;
		sheetObj.CellValue(1,"ts_yd_cd") = formObj.ts_yd_cd.value;
		sheetObj.CellValue(1,"prop_rt_amt") = formObj.prop_rt_amt.value;
		sheetObj.CellValue(1,"apro_rt_amt") = formObj.apro_rt_amt.value;
		
		sheetObj.CellValue(1,"scq_ver_no")  = formObj.scq_ver_no.value;
		
		
		//콤보
		sheetObj.CellValue(1,"rqst_srep_cd") = comboObjects[SREP_CMB_ID].Text;
		sheetObj.CellValue(1,"scq_ver_no")   = comboObjects[VERN_CMB_ID].Text;   
		sheetObj.CellValue(1,"svc_scp_cd")   = comboObjects[SSCP_CMB_ID].Text;
		sheetObj.CellValue(1,"rcv_term_cd")  = comboObjects[RTRM_CMB_ID].Text;
		sheetObj.CellValue(1,"de_term_cd")   = comboObjects[DTRM_CMB_ID].Text; 
		sheetObj.CellValue(1,"apro_ofc_cd")  = comboObjects[AOFC_CMB_ID].Text; 

		//PRI_SCQ_PROG 를 위한 값		
		sheetObj.CellValue(1,"prog_rmk")       = document.form.prop_rmk.value;
		sheetObj.CellValue(1,"prog_ofc_cd")    = document.form.in_usr_ofc_cd.value;
		sheetObj.CellValue(1,"spcl_cgo_tp_cd") = "BB";
		
		// Target Lane, VVD, ETA DT 		
		sheetObj.CellValue(1,"lane_cd")       = document.form.lane_cd.value;
		sheetObj.CellValue(1,"vvd_cd")        = comboObjects[TVVD_CMB_ID].Code;
		sheetObj.CellValue(1,"vps_eta_dt")    = document.form.vps_eta_dt.value;
		
		// Actual Customer, Bidding Flag 추가 
		
		sheetObj.CellValue(1,"act_cust_cnt_cd") = document.form.act_cust_cnt_cd.value;
		if(formObj.act_cust_seq.value != ""){
			sheetObj.CellValue(1,"act_cust_seq") = ComLtrim(formObj.act_cust_seq.value, "0");       
		}
		sheetObj.CellValue(1,"act_cust_nm")     = document.form.act_cust_nm.value;
		sheetObj.CellValue(1,"scq_bid_flg")     = comboObjects[BFLG_CMB_ID].Code;
		sheetObj.CellValue(1,"meas_sys_cd")     = comboObjects[MEAS_CMB_ID].Code;
		
				
    }
    
    // 히든 sheet 내용을 form 에 update
    function updateForm(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
		
		if(sheetObj.RowCount == 0){
        	sheetObj.DataInsert(0);
        }
		
	    formObj.rqst_ofc_cd.value = sheetObj.CellValue(1,"rqst_ofc_cd"); 
		// formObj.apro_ofc_cd.value = sheetObj.CellValue(1,"apro_ofc_cd");      
		formObj.pol_cd.value      = sheetObj.CellValue(1,"pol_cd");      
		formObj.pol_yd_cd.value   = sheetObj.CellValue(1,"pol_yd_cd");      
		formObj.pod_cd.value      = sheetObj.CellValue(1,"pod_cd");      
		formObj.pod_yd_cd.value   = sheetObj.CellValue(1,"pod_yd_cd");      
		formObj.cust_cnt_cd.value = sheetObj.CellValue(1,"cust_cnt_cd");
		if(sheetObj.CellValue(1,"cust_seq") != ""){
			formObj.cust_seq.value = ComLpad(sheetObj.CellValue(1,"cust_seq"), 6, "0");
		}else{
			formObj.cust_seq.value = ""
		}
		formObj.p_date1.value     = sheetObj.CellValue(1,"prop_eff_dt");  
		formObj.p_date2.value     = sheetObj.CellValue(1,"prop_exp_dt");  
		p_date1_origin            = sheetObj.CellValue(1,"prop_eff_dt");
		p_date2_origin            = sheetObj.CellValue(1,"prop_exp_dt");
		formObj.a_date1.value     = sheetObj.CellValue(1,"apro_eff_dt");  
		formObj.a_date2.value     = sheetObj.CellValue(1,"apro_exp_dt");
		
		formObj.ts_loc_cd.value = sheetObj.CellValue(1,"ts_loc_cd");
		formObj.ts_yd_cd.value = sheetObj.CellValue(1,"ts_yd_cd");
		formObj.prop_rt_amt.value = sheetObj.CellValue(1,"prop_rt_amt");
		prop_rt_amt_origin        = sheetObj.CellValue(1,"prop_rt_amt");
		formObj.apro_rt_amt.value = sheetObj.CellValue(1,"apro_rt_amt");
		
		formObj.scq_ver_no.value  = sheetObj.CellValue(1,"scq_ver_no");
		
		comboObjects[SREP_CMB_ID].Text   = sheetObj.CellValue(1,"rqst_srep_cd");
		if(comboObjects[SREP_CMB_ID].Text != sheetObj.CellValue(1,"rqst_srep_cd")){
			var tempItem = sheetObj.CellValue(1,"rqst_srep_cd");
			comboObjects[SREP_CMB_ID].InsertItem(0,tempItem,tempItem);
			comboObjects[SREP_CMB_ID].Text   = sheetObj.CellValue(1,"rqst_srep_cd");
		}
		comboObjects[SSCP_CMB_ID].Text   = sheetObj.CellValue(1,"svc_scp_cd");
		if(comboObjects[SSCP_CMB_ID].Text != sheetObj.CellValue(1,"svc_scp_cd")){
			var tempItem = sheetObj.CellValue(1,"svc_scp_cd");
			formObj.cmb_svc_scp_cd.InsertItem(0,tempItem,tempItem);
			comboObjects[SSCP_CMB_ID].Text   = sheetObj.CellValue(1,"svc_scp_cd");
		}
		comboObjects[RTRM_CMB_ID].Text   = sheetObj.CellValue(1,"rcv_term_cd");
		comboObjects[DTRM_CMB_ID].Text   = sheetObj.CellValue(1,"de_term_cd");    
		
		formObj.rqst_srep_nm.value = sheetObj.CellValue(1,"rqst_srep_nm");
		formObj.ctrt_pty_nm.value = sheetObj.CellValue(1,"cust_lgl_eng_nm");
		if(sheetObj.CellValue(1,"delt_flg")=="Y"){
			formObj.prog_sts_nm.value = "Deleted";
			formObj.prog_sts_nm.style.color = "Red";
		}else{
			formObj.prog_sts_nm.value = sheetObj.CellValue(1,"prog_sts_nm");
			formObj.prog_sts_nm.style.color = "";
		}
		//formObj.first_cre_usr_id.value = sheetObj.CellValue(sheetObj.LastRow,"cre_usr_id");
		formObj.first_cre_usr_id.value = sheetObj.CellValue(sheetObj.LastRow,"prog_usr_id");
		formObj.first_cre_usr_nm.value = sheetObj.CellValue(sheetObj.LastRow,"prog_usr_nm");
		formObj.apro_usr_nm.value = "";
		for(var i=sheetObj.HeaderRows; i<sheetObj.RowCount+sheetObj.HeaderRows; i++){
			if(sheetObj.CellValue(i,"pg_prog_sts_cd") == "A"||sheetObj.CellValue(i,"pg_prog_sts_cd") == "R"||sheetObj.CellValue(i,"pg_prog_sts_cd") == "P"){
				formObj.apro_usr_nm.value = sheetObj.CellValue(i,"prog_usr_nm");
				break;
			}
		}
		// Target Lane, VVD, ETA DT 		
		formObj.lane_cd.value          = sheetObj.CellValue(1,"lane_cd");
		comboObjects[TVVD_CMB_ID].Code		   = sheetObj.CellValue(1,"vvd_cd");
		formObj.vps_eta_dt.value       = sheetObj.CellValue(1,"vps_eta_dt");
		
		// Actual Customer, Bidding Flag 추가 
		
		formObj.act_cust_cnt_cd.value  = sheetObj.CellValue(1,"act_cust_cnt_cd");
		if(sheetObj.CellValue(1,"act_cust_seq") != ""){
			formObj.act_cust_seq.value = ComLpad(sheetObj.CellValue(1,"act_cust_seq"), 6, "0");
		}else{
			formObj.act_cust_seq.value = ""
		}
		formObj.act_cust_nm.value      = sheetObj.CellValue(1,"act_cust_nm");
		comboObjects[BFLG_CMB_ID].Code           = sheetObj.CellValue(1,"scq_bid_flg");
		comboObjects[MEAS_CMB_ID].Code2          = sheetObj.CellValue(1,"meas_sys_cd");// meas_sys_cd 의 OnChange Event 가 발생하지 않도록 한다.
		comboObjects[AOFC_CMB_ID].Code           = sheetObj.CellValue(1,"apro_ofc_cd");
		

    }	

	function cmb_rqst_srep_cd_OnChange(comboObj, code, text) {	
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.rqst_srep_nm.value = comboObj.GetText(code, 1);
    	}
    	if(sheetObjects[2].CellValue(1,"prog_sts_cd") == ""){
//    		toggleButtons("CREATE");
//    		toggleForms("CREATE");  
        }
    }
    
    function cmb_scq_ver_no_OnChange(comboObj, code, text) {
        var formObj = document.form;
		sheetObjects[0].removeAll();
		sheetObjects[1].removeAll();
		sheetObjects[2].removeAll();
		if(!countoffer_flg){
			sheetObjects[3].removeAll();
			sheetObjects[4].removeAll();
			sheetObjects[5].removeAll();
			formObj.pol_rmk.value = "";
			formObj.pod_rmk.value = "";
			formObj.ts_rmk.value = "";
		}
		comboObjects[SREP_CMB_ID].removeAll();
		comboObjects[SSCP_CMB_ID].removeAll();
		
		updateForm();
		
		formObj.prop_rmk.value = "";
		formObj.apro_rmk.value = "";
		
		formObj.scq_ver_no.value = code;
		toggleButtons();
		toggleForms();
    }    
    
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		var tpCd = "C";
		
		var sUrl = "/hanjin/ESM_PRI_8103.do?grp_cd="+ PRI_RG+"&commodity_cmd=CR";
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_8103", 600, 304, true);
		if (rtnVal != null){
			sheetObj.CellValue2(Row, "cmdt_cd") = rtnVal.cd;
			sheetObj.CellValue2(Row, "cmdt_nm") = rtnVal.nm;			

		}
	}    
	
	function validateForm(sheetObj,formObj,sAction){
   			switch (sAction) {
   				case SEARCH01: // 헤더 조회
	  				if (formObj.scq_rqst_no.value == "" || formObj.scq_ver_no.value == ""
	  					||formObj.scq_rqst_no.value.length != 15||formObj.scq_ver_no.value.length != 3) {
	  					ComShowCodeMessage("PRI09014");//Request No / Request Seq is Invalid
	  					return false;
	  				}
	  				break;
	  			case SEARCH02: // cargo 조회
   				case SEARCH03: // route 조회
   					if (formObj.scq_rqst_no.value == "" || formObj.scq_ver_no.value == ""
	  					||formObj.scq_rqst_no.value.length != 15||formObj.scq_ver_no.value.length != 3) {
	  					return false;
	  				}
	  				break;	
	  			case SEARCH06: // svc scp 조회
	  				if (formObj.pol_cd.value == "" || formObj.pod_cd.value == "") {
	  					return false;
	  				}
	  				break;	
	  				
	  			case MULTI01:
	  				if(sheetObjects[0].CellValue(1,"prog_sts_cd") != "D"){	
		  				if(sheetObjects[0].CellValue(1,"prog_sts_cd") != "T" && sheetObjects[0].CellValue(1,"prog_sts_cd") != "C"){
			  				if (formObj.scq_rqst_no.value == "" || formObj.scq_ver_no.value == ""
			  					||formObj.scq_rqst_no.value.length != 15 || formObj.scq_ver_no.value.length != 3){
			  					ComShowCodeMessage("PRI09014");//Request No / Request Seq is Invalid
			  					return false;
			  				}
			  				if (sheetObjects[0].CellValue(1,"rqst_ofc_cd") == ""){
			  					ComShowCodeMessage("PRI00316","Request OFC."); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[0].CellValue(1,"apro_ofc_cd") == ""){
			  					ComShowCodeMessage("PRI00316","Approval OFC."); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				/*
			  				if(sheetObjects[0].CellValue(1,"rqst_srep_cd") == "" ){
			  					ComShowCodeMessage("PRI00316","Sales Rep."); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				*/
			  				if(sheetObjects[0].CellValue(1,"pol_cd") == ""){
			  					ComShowCodeMessage("PRI00316","POL"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[0].CellValue(1,"pod_cd") == ""){
			  					ComShowCodeMessage("PRI00316","POD"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[0].CellValue(1,"svc_scp_cd") == ""){
			  					ComShowCodeMessage("PRI00316","Service Scope"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[0].CellValue(1,"cust_cnt_cd") == ""){
			  					ComShowCodeMessage("PRI00316","Customer"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[0].CellValue(1,"cust_seq") == ""){
			  					ComShowCodeMessage("PRI00316","Customer"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[0].CellValue(1,"prog_sts_cd") == "S") { // 
				  				if(sheetObjects[0].CellValue(1,"act_cust_cnt_cd") == "" && 
						  		   sheetObjects[0].CellValue(1,"act_cust_seq")    == "" && 
						  		   sheetObjects[0].CellValue(1,"act_cust_nm")     == "" ){
						  			ComShowCodeMessage("PRI00316","Act. Customer"); //Mandatory items [{?msg1}] are required.
						  			return false;
						  		}
			  				}
						  		  		
			  				if(sheetObjects[0].CellValue(1,"rcv_term_cd") == ""){
			  					ComShowCodeMessage("PRI00316","Break Bulk Term"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[0].CellValue(1,"de_term_cd") == ""	){
			  					ComShowCodeMessage("PRI00316","Awkward Term"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[0].CellValue(1,"meas_sys_cd") == "" ) {
			  					ComShowCodeMessage("PRI00316","Measurement Unit"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[0].CellValue(1,"prop_eff_dt") == ""){
			  					ComShowCodeMessage("PRI00316","Proposal Duration"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[0].CellValue(1,"prop_exp_dt") == "" ) {
			  					ComShowCodeMessage("PRI00316","Proposal Duration"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[0].CellValue(1,"prop_eff_dt") > sheetObjects[0].CellValue(1,"prop_exp_dt")){
			  					ComShowCodeMessage("PRI09009"); //Invalid duration
			  					return false;
			  				}
			  				if(sheetObjects[1].RowCount == 0){
			  					ComShowCodeMessage("PRI09008"); //Cargo Information is Mandatory.
			  					return false;
			  				}
			  				if(sheetObjects[2].RowCount == 0){
			  					ComShowCodeMessage("PRI09012"); //Container Information is Mandatory.
			  					return false;
			  				}
			  			}else if (sheetObjects[0].CellValue(1,"prog_sts_cd") == "T" && sheetObjects[0].CellValue(1,"prog_sts_cd") != "C"){
			  				if (sheetObjects[0].CellValue(1,"svc_scp_cd") == "") {
			  					ComShowCodeMessage("PRI00316","Service Scope"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  			}
	  				}	
		  			if(sheetObjects[1].RowCount != 0){
			  			for(var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].LastRow; i++){	
			  				if ((sheetObjects[1].CellValue(i,"ibflag")=="I"||sheetObjects[1].CellValue(i,"ibflag")=="U")
			  					&&(
			  					sheetObjects[1].CellValue(i,"cmdt_cd") == ""
			  					||sheetObjects[1].CellValue(i,"ttl_dim_len") == ""
			  					||sheetObjects[1].CellValue(i,"ttl_dim_wdt") == ""
			  					||sheetObjects[1].CellValue(i,"ttl_dim_hgt") == ""
			  					||sheetObjects[1].CellValue(i,"grs_wgt") == "")){

			  					ComShowCodeMessage("PRI09011"); //Mandatory field of Cargo Sheet is missing.
			  					return false;
			  				}
		  				}
					}
					if(sheetObjects[2].RowCount != 0){
			  			for(var i=sheetObjects[2].HeaderRows; i<=sheetObjects[2].LastRow; i++){	
			  				if ((sheetObjects[2].CellValue(i,"ibflag")=="I"||sheetObjects[2].CellValue(i,"ibflag")=="U")
			  					&&(sheetObjects[2].CellValue(i,"cntr_tpsz_cd") == ""
			  					||sheetObjects[2].CellValue(i,"cntr_qty") == "")){
	
			  					ComShowCodeMessage("PRI09013"); //Mandatory field of Container Sheet is missing.
			  					return false;
			  				}
		  				}
					}
	  				if(sheetObjects[0].CellValue(1,"prog_sts_cd") == "D" && sheetObjects[0].CellValue(1,"prog_rmk") == ""){
	  					ComShowCodeMessage("PRI09015","Delete"); //Remark is mandatory item when {?msg1}.
	  					return false;
	  				}
	  				break;	  				
   			}
   		return true;
    }
	function toggleSheets(mode){
		var formObj = document.form;
		
		if (checkAuth()){
			switch (mode) {
				case "":
				case "NEW":
				case "CREATE":
				case "T":
				case "C":
				case "A":
				case "R":
					for(var j=1; j<=2; j++){
						var shtObj = sheetObjects[j];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.RowEditable(i) = true;
						}
					}
					ComBtnEnable("btn_rowadd_1");
					ComBtnEnable("btn_rowadd_2");
					ComBtnEnable("btn_rowdel_1");
					ComBtnEnable("btn_rowdel_2");
					ComBtnEnable("btn_copy_1");
					ComBtnDisable("btn_save_2");
									
					for(var j=3; j<=5; j++){
						var shtObj = sheetObjects[j];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.RowEditable(i) = false;
						}
					}
					comboObjects[LCUR_CMB_ID].enable = false;
					comboObjects[DCUR_CMB_ID].enable = false;
					comboObjects[SCUR_CMB_ID].enable = false;
					
					ComBtnDisable("btn_save_pol");
					ComBtnDisable("btn_save_pod");
					ComBtnDisable("btn_save_ts");
					ComBtnDisable("btn_confirm_pol");
					ComBtnDisable("btn_confirm_pod");
					ComBtnDisable("btn_confirm_ts");
					toggleFormsClass(formObj.pol_rmk, 2);
					toggleFormsClass(formObj.pod_rmk, 2);
					toggleFormsClass(formObj.ts_rmk, 2);
					break;
				
				case "S":
					ComBtnEnable("btn_rowadd_1");
					ComBtnEnable("btn_rowadd_2");
					ComBtnEnable("btn_rowdel_1");
					ComBtnEnable("btn_rowdel_2");
					ComBtnEnable("btn_copy_1");
					ComBtnEnable("btn_save_2");						
					
					for(var j=1; j<=2; j++){
						var shtObj = sheetObjects[j];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.RowEditable(i) = true;
						}
					}
					
					for(var j=3; j<=4; j++){
						var shtObj = sheetObjects[j];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.RowEditable(i) = true;
						}
					}
					ComBtnEnable("btn_save_pol");
					ComBtnEnable("btn_save_pod");
					ComBtnEnable("btn_confirm_pol");
					ComBtnEnable("btn_confirm_pod");
					/*
					if(sheetObjects[3].CellValue(1,"rout_cost_seq")!=""&&sheetObjects[3].CellValue(1,"cfm_flg")!="Y"){
						ComBtnEnable("btn_confirm_pol");
					}else{
						ComBtnDisable("btn_confirm_pol");
					}
					if(sheetObjects[4].CellValue(1,"rout_cost_seq")!=""&&sheetObjects[4].CellValue(1,"cfm_flg")!="Y"){
						ComBtnEnable("btn_confirm_pod");
					}else{
						ComBtnDisable("btn_confirm_pod");
					}
					*/
					toggleFormsClass(formObj.pol_rmk, 0);
					toggleFormsClass(formObj.pod_rmk, 0);
					
					comboObjects[LCUR_CMB_ID].enable = true;
					comboObjects[DCUR_CMB_ID].enable = true;
					
					if(formObj.ts_loc_cd.value != ""){
						var shtObj = sheetObjects[5];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.RowEditable(i) = true;
						}
						ComBtnEnable("btn_save_ts");
						ComBtnEnable("btn_confirm_ts");
						/*
						if(sheetObjects[5].CellValue(1,"rout_cost_seq")!=""&&sheetObjects[5].CellValue(1,"cfm_flg")!="Y"){
							ComBtnEnable("btn_confirm_ts");
						}else{
							ComBtnDisable("btn_confirm_ts");
						}
						*/
						toggleFormsClass(formObj.ts_rmk, 0);
						comboObjects[SCUR_CMB_ID].enable = true;
					}else{
						var shtObj = sheetObjects[5];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.RowEditable(i) = false;
						}
						ComBtnDisable("btn_save_ts");
						ComBtnDisable("btn_confirm_ts");
						toggleFormsClass(formObj.ts_rmk, 2);
						comboObjects[SCUR_CMB_ID].enable = false;
					}
					
					break;
					
				case "Q":
				case "O":
				case "P":	
				default:
					for(var j=1; j<=2; j++){
						var shtObj = sheetObjects[j];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.RowEditable(i) = false;
						}
					}
					ComBtnDisable("btn_rowadd_1");
					ComBtnDisable("btn_rowadd_2");
					ComBtnDisable("btn_rowdel_1");
					ComBtnDisable("btn_rowdel_2");
					ComBtnDisable("btn_copy_1");
					ComBtnDisable("btn_save_2");
					for(var j=3; j<=5; j++){
						var shtObj = sheetObjects[j];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.RowEditable(i) = false;
						}
					}
					comboObjects[LCUR_CMB_ID].enable = false;
					comboObjects[DCUR_CMB_ID].enable = false;
					comboObjects[SCUR_CMB_ID].enable = false;
					
					ComBtnDisable("btn_save_pol");
					ComBtnDisable("btn_save_pod");
					ComBtnDisable("btn_save_ts");
					ComBtnDisable("btn_confirm_pol");
					ComBtnDisable("btn_confirm_pod");
					ComBtnDisable("btn_confirm_ts");
					toggleFormsClass(formObj.pol_rmk, 2);
					toggleFormsClass(formObj.pod_rmk, 2);
					toggleFormsClass(formObj.ts_rmk, 2);
					break;
			}
		}else{
			switch (mode) {
				case "NEW":
				case "CREATE":
					for(var j=1; j<=2; j++){
						var shtObj = sheetObjects[j];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.RowEditable(i) = true;
						}
					}
					ComBtnEnable("btn_rowadd_1");
					ComBtnEnable("btn_rowadd_2");
					ComBtnEnable("btn_rowdel_1");
					ComBtnEnable("btn_rowdel_2");
					ComBtnEnable("btn_copy_1");
					ComBtnDisable("btn_save_2");
					for(var j=3; j<=5; j++){
						var shtObj = sheetObjects[j];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.RowEditable(i) = false;
						}
					}
					comboObjects[LCUR_CMB_ID].enable = false;
					comboObjects[DCUR_CMB_ID].enable = false;
					comboObjects[SCUR_CMB_ID].enable = false;

					ComBtnDisable("btn_save_pol");
					ComBtnDisable("btn_save_pod");
					ComBtnDisable("btn_save_ts");
					ComBtnDisable("btn_confirm_pol");
					ComBtnDisable("btn_confirm_pod");
					ComBtnDisable("btn_confirm_ts");
					toggleFormsClass(formObj.pol_rmk, 2);
					toggleFormsClass(formObj.pod_rmk, 2);
					toggleFormsClass(formObj.ts_rmk, 2);
					break;
					
				default:
					for(var j=1; j<=2; j++){
						var shtObj = sheetObjects[j];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.RowEditable(i) = false;
						}
					}
					ComBtnDisable("btn_rowadd_1");
					ComBtnDisable("btn_rowadd_2");
					ComBtnDisable("btn_rowdel_1");
					ComBtnDisable("btn_rowdel_2");
					ComBtnDisable("btn_copy_1");
					ComBtnDisable("btn_save_2");
					for(var j=3; j<=5; j++){
						var shtObj = sheetObjects[j];
						for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
							shtObj.RowEditable(i) = false;
						}
					}
					comboObjects[LCUR_CMB_ID].enable = false;
					comboObjects[DCUR_CMB_ID].enable = false;
					comboObjects[SCUR_CMB_ID].enable = false;

					ComBtnDisable("btn_save_pol");
					ComBtnDisable("btn_save_pod");
					ComBtnDisable("btn_save_ts");
					ComBtnDisable("btn_confirm_pol");
					ComBtnDisable("btn_confirm_pod");
					ComBtnDisable("btn_confirm_ts");
					toggleFormsClass(formObj.pol_rmk, 2);
					toggleFormsClass(formObj.pod_rmk, 2);
					toggleFormsClass(formObj.ts_rmk, 2);
					break;
			}
		}
	}
	
	// 기초 권한 체크
	function checkAuth(){
		var stsCd = sheetObjects[0].CellValue(1,"prog_sts_cd"); //Request 의 prog_sts_cd
		firstProgUsrId = sheetObjects[0].CellValue(sheetObjects[0].LastRow, "prog_usr_id");//최초 작성자
		if(liveVerNo == document.form.scq_ver_no.value){//liveVerNo 이면 (deleted 를 제외한 최종 ver)
			if(firstProgUsrId == document.form.in_usr_id.value || document.form.in_usr_ofc_cd.value == "SELCMR" ){ //User 가 최초 작성자 이면	// [CHM-201639660] SELCMR로 변경 Requested by SELCMR/Pilkyung Jun
						return true;
			}else if(stsCd == "T"||stsCd == "S"){ // T 일 땐 누구나 Save 가능 (Request,Delete 는 불가)
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	// 승인 권한 체크
	function checkApprovalAuth(){
		var stsCd = sheetObjects[0].CellValue(1,"prog_sts_cd"); //Request 의 prog_sts_cd
		var aproOfcCd = sheetObjects[0].CellValue(1, "apro_ofc_cd");//승인 ofc
		if(liveVerNo == document.form.scq_ver_no.value){//liveVerNo 이면 (deleted 를 제외한 최종 ver)
			if( ( aproOfcCd == document.form.in_usr_ofc_cd.value // 승인 ofc 이고
				&& sheetObjects[0].CellValue(1, "auth")=="1" ) || document.form.in_usr_ofc_cd.value == "SELCMR" ){     // 해당 SCP 승인 권한 있으면 	// [CHM-201639660] SELCMR로 변경 Requested by SELCMR/Pilkyung Jun
						return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}


	
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		mergeTotalLine(sheetObj);
		// Last Row 는 Sum Row 이므로 제외하도록 한다.
     	for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow - 1; i++){
     	     sheetObj.CellValue ( i, "not_sum_row") = "1";
     	}
	} 
	function sheet2_OnChange(sheetObj, ErrMsg){
		mergeTotalLine(sheetObj);
	} 	
	function mergeTotalLine(sheetObj){
     	with(sheetObj){

 			/*토탈 라인 합쳐지기. */
 			var row = LastRow;
 			var startCol = SaveNameCol("seq");
 			var endCol = SaveNameCol("cmdt_nm");
			SumText(0, "seq") = "";
			SumText(0, "cmdt_nm") = "Total";
			for (var j = startCol; j <= endCol; j ++){
 				SumText(0, j) = "Total";
 			}
 			RowMerge(row) = true;
     	}
 	}

	var prev_rqstno = "";
	var next_rqstno = "";
	var prev_verno = "";
	var next_verno = "";

	function setPreviousNextBtn(){
		var formObj = document.form;
		var opener = window.dialogArguments;
		prev_rqstno = "";
		next_rqstno = "";
		
		if(opener != undefined && formObj.scq_rqst_no.value != ""){
			var shtObj = opener.sheetObjects[0]; //8001번 화면의 sheet
			for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++){
				if(shtObj.CellValue(i,"tp_cd")=="BB"){ 			
					if(shtObj.CellValue(i,"scq_rqst_no")==formObj.scq_rqst_no.value){
						for(var j=i+1;j<=shtObj.LastRow;j++){
							if(shtObj.CellValue(j,"tp_cd")=="BB" 
								&& shtObj.CellValue(j,"scq_rqst_no")!=formObj.scq_rqst_no.value){
									next_rqstno = shtObj.CellValue(j,"scq_rqst_no");
									next_verno = shtObj.CellValue(j,"scq_ver_no");
									break;
							}
						}
						break;
					}else{
						prev_rqstno = shtObj.CellValue(i,"scq_rqst_no");
						prev_verno = shtObj.CellValue(i,"scq_ver_no");
					}				
				}
			}
		}
		if(prev_rqstno == ""){
			ComBtnDisable("btn_previous");
		}else{
			ComBtnEnable("btn_previous");
		}
		if(next_rqstno == ""){
			ComBtnDisable("btn_next");
		}else{
			ComBtnEnable("btn_next");
		}
	}  			
	
	function sheet4_OnSearchEnd(){
		if(sheetObjects[3].CellValue(1,"upd_usr_id")!=""){
			document.getElementById("pol_cost_id").innerText = "( " + sheetObjects[3].CellValue(1,"upd_usr_id") + " )";
		}else{
			document.getElementById("pol_cost_id").innerText = "";	
		}
	}    
	
	function sheet5_OnSearchEnd(){
		if(sheetObjects[4].CellValue(1,"upd_usr_id")!=""){
			document.getElementById("pod_cost_id").innerText = "( " + sheetObjects[4].CellValue(1,"upd_usr_id") + " )";
		}else{
			document.getElementById("pod_cost_id").innerText = "";	
		}
	}  
	
	function sheet6_OnSearchEnd(){
		if(sheetObjects[5].CellValue(1,"upd_usr_id")!=""){
			document.getElementById("ts_cost_id").innerText = "( " + sheetObjects[5].CellValue(1,"upd_usr_id") + " )";
		}else{
			document.getElementById("ts_cost_id").innerText = "";	
		}
	}  
    /** 
     * sheet의 내용이 변경 되었을때 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {int} row 필수, 변경된 row index
     * @param {int} col 필수, 변경된 col index
     * @param {string} value 필수, 변경된 cell의 값
     * @return 없음
     */    
  	function sheet4_OnChange(sheetObj,row,col,value){
		var colname = sheetObj.ColSaveName(col);  
  		if( colname == "locl_curr_cd" || colname == "locl_curr_amt"){
  			//현재 조회중인 데이터를 생성한 년월을 이용해서 Local Amt를 USD로 환산해준다. 
  			getLocalAmtToUSD(sheetObj,row);
  		}
  	}
  	
   	function sheet5_OnChange(sheetObj,row,col,value){
		var colname = sheetObj.ColSaveName(col);  
  		if( colname == "locl_curr_cd" || colname == "locl_curr_amt"){
  			//현재 조회중인 데이터를 생성한 년월을 이용해서 Local Amt를 USD로 환산해준다. 
  			getLocalAmtToUSD(sheetObj,row);
  		}
  	}
   	
  	function sheet6_OnChange(sheetObj,row,col,value){
		var colname = sheetObj.ColSaveName(col);  
  		if( colname == "locl_curr_cd" || colname == "locl_curr_amt"){
  			//현재 조회중인 데이터를 생성한 년월을 이용해서 Local Amt를 USD로 환산해준다. 
  			getLocalAmtToUSD(sheetObj,row);
  		}
  	}
     /** 
     * 현재 조회중인 데이터를 생성한 년월을 이용해서 Local Amt를 USD로 환산해준다. 
     * 
     * <br><b>Example :</b>
     * <pre>
     *       getLocalAmtToUSD(sheetObj,row);
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {int} row 필수, 변경하고자 하는 row index
     * @return 없음
     */     	 
  	function getLocalAmtToUSD(sheetObj,row){
			//USD이면 DB조회가 필요 없다.
		var formObj = document.form;
		if(  sheetObj.Cellvalue(row,"locl_curr_cd") == "USD"){
			sheetObj.Cellvalue2(row,"cost_amt") = sheetObj.Cellvalue(row,"locl_curr_amt");
		}else{
  	    	//USD AMOUNT
  	    	switch ( sheetObj.id ) {
  	    	case "sheet4":
  	    		sheetObj.Cellvalue2(row,"cost_amt") = Math. round ( sheetObj.Cellvalue(row,"locl_curr_amt") / formObj.curr_cd_pol_exrate.value ); 
  	    		break;
  	    	case "sheet5":
  	    		sheetObj.Cellvalue2(row,"cost_amt") = Math. round ( sheetObj.Cellvalue(row,"locl_curr_amt") / formObj.curr_cd_pod_exrate.value ); 
  	    		break;
  	    	case "sheet6":
  	    		sheetObj.Cellvalue2(row,"cost_amt") = Math. round ( sheetObj.Cellvalue(row,"locl_curr_amt") / formObj.curr_cd_ts_exrate.value ); 
  	    		break;
  	    	}
  	    	/*
	      	var formObj = document.form
			var formParam = "f_cmd="+COMMAND03+"&etc1="+sheetObj.Cellvalue(row,"locl_curr_cd");
			formParam = formParam + "&etc2="+sheetObj.Cellvalue(row,"locl_curr_amt");
			formParam = formParam + "&etc3=";
			var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", formParam );
			var arrData = ComXml2ComboString(sXml, "cd", "nm");
			//alert(arrData[0]+"/"+arrData[1])
			sheetObj.Cellvalue2(row,"cost_amt") = arrData[1];
			*/
		}   		
  		
  	}

     /** 
     * 현재 조회중인 데이터를 생성한 년월을 이용해서 Local Currency 의 대 USD 환율을 구한다. 
     * 
     * <br><b>Example :</b>
     * <pre>
     *       getLocalExRateToUSD(curr,idx);
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {int} row 필수, 변경하고자 하는 row index
     * @return 없음
     */     	 
  	function getLocalExRateToUSD(curr_cd, rout_tp_cd){
  		//USD이면 DB조회가 필요 없다.
  		var exrate = 0;
      	var formObj = document.form;
      	
		if(  curr_cd == "USD"){
			exrate = 1;
		} else {
			//USD AMOUNT
			var formParam = "f_cmd="+SEARCH24+"&rate=1&curr_cd="+curr_cd;
			var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", formParam );
			exrate = ComGetEtcData(sXml, "RATE");
		}
		var sheetObj ;
		if ( rout_tp_cd == "POL") {
			formObj.curr_cd_pol_exrate.value = exrate;
			sheetObj = sheetObjects[3];
		} else if ( rout_tp_cd == "POD" ) {
			formObj.curr_cd_pod_exrate.value = exrate;
			sheetObj = sheetObjects[4];
		} else if ( rout_tp_cd == "TS" ) {
			formObj.curr_cd_ts_exrate.value = exrate;
			sheetObj = sheetObjects[5];
		}
		var idx = 0;
		var locl_curr_amt;
		for ( idx = 0; idx <= sheetObj.RowCount; idx++) {
			sheetObj.CellValue2 ( idx, "locl_curr_cd" ) = curr_cd;
			locl_curr_amt = sheetObj.CellValue ( idx, "locl_curr_amt");
			if ( locl_curr_amt != null && locl_curr_amt != '' && locl_curr_amt > 0 ){
				sheetObj.CellValue2 ( idx, "cost_amt" ) = Math.round ( locl_curr_amt / exrate );
			}
		}  		
  	}

     
     function cmb_vvd_cd_OnChange ( comboObj, code, text ) {
    	 var arrText = text.split("|");
    	 document.form.vps_eta_dt.value = arrText[1];  	 
     }

     
     function curr_cd_pol_OnChange ( comboObj, code, text ) {
    	 getLocalExRateToUSD (code, "POL");
     }
   
     function curr_cd_pod_OnChange ( comboObj, code, text ) {
    	 getLocalExRateToUSD (code, "POD");
     }
   
     function curr_cd_ts_OnChange ( comboObj, code, text ) {
    	 getLocalExRateToUSD (code, "TS");
     }

 	/**
 	 * Customer에 관련된 Html Object의 값을 clear 한다.<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *		clearCustName();
 	 * </pre>
 	 * @param  없음
 	 * @return 없음
 	 * @author 공백진
 	 * @version 2009.05.07
 	 */  
 	 function clearCustName(){
 	     var formObj = document.form;
 	     var sheetObj = sheetObjects[0];
 	     
 	     sheetObj.CellValue(1, "cust_cnt_cd")= "";
 	     sheetObj.CellValue(1, "cust_seq") = "";
 	     sheetObj.CellValue(1, "cust_lgl_eng_nm") = "";
 	
 	     formObj.cust_cnt_cd.value = "";
 	     formObj.cust_seq.value = "";
 	     formObj.ctrt_pty_nm.value = "";
 	     
 	 }
 	 
  	/**
  	 * Actual Customer에 관련된 Html Object의 값을 clear 한다.<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *		clearActCustName();
  	 * </pre>
  	 * @param  없음
  	 * @return 없음
  	 * @author 공백진
  	 * @version 2014.08.22
  	 */ 
 	 
  	 function clearActCustName(){
  	     var formObj = document.form;
  	     var sheetObj = sheetObjects[0];
  	     
  	     sheetObj.CellValue(1, "act_cust_cnt_cd")= "";
  	     sheetObj.CellValue(1, "act_cust_seq") = "";
  	     sheetObj.CellValue(1, "act_cust_nm") = "";
  	
  	     formObj.act_cust_cnt_cd.value = "";
  	     formObj.act_cust_seq.value = "";
  	     formObj.act_cust_nm.value = "";
  	     
  	 }
  	 
  	 
 	 
 	 /**
 	 * Customer에 관련된 정보를 조회한다.<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *		custNameFind(eleName);
 	 * </pre>
 	 * @param  {string} eleName 필수 Html Object Name
 	 * @return 없음
 	 * @author 공백진
 	 * @version 2009.05.07
 	 */      
 	 function custNameFind(eleName){
 	     var formObj = document.form;
 	     var sheetObj = sheetObjects[0];
 	     var cust_cnt_cd = formObj.cust_cnt_cd.value;        
 	     var cust_seq = formObj.cust_seq.value;        
 	     
 	     if(cust_cnt_cd != "" && cust_seq !=""){
 	         var sParam = "f_cmd="+COMMAND07+"&etc1="+cust_cnt_cd+"&etc2="+cust_seq;
 	         var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	         var arrText = ComPriXml2Array(sXml, "cd|nm");
 	
 	         if(arrText==undefined){
 	             clearCustName();
 	             formObj.cust_cnt_cd.focus();
 	         }else{           
 	             sheetObj.CellValue2(1,"cust_lgl_eng_nm") = arrText[0][1];
 	             formObj.ctrt_pty_nm.value = arrText[0][1];
 	         }
 	
 	     }
 	     var sheetObj = sheetObjects[0];         
 	     com_change_sheet( sheetObj, eleName);      
 	
 	 }   
 	
 	 
 	 /**
 	 * Actual Customer에 관련된 정보를 조회한다.<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *		actCustNameFind(eleName);
 	 * </pre>
 	 * @param  {string} eleName 필수 Html Object Name
 	 * @return 없음
 	 * @author 공백진
 	 * @version 2009.05.07
 	 */ 
 	 
 	 function actCustNameFind(eleName){
 	     var formObj = document.form;
 	     var sheetObj = sheetObjects[0];
 	     var act_cust_cnt_cd = formObj.act_cust_cnt_cd.value;        
 	     var act_cust_seq = formObj.act_cust_seq.value;        
 	     
 	     if(act_cust_cnt_cd != "" && act_cust_seq !=""){
 	         var sParam = "f_cmd="+COMMAND07+"&etc1="+act_cust_cnt_cd+"&etc2="+act_cust_seq;
 	         var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	         var arrText = ComPriXml2Array(sXml, "cd|nm");
 	
 	         if(arrText==undefined){
 	             clearActCustName();
 	             formObj.act_cust_cnt_cd.focus();
 	         }else{           
 	             sheetObj.CellValue2(1,"act_cust_nm") = arrText[0][1];
 	             formObj.act_cust_nm.value = arrText[0][1];
 	         }
 	
 	     }
 	     var sheetObj = sheetObjects[0];         
 	     com_change_sheet( sheetObj, eleName);      
 	
 	 }   
 	 
 	
     /**
     * Html Object의 값을 변경할 때 숨겨진 Sheet에 변경된 값을 반영한다.<br>
     * 숨겨진 sheet를 이용하여 값을 저장한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *   com_change_sheet( sheetObj, colNm );
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} colNm 필수 Html Object의 name
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */      
     function com_change_sheet( sheetObj, colNm ){
         var eleValue = "";      
         if(document.getElementById(colNm).type=="text"){
             switch(colNm){
                 case "cust_seq":
                     eleValue = ComParseInt(document.getElementById(colNm).value);
                     break;

                 case "act_cust_seq":
                     eleValue = ComParseInt(document.getElementById(colNm).value);
                     break;

                 default:
                     eleValue = document.getElementById(colNm).value;    
                     break;                  
             }           
             sheetObj.CellValue(1,colNm) = eleValue;     

         }else{
             sheetObj.CellValue(1,colNm) = document.getElementById(colNm).Code;          
         }
     }
     


     function meas_sys_cd_OnChange(comboObj, code, text) {
     	
     	sheetObjects[1].Redraw = false;
     	
     	sheetObjects[0].CellValue2( 1, "meas_sys_cd") = code;
     	
     	var sXml = "";
     	if ( sheetObjects[1].RowCount > 0 ){
             sXml = ComPriSheet2Xml ( sheetObjects[1], null, "not_sum_row", "1" );
     	}	
     	
        ComConfigSheet(sheetObjects[1]);
     	initSheet ( sheetObjects[1], 2 );   	
        ComEndConfigSheet(sheetObjects[1]);
        
     	if ( sXml != "" ) {
     		ComPriXml2Sheet ( sheetObjects[1], sXml);
     		sXml = "";
     	}
         
         convertMeasSysCd(sheetObjects[1], code );
         
        mergeTotalLine(sheetObjects[1]);
        sheetObjects[1].Redraw = true;
     }
     
     function convertMeasSysCd ( sheetObj, code ){
     	
     	var ttl_dim_len = 0, ttl_dim_wdt = 0, ttl_dim_hgt = 0, grs_wgt = 0;
     	// Last Row 는 Sum Row 이므로 제외하도록 한다.
     	for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow - 1; i++){
     		ttl_dim_len = sheetObj.CellValue ( i, "ttl_dim_len" );
     		ttl_dim_wdt = sheetObj.CellValue ( i, "ttl_dim_wdt" );
     		ttl_dim_hgt = sheetObj.CellValue ( i, "ttl_dim_hgt" );
     		grs_wgt = sheetObj.CellValue ( i, "grs_wgt" );
     		if ( code == "M" ) {
     			ttl_dim_len = Math.round ( ttl_dim_len * 2.54 );
     			ttl_dim_wdt = Math.round ( ttl_dim_wdt * 2.54 );
     			ttl_dim_hgt = Math.round ( ttl_dim_hgt * 2.54 );
     			grs_wgt     = Math.round ( grs_wgt * 0.453592 );
     		} else if ( code == "I" ) {
     			ttl_dim_len = Math.round ( ( ttl_dim_len / 2.54 ) * 100 ) / 100;
     			ttl_dim_wdt = Math.round ( ( ttl_dim_wdt / 2.54 ) * 100 ) / 100;
     			ttl_dim_hgt = Math.round ( ( ttl_dim_hgt / 2.54 ) * 100 ) / 100;
     			grs_wgt     = Math.round ( ( grs_wgt / 0.453592 ) * 100 ) / 100;
     		}
     		
     		sheetObj.CellValue2 ( i, "ttl_dim_len" ) = ttl_dim_len;
     		sheetObj.CellValue2 ( i, "ttl_dim_wdt" ) = ttl_dim_wdt;
     		sheetObj.CellValue2 ( i, "ttl_dim_hgt" ) = ttl_dim_hgt;
     		sheetObj.CellValue  ( i, "grs_wgt"     ) = grs_wgt;
     		
     	}
     }
     
     
     /* 개발자 작업  끝 */