/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0208.js
*@FileTitle : Bank Information 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.30 김진일
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
     * @class vop_pso_0208 : vop_pso_0208 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0208() {
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
    var usrOfcCd = "";/*SSO 유저의 office cd를 저장 */
    var sheetOutlineColors = new Array(4); //sheet마다의 이전 OutlineColor를 저정하기 위한 전역배열변수 
    var targetSheet = 2;//타겟sheet의 인덱스 변수 
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
    		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		
    		var sheetObject1 = sheetObjects[0];
    		var sheetObject2 = sheetObjects[1];
    		var sheetObject3 = sheetObjects[2];
    		var sheetObject4 = sheetObjects[3];
    		
    		/*******************************************************/
    		var formObject = document.form;
    		
    		try {
        		var srcName = window.event.srcElement.getAttribute("name");
        	       		
            	switch(srcName) {

    	          	case "btn1_OK":
    					doActionIBSheet(sheetObject1,formObject,IBSAVE);
    					//self.close();
    					comPopupOK();
    					break;
    	
    				case "btn1_Close":
    					self.close();
    					break;
    				case "btns_add":
    					/*Left의 현재 선택된 OBJECT ID*/
    					//alert(sheetObject1.selectRow);
    					//"/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
    					  var sRowStr = sheetObject1.GetSelectionRows("/");
    					  if(sRowStr==="0"||sRowStr==="") break;
    					  //자바 스크립트 배열로 만들기
    					  var arr = sRowStr.split("/");
    					  for (i=0; i<arr.length; i++) {
    					      //alert(arr[i] + " 행이 선택되었음");
    						  sheetObject1.CellValue2(parseInt(arr[i]), "hiddencheck") = "Y";
    						  switch (targetSheet){
      	                		case 2:
      	                			sheetObject1.CellValue2(parseInt(arr[i]), "sheet1_row_no") = "1";
      	                			break;
      	                		case 3:
      	                			sheetObject1.CellValue2(parseInt(arr[i]), "sheet1_row_no") = "2";
      	                			break;
      	                		case 4:
      	                			sheetObject1.CellValue2(parseInt(arr[i]), "sheet1_row_no") = "3";
      	                			break;
    						  }
    					  }

    	                var sTime = new Date();
    	                //ComSheet2SheetCheck(form.sheet1, form.sheet2, "hiddencheck");
    	                var sXml = ComMakeSearchXml(sheetObject1, false, "hiddencheck","sheet1_pso_obj_cd|sheet1_row_no|sheet1_obj_list_nm|sheet1_pso_meas_ut_cd|sheet1_obj_list_no|sheet1_pso_ofc_cd|sheet1_pso_obj_cd_dsp|sheet1_pso_meas_ut_cd_dsp", true);
    	                
    	                //alert(sXml);//alert(sXml.replace(/sheet1_/gi,"sheet2_"));
    	                //var eTime = new Date();
    	                //MsgAdd('ComSheet2SheetCheck(form.sheet1, form.sheet2, "hiddencheck")          ==> '   + (eTime-sTime)/1000);
    	                //sheetObject1.ColumnSort("sheet1_pso_obj_cd_dsp|sheet1_pso_meas_ut_cd_dsp", "ASC");	//[2010.03.11:jmh] Close
    	                switch (targetSheet){
    	                	case 2:
    	                		//sheetObject2.ColumnSort("sheet2_pso_obj_cd|sheet2_pso_meas_ut_cd", "ASC");
    	                		sheetObject2.LoadSearchXml(sXml.replace(/sheet1_/gi,"sheet2_"), true);
    	                		sheetObject2.ColumnSort("sheet2_pso_obj_cd_dsp|sheet2_pso_meas_ut_cd_dsp", "ASC");	//[2010.03.11:jmh] Add
    	                		break;
    	                	case 3:
    	                		//sheetObject3.ColumnSort("sheet3_pso_obj_cd|sheet3_pso_meas_ut_cd", "ASC");
    	                		sheetObject3.LoadSearchXml(sXml.replace(/sheet1_/gi,"sheet3_"), true);
    	                		sheetObject3.ColumnSort("sheet3_pso_obj_cd_dsp|sheet3_pso_meas_ut_cd_dsp", "ASC");	//[2010.03.11:jmh] Add
    	                		break;
    	                	case 4:
    	                		//sheetObject4.ColumnSort("sheet4_pso_obj_cd|sheet4_pso_meas_ut_cd", "ASC");
    	                		sheetObject4.LoadSearchXml(sXml.replace(/sheet1_/gi,"sheet4_"), true);
    	                		sheetObject4.ColumnSort("sheet4_pso_obj_cd_dsp|sheet4_pso_meas_ut_cd_dsp", "ASC");	//[2010.03.11:jmh] Add
    	                		break;
    	                	default : break;	
    	                }
    	                
    					break;
    				case "btns_del":
	    				var sRowStr= "";
	    				var sXml = "";
    	                var sTime = new Date();
    	                switch (targetSheet){
	    	                case 2:
	    	                	sRowStr= sheetObject2.GetSelectionRows("/");
	    	                	if(sheetObject2.RowCount==0||sRowStr==="") break;	//[2010.03.11:jmh] Modify
	    	                	//자바 스크립트 배열로 만들기
	    	                	var arr = sRowStr.split("/");
	    	                	for (i=0; i<arr.length; i++) {
	    	                		sheetObject2.CellValue2(parseInt(arr[i]), "hiddencheck") = "Y";
	    	                	}
	    	                	sXml=ComMakeSearchXml(sheetObject2, false, "hiddencheck","sheet2_pso_obj_cd|sheet2_obj_list_nm|sheet2_pso_meas_ut_cd|sheet2_obj_list_no|sheet2_pso_ofc_cd|sheet2_pso_obj_cd_dsp|sheet2_pso_meas_ut_cd_dsp", true)
	    	                	///sheetObject2.ColumnSort("sheet2_pso_obj_cd|sheet2_pso_meas_ut_cd", "ASC");	//[2010.03.11:jmh] Close
	    	                	sheetObject1.LoadSearchXml(sXml.replace(/sheet2_/gi,"sheet1_"), true);
	    	                	break;
	    	                case 3:
	    	                	sRowStr= sheetObject3.GetSelectionRows("/");
	    	                	if(sheetObject3.RowCount==0||sRowStr==="") break;	//[2010.03.11:jmh] Modify
	    	                	//자바 스크립트 배열로 만들기
	    	                	var arr = sRowStr.split("/");
	    	                	for (i=0; i<arr.length; i++) {
	    	                		sheetObject3.CellValue2(parseInt(arr[i]), "hiddencheck") = "Y";
	    	                	}
	    	                	sXml=ComMakeSearchXml(sheetObject3, false, "hiddencheck","sheet3_pso_obj_cd|sheet3_obj_list_nm|sheet3_pso_meas_ut_cd|sheet3_obj_list_no|sheet3_pso_ofc_cd|sheet3_pso_obj_cd_dsp|sheet3_pso_meas_ut_cd_dsp", true)
	    	                	///sheetObject3.ColumnSort("sheet3_pso_obj_cd|sheet3_pso_meas_ut_cd", "ASC");	//[2010.03.11:jmh] Close
	    	                	sheetObject1.LoadSearchXml(sXml.replace(/sheet3_/gi,"sheet1_"), true);
	    	                	break;
	    	                case 4:
	    	                	sRowStr= sheetObject4.GetSelectionRows("/");
	    	                	if(sheetObject4.RowCount==0||sRowStr==="") break;	//[2010.03.11:jmh] Modify
	    	                	//자바 스크립트 배열로 만들기
	    	                	var arr = sRowStr.split("/");
	    	                	for (i=0; i<arr.length; i++) {
	    	                		sheetObject4.CellValue2(parseInt(arr[i]), "hiddencheck") = "Y";
	    	                	}
	    	                	sXml=ComMakeSearchXml(sheetObject4, false, "hiddencheck","sheet4_pso_obj_cd|sheet4_obj_list_nm|sheet4_pso_meas_ut_cd|sheet4_obj_list_no|sheet4_pso_ofc_cd|sheet4_pso_obj_cd_dsp|sheet4_pso_meas_ut_cd_dsp", true)
	    	                	///sheetObject4.ColumnSort("sheet4_pso_obj_cd|sheet4_pso_meas_ut_cd", "ASC");	//[2010.03.11:jmh] Close
	    	                	sheetObject1.LoadSearchXml(sXml.replace(/sheet4_/gi,"sheet1_"), true);
	    	                	break;
	    	                default : break;	
    	              }
    	              sheetObject1.ColumnSort("sheet1_pso_obj_cd_dsp|sheet1_pso_meas_ut_cd_dsp", "ASC");  
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
    	
    	var formObject = document.form;
    	formObject.pso_ofc_cd.value = usrOfcCd; //ofc cd 설정.
    	
        for(i=0;i<sheetObjects.length;i++){

	        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            
	        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
            //alert(sheetObjects.length);
			//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }

        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

     }

//    function sheet4_OnLoadFinish(sheetObj) {
//    }

      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

          	var cnt = 0;
    		var sheetid = sheetObj.id;
    		
          	switch(sheetid) {

    			case "sheet1":
    				with (sheetObj) {
    					// 높이 설정
    					style.height = 510;
    					
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;

    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msHeaderOnly;

    					//전체Edit 허용 여부 [선택, Default false]
    					Editable = false;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo(1, 1, 3, 100);

    					var HeadTitle1 = "Status|CHK|Seq.|Subject Item|Subject Item|UOM|OBJLISTNO|OFCCD|ROWNO|hidden1|hidden2";
    					var headCount = ComCountHeadTitle(HeadTitle1);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(headCount, 0, 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					//InitHeadMode(true, true, false, true, false,false);

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle1, true);
    					var prefix = "sheet1_";
            			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
    					InitDataProperty(0, cnt++,  dtCheckBox,       0,    	daCenter,  	true,   "hiddencheck");
    					InitDataProperty(0, cnt++ , dtDataSeq,			40,		daCenter,	true);//,	prefix+"rn");
    					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"pso_obj_cd_dsp");
    					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,	prefix+"obj_list_nm");
    					InitDataProperty(0, cnt++ , dtData,			40,		daLeft,		true,	prefix+"pso_meas_ut_cd_dsp");
    					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	prefix+"obj_list_no");
    					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	prefix+"pso_ofc_cd");
    					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	prefix+"row_no");
    					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,	prefix+"pso_obj_cd");		//
    					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,	prefix+"pso_meas_ut_cd");	//
    					
    					CountPosition = 0;
    					
    					//SelectHighLight = true;
    					//SelectFontBold = true;
    					
    					SelectionMode = smSelectionList; //추가
    					ColHidden("hiddencheck") = true;	//[2010.03.11:jmh]
