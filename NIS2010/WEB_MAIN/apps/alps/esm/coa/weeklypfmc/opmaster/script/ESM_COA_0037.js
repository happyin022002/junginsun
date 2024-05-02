/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0037.js
*@FileTitle : 선박 생성/조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각 
*@LastVersion : 1.0
=========================================================
* History
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.03.13 김태윤 N200903110001 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.03.16 김종열 N200903100130 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이행지 FormQueryString =>coaFormQueryString 변경
* 2010.07.08 김기종 AOM Ticket ID - CHM-201004427-01  화면의 CRR Code정보 Read Only변경
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2010.09.29 박은주 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
*                  Sheet의  콤보가 초기에 세팅되지 않음[SearchEnd에서 조회후 세팅하고 있음 불필요한 작업임]
* 2011.01.25 최윤성 [CHM-201108537-01] Create VSL Table 수정
*                  OPR, OPR2 필드 위치 변경, mandatory 처리 및 동적 메소드 적용
* 2011.08.16 최성민 [CHM-201112855-01] [COA]Create VSL table Operator 정보 표시
* 2012.08.17 이석준[CHM-201219742-01] Create VSL Table 화면 T/P 컬럼 값 setting
*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_COA_0037 : ESM_COA_0037 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0037() {
    this.processButtonClick = processButtonClick ;
    this.chgView            = chgView            ;
    this.Popup              = Popup              ;
    this.retrieve           = retrieve           ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.sheet1_OnSearchEnd = sheet1_OnSearchEnd ;
    this.sheet1_OnChange    = sheet1_OnChange    ;
    this.sheet1_OnDblClick  = sheet1_OnDblClick  ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.validateForm       = validateForm       ;
    this.chkValidCreate     = chkValidCreate     ;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet_height = 20; // sheet의 height
var comboCnt = 0;
var loadingMode = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
    /**
     *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
         var sheetObject = sheetObjects[0];
         var formObject = document.form;
         var srcName = window.event.srcElement.getAttribute("name");

        try {
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

                case "btn_Save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;

                case "btn_Downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;

                case "btn_SubTrade":
                    var rtn = window.showModalDialog ("/hanjin/ESM_COA_0038.do", window,"dialogWidth:400px;dialogHeight:320px;center:1; scroll:0; help:0; status:0;");
                    //doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    //noRtnPopup('/hanjin/ESM_COA_038.do', 'width=300,height=300,menubar=0,status=0,scrollbars=0,resizable=0');
                    break;

                case "btn_Rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;

                case "btng_Crrinfo":
                   ComOpenWindow2('ESM_COA_0123.do','', 'width=650,height=370,menubar=0,status=1,scrollbars=0,resizable=0');
                   break;

                case "bu_zoom_in":
                    sheet_height = getSheetHeightCnt(sheetObject,"MAX",1);
                    sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
                    div_zoom_in.style.display = "none";
                    div_zoom_out.style.display = "inline";
    				if (parent && parent.syncHeight) {
    					parent.syncHeight();
    				}
                    break;

                case "bu_zoom_out":
                    sheet_height = getSheetHeightCnt(sheetObject,"MIN",0);
                    sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
                    div_zoom_in.style.display = "inline";
                    div_zoom_out.style.display = "none";
    				if (parent && parent.syncHeight) {
    					parent.syncHeight();
    				}
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

    function chgView(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];

        if(formObj.f_chkdel.checked){
            sheetObj.ColHidden(0) = true;
            sheetObj.ColHidden(1) = false;
        }else{
            sheetObj.ColHidden(0) = false;
            sheetObj.ColHidden(1) = true;
        }// end if

    }
    
    /**
     * 팝업 함수
     */
    function Popup(str){
        ComOpenWindow2("ESM_COA_0146.do?" + str,'','width=1100, height=550, menubar=no, status=no,scrollbars=no, resizable=yes');

    }

    function retrieve(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        doActionIBSheet(sheetObj,formObj,IBSEARCH);
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		loadingMode = true;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);       
        loadingMode = false;
        btn_Retrieve.focus();
    }
 
   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo, vslSubTrade) {
		var cnt = 0;
        var aryCD = [];
        if (vslSubTrade) {
        	aryCD = vslSubTrade.split("|");
        }
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;         //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);     //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                  //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                            //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(2 , 1, 9, 100);                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(24 + aryCD.length, 4, 0, true);              //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

                    var HeadTitle0 = "Del.|CHK|STS|VSL|T/P|OPR\n(Operation)|OPR2\n(Owner)|Flag|VSL\nClass|Port Class|Designed\nCapa.|Standard \nLoadable Capa.|CRR\nCode";
			        for (var j=0; j<aryCD.length; j++) {
			        	HeadTitle0 += "|Trade Loadable Capa. By Trade";
			        }
			        HeadTitle0 += "|VSL Price|EXP Ratio|VSL Retaining Period|VSL Retaining Period|Del Mark|History \nFlag|||||";

			        var HeadTitle1 = "Del.|CHK|STS|VSL|T/P|OPR\n(Operation)|OPR2\n(Owner)|Flag|VSL\nClass|Port Class|Designed\nCapa.|Standard \nLoadable Capa.|CRR\nCode";
			        for (var j=0; j<aryCD.length; j++) {
			        	HeadTitle1 += "|"+aryCD[j];
			        }
			        HeadTitle1 += "|VSL Price|EXP Ratio|From|To|Del Mark|History \nFlag|||||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtDelCheck,   30, daCenter, true, "");
                    InitDataProperty(0, cnt++, dtCheckBox,   30, daCenter, true, "chg_delt");
                    InitDataProperty(0, cnt++, dtStatus,     30, daCenter, true, "ibflag");
                    InitDataProperty(0, cnt++, dtData,       50, daCenter, true, "vsl_cd",          true,  "", dfEngUpKey,  0, false,  true, 4, true);
                    InitDataProperty(0, cnt++, dtCombo,      40, daCenter, true, "vsl_tp_cd",       true,  "", dfEngUpKey,  0, true,  true, 1);
                    InitDataProperty(0, cnt++, dtCombo,      85, daCenter, true, "vop_cd",          true , "", dfNone,      0, true,  true, 3);
                    InitDataProperty(0, cnt++, dtCombo,      65, daCenter, true, "vsl_oshp_cd",     true , "", dfNone,      0, true,  true, 3);
                    InitDataProperty(0, cnt++, dtData,       50, daCenter, true, "vsl_rgst_cnt_cd", false, "", dfNone,      0, true,  true, 2);
                    InitDataProperty(0, cnt++, dtAutoSum,    70, daRight,  true, "vsl_clss_capa",   false, "", dfInteger,   0, true,  true);
                    InitDataProperty(0, cnt++, dtAutoSum,    70, daRight,  true, "port_clss_capa",  false, "", dfInteger,   0, true,  true);
                    InitDataProperty(0, cnt++, dtAutoSum,    70, daRight,  true, "vsl_dznd_capa",   false, "", dfInteger,   0, true,  true);
                    InitDataProperty(0, cnt++, dtAutoSum,   100, daRight,  true, "stnd_ldb_capa",   false, "", dfFloatOrg,  3, true,  true);
                    InitDataProperty(0, cnt++, dtData,       50, daCenter, true, "crr_cd",          true,  "", dfEngUpKey,  0, false,  true, 3, true);
                    for (var j=0; j<aryCD.length; j++) {
					    InitDataProperty(0, cnt++, dtAutoSum,    80, daRight,  true, aryCD[j],      false, "", dfFloatOrg,   3, true,  true);
					}
                    InitDataProperty(0, cnt++, dtAutoSum,    80, daRight,  true, "vsl_prc",         false, "", dfInteger,   0, true,  true);
                    InitDataProperty(0, cnt++, dtData,       70, daCenter, true, "vsl_prc_rto",     false, "", dfNullFloatOrg, 3, true,  true);
                    InitDataProperty(0, cnt++, dtData,       70, daCenter, true, "vsl_retn_fm_dt",  true, "", dfDateYmd,   0, true,  true);
                    InitDataProperty(0, cnt++, dtData,       70, daCenter, true, "vsl_retn_to_dt",  true, "", dfDateYmd,   0, true,  true);
                    InitDataProperty(0, cnt++, dtData,       60, daCenter, true, "delt_flg",        false, "", dfEngUpKey,  0, false, false, 1);
                    InitDataProperty(0, cnt++, dtData,       40, daCenter, true, "bsa_vsl_flg",     false, "", dfEngUpKey,  0, false, false, 1);


                    // 2009.10.07일 ALPS 전환. 테이블변경 후 히스토리관련 히든값 추가
                    // vsl_seq, lst_flg, vsl_aply_to_dt, vsl_aply_fm_dt
                    InitDataProperty(0, cnt++, dtHidden,     60, daCenter, true, "cre_usr_id",      false, "", dfNone    ,  0,  false,  false);
                    InitDataProperty(0, cnt++, dtHidden,     60, daCenter, true, "vsl_seq",         false, "", dfNone    ,  0,  false,  false);
                    InitDataProperty(0, cnt++, dtHidden,     60, daCenter, true, "lst_flg",         false, "", dfNone    ,  0,  false,  false);
                    InitDataProperty(0, cnt++, dtHidden,     60, daCenter, true, "vsl_aply_to_dt",  false, "", dfNone    ,  0,  false,  false);
                    InitDataProperty(0, cnt++, dtHidden,     60, daCenter, true, "vsl_aply_fm_dt",  false, "", dfNone    ,  0,  false,  false);
                    HeadRowHeight  = 10;
                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(sheet_height) ;

                    InitDataValid(0, "delt_flg", vtCharOnly, "YN");
                    InitDataCombo(0, "vsl_tp_cd","C\tContainer","C","","C",0);
                    chgView();
                    
                    WaitImageVisible = false;
                }
                break;

        }
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    // f_chkdel 체크유무에 때라 sheet의 del 컬럼을 숨기거나 보여준다.
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        var formObj = document.form;
        if (0==ComGetObjValue(formObj.f_cmd)) {
//			ComOpenWait(true);
//			ComSetObjValue(formObj.f_cmd,SEARCHLIST02);
//			var sXml = sheetObj.GetSearchXml("ESM_COA_0037GS2.do", coaFormQueryString(formObj));
//			var arrXml = sXml.split("|$$|");
//			if (arrXml.length > 0)
//				ComCoaSetIBCombo(sheetObj, arrXml[0], "vop_cd", true, 0);
//			if (arrXml.length > 1)
//				ComCoaSetIBCombo(sheetObj, arrXml[1], "vsl_oshp_cd", true, 0);
//			ComOpenWait(false);

			chgView();
	        sheetObj.SumText(0,1) = "";
	        sheetObj.SumText(0,2) = "TOTAL";
        }
    }

    /*
     * 1. vsl_prc_rto 변경시 소숫점을 백분율로 보여줌
     * 2. trd_chk_flg를 선택시 Trade Loadable Capa, trade를 입력할수 있도록 활성화한다.
     *                  선택이 안되었을 경우는 비활성화한다.
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {

        if(sheetObj.ColSaveName(Col) == "vsl_prc_rto" ) {
            sheetObj.CellValue2(Row, Col) = Value * 100;
        } else if (sheetObj.ColSaveName(Col) == "trd_chk_flg") {
            for(i=12; i<22; i++){
                if(Value == 1){
                    sheetObj.CellEditable(Row, i) = true;
                }else{
                    sheetObj.CellEditable(Row, i) = false;
                } // end if
            }//end for
        } else if (sheetObj.ColSaveName(Col) == "stnd_ldb_capa") {
            // stnd_ldb_capa값이 변경되면 Trade에 값을
            // stnd_ldb_capa값으로 초기화시킨다.
            // 단, OPR2가 'HJS'가 아닐 경우만.
            //-----------------------------------------------
            if(sheetObj.CellValue(Row, "vop_cd") != "HJS"){
                var num = 0;
                var header = document.form.f_header.value;
                
                var subTrade = header.split("|");

                if(header != "") num = subTrade.length;
                for(j=0;j<num; j++){
                    sheetObj.CellValue(Row, subTrade[j]) = sheetObj.CellValue(Row, "stnd_ldb_capa");
                }
            }
            //-----------------------------------------------
        }

        //-----------------------------------------------
        // 2007.09.11
        // 삭제된 vessel을 다시 사용할수 있도록 delt_flg = 'N'
        //-----------------------------------------------
        if(sheetObj.ColSaveName(Col) == "chg_delt"){
            if (Value == "1") sheetObj.CellValue(Row, "delt_flg")="N";
            else sheetObj.CellValue(Row, "delt_flg")="Y";

        }

        //-----------------------------------------------
        // 2009.10.14
        // 삭제된 vessel 신규 생성시 해당 vessel이 기존에 존재한다면
        // 신규로 입력이 안되게 한다.
        //-----------------------------------------------
        if(sheetObj.ColSaveName(Col) == "vsl_cd"){
            var current_vsl_code = sheetObj.CellValue(Row, "vsl_cd");

            for(var i=1; i<sheetObj.LastRow; i++){
                if(i != Row){
                    if(current_vsl_code == sheetObj.CellValue(i, "vsl_cd")){
                        ComShowMessage(ComGetMsg("COA10043", current_vsl_code));
                    }
                }
            }
        }
        
        //-----------------------------------------------
        // 2011.01.25
        // OPR(Operation) 변경시 OPR2(Owner) ComboList 재조회.
        //-----------------------------------------------
        if(sheetObj.ColSaveName(Col) == "vop_cd"){
        	if(Value == "") {
        		sheetObj.CellValue(Row, "vsl_oshp_cd") = "";
        		sheetObj.CellComboItem(Row, "vsl_oshp_cd", " |", " |");
        	} else {
        		var param = "";
        		param = param+"&f_cmd="+SEARCHLIST03;
        		param = param+"&f_vop_cd="+sheetObj.CellValue(Row,Col);
        		
        		var sXml = sheetObj.GetSearchXml("ESM_COA_0037GS2.do", param);
        		
        		var arrXml = sXml.split("|$$|");
        		
        		if (arrXml.length > 0)
        			ComCoaSetIBCombo(sheetObj, arrXml[0], "vsl_oshp_cd", true,0,Row);
        	}
        }
    }

    /**
    * sheet1을 더블클릭하여 팝업화면을 띄운다.
    */
    function sheet1_OnDblClick(sheetObj , row, col){
        var str = "f_vsl_cd=" + sheetObj.CellValue(row, "vsl_cd") + "&sysCommUiTitle=Vessel History";
        
        var existCapa = "";
        if ( sheetObj.CellValue(row, "ibflag") == "U" && sheetObj.CellValue(row, "bsa_vsl_flg") == "N"){
        	existCapa = "Y";
        	str = str + "&existCapa="+existCapa;
        }
        // 팝업창 팝업
        Popup(str);
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

        	case IBCLEAR:          //조회
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0037GS2.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 0) {
		            ComConfigSheet(sheetObj);
			        initSheet(sheetObj, 1, ComXml2ComboString(arrXml[0], "code", "name")[0]);
			        formObj.f_header.value = ComXml2ComboString(arrXml[0], "code", "name")[0];
		            ComEndConfigSheet(sheetObj);
				}
				if (arrXml.length > 1)ComCoaSetIBCombo(sheetObj, arrXml[1], "vop_cd", true, 0);
				
				// 2011.01.25 동적메소드로 변경하여 세팅 불필요
				//if (arrXml.length > 2)ComCoaSetIBCombo(sheetObj, arrXml[2], "vsl_oshp_cd", true, 0);;
				
				ComOpenWait(false);
				break;	

            case IBSEARCH:      //조회
            	// 업무처리중 버튼사용 금지 처리
				ComOpenWait(true);
                //if(!validateForm(sheetObj,formObj,sAction)) return false;
                formObj.f_cmd.value = SEARCHLIST01;
                var xml = sheetObj.GetSearchXml("ESM_COA_0037GS.do", coaFormQueryString(formObj));
                formObj.f_header.value = searchEtcData("header", xml);

                // Header 정보를 변경하기 위해 sheet를 초기화 한다.
                //--------------------------------------------------
                // Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.
                sheetObj.Redraw = false;
                sheetObj.Visible = false;
                sheetObj.RemoveAll();
                //sheetObj.Reset();
                loadPage();
                sheetObj.Visible = true;
                sheetObj.Redraw = true;
                //--------------------------------------------------
                sheetObj.LoadSearchXml(xml);
                sheetObj.RemoveEtcData();
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장
                if(!chkValidCreate(sheetObj,formObj)) return false;
                // 업무처리중 버튼사용 금지 처리
				ComOpenWait(true);
                formObj.f_cmd.value = MULTI01;
                sheetObj.DoSave("ESM_COA_0037GS.do", coaFormQueryString(formObj), -1, false);
                ComOpenWait(false);
                break;

            case IBINSERT:      // 입력
                sheetObj.DataInsert(-1);
                sheetObj.CellValue2(sheetObj.LastRow-1, "delt_flg") = "N";
                sheetObj.CellValue2(sheetObj.LastRow-1, "bsa_vsl_flg") = "N";
                sheetObj.CellValue2(sheetObj.LastRow-1, "vsl_seq") = "1"; // 초기값을 1로 세팅
                
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                //sheetObj.SpeedDown2Excel(-1);
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }
                break;
        }
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(formObj.f_vsl_cd.value != ""){
                if (!ComIsAlphabet(formObj.f_vsl_cd)) {
                    ComShowMessage(ComGetMsg("COM12114", "Vessel"));
                    formObj.f_vsl_cd.select();
                    return false;
                }// end if
            }// end if

        }

        return true;
    }

    /**
     *
     */
    function chkValidCreate(sheetObj,formObj){
        var strRowNum = sheetObj.FindStatusRow("I|U");
        var arrRow = strRowNum.split(";");
        var cnt = 0;
        if(strRowNum != "") cnt = arrRow.length-1;
        with(formObj){
            // VSL Retaining Period가 있는지 여부를 확인한다.
            //---------------------------------------------------------            
        	for(i=0; i<cnt; i++){
                if(sheetObj.CellValue(arrRow[i], "vsl_retn_fm_dt") == "" || sheetObj.CellValue(arrRow[i], "vsl_retn_to_dt") == ""){
                    // [COM12114] : VSL Retaining Period 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114", "VSL Retaining Period"));
                    if(sheetObj.CellValue(arrRow[i], "vsl_retn_fm_dt") == "")sheetObj.SelectCell(arrRow[i], "vsl_retn_fm_dt");
                    if(sheetObj.CellValue(arrRow[i], "vsl_retn_to_dt") == "")sheetObj.SelectCell(arrRow[i], "vsl_retn_to_dt");
                    return false;
                }
            }            
        }
        //-----------------------------------------------
        // 2009.10.14
        // 삭제된 vessel 신규 생성시 해당 vessel이 기존에 존재한다면
        // 신규로 입력이 안되게 한다.
        //-----------------------------------------------
        var dupYn = "N";
        var dupVesselCd = "";
        for(var i=1; i<sheetObj.LastRow; i++){
            var current_vsl_code = "";
            if(sheetObj.CellValue(i, "ibflag") == "I"){
                current_vsl_code = sheetObj.CellValue(i, "vsl_cd");
                for(var j=1; j<sheetObj.LastRow; j++){
                    if(j!=1 && sheetObj.CellValue(j, "ibflag") != "I" && current_vsl_code == sheetObj.CellValue(j, "vsl_cd")){
                        dupYn = "Y";
                        dupVesselCd = current_vsl_code;
                        break;
                    }
                }
            }
        }

        if(dupYn == "Y") {
            ComShowMessage(ComGetMsg("COA10043", dupVesselCd));
            return false;
        }

        return true;
    }