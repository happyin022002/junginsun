/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_8003.js
*@FileTitle : Awkward Cargo Pricing Application
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.05 문동선
* 1.0 Creation
=========================================================
* History 
* 2013.06.14 송호진 [CHM-201325245] 조직코드 변경 및 병행 관리 관련 기존 코드에 신규 코드 추가. 6 월 말 기존 코드 삭제 예정 ( CAM -> CCM, CTA -> CCA, CTE,CTI -> CCE, COS -> CCS, CGS -> CCB )
* 2013.06.26 이혜민 [CHM-201325215] Special cargo Quotation System 수정 요청 - Approval, Application 화면에 Approver Name 추가, Request ID는 Requester Name으로 변경, Application 필수 입력 사항 추가-Sales rep/Customer/Commodity
* 2013.06.27 송호진 [CHM-201324720] Special Cargo Quotation System 수정 - C/Offer 확인 메시지표시. BB 화면 Text 변경
* 2013.06.27 송호진 [CHM-201325462] 본사 조직 변경에 따른 PRICING MODULE 내에 기존 조직코드 삭제 요청 - CHM-201325245 변경시 남겨놓은 기존 코드 삭제
* 2013.07.03 송호진 [CHM-201324872] Counter Offer Cancel 기능 추가 
* 2013.07.25 송호진 [CHM-201325102] Approval Cancel 기능 추가
* 2014.03.20 송호진 [CHM-201429287] Request 이후 Send Mail Enable 되도록 수정 
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
     * @class ESM_PRI_8003 : ESM_PRI_8003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_8003() {
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
var RTRM_CMB_ID = 4;
var DTRM_CMB_ID = 5;
var BFLG_CMB_ID = 6;
var MEAS_CMB_ID = 7;

var preStsCd = "";  // prog 수행 전 후의 sts_cd 구분을 위한 변수
var liveVerNo = ""; // delt_flg 달리지 않은 가장큰 ver_no, 이 ver_no 에서만 대부분의 prog 가능
var tmpRqstNo = "";
var fistProgUsrId = ""; // 최초 생성자를 저장할 변수

var tempDataStatus = ""; // Calculate 로 생성된 데이터 상태 
var ofcArr = new Array(); // office code list 를 담을 배열
var rout_tmp_yn = false ; // Extra Handling Cost 를 temp 테이블에서 조회해 왔는지 여부
var catalog_flg = false ; // catalog 새로이 반영된 경우인지 
var polpod_chg_flg = false ; // pol pod 변경 flag, product cata 사용시 다시 false 로
var cgoinfo_chg_flg = false; // cargo sheet 변경 flag, calcuration 사용시 다시 false 로
var cfinfo_chg_flg = false; // hdr sheet 변경 flag 

// Counter Offer 시에 변경된 값을 체크하기 위해 조회 field 저장 ( Duration ) 
var p_date1_origin = "";
var p_date2_origin = "";
var cntrTpSzXml    = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	function check_temporary_data_exists( checkFlg ) {
		
		var formObj = document.form;
	
		if ( formObj.scq_ver_no_tmp.value != null && ComTrim(formObj.scq_ver_no_tmp.value) != '' ){
			if(checkAuth()){ // 권한이 있는 경우
				if ( checkFlg == 0 ) { // 선택하기
					execScript("rtn = msgbox(\"There is data remains by Calculate. Will you save it? [Yes:Save, No:Ignore]\", 4, \"Calculate Confirm\")", "vbscript");
			    	if (rtn == 6) { // Yes : Save Case
			    		doActionIBSheet ( sheetObjects[2], document.form, MULTI13 );
			    	} else if (rtn == 7) { // No : Ignore Case
			    		doActionIBSheet ( sheetObjects[2], document.form, MULTI12 );
			    	}
				} else if ( checkFlg == 1 ){ // 저장하기			
					doActionIBSheet ( sheetObjects[2], document.form, MULTI13 );
				} else if ( checkFlg == 2 ){ // 지우기		
					doActionIBSheet ( sheetObjects[2], document.form, MULTI12 );
				}
			}else{
				doActionIBSheet ( sheetObjects[2], document.form, MULTI12 );// 지우기
			}
	    	formObj.scq_ver_no_tmp.value = "";
		}		
	}
	
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
                	check_temporary_data_exists(2);
                	formObj.rmk_req.value = "";
					formObj.rmk_appr.value = "";
					formObj.rqst_basic_rate.value = "";
					formObj.rqst_void_rate.value = "";
					formObj.apro_basic_rate.value = "";
					formObj.apro_void_rate.value = "";
					formObj.apro_usr_nm.value = "";
                
                	sheetObjects[2].RemoveAll();
                	sheetObjects[1].RemoveAll();
                	sheetObjects[0].RemoveAll();
                	formObj.scq_rqst_no.value = "";
                	formObj.scq_ver_no.value = "";
                	comboObjects[VERN_CMB_ID].RemoveAll();
                	formObj.svc_scp_cd_combo.RemoveAll();
                	updateForm();
	                liveVerNo = "";
	                preStsCd = "";
	                doActionIBSheet(sheetObjects[0],document.form,IBCREATE); // 히든 헤더 시트에 초기값 세팅
	                toggleButtons("NEW");
	                toggleForms("NEW");
	                break;
	            case "btn_copy":
	            	check_temporary_data_exists(2);
                	preStsCd = "";
                	document.form.rqst_ofc_cd.value = document.form.in_usr_ofc_cd.value;
					doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
					doActionIBSheet(sheetObjects[0],document.form,SEARCH07);
                	sheetObjects[2].RemoveAll();
                	sheetObjects[2].DataInsert(0);
					sheetObjects[2].CellValue(1,"prog_sts_cd") = "";
                	sheetObjects[2].CellValue(1,"pq_prog_sts_cd") = "";
                	for(var i=2; i<=sheetObjects[0].LastRow; i++){
                		if(sheetObjects[0].CellValue(i,"ibflag") != "D"){
                			
                    		sheetObjects[0].SelectRow = i;
                    		overDimensionSettingHeight();
                    		overDimensionSettingLength();
                    		overDimensionSettingWidth();
                			
                    		sheetObjects[0].CellValue(i,"ibflag") = "I";
                			sheetObjects[0].CellValue(i,"apro_bsrt_amt") = "";
                			sheetObjects[0].CellValue(i,"apro_void_rt_amt") = "";
                		}
                		
                	}
                	formObj.apro_basic_rate.value = "";
					formObj.apro_void_rate.value = "";
                	for(var i=2; i<=sheetObjects[1].LastRow; i++){
                		sheetObjects[1].CellValue(i,"ibflag") = "I";
                	}
                	formObj.scq_rqst_no.value = "";
                	formObj.scq_ver_no.value = "";
                	formObj.prog_sts_nm.value = "";
                	formObj.rmk_appr.value = "";
                	formObj.apro_usr_nm.value = "";
                	formObj.first_cre_usr_nm.value = "";
                	formObj.a_date1.value = "";
                	formObj.a_date2.value = "";
                	doActionIBSheet(sheetObjects[0],document.form,SEARCH04);
                	//comboObjects[SSCP_CMB_ID].Text = sheetObjects[2].CellValue(1,"svc_scp_cd");
                	sheetObjects[1].RemoveAll();
                	sheetObjects[3].RemoveAll();
                	for(var i=2;i<=sheetObj.LastRow;i++){
						sheetObj.CellBackColor(i,"prop_bsrt_amt") = sheetObj.RgbColor(0,0,0);
						sheetObj.CellBackColor(i,"prop_void_rt_amt") = sheetObj.RgbColor(0,0,0);
					}
                	rout_tmp_yn = false;
                	toggleButtons("CREATE");
	                toggleForms("CREATE");
	                setSheetsEditable(true);
	                break;	
                case "btn_retrieve":
                	check_temporary_data_exists(2);
                	formObj.scq_ver_no.value = comboObjects[VERN_CMB_ID].Code;
                	ComOpenWait(true);
                	doActionIBSheet(sheetObjects[0], document.form, SEARCH04); // Ver 조회
                	doActionIBSheet(sheetObjects[2], document.form, SEARCH01); // 히든 헤더 sheet 조회
					doActionIBSheet(sheetObjects[2], document.form, IBSEARCH); // Cargo sheet 조회
					doActionIBSheet(sheetObjects[1], document.form, SEARCH02); // Extar Handling Cost by Route 조회
					doActionIBSheet(sheetObjects[1], document.form, SEARCH07);
					updateForm();
					ComOpenWait(false);
					toggleButtons(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					break;	
				case "btn_save":
					ComOpenWait(true);
					
					if(sheetObjects[2].CellValue(1,"prog_sts_cd")==""){
						preStsCd = "CREATE";
					}else{
                		preStsCd = sheetObjects[2].CellValue(1,"prog_sts_cd");
                		sheetObjects[2].CellValue(1,"pre_prog_sts_cd") = sheetObjects[2].CellValue(1,"prog_sts_cd");
					}
					sheetObjects[2].CellValue(1,"prog_sts_cd") = "T";
                	sheetObjects[2].CellValue(1,"pq_prog_sts_cd") = "T";
                	var rst = doActionIBSheet(sheetObjects[0],document.form,MULTI10);
                	
                	formObj.scq_rqst_no.value = sheetObjects[2].CellValue(1,"scq_rqst_no");
                	formObj.scq_ver_no.value = sheetObjects[2].CellValue(1,"scq_ver_no");
                	
                	if(rst){ //Save 일 땐 알아서 계산까지 하고 저장하게 해달라는 현업 요청
                		if(sheetObjects[0].RowCount > 0 && sheetObjects[1].RowCount > 0){
		                	check_temporary_data_exists(2);
		                	tmp_rout_tmp_yn = false;
		                	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); //cargo sheet 조회
							doActionIBSheet(sheetObjects[1], document.form, MULTI11); // 재 계산
							doActionIBSheet ( sheetObjects[2], document.form, MULTI13 ); // 테이블에 저장
							catalog_flg = false;
							cgoinfo_chg_flg = false;
							doActionIBSheet(sheetObjects[1], document.form, SEARCH02); // Extar Handling Cost by Route 조회
                		}
                		doActionIBSheet(sheetObjects[0], document.form, SEARCH04); // Ver 조회
	                	doActionIBSheet(sheetObjects[2], document.form, SEARCH01); // 히든 헤더 sheet 조회
						doActionIBSheet(sheetObjects[2], document.form, IBSEARCH); // Cargo sheet 조회
						doActionIBSheet(sheetObjects[1], document.form, SEARCH02); // Extar Handling Cost by Route 조회
						doActionIBSheet(sheetObjects[1], document.form, SEARCH07);
						updateForm();
                	}
                	
                	ComOpenWait(false);
                	toggleButtons(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[2].CellValue(1,"prog_sts_cd"));
	                break;		
                case "btn_request":
                	if(rout_tmp_yn){
                		check_temporary_data_exists(1);
                	}
                	ComOpenWait(true);
                	preStsCd = sheetObjects[2].CellValue(1,"prog_sts_cd");
                	sheetObjects[2].CellValue(1,"pre_prog_sts_cd") = sheetObjects[2].CellValue(1,"prog_sts_cd");
                	sheetObjects[2].CellValue(1,"prog_sts_cd") = "Q";
                	sheetObjects[2].CellValue(1,"pq_prog_sts_cd") = "Q";
                	doActionIBSheet(sheetObjects[0],document.form,MULTI10);
                	
                	ComOpenWait(false);
                	toggleButtons(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					break;
					
				case "btn_countoffer":
				   if ( sheetObjects[0].isDataModified != true && 
						 sheetObjects[1].isDataModified != true &&
						 p_date1_origin == formObj.p_date1.value &&
						 p_date2_origin == formObj.p_date2.value &&
						 formObj.scq_ver_no_tmp.value == "" ){
						if ( ComShowCodeConfirm("PRI09023") == false ) {
		            		return;
		            	}
					}
					var cp_scq_rqst_no = sheetObjects[2].CellValue(1,"scq_rqst_no"); //
                	var cp_scq_ver_no_tmp = formObj.scq_ver_no_tmp.value; //
                	var tmp_rout_tmp_yn = rout_tmp_yn;
                	
					ComOpenWait(true);
					preStsCd = sheetObjects[2].CellValue(1,"prog_sts_cd");
					sheetObjects[2].CellValue(1,"pre_prog_sts_cd") = sheetObjects[2].CellValue(1,"prog_sts_cd");
                	sheetObjects[2].CellValue(1,"prog_sts_cd") = "O";
                	sheetObjects[2].CellValue(1,"pq_prog_sts_cd") = "O";
                	var rst = doActionIBSheet(sheetObjects[0],document.form,MULTI10);
                	
                	var cp_scq_ver_no = sheetObjects[2].CellValue(1,"scq_ver_no"); //
                	sheetObjects[2].CellValue(1,"scq_rqst_no") = cp_scq_rqst_no;
                	sheetObjects[2].CellValue(1,"scq_ver_no") = cp_scq_ver_no;
                	sheetObjects[2].CellValue(1,"scq_ver_no_tmp") = formObj.scq_ver_no_tmp.value;
                	
                	if(tmp_rout_tmp_yn && rst){
                		check_temporary_data_exists(1);
                		doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
                	}
                	
                	ComOpenWait(false);
                	toggleButtons(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					break;	
				case "btn_cancel":
					if ( !ComShowCodeConfirm("PRI00015") )return;
					ComOpenWait(true);
					preStsCd = sheetObjects[2].CellValue(1,"prog_sts_cd");
					sheetObjects[2].CellValue(1,"pre_prog_sts_cd") = sheetObjects[2].CellValue(1,"prog_sts_cd");
                	sheetObjects[2].CellValue(1,"prog_sts_cd") = "C";
                	sheetObjects[2].CellValue(1,"pq_prog_sts_cd") = "C";
                	doActionIBSheet(sheetObjects[0],document.form,MULTI10);
                	ComOpenWait(false);
                	toggleButtons(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					break;		
				case "btn_delete":
					ComOpenWait(true);
					preStsCd = sheetObjects[2].CellValue(1,"prog_sts_cd");
					sheetObjects[2].CellValue(1,"pre_prog_sts_cd") = sheetObjects[2].CellValue(1,"prog_sts_cd");
                	sheetObjects[2].CellValue(1,"ibflag") = "D";
                	sheetObjects[2].CellValue(1,"prog_sts_cd") = "D";
                	// 히든 헤더 시트의 ibflag D 로 해서 저장 하면  main 테이블 delt flag 에 Y, 
                	// prog 테이블에 기존과 동일 prog_sts_cd 로 저장 (remark 위함)
					var rst = doActionIBSheet(sheetObjects[0],document.form,MULTI10);
					
					if(rst && sheetObjects[2].CellValue(1,"prog_sts_cd")=="T"){
		       			doActionIBSheet(sheetObjects[2],document.form,SEARCH04); //VerNo 콤보 재 조회
		       			doActionIBSheet(sheetObjects[2],document.form,SEARCH01); //헤더 재 조회
		       			doActionIBSheet(sheetObjects[2],document.form,IBSEARCH); //카고 재 조회
			       		doActionIBSheet(sheetObjects[2],document.form,SEARCH02); //라우트 재 조회
		       			updateForm();
		       		}
					
					ComOpenWait(false);
                	toggleButtons(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[2].CellValue(1,"prog_sts_cd"));
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


                case "btn_close":
                    window.close();
                    break;
                    
                case "btn_rowadd":
                	addRow();
                	cgoinfo_chg_flg = true;
	     			setTotalRate();	
                	break;    
				
				case "btn_rowcopy":
					cgoinfo_chg_flg = true; // count offer flg 갱신, 값 변경 체크용
                	for(var i=2; i<=sheetObj.LastRow; i++){
						if(sheetObj.CellValue(i,"del_chk")=="1"){
							var tmprow = addRow();
							sheetObj.CellValue2(tmprow,"cntr_tpsz_cd") = sheetObj.CellValue(i,"cntr_tpsz_cd");
							sheetObj.CellValue2(tmprow,"cntr_qty") = sheetObj.CellValue(i,"cntr_qty");
							sheetObj.CellValue2(tmprow,"cmdt_cd") = sheetObj.CellValue(i,"cmdt_cd");
							sheetObj.CellValue2(tmprow,"cmdt_nm") = sheetObj.CellValue(i,"cmdt_nm");
							sheetObj.CellValue2(tmprow,"ttl_dim_len") = sheetObj.CellValue(i,"ttl_dim_len");
							sheetObj.CellValue2(tmprow,"ttl_dim_wdt") = sheetObj.CellValue(i,"ttl_dim_wdt");
							sheetObj.CellValue2(tmprow,"ttl_dim_hgt") = sheetObj.CellValue(i,"ttl_dim_hgt");
							sheetObj.CellValue2(tmprow,"ovr_fwrd_len") = sheetObj.CellValue(i,"ovr_fwrd_len");
							sheetObj.CellValue2(tmprow,"ovr_bkwd_len") = sheetObj.CellValue(i,"ovr_bkwd_len");
							sheetObj.CellValue2(tmprow,"ovr_lf_len") = sheetObj.CellValue(i,"ovr_lf_len");
							sheetObj.CellValue2(tmprow,"ovr_rt_len") = sheetObj.CellValue(i,"ovr_rt_len");
							sheetObj.CellValue2(tmprow,"ovr_hgt") = sheetObj.CellValue(i,"ovr_hgt");
							sheetObj.CellValue2(tmprow,"grs_wgt") = sheetObj.CellValue(i,"grs_wgt");
							sheetObj.CellValue2(tmprow,"ovr_void_slt_qty") = sheetObj.CellValue(i,"ovr_void_slt_qty");
							sheetObj.CellValue2(tmprow,"prop_bsrt_amt") = sheetObj.CellValue(i,"prop_bsrt_amt");
							sheetObj.CellValue2(tmprow,"prop_void_rt_amt") = sheetObj.CellValue(i,"prop_void_rt_amt");
							//sheetObj.CellValue2(tmprow,"apro_bsrt_amt") = sheetObj.CellValue(i,"apro_bsrt_amt");
							//sheetObj.CellValue2(tmprow,"apro_void_rt_amt") = sheetObj.CellValue(i,"apro_void_rt_amt");
						}
					}
	     			setTotalRate();	
                	break;   
				
				case "btn_rowdel":
					for(var i=2; i<=sheetObj.LastRow; i++){
						if(sheetObj.CellValue(i,"del_chk")=="1"){
							if(sheetObj.CellValue(i,"ibflag")=="I"){
								sheetObj.RowDelete(i, false);
								i--;
							}else{
								sheetObj.RowHidden(i) = true;
								sheetObj.CellValue(i,"ibflag")="D";
							}
						}
					}
					cgoinfo_chg_flg = true;
	     			setTotalRate();		
					break;
					
				case "btn_productCatalog":
					var sUrl = "/hanjin/ESM_PRI_8102.do?";
                    sUrl += "pop_mode=Y";
                    sUrl += "&pol_port_cd="+form.pol_cd.value;
                    sUrl += "&pod_port_cd="+form.pod_cd.value;
                    
                    var rtnVal = ComOpenPopup(sUrl,1020,470,"","0,1", true);
                    
                    if ( rtnVal != null && rtnVal.length > 0 ) {
                    	if(tmp_rout_tmp_yn){
	                		check_temporary_data_exists(2); //tmp 테이블 삭제
	                	}
                    	polpod_chg_flg = false;
                    	
                    	sheetObjects[1].RemoveAll();
    					for ( var i = 0; i < rtnVal.length; i++) {
							var idx = sheetObjects[1].DataInsert();
							
							sheetObjects[1].CellValue(idx, "rout_tp_cd") = rtnVal[i].rout_tp_cd;
							sheetObjects[1].CellValue(idx, "rout_tp_seq") = rtnVal[i].rout_tp_seq;
							sheetObjects[1].CellValue(idx, "lane_cd") = rtnVal[i].lane_cd;
							sheetObjects[1].CellValue(idx, "ib_yd_cd") = rtnVal[i].ib_yd_cd;
							sheetObjects[1].CellValue(idx, "ob_yd_cd") = rtnVal[i].ob_yd_cd;
							sheetObjects[1].CellValue(idx, "rout_seq") = i+1;
    					}
    					
    					formObj.pol_cd.value = rtnVal[0].ob_yd_cd.substring(0,5);
    					formObj.pol_yd_cd.value = rtnVal[0].ob_yd_cd.substring(5,7);
    					formObj.pod_cd.value = rtnVal[rtnVal.length-1].ib_yd_cd.substring(0,5);
    					formObj.pod_yd_cd.value = rtnVal[rtnVal.length-1].ib_yd_cd.substring(5,7);
                  	}
                  	doActionIBSheet(sheetObjects[0],document.form,SEARCH07);
                  	
                  	catalog_flg = true;
					break;
				
				case "btn_por_cd":
                case "btn_pol_cd":
                case "btn_pod_cd":
                case "btn_del_cd":
                	//ESM_PRI_0108_02.js 참조
                	if(window.event.srcElement.style.cursor == "hand"){
	                    var sUrl = "/hanjin/ESM_PRI_4026.do?";
	                    sUrl += "group_cmd=" + PRI_SP_SCP;
	                    sUrl += "&location_cmd=L";
	                    var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 300, true);
	                    if (rtnVal != null){
	                        if(srcName == "btn_por_cd") {
	                            form.por_cd.value = rtnVal.cd;
	                        }else if(srcName == "btn_pol_cd"){
	                            form.pol_cd.value = rtnVal.cd;
	                        }else if(srcName == "btn_pod_cd"){
	                            form.pod_cd.value = rtnVal.cd;
	                        }else if(srcName == "btn_del_cd"){
	                            form.del_cd.value = rtnVal.cd;
	                        }
	                    }
                    }
                    break;
                
                case "btn_customer":
                	if(window.event.srcElement.style.cursor == "hand"){
		                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_8105.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.cust_cnt_cd.value+"&cust_seq="+formObj.cust_seq.value, "", 640, 465, true);
		            	if (rtnVal != null){
		                    formObj.cust_cnt_cd.value = rtnVal.custCntCd;
		                    formObj.cust_seq.value = rtnVal.custSeq;
		                    formObj.ctrt_pty_nm.value = rtnVal.custNm;   
		                    
		                    if ( sheetObjects[2] != null && sheetObjects[2].RowCount > 0 ) {
			                    sheetObjects[2].CellValue2(1, "cust_cnt_cd") = rtnVal.custCntCd;
			                    sheetObjects[2].CellValue2(1, "cust_lgl_eng_nm") = rtnVal.custNm;
			           	     	com_change_sheet( sheetObjects[2], "cust_seq");
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
		                    
		                    if ( sheetObjects[2] != null && sheetObjects[2].RowCount > 0 ) {
			                    sheetObjects[2].CellValue2(1, "act_cust_cnt_cd") = rtnVal.custCntCd;
			                    sheetObjects[2].CellValue2(1, "act_cust_nm") = rtnVal.custNm;
			           	     	com_change_sheet( sheetObjects[2], "act_cust_seq");
		                    }
		                  
		                }
					}
	                break;     
                    
				case "btn_sendmail":
					sendMail();
					break;
					
				case "btn_calculation":
                	check_temporary_data_exists(2); //tmp 테이블 삭제
                	tmp_rout_tmp_yn = false;
					doActionIBSheet(sheetObjects[1], document.form, MULTI11);
					catalog_flg = false;
					cgoinfo_chg_flg = false;
					break;	
				
				case "btn_attachfile":
					var urlParam = "ESM_PRI_8101.do?p_scq_rqst_no="+formObj.scq_rqst_no.value
									+"&p_spcl_cgo_tp_cd=AK";
        			if(checkAuth()){
						urlParam += "&p_editable=Y";        			
        			}
    				ComOpenPopup(urlParam, 525, 440, "", "0,0,1,1,1,1,1", true);
					break;
				case "btn_commonattach": 
					ComOpenPopup("VOP_SCG_0080.do", 1024, 600, "", "0,0,1,1,1,1,1", false, "", "", "", "", "Special Cargo Guidanace", "yes");
    				break;
					
				case "btn_previous":
					check_temporary_data_exists(2);
					document.form.scq_rqst_no.value = prev_rqstno;
					document.form.scq_ver_no.value = prev_verno;
					ComOpenWait(true);
		        	doActionIBSheet(sheetObjects[1], document.form, SEARCH04);
		        	doActionIBSheet(sheetObjects[2], document.form, SEARCH01); // 히든 헤더 sheet 조회
					doActionIBSheet(sheetObjects[2], document.form, IBSEARCH); // Cargo sheet 조회
					doActionIBSheet(sheetObjects[1], document.form, SEARCH02); // Extar Handling Cost by Route 조회
					doActionIBSheet(sheetObjects[1], document.form, SEARCH07);
					updateForm();
					ComOpenWait(false);
					toggleButtons(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					
					setPreviousNextBtn();
					break;	
				case "btn_next":
					check_temporary_data_exists(2);
					document.form.scq_rqst_no.value = next_rqstno;
					document.form.scq_ver_no.value = next_verno;
					ComOpenWait(true);
		        	doActionIBSheet(sheetObjects[1], document.form, SEARCH04);
		        	doActionIBSheet(sheetObjects[2], document.form, SEARCH01); // 히든 헤더 sheet 조회
					doActionIBSheet(sheetObjects[2], document.form, IBSEARCH); // Cargo sheet 조회
					doActionIBSheet(sheetObjects[1], document.form, SEARCH02); // Extar Handling Cost by Route 조회
					doActionIBSheet(sheetObjects[1], document.form, SEARCH07);
					updateForm();
					ComOpenWait(false);
					toggleButtons(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					toggleForms(sheetObjects[2].CellValue(1,"prog_sts_cd"));
					
					setPreviousNextBtn();
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
            		&& event.keyCode!=37 && event.keyCode!=38 && event.keyCode!=39 && event.keyCode!=40 && event.keyCode!=8 && event.keyCode!=46 && event.keyCode!=9){ // 방향키, BackSpace, Delete 키
            		formObj.scq_ver_no.value = "";
	            	doActionIBSheet(sheetObjects[0], document.form, SEARCH04);

	            	if(formObj.scq_ver_no_combo.Text != ""){
	            		formObj.scq_ver_no.value = comboObjects[VERN_CMB_ID].Code;
	                	ComOpenWait(true);
	                	doActionIBSheet(sheetObjects[2], document.form, SEARCH01); // 히든 헤더 sheet 조회
						doActionIBSheet(sheetObjects[2], document.form, IBSEARCH); // Cargo sheet 조회
						doActionIBSheet(sheetObjects[1], document.form, SEARCH02); // Extar Handling Cost by Route 조회
						doActionIBSheet(sheetObjects[1], document.form, SEARCH07);
						updateForm();
						ComOpenWait(false);
						toggleButtons(sheetObjects[2].CellValue(1,"prog_sts_cd"));
						toggleForms(sheetObjects[2].CellValue(1,"prog_sts_cd"));
	            	}
                }
                break;         
        	default:
                break;
        }
    }     


    function obj_dblclick() {
        var formObj = document.form;
        var eleName = event.srcElement.name;

        switch(eleName){
            case "rmk_req":
            case "rmk_appr":
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
    
	/**
    * 초기 이벤트 등록 
    */
    function initControl() {
    	
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        axon_event.addListenerForm('focusout', 'obj_focusout', document.form);
        axon_event.addListenerForm('dblclick', 'obj_dblclick', document.form);
        axon_event.addListenerFormat('keypress',        'obj_keypress', form);
        axon_event.addListener('keyup', 'obj_onkeyup', 'scq_rqst_no', '');
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
    * @author 공백진
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

        // 페이지 로딩시 focus
        // document.form.p_cntrno.focus();
		
		initControl();
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

        ComPriTextCode2ComboItem(prcScqAproOfcCdValue, prcScqAproOfcCdText, getComboObject(comboObjects, 'apro_ofc_cd') ,"|","\t" );
        ComPriTextCode2ComboItem(measSysCdValue, measSysCdText, getComboObject(comboObjects, 'meas_sys_cd') ,"|","\t" );
        
		//p_rqstno 있으면 조회, p_verno 있으면 그 VerNo 로 조회하고, 없으면 liveNo 를 조회함
		if (document.form.p_rqstno.value){
			document.form.scq_rqst_no.value = document.form.p_rqstno.value;
			document.form.scq_ver_no.value = document.form.p_verno.value;
			ComOpenWait(true);
        	doActionIBSheet(sheetObjects[1], document.form, SEARCH04);
        	doActionIBSheet(sheetObjects[2], document.form, SEARCH01); // 히든 헤더 sheet 조회
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH); // Cargo sheet 조회
			doActionIBSheet(sheetObjects[1], document.form, SEARCH02); // Extar Handling Cost by Route 조회
			doActionIBSheet(sheetObjects[1], document.form, SEARCH07);
			updateForm();
			ComOpenWait(false);
			toggleButtons(sheetObjects[2].CellValue(1,"prog_sts_cd"));
			toggleForms(sheetObjects[2].CellValue(1,"prog_sts_cd"));
		}else{
			doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
			toggleButtons("NEW");
			toggleForms("NEW");
		}
		setPreviousNextBtn();
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var HeadTitle1 = "";
        var HeadTitle2 = "";
        var len_unit = "";
        var wgt_unit = "";
        var meas_sys_cd = "";
        if ( sheetObjects.length > 0 && sheetObjects[2].RowCount > 0 ) {
        	meas_sys_cd = sheetObjects[2].CellValue ( 1, "meas_sys_cd");
        }

        if ( meas_sys_cd == "M" || meas_sys_cd == "" ) {
        	len_unit = "cm";
        	wgt_unit = "kgs";
        } else if ( meas_sys_cd == "I") {
        	len_unit = "inch";
        	wgt_unit = "lbs";        	
        }

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 158;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    var HeadTitle1 = "||TP\nSZ|Q'ty|cmdt_cd|Commodity|Overall("+len_unit+")|Overall("+len_unit+")|Overall("+len_unit+")|Over Dimension("+len_unit+")|Over Dimension("+len_unit+")|Over Dimension("+len_unit+")|Over Dimension("+len_unit+")|Over Dimension("+len_unit+")|"
        							+"Gross\nWeight\n("+wgt_unit+")|Void\n(Q'ty)\n(Q2/Q4)|Proposal Rate\n(USD)|Proposal Rate\n(USD)|Approval Rate\n(USD)|Approval Rate\n(USD)|Total Approval Rate\n(USD)\n(Including Void)|scq_rqst_no|scq_ver_no|cgo_seq|scq_ver_no_tmp";
                    var HeadTitle2 = "||TP\nSZ|Q'ty|cmdt_cd|Commodity|L|W|H|FWD|AFT|Left|Right|Hight|"
                    				+"Gross\nWeight\n("+wgt_unit+")|Void\n(Q'ty)\n(Q2/Q4)|Basic\n(Per Box)|Void\n(Per Box)|Basic\n(Per Box)|Void\n(Per Box)|Total Approval Rate\n(USD)\n(Including Void)|scq_rqst_no|scq_ver_no|cgo_seq|scq_ver_no_tmp";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다 (Row, HeadText, [RowMerge], [Hidden])
                    InitHeadMode(false, false, false, true, false, false);

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;
                    
                    // 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtHiddenStatus,30, daLeft,	 false,    "ibflag");
                    InitDataProperty(0, cnt++,    dtCheckBox,30,     daCenter,   true,     "del_chk",           false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtCombo,   40,     daCenter,   true,     "cntr_tpsz_cd",      true,     "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    40,     daCenter,   true,     "cntr_qty",          true,     "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,  65,     daCenter,   true,     "cmdt_cd",        	false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtPopup,  105,     daLeft,     true,     "cmdt_nm",        	true,     "",    dfNone,    0,    true,    true);
                    
                    if ( meas_sys_cd == "M" || meas_sys_cd == "" ) {
                    	InitDataProperty(0, cnt++,    dtData,    50,     daRight,    false,    "ttl_dim_len",       true,     "",    dfNone,    0,    true,    true);
                    	InitDataProperty(0, cnt++,    dtData,    50,     daRight,    false,    "ttl_dim_wdt",       true,     "",    dfNone,    0,    true,    true);
                    	InitDataProperty(0, cnt++,    dtData,    50,     daRight,    false,    "ttl_dim_hgt",       true,     "",    dfNone,    0,    true,    true);
            	                            
                    	InitDataProperty(0, cnt++,    dtData,    40,     daRight,    false,    "ovr_fwrd_len",      false,    "",    dfNone,    0,    true,    true);
                    	InitDataProperty(0, cnt++,    dtData,    40,     daRight,    false,    "ovr_bkwd_len",      false,    "",    dfNone,    0,    true,    true);
                    	InitDataProperty(0, cnt++,    dtData,    40,     daRight,    false,    "ovr_lf_len",        false,    "",    dfNone,    0,    true,    true);
                    	InitDataProperty(0, cnt++,    dtData,    40,     daRight,    false,    "ovr_rt_len",        false,    "",    dfNone,    0,    true,    true);
                    	InitDataProperty(0, cnt++,    dtData,    40,     daRight,    false,    "ovr_hgt",           false,    "",    dfNone,    0,    true,    true);
            	        
                    	InitDataProperty(0, cnt++,    dtData,    70,     daRight,    true,     "grs_wgt",           true,     "",    dfNone,    0,    true,    true);
                    } else if( meas_sys_cd == "I") {
                    	InitDataProperty(0, cnt++,    dtData,    50,     daRight,    false,    "ttl_dim_len",       true,     "",    dfNullFloat,    2,    true,    true);
                    	InitDataProperty(0, cnt++,    dtData,    50,     daRight,    false,    "ttl_dim_wdt",       true,     "",    dfNullFloat,    2,    true,    true);
                    	InitDataProperty(0, cnt++,    dtData,    50,     daRight,    false,    "ttl_dim_hgt",       true,     "",    dfNullFloat,    2,    true,    true);
            	                            
                    	InitDataProperty(0, cnt++,    dtData,    40,     daRight,    false,    "ovr_fwrd_len",      false,    "",    dfNullFloat,    2,    true,    true);
                    	InitDataProperty(0, cnt++,    dtData,    40,     daRight,    false,    "ovr_bkwd_len",      false,    "",    dfNullFloat,    2,    true,    true);
                    	InitDataProperty(0, cnt++,    dtData,    40,     daRight,    false,    "ovr_lf_len",        false,    "",    dfNullFloat,    2,    true,    true);
                    	InitDataProperty(0, cnt++,    dtData,    40,     daRight,    false,    "ovr_rt_len",        false,    "",    dfNullFloat,    2,    true,    true);
                    	InitDataProperty(0, cnt++,    dtData,    40,     daRight,    false,    "ovr_hgt",           false,    "",    dfNullFloat,    2,    true,    true);
            	        
                    	InitDataProperty(0, cnt++,    dtData,    70,     daRight,    true,     "grs_wgt",           true,     "",    dfNullFloat,    2,    true,    true);
                    }
                    
                    InitDataProperty(0, cnt++,    dtData,    60,     daCenter,   true,     "ovr_void_slt_qty", 	false,    "",    dfNone,    0,    true,    true);
                    
                    InitDataProperty(0, cnt++,    dtData,	 70,     daRight,    false,    "prop_bsrt_amt",     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData, 	 70,     daRight,    false,    "prop_void_rt_amt",  false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData, 	 70,     daRight,    false,    "apro_bsrt_amt",     false,    "",    dfNone,    0,    false,   false);
                    InitDataProperty(0, cnt++,    dtData, 	 50,     daRight,    false,    "apro_void_rt_amt",  false,    "",    dfNone,    0,    false,   false);
                    InitDataProperty(0, cnt++,    dtData, 	 140,    daRight,    true,     "ttl_amt",		    false,    "",    dfNone,    0,    false,   false);
                    
                    InitDataProperty(0, cnt++,    dtHidden,  60,     daRight,    false,    "scq_rqst_no",       false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,  60,     daRight,    false,    "scq_ver_no",  		false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,  60,     daRight,    false,    "cgo_seq",  			false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtHidden,  60,     daRight,    false,    "scq_ver_no_tmp",  	false,    "",    dfNone,    0,    true,    true);
                   
                    CountPosition = 0;
                    ShowButtonImage = 1; // editable 인 경우만 돋보기 버튼 보임
                    
					// 입력 형식 지정
					InitDataValid(0, "cntr_qty", vtNumericOnly);
                    if ( meas_sys_cd != "I") {
						InitDataValid(0, "ttl_dim_len", vtNumericOnly);
						InitDataValid(0, "ttl_dim_wdt", vtNumericOnly);
						InitDataValid(0, "ttl_dim_hgt", vtNumericOnly);
						InitDataValid(0, "ovr_fwrd_len", vtNumericOnly);
						InitDataValid(0, "ovr_bkwd_len", vtNumericOnly);
						InitDataValid(0, "ovr_lf_len", vtNumericOnly);
						InitDataValid(0, "ovr_rt_len", vtNumericOnly);
						InitDataValid(0, "ovr_hgt", vtNumericOnly);
						InitDataValid(0, "grs_wgt", vtNumericOnly);
                    }
					InitDataValid(0, "ovr_void_slt_qty", vtNumericOther, "."); //소수점 사용해야 할 경우
					InitDataValid(0, "prop_bsrt_amt", vtNumericOnly);
					InitDataValid(0, "prop_void_rt_amt", vtNumericOnly);
					InitDataValid(0, "apro_bsrt_amt", vtNumericOnly);
					InitDataValid(0, "apro_void_rt_amt", vtNumericOnly);
					SelectHighLight = false;
                    WaitImageVisible = false;
                    
                    // row 높이 지정
                    RowHeight(0) = 28;
                    RowHeight(1) = 28;
                }
                break;
                
             case 2:      //sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 164;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    var HeadTitle1 = "|Route|rout_tp_seq|Lane|Route|Route|Terminal Handling Cost|Terminal Handling Cost|Terminal Handling Cost|Terminal Handling Cost|Terminal Handling Cost|Terminal Handling Cost|T/S|T/S|Shuttle|Shuttle|Add-On|Add-On|scq_rqst_no|scq_ver_no|cgo_seq|scq_ver_no_tmp|n_cost_zero_exist|w_cost_zero_exist|g_cost_zero_exist|t_cost_zero_exist|s_cost_zero_exist|a_cost_zero_exist";
                    var HeadTitle2 = "|Route|rout_tp_seq|Lane|In|Out|Normal|Normal|Wire|Wire|S.Gear|S.Gear|T/S|T/S|Shuttle|Shuttle|Add-On|Add-On|scq_rqst_no|scq_ver_no|cgo_seq|scq_ver_no_tmp";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                    InitHeadMode(false, false, true, true, false, false);

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW, COL,  DATATYPE,  WIDTH, DATAALIGN, COLMERGE,     SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,      30,	daCenter,	true,	"ibflag", 	false,    "",    dfNone,    0,    true,  true); 
                    InitDataProperty(0, cnt++ , dtCombo,      45,	daCenter,	true,	"rout_tp_cd", 	false,    "",    dfNone,    0,    true,  true); 
                    InitDataProperty(0, cnt++ , dtHidden,    40,	daCenter,	true,	"rout_tp_seq",  false,    "",    dfNone,    0,    false, false); 
                    InitDataProperty(0, cnt++ , dtData,      40,	daCenter,	true,	"lane_cd",    	false,    "",    dfNone,    0,    true,  true); 
                    InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	"ib_yd_cd",   	false,    "",    dfNone,    0,    true,  true, 7); 
                    InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	"ob_yd_cd",   	false,    "",    dfNone,    0,    true,  true, 7); 
                    InitDataProperty(0, cnt++ , dtAutoSum,   60,	daRight,	true,	"n_cost",     	false,    "",    dfNone,    0,    false, false); 
                    InitDataProperty(0, cnt++ , dtPopupEdit, 20,	daCenter,	false,	"n_cost_pop", 	false,    "",    dfNone,    0,    false, false);        
                    InitDataProperty(0, cnt++ , dtAutoSum,   60,	daRight,	true,	"w_cost",     	false,    "",    dfNone,    0,    false, false); 
                    InitDataProperty(0, cnt++ , dtPopupEdit, 20,	daCenter,	false,	"w_cost_pop", 	false,    "",    dfNone,    0,    false, false);        
                    InitDataProperty(0, cnt++ , dtAutoSum,   60,	daRight,	true,	"g_cost",     	false,    "",    dfNone,    0,    false, false); 
                    InitDataProperty(0, cnt++ , dtPopupEdit, 20,	daCenter,	false,	"g_cost_pop", 	false,    "",    dfNone,    0,    false, false);        
                    InitDataProperty(0, cnt++ , dtAutoSum,   60,	daRight,	true,	"t_cost",     	false,    "",    dfNone,    0,    false, false); 
                    InitDataProperty(0, cnt++ , dtPopupEdit, 20,	daCenter,	true,	"t_cost_pop", 	false,    "",    dfNone,    0,    false, false);
                    InitDataProperty(0, cnt++ , dtAutoSum,   60,	daRight,	true,	"s_cost",     	false,    "",    dfNone,    0,    false, false); 
                    InitDataProperty(0, cnt++ , dtPopupEdit, 20,	daCenter,	false,	"s_cost_pop", 	false,    "",    dfNone,    0,    false, false);        
                    InitDataProperty(0, cnt++ , dtAutoSum,   60,	daRight,	true,	"a_cost",     	false,    "",    dfNone,    0,    false, false); 
                    InitDataProperty(0, cnt++ , dtPopupEdit, 20,	daCenter,	false,	"a_cost_pop", 	false,    "",    dfNone,    0,    false, false);
                    InitDataProperty(0, cnt++ , dtHidden,    20,	daCenter,	false,	"scq_rqst_no", 	false,    "",    dfNone,    0,    false, false);
                    InitDataProperty(0, cnt++ , dtHidden,    20,	daCenter,	false,	"scq_ver_no", 	false,    "",    dfNone,    0,    false, false);        
                    InitDataProperty(0, cnt++ , dtHidden,    20,	daCenter,	false,	"rout_seq", 	false,    "",    dfNone,    0,    false, false);
                    InitDataProperty(0, cnt++ , dtHidden,    20,	daCenter,	false,	"scq_ver_no_tmp", 	false,    "",    dfNone,    0,    false, false);
                    InitDataProperty(0, cnt++ , dtHidden,    20,	daCenter,	false,	"n_cost_zero_exist", 	false,    "",    dfNone,    0,    false, false);
                    InitDataProperty(0, cnt++ , dtHidden,    20,	daCenter,	false,	"w_cost_zero_exist", 	false,    "",    dfNone,    0,    false, false);
                    InitDataProperty(0, cnt++ , dtHidden,    20,	daCenter,	false,	"g_cost_zero_exist", 	false,    "",    dfNone,    0,    false, false);
                    InitDataProperty(0, cnt++ , dtHidden,    20,	daCenter,	false,	"t_cost_zero_exist", 	false,    "",    dfNone,    0,    false, false);
                    InitDataProperty(0, cnt++ , dtHidden,    20,	daCenter,	false,	"s_cost_zero_exist", 	false,    "",    dfNone,    0,    false, false);
                    InitDataProperty(0, cnt++ , dtHidden,    20,	daCenter,	false,	"a_cost_zero_exist", 	false,    "",    dfNone,    0,    false, false);
                    
                    CountPosition = 0;
                    AutoSumBottom = 1;
                    ShowButtonImage = 1; // editable 인 경우만 돋보기 버튼 보임
                    
                    // 입력 형식 지정
                    InitDataValid(0, "ib_yd_cd", vtEngUpOther, "1234567890");
                    InitDataValid(0, "ob_yd_cd", vtEngUpOther, "1234567890");
                    
                    InitDataCombo (0, "rout_tp_cd", "POL|T/S|POD", "L|N|P");
		            // 강제 merge
                    SetMergeCell(0,12,2,2);
                    SetMergeCell(0,14,2,2);
                    SetMergeCell(0,16,2,2);
                                 
					//CellEditable(2,5) = false;
					RowMerge(0) = true;
					RowMerge(1) = true;
					
					SelectHighLight = false;
					WaitImageVisible = false;
                }
                break;
                
             case 3:      //sheet3 init
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

                    var HeadTitle1 = "ibflag|scq_rqst_no|scq_ver_no|prog_sts_cd|rqst_ofc_cd|rqst_srep_cd|rqst_srep_nm|por_cd|pol_cd|"+
                    "pol_yd_cd|pod_cd|pod_yd_cd|del_cd|svc_scp_cd|cust_cnt_cd|cust_seq|rcv_term_cd|de_term_cd|prop_eff_dt|prop_exp_dt|"+
                    "apro_eff_dt|apro_exp_dt|delt_flg|cre_usr_id|cre_dt|upd_usr_id|upd_dt|apro_ofc_cd|spcl_cgo_tp_cd|prog_seq|"+
                    "pg_prog_sts_cd|prog_ofc_cd|prog_usr_id|prog_usr_nm|prog_dt|prog_rmk|cust_lgl_eng_nm|prog_sts_nm|scq_ver_no_tmp|"+
                    "auth|pre_prog_sts_cd|rslt_flg|last_flg|act_cust_cnt_cd|act_cust_seq|act_cust_nm|scq_bid_flg|meas_sys_cd";

	                var headCount = ComCountHeadTitle(HeadTitle1);
	                
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                    InitHeadMode(true, true, true, true, false,false);

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW, COL,  DATATYPE,  WIDTH, DATAALIGN, COLMERGE,     SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,      60,	daCenter,	true,	 "ibflag");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "scq_rqst_no");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "scq_ver_no");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "prog_sts_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "rqst_ofc_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "rqst_srep_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "rqst_srep_nm");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "por_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "pol_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "pol_yd_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "pod_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "pod_yd_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "del_cd");
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
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "scq_ver_no_tmp");
                    InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "auth");   
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "pre_prog_sts_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "rslt_flg");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "last_flg");
					
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "act_cust_cnt_cd");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "act_cust_seq");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "act_cust_nm" );
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "scq_bid_flg");
					InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "meas_sys_cd");
                    
                    
                    CountPosition = 0;
                
                    sheetObj.DataInsert(-1);
                }
                break;
         case 4:      //sheet4 init
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

                 var HeadTitle1 = "ibflag|cgo_seq|rout_seq|cntr_qty|n_cost|w_cost|g_cost|t_cost|s_cost|a_cost";

                 var headCount = ComCountHeadTitle(HeadTitle1);
	                
                 // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 헤더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                 InitHeadMode(true, true, true, true, false,false);

                 // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 // 자동 트림하여 조회및 저장
                 DataAutoTrim = true;

                 // 데이터속성    [ROW, COL,  DATATYPE,  WIDTH, DATAALIGN, COLMERGE,     SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				 InitDataProperty(0, cnt++ , dtStatus,    60,	daCenter,	true,	 "ibflag" );
				 InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "cgo_seq" );
				 InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "rout_seq" );
				 InitDataProperty(0, cnt++ , dtData,      60,	daCenter,	true,	 "cntr_qty" );
				 InitDataProperty(0, cnt++ , dtData,      60,	daRight,	false,	 "n_cost" );
				 InitDataProperty(0, cnt++ , dtData,      60,	daRight,	false,	 "w_cost" );
				 InitDataProperty(0, cnt++ , dtData,      60,	daRight,	false,	 "g_cost" );
				 InitDataProperty(0, cnt++ , dtData,      60,	daRight,	false,	 "t_cost" );
				 InitDataProperty(0, cnt++ , dtData,      60,	daRight,	false,	 "s_cost" );
				 InitDataProperty(0, cnt++ , dtData,      60,	daRight,	false,	 "a_cost" );

				 CountPosition = 0;
             
                 sheetObj.DataInsert(-1);
             }
             break;
        }
    }

	    /**
     * Combo 기본 설정, Combo의 항목을 설정한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */        
    function initCombo(comboObj, comboNo) {

    	switch(comboObj.id) {
            case "prop_srep_cd":
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
            case "scq_rqst_no":
                var i=0;
                with(comboObj) {
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
			case "scq_ver_no_combo":
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
            case "svc_scp_cd_combo":
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
            case "rcv_term_cd":
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
            case "de_term_cd":
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


   /**
    * Onbeforedeactivate  event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_deactivate()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */   
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
            	if(formObj.apro_ofc_cd.value != ""){
					for(var i=0; i<=ofcArr.length; i++){
						if(i==ofcArr.length){
							ComShowCodeMessage("PRI09017"); //Invaild Office Code.
							formObj.apro_ofc_cd.value = "";
							break;
						}
						if(ofcArr[i] == formObj.apro_ofc_cd.value){
							break;
						}
					}
            	}
                break; 
                */   
            case "scq_rqst_no":
            	if((formObj.scq_rqst_no.value != tmpRqstNo)&&(formObj.scq_rqst_no.value.length == 15)){
            		formObj.scq_ver_no.value = "";
	            	doActionIBSheet(sheetObjects[0], document.form, SEARCH04);     
                }
                break;
            case "pol_cd":
            	doActionIBSheet(sheetObjects[0], document.form, SEARCH07); 
            	if(formObj.pol_cd.value != sheetObjects[2].CellValue(1,"pol_cd")){
            		polpod_chg_flg = true;
                }
                break;
            case "pod_cd":
            	doActionIBSheet(sheetObjects[0], document.form, SEARCH07);
            	if(formObj.pod_cd.value != sheetObjects[2].CellValue(1,"pod_cd")){
            		polpod_chg_flg = true;
                }
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

            case "cust_cnt_cd":
                //cust name find
                if (sheetObj.CellValue(1, "cust_cnt_cd") != formObj.cust_cnt_cd.value){
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
                if (sheetObj.CellValue(1, "act_cust_cnt_cd") != formObj.act_cust_cnt_cd.value){
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
                    formObj.act_cust_seq.value = ComLpad(actCustSeq, 6, "0");
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
               // ComChkObjValid(event.srcElement);       
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
         }
         
     }    
     
    /**
    * OnBeforeActivate   event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_activate()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */   
    function obj_activate() {
        var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        ComClearSeparator (event.srcElement);

        switch(srcName){
	        case "scq_rqst_no":
	                tmpRqstNo = formObj.scq_rqst_no.value
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
	    }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
        	case IBCLEAR: // 초기 화면 open
        		formObj.f_cmd.value = SEARCH19; // 공통코드 조회
				formObj.cd.value="CD02070";		// PRICING RECEIVING TERM CODE		
				sheetObjects[0].WaitImageVisible = false;				
				var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, formObj.rcv_term_cd, "cd", "cd|nm");
                formObj.rcv_term_cd.InsertItem(0, "", "");
                formObj.rcv_term_cd.value = "";
                
				formObj.cd.value="CD02071";		// PRICING DELIVERY TERM CODE				
				sheetObjects[0].WaitImageVisible = false;				
				var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));				
				ComPriXml2ComboItem(sXml, formObj.de_term_cd, "cd", "cd|nm");
                formObj.de_term_cd.InsertItem(0, "", "");
                formObj.de_term_cd.value = "";
                
        		formObj.f_cmd.value = SEARCH04; // MDM_CNTR_TP_SZ
        		sheetObjects[0].WaitImageVisible = false;				
				cntrTpSzXml = sheetObjects[0].GetSearchXml("ESM_PRI_8003GS.do", FormQueryString(formObj));				
                ComSetIBCombo(sheetObjects[0],cntrTpSzXml,"cntr_tpsz_cd",true,0);	 
                
                formObj.f_cmd.value = SEARCH14;	// Office code list 배열에 넣기					
				sheetObjects[0].WaitImageVisible = false;				
				var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));				
				ofcArr = ComPriXml2Array(sXml, "cd");

				comboObjects[MEAS_CMB_ID].Code = "M";
				break; 
        	
        	case IBCREATE: // 신규생성 (New 버튼)
        		// Sales Rep. 조회
        		formObj.document.form.rqst_ofc_cd.value = document.form.in_usr_ofc_cd.value;
				var params = "f_cmd=" + SEARCH15 + "&etc1=" + formObj.rqst_ofc_cd.value; 
                var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do?", params);
                formObj.prop_srep_cd.RemoveAll();
                ComPriXml2ComboItem(sXml, formObj.prop_srep_cd, "cd", "cd|nm");
                formObj.prop_srep_cd.InsertItem(0, "", "");
                formObj.prop_srep_nm.value = "";
        	
        		sheetObjects[2].CellValue(1,"rqst_ofc_cd")= document.form.in_usr_ofc_cd.value;
        		//sheetObjects[2].CellValue(1,"scq_ver_no")= "000";
        		sheetObjects[2].CellValue(1,"spcl_cgo_tp_cd")= "AK";
        		document.form.rqst_ofc_cd.value = sheetObjects[2].CellValue(1,"rqst_ofc_cd");
        		var meas_sys_cd = "M";
        		if ( sheetObjects.length > 2 && sheetObjects[2].RowCount > 0 ) {
        			meas_sys_cd = sheetObjects[2].CellValue(1,"meas_sys_cd");
        			if ( meas_sys_cd == "" ) {
        				meas_sys_cd = "M";
        			}
        		}
                comboObjects[MEAS_CMB_ID].Code = meas_sys_cd;
                break;
        	
        	case MULTI10: // 헤더 시트, cargo 시트, route 시트 저장 ///////////////////////////////////////////////////
        		//Hidden Header sheet 셋팅
      			updateHdrSheet();
				if (!validateForm(sheetObj, formObj, sAction)) {
					sheetObjects[2].CellValue(1,"prog_sts_cd") = preStsCd;
                	sheetObjects[2].CellValue(1,"pq_prog_sts_cd") = preStsCd;
					ComOpenWait(false);
					return false;
				}
        		if(sheetObjects[2].CellValue(1,"ibflag") != "I"){
	        		sheetObjects[2].CellValue(1,"ibflag") = "U";
    			}
    			//Cargo Sheet 셋팅
    			var cgoEditRow = 0;
				if((preStsCd==""&&sheetObjects[2].CellValue(1,"prog_sts_cd")=="T")
					||(preStsCd=="T"&&sheetObjects[2].CellValue(1,"prog_sts_cd")=="Q")
					||(preStsCd=="A"&&sheetObjects[2].CellValue(1,"prog_sts_cd")=="O")
					||(preStsCd=="R"&&sheetObjects[2].CellValue(1,"prog_sts_cd")=="O")){
					// Request no 가 새로 생성 되어, 해당 no 로 cargo 정보 새롭게 저장
					for(var i=2;i<=sheetObjects[0].LastRow;i++){//scq_rqst_no
						sheetObjects[0].CellValue(i,"scq_rqst_no") = sheetObjects[2].CellValue(1,"scq_rqst_no");
        				sheetObjects[0].CellValue(i,"scq_ver_no") = sheetObjects[2].CellValue(1,"scq_ver_no");
        				// 신규 생성에 맞도록 ibflag 조정
        				if(sheetObjects[0].CellValue(i,"ibflag")!="D"){
        					sheetObjects[0].CellValue(i,"ibflag") = "I";
							cgoEditRow++;
						}else if(sheetObjects[0].CellValue(i,"ibflag")=="D"){
							sheetObjects[0].CellValue(i,"ibflag") = "";
						}
					}
				}else if((preStsCd=="T"&&sheetObjects[2].CellValue(1,"prog_sts_cd")=="T")
					||(preStsCd=="C"&&sheetObjects[2].CellValue(1,"prog_sts_cd")=="Q")
					||(preStsCd=="Q"&&sheetObjects[2].CellValue(1,"prog_sts_cd")=="A")
					||(preStsCd=="Q"&&sheetObjects[2].CellValue(1,"prog_sts_cd")=="R")
					||(preStsCd=="Q"&&sheetObjects[2].CellValue(1,"prog_sts_cd")=="P")){
					// Request no 가 유지 되어, 해당 no 에 cargo 정보 갱신 
					for(var i=2;i<=sheetObjects[0].LastRow;i++){
        				// row add 된 부분에만 request no, ver no 복사
        				if(sheetObjects[0].CellValue(i,"ibflag")=="I"){
        					sheetObjects[0].CellValue(i,"scq_rqst_no") = sheetObjects[2].CellValue(1,"scq_rqst_no");
        					sheetObjects[0].CellValue(i,"scq_ver_no") = sheetObjects[2].CellValue(1,"scq_ver_no");
							cgoEditRow++;
						}else if(sheetObjects[0].CellValue(i,"ibflag")=="U"||sheetObjects[0].CellValue(i,"ibflag")=="D"){
							cgoEditRow++;
						}
					}
				}
    			//Route Sheet 셋팅
    			for(var i=0; i < sheetObjects[1].RowCount; i++){
    				var headerRow = sheetObjects[1].HeaderRows;
    				//sheetObjects[1].CellValue(i + sheetObject,"ibflag") = "I";
	        		sheetObjects[1].CellValue(i + headerRow,"scq_rqst_no") = formObj.scq_rqst_no.value;
	        		sheetObjects[1].CellValue(i + headerRow,"scq_ver_no") = formObj.scq_ver_no.value;
	        		sheetObjects[1].CellValue(i + headerRow,"rout_seq") = i + headerRow - 1;
    			}
    			// sParam 셋팅
        		formObj.f_cmd.value = MULTI01;
				var sParam = FormQueryString(formObj);
        		var sParamSheet1 = sheetObjects[0].GetSaveString();
				if (sParamSheet1 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
				}
				var sParamSheet2 = sheetObjects[1].GetSaveString();
				if (sParamSheet2 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
				}
				var sParamSheet3 = sheetObjects[2].GetSaveString();
				if (sParamSheet3 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
				}
