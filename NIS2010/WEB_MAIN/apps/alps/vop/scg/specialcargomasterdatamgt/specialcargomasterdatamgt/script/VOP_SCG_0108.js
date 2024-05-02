/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VOP_SCG_0108.js
*@FileTitle : Image File Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.27
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2013.02.27 신자영
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
	 * @class VOP_SCG_0108 : VOP_SCG_0108 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function VOP_SCG_0108() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}
    
   	/* 개발자 작업	*/

	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
    var uploadObjects = new Array();
	var uploadCnt = 0;
	
    var userId = "";
    var stvDmgAtchFileTpCd = "";
    var prefix = "sheet1_";
    
    
	
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

     			case "btn_RowAdd":
					var row = sheetObject.DataInsert(-1);
					sheetObject.SelectCell(row, 2);
					break;
				
				case "btn_FileAdd":
					selectFile(sheetObject, formObject, true);
					break;
					
				case "btn_RowDelete":
					ComRowHideDelete(sheetObject, "del_chk");
					break;
					
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,document.form,IBSEARCH);
					break;
				
				case "btn_Save":
					doActionIBSheet(sheetObject,document.form,IBSAVE);
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
    * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
    * @param {ibupload} uploadObj    IBUpload Object
    **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
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
         }
    	 
    	 //UPLOAD 환경 설정
    	 for ( var i = 0; i < uploadObjects.length; i++) {
    		 //1. 기본 환경 설정
 			ComConfigUpload(uploadObjects[i], "/hanjin/VOP_SCG_0108GS.do");
    	 }
    	 uploadObjects[0].AutoConfirm = "UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";
    }

     function sheet1_OnLoadFinish(sheetObj) {
         //html컨트롤 이벤트초기화
         initControl();
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
    	 			style.height = 300;
    	 			//전체 너비 설정
    	 			SheetWidth = mainTable.clientWidth;

    	 			//Host정보 설정[필수][HostIp, Port, PagePath]
    	 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    	 			//전체Merge 종류 [선택, Default msNone]
    	 			MergeSheet = msNone;

    	 			//전체Edit 허용 여부 [선택, Default false]
    	 			Editable = true;

    	 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    	 			InitRowInfo( 1, 1, 3, 100);

    	 			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	 			//InitColumnInfo(6, 0, 0, true);
    	 			//InitColumnInfo(4, 0, 0, true);
    	 			InitColumnInfo(10, 0, 0, true);

    	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    	 			InitHeadMode(true, true, false, true, false,false)

    	 			//var HeadTitle = "|Sel|Display Seq.|File Name|";
    	 			
    	 			var HeadTitle = "|Sel|Display Seq.|File Name|Update Date|IMG SEQ|cre_usr_id|cre_dt|file_sav_id|deleteFlag";
    	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    	 			InitHeadRow(0, HeadTitle, true);
    	 			


    	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	 			
    	 			InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,	"ibflag");	
					InitDataProperty(0, cnt++ , dtCheckBox,			30,		daCenter,	true,	"del_chk",				false,	"",		dfNone,		0,	true,		true);
                    InitDataProperty(0, cnt++ , dtData,          	100,    daCenter,  	false,	"regu_dp_no",  			true, 	"",     dfNone,   	0,	false,      true,	5);
                    InitDataProperty(0, cnt++ , dtData,       		200,   	daCenter,  	false,	"file_nm",				true, 	"",     dfNone,   	0,  true,       true);
                    InitDataProperty(0, cnt++ , dtData,				150,	daCenter,	true,	"upd_dt",  				false,	"",		dfNone,		0,	false,		false);
                    InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	true,	"sub_seq",  				false,	"",		dfNone,		0,	false,		false);
                    
                    
                    // file upload 관련
                    InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	true,	"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		90, daCenter,	true,	"cre_dt",  					false,	"",	dfNone,	0,	false,	false);               
                    InitDataProperty(0, cnt++ , dtData,		200,daCenter,	true,	"file_sav_id",  			false,	"",	dfNone,	0,	false,	false); //저장되는 위치의 file 이름
                    InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
    	 	}
    	 	break;
    	 }
     }

  	// Sheet관련 프로세스 처리
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
          	case IBSEARCH: //조회
          		if(validateForm(sheetObj,formObj,sAction)){
          	 		formObj.f_cmd.value = SEARCH;
  	        	   	sheetObj.DoSearch("VOP_SCG_0108GS.do", FormQueryString(formObj));
  				}
          	break;
          	
        	case IBSAVE: //저장
    		if (!validateForm(sheetObj, formObj, sAction))
    			return;
    		//1.IBSheet 데이터 QueryString으로 묶기
    		var sParam = ComGetSaveString(sheetObj);
    		if (sParam == "")
    			return;

    		//0.IBUpload에 파일 추가하기
    		var upObj = uploadObjects[0];
    		upObj.Files = ""; //-먼저기존파일을 모두 지운후 추가함
    		var paramFile1 = setFileUpload(sheetObj);
    		ComSetObjValue(formObj.f_cmd, MULTI);
    		if (upObj.LocalFiles == "") {
    			/*******파일이 없는 경우 IBSheet 이용하기********/
    			//3.Form 데이터 QueryString으로 묶기
    			sParam += "&" + FormQueryString(formObj);
    			//4. 서버에 request전달하고, reponse 받기

    			var sXml = sheetObj.GetSaveXml("VOP_SCG_0108GS.do", sParam);
    			if (sXml.length > 0)
    				sheetObj.LoadSaveXml(sXml);
    		} else {
    			/*******파일이 있는 경우 IBUpload 이용하기********/
    			//3.Form 데이터 QueryString으로 묶기
    			sParam += "&" + FormQueryString(formObj) ;

    			//3.저장조건으로 저장실행
    			upObj.ExtendParam = sParam; //param값 추가 
    			upObj.ParamDecoding = true;
    			var sXml = upObj.DoUpload(true);
    			//4.저장후 결과처리
    			if (sXml.length > 0){
    				var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
    				if ( State == "S" ) {	
    					//ComShowMessage(ComGetMsg("BKG06071"));
    					sheetObj.LoadSaveXml(sXml);
    				}else{
    					fnExceptionMessage(sXml);
    				}
    			}
    		}
    		break;
    		
  			}
  		}

 	/**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl() {    	
         //Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	 axon_event.addListener ('keydown', 'ComKeyEnter', 		'form');
    	 axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
     }

	/**
	 * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
	 **/
	function obj_keypress(){
		var obj = event.srcElement;
		switch(obj.name){
			case "cnt_cd":
				if(event.keyCode!=32){ // 공백입력가능
					ComKeyOnlyAlphabet('upper');
				}
				break;
			case "port_cd":
				if(event.keyCode!=32){ // 공백입력가능
					ComKeyOnlyAlphabet('upper');
				}
				break;
		}
	}


	/**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */	 
     function validateForm(sheetObj,formObj,sAction){
//    	 if (sAction == IBSAVE) {
//  			var dupRow = sheetObj.ColValueDupRows("val_cd", false, true);
// 			if(dupRow != "") {
//				ComShowCodeMessage('SCG50005', 'Data');
//				if (sheetObj.RowStatus(dupRow.split("|")[0])=="R") {
//					sheetObj.SelectCell(dupRow.split("|")[1], 2);
//				}else{
//					sheetObj.SelectCell(dupRow.split("|")[0], 2);					
//				}
//				return;
// 			}    		 
//    	 }
         return true;
     }

	/**
	 * 파일 선택하기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} addRowFlag  sheetObj에 Row추가 여부
	 **/
	function selectFile(sheetObj, formObj, addFlag){
	
		var fileName = sheetObj.OpenFileDialog("Supporting Upload");
		var dispNo = formObj.regu_dp_no.value;

		if(addFlag){
			var strSeq = 1;
			var fileSeq = 1;
			if(sheetObj.RowCount > 0){
				strSeq  = parseInt(sheetObj.CellValue(sheetObj.RowCount, "strSeq"))+1;
			}
			var row = sheetObj.DataInsert(-1);
			sheetObj.CellValue2(row, "strSeq") = strSeq;
		}
	
		if(fileName.indexOf("\\") !=-1) {
			with(sheetObj) {
				CellValue2(SelectRow, "file_sav_id") = fileName;		//파일 경로 설정
				CellValue2(SelectRow, "file_set_yn") = "Y";				//로컬파일 선택여부 설정
				CellValue2(SelectRow, "cre_dt") = ComGetNowInfo("ymd");
				CellValue2(SelectRow, "regu_dp_no") = dispNo;

				fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
				CellValue2(SelectRow, "file_nm")= fileName;				//파일명 설정
				CellFontUnderline(SelectRow, "file_nm") = false;		//다운로드 링크 해제
				
			}
		}
		else{
			if(addFlag){
				sheetObj.RowStatus(sheetObj.SelectRow)= "D";
			}
		}
	}

	 /**
	  * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
	  * @param {ibsheet} sheetObj    IBSheet Object
	  * @param {String} 	prefix    	변수 구분값
	  **/
    function setFileUpload(sheetObj) {
		 
        var sRow = sheetObj.FindStatusRow("I");
        var upObj = uploadObjects[0];
        var arrRow = sRow.split(";");

        for (idx = 0; idx < arrRow.length - 1; idx++) {
        	var row = arrRow[idx];

        	//파일 경로 가져오기
        	var sFile = sheetObj.CellValue(row, "file_sav_id");	
        	//IBUpload에 파일 추가하기
        	var ret = upObj.AddFile(sFile);
        }
        var param = "file_cnt=" + (arrRow.length - 1);
        return param;
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
			// 파일이 존재시 다운로드 받는다.
			var key_id = sheetObj.CellValue(Row, "file_sav_id");
			//var exist = fnSaveFileExist(key_id , sheetObj);
			// 서버에 파일존재유무확인 
			//if(eval(exist)){
				hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
			//}else{
			//	ComShowMessage(ComGetMsg("BKG08127"));
			//}

			//sheetObj.HtmlControlEnterKey("downbtn",sheetObj);
			
		//return;
	}
	 
	 
	function doAction(sAction){
		switch(sAction){
			case "down":        //저장
				location.href = "/hanjin/FileDownload?key="+sheetObjects[0].CellText(sheetObjects[0].SelectRow, "file_sav_id");
				sheetObjects[0].SelectRow;
				break;
		}
	}


	/* 개발자 작업  끝 */