//    					ColHidden(prefix+"obj_list_no") = true;
//    					ColHidden(prefix+"pso_ofc_cd") = true;
//    					ColHidden(prefix+"row_no") = true;
    					//SelectHighLight = true
//    					SelectBackColor = RgbColor(255,255,192);

    					//FocusStyle = fsHeavy;

    					//RowHidden(5) = true; 
    					//FocusAfterProcess = false;

    					//1컬럼의 SaveName이 "stckCd"인 경우
    					//  mySheet.ColHidden("stckCd") = false

    					//SelectBackColor = RgbColor(255,0,0)

    				}
    				break;

    			case "sheet2":
    				with (sheetObj) {
    					// 높이 설정
    					style.height = 140;
    					
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;

    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msHeaderOnly;

    					//전체Edit 허용 여부 [선택, Default false]
    					Editable = false;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo(1, 1, 3, 100);

    					var HeadTitle1 = "|CHK|Seq.|Subject Item|Subject Item|UOM|OBJLISTNO|OFCCD|ROWNO|hidden1|hidden2";
    					var headCount = ComCountHeadTitle(HeadTitle1);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(headCount, 0, 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					//InitHeadMode(true, true, false, true, false,false);

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle1, true);

    					var prefix = "sheet2_";
            			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
//    					InitDataProperty(0, cnt++ , dtStatus,	40,		daCenter,	true,	prefix+"ibflag");
    					InitDataProperty(0, cnt++, dtCheckBox,      0,    	daCenter,  	true,  "hiddencheck");
    					InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	prefix+"rn");
    					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"pso_obj_cd_dsp");
    					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,	prefix+"obj_list_nm");
    					InitDataProperty(0, cnt++ , dtData,			40,		daLeft,		true,	prefix+"pso_meas_ut_cd_dsp");
    					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	prefix+"obj_list_no");
    					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	prefix+"pso_ofc_cd");
    					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	prefix+"row_no");
    					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,	prefix+"pso_obj_cd");		//
    					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,	prefix+"pso_meas_ut_cd");	//
    					
    					CountPosition = 0;
    					SelectionMode = smSelectionList; //추가
    					ColHidden("hiddencheck") = true;	//[2010.03.11:jmh] Close
    					//ColHidden(prefix+"rn") = true;
