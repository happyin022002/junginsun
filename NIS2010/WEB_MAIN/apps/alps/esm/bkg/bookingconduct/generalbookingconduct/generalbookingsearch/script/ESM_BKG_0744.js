/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0744.js
*@FileTitle : Direct NVO AMS File No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.25 
* 1.0 Creation KimByungKyu
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
     * @class esm_bkg_0744 : esm_bkg_0744 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0744() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1; 

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
    	/*******************************************************/
    	var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
 			switch(srcName) { 					
 				case "btn_RowAdd":
 					if(ComIsBtnEnable("btn_RowAdd")){
 						sheetObjects[0].DataInsert(-1);
 					} 					
 					break;
 					
 				case "btn_Delete":
 					if(ComIsBtnEnable("btn_Delete")){
 						//ComRowHideDelete(sheetObject1,"del_chk");
 						sheetObject1.RowHidden(sheetObject1.SelectRow)= true;
 						sheetObject1.RowStatus(sheetObject1.SelectRow)= "D";
 					}
 					break;
 					
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 					break;
 					
 				case "btn_Save":
 					if(ComIsBtnEnable("btn_Save")){
 						if(validateForm(sheetObject1)){
 							doActionIBSheet(sheetObject1, formObject, IBSAVE);
 						}
 					} 					 					
 					break;
 				
 				case "btn_Close":
 					window.close();
 					break; 					
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");     
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
      	var formObject = document.form;
        axon_event.addListenerFormat('keypress', 'obj_KeyPress',    formObject); //- 키보드 입력할때
    }

    /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
 		var sheetID = sheetObj.id;
 		switch(sheetID) { 					
 			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 162;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle1 = "||House B/L No.|SCAC|Piece";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,		cnt++ , dtHiddenStatus,		30,		daCenter,		false,		"ibflag");
					InitDataProperty(0, 	cnt++ , dtDummyCheck, 		40, 	daCenter,  		false, 		"del_chk");
					InitDataProperty(0,		cnt++ , dtData,				200,	daCenter,		false,		"usa_cstms_file_no",		false,		"",		dfNone,						0,		true,		true, 20);
					InitDataProperty(0,		cnt++ , dtData,				70,		daCenter,		false,		"scac_cd",					false,		"",		dfNone,						0,		true,		true, 4);
					InitDataProperty(0,		cnt++ , dtData,				50,		daRight,		false,		"pck_qty",					false,		"",		dfNullInteger,				0,		true,		true, 9);
					CountPosition = 0;
					
					InitDataValid(0,  "usa_cstms_file_no",		vtEngUpOther,	"1234567890");		// 영문대문자+숫자 입력
					InitDataValid(0,  "scac_cd",				vtEngUpOther,	"1234567890");   	// 영문대문자+숫자 입력
					
					ColHidden("del_chk") = true;
				}
				break;
 		}
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           	case IBSEARCH:      //조회
           		formObj.f_cmd.value = SEARCH;
           		var sXml = sheetObj.GetSearchXml("ESM_BKG_0744GS.do" , FormQueryString(formObj));
           		var arrXml = sXml.split("|$$|");
           		if (arrXml.length > 0){
					sheetObj.LoadSearchXml(arrXml[0]);
 				}        	 
           		formObj.hbl_ttl_knt.value = ComGetEtcData(sXml,"hbl_count");
           		break;

            case IBSAVE:        //저장
            	formObj.f_cmd.value = MULTI;
           		var params = FormQueryString(formObj)
           		params = params + "&" + sheetObj.GetSaveString(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0744GS.do", params);	
				sheetObj.LoadSaveXml(sXml);
				document.form.total_pieces.value = sheetObj.ComputeSum("|pck_qty|");
				break;
        }
    }

     /*
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj){
    	for (var i = sheetObj.RowCount ; i > 0 ; i-- ){
    		if(ComIsNull(sheetObj.CellValue(i, "usa_cstms_file_no"))){
    			sheetObj.RowDelete(i,false);    
    		}
//    		if(ComIsNull(sheetObj.CellValue(i, "pck_qty"))){
//    			sheetObj.CellValue2(i, "pck_qty") = "0";
//				ComShowCodeMessage("BKG00104","Piece");
//    			return false;
//    			sheetObj.RowDelete(i,false);    
//    		}
    	}    
    	
    	for(var i = 1 ; i < sheetObj.RowCount; i++){
    		for(var j = i + 1; j <= sheetObj.RowCount; j++){
    			if(sheetObj.CellValue(i, "usa_cstms_file_no")
    					== sheetObj.CellValue(j, "usa_cstms_file_no")){
    				ComShowCodeMessage("BKG00764", sheetObj.CellValue(i, "usa_cstms_file_no"));
    				return false;
    			}
    		}
    	}
    	return true;
    }   

    function sheet1_OnLoadFinish(sheetObj) {   
  		sheetObj.WaitImageVisible = false;   
  		var formObj = document.form;
        initControl();
        if(formObj.bdr_flg.value == "Y"&&formObj.ca_flg.value == "N"){
        	ComBtnDisable("btn_RowAdd");
        	ComBtnDisable("btn_Delete");
        	ComBtnDisable("btn_Save");
        }
        doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
  		sheetObj.WaitImageVisible = true;   
  	 }  
    
     /**
      * sheet1 OnClick후 이벤트 
      * @param {ibsheet} sheet 해당 시트   
      * @param {long} row 해당 셀의 Row Index
      * @param {long} col 해당 셀의 Column Index
      * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnClick(sheet , row, col, value) {  
    	for (var idx=sheet.HeaderRows; idx<=sheet.LastRow; idx++) {
      		sheet.CellValue(idx,"del_chk") = 0;
 	    } 		    	 
     	sheet.CellValue(row,"del_chk") = 1;     	
    }

     /**
      * OnSaveEnd 이벤트 발생시 호출되는 function <br>
      * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
      * @return 없음
      * @author 김병규
      * @version 2009.05.17
      */ 	
  	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
		document.form.total_pieces.value = sheetObj.ComputeSum("|pck_qty|"); 		
  		if (ErrMsg == "") {
 			ComBkgSaveCompleted();			
 		}
 	}     
      
    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * 1. House B/L No 항목 배경색 변경. <br>
     * 2. Piece 항목 합계값 출력.<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 김병규
     * @version 2009.05.17
     */ 	
	function sheet1_OnSearchEnd(sheetObj, ErrMSg){
		with(sheetObj){
			ColBackColor("usa_cstms_file_no") = RgbColor(204, 255, 253);
//			ColBackColor("pck_qty") = RgbColor(204, 255, 253);
			document.form.total_pieces.value = sheetObj.ComputeSum("|pck_qty|");
		}
	}

	/* 개발자 작업  끝 */