//				if (!supressConfirm && !ComPriConfirmSave()) {
//					return false;
//				}
				var sXml = sheetObj.GetSaveXml("ESM_PRI_8003GS.do", sParam);
				sheetObjects[2].LoadSearchXml(sXml);
				
				if(sheetObjects[2].CellValue(1,"rslt_flg")=='Changed'){
					// Please retrieve this [Request] again as other user changed the data.
					ComShowCodeMessage("PRI01135","Request");
					return false;
					break;
				}
				
				formObj.scq_rqst_no.value = sheetObjects[2].CellValue(1,"scq_rqst_no");
	       		formObj.scq_ver_no.value = sheetObjects[2].CellValue(1,"scq_ver_no");
	       		if(sheetObjects[2].CellValue(1,"prog_sts_cd")!="T"){
		       		doActionIBSheet(sheetObjects[2],document.form,SEARCH04); //VerNo 콤보 재 조회
		       	}
	       		doActionIBSheet(sheetObjects[2],document.form,SEARCH01); //헤더 재 조회
	       		if(sheetObjects[2].CellValue(1,"prog_sts_cd")!="T"){
	       			doActionIBSheet(sheetObjects[2],document.form,IBSEARCH); //카고 재 조회
		       		doActionIBSheet(sheetObjects[2],document.form,SEARCH02); //라우트 재 조회
	       			updateForm();
	       		}
	       		return true;
        		break;
        	
        	case SEARCH01:	// 헤더 정보 조회
	 			formObj.f_cmd.value = SEARCH01;
	 			var sXml = sheetObjects[2].GetSearchXml("ESM_PRI_8003GS.do", FormQueryString(formObj));
	 			sheetObjects[2].LoadSearchXml(sXml);
	 			
	 			var req_rmk_ok = false;
	 			var appr_rmk_ok = false;
 				
	 			form.rmk_req.value = "";
	 			form.rmk_appr.value = "";
	 			var delt_flg ;
	 			var del_pg_prog_sts_cd;
	 			for(var i=1;i<=sheetObjects[2].LastRow;i++){
	 				if ( i == 1 ) { 
	 					delt_flg = sheetObjects[2].CellValue(i,"delt_flg");
		 				if( delt_flg == "Y" ) {
							formObj.rmk_appr.value = sheetObjects[2].CellValue(i,"prog_rmk");
							appr_rmk_ok = true;	 					
							del_pg_prog_sts_cd = sheetObjects[2].CellValue(i,"pg_prog_sts_cd");
		 				}
	 				}
	 				var sts_cd = sheetObjects[2].CellValue(i,"pg_prog_sts_cd");
	 				if (delt_flg == "Y" ) {
	 					if ( i != 1 && !req_rmk_ok  && sts_cd == del_pg_prog_sts_cd ) {
							form.rmk_req.value = sheetObjects[2].CellValue(i,"prog_rmk");
							req_rmk_ok = true;
	 					}
	 				} else {
						if(!req_rmk_ok&&(sts_cd=="T"||sts_cd=="Q"||sts_cd=="C"||sts_cd=="O")){
							form.rmk_req.value = sheetObjects[2].CellValue(i,"prog_rmk");
							req_rmk_ok = true;
						}else if(!appr_rmk_ok&&(sts_cd=="A"||sts_cd=="R"||sts_cd=="P")){
							form.rmk_appr.value = sheetObjects[2].CellValue(i,"prog_rmk");
							appr_rmk_ok = true;
						}
	 				}
				}
				
				var stsCd = sheetObjects[2].CellValue(1,"prog_sts_cd");
				if((stsCd=="Q"||stsCd=="C"||stsCd=="A"||stsCd=="R")
					&&(sheetObjects[2].CellValue(sheetObjects[2].LastRow,"cre_usr_id") == document.form.in_usr_id.value)){
					formObj.rqst_ofc_cd.value = formObj.in_usr_ofc_cd.value;
					formObj.pol_cd.value = sheetObjects[2].CellValue(1,"pol_cd");
					formObj.pod_cd.value = sheetObjects[2].CellValue(1,"pod_cd");
					doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
					doActionIBSheet(sheetObjects[0],document.form,SEARCH07);
				}
				if(stsCd=="T"){
					formObj.document.form.rqst_ofc_cd.value = document.form.in_usr_ofc_cd.value;
					formObj.pol_cd.value = sheetObjects[2].CellValue(1,"pol_cd");
					formObj.pod_cd.value = sheetObjects[2].CellValue(1,"pod_cd");
					doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
					doActionIBSheet(sheetObjects[0],document.form,SEARCH07);
				}
				
				fistProgUsrId = sheetObjects[2].CellValue(sheetObjects[2].LastRow, "prog_usr_id");
				
				if(sheetObjects[2].RowCount == 0){
					ComShowCodeMessage("PRI09014");//Request No / Request Ver is Invalid
				}
				
				// Header 의 MEAS_SYS_CD 와 관련하여 sheet 재 정림
				var sXml = "";
				if ( sheetObjects[0].RowCount > 0 ) {
					sXml = ComPriSheet2Xml ( sheetObjects[0] );
				}

		    	initSheet ( sheetObjects[0], 1 );   	
		        
		        ComEndConfigSheet(sheetObjects[0]);
		    	ComSetIBCombo(sheetObjects[0],cntrTpSzXml,"cntr_tpsz_cd",true,0);
		    	
		    	if ( sXml != "") {
		            ComPriXml2Sheet ( sheetObjects[0], sXml);
		            sxml = "";
		    	}
		        
				break;
        	
            case IBSEARCH:  //CARGO SHEET 조회