//    					ColHidden(prefix+"obj_list_no") = true;
//    					ColHidden(prefix+"pso_ofc_cd") = true;
//    					ColHidden(prefix+"row_no") = true;
//    					SelectBackColor = RgbColor(255,255,192);
    					
    					
    					//Sheet2 를 기본 타겟으로 설정..
    					if(sheetOutlineColors[1]==null)
    		        		sheetOutlineColors[1] = sheetObjects[1].SheetOutLineColor;
    		        	sheetObjects[1].SheetOutLineColor = sheetObjects[1].RgbColor(255,0,0);
    				}
    				break;

    			case "sheet3":
    				with (sheetObj) {
    				// 높이 설정
    					style.height = 140;
    					
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;

    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msHeaderOnly;

    					//전체Edit 허용 여부 [선택, Default false]
    					Editable = false;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo(1, 1, 3, 100);

    					var HeadTitle1 = "|CHK|Seq.|Subject Item|Subject Item|UOM|OBJLISTNO|OFCCD|ROWNO|hidden1|hidden2";
    					var headCount = ComCountHeadTitle(HeadTitle1);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(headCount, 0, 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					InitHeadMode(true, true, false, true, false,false);

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle1, true);

    					var prefix = "sheet3_";
            			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
    					InitDataProperty(0, cnt++, dtCheckBox,      0,    	daCenter,  	true,  "hiddencheck");
    					InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	prefix+"rn");
    					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"pso_obj_cd_dsp");
    					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,	prefix+"obj_list_nm");
    					InitDataProperty(0, cnt++ , dtData,			40,		daLeft,		true,	prefix+"pso_meas_ut_cd_dsp");
    					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	prefix+"obj_list_no");
    					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	prefix+"pso_ofc_cd");
    					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	prefix+"row_no");
    					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,	prefix+"pso_obj_cd");		//
    					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,	prefix+"pso_meas_ut_cd");	//
    					
    					CountPosition = 0;
    					SelectionMode = smSelectionList; //추가
    					ColHidden("hiddencheck") = true;
