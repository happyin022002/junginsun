/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_ACM_0114.js 
*@FileTitle  : Agreement Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @extends
     * @class ESM_ACM_0114 : ESM_ACM_0114 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_m_close":           // close
            	ComClosePopup(); 
                break;
        }
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
        sheet1_OnLoadFinish(sheet1);
        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        var shtId=shtObj.id;
        with(shtObj){
        	
        	      document.form.pagerows.value=500;
        	      InitComboNoMatchText(true);
        	      SetShowButtonImage(3);
        	      switch (shtId) {
        	      case "sheet1":
        	      var cnt=0;
        	      //no support[check again]CLT style.height=GetSheetHeight(16);
        	      var HeadTitle0="STS|Bound|Account|Fixed Base|Fixed Base|Fixed Base|Fixed Base|Rate Base|Rate Base|Rate Base|Deduction|Deduction|Deduction|Deduction|Deduction|Deduction|Route Setting|Route Setting|Route Setting|Route Setting|Office Setting|Office Setting|Office Setting";
        	      var HeadTitle1="STS|Bound|Account|TP/SZ|Full/MT|Curr|Fixed Amount|Pay Term|Base|Rate|R. CHG|CHG|O. Haulage|D. Haulage|O. Feederage|D. Feederage|POR|POL|POD|DEL|Type|Covered Location|Office";

        	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );

        	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	      var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
        	      InitHeaders(headers, info);

        	      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
        	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd" },
        	             {Type:"Combo",     Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"ac_tp_cd" },
        	             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"cntr_tpsz_cd" },
        	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd" },
        	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd" },
        	             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"comm_fx_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
        	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"comm_pay_term_cd" },
        	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_div_cd" },
        	             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"comm_rt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
        	             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rep_chg_cd" },
        	             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"chg_cd" },
        	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"hlg_ddct_org_flg" },
        	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"hlg_ddct_dest_flg" },
        	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fdrg_ddct_org_flg" },
        	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fdrg_ddct_dest_flg" },
        	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por" },
        	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol" },
        	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod" },
        	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del" },
        	             {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ofc_set_tp_cd" },
        	             {Type:"Combo",     Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cvrg_cd" },
        	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd" } ];
        	       
        	      InitColumns(cols);

        	      SetEditable(0);
        	      SetColProperty("ofc_cvrg_cd", {ComboText:"|"+ofcCvrgText, ComboCode:"|"+ofcCvrgCode} );
        	      SetColProperty("io_bnd_cd", {ComboText:ioBndText, ComboCode:ioBndCode} );
              	SetColProperty("ac_tp_cd", {ComboText:acTpText, ComboCode:acTpCode} );
              	SetColProperty("full_mty_cd", {ComboText:fullMtyText, ComboCode:fullMtyCode} );
              	SetColProperty("comm_pay_term_cd", {ComboText:commPayTermText, ComboCode:commPayTermCode} );
              	SetColProperty("rev_div_cd", {ComboText:revDivText, ComboCode:revDivCode} );
              	SetColProperty("hlg_ddct_org_flg", {ComboText:"Y|N", ComboCode:"1|0"} );
              	SetColProperty("hlg_ddct_dest_flg", {ComboText:"Y|N", ComboCode:"1|0"} );
              	SetColProperty("fdrg_ddct_org_flg", {ComboText:"Y|N", ComboCode:"1|0"} );
              	SetColProperty("fdrg_ddct_dest_flg", {ComboText:"Y|N", ComboCode:"1|0"} );
              	SetColProperty("ofc_set_tp_cd", {ComboText:ofcSetTpText, ComboCode:ofcSetTpCode} );
        	            //no support[check again]CLT ColIndent("cntr_tpsz_cd")=2;
        	      //no support[check again]CLT ColIndent("comm_fx_amt")=2;
        	      //no support[check again]CLT ColIndent("comm_rt")=2;
        	      //no support[check again]CLT ColIndent("rep_chg_cd")=2;
        	      //no support[check again]CLT ColIndent("chg_cd")=2;
              	SetSheetHeight(ComGetSheetHeight(sheetObj, 10));
              	SetRangeBackColor(1, 2,1, 22, "#555555");
              	SetCountPosition(0);
        	      break;



                    break;
            }
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case IBSEARCH:
                frmObj.f_cmd.value=SEARCH;
                 shtObj.DoSearch("ESM_ACM_0114GS.do", FormQueryString(frmObj), {Sync:2} );
                break;
        }
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
 function sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 RHQ Select Object 생성
         doActionIBSheet(shtObj, document.form, IBSEARCH);
     }
     /**
      * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
      * @param {shtObj} String : 해당 IBSheet Object
      * @param {Row} Long : 해당 셀의 Row Index
      * @param {Col} Long : 해당 셀의 Column Index
      * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
      */
     function sheet1_OnClick(shtObj, Row, Col, Value) {
         with (shtObj) {
             switch (ColSaveName(Col)) {
                 case "cntr_tpsz_cd":
                 case "rep_chg_cd":
                 case "chg_cd":
                     ComShowMemoPad(shtObj, Row, Col, true);
                     break;
             }
         }
     }
/* 개발자 작업 끝 */