//                if (!validateForm(sheetObj, document.form, sAction)) {
//					return false;
//				}
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObjects[2].GetSearchXml("ESM_PRI_8003GS.do", FormQueryString(formObj));
	 			sheetObjects[0].LoadSearchXml(sXml);
	 			break;
	 		
	 		case SEARCH02:	// Extra Handling Cost by Route 조회
	 			formObj.f_cmd.value = SEARCH03;
				rout_tmp_yn = false;
				//var sParamSheet3 = sheetObjects[2].GetSaveString(true);
        		//sParam += sParamSheet3;
        		//sParam += "&" + FormQueryString(formObj);
	 		    var sParam = FormQueryString(formObj);
	 			var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_8003GS.do", sParam);
	 			var arrXml = sXml.split("|$$|");
                if (arrXml.length > 0) {
                
		 			sheetObjects[1].LoadSearchXml(arrXml[0]);
		 			
		 			for(var i=2;i<=sheetObjects[1].LastRow;i++){
		 				if(sheetObjects[1].CellValue(i,"n_cost")!='')
		 					sheetObjects[1].CellEditable(i,"n_cost_pop") = true;
		 				if(sheetObjects[1].CellValue(i,"w_cost")!='')
		 					sheetObjects[1].CellEditable(i,"w_cost_pop") = true;
		 				if(sheetObjects[1].CellValue(i,"g_cost")!='')
		 					sheetObjects[1].CellEditable(i,"g_cost_pop") = true;
		 				if(sheetObjects[1].CellValue(i,"t_cost")!='')
		 					sheetObjects[1].CellEditable(i,"t_cost_pop") = true;
		 				if(sheetObjects[1].CellValue(i,"s_cost")!='')
		 					sheetObjects[1].CellEditable(i,"s_cost_pop") = true;
		 				if(sheetObjects[1].CellValue(i,"a_cost")!='')
		 					sheetObjects[1].CellEditable(i,"a_cost_pop") = true;					
		 			}
		 			
		 			if(sheetObjects[2].CellValue(1,"prog_sts_cd")!="Y"){
			 			var stsCd = sheetObjects[2].CellValue(1,"prog_sts_cd");
						if(stsCd=="T"){
							setSheetsEditable(true);
						}else if((stsCd=="C"||stsCd=="A"||stsCd=="R")
							&&(sheetObjects[2].CellValue(sheetObjects[2].LastRow,"cre_usr_id") == document.form.in_usr_id.value)){
							setSheetsEditable(true);
						}else{
							setSheetsEditable(false);
						}	
					}else{
						setSheetsEditable(false);
					}
		 			
		 			if ( arrXml.length > 1 ) {
		 				sheetObjects[3].LoadSearchXml(arrXml[1]);
		 			}
                }
				break;  
				  
			case SEARCH04:	// Ver No 조회
				if (!validateForm(sheetObj, document.form, sAction)) {
					return false;
				}
	 			formObj.f_cmd.value = SEARCH05;
	 			var sXml = sheetObjects[2].GetSearchXml("ESM_PRI_8003GS.do", FormQueryString(formObj));
	 			sheetObjects[2].LoadSearchXml(sXml);
				
				formObj.scq_ver_no_combo.RemoveAll();
                ComPriXml2ComboItem(sXml, formObj.scq_ver_no_combo, "scq_ver_no", "scq_ver_no|prog_sts_cd|delt_flg");
				
				for(var i=1; i<=sheetObjects[2].LastRow; i++){
					if(sheetObjects[2].CellValue(i,"delt_flg")==""){
						liveVerNo = sheetObjects[2].CellValue(i,"scq_ver_no");
						break;
					}
				}
				if(formObj.scq_ver_no.value !=""){
					formObj.scq_ver_no.value = formObj.scq_ver_no.value;
					formObj.scq_ver_no_combo.Text = formObj.scq_ver_no.value;
				}else if(liveVerNo!=""){
					formObj.scq_ver_no.value = liveVerNo;
					formObj.scq_ver_no_combo.Text = liveVerNo;
				}else{
					formObj.scq_ver_no.value = sheetObjects[2].CellValue(1,"scq_ver_no");
					formObj.scq_ver_no_combo.Text = sheetObjects[2].CellValue(1,"scq_ver_no");
				}
				
				if(sheetObjects[2].RowCount == 0){
					sheetObjects[2].DataInsert(0);
				}
				break;
				
			case SEARCH07:	// svc scp 조회
				if (!validateForm(sheetObj, document.form, sAction)) {
					return false;
				}
				if(formObj.pol_cd.value.length == 5 && formObj.pod_cd.value.length == 5){
		 			formObj.f_cmd.value = SEARCH06;
		 			var sXml = sheetObjects[2].GetSearchXml("ESM_PRI_8003GS.do", FormQueryString(formObj));
					formObj.svc_scp_cd_combo.RemoveAll();
	                ComPriXml2ComboItem(sXml, formObj.svc_scp_cd_combo, "svc_scp_cd", "svc_scp_cd");
				}
				comboObjects[SSCP_CMB_ID].Text = sheetObjects[2].CellValue(1,"svc_scp_cd");
				comboObjects[SSCP_CMB_ID].Code = sheetObjects[2].CellValue(1,"svc_scp_cd");
				break;
				
            case SEARCH11:  //CARGO SHEET Temporary 조회

				formObj.f_cmd.value = SEARCH11;
				var sXml = sheetObjects[2].GetSearchXml("ESM_PRI_8003GS.do", FormQueryString(formObj));
				sheetObjects[0].LoadSearchXml(sXml);
				break;
		
            case SEARCH12:	// Extra Handling Cost by Route Temporary 조회
				formObj.f_cmd.value = SEARCH12;
				rout_tmp_yn = true;
				// var sParamSheet3 = sheetObjects[2].GetSaveString(true);
		  		// sParam += sParamSheet3;
		  		sParam = FormQueryString(formObj);
				
				var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_8003GS.do", sParam);
				
	 			var arrXml = sXml.split("|$$|");
                if (arrXml.length > 0) {
					sheetObjects[1].LoadSearchXml(arrXml[0]);
					
					for(var i=2;i<=sheetObjects[1].LastRow;i++){
						if(sheetObjects[1].CellValue(i,"n_cost")!='')
							sheetObjects[1].CellEditable(i,"n_cost_pop") = true;
						if(sheetObjects[1].CellValue(i,"w_cost")!='')
							sheetObjects[1].CellEditable(i,"w_cost_pop") = true;
						if(sheetObjects[1].CellValue(i,"g_cost")!='')
							sheetObjects[1].CellEditable(i,"g_cost_pop") = true;
						if(sheetObjects[1].CellValue(i,"t_cost")!='')
							sheetObjects[1].CellEditable(i,"t_cost_pop") = true;
						if(sheetObjects[1].CellValue(i,"s_cost")!='')
							sheetObjects[1].CellEditable(i,"s_cost_pop") = true;
						if(sheetObjects[1].CellValue(i,"a_cost")!='')
							sheetObjects[1].CellEditable(i,"a_cost_pop") = true;					
					}
					
//					if(sheetObjects[2].CellValue(1,"prog_sts_cd")!="Y"){
//			 			var stsCd = sheetObjects[2].CellValue(1,"prog_sts_cd");
//						if(stsCd=="T"){
//							setSheetsEditable(true);
//						}else if((stsCd=="C"||stsCd=="A"||stsCd=="R")
//							&&(sheetObjects[2].CellValue(1,"cre_usr_id") == document.form.in_usr_id.value)){
//							setSheetsEditable(true);
//						}else{
//							setSheetsEditable(false);
//						}	
//					}else{
//						setSheetsEditable(false);
//					}	
					
		 			if ( arrXml.length > 1 ) {
		 				sheetObjects[3].LoadSearchXml(arrXml[1]);
		 			}
                }
				break;  
			  
	    	case MULTI11: // Calculation///////////////////////////////////////////////////
				if (!validateForm(sheetObj, document.form, sAction)) {
					return false;
					break;
				}
				
	    		if ( formObj.scq_rqst_no.value == '' || formObj.scq_rqst_no.value == null ) {
	    			ComShowMessage("Please generate Request No. first.");
	    			return;
	    		}
	    	
	    		if ( sheetObjects[0].RowCount <= 0 ) {
	    			ComShowMessage("Please Input Cargo Information first.");
	    			return;
	    		}
	    		
	    		if ( sheetObjects[1].RowCount <= 0 ) {
	    			ComShowMessage("Please Setting Route Information first.");
	    			return;	    			
	    		}

				// sParam 셋팅
				formObj.f_cmd.value = MULTI11;
				var sParam = FormQueryString(formObj);
				
				var sParamSheet1 = sheetObjects[0].GetSaveString(true);
				if (sParamSheet1 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
				}
				var sParamSheet2 = sheetObjects[1].GetSaveString(true);
				if (sParamSheet2 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
				}
				var sParamSheet3 = sheetObjects[2].GetSaveString(true);
				if (sParamSheet3 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
				}
	
				var sXml = sheetObj.GetSaveXml("ESM_PRI_8003GS.do", sParam);
	
		   		formObj.scq_ver_no_tmp.value = ComGetEtcData ( sXml, "scq_ver_no_tmp" ) ; // sheetObjects[2].CellValue(1,"scq_ver_no_tmp");
		   		doActionIBSheet(sheetObjects[2],document.form,SEARCH11); //카고 재 조회
		   		doActionIBSheet(sheetObjects[2],document.form,SEARCH12); //라우트 재 조회				
		   		break;

            case MULTI12:  //Temporary Data 삭제 처리 
				formObj.f_cmd.value = MULTI12;
				var sXml = sheetObjects[2].GetSaveXml("ESM_PRI_8003GS.do", FormQueryString(formObj));
				break;
				
            case MULTI13:  //Temporary Data 를 Transaction Data 로 copySave 하고 삭제 처리 
				formObj.f_cmd.value = MULTI13;
				var sXml = sheetObjects[2].GetSaveXml("ESM_PRI_8003GS.do", FormQueryString(formObj));
				break;
        }
        return true;
    }


