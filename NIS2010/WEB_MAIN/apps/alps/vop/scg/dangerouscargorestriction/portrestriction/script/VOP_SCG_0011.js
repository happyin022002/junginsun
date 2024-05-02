/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0011.js
*@FileTitle : VSL OPR's Restriction on DG (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.14
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.14 장강철 jkc
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
     * @class vop_scg_0011 : vop_scg_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0011() {
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

 
 var SEARCH_METHOD = "";
 
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

 		 
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[1] , formObject, IBSEARCH);
 					break;
 					
 				case "btn_New":
 					doActionIBSheet(sheetObjects[1] , formObject, IBRESET);
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
      * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
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
         initControl();         
		 doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBCLEAR);         
         
 
     }
      /**
       * Irregular List for Un No. 조회
       */
      var unData;
      function searchIrrForUnNo(imdg_un_no) {
          var formObj  = document.form;
          var sheetObj = sheetObjects[0];
          
          formObj.f_cmd.value = SEARCH07;
          sheetObj.WaitImageVisible = false;  
          var sXml = sheetObj.GetSearchXml("VOP_SCG_0012GS.do", FormQueryString(formObj));    
          sheetObj.WaitImageVisible = true;   
          
          unData = ComScgXml2Array(sXml, "imdg_un_no");
          
          var isChk = false;
          if(unData != null && unData.length > 0) {
              for(var arrIdx=0; arrIdx<unData.length; arrIdx++) {
                  if(imdg_un_no == unData[arrIdx]) isChk = true;
              }
          } 
          
          if(isChk) document.getElementById('srch_irregulars_list').style.color = "red";
      }      
     /**
      * 
      * @return
      */
      function initControl() {
    	 var formObj = document.form;

    	 axon_event.addListener ('keydown', 	'ComKeyEnter', 	'form');
       	 axon_event.addListenerForm('keypress','obj_keypress',    form  );
     	 axon_event.addListenerForm('keyup',   'obj_keyup',     form );
              	 
   	     axon_event.addListenerForm('blur',  	  'obj_blur'      ,form); //- 포커스 나갈때
         axon_event.addListenerForm('beforedeactivate', 'obj_blur_deact',form); //- 포커스 나갈때
    
         axon_event.addListener    ('click',   'img_click',   	"srch_imdg_un_no");
         axon_event.addListener    ('click',   'img_click',   	"srch_pol_port_cd");
         axon_event.addListener    ('click',   'img_click',   	"srch_pod_port_cd");
         axon_event.addListener    ('click',   'img_click',   	"srch_irregulars_list");     
         
         
         // IBMultiCombo초기화
          
         for(var k=0; k<comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }         
      }   
      /**
       * Combo 기본 설정
       * Combo의 항목을 설정한다.
       */
      function initCombo(comboObj, comboNo) {  
	 	    switch(comboObj.id) {
	 	        case "slan_cd":
	 	            with(comboObj) {
	 	            	SetTitle("Code|CodeName");	 	            	
    	                SetColAlign("center|left");	 	            	
	 	            	SetColWidth("50|400");
	 	            	DropHeight      = 200;
	 	            	MultiSelect     = false;
	 	            	UseAutoComplete = true;
	                    ValidChar(2,1);
	                    MaxLength = 3;
	 	            }
	 	            break;	
		        case "pol_port_rotn_seq":
		            with(comboObj) {
		            	SetColWidth("40");
		            	DropHeight = 190;
		            	MultiSelect = false;
		            	MaxSelect = 1;
		            	UseAutoComplete = false;
		        		Enable = false;
		            }
		            break;
		        case "pod_port_rotn_seq":
		            with(comboObj) {
		            	SetColWidth("40");
		            	DropHeight = 190;
		            	MultiSelect = false;
		            	MaxSelect = 1;
		            	UseAutoComplete = false;
		        		Enable = false;
		            }
		            break;
	 	    }
      }
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo){ 
		     case 1:      //t2sheet1 init
		     with (sheetObj) {
		          // 높이 설정
		          style.height = 82;
		          style.width  = 490;		          
		          //전체 너비 설정
		          SheetWidth = mainTable.clientWidth;
		
		          //Host정보 설정[필수][HostIp, Port, PagePath]
		          if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		          //전체Merge 종류 [선택, Default msNone]
		          MergeSheet = msHeaderOnly;
		
		         //전체Edit 허용 여부 [선택, Default false]
		          Editable = false;
		
		          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		          InitRowInfo(1, 1, 1, 100);
		
		          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		          InitColumnInfo(8, 0, 0, true);
		
		          // 해더에서 처리할 수 있는 각종 기능을 설정한다
		          InitHeadMode(true, true, true, true, false )
		
		          var HeadTitle1 = "|Type|Port Code|Required|Explanation";
		
		          //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		          InitHeadRow(0, HeadTitle1, false, true);
		
		          //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,	        60,	    	daCenter,	true,		"crr_cd1",		false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    60,		    daCenter,	true,		"crr_cd2",	    false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    60,	       daCenter,	true,		"crr_cd3",		false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,			60,	       daCenter,	true,		"crr_cd4",      false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,			60,		   daCenter,	true,		"crr_cd5",	    false,           "",      dfNone, 			0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,         60,        daCenter,   true,       "crr_cd6",      false,           "",      dfNone,           0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,         60,        daCenter,   true,       "crr_cd7",      false,           "",      dfNone,           0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,         60,        daCenter,   true,       "crr_cd8",      false,           "",      dfNone,           0,     true,       true);
        
                    //선택된 행의 하이라이트를 안준다.
                    SelectHighLight = false;
						
					ShowButtonImage = 2;

 					CountPosition=0;
 					
		     }
		     break; 
             case 2:      //t2sheet1 init
                with (sheetObj) {
                     // 높이 설정
                     style.height = 220;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 13, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(5, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle1 = "|Type|Port Code|Required|Explanation";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, false, false);

                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,		daCenter,	true,		"Status",		       false,           "",      dfNone, 			0,     true,       true);
 					InitDataProperty(0, cnt++ , dtData,		    95,		daCenter,	false,		"port_type",	       false,           "",      dfNone, 			0,     true,       true);
 					InitDataProperty(0, cnt++ , dtData,		    100,	daCenter,	false,		"port_cd",		       false,           "",      dfNone, 			0,     true,       true);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"imdg_cmptn_auth_cd",  false,           "",      dfNone, 			0,     true,       true);
 					InitDataProperty(0, cnt++ , dtData,			55,		daLeft,		true,		"txt_desc",	           false,           "",      dfNone, 			0,     true,       true);

 					 
 					InitDataCombo(0, "port_type", "POL|POD|Transit", "1|2|3");
 						
                    //선택된 행의 하이라이트를 안준다.
                    SelectHighLight = false;

                    ShowButtonImage = 2;
 					
 					DataLinkMouse("port_cd") = true;
                }
                break;
 
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction, cRow, pObj) {
         sheetObj.ShowDebugMsg = false;
 
         switch(sAction) {

	         case IBCLEAR:      //초기화
//	             formObj.f_cmd.value = SEARCH02;
//	             var param      =  FormQueryString(formObj)+"&vsl_slan_cd=" ;
//	             var sXml       =  sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", param);		
//	             ComXml2ComboItem(sXml, formObj.slan_cd, "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
	      
                 clearComboObj();
		         formObj.imdg_un_no.focus();
		         formObj.imdg_un_no.select();

	             break;         
            case IBSEARCH:      //조회
                 if(!validateForm(sheetObj,formObj,sAction)){
                     return;
                 }
 
				 formObj.f_cmd.value = SEARCH01;
				 var param      =  FormQueryString(formObj);
 
				 var sXml = sheetObj.GetSearchXml("VOP_SCG_0011GS.do", param); 
				 var aXml =  sXml.split("|$$|")
				// sheetObjects[0].LoadSearchXml( aXml[0] );
				 sheetObjects[1].LoadSearchXml( aXml[1] );
				 sheetObj.ColFontUnderline("port_cd") = true;
				 fnCarrierSearchEnd( aXml[0] );
				 
				 SEARCH_METHOD = ComGetEtcData(aXml[0], "SEARCH_METHOD"); //{class, unno}

                 break;

 			case IBRESET:      // NEW 버튼
                 fnBtnNew();
                 clearComboObj();
                 formObj.imdg_un_no.focus();
 			     break;

 			case IBSEARCH_ASYNC01:  //axon_event checkPort
				    if(!validateForm(sheetObj,formObj,sAction) ){ 
					    return;
					}
		            formObj.f_cmd.value = SEARCH09;
		            var param      =  "f_cmd="+formObj.f_cmd.value+"&port_cd="+pObj.value ;
		            var sXml       =  sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", param);		 
		            var port_cd_nm =  ComGetEtcData(sXml,"port_cd_nm");   //port_cd_nm              
		            var Msg        =  ComScgGetMessageFromXml(sXml );
	 
		            if( Msg  != ""){
 				    	 if( pObj.name == "pol_port_cd"){
 		                 	 ComShowCodeMessage("SCG50010", 'Data'); 	
					         formObj.pol_port_cd.value = '';	 		                 	 
					         formObj.pol_port_cd.focus();			    		 
				    	 }else if( pObj.name == "pod_port_cd"){
 		                 	 ComShowCodeMessage("SCG50010", 'Data'); 					    		 
					         formObj.pod_port_cd.value = '';				    		 
					         formObj.pod_port_cd.focus();			    		 
 				    	 } 
		            }else{
				    	 if( pObj.name == "pol_port_cd"){
					         formObj.pod_port_cd.focus();			    		 
				    	 }else if( pObj.name == "pod_port_cd"){ 
                             doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC04);
				    	 }
		            }
		       break;
		       
			case IBSEARCH_ASYNC02:  //axon_event prp_shp_nm 
			     if(!validateForm(sheetObj,formObj,sAction)){ 
				    return;
				 }
	             formObj.f_cmd.value = SEARCH05;
	             var param                       =  FormQueryString(formObj)+"&imdg_un_no_hld_flg=Y" ;//imdg_un_no_hld_flg: to get IrrList 
	             var sXml                        =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);	
 
	             var prp_shp_nm                  =  ComGetEtcData(sXml,"prp_shp_nm"  );   //prp_shp_nm  
	             var imdg_clss_cd_desc           =  ComGetEtcData(sXml,"imdg_clss_cd_desc");   //imdg_clss_cd_desc  
	             var imdg_clss_cd                =  ComGetEtcData(sXml,"imdg_clss_cd");   //imdg_clss_cd  		                 
