/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0025.js
*@FileTitle  : Compensation Agreement Rate Creation
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
            case "btn_popup":
                //var cust_cd = "US"; // Default 셋팅
                var url="COM_ENS_041.do";
                var width=775;
                var height=484;
                var func="setForwarder";
                var display="1,0,1,1,1,1,1,1,1,1,1,1";
                ComOpenPopup(url, width, height, func, display, true, false);
                break;
            case "btn_retrieve":
                doActionIBSheet(shtObj,frmObj,IBSEARCH);
                break;
            case "btn_save":
                doActionIBSheet(shtObj, frmObj, IBSAVE);
                break;
            case "btn_downexcel":
            	if(shtObj.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
               }else{
            	   //shtObj.Down2Excel({ HiddenColumn:true});
            	   shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
               }
                break;
            case "btn_copy":
                doActionIBSheet(shtObj, frmObj, IBCOPYROW);
                break;
            case "btn_add":
                doActionIBSheet(shtObj, frmObj, IBINSERT);
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
                var HeadTitle0="Del.|STS|SEQ|Office|Kind|AGMT\nCustomer|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|EFF DT|EXP DT|SC No|RFA No|Commodity\nTP|Commodity|Commodity|Type|Rate|USD|USD|USD|USD|USD|USD|Specific CHG|Local|Local||||";
                var HeadTitle1="|STS|SEQ|Office|Kind|AGMT\nCustomer|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|EFF DT|EXP DT|SC No|RFA No|Commodity\nTP|Commodity|Commodity|Type|Rate|Box AMT|TEU AMT|FEU AMT|REU AMT|RTEU AMT|RFEU AMT|Specific CHG|Cur|Ex. Rate||||";
                SetConfig( { SearchMode:2, FrozenCol:7, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Status",    Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"spcl_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, AcceptKeys:"E", 	InputCaseSensitive:1 },
                       {Type:"Combo",     Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"cust_knd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8, AcceptKeys:"E|N", 	InputCaseSensitive:1 },
                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"spcl_cnt_cust_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"PopupEdit", Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"shpr_cnt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"shpr_cnt_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"por_grp_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"PopupEdit", Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"por_rout_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 , InputCaseSensitive:1},
                       {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_grp_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"PopupEdit", Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_rout_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 , InputCaseSensitive:1},
                       {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_grp_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"PopupEdit", Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_rout_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 , InputCaseSensitive:1},
                       {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fm_eff_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"to_eff_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"PopupEdit", Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                       {Type:"PopupEdit", Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
                       {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"PopupEdit", Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 , InputCaseSensitive:1},
                       {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Combo",     Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:"spcl_div_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"spcl_bkg_rt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
                       {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"spcl_bx_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                       {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"spcl_teu_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                       {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"spcl_feu_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                       {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"spcl_rf_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                       {Type:"Float",     Hidden:0,  Width:63,   Align:"Right",   ColMerge:1,   SaveName:"spcl_rf_teu_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                       {Type:"Float",     Hidden:0,  Width:63,   Align:"Right",   ColMerge:1,   SaveName:"spcl_rf_feu_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                       {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"spcl_chg_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
 
                       {Type:"PopupEdit", Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd" ,          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 , AcceptKeys:"E", InputCaseSensitive:1},
                       {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pay_xch_rt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   AcceptKeys:"N"},
                       
                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"g_delt_flg",         KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd" },
                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq" },
                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_agmt_seq" } ];
                 
                InitColumns(cols);
                SetSheetHeight(485);
                SetEditable(1);
                SetWaitImageVisible(0);
                SetColProperty("por_grp_tp_cd", {ComboText:proTpText, ComboCode:proTpCode} );
                SetColProperty("pol_grp_tp_cd", {ComboText:proTpText, ComboCode:proTpCode} );
                SetColProperty("pod_grp_tp_cd", {ComboText:proTpText, ComboCode:proTpCode} );
         	   	SetColProperty(0 ,"por_rout_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
         	   	SetColProperty(0 ,"pol_rout_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
         	   	SetColProperty(0 ,"pod_rout_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetColProperty("cmdt_tp_cd", {ComboText:"*|Rep|Common", ComboCode:"*|2|3"} );
                SetColProperty("spcl_div_cd", {ComboText:ffDivCdText, ComboCode:ffDivCdCode} );
                SetColProperty("cust_knd_cd", {ComboText:customerKindCdText, ComboCode:customerKindCdCode} );
                SetColProperty("spcl_chg_ctnt" , {AcceptKeys:"E|[,]" , InputCaseSensitive:1});
         	    SetColProperty(0 ,"shpr_cnt_seq" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetShowButtonImage(3);
                SetHeaderRowHeight(24);
                break;
                }
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        var newRow=-1;
        switch (sAction) {
            case SEARCH01:       // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 spcl_ofc_cd를 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.spcl_ofc_cd, "value0", "value0", true);
                break;
            case IBSEARCH:    // 조회(Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                if (frmObj.deleted_customer.checked) {
                    frmObj.delt_flg.value="Y";
                } else {
                    frmObj.delt_flg.value="N";
                }
                shtObj.DoSearch("ESM_ACM_0025GS.do", FormQueryString(frmObj) );
                ComOpenWait(false);
                break;
            case IBINSERT:      // 입력
                newRow=shtObj.DataInsert();
                shtObj.SetCellValue(newRow, "spcl_ofc_cd",frmObj.spcl_ofc_cd.value,0);
                shtObj.SetCellValue(newRow, "cust_knd_cd","R",0);
                shtObj.SetCellValue(newRow, "shpr_cnt_seq","*",0);
                shtObj.SetCellValue(newRow, "por_grp_tp_cd","*",0);
                shtObj.SetCellValue(newRow, "por_rout_cd","*",0);
                shtObj.SetCellValue(newRow, "pol_grp_tp_cd","*",0);
                shtObj.SetCellValue(newRow, "pol_rout_cd","*",0);
                shtObj.SetCellValue(newRow, "pod_grp_tp_cd","*",0);
                shtObj.SetCellValue(newRow, "pod_rout_cd","*",0);
                shtObj.SetCellValue(newRow, "fm_eff_dt","20000101",0);
                shtObj.SetCellValue(newRow, "to_eff_dt","29991231",0);
                shtObj.SetCellValue(newRow, "sc_no","*",0);
                shtObj.SetCellValue(newRow, "rfa_no","*",0);
                shtObj.SetCellValue(newRow, "cmdt_tp_cd","*",0);
                shtObj.SetCellValue(newRow, "cmdt_cd","*",0);
                shtObj.SetCellValue(newRow, "spcl_div_cd","CS",0);
                setBrogDivCd(shtObj, newRow, "spcl_div_cd");
                break;
            case IBCOPYROW:    //행 복사
                newRow=shtObj.DataCopy();
                setBrogDivCd(shtObj, newRow, "spcl_div_cd");
                break;
            case IBSAVE:
                if (!ComChkValid(frmObj)) return;
        		var SaveStr=ComGetSaveString(shtObj);
        		if(SaveStr == undefined || SaveStr.length <= 0 ){
        			return;
        		}
                frmObj.f_cmd.value=MULTI05;
                var sXml = shtObj.GetSaveData("ESM_ACM_0025GS.do", FormQueryString(frmObj) + "&" + ComGetSaveString(shtObj));
                if (ComGetEtcData(sXml, "cnt") == 0) {                
	                ComOpenWait(true);
	                frmObj.f_cmd.value=MULTI;
	                shtObj.DoSave("ESM_ACM_0025GS.do", FormQueryString(frmObj));
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
        }
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
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnChange(shtObj, Row, Col, Value) {
        if (Value == "") {
        	with (shtObj) {
        		var saveNm = ColSaveName(Col);
        		switch (saveNm) {        		
        			case "cust_cnt_seq":
                    	SetCellValue(Row, "spcl_cnt_cust_nm", "", 0);                		
        				break;
        			case "shpr_cnt_seq":
                    	SetCellValue(Row, "shpr_cnt_nm", "", 0);                		
        				break;
        			case "cmdt_cd":
        				SetCellValue(Row, "cmdt_nm", "", 0);                		
        				break;
        		}
        	}
        	return;
        }    	
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "spcl_chg_ctnt":
                    //ACMCheckBox_OnClick(Param, Hidden);    // CoAcm.js에 정의
                    //ACMCheckBox_OnClick(frmObj.ac_sts_div, frmObj.ac_sts_cd);    // CoAcm.js에 정의
                    //SQL -> IN (${arr_val}).......
                    var ffChgCtntArray=new Array();
                    ffChgCtntArray=Value;
                    var ffChgCtntArraySplit=ffChgCtntArray.split(",");
                    var ffChgCtntVal="";
                    for(j=0;j<ffChgCtntArraySplit.length; j++){
                        if(j < ffChgCtntArraySplit.length-1){
                            ffChgCtntVal += ffChgCtntArraySplit[j]+"','";
                        }else{
                            ffChgCtntVal += ffChgCtntArraySplit[j];
                        }
                    }
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH20 + "&value0=" + "'"+ffChgCtntVal+"'"+ "&value1=" + ffChgCtntArraySplit.length);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        //Cellvalue2(Row, "spcl_chg_ctnt")="";
                    	SetCellValue(Row, Col, "", 0);
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);     
                    } else {
                        //ERR_CNT 가 0 일경우엔 저장 진행, 0 이 아니면 ERR MSG 리턴 !!
                        if (ComGetEtcData(xmlStr, "err_cnt") == "0") {
                        } else {
                            //"{?msg1} of {?msg2} row is invalid."
                            ComShowCodeMessage("ACM00013", "["+Value+"] of ["+ Row+ "] row is invalid.");
                            //Cellvalue2(Row, "spcl_chg_ctnt") = "";
                            SetCellValue(Row, Col, "", 0);
                        	setTimeout(function(){
                                SelectCell(Row, Col, true, "");
                            	},10);     
                        }
                    }
                    break;
                case "cust_cnt_seq":
                    // validation
                    if (!ComIsNumber(Value.substring(2))) {
                        ComShowCodeMessage("ACM00003", "Customer Code [" + Value + "]", "Customer Code");
                        SetCellValue(Row, "spcl_cnt_cust_nm", "", 0); 
                    	SetCellValue(Row, Col, "", 0);
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);     
                        return;
                    }
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH17 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        //Cellvalue2(Row, "spcl_cnt_cust_nm")="";
                    	SetCellValue(Row, "spcl_cnt_cust_nm", "", 0);
                    	SetCellValue(Row, Col, "", 0);
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);     
                    } else {
                        SetCellValue(Row, "spcl_cnt_cust_nm",ComGetEtcData(xmlStr, "cust_lgl_eng_nm"),0);
                    }
                    break;
                case "shpr_cnt_seq":
                    // validation
                    if (!ComIsNumber(Value.substring(2))) {
                        ComShowCodeMessage("ACM00003", "Customer Code [" + Value + "]", "Customer Code");
                        //Cellvalue2(Row, "shpr_cnt_nm")="";
                    	SetCellValue(Row, "shpr_cnt_nm", "", 0);
                    	SetCellValue(Row, Col, "", 0);
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);     
                        return;
                    }
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH17 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        //Cellvalue2(Row, "shpr_cnt_nm")="";
                    	SetCellValue(Row, "shpr_cnt_nm", "", 0);
                    	SetCellValue(Row, Col, "", 0);
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);     
                    } else {
                        SetCellValue(Row, "shpr_cnt_nm",ComGetEtcData(xmlStr, "cust_lgl_eng_nm"),0);
                    }
                    break;
                case "por_grp_tp_cd":
                case "pol_grp_tp_cd":
                case "pod_grp_tp_cd":
                    if(Value == 5) {
                        SetCellValue(Row, (parseInt(Col)+1),"",0);
                        //sheet1_OnPopupClick(sheetObj, Row, Col+1);
                    } else {
                        SetCellValue(Row, (parseInt(Col)+1),"*",0);
                    }
                    break;
                case "spcl_div_cd":
                    if ( Value == "BA" || Value == "BF" ) {
                        SetCellValue(Row, "spcl_bx_amt",0,0);
                        SetCellValue(Row, "spcl_teu_amt",0,0);
                        SetCellValue(Row, "spcl_feu_amt",0,0);
                        SetCellValue(Row, "spcl_rf_teu_amt",0,0);
                        SetCellValue(Row, "spcl_rf_feu_amt",0,0);
                        SetCellValue(Row, "spcl_chg_ctnt","",0);
                        SetCellEditable(Row, "spcl_bkg_rt",1);
                        SetCellEditable(Row, "spcl_bx_amt",0);
                        SetCellEditable(Row, "spcl_teu_amt",0);
                        SetCellEditable(Row, "spcl_feu_amt",0);
                        SetCellEditable(Row, "spcl_rf_teu_amt",0);
                        SetCellEditable(Row, "spcl_rf_feu_amt",0);
                        SetCellEditable(Row, "spcl_chg_ctnt",0);
                    } else if( Value == "BS" ) {
                        SetCellValue(Row, "spcl_bx_amt",0,0);
                        SetCellValue(Row, "spcl_teu_amt",0,0);
                        SetCellValue(Row, "spcl_feu_amt",0,0);
                        SetCellValue(Row, "spcl_rf_teu_amt",0,0);
                        SetCellValue(Row, "spcl_rf_feu_amt",0,0);
                        SetCellEditable(Row, "spcl_bkg_rt",1);
                        SetCellEditable(Row, "spcl_bx_amt",0);
                        SetCellEditable(Row, "spcl_teu_amt",0);
                        SetCellEditable(Row, "spcl_feu_amt",0);
                        SetCellEditable(Row, "spcl_rf_teu_amt",0);
                        SetCellEditable(Row, "spcl_rf_feu_amt",0);
                        SetCellEditable(Row, "spcl_chg_ctnt",1);
                    } else if( Value == "CA" ) {
                        SetCellValue(Row, "spcl_bkg_rt",0,0);
                        SetCellValue(Row, "spcl_teu_amt",0,0);
                        SetCellValue(Row, "spcl_feu_amt",0,0);
                        SetCellValue(Row, "spcl_rf_teu_amt",0,0);
                        SetCellValue(Row, "spcl_rf_feu_amt",0,0);
                        SetCellValue(Row, "spcl_chg_ctnt","",0);
                        SetCellEditable(Row, "spcl_bkg_rt",0);
                        SetCellEditable(Row, "spcl_bx_amt",1);
                        SetCellEditable(Row, "spcl_teu_amt",0);
                        SetCellEditable(Row, "spcl_feu_amt",0);
                        SetCellEditable(Row, "spcl_rf_teu_amt",0);
                        SetCellEditable(Row, "spcl_rf_feu_amt",0);
                        SetCellEditable(Row, "spcl_chg_ctnt",0);
                    } else if( Value == "CS" ) {
                        SetCellValue(Row, "spcl_bkg_rt",0,0);
                        SetCellValue(Row, "spcl_bx_amt",0,0);
                        SetCellValue(Row, "spcl_chg_ctnt","",0);
                        SetCellEditable(Row, "spcl_bkg_rt",0);
                        SetCellEditable(Row, "spcl_bx_amt",0);
                        SetCellEditable(Row, "spcl_teu_amt",1);
                        SetCellEditable(Row, "spcl_feu_amt",1);
                        SetCellEditable(Row, "spcl_rf_teu_amt",1);
                        SetCellEditable(Row, "spcl_rf_feu_amt",1);
                        SetCellEditable(Row, "spcl_chg_ctnt",0);
                    }
                    break;
                case "cmdt_cd":
                	var cmdt_tp=ComTrim(GetCellValue(Row, "cmdt_tp_cd"));
                    if(cmdt_tp == "*") {
                         ComShowCodeMessage("COM12113", "Commodity Type", "", "");
                         //Cellvalue2(Row, Col)="*";
                         SetCellValue(Row, Col, "*", 0);                            
                         SelectCell( Row, parseInt(Col)-1 );
                         return;
                    }
                    var xmlStr=GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH19 + "&value0=" + cmdt_tp + "&value1=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        SetCellValue(Row, "cmdt_nm", "", 0); 
                        SetCellValue(Row, Col, "*", 0);     
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);     
                    } else {
                        var rsltCmdtNm=ComGetEtcData(xmlStr, "cmdt_nm");
                        if ( rsltCmdtNm != "") {
                            SetCellValue(Row, "cmdt_nm", rsltCmdtNm, 0);                            
                        } else {
                            // Commodity Code is invalid.
                            ComShowCodeMessage("COM132201", "Commodity Code");
                            SetCellValue(Row, "cmdt_nm", "", 0); 
                            SetCellValue(Row, Col, "*", 0);     
                        	setTimeout(function(){
                                SelectCell(Row, Col, true, "");
                            	},10);     
                        }
                    }
                    break;
                case "cmdt_tp_cd":
                    SetCellValue(Row, (parseInt(Col)+1),"*",0);
                    SetCellValue(Row, (parseInt(Col)+2),"",0);
                    break;
                case "fm_eff_dt":
                	if( GetCellValue(Row,"fm_eff_dt") != "" && GetCellValue(Row,"to_eff_dt") != "" && (GetCellValue(Row,"fm_eff_dt") > GetCellValue(Row,"to_eff_dt")) ) {
                        ComShowCodeMessage("ACM00017", "Eff. Date", "Exp. Date");
                        //ComShowMessage("Eff. Date is later than Exp. Date. Please check Eff. Or Exp. Date.");
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);     
                    }
                    break;
                case "to_eff_dt":
                	if( GetCellValue(Row,"fm_eff_dt") != "" && GetCellValue(Row,"to_eff_dt") != "" && (GetCellValue(Row,"fm_eff_dt") > GetCellValue(Row,"to_eff_dt")) ) {
                        ComShowCodeMessage("ACM00018", "Exp. Date", "Eff. Date");
                        //ComShowMessage("Exp. Date is earlier than Eff. Date. Please check Eff. Or Exp. Date.");
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);     
                    }
                    break;
                case "curr_cd":
                    // validation
                     var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH14 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                    	SetCellValue(Row, Col, "", 0);
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);    
                    }
                    break;                    
            }
        }
    }
    /**
     * F.Forwarder 조회 후 값 Return 받아 셋팅한다.
     */
    function setForwarder(rowArray, row, col) {
        var colArray=rowArray[0];
        document.form.fcust_cnt_seq.value=colArray[3];
    }
    /**
     * Type(spcl_div_cd) 입력시 Format 적용
     */
    function setBrogDivCd(shtObj, Row, Col) {
        with(shtObj) {
        	var value=GetCellValue(Row, Col);
            if ( value == "BA" || value == "BF" ) {
                SetCellValue(Row, "spcl_bx_amt",0,0);
                SetCellValue(Row, "spcl_teu_amt",0,0);
                SetCellValue(Row, "spcl_feu_amt",0,0);
                SetCellValue(Row, "spcl_rf_teu_amt",0,0);
                SetCellValue(Row, "spcl_rf_feu_amt",0,0);
                SetCellValue(Row, "spcl_chg_ctnt","",0);
                SetCellEditable(Row, "spcl_bkg_rt",1);
                SetCellEditable(Row, "spcl_bx_amt",0);
                SetCellEditable(Row, "spcl_teu_amt",0);
                SetCellEditable(Row, "spcl_feu_amt",0);
                SetCellEditable(Row, "spcl_rf_teu_amt",0);
                SetCellEditable(Row, "spcl_rf_feu_amt",0);
                SetCellEditable(Row, "spcl_chg_ctnt",0);
            } else if( value == "BS" ) {
                SetCellValue(Row, "spcl_bx_amt",0,0);
                SetCellValue(Row, "spcl_teu_amt",0,0);
                SetCellValue(Row, "spcl_feu_amt",0,0);
                SetCellValue(Row, "spcl_rf_teu_amt",0,0);
                SetCellValue(Row, "spcl_rf_feu_amt",0,0);
                SetCellEditable(Row, "spcl_bkg_rt",1);
                SetCellEditable(Row, "spcl_bx_amt",0);
                SetCellEditable(Row, "spcl_teu_amt",0);
                SetCellEditable(Row, "spcl_feu_amt",0);
                SetCellEditable(Row, "spcl_rf_teu_amt",0);
                SetCellEditable(Row, "spcl_rf_feu_amt",0);
                SetCellEditable(Row, "spcl_chg_ctnt",1);
            } else if( value == "CA" ) {
                SetCellValue(Row, "spcl_bkg_rt",0,0);
                SetCellValue(Row, "spcl_teu_amt",0,0);
                SetCellValue(Row, "spcl_feu_amt",0,0);
                SetCellValue(Row, "spcl_rf_teu_amt",0,0);
                SetCellValue(Row, "spcl_rf_feu_amt",0,0);
                SetCellValue(Row, "spcl_chg_ctnt","",0);
                SetCellEditable(Row, "spcl_bkg_rt",0);
                SetCellEditable(Row, "spcl_bx_amt",1);
                SetCellEditable(Row, "spcl_teu_amt",0);
                SetCellEditable(Row, "spcl_feu_amt",0);
                SetCellEditable(Row, "spcl_rf_teu_amt",0);
                SetCellEditable(Row, "spcl_rf_feu_amt",0);
                SetCellEditable(Row, "spcl_chg_ctnt",0);
            } else if( value == "CS" ) {
                SetCellValue(Row, "spcl_bkg_rt",0,0);
                SetCellValue(Row, "spcl_bx_amt",0,0);
                SetCellValue(Row, "spcl_chg_ctnt","",0);
                SetCellEditable(Row, "spcl_bkg_rt",0);
                SetCellEditable(Row, "spcl_bx_amt",0);
                SetCellEditable(Row, "spcl_teu_amt",1);
                SetCellEditable(Row, "spcl_feu_amt",1);
                SetCellEditable(Row, "spcl_rf_teu_amt",1);
                SetCellEditable(Row, "spcl_rf_feu_amt",1);
                SetCellEditable(Row, "spcl_chg_ctnt",0);
            }
        }
    }
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnPopupClick(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "cust_cnt_seq":
                case "shpr_cnt_seq":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_041.do", 775, 484, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;
                case "por_rout_cd":
                case "pol_rout_cd":
                case "pod_rout_cd":
                    var iWidth="";
                    var iHeight="";
                    var sUrl="";
                    switch (GetCellValue(Row, parseInt(Col)-1)) {
                        case "1":
                            iWidth=700;
                            iHeight=415;
                            sUrl="COM_ENS_0H1.do";
                            break;
                        case "2":
                            iWidth=700;
                            iHeight=385;
                            sUrl="COM_ENS_0I1.do";
                            break;
                        case "3":
                            iWidth=700;
                            iHeight=515;
                            sUrl="COM_ENS_0M1.do";
                            break;
                        case "4":
                            iWidth=700;
                            iHeight=454;
                            sUrl="COM_ENS_0J1.do";
                            break;
                        case "5":
                            iWidth=775;
                            iHeight=515;
                            sUrl="COM_ENS_051.do";
                            break;
                        default:
                            if(ColSaveName(Col) == "por_rout_cd") {
                                ComShowMessage(ComGetMsg("COM12113", "POR TYPE", "", ""));
                            } else if (ColSaveName(Col) == "pol_rout_cd") {
                                ComShowMessage(ComGetMsg("COM12113", "POL TYPE", "", ""));
                            } else if (ColSaveName(Col) == "pod_rout_cd") {
                                ComShowMessage(ComGetMsg("COM12113", "POD TYPE", "", ""));
                            }
                            SelectCell(Row, parseInt(Col)-1);
                            return false;
                            break;
                    }
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup(sUrl, iWidth, iHeight, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;
                case "cmdt_cd":
                    var iWidth=0;
                    var iHeight=0;
                    var sUrl="";
                    var func="";
                    switch (GetCellValue(Row, parseInt(Col)-1)) {
                        case "2":
                            iWidth=775;
                            iHeight=400;
                            sUrl="COM_ENS_0K1.do";
                            break;
                        case "3":
                            iWidth=775;
                            iHeight=452;
                            sUrl="COM_ENS_011.do";
                            break;
                        default:
                            ComShowMessage(ComGetMsg("COM12113", "Commodity Type", "", ""));
                            SelectCell(Row, parseInt(Col)-1);
                            return false;
                            break;
                    }
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup(sUrl, iWidth, iHeight, "setPopupData", "1,0,1", false, true, Row, Col, 0);
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
                    var func="";
                    var display="1,0,1,1,1,1,1,1,1,1,1,1";
                    var url="";
                    func="sheet1_setSheetData4";
                    url="ESM_BKG_0655.do?pgmNo=ESM_BKG_0655&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&func="+func;
                    ComOpenPopup(url, 860, 500, func, display, true, false, Row, Col);
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
                    var func="";
                    var display="1,0,1,1,1,1,1,1,1,1,1,1";
                    var url="";
                    func="sheet1_setSheetData4";
                    url="ESM_BKG_0654.do?pgmNo=ESM_BKG_0655&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&func="+func;
                    ComOpenPopup(url, 860, 475, func, display, true, false, Row, Col);
                    break;
                case "curr_cd":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_N13.do", 775, 484, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;                    
            }
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
    	var aryData = aryPopupData[0];
        if (aryPopupData[0].length > 0 ) {
            with (sheetObjects[ShtIdx]) {
                switch (ColSaveName(Col)) {
                    // sheet1_setFFCntSeq
                    case "cust_cnt_seq":
                    case "shpr_cnt_seq":
                        SetCellValue(Row, Col,aryPopupData[0][3].substring(0, 2) + ComLpad(aryPopupData[0][3].substring(2), 6, "0"),0);
                        SetCellValue(Row, parseInt(Col)+1,aryPopupData[0][4],0);
                        break;
                    // sheet1_setSheetData2
                    case "por_rout_cd":
                    case "pol_rout_cd":
                    case "pod_rout_cd":
                        SetCellValue(Row, Col,aryPopupData[0][3]);
                        break;
                    // sheet1_setSheetData3
                    case "cmdt_cd":
                    	switch (GetCellValue(Row, parseInt(Col)-1)) {
                            case "2":
                            	
                                SetCellValue(Row, Col,aryData[3],0);
                                SetCellValue(Row, parseInt(Col)+1,aryData[4],0);
//                                SetCellValue(Row, Col,aryPopupData[0][3]);
//                                SetCellValue(Row, parseInt(Col)+1,aryPopupData[0][4]);
                                break;
                            case "3":
                                SetCellValue(Row, Col,aryData[2]);
                                SetCellValue(Row, parseInt(Col)+1,aryData[3]);
//                                SetCellValue(Row, Col,aryPopupData[0][3]);
//                                SetCellValue(Row, parseInt(Col)+1,aryPopupData[0][4]);
                                break;
                        }
                        break;
                    case "curr_cd":
                    	SetCellValue(Row,  Col,aryPopupData[0][2]);
                    	break;
                }
            }
        }
    }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            for(var i=1; i<=shtObj.LastRow(); i++) {
              if(shtObj.GetCellValue(i, "g_delt_flg") == "Y" ){
            	 shtObj.SetRowEditable(i, 0);
            }else{
            	if (shtObj.GetCellValue(i, "spcl_div_cd") == "BA" || shtObj.GetCellValue(i, "spcl_div_cd") == "BF") {
                    //shtObj.CellValue2(i, "ff_bx_amt") = 0;
                    shtObj.SetCellValue(i, "spcl_bx_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_teu_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_feu_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_rf_teu_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_rf_feu_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_chg_ctnt","",0);
                    shtObj.SetCellEditable(i, "spcl_bkg_rt",1);
                    shtObj.SetCellEditable(i, "spcl_bx_amt",0);
                    shtObj.SetCellEditable(i, "spcl_teu_amt",0);
                    shtObj.SetCellEditable(i, "spcl_feu_amt",0);
                    shtObj.SetCellEditable(i, "spcl_rf_teu_amt",0);
                    shtObj.SetCellEditable(i, "spcl_rf_feu_amt",0);
                    shtObj.SetCellEditable(i, "spcl_chg_ctnt",0);
            	} else if (shtObj.GetCellValue(i, "spcl_div_cd") == "BS") {
                    shtObj.SetCellValue(i, "spcl_bx_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_teu_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_feu_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_rf_teu_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_rf_feu_amt",0,0);
                    shtObj.SetCellEditable(i, "spcl_bkg_rt",1);
                    shtObj.SetCellEditable(i, "spcl_bx_amt",0);
                    shtObj.SetCellEditable(i, "spcl_teu_amt",0);
                    shtObj.SetCellEditable(i, "spcl_feu_amt",0);
                    shtObj.SetCellEditable(i, "spcl_rf_teu_amt",0);
                    shtObj.SetCellEditable(i, "spcl_rf_feu_amt",0);
                    shtObj.SetCellEditable(i, "spcl_chg_ctnt",1);
            	} else if (shtObj.GetCellValue(i, "spcl_div_cd") == "CA") {
                    shtObj.SetCellValue(i, "spcl_bkg_rt",0,0);
                    shtObj.SetCellValue(i, "spcl_teu_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_feu_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_rf_teu_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_rf_feu_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_chg_ctnt","",0);
                    shtObj.SetCellEditable(i, "spcl_bkg_rt",0);
                    shtObj.SetCellEditable(i, "spcl_bx_amt",1);
                    shtObj.SetCellEditable(i, "spcl_teu_amt",0);
                    shtObj.SetCellEditable(i, "spcl_feu_amt",0);
                    shtObj.SetCellEditable(i, "spcl_rf_teu_amt",0);
                    shtObj.SetCellEditable(i, "spcl_rf_feu_amt",0);
                    shtObj.SetCellEditable(i, "spcl_chg_ctnt",0);
            	} else if (shtObj.GetCellValue(i, "spcl_div_cd") == "CS") {
                    shtObj.SetCellValue(i, "spcl_bkg_rt",0,0);
                    shtObj.SetCellValue(i, "spcl_bx_amt",0,0);
                    shtObj.SetCellValue(i, "spcl_chg_ctnt","",0);
                    shtObj.SetCellEditable(i, "spcl_bkg_rt",0);
                    shtObj.SetCellEditable(i, "spcl_bx_amt",0);
                    shtObj.SetCellEditable(i, "spcl_teu_amt",1);
                    shtObj.SetCellEditable(i, "spcl_feu_amt",1);
                    shtObj.SetCellEditable(i, "spcl_rf_teu_amt",1);
                    shtObj.SetCellEditable(i, "spcl_rf_feu_amt",1);
                    shtObj.SetCellEditable(i, "spcl_chg_ctnt",0);
                }
               }
                shtObj.SetRowStatus(i,"");
            }
        }
    }
     /**
     * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
     */
    function sheet1_setSheetData4(rowArray, row, col) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var colArray=rowArray[0];
        row=formObj.rowNum.value;
        col=formObj.colNum.value;
        sheetObj.SetCellValue(row, col,colArray[5],0);
    }
/* 개발자 작업 끝 */
