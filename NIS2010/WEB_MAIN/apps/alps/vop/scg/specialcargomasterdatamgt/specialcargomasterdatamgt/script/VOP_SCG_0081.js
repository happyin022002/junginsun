/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VOP_SCG_0081.js
*@FileTitle : Special Cargo Guidance - Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.07
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.07 김영오
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
     * @class vop_scg_0081 : vop_scg_0081 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0081() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnDblClick 		= sheet1_OnDblClick;
    	this.setStvDmgNo			= setStvDmgNo;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt     = 0;
    
    var uploadObjects = new Array();
	var uploadCnt     = 0;
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var bRetrive = false;
	var sheetCheckEdit = null;
	var tabIndex = 0;
	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {    	
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        //axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
        axon_event.addListener("change", "frmObj_OnChange", "ftr_ctnt01");
        axon_event.addListener("change", "frmObj_OnChange", "ftr_ctnt02");
        axon_event.addListener("change", "frmObj_OnChange", "ftr_ctnt03");
        axon_event.addListener("change", "frmObj_OnChange", "ftr_ctnt04");        
    }
    
    // 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "engup":
    	    	switch(event.srcElement.name){
	    	        case "imdg_pck_instr_cd":	
	    	        	//공통기준:영문대, 숫자만을 인식
	        	    	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
    	    	}
    	    	break; 
    	}
    }

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	    var sheetObject = sheetObjects[0];
	    var sheetObject2 = sheetObjects[1];
	    var sheetObject3 = sheetObjects[2];
	    var sheetObject4 = sheetObjects[3];
	    var sheetObject5 = sheetObjects[4];
	    var sheetObject6 = sheetObjects[5];		
		
	    var sheetObject7 = sheetObjects[6];
	    var sheetObject10 = sheetObjects[9];
	    var sheetObject11 = sheetObjects[10];
	    
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_retrieve":
					ComOpenWait(true);
					sheetObjects[8].removeAll();
					doActionIBSheet(sheetObject7,formObject,IBSEARCH);
					ComOpenWait(false);
					break;
					
				///////////////////////////////////DG
				case "btn1_addrow":										//신규 Row 생성
					var insRow = sheetObject.DataInsert(-1);
					sheetObject.CellValue2(insRow, "upd_usr_id") = formObject.upd_usr_id.value;
					sheetObject.CellValue2(insRow, "cre_usr_id") = formObject.upd_usr_id.value;
					sheetObject.CellValue2(insRow, "upd_dt") = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hms");
					sheetObject.CellValue2(insRow, "spcl_cgo_guid_cd") = "DG";
					break;
				case "btn1_row_delete":									//Row 삭제
					ComRowHideDelete(sheetObject, "del_chk");
					break;
				case "btn1_addfile_row":								//File Add인 경우 New Row 생성과 윈도우 탐색기 호출
					if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "spcl_cgo_guid_seq") == ""){
						ComShowCodeMessage('SCG50041', '');
						return;
	        		}
					selectFile(sheetObject2, true);
					selectFile(sheetObject2, false);
					formObject.chk_file.value = '0';
					sheetObjects[1].CellValue2(sheetObjects[1].LastRow, "spcl_cgo_guid_seq") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "spcl_cgo_guid_seq");
					break; 			
				case "btn1_addfile_delete":								//Row 삭제
					ComRowHideDelete(sheetObject2, "del_chk");
					break;
				
				///////////////////////////////////Awkward				
				case "btn2_addrow":										//신규 Row 생성
					var insRow3 = sheetObject3.DataInsert(-1);
					sheetObject3.CellValue2(insRow3, "upd_usr_id") = formObject.upd_usr_id.value;
					sheetObject3.CellValue2(insRow3, "cre_usr_id") = formObject.upd_usr_id.value;
					sheetObject3.CellValue2(insRow3, "upd_dt") = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hms");
					sheetObject.CellValue2(insRow3, "spcl_cgo_guid_cd") = "AW";
					break;
				case "btn2_row_delete":									//Row 삭제
					ComRowHideDelete(sheetObject3, "del_chk");
					break;
				case "btn2_addfile_row":								//File Add인 경우 New Row 생성과 윈도우 탐색기 호출
					if(sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "spcl_cgo_guid_seq") == ""){
						ComShowCodeMessage('SCG50041', '');
						return;
	        		}
					selectFile(sheetObject4, true);
					selectFile(sheetObject4, false);
					formObject.chk_file.value = '0';
					sheetObjects[3].CellValue2(sheetObjects[3].LastRow, "spcl_cgo_guid_seq")  = sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "spcl_cgo_guid_seq");
					break; 			
				case "btn2_addfile_delete":								//Row 삭제
					ComRowHideDelete(sheetObject4, "del_chk");
					break;	
				
				///////////////////////////////////Others
				case "btn3_addrow":										//신규 Row 생성
					var insRow5 = sheetObject5.DataInsert(-1);
					sheetObject5.CellValue2(insRow5, "upd_usr_id") = formObject.upd_usr_id.value;
					sheetObject5.CellValue2(insRow5, "cre_usr_id") = formObject.upd_usr_id.value;
					sheetObject5.CellValue2(insRow5, "upd_dt") = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hms");
					sheetObject.CellValue2(insRow5, "spcl_cgo_guid_cd") = "BB";
					break;
				case "btn3_row_delete":									//Row 삭제
					ComRowHideDelete(sheetObject5, "del_chk");
					break;	
				case "btn3_addfile_row":								//File Add인 경우 New Row 생성과 윈도우 탐색기 호출
					if(sheetObjects[4].CellValue(sheetObjects[4].SelectRow, "spcl_cgo_guid_seq") == ""){
						ComShowCodeMessage('SCG50041', '');
						return;
	        		}				
					selectFile(sheetObject6, true);
					selectFile(sheetObject6, false);
					formObject.chk_file.value = '0';
					sheetObjects[5].CellValue2(sheetObjects[5].LastRow, "spcl_cgo_guid_seq")  = sheetObjects[4].CellValue(sheetObjects[4].SelectRow, "spcl_cgo_guid_seq");
					break; 			
				case "btn3_addfile_delete":								//Row 삭제
					ComRowHideDelete(sheetObject6, "del_chk");
					break;
					
				    ///////////////////////////////////Break Bulk
				case "btn4_addrow":										//신규 Row 생성
					var insRow5 = sheetObject10.DataInsert(-1);
					sheetObject10.CellValue2(insRow5, "upd_usr_id") = formObject.upd_usr_id.value;
					sheetObject10.CellValue2(insRow5, "cre_usr_id") = formObject.upd_usr_id.value;
					sheetObject10.CellValue2(insRow5, "upd_dt") = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hms");
					sheetObject.CellValue2(insRow5, "spcl_cgo_guid_cd") = "OT";
					break;
				case "btn4_row_delete":									//Row 삭제
					ComRowHideDelete(sheetObject10, "del_chk");
					break;	
				case "btn4_addfile_row":								//File Add인 경우 New Row 생성과 윈도우 탐색기 호출
				
					if(sheetObjects[9].CellValue(sheetObjects[9].SelectRow, "spcl_cgo_guid_seq") == ""){
						ComShowCodeMessage('SCG50041', '');
						return;
	        		}
					selectFile(sheetObject11, true);
					selectFile(sheetObject11, false);
					formObject.chk_file.value = '0';
					sheetObjects[10].CellValue2(sheetObjects[10].LastRow, "spcl_cgo_guid_seq")  = sheetObjects[9].CellValue(sheetObjects[9].SelectRow, "spcl_cgo_guid_seq");
					
					break;
				case "btn4_addfile_delete":								//Row 삭제
					ComRowHideDelete(sheetObject11, "del_chk");
					break;						
					
				case "btn_update":
					selectFile(sheetObject, false);
					break;
				case "btn2_row_insert":
					//sheetObject.DataInsert();							//선택행아래 생성[Sheet1]
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);	
					break;
				case "btn_new":
					ComResetAll();
					doActionIBSheet(sheetObject7,formObject,IBSEARCH);
					break;
            } // end switch
    	}catch(e) {    		if( e == "[object Error]") {
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
		if(addRowFlag) {
			sheetObj.DataInsert(-1,0);								//File Add인 경우 New Row 생성
		} else {
		
			var filePath = sheetObj.OpenFileDialog('Please choose target file to upload.');
			
			if(filePath.indexOf("\\") !=-1) {
				with(sheetObj) {
					CellValue2(SelectRow, "file_set_yn") = "Y";				//로컬파일 선택여부 설정
					CellValue2(SelectRow, "file_sav_id") = filePath;			//파일 로컬경로 설정
		
					fileName = filePath.substr(filePath.lastIndexOf("\\")+1);
					CellValue2(SelectRow, "file_nm")= fileName;			    //파일명 설정
				}
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
        for(var i=0;i<uploadObjects.length;i++){
		    //1. 기본 환경 설정
		    ComConfigUpload(uploadObjects[i], "/hanjin/VOP_SCG_0081GS.do");
		}
        
        //이벤트 리스너 생성
        initControl();
		
        // Tab Object 초기화
    	for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
		tabObjects[0].SelectedIndex = 0;
		bRetrive = true;
		document.form.chk_file.value = '';
    }
     
    /**
     * sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function sheet1_OnLoadFinish(sheetObj) {	
    	//페이지로딩시 초기 조회
		doActionIBSheet(sheetObj,document.form,SEARCH14);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet0 init [Dg-제목]
                with (sheetObj) {

                    //높이 설정
                    style.height = 210;
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

                    var HeadTitle = "|Sel.|No.|Subject|Posted by|Posted Date||||";
					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	   	0,	    daCenter,   true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,        	30,     daCenter,   true,    "del_chk");
                    InitDataProperty(0, cnt++ , dtDataSeq,         	30,     daCenter);
                    InitDataProperty(0, cnt++ , dtData,			   	700,    daLeft,	    true,    "hdr_ctnt", 	    		false,     "",      dfNone,      0,     true,   true, 200);
                    InitDataProperty(0, cnt++ , dtData,		   		90,    daCenter,   true,    "upd_usr_id", 	 		 	false,    "",      dfNone,      0,     false,    false);
                    InitDataProperty(0, cnt++ , dtData,		   		100,    daCenter,   true,    "upd_dt", 	  				false,    "",      dfNone,   0,     false,    false);
               		
					InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "cre_usr_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "cre_dt", 	  				false,    "",      dfDateYmd,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "ftr_ctnt", 	  			false,    "",      dfNone,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "spcl_cgo_guid_cd", 	  	false,    "",      dfDateYmd,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "spcl_cgo_guid_seq", 	  	false,    "",      dfDateYmd,   0,     true,    true);
                    
                    WaitImageVisible = false;
			   }
               break;
			   
            case 2:      //sheet1 init [Dg-첨부파일]
                with (sheetObj) {

                    //높이 설정
                    style.height = 90;
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
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	   0,	   daCenter,   	true,	 "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,        30,     daCenter,   	true,    "del_chk");
                    InitDataProperty(0, cnt++ , dtDataSeq,         30,     daCenter);
                    InitDataProperty(0, cnt++ , dtData,			   450,    daLeft,	   	true,    "file_nm", 	    		    true,     "",      dfNone,      0,     false,   false, 200);
                    
					InitDataProperty(0, cnt++ , dtHidden,		   130,    daCenter,   	true,    "cre_usr_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		   130,    daCenter,   	true,    "cre_dt", 	  				false,    "",      dfDateYmd,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		   450,    daLeft,	   	true,    "spcl_cgo_guid_atch_file_seq", 	    		    true,     "",      dfNone,      0,     false,   false, 200);
                    InitDataProperty(0, cnt++ , dtHidden,		   450,    daLeft,	   	true,    "spcl_cgo_guid_seq", 	    		    true,     "",      dfNone,      0,     false,   false, 200);
                    InitDataProperty(0, cnt++ , dtHidden,		   130,    daLeft,   	true,    "file_sav_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		   130,    daLeft,   	true,    "file_set_yn", 	 		 	false,    "",      dfNone,      0,     true,    true);
               		InitDataProperty(0, cnt++ , dtHidden,		   130,    daLeft,   	true,    "iud_flg", 	 		 	false,    "",      dfNone,      0,     true,    true);
               
               		WaitImageVisible = false;
			   }
               break;
			   			   
			   case 3:      //sheet2 init [Awkward-제목]
                with (sheetObj) {

                    //높이 설정
                    style.height = 210;
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
                    InitColumnInfo(10, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|No.|Subject|Posted by|Posted Date|||";
					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	   	0,	    daCenter,   true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,        	30,     daCenter,   true,    "del_chk");
                    InitDataProperty(0, cnt++ , dtDataSeq,         	30,     daCenter);
                    InitDataProperty(0, cnt++ , dtData,			   	700,    daLeft,	    true,    "hdr_ctnt", 	    		false,     "",      dfNone,      0,     true,   true, 200);
                    InitDataProperty(0, cnt++ , dtData,		   		90,    daCenter,   true,    "upd_usr_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,		   		100,    daCenter,   true,    "upd_dt", 	  				false,    "",      dfNone,   0,     true,    true);
               		
					InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "cre_usr_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "cre_dt", 	  				false,    "",      dfDateYmd,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "ftr_ctnt", 	  			false,    "",      dfNone,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "spcl_cgo_guid_seq", 	  	false,    "",      dfDateYmd,   0,     true,    true);
                    
                    WaitImageVisible = false;
			   }
               break;
			   
            case 4:      //sheet3 init [Awkward-첨부파일]
                with (sheetObj) {

                    //높이 설정
                    style.height = 90;
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
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	   0,	   daCenter,   	true,	 "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,        30,     daCenter,   	true,    "del_chk");
                    InitDataProperty(0, cnt++ , dtDataSeq,         30,     daCenter);
                    InitDataProperty(0, cnt++ , dtData,			   450,    daLeft,	   	true,    "file_nm", 	    		    true,     "",      dfNone,      0,     false,   false, 200);
                    
					InitDataProperty(0, cnt++ , dtHidden,		   130,    daCenter,   	true,    "cre_usr_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		   130,    daCenter,   	true,    "cre_dt", 	  				false,    "",      dfDateYmd,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		   450,    daLeft,	   	true,    "spcl_cgo_guid_atch_file_seq", 	    		    true,     "",      dfNone,      0,     false,   false, 200);
                    InitDataProperty(0, cnt++ , dtHidden,		   450,    daLeft,	   	true,    "spcl_cgo_guid_seq", 	    		    true,     "",      dfNone,      0,     false,   false, 200);
                    InitDataProperty(0, cnt++ , dtHidden,		   130,    daLeft,   	true,    "file_sav_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		   130,    daLeft,   	true,    "file_set_yn", 	 		 	false,    "",      dfNone,      0,     true,    true);
               		InitDataProperty(0, cnt++ , dtHidden,		   130,    daLeft,   	true,    "iud_flg", 	 		 	false,    "",      dfNone,      0,     true,    true);
               
               		WaitImageVisible = false;
			   }
               break;
			   case 5:      //sheet4 init [BB -제목]
                with (sheetObj) {

                    //높이 설정
                    style.height = 210;
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
                    InitColumnInfo(10, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|No.|Subject|Posted by|Posted Date|||";
					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	   	0,	    daCenter,   true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,        	30,     daCenter,   true,    "del_chk");
                    InitDataProperty(0, cnt++ , dtDataSeq,         	30,     daCenter);
                    InitDataProperty(0, cnt++ , dtData,			   	700,    daLeft,	    true,    "hdr_ctnt", 	    		false,     "",      dfNone,      0,     true,   true, 200);
                    InitDataProperty(0, cnt++ , dtData,		   		90,    daCenter,   true,    "upd_usr_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,		   		100,    daCenter,   true,    "upd_dt", 	  				false,    "",      dfNone,   0,     true,    true);
               		
					InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "cre_usr_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "cre_dt", 	  				false,    "",      dfDateYmd,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "ftr_ctnt", 	  			false,    "",      dfNone,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "spcl_cgo_guid_seq", 	  	false,    "",      dfDateYmd,   0,     true,    true);
                    
                    WaitImageVisible = false;
			   }
               break;
			   
            case 6:      //sheet5 init [BB -첨부파일]
               with (sheetObj) {

                    //높이 설정
                    style.height = 90;
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
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	   0,	   daCenter,   	true,	 "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,        30,     daCenter,   	true,    "del_chk");
                    InitDataProperty(0, cnt++ , dtDataSeq,         30,     daCenter);
                    InitDataProperty(0, cnt++ , dtData,			   450,    daLeft,	   	true,    "file_nm", 	    		    true,     "",      dfNone,      0,     false,   false, 200);
                    
					InitDataProperty(0, cnt++ , dtHidden,		   130,    daCenter,   	true,    "cre_usr_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		   130,    daCenter,   	true,    "cre_dt", 	  				false,    "",      dfDateYmd,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		   450,    daLeft,	   	true,    "spcl_cgo_guid_atch_file_seq", 	    		    true,     "",      dfNone,      0,     false,   false, 200);
                    InitDataProperty(0, cnt++ , dtHidden,		   450,    daLeft,	   	true,    "spcl_cgo_guid_seq", 	    		    true,     "",      dfNone,      0,     false,   false, 200);
                    InitDataProperty(0, cnt++ , dtHidden,		   130,    daLeft,   	true,    "file_sav_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,		   130,    daLeft,   	true,    "file_set_yn", 	 		 	false,    "",      dfNone,      0,     true,    true);
               		InitDataProperty(0, cnt++ , dtHidden,		   130,    daLeft,   	true,    "iud_flg", 	 		 	false,    "",      dfNone,      0,     true,    true);
               
               		WaitImageVisible = false;
			   }
               break;
			   
			   
            case 7:      //sheet6 init 화면 제일 윗 부분 TextArea 저장 을위한 Grid
                with (sheetObj) {

                    //높이 설정
                    style.height = 110;
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
                    InitColumnInfo(4, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|No.|hdr_ctnt|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	   0,	   daCenter,   	true,	 "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,        30,     daCenter,   	true,    "del_chk");
                    InitDataProperty(0, cnt++ , dtDataSeq,         30,     daCenter);
                    InitDataProperty(0, cnt++ , dtData,			   450,    daLeft,	   	true,    "msg_hdr_ctnt", 	    false,     "",      dfNone,      0,     true,   true, 200);
                    
                    WaitImageVisible = false;
               }
               break;
			   
			  case 8:      //sheet7 init [탭 상세정보 저장을 위한 Greid]
                with (sheetObj) {

                    //높이 설정
                    style.height = 110;
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

                    var HeadTitle = "|No.|iud_flg|Subject|ftr_ctnt|Posted by|Posted Date|||";
					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,	   		30,	    daCenter,   true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtDataSeq,         	30,     daCenter);
                    InitDataProperty(0, cnt++ , dtData,			   	50,    	daLeft,	    true,    "iud_flg", 	    		false,     "",      dfNone,      0,     true,   true, 200);
                    InitDataProperty(0, cnt++ , dtData,			   	350,    daLeft,	    true,    "hdr_ctnt", 	    		false,     "",      dfNone,      0,     true,   true, 200);
                    InitDataProperty(0, cnt++ , dtData,			   	350,    daLeft,	    true,    "ftr_ctnt", 	    		false,     "",      dfNone,      0,     true,   true, 200);
					InitDataProperty(0, cnt++ , dtData,		   		150,    daCenter,   true,    "upd_usr_id", 	 		 	false,    "",      dfNone,      0,     false,    false);
                    InitDataProperty(0, cnt++ , dtData,		   		130,    daCenter,   true,    "upd_dt", 	  				false,    "",      dfNone,   0,     false,    false);
               		InitDataProperty(0, cnt++ , dtData,		    	130,    daCenter,   true,    "cre_usr_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,		    	130,    daCenter,   true,    "cre_dt", 	  				false,    "",      dfDateYmd,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,		    	130,    daCenter,   true,    "spcl_cgo_guid_cd", 	  	false,    "",      dfDateYmd,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,		    	130,    daCenter,   true,    "spcl_cgo_guid_seq", 	  	false,    "",      dfDateYmd,   0,     true,    true);
                    
                    WaitImageVisible = false;
			   }
               break;
			   
			   case 9:      //sheet8 init [첨부파일 정보 저장을 위한 Greid]
                with (sheetObj) {

                    //높이 설정
                    style.height = 110;
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
                    InitColumnInfo(10, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|No.|File Name|spcl_cgo_guid_cd|spcl_cgo_guid_atch_file_seq|file_sav_id|file_set_yn|iud_flg|spcl_cgo_guid_seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	   0,	   daCenter,   	true,	 "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,        30,     daCenter,   	true,    "del_chk");
                    InitDataProperty(0, cnt++ , dtDataSeq,         30,     daCenter);
				    InitDataProperty(0, cnt++ , dtData,			   200,    daLeft,	   	true,    "file_nm", 	    		    false,     "",      dfNone,      0,     true,   true, 200);
                    InitDataProperty(0, cnt++ , dtData,		   200,    daLeft,   	true,    "spcl_cgo_guid_cd", 	  			false,    "",      dfNone,   0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,		   200,    daLeft,	   	true,    "spcl_cgo_guid_atch_file_seq", 	false,     "",      dfNone,      0,     true,   true, 200);
                    InitDataProperty(0, cnt++ , dtData,		   200,    daLeft,   	true,    "file_sav_id", 	 		 		false,    "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,		   200,    daLeft,   	true,    "file_set_yn", 	 		 		false,    "",      dfNone,      0,     true,    true);
               		InitDataProperty(0, cnt++ , dtData,		   200,    daLeft,   	true,    "iud_flg", 	 		 			false,    "",      dfNone,      0,     true,    true);
               		InitDataProperty(0, cnt++ , dtData,		   200,    daLeft,   	true,    "spcl_cgo_guid_seq", 	 		 	false,    "",      dfNone,      0,     true,    true);
               
               		WaitImageVisible = false;
			   }
               break;
               
			   case 10:      //sheet10 init [Others-제목]
	             with (sheetObj) {
	
	                 //높이 설정
	                 style.height = 210;
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
	                 InitColumnInfo(10, 0, 0, true);
	
	                 //해더에서 처리할 수 있는 각종 기능을 설정한다
	                 InitHeadMode(true, true, false, true, false,false)
	
	                 var HeadTitle = "|Sel.|No.|Subject-BB|Posted by|Posted Date|||";
					
	                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                 InitHeadRow(0, HeadTitle, true);
	
	                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                 InitDataProperty(0, cnt++ , dtHiddenStatus,	   	0,	    daCenter,   true,	"ibflag");
	                 InitDataProperty(0, cnt++ , dtCheckBox,        	30,     daCenter,   true,    "del_chk");
	                 InitDataProperty(0, cnt++ , dtDataSeq,         	30,     daCenter);
	                 InitDataProperty(0, cnt++ , dtData,			   	700,    daLeft,	    true,    "hdr_ctnt", 	    		false,     "",      dfNone,      0,     true,   true, 200);
	                 InitDataProperty(0, cnt++ , dtData,		   		90,    daCenter,   true,    "upd_usr_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
	                 InitDataProperty(0, cnt++ , dtData,		   		100,    daCenter,   true,    "upd_dt", 	  				false,    "",      dfNone,   0,     true,    true);
	            		
					 InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "cre_usr_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
	                 InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "cre_dt", 	  				false,    "",      dfDateYmd,   0,     true,    true);
	                 InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "ftr_ctnt", 	  			false,    "",      dfNone,   0,     true,    true);
	                 InitDataProperty(0, cnt++ , dtHidden,		    130,    daCenter,   true,    "spcl_cgo_guid_seq", 	  	false,    "",      dfDateYmd,   0,     true,    true);
	                 
	                 WaitImageVisible = false;
			      }
	            break;
			   
	         case 11:      //sheet11 init [Others-첨부파일]
	            with (sheetObj) {
	
	                 //높이 설정
	                 style.height = 90;
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
	                 InitDataProperty(0, cnt++ , dtHiddenStatus,	   0,	   daCenter,   	true,	 "ibflag");
	                 InitDataProperty(0, cnt++ , dtCheckBox,        30,     daCenter,   	true,    "del_chk");
	                 InitDataProperty(0, cnt++ , dtDataSeq,         30,     daCenter);
	                 InitDataProperty(0, cnt++ , dtData,			   450,    daLeft,	   	true,    "file_nm", 	    		    true,     "",      dfNone,      0,     false,   false, 200);
	                 
					InitDataProperty(0, cnt++ , dtHidden,		   130,    daCenter,   	true,    "cre_usr_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
	                 InitDataProperty(0, cnt++ , dtHidden,		   130,    daCenter,   	true,    "cre_dt", 	  				false,    "",      dfDateYmd,   0,     true,    true);
	                 InitDataProperty(0, cnt++ , dtHidden,		   450,    daLeft,	   	true,    "spcl_cgo_guid_atch_file_seq", 	    		    true,     "",      dfNone,      0,     false,   false, 200);
	                 InitDataProperty(0, cnt++ , dtHidden,		   450,    daLeft,	   	true,    "spcl_cgo_guid_seq", 	    		    true,     "",      dfNone,      0,     false,   false, 200);
	                 InitDataProperty(0, cnt++ , dtHidden,		   130,    daLeft,   	true,    "file_sav_id", 	 		 	false,    "",      dfNone,      0,     true,    true);
	                 InitDataProperty(0, cnt++ , dtHidden,		   130,    daLeft,   	true,    "file_set_yn", 	 		 	false,    "",      dfNone,      0,     true,    true);
	            		InitDataProperty(0, cnt++ , dtHidden,		   130,    daLeft,   	true,    "iud_flg", 	 		 	false,    "",      dfNone,      0,     true,    true);
	            
	            		WaitImageVisible = false;
			      }
	            break; 
          
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				//ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObjects[6].removeAll();
				formObj.ftr_ctnt01.value = "";
				formObj.ftr_ctnt02.value = "";
				formObj.ftr_ctnt03.value = "";
				formObj.ftr_ctnt04.value = "";				
				
				if (tabIndex == 0) {
         			formObj.scg_flg.value = "DG";
         		}else if (tabIndex == 1) {
         			formObj.scg_flg.value = "AW";
         		}else if (tabIndex == 2) {
         			formObj.scg_flg.value = "BB";
         		}else if (tabIndex == 3) {
         			formObj.scg_flg.value = "OT";
         		}
				
				var xmlStr = sheetObjects[6].GetSearchXml("VOP_SCG_0080GS.do", FormQueryString(formObj)).split("|$$|");
				sheetObjects[6].DataInsert(-1,0);				
				sheetObjects[6].CellValue(1, "msg_hdr_ctnt") = ComGetEtcData(xmlStr[0], "msg_hdr_ctnt");
				formObj.msg_hdr_ctnt.value = sheetObjects[6].CellValue(1, "msg_hdr_ctnt");
				
				if (sheetObjects[6].CellValue(1, "msg_hdr_ctnt") = "") {
					formObj.hdr_ctnt.value = "";
				}
				if (tabIndex == 0) {
         			sheetObjects[0].LoadSearchXml(xmlStr[0]);
         		}else if (tabIndex == 1) {
         			sheetObjects[2].LoadSearchXml(xmlStr[0]);
         		}else if (tabIndex == 2) {
         			sheetObjects[4].LoadSearchXml(xmlStr[0]);
         		}else if (tabIndex == 3) {
         			sheetObjects[9].LoadSearchXml(xmlStr[0]);
         		}
				//ComOpenWait(false);
				break;
			
			case SEARCH01:      //조회(첨부파일)
				//ComOpenWait(true);
				formObj.f_cmd.value = SEARCH01;
				
				if (tabIndex == 0) {
         			formObj.scg_flg.value = "DG";
         		}else if (tabIndex == 1) {
         			formObj.scg_flg.value = "AW";
         		}else if (tabIndex == 2) {
         			formObj.scg_flg.value = "BB";
         		}else if (tabIndex == 3) {
         			formObj.scg_flg.value = "OT";
         		}
				
				var xmlStr = sheetObj.GetSearchXml("VOP_SCG_0080GS.do", FormQueryString(formObj));				
				if (tabIndex == 0) {
         			sheetObjects[1].LoadSearchXml(xmlStr);
         		}else if (tabIndex == 1) {
         			sheetObjects[3].LoadSearchXml(xmlStr);
         		}else if (tabIndex == 2) {
         			sheetObjects[5].LoadSearchXml(xmlStr);
         		}else if (tabIndex == 3) {
         			sheetObjects[10].LoadSearchXml(xmlStr);
         		}
				//ComOpenWait(false);
				break;
			
			
			case SEARCH14:      //조회(첨부파일)
				//ComOpenWait(true);
//				formObj.f_cmd.value = SEARCH14;				
//				var xmlStr = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", "f_cmd=" + SEARCH14 + "&pgmNo=" + formObj.pgm_no.value);
//				var user_role_cd = ComGetEtcData(xmlStr, "user_role_cd");   //role code 에 상관없이 creation 메뉴 권한으로 저장 권한 부여
				
//					ComBtnDisable("btn_save");
					ComBtnDisable("btn1_row_delete");
					ComBtnDisable("btn2_row_delete");
					ComBtnDisable("btn3_row_delete");
					ComBtnDisable("btn1_addrow");
					ComBtnDisable("btn2_addrow");
					ComBtnDisable("btn3_addrow");
					ComBtnDisable("btn1_addfile_row");
					ComBtnDisable("btn2_addfile_row");
					ComBtnDisable("btn3_addfile_row");
					ComBtnDisable("btn1_addfile_delete");
					ComBtnDisable("btn2_addfile_delete");
					ComBtnDisable("btn3_addfile_delete");
					ComBtnDisable("btn4_row_delete");
					ComBtnDisable("btn4_addrow");
					ComBtnDisable("btn4_addfile_row");
					ComBtnDisable("btn4_addfile_delete");					

				//ComOpenWait(false);
				break;

			case IBSAVE:        //저장
                	ComOpenWait(true);
					sheetObjects[7].removeAll();

    				var scg_flg = null;
         			formObj.f_cmd.value = MULTI;
					
					sheetObjects[6].removeAll();
					sheetObjects[6].DataInsert(-1,0);
					sheetObjects[6].CellValue(1, "msg_hdr_ctnt") = formObj.msg_hdr_ctnt.value;
					
			        if (tabIndex == 0) {
             			scg_flg = "DG";
             		}else if (tabIndex == 1) {
             			scg_flg = "AW";
             		}else if (tabIndex == 2) {
             			scg_flg = "BB";
             		}else if (tabIndex == 3) {
             			scg_flg = "OT";
             		}
			        
					if (formObj.msg_hdr_ctnt.value.length > 4000) {
						ComShowCodeMessage('SCG50034', '');
                		ComOpenWait(false);
						return;
					}
					
         			var sParam = ComGetSaveString(sheetObjects[6]);
         			if (sParam == "") {						
	                	ComOpenWait(false);
						return;
					}
         							
                    var sParam = ComSetPrifix(sheetObjects[6].GetSaveString(), "sheet6_");
                    sheetObjects[6].LoadSaveXml(sheetObjects[6].GetSaveXml("VOP_SCG_0080GS.do", sParam + "&f_cmd=" + MULTI + "&" + ComGetPrefixParam("sheet6_")));
                    
					//TAB 상세정보 부분					
					//Dg
					if (sheetObjects[0].RowCount > 0) {
						for(var i=1; i<sheetObjects[0].Rows; i++) {
							var addRow = sheetObjects[7].DataInsert();
							//I,U,D 구분 코드 셋팅
							if (sheetObjects[0].CellValue(i, "ibflag") == "I") {
								sheetObjects[7].CellValue(addRow, "iud_flg") = "I";
							} else if (sheetObjects[0].CellValue(i, "ibflag") == "U") {
								sheetObjects[7].CellValue(addRow, "iud_flg") = "U";
							} else if (sheetObjects[0].CellValue(i, "ibflag") == "D") {
								sheetObjects[7].CellValue(addRow, "iud_flg") = "D";
							}
							sheetObjects[7].CellValue(addRow, "upd_usr_id") = formObj.upd_usr_id.value;
							sheetObjects[7].CellValue(addRow, "hdr_ctnt") = sheetObjects[0].CellValue(i, "hdr_ctnt");
							sheetObjects[7].CellValue(addRow, "spcl_cgo_guid_seq") = sheetObjects[0].CellValue(i, "spcl_cgo_guid_seq");
							sheetObjects[7].CellValue(addRow, "ftr_ctnt") = sheetObjects[0].CellValue(i, "ftr_ctnt");
							sheetObjects[7].CellValue(addRow, "spcl_cgo_guid_cd") = "DG";
						}
					}
					//Awkward
					if (sheetObjects[2].RowCount > 0) {
						for(var i=1; i<sheetObjects[2].Rows; i++) {
							var addRow = sheetObjects[7].DataInsert();
							
							//I,U,D 구분 코드 셋팅
							if (sheetObjects[2].CellValue(i, "ibflag") == "I") {
								sheetObjects[7].CellValue(addRow, "iud_flg") = "I";
							}
							if (sheetObjects[2].CellValue(i, "ibflag") == "U") {
								sheetObjects[7].CellValue(addRow, "iud_flg") = "U";
							}
							if (sheetObjects[2].CellValue(i, "ibflag") == "D") {
								sheetObjects[7].CellValue(addRow, "iud_flg") = "D";
							}
							sheetObjects[7].CellValue(addRow, "upd_usr_id") = formObj.upd_usr_id.value;
							sheetObjects[7].CellValue(addRow, "hdr_ctnt") = sheetObjects[2].CellValue(i, "hdr_ctnt");
							sheetObjects[7].CellValue(addRow, "spcl_cgo_guid_seq") = sheetObjects[2].CellValue(i, "spcl_cgo_guid_seq");
							sheetObjects[7].CellValue(addRow, "ftr_ctnt") = sheetObjects[2].CellValue(i, "ftr_ctnt");
							sheetObjects[7].CellValue(addRow, "spcl_cgo_guid_cd") = "AW";
						}
					}
					//BB
					if (sheetObjects[4].RowCount > 0) {
						for(var i=1; i<sheetObjects[4].Rows; i++) {
							var addRow = sheetObjects[7].DataInsert();
							
							//I,U,D 구분 코드 셋팅
							if (sheetObjects[4].CellValue(i, "ibflag") == "I") {
								sheetObjects[7].CellValue(addRow, "iud_flg") = "I";
							}
							if (sheetObjects[4].CellValue(i, "ibflag") == "U") {
								sheetObjects[7].CellValue(addRow, "iud_flg") = "U";
							}
							if (sheetObjects[4].CellValue(i, "ibflag") == "D") {
								sheetObjects[7].CellValue(addRow, "iud_flg") = "D";
							}
							sheetObjects[7].CellValue(addRow, "upd_usr_id") = formObj.upd_usr_id.value;
							sheetObjects[7].CellValue(addRow, "hdr_ctnt") = sheetObjects[4].CellValue(i, "hdr_ctnt");
							sheetObjects[7].CellValue(addRow, "spcl_cgo_guid_seq") = sheetObjects[4].CellValue(i, "spcl_cgo_guid_seq");
							sheetObjects[7].CellValue(addRow, "ftr_ctnt") = sheetObjects[4].CellValue(i, "ftr_ctnt");
							sheetObjects[7].CellValue(addRow, "spcl_cgo_guid_cd") = "BB";
						}
					}
					
					//Others
					if (sheetObjects[9].RowCount > 0) {
						for(var i=1; i<sheetObjects[9].Rows; i++) {
							var addRow = sheetObjects[7].DataInsert();
							
							//I,U,D 구분 코드 셋팅
							if (sheetObjects[9].CellValue(i, "ibflag") == "I") {
								sheetObjects[7].CellValue(addRow, "iud_flg") = "I";
							}
							if (sheetObjects[9].CellValue(i, "ibflag") == "U") {
								sheetObjects[7].CellValue(addRow, "iud_flg") = "U";
							}
							if (sheetObjects[9].CellValue(i, "ibflag") == "D") {
								sheetObjects[7].CellValue(addRow, "iud_flg") = "D";
							}
							sheetObjects[7].CellValue(addRow, "upd_usr_id") = formObj.upd_usr_id.value;
							sheetObjects[7].CellValue(addRow, "hdr_ctnt") = sheetObjects[9].CellValue(i, "hdr_ctnt");
							sheetObjects[7].CellValue(addRow, "spcl_cgo_guid_seq") = sheetObjects[9].CellValue(i, "spcl_cgo_guid_seq");
							sheetObjects[7].CellValue(addRow, "ftr_ctnt") = sheetObjects[9].CellValue(i, "ftr_ctnt");
							sheetObjects[7].CellValue(addRow, "spcl_cgo_guid_cd") = "OT";
							
						}
					}
					
					
					var sParamNoneFile3 = ComSetPrifix(sheetObjects[7].GetSaveString(), "sheet7_");
                    sheetObjects[7].LoadSaveXml(sheetObjects[7].GetSaveXml("VOP_SCG_0080GS.do", sParamNoneFile3 + "&f_cmd=" + MULTI01 + "&" + ComGetPrefixParam("sParamNoneFile3")));
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					////////첨부파일 시작
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					//0. 첨부파일 정보 다시한번 담는작업
					//Dg			
					for(i=1,j=0; i<=sheetObjects[1].RowCount; i++){
						if (sheetObjects[1].CellValue(i, "file_nm") != "") {
							if ((sheetObjects[1].CellValue(i, "ibflag") == "I") || (sheetObjects[1].CellValue(i, "ibflag") == "D")) {
								var addRow = sheetObjects[8].DataInsert();
								sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_atch_file_seq") = sheetObjects[1].CellValue(i, "spcl_cgo_guid_atch_file_seq");
								sheetObjects[8].CellValue(addRow, "file_sav_id") = sheetObjects[1].CellValue(i, "file_sav_id");
								sheetObjects[8].CellValue(addRow, "file_nm") = sheetObjects[1].CellValue(i, "file_nm");
								sheetObjects[8].CellValue(addRow, "file_set_yn") = sheetObjects[1].CellValue(i, "file_set_yn");
								sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_seq") = sheetObjects[1].CellValue(i, "spcl_cgo_guid_seq");
						        sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_cd") = "DG";
								
								if (sheetObjects[1].CellValue(i, "ibflag") == "I") {
									sheetObjects[8].CellValue(addRow, "iud_flg") = "I";
								} else if (sheetObjects[1].CellValue(i, "ibflag") == "D") {
									sheetObjects[8].CellValue(addRow, "iud_flg") = "D";
								}
							}
						}
		        	}
					
					//Awkward
					for(i=1,j=0; i<=sheetObjects[3].RowCount; i++){
						if (sheetObjects[3].CellValue(i, "file_nm") != "") {					
							if ((sheetObjects[3].CellValue(i, "ibflag") == "I") || (sheetObjects[3].CellValue(i, "ibflag") == "D")) {
								var addRow = sheetObjects[8].DataInsert();
								sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_atch_file_seq") = sheetObjects[3].CellValue(i, "spcl_cgo_guid_atch_file_seq");
								sheetObjects[8].CellValue(addRow, "file_sav_id") = sheetObjects[3].CellValue(i, "file_sav_id");
								sheetObjects[8].CellValue(addRow, "file_nm") = sheetObjects[3].CellValue(i, "file_nm");
								sheetObjects[8].CellValue(addRow, "file_set_yn") = sheetObjects[3].CellValue(i, "file_set_yn");
								sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_seq") = sheetObjects[3].CellValue(i, "spcl_cgo_guid_seq");
								sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_cd") = "AW";
								
								if (sheetObjects[3].CellValue(i, "ibflag") == "I") {
									sheetObjects[8].CellValue(addRow, "iud_flg") = "I";
								} else if (sheetObjects[3].CellValue(i, "ibflag") == "D") {
									sheetObjects[8].CellValue(addRow, "iud_flg") = "D";
								}
							}
						}
		        	}
					
					//BB					
					for(i=1,j=0; i<=sheetObjects[5].RowCount; i++){
						if ((sheetObjects[5].CellValue(i, "ibflag") == "I") || (sheetObjects[5].CellValue(i, "ibflag") == "D")) {
							if (sheetObjects[5].CellValue(i, "file_nm") != "") {
								var addRow = sheetObjects[8].DataInsert();
								sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_atch_file_seq") = sheetObjects[5].CellValue(i, "spcl_cgo_guid_atch_file_seq");
								sheetObjects[8].CellValue(addRow, "file_sav_id") = sheetObjects[5].CellValue(i, "file_sav_id");
								sheetObjects[8].CellValue(addRow, "file_nm") = sheetObjects[5].CellValue(i, "file_nm");
								sheetObjects[8].CellValue(addRow, "file_set_yn") = sheetObjects[5].CellValue(i, "file_set_yn");
								sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_seq") = sheetObjects[5].CellValue(i, "spcl_cgo_guid_seq");
								sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_cd") = "BB";
								
								if (sheetObjects[5].CellValue(i, "ibflag") == "I") {
									sheetObjects[8].CellValue(addRow, "iud_flg") = "I";
								} else if (sheetObjects[5].CellValue(i, "ibflag") == "D") {
									sheetObjects[8].CellValue(addRow, "iud_flg") = "D";
								}
							}
						}
		        	}
					
					//Others				
					for(i=1,j=0; i<=sheetObjects[10].RowCount; i++){
						if ((sheetObjects[10].CellValue(i, "ibflag") == "I") || (sheetObjects[10].CellValue(i, "ibflag") == "D")) {
							if (sheetObjects[10].CellValue(i, "file_nm") != "") {
								var addRow = sheetObjects[8].DataInsert();
								sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_atch_file_seq") = sheetObjects[10].CellValue(i, "spcl_cgo_guid_atch_file_seq");
								sheetObjects[8].CellValue(addRow, "file_sav_id") = sheetObjects[10].CellValue(i, "file_sav_id");
								sheetObjects[8].CellValue(addRow, "file_nm") = sheetObjects[10].CellValue(i, "file_nm");
								sheetObjects[8].CellValue(addRow, "file_set_yn") = sheetObjects[10].CellValue(i, "file_set_yn");
								sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_seq") = sheetObjects[10].CellValue(i, "spcl_cgo_guid_seq");
								sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_cd") = "OT";
								
								if (sheetObjects[10].CellValue(i, "ibflag") == "I") {
									sheetObjects[8].CellValue(addRow, "iud_flg") = "I";
								} else if (sheetObjects[10].CellValue(i, "ibflag") == "D") {
									sheetObjects[8].CellValue(addRow, "iud_flg") = "D";
								}
								
							}
						}
		        	}
					
					
					if (sheetObjects[8].RowCount > 0) {
						//1.IBUpload에 파일 추가하기
						var upObj = uploadObjects[0];	
						upObj.Files="";					//먼저기존파일을 모두 지운후 추가함
						setFileUpload(sheetObjects[8], upObj);	//Sheet의 추가 파일정보를 IBUpload로 Copy
						if (upObj.LocalFiles != "") {
							//파일이 있는 경우 IBUpload 이용하기
	
							//2.IBSheet 데이터 QueryString으로 묶기
							var sParamF = ComSetPrifix(sheetObjects[8].GetSaveString(), "sheet8_");
							if (sParamF == "") return;

							//3.Form 데이터 QueryString으로 묶기	
							formObj.f_cmd.value = MULTI01;
							sParamF += "&" + FormQueryString(formObj);
							ComOpenWait(true, true);	//키보드나 마우스를 대기상태 & 대기이미지
							
							//4. 서버에 request전달하고, reponse 받기
							upObj.ExtendParam = sParamF;
							upObj.ParamDecoding = true;
							var saveXml2 = upObj.DoUpload(true);
							//alert(saveXml2);
						} else {
							//첨부파일이 없는 경우엔 일반 저장 처리
							var sParamNoneFile = ComSetPrifix(sheetObjects[8].GetSaveString(), "sheet8_");
                    		sheetObjects[8].LoadSaveXml(sheetObjects[8].GetSaveXml("VOP_SCG_0080GS.do", sParamNoneFile + "&f_cmd=" + MULTI01 + "&" + ComGetPrefixParam("sParamNoneFile")));
						}
							
					}
					//첨부파일 끝!!!
					sheetObjects[8].removeAll();
					formObj.chk_file.value = '';
					
					if (tabIndex == "0") {
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
					} else if (tabIndex == "1") {
						doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);			
					} else if (tabIndex == "2") {
						doActionIBSheet(sheetObjects[4],document.form,IBSEARCH);			
					} else if (tabIndex == "3") {
						doActionIBSheet(sheetObjects[9],document.form,IBSEARCH);			
					}
                	ComOpenWait(false);
         		break;
        }
    }
    
    /**
     * Sheet 조회완료 후 이벤트 발생
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			document.form.ftr_ctnt01.value = sheetObj.Cellvalue(1, "ftr_ctnt");
			document.form.spcl_cgo_guid_seq.value = sheetObj.Cellvalue(1, "spcl_cgo_guid_seq");
			doActionIBSheet(sheetObj,document.form,SEARCH01);
		}
	}
		
    /**
     * Sheet 조회완료 후 이벤트 발생
     */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			document.form.ftr_ctnt02.value = sheetObj.Cellvalue(1, "ftr_ctnt");
			document.form.spcl_cgo_guid_seq.value = sheetObj.Cellvalue(1, "spcl_cgo_guid_seq");
			doActionIBSheet(sheetObj,document.form,SEARCH01);
		}
	}
	
    /**
     * Sheet 조회완료 후 이벤트 발생
     */
    function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			document.form.ftr_ctnt03.value = sheetObj.Cellvalue(1, "ftr_ctnt");
			document.form.spcl_cgo_guid_seq.value = sheetObj.Cellvalue(1, "spcl_cgo_guid_seq");
			doActionIBSheet(sheetObj,document.form,SEARCH01);
		}
	}
     
     /**
     * Sheet 조회완료 후 이벤트 발생
     */
    function sheet10_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			document.form.ftr_ctnt04.value = sheetObj.Cellvalue(1, "ftr_ctnt");
			document.form.spcl_cgo_guid_seq.value = sheetObj.Cellvalue(1, "spcl_cgo_guid_seq");
			doActionIBSheet(sheetObj,document.form,SEARCH01);
		}
	} 
    
    
    /**
     * Sheet 저장완료 후 이벤트 발생
     */
    function sheet8_OnSaveEnd(sheetObj, ErrMsg)  {
    	sheetObj.removeAll();
    }
	
	/**
	 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
	 * @param {ibsheet}   sheetObj    IBSheet Object
	 * @param {ibupload}  upObj    	  IBUpload Object
	 **/
	function setFileUpload(sheetObj, upObj) {	
		for (var rowIdx=1; rowIdx<=sheetObj.RowCount; rowIdx++){ 
			var fileSetYn = sheetObj.CellValue(rowIdx, "file_set_yn");
			//파일 경로 가져오기
			if(fileSetYn == 'Y') {
				var sFile = sheetObj.CellValue(rowIdx, "file_sav_id");		
				if (sFile=="") ComShowCodeMessage('SCG50004', 'Data');	//'{?msg1} is not available.'
				//IBUpload에 파일 추가하기
				var ret = upObj.AddFile(sFile);
			}
		}
		return; 
	}
	
	/////////////////////File DownLoad
	//DG
	function sheet2_OnDblClick(sheetObj, Row, Col, Value){
		file_open (sheetObj, Row, Col, Value);
	}
	//Awkward
	function sheet4_OnDblClick(sheetObj, Row, Col, Value){
		file_open (sheetObj, Row, Col, Value);
	}
	//BB
	function sheet6_OnDblClick(sheetObj, Row, Col, Value){
		file_open (sheetObj, Row, Col, Value);
	}
	//Others
	function sheet11_OnDblClick(sheetObj, Row, Col, Value){
		file_open (sheetObj, Row, Col, Value);
	}
	
	function file_open(sheetObj, Row, Col, Value){		
		if (sheetObj.ColSaveName(Col) != "file_nm") 
			return;
		//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
		if(sheetObj.CellText(Row, "file_nm") == "" 
			|| sheetObj.RowStatus(Row) == "I" 
			|| sheetObj.CellValue(Row, "file_set_yn") == "Y") {			
			selectFile(sheetObj, false);			
			return;
		}
		parent.location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, "file_sav_id");
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
		
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
	
	/**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Dangerous Cargo (DG)" , -1 );
                    InsertTab( cnt++ , "Awkward" , -1 );
                    InsertTab( cnt++ , "Break Bulk" , -1 );
                    InsertTab( cnt++ , "Others" , -1 );                    
                }
                break;
        }
    }
	
	
	/**
     * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        with (sheetObj) {
			document.form.ftr_ctnt01.value = sheetObj.Cellvalue(Row, "ftr_ctnt");
			document.form.spcl_cgo_guid_seq.value = sheetObj.Cellvalue(Row, "spcl_cgo_guid_seq");
			
			for(i=1,j=0; i<=sheetObjects[1].RowCount; i++){
				if (sheetObjects[1].CellValue(i, "file_nm") != "") {
					if ((sheetObjects[1].CellValue(i, "ibflag") == "I") || (sheetObjects[1].CellValue(i, "ibflag") == "D")) {
						var addRow = sheetObjects[8].DataInsert();
						sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_atch_file_seq") = sheetObjects[1].CellValue(i, "spcl_cgo_guid_atch_file_seq");
						sheetObjects[8].CellValue(addRow, "file_sav_id") = sheetObjects[1].CellValue(i, "file_sav_id");
						sheetObjects[8].CellValue(addRow, "file_nm") = sheetObjects[1].CellValue(i, "file_nm");
						sheetObjects[8].CellValue(addRow, "file_set_yn") = sheetObjects[1].CellValue(i, "file_set_yn");
						sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_seq") = sheetObjects[1].CellValue(i, "spcl_cgo_guid_seq");
				        sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_cd") = "DG";
						
						if (sheetObjects[1].CellValue(i, "ibflag") == "I") {
							sheetObjects[8].CellValue(addRow, "iud_flg") = "I";
						} else if (sheetObjects[1].CellValue(i, "ibflag") == "D") {
							sheetObjects[8].CellValue(addRow, "iud_flg") = "D";
						}
					}
				}
        	}
			doActionIBSheet(sheetObj,document.form,SEARCH01);
        }
    }
	
	
	/**
     * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet3_OnDblClick(sheetObj, Row, Col) {
        with (sheetObj) {
			document.form.ftr_ctnt02.value = sheetObj.Cellvalue(Row, "ftr_ctnt");
			document.form.spcl_cgo_guid_seq.value = sheetObj.Cellvalue(Row, "spcl_cgo_guid_seq");
			for(i=1,j=0; i<=sheetObjects[3].RowCount; i++){
				if (sheetObjects[3].CellValue(i, "file_nm") != "") {					
					if ((sheetObjects[3].CellValue(i, "ibflag") == "I") || (sheetObjects[3].CellValue(i, "ibflag") == "D")) {
						var addRow = sheetObjects[8].DataInsert();
						sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_atch_file_seq") = sheetObjects[3].CellValue(i, "spcl_cgo_guid_atch_file_seq");
						sheetObjects[8].CellValue(addRow, "file_sav_id") = sheetObjects[3].CellValue(i, "file_sav_id");
						sheetObjects[8].CellValue(addRow, "file_nm") = sheetObjects[3].CellValue(i, "file_nm");
						sheetObjects[8].CellValue(addRow, "file_set_yn") = sheetObjects[3].CellValue(i, "file_set_yn");
						sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_seq") = sheetObjects[3].CellValue(i, "spcl_cgo_guid_seq");
						sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_cd") = "AW";
						
						if (sheetObjects[3].CellValue(i, "ibflag") == "I") {
							sheetObjects[8].CellValue(addRow, "iud_flg") = "I";
						} else if (sheetObjects[3].CellValue(i, "ibflag") == "D") {
							sheetObjects[8].CellValue(addRow, "iud_flg") = "D";
						}
					}
				}
        	}
			doActionIBSheet(sheetObj,document.form,SEARCH01);
        }
    }
	
	
	/**
     * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet5_OnDblClick(sheetObj, Row, Col) {
        with (sheetObj) {
			document.form.ftr_ctnt03.value = sheetObj.Cellvalue(Row, "ftr_ctnt");
			document.form.spcl_cgo_guid_seq.value = sheetObj.Cellvalue(Row, "spcl_cgo_guid_seq");
			for(i=1,j=0; i<=sheetObjects[5].RowCount; i++){
				if ((sheetObjects[5].CellValue(i, "ibflag") == "I") || (sheetObjects[5].CellValue(i, "ibflag") == "D")) {
					if (sheetObjects[5].CellValue(i, "file_nm") != "") {
						var addRow = sheetObjects[8].DataInsert();
						sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_atch_file_seq") = sheetObjects[5].CellValue(i, "spcl_cgo_guid_atch_file_seq");
						sheetObjects[8].CellValue(addRow, "file_sav_id") = sheetObjects[5].CellValue(i, "file_sav_id");
						sheetObjects[8].CellValue(addRow, "file_nm") = sheetObjects[5].CellValue(i, "file_nm");
						sheetObjects[8].CellValue(addRow, "file_set_yn") = sheetObjects[5].CellValue(i, "file_set_yn");
						sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_seq") = sheetObjects[5].CellValue(i, "spcl_cgo_guid_seq");
						sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_cd") = "BB";
						
						if (sheetObjects[5].CellValue(i, "ibflag") == "I") {
							sheetObjects[8].CellValue(addRow, "iud_flg") = "I";
						} else if (sheetObjects[5].CellValue(i, "ibflag") == "D") {
							sheetObjects[8].CellValue(addRow, "iud_flg") = "D";
						}
					}
				}
        	}
			doActionIBSheet(sheetObj,document.form,SEARCH01);
        }
    }
     
  	/**
      * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
      * @param {sheetObj} String : 해당 IBSheet Object
      * @param {Row} Long : 해당 셀의 Row Index
      * @param {Col} Long : 해당 셀의 Column Index
      */
     function sheet10_OnDblClick(sheetObj, Row, Col) {
         with (sheetObj) {
 			document.form.ftr_ctnt04.value = sheetObj.Cellvalue(Row, "ftr_ctnt");
 			document.form.spcl_cgo_guid_seq.value = sheetObj.Cellvalue(Row, "spcl_cgo_guid_seq");
 			for(i=1,j=0; i<=sheetObjects[10].RowCount; i++){
 				if ((sheetObjects[10].CellValue(i, "ibflag") == "I") || (sheetObjects[10].CellValue(i, "ibflag") == "D")) {
 					if (sheetObjects[10].CellValue(i, "file_nm") != "") {
 						var addRow = sheetObjects[8].DataInsert();
 						sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_atch_file_seq") = sheetObjects[10].CellValue(i, "spcl_cgo_guid_atch_file_seq");
 						sheetObjects[8].CellValue(addRow, "file_sav_id") = sheetObjects[10].CellValue(i, "file_sav_id");
 						sheetObjects[8].CellValue(addRow, "file_nm") = sheetObjects[10].CellValue(i, "file_nm");
 						sheetObjects[8].CellValue(addRow, "file_set_yn") = sheetObjects[10].CellValue(i, "file_set_yn");
 						sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_seq") = sheetObjects[10].CellValue(i, "spcl_cgo_guid_seq");
 						sheetObjects[8].CellValue(addRow, "spcl_cgo_guid_cd") = "OT";
 						
 						if (sheetObjects[10].CellValue(i, "ibflag") == "I") {
 							sheetObjects[8].CellValue(addRow, "iud_flg") = "I";
 						} else if (sheetObjects[10].CellValue(i, "ibflag") == "D") {
 							sheetObjects[8].CellValue(addRow, "iud_flg") = "D";
 						}
 					}
 				}
         	}
 			doActionIBSheet(sheetObj,document.form,SEARCH01);
         }
     } 
     
		
	function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        var sheetObj = sheetObjects[0];
        var sheetObj2 = sheetObjects[2];
        var sheetObj4 = sheetObjects[4];
        var sheetObj10 = sheetObjects[9];
		var sRow = sheetObj.SelectRow;
        with (document.form) {
            switch (elementName) {

                case "ftr_ctnt01":
				   sheetObj.Cellvalue(sheetObj.SelectRow, "ftr_ctnt") = document.form.ftr_ctnt01.value;
                    break;
                case "ftr_ctnt02":
				   sheetObj2.Cellvalue(sheetObj2.SelectRow, "ftr_ctnt") = document.form.ftr_ctnt02.value;
                    break;
                case "ftr_ctnt03":
				   sheetObj4.Cellvalue(sheetObj4.SelectRow, "ftr_ctnt") = document.form.ftr_ctnt03.value;
                    break;
                case "ftr_ctnt04":
                   sheetObj10.Cellvalue(sheetObj10.SelectRow, "ftr_ctnt") = document.form.ftr_ctnt04.value;
                    break;                     
            }
        }
    }
	
	
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     * (***** 기본 Event (중요) *****)
     */
    function tab1_OnChange(tabObj, nItem) {
		tabIndex = nItem;				
        var objs = document.all.item("tabLayer");        
        objs[nItem].style.display = "Inline"; 
        
      //ComOpenWait(true); 
		
		//신규데이터있는 경우 저장여부 메세지
		if (beforetab == "0") {
			for(i=1,j=0; i<=sheetObjects[0].RowCount; i++){
				if ((sheetObjects[0].CellValue(i, "ibflag") == "I") || (sheetObjects[0].CellValue(i, "ibflag") == "D")) {
					if(ComShowCodeConfirm('SCG50003', '')) {
						doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
						return true;
					}
				}
        	}
			for(i=1,j=0; i<=sheetObjects[1].RowCount; i++){
				if (sheetObjects[1].CellValue(i, "file_nm") != "") {
					if ((sheetObjects[1].CellValue(i, "ibflag") == "I") || (sheetObjects[1].CellValue(i, "ibflag") == "D")) {
						if(ComShowCodeConfirm('SCG50003', '')) {
							doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
							return true;
						}
					}
				}
        	}
		} else if (beforetab == "1") {
			for(i=1,j=0; i<=sheetObjects[2].RowCount; i++){
				if ((sheetObjects[2].CellValue(i, "ibflag") == "I") || (sheetObjects[2].CellValue(i, "ibflag") == "D")) {
					if(ComShowCodeConfirm('SCG50003', '')) {
						doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
						return true;
					}
				}
        	}
			for(i=1,j=0; i<=sheetObjects[3].RowCount; i++){
				if (sheetObjects[3].CellValue(i, "file_nm") != "") {
					if ((sheetObjects[3].CellValue(i, "ibflag") == "I") || (sheetObjects[3].CellValue(i, "ibflag") == "D")) {
						if(ComShowCodeConfirm('SCG50003', '')) {
							doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
							return true;
						}
					}
				}
        	}			
		} else if (beforetab == "2") {
			for(i=1,j=0; i<=sheetObjects[4].RowCount; i++){
				if ((sheetObjects[4].CellValue(i, "ibflag") == "I") || (sheetObjects[4].CellValue(i, "ibflag") == "D")) {					
					if(ComShowCodeConfirm('SCG50003', '')) {
						doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
						return true;
					}
				}
        	}
			for(i=1,j=0; i<=sheetObjects[5].RowCount; i++){
				if (sheetObjects[5].CellValue(i, "file_nm") != "") {
					if ((sheetObjects[5].CellValue(i, "ibflag") == "I") || (sheetObjects[5].CellValue(i, "ibflag") == "D")) {
						if(ComShowCodeConfirm('SCG50003', '')) {
							doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
							return true;
						}
					}
				}
        	}	
		} else if (beforetab == "3") {
			for(i=1,j=0; i<=sheetObjects[9].RowCount; i++){
				if ((sheetObjects[9].CellValue(i, "ibflag") == "I") || (sheetObjects[9].CellValue(i, "ibflag") == "D")) {					
					if(ComShowCodeConfirm('SCG50003', '')) {
						doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
						return true;
					}
				}
        	}
			for(i=1,j=0; i<=sheetObjects[10].RowCount; i++){
				if (sheetObjects[10].CellValue(i, "file_nm") != "") {
					if ((sheetObjects[10].CellValue(i, "ibflag") == "I") || (sheetObjects[10].CellValue(i, "ibflag") == "D")) {
						if(ComShowCodeConfirm('SCG50003', '')) {
							doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
							return true;
						}
					}
				}
        	}	
		}
		
        objs[beforetab].style.display = "none";        
        objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1;
        beforetab = nItem;        
		
		//탭 이동 시 자동 조회
		if (tabIndex == "0") {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
		} else if (tabIndex == "1") {
			doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);			
		} else if (tabIndex == "2") {
			doActionIBSheet(sheetObjects[4],document.form,IBSEARCH);			
		} else if (tabIndex == "3") {
			doActionIBSheet(sheetObjects[9],document.form,IBSEARCH);			
		}
		
		document.form.chk_file.value = '';		
		//ComOpenWait(false);
    }
	
	
    /**
     * 저장 후 stv_dmg_no 가져오기..
     */
    function setStvDmgNo(sheetObj, stvDmgNoList){
    	if(!isNull(stvDmgNoList)){
    		var stvDmgNoS = stvDmgNoList.split("|");
        	
        	for(i=1,j=0; i<=sheetObj.RowCount; i++){
            	if(sheetObj.RowStatus(i)=="I"){
            		sheetObj.CellValue2(i, "sheet1_stv_dmg_no") = stvDmgNoS[j++];
            		sheetObj.CellValue2(i, "sheet1_cre_usr_id") = userId;
            		sheetObj.CellValue2(i, "sheet1_cre_usr_ofc") = ofcCd;
            	}
        	}
        	document.form.stv_dmg_no.value = stvDmgNoS[0];
        	document.form.stv_dmg_no_prefix.value = stvDmgNoS[0].substring(0,4);
        	document.form.stv_dmg_no_suffix.value = stvDmgNoS[0].substring(4,11);
    	}
    }
    
	/* 개발자 작업  끝 */