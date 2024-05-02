/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0054.js
*@FileTitle : Stevedore Damage History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.22 이선영
* 1.0 Creation
* 2012.02.03 김민아 [CHM-201215702-01] [VOP-OPF] SDMS No. 정의 및 칼럼 정리 : SDMS No. 보완 및 Report No. 제거
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
     * @class vop_opf_0054 : vop_opf_0054 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_0054() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	//this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	//this.setTabObject 			= setTabObject;
    	//this.validateForm 			= validateForm;
    	this.setDamageData			= setDamageData;
    }
    
    
	/* 개발자 작업	*/

	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
	     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	         var sheetObject1 = sheetObjects[0];
	     /*******************************************************/
	     var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
	        switch(srcName) {
	        	
				case "btn_Print":
					//ComOpenPopup("VOP_OPF_1054.do", 800, 550, "", "0,0", true, false, null,null,null,"HistoryReportPop");
					rdOpen();
					break;
					
				case "btn_Close":
					self.close();
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
	
    //RD 공통 팝업  
    function rdOpen(){
    	var formObject = document.form;
    	var rdParam = "/rp ["+formObject.stv_dmg_no.value+"]";
    	var strPath = "apps/alps/vop/opf/stevedoredamagemgt/stevedoredamagemgt/report/VOP_OPF_1054.mrd";

    	formObject.com_mrdPath.value = strPath;
    	formObject.com_mrdArguments.value = rdParam;
    	ComOpenRDPopupModal();
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
			
			doActionIBSheet(sheetObjects[0],document.form, IBSEARCH);
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	
	    var cnt = 0;
		var sheetID = sheetObj.id;
	
	    switch(sheetID) {
	
	        case "sheet1":
	            with (sheetObj) {
	
	                // 높이 설정
	                style.height = 300;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(2, 1, 3, 100);
	                
	                //var HeadTitle = "|STV_DMG_NO|VVD_CD|VPS_PORT_CD|STV_DMG_EVNT_DT|STV_DMG_TP_CD|elapseDay|DMG_AUTH_STS_CD|STV_DMG_REQ_CATE_CD|STV_DMG_RPR_PROC_STS_CD|STV_DMG_CMPN_PROC_STS_CD|STV_DMG_STL_PROC_STS_CD|REQ_PORT_CD|REQ_ETA_DT";
					//var headCount = ComCountHeadTitle(HeadTitle);
	                var HeadTitle1 = "|No.||Date|Time|Office|ID|Name|Requirement\nCategory|Process|Process|Process";
					var HeadTitle2 = "|No.||Date|Time|Office|ID|Name|Requirement\nCategory|Repair|Compen.|Settle";
					var headCount = ComCountHeadTitle(HeadTitle1);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false);
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                //InitHeadRow(0, HeadTitle, true);
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                var prefix="sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,	30,		daCenter,	true,	"seq",			false,  "", dfInteger);
					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,	true,	prefix+"stv_dmg_step_his_seq",	false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_dt",			false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	45,	daCenter,	true,	prefix+"cre_time",			false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	60,	daCenter,	true,	prefix+"cre_usr_ofc_cd",	false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter,	true,	prefix+"cre_usr_id",		false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	150,daLeft,		true,	prefix+"cre_usr_nm",		false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	true,	prefix+"stv_dmg_proc_cd",	false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter,	true,	prefix+"rpr_sts_cd",		false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter,	true,	prefix+"cmpn_sts_cd",		false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"stl_sts_cd",		false,	"",  dfNone,	0,	false,	false);
					
					//CellFontColor(0,prefix+"dmg_auth_sts_cd") = RgbColor(255,0,0);
				}
	            break;
	    }
	}
	
	/**
	 * 화면 상단의 Damage 정보 Set..
	 */
	function setDamageData(sheetObj, formObj, dataXml){
		//var dataXml = sheetObj.GetSearchXml("VOP_OPF_0054GS.do" , FormQueryString(formObj));
		
		formObj.vsl_cd.value = ComGetEtcData(dataXml, "vsl_cd");
		formObj.skd_voy_no.value = ComGetEtcData(dataXml, "skd_voy_no");
		formObj.skd_dir_cd.value = ComGetEtcData(dataXml, "skd_dir_cd");
		formObj.vps_port_cd.value = ComGetEtcData(dataXml, "vps_port_cd");
		formObj.stv_dmg_evnt_dt.value = ComGetEtcData(dataXml, "stv_dmg_evnt_dt");
		formObj.slan_cd.value = ComGetEtcData(dataXml, "slan_cd");
		formObj.clm_hndl_ofc_cd.value = ComGetEtcData(dataXml, "clm_hndl_ofc_cd");
	}
	
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	    
	      case IBSEARCH:
	        formObj.f_cmd.value = SEARCH;
	        //sheetObj.DoSearch("VOP_OPF_0054GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	        var dataXml = sheetObj.GetSearchXml("VOP_OPF_0054GS.do" , FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	        if (dataXml != ""){
	        	sheetObj.LoadSearchXml(dataXml);
		        setDamageData(sheetObj, formObj, dataXml);
	        }
	        break;
	    }
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
//	function validateForm(sheetObj,formObj,sAction){
//	    with(formObj){
//	    }
//	    return true;
//	}
	
	/* 개발자 작업  끝 */