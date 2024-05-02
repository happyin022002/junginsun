/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6037.js
*@FileTitle : CMPB Guideline Creation - Origin & Destination
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.10 이승준
* 1.0 Creation
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
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
     * @class CMPB Guideline Creation - Origin & Destination : CMPB Guideline Creation - Origin & Destination 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6037() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	
    	//this.onbeforeunload = onBeforeUnload;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;
//radio 버튼을 클릭하여 조회 할때 sheet1의 내용을 아래의 어떤 sheet에 내릴지 알수있게 하기위해 사용한다. 
 var currentSheet = 1; 
 var enableFlag = true;
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

	 /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author 공백진
	  * @version 2009.05.07
	  */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/          
          var sheetObject1 = sheetObjects[0];          
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
	            case "btn_Ok":
	            	if (validateForm(sheetObject1,formObject,IBSAVE)) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						window.returnValue = "O";
						window.close();
	            	}	            	
	                break;
	            case "btn_Close":
	            	window.returnValue = "C";
	            	if (getSheetModify()){
	            		if(ComShowCodeConfirm("PRI00006")){
	            			if (validateForm(sheetObject1,formObject,IBSAVE)) {
	            				doActionIBSheet(sheetObject1,formObject,IBSAVE);
	            				window.returnValue = "O";
	            				window.close();
	            			}else{
	            				return;
	            			}
	            		}
	            	}	
	            	window.close();
	                break;
	            case "btn_RowAdd":
					if (validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;
	            case "btn_RowDel":
					if (validateForm(sheetObject1,formObject,IBDELETE)) { 
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }


     /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */
     function loadPage() {    	 
    	  //radio 버튼 이벤트
    	 initControl();
    	  //메인에서 받아온 조회조건
    	 setSearchCondition();
    	 
         for(i=0;i<sheetObjects.length;i++){
        	 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }         
         doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);                  
     }


     /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
         var sheetID = sheetObj.id;
         switch(sheetID) {
             case "sheet1":	// 화면에보이는 sheet
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 220;
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
                     
                     var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|Term|rcv_de_term_nm|display_seq";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//		  				  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//		  			  				  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//		  				  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
 					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter,	false, "ibflag");
 					InitDataProperty(0, cnt++ , dtCheckBox,	    40,  daCenter,	false, "chk");
 					InitDataProperty(0, cnt++ , dtSeq,			40,  daCenter,	false, "seq", false, "", dfNone, 0,	true, true);
 					 
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "svc_scp_cd", 	false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cre_ofc_cd", 	false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "gline_seq", 	false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prs_cust_tp_cd",false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "bse_seq",  		false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd",false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_pnt_seq",  false, "", dfNone, 0, true, true);
 					
 					InitDataProperty(0, cnt++ , dtCombo,     105, daCenter,	false, "rout_pnt_loc_tp_cd",  true,	 "",	dfNone,	0,	true,	true);
 					InitDataProperty(0, cnt++ , dtPopupEdit, 100, daCenter,	false, "rout_pnt_loc_def_cd", true,  "",	dfNone,	0,	true,	true, 5);
 					InitDataProperty(0, cnt++ , dtData,      190, daLeft,	false, "rout_pnt_loc_def_nm", false, "",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,     90,  daCenter,	false, "rcv_de_term_cd",	  false, "",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,  	 90,  daCenter,	false, "rcv_de_term_nm",	  false, "",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,  	 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);

 					//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
 					InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 				 
 					ShowButtonImage = 2;
                 }
                 break;
             case "sheet2":	// Route Point Origin sheet
            	 with (sheetObj) {
                     // 높이 설정
                     style.height = 140;
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
                     
                     var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|Term|rcv_de_term_nm|display_seq";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//		  				  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//		  			  				  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//		  				  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
 					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter,	false, "ibflag");
 					InitDataProperty(0, cnt++ , dtCheckBox,	    40,  daCenter,	false, "chk");
 					InitDataProperty(0, cnt++ , dtSeq,			40,  daCenter,	false, "seq", false, "", dfNone, 0,	true, true);
 					 
 					InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "svc_scp_cd", 	false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "cre_ofc_cd", 	false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "gline_seq", 	false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "prs_cust_tp_cd",false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "bse_seq",  		false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "org_dest_tp_cd",false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "rout_pnt_seq",  false, "", dfNone, 0, true, true);
 					
 					InitDataProperty(0, cnt++ , dtData,  105, daCenter,	false, "rout_pnt_loc_tp_cd",  true,	 "",	dfNone,	0,	true,	true);
 					InitDataProperty(0, cnt++ , dtData,  100, daCenter,	false, "rout_pnt_loc_def_cd", true,  "",	dfNone,	0,	true,	true, 5);
 					InitDataProperty(0, cnt++ , dtData,  240, daLeft,	false, "rout_pnt_loc_def_nm", false, "",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,  90,  daCenter,	false, "rcv_de_term_cd",	  false, "",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,  60,  daCenter,	false, "rcv_de_term_nm",	  false, "",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,  	 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);

 					//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
 					InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 				 
 					ShowButtonImage = 2;
                 }
	             break;
             case "sheet3":	// Route Point Origin Via sheet
	             with (sheetObj) {
	                 // 높이 설정
	                 style.height = 100;
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
	                 
	                 var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|display_seq";
	                 var headCount = ComCountHeadTitle(HeadTitle);
	                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                 InitColumnInfo(headCount, 0, 0, true);
	
	                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                 InitHeadMode(true, true, true, true, false,false)
	
	                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                 InitHeadRow(0, HeadTitle, true);
	
	
	//               데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
	//	  				  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
	//	  			  				  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
	//	  				  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
						InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter,	false, "ibflag");
	 					InitDataProperty(0, cnt++ , dtData,	    	40,  daCenter,	false, "chk");
	 					InitDataProperty(0, cnt++ , dtData,			40,  daCenter,	false, "seq",			 false,	"",	dfNone,	0,	true,	true);

	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 	false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_ofc_cd", 	false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 	false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq",  		false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd",false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq",  false, "", dfNone, 0, true, true);
						
						InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "rout_via_port_tp_cd",  false, "", dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData, 85,  daCenter, false, "rout_via_port_def_cd", false, "", dfNone,	0,	false,	false, 5);
						InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rout_via_port_def_nm", false, "", dfNone,	0,	false,	false);						
						InitDataProperty(0, cnt++ , dtHidden,  	 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);
	             }
	             break;
             case "sheet4":	// Route Point Destination Via sheet
	             with (sheetObj) {
	            	// 높이 설정
	                 style.height = 100;
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
	                 
	                 var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|display_seq";
	                 var headCount = ComCountHeadTitle(HeadTitle);
	                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                 InitColumnInfo(headCount, 0, 0, true);
	
	                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                 InitHeadMode(true, true, true, true, false,false)
	
	                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                 InitHeadRow(0, HeadTitle, true);
	
	
	//               데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
	//	  				  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
	//	  			  				  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
	//	  				  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
						InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter,	false, "ibflag");
	 					InitDataProperty(0, cnt++ , dtData,	    	40,  daCenter,	false, "chk");
	 					InitDataProperty(0, cnt++ , dtData,			40,  daCenter,	false, "seq",			 false,	"",	dfNone,	0,	true,	true);

	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 	false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_ofc_cd", 	false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 	false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq",  		false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd",false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq",  false, "", dfNone, 0, true, true);
						
						InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "rout_via_port_tp_cd",  false, "", dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData, 85,  daCenter, false, "rout_via_port_def_cd", false, "", dfNone,	0,	false,	false, 5);
						InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rout_via_port_def_nm", false, "", dfNone,	0,	false,	false);						
						InitDataProperty(0, cnt++ , dtHidden,  	 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);
	             }
	             break;
             case "sheet5":	// Route Point Destination sheet
	             with (sheetObj) {
	            	// 높이 설정
                     style.height = 140;
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
                     
                     var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|Term|rcv_de_term_nm|display_seq";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//		  				  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//		  			  				  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//		  				  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
 					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter,	false, "ibflag");
 					InitDataProperty(0, cnt++ , dtCheckBox,	    40,  daCenter,	false, "chk");
 					InitDataProperty(0, cnt++ , dtSeq,			40,  daCenter,	false, "seq", false, "", dfNone, 0,	true, true);
 					 
 					InitDataProperty(0, cnt++,  dtData, 100, daCenter, false, "svc_scp_cd", 	false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++,  dtData, 100, daCenter, false, "cre_ofc_cd", 	false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++,  dtData, 100, daCenter, false, "gline_seq", 	false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++,  dtData, 100, daCenter, false, "prs_cust_tp_cd",false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++,  dtData, 100, daCenter, false, "bse_seq",  		false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++,  dtData, 100, daCenter, false, "org_dest_tp_cd",false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++,  dtData, 100, daCenter, false, "rout_pnt_seq",  false, "", dfNone, 0, true, true);
 					
 					InitDataProperty(0, cnt++ , dtData, 105, daCenter,	false, "rout_pnt_loc_tp_cd",  true,	 "",	dfNone,	0,	true,	true);
 					InitDataProperty(0, cnt++ , dtData, 100, daCenter,	false, "rout_pnt_loc_def_cd", true,  "",	dfNone,	0,	true,	true, 5);
 					InitDataProperty(0, cnt++ , dtData, 240, daLeft,	false, "rout_pnt_loc_def_nm", false, "",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "rcv_de_term_cd",	  false, "",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData, 60,  daCenter,	false, "rcv_de_term_nm",	  false, "",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,  	 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);
					
 					//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
 					InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 				 
 					ShowButtonImage = 2;
                 }
	             break;            
         }
     }

     /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */
      function doActionIBSheet(sheetObj,formObj,sAction) {
          sheetObj.ShowDebugMsg = false;
          switch(sAction) {
 			case IBCLEAR: // 화면 로딩시 
 				var sXml = "";
 				var radioObj = formObj.rt_pnt;
 			
				//공통 - type
 				//sheetObj.InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				formObj.f_cmd.value = SEARCH19;
				formObj.cd.value="CD02167";
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));			
				setIBCombo(sheetObj, sXml, "rout_pnt_loc_tp_cd", true, 0);	 			
 			
 				
 				//Term combo
         		formObj.f_cmd.value = SEARCH20;
         		//공통 term, trans mode
         		formObj.cd.value = "CD02138";//Origin
				if(radioObj[3].checked == true){
					formObj.cd.value = "CD02139";  //Destination
				}
				
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));	
				setIBCombo(sheetObj, sXml, "rcv_de_term_cd", true, 0);	 
 				
 				break;
 				
			case IBSEARCH:      //조회
				var sXml = "";
				//sheet data를 메인페이지에서 가져온다.
				for (i = 6; i < 10; i++){
					sXml = dialogArguments.getSheetXml(i);
					//ComDebug("sheetcnt = "+i+"  "+sXml)
					sheetObjects[i-5].LoadSearchXml(sXml);
				}
				//hidden 된 sheet의 데이터를 화면의 sheet에 복사한다.			
