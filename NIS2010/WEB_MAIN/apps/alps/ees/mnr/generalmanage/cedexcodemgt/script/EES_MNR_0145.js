/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_mnr_0145.js
*@FileTitle : EQ Component Code Grouping by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.11 김완규
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.09.14 김상수 [CHM-201006047-01] ALPS MNR-> Code 조회 권한 조정 건
*                   (사용자 Office코드가 본사(장비팀)일때만 저장가능하도록 수정)
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
     * @class ess_mnr_0145 : ess_mnr_0145 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0145() {
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
/* ********* General Functions ************* */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */	
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

						case "btn_Save":
								doActionIBSheet(sheetObject1,formObject,IBSAVE);
								break;

						case "btn_Close":
								window.close();
								break;

            }
    	}catch(e) {
    		if( e == "[object Error]") {
				ComFuncErrMsg(e); 
    		} else {
				ComFuncErrMsg(e); 
    		}
    	}
    }

	/** 
	 * IBSheet Object를 배열로 등록
	 * @param    {IBSheet}	sheet_obj	배열로 등록될 IBSheet Object
	 */	
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }
	/****************************************************************************************
	 * 2010.09.14 이석준 [ ] 본사이외의 office가 들어올때 Save Button Disable처리
	 ****************************************************************************************/
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//버튼 설정
    	MnrWaitControl(true);

        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i + 1);

            ComEndConfigSheet(sheetObjects[i]);
        }
			
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		MnrWaitControl(false);
		setSaveBtnDisplay();
    }


  	/**
     * 시트 초기설정값, 헤더 정의
     * @param	{IBSheet}	sheetObj	초기설정될 시트오브젝트 
     * @param	{String}	sheetNo		시트오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;

        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 282;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Seq|Grp|Code|Description";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 4, 0, 0, true);
							
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성       [ROW, COL,    DATATYPE,    WIDTH,    DATAALIGN, COLMERGE, SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,	"S");
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	true,	"g",					false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"code",					false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"description",			false,	"",	dfNone,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"eq_cedex_rlt_tp_cd",	false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"fm_rlt_cd",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"to_rlt_cd",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"eq_cmpo_cd",			false,	"",	dfNone,	0,	true,	true);

					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   

					CountPosition = 0;
				}
	         	break;
	         		
            case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 282;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Seq|Grp|Code|Description";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,	"S");
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	true,	"g",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"code",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"description",	false,	"",	dfNone,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"eq_cedex_rlt_tp_cd",	false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"fm_rlt_cd",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"to_rlt_cd",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"eq_cmpo_cd",			false,	"",	dfNone,	0,	true,	true);

					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   

					CountPosition = 0;
				}
         		break;
			 case "sheet3":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 282;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;		

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Seq|Grp|Code|Description";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,	"S");
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	true,	"g",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"code",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"description",	false,	"",	dfNone,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"eq_cedex_rlt_tp_cd",	false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"fm_rlt_cd",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"to_rlt_cd",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"eq_cmpo_cd",			false,	"",	dfNone,	0,	true,	true);

					//SELECT 로우 배경색	       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;	            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   

					CountPosition = 0;
				}
         		break;	

        }
    }

  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH02;
				if(validateForm(sheetObj,formObj,sAction)) {
					//다중조회
					var sXml = sheetObj.GetSearchXml("EES_MNR_0145GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					for(var i = 0; i < arrXml.length; i++){ 
						sheetObjects[i].LoadSearchXml(arrXml[i]); 
					}
				}
				break;
	
			case IBSAVE:        //저장
			    formObj.f_cmd.value = MULTI01;
                if(validateForm(sheetObj,formObj,sAction)) {
					var sParam = ComGetSaveString(sheetObjects);
				    if (sParam == "") return;	
				    sParam += "&" + FormQueryString(formObj);
				    var sXml = sheetObjects[0].GetSaveXml("EES_MNR_0145GS.do", sParam);
				    sheetObjects[0].LoadSaveXml(sXml);     
				    sheetObjects[1].LoadSaveXml(sXml);
					sheetObjects[2].LoadSaveXml(sXml);
				}
				break;
        }
    }

  	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSAVE) {
			}
        }
        return true;
    }

/* ********* Event Functions ************* */
	/** 
	 * 저장후 결과메세지 표시
	 * @param	{IBSheet}	sheetObj	저장이벤트의 시트 오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") { 
			ComShowCodeMessage("MNR00023",'');   
		} else { 
			ComShowCodeMessage("MNR00008",ErrMsg);  
		}       
	}     
	/****************************************************************************************
	 * 2010.09.14 이석준 [ ] 본사이외의 office가 들어올때 Save Button Disable처리
	 ****************************************************************************************/
	/**
	 * 저장버튼 Display 설정
	 * 로그인한 OFFICE 의 LEVEL 이  L1 일 때만 Display 시키고 
	 * 나머지는  Disalbe 시킨다. 
	 * @return
	 */
	function setSaveBtnDisplay() {
		if(strMnrOfficeLevel=="L1") {
			ComBtnEnable("btn_Save");
		} else {
			ComBtnDisable("btn_Save");
		}
	}
	
/* 개발자 작업  끝 */