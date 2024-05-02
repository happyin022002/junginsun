/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0017.js
*@FileTitle : Invoice Customer Correction by Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.12 최도순
* 1.0 Creation
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
	 * @class FNS_INV_0017: FNS_INV_0017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0017() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/	
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// CHM-201113244 
	var act_cust_cd="";
	
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
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH); 	
					break;
		
				case "btn_new":
					ComBtnEnable("btn_save");
		
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
		
					ComResetAll();
		
					formObject.act_cust_cnt_cd.readOnly = false;
					formObject.act_cust_seq.readOnly = false;
		
					document.all.act_cust_cnt_cd.style.color="#606060";
					document.all.act_cust_seq.style.color="#606060";
					document.all.act_cust_cnt_cd.style.fontWeight="normal";
					document.all.act_cust_seq.style.fontWeight="normal";
		
					doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC01); 		
					fn_act_cust_chg();	
					
					form.from_date.focus();
		
					break; 
		
				case "btn_save":
					doActionIBSheet(sheetObject1,document.form,IBSAVE);
		
					break; 
		
				case "btn_actcust":
					var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObject.act_cust_cnt_cd.value+'&cust_seq='+formObject.act_cust_seq.value+'&pop_yn=Y';
					var Row = 1;
					var Col = 1;
					ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
					break; 
				case "btn_custNm":
					param = '?pgmNo=FNS_INV_0086&cust_seq='+formObject.act_cust_seq.value+'&cust_cnt_cd='+formObject.act_cust_cnt_cd.value;
					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086_1', '1,0', false, false, Row, Col, 0);
					break; 
		
				case "btns_calendar1": //달력버튼
					var cal = new ComCalendar();
					cal.select(formObject.from_date, 'yyyy-MM-dd');
				break;
				
				case "btns_calendar2": //달력버튼
					var cal = new ComCalendar();
	             	cal.select(formObject.to_date, 'yyyy-MM-dd');
	            break;
		
				case "btn_next":
					
					if(sheetObject1.RowCount>0&&sheetObject1.SelectRow<sheetObject1.RowCount){
						sheetObject1.SelectCell(sheetObject1.SelectRow+1,1);
						if(sheetObject1.CellValue(sheetObject1.SelectRow,'chg_flg')=='Y'){
							document.all.act_cust_cnt_cd.style.color="red";
							document.all.act_cust_seq.style.color="red";
							document.all.act_cust_cnt_cd.style.fontWeight="bold";
							document.all.act_cust_seq.style.fontWeight="bold";
						}else{
							document.all.act_cust_cnt_cd.style.color="#606060";
							document.all.act_cust_seq.style.color="#606060";
							document.all.act_cust_cnt_cd.style.fontWeight="normal";
							document.all.act_cust_seq.style.fontWeight="normal";
						}
		
						if(sheetObject1.CellValue(sheetObject1.SelectRow,'save_flg')=='Y'){
							ComBtnDisable("btn_save");
							sheetObject2.Editable = false;
							formObject.act_cust_cnt_cd.readOnly = true;
							formObject.act_cust_seq.readOnly = true;
							document.all.btn_custNm.style.visibility = "hidden";
						}else{
							ComBtnEnable("btn_save");
							sheetObject2.Editable = true;
							formObject.act_cust_cnt_cd.readOnly = false;
							formObject.act_cust_seq.readOnly = false;
							document.all.btn_custNm.style.visibility = "visible";
						}
					}
					
					break;
		
				case "btn_back":
					
					if(sheetObject1.RowCount>0&&sheetObject1.SelectRow>1){
						sheetObject1.SelectCell(sheetObject1.SelectRow-1,1);
						if(sheetObject1.CellValue(sheetObject1.SelectRow,'chg_flg')=='Y'){
							document.all.act_cust_cnt_cd.style.color="red";
							document.all.act_cust_seq.style.color="red";
							document.all.act_cust_cnt_cd.style.fontWeight="bold";
							document.all.act_cust_seq.style.fontWeight="bold";
						}else{
							document.all.act_cust_cnt_cd.style.color="#606060";
							document.all.act_cust_seq.style.color="#606060";
							document.all.act_cust_cnt_cd.style.fontWeight="normal";
							document.all.act_cust_seq.style.fontWeight="normal";
						}
		
						if(sheetObject1.CellValue(sheetObject1.SelectRow,'save_flg')=='Y'){
							ComBtnDisable("btn_save");
							sheetObject2.Editable = false;
							formObject.act_cust_cnt_cd.readOnly = true;
							formObject.act_cust_seq.readOnly = true;
							document.all.btn_custNm.style.visibility = "hidden";
						}else{
							ComBtnEnable("btn_save");
							sheetObject2.Editable = true;
							formObject.act_cust_cnt_cd.readOnly = false;
							formObject.act_cust_seq.readOnly = false;
							document.all.btn_custNm.style.visibility = "visible";
						}
					}
					
					break;
		
				case "btn_back_1":
					
					if(sheetObject1.RowCount>0&&sheetObject1.SelectRow>1){
						sheetObject1.SelectCell(1,1);
						if(sheetObject1.CellValue(sheetObject1.SelectRow,'chg_flg')=='Y'){
							document.all.act_cust_cnt_cd.style.color="red";
							document.all.act_cust_seq.style.color="red";
							document.all.act_cust_cnt_cd.style.fontWeight="bold";
							document.all.act_cust_seq.style.fontWeight="bold";
						}else{
							document.all.act_cust_cnt_cd.style.color="#606060";
							document.all.act_cust_seq.style.color="#606060";
							document.all.act_cust_cnt_cd.style.fontWeight="normal";
							document.all.act_cust_seq.style.fontWeight="normal";
						}
		
						if(sheetObject1.CellValue(sheetObject1.SelectRow,'save_flg')=='Y'){
							ComBtnDisable("btn_save");
							sheetObject2.Editable = false;
							formObject.act_cust_cnt_cd.readOnly = true;
							formObject.act_cust_seq.readOnly = true;
							document.all.btn_custNm.style.visibility = "hidden";
						}else{
							ComBtnEnable("btn_save");
							sheetObject2.Editable = true;
							formObject.act_cust_cnt_cd.readOnly = false;
							formObject.act_cust_seq.readOnly = false;
							document.all.btn_custNm.style.visibility = "visible";
						}
					}
					
					break;
		
				case "btn_next_1":
					
					if(sheetObject1.RowCount>0&&sheetObject1.SelectRow<sheetObject1.RowCount){
						sheetObject1.SelectCell(sheetObject1.RowCount,1);
						if(sheetObject1.CellValue(sheetObject1.SelectRow,'chg_flg')=='Y'){
							document.all.act_cust_cnt_cd.style.color="red";
							document.all.act_cust_seq.style.color="red";
							document.all.act_cust_cnt_cd.style.fontWeight="bold";
							document.all.act_cust_seq.style.fontWeight="bold";
						}else{
							document.all.act_cust_cnt_cd.style.color="#606060";
							document.all.act_cust_seq.style.color="#606060";
							document.all.act_cust_cnt_cd.style.fontWeight="normal";
							document.all.act_cust_seq.style.fontWeight="normal";
						}
		
						if(sheetObject1.CellValue(sheetObject1.SelectRow,'save_flg')=='Y'){
							ComBtnDisable("btn_save");
							sheetObject2.Editable = false;
							formObject.act_cust_cnt_cd.readOnly = true;
							formObject.act_cust_seq.readOnly = true;
							document.all.btn_custNm.style.visibility = "hidden";
						}else{
							ComBtnEnable("btn_save");
							sheetObject2.Editable = true;
							formObject.act_cust_cnt_cd.readOnly = false;
							formObject.act_cust_seq.readOnly = false;
							document.all.btn_custNm.style.visibility = "visible";
						}
					}
					
					break;
				
				case "btns_port": //port 조회버튼
					var loc_cd_val = formObject.port_cd.value;
					var sys_code = "ENIS";
	            
					var loc_port_ind_val = "1";
	            
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";
					var classId = "COM_ENS_051";
					var param = '?loc_cd='+loc_cd_val+'&sysCode='+sys_code+'&classId='+classId;
	 			  
					ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 900, 450, 'getCOM_ENS_051_1', dispaly);
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
	
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	
		initControl();
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 		
		
		form.from_date.focus();
		
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
	
		switch(sheetNo) {
	
			case 1:      //sheet1 init
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
				InitColumnInfo(32, 0, 0, true);
		
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true,true, false, true, false,false)
		
				var HeadTitle = "|act_cust_cnt_cd|act_cust_seq|cust_lgl_eng_nm|vvd|svc_scp_cd|por_cd|pol_cd|pod_cd|del_cd|bl_src_no|ar_if_no|bkg_no|shpr_cust_cnt_cd|shpr_cust_seq|shpr_cust_nm|shpr_cust_addr|fwdr_cust_cnt_cd|fwdr_cust_seq|fwdr_cust_nm|fwdr_cust_addr|bl_inv_if_dt|cust_nm|inv_rmk|sail_arr_dt|io_bnd_cd|ofc_cd|gl_eff_dt|bl_inv_cfm_dt|chg_flg|save_flg|sail_dt";
		
		
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
		
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "act_cust_cnt_cd",true);
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "act_cust_seq",true);
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "cust_lgl_eng_nm");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "vvd");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "svc_scp_cd");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "por_cd");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "pol_cd");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "pod_cd");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "del_cd");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "bl_src_no");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "ar_if_no");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "bkg_no");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "shpr_cust_cnt_cd");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "shpr_cust_seq");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "shpr_cust_nm");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "shpr_cust_addr");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "fwdr_cust_cnt_cd");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "fwdr_cust_seq");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "fwdr_cust_nm");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "fwdr_cust_addr");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "bl_inv_if_dt");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "cust_nm");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "inv_rmk");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "sail_arr_dt");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "io_bnd_cd");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "ar_ofc_cd");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "gl_eff_dt");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "bl_inv_cfm_dt");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "chg_flg");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "save_flg");
				InitDataProperty(0, cnt++ , dtData,  80,    daCenter,  true,    "sail_dt");
				
				WaitImageVisible = false; 
			}
			break;
		
			case 2:      //container
			with (sheetObj) {
		
				// 높이 설정
				style.height = 220;
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
				InitHeadMode(true,true, true, true, false,false)
		
				var HeadTitle = "|Sel.|Cust. Code|Cust. Name|Address|Zip Code|Credit Office";                             
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
		
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtRadioCheck,  40,    daCenter,  true,    "sel");
				InitDataProperty(0, cnt++ , dtData,  		 80,    daCenter,  true,    "cust_cd",		  true,  "",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,  		 200,   daLeft,    true,    "cust_lgl_eng_nm",false, "",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,  		 400,   daLeft,    true,    "addr", 		  false, "",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,  		 80,    daCenter,  true,    "zip_cd",		  false, "",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,  		 80,    daCenter,  true,    "cr_clt_ofc_cd",  false, "",      dfNone,			0,		false,		false);
		
				WaitImageVisible = false; 
				EditableColorDiff = false;
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
			//alert(FormQueryString(formObj));
			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
			//alert(sXml);			
		
			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
			//alert(sStr);
			var arrStr = sStr.split("|");
		
			MakeComboObject2(formObj.ar_ofc_cd, arrStr);
		
			var arrStr2 = "";
			var ar_ofc_cd = "";
		
			for(i=1;i<arrStr.length;i++){
				arrStr2 = arrStr[i].split("^");
				if(arrStr2[1]==arrStr2[3]){
					ar_ofc_cd = arrStr2[1];
		
					formObj.ofc.value = ar_ofc_cd;
					form.ofc_cd.value = form.ofc.value;	
					formObj.act_cust_cnt_cd.value= arrStr2[10];
					formObj.act_cust_seq.value= arrStr2[11];
		
				}
			}
			formObj.ar_ofc_cd.text = ar_ofc_cd;	
			
			// 전역변수에 해당OFC의 대표 ActCustCd를 설정
			act_cust_cd = formObj.act_cust_cnt_cd.value + formObj.act_cust_seq.value;

			ComOpenWait(false);
			
			break;
		
			case IBSEARCH:      //조회
		
			if(validateForm(sheetObj,formObj,sAction)){
				
				ComOpenWait(true);
	            	
				formObj.old_act_cust_cnt_cd.value = formObj.act_cust_cnt_cd.value;
				formObj.old_act_cust_seq.value = formObj.act_cust_seq.value;
				
				document.all.act_cust_cnt_cd.style.color="#606060";
				document.all.act_cust_seq.style.color="#606060";
				document.all.act_cust_cnt_cd.style.fontWeight="normal";
				document.all.act_cust_seq.style.fontWeight="normal";
		
				formObj.f_cmd.value = SEARCH;
			
				var sXml = sheetObj.GetSearchXml("FNS_INV_0017GS.do" , FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
		
				if (sXml.indexOf("ERROR") < 1){
					if ( arrXml[0] != null){
						sheetObjects[0].LoadSearchXml(arrXml[0]);
						if(sheetObjects[0].RowCount==0){
							ComShowCodeMessage("COM130401");
							formObj.from_date.select();
							ComOpenWait(false);
						}
					}
				}
				
				ComOpenWait(false);
			}
		
			break;
		
			case IBSEARCH_ASYNC02:      //조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			if (formObj.frm_cust_nm.value!=""){
				sheetObj.DoSearch("FNS_INV_0017GS.do", FormQueryString(formObj));
			}else{
				sheetObjects[1].RemoveAll();
			}
			ComOpenWait(false);
		
			break;
		
			case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)){
		
				formObj.f_cmd.value = MULTI;
				
				for(i=1;i<=sheetObj.RowCount;i++){
					if(sheetObj.CellValue(i,"ibflag")=="U"){
						sheetObj.CellValue2(i,"save_flg")="Y";
					}
				}
				
				ComBtnDisable("btn_save");
				sheetObjects[1].Editable = false;
				formObj.act_cust_cnt_cd.readOnly = true;
				formObj.act_cust_seq.readOnly = true;
				document.all.btn_custNm.style.visibility = "hidden";
				
				//act_cust_cd값이 바뀌었는지 체크 
				var currArOfcCd =  formObj.act_cust_cnt_cd.value + formObj.act_cust_seq.value
				if (act_cust_cd != currArOfcCd) {
					formObj.changed_cust_cd.value = "custCdIsChanged";
				}
				
				sheetObjects[0].DoSave("FNS_INV_0017GS.do", FormQueryString(formObj)+ "&" + ComSetPrifix(sheetObjects[0].GetSaveString(),"sheet1_") ,"");				

			}	
			break;
	
		}
	}
	
	
	/**
	 * sheet1 cell 선택시 실행되는 function <br>
	 * 페이지 이동시 그리드 행이동 이동된 행의 값을 document.form 에 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   sheet1_OnSelectCell(sheetObjects[0],1, 1, 2, 1);
	 * </pre>
	 * @param object sheetObj
	 * @param number OldRow
	 * @param number OldCol
	 * @param number NewRow
	 * @param number NewCol
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
		sheetObjects[1].removeAll();
	
		IBS_CopyRowToForm(sheetObjects[0],document.form, NewRow,"frm_") ;
		form.cust_lgl_eng_nm.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cust_lgl_eng_nm");
	
		if(sheetObj.RowCount>0){
			form.act_cust_cnt_cd.value = form.frm_act_cust_cnt_cd.value;
			form.act_cust_seq.value = ComLpad(form.frm_act_cust_seq.value.trim(), 6, "0");
		}
	
		cntSheetStat(sheetObj);
	
		if(sheetObj.RowCount>0){
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC02); 	
		}
	}
	
	/**
	 * sheet2 데이터 변경시 실행되는 function<br>
	 * sheet2 체크박스 선택시 form에 act_cust_cnt_cd,act_cust_seq 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   sheet2_OnChange(sheetObjects[0],1, 1,'1');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number Col
	 * @param string Value
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function sheet2_OnChange(sheetObj,Row,Col,Value){
		if(sheetObj.ColSaveName(Col) == "sel"&&Value==1){
			document.form.act_cust_cnt_cd.value=sheetObj.CellValue(Row,"cust_cd").substring(0,2);
			document.form.act_cust_seq.value=sheetObj.CellValue(Row,"cust_cd").substring(2,8);
			document.all.act_cust_cnt_cd.style.color="red";
			document.all.act_cust_seq.style.color="red";
			fn_act_cust_chg();
			sheetObj.CellValue2(Row,"chg_flg") = "Y";
		}
	}
	
	/**
	 * 콤보박스 ar_ofc_cd 데이터 변경시 실행되는 function<br>
	 * 해당 office act_cust_cnt_cd,act_cust_seq 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   ar_ofc_cd_OnChange(document.form,'HAMBB','HAMBB');
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
	
		document.all.act_cust_cnt_cd.style.color="#606060";
		document.all.act_cust_seq.style.color="#606060";
		document.all.act_cust_cnt_cd.style.fontWeight="normal";
		document.all.act_cust_seq.style.fontWeight="normal";
	
		arrStr = value.split("^");
		document.form.act_cust_cnt_cd.value= arrStr[10];
		document.form.act_cust_seq.value= arrStr[11];
		document.form.ofc.value = arrStr[1];
		fn_act_cust_chg();		
	}
	
	/**
	 * form 현재 페이지 번호, 총 페이지 번호 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   cntSheetStat(sheetObjects[0]);
	 * </pre>
	 * @param object sheetObj
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function cntSheetStat(sheetObj){
		document.form.cur_cnt.value = sheetObj.SelectRow;
		document.form.all_cnt.value = sheetObj.RowCount;
	}
	
	/**
	 * form inv_rmk 변경시 실행되는 function<br>
	 * 그리드의 선택된 행에 remark 정보 세팅
	 * <br><b>Example : </b>
	 * <pre>
	 *   fn_inv_rmk_chg('비고');
	 * </pre>
	 * @param string val
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function fn_inv_rmk_chg(val){
		if(sheetObjects[0].SelectRow>0){
			sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"inv_rmk") = val;
		}
	}
	
	/**
	 * 팝업 (FNS_INV_0086) UI 처리 후 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    getFNS_INV_0086_1(rowArray, 1, 1);
	 * </pre>
	 * @param String rowArray
	 * @param number row
	 * @param number col
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function getFNS_INV_0086_1(rowArray, row, col) {    	 
		var colArray = rowArray[0];	
		document.form.act_cust_cnt_cd.value = colArray[8];
		document.form.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		fn_act_cust_chg();
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
	 * act_cust_cnt_cd, act_cust_seq 변경시 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_act_cust_chg();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_act_cust_chg(){
		//입력Validation 확인하기 + 마스크구분자 넣기
	
		if(form.act_cust_seq.value!=''){
			form.act_cust_seq.value = ComLpad(form.act_cust_seq.value.trim(), 6, "0");
		}
		form.cust_cnt_cd.value = form.act_cust_cnt_cd.value;
		form.cust_seq.value = form.act_cust_seq.value;
		form.ofc_cd.value = form.ofc.value;
	
		document.form.f_cmd.value = SEARCH03;
		var cust_nm = "";
		if ((form.cust_cnt_cd.value.trim() != "" )&&(form.cust_seq.value.trim() != "")&&(form.cust_seq.value.trim() != "000000")){
			var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
			if (cust_nm == undefined) {
				form.act_cust_cnt_cd.value ="";
				form.cust_lgl_eng_nm.value="";
				form.act_cust_seq.value="";
				ComShowCodeMessage("INV00008");
				form.act_cust_cnt_cd.focus();
				
				sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"act_cust_cnt_cd") = form.act_cust_cnt_cd.value;
				sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"act_cust_seq") = form.act_cust_seq.value;
				
				if(sheetObjects[0].SelectRow>0&&sheetObjects[0].RowCount>0){
					document.all.act_cust_cnt_cd.style.color="#606060";
					document.all.act_cust_seq.style.color="#606060";
					document.all.act_cust_cnt_cd.style.fontWeight="normal";
					document.all.act_cust_seq.style.fontWeight="normal";
				}
				
				return false;   	    		  
			} 
	
			delt_flg = ComGetEtcData(sXml,"delt_flg");
			if(delt_flg=='Y'){
				form.act_cust_cnt_cd.value ="";
				form.cust_lgl_eng_nm.value="";
				form.act_cust_seq.value="";
				form.cust_seq.value="";
				ComShowCodeMessage("INV00060");
				form.act_cust_cnt_cd.focus();
				
				sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"act_cust_cnt_cd") = form.act_cust_cnt_cd.value;
				sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"act_cust_seq") = form.act_cust_seq.value;
				
				if(sheetObjects[0].SelectRow>0&&sheetObjects[0].RowCount>0){
					document.all.act_cust_cnt_cd.style.color="#606060";
					document.all.act_cust_seq.style.color="#606060";
					document.all.act_cust_cnt_cd.style.fontWeight="normal";
					document.all.act_cust_seq.style.fontWeight="normal";
				}
				
				return false;
			}
		
			form.cust_lgl_eng_nm.value=cust_nm;
	
			if(sheetObjects[0].SelectRow>0&&sheetObjects[0].RowCount>0){
				sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"act_cust_cnt_cd") = form.act_cust_cnt_cd.value;
				sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"act_cust_seq") = form.act_cust_seq.value;
				sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cust_lgl_eng_nm") = cust_nm;
				document.all.act_cust_cnt_cd.style.color="red";
				document.all.act_cust_seq.style.color="red";
				document.all.act_cust_cnt_cd.style.fontWeight="bold";
				document.all.act_cust_seq.style.fontWeight="bold";
	
				sheetObjects[0].CellValue2(sheetObjects[0].SelectRow,"chg_flg") = "Y";
			}else{
				document.all.act_cust_cnt_cd.style.color="#606060";
				document.all.act_cust_seq.style.color="#606060";
				document.all.act_cust_cnt_cd.style.fontWeight="normal";
				document.all.act_cust_seq.style.fontWeight="normal";
			}
			
			
			if(sheetObjects[0].SelectRow>0&&sheetObjects[0].RowCount>0){
				if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"act_cust_cnt_cd")==form.old_act_cust_cnt_cd.value
						&&ComLpad(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"act_cust_seq"),6,"0")==ComLpad(form.old_act_cust_seq.value,6,"0")){
					
					sheetObjects[0].RowStatus(sheetObjects[0].SelectRow)="R";
					
					ComShowCodeMessage("INV00031");
					
					document.all.act_cust_cnt_cd.style.color="#606060";
					document.all.act_cust_seq.style.color="#606060";
					document.all.act_cust_cnt_cd.style.fontWeight="normal";
					document.all.act_cust_seq.style.fontWeight="normal";					
					
					form.act_cust_cnt_cd.focus();
					
				}
			}
	
		}
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
	
			if( form.from_date.value.trim() == "" || form.to_date.value.trim() == "" || form.ofc_cd.value.trim() == "" ) {
				ComShowCodeMessage("INV00004");
				form.from_date.focus();
				return;
			} 
			if( form.act_cust_cnt_cd.value.trim() == "" || form.act_cust_seq.value.trim() == "" ) {
				ComShowCodeMessage("INV00004");
				form.act_cust_cnt_cd.focus();
				return;
			} 
	
			break;
			case IBSAVE:        //저장
			
			for(i=1;i<=sheetObj.RowCount;i++){
				if(sheetObj.CellValue(i,"ibflag")=="U"){
					if(sheetObj.CellValue(i,"act_cust_cnt_cd")==form.old_act_cust_cnt_cd.value
							&&ComLpad(sheetObj.CellValue(i,"act_cust_seq"),6,"0")==ComLpad(form.old_act_cust_seq.value,6,"0")){
						ComShowCodeMessage("INV00031");
						sheetObj.RowStatus(i)="R";
						return;
					}
					
					if(sheetObj.CellValue(i,"act_cust_cnt_cd")==''||sheetObj.CellValue(i,"act_cust_seq")==''){
						ComShowCodeMessage("INV00004");
						return;
					}
				}
			}
			
			break;
			}
		}     
		return true;    
	}
	
	/**
	 * 팝업 FNS_INV_0013 에서 act_cust_cnt_cd,act_cust_seq 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   getPopData(rowArray);
	 * </pre>
	 * @param String rowArray
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function getPopData(rowArray){
		var colArray = rowArray[0];	
		document.form.act_cust_cnt_cd.value = colArray[1];
		document.form.act_cust_seq.value = colArray[2];
	}
	
	/**
	 * bl_inv_if_dt 변경시 날짜 유형 체크 후 masked value 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   fn_ComGetMaskedValue('2009-01-01');
	 * </pre>
	 * @param String value
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
//	function fn_ComGetMaskedValue(value) {
//	
//		var value = form.bl_inv_if_dt.value;
//	
//		value = ComReplaceStr(value,"-","");
//		if(value!=''){
//			if (value.length < 8) {
//				ComShowCodeMessage("INV00024");
//				return;
//			} 
//	
//			if (value.substring(4,6) > 12) {
//				ComShowCodeMessage("INV00024");
//				return;
//			} 
//			if (value.substring(4,6) == 00) {
//				ComShowCodeMessage("INV00024");
//				return;
//			} 
//	
//			var days = ComGetLastDay(value.substring(0,4), value.substring(4,6));
//			if (value.substring(6,8) > days) {
//				ComShowCodeMessage("INV00024");
//				return;
//			} 
//			if (value.substring(6,8) == 00) {
//				ComShowCodeMessage("INV00024");
//				return;
//			} 
//	
//			var ret = ComGetMaskedValue(value, "ymd")  ;     
//			form.bl_inv_if_dt.value = ret;
//		}
//	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
		axon_event.addListenerForm ('keyup', 'obj_keyup', form);
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
	 * 팝업창(COM_ENS_051_1)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function getCOM_ENS_051_1(rowArray) {
		var colArray = rowArray[0];
		document.all.port_cd.value = colArray[3];
	}
	
	
		/** 
	 * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 (포커스가 나갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "from_date":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "to_date":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
		}
	}
	
	/** 
	 * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 (포커스가 들어갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_activate() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "from_date":
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
			break;
			case "to_date":
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
			break;
		}
	}
	
	/** 
	 * HTML Control KeyUp 이벤트 호출<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "from_date":
				var fromDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fromDt.length == 8) {
					formObject.to_date.focus();
				}
	 		break;
		}
	}
	
	
    
	/* 개발자 작업  끝 */