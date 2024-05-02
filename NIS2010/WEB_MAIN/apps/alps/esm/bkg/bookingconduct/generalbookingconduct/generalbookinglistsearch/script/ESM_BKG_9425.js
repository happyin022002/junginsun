/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_9425.js
*@FileTitle : Empty REPO BKG Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.30 김병규
* 1.0 Creation
===============================================================================
* History
* 2011.05.16 이일민 [CHM-201110731] EQR > Empty Repo BKG Inquiry의 POL,POD date 컬럼 추가
* 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
* 2011.11.28 금병주 [CHM-201114690-01] MTY BKG Inquiry 기능에 G.TTL(TEU 기준) 추가
* 2013.10.10 최문환 [CHM-201326810] MT BKG Inquiry 화면 상 GOH CNTR 대수 표시 방법 변경
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
     * @class ESM_BKG_9425 : ESM_BKG_9425 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_9425() {
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
    var comboCnt = 0 ;
    
    // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //  
    var tpszallText = "D2|D4|D5|D7|DX|R2|R5|R9|O2|O4|O5|O7|S2|S4|F2|F4|F5|A2|A4|A5"; 
    var tpszallCode = "D2|D4|D5|D7|DX|R2|R5|R9|O2|O4|O5|O7|S2|S4|F2|F4|F5|A2|A4|A5"; 
    var tpszdryText = "D2|D4|D5|D7|DX";    // DRY TYPE SIZE
    var tpszdryCode = "D2|D4|D5|D7|DX";
    var tpszrfrText = "R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode = "R2|R5|R9";
    var tpszotText  = "O2|O4|O5|O7|S2|S4";    // OT  TYPE SIZE 
    var tpszotCode  = "O2|O4|O5|O7|S2|S4";
    var tpszfrText  = "F2|F4|F5|A2|A4|A5"; // FR  TYPE SIZE 
    var tpszfrCode  = "F2|F4|F5|A2|A4|A5"; 
    
    var consTpsz      = "D2,D4,D5,D7,DX,R2,R5,R9,O2,O4,O5,O7,S2,S4,F2,F4,F5,A2,A4,A5";
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = "D2,D4,D5,D7,DX";
    var consTpszRfr   = "R2,R5,R9";
    var consTpszOt    = "O2,O4,O5,O7,S2,S4";
    var consTpszFr    = "F2,F4,F5,A2,A4,A5";
    // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //	
	
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
            	case "btn_Retrieve":
            		doActionIBSheet(sheetObject,formObject,IBSEARCH);
            		break;

            	case "btn_New":
            		ComResetAll();
            		setInitData();
            		break;

            	case "btn_Cntr":
            		if(sheetObject.RowCount < 1){
            			ComShowCodeMessage("BKG00567");
            		}else{
            			var bkgNo =sheetObject.CellValue(sheetObject.SelectRow, "bkg_no");
            			ComOpenPopup("ESM_BKG_9450.do?pgmNo=ESM_BKG_9450&bkg_no="+bkgNo, 430, 520, "","1,0,1,1,1", true); 		        		
            		}
 		        	break;
 		        	
 		        case "btns_Calendar": //달력버튼
 		         	var cal = new ComCalendarFromTo();
            		cal.select(formObject.cre_from_dt,formObject.cre_to_dt, 'yyyy-MM-dd');
	            	break;	
	            	
		        case "btn_DownExcel": 
		        	ComOpenWait(true); 
		        	sheetObject.SpeedDown2Excel(-1);
		        	ComOpenWait(false); 
	            	break;
	            	
		        case "btn_HangerDownExcel":
	          		doActionIBSheet(sheetObjects[2],formObject,COMMAND01);
		        	break;
             } // end switch
     	}catch(e) {
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
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	setInitData();
    	initControl();      
    	    	
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }    	
        document.form.cntrTpsz.selectedIndex = 0; // Dry 선택
        tpszChange(''); // Dry 선택
