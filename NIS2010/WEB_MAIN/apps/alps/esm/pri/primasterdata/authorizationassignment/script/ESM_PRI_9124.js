
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_9124.js
*@FileTitle : Pricing File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.18 
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
     * @extends Pri
     * @class ESM_PRI_9124 : ESM_PRI_9124 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_9124 () {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.validateForm = validateForm;
    }

    /* 개발자 작업   */


    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var uploadObjects = new Array();
	var uploadCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.08.17
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

 
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_rowAdd":
            		var row = sheetObjects[0].DataInsert(-1);
            		
            		break;
            	
            	case "btn_upload":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                    break;

            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수, IBSheet Object
     * @return 없음
     * @author 문동규
     * @version 2009.08.17
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.08.17
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
                // khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                // khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
          //UPLOAD 환경 설정
            for(var i=0;i<uploadObjects.length;i++){
    		    //1. 기본 환경 설정
    		    ComConfigUpload(uploadObjects[i], "/hanjin/ESM_PRI_9124GS.do");
    		}
    
            var formObj = document.form;
            
            sheetObjects[0].DataInsert(-1);
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }
    
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수, IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 송민석
     * @version 2011.08.08
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
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

                    var HeadTitle = "|Sel|File Upload|File Path";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,  true,	"ibflag");
    				InitDataProperty(0, cnt++ , dtDelCheck,     40,    	daCenter,  false,   "DelChk");
    				InitDataProperty(0, cnt++ , dtPopup,      	319,    daLeft,    false,   "file_nm",     	true,           "",      dfNone,      0,     false,		true,	50);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   "file_path",   	false,          "",      dfNone,      0,     true,      true);
                    
                    DataLinkMouse("file_nm") = true;
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";

    				ShowButtonImage = 1;
                }
                break;
             
        }
    }
 

    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {form} formObj 필수, html form object
     * @param {int} sAction 필수, 프로세스 플래그 상수
     * @return 없음
     * @author 송민석
     * @version 2011.08.08
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSAVE:
                ComOpenWait(true);
                if (validateForm(sheetObj,formObj,sAction)) {
                	formObj.f_cmd.value = MULTI;
                	
                	//1.IBUpload에 파일 추가하기
                	var upObj = uploadObjects[0];
                	
                	upObj.Files = "";	//-먼저기존파일을 모두 지운후 추가함
                	
                	var paramFile = setFileUpload(sheetObj);
                	
                	if (upObj.LocalFiles != "") {
                		//2.IBSheet 데이터 QueryString으로 묶기
                		var arrSheets = new Array(sheetObj);
                		var sParam = ComGetSaveString(arrSheets, true);
                		
                		if (sParam == "") return;
                		
                		//3.Form 데이터 QueryString으로 묶기
                		var aryPrefix = new Array("");
                		sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
                		sParam += "&" + paramFile;
                		
                		//4. 서버에 request전달하고, reponse 받기
                		upObj.ExtendParam = sParam;
                		
                		upObj.ParamDecoding = true;
                		
                		var sXml = upObj.DoUpload(true);
                		
                		ComResetAll();
     			   }
                }
                ComOpenWait(false);
                break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {form} formObj 필수, html form object
     * @param {int} sAction 필수, 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author  송민석
     * @version 2011.08.08
     */
    function validateForm(sheetObj,formObj,sAction){

        switch(sAction){

//            case IBSAVE:
//                break;
        }

        return true;
    }
    
    /**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		var fileName = sheetObj.OpenFileDialog(ComGetMsg('FMS01074'));
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, "file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
	}
	
    /**
     * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	변수 구분값
     **/
	function setFileUpload(sheetObj) {
		//트랜잭션 상태가 "입력"인 행을 찾아 온다.
		var sRow = sheetObj.FindStatusRow("I");
		var upObj = uploadObjects[0];
		var arrRow = sRow.split(";");
		
		for (idx=0; idx<arrRow.length-1; idx++){ 
			var row = arrRow[idx];
			
			//파일 경로 가져오기
			var sFile = sheetObj.CellValue(row,"file_path");		
			if (sFile=="") ComShowMessage(ComGetMsg('PRI00359'));
			
			//IBUpload에 파일 추가하기
			var ret = upObj.AddFile(sFile);
		}
		
		var param = "file_cnt=" + (arrRow.length-1); 

		return param; 
	}
   
    /* 개발자 작업  끝 */