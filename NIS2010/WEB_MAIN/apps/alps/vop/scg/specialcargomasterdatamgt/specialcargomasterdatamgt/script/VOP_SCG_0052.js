/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0052.js
*@FileTitle : Partner’s Contact Point for SPCL CGO (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.18 장강철 jkc
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
     */

    /**
     * @extends 
     * @class vop_scg_0052 : vop_scg_0052 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0052() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    /* 개발자 작업   */

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_Retrieve":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    break;
                
                case "btn1_Excel":                    
                    doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
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

     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }

     /**
      * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
     function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
     }
     
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
         // combo
         combo1 = comboObjects[0];
         comboCnt = comboObjects.length;                          

         for(i=0;i<sheetObjects.length;i++){
             //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         // IBMultiCombo초기화
         for(var k=0; k<comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         }
         
         //html컨트롤 이벤트초기화
         initControl();


     }
      function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet( sheetObj,document.form,IBSEARCH_ASYNC01);
      } 

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    var HeadTitle = "|No.|Carrier Code|Carrier Full Name|Lane|CGO Type|E-mail|TEL No|FAX No|";
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo( HeadTitle.split("|").length, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)



                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  "ibflag");
                    InitDataProperty(0, cnt++ , dtDataSeq,      30,    daCenter);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,   "crr_cd",           false,   "",      dfNone,    0,     false,   true,   4);
                    InitDataProperty(0, cnt++ , dtData,         155,    daLeft,     true,   "vsl_opr_nm",       false,  "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,   "slan_cd",          false,   "",      dfNone,    0,     false,   true,   3, true);
                    InitDataProperty(0, cnt++ , dtCombo,        85,     daCenter,   true,   "spcl_cgo_cate_cd", false,   "",      dfNone,    0,     false,   true);                       
                    InitDataProperty(0, cnt++ , dtData,         310,    daLeft,     true,   "cntc_pson_eml_ctnt",false,  "",      dfNone,    0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,         90,     daCenter,   true,   "cntc_pson_phn_no", false,  "",      dfNone,    0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,         80,     daCenter,   true,   "cntc_pson_fax_no", false,  "",      dfNone,    0,     true,    true);                                          
                    InitDataProperty(0, cnt++ , dtHidden,       30,     daLeft,     true,   "delt_flg",         false,  "",      dfNone,    0,     true,    true);
                       
                    InitDataValid(0, "crr_cd", vtEngUpOnly);
                    InitDataValid(0, "slan_cd", vtEngUpOnly);
                    InitDataCombo(0, "spcl_cgo_cate_cd", "DG|AWK", "01|02");
                    
                }
                break;
         }
     }

     /**
      * Combo 기본 설정
      * Combo의 항목을 설정한다.
      */
     function initCombo(comboObj, comboNo) {
        switch(comboObj.id) {
            case "rgn_shp_opr_cd":
                with(comboObj) {
                    SetTitle("Code|Description");
    	  			SetColAlign("center|left");
                    SetColWidth("50|150")
                    DropHeight = 260;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                }
                break;          
        }
    }     
     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

            case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)) {
                    if(sheetObj.id == "sheet1") {
                        formObj.f_cmd.value = SEARCH;
                        sheetObj.DoSearch("VOP_SCG_0034GS.do", FormQueryString(formObj));
                    }
                }
                break;
            
            case IBSEARCH_ASYNC01: // RSO조회
                formObj.f_cmd.value = SEARCH01;
                var sXml = sheetObj.GetSearchXml("VOP_SCG_0034GS.do", FormQueryString(formObj));                
                ComXml2ComboItem(sXml, formObj.rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
                break;
 
 
            case IBDOWNEXCEL:      // Excel
                var paramObj = new Object();
                paramObj.title = "Partner's Contact Point for SPCL CGO ";
                paramObj.columnwidth = "2:10|3:25|4:7|5:7|6:45|7:10|8:10";
                var url = ComScgGetPgmTitle(sheetObj, paramObj); 
                sheetObj.SpeedDown2Excel(-1, false, false, "", url );
                break;            
         }
     }

     //업무 자바스크립트 OnKeyPress 이벤트 Catch
     function initControl() {
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
         axon_event.addListener('change', 'combo_OnChange', 'rgn_shp_opr_cd');     
     }
     
    function combo_OnChange(comboObj, code, text) {
        var formObj = document.form;
        if (!ComIsNull(code)) {
            var arrText = code.split("|");
            formObj.rgn_shp_opr_desc.value = arrText[1];
			//RSO코드가 선택시 조회를 한다.
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
 
        if (sAction == IBSEARCH) {
        	if (comboObjects[0].Code == "") {
        		ComShowCodeMessage('SCG50011','RSO');
        		formObj.rgn_shp_opr_cd.focus();
        		return;
        	}
        }
        return true;
    }

    /**
      * IBSheet Object에서 팝업을 클릭시
      */
    function sheet1_OnPopupClick(sheetObj, Row, Col){
        
        if (sheetObj.ColSaveName(Col) == "crr_cd") {
            ComOpenPopup("COM_ENS_0N1.do?crr_cd="+sheetObj.CellValue(Row, "crr_cd"), 423, 420, "setCrrCd", "1,0,1,1,1,1", false, false, Row, Col, 0);
        } else if (sheetObj.ColSaveName(Col) == "slan_cd") {
			ComOpenPopup('/hanjin/VOP_VSK_0202.do', 426, 455, "setSlanCd", "0,0", true, false, Row, Col, 0);
        }
        
    }
    
 

    /**
     * crr_cd 입력부분.<br>
     * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
     */
    function setCrrCd(aryPopupData, Row, Col, sheetIdx){
        sheetObjects[0].CellValue2(Row,Col) = aryPopupData[0][1];
        sheetObjects[0].CellValue2(Row,3) = aryPopupData[0][2];
    }
     
    /**
     * slan_cd 입력부분.<br>
     * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
     */
    function setSlanCd(aryPopupData, Row, Col, sheetIdx){
        //sheetObjects[0].CellValue2(Row,Col) = aryPopupData[0][1];
        sheetObjects[0].CellValue2(Row,Col) = aryPopupData[0][3];
    }
     

    /* 개발자 작업  끝 */