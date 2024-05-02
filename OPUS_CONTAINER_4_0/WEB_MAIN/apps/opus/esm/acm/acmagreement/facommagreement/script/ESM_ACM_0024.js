/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0024.js
*@FileTitle  : FAC Agreement Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
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
     * @class ESM_ACM_0024 : ESM_ACM_0024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var currentRow=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj=sheetObjects[0];
        var frmObj=document.form;
        var srcName=ComGetEvent("name");
        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(shtObj,frmObj,IBSEARCH);
                break;
            case "btn_save":
                doActionIBSheet(shtObj, frmObj, IBSAVE);
                break;
            case "btn_request":
                doActionIBSheet(shtObj,frmObj,IBSEARCH_ASYNC01);
                break;
            case "btn_approve":
                doActionIBSheet(shtObj,frmObj,IBSEARCH_ASYNC02);
                break;
            case "btn_reject":
                doActionIBSheet(shtObj,frmObj,IBSEARCH_ASYNC03);
                break;
            case "btn_uploadexcel":
                if (!ComChkValid(frmObj)) return;//조건절 office 설정 여부 체크
                shtObj.LoadExcel({Append:1});
                break;
            case "btn_downexcel":
                ComOpenWait(true);if(shtObj.RowCount() < 1){//no data
                	ComShowCodeMessage("COM132501");
                }else{
//                	shtObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false,
//                		DownCols:'3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49'
//                			});
                	shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
                }
                ComOpenWait(false);
                break;
            case "btn_copy":
            	if(sheetObjects[0].RowCount()<1){
            		 ComShowCodeMessage("ACM00032");
            	}
                var newRow=shtObj.DataCopy();
                setCellData( shtObj, newRow );
                setGetCellEditable( shtObj, newRow );
                setFacDivCd( shtObj, newRow, "fac_div_cd" );
                checkSglFlg( shtObj, newRow );
                break;
            case "btn_add":
                if (!ComChkValid(frmObj)) return;//조건절 office 설정 여부 체크
                var newRow=shtObj.DataInsert();
                shtObj.SetCellValue(newRow, "fac_ofc_cd",frmObj.ar_ofc_cd.value,0);// 조회 조건의 Office를 fac_ofc_cd로 설정한다.
                shtObj.SetCellValue(newRow, "shpr_cnt_seq","*",0);
                shtObj.SetCellValue(newRow, "por_rout_cd","*",0);
                shtObj.SetCellValue(newRow, "pol_rout_cd","*",0);
                shtObj.SetCellValue(newRow, "pod_rout_cd","*",0);
                shtObj.SetCellValue(newRow, "del_rout_cd","*",0);
                shtObj.SetCellValue(newRow, "svc_scp_cd","*",0);
                shtObj.SetCellValue(newRow, "fm_eff_dt","20000101",0);
                shtObj.SetCellValue(newRow, "to_eff_dt","29991231",0);
                shtObj.SetCellValue(newRow, "sc_no","*",0);
                shtObj.SetCellValue(newRow, "rfa_no","*",0);
                shtObj.SetCellValue(newRow, "cmdt_cd","*",0);
                //shtObj.CellValue(newRow, "cmdt_nm") = "*";
                shtObj.SetCellValue(newRow, "fac_sts_cd","RS",0);//New
                shtObj.SetCellEditable(newRow, "check",0);
                setFacDivCd( shtObj, newRow, "fac_div_cd" );
                // F/Forwarder 디폴트 값으로 설정
                doActionIBSheet(shtObj,frmObj,IBINSERT,newRow);
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
        initControl();
        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
        sheet1_OnLoadFinish(sheet1);
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
                	   var HeadTitle0="Del.|CHK|STS|SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|DEL TP|DEL|RCV Term|DEL Term|S.F.|D.F.|All in Rate|Scope|Eff.Date|Exp.Date|SC No.|RFA No.|Commodity TP|Commodity|Commodity Name|Type|Rate|Special Rate1|Special Rate1|Special Rate2|Special Rate2|Cur|BL AMT|Box AMT|TEU AMT|FEU AMT|RTEU AMT|RFEU AMT|STEU AMT|SFEU AMT|Charge(Only for BS)|Status|Request ID|Approval ID|Approval Date|Remark||";
                	   var HeadTitle1="| |STS|SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|DEL TP|DEL|RCV Term|DEL Term|S.F.|D.F.|All in Rate|Scope|Eff.Date|Exp.Date|SC No.|RFA No.|Commodity TP|Commodity|Commodity Name|Type|Rate|CNTR TP|Rate|CNTR TP|Rate|Cur|BL AMT|Box AMT|TEU AMT|FEU AMT|RTEU AMT|RFEU AMT|STEU AMT|SFEU AMT|Charge(Only for BS)|Status|Request ID|Approval ID|Approval Date|Remark||";

                	   SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:0 } );

                	   var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                	   var headers = [ { Text:HeadTitle0, Align:"Center"},
                	                 { Text:HeadTitle1, Align:"Center"} ];
                	   InitHeaders(headers, info);

                	   var cols = [ {Type:"DelCheck",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"delchk" },
                	                {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check" },
                	                {Type:"Status",    Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                	                {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                	                {Type:"PopupEdit", Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"frt_cnt_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
                	                {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ff_lgl_eng_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	                {Type:"PopupEdit", Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"shpr_cnt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                	                {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"shpr_lgl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	                {Type:"Combo",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"por_grp_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"PopupEdit", Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"por_rout_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 , InputCaseSensitive:1},
                	                {Type:"Combo",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pol_grp_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"PopupEdit", Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_rout_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 , InputCaseSensitive:1},
                	                {Type:"Combo",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pod_grp_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"PopupEdit", Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_rout_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 , InputCaseSensitive:1},
                	                {Type:"Combo",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"del_grp_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"PopupEdit", Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_rout_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 , InputCaseSensitive:1},
                	                {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcv_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_de_term_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fac_sgl_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fac_dbl_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"all_in_rt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 , InputCaseSensitive:1},
                	                {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fm_eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"PopupEdit", Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                	                {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rfa_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
                	                {Type:"Combo",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"PopupEdit", Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                	                {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	                {Type:"Combo",     Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"fac_div_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_fac_rt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                	                {Type:"PopupEdit", Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"fac_spcl_cntr_tp_ctnt1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
                	                {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fac_spcl_cntr_rt1",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
                	                {Type:"PopupEdit", Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"fac_spcl_cntr_tp_ctnt2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
                	                {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fac_spcl_cntr_rt2",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
                	                {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                	                {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_fac_bl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                	                {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"fac_bx_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                	                {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"fac_teu_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                	                {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"fac_feu_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                	                {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"fac_rf_teu_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                	                {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"fac_rf_feu_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                	                {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"fac_spcl_teu_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                	                {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"fac_spcl_feu_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                	                {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"fac_chg_ctnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
                	                {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fac_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fac_rqst_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fac_apro_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                	                {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fac_apro_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	                {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"fac_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                	                {Type:"Text",      Hidden:1,  Width:0,    Align:"Left",    ColMerge:1,   SaveName:"fac_ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                	                {Type:"Text",      Hidden:1,  Width:0,    Align:"Left",    ColMerge:1,   SaveName:"fac_agmt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                	    
                	   InitColumns(cols);

                	   SetEditable(1);
                	   SetColProperty("fac_sgl_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
                	   SetColProperty("fac_dbl_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
                	   SetColProperty("all_in_rt_cd", {ComboText:"Y|N", ComboCode:"Y|N"} );
                	   SetColProperty("curr_cd", {ComboText:"USD|EUR", ComboCode:"USD|EUR"} );
                	   SetWaitImageVisible(0);
                	   SetColProperty("por_grp_tp_cd", {ComboText:proTpText, ComboCode:proTpCode} );
                	   SetColProperty("pol_grp_tp_cd", {ComboText:proTpText, ComboCode:proTpCode} );
                	   SetColProperty("pod_grp_tp_cd", {ComboText:proTpText, ComboCode:proTpCode} );
                	   SetColProperty("del_grp_tp_cd", {ComboText:proTpText, ComboCode:proTpCode} );
                	   SetColProperty(0 ,"por_rout_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                	   SetColProperty(0 ,"pol_rout_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                	   SetColProperty(0 ,"pod_rout_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                	   SetColProperty(0 ,"del_rout_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                	   SetColProperty("bkg_rcv_term_cd", {ComboText:"*|"+bkgRcvTermCdText, ComboCode:"*|"+bkgRcvTermCdCode} );
                	   SetColProperty("bkg_de_term_cd", {ComboText:"*|"+bkgDeTermCdText, ComboCode:"*|"+bkgDeTermCdCode} );
                	   SetColProperty("fac_div_cd", {ComboText:facDivCdText, ComboCode:facDivCdCode} );
                	   SetColProperty("cmdt_tp_cd", {ComboText:"*|Rep|Common", ComboCode:"*|2|3"} );
                	   SetColProperty("fac_sts_cd", {ComboText:"New|Requested|Approved|Rejected", ComboCode:"RS|RR|PS|RE"} );
                	   SetColProperty("fac_chg_ctnt" , {AcceptKeys:"E|[,]" , InputCaseSensitive:1});
                	   SetColProperty(0 ,"frt_cnt_seq" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                	   SetColProperty(0 ,"shpr_cnt_seq" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                	   SetShowButtonImage(3);
                	   SetEditEnterBehavior("tab");
                	   SetSheetHeight(465);
                    break;
            }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
//        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        var newRow=-1;
        switch (sAction) {
            case SEARCH01:       // agn_cd 조회
                // 로그인한 사용자의 rhq_cd로 agn_cd를 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH23);
                ACMXml2SelectItem(xmlStr, document.getElementById("ar_ofc_cd"), "value0", "value0", true);    // CoAcm.js에 정의
                break;
            case IBSEARCH:       	// 조회(Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                var sXml = sheetObjects[0].GetSearchData("ESM_ACM_0024GS.do", FormQueryString(frmObj) );
                sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
                if (frmObj.fac_sts_cd.value == "") {
                	ComBtnDisable("btn_save");
                	ComBtnDisable("btn_request");
                	ComBtnDisable("btn_approve");
                	ComBtnDisable("btn_reject");
                	ComBtnDisable("btn_uploadexcel");
                }else{
                	ComBtnEnable("btn_save");
                	ComBtnEnable("btn_request");
                	ComBtnEnable("btn_approve");
                	ComBtnEnable("btn_reject");
                	ComBtnEnable("btn_uploadexcel");
                }
            	//change_sts();                	
                break;
            case IBSAVE:        //저장
                if (!ComChkValid(frmObj)) return;
                if (!validateData(shtObj)) return;
        		var SaveStr=ComGetSaveString(shtObj);
        		if(SaveStr == undefined || SaveStr.length <= 0 ){
        			return;
        		}                
                frmObj.f_cmd.value=MULTI05;
                var sXml = shtObj.GetSaveData("ESM_ACM_0024GS.do", FormQueryString(frmObj) + "&" + ComGetSaveString(shtObj));
                if (ComGetEtcData(sXml, "cnt") == 0) {
                	ComOpenWait(true);
                	frmObj.f_cmd.value=MULTI;
                	shtObj.DoSave("ESM_ACM_0024GS.do", FormQueryString(frmObj));
                	ComOpenWait(false);
                	
                }else{
                	for (var i=0; i < ComGetEtcData(sXml, "cnt"); i++) {
            			var idx=shtObj.FindText("seq", ComGetEtcData(sXml, i+""), 0, -1, 1);
            			if (idx > 1) {
            				sheetObjects[0].SetRangeBackColor(idx, 3, idx, 52, "#FFFF00");
            			}                		
                	}
                  ComOpenWait(false);
                  ComShowCodeMessage("ACM00034", "Row Data");
                }
                break;
            case IBSEARCH_ASYNC01:      //REQUEST
                if (!ComChkValid(frmObj)) return;
                frmObj.f_cmd.value=MULTI04;
                var cnt=checkData("RR");
                if( cnt > 0 ) {
                    if(ComShowCodeConfirm("ACM00026", "Request "+cnt, "request") == 1) {
                        shtObj.DoSave("ESM_ACM_0024GS.do", FormQueryString(frmObj), "check", false);
                    }
                } else {
                    ComShowCodeMessage("ACM00012", "request");
                    //ComShowMessage("There is no contents to request");
                }
                break;
            case IBSEARCH_ASYNC02:      //APPROVE
                if (!ComChkValid(frmObj)) return;
                frmObj.f_cmd.value=MULTI02;
                var cnt=checkData("PS");
                if( cnt > 0 ) {
                    if(ComShowCodeConfirm("ACM00026", "Approval "+cnt, "approve") == 1) {
                        shtObj.DoSave("ESM_ACM_0024GS.do", FormQueryString(frmObj), "check", false);
                    }
                } else {
                    ComShowCodeMessage("ACM00012", "approve");
                    //ComShowMessage("There is no contents to approve");
                }
                break;
            case IBSEARCH_ASYNC03:        //REJECT
                if (!ComChkValid(frmObj)) return;
                frmObj.f_cmd.value=MULTI03;
                var cnt=checkData("RE");
                if( cnt > 0 ) {
                    if(ComShowCodeConfirm("ACM00026", "Reject "+cnt, "reject") == 1) {
                        shtObj.DoSave("ESM_ACM_0024GS.do", FormQueryString(frmObj), "check", false);
                    }
                } else {
                    ComShowCodeMessage("ACM00012", "reject");
                    //ComShowMessage("There is no contents to reject");
                }
                break;
            case IBINSERT:      // 입력
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + frmObj.ofc_cd.value);
                if (ACMDecideErrXml(shtObj, xmlStr)) return;
                //추가된 Row에 데이터 할당
                addRowData(CondParam, ComGetEtcData(xmlStr, "loc_cd").substring(0, 2));//(newRow, cntCd)
                break;
        }
    }
    
    function sheet1_OnSearchEnd(shtObj , code , msg ) {
    	
    	ComOpenWait(false);
    	
    	var frmObj=document.form;
    	
    	//Status에 따른 컬럼별 편집모드 설정
        var mod=frmObj.mod.value;
        var rows=shtObj.RowCount()+ 2;
        for(var i=2; i<rows; i++){
			var sts=shtObj.GetCellValue(i,"fac_sts_cd");
			var div=shtObj.GetCellValue(i,"fac_div_cd");
			var facSqlFlg=shtObj.GetCellValue(i,"fac_sgl_flg");
			var facDblFlg=shtObj.GetCellValue(i,"fac_dbl_flg");
			var allInRtCd=shtObj.GetCellValue(i,"all_in_rt_cd");
			
            if((mod == "Y" && (sts == "RR" || sts == "RS")) || (mod == "N" && sts == "RS")){
                //(Approval 권한 : Y 이고 NEW or REQUEST) 혹은  (Approval 권한 : N 이고 NEW)
                shtObj.SetCellEditable(i, "shpr_cnt_seq",1);
                shtObj.SetCellEditable(i, "shpr_lgl_eng_nm",1);
                shtObj.SetCellEditable(i, "por_grp_tp_cd",1);
                shtObj.SetCellEditable(i, "por_rout_cd",1);
                shtObj.SetCellEditable(i, "pol_grp_tp_cd",1);
                shtObj.SetCellEditable(i, "pol_rout_cd",1);
                shtObj.SetCellEditable(i, "pod_grp_tp_cd",1);
                shtObj.SetCellEditable(i, "pod_rout_cd",1);
                shtObj.SetCellEditable(i, "del_grp_tp_cd",1);
                shtObj.SetCellEditable(i, "del_rout_cd",1);
                shtObj.SetCellEditable(i, "bkg_rcv_term_cd",1);
                shtObj.SetCellEditable(i, "bkg_de_term_cd",1);
                shtObj.SetCellEditable(i, "fac_sgl_flg",1);
                shtObj.SetCellEditable(i, "fac_dbl_flg",1);
                //shtObj.CellEditable(i, "fac_sgl_flg")     = true;
                //shtObj.CellEditable(i, "fac_dbl_flg")     = true;f
                shtObj.SetCellEditable(i, "all_in_rt_cd",1);
                shtObj.SetCellEditable(i, "svc_scp_cd",1);
                shtObj.SetCellEditable(i, "fm_eff_dt",1);
                shtObj.SetCellEditable(i, "to_eff_dt",1);
                shtObj.SetCellEditable(i, "sc_no",1);
                shtObj.SetCellEditable(i, "rfa_no",1);
                shtObj.SetCellEditable(i, "cmdt_tp_cd",1);
                shtObj.SetCellEditable(i, "cmdt_cd",1);
                shtObj.SetCellEditable(i, "cmdt_nm",1);
//                if(allInRtCd == "Y"){
//                    shtObj.CellValue(i,"fac_div_cd") = "BA";
//                    shtObj.CellEditable(i, "fac_div_cd")  = false;
//                }else{
                    shtObj.SetCellEditable(i, "fac_div_cd",1);
//                }
                // DF, SF 중 둘중 하나가 Y이면 나머지는 편집불가
//                if(facSqlFlg == "Y"){
//                    shtObj.SetCellEditable(i, "fac_dbl_flg",0);
//                }else{
//                    shtObj.SetCellEditable(i, "fac_dbl_flg",1);
//                }
//                if(facDblFlg == "Y"){
//                    shtObj.SetCellEditable(i, "fac_sgl_flg",0);
//                }else{
//                    shtObj.SetCellEditable(i, "fac_sgl_flg",1);
//                }
                switch(div) {
                    case "BA":
                    case "BF":
                        shtObj.SetCellEditable(i, "bkg_fac_rt",1);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt1",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_rt1",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt2",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_rt2",0);
                        shtObj.SetCellEditable(i, "bkg_fac_bl_amt",0);
                        shtObj.SetCellEditable(i, "fac_bx_amt",0);
                        shtObj.SetCellEditable(i, "fac_teu_amt",0);
                        shtObj.SetCellEditable(i, "fac_feu_amt",0);
                        shtObj.SetCellEditable(i, "fac_rf_teu_amt",0);
                        shtObj.SetCellEditable(i, "fac_rf_feu_amt",0);
                        shtObj.SetCellEditable(i, "fac_chg_ctnt",0);
                        shtObj.SetCellEditable(i, "curr_cd",0);
                        break;
                    case "BS":
                        shtObj.SetCellEditable(i, "bkg_fac_rt",1);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt1",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_rt1",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt2",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_rt2",0);
                        shtObj.SetCellEditable(i, "bkg_fac_bl_amt",0);
                        shtObj.SetCellEditable(i, "fac_bx_amt",0);
                        shtObj.SetCellEditable(i, "fac_teu_amt",0);
                        shtObj.SetCellEditable(i, "fac_feu_amt",0);
                        shtObj.SetCellEditable(i, "fac_rf_teu_amt",0);
                        shtObj.SetCellEditable(i, "fac_rf_feu_amt",0);
                        shtObj.SetCellEditable(i, "fac_chg_ctnt",1);
                        shtObj.SetCellEditable(i, "curr_cd",0);
                        break;
                    case "BL":
                        shtObj.SetCellEditable(i, "bkg_fac_rt",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt1",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_rt1",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt2",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_rt2",0);
                        shtObj.SetCellEditable(i, "bkg_fac_bl_amt",1);
                        shtObj.SetCellEditable(i, "fac_bx_amt",0);
                        shtObj.SetCellEditable(i, "fac_teu_amt",0);
                        shtObj.SetCellEditable(i, "fac_feu_amt",0);
                        shtObj.SetCellEditable(i, "fac_rf_teu_amt",0);
                        shtObj.SetCellEditable(i, "fac_rf_feu_amt",0);
                        shtObj.SetCellEditable(i, "fac_chg_ctnt",0);
                        shtObj.SetCellEditable(i, "curr_cd",1);
                        break;
                    case "CA":
                        shtObj.SetCellEditable(i, "bkg_fac_rt",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt1",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_rt1",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt2",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_rt2",0);
                        shtObj.SetCellEditable(i, "bkg_fac_bl_amt",0);
                        shtObj.SetCellEditable(i, "fac_bx_amt",1);
                        shtObj.SetCellEditable(i, "fac_teu_amt",0);
                        shtObj.SetCellEditable(i, "fac_feu_amt",0);
                        shtObj.SetCellEditable(i, "fac_rf_teu_amt",0);
                        shtObj.SetCellEditable(i, "fac_rf_feu_amt",0);
                        shtObj.SetCellEditable(i, "fac_chg_ctnt",0);
                        shtObj.SetCellEditable(i, "curr_cd",1);
                        break;
                    case "CS":
                        shtObj.SetCellEditable(i, "bkg_fac_rt",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt1",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_rt1",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt2",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_rt2",0);
                        shtObj.SetCellEditable(i, "bkg_fac_bl_amt",0);
                        shtObj.SetCellEditable(i, "fac_bx_amt",0);
                        shtObj.SetCellEditable(i, "fac_teu_amt",1);
                        shtObj.SetCellEditable(i, "fac_feu_amt",1);
                        shtObj.SetCellEditable(i, "fac_rf_teu_amt",1);
                        shtObj.SetCellEditable(i, "fac_rf_feu_amt",1);
                        shtObj.SetCellEditable(i, "fac_chg_ctnt",0);
                        shtObj.SetCellEditable(i, "curr_cd",1);
                        break;
                    case "DR":
                        shtObj.SetCellEditable(i, "bkg_fac_rt",0);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt1",1);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_rt1",1);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt2",1);
                        shtObj.SetCellEditable(i, "fac_spcl_cntr_rt2",1);
                        shtObj.SetCellEditable(i, "bkg_fac_bl_amt",0);
                        shtObj.SetCellEditable(i, "fac_bx_amt",0);
                        shtObj.SetCellEditable(i, "fac_teu_amt",0);
                        shtObj.SetCellEditable(i, "fac_feu_amt",0);
                        shtObj.SetCellEditable(i, "fac_rf_teu_amt",0);
                        shtObj.SetCellEditable(i, "fac_rf_feu_amt",0);
                        shtObj.SetCellEditable(i, "fac_chg_ctnt",1);
                        shtObj.SetCellEditable(i, "curr_cd",0);
                        break;
                }
            }else{
                //편집불가모드
                shtObj.SetCellEditable(i, "delchk",0);            	
                shtObj.SetCellEditable(i, "shpr_cnt_seq",0);
                shtObj.SetCellEditable(i, "shpr_lgl_eng_nm",0);
                shtObj.SetCellEditable(i, "por_grp_tp_cd",0);
                shtObj.SetCellEditable(i, "por_rout_cd",0);
                shtObj.SetCellEditable(i, "pol_grp_tp_cd",0);
                shtObj.SetCellEditable(i, "pol_rout_cd",0);
                shtObj.SetCellEditable(i, "pod_grp_tp_cd",0);
                shtObj.SetCellEditable(i, "pod_rout_cd",0);
                shtObj.SetCellEditable(i, "del_grp_tp_cd",0);
                shtObj.SetCellEditable(i, "del_rout_cd",0);
                shtObj.SetCellEditable(i, "bkg_rcv_term_cd",0);
                shtObj.SetCellEditable(i, "bkg_de_term_cd",0);
                shtObj.SetCellEditable(i, "fac_sgl_flg",0);
                shtObj.SetCellEditable(i, "fac_dbl_flg",0);
                shtObj.SetCellEditable(i, "all_in_rt_cd",0);
                shtObj.SetCellEditable(i, "svc_scp_cd",0);
                shtObj.SetCellEditable(i, "fm_eff_dt",0);
                shtObj.SetCellEditable(i, "to_eff_dt",0);
                shtObj.SetCellEditable(i, "sc_no",0);
                shtObj.SetCellEditable(i, "rfa_no",0);
                shtObj.SetCellEditable(i, "cmdt_tp_cd",0);
                shtObj.SetCellEditable(i, "cmdt_cd",0);
                shtObj.SetCellEditable(i, "cmdt_nm",0);
                shtObj.SetCellEditable(i, "fac_div_cd",0);

                shtObj.SetCellEditable(i, "bkg_fac_rt",0);
                
                shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt1",0);
                shtObj.SetCellEditable(i, "fac_spcl_cntr_rt1",0);
                shtObj.SetCellEditable(i, "fac_spcl_cntr_tp_ctnt2",0);
                shtObj.SetCellEditable(i, "fac_spcl_cntr_rt2",0);
                shtObj.SetCellEditable(i, "curr_cd",0);
                
                shtObj.SetCellEditable(i, "bkg_fac_bl_amt",0);
                shtObj.SetCellEditable(i, "fac_bx_amt",0);
                shtObj.SetCellEditable(i, "fac_teu_amt",0);
                shtObj.SetCellEditable(i, "fac_feu_amt",0);
                shtObj.SetCellEditable(i, "fac_rf_teu_amt",0);
                shtObj.SetCellEditable(i, "fac_rf_feu_amt",0);
                shtObj.SetCellEditable(i, "fac_spcl_teu_amt",0);
                shtObj.SetCellEditable(i, "fac_spcl_feu_amt",0);
                shtObj.SetCellEditable(i, "fac_rmk",0);
                
            }//if((mod == "Y" && (sts == "RR" || sts == "RN")) || (mod == "N" && sts == "RN")){
        }//for(var i=0; i<rows; i++)
    }
    
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet1_OnLoadFinish(shtObj) {
        // 조회조건의 Office Select Object 생성
        doActionIBSheet(shtObj, document.form, SEARCH01);
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }
    /**
     * 엑셀에서 데이터를 모두 읽어들였을때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     */
    function sheet1_OnLoadExcel(shtObj, result, code, msg) {
    	if(isExceedMaxRow(msg))return;
        var rows=shtObj.RowCount()+ 2;
        var tmp_ofc_cd=document.form.ar_ofc_cd.value;
        for(var i=2; i<rows; i++) {
            shtObj.SetCellValue(i, "fac_ofc_cd",tmp_ofc_cd,0);// 조회 조건의 Office를 fac_ofc_cd로 설정한다.
	        if( shtObj.GetRowStatus(i).toUpperCase() == "I" ) {
	            shtObj.SetCellValue(i, "fac_rqst_usr_id","",0);
	            shtObj.SetCellValue(i, "fac_apro_usr_id","",0);
	            shtObj.SetCellValue(i, "fac_apro_dt","",0);
	        }
        }
    }
    /**
     * Form Element의 OnChange 이벤트
     */ 
    function frmObj_OnChange() {
        var elementName=ComGetEvent("name");     
        var shtObj=sheetObjects[0];
        with (document.form) {
            switch (elementName) {
                case "ar_ofc_cd":
                    shtObj.RemoveAll();
                    break;
            }
        }
    }
    /**
     * Grid 입력값에 대한 OnChange Event 처리
     */
    var oldFfChgCtntVal = "";
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        if (Value == "") {
        	with (sheetObj) {
        		var saveNm = ColSaveName(Col);
        		switch (saveNm) {
        			case "fac_chg_ctnt":
        				oldFfChgCtntVal = "";
        				break;
        			case "shpr_cnt_seq":
                    	SetCellValue(Row, "shpr_lgl_eng_nm", "", 0);                		
        				break;
        			case "frt_cnt_seq":
                    	SetCellValue(Row, "ff_lgl_eng_nm", "", 0);                		
        				break;        				
        			case "cmdt_cd":
        				SetCellValue(Row, "cmdt_nm", "", 0);                		
        				break;        				
        		}
        	}        	
        	return;
        }
        with(sheetObj) {
            var saveNm=ColSaveName(Col);
            switch (saveNm) {
                case "frt_cnt_seq":
                    // validation
                    if (!ComIsNumber(Value.substring(2))) {
                        ComShowCodeMessage("ACM00003", "Customer Code [" + Value + "]", "Customer Code");
                        SetCellValue(Row, "ff_lgl_eng_nm", "", 0);                            
                        SelectCell(Row, Col, true, "");
                        return;
                    }
                    var xmlStr=GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH17 + "&value0=" + Value);
                    if (ACMDecideErrXml(sheetObj, xmlStr)) {
                        //Cellvalue2(Row, "ff_lgl_eng_nm")="";
                    	SetCellValue(Row, Col, "", 0);
                        SelectCell(Row, Col, true, "");
                    } else {
                        SetCellValue(Row, "ff_lgl_eng_nm",ComGetEtcData(xmlStr, "cust_lgl_eng_nm"),0);
                    }
                    break;
                case "shpr_cnt_seq":
                    // validation
                    if (!ComIsNumber(Value.substring(2))) {
                        ComShowCodeMessage("ACM00003", "Customer Code [" + Value + "]", "Customer Code");
                        SetCellValue(Row, "shpr_lgl_eng_nm", "", 0);                            
                        SelectCell(Row, Col, true, "");
                        return;
                    }
                    var xmlStr=GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH17 + "&value0=" + Value);
                    if (ACMDecideErrXml(sheetObj, xmlStr)) {
                        //Cellvalue2(Row, "shpr_lgl_eng_nm")="";
                    	SetCellValue(Row, Col, "", 0);
                        SelectCell(Row, Col, true, "");
                    } else {
                        SetCellValue(Row, "shpr_lgl_eng_nm",ComGetEtcData(xmlStr, "cust_lgl_eng_nm"),0);
                    }
                    break;
                case "por_grp_tp_cd":
                case "pol_grp_tp_cd":
                case "pod_grp_tp_cd":
                case "del_grp_tp_cd":
                    if(Value == 5) {
                        SetCellValue(Row, (parseInt(Col)+1),"",0);
                        //sheet1_OnPopupClick(sheetObj, Row, Col+1);
                    } else {
                        SetCellValue(Row, (parseInt(Col)+1),"*",0);
                    }
                    break;
                case "cmdt_tp_cd":
                    SetCellValue(Row, (parseInt(Col)+1),"*",0);
                    SetCellValue(Row, (parseInt(Col)+2),"",0);
                    break;
                case "fac_div_cd":
                    setFacDivCd( sheetObj, Row, Col );
                    break;
//                case "all_in_rt_cd":
//                    if( Value == "Y" ) {
//                        CellValue(Row, "fac_div_cd") = "BA";
//                        CellEditable(Row, "fac_div_cd") = false;
//                    } else {
//                       CellValue(Row, "fac_div_cd") = "BF";
//                       CellEditable(Row, "fac_div_cd") = true;
//                    }
//                    break;
                case "por_rout_cd":
                case "pol_rout_cd":
                case "pod_rout_cd":
                case "del_rout_cd":
                    checkSglFlg( sheetObj, Row, Col );
                    break;
                case "fac_dbl_flg":
                    // DF == 'Y' 이면 SF == 'Y' 이다.
                    if( ComTrim(Value) != "" && ComTrim(Value) == "Y" ) {
                        //CellValue(Row, "fac_sgl_flg") = "Y";
                        SetCellEditable(Row, "fac_sgl_flg",0);
                    }else {
                        SetCellEditable(Row, "fac_sgl_flg",1);
                    }
                    break;
                case "fac_sgl_flg":
                    // SF 수정시 DF == 'Y' 이면 SF는 항상 'Y'이다.
                    if( ComTrim(Value) != "" && ComTrim(Value) == "Y" ) {
                        //CellValue(Row, "fac_sgl_flg") = "Y";
                        SetCellEditable(Row, "fac_dbl_flg",0);
                    }else{
                        SetCellEditable(Row, "fac_dbl_flg",1);
                    }
                    break;
                case "fm_eff_dt":
                	if( GetCellValue(Row,"fm_eff_dt") > GetCellValue(Row,"to_eff_dt") ) {
                        ComShowCodeMessage("ACM00017", "Eff. Date", "Exp. Date");
                        //ComShowMessage("Eff. Date is later than Exp. Date. Please check Eff. Or Exp. Date.");
                        SelectCell(Row, Col, true, "");
                    }
                    break;
                case "to_eff_dt":
                	if( GetCellValue(Row,"fm_eff_dt") > GetCellValue(Row,"to_eff_dt") ) {
                        ComShowCodeMessage("ACM00018", "Exp. Date", "Eff. Date");
                        //ComShowMessage("Exp. Date is earlier than Eff. Date. Please check Eff. Or Exp. Date.");
                        SelectCell(Row, Col, true, "");
                    }
                    break;
                case "sc_no":
                    if( !("*" == Value) && !/[A-Z]{3}[0-9]{5}/.test(Value) ) {
                        ComShowCodeMessage("ACM00003", "SC No.", "SC No.");
                        SelectCell(Row, Col, true, "*");
                    }
                    break;
                case "rfa_no":
                    if( !("*" == Value) && !/[A-Z]{3}[0-9]{2}[A-Z]{1}[0-9]{4}/.test(Value) ) {
                        ComShowCodeMessage("ACM00003", "RFA No.", "RFA No.");
                        SelectCell(Row, Col, true, "*");
                    }
                    break;
                case "cmdt_cd": // 입력값 Validation 체크
                	var cmdt_tp=ComTrim(sheetObj.GetCellValue(Row, "cmdt_tp_cd"));
                    if(cmdt_tp == "*") {
                         ComShowCodeMessage("COM12113", "Commodity Type", "", "");
//                         Cellvalue2(Row, Col)="*";
                         SetCellValue(Row, Col, "*", 0);                            
                         SelectCell( Row, parseInt(Col)-1 );
                         return;
                    }
                    var xmlStr=GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH19 + "&value0=" + cmdt_tp + "&value1=" + Value);
                    if (ACMDecideErrXml(sheetObj, xmlStr)) {
                        SelectCell(Row, Col, true, "");
                        SetCellValue(Row, Col, "", 0);
                    } else {
                        var rsltCmdtNm=ComGetEtcData(xmlStr, "cmdt_nm");
                        if ( rsltCmdtNm != "") {
                            SetCellValue(Row, "cmdt_nm", rsltCmdtNm, 0);                            
                        } else {
                            // Commodity Code is invalid.
                            ComShowCodeMessage("COM132201", "Commodity Code");
                            SelectCell(Row, Col, true, "");
                        }
                    }
                    break;
                case "fac_spcl_cntr_tp_ctnt1": // 입력값 Validation 체크
                case "fac_spcl_cntr_tp_ctnt2": // 입력값 Validation 체크
                    var facCtntTpArr=Value.split(",");
                    var facCtntTpVal="'";
                    for(i=0; i<facCtntTpArr.length; i++) {
                        if(i == facCtntTpArr.length-1) {
                            facCtntTpVal += facCtntTpArr[i]+"'";
                        } else {
                            facCtntTpVal += facCtntTpArr[i]+"','";
                        }
                    }
                    var xmlStr=GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH21 + "&value0=" + facCtntTpVal);
                    if (ACMDecideErrXml(sheetObj, xmlStr)) {
                        SelectCell(Row, Col, true, "");
                        SetCellValue(Row, Col, "", 0);
                    } else {
                        // MDM_CNTR_TP 테이블에 값이 존재하지 않으면, Message
                        if (ComGetEtcData(xmlStr, "cnt") != facCtntTpArr.length) {
                            //"{?msg1} is invalid."
                            ComShowCodeMessage("COM132201", "Container TP code ["+Value+"]");
                            SelectCell(Row, Col, true, "");
                        }
                    }
                    break;
                case "fac_chg_ctnt": // 입력값 Validation 체크
                	var fac_div_cd=GetCellValue(Row, "fac_div_cd");
                    if( fac_div_cd == "BS" || fac_div_cd == "DR") { // fac_div_cd 이 'BS', 'DR' 인 경우 Charge를 체크 한다.
                        if( !checkCHG( sheetObj, Row, "fac_chg_ctnt") ) {
                            SelectCell( Row, Col, "" );
                            return;
                        }
                    }
                    if( fac_div_cd == "DR") {
                        if( !checkManCHG( sheetObj, Row, "fac_chg_ctnt" ) ) {
                            SelectCell( Row, Col, "" );
                            return;
                        }
                    }
                    var facChgCtntArr=Value.split(",");
                    var facChgCtntVal="";
                    for(i=0; i<facChgCtntArr.length; i++) {
                        if(i == facChgCtntArr.length-1) {
                            facChgCtntVal += facChgCtntArr[i];
                        } else {
                            facChgCtntVal += facChgCtntArr[i]+"','";
                        }
                    }
                    var xmlStr=GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH20 + "&value0=" + "'"+facChgCtntVal+"'"+ "&value1=" +facChgCtntArr.length);
                    if (ACMDecideErrXml(sheetObj, xmlStr)) {
                        //Cellvalue2(Row, "fac_chg_ctnt")="";
                    	SetCellValue(Row, Col, "", 0);
                        SelectCell(Row, Col, true, "");
                    } else {
                        // MDM_CHARGE 테이블에 값이 존재하지 않으면, Message
                        if (ComGetEtcData(xmlStr, "err_cnt") == "0") {
                        	oldFfChgCtntVal = 	Value;
                        } else {
                            //"{?msg1} is invalid."
                            ComShowCodeMessage("COM132201", "Charge code ["+Value+"]");
                            
                            SelectCell(Row, Col, true, "");
                            SetCellValue(Row, "fac_chg_ctnt", oldFfChgCtntVal);
                            
                            
                        }
                    }
                    break;
            }
        }
    }
    /**
     * Grid에서 OnPopupClick Event 처리
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var saveNm=sheetObj.ColSaveName(Col);
        var func="setPopupData";
        var width=775;
        var height=482;
        switch (saveNm) {
            case "frt_cnt_seq":
            case "shpr_cnt_seq":
                var cust_cd="";
                var display="1,0,1";
                var url="COM_ENS_041.do";
             // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                ComOpenPopup("COM_ENS_041.do", 775, 445, func, "1,0,1,1,1,1,1", false, false, Row, Col, 0);
                break;
            case "por_rout_cd":
            case "pol_rout_cd":
            case "pod_rout_cd":
            case "del_rout_cd":
            	var grp_tp=sheetObj.GetCellValue(Row, parseInt(Col)-1);
                var display="1,0,1,1,1,1,1";
                var url="";
                if( grp_tp == "1" ) {
                    width=700;
                    height=382;
                    url="COM_ENS_0H1.do";
                } else if( grp_tp == "2" ) {
                    width=700;
                    height=450;
                    url="COM_ENS_0I1.do";
                } else if( grp_tp == "3" ) {
                    width=600;
                    height=484;
                    url="COM_ENS_0M1.do";
                } else if( grp_tp == "4" ) {
                    width=700;
                    height=500;
                    url="COM_ENS_0J1.do";
                } else if( grp_tp == "5" ) {
                    width=775;
                    height=525;
                    url="COM_ENS_051.do";
                } else {
                    if( saveNm == "por_rout_cd" ) {
                        ComShowMessage(ComGetMsg("COM12113", "POR TYPE", "", ""));
                    } else if( saveNm == "pol_rout_cd" ) {
                        ComShowMessage(ComGetMsg("COM12113", "POL TYPE", "", ""));
                    } else if( saveNm == "pod_rout_cd" ) {
                        ComShowMessage(ComGetMsg("COM12113", "POD TYPE", "", ""));
                    } else if( saveNm == "del_rout_cd" ) {
                        ComShowMessage(ComGetMsg("COM12113", "DEL TYPE", "", ""));
                    }
                    sheetObj.SelectCell( Row, parseInt(Col)-1 );
                    return false;
                }
                ComOpenPopup(url, width, height, func, display, false, false, Row, Col, 0);
                break;
            case "cmdt_cd":
                var display="1,0,1";
                var url="";
                var cmdt_tp=ComTrim(sheetObj.GetCellValue(Row, "cmdt_tp_cd"));
                if(cmdt_tp == "2") {
                    width=706;
                    height=430;
                    url="COM_ENS_0K1.do";
                } else if(cmdt_tp == "3") {
                    width=775;
                    height=482;
                    url="COM_ENS_011.do";
                } else {
                    ComShowCodeMessage("COM12113", "Commodity Type", "", "");
                    sheetObj.SelectCell( Row, Col-1 );
                    return false;
                }
                ComOpenPopup(url, width, height, func, display, false, false, Row, Col, 0);
                break;
            case "sc_no":
                var bkgNo="";
                var bkgVvd="";
                var porCd="";
                var delCd="";
                var sCustCntCd="";
                var sCustSeq="";
                var cCustCntCd="";
                var cCustSeq="";
                document.form.rowNum.value=Row;
                document.form.colNum.value=Col;
                var func="sheet1_setSheetData";
                var display="1,0,1,1,1,1,1,1,1,1,1,1";
                var url="";
                url="ESM_BKG_0655.do?pgmNo=ESM_BKG_0655&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&func="+func;
                ComOpenPopup(url, 860, 475, func, display, false, false, Row, Col, 0);
                break;
            case "rfa_no":
                var bkgNo="";
                var bkgVvd="";
                var porCd="";
                var delCd="";
                var sCustCntCd="";
                var sCustSeq="";
                var cCustCntCd="";
                var cCustSeq="";
                document.form.rowNum.value=Row;
                document.form.colNum.value=Col;
                var func="sheet1_setSheetData";
                var display="1,0,1,1,1,1,1,1,1,1,1,1";
                var url="";
                url="ESM_BKG_0654.do?pgmNo=ESM_BKG_0655&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&func="+func;
                ComOpenPopup(url, 860, 475, func, display, false, false, Row, Col, 0);
                break;
            case "fac_spcl_cntr_tp_ctnt1":
            case "fac_spcl_cntr_tp_ctnt2":
            	var ctntVal=sheetObj.GetCellValue(Row, Col);
                //ComOpenPopup(url, width, height, "setPopupData", display, modal, b2ndSheet, Row, Col);
                ComOpenPopup("ESM_ACM_0104.do?fac_spcl_cntr_tp_ctnt="+ctntVal, 450, 450, func, "0,1,1,1,1", false, false, Row, Col, 0);
                break;
        }
    }
    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData[0] : {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
     * @param ShtIdx : 대상IBSheet의 Sheet Array index
     */
    function setPopupData(aryPopupData, Row, Col, ShtIdx) {
        if (aryPopupData[0].length > 0 ) {
            with (sheetObjects[ShtIdx]) {
                switch (ColSaveName(Col)) {
                    case "frt_cnt_seq":
                    case "shpr_cnt_seq":
                        SetCellValue(Row, Col,aryPopupData[0][3].substring(0, 2) + ComLpad(aryPopupData[0][3].substring(2), 6, "0"),0);
                        SetCellValue(Row, parseInt(Col)+1,aryPopupData[0][4],0);
                        break;
                    case "por_rout_cd":
                    case "pol_rout_cd":
                    case "pod_rout_cd":
                    case "del_rout_cd":
                        SetCellValue(Row, Col,aryPopupData[0][3]);
                        break;
                    case "cmdt_cd":
                    	switch (GetCellValue(Row, parseInt(Col)-1)) {
                            case "2":
                                SetCellValue(Row, Col,aryPopupData[0][3]);
                                SetCellValue(Row, parseInt(Col)+1,aryPopupData[0][4]);
                                break;
                            case "3":
                                SetCellValue(Row, Col,aryPopupData[0][2]);
                                SetCellValue(Row, parseInt(Col)+1,aryPopupData[0][3]);
                                break;
                        }
                        break;
        			case "fac_spcl_cntr_tp_ctnt1":
        			case "fac_spcl_cntr_tp_ctnt2":
        			    var cellVal = "";
        			    for (var i=0; i<aryPopupData.length; i++) {
        			    	if(cellVal.length > 0) {
        			    		cellVal=cellVal + "," + aryPopupData[i][3];
        				    } else {
        				    	cellVal=aryPopupData[i][3];
        				    }
        			    }
        				SetCellValue(Row, Col, cellVal);
        				break;                }
            }
        }
    }
    /**
     * 저장 버튼 클릭시 유효성검증 프로세스 처리
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {
        var f_cmd=document.form.f_cmd.value;
        var val=ComTrim(Value);
        var subValue="";
        if(f_cmd == MULTI) { // 저장시에만 체크한다.
            with(sheetObj) {
                var saveNm=ColSaveName(Col);
                var ibStatus=GetRowStatus(Row);
                if( ibStatus.toUpperCase() == "I" || ibStatus.toUpperCase() == "U" ) {
                    switch (saveNm) {
                        case "por_grp_tp_cd":
                        case "pol_grp_tp_cd":
                        case "pod_grp_tp_cd":
                        case "del_grp_tp_cd":
                        case "cmdt_tp_cd":
                            if( val.length > 0 && val != "*" ) {
                            	subValue=ComTrim(GetCellValue(Row, Col+1));
                                if( subValue == "" || subValue == "*") {
                                    if(saveNm=="por_grp_tp_cd") {
                                        ComShowMessage(ComGetMsg("COM130201", "POR", "", ""));
                                    } else if(saveNm=="pol_grp_tp_cd") {
                                        ComShowMessage(ComGetMsg("COM130201", "POL", "", ""));
                                    } else if(saveNm=="pod_grp_tp_cd") {
                                        ComShowMessage(ComGetMsg("COM130201", "POD", "", ""));
                                    } else if(saveNm=="del_grp_tp_cd") {
                                        ComShowMessage(ComGetMsg("COM130201", "DEL", "", ""));
                                    } else if(saveNm=="cmdt_tp_cd") {
                                        ComShowMessage(ComGetMsg("COM130201", "Commodity", "", ""));
                                    }
                                    ValidateFail(true);
                                    SelectCell( Row, Col+1 );
                                } else {
                                    if( saveNm=="por_grp_tp_cd" || saveNm=="pol_grp_tp_cd" ||
                                        saveNm=="pod_grp_tp_cd" || saveNm=="del_grp_tp_cd" ) {
                                        if(checkSubLength( sheetObj, Row, Col, val ) == false) {
                                            ValidateFail(true);
                                            SelectCell( Row, Col+1 );
                                        }
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        }
    }
    /**
     * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
     */
    function sheet1_setSheetData(rowArray, row, col) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var colArray=rowArray[0];
        row=formObj.rowNum.value;
        col=formObj.colNum.value;
        sheetObj.SetCellValue(row, col,colArray[5],0);
    }
    /**
     * Save 시에 Sheet 데이터 유효성 체크
     */
    function validateData(sheetObj) {
        with(sheetObj) {
            for (var i=HeaderRows(); i<=LastRow(); i++) {
            	var ibStatus=GetRowStatus(i);
                if( ibStatus.toUpperCase() == "I" || ibStatus.toUpperCase() == "U" ) {
                    // Rate, Amount 가 전부 미입력일때
                	if( GetCellValue(i, "bkg_fac_rt") == "0" && GetCellValue(i, "fac_spcl_cntr_rt1") == "0" && GetCellValue(i, "fac_spcl_cntr_rt2") == "0" &&
                			GetCellValue(i, "bkg_fac_bl_amt") == "0" && GetCellValue(i, "fac_bx_amt") == "0" && GetCellValue(i, "fac_teu_amt") == "0" &&
                			GetCellValue(i, "fac_feu_amt") == "0" && GetCellValue(i, "fac_rf_teu_amt") == "0" && GetCellValue(i, "fac_rf_feu_amt") == "0" &&
                			GetCellValue(i, "fac_spcl_teu_amt") == "0" && GetCellValue(i, "fac_spcl_feu_amt") == "0" ) {
                            ComShowCodeMessage("COM130201", "rate or amount");
                            return false;
                    }
                }
            }
        }
        return true;
    }
    /**
     * Request, Approve, Reject 버튼 클릭시 대상 체크
     */
    function checkData( gubun ){
        var sheetObj=sheetObjects[0];
        var cnt=0;
        if( gubun == "RE" ) {    // Reject일 경우
            for(var i=1; i<sheetObj.RowCount()+1; i++) {
        	var check=sheetObj.GetCellValue(i+1, "check");
        	var sts_cd=sheetObj.GetCellValue(i+1, "fac_sts_cd");
                if( check == 1 ) {
                    if(sts_cd == "RR" || sts_cd == "PS") {
                        cnt++;
                    } else {
                        sheetObj.SetCellValue(i+1, "check","N",0);
                    }
                }
            }
        } else {   // Request/Approval일 경우
            var sts="";
            if( gubun == "RR" || gubun == "RN" ) {
                sts="RS";
            } else if( gubun == "PS" ) {
                sts="RR";
            }
            for(var i=1; i<sheetObj.RowCount()+1; i++) {
            var check=sheetObj.GetCellValue(i+1, "check");
            var sts_cd=sheetObj.GetCellValue(i+1, "fac_sts_cd");
                if( check == 1 ) {
                    if(sts_cd == sts) {
                        cnt++;
                    } else {
                        sheetObj.SetCellValue(i+1, "check","N",0);
                    }
                }
            }
        }
        return cnt;
    }
    /**
     * 행추가
     */
    function addRowData(newRow, cntCd) {
        var sheetObj=sheetObjects[0];
        var ff_cnt_cd="";
        var ff_cust_nm="";
        if(cntCd != null && cntCd.length > 0) {
            ff_cnt_cd=cntCd + "999999";
            ff_cust_nm="REP. CUSTOMER";
            sheetObj.SetCellValue(newRow, "frt_cnt_seq",ff_cnt_cd,0);
            sheetObj.SetCellValue(newRow, "ff_lgl_eng_nm",ff_cust_nm,0);
        }
        setGetCellEditable( sheetObj, newRow );
    }
    /**
     * 행복사시 Grid Cell Data 설정
     */
    function setCellData( sheetObj, newRow ) {
        with(sheetObj) {
            SetCellValue(newRow, "fac_sts_cd","RS",0);
            SetCellValue(newRow, "fac_rqst_usr_id","",0);
            SetCellValue(newRow, "fac_apro_usr_id","",0);
            SetCellValue(newRow, "fac_apro_dt","",0);
            SetCellValue(newRow, "fac_rmk","",0);
            SetCellValue(newRow, "fac_agmt_seq","",0);
//	        CellValue2(newRow, "fac_rqst_usr_eml") = "";
//	        CellValue2(newRow, "fac_apro_usr_eml") = "";
//	        CellValue2(newRow, "fac_rqst_usr_name") = "";
        }
    }
    /**
     * 행복사시 Grid CellEditable 설정
     */
    function setGetCellEditable( sheetObj, newRow ) {
        with(sheetObj) {
            SetCellEditable(newRow, "delchk",1);
            SetCellEditable(newRow, "check",0);
            SetCellEditable(newRow, "frt_cnt_seq",1);
            SetCellEditable(newRow, "shpr_cnt_seq",1);
            SetCellEditable(newRow, "por_grp_tp_cd",1);
            SetCellEditable(newRow, "por_rout_cd",1);
            SetCellEditable(newRow, "pol_grp_tp_cd",1);
            SetCellEditable(newRow, "pol_rout_cd",1);
            SetCellEditable(newRow, "pod_grp_tp_cd",1);
            SetCellEditable(newRow, "pod_rout_cd",1);
            SetCellEditable(newRow, "del_grp_tp_cd",1);
            SetCellEditable(newRow, "del_rout_cd",1);
            SetCellEditable(newRow, "bkg_rcv_term_cd",1);
            SetCellEditable(newRow, "bkg_de_term_cd",1);
            SetCellEditable(newRow, "fac_sgl_flg",1);
            SetCellEditable(newRow, "fac_dbl_flg",1);
            SetCellEditable(newRow, "all_in_rt_cd",1);
            SetCellEditable(newRow, "svc_scp_cd",1);
            SetCellEditable(newRow, "fm_eff_dt",1);
            SetCellEditable(newRow, "to_eff_dt",1);
            SetCellEditable(newRow, "sc_no",1);
            SetCellEditable(newRow, "rfa_no",1);
            SetCellEditable(newRow, "cmdt_tp_cd",1);
            SetCellEditable(newRow, "cmdt_cd",1);
            SetCellEditable(newRow, "fac_div_cd",1);
            SetCellEditable(newRow, "bkg_fac_rt",1);
        	if (GetCellValue(newRow, "fac_div_cd") == "DR") {
                SetCellEditable(newRow, "fac_spcl_cntr_tp_ctnt1",1);
                SetCellEditable(newRow, "fac_spcl_cntr_rt1",1);
                SetCellEditable(newRow, "fac_spcl_cntr_tp_ctnt2",1);
                SetCellEditable(newRow, "fac_spcl_cntr_rt2",1);
        	}else{
                SetCellEditable(newRow, "fac_spcl_cntr_tp_ctnt1",0);
                SetCellEditable(newRow, "fac_spcl_cntr_rt1",0);
                SetCellEditable(newRow, "fac_spcl_cntr_tp_ctnt2",0);
                SetCellEditable(newRow, "fac_spcl_cntr_rt2",0);        		
        	}            
//            CellEditable(newRow, "bkg_fac_bl_amt") = true;
            SetCellEditable(newRow, "fac_bx_amt",1);
            SetCellEditable(newRow, "fac_teu_amt",1);
            SetCellEditable(newRow, "fac_feu_amt",1);
            SetCellEditable(newRow, "fac_rf_teu_amt",1);
            SetCellEditable(newRow, "fac_rf_feu_amt",1);
            SetCellEditable(newRow, "fac_chg_ctnt",1);
            SetCellEditable(newRow, "fac_rmk",1);
        }
    }
    /**
     * Type(fac_div_cd) 입력시 Format 적용
     */
    function setFacDivCd( sheetObj, Row, Col ) {
        with(sheetObj) {
        	var value=GetCellValue(Row, Col);
            switch (value) {
                case "BA":
                case "BF":
                    SetCellValue(Row, "fac_spcl_cntr_tp_ctnt1","",0);
                    SetCellValue(Row, "fac_spcl_cntr_tp_ctnt2","",0);
                    SetCellValue(Row, "fac_spcl_cntr_rt1",0,0);
                    SetCellValue(Row, "fac_spcl_cntr_rt2",0,0);
                    SetCellValue(Row, "bkg_fac_bl_amt",0,0);
                    SetCellValue(Row, "fac_bx_amt",0,0);
                    SetCellValue(Row, "fac_teu_amt",0,0);
                    SetCellValue(Row, "fac_feu_amt",0,0);
                    SetCellValue(Row, "fac_rf_teu_amt",0,0);
                    SetCellValue(Row, "fac_rf_feu_amt",0,0);
                    SetCellValue(Row, "fac_chg_ctnt","",0);
                    SetCellEditable(Row, "bkg_fac_rt",1);
                    SetCellEditable(Row, "fac_spcl_cntr_tp_ctnt1",0);
                    SetCellEditable(Row, "fac_spcl_cntr_rt1",0);
                    SetCellEditable(Row, "fac_spcl_cntr_tp_ctnt2",0);
                    SetCellEditable(Row, "fac_spcl_cntr_rt2",0);
                    SetCellEditable(Row, "bkg_fac_bl_amt",0);
                    SetCellEditable(Row, "fac_bx_amt",0);
                    SetCellEditable(Row, "fac_teu_amt",0);
                    SetCellEditable(Row, "fac_feu_amt",0);
                    SetCellEditable(Row, "fac_rf_teu_amt",0);
                    SetCellEditable(Row, "fac_rf_feu_amt",0);
                    SetCellEditable(Row, "fac_chg_ctnt",0);
                    SetCellEditable(Row, "fac_spcl_teu_amt",0);
                    SetCellEditable(Row, "fac_spcl_feu_amt",0);
                    SetCellEditable(Row, "curr_cd",0);
                    break;
                case "BS":
                    SetCellValue(Row, "fac_spcl_cntr_tp_ctnt1","",0);
                    SetCellValue(Row, "fac_spcl_cntr_tp_ctnt2","",0);
                    SetCellValue(Row, "fac_spcl_cntr_rt1",0,0);
                    SetCellValue(Row, "fac_spcl_cntr_rt2",0,0);
                    SetCellValue(Row, "bkg_fac_bl_amt",0,0);
                    SetCellValue(Row, "fac_bx_amt",0,0);
                    SetCellValue(Row, "fac_teu_amt",0,0);
                    SetCellValue(Row, "fac_feu_amt",0,0);
                    SetCellValue(Row, "fac_rf_teu_amt",0,0);
                    SetCellValue(Row, "fac_rf_feu_amt",0,0);
                    SetCellEditable(Row, "bkg_fac_rt",1);
                    SetCellEditable(Row, "fac_spcl_cntr_tp_ctnt1",0);
                    SetCellEditable(Row, "fac_spcl_cntr_rt1",0);
                    SetCellEditable(Row, "fac_spcl_cntr_tp_ctnt2",0);
                    SetCellEditable(Row, "fac_spcl_cntr_rt2",0);
                    SetCellEditable(Row, "bkg_fac_bl_amt",0);
                    SetCellEditable(Row, "fac_bx_amt",0);
                    SetCellEditable(Row, "fac_teu_amt",0);
                    SetCellEditable(Row, "fac_feu_amt",0);
                    SetCellEditable(Row, "fac_rf_teu_amt",0);
                    SetCellEditable(Row, "fac_rf_feu_amt",0);
                    SetCellEditable(Row, "fac_chg_ctnt",1);
                    SetCellEditable(Row, "fac_spcl_teu_amt",0);
                    SetCellEditable(Row, "fac_spcl_feu_amt",0);
                    SetCellEditable(Row, "curr_cd",0);
                    break;
                case "BL":
                    SetCellValue(Row, "bkg_fac_rt",0,0);
                    SetCellValue(Row, "fac_bx_amt",0,0);
                    SetCellValue(Row, "fac_spcl_cntr_tp_ctnt1","",0);
                    SetCellValue(Row, "fac_spcl_cntr_tp_ctnt2","",0);
                    SetCellValue(Row, "fac_spcl_cntr_rt1",0,0);
                    SetCellValue(Row, "fac_spcl_cntr_rt2",0,0);
                    SetCellValue(Row, "fac_teu_amt",0,0);
                    SetCellValue(Row, "fac_feu_amt",0,0);
                    SetCellValue(Row, "fac_rf_teu_amt",0,0);
                    SetCellValue(Row, "fac_rf_feu_amt",0,0);
                    SetCellValue(Row, "fac_chg_ctnt","",0);
                    SetCellEditable(Row, "bkg_fac_bl_amt",1);
                    SetCellEditable(Row, "bkg_fac_rt",0);
                    SetCellEditable(Row, "fac_spcl_cntr_tp_ctnt1",0);
                    SetCellEditable(Row, "fac_spcl_cntr_rt1",0);
                    SetCellEditable(Row, "fac_spcl_cntr_tp_ctnt2",0);
                    SetCellEditable(Row, "fac_spcl_cntr_rt2",0);
                    SetCellEditable(Row, "fac_bx_amt",0);
                    SetCellEditable(Row, "fac_teu_amt",0);
                    SetCellEditable(Row, "fac_feu_amt",0);
                    SetCellEditable(Row, "fac_rf_teu_amt",0);
                    SetCellEditable(Row, "fac_rf_feu_amt",0);
                    SetCellEditable(Row, "fac_chg_ctnt",0);
                    SetCellEditable(Row, "fac_spcl_teu_amt",0);
                    SetCellEditable(Row, "fac_spcl_feu_amt",0);
                    SetCellEditable(Row, "curr_cd",1);
                    break;
                case "CA":
                    SetCellValue(Row, "bkg_fac_rt",0,0);
                    SetCellValue(Row, "fac_spcl_cntr_tp_ctnt1","",0);
                    SetCellValue(Row, "fac_spcl_cntr_tp_ctnt2","",0);
                    SetCellValue(Row, "fac_spcl_cntr_rt1",0,0);
                    SetCellValue(Row, "fac_spcl_cntr_rt2",0,0);
                    SetCellValue(Row, "bkg_fac_bl_amt",0,0);
                    SetCellValue(Row, "fac_teu_amt",0,0);
                    SetCellValue(Row, "fac_feu_amt",0,0);
                    SetCellValue(Row, "fac_rf_teu_amt",0,0);
                    SetCellValue(Row, "fac_rf_feu_amt",0,0);
                    SetCellValue(Row, "fac_chg_ctnt","",0);
                    SetCellEditable(Row, "bkg_fac_rt",0);
                    SetCellEditable(Row, "fac_spcl_cntr_tp_ctnt1",0);
                    SetCellEditable(Row, "fac_spcl_cntr_rt1",0);
                    SetCellEditable(Row, "fac_spcl_cntr_tp_ctnt2",0);
                    SetCellEditable(Row, "fac_spcl_cntr_rt2",0);
                    SetCellEditable(Row, "bkg_fac_bl_amt",0);
                    SetCellEditable(Row, "fac_bx_amt",1);
                    SetCellEditable(Row, "fac_teu_amt",0);
                    SetCellEditable(Row, "fac_feu_amt",0);
                    SetCellEditable(Row, "fac_rf_teu_amt",0);
                    SetCellEditable(Row, "fac_rf_feu_amt",0);
                    SetCellEditable(Row, "fac_chg_ctnt",0);
                    SetCellEditable(Row, "fac_spcl_teu_amt",0);
                    SetCellEditable(Row, "fac_spcl_feu_amt",0);
                    SetCellEditable(Row, "curr_cd",1);
                    break;
                case "CS":
                    SetCellValue(Row, "bkg_fac_rt",0,0);
                    SetCellValue(Row, "fac_spcl_cntr_tp_ctnt1","",0);
                    SetCellValue(Row, "fac_spcl_cntr_tp_ctnt2","",0);
                    SetCellValue(Row, "fac_spcl_cntr_rt1",0,0);
                    SetCellValue(Row, "fac_spcl_cntr_rt2",0,0);
                    SetCellValue(Row, "bkg_fac_bl_amt",0,0);
                    SetCellValue(Row, "fac_bx_amt",0,0);
                    SetCellValue(Row, "fac_rf_feu_amt","",0);
                    SetCellEditable(Row, "bkg_fac_rt",0);
                    SetCellEditable(Row, "fac_spcl_cntr_tp_ctnt1",0);
                    SetCellEditable(Row, "fac_spcl_cntr_rt1",0);
                    SetCellEditable(Row, "fac_spcl_cntr_tp_ctnt2",0);
                    SetCellEditable(Row, "fac_spcl_cntr_rt2",0);
                    SetCellEditable(Row, "bkg_fac_bl_amt",0);
                    SetCellEditable(Row, "fac_bx_amt",0);
                    SetCellEditable(Row, "fac_teu_amt",1);
                    SetCellEditable(Row, "fac_feu_amt",1);
                    SetCellEditable(Row, "fac_rf_teu_amt",1);
                    SetCellEditable(Row, "fac_rf_feu_amt",1);
                    SetCellEditable(Row, "fac_chg_ctnt",0);
                    SetCellEditable(Row, "fac_spcl_teu_amt",1);
                    SetCellEditable(Row, "fac_spcl_feu_amt",1);
                    SetCellEditable(Row, "curr_cd",1);
                    break;
                case "DR":
                    SetCellValue(Row, "bkg_fac_rt",0,0);
                    SetCellValue(Row, "bkg_fac_bl_amt",0,0);
                    SetCellValue(Row, "fac_bx_amt",0,0);
                    SetCellValue(Row, "fac_rf_feu_amt","",0);
                    SetCellEditable(Row, "bkg_fac_rt",0);
                    SetCellEditable(Row, "fac_spcl_cntr_tp_ctnt1",1);
                    SetCellEditable(Row, "fac_spcl_cntr_rt1",1);
                    SetCellEditable(Row, "fac_spcl_cntr_tp_ctnt2",1);
                    SetCellEditable(Row, "fac_spcl_cntr_rt2",1);
                    SetCellEditable(Row, "bkg_fac_bl_amt",0);
                    SetCellEditable(Row, "fac_bx_amt",0);
                    SetCellEditable(Row, "fac_teu_amt",0);
                    SetCellEditable(Row, "fac_feu_amt",0);
                    SetCellEditable(Row, "fac_rf_teu_amt",0);
                    SetCellEditable(Row, "fac_rf_feu_amt",0);
                    SetCellEditable(Row, "fac_chg_ctnt",1);
                    SetCellEditable(Row, "fac_spcl_teu_amt",0);
                    SetCellEditable(Row, "fac_spcl_feu_amt",0);
                    SetCellEditable(Row, "curr_cd",0);
                    break;
            }
        }
    }
    /**
     * CHG 체크
     */
    function checkCHG( sheetObj, Row, ColNm ) {
        with(sheetObj) {
        	var value=ComTrim(GetCellValue(Row, ColNm));
            var chg_arr=value.split(',');
            if(chg_arr.length > 0) {
                for(var i=0; i<chg_arr.length; i++) {
                    if(chg_arr[i] == "") { // 계산시 문제 발생 가능하므로 ComTrim하지 않고 체크한다.
                        ComShowCodeMessage("COM130201", "CHG", "(ex:OFT,OTH,DTH)", "");
                        SelectCell( Row, ColNm, true, "" );
                        return false;
                    } else {
                        if(chg_arr[i].length > 3) {
                            ComShowCodeMessage("ACM00016");
                            //ComShowMessage("Each CHG consists of maximum of 3 Characters.\n\n (ex:OFT,OTH,DTH)");
                            SelectCell( Row, ColNm, true, "" );
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    /**
     * CHG 체크
     */
    function checkManCHG( sheetObj, Row, ColNm ) {
        with(sheetObj) {
        	var value=ComTrim(GetCellValue(Row, ColNm));
            if(value.length <= 0) {
                ComShowCodeMessage("COM130201", "CHG", "(ex:OFT,OTH,DTH)", "");
                SelectCell( Row, ColNm );
                return false;
            }
        }
        return true;
    }
    /**
     * 입력 길이 체크
     */
    function checkSubLength( sheetObj, Row, Col, Value ) {
        with(sheetObj) {
            Value=ComTrim(Value);
            var saveNm=ColSaveName(Col);
            var subValue=ComTrim(GetCellValue(Row, Col+1));
            switch (Value) {
                case "1":
                    if(subValue.length > 1) {
                        if(saveNm=="por_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POR", "1", ""));
                        } else if(saveNm=="pol_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POL", "1", ""));
                        } else if(saveNm=="pod_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POD", "1", ""));
                        } else if(saveNm=="del_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "DEL", "1", ""));
                        }
                        return false;
                    }
                    break;
                case "2":
                case "3":
                    if(subValue.length > 2) {
                        if(saveNm=="por_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POR", "2", ""));
                        } else if(saveNm=="pol_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POL", "2", ""));
                        } else if(saveNm=="pod_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POD", "2", ""));
                        } else if(saveNm=="del_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "DEL", "2", ""));
                        }
                        return false;
                    }
                    break;
                case "4":
                    if(subValue.length > 3) {
                        if(saveNm=="por_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POR", "3", ""));
                        } else if(saveNm=="pol_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POL", "3", ""));
                        } else if(saveNm=="pod_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POD", "3", ""));
                        } else if(saveNm=="del_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "DEL", "3", ""));
                        }
                        return false;
                    }
                    break;
                case "5":
                    if(subValue.length > 5) {
                        if(saveNm=="por_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POR", "5", ""));
                        } else if(saveNm=="pol_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POL", "5", ""));
                        } else if(saveNm=="pod_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POD", "5", ""));
                        } else if(saveNm=="del_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "DEL", "5", ""));
                        }
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
    /**
     * Grid에서 Sgl Flg 설정 처리
     */
    function checkSglFlg( sheetObj, Row ) {
        with (sheetObj) {
        	var por_cd=ComTrim(GetCellValue(Row, "por_rout_cd"));
        	var pol_cd=ComTrim(GetCellValue(Row, "pol_rout_cd"));
        	var pod_cd=ComTrim(GetCellValue(Row, "pod_rout_cd"));
        	var del_cd=ComTrim(GetCellValue(Row, "del_rout_cd"));
            if( por_cd != "*" && pol_cd != "*" && pod_cd != "*" &&
                del_cd != "*" && por_cd == pol_cd && pod_cd == del_cd ) {
                SetCellValue(Row, "fac_sgl_flg","N",0);
                SetCellEditable(Row, "fac_sgl_flg",0);
            } else {
                SetCellEditable(Row, "fac_sgl_flg",1);
            }
            if( por_cd != "*" && pol_cd != "*" && pod_cd != "*" &&
                del_cd != "*" && por_cd != pol_cd && pod_cd != del_cd ) {
                SetCellValue(Row, "fac_dbl_flg","Y",0);
                SetCellEditable(Row, "fac_dbl_flg",1);
            } else {
                SetCellEditable(Row, "fac_dbl_flg",0);
            }
        }
    }
    /**
     * Request Click Event 처리
     */
    function openStaffInfo( cnt ) {
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        document.form.cnt.value=cnt; // Request Count를 셋팅한다.
        var cust_cd="";
        var width=858;
        var height=554;
        var func="doRequest";
        var url="COM_ENS_092.do";
//        ComOpenPopup(url, width, height, func, 'none', true);
    }
    /**
     * Request Click Event 처리
     */
    function doRequest( rowArray ) {
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        var gubun=';';
        formObj.recipients_eml.value=""; // 초기화
        formObj.recipients_name.value=""; // 초기화
        for(var i=0; i<rowArray.length; i++) {
            if(i == rowArray.length-1) gubun='';
            var colArray=rowArray[i];
            if(colArray[1] == "1"){
                formObj.recipients_eml.value += colArray[4] + gubun;
                formObj.recipients_name.value += colArray[3] + gubun;
            }
        }
        if( formObj.recipients_eml.value.length <= 0) {
            ComShowCodeMessage("COM130402", "Recipient e-mail address");
            return false;
        }
        sheetObj.DoSave("ESM_ACM_0024GS.do", FormQueryString(formObj), "check", false);
    }

    function change_sts() {
    	/**
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        var stsCd = formObj.fac_sts_cd.value;
        for (var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++){
        	if (stsCd == "") {
        		sheetObj.SetRowHidden(i, 0);
        	}else if (stsCd == sheetObj.GetCellValue(i, "fac_sts_cd")) {
        		sheetObj.SetRowHidden(i, 0);
        	}else{
        		sheetObj.SetRowHidden(i, 1);                    		
        	}
        }  
        **/  	
    }    
    /* 개발자 작업 끝 */
    