//				if (sheetObjects[currentSheet].RowCount != 0){
					sheetToSheet(sheetObjects[currentSheet],sheetObjects[0]);
//				}				
				//column을 hidden한다.
				setColHidden();
	         	
				break;
				
 			case IBINSERT:      // 입력
 			    //sheetObj.DataAutoTrim = false;
 		        var idx = sheetObj.DataInsert();		

				sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
				sheetObj.CellValue(idx, "cre_ofc_cd") = formObj.cre_ofc_cd.value;
				sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
				sheetObj.CellValue(idx, "prs_cust_tp_cd") = formObj.prs_cust_tp_cd.value;
				sheetObj.CellValue(idx, "bse_seq") = formObj.bse_seq.value;
				
				var radioObj = document.form.rt_pnt;
				var tpCd = "O";
		  		//선택된 radio button
		  		for (i = 0; i < 4 ; i++){
		  			if (radioObj[i].checked == true ){
		  				if (i == 2 || i == 3){
		  					tpCd = "D";
		  				}
		  			}
		  		}
		  		
				sheetObj.CellValue(idx, "org_dest_tp_cd") = tpCd;

				sheetObj.CellValue(idx, "rout_pnt_seq") = parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1;
				
				sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd", false);
											
 				break;
 				
 			case IBDELETE: // Delete
 				
 				if (sheetObj.CheckedRows("chk") <= 0) {
 					sheetObj.RowDelete(sheetObj.SelectRow,false);
  	        	}
 				
				for(var i = sheetObj.LastRow; i >= sheetObj.HeaderRows; i--) {
					if(sheetObj.CellValue(i, "chk") == "1") {
						sheetObj.RowDelete(i,false);
					}
				}
     	
 				break;	
 				
			case IBSAVE:        //저장		
				var sXml="";
	      	  	sheetToSheet(sheetObjects[0],sheetObjects[currentSheet]);
	      	  	
