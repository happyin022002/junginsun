/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0007.js
*@FileTitle  : O/B Booking Office Info for China
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj=sheetObjects[0];
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "btn_retrieve":     // Retrieve
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
                case "btn_save":         // Save
                    doActionIBSheet(shtObj, frmObj, IBSAVE);
                    break;
                case "btn_downexcel":    // Down Excel
                    doActionIBSheet(shtObj, frmObj, IBDOWNEXCEL);
                    break;
                case "btn_add":           // Row Add
                    doActionIBSheet(shtObj, frmObj, IBINSERT);
                    break;
            } // end switch
        } catch(e) {
            if (e == "[object Error]") {
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
        var cnt=0;
        with(shtObj){
          
          document.form.pagerows.value=500;
          var HeadTitle="STS|SEQ|Agent|Agent Name|A/R Office|Vendor Code|Vendor Name|DEL" +
          "|vndr_delt_flg|bkg_blck_flg|vndr_cnt_cd|ofc_cd|diff_rmk|cust_cnt_cd|cust_seq|auto_dp_chk_flg|agn_eml|ar_ofc_cd|dir_pay_ofc_cd";
          (ComCountHeadTitle(HeadTitle), 0, 0, false);
          SetEditEnterBehavior("tab");

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                       {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chn_agn_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 , AcceptKeys:"E", InputCaseSensitive:1 },
                       {Type:"Text",      Hidden:0, Width:400,  Align:"Left",    ColMerge:0,   SaveName:"agn_nm",           KeyField:0 ,  CalcLogic:"",   Format:"", 			PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
                       {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"finc_ofc_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                       {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 , AcceptKeys:"N"},
                       {Type:"Text",      Hidden:0, Width:450,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500},
                       {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_delt_flg" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_blck_flg" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_cnt_cd" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"diff_rmk" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"auto_dp_chk_flg" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agn_eml" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ar_ofc_cd" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dir_pay_ofc_cd" } ];
           
          InitColumns(cols);
          SetSheetHeight(475);
          SetEditable(1);
          SetWaitImageVisible(0);
          SetColProperty("agn_nm", {AcceptKeys:"E|N|[ `-=~!@#$%^&*()_+[]\\;',.{}|:\"?]", InputCaseSensitive:1});
          SetColProperty("finc_ofc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});           
          SetColProperty("delt_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
          
          SetShowButtonImage(3);
          }
    }
    
    
    function initControl() {
        // OnChange 이벤트
        axon_event.addListener("change", "sheet1_OnChange", "finc_ofc_cd");
    }
    
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:       // A/R Office 목록 조회
                ComOpenWait(true);
                 var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH01);
                ACMXml2SelectItem(xmlStr, frmObj.finc_ofc_cd, "value0", "value0", true);
                ComOpenWait(false);
                break;
            case IBSEARCH:       // 조회
            	ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                 shtObj.DoSearch("ESM_ACM_0007GS.do", FormQueryString(frmObj) );
                ComOpenWait(false);
                break;
            case IBSAVE:         // 저장
                frmObj.f_cmd.value=MULTI;
                var sParam=shtObj.GetSaveString(false);
                if (sParam == "") return;
                ComOpenWait(true);
                sParam=sParam + "&"+ FormQueryString(frmObj);
                var sXml=shtObj.GetSaveData("ESM_ACM_0007GS.do", sParam);
                var dupVndrSeq=ComGetEtcData(sXml,"dup_vendor");
                if(dupVndrSeq != ""){
                	ComShowCodeMessage("ACM00030",dupVndrSeq);
                }else{
                		shtObj.LoadSaveData(sXml);
                }	
                ComOpenWait(false);
                break;
            case IBDOWNEXCEL:    // 엑셀다운로드
                ComOpenWait(true);
                shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
                ComOpenWait(false);
                break;
            case IBINSERT:       // 신규 행추가
                var newRowIdx=shtObj.DataInsert();
                // 조회 조건의 A/R Office를 finc_ofc_cd에 setting
                shtObj.SetCellValue(newRowIdx, "finc_ofc_cd",frmObj.finc_ofc_cd.value,0);
                shtObj.SetCellEditable(newRowIdx, "delt_flg",1);
                break;
        }
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
 	 function sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 A/R Office Select Object 생성
         doActionIBSheet(shtObj, document.form, SEARCH01);
     }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount()> 0) {
                ReDraw=false;
                for (var i=HeaderRows(); i<=LastRow(); i++) {
                    // MDM_VENDOR테이블에서 가져온 delt_flag가 Y면 agn_nm 컬럼 편집 비활성화, vendor 컬럼폰트 빨간색에 취소선
				if (GetCellValue(i, "vndr_delt_flg") == "Y") {
				    SetCellFont("FontColor", i, "vndr_seq", i, "vndr_lgl_eng_nm", "#C80000");
				    SetCellFont("FontColor", i, "vndr_lgl_eng_nm","#C80000");
				    SetCellFont("FontColor", i, "delt_flg","#C80000");
				    SetCellFont("FontStrike", i, "vndr_seq",  i, "vndr_lgl_eng_nm", 1);
				    SetCellFont("FontStrike", i, "vndr_lgl_eng_nm",1);
				    SetCellFont("FontStrike", i, "delt_flg",1);
                    }
                    // delt_flag가 Y면 agn_nm, vndr_seq 컬럼 편집 비활성화
					if (GetCellValue(i, "delt_flg") == "Y") {
                        SetCellEditable(i, "agn_nm",0);
                        SetCellEditable(i, "vndr_seq",0);
                        SetCellEditable(i, "vndr_lgl_eng_nm",0);
                    } else {
                        SetCellEditable(i, "agn_nm",1);
                        SetCellEditable(i, "vndr_seq",1);
                        SetCellEditable(i, "vndr_lgl_eng_nm",1);                    	
                    }
                }
                ReDraw=true;
            }
        }
    }
    /**
     * IBSeet내의 셀의 값을 편집하기 직전에 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnBeforeEdit(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "vndr_seq":
                    // Edit직전 빨간색에 취소선 일 수 있는 Cell속성을 Default로
					SetCellFont("FontColor", Row, Col,GetDataFontColor());
					SetCellFont("FontColor", Row, "vndr_lgl_eng_nm",GetDataFontColor());
					SetCellFont("FontStrikethru", Row, Col,0);
					SetCellFont("FontStrikethru", Row, "vndr_lgl_eng_nm",0);
                    break;
            }
        }
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
        			case "vndr_seq":
                    	SetCellValue(Row, "vndr_lgl_eng_nm", "", 0);                		
        				break;
        		}
        	}
        	return;
        }  
        
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "chn_agn_cd":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH02 + "&value0=" + Value + "&chn_agn_cd=" + ComTrim(Value));
                	if (ACMDecideErrXml(shtObj, xmlStr,GetCellValue(Row, "chn_agn_cd"))){
                        //SetCellValue(Row, "chn_agn_cd", "");
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);     
                		SetCellValue(Row, Col, "", 0);
                    }
                	break;
                case "finc_ofc_cd":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + Value + "&value8=A/R Office" + "&finc_ofc_cd=" + ComTrim(Value));
                    if (ACMDecideErrXml(shtObj, xmlStr,GetCellValue(Row, "finc_ofc_cd"))){
                        //SetCellValue(Row, "finc_ofc_cd", "");
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);    
                    	SetCellValue(Row, Col, "", 0);
                    }
                    break;
                case "vndr_seq":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + Value + "&vndr_seq=" + ComTrim(Value));
                    if (ACMDecideErrXml(shtObj, xmlStr,GetCellValue(Row, "vndr_seq"))) {
                        //Cellvalue2(Row, "vndr_lgl_eng_nm")="";
                        //SetCellValue(Row, "vndr_seq", "");
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);    
                    	SetCellValue(Row, Col, "", 0);
                    } else {
                        var vndrCntCd=ComGetEtcData(xmlStr, "vndr_cnt_cd");
                        // VENDOR의 COUNTRY CODE가 CN이 아닐경우 Error
                        if (vndrCntCd != undefined && vndrCntCd != "CN") {
                            ComShowCodeMessage("ACM00003", "Country Code of Vendor Code [" + Value + "]", "Vendor Code");
                            SetCellValue(Row, "vndr_lgl_eng_nm", "", 0); 
                        	SetCellValue(Row, Col, "", 0);
                        	setTimeout(function(){
                                SelectCell(Row, Col, true, "");
                            	},10);    
                        } else {
                            // 빨간색에 취소선 일 수 있는 Cell속성을 Default로 (OnBeforeEdit 보완)
							SetCellFont("FontColor", Row, Col,GetDataFontColor());
							SetCellFont("FontColor", Row, "vndr_lgl_eng_nm",GetDataFontColor());
							SetCellFont("FontStrikethru", Row, Col,0);
							SetCellFont("FontStrikethru", Row, "vndr_lgl_eng_nm",0);
                            SetCellValue(Row, "vndr_lgl_eng_nm",ComGetEtcData(xmlStr, "vndr_lgl_eng_nm"),0);
                            SetCellValue(Row, "vndr_cnt_cd",ComGetEtcData(xmlStr, "vndr_cnt_cd"),0);
                            SetCellValue(Row, "ofc_cd",ComGetEtcData(xmlStr, "ofc_cd"),0);
                        }
                    }
                    break;
                case "delt_flg":
                    if (Value == "Y") {
                        SetCellEditable(Row, "agn_nm",0);
                        SetCellEditable(Row, "vndr_seq",0);
                        SetCellEditable(Row, "vndr_lgl_eng_nm",0);
                    } else {
                        SetCellEditable(Row, "agn_nm",1);
                        SetCellEditable(Row, "vndr_seq",1);
                        SetCellEditable(Row, "vndr_lgl_eng_nm",1);
                    }
                    break;
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
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        var frmObj=document.form;
        var fincOfcCd=frmObj.finc_ofc_cd.value;
        doActionIBSheet(shtObj, frmObj, SEARCH01);
        frmObj.finc_ofc_cd.value=fincOfcCd;
        doActionIBSheet(shtObj, frmObj, IBSEARCH);
    }
/* 개발자 작업 끝 */
