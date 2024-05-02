/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0010.js
*@FileTitle : VSL OPR's Restriction on DG (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.15 장강철 jkc
* 1.0 Creation
* 2012.04.20 서석진 [CHM-201216960-01] Vessl Operator내 파일첨부 기능 추가
* 2014.04.14 안진응 [CHM-201428592] Vessel Operator"s Restriction on DG - Inquiry (조회조건 변경 OPR or Class/UN No.)
* 2016.05.09 UN NO에 해당 하는 데이터가 없으면 CLASS로 조회
* 처리내역 :첨부파일추가
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
     * @class vop_scg_0010 : vop_scg_0010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0010() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    /* 개발자 작업   */
    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0; 
    var codeObjs = new Array();
    
    var oneventing = "N";
    
    var callbackEvent = "";
    var popCheck      = "N";
     
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             
             var sheetObject1 = sheetObjects[0];
             
             /*******************************************************/
             var formObject = document.form;

           // try {
               var srcName  = window.event.srcElement.getAttribute("name");
               var optclass = window.event.srcElement.getAttribute("optclass");
               var doc      = document.all;
    
           
                switch(srcName) {

                case "btn_Retrieve":
                       doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                       break;
                       
                   case "btn_New":
                       
                       doActionIBSheet(sheetObjects[0],document.form,IBRESET);
                       break;
                       
                   case "btn_DownExcel":
                	   if( formObject.optclass[0].checked ){
                		   var paramObj = new Object();
                           paramObj.title = "Vessel Operator's Restriction on DG";
                           paramObj.cols = "5";
                           paramObj.columnwidth = "1:10|2:10|3:70|4:20|5:10";
                           var url = ComScgGetPgmTitle(sheetObjects[0], paramObj);  
                           sheetObjects[0].SpeedDown2Excel(-1, false, false, "", url );
                	   }else{
                           var paramObj = new Object();
                           paramObj.title = "Vessel Operator's Restriction on DG";
                           paramObj.cols = "9";
                           paramObj.columnwidth = "1:5|2:5|3:5|4:5|5:55|6:20|7:7|8:10|9:7|10:7";
                           paramObj.datarowheight   = "0:25";
                           var url = ComScgGetPgmTitle(sheetObjects[1], paramObj);  
                           sheetObjects[1].SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
                	   }	
					
					break;  
					
                   case "btn_filePop":
    					if(popCheck == "Y"){
   					       ComOpenPopup('/hanjin/VOP_SCG_0079.do?vsl_opr_tp_cd='+document.form.crr_cd.value+'&seachCheck=Y', 605,490, "setFileUpload", 'none', true);	
    					}
    				
    					break;
 
                   case "btn_Close":
                       window.close();
                       break;                       

                } // end switch
