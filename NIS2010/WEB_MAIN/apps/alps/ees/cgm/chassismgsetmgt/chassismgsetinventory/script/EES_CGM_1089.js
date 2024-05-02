/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1089.js
*@FileTitle : General Inventory
*@FileName : EES_CGM_1122.js
*@FileTitle : General Inventory Graphic
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.16 김창식
* 2009.08.06 조재성
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.12.08 신혜정 [CHM-201115037-01] Location 'USNYC' default 셋팅   
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


    /**
     * @extends 
     * @class EES_CGM_1089 : EES_CGM_1089 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1089() {
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
    
    var rdObjects = new Array();
    var rdCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;

    var IBSEARCH02 = 30;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.15
     */ 
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

         var rdObject = rdObjects[0];

        try {
        	var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            	case "btn_retrieve":
            		if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
            			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            	        rdOpen(); 
            		}
            		formObject.crnt_loc_cd.focus(); //조회후 focus는 location으로 가게 만든다. 
                    break;

                case "btn_new":
                	initControl();
                    break;

                case "btn_downexcel":
                	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                    break;

                case "btn_print":
	               	 if(formObject.doc_type[0].checked){
       					if( sheetObjects[0].rowcount==0 ) {
     						errMsg = 'No data found.';
     						ComShowMessage(msgs["CGM10012"]);
     						return;
     					}
     					formObject.f_cmd.value = IBSEARCH02;
     					ComOpenPopupWithTarget('/hanjin/EES_CGM_1090.do', 775, 800, "", "0,1,1,1,1,1,1", true);
                	 }
                	 else if (formObject.doc_type[1].checked)
                	 {
                		//rdObject.autoadjust=true;
                		//rdObject.ZoomRatio=100;

                		//rdObject.HideToolbar();
                		//rdObject.HideStatusbar();
                		//rdObject.ViewShowMode(0);
                		
                		//rdObject.setbackgroundcolor(255,255,255);
                		//rdObject.SetPageLineColor(255,255,255);
                		rdObject.PrintDialog();
                	 }
                    break;
                    
                case "btns_crnt_loc_cd":	// Location Popup
	                var tmp = formObject.location.text;
	            	if(tmp == "RCC"){
	            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            	} else if(tmp == "LCC") {
	            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            	} else if(tmp == "SCC") {
	            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            	}
                	break;
                	
                case "btns_crnt_yd_cd":		// Yard
                	//ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do', 1000, 450, "3:crnt_yd_cd", "1,0,1,1,1,1,1", true);
                	ComOpenPopup('/hanjin/COM_ENS_061.do', 800, 475, "callBackYard", "0,1,1,1,1,1,1", true, false);
                	break;
                	
                case "btns_vndr":
                	ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackVendor", "0,1,1,1,1,1", true, false);
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
     * @param  {object} sheet_obj	필수
     * @return 없음
     * @author 김창식
     * @version 2009.07.15
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
     * @version 2009.07.15
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
      * Sheet 로딩 후 기본 설정 및 초기화 <br>
      * @param  없음
      * @return 없음
      * @author 조재성
      * @version 2009.08.05
      */     
     function sheet1_OnLoadFinish(sheetObj) {
        sheetObj.WaitImageVisible = false;
  
     	// axon event 등록
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener('change', 'obj_change' , 'crnt_loc_cd');  
     	axon_event.addListener('change', 'obj_change' , 'crnt_yd_cd');  
     	axon_event.addListener('change', 'obj_change', 'vndr_seq'); 
     	axon_event.addListener('click', 'doc_type_change', 'doc_type');
     	axon_event.addListener('keyup', 'enterFire', 'crnt_loc_cd');
     	axon_event.addListener('keyup', 'enterFire', 'crnt_yd_cd');
     	axon_event.addListenerForm('keyup', 'obj_keyup', form);         

     	 
     	// Multi Combo 초기화
     	comboObjects[comboCnt++] = document.location;
     	comboObjects[comboCnt++] = document.aciac_div_cd;
     	comboObjects[comboCnt++] = document.chss_pool_cd;
     	comboObjects[comboCnt++] = document.group1;
     	comboObjects[comboCnt++] = document.group2;
     	comboObjects[comboCnt++] = document.group3;    	
     	comboObjects[comboCnt++] = document.eq_tpsz_cd;
     	comboObjects[comboCnt++] = document.agmt_lstm_cd;
     	comboObjects[comboCnt++] = document.chss_mvmt_sts_cd;
     	
       	for(var k=0;k<comboObjects.length;k++){
   	        initCombo(comboObjects[k]);
  	    }  
       	
       	// Active St. MultiCombo 값 초기화
       	var arrActive = new Array();
       	arrActive[0] = "A|Active";
       	arrActive[1] = "I|In-active";
       	makeComboObject(document.form.aciac_div_cd, arrActive, 1, 0, 0);
       	
       	//Group MultiCombo 값 초기화
       	var arrGroup = new Array();
       	arrGroup[0] = "1|LCC[Location]";
       	arrGroup[1] = "2|Office";
       	arrGroup[2] = "3|SCC[Location]";
       	arrGroup[3] = "4|Yard";
       	arrGroup[4] = "5|Lease term";
       	arrGroup[5] = "6|Lessor";
       	arrGroup[6] = "7|Mvmt Status";
       	makeComboObject(document.form.group1, arrGroup, 1, 0, 1);
   
       	
       	/*
       	// Location MultiCombo 값 설정
     	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
     	
     	// CP MultiCombo 값 설정
     	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
     	
     	// Type Size MultiCombo 값 설정
     	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
     	
     	// Lease Term MultiCombo 값 설정
     	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
     	
     	// Movement Status MultiCombo 값 설정
     	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
     	*/
       	
       	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
     	initControl();
     	 
        sheetObj.WaitImageVisible = true; 
     }
      
    /**
     * print화면 오픈
     * print화면 오픈
     * print할수 있는 화면 오픈
     */
	function rdOpen(){		
		
		var sXml = "";		
		var i=0;
		var j=0;
        var sheetObject = sheetObjects[0];
        
        //RDOBJECT초기화

        rdObjects[0].AutoAdjust = 1; // 0:ZoomRatio에 맞춤, 1:화면사이즈맞춤, 2:가로비율에 맞춤
        //rdObjects[0].ZoomRatio = 90;
        rdObjects[0].HideStatusbar();
        //rdObjects[0].HideToolbar();
        rdObjects[0].ViewShowMode(1);
        rdObjects[0].setbackgroundcolor(255,255,255);
        rdObjects[0].SetPageLineColor(255,255,255);
        
        //fromObj = document.form
        //rdObj = sheetObject
		 
		sXml = "<?xml version='1.0' encoding='UTF-8'?>";
		sXml += "<ETC>";
		sXml += "<SHEET1>";
		sXml += "<DATA>";
		sXml += "<TR>";
		sXml += "<TD>01</TD>";
		sXml += "<TD>50</TD>";
		sXml += "<TD>20</TD>";
		sXml += "</TR>";
     	sXml += "</DATA>";
		sXml += "</SHEET1>";
		sXml += "<SHEET2>";
		sXml += "<DATA>";
		sXml += "<TR>";
		sXml += "<TD>01</TD>";
		sXml += "<TD>50</TD>";
		sXml += "<TD>20</TD>";
		sXml += "</TR>";
		sXml += "</DATA>";
		sXml += "</SHEET2>";
		sXml += "<SHEET3>";
		sXml += "<DATA>";
		
		if(sheetObject.RowCount == 0)
		{
			sXml += "<TR>";
			sXml += "<TD></TD>";
			sXml += "<TD></TD>";
			sXml += "</TR>";
		}
		else
		{
			for(var i = 1; i <= sheetObject.RowCount; i++){
				if(sheetObject.cellValue(i,"group1") == "Sub Total")
				{
				
				}else if(sheetObject.cellValue(i,"group1") == "")
				{
					
				}else{
					sXml += "<TR>";
					var xAx = "<TD>["+sheetObject.cellValue(i, "group1")
						 +"|"+sheetObject.cellValue(i, "group2")
						 +"|"+sheetObject.cellValue(i, "group3")
						 +"]</TD>";
					sXml += xAx;
					sXml += "<TD>"+sheetObject.cellValue(i, "total")+"</TD>";
					sXml += "</TR>";
				}
			}
		}
		
		sXml += "</DATA>";
		sXml += "</SHEET3>";
		sXml += "<SHEET4>";
		sXml += "<DATA>";
		sXml += "<TR>";
		sXml += "<TD></TD>";
		sXml += "<TD></TD>";
		sXml += "<TD></TD>";
		sXml += "<TD></TD>";
		sXml += "<TD></TD>";
		sXml += "<TD></TD>";
		sXml += "<TD></TD>";
		sXml += "</TR>";
		sXml += "</DATA>";
		sXml += "</SHEET4>";
		sXml += "</ETC>";

		rdObjects[0].SetRData(sXml);
		rdObjects[0].FileOpen(RD_path+'apps/alps/ees/cgm/chassismgsetmgt/chassismgsetinventory/report/EES_CGM_1122.mrd',RDServer);
		//rdObjects[0].FileOpen('http://localhost:7001/hanjin/apps/alps/ees/cgm/chassismgsetmgt/chassismgsetinventory/report/EES_CGM_1122.mrd',RDServer);
    }
     
    /**
     * Form의 Conrol 를 초기화 시킨다. <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.16
     */
    function initControl(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 
    	 // Form Object 초기화
    	 with(formObj){
    		 crnt_loc_cd.value  = "USNYC"; // USNYC default 셋팅
    		 crnt_yd_cd.value   = "";
    		 staying_days.value	= "";
    		 vndr_seq.value		= "";
    		 include_np.checked = false;
    	 }
    	 
    	 // MultiCombo 초기화
    	 for(var i=0; i<comboObjects.length; i++){
    		 comboObjects[i].Text2 = "";
    	 }
    	 
    	 // Sheet Object 초기화
    	 sheetObj.RemoveAll();
    	 sheetObj.ColHidden("group1") = true;
    	 sheetObj.ColHidden("group2") = true;
    	 sheetObj.ColHidden("group3") = true;
    	 
    	 // 초기값 설정
    	 comboObjects[0].Index2 = 0;	// change event 를 발생시키지 않기 위해 Index2 를 사용
    	 comboObjects[1].Index2 = 0;
    	 comboObjects[2].Index2 = 0;
    	 
    	 formObj.staying_days.value = "0";
    	 
    	 comboObjects[3].Index = 1;		// change event 를 발생시키기 위해 Index 를 사용
    	 comboObjects[4].Index = 2;		// change event 를 발생시키기 위해 Index 를 사용
    	 comboObjects[5].Index = 2;		// change event 를 발생시키기 위해 Index 를 사용
    	 
    	 //rd object 초기화
    	 rdOpen();
    	 
    	 formObj.crnt_loc_cd.focus(); //초기화시  focus는 location으로 가게 만든다. 
    }


     /**
      * 시트 초기설정값, 헤더 정의 <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
      * @param  {object} sheetObj	필수	 Sheet Object
      * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
      * @return 없음
      * @author 김창식
      * @version 2009.07.16
      */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
    	var sheetID = sheetObj.id;
        switch(sheetID) {

        	case "sheet1":
        		with (sheetObj) {

        			// 높이 설정
                    style.height = 362;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;//msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

                    var HeadTitle = "Seq.||||Total|SF2|SL2|TA2|SF4|GN4|GN5|CB4|EG5|EG8|ZT4";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var totalVal = "|5|+|6|+|7|+|8|+|9|+|10|+|11|+|12|+|13|+|14|";
                    InitDataProperty(0, cnt++ , dtDataSeq,	    30,	daCenter,false,	"Seq");
                    InitDataProperty(0, cnt++ , dtData,	   95, daCenter,true,	"group1", false, "", dfNone,    0, false, true);
                    InitDataProperty(0, cnt++ , dtData,	   90, daCenter,true,	"group2", false, "", dfNone,    0, false, true);
                    InitDataProperty(0, cnt++ , dtData,	   90, daCenter,true,	"group3", false, "", dfNone,    0, false, true);
					InitDataProperty(0, cnt++ , dtAutoSum,  70,	daRight, false,	"total",  false, totalVal, dfInteger, 0, false, true);
                    InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight, false,	"eq_tpsz_cd_sf2", false, "", dfInteger, 0, false, true);
                    InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight, false,	"eq_tpsz_cd_sl2", false, "", dfInteger, 0, false, true);
                    InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight, false,	"eq_tpsz_cd_ta2", false, "", dfInteger, 0, false, true);
                    InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight, false,	"eq_tpsz_cd_sf4", false, "", dfInteger, 0, false, true);
                    InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight, false,	"eq_tpsz_cd_gn4", false, "", dfInteger, 0, false, true);
                    InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight, false,	"eq_tpsz_cd_gn5", false, "", dfInteger, 0, false, true);
                    InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight, false,	"eq_tpsz_cd_cb4", false, "", dfInteger, 0, false, true);
                    InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight, false,	"eq_tpsz_cd_eg5", false, "", dfInteger, 0, false, true);
                    InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight, false,	"eq_tpsz_cd_eg8", false, "", dfInteger,	0, false, true);
                    InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight, false,	"eq_tpsz_cd_zt4", false, "", dfInteger, 0, false, true);
    				
    				CountPosition = 0;
                    
                    EditableColorDiff = false;
				}
                break;

        }
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type
     * @return 없음
     * @author 김창식
     * @version 2009.07.16
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {

	        case IBSEARCH:      //조회
		        // Form Object 값 설정
		    	formObj.f_cmd.value = SEARCH;
		 		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
		 		
		 		if(formObj.include_np.checked){
		 			formObj.include_np.value = "Y";
		 		} else {
		 			formObj.include_np.value = "";
		 		}

		 		sheetObj.WaitImageVisible=false;
		 		ComOpenWait(true);
		 		// 조회실행
		 		var sXml = sheetObj.GetSearchXml("EES_CGM_1089GS.do" , FormQueryString(formObj));
		 		sheetObj.LoadSearchXml(sXml);
		 		ComOpenWait(false);

		        break;
                    
        	case IBSEARCH_ASYNC01:	// Location Combo 조회
		       	formObj.f_cmd.value = SEARCH;
		       	formObj.intg_cd_id.value = COM_CD_TYPE_CD02117;		// 코드Type 설정 (Location)
		   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		   			    			
		   		var sStr = ComGetEtcData(sXml,"comboList");    			
		   		var arrStr = sStr.split("@");
		   			
		   		// combo control, 결과 문자열, Text Index, Code Index
		  		makeComboObject(formObj.location, arrStr, 1, 1, 0);
		       	break;
		    
        	case IBSEARCH_ASYNC02:	// Yard 에 대한 Validation 체크 
			   	formObj.f_cmd.value = COMMAND01;
			   	formObj.yd_cd.value = formObj.crnt_yd_cd.value;
			   	var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
			   	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		formObj.crnt_yd_cd.value = "";
			   		formObj.crnt_yd_cd.focus();
			   	}
			   	break;
			   	
        	case IBSEARCH_ASYNC03:	// CP Combo 조회
           		
        		formObj.f_cmd.value = SEARCH02;
        		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
        		ss = ComCgmXml2ComboString(sXml, "TOTAL");
        		var cols = ComCgmXml2ComboString(sXml, "code1", "desc1");
        		//IBSHEET GRID 밖에 있는 콤보
        		makeCPMultiCombo(formObj.chss_pool_cd, cols, 0, 0);
         	  	break;   
         	  	
        	case IBSEARCH_ASYNC04:	// Type Size Combo 조회
        		formObj.f_cmd.value = SEARCH04;
        		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
				var sStr = ComGetEtcData(sXml,"comboList");
				var arrStr = sStr.split("@");
				
		  		makeComboObject(formObj.eq_tpsz_cd, arrStr, 0, 0, 0);
		  		//comboObjects[6].DeleteItem(1);
		       	break;  
		       	
        	case IBSEARCH_ASYNC05:	// Term Code Combo 조회
		       	formObj.f_cmd.value = SEARCH;
		       	formObj.intg_cd_id.value = COM_CD_TYPE_CD01948;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
		   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		   			    			
		   		var sStr = ComGetEtcData(sXml,"comboList");    			
		   		var arrStr = sStr.split("@");

		  		makeComboObject(formObj.agmt_lstm_cd, arrStr, 0, 0, 0);
		  		comboObjects[7].DeleteItem(0);
		       	break;
		       	
        	case IBSEARCH_ASYNC06:	// Movement Status Combo 조회
	        	formObj.f_cmd.value = SEARCH13;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
				    			
				var cols = ComCgmXml2ComboString(sXml, "code1", "code1");
	     	  	ComCgmMakeMultiCombo(form.chss_mvmt_sts_cd, cols[0], cols[1], 0);
	     	  	break;
	     	  	
	  	    case IBSEARCH_ASYNC08:
		       	//formObj.f_cmd.value = SEARCH;
		       	//formObj.loc_cd.value = formObj.crnt_loc_cd.value;		//   ( location)
		   		//var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
		    	formObj.f_cmd.value = SEARCH17;
		    	var location = formObj.location.text;
		    	
		    	if(location == "RCC")
		    	{
		    		formObj.eq_orz_cht_chktype.value = "RCC";
		    		formObj.eq_orz_cht_rcc_cd.value = formObj.crnt_loc_cd.value;
		    	}else if(location == "LCC")
		    	{
		    		formObj.eq_orz_cht_chktype.value = "LCC";
		    		formObj.eq_orz_cht_lcc_cd.value = formObj.crnt_loc_cd.value;
		    	}else if(location == "SCC")
		    	{
		    		formObj.eq_orz_cht_chktype.value = "SCC";
		    		formObj.eq_orz_cht_scc_cd.value = formObj.crnt_loc_cd.value;
		    	}else
		    	{
		    		formObj.eq_orz_cht_chktype.value = "";
		    		formObj.eq_orz_cht_scc_cd.value = "";
		    	}
	     		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		   		// 데이터 건수
		        var dataCount = ComGetTotalRows(sXml);
		        if(dataCount==0){
		        	ComShowCodeMessage('CGM10009','location cd');
			   		formObj.crnt_loc_cd.value = "";
		        }
		        formObj.crnt_loc_cd.focus(); //validation후 focus는 location으로 가게 만든다. 
		  	    break;		     	  	
    		
        	case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.SpeedDown2Excel(-1);
				break;
				
        	case IBRESET:
        		var idx = 0
        		var sXml2 = document.form2.sXml.value;
        		var arrXml = sXml2.split("|$$|");

        		//Location
        		if ( arrXml[idx] == null ) {return;}
        		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
        	    var arrStr1 = new Array();
        		for ( var i = 0; i < vArrayListData.length; i++) {
        		    vListData = vArrayListData[i];
        		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
        		}
        		// combo control, 결과 문자열, Text Index, Code Index
		  		makeComboObject(formObj.location, arrStr1, 1, 1, 0);       
        		idx++;        		

		  		//Co-Op Pool
        		if ( arrXml[idx] == null ) {return;}
        		var cols1 = ComCgmXml2ComboString(arrXml[idx], "code1", "desc1");
        		//IBSHEET GRID 밖에 있는 콤보
        		makeCPMultiCombo(formObj.chss_pool_cd, cols1, 0, 0);
        		idx++;
        		
        		//Type/Size
        		if ( arrXml[idx] == null ) {return;}
        		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
        	    var arrStr2 = new Array();
        		for ( var i = 0; i < vArrayListData.length; i++) {
        		    vListData = vArrayListData[i];
        		    arrStr2[i] = vListData["code1"] + "|" + vListData["desc1"];
        		}
        		makeComboObject(formObj.eq_tpsz_cd, arrStr2, 0, 0, 0);
		  		idx++;
		  		
        		//Lease Term
        		if ( arrXml[idx] == null ) {return;}
        		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
        	    var arrStr3 = new Array();
        		for ( var i = 0; i < vArrayListData.length; i++) {
        		    vListData = vArrayListData[i];
        		    arrStr3[i] = vListData["code1"] + "|" + vListData["desc1"];
        		}
		  		makeComboObject(formObj.agmt_lstm_cd, arrStr3, 0, 0, 0);
		  		comboObjects[7].DeleteItem(0); // <= chungpa 20091229 확인 요망.
		  		idx++;
		  		
		  		//MVMT Status
        		if ( arrXml[idx] == null ) {return;}
				var cols2 = ComCgmXml2ComboString(arrXml[idx], "code1", "code1");
	     	  	ComCgmMakeMultiCombo(form.chss_mvmt_sts_cd, cols2[0], cols2[1], 0);
	     	  	idx++;
	     	  	
        		break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
     * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
     * @author 김창식
     * @version 2009.07.16
     */ 
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		switch(sAction){
    			case IBSEARCH:
    				if(crnt_loc_cd.value == ''){
    					ComShowCodeMessage('CGM10004','Location');
    					crnt_loc_cd.focus();
    					return false;
    				} else {
    					if(crnt_loc_cd.value.length != 5) // Location 자리수 고정 size=5
    					{
    						ComShowCodeMessage('CGM10044','Location(5)');
    						crnt_loc_cd.focus();
    						return false;
    					}else
    					{
    						return true;
    					}
    				}
    				
    				break;
    		}
    	}
    }
     
    /**
     * 콜백 함수. <br>
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				필수 선택한 Row
     * @param  {Int} col				필수 선택한 Column
     * @param  {Int} sheetIdx			필수 Sheet Index
     * @return 없음
     * @author 김창식
     * @version 2009.07.16
     */   
    function callBackLocation(aryPopupData, row, col, sheetIdx){
         	 
        var formObj = document.form;
        var location = formObj.location.text;
        var crntLocCd = "";
        var i = 0;
        
        for(i = 0; i < aryPopupData.length; i++){
        	if(location == 'RCC'){
        		crntLocCd = crntLocCd + aryPopupData[i][11];
        	} else if(location == 'LCC'){
        		crntLocCd = crntLocCd + aryPopupData[i][10];
        	} else if(location == 'SCC'){
        		crntLocCd = crntLocCd + aryPopupData[i][8];
        	}
         		
        	if(i < aryPopupData.length - 1){
        		crntLocCd = crntLocCd + ",";
         	}
        }
         	 
        formObj.crnt_loc_cd.value = crntLocCd;
         	 
    }	 
    
    /**
     * 콜백 함수. <br>
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				필수 선택한 Row
     * @param  {Int} col				필수 선택한 Column
     * @param  {Int} sheetIdx			필수 Sheet Index
     * @return 없음
     * @author 김창식
     * @version 2009.07.16
     */   
    function callBackYard(aryPopupData, row, col, sheetIdx){
         	 
        var formObj = document.form;
        var crntYdCd = "";
        var i = 0;
        
        for(i = 0; i < aryPopupData.length; i++){
        	
        	crntYdCd = crntYdCd + aryPopupData[i][3];
        	
        	if(i < aryPopupData.length - 1){
        		crntYdCd = crntYdCd + ",";
         	}
        }
         	 
        formObj.crnt_yd_cd.value = crntYdCd;
        
        //chungpa 20091015 check yard
        checkGroup2Yard();
    }
    	
    /**
     * 콜백 함수. <br>
     * 공통팝업 ServiceProvider에서 선택한 Lessor Seq를 Form Object 인 vndr_seq에 설정한다.
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				필수 선택한 Row
     * @param  {Int} col				필수 선택한 Column
     * @param  {Int} sheetIdx			필수 Sheet Index
     * @return 없음
     * @author 김창식
     * @version 2009.07.16
     */   
    function callBackVendor(aryPopupData, row, col, sheetIdx){
        	 
       	var formObj = document.form;
        var vndrSeq = "";
        var i = 0;
        	 
        for(i = 0; i < aryPopupData.length; i++){
        	vndrSeq = vndrSeq + aryPopupData[i][2];
        		
        	if(i < aryPopupData.length - 1){
        		vndrSeq = vndrSeq + ",";
        	}
        }
        	 
        formObj.vndr_seq.value = vndrSeq;
        	 
    }	
     
     /**
      * 콜백 함수. <br>
      * Total display 
      * @param  {Object} sheetObj		필수	 SheetObj
      * @param  {Int} row				필수 선택한 Row
      * @return 없음
      * @author 조재성
      * @version 2009.10.01
      */ 
     function sheet1_OnChangeSum(sheetObj, Row)
     {
     	with(sheetObj)
     	{
     		SumText(0, "Seq") = "";
     		SumText(0, "group1") = "Grand Total";
     		
     		CellAlign(Row, "group1") = daCenter;
     	}
     }
     
    /**
     * Sheet1 의 OnSearchEnd 이벤트처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {string} ErrMsg		필수 String
     * @return 없음
     * @version 2009.07.16
     */ 
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
    	with(sheetObj)
    	{
    		if(comboObjects[3].Text != ''){
    			ShowSubSum("group1", "4|5|6|7|8|9|10|11|12|13|14",-1, false, false, -1,"Seq=;group1=Sub Total");
    		}
    	}
    }

  /**
   * Sheet1 의 OnMouseDown 이벤트처리 <br>
   * @param  {Integer} Button	필수 Integer
   * @param  {integer} Shift	필수 Integer
   * @param  {Integer} X	필수 Integer
   * @param  {integer} Y	필수 Integer
   * @return 없음
   * @author 조재성
   * @version 2009.09.23
   */ 
   function sheet1_OnMouseDown (Button, Shift, X, Y){
  	 var sheetObj = sheetObjects[0];
  	 var formObj = document.form;
  	 if(sheetObj.rowcount + 1 == sheetObj.mouseRow)
  	 {
  		 //alert("ROWCNT:"+ sheetObj.rowcount+"=>"+ sheetObj.MouseRow +":"+sheetObj.MouseCol)	 
  		 //var groupValue1 = sheetObj.cellValue(sheetObj.MouseRow, "group1");
  		 //alert(groupValue1);
  		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow, sheetObj.MouseCol, 0, 0, 0, 0);
  	 }
  	 
   }     
    /**
     * Sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
     * @author 김창식
     * @version 2009.07.16
     */      
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
    	
    	var eqKndCd			= EQ_KND_CD_CHASSIS;
    	var location		= comboObjects[0].Code;
    	var crntLocCd		= document.form.crnt_loc_cd.value;
    	var crntYdCd		= document.form.crnt_yd_cd.value;
    	var aciacDivCd		= comboObjects[1].Code;
    	var chssPoolCd		= comboObjects[2].Code;
    	var includeNp		= "";
    	if(document.form.include_np.checked){
    		includeNp = "Y";
    	}
    	var stayingDays		= document.form.staying_days.value;
    	var group1 = comboObjects[3].Code;
    	var group2 = comboObjects[4].Code;
    	var group3 = comboObjects[5].Code;
    	var groupValue1 = sheetObj.cellValue(Row, "group1");
    	var groupValue2 = sheetObj.cellValue(Row, "group2");
    	var groupValue3 = sheetObj.cellValue(Row, "group3");

	  	var s2_group1 = "";
	  	var s2_group1_val = "";
	  	var s2_group2 = "";
	  	var s2_group2_val = "";
	  	var s2_group3 = "";
	  	var s2_group3_val = "";
	  	var s3_gtotal = "";
	  	if(groupValue1.substring(0,9) == "Sub Total")
	  	{
		  	s2_group1 = group1;
		  	s2_group1_val = sheetObj.cellValue(Row-1, "group1");
		  	s2_group2 = group2;
		  	s2_group2_val = sheetObj.cellValue(Row-1, "group2");
		  	
		  	//alert("chungpa s2_group1_val:"+s2_group2_val + "   s2_group2:" + s2_group2);
		  	//alert("chungpa Row:"+ Row);
		  	if(Row>=3) //Sub Total이 Group2에서 두개이상 데이터가 있을 경우 
		  	{
		  		for(var i=Row-1; i>=0; i--) // 위로 올라가면서 싹 뒤져서 다음 SubTotal이 안나올때까지
		  		{
		  			if(sheetObj.cellValue(i,"group1")== "Sub Total")
		  			{
		  				break; // 다음 sub total에 도달하면 더이상 체크할 필요가 없슴.
		  			}
		  			
		  			//최초 걸린놈 데이터와 다른놈이 있다면, 그룹바이 조건에서 없애버린다. 
		  			if(s2_group2_val != sheetObj.cellValue(i,"group2"))
		  			{
		  				s2_group2 = "";
		  				break;
		  			}
		  		}
		  		
		  	}
		  	s2_group3 = group3;
		  	s2_group3_val = sheetObj.cellValue(Row-1, "group3");
		  	if(Row>=3) //Sub Total이 Group3에서 두개이상 데이터가 있을 경우 
		  	{
		  		for(var i=Row-1; i>=0; i--) // 위로 올라가면서 싹 뒤져서
		  		{
		  			if(sheetObj.cellValue(i,"group1")== "Sub Total")
		  			{
		  				break; // 다음 sub total에 도달하면 더이상 체크할 필요가 없슴.
		  			}
		  			//최초 걸린놈 데이터와 다른놈이 있다면, 그룹바이 조건에서 없애버린다. 
		  			if(s2_group3_val != sheetObj.cellValue(i,"group3"))
		  			{
		  				s2_group3 = "";
		  				break;
		  			}
		  		}
		  		
		  	}
		  	//alert("chungpa SG1>>"+s2_group1+": SG2>>"+s2_group2+ ": SG3>>"+ s2_group3);
		  	//return;
		  	s3_gtotal = "";
		  	
		  	groupValue1 = "SubSum"; 
	  	}else if(groupValue1 == "Grand Total"){
	  		s3_gtotal = "GTOTAL";
	  	}else{
	  		s2_group1 = "";
	  		s2_group1_val = "";
	  		s2_group2 = "";
	  		s2_group2_val = "";
	  		s2_group3 = "";
	  		s2_group3_val = "";
	  	}

    	var agmtLstmCd = comboObjects[7].Text;
    	var vndrSeq = document.form.vndr_seq.value;
    	var chssMvmtStsCd = comboObjects[8].Text;
    
    	var eqTpszCd = document.eq_tpsz_cd.Text;
    	var s2EqTpszCd = "";
    	
    	var colSaveName = sheetObj.ColSaveName(Col);
    	
    	if(colSaveName == 'eq_tpsz_cd_sf2') 		s2EqTpszCd = "SF2";
    	else if(colSaveName == 'eq_tpsz_cd_sl2')	s2EqTpszCd = "SL2";
    	else if(colSaveName == 'eq_tpsz_cd_ta2')	s2EqTpszCd = "TA2";
    	else if(colSaveName == 'eq_tpsz_cd_sf4')	s2EqTpszCd = "SF4";
    	else if(colSaveName == 'eq_tpsz_cd_gn4')	s2EqTpszCd = "GN4";
    	else if(colSaveName == 'eq_tpsz_cd_cb4')	s2EqTpszCd = "CB4";
    	else if(colSaveName == 'eq_tpsz_cd_eg5')	s2EqTpszCd = "EG5";
    	else if(colSaveName == 'eq_tpsz_cd_eg8')	s2EqTpszCd = "EG8";
    	else if(colSaveName == 'eq_tpsz_cd_gn5')	s2EqTpszCd = "GN5";
    	else if(colSaveName == 'eq_tpsz_cd_zt4')	s2EqTpszCd = "ZT4";
    	
    	var param = "?program_id=1089";
    	param = param + "&eq_knd_cd=" + eqKndCd;
    	param = param + "&location=" + location;
    	param = param + "&crnt_loc_cd=" + crntLocCd;
    	param = param + "&crnt_yd_cd=" + crntYdCd;
    	param = param + "&aciac_div_cd=" + aciacDivCd;
    	param = param + "&chss_pool_cd=" + chssPoolCd;
    	param = param + "&include_np=" + includeNp;
    	param = param + "&staying_days=" + stayingDays;
    	param = param + "&eq_tpsz_cd=" + eqTpszCd;
    	param = param + "&s2_eq_tpsz_cd=" + s2EqTpszCd;
    	param = param + "&group1=" + group1;
    	param = param + "&group2=" + group2;
    	param = param + "&group3=" + group3;
    	param = param + "&group_value1=" + groupValue1;
    	param = param + "&group_value2=" + groupValue2;
    	param = param + "&group_value3=" + groupValue3;
    	param = param + "&agmt_lstm_cd=" + agmtLstmCd;
    	param = param + "&vndr_seq=" + vndrSeq;
    	param = param + "&chss_mvmt_sts_cd=" + chssMvmtStsCd;
	  	param = param + "&s2_group1=" + s2_group1;
	  	param = param + "&s2_group1_val=" + s2_group1_val;
	  	param = param + "&s2_group2=" + s2_group2;
	  	param = param + "&s2_group2_val=" + s2_group2_val;
	  	param = param + "&s2_group3=" + s2_group3;
	  	param = param + "&s2_group3_val=" + s2_group3_val;
	  	param = param + "&s3_gtotal=" + s3_gtotal;

    	//var seq = sheetObj.cellValue(Row, "Seq");
    	if(Col > 3)// && seq != '')
        {
	    	ComOpenPopup('/hanjin/EES_CGM_1091.do' + param, 900, 570, "", "1,0", true, false);
        }else
        {
            ComShowCodeMessage('CGM10016');
        }
	   
    }
    
    /**
     * Location Multi-Combo 의 OnChange 이벤트처리 <br>
     * @param  {object} ComboObj	필수	 Sheet Object
     * @param  {int} 	Index_Code	필수
     * @param  {string} Text		필수
     * @return 없음
     * @version 2009.07.16
     */ 
    function location_OnChange(ComboObj, Index_Code, Text){
    	var formObj = document.form; 
    	formObj.crnt_loc_cd.value = "";
    	
    	// chungpa 20091014 Location 에서 SCC 로 선택되거나, Yard 를 입력후 조회시 1.Group by 는 'SCC' 로,   2.Group by 는 'Yard' 로 자동변환토록 수정.
    	if(formObj.location.Text == "SCC")
    	{
    		comboObjects[3].Index = 3;		// change event 를 발생시키기 위해 Index 를 사용
    		comboObjects[4].Index = 1;		// yard도  선택함.
    		
    	}else
    	{
    		comboObjects[3].Index = 1;		// change event 를 발생시키기 위해 Index 를 사용
    		comboObjects[4].Index = 2;		// change event 를 발생시키기 위해 Index 를 사용
    		comboObjects[5].Index = 2;		// change event 를 발생시키기 위해 Index 를 사용
    	}
   	}
    
    /**
     * Group1 Multi-Combo 의 OnChange 이벤트처리 <br>
     * @param  {object} ComboObj	필수	 Sheet Object
     * @param  {int} 	Index_Code	필수
     * @param  {string} Text		필수
     * @return 없음
     * @version 2009.07.16
     */ 
    function group1_OnChange(comboObj, Index_Code, Text){
    	//Group MultiCombo 값 초기화
      	var arrGroup = new Array();
    	var sheetObj = sheetObjects[0];
      	
      	if(comboObj.Code == 1){
      		arrGroup[0] = "2|Office";
          	arrGroup[1] = "3|SCC[Location]";
          	arrGroup[2] = "4|Yard";
          	arrGroup[3] = "5|Lease term";
          	arrGroup[4] = "6|Lessor";
          	arrGroup[5] = "7|Mvmt Status";
      	} else if(comboObj.Code == 2){
          	arrGroup[0] = "3|SCC[Location]";
          	arrGroup[1] = "4|Yard";
          	arrGroup[2] = "5|Lease term";
          	arrGroup[3] = "6|Lessor";
          	arrGroup[4] = "7|Mvmt Status";
      	} else if(comboObj.Code == 3){
          	arrGroup[0] = "4|Yard";
          	arrGroup[1] = "5|Lease term";
          	arrGroup[2] = "6|Lessor";
          	arrGroup[3] = "7|Mvmt Status";
      	} else if(comboObj.Code == 4){
          	arrGroup[0] = "5|Lease term";
          	arrGroup[1] = "6|Lessor";
          	arrGroup[2] = "7|Mvmt Status";
      	}

      	// Group2 MultiCombo 값 초기화
      	makeComboObject(document.form.group2, arrGroup, 1, 0, 1);
      	
      	// Group3 MultiCombo Clear
      	comboObjects[5].RemoveAll();
      	
      	// Sheet Object 타이틀 값 설정
      	sheetObj.RemoveAll();
      	sheetObj.cellValue2(0,"group1") = comboObj.Text;
      	sheetObj.cellValue2(0,"group2") = "";
      	sheetObj.cellValue2(0,"group3") = "";
      	
      	// Sheet Object Group 컬럼 숨기기
      	if(sheetObj.cellValue(0,"group1") == ""){
      		sheetObj.ColHidden("group1") = true;
      	} else {
      		sheetObj.ColHidden("group1") = false;
      	}
      	sheetObj.ColHidden("group2") = true;
  		sheetObj.ColHidden("group3") = true;
  		
  		
	    // chungpa 20091014 Location 에서 SCC 로 선택되거나, Yard 를 입력후 조회시 1.Group by 는 'SCC' 로,   2.Group by 는 'Yard' 로 자동변환토록 수정.
  		checkGroup2Yard();
    }
    
    /**
     * Group2 Multi-Combo 의 OnChange 이벤트처리 <br>
     * @param  {object} ComboObj	필수	 Sheet Object
     * @param  {int} 	Index_Code	필수
     * @param  {string} Text		필수
     * @return 없음
     * @version 2009.07.16
     */ 
    function group2_OnChange(comboObj, Index_Code, Text){
    	
    	var sheetObj = sheetObjects[0];
    	var group1Value = comboObjects[3].Code;
    	var arrGroup = new Array();
    	
    	if(group1Value == 1){
    		if(comboObj.Code == 2){
    			arrGroup[0] = "3|SCC[Location]";
              	arrGroup[1] = "4|Yard";
              	arrGroup[2] = "5|Lease term";
              	arrGroup[3] = "6|Lessor";
              	arrGroup[4] = "7|Mvmt Status";
    		} else if(comboObj.Code == 3){
    			arrGroup[0] = "4|Yard";
              	arrGroup[1] = "5|Lease term";
              	arrGroup[2] = "6|Lessor";
              	arrGroup[3] = "7|Mvmt Status";
    		} else if(comboObj.Code == 4){
              	arrGroup[0] = "5|Lease term";
              	arrGroup[1] = "6|Lessor";
              	arrGroup[2] = "7|Mvmt Status";
    		}
    	} else if(group1Value == 2){
    		if(comboObj.Code == 3){
    			arrGroup[0] = "4|Yard";
    			arrGroup[1] = "5|Lease term";
    			arrGroup[2] = "6|Lessor";
    			arrGroup[3] = "7|Mvmt Status";
    		} else if(comboObj.Code == 4){
    			arrGroup[0] = "5|Lease term";
    			arrGroup[1] = "6|Lessor";
    			arrGroup[2] = "7|Mvmt Status";
    		}
    	} else if(group1Value == 3){
    		if(comboObj.Code == 4){
    			arrGroup[0] = "5|Lease term";
    			arrGroup[1] = "6|Lessor";
    			arrGroup[2] = "7|Mvmt Status";
    		}
    	}
    	
    	makeComboObject(document.form.group3, arrGroup, 1, 0, 1);
    	
    	// Sheet Object 타이틀 값 설정
      	sheetObj.RemoveAll();
      	sheetObj.cellValue2(0,"group2") = comboObj.Text;
      	sheetObj.cellValue2(0,"group3") = "";
      	sheetObj.ColHidden("group2") = false;
      	
      	// Sheet Object Group 컬럼 숨기기
      	if(sheetObj.cellValue(0,"group2") == ""){
      		sheetObj.ColHidden("group2") = true;
      	} else {
      		sheetObj.ColHidden("group2") = false;
      	}
  		sheetObj.ColHidden("group3") = true;
    }
    
    /**
     * Group3 Multi-Combo 의 OnChange 이벤트처리 <br>
     * @param  {object} ComboObj	필수	 Sheet Object
     * @param  {int} 	Index_Code	필수
     * @param  {string} Text		필수
     * @return 없음
     * @version 2009.07.16
     */ 
    function group3_OnChange(comboObj, Index_Code, Text){
    	
    	var sheetObj = sheetObjects[0];
    	// Sheet Object 타이틀 값 설정
      	sheetObj.RemoveAll();
      	sheetObj.cellValue2(0,"group3") = comboObj.Text;
      	sheetObj.ColHidden("group3") = false;
      	
      	// Sheet Object Group 컬럼 숨기기
      	if(sheetObj.cellValue(0,"group3") == ""){
      		sheetObj.ColHidden("group3") = true;
      	} else {
      		sheetObj.ColHidden("group3") = false;
      	}
    }
     
    /** 
     * Object 의 activate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.17
     */
    function obj_activate(){
      	ComClearSeparator(event.srcElement);
    } 
    
    /** 
     * Object 의 deactivate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.17
     */
    function obj_deactivate(){
    	 
    	//ComChkObjValid(event.srcElement);
    }
     
    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.17
     */ 
    function obj_keypress(){
      	obj = event.srcElement;
      	if(obj.dataformat == null) return;
      	 	
      	window.defaultStatus = obj.dataformat;
      	 
      	switch(obj.dataformat) {
      	 	case "ym": case "ymd":
      	 		ComKeyOnlyNumber(obj);
      	 		break;
      	 	case "int":
      	 		if(obj.name=="vndr_seq") ComKeyOnlyNumber(obj,",");
      	 		else ComKeyOnlyNumber(obj);
      	        break;
      	 	case "float":
 	            ComKeyOnlyNumber(obj, "-.");
 	            break;    
      	    case "eng":
      	    	if(obj.name=="vndr_seq") ComKeyOnlyNumber(obj,",");
      	    	else ComKeyOnlyAlphabet(); 
      	        break;
      	    case "engup":
      	        if(obj.name=="crnt_loc_cd") ComKeyOnlyAlphabet('uppernum',"44");
      	        else if(obj.name=="crnt_yd_cd") ComKeyOnlyAlphabet('uppernum',"44");
      	        else ComKeyOnlyAlphabet('upper');
      	        break;
      	    case "engdn":
      	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
      	        else ComKeyOnlyAlphabet('lower');
      	        break;
      	}
    } 
    
    /** 
     * Object 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.16
     */  
    function obj_change(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0]; 
    	 obj = event.srcElement;
    	 switch(obj.name){
    	   
    	   	case "vndr_seq":
    	   		var vndrSeq = ComTrimAll(formObj.vndr_seq.value);
    	   		var arrVndrSeq = vndrSeq.split(",");
    	   		
    	   		for(var i = 0; i < arrVndrSeq.length; i++){
    	   		// 입력오류 체크 (예> ,,)
    	 			if(arrVndrSeq[i] == ''){
    	 				ComShowCodeMessage('CGM10009','Lessor');
    	 				formObj.vndr_seq.value = "";
    	 				ComSetFocus(formObj.vndr_seq);
    	 				break;
    	 			}
    	   		}
    	   		break;    	   	
    	 }   
    }
    
    /** 
     * Combo Object 초기화  <br>
     * @param  {object} comboObj	필수 Combo Object
     * @return 없음
     * @author 김창식
     * @version 2009.07.16
     */ 
    function initCombo(comboObj) {
    	switch(comboObj.id) {
	    	case "location":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code = "";
	  	            Text = "";
	  	            DropHeight = 100;
	  	            MultiSelect = false;
	  	            MaxSelect = 1;	    
	  	            UseCode = true;
	  	            Enable = true;
	  	            comboObj.UseAutoComplete = true;
	  	        }
	  	        
	  	        break;
	  	        
	    	case "aciac_div_cd":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code = "";
	  	            Text = "";
	  	            DropHeight = 100;
	  	            MultiSelect = false;
	  	            MaxSelect = 1;	    
	  	            UseCode = true;
	  	            Enable = true;
	  	            comboObj.UseAutoComplete = true;
	  	        }
	  	        
	  	        break;
	  	        
	    	case "chss_pool_cd":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code = "";
	  	            Text = "";
	  	            DropHeight = 100;
	  	            MultiSelect = false;
	  	            MaxSelect = 1;	    
	  	            UseCode = true;
	  	            Enable = true;
	  	            comboObj.UseAutoComplete = true;
	  	        }
	  	        
	  	        break;
	  	        
	    	case "group1":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code = "";
	  	            Text = "";
	  	            DropHeight = 170;
	  	            MultiSelect = false;
	  	            MaxSelect = 1;	    
	  	            UseCode = true;
	  	            Enable = true;
	  	            comboObj.UseAutoComplete = true;
	  	        }
	  	        
	  	        break;    
	  	        
	    	case "group2":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code = "";
	  	            Text = "";
	  	            DropHeight = 150;
	  	            MultiSelect = false;
	  	            MaxSelect = 1;	    
	  	            UseCode = true;
	  	            Enable = true;
	  	            comboObj.UseAutoComplete = true;
	  	        }
	  	        
	  	        break;
	  	        
	    	case "group3":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code = "";
	  	            Text = "";
	  	            DropHeight = 150;
	  	            MultiSelect = false;
	  	            MaxSelect = 1;	    
	  	            UseCode = true;
	  	            Enable = true;
	  	            comboObj.UseAutoComplete = true;
	  	        }
	  	        
	  	        break;
	  	        
	    	case "eq_tpsz_cd":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code = "";
	  	            Text = "";
	  	            DropHeight = 150;
	  	            MultiSelect = true;
	  	            MaxSelect = 100;	    
	  	            UseCode = true;
	  	            Enable = true;
  	            
	        	ValidChar(2,3);         // 영어 대문자, 숫자포함+특수(',')
	            IMEMode = 0;            // 영문
	            MaxLength = 20;         // 100자까지 입력
	  	        }
	  	        
	  	        break;
	  	        
	    	case "agmt_lstm_cd":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code = "";
	  	            Text = "";
	  	            DropHeight = 180;
	  	            MultiSelect = true;
	  	            MaxSelect = 100;	    
	  	            UseCode = true;
	  	            Enable = true;
  	            
	        	ValidChar(2,3);         // 영어 대문자, 숫자포함+특수(',')
	            IMEMode = 0;            // 영문
	            MaxLength = 20;         // 100자까지 입력
	  	        }
	  	        
	  	        break;
	  	        
	    	case "chss_mvmt_sts_cd":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code = "";
	  	            Text = "";
	  	            DropHeight = 150;
	  	            MultiSelect = true;
	  	            MaxSelect = 100;	    
	  	            UseCode = true;
	  	            Enable = true;
  	            
	        	ValidChar(2,3);         // 영어 대문자, 숫자포함+특수(',')
	            IMEMode = 0;            // 영문
	            MaxLength = 20;         // 100자까지 입력
	  	        }
	  	        
	  	        break;
	  	    
	  	      
    	}
    }  
    
    /** 
     * Combo Object 에 값을 추가하는 처리 <br>
     * @param  {object} cmbObj	필수 Combo Object
     * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
     * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
     * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
     * @param  {int} 	opt		필수 공백문자 추가여부 (0:추가안함, 1:추가)
     * @return 없음
     * @author 김창식
     * @version 2009.07.16
     */ 
    function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
    	cmbObj.RemoveAll();
    	
    	if(opt == 0) {
    		for (var i = 0; i < arrStr.length;i++ ) {
    			var arrCode = arrStr[i].split("|");
        		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
            }
    	} else if(opt == 1){
    		cmbObj.InsertItem(0,"","");
    		for (var i = 0; i < arrStr.length;i++ ) {
    			var arrCode = arrStr[i].split("|");
        		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
            }
    	}
    	
    	cmbObj.Index2 = "" ;
    }   
    
    /** 
     * CP Combo Object 에 값을 추가하는 처리 <br>
     * @param  {object} cmbObj	필수 Combo Object
     * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
     * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
     * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
     * @return 없음
     * @author 김창식
     * @version 2009.07.16
     */ 
    function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
       	cmbObj.RemoveAll();
    
       	// LOOP를 돌리기 위해 데이타 갯수를 구함 
       	if(arrStr == undefined ){
       		cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
   			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
   			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
       	} else {
           	var arrCode = arrStr[0].split("|");
         	var arrCode2 = arrStr[1].split("|");
	          	
	          	for (var i = 0; i < arrCode.length;i++ ) {
	          		var arrCode3 = arrCode[i].split("|");
	          		var arrCode4 = arrCode2[i].split("|");
	          		if(i==0)
	          		{
	          			cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
	          			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
	          			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
	          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
	          		}
	          		else
	          		{
	          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
	          		}
	          		
	          	}
       	}

       	cmbObj.Index2 = "" ;
       } 

     /** 
      * 그래픽속성선택 <br>
      * @param  없음
      * @return 없음
      * @author 조재성
      * @version 2009.08.07
      */ 
    function doc_type_change() {
    	var formObj = document.form;
    	
    	document.getElementById('chartLayer').style.display = "none";
    	document.getElementById('sheetLayer').style.display = "none";
    	
    	//챠트
    	if(formObj.doc_type[0].checked==true)
    	{
    		//document.getElementById('chartLayer').style.visibility = 'hidden';
    		//document.getElementById('sheetLayer').style.visibility = 'visible';
    		document.getElementById('sheetLayer').style.display = "";
    	}else //그래프
    	{
    		//document.getElementById('sheetLayer').style.visibility = 'hidden';
    		//document.getElementById('chartLayer').style.visibility = 'visible';
    		document.getElementById('chartLayer').style.display = "";
    	}
    	 
    	   
    }

  /** 
   * 기본조건 입력 후 ENTER키 적용 <br>
   * @param  없음
   * @return 없음
   * @author 조재성
   * @version 2009.10.01
   */ 
   function enterFire() {
	   var formObj = document.form;
	   var sheetObj = sheetObjects[0];
	   if(event.keyCode == 13)
	   {
		   if(validateForm(sheetObj,formObj,IBSEARCH))
		   {
			   ComKeyEnter('search');
		   }
	   }
	 	 
   }        

