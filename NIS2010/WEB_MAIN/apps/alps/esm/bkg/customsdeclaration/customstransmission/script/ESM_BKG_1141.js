/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1141.js
 *@FileTitle : Malaysia Customs Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.03 
 *@LastModifier : 변종건
 *@LastVersion : 1.0
 * 2012.02.03  변종건
 * 1.0 Creation
 * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
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
 * @class ESM_BKG-1141 : ESM_BKG-1141 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1141() {
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

//추가 전역 변수
// VSL 관련 필수항목
var vsl_call_no; 
var vsl_id; 
		
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
					
				case "btn_down_excel":
					if( beforetab == 0 ){
						doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
					} else{
						doActionIBSheet(sheetObjects[1],document.form,IBDOWNEXCEL);
					}
					break;
				
				case "btn_Transmit":
					doActionIBSheet(sheetObjects[0], document.form, MULTI);
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
                 }
              break;

          }
     }
      
     /**
      * 콤보 초기설정값
      * 
      * @param {IBMultiCombo}
      * comboObj comboObj
      */
     function initCombo(comboObj) {
         switch(comboObj.id) {
         	case "s_status": 
         		doActionIBSheet(sheetObjects[0],document.form,"setCombo");
         		
                comboObj.Code = "9";
                comboObj.SetColWidth("50|550|0");
                comboObj.DropHeight= 350;
                comboObj.ColBackColor(0) = "#eeeeee";
                break;
                
      	    default:
      	    	comboObj.MultiSelect = false;
      			comboObj.UseCode = true;
      			comboObj.LineColor = "#ffffff";
      			comboObj.SetColAlign("left|left");
      			comboObj.MultiSeparator = "|";
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
  			//khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
        
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);           
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
		//** Date 구분자 **/
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
                    style.height = 340;
                    
                    //전체 너비 설정
                    SheetWidth = 400;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 4, 100);

                    var HeadTitle1 = "|Sel.|Seq.|B/L No.|POR|POL|POD|DEL|CN|R/D|R/D|Trunk VVD|Trunk POL|Trunk POD|Customs Description|Package|Package|Weight|Weight|Measure|Measure|DG|RF|AW|BB|BKG NO|Description|Mode|VVD|Input POL|Input POD|Trasmit Status|BL Count|Container Count|Type";
					var headCount = ComCountHeadTitle(HeadTitle1);					

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ ROW,  COL,    DATATYPE,     WIDTH,    DATAALIGN, COLMERGE, SAVENAME, 	 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		 40,	daCenter,	false,	"sel");
					InitDataProperty(0, cnt++ , dtDataSeq,		 30,	daCenter,	false,	"seq");
					InitDataProperty(0, cnt++ , dtData,		     90,	daCenter,	false,	"bl_no",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"por_cd",   	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"pol_cd",  		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"pod_cd",   	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"del_cd",  		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"cn_flg",  		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 20,	daCenter,	false,	"rcv_term_cd", 	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 20,	daCenter,	false,	"de_term_cd",  	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	true,	"trnk_vvd",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	true,	"trnk_pol",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	true,	"trnk_pod",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			140,	daLeft,     true,	"description",	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 60,	daRight,	false,	"pck_qty",		false,		"", 	dfNumber,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	false,	"pck_tp_cd",	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 60,	daRight,	false,	"act_wgt",		false,		"", 	dfNumber,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	false,	"wgt_ut_cd",	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     60,	daRight,	false,	"meas_qty",		false,		"", 	dfNumber,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	false,	"meas_ut_cd",   false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	false,	"dcgo_flg",  	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	false,	"rd_cgo_flg",   false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	false,	"awk_cgo_flg",  false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	false,	"bb_cgo_flg",  	false,		"", 	dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"bkg_no",  		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"description2", false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 50,	daCenter,	false,	"e_i_ind",  	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"vvd",  		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"input_pol_cd", false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"input_pod_cd", false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"trsm_sts",  	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"bl_knt",  		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"ttl_cntr_knt", false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 50,	daCenter,	false,	"ts_tp_cd",  	false,		"", 	dfNone,		0,			false,		false);
					WaitImageVisible = false;  
					CountPosition = 2;	
					 
            }
               break;


            case "sheet2":
	    		with (sheetObj) {
	    			var cnt = 0;
	    			// 높이 설정
	    			style.height = 340;
	    			// 전체 너비 설정
	    			SheetWidth = mainTable.clientWidth;
	
	    			// Host정보 설정[필수][HostIp, Port, PagePath]
	    			if (location.hostname != "")
	    				InitHostInfo(location.hostname, location.port, page_path);
	
	    			// 전체Merge 종류 [선택, Default msNone]
	    			MergeSheet = msHeaderOnly;
	
	    			// 전체Edit 허용 여부 [선택, Default false]
	    			Editable = true;
	
	    			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			InitRowInfo(2, 1, 3, 100);
	
	
	    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    			InitHeadMode(true, true, false, true, false, false)
	
	    			var HeadTitle1 = "|Seq.|B/L No.|Container|Container|Container|Container|Container|Container|Container|Container|Container";
	    			var HeadTitle2 = "|Seq.|B/L No.|Container No.|CNTR TS|SEAL No.|Package|Package|Weight|Weight|Measure|Measure";
	    			var headCount = ComCountHeadTitle(HeadTitle1);
	
	    			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    			InitColumnInfo(headCount, 3, 0, true);
	    			
	    			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			InitHeadRow(0, HeadTitle1, true);
	    			InitHeadRow(1, HeadTitle2, true);
	
	    			//데이터속성    [ ROW,  COL,    DATATYPE,     WIDTH,    DATAALIGN, COLMERGE, SAVENAME, 	 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,		 40,	daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,		   	130,	daCenter,	true,	"bl_no",   		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	true,	"cntr_no",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 90,	daCenter,	true,	"cntr_tpsz_cd", false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	"cntr_seal_no", false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 90,	daRight,	true,	"pck_qty",  	false,		"", 	dfNumber,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 60,	daCenter,	true,	"pck_tp_cd",  	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 90,	daRight,	true,	"cntr_wgt",  	false,		"", 	dfNumber,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 60,	daCenter,	true,	"wgt_ut_cd",  	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 90,	daRight,	true,	"meas_qty",  	false,		"", 	dfNumber,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 60,	daCenter,	true,	"meas_ut_cd",  	false,		"", 	dfNone,		0,			false,		false);
	
	    			CountPosition = 2;
	    		}
	    		break;

        }
    }

    
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case "setCombo": // Status id 콤보값 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1141GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.s_status, "val", "name");
				break;
				
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1141GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[1].LoadSearchXml(arrXml[1]);
				
				break;
				
			case IBDOWNEXCEL:
				if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObj.Down2Excel(-1, false, false, true);
				break;
					
			case MULTI:        //Transmit
				if( ! validateForm(sheetObj,formObj,sAction)) return;
				var idx = 0;
				for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
					sheetObj.CellValue2(idx,"trsm_sts") = comboObjects[0].Code;
					//sheetObj.RowStatus(idx)= "U";
					if(sheetObj.CellValue(idx, "sel") == 1) {
						sheetObj.RowStatus(idx)= "U";
					}else{
						sheetObj.RowStatus(idx)= "";
					}
				}
				for( idx = 0+parseInt(sheetObjects[1].HeaderRows); idx < sheetObjects[1].RowCount+parseInt(sheetObjects[1].HeaderRows); idx++ ){
					sheetObjects[1].RowStatus(idx)= "U";
				}
				
				formObj.f_cmd.value = MULTI;
				ComOpenWait(true); 
				var sParam = "";
				var sParamSheet1 = sheetObjects[0].GetSaveString();
				var sParamSheet2 = sheetObjects[1].GetSaveString();

				if (sParamSheet1 != "") {
					sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
				}
				if (sParamSheet2 != "") {
					sParam = sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
				}
				sParam = sParam + "&" + FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1141GS.do", sParam);
				var key = ComGetEtcData(sXml, "KEY");

				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);

				break;
        }
  	}
        
    /**
     * BackEndJob 실행결과조회.
     */
    function doActionValidationResult(sheetObj, sKey) {

    	var sXml = sheetObj.GetSearchXml("ESM_BKG_1141GS.do?f_cmd=" + SEARCH01 + "&key=" + sKey);
    	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
    	

    	// 에러가 발생했을 경우 대기사항을 종료한다.
    	if (!ComBkgErrMessage(sheetObj, sXml)) {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
    	if (sJbStsFlg == "SUCCESS") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 성공메시지 보여주고
    		ComShowCodeMessage('BKG00101');	
    		return;
    	} else if (sJbStsFlg == "FAIL") {
    		//에러
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 에러메시지 보여주고
    		ComShowMessage(ComResultMessage(sXml));
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
				
			case MULTI:
				if(sheetObjects[0].RowCount == 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				var iCheckRow = sheetObjects[0].CheckedRows("sel");
				if(iCheckRow <= 0){
					ComShowCodeMessage('BKG02108');//coBKG 추가   "Please click the Check Box which you want to transmit"
					return false;
				}
				
		        if(ComIsEmpty(vsl_call_no) && ComIsEmpty(vsl_id)){
		        	// msgs['BKG06133'] = "{?msg1} is empty."
		            ComShowCodeMessage("BKG06133","Ship Call No./Vessel ID");
		            return false;
		        }else if(ComIsEmpty(vsl_call_no)){
		            ComShowCodeMessage("BKG06133","Ship Call No.");
		            return false;
		        }else if(ComIsEmpty(vsl_id)){
		            ComShowCodeMessage("BKG06133","Vessel ID");
		            return false;
		        }
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
     * 조회완료후 이벤트
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	for( var idx=0; idx<document.form.s_mode.length; idx++)	{
    		if( document.form.s_mode[idx].checked == true ){
    			for( var jdx = 0+parseInt(sheetObj.HeaderRows); jdx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); jdx++ ){
    	    		sheetObj.CellValue2(jdx,"e_i_ind") = document.form.s_mode[idx].value;
    	    		sheetObj.CellValue2(jdx,"input_pol_cd") = document.form.s_pol_cd.value;
    	    		sheetObj.CellValue2(jdx,"input_pod_cd") = document.form.s_pod_cd.value;
    	    		sheetObj.CellValue2(jdx,"bl_knt") = document.form.bl_tot_cnt.value;
    	    		sheetObj.CellValue2(jdx,"ts_tp_cd")= document.form.ts_tp_cd.value;
    	    	}
    		}
		}

    	var formObj = document.form;
    	formObj.bl_tot_cnt.value = sheetObj.RowCount;
        vsl_call_no = sheetObj.EtcData("vsl_call_no");
        vsl_id      = sheetObj.EtcData("vsl_id");
        
        formObj.ship_call_no.value = vsl_call_no;
        formObj.vsl_id.value       = vsl_id;
        
//        if(ComIsEmpty(vsl_call_no) && ComIsEmpty(vsl_id)){
//        	// msgs['BKG06133'] = "{?msg1} is empty."
//            ComShowCodeMessage("BKG06133","Ship Call No./Vessel ID");
//        }else if(ComIsEmpty(vsl_call_no)){
//            ComShowCodeMessage("BKG06133","Ship Call No.");
//        }else if(ComIsEmpty(vsl_id)){
//            ComShowCodeMessage("BKG06133","Vessel ID");
//        }        

        
	}
     
    /**
     * 조회완료후 이벤트
     */
 	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
     	document.form.cntr_tot_cnt.value = sheetObj.RowCount;
     	
     	for( var jdx = 0+parseInt(sheetObjects[0].HeaderRows); jdx < sheetObjects[0].RowCount+parseInt(sheetObjects[0].HeaderRows); jdx++ ){
     		sheetObjects[0].CellValue2(jdx,"ttl_cntr_knt") = document.form.cntr_tot_cnt.value;
    	}
 	}
     
    /**
     * Booking Creation 화면 이동
     * @param sheetObj Sheet
     * @param Row Row Index
     * @param Col Col Index
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
    }
     
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_Clicked() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if(srcName == "s_mode"){
	    	if(srcValue == "E"){
	    		document.form.s_pol_cd.required = true;
	    		document.form.s_pol_cd.className = "input1";
	    		
	    		document.form.s_pod_cd.required = null;
	    		document.form.s_pod_cd.className = "input";
	    		document.form.s_pod_cd.value ="";
	    	}else if(srcValue == "I"){
	    		document.form.s_pol_cd.required = null;
	    		document.form.s_pol_cd.className = "input";
	    		document.form.s_pol_cd.value ="";
	    		
	    		document.form.s_pod_cd.required = true;
	    		document.form.s_pod_cd.className = "input1";
	    	}
    	}
    }
     
     /**
      * ts_tp_cd 클릭시 시트에 값을 넘겨주고 T 일 경우는 E_I_IND 값이 무조건 T로 나간다.
      * 
      */
     function tsTpCd_OnChange() {
    	  
    		for( var i=0; i<=sheetObjects[0].RowCount ; i++)	{
    			
    			sheetObjects[0].CellValue2(i,"ts_tp_cd")= document.form.ts_tp_cd.value;
    		    	
    			
    		}
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