//    					ColHidden(prefix+"obj_list_no") = true;
//    					ColHidden(prefix+"pso_ofc_cd") = true;
//    					ColHidden(prefix+"row_no") = true;
    					//ColHidden(prefix+"rn") = true;
//    					SelectBackColor = RgbColor(255,255,192);
    				}
    				break;

    			case "sheet4":
    				with (sheetObj) {
    				// 높이 설정
    					style.height = 140;
    					
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;

    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msHeaderOnly;

    					//전체Edit 허용 여부 [선택, Default false]
    					Editable = false;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo(1, 1, 3, 100);

    					var HeadTitle1 = "|CHK|Seq.|Subject Item|Subject Item|UOM|OBJLISTNO|OFCCD|ROWNO|hidden1|hidden2";
    					var headCount = ComCountHeadTitle(HeadTitle1);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(headCount, 0, 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					InitHeadMode(true, true, false, true, false,false);

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle1, true);

    					var prefix = "sheet4_";
            			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
    					InitDataProperty(0, cnt++, dtCheckBox,      0,    	daCenter,  	true,  "hiddencheck");
    					InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	prefix+"rn");
    					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"pso_obj_cd_dsp");
    					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,	prefix+"obj_list_nm");
    					InitDataProperty(0, cnt++ , dtData,			40,		daLeft,		true,	prefix+"pso_meas_ut_cd_dsp");
    					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	prefix+"obj_list_no");
    					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	prefix+"pso_ofc_cd");
    					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	prefix+"row_no");
    					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,	prefix+"pso_obj_cd");		//
    					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,	prefix+"pso_meas_ut_cd");	//
    					
    					CountPosition = 0;
    					SelectionMode = smSelectionList; //추가
    					ColHidden("hiddencheck") = true;
    				}
    				break;
            }
        }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
