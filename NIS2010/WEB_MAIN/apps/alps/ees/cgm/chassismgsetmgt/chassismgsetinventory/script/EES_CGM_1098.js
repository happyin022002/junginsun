/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1098.js
*@FileTitle : Inventory by Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.29 조재성
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.12.13 신혜정 [CHM-201115037-01] Location 'USNYC' default 셋팅   
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


    /**
     * @extends 
     * @class EES_CGM_1098 : EES_CGM_1098 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1098() {
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
 
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 조재성
     * @version 2009.07.29
     */ 
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_retrieve":
            		if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
            			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            		}
            		formObject.crnt_loc_cd.focus(); //조회후 focus는 location으로 가게 만든다.             		
                    break;

                case "btn_new":
                	initControl();
                    break; 

                case "btn_downexcel":
                	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                    break;
                 
                case "btns_crnt_loc_cd":	// Location Popup
	                var tmp = formObject.location.text;
	            	if(tmp == "RCC"){
	            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);
	            	} else if(tmp == "LCC") {
	            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
	            	} else if(tmp == "SCC") {
	            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
	            	}
                	break;
                	
                case "btns_crnt_yd_cd":		// Yard
                	//ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do', 1000, 450, "3:crnt_yd_cd", "1,0,1,1,1,1,1", true);
                	ComOpenPopup('/hanjin/COM_ENS_061.do',  800, 475, "callBackYard", "0,1,1,1,1,1,1", true, false);
                	break;
                	
                case "btns_vndr":
                	ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackVendor", "0,1,1,1,1,1", true, false);
                	break;   

                case "btns_agmt_no":
       			ComOpenPopup('/hanjin/EES_CGM_1117.do', 820, 420, "setAgmtNo", "0,1,1,1,1,1", true, false);
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
     * @author 조재성
     * @version 2009.07.29
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;
			
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.07.29
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
     * @version 2009.10.20
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
       	 axon_event.addListener('focusout', 'obj_focusout', 'crnt_yd_cd');
       	 axon_event.addListener('keyup', 'enterFire', 'crnt_loc_cd');
       	 axon_event.addListener('keyup', 'enterFire', 'crnt_yd_cd');
       	 axon_event.addListenerForm('keyup', 'obj_keyup', form);         
         
      	 // Multi Combo 초기화
      	 comboObjects[comboCnt++] = document.location;
       	 for(var k=0;k<comboObjects.length;k++){
   	         initCombo(comboObjects[k]);
  	     }  
         /*
       	 // Location MultiCombo 값 설정
      	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		 */
      	 doActionIBSheet(sheetObjects[0], document.form, IBRESET);
      	
         initControl();
       	 
         sheetObj.WaitImageVisible = true; 
     }
     
      /**
       * Form의 Conrol 를 초기화 시킨다. <br>
       * @param  없음
       * @return 없음
       * @author 조재성
       * @version 2009.07.29
       */
     function initControl(){
      	 var formObj = document.form;
      	 var sheetObj = sheetObjects[0];
      	 
      	 // Form Object 초기화
      	 with(formObj){
      		 crnt_loc_cd.value  = "USNYC"; // USNYC default 셋팅
      		 crnt_yd_cd.value   = "";
      		 vndr_seq.value		= "";
      		 agmt_no.value = "";
      		 include_np.checked = false;
      	 }
      	 
      	 // MultiCombo 초기화
      	 for(var i=0; i<comboObjects.length; i++){
      		 comboObjects[i].Text2 = "";
      	 }
      	 
      	 // Sheet Object 초기화
      	 sheetObj.RemoveAll();
      	     	 
    	 // 초기값 설정
    	 comboObjects[0].Index2 = 0;	// change event 를 발생시키지 않기 위해 Index2 를 사용
    	 sheetObj.cellValue(0,"crnt_loc_cd") = comboObjects[0].Text;
    	 
    	 formObj.crnt_loc_cd.focus(); //초기화시  focus는 location으로 가게 만든다.
    	 
     }
   /**
      * 시트 초기설정값, 헤더 정의 <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
      * @param  {object} sheetObj	필수	 Sheet Object
      * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
      * @return 없음
      * @author 조재성
      * @version 2009.07.29
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
				var sheetID = sheetObj.id;
        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 422;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);

                    var HeadTitle = "LCC|AGMT No.|Lessor|Total|SF2|SL2|TA2|SF4|GN4|CB4|EG5|GN5|EG8|ZT4";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData, 	70,  daCenter,	true,	"crnt_loc_cd",		false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData, 	80,  daCenter,	false,	"agmt_no",   		false,  "",	dfNone,     	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	85,  daCenter, false,  "vndr_seq",   		false,  "", dfNone,     	0,	false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,  80,  daRight, false,  "eq_tpsz_cd_total", false,  "", dfNullInteger,  0,	false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,	65,   daRight, false,  "eq_tpsz_cd_sf2",   false,  "", dfNullInteger,  0,	false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,  65,   daRight, false,  "eq_tpsz_cd_sl2",   false,  "", dfNullInteger,  0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtAutoSum,  65,   daRight, false,  "eq_tpsz_cd_ta2",   false,  "", dfNullInteger,  0,	false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,  65,   daRight, false,  "eq_tpsz_cd_sf4",   false,  "", dfNullInteger,  0,	false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,  65,   daRight, false,  "eq_tpsz_cd_gn4",   false,  "", dfNullInteger,  0,	false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,  65,   daRight, false,  "eq_tpsz_cd_cb4",  	false,  "", dfNullInteger,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,  65,   daRight, false,  "eq_tpsz_cd_eg5",   false,  "", dfNullInteger,  0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtAutoSum, 	65,   daRight, false,   "eq_tpsz_cd_gn5",   false,  "", dfNullInteger,  0,	false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,  65,   daRight, false,  "eq_tpsz_cd_eg8",   false,  "", dfNullInteger,  0,	false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,  65,   daRight, false,  "eq_tpsz_cd_zt4",  	false,  "", dfNullInteger,  0,	false,	true);

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
     * @author 조재성
     * @version 2009.07.29
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

	 		// 조회실행
	 		if(validateForm(sheetObj,formObj,sAction))
	 		{
		 		sheetObj.WaitImageVisible=false;
		 		ComOpenWait(true);
	 			
	 			var sXml = sheetObj.GetSearchXml("EES_CGM_1098GS.do" , FormQueryString(formObj));
	 			sheetObj.LoadSearchXml(sXml);

	 			ComOpenWait(false);
	 			
	 		}
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
		   		//formObj.crnt_loc_cd.focus();
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

	  		break;			
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
     * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
     * @author 조재성
     * @version 2009.07.29
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
   
	function sheet1_OnChangeSum(sheetObj, Row )
	{
		with(sheetObj)
		{
			SumText(0,"crnt_loc_cd") = "";
			SumText(0,"agmt_no") = "Grand Total";
			
			CellAlign(Row, "agmt_no") = daCenter;
		}
	} 
	
    /**
     * Sheet1 의 OnSearchEnd 이벤트처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {string} ErrMsg		필수 String
     * @return 없음
     * @version 2009.07.29
     */ 	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
 		sheetObj.ShowSubSum("crnt_loc_cd", "3|4|5|6|7|8|9|10|11|12|13",-1, false, false, -1,"crnt_loc_cd=;agmt_no=Sub Total");
	}