//         }catch(e) {
//             if( e == "[object Error]") {
//                 ComShowMessage(OBJECT_ERROR);
//             } else {
//                 ComShowMessage(e);
//             }
//         }
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
 
        }
         function sheet1_OnLoadFinish(sheetObj) {
             doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
         }         
        function initControl() {
            var form = document.form;
            axon_event.addListenerForm('keypress','obj_keypress',    form  );
            axon_event.addListenerForm('keydown','ComKeyEnterControl',  form,"crr_regu_desc_class|crr_regu_desc_unno"  );
    
            axon_event.addListenerForm('blur',    'obj_blur'      ,form); //- 포커스 나갈때
            axon_event.addListenerForm('keyup',   'obj_keyup',     form );          
            axon_event.addListenerForm('click',   'obj_click',     form);   

            axon_event.addListenerForm('change',  'obj_change',    form);           
           
            axon_event.addListener    ('click',   'img_click',     "srch_imdg_un_no");
            axon_event.addListener    ('click',   'img_click',     "srch_crr_cd"    ); 
            
           // axon_event.addListener    ('mousedown', 'mouse_down',   "btn_Retrieve");   
    

            
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
               case "imdg_clss_cd":
                   with(comboObj) {
                       MultiSelect = false;
                       UseAutoComplete = true;	                
                       SetTitle("Class|Definition");
                       SetColWidth("50|700");
                       DropHeight = 200;
                       ValidChar(2,3);
                       MaxLength = 3;
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

            switch(sheetNo) {
                case 1:      // sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 300;
                        // 전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 6, 100);
                        var HeadTitle = "|Sel.|OPR|Class|Definitions|Restrictions|Lane||||";
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(HeadTitle.split("|").length, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                       var prefix = "sheet1_"; 
                       InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	  daCenter,	false,	prefix+"ibflag");
                       InitDataProperty(0, cnt++ , dtHidden,		30,	  daCenter,	false,	prefix+"Sel",				           false,	"",		dfNone,			0,			false,		false);
                       InitDataProperty(0, cnt++ , dtData,			60,   daCenter,	false,	prefix+"vsl_opr_tp_cd",                false,	"",		dfNone,			0,			false,		false);
                       InitDataProperty(0, cnt++ , dtCombo,        	60,   daCenter, false,  prefix+"imdg_clss_cd",                 true,    "",     dfNone,         0,          false,      false);
                       InitDataProperty(0, cnt++ , dtData,			630,  daLeft,	false,	prefix+"imdg_clss_cd_desc",            false,	"",		dfNone,			0,			false,		false);
                       InitDataProperty(0, cnt++ , dtCombo,	    	120,  daLeft,	false,	prefix+"imdg_crr_rstr_expt_cd",        false,	"",		dfNone,			0,			false,		false);
                       InitDataProperty(0, cnt++ , dtData,    		60,	  daCenter,	false,	prefix+"slan_cd",			           false,	"",		dfEngUpKey,	    0,			false,		false);
                       InitDataProperty(0, cnt++ , dtHidden,		90,	  daLeft,	false,	prefix+"crr_regu_desc",		           false,	"",		dfNone,			0,		    false,	    false); 
                       InitDataProperty(0, cnt++ , dtHidden,		90,	  daLeft,	false,	prefix+"vsl_opr_tp_cd",		           false,	"",		dfNone,			0,		    false,	    false);
                       InitDataProperty(0, cnt++ , dtHidden,		90,	  daLeft,	false,	prefix+"imdg_crr_rstr_seq",	           false,	"",		dfNone,			0,		    false,	    false); 					
                       InitDataProperty(0, cnt++ , dtHidden,	    90,	  daLeft,	false,	prefix+"row_seq",	                   false,	"",		dfNone,			0,		    false,	    false); 					

                       InitDataValid(0,  "sheet1_slan_cd",vtEngUpOnly);    
                       HeadRowHeight 	= 28;
                       ShowButtonImage = 1;
                       CountPosition   = 2;
                       MultiSelection=false;                   
                  }
                    break;
                case 2:      // sheet2 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 300;
                        // 전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 6, 100);

                        var HeadTitle = "|Sel.|OPR|Class|UN No./Seq.|UN No./Seq.|Definitions|Proper Shipping Name|Technical Name|Sub\nRisks|Packing\nGroup|Restrictions|Lane|regu_desc|vsl_opr_tp_cd|imdg_crr_rstr_seq";

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo( HeadTitle.split("|").length , 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);
                            
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                       var prefix = "sheet2_";
                       InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	  daCenter,	false,	prefix+"ibflag");
                       InitDataProperty(0, cnt++ , dtHidden,		30,	  daCenter,	false,	prefix+"Sel",		            false,	"",		dfNone,			0,	false,	true);
                       InitDataProperty(0, cnt++ , dtData,			40,   daCenter,	false,	prefix+"vsl_opr_tp_cd",         false,	"",		dfNone,			0,	false,	false);
                       InitDataProperty(0, cnt++ , dtData,		    40,	  daCenter,	false,	prefix+"imdg_clss_cd",	        false,	"",		dfNone,			0,	false,	false);
                       InitDataProperty(0, cnt++ , dtData,		    45,	  daCenter,	false,	prefix+"imdg_un_no",		    true,	"",		dfNone,         0,	false,	false);
                       InitDataProperty(0, cnt++ , dtPopupEdit,    	40,	  daCenter,	false,	prefix+"imdg_un_no_seq",		true,	"",		dfNumber,		0,	false,	false);
                       InitDataProperty(0, cnt++ , dtData,			630,  daLeft,	false,	prefix+"imdg_clss_cd_desc",     false,	"",		dfNone,			0,			false,		false);
                       InitDataProperty(0, cnt++ , dtData,		   	300,  daLeft,	false,	prefix+"prp_shp_nm",	        false,	"",		dfNone,			0,	false,	false);
                       InitDataProperty(0, cnt++ , dtData,		   	120,  daLeft,	false,	prefix+"imdg_tec_nm",	        false,	"",		dfNone,			0,	false,	false);
                       InitDataProperty(0, cnt++ , dtData,         	60,   daCenter, false,  prefix+"imdg_subs_rsk_lbl_cd",  false,  "",     dfNone,         0,  false,  false);
                       InitDataProperty(0, cnt++ , dtData,		    55,	  daCenter,	false,	prefix+"imdg_pck_grp_cd",	    false,	"",		dfNone,			0,	false,	false);
                       InitDataProperty(0, cnt++ , dtCombo,	   		150,  daLeft,	false,	prefix+"imdg_crr_rstr_expt_cd",	false,	"",		dfNone,			0,	false,	true);
                       InitDataProperty(0, cnt++ , dtData,			60,	  daCenter,	false,	prefix+"slan_cd",		        false,	"",		dfEngUpKey,	    0,	false,	false);
                       InitDataProperty(0, cnt++ , dtHidden,		90,	  daLeft,	false,	prefix+"crr_regu_desc",		    false,	"",		dfNone,			0,	false,	false);
                       InitDataProperty(0, cnt++ , dtHidden,		90,	  daLeft,	false,	prefix+"vsl_opr_tp_cd",		   	false,	"",		dfNone,			0,	false,	false);
                       InitDataProperty(0, cnt++ , dtHidden,		90,	  daLeft,	false,	prefix+"imdg_crr_rstr_seq",	   	false,	"",		dfNone,			0,	false,	false);
                      
                       InitDataValid(0, "sheet2_imdg_un_no"     , vtNumericOnly);
                       InitDataValid(0, "sheet2_slan_cd"        , vtEngUpOnly);    
    
                       HeadRowHeight 	= 28;
                       ShowButtonImage = 1;
                       CountPosition   = 2;
                       MultiSelection  = false;
                       ExtendLastCol   = false;
                       //SelectionMode  = smSelectionCol;
                       //FitColWidth();
                  }
                    break;
            }
        }
          
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction, pRow) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
    
                 case IBCLEAR :      //초기화
                          

                          initoptclass(); 
                
                          formObj.f_cmd.value = SEARCH02;   
                          var param =  FormQueryString(formObj);
                          var exceptkey = "C";
            
                          var sXml  =  sheetObj.GetSearchXml("VOP_SCG_0009GS.do", param+"&code=CD01950&exceptkey="+exceptkey, true);
    
                          var aEtcData     =  ComGetEtcData(sXml ,"codeinfo").split("##");     
                          var aEtcDataAll  =  ComGetEtcData(sXml ,"codeinfoAll").split("##");                     
                          
                          
                          /***************  Grid  Combo Set **********************************/
                          sheetObjects[0].InitDataCombo(0,  "sheet1_imdg_crr_rstr_expt_cd", aEtcData[1], aEtcData[0]   );
                          sheetObjects[1].InitDataCombo(0,  "sheet2_imdg_crr_rstr_expt_cd", aEtcDataAll[1], aEtcDataAll[0]   );
                                /***********Class Combo Set *********************************/
                          var class_cd = ComXml2ComboString(sXml, "imdg_clss_cd", "imdg_clss_cd_desc");
                          var tStr     = ComScgClossAppend(class_cd[0], class_cd[1] );
                          sheetObjects[0].InitDataCombo(0,  "sheet1_imdg_clss_cd"    ,  " |"+tStr, " |"+class_cd[0]);                     
                          
                          
                          /*************** Search Combo grpcd와 Class Cd Setting ******/        
    
                          ComXml2ComboItem(sXml, formObj.imdg_clss_cd, "imdg_clss_cd"    , "imdg_clss_cd|imdg_clss_cd_desc" );
    
                          
                          /******************* CLASS GRID ENABLE, UNNO GRID DISABLE********************/
                          for(var i=1;i<=sheetObjects[0].RowCount;i++){
                              sheetObjects[0].RowEditable(i) = true;
                          }
                          for(var i=1;i<=sheetObjects[1].RowCount;i++){
                              sheetObjects[1].RowEditable(i) = false;
                          }    
                          /**************0011 PGM 넘어온 파람값 셋. **************************/
                          if( formObj.pCrr_cd.value != ""){

                              
                              if(formObj.pSearchMethod.value != ""){
                                  if(  formObj.pSearchMethod.value  == "class" ){
                                      formObj.optclass[0].checked = true;
                                      formObj.optclass[0].fireEvent("onclick");
                                  }else if(  formObj.pSearchMethod.value  == "unno" ){
                                      formObj.optclass[1].checked = true;
                                      formObj.optclass[1].fireEvent("onclick");
                                  }
                              }
                              
                              //obj_click();   .fireEvent('onclick')                           
                              formObj.crr_cd.value       = formObj.pCrr_cd.value;
                              formObj.imdg_clss_cd.Code  = formObj.pImdg_clss_cd.value;
                              formObj.imdg_un_no.value   = formObj.pImdg_un_no.value;
                              formObj.imdg_un_no_seq.value   = formObj.pImdg_un_no_seq.value;
                              formObj.prp_shp_nm.value   = formObj.pPrp_shp_nm.value;
                              
                              doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
 
                              doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);                              
    
                          }else{
                              formObj.crr_cd.focus();
                          }
                          break;
                          
                         case IBSEARCH:      //조회

                                if(!validateForm(sheetObj,formObj,sAction)){ 
                                     return;
                                }
                                if( formObj.optclass[0].checked ){
                                      with( sheetObjects[0] ){
                                          formObj.f_cmd.value = SEARCH01;  
                            
                                          var param     =  "f_cmd="+formObj.f_cmd.value+"&imdg_clss_cd="+formObj.imdg_clss_cd.Text;
                                              param    +=  "&crr_cd="+formObj.crr_cd.value;                                               
                                              param    +=  "&optclass=class";
                                             
                                          var aryPrefix =  new Array( "sheet1_" );
                                          var sXml      =  GetSearchXml("VOP_SCG_0009GS.do", param+ "&" + ComGetPrefixParam( aryPrefix ) );
                                          
                                          formObj.file_name.value = ComGetEtcData(sXml, "fimename");
                                          if(ComGetEtcData(sXml, "fimename") != "") popCheck="Y";
                                          else popCheck="N";
                                         
                                          LoadSearchXml(sXml);
                                          fnSearchEnd(sheetObjects[0]);
                                        /***********************************TXT AREA Setting***********************************************/
                                          formObj.crr_regu_desc_class.value = CellValue(SelectRow, id+"_"+"crr_regu_desc");
    
                                      }   
                                 }else if( formObj.optclass[1].checked ){
                                      with( sheetObjects[1] ){                           
                                          formObj.f_cmd.value = SEARCH01;  
                                          var param     =  "f_cmd="+formObj.f_cmd.value;//+"&imdg_clss_cd="+formObj.imdg_clss_cd.Text;
    
                                              param    +=  "&imdg_un_no="+formObj.imdg_un_no.value;
                                              param    +=  "&imdg_un_no_seq="+formObj.imdg_un_no_seq.value;
                                              param    +=  "&crr_cd="+formObj.crr_cd.value;    
                                              param    +=  "&optclass=unno";
                                              param    +=  "&imdg_tek_nm_check=Y";
                                              param    +=  "&imdg_crr_rstr_expt_cd=C";//
    
                                          var aryPrefix =  new Array( "sheet2_" );
                                          var sXml      =  GetSearchXml("VOP_SCG_0009GS.do", param+ "&" + ComGetPrefixParam( aryPrefix ) );
                                          var SHOW_MSG  =  ComGetEtcData( sXml, "SHOW_MSG");
                                          var sMsg      =  ComScgGetMessageFromXml(sXml);
                                          
                                          formObj.file_name.value = ComGetEtcData(sXml, "fimename");
                                          if(ComGetEtcData(sXml, "fimename") != "") popCheck="Y";
                                          else popCheck="N";
                                          
                                          LoadSearchXml(sXml); 
                                          fnSearchEnd(sheetObjects[1]);
                                       
                                          /********SHOW_MSG에 값이 있을경우 DATA DISP 보다 먼저 메세지 보인다.*******/
                                          if(SearchRows == 0 ){
                                              ComShowMessage( sMsg);
                                              sXml = ComDeleteMsg(sXml);
                                              ColHidden("sheet2_imdg_un_no") = true;
                                              ColHidden("sheet2_imdg_un_no_seq") = true;
                                              ColHidden("sheet2_prp_shp_nm") = true;
                                              ColHidden("sheet2_imdg_tec_nm") = true;
                                              ColHidden("sheet2_imdg_subs_rsk_lbl_cd") = true;
                                              ColHidden("sheet2_imdg_pck_grp_cd") = true;
                                                 
                                              ComShowMessage("There is no restriction of UN No. but pls check restriction of class again.");
                                              var param     =  "f_cmd="+formObj.f_cmd.value+"&imdg_clss_cd="+formObj.imdg_clss_cd.Text;
                                              param    +=  "&crr_cd="+formObj.crr_cd.value;                                               
                                              param    +=  "&optclass=class";
                                             
                                          var aryPrefix =  new Array( "sheet2_" );
                                          var sXml      =  GetSearchXml("VOP_SCG_0009GS.do", param+ "&" + ComGetPrefixParam( aryPrefix ) );
                                          
                                          LoadSearchXml(sXml); 
                                          fnSearchEnd(sheetObjects[1]);
                                          }
                                    
                                          formObj.crr_regu_desc_unno.value = CellValue(SelectRow, id+"_"+"crr_regu_desc"); 
                                      }
                                 }
                                 /******************* Land by Restriction Status********************/
                                 setLaneEnable();                                    
                              break;
    
                       case IBRESET:      // NEW 버튼
                           var doc = document.all;
                           if( formObj.optclass[0].checked ){                 
                               doc.div_s1.style.display = "";                    
                               doc.div_s2.style.display = "none";
                           }                   
                           if( formObj.optclass[1].checked ){                  
                               doc.div_s1.style.display = "";                    
                               doc.div_s2.style.display = "none";
                           }
    
                            initSetting();
                            formObj.crr_cd.focus();
                            break;         
                            
                       case IBSEARCH_ASYNC01:  //axon_event checkCarrier
    
                            formObj.f_cmd.value = SEARCH01;                    
                            var param =  FormQueryString(formObj);
                            var sXml     =  sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", param);                              
                            var sValue   =  ComScgGetRowValue(sXml, 1,"crr_cd|crr_nm|");
                            var aValue   =  sValue.split("|");
                            if( sValue != "" ){
                                formObj.crr_cd.value      = aValue[0];
                                formObj.crr_nm.value = aValue[1];
                                if(  callbackEvent != ""){
                                    if( callbackEvent == "btn_Retrieve"){
                                        callbackEvent="";
                                        doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
                                    }
                                }
                                iniBtn(true); 
                                with(formObj){
                                    if( optclass[0].checked){ 
                                        formObj.imdg_clss_cd.focus();
                                    }
                                    if( optclass[1].checked){
                                        formObj.imdg_un_no.focus();
                                    }
                                }                       
                            }else{
                                ComShowCodeMessage( "SCG50010", 'Data'  );
                                formObj.crr_cd.value      = "";
                                formObj.crr_nm.value = "";
                                formObj.crr_cd.focus();
                                return;
                            }
                            break;
                   
                       case IBSEARCH_ASYNC02:  //CheckUnNumber
    
                           formObj.f_cmd.value = SEARCH01;
                           
                           var param =  FormQueryString(formObj) ;
                           var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
                           var sTotal = ComScgGetTotalValue(sXml);
    
                           if( sTotal == "0"){
                                ComShowCodeMessage("SCG50010", 'Data');
                                formObj.imdg_un_no.value = "";
                                formObj.imdg_un_no.focus();
                           }else{
                                formObj.imdg_un_no_seq.focus();
                           }
                                
                           break;                       

                       case IBSEARCH_ASYNC03:  //shee2 imdg_un_no_seq = > prp_shp_nm 
                            if(!validateForm(sheetObj,formObj,sAction, pRow)){ 
                                return;
                            }
                            formObj.f_cmd.value = SEARCH05;    
                            var param  =  "f_cmd="+formObj.f_cmd.value+"&imdg_un_no="+sheetObj.CellValue(pRow, sheetObj.id+"_imdg_un_no");
                            param      +=  "&imdg_un_no_seq="+sheetObj.CellValue(pRow, sheetObj.id+"_imdg_un_no_seq");


                            var sXml   =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
                            with(sheetObj){
                                CellValue2(pRow, id+"_imdg_clss_cd" )       = ComScgGetRowValue(sXml, 1, "imdg_clss_cd"     );
                                CellValue2(pRow, id+"_prp_shp_nm" )         = ComScgGetRowValue(sXml, 1, "prp_shp_nm"       ); 
                                CellValue2(pRow, id+"_imdg_tec_nm" )        = ComScgGetRowValue(sXml, 1, "imdg_tec_nm"      ); 
                                CellValue2(pRow, id+"_imdg_pck_grp_cd" )    = ComScgGetRowValue(sXml, 1, "imdg_pck_grp_cd"  );   
    
                                
                            }
                             var sTotal = ComScgGetTotalValue(sXml);
                             if( sTotal == "0"){
                                 ComShowCodeMessage("SCG50010", 'Data');  
                                 sheetObj.SelectCell(pRow,  "sheet2_imdg_un_no_seq", true );
                                 sheetObj.CellValue2(pRow,  "sheet2_imdg_un_no_seq") = ""; 
                             } 
                            break;
                       case IBSEARCH_ASYNC04:      //form -> prp_shp_nm 조회
                            formObj.f_cmd.value = SEARCH05;
    
                            var param =  FormQueryString(formObj) ;
                            var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
    
                            var sTotal = ComScgGetTotalValue(sXml);
                            if( sTotal == "0"){
                                ComShowCodeMessage("SCG50010", 'Data');
                                formObj.imdg_un_no_seq.value = "";
                                formObj.imdg_un_no_seq.focus();   
                            }else{//정상확인시.
                                var prp_shp_nm                  =  ComGetEtcData(sXml,"prp_shp_nm");   //prp_shp_nm  
                                var imdg_clss_cd_desc           =  ComGetEtcData(sXml,"imdg_clss_cd_desc");   //imdg_clss_cd_desc  
                                var imdg_clss_cd                =  ComGetEtcData(sXml,"imdg_clss_cd");   //imdg_clss_cd                         
                                
                                formObj.prp_shp_nm.value        =  prp_shp_nm;   
                                formObj.imdg_clss_cd_desc.value =  imdg_clss_cd_desc;
                                formObj.imdg_clss_cd.Code2      =  imdg_clss_cd; 
                                 
                                if(  callbackEvent != ""){
                                    if( callbackEvent == "btn_Retrieve"){
                                        callbackEvent="";
                                        doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
                                    }
                                }
                            }
                            break;     
                        case IBSEARCH_ASYNC05:  //그리드2 CheckUnNumber
                        
                             fnClearUnnoInfo(sheetObj, pRow);
                             sheetObj.CellValue2(pRow, "sheet2_imdg_un_no_seq") = "";
                             
                             
                             formObj.f_cmd.value = SEARCH01;
                             var param  =  "f_cmd="+formObj.f_cmd.value+"&imdg_un_no="+sheetObj.CellValue(pRow, sheetObj.id+"_imdg_un_no");
                                 param  +=  "&imdg_un_no_seq="+sheetObj.CellValue(pRow, sheetObj.id+"_imdg_un_no_seq");

                             var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
                             var sTotal = ComScgGetTotalValue(sXml);
       
                             if( sTotal == "0"){
                                 ComShowCodeMessage("SCG50010", 'Data');
                                 sheetObj.CellValue2(pRow, sheetObj.id+"_imdg_un_no")   = "";
                                 sheetObj.SelectCell(pRow, sheetObj.id+"_imdg_un_no") ;
                             }else{
                                 sheetObj.SelectCell(pRow, sheetObj.id+"_imdg_un_no_seq") ;
                             }
                             break;
                             
                       case    IBSEARCH_ASYNC06:  //CheckLane
                               formObj.f_cmd.value = SEARCH02;
                               var param  =  "f_cmd="+formObj.f_cmd.value+"&vsl_slan_cd="+sheetObj.CellValue(pRow, sheetObj.id+"_slan_cd");

                               var sXml  =  sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", param);
                               var sTotal = ComScgGetTotalValue(sXml);
                               if( sTotal == "0"){
                                   ComShowCodeMessage("SCG50010", 'Data');
                                   sheetObj.CellValue2(pRow, sheetObj.id+"_slan_cd")   = "";
                                   sheetObj.SelectCell(pRow, sheetObj.id+"_slan_cd") ;
                               }else{
                                   sheetObj.SelectCell(pRow, sheetObj.id+"_slan_cd") ;
                               }
                               break;                            
            }
        }
    

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction, pRow){
    
            with(formObj){
    
                  switch (sAction){
                  
                          case IBSEARCH_ASYNC01: //Carrier Check
                               if( !ComChkRequired(formObj) ){
                                   return false;
                               }
    
                               break;                  
                          case IBSEARCH_ASYNC02: 
                               if( !ComChkRequired(formObj) ){
                                  return false;
                               }else if( formObj.imdg_un_no.value == ""){ 
                                   formObj.imdg_un_no.focus();
                                   formObj.imdg_un_no.select();
                                   return false;
                               }else if( formObj.imdg_un_no_seq.value == ""){  
                                   formObj.imdg_un_no_seq.focus();
                                   formObj.imdg_un_no_seq.select();
                                   return false;
                               }
                              break;   
                          case IBSEARCH_ASYNC03: 
                              if( sheetObj.CellValue(pRow, sheetObj.id+"_imdg_un_no") == "" ){  
                                   return false;
                              }                           
                              if( sheetObj.CellValue(pRow, sheetObj.id+"_imdg_un_no_seq") == "" ){  
                                   return false;
                              }
                              break; 
            
                          case IBSEARCH:  
                              
                              if( !ComChkValid(formObj) ){
                                 return false;
                              }
                              
                              if( formObj.optclass[0].checked ){                            	  
                            	  if(formObj.imdg_clss_cd_desc.value == ""){
	                            	  if( formObj.crr_cd.value == "" || formObj.crr_nm.value == ""){
	                            		  ComShowCodeMessage( "COM12139", " Vessel Operator", " Class"  );
	                                      formObj.crr_cd.focus();
	                                      formObj.crr_cd.select();
	                                      return false;                            		  
	                            	  }
                            	  }
                              }else if( formObj.optclass[1].checked ){
                            	  if( formObj.imdg_un_no.value == ""){
	                                  if( formObj.crr_cd.value == "" || formObj.crr_nm.value == ""){                      
	                                	  ComShowCodeMessage( "COM12139", " Vessel Operator", " UN No./Seq."  );
	                                      formObj.crr_cd.focus();
	                                      formObj.crr_cd.select();
	                                      return false;
	                                  }
                            	  }
                              }

                              break;
  
                   } //END Switch
                   
            }

            return true;
        }
        /************************************User Function *************************************************/
       
       function fnClearUnnoInfo(sheetObj,  row ){
           
               sheetObj.CellValue2(row, sheetObj.id+"_imdg_clss_cd")     = "";
    

               sheetObj.CellValue2(row, sheetObj.id+"_prp_shp_nm")       = "";
               sheetObj.CellValue2(row, sheetObj.id+"_imdg_tec_nm")      = "";
               sheetObj.CellValue2(row, sheetObj.id+"_imdg_pck_grp_cd")  = "";     
           
       }
       /**
        * 입력값에 대한 키 체크 처리 <br>
        * <br><b>Example : </b>
        * <pre>
        *      CheckDup(sheetObj, sheet1_loc_cd|sheet1_rgn_shp_opr_cd) 
        * </pre>
        * @param {Object }  필수, Sheet Object 
        * @param {Object }  필수, 체크할 ColSaveName 
        * @return boolean
        * @see #링크연결
        * @author JKC
        * @version 2009.06.12
        */
        function CheckDup(sheetObj ,ColSaveName){
    
            var Row = sheetObj.ColValueDup( ColSaveName ,false);
            var msg = "";
            if( Row != -1){
                msg = fnMakeMsg(Row, sheetObj);
                ComShowCodeMessage("SCG50010", 'Data');
                if( sheetObj.id == "sheet1"){
                    sheetObj.SelectCell(Row, "sheet1_imdg_clss_cd");
                }else if( sheetObj.id == "sheet2"){
                    sheetObj.SelectCell(Row, "sheet2_imdg_un_no");
                }           
    
                return false;           
            }
            if( sheetObj.id == "sheet1"){
                return CheckDupAddClss(sheetObj);
            }else if( sheetObj.id == "sheet2"){
                return CheckDupAddUnno(sheetObj);
            }
            return true;
        }
        function fnMakeMsg(cRow,sheetObj ){
      
            var rstr_expt_cd = sheetObj.CellValue(cRow, sheetObj.id+"_imdg_crr_rstr_expt_cd");
            
            var msg = "";
            switch (rstr_expt_cd){
                case "P":
                     msg = "[Prohibited or Restrictions]";
                     break;
                case "R":
                    msg = "[Prohibited or Restrictions]";
                     break;
                case "C":
                    msg = "[Excepted fm Class prohibition]";                 
                    break;
                case "T":
                    msg = "[T/S Prohibited]";                            
                    break;
                case "L":
                    var slan_cd = sheetObj.CellValue(cRow, sheetObj.id+"_slan_cd");
                                     
                    msg = "[Prohibited on Lane - "+slan_cd+"]";                    
                    break;                 
            }
            return msg;
        }
        /**
         * 
         * <pre>
         *
         * </pre>
         *
         * @param   sheetObj
         * @return  boolean
         * @author jang kang cheol
         */
        function CheckDupAddClss(sheetObj){
            for(var i=1;i<=sheetObj.RowCount;i++){
                if(sheetObj.RowStatus(i) == "D" ){
                    continue;
                }
    
                if( sheetObj.CellValue(i, sheetObj.id+"_imdg_crr_rstr_expt_cd" ) == "P" ){
                    var mStr = sheetObj.CellValue(i, sheetObj.id+"_imdg_clss_cd" )+"$R";                 
                    for(var j=i+1;j <= sheetObj.RowCount; j++){
                        if(sheetObj.RowStatus(j) == "D"  ){
                            continue; 
                        }                     
                        var sStr =  sheetObj.CellValue(j, sheetObj.id+"_imdg_clss_cd" )+"$"+sheetObj.CellValue(j, sheetObj.id+"_imdg_crr_rstr_expt_cd" )
                        if( mStr ==  sStr){
                            var msg = fnMakeMsg(j, sheetObj);
                            ComShowCodeMessage("SCG50010", 'Data');
                            sheetObj.SelectCell(j, "sheet1_imdg_clss_cd");

                            return false;   
                        }
                    }
                }else if( sheetObj.CellValue(i, sheetObj.id+"_imdg_crr_rstr_expt_cd" ) == "R" ){
                    var mStr = sheetObj.CellValue(i, sheetObj.id+"_imdg_clss_cd" )+"$P";                 
                    for(var j=i+1;j <= sheetObj.RowCount; j++){
                        if(sheetObj.RowStatus(j) == "D"  ){
                            continue;
                        }
                        var sStr =  sheetObj.CellValue(j, sheetObj.id+"_imdg_clss_cd" )+"$"+sheetObj.CellValue(j, sheetObj.id+"_imdg_crr_rstr_expt_cd" )
                        if( mStr ==  sStr){
                            var msg = fnMakeMsg(j, sheetObj);
                            ComShowCodeMessage("SCG50010", 'Data');
                            sheetObj.SelectCell(j, "sheet1_imdg_clss_cd");
    
                            return false;   
                        }
                    }              
                }
            } 
            return true;
        }
        function CheckDupAddUnno(sheetObj){
            for(var i=1;i<=sheetObj.RowCount;i++){
                if(sheetObj.RowStatus(i) == "D" ){
                    continue;
                }
    
                if( sheetObj.CellValue(i, sheetObj.id+"_imdg_crr_rstr_expt_cd" ) == "P" ){
                    var mStr = sheetObj.CellValue(i, sheetObj.id+"_imdg_un_no" )+"$"+sheetObj.CellValue(i, sheetObj.id+"_imdg_un_no_seq" )+"$R";                 
                    for(var j=i+1;j <= sheetObj.RowCount; j++){
                        if(sheetObj.RowStatus(j) == "D"  ){
                            continue;
                        }                     
                        var sStr =  sheetObj.CellValue(j, sheetObj.id+"_imdg_clss_cd" )+"$"+sheetObj.CellValue(j, sheetObj.id+"_imdg_crr_rstr_expt_cd" );
                        if( mStr ==  sStr){
                            var msg = fnMakeMsg(j, sheetObj);
                            ComShowCodeMessage("SCG50010", 'Data');
                            sheetObj.SelectCell(j, "sheet2_imdg_un_no");    
                            return false;   
                        }
                    }
                }else if( sheetObj.CellValue(i, sheetObj.id+"_imdg_crr_rstr_expt_cd" ) == "R" ){
                    var mStr = sheetObj.CellValue(i, sheetObj.id+"_imdg_un_no" )+"$"+sheetObj.CellValue(i, sheetObj.id+"_imdg_un_no_seq" )+"$P";              
                    for(var j=i+1;j <= sheetObj.RowCount; j++){
                        if(sheetObj.RowStatus(j) == "D"  ){
                            continue;
                        }                      
                        var sStr = sheetObj.CellValue(j, sheetObj.id+"_imdg_un_no" )+"$"+sheetObj.CellValue(j, sheetObj.id+"_imdg_un_no_seq" )
                                   +"$"+sheetObj.CellValue(j, sheetObj.id+"_imdg_crr_rstr_expt_cd" );
                        if( mStr ==  sStr){
                            var msg = fnMakeMsg(j, sheetObj);
                            ComShowCodeMessage("SCG50010", 'Data');
                            sheetObj.SelectCell(j, "sheet2_imdg_un_no");                         
                            return false;   
                        }
                    }              
                }
            } 
            return true;
        }     
        function ComLog2(msg){
            var win = document.form.crr_regu_desc_class;
            win.value += "\n"+msg;
        }
        /**
         * optclass 선택시 조회옵션 Enable, Disable 처리
         * 
         * @param void 
         * @param void
         * @return
         */
        function initoptclass(){
            var formObj = document.form;
     
            with(formObj){
                if( optclass[0].checked){ 
                    initClass();
                }
                if( optclass[1].checked){
                    initUnno();
                }
            }
        }
        
        /**
         *  optclass 항목설정으로 인한 조회 옵션 Class style 변경 
         * @return
         */
        function initClass(){
               var formObj = document.form;
    
               formObj.imdg_clss_cd.DisabledBackColor = "#E8E7EC"; 
    
               formObj.imdg_clss_cd.Enable = true;      
    
               formObj.imdg_un_no.className          = 'input2';
               formObj.imdg_un_no.readOnly           = true;
               formObj.imdg_un_no_seq.className      = 'input2';
               formObj.imdg_un_no_seq.readOnly       = true;
    
               
               formObj.crr_regu_desc_unno.readOnly   = true;
               formObj.crr_regu_desc_class.readOnly  = false;  
               
               formObj.imdg_un_no.value           = "";
               formObj.imdg_un_no_seq.value       = "";            
               
               formObj.imdg_un_no_seq.value       = "";
               formObj.prp_shp_nm.value           = "";                
               
               
               document.all.srch_imdg_un_no.src =  '/hanjin/img/btns_search_off.gif';   
               document.all.srch_imdg_un_no.className='';

               fnNewGrid(); 
                   
               if( formObj.crr_cd.value != ""){
                   formObj.imdg_clss_cd.focus(); 
               }else{
                   formObj.crr_cd.focus();
               }           
    
        }   
        
        function initClassBtn(){
            var doc = document.all;
            doc.btn_add.className        = "btn2";
            doc.btn_insert.className     = "btn2";
            doc.btn_copy.className       = "btn2";
            doc.btn_row_delete.className = "btn2";     
            
            doc.btn_add2.className        = "btn2_1";
            doc.btn_insert2.className     = "btn2_1";
            doc.btn_copy2.className       = "btn2_1";
            doc.btn_row_delete2.className = "btn2_1";       
        }
        function initUnnoBtn(){
            var doc = document.all;
            doc.btn_add.className        = "btn2_1";
            doc.btn_insert.className     = "btn2_1";
            doc.btn_copy.className       = "btn2_1";
            doc.btn_row_delete.className = "btn2_1";       
            
            doc.btn_add2.className        = "btn2";
            doc.btn_insert2.className     = "btn2";
            doc.btn_copy2.className       = "btn2";
            doc.btn_row_delete2.className = "btn2";         
        }     
        /**
         *  optclass 항목설정으로 인한 조회 옵션 Class style 변경 
         * @return
         */
        function initUnno(){
           var formObj = document.form;
           formObj.imdg_clss_cd.DisabledBackColor = "#eeeeee"; 
           formObj.imdg_clss_cd.Enable            = false;
           
           
           formObj.imdg_un_no.className           = 'input';
           formObj.imdg_un_no.readOnly            = false;
           formObj.imdg_un_no_seq.className       = 'input';
           formObj.imdg_un_no_seq.readOnly        = false;     
           formObj.srch_imdg_un_no.style.display  = "";        
     
           formObj.crr_regu_desc_unno.readOnly    = false;
           formObj.crr_regu_desc_class.readOnly   = true;   
            
           formObj.imdg_clss_cd.Code2           = "";
     
           formObj.imdg_clss_cd_desc.value      = "";      
           document.all.srch_imdg_un_no.src =  '/hanjin/img/btns_search.gif';   
           document.all.srch_imdg_un_no.className='Cursor';    

           fnNewGrid();
     
           if( formObj.crr_cd.value != ""){
               formObj.imdg_un_no.focus(); 
           }else{
               formObj.crr_cd.focus();
           }
           
        }    
        
        /**
         *  NEW 버튼 처리 
         *  
         * @param void 
         * @param void
         * @return
         */
        function initSetting(){
            var formObj = document.form;
            fnNewGrid();
            formObj.crr_cd.value        = "";
            formObj.crr_nm.value   = "";
            formObj.optclass[0].checked = true;
            formObj.imdg_clss_cd.Code   = "";
            formObj.file_name.value = "";
    
            formObj.imdg_un_no.value        = "";         
            formObj.imdg_un_no_seq.value    = "";
            
            formObj.prp_shp_nm.value        = "";         
      
            formObj.crr_regu_desc_class.value  = "";             
            formObj.crr_regu_desc_unno.value   = "";    
            
            initClass();
            
            initClassBtn(false); 
            initUnnoBtn(false);
    
        }
    
         /**
         * optclass 선택시 조회옵션 Enable, Disable 처리
         * 
         * @param void 
         * @param void
         * @return
         */
        function iniBtn(Yn){
            var formObj = document.form;
            with(formObj){
                initClassBtn(Yn);
                initUnnoBtn(Yn);
            }
        }
       function initClassBtn(Yn){
           var doc = document.all;
           var ClassName = "";
    
           if( Yn ){
               ClassName = "btn2";
           }else{
               ClassName = "btn2_1";           
           }
       }
       function initUnnoBtn(Yn){
           var doc = document.all;
           var ClassName = "";
           if( Yn){
               ClassName = "btn2";
           }else{
               ClassName = "btn2_1";           
           }
       }        

       /**
        * Unno Help 팝업으로 Unno, seq, ClassCd 구하기 
        * @param  {Array} aryPopupData 필수   Array Object
        * @param  {Int} row                선택 선택한 Row
        * @param  {Int} col                선택 선택한 Column
        * @param  {Int} sheetIdx       선택 Sheet Index
        * @return 없음
        */  
        function setUnnoAndClassCd(aryPopupData){ 
        	with(document.form){
        		imdg_clss_cd.Text2   = aryPopupData[0][4]; 
        		imdg_clss_cd_desc.value   = aryPopupData[0][5];    
        		imdg_un_no.value     = aryPopupData[0][2];      
        		imdg_un_no_seq.value = aryPopupData[0][3];                  
        		prp_shp_nm.value     = aryPopupData[0][6]; 
        	}
        } 
         
        /******************* Land by Restriction Status********************/
        /**
         * Lane 의 Enable 처리 Restriction 값에 따라 설정 변경처리한다.
         * @parma void
         * @return void 
         * @author 
         */
        function setLaneEnable(){
            with(sheetObjects[0]){
                for(var i=1;i<= RowCount;i++){
                    if( CellValue(i, id+"_imdg_crr_rstr_expt_cd") == "L" ){ 
                        CellEditable(i, id+"_slan_cd" ) = false;
                    }
                }
            }
            with(sheetObjects[1]){
                for(var i=1;i<= RowCount;i++){
                    if( CellValue(i, id+"_imdg_crr_rstr_expt_cd") == "L" ){ 
                        CellEditable(i, id+"_slan_cd" ) = false;
                    }
                }
            }
    
        }
       
        /************************************Object_event*************************************************/
       
       function sheet1_OnSearchEnd(sheetObj, ErrMsg){
           
           switch (sheetObj.id) {
               case "sheet1":
                     for(var i=1;i<=sheetObj.RowCount;i++){
                         /**************** L:Prohibited on Lane 만 Enable = true else False **************/
                         if( sheetObj.CellValue( i, "sheet1_imdg_crr_rstr_expt_cd") == "L"  ){
                             sheetObj.CellEditable( i, "sheet1_slan_cd") = true;
                         }else{
                             sheetObj.CellEditable( i, "sheet1_slan_cd") = false;
                         }
                     }
                     break;
               case "sheet2":
                     break;
           }
    
       }

       /**
         * Class 콤보 OnChange 이벤트 처리.
         * @param comboObj
         * @param value
         * @param text
         * @return
         */
        function imdg_clss_cd_OnChange(comboObj,value,text) {
     
            var formObj = document.form;
            var aText = text.split("|");
     

            var sText =  comboObj.GetText( value , 1);
    
            if( text == "" ){
                formObj.imdg_clss_cd_desc.value = "";
            }else{
                formObj.imdg_clss_cd_desc.value = sText;
            } 
        }
 
         
         /**
          * 
          * <pre>
          *     EnterKey입력시.
          * </pre>
          *
          * @param   
          * @return
          * @author jang kang cheol
          */
         function imdg_clss_cd_OnKeyDown(comboObj, KeyCode, Shift) {
             var formObj = document.form;
             if( KeyCode == 13){
                 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
             }
         } 
               
        /**
         * Sheet1 OnSelectCell 이벤트 처리
         * @param OldRow
         * @param OldCol
         * @param NewRow
         * @param NewCol
         * @return
         */
        function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
            var formObject = document.form;
            if( OldRow != NewRow ){
                 formObject.crr_regu_desc_class.value = sheetObj.CellValue(sheetObj.SelectRow,  "sheet1_crr_regu_desc");
            }
        }

         /**
          * Sheet2 OnSelectCell 이벤트 처리
          * @param OldRow
          * @param OldCol
          * @param NewRow
          * @param NewCol
          * @return
          */
         function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
              var formObject = document.form;
              if( OldRow != NewRow ){           
                  formObject.crr_regu_desc_unno.value = sheetObj.CellValue(sheetObj.SelectRow,  "sheet2_crr_regu_desc");
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
           if(obj.name == "srch_crr_cd"){
        	   var old_crr_cd = document.form.crr_cd.value;
                ComOpenPopupWithTarget('/hanjin/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.crr_cd), 423, 450, "crr_cd:crr_cd|crr_full_nm:crr_nm", "1,0,1,1,1", true);
                var new_crr_cd = document.form.crr_cd.value;
                
                if(old_crr_cd != new_crr_cd){
               	 popCheck      = "N";
               	 formObj.file_name.value = "";
                }
           }    
     
           if(obj.name == "srch_imdg_un_no"){
                if( obj.className == ""){
                     return;
                }              
                var imdg_un_no = formObj.imdg_un_no.value;
      
                var imdg_un_no_seq =  formObj.imdg_un_no_seq.value;
                ComOpenPopup("/hanjin/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq,940, 420, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true,false);
           }
        }
        /**
         * document.all Object mouse down 처리 
         * @return
         */
        function mouse_down(){
            var obj = event.srcElement;
            var formObj = document.form;
            switch ( obj.id ){
               case "btn_Retrieve":                
                   callbackEvent = "btn_Retrieve";     
               break;
            }
        }
         /**
          * 
          * <pre>
          *    onblur와 Search가 동시 이벤트 발생함.
          * </pre>
          *
          * @param   
          * @return
          * @author jang kang cheol
          */
         function ComKeyEnterControl(){
             if( event.keyCode != 13){return;}
             var obj     = event.srcElement;
             var formObj = document.form;
             switch ( obj.name ){
                case "crr_cd":
                    oneventing ="Y";
                    if( !ComChkValid(formObj) ){
                        oneventing ="N";
                        return;
                    }else{                        
                        callbackEvent="btn_Retrieve";                     
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
                    }
                    oneventing ="N";
                    break;
    
                default:
                     ComKeyEnter();
                     break;
             }      
             
         }
        /**
         * Form Object obj_keypress 이벤트시 처리
         * @param  void
         * @return void
         */     
         function obj_keypress (){
             var obj = event.srcElement;
    
             switch (obj.name){
                  case 'crr_cd':
                        ComKeyOnlyAlphabet('upper');
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
          /**
           * 
           * <pre>
           *     조회후 후처리 사용자함수,.
           * </pre>
           *
           * @param   sheetObj
           * @return  void
           * @author jang kang cheol
           */
         function fnSearchEnd(sheetObj){
             switch ( sheetObj.id ){
                 case "sheet2" :
                     sheetObj.ColHidden("sheet2_imdg_tec_nm") = true;                  
                     for(var i=1;i<=sheetObj.RowCount;i++){
                         if( sheetObj.CellValue(i,"sheet2_imdg_tec_nm") != ""){                          
                             sheetObj.ColHidden("sheet2_imdg_tec_nm") = false;
                             return;
                         }
                     }
                     sheetObj.ColWidth("sheet2_prp_shp_nm") = 480;
                     break;
             }
         }
         /**
          * Form Object  keydown 이벤트시 처리
          * @param  void
          * @return void
          */     
          function obj_keyup(){
               
               var obj = event.srcElement;
               var formObj = document.form;
    
               switch (obj.name){
                  case 'crr_cd':
                        fnNewGrid();                      
                        formObj.imdg_clss_cd.Text2        = "";         
                        formObj.imdg_clss_cd_desc.value   = "";
                        formObj.imdg_un_no.value          = "";                     
                        formObj.imdg_un_no_seq.value      = "";
                        formObj.prp_shp_nm.value          = "";  
                        formObj.crr_regu_desc_class.value = "";                     
                        formObj.crr_regu_desc_unno.value  = "";  
                        

                        if( formObj.crr_cd.value.length  > 3    ){
                        /****************SearchXml시 OnBlur 발생 막기 플래그 수행****************/
                              if( oneventing == "N" ){
                                oneventing =  "Y";
                                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
                                oneventing = "N";
                              }                           
                        }else{

                              formObj.crr_nm.value = '';
                              iniBtn(false);                          
                        }
                        break;
                  
                  case 'imdg_un_no':
                        fnNewGrid();                      
                        formObj.crr_regu_desc_class.value = "";                     
                        formObj.crr_regu_desc_unno.value  = "";
                        
                        formObj.imdg_un_no_seq.value    = "";
                        formObj.prp_shp_nm.value        = "";      
                        formObj.imdg_clss_cd.Text2      = "";
                        formObj.imdg_clss_cd_desc.value = "";                        
                        if( formObj.imdg_un_no.value.length == 4  ){   

                            doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC02);
                        }
                        break;  

                  case 'imdg_un_no_seq':
                      formObj.imdg_clss_cd.Text2      = "";
                      formObj.imdg_clss_cd_desc.value = "";
                      fnNewGrid();                        
                      formObj.prp_shp_nm.value = "";
                      formObj.crr_regu_desc_class.value = "";                     
                      formObj.crr_regu_desc_unno.value  = "";                     
                      break;
                  
               }            
          }  
          /**
           * Form Object  onchange 이벤트시 처리
           * @param  void
           * @return void
           */     
           function obj_change(){
               var obj = event.srcElement;
               var formObj = document.form;
               switch (obj.name){
                      case 'crr_regu_desc_class':
                          sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "sheet1_crr_regu_desc") = document.form.crr_regu_desc_class.value;    
                          break;
                      case 'crr_regu_desc_unno':
                          sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "sheet2_crr_regu_desc") = document.form.crr_regu_desc_unno.value;    
                          break;

               }
           }           
        /**
         * Form Object  blur 이벤트시 처리
         * @param  void
         * @return void
         */     
         function obj_blur (){
    
               if( oneventing == "Y"){return;}
               var obj = event.srcElement;
               var formObj = document.form;
    
               switch (obj.name){
                  case "crr_cd":
                	  if( formObj.crr_cd.value.length  >= 3 ){
                		  if( oneventing == "N" ){
                			  oneventing =  "Y";
                			  doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
                			  oneventing = "N";
                		  }
                	  }else{
                		  if( formObj.crr_cd.value !=""   ){           
                			  if( !ComChkValid(formObj) ){
                				  obj.focus();
                				  obj.select();
                				  return;
                			  }
                			  return;
                		  }
                	  }
                	  break;
                  case "imdg_un_no":
                	  if( !ComChkObjValid(formObj.imdg_un_no) ){
                		  obj.focus(); 
                          obj.select();  
                      } 
                      break;
                  case "imdg_un_no_seq":
                       if( oneventing == "N" ){
                            formObj.prp_shp_nm.value = "";
                            if( formObj.imdg_un_no.value.length  == 4  && formObj.imdg_un_no_seq.value.length  != ""    ){
                                oneventing =  "Y";                                  
                                doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC04); 
                                oneventing = "N";
                            }
                       }
                       break;
               }
         }

         /**
         * Form Object  OnChange 이벤트 처리.
         * @param  void
         * @return void
         */     
         function obj_click(){
            obj = event.srcElement;
            var formObj = document.form;
            var doc     = document.all;
            switch(obj.name ) {
               case "optclass":
                   initoptclass();                 
                   if(obj.value == "class"){    
                       doc.div_s1.style.display = "";                    
                       doc.div_s2.style.display = "none";
                       formObj.crr_regu_desc_class.value = "";
                   }
                   if(obj.value == "unno"){
                       doc.div_s1.style.display = "none";                    
                       doc.div_s2.style.display = "";          
                       formObj.crr_regu_desc_unno.value = "";                    
                   }
                   break;
            } // end switch
         }
    
       /* 개발자 작업  끝 */