//    		sheetObject4.ShowDebugMsg = true;
		var saveObjs = new Array(3);
		saveObjs[0] = sheetObject2;
		saveObjs[1] = sheetObject3;
		saveObjs[2] = sheetObject4;
		
		sheetObject1.WaitImageVisible=false;
		sheetObject2.WaitImageVisible=false;
		sheetObject3.WaitImageVisible=false;
		sheetObject4.WaitImageVisible=false;
		
        switch(sAction) {

			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				if ( sheetObj.id == "sheet1"){
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH;
					var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_"); //prefix 문자열 배열
					var sXml = sheetObj.GetSearchXml("VOP_PSO_0208GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					var sXmls = sXml.split('|$$|');

					for(var i=0; i<sXmls.length;i++){
						sheetObjects[i].LoadSearchXml(sXmls[i]);
					}
					ComOpenWait(false);
				}
				break;
			 case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) return;
			    ComOpenWait(true);
			  	formObj.f_cmd.value = MULTI;
			  	for(var i=0; i<saveObjs.length;i++){
			  		for(var j=saveObjs[i].HeaderRows ; j<=saveObjs[i].RowCount;j++)//강제로 Insert로 만든다
			  			saveObjs[i].CellValue2(j,0) = "I";
			  	}
				//var SaveStr = ComGetSaveString(sheetObjects); // 배열입니다.
				var SaveStr = ComGetSaveString(saveObjs); // 배열입니다.
				//alert(SaveStr);
				var aryPrefix = new Array("sheet2_", "sheet3_", "sheet4_");	//prefix 문자열 배열	
				var sXml = sheetObject2.GetSaveXml("VOP_PSO_0208GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				//alert(sXml);
				ComOpenWait(false);
				sheetObjects[0].LoadSaveXml(sXml);
				break;
    			
        }
    }
        

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }

        return true;
    }
     

	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
		var addElement = document.getElementById("btns_add");
		addElement.fireEvent("onclick");
	}
	
	function sheet2_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
		var addElement = document.getElementById("btns_del");
		addElement.fireEvent("onclick");
	}
	
	function sheet3_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
		var addElement = document.getElementById("btns_del");
		addElement.fireEvent("onclick");
	}
	
	function sheet4_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
		var addElement = document.getElementById("btns_del");
		addElement.fireEvent("onclick");
	}

     
    function sheet2_OnMouseDown(Button, Shift, X, Y){
    	targetSheet = 2;
    	if(sheetOutlineColors[1]==null)
    		sheetOutlineColors[1] = sheetObjects[1].SheetOutLineColor;
    	sheetObjects[1].SheetOutLineColor = sheetObjects[1].RgbColor(255,0,0);
    	if(sheetOutlineColors[2]!=null)
    		sheetObjects[2].SheetOutLineColor=sheetOutlineColors[2];
    	if(sheetOutlineColors[3]!=null)
    		sheetObjects[3].SheetOutLineColor=sheetOutlineColors[3];
    }
    function sheet3_OnMouseDown(Button, Shift, X, Y){
    	targetSheet = 3;
    	if(sheetOutlineColors[2]==null)
    		sheetOutlineColors[2] = sheetObjects[2].SheetOutLineColor;
    	sheetObjects[2].SheetOutLineColor = sheetObjects[2].RgbColor(255,0,0);
    	if(sheetOutlineColors[1]!=null)
    		sheetObjects[1].SheetOutLineColor=sheetOutlineColors[1]; 
    	if(sheetOutlineColors[3]!=null)
    		sheetObjects[3].SheetOutLineColor=sheetOutlineColors[3];
    }
    function sheet4_OnMouseDown(Button, Shift, X, Y){
    	targetSheet = 4;
    	if(sheetOutlineColors[3]==null)
    		sheetOutlineColors[3] = sheetObjects[3].SheetOutLineColor;
    	sheetObjects[3].SheetOutLineColor = sheetObjects[3].RgbColor(255,0,0);
    	if(sheetOutlineColors[1]!=null)
    		sheetObjects[1].SheetOutLineColor=sheetOutlineColors[1];
    	if(sheetOutlineColors[2]!=null)
    		sheetObjects[2].SheetOutLineColor=sheetOutlineColors[2]; 
    }
	/* 개발자 작업  끝 */