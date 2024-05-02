/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1082.js
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.31 강동윤
* 1.0 Creation
* -----------------------------------------------------------------
* History
* 2010.10.08 김영철 [CHM-201006186-01] 
*   1. 조회조건으로 Contract Office및  Sales Rep.조건 추가
*   2. Direct Down Load(B/L Detail) List상에 Contract Office및 Contract Sales Rep. 추가반영 및 일부항목 Label수정
*   3. bkg실적이 없는 날짜에 bkg된 것처럼 display되는 error수정.
*   4. BKG Trend의 "D" Day의 의미 및 SNAPSHOT Time를 명확히하는 차원에서 Guide문귀 삽입
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
     * @class ESM_BKG_1082 : ESM_BKG_1082 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1082() {
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
var combo1 = null;
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;		
    }

	function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
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

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        //MultiCombo초기화 
	 	for(var k=0;k<comboObjects.length;k++){
	 		initCombo(comboObjects[k],comboObjects[k].id);
	 	}
        
        initControl();
        
        document.form.pol_etd_fr_dt.focus();

    }
	
	/**
      * 콤보 초기설정값
      * @param {IBMultiCombo} comboObj  comboObj
      */
      function initCombo(comboObj, comboId) {
    	  comboObj.MultiSelect = false;
    	  comboObj.UseCode = true;
    	  //comboObj.LineColor = "#ffffff";
    	  //comboObj.SetColAlign("left|left");
    	  comboObj.MultiSeparator = ",";
    	  comboObj.DropHeight = 150;      	
    	  
    	  if (comboId == "vvd"){
    		  
    		  comboObj.MultiSelect = true;
        	  comboObj.UseEdit = true;
        	  comboObj.BackColor = "#CCFFFD";
    	  }else if (comboId == "grp_by"){
    		  
    		  comboObj.MultiSelect = true;
    	  }
    	  
    	  UseAutoComplete = true; // 편집시 자동 코드 검색
      }  
      
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
								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
							break; 
							
							case "btn_new":
								ComResetAll();
  		    	   				tabObjects[0].SelectedIndex = '0';
  		    	   				
  		    	   				for(var i = 0 ; i < formObject.dis_op.length ; i++){
  		    	   					
  		    	   					formObject.dis_op[i].checked = false;
  		    	   				}
							break;  
							
							case "btn_excel":
								/* Excel Down 시만  적용 */
					 			var cnt = sheetObjects[0].RowCount + 1;
					 			var totCm = 0;
					 			var totCmpb = 0;
					 			for(var idx = 1; idx < cnt; idx++){
					 				totCm += parseInt(sheetObjects[0].CellValue(idx,"cm"));				
					 			}
					 			totCmpb = totCm / parseInt(sheetObjects[0].CellValue(cnt,"load"));  
//					 			sheetObjects[0].CellValue(cnt,"cm") = totCm;
					 			sheetObjects[0].CellValue(cnt,"cmpb") = parseInt(totCmpb);
					 			
								sheetObject.SpeedDown2Excel(-1);
								