//    /**
//     * Sheet1의 OnSearchEnd 이벤트 처리
//     */
//    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//        ComOpenWait(false);
//        sheetObjects[1].WaitImageVisible = true;
//        sheetObjects[0].WaitImageVisible = true;
//    }   

     /**
	 * Use in [btn_rowadd]
	 * @param 
	 * @return Row
	 */
	function addRow() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		//var stsCond = frmObj.p_status.value;
		var Row = 0;

		Row = sheetObj.DataInsert(-1);
		sheetObj.CellBackColor(Row, "void") = sheetObj.RgbColor(241, 241, 241);
		sheetObj.CellBackColor(Row, "a_basic_rate") = sheetObj.RgbColor(241, 241, 241);
		sheetObj.CellBackColor(Row, "a_void_rate") = sheetObj.RgbColor(241, 241, 241);
		sheetObj.CellValue(Row,"no") = sheetObj.LastRow + 1;
		
		return Row;
	}
	
		/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리하는 함수. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode 필수 사용자 권한이나 모드
	 * @author 박성수
	 * @version 2009.05.01
	 */
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
					ComBtnEnable("btn_rowadd");
					ComBtnEnable("btn_rowdel");
					ComBtnEnable("btn_rowcopy");
					ComBtnEnable("btn_rowcopy");
					ComBtnEnable("btn_calculation");
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
					ComBtnEnable("btn_rowadd");
					ComBtnEnable("btn_rowdel");
					ComBtnEnable("btn_rowcopy");
					ComBtnEnable("btn_calculation");
					break;
					
				case "T"://최초생성자만 request,delete 가능
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnEnable("btn_copy");
					ComBtnEnable("btn_save");
					if(fistProgUsrId == document.form.in_usr_id.value){
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
					ComBtnEnable("btn_rowadd");
					ComBtnEnable("btn_rowdel");
					ComBtnEnable("btn_rowcopy");
					ComBtnEnable("btn_calculation");
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
					ComBtnDisable("btn_productCatalog");
					ComBtnDisable("btn_rowadd");
					ComBtnDisable("btn_rowdel");
					ComBtnDisable("btn_rowcopy");
					ComBtnDisable("btn_calculation");
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
					ComBtnEnable("btn_rowadd");
					ComBtnEnable("btn_rowdel");
					ComBtnEnable("btn_rowcopy");
					ComBtnEnable("btn_calculation");
					break;	
				
				case "A":
				case "R":
					var last_flg = sheetObjects[2].CellValue ( 1, "last_flg" );
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
					ComBtnEnable("btn_rowadd");
					ComBtnEnable("btn_rowdel");
					ComBtnEnable("btn_rowcopy");
					ComBtnEnable("btn_calculation");
					break;
				
				case "P":
				case "O":
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_new");
					ComBtnEnable("btn_copy");
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_request");
					ComBtnDisable("btn_countoffer");
					ComBtnDisable("btn_delete");
					if ( mode == "O" ) {
						ComBtnEnable("btn_cancel");
					} else {
						ComBtnDisable("btn_cancel");
					}
					ComBtnEnable("btn_sendmail");
					ComBtnEnable("btn_attachfile");
					ComBtnDisable("btn_productCatalog");
					ComBtnDisable("btn_rowadd");
					ComBtnDisable("btn_rowdel");
					ComBtnDisable("btn_rowcopy");
					ComBtnDisable("btn_calculation");
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
					ComBtnDisable("btn_rowadd");
					ComBtnDisable("btn_rowdel");
					ComBtnDisable("btn_rowcopy");
					ComBtnDisable("btn_calculation");
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
					ComBtnEnable("btn_rowadd");
					ComBtnEnable("btn_rowdel");
					ComBtnEnable("btn_rowcopy");
					ComBtnEnable("btn_calculation");
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
					ComBtnEnable("btn_rowadd");
					ComBtnEnable("btn_rowdel");
					ComBtnEnable("btn_rowcopy");
					ComBtnEnable("btn_calculation");
					break;
				
				case "T":
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
					ComBtnDisable("btn_rowadd");
					ComBtnDisable("btn_rowdel");
					ComBtnDisable("btn_rowcopy");
					ComBtnDisable("btn_calculation");
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
					ComBtnDisable("btn_rowadd");
					ComBtnDisable("btn_rowdel");
					ComBtnDisable("btn_rowcopy");
					ComBtnDisable("btn_calculation");
					break;
			}
		}
	}
	
	function toggleForms(mode) {
		var formObj = document.form;
		
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
				toggleFormsClass(formObj.por_cd, 0);
				toggleFormsClass(formObj.pol_cd, 1); 
				toggleFormsClass(formObj.pol_yd_cd, 0);    
				toggleFormsClass(formObj.pod_cd, 1);
				toggleFormsClass(formObj.pod_yd_cd, 0);    
				toggleFormsClass(formObj.del_cd, 0);
				toggleFormsClass(formObj.btn_por_cd, 0);
				toggleFormsClass(formObj.btn_pol_cd, 0); 
				toggleFormsClass(formObj.btn_pod_cd, 0);
				toggleFormsClass(formObj.btn_del_cd, 0); 
				toggleFormsClass(formObj.cust_cnt_cd, 1);      
				toggleFormsClass(formObj.cust_seq, 1); 
				toggleFormsClass(formObj.btn_customer, 0);
				toggleFormsClass(formObj.act_cust_cnt_cd, 1);      
				toggleFormsClass(formObj.act_cust_seq, 1); 
				toggleFormsClass(formObj.act_cust_nm, 1); 
				toggleFormsClass(formObj.btn_customer2, 0);
				toggleFormsClass(formObj.p_date1, 1); 
				toggleFormsClass(formObj.p_date2, 1);  
				toggleFormsClass(formObj.a_date1, 2);  
				toggleFormsClass(formObj.a_date2, 2);
				toggleFormsClass(formObj.rmk_req, 0);
				toggleFormsClass(formObj.rmk_appr, 2);
				toggleFormsClass(formObj.btn_Calendar1, 0);
				toggleFormsClass(formObj.btn_Calendar2, 2);
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
					toggleFormsClass(formObj.por_cd, 0);
					toggleFormsClass(formObj.pol_cd, 1); 
					toggleFormsClass(formObj.pol_yd_cd, 0);    
					toggleFormsClass(formObj.pod_cd, 1);
					toggleFormsClass(formObj.pod_yd_cd, 0);    
					toggleFormsClass(formObj.del_cd, 0);
					toggleFormsClass(formObj.btn_por_cd, 0);
					toggleFormsClass(formObj.btn_pol_cd, 0); 
					toggleFormsClass(formObj.btn_pod_cd, 0);
					toggleFormsClass(formObj.btn_del_cd, 0); 
					toggleFormsClass(formObj.cust_cnt_cd, 1);      
					toggleFormsClass(formObj.cust_seq, 1); 
					toggleFormsClass(formObj.btn_customer, 0);
					toggleFormsClass(formObj.act_cust_cnt_cd, 1);      
					toggleFormsClass(formObj.act_cust_seq, 1); 
					toggleFormsClass(formObj.act_cust_nm, 1); 
					toggleFormsClass(formObj.btn_customer2, 0);
					toggleFormsClass(formObj.p_date1, 1); 
					toggleFormsClass(formObj.p_date2, 1);  
					toggleFormsClass(formObj.a_date1, 2);  
					toggleFormsClass(formObj.a_date2, 2);
					toggleFormsClass(formObj.rmk_req, 0);
					toggleFormsClass(formObj.rmk_appr, 2);
					toggleFormsClass(formObj.btn_Calendar1, 0);
					toggleFormsClass(formObj.btn_Calendar2, 2);
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
					//toggleFormsClass(formObj.apro_ofc_cd, 2);
					toggleFormsClass(formObj.por_cd, 2);
					toggleFormsClass(formObj.pol_cd, 2); 
					toggleFormsClass(formObj.pol_yd_cd, 2);    
					toggleFormsClass(formObj.pod_cd, 2);
					toggleFormsClass(formObj.pod_yd_cd, 2);    
					toggleFormsClass(formObj.del_cd, 2);
					toggleFormsClass(formObj.btn_por_cd, 2);
					toggleFormsClass(formObj.btn_pol_cd, 2); 
					toggleFormsClass(formObj.btn_pod_cd, 2);
					toggleFormsClass(formObj.btn_del_cd, 2);
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
					toggleFormsClass(formObj.rmk_req, 2);
					toggleFormsClass(formObj.rmk_appr, 2);
					toggleFormsClass(formObj.btn_Calendar1, 2);
					toggleFormsClass(formObj.btn_Calendar2, 2);
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
				
			case "Q":
			case "O":
			case "P":
			default:
				//수정 불가
				toggleFormsClass(formObj.rqst_ofc_cd, 2); 
				//toggleFormsClass(formObj.apro_ofc_cd, 2);
				toggleFormsClass(formObj.por_cd, 2);
				toggleFormsClass(formObj.pol_cd, 2); 
				toggleFormsClass(formObj.pol_yd_cd, 2);    
				toggleFormsClass(formObj.pod_cd, 2);
				toggleFormsClass(formObj.pod_yd_cd, 2);    
				toggleFormsClass(formObj.del_cd, 2);
				toggleFormsClass(formObj.btn_por_cd, 2);
				toggleFormsClass(formObj.btn_pol_cd, 2); 
				toggleFormsClass(formObj.btn_pod_cd, 2);
				toggleFormsClass(formObj.btn_del_cd, 2);
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
				toggleFormsClass(formObj.rmk_req, 2);
				toggleFormsClass(formObj.rmk_appr, 2);
				toggleFormsClass(formObj.btn_Calendar1, 2);
				toggleFormsClass(formObj.btn_Calendar2, 2);
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
	
	/**
	 * 선택한 Sales Rep 에게 메일 보내기 //ESM_PRI_0003 참조
	 */    
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
				+ "<a href='" + server_url + "hanjin/ESM_PRI_8003.do?p_rqstno="+formObj.scq_rqst_no.value+"'>"
				+ "Click Here</a><br>";
		*/
		//ts port 찾기
		var tmp_tsport = "";
		for(var i=sheetObjects[1].HeaderRows+1; i<sheetObjects[1].LastRow-1; i++){
			if(i>3){
				tmp_tsport += ", ";
			}
			tmp_tsport += sheetObjects[1].CellValue(i,"ib_yd_cd").substr(0,5);
		}
		var lane_cd = "";
		var lane_idx = 0;
		var lane_list = "";
		for ( var j = sheetObjects[1].HeaderRows+1; j<sheetObjects[1].LastRow; j++){
			lane_cd = ComTrim(sheetObjects[1].CellValue(j, "lane_cd"));
			if ( !ComIsNull(lane_cd) ) {
				lane_list += ( lane_idx == 0 ? "" : " - ") + lane_cd;
				lane_idx++;
			}
		}
		
		content += "<br><br> --- Basic Information of Request ----------------------"
				+ "<br><br> 1. Request No.                 : <a href='" + server_url + "hanjin/ESM_PRI_8004.do?p_rqstno="+formObj.scq_rqst_no.value+"' style=\"color:#ff0000\" target=\"_blank\" >"+formObj.scq_rqst_no.value + "</a>"
				+ "<br> 2. Request Office              : "+formObj.rqst_ofc_cd.value
				+ "<br> 3. POR : "+formObj.por_cd.value + " , POL : "+formObj.pol_cd.value
				+        " , POD : "+formObj.pod_cd.value + " , DEL : "+formObj.del_cd.value
				+ "<br> 4. T/S Port                    : "+tmp_tsport
				+ "<br> 5. Target Lane                 : "+lane_list
				+ "<br> 6. Customer Name               : "+formObj.ctrt_pty_nm.value
				+ "<br> 7. Actual Customer Name        : "+formObj.act_cust_nm.value
				+ "<br> 8. Awkward Term                : "+formObj.rcv_term_cd.Text+" / "+formObj.de_term_cd.Text
				+ "<br> 9. Proposal Duration           : "+ ( formObj.p_date1.value != "" ? formObj.p_date1.value+" ~ "+formObj.p_date2.value : "" ) 
		        + "<br> 10. Approval Duration          : "+ ( formObj.a_date1.value != "" ? formObj.a_date1.value+" ~ "+formObj.a_date2.value : "" ) ;
		
		var    rmkReq = formObj.rmk_req.value;
		if ( rmkReq.indexOf( "\r\n" ) > 0 ){
			rmkReq = rmkReq.replace(RegExp(/\r/ig), "").replace(RegExp(/\n/ig), "<br>");
			rmkReq = "<br>" +rmkReq;
		}
		content += "<br> 11. Request Remark             : "+rmkReq;
		
		var    rmkAppr = formObj.rmk_appr.value;
		if ( rmkAppr.indexOf( "\r\n" ) > 0 ){
			rmkAppr = rmkAppr.replace(RegExp(/\r/ig), "").replace(RegExp(/\n/ig), "<br>");
			rmkAppr = "<br>" +rmkAppr;
		}
		content += "<br> 12. Approval Remark            : "+rmkAppr;
		
		var tempcontent;
		tempcontent = "";
		tempcontent += "<br><br> --- Rate & Extra Handling Cost by Cargo --------------- ";

		var tempseq = 0;
		for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].LastRow; i++){			
			tempseq++;
			tempcontent +=
			 "<br>            "
			+"<br> 1. Container SEQ.              : " + tempseq   
			+"<br> 2. EQ Type/Size/Q'ty           : " + sheetObjects[0].CellValue(i,'cntr_tpsz_cd') + " X " + sheetObjects[0].CellValue(i,'cntr_qty') + " EA"
			+"<br> 3. Commodity                   : " + sheetObjects[0].CellValue(i,'cmdt_nm')
			+"<br> 4. Gross Weight                : " + sheetObjects[0].CellValue(i,'grs_wgt') + " "+ wgt_unit
			+"<br> 5. Overall Dimension (in "+len_unit+")   : " + sheetObjects[0].CellValue(i,'ttl_dim_len') + " x " 
			                                          + sheetObjects[0].CellValue(i,'ttl_dim_wdt') + " x "
			                                          + sheetObjects[0].CellValue(i,'ttl_dim_hgt') + " (Length x Width x Height)"
			+"<br> 6. Void Space                  : " + sheetObjects[0].CellValue(i,'ovr_void_slt_qty') + " Box";
			if(sheetObjects[0].CellValue(i,'prop_bsrt_amt')!=""){
				tempcontent += "<br> 7. Proposal Rate : Basic - $ " + sheetObjects[0].CellValue(i,'prop_bsrt_amt');
				if(sheetObjects[0].CellValue(i,'prop_void_rt_amt')!=""){
					tempcontent += " , Void - $ " + sheetObjects[0].CellValue(i,'prop_void_rt_amt');
				}
			} else {
				tempcontent += "<br> 7. Proposal Rate : ";					
			}
			if(sheetObjects[0].CellValue(i,'apro_bsrt_amt')!=""){
				tempcontent += "<br> 8. Aproval Rate  : Basic - $ " + sheetObjects[0].CellValue(i,'apro_bsrt_amt');
				if(sheetObjects[0].CellValue(i,'apro_void_rt_amt')!=""){
					tempcontent += " , Void - $ " + sheetObjects[0].CellValue(i,'apro_void_rt_amt');
				}
			} else {
				tempcontent += "<br> 8. Aproval Rate  : ";					
			}
			tempcontent += "<br>";
			if(i!=sheetObjects[0].LastRow ){
				tempcontent += "<br> - - - - - - - - - - - - - - - - - - - - - - - - - - - - ";
			}
		}
		content = content + tempcontent;
		content = content + "<br> --- End ----------------------------------------------- ";
		
		formObj.gw_contents.value = content;
		//메일 제목
		var mailtitle = "AWK Quotation for "+formObj.scq_rqst_no.value+" / POL : "+formObj.pol_cd.value+" POD : "+formObj.pod_cd.value + " / " + formObj.ctrt_pty_nm.value.substring ( 0, 15 );
		formObj.gw_subject.value = mailtitle;
	    ComOpenGroupwareMail(sheetObjects[0],formObj);
	}   
	
	/**
    * OnChange 이벤트 발생시 호출되는 function <br>
    * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
    * @return 없음
    * @author 
    * @version 
    */  	    
     function sheet1_OnChange(sheetObj, Row, Col, Value)
     {
     	var colname = sheetObj.ColSaveName(Col);  
     	var formObj = document.form
		
     	switch(colname)
     	{
     		case "cntr_qty":
     		case "ovr_void_slt_qty":
     			cgoinfo_chg_flg = true; // cargo 값 변경
     		case "prop_bsrt_amt":
     		case "prop_void_rt_amt":
     			cfinfo_chg_flg = true; // count offer flg 갱신, 값 변경 체크용
     			setTotalRate();
     			break;	
     		
 	    	case "ttl_dim_len":
 	    		cgoinfo_chg_flg = true;
 	    		overDimensionSettingLength();
 	    		break;
 	    	case "ttl_dim_wdt":
 	    		cgoinfo_chg_flg = true;
 	    		overDimensionSettingWidth();
 	    		break;
 	    	case "ttl_dim_hgt":
 	    		cgoinfo_chg_flg = true;
 	    		overDimensionSettingHeight();
 	    		break;
 	    	case "cntr_tpsz_cd":
 	    		cgoinfo_chg_flg = true;
 	    		overDimensionSettingLength();
 	    		overDimensionSettingWidth();
 	    		overDimensionSettingHeight();
 	    		break;
 	    	case "del_chk" :
 	    		var checkRow = sheetObjects[0].FindCheckedRow("del_chk");
 	    		var checkRowArr = checkRow.split("|");
 	    		if(checkRow!=null && checkRowArr.length>1){
	 	    		for(var i=0;i<checkRowArr.length-1;i++){
	 	    			if(checkRowArr[i]!=Row){
	 	    				sheetObjects[0].CellValue2(checkRowArr[i],"del_chk") = 0;
	 	    			}
	 	    		}
 	    		}
 	    		if(document.form.scq_rqst_no.value != ""){
 	    			cargoDetailDisplay();
 	    		}
 	    		for ( var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
 	    			ttlAmtCalculate(sheetObj, i );
 	    		}
 	    		break;
 	    	case "ovr_fwrd_len":
			case "ovr_bkwd_len":
			case "ovr_lf_len":
			case "ovr_rt_len":
			case "ovr_hgt":
			case "grs_wgt":
 	    		cgoinfo_chg_flg = true;
 	    		
 	    		break;	
     	}
     }  
	
	/**
     * OnPopupClick 이벤트 발생시 호출되는 function <br>
     * Location PopUp을 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 
     * @version
     */  	      	 
	function sheet2_OnPopupClick(sheetObj, Row, Col)
	{
		var formObj = document.form;
		var sUrl = "";
		
		var tmp_yn = "";
		var ver_no = "";
		if(sheetObj.CellValue(Row,"scq_ver_no_tmp")!=""){
			ver_no = sheetObj.CellValue(Row,"scq_ver_no_tmp");
			tmp_yn = "Y";
		}else{
			ver_no = formObj.scq_ver_no.value;
			tmp_yn = "N";
		}
		
		if(sheetObj.ColSaveName(Col)=="n_cost_pop"){
			var sUrl = "/hanjin/ESD_TES_0055.do?";
			sUrl += "cost_tp_cd=N";
			sUrl += "&scq_rqst_no="+formObj.scq_rqst_no.value;
			sUrl += "&scq_ver_no="+ver_no;
			sUrl += "&rout_seq="+sheetObj.CellValue(Row,"rout_seq");
			sUrl += "&tmp_yn="+tmp_yn;
			ComPriOpenWindowCenter(sUrl, "", 1020, 575, true);
		}else if(sheetObj.ColSaveName(Col)=="w_cost_pop"){
			var sUrl = "/hanjin/ESD_TES_0055.do?";
			sUrl += "cost_tp_cd=W";
			sUrl += "&scq_rqst_no="+formObj.scq_rqst_no.value;
			sUrl += "&scq_ver_no="+ver_no;
			sUrl += "&rout_seq="+sheetObj.CellValue(Row,"rout_seq");
			sUrl += "&tmp_yn="+tmp_yn;
			ComPriOpenWindowCenter(sUrl, "", 1020, 575, true);
		}else if(sheetObj.ColSaveName(Col)=="g_cost_pop"){
			var sUrl = "/hanjin/ESD_TES_0055.do?";
			sUrl += "cost_tp_cd=G";
			sUrl += "&scq_rqst_no="+formObj.scq_rqst_no.value;
			sUrl += "&scq_ver_no="+ver_no;
			sUrl += "&rout_seq="+sheetObj.CellValue(Row,"rout_seq");
			sUrl += "&tmp_yn="+tmp_yn;
			ComPriOpenWindowCenter(sUrl, "", 1020, 575, true);
		}else if(sheetObj.ColSaveName(Col)=="t_cost_pop"){
			var sUrl = "/hanjin/ESD_TES_0056.do?";
			sUrl += "cost_tp_cd=T";
			sUrl += "&scq_rqst_no="+formObj.scq_rqst_no.value;
			sUrl += "&scq_ver_no="+ver_no;
			sUrl += "&rout_seq="+sheetObj.CellValue(Row,"rout_seq");
			sUrl += "&tmp_yn="+tmp_yn;
			ComPriOpenWindowCenter(sUrl, "", 1020, 575, true);
		}else if(sheetObj.ColSaveName(Col)=="s_cost_pop"){
			var sUrl = "/hanjin/ESD_TRS_0252.do?";
			sUrl += "cost_tp_cd=S";
			sUrl += "&scq_rqst_no="+formObj.scq_rqst_no.value;
			sUrl += "&scq_ver_no="+ver_no;
			sUrl += "&rout_seq="+sheetObj.CellValue(Row,"rout_seq");
			sUrl += "&tmp_yn="+tmp_yn;
			ComPriOpenWindowCenter(sUrl, "", 1020, 575, true);
		}else if(sheetObj.ColSaveName(Col)=="a_cost_pop"){
			var urlParam = "ESM_PRI_8101.do?p_scq_rqst_no="+"SEL000000000001"
							+"&p_spcl_cgo_tp_cd=AK&file_up_title=Add-On";
			if( document.form.in_usr_ofc_cd.value=="SELCMR" || document.form.in_usr_ofc_cd.value=="PUSCOV" ){	// [CHM-201639660] SELCMR로 변경 Requested by SELCMR/Pilkyung Jun
				urlParam += "&p_editable=Y"; 			
			}
			ComOpenPopup(urlParam, 525, 440, "", "0,0,1,1,1,1,1", true);
		}
	}
	
    // form 내용을 히든 sheet 에 update
    function updateHdrSheet(){
        var formObj = document.form;
        var sheetObj = sheetObjects[2];
        
        if(sheetObj.RowCount == 0){
        	sheetObj.DataInsert(0);
        }
		//PRI_SCQ_AWK_MN 를 위한 값
		
    	sheetObj.CellValue(1,"rqst_ofc_cd") = formObj.rqst_ofc_cd.value; 
		// sheetObj.CellValue(1,"apro_ofc_cd") = formObj.apro_ofc_cd.value;       
		sheetObj.CellValue(1,"por_cd")      = formObj.por_cd.value;       
		sheetObj.CellValue(1,"pol_cd")      = formObj.pol_cd.value;       
		sheetObj.CellValue(1,"pol_yd_cd")   = formObj.pol_yd_cd.value;       
		sheetObj.CellValue(1,"pod_cd")      = formObj.pod_cd.value;       
		sheetObj.CellValue(1,"pod_yd_cd")   = formObj.pod_yd_cd.value;       
		sheetObj.CellValue(1,"del_cd")      = formObj.del_cd.value;       
		sheetObj.CellValue(1,"cust_cnt_cd") = formObj.cust_cnt_cd.value;
		if(formObj.cust_seq.value != ""){
		sheetObj.CellValue(1,"cust_seq") = ComLtrim(formObj.cust_seq.value, "0");       
		}
		sheetObj.CellValue(1,"prop_eff_dt") = formObj.p_date1.value;       
		sheetObj.CellValue(1,"prop_exp_dt") = formObj.p_date2.value;       
		sheetObj.CellValue(1,"apro_eff_dt") = formObj.a_date1.value;       
		sheetObj.CellValue(1,"apro_exp_dt") = formObj.a_date2.value; 
		
		sheetObj.CellValue(1,"scq_ver_no")  = formObj.scq_ver_no.value;
		
		
		//콤보
		sheetObj.CellValue(1,"rqst_srep_cd") = comboObjects[SREP_CMB_ID].Text;
		sheetObj.CellValue(1,"scq_ver_no")   = comboObjects[VERN_CMB_ID].Text;   
		sheetObj.CellValue(1,"svc_scp_cd")   = comboObjects[SSCP_CMB_ID].Text;
		sheetObj.CellValue(1,"rcv_term_cd")  = comboObjects[RTRM_CMB_ID].Text;
		sheetObj.CellValue(1,"de_term_cd")   = comboObjects[DTRM_CMB_ID].Text;  
		sheetObj.CellValue(1,"apro_ofc_cd")  = comboObjects[AOFC_CMB_ID].Text;  

		//PRI_SCQ_PROG 를 위한 값		
		sheetObj.CellValue(1,"prog_rmk")       = document.form.rmk_req.value;
		sheetObj.CellValue(1,"prog_ofc_cd")    = document.form.in_usr_ofc_cd.value;
		sheetObj.CellValue(1,"spcl_cgo_tp_cd") = "AK";
		
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
        var sheetObj = sheetObjects[2];
		
		if(sheetObj.RowCount == 0){
        	sheetObj.DataInsert(0);
        }
		
	    formObj.rqst_ofc_cd.value = sheetObj.CellValue(1,"rqst_ofc_cd"); 
		//formObj.apro_ofc_cd.value = sheetObj.CellValue(1,"apro_ofc_cd");      
		formObj.por_cd.value      = sheetObj.CellValue(1,"por_cd");      
		formObj.pol_cd.value      = sheetObj.CellValue(1,"pol_cd");      
		formObj.pol_yd_cd.value   = sheetObj.CellValue(1,"pol_yd_cd");      
		formObj.pod_cd.value      = sheetObj.CellValue(1,"pod_cd");      
		formObj.pod_yd_cd.value   = sheetObj.CellValue(1,"pod_yd_cd");      
		formObj.del_cd.value      = sheetObj.CellValue(1,"del_cd");      
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
			formObj.svc_scp_cd_combo.InsertItem(0,tempItem,tempItem);
			comboObjects[SSCP_CMB_ID].Text   = sheetObj.CellValue(1,"svc_scp_cd");
		}
		comboObjects[RTRM_CMB_ID].Text   = sheetObj.CellValue(1,"rcv_term_cd");
		comboObjects[DTRM_CMB_ID].Text   = sheetObj.CellValue(1,"de_term_cd");    
		
		formObj.prop_srep_nm.value = sheetObj.CellValue(1,"rqst_srep_nm");
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

	/**
     * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
     * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    prop_srep_cd_OnChange(comboObj, code, text);
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param   {string} code 필수 코드
     * @param   {string} text 화면에 표시된 문자 
     * @return 없음
     * @author 
     * @version 
     */     
    function prop_srep_cd_OnChange(comboObj, code, text) {	
        var formObj = document.form;
        var sheetObj = sheetObjects[2];
        var arrText = text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.prop_srep_nm.value = comboObj.GetText(code, 1);
    	}
    	if(sheetObjects[2].CellValue(1,"prog_sts_cd") == ""){
//    		toggleButtons("CREATE");
//    		toggleForms("CREATE");  
        }
    }	

    function scq_ver_no_combo_OnChange(comboObj, code, text) {
        var formObj = document.form;
		sheetObjects[0].removeAll();
		sheetObjects[1].removeAll();
		sheetObjects[2].removeAll();
		comboObjects[SREP_CMB_ID].removeAll();
		comboObjects[SSCP_CMB_ID].removeAll();
		updateForm();
		
		formObj.rmk_req.value = "";
		formObj.rmk_appr.value = "";
		formObj.rqst_basic_rate.value = "";
		formObj.rqst_void_rate.value = "";
		formObj.apro_basic_rate.value = "";
		formObj.apro_void_rate.value = "";
		
		formObj.scq_ver_no.value = code;
		toggleButtons();
		toggleForms();
    }

    
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
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



	function overDimensionSettingLength() {

		var row = sheetObjects[0].SelectRow;
		var SumLength = sheetObjects[0].CellValue(row, "ttl_dim_len");
		var cntr_tpsz_cd = sheetObjects[0].CellText(row, "cntr_tpsz_cd");
		var meas_sys_cd = comboObjects[MEAS_CMB_ID].Code;
		var O2_LEN = 0;
		var A2_LEN = 0;
		var O4_LEN = 0;
		var F4_LEN = 0;
		var front = 0;
		var rear = 0;
		var lengthCnt = 0;
		
		if (meas_sys_cd == "M" ){
			O2_LEN = 589.3;
			A2_LEN = 605.8;
			O4_LEN = 1203.2;
			F4_LEN = 1219.2;			
		} else if ( meas_sys_cd == "I" ) {			
			O2_LEN = 232.01;
			A2_LEN = 238.5;
			O4_LEN = 473.7;
			F4_LEN = 480;
		}

		if (cntr_tpsz_cd == "O2") {
			front = (SumLength - O2_LEN) / 2;
			rear = (SumLength - O2_LEN) / 2;
		}
		if (cntr_tpsz_cd == "O4" || cntr_tpsz_cd == "S4") {
			front = (SumLength - O4_LEN) / 2;
			rear = (SumLength - O4_LEN) / 2;
		}
		if (cntr_tpsz_cd == "S2") {
			front = (SumLength - O2_LEN) / 2;
			rear = (SumLength - O2_LEN) / 2;
		}
		if (cntr_tpsz_cd == "A2" || cntr_tpsz_cd == "F2" || cntr_tpsz_cd == "P2") {
			front = (SumLength - A2_LEN) / 2;
			rear = (SumLength - A2_LEN) / 2;
		}
		if (cntr_tpsz_cd == "F4" || cntr_tpsz_cd == "P4") {
			front = (SumLength - F4_LEN) / 2;
			rear = (SumLength - F4_LEN) / 2;
		}
		if (cntr_tpsz_cd == "A4") {
			front = (SumLength - F4_LEN) / 2;
			rear = (SumLength - F4_LEN) / 2;
		}
		if (cntr_tpsz_cd == "F5") {
			front = (SumLength - F4_LEN) / 2;
			rear = (SumLength - F4_LEN) / 2;
		}
		if (cntr_tpsz_cd == "O5") {
			front = (SumLength - F4_LEN) / 2;
			rear = (SumLength - F4_LEN) / 2;
		}
		if (front > 0) {
			if ( meas_sys_cd == "M" ) {
				front = Math.round(parseFloat(front)) ;
			} else if ( meas_sys_cd == "I" ) {
				front = parseFloat((Math.round(parseFloat(front * 100)))/100);
			}		
			sheetObjects[0].CellValue(row, "ovr_fwrd_len") = front;
//			document.getElementById("ovr_fwrd_len").value = sheetObjects[0].CellValue(row, "ovr_fwrd_len");
			lengthCnt++
		} else {
			sheetObjects[0].CellValue(row, "ovr_fwrd_len") = "0";
//			document.getElementById("ovr_fwrd_len").value = "0";
		}
		if (rear > 0) {
			if ( meas_sys_cd == "M" ) {
				rear = Math.round(parseFloat(rear)) ;
			} else if ( meas_sys_cd == "I" ) {
				rear = parseFloat((Math.round(parseFloat(rear * 100)))/100);
			}		
			sheetObjects[0].CellValue(row, "ovr_bkwd_len") = rear;
//			document.getElementById("ovr_bkwd_len").value = sheetObjects[1].CellValue(row, "ovr_bkwd_len");
			lengthCnt++
		} else {
			sheetObjects[0].CellValue(row, "ovr_bkwd_len") = "0";
//			document.getElementById("ovr_bkwd_len").value = "0";
		}
		if (lengthCnt > 0) {
			ComShowMessage(ComGetMsg("BKG08034"));
		}
	}

	function overDimensionSettingWidth() {

		var row = sheetObjects[0].SelectRow;
		var SumWidth = sheetObjects[0].CellValue(row, "ttl_dim_wdt");
		var cntr_tpsz_cd = sheetObjects[0].CellText(row, "cntr_tpsz_cd");
		var meas_sys_cd = comboObjects[MEAS_CMB_ID].Code;
		var O2_WDT = 0;
		var A2_WDT = 0;
		var left = 0;
		var right = 0;

		if (meas_sys_cd == "M" ){
			O2_WDT = 234.6;
			A2_WDT = 243.8;			
		} else if ( meas_sys_cd == "I" ) {			
			O2_WDT = 92.36;
			A2_WDT = 95.98;
		}
		
		if (cntr_tpsz_cd == "O2") {
			left = (SumWidth - O2_WDT) / 2;
			right = (SumWidth - O2_WDT) / 2;
		}
		if (cntr_tpsz_cd == "O4" || cntr_tpsz_cd == "S4") {
			left = (SumWidth - O2_WDT) / 2;
			right = (SumWidth - O2_WDT) / 2;
		}
		if (cntr_tpsz_cd == "S2") {
			left = (SumWidth - O2_WDT) / 2;
			right = (SumWidth - O2_WDT) / 2;
		}
		if (cntr_tpsz_cd == "A2" || cntr_tpsz_cd == "F2" || cntr_tpsz_cd == "P2") {
			left = (SumWidth - A2_WDT) / 2;
			right = (SumWidth - A2_WDT) / 2;
		}
		if (cntr_tpsz_cd == "F4" || cntr_tpsz_cd == "P4") {
			left = (SumWidth - A2_WDT) / 2;
			right = (SumWidth - A2_WDT) / 2;
		}
		if (cntr_tpsz_cd == "A4") {
			left = (SumWidth - A2_WDT) / 2;
			right = (SumWidth - A2_WDT) / 2;
		}
		if (cntr_tpsz_cd == "F5") {
			left = (SumWidth - A2_WDT) / 2;
			right = (SumWidth - A2_WDT) / 2;
		}
		if (cntr_tpsz_cd == "O5") {
			left = (SumWidth - A2_WDT) / 2;
			right = (SumWidth - A2_WDT) / 2;
		}
		if (left > 0) {
			if ( meas_sys_cd == "M" ) {
				left = Math.round(parseFloat(left)) ;
			} else if ( meas_sys_cd == "I" ) {
				left = parseFloat((Math.round(parseFloat(left * 100)))/100);
			}		
			sheetObjects[0].CellValue(row, "ovr_lf_len") = left;
//			document.getElementById("ovr_lf_len").value = sheetObjects[1].CellValue(row, "ovr_lf_len");
		} else {
			sheetObjects[0].CellValue(row, "ovr_lf_len") = "0";
//			document.getElementById("ovr_lf_len").value = "0";
		}
		if (right > 0) {
			if ( meas_sys_cd == "M" ) {
				right = Math.round(parseFloat(right)) ;
			} else if ( meas_sys_cd == "I" ) {
				right = parseFloat((Math.round(parseFloat(right * 100)))/100);
			}		
			sheetObjects[0].CellValue(row, "ovr_rt_len") = right;
//			document.getElementById("ovr_rt_len").value = sheetObjects[1].CellValue(row, "ovr_rt_len");
		} else {
			sheetObjects[0].CellValue(row, "ovr_rt_len") = "0";
//			document.getElementById("ovr_rt_len").value = "0";
		}
		if (cntr_tpsz_cd.indexOf("2") > -1) {
			voidSpaceValue2();
		} else {
			voidSpaceValue();
		}
	}

	function overDimensionSettingHeight() {

		var row = sheetObjects[0].SelectRow;
		var SumHeight = sheetObjects[0].CellValue(row, "ttl_dim_hgt");
		var cntr_tpsz_cd = sheetObjects[0].CellText(row, "cntr_tpsz_cd");
		var meas_sys_cd = comboObjects[MEAS_CMB_ID].Code;
		var F4_HGT = 0;
		var A2_HGT = 0;
		var F5_HGT = 0;
		var S2_HGT = 0;
		var O4_HGT = 0;
		var O2_HGT = 0;
		var O5_HGT = 0;
		var height = 0;

		if (meas_sys_cd == "M" ){
			F4_HGT = 196.8;
			A2_HGT = 207.7;
			F5_HGT = 226.4;
			S2_HGT = 236.4;
			O4_HGT = 238.1;
			O2_HGT = 238.4;
			O5_HGT = 265.3;
		} else if ( meas_sys_cd == "I" ) {			
			F4_HGT =  77.48;
			A2_HGT =  81.77;
			F5_HGT =  89.13;
			S2_HGT =  93.07;
			O4_HGT =  93.74;
			O2_HGT =  93.86;
			O5_HGT = 104.45;
		}

		if (cntr_tpsz_cd == "O2") {
			height = SumHeight - O2_HGT;
		}
		if (cntr_tpsz_cd == "O4" || cntr_tpsz_cd == "S4") {
			height = SumHeight - O4_HGT;
		}
		if (cntr_tpsz_cd == "S2") {
			height = SumHeight - S2_HGT;
		}
		if (cntr_tpsz_cd == "A2" || cntr_tpsz_cd == "F2" || cntr_tpsz_cd == "P2") {
			height = SumHeight - A2_HGT;
		}
		if (cntr_tpsz_cd == "F4" || cntr_tpsz_cd == "P4") {
			height = SumHeight - F4_HGT;
		}
		if (cntr_tpsz_cd == "A4") {
			height = SumHeight - F4_HGT;
		}
		if (cntr_tpsz_cd == "F5") {
			height = SumHeight - F5_HGT;
		}
		if (cntr_tpsz_cd == "O5") {
			height = SumHeight - O5_HGT;
		}
		if (height > 0) {
			if ( meas_sys_cd == "M" ) {
				height = Math.round(parseFloat(height)) ;
			} else if ( meas_sys_cd == "I" ) {
				height = parseFloat((Math.round(parseFloat(height * 100)))/100);
			}		
			sheetObjects[0].CellValue(row, "ovr_hgt") = height;
//			document.getElementById("ovr_hgt").value = sheetObjects[1].CellValue(row, "ovr_hgt");
		} else {
			sheetObjects[0].CellValue(row, "ovr_hgt") = "0";
//			document.getElementById("ovr_hgt").value = "0";
		}
		if (cntr_tpsz_cd.indexOf("2") > -1) {
			voidSpaceValue2();
		} else {
			voidSpaceValue();
		}
//		cornerPostStatus();
	}

	function voidSpaceValue() {

		var row = sheetObjects[0].SelectRow;
		var width1 = sheetObjects[0].CellValue(row, "ovr_lf_len");
		var width2 = sheetObjects[0].CellValue(row, "ovr_rt_len");
		var height = sheetObjects[0].CellValue(row, "ovr_hgt");
		var w1_len, w2_len, h_len;
		var WDT = 0;
		var HGT = 0;
		var meas_sys_cd = comboObjects[MEAS_CMB_ID].Code;
		
		if (meas_sys_cd == "M" ){
			WDT = 244;
			HGT = 259;
		} else if ( meas_sys_cd == "I" ) {			
			WDT = Math.round ( ( 244 / 2.54 ) * 100 ) / 100;
			HGT = Math.round ( ( 259 / 2.54 ) * 100 ) / 100;
		}
		
		if ( width1 == 0 ) {
			w1_len = 0
		} else if ( width1 > 0 ) {
			w1_len = ( Math.ceil ( width1 / WDT ) == ( width1 / WDT ) ? width1 / WDT + 1 : Math.ceil ( width1 / WDT ) );
		}
		
		if ( width2 == 0 ) {
			w2_len = 0;
		} else if ( width2 > 0 ) {
			w2_len = ( Math.ceil ( width2 / WDT ) == ( width2 / WDT ) ? width2 / WDT + 1 : Math.ceil ( width2 / WDT ) );
		}
		
		if ( height == 0 ) {
			h_len = 0;
		} else if ( height > 0 ) {
			h_len  = ( Math.ceil ( height / HGT ) == ( height / HGT ) ? height / HGT + 1 : Math.ceil ( height / HGT ) );
		}
				
		sheetObjects[0].CellValue2 ( row, "ovr_void_slt_qty" ) = ( ( h_len + 1 ) * ( w1_len + w2_len + 1 ) ) - 1;

	}
