/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_167.js
*@FileTitle  : TC/O Hire Table
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
                case "btn_rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;
                case "btn_close":
  ComClosePopup(); 
                    break;
            } // end switch
        }catch(e) {
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
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj) {
        var cnt=0;
        with(sheetObj){
          var HeadTitle0="STS|Del|Vessel Capa.\n(from~)|TC/O Revenue|TC/O Revenue||SEQ|MIN SEQ";
          var HeadTitle1="STS|Del|Vessel Capa.\n(from~)|Per TEU|Per Day||SEQ|MIN SEQ";

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

          var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle0, Align:"Center"},
                      { Text:HeadTitle1, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",         KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_clss_capa",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vsl_teu_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vsl_dly_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"to_hir_seq",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"min_seq",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
           
          InitColumns(cols);

          SetEditable(1);//전체Edit허용여부[선택,Defaultfalse]
                }


    }
    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //조회
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
                formObj.f_cmd.value=SEARCHLIST01;
                 sheetObj.DoSearch("ESM_COA_0167GS.do", coaFormQueryString(formObj) );
                ComOpenWait(false);
                break;
            case IBSAVE:        //저장
                if(!validateForm(sheetObj,formObj,sAction))return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
                formObj.f_cmd.value=MULTI01;
                sheetObj.DoAllSave("ESM_COA_0167GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;
            case IBINSERT:        //저장
                sheetObj.DataInsert();
                break;
        }
    }
    var chkFlag;
    /**
     * Click event 시의 ibflag를 체크한다.
     */
    function sheet1_OnClick(sheetObj, row, col, value){
        //chkFlag = sheetObj.CellValue(row,"ibflag");
chkFlag=sheetObj.GetRowStatus(row);
    }
    /**
     * 이전 컬럼의 상태를 변경시켜 준다.
     */
    function sheet1_OnChange(sheetObj, row, col, value){
        // Row 의  from vessel class 가 변경되면 이전 Row의 to vessel class 도 변경되어야 
        // 하기 때문에 이전 Row의 상태를 Update로 변경한다.
        if(row > 1 && chkFlag != "I" &&
           (
            sheetObj.SaveNameCol("del_chk")== col  ||
            sheetObj.SaveNameCol("vsl_clss_capa")== col  ||
            sheetObj.SaveNameCol("vsl_teu_uc_amt")== col ||
            sheetObj.SaveNameCol("vsl_dly_uc_amt")== col
           )){
            // 이전 Row의 상타가 D/U/I 일경우는 상태를 변경시키지 않는다.
            //if(sheetObj.CellValue(row-1,"ibflag")== "R") sheetObj.CellValue2(row-1, "ibflag") = "U";
if(sheetObj.SetRowStatus(row-1)== "R") sheetObj.GetRowStatus(row-1,"U");
        }
    }
