/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_JOO_0083.js
*@FileTitle : Office Mapping Management
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.16
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.11.16 원종규
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
     * @class FNS_JOO_0083 : FNS_JOO_0083 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0083() {
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
    var comboObjects = new Array();
    var comboCnt = 0;
    var prefix = "sheet1_";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

        // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];

             /*******************************************************/
             var formObj = document.form;
             var doc = document.all;
            try {
                var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
                
                	case "btn_add":
                		var row = sheetObject.DataInsert(-1);
                		
            			//sheetObjects[0].CellValue2(row, prefix+"ibflag"   )  = "I";
            			//sheetObjects[0].CellValue2(row, prefix+"ofc_cd"   )  	= gUserOfcCd;
            			//sheetObjects[0].CellValue2(row, prefix+"ofc_cd_rhq"   )  = gUserRhqOfcCd
            			sheetObjects[0].CellValue2(row, prefix+"cre_dt" ) 		= gSysDate;
            			sheetObjects[0].CellValue2(row, prefix+"cre_usr_id" )  	= gUserId;
            			sheetObjects[0].CellValue2(row, prefix+"eff_dt"  ) 	 	= gSysDate; 
            			sheetObjects[0].CellValue2(row, prefix+"delt_flg"   )   = "N";
            			
                		sheetObject.SelectCell(sheetObject.SelectRow ,prefix+"ofc_cd");
            			break;
            			
					case "btn_insert":
						var row = sheetObject.DataInsert();
							
							//sheetObjects[0].CellValue2(row, prefix+"ofc_cd"   )  	= gUserOfcCd;
							//sheetObjects[0].CellValue2(row, prefix+"ofc_cd_rhq"   )  = gUserRhqOfcCd
	            			sheetObjects[0].CellValue2(row, prefix+"cre_dt" ) 		= gSysDate;
	            			sheetObjects[0].CellValue2(row, prefix+"cre_usr_id" )  	= gUserId;
	            			sheetObjects[0].CellValue2(row, prefix+"eff_dt"  ) 	 	= gSysDate;
	            			sheetObjects[0].CellValue2(row, prefix+"delt_flg"   )   = "N";
	            			
							sheetObject.SelectCell(sheetObject.SelectRow ,prefix+"ofc_cd"); 	
                		break;
                		
                	case "btn_delete":
            			JooRowHideDelete(sheetObject, prefix+"del_chk");
            			break;
                  
                    case "btn_Retrieve":
                        doActionIBSheet(sheetObjects[0],formObj, IBSEARCH);                        
                        break;
                        
            		case "btn_new":
            			sheetObjects[0].RemoveAll();
            			formObj.ofc_cd_rhq.Index2 = -1;
            			formObj.ofc_cd.value = "";            			
            			formObj.cng_ofc_rhq.Index2 = -1;
            			formObj.cng_ofc_cd.value = "";
            			formObj.delt_flg.value = "N";
            			formObj.ofc_cd_rhq.focus();
            			break;

                    case "btn_Save":
                        doActionIBSheet(sheetObjects[0],formObj, IBSAVE);
                        break;

                    case "btn_DownExcel":
                        //var paramObj = new Object();
                        //paramObj.cols = 10;
                        //var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);
                    	var url = "";

                        sheetObjects[0].SpeedDown2Excel(-1, false,false, "", url);           
                        break; 
                    
                    case "btn_pop_ofc_cd":
    		            	ComOpenPopup("/hanjin/COM_ENS_071.do", 750, 470, "ofc_cd_pop_event", "1,0,1", true);
                    	break;
                    	
                    case "btn_pop_cng_ofc_cd":
			            	ComOpenPopup("/hanjin/COM_ENS_071.do", 750, 470, "cng_ofc_cd_pop_event", "1,0,1", true);
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
         * Popup Data Validation Check. <br>
         **/
        function ofc_cd_pop_event(aryPopupData) {
        	document.form.ofc_cd.value = aryPopupData[0][3];
        }
         
	    function cng_ofc_cd_pop_event(aryPopupData) {
	        document.form.cng_ofc_cd.value = aryPopupData[0][3];
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
         /**
          * Combo 기본 설정
          * Combo의 항목을 설정한다.
          * @param comboObj 
          * @param comboIndex Number
          */
         function initCombo(comboObj, comboNo ) {
             var formObj = document.form
             switch(comboObj.id) {  
                 case "ofc_cd_rhq":  
                     with (comboObj) { 
                         MultiSelect = false; 
                         UseAutoComplete = true;    
                         SetColAlign("left");        
                         SetColWidth("60");
                         DropHeight = 160;
                         ValidChar(2,0);
                         MaxLength = 5;
                      }
	                    var comboItems = gOffList.split("|");
	             		addComboItem(comboObj, comboItems);
	             		//comboObj.Text2 = gUserRhqOfcCd;
	                    if (comboItems.length == 1){
	                     	comboObj.Enable = false;
	                    }else{
	                     	comboObj.Enable = true;
	                    }		
                      break; 
                  case "cng_ofc_rhq":
                      with (comboObj) { 
                          MultiSelect = false; 
                          UseAutoComplete = true;    
                          SetColAlign("left");
                          SetColWidth("60");
                          DropHeight = 160;
                          ValidChar(2,0);
                          MaxLength = 3;
                       }
                        var comboItems = gOffList.split("|"); 
	             		addComboItem(comboObj, comboItems);
	             		comboObj.Index2 = -1;
	                    if (comboItems.length == 1){
	                     	comboObj.Enable = false;
	                    }else{
	                     	comboObj.Enable = true;
	                    }
                       break;                       
              }               
         }

        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){
                // 시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );

                initSheet(sheetObjects[i],i+1);
                // 마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);                
            }
            // IBMultiCombo초기화
            for(var k=0; k<comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);                
            } 
            
            initControl();
        }
         
         function sheet1_OnLoadFinish(sheetObj) {
             var formObj = document.form;
             //alert("loadfinish	");
             //doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
         }
        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

            switch(sheetObj.id) {
                case "sheet1":      //t1sheet1 init
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 412;
                       
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 15, 100);

                        var HeadTitle1 = "STS|SEL|Login Office|Login RHQ|JOO Office|JOO RHQ|Creation Date|Created by|Eff. Date|Exp. Date|Remark|Del";
                        //var HeadTitle1 = "|Carrier\nCode|Trade|Lane|Service\nProvider|Customer\nCode|Service Provider/\nCustomer Name|Authority Office|Authority Code|DEL_MK";
                        
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,            WIDTH,      DATAALIGN,      COLMERGE,       SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtStatus,  		  0,          daCenter,       true,          prefix+"ibflag");
            			InitDataProperty(0, cnt++ , dtCheckBox    ,  30, 		  daCenter, 	  true, 		 prefix+"del_chk");
                        InitDataProperty(0, cnt++ , dtPopupEdit,    90,          daCenter,       true,          prefix+"ofc_cd",         	true,          "",       dfEngUpKey,     0,     false,       true,	6);
                        InitDataProperty(0, cnt++ , dtData,         90,          daCenter,       true,          prefix+"ofc_cd_rhq",       false,          "",       dfNone,      	 0,     false,       false);
                        InitDataProperty(0, cnt++ , dtPopupEdit,    90,          daCenter,       true,          prefix+"cng_ofc_cd",       true,           "",       dfEngUpKey,     0,     false,       true,	6);
                        InitDataProperty(0, cnt++ , dtData,         90,          daCenter,       true,          prefix+"cng_ofc_rhq",      false,          "",       dfNone,      	 0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,         90,          daCenter,       true,          prefix+"cre_dt",        	false,          "",      dfUserFormat2,  0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,        	90,      	  daCenter,       true,          prefix+"cre_usr_id",  		false,          "",      dfNone,      	 0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,   		100,          daCenter,       true,          prefix+"eff_dt",       	false,        	"",      dfDateYmd,  	0,      true, 	     true);
                        InitDataProperty(0, cnt++ , dtData,   		100,          daCenter,       true,          prefix+"exp_dt",     		false,			"",      dfDateYmd,  	0,      true,        true);
                        InitDataProperty(0, cnt++ , dtData,   		100,          daCenter,       true,          prefix+"ofc_cng_rmk",      false,         	"",      dfNone,      	 0,     true,        true,  500);
            			InitDataProperty(0, cnt++ , dtCombo,     	 20, 		  daCenter, 	  true, 		 prefix+"delt_flg",			false,         	"",      dfEngUpKey,   	 0,     false,       false, 1);
            			
            			InitDataCombo(0, prefix+"delt_flg"  , "Y|N", "Y|N");                        
                        InitUserFormat2(0, prefix+"cre_dt" , "####-##-##", "-");
                        //InitUserFormat2(0, prefix+"eff_dt" , "####-##-##", "-");
                        //InitUserFormat2(0, prefix+"exp_dt" , "####-##-##", "-");

                        InitDataValid(0, prefix+"ofc_cd", 	  vtEngUpOnly);
                        InitDataValid(0, prefix+"cng_ofc_cd", vtEngUpOnly);
                        //ShowButtonImage = 2;  //버튼항상표시
                	}
                    break;

            }
        }
         
         	function initControl() {
        		var formObject = document.form;
        		
        	    //Axon 이벤트 처리1. 이벤트 catch
        		axon_event.addListenerFormat('beforedeactivate', 'obj_blur' , formObject); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        		axon_event.addListenerFormat('beforeactivate',   'obj_focus', formObject);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        	    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObject);

        	    axon_event.addListener  ('keypress', 'ofc_cd_keypress' , 'ofc_cd');
        	    axon_event.addListener  ('keypress', 'cng_ofc_cd_keypress' , 'cng_ofc_cd');	
        	    axon_event.addListener  ('keypress', 'eff_dt_keypress' , 'eff_dt');		
        	    axon_event.addListener  ('keypress', 'exp_dt_keypress' , 'exp_dt');	 
        	    
        	    axon_event.addListener  ('change'  , 'ofc_cd_OnChange', 	'ofc_cd');
        	    axon_event.addListener  ('change'  , 'cng_ofc_cd_OnChange', 'cng_ofc_cd');
        	    
        	    formObject.ofc_cd_rhq.focus();        	    
        	}

        	//Axon 이벤트 처리2. 이벤트처리함수
        	function obj_blur(){
        	    //ComChkObjValid(event.srcElement);
        	}

        	function obj_focus(){
        	    //ComClearSeparator(event.srcElement);
        	}
        	
        	//ofc_cd 에는 영문 대문자만 입력가능
        	function ofc_cd_keypress() {
        	    ComKeyOnlyAlphabet('upper');
        	}
        	
        	function cng_ofc_cd_keypress() {
        	    ComKeyOnlyAlphabet('upper');
        	} 
        	
        	//check ofc_cd validation
        	function ofc_cd_OnChange() {        		        		
	        		var formObj = document.form;
	        		var sheetObj = sheetObjects[0];
	        		formObj.f_cmd.value = SEARCH11;
	                var code  = formObj.ofc_cd.value;
	                var param =  FormQueryString(formObj)+"&code="+code;
                
	                var sXml  =  sheetObj.GetSearchXml("FNS_JOO_0083GS.do", param);
	                 
	                 if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
		                    var arHqOfcCd = ComGetEtcData(sXml, "arHqOfcCd");
			                     if(arHqOfcCd == "" ){
			                         ComShowCodeMessage("JOO00117", "Office Code");
			                         formObj.ofc_cd.value = "";
			                         ComSetFocus(formObj.ofc_cd);			                         
			                     }else {
			                    	 ComSetFocus(formObj.cng_ofc_rhq);
			                     } 
	                 }
        	}        	
        	//check cng_ofc_cd validation
        	function cng_ofc_cd_OnChange() {        		        		
	        		var formObj = document.form;
	        		var sheetObj = sheetObjects[0];
	        		formObj.f_cmd.value = SEARCH11;
	                var code  = formObj.cng_ofc_cd.value;
	                var param =  FormQueryString(formObj)+"&code="+code;
              
	                var sXml  =  sheetObj.GetSearchXml("FNS_JOO_0083GS.do", param);
	                 
	                 if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
		                    var arHqOfcCd = ComGetEtcData(sXml, "arHqOfcCd");
			                     if(arHqOfcCd == "" ){
			                         ComShowCodeMessage("JOO00117", "Office Code");
			                         formObj.cng_ofc_cd.value = "";
			                         ComSetFocus(formObj.cng_ofc_cd);                             
			                     }else {} 
	                 }
        	}

        	function eff_dt_keypress(){
        		//ComKeyOnlyNumber(sheetObjects[0].eff_dt);        	    
        	}

        	function exp_dt_keypress(){
        	    //ComKeyOnlyNumber(document.form.slp_iss_dt);
        	}
        	

        // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction, cRow, Col) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
          
                case    IBCLEAR:      //초기 
                        /*formObj.f_cmd.value = SEARCH01;            
                        var param  =  FormQueryString(formObj)+"&auth_delcheck_yn=N"; //auth_delcheck_yn
                        var sXml   =  sheetObj.GetSearchXml("FNS_JOO_0079GS.do", param);
                        var aXml   = sXml.split("|$$|");
                        ComXml2ComboItem( aXml[0], formObj.jo_crr_cd   , "code","code" );
                        ComXml2ComboItem( aXml[1], formObj.auth_ofc_cd , "code","code" );
                        */
                        break;                     
                         
                case    IBSEARCH:      //조회
                        formObj.f_cmd.value = SEARCH;    
                        if(!validateForm(sheetObj,formObj,sAction)){return;}
                        var param =  FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                        var sXml = sheetObj.GetSearchXml("FNS_JOO_0083GS.do", param);
                        sheetObj.LoadSearchXml(sXml);
    
                        break;

                case    IBSAVE:        //저장
                        if(!validateForm(sheetObj,formObj,sAction)){ return;}
             
                        sheetObj.WaitImageVisible=false;
                        ComOpenWait(true);
                        formObj.f_cmd.value = MULTI;
                        try{                        	
	                        var sXml =   sheetObj.GetSaveXml("FNS_JOO_0083GS.do", ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );
	                        if (ComGetEtcData(sXml,"iRtn") != undefined && ComGetEtcData(sXml,"iRtn") != ""){
	                        	ComOpenWait(false);
	                        	ComShowMessage("Duplicated Error!!! \n\n" + ComGetEtcData(sXml,"iRtn"));
	                        }else{
	                        	sheetObj.LoadSaveXml( sXml );
	                        }
                        }finally{
                        	ComOpenWait(false);
                        }
                        break;

                case    IBINSERT:      // 입력
                
                        break;
                
                case    IBSEARCH_ASYNC01:      // THE RHQ BY THE OFC 
		                formObj.f_cmd.value = SEARCH11;            
		                var code   = sheetObjects[0].CellValue( cRow, Col);		                
		                var param =  FormQueryString(formObj)+"&code="+code;	                
		                
	                    var sXml  =  sheetObj.GetSearchXml("FNS_JOO_0083GS.do", param);
	                     
	                     if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
	 	                    var arHqOfcCd = ComGetEtcData(sXml, "arHqOfcCd");
	 	                    
	 	                   if(sheetObj.ColSaveName(Col) == prefix+'ofc_cd'){
	                         if(arHqOfcCd == "" ){
	                             ComShowCodeMessage("JOO00117", "RHQ by OFFICE");
	                             sheetObjects[0].CellValue2( cRow, Col) = sheetObjects[0].CellSearchValue(cRow, Col); 
	                             sheetObjects[0].CellValue2( cRow, prefix+"ofc_cd_rhq") = sheetObjects[0].CellSearchValue(cRow, prefix+"ofc_cd_rhq");
	                             sheetObjects[0].SelectCell( cRow, Col);	                             
	                         }
	                         else {	                        	
	                        	 sheetObjects[0].CellValue2( cRow, prefix+"ofc_cd_rhq") = arHqOfcCd;
	                        	 sheetObjects[0].SelectCell( cRow, Col);	                        	 
	                         }
	                         
	 	                   }else if(sheetObj.ColSaveName(Col) == prefix+'cng_ofc_cd'){
	                    	   if(arHqOfcCd == "" ){
		                             ComShowCodeMessage("JOO00117", "RHQ by OFFICE");
		                             sheetObjects[0].CellValue2( cRow, Col) = sheetObjects[0].CellSearchValue(cRow, Col); 
		                             sheetObjects[0].CellValue2( cRow, prefix+"cng_ofc_rhq") = sheetObjects[0].CellSearchValue(cRow, prefix+"cng_ofc_rhq");
		                             sheetObjects[0].SelectCell( cRow, Col);	                             
		                         }
		                         else {		                        	 
		                        	 sheetObjects[0].CellValue2( cRow, prefix+"cng_ofc_rhq") = arHqOfcCd;
		                        	 sheetObjects[0].SelectCell( cRow, Col);	                        	 
		                         }                  	   
 	                       }
	                     }             
            }
         
        }
       
        function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        	for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
        		if (sheetObj.CellValue(i, prefix+"delt_flg") == "Y"){   
        			sheetObj.CellEditable(i,prefix+"del_chk") = false;
        			sheetObj.CellEditable(i,prefix+"eff_dt") = false;
        			sheetObj.CellEditable(i,prefix+"exp_dt") = false;
        			sheetObj.CellEditable(i,prefix+"ofc_cng_rmk") = false;
        			sheetObj.CellEditable(i,prefix+"delt_flg") = true;       			
        		}
        	}
