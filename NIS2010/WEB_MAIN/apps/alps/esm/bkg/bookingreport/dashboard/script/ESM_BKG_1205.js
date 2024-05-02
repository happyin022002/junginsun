/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : esm_bkg_1201.js
*@FileTitle : BKG Dashboard Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.6
*@LastModifier : Poong-Yeon Cho
*@LastVersion : 1.0
* 2013.11.6 Poong-Yeon Cho
* 1.0 Creation
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
     * @extends 
     * @class esm_bkg_1201  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1203() {
    	this.processButtonClick    = processButtonClick;
    	this.setSheetObject        = setSheetObject;
    	this.loadPage              = loadPage;
    	this.initSheet             = initSheet; 
    	this.initControl           = initControl;
    	this.doActionIBSheet       = doActionIBSheet;
    	this.setTabObject          = setTabObject;
    	this.validateForm          = validateForm;
    	this.sheet1_OnClick        = sheet1_OnClick;
    	this.sheet1_OnKeyUp        = sheet1_OnKeyUp;
    	this.setComboObject        = setComboObject;
    }
    
   	/* 개발자 작업	*/    
     
 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;

 /**
  * IBSheet Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
  */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}
     
 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}


//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var formObject = document.form;
                
    var srcName = window.event.srcElement.getAttribute("name");

    switch(srcName) {

        case "btn_close":
            window.close();
            break;
        case "btn_downexcel":
            doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
            break;
        case "btn_retrieve":
            doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
            break;

    } // end switch
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

    var cnt = 0;

    switch (sheetNo) {
    case 1: 
        with (sheetObj) {
            // 높이 설정
            style.height = GetSheetHeight(16) ;
            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;
            
            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 9, 100);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false) ;

            var HeadTitle = "ibflag|Seq|BKG No|Shipper|Consignee|Notify Party|POR|POL|POD|DEL|T.VVD|Current\nLocation|Contact No.|BKG\nStatus|POL ETD|VL Staying Days"
            	 +"|Not Updated\nCNTR. List"
                ;

            var headCount = ComCountHeadTitle(HeadTitle);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true)

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
            // SAVESTATUS, FORMATFIX]

            InitDataProperty(0, cnt++, dtHiddenStatus, 80, daCenter, false,  "ibflag",        false,          "",       dfNone,    0,     false,      false);
            InitDataProperty(0, cnt++, dtDataSeq, 75, daCenter, false, "s_seq",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bkg_no",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "shrp",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "cnee",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "ntfy",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "por_nod_cd",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pol_nod_cd",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pod_nod_cd",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "del_nod_cd",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "t_vvd",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "crnt_yd_cd",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "ctrt_no",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "bkg_sts_cd",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "vps_etd_dt",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "accr_dt",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "not_upd_cntr_list",      false,          "",       dfNone,          0,     false,       false);
            DataLinkMouse('bkg_no') = true;
            ToolTipText(0, 'crnt_yd_cd') = 'location of the container (the latest updated one) ';
            ToolTipText(0, 'accr_dt') = 'the number of days after on-board date';
        }
        break;
    }
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
    switch (sAction) {
    case IBSEARCH:
        formObj.f_cmd.value = SEARCH09 ;
        sheetObj.DoSearch("ESM_BKG_1201GS.do", FormQueryString(formObj));
        break;
        
    case IBDOWNEXCEL:        //엑셀 다운로드
        ComOpenWait(true);
    sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false );
        ComOpenWait(false);
        break;
    }
}

function sheet1_OnDblClick(sheetObj,Row, Col, CellX, CellY, CellW, CellH) {
    var formObj = document.form;
    var colName = sheetObj.ColSaveName(Col);
    switch (colName){
        case 'bkg_no' :
            var param= "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(Row, Col);
            ComOpenWindowCenter2("/hanjin/ESM_BKG_0079.do"+param, "Booking Main", 1024,740,true,"scrollbars=yes,resizable=yes");
            break;
    }
}

function sheet1_OnSearchEnd(sheetObj)
{
    sheetObj.ColFontUnderline('bkg_no') = true;
    sheetObj.ColFontColor('bkg_no')= sheetObj.RgbColor(0, 0, 255);
    sheetObj.RangeFontBold(1,sheetObj.SaveNameCol('bkg_no'),sheetObj.RowCount,sheetObj.SaveNameCol('bkg_no'))=true;
}