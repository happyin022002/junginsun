/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0581.js
*@FileTitle : OOP Code Match with Vessel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.19 최영희
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
     * @class esm_bkg_0581 : esm_bkg_0581 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0581() {
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
var prefix1="sheet1_";
var prefix2="sheet2_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

					case "btn_retrieve":
						 if (ComIsNull(formObject.crr_cd)&&ComIsNull(formObject.vsl_cd)&&ComIsNull(formObject.vsl_eng_nm)){ 
							 ComShowCodeMessage("BKG00701");
						 }else{
							doActionIBSheet(sheetObject,document.form,IBSEARCH);
						 }
                    break;

					case "btn_new":
						doActionIBSheet(sheetObject,document.form,COMMAND01);
                    break;

					case "btn_save":
						doActionIBSheet(sheetObject,document.form,MULTI01);
                    break;

					case "btn_rowAdd":
						doActionIBSheet(sheetObject1,document.form,COMMAND02);
                    break;

					case "btn_delete":
						doActionIBSheet(sheetObject1,document.form,REMOVE);
                    break;
					
					case "btn_save2":
						for(i=0;i<sheetObject1.Rows;i++){
							if (ComIsNull(sheetObject1.CellValue(i,prefix2+"op_cd"))){
								ComShowCodeMessage("BKG00155");
								return;
							}
					    }
						doActionIBSheet(sheetObject1,document.form,MULTI02);
                    break;

					case "btn_carrier_cd":		
						var param="?crr_cd="+formObject.crr_cd.value;   
					    param+="&pgmNo=COM_ENS_0N1";
						ComOpenPopup('/hanjin/COM_ENS_0N1.do' + param, 420, 450, 'getCOM_ENS_0N1_1', '1,0,1,1,1', true);
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

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
             
         // doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
		axon_event.addListenerFormat('keypress','bkg0581_keypress',document.form); 
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
                    style.height = 340;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 14, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle1 = "|Vessel|Full Name|OOP1|OOP2|OOP3";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix1+"ibflag");
						InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	false,		prefix1+"vsl_cd",				false,			"",      dfNone,			0,		false,		true, 4);
						InitDataProperty(0, cnt++ , dtData,					220,		daCenter,	false,		prefix1+"vsl_eng_nm",				false,			"",      dfNone,			0,		false,		true, 50);
						InitDataProperty(0, cnt++ , dtData,					85,		daCenter,	false,		prefix1+"oop1",				false,			"",      dfEngUpKey,			0,		true,		true, 2);
						InitDataProperty(0, cnt++ , dtData,					65,		daCenter,	false,		prefix1+"oop2",				false,			"",      dfEngUpKey,			0,		true,		true, 2);
						InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		prefix1+"oop3",				false,			"",      dfEngUpKey,			0,		true,		true, 2);
					
					EditEnterBehavior = "tab";
				}
				break;
				
			case 2:      //sheet1 init
				with (sheetObj) {

                    // 높이 설정
                    style.height = 340;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 14, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle1 = "|Sel.|OOP|Name ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix2+"ibflag");
						InitDataProperty(0, cnt++ , dtCheckBox,					30,		daCenter,			false,		prefix2+"del_chk",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,					130,		daCenter,			false,		prefix2+"op_cd",				false,			"",      dfEngUpKey,			0,		true,		true, 2);
						InitDataProperty(0, cnt++ , dtData,					110,		daCenter,			false,		prefix2+"op_nm",		false,			"",      dfEngUpKey,			0,		true,		true, 500);


				}
				break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
		var arrPreFix = new Array("sheet1_","sheet2_");
        sheetObj.ShowDebugMsg = false; 
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction))
 					formObj.f_cmd.value = SEARCH; 
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0581GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
					var arrXml = sXml.split("|$$|");
					
					for(var i = 0; i < arrXml.length; i++){ 
						sheetObjects[i].Redraw = false;    
						if(i > 0) {
							sheetObjects[i].WaitImageVisible = false;	
						}  
						sheetObjects[i].LoadSearchXml(arrXml[i]); 
						sheetObjects[i].Redraw = true; 
					}
                break;

			case MULTI01:        //sheet1 저장
          	  //if(getGridDataExistCheck(sheetObjects[0],sheetObjects[1])){
                formObj.f_cmd.value = MULTI01; 
				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return; 
				sParam += "&" + FormQueryString(formObj);
				var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0581GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
			  //}
                break;

			case MULTI02:        //sheet2저장
          	  if(validateForm(sheetObj,formObj,sAction)){
                formObj.f_cmd.value = MULTI02; 
				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return; 
				sParam += "&" + FormQueryString(formObj);
				var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_0581GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
			  }
                break;

			case COMMAND01:      // 초기화
			    ComClearObject(formObj.crr_cd);
				ComClearObject(formObj.vsl_cd);
				ComClearObject(formObj.vsl_eng_nm);
			    sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
                break;

			case COMMAND02:      // sheet2입력
			     sheetObj.DataInsert();
                break;

			case REMOVE:      // sheet1삭제
			   ComRowHideDelete(sheetObj,prefix2+"del_chk");
                break;
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }

	/*
	* Carrier 코드값을 가져오는 공통팝업
	*/
	 function getCOM_ENS_0N1_1(rowArray){

		var formObject = document.form;
		var colArray = rowArray[0]; 
 		formObject.crr_cd.value = colArray[3] 
		
    }
	
	/*
	* Sheet1에 입력하는 그리드값이 Sheet2에 존재하는지 체크함수
	*/
	function getGridDataExistCheck(sheetObj,sheetObj1){
		for (var i=0;i<sheetObj1.Rows ; i++)
		{
			if(sheetObj.CellValue(sheetObj.SelectRow,sheetObj.SelectCol) == sheetObj1.CellValue(i+1,"op_cd"))
			{
				return true;
			} 
			return false;
		}

    } 
	
	/*
	 * KeyPress Event 처리
	 */
    function bkg0581_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat; 
	    switch(obj.dataformat){
			 case "engup": 
				 ComKeyOnlyAlphabet('uppernum');
	            break; 
	    }
	}
	
    /*
	* OnAfterEdit Event 처리
	*/
	function sheet1_OnAfterEdit(sheetObj,Row,Col){
		if (!ComIsNull(sheetObj.CellValue(Row,Col))){
			var bFlag=false;
			for(i=0;i<sheetObjects[1].Rows;i++){
				if (sheetObj.CellValue(Row,Col)==sheetObjects[1].CellValue(i,prefix2+"op_cd")){
					bFlag=true;
					break;
				}
			}
			if (!bFlag){
				ComShowCodeMessage("BKG00105"); 
				sheetObj.CellValue(Row,Col)="";
				return;
			}
			
			if(sheetObj.ColSaveName(Col)==prefix1+"oop1"){
				if (sheetObj.CellValue(Row,prefix1+"oop1")==sheetObj.CellValue(Row,prefix1+"oop2")
					|| sheetObj.CellValue(Row,prefix1+"oop1")==sheetObj.CellValue(Row,prefix1+"oop3")){
					ComShowCodeMessage("BKG00488");
					sheetObj.CellValue(Row,Col)="";
				}
			}else if(sheetObj.ColSaveName(Col)==prefix1+"oop2"){
				if (sheetObj.CellValue(Row,prefix1+"oop2")==sheetObj.CellValue(Row,prefix1+"oop1")
					|| sheetObj.CellValue(Row,prefix1+"oop2")==sheetObj.CellValue(Row,prefix1+"oop3")){
					ComShowCodeMessage("BKG00488");
					sheetObj.CellValue(Row,Col)="";
				}
			}else if(sheetObj.ColSaveName(Col)==prefix1+"oop3"){
				if (sheetObj.CellValue(Row,prefix1+"oop3")==sheetObj.CellValue(Row,prefix1+"oop1")
					|| sheetObj.CellValue(Row,prefix1+"oop3")==sheetObj.CellValue(Row,prefix1+"oop2")){
					ComShowCodeMessage("BKG00488");
					sheetObj.CellValue(Row,Col)="";
				}
			} 
		}
	}

	/* 개발자 작업  끝 */