/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_360.js
*@FileTitle : Marks And Description by NVO H/BL
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.07.22 김영출
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
     * @class ESM_BKG_360 : ESM_BKG_360 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0360() {
    	this.processButtonClick		= processButtonClick;
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
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var callback_func = '';
	
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

    		if(srcName != "btn_splitPop"){
        		if(layList.style.display != "none"){
        			layList.style.display = "none";
        		}    	    			
    		}
			
            switch(srcName) {
				case "btn_splitPop":			
					doActionIBSheet(sheetObject1,formObject,COMMAND04);					
				break;
				
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;  
					
				//case "btn_selectall":
				//	var rCnt = sheetObject1.RowCount +1;
				//	for(ir=1;ir<rCnt;ir++){
				//		sheetObject1.CellValue2(ir, "sel") = 1;
				//	}
				//break; 					

				case "btn_copy":
					//var cntr_mf_gds_desc = '';
					var bl_mk_desc = '';
					var bl_cmdt_desc = '';

					var arrRow = ComFindText(sheetObject1, "sel", "1");
					if(arrRow.length == 0){
						ComShowMessage(ComGetMsg("BKG40076"));
						return;						
					}else{
						for (idx=0; idx<arrRow.length; idx++){
							//cntr_mf_gds_desc += sheetObject1.CellValue(arrRow[idx], "cntr_mf_gds_desc");
							bl_mk_desc += sheetObject1.CellValue(arrRow[idx], "bl_mk_desc");
							bl_cmdt_desc += sheetObject1.CellValue(arrRow[idx], "bl_gds_desc");
						}
					}
					
					//alert("\n" + cntr_mf_gds_desc + "\n" + bl_mk_desc + "\n" + bl_cmdt_desc);
					if(!opener) opener = window.dialogArguments; 
					if(callback_func != ''){
						eval('opener.'+callback_func)(bl_mk_desc, bl_cmdt_desc);
					}	
				//break; 					

				case "btn_close":
					window.close();
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			//initSheet
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//iframe 생성 
    	CofigIframe();

		//
		if(document.form.bkg_no.value != ''){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		
        //add listener
		axon_event.addListenerForm('focus', 'form1_focus', document.form);
        axon_event.addListenerForm('blur', 'form1_blur', document.form);
        axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
        axon_event.addListenerForm('change', 'form1_change', document.form);
    }



  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
     function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 215;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel.|Seq.|Bkg No|CntrMf|BlMk|BlGds";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,  0,    daCenter,  false,  "ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,  40,   daCenter,    false,     "sel");
					InitDataProperty(0, cnt++, dtData,        30,   daCenter,    false,     "hbl_seq");
					InitDataProperty(0, cnt++, dtHidden,      30,   daCenter,    false,     "bkg_no");
					InitDataProperty(0, cnt++, dtHidden,      30,   daCenter,    false,     "cntr_mf_gds_desc",  false,    "",      dfNone, 		0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,      30,   daCenter,    false,     "bl_mk_desc",    		 false,    "",      dfNone, 		0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,      30,   daCenter,    false,     "bl_gds_desc",    		 false,    "",      dfNone, 		0,     false,       true);

					CountPosition = 0;
               }
        	break;

        }
    }
	
	/**
	* Sheet관련 프로세스 처리
	*/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_BKG_0360GS.do", FormQueryString(formObj));
					if(sheetObj.TotalRows > 0){
						formObj.cntr_mf_gds_desc.value = sheetObj.CellValue(1, "cntr_mf_gds_desc");
						formObj.bl_mk_desc.value =  sheetObj.CellValue(1, "bl_mk_desc");
						formObj.bl_gds_desc.value =  sheetObj.CellValue(1, "bl_gds_desc");
					}
				}
			break;
			
			case COMMAND04:      //booking split no조회 
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.WaitImageVisible = false;
					ComSetObjValue(formObj.f_cmd, COMMAND03);
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
					var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
					bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 30); 
					sheetObj.WaitImageVisible = true;
				}else{
					return false;
				}					
			break;			
        }
    }
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
			
			case IBSEARCH:      //조회
				if(formObj.bkg_no.value == '') {
					ComShowMessage(ComGetMsg("BKG00888", "bkg_no"));
					formObj.bkg_no.focus();
					return false;
				}
			break;
			
			case COMMAND04: 
				with (formObj) {
					if(ComIsEmpty(bkg_no.value)){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.focus();
						return false;
					}
				}
			break;			
        }		
        return true;
    }
	
	/* ---------------------------------------------------------------------------------------
	 * 이벤트 처리
	 ----------------------------------------------------------------------------------------- */
	function form1_focus(){

	}
	
    function form1_blur(){

    }

	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			//ComKeyEnter("search");
		}
		switch(event.srcElement.dataformat){
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ym":
			case "yw":
			case "jumin":
			case "saupja":	//숫자 + "-"
				ComKeyOnlyNumber(event.srcElement, "-"); 
			break;
			case "hms":
			case "hm":		//숫자 + ":"
				ComKeyOnlyNumber(event.srcElement, ":"); 
			break;
			case "int":		//숫자
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "float":	//숫자+"."	            
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;	    
			case "engup":
				//영문대문자
				ComKeyOnlyAlphabet("upper");
			break;
			case "engupnum":
				//숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet("uppernum");
			break;
			case "engupnumspc":
				//영문대문자 + 숫자 + 스페이스
				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
				var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
				if(keyValue >= 97 && keyValue <= 122){                  //소문자
                	event.keyCode = keyValue + 65 - 97;
				}
				//event.returnValue = true;
			break;
		}			
	}
	
    function form1_change(){
		/* 대문자 */
		//if(event.srcElement.type =="text") {
		//	event.srcElement.value = event.srcElement.value.toUpperCase();
		//}
		/* 데이터 변경 여부 체크 */
		//document.form.dirty_flag.value = 'Y'
		
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        switch(srcName){
            case "cntr_mf_gds_desc":
				sheetObj.CellValue2(sheetObj.SelectRow, "cntr_mf_gds_desc") = formObj.cntr_mf_gds_desc.value;
            break;
            case "bl_mk_desc":
				sheetObj.CellValue2(sheetObj.SelectRow, "bl_mk_desc") = formObj.bl_mk_desc.value;
            break;
            case "bl_gds_desc":
				sheetObj.CellValue2(sheetObj.SelectRow, "bl_gds_desc") = formObj.bl_gds_desc.value;
            break;
        }
    }
	
	function sheet1_OnClick(sheetObj, row, col, val) {
		var formObj = document.form;
	    var col_save_name = sheetObj.ColSaveName(col);
		if (col_save_name == "hbl_seq") {
			formObj.cntr_mf_gds_desc.value = sheetObj.CellValue(row, "cntr_mf_gds_desc");
			formObj.bl_mk_desc.value =  sheetObj.CellValue(row, "bl_mk_desc");
			formObj.bl_gds_desc.value =  sheetObj.CellValue(row, "bl_gds_desc");
		}
	 }
	 
	//
	function bkgSplitNoList(split_list){
		document.form.bkg_no.value = split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}

	/* 개발자 작업  끝 */