/**
 * FEU 단위에서 Box 단위로 수정하면서 기존의 계수 * 2 를 한 값으로 계산하게끔 한다.
 * @return
 */
	function voidSpaceValue2() {

		var row = sheetObjects[0].SelectRow;
		var width1 = sheetObjects[0].CellValue(row, "ovr_lf_len");
		var width2 = sheetObjects[0].CellValue(row, "ovr_rt_len");
		var height = sheetObjects[0].CellValue(row, "ovr_hgt");
		var w1_len, w2_len, h_len;
		var meas_sys_cd = comboObjects[MEAS_CMB_ID].Code;
		
		if (meas_sys_cd == "M" ){
			WDT = 244;
			HGT = 259;
		} else if ( meas_sys_cd == "I" ) {			
			WDT = Math.round ( ( 244 / 2.54 ) * 100 ) / 100;
			HGT = Math.round ( ( 259 / 2.54 ) * 100 ) / 100;
		}
		
		
		if ( width1 == 0 ) {
			w1_len = 0
		} else if ( width1 > 0 ) {
			w1_len = ( Math.ceil ( width1 / WDT ) == ( width1 / WDT ) ? width1 / WDT + 1 : Math.ceil ( width1 / WDT ) );
		}
		
		if ( width2 == 0 ) {
			w2_len = 0;
		} else if ( width2 > 0 ) {
			w2_len = ( Math.ceil ( width2 / WDT ) == ( width2 / WDT ) ? width2 / WDT + 1 : Math.ceil ( width2 / WDT ) );
		}
		
		if ( height == 0 ) {
			h_len = 0;
		} else if ( height > 0 ) {
			h_len  = ( Math.ceil ( height / HGT ) == ( height / HGT ) ? height / HGT + 1 : Math.ceil ( height / HGT ) );
		}
				
		sheetObjects[0].CellValue2 ( row, "ovr_void_slt_qty" ) = ( ( h_len + 1 ) * ( w1_len + w2_len + 1 ) ) - 1;

	}
	
	
	function validateForm(sheetObj,formObj,sAction){
   			switch (sAction) {
   				case SEARCH01: // 헤더 조회
   				case IBSEARCH: // cargo 조회
   				case SEARCH02: // route 조회
	  				if (formObj.scq_rqst_no.value == "" || formObj.scq_ver_no.value == ""
	  					||formObj.scq_rqst_no.value.length != 15||formObj.scq_ver_no.value.length != 3) {
	  					ComShowCodeMessage("PRI09014");//Request No / Request Seq is Invalid
	  					return false;
	  				}
	  				break;
	  			case SEARCH07: // svc scp 조회
	  				if (formObj.pol_cd.value == "" || formObj.pod_cd.value == "") {
	  					return false;
	  				}
	  				break;	
	  				
	  			case MULTI10: // 
	  				if(sheetObjects[2].CellValue(1,"prog_sts_cd") != "D"){
		  				if(sheetObjects[2].CellValue(1,"prog_sts_cd") != "T" && sheetObjects[2].CellValue(1,"prog_sts_cd") != "C"){
			  				if (formObj.scq_rqst_no.value == "" || formObj.scq_ver_no.value == ""
			  					||formObj.scq_rqst_no.value.length != 15 || formObj.scq_ver_no.value.length != 3){
			  					ComShowCodeMessage("PRI09014");//Request No / Request Seq is Invalid
			  					return false;
			  				}
			  				if(sheetObjects[2].CellValue(1,"rqst_ofc_cd") == ""){
			  					ComShowCodeMessage("PRI00316","Request OFC."); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[2].CellValue(1,"apro_ofc_cd") == ""){
			  					ComShowCodeMessage("PRI00316","Approval OFC."); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				/*
			  				if(sheetObjects[2].CellValue(1,"rqst_srep_cd") == "" ){
			  					ComShowCodeMessage("PRI00316","Sales Rep."); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				*/
			  				if(sheetObjects[2].CellValue(1,"pol_cd") == ""){
			  					ComShowCodeMessage("PRI00316","POL"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[2].CellValue(1,"pod_cd") == ""){
			  					ComShowCodeMessage("PRI00316","POD"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[2].CellValue(1,"svc_scp_cd") == ""){
			  					ComShowCodeMessage("PRI00316","Service Scope"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[2].CellValue(1,"cust_cnt_cd") == ""){
			  					ComShowCodeMessage("PRI00316","Customer"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[2].CellValue(1,"cust_seq") == ""){
			  					ComShowCodeMessage("PRI00316","Customer"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if (sheetObjects[2].CellValue(1,"prog_sts_cd") == "Q" ) {
				  				if(sheetObjects[2].CellValue(1,"act_cust_cnt_cd") == "" && 
						  		   sheetObjects[2].CellValue(1,"act_cust_seq")    == "" && 
						  		   sheetObjects[2].CellValue(1,"act_cust_nm")     == "" ){
						  			ComShowCodeMessage("PRI00316","Act. Customer"); //Mandatory items [{?msg1}] are required.
						  			return false;
						  		}	
			  				}
			  				if(sheetObjects[2].CellValue(1,"rcv_term_cd") == ""){
			  					ComShowCodeMessage("PRI00316","Awkward Term"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[2].CellValue(1,"de_term_cd") == ""){
			  					ComShowCodeMessage("PRI00316","Awkward Term"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[2].CellValue(1,"prop_eff_dt") == ""){
			  					ComShowCodeMessage("PRI00316","Proposal Duration"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[2].CellValue(1,"prop_exp_dt") == "" ) {
			  					ComShowCodeMessage("PRI00316","Proposal Duration"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[2].CellValue(1,"meas_sys_cd") == "" ) {
			  					ComShowCodeMessage("PRI00316","Measurement Unit"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  				if(sheetObjects[2].CellValue(1,"prop_eff_dt") > sheetObjects[2].CellValue(1,"prop_exp_dt")){
			  					ComShowCodeMessage("PRI09009"); //Invalid duration
			  					return false;
			  				}
			  				if(sheetObjects[0].RowCount == 0){
			  					ComShowCodeMessage("PRI09008"); //Cargo Information is Mandatory.
			  					return false;
			  				}
			  				if(sheetObjects[1].RowCount < 1){
			  					ComShowCodeMessage("PRI09018"); //Extar Handling Cost by Route is Mandatory. Select Product Catalog First.
			  					return false;
			  				}
			  				if(polpod_chg_flg){
			  					ComShowCodeMessage("PRI09019"); //POL/POD Changed. Select Product Catalog again.
			  					return false;
			  				}
			  				if(catalog_flg){
			  					ComShowCodeMessage("PRI09020"); //Calculate Extra Handling Cost First.
			  					return false;
			  				}
			  				if(cgoinfo_chg_flg){
			  					ComShowCodeMessage("PRI09021"); //Cargo Information Changed. Calculate again.
			  					return false;
			  				}
			  			}else if (sheetObjects[2].CellValue(1,"prog_sts_cd") == "T" && sheetObjects[2].CellValue(1,"prog_sts_cd") != "C"){
			  				if (sheetObjects[2].CellValue(1,"svc_scp_cd") == "") {
			  					ComShowCodeMessage("PRI00316","Service Scope"); //Mandatory items [{?msg1}] are required.
			  					return false;
			  				}
			  			}
	  				}	
		  			if(sheetObjects[0].RowCount != 0){
			  			for(var i=2; i<=sheetObjects[0].LastRow; i++){	
			  				if ((sheetObjects[0].CellValue(i,"ibflag")!="D")
			  					&&(sheetObjects[0].CellValue(i,"cntr_tpsz_cd") == ""
			  					||sheetObjects[0].CellValue(i,"cntr_qty") == ""
			  					||sheetObjects[0].CellValue(i,"cmdt_cd") == ""
			  					||sheetObjects[0].CellValue(i,"ttl_dim_len") == ""
			  					||sheetObjects[0].CellValue(i,"ttl_dim_hgt") == ""
			  					||sheetObjects[0].CellValue(i,"grs_wgt") == "")){
	
			  					ComShowCodeMessage("PRI09011"); //Mandatory field of Cargo Sheet is missing.
			  					return false;
			  				}
		  				}
					}
	  				if(sheetObjects[2].CellValue(1,"prog_sts_cd") == "D" && sheetObjects[2].CellValue(1,"prog_rmk") == ""){
	  					ComShowCodeMessage("PRI09015","Delete"); //Remark is mandatory item when {?msg1}.
	  					return false;
	  				}
	  				break;	 
	  				
	  			case MULTI11:
	  				if(sheetObjects[0].RowCount != 0){
			  			for(var i=2; i<=sheetObjects[0].LastRow; i++){	
			  				if ((sheetObjects[0].CellValue(i,"ibflag")!="D")
			  					&&(sheetObjects[0].CellValue(i,"cntr_tpsz_cd") == ""
			  					||sheetObjects[0].CellValue(i,"cntr_qty") == ""
			  					||sheetObjects[0].CellValue(i,"cmdt_cd") == ""
			  					||sheetObjects[0].CellValue(i,"ttl_dim_len") == ""
			  					||sheetObjects[0].CellValue(i,"ttl_dim_hgt") == ""
			  					||sheetObjects[0].CellValue(i,"grs_wgt") == "")){
	
			  					ComShowCodeMessage("PRI09011"); //Mandatory field of Cargo Sheet is missing.
			  					return false;
			  				}
		  				}
					}
	  				break; 				
   			}
   		return true;
    }

	function setSheetsEditable(editable){
		if(editable){
			for(var i=2; i<=sheetObjects[0].LastRow; i++){
//				sheetObjects[0].CellEditable(i,"del_chk") = true;         
				sheetObjects[0].CellEditable(i,"cntr_tpsz_cd") = true;    
				sheetObjects[0].CellEditable(i,"cntr_qty") = true;        
				sheetObjects[0].CellEditable(i,"cmdt_nm") = true;        	
				sheetObjects[0].CellEditable(i,"ttl_dim_len") = true;     
				sheetObjects[0].CellEditable(i,"ttl_dim_wdt") = true;     
				sheetObjects[0].CellEditable(i,"ttl_dim_hgt") = true;     
				sheetObjects[0].CellEditable(i,"ovr_fwrd_len") = true;    
				sheetObjects[0].CellEditable(i,"ovr_bkwd_len") = true;    
				sheetObjects[0].CellEditable(i,"ovr_lf_len") = true;      
				sheetObjects[0].CellEditable(i,"ovr_rt_len") = true;      
				sheetObjects[0].CellEditable(i,"ovr_hgt") = true;         
				sheetObjects[0].CellEditable(i,"grs_wgt") = true;         
				sheetObjects[0].CellEditable(i,"ovr_void_slt_qty") = true;
				sheetObjects[0].CellEditable(i,"prop_bsrt_amt") = true;   
				sheetObjects[0].CellEditable(i,"prop_void_rt_amt") = true;
			}
			for(var i=2; i<=sheetObjects[1].LastRow; i++){
				sheetObjects[1].CellEditable(i, "rout_tp_cd") = true; 	
				sheetObjects[1].CellEditable(i, "lane_cd") = true;    	
				sheetObjects[1].CellEditable(i, "ib_yd_cd") = true;   	
				sheetObjects[1].CellEditable(i, "ob_yd_cd") = true;   	
				sheetObjects[1].CellEditable(i, "n_cost") = false;     
				sheetObjects[1].CellEditable(i, "w_cost") = false;     	
				sheetObjects[1].CellEditable(i, "g_cost") = false;     	
				sheetObjects[1].CellEditable(i, "t_cost") = false;     
				sheetObjects[1].CellEditable(i, "s_cost") = false;    
				sheetObjects[1].CellEditable(i, "a_cost") = false; 
			}       
		}else{
			for(var i=2; i<=sheetObjects[0].LastRow; i++){
				sheetObjects[0].CellEditable(i,"cntr_tpsz_cd") = false;    
				sheetObjects[0].CellEditable(i,"cntr_qty") = false;        
				sheetObjects[0].CellEditable(i,"cmdt_nm") = false;        	
				sheetObjects[0].CellEditable(i,"ttl_dim_len") = false;     
				sheetObjects[0].CellEditable(i,"ttl_dim_wdt") = false;     
				sheetObjects[0].CellEditable(i,"ttl_dim_hgt") = false;     
				sheetObjects[0].CellEditable(i,"ovr_fwrd_len") = false;    
				sheetObjects[0].CellEditable(i,"ovr_bkwd_len") = false;    
				sheetObjects[0].CellEditable(i,"ovr_lf_len") = false;      
				sheetObjects[0].CellEditable(i,"ovr_rt_len") = false;      
				sheetObjects[0].CellEditable(i,"ovr_hgt") = false;         
				sheetObjects[0].CellEditable(i,"grs_wgt") = false;         
				sheetObjects[0].CellEditable(i,"ovr_void_slt_qty") = false;
				sheetObjects[0].CellEditable(i,"prop_bsrt_amt") = false;   
				sheetObjects[0].CellEditable(i,"prop_void_rt_amt") = false;
			}
			for(var i=2; i<=sheetObjects[1].LastRow; i++){
				sheetObjects[1].CellEditable(i, "rout_tp_cd") = false; 	
				sheetObjects[1].CellEditable(i, "lane_cd") = false;    	
				sheetObjects[1].CellEditable(i, "ib_yd_cd") = false;   	
				sheetObjects[1].CellEditable(i, "ob_yd_cd") = false;   	
				sheetObjects[1].CellEditable(i, "n_cost") = false;     
				sheetObjects[1].CellEditable(i, "w_cost") = false;     	
				sheetObjects[1].CellEditable(i, "g_cost") = false;     	
				sheetObjects[1].CellEditable(i, "t_cost") = false;     
				sheetObjects[1].CellEditable(i, "s_cost") = false;    
				sheetObjects[1].CellEditable(i, "a_cost") = false; 
			}
		}
	}
	
	function sheet1_OnSearchEnd(){
		// 합계 계산
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var total_basic = 0;
		var total_void  = 0;
		
		for(var i=2;i<=sheetObj.LastRow;i++){
			//20ft (void에 2를 더 곱함) - Box 단위로 바꾸면서 곱하기 2 제외시킴 - 로직 구분 필요 없음 
 			total_basic = total_basic + (sheetObj.CellValue(i,"cntr_qty")*sheetObj.CellValue(i,"prop_bsrt_amt"));
 			total_void  = total_void  + ((sheetObj.CellValue(i,"cntr_qty")*sheetObj.CellValue(i,"prop_void_rt_amt"))*(sheetObj.CellValue(i,"ovr_void_slt_qty")*1));
 		}
// 		for(var i=2;i<=sheetObj.LastRow;i++){	
// 			if(sheetObj.CellValue(i,"cntr_qty")==""||sheetObj.CellValue(i,"prop_bsrt_amt")==""){
//				total_basic = ""; // 빈 값이 있으면 지움
//			}
//			if(sheetObj.CellValue(i,"cntr_qty")==""||sheetObj.CellValue(i,"prop_void_rt_amt")==""||sheetObj.CellValue(i,"ovr_void_slt_qty")==""){
//				total_void = ""; // 빈 값이 있으면 지움
//			}
//		}
		
		formObj.rqst_basic_rate.value = total_basic;
		formObj.rqst_void_rate.value = total_void;		

		var apro_total_basic = 0;
		var apro_total_void  = 0;
		for(var i=2;i<=sheetObj.LastRow;i++){
			//20ft (void에 2를 더 곱함) - Box 단위로 바꾸면서 곱하기 2 제외시킴 - 로직 구분 필요 없음
			ttlAmtCalculate ( sheetObj, i );
 			apro_total_basic = apro_total_basic + (sheetObj.CellValue(i,"cntr_qty")*sheetObj.CellValue(i,"apro_bsrt_amt"));
			apro_total_void  = apro_total_void  + ((sheetObj.CellValue(i,"cntr_qty")*sheetObj.CellValue(i,"apro_void_rt_amt"))*(sheetObj.CellValue(i,"ovr_void_slt_qty")*1));
 		}
// 		for(var i=2;i<=sheetObj.LastRow;i++){	
// 			if(sheetObj.CellValue(i,"cntr_qty")==""||sheetObj.CellValue(i,"apro_bsrt_amt")==""){
//				apro_total_basic = ""; // 빈 값이 있으면 지움
//			}
//			if(sheetObj.CellValue(i,"cntr_qty")==""||sheetObj.CellValue(i,"apro_void_rt_amt")==""||sheetObj.CellValue(i,"ovr_void_slt_qty")==""){
//				apro_total_void = ""; // 빈 값이 있으면 지움
//			}
//		}
		
		formObj.apro_basic_rate.value = apro_total_basic;		
		formObj.apro_void_rate.value = apro_total_void;
		
		// Reject 시 가격 하이라이트
		if(sheetObjects[2].CellValue(1,"prog_sts_cd")=="R"){ //Reject 상태면
			for(var i=2;i<=sheetObj.LastRow;i++){
				if(sheetObj.CellValue(i,"prop_bsrt_amt")!=sheetObj.CellValue(i,"apro_bsrt_amt")){
					sheetObj.CellBackColor(i,"prop_bsrt_amt") = sheetObj.RgbColor(247,225,236);
				}
				if(sheetObj.CellValue(i,"prop_void_rt_amt")!=sheetObj.CellValue(i,"apro_void_rt_amt")){
					sheetObj.CellBackColor(i,"prop_void_rt_amt") = sheetObj.RgbColor(247,225,236);
				}
			}
		}
	}
	
	// 기초 권한 체크
	function checkAuth(){
		var stsCd = sheetObjects[2].CellValue(1,"prog_sts_cd"); //Request 의 prog_sts_cd
		fistProgUsrId = sheetObjects[2].CellValue(sheetObjects[2].LastRow, "prog_usr_id");//최초 작성자
		if(liveVerNo == document.form.scq_ver_no.value && sheetObjects[2].CellValue(1,"delt_flg")!="Y"){//liveVerNo 이면 (deleted 를 제외한 최종 ver)
			if(fistProgUsrId == document.form.in_usr_id.value || document.form.in_usr_ofc_cd.value == "SELCMR" ){ //User 가 최초 작성자 이면	// [CHM-201639660] SELCMR로 변경 Requested by SELCMR/Pilkyung Jun
						return true;
			}else if(stsCd == "T"){ // T 일 땐 누구나 Save 가능 (Request,Delete 는 불가)
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
		var stsCd = sheetObjects[2].CellValue(1,"prog_sts_cd"); //Request 의 prog_sts_cd
		var aproOfcCd = sheetObjects[2].CellValue(1, "apro_ofc_cd");//승인 ofc
		if(liveVerNo == document.form.scq_ver_no.value){//liveVerNo 이면 (deleted 를 제외한 최종 ver)
			if( ( aproOfcCd == document.form.in_usr_ofc_cd.value // 승인 ofc 이고
				&& sheetObjects[2].CellValue(1, "auth")=="1" ) || document.form.in_usr_ofc_cd.value == "SELCMR" ){     // 해당 SCP 승인 권한 있으면	// [CHM-201639660] SELCMR로 변경 Requested by SELCMR/Pilkyung Jun
						return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}


	function cargoDetailDisplay() {
		
		var fobjCgo = sheetObjects[0];
		var fobjRout = sheetObjects[1];
		var fobjCost = sheetObjects[3];
		
		var rhRows = fobjRout.HeaderRows;
		var chRows = fobjCost.HeaderRows;
		
		for ( var i = 0; i < fobjRout.TotalRows; i++ ) {
			fobjRout.CellValue ( i+rhRows, "n_cost" ) = "";
			fobjRout.CellValue ( i+rhRows, "w_cost" ) = "";
			fobjRout.CellValue ( i+rhRows, "g_cost" ) = "";
			fobjRout.CellValue ( i+rhRows, "t_cost" ) = "";
			fobjRout.CellValue ( i+rhRows, "s_cost" ) = "";
			fobjRout.CellValue ( i+rhRows, "a_cost" ) = "";
		}
		var checkedIdxArrStr = fobjCgo.FindCheckedRow ("del_chk");
		var checkedIdxArr = checkedIdxArrStr.substr(0, checkedIdxArrStr.length - 1).split("|");
		if ( checkedIdxArr.length > 0 && checkedIdxArr[0] != '' ) {
			var checkedCgoSeqArr = new Array();
			checkedCgoSeqArr.length = checkedIdxArr.length;
			for ( var i = 0; i < checkedIdxArr.length; i++ ){
				checkedCgoSeqArr[i] = fobjCgo.CellValue ( checkedIdxArr[i], "cgo_seq" );
			}
				
			for ( var i = 0; i < fobjCost.TotalRows; i++ ) {
				for ( var j = 0; j < checkedCgoSeqArr.length; j++ ) {
					if ( fobjCost.CellValue ( i+chRows, "cgo_seq") == checkedCgoSeqArr[j] ) {
						rout_seq = fobjCost.CellValue ( i+chRows, "rout_seq");
						var idx = fobjRout.FindText("rout_seq", rout_seq);
						if(fobjRout.CellEditable( idx, "n_cost_pop" ) && fobjCost.CellValue(i+chRows,"n_cost")!="")
							fobjRout.CellValue ( idx, "n_cost" ) = (fobjRout.CellValue ( idx, "n_cost" )*1 + fobjCost.CellValue ( i+chRows, "n_cost" )*1 ) ;
						if(fobjRout.CellEditable( idx, "w_cost_pop" ) && fobjCost.CellValue(i+chRows,"w_cost")!="")
							fobjRout.CellValue ( idx, "w_cost" ) = (fobjRout.CellValue ( idx, "w_cost" )*1 + fobjCost.CellValue ( i+chRows, "w_cost" )*1 ) ;
						if(fobjRout.CellEditable( idx, "g_cost_pop" ) && fobjCost.CellValue(i+chRows,"g_cost")!="")
							fobjRout.CellValue ( idx, "g_cost" ) = (fobjRout.CellValue ( idx, "g_cost" )*1 + fobjCost.CellValue ( i+chRows, "g_cost" )*1 ) ;
						if(fobjRout.CellEditable( idx, "t_cost_pop" ) && fobjCost.CellValue(i+chRows,"t_cost")!="")
							fobjRout.CellValue ( idx, "t_cost" ) = (fobjRout.CellValue ( idx, "t_cost" )*1 + fobjCost.CellValue ( i+chRows, "t_cost" )*1 ) ;
						if(fobjRout.CellEditable( idx, "s_cost_pop" ) && fobjCost.CellValue(i+chRows,"s_cost")!="")
							fobjRout.CellValue ( idx, "s_cost" ) = (fobjRout.CellValue ( idx, "s_cost" )*1 + fobjCost.CellValue ( i+chRows, "s_cost" )*1 ) ;
						if(fobjRout.CellEditable( idx, "a_cost_pop" ) && fobjCost.CellValue(i+chRows,"a_cost")!="")
							fobjRout.CellValue ( idx, "a_cost" ) = (fobjRout.CellValue ( idx, "a_cost" )*1 + fobjCost.CellValue ( i+chRows, "a_cost" )*1 ) ;
					}
				}
			}
		}else{	
			if(rout_tmp_yn){ // temp 테이블에서 조회해온 경우
				doActionIBSheet(sheetObjects[0],document.form,SEARCH12);
			}else{
				doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
			}
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
				if(shtObj.CellValue(i,"tp_cd")=="AK"){ 			
					if(shtObj.CellValue(i,"scq_rqst_no")==formObj.scq_rqst_no.value){
						for(var j=i+1;j<=shtObj.LastRow;j++){
							if(shtObj.CellValue(j,"tp_cd")=="AK" 
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
	
	var color_flg = false;

	function sheet2_OnSearchEnd(){
		sheetObj = sheetObjects[1];
		
		for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
			if(sheetObj.CellValue(i,"n_cost_zero_exist")==1){
				sheetObj.CellBackColor(i,"n_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}
			if(sheetObj.CellValue(i,"w_cost_zero_exist")==1){
				sheetObj.CellBackColor(i,"w_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}
			if(sheetObj.CellValue(i,"g_cost_zero_exist")==1){
				sheetObj.CellBackColor(i,"g_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}
			if(sheetObj.CellValue(i,"t_cost_zero_exist")==1){
				sheetObj.CellBackColor(i,"t_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}
			if(sheetObj.CellValue(i,"s_cost_zero_exist")==1){
				sheetObj.CellBackColor(i,"s_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}
			if(sheetObj.CellValue(i,"a_cost_zero_exist")==1){
				sheetObj.CellBackColor(i,"a_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}		
		}
		
	}
	
	function sheet4_OnSearchEnd(){
		sheetObj = sheetObjects[1];
		sheetObj2 = sheetObjects[3];
		var routSeq = 0;
		
		if(cgoinfo_chg_flg){// Cargo Sheet 수정 됐을 시엔 하이 라이트 하지 않음
			color_flg = false;
			return;
		}
		
		for(var i=sheetObj2.HeaderRows; i<=sheetObj2.LastRow; i++){
			// 값이 0 인 경우 - 노란색으로 하이라이트
			if(sheetObj2.CellValue(i,"n_cost")=="0"){
				row = sheetObj2.CellValue(i,"rout_seq")*1 + 1;
				sheetObj.CellBackColor(row,"n_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}
			if(sheetObj2.CellValue(i,"w_cost")=="0"){
				row = sheetObj2.CellValue(i,"rout_seq")*1 + 1;
				sheetObj.CellBackColor(row,"w_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}
			if(sheetObj2.CellValue(i,"g_cost")=="0"){
				row = sheetObj2.CellValue(i,"rout_seq")*1 + 1;
				sheetObj.CellBackColor(row,"g_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}
			if(sheetObj2.CellValue(i,"t_cost")=="0"){
				row = sheetObj2.CellValue(i,"rout_seq")*1 + 1;
				sheetObj.CellBackColor(row,"t_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}
			if(sheetObj2.CellValue(i,"s_cost")=="0"){
				row = sheetObj2.CellValue(i,"rout_seq")*1 + 1;
				sheetObj.CellBackColor(row,"s_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}
			if(sheetObj2.CellValue(i,"a_cost")=="0"){
				row = sheetObj2.CellValue(i,"rout_seq")*1 + 1;
				sheetObj.CellBackColor(row,"a_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}
		}
		
		var cgoCount = sheetObjects[0].RowCount - sheetObjects[0].RowCount("D");
		var routArr = new Array(0,cgoCount,cgoCount,cgoCount,cgoCount,cgoCount);
		var shuttleArr = new Array(0,0,cgoCount,cgoCount,cgoCount,0);
		var routSeq ;
		for(var i=sheetObj2.HeaderRows; i<=sheetObj2.LastRow; i++){
			// 매칭되는 값이 없는 경우 - 하이라이트
			if(sheetObj.CellValue(sheetObj2.CellValue(i,"rout_seq")*1+1,"rout_tp_cd") == "N"){ // T/S port
				// T/S or Add-On 에 값 있어야 함
				if(sheetObj2.CellValue(i,"t_cost")!="" || sheetObj2.CellValue(i,"a_cost")!=""){
					routSeq = sheetObj2.CellValue(i,"rout_seq")*1;
					routArr[routSeq] = routArr[routSeq]-1;
				}
				// Yard 가 다를 경우 Shuttle 에 값 있어야 함
				if(sheetObj.CellValue(sheetObj2.CellValue(i,"rout_seq")*1+1,"ib_yd_cd") != sheetObj.CellValue(sheetObj2.CellValue(i,"rout_seq")*1+1,"ob_yd_cd")){
					if(sheetObj2.CellValue(i,"s_cost")!=""){
						routSeq = sheetObj2.CellValue(i,"rout_seq")*1;
						shuttleArr[routSeq] = shuttleArr[routSeq]-1;
					}
				}else{
					routSeq = sheetObj2.CellValue(i,"rout_seq")*1;
					shuttleArr[routSeq]=0;
				}
			}else if(sheetObj.CellValue(sheetObj2.CellValue(i,"rout_seq")*1+1,"rout_tp_cd") == "L"
					|| sheetObj.CellValue(sheetObj2.CellValue(i,"rout_seq")*1+1,"rout_tp_cd") == "P"){ // POL or POD
				// Normal 에 값 있어야 함
				if(sheetObj2.CellValue(i,"n_cost")!=""){
					routSeq = sheetObj2.CellValue(i,"rout_seq")*1;
					routArr[routSeq] = routArr[routSeq]-1;
				}
			}
		}
		if(routArr[1] != 0){//POL
			sheetObj.CellBackColor(1+1,"n_cost") = sheetObj.RgbColor(255, 255, 162);	
			color_flg = true;
		}
		for(var i=2;i<sheetObjects[1].RowCount-1;i++){//TS Port
			if(routArr[i] != 0){//TS
				sheetObj.CellBackColor(i+1,"t_cost") = sheetObj.RgbColor(255, 255, 162);
				color_flg = true;
			}
			if(sheetObj.CellValue(i,"ib_yd_cd") != sheetObj.CellValue(i,"ob_yd_cd")){//Shuttle
				if(shuttleArr[i] != 0){
					sheetObj.CellBackColor(i+1,"s_cost") = sheetObj.RgbColor(255, 255, 162); 
					color_flg = true;
				}
			}
		}
		if(routArr[sheetObjects[1].RowCount] != 0){//POD
			sheetObj.CellBackColor(sheetObjects[1].RowCount+1,"n_cost") = sheetObj.RgbColor(255, 255, 162);
			color_flg = true;
		}
		
		if(color_flg){
			document.getElementById("red_msg").innerText = "If cells have color, please check calculation data to check whether unit cost missing or not.";
		}else{
			document.getElementById("red_msg").innerText = "Please check whether the Wire/Special Gear are used or not.";
		}
		color_flg = false;
	}	
	
	function setTotalRate(){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		var total_basic = 0;
		var total_void  = 0;
		
		for(var i=2;i<=sheetObj.LastRow;i++){
			//20ft (void에 2를 더 곱함) - Box 단위로 바꾸면서 곱하기 2 제외시킴 - 로직 구분 필요 없음
			total_basic = total_basic + (sheetObj.CellValue(i,"cntr_qty")*sheetObj.CellValue(i,"prop_bsrt_amt"));
 			total_void  = total_void  + ((sheetObj.CellValue(i,"cntr_qty")*sheetObj.CellValue(i,"prop_void_rt_amt"))*(sheetObj.CellValue(i,"ovr_void_slt_qty")*1));
 		}
 		
// 		for(var i=2;i<=sheetObj.LastRow;i++){	
// 			if(sheetObj.CellValue(i,"cntr_qty")==""||sheetObj.CellValue(i,"prop_bsrt_amt")==""){
//				total_basic = " "; // 빈 값이 있으면 지움
//			}
//			if(sheetObj.CellValue(i,"cntr_qty")==""||sheetObj.CellValue(i,"prop_void_rt_amt")==""||sheetObj.CellValue(i,"ovr_void_slt_qty")==""){
//				total_void = " "; // 빈 값이 있으면 지움
//			}
//		}
		formObj.rqst_basic_rate.value = total_basic;		
     	formObj.rqst_void_rate.value = total_void;
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
	     var sheetObj = sheetObjects[2];
	     
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
	 * @version 2009.05.07
	 */  
	 function clearActCustName(){
	     var formObj = document.form;
	     var sheetObj = sheetObjects[2];
	     
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
	     var sheetObj = sheetObjects[2];
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
	     var sheetObj = sheetObjects[2];         
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
		     var sheetObj = sheetObjects[2];
		     var cust_cnt_cd = formObj.act_cust_cnt_cd.value;        
		     var cust_seq = formObj.act_cust_seq.value;        
		     
		     if(cust_cnt_cd != "" && cust_seq !=""){
		         var sParam = "f_cmd="+COMMAND07+"&etc1="+cust_cnt_cd+"&etc2="+cust_seq;
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
		     var sheetObj = sheetObjects[2];         
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
    	
    	sheetObjects[0].Redraw = false;
    	
    	sheetObjects[2].CellValue2( 1, "meas_sys_cd") = code;
    	
    	var sXml = ""
    	if ( sheetObjects[0].RowCount > 0 ){
            sXml = ComPriSheet2Xml ( sheetObjects[0] );
    	}	
    	
    	initSheet ( sheetObjects[0], 1 );   	
        
        ComEndConfigSheet(sheetObjects[0]);
    	ComSetIBCombo(sheetObjects[0],cntrTpSzXml,"cntr_tpsz_cd",true,0);	
        
    	if ( sXml != "" ) {
    		ComPriXml2Sheet ( sheetObjects[0], sXml);
    		sXml = "";
    	}
        
        convertMeasSysCd(sheetObjects[0], code );
        
        sheetObjects[0].Redraw = true;
    }
    
    function convertMeasSysCd ( sheetObj, code ){
    	
    	var ttl_dim_len = 0, ttl_dim_wdt = 0, ttl_dim_hgt = 0, grs_wgt = 0;
    	
    	for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
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
    		sheetObj.CellValue2 ( i, "grs_wgt"     ) = grs_wgt;
    		
    		sheetObj.SelectRow = i;
    		
    		overDimensionSettingHeight();
    		overDimensionSettingLength();
    		overDimensionSettingWidth();
    	}
    }
    
    function ttlAmtCalculate ( sheetObj, row ) {
    	
		var apro_basic = 0;
		var apro_void = 0;
		var cntr_qty = sheetObj.CellValue ( row, "cntr_qty");
		
		if ( sheetObj.CellValue(row, "del_chk" ) == 1 || cntr_qty == "" || cntr_qty == 0 ) {
			cntr_qty = 1;
		}
		
		apro_basic = ( cntr_qty * sheetObj.CellValue(row,"apro_bsrt_amt") );
		apro_void  = ( cntr_qty * ( sheetObj.CellValue(row,"apro_void_rt_amt") * sheetObj.CellValue(row,"ovr_void_slt_qty") ) );
		if ( ( apro_basic + apro_void ) > 0 ) {
			sheetObj.CellValue ( row, "ttl_amt") = apro_basic + apro_void;
		}
	
    }

/* 개발자 작업  끝 */