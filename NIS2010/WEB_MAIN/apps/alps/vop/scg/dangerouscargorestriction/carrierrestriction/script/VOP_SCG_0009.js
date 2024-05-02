/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0009.js
*@FileTitle : VSL OPR's Restriction on DG (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.09 장강철 jkc
* 1.0 Creation
* 2012.04.20 서석진 [CHM-201216960-01] Vessl Operator내 파일첨부 기능 추가
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
     * @class vop_scg_0009 : vop_scg_0009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0009() {
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

     	 try {
     		var srcName  = window.event.srcElement.getAttribute("name");
     		var optclass = window.event.srcElement.getAttribute("optclass");
     		var doc      = document.all;
 
  		
             switch(srcName) {
             

             
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					break;
 					
				case "btn_add":
					 if( !formObject.optclass[0].checked ){
                        return;
					 }					
		             if( doc.btn_add.className == "btn2_1"){
		                 return;
		             }   
			         
		             var Row  =  sheetObjects[0].DataInsert(-1);
					sheetObjects[0].SelectCell( Row ,"sheet1_imdg_clss_cd");
 					break;					
 
				case "btn_add2":
					if( !formObject.optclass[1].checked ){
                        return;
					}					
                    if( doc.btn_add2.className == "btn2_1"){
                        return;
                    }   					
                    var Row = sheetObjects[1].DataInsert(-1);
					sheetObjects[1].SelectCell(  Row ,"sheet2_imdg_un_no");
					break;
					
				case "btn_insert":
					if( !formObject.optclass[0].checked ){
                        return;
					}					
                    if( doc.btn_insert.className == "btn2_1"){
                        return;
                    }   					
 					var Row  = sheetObjects[0].DataInsert();
 					sheetObjects[0].SelectCell(  Row, "sheet1_imdg_clss_cd"); 	 
 					break;
 
				case "btn_insert2":
					if( !formObject.optclass[1].checked ){
                        return;
					}			
                    if( doc.btn_insert2.className == "btn2_1"){
                        return;
                    }  					
                    var Row  =  sheetObjects[1].DataInsert();
 					sheetObjects[1].SelectCell(  Row ,"sheet2_imdg_un_no"); 	 					
 					break;
 
					
				case "btn_copy":
					if( !formObject.optclass[0].checked ){
                        return;
					}		
                    if( doc.btn_copy.className == "btn2_1"){
                        return;
                    }  					
				    var row = sheetObjects[0].DataCopy(); 	
                    sheetObjects[0].SelectCell( row,"sheet1_imdg_clss_cd");        				    
 					break;					 
 
					break; 
				case "btn_copy2":
					if( !formObject.optclass[1].checked ){
                        return;
					}		
                    if( doc.btn_copy2.className == "btn2_1"){
                        return;
                    } 					
				    var row = sheetObjects[1].DataCopy(); 		
                    sheetObjects[1].SelectCell( row,"sheet2_imdg_un_no");        
 
 					break;
 				
						
 				case "btn_New":
  					
 					doActionIBSheet(sheetObjects[0],document.form,IBRESET);
 					break;
 					
 				case "btn_row_delete":
					if( !formObject.optclass[0].checked ){
                        return;
					}	 				
                    if( doc.btn_row_delete.className == "btn2_1"){
                        return;
                    }   					
					if(   formObject.optclass[0].checked ){
                        ComRowHideDelete(sheetObjects[0], "sheet1_Sel");
					}
 
					break;
 					
 				case "btn_row_delete2":
					if( !formObject.optclass[1].checked ){
                        return;
					}	
                    if( doc.btn_row_delete2.className == "btn2_1"){
                        return;
                    }  					
					if( formObject.optclass[1].checked ){
                        ComRowHideDelete(sheetObjects[1], "sheet2_Sel");
					}
					break;
					
				case "btn_DownExcel":
					if( formObject.optclass[0].checked ){
						sheetObjects[0].SpeedDown2Excel(-1,false,true,"","",false,false,"Restrictions on Class",false);
					}else{
		 				sheetObjects[1].SpeedDown2Excel(-1,false,true,"","",false,false,"Restrictions on UN No.",false);
		 			}	
					
					break; 
 					
 				case "btn_Save":
		 			if( formObject.optclass[0].checked ){
		 				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
		 			}else{
		 				doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
		 			}	 					
 					break;
 				case "btn_filePop":
 					if(popCheck == "Y"){
					ComOpenPopup('/hanjin/VOP_SCG_0079.do?vsl_opr_tp_cd='+document.form.crr_cd.value+'&seachCheck=N', 605,490, "setFileUpload", 'none', true);	
					reload();
 					}
 				
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
     function initControl() {
         var form = document.form;
    	 axon_event.addListenerForm('keypress','obj_keypress',    form  );
         axon_event.addListenerForm('keydown','ComKeyEnterControl',  form,"crr_regu_desc_class|crr_regu_desc_unno"  );
 
 	     axon_event.addListenerForm('blur',    'obj_blur'      ,form); //- 포커스 나갈때
         axon_event.addListenerForm('keyup',   'obj_keyup',     form ); 	     
         axon_event.addListenerForm('click',   'obj_click',   	form);   

         axon_event.addListenerForm('change',  'obj_change',   	form);           
        
         axon_event.addListener    ('click',   'img_click',   	"srch_imdg_un_no");
         axon_event.addListener    ('click',   'img_click',   	"srch_crr_cd"    ); 
         
         //axon_event.addListener    ('mousedown', 'mouse_down',   "btn_Retrieve");   
 

         
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
                     style.height = 287;
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
                     var HeadTitle = "|Sel.|Class|Definitions|Restrictions|Lane||||";
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(HeadTitle.split("|").length, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     var prefix = "sheet1_"; 
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	  daCenter,	false,	prefix+"ibflag");
                     InitDataProperty(0, cnt++ , dtCheckBox,		30,	  daCenter,	false,	prefix+"Sel",				           false,	"",		dfNone,			0,			true,		true);
                     InitDataProperty(0, cnt++ , dtCombo,        	60,   daCenter, false,  prefix+"imdg_clss_cd",                 true,    "",     dfNone,         0,          true,       true)
                     InitDataProperty(0, cnt++ , dtData,			690,  daLeft,	false,	prefix+"imdg_clss_cd_desc",            false,	"",		dfNone,			0,			false,		false, 100);
                     InitDataProperty(0, cnt++ , dtCombo,	    	120,  daLeft,	false,	prefix+"imdg_crr_rstr_expt_cd",        false,	"",		dfNone,			0,			true,		true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	60,	  daCenter,	false,	prefix+"slan_cd",			           false,	"",		dfEngUpKey,	    0,			false,		false,   3);
                     InitDataProperty(0, cnt++ , dtHidden,			90,	  daLeft,	false,	prefix+"crr_regu_desc",		           false,	"",		dfNone,			0,		    false,	    false); 
                     InitDataProperty(0, cnt++ , dtHidden,			90,	  daLeft,	false,	prefix+"vsl_opr_tp_cd",		           false,	"",		dfNone,			0,		    false,	    false);
                     InitDataProperty(0, cnt++ , dtHidden,			90,	  daLeft,	false,	prefix+"imdg_crr_rstr_seq",	           false,	"",		dfNone,			0,		    false,	    false); 					
                     InitDataProperty(0, cnt++ , dtHidden,	    	90,	  daLeft,	false,	prefix+"row_seq",	                   false,	"",		dfNone,			0,		    false,	    false); 					
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
                     style.height = 287;
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

                     var HeadTitle = "|Sel.|Class|UN No./Seq.|UN No./Seq.|Proper Shipping Name|Technical Name|Sub\nRisks|Packing\nGroup|Restrictions|Lane|regu_desc|vsl_opr_tp_cd|imdg_crr_rstr_seq";

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo( HeadTitle.split("|").length , 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);
                      
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     var prefix = "sheet2_";
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	  daCenter,	false,	prefix+"ibflag");
                     InitDataProperty(0, cnt++ , dtCheckBox,		30,	  daCenter,	false,	prefix+"Sel",		            false,	"",		dfNone,			0,			true,		true);
                     InitDataProperty(0, cnt++ , dtData,		    40,	  daCenter,	false,	prefix+"imdg_clss_cd",	        false,	"",		dfNone,			0,			false,		false);
                     InitDataProperty(0, cnt++ , dtData,		    45,	  daCenter,	false,	prefix+"imdg_un_no",		    true,	"",		dfNone,         0,			true,		true, 4);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	40,	  daCenter,	false,	prefix+"imdg_un_no_seq",		true,	"",		dfNumber,		0,			true,		true, 2);
                     InitDataProperty(0, cnt++ , dtData,		   	360,  daLeft,	false,	prefix+"prp_shp_nm",	        false,	"",		dfNone,			0,			false,		false);
                     InitDataProperty(0, cnt++ , dtData,		   	120,  daLeft,	false,	prefix+"imdg_tec_nm",	        false,	"",		dfNone,			0,			false,		false);
                     InitDataProperty(0, cnt++ , dtData,         	60,   daCenter, false,  prefix+"imdg_subs_rsk_lbl_cd",  false,  "",     dfNone,         0,          false,      false);				 	
                     InitDataProperty(0, cnt++ , dtData,		    55,	  daCenter,	false,	prefix+"imdg_pck_grp_cd",	    false,	"",		dfNone,			0,			false,		false);
                     InitDataProperty(0, cnt++ , dtCombo,	   		150,  daLeft,	false,	prefix+"imdg_crr_rstr_expt_cd",	false,	"",		dfNone,			0,			true,		true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,		60,	  daCenter,	false,	prefix+"slan_cd",		        false,	"",		dfEngUpKey,	    0,			false,		false, 3);
                     InitDataProperty(0, cnt++ , dtHidden,			90,	  daLeft,	false,	prefix+"crr_regu_desc",		    false,	"",		dfNone,			0,		   false,	   false);
                     InitDataProperty(0, cnt++ , dtHidden,			90,	  daLeft,	false,	prefix+"vsl_opr_tp_cd",		   false,	"",		dfNone,			0,		   false,	   false);
                     InitDataProperty(0, cnt++ , dtHidden,			90,	  daLeft,	false,	prefix+"imdg_crr_rstr_seq",	   false,	"",		dfNone,			0,		   false,	   false); 					
   
                     InitDataValid(0, "sheet2_imdg_un_no"     , vtNumericOnly);
                     InitDataValid(0, "sheet2_slan_cd"        , vtEngUpOnly);    
                     HeadRowHeight 	= 28;

                     ShowButtonImage = 1;
                     CountPosition   = 2;
                     MultiSelection  = false;
                     ExtendLastCol   = false;
 			   }
                 break;
         }
     }
       
     var aEtcData     =  "";
     var aEtcDataAll  =  "";
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

			           aEtcData     =  ComGetEtcData(sXml ,"codeinfo").split("##");
			           aEtcDataAll  =  ComGetEtcData(sXml ,"codeinfoAll").split("##");
			           
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
                   	   //formObj.grp_cd.Enable = false;
    
                   	   formObj.crr_cd.focus();
                   	   

					   break;
 
			                
		              case IBSEARCH:      //조회
	                         if(!validateForm(sheetObj,formObj,sAction)){ 
					 		      return;
					 		 }
				             if( formObj.optclass[0].checked ){
				            	   with( sheetObjects[0] ){
								       formObj.f_cmd.value = SEARCH01;  
						 
					         		   var param     =  "f_cmd="+formObj.f_cmd.value+"&imdg_clss_cd="+formObj.imdg_clss_cd.Text;
					         		       param    +=  "&imdg_un_no="+formObj.imdg_un_no.value;
					         		       param    +=  "&imdg_un_no_seq="+formObj.imdg_un_no_seq.value;
					         		       param    +=  "&crr_cd="+formObj.crr_cd.value;						         		       
					     
					         		       param    +=  "&optclass=class";
					         		      
					  				   var aryPrefix =  new Array( "sheet1_" );
					  				   var sXml      =  GetSearchXml("VOP_SCG_0009GS.do", param+ "&" + ComGetPrefixParam( aryPrefix ) );
					  				  
					  				   formObj.file_name.value = ComGetEtcData(sXml, "fimename");
					  				  
					  				   LoadSearchXml(sXml);
                                       fnSearchEnd(sheetObjects[0]);
                                     /***********************************TXT AREA Setting***********************************************/
					  				   formObj.crr_regu_desc_class.value = CellValue(SelectRow, id+"_"+"crr_regu_desc");
					  				   //Class에서는 Vessel Operator에 상관없이 T/S Prohibited를 보여주지 않는다.
					  				   //if (formObj.crr_cd.value != "SML") {
					  					   var comText = aEtcData[1].split("|");
					  					   var comCode = aEtcData[0].split("|");
					  					   comText = comText[1]+"|"+comText[2]+"|"+comText[4]+"|";
					  					   comCode = comCode[0]+"|"+comCode[1]+"|"+comCode[3]+"|";
					  					   sheetObjects[0].InitDataCombo(0,  "sheet1_imdg_crr_rstr_expt_cd", comText, comCode   );
					  				   //}else{
								       //    sheetObjects[0].InitDataCombo(0,  "sheet1_imdg_crr_rstr_expt_cd", aEtcData[1], aEtcData[0]   );					  					   
					  				   //}
				                   }   
						           iniBtn('C');
				              }else if( formObj.optclass[1].checked ){
					               with( sheetObjects[1] ){			            	  
							           formObj.f_cmd.value = SEARCH01;  
					         		   var param     =  "f_cmd="+formObj.f_cmd.value+"&imdg_clss_cd="+formObj.imdg_clss_cd.Text;
 
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
 
				  				       /********SHOW_MSG에 값이 있을경우 DATA DISP 보다 먼저 메세지 보인다.*******/
				  				       if(SHOW_MSG != ""){
									       ComShowMessage( sMsg);
									       sXml = ComDeleteMsg(sXml);
				  				       }else{
				  				    	   
				  				       }
				  				       LoadSearchXml(sXml);	
				  				       fnSearchEnd(sheetObjects[1]);
					  				   formObj.crr_regu_desc_unno.value = CellValue(SelectRow, id+"_"+"crr_regu_desc");	
					  				   if (formObj.crr_cd.value != "SML") {
					  					   var comText = aEtcDataAll[1].split("|");
					  					   var comCode = aEtcDataAll[0].split("|");
					  					   comText = comText[1]+"|"+comText[2]+"|"+comText[3]+"|"+comText[5]+"|";
					  					   comCode = comCode[0]+"|"+comCode[1]+"|"+comCode[2]+"|"+comCode[4]+"|";
						                   sheetObjects[1].InitDataCombo(0,  "sheet2_imdg_crr_rstr_expt_cd", comText, comCode   );
					  				   }else{
						                   sheetObjects[1].InitDataCombo(0,  "sheet2_imdg_crr_rstr_expt_cd", aEtcDataAll[1], aEtcDataAll[0]   );					  					   
					  				   }
					               }
						           iniBtn('U');
				              }
					          /******************* Land by Restriction Status********************/
                              setLaneEnable();						              
	 					   break;
 
		 			 case IBSAVE:        //저장
 
			 			 if(!validateForm(sheetObj,formObj,sAction)){ 
			 			    return;
			 			 }
 
			 			 formObj.f_cmd.value = MULTI01;
			 			 var sheetName = "";
			 			 if( formObj.optclass[0].checked ){
			 				sheetName = "sheet1_";
			 			 }else{
			 		 		sheetName = "sheet2_";
			 			 }
			 			 var aryPrefix       =  new Array(sheetName);
 			 			 var sParam          =  ComGetSaveString(sheetObjects, true, true);
			 			 if( sParam == ""){ return;}
 			 			 sParam  +=  "&"+FormQueryString(formObj) +"&" + ComGetPrefixParam( aryPrefix );

			 			 var sXml   =  sheetObj.GetSaveXml( "VOP_SCG_0009GS.do", sParam);
 	 			 		 sheetObj.LoadSaveXml(sXml);
 	 			 		 reload();
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
							 //iniBtn(true); 
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
                    	     
                    	     var imdg_tec_nm =   ComScgGetRowValue(sXml, 1, "imdg_tec_nm");  
                             if( imdg_tec_nm != "" ){                          
                                 sheetObj.ColHidden("sheet2_imdg_tec_nm" ) = false;
                                 sheetObj.ColWidth ("sheet2_prp_shp_nm"  ) = 380;   
                             }
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
       				       if( formObj.crr_cd.value == "" || formObj.crr_nm.value == "" ){       				 
							   ComShowCodeMessage( "COM12113", " Vessel Operator.."  );
							   formObj.crr_cd.focus();
							   formObj.crr_cd.select();
							   return false;
       				       }
						   break;
       				  case IBSAVE:
