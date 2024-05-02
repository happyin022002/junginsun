/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0404.js
*@FileTitle : Vessel Entry Status View
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
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
     * @class CPS_CNI_0404 : CPS_CNI_0404 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function CPS_CNI_0404() {
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
   	var prefix = "sheet_";
	var popupType;

	//IBMultiCombo
	var comboObjects = new Array();
	var comboCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];

		/*******************************************************/
		var formObject = document.form;
		try {
    		var srcName = window.event.srcElement.getAttribute("name");
					//alert(srcName);
            switch(srcName) {
                case "btn_Retrieve":
	             	if(!CoCniInitConfirm(sheetObject1)) return;
	             	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break; 

                case "btn_New":
	             	if(!CoCniInitConfirm(sheetObject1)) return;
					ComResetAll();
					eval("document.all.combo_insur_period").Code = "INS_IN";
                    break; 
                   
               	case "btn_Print":
					if (sheetObject1.RowCount <= 0 ) {
						ComShowCodeMessage("CNI00024");
						return;
					}
					
					var vParam = "/rp ";
					var insurPeriod = formObject.insur_period.value;
					if (insurPeriod == "INS_IN") {
						vParam = vParam + "[ AND	A.INSUR_EFF_DT BETWEEN '"+ComReplaceStr(form.insur_eff_dt.value.trim(),"-","")+"' AND '"+ComReplaceStr(form.insur_exp_dt.value.trim(),"-","")+"'] ";
					} else if (insurPeriod == "INS_IN") {
						vParam = vParam + "[ AND	A.INSUR_EXP_DT BETWEEN '"+ComReplaceStr(form.insur_eff_dt.value.trim(),"-","")+"' AND '"+ComReplaceStr(form.insur_exp_dt.value.trim(),"-","")+"'] ";
					} else if (insurPeriod == "INS_IN") {
						vParam = vParam + "[ AND	A.VSL_OSHP_EFF_DT BETWEEN '"+ComReplaceStr(form.insur_eff_dt.value.trim(),"-","")+"' AND '"+ComReplaceStr(form.insur_exp_dt.value.trim(),"-","")+"'] ";
					} else {
						vParam = vParam + "[ AND	A.VSL_OSHP_EXP_DT BETWEEN '"+ComReplaceStr(form.insur_eff_dt.value.trim(),"-","")+"' AND '"+ComReplaceStr(form.insur_exp_dt.value.trim(),"-","")+"'] ";
					}
					
					vParam = vParam + "[" + eval("document.all.combo_insur_period").Text + "] ";
					vParam = vParam + "[" + formObject.insur_eff_dt.value + "] ";
					vParam = vParam + "[" + formObject.insur_exp_dt.value + "] ";
					vParam = vParam + "[" + formObject.insur_cvrg_cd.value + "] ";
					vParam = vParam + "[" + formObject.insur_clm_pty_no.value + "] ";
					vParam = vParam + "[" + formObject.insur_clm_pty_nm.value + "] ";
					vParam = vParam + "[" + formObject.vsl_eng_nm.value + "] ";
					vParam = vParam + "[" + formObject.vsl_cd.value + "] ";
					vParam = vParam + "[" + formObject.insur_vsl_tp_cd.value + "] ";
					vParam = vParam + "[" + formObject.insur_vsl_oshp_cd.value + "] ";
					vParam = vParam + "[" + formObject.insur_tp_cd.value + "] ";

					ComSetObjValue(formObject.com_mrdPath,"apps/alps/cps/cni/insurance/vesselstatus/report/CPS_CNI_0405.mrd");
					ComSetObjValue(formObject.com_mrdArguments, vParam); 
					ComSetObjValue(formObject.com_mrdTitle,"Entry Status");
					
					ComOpenRDPopup('resizable=yes');
                    break; 

                case "cal_insur_eff_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.insur_eff_dt, 'yyyy-MM-dd');
                    break; 

                case "cal_insur_exp_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.insur_exp_dt, 'yyyy-MM-dd');
                    break; 
                    
               	case "pop_insur_clm_pty_nm":
               		popupType = srcName;
					popupMainCodeInquiry();
                    break; 

                case "btn_Row_Add":
	          		if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var row = sheetObject1.DataInsert(-1);
					sheetObject1.CellImage(row, prefix+"insur_rmk") = 0;
					break;

                case "btn_Row_Insert":
	          		if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var row = sheetObject1.DataInsert();
					sheetObject1.CellImage(row, prefix+"insur_rmk") = 0;
                    break; 

                case "btn_Row_Delete":
					if(ComCniCheckBoxCheckYn(sheetObject1, prefix+"DelChk")) { 
						ComRowHideDelete(sheetObject1, prefix+"DelChk"); 
					}
                    break;

				case "btn_DownExcel":
					var strColSkipList = prefix + "ibflag|" + prefix + "DelChk";
					sheetObject1.SpeedDown2Excel(0,false,false,'','',false,false,'',false, strColSkipList);
                    break; 
                break;

				case "btn_LoadExcel":
	          		if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					sheetObject1.LoadExcel(-1)
                    break; 
                break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("An unknown error occurred(in JavaScript source). Please verify your entry and try again. If the problem persists, please contact your system administrator.");
    		} else {
    			ComShowMessage(e);
    		}
    	}
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
	* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
	**/
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
            initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].ExtendLastCol = false;

        //html컨트롤 이벤트초기화
        initControl();

    }

    /**
     * Sheet의 Load가 끝났을때 발생되는 이벤트
     */
    function sheet1_OnLoadFinish(sheetObj) {
		sheetObj.WaitImageVisible = false;
		initMiscCode(sheetObj);   

		//Sheet의 콤보는 text가 아니라 code가 보이도록 처리
    	sheetObj.InitDataCombo(0, prefix+"insur_vsl_tp_cd", " |"+sheetObj.GetComboInfo(0,prefix+"insur_vsl_tp_cd", "Code"), " |"+sheetObj.GetComboInfo(0,prefix+"insur_vsl_tp_cd", "Code"));
    	sheetObj.InitDataCombo(0, prefix+"insur_vsl_clss_nm", " |"+sheetObj.GetComboInfo(0,prefix+"insur_vsl_clss_nm", "Code"), " |"+sheetObj.GetComboInfo(0,prefix+"insur_vsl_clss_nm", "Code"));
    	sheetObj.InitDataCombo(0, prefix+"insur_vsl_oshp_cd", " |"+sheetObj.GetComboInfo(0,prefix+"insur_vsl_oshp_cd", "Code"), " |"+sheetObj.GetComboInfo(0,prefix+"insur_vsl_oshp_cd", "Code"));
    	sheetObj.InitDataCombo(0, prefix+"insur_tp_cd", " |"+sheetObj.GetComboInfo(0,prefix+"insur_tp_cd", "Code"), " |"+sheetObj.GetComboInfo(0,prefix+"insur_tp_cd", "Code"));
    	sheetObj.InitDataCombo(0, prefix+"insur_cvrg_cd", sheetObj.GetComboInfo(0,prefix+"insur_cvrg_cd", "Code"), sheetObj.GetComboInfo(0,prefix+"insur_cvrg_cd", "Code"));

		sheetObj.WaitImageVisible = true; 
    } 

	/**
	* 콤보 Miscellaneous 코드값 가져오기
    * @param {ibsheet} sheetObj    IBSheet Object
	*/
    function initMiscCode(sheetObj) {
		sheetObj.WaitImageVisible = false;
      
		// IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k]);
		}
      
		//MISCELLANEOUS 코드 정보를 가져온다
		doActionIBSheet(sheetObj,document.form,IBROWSEARCH, "ComCd");

		eval("document.all.combo_insur_period").DeleteItem(""); 
		eval("document.all.combo_insur_period").Code = "INS_IN";
		eval("document.all.combo_insur_period").SetColWidth("70|200");


		sheetObj.WaitImageVisible = true; 
    } 

	/**
	* 콤보 초기설정값
	* @param {IBMultiCombo} comboObj  comboObj
	*/
	function initCombo(comboObj) {
		comboObj.MultiSelect = false;
		comboObj.UseCode = true;
		comboObj.LineColor = "#ffffff";
		comboObj.SetColAlign("left|left");
		comboObj.MultiSeparator = ",";
		comboObj.DropHeight = 190;
	}
	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('blur'	, 'obj_deactivate', form); 							//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form); 				//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerFormat('beforeactivate'	, 'obj_activate'  , form);
        
        axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListener  ('keypress', 'obj_keypress' , form);							//- form 전체 컨트롤 중 keypress 이벤트 발생시
        axon_event.addListener  ('change'  , 'party_change', 'insur_clm_pty_nm');				//- Party name 삭제시 party no 삭제

    }

 	//focus in
 	function obj_activate(){
 		obj = event.srcElement;
 		//readonly 일때 데이터 포맷 변경되는 것  방지
 		if (obj.getAttribute("readOnly")) return;
 		ComClearSeparator(obj);
 	} 

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){

        ComChkObjValid(event.srcElement);
    	
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

    	switch(event.srcElement.name){
	        case "vsl_cd":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "insur_clm_pty_nm":
	        	if (event.keyCode > 0) event.returnValue = false;;
	            break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * Party name 삭제시 party no 삭제. <br>
     **/
    function party_change() {
    	var obj = event.srcElement;
    	if (obj.value == "") {
			eval("form."+obj.name.substring(0,obj.name.length-1)+"o").value = '';
    	}
    }

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

		           // 높이 설정
					style.height = 400;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 15, 100);

					var HeadTitle1 = "|Seq.|Name of Vessel|Code|TOV|TOI|Coverage|Insurer|Insurer|INS In|INS Out|PY|Deductible|Deductible|Deductible|Deductible|Updater|Updated|Built|Flag|Flag|Class|GRT|DWT|TOO|TOO In|TOO Out|Remark(s)";
					var HeadTitle2 = "|Seq.|Name of Vessel|Code|TOV|TOI|Coverage|Insurer|Insurer|INS In|INS Out|PY|Cargo|Crew|DTH|Others|Updater|Updated|Built|Flag|Flag|Class|GRT|DWT|TOO|TOO In|TOO Out|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,    	50,    	daCenter,  	true,   prefix + "Seq");
					InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		true,	prefix + "vsl_eng_nm",			false,	"",				dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix + "vsl_cd",				false,	"",				dfNone,			0,			false,		true,	4);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix + "insur_vsl_tp_cd",		false,	"",				dfNone,			0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix + "insur_tp_cd",			false,  "",				dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	prefix + "insur_cvrg_cd",		false,   "",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	prefix + "insur_clm_pty_no",	false,	"",				dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,	prefix + "insur_clm_pty_nm",	false,	"",				dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,	prefix + "insur_eff_dt",		false,	"",				dfDateYmd,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,	prefix + "insur_exp_dt",		false,	"",				dfDateYmd,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix + "insur_plcy_yr",		false,  "",				dfNone,			0,			true,		true,	4, true);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	prefix + "ddct_cgo_amt",		false,	"",				dfNullFloat,	2,			true,		true,	18);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	prefix + "ddct_crw_amt",		false,	"",				dfNullFloat,	2,			true,		true,	18);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	prefix + "ddct_dmg_hl_amt",		false,  "",				dfNullFloat,	2,			true,		true,	18);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	prefix + "ddct_otr_amt",		false,  "",				dfNullFloat,	2,			true,		true,	18);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix + "upd_usr_id",			false,	"",				dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix + "upd_dt",				false,	"",				dfDateYmd,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix + "vsl_bld_yr",			false,	"",				dfNone,			0,			true,		true,	4, true);
					InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,	prefix + "vsl_rgst_cnt_cd",		false,	"",				dfNone,			0,			true,		true,	2);
					InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,	prefix + "cnt_nm",				false,	"",				dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix + "insur_vsl_clss_nm",	false,	"",				dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix + "grs_rgst_tong_wgt",	false,	"",				dfNullFloat,	3,			true,		true,	9);
					
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	prefix + "dwt_wgt",				false,	"",				dfNullFloat,	3,			true,		true,	9);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix + "insur_vsl_oshp_cd",	false,	"",				dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix + "vsl_oshp_eff_dt",		false,	"",				dfDateYmd,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix + "vsl_oshp_exp_dt",		false,	"",				dfDateYmd,		0,			true,		true);

					InitDataProperty(0, cnt++ , dtData,			350,	daLeft,		true,	prefix + "insur_rmk",			false,	"",				dfNone,			0,			false,		false);

					AutoRowHeight = false;//메모장을 이용해 줄바뀜이 되어 내용이 길어져도 Row의 높이가 늘어나지 않게 함.
		          }
		          break;

        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {

        switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				formObj.f_cmd.value = SEARCH;
	        	
	        	var aryPrefix = new Array("sheet_");
	
	   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0403GS.do" , FormQueryString(formObj) +"&" + ComGetPrefixParam(aryPrefix));
	   			sheetObj.LoadSearchXml(sXml);

			break;

			case IBROWSEARCH: 

				if (Col == "ComCd") {//코드 조회
					
					CoCniGetCombo(formObj, sheetObj, "MULTI:MULTI:MULTI:MULTI:MULTI", "29:27:31:33:34",
					"insur_period:"+"insur_tp_cd:"+"insur_cvrg_cd:"+"insur_vsl_tp_cd:"+"insur_vsl_oshp_cd:", 
					"insur_periodText:"+"insur_tp_cdText:"+"insur_cvrg_cdText:"+"insur_vsl_tp_cdText:"+"insur_vsl_oshp_cdText:");

				}
					
					
			break;
        }
    }

    /**
     * Party popup에서 선택시 Party Name을 세팅한다.
     */
    function setMainCodeInquiry(partyVo) {

        switch(popupType) {
            case "pop_insur_clm_pty_nm":
				form.insur_clm_pty_no.value = partyVo.clm_pty_no;
				form.insur_clm_pty_nm.value = partyVo.clm_pty_abbr_nm;    
                break;

        }
    }
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

        with(formObj){

			if (!ComChkValid(formObj)) return false;

            if (sAction == IBSEARCH) {
            	var fromDt = ComReplaceStr(form.insur_eff_dt.value.trim(),"-","");
            	var toDt = ComReplaceStr(form.insur_exp_dt.value.trim(),"-","");

   				if (fromDt != "" && toDt != "" && fromDt > toDt) {
					ComAlertFocus(form.to_dt, ComGetMsg("CNI09058"));
					return;
   				}
			}
        
        }

        return true;
    }

	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_period_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_period.value = index_cd;
	}

	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_tp_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_tp_cd.value = index_cd;
	}

	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_cvrg_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_cvrg_cd.value = index_cd;
	}

	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_vsl_tp_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_vsl_tp_cd.value = index_cd;
	}

	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_insur_vsl_oshp_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.insur_vsl_oshp_cd.value = index_cd;
	}
	
    /**
     * IBSheet XML에서 XML 문자열을 파싱하여 그 안의 파라미터 항목 값을 리턴한다 <br>
     * @param {string} xmlStr    IBSheet를 통해 받아온 xml 문자열
     * @param {string} dataNode  파싱할 항목
     * @return {string} xmlValue
     **/
  	function GetXMLData(xmlStr, dataNode) {
  		
  		var xmlData = '';

        try {
            /* XML Parsing */
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.async = "false";
            xmlDoc.loadXML(xmlStr);
			/* get message */
            xmlData = xmlDoc.documentElement.getElementsByTagName(dataNode).item(0).text
        } catch(err) {
            xmlData = '';
        }
        
		return xmlData;
  	}
    
	/* 개발자 작업  끝 */