//								sheetObjects[0].CellValue(cnt,"cm") = "";
					 			sheetObjects[0].CellValue(cnt,"cmpb") = "";
								
							break;                      
							
							case "btn_detail":
								openDtaile();
							break;  
							
							case "btn_directDown2Excel":
						  		var HeadTitle ="";
						  		var formObj = document.form;
						  		/* Unit View 에 따라 Title 수정 */
								if(formObj.unit_op[0].checked == true){ /* FEU */
									HeadTitle = "No|Shipper|Shipper\nCode|Booking No|Bkg\nStatus|Trunk VVD|Lane|POL\n(BKG)|POD\n(BKG)|DEL|POD\n(Trunk)|1st VVD|1st Leg\n(Lane)|1st POL_ETD|ETD_WK|Container\nTP/SZ List|TEU|FEU|Load\n(FEU)|CM|CMPB|Booking Date|Booking\nWeek|Cancel\nDate|Cancel\nWeek|L.Sales Rep.|L.Sales OFC|BKG OFC|S/C NO|RFA NO|TAA NO|C.Office|C.Sales Rep.|Commodity Cd|Commodity|Remark|Remark";
									sheetObjects[1].InitHeadRow(0,HeadTitle, true);
								}else{ /* TEU */
									HeadTitle = "No|Shipper|Shipper\nCode|Booking No|Bkg\nStatus|Trunk VVD|Lane|POL\n(BKG)|POD\n(BKG)|DEL|POD\n(Trunk)|1st VVD|1st Leg\n(Lane)|1st POL_ETD|ETD_WK|Container\nTP/SZ List|TEU|FEU|Load\n(TEU)|CM|CMPB|Booking Date|Booking\nWeek|Cancel\nDate|Cancel\nWeek|L.Sales Rep.|L.Sales OFC|BKG OFC|S/C NO|RFA NO|TAA NO|C.Office|C.Sales Rep.|Commodity Cd|Commodity|Remark|Remark";
									sheetObjects[1].InitHeadRow(0,HeadTitle, true);
								}
								doActionIBSheet(sheetObjects[1],document.form,SEARCH02);
							break; 	

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("지금은 사용하실 수가 없습니다 ");
    		} else {
    			alert(e);
    		}
    	}
    }
    
     /**
      * 조회조건 입력할 때 처리
      */
     function obj_KeyUp() {
	     var formObject = document.form;
	     var srcName = window.event.srcElement.getAttribute("name");
	     var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	     var srcValue = window.event.srcElement.getAttribute("value");
	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
	     	ComSetNextFocus();
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
      	var formObject = document.form;
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
          
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
          axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
      }
      
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
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
            case 1:      //sheet1 init

                with (sheetObj) {

                    // 높이 설정
                    style.height = 450;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(43, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Sel.|Lane|VVD|Trade|Sub\nTrade|Lane|POL|ETD|WK|S.Rep|Shipper|Shipper Name|LOAD(TEU)|CM|CMPB|D-1|D-2|D-3|D-4|D-5|D-6|D-7|D-8|D-9|D-10|D-11|D-12|D-13|D-14|D-15|D-16|D-17|D-18|D-19|D-20|D-21|D-22|D-23|D-24|D-25|D-26|D-27|D-28";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtCheckBox,	40,	daCenter,	false,		"sel");		
					InitDataProperty(0, cnt++ , dtData,	60,		daCenter,	true,		"slan_cd",		false,	"",      dfNone,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	110,	daCenter,	true,		"vvd",			false,	"",      dfNone,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	40,		daCenter,	true,		"trd_cd",		false,	"",      dfNone,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	40,		daCenter,	true,		"sub_trd_cd",	false,	"",      dfNone,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	40,		daCenter,	true,		"rlane_cd",		false,	"",      dfNone,	0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,	60,		daCenter,	true,		"pol_cd",		false,	"",      dfNone,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	60,		daCenter,	true,		"etd_dt",		false,	"",      dfNone,	0,		false,		false);
			
					InitDataProperty(0, cnt++ , dtData,	30,		daCenter,	true,		"cost_wk",		false,	"",      dfNone,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	50,		daCenter,	true,		"ob_srep_cd",	false,	"",      dfNone,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	70,		daLeft,		true,		"cust_cd",		false,	"",      dfNone,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	130,	daLeft,		true,		"cust_nm",		false,	"",      dfNone,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	false,		"load",			false,	"",      dfFloat,	1,		false,		false);
			
					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	false,		"cm",			false,	"",      dfInteger,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	70,		daRight,	false,		"cmpb",			false,	"",      dfInteger,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_1",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_2",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_3",			false,	"",      dfFloat,	1,		false,		false);
			
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_4",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_5",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_6",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_7",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_8",			false,	"",      dfFloat,	1,		false,		false);
			
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_9",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_10",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_11",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_12",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_13",			false,	"",      dfFloat,	1,		false,		false);
			
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_14",			false,	"",      dfFloat,	1,		false,		false);
													
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_15",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_16",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_17",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_18",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_19",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_20",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_21",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_22",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_23",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_24",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_25",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_26",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_27",			false,	"",      dfFloat,	1,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_28",			false,	"",      dfFloat,	1,		false,		false);
					
					//CountPosition = 0;	
					FrozenCols = 9;

               }
                break;
               
            case 2:      //sheet2 init

            with (sheetObj) {

                // 높이 설정
                style.height = 300;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 18, 100);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle = "No|Shipper|Shipper\nCode|Booking No|Bkg\nStatus|Trunk VVD|Lane|POL\n(BKG)|POD\n(BKG)|DEL|POD\n(Trunk)|1st VVD|1st Leg\n(Lane)|1st POL_ETD|ETD_WK|Container\nTP/SZ List|TEU|FEU|Load\n(TEU)|CM|CMPB|Booking Date|Booking\nWeek|Cancel\nDate|Cancel\nWeek|L.Sales Rep.|L.Sales OFC|BKG OFC|S/C NO|RFA NO|TAA NO|C.Office|C.Sales Rep.|Commodity Cd|Commodity|Remark|Remark";
                var headCount = ComCountHeadTitle(HeadTitle);
                
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++,  dtSeq, 	40, 	daCenter, 	false, 		"Seq");		
				InitDataProperty(0, cnt++ , dtData,	150,		daLeft,	true,		"cust_nm",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,		"cust_cd",			false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	90,		daCenter,	true,		"bkg_no",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	true,		"bkg_sts_cd",		false,	"",      dfNone,	0,		true,		true);
		
				InitDataProperty(0, cnt++ , dtData,	90,		daCenter,	true,		"trnk_vvd_cd",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	50,		daCenter,	true,		"slan_cd",	false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"pol_cd",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"pod_cd",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"del_cd",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"pod_cd_trunk",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	90,	daCenter,		true,		"vvd",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"vvd_slan_cd",		false,	"",      dfNone,	0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	true,		"etd_dt",	false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	50,		daCenter,		true,		"etd_wk",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	130,	daLeft,		true,		"cntr_tp_sz",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,		"c_teu",			false,	"",      dfFloat,	2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,		"c_feu",			false,	"",      dfFloat,	2,		true,		true);
				
				InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,		"load",			false,	"",      dfFloat,	2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,		"cm",			false,	"",      dfFloat,	2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,		"cmpb",			false,	"",      dfFloat,	2,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	90,		daCenter,	true,		"bkg_cre_dt",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	true,		"bkg_cre_wk",	false,	"",      dfNone,	0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,	90,		daCenter,		true,		"bkg_cxl_dt",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,		true,		"bkg_cxl_wk",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"ob_srep_cd",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"ob_sls_ofc_cd",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"s_bkg_ofc_cd",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"sc_no",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"rfa_no",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"taa_no",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"ctrt_ofc_cd",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,		"ctrt_srep_cd",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	90,		daCenter,	true,		"cmdt_cd",	false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	150,		daLeft,		true,		"cmdt_nm",		false,	"",      dfNone,	0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,	200,	daLeft,		true,		"inter_rmk",		false,	"",      dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,	200,	daLeft,		true,		"xter_rmk",		false,	"",      dfNone,	0,		true,		true);
				

           }
            break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

					case IBSEARCH:      //조회
						if(!validateForm(sheetObj,formObj,sAction)) return;
						sheetObj.Reset();
						initSheet(sheetObjects[0],1);
						tabObjects[0].SelectedIndex = "1";
						
						sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    							
	    				formObj.f_cmd.value = SEARCH;   
	    				sheetObj.DoSearch("ESM_BKG_1082GS.do",FormQueryString(formObj));	    				

	    				to_dt.innerHTML = ComGetDateAdd(null, "d", 0, ".");
	    				
	    				break;
					case SEARCH02:      //조회
						if(!validateForm(sheetObj,formObj,sAction)) return;
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
								
	    				formObj.f_cmd.value = SEARCH02;   
	    				var sXml = sheetObj.GetSearchXml("ESM_BKG_1082GS.do",FormQueryString(formObj));
	    				
	    				sheetObj.LoadSearchXml(sXml);
	    				sheetObj.SpeedDown2Excel(-1);
	    				ComOpenWait(false);
	    				
	    				to_dt.innerHTML = ComGetDateAdd(null, "d", 0, ".");
	    				
	    				break;
					
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
                    InsertTab( cnt++ , "Search " , -1 );
                    InsertTab( cnt++ , "Output Result" , -1 );
                   
                
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
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		
    	 	if((ComGetObjValue(formObj.pol_etd_fr_dt) == "" && ComGetObjValue(formObj.pol_etd_to_dt) == "") && (ComGetObjValue(formObj.bkg_cxl_fr_dt) == "" && ComGetObjValue(formObj.bkg_cxl_to_dt) == "") && formObj.vvd.Text == ''){
    	 		ComShowCodeMessage("BKG00499");
    	 		return false;
    	 	}
    	 	if(!ComIsNull(formObj.pol_etd_fr_dt) ||!ComIsNull(formObj.pol_etd_to_dt)){
    			if(ComGetObjValue(formObj.pol_etd_fr_dt) == ""){
					ComShowCodeMessage("BKG00499");
					formObj.pol_etd_fr_dt.focus();
					return false;
    			}
    			if(ComGetObjValue(formObj.pol_etd_to_dt) == ""){
					ComShowCodeMessage("BKG00499");
					formObj.pol_etd_to_dt.focus();
					return false;
    			}
    	 	}
    	 	if(!ComIsNull(formObj.bkg_cxl_fr_dt) || !ComIsNull(formObj.bkg_cxl_to_dt)){
    			if(ComGetObjValue(formObj.bkg_cxl_fr_dt) == ""){
					ComShowCodeMessage("BKG00499");
					formObj.bkg_cxl_fr_dt.focus();
					return false;
				}
				if(ComGetObjValue(formObj.bkg_cxl_to_dt) == ""){
					ComShowCodeMessage("BKG00499");
					formObj.bkg_cxl_to_dt.focus();
					return false;
				}
    	 	}
			if (!ComIsNull(formObj.pol_etd_fr_dt) 
		  			&& !ComIsNull(formObj.pol_etd_to_dt) 
		  			&& ComGetDaysBetween(formObj.pol_etd_fr_dt.value, formObj.pol_etd_to_dt.value) > 31){
           		 
     			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
     			formObj.pol_etd_fr_dt.focus();
     			return false;
     		}
			
			if(ComGetObjValue(formObj.ob_sls_ofc_cd) == "" && ComGetObjValue(formObj.bkg_ofc_cd) == "" && ComGetObjValue(formObj.ctrt_ofc_cd) == ""){
				ComShowCodeMessage('BKG00626', 'Contract Ofc or Sales Ofc or BKG Ofc');
				formObj.ob_sls_ofc_cd.focus();
				return false;
			}
			if (!ComIsNull(formObj.bkg_cxl_fr_dt) 
		  			&& !ComIsNull(formObj.bkg_cxl_to_dt) 
		  			&& ComGetDaysBetween(formObj.bkg_cxl_fr_dt.value, formObj.bkg_cxl_to_dt.value) > 31){
           		 
     			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
     			formObj.bkg_cxl_fr_dt.focus();
     			return false;
     		}
			
