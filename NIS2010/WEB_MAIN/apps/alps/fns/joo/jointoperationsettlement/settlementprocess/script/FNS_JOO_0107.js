/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0107.js
*@FileTitle : JO Settlement Status Information
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.30 민정호
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
     * @class ees_ctm_0408 : ees_ctm_0408 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0107() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject        	= setSheetObject;
        this.loadPage              		= loadPage;
        this.initSheet             		= initSheet;        
    	this.initControl 					= initControl;        
        this.doActionIBSheet       	= doActionIBSheet;
        this.validateForm				= validateForm;
    } 

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var gRefresh = true;

var prefix="";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

        var sheetObj = sheetObjects[0];
        
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
	     		case "btns_calendar1": //달력버튼
	     			var cal = new ComCalendar();
	     			cal.setDisplayType('month');
	     			cal.select(formObj.rev_yrmon, 'yyyy-MM');           	 
	     			break;            
            
                case "btn_retrieve":
        			if(formObj.page_no.value == ""){
        				formObj.page_no.value = "1";
        			}		
        			
        			if(comboObjects[0].Text == "OUS/RF/OTHER"  || comboObjects[0].Text == "OUS/RF/OTHER(Detail)"){
	    				if(comboObjects[5].Text == "ALL"){					        			
	        				alert("Please select 'Rev/Exp'");
	        				return;
	        			}
        			}
        			
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
                    break;
                    
                case "btn_new":
        			UF_reset();
        			reset_all();	// 페이지 초기화       
                    break;

        		case "btn_downexcel":
        			sheetObj.Down2Excel(-1);
        			break;                    
        								
        		case "reward":
        			var ipageNo = parseInt(formObj.page_no.value);
        			var totpage = parseInt(formObj.tot_page_cnt.value);
        			if(ipageNo <= 1){
        				return;
        			}

        			ipageNo--;
        			
        			if(ipageNo <= 1){
        				ipageNo = 1;
        			}
        			
        			
        			formObj.page_no.value = ipageNo;
        			doActionIBSheet(sheetObj, formObj, IBSEARCH);
        			break;

        		case "forward":
        			var ipageNo = parseInt(formObj.page_no.value);
        			var totpage = parseInt(formObj.tot_page_cnt.value);
        			if(totpage == 0){
        				return;
        			} else if(ipageNo >= totpage) {
        				return;
        			}
        			ipageNo++;  
        			formObj.page_no.value = ipageNo;
        			doActionIBSheet(sheetObj, formObj, IBSEARCH);
        			break;		        			
        			
            } // end switch
        } catch(e) {
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
     * IBCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
     function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
     }    
    
     function sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
         document.form.rlane_cd.focus();
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
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
          
        // IBMultiCombo초기화
        for(var k=0; k<comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }                
        
    	var arr1d = gTrdLaneCrr.split("|");
    	gTrdLaneCrrArr = arr1d;
    	for (var i=0; i< arr1d.length; i++){
    		var arr2d = arr1d[i];
    		gTrdLaneCrrArr[i] = arr2d.split(",");
    	}
    	
    	initControl();    	    	
    }

    /**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     * @param comboObj
     * @param comboIndex Number
     */
     function initCombo(comboObj, comboNo ) {

    	 var formObj = document.form;
    	 
        switch(comboObj.id) {
 		case "re_divr_cd":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("60");
				DropHeight = 160;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 7;
			}
			var comboItems = "ALL, |Rev,R|Exp,E";
			UF_addComboItem(comboObj, comboItems.split("|"));
			comboObj.Text2 = "ALL";
			break;
			
		case "jo_crr_cd":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 3;
			}
			var comboItems = ("ALL, |"+gCrrCd+"|SML,SML").split("|");
			UF_addComboItem(comboObj, comboItems);			
			comboObj.Text2 = "ALL";
			break;
	
		case "trd_cd":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 3;
			}
			var comboItems = ("ALL, |"+gTrdCd).split("|");
			UF_addComboItem(comboObj, comboItems);
			comboObj.Text2 = "ALL";
			break;
	
		case "rlane_cd":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("50");
				DropHeight = 160;
				ValidChar(2, 1);//영문대문자+숫자만 입력가능
				MaxLength = 5;
			}
				
			var sheetObj = sheetObjects[0];
			formObj.f_cmd.value = SEARCH16;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+formObj.trd_cd.Code+"&super_cd1="+formObj.jo_crr_cd.Code);
	        ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code");
	        comboObj.InsertItem(0, "ALL", " ");
	        comboObj.Index2 = 0;			
			break;
			
		case "skd_dir_cd":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("60");
				DropHeight = 160;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 1;
			}
			var comboItems = "ALL, |E,E|W,W|S,S|N,N";
			UF_addComboItem(comboObj, comboItems.split("|"));
			comboObj.Text2 = "ALL";
			break;
			
		case "gubun":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("150");
				DropHeight = 160;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 1;
			}
			var comboItems = "Slot,slot|OUS/RF/OTHER,ous|OUS/RF/OTHER(Detail),ous_detail";
			UF_addComboItem(comboObj, comboItems.split("|"));
			comboObj.Text2 = "Slot";
			break;			
			
		case "date_cd":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("150");
				DropHeight = 160;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 1;
			}
			var comboItems = "Today,1|3 Months ago,2|6 Months ago,3";
			UF_addComboItem(comboObj, comboItems.split("|"));
			comboObj.Text2 = "Today";
			break;					
         }
     }    
    
    
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 배열에서 순번
     */
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "-";
    	var formObj = document.form;
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate'    ,  formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
    	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'      ,  formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'      , 	formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        axon_event.addListenerFormat('keyup'           , 'obj_keyup'         ,  formObj);
        axon_event.addListenerFormat('click'           , 'obj_onclick'       , 	formObj);
        axon_event.addListenerForm("Click","obj_Click", document.form);

    	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'          , formObj); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
    	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'         , formObj);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'      , formObj);
        
        axon_event.addListenerForm  ('keydown'         , 'ComKeyEnter'       , formObj);
        axon_event.addListenerForm  ('keyup'           , 'fnObjKeyUp'        , formObj );
        axon_event.addListenerForm  ('keypress'        , 'fnObjKeyPress'     , formObj );                            
    }
    
  //Axon 이벤트 처리2. 이벤트처리함수          
    function obj_deactivate() {
    	ComChkObjValid(event.srcElement);    	
    }
    
    function obj_activate() {
    	ComClearSeparator(event.srcElement);    	
    }
    
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
    		case "engup":
    			switch(event.srcElement.name){
    				case "vsl_cd":	     
    					ComKeyOnlyAlphabet('uppernum');		//영문대문자 입력하기 . 숫자도 포함
    					break;
    				case "port_cd":	     
    					ComKeyOnlyAlphabet('upper');		//영문대문자 입력하기
    					break;
    				case "vvd_port":	     
    					ComKeyOnlyAlphabet('uppernum');		//영문대문자 입력하기 . 숫자도 포함
    					break;	
    			}
    			break;
    	}
    }
    
    function obj_keyup() {
    	ComKeyEnter('lengthnextfocus');
    }
                                 
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
    	var sheetID = sheetObj.id;
    	
    	switch (sheetID) {		
        case "sheet1":      //sheet2 init
	        	with (sheetObj) {
//-----------------------
			// 높이 설정
			style.height = 433;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "Seq.|Revenue\nMonth|Trade|Lane|Carrier|Rev/Exp" +
		     						"|VVD|VVD|VVD|Yard|Yard|Yard" +					     						
									"|ETD|OUS|RF|OTHER" +
								    "|Remarks\nType|Remarks|PIC";			
			var HeadTitle2 = "Seq.|Revenue\nMonth|Trade|Lane|Carrier|Rev/Exp" +
								    "|VSL|VOY|DIR|PORT|TML|IND" +					     						
								    "|ETD|OUS|RF|OTHER" +
		    						"|Remarks\nType|Remarks|PIC";			

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData        , 40, daCenter, true, prefix + "seq"   );
			InitDataProperty(0, cnt++, dtData        , 80, daCenter, true, prefix + "rev_yrmon"	, false, "", dfUserFormat2, 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, prefix + "trd_cd" 		, false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, prefix + "rlane_cd"     , false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, prefix + "crr_cd"    	, false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 70, daCenter, true, prefix + "re_divr_cd"  	, false, "", dfNone, 0, true, true);			
			InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, prefix + "vsl"  			, false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, prefix + "voy"  			, false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 40, daCenter, true, prefix + "dir" 				, false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, prefix + "port" 			, false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 40, daCenter, true, prefix + "tml" 			, false, "", dfNone, 0, true, true);			
			InitDataProperty(0, cnt++, dtData        , 40, daCenter, true, prefix + "ind" 			, false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 110, daCenter, true, prefix + "etd" 	, false, "", dfUserFormat2, 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, prefix + "ous" 			, false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, prefix + "rf" 				, false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, prefix + "other" 			, false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo	       , 100, daLeft, 	 true, prefix + "rmk_tp" 		, false, "", dfNone, 0, true, true)
			InitDataProperty(0, cnt++, dtData        , 180, daLeft, 	 true, prefix + "rmk" 			, false, "", dfNone, 0, true, true);;
			InitDataProperty(0, cnt++, dtData        , 70, daLeft, 	 true, prefix + "pic" 			, false, "", dfNone, 0, true, true);
			
        	
			InitUserFormat2(0, "rev_yrmon",  "####-##", "-|:" );
			InitUserFormat2(0, "etd", "####-##-## ##:##", "-|:" );
			FrozenCols = 12;				
			
    		ColHidden(prefix+"rev_yrmon")	= false;
    		ColHidden(prefix+"trd_cd")			= false;
    		ColHidden(prefix+"rlane_cd")		= false;
    		ColHidden(prefix+"crr_cd")			= false;
    		ColHidden(prefix+"re_divr_cd")	= false;
    		ColHidden(prefix+"vsl")				= false;
    		ColHidden(prefix+"voy")			= false;
    		ColHidden(prefix+"dir")				= false;
    		ColHidden(prefix+"port")			= true;
    		ColHidden(prefix+"tml")				= true;
    		ColHidden(prefix+"ind")			    = true;
    		ColHidden(prefix+"etd")		= true;
    		ColHidden(prefix+"ous")			= true;
    		ColHidden(prefix+"rf")			    = true;
    		ColHidden(prefix+"other")			= true;
    		ColHidden(prefix+"rmk_tp")		= false;