//        	var deltFlg = document.form.delt_flg.value;
//            UF_afterRetrieve(deltFlg);
        	
//            var doc = document.all;        	
//            if(sheetObj.RowCount > 0){
//                //doc.btn_delete.className = "btn2";
//                doc.btn_copy.className   = "btn2"; 
//            }
        }
        
        function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
//            var doc = document.all;
//
//            if(sheetObj.RowStatus(NewRow) == "I" || sheetObj.RowStatus(NewRow) == "U"){
//                 doc.btn_delete.className = "btn2";
//            }else{
//                 doc.btn_delete.className = "btn2_1";
//            }
        }
        function sheet1_OnChange(sheetObj, Row, Col, Value) {
            var formObj = document.form;
            switch(sheetObj.ColSaveName(Col)) {	               
            	case prefix+"ofc_cd":
            		
                	   var ofcCd = Value;
                	   var dupCheck = "N";

                	   for(var i=sheetObj.HeaderRows; i<= sheetObj.LastRow; i++){
                		   if (i == Row || sheetObj.CellValue(i, prefix+"delt_flg") == "Y") continue;
                		   if (ofcCd == sheetObj.CellValue(i, Col)){
                			   dupCheck = "Y";
	                		   ComShowMessage("Duplicated Error!!!");
                			   sheetObj.CellValue2( Row, Col) = "";
                			   sheetObj.SelectCell( Row, Col);	                			   
	                		   break;
                		   }	                		   
                	   }

                	   if(dupCheck == "N"){
                		   doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC01, Row, Col);
                	   }
                       break;
                       
            	case prefix+"cng_ofc_cd":
            		doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC01, Row, Col);	                       
                 break;    
            }
        }
    
        
        function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
            var formObj = document.form;
    