//			if (formObj.vvd.Text == ''){
//        		
//        		ComShowCodeMessage("BKG00007");//VVD is not available !    		  
//	      	   	formObj.vvd.focus();    		  
//	      	   	return false;
//        	}    	
		
		formObj.dis_val.value = '';
				
		for(var i = 0 ; i < formObj.dis_op.length ; i++){
			
			if (formObj.dis_op[i].checked == true){
				
				formObj.dis_val.value += (i+1) + ",";
			}
		}
		
        return true;
    }

	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
  	{
  		var formObj = document.form;
  		
  		with(sheetObj)
  		{
  			//S.Rep
  			if(formObj.dis_op[0].checked == false){
  				sheetObj.ColHidden(9) 	= true;
  			}else{
  				sheetObj.ColHidden(9) 	= false;
  			}
			
  			//Shipper, Shipper Name
			if(formObj.dis_op[1].checked == false){
  				sheetObj.ColHidden(10) 	= true;
  				sheetObj.ColHidden(11) 	= true;
  			}else{
				sheetObj.ColHidden(10) 	= false;
				sheetObj.ColHidden(11) 	= false;
			}
		
			//CM, CMPB
			if(formObj.dis_op[2].checked == false){
  				sheetObj.ColHidden(13) 	= true;
  				sheetObj.ColHidden(14) 	= true;
  			}else{
  				sheetObj.ColHidden(13) 	= false;
  				sheetObj.ColHidden(14) 	= false;
  			}
  				
  			
  			var idx = parseInt(formObj.dis_days.value);
  			
  			for (var i = 15+idx ; i < 44 ; i++){
  				
  				sheetObj.ColHidden(i) 	= true;
  			}	
  			ComOpenWait(false);
  			/*SumText(0, "slan_cd") = "";
    		SumText(0, "vvd") = "Total";*/
 			if(formObj.dis_op[2].checked == false){
  				SumValue(0,"cmpb") = CutDecimalPoint(SumValue(0,"cm") /SumValue(0,"load"),0) ;
 			}
 			/* Unit View 에 따라 Title 수정 */
 			var HeadTitle ="";
 			if(formObj.unit_op[0].checked == true){ /* FEU */
				var HeadTitle = "Sel.|Lane|VVD|Trade|Sub\nTrade|Lane|POL|ETD|WK|S.Rep|Shipper|Shipper Name|LOAD(FEU)|CM|CMPB|D-1|D-2|D-3|D-4|D-5|D-6|D-7|D-8|D-9|D-10|D-11|D-12|D-13|D-14|D-15|D-16|D-17|D-18|D-19|D-20|D-21|D-22|D-23|D-24|D-25|D-26|D-27|D-28";
				sheetObjects[0].InitHeadRow(0,HeadTitle, true);
			}else{ /* TEU */
				var HeadTitle = "Sel.|Lane|VVD|Trade|Sub\nTrade|Lane|POL|ETD|WK|S.Rep|Shipper|Shipper Name|LOAD(TEU)|CM|CMPB|D-1|D-2|D-3|D-4|D-5|D-6|D-7|D-8|D-9|D-10|D-11|D-12|D-13|D-14|D-15|D-16|D-17|D-18|D-19|D-20|D-21|D-22|D-23|D-24|D-25|D-26|D-27|D-28";
				sheetObjects[0].InitHeadRow(0,HeadTitle, true);
			}
 			
 			if(formObj.unit_op[0].checked == true){ /* FEU */
				HeadTitle = "No|Shipper|Shipper\nCode|Booking No|Bkg\nStatus|Trunk VVD|Lane|POL\n(BKG)|1st VVD|1st Leg\n(Lane)|1st POL_ETD|ETD_WK|Container\nTP/SZ List|TEU|FEU|Load\n(FEU)|CM|CMPB|Booking Date|Booking\nWeek|Cancel\nDate|Cancel\nWeek|L.Sales Rep.|L.Sales OFC|BKG OFC|S/C NO|RFA NO|TAA NO|C.Office|C.Sales Rep.|Commodity Cd|Commodity|Remark|Remark"; 
 				sheetObjects[1].InitHeadRow(0,HeadTitle, true);
 			}else{ /* TEU */
 				HeadTitle = "No|Shipper|Shipper\nCode|Booking No|Bkg\nStatus|Trunk VVD|Lane|POL\n(BKG)|1st VVD|1st Leg\n(Lane)|1st POL_ETD|ETD_WK|Container\nTP/SZ List|TEU|FEU|Load\n(TEU)|CM|CMPB|Booking Date|Booking\nWeek|Cancel\nDate|Cancel\nWeek|L.Sales Rep.|L.Sales OFC|BKG OFC|S/C NO|RFA NO|TAA NO|C.Office|C.Sales Rep.|Commodity Cd|Commodity|Remark|Remark";
 				sheetObjects[1].InitHeadRow(0,HeadTitle, true);
 			}
  		}
  	}
	
	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	function sheet2_OnSearchEnd(sheetObj, ErrMsg)
  	{
		var cnt = sheetObjects[1].RowCount + 1;
			var totCm = 0;
			var totCmpb = 0;
			for(var idx = 1; idx < cnt; idx++){
				totCm += parseInt(sheetObjects[1].CellValue(idx,"cm"));				
			}
			totCmpb = totCm / parseInt(sheetObjects[1].CellValue(cnt,"load"));  
			sheetObjects[1].CellValue(cnt,"cm") = totCm;
			sheetObjects[1].CellValue(cnt,"cmpb") = parseInt(totCmpb);
  	}
	
	
	   /**
        *  라디오 버튼 만들기 
        */
       function sheet1_OnClick(sheetObj, row, col, value) {

            if (sheetObj.ColSaveName(col) == "sel") {	 

				if (sheetObj.CellValue(row,'sel') == '0'){
					
					for(var i = 1 ; i <= sheetObj.RowCount ; i++){
						
						if (i != row){
							
							sheetObj.CellValue(i,'sel') = '0';
						}
					}
				}
    		}
     	}
     		
  	   /**
        * open B/L Detail
        */    
       function openDtaile(){
    	   var formObj  = document.form;
    	   var sheetObj = sheetObjects[0];
    	   var chk = false;
    	   var sel_slan_cd,sel_vvd,sel_pol_cd,sel_etd_dt,sel_cost_wk,sel_ob_srep_cd,sel_cust_cd;
    	   for (var i = 1 ; i < sheetObj.LastRow ; i++){
    	   		if (sheetObj.CellValue(i,'sel') == '1'){
    	   			sel_slan_cd = sheetObj.CellValue(i,'slan_cd');
    	   			sel_vvd = sheetObj.CellValue(i,'vvd');
    	   			sel_pol_cd = sheetObj.CellValue(i,'pol_cd');
    	   			sel_etd_dt = sheetObj.CellValue(i,'etd_dt');
    	   			sel_cost_wk = sheetObj.CellValue(i,'cost_wk');
    	   			sel_ob_srep_cd = sheetObj.CellValue(i,'ob_srep_cd');
    	   			sel_cust_cd = sheetObj.CellValue(i,'cust_cd');
    	   			chk = true;
    	   			break;
    	   		}
    	   }
    	   
    	   if (!chk){
    	   		ComShowCodeMessage("BKG00249");//No Selected Row
    			return;
    	   }
    	   ComSetObjValue(formObj.f_cmd,INIT);
    	   var param = "";
    	   param += "&sel_slan_cd="+sel_slan_cd;
    	   param += "&sel_vvd="+sel_vvd;
    	   param += "&sel_pol_cd="+sel_pol_cd;
    	   param += "&sel_etd_dt="+sel_etd_dt;
    	   param += "&sel_cost_wk="+sel_cost_wk;
    	   param += "&sel_ob_srep_cd="+sel_ob_srep_cd;
    	   param += "&sel_cust_cd="+sel_cust_cd;
    	   param += "&"+FormQueryString(formObj);
    	   //alert("/hanjin/ESM_BKG_1083.do?f_cmd=SEARCH&"+FormQueryString(formObj));
    	   ComOpenWindowCenter("/hanjin/ESM_BKG_1083.do?"+param, "ESM_BKG_1083", 1000, 570, true);
     	   //var pWin = ComOpenWindow("/hanjin/ESM_BKG_1083.do" + param,"open1083", "statebar=no,width=1000,height=570,left=200,top=0");

       }
  	    
        /**
		 * VVD Name Upper Event
    	 */
    	 function searchLane(vvd) {
    		 
			 var formObj  = document.form;
			 var sheetObj = sheetObjects[0];
			 
			 if (vvd.value == ""){
				 
				 formObj.slan_cd.value = "";
				 formObj.vvd_idx.value = "";				 
				 return;
			 }else if (vvd.value.length != 9){
				 
				 ComShowCodeMessage("BKG00145");//Please! Check your VVD.	
				 vvd.focus();
				 return;
			 }			 			
			 
			 formObj.f_cmd.value = SEARCH01;   
			 
			 var searchXml = sheetObj.GetSearchXml("ESM_BKG_1082GS.do" , FormQueryString(formObj));
			 
			 if (ComGetEtcData(searchXml,"lane") == "none"){
				 
				 ComShowCodeMessage("BKG00163");//VVD is NOT Registered
				 vvd.focus();
				 return;
			 }
			 
			 formObj.slan_cd.value = ComGetEtcData(searchXml,"lane");
			 formObj.vvd_idx.value = "1";
			 
			 var comboObj = comboObjects[0];
			 
			 comboObj.InsertItem(-1, vvd.value, vvd.value); 
			 comboObj.Index2 = comboObj.GetCount()-1;

			 fromObj.vvd.focus();			 
		 }
		 
		 /**
		  * VVD Combo Change Event
	      */
		 function vvd_OnChange(comboObj,value,text){
			 
			 var formObj  = document.form;
			 
			 var comIdx = text.split(",");

			 if (comIdx.length > 1){

				 formObj.vvd_sig.value = "";
				 formObj.slan_cd.value = "";
				 formObj.vvd_idx.value = comIdx.length;
			 }
		 }
	
		  /**
	       * VVD Selection Inquiry Popup Open
	       */ 
	      function getVvds(){
	    	  
	    	  var param = ""
	    	  var pWin = ComOpenWindow("/hanjin/ESM_BKG_0753.do" + param,"open0753", "statebar=no,width=920,height=390,left=200,top=0");
	      }
	      
	      function clearVvds(){
	      	 document.form.vvd.RemoveAll();
	      }
	      
	 	  /**
		   * VVD Selection Inquiry Popup Value Import
		   */
	      function setVvds(vvds){
	    	  
			  var formObj = document.form;
	    	  var comboObj = comboObjects[0];
	    	  
	    	  ComClearCombo(formObj.rpt_nm);	    	  
	    	  
	    	  var arVvds = vvds.split(",");
	    	  
	    	  for (var i = 0 ; i < arVvds.length ; i++){
	    		  
	    		  comboObj.InsertItem(-1, arVvds[i], arVvds[i]);
	    	  }
	    	  
	    	  comboObj.Text2 = vvds;
	    	  
	    	  formObj.vvd_sig.value = "";
			  formObj.slan_cd.value = "";
			  formObj.vvd_idx.value = arVvds.length;
			  
	      }
		/**
         * 날짜 계산 함수
         */
        function getCalculatedDate(iYear,iMonth,iDay,seperator)
        {
        	//현재 날짜 객체를 얻어옴
        	var gdCurDate = new Date();
        	
        	//현재 날짜에 날짜 계산
        	gdCurDate.setYear(gdCurDate.getFullYear() + iYear);
        	gdCurDate.setMonth(gdCurDate.getMonth() + iMonth);
        	gdCurDate.setDate(gdCurDate.getDate() + iDay);
        	
        	//실제 사용할 연,월,일 변수 받기
        	var giYear = gdCurDate.getFullYear();
        	var giMonth = gdCurDate.getMonth()+1;
        	var giDay = gdCurDate.getDate();

        	//월,일의 자릿수를 2자리로 맞춘다.
        	giMonth = "0" + giMonth;
        	giMonth = giMonth.substring(giMonth.length-2,giMonth.length);
        	giDay   = "0" + giDay;
        	giDay   = giDay.substring(giDay.length-2,giDay.length);
        	//alert(giYear + seperator + giMonth + seperator + giDay);
        	//display 형태 맞추기
        	return giYear + seperator + giMonth + seperator + giDay;	
        }
         /**
     	* from,to 기간 선택 달력 띄우기
     	*/
     	function callDatePop(val){
     		var cal = new ComCalendarFromTo();
     		if (val == 'BKG_CXL_DATE'){
     			cal.select(form.bkg_cxl_fr_dt,  form.bkg_cxl_to_dt,  'yyyy-MM-dd');
     		}else if (val == 'POL_ETD_DT'){
     			cal.select(form.pol_etd_fr_dt,  form.pol_etd_to_dt,  'yyyy-MM-dd');	
     		}
     		
     	} 

     	function checkCancel() {
     		var formObj = document.form;
     		var fr = formObj.bkg_cxl_fr_dt;
     		var to = formObj.bkg_cxl_to_dt;
     		var chk = formObj.chk_cxl_bkg_only;
     		if (!ComIsEmpty(fr.value) && !ComIsEmpty(to.value)) {
     			chk.checked = true;
     		}
     	}
     	/* 개발자 작업  끝 */
        