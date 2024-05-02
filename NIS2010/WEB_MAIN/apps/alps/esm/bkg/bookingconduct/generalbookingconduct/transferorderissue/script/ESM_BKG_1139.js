/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1139.js
*@FileTitle : Send TRO Notice
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.29
*@LastModifier : 금병주
*@LastVersion : 1.0
* 2011.11.29 금병주
* 1.0 Creation
* -------------------------------------------------------
* History
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
     * @class ESM_BKG_1139 : ESM_BKG_1139 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1139() {
    	   this.processButtonClick     = tprocessButtonClick;
           this.setSheetObject         = setSheetObject;
           this.loadPage               = loadPage;
           this.initSheet              = initSheet;
           this.doActionIBSheet        = doActionIBSheet;
           this.validateForm           = validateForm;
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
	     var sheetObject = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

         try {
             var srcName = window.event.srcElement.getAttribute("name");
             switch(srcName) {             
                 case "btn_close":
                     window.close();
                     break;

                 case "btn_send":
                     doActionIBSheet(sheetObject,formObject,COMMAND01);
                     break;

             } // end switch
         } catch(e) {
             if ( e == "[object Error]") {
                 ComShowCodeMessage("COM12111");
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
    	 for (var i=0; i<sheetObjects.length; i++) {
    		 ComConfigSheet(sheetObjects[i]);
    		 initSheet(sheetObjects[i],i+1);
    		 ComEndConfigSheet(sheetObjects[i]);
    	 }
    	 initControl();
    	 BkgEnableObject(document.form.other, false);
    	 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    } 
     
    function initControl() {
     	var formObj = document.form;
        axon_event.addListenerForm('click', 'bkg1139_click', formObj); //- 클릭시
    }
    
	function bkg1139_click(){
    	var formObj = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");

    	if(srcName == "receiver"){
    		if(ComGetObjValue(formObj.receiver) == "O"){
    			BkgEnableObject(formObj.other, true);
    		} else {
    			BkgEnableObject(formObj.other, false);
    			ComSetObjValue(formObj.other, "");
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
        switch(sheetObj.id) {
            case 'sheet1':      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    try{
                    style.height = 100;
                    //전체 너비 설정 
                    
                    SheetWidth = mainTable.clientWidth;
                    RequestTimeOut = 30;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);
 
                    var HeadTitle1 = "| | |Contact Point|Sender|Send Date|Result||";
                    var headCount = ComCountHeadTitle(HeadTitle1); 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1); 
                    //데이터속성    [ROW, COL,  DATATYPE,				WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	"ibflag");

					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,	"slct_flg",			false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"remark",			false,	"",	dfNone,			0,	true,	true);
					
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,	"fax_no",			false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	true,	"fax_sender_nm",	false,	"",	dfNone,			0,	false,	true);

					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"fax_send_dt",		false,	"",	dfUserFormat2,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"fax_send_result",	false,	"",	dfNone,			0,	false,	true);

					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"bkg_no");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"ntc_knd_cd");
 
					InitUserFormat2(0, "fax_send_dt",  "####-##-## ##:##", "-|:" );
                    }catch(e){
                    	e.errorMessage;
                    }
               	}
                break;
                
            case 'sheet2':      //sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    try{
                    style.height = 175;
                    //전체 너비 설정 
                    
                    SheetWidth = cntrTable.clientWidth;
                    RequestTimeOut = 30;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);
 
                    var HeadTitle1 = "||Seq|CNTR No.|cntr_tpsz_cd";
                    var headCount = ComCountHeadTitle(HeadTitle1); 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1); 
                    //데이터속성    [ROW, COL,  DATATYPE,				WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	false,	"slct",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtDataSeq,		30,		daCenter,	false,	"tro_seq",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"cntr_no",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"cntr_tpsz_cd",	false,	"",	dfNone,	0,	false,	false);

                    }catch(e){
                    	e.errorMessage;
                    }
               	}
                break;     
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
//      sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				var sXml = ComGetObjValue(formObj.sXml);
				formObj.sXml.value = null;
	        	var arrXml = sXml.split("|$$|");
	        	sheetObj.LoadSearchXml(arrXml[0]); 
	        	
	        	if(arrXml.length > 1){
	        		sheetObjects[0].LoadSearchXml(arrXml[1]);//cnrt sheet
	        		sheetObjects[0].CheckAll2("slct") = true; 
	        	}
	        	break;
	
			case COMMAND01:
				if(validateForm(sheetObj,formObj,sAction)){
					var fax= '';
					var email = '';
					for(var i = 0; i < sheetObj.RowCount; i++){
					 	var chkFlg = sheetObj.CellValue(i+1,"slct_flg") == 1; 
						var ctPnt = sheetObj.CellValue(i+1, "fax_no");
						if (chkFlg){ 
							if(i == 0){
								fax =  ctPnt;
							}
							if(i == 1){
								email = ctPnt;
							}
						}
					}
					var cmdt = ComGetObjValue(formObj.cmdt);
					var receiver = ComGetObjValue(formObj.receiver);
					var other = ComGetObjValue(formObj.other);
					var cust_ntc = ComGetObjValue(formObj.cust_ntc);
					var slct_cntr = "";
					
					
					if(sheetObjects[0].CheckedRows("slct") > 0){
						var slctArr = ComRtrim(sheetObjects[0].FindCheckedRow("slct"),"|").split("|");
						if(slctArr.length == 1){
							slct_cntr = "'" + sheetObjects[0].CellValue(slctArr[0],"cntr_no") + "'";
						}else if(slctArr.length > 1){
							slct_cntr = "'" + sheetObjects[0].CellValue(slctArr[0],"cntr_no") + "'";
							for(var i=1; i<slctArr.length; i++){
								slct_cntr = slct_cntr + ",'"+ sheetObjects[0].CellValue(slctArr[i],"cntr_no") + "'";
							}
						}
					}else{
						slct_cntr = "''";
					}
					opener.sendFaxEmail(fax, email, cmdt, receiver, other, cust_ntc, slct_cntr);
				}
				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		switch(sAction) {
			   	case COMMAND01:
			   		if (sheetObj.RowCount == 0) {
						ComShowMessage(msgs['BKG40017']); // There is no Row Selected
						return false;
					}
					if (sheetObj.CheckedRows("slct_flg") == 0) {
						ComShowMessage(msgs['BKG40017']); // There is no Row Selected
						return false;
					}
					for(var i = 0; i < sheetObj.RowCount; i++){						
					 	var chkFlg = sheetObj.CellValue(i+1,"slct_flg") == 1; 
						var ctPnt = sheetObj.CellValue(i+1, "fax_no");
						if (chkFlg){ 
							if( ctPnt == "") {
								ComShowCodeMessage("BKG04006");  //The Fax, E-Mail is invalid
		                    	return false;
		                    	break;
							} 
							if(i == 0 && !ComIsContainsCharsOnly(ctPnt,"1234567890-")){
								ComShowCodeMessage("BKG00246");  //The Fax is invalid
		                    	return false;
		                    	break; 
							}
							if(i == 1 && !ComIsEmailAddr(ctPnt)){
								ComShowCodeMessage("BKG00245");  //The E-Mail is invalid
		                    	return false;
		                    	break;
							}
						}
					}
					break;
    		}
    	}
    	return true;
    }
