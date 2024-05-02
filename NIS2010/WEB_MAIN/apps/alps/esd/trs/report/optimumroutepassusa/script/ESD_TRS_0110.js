/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0110.js
*@FileTitle : BKG Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-17
*@LastModifier : 조인영
*@LastVersion : 1.0
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
     * @class ESD_TRS_0110 : esd_trs_0110 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_trs_0110() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0];
		 var sheetObject2 = sheetObjects[1];
         
         /*******************************************************/
         var formObject = document.form;
 		 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;

					case "btn_down_excel":
						sheetObject1.SpeedDown2Excel(-1);
						break;

						
					case "btn_close":
						window.close();
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

	function getSheet2Search(){
		var formObj = document.form;
		doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);
	}

	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		
		if(sheetObj.RowCount > 0){
    		sheetObjects[1].SpeedDown2Excel(-1);
		}
		ComOpenWait(false);
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		
		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;
		
    }
     
    function sheet1_OnLoadFinish(sheetObj){
        var formObj = document.form;
    	doActionIBSheet(sheetObj,formObj,IBSEARCH);
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
                    style.height = 446;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle = "Flag|Seq.|BKG No|S/O No|W/O No|COP No|CNTR No|TP/SZ|W/O Office|BND|Cost Mode|Trans Mode|From|Via|To|Door|TRS S/O Remark";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(17, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,30,daCenter,false,prefix+"ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 	50,	daCenter,	true,	prefix+"",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"bkg_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"so_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,daCenter,	true,	prefix+"wo_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	100,	daCenter,	true,	prefix+"cop_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"eq_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	40,	daCenter,	true,	prefix+"eq_tpsz_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"wo_cre_ofc_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	40,	daCenter,	true,	prefix+"trsp_bnd_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"trsp_cost_dtl_mod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"trsp_crr_mod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"via_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"to_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"dor_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	100,	daLeft,	true,	prefix+"trs_so_rmk",	false, "", dfNone, 0, false, false);
					CountFormat = "[ SELECTDATAROW / TOTALROWS ]";
	            	}
				break;

            case "sheet2":
                with (sheetObj) {
					// 높이 설정
                    style.height = 446;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle = "Flag|Seq.|BKG No|W/O No|COP No|CNTR No|TP/SZ|W/O Office|BND|Cost Mode|Trans Mode|From|Via|To|Door|TRS S/O Remark";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(17, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,30,daCenter,false,prefix+"ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 	50,	daCenter,	true,	prefix+"",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"bkg_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"so_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,daCenter,	true,	prefix+"wo_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	100,	daCenter,	true,	prefix+"cop_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"eq_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	40,	daCenter,	true,	prefix+"eq_tpsz_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"wo_cre_ofc_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	40,	daCenter,	true,	prefix+"trsp_bnd_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"trsp_cost_dtl_mod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"trsp_crr_mod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"via_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"to_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"dor_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	100,	daLeft,	true,	prefix+"trs_so_rmk",	false, "", dfNone, 0, false, false);
				}
				break;
        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH: //Retrieve
				//if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					var arr = new Array("sheet1_", "");
		        	var sParam = FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr);
					var sXml = sheetObj.GetSearchXml("ESD_TRS_0110GS.do", sParam);
					if(sXml.length>0){
						sheetObj.LoadSearchXml(sXml);
					}
				//}	
				break;
        }
    }
	
	/**
     * Get Object Value
     */
    function getObjValue(name) {
    	return ComGetObjValue(eval("document.form."+name));
    }
    
    /**
     * Set Object Value
     */
    function setObjValue(name, value) {
    	ComSetObjValue(eval("document.form."+name), value);
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {

		}
        return true;
    }

	/* 개발자 작업  끝 */