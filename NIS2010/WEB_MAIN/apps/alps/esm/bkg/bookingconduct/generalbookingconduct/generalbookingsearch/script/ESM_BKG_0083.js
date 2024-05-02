/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0083.js
*@FileTitle : Node Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.20 KimByungKyu
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
     * @class esm_bkg_0083 : esm_bkg_0083 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0083() {
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
 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var shtCnt = 0;
 	         var sheet1 = sheetObjects[0];
 	         var sheet2 = sheetObjects[1];
 	         var sheet3 = sheetObjects[2];
          /*******************************************************/ 
          
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
	             case "btn_t1Retrieve":
			         if(validateForm(formObject, SEARCH01)){
			        	 doActionIBSheet(formObject,SEARCH01); 
			         }else{
			        	 ComShowCodeMessage("BKG00625");
			         }	            	 
	     	        break;
	
	             case "btn_t1Close":
	 	            self.close();
	     	        break;
	
	     	    case "btn_t1OK":
	     	    	comPopupSend(formObject, 1);
	     	        break;
	     	    
	     	    case "Code_Detail":
	     	    	if(sheet1.RowCount > 0){
		     	    	var row = sheet1.SelectRow;
		     	    	ComOpenWindowCenter("/hanjin/locationCodeInquiry.do?f_cmd=101&loc_cd="+sheet1.CellValue(row, "loc_cd") , "myWin", 605,560, true);	     	    		
	     	    	}

	     	        break;
      
             
				case "btn_t2Retrieve":
			         if(validateForm(formObject, SEARCH)){
			        	 doActionIBSheet(formObject,SEARCH); 
			         }else{
			        	 ComShowCodeMessage("BKG00625");
			         }
				break; 
				
				case "btn_t2Select":
					comPopupSend(formObject, 2);
				break; 
				
				case "btn_t2Close":
					window.close();
				break; 

				case "btn_008301pop":
					ComOpenPopup('/hanjin/COM_ENS_0M1.do?pgmNo=COM_ENS_0M1', 600, 470, "setCallBack008301", '0,1,1,1,1,1,1', true);
				break; 				

				case "btn_008302pop":
					openComNodePop();
				break; 					
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
     		} else {
     			ComShowMessage(e);
     		}
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
                    InsertTab( cnt++ , "Location" , -1 );
                    InsertTab( cnt++ , "Node" , -1 );
                 }
              break;
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
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
         }         
         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }         
         initControl();
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

         axon_event.addListenerFormat('keypress', 'obj_KeyPress',    formObject); //- 키보드 입력할때
         axon_event.addListener('keydown', 'bkg0083_keydown', 'form');        
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
        * 시트 초기설정값, 헤더 정의
        * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
        * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
        */
       function initSheet(sheetObj,sheetNo) {

           var cnt = 0;
           var sheetID = sheetObj.id;
           switch(sheetID) {
           	case "t1sheet1":      //sheet1 init
  		         with (sheetObj) {
  		             // 높이 설정
  		             style.height = 220;
  		             //전체 너비 설정
  		             SheetWidth = mainTable.clientWidth;
  		
  		             //Host정보 설정[필수][HostIp, Port, PagePath]
  		             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  		             //전체Merge 종류 [선택, Default msNone]
  		             MergeSheet = msNone;
  		
  		             //전체Edit 허용 여부 [선택, Default false]
  		             Editable = true;
  		
  		             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  		             InitRowInfo( 1, 1, 9, 50);
  		
  		             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  		             InitColumnInfo(17, 0, 0, true);
  		
  		             // 해더에서 처리할 수 있는 각종 기능을 설정한다
  		             InitHeadMode(true, true, true, true, false,false)
  		             var HeadTitle = "Sel|Seq|Location|Location Name|Region|State|US Mode|SCC|ECC|LCC|RCC|S.OFC|EQ OFC|Country|UN|UNLoc|Hub Loc";
  		
  		             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  		             InitHeadRow(0, HeadTitle, false);
  		             //데이터속성    [	ROW, COL,   DATATYPE,		WIDTH,  DATAALIGN, 	COLMERGE,   SAVENAME,   		KEYFIELD, 	CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  		             InitDataProperty(0, cnt++ , dtRadioCheck,		30,    	daCenter,  	false,    	"chk",        		false,          "",       dfNone,	    0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtSeq,       		30,    	daCenter,  	false,    	"seq",          	false,          "",       dfNone,   	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,  	false,    	"loc_cd",       	false,          "",       dfNone,     	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		140,   	daLeft,  	false,   	"loc_nm",    		false,          "",       dfNone,     	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,  	false,    	"rgn_cd",       	false,          "",       dfNone,    	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,  	false,    	"loc_state",    	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,  	false,    	"",   				false,          "",       dfNone, 		0,    		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,  	false,    	"scc_cd",       	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,  	false,    	"ecc_cd",       	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,  	false,    	"lcc_cd",       	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,  	false,    	"rcc_cd",       	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,  	false,    	"sls_ofc_cd",   	false,          "",       dfNone, 		0,    		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		0,    	daCenter,  	false,    	"eq_ctrl_ofc_cd",	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		0,    	daCenter,  	false,    	"cnt_cd",			false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,     		40,    	daCenter,  	false,    	"un_loc_ind_cd",	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,  	false,    	"un_loc_cd",    	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,  	false,    	"hub_loc_cd",   	false,          "",       dfNone, 		0,    		false,      true);
  		
   
  		         }
  		         break;         
               case "t2sheet1":      //sheet1 init
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
                       Editable = true;

                       //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                       InitRowInfo(1, 1, 4, 100);

                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                       InitColumnInfo(13, 0, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                       InitHeadMode(true, true, false, true, false,false)

                       var HeadTitle1 = "|Sel|Loc. Code|Loc. Name|Yard CD|Yard Name|EQ CTRL OFC|CY|CFS|Rail\nRamp|Pseudo\nYard|Marine\nTerminal|Address";

                       //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                       InitHeadRow(0, HeadTitle1, true);

                       //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                      InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		"ibflag");
  					InitDataProperty(0, cnt++ , dtRadioCheck,		30,		daCenter,	true,		"chk");
  					InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		"loc_cd",					false,			"",      dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,				65,		daLeft,		true,		"loc_nm",					false,			"",      dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	true,		"yd_cd",					false,			"",      dfNone,		0,		false,		true);					
  					InitDataProperty(0, cnt++ , dtData,				200,	daLeft,		true,		"yd_nm",					false,			"",      dfNone,		0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,				85,		daCenter,	true,		"eq_ctrl_ofc_cd",			false,			"",      dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	true,		"yd_fcty_tp_cy_flg",		false,			"",      dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	true,		"yd_fcty_tp_cfs_flg",		false,			"",      dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,				45,		daCenter,	true,		"yd_fcty_tp_rail_rmp_flg",	false,			"",      dfNone,		0,		false,		true);					
  					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		"yd_fcty_tp_psdo_yd_flg",	false,			"",      dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		"yd_fcty_tp_mrn_tml_flg",	false,			"",      dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,				150,	daLeft,		true,		"yd_addr",					false,			"",      dfNone,		0,		true,		true);


//  				       ,DECODE(YD.YD_FCTY_TP_CY_FLG,      'Y','O','') YD_FCTY_TP_CY_FLG
//  				       ,DECODE(YD.YD_FCTY_TP_CFS_FLG,     'Y','O','') YD_FCTY_TP_CFS_FLG
//  				       ,DECODE(YD.YD_FCTY_TP_RAIL_RMP_FLG,'Y','O','') YD_FCTY_TP_RAIL_RMP_FLG
//  				       ,DECODE(YD.YD_FCTY_TP_PSDO_YD_FLG, 'Y','O','') YD_FCTY_TP_PSDO_YD_FLG
//  				       ,DECODE(YD.YD_FCTY_TP_MRN_TML_FLG, 'Y','O','') YD_FCTY_TP_MRN_TML_FLG
  					DataLinkMouse = true;
  					//CountPosition = 0;

                  }
                  break;

               case "t2sheet2":      //sheet2 init
                   with (sheetObj) {

                       // 높이 설정
                       style.height = 222;
                       //전체 너비 설정
                       SheetWidth = mainTable.clientWidth;

                       //Host정보 설정[필수][HostIp, Port, PagePath]
                       if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                       //전체Merge 종류 [선택, Default msNone]
                       MergeSheet = msHeaderOnly;

                      //전체Edit 허용 여부 [선택, Default false]
                       Editable = true;

                       //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                       InitRowInfo(1, 1, 4, 100);

                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                       InitColumnInfo(9, 0, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                       InitHeadMode(true, true, false, true, false,false)

                       var HeadTitle1 = "||Loc. Code|Loc. Name|Zone CD|Zone Name|Postal CD|District|EQ CTRL OFC ";

                       //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                       InitHeadRow(0, HeadTitle1, true);

                       //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                      InitDataProperty(0, cnt++ ,dtHiddenStatus,		30,		daCenter,	false,		"ibflag");
  					InitDataProperty(0, cnt++ , dtRadioCheck,		30,		daCenter,	true,		"chk");
  					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	true,		"loc_cd",				false,			"",      dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,		true,		"loc_nm",				false,			"",      dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"zn_cd",				false,			"",      dfNone,		0,		false,		true);					
  					InitDataProperty(0, cnt++ , dtData,				240,	daLeft,		true,		"zn_nm",				false,			"",      dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,				85,		daCenter,	true,		"pst_cd",				false,			"",      dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,				85,		daCenter,	true,		"dstr_nm",				false,			"",      dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,				85,		daCenter,	true,		"eq_ctrl_ofc_cd",		false,			"",      dfNone,		0,		false,		true);


  					DataLinkMouse = true;
  					//CountPosition = 0;

                  }
                  break;

           }
       }
       
       // Sheet관련 프로세스 처리
         function doActionIBSheet(formObj,sAction) {
        	 sheetObjects[0].ShowDebugMsg = false;
        	 sheetObjects[1].ShowDebugMsg = false;
        	 sheetObjects[2].ShowDebugMsg = false;
             switch(sAction) {
    			case SEARCH:      //조회
    				formObj.f_cmd.value = SEARCH;
    				if(formObj.yz_flag[0].checked){		            	
    					sheetObjects[1].DoSearch("ESM_BKG_0083GS.do" , FormQueryString(formObj));
    					if(sheetObjects[1].RowCount("R") > 0){
    						sheetObjects[1].CellValue(1,"chk") = 1;
    					}
    				}else{
    					sheetObjects[2].DoSearch("ESM_BKG_0083GS.do" , FormQueryString(formObj));
    					if(sheetObjects[2].RowCount("R") > 0){
    						sheetObjects[2].CellValue(1,"chk") = 1;
    					}						
    				}
    			break;
    			case SEARCH01:      //조회
    				formObj.f_cmd.value = SEARCH01;				
    				sheetObjects[0].DoSearch("ESM_BKG_0083GS.do" , FormQueryString(formObj));
    				sheetObjects[0].CellValue(1,"chk") = 1;
    			break;			
             }
         }

         /**
          * 화면 폼입력값에 대한 유효성검증 프로세스 처리
          */
         function validateForm(formObj,sAction){
        	  switch(sAction) {
        	  	case SEARCH:      //조회
        	  		if(ComIsNull(formObj.country_cd) && ComIsNull(formObj.loc_cd)){
        	  			ComSetFocus(formObj.country_cd);
        	  			return false;
        	  		}else{
        	  			if(!ComIsNull(formObj.country_cd)){
    	  					if(ComChkLen(formObj.country_cd,2) < 2){    	        		 
    	  						ComSetFocus(formObj.country_cd);    
    	  						return false;
    	  					}    	  				
        	  			}
        	  		}
        	  		return true;
        	  		break;
    			case SEARCH01:      //조회
    				if(ComIsNull(formObj.cnt_cd) && ComIsNull(formObj.location_cd) && formObj.loc_nm.value.length < 3){
    		  			ComSetFocus(formObj.cnt_cd);
    		  			return false;					
    				}
    				return true;
    				break;			
        	  }    	  
         }


     function  bkg0083_keydown(){
    	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	 var formObject = document.form;
    	 if(keyValue == 13){
    		 if(beforetab == 0){	// Location Tab
		         if(validateForm(formObject, SEARCH01)){
		        	 doActionIBSheet(formObject,SEARCH01); 
		         }else{
		        	 ComShowCodeMessage("BKG00104");
		         }	         			 
    		 }else{	// Node Tab
		         if(validateForm(formObject, SEARCH)){
		        	 doActionIBSheet(formObject,SEARCH); 
		         }else{
		        	 ComShowCodeMessage("BKG00104");
		         }    			 
    		 }
    		 
    	 }
     }

     /**
      * sheet1 OnClick후 이벤트 
      * @param {ibsheet} sheet 해당 시트   
      * @param {long} row 해당 셀의 Row Index
      * @param {long} col 해당 셀의 Column Index
      * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
     function sheet1_OnClick(sheet , row, col, value) {  
    	var formObj = document.form; 

    	sheetObjects[0].CellValue(row,"chk") = 1;
 		    	
     }     

     /**
      * sheet2 OnClick후 이벤트 
      * @param {ibsheet} sheet 해당 시트   
      * @param {long} row 해당 셀의 Row Index
      * @param {long} col 해당 셀의 Column Index
      * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
     function sheet2_OnClick(sheet , row, col, value) {  
    	var formObj = document.form; 

    	sheetObjects[1].CellValue(row,"chk") = 1;
 		    	
     }          
      
      /**
       * sheet2 OnClick후 이벤트 
       * @param {ibsheet} sheet 해당 시트   
       * @param {long} row 해당 셀의 Row Index
       * @param {long} col 해당 셀의 Column Index
       * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
      */
      function sheet3_OnClick(sheet , row, col, value) {  
     	var formObj = document.form; 

     	sheetObjects[2].CellValue(row,"chk") = 1;
  		    	
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

          var objs2 = document.all.item("tabLayer_btn");
          
       	objs2[nItem].style.display = "Inline";
       	objs2[beforetab].style.display = "none";     	
       	
       	//--------------- 요기가 중요 --------------------------//
       	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
       	//------------------------------------------------------//

       	//--------------- 요기가 중요 --------------------------//
       	objs2[beforetab].style.zIndex = objs2[nItem].style.zIndex -1 ;
       	//------------------------------------------------------//     	
       	beforetab= nItem;


       }
     /**	
      * Yard/Zone의 선택에 따라 화면 Layout 변경
      */     
     function setDisplayTp(displayTp){
    	 if("Y" == displayTp){
    		 // Yard  선택시
    		 document.getElementById("yardTable").style.display="block";
    		 document.getElementById("zoneTable").style.display="none";
    		 document.getElementById("ydCheck").style.display="block";
    		 document.getElementById("znCombo").style.display="none";    		 
    	 }else{
    		 // Zone 선택시
    		 document.getElementById("yardTable").style.display="none";
    		 document.getElementById("zoneTable").style.display="block";
    		 document.getElementById("ydCheck").style.display="none";
    		 document.getElementById("znCombo").style.display="block";      		 
    	 }
     }
     
     /**
      * 화면정보를 Main에 전달한다.
      */     
     function comPopupSend(formObj, tab){
    	 var calllFunc = formObj.calllFunc.value;
    	 if(calllFunc != ''){
			 var locTp = formObj.locTp.value;
			 var nRow  = formObj.row.value;
			 var nCol  = formObj.col.value;
			 var nSheetIdx = formObj.sheetIdx.value;
			 
			 var rArray = null;
			 if(tab == 1){
				 rArray = getCheckedRowsByName(sheetObjects[0], "chk"); 
			 }else{
				 if(formObj.yz_flag[0].checked){
					 rArray = getCheckedRowsByName(sheetObjects[1], "chk"); 
				 }else{
					 rArray = getCheckedRowsByName(sheetObjects[2], "chk");
				 }				 
			 }
			 eval('window.dialogArguments.'+calllFunc)(locTp,tab,rArray, nRow, nCol, nSheetIdx); 
	      	 window.close();
    	 }
     }
     
     // Node 공통 Popup에서 전달받은 값 Main에 셋팅
     function setYardSearch(aryPopupData, row, col, shhetIdx){
    	 var formObj = document.form;
    	 
    	 formObj.loc_cd.value = aryPopupData[0][3].substring(0,5);
    	 formObj.loc_cd2.value = aryPopupData[0][3].substring(5,7);
     }
     
     // Node 공통 Popup 호출
     function openComNodePop(){
    	 var mode;
    	 if(document.form.yz_flag[0].checked){
    		 mode = "yard";
    	 }else{
    		 mode = "zone";
    	 }
    	 ComOpenPopup('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061&mode='+mode, 800, 480, 'setCallBack008302','1,0,1,1,1', true);
     }
     
     function setCallBack008301(rArray){
   		var formObject = document.form;
   		if(rArray != null){
   			formObject.country_cd.value = rArray[0][3];
   		}  		    	 
     }

     function setCallBack008302(rArray){

		var formObject = document.form;		
		if(rArray != null){
			formObject.locCd.value = rArray[0][3].substring(0,5);
			formObject.loc_cd2.value = rArray[0][3].substring(5,7);
		}  		    	 
      }     
	/* 개발자 작업  끝 */
     