/**
 * Yard입력시, group2를 Yard로 바꿔줌
 * // chungpa 20091014 Location 에서 SCC 로 선택되거나, Yard 를 입력후 조회시 1.Group by 는 'SCC' 로,   2.Group by 는 'Yard' 로 자동변환토록 수정.
 * @author 조재성 2009.10.14
 */   
function checkGroup2Yard(){
	var formObj = document.form;
	var crntYdCd = ComTrimAll(formObj.crnt_yd_cd.value);
	var arrCrntYdCd = crntYdCd.split(",");
	
	if(
			(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value.length == 7) 	//데이터가 한개만 있거나
		||  (formObj.crnt_yd_cd.value.search(',') > 0)							//,로 여러개로 나뉘어 있으면
	){
		if(document.group1.Code == 1){
	  		comboObjects[4].Index = 3; // 빈칸고려
	  		//arrGroup[0] = "2|Office";
	      	//arrGroup[1] = "3|SCC[Location]";
	      	//arrGroup[2] = "4|Yard";
	      	//arrGroup[3] = "5|Lease term";
	      	//arrGroup[4] = "6|Lessor";
	      	//arrGroup[5] = "7|Mvmt Status";
	 	} else if(document.group1.Code == 2){
	  		comboObjects[4].Index = 2;
	      	//arrGroup[0] = "3|SCC[Location]";
	      	//arrGroup[1] = "4|Yard";
	      	//arrGroup[2] = "5|Lease term";
	      	//arrGroup[3] = "6|Lessor";
	      	//arrGroup[4] = "7|Mvmt Status";
	  	} else if(document.group1.Code == 3){
	  		comboObjects[4].Index = 1;
	  	  	//arrGroup[0] = "4|Yard";
	      	//arrGroup[1] = "5|Lease term";
	      	//arrGroup[2] = "6|Lessor";
	      	//arrGroup[3] = "7|Mvmt Status";
	  	} else if(document.group1.Code == 4){
	      	//arrGroup[0] = "5|Lease term";
	      	//arrGroup[1] = "6|Lessor";
	      	//arrGroup[2] = "7|Mvmt Status";
	  	}		
	}else
	{
		/* 필수가 아니기 때문에 삭제
		if(document.group1.Code == 1){
	  		comboObjects[4].Index = 0; // 빈칸
	  		//arrGroup[0] = "2|Office";
	      	//arrGroup[1] = "3|SCC[Location]";
	      	//arrGroup[2] = "4|Yard";
	      	//arrGroup[3] = "5|Lease term";
	      	//arrGroup[4] = "6|Lessor";
	      	//arrGroup[5] = "7|Mvmt Status";
	 	} else if(document.group1.Code == 2){
	 		comboObjects[4].Index = 0; // 빈칸
	      	//arrGroup[0] = "3|SCC[Location]";
	      	//arrGroup[1] = "4|Yard";
	      	//arrGroup[2] = "5|Lease term";
	      	//arrGroup[3] = "6|Lessor";
	      	//arrGroup[4] = "7|Mvmt Status";
	  	} else if(document.group1.Code == 3){
	  		comboObjects[4].Index = 0; // 빈칸
	  	  	//arrGroup[0] = "4|Yard";
	      	//arrGroup[1] = "5|Lease term";
	      	//arrGroup[2] = "6|Lessor";
	      	//arrGroup[3] = "7|Mvmt Status";
	  	} else if(document.group1.Code == 4){
	  		comboObjects[4].Index = 0; // 빈칸
	      	//arrGroup[0] = "5|Lease term";
	      	//arrGroup[1] = "6|Lessor";
	      	//arrGroup[2] = "7|Mvmt Status";
	  	}		
	  	*/	
	}
}
/**
 * 유효값체크 로직(자리수에 맞춰서)
 * @author 조재성 2009.09.30
 */
