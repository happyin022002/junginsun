/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1022.js
*@FileTitle : Lease Agreement Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.17 김창식
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

    /**
     * @extends 
     * @class ees_cgm_1022 : ees_cgm_1022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_1022() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;

    var tabLoad = new Array();
    tabLoad[0]= 0;
    tabLoad[1]= 0;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.28
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
            
        /*******************************************************/
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            
 				case "btn_Close":
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
     * IBSheet Object를 배열로 등록 <br>
     * @param  {object} sheetObj	필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.17
     */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }



     /**
      * Sheet 기본 설정 및 초기화 <br>
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * @param  없음
      * @return 없음
      * @author 김창식
      * @version 2009.06.17
      */
    function loadPage() {

    	var formObj = document.form;
        
    	for(i=0;i<sheetObjects.length;i++){

    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i] );

    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        comboObjects[comboCnt++] = document.agmt_ver_no;
        for(var k=0;k<comboObjects.length;k++){
     		initCombo(comboObjects[k]);
 	    }
        
        if(validateForm(sheetObjects[0], formObj,IBSEARCH) != false) {
        	doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
//        	doActionIBSheet(sheetObjects[0], formObj,IBRESET);
        }
     }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김창식
     * @version 2009.06.17
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
   		var sheetID = sheetObj.id;
           
   		switch(sheetID) {
           	
              case "t1sheet1":
                   with (sheetObj) {

                  	   // 높이 설정
                       style.height = 62;
                       //전체 너비 설정
                       SheetWidth = mainTable.clientWidth;

                       //Host정보 설정[필수][HostIp, Port, PagePath]
                       if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                       //전체Merge 종류 [선택, Default msNone]
                       MergeSheet = msHeaderOnly;

                      //전체Edit 허용 여부 [선택, Default false]
                       Editable = true;

                       //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                       InitRowInfo( 1, 1, 3, 100);

   					   var HeadTitle = "T/S||SF2|SL2|TA2|SF4|GN4|CB4|EG5|EG8|GN5|ZT4";
   					   var headCount = ComCountHeadTitle(HeadTitle);

                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                       InitColumnInfo(headCount, 0, 1, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                       InitHeadMode(true, true, false, true, false,false);

   					  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                       InitHeadRow(0, HeadTitle, true);

                       //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                       InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "title", false, "", dfNone,	  0, true, true);
                       InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                       InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_sf2", false, "", dfNullFloat, 2, false, true);
   					   InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_sl2", false, "", dfNullFloat, 2, false, true);
                       InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_ta2", false, "", dfNullFloat, 2, false, true);
   					   InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_sf4", false, "", dfNullFloat, 2, false, true);
                       InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_gn4", false, "", dfNullFloat, 2, false, true);
   					   InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_cb4", false, "", dfNullFloat, 2, false, true);
                       InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_eg5", false, "", dfNullFloat, 2, false, true);
   					   InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_eg8", false, "", dfNullFloat, 2, false, true);
                       InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_gn5", false, "", dfNullFloat, 2, false, true);
   					   InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_zt4", false, "", dfNullFloat, 2, false, true);
   					 
   					   InitHeadColumn("title","Initial Value");

   					 CountPosition = 0;
   					 
                  }
                   break;         	
           	
              case "t2sheet1":
                   with (sheetObj) {
                       // 높이 설정
                       style.height = 82;
                       //전체 너비 설정
                       SheetWidth = mainTable.clientWidth;

                       //Host정보 설정[필수][HostIp, Port, PagePath]
                       if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                       //전체Merge 종류 [선택, Default msNone]
                       MergeSheet = msHeaderOnly;

                      //전체Edit 허용 여부 [선택, Default false]
                       Editable = true;

                       //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                       InitRowInfo(1, 1, 1, 100);

   					   var HeadTitle1 = "|Seq|Registered State|Surcharge Rate";
                       var headCount = ComCountHeadTitle(HeadTitle1);

                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                       InitColumnInfo(headCount, 0, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                       InitHeadMode(true, true, true, true, false,false)

                       //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                       InitHeadRow(0, HeadTitle1, true);

                       //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                       InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                       InitDataProperty(0, cnt++ , dtDataSeq,  	    50, daCenter,  true, "seq");
                       InitDataProperty(0, cnt++ , dtData,   170, daCenter,  true, "ste_cd", false, "", dfNone, 0, false, true);
   					   InitDataProperty(0, cnt++ , dtData,    170, daRight,   false, "rgst_scg_rt_amt", false, "", dfNullFloat, 2, false, true);
   										
   					   CountPosition = 0;
                  }
                   
                  break;

              case "t3sheet1":
                   with (sheetObj) {
                       // 높이 설정
                       style.height =62;
                       //전체 너비 설정
                       SheetWidth = mainTable.clientWidth;

                       //Host정보 설정[필수][HostIp, Port, PagePath]
                       if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                       //전체Merge 종류 [선택, Default msNone]
                       MergeSheet = msHeaderOnly;

                      //전체Edit 허용 여부 [선택, Default false]
                       Editable = true;

                       //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                       InitRowInfo(1, 1, 1, 100);

   					   var HeadTitle = "Type/Size||SF2|SL2|TA2|SF4|GN4|CB4|EG5|EG8|GN5|ZT4";
                       var headCount = ComCountHeadTitle(HeadTitle);

                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                       InitColumnInfo(headCount, 0, 1, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                       InitHeadMode(true, true, true, true, false,false);

                       //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                       InitHeadRow(0, HeadTitle, true);

                       //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                     
                       InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "title", false, "", dfNone,      0, true, true);
                       InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                       InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_sf2",      false, "", dfNullFloat, 2, false, true);
   					   InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_sl2",      false, "", dfNullFloat, 2, false, true);
                       InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_ta2",      false, "", dfNullFloat, 2, false, true);
   					   InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_sf4",      false, "", dfNullFloat, 2, false, true);			
                       InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_gn4",      false, "", dfNullFloat, 2, false, true);
   					   InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_cb4",      false, "", dfNullFloat, 2, false, true);
                       InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_eg5",      false, "", dfNullFloat, 2, false, true);
   					   InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_eg8",      false, "", dfNullFloat, 2, false, true);
                       InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_gn5",      false, "", dfNullFloat, 2, false, true);
                       InitDataProperty(0, cnt++, dtData,  65, daRight, false, "eq_tpsz_cd_zt4",      false, "", dfNullFloat, 2, false, true);
   	
                       InitHeadColumn("title","Fixed Rate");
                       
   					 CountPosition = 0;
   				 }
                  
                   break;

              case "t3sheet2":
                   with (sheetObj) {
                       // 높이 설정
                       style.height =82;
                       //전체 너비 설정
                       SheetWidth = mainTable.clientWidth;

                       //Host정보 설정[필수][HostIp, Port, PagePath]
                       if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                       //전체Merge 종류 [선택, Default msNone]
                       MergeSheet = msHeaderOnly;

                      //전체Edit 허용 여부 [선택, Default false]
                       Editable = true;

                       //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                       InitRowInfo(1, 1, 1, 100);

   					   var HeadTitle = "|Number of Units|Number of Units|Number of Units|Number of Units|SF2|SL2|TA2|SF4|GN4|CB4|EG5|EG8|GN5|ZT4";
                       var headCount = ComCountHeadTitle(HeadTitle);

                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                       InitColumnInfo(headCount, 0, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                       InitHeadMode(false, true, true, true, false,false);

                       //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                       InitHeadRow(0, HeadTitle, true);

                       //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                       InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                       
                       InitDataProperty(0, cnt++ , dtData, 50, daCenter, false, "rntl_fm_title",  false, "", dfNone, 		  0, false, false);
                       InitDataProperty(0, cnt++ , dtData, 50, daCenter, false, "rntl_fm_tr_val", false, "", dfNullInteger, 0, false, true);
                       InitDataProperty(0, cnt++ , dtData, 50, daCenter, false, "rntl_to_title", 	false, "", dfNone, 		  0, false, false);
                       InitDataProperty(0, cnt++ , dtData, 50, daCenter, false, "rntl_to_tr_val", false, "", dfNullInteger, 0, false, true);
                       InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_sf2", false, "", dfNullFloat,   2, false, true);
   					   InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_sl2", false, "", dfNullFloat,   2, false, true);
                       InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_ta2", false, "", dfNullFloat,   2, false, true);
   					   InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_sf4", false, "", dfNullFloat,   2, false, true);
                       InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_gn4", false, "", dfNullFloat,   2, false, true);
   					   InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_cb4", false, "", dfNullFloat,   2, false, true);
                       InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_eg5", false, "", dfNullFloat,   2, false, true);
   					   InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_eg8", false, "", dfNullFloat,   2, false, true);
                       InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_gn5", false, "", dfNullFloat,   2, false, true);
   					   InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_zt4", false, "", dfNullFloat,   2, false, true);
   	
   					CountPosition = 0;
   				 }
                   
                   break;
                   
              case "t3sheet3":
                   with (sheetObj) {

                  	 // 높이 설정
                       style.height =82;
                       //전체 너비 설정
                       SheetWidth = mainTable.clientWidth;

                       //Host정보 설정[필수][HostIp, Port, PagePath]
                       if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                       //전체Merge 종류 [선택, Default msNone]
                       MergeSheet = msHeaderOnly;

                      //전체Edit 허용 여부 [선택, Default false]
                       Editable = true;

                       //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                       InitRowInfo(1, 1, 1, 100);

   					   var HeadTitle = "|Used Days|Used Days|Used Days|Used Days|SF2|SL2|TA2|SF4|GN4|CB4|EG5|EG8|GN5|ZT4";
                       var headCount = ComCountHeadTitle(HeadTitle);

                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                       InitColumnInfo(headCount, 0, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                       InitHeadMode(false, true, true, true, false,false);

                       //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                       InitHeadRow(0, HeadTitle, true);

                       //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                       InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                       
                       InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rntl_fm_title",  false, "", dfNone, 	  	0, false, false);
                       InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rntl_fm_tr_val", false, "", dfNullInteger,0, false, true);
                       InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rntl_to_title",  false, "", dfNone, 	  	0, false, false);
                       InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rntl_to_tr_val", false, "", dfNullInteger,0, false, true);
                       InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_sf2", false, "", dfNullFloat, 	2, false, true);
   					   InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_sl2", false, "", dfNullFloat, 	2, false, true);
                       InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_ta2", false, "", dfNullFloat, 	2, false, true);
   					   InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_sf4", false, "", dfNullFloat, 	2, false, true);
                       InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_gn4", false, "", dfNullFloat, 	2, false, true);
   					   InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_cb4", false, "", dfNullFloat, 	2, false, true);
                       InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_eg5", false, "", dfNullFloat, 	2, false, true);
   					   InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_eg8", false, "", dfNullFloat, 	2, false, true);
                       InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_gn5", false, "", dfNullFloat, 	2, false, true);
   					   InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_zt4", false, "", dfNullFloat, 	2, false, true);
   	
   					 CountPosition = 0;
   					 
   				 }
                   
                 break;
            
              case "sheet":	// Hidden Sheet
              	 with (sheetObj) {
                  	// 높이 설정
                  	//Host정보 설정[필수][HostIp, Port, PagePath]
                  	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
              	 }
              
                 break;

        }
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01)
     * @return 없음
     * @author 김창식
     * @version 2009.05.28
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

         	case IBSEARCH:      //조회
         		formObj.f_cmd.value = SEARCH;
         		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
         		sheetObj.WaitImageVisible=false;
		 	    ComOpenWait(true);
         		var sXml = sheetObjects[5].GetSearchXml("EES_CGM_1022GS.do" , FormQueryString(formObj), '', true);
         		var arrXml = sXml.split("|$$|");
		 	    ComOpenWait(false);
         		// tab1 Sheet Object
         		sheetObjects[3].LoadSearchXml(arrXml[0]);
         		
         		// ETC DATA 값을  FORM OBJECT 에 세팅
         		setEtcDataToForm(formObj, sheetObjects[3]);
         		
         		if(arrXml.length > 1){
	         	
	         		// Rental Rate Tab 안의  Sheet Object 값 설정
	         		if(sheetObjects[3].EtcData("eq_rntl_tp_cd") == 'F'){	
	         			sheetObjects[0].LoadSearchXml(arrXml[2])
	         		} else if(sheetObjects[3].EtcData("eq_rntl_tp_cd") == 'U'){
	         			sheetObjects[1].LoadSearchXml(arrXml[2])    		
	         		} else if(sheetObjects[3].EtcData("eq_rntl_tp_cd") == 'D'){
	         			sheetObjects[2].LoadSearchXml(arrXml[2])
	         		}
	         		
	         		// Surchage Tab Sheet Object 값 설정
	         		sheetObjects[4].LoadSearchXml(arrXml[1]);	
	         		
	         		// Agreement Version MultiCombo 설정
	         		var comboItemCnt = comboObjects[0].getCount();
	         		
		         	var cols = ComCgmXml2ComboString(arrXml[3], "agmt_ver_no", "agmt_ver_no");
		         	ComCgmMakeMultiCombo(comboObjects[0], cols[0], cols[1], 0);
		         	comboObjects[0].Text2 = ComCgmNullToBlank(sheetObjects[3].EtcData("agmt_ver_no"));
	         		
	         	  	
         		} else {
         			// Sheet Object Clear
             		for(var i=0; i<sheetObjects.length; i++){
             			sheetObjects[i].RemoveAll();
             		}
         		}
         		
         		break;
        }
    }

    /**
     * ETC 데이터를 Form Tag 에 설정한다. <br>
     * @param  {object} formObj	 필수
     * @param  {object} sheetObj 필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.09
     */
    function setEtcDataToForm(formObj, sheetObj){
    	formObj.eq_knd_cd.value 		= ComCgmNullToBlank(sheetObj.EtcData("eq_knd_cd"));
    	formObj.agmt_ofc_cty_cd.value 	= ComCgmNullToBlank(sheetObj.EtcData("agmt_ofc_cty_cd"));
  		formObj.agmt_seq.value 			= ComCgmNullToBlank(sheetObj.EtcData("agmt_seq"));
  		formObj.agmt_no.value 			= ComCgmNullToBlank(sheetObj.EtcData("agmt_no"));
  		formObj.agmt_ref_no.value 		= ComCgmNullToBlank(sheetObj.EtcData("agmt_ref_no"));
  		formObj.curr_cd.value 			= ComCgmNullToBlank(sheetObj.EtcData("curr_cd"));
  		formObj.agmt_dt.value 			= ComCgmNullToBlank(sheetObj.EtcData("agmt_dt"));
  		formObj.agmt_iss_ofc_cd.value 	= ComCgmNullToBlank(sheetObj.EtcData("agmt_iss_ofc_cd"));
  		formObj.agmt_eff_dt.value 		= ComCgmNullToBlank(sheetObj.EtcData("agmt_eff_dt"));
  		formObj.agmt_exp_dt.value 		= ComCgmNullToBlank(sheetObj.EtcData("agmt_exp_dt"));
  		formObj.eff_dt.value 			= ComCgmNullToBlank(sheetObj.EtcData("eff_dt"));
  		formObj.exp_dt.value 			= ComCgmNullToBlank(sheetObj.EtcData("exp_dt"));
  		formObj.vndr_seq.value 			= ComCgmNullToBlank(sheetObj.EtcData("vndr_seq"));
  		formObj.vndr_lgl_eng_nm.value 	= ComCgmNullToBlank(sheetObj.EtcData("vndr_lgl_eng_nm"));
  		formObj.dpp_rt_amt.value 		= ComCgmNullToZero(sheetObj.EtcData("dpp_rt_amt"));
  		formObj.dpp_cvrg_amt.value 		= ComCgmNullToZero(sheetObj.EtcData("dpp_cvrg_amt"));
  		formObj.lmsm_amt.value 			= ComCgmNullToZero(sheetObj.EtcData("lmsm_amt"));
  		formObj.onh_hndl_rt_amt.value 	= ComCgmNullToZero(sheetObj.EtcData("onh_hndl_rt_amt"));
  		formObj.offh_hndl_rt_amt.value 	= ComCgmNullToZero(sheetObj.EtcData("offh_hndl_rt_amt"));
  		formObj.pay_term_dys.value 		= ComCgmNullToBlank(sheetObj.EtcData("pay_term_dys"));
  		formObj.drp_off_lmt_qty.value 	= ComCgmNullToZero(sheetObj.EtcData("drp_off_lmt_qty"));
  		formObj.drp_off_lmt_rto.value 	= ComCgmNullToZero(sheetObj.EtcData("drp_off_lmt_rto"));
  		formObj.mon_dpc_rt_amt.value 	= ComCgmNullToZero(sheetObj.EtcData("mon_dpc_rt_amt"));
  		formObj.max_dpc_rt_amt.value 	= ComCgmNullToZero(sheetObj.EtcData("max_dpc_rt_amt"));
  		formObj.init_dpc_rt_amt.value 	= ComCgmNullToZero(sheetObj.EtcData("init_dpc_rt_amt"));
  		formObj.diff_rmk.value 			= ComCgmNullToBlank(sheetObj.EtcData("diff_rmk"));
  		
  		comboObjects[0].Text2 = ComCgmNullToBlank(sheetObj.EtcData("agmt_ver_no"));
  		formObj.agmt_lstm_cd.value = ComCgmNullToBlank(sheetObj.EtcData("agmt_lstm_cd"));
  		formObj.chss_pool_cd.value = ComCgmNullToBlank(sheetObj.EtcData("chss_pool_cd"));
  		
  		if(sheetObj.EtcData("eq_rntl_tp_cd") == 'F'){
  			formObj.eq_rntl_tp_cd(0).checked = true;
  		} else if(sheetObj.EtcData("eq_rntl_tp_cd") == 'U'){
  			formObj.eq_rntl_tp_cd(1).checked = true;
  		} else if(sheetObj.EtcData("eq_rntl_tp_cd") == 'D'){
  			formObj.eq_rntl_tp_cd(2).checked = true;
  		}
  		
    	if(sheetObj.EtcData("dpp_tp_cd") == 'G'){
    		formObj.dpp_tp_cd(0).checked = true;
  		} else if(sheetObj.EtcData("dpp_tp_cd") == 'L'){
  			formObj.dpp_tp_cd(1).checked = true;
  		}	
  		
  		if(sheetObj.EtcData("drp_off_lmt_prd_cd") == 'M'){
  			formObj.drp_off_lmt_prd_cd(0).checked = true;
  		} else if(sheetObj.EtcData("drp_off_lmt_prd_cd") == 'Y'){
  			formObj.drp_off_lmt_prd_cd(1).checked = true;
  		}	
  		
  		if(sheetObj.EtcData("drp_off_lmt_tp_cd") == 'F'){
  			formObj.drp_off_lmt_tp_cd(0).checked = true;
  		} else if(sheetObj.EtcData("drp_off_lmt_tp_cd") == 'R'){
  			formObj.drp_off_lmt_tp_cd(1).checked = true;
  		}
  		
  		// Lease Term 이 CP일 경우 Pool Layer 표시
  		var element = document.getElementById("poolLayer");
  		if(formObj.chss_pool_cd.value == "CP"){
  			element.style.display.visibility = "visible";
  		} else {
  			element.style.display.visibility = "hidden";
  		}
  		
  		
  		// Damage Protection Plan 에 따라서 텍스트 박스 표시
  		var qtyLayer = document.getElementById("qtyLayer");
		var rtoLayer = document.getElementById("rtoLayer");
		
		if(formObj.drp_off_lmt_tp_cd(0).checked){
			qtyLayer.style.display = "block";
			rtoLayer.style.display = "none";
		} else if(formObj.drp_off_lmt_tp_cd(1).checked){
			qtyLayer.style.display = "none";
			rtoLayer.style.display = "block";
		}
		
  		
  		// Tab3 안에서의 Sheet Enable 설정
 		setTab3SheetEnable(formObj);	
  		 
    }
    
    /**
     * Tab3 안의 Sheet 의 활성/비활성을 설정한다. <br>
     * @param  {object} formObj	필수
     * @param  {boolean} bEnable	필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.09
     */ 
    function setTab3SheetEnable(formObj){
    	var objsheets1 = document.getElementById("t3sheetLayer1");
     	var objsheets2 = document.getElementById("t3sheetLayer2");
     	var objsheets3 = document.getElementById("t3sheetLayer3");
  	    
     	with(formObj){
			if(eq_rntl_tp_cd(0).checked){
				objsheets1.style.display = 'Inline';
				objsheets2.style.display = 'none';
				objsheets3.style.display = 'none';
      			
			} else if (eq_rntl_tp_cd(1).checked){	
				objsheets1.style.display = 'none';
				objsheets2.style.display = 'Inline';
				objsheets3.style.display = 'none';
      			
			} else if (eq_rntl_tp_cd(2).checked){
				objsheets1.style.display = 'none';
				objsheets2.style.display = 'none';
				objsheets3.style.display = 'Inline';
			}
    	}
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
                     InsertTab( cnt++ , "Rental Rate" , -1 );
                     InsertTab( cnt++ , "Depr. For Casualty Value" , -1 );
                     InsertTab( cnt++ , "Surcharge" , -1 );
                     InsertTab( cnt++ , "Remark(s)" , -1 );
                     

                 }
              break;

          }
     }

     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem)
     {


         var objs = document.all.item("tabLayer");

 	    	objs[nItem].style.display = "Inline";
 	    	objs[beforetab].style.display = "none";

 	    	//--------------- 요기가 중요 --------------------------//
 	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
 	    	//------------------------------------------------------//
 	    	beforetab= nItem;
 		

     }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
     * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
     * @author 김창식
     * @version 2009.06.15
     */  
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
          	switch(sAction){
          	 	case IBSEARCH:	// 조회
          	 		var agmtNo = formObj.agmt_no.value;
          	 		var result = true;
          	 	
          	 		if(agmtNo != ""){
          	 			if(agmtNo.length <= 3){
          	 				result = false;
          	 			} else {
          	 				if(ComIsNumber(agmtNo.substring(3))==false){
          	 					result = false;
          	 				}
          	 			}
          	 		} else {
          	 			result = false;
          	 		}
          	 		
          	 		if(!result){
        	 			ComShowCodeMessage('CGM10004','Agreement No.');
        	 			window.close();
        	 			return false;
        	 		} else {
        	 			return true;
        	 		}
          	 			
          	 		break;
          	}
        }
    }

 	/** 
     * Combo Object 초기화  <br>
     * @param  {object} comboObj	필수 Combo Object
     * @return 없음
     * @author 김창식
     * @version 2009.06.17
     */ 
    function initCombo(comboObj) {
    	switch(comboObj.id) {
	    	case "agmt_ver_no":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code = "";
	  	            Text = "";
	  	            DropHeight = 100;
	  	            MultiSelect = false;
	  	            MaxSelect = 1;	    
	  	            UseCode = true;
	  	            Enable = true;
	  	        }
	  	        
	  	        break;
    	}
    }  
     
    /**
     * Agreement Version No 의 Change 이벤트를 정의한다. <br>
     * @param  {string} Index_Code 필수
     * @param  {string} Text 필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.09
     */
    function agmt_ver_no_OnChange(Index_Code, Text){
    	var formObj = document.form;
    	
    	if(validateForm(sheetObjects[0], formObj, IBSEARCH) != false) {
        	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        }
    } 


	/* 개발자 작업  끝 */