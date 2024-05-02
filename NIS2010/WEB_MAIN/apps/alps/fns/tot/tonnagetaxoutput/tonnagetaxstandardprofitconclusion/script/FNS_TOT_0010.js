/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0010.js
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.21 장창수
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
     * @class fns_tot_010 : fns_tot_010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_tot_0010() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setComboObject			= setComboObject;
    }
    
   	/* 개발자 작업	*/



	 // 공통전역변수
	
	 var sheetObjects = new Array();
	 var sheetCnt = 0;
	 var comboObjects = new Array();
	 var comboCnt = 0;
	 var trdBylaneCmbList = "";
	 var laneCmb = "";
	 var trdCmbList = "";
	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick = processButtonClick;

     // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		 var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

         try {
             var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
              	
 							case "btn1_Retrieve":
 								doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 							break;
 							
 							case "btn1_New":
 	       				 		setDate();
 	       				 	    formObject.slan_cd.Code = "";
 	       				 		sheetObject1.RemoveAll();
 							break;
 							
 							case "btn1_Down_Excel":
 								sheetObject1.SpeedDown2Excel(-1);
 							break;
 							
 		    				case "btns_back":
                                 
                                     if(formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == ""){
                                	     ComShowCodeMessage('TOT00007');
                                	     ComSetFocus(formObject.stl_yrmon);
                                    	
                                    	 return false;
                                     } 
 			   	                     formObject.stl_yrmon.value = ComGetDateAdd(formObject.stl_yrmon.value+"-01","M",-1).substring(0,7);
 			   	                     setTrdCombo();
 		   					break;

 		    				case "btns_next":

                                    if(formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == ""){
                                    	ComShowCodeMessage('TOT00007');
                               	     ComSetFocus(formObject.stl_yrmon);
                                   	
                                   	 return false;
                                    } 
	 			   	                 formObject.stl_yrmon.value = ComGetDateAdd(formObject.stl_yrmon.value+"-01","M", 1).substring(0,7);
	 			   	                 setTrdCombo();
	 			   	        break;
 		   					
 		    				case "btns_back2":

 		    			             if(formObject.e_stl_yrmon.value == null || formObject.e_stl_yrmon.value == ""){
 		    			            	ComShowCodeMessage('TOT00008');
 		    			        	     ComSetFocus(formObject.e_stl_yrmon);
 		    			            	
 		    			            	 return false;
 		    			             }
	 			   	                 formObject.e_stl_yrmon.value = ComGetDateAdd(formObject.e_stl_yrmon.value+"-01","M",-1).substring(0,7);
	 			   	                 setTrdCombo();
	 			   	        break;

 		   				    case "btns_next2":
                              
                                     if(formObject.e_stl_yrmon.value == null || formObject.e_stl_yrmon.value == ""){
                                    	 ComShowCodeMessage('TOT00008');
                              	       ComSetFocus(formObject.e_stl_yrmon);
                                  	
                                  	   return false;
                                     }
	 			   	                 formObject.e_stl_yrmon.value = ComGetDateAdd(formObject.e_stl_yrmon.value+"-01","M", 1).substring(0,7);
	 			   	                 setTrdCombo();
	 			   	        break;
							case "btn1_pop_vsl":

			                     ComOpenPopup("/hanjin/COM_ENS_0A1.do", 618, 480, "getCOM_ENS_0A1_1", "1,0,1,1,1");
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
     function loadPage(trdCmb) {

         //IBSheet 초기화하기
         for(i=0;i<sheetObjects.length;i++){

             //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

         initControl();
         setDate();
         
         initCombo(comboObjects[0],1,trdCmb);
  

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
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
    function initControl() {
   	  
     	//** Date 구분자 **/
     	DATE_SEPARATOR = "-";
     	var formObject = document.form;
     	
        //Axon 이벤트 처리1. 이벤트catch
     	
   	  	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
   	  	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerFormat('keypress','obj_keypress', formObject);   
        axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  formObject);    
    	axon_event.addListener  ('blur'  , 'stl_yrmon_onblur', 'stl_yrmon');//- customer code 입력 후 name 가져오기
    	axon_event.addListener  ('blur'  , 'e_stl_yrmon_onblur', 'e_stl_yrmon');//- customer code 입력 후 name 가져오기
        axon_event.addListener  ('keyup', 'vsl_cd_keyup', 'vsl_cd');	

     }
 
    /**
      * Combo 기본 설정 
      * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
      * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
      */ 
    function initCombo(comboObj, comboNo, cmbList) {
         var formObject = document.form

         switch(comboNo) {  
         	case 1: 
                with (comboObj) { 
     				MultiSelect = false; 
     				UseAutoComplete = false;	
     				SetColAlign("left|left");        
     				SetColWidth("0|30");
					
      				DropHeight = 160;
      		   }
                  comboObj.RemoveAll(); 
                  var comboItemsValue = cmbList.split("|");
                   
                  comboObj.InsertItem(0, "" + "|" + "", "ALL");
                  for (var i = 0; i<comboItemsValue.length; i++){
	                
	                  comboObj.InsertItem(i+1, comboItemsValue[i] + "|" + comboItemsValue[i], comboItemsValue[i]);
                  }
                 
                  comboObj.index = 0;
      	break; 
      			
         	case 2: 
                 with (comboObj) { 
      				MultiSelect = false; 
      				UseAutoComplete = false;	
      				SetColAlign("left|left");        
      				SetColWidth("0|30");
				
       				DropHeight = 160;
       		    }
                 comboObj.RemoveAll(); 
                 var comboItemsValue = cmbList.split("|");
                  
                 comboObj.InsertItem(0, "" + "|" + "", "ALL");
                 for (var i = 0; i<comboItemsValue.length; i++){
	                
	                  comboObj.InsertItem(i+1, comboItemsValue[i] + "|" + comboItemsValue[i], comboItemsValue[i]);
                 }
                
                 comboObj.index = 0;                
       	break;

      	} 
    }

    /**
      * 콤보필드에 데이터를 추가해준다.
      */	
    function addComboItem(comboObj, i, comboItemsValue, comboItemsText) {
     
     		//alert("addComboItem ::::: "+i+"번째  "+comboItemsValue+"        "+comboItemsText);

     		comboObj.InsertItem(i, comboItemsText + "|" + comboItemsText, comboItemsValue);
     		
    }

    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate(){
          ComChkObjValid(event.srcElement);
    }

    function obj_activate(){
          ComClearSeparator(event.srcElement);
    }

	function obj_keypress(){
		switch(event.srcElement.dataformat){
		    case "ym":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, "-"); 
		    break;
		    case "engup":
		        
		         ComKeyOnlyAlphabet('upper');
		    break;			    
           
		}
	  }   	  
	  
	function form_keyup(){
			ComKeyEnter('lengthnextfocus');
	}  
    
	function getCOM_ENS_0A1_1(rowArray) {
    	 
         var colArray = rowArray[0];
         document.all.vsl_cd.value = colArray[3];
    }	  
    
	function vsl_cd_keyup(){
      	//ComKeyOnlyAlphabet('upper');
  	    var formObject = document.form;

  	    if (formObject.vsl_cd.value.length == 4){
  	    	setVslYn();
  	    	sheetObjects[0].RemoveAll();
  		}
  	   
  	}	  
    
	/*
       * 팝업으로 선박코드 입력시 해당 선박코드의 유무조회한다.  <br>
       */
       
    function setVslYn(){
      	 
      	 var formObj = document.form;
      	 var prefix = "sheet1_";
      	 formObj.f_cmd.value = SEARCHLIST01;
      	 
      	 //alert(formObj.vsl_cd.value);
      	 var sXml = sheetObjects[1].GetSearchXml("TOTCommonGS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

      	 
      	 if(ComGetEtcData(sXml,"vslEngNm") == ""){
  				 ComShowCodeMessage('TOT00012');
  				 //formObject.vsl_cd.value = "";
  				 ComSetFocus(formObj.vsl_cd);
  				 return;
      	 }
    
    }       
    
    //stl_yr 변경시 조회 
    function stl_yrmon_onblur(){
     	//alert("stl_yrmon_onblur");
     	var formObject = document.form;
     	//validationPeriod(formObject,"S","i"); 
        if(formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == ""){
        	ComShowCodeMessage('TOT00007');
   	        ComSetFocus(formObject.stl_yrmon);
       	
       	 return false;
        }
        setTrdCombo();
    }       
    
    //stl_yr 변경시 조회 
    function e_stl_yrmon_onblur(){
     	//alert("e_stl_yrmon_onblur");
     	var formObject = document.form;
     	//validationPeriod(formObject,"E","i"); 
        if(formObject.e_stl_yrmon.value == null || formObject.e_stl_yrmon.value == ""){
        	ComShowCodeMessage('TOT00008');
   	     ComSetFocus(formObject.e_stl_yrmon);
   	 
       	 return false;
        }
        
        setTrdCombo();
    }       

    //slan_cd 변경시 조회 
    function slan_cd_OnChange(idx_cd, text){
     	//alert("slan_cd_OnChange");
     	
     	//setTrdCombo(text);
      	sheetObjects[0].RemoveAll(); 

    }

    //trd_cd 변경시 조회 
    function trd_cd_OnChange(idx_cd, text){
     	//alert("trd_cd_OnChange");
     	
      	sheetObjects[0].RemoveAll(); 
      	setLaneCombo();
    }
     
    function setDate(){
     	var today=new Date();
     	var y = today.getFullYear().toString();
     	var m = today.getMonth()+1;
     		
     	if(m<10){
     		m = "0"+m;
     	}
     	document.form.stl_yrmon.value = y+"-01";    	
     	document.form.e_stl_yrmon.value = y+"-"+m;	
    }

    function setLaneCombo(){
    	
 		var formObj = document.form;
 		var sheetObj = sheetObjects[1];
 		
 		
 		formObj.f_cmd.value = SEARCH02;
		var prefix = "sheet2_";	//prefix 문자열 배열
		
		var sXml = sheetObj.GetSearchXml("FNS_TOT_0010GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		
		sheetObj.LoadSearchXml(sXml);
        var laneCmb  = ComGetEtcData(sXml,"laneCmb"); 
        
        initCombo(comboObjects[1],2,laneCmb);
	}
    
    function setTrdCombo(){
    	
 		var formObj = document.form;
 		var sheetObj = sheetObjects[1];
 		
 		
 		formObj.f_cmd.value = SEARCH01;
		var prefix = "sheet2_";	//prefix 문자열 배열
		
		var sXml = sheetObj.GetSearchXml("FNS_TOT_0010GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		
		sheetObj.LoadSearchXml(sXml);
        var trdCmb  = ComGetEtcData(sXml,"trdCmb"); 
        
        initCombo(comboObjects[0],1,trdCmb);
	}
    
/* 	function setTrdCombo(text){
 		var formObject = document.form;
		comboObjects[1].RemoveAll();

        var comboLaneTrdValue = trdBylaneCmbList.split("|");
        var j =1;
        
        if(text == "ALL" || text == "-1" ){
        	
           var comboSeperate = trdCmbList.split("|");
           
           comboObjects[1].InsertItem(0, "" + "|" + "", "ALL");
	       for (var i = 0; i<comboSeperate.length; i++){
	    	
	    	   comboObjects[1].InsertItem(i+1, comboSeperate[i] + "|" + comboSeperate[i], comboSeperate[i]);
		   }
	       
	        comboObjects[1].index = 0;
       	
        }else{        
        	comboObjects[1].InsertItem(0, "" + "|" + "", "ALL");
	        for (var i = 0; i<comboLaneTrdValue.length; i++){
	     	  
	     	   var comboSeperate = comboLaneTrdValue[i].split(",");
	     	  
	     	   if(text == comboSeperate[0]){
	     		 comboObjects[1].InsertItem(j, comboSeperate[1] + "|" + comboSeperate[1], comboSeperate[1]);
			       
	              j++; 
	     	   }
	        }
       
            comboObjects[1].index = 0;
            
            if(j==1){
               
            	ComShowCodeMessage('TOT00045');
         	   formObject.slan_cd.CODE = "ALL";
         	   return;
            }
        }    

	}*/
     
    /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      // t1sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 412;
                     
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     var HeadTitle1 = "|Seq.|Trade|Lane|Vessel\nVoyage|Month|NRT|ITC|Declared\nCAPA|BSA||";
                    
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)
                      

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     
                     var prefix = "sheet1_";
                     
                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtHiddenStatus,  0,			daCenter,	true,	"Status");
                     InitDataProperty(0, cnt++, dtSeq,				60,			daCenter,	true,	"SEQ",				false,		"",       dfNone,	0,	false,	false);
                     InitDataProperty(0, cnt++, dtData,			100,			daCenter,	true,	prefix+"trd_cd",			false,		"",       dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			100,			daCenter,	true,	prefix+"slan_cd",				false,		"",       dfNone,	0,	false,	false);
					
					InitDataProperty(0, cnt++, dtData,			140,		daCenter,	true,	prefix+"vvd",			false,		"",       dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			100,			daCenter,	true,	prefix+"stl_yrmon",			false,		"",       dfDateYm,	0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			120,			daRight,	true,	prefix+"net_rgst_tong_wgt",				false,		"",       dfNullInteger,	0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			80,			daCenter,	true,	prefix+"intl_tong_certi_flg",				false,		"",       dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			120,			daRight,	true,	prefix+"ldb_capa_qty",		false,		"",       dfNullInteger,	0,	false,	false);
					
					InitDataProperty(0, cnt++, dtData,			120,			daRight,	true,	prefix+"fnl_hjs_bsa_capa",		false,		"",       dfNullInteger,	0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			0,			daRight,	true,	prefix+"crr_bsa_capa",	false,		"",       dfNullInteger,	0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			0,			daRight,	true,	prefix+"tong_bsa_capa",	false,		"",       dfNullInteger,	0,	false,	false);
					  }
                 break;
             case 2:      // t1sheet2 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 0;
                 
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 10, 100);

                 var HeadTitle1 = "Lane|Trade";
                
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)
                  

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 
                 var prefix = "sheet2_";
                 
                 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtData,			100,			daCenter,	true,	prefix+"slan_cd",				false,		"",       dfNone,	0,	false,	false);
                 InitDataProperty(0, cnt++, dtData,			100,			daCenter,	true,	prefix+"trd_cd",			false,		"",       dfNone,	0,	false,	false);
			  }
             break;                 
         }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
             case IBSEARCH:      //조회
	             if (validateForm(sheetObj, formObj, sAction)){
		             	
	                 if ( sheetObj.id == "sheet1"){
	     				 formObj.f_cmd.value = SEARCH;
	     				 var prefix = "sheet1_";	//prefix 문자열 배열
	
		    			var sXml = sheetObj.GetSearchXml("FNS_TOT_0010GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
	
		    			sheetObjects[0].LoadSearchXml(sXml);

	                 }
	                 
	             }

                 break;

         }
    }

     /*
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
    		sheetObj.ShowDebugMsg = false;
    		var formObject = document.form;
    		var prefix="sheet1_";
    		switch (sAction) {

			
			   case IBSEARCH: //조회

					if (formObject.slan_cd.Code ==null || formObject.slan_cd.Code ==""){
						ComShowCodeMessage('TOT00005');
						ComSetFocus(formObject.slan_cd);
						return false;
					}
				    if (formObject.trd_cd.Code ==null || formObject.trd_cd.Code ==""){
				    	ComShowCodeMessage('TOT00006');
					    ComSetFocus(formObject.trd_cd);
					    return false;
				    }
			   
					if (formObject.stl_yrmon.value ==null || formObject.stl_yrmon.value ==""){
						ComShowCodeMessage('TOT00001');
						ComSetFocus(formObject.stl_yrmon);
						return false;
					}

					if (formObject.e_stl_yrmon.value ==null || formObject.e_stl_yrmon.value ==""){
						ComShowCodeMessage('TOT00001');
						ComSetFocus(formObject.e_stl_yrmon);
						return false;
					}
	        		if (formObject.stl_yrmon.value < ComGetDateAdd(formObject.e_stl_yrmon.value+"-01","M", -12).substring(0,7)){
	        			ComShowCodeMessage('TOT00042');
							//formObject.stl_yrmon.value = "";
							ComSetFocus(formObject.e_stl_yrmon);
							
							return false;
					} 

				break;
				
    			default:
    				break;
    		}
    		return true;

    }


	/* 개발자 작업  끝 */