/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_150.js
*@FileTitle  : Continent Pair
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                case "btng_rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
            } 
        } catch(e) {
            if( e == "[object Error]") {
            	ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
              var HeadTitle="DEL|STS|R.Lane|Bound|IOC|From Conti|To Conti|Trade|Sub Trade|S.Lane||";

              SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"delflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_conti_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_conti_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"org_fm_conti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"org_to_conti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);//전체Edit허용여부[선택,Defaultfalse]
              SetColProperty("fm_conti_cd", {ComboText:"|ASIA|EUROPE|AFRICA|AMERICA", ComboCode:"|A|E|F|M"} );
              SetColProperty("to_conti_cd", {ComboText:"|ASIA|EUROPE|AFRICA|AMERICA", ComboCode:"|A|E|F|M"} );
              }


                break;
        }
    }
    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBCLEAR:          //조회
		        sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
 				var sXml=sheetObj.GetSearchData("ESM_COA_0150GS.do", coaFormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "skd_dir_cd", true, 0);
				if (arrXml.length > 1)
					ComCoaSetIBCombo(sheetObj, arrXml[1], "ioc_cd", true, 0);
				ComOpenWait(false);
				break;    
            case IBSEARCH:      /*조회*/
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                formObj.slan_cd.value=formObj.f_slan_cd.value;
                formObj.sim_no.value=formObj.f_sim_no.value;
                formObj.sim_dt.value=formObj.f_sim_dt.value;
                formObj.dept_cd.value=formObj.f_dept_cd.value;
                formObj.usr_id.value=formObj.f_usr_id.value;
                sheetObj.DoSearch("ESM_COA_0150GS.do", coaFormQueryString(formObj) );
                ComOpenWait(false);
                break;
            case IBSAVE:        /*저장*/
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
                formObj.f_cmd.value=MULTI01;   
                formObj.slan_cd.value=formObj.f_slan_cd.value;
                formObj.sim_no.value=formObj.f_sim_no.value;
                formObj.sim_dt.value=formObj.f_sim_dt.value;
                formObj.dept_cd.value=formObj.f_dept_cd.valu
                formObj.usr_id.value=formObj.f_usr_id.value;
                sheetObj.DoSave("ESM_COA_0150GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;
            case IBINSERT:      /* 입력*/
                sheetObj.DataCopy();
                sheetObj.SetCellValue(sheetObj.GetSelectRow(),"fm_conti_cd","",0);
                sheetObj.SetCellValue(sheetObj.GetSelectRow(),"to_conti_cd","",0);
                break;
        }
    }
    /**
     *
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    }
