/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESM_SPC_0119.js
*@FileTitle : Control Option Office List Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.02
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.03.02 
* 1.0 Creation. Control Option Office List Popup
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
     * @class ESM_SPC_0119 : ESM_SPC_0119 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	var trd_cd;
	var sub_trd_cd;
	var rlane_cd;
	var dir_cd;
	var aloc_ctrl_tp_cd;
	var ctrl_loc_acct_cd;
	var ofc_cd;

    function ESM_SPC_0119() {
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
    
    
    var dupDataColor = null;
    var errDataColor = null;
    var disableColor = null;
    var enableColor = null;
    var validUploadSave = false;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
    		    				
    			case "btn_ok":
//    				doActionIBSheet(sheetObject,formObject,IBSAVE);
//    				var selRow = sheetObject.SelectRow;
//        			var selValue = sheetObject.CellValue( selRow , "rgn_ofc_cd" );
//        			window.returnValue = selValue;
//        			window.close();
    				var sRow = sheetObject.FindCheckedRow("chk_ofc");
    				var aRow = sRow.split("|");
    				var result = "";

    				for( var x=0 ; x<aRow.length-1 ; x++ ) {
    					if( x == 0 )
    						result += sheetObject.CellValue(aRow[x] , "rgn_ofc_cd" );
    					else
    						result += "|" + sheetObject.CellValue(aRow[x] , "rgn_ofc_cd" );
    				}
    				
    				window.returnValue = result;
    				window.close();
    				break;
    				
    			case "btn_ok_all":
    				var sRow = sheetObject.FindCheckedRow("chk_ofc");
    				var aRow = sRow.split("|");
    				var result = "";

    				for( var x=0 ; x<aRow.length-1 ; x++ ) {
    					if( x == 0 )
    						result += sheetObject.CellValue(aRow[x] , "rgn_ofc_cd" );
    					else
    						result += "|" + sheetObject.CellValue(aRow[x] , "rgn_ofc_cd" );
    				}
    				
    				window.returnValue = "A|"+result;
    				window.close();
    				break;
    				
    			case "btn_close":
    				window.close();
    				break;

    		}
    	}catch(e) {
    		if( e == "[object Error]") {
    		      ComShowCodeMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	for(var i=0;i<sheetObjects.length;i++){
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	 var param = "f_cmd=" + SEARCHLIST04 + "&trd_cd=" + trd_cd + "&sub_trd_cd=" + sub_trd_cd + "&rlane_cd=" + rlane_cd + "&dir_cd=" + dir_cd + "&aloc_ctrl_tp_cd=" + aloc_ctrl_tp_cd+"&ctrl_loc_acct_cd="+ctrl_loc_acct_cd;
		   var today = new	Date();
		   var year  = today.getFullYear();
		   var month = today.getMonth()+1;
		   
		   var qtr = "";
		   if( month > 0 && month < 4 )
			   qtr = "1Q";
		   else if( month > 3 && month < 7 )
			   qtr = "2Q";
		   else if( month > 6 && month < 10 )
			   qtr = "3Q";
		   else 
			   qtr = "4Q";
		   param += "&bse_yr="+year+"&bse_qtr_cd="+qtr;
//		   alert( param );
		   //sheetObjects[0].DoSearch4Post("ESM_SPC_0052GS.do", param);
		   var sXml = sheetObjects[0].GetSearchXml( "ESM_SPC_0052GS.do", param );
		   if( sheetType == "" || sheetType != "null" ) {
			   sXml = sXml.replace("<TR>","<TR><![CDATA[☜☞☜☞☜☞☜☞☜☞☜☞☜☞☜☞☜☞☜☞☜☞☜☞☜☞☜☞☜☞☜☞☜☞Default]]></TR><TR>");
			   document.getElementById("btn_ok_all_frame").style.display="none";
		   }
		   sheetObjects[0].LoadSearchXml(sXml);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		switch(sheetNo) {
   			 case 1:      //sheet1 init
  				with (sheetObj) {
    				        				 
  					style.height = GetSheetHeight(7) ;// 높이 설정      					
  					SheetWidth = mainTable.clientWidth;//전체 너비 설정      					
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]

  					MergeSheet = msNone;//전체Merge 종류 [선택, Default msNone]
  					Editable = true;//전체Edit 허용 여부 [선택, Default false]
  					
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(3, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
  					InitHeadMode(true, false, false, false, false, false);     					

  					var HeadTitle  = "Sel | SEL |Office Code ";
  					InitHeadRow(0, HeadTitle, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					
  					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtRadioCheck,	30,    	daCenter,  		false,    	"radio",   					false,          "",	dfNone,		0,		true,       true);
 		            InitDataProperty(0, cnt++ , dtCheckBox,   	50,    daCenter,   false,    "chk_ofc",     	 	false,	"",       dfNone,   	0,    true,      true); //D2
 					InitDataProperty(0, cnt++, dtData, 40, daCenter,  true,     "rgn_ofc_cd",     	   false,  "",  dfNone,   		0, false, true);

 					HeadRowHeight = 20 ;
  			   	}
  				break;
		}

    }

    function sheet1_OnClick(sheetObj, row, col) {
    	var clickNm = sheetObj.ColSaveName(col);
    	
    	if( clickNm == "rgn_ofc_cd" ) {
			var selValue = sheetObj.CellValue( row , "rgn_ofc_cd" );
			window.returnValue = selValue;
			window.close();
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
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	if( ofc_cd != null && ofc_cd != '' ){
    		var ofc_arry = ofc_cd.split(",");
    		var cnt = sheetObj.RowCount+1;
    		for( var x=0 ; x<cnt ; x++ ) {
    			var cellv = sheetObj.CellValue( x , "rgn_ofc_cd" );
    			if( ofc_cd.indexOf( cellv ) > -1 ) {
    				sheetObj.CellValue( x , "chk_ofc" ) = "Y";
    			}
    		}
    	}
    }
    
	/* 개발자 작업  끝 */