//						   if( !ComChkRequired(formObj) ){
//							   return false;
//						   }
//						   if( sheetObj.GetSaveString(false) == ""  ){return false;}
		            	   var cByte = ComGetLenByByte(formObj.crr_regu_desc_class  );
		            	   if ( cByte > 500  ){
		            		   ComShowCodeMessage("COM12142", "", "500byte (Current:"+cByte+")");
		            		   formObj.crr_regu_desc_class.focus();
		            		   formObj.crr_regu_desc_class.select();
		            		   return false;
		            	   }
		            	   if( formObj.optclass[0].checked ){
		            	       for(var i=1;i<=sheetObj.RowCount;i++){
		            	           if( sheetObj.CellValue(i, "sheet1_imdg_crr_rstr_expt_cd") == "L"  ){
		            	               if( sheetObj.CellValue(i, "sheet1_slan_cd") == ""  ){
		            	                   ComShowCodeMessage("SCG50007", "Lane");
		            	                   sheetObj.SelectCell(i, "sheet1_slan_cd");
		            	                   return false;
		            	               }
		            	           }
		            	       }
                    			var dupRow = sheetObj.ColValueDupRows("sheet1_imdg_clss_cd|sheet1_imdg_crr_rstr_expt_cd|sheet1_slan_cd", false, true);
                     			if(dupRow != "") {
                    				ComShowCodeMessage('SCG50005', 'Data');
                    				if (sheetObj.RowStatus(dupRow.split("|")[0])=="R") {
                    					sheetObj.SelectCell(dupRow.split("|")[1], "sheet1_imdg_clss_cd");
                    				}else{
                    					sheetObj.SelectCell(dupRow.split("|")[0], "sheet1_imdg_clss_cd");
                    				}
                    				return;
                     			}
		            	   }
		            	   if( formObj.optclass[1].checked ){
                               for(var i=1;i<=sheetObj.RowCount;i++){
                                   if( sheetObj.CellValue(i, "sheet2_imdg_crr_rstr_expt_cd") == "L"  ){
                                       if( sheetObj.CellValue(i, "sheet2_slan_cd") == ""  ){
                                           ComShowCodeMessage("SCG50007", "Lane");
                                           sheetObj.SelectCell(i, "sheet2_slan_cd");
                                           return false;
                                       }
                                   }
                               }
                               
                     			var dupRow = sheetObj.ColValueDupRows("sheet2_imdg_un_no|sheet2_imdg_un_no_seq|sheet2_imdg_crr_rstr_expt_cd|sheet2_slan_cd", false, true);
                     			if(dupRow != "") {
                    				ComShowCodeMessage('SCG50005', 'Data');
                    				if (sheetObj.RowStatus(dupRow.split("|")[0])=="R") {
                    					sheetObj.SelectCell(dupRow.split("|")[1], "sheet2_imdg_un_no");
                    				}else{
                    					sheetObj.SelectCell(dupRow.split("|")[0], "sheet2_imdg_un_no");
                    				}
                    				return;
                     			}
		            	   }
		                   if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
	                           return false;   
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
     function iniBtn(Type){
         var formObj = document.form;
         with(formObj){
        	 if (Type == 'C') {
        		 initClassBtn(true);
        	 }else{
        		 initUnnoBtn(true);
        	 }
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
        
        doc.btn_add.className        = ClassName;
        doc.btn_insert.className     = ClassName;
        doc.btn_copy.className       = ClassName;
        doc.btn_row_delete.className = ClassName;     
    
    }
    function initUnnoBtn(Yn){
        var doc = document.all;
        var ClassName = "";
        if( Yn){
            ClassName = "btn2";
        }else{
            ClassName = "btn2_1";           
        }
 

        
        doc.btn_add2.className        = ClassName;
        doc.btn_insert2.className     = ClassName;
        doc.btn_copy2.className       = ClassName;
        doc.btn_row_delete2.className = ClassName;          
    }        
     /**
      * Sheet1 OnPopupClick 이벤트 처리에 대한 CallBack 함수 
      * @param aryPopupData
      * @param row
      * @param col
      * @param seetIdx 
      * @return
      */
     function setSheet1_PopupCallback_SlanCd(aryPopupData,row, col, seetIdx){
    	 sheetObjects[seetIdx].CellValue2(row, col) = aryPopupData[0][1];
     }
     /**
     * Sheet2 OnPopupClick 이벤트 처리에 대한 SlanCd CallBack 함수 
     * @param aryPopupData
     * @param row
     * @param col
     * @param seetIdx 
     * @return
     */     
     function setSheet2_PopupCallback_SlanCd(aryPopupData,row, col, seetIdx){
    	 sheetObjects[seetIdx].CellValue2(row, col) = aryPopupData[0][1];
     }
     /**
     * Sheet2 OnPopupClick ImdgUnNoSeq 이벤트 처리에 대한 CallBack 함수 
     * @param aryPopupData
     * @param row
     * @param col
     * @param seetIdx 
     * @return
     */
     function setSheet2_PopupCallback_ImdgUnNoSeq(aryPopupData,row, col, seetIdx){
 
    	 sheetObjects[seetIdx].CellValue2(row, "sheet2_imdg_un_no")    = aryPopupData[0][2];//UnNo
    	 sheetObjects[seetIdx].CellValue2(row, "sheet2_imdg_un_no_seq") = aryPopupData[0][3];//UnNoSeq
    	 sheetObjects[seetIdx].CellValue2(row, "sheet2_imdg_clss_cd")  = aryPopupData[0][4];//ClassCd
 	 
    	 sheetObjects[seetIdx].CellValue2(row, "sheet2_prp_shp_nm")    = aryPopupData[0][6]; 
    	 sheetObjects[seetIdx].CellValue2(row, "sheet2_imdg_tec_nm")    = aryPopupData[0][7];  
    	 sheetObjects[seetIdx].CellValue2(row, "sheet2_imdg_pck_grp_cd")    = aryPopupData[0][8];   
 
  
         if( sheetObjects[seetIdx].CellValue(row,"sheet2_imdg_tec_nm") != ""){                          
             sheetObjects[seetIdx].ColHidden("sheet2_imdg_tec_nm") = false;
             sheetObjects[seetIdx].ColWidth("sheet2_prp_shp_nm"  ) = 380;   
         }
 
     }
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
            		 CellEditable(i, id+"_slan_cd" ) = true;
            	 }
             }
         }
         with(sheetObjects[1]){
             for(var i=1;i<= RowCount;i++){
            	 if( CellValue(i, id+"_imdg_crr_rstr_expt_cd") == "L" ){ 
            		 CellEditable(i, id+"_slan_cd" ) = true;
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
		    if( sheetObj.ColSaveName(Col) == sheetObj.id+'_slan_cd' ){
		        var lane_cd = "";//sheetObj.CellText(Row, Col);
				ComOpenPopup('/hanjin/VOP_VSK_0202.do', 426, 475, "setSheet1_PopupCallback_SlanCd", "0,0", true, false, Row, Col, 0);
		    }
 		}
 	}     
    /**
    * Sheet2 OnPopupClick 이벤트 처리  
    * @param sheetObj
    * @param Row
    * @param Col
    * @return
    */
   function sheet2_OnPopupClick(sheetObj, Row, Col)
	{
		with(sheetObj)
		{
		    if( sheetObj.ColSaveName(Col) == sheetObj.id+'_imdg_un_no_seq' ){
	   	    	 var imdg_un_no     =  sheetObj.CellText(Row,  sheetObj.id+'_imdg_un_no'     );
 	  	    	 var imdg_un_no_seq =  sheetObj.CellText(Row,  sheetObj.id+'_imdg_un_no_seq' );
 			     ComOpenPopup("/hanjin/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq,
 			    		940, 420, "setSheet2_PopupCallback_ImdgUnNoSeq", "0,1,1,1,1,1,1,1", true,true, Row, Col, 1);
		    }
		    if( sheetObj.ColSaveName(Col) == sheetObj.id+'_slan_cd' ){
		        var lane_cd = "";//sheetObj.CellText(Row, Col);
				ComOpenPopup('/hanjin/VOP_VSK_0202.do?lane_cd='+lane_cd, 426, 475, "setSheet2_PopupCallback_SlanCd", "0,0", true, false, Row, Col, 1);
		    }
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
         // formObj.imdg_clss_cd.style.ime-mode="disabled";
          if( KeyCode == 13){
              doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
          }
      } 
 
    /**
     * Sheet1 콤보 OnChange 이벤트 처리.
     * @param comboObj
     * @param value
     * @param text
     * @return
     */
     function sheet1_OnChange(sheetObj, row, col) {
    	 switch( sheetObj.ColSaveName(col)  ){
    	       case 'sheet1_imdg_clss_cd' :
    	            var SelectedIndex = sheetObj.GetComboInfo(row, col, "SelectedIndex");
                    var sText = sheetObj.GetComboInfo(row, col, "Text");
                    var aText = sText.split("|");
                    var aSelectedText = aText[SelectedIndex].split("\t");
    	    	    sheetObj.CellValue2(row, "sheet1_imdg_clss_cd_desc") =  aSelectedText[1];
    	            break;
    	       case 'sheet1_imdg_crr_rstr_expt_cd':
    	        	if( sheetObj.CellValue(row, sheetObj.id+"_imdg_crr_rstr_expt_cd") == "L" ){ 
    	        		 sheetObj.CellEditable(row, sheetObj.id+"_slan_cd" ) = true;
                         sheetObj.SelectCell (row,  sheetObj.id+"_slan_cd");
    	        	}else{
    	        		 sheetObj.CellValue2(row, sheetObj.id+"_slan_cd") = "";
    	        		 sheetObj.CellEditable(row, sheetObj.id+"_slan_cd" ) = false;
    	        	}
   	                break;
               case 'sheet1_slan_cd' :
                   if( sheetObj.CellValue != "" ){
                       if( sheetObj.EditValue.length != 3){
                           ComShowCodeMessage("SCG50006","Lane","3" );
                           sheetObj.CellValue2(row, sheetObj.id+"_slan_cd") = "";
                           sheetObj.SelectCell(row, sheetObj.id+"_slan_cd");
                       }
                   }
                   break;          
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
       * 
       * <pre>
       *     Sheet1 OnKeyUp 이벤트 처리
       * </pre>
       *
       * @param   
       * @return
       * @author jang kang cheol
       */
     function  sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
          var formObj = document.form;
          if( KeyCode == 229){return;}
          
          switch( sheetObj.ColSaveName(Col)  ){
                 case 'sheet1_slan_cd' :
                       if( sheetObj.EditValue.length == 3){
                           sheetObj.CellValue2(Row, "sheet1_slan_cd")  = sheetObj.EditValue;
                           doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC06, Row);                            
                       }
                       break;
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
      * Sheet2 콤보 OnChange 이벤트 처리.
      * @param comboObj
      * @param value
      * @param text
      * @return
      */
	function sheet2_OnChange(sheetObj, Row, Col) {
	var formObj = document.form;
		switch( sheetObj.ColSaveName(Col)  ){
			case 'sheet2_imdg_crr_rstr_expt_cd':
				if( sheetObj.CellValue(Row, sheetObj.id+"_imdg_crr_rstr_expt_cd") == "L" ){ 
					sheetObj.CellEditable(Row, sheetObj.id+"_slan_cd" ) = true;
					sheetObj.SelectCell (Row,  sheetObj.id+"_slan_cd");
				}else{
					sheetObj.CellValue2(Row, sheetObj.id+"_slan_cd") = "";
					sheetObj.CellEditable(Row, sheetObj.id+"_slan_cd" ) = false;
				}
				break;
			case 'sheet2_imdg_un_no_seq' :
				doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC03, Row);
				break;
			case 'sheet2_imdg_un_no' :
				if( sheetObj.CellValue != "" ){
					if( sheetObj.EditValue.length != 4){
						ComShowCodeMessage( "SCG50006","UN No.","4" );         
						sheetObj.CellValue2(Row, sheetObj.id+"_imdg_un_no") = "";                            
						sheetObj.SelectCell(Row, sheetObj.id+"_imdg_un_no");
					}
				}
				break;
			case 'sheet2_slan_cd' :
				if( sheetObj.CellValue != "" ){
					if( sheetObj.EditValue.length != 3){
						ComShowCodeMessage( "SCG50006","Lane","3" );         
						sheetObj.CellValue2(Row, sheetObj.id+"_slan_cd") = "";                            
						sheetObj.SelectCell(Row, sheetObj.id+"_slan_cd");
					}
				}
				break;                      
		}
	}
    
	function  sheet2_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
    	   var formObj = document.form;
    	   if( KeyCode == 229){return;}
    	   
      	   switch( sheetObj.ColSaveName(Col)  ){
                  case 'sheet2_imdg_un_no' :
       	    	        if( sheetObj.EditValue.length == 4){
       	    	        	fnClearUnnoInfo(sheetObj, Row);
       	    	        	sheetObj.CellValue2(Row, "sheet2_imdg_un_no")  = sheetObj.EditValue;
       	    	        	sheetObj.CellValue2(Row, "sheet2_imdg_un_no_seq")  = "";
                            doActionIBSheet(sheetObjects[1], formObj,IBSEARCH_ASYNC05, Row);       	    	        	
    	    	        }
                        break;
                  case 'sheet2_imdg_un_no_seq' :
                	    if( sheetObj.CellValue (Row, "sheet2_imdg_un_no") == "" ){
                	         ComShowCodeMessage( "SCG50010", 'Data'  );        	        
                	         sheetObj.CellValue2(Row, "sheet2_imdg_un_no_seq") = "";
                	         sheetObj.SelectCell(Row, "sheet2_imdg_un_no");
                	    }
     	    	        if( sheetObj.EditValue !=  sheetObj.CellValue (Row, "sheet2_imdg_un_no_seq") ){
     	    	        	fnClearUnnoInfo(sheetObj, Row);
     	    	        }
 
                        if(sheetObj.EditValue == ""){
     	    	            sheetObj.CellValue2 (Row, "sheet2_imdg_un_no_seq") = sheetObj.EditValue;
     	    	        }
                	    break;
 
                 case 'sheet2_slan_cd' :
                      if( sheetObj.EditValue.length == 3){
                          sheetObj.CellValue2(Row, "sheet2_slan_cd")  = sheetObj.EditValue;
                          doActionIBSheet(sheetObjects[1], formObj,IBSEARCH_ASYNC06, Row);                            
                      }
                      break;
            	    
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
                 //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
          if(sheetObj.RowCount > 0){
        	  popCheck ="Y";
          }else{
        	  popCheck ="N";
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
            	    	   //initClassBtn(false);            	    	   
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
	            	   var cByte = ComGetLenByByte(formObj.crr_regu_desc_class  );
	            	   if ( cByte > 500  ){
	            		   ComShowCodeMessage("COM12142", "", "500byte (Current:"+cByte+")");
	            		   formObj.crr_regu_desc_class.focus();
	            		   formObj.crr_regu_desc_class.select();
	            		   return false;
	            	   }    	        	   
    	        	   sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "sheet1_crr_regu_desc") = document.form.crr_regu_desc_class.value;    
    	               break;
    	           case 'crr_regu_desc_unno':
	            	   var cByte = ComGetLenByByte(formObj.crr_regu_desc_unno  );
	            	   if ( cByte > 500  ){
	            		   ComShowCodeMessage("COM12142", "", "500byte (Current:"+cByte+")");
	            		   formObj.crr_regu_desc_class.focus();
	            		   formObj.crr_regu_desc_class.select();
	            		   return false;
	            	   }    	        	   
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
                    initClassBtn(false);
 	 	    	}
 	 	    	if(obj.value == "unno"){
                    doc.div_s1.style.display = "none";                    
                    doc.div_s2.style.display = "";          
                    formObj.crr_regu_desc_unno.value = "";                    
                    initUnnoBtn(false);
 	 	    	}
 				break;
         } // end switch
      }
      /**
       *  reload
       */   
      function reload(){
    	  doActionIBSheet(sheetObjects,document.form,IBSEARCH);
       }  
 
	/* 개발자 작업  끝 */