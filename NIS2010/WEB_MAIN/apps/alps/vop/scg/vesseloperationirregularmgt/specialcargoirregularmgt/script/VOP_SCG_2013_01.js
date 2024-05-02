/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_2013_01.js
*@FileTitle : Supporting Documents or Pictures
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.08 김현욱
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
     * @class vop_scg_2013_01 : vop_scg_2013_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_2013_01() {
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


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObj = sheetObjects[0];
         
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

	            case "btn_FileAdd":  
					selectFile(sheetObj, true);
					break;
					
	            case "btn_Delete":
	            	setDelRow(sheetObj);
					break;					
			
				case "btn_OK":
					comPopupOK();
					break;
					
				case "btn_Close":
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
     * 선택한 행 삭제 처리
     */
    function setDelRow(sheetObj){
    	
    	sheetObj.RowHidden(sheetObj.SelectRow)= true;		//1.행 숨기기
		sheetObj.RowStatus(sheetObj.SelectRow)= "D";		//2.트랜잭션 상태 "삭제"로 만들기

    }
    
    /**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} addRowFlag  sheetObj에 Row추가 여부
     **/
	function selectFile(sheetObj, addRowFlag){
		if(addRowFlag) sheetObj.DataInsert(-1,0);						//File Add인 경우 New Row 생성
		
		var fileName = sheetObj.OpenFileDialog('Please choose target file to upload.');
		
		if(fileName.indexOf("\\") !=-1) {
			with(sheetObj) {
				CellValue2(SelectRow, "file_sav_id") = fileName;		//파일 경로 설정
				CellValue2(SelectRow, "file_set_yn") = "Y";				//로컬파일 선택여부 설정
	
				fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
				CellValue2(SelectRow, "file_nm")= fileName;				//파일명 설정
				
				CellFontUnderline(SelectRow, "file_nm") = false;		//다운로드 링크 해제
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
    function loadPage(file_pop_kind) {
    	//팝업 종류에 따라 수정모드 & 단순조회모드
        if(file_pop_kind != null && file_pop_kind == 'readOnly') 
        	document.getElementById("btnLayer").style.visibility = "hidden";

        for(i=0;i<sheetObjects.length;i++){

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

        }
        
        var sheetObj = sheetObjects[0];
        
        var opener = window.dialogArguments;
        
        //부모창에 수정중인 파일정보가 있을 경우 기존 정보를 유지하게끔 처리한다.
        if(opener != undefined && opener != null) {
        	var oSheetObj = opener.getFileUpload();
        	if(oSheetObj != undefined && oSheetObj != null) {
        		if(oSheetObj.RowCount > 0) {
        			var sXml = IBS_GetDataSearchXml(oSheetObj);
        			sheetObj.LoadSearchXml(sXml);
	        		for(var rowIdx=sheetObj.HeaderRows; rowIdx<=sheetObj.LastRow; rowIdx++) {
	        			if(sheetObj.RowStatus(rowIdx) == 'D') sheetObj.RowHidden(rowIdx) =  true;
	        			if(sheetObj.RowStatus(rowIdx) == 'I') sheetObj.CellFont("FontUnderline", rowIdx,3) = false;
	        		}
        		} else {
        			//페이지로딩시 초기 조회
        			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        		}
        	}
        }
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 100;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Seq.||File Name||ID|Date|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	false,	"No");
					InitDataProperty(0, cnt++ , dtHidden,       0,      daCenter,   true,   "file_set_yn",	  true,     "",     dfNone,         0,     		true,    	true);
					InitDataProperty(0, cnt++ , dtData,			300,	daCenter,	false,	"file_nm",		  false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	    daCenter,	false,	"file_sav_id",    false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,	"cre_usr_id",	  false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"cre_dt",		  false,	"",		dfDateYmd,		0,			true,		true);

					InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,	"spcl_cgo_irr_file_seq");
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
        		sheetObj.DoSearch("VOP_SCG_2013_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
        		break;
        }
    }
    
    /**
     * Sheet 조회완료 후 이벤트 발생
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			ColFontUnderline("file_nm") = true;
			DataLinkMouse("file_nm") = true;
		}
	}
    
    /**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet1_OnDblClick(sheetObj,Row,Col,Value){		
		if (sheetObj.ColSaveName(Col) != "file_nm") 
			return;
		
		//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
		if(sheetObj.CellText(Row, "file_nm") == "" 
			|| sheetObj.RowStatus(Row) == "I" 
			|| sheetObj.CellValue(Row, "file_set_yn") == "Y") {			
			selectFile(sheetObj, false);			
			return;
		}
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, "file_sav_id");
		
		return;
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }

        return true;
    }

	/* 개발자 작업  끝 */