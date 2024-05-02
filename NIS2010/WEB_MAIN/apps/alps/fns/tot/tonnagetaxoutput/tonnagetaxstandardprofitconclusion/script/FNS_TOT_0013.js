/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0013.js
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.19 장창수
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
     * @class fns_tot_013 : fns_tot_013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_tot_0013() {
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


    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var closing_dt = "";
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
 							case "btn1_Detail":
 								 openPopup();

 							break; 							
 							case "btn1_New":
 			 					setDate();
 			 					formObject.vsl_cd.value = "";
 			 	    			sheetObjects[0].RemoveAll();

 							break;
 							
 		    				case "btns_back":

 			   	                 if(formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == ""){
 			   	                	 ComShowCodeMessage('TOT00003');
 			   	                	 return;
 			   	                 }
 			   	                 formObject.stl_yrmon.value = ComGetDateAdd(formObject.stl_yrmon.value+"-01","M",-1).substring(0,7);

 		   					break;

 		    				case "btns_next":
 		   					
 			   	                 if(formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == ""){
 			   	                	 ComShowCodeMessage('TOT00003');
 			   	                	 return;
 			   	                 }
 			   	                 formObject.stl_yrmon.value = ComGetDateAdd(formObject.stl_yrmon.value+"-01","M", 1).substring(0,7);
 		   	                 
 		   					break;
 		   					
 		    				case "btns_back2":

 			   	                 if(formObject.e_stl_yrmon.value == null || formObject.e_stl_yrmon.value == ""){
 			   	                	 ComShowCodeMessage('TOT00003');
 			   	                	 return;
 			   	                 }
 			   	                 formObject.e_stl_yrmon.value = ComGetDateAdd(formObject.e_stl_yrmon.value+"-01","M",-1).substring(0,7);

 		  					break;

 		   				    case "btns_next2":
 		  					
 			   	                 if(formObject.e_stl_yrmon.value == null || formObject.e_stl_yrmon.value == ""){
 			   	                	 ComShowCodeMessage('TOT00003');
 			   	                	 return;
 			   	                 }
 			   	                 formObject.e_stl_yrmon.value = ComGetDateAdd(formObject.e_stl_yrmon.value+"-01","M", 1).substring(0,7);
 		  	                 
 		  					break;
							case "btn1_pop_vsl":

			                     ComOpenPopup("/hanjin/COM_ENS_0A1.do", 618, 480, "getCOM_ENS_0A1_1", "1,0,1,1,1");
							break;
							case "btn1_Down_Excel":
				                 
								sheetObject1.SpeedDown2Excel(-1);
 							
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

    function getCOM_ENS_0A1_1(rowArray) {
 
        var colArray = rowArray[0];
        document.all.vsl_cd.value = colArray[3];
    }
     
    /** 
      * Summary Preview 버튼 클릭시 팝업호출
      */
    function openPopup() {
     //alert("openPopup START  : " + sheetObjects[0].SelectRow);
    	if(sheetObjects[0].SelectRow == -1){
    		ComShowCodeMessage('TOT00035');
    		return;
    	}
     	var formObject = document.form;

     	var stl_yrmon = sheetObjects[0].CellValue(sheetObjects[0].SelectRow ,"sheet1_stl_yrmon");
     	stl_yrmon = stl_yrmon.substring(0,4)+"-"+stl_yrmon.substring(4,6);
     	//alert(stl_yrmon);
     	var trd_cd = "ALL";
   	    var vsl_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow ,"sheet1_vsl_cd");    

     	var param = "?stl_yrmon="+stl_yrmon+"&trd_cd="+trd_cd+"&vsl_cd="+vsl_cd+"&modify_yn=N";

      	ComOpenPopup('/hanjin/FNS_TOT_0012.do'+param, 1200, 450, 'getVVD', '1,0,1,1,1,1,1,1');

    }
  

    /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
    function loadPage(e_stl_yrmon) {

         //IBSheet 초기화하기
         for(i=0;i<sheetObjects.length;i++){

             //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

         closing_dt = e_stl_yrmon;
         initControl();
       

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
        	axon_event.addListener  ('blur'  , 'stl_yrmon_onblur', 'stl_yrmon');//- customer code 입력 후 name 가져오기
            axon_event.addListener  ('blur'  , 'e_stl_yrmon_onblur', 'e_stl_yrmon');//- customer code 입력 후 name 가져오기
            axon_event.addListener  ('keyup', 'vsl_cd_keyup', 'vsl_cd');	
            axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  formObject);    

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
    
    function vsl_cd_keyup(){
        	//ComKeyOnlyAlphabet('upper');
    	    var formObject = document.form;

    	    if (formObject.vsl_cd.value.length == 4){
    	    	setVslYn();
    		}
    }

    //stl_yr 변경시 조회 
    function stl_yrmon_onblur(){
         	//alert("stl_yrmon_onblur");
         	var formObject = document.form;
            
    		if (formObject.stl_yrmon.value ==null || formObject.stl_yrmon.value ==""){
    			
    			ComShowCodeMessage('TOT00007');
    			ComSetFocus(formObject.stl_yrmon);
    			
    			return false;
    		}
                 
    }       
    
    //stl_yr 변경시 조회 
    function e_stl_yrmon_onblur(){
     	//alert("e_stl_yrmon_onblur");
     	var formObject = document.form;

		if (formObject.e_stl_yrmon.value ==null || formObject.e_stl_yrmon.value ==""){
			
			ComShowCodeMessage('TOT00008');
			ComSetFocus(formObject.e_stl_yrmon);
			
			return false;
		}
    }       

    function setDate(){
      	document.form.stl_yrmon.value = closing_dt.substring(0,4)+"-01";    	
      	document.form.e_stl_yrmon.value = closing_dt;	
    }
 
    /*
     * 팝업으로 선박코드 입력시 해당 선박코드의 유무조회한다.  <br>
     */
      
    function setVslYn(){
     	 
     	 var formObj = document.form;
     	 var prefix = "sheet1_";
     	 formObj.f_cmd.value = SEARCHLIST01;
     	 
     	 //alert(formObj.vsl_cd.value);
     	 var sXml = sheetObjects[0].GetSearchXml("TOTCommonGS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

     	 
     	 if(ComGetEtcData(sXml,"vslEngNm") == ""){
 				 ComShowCodeMessage('TOT00012');
 				 //formObject.vsl_cd.value = "";
 				 ComSetFocus(formObj.vsl_cd);
 				 return;
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
	           case 1:      // t1sheet1 init
	               with (sheetObj) {
	                   // 높이 설정
	                   style.height = 430;
	                   
	                   // 전체 너비 설정
	                   SheetWidth = mainTable.clientWidth;
	
	                   //Host정보 설정[필수][HostIp, Port, PagePath]
	                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                   //전체Merge 종류 [선택, Default msNone]
	                   MergeSheet = msHeaderOnly;
	
	                  //전체Edit 허용 여부 [선택, Default false]
	                   Editable = true;
	
	                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                   InitRowInfo( 2, 1, 10, 100);
	
	                   var HeadTitle1 = "|Seq|Month|Vessel|Vessel Name|FLAG|OPR|GRT|NRT|Rev Per\nTon|BUILT|TIME CHARTER|TIME CHARTER|TIME CHARTER|LOAD\nCAPA|SUPPLY\n(BSA)|S/CHARTER\n(BSA)|ACTUAL|CAPA\nDIFF|USE(%)|DURATION|DURATION|DURATION|Taxable Amount|";
					   var HeadTitle2 = "|Seq|Month|Vessel|Vessel Name|FLAG|OPR|GRT|NRT|Rev Per\nTon|BUILT|DEL DT|REDEL DT|YEAR|LOAD\nCAPA|SUPPLY\n(BSA)|S/CHARTER\n(BSA)|ACTUAL|CAPA\nDIFF|USE(%)|START|FINISH|DAYS|Taxable Amount|";
					
	
	                   //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                   InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
	
	                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                   InitHeadMode(true, true, false, true, false,false)
	
	
	                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                   InitHeadRow(0, HeadTitle1, true);
										InitHeadRow(1, HeadTitle2, true);
						 var prefix = "sheet1_"		
	                   //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                    InitDataProperty(0, cnt++, dtHiddenStatus,  0,			daCenter,	true,	"Status");
						InitDataProperty(0, cnt++, dtSeq,			50,			daCenter,	true,	"Seq",			false,		"",       dfNone,	0,	false,	false);
		                InitDataProperty(0, cnt++, dtData,			50,			daCenter,	true,	prefix+"stl_mon",			false,		"",       dfNone,	0,	false,	false);
	                    InitDataProperty(0, cnt++, dtData,			60,			daCenter,	true,	prefix+"vsl_cd",			false,		"",       dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			130,		daLeft,	true,	prefix+"vsl_eng_nm",		false,		"",       dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			40,			daCenter,	true,	prefix+"vsl_rgst_cnt_cd",				false,		"",       dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			60,		  daCenter,		true,	prefix+"tong_flet_tp_cd",				false,		"",       dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			60,		  daRight,	true,	prefix+"grs_rgst_tong_wgt",				false,		"",       dfInteger,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			60,		  daRight,	true,	prefix+"nrt_wgt",				false,		"",       dfInteger,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			70,		  daRight,	true,	prefix+"per_ton_rev",				false,		"",       dfInteger,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			70,		  daCenter,	true,	prefix+"vsl_de_dt",				false,		"",       dfDateYmd,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			70,		  daCenter,	true,	prefix+"ctrt_st_dt",			false,		"",       dfDateYmd,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			70,			daCenter,	true,	prefix+"ctrt_end_dt",		false,		"",       dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			40,			daRight,	true,	prefix+"ctrt_year",		false,		"",       dfFloat,	2,	false,	false);
						InitDataProperty(0, cnt++, dtData,			70,			daRight,	true,	prefix+"ldb_capa_qty",				false,		"",       dfInteger,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			70,			daRight,	true,	prefix+"bsa_capa",			false,		"",       dfInteger,	0,	false,	false);
						InitDataProperty(0, cnt++, dtHidden,			0,			daRight,	true,	prefix+"chtr_bsa_capa",			false,		"",       dfInteger,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			60,			daRight,	true,	prefix+"act_bsa_capa",			false,		"",       dfInteger,	0,	false,	false);
						InitDataProperty(0, cnt++, dtHidden,			0,			daRight,	true,	prefix+"capa_diff",				false,		"",       dfInteger,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			50,			daRight,	true,	prefix+"usg_rt",				false,		"",       dfFloat,		2,	false,	false);
						InitDataProperty(0, cnt++, dtData,			70,			daCenter,	true,	prefix+"fm_vvd_stl_dt",	false,		"",       dfDateYmd,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			70,			daCenter,	true,	prefix+"to_vvd_stl_dt",	false,		"",       dfDateYmd,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			40,			daRight,	true,	prefix+"voy_dys",	false,		"",       dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,			90,			daRight,	true,	prefix+"tong_tax_amt",			false,		"",       dfInteger,	0,	false,	false);
						InitDataProperty(0, cnt++, dtHidden,			90,			daCenter,	true,	prefix+"stl_yrmon",			false,		"",       dfNone,	0,	false,	false);
					
					
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
	 		
	 			    			var sXml = sheetObj.GetSearchXml("FNS_TOT_0013GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
	 			    			sheetObjects[0].LoadSearchXml(sXml);

	 		                 }
	 		                 
	 		             }
	 					
 					break;
 					
 					case IBSAVE:        //저장
	 				
 					break;
 					
 					case IBINSERT:      // 입력
 					break;
         }
    }

    /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
  		sheetObj.ShowDebugMsg = false;
  		var formObject = document.form;
  		var prefix="sheet1_";
        var stl_yrmon = formObject.stl_yrmon.value;
        var e_stl_yrmon = formObject.e_stl_yrmon.value;
  		switch (sAction) {

			
			   case IBSEARCH: //조회

				    if (formObject.vsl_cd.value ==null || formObject.vsl_cd.value ==""){
					    ComShowCodeMessage('TOT00054');
					    ComSetFocus(formObject.vsl_cd);
					    return false;
				    }
					if (formObject.stl_yrmon.value ==null || formObject.stl_yrmon.value ==""){
   						ComShowCodeMessage('TOT00003');
   						ComSetFocus(formObject.stl_yrmon);
   						return false;
   					}

					if (formObject.e_stl_yrmon.value ==null || formObject.e_stl_yrmon.value ==""){
						ComShowCodeMessage('TOT00003');
   						ComSetFocus(formObject.e_stl_yrmon);
   						return false;
   					}			   

		    		
		    		if(stl_yrmon.substring(0,4) != e_stl_yrmon.substring(0,4)){
		    			ComShowCodeMessage('TOT00041');
		    			ComSetFocus(formObject.stl_yrmon);
		    			return false;
		    		}

				break;
			   case IBSAVE:   //저장
			   
			   break;
  			default:
  				break;
  		}
  		return true;

    }

    function sheet1_OnDblClick(sheetObj,Row,Col){
	 // alert("sheet1_OnDblClick row : " +Row+"   col : "+ Col);
   	  openPopup();

    }
    
    /**
      * 아이비시트 팝업 클릭시 이벤트
      */
    function t1sheet1_OnPopupClick(sheetObj, Row,Col,Value)
    {
         switch(sheetObj.ColSaveName(Col)) {
             case "MDate":
                 alert("MDate_popup_click");
                 break;
         }
    }
