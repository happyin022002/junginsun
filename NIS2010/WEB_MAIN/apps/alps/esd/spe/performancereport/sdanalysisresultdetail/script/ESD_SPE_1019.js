/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1019.js
*@FileTitle : SD Analysis Result Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
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
     * @class ESD_SPE_1019 : ESD_SPE_1019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SPE_1019() {
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

	//공통전역변수
    var frm = null;
    var searchFlag = "0";
    var rhqXml = null;
    var ofcXml = null;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	

	    
	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++] = sheet_obj;
	 }    	    
	 
	 /**
      * IBMultiCombo Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++] = combo_obj;
     }
     
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;    

	 
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick() {
	 	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 	var sheetObj    = sheetObjects[0];

	 	/*******************************************************/
	 
	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	 		switch (srcName) {

	 			case "btn_retrieve":
	 				// IBSHEET 조회
	 				doActionIBSheet(sheetObjects[0], frm, IBSEARCH);	 				
	 				break;
	 				
	 			case "btn_detail":
	 				// IBSHEET 조회
	 				doActionIBSheet(sheetObjects[0], frm, "btn_detail");	 				
	 				break;
	 				
	 			case "btn_downexcel":
					doActionIBSheet(sheetObjects[1],frm,IBDOWNEXCEL);
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
		frm = document.form;
	    for(i=0;i<sheetObjects.length;i++){
			 //-시작 환경 설정 함수 이름 변경
			 ComConfigSheet(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	    
	    loadPageGridSetting(sheetObjects[0]);
	    doActionIBSheet(sheetObjects[1], frm, IBSEARCH);	
	    
         
	}



	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	 	var cnt = 0;
	 	switch(sheetNo) {
	  	case 1:      //IBSheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = GetSheetHeight(6) ;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                var HeadTitle1 = "|Year|Office|Office|Service Category|Evaluation Group|Evaluation Group|Service Provider|Service Provider|SD Group|PA Result|PA Result|B.A. Result|B.A. Result" ;
                var HeadTitle2 = "|Year|RHQ|Branch|Service Category|ID|Name|ID|Name|SD Group|Point|Group|B.A. Result|B.A. Result" ;
                var headCount = ComCountHeadTitle(HeadTitle1);
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 10, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);
                HeadRowHeight = 12;
              //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,         KEYFIELD, CALCULOGIC,  DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,	daCenter,  false,	 "ibflag");
                InitDataProperty(0, cnt++ , dtData,        45,	daCenter,  true,     "ev_yr",          false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,        45,	daCenter,  true,     "eg_rhq_cd",      false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,        45,	daCenter,  true,     "eg_ofc_cd",	   false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,        110, daCenter,  true,     "ev_svc_cate_cd", false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,        70,  daCenter,  true,     "eg_id",		   false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,        100, daCenter,  true,     "eg_nm",          false,          "",       dfNone,       0,     false,       false);
                
				InitDataProperty(0, cnt++ , dtData,        50,  daCenter,  true,     "sp_seq",         false,          "",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,        170, daLeft,    true,     "sp_name",        false,          "",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,        60,  daCenter,  true,     "sd_group",       false,          "",       dfNone,       0,     false,       false);                    
                InitDataProperty(0, cnt++ , dtData,        50,	daRight,   false,    "pa_point",       false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,        80,  daCenter,  false,    "pa_group",	   false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,      50,  daRight,   false,    "be_point",	   false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,        100, daCenter,  true,     "be_group", 	   false,          "",       dfNone,       0,     false,       false);
                
           }
           break;        

	    	case 2:      //sheet2 init
	    		with (sheetObj) {
	    		// 높이 설정
	    		style.height = GetSheetHeight(14) ;
	    		//전체 너비 설정
	    		SheetWidth = mainTable.clientWidth;
	    		
	    		//Host정보 설정[필수][HostIp, Port, PagePath]
	    		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    		
	    		//전체Merge 종류 [선택, Default msNone]
	    		MergeSheet = 7;
	    		
	    		//전체Edit 허용 여부 [선택, Default false]
	    		Editable = true;
	    		
	    		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    		InitRowInfo(1, 1, 10, 100);
	    		
	    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    		
	    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    		InitHeadMode(true, true, true, true, false,false) ;
	    		
	    		var HeadTitle1 = "ibflag|EG ID|EG Name|S/P ID|S/P Name|Analysis Way|KPICD|KPI|SP_KPI_TP_CD|Result (Score)|Target|PFMC|Weight (%)|EV_YR|EG_RHQ_CD|EG_OFC_CD|EV_SVC_CATE_CD";
	    		InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
	    		
	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    		InitHeadRow(0, HeadTitle1, true);
	    		SelectHighLight = false;
	    		
	    		HeadRowHeight = 12;
	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,         KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    		InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	true,	  "ibflag");
                InitDataProperty(0, cnt++ , dtData,         70,     daCenter,   true,     "eg_id",		    false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,     "eg_nm",          false,          "",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         75,     daCenter,   true,     "sp_seq",         false,          "",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         100,    daLeft,     true,     "sp_name",        false,          "",       dfNone,       0,     false,       false);	    		
				InitDataProperty(0, cnt++ , dtData,         100,    daLeft,     true,     "sp_kpi_tp_nm",   false,          "",       dfNone,       0,     false,       false);	    		
				InitDataProperty(0, cnt++ , dtHidden,       100,    daCenter,   true,     "sp_kpi_id",      false,          "",       dfNone,       0,     false,       false);	    		
				InitDataProperty(0, cnt++ , dtData,         150,    daLeft,     true,     "sp_kpi_nm",      false,          "",       dfNone,       0,     false,       false);	    		
				InitDataProperty(0, cnt++ , dtHidden,       100,    daCenter,   true,     "sp_kpi_tp_cd",   false,          "",       dfNone,       0,     false,       false);	    		
				InitDataProperty(0, cnt++ , dtPopup,        100,    daRight,    true,     "rslt_scre_rto",  false,          "",       dfNone,       0,     true,       true);	    		
				InitDataProperty(0, cnt++ , dtData,         60,     daRight,    true,     "kpi_tgt_rto",    false,          "",       dfNone,       0,     false,       false);	    		
				InitDataProperty(0, cnt++ , dtData,         60,     daRight,    true,     "pfmc",           false,          "",       dfNone,       0,     false,       false);	    		
				InitDataProperty(0, cnt++ , dtData,         60,     daRight,    true,     "kpi_wgt_rto",    false,          "",       dfNone,       0,     false,       false);	    		
				InitDataProperty(0, cnt++ , dtHidden,       100,    daRight,    true,     "ev_yr",          false,          "",       dfNone,       0,     false,       false);	    		
				InitDataProperty(0, cnt++ , dtHidden,       100,    daRight,    true,     "eg_rhq_cd",      false,          "",       dfNone,       0,     false,       false);	    		
				InitDataProperty(0, cnt++ , dtHidden,       100,    daRight,    true,     "eg_ofc_cd",      false,          "",       dfNone,       0,     false,       false);	    		
				InitDataProperty(0, cnt++ , dtHidden,       100,    daRight,    true,     "ev_svc_cate_cd", false,          "",       dfNone,       0,     false,       false);	    		
	    		
	    		
	        }
	    	break;				
		}
	}	

	 
	function loadPageGridSetting(sheetObj){
		var dRow = sheetObj.DataInsert(-1);
		sheetObj.CellValue(dRow,"ev_yr")          = frm.ev_yr.value;
		sheetObj.CellValue(dRow,"eg_rhq_cd")      = frm.eg_rhq_cd.value;
		sheetObj.CellValue(dRow,"eg_ofc_cd")      = frm.eg_ofc_cd.value;
		sheetObj.CellValue(dRow,"ev_svc_cate_cd") = frm.ev_svc_cate_cd.value;
		sheetObj.CellValue(dRow,"eg_id")          = frm.eg_id.value;
		sheetObj.CellValue(dRow,"eg_nm")          = frm.eg_nm.value;
		sheetObj.CellValue(dRow,"sp_seq")         = frm.sp_seq.value;
		sheetObj.CellValue(dRow,"sp_name")        = frm.sp_name.value;
		sheetObj.CellValue(dRow,"sd_group")       = frm.sd_group.value;
		sheetObj.CellValue(dRow,"pa_point")       = frm.pa_point.value;
		frm.s_pa_score.value                      = frm.pa_point.value;
		sheetObj.CellValue(dRow,"pa_group")       = frm.pa_group.value;
		sheetObj.CellValue(dRow,"be_point")       = frm.be_point.value;
		sheetObj.CellValue(dRow,"be_group")       = frm.be_group.value;
	}

	//SHEET 관련 프로세스 처리
	function doActionIBSheet(sheetObj, frm, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {

			// SEARCH LOGIC
			case IBSEARCH:
				if(!validateForm(sheetObj,frm,sAction)) return;
        	    sheetObj.RemoveAll();
				frm.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(frm);

				var sXml = sheetObj.GetSearchXml("ESD_SPE_1019GS.do", sParam);
				sheetObj.loadSearchXml(sXml);
				break;
		
			case IBDOWNEXCEL :	// EXCEL DOWNLOAD
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
				break;
			case "btn_detail" :	// EXCEL DOWNLOAD
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
				break;
		}
	}


    
	 
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	  function validateForm(sheetObj,frm,sAction){
	 	 switch(sAction) {
	 	 case IBSEARCH :
	 		 break;
	 	 } // end switch()
	 	 return true;
	  }	 
	  
	    /**
	     * 조회 함수를 이용하여 조회가 완료되고 발생하는 이벤트
	     */
		function sheet2_OnSearchEnd(sheetObj,ErrMsg){
			// CELL format변경
//			for( var idx = parseInt(sheetObj.HeaderRows); idx <= sheetObj.SearchRows ; idx++ ){			
//				var kpiTpCd = sheetObj.CellValue(idx,"sp_kpi_tp_cd");
//				if(kpiTpCd == 'S'){
//					sheetObj.InitCellProperty (idx, "rslt_scre_rto", dtPopup, daRight, "rslt_scre_rto", "", dfNone, 0, 0);
//				}else{
//					sheetObj.CellEditable(idx, "rslt_scre_rto") = false; 
//				}
//			}	
		}
		
		
		/**
	 	 * sheet2의 OnPopupClick Event 처리부분.<br>
	 	 * @param sheetObj
	 	 * 
	 	 * @param Row
	 	 * @param Col
	 	 */
	    function sheet2_OnPopupClick(sheetObj,row,col) {
	 		with(sheetObj) {
				var sName = ColSaveName(col);
				switch(sName) {
					case "rslt_scre_rto":
						var kpiTpCd = sheetObj.CellValue(row,"sp_kpi_tp_cd");
						if(kpiTpCd == 'S'){
							var param = "?EV_YR="+sheetObj.CellValue(row,"ev_yr")+
							            "&EG_RHQ_CD="+sheetObj.CellValue(row,"eg_rhq_cd")+
							            "&EG_OFC_CD="+sheetObj.CellValue(row,"eg_ofc_cd")+
							            "&EV_SVC_CATE_CD="+sheetObj.CellValue(row,"ev_svc_cate_cd")+
							            "&SP_SEQ="+sheetObj.CellValue(row,"sp_seq")+
							            "&SP_NM="+sheetObj.CellValue(row,"sp_name");
							  ComOpenPopup("/hanjin/ESD_SPE_1016.do"+param, 1024, 620, '', '1,0,1,1,1', true, false);
						}else{
							var param = "?EV_YR="+sheetObj.CellValue(row,"ev_yr")+
										"&EG_ID="+sheetObj.CellValue(row,"eg_id")+
										"&SP_SEQ="+sheetObj.CellValue(row,"sp_seq")+
										"&EG_RHQ_CD="+sheetObj.CellValue(row,"eg_rhq_cd")+
										"&EG_OFC_CD="+sheetObj.CellValue(row,"eg_ofc_cd")+
										"&EV_SVC_CATE_CD="+sheetObj.CellValue(row,"ev_svc_cate_cd")+
							"&SP_NM="+sheetObj.CellValue(row,"sp_name");
							ComOpenPopup("/hanjin/ESD_SPE_1020.do"+param, 1024, 450, '', '1,0,1,1,1', true, false);
							
						}
						break;
				}
	 		}
	    }			
      

		
	/* 개발자 작업  끝 */