function obj_keyup(){
	 var formObj = document.form;
	 var sheetObj = sheetObjects[0];
	 obj = event.srcElement;
	 switch(obj.name){
 	 	case "crnt_loc_cd":
	 		var crntLocCd = ComTrimAll(formObj.crnt_loc_cd.value);
	   		var arrCrntLocCd = crntLocCd.split(",");
	   		
	   		for(var i = 0; i < arrCrntLocCd.length; i++){
	   		// 입력오류 체크 (예> ,,)
	 			if(arrCrntLocCd[i] == ''){
	 				ComShowCodeMessage('CGM10009','Location');
	 				formObj.crnt_loc_cd.value = "";
	 				ComSetFocus(formObj.crnt_loc_cd);
	 				break;
	 			}else
	 			{
	    	 		//if(formObj.crnt_loc_cd.value != ''){
	    	 		if(formObj.crnt_loc_cd.value.length == 5){
	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
	    	 		}
	 			}
	   		}
	 		break; 
 	   	case "crnt_yd_cd":
	   		var crntYdCd = ComTrimAll(formObj.crnt_yd_cd.value);
	   		if( formObj.crnt_yd_cd.value.search(',') > 0 || (formObj.crnt_yd_cd.value == '')) // 다중 yard code(,로 연결됨)이면 검사하지 않는다. 
	   		{
	   	    	// chungpa 20091014 Location 에서 SCC 로 선택되거나, Yard 를 입력후 조회시 1.Group by 는 'SCC' 로,   2.Group by 는 'Yard' 로 자동변환토록 수정.
	   			checkGroup2Yard();
	   			break;
	   		}
	   		var arrCrntYdCd = crntYdCd.split(",");
	   		for(var i = 0; i < arrCrntYdCd.length; i++){
	   			// 입력오류 체크 (예> ,,)
	 			if(arrCrntYdCd[i] == ''){
	 				ComShowCodeMessage('CGM10009','Yard');
	 				formObj.crnt_yd_cd.value = "";
	 				ComSetFocus(formObj.crnt_yd_cd);
	 				break;
	 			}
	   		}
	   		
	 		//if(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value != ''){
	 		if(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value.length == 7){
	 			
	 			//chungpa 20091015 MULTI일경우 YD check안함
	 			//doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
	   	    	
	 			
	 			// chungpa 20091014 Location 에서 SCC 로 선택되거나, Yard 를 입력후 조회시 1.Group by 는 'SCC' 로,   2.Group by 는 'Yard' 로 자동변환토록 수정.
	   			checkGroup2Yard();		 			
 	 		} 
 	 		break;
	 }
}               
	/* 개발자 작업  끝 */