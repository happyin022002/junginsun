/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0032.js
*@FileTitle  : Batch Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
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
     * @class ESM_ACM_0032 : ESM_ACM_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0032() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.doActionIBSheet=doActionIBSheet;
    }
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var currentRow=0;
    var loginUsr="";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj=sheetObjects[0];
        var shtObj2=sheetObjects[1];
        var frmObj=document.form;
        var srcName=ComGetEvent("name");
        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(shtObj, frmObj, IBSEARCH);
                break;
            case "btng_cancel_cal":
            	doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
            	break;
            case "btng_cancel_sim":
            	doActionIBSheet(shtObj2, frmObj, IBSEARCH_ASYNC01);
            	break;
        } // end switch
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(shtObj) {
       sheetObjects[sheetCnt++]=shtObj;
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        with (shtObj) {
            switch (shtObj.id) {
            case "sheet1":
            	   var cnt=0;
            	   
            	   document.form.pagerows.value=500;
            	   var HeadTitle="|CHK|Seq|User|Total BKG No.|Completed|Start Date|Start Date|Remark|||";
            	   (ComCountHeadTitle(HeadTitle), 0, 0, false);
            	   SetEditEnterBehavior("tab");

            	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	   var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
            	   var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	   InitHeaders(headers, info);

            	   var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	             {Type:"DummyCheck", Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
            	             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"tot_bkg_cnt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"com_cnt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"stat_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"stat_tm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"bat_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"bat_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            	             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"n_cnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            	             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"bat_itm_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
            	    
            	   InitColumns(cols);
            	   SetSheetHeight(210);
                   SetEditable(1);
                   SetWaitImageVisible(0);
                   SetEditableColorDiff(0);
            	      break;


            case "sheet2":
                var cnt=0;
               
                document.form.pagerows.value=500;
                var HeadTitle="|CHK|Seq|Simulation No.|User|Total BKG No.|Completed|Start Date|Start Date|Remark|";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);
                SetEditEnterBehavior("tab");

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                       {Type:"DummyCheck", Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                       {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bat_itm_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"tot_bkg_cnt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"com_cnt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"stat_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"stat_tm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"bat_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 ,  UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"n_cnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
                 
                InitColumns(cols);
                SetSheetHeight(210);
                SetEditable(1);
                SetWaitImageVisible(0);
                SetEditableColorDiff(0); 
                      break;


            }
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case IBSEARCH:    // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                var sXml=shtObj.GetSearchData("ESM_ACM_0032GS.do", FormQueryString(frmObj));
                var arrXml=sXml.split("|$$|");
                //데이터를 IBSheet에 세팅한다.
                sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
                sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC01:    // Cancel Batch
            	if (!ComChkValid(frmObj)) return;
            	ComOpenWait(true);
            	frmObj.f_cmd.value=MULTI01;
            	shtObj.DoSave("ESM_ACM_0032GS.do", FormQueryString(frmObj), "chk", false);
                ComOpenWait(false);
            	break;
        }
    }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        loginUsr=document.form.usr_id.value;
        with (shtObj) {
			for(var i=1; i<=shtObj.LastRow(); i++) {
				//Processing or 유저가 다른 로우에 대해서 Check box 비활성화
				if ( GetCellValue(i, "com_cnt") != "0" || GetCellValue(i, "cre_usr_id") != loginUsr ) {
					SetCellEditable(i, "chk",0);
					//SetCellBackColor(i, "chk",RgbColor(239,240,243));
				}
            }
        }
    }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet2_OnSearchEnd(shtObj, ErrMsg) {
    	if (ErrMsg != "") return;
    	with (shtObj) {
    		for(var i=1; i<=shtObj.LastRow(); i++) {
    			//Processing or 유저가 다른 로우에 대해서 Check box 비활성화
    			if ( GetCellValue(i, "com_cnt") != "0" || GetCellValue(i, "cre_usr_id") != loginUsr ) {
    				SetCellEditable(i, "chk",0);
    				//SetCellBackColor(i, "chk",RgbColor(239,240,243));
    			}
    		}
    	}
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet2_OnSaveEnd(shtObj, ErrMsg) {
    	if (ErrMsg != "") return;
    	// 저장 후 재조회
    	doActionIBSheet(shtObj, document.form, IBSEARCH);
    }
/* 개발자 작업 끝 */
