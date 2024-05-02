/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0083.js
*@FileTitle : Weekly L/F by POL/POD
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.11.22 김종준 
* 1.0 Creation
* 2011.12.08 김종준   화면 속도 개선
* 2011.12.30 김종준 [CHM-201007719-01] Loading by POL/POD 화면 -POL/POD별 조회 기능추가
* 2011.03.03 이석준 [CHM-201109016-01] BSA Input Button 추가및 버튼 클릭시 PopUp(ESM_SPC_0084)
* 2011.07.05 최윤성 [CHM-201111937-01] Space Utilization 화면 보완
*  - Grid 상단의 POL/POD 체크박스 옆에 Weight 체크박스 추가하여, 해당 항목 체크시 Weight 정보 보여줌. 각각의 Carrier 별 Weight 정보를 추가.
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2015.02.24 김승만 [CHM-201533936] 사용자 표준환경 관련 개선
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESM_SPC_0083 : ESM_SPC_0083 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0083() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/** 개발자 작업	*/
    
    // 공통전역변수
    var sheetObjects = new Array();
    var comObjects   = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    var param    = "";
    var bse_dt=0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_year = '';
    var init_week = '';
    var init_duration = '';
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	/*******************************************************/
    	var sheetObject  = sheetObjects[0];
    	var sheetObject1 = sheetObjects[1];
    	var formObject  = document.form;
    	
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;
    			
    			case "btn_new":
    				sheetObject.RemoveAll();
    				formObject.reset();
    				resetAll(); 

					document.form.full_flg.value = 'F';
    				formObject.year.value = init_year;
					formObject.week.value = init_week;  
					formObject.temp_duration.value = init_duration;
					SpcSearchOptionWeek("week",false,document.form.year.value);
					
					SpcSearchOptionTrade("trade");
					SpcSearchOptionSubTrade("subtrade", true, true);
					SpcSearchOptionLane("rlane_cd"); // 0207 SHKIM    
    				break;
    			
    			case "btn_downexcel":
    				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
    				break;
    			case "btn_bsa":
    				var sUrl = "/hanjin/ESM_SPC_0084.do";
  		          ComOpenPopup(sUrl, 600, 400, "", "0,0", true, false, "", "", "","BSA INPUT"); 
    				break;    				
    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");
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
    function setSheetObject(sheet_obj) {
    	sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
    	comObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
    	document.getElementById("trade").Enable = false;
    	document.getElementById("subtrade").Enable = false;
    	
     	SpcSearchOptionYear("year");
     	SpcSearchOptionWeek("week");
     	SpcSearchOptionDuration("temp_duration", 5, 3);
     	SpcSearchOptionTrade("trade");
     	SpcSearchOptionSubTrade("subtrade", true, true);
     	SpcSearchOptionLane("rlane_cd");
     	SpcSearchOptionBound("bound",false,true,false,false);
    	
    	for(i=0;i<sheetObjects.length;i++) {
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	var sheetResizeFull = true;
    	document_onresize();
    	sheetObjects[0].WaitImageVisible=false;
    	doActionIBSheet(sheetObjects[0],document.form,SEARCHLIST01);	//헤더 주차 조회  	
    	document.form.year.focus();
    	document.form.full_flg.value = 'F';

    	init_year = document.form.year.value; // 년 초기화용
    	init_week = document.form.week.value; // 주차 초기화용
    	init_duration = document.form.temp_duration.value; // 기간 초기화용
    	
    	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
    	document.getElementById("trade").Enable = true;
    	document.getElementById("subtrade").Enable = true;
    }

    /**
    * Tab 기본 설정
    * 탭의 항목을 설정한다.
    */
    function initCombo (comboObj, comboNo) {
    }
    
    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo,headTitle1) {
       var cnt = 0;
 
       with (sheetObj) {
      
	       switch (sheetObj.id) {
	       case "sheet1":      //t1sheet1 init
	       	   style.height = 350;
			           
	           //Host정보 설정[필수][HostIp, Port, PagePath]
	           if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    
	           //전체Merge 종류 [선택, Default msNone]
	           MergeSheet = msPrevColumnMerge;

	           //전체Edit 허용 여부 [선택, Default false]
	           Editable = false;
	           FocusEditMode = default_edit_mode;
	    
	           //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	           InitRowInfo( 3, 3, 20, 100);
	                   
	           // 해더에서 처리할 수 있는 각종 기능을 설정한다
	           InitHeadMode(true, false, false, true, false,false) ;
	           CountPosition = 0;	//페이지카운트 없애기 
	           var colCnt = 0;
	           if (headTitle1==null || headTitle1 =="") {
	        	   headTitle1 = "Sub Trade\n/Lane|POL|POD|200701|200701|200701|200701|200701|200701|200701|200701|200701|200701|200701|200701|200702|200702|200702|200702|200702|200702|200702|200702|200702|200702|200702|200702|200703|200703|200703|200703|200703|200703|200703|200703|200703|200703|200703|200703|200704|200704|200704|200704|200704|200704|200704|200704|200704|200704|200704|200704|200705|200705|200705|200705|200705|200705|200705|200705|200705|200705|200705|200705|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|||||"; 
	        	   headTitle2 = "Sub Trade\n/Lane|POL|POD|SML|SML|COS|COS|KKL|KKL|YML|YML|OTH|OTH|POL TTL|POL TTL|SML|SML|COS|COS|KKL|KKL|YML|YML|OTH|OTH|POL TTL|POL TTL|SML|SML|COS|COS|KKL|KKL|YML|YML|OTH|OTH|POL TTL|POL TTL|SML|SML|COS|COS|KKL|KKL|YML|YML|OTH|OTH|POL TTL|POL TTL|SML|SML|COS|COS|KKL|KKL|YML|YML|OTH|OTH|POL TTL|POL TTL|SML|SML|COS|COS|KKL|KKL|YML|YML|OTH|OTH|POL TTL|POL TTL|||||"; 
	        	   headTitle3 = "Sub Trade\n/Lane|POL|POD|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|||||";
	        	   InitColumnInfo(63, 0, 0, true);
	        	   colCnt =5;
	           } else {
	        	   colCnt=eval(document.form.duration.value);
	           }
	           headCnt  = headTitle1.split("|").length;
	           InitColumnInfo(headCnt, 3, 0, true);
	           //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	           InitHeadRow(0, headTitle1, true);
	           InitHeadRow(1, headTitle2, true);
	           InitHeadRow(2, headTitle3, true);
	                   
	           //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	           InitDataProperty(	0, cnt++ , dtData,  	80,    daCenterTop,	true,	"sub_rlane_cd",			false,	"",      dfNone,	0,     true,	true);
	           if ( document.form.polpod_flg.value == 'POD' ) {    //POD별 조회면 POL,POD 순서를 바꿔준다.
	               InitDataProperty(	0, cnt++ , dtData,  80,    daCenterTop,	true,	"pod",					false,	"",      dfNone,	0,     true,    true);
	        	   InitDataProperty(	0, cnt++ , dtData,  80,    daCenterTop,	true,	"pol",					false,	"",      dfNone,	0,     true,    true);
	           } else {	  
	        	   InitDataProperty(	0, cnt++ , dtData,  80,    daCenterTop,	true,	"pol",					false,	"",      dfNone,	0,     true,    true);
	        	   InitDataProperty(	0, cnt++ , dtData,  80,    daCenterTop,	true,	"pod",					false,	"",      dfNone,	0,     true,    true);
	           }
	           for(var i=1 ; i <= 5 ; i++){
	        	   InitDataProperty(0, cnt++ , dtData,  	50,    daCenter,	true,	"wk"+i+"_hjs_qty",		false,  "",      dfNone,	0,     true,    true);
	        	   InitDataProperty(0, cnt++ , dtData,  	50,    daCenter,	true,	"wk"+i+"_hjs_wgt",		false,  "",      dfNone,	0,     true,    true);
	        	   InitDataProperty(0, cnt++ , dtData,  	50,    daCenter,	true,	"wk"+i+"_cos_qty",		false,  "",      dfNone,	0,     true,    true);
	        	   InitDataProperty(0, cnt++ , dtData,  	50,    daCenter,	true,	"wk"+i+"_cos_wgt",		false,  "",      dfNone,	0,     true,    true);
	        	   InitDataProperty(0, cnt++ , dtData,  	50,    daCenter,	true,	"wk"+i+"_kkl_qty",		false,  "",      dfNone,	0,     true,    true);
	        	   InitDataProperty(0, cnt++ , dtData,  	50,    daCenter,	true,	"wk"+i+"_kkl_wgt",		false,  "",      dfNone,	0,     true,    true);
	        	   InitDataProperty(0, cnt++ , dtData,  	50,    daCenter,	true,	"wk"+i+"_yml_qty",		false,  "",      dfNone,	0,     true,    true);
	        	   InitDataProperty(0, cnt++ , dtData,  	50,    daCenter,	true,	"wk"+i+"_yml_wgt",		false,  "",      dfNone,	0,     true,    true);
	        	   InitDataProperty(0, cnt++ , dtData,  	50,    daCenter,	true,	"wk"+i+"_oth_qty",		false,  "",      dfNone,	0,     true,    true);
	        	   InitDataProperty(0, cnt++ , dtData,  	50,    daCenter,	true,	"wk"+i+"_oth_wgt",		false,  "",      dfNone,	0,     true,    true);
	        	   InitDataProperty(0, cnt++ , dtData,  	55,    daCenter,	true,	"wk"+i+"_pol_qty",		false,  "",      dfNone,	0,     true,    true);
	        	   InitDataProperty(0, cnt++ , dtData,  	50,    daCenter,	true,	"wk"+i+"_pol_wgt",		false,  "",      dfNone,	0,     true,    true);
	           }
	           InitDataProperty(	0, cnt++ , dtData,  	55,    daCenter,	true,	"gtl_hjs_qty",			false,  "",      dfNone,	0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtData,  	55,    daCenter,	true,	"gtl_hjs_wgt",			false,  "",      dfNone,	0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtData,  	55,    daCenter,	true,	"gtl_cos_qty",			false,  "",      dfNone,	0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtData,  	55,    daCenter,	true,	"gtl_cos_wgt",			false,  "",      dfNone,	0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtData,  	55,    daCenter,	true,	"gtl_kkl_qty",			false,  "",      dfNone,	0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtData,  	55,    daCenter,	true,	"gtl_kkl_wgt",			false,  "",      dfNone,	0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtData,  	55,    daCenter,	true,	"gtl_yml_qty",			false,  "",      dfNone,	0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtData,  	55,    daCenter,	true,	"gtl_yml_wgt",			false,  "",      dfNone,	0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtData,  	55,    daCenter,	true,	"gtl_oth_qty",			false,  "",      dfNone,	0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtData,  	55,    daCenter,	true,	"gtl_oth_wgt",			false,  "",      dfNone,	0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtData,  	55,    daCenter,	true,	"gtl_pol_qty",			false,  "",      dfNone,	0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtData,  	55,    daCenter,	true,	"gtl_pol_wgt",			false,  "",      dfNone,	0,     true,    true);
	           
	           InitDataProperty(	0, cnt++ , dtHidden,	30,    daCenter,   	true,   "level",     			false,  "",      dfNone,    0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtHidden,	30,    daCenter,   	true,   "lvl0",     			false,  "",      dfNone,    0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtHidden,	30,    daCenter,   	true,   "grp_id",     			false,  "",      dfNone,    0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtHidden,	30,    daCenter,   	true,   "trd_cd",     			false,  "",      dfNone,    0,     true,    true);
	           InitDataProperty(	0, cnt++ , dtHidden,	30,    daCenter,   	true,   "width",     			false,  "",      dfNone,    0,     true,    true);
	           
	           sheetObj.ShowTreeLevel(0,1);
	           InitTreeInfo("level", "level", RgbColor(0,0,255), false);	  //트리 구조 세팅

	           for ( var i=21; i<headCnt-6; i++ ) {	  //최초 로딩시 3주차 까지 view
	        	   sheetObj.ColHidden(i) = true;
	           }
	           sheetObj.ColHidden(headCnt-1) = true;	//width컬럼 hidden처리
	           break;
	       }
       }
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
	        case IBSEARCH:      //조회 
				if(!validateForm(sheetObj,formObj,sAction)){
		            return false;
		        }
	        	document.form.duration.value = document.form.temp_duration.value;	//temp 값을  duration에 세팅
	        	if ( document.form.vvd.value !='' ) {	//vvd값이 있을경우 1주차로 처리한다.
	        		document.form.duration.value ='1'; 	        		
	        	}
	        	sheetObj.RemoveAll();
		        sheetObj.ReDraw=false;
		        sheetObj.WaitImageVisible=true;
		        doActionIBSheet(sheetObj,document.form,SEARCHLIST01);	//헤더 주차 조회 
		        formObj.f_cmd.value = SEARCHLIST;
		        var param = SpcFormString(formObj,'f_cmd,year,week,duration,rlane_cd,pol_cd,trade,subtrade,rhq,bound,operator,vvd,full_flg,polpod_flg');
		        sheetObj.DoSearch4Post("ESM_SPC_0083GS.do", param );
		        break;
	        case SEARCHLIST01:      //헤더 조회 및 세팅
				form.f_cmd.value = SEARCHLIST01;
	        	document.form.duration.value = document.form.temp_duration.value;	//temp 값을  duration에 세팅
	        	if ( document.form.vvd.value !='' ) {	//vvd값이 있을경우 1주차로 처리한다.
	        		document.form.duration.value ='1'; 	        		
	        	}
				var sXml = sheetObj.GetSearchXml("ESM_SPC_0083GS.do" , FormQueryString(form)); 
				//헤더 데이터를 설정한다.
				bse_dt = ComGetEtcData(sXml,"bse_dt");
				var headTitle = '';
    			for ( var i=0; i<bse_dt.split("|").length; i++ ) {
    				for ( var j=0; j<12; j++ ) {
        				headTitle = headTitle + bse_dt.split("|")[i]+"|";
    				}
    			} 
    			headTitle = "Sub Trade\n/Lane|POL|POD|"+headTitle+"G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL";
    			var headTitleCnt = headTitle.split("|").length;
    			for ( var i=0; i<headTitleCnt; i++ ) {
    				sheetObj.CellValue2(0,i) = headTitle.split("|")[i];	 
    			}
    			
    			if ( document.form.polpod_flg.value == 'POD' ) {	//POD 조회시 헤더 변경
        			sheetObj.CellValue2(0,1) = "POD";
        			sheetObj.CellValue2(0,2) = "POL";
        			sheetObj.CellValue2(1,1) = "POD";
        			sheetObj.CellValue2(1,2) = "POL";
        			
        			sheetObj.CellValue2(1,"wk1_pol_qty") = "POD TTL";
        			sheetObj.CellValue2(1,"wk1_pol_wgt") = "POD TTL";
        			sheetObj.CellValue2(1,"wk2_pol_qty") = "POD TTL";
        			sheetObj.CellValue2(1,"wk2_pol_wgt") = "POD TTL";
        			sheetObj.CellValue2(1,"wk3_pol_qty") = "POD TTL";
        			sheetObj.CellValue2(1,"wk3_pol_wgt") = "POD TTL";
        			sheetObj.CellValue2(1,"wk4_pol_qty") = "POD TTL";
        			sheetObj.CellValue2(1,"wk4_pol_wgt") = "POD TTL";
        			sheetObj.CellValue2(1,"wk5_pol_qty") = "POD TTL";
        			sheetObj.CellValue2(1,"wk5_pol_wgt") = "POD TTL";
        			sheetObj.CellValue2(1,"gtl_pol_qty") = "POD TTL";
        			sheetObj.CellValue2(1,"gtl_pol_wgt") = "POD TTL";
    			} else if ( document.form.polpod_flg.value == 'POL' ) {	//POD별 조회면 POL,POD 헤더 변경 순서를 바꿔준다.
        			sheetObj.CellValue2(0,1) = "POL";
        			sheetObj.CellValue2(0,2) = "POD";
        			sheetObj.CellValue2(1,1) = "POL";
        			sheetObj.CellValue2(1,2) = "POD";

        			sheetObj.CellValue2(1,"wk1_pol_qty") = "POL TTL";
        			sheetObj.CellValue2(1,"wk1_pol_wgt") = "POL TTL";
        			sheetObj.CellValue2(1,"wk2_pol_qty") = "POL TTL";
        			sheetObj.CellValue2(1,"wk2_pol_wgt") = "POL TTL";
        			sheetObj.CellValue2(1,"wk3_pol_qty") = "POL TTL";
        			sheetObj.CellValue2(1,"wk3_pol_wgt") = "POL TTL";
        			sheetObj.CellValue2(1,"wk4_pol_qty") = "POL TTL";
        			sheetObj.CellValue2(1,"wk4_pol_wgt") = "POL TTL";
        			sheetObj.CellValue2(1,"wk5_pol_qty") = "POL TTL";
        			sheetObj.CellValue2(1,"wk5_pol_wgt") = "POL TTL";
        			sheetObj.CellValue2(1,"gtl_pol_qty") = "POL TTL";
        			sheetObj.CellValue2(1,"gtl_pol_wgt") = "POL TTL";
    			}
				var colCnt=eval(document.form.duration.value);
    			var totalCnt = 5*12+12+3;		//5*12(5주차)+12(G TTL)+3(LINE,POL,POD) : 총 COL갯수
    			var focCnt = colCnt*12+2;	//
    			for ( var i=0; i<=totalCnt; i++ ) {
    				if ( i > focCnt ) {
    					sheetObj.ColHidden(i) = true;
    				} else {
    					sheetObj.ColHidden(i) = false;
    				}
    			}
    			var gTtlFlag = false;
    			if ( document.form.vvd.value.trim() !='' || document.form.duration.value =='1' ) {	//vvd값이 있을경우 G. TTL 부분 히든처리
    				gTtlFlag = true;
    			}
    			sheetObj.ColHidden("gtl_hjs_qty") = gTtlFlag;
    			sheetObj.ColHidden("gtl_hjs_wgt") = gTtlFlag;
    			sheetObj.ColHidden("gtl_cos_qty") = gTtlFlag;
    			sheetObj.ColHidden("gtl_cos_wgt") = gTtlFlag;
    			sheetObj.ColHidden("gtl_kkl_qty") = gTtlFlag;
    			sheetObj.ColHidden("gtl_kkl_wgt") = gTtlFlag;
    			sheetObj.ColHidden("gtl_yml_qty") = gTtlFlag;
    			sheetObj.ColHidden("gtl_yml_wgt") = gTtlFlag;
    			sheetObj.ColHidden("gtl_oth_qty") = gTtlFlag;
    			sheetObj.ColHidden("gtl_oth_wgt") = gTtlFlag;
    			sheetObj.ColHidden("gtl_pol_qty") = gTtlFlag;
    			sheetObj.ColHidden("gtl_pol_wgt") = gTtlFlag;
    			
    			showWeight(document.form.check_weight);	//체크박스 선택시 weight 컬럼을 펼칠지 여부
    			
    			break;
	        case IBDOWNEXCEL:        //엑셀 다운로드
				for(var Row=2; Row<=sheetObj.LastRow; Row++){	//엑셀 다운로드시 재정렬(문자,숫자 혼용시 랜덤하게 정렬됨)
					var alignFlg = "";
					if ( sheetObj.CellValue(Row, "lvl0") == '9') {	//VVD자리가 아닐때 정렬 문제 수정
						alignFlg = daCenter;
					} else {
						alignFlg = daRight;
					}					
					for ( var i=1; i<=eval(document.form.duration.value); i++ ) {
		    			sheetObj.CellAlign(Row,"wk"+i+"_hjs_qty") = alignFlg;
		    			sheetObj.CellAlign(Row,"wk"+i+"_hjs_wgt") = alignFlg;
		    			sheetObj.CellAlign(Row,"wk"+i+"_cos_qty") = alignFlg;
		    			sheetObj.CellAlign(Row,"wk"+i+"_cos_wgt") = alignFlg;
		    			sheetObj.CellAlign(Row,"wk"+i+"_kkl_qty") = alignFlg;
		    			sheetObj.CellAlign(Row,"wk"+i+"_kkl_wgt") = alignFlg;
		    			sheetObj.CellAlign(Row,"wk"+i+"_yml_qty") = alignFlg;
		    			sheetObj.CellAlign(Row,"wk"+i+"_yml_wgt") = alignFlg;
		    			sheetObj.CellAlign(Row,"wk"+i+"_oth_qty") = alignFlg;
		    			sheetObj.CellAlign(Row,"wk"+i+"_oth_wgt") = alignFlg;
		    			sheetObj.CellAlign(Row,"wk"+i+"_pol_qty") = alignFlg;
		    			sheetObj.CellAlign(Row,"wk"+i+"_pol_wgt") = alignFlg;
					}
					sheetObj.CellAlign(Row,"gtl_hjs_qty") = daRight;
					sheetObj.CellAlign(Row,"gtl_hjs_wgt") = daRight;
					sheetObj.CellAlign(Row,"gtl_cos_qty") = daRight;
					sheetObj.CellAlign(Row,"gtl_cos_wgt") = daRight;
					sheetObj.CellAlign(Row,"gtl_kkl_qty") = daRight;
					sheetObj.CellAlign(Row,"gtl_kkl_wgt") = daRight;
					sheetObj.CellAlign(Row,"gtl_yml_qty") = daRight;
					sheetObj.CellAlign(Row,"gtl_yml_wgt") = daRight;
					sheetObj.CellAlign(Row,"gtl_oth_qty") = daRight;
					sheetObj.CellAlign(Row,"gtl_oth_wgt") = daRight;
					sheetObj.CellAlign(Row,"gtl_pol_qty") = daRight;
					sheetObj.CellAlign(Row,"gtl_pol_wgt") = daRight;
				}	   
//	        	sheetObj.Down2Excel(-1, false, false, true);
	        	sheetObj.Down2Excel(-1, false, false, true,"","",true,false,"",false,"","",false,true,"");	//엑셀 오류 메세지 삭제 - 문자,숫자 혼용으로
		      	break;
    	}
    }
    
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
    	var trade = comObjects[0].Code;
    	var rhq   = formObj.rhq.value;
    	var vvd   = formObj.vvd.value;
    	if ( vvd.trim() == '' ) {	//vvd값이 없을때만 체크
	    	if(trade == "") {
	    		ComShowMessage(getMsg("SPC90114", "Trade"));
	    		comObjects[0].focus();
	    		return false;
	    	}
	    	
	    	if(rhq == "") {
	    		ComShowMessage(getMsg("SPC90114", "RHQ"));
	    		formObj.rhq.focus();
	    		return false;
	    	}
    	}
    	
    	return true;
    }
    
    /*
    * 셀을 클릭했을때 발생하는 이벤트 <br> 
    */
    function sheet1_OnClick(sheetObj, row, col){
    	switch(sheetObj.ColSaveName(col)){
    	case "pol":
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
    		}
    		break;
    	case "pod":
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
    		}
    		break;
    	}
    }    

    /**
     * sheet1 조회종료후 이벤트 호출
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	sheetObj.ShowTreeLevel(1);
    	showPol(document.form.check_pol);	//체크박스 선택시 pol 컬럼을 펼칠지 여부
    	showPod(document.form.check_pod);	//체크박스 선택시 pod 컬럼을 펼칠지 여부
    	showWeight(document.form.check_weight);	//체크박스 선택시 weight 컬럼을 펼칠지 여부
    	for(var Row=2; Row<=sheetObj.LastRow; Row++){
			sheetObj.CellAlign(Row,"sub_rlane_cd")= daCenterTop;	//정렬 버그 수정
			sheetObj.CellAlign(Row,"pol")= daCenterTop;				//정렬 버그 수정
			sheetObj.CellAlign(Row,"pod")= daCenterTop;				//정렬 버그 수정
			if ( sheetObj.CellValue(Row, "lvl0") == '9') {	//VVD
				for ( var i=1; i<=5; i++ ) {	//화면 정렬버그 및 excel 정렬버그 수정
	    			sheetObj.CellAlign(Row,"wk"+i+"_hjs_qty") = daCenter;
	    			sheetObj.CellAlign(Row,"wk"+i+"_hjs_wgt") = daCenter;
	    			sheetObj.CellAlign(Row,"wk"+i+"_cos_qty") = daCenter;
	    			sheetObj.CellAlign(Row,"wk"+i+"_cos_wgt") = daCenter;
	    			sheetObj.CellAlign(Row,"wk"+i+"_kkl_qty") = daCenter;
	    			sheetObj.CellAlign(Row,"wk"+i+"_kkl_wgt") = daCenter;
	    			sheetObj.CellAlign(Row,"wk"+i+"_yml_qty") = daCenter;
	    			sheetObj.CellAlign(Row,"wk"+i+"_yml_wgt") = daCenter;
	    			sheetObj.CellAlign(Row,"wk"+i+"_oth_qty") = daCenter;
	    			sheetObj.CellAlign(Row,"wk"+i+"_oth_wgt") = daCenter;
	    			sheetObj.CellAlign(Row,"wk"+i+"_pol_qty") = daCenter;
	    			sheetObj.CellAlign(Row,"wk"+i+"_pol_wgt") = daCenter;
				}
			}
    	}
    	if ( bse_dt.split("|").length == 1 ) {	//Duration이 1주차(vvd값이 있을시)라면  히든width=100 설정
    		sheetObj.ColHidden("width") = false;
    		sheetObj.ColWidth("width") = 100; 
    	} else {
    		sheetObj.ColHidden("width") = true;
    	}
    	if ( document.form.polpod_flg.value =='POL' ) {    //POL 조회시 
    		document.getElementById("pol").innerHTML = 'POL';
			document.getElementById("pod").innerHTML = 'POD';
		} else if ( document.form.polpod_flg.value =='POD' ) {	//POD별 조회면 POL,POD 순서를 바꿔준다.
    		document.getElementById("pol").innerHTML = 'POD';
			document.getElementById("pod").innerHTML = 'POL';
		}
    	sheetObj.Redraw = true;
	}
      
      
    /*
     * 체크박스 선택시 pol 컬럼을 펼칠지 여부
  	 */
  	function showPol(obj){   
  		type = obj.checked;
  		sheetObj = sheetObjects[0];
		var row = 0;
		var findTxt = "";
		var replTxt = "";
  		if ( type ) {
  			sheetObj.ShowTreeLevel(1);
  			findTxt = "+";
  			replTxt = "-";
  			
  		} else {
  			sheetObj.ShowTreeLevel(0,1);
  			findTxt = "-";
  			replTxt = "+";
  		}
		while((row = sheetObj.FindText("pol", findTxt, row)) > 0){
			sheetObj.CellValue2(row, "pol") = replTxt;
		}
		
  	}      
    /*
     * 체크박스 선택시 pod 컬럼을 펼칠지 여부
     */
    function showPod(obj){   
    	type = obj.checked;
  		sheetObj = sheetObjects[0];
		var row = 0;
		var findTxt = "";
		var replTxt = "";
  		if ( type ) {
  			sheetObj.ShowTreeLevel(2,2);
  			findTxt = "+";
  			replTxt = "-";
  			
  		} else {
  			sheetObj.ShowTreeLevel(1,1);
  			findTxt = "-";
  			replTxt = "+";
  		}
		while((row = sheetObj.FindText("pod", findTxt, row)) > 0){
			sheetObj.CellValue2(row, "pod") = replTxt;
		}
  	}
    
    /*
     * 체크박스 선택시 weight 컬럼을 펼칠지 여부
     */
    function showWeight(obj){   
    	type = obj.checked;
  		sheetObj = sheetObjects[0];
		
  		sheetObj.RowHidden(2) = !type;
  		
		for ( var i=1; i<=eval(document.form.duration.value); i++ ) {
			sheetObj.ColHidden("wk"+i+"_hjs_wgt") = !type;
			sheetObj.ColHidden("wk"+i+"_cos_wgt") = !type;
			sheetObj.ColHidden("wk"+i+"_kkl_wgt") = !type;
			sheetObj.ColHidden("wk"+i+"_yml_wgt") = !type;
			sheetObj.ColHidden("wk"+i+"_oth_wgt") = !type;
			sheetObj.ColHidden("wk"+i+"_pol_wgt") = !type;
		}
		
		if ( document.form.vvd.value.trim() !='' || document.form.duration.value =='1' ) {	//vvd값이 있을경우 G. TTL 부분 히든처리
			type = false;
		}
		
		sheetObj.ColHidden("gtl_hjs_wgt") = !type;
		sheetObj.ColHidden("gtl_cos_wgt") = !type;
		sheetObj.ColHidden("gtl_kkl_wgt") = !type;
		sheetObj.ColHidden("gtl_yml_wgt") = !type;
		sheetObj.ColHidden("gtl_oth_wgt") = !type;
		sheetObj.ColHidden("gtl_pol_wgt") = !type;
  	}
     
    /*
     * Sub Trade OnChange시
     */
    function subtrade_OnChange_t(comObj,value,text ){  
//    	 if(text == '||ALL'){   optionAllReset2("subtrade",document.form.trade.Code,"true"); return; } // 0207 SHKIM
    	SpcSearchOptionLane("rlane_cd",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM
   	 	if(value == "") return;
     	var arrTrade = text.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[0].Code2 = arrTrade[0];
    		comObjects[2].Code2 = '';
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    		comObjects[2].Code2 = '';
    	}   
//    	SpcSearchOptionLane("rlane_cd",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM
    } 
     
    /*
     * lane OnChange시
     */     
    function rlane_cd_OnChange_t(comObj,value,text ){
    	var arrLane = text.split("|");
    	if(arrLane.length > 1) {
    		comObjects[0].Code2 = arrLane[0];
    		comObjects[1].Code2 = arrLane[1];
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    		comObjects[1].Code2 = comObj.GetText(value,1);  
    	}	     	
    }     
    
    function initDataValue_trade(){
     	var sheetObj = document.getElementById("trade");
     	with(sheetObj){
     		Index2 = 0;
     	}
     }
     
     function initDataValue_subtrade(){
     	var sheetObj = document.getElementById("subtrade");
     	with(sheetObj){
     		Index2 = 0;
     	}
     }
     
     function initDataValue_rlane_cd(){
     	var sheetObj = document.getElementById("rlane_cd");
     	with(sheetObj){
     		Index2 = 0;
     	}
     }    
     
     function trade_OnChange_t(comObj,value,text ){
//    	if(text == '|ALL'){	optionAllReset2("trade",value,"true");   return;} // 0207 SHKIM
//     	if(value == "" ) return;
     	var repTrade = comObj.GetText(value,0);  
     	comObjects[1].Code2 = ""; //sub trade
     	comObjects[2].Code2 = ""; // lane
     	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
		SpcSearchOptionLane("rlane_cd",true,false,'',value,'',true);	// 0207 SHKIM
     }      
     /**
      * Start Week 의 year 변경시
      * Start Week 의 year 변경시 주차 변경
      */
     function checkWeek(){
     	SpcSearchOptionWeek("week",false,document.form.year.value);
     }        
     /**************** IE11지원을 위해 combobox 잔상 제거용 코드 추가 ****************/
	 /*
	  * 기존의 onChange를 onChange_t로 변경하고, onChange에서는 timeout을 두어 onChange_t를 호출하도록 변경함
	  */
	 function trade_OnFocus(combj, value, text){
        document.getElementById("year").focus();
        document.getElementById("trade").focus(); 
	 }

	 function subtrade_OnFocus(combj, value, text){
        document.getElementById("year").focus();
        document.getElementById("subtrade").focus(); 
	 }
	 
	 function rlane_cd_OnFocus(combj, value, text){
        document.getElementById("year").focus();
        document.getElementById("rlane_cd").focus(); 
	 }
	 
	 function trade_OnChange(combj, value, text){
		 var formObj = document.form;
		 setTimeout(function(){trade_OnChange_t(combj,value,text)},10);
	 }

	 function subtrade_OnChange(combj, value, text){
		 var formObj = document.form;
		 setTimeout(function(){subtrade_OnChange_t(combj,value,text)},10);
	 }
	 function rlane_cd_OnChange(combj, value, text){
		 var formObj = document.form;
		 setTimeout(function(){rlane_cd_OnChange_t(combj,value,text)},10);
	 }

     
	/* 개발자 작업  끝 */