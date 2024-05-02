/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1025.js
*@FileTitle : Booking split_TRO/O Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.16 최영희
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
     * @class esm_bkg_1025 : esm_bkg_1025 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1025() {
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
var sheetObjects = new Array();
var sheetCnt = 0;
var prefix1="sheet1_";
var strSheetTitle=" |TRO Seq.|Sub. Seq.|TP/SZ|Haulage|Door"; 
var chkCntrValidate="";
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
				 
				case "btn_ok":
					callParentTroSplitFunc(sheetObjects[0],prefix1+"tro_seq",prefix1+"tro_sub_seq",ComGetObjValue(formObject.bkg_no),ComGetObjValue(formObject.bkgsplitno),ComGetObjValue(formObject.splitReason),strSheetTitle);
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
			strSheetTitle=" |TRO Seq.|Sub. Seq.|TP/SZ|Haulage|Door|"+ComGetObjValue(document.form.bkg_no).substring(10,12);
		}else{
			strSheetTitle=" |TRO Seq.|Sub. Seq.|TP/SZ|Haulage|Door|"+ComGetObjValue(document.form.orgSplit);
		}
		
		strSheetTitle=SheetSetHeader(ComGetObjValue(document.form.splitReason),ComParseInt(document.form.lastSplitNo),ComGetObjValue(document.form.splitCnt),strSheetTitle);
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }	
		sheetObjects[0].ExtendLastCol = false;
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		//sheetObjects[0].CheckAll(prefix1+ComGetObjValue(document.form.orgSplit))=1;
	 
		//if(ComParseInt(document.form.splitCnt.value)>0){
		//	setSplitNo(sheetObjects[0],document.form.splitCntrSplitNo.value,strSheetTitle,prefix1,prefix1+"tro_seq");
		//	chkCntrValidate= CheckCntrSplit(document.form.validateSplitNo.value);
		//}
		 
    }

	/*
	* Sheet 화면 깜박거리 없애는 처리
	*/
	function sheet1_OnLoadFinish(sheetObj) {   
		sheetObj.WaitImageVisible = false;  
		doActionIBSheet(sheetObj,document.form,IBSEARCH);   
		sheetObj.WaitImageVisible = true;   
	} 


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 102;
                    
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

					//var HeadTitle1 = "|TRO Seq.|Sub. Seq.|TP/SZ|Haulage|Door||A1|B1";
					var HeadTitle1 = strSheetTitle;
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 8, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, false, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		prefix1+"ibflag");
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix1+"tro_seq",			false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix1+"tro_sub_seq",		false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix1+"cntr_tpsz_cd",		false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix1+"hualage",			false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix1+"door",				false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	false,		prefix1+ComGetObjValue(document.form.orgSplit),				false,		"",      dfNone,	0,		true,	true);
					
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
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1025GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
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

	function callParentTroSplitFunc(sheetObj,prefix,key,bkgno,bkgsplitno,splitReason,strSheetTitle) { 
		var rArray = null; //행데이터를 담고 있는 배열
		var idx=0;
		var ichk=0;
		var tmpbkgno="";
		rArray = new Array();
		for(var iRow=0;iRow<sheetObj.Rows;iRow++){
			ichk=0;
			for(var iCol=0;iCol<sheetObj.LastCol+1;iCol++){
				if(typeof(sheetObj.CellValue(iRow,iCol).length) =="undefined"){
					var str = sheetObj.ColSaveName(iCol).split("_");
					if (splitReason=="C"){
					 if(ichk==0){							
						ichk++;
						//tmpbkgno=bkgno;
						var strTmp = strSheetTitle.split("|");
						str=["",strTmp[iCol]];
						 tmpbkgno=bkgsplitno.substring(0,10)+str[1];
					 }else{
						tmpbkgno=bkgsplitno.substring(0,10)+str[1];
					 }
					}else{
						tmpbkgno=bkgsplitno.substring(0,10)+str[1];
					}

					 if(sheetObj.CellValue(iRow,iCol)==1){
						 rArray[idx]= sheetObj.CellValue(iRow,prefix)+":"+sheetObj.CellValue(iRow,key)+":"+str[1]+":"+tmpbkgno;
					 }else{
						 rArray[idx]= sheetObj.CellValue(iRow,prefix)+":"+sheetObj.CellValue(iRow,key)+"::"+tmpbkgno;
					 }
					 idx++;
				 }
			}
		}
		
		// 모달창인 경우는 window 객체로부터 opener를 획득
		if(!opener)
			opener = window.dialogArguments; 
		try {
				opener.getSplitTro(rArray);
				window.close();
		}
		catch(e) {
		 	ComShowCodeMessage("COM12111");
		}
	} 

	/* 개발자 작업  끝 */