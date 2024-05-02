/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1148.js
 *@FileTitle : Pakistan Customs Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.18
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.07.18 김보배
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2012.08.31 김보배 [CHM-201219908] [BKG] Pakistan Manifest 기능 보완 요청
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
 * @class ESM_BKG-1148 : ESM_BKG-1148 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1148() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.tsTpCd_OnChange=tsTpCd_OnChange;
}
/* 개발자 작업 */
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;
var intervalId = "";

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

		 var sheetObject = sheetObjects[0];
         var formObject = document.form;
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					
				case "btn_down_excel":
					if( beforetab == 0 ){
						doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
					} else if( beforetab == 1 ){
						doActionIBSheet(sheetObjects[1],document.form,IBDOWNEXCEL);
					} else {
						doActionIBSheet(sheetObjects[2],document.form,IBDOWNEXCEL);
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
      * 
      * @param {IBMultiCombo}
      *            combo_obj IBMultiCombo Object
      */
     function setComboObject(combo_obj) {
     	comboObjects[comboCnt++] = combo_obj;
     }
     
     /**
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;
     }
         
     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     var cnt  = 0 ;
                     InsertTab( cnt++ , "B/L Info" , -1 );
                     InsertTab( cnt++ , "CNTR Info" , -1 );
                     InsertTab( cnt++ , "Charge Info" , -1 );
                 }
              break;

          }
     }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			ComEndConfigSheet(sheetObjects[i]);
  		}
        
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
		initControl();
    }
  
     /**
      * 조회조건 입력할 때 처리
      */
     function obj_KeyUp() {
    	  var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	  var formObject = document.form;
	     var srcName = window.event.srcElement.getAttribute("name");
	     var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	     var srcValue = window.event.srcElement.getAttribute("value");
	     if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
	     	ComSetNextFocus();
	     }
     }
     
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {

		DATE_SEPARATOR = "-";
  	
		var formObject = document.form;
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		axon_event.addListenerForm("click", "obj_Clicked", document.form);
		axon_event.addListenerForm("change", "obj_OnChange", document.form);
		
	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

		var sheetID = sheetObj.id;
				
        switch(sheetID) {

        case "sheet1":      //sheet1 init
        	with (sheetObj) {

            	var cnt = 0;
                // 높이 설정
                style.height = 400;
                AutoRowHeight = false;
                
                //전체 너비 설정
                SheetWidth = 400;
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 3);

                var HeadTitle1 = "|Sel.|Seq.|Vessel|Voayge||BL No.|Shipper|Shipper|CNEE|CNEE|Notify|Notify|A/Notify|A/Notify|POL|POD|DEL|Last Port|R/D Term|BL Date|Customs Description|Marks & Nos|Description of Goods|"; // 
                var HeadTitle2 = "|Sel.|Seq.|Vessel|Voayge||BL No.|Name|Address|Name|Address|Name|Address|Name|Address|POL|POD|DEL|Last Port|R/D Term|BL Date|Customs Description|Marks & Nos|Description of Goods|"; 
				var headCount = ComCountHeadTitle(HeadTitle1);					

    			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(headCount, 0, 0, true);
    			
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle1, true);
	    		InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ ROW,  COL,    DATATYPE,     WIDTH,    DATAALIGN, COLMERGE, SAVENAME, 	 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	false,	"ibflag");
                InitDataProperty(0, cnt++ , dtDummyCheck,	 40,    daCenter,	true,  	"chk");
                InitDataProperty(0, cnt++ , dtDataSeq,		 30,	daCenter,	true,	"seq");
                InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,	"vvd_nm",		false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		 60,	daCenter,	true,	"voy_cd",		false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtHidden,	 95,	daCenter,	true,	"bkg_no",		false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		 95,	daCenter,	true,	"bl_no",		false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		130,	daLeft,		true,	"shpr_nm",		false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		130,	daLeft,		true,	"shpr_addr",	false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,	"cnee_nm",		false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		130,	daLeft,		true,	"cnee_addr",	false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,	"ntfy_nm",		false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		130,	daLeft,		true,	"ntfy_addr",	false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,	"a_ntfy_nm",	false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		130,	daLeft,		true,	"a_ntfy_addr",	false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		 50,	daCenter,	true,	"pol_cd",		false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		 50,	daCenter,	true,	"pod_cd",		false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		 50,	daCenter,	true,	"del_cd",		false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,	true,	"last_port",	false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		 65,	daCenter,	true,	"rd_term_cd",	false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		120,	daCenter,	true,	"obl_iss_dt",	false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		130,	daLeft,		true,	"cstms_desc",	false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		130,	daLeft,		true,	"mk_desc",		false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		230,	daLeft,		true,	"cmdt_desc",	false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtHidden,	 60,	daCenter,	true,	"total_bl",		false,	"", 	dfNone,	0,	false,	false);
                
                CountPosition = 0;
           }
           break;


        case "sheet2":
    		with (sheetObj) {
    			var cnt = 0;
    			// 높이 설정
    			style.height = 400;

                //전체 너비 설정
                SheetWidth = 400;

    			// Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "")
    				InitHostInfo(location.hostname, location.port, page_path);

    			// 전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msHeaderOnly;

    			// 전체Edit 허용 여부 [선택, Default false]
    			Editable = true;

    			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo(1, 1, 3);


    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, true, true, false, false)

    			var HeadTitle1 = "|sel.|Seq.|BL No.|CNTR No.|TS|HS Code|Customs D|Seal No.|Package|Package|Weight|Weight|Measure|Measure|Un No.|IMDG|SOC";
    			var headCount = ComCountHeadTitle(HeadTitle1);

    			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(headCount, 0, 0, true);
    			
    			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle1, true);

    			//데이터속성    [ ROW,  COL,    DATATYPE,     WIDTH,    DATAALIGN, COLMERGE, SAVENAME, 	 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	true,	"ibflag");
    			InitDataProperty(0, cnt++ , dtDummyCheck,    40,    daCenter,   true,  	"chk");
    			InitDataProperty(0, cnt++ , dtDataSeq,		 30,	daCenter,	true,	"seq");
    			InitDataProperty(0, cnt++ , dtData,			 90,	daCenter,	true,	"bkg_no",          false,	"", 	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			 90,	daCenter,	true,	"cntr_no",         false,	"", 	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	true,	"cntr_tpsz_cd",    false,	"", 	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			 60,	daCenter,	true,	"cmdt_hs_cd",      false,	"", 	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,	"cntr_mf_gds_desc",false,	"", 	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	true,	"cntr_seal_no",    false,	"", 	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			 40,	daRight,	true,	"pck_qty",         false,	"", 	dfNumber,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			 60,	daCenter,	true,	"pck_nm",       false,	"", 	dfNone,	0,	false,	false);                                               
    			InitDataProperty(0, cnt++ , dtData,			 60,	daRight,	true,	"cntr_mf_wgt",     false,	"", 	dfNumber,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			 40,	daCenter,	true,	"wgt_ut_cd",       false,	"", 	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			 50,	daRight,	true,	"meas_qty",        false,	"", 	dfNumber,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			 40,	daCenter,	true,	"meas_ut_cd",      false,	"", 	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			 40,	daCenter,	true,	"imdg_un_no",		false,	"", 	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			 40,	daCenter,	true,	"imdg_clss_cd",		false,	"", 	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	true,	"soc_flg",         false,	"", 	dfNone,	0,	false,	false);
    			
    			CountPosition = 0;

    		}
    		break;
    		
    	
        case "sheet3":
    		with (sheetObj) {
    			var cnt = 0;
    			// 높이 설정
    			style.height = 400;

                //전체 너비 설정
                SheetWidth = 400;

    			// Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "")
    				InitHostInfo(location.hostname, location.port, page_path);

    			// 전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msHeaderOnly;

    			// 전체Edit 허용 여부 [선택, Default false]
    			Editable = true;

    			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo(1, 1, 3);


    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, true, true, false, false)

    			var HeadTitle1 = "|Seq.|BL No.|Charge Code|Per|Currency|P/C|Amount";
    			var headCount = ComCountHeadTitle(HeadTitle1);

    			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(headCount, 0, 0, true);
    			
    			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle1, true);

    			//데이터속성    [ ROW,  COL,    DATATYPE,     WIDTH,    DATAALIGN, COLMERGE, SAVENAME, 	 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	true,	"ibflag");