//         ComOpenWindowCenter("/hanjin/ESM_BKG_9424.do?mainPage=false&pgmNo=ESM_BKG_9424&bkgno=ALY101411701&bkgdiv=2", "ESM_BKG_9424", 1024, 650, true, "yes")
    }

    function setInitData(){
        var formObj = document.form;   
        var todate = new Date();
        var calToDate = new Date(new Date(Date.parse(todate)-30*1000*60*60*24));
        ComSetObjValue(formObj.cre_from_dt, ""+calToDate.getFullYear()+"-"+ComLpad(calToDate.getMonth()+1,2,"0")+"-"+ComLpad(calToDate.getDate(),2,"0"));
        ComSetObjValue(formObj.cre_to_dt, ComGetNowInfo("yy")+"-"+ComLpad(ComGetNowInfo("mm"),2,"0")+"-"+ComLpad(ComGetNowInfo("dd"),2,"0"));
        ComSetObjValue(formObj.today, ComGetNowInfo("yy")+"-"+ComLpad(ComGetNowInfo("mm"),2,"0")+"-"+ComLpad(ComGetNowInfo("dd"),2,"0"));
        
        document.form.cntrTpsz.selectedIndex = 0; // Dry 선택
        tpszChange(''); // Dry 선택        
    }
      
    function initControl() {
    	var formObject = document.form;
      	axon_event.addListenerFormat('keypress','obj_KeyPress',formObject); //- 키보드 입력할때
      	axon_event.addListenerForm('beforedeactivate', 'bkg9425_deactivate',  formObject); //- 포커스 나갈때
      	axon_event.addListenerForm('click', 'bkg9425_click',    formObject); //- 클릭시
      	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
      	axon_event.addListenerForm('change','form_change',form);
    }        
      
	function bkg9425_deactivate(){
		var srcName = event.srcElement.getAttribute("name");
		var srcValue = event.srcElement.getAttribute("value");
		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
		var formObject = document.form;
		if(srcName == "cntr_no1"){
			if (ComChkLen(srcValue, srcMaxLength) == "2") {
    			ComSetObjValue(formObject.f_cmd, SEARCHLIST11);
    			var sXml = sheetObjects[1].GetSearchXml("ESM_BKG_9424GS.do?cntr_no="+srcValue, FormQueryString(formObject));
    			if(ComGetEtcData(sXml,"chk_digit") == undefined || ComGetEtcData(sXml,"chk_digit") == ""){
    				ComShowCodeMessage("BKG01028");
    				ComSetObjValue(formObject.cntr_no2,"");
    			}else{
    				ComSetObjValue(formObject.cntr_no2, ComGetEtcData(sXml,"chk_digit"));
    			}    			
			}
			
			if(ComIsNull(ComGetObjValue(formObject.cntr_no1))){
				ComSetObjValue(formObject.cntr_no2,"");
			}
	    }
		else if(srcName == "cre_from_dt"){
			if(ComGetObjValue(formObject.cre_from_dt)!="" && !ComIsDate(ComGetObjValue(formObject.cre_from_dt))){
				ComShowCodeMessage("BKG00421");
				ComSetFocus(formObject.cre_from_dt);
			}
		}else if(srcName == "cre_to_dt"){
			if(ComGetObjValue(formObject.cre_to_dt)!="" && !ComIsDate(ComGetObjValue(formObject.cre_to_dt))){
				ComShowCodeMessage("BKG00421");
				ComSetFocus(formObject.cre_to_dt);
			}
		}
	}  

	function bkg9425_click(){
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");

    	if(srcName == "cre_from_dt"){
    		ComSetFocus(formObject.cre_from_dt);
    	}else if(srcName == "cre_to_dt"){
    		ComSetFocus(formObject.cre_to_dt);
    	}
	}
	
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;
        switch(sheetNo) {
        	case 1:      //t1sheet1 init
        		with (sheetObj) {
        			// 높이 설정
        			style.height = 382;
        			//전체 너비 설정
        			SheetWidth = mainTable.clientWidth;

        			//Host정보 설정[필수][HostIp, Port, PagePath]
        			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

        			//전체Merge 종류 [선택, Default msNone]
        			MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
        			Editable = true;

        			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        			InitRowInfo(2, 1, 3, 100);

        			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        			// 2011.11.28 gttl값 추가 kbj
        			InitColumnInfo(48, 0, 0, true);

        			// 해더에서 처리할 수 있는 각종 기능을 설정한다
        			InitHeadMode(true, true, false, true, false, false);

        			// 2011.11.28 gttl값 추가 kbj
        			var HeadTitle1 = "|Seq.|Booking No.|B/L No.|Ind.|B|T/S|VVD Code|Lane|EMT|POL|ETB POL|POD|ETA POD|TEU|FEU|TTL|RHQ OFC|CNTR Volume|Booking date|CNTR Attach date|Dry (GOH included)|Dry (GOH included)|Dry (GOH included)|Dry (GOH included)|DX|R2|R5|R9|F2|F4|F5|O2|O4|O5|O7|A2|A4|A5|S2|S4|GOH Only|GOH Only|GOH Only|GOH Only|Remarks";
                    var HeadTitle2 = "|Seq.|Booking No.|B/L No.|Ind.|B|T/S|VVD Code|Lane|EMT|POL|ETB POL|POD|ETA POD|TEU|FEU|TTL|RHQ OFC|CNTR Volume|Booking date|CNTR Attach date|D2|D4|D5|D7|DX|R2|R5|R9|F2|F4|F5|O2|O4|O5|O7|A2|A4|A5|S2|S4|D2|D4|D5|D7|Remarks";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  		 0,     daCenter, false,  		"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,       			30,     daCenter, true,  		"seq");
                    InitDataProperty(0, cnt++ , dtData,      			90,   	daLeft,   true,     	"bkg_no",  					false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			90,     daCenter, true,     	"bl_no",     				false,          "",      dfNone ,   			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			30,     daCenter, true,     	"ind",     					false,          "",      dfNone ,    			0,    false,	false);
                    
                    InitDataProperty(0, cnt++ , dtData,      			20,     daCenter, true,     	"bundle",     				false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtPopup,     			40,     daLeft,   true,     	"ts",     					false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			70,     daCenter, true,     	"vvd",     					false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,     daCenter, true,     	"lane",     				false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			30,     daCenter, true,     	"emt",     					false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			60,     daCenter, true,     	"pol_cd",     				false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			110,    daCenter, true,     	"pol_etb",     				false,          "",      dfUserFormat2,    		0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			60,     daCenter, true,     	"pod_cd",     				false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			110,    daCenter, true,     	"pod_eta",     				false,          "",      dfUserFormat2,    		0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			45,     daCenter, true,     	"teu",     					false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			45,     daCenter, true,     	"feu",     					false,          "",      dfNone ,    			0,    false,	false);
                    //2011.11.28 gttl값 추가 kbj
                    InitDataProperty(0, cnt++ , dtData,      			45,     daCenter, true,     	"gttl",    					false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			60,     daCenter, true,     	"bkg_ofc_cd",     			false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			90,     daCenter, true,     	"cntr_volumn",     			false,          "",      dfNone ,    			0,    false,	false);
                    
                    InitDataProperty(0, cnt++ , dtData,      			90,   	daCenter, true,     	"booking_date",    			false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			110,    daCenter, true,     	"cntr_attach_date",   		false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, false,     	"d2",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, false,     	"d4",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, false,     	"d5",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, false,     	"d7",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"dx",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"r2",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"r5",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"r9",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"f2",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"f4",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"f5",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"o2",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"o4",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"o5",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"o7",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"a2",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"a4",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"a5",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"s2",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, true,     	"s4",   					false,          "",      dfNone ,  				0,    false,	false);                     
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, false,     	"d2_h",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, false,     	"d4_h",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, false,     	"d5_h",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			40,   	daCenter, false,     	"d7_h",   					false,          "",      dfNone ,  				0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,      			200,    daLeft,   true,     	"remark",  					false,          "",      dfNone ,   			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,      			80,     daCenter, false,     	"emt_desc");
                    InitDataProperty(0, cnt++ , dtHidden,      			80,     daCenter, false,     	"ind_desc");

                    InitUserFormat2(0, "pol_etb", "####-##-## ##:##", "-|:");  
                    InitUserFormat2(0, "pod_eta", "####-##-## ##:##", "-|:");

                    ShowButtonImage = 2;			
                    //CountPosition = 0;							
                }
                break;
                
			case 2:
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
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
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(2, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false,false)
					
					var HeadTitle = "";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,		"ibflag");
				}
				break;

        	case 3:
        		with (sheetObj) {
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
        			InitRowInfo(1, 1, 3, 100);

        			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        			// 2011.11.28 gttl값 추가 kbj
        			InitColumnInfo(11, 0, 0, true);

        			// 해더에서 처리할 수 있는 각종 기능을 설정한다
        			InitHeadMode(true, true, false, true, false, false)

        			// 2011.11.28 gttl값 추가 kbj
        			var HeadTitle1 = "POL|POD|POD ETA|CNTR NO|CNTR Type size|HRT|HBT|HBQ|BKG NO|PRE BKG NO|S.Bar Qty";
        			                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  true,     	"pol_cd",  				false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  true,     	"pod_cd",     			false,          "",      dfNone ,   			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  true,     	"pod_eta",     			false,          "",      dfUserFormat2 ,    	0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  true,     	"cntr_no",     			false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  true,     	"cntr_tpsz_cd",     	false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  true,     	"hrt",     				false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  true,     	"hbt",     				false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  true,     	"hbq",     				false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,     90,	   daCenter,  true,     	"bkg_no",     			false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  true,     	"pre_bkg_no",     		false,          "",      dfNone ,    			0,    false,	false);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  true,     	"s_bar_qty",     		false,          "",      dfNone ,    			0,    false,	false);                    
                    InitUserFormat2(0, "pod_eta", "####-##-## ##:##", "-|:");
                }
                break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction){
            case IBSEARCH:      //조회
            	if(validateForm(sheetObj,formObj,sAction)){
            		resetData(sheetObj,formObj);
            		ComSetObjValue(formObj.f_cmd, SEARCH);
            		sheetObj.WaitImageVisible=false;
            		ComOpenWait(true);            		
            		var sXml = sheetObj.GetSearchXml("ESM_BKG_9425GS.do", FormQueryString(formObj));    
         			ComOpenWait(false);        		
            		sheetObj.LoadSearchXml(sXml);
            		BkgEtcDataXmlToForm(sXml, formObj);	
            		
         			var teuSum = 0;
         			var feuSum = 0;
         			var gttlSum = 0; 
         			for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){         			
         				teuSum = teuSum + BkgParseInt(sheetObj.CellValue(i, "teu"));
         				feuSum = feuSum + BkgParseInt(sheetObj.CellValue(i, "feu"));
         				//2011.11.28 sum_gttl값 추가 kbj
         				gttlSum  = gttlSum + BkgParseInt(sheetObj.CellValue(i, "gttl"));
         			}
         			ComSetObjValue(formObj.sum_teu, teuSum);
         			ComSetObjValue(formObj.sum_feu, feuSum);   
         			ComSetObjValue(formObj.sum_box, teuSum+feuSum);
         			//2011.11.28 sum_gttl값 추가 kbj
         			ComSetObjValue(formObj.sum_g_ttl, gttlSum );
            	}
            	break;
            	
            case COMMAND01: //hanger excel down
            	if(validateForm(sheetObj,formObj,sAction)){
            		ComSetObjValue(formObj.f_cmd, COMMAND01);
            		sheetObj.WaitImageVisible=false;
            		ComOpenWait(true);            		
            		var sXml = sheetObj.GetSearchXml("ESM_BKG_9425GS.do", FormQueryString(formObj));    
         			ComOpenWait(false);        		
            		sheetObj.LoadSearchXml(sXml);
            		
            		if (sheetObj.TotalRows > 0) {
            			sheetObj.SpeedDown2Excel(-1);
            		} else {
            			ComShowCodeMessage("BKG00095");
            		}
            	}
            	break;
         }
    }
   
   	// 조회시 기조회된 정보를 지운다.
   	function resetData(sheetObj, formObj){
   		sheetObj.RemoveAll();
	    ComSetObjValue(formObj.sum_teu , "0");
	    ComSetObjValue(formObj.sum_feu , "0");
	    ComSetObjValue(formObj.sum_box , "0");
	    /*
	     * 2011.11.24 sum_g_ttl값 추가 kbj
		 */
	    ComSetObjValue(formObj.sum_g_ttl , "0");
	    ComSetObjValue(formObj.sum_d2 , "0");
	    ComSetObjValue(formObj.sum_d4 , "0");
	    ComSetObjValue(formObj.sum_d5 , "0");
	    ComSetObjValue(formObj.sum_d7 , "0");
	    ComSetObjValue(formObj.sum_dx , "0");
	    ComSetObjValue(formObj.sum_r2 , "0");
	    ComSetObjValue(formObj.sum_r5 , "0");
	    ComSetObjValue(formObj.sum_r9 , "0");
	    ComSetObjValue(formObj.sum_f2 , "0");
	    ComSetObjValue(formObj.sum_f4 , "0");
	    ComSetObjValue(formObj.sum_f5 , "0");
	    ComSetObjValue(formObj.sum_o2 , "0");
	    ComSetObjValue(formObj.sum_o4 , "0");
	    ComSetObjValue(formObj.sum_o5 , "0");
	    ComSetObjValue(formObj.sum_o7 , "0");
	    ComSetObjValue(formObj.sum_a2 , "0");
	    ComSetObjValue(formObj.sum_a4 , "0");
	    ComSetObjValue(formObj.sum_a5 , "0");
	    ComSetObjValue(formObj.sum_s2 , "0");
	    ComSetObjValue(formObj.sum_s4 , "0");	   
   	}
   
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
  		switch(sAction) {
  			case IBSEARCH:      //조회
		    	if(ComIsNull(formObj.bkg_no) && ComIsNull(formObj.bl_no) && ComIsNull(formObj.vvd_cd)){
		    		if(ComIsNull(formObj.cre_from_dt)){
		    			ComSetFocus(formObj.cre_from_dt);
		    			ComShowCodeMessage("BKG00819");
		    			return false;
		    		}
		    		if(ComIsNull(formObj.cre_to_dt)){
		    			ComSetFocus(formObj.cre_to_dt);
		    			ComShowCodeMessage("BKG00819");
		    			return false;    			 
		    		}
	    			if(!ComIsDate(ComGetObjValue(formObj.cre_from_dt))){
	    				ComShowCodeMessage("BKG00421");
	    				ComSetFocus(formObj.cre_from_dt);
	    				return false;    
	    			}
	    			if(!ComIsDate(ComGetObjValue(formObj.cre_to_dt))){
	    				ComShowCodeMessage("BKG00421");
	    				ComSetFocus(formObj.cre_to_dt);
	    				return false;
	    			}

		    		if(ComIsNull(formObj.cntr_no1)){
		    			if(ComIsNull(formObj.pol_cd) && ComIsNull(formObj.pod_cd) && ComIsNull(formObj.bkg_ofc_cd)){
		    				ComShowCodeMessage("BKG00820");
		    				ComSetFocus(formObj.vvd_cd);
		    				return false;    			     			 
		    			}
		    		}
		    		if(ComGetObjValue(formObj.vvd_cd_flg) == "E" && ComIsNull(formObj.vvd_cd)){
		    			ComShowCodeMessage("BKG00115");
		    			ComSetFocus(formObj.vvd_cd);
		    			return false;    			 
		    		}    		 
		    		if(ComGetObjValue(formObj.bkg_date_tp) == "E" && ComIsNull(formObj.pod_cd)){
		    			ComShowCodeMessage("BKG00104","POD");
		    			ComSetFocus(formObj.pod_cd);
		    			return false;    			     			 
		    		}
		    	} else {
		    		if(!ComIsNull(formObj.bkg_no) && formObj.bkg_no.value.length < 11){
		    			ComShowCodeMessage("BKG00835");
		    			ComSetFocus(formObj.bkg_no);
		    			return false;    			 
		    		}
		    		if(!ComIsNull(formObj.bl_no) && formObj.bl_no.value.length != 12){
		    			ComShowCodeMessage("BKG00241");
		    			ComSetFocus(formObj.bl_no);
		    			return false;    			 
		    		}
		    		if(!ComIsNull(formObj.vvd_cd) && formObj.vvd_cd.value.length != 9){
		    			ComShowCodeMessage("BKG00833");
		    			ComSetFocus(formObj.vvd_cd);
		    			return false;    			 
		    		}	
		    	}
		    	return true;
		    	break;
		    	
  			case COMMAND01:      //Hanger
	  			if(ComIsNull(formObj.cre_from_dt)){
	    			ComSetFocus(formObj.cre_from_dt);
	    			ComShowCodeMessage("BKG00819");
	    			return false;
	    		}
	    		if(ComIsNull(formObj.cre_to_dt)){
	    			ComSetFocus(formObj.cre_to_dt);
	    			ComShowCodeMessage("BKG00819");
	    			return false;    			 
	    		}
	    		if(ComGetObjValue(formObj.bkg_date_tp) == "B"){
	    			ComShowCodeMessage("BKG08289");
	    			return false;	    			
	    		}
	    		
				if (ComGetDaysBetween(formObj.cre_from_dt.value, formObj.cre_to_dt.value) < 0) {
	    			ComSetFocus(formObj.cre_from_dt);
	    			ComShowCodeMessage("BKG95009", "Period");
					return false;
				} 		
				if (ComGetDaysBetween(formObj.cre_from_dt.value, formObj.cre_to_dt.value) > 31){
	    			ComSetFocus(formObj.cre_from_dt);
	    			ComShowCodeMessage("BKG50469");
					return false;
				}
				if (ComGetDaysBetween(formObj.cre_from_dt.value, formObj.today.value) > 45){
	    			ComSetFocus(formObj.cre_from_dt);
	    			ComShowCodeMessage("BKG08288");
					return false;
				}

    			if(ComIsNull(formObj.pod_cd)){
    				ComShowCodeMessage("BKG00210");
    				ComSetFocus(formObj.pod_cd);
    				return false;    			     			 
    			}
  				return true;
  				break;
  		}
    }

 	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg){		
 		var formObject = document.form;
 		if(ErrMsg == ""){

 		}
 	}
 	
 	function sheet1_OnPopupClick(sheetObj, Row,Col){
 
 		with(sheetObj){ 			
 			if (CellValue(Row,Col) == "Y") {
 				ComOpenPopup("ESM_BKG_9454.do?pgmNo=ESM_BKG_9454&bkg_no="+sheetObj.CellValue(Row,"bkg_no"), 600, 480, "","1,0,1,1,1", true);
 			}else { 				
 			   return
 			}
 		}
 	}

 	function sheet1_OnMouseMove(sheetObj,Button,Shift, X, Y){ 
 		//alert(2);
 		sheetObj.ToolTipText(0,"ind") = "S: Sound, H: Hanger rack, D: Damaged";
 		sheetObj.ToolTipText(0,"bundle") = "Bundle";      
 	}
 	
    /**
     * 설  명 : TP/SZ 종류 변경시 코드 설정 <br>
     * <br><b>Example : </b>
     * <pre>
     *     tpszChange('')
     * </pre>
     * @param {String}  key - tpsz Combo Value('' - ALL, D - Dry, R - Refer, O - O/T, F - F/R)
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function tpszChange(key){
        switch (key) {
        case "":
            document.form.tpsztype.Code = consTpsz;                     
            break;
        case "D":
            document.form.tpsztype.Code = consTpszDry;                
            break;
        case "R":
            document.form.tpsztype.Code = consTpszRfr;
            break;
        case "O":
            document.form.tpsztype.Code = consTpszOt;
            break;
        case "F":
            document.form.tpsztype.Code = consTpszFr;
            break;
        }
    } 	
    
    /**
     * 설  명 :  Combo 기본 설정 <br>
     * <br><b>Example : </b>
     * <pre>
     *     initCombo(comboObj,comboNo)
     * </pre>
     * @param {object}  comboObj - Combo Object
     * @param {Number}  comboNo  - Combo Number
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function initCombo (comboObj, comboNo) {
        var cnt  = 0 ;
        
        switch(comboObj.name) {       
            // Type Size
            case "tpsztype":
                with (comboObj) {               
                    DropHeight = 12 * 20;
                    
                    var menuname = tpszallText.split('|'); 
                    var menucode = tpszallCode.split('|'); 
                    
                    MultiSelect = true;
                    MaxSelect = menuname.length;
                    MultiSeparator = ",";
                    
                    for(i=0; i<menuname.length; i++) {
                        InsertItem(cnt++, menuname[i], menucode[i]);                            
                    } 
                }
                break;
        }
    }    

    /**
     * 설  명 : IBCombo Object를 배열로 등록 <br>
     *          향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     *          배열은 소스 상단에 정의<br>
     * <br><b>Example : </b>
     * <pre>
     *     setComboObject(combo_obj)
     * </pre>
     * @param {object}  combo_obj - Combo Object
     * @see #링크연결
     * @author 작성자
     * @version 
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * 설  명 : Form Object의 Change Event <br>
     * <br><b>Example : </b>
     * <pre>
     *     form_change()
     * </pre>
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function form_change(){
        var srcName = window.event.srcElement.getAttribute("name");
        
        if ( srcName == "cntrTpsz"){
			ComOpenWait(true);
            var index = document.form.cntrTpsz.selectedIndex;
            tpszChange(document.form.cntrTpsz.options[index].value);
			ComOpenWait(false);
        }
    }
	/* 개발자 작업  끝 */