//                 var irregular_reg_yn            =  ComGetEtcData(sXml,"irregular_reg_yn");   //irregular_reg_yn
	             
                 var sTotal = ComScgGetTotalValue(sXml);
//                 document.getElementById('srch_irregulars_list').style.color = "#737373";                        
                 if( sTotal == "0"){
                 	 ComShowCodeMessage("SCG50010", 'Data');
			         formObj.imdg_un_no_seq.value = '';
			         formObj.prp_shp_nm.value     = '';			         
			         formObj.imdg_un_no_seq.focus();
	             }else{
//	                 if(irregular_reg_yn == "Y"){
//	                     document.getElementById('srch_irregulars_list').style.color = "red";
//	                 }else{
//	                     document.getElementById('srch_irregulars_list').style.color = "#737373";	                    
//	                 }
	                 formObj.prp_shp_nm.value        =  prp_shp_nm;   
	                 formObj.imdg_clss_cd_desc.value =  imdg_clss_cd_desc;
	                 formObj.imdg_clss_cd.value      =  imdg_clss_cd;	                 
			         formObj.pol_port_cd.focus();	            	 
	             }
	             break;
	             
			case IBSEARCH_ASYNC03:  //CheckUnNumber
                 formObj.f_cmd.value = SEARCH01;
                 var param =  FormQueryString(formObj) ;
                 var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
                 var sTotal = ComScgGetTotalValue(sXml);
                 if( sTotal == "0"){
              	     ComShowCodeMessage("SCG50010", 'Data');
              	     formObj.imdg_un_no.value = "";
              	     formObj.imdg_un_no.focus();
                 }else{  
            	     formObj.f_cmd.value = SEARCH05;
		             var param                       =  FormQueryString(formObj)+"&imdg_un_no_hld_flg=Y" ;//imdg_un_no_hld_flg: to get IrrList 
		             var sXml                        =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);	
	 
		             var irregular_reg_yn            =  ComGetEtcData(sXml,"irregular_reg_yn");   //irregular_reg_yn
	                 
	                 if(irregular_reg_yn == "Y"){
	                     document.getElementById('srch_irregulars_list').style.color = "red";
	                 }else{
	                     document.getElementById('srch_irregulars_list').style.color = "#737373";	                    
	                 }
	                 
	                 formObj.imdg_un_no_seq.focus();
                 }
                 break;		 
                 
	         case IBSEARCH_ASYNC04:      //Target Lane 가져오기 
                 formObj.f_cmd.value = SEARCH11;
                 var param      =  FormQueryString(formObj);
                 var sXml       =  sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", param);       
                 ComXml2ComboItem(sXml, formObj.slan_cd, "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
                 var sTotal = ComScgGetTotalValue(sXml);
                 //2010-02-19서동호부장님 요청으로 메세지 삭제
                 //if( sTotal == "0"){
                 //     ComShowCodeMessage("SCG50010", 'Data');
                 //     formObj.pod_port_cd.focus(); 
                 //     formObj.pod_port_cd.select();                         
                 //     return;
                 //}else{
                 formObj.slan_cd.focus();
                 //}                 
                 break;                   

	         case IBSEARCH_ASYNC05:    //Port Clpt Seq 가져오기 
	        	 formObj.f_cmd.value = SEARCH02;
         		//파라미터 명시적인 생성
	 			var formParams = "";
	 			var polXml = "";
	 			var podXml = "";
	     		formParams = "f_cmd="+ComGetObjValue(formObj.f_cmd)+"&slan_cd="+ComGetObjValue(formObj.slan_cd)+"&pol_port_cd="+ComGetObjValue(formObj.pol_port_cd);         		
	     		var polXml = sheetObj.GetSearchXml("VOP_SCG_0011GS.do", formParams);
	     		if(ComScgGetTotalValue(polXml) > 0) {
    	  			comboObjects[0].Enable = true;
		     		ComXml2ComboItem(polXml, formObj.pol_port_rotn_seq, "clpt_seq", "clpt_seq");	     			
    	  			comboObjects[0].Index = 0;
	     		}
	     		formParams = "f_cmd="+ComGetObjValue(formObj.f_cmd)+"&slan_cd="+ComGetObjValue(formObj.slan_cd)+"&pod_port_cd="+ComGetObjValue(formObj.pod_port_cd);         		
	     		var podXml = sheetObj.GetSearchXml("VOP_SCG_0011GS.do", formParams);
	     		if(ComScgGetTotalValue(podXml) > 0) {
    	  			comboObjects[1].Enable = true;	     			
		     		ComXml2ComboItem(podXml, formObj.pod_port_rotn_seq, "clpt_seq", "clpt_seq");
    	  			comboObjects[1].Index = 0;
	     		}
	     		break;
         }
          
     }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch ( sAction ) {
        	          case  IBSEARCH:
        	        	  if( !ComChkRequired(formObj) ){
                              return false;
                          }
 
        	        	  if(formObj.slan_cd.Text == ""){
         		    	     ComShowCodeMessage('SCG01001', 'Target Lane');   
        		    	     formObj.slan_cd.focus();
        		    	     return false;     
        	        	  }        	        	  
        	        	  break;
        	 }
         }

         return true;
     }


    /************************************User_event*************************************************/ 	
    /**
     * Unno Help 팝업으로 Unno, seq, ClassCd 구하기 
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				선택 선택한 Row
     * @param  {Int} col				선택 선택한 Column
     * @param  {Int} sheetIdx		선택 Sheet Index
     * @return 없음
     */  
     function setUnnoAndClassCd(aryPopupData){ 
        	with(document.form){
        		imdg_clss_cd.value       = aryPopupData[0][4]; 
        		imdg_clss_cd_desc.value  = aryPopupData[0][5];    
        		imdg_un_no.value     = aryPopupData[0][2];      
        		imdg_un_no_seq.value = aryPopupData[0][3];          		
        		prp_shp_nm.value     = aryPopupData[0][6]; 
 	       }
     }
    /**
     *  Carrier 조회 후 처리.
     *  
     */
    function fnCarrierSearchEnd( sXml ){
        if( sXml == ""){
        	return;
        }
        var total = eval( ComScgGetTotalValue(sXml) );
        var rowNum = 1;
        if( total > 0){
        	sheetObjects[0].RemoveAll();
        	sheetObjects[0].DataInsert(-1);
        }
        var j = -1;
         
        for(var i=1;i<=total;i++){
            var value = ComScgGetRowValue(sXml, i, "vsl_opr_tp_cd");    
            if ( j < sheetObjects[0].LastCol ){
                j++;
            }else{
            	j=0;
            	sheetObjects[0].DataInsert(-1);            	
            	rowNum++;             	
            }
            sheetObjects[0].CellValue2(rowNum, j) = value;
            sheetObjects[0].DataLinkMouse(j) = true;                 
            sheetObjects[0].ColFontUnderline(j) = true;
        }
        
        for(var i=sheetObjects[1].HeaderRows;i<=sheetObjects[1].RowCount;i++){
           if ( sheetObjects[1].CellValue( i, "imdg_cmptn_auth_cd")   == "Prohibition"  ){
                sheetObjects[1].CellFontColor( i, "imdg_cmptn_auth_cd") = sheetObjects[1].RgbColor(255, 0, 0);
           }
       
        }
       
    }
     /**
      * NEW 버튼 처리. 
      * @return
      */
     function fnBtnNew(){
    	  var formObj = document.form;
    	  fnNewGrid();
    	  formObj.imdg_un_no.value         = '';	         
     	  formObj.imdg_un_no_seq.value     = '';	
      	  formObj.prp_shp_nm.value         = '';		
      	  formObj.imdg_clss_cd.value       = ""; 	            	
      	  formObj.imdg_clss_cd_desc.value  = ""; 	
      	  formObj.pod_port_cd.value = "";
      	  formObj.pol_port_cd.value = "";
      	  formObj.slan_cd.Text2 = "";
      	  formObj.slan_cd.RemoveAll();
      	  
      	  document.getElementById('srch_irregulars_list').style.color = "#737373";

     }
     /**
      * 
      * <pre>
      *    Grid 데이타 크리어 
      * </pre>
      *
      * @param   
      * @return
      * @author jang kang cheol
      */
     function fnNewGrid(){
         for(var i=0;i<sheetObjects.length;i++){
             var cnt = sheetObjects[i].RowCount;
 
             for(var j=1;j<= cnt;j++ ){
                 sheetObjects[i].RowDelete(1, false);
             }
         }
     }
    /************************************Sheet_event*************************************************/ 	     
  	function sheet1_OnClick(sheetObj,Row,Col,Value){
  	    var formObj = document.form;
 		if( Value != ""){

			 var  imdg_clss_cd      =  formObj.imdg_clss_cd.value;
			 var  imdg_clss_cd_desc =  formObj.imdg_clss_cd_desc.value;
			 var  imdg_un_no        =  formObj.imdg_un_no.value;
			 var  imdg_un_no_seq    =  formObj.imdg_un_no_seq.value;
			 var  prp_shp_nm        =  formObj.prp_shp_nm.value; 
			 
			 
 			 var  sUrl              = "/hanjin/VOP_SCG_0010.do?pgmNo=VOP_SCG_0010";
 			 var  param             = "&pCrr_cd="+Value;
 			 
 			 param          += "&pImdg_clss_cd="+imdg_clss_cd;
 			 param          += "&pImdg_clss_cd_desc="+imdg_clss_cd_desc;
 			 param          += "&pImdg_un_no="+imdg_un_no;
 			 param          += "&pImdg_un_no_seq="+imdg_un_no_seq;    
             param          += "&pPrp_shp_nm="+prp_shp_nm;
             param          += "&pSearchMethod="+SEARCH_METHOD;
             sUrl += param;
             
             var leftpos = (screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
             var toppos  = (screen.height- iHeight)/2;   if(toppos<0)  toppos=0;  	
 			 var iWidth  = 1026;
 			 var iHeight = 705;             
 			 var sFeatures = "scroll:no;status:no;help:no;dialogWidth:"+iWidth+"px;dialogHeight:"+iHeight+"px;dialogLeft:" + leftpos + ";dialogTop:"+toppos+ ";scroll-y:no";
 			 ComOpenWindow(sUrl,"VOP_SCG_0010",sFeatures, true);
 
 		}
 	}
  	function sheet2_OnClick(sheetObj,Row,Col,Value){
        var formObj = document.form;
        
 		if( sheetObj.ColSaveName(Col) == "port_cd" ){
            var  imdg_clss_cd      =  formObj.imdg_clss_cd.value;
            var  imdg_clss_cd_desc =  formObj.imdg_clss_cd_desc.value;
            var  imdg_un_no        =  formObj.imdg_un_no.value;
            var  imdg_un_no_seq    =  formObj.imdg_un_no_seq.value;
            var  prp_shp_nm        =  formObj.prp_shp_nm.value; 
            var sUrl = "/hanjin/VOP_SCG_0006.do?pgmNo=VOP_SCG_0006&pPort_cd="+Value;
            var  param             = "&pCrr_cd="+Value;
            
            param          += "&pImdg_clss_cd="+imdg_clss_cd;
            param          += "&pImdg_clss_cd_desc="+imdg_clss_cd_desc;
            param          += "&pImdg_un_no="+imdg_un_no;
            param          += "&pImdg_un_no_seq="+imdg_un_no_seq;    
            param          += "&pPrp_shp_nm="+prp_shp_nm;
            sUrl += param;
            

             var leftpos = (screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
             var toppos  = (screen.height- iHeight)/2;   if(toppos<0)  toppos=0; 			
 			 var iWidth  = 1040;
 			 var iHeight = 700;
 			 var sFeatures = "status:no;help:no;dialogWidth:"+iWidth+"px;dialogHeight:"+iHeight+"px;dialogLeft:" + leftpos + ";dialogTop:"+toppos;
 			ComOpenWindow(sUrl, sUrl, sFeatures, true);		 
 		}
 	}  	
    /**
     * Lane Code OnChange시 처리 
     * @param comboObj
     * @param value
     * @param text
     * @return
     */
    function slan_cd_OnChange (comboObj, code, text) {
        clearComboObj();
        var formObj = document.form; 
    	doActionIBSheet(sheetObjects[1] , formObj, IBSEARCH_ASYNC05);
    } 	
    
    function slan_cd_OnKeyDown(comboObj, KeyCode, Shift){
        var formObj = document.form;
        //formObj.slan_cd.className = "input2_1";
    }
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	 	 
    }

    /************************************Axon_event*************************************************/
     /**
      * Form Object obj_keypress 이벤트시 처리
      * @param  void
      * @return void
      */     
      function obj_keypress (){
    	  var obj = event.srcElement;
      	  switch (obj.name){
               case 'pol_port_cd':
        	       ComKeyOnlyAlphabet('uppernum');
    	            break; 
               case 'pod_port_cd':
       	            ComKeyOnlyAlphabet('uppernum');
   	                break; 
   	            
      	       case 'imdg_un_no':
      	    	    ComKeyOnlyNumber(obj);
      	    	    break;
      	       case 'imdg_un_no_seq':
      	    	    ComKeyOnlyNumber(obj);
     	    	    break;      	    	    
      	  }
    	  
      }
      /**
       * Form Object  blur 이벤트시 처리
       * @param  void
       * @return void
       */     
       function obj_blur (){
 
 	  	    var obj = event.srcElement;
 
 	  	    var formObj = document.form;
 	  	    switch (obj.name){
                case 'imdg_un_no':
                    if( !ComChkObjValid( formObj.imdg_un_no) ){
 
                        return;
                    }else{
                        doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC03);                         
                    }
                    break;

 	            case 'imdg_un_no_seq':
                      if( !ComChkObjValid( formObj.imdg_un_no_seq) ){
                          return;
 	 	              }else{
                          doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC02); 	 	                  
 	 	              }
 	                  break;
 	            case 'pol_port_cd':
 
 	                 if( !ComChkObjValid( formObj.pol_port_cd) ){
 
     		    	     return;
                      } 
	                  break; 
// 	            case 'pod_port_cd':
//                      if( !ComChkObjValid( formObj.pod_port_cd) ){
//                        obj.focus();
//                        obj.select();
//                          return;
//                      }
//	                  break; 	            
// 	  	        }
 	  	    }
       }   
       function obj_blur_deact (){
           
           var obj = event.srcElement;

           var formObj = document.form;
           switch (obj.name){
  
               case 'pod_port_cd':
                     if( !ComChkObjValid( formObj.pod_port_cd) ){
                         return;
                     }
                     break;                
           }
      }        
       /**
        * Form obj_keyup 이벤트시 처리
        * @param  void
        * @return void
        */         
        
       function obj_keyup(){
 
	  	    var obj = event.srcElement;	  	  
 	  	    var formObj = document.form;
 	  	    switch (obj.name){
 	            case 'imdg_un_no':
 	     	          if( formObj.imdg_un_no.value.length == 4 ){
 	     	              formObj.imdg_un_no_seq.focus();
 	 	              }else{
                          fnNewGrid();                          
                          formObj.imdg_un_no_seq.value     = '';    
                          formObj.prp_shp_nm.value     = '';        
                          formObj.imdg_clss_cd.value = "";                  
                          formObj.imdg_clss_cd_desc.value = "";     
                          formObj.pol_port_cd.value = "";
                          formObj.pod_port_cd.value = "";
                          formObj.slan_cd.Text2     = "";
                          document.getElementById('srch_irregulars_list').style.color = "#737373";                                
 	 	              }
 	                  break;   
 	            case 'imdg_un_no_seq':
                        fnNewGrid();                          
    
                        formObj.prp_shp_nm.value     = '';        
                        formObj.imdg_clss_cd.value = "";                  
                        formObj.imdg_clss_cd_desc.value = "";     
                        formObj.pol_port_cd.value = "";
                        formObj.pod_port_cd.value = "";
                        formObj.slan_cd.Text2     = "";       

	                  break;  
 	            case 'pol_port_cd':
	     	          if( obj.value != "" && obj.value.length == 5 ){    
 
	     	        	  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01, 0, obj);
	 	              }else{
                          fnNewGrid();                          
                          formObj.pod_port_cd.value = "";
                          formObj.slan_cd.Text2     = "";           	 	                  
	 	              }
	                  break;
 	            case 'pod_port_cd':
	     	          if( obj.value != "" && obj.value.length == 5 ){     
	     	        	  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01, 0, obj);
                      }else{
                          fnNewGrid();                          
                          formObj.slan_cd.Text2     = "";                                     
                      }
	                  break;	                  
 	  	    } 	            
 
       }
    /**
     * @param  {Array} aryPopupData 필수   Array Object
     * @return 없음
     */   
     function setPodPortCd(aryPopupData){
         with(document.form){
             pod_port_cd.value = aryPopupData[0][2];
             doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC04);               
         }
     }   
    /**
     * image Button 클릭시 이벤트 처리
     * @param  void
     * @return void
     */
    function img_click(){

	    var obj = event.srcElement;
        var formObj = document.form;
   	    if(obj.name == "srch_pol_port_cd"){
            var port_cd = document.form.pol_port_cd.value; 
    	     ComOpenPopupWithTarget('/hanjin/VOP_VSK_0043.do?port_cd='+port_cd, 427, 520, "loc_cd:pol_port_cd", "0,0", true);    	     
   	    }    
   	    if(obj.name == "srch_pod_port_cd"){
            var port_cd = document.form.pod_port_cd.value; 
//          ComOpenPopupWithTarget('/hanjin/VOP_VSK_0043.do?port_cd='+port_cd, 427, 495, "loc_cd:pod_port_cd", "0,0", true);
            ComOpenPopup('/hanjin/VOP_VSK_0043.do?port_cd='+port_cd, 427, 520, "setPodPortCd", "0,0", true);
  	    }   
  	    if(obj.name == "srch_imdg_un_no"){ 
  	    	 var imdg_un_no = formObj.imdg_un_no.value;
  	    	 ComOpenPopup('/hanjin/VOP_SCG_3005.do?imdg_un_no='+imdg_un_no,940, 420, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true);
	    }
  	    if(obj.name == "srch_irregulars_list"){ 
	    	 var imdg_un_no = formObj.imdg_un_no.value;
             if( !ComChkObjValid( formObj.imdg_un_no ) ){
                 return;
             }
             if(document.getElementById('srch_irregulars_list').style.color != 'red') imdg_un_no = "";
	    	 var scg_0012 = ComOpenPopup('/hanjin/VOP_SCG_0012Pop.do?pgmNo=VOP_SCG_0012&pop_mode=Y&f_cmd=&imdg_un_no='+imdg_un_no, 1025, 705, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true);
 
	    }  	  
    }

    function clearComboObj() {
    	comboObjects[0].RemoveAll();
    	comboObjects[1].RemoveAll();
    	comboObjects[0].Enable = false;
    	comboObjects[1].Enable = false;
    }
	/* 개발자 작업  끝 */