//            if( KeyCode == 229){return;}
//            if(sheetObj.ColSaveName (Col) == "auth_ofc_cd" ){ 
//                 if( sheetObj.EditValue.length == 6){
//                     sheetObj.CellValue2(Row, "auth_ofc_cd")  = sheetObj.EditValue;
//                     doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC04, Row);
//                 }
//            }
        }
        
        /**
         * Sheet1 OnPopupClick 이벤트 처리  
         * @param sheetObj
         * @param Row
         * @param Col
         * @return
         */
        function sheet1_OnPopupClick(sheetObj, Row, Col)
        {
            with(sheetObj)
            {
                if( sheetObj.ColSaveName(Col) ==  prefix+'ofc_cd' ){
                    ComOpenPopup('/hanjin/COM_ENS_071.do',  770, 480, "PopupCallback_OffCd", "1,0,0", true, false, Row, Col, 0);
                }
                else if( sheetObj.ColSaveName(Col) ==  prefix+'cng_ofc_cd' ){
                	ComOpenPopup('/hanjin/COM_ENS_071.do',  770, 480, "PopupCallback_OffCd", "1,0,0", true, false, Row, Col, 0);                	
                }
            }
        }  
        function PopupCallback_OffCd(aryPopupData,row, col, seetIdx){ 
        		var formObj = document.form;
        		sheetObjects[seetIdx].CellValue2(row, col) = aryPopupData[0][3];        		
        		doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC01, row, col);
        }
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
                switch(sAction) { 
                    case IBSAVE:
                        var sParam     =  ComGetSaveString(sheetObj );
                        if( sParam == ""){
                            return false;
                        }
                        
                       /* var Row = sheetObj.ColValueDup(prefix+"ofc_cd", false); 
                        if( Row > -1 ){
                            ComShowCodeMessage("JOO00161");
                            sheetObj.SelectCell(Row, prefix+"ofc_cd");
                            return false;
                        }*/
	                        
                        if( !ComShowCodeConfirm("JOO00046") ){
                            return false;
                        }
                        break; 
                } // end switch
            }
            return true;
        }

		/**
		* Reset 
		* @param deltFlg
		* @return
		*/
		function UF_afterRetrieve(deltFlg){			
			if (deltFlg == undefined || deltFlg == null){
				deltFlg = "";
			}
				switch(deltFlg) {			
					case "Y":
						ComBtnDisable("btn_delete");
						break;
					case "N":
						ComBtnEnable("btn_delete");
						break;
					case "A":
						ComBtnDisable("btn_delete");
						break;
				}
		}
 
	/* 개발자 작업  끝 */