/**
 * Sheet1 의 OnMouseDown 이벤트처리 <br>
 * @param  {Integer} Button	필수 Integer
 * @param  {integer} Shift	필수 Integer
 * @param  {Integer} X	필수 Integer
 * @param  {integer} Y	필수 Integer
 * @return 없음
 * @author 조재성
 * @version 2009.09.24
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
  * @author 조재성
  * @version 2009.07.28
  */      
 function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
 	
 	var eqKndCd			= EQ_KND_CD_CHASSIS;
 	var location		= comboObjects[0].Code;
 	var crntLocCd		= document.form.crnt_loc_cd.value;
 	var crntYdCd		= document.form.crnt_yd_cd.value;

 	var includeNp		= "";
 	if(document.form.include_np.checked){
 		includeNp = "Y";
 	}
 	
 	var agmt_no = document.form.agmt_no.value;
 	var vndrSeq = document.form.vndr_seq.value;
 	
	var eqTpszCd = "";
	var colSaveName = sheetObj.ColSaveName(Col);
	if(colSaveName == 'eq_tpsz_cd_sf2') 		eqTpszCd = "SF2";
	else if(colSaveName == 'eq_tpsz_cd_sl2')	eqTpszCd = "SL2";
	else if(colSaveName == 'eq_tpsz_cd_ta2')	eqTpszCd = "TA2";
	else if(colSaveName == 'eq_tpsz_cd_sf4')	eqTpszCd = "SF4";
	else if(colSaveName == 'eq_tpsz_cd_gn4')	eqTpszCd = "GN4";
	else if(colSaveName == 'eq_tpsz_cd_cb4')	eqTpszCd = "CB4";
	else if(colSaveName == 'eq_tpsz_cd_eg5')	eqTpszCd = "EG5";
	else if(colSaveName == 'eq_tpsz_cd_eg8')	eqTpszCd = "EG8";
	else if(colSaveName == 'eq_tpsz_cd_gn5')	eqTpszCd = "GN5";
	else if(colSaveName == 'eq_tpsz_cd_zt4')	eqTpszCd = "ZT4";
	var groupValue1 = sheetObj.cellValue(Row, "crnt_loc_cd");
	var groupValue2 = sheetObj.cellValue(Row, "agmt_no");
	var groupValue3 = sheetObj.cellValue(Row, "vndr_seq");
    	
  	var s2_group1 = "";
  	var s2_groupValue1 = "";
  	
  	var s3_gtotal = "";
  	if(groupValue2.substring(0,9) == "Sub Total")
  	{
		s2_group1 = "SubSum";
  	    s2_groupValue1 = sheetObj.CellValue(Row-1, "crnt_loc_cd");
        groupValue1 = s2_groupValue1;
  	}else if(groupValue2 == "Grand Total"){
  		s3_gtotal = "GTOTAL";
  	}else{
  		s2_group1 = "";
  		s2_groupValue1 = "";
  	}

 	var param = "?program_id=1098";
 	param = param + "&eq_knd_cd=" + eqKndCd;
 	param = param + "&location=" + location;
 	param = param + "&crnt_loc_cd=" + crntLocCd;
 	param = param + "&crnt_yd_cd=" + crntYdCd;
	param = param + "&eq_tpsz_cd=" + eqTpszCd;     	
 	param = param + "&include_np=" + includeNp;
 	param = param + "&agmt_no=" + agmt_no;
 	param = param + "&vndr_seq=" + vndrSeq;
	param = param + "&group_value1=" + groupValue1;
	param = param + "&group_value2=" + groupValue2;
	param = param + "&group_value3=" + groupValue3;
	//param = param + "&s_group1=" + group1; 
  	//param = param + "&s_group1_val=" + groupValue1;
  	param = param + "&s2_group1=" + s2_group1;
  	param = param + "&s2_group1_val=" + s2_groupValue1;
  	param = param + "&s3_gtotal=" + s3_gtotal;

 	//var LCC = sheetObj.cellValue(Row, "crnt_loc_cd");
 	if(Col >= 3) // && LCC != '')
    {
    	ComOpenPopup('/hanjin/EES_CGM_1091.do' + param, 900, 550, "", "1,0", true, false);
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
	document.form.crnt_loc_cd.value = "";
	var sheetObj = sheetObjects[0];
	if(Text == "RCC")
	{
		sheetObj.cellValue2(0, "crnt_loc_cd") = "RCC";  
	}else if(Text == "LCC")
	{
		sheetObj.cellValue2(0, "crnt_loc_cd") = "LCC";
	}else if(Text == "SCC")
	{
		sheetObj.cellValue2(0, "crnt_loc_cd") = "Yard";
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
    * programNo 입력부분. <br>
    * 공통팝업 ServiceProvider에서 선택한 Lessor Seq를 Form Object 인 vndr_seq에 설정한다.
    * @param  {Array} aryPopupData	필수	 Array Object
    * @param  {Int} row				필수 선택한 Row
    * @param  {Int} col				필수 선택한 Column
    * @param  {Int} sheetIdx			필수 Sheet Index
    * @return 없음
    * @author 조재성
    * @version 2009.07.29
    */   
   function setAgmtNo(aryPopupData, row, col, sheetIdx){
   	 
  	 var formObj = document.form;
   	 var agmtNo = "";
   	 var i = 0;
   	 for(i = 0; i < aryPopupData.length; i++){
   		 agmtNo = agmtNo + aryPopupData[i][2];
   		 
   		 if(i < aryPopupData.length - 1){
   			 agmtNo = agmtNo + ",";
   		 }
   	 }
   	 
   	  formObj.agmt_no.value = agmtNo;
   	 
   	 
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
  	    	if(obj.name=="vndr_seq") 
  	    		ComKeyOnlyNumber(obj,",");
  	    	else 
  	    		ComKeyOnlyAlphabet();
   	        break;
   	    case "engup":
  	        if(obj.name=="crnt_loc_cd") ComKeyOnlyAlphabet('upper');//ComKeyOnlyAlphabet('uppernum');
  	        else if(obj.name=="crnt_yd_cd" || obj.name=="agmt_no") ComKeyOnlyAlphabet('uppernum',"44");
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
 * Object 의 obj_focusout 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 최민회
 * @version 2009.05.20
 */  
function obj_focusout(){
	 var formObj = document.form;
	 var sheetObj = sheetObjects[0];
	 obj = event.srcElement;
	 switch(obj.name){
	 	case "crnt_yd_cd":
	 		break;
	 }
}

 /** 
  * Combo Object 초기화  <br>
  * @param  {object} comboObj	필수 Combo Object
  * @return 없음
  * @author 조재성
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
  * @author 조재성
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
  * 기본조건 입력 후 ENTER키 적용 <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.08.14
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
	 	 		} 
	 	 		break;
    	 }
}   
	/* 개발자 작업  끝 */