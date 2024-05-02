/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2077.js
*@FileTitle : RFA Guideline Creation - Rate(Route Point)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.08.10 박성수
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
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2077() {
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
  * @author 박성수
  * @version 2009.08.10
  */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/          
          var sheetObject1 = sheetObjects[0];          
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		
            if (srcName == null || srcName == "") {
            	return false;
            }
            if (srcName.indexOf("btn") == 0 && getButtonTable(srcName).disabled) {
            	return false;
            }
            
            switch(srcName) {
	            case "btn_Ok":
	            	if (enableFlag && validateForm(sheetObject1,formObject,IBSAVE)) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						window.returnValue = "O";
						window.close();
	            	}	            	
	                break;
	            case "btn_Close":
	            	window.returnValue = "C";
	            	if (getSheetModify()){
	            		if(ComShowCodeConfirm("PRI00006")){
	            			if (enableFlag && validateForm(sheetObject1,formObject,IBSAVE)) {
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
					if (enableFlag && validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;
	            case "btn_RowDel":
					if (enableFlag && validateForm(sheetObject1,formObject,IBDELETE)) { 
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
     * @author 박성수
     * @version 2009.08.10
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
     * @author 박성수
     * @version 2009.08.10
     */
     function loadPage() {    	 
    	 initControl();
    	 setSearchCondition()
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             sheetObjects[i].WaitImageVisible = false;
             ComEndConfigSheet(sheetObjects[i]);
         }         
         doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
         
 		if (document.form.isEditable.value == "false") {
			sheetObjects[0].Editable = false;
			disableButton("btn_RowAdd");
			disableButton("btn_RowDel");
		}
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
     * @author 박성수
     * @version 2009.08.10
     */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
         var sheetID = sheetObj.id;
         switch(sheetID) {
             case "sheet1":	// 화면에보이는 sheet
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
                     
                     var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|Term|Trans Mode";
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
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "svc_scp_cd", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "gline_seq", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_pnt_seq", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++ , dtCombo,     105, daCenter,	false, "rout_pnt_loc_tp_cd",  true,	 "",	dfNone,	0,	true,	true);
 					InitDataProperty(0, cnt++ , dtPopupEdit, 100, daCenter,	false, "rout_pnt_loc_def_cd", true,  "",	dfNone,	0,	true,	true, 5);
 					InitDataProperty(0, cnt++ , dtData,      190, daLeft,	false, "rout_pnt_loc_def_nm", false,	 "",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,     90,  daCenter,	false, "rcv_de_term_cd",	  true, "",	dfNone,	0,	true,	true);
 					InitDataProperty(0, cnt++ , dtCombo,     90,  daCenter,	false, "prc_trsp_mod_cd",	  false, "",	dfNone,	0,	true,	true);
 					 					
	                InitDataValid(0,  "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");		// 영문대문자만 입력
 					ShowButtonImage = 2;
                }
                 break;
             case "sheet2":	// Route Point Origin sheet
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
	                 
//	                 var HeadTitle = "|1|2|3|4|5|6|7|Location Type|Location Code|Description|Term|Trans Mode";
	                 var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|Term|Trans Mode";
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

	 					InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "gline_seq", true, "", dfNone, 0, true, true);
						InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
						
						InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "rout_pnt_loc_tp_cd",  false, "", dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData, 85,  daCenter, false, "rout_pnt_loc_def_cd", false, "", dfNone,	0,	false,	false, 5);
						InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rout_pnt_loc_def_nm", false, "", dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData, 70,  daCenter, false, "rcv_de_term_cd",	    false, "", dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData, 90,  daCenter, false, "prc_trsp_mod_cd",	    false, "", dfNone,	0,	false,	false);

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
	                 
	                 var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description";
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

						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
						
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);						
						InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "rout_via_port_tp_cd",  false, "", dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData, 85,  daCenter, false, "rout_via_port_def_cd", false, "", dfNone,	0,	false,	false, 5);
						InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rout_via_port_def_nm", false, "", dfNone,	0,	false,	false);						
		
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
	                 
	                 var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description";
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

						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
						
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);						
						InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "rout_via_port_tp_cd",  false, "", dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData, 85,  daCenter, false, "rout_via_port_def_cd", false, "", dfNone,	0,	false,	false, 5);
						InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rout_via_port_def_nm", false, "", dfNone,	0,	false,	false);								
						
	            }
	             break;
             case "sheet5":	// Route Point Destination sheet
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
	                 
	                 var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|Term|Trans Mode";
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
	 					InitDataProperty(0, cnt++ , dtData,	        40,  daCenter,	false, "chk");
	 					InitDataProperty(0, cnt++ , dtData,			40,  daCenter,	false, "seq", false,	"",	dfNone,	0,	true,	true);

						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
						
						InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "rout_pnt_loc_tp_cd",  false, "", dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData, 85,  daCenter, false, "rout_pnt_loc_def_cd", false, "", dfNone,	0,	false,	false, 5);
						InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rout_pnt_loc_def_nm", false, "", dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData, 70,  daCenter, false, "rcv_de_term_cd",	    false, "", dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData, 90,  daCenter, false, "prc_trsp_mod_cd",	    false, "", dfNone,	0,	false,	false);
	
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
     * @author 박성수
     * @version 2009.08.10
     */
      function doActionIBSheet(sheetObj,formObj,sAction) {
         try {
             if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                 ComOpenWait(true);
             }
	          sheetObj.ShowDebugMsg = false;
	          switch(sAction) {
	 			case IBCLEAR: // 화면 로딩시 
	 				var sXml = "";
	 				var radioObj = formObj.rt_pnt;
	 			
					//공통 - type
	 				sheetObj.InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
	 				
	         		formObj.f_cmd.value = COMMAND13;
	         		//공통 term, trans mode
	         		var param = "";
	         		param = "CD02070:N";//Origin
					if(radioObj[3].checked == true){
						param = "CD02071:N";  //Destination
					}
					param += ":CD01720:N"
	
	         		formObj.cd.value = param;// 명칭이 code|desc일 경우는 Y         		
	 				sXml = sheetObj.GetSearchXml("PRICommonGS.do" , FormQueryString(formObj));
	 				var arrXml = sXml.split("|$$|");
	 				if ( arrXml[0] != null)	setIBCombo(sheetObj,arrXml[0],"rcv_de_term_cd",false,0,"Y");
	 				if ( arrXml[1] != null)	setIBCombo(sheetObj,arrXml[1],"prc_trsp_mod_cd",true,0);			
			
	 				break;
				case IBSEARCH:      //조회
					var sXml = "";
					//sheet data를 메인페이지에서 가져온다.
					for (var i = 4; i < 8; i++){
						sXml = dialogArguments.getSheetXml(i);
						sheetObjects[i-3].LoadSearchXml(sXml);
					}
					//hidden 된 sheet의 데이터를 화면의 sheet에 복사한다.			
					if (sheetObjects[currentSheet].RowCount != 0){
						sheetToSheet(sheetObjects[currentSheet],sheetObjects[0]);
					}				
					//column을 hidden한다.
					setColHidden();
		         	break; 				
	 			case IBINSERT:      // 입력
	 		        var idx = sheetObj.DataInsert();		
	
					sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
					sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
					sheetObj.CellValue(idx, "cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
					sheetObj.CellValue(idx, "rout_seq") = formObj.rout_seq.value;
					var radioObj = document.form.rt_pnt;
					var tpCd = "O";
			  		//선택된 radio button
			  		for (var i = 0; i < 4 ; i++){
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
	 	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
	 	        	}
	 	        	
	 				deleteRowCheck(sheetObj, "chk");
	 				break;
	 				
				case IBSAVE:        //저장		
					var sXml="";
		      	  	sheetToSheet(sheetObjects[0],sheetObjects[currentSheet]);
	
					for (var i = 1; i < 5; i++){
						//정렬 한 후 메인 페이지로 보낸다.
						if (i == 1 || i == 4){
							sheetObjects[i].ColumnSort("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd","ASC","ASC|ASC"); 
						} else {
							sheetObjects[i].ColumnSort("rout_via_port_tp_cd|rout_via_port_def_cd","ASC","ASC|ASC"); 
						}
						var sXml = ComPriSheet2Xml(sheetObjects[i]);
						dialogArguments.setSheetXml(sXml, i+3);
					}
		            break; 				
	          }
         } catch (e) {
             if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e);
             }
         } finally {
         	ComOpenWait(false);
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
       * @author 박성수
       * @version 2009.08.10
       */
      function validateForm(sheetObj,formObj,sAction){
     	  switch (sAction) {
 	  		case IBSEARCH: // 조회			
 				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				} else {
 					return true;
 				}
 				break;    	  
     	  	case IBSAVE: // 저장
 				if (sheetObjects[0].IsDataModified ) {
	 		  		var sParamSheet1 = sheetObjects[0].GetSaveString();
	 		  		if (sParamSheet1 == ""){
	 		  			return ; 		  			
	 		  		} 					
 					var rowM = sheetObjects[0].ColValueDup("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rcv_de_term_cd|prc_trsp_mod_cd");
 					if (rowM >= 0) {
 						ComShowCodeMessage("PRI00303", "Sheet", rowM);
 					    return false;
 				    }
 				}
 				break;
     			
     		case IBINSERT: // Row Add
     			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
     				return false;
     			} else {
     				return true;
     			}
     			break;
     			
     		case IBDELETE: // Delete
     			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
     				return false;
     			} else {
     				return true;
     			}
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
       * @author 박성수
       * @version 2009.08.10
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
    * @author 박성수
    * @version 2009.08.10
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
     * @author 박성수
     * @version 2009.08.10
     */ 	   
    function changeCombo(){
    	var radioObj = document.form.rt_pnt;
		// Origin 일 경우 와 Destination 일 경우 Term이 틀려진다.
		if (radioObj[0].checked){
			document.form.cd.value="CD02070";
		}else if (radioObj[3].checked){
			document.form.cd.value="CD02071";
		}
		if (radioObj[0].checked || radioObj[3].checked){
			//공통 term
			document.form.f_cmd.value = SEARCH19;
			var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(document.form));
			setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true, 0, "Y");
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
      * @author 박성수
      * @version 2009.08.10
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
  			sheetObjects[0].InitDataProperty(0, 12, dtCombo, 90, daCenter, false, "rcv_de_term_cd",  false, "",	dfNone,	0,	true,	true);
  		} else {
  			hiddenVal = false;
  			sheetObjects[0].InitDataProperty(0, 12, dtCombo, 90, daCenter, false, "rcv_de_term_cd",  true, "",	dfNone,	0,	true,	true);
  		}
		sheetObjects[0].colHidden("rcv_de_term_cd")= hiddenVal;
		sheetObjects[0].colHidden("prc_trsp_mod_cd")= hiddenVal;
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
	    * @author 박성수
	    * @version 2009.08.10
	    */  	 	 
   	function sheetToSheet (sheetObj1, sheetObj2){
   		//sheetObj1 데이터를 조회XML로 만들기
   		if (sheetObj1.RowCount != 0 ){
   	   		var sXml = ComMakeSearchXml(sheetObj1, true, "","",true)
   	   		//sheetObj2로 조회XML 로드하기

   	   		if (sXml !=""){
   	   			sheetObj2.LoadSearchXml(sXml);    			
   	   			if ( sheetObj2 == sheetObjects[0]){
   	   				sheetRowHidden(sheetObj2);
   	   			}
   	   		}	
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
 	    * @author 박성수
 	    * @version 2009.08.10
 	    */   	 
 	function sheetRowHidden (sheetObj){
		for (i = sheetObj.RowCount; i > 0; i-- ){
			if (sheetObj.CellValue( i, "ibflag") == "D" ){
				sheetObj.RowHidden(i) = true;
			}
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
 	    * @author 박성수
 	    * @version 2009.08.10
 	    */  	    
     function sheet1_OnChange(sheetObj, Row, Col, Value)
     {
     	var colname = sheetObj.ColSaveName(Col);  
     	var formObj = document.form

     	switch(colname)
     	{
 	    	case "rout_pnt_loc_def_cd":
 	    		if (Value.length == 5) {
 	    			formObj.f_cmd.value = SEARCH05; 	    			
 	    			formObj.cd.value = sheetObj.Cellvalue(Row,Col);
 	    			var param = "&nm=rg&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.gline_seq.value;	
 			  		for (var i = 0; i <= 3; i++) {
 			  			if (formObj.rt_pnt[i].checked == true) {
 			  				if (i == 0) {
 			  					param += "&etc4=O";
 			  				} else if (i == 3) {
 			  					param += "&etc4=D";
 			  				}
 			  			}
 			  		}
	 				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	 				var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
	 				if (arrDesc != null && arrDesc.length > 0) {
	 					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrDesc[0][1];
	 					sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = "L" ;
	 				} else {	
	 					locationCellClear(sheetObj,Row);
	 				}
 	    		} else if (Value.length == 4) {
 	    			formObj.f_cmd.value = SEARCH11;
 	    			formObj.cd.value = sheetObj.Cellvalue(Row,Col);
 	    			var param = "&nm=rg&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.gline_seq.value;	
 			  		for (var i = 0; i <= 3; i++) {
 			  			if (formObj.rt_pnt[i].checked == true) {
 			  				if (i == 0) {
 			  					param += "&etc3=O";
 			  				} else if (i == 3) {
 			  					param += "&etc3=D";
 			  				}
 			  			}
 			  		}
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param); 	  				
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm"); 	  				
	 				if (arrData != null && arrData.length > 0) {
	 					if (arrData[1] != "") {
		 					sheetObj.Cellvalue2(Row,"rout_pnt_loc_def_nm") = arrData[1]; 
		 					sheetObj.Cellvalue2(Row,"rout_pnt_loc_tp_cd") = "G";
	 					} else {
	 						locationCellClear(sheetObj,Row);
	 					}
	 				}
 	    		} else {
 	    			locationCellClear(sheetObj,Row);
 	    		}
 	    		break;
 	    	case "rout_pnt_loc_tp_cd": 	    
 	    		locationCellClear(sheetObj,Row);
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
    * @author 박성수
    * @version 2009.08.10
    */  	    
 	function locationCellClear(sheetObj,Row){
 		sheetObj.CellValue2(Row,"rout_pnt_loc_def_nm")= ""; 		
 		sheetObj.CellValue2(Row,"rout_pnt_loc_def_cd")= "";
 		sheetObj.SelectCell(Row,"rout_pnt_loc_def_cd");
 	}

	 
 /**
    * 메인에서 받아온 조건으로 radio버튼값을 check하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    * 		setSearchCondition()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 박성수
    * @version 2009.08.10
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
	    * @author 박성수
	    * @version 2009.08.10
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
	    * @author 박성수
	    * @version 2009.08.10
	    */  	      	 
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		var tpCd = "G";
		
		if (colName == "rout_pnt_loc_def_cd"){
			var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_RG + "&location_cmd=LG&svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value;
			sUrl += "&loc_tp_cd=" + sheetObj.CellValue(Row, "rout_pnt_loc_tp_cd");
	  		for (var i = 0; i <= 3; i++) {
	  			if (formObj.rt_pnt[i].checked == true) {
	  				if (i == 0) {
	  					sUrl += "&org_dest_cd=O";
	  				} else if (i == 3) {
	  					sUrl += "&org_dest_cd=D";
	  				}
	  			}
		  	}
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
			if (rtnVal != null) {
				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;			
				//Location Type을 변경한다.
				if (rtnVal.cd.length == 5) {
					tpCd = "L";
				}
				sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = tpCd ;
			}
		}		
	}


	/* 개발자 작업  끝 */