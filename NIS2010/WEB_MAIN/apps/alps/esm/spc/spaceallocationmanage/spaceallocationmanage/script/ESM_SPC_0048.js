/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SPC_0048.js
*@FileTitle : WAF Allocation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.07.26 이행지
* 1.0 Creation
=========================================================
* History
* 2011.08.11 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - WAF 노선에 대한 Allocation 팝업 추가
=========================================================
*/
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
     * @class ESM_SPC_0048 : ESM_SPC_0048 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0048() {
    	this.processButtonClick		= processButtonClick;
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
	
	var parentForm = dialogArguments.document.form;
	var formObj = document.form;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	function processButtonClick(){
		var sheetObj = sheetObjects[0];
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
					break;
				case "btn_save":
					doActionIBSheet(sheetObj, document.form, IBSAVE);
					break;
				case "btn_close":
					close();
					break;
				case "btng_rowadd":
					doActionIBSheet(sheetObj, document.form, IBINSERT);
					break;
				case "btng_rowdel":
					doActionIBSheet(sheetObj, document.form, IBDELETE);
					break;
			}
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/**
	 * 설  명 :  Sheet 기본 설정 및 초기화 <br>
	 *          body 태그의 onLoad 이벤트핸들러 구현<br>
	 *          화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		// Control by HO 에서 적용되어 있는 체크박스를 그대로 적용시켜준다.
		document.form.chkHC.checked  = parentForm.chkHC.checked;
		document.form.chk45.checked  = parentForm.chk45.checked;
		document.form.chk53.checked  = parentForm.chk53.checked;
		document.form.chkRFR.checked = parentForm.chkRFR.checked;
		document.form.chkWGT.checked = parentForm.chkWGT.checked;

		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		column_hidden();
		
	}
	
	/**
	 * 설  명 : IBSheet Object를 배열로 등록 <br>
	 *         향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
	 *         배열은 소스 상단에 정의<br>
	 * <b>Example : </b>
	 * <pre>
	 *    setComboObject(sheet_obj)
	 *    </pre>
	 * @param {object}	sheet_obj - Sheet Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * 설  명 :  시트 초기설정값, 헤더 정의 <br>
	 *          시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     initSheet(sheetObj, sheetNo)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {Number}	sheetNo  - Sheet Number (시트오브젝트 태그의 아이디에 붙인 일련번호)
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:      //IBSheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(14) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					//MergeSheet = msPrevColumnMerge;
					MergeSheet = msHeaderOnly;
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					HeadRowHeight  = 10;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 9, 100);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
					
					// var HeadTitle = "Co.|POR ECC|POL ECC|AVG|D2|D4|D5|D7|R2|R5|O2|O4|F2|F4" ;
					//   var HeadTitle = "Co.|POR ECC|POL ECC|AVG|" + title ; 
					var HeadTitle0 = "STS|Sel.|RHQ|IOC|Alloc.|Alloc.|Alloc by Type/Size|Alloc by Type/Size|Alloc by Type/Size|Alloc by Type/Size|Rlane|Dir|VSL|SkdVoyNo|SkdDirCd|POL|POD|TS|MNL|TRD|SubTrd|RepTrd|RepSubTrd" ;
					var HeadTitle1 = "STS|Sel.|RHQ|IOC|TEU|WGT|HC|45'|53'|RF|Rlane|Dir|VSL|SkdVoyNo|SkdDirCd|POL|POD|TS|MNL|TRD|SubTrd|RepTrd|RepSubTrd" ;
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle0), 0, 0, true);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, false);
					
					//데이터속성            [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					//					InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,    "",     	     false,        "",       dfNone,   	 0,     true,        true);
					InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,    "ibflag",           false,        "",       dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtCheckBox,      30,    daCenter,  true,     "del_chk",          false,        "",       dfNone,	 0,     true,       true);
					InitDataProperty(0, cnt++ , dtCombo,         70,    daCenter,  true,     "sls_ofc_cd",       false,        "",       dfNone,   	 0,     false,      true);
					InitDataProperty(0, cnt++ , dtCombo,         70,    daCenter,  true,     "ioc_cd",           false,        "",       dfNone,     0,     false,      true);
					InitDataProperty(0, cnt++ , dtAutoSum,       60,    daCenter,  false,    "asgn_ttl_qty",     false,        "",       dfNone,     0,     true,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,       60,    daCenter,  false,    "asgn_ttl_wgt",     false,        "",       dfNone,     0,     true,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,       60,    daCenter,  false,    "asgn_40ft_hc_qty", false,        "",       dfNone,     0,     true,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,       60,    daCenter,  false,    "asgn_45ft_hc_qty", false,        "",       dfNone,     0,     true,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,       60,    daCenter,  false,    "asgn_53ft_qty",    false,        "",       dfNone,     0,     true,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,       60,    daCenter,  false,    "asgn_rf_qty",      false,        "",       dfNone,     0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "rlane_cd",      false,        "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "dir_cd",        false,        "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "vsl_cd",        false,        "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "skd_voy_no",    false,        "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "skd_dir_cd",    false,        "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "pol_cd",        false,        "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "pod_cd",        false,        "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "ts_flg",        false,        "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "mnl_flg",       false,        "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "trd_cd",        false,        "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "sub_trd_cd",    false,        "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "rep_trd_cd",    false,        "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  false,    "rep_sub_trd_cd",false,        "",       dfNone,     0,     false,       false);
					
					InitDataCombo(0, 2, "|HAMRU|NYCRA", "|HAMRU|NYCRA");
					InitDataCombo(0, 3, "|OCN|IPC|T/S", "|O|I|T");

				}
				break;
		 }
	}
	/**
	 * 설  명 : Sheet관련 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     doActionIBSheet(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - 프로세스 종류 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;	
		
		switch(sAction) {
			case IBSEARCH:		// Loading시 조회
				if(!validateForm(sheetObj,formObj,sAction)){
					return false;
				} else {
					formObj.f_cmd.value = SEARCHLIST;
					var param = SpcFormString(formObj,"f_cmd,year,week,vvd,trade,subtrade,lane,bound,office,vsl_cd,skd_voy_no,skd_dir_cd");
					sheetObj.DoSearch4Post("ESM_SPC_0048GS.do", param);
				}
				
				break;
			
			case IBSAVE:		// Save Button
				formObj.f_cmd.value = MULTI01;
				var result = sheetObj.DoAllSave("ESM_SPC_0048GS.do" ,SpcFormString(formObj,"f_cmd"));
				break;
			case IBINSERT:     // Row Add
				var insRow = sheetObj.DataInsert(-1);

				sheetObj.CellValue(insRow, "ioc_cd")     = "I";
				sheetObj.CellValue(insRow, "rlane_cd")   = formObj.lane.value;
				sheetObj.CellValue(insRow, "dir_cd")     = formObj.bound.value;
				sheetObj.CellValue(insRow, "vsl_cd")     = formObj.vsl_cd.value;
				sheetObj.CellValue(insRow, "skd_voy_no") = formObj.skd_voy_no.value;
				sheetObj.CellValue(insRow, "skd_dir_cd") = formObj.skd_dir_cd.value;
				sheetObj.CellValue(insRow, "pol_cd")     = "XXXXXXX";
				sheetObj.CellValue(insRow, "pod_cd")     = "XXXXXXX";
				sheetObj.CellValue(insRow, "ts_flg")     = "N";
				sheetObj.CellValue(insRow, "mnl_flg")    = "N";
				sheetObj.CellValue(insRow, "trd_cd")     = formObj.trade.value;
				sheetObj.CellValue(insRow, "sub_trd_cd") = formObj.subtrade.value;
				
				// AutoSum Text 설정
				sheetObj.SumText(0,1) = "";
			    sheetObj.SumText(0,"ioc_cd") = "TTL";
			    break;
			case IBDELETE:     // Row Delete
				ComRowHideDelete(sheetObj, "del_chk");
				break;
		}

		return true;
	}
	/**
	 * 설  명 : 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     validateForm(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - 프로세스 종류 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function validateForm(sheetObj, formObj, sAction){
		switch(sAction){
			case IBSEARCH:
				break;
		}
		return true;
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		sheetObj.SumText(0,0) = "";
	    sheetObj.SumText(0,"rhq_cd") = "TTL";
	    column_hidden();  
	}
	/**
	 * 설  명 : 저장 함수를 이용하여 저장이 완료되고 발생하는 이벤트 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnSaveEnd(sheetObj, errMsg)
	 * </pre>
	 * @param {object}	sheetObj - sheet
	 * @param {String}	errMsg  - 저장 후 메시지
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
			close();
			dialogArguments.sheet1_OnDblClick(dialogArguments.sheetObjects[0],dialogArguments.sheet1_selRow, "");
		}
	}
	
	/**
	 */
	function column_hidden(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var chCOItemHC    = formObj.chkHC.checked;
		var chCOItem45    = formObj.chk45.checked;
		var chCOItem53    = formObj.chk53.checked;
		var chCOItemRFR   = formObj.chkRFR.checked;
		var chCOItemWGT   = formObj.chkWGT.checked;
		
		sheetObj.ColHidden("asgn_40ft_hc_qty") = !chCOItemHC;
		sheetObj.ColHidden("asgn_45ft_hc_qty") = !chCOItem45;
		sheetObj.ColHidden("asgn_53ft_qty")    = !chCOItem53;
		sheetObj.ColHidden("asgn_rf_qty")      = !chCOItemRFR;
		sheetObj.ColHidden("asgn_ttl_wgt")     = !chCOItemWGT;
		
	}
	/* 개발자 작업  끝 */