//    			InitDataProperty(0, cnt++ , dtDummyCheck,    40,    daCenter,   true,  	"chk");
    			InitDataProperty(0, cnt++ , dtDataSeq,		 70,	daCenter,	true,	"seq");
    			InitDataProperty(0, cnt++ , dtData,		150,	daCenter,	true,	"bkg_no",		false,	"", 	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,		200,	daCenter,	true,	"chg_cd",		false,	"", 	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,		120,	daCenter,	true,	"rat_ut_cd",	false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		150,	daCenter,	true,	"curr_cd",		false,	"", 	dfNone,	0,	false,	false);    
                InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"frt_term_cd",	false,	"", 	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,	"chg_amt",		false,	"", 	dfNumber,	0,	false,	false);    
                
    			CountPosition = 0;

    		}
    		break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				formObj.f_cmd.value = SEARCH;
				
				var frobs = formObj.elements("port_flg");
				for (i = 0; i < frobs.length; i++) {
					if (frobs[i].checked) {
						if (frobs[i].value == "pol") {
							formObj.pol_cd.value = formObj.pol_pod_cd.value;
							formObj.pod_cd.value = "";
						} else {
							formObj.pod_cd.value = formObj.pol_pod_cd.value;
							formObj.pol_cd.value = "";
						}
					}
				}
				
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1148GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) {
					sheetObjects[0].LoadSearchXml(arrXml[0]);
					sheetObjects[1].LoadSearchXml(arrXml[1]);
					sheetObjects[2].LoadSearchXml(arrXml[2]);
				}
				
				ComEtcDataToForm(formObj, sheetObj);
				
				ComOpenWait(false);
				sheetObj.WaitImageVisible = true;
				
				break;
			
			case IBDOWNEXCEL:
				if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObj.Down2Excel(-1, false, false, true);
				break;
        }
  	}
   
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			case IBSEARCH:
				if(!ComChkRequired(formObj)) return false;
				break;

			case IBDOWNEXCEL:
				if(sheetObjects[0].RowCount == 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				break;	
    	}
        return true;
    }

    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj, nItem) {
    	var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

		// --------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
		// ------------------------------------------------------//
		beforetab = nItem;
    }
    
    
    /**
     * radio버튼 클릭에 따라 조건 검색을 바꿔준다.
     * @param formObj
     * @return
     */
    function OnClickRadioButton(formObj) {
    	var frobs = formObj.elements("port_flg");
    	for (i = 0; i < frobs.length; i++) {
    		if (frobs[i].checked) {
    			if (frobs[i].value == "pol") {
    				formObj.pol_cd.value = formObj.pol_pod_cd.value;
    			} else {
    				formObj.pod_cd.value = formObj.pol_pod_cd.value;
    			}

    		}
    	}
    }
    
    
    
    /**
     * 시트를 클릭했을 때 처리
     */
    function sheet1_OnClick(sheetObj, row, col) {
    	
        var colSaveName = sheetObj.ColSaveName(col);
        
        switch(colSaveName) {
        	case "vvd_nm" : 
        	case "shpr_nm" :
	        case "shpr_addr" :
	        case "cnee_nm" :  
	        case "cnee_addr" :
	        case "ntfy_nm" : 
	        case "ntfy_addr" :
	        case "a_ntfy_nm" : 
	        case "a_ntfy_addr" :
	        case "cstms_desc" :
	        case "mk_desc" : 
	        case "cmdt_desc" :
	        	/* 긴 문자열 MemoPad 처리*/
	    		if(sheetObj.CellValue(row,col) != "") {
	    			ComShowMemoPad(sheetObj, null, null, true, 250, 80);
	    		}
	    		break;
        } // end switch
        
    }
     
     /**
      * 시트를 클릭했을 때 처리
      */
     function sheet2_OnClick(sheetObj, row, col) {
     	
         var colSaveName = sheetObj.ColSaveName(col);
         
         switch(colSaveName) {
 	        case "cntr_mf_gds_desc" :
 	        	/* 긴 문자열 MemoPad 처리*/
 	    		if(sheetObj.CellValue(row,col) != "") {
 	    			ComShowMemoPad(sheetObj, null, null, true, 250, 80);
 	    		}
 	    		break;
         } // end switch
         
     }
    
