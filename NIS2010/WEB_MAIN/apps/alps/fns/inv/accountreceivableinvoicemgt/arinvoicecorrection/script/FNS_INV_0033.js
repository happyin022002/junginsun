/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0033.js
*@FileTitle : Invoice Split After Invoice Issue
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.22
 *@LastModifier : 최도순
 *@LastVersion : 1.0
 * 2009.09.22 최도순
 * 1.0 Creation
 * --------------------------------------------------------
 * History
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
	 * @extends 
	 * @class FNS_INV_0033 : FNS_INV_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0033() {
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
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	// Tab 이벤트시  Customer 체크를 위한 전역변수
	var isCustCheckErr = false;
	var errIndex = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
	
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
	
			case "btn_retrive":			
				doActionIBSheet(sheetObject,formObject,IBSEARCH);	
				break;
	
			case "btn_new":
				formObject.ar_ofc_cd.RemoveAll(); 
				tabObjects[0].RemoveAll();
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				sheetObjects[9].RemoveAll();
				ComResetAll();
				document.getElementById ("mst_sum").innerHTML = "";
				document.getElementById ("split_sum").innerHTML = "";
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
	
				ComBtnDisable("btn_go");
				ComBtnDisable("btn_paper");
				ComBtnEnable("btn_retrive");
				ComBtnEnable("btn_save");
	
				formObject.inv_no.readOnly=false;
				formObject.split_cnt.readOnly=false;					
				formObject.inv_no.className = "input1";
				formObject.split_cnt.className = "input1";
				formObject.inv_no.focus();
				break;
	
			case "btn_save":
				sheetObjects[9].RemoveAll();				
				sheetObjects[10].RemoveAll();				
				sheetObjects[11].RemoveAll();				
	
				doActionIBSheet(sheetObjects[9],formObject,IBSAVE);
				break;
	
			case "btn_paper":
				if(validateForm(sheetObjects[9],formObject,"IBSAVE")){
					ComBtnDisable("btn_go");
					ComBtnDisable("btn_paper");
	
					formObject.email_flag.value = "N";
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);              
				}
				break;
	
			case "btn_go":
				if(validateForm(sheetObjects[9],document.form,"")){
					
					ComBtnDisable("btn_go");
					ComBtnDisable("btn_paper");
					
					var ar_ofc_cd = formObject.ar_ofc_cd2.value;
					if (ar_ofc_cd == "DXBSC") {
						formObject.bl_nos.value = "'"+ formObject.frm_bl_src_no.value + "'";
						
						var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
						formObject.svr_id.value = arrStr2[7]; 			    
						formObject.ots_smry_cd.value = arrStr2[13]; 	
						formObject.inv_dup_flg.value = arrStr2[14]; 
						formObject.inv_mlt_bl_iss_flg.value = arrStr2[15]; 	
						
						var param = FormQueryString(formObject);
						ComOpenWindowCenter("FNS_INV_0110.do?"+param, "pop", 730, 400);
						//FNS_INV_0110 에서 issue ok 되면 호출 -  getFnsInv0110()
					}else{
						formObject.email_flag.value = "Y";
						doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
		
						var state = formObject.state.value;  
						var r_invs = formObject.inv_nos.value;  
						var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
						formObject.ar_ofc_cd2.value = arrStr2[1];
					}
				} else {
					return;
				} 		
	
				break;
	
			case "btn_actcust":
				var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObject.act_cust_cnt_cd[tabObjects[0].SelectedIndex].value+'&cust_seq='+formObject.act_cust_seq[tabObjects[0].SelectedIndex].value+'&pop_yn=Y';
				ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
				break;
	
			case "btn_frmactcust":
				var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObject.frm_act_cust_cnt_cd.value+'&cust_seq='+formObject.frm_act_cust_seq.value+'&pop_yn=Y';
				ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
				break;
	
			case "btn_shprcust":
				var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObject.frm_shpr_cust_cnt_cd.value+'&cust_seq='+formObject.frm_shpr_cust_seq.value+'&pop_yn=Y';
				ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
				break;
	
			case "btn_fwdrcust":
				var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObject.frm_fwdr_cust_cnt_cd.value+'&cust_seq='+formObject.frm_fwdr_cust_seq.value+'&pop_yn=Y';
				ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
				break;
	
			case "btn_custNm":
				param = '?pgmNo=FNS_INV_0086&cust_seq='+formObject.act_cust_seq[tabObjects[0].SelectedIndex].value+'&cust_cnt_cd='+formObject.act_cust_cnt_cd[tabObjects[0].SelectedIndex].value;
				ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086', '1,0', false, false, 1, 1, 0);
				break;
	
			case "btn_container":
				sheet_container = sheetObjects[2]; 
				ComOpenPopup('/hanjin/FNS_INV_0098.do?pgmNo=FNS_INV_0098', 700, 380, '', '0,0');  
				break; 
	
			case "btn_container_e":
				sheet_container = sheetObjects[12]; 
				ComOpenPopup('/hanjin/FNS_INV_0098.do?arIfNo='+tabObjects[0].TabText([tabObjects[0].SelectedIndex]) +'&pagetype=E&pgmNo=FNS_INV_0098&', 700, 400, 'getFNS_INV_0098', '0,0');
				break;
	
			case "btn_rfano":
				ComOpenPopup('/hanjin/FNS_INV_0090.do?pgmNo=FNS_INV_0090&rfa_no='+formObject.frm_rfa_no.value, 600, 368, '', '0,0');  
				break; 
			case "btn_scno":
				ComOpenPopup('/hanjin/FNS_INV_0091.do?pgmNo=FNS_INV_0091&sc_no='+formObject.frm_sc_no.value, 600, 368, '', '0,0');  
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
	 * IBSheet Object를 sheetObjects 배열로 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function setSheetObject(sheet_obj){
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	/** 
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
		for(i=0;i<4;i++){
			ComConfigSheet (sheetObjects[i] );	
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);	
		}
		initControl();
	
		initRdConfig(rdObjects[0]);
	
		ComBtnDisable("btn_go");
		ComBtnDisable("btn_paper");
	
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 

		form.inv_no.focus();
		
	}
		
	function initRdConfig(rdObject){
		var Rdviewer = rdObject ;
		Rdviewer.style.height = 0;
		Rdviewer.style.width = 0;
	
		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
	
	/** 
	 * Sheet 기본 설정 및 초기화 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBSheet} sheetObj : 시트오브젝트
	 * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
		var shtID = sheetObj.id;
	
		switch(shtID) {
	
		case "sheet1":      //sheet1 init
		with (sheetObj) {
	
			// 높이 설정
			style.height =0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(68, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true,true, false, true, false,false)
	
			var HeadTitle = "|bl_no|bkg_no|if_no|actual cust seq| actual cust cd|cust_nm |cust_rgst_no|inv cust cd|inv_cust_seq |crdt limit cd |crdt limit amt | crdt term ob|crdt term ib| crdt office| vsl_cd|skd_voy_no|skd_dir_cd|local vvd| scope| bound|s/a Date|trnk_vsl_cd|trnk_skd_voy_no|trnk_skd_dir_cd|Trunk vvd|Lane|PoR|pol|pod|del|c/a no.|c/a Date|SML Ref.|INV ref.no|Bkg Ref.No|S/I Ref.No|Description|Rev.Type|Source|Master B/L|RFA No.|S/C No|Sales Rep.|Weight|Measure|WHF DEC|WHF Date|TEU|FEU|I/F Date|Good Date|Eff.Date|INV No.|Issue Date|Due Date|FWDR Code|FWDR Seq|cr_flg|zn_ioc_cd|locl_curr_cd|inv_delt_div_cd|CR_TERM_DYS|CUST_CR_FLG|XCH_RT_N3RD_TP_CD|XCH_RT_USD_TP_CD|XCH_RT_DT|sail_dt";
	
	
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bl_src_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bkg_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "ar_if_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "act_cust_cnt_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "act_cust_seq");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cust_nm");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cust_rgst_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_cust_cnt_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_cust_seq");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cr_curr_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cr_amt");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "ob_cr_term_dys");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "ib_cr_term_dys");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cr_clt_ofc_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "vsl_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "skd_voy_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "skd_dir_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "local_vvd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "svc_scp_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "io_bnd_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "sail_arr_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "trnk_vsl_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "trnk_skd_voy_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "trnk_skd_dir_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "trunk_vvd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "slan_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "por_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "pol_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "pod_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "del_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bkg_corr_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bkg_corr_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "hjs_stf_ctnt");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_ref_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bkg_ref_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "si_ref_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_rmk");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "rev_tp_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "rev_src_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "mst_bl_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "rfa_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "sc_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "srep_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cgo_wgt");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cgo_meas_qty");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "whf_decl_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "whf_decl_cfm_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bkg_teu_qty");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bkg_feu_qty");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bl_inv_if_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bl_inv_cfm_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "gl_eff_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "iss_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "due_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "frt_fwrd_cnt_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "frt_fwrd_cust_seq");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cr_flg");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "zn_ioc_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "locl_curr_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_delt_div_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cr_term_dys");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cust_cr_flg");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "xch_rt_n3rd_tp_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "xch_rt_usd_tp_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "xch_rt_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "sail_dt");
			WaitImageVisible = false; 
		}
		break;
	
		case "sheet2":     
			with (sheetObj) {
	
				// 높이 설정
				style.height = 135;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(11, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				var HeadTitle       = "|Seq.|CHG|Cur|Rate|Rated As|Per|Amount|Ex. Rate||";
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,     40,    daCenter,  true,    "ibflag",     false,          "",      dfNone );
				InitDataProperty(rowCnt, cnt++ , dtDataSeq,     40,    daCenter,  true,    "Seq",     false,          "",      dfNone ,0, false, false , -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     60,    daCenter,  true,    "chg_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     80,    daCenter,  true,    "curr_cd",     false,          "",      dfNone ,0 , false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     90,    daRight,  true,    "trf_rt_amt",     false,          "",      dfFloat, 2, false, false , 50, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     80,    daRight,  true,    "rat_as_cntr_qty",     false,          "",      dfFloat,  3 , false, false, 50, false, false);
	
				InitDataProperty(rowCnt, cnt++ , dtData,     80,    daCenter,  true,    "per_tp_cd",     false,          "",      dfNone ,0 , false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     80,    daRight,  true,    "chg_amt",     false,          "",      dfFloat, 2, false, false , 50, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     65,    daCenter,  true,    "inv_xch_rt",     false,          "",      dfNullFloat, 7, false, false , 50, false, false);
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "tj_src_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "dp_prcs_knt",     false,          "",      dfNone, 0, false, false );
	
				CountPosition = 0;
				EditableColorDiff = false;
				WaitImageVisible = false; 
			}
			break;
	
		case "sheet3":      //container
		with (sheetObj) {
	
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(7, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true,true, false, true, false,false)
	
			var HeadTitle = "|cntr_tpsz_cd|cntr_no|cntr_seq|teu|feu|ar_if_no|";
	
	
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cntr_tpsz_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cntr_no");
			InitDataProperty(0, cnt++ , dtSeq,  40,    daCenter,  true,    "cntr_seq");
			InitDataProperty(0, cnt++ , dtAutoSum,  40,    daCenter,  true,    "teu");
			InitDataProperty(0, cnt++ , dtAutoSum,  40,    daCenter,  true,    "feu");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "ar_if_no");
			WaitImageVisible = false; 
		}
		break;
	
		case "sheet4":       
			with (sheetObj) {
	
				// 높이 설정
				style.height =0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 10, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(7, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true,true, false, true, false,false)
	
				var HeadTitle = "|shpr_cust_cnt_cd|shpr_cust_seq|shpr_cust_nm|fwdr_cust_cnt_cd|fwdr_cust_seq|fwdr_cust_nm";
	
	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				initDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "shpr_cust_cnt_cd");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "shpr_cust_seq");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "shpr_cust_nm");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "fwdr_cust_cnt_cd");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "fwdr_cust_seq");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "fwdr_cust_nm");
				WaitImageVisible = false; 
			}
			break;
	
		case "t0sheet1":   			
			with (sheetObj) {
	
				// 높이 설정
				style.height = 137;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
	
				var HeadTitle = "|Seq.|CHG|Cur|Rate|Rated As|Per|Amount|inv_xch_rt|tj_src_nm|ar_if_no|ar_if_ser_no|chg_seq|inv_xch_rt_dt|rep_chg_cd|chg_full_nm|trf_no|sob_id|inv_rev_tp_src_cd|rev_coa_co_cd"+
				"|rev_coa_rgn_cd|rev_coa_ctr_cd|rev_coa_acct_cd|rev_coa_inter_co_cd|rev_coa_vsl_cd|rev_coa_voy_no|rev_coa_skd_dir_cd|rev_coa_dir_cd|acct_cd|tva_flg|chg_rmk|mnl_flg|mf_div_cd|||";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,     0,    daCenter,  true,    "ibflag",     false,          "",      dfNone );
				InitDataProperty(rowCnt, cnt++ , dtDataSeq,     30,    daCenter,  true,    "Seq",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     50,    daCenter,  true,    "chg_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daCenter,  true,    "curr_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     80,    daRight,  true,    "trf_rt_amt",     false,          "",      dfFloat,         2 , true, true, 50, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daRight,  true,    "rat_as_cntr_qty",     false,          "",      dfFloat,         3 , true, true, 50, false, false);
	
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daCenter,  true,    "per_tp_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daRight,  true,    "chg_amt",     false,          "",      dfFloat, 2, false, false , -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_xch_rt",     false,          "",      dfNullFloat, 7, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "tj_src_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "ar_if_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "ar_if_ser_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_seq",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_xch_rt_dt",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rep_chg_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_full_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "trf_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "sob_id",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_rev_tp_src_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_co_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_rgn_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_ctr_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_acct_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_inter_co_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_vsl_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_voy_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_skd_dir_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_dir_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "acct_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "tva_flg",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_rmk",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "mnl_flg",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "mf_div_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "new_ser_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "new_chg_seq",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "dp_prcs_knt",     false,          "",      dfNone, 0, false, false );
	
				CountPosition = 0;
				WaitImageVisible = false; 
			}
			break;	
	
		case "t1sheet1":   			
			with (sheetObj) {
	
				// 높이 설정
				style.height = 137;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
	
				var HeadTitle = "|Seq.|CHG|Cur|Rate|Rated As|Per|Amount|inv_xch_rt|tj_src_nm|ar_if_no|ar_if_ser_no|chg_seq|inv_xch_rt_dt|rep_chg_cd|chg_full_nm|trf_no|sob_id|inv_rev_tp_src_cd|rev_coa_co_cd"+
				"|rev_coa_rgn_cd|rev_coa_ctr_cd|rev_coa_acct_cd|rev_coa_inter_co_cd|rev_coa_vsl_cd|rev_coa_voy_no|rev_coa_skd_dir_cd|rev_coa_dir_cd|acct_cd|tva_flg|chg_rmk|mnl_flg|mf_div_cd|||";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,     0,    daCenter,  true,    "ibflag",     false,          "",      dfNone );
				InitDataProperty(rowCnt, cnt++ , dtDataSeq,     30,    daCenter,  true,    "Seq",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     50,    daCenter,  true,    "chg_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daCenter,  true,    "curr_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     80,    daRight,  true,    "trf_rt_amt",     false,          "",      dfFloat,         2 , true, true, 50, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daRight,  true,    "rat_as_cntr_qty",     false,          "",      dfFloat,         3 , true, true, 50, false, false);
	
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daCenter,  true,    "per_tp_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daRight,  true,    "chg_amt",     false,          "",      dfFloat, 2, false, false , -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_xch_rt",     false,          "",      dfNullFloat, 7, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "tj_src_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "ar_if_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "ar_if_ser_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_seq",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_xch_rt_dt",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rep_chg_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_full_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "trf_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "sob_id",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_rev_tp_src_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_co_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_rgn_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_ctr_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_acct_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_inter_co_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_vsl_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_voy_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_skd_dir_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_dir_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "acct_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "tva_flg",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_rmk",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "mnl_flg",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "mf_div_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "new_ser_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "new_chg_seq",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "dp_prcs_knt",     false,          "",      dfNone, 0, false, false );
	
				CountPosition = 0;
				WaitImageVisible = false; 
			}
			break;
		case "t2sheet1":   			
			with (sheetObj) {
	
				// 높이 설정
				style.height = 137;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
	
				var HeadTitle = "|Seq.|CHG|Cur|Rate|Rated As|Per|Amount|inv_xch_rt|tj_src_nm|ar_if_no|ar_if_ser_no|chg_seq|inv_xch_rt_dt|rep_chg_cd|chg_full_nm|trf_no|sob_id|inv_rev_tp_src_cd|rev_coa_co_cd"+
				"|rev_coa_rgn_cd|rev_coa_ctr_cd|rev_coa_acct_cd|rev_coa_inter_co_cd|rev_coa_vsl_cd|rev_coa_voy_no|rev_coa_skd_dir_cd|rev_coa_dir_cd|acct_cd|tva_flg|chg_rmk|mnl_flg|mf_div_cd|||";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,     0,    daCenter,  true,    "ibflag",     false,          "",      dfNone );
				InitDataProperty(rowCnt, cnt++ , dtDataSeq,     30,    daCenter,  true,    "Seq",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     50,    daCenter,  true,    "chg_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daCenter,  true,    "curr_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     80,    daRight,  true,    "trf_rt_amt",     false,          "",      dfFloat,         2 , true, true, 50, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daRight,  true,    "rat_as_cntr_qty",     false,          "",      dfFloat,         3 , true, true, 50, false, false);
	
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daCenter,  true,    "per_tp_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daRight,  true,    "chg_amt",     false,          "",      dfFloat, 2, false, false , -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_xch_rt",     false,          "",      dfNullFloat, 7, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "tj_src_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "ar_if_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "ar_if_ser_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_seq",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_xch_rt_dt",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rep_chg_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_full_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "trf_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "sob_id",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_rev_tp_src_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_co_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_rgn_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_ctr_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_acct_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_inter_co_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_vsl_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_voy_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_skd_dir_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_dir_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "acct_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "tva_flg",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_rmk",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "mnl_flg",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "mf_div_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "new_ser_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "new_chg_seq",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "dp_prcs_knt",     false,          "",      dfNone, 0, false, false );
	
				CountPosition = 0;
				WaitImageVisible = false; 
			}
			break;
		case "t3sheet1":   			
			with (sheetObj) {
	
				// 높이 설정
				style.height = 137;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
	
				var HeadTitle = "|Seq.|CHG|Cur|Rate|Rated As|Per|Amount|inv_xch_rt|tj_src_nm|ar_if_no|ar_if_ser_no|chg_seq|inv_xch_rt_dt|rep_chg_cd|chg_full_nm|trf_no|sob_id|inv_rev_tp_src_cd|rev_coa_co_cd"+
				"|rev_coa_rgn_cd|rev_coa_ctr_cd|rev_coa_acct_cd|rev_coa_inter_co_cd|rev_coa_vsl_cd|rev_coa_voy_no|rev_coa_skd_dir_cd|rev_coa_dir_cd|acct_cd|tva_flg|chg_rmk|mnl_flg|mf_div_cd|||";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,     0,    daCenter,  true,    "ibflag",     false,          "",      dfNone );
				InitDataProperty(rowCnt, cnt++ , dtDataSeq,     30,    daCenter,  true,    "Seq",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     50,    daCenter,  true,    "chg_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daCenter,  true,    "curr_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     80,    daRight,  true,    "trf_rt_amt",     false,          "",      dfFloat,         2 , true, true, 50, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daRight,  true,    "rat_as_cntr_qty",     false,          "",      dfFloat,         3 , true, true, 50, false, false);
	
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daCenter,  true,    "per_tp_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daRight,  true,    "chg_amt",     false,          "",      dfFloat, 2, false, false , -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_xch_rt",     false,          "",      dfNullFloat, 7, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "tj_src_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "ar_if_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "ar_if_ser_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_seq",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_xch_rt_dt",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rep_chg_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_full_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "trf_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "sob_id",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_rev_tp_src_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_co_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_rgn_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_ctr_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_acct_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_inter_co_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_vsl_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_voy_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_skd_dir_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_dir_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "acct_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "tva_flg",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_rmk",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "mnl_flg",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "mf_div_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "new_ser_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "new_chg_seq",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "dp_prcs_knt",     false,          "",      dfNone, 0, false, false );
	
				CountPosition = 0;
				WaitImageVisible = false; 
			}
			break;
		case "t4sheet1":   			
			with (sheetObj) {
	
				// 높이 설정
				style.height = 137;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
	
				var HeadTitle = "|Seq.|CHG|Cur|Rate|Rated As|Per|Amount|inv_xch_rt|tj_src_nm|ar_if_no|ar_if_ser_no|chg_seq|inv_xch_rt_dt|rep_chg_cd|chg_full_nm|trf_no|sob_id|inv_rev_tp_src_cd|rev_coa_co_cd"+
				"|rev_coa_rgn_cd|rev_coa_ctr_cd|rev_coa_acct_cd|rev_coa_inter_co_cd|rev_coa_vsl_cd|rev_coa_voy_no|rev_coa_skd_dir_cd|rev_coa_dir_cd|acct_cd|tva_flg|chg_rmk|mnl_flg|mf_div_cd|||";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,     0,    daCenter,  true,    "ibflag",     false,          "",      dfNone );
				InitDataProperty(rowCnt, cnt++ , dtDataSeq,     30,    daCenter,  true,    "Seq",     false,          "",      dfNone );
				InitDataProperty(rowCnt, cnt++ , dtData,     50,    daCenter,  true,    "chg_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daCenter,  true,    "curr_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     80,    daRight,  true,    "trf_rt_amt",     false,          "",      dfFloat,         2 , true, true, 50, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daRight,  true,    "rat_as_cntr_qty",     false,          "",      dfFloat,         3 , true, true, 50, false, false);
	
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daCenter,  true,    "per_tp_cd",     false,          "",      dfNone ,0, false, false, -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,     70,    daRight,  true,    "chg_amt",     false,          "",      dfFloat, 2, false, false , -1, false, false);
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_xch_rt",     false,          "",      dfNullFloat, 7, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "tj_src_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "ar_if_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "ar_if_ser_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_seq",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_xch_rt_dt",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rep_chg_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_full_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "trf_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "sob_id",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "inv_rev_tp_src_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_co_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_rgn_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_ctr_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_acct_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_inter_co_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_vsl_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_voy_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_skd_dir_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "rev_coa_dir_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "acct_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "tva_flg",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "chg_rmk",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "mnl_flg",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "mf_div_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "new_ser_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "new_chg_seq",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtHidden,    0,    daCenter,  true,    "dp_prcs_knt",     false,          "",      dfNone, 0, false, false );
	
				CountPosition = 0;
				WaitImageVisible = false; 
			}
			break;			
	
		case "s0sheet1":      //sheet1 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(12, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true,true, false, true, false,false)
	
			var HeadTitle = "|ar_if_no|act_cust_cnt_cd|act_cust_seq|bkg_teu_qty|bkg_feu_qty|inv_ref_no|hjs_stf_ctnt|inv_rmk|io_bnd_cd|sail_dt|cust_cd";
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "ar_if_no" , true);
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "act_cust_cnt_cd" , true);
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "act_cust_seq", true);
			InitDataProperty(0, cnt++ , dtData,  90,    daCenter,  true,    "bkg_teu_qty");
			InitDataProperty(0, cnt++ , dtData,  90,    daCenter,  true,    "bkg_feu_qty");
			InitDataProperty(0, cnt++ , dtData,  90,    daCenter,  true,    "inv_ref_no");
			InitDataProperty(0, cnt++ , dtData,  90,    daCenter,  true,    "hjs_stf_ctnt");
			InitDataProperty(0, cnt++ , dtData,  90,    daCenter,  true,    "inv_rmk");
			InitDataProperty(0, cnt++ , dtData,  90,    daCenter,  true,    "io_bnd_cd");
			InitDataProperty(0, cnt++ , dtData,  90,    daCenter,  true,    "sail_arr_dt");
			InitDataProperty(0, cnt++ , dtData,  90,    daCenter,  true,    "cust_cd");
	
			CountPosition = 0;   
			WaitImageVisible = false; 
		}
		break;
	
		case "s0sheet2":   			
			with (sheetObj) {
	
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
	
				var HeadTitle = "|ar_if_no|ar_if_ser_no|chg_seq|chg_cd|rat_as_cntr_qty|trf_rt_amt|per_tp_cd|curr_cd|chg_amt|inv_xch_rt|tj_src_nm|inv_xch_rt_dt|rep_chg_cd|chg_full_nm|trf_no|sob_id|inv_rev_tp_src_cd|rev_coa_co_cd"+
				"|rev_coa_rgn_cd|rev_coa_ctr_cd|rev_coa_acct_cd|rev_coa_inter_co_cd|rev_coa_vsl_cd|rev_coa_voy_no|rev_coa_skd_dir_cd|rev_coa_dir_cd|acct_cd|tva_flg|chg_rmk|mnl_flg|mf_div_cd|ar_if_chg_seq";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,     0,    daCenter,  true,    "ibflag",     false,          "",      dfNone );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "ar_if_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "ar_if_ser_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "chg_seq",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    50,    daCenter,  true,    "chg_cd",     false,          "",      dfNone ,0, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daRight,  true,     "rat_as_cntr_qty",     false,          "",      dfFloat,         3 , true, true);
				InitDataProperty(rowCnt, cnt++ , dtData,    80,    daRight,  true,     "trf_rt_amt",     false,          "",      dfFloat,         2 , true, true);
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "per_tp_cd",     false,          "",      dfNone ,0, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "curr_cd",     false,          "",      dfNone ,0, false, false);
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daRight,  true,     "chg_amt",     false,          "",      dfFloat, 3, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "inv_xch_rt",     false,          "",      dfNullFloat, 7, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "tj_src_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "inv_xch_rt_dt",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "rep_chg_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "chg_full_nm",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "trf_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "sob_id",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "inv_rev_tp_src_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "rev_coa_co_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "rev_coa_rgn_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "rev_coa_ctr_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "rev_coa_acct_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "rev_coa_inter_co_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "rev_coa_vsl_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "rev_coa_voy_no",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "rev_coa_skd_dir_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "rev_coa_dir_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "acct_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "tva_flg",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "chg_rmk",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "mnl_flg",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "mf_div_cd",     false,          "",      dfNone, 0, false, false );
				InitDataProperty(rowCnt, cnt++ , dtData,    70,    daCenter,  true,    "ar_if_chg_seq",     false,          "",      dfNone, 0, false, false );
	
				CountPosition = 0;
				WaitImageVisible = false; 
			}
			break;	
	
		case "s0sheet3":      //container
		with (sheetObj) {
	
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);
	
			var HeadTitle = "|ar_if_no|ar_if_ser_no|tj_src_nm|curr_cd|inv_amt";
			var headCount = ComCountHeadTitle(HeadTitle);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true,true, false, true, false,false)
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "ar_if_no");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "ar_if_ser_no");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "tj_src_nm");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "curr_cd");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "inv_amt");
	
			CountPosition = 0;
			WaitImageVisible = false; 
		}
		break;
	
		case "s0sheet4":      //container
		with (sheetObj) {
	
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(6, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true,true, false, true, false,false)
	
			var HeadTitle = "|check||ar_if_no|cntr_seq|cntr_tpsz_cd|cntr_no";
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,  40,    daCenter,  true,    "check");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "ar_if_no");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "cntr_seq");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "cntr_tpsz_cd");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "cntr_no");
	
			CountPosition = 0;
			WaitImageVisible = false; 
		}
		break;
		case "s0sheet5":      //container
		with (sheetObj) {
	
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(5, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true,true, false, true, false,false)
	
			var HeadTitle = "|if_no|cancel_if_no|max_if_no|m_if_no";
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
	
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "if_no");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "cancel_if_no");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "max_if_no");
			InitDataProperty(0, cnt++ , dtData,  100,    daCenter,  true,    "m_if_no");
	
			CountPosition = 0;
			WaitImageVisible = false; 
		}
		break;
		}
	}
	
	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false; 
		switch(sAction) {
	
		case IBSEARCH_ASYNC01: // 화면 로딩시 AR_OFFICE_LIST 조회
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
	
		var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
		var arrStr = sStr.split("|");
	
		MakeComboObject2(formObj.ar_ofc_cd, arrStr);
	
		var arrStr2 = "";
		var ar_ofc_cd = "";
	
		for(i=1;i<arrStr.length;i++){
			arrStr2 = arrStr[i].split("^");
			if(arrStr2[1]==arrStr2[3]){
				ar_ofc_cd = arrStr2[1];
	
				formObj.ar_ofc_cd.text = ar_ofc_cd;
				formObj.ofc.value = ar_ofc_cd;
				form.ofc_cd.value = form.ofc.value;	
			}
		}	
		ComOpenWait(false);
	
		break;
	
		case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)){
			ComOpenWait(true);
			for(i=4;i<sheetObjects.length;i++){
				ComConfigSheet (sheetObjects[i] );	
				initSheet(sheetObjects[i],i+1);
				ComEndConfigSheet(sheetObjects[i]);	
			}
	
			tabObjects[0].RemoveAll();
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("FNS_INV_0033GS.do" , FormQueryString(formObj));					
	
			var arrXml = sXml.split("|$$|");
	
			if ( arrXml[0] != null)	{
				sheetObjects[0].LoadSearchXml(arrXml[0]); 	
			}
			if ( arrXml[1] != null)	{
				sheetObjects[1].LoadSearchXml(arrXml[1]); 	
			}	
			if ( arrXml[2] != null)	{
				sheetObjects[2].LoadSearchXml(arrXml[2]); 	
			}
			if ( arrXml[4] != null)	{
				sheetObjects[3].LoadSearchXml(arrXml[4]); 	
			}
			if ( arrXml[3] != null)	{
				sheetObjects[13].LoadSearchXml(arrXml[3]); 	
			}
	
			if(ComGetEtcData(sXml,"TRANS_RESULT_KEY")=="F"){
				ComOpenWait(false);
				form.inv_no.select();
				return;
			}
	
	
			IBS_CopyRowToForm(sheetObjects[0],document.form, 1,"frm_") ;  
			IBS_CopyRowToForm(sheetObjects[3],document.form, 1,"frm_") ;  
	
			formObj.frm_sail_arr_dt.value = sheetObjects[0].CellText(1, "sail_arr_dt");
			formObj.frm_iss_dt.value = sheetObjects[0].CellText(1, "iss_dt");
	
	
			formObj.frm_port_cd.value = sheetObjects[0].CellValue(1, "io_bnd_cd")=="I/B"?sheetObjects[0].CellValue(1, "pod_cd"):sheetObjects[0].CellValue(1, "pol_cd");
	
			var sStr = ComGetEtcData(arrXml[0],"max_seq");
			formObj.max_seq.value=sStr;
	
			formObj.if_no.value=sheetObjects[13].CellValue(1,"max_if_no")==""?sheetObjects[13].CellValue(1,"m_if_no"):sheetObjects[13].CellValue(1,"max_if_no");
	
			for(k=0;k<tabObjects.length;k++){
				initTab(tabObjects[k],k+1);
			}
	
			var split_cnt = document.form.split_cnt.value;
			if(split_cnt!=''&&sStr!=''){
				for(cnt = 0;cnt < split_cnt; cnt++){
					for(i=0;i<sheetObjects.length;i++){
						if(sheetObjects[i].id=="t"+cnt+"sheet1"){
							sheetObjects[i].LoadSearchXml(arrXml[1]); 
	
							for(k=1;k<=sheetObjects[i].RowCount;k++){
								sheetObjects[i].CellValue(k,"ar_if_no") = tabObjects[0].TabText(cnt);
								currPoint = sheetObjects[i].CellValue(k,"dp_prcs_knt");
								if (currPoint == '0') {
									sheetObjects[i].InitCellProperty(k , "chg_amt", dtData , daRight , "chg_amt", "", dfInteger );
								}
								else {
									sheetObjects[i].InitCellProperty(k , "chg_amt", dtData , daRight , "chg_amt", "", dfNullFloat, currPoint );
								}
							}
							sheetObjects[i].ShowSubSum("curr_cd", "7", 2, false, false, 0, "per_tp_cd=Total;curr_cd=%s");
	
						}
									
					}
	
					document.form.inv_ref_no[cnt].value = sheetObjects[0].CellValue(1,"inv_ref_no");	
					document.form.hjs_stf_ctnt[cnt].value = document.form.user_nm.value;	
	
					for(x=1;x<sheetObjects[2].RowCount+1;x++){
						var nRow = sheetObjects[12].DataInsert(-1); 
						sheetObjects[12].CellValue(nRow,"ar_if_no") = tabObjects[0].TabText(cnt);
						sheetObjects[12].CellValue(nRow,"cntr_seq") = sheetObjects[2].CellValue(x,"cntr_seq");
						sheetObjects[12].CellValue(nRow,"cntr_no") = sheetObjects[2].CellValue(x,"cntr_no");
						sheetObjects[12].CellValue(nRow,"cntr_tpsz_cd") = sheetObjects[2].CellValue(x,"cntr_tpsz_cd");
					}
	
					formObj.bkg_teu_qty[cnt].value = formObj.frm_bkg_teu_qty.value;
					formObj.bkg_feu_qty[cnt].value = formObj.frm_bkg_feu_qty.value;
				}
			}
	
			reSum(sheetObjects[4]);
			
			ComOpenWait(false);
		}
		break;
	
		case IBSAVE:        //저장
		if(formObj.split_cnt.value != ""){
			for(cnt = 0;cnt < formObj.split_cnt.value; cnt++){
				sheetObjects[9].DataInsert(-1); 
				sheetObjects[9].CellValue(cnt+1,"ar_if_no") = tabObjects[0].TabText(cnt);
				sheetObjects[9].CellValue(cnt+1,"act_cust_cnt_cd") = formObj.act_cust_cnt_cd[cnt].value;
				sheetObjects[9].CellValue(cnt+1,"act_cust_seq") = formObj.act_cust_seq[cnt].value;
				sheetObjects[9].CellValue(cnt+1,"bkg_teu_qty") = formObj.bkg_teu_qty[cnt].value;
				sheetObjects[9].CellValue(cnt+1,"bkg_feu_qty") = formObj.bkg_feu_qty[cnt].value;
				sheetObjects[9].CellValue(cnt+1,"inv_ref_no") = formObj.inv_ref_no[cnt].value;
				sheetObjects[9].CellValue(cnt+1,"hjs_stf_ctnt") = formObj.hjs_stf_ctnt[cnt].value;
				sheetObjects[9].CellValue(cnt+1,"inv_rmk") = formObj.inv_rmk[cnt].value;
				sheetObjects[9].CellValue(cnt+1,"io_bnd_cd") = sheetObjects[0].CellValue(1,"io_bnd_cd").substring(0,1);
				sheetObjects[9].CellValue(cnt+1,"sail_arr_dt") = sheetObjects[0].CellValue(1,"sail_arr_dt");
				sheetObjects[9].CellValue(cnt+1,"cust_cd") = formObj.act_cust_cnt_cd[cnt].value+formObj.act_cust_seq[cnt].value;
	
				for(i=0;i<sheetObjects.length;i++){
					if(sheetObjects[i].id=="t"+cnt+"sheet1"){
						var serNo = 0;
						var chgSeq = 0;
						var arIfChgSeq = 1;
						var prev_tjSrcNm = "";
						var prev_curr = "";
						var chgAmt = 0;
						for(c = 1; c<=sheetObjects[i].RowCount;c++){
							if(sheetObjects[i].CellValue(c,"chg_amt")!="0"&&sheetObjects[i].CellValue(c,"Seq")!=""){										
	
								chgSeq = chgSeq + 1;
	
								if(prev_curr!=sheetObjects[i].CellValue(c,"curr_cd")||prev_tjSrcNm!=sheetObjects[i].CellValue(c,"tj_src_nm")){
									serNo = serNo+1;
									arIfChgSeq = 1;											
	
								}else{
									serNo = serNo;
									arIfChgSeq = arIfChgSeq+1;
								}
	
								sheetObjects[i].CellValue(c,"new_ser_no") = serNo
								sheetObjects[i].CellValue(c,"new_chg_seq") = chgSeq
	
								prev_curr = sheetObjects[i].CellValue(c,"curr_cd");
								prev_tjSrcNm = sheetObjects[i].CellValue(c,"tj_src_nm");
	
								var nRow = sheetObjects[10].DataInsert(-1); 
	
								sheetObjects[10].CellValue(nRow,"ar_if_no") = sheetObjects[i].CellValue(c,"ar_if_no");
								sheetObjects[10].CellValue(nRow,"ar_if_ser_no") = sheetObjects[i].CellValue(c,"new_ser_no");
								sheetObjects[10].CellValue(nRow,"chg_seq") = sheetObjects[i].CellValue(c,"new_chg_seq");
								sheetObjects[10].CellValue(nRow,"chg_cd") = sheetObjects[i].CellValue(c,"chg_cd");
								sheetObjects[10].CellValue(nRow,"rat_as_cntr_qty") = sheetObjects[i].CellValue(c,"rat_as_cntr_qty");
								sheetObjects[10].CellValue(nRow,"trf_rt_amt") = sheetObjects[i].CellValue(c,"trf_rt_amt");
								sheetObjects[10].CellValue(nRow,"per_tp_cd") = sheetObjects[i].CellValue(c,"per_tp_cd");
								sheetObjects[10].CellValue(nRow,"curr_cd") = sheetObjects[i].CellValue(c,"curr_cd");
								sheetObjects[10].CellValue(nRow,"chg_amt") = sheetObjects[i].CellValue(c,"chg_amt");
								sheetObjects[10].CellValue(nRow,"inv_xch_rt") = sheetObjects[i].CellValue(c,"inv_xch_rt");
								sheetObjects[10].CellValue(nRow,"tj_src_nm") = sheetObjects[i].CellValue(c,"tj_src_nm");
								sheetObjects[10].CellValue(nRow,"inv_xch_rt_dt") = sheetObjects[i].CellValue(c,"inv_xch_rt_dt");
								sheetObjects[10].CellValue(nRow,"rep_chg_cd") = sheetObjects[i].CellValue(c,"rep_chg_cd");
								sheetObjects[10].CellValue(nRow,"chg_full_nm") = sheetObjects[i].CellValue(c,"chg_full_nm");
								sheetObjects[10].CellValue(nRow,"trf_no") = sheetObjects[i].CellValue(c,"trf_no");
								sheetObjects[10].CellValue(nRow,"sob_id") = sheetObjects[i].CellValue(c,"sob_id");
								sheetObjects[10].CellValue(nRow,"inv_rev_tp_src_cd") = sheetObjects[i].CellValue(c,"inv_rev_tp_src_cd");
								sheetObjects[10].CellValue(nRow,"rev_coa_co_cd") = sheetObjects[i].CellValue(c,"rev_coa_co_cd");
								sheetObjects[10].CellValue(nRow,"rev_coa_rgn_cd") = sheetObjects[i].CellValue(c,"rev_coa_rgn_cd");
								sheetObjects[10].CellValue(nRow,"rev_coa_ctr_cd") = sheetObjects[i].CellValue(c,"rev_coa_ctr_cd");
								sheetObjects[10].CellValue(nRow,"rev_coa_acct_cd") = sheetObjects[i].CellValue(c,"rev_coa_acct_cd");
								sheetObjects[10].CellValue(nRow,"rev_coa_inter_co_cd") = sheetObjects[i].CellValue(c,"rev_coa_inter_co_cd");
								sheetObjects[10].CellValue(nRow,"rev_coa_vsl_cd") = sheetObjects[i].CellValue(c,"rev_coa_vsl_cd");
								sheetObjects[10].CellValue(nRow,"rev_coa_voy_no") = sheetObjects[i].CellValue(c,"rev_coa_voy_no");
								sheetObjects[10].CellValue(nRow,"rev_coa_skd_dir_cd") = sheetObjects[i].CellValue(c,"rev_coa_skd_dir_cd");
								sheetObjects[10].CellValue(nRow,"rev_coa_dir_cd") = sheetObjects[i].CellValue(c,"rev_coa_dir_cd");
								sheetObjects[10].CellValue(nRow,"acct_cd") = sheetObjects[i].CellValue(c,"acct_cd");
								sheetObjects[10].CellValue(nRow,"tva_flg") = sheetObjects[i].CellValue(c,"tva_flg");
								sheetObjects[10].CellValue(nRow,"chg_rmk") = sheetObjects[i].CellValue(c,"chg_rmk");
								sheetObjects[10].CellValue(nRow,"mnl_flg") = sheetObjects[i].CellValue(c,"mnl_flg");
								sheetObjects[10].CellValue(nRow,"mf_div_cd") = sheetObjects[i].CellValue(c,"mf_div_cd");
								sheetObjects[10].CellValue(nRow,"ar_if_chg_seq") = arIfChgSeq;
							}
						}								
					}
				}
			}
		}
		var amt = 0.000;
		var T=Number('1e'+1);
		for(a = 1; a<=sheetObjects[10].RowCount;a++){
			var arIfNo = sheetObjects[10].CellValue(a,"ar_if_no");
			var arIfSerNo = sheetObjects[10].CellValue(a,"ar_if_ser_no");
			var nxtArIfNo = sheetObjects[10].CellValue(a+1,"ar_if_no");
			var nxtArIfSerNo = sheetObjects[10].CellValue(a+1,"ar_if_ser_no");
			var chgAmt = sheetObjects[10].CellValue(a,"chg_amt");					
	
			if(arIfNo == nxtArIfNo && arIfSerNo == nxtArIfSerNo){
				amt = amt + parseFloat(chgAmt);
			}
	
			if(arIfNo != nxtArIfNo || arIfSerNo != nxtArIfSerNo){
				var nRow = sheetObjects[11].DataInsert(-1); 							
				sheetObjects[11].CellValue(nRow,"ar_if_no") = sheetObjects[10].CellValue(a,"ar_if_no");
				sheetObjects[11].CellValue(nRow,"ar_if_ser_no") = sheetObjects[10].CellValue(a,"ar_if_ser_no");
				sheetObjects[11].CellValue(nRow,"tj_src_nm") = sheetObjects[10].CellValue(a,"tj_src_nm");
				sheetObjects[11].CellValue(nRow,"curr_cd") = sheetObjects[10].CellValue(a,"curr_cd");
				sheetObjects[11].CellValue(nRow,"inv_amt") = (amt + parseFloat(chgAmt))* T / T;
	
				amt = 0;
			}
		}
	
		if(validateForm(sheetObj,formObj,sAction)){					
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("FNS_INV_0033GS.do", FormQueryString(formObj)+ "&" + ComSetPrifix(sheetObjects[9].GetSaveString(true),"s0sheet1_")+ "&" + ComSetPrifix(sheetObjects[10].GetSaveString(true),"s0sheet2_")+ "&" + ComSetPrifix(sheetObjects[11].GetSaveString(true),"s0sheet3_")+ "&" + ComSetPrifix(sheetObjects[12].GetSaveString(true),"s0sheet4_")+ "&" + ComSetPrifix(sheetObjects[13].GetSaveString(true),"s0sheet5_") ,"");
	
			ar_ofc_cd = document.form.ofc_cd.value;
	
			if(ar_ofc_cd == "SZPSC" || ar_ofc_cd == "XMNSC" || ar_ofc_cd == "CANSO"){
				ComBtnDisable("btn_paper");
			}else{
				ComBtnEnable("btn_paper");						
			}
	
			ComBtnEnable("btn_go");
			ComBtnDisable("btn_retrive");
			ComBtnDisable("btn_save");
	
			formObj.inv_no.readOnly=true;
			formObj.split_cnt.readOnly=true;					
			formObj.inv_no.className = "input2";
			formObj.split_cnt.className = "input2";
			ComOpenWait(false);
		}
		break;
	
		case IBINSERT:      //입력
	
		formObj.bl_nos.value = "'"+ formObj.frm_bl_src_no.value + "'";
	
		var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		formObj.svr_id.value = arrStr2[7]; 			    
		formObj.ots_smry_cd.value = arrStr2[13]; 	
		formObj.inv_dup_flg.value = arrStr2[14]; 
		formObj.inv_mlt_bl_iss_flg.value = arrStr2[15]; 	   		    
	
		formObj.cust_cnt_cd.value = "";
		formObj.cust_seq.value = "";
	
		formObj.f_cmd.value = MULTI;
		var sXml = sheetObj.GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(formObj)); 	
		var arrXml = sXml.split("|$$|");
		var backEndJobKey = ComGetEtcData(arrXml[0], "BackEndJobKey")
	
		if(backEndJobKey.length > 0) {
			formObj.backendjob_key.value = backEndJobKey;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.RequestTimeOut = 10000;
			timer = setInterval(getBackEndJobStatus, 3000);
		}
		break;
	
		case IBSEARCH_ASYNC10: // Number of copy invoice 조회
		var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		formObj.ar_ofc_cd2.value = arrStr2[1];
		formObj.f_cmd.value = SEARCH;
		var sXml = sheetObj.GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(formObj));
		
		formObj.copy_cnt.value = ComGetEtcData(sXml,"copy_cnt");
	
		var sStr = ComGetEtcData(sXml,"inv_prn_dvc_nm");
		formObj.print_nm.value = sStr;
	
		break;
		}
	}
	
	
	
	
	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	
	}
	
	
	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
		case 1:
			with (tabObj) {
	
				var cnt  = 0 ;				
				var max_seq = document.form.max_seq.value;
				var split_cnt = document.form.split_cnt.value;
				var min_seq = max_seq-split_cnt+1;
				if(split_cnt!=''&&max_seq!=''){
					for(cnt = 0;cnt < split_cnt; cnt++){
						InsertTab( cnt , document.form.ofc.value.substring(0,3)=='FXT'?'LON'+ComLpad(min_seq, 8, "0"):document.form.ofc.value.substring(0,3)+ComLpad(min_seq, 8, "0") , -1 );
						min_seq = min_seq+1;						
					}
				}
	
				cancelIfSeq = max_seq-split_cnt
				document.form.cancel_if_no.value = document.form.ofc.value.substring(0,3)=='FXT'?'LON'+ ComLpad(cancelIfSeq, 8, "0"):document.form.ofc.value.substring(0,3)+ComLpad(cancelIfSeq, 8, "0");
	
			}
			break;
	
		}
	}
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem){	
		var objs = document.all.item("tabLayer");		
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
	
		var split_cnt  = document.form.split_cnt.value;
	
		if(split_cnt == 2 && nItem == 1){			
	
			for(i = 1; i<=sheetObjects[1].RowCount;i++){
	
				var mst_rat_as_cntr_qty = sheetObjects[1].CellValue(i,"rat_as_cntr_qty");
				var mst_trf_rt_amt = sheetObjects[1].CellValue(i,"trf_rt_amt");		
				var tab1_rat_as_cntr_qty = sheetObjects[4].CellValue(i,"rat_as_cntr_qty");
				var tab1_trf_rt_amt = sheetObjects[4].CellValue(i,"trf_rt_amt");
	
				if(mst_rat_as_cntr_qty == tab1_rat_as_cntr_qty && mst_trf_rt_amt == tab1_trf_rt_amt){
					sheetObjects[5].CellValue2(i,"trf_rt_amt") = mst_trf_rt_amt-tab1_trf_rt_amt;
					sheetObjects[5].CellValue2(i,"rat_as_cntr_qty") = mst_rat_as_cntr_qty;
				}
	
				if(mst_rat_as_cntr_qty != tab1_rat_as_cntr_qty){
					sheetObjects[5].CellValue2(i,"rat_as_cntr_qty") = mst_rat_as_cntr_qty-tab1_rat_as_cntr_qty;
					sheetObjects[5].CellValue2(i,"trf_rt_amt") = mst_trf_rt_amt;
				}
	
				if(mst_trf_rt_amt != tab1_trf_rt_amt){
					sheetObjects[5].CellValue2(i,"trf_rt_amt") = mst_trf_rt_amt-tab1_trf_rt_amt;
					sheetObjects[5].CellValue2(i,"rat_as_cntr_qty") = mst_rat_as_cntr_qty;					
				}
	
				if(sheetObjects[1].CellValue(i,"per_tp_cd")!='PC'){
					sheetObjects[5].CellValue2(i,"chg_amt") = sheetObjects[5].CellValue(i,"rat_as_cntr_qty")*sheetObjects[5].CellValue(i,"trf_rt_amt");
				}else{
					sheetObjects[5].CellValue2(i,"chg_amt") = sheetObjects[5].CellValue(i,"rat_as_cntr_qty")*sheetObjects[5].CellValue(i,"trf_rt_amt")/100;
				}				
			}
	
			reSum(sheetObjects[5]);
		}
	
		if(split_cnt == 3 && nItem == 2){
	
			for(i = 1; i<=sheetObjects[1].RowCount;i++){
	
				var mst_rat_as_cntr_qty = sheetObjects[1].CellValue(i,"rat_as_cntr_qty");
				var mst_trf_rt_amt = sheetObjects[1].CellValue(i,"trf_rt_amt");		
				var tab1_rat_as_cntr_qty = sheetObjects[4].CellValue(i,"rat_as_cntr_qty");
				var tab1_trf_rt_amt = sheetObjects[4].CellValue(i,"trf_rt_amt");
				var tab2_rat_as_cntr_qty = sheetObjects[5].CellValue(i,"rat_as_cntr_qty");
				var tab2_trf_rt_amt = sheetObjects[5].CellValue(i,"trf_rt_amt");
	
				if((mst_rat_as_cntr_qty == tab1_rat_as_cntr_qty && mst_trf_rt_amt == tab1_trf_rt_amt) ||
						(mst_rat_as_cntr_qty == tab2_rat_as_cntr_qty && mst_trf_rt_amt == tab2_trf_rt_amt)){
					sheetObjects[6].CellValue2(i,"trf_rt_amt") = mst_trf_rt_amt-tab1_trf_rt_amt;
					sheetObjects[6].CellValue2(i,"rat_as_cntr_qty") = mst_rat_as_cntr_qty;
				}				
	
				if(mst_rat_as_cntr_qty != tab1_rat_as_cntr_qty || mst_rat_as_cntr_qty != tab2_rat_as_cntr_qty){
					sheetObjects[6].CellValue2(i,"rat_as_cntr_qty") = mst_rat_as_cntr_qty - tab1_rat_as_cntr_qty - tab2_rat_as_cntr_qty;
					sheetObjects[6].CellValue2(i,"trf_rt_amt") = mst_trf_rt_amt;
				}
	
				if(mst_trf_rt_amt != tab1_trf_rt_amt || mst_trf_rt_amt != tab2_trf_rt_amt){
					sheetObjects[6].CellValue2(i,"trf_rt_amt") = mst_trf_rt_amt - tab1_trf_rt_amt - tab2_trf_rt_amt;
					sheetObjects[6].CellValue2(i,"rat_as_cntr_qty") = mst_rat_as_cntr_qty;
				}
	
				if(sheetObjects[1].CellValue(i,"per_tp_cd")!='PC'){
					sheetObjects[6].CellValue2(i,"chg_amt") = sheetObjects[6].CellValue(i,"rat_as_cntr_qty")*sheetObjects[6].CellValue(i,"trf_rt_amt");
				}else{
					sheetObjects[6].CellValue2(i,"chg_amt") = sheetObjects[6].CellValue(i,"rat_as_cntr_qty")*sheetObjects[6].CellValue(i,"trf_rt_amt")/100;
				}				
			}
	
			reSum(sheetObjects[6]);
		}
	
		if(split_cnt == 4 && nItem == 3){
	
			for(i = 1; i<=sheetObjects[1].RowCount;i++){
	
				var mst_rat_as_cntr_qty = sheetObjects[1].CellValue(i,"rat_as_cntr_qty");
				var mst_trf_rt_amt = sheetObjects[1].CellValue(i,"trf_rt_amt");		
				var tab1_rat_as_cntr_qty = sheetObjects[4].CellValue(i,"rat_as_cntr_qty");
				var tab1_trf_rt_amt = sheetObjects[4].CellValue(i,"trf_rt_amt");
				var tab2_rat_as_cntr_qty = sheetObjects[5].CellValue(i,"rat_as_cntr_qty");
				var tab2_trf_rt_amt = sheetObjects[5].CellValue(i,"trf_rt_amt");
				var tab3_rat_as_cntr_qty = sheetObjects[6].CellValue(i,"rat_as_cntr_qty");
				var tab3_trf_rt_amt = sheetObjects[6].CellValue(i,"trf_rt_amt");
	
				if((mst_rat_as_cntr_qty == tab1_rat_as_cntr_qty && mst_trf_rt_amt == tab1_trf_rt_amt) ||
						(mst_rat_as_cntr_qty == tab2_rat_as_cntr_qty && mst_trf_rt_amt == tab2_trf_rt_amt) ||
						(mst_rat_as_cntr_qty == tab3_rat_as_cntr_qty && mst_trf_rt_amt == tab3_trf_rt_amt)) {
					sheetObjects[7].CellValue2(i,"trf_rt_amt") = mst_trf_rt_amt-tab1_trf_rt_amt;
					sheetObjects[7].CellValue2(i,"rat_as_cntr_qty") = mst_rat_as_cntr_qty;
				}				
	
				if(mst_rat_as_cntr_qty != tab1_rat_as_cntr_qty || mst_rat_as_cntr_qty != tab2_rat_as_cntr_qty || mst_rat_as_cntr_qty != tab3_rat_as_cntr_qty){
					sheetObjects[7].CellValue2(i,"rat_as_cntr_qty") = mst_rat_as_cntr_qty - tab1_rat_as_cntr_qty - tab2_rat_as_cntr_qty - tab3_rat_as_cntr_qty;
					sheetObjects[7].CellValue2(i,"trf_rt_amt") = mst_trf_rt_amt;
				}
	
				if(mst_trf_rt_amt != tab1_trf_rt_amt || mst_trf_rt_amt != tab2_trf_rt_amt || mst_trf_rt_amt != tab3_trf_rt_amt){
					sheetObjects[7].CellValue2(i,"trf_rt_amt") = mst_trf_rt_amt - tab1_trf_rt_amt - tab2_trf_rt_amt - tab3_trf_rt_amt;
					sheetObjects[7].CellValue2(i,"rat_as_cntr_qty") = mst_rat_as_cntr_qty;
				}
	
				if(sheetObjects[1].CellValue(i,"per_tp_cd")!='PC'){
					sheetObjects[7].CellValue2(i,"chg_amt") = sheetObjects[7].CellValue(i,"rat_as_cntr_qty")*sheetObjects[7].CellValue(i,"trf_rt_amt");
				}else{
					sheetObjects[7].CellValue2(i,"chg_amt") = sheetObjects[7].CellValue(i,"rat_as_cntr_qty")*sheetObjects[7].CellValue(i,"trf_rt_amt")/100;
				}				
			}
	
			reSum(sheetObjects[7]);
		}
	
		if(split_cnt == 5 && nItem == 4){
	
			for(i = 1; i<=sheetObjects[1].RowCount;i++){
	
				var mst_rat_as_cntr_qty = sheetObjects[1].CellValue(i,"rat_as_cntr_qty");
				var mst_trf_rt_amt = sheetObjects[1].CellValue(i,"trf_rt_amt");		
				var tab1_rat_as_cntr_qty = sheetObjects[4].CellValue(i,"rat_as_cntr_qty");
				var tab1_trf_rt_amt = sheetObjects[4].CellValue(i,"trf_rt_amt");
				var tab2_rat_as_cntr_qty = sheetObjects[5].CellValue(i,"rat_as_cntr_qty");
				var tab2_trf_rt_amt = sheetObjects[5].CellValue(i,"trf_rt_amt");
				var tab3_rat_as_cntr_qty = sheetObjects[6].CellValue(i,"rat_as_cntr_qty");
				var tab3_trf_rt_amt = sheetObjects[6].CellValue(i,"trf_rt_amt");
				var tab4_rat_as_cntr_qty = sheetObjects[7].CellValue(i,"rat_as_cntr_qty");
				var tab4_trf_rt_amt = sheetObjects[7].CellValue(i,"trf_rt_amt");
	
				if((mst_rat_as_cntr_qty == tab1_rat_as_cntr_qty && mst_trf_rt_amt == tab1_trf_rt_amt) ||
						(mst_rat_as_cntr_qty == tab2_rat_as_cntr_qty && mst_trf_rt_amt == tab2_trf_rt_amt) ||
						(mst_rat_as_cntr_qty == tab3_rat_as_cntr_qty && mst_trf_rt_amt == tab3_trf_rt_amt) ||
						(mst_rat_as_cntr_qty == tab4_rat_as_cntr_qty && mst_trf_rt_amt == tab4_trf_rt_amt)) {
					sheetObjects[8].CellValue2(i,"trf_rt_amt") = mst_trf_rt_amt-tab1_trf_rt_amt;
					sheetObjects[8].CellValue2(i,"rat_as_cntr_qty") = mst_rat_as_cntr_qty;
				}				
	
				if(mst_rat_as_cntr_qty != tab1_rat_as_cntr_qty || 
						mst_rat_as_cntr_qty != tab2_rat_as_cntr_qty || 
						mst_rat_as_cntr_qty != tab3_rat_as_cntr_qty ||
						mst_rat_as_cntr_qty != tab4_rat_as_cntr_qty){
					sheetObjects[8].CellValue2(i,"rat_as_cntr_qty") = mst_rat_as_cntr_qty - tab1_rat_as_cntr_qty - tab2_rat_as_cntr_qty - tab3_rat_as_cntr_qty - tab4_rat_as_cntr_qty;
					sheetObjects[8].CellValue2(i,"trf_rt_amt") = mst_trf_rt_amt;
				}
	
				if(mst_trf_rt_amt != tab1_trf_rt_amt || 
						mst_trf_rt_amt != tab2_trf_rt_amt || 
						mst_trf_rt_amt != tab3_trf_rt_amt ||
						mst_trf_rt_amt != tab4_trf_rt_amt){
					sheetObjects[8].CellValue2(i,"trf_rt_amt") = mst_trf_rt_amt - tab1_trf_rt_amt - tab2_trf_rt_amt - tab3_trf_rt_amt - tab4_trf_rt_amt;
					sheetObjects[8].CellValue2(i,"rat_as_cntr_qty") = mst_rat_as_cntr_qty;
				}
	
				if(sheetObjects[1].CellValue(i,"per_tp_cd")!='PC'){
					sheetObjects[8].CellValue2(i,"chg_amt") = sheetObjects[8].CellValue(i,"rat_as_cntr_qty")*sheetObjects[8].CellValue(i,"trf_rt_amt");
				}else{
					sheetObjects[8].CellValue2(i,"chg_amt") = sheetObjects[8].CellValue(i,"rat_as_cntr_qty")*sheetObjects[8].CellValue(i,"trf_rt_amt")/100;
				}				
			}
	
			reSum(sheetObjects[8]);
		}
	
		// 이전탭의 Customer Code를 체크한다.	
		fn_act_cust_chg_tabClick();
		
		beforetab= nItem;	
	}
	
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 이전 Tab의 custCntCd 와 CustSeq가 널이 아니면 Cust체크를 한다
	 */
	function fn_act_cust_chg_tabClick(){
		form.cust_cnt_cd.value = "";
		form.cust_seq.value = "";
		fn_dueDate_chg();
		
		var custCntCd = form.act_cust_cnt_cd[beforetab].value;
		var custSeq = form.act_cust_seq[beforetab].value;
		
		
		if (custCntCd != "" && custSeq != "") {
			fn_cust_nm_tabClick();
		}
	}
	
	/**
	 * Tab 이벤트시 Customer체크
	 */
	function fn_cust_nm_tabClick(){
		
		var ret = false;
		
		//입력Validation 확인하기 + 마스크구분자 넣기
		var form = document.form;
		document.form.f_cmd.value = SEARCH03;
		var cust_nm = "";

		form.cust_cnt_cd.value = form.act_cust_cnt_cd[beforetab].value;
		form.cust_seq.value = form.act_cust_seq[beforetab].value;
		var queryParam = FormQueryString(document.form);
		
		var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", queryParam);
		cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
		delt_flg = ComGetEtcData(sXml,"delt_flg");
		
		form.cust_cnt_cd.value="";
		form.cust_seq.value="";
		
		if (delt_flg=='Y') {
			form.cust_lgl_eng_nm[beforetab].value="";
			form.act_cust_seq[beforetab].value="";
			ComShowCodeMessage("INV00060");
		} else if (cust_nm == undefined) {
			form.cust_lgl_eng_nm[beforetab].value="";
			form.act_cust_seq[beforetab].value="";
			ComShowCodeMessage("INV00008");			
		} else {
			// MDM_CUSTOMER에서 CUSTOMER체크를 한다.				
			form.cust_lgl_eng_nm[beforetab].value=cust_nm;    
			ret = true;
		}
		
		if (!ret) {
			
			form.act_cust_seq[beforetab].value="";
			form.cust_lgl_eng_nm[beforetab].value="";
			
			errIndex = beforetab;
			isCustCheckErr = true;
		} else {
			isCustCheckErr = false;
		}
	}
	
	/** 
	 * 체인지 이벤트가 끝나고 Cust체크에서 에러인 경우 원래의 탭으로 포커스를 이동한다
	 */
	function tab1_OnClick(tabObj , nItem){	
		 
		if (isCustCheckErr) {
			tabObjects[0].SelectedIndex = errIndex;
			form.act_cust_cnt_cd[tabObjects[0].SelectedIndex].focus();
		}
		
		isCustCheckErr = false;
	}
	
	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return true, false
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:        //조회				
	
			if( formObj.inv_no.value.trim() == "") {
				ComShowCodeMessage("INV00004");
				formObj.inv_no.focus();
				return;
			} 
	
			if( formObj.split_cnt.value.trim() == "") {
				ComShowCodeMessage("INV00079");
				formObj.split_cnt.focus();
				return;
			} 
	
			if( formObj.split_cnt.value<2||formObj.split_cnt.value>5) {
				ComShowCodeMessage("INV00079");
				formObj.split_cnt.focus();
				return;
			} 
	
			break;
	
			case IBSAVE:        //저장
			if(formObj.split_cnt.value != ""){
				for(cnt = 0;cnt < formObj.split_cnt.value; cnt++){						
					if( formObj.act_cust_cnt_cd[cnt].value.trim() == "" || formObj.act_cust_seq[cnt].value.trim() == "" ) {
						ComShowCodeMessage("INV00004");
						tabObjects[0].SelectedIndex=cnt;
						formObj.act_cust_cnt_cd[cnt].focus();
						return;
					}					
				}
				/* 2010-02-18 동일화주 체크안함 정영한
				if(sheetObjects[9].ColValueDup("cust_cd")>0){
					ComShowCodeMessage("INV00034");
					return;
				}
				*/
	
				for (i=0; i<document.form.split_curr_cd.length; i++) {						
					if(parseFloat(document.form.mst_chg_amt[i].value.replace("/\,/gi","")) != parseFloat(document.form.split_chg_amt[i].value.replace("/\,/gi",""))){
						ComShowCodeMessage("INV00035");
						return;
					}						
				}
	
				for(cnt = 0;cnt < document.form.split_cnt.value; cnt++){
					for(j=0;j<sheetObjects.length;j++){
						var amt = 0;
						
						if(sheetObjects[j].id=="t"+cnt+"sheet1"){
							sumrow = sheetObjects[j].FindSubSumRow("curr_cd");
							arrRow = sumrow.split("|");
							for (idx=0; idx<arrRow.length-1; idx++) {
								amt = amt + parseFloat(sheetObjects[j].CellValue(arrRow[idx], "chg_amt"));
							}	
							
							if(amt==0){
								ComShowCodeMessage("INV00033");
								return;
							}
						}							
					}
				}
				
				var T=Number('1e'+1);	
				
				for(a = 1; a<=sheetObjects[1].RowCount;a++){
					var aChgAmt = 0;						
					aChgCd = sheetObjects[1].CellValue(a,"chg_cd");
					aCurrPoint = sheetObjects[1].CellValue(a,"dp_prcs_knt");
					if(aChgCd!=""){
						for(b = 1; b<=sheetObjects[1].RowCount;b++){
							bChgCd = sheetObjects[1].CellValue(b,"chg_cd");
							if(aChgCd == bChgCd){
								aChgAmt = aChgAmt + parseFloat(sheetObjects[1].CellValue(b,"chg_amt"));
								aChgAmt = aChgAmt* T / T;
								posV = Math.pow(10, aCurrPoint)
								aChgAmt = Math.round(aChgAmt*posV)/posV;	
							}							
						}
	
						var cChgAmt = 0;							
						for (c = 1; c<=sheetObjects[10].RowCount;c++){
							cChgCd = sheetObjects[10].CellValue(c,"chg_cd");
							if(aChgCd == cChgCd){
								cChgAmt = cChgAmt + parseFloat(sheetObjects[10].CellValue(c,"chg_amt"));
								cChgAmt = cChgAmt* T / T;
								posV = Math.pow(10, aCurrPoint)
								cChgAmt = Math.round(cChgAmt*posV)/posV;	
							}							
						}
						if(aChgAmt!=cChgAmt){
							ComShowCodeMessage("INV00035");
							return;
						}
					}
				}
			}				
	
			break;
			}
		}     
	
		return true;
	}
	
	/**
	 * sheet2 retrieve 종료시 실행되는 function<br>
	 * 계좌별 sheet2의 subsum 행 값을 계산하여 total 금액 세팅
	 * <br><b>Example : </b>
	 * <pre>
	 *   sheet2_OnSearchEnd(sheetObjects[0],"");
	 * </pre>
	 * @param object sheetObj
	 * @param String ErrMsg
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		for(k=1;k<=sheetObj.RowCount;k++){
			currPoint = sheetObj.CellValue(k,"dp_prcs_knt");
	
			if (currPoint == '0') {
				sheetObj.InitCellProperty(k , "chg_amt", dtData , daRight , "chg_amt", "", dfInteger );
			}
			else {
				sheetObj.InitCellProperty(k , "chg_amt", dtData , daRight , "chg_amt", "", dfNullFloat, currPoint );
			}
		}	
	
		sheetObj.ShowSubSum("curr_cd", "7", 2, false, false, 0, "per_tp_cd=Total;curr_cd=%s;dp_prcs_knt=%s");
	
		var sumrow = sheetObj.FindSubSumRow("curr_cd");		
		var arrRow = sumrow.split("|");
		var mst_sum_con ="<table cellpadding=0 cellspacing=0 border=0> <input type=hidden name=mst_curr_point> <input type=hidden name=mst_curr_cd><input type=hidden name=mst_chg_amt value=0>";
		var split_sum_con ="<table cellpadding=0 cellspacing=0 border=0> <input type=hidden name=split_curr_point> <input type=hidden name=split_curr_cd><input type=hidden name=split_chg_amt value=0>";
		for (idx=0; idx<arrRow.length-1; idx++) {
	
			sVal = sheetObjects[1].CellValue(arrRow[idx], "chg_amt");
			currPoint = sheetObjects[1].CellValue(arrRow[idx], "dp_prcs_knt");	
			p = sVal.split("."); 
			p[0] = ComAddComma(p[0]);
			if      (p.length == 1&&currPoint>0) {
				sVal = p[0]+"."+ComRpad("", currPoint, "0");
			}else if (p.length == 2&&currPoint>0) {
				sVal = p[0]+"."+ComRpad(p[1], currPoint, "0");
			}else {
				sVal = p[0];
			}           
	
			mst_sum_con = mst_sum_con + "<tr><td>"+
			"<input type=hidden style='width:45;text-align:center;background-color:#ffffcc;' class='input2' name='mst_curr_point' value="+currPoint+">&nbsp;" +			
			"<input type=text style='width:45;text-align:center;background-color:#ffffcc;' class='input2' name='mst_curr_cd' readOnly value="+sheetObjects[1].CellValue(arrRow[idx], "curr_cd")+">&nbsp;" +
			"<input type=text style='width:80;text-align:right;background-color:#ffffcc;' class='input2' name='mst_chg_amt' readOnly dataformat='float' pointcount="+currPoint+" value="+sVal+">"+															  
			"</td></tr>";	
			split_sum_con = split_sum_con + "<tr><td>"+
			"<input type=hidden style='width:45;text-align:center;background-color:#ffffcc;' class='input2' name='split_curr_point' value="+currPoint+">&nbsp;" +			
			"<input type=text style='width:45;text-align:center;background-color:#ffffcc;' class='input2' name='split_curr_cd' readOnly value="+sheetObjects[1].CellValue(arrRow[idx], "curr_cd")+">&nbsp;" +
			"<input type=text style='width:80;text-align:right;background-color:#ffffcc;' class='input2' name='split_chg_amt' readOnly dataformat='float' pointcount="+currPoint+" value="+sVal+">"+															  
			"</td></tr>";	
			sheetObjects[1].RowHidden(arrRow[idx])=true;
		}
	
		document.getElementById ("mst_sum").innerHTML = mst_sum_con + "</table>"
		document.getElementById ("split_sum").innerHTML = split_sum_con + "</table>"
	
	}
	
	/**
	 * 탭별로 있는 charge 그리드의 subsum을 계산하여 해당탭 form의 split total 에 금액 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   reSum(sheetObjects[0]);
	 * </pre>
	 * @param object sheetObj
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function reSum(sheetObj){	
		sheetObj.HideSubSum();
		sheetObj.ShowSubSum("curr_cd", "7", 2, false, false, 0, "per_tp_cd=Total;curr_cd=%s");
	
		var max_seq = document.form.max_seq.value;
		var split_cnt = document.form.split_cnt.value;
		var sumrow = 0;	
		var T=Number('1e'+1);
		if(split_cnt!=''&&max_seq!=''){
			for (i=0; i<document.form.split_curr_cd.length; i++) {	
				var amt = 0.000;
				for(cnt = 0;cnt < split_cnt; cnt++){
					for(j=0;j<sheetObjects.length;j++){
						if(sheetObjects[j].id=="t"+cnt+"sheet1"){
							sumrow = sheetObjects[j].FindSubSumRow("curr_cd");
							arrRow = sumrow.split("|");
							for (idx=0; idx<arrRow.length-1; idx++) {
								if(document.form.split_curr_cd[i].value==sheetObjects[j].CellValue(arrRow[idx], "curr_cd")){
									amt = amt + parseFloat(sheetObjects[j].CellValue(arrRow[idx], "chg_amt"));
								}
							}
						}
					}
				}
				currPoint = document.form.split_curr_point[i].value;
	
				var sVal = (amt)* T / T;
				var posV = Math.pow(10, currPoint)
				sVal = Math.round(sVal*posV)/posV;	            
				sVal = sVal.toString();				
				p = sVal.split("."); 
				p[0] = ComAddComma(p[0]);
				if      (p.length == 1&&currPoint>0) {
					sVal = p[0]+"."+ComRpad("", currPoint, "0");
				}else if (p.length == 2&&currPoint>0) {
					sVal = p[0]+"."+ComRpad(p[1], currPoint, "0");
				}else {
					sVal = p[0];
				} 
	
				document.form.split_chg_amt[i].value = sVal;
			}
		}
	
	}
	
	/**
	 * 콤보박스 ar_ofc_cd 데이터 변경시 실행되는 function<br>
	 * 해당 office값 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   ar_ofc_cd_OnChange(document.form,'HAMSC','HAMSC');
	 * </pre>
	 * @param object comboObj
	 * @param string value
	 * @param string text
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function ar_ofc_cd_OnChange(comboObj,value,text){ 
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
	
		arrStr = value.split("^");
		document.form.ofc.value = arrStr[1];
		document.form.ofc_cd.value = arrStr[1];
	
		get_copy_cnt();
	}
	
	/**
	 * paper issue 관련 Number of copy invoice를 해당 office로 조회해서 값 세팅 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   get_copy_cnt();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function get_copy_cnt() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;		    
		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC10); 	    
	}
	
	/**
	 * 콤보 생성<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeComboObject2(formObj.ar_ofc_cd, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function MakeComboObject2(cmbObj, arrStr) {
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);			 
		}
	
		cmbObj.DropHeight = 190;
	}
	
	/**
	 * 팝업 (FNS_INV_0086) UI 처리 후 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    getFNS_INV_0086(rowArray, 1, 1);
	 * </pre>
	 * @param String rowArray
	 * @param number row
	 * @param number col
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function getFNS_INV_0086(rowArray, row, col) {    	 
		var colArray = rowArray[0];	
		document.form.act_cust_cnt_cd[tabObjects[0].SelectedIndex].value = colArray[8];
		document.form.act_cust_seq[tabObjects[0].SelectedIndex].value = ComLpad(colArray[9], 6, '0');
		fn_act_cust_chg();
	}
	
	/**
	 * 팝업 (FNS_INV_0098) UI 처리 후 실행되는 function<br>
	 * 선택된 탭의 container 그리드에서 조회하여 teu/feu 값을 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    getFNS_INV_0098();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function getFNS_INV_0098() {
		var cnt_teu = 0;
		var cnt_feu = 0;
		/*
	    	for(j=0;j<sheetObjects.length;j++){
				if(sheetObjects[j].id=="t"+[tabObjects[0].SelectedIndex]+"sheet2"){
					for (var i = 1; i <= sheetObjects[j].RowCount; i++){
	    				if (sheetObjects[j].CellValue(i, "cntr_tpsz_cd").substr(1,1) == "2") {
	    					cnt_teu++;
	    				} else {
	    					cnt_feu++;
	    				}        			
	        		}
		        }
			}
		 */
	
		for (var i = 1; i <= sheetObjects[12].RowCount; i++){
			if(sheetObjects[12].CellValue(i, "ar_if_no") == tabObjects[0].TabText([tabObjects[0].SelectedIndex])){
				if (sheetObjects[12].CellValue(i, "cntr_tpsz_cd").substr(1,1) == "2") {
					cnt_teu++;
				} else {
					cnt_feu++;
				}
			}
		}
	
		document.form.bkg_teu_qty[tabObjects[0].SelectedIndex].value = cnt_teu;
		document.form.bkg_feu_qty[tabObjects[0].SelectedIndex].value = cnt_feu;
	}
	
	/**
	 * act_cust_cnt_cd, act_cust_seq 변경시 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_act_cust_chg();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_act_cust_chg(){
		form.cust_cnt_cd.value = "";
		form.cust_seq.value = "";
		fn_dueDate_chg();
		fn_cust_nm(); 
	}
	
	/**
	 * 선택된 탭의 act_cust_cnt_cd, act_cust_seq 변경시 실행되는 function<br>
	 * fn_act_cust_chg() 에서 호출
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_dueDate_chg(){
		if(form.act_cust_seq[tabObjects[0].SelectedIndex].value!=''){
			form.act_cust_seq[tabObjects[0].SelectedIndex].value = ComLpad(form.act_cust_seq[tabObjects[0].SelectedIndex].value.trim(), 6, "0");
			/* 
	  			 if( form.act_cust_cnt_cd[tabObjects[0].SelectedIndex].value == form.frm_act_cust_cnt_cd.value&&form.act_cust_seq[tabObjects[0].SelectedIndex].value==form.frm_act_cust_seq.value){
	  				  ComShowCodeMessage("INV00031");
	  				  form.act_cust_cnt_cd[tabObjects[0].SelectedIndex].value="";
	  				  form.act_cust_seq[tabObjects[0].SelectedIndex].value="";
	  				  form.cust_lgl_eng_nm[tabObjects[0].SelectedIndex].value="";
	  				  form.act_cust_cnt_cd[tabObjects[0].SelectedIndex].focus();
	  				  return;
	  			  }
			 */
	
			form.cust_cnt_cd.value = form.act_cust_cnt_cd[tabObjects[0].SelectedIndex].value;
			form.cust_seq.value = form.act_cust_seq[tabObjects[0].SelectedIndex].value;
			form.ofc_cd.value = form.ofc.value;
	
		}  		 
	}
	
	/**
	 * 선택된 탭의 act_cust_cnt_cd, act_cust_seq 변경시 실행되는 function<br>
	 * fn_act_cust_chg() 에서 호출
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_cust_nm(){
		//입력Validation 확인하기 + 마스크구분자 넣기
		document.form.f_cmd.value = SEARCH03;
		var cust_nm = "";
		if ((form.cust_cnt_cd.value.trim() != "" )&&(form.cust_seq.value.trim() != "")&&(form.cust_seq.value.trim() != "000000")){
			var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
	
			delt_flg = ComGetEtcData(sXml,"delt_flg");
			if(delt_flg=='Y'){
				form.cust_lgl_eng_nm[tabObjects[0].SelectedIndex].value="";
				form.act_cust_seq[tabObjects[0].SelectedIndex].value="";
				form.cust_seq.value="";
				ComShowCodeMessage("INV00060");
				form.act_cust_cnt_cd[tabObjects[0].SelectedIndex].focus();
				return;
			}
			if (cust_nm == undefined) {
				form.cust_lgl_eng_nm[tabObjects[0].SelectedIndex].value="";
				form.act_cust_seq[tabObjects[0].SelectedIndex].value="";
				ComShowCodeMessage("INV00008");
				form.act_cust_cnt_cd[tabObjects[0].SelectedIndex].focus();
				return;   	    		  
			}else{
				if(sheetObjects[1].RowCount>0){
					//sheetObjects[1].CellValue(1,"act_cust_cnt_cd") = form.act_cust_cnt_cd.value;
					//sheetObjects[1].CellValue(1,"act_cust_seq") = form.act_cust_seq.value; 	     			  
				}  
	
				form.cust_lgl_eng_nm[tabObjects[0].SelectedIndex].value=cust_nm;    
			}
		}
	}
	
	/**
	 * Go to Send 클릭시 메일 팝업(FNS_INV_0034_02) 호출 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    open_email();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function openEmail() {
		var ar_ofc_cd = document.form.ar_ofc_cd2.value;
		if (ar_ofc_cd == "SZPSC" || ar_ofc_cd == "XMNSC" || ar_ofc_cd == "CANSO") {
			//         		ComOpenPopup('/hanjin/FNS_INV_0037.do?issueGubn=I', 1010, 610, '', '0,0'); 
			ComOpenWindowCenter("FNS_INV_0037.do?issueGubn=I", "pop", 1010, 750);
		} else {
			//         		ComOpenPopup('/hanjin/FNS_INV_0034_02.do?issueGubn=I', 1010, 610, '', '0,0');  
			ComOpenWindowCenter("FNS_INV_0034_02.do?issueGubn=I", "pop", 1010, 750);
		}
	}
	
	/**
	 * 선택된 탭의 cust_cnt_cd 자릿수 체크하여  cust_seq로 포커스 이동 시켜주는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    checkCustLeng();
	 * </pre>
	 * @param string value
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function checkCustLeng(value){    	  
		if(value.length==2){
			form.act_cust_seq[tabObjects[0].SelectedIndex].focus(); 
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
		} else if (ofc_cd == "WRPSC") {
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
			rdFile = "FNS_INV_0514.mrd";
		} else if (ofc_cd == "SYDSC") {
			rdFile = "FNS_INV_0515.mrd";
		} else if (ofc_cd == "SHASC" || ofc_cd == "SHARC") {
			rdFile = "FNS_INV_0516.mrd";
		} else if (ofc_cd == "HKGSC") {
			rdFile = "FNS_INV_0518.mrd";
		} else if (ofc_cd == "FXTSC" || ofc_cd == "LONBC1") {
			rdFile = "FNS_INV_0521.mrd";
		} else if (ofc_cd == "LEHSC") {
			rdFile = "FNS_INV_0522.mrd";
	//		} else if (ofc_cd == "SGNSC") {
	//		rdFile = "FNS_INV_0520.mrd";
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
				
	
		if (ofc_cd == "BOMSC" || ofc_cd == "SYDSC" || ofc_cd == "FXTSC" || ofc_cd == "LEHSC") {
			ofc_cd = document.form.login_ofc_cd.value;
		}
	
		rdParam = "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+user_nm+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num ["+line_num+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_paper_yn ["+paperYn+"] frm1_issue_type[] frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";
	
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";	
	
		// 열고자 하는 RD 파일을 지정한다.		
		Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
	
	}    
	
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
	 *
	 * @return 없음
	 * @see #doActionIBSheet
	 */
	function getBackEndJobStatus() {
		form.f_cmd.value = SEARCH02;
		var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(form));
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
	 * BackEndJob의 결과가 완료되면 결과를 조회한다.<br>
	 * 
	 * @return 없음
	 * @see #getBackEndJobLoadFile
	 */
	function getBackEndJobLoadFile() {
		form.f_cmd.value = SEARCH03;
		var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(form));
		//alert(sXml);
		var arrXml = sXml.split("|$$|");
		if(arrXml.length > 0) {
			//sheetObjects[0].LoadSearchXml(arrXml[0]);
			form.backendjob_key.value = "";
	
			var sStr = ComGetEtcData(sXml,"inv_nos");	
			//alert(sStr);
	
	//		if (sStr == "") {
	//		ComShowCodeMessage("INV00095");
	//		return;
	//		}	
	
			var sStr2 = sStr.split("&");
	
			var arrStr = sStr2[0].split("|");
	
			if (arrStr.length > 1) {
				form.f_inv.value = arrStr[0];	
				form.t_inv.value = arrStr[arrStr.length - 2];
				form.tot_inv_cnt.value = ComAddComma2(arrStr.length - 1, "#,###");
	
			} 
	
			var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	
			var r_invs = arrStr[0];  
	
			/*
					if (sStr2[1] != "") {
						ComShowCodeMessage("INV00096", sStr2[1]);
					} else if (r_invs == "") {
						ComShowCodeMessage("INV00097");
					}
			 */
	
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
				var v_copy_cnt = form.copy_cnt.value;  
	
	
				//alert(form.email_flag.value);
				if (form.email_flag.value == "N") {
					rdObjects[0].SetAppendReport(1);
					for(var i=0; i<arrStr3.length -1; i++){
						//alert(arrStr3[i]);
						rdOpen(rdObjects[0], arrStr3[i], 15, form.user_nm.value, form.ar_ofc_cd2.value, "ORIGINAL", "", "", "N", "Y");
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
					rdObjects[0].CMPrint (); //인쇄 시작
				} else {
					openEmail();
				}
	
			} 
	
		}
	}
	
	/**
	 * 선택된 탭의 charge 그리드(t0sheet1)의 금액 변경시 호출되는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   t0sheet1_OnChange(sheetObjects[0],1, 1,'1');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number Col
	 * @param string Value
	 * @see reSum(sheetObj);
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function t0sheet1_OnChange(sheetObj, Row, Col,Value){    	 
		if(sheetObj.ColSaveName(Col)=="rat_as_cntr_qty"||sheetObj.ColSaveName(Col)=="trf_rt_amt"){			
			if(sheetObj.CellValue(Row,"per_tp_cd")!='PC'){
				sheetObj.CellValue2(Row,"chg_amt") = sheetObj.CellValue(Row,"rat_as_cntr_qty")*sheetObj.CellValue(Row,"trf_rt_amt");
			}else{
				sheetObj.CellValue2(Row,"chg_amt") = sheetObj.CellValue(Row,"rat_as_cntr_qty")*sheetObj.CellValue(Row,"trf_rt_amt")/100;
			}
	
			reSum(sheetObj);
		}
	}
	/**
	 * 선택된 탭의 charge 그리드(t1sheet1)의 금액 변경시 호출되는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   t1sheet1_OnChange(sheetObjects[0],1, 1,'1');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number Col
	 * @param string Value
	 * @see reSum(sheetObj);
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function t1sheet1_OnChange(sheetObj, Row, Col,Value){
		if(sheetObj.ColSaveName(Col)=="rat_as_cntr_qty"||sheetObj.ColSaveName(Col)=="trf_rt_amt"){
			if(sheetObj.CellValue(Row,"per_tp_cd")!='PC'){
				sheetObj.CellValue2(Row,"chg_amt") = sheetObj.CellValue(Row,"rat_as_cntr_qty")*sheetObj.CellValue(Row,"trf_rt_amt");
			}else{
				sheetObj.CellValue2(Row,"chg_amt") = sheetObj.CellValue(Row,"rat_as_cntr_qty")*sheetObj.CellValue(Row,"trf_rt_amt")/100;
			}
			reSum(sheetObj);
		}
	}
	/**
	 * 선택된 탭의 charge 그리드(t2sheet1)의 금액 변경시 호출되는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   t2sheet1_OnChange(sheetObjects[0],1, 1,'1');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number Col
	 * @param string Value
	 * @see reSum(sheetObj);
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function t2sheet1_OnChange(sheetObj, Row, Col,Value){
		if(sheetObj.ColSaveName(Col)=="rat_as_cntr_qty"||sheetObj.ColSaveName(Col)=="trf_rt_amt"){			
			if(sheetObj.CellValue(Row,"per_tp_cd")!='PC'){
				sheetObj.CellValue2(Row,"chg_amt") = sheetObj.CellValue(Row,"rat_as_cntr_qty")*sheetObj.CellValue(Row,"trf_rt_amt");
			}else{
				sheetObj.CellValue2(Row,"chg_amt") = sheetObj.CellValue(Row,"rat_as_cntr_qty")*sheetObj.CellValue(Row,"trf_rt_amt")/100;
			}
			reSum(sheetObj);
		}
	}
	/**
	 * 선택된 탭의 charge 그리드(t3sheet1)의 금액 변경시 호출되는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   t3sheet1_OnChange(sheetObjects[0],1, 1,'1');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number Col
	 * @param string Value
	 * @see reSum(sheetObj);
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function t3sheet1_OnChange(sheetObj, Row, Col,Value){
		if(sheetObj.ColSaveName(Col)=="rat_as_cntr_qty"||sheetObj.ColSaveName(Col)=="trf_rt_amt"){			
			if(sheetObj.CellValue(Row,"per_tp_cd")!='PC'){
				sheetObj.CellValue2(Row,"chg_amt") = sheetObj.CellValue(Row,"rat_as_cntr_qty")*sheetObj.CellValue(Row,"trf_rt_amt");
			}else{
				sheetObj.CellValue2(Row,"chg_amt") = sheetObj.CellValue(Row,"rat_as_cntr_qty")*sheetObj.CellValue(Row,"trf_rt_amt")/100;
			}
			reSum(sheetObj);
		}
	}
	/**
	 * 선택된 탭의 charge 그리드(t4sheet1)의 금액 변경시 호출되는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   t4sheet1_OnChange(sheetObjects[0],1, 1,'1');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number Col
	 * @param string Value
	 * @see reSum(sheetObj);
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function t4sheet1_OnChange(sheetObj, Row, Col,Value){
		if(sheetObj.ColSaveName(Col)=="rat_as_cntr_qty"||sheetObj.ColSaveName(Col)=="trf_rt_amt"){			
			if(sheetObj.CellValue(Row,"per_tp_cd")!='PC'){
				sheetObj.CellValue2(Row,"chg_amt") = sheetObj.CellValue(Row,"rat_as_cntr_qty")*sheetObj.CellValue(Row,"trf_rt_amt");
			}else{
				sheetObj.CellValue2(Row,"chg_amt") = sheetObj.CellValue(Row,"rat_as_cntr_qty")*sheetObj.CellValue(Row,"trf_rt_amt")/100;
			}
			reSum(sheetObj);
		}
	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function obj_keypress(){
		switch(event.srcElement.dataformat){
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "ymd":
			//숫자+"-"입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "eng":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet();
			break;
		case "engdn":
			//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
			break;
		case "num":
			//숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber('num');
			break;
		case "uppernum":
			//영문대+숫자 
			ComKeyOnlyAlphabet('uppernum');
			break;
		default:
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
		}
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
		 document.form.email_flag.value = "Y";

		 doActionIBSheet(sheetObjects[0],document.form,IBINSERT);

		 var state = document.form.state.value;  
		 var r_invs = document.form.inv_nos.value;  
		 var arrStr2 = document.form.ar_ofc_cd.Code.split("^");
		 document.form.ar_ofc_cd2.value = arrStr2[1];	
	 }

	/* 개발자 작업  끝 */