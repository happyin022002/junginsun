/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0112.js
*@FileTitle : File Attach
*Open Issues :
*Change history :
*@LastModifyDate :
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
     * @class vop_scg_0112 : vop_scg_0112 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0112() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnDblClick 		= sheet1_OnDblClick;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt     = 0;
    var prefix       = "sheet1_";
    
    var uploadObjects = new Array();
	var uploadCnt     = 0;
	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {    	
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
    }
    
    

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
				case "btn_FileAdd":  
					selectFile(sheetObject, false);
					break;								//선택행아래 생성[Sheet1]
				case "btn_FileDelete":
				//	setDelRow(sheetObject);
					ComRowHideDelete(sheetObject, prefix+"del_chk");
					break;	
				case "btn_Save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);					
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
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} addRowFlag  sheetObj에 Row추가 여부
     **/
	function selectFile(sheetObj, addRowFlag){

			sheetObj.DataInsert(-1,0);							
			var filePath = sheetObj.OpenFileDialog('Please choose target file to upload.');
			
			if(filePath.indexOf("\\") !=-1) {
				with(sheetObj) {
					CellValue2(SelectRow, prefix+"file_set_yn") = "Y";				//로컬파일 선택여부 설정
					CellValue2(SelectRow, prefix+"file_sav_id") = filePath;			//파일 로컬경로 설정
		
					fileName = filePath.substr(filePath.lastIndexOf("\\")+1);
					CellValue2(SelectRow, prefix+"file_nm")= fileName;			    //파일명 설정
					
					CellFontUnderline(SelectRow, prefix+"file_nm") = false;			//다운로드 링크 해제
					
					CellValue2(SelectRow, prefix+"chem_seq")= document.form.chem_seq.value;		
					CellValue2(SelectRow, prefix+"atch_file_div_cd")= document.form.atch_file_div_cd.value;	
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
        for(var i=0;i<uploadObjects.length;i++){
		    //1. 기본 환경 설정
		    ComConfigUpload(uploadObjects[i], "/hanjin/VOP_SCG_0112GS.do");
		}
        
        //이벤트 리스너 생성
        initControl();
      //  if(document.form.seachCheck.value == "Y")
       // document.getElementById("btns").style.visibility = "hidden";
    }
     
    /**
     * sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function sheet1_OnLoadFinish(sheetObj) {	
    	//페이지로딩시 초기 조회
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    //높이 설정
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
                    InitColumnInfo(11, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|No.|File Name|ID|Date|||||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	    0,	   daCenter,   true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,         30,     daCenter,   true,    prefix+"del_chk");
                    InitDataProperty(0, cnt++ , dtDataSeq,      	30,     daCenter);
                    
                    InitDataProperty(0, cnt++ , dtData,			   400,    daLeft,	   true,    prefix+"file_nm", 	    		    false,     "",     dfNone,      0,     false,   false, 200);
                    InitDataProperty(0, cnt++ , dtData,			    70,    daCenter,   true,    prefix+"cre_usr_id", 	 		 	false,    "",      dfNone,      0,     false,    false);
                    InitDataProperty(0, cnt++ , dtData,			    60,    daCenter,   true,    prefix+"cre_dt", 	  				false,    "",      dfDateYmd,   0,     false,    false);
                  
                    InitDataProperty(0, cnt++ , dtHidden,          0,      daCenter,   true,    prefix+"file_set_yn",		        true,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,   	   0,      daLeft,	   true,    prefix+"file_sav_id", 		        true,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,          0,      daLeft,	   true,    prefix+"chem_seq",              	true,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,   	   0,      daLeft,	   true,    prefix+"atch_file_div_cd", 	        true,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,   	   0,      daLeft,	   true,    prefix+"atch_file_seq", 	        true,     "",      dfNone,      0,     true,    true);
                                    
                  
               }
               break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;						
				sheetObj.DoSearch("VOP_SCG_0112GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));	
				
				break;
			case IBSAVE:        //저장
			//	if(!validateForm(sheetObj,formObj,sAction)) return true;
				
				formObj.f_cmd.value = MULTI;

				//1.IBUpload에 파일 추가하기
				var upObj = uploadObjects[0];	
		
				upObj.Files="";	
			
				setFileUpload(sheetObj, upObj);	//Sheet의 추가 파일정보를 IBUpload로 Copy

				if (upObj.LocalFiles == "") {
					/*******파일이 없는 경우 IBSheet 이용하기********/
					//2.IBSheet 데이터 QueryString으로 묶기
					var sParam = ComGetSaveString(sheetObj);					
					if (sParam == "") return;
					//3.Form 데이터 QueryString으로 묶기
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
					ComOpenWait(true, true);	//키보드나 마우스를 대기상태 & 대기이미지
					//4. 서버에 request전달하고, reponse 받기
					var sXml = sheetObj.GetSaveXml("VOP_SCG_0112GS.do", sParam);
				
				} else {
					/*******파일이 있는 경우 IBUpload 이용하기********/

					//2.IBSheet 데이터 QueryString으로 묶기
					var sParam = ComGetSaveString(sheetObj, true);
					if (sParam == "") return;
	
					//3.Form 데이터 QueryString으로 묶기				
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
					
					ComOpenWait(true, true);	//키보드나 마우스를 대기상태 & 대기이미지
					
					//4. 서버에 request전달하고, reponse 받기
					upObj.ExtendParam = sParam;
					
					upObj.ParamDecoding = true;

					var sXml = upObj.DoUpload(true);
				}
				
				if (sXml.length > 0) sheetObj.LoadSaveXml(sXml);
				
				ComOpenWait(false);
			break;					
        }
    }
    
    /**
     * Sheet 조회완료 후 이벤트 발생
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			ColFontUnderline(prefix+"file_nm") = true;
			DataLinkMouse(prefix+"file_nm") = true;
		}
	}
    
    /**
     * Sheet 저장완료 후 이벤트 발생
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	//if (ErrMsg == "") {
    		//ComScgSaveCompleted();  							//서버메세지 처리
    		doActionIBSheet(sheetObj, document.form, IBSEARCH);	//파일링크를 위해 재조회
    	//} 	 	
    }
        
	/**
	 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
	 * @param {ibsheet}   sheetObj    IBSheet Object
	 * @param {ibupload}  upObj    	  IBUpload Object
	 **/
	function setFileUpload(sheetObj, upObj) {	
		for (var rowIdx=1; rowIdx<=sheetObj.RowCount; rowIdx++){ 
			var fileSetYn = sheetObj.CellValue(rowIdx, prefix+"file_set_yn");
			
			//파일 경로 가져오기
			if(fileSetYn == 'Y') {
				var sFile = sheetObj.CellValue(rowIdx, prefix + "file_sav_id");		
				if (sFile=="") ComShowCodeMessage('SCG50004', 'Data');	//'{?msg1} is not available.'
				//IBUpload에 파일 추가하기
				var ret = upObj.AddFile(sFile);
			}
		}
	
		return; 
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet1_OnDblClick(sheetObj, Row, Col, Value){		
		if (sheetObj.ColSaveName(Col) != prefix+"file_nm") 
			return;

		//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
	/*	if(sheetObj.CellText(Row, prefix+"file_nm") == "" 
			|| sheetObj.RowStatus(Row) == "I" 
			|| sheetObj.CellValue(Row, prefix+"file_set_yn") == "Y") {			
			selectFile(sheetObj, false);			
			return;
		}*/
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
    	var ibflag;
    	var sVal1;
    	var sVal2;

    	
    	for(var rowIdx1=sheetObj.HeaderRows; rowIdx1<=sheetObj.LastRow; rowIdx1++) {
    		ibflag = sheetObj.cellValue(rowIdx1,0);			
    		sVal1 = sheetObj.CellValue(rowIdx1, 7);
			if((ibflag == 'U' || ibflag == 'I') && sVal1 != '') {				
	    		for(var rowIdx2=sheetObj.HeaderRows; rowIdx2<=sheetObj.LastRow; rowIdx2++) {
	    			ibflag = sheetObj.cellValue(rowIdx1,0);	
					sVal2 = sheetObj.CellValue(rowIdx2, 7);
					if(rowIdx1 != rowIdx2 && ibflag != 'D' && sVal2 != '') {
		    			if(sVal1 == sVal2) {
		    				ComShowCodeMessage('SCG50005', 'Data');   //'{?msg1} is duplicated.'
		    				sheetObj.SelectCell(rowIdx1,7);
		    				return false;
		    			}
		    		}
				}
			}
    	}
    	
    	//'저장하시겠습니까?'
		if(!ComShowCodeConfirm('SCG50001', 'data')) return false;	//'Do you want to save {?msg1}?'

        return true;
    }
    
	/* 개발자 작업  끝 */