//				* opener화면으로 sheet data 내리는 방법
				for (i = 1; i < 5; i++){
					//정렬 한 후 메인 페이지로 보낸다.
					if (i == 1 || i == 4){
						setDisplaySeq (sheetObjects[i], "rout_pnt_loc_tp_cd");
						sheetObjects[i].ColumnSort("display_seq|rout_pnt_loc_def_cd","ASC","ASC|ASC",true); 
					}else{
						setDisplaySeq (sheetObjects[i], "rout_pnt_loc_tp_cd");
						sheetObjects[i].ColumnSort("display_seq|rout_via_port_def_cd","ASC","ASC|ASC",true); 
					}
					if(sheetObjects[i].RowCount > 0) {
						var sXml = ComPriSheet2Xml(sheetObjects[i]);
						dialogArguments.setSheetXml(sXml, i+5);
					} else {
						dialogArguments.removeSheetXml(sXml, i+5);
					}	
				}
	            break; 				
          }
      }
      
    

      
  /**
   * 저장시 rcv_de_term_nm에 콤보 세팅 Text 세팅 <br>
   * <br><b>Example :</b>
   * <pre>
   *     setRcvDeTermNm(sheetObj)
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @return 없음 <br>
   * @author 이승준
   * @version 2009.04.17
   */
   	function setRcvDeTermNm(sheetObj)  {
   		
   		for(var i=1; i<=sheetObj.RowCount; i++) {
   			
   			sheetObj.Cellvalue2(i, "rcv_de_term_nm") = GetComboInfo(i, "rcv_de_term_cd", "Text");
   		}

   	}


      /**
       * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
       * <br><b>Example :</b>
       * <pre>
       *     if (validateForm(sheetObj,document.form,IBSAVE)) {
       *         로직처리;
       *     }
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {form} formObj 필수 html form object
       * @param {int} sAction 필수 프로세스 플래그 상수
       * @returns bool <br>
       *          true  : 폼입력값이 유효할 경우<br>
       *          false : 폼입력값이 유효하지 않을 경우
       * @author 이승준
       * @version 2009.05.07
       */
      function validateForm(sheetObj,formObj,sAction){
     	  switch (sAction) {
 	  		case IBSEARCH: // 조회			
// 				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
// 					ComShowCodeMessage('PRI08001');
// 					return false;
// 				} else {
// 					return true;
// 				}
 	  			return true;
 				break;    	  
     	  	case IBSAVE: // 저장
 	        	//if (!ComChkValid(formObj)) return false;	    	
 				if (sheetObjects[0].IsDataModified ) {
	 		  		var sParamSheet1 = sheetObjects[0].GetSaveString();
	 		  		if (sParamSheet1==""){
	 		  			return ; 		  			
	 		  		} 					
 					var rowM = sheetObjects[0].ColValueDup("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rcv_de_term_cd");
 					if (rowM >= 0) {
 						ComShowCodeMessage("PRI00303", "Sheet", rowM);
 					    return false;
 				    }
 					
 					/*
 		            if (getValidRowCount(sheetObjects[1]) <= 0) {
 		            	ComShowCodeMessage("PRI00316", "Origin");
 		                return false;
 		            }
 		            if (formObj.svc_scp_cd.value == "TPE"
 		            	&& getValidRowCount(sheetObjects[2]) <= 0) {
 		            	ComShowCodeMessage("PRI00316", "Origin Via");
 		                return false;
 		            }
 		            if (formObj.svc_scp_cd.value == "TPE"
 		            	&& getValidRowCount(sheetObjects[3]) <= 0) {
 		            	ComShowCodeMessage("PRI00316", "Destination Via");
 		                return false;
 		            }
 		            if (getValidRowCount(sheetObjects[4]) <= 0) {
 		            	ComShowCodeMessage("PRI00316", "Destination");
 		                return false;
 		            }
 		            */
 				}
 				break;
     			
     		case IBINSERT: // Row Add
//     			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
//     				return false;
//     			} else {
//     				return true;
//     			}
     			return true;
     			break;
     			
     		case IBDELETE: // Delete
//     			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
//     				return false;
//     			} else {
//     				return true;
//     			}
     			return true;
     			break;
 				
     	  }
          return true;
      }
         
         
      /**
       * radio버튼 Axon 이벤트  처리 <br>
       * <br><b>Example :</b>
       * <pre>
       *     initControl()
       * </pre>
       * @param 없음
       * @returns 없음
       * @author 이승준
       * @version 2009.05.07
       */ 	 
  	function initControl() {
  	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
  	    axon_event.addListener('click', 'radio_click', 'rt_pnt');

  	}
      	

    /**
    * radio버튼 click 이벤트 발생시 호출되는 function <br>
    * <br><b>Example :</b>
    * <pre>
    *     
    * </pre>
    * @param 없음
    * @returns 없음
    * @author 이승준
    * @version 2009.05.07
    */ 	
  	function radio_click()
  	{
  		var radioObj = document.form.rt_pnt;
  		var hiddenVal = false;
  		var idx = 1 ;
  		
  		// validation을 통과하지 못하면 다른 route point로 이동 못함
  		if(validateForm(sheetObjects[0],document.form,IBSAVE)!=true){
  			radioObj[currentSheet-1].checked = true;
  			return ;
  		}  	  		
  		
  		//현재 작업 화면에 보이는 데이터를 숨겨진 sheet로 내린다.
  	  	sheetToSheet(sheetObjects[0],sheetObjects[currentSheet]);
  	    sheetObjects[0].removeAll();
  	    
  		//선택된 radio button
  		for (i = 0; i < 4 ; i++){
  			if (radioObj[i].checked == true ){
  				idx = i + 1;
  				currentSheet = idx;
  			}
  		}
 		
  		//radio 버튼에 따라 컬럼을 숨기거나 보여준다.
  		setColHidden();
  		//숨겨진  sheet의 데이터를 화면의 sheet로 로드한다.
  		changeCombo();
  		sheetToSheet(sheetObjects[idx],sheetObjects[0]);

  	}         
    /**
     * Route Point에 따라 Term의 콤보를 변경하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *     	changeCombo()
     * </pre>
     * @param 없음
     * @returns 없음
     * @author 이승준
     * @version 2009.05.07
     */ 	   
    function changeCombo(){
    	var radioObj = document.form.rt_pnt;
		// Origin 일 경우 와 Destination 일 경우 Term이 틀려진다.
		if (radioObj[0].checked){
			document.form.cd.value="CD02138";
		}else if (radioObj[3].checked){
			document.form.cd.value="CD02139";
		}
		if (radioObj[0].checked || radioObj[3].checked){
			//공통 term
			document.form.f_cmd.value = SEARCH19;
			var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(document.form));
			setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true, 0);	  	 		
		}
    }
    

     /**
      * radio버튼 click 이벤트에서 호출되는 function <br>
      * sheet의 컬럼을 숨기거나 보여준다.
      * <br><b>Example :</b>
      * <pre>
      *     	setColHidden()
      * </pre>
      * @param 없음
      * @returns 없음
      * @author 이승준
      * @version 2009.05.07
      */ 	   	 
   	function setColHidden()
   	{
   		var radioObj = document.form.rt_pnt;
   		var hiddenVal = false;
   		var idx = 1;
  		//선택된 radio button
  		for (i = 0; i < 4 ; i++){
  			if (radioObj[i].checked == true ){
  				idx = i + 1;
  			}
  		}
  		if (idx == 2 || idx == 3){
  			hiddenVal = true;
  		}  		
		sheetObjects[0].colHidden("rcv_de_term_cd")= hiddenVal;
		
   	}   	
 	 
   	/**
    * sheet 간의 데이터 이동시 호출하는 function <br>
    * sheet의 모든 데이터를 이동하며 원본 sheet의 데이터는 삭제한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *		sheetToSheet (sheetObj1, sheetObj2)
    * </pre>
    * @param {ibsheet} sheetObj1 필수 옮길 데이터가 있는IBSheet Object 
    * @param {ibsheet} sheetObj2 필수 데이터를 로드 할 IBSheet Object(hidden 되어 있음)
    * @return 없음
    * @author 이승준
    * @version 2009.05.07
    */  	 	 
	function sheetToSheet (sheetObj1, sheetObj2){
		//sheetObj1 데이터를 조회XML로 만들기
//		if (sheetObj1.RowCount != 0 ){
			if (sheetObj1.RowCount != 0 )
				var sXml = ComMakeSearchXml(sheetObj1, true, "","",false)
	   		//sheetObj2로 조회XML 로드하기


			var rsltCnt = ComPriGetRowCountFromXML(sXml);
//	   		alert(rsltCnt)
	   		
	   		if ( sheetObj2 == sheetObjects[0]){
				sheetRowHidden(sheetObj2);
			}
				
//	   		if(rsltCnt>=1){
//	   			sheetObj2.LoadSearchXml(sXml);    			
//	   			if ( sheetObj2 == sheetObjects[0]){
//	   				sheetRowHidden(sheetObj2);
//	   			}
//	   		} else {
//	   			sheetObj2.removeAll();
//	   		}
	   		
	   		if(sheetObj1.RowCount == 0)	sheetObj2.removeAll();
	   		else sheetObj2.LoadSearchXml(sXml);  
	   	
			if ( sheetObj2 == sheetObjects[0]){
				sheetRowHidden(sheetObj2);
			}
			
			

	}
 	 
	 
 	 /**
    * 삭제된 row가 sheet 간 이동하면 Hidden이 되었던게 보이므로 다시 hidden 시켜주는 function <br>
    * sheet 간 데이터 이동시 실행한다.
    * <br><b>Example :</b>
    * <pre>
    * 		sheetRowHidden (sheetObj)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @return 없음
    * @author 이승준
    * @version 2009.05.07
    */   	 
 	function sheetRowHidden (sheetObj){
		for (i = sheetObj.RowCount; i > 0; i-- ){
			if (sheetObj.CellValue( i, "ibflag") == "D" ){
				sheetObj.RowHidden(i) = true;
			}
   		}	
 	}
 	
 	
 	function setDisplaySeq (sheetObj, saveName) {
		
   		for (var i=1; i <= sheetObj.RowCount; i++) {

  			if(sheetObj.CellValue(i, saveName) == "C") 
  				sheetObj.CellValue2(i,"display_seq") = 1;
  			else if(sheetObj.CellValue(i, saveName) == "R") 
  				sheetObj.CellValue2(i,"display_seq") = 2;
  			else if(sheetObj.CellValue(i, saveName) == "G") 
  				sheetObj.CellValue2(i,"display_seq") = 3;
  			else if(sheetObj.CellValue(i, saveName) == "L") 
  				sheetObj.CellValue2(i,"display_seq") = 4;	
   				
      	}	
    }  
 	
   	 
     /**
 	    * OnChange 이벤트 발생시 호출되는 function <br>
 	    * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
 	    * <br><b>Example :</b>
 	    * <pre>
 	    *
 	    * </pre>
 	    * @param {ibsheet} sheetObj 필수 IBSheet Object
 	    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 	    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 	    * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
 	    * @return 없음
 	    * @author 이승준
 	    * @version 2009.05.07
 	    */  	    
     function sheet1_OnChange(sheetObj, Row, Col, Value)
     {
     	var colname = sheetObj.ColSaveName(Col);  
     	var formObj = document.form

     	switch(colname)
     	{
 	    	case "rout_pnt_loc_def_cd":
 	    		
 	    		if (Value.length==5){
 	    			//location name
 	    			formObj.f_cmd.value = SEARCH05; 	    			
 	    			formObj.cd.value = Value;
	 				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	 				var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
	 				if (arrDesc != null && arrDesc.length > 0) {
	 					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrDesc[0][1];
	 					sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = "L" ;
	 					//display seq 세팅
	 					sheetObj.CellValue2(Row,"display_seq") = 4 ;
	 				}else{	
	 					locationCellClear(sheetObj,Row);
	 				}
 	    		}else if (Value.length==4){
 	    			formObj.f_cmd.value = COMMAND33;
 	    			formObj.cd.value=sheetObj.Cellvalue(Row,Col);  	  
 	    			var param = "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.cre_ofc_cd.value + "&etc3=" 
 	    						+ formObj.gline_seq.value + "&etc5=CMPB";
 	    								
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+param); 	  				
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm"); 	  				
	 				if (arrData != null && arrData.length > 0) {
	 					if (arrData[1]!=""){
		 					sheetObj.Cellvalue2(Row,"rout_pnt_loc_def_nm") = arrData[1]; 
		 					sheetObj.Cellvalue2(Row,"rout_pnt_loc_tp_cd") = "G";
		 					//display seq 세팅
		 					sheetObj.CellValue2(Row,"display_seq") = 3 ;
	 					}else{
	 						locationCellClear(sheetObj,Row);
	 					}
	 				}
 	    		} else if (Value.length==2) {
 	    			//location name
 	    			formObj.f_cmd.value = SEARCH07; 	    			
 	    			formObj.cd.value = Value;
	 				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	 				var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
	 				if (arrDesc != null && arrDesc.length > 0) {
	 					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrDesc[0][1];
	 					sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = "C" ;
	 					//display seq 세팅
	 					sheetObj.CellValue2(Row,"display_seq") = 1 ;
	 				}else{	
	 					locationCellClear(sheetObj,Row);
	 				}
 	    		} else if (Value.length==3) {
 	    			//location name
 	    			formObj.f_cmd.value = COMMAND08; 	    			
 	    			formObj.cd.value = Value;
	 				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	 				var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
	 				if (arrDesc != null && arrDesc.length > 0) {
	 					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrDesc[0][1];
	 					sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = "R" ;
	 					//display seq 세팅
	 					sheetObj.CellValue2(Row,"display_seq") = 2 ;
	 				}else{	
	 					locationCellClear(sheetObj,Row);
	 				}	
 	    		}else{
 	    			locationCellClear(sheetObj,Row);
 	    		}
 	    		break;
 	    	case "rout_pnt_loc_tp_cd": 	    
 	    		locationCellClear(sheetObj,Row);
 	    		break;
 	    	
 	    	case "rcv_de_term_cd": 
 	    		//var comboStr = sheetObj.GetComboInfo(Row, "rcv_de_term_cd", "Text");
 	    		var sText = sheetObj.GetComboInfo(Row, "rcv_de_term_cd", "Text");
 	    		
 	    		// 배열로 구성한다.
 	    		var arrText = sText.split("|");
 	    		
        		var idx = sheetObj.GetComboInfo(Row, "rcv_de_term_cd", "SelectedIndex");
        		
 	    		sheetObj.Cellvalue2(Row,"rcv_de_term_nm") = arrText[idx];

 	    		break;	
 	    		
     	}
     
     }  
 	    
   /**
    * sheet의 특정 cell의 값을 빈칸으로 초기화하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    * 		locationCellClear(sheetObj,Row)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 값을 초기화할 해당 셀의 Row Index  
    * @return 없음
    * @author 이승준
    * @version 2009.05.07
    */  	    
 	function locationCellClear(sheetObj,Row){
 		sheetObj.CellValue2(Row,"rout_pnt_loc_def_nm")= ""; 		
 		sheetObj.CellValue2(Row,"rout_pnt_loc_def_cd")= "";
 		sheetObj.SelectCell(Row,"rout_pnt_loc_def_cd");
 		
 		sheetObj.CellValue2(Row,"display_seq") = "";
 	}

	 
 /**
    * 메인에서 받아온 조건으로 radio버튼값을 check하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    * 		setSearchCondition()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 이승준
    * @version 2009.05.07
    */  	 
	function setSearchCondition()
	{
		 var formObj = document.form;
		 var radioSelect = formObj.org_dest_tp_cd.value + formObj.pnt_via_tp_cd.value;
	  	 var radioObj = document.form.rt_pnt;
	  	 
		 switch (radioSelect){
			 case "OP":
				 currentSheet = 1;				 
				 break;
			 case "OV":
				 currentSheet = 2;
				 break;
			 case "DV":
				 currentSheet = 3;
				 break;				 
			 case "DP":
				 currentSheet = 4;
				 break;
		 }// end switch
		 radioObj[currentSheet - 1].checked = true;
	
	}		
	 

	 /**
	    * close button 클릭 후 sheet에 수정된 데이터가 있는지 확인하는  function <br>
	    * <br><b>Example :</b>
	    * <pre>
	    * 		getSheetModify()
	    * </pre>
	    * @param 없음
	    * @return {boolean}
        *          true  : sheet가 수정됨<br>
        *          false : sheet가 수정안됨<br>
	    * @author 이승준
	    * @version 2009.05.07
	    */  		 
	function getSheetModify()
	{
		 if (sheetObjects[0].IsDataModified == true || sheetObjects[1].IsDataModified == true || sheetObjects[2].IsDataModified == true || sheetObjects[3].IsDataModified == true || sheetObjects[4].IsDataModified == true ){
			 return true;
		 }
		 return false;
	}	 
	 
    /**
     * OnPopupClick 이벤트 발생시 호출되는 function <br>
     * Location PopUp을 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */  	      	 
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		var tpCd = "";
		
		if (colName == "rout_pnt_loc_def_cd"){
//			var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_SG + "&location_cmd=LGCR&svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value;
			
			var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
			sUrl += "&group_cmd=" + 5;
			sUrl += "&location_cmd=LGCR";
			sUrl += "&loc_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "rout_pnt_loc_tp_cd");
			
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;			
				//Location Type을 변경한다.
//				if (rtnVal.cd.length == 5){
//					tpCd = "L";
//				}
//				else if (rtnVal.cd.length == 4){
//					tpCd = "G";
//				}
//				else if (rtnVal.cd.length == 2){
//					tpCd = "C";
//				}
//				else if (rtnVal.cd.length == 3){
//					tpCd = "R";
//				}
				sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = rtnVal.tp;	
			}
		}		
	}


	/* 개발자 작업  끝 */