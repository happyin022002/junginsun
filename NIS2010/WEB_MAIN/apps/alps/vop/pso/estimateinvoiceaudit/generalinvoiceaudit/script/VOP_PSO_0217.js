/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0217.jsp
*@FileTitle : Add information
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : kwkim
*@LastVersion : 1.0
* 1.0 Creation
* User가 직접 add info정보를 입력할 수 있도록 함.
=========================================================*/

   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class vop_pso_0217 : vop_pso_0217 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0217() {
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
    
 // IBSheet 
 var sheetObjects = new Array();
 var sheetCnt = 0;

 var formObj = null;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
 document.onclick = processButtonClick;

 /**
  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
  */
 function processButtonClick() {
	var sheetObj   = sheetObjects[0];
 	var srcName = window.event.srcElement.getAttribute("name");
 	
 	switch (srcName) {	
 		case "btn_OK":

          var objval = sheetObj.CellValue(2, "sheet1_objno");
          var objhour = sheetObj.CellValue(2, "sheet1_objhour");
 		
 		  if(objval == "0" || ComTrim(objval) == "")  ComShowMessage("Please, input Used NO.of TUG.");
 		  if(objhour == "0" || ComTrim(objhour) == "")  ComShowMessage("Please, input Used Hour of TUG.");
 		  else  comPopupOK();
 		  break;
 	}
 }
 
 /**
  * IBSheet Object를 배열로 등록
  * @param {ibsheet} sheetObj    IBSheet Object  
  **/
 function setSheetObject(sheet_obj){
     sheetObjects[sheetCnt++] = sheet_obj;
 }

 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  **/
 function loadPage() {
     //전역 변수 설정 
     formObj = document.form;
     sheetCnt = sheetObjects.length ;   
     
     //시트 초기화 
     for(var i=0 ; i < sheetCnt ; i++) {
         ComConfigSheet (sheetObjects[i]);
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);              
     }
     doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
 }

 /**
   * 시트 초기설정값, 헤더 정의
   * @param {ibsheet} sheetObj  sheet
   * @param {int} sheetNo 시트번호
   */
 function initSheet(sheetObj, sheetNo) {
 	var cnt = 0;	
 	with (sheetObj) {
 		switch (sheetObj.id) {
 		case "sheet1": 
             // 높이 설정
 			style.height = 100;
 								
 			//전체 너비 설정
 			SheetWidth = mainTable.clientWidth;

 			//Host정보 설정[필수][HostIp, Port, PagePath]
 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 			//전체Merge 종류 [선택, Default msNone]
 			MergeSheet = msHeaderOnly;

 			//전체Edit 허용 여부 [선택, Default false]
 			Editable = true;

 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 			InitRowInfo( 2, 1, 3, 100);

 			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 			InitColumnInfo(6, 0, 0, true);

 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
 			InitHeadMode(true, true, false, true, false,false)
           
 			var chk =  document.form.io.value;
 			
 			if(chk=="IN")
 			var HeadTitle  = "|No. of TUG in Arrival|No. of TUG in Arrival|No. of TUG in Arrival|TUG Used Hour in Arrival|TUG Used Hour in Arrival|";
 			else
 				var HeadTitle  = "|No. of TUG in Departure|No. of TUG in Departure|No. of TUG in Departure|TUG Used Hour in Departure|TUG Used Hour in Departure|";
 			
 			var HeadTitle1 = "|Regular|Actul|Used|Actul|Used|";
          
 			
 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 			InitHeadRow(0, HeadTitle,  true);
 			InitHeadRow(1, HeadTitle1, true);

 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 			var prefix = "sheet1_";
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		    daCenter,	false,	    prefix+"ibflag");         
            InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,		prefix+"regno",		false,		"",			dfNumber,	2,			false,		false, 		6,			false,	false, 		"Arrival Number of Tug");
            InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,		prefix+"actno",		false,		"",			dfNumber,	2,			false,		false, 		6,			false,	false, 		"Arrival Number of Tug");
	        InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,		prefix+"objno",		false,		"",			dfInteger,	2,			true,		true, 		6,			false,	false, 		"Arrival Number of Tug");
	        InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,		prefix+"acthour",	false,		"",			dfNumber,	2,			false,		false, 		6,			false,	false, 		"Arrival Used Hour of Tug");
	        InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,		prefix+"objhour",	false,		"",			dfNumber,	2,			true,		true, 		2,			false,	false, 		"Arrival Used Hour of Tug");
 
	        CountPosition = 0;
			//ShowButtonImage = 1;
			//ShowMsgMode=false;

            break;			    
 		}
 	}
 }
 
  // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj, formObj, sAction) {
	 sheetObj.ShowDebugMsg = false;
	 sheetObj.WaitImageVisible=false;
	 
	 switch(sAction) {
	     
     case SEARCH01:		
        formObj.f_cmd.value = SEARCH01;
     	var param = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VOP_PSO_0217GS.do", param );
		setBasicData(sheetObj);
		var rtVal = ComGetEtcData(sXml, "OBJVAL");
		
		var regVal = rtVal.split("+")[0];
		var actVal = rtVal.split("+")[1];
		var actHour = rtVal.split("+")[2];
			
		sheetObj.CellValue2(2, "sheet1_regno") = regVal;
		sheetObj.CellValue2(2, "sheet1_actno") = actVal;
		
		if(actVal != "0")  sheetObj.CellValue2(2, "sheet1_objno") = actVal;
		else 
		 { if(regVal != "0")  sheetObj.CellValue2(2, "sheet1_objno") = regVal;
		  else  sheetObj.CellValue2(2, "sheet1_objno") = "";
		 }
		
		sheetObj.CellValue2(2, "sheet1_acthour") = actHour;
		
		if(actHour !="0")	sheetObj.CellValue2(2, "sheet1_objhour") = actHour;
		else
			sheetObj.CellValue2(2, "sheet1_objhour") = "";
			
	 	break;
     }
 }
	 
 function setBasicData(sheetObj) {
	 var formObj = document.form;
	 var row = sheetObj.DataInsert(-1);
	 sheetObj.SelectHighLight  = false;
	 sheetObj.CellValue2(row, "sheet1_objno") = "";

	 sheetObj.CellBackColor(2,3) = sheetObj.RgbColor(230, 255, 255);
	
 }
 

 /**
  * IBSheet OnChange Event
  */
 function sheet1_OnChange(sheetObj,Row,Col) {
 	var formObj = document.form;
 	var prefix = "sheet1_";
 	
 }	
 
	/* 개발자 작업  끝 */