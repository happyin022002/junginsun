/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0008.js
*@FileTitle : Route Cost (PA/RA)
*Open Issues :
*Change history :2007-06-07=EMS_MAS_008 관련 메소드:prd과 프로그램 공유를 위해 sheet1, 2, 3삭제하고 4를 1로 대체
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2006-12-04 IM OKYOUNG
* 1.0 최초 생성
=========================================================
* History
* 2009.08.05 박수훈 New Framework 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.05.13 김민아 [CHM-201110694-01] MAS Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
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
     * @class ESM_MAS_0008 : ESM_MAS_0008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0008() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.setSheetObject 		= setSheetObject;
    	this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.changeConditionType 	= changeConditionType;
    	this.openLocationCode 		= openLocationCode;
    	this.getF_from  			= getF_from;
    	this.getF_to    			= getF_to;
    	this.hideActGrpCombo 		= hideActGrpCombo;
    	this.showActGrpCombo 		= showActGrpCombo;
    }
    

 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    var loadingMode = false;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		var sheetObject = sheetObjects[0];

    		/*******************************************************/
    		var formObject = document.form;


    		try {
    			var srcName = window.event.srcElement.getAttribute("name");
    			switch(srcName) {

    				case "btn_Downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;

    				case "btn_Retrieve":
    					if(formObject.conditionType[1].checked) {//from-to
    						doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					} else {//por-del product화면으로 이동

    					}
    					break;


    				case "bu_zoom_in":
    					if(sheetObject.RowCount>25+2){
    						sheetObject.style.height = sheetObject.GetSheetHeight(sheetObject.RowCount + 2);
    						div_zoom_out.style.display = "inline";
    						div_zoom_in.style.display = "none";
    						parent.syncHeight();
    					}
    					break;

    				case "bu_zoom_out":
    					if(sheetObject.RowCount>25+2){
    						sheetObject.style.height = sheetObject.GetSheetHeight(25+2);
    						div_zoom_in.style.display = "inline";
    						div_zoom_out.style.display = "none";
    						parent.syncHeight();
    					}
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
    	* Sheet 기본 설정 및 초기화
    	* body 태그의 onLoad 이벤트핸들러 구현
    	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	*/
    	function loadPage() {
    		for(i=0;i<sheetObjects.length;i++){
    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet (sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		loadingMode = true;
            doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
            // 멀티콤보 처리
            //---------------------------------------------
            for(k=0;k<comboObjects.length;k++){
                initCombo(comboObjects[k],comboObjects[k].id);
            }
            loadingMode = false;
            
    		//임시
    		ComSetFocus(document.form.f_por);
    		changeConditionType('1');
    		//현재날짜 세팅
    		document.form.f_cost_yrmon.value = ComGetNowInfo("ym");
    	}
    	/**
         * 멀티콤보 항목을 설정한다.
         */
         function initCombo(comboObj, comboId) {
        	 with (comboObj) {
    	    	 DropHeight = 300; 
    	    	 switch(comboObj.id) {
	 	    	 	case "f_cntr_tpsz_cd":
		    	    		IMEMode = 0;
		    	    		ValidChar(2, 1);
		    	    		MaxLength = 4;
		    	    		break;
	 	    	 	case "f_act_grp_cd":
	 	    	 		comboObj.InsertItem(0, 'All' ,'');
	 	    	 		break;	
	 	    	 }
    	    	 Index = 0;
    	    	 
        	 }
         }	
    	/**
    	* 시트 초기설정값, 헤더 정의
    	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	*/
    	function initSheet(sheetObj,sheetNo) {
    		var cnt = 0;
    			with (sheetObj) {

    				SheetWidth = mainTable.clientWidth;//전체 너비 설정
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
    				MergeSheet = msPrevColumnMerge;//전체Merge 종류 [선택, Default msNone]
    				Editable = false;//전체Edit 허용 여부 [선택, Default false]
    				InitRowInfo( 1, 1,1, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitColumnInfo(8, 1, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
    				var HeadTitle = "From|To|A/G|Cost Element/Cost Code|Ctrt/Avg|Curr.|Cost|Location\nHierarchy" ;

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);
    				//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ ,	dtData,		60,	    daCenter,	true,	"lnk_fm_nod_cd",	false,"",dfNone, 	0,	true,true);
    				InitDataProperty(0, cnt++ ,	dtData,		60,	    daCenter,	true,	"lnk_to_nod_cd",	false,"",dfNone, 	0,	true,true);
    				InitDataProperty(0, cnt++ ,	dtData,		100,	daLeft,		true,	"grp",				false,"",dfNone, 	0,	true,true);
    				InitDataProperty(0, cnt++ ,	dtData,		250,	daLeft,		false,	"cost_nm",			false,"",dfNone, 	0,	true,true);
    				InitDataProperty(0, cnt++ ,	dtData,		60,		daCenter,	false,	"cost_ass_bse_cd",	false,"",dfNone, 	0,	true,true, -1, false, false);
    				InitDataProperty(0, cnt++ ,	dtData,		40,		daCenter,	false,	"locl_curr_cd",		false,"",dfNone, 	0,	true,true, -1, false, false);
    				InitDataProperty(0, cnt++ ,	dtAutoSum,	70,	    daRight,	false,	"cost",				false,"",dfNullFloatOrg, 2,	true,true, -1, false, false);
    				InitDataProperty(0, cnt++ ,	dtData,		70,		daCenter,	false,	"loc_type",			false,"",dfNone, 	0,	true,true, -1, false, false);

    				InitTreeInfo(3, "", RgbColor(0,0,255), false);
    				CountPosition	= 0 ;
    				style.height = GetSheetHeight(25) ;
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
         * IBCombo Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++] = combo_obj;
        }
    	function sheet1_OnSearchEnd(sheetObj, errMessge) {
    		sheetObj.ShowSubSum( "grp", "cost", 0);
    		sheetObj.ShowTreeLevel(0, 1);
    	}


    	// Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;
    		switch(sAction) {
    			case IBCLEAR:          //조회
			        sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = INIT;
					var sXml = sheetObj.GetSearchXml("ESM_MAS_0008_1GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0)
						ComXml2ComboItem(arrXml[0], formObj.f_cntr_tpsz_cd, "code", "code");
					if (arrXml.length > 1)
						ComXml2ComboItem(arrXml[1], formObj.f_act_grp_cd, "code", "name");
					
					ComOpenWait(false);
					break;
					
    			case IBSEARCH:		//조회
    				if(validateForm(sheetObj,formObj,sAction)) {
    					// 업무처리중 버튼사용 금지 처리
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    					formObj.f_cmd.value = SEARCH;
    					sheetObj.DoSearch4Post("ESM_MAS_0008GS.do",masFormQueryString(formObj));
    					ComOpenWait(false);
    				}
    				break;

    			case IBDOWNEXCEL:			// excel down
    				var excelType = selectDownExcelMethod(sheetObj);
    				switch (excelType) {
    					case "AY":
    						sheetObj.Down2Excel(0, false, false, true);
    						break;
    					case "DY":
    						sheetObj.Down2Excel(-1, false, false, true);
    						break;
    					case "AN":
    						sheetObj.SpeedDown2Excel(0, false, false);
    						break;
    					case "DN":
    						sheetObj.SpeedDown2Excel(-1, false, false);
    						break;
    				}

    				break;
    		}
    	}
    	

    	/**
    	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	*/
    	function validateForm(sheetObj,formObj,sAction){
    		var rt = false;
    		with(formObj){
    			if(formObj.conditionType[1].checked){//Port To/FR Inland 조건 선택
    			    if(formObj.f_from.value == "") {
    					ComShowCodeMessage('MAS10002', 'From');
    					ComSetFocus(formObj.f_from);
    				} 
    			    else if(formObj.f_to.value == "") {
    					ComShowCodeMessage('MAS10002', 'To');
    					ComSetFocus(formObj.f_to);
    				} 
    				else if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
    					ComShowCodeMessage('COM12180');
    				} 
    				else {
    					rt = true;
    				}
    			}	
    			if(ComParseInt(formObj.f_cost_yrmon.value.replace("-","")) < 200707) {
                    // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
    				ComShowCodeMessage('MAS10037');
                    rt = false;
    		    }	
    		}
    		return rt;
    	}

    	/**
    	* radio버튼에 따라 화면이동
    	*/
    	function changeConditionType(v){
    		var frm = document.form;

    		if(v == '1'){//Port To/FR Inland
    			div_mas.style.display = "inline";
    			div_prd.style.display = "none";
    			//focus
    			frm.f_from.focus();
    			

    		} else if(v == '0'){//Org To
    		    //var para = "?sysCommUiTitle=Route Cost (PA/RA) & sysCommUiNavigation=Sales Marketing > Cost Assignment > Multi-Dimension Report > Sales PFMC"
    		    //document.location.href = "/hanjin/ESD_PRD_020.do" + para;
    		    //var cond = '';
    		    //noRtnPopup('ESM_MAS_141.do?f_pctl_no=T0706200000000370003' + cond, 'width=850,height=680,menubar=0,status=1,scrollbars=0,resizable=0')
    			div_mas.style.display = "none";
    			div_prd.style.display = "inline";
    			iframe_prd.document.form.por.focus();
    			iframe_prd.sheetObjects[0].Editable = false;
    		}

    	}

    	/**
    	* location code 공통 팝업 오픈
    	*/
    	function openLocationCode(funtionNm){
    		if(document.form.conditionType[0].checked){//org To일때 팝업오픈, getF_por, getF_del	
    			if(funtionNm == "getF_por" || funtionNm == "getF_del")
    				ComOpenPopup('/hanjin/COM_ENS_051.do', 775, 490,	funtionNm, '1,0,1,1,1,1,1,1,1,1,1,1', true);

    		} else {//port일때 팝업오픈, getF_from, getF_to
    			if(funtionNm == "getF_from" || funtionNm == "getF_to")
    			ComOpenPopup('/hanjin/COM_ENS_051.do', 775, 490,	funtionNm, '1,0,1,1,1,1,1,1,1,1,1,1', true);
    		}
    	}

        function getF_from(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_from.value = colArray[3];
    		document.form.f_to.focus();
    	}

    	function getF_to(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_to.value = colArray[3];
    		document.form.f_cost_yrmon.focus();
    	}

    	/**
    	* Empty 선택시 Activity Group Combo를 비활성화 시킨다.
    	*/
    	function hideActGrpCombo(){
    		var frm = document.form;
    		frm.f_act_grp_cd.Enable = false;
    		//document.form.f_act_grp_cd.disabled = true;
    	}

    	/**
    	* Full 선택시 Activity Group Combo를 활성화 시킨다.
    	*/
    	function showActGrpCombo(){
    		var frm = document.form;
    		frm.f_act_grp_cd.Enable = true;
    		//document.form.f_act_grp_cd.disabled = false;
    	}
    