//    		ColHidden(prefix+"rmk")			= false;
    		ColHidden(prefix+"pic")				= false;    				
    		
			InitDataCombo(0, prefix+"rmk_tp", " |Price TBD|Contract Details TBD|Operational Issues|Mere Delay", " |1|2|3|4","");    		
//----------------------        	
	        	}
            break;
        }        	
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
            case IBSEARCH:      //조회
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
                
			    sheetObj.WaitImageVisible=false;
			    ComOpenWait(true);		                
				formObj.f_cmd.value = SEARCH;				
				setConditionValue('1');						
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0107GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml, false); //Append X			
 				ComOpenWait(false);	 								
				break;
							                                
        }
    }
    	 	 	 
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         switch(sAction){
                 case IBSEARCH:
                     break;                     
         }
         return true;
     }

     /**
      * 구분 값이 변경 될 때
      * 구분 값에 따라서 그리드 항목 보이고 감추는 프로세스 처리
      */          
    function gubun_OnChange(comboObj, Code, Text) {
    	var sheetObj = sheetObjects[0];    	
    	var formObj = document.form;
    	
    	formObj.page_no.value = "1";
    	
    	sheetObjects[0].RemoveAll();
    	comboObjects[1].Index2 = 0;
    	comboObjects[2].Index2 = 0;
    	comboObjects[3].Index2 = 0;
    	comboObjects[4].Index2 = 0;
    	comboObjects[5].Index2 = 0;
    	formObj.vvd_cd.value = "";
    	    	
    	    	
    	sheetObj.RemoveAll(); 
    	
    	if(Code == 'slot'){
        	formObj.pagerows2.value = "50000";  		    	
    		sheetObj.ColHidden(prefix+"rev_yrmon")	= false;
    		sheetObj.ColHidden(prefix+"trd_cd")			= false;
    		sheetObj.ColHidden(prefix+"rlane_cd")		= false;
    		sheetObj.ColHidden(prefix+"crr_cd")			= false;
    		sheetObj.ColHidden(prefix+"re_divr_cd")	= false;
    		sheetObj.ColHidden(prefix+"vsl")				= false;
    		sheetObj.ColHidden(prefix+"voy")			= false;
    		sheetObj.ColHidden(prefix+"dir")				= false;
    		sheetObj.ColHidden(prefix+"port")			= true;
    		sheetObj.ColHidden(prefix+"tml")				= true;
    		sheetObj.ColHidden(prefix+"ind")			    = true;
    		sheetObj.ColHidden(prefix+"etd")			    = true;
    		sheetObj.ColHidden(prefix+"ous")			= true;
    		sheetObj.ColHidden(prefix+"rf")			    = true;
    		sheetObj.ColHidden(prefix+"other")			= true;
    		sheetObj.ColHidden(prefix+"rmk_tp")		= false;
//    		sheetObj.ColHidden(prefix+"rmk")			= false;
    		sheetObj.ColHidden(prefix+"pic")				= false;    		    		
    	}else if(Code == 'ous'){
        	formObj.pagerows2.value = "100000";  		    	
    		sheetObj.ColHidden(prefix+"rev_yrmon")	= true;
    		sheetObj.ColHidden(prefix+"trd_cd")			= false;
    		sheetObj.ColHidden(prefix+"rlane_cd")		= false;
    		sheetObj.ColHidden(prefix+"crr_cd")			= false;
    		sheetObj.ColHidden(prefix+"re_divr_cd")	= false;
    		sheetObj.ColHidden(prefix+"vsl")				= false;
    		sheetObj.ColHidden(prefix+"voy")			= false;
    		sheetObj.ColHidden(prefix+"dir")				= false;
    		sheetObj.ColHidden(prefix+"port")			= false;
    		sheetObj.ColHidden(prefix+"tml")				= false;
    		sheetObj.ColHidden(prefix+"ind")			    = false;
    		sheetObj.ColHidden(prefix+"etd")			    = false;
    		sheetObj.ColHidden(prefix+"ous")			= true;
    		sheetObj.ColHidden(prefix+"rf")			    = true;
    		sheetObj.ColHidden(prefix+"other")			= true;
    		sheetObj.ColHidden(prefix+"rmk_tp")		= false;
//    		sheetObj.ColHidden(prefix+"rmk")			= false;
    		sheetObj.ColHidden(prefix+"pic")				= false;    	    		
    	}else{
        	formObj.pagerows2.value = "50000";  		    	
    		sheetObj.ColHidden(prefix+"rev_yrmon")	= false;
    		sheetObj.ColHidden(prefix+"trd_cd")			= false;
    		sheetObj.ColHidden(prefix+"rlane_cd")		= false;
    		sheetObj.ColHidden(prefix+"crr_cd")			= false;
    		sheetObj.ColHidden(prefix+"re_divr_cd")	= false;
    		sheetObj.ColHidden(prefix+"vsl")				= false;
    		sheetObj.ColHidden(prefix+"voy")			= false;
    		sheetObj.ColHidden(prefix+"dir")				= false;
    		sheetObj.ColHidden(prefix+"port")			= false;
    		sheetObj.ColHidden(prefix+"tml")				= false;
    		sheetObj.ColHidden(prefix+"ind")			    = false;
    		sheetObj.ColHidden(prefix+"etd")			    = true;
    		sheetObj.ColHidden(prefix+"ous")			= false;
    		sheetObj.ColHidden(prefix+"rf")			    = false;
    		sheetObj.ColHidden(prefix+"other")			= false;
    		sheetObj.ColHidden(prefix+"rmk_tp")		= true;
//    		sheetObj.ColHidden(prefix+"rmk")			= true;
    		sheetObj.ColHidden(prefix+"pic")				= false;  
    	}
    }     
                            
    /**
     * NEW 버튼 처리 
     * @param    void
     * @return   void
     */
    function UF_reset() {
    	var formObj = document.form;
    	
    	formObj.page_no.value = "1";
    	
    	sheetObjects[0].RemoveAll();
//    	comboObjects[0].Index2 = 0;
    	comboObjects[1].Index2 = 0;
    	comboObjects[2].Index2 = 0;
    	comboObjects[3].Index2 = 0;
    	comboObjects[4].Index2 = 0;
    	comboObjects[5].Index2 = 0;
    	formObj.vvd_cd.value = "";

    	var Code = comboObjects[0].Code;  
    	if(Code == 'slot'){
        	formObj.pagerows2.value = "50000";  		    	
    	}else if(Code == 'ous'){
        	formObj.pagerows2.value = "100000";  		    	
    	}else{
        	formObj.pagerows2.value = "50000";  		    	
    	}//---------------------------------------
    	var sheetObj = sheetObjects[0];
    	sheetObj.RemoveAll();     	
    }    
    
    /**
     * 화면 Reset
     */ 
    
    function reset_all(){	 
    	var formObject = document.form;
    	
		formObject.tot_page_cnt.value="0";
		formObject.page_no.value="1";
		formObject.sheet1.RemoveEtcData();
		formObject.sheet1.RemoveAll();	
    }    
    
    /**
     * setConditionValue
     */    
    function setConditionValue(searchGubun){
  		var formObj = document.form;
  				
  		formObj.pagerows.value = formObj.pagerows2.value; 
    }      
    
    /**
     * Onkeydown 이벤트 관련
     */
     function gotopage(){
    	 var formObject = document.form;
    	 var tot_page = "";
    	 var cur_page = "";
    	 
    	 cur_page = formObject.page_no.value;
    	 tot_page = formObject.tot_page_cnt.value;
    	 
    	 if( (Number(cur_page) > Number(tot_page)) || tot_page < 1){
    		 var errMessage = ComGetMsg('JOO00214','','','');  			// 	msgs['TRS90351'] = 'You have just selected the number of page beyond that of total pages.' ;
    		 ComShowMessage(errMessage);
    		 return;
    	 }
    	 
    	 doActionIBSheet(sheetObjects[0],formObject,"IBSEARCH");    	 
     }    
     
     function sheet1_OnSearchEnd(sheetObj, errMsg) {
    		var formObj    = document.form;    		    		
    		var cmd = formObj.f_cmd.value;
    		var cur_page = formObj.page_no.value;
    		
    		if( (cmd == SEARCH) && sheetObj.RowCount > 0 && cur_page == "1") {
    			var tot_page_cnt = sheetObj.EtcData('tot_page_cnt');
    			formObj.tot_page_cnt.value = tot_page_cnt;
    		}			
    	}     
     
  	//TRADE 변경시 LANE 변경
  	function trd_cd_OnChange(comboObj, Code, Text){
  		var formObj = document.form;
  		formObj.rlane_cd.Index2 = -1;
  		formObj.rlane_cd.RemoveAll();
  		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObjects[2] ,"rlane_cd");
  		formObj.trd_cd.focus(); 	
  	}     
  	
 	//조회조건필드인 Lane SVC Type 데이터 조회
 	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
 	    sheetObj.ShowDebugMsg = false;	
 	    switch(sAction) {	
 	       case IBSEARCH: //TRADE
 				if (sComboObj.id == "trd_cd"){
 					//콤보필드를 초기화시킨다.
 					sComboObj.RemoveAll();
 					formObj.f_cmd.value = SEARCH15;
 					sheetObj.WaitImageVisible = false;
 					var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1="+formObj.jo_crr_cd.Code+"&super_cd2=");
 	                ComXml2ComboItem(sXml, formObj.trd_cd,"code","code");
 					sComboObj.InsertItem(0, "ALL", " ");
 					sComboObj.Index2 = 0;
 	    	   }else if (sComboObj.id == "rlane_cd") {
 					//콤보필드를 초기화시킨다.
 					sComboObj.RemoveAll();
 								
 					formObj.f_cmd.value = SEARCH16;
 					sheetObj.WaitImageVisible = false;
 					var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+formObj.trd_cd.Code+"&super_cd1=");
 					var comboItems = ("ALL, |"+ComGetEtcData(sXml, "rlane_cd")).split("|");
 					addComboItem(comboObjects[2],comboItems);
 					sComboObj.Index2 = 0;
 				}
 				break;
 	    }
 	} 	     
 	
/* 개발자 작업  끝 */
