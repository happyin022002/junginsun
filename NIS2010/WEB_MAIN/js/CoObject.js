/**
===============================================================================
프로그램  명  : UI관련 공통 함수 정의 Script 
프로그램개요  : 
작   성   자  :
작   성   일  :
===============================================================================
수정자/수정일 : 2006년 11월 03일 ( 10월 19일 초기적용)
수정사유/내역 : IBSheet Object의 OnSearchEnd(), OnSaveEnd() 이벤트발생 시 ComShowMessage() 처리 추가
===============================================================================
수정자/수정일 : 이경희/2008년 11월 13일
수정사유/내역 : 자바스크립트 통합으로 중복 함수 제거 및 자바스크립도움말을 위한 주석 수정
===============================================================================
*/

    /*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 UI(IBSheet, IBTab, IBMultiCombo) 관련 공통 자바스크립트 함수가 정의되어 있다.
     * 이 파일에서 제공하는 함수를 사용하기 위해서는 먼저 CoCommon.js 파일과 CoFormControl파일, CoMessage 파일을 include하여야 한다.
     * @author 한진해운
     */

    /**
     * @class CoObject : UI(IBSheet, IBTab, IBMultiCombo) 관련 공통 자바스크립트 함수가 정의되어 있다. 이 파일에서 제공하는 함수를 사용하기 위해서는 먼저 <font color="red">CoCommon.js 파일과 CoFormControl파일, CoMessage 파일</font>을 include하여야 한다.
     */
    function CoObject() {
        this.ComConfigSheet         = ComConfigSheet;
        this.ComEndConfigSheet      = ComEndConfigSheet;
        this.ComSheetObject         = ComSheetObject;
        this.ComGetSheetObjectTag   = ComGetSheetObjectTag;
        this.ComTabObject           = ComTabObject;
        this.ComComboObject         = ComComboObject;
        this.ComChartObject         = ComChartObject;
        this.ComUploadObject        = ComUploadObject;
        this.ComConfigUpload		= ComConfigUpload;
        this.ComCountHeadTitle      = ComCountHeadTitle;
        this.ComEtcDataToForm       = ComEtcDataToForm;
        this.ComEtcDataToForm2      = ComEtcDataToForm2;
        this.ComSheet2SheetCheck    = ComSheet2SheetCheck;
        this.ComGetSheetViewRows    = ComGetSheetViewRows;
        this.ComGetEtcData          = ComGetEtcData;
        this.ComGetTotalRows      	= ComGetTotalRows;        
        this.ComMakeSearchXml       = ComMakeSearchXml;
        this.ComIsModifiedSheets    = ComIsModifiedSheets;
        this.ComGetHiddenCols       = ComGetHiddenCols;
        this.ComGetSaveNameParam    = ComGetSaveNameParam;
        this.ComGetPrefixParam      = ComGetPrefixParam;
        this.ComGetSaveString       = ComGetSaveString;
        this.ComShowMemoPad         = ComShowMemoPad;
        this.ComHideMemoPad         = ComHideMemoPad;
        this.ComRowHideDelete       = ComRowHideDelete;
        this.ComSheetFiltering      = ComSheetFiltering;
        this.ComSaveGridSetting     = ComSaveGridSetting;
        this.ComSendIBHeaderRequest = ComSendIBHeaderRequest;
        this.ComRestoreGridSetting  = ComRestoreGridSetting;
        this.ComDelGridSetting      = ComDelGridSetting;
        this.ComSetPrifix      		= ComSetPrifix;
        this.ComXml2ComboString     = ComXml2ComboString;
        this.ComXml2ComboItem       = ComXml2ComboItem;
        this.ComColEditable     	= ComColEditable;
        this.ComDeleteMsg     		= ComDeleteMsg;
        this.ComSyncAllCheck		= ComSyncAllCheck;
        this.ComFindAll				= ComFindAll;
        this.ComGetComBoObject		= ComGetComBoObject;
        
    }

    /*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	var CLSID_IBTAB    = "CLSID:B4019746-931F-4116-912C-8A11406BDE80";
	var CLSID_IBMCOMBO = "CLSID:D9FA9278-6363-4906-A14E-0AFB460CEA90";
    var CLSID_IBSHEET  = "CLSID:DAB66ACA-49CD-41F2-89A0-8593DBB0C36C"; //IBSheet3N (유니코드버전)
    var SHEET_VERSION = "3,4,0,381";
    var COMBO_VERSION = "1,5,10,11";
    var IBTAB_VERSION = "1,1,4,11";
    var CODEBASE = "/hanjin/sheet/IBSheet3N.CAB#version="+SHEET_VERSION;
    var CODEBASECOMBO = "/hanjin/sheet/IBMultiComboU.CAB#version="+COMBO_VERSION;
    
    
    //각 페이지의 Sheet 이벤트 처리 함수를 실행하는 전역 변수
    /* IBSheet Action */
    IBSEARCH       = 0;  // 조회
    IBSEARCHAPPEND = 1;  // 페이징 조회
    IBSAVE         = 2;  // 저장
    IBINSERT       = 3;  // 삽입
    IBCLEAR        = 4;  // 초기화
    IBDOWNEXCEL    = 5;  // 엑셀 다운로드
    IBLOADEXCEL    = 6;  // 엑셀 업로드
    IBCOPYROW      = 7;  // 행복사
    IBDELETE       = 8;  // 삭제
    RDPRINT        = 9;  // RD 연결
    IBROWSEARCH    = 10; // Row 조회
    IBCREATE       = 11; // Create
    IBRESET        = 12; // Reset
    IBBATCH        = 13; // Batch


    /* Async  IBSheet Action */
    IBSEARCH_ASYNC01 = 901;
    IBSEARCH_ASYNC02 = 902;
    IBSEARCH_ASYNC03 = 903;
    IBSEARCH_ASYNC04 = 904;
    IBSEARCH_ASYNC05 = 905;
    IBSEARCH_ASYNC06 = 906;
    IBSEARCH_ASYNC07 = 907;
    IBSEARCH_ASYNC08 = 908;
    IBSEARCH_ASYNC09 = 909;
    IBSEARCH_ASYNC10 = 910;
    IBSEARCH_ASYNC11 = 911;
    IBSEARCH_ASYNC12 = 912;
    IBSEARCH_ASYNC13 = 913;
    IBSEARCH_ASYNC14 = 914;
    IBSEARCH_ASYNC15 = 915;
    IBSEARCH_ASYNC16 = 916;
    IBSEARCH_ASYNC17 = 917;
    IBSEARCH_ASYNC18 = 918;
    IBSEARCH_ASYNC19 = 919;
    IBSEARCH_ASYNC20 = 920;


    /**
     * Sheet의 기본 디자인을 설정한다. 이 함수는 반드시 Sheet 초기화 전에 호출해야 한다. <br>
     * 즉 Object태그 생성 직후에 이 함수를 호출하고, Sheet 초기화 한 후 마지막에 {@link #ComEndConfigSheet} 함수를 호출해야 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     function loadPage() {
     *         for(var i=0;i&lt;sheetObjects.length;i++){
     *             //1.시작-환경 설정 함수 이름 변경
     *             ComConfigSheet(sheetObjects[i]);
     *
     *             //2. Sheet 초기화
     *             initSheet(sheetObjects[i],i+1);
     *
     *             //3. 마지막-환경 설정 함수 추가
     *             ComEndConfigSheet(sheetObjects[i]);
     *         }
     *     }
     * </pre>
     * @param {ibsheet} sheet_obj   필수,IBSheet Object ID
     * @return 없음
     * @see #ComEndConfigSheet
     */
    function ComConfigSheet(sheet_obj)
    {
        try {

            with (sheet_obj)
            {
                SheetBackColor	      = RgbColor(243,242,248);  //Sheet 배경색
                HeadBackColor         = RgbColor(193,196,232);  //해더행 배경색
    			SheetOutLineColor	  = RgbColor(162,135,146);  // 시트의 외곽선 
    			
                DataBackColor         = RgbColor(255,255,255);  //데이터행 배경색(홀수)
                SelectBackColor       = RgbColor(231,250,246);  //2009.06.23 (249,249,249) --> 수정
                SubSumBackColor       = RgbColor(247,231,236);  //소계행 배경색
                CumulateBackColor     = RgbColor(232,255,198);  //누계행 배경색
                SumBackColor          = RgbColor(247,225,236);  //합계행 배경색
    
                HeadFontBold 	      = true;					//해더글자를 볼드사용여부
                SumFontBold           = true;                   //합계행 볼드여부
                HeadFontColor         = RgbColor(39,95,101);    //해더행 글자색
                DataFontColor         = RgbColor(37,35,65);     //데이터행 글자색
                SumFontColor          = RgbColor(37,35,65);     //합계행 글자색
    
                SheetFontName         = "Tahoma";     //2009.06.23 변경 Arial--> 글자체, Default:굴림체, 동일폭 폰트"Courier New"
                HeadRowHeight         = 20;                     //해더 행 높이, Default:26
                SheetFontSize         = 8;                      //글자크기, Default:9
    
                InLineColor           = RgbColor(225,225,225);  //안쪽선색
                OutLineColor          = RgbColor(147,147,148);  //바깥쪽선색
                EditableColorDiff     = true;                   //Default:false, Edit
    
                SelectFontBold        = false;                   //Default:false, 선택행 볼드여부
                MultiSelection        = true;                   //Default:false, 다중 선택 여부
                SelectionMode		  = smSelectionRow; 		//2009.06.23 추가
                SelectHighLight       = true;
                
                CountPosition         = 2;                      //건수위치,0:없음,1:좌상,2:우상,3:좌하,4:우하
    			CountBackColor		  = RgbColor(243,242,248);
                CountFontBold         = false;                  //Default:true, 건수글자볼드여부
                CountFormat           = "[SELECTDATAROW / ROWCOUNT]";
    
                DateFormatChar        = "-";                    //Default:., 날짜구분자,(-/.)
                ScrollTrack           = true;                   //Default:false, 스크롤과 데이타 같이이동
                ShowSortArrow         = true;                   //Default:false, 소트 화살표 표시여부
                EditEnterBehavior     = "down"                  //Default:tab, 편집중 Enter행동자
                EnterBehavior         = "tab";                  //Default:Edit, Enter행동자
                HeadFlat              = true;                   //Default:3D 해더평면여부
                DataAutoTrim          = false;                  //Default:true, 데이타 양쪽공백 트림여부
                ClipPasteMode 		  = 1;                      // 클립보드에 복사된 내용을 Sheet로 붙일 때 방식을 확인하거나 설정한다.
    
            	KoreaLanguageUse 	  = false ;

                // 2007.10.23 추가 (3.4.0.12버젼)
                AllowTabKeyOnDropDownList = true;
                
                /*default와 같은 경우 설정하지 않는것이 빠름
                DataAltanateBackColor = RgbColor(255,255,255);  //데이터행 배경색(짝수)
                DataRowHeight         = 20;                     //데이터 행 높이, Default:20
                FocusAfterProcess     = false;                  //Default:true, 조회후 포커스 뺏기여부
                FocusEditMode         = 2;		              // Edit 가능한 셀에 포커스가 들어갔을 때 Edit를 시작할지 여부를 확인하거나 설정한다.
                EditableColor         = RgbColor(255,255,0);    //Default:255,255,255, 흰색 Edit 가능 데이터 배경색
                SelectHighLight       = false;                  //Default:true, 하일라이트 여부
                RequestTimeOut        = 60;                     //Default:60초, 응답대기시간,초단위
                ShowButtonImage       = 0;                      //Default:0(Focus 있을때 팝업 이미지 표시), 3(Edit 가능시 팝업/콤보이미지 표시), 데이터 타입이 dtPopup, dtPopupEdit, dtCombo, dtComboEdit 일때 이미지 표시종류
                WaitImageVisible      = true;                  	//Default:true, 대기이미지 표시여부
                MultiLineText         = true;                   //Default:true, Shift+Enter 또는 Ctrl+Enter 이용 다중라인 입력가능여부
                */

                UnEditableColor       = RgbColor(239,240,243);   //Default:239,235,239, 회색 Edit 불가능 데이터 배경색
                RequestTimeOut        = 3000;                     //Default:60초, 응답대기시간,초단위
                PopupImage            = "/hanjin/img/btns_search.gif";     //팝업 버튼 이미지
                KeyFieldImage         = "/hanjin/img/ico_star.gif";        //필수 입력 이미지

                WaitImage             = "/hanjin/img/waiting_sheet.gif";
                DownLoadImage         = "/hanjin/img/waiting_sheet.gif";
                UpLoadImage           = "/hanjin/img/waiting_sheet.gif";

                MessageText("ConfirmTitle")     = "ALPS Confirmation";
                MessageText("WarningTitle")     = "ALPS Warning";
                MessageText("NoData")           = "There is no data to search" ;
                MessageText("Avg")              = "Average" ;
                MessageText("UserMsg00")        = "It's not appropriate date format." ;
                MessageText("UserMsg01")        = "It's not appropriate Year/Month format." ;
                MessageText("UserMsg02")        = "It's not appropriate Month/Day format." ;
                MessageText("UserMsg03")        = "It's not appropriate Number format." ;
                MessageText("UserMsg04")        = "It's not appropriate [Hour:Minute:Second] format.";
                MessageText("UserMsg05")        = "It's not appropriate [Hour:Minute] format." ;
                MessageText("UserMsg23")        = "The pasted data is not appropriate format." ;
                MessageText("UserMsg24")        = "It's not editable area." ;
                MessageText("UserMsg11")        = "As there is no result retrieved, it's impossible to download in the [EXCEL] format."  ;
                MessageText("UserMsg16")        = " is mandatory item." ;

                MessageText("UserMsg29")        = "Do you want to save?";
                MessageText("Sum")              = "TOTAL";
                MessageText("RequestProcess")   = "Processing";
            }
        } catch(err) { ComFuncErrMsg(err.message); }

    }

    /**
     * Sheet의 기본 디자인을 마무리 한다. 이 함수는 반드시 Sheet 초기화 후에 호출해야 한다. <br>
     * 즉 Object태그 생성 직후에 {@link #ComConfigSheet} 함수를 호출하고, Sheet 초기화 한 후 마지막에 이 함수를 호출해야 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     function loadPage() {
     *         for(var i=0;i&lt;sheetObjects.length;i++){
     *             //1.시작-환경 설정 함수 이름 변경
     *             ComConfigSheet(sheetObjects[i]);
     *
     *             //2. Sheet 초기화
     *             initSheet(sheetObjects[i],i+1);
     *
     *             //3. 마지막-환경 설정 함수 추가
     *             ComEndConfigSheet(sheetObjects[i]);
     *         }
     *     }
     * </pre>
     * @param {ibsheet} sheet_obj 필수,IBSheet Object ID
     * @return 없음
     * @see #ComConfigSheet
     */
    function ComEndConfigSheet (sheet_obj)
    {
        try {
        	//ALPS 표준상 두번째 해더행부터 색상이 변경되어야 함
		    var iColor= sheet_obj.RgbColor(203,210,248);
		    
		    for (var ir=1; ir < sheet_obj.HeaderRows; ir++) {
		    	sheet_obj.RowBackColor(ir) = iColor;
		    }

            sheet_obj.ExtendLastCol = true;
            sheet_obj.Visible = true;
            sheet_obj.PlusChar2Encoding = true;
            sheet_obj.XmlHttpVer = 2;
            sheet_obj.UsePost = true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }


    /**
     * Object태그를 이용하여 IBSheet 개체를 생성한다. 추가적으로 setSheetObject자바스크립트 함수를 호출하고, IBSheet의 모든 Event Catch 태그도 포함한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;script language="javascript"&gt;ComSheetObject('sheet1');&lt;/script&gt;
     * </pre>
     * @param {string} sheetid 필수,IBSheet Object ID 문자열
     * @return 없음
     */
    function ComSheetObject(sheetid,h){
        try {

            var sEventTag = ComGetSheetEventTag(sheetid);
            document.write(sEventTag);

            var sTag = ComGetSheetObjectTag(sheetid,h);
            document.write(sTag);

            //이 함수는 각 업무페이지 js 파일에 정의되어 있음
            //setSheetObject 함수를 호출한다.
            if (ComFuncCheck("setSheetObject")) setSheetObject(eval("document.all."+sheetid));
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * ComSheetObject()와 동일하며 ComGetSheetObjectTag1()을 호출하기 위한 메소드<br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;script language="javascript"&gt;ComSheetObject1('sheet1');&lt;/script&gt;
     * </pre>
     * @param {string} sheetid 필수,IBSheet Object ID 문자열
     * @return 없음
     */
    function ComSheetObject1(sheetid){
        try {

            var sEventTag = ComGetSheetEventTag(sheetid);
            document.write(sEventTag);

            var sTag = ComGetSheetObjectTag1(sheetid);
            document.write(sTag);

            //이 함수는 각 업무페이지 js 파일에 정의되어 있음
            //setSheetObject 함수를 호출한다.
            if (ComFuncCheck("setSheetObject")) setSheetObject(eval("document.all."+sheetid));
        } catch(err) { ComFuncErrMsg(err.message); }
    }


    /**
     * IBSheet의 Event 태그를 문자열로 반환하며 Event Catch 태그는 문자열에서 제외한다. <br>
     * {@link #ComSheetObject}함수와 달리 Object를 생성하지 않고, 단순히 문자열만을 반환한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sObjTag = ComGetSheetObjectTag("sheet1");
     * </pre>
     * @param {string} sheetid 필수,IBSheet Object ID 문자열
     * @return string,IBSheet의 Object태그 문자열
     * @see #ComSheetObject
     */
    function ComGetSheetEventTag(sheetid){
        try {

            var sEventTag = "";
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnAfterColumnMove(Col,NewPos)">                        if (!ComFuncCheck(id+"_OnAfterColumnMove")) return;  ComFunc(this,Col, NewPos);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnBeforeColumnMove(Col,NewPos)">                       if (!ComFuncCheck(id+"_OnBeforeColumnMove")) return; ComFunc(this,Col,NewPos);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnChange(Row, Col, Value)">                            if (!ComFuncCheck(id+"_OnChange")) return;           ComFunc(this,Row, Col, Value);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnChangeSum(Row)">                                     if (!ComFuncCheck(id+"_OnChangeSum")) return;        ComFunc(this,Row);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnClick(Row, Col, Value)">                             if (!ComFuncCheck(id+"_OnClick")) return;            ComFunc(this,Row, Col, Value);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnDblClick(Row,Col)">                                  if (!ComFuncCheck(id+"_OnDblClick")) return;         ComFunc(this,Row,Col);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnDebugMsg(Msg)">                                      if (!ComFuncCheck(id+"_OnDebugMsg")) return;         ComFunc(this,Msg);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnKeyDown(Row, Col, KeyCode, Shift)">                  if (!ComFuncCheck(id+"_OnKeyDown")) return;          ComFunc(this,Row, Col, KeyCode, Shift);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnKeyUp(Row, Col, KeyCode, Shift)">                    if (!ComFuncCheck(id+"_OnKeyUp")) return;            ComFunc(this,Row, Col, KeyCode, Shift);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnLoadExcel()">                                        if (!ComFuncCheck(id+"_OnLoadExcel")) return;        ComFunc(this);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnMouseDown(Button, Shift, X, Y)"> try{parent.callDisappearMenu2Flash();}catch(err){;} if (!ComFuncCheck(id+"_OnMouseDown")) return;         ComFunc(this,Button, Shift, X, Y);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnMouseMove(Button, Shift, X, Y)">                     if (!ComFuncCheck(id+"_OnMouseMove")) return;        ComFunc(this,Button, Shift, X, Y);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnMouseUp(Button, Shift, X, Y)">                       if (!ComFuncCheck(id+"_OnMouseUp")) return;          ComFunc(this,Button, Shift, X, Y);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnPopupClick(Row,Col)">                                if (!ComFuncCheck(id+"_OnPopupClick")) return;       ComFunc(this,Row,Col);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnResize(lWidth, lHeight)">                            if (!ComFuncCheck(id+"_OnResize")) return;           ComFunc(this ,lWidth, lHeight);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnSaveEnd(ErrMsg)">                                    if(ErrMsg!=null && ErrMsg!="") ComShowMessage(ErrMsg.replaceStr("<||>", "\\n"),this.EtcData("Exception"));     if (!ComFuncCheck(id+"_OnSaveEnd")) return; ComFunc(this ,ErrMsg);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnScroll(OlTopRow, OldLeftCol, NewTopRow, NewLeftCol)">if (!ComFuncCheck(id+"_OnScroll")) return;           ComFunc(this,OlTopRow, OldLeftCol, NewTopRow, NewLeftCol);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnScrollNext(CondParam, PageNo,OnePageRow)">           if (!ComFuncCheck(id+"_OnScrollNext")) return;       ComFunc(this,CondParam, PageNo,OnePageRow);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnSearchEnd(ErrMsg)">                                  if(ErrMsg!=null && ErrMsg!="") ComShowMessage(ErrMsg.replaceStr("<||>", "\\n"),this.EtcData("Exception"));     if (!ComFuncCheck(id+"_OnSearchEnd")) return; ComFunc(this ,ErrMsg);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnSelectCell(OldRow, OldCol, NewRow, NewCol)">         if (!ComFuncCheck(id+"_OnSelectCell")) return;       ComFunc(this,OldRow, OldCol, NewRow, NewCol);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnSelectMenu(MenuString)">                             if (!ComFuncCheck(id+"_OnSelectMenu")) return;       ComFunc(this ,MenuString);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnTreeChild(CondParam, Row)">                          if (!ComFuncCheck(id+"_OnTreeChild")) return;        ComFunc(this ,CondParam, Row);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnUserResize(Row,Col)">                                if (!ComFuncCheck(id+"_OnUserResize")) return;       ComFunc(this ,Row,Col);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnValidation(Row, Col, Value)">                        if (!ComFuncCheck(id+"_OnValidation")) return;       ComFunc(this,Row, Col, Value);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnBeforeEdit(Row,Col)">                                if (!ComFuncCheck(id+"_OnBeforeEdit")) return;        ComFunc(this,Row,Col);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnAfterEdit(Row,Col)">                                 if (!ComFuncCheck(id+"_OnAfterEdit")) return;        ComFunc(this,Row,Col);</script>\n';
            //2009.05.04 추가
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnBeforeCheck(Row,Col)">                               if (!ComFuncCheck(id+"_OnBeforeCheck")) return;      ComFunc(this,Row,Col);</script>\n';
            //세션이 끊어진 경우 OnServerMsg 이벤트로 처리한다.
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnServerMsg(Msg)">                                     if(Msg!="") {ComShowMessage(Msg.replaceStr("<||>", "\\n")); location.href="/hanjin/main.jsp"; }</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnSort(Col, SortArrow)">                               if (!ComFuncCheck(id+"_OnSort")) return;             ComFunc(this ,Col, SortArrow);</script>\n';
            //2009.07.30 추가
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnLoadFinish()">                               		if (!ComFuncCheck(id+"_OnLoadFinish")) return;      ComFunc(this);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnDownFinish(DownloadType, SaveAsName)">               if (!ComFuncCheck(id+"_OnDownFinish")) return;      ComFunc(this, DownloadType, SaveAsName);</script>\n';
            //2009.08.13 추가
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnComboChange(Row, Col, Code, Text)">                  if (!ComFuncCheck(id+"_OnComboChange")) return;      ComFunc(this, Row, Col, Code, Text);</script>\n';
            /*
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnRequestTimeOut(Sec)">                                if (!ComFuncCheck(id+"_OnRequestTimeOut")) return;   ComFunc(this ,Sec);</script>\n';
            sEventTag += '<script language="javascript" for="'+sheetid+'" event="OnMessage(Msg, MsgLevel, MsgCode, IsConfirm)">         if (!ComFuncCheck(id+"_OnMessage")) return;          ComFunc(Msg, MsgLevel, MsgCode, IsConfirm);</script>\n';
            */
            return sEventTag ;
        } catch(err) { ComFuncErrMsg(err.message); }
    }


    /**
     * IBSheet의 Object태그를 문자열로 반환하며 Event Catch 태그는 문자열에서 제외한다. <br>
     * {@link #ComSheetObject}함수와 달리 Object를 생성하지 않고, 단순히 문자열만을 반환한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sObjTag = ComGetSheetObjectTag("sheet1");
     * </pre>
     * @param {string} sheetid 필수,IBSheet Object ID 문자열
     * @return string,IBSheet의 Object태그 문자열
     * @see #ComSheetObject
     */
    function ComGetSheetObjectTag(sheetid,h){
        try {
            var sTag = "";

            if (!h) h = "100%";
            
            sTag += '<OBJECT ID="'+sheetid+'"  width="100%" height="' + h +'" \n';
            sTag += ' CLASSID="'+CLSID_IBSHEET+'" \n';
            sTag += ' CODEBASE="'+CODEBASE+'"> \n';
            sTag += ' <param name="Visible" value="false"> \n';
            sTag += ' <param name="UseUTF8" value="true"> \n';
            sTag += ' <param name="AutoSizeMode" value="true"> \n';
            sTag += '</OBJECT>';

			//alert(sTag);
            return sTag ;
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * ComGetSheetObjectTag()와 동일하며 AutoSizeMode를 false 해야 될 경우에만 사용한다. <br>
     * {@link #ComSheetObject}함수와 달리 Object를 생성하지 않고, 단순히 문자열만을 반환한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sObjTag = ComGetSheetObjectTag1("sheet1");
     * </pre>
     * @param {string} sheetid 필수,IBSheet Object ID 문자열
     * @return string,IBSheet의 Object태그 문자열
     * @see #ComSheetObject
     */
    function ComGetSheetObjectTag1(sheetid){
        try {
            var sTag = "";

            sTag += '<OBJECT ID="'+sheetid+'"  \n';
            sTag += ' CLASSID="'+CLSID_IBSHEET+'" \n';
            sTag += ' CODEBASE="'+CODEBASE+'"> \n';
            sTag += ' <param name="Visible" value="false"> \n';
            sTag += ' <param name="UseUTF8" value="true"> \n';
            sTag += ' <param name="AutoSizeMode" value="false"> \n';
            sTag += '</OBJECT>';

			//alert(sTag);
            return sTag ;
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * Object태그를 이용하여 IBTab 개체를 생성한다. 추가적으로 setTabObject자바스크립트 함수를 호출하고, IBTab의 모든 Event Catch 태그도 포함한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;script language="javascript"&gt;ComTabObject('tab1');&lt;/script&gt;
     *     &lt;script language="javascript"&gt;ComTabObject('tab1', "blue", 200, 30);&lt;/script&gt;
     *     &lt;script language="javascript"&gt;ComTabObject('tab1', null,   200, 30);&lt;/script&gt;
     * </pre>
     * @param {string} tabid        필수,IBTab Object ID 문자열
     * @param {string} sBaseColor   선택,Tab의 Base 색상을 설정한다 . 미설정시 흰색("white")으로 한다.
     * @param {int}    iWidth       선택,Tab의 넓이, default="100%"
     * @param {int}    iHeight      선택,Tab의 높이, default="25"
     * @return 없음
     */
    function ComTabObject(tabid, sBaseColor, iWidth, iHeight, iVisible)
    {
        try {
            var sTag = "";
            var sEventTag = "";

            if (iWidth    == undefined || iWidth    == null) iWidth = "100%";
            if (iHeight   == undefined || iHeight   == null) iHeight = "27";
            if (sBaseColor== undefined || sBaseColor== null) sBaseColor = "white";
            if (iVisible== undefined || iVisible== null) iVisible = true;


            sTag += '<OBJECT id="'+tabid+'" width="'+ iWidth +'" height="'+ iHeight +'" \n';
            sTag += '        CLASSID="'+CLSID_IBTAB+'" \n';
            sTag += '        CODEBASE="/hanjin/sheet/IBTab.CAB#version='+ IBTAB_VERSION +'"> \n';
	        sTag += '    <PARAM name="TabMouseOverEffect" value="false"> \n' ;
	        sTag += '    <PARAM name="BackColor" value="206,220,246"> \n' ;
	        sTag += '    <PARAM name="BaseColor" value="'+sBaseColor+'">  \n' ;
	        sTag += '    <PARAM name="SelectBackColor" value="131,133,217"> \n' ;
	        sTag += '    <PARAM name="FontColor" value="54,55,114"> \n' ;
	        sTag += '    <PARAM name="SelectFontColor" value="54,55,114"> \n' ;
	        sTag += '    <PARAM name="Visible" value="'+iVisible+'">  \n' ;
            sTag += '</OBJECT> \n';
            document.write(sTag);

            //setTabObject 함수를 호출한다.
            if (ComFuncCheck("setTabObject")) setTabObject(eval("document.all."+tabid));

            //2008-12-16 이경희 : OnChange 이벤트에서 메인페이지에 있는 syncHeight를 호출하도록 함
            sEventTag += '<script language="javascript" for="'+tabid+'" event="OnBlur()">                if (!ComFuncCheck(id+"_OnBlur")) return;        ComFunc(this);</script>\n';
            sEventTag += '<script language="javascript" for="'+tabid+'" event="OnChange(tabindex)">      if (!ComFuncCheck(id+"_OnChange")) return;      this.focus(); ComFunc(this,tabindex); try{top.syncHeight()}catch(err){;} </script>\n';
            sEventTag += '<script language="javascript" for="'+tabid+'" event="OnClear()">               if (!ComFuncCheck(id+"_OnClear")) return;       ComFunc(this);</script>\n';
            sEventTag += '<script language="javascript" for="'+tabid+'" event="OnClick(tabindex)">       if (!ComFuncCheck(id+"_OnClick")) return;       ComFunc(this,tabindex);</script>\n';
            sEventTag += '<script language="javascript" for="'+tabid+'" event="OnFocus()">               if (!ComFuncCheck(id+"_OnFocus")) return;       ComFunc(this);</script>\n';
            sEventTag += '<script language="javascript" for="'+tabid+'" event="OnKeyDown(keycode,shift)">if (!ComFuncCheck(id+"_OnKeyDown")) return;     ComFunc(this,keycode,shift);</script>\n';
            sEventTag += '<script language="javascript" for="'+tabid+'" event="OnLoadFinish()">          if (!ComFuncCheck(id+"_OnLoadFinish")) return;  ComFunc(this);</script>\n';
            document.write(sEventTag);
        } catch(err) { ComFuncErrMsg(err.message); }
    }


    /**
     * Object태그를 이용하여 IBMultiCombo 개체를 생성한다. 추가적으로 setComboObject자바스크립트 함수를 호출하고, IBMultiCombo의 모든 Event Catch 태그도 포함한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;script language="javascript"&gt;ComComboObject('combo1', 1, 100, 0, 2);&lt;/script&gt;
     *     &lt;script language="javascript"&gt;ComComboObject('combo1', 2, 150, 1);&lt;/script&gt;
     * </pre>
     * @param {string} comboid      필수,IBCombo Object ID 문자열
     * @param {int}    iColCnt      선택,콤보리스트에 컬럼의 개수로 최소 1이상, default=1
     * @param {int}    iWidth       선택,Object의 넓이, default=150
     * @param {int}    iStyle       선택,편집가능불가능여부 (0=편집가능, 1=편집불가능), default=0
     * @param {int}    iCss       	선택,스타일 처리 (input=0 input1=1 input1_1=2 input2=3 input2_1=4)
     * @param {int}    iShowCol     선택,멀티 컬럼일때 보여주고 싶은 컬럼의 인덱스, default=0
     * @param {int}    iEdit       	선택,에디터 상태에서 콤보리스트에 없는 값의 유지 여부 , default=false
     * @param {int}    iTab       	선택,탭오더의 설정
     * @return 없음
     */
    function ComComboObject(comboid, iColCnt, iWidth , iStyle, iCss, iShowCol, iEdit, iTab, iUseCode)
    {
        try {
            var sTag = "";
            var sEventTag = "";
            var sCss = new Array("mult_combo", "mult_combo1", "mult_combo1_1", "mult_combo2", "mult_combo2_1");
            if (iWidth == undefined  || iWidth == null) iWidth = 150;
            if (iColCnt == undefined || iColCnt == null || iColCnt<1 ) iColCnt = 1;
            if (iStyle == undefined  || iStyle == null) iStyle = 0;
            if (iCss == undefined  	|| iCss == null) iCss = 0;
            if (iShowCol == undefined || iShowCol == null) iShowCol = 0;
            if (iEdit == undefined || iEdit == null) iEdit = false;
            if (iTab == undefined || iTab == null) iTab = "";
            if (iUseCode == undefined || iUseCode == null) iUseCode = true;
            sTag += '<OBJECT id="'+comboid+'" name="'+comboid+'"  class="'+sCss[iCss]+'" WIDTH="'+ iWidth +'" tabindex="'+ iTab +'" HEIGHT="18" align="absmiddle" \n';
            sTag += '        CLASSID="'+CLSID_IBMCOMBO+'" \n';
            sTag += '        CODEBASE="' + CODEBASECOMBO + '" > \n';
            sTag += ' <param name="ColCnt" value="'+iColCnt+'"> \n';
            sTag += ' <param name="ShowCol" value="'+iShowCol+'"> \n';
            sTag += ' <param name="FontName" value="Tahoma"> \n';
            sTag += ' <param name="UseCode" value="'+iUseCode+'"> \n';
            sTag += ' <param name="UseEdit" value="'+iEdit+'"> \n';
            sTag += ' <param name="DisabledBackColor" value="#E8E7EC"> \n';
            sTag += ' <param name="DisabledFontColor" value="#606060"> \n';
            sTag += ' <param name="SelectBackColor" value="#316AC5"> \n';
            sTag += ' <param name="Style" value="'+iStyle+'"> \n';
            sTag += ' <param name="MouseOverFontBold" value="false"> \n';
            sTag += ' <param name="MultiSeparator" value=","> \n';
            sTag += '</OBJECT> \n';
            //alert(sTag);
            document.write(sTag);

            //이 함수는 각 업무페이지 js 파일에 정의되어 있음
            //setComboObject 함수를 호출한다.
            if (ComFuncCheck("setComboObject")) setComboObject(eval("document.all."+comboid));

            sEventTag += '<script language="javascript" for="'+comboid+'" event="OnBlur()">                 if (!ComFuncCheck(id+"_OnBlur")) return;         ComFunc(this);</script>\n';
            sEventTag += '<script language="javascript" for="'+comboid+'" event="OnChange(value,text)">     if (!ComFuncCheck(id+"_OnChange")) return;       ComFunc(this,value,text);</script>\n';
            sEventTag += '<script language="javascript" for="'+comboid+'" event="OnClear()">                if (!ComFuncCheck(id+"_OnClear")) return;        ComFunc(this);</script>\n';
            sEventTag += '<script language="javascript" for="'+comboid+'" event="OnFocus()">                if (!ComFuncCheck(id+"_OnFocus")) return;        ComFunc(this);</script>\n';
            sEventTag += '<script language="javascript" for="'+comboid+'" event="OnKeyDown(keycode,shift)"> if (!ComFuncCheck(id+"_OnKeyDown")) return;      ComFunc(this ,keycode,shift);</script>\n';
            sEventTag += '<script language="javascript" for="'+comboid+'" event="OnKeyUp(keycode,shift)">   if (!ComFuncCheck(id+"_OnKeyUp")) return;      ComFunc(this ,keycode,shift);</script>\n';
            sEventTag += '<script language="javascript" for="'+comboid+'" event="OnLoadFinish()">           if (!ComFuncCheck(id+"_OnLoadFinish")) return;   ComFunc(this);</script>\n';
            sEventTag += '<script language="javascript" for="'+comboid+'" event="OnCheckClick(index,code)"> if (!ComFuncCheck(id+"_OnCheckClick")) return;   ComFunc(this,index,code);</script>\n';

            document.write(sEventTag);
        } catch(err) { ComFuncErrMsg(err.message); }

    }

     /**
      * Object태그를 이용하여 IBMultiCombo 개체를 생성한다. <br>
      * UseCode = false 인 멀티콤보 생성<br>
      * <br><b>Example :</b>
      */
     function ComComboObject1(comboid, iColCnt, iWidth , iStyle, iCss, iShowCol, iEdit, iTab)
     {
          if (iColCnt == undefined || iColCnt == null || iColCnt<1 ) iColCnt = 1;
          if (iWidth == undefined  || iWidth == null) iWidth = 150;
          if (iStyle == undefined  || iStyle == null) iStyle = 0;
          if (iCss == undefined  	|| iCss == null) iCss = 0;
          if (iShowCol == undefined || iShowCol == null) iShowCol = 0;
          if (iEdit == undefined || iEdit == null) iEdit = false;
          if (iTab == undefined || iTab == null) iTab = "";
    	  ComComboObject(comboid, iColCnt, iWidth , iStyle, iCss, iShowCol, iEdit, iTab, false);
     }

     /**
     * Object태그를 이용하여 IBChart 개체를 생성한다. 추가적으로 setChartObject자바스크립트 함수를 호출하고, IBChart의 모든 Event Catch 태그도 포함한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;script language="javascript"&gt;ComChartObject('chart1');&lt;/script&gt;
     *     &lt;script language="javascript"&gt;ComChartObject('chart2', 355, 200);&lt;/script&gt;
     * </pre>
     * @param {string} id           필수,IBChart Object ID 문자열
     * @param {int}    iWidth       선택,Object의 넓이, default=755
     * @param {int}    iHeight      선택,Object의 높이, default=355
     * @return 없음
     */
    function ComChartObject(id, iWidth , iHeight )
    {
        try {
            var sTag = "";
            var sEventTag = "";

            if (iWidth==undefined  || iWidth == null) iWidth = "755";
            if (iHeight==undefined || iHeight == null) iHeight = "355";

            sTag += '<object classid="clsid:5220cb21-c88d-11cf-b347-00aa00a28331">  \n';
            sTag += ' <param name="LPKPath" value="/hanjin/sheet/ibchart.lpk"> \n';
            sTag += ' </object> \n';
            sTag += '<object id="'+id+'" width='+ iWidth +'" height="'+ iHeight +'" classid="clsid:9cd77d36-9a9f-4cf8-86c5-18ae5b8ca118" codebase="/hanjin/sheet/ibchart.cab#version=1,0,0,24">  \n';
            sTag += '</OBJECT> \n';
            document.write(sTag);

            //이 함수는 각 업무페이지 js 파일에 정의되어 있음
            //setChartObject 함수를 호출한다.
            if (ComFuncCheck("setChartObject")) setChartObject(eval("document.all."+id));

            sEventTag += '<script language="javascript" for="'+id+'" event="Click()">                                           if (!ComFuncCheck(id+"_Click")) return;           ComFunc(this);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="DblClick()">                                        if (!ComFuncCheck(id+"_DblClick")) return;        ComFunc(this);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="DoneFetchXml()">                                    if (!ComFuncCheck(id+"_DoneFetchXml")) return;    ComFunc(this);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="FailFetchXml()">                                    if (!ComFuncCheck(id+"_FailFetchXml")) return;    ComFunc(this);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="KeyDown(keycode,shift)">                            if (!ComFuncCheck(id+"_KeyDown")) return;         ComFunc(this,keycode,shift);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="KeyUp(keycode,shift)">                              if (!ComFuncCheck(id+"_KeyUp")) return;           ComFunc(this,keycode,shift);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="KeyPress(keyascii)">                                if (!ComFuncCheck(id+"_KeyPress")) return;        ComFunc(this,keyascii);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="MouseDown(button, shift, x, y)">                    if (!ComFuncCheck(id+"_MouseDown")) return;       ComFunc(this,button, shift, x, y);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="MouseUp(button, shift, x, y)">                      if (!ComFuncCheck(id+"_MouseUp")) return;         ComFunc(this,button, shift, x, y);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="MouseMove(button, shift, x, y)">                    if (!ComFuncCheck(id+"_MouseMove")) return;       ComFunc(this,button, shift, x, y);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="PointClick(chartid, seriesindex, pointindex)">      if (!ComFuncCheck(id+"_PointClick")) return;      ComFunc(this,chartid, seriesindex, pointindex);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="PointDblClick(chartid, seriesindex, pointindex)">   if (!ComFuncCheck(id+"_PointDblClick")) return;   ComFunc(this,chartid, seriesindex, pointindex);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="Repaint(hdc, left, top, width, height)">            if (!ComFuncCheck(id+"_Repaint")) return;         ComFunc(this,hdc, left, top, width, height);</script>';
            sEventTag += '<script language="javascript" for="'+id+'" event="Resize(height, width)">                             if (!ComFuncCheck(id+"_Resize")) return;          ComFunc(this ,height, width);</script>';

            document.write(sEventTag);
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * Object태그를 이용하여 IBUpload 개체를 생성한다. 추가적으로 setUploadObject자바스크립트 함수를 호출하고, IBUpload의 모든 Event Catch 태그도 포함한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;script language="javascript"&gt;ComUploadObject('upload1', '&lt;%=session.getId()%&gt;');&lt;/script&gt;
     *     &lt;script language="javascript"&gt;ComUploadObject('upload1', '&lt;%=session.getId()%&gt;', 200, 30);&lt;/script&gt;
     * </pre>
     * @param {string} objid        필수,IBUpload Object ID 문자열
     * @param {string} ssid         필수,세션ID
     * @param {int}    iWidth       선택,IBUpload의 넓이, default=0
     * @param {int}    iHeight      선택,IBUpload의 높이, default=0
     * @return 없음
     */
    function ComUploadObject(objid, ssid, iWidth, iHeight)
    {
        try {
            var sTag = "";
            var sEventTag = "";
            if (iWidth    == undefined || iWidth    == null) iWidth = "0";
            if (iHeight   == undefined || iHeight   == null) iHeight = "0";


            sTag += '<OBJECT id="'+objid+'" width="'+ iWidth +'" height="'+ iHeight +'" \n';
            sTag += '        CLASSID="CLSID:6D795D00-FDC0-4034-8EFF-1EE3DEA45183" \n';
            sTag += '        CODEBASE="/hanjin/sheet/IBUploadU.CAB#version=1,5,0,76"> \n';
            sTag += ' <param name="ssId" value="'+ ssid +'">';
            sTag += '</OBJECT> \n';
            document.write(sTag);

            //setTabObject 함수를 호출한다.
            if (ComFuncCheck("setUploadObject")) setUploadObject(eval("document.all."+objid));

            //2008-12-16 이경희 : OnChange 이벤트에서 메인페이지에 있는 syncHeight를 호출하도록 함
            sEventTag += '<script language="javascript" for="'+objid+'" event="OnClick()">												if (!ComFuncCheck(id+"_OnClick")) return;       	ComFunc(this);</script>\n';
            sEventTag += '<script language="javascript" for="'+objid+'" event="OnDblClick()">											if (!ComFuncCheck(id+"_OnDblClick")) return;       	ComFunc(this);</script>\n';
            sEventTag += '<script language="javascript" for="'+objid+'" event="OnDownloadResult(File,isUserCancel)">					if (!ComFuncCheck(id+"_OnDownloadResult")) return;  ComFunc(this,File,isUserCancel);</script>\n';
            sEventTag += '<script language="javascript" for="'+objid+'" event="OnFileClick(File,LocalFile,WebFile)">					if (!ComFuncCheck(id+"_OnFileClick")) return;       ComFunc(this,File,LocalFile,WebFile);</script>\n';
            sEventTag += '<script language="javascript" for="'+objid+'" event="OnFileDblClick(File,FileLocal,FileWeb)">					if (!ComFuncCheck(id+"_OnFileDblClick")) return;    ComFunc(this,File,FileLocal,FileWeb);</script>\n';
            sEventTag += '<script language="javascript" for="'+objid+'" event="OnKeyDown(KeyCode,Shift)">								if (!ComFuncCheck(id+"_OnKeyDown")) return;       	ComFunc(this,KeyCode,Shift);</script>\n';
            sEventTag += '<script language="javascript" for="'+objid+'" event="OnKeyPress(KeyAscii)">									if (!ComFuncCheck(id+"_OnKeyPress")) return;       	ComFunc(this,KeyAscii);</script>\n';
            sEventTag += '<script language="javascript" for="'+objid+'" event="OnKeyUp(KeyCode,Shift)">									if (!ComFuncCheck(id+"_OnKeyUp")) return;       	ComFunc(this,KeyCode,Shift);</script>\n';
            sEventTag += '<script language="javascript" for="'+objid+'" event="OnMessage(Message,MsgCode,Description,EventFile, File2)">if (!ComFuncCheck(id+"_OnMessage")) return;       	ComFunc(this,Message,MsgCode,Description,EventFile, File2);</script>\n';
            sEventTag += '<script language="javascript" for="'+objid+'" event="OnMouseDown(Button,Shift,X,Y)">							if (!ComFuncCheck(id+"_OnMouseDown")) return;       ComFunc(this,Button,Shift,X,Y);</script>\n';
            sEventTag += '<script language="javascript" for="'+objid+'" event="OnMouseMove(Button,Shift,X,Y)">							if (!ComFuncCheck(id+"_OnMouseMove")) return;       ComFunc(this,Button,Shift,X,Y);</script>\n';
            sEventTag += '<script language="javascript" for="'+objid+'" event="OnMouseUp(Button,Shift,X,Y)">							if (!ComFuncCheck(id+"_OnMouseUp")) return;       	ComFunc(this,Button,Shift,X,Y);</script>\n';
            document.write(sEventTag);

        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * IBUpload의 기본 속성을 설정한다. 이 함수에서 설정된것을 변경하고자 한다면 initUpload함수에서 재설정할 수 있다.<br>
     * Object태그 생성 후에 이 함수를 호출하고, sPageUrl인자는 파일저장을 처리할 서버페이지명을 설정한다.<br>
     * 파일저장을 처리할 서버페이지명은 웹루트를 기준으로 설정하며 Example과 같이 설정한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     function loadPage() {
     *         for(var i=0;i&lt;uploadObjects.length;i++){
     *             //1. 기본 환경 설정
     *             ComConfigUpload(uploadObjects[i], "/hanjin/xxxxxGS.do");
     *
     *             //2. Upload 초기화
     *             initUpload(uploadObjects[i],i+1);
     *         }
     *     }
     * </pre>
     * @param {ibupload}	uploadObj	필수,IBUpload Object ID
     * @param {string} 		sPageUrl	필수,파일저장을 처리할 서버페이지명이며 웹루트를 기준으로 문자열로 설정한다.
     * @return 없음
     */
    function ComConfigUpload(uploadObj, sPageUrl)
    {
        try {
	    	//서버환경설정
			uploadObj.UploadServerIP 	= location.hostname;
	    	//운영서버에서 기본포트를 사용하여 에러가 발생 채크로직 추가.2009-12-23
			if(location.port == undefined || location.port == null || location.port =="")
				uploadObj.UploadServerPort 	= 80;  
			else
				uploadObj.UploadServerPort 	= location.port;  
			uploadObj.UploadProgramPath = sPageUrl;
			//uploadObj.UploadDir 		= "ibsample\\Sample_IBUpload\\upload_files"; //업로드할 서버 Dir,웹루트 이하 경로
			
			//인코딩 설정
			uploadObj.DownloadEncoding 	= 2;
			uploadObj.UploadEncoding 	= "utf-8";  
			
			//기본설정
			uploadObj.ModeRW 			= "W";
			uploadObj.AutoUpload 		= false;
			uploadObj.IsUploadWithDelete= true;
			
        } catch(err) { ComFuncErrMsg(err.message); }
    }


    /**
     * Sheet의 헤더 타이틀 문자열을 받아서 컬럼의 개수를 리턴한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     HeadTitle = "Status|CNTR No.|TY/SZ|MATL|PUC|PUCredit|Min O/H Days|Free Days|DII Fee|Old /New|M/Date|Manufacturer|Lift on Charge";
     *     ret = ComCountHeadTitle(HeadTitle);    //결과 : 13
     * </pre>
     * @param {string} sHeadTitle 필수,Sheet의 헤더 타이틀 문자열
     * @return int, 컬럼개수
     */
    function ComCountHeadTitle(sHeadTitle){
        try {
            return sHeadTitle.split("|").length;
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    // IBSheetInfo.js 에서 이동 //
    /**
     * Sheet에 존재하는 EtcData의 값을 폼의 객체에 채운다. 주로 조회 함수 사용 후 이 함수를 사용한다. <br>
     * IBSheetInfo.js의 IBS_EtcData2Form 함수를 가져와서 코드를 수정한 함수이다. <br>
     * 이때 주의할 점은 Form오브젝트안에 존재하는 컨트롤의 name와 EtcData의 KeyName과 같아야 한다. 예를 들면 다음과 같다. <br>
     * form1.<font color="red">age</font>.value     = mySheet.EtcData("<font color="red">age</font>") -> ComEtcDataToForm(form1, mySheet) 처리 가능 <br>
     * form1.<font color="red">t1_name</font>.value = mySheet.EtcData("<font color="red">name</font>") -> ComEtcDataToForm(form1, mySheet) 처리 불가 <br>
     * 위와 같이 이름은 다르지만 Form안에 컨트롤Name들에 일정한 prefix가 있다면 sPrefix인자를 설정하여 다음과 같이 호출한다.
     * ComEtcDataToForm(frmMaster, sheet1, "t1_");
     * <br><b>Example :</b>
     * <pre>
     *     ComEtcDataToForm(frmMaster, sheet1);
     * </pre>
     * @param {form}    form     필수,Form 오브젝트
     * @param {ibsheet} sheetObj 필수,IBSheet Object ID\
     * @param {string}  sPrefix  선택,Form 안의 컨트롤Name 앞에 붙은 prefix 문자열, default=""
     * @return int, Match된 필드의 개수
     * @see #ComEtcDataToForm2
     */
    function ComEtcDataToForm(form,sheetObj,sPrefix){
    	var iMatchCnt=0;
        try {
            if (typeof(form) != "object" || form.tagName != "FORM") {
            	alert("It is not a FORM of [ComEtcDataToFomrm].");
                return "";
            }

            //sheetObjInfo.js의 IBS_EtcData2Form에서 이 부분을 주석으로 막았음
            //form을 리셋한다.
            //form.reset();
            
            if (sPrefix==undefined || sPrefix==null) sPrefix="";

            var elems   = form.elements;

            //사용가능한 HTML컨트롤을 배열로 생성한다.
            for (var i = 0; i < elems.length; i++) {
                var xvalue, sName;
                if(elems[i].classid == undefined){
                	sName = elems[i].name; 	//Html오브젝트인경우
                }else{
                	sName = elems[i].id;	//IBMultiCombo인경우
                }

                if (sName == "") continue;
                
                //Form 안의 컨트롤Name 앞에 붙은 prefix 문자열을 제거하기
            	if (sPrefix.length > sName.length) continue;
            	if (sName.substr(0,sPrefix.length) != sPrefix) continue;
            	sName = sName.substr(sPrefix.length);
            	
                xvalue = sheetObj.EtcData(sName);

                //radio인 경우 같은이름으로 여러개 있는 경우
                if (elems[i].type =="radio") {
                    var eRadio = document.all[sName];
                    //첫번째 radio만 체크하고 나머지 건너뛰기
                    if(eRadio.length>1) i += (eRadio.length-1);

                    if (xvalue != undefined) {
                    	ComSetObjValue(eRadio, xvalue);
                    	iMatchCnt++;
                    }
                    continue;
                }
                //해당이름의 EtcData가 없는 경우 다음 항목 찾기
                if ( xvalue == undefined)  continue;

                //radio인 경우를 제외하고 모두 여기서 값이 설정된다.
                ComSetObjValue(elems[i], xvalue);
                
                iMatchCnt++;
             }//for
        } catch(err) { ComFuncErrMsg(err.message); }
        
        return iMatchCnt;
    }

    /**
     * Sheet에 존재하는 EtcData의 값을 폼의 객체에 채운다. 주로 조회 함수 사용 후 이 함수를 사용한다. <br>
     * ComEtcDataToForm함수와 유사한 기능을 처리하나 다른점은 Form오브젝트 안에 존재하는 컨트롤의 Name과 IBSheet의 EtcData의 KeyName을 Match하는 방식이 다르다.<br>
     * ComEtcDataToForm함수는 두개 이름이 동일해야 값을 가져오는 반면 이 함수는 다음과 같이 "_"를 제거하고, "_"뒤의 첫글자를 대문자로 변경한 이름이 동일해야 값을 가져온다.<br>
     * 예를 들면 다음과 같다. <br>
     * form1.<font color="red">vvd_cd</font>.value    = mySheet.EtcData("<font color="red">vvdCd</font>")		-> ComEtcDataToForm2(form1, mySheet) 처리 가능 <br>
     * form1.<font color="red">vvd_cd_nm</font>.value = mySheet.EtcData("<font color="red">vvdCdNm</font>")		-> ComEtcDataToForm2(form1, mySheet) 처리 가능 <br>
     * form1.<font color="red">vvd_cd_nm</font>.value = mySheet.EtcData("<font color="red">vvd_cd_nm</font>") 	-> ComEtcDataToForm2(form1, mySheet) 처리 불가, ComEtcDataToForm(form1, mySheet) 처리 가능<br>
     * form1.<font color="red">vvd_cd_nm</font>.value = mySheet.EtcData("<font color="red">cdNm</font>")		-> ComEtcDataToForm2(form1, mySheet) 처리 불가, ComEtcDataToForm2(form1, mySheet, "vvd_") 처리 가능<br>
     * 위의 마지막 예제처럼 이름은 다르지만 Form안에 컨트롤 Name들에 일정한 prefix가 있다면 sPrefix인자를 설정하여 다음과 같이 호출한다. <br>
     *     ComEtcDataToForm2(formObj, sheetObj, "vvd_");
     * 위 3개 중 2개만 match되는 값을 가져오고, 1개는 match되는 값이 없으므로 무시된다. <br>
     * bValueClear인자를 true로 설정하면 위의 예에서 match되지 않는 1개를 무시하지 않고, 값을 clear한다. 이때 {@link CoFormControl#ComClearObject}함수를 이용한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComEtcDataToForm2(form, sheet1); 			//match되는 값만 가져오기
     *     ComEtcDataToForm2(form, sheet1, "", true);	//match되는 값은 가져오고, match되지 않는 html필드값은 clear하기
     *     ComEtcDataToForm2(form, sheet1, "pay_");		//html필드이름앞에 prefix로 "pay_"를 제외하고 match되는 값은 가져오기
     * </pre>
     * @param {form}    form     	필수,Form 오브젝트
     * @param {ibsheet} sheetObj 	필수,IBSheet Object ID
     * @param {string}  sPrefix  선택,Form 안의 컨트롤Name 앞에 붙은 prefix 문자열, default=""
     * @param {bool}  	bValueClear 선택,EtcData에 값이 undefined로 나오는 경우 html필드의 값을 clear할지 여부, default=false
     * @return int, Match된 필드의 개수
     * @see #ComEtcDataToForm
     */
    function ComEtcDataToForm2(form,sheetObj,sPrefix,bValueClear){
    	var iMatchCnt=0;
    	
        try {
            if (typeof(form) != "object" || form.tagName != "FORM") {
            	alert("It is not a FORM of [ComEtcDataToFomrm].");
                return "";
            }

            //sheetObjInfo.js의 IBS_EtcData2Form에서 이 부분을 주석으로 막았음
            //form을 리셋한다.
            //form.reset();
            
            if (sPrefix==undefined || sPrefix==null) sPrefix="";
            if (bValueClear==undefined || bValueClear==null) bValueClear=false;

            var elems   = form.elements;
            
            //사용가능한 HTML컨트롤을 배열로 생성한다.
            for (var i = 0; i < elems.length; i++) {
                var xvalue, sName;
                if(elems[i].classid == undefined){
                	sName = elems[i].name; 	//Html오브젝트인경우
                }else{
                	sName = elems[i].id;	//IBMultiCombo인경우
                }
                
                if (sName == "") continue;

                //Form 안의 컨트롤Name 앞에 붙은 prefix 문자열을 제거하기
            	if (sPrefix.length > sName.length) continue;
            	if (sName.substr(0,sPrefix.length) != sPrefix) continue;
            	sName = sName.substr(sPrefix.length);
                
				//name 중간에 "_"를 제거하고, "_" 뒤의 첫글자를 대문자로 변경한다.
				//예) name="vvs_cd" 결과 "vvsCd"를 만든다.
                var arrName = sName.split("_");
                for (var idx=1; idx<arrName.length; idx++){
                	arrName[idx] = arrName[idx].charAt(0).toUpperCase() + arrName[idx].substr(1);
                }
                //ComDebug(sName + "->" + arrName.join(""));
                sName = arrName.join("");
                
                xvalue = sheetObj.EtcData(sName);
                
                //radio인 경우 같은이름으로 여러개 있는 경우
                if (elems[i].type =="radio") {
                    var eRadio = document.all[elems[i].name];
                    //첫번째 radio만 체크하고 나머지 건너뛰기
                    if(eRadio.length>1) i += (eRadio.length-1);

                    if (xvalue != undefined) {
                    	ComSetObjValue(eRadio, xvalue);
                    	iMatchCnt++;
                    } else if (bValueClear) {
                    	ComClearObject(eRadio);
                    }
                    continue;
                }
                
                //해당이름의 EtcData가 없는 경우 다음 항목 찾기
                if ( xvalue == undefined)  {
                	if (bValueClear) ComClearObject(elems[i]);
                	continue;
                }
                
                //radio인 경우를 제외하고 모두 여기서 값이 설정된다.
                ComSetObjValue(elems[i], xvalue);
                
                iMatchCnt++;
             }//for
        } catch(err) { ComFuncErrMsg(err.message); }
        
        return iMatchCnt;
    }



    /**
     * 2개 Sheet에서 데이터 이동하며 체크된 데이터만 이동한다. <br>
     * fromSheet의 체크된 행만 toSheet로 이동하며, 이동된 행은 fromSheet에서 삭제되고, toSheet에는 마지막에 새로운 행이 추가된다. <br>
     * 주의할 점은 toSheet의 컬럼개수는 fromSheet의 컬럼개수와 많거나 같아야 하고, 컬럼의 위치가 같아야 한다. 두 Sheet의 해더행의 개수도 같아야 한다. <br>
     * chkCol인자는 체크박스가 있는 컬럼의 Index 또는 SaveName이여도 된다. <br>
     * 이 함수는 IBSheetInfo.js 파일의 IBS_Sheet2SheetCheck함수를 옮겨온것이며, 경고메시지처리와 해더행이 1개 이상인경우의 처리가 원본함수와 다르다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComSheet2SheetCheck(mySheet1, mySheet2, 0);  //mySheet1의 0컬럼이 체크된행을 mySheet2로 이동한다.
     * </pre>
     * @param {ibsheet}      fromSheet  필수,이동 원본 Sheet의 Object id, 보내는Sheet
     * @param {ibsheet}      toSheet    필수,이동 대상 Sheet의 Object id, 받는 Sheet
     * @param {int,string}   chkCol     필수,체크박스 컬럼의 인덱스 또는 SaveName
     * @return : 없음
     */
    function ComSheet2SheetCheck(fromSheet, toSheet, chkCol)  {
        try {
            //함수 인자 유효성 확인
            if ((typeof(fromSheet) != "object" || fromSheet.tagName != "OBJECT") ||
                (typeof(toSheet)   != "object" || toSheet.tagName   != "OBJECT") ||
                (chkCol < 0 || chkCol > fromSheet.LastCol)) {
                ComShowCodeMessage('COM12111');
                return false;
            }

            //체크된 행번호만 "|"로 연결한 문자열로 받는다.
            var sCheckRows = fromSheet.FindCheckedRow(chkCol);
            if (sCheckRows == "") return;

            if (!ComIsNumber(chkCol)) chkCol=fromSheet.SaveNameCol(chkCol);

            //이동하는동안 그림 그리지 않기
            fromSheet.Redraw    = false;
            fromSheet.RedrawSum = false;
            toSheet.Redraw      = false;
            toSheet.RedrawSum   = false;

            sCheckRows = ComTrim(sCheckRows, "|");
            var arrRows = sCheckRows.split("|");
            var toRow = toSheet.RowCount;

            //원본에서 역순으로 Check 된 데이터를 확인하여 이동
            for (var idx = arrRows.length-1 ; idx>=0 ; idx--) {
                var ir = arrRows[idx];

                //데이터 행 추가
                var row = toSheet.DataInsert(toRow);

                //데이터 옮기기
                for (ic = 0; ic<=fromSheet.LastCol; ic++) {
                    if (ic == chkCol) continue; //체크 컬럼은 빼고 옮김
                    toSheet.CellValue(row, ic) = fromSheet.CellValue(ir, ic);
                }
                //원본에서 지움
                fromSheet.RowDelete(ir, false);
            }

            //이동완료 후 그림 그리기
            toSheet.RedrawSum   = true;
            toSheet.Redraw      = true;
            fromSheet.RedrawSum = true;
            fromSheet.Redraw    = true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * sheet의 height를 계산하기 위해 ViewRows(화면에 보일 행의 개수)를 계산하여 리턴한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (bZoomIn) {
     *         iRows = ComGetSheetViewRows(sheetObject1,"MAX",1);
     *         sheetObject1.style.height = sheetObject1.GetSheetHeight(iRows);
     *         zoomFlag = "open";
     *     } else {
     *         iRows = ComGetSheetViewRows(sheetObject1,"MIN",0);
     *         sheetObject1.style.height = sheetObject1.GetSheetHeight(iRows);
     *         zoomFlag = "close";
     *     }
     * </pre>
     * @param {ibsheet} sheet_obj 필수,IBSheet Object ID
     * @param {string}  retType   필수,추출방법 ("MAX":최대값,"MIN":최소값)
     * @param {int}     scrollCnt 필수,스크롤 여부 (0:없음, 1:있음). 단, MAX만 적용
     * @return ViewRows(화면에 보일 행의 개수)
     */
    function ComGetSheetViewRows(sheetObj, retType, scrollCnt) {
        try {
            var basCnt = 20;  //기본 height
            var maxCnt = 100; //허용가능한 최대 height

            var heightCnt = 0;

            switch(retType.toUpperCase()){
                case "MAX":
                    heightCnt = maxCnt;
                    if (sheetObj.RowCount > 0) {
                        heightCnt = sheetObj.HeaderRows + sheetObj.LastRow + scrollCnt + 1; //예비 +1
                    } else { //조회된 데이터가 없으면
                        heightCnt = basCnt;
                    }
                    break;
                case "MIN":
                    heightCnt = basCnt;
                    break;
            }

            if (heightCnt > maxCnt)     heightCnt = maxCnt;
            if (heightCnt < basCnt)     heightCnt = basCnt;

            return heightCnt;
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * IBSheet의 GetSearchXml 함수 또는 GetSaveXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 ETC-DATA로 넣은 KEY의 값을 리턴한다.
     * <br><b>Example :</b>
     * <pre>
     *     xmlStr = mySheet.GetSearchXml("list.jsp");
     *     sValue = ComGetEtcData(xmlStr, "UserId");
     *     예를 들어 xmlStr의 내용이 아래와 같다면 sValue의 값은 "ibs006"이 된다.
     *     xmlStr ======================================================
     *       &lt;?xml version='1.0' ?&gt;
     *       &lt;SHEET&gt;
     *         &lt;ETC-DATA&gt;
     *              &lt;ETC KEY="UserId"&gt;ibs006&lt;/ETC&gt;
     *              &lt;ETC KEY="UserName"&gt;khlee&lt;/ETC&gt;
     *         &lt;/ETC-DATA&gt;
     *       &lt;/SHEET&gt;
     *     xmlStr ======================================================
     * </pre>
     * @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
     * @param   {string} etcName    필수,xml 문자열에서 추출하고자하는 ETC Key이름
     * @return  string, ETC-DATA로 넣은 KEY의 값
     * @version 3.4.0.50
     */
    function ComGetEtcData(xmlStr,etcName){
        if(xmlStr == null  || xmlStr == "" || etcName == null || etcName == "") return;

        try {
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
            xmlDoc.loadXML(xmlStr);

            var xmlRoot = xmlDoc.documentElement;
            if(xmlRoot == null) return;

            var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
            if(etcDataNode == null) return;

            var etcNodes = etcDataNode.childNodes;
            if(etcDataNode == null) return;

            for(var i=0;i<etcNodes.length;i++){
              if(etcNodes[i].nodeType!=1 || etcNodes[i].attributes.length == 0) continue;

              if(etcNodes[i].attributes(0).text==etcName) {
                if (etcNodes[i].firstChild==null) {
                  return "";
                } else {
                  return etcNodes[i].firstChild.nodeValue;
                }
              }
            }

        } catch(err) { ComFuncErrMsg(err.message); }
    }

     /**
      * IBSheet의 GetSearchXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 TOTAL 값을 리턴한다.
      * <br><b>Example :</b>
      * <pre>
      *     xmlStr = mySheet.GetSearchXml("list.jsp");
      *     sTotal = ComGetTotalRows(xmlStr);
      * </pre>
      * @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
      * @return  string, 결과 xml의 조회 건수 리턴
      * @version 3.4.0.50
      */
    function ComGetTotalRows(xmlStr){
         if(xmlStr == null  || xmlStr == "") return;

         try {
             var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
             xmlDoc.loadXML(xmlStr);

             var xmlRoot = xmlDoc.documentElement;
             if(xmlRoot == null) return;

             var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
             if(dataNode == null) 
            	 return;
             else 
            	 return dataNode.getAttribute("TOTAL");

         } catch(err) { ComFuncErrMsg(err.message); }
     }
    /**
     * IBSheet에 특정 컬럼이 체크된 데이터행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
     * 부모창에서 팝업으로 창을 열때 체크된 데이터 또는 모든 데이터행을 팝업창의 IBSheet로 넘기기위해 사용한다. <br>
     * 또는 왼쪽IBSheet에서 오른쪽IBSheet로 데이터를 이동할때도 사용할 수 있다. <br>
     * bRowDel인자를 true로 설정하면 XML생성에 대상이된 행을 삭제처리까지 할수 있다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sXml = ComMakeSearchXml(sheetObj, false, "chkBox","trd_cd|rlane_cd|dir_cd");
     * </pre>
     * @param {ibsheet} 	sheet_obj   필수,IBSheet Object ID
     * @param {bool}    	allSave     필수,sheet 전체를 xml string으로 만들지 여부[true/false]
     * @param {int,string}	col     	필수,대상이 되는 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
     * @param {string}  	saveColName 필수,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
     * @param {bool}    	bRowDel     선택,대상행삭제여부, default=false
     * @return string,Sheet의 데이터를 조회XML로 구성한 문자열
     */
     function ComMakeSearchXml(sheet_obj, allSave, col, saveColName, bRowDel)  {
         try {
             //함수 인자 유효성 확인
             if (typeof sheet_obj != "object" || sheet_obj.tagName != "OBJECT") {
                 ComShowMessage("ComMakeSearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
                 return "";
             }

             var allXml = "";
             var sColSep = "^|^";
             var sColOrder = "";
             if (saveColName!=undefined && saveColName != null && saveColName!="") {
                 sColOrder = " COLORDER='" + saveColName + "' ";
             }

             allXml = "<?xml version='1.0'  ?>\n"
                    + "<SHEET>\n"
             if(allSave){
                 allXml += "  <DATA TOTAL='"+ sheet_obj.TotalRows + "' " + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";

                 var aryTR  = new Array(sheet_obj.LastRow - sheet_obj.HeaderRows);
                 var aryTD = new Array(sheet_obj.LastCol);

                 for (ir = sheet_obj.HeaderRows; ir <= sheet_obj.LastRow; ir++) {
                     for (ic = 0; ic<= sheet_obj.LastCol; ic++) {
                         //TD-셀의 값을 변수에 저장한다.
                         aryTD[ic] = String(sheet_obj.CellValue(ir,ic));
                     }
                     aryTR[ir-sheet_obj.HeaderRows] = "    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
                 }
                 if (bRowDel) sheet_obj.RemoveAll();

                 allXml += aryTR.join("\n");
             }else{
                 allXml += "  <DATA" + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
                 if(col != ""){
                     var findRows = sheet_obj.FindCheckedRow(col);
                     if(findRows != ""){
                         findRows = findRows.substring(0, findRows.length-1); //맨끝의 "|"제거
                         var arrRow = findRows.split("|");
                         var arrCol = saveColName.split("|");

                         var aryTR  = new Array(arrRow.length);
                         var aryTD = new Array(arrCol.length);
                         for(var ir = 0; ir<arrRow.length; ir++){
                             for(var ic = 0; ic<arrCol.length; ic++){
                                 //TD-셀의 값을 변수에 저장한다.
                                 aryTD[ic] = String(sheet_obj.CellValue(arrRow[ir], arrCol[ic]));
                             }
                             aryTR[ir] = "    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
                         }
                         if (bRowDel) {
                         	sheet_obj.Redraw = false;
                         	sheet_obj.RedrawSum = false;
                             for(var ir = arrRow.length-1; ir>=0; ir--){
                                 sheet_obj.RowDelete(arrRow[ir],false);
                             }
                         	sheet_obj.RedrawSum = true;
                         	sheet_obj.Redraw = true;
                         }
                         allXml += aryTR.join("\n");
                     }
                 }
             }
             allXml += "  </DATA>\n"
                    +  "</SHEET>";

             return allXml;
         } catch(err) { ComFuncErrMsg(err.message); }
     }

     /**
     * 인자로 받은 IBSheet 배열에서 트랜잭션이 발생한 IBSheet가 하나라도 있는지 여부를 리턴한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     if(ComIsModifiedSheets(sheetObjects)) alert("수정되었습니다.");
     * </pre>
     * @param {ibsheet,array} sheetObjs    필수,IBSheet Object 또는 IBSheet Object배열
     * @returns bool <br>
     *          true  : 트랜잭션이 발생한 IBSheet가 하나라도 있는 경우<br>
     *          false : 트랜잭션이 발생한 IBSheet가 없는 경우
     */
    function ComIsModifiedSheets(sheetObjs){
        try{
            var modified = false;
            if(sheetObjs.constructor == Array){
               for(var i = 0 ; i < sheetObjs.length ; i++){
                    if (sheetObjs[i].IsDataModified) return true;
               }
            } else{
                modified = sheetObjs.IsDataModified;
            }
            return modified;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    
	/**
	 * sheetObj에 숨겨진 컬럼(ColHidden=true)의 index를 |로 구분한 문자열로 구성하여 반환한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ret = ComGetHiddenCols(sheetObjects[0]);	//결과 : "0|7|8"형태
     * </pre>
     * @param {object} sheetObj    필수,IBSheet Object
     * @returns string <br>
	 */
	function ComGetHiddenCols(sheetObj){
        try{
			var colText = new Array();
			var idx = 0;
			for(var col=0; col<=sheetObj.LastCol; col++){
				if( sheetObj.ColHidden(col)) colText[idx++] = col;
			}    
			return colText.join("|");
        } catch(err) { ComFuncErrMsg(err.message); }
	}    


	/**
	 * IBSheet의 각 컬럼의 Alias인 SaveName을 구분자("|")으로 조합한 문자열을 다음과 같이 QueryString으로 조합하여 리턴한다. <br>
	 * "<font color="red">COLORDER0</font>=ibflag<b>|</b>bkg_no<b>|</b>bl_no"<br>
	 * IBSheet가 여러개인 경우 다음과 같이 QueryString을 조합하여 리턴한다. <br>
	 * "<font color="red">COLORDER0</font>=ibflag|bkg_no|bl_no&<font color="red">COLORDER1</font>=ibflag1|ener_date|chk_yn&<font color="red">COLORDER2</font>=ibflag2|err_no|desc|name"<br>
	 * 이 함수는 DoSearch4Fx 함수를 사용하여 서버에 조회할때 사용한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ret = ComGetSaveNameParam(sheetObj);	//결과 : 하나만 조합한 결과 "<font color="red">COLORDER0</font>=ibflag<b>|</b>bkg_no<b>|</b>bl_no"
     *     sheetObj.DoSearch4Fx("xxxxx.do", FormQueryString(formObj) + "&" + ret);
     *
     *     ret = ComGetSaveNameParam(sheetObjects);	//결과 : 여러개 조합한 결과 "<font color="red">COLORDER0</font>=ibflag|bkg_no|bl_no&<font color="red">COLORDER1</font>=ibflag1|ener_date|chk_yn&<font color="red">COLORDER2</font>=ibflag2|err_no|desc|name"
     *     sheetObjects[0].DoSearch4Fx("xxxxx.do", FormQueryString(formObj) + "&" + ret);
     * </pre>
     * @param {ibsheet,array} sheetObjs    필수,IBSheet Object 하나 또는 IBSheet Object 배열
     * @returns 문자열<br>
	 */
	function ComGetSaveNameParam(sheetObjs){
        try{
        	var result = new Array();
        	var sSaveName = "";
            if(sheetObjs.constructor == Array){
            	for(var i = 0 ; i < sheetObjs.length ; i++){
               		result[i] = "COLORDER" + i + "=" + IBS_ConcatSaveName(sheetObjs[i], "|");
               	}
               	return result.join("&");
            } else{
           		return "COLORDER0=" + IBS_ConcatSaveName(sheetObjs, "|");
            }
        } catch(err) { ComFuncErrMsg(err.message); }
	}    

	/**
	 * IBSheet의 각 컬럼의 Alias인 SaveName을 앞에 Prefix 문자열이 있는 경우 Prefix문자열을 다음과 같이 QueryString으로 조합하여 리턴한다. <br>
	 * "IBPREFIX=hir_"<br>
	 * IBSheet가 여러개인 경우 다음과 같이 QueryString을 조합하여 리턴한다. <br>
	 * "IBPREFIX=hir_&IBPREFIX=pay_&IBPREFIX=otr_"<br>
     * <br><b>Example :</b>
     * <pre>
     *     ret = ComGetPrefixParam("hir_");	//결과 : 하나만 조합한 결과 "<font color="red">IBPREFIX</font>=hir_"
     *
     *     var aryPrefix = new Array("hir_", "pay_", "otr_");	//prefix 문자열 배열	
     *     ret = ComGetPrefixParam(aryPrefix);	//결과 : 여러개 조합한 결과 "<font color="red">IBPREFIX</font>=hir_&<font color="red">IBPREFIX</font>=pay_&<font color="red">IBPREFIX</font>=otr_"
     * </pre>
     * @param {string,array} aryPrefix    필수,Prefix 문자열 하나 또는 Prefix 문자열 배열
     * @returns QueryString문자열<br>
	 */
	function ComGetPrefixParam(aryPrefix){
        try{
        	var result = new Array();
        	var sSaveName = "";
            if(aryPrefix.constructor == Array){
            	for(var i = 0 ; i < aryPrefix.length ; i++){
               		result[i] = "IBPREFIX=" + aryPrefix[i];
               	}
               	return result.join("&");
            } else{
           		return "IBPREFIX=" + aryPrefix;
            }
        } catch(err) { ComFuncErrMsg(err.message); }
	} 
	
	/**
	 * IBSheet의 GetSaveString함수를 이용하여 저장할 데이터를 QueryString으로 가져와서 리턴한다. <br>
	 * 만약 필수입력 등 Validation에 걸린 경우 ""을 리턴하고, TAB으로 구성되어 숨겨진 Sheet로 포커스 이동 처리한다. <br>
	 * 이 함수는 여러개 IBSheet를 한꺼번에 서버에 저장할 때 사용한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ret = ComGetSaveString(sheetObjects[0]);			//결과 : 하나의 IBSheet의 저장할 QueryString 가져오기
     *     ret = ComGetSaveString(sheetObjects);			//결과 : 여러개 IBSheet의 저장할 QueryString을 조합한 결과 
     *     if(ComGetSaveString(sheetObjects)=="") return;	//결과 : 결과가 ""인 경우 필수입력 등 validation에 걸렸기 때문임
     * </pre>
     * @param {ibsheet,array} 	sheetObjs    필수,IBSheet Object 하나 또는 IBSheet Object 배열
     * @param {string} 			bUrlEncode   선택,QueryString 인코딩여부, default=true
     * @param {bool}    		allSave      선택,sheet 전체를 xml string으로 만들지 여부, default=false
     * @param {int,string}  	col          선택,대상이 되는 기준 컬럼의 인덱스 또는 SaveName, default=-1
     * @returns string<br>
     *          QueryString문자열 : 저장할 수 있는 경우<br>
     *          "" : 필수 입력 등 validation에 걸린 경우
	 */
	function ComGetSaveString(sheetObjs, bUrlEncode, allSave, col){
        try{
        	var result = new Array();
        	var cnt = 0;
        	
            if (bUrlEncode == undefined || bUrlEncode == null) bUrlEncode = true;
            if (allSave    == undefined || allSave    == null) allSave = false;
            if (col        == undefined || col        == null) col = -1;

            if(sheetObjs.constructor != Array) sheetObjs = new Array(sheetObjs);

        	for(var i=0; i < sheetObjs.length ; i++){
        		var sheetObj = sheetObjs[i];
        		if (col==-1) {
           			var sParam = sheetObj.GetSaveString(allSave, bUrlEncode);
           		} else {
           			var sParam = sheetObj.GetSaveString(allSave, bUrlEncode, col);
           		}
           		
           		//ComDebug("[ComGetSaveString] sheetObjs[" + i + "]=" +  sParam);
           		
				//필수 입력과 같은 확인이 이루어짐-다음조건이 만족하면 필수입력에 오류발생한 경우임
				if (sheetObj.IsDataModified && sParam == "") {
					
					//해당 Sheet가 특정 탭에 있고, Tab에 의해 숨겨져 있는 경우
					try{						
					    // 필수입력 팝업이 활성된 탭으로 이동 ( 주의 탭안에 탭있는 경우 코딩 수정)
					    tabObjects[0].SelectedIndex = (sheetObj.id).substring(1,sheetObj.id.indexOf("sheet")) - 1;
					    
					    // 핍수 입력 팝업을 활성한 그리드에 포커스 이동
					    sheetObj.focus();

					    // 해당 컬럼에 편집 가능 모드로 수정
					    var row = sheetObj.SelectRow;
					    var col = sheetObj.SelectCol;
					    sheetObj.SelectCell(row, col);

					} catch(er) {;}

				    return "";
				}
				
				if (sParam != "") result[cnt++] = sParam;
           	}
            
           	return result.join("&");

        } catch(err) { ComFuncErrMsg(err.message); }
	} 
	
	//MemoPad를 위한 전역 변수
	var MEMO_FRAME_NAME = "_iFrameMemo_";
	var MEMO_DIV_NAME = "_DivMemo_";
	var MEMO_TEXT_NAME = "_MemoText_";
	var memoSheet=null, memoRow, memoCol;
	
	/**
	 * IBSheet의 특정셀의 글자가 줄바꿈되어 한눈에 볼수 없을때 MemoPad를 이용하여 확인하거나 값을 변경할 때 사용한다. <br>
	 * MemoPad는 TextArea와 버튼으로 구성되며, 값을 확인하고 MemoPad를 닫을때는 ESC키를 누르거나 Close 버튼을 누르거나 HTML 영역을 클릭한다. <br>
	 * MemoPad가 표시될 위치의 셀은 반드시 편집불가능이어야 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    function sheet1_OnClick(sheetObj, Row, Col, Value) {
     *        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
     *        if (sheetObj.ColSaveName(Col) == "desc") ComShowMemoPad(sheetObj);
     *    }
     *    function sheet2_OnClick(sheetObj, Row, Col, Value) {
     *        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집불가능)
     *        if (sheetObj.ColSaveName(Col) == "desc") ComShowMemoPad(sheetObj, Row, Col, true);
     *    }
     * </pre>
     * @param {ibsheet} 	sheetObj    필수,IBSheet Object
     * @param {int} 		row    		선택,MemoPad를 표시할 셀의 행 Index, default=sheetObj.SelectRow
     * @param {int} 		col    		선택,MemoPad를 표시할 셀의 컬럼 Index, default=sheetObj.SelectCol
     * @param {bool} 		bReadOnly	선택,MemoPad에 표시된 값의 편집가능 여부, default=true
     * @param {int}    		iWidth		선택,MemoPad의 넓이, default=200
     * @param {int}    		iHeight		선택,MemoPad의 높이, default=200
     * @param {boolean}		bEventRaise	선택,MomoPad 입력 후 적용 시, Sheet 의 OnChange Event 발생 여부
     * @see #ComHideMemoPad
     * @return 없음<br>
	 */
	function ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax, bEventRaise) {
		try{
			//함수의 인자 default 값 설정하기			
			if (row == undefined 		|| row == null) 		row=sheetObj.SelectRow;
			if (col == undefined 		|| col == null) 		col=sheetObj.SelectCol;
			if (bReadOnly == undefined  || bReadOnly == null) 	bReadOnly=false;
			if (iWidth == undefined 	|| iWidth == null) 		iWidth = 200; 
			if (iHeight == undefined 	|| iHeight == null) 	iHeight = 200; 
			if (iMax == undefined 	    || iMax == null) 	    iMax = 4000; 

			//메모를 위한 IBSheet 정보의 Validation 확인하기
			if (sheetObj.CellEditable(row,col)) {
				return ComShowMessage("[ComShowMemoPad] "+ sheetObj.id + "(" + row + "," + col + ") 셀은 편집불가능이어야 합니다.");
			}
			//메모를 위한 IBSheet 정보 받기
			if (!ComIsNumber(col)) col = sheetObj.SaveNameCol(col);
	        memoSheet=sheetObj;
	        memoRow=row;
	        memoCol=col;

			//메모메드 만들기
			if (!initMemoPad(iMax, bEventRaise)) return;
			
	        //메모 DIV 표시할 위치 계산하기 (AnchorPosition_getPageOffsetLeft, AnchorPosition_getPageOffsetTop 함수는 ComCalendar.js 있는것을 사용함)
	        var iLeft = AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col) + 2;
	        var iTop  = AnchorPosition_getPageOffsetTop(sheetObj)  + sheetObj.RowTop(row)  + 2;
	        if (sheetObj.CountPosition!= 0)  iTop += 16; //건수정보가 표시될 때 표시위치를 조금 내린다.
	
            //현재페이지가 iframe이나 frame 안에 있고, 그것의 scrolling이 불가능한 경우 표시 위치를 변경함
            if (top.document != document && window.frameElement.scrolling=="no") {
            	//높이초과
            	if (iTop + iHeight  > document.body.clientHeight) {
            		iBottom = iTop + sheetObj.RowHeight(row);
            		if (iBottom > document.body.clientHeight) iBottom = document.body.clientHeight;  
            		iTop = iBottom-iHeight;
            		if (iTop <0) iTop = 0
            	}
            	
            	//넓이초과
                if (iLeft + iWidth  > document.body.clientWidth)   {
                	iLeft = document.body.clientWidth - iWidth;    
                	if (iLeft<0) iLeft = 0;
                }
            }

	        var _divMemo = document.getElementById(MEMO_DIV_NAME);
	        var _frameDoc  = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
	
			_frameDoc.getElementById("btn_apply").style.display = (bReadOnly)?"none":"inline";
	        _frameDoc.getElementById(MEMO_TEXT_NAME).style.backgroundColor = bReadOnly?"#E8E7EC":"";
	        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontFamily  = sheetObj.SheetFontName;
	        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontSize  = 11;
			_frameDoc.getElementById(MEMO_TEXT_NAME).style.height = iHeight-25;
	        _frameDoc.getElementById(MEMO_TEXT_NAME).value = sheetObj.CellText(row,col);
	        _frameDoc.getElementById(MEMO_TEXT_NAME).readOnly = bReadOnly;

			_divMemo.style.width = iWidth;
			_divMemo.style.height = iHeight;
	        _divMemo.style.top = iTop;
	        _divMemo.style.left = iLeft;
	        _divMemo.style.visibility = "visible";
	        _divMemo.focus();	
	        
	        ComSetFocus(_frameDoc.getElementById(MEMO_TEXT_NAME));
        } catch(err) { ComFuncErrMsg(err.message); }
	}

	/**
	 * 표시된 MemoPad를 강제로 닫을때 이 함수를 사용한다. <br>
     * @param {bool} 	bFocus	선택,닫은 후 처음열었던 IBSheet로 포커스를 설정할지 여부, default=false
     * @see #ComShowMemoPad
     * @return 없음<br>
	 */
	function ComHideMemoPad(bFocus) {
		try {
	        if (document.getElementById(MEMO_DIV_NAME) == null || memoSheet == null)  return;
	        document.getElementById(MEMO_DIV_NAME).style.visibility = "hidden";

			var sheetObj = memoSheet;
			memoSheet = null;
			
	        if (bFocus) {
		        sheetObj.focus();	//포커스 하는 순간 이 함수가 또 호출되므로 sheetObj 변수로 다시 받았음
				sheetObj.SelectCell(memoRow, memoCol, false);
	        }
        } catch(err) { ; }
	}

    /**
     * MemoPad에서 Apply 버튼을 눌렀을때 이 함수를 호출하며, MemoPad의 값을 IBSheet의 특정셀로 설정한다. <br>
     * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
     */
	function setMemoValue(sValue,iMax, bEventRaise) {
		try {
			if(sValue.length > iMax){
				ComShowMessage("characters long");
//				document.getElementById(MEMO_FRAME_NAME).focus();
				return;
			}else{
				if (memoSheet == null) return;
				
				if(bEventRaise) {
					memoSheet.CellValue(memoRow, memoCol) = sValue;
				} else {
					memoSheet.CellValue2(memoRow, memoCol) = sValue;
				}
				ComHideMemoPad(true);
			}
        } catch(err) { ComFuncErrMsg(err.message); }
	}
	
    /**
     * MemoPad를 위한 DIV안에 iFrame을 만들고, iFrame안에 Textarea와 버튼을 생성한다. <br>
     * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
     */
	function initMemoPad(iMax, bEventRaise) {
		try {
	        //메모용 Div가 없으면 생성한다.
	        if (document.getElementById(MEMO_DIV_NAME) != null) return true;
			
			//메모용 Div 만들기	        
	        var _divMemo=document.createElement("<div id='"+  MEMO_DIV_NAME +"' style='position:absolute; overflow:hidden; width:200px; height:200px; visibility:hidden'/>");
	        document.body.insertBefore(_divMemo);

	        //메모용 Div 안에 iFrame 만들기(Select태그나 Object태그 위쪽으로 나타나게 하기 위함)
	        var _frameMemo = document.createElement("<IFRAME id='"+MEMO_FRAME_NAME+"' src='' frameborder=0 marginHeight=0 marginWidth=0 width=100% height=100% />");
	        _divMemo.appendChild(_frameMemo);	        
	
	        var _FrameDoc = _frameMemo.contentWindow.document;

			//iFrame안에 Div 태그 만들기(테두리 만들기,ESC키시 닫기처리 위함)
	        var _FrameDiv=_FrameDoc.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);' style='border:1.2px solid #aaa; padding:1px; overflow:hidden; background-color:#E6EFF6; width:100%; height:100%;'/>");
	        _FrameDoc.appendChild(_FrameDiv);
	        
			//Div안에 Textarea 만들기
	        var _area = _FrameDoc.createElement("<textarea id='" + MEMO_TEXT_NAME +"' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; color:#4f4f4f; height:175px; width:100%'/>");
	        _FrameDiv.appendChild(_area);
	        
	        //Div 안에 center 태그 만들기(버튼을 가운데 놓기 위함)
	        var _centerTag = _FrameDoc.createElement("<center>");
	        _FrameDiv.appendChild(_centerTag);
			
			//Apply 버튼 만들기
	        var _button1;
	        if(bEventRaise) {
	        	_button1 = _FrameDoc.createElement("<span id='btn_apply' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.setMemoValue(document.getElementById(\""+MEMO_TEXT_NAME+"\").value,"+iMax+", true);'/>");
	        } else {
	        	_button1 = _FrameDoc.createElement("<span id='btn_apply' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.setMemoValue(document.getElementById(\""+MEMO_TEXT_NAME+"\").value,"+iMax+", false);'/>");
	        }
	        _button1.innerHTML = "Apply";
	        _centerTag.appendChild(_button1);
	        
			//Close 버튼 만들기
	        var _button2 = _FrameDoc.createElement("<span id='btn_close' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.ComHideMemoPad(true)'/>");
	        _button2.innerHTML = "Close";
	        _centerTag.appendChild(_button2);
	        
	        //메모용 iFrame 자동 닫기 처리
	        if (document.onmouseup==null || document.onmouseup.toString().indexOf("ComHideMemoPad") < 0) {
		        //Axon에서 onmouseup을 쓰고 있으므로, 아래와 같은 방법으로 MemoPad 닫기 처리
		        window.popupMemoOldEventListener = document.onmouseup;
		        if (window.popupMemoOldEventListener != null) {
		        	//alert("CoObject \n" + window.popupMemoOldEventListener.toString());
		            //기존에 document.onmouseup에  정의된 함수가 있는 경우
		            document.onmouseup = new Function("window.popupMemoOldEventListener(); ComHideMemoPad();");
		        } else {
		            //기존에 document.onmouseup에  정의된 함수가 없는 경우
		            document.onmouseup = ComHideMemoPad;
		        }
		        
		        //ActiveX에 포커스가 갔을때 메모DiV 닫기
		        var objs = document.getElementsByTagName("OBJECT")
				window.popupMemoOldObjEventListener = new Array(objs.length);
		        for(var i = 0 ; i < objs.length ; i++){
			        window.popupMemoOldObjEventListener[i] = objs[i].onfocus;
			        if (window.popupMemoOldObjEventListener[i] != null) {
			            //기존에 document.onmouseup에  정의된 함수가 있는 경우
			            objs[i].onfocus = new Function("window.popupMemoOldObjEventListener["+i+"](); ComHideMemoPad();");
			        } else {
			            //기존에 document.onmouseup에  정의된 함수가 없는 경우
			            objs[i].onfocus = ComHideMemoPad;
			        }
		        }
	        }
        } catch(err) { ComFuncErrMsg(err.message); return false;}
        return true;
	}
	
	/**
	 * IBSheet의 특정 컬럼을 기준으로 체크된 행을 모두 숨기면서 트랜잭션 상태를 삭제 상태("D")로 변경한다. <br>
	 * col인자는 기능을 처리할 기준이 되는 체크컬럼 Index로 반드시 체크박스형태(dtCheckBox, dtDelCheck, dtDummyCheck, dtRadioCheck) 이어야 한다. <br>
	 * 삭제 상태로 숨겨진 행은 실제로 서버에 전달되지 않으므로 나중에 DoSave함수를 이용하여 서버에 전달하도록 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComRowHideDelete(sheetObj, "sel");	//"sel"컬럼이 체크된 행을 숨기고 삭제상태로 만든다.
     * <pre>
     * </pre>
     * @param {ibsheet} 	sheetObj    필수,IBSheet Object
     * @param {int,string} 	col    		필수,삭제처리할 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
     * @param {bool} 	isMsg    		선택,삭제처리할 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
     * @returns int<br>
     *          -1 : 숨기기삭제 실패한 경우<br>
     *          그외  : 숨기기삭제 성공한 경우 처리된 행의 개수로 0개 이상의 값을 리턴한다.<br>
	 */
	function ComRowHideDelete(sheetObj, col, isMsg) {
   	    if (isMsg==undefined || isMsg==null) isMsg = true;
		var org_col = col;
		//컬럼Index가 아닌 경우 SaveName인 경우 -> 컬럼Index를 가져온다.
		col = ComIsNumber(col)?ComParseInt(col):sheetObj.SaveNameCol(col);
		
		//컬럼 인자의 유효성 확인하기
		if (col< 0 || col > sheetObj.LastCol) {
			ComShowMessage("[ComRowHideDelete] '" + sheetObj.id + "'의 '" + org_col + "' 컬럼은 존재하지 않습니다.");
			return -1;
		}
		
		//체크박스에 체크된 행 전체를 문자열로 가져온다. 결과 : "1|3|5|"
		var sRow = sheetObj.FindCheckedRow(col);
		if (sRow == "") {
			if(isMsg) ComShowCodeMessage("COM12189");
			return 0;
		}
		
		//가져온 행을 배열로 만들기 
		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
		
		sheetObj.RedrawSum = false;	//합계 계산하지 않기, dtAutoSumEx가 있는 경우를 대비

		//기준컬럼의 DataType이 dtDelCheck이면 그냥 숨기기만하고, dtDelCheck가 아닌 경우만 숨기고, 트랜잭션 바꾼다.
		if (sheetObj.ReadDataProperty(0, col, dpDataType) == dtDelCheck) {
			//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
			for (var idx=arrRow.length-2; idx>=0; idx--){
				var row = arrRow[idx];
				sheetObj.RowHidden(row)= true;		//2.행 숨기기
			}
		} else {
			//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
			for (var idx=arrRow.length-2; idx>=0; idx--){
				var row = arrRow[idx];
				sheetObj.CellValue2(row, col)= 0;	//1.체크박스 없애기 (체크된데이터만 다른 처리 하는 경우도 있으므로)
				sheetObj.RowHidden(row)= true;		//2.행 숨기기
				sheetObj.RowStatus(row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
			}
		}

		sheetObj.RedrawSum = true;	//합계 계산하기
		
		return arrRow.length-1;
	}
		
    //?-이 함수는 oriValues , cols인자를 설정할때의 기능이 이상하다

    /**
     * 엑셀의 필터링 기능과 유사하게 sheet의 데이터행을 필터링 처리한다. <br>
     * oriValues인자와 cols인자가 설정되지 않은 경우는 Sheet의 숨겨진 컬럼중 컬럼의 Alias가 "hiddencheck"인 체크컬럼이 체크된 행을 모두 숨긴다. <br>
     * oriValues인자와 cols인자가 설정된 경우 컬럼의 Alias가 cols인자인 컬럼들의 셀값과  oriValues인자의 값이 일치하는 행의 "hiddencheck"인 체크컬럼을 체크하고, 행을 표시한다. <br>
     * 조건에 맞지 않는 행을 숨기지는 않고 그대로 둔다. <br>
     * 위 두가지 경우 모두 sheetObj에는 "hiddencheck"라는 컬럼과 dtStatus 또는 stHiddenStatus 컬럼이 존재해야만 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComSheetFiltering(sheet1);                           //결과 = "hiddencheck" 컬럼이 체크된 행을 모두 숨긴다.
     *     ComSheetFiltering(mySheet, "종가", "price");         //결과 = "price"컬럼이 "종가"인 행을 표시하고, "hiddencheck" 컬럼이 체크되도록 한다.
     *     cols[0] = "price";
     *     cols[1] = "amt";
     *     orivalues[0] = "종가";
     *     ComSheetFiltering(mySheet, orivalues, cols, true);   //결과 = "price" 또는 "amt"컬럼이 "종가"인 행을 표시하고, "hiddencheck" 컬럼이 체크되도록 한다.
     * </pre>
     * @param {ibsheet} sheetObj     필수,필터링 하고자 하는 IBSheet Object ID
     * @param {array}   oriValues    선택,찾고자 하는 값(Array)
     * @param {array}   cols         선택,sheetObj에서 찾고자 하는 컬럼
     * @param {bool}    isOrder      선택,현재 sheetObj가 cols의 값 순서대로 정렬 되어 있는지 여부( true :정렬되어 있음, false:정렬되어 있지 않음)
     * @param {bool}    isRowSumable 선택,hidden되는 AutoSum 컬럼의 row를  합계에 포함시킬지 여부(default=false)( true :hidden row도 포함시킴, false:hidden row를 포함시키지 않음)
     * @return int,display된 row의 갯수
     * @author 송민석
     */
    function ComSheetFiltering(sheetObj, oriValues , cols, isOrder, isRowSumable ){
        try {
            var filterCnt= 0;
            var preStatus;
            sheetObj.ReDraw=false;
            // clear
            var sRow  = sheetObj.FindCheckedRow("hiddencheck") ;
            var arrRow = sRow.split("|");
            for (var idx=0; idx<arrRow.length-1; idx++){
                row = arrRow[idx];
                sheetObj.RowHidden(row) = true;
                preStatus = sheetObj.RowStatus(row);
                sheetObj.CellValue2(row,"hiddencheck")="0";
                if(isRowSumable != true ) sheetObj.RowSumable(row)=false;
                sheetObj.RowStatus(row) = preStatus;
            }

            if( oriValues == undefined || oriValues.length == 0) {
                sheetObj.ReDraw=true;
                return;
            }

            if( !(oriValues instanceof Array)){
                var arr = Array(1);
                arr[0] = oriValues;
                oriValues = arr;
            }

            if( !(cols instanceof Array)){
                var arr = Array(1);
                arr[0] = cols;
                cols = arr;
            }


            if( !isOrder ){//정렬 안되어 있을때

                for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
                    var flg = false;
                    for(var j = 0 ; j < cols.length ; j++ ){
                        var subValue = sheetObj.CellValue(i,cols[(j)]);
                        if(oriValues[j] != subValue  ){
                            flg = true;
                            break;
                        }
                    }
                    if(flg == false  ){
                         filterCnt++;
                         sheetObj.RowHidden(i) = flg;
                         preStatus = sheetObj.RowStatus(i);
                         sheetObj.CellValue2(i,"hiddencheck")="1";
                         if(isRowSumable != true)  sheetObj.RowSumable(i)=true;
                         sheetObj.RowStatus(i) = preStatus;

                    }


                }
            }else{//데이터가 정렬되어 있을때

                var selRow = 0;
                for(var j = 0 ; j < cols.length ; j++ ){
                    selRow = sheetObj.FindText(cols[j],oriValues[j],selRow);
                    //찾는 값이 없다..
                    if( selRow < 0 ) break;
                }
                if( selRow >= 0 ){

                    for(var i=selRow ; i <= sheetObj.LastRow ; i++){
                        var flg = false;
                        for(var j = 0 ; j < cols.length ; j++ ){
                            var subValue = sheetObj.CellValue(i,cols[(j)]);
                            if(oriValues[j] != subValue  ){
                                flg = true;
                                break;
                            }
                        }

                        //sort되어 있기 때문에 더이상 loop를 돌필요 없다.
                        if(flg) break;

                        filterCnt++;
                        sheetObj.RowHidden(i) = flg;
                        preStatus = sheetObj.RowStatus(i);
                        sheetObj.CellValue2(i,"hiddencheck")="1";
                        if(isRowSumable != true)  sheetObj.RowSumable(i)=true;
                        sheetObj.RowStatus(i) = preStatus;
                    }
                }

           }

           sheetObj.ReDraw=true;
           return filterCnt;
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    // Header 정보 저장/조회 시, 결과 메시지 출력 여부
    var IBS_bMsgOut = true;

    function ComSendIBHeaderRequest(mode, usr_id, scrn_id, sh_id, hdr_desc) {
        try {
            var userIframe = document.all.ibs_udataIframe;
            var userFrm = document.all.ibs_udataFrm;
            var userInputMode = document.all.ibs_udataMode;
            var userInputUsrId = document.all.ibs_udataUsrId;
            var userInputScrnId = document.all.ibs_udataScrnId;
            var userInputShId = document.all.ibs_udataShId;
            var userInputHdrDesc = document.all.ibs_udataHdrDesc;
            var userInputMsgOut = document.all.ibs_udataMsgOut;

            if(!userIframe) {
                userIframe = document.createElement("<iframe name='ibs_udataIframe' id='ibs_udataIframe' style='display:none'></iframe>");
                userFrm = document.createElement("<form name='ibs_udataFrm' method='post'></form>");
                userInputMode = document.createElement("<input type='hidden' name='ibs_udataMode'>");
                userInputUsrId = document.createElement("<input type='hidden' name='ibs_udataUsrId'>");
                userInputScrnId = document.createElement("<input type='hidden' name='ibs_udataScrnId'>");
                userInputShId = document.createElement("<input type='hidden' name='ibs_udataShId'>");
                userInputHdrDesc = document.createElement("<input type='hidden' name='ibs_udataHdrDesc'>");
                userInputMsgOut = document.createElement("<input type='hidden' name='ibs_udataMsgOut'>");

                userFrm.appendChild(userInputMode);
                userFrm.appendChild(userInputUsrId);
                userFrm.appendChild(userInputScrnId);
                userFrm.appendChild(userInputShId);
                userFrm.appendChild(userInputHdrDesc);
                userFrm.appendChild(userInputMsgOut);

                document.body.appendChild(userIframe);
                document.body.appendChild(userFrm);
            }
            userInputMode.value = mode;
            userInputUsrId.value = usr_id;
            userInputScrnId.value = scrn_id;
            userInputShId.value = sh_id;
            userInputHdrDesc.value = hdr_desc;
            userInputMsgOut.value = IBS_bMsgOut;

            userFrm.target = "ibs_udataIframe";
            userFrm.action = "/hanjin/sys/common/ibsheet/IBS_common.jsp";
            userFrm.submit();
        } catch(err) { ComFuncErrMsg(err.message); }
    }


    /**
     *  Sheet 세팅을 Cookie, DB에  저장한다. <br>
     *    : Column 배열순서, Column 정렬 옵션(ASC/DESC), Column Size <br>
     *    : Cookie => UserData => DB 방식으로 변경 <br>
     *    : Hidden IBSheet / IFrame 방식 / Ajax / behavior:url(#default#download) 중 택일 <br>
     *      (표준에 맞는가, 속도는 어떤 방식이 제일 빠른가) => behavior를 이용하는 것이 무난할 것으로 보임 <br>
     *    : Framework을 타게 할 것인가? (.do / .screen) => 속도면에서는 떨어짐 <br>
     */
    function ComSaveGridSetting(usr_id, scrn_id, sheetObj, bMsgOut) {
        try {
            if(bMsgOut != null && !bMsgOut) {
                IBS_bMsgOut = bMsgOut;
            } else {
                IBS_bMsgOut = true;
            }

            var sh_id = sheetObj.id;
            var hdr_desc = "";

            var colSeq = "";
            var colSize = "";


            with(sheetObj) {
                // 1. Column 배열 순서
                for(var i=0; i<=LastCol; i++) {
                    if(i == 0)
                        colSeq += ColSaveName(i);
                    else
                        colSeq += "|" + ColSaveName(i);
                }

                // 2. Column Size
                for(var i=0; i<=LastCol; i++) {
                    if(i == 0)
                        colSize += ColWidth(i);
                    else
                        colSize += "|" + ColWidth(i);
                }
            }

            hdr_desc = colSeq + "||" + colSize

            ComSendIBHeaderRequest("SAVE", usr_id, scrn_id, sh_id, hdr_desc)

        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     *  Cookie/DB에 저장된 IBSheet 세팅 적용한다.  <br>
     *    : Column 배열순서, Column 정렬 옵션(ASC/DESC), Column Size <br>
     *    : Cookie => UserData => DB 방식으로 변경 <br>
     */
    function ComRestoreGridSetting(usr_id, scrn_id, sheetObj, bMsgOut) {
        try {

            // 결과 Message 출력 여부 세팅
            if(bMsgOut != null && !bMsgOut) {
                IBS_bMsgOut = bMsgOut;
            } else {
                IBS_bMsgOut = true;
            }

            var sh_id = sheetObj.id;
            sendIBHeaderRequest("SEARCH", usr_id, scrn_id, sh_id);
        } catch(err) { ComFuncErrMsg(err.message); }
    }


    /**
     *  Cookie/DB에 저장된 IBSheet 세팅 삭제한다.  <br>
     *  Column 배열순서, Column 정렬 옵션(ASC/DESC), Column Size <br>
     */
    function ComDelGridSetting(usr_id, scrn_id, sheetObj, bMsgOut) {
        try {
            // 결과 Message 출력 여부 세팅
            if(bMsgOut != null && !bMsgOut) {
                IBS_bMsgOut = bMsgOut;
            } else {
                IBS_bMsgOut = true;
            }

            var sh_id = sheetObj.id;

            sendIBHeaderRequest("DEL", usr_id, scrn_id, sh_id)
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
	/**
	 * 한 화면에 여러개의 Sheet가 있는 경우, SaveString에 prefix를 붙여준다 <br>
	 * 
	 * @param {string} sStr 필수, QueryString from IBSheet.GetSaveString().
	 * @param {string} sPrefix 필수, Prefix.
	 * @return string 쿼리스트링의 각 name앞에, 주어진 prefix가 붙여진 쿼리스트링.
	 * @author 박성수
	 * @version 2009.04.22
	 */
	function ComSetPrifix(sStr, sPrefix) {
		if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
			return sStr;
		}
		
		var regexp = RegExp(/&/g);
		sStr = sPrefix + sStr.replace(regexp, "&" + sPrefix);
		return sStr;
	}
    	/**
	 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
	 * IBSheet의 Combo에 연결할수 있는 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
	 * Return되는 배열의 0번째는 Code문자열, 1번째는 Text문자열이 담겨있다.
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
	 * var arrData = ComXml2ComboString(xmlStr, &quot;cd&quot;, &quot;nm&quot;);
	 * 
	 * </pre>
	 * 
	 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @param {string} codeCol 필수, Combo의 Code컬럼명.
	 * @param {string} textCol 필수, Combo의 Text컬럼명.
	 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComXml2ComboString(xmlStr, codeCol, textCol) {
		var rtnArr = new Array();
		
		if (xmlStr == null || xmlStr == "") {
			return;
		}
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
			return;
		}
	
		try {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);
	
			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) {
				return;
			}
	
			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return;
			}
	
			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");
	
			var dataChildNodes = dataNode.childNodes;
			if (dataChildNodes == null) {
				return;
			}
			
			var colListIdx = Array();
			for ( var i = 0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0] = i;
				}
				if (colArr[i] == textCol) {
					colListIdx[1] = i;
				}
			}
			
			var sCode = "";
			var sText = "";
			for ( var i = 0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
				
				sCode += arrData[colListIdx[0]];
				sText += arrData[colListIdx[1]];
				
				if (i != dataChildNodes.length - 1) {
					sCode += "|";
					sText += "|";
				}
			}
			rtnArr.push(sCode);
			rtnArr.push(sText);
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
	
		return rtnArr;
	}

	/**
	 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
	 * IBMultiCombo의 item으로 insert 해준다.<br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
	 * var arrData = ComXml2ComboItem(xmlStr, combo1, &quot;cd&quot;, &quot;nm&quot;);
	 * 
	 * </pre>
	 * 
	 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @param {object} cmbObj 필수, insert하고자 하는 IBMultiCombo Object.
	 * @param {string} codeCol 필수, Combo의 Code컬럼명.
	 * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
	 * @return 없음.
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComXml2ComboItem(xmlStr, cmbObj, codeCol, textCol) {
		if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
			return;
		}
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
			return;
		}
	
		try {
			cmbObj.RemoveAll();
			
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);
	
			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) {
				return;
			}
	
			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return;
			}
			
			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");
	
			var dataChildNodes = dataNode.childNodes;
			if (dataChildNodes == null) {
				return;
			}
			
			var colListIdx = Array();
			var arrText = textCol.split("|");
			for (var i = 0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0] = i;
				}
				for (var j = 0; j < arrText.length; j++) {
					if (colArr[i] == arrText[j]) {
						colListIdx[j+1] = i;
					}
				}
			}
			
			for (var i = 0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
				
				var item = "";
				for (var j = 1; j < colListIdx.length; j++) {
					item += arrData[colListIdx[j]];
					if (j < colListIdx.length - 1) {
						item += "|";
					}
				}
				cmbObj.InsertItem(i, item, arrData[colListIdx[0]]);
			}
	
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
	}

	/**
	 * 컬럼의 Edit 가능여부를 설정한다.
	 * 
	 * @param {ibsheet}     sheetObj  필수, IBSheet Object ID
	 * @param {int,string}  col       필수, 대상이 되는 기준 컬럼의 인덱스 또는 SaveName, default=-1
	 * @param {bool}        editMode  필수, 편집 가능/불가능 여부를 true/false로 설정한다.
	 * @param {int}         fromRow   선택, 시작Row. default=컬럼 시작 행
	 * @param {int}         toRow     선택, 마지막Row. default=컬럼 마지막 행
	 * @return 없슴
	 */
    function ComColEditable(sheetObj, col, editMode, fromRow, toRow) {
    	with(sheetObj) {
      	    if (fromRow==undefined || fromRow==null) fromRow = 1;
    	    if (toRow==undefined || toRow==null)     toRow = RowCount;
    	
    	    for (var idx = fromRow; idx <=toRow; idx++) {
		    	CellEditable(idx, col)  = editMode;
		    }
    	}
    }

	/**
	 * 화면에 다수의 시트를 저장시 결과 xml에서 메시지 삭제
	 * 
	 * @param {string}  sxml       필수, 메시지 제거가 필요한 xml String
	 * @return string
	 */
    function ComDeleteMsg(sxml){
    	while (sxml.indexOf('<MESSAGE>') > -1) {
     		var start = sxml.indexOf('<MESSAGE>');
    		var end = sxml.indexOf('</MESSAGE>');
    		sxml = sxml.substring(0,start)+sxml.substring(end+10);
    	}
    	return sxml;
    }

	 
	 
	/**
	 * 헤더에 AllCheck 가 있을경우 데이터 영역의 체크 상태에 따라서 변경처리한다. <br>
	 * 다중 라인레코드의 경우 지원하지 않는다. <br>
	 * 반드시 시트의 OnClick 이벤트에서 사용해야 정상 동작을 한다.
	 *
	 * @param {ibsheet}     sheetObj  필수, IBSheet Object ID
	 * @param {int,string}  Col       필수, 대상이 되는 기준 컬럼의 인덱스 또는 SaveName, default=-1
	 * @param {bool}        Value     필수, OnClick 이벤트 상의 Value 값
	 * @param {int}         DataRow   선택, 헤더가 다중행일때 마지막 헤더에만 채크해야 될 경우
	 * @return 없슴
	 */
	function ComSyncAllCheck(sheetObj, Col, Value, DataRow){
		if (DataRow == undefined || DataRow == null) DataRow=0;
		var checkRows = sheetObj.FindCheckedRow(Col);
		var arrRows = checkRows.split("|");
		var CheckCnt = arrRows.length - 1;
		var chkFlag = null;
		if(CheckCnt >= sheetObj.RowCount){
			chkFlag = false;
		}else if(CheckCnt == sheetObj.RowCount-1){
			if(Value == 0){
				chkFlag = true;
			}else{
				chkFlag = false;
			}
		}else{
			chkFlag = false;
		}
		
		for(var i = DataRow ; i < sheetObj.HeaderRows ; i++)
			sheetObj.HeadCheck(i,Col) = chkFlag;
		
	}
	/**
	 * 시트의 특정 컬럼의 값이 포함된 경우 해당 Row를 찾아준다. 복수의 갯수인 경우 '|'로 연결된다.
     * <br><b>Example :</b>
     * <pre>
     *     ComFindAll(sheetObj, Col, "SEOUL");
     * </pre>
	 * 
	 * @param {ibsheet}     sheetObj  필수, IBSheet Object ID
	 * @param {int}  		Col       필수, 대상 Col index 또는 Savename
	 * @param {String}      SearchText필수, 검색어.
	 * @param {int}         StartRow  선택, . default=HeaderRows
	 * @param {int}         FullMatch 선택, . default=-1
	 * @param {bool}        CaseSensitive 선택, . default=true
	 * @return 검색어가 포함된 Row index, 없을경우 -1
	 */
    function ComFindAll(sheetObj, Col, SearchText, StartRow, FullMatch, CaseSensitive) {

	    if (StartRow==undefined || StartRow==null) StartRow = sheetObj.HeaderRows ;
	    if (FullMatch==undefined || FullMatch==null) FullMatch = -1;
	    if (CaseSensitive==undefined || CaseSensitive==null) CaseSensitive = true;
	
		var sResult = null;
		var iCount = 0;
		while (sheetObj.FindText(Col, SearchText, StartRow, FullMatch, CaseSensitive)!=-1 ) {
		    var iRow = sheetObj.FindText(Col, SearchText, StartRow, FullMatch, CaseSensitive);
		    if(iCount != 0) sResult += "|";
		    sResult += iRow;
		    StartRow = iRow + 1;
		    iCount++;
		}
		if(iCount == 0) sResult = -1;

	    return sResult;
	
    }
    
    /**
     * 
     * @param comboObj
     * @param id
     * @returns
     */
    function ComGetComBoObject(comboObj, id){
    	for (var i = 0; i < comboObj.length; i++) {
			if(comboObj[i].id == id) return comboObj[i]
		}
    	return undefined;
    }
	 
