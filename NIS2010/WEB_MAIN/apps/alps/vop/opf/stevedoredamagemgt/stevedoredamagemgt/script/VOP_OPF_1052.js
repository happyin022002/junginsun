/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_1052.js
*@FileTitle : Supporting Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.25 이선영
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
     * @class vop_opf_1052 : vop_opf_1052 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_1052() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	//this.setTabObject 			= setTabObject;
    	//this.validateForm 			= validateForm;
    	this.setSequence			= setSequence;
    }
    
    /* 개발자 작업	*/

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var userId = "";
    var stvDmgNo = "";
    var stvDmgProcCd = "";
    var stvDmgAtchFileTpCd = "";
    var vslCd = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_FileAdd":
					selectFile(sheetObject1, true);
					break;
					
				case "btn_Delete":
					deleteRow(sheetObject1);
					break;
					
				case "btn_Ok":
					returnPopupData(sheetObject1);
					//comPopupOK();
					self.close();
					break;
					
				case "btn_Close":
					self.close();
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
     * 선택한 행 삭제 처리
     */
    function deleteRow(sheetObj){
    	var beforeStatus = sheetObj.RowStatus(sheetObj.SelectRow);
    	sheetObj.CellValue(sheetObj.SelectRow, "deleteFlag") = "Y";
    	sheetObj.RowStatus(sheetObj.SelectRow) = beforeStatus;
    	sheetObj.RowHidden(sheetObj.SelectRow) = true;
    	
    	// Sequence 재설정.
		setSequence(sheetObj);
    }
    
    /**
     * Sequence Update <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     **/
	function setSequence(sheetObj){
    	// Sequence 재설정.
		var seq = 1;
		var beforeStatus = "";
		for(var i=1; i<=sheetObj.LastRow; i++){
			if(sheetObj.CellValue(i, "deleteFlag") != "Y"){
			//if(sheetObj.RowStatus(i)!="D"){
				beforeStatus = sheetObj.RowStatus(i);
				sheetObj.CellValue2(i,"strSeq") = seq++;
				sheetObj.RowStatus(i) = beforeStatus;
			}
		}
    }
    
    /**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} addRowFlag  sheetObj에 Row추가 여부
     **/
	function selectFile(sheetObj, addFlag){
		
		var fileName = sheetObj.OpenFileDialog("Supporting Upload");
		
		if(addFlag){
			var strSeq = 1;
			var fileSeq = 1;
			if(sheetObj.RowCount > 0){
				strSeq  = parseInt(sheetObj.CellValue(sheetObj.RowCount, "strSeq"))+1;
				fileSeq = parseInt(sheetObj.CellValue(sheetObj.RowCount, "stv_dmg_atch_file_seq"))+1;
			}
			var row = sheetObj.DataInsert(-1);
			
			sheetObj.CellValue2(row, "stv_dmg_no") = stvDmgNo;
			sheetObj.CellValue2(row, "stv_dmg_proc_cd") = stvDmgProcCd;
			sheetObj.CellValue2(row, "stv_dmg_atch_file_tp_cd") = stvDmgAtchFileTpCd;
			sheetObj.CellValue2(row, "vsl_cd") = vslCd;
			sheetObj.CellValue2(row, "strSeq") = strSeq;
			sheetObj.CellValue2(row, "stv_dmg_atch_file_seq") = fileSeq;
		}
		
		if(fileName.indexOf("\\") !=-1) {
			with(sheetObj) {
				CellValue2(SelectRow, "file_sav_id") = fileName;		//파일 경로 설정
				CellValue2(SelectRow, "file_set_yn") = "Y";				//로컬파일 선택여부 설정
				CellValue2(SelectRow, "cre_usr_id") = userId;
				CellValue2(SelectRow, "cre_dt") = ComGetNowInfo("ymd");
	
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
		//location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, "file_sav_id");
		sheetObj.HtmlControlEnterKey("downbtn",sheetObj);
		
		return;
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(strPageId, strStvDmgNo, strUserId, strStvDmgProcCd, strStvDmgAtchFileTpCd, strVslCd) {

	    //부모창에 수정중인 파일정보가 있을 경우 부모창 정보를 가져온다.
	    //opener = window.dialogArguments;

		for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		pageId = strPageId;
		userId = strUserId;
		stvDmgNo = strStvDmgNo;
		stvDmgProcCd = strStvDmgProcCd;
	    stvDmgAtchFileTpCd = strStvDmgAtchFileTpCd;
	    vslCd = strVslCd;

	    //부모창에 Sheet명
	    var vSheetName;
	    if(strPageId == "OPF0052"){
		    if(strStvDmgAtchFileTpCd == "SDR"){
		    	vSheetName = "sheet2_";
		    }else if(strStvDmgAtchFileTpCd == "PIC"){
		    	vSheetName = "sheet3_";
	    	}else if(strStvDmgAtchFileTpCd == "DOC"){
		    	vSheetName = "sheet4_";
	    	}
	    }else if(strPageId == "OPF1053"){
	    	//부모창에 수정중인 파일정보가 있을 경우 부모창 정보를 가져온다.
	    	opener = window.dialogArguments;
	    	if(strStvDmgProcCd == "D"){
			    if(strStvDmgAtchFileTpCd == "SDR"){
			    	vSheetName = "sheet7_";
			    }else if(strStvDmgAtchFileTpCd == "PIC"){
			    	vSheetName = "sheet8_";
		    	}else if(strStvDmgAtchFileTpCd == "DOC"){
			    	vSheetName = "sheet9_";
		    	}
			    
			    //권한 따라 File Add, Delete, Ok 버튼 제어함.
			    if(!opener.authPermission(0)){
		     		ComBtnDisable("btn_FileAdd");
		     		ComBtnDisable("btn_Delete");
		     		ComBtnDisable("btn_Ok");
			    }
	    	}else if(strStvDmgProcCd == "R"){
			    if(strStvDmgAtchFileTpCd == "RES"){
			    	vSheetName = "sheet10_";
			    }else if(strStvDmgAtchFileTpCd == "INV"){
			    	vSheetName = "sheet11_";
		    	}else if(strStvDmgAtchFileTpCd == "PIC"){
			    	vSheetName = "sheet12_";
		    	}else if(strStvDmgAtchFileTpCd == "DOC"){
			    	vSheetName = "sheet13_";				    	
		    	}
			    
			    //권한 따라 File Add, Delete, Ok 버튼 제어함.
			    if(!opener.authPermission(1)){
		     		ComBtnDisable("btn_FileAdd");
		     		ComBtnDisable("btn_Delete");
		     		ComBtnDisable("btn_Ok");
			    }
	    	}else if(strStvDmgProcCd == "S"){
			    if(strStvDmgAtchFileTpCd == "INV"){
			    	vSheetName = "sheet14_";
		    	}else if(strStvDmgAtchFileTpCd == "DOC"){
			    	vSheetName = "sheet15_";				    	
		    	}
			    
			    //권한 따라 File Add, Delete, Ok 버튼 제어함.
			    if(!opener.authPermission(3)){
		     		ComBtnDisable("btn_FileAdd");
		     		ComBtnDisable("btn_Delete");
		     		ComBtnDisable("btn_Ok");
			    }
	    	}
	    }
	    
	    var sheetObj = sheetObjects[0];
        if(opener != undefined && opener != null) {
        	//alert("00"+document.form.stvDmgAtchFileTpCd.value);
        	var oSheetObj = opener.getFileUpload(document.form.stvDmgAtchFileTpCd.value, document.form.stvDmgProcCd.value);

        	if(strPageId == "OPF0052"){
	        	if(oSheetObj != undefined && oSheetObj != null && oSheetObj.RowCount > 0 && (oSheetObj.FindText(vSheetName+"stv_dmg_no", stvDmgNo) > 0) ){
	        		for(var i=oSheetObj.HeaderRows; i<=oSheetObj.LastRow; i++) {
	        			if( oSheetObj.CellValue(i, vSheetName+"stv_dmg_no") == stvDmgNo ){
	    					var inx = sheetObj.DataInsert(-1);
	    					for(var cnt=0 ; cnt < 12 ; cnt++){
	    						sheetObj.CellValue(inx, cnt) = oSheetObj.CellValue(i, cnt);
	    					}
	        			}
	        		}
	    			//ColFontUnderline("file_nm") = true;
	    			//DataLinkMouse("file_nm") = true;
	        		for(var rowIdx=sheetObj.HeaderRows; rowIdx<=sheetObj.LastRow; rowIdx++) {
	        			if(sheetObj.RowStatus(rowIdx) == 'D') sheetObj.RowHidden(rowIdx) =  true;
	        			if(sheetObj.RowStatus(rowIdx) == 'I') sheetObj.CellFont("FontUnderline", rowIdx,3) = false;
	        		}
	        	}
        	}else if(strPageId == "OPF1053"){
	        	if(oSheetObj != undefined && oSheetObj != null && oSheetObj.RowCount > 0){
	        		var sXml = IBS_GetDataSearchXml(oSheetObj);
	    			sheetObj.LoadSearchXml(sXml);
	        		for(var rowIdx=sheetObj.HeaderRows; rowIdx<=sheetObj.LastRow; rowIdx++) {
	        			if(sheetObj.RowStatus(rowIdx) == 'D'){ 
	        				sheetObj.RowHidden(rowIdx) =  true;
	        			}else if(sheetObj.RowStatus(rowIdx) == 'I') {
	        				sheetObj.CellFont("FontUnderline", rowIdx, "file_nm") = false;
	        			}
	        		}
	        	}
        		
        	}
        }
        
        // Sequence 재설정.
		setSequence(sheetObj);
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
                    
                    var HeadTitle = "|Seq.|stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
                    //InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	true,	"del_chk");
                    InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,	true,	"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	40,	daCenter,	true,	"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	40,	daCenter,	true,	"stv_dmg_atch_file_seq",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		260,daCenter,	true,	"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	true,	"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		90,daCenter,	true,	"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	100,daCenter,	true,	"file_sav_id",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,	true,	"stv_dmg_proc_cd",  		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	50,	daCenter,	true,	"stv_dmg_atch_file_tp_cd",  false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	70,	daCenter,	true,	"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;
                
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	      case IBSEARCH:      //조회
	        formObj.f_cmd.value = SEARCH;
	        sheetObj.DoSearch("VOP_OPF_1052GS.do", FormQueryString(formObj));
	        break;
	        
	    }
	}
    
	function doAction(sAction){
		switch(sAction){
			case "down":        //저장
				location.href = "/hanjin/FileDownload?key="+sheetObjects[0].CellText(sheetObjects[0].SelectRow, "file_sav_id");
				sheetObjects[0].SelectRow;
				break;
		}
	}
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
//    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
//        }
//
//        return true;
//    }

	/* 개발자 작업  끝 */