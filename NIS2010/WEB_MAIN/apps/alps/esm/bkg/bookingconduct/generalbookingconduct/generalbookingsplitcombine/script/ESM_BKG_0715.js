/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0715.js
*@FileTitle : AK Application Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.16 최영희
* 1.0 Creation
*-------------------------------------------------------
* HISTORY
* 2012.10.22 조정민 [CHM-201220706] Special Appliatoin Split시 호출방식 변경
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
     * @class esm_bkg_0715 : esm_bkg_0715 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0715() {
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
var strSheetTitle=" |Container Seq & No|Container Seq & No|Commodity|Length|Width|Height|Weight"; 
var chkCntrValidate="";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
					
				case "btn_new":
					if (ComGetObjValue(document.form.cntrExists)=="Y" && ComGetObjValue(document.form.cntrPopExists)=="N"){
							restoreCheck(sheetObject,strSheetTitle,prefix1,prefix1+"cntr_no",ComGetObjValue(document.form.cntrPopExists));
						}else{
							restoreCheck(sheetObject,strSheetTitle,prefix1,prefix1+"awk_cgo_seq",ComGetObjValue(document.form.cntrPopExists));
						}
					 
					break;
					
				case "btn_save":
					callParentSplitFunc(sheetObjects[0],"A",prefix1+"cntr_no",prefix1+"awk_cgo_seq",ComGetObjValue(formObject.bkg_no),ComGetObjValue(formObject.bkgsplitno),ComGetObjValue(formObject.splitReason),strSheetTitle,ComGetObjValue(formObject.cntrPopExists));
					break;
									
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
		if(ComGetObjValue(document.form.splitReason)=="C" && ComGetObjValue(document.form.bkg_no).length==12){
			strSheetTitle="|Container Seq & No|Container Seq & No|Commodity|Length|Width|Height|Weight|"+ComGetObjValue(document.form.bkg_no).substring(10,12);
		}else{
			strSheetTitle="|Container Seq & No|Container Seq & No|Commodity|Length|Width|Height|Weight|"+ComGetObjValue(document.form.orgSplit);
		}
		
		
		strSheetTitle=SheetSetHeader(ComGetObjValue(document.form.splitReason),ComParseInt(document.form.lastSplitNo),ComGetObjValue(document.form.splitCnt),strSheetTitle);
		 
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		sheetObjects[0].ExtendLastCol = false;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		//sheetObjects[0].CheckAll(prefix1+ComGetObjValue(document.form.orgSplit))=1;
		/*if(ComParseInt(document.form.splitCnt.value)>0){
			if (ComGetObjValue(document.form.cntrExists)=="Y"){
				setSplitNo(sheetObjects[0],document.form.splitCntrSplitNo.value,strSheetTitle,prefix1,prefix1+"cntr_no");
			}else{
				setSplitNo(sheetObjects[0],document.form.splitCntrSplitNo.value,strSheetTitle,prefix1,prefix1+"awk_cgo_seq");
			}
			chkCntrValidate= CheckCntrSplit(document.form.validateSplitNo.value);
		}*/
    }

	/*
	* Sheet 화면 깜박거리 없애는 처리
	*/
	function sheet1_OnSearchEnd(ErrMsg) {   
//		sheetObj.WaitImageVisible = false;  
//		doActionIBSheet(sheetObj,document.form,IBSEARCH);   
//		sheetObj.WaitImageVisible = true;   
		if(ComParseInt(document.form.splitCnt.value)>0){
			if (ComGetObjValue(document.form.cntrExists)=="Y" && ComGetObjValue(document.form.cntrPopExists)=="N"){
				setSplitNo(sheetObjects[0],document.form.splitCntrSplitNo.value,strSheetTitle,prefix1,prefix1+"cntr_no");
			}else{
				setSplitNo(sheetObjects[0],document.form.splitCntrSplitNo.value,strSheetTitle,prefix1,prefix1+"awk_cgo_seq");
			}
			chkCntrValidate= CheckCntrSplit(document.form.validateSplitNo.value);
		}
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
								style.height =202;
								//전체 너비 설정
								SheetWidth = mainTable.clientWidth;
								
								//Host정보 설정[필수][HostIp, Port, PagePath]
								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
								
								//전체Merge 종류 [선택, Default msNone]
								MergeSheet = msHeaderOnly;
								
								//전체Edit 허용 여부 [선택, Default false]
								Editable = true;
								
								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
								InitRowInfo(1, 1, 15, 100);
								
								// 해더에서 처리할 수 있는 각종 기능을 설정한다
								InitHeadMode(true, false, false, false, false,false);

								var HeadTitle1 =strSheetTitle;
								var headCount = ComCountHeadTitle(HeadTitle1);
                              
								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
								InitColumnInfo(headCount, 8, 0, true);
							 
								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
								InitHeadRow(0, HeadTitle1, true);
								
								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
								InitDataProperty(0,     cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix1+"ibflag");
								InitDataProperty(0,		cnt++ , dtData,			20,		daCenter,		false,		prefix1+"awk_cgo_seq",			false,		"",		dfNone,			0,		false,	false);
								InitDataProperty(0,		cnt++ , dtData,		   100,	    daCenter,		false,		prefix1+"cntr_no",			false,		"",		dfNone,			0,		false,	false);
								InitDataProperty(0,		cnt++ , dtData,			220,	daLeft,			false,		prefix1+"cmdt_nm",			false,		"",		dfNone,			0,		false,	true,		20);
								InitDataProperty(0,		cnt++ , dtData,			55,		daRight,		false,		prefix1+"ttl_dim_len",		false,		"",		dfNullInteger,	0,		false,	true,		4);
								InitDataProperty(0,		cnt++ , dtData,			55,		daRight,		false,		prefix1+"ttl_dim_wdt",		false,		"",		dfNullInteger,	0,		false,	true,		4);
								InitDataProperty(0,		cnt++ , dtData,			55,		daRight,		false,		prefix1+"ttl_dim_hgt",		false,		"",		dfNullInteger,	0,		false,	true,		4);
								InitDataProperty(0,		cnt++ , dtData,			65,		daRight,		false,		prefix1+"grs_wgt",			false,		"",		dfNullFloat,	3,		false,	true);
								
								InitDataProperty(0,		cnt++ , dtCheckBox,		30,		daCenter,		false,		prefix1+ComGetObjValue(document.form.orgSplit),				false,		"",		dfNone,			0,		true,	true);

								SheetSetInitCol(sheetObj,ComGetObjValue(document.form.splitReason),ComGetObjValue(document.form.splitCnt),ComParseInt(document.form.lastSplitNo),cnt,prefix1); 

								CountPosition = 0;
		
						}
						break;
			}
	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		var arrPreFix = new Array("sheet1_");
        switch(sAction) { 
          case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH; 
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0715GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
//				var sXml = sheetObj.GetSearchXml("ESM_BKG_0715GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
				sheetObj.Redraw = false; 
				sheetObj.LoadSearchXml(sXml); 
				sheetObj.Redraw = true;  
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
	* 그리드 Onchange 이벤트처리
	*/
	function sheet1_OnChange(sheetObj,Row,Col,Value){  
		 ComSetObjValue(document.form.cntrPopExists,"Y");
	} 
	/*
	* 그리드 OnBefore 이벤트처리
	*/  
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){
		if (!ComIsEmpty(sheetObj.CellValue(Row,prefix1+"cntr_no"))){
			if(!CheckCntrValidate(sheetObj,Col,sheetObj.CellValue(Row,prefix1+"cntr_no"),chkCntrValidate,prefix1)){
				sheetObj.CellValue2(Row,Col)=1;
			}
		}
	}
	
	 
 
	/* 개발자 작업  끝 */