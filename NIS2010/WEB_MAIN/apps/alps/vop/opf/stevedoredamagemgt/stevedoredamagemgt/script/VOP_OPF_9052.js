/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_9052.js
*@FileTitle : Claim Handling Office User Select
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.06
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2011.10.06 김민아
* 1.0 Creation
* 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가 - 담당자 선택 기능 추가 및 Auto mailing 기능 추가
* 2011.11.21 김민아 [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD 및 Port 설정 기능 변경
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
	 * @class vop_opf_9052 : vop_opf_9052 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_opf_9052() {
		this.doReturnValue			= doReturnValue;
		this.initSheet 				= initSheet;
		this.loadData				= loadData;
		this.loadMainData			= loadMainData;
		this.loadPage 				= loadPage;
		this.officeSearch			= officeSearch;
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
	}
    
   	/* 개발자 작업	*/


	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;
	var loadFlg = true;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 
		var sheetObject1 = sheetObjects[1];
		 
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
			
				case "btn_Search":
	        		if ( document.getElementById("search_text").value == "" ) return;	
	        		findXML(document.getElementById("search").value, document.getElementById("search_text").value);
	        		break;
	        		
            	case "btns_add":
            		var selrow = sheetObjects[0].SelectRow;
                    if ( selrow > 0 ){
                    	sheet1_OnDblClick("", "", "", "");
            		}     	        
            		break;

         	    case "btns_del":
         	    	var selrow = sheetObjects[1].SelectRow;
                    if ( selrow > 0 ){
                    	sheet2_OnDblClick("", "", "", "");
            		}    
         	    	break;

				case "btn_ok":
					doReturnValue(sheetObject1);
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
		for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
			
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
	                style.height = 322;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 2, 100);
	
	                var HeadTitle = "Name|Dept|Title||" ;
					var headCount = ComCountHeadTitle(HeadTitle);
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                //InitHeadMode(true, true, false, true, false,false);
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	                
	                //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtData,     120,   	daLeft,  	false,    	"NAME",        	false,          "",       dfNone,     0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,     130,    daCenter,   false,    	"TEAMNM",       false,          "",       dfNone,     0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,     0,    	daLeft,    	false,    	"BUJAE",        false,          "",       dfNone,     0,     false,       false);
	                InitDataProperty(0, cnt++ , dtHidden,   0,    	daCenter,  	false,    	"CN",       	false,          "",       dfNone,     0,     false,       false);
	                InitDataProperty(0, cnt++ , dtHidden,   0,    	daLeft,    	false,    	"MAIL",        false,          "",       dfNone,     0,     false,       false);
	                
	                CountPosition = 0;
	            }
	            break;
			   
			case "sheet2":      // sheet3 init
				with (sheetObj) {
					// 높이 설정
					style.height = 322;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 4, 100);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false);
					
					var HeadTitle = "";
					var headCount = 0;
					
					HeadTitle = "|1|Name|Dept|4|Title|6|7|8";
					headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
	
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix="sheet20_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,  daCenter,  true,    "Status");
					InitDataProperty(0, cnt++ , dtHidden,	20,		daCenter,	false,		prefix+"chk");
					InitDataProperty(0, cnt++ , dtData,		120,	daLeft,		false,		prefix+"clm_hndl_usr_nm",	false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	false,		prefix+"clm_hndl_ofc_nm",	false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	130,	daCenter,	false,		prefix+"clm_hndl_ofc_cd",	false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	20,		daLeft,		false,		prefix+"grd_eng_nm",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	20,		daCenter,	false,		prefix+"clm_hndl_usr_id",	false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	20,		daCenter,   false,      prefix+"clm_hndl_usr_eml",	false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	20,		daCenter,	false,		prefix+"dflt_eml",			false,	"",	dfNone,	0,	false,	false);
					
					CountPosition = 0;
			   }
			   break;
		}
	}
	
    function loadMainData(){
		//부모창 데이타 셋팅
		var sXml = dialogArguments.getSheetXml();
		sheetObjects[1].LoadSearchXml(sXml);
    }
    
    function sheet1_OnDblClick(sheetObj, row, col, value) {
    	var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
  
        var selrow = sheetObject1.SelectRow;
        if ( selrow > 0 )
        {
            var usr_id = sheetObject1.CellValue(selrow, "CN");
            var usr_nm = sheetObject1.CellValue(selrow, "NAME");
            var ofc_cd = sheetObject1.CellValue(selrow, "TEAMNM");
            var title = sheetObject1.CellValue(selrow, "BUJAE");
            var email = sheetObject1.CellValue(selrow, "MAIL");
            
            // Duplication(중복) 체크
            for(var i=0; i<sheetObject2.RowCount; i++) {
                if(sheetObject2.CellValue(i + 1, "sheet20_clm_hndl_usr_id") == usr_id) {
                    ComShowMessage(usr_id + " is already added");
                    return;
                }
            }
            
            // 대상 Sheet로 데이타 이행
            row = sheetObject2.DataInsert(0);
			sheetObject2.CellValue2(row, "sheet20_clm_hndl_usr_nm") =  usr_nm;
			sheetObject2.CellValue2(row, "sheet20_clm_hndl_ofc_nm") =  ofc_cd;            			
			sheetObject2.CellValue2(row, "sheet20_grd_eng_nm")  =  title; 
			sheetObject2.CellValue2(row, "sheet20_clm_hndl_usr_id") =  usr_id;
			sheetObject2.CellValue2(row, "sheet20_clm_hndl_usr_eml") =  email;
			
        }   
    }
    
    function sheet2_OnDblClick(sheetObj, row, col, value) {
    	var sheetObject2 = sheetObjects[1];
        var selrow = sheetObject2.SelectRow;
                    
        if(selrow > 0) {
            sheetObject2.RowDelete(selrow, false);
        }
    }

	function doReturnValue(sheetObj){

		//데이타 Copy
		var sXml = ComOpfSheet2Xml(sheetObjects[1]);
		dialogArguments.setSheetXml(sXml);
			
		window.returnValue = "O";
		window.close();
	}
	
    // OrganTree 로 부터 받은 HashMap 결과를 시트에 바인딩
    function loadData(data) {
    	var sheetObject = sheetObjects[0];

    	var sheetXml = "<SHEET><DATA COLSEPARATOR='|'>";
    	for( var i = 0 ; i < data.length ; i++ ) {
    		sheetXml += "<TR><![CDATA[";
    		sheetXml += data[i].getPos(1) + "|" + data[i].getPos(0) + "|" + data[i].getPos(7) + "|" + data[i].getPos(4) + "|" + data[i].getPos(2);
    		sheetXml += "]]></TR>";
    	}
    	
    	sheetObject.LoadSearchXml(sheetXml+"</DATA></SHEET>");
    	
    	if(loadFlg){
        	//부모창의 데이터 셋팅
        	loadMainData();
        	loadFlg = false;
    	}
     }
    
    // 소속 Office 자동 펼침 처리
    function officeSearch() {
	 	findXML('TEAMNM', document.getElementById("ofc_cd").value);
    }

    
	/* 개발자 작업  끝 */