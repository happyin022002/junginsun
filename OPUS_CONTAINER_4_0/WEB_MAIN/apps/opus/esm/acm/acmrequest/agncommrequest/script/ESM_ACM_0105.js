/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0105.js
*@FileTitle  : Calculation Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
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
     * @class ESM_ACM_0105 : ESM_ACM_0105 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0105() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
        this.validateForm=validateForm;
    }
 
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var vvd_shtObj=sheetObjects[0];
        var bl_shtObj=sheetObjects[1];
        var shtObj=sheetObjects[2];
        var frmObj=document.form;
//        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "btn_close":
                	ComClosePopup(); 
                    break;
            } // end switch
//        } catch(e) {
//            if (e == "[object Error]") {
//                ComShowMessage(OBJECT_ERROR);
//            } else {
//                ComShowMessage(e);
//            }
//        }
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
        box1sheet1_OnLoadFinish(sheetObjects[0]); //메서드 반드시 참조
        //box3sheet3_OnSearchEnd(sheetObjects[2]);
       
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
    	var shtId=shtObj.id;
        with (shtObj) {
        	document.form.pagerows.value=500;
        	SetEditEnterBehavior("tab");
        	InitComboNoMatchText(true);
        	SetShowButtonImage(3);
        	//no support[implemented common]CLT SelectHighLight=false;
            switch (shtId) {
            case "box1sheet1":    // Booking Revenue
                var cnt=0;
                var HeadTitle="STS|CHG|Amount|Cur|USD AMT";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2, Page:20, DataRowMerge:0 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",        UpdateEdit:0,	   InsertEdit:0},
                             {Type:"Float",     Hidden:0,  Width:132,  Align:"Right",   ColMerge:0,   SaveName:"chg_amt",      UpdateEdit:0,   InsertEdit:0,	KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd" ,      UpdateEdit:0,   InsertEdit:0},
                             {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"usd_chg_amt",  InsertEdit:0,  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,      UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                SetSheetHeight(130);
                break;
            case "box1sheet2":    // Booking Q’ty
                var cnt=0;
                var HeadTitle="STS|TP/SZ|Q'ty";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2, Page:20, DataRowMerge:0 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      UpdateEdit:0,   InsertEdit:0},
                             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",      UpdateEdit:0,   InsertEdit:0,   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
                 
                InitColumns(cols);
                SetSheetHeight(95);
                SetSheetWidth(220);
                break;
            case "box1sheet3":    // Booking Route
                var cnt=0;
                var HeadTitle="STS|POR|POL|Pre|Post|POD|DEL|R/D";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2, Page:20, DataRowMerge:0 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Text",     Hidden:0,  Width:58,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",      UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",     Hidden:0,  Width:58,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",      UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",     Hidden:0,  Width:58,   Align:"Center",  ColMerge:0,   SaveName:"pre_port_cd", UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",     Hidden:0,  Width:58,   Align:"Center",  ColMerge:0,   SaveName:"pst_port_cd", UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",     Hidden:0,  Width:58,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",      UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",     Hidden:0,  Width:58,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",      UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",     Hidden:0,  Width:52,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",      UpdateEdit:0,   InsertEdit:0 }];
                 
                InitColumns(cols);
                SetSheetHeight(95);
                break;
            case "box2sheet1":    // Charge Deduction
                var cnt=0;
                var HeadTitle="STS|CHG|Amount|Cur|USD AMT";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2, Page:20, DataRowMerge:0 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",      		UpdateEdit:0,   InsertEdit:0},
                             {Type:"Float",     Hidden:0,  Width:132,  Align:"Right",   ColMerge:0,   SaveName:"chg_ddct_pay_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,      UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",      		UpdateEdit:0,   InsertEdit:0},
                             {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"chg_ddct_amt",      UpdateEdit:0,   InsertEdit:0,      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
                 
                InitColumns(cols);
                SetSheetHeight(130);
                break;
            case "box2sheet2":    // Transportation Cost Deduction
                var cnt=0;
                var HeadTitle="STS|Item|From|To|USD AMT";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2, Page:20, DataRowMerge:0 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"stnd_cost_nm",   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"nod_cd",      	UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"to_nod_cd",   	UpdateEdit:0,   InsertEdit:0},
                             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"usd_uc_amt",    UpdateEdit:0,   InsertEdit:0,    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
                 
                InitColumns(cols);
                SetSheetHeight(155);
                break;
            case "box3sheet1":    // General Commission
                var cnt=0;
                var HeadTitle="STS|Net Revenue|Net Revenue|Rate(%)|Q'ty|Fixed Amount|General AMT(LCL)|General AMT(USD)";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",   Hidden:1,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Float",    Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"crnt_rev_amt",   KeyField:0,     CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",   		UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"comm_rt",   		UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_qty",  UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:168,  Align:"Center",  ColMerge:0,   SaveName:"comm_fx_amt",   	UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",    Hidden:0,  Width:168,  Align:"Right",   ColMerge:0,   SaveName:"pay_if_amt",     KeyField:0,     CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",    Hidden:0,  Width:168,  Align:"Right",   ColMerge:0,   SaveName:"if_amt",         KeyField:0,     CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                SetSheetHeight(130);
                break;
            case "box3sheet2":    // Container Handling Fee (CHF)
                var cnt=0;
                var HeadTitle="STS|Q'ty|Rate(USD)|CHF AMT(LCL)|CHF AMT(USD)";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2, Page:20, DataRowMerge:0 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",   Hidden:1,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_qty",  UpdateEdit:0,  InsertEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"comm_fx_amt",    UpdateEdit:0,  InsertEdit:0 },
                             {Type:"Float",    Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:"pay_if_amt",     KeyField:0,    CalcLogic:"",   Format:"Float",    PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",    Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:"if_amt",         KeyField:0,    CalcLogic:"",   Format:"Float",    PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                SetSheetHeight(130);
                break;
            case "box3sheet3":    // T/S Commission
                var cnt=0;
                var HeadTitle="STS|Q'ty|Rate(USD)|T/S AMT(LCL)|T/S AMT(USD)";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2, Page:20, DataRowMerge:0 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",   Hidden:1,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_qty",   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"comm_fx_amt",     UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",    Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:"pay_if_amt",      KeyField:0,    CalcLogic:"",   Format:"Float",    PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",    Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:"if_amt",          KeyField:0,    CalcLogic:"",   Format:"Float",    PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                SetSheetHeight(130);
                break;
                
            case "box3sheet4":    // Commission Detail
                var cnt=0;
                var HeadTitle0="STS|Account|Rate/Box|Gross/Net|Comm.Rev|Rate/Unit|Comm.\nTP/SZ|Q'ty|Calculated \nAmt(USD)|Pre \nAmt(USD)|Current Amt|Current Amt|Remark";
                var HeadTitle1="STS|Account|Rate/Box|Gross/Net|Comm.Rev|Rate/Unit|Comm.\nTP/SZ|Q'ty|Calculated \nAmt(USD)|Pre \nAmt(USD)|(USD)|(LCL)|Remark";
                (ComCountHeadTitle(HeadTitle1), 1, 0, false);

                SetConfig( { SearchMode:2, FrozenCol:2, Page:20, MergeSheet:7, DataRowMerge:0 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"}];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",   Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Text",     Hidden:0,  Width:200, Align:"Center",  ColMerge:1,   SaveName:"acct_cd",   	 	UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"rt_fx_flg",   	UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:"rev_div_cd",   	UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",    Hidden:0,  Width:80,  Align:"Right",   ColMerge:0,   SaveName:"comm_rev_amt",    KeyField:0,     CalcLogic:"",   Format:"NullFloat",PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:80,  Align:"Right",   ColMerge:0,   SaveName:"comm_rt_amt",     KeyField:0,     CalcLogic:"",   Format:"Float",    PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"comm_tpsz_cd",    UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:80,  Align:"Right",   ColMerge:0,   SaveName:"bkg_vol_qty",     UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",    Hidden:0,  Width:80,  Align:"Right",   ColMerge:1,   SaveName:"crnt_amt",      	KeyField:0,     CalcLogic:"",   Format:"Float",    PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",    Hidden:0,  Width:80,  Align:"Right",   ColMerge:1,   SaveName:"ppd_amt",      	KeyField:0,     CalcLogic:"",   Format:"Float",    PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",    Hidden:0,  Width:80,  Align:"Right",   ColMerge:1,   SaveName:"if_amt",      	KeyField:0,     CalcLogic:"",   Format:"Float",    PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",    Hidden:0,  Width:80,  Align:"Right",   ColMerge:1,   SaveName:"pay_if_amt",      KeyField:0,     CalcLogic:"",   Format:"Float",    PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:110, Align:"Center",  ColMerge:0,   SaveName:"rmk",   	 		UpdateEdit:0,   InsertEdit:0 }];
                 
                InitColumns(cols);
                SetSheetHeight(400);
                break;
            }
            SetWaitImageVisible(0);
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case IBSEARCH:       // 조회
                frmObj.f_cmd.value=SEARCH;
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0105GS.do", FormQueryString(frmObj)).split("|$$|");
                for (var i=0; i< xmlStr.length; i++) {
                    sheetObjects[i].LoadSearchData(xmlStr[i],{Sync:1} );
                    if (i == xmlStr.length) window.scrollTo(0, 0);

                }
                frmObj.non_ddc_rev.value=ComAddComma2(frmObj.non_ddc_rev.value==""?"0":frmObj.non_ddc_rev.value, "#,###.00"); //Non Deducted Rev.
                frmObj.ttl_chr_ddc.value=ComAddComma2(frmObj.ttl_chr_ddc.value==""?"0":frmObj.ttl_chr_ddc.value, "#,###.00"); //Total Charge Deduction
                frmObj.ttl_trs_ddc.value=ComAddComma2(frmObj.ttl_trs_ddc.value==""?"0":frmObj.ttl_trs_ddc.value, "#,###.00"); //Total Transportation Deduction
                frmObj.net_rev.value=ComAddComma2(frmObj.net_rev.value==""?"0":frmObj.net_rev.value, "#,###.00"); //Net Revenue
                break;
        }
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
   	 function box1sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 Office Select Object 생성
         doActionIBSheet(shtObj, document.form, IBSEARCH);
         window.scrollTo(0, 0);
     }
     /**
      * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
      * @param {shtObj} String : 해당 IBSheet Object
      * @param {ErrMsg} String : 조회 후 메시지
      */
     function box3sheet3_OnSearchEnd(shtObj, ErrMsg) {
    	 if (ErrMsg != "") return;
         var frmObj=document.form;
         var ttlQty=sheetObjects[1].ComputeSum("|2|"); //Total Q'ty
         frmObj.ttl_qty.value=ComAddComma2(ttlQty+'', "#,###.00");
     }
/* 개발자 작업 끝 */
