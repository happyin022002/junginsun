/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0010.js
*@FileTitle : Standard Note Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.10.16 최성민
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
     * @class Standard Note Creation : Standard Note Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0010() {
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
 
 var errMsg = "";
 
 //현재 이벤트를 저장
 var eventStatus = "";
 var eventStatus2 = "";

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;
 
 

	/**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author 최성민
	  * @version 2009.10.28
	  */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];
          var sheetObject3 = sheetObjects[2];
          
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

               case "btn_retrieve":
            	    doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
	 				break;

				case "btns_calendar": //달력버튼
   	    			if (comboObjects[0].Code == "") {
   	    				ComShowCodeMessage('PRI08002');
   	    				return false;
   	    			}
   	    			var cal = new ComCalendarFromTo();
   	                cal.select(formObject.eff_dt, formObject.exp_dt, 'yyyy-MM-dd');
   	              	
   	                break;		

             } // end switch
     	}catch(e) {
			if (e == "[object Error]") {
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
    * @author 최성민
    * @version 2009.10.28
    */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }

    /**
     * IBCombo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(sheetObj);
     * </pre>
     * @param {ibcombo} sheet_obj 필수 IBCombo Object
     * @return 없음
     * @author 최성민
     * @version 2009.10.28
     */    
     function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
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
      * @author 최성민
      * @version 2009.05.17
      */
     function loadPage() {
    	 
    	 for(i=0;i<sheetObjects.length;i++){

    		 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

    	 //IBMultiCombo초기화
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    } 	   

    	//SERVICE SCOPE
	    ComPriTextCode2ComboItem(svcScpCdComboValue, svcScpCdComboText, getComboObject(comboObjects, 'svc_scp_cd'));
	    //CUSTOMER TYPE
	    ComPriTextCode2ComboItem(prcCustTpCdComboValue, prcCustTpCdComboText, getComboObject(comboObjects, 'prc_cust_tp_cd'));
	    comboObjects[3].InsertItem(0,'','');
    
 	    axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
	    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
 		 		
 		var formObj = document.form;
 		formObj.note_ref_yr.focus();

     }
     
      /**
       * body 태그의 activate 이벤트핸들러 구현 <br>
       * <br><b>Example :</b>
       * <pre>
       *     obj_activate();
       * </pre>
       * @return 없음
       * @author 최성민
       * @version 2009.05.17
       */     
     function obj_activate() {
  		var formObject = document.form;
  	    var srcName = event.srcElement.getAttribute("name");
  	    var comboObj = comboObjects[1];
  	    
  	    ComClearSeparator (event.srcElement);
  	    
  	    if (srcName == "exp_dt") {
  	    	var eff_dt = formObject.eff_dt.value;
  	    		
  	    	if (eff_dt != null && eff_dt != "") {
	  	    	//code를 직접 입력시 값이 없음
	  	  		var text 	= comboObj.GetText(eff_dt, 1);
	  	  		var code  	= comboObj.FindIndex(setDash(eff_dt), 0);
	  	  		
	  	  		//OnBlur 시 매번 이벤트 발생 방지
	  	  		if (ComIsEmpty(text)) {
	  	  			
	  	  			//exp date 를 제외한 나머지 칼럼이 모두 같은 경우가 아니면 인서트
	  	  			var code2  		= comboObj.FindIndex(setDash(eff_dt), 0);	

	  	  			//입력한 날짜를 insert
	  	  			if(code2 == "-1") {
	  	  				//combo item insert
	  	  				comboObj.InsertItem(-1,setDash(eff_dt) + "|||", setDash(eff_dt));
	  	  				comboObj.Code = setDash(eff_dt);
	  	  				formObject.eff_dt.value = setDash(eff_dt);
	  	  			} 	  	  			
	  	  		} 
	  	  		
	  	  		//직접 입력이 아니라  auto search or select
	  	  		else {
	  	  			if(!isDateIBCombo(comboObj)) return;
	  	  			comboObj.Text2 = setDash(eff_dt);
		  		}
  	    	}	
  	    	
  	    }
  	}
     
    /**
     * body 태그의 deactivate 이벤트핸들러 구현 <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate();
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2009.05.17
     */     
  	function obj_deactivate() {
  	    ComChkObjValid(event.srcElement);
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
     * @author 최성민
     * @version 2009.05.22
     */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetObj.id) {
         
         	
	         case "sheet0":      //hidden 
	             with (sheetObj) {
	            	// Host정보 설정[필수][HostIp, Port, PagePath]
	 				if (location.hostname != "")
	 					InitHostInfo(location.hostname, location.port, page_path);
											
	             }
	             break; 
         
             case "sheet1":      //t1sheet1 init)
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 280;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(10, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|Sel.|Del Check|Seq.|Title|dp_seq|note_hdr_seq|note_seq|prc_cust_tp_cd|svc_scp_cd|note_tit_nm";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,   	"ibflag");
 	                 InitDataProperty(0, cnt++,  dtHidden, 		 	 40, 	daCenter,  false, 		"chk");
                     InitDataProperty(0, cnt++,  dtDelCheck, 		 40, 	daCenter,  false, 		"del_chk");
                     InitDataProperty(0, cnt++ , dtSeq,    			 50,    daCenter,  false,    	"Seq");
                     InitDataProperty(0, cnt++ , dtData,     		 150,   daLeft,    true,      	"note_tit_nm",  	false,  "", dfNone, 0, false,  false);
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"dp_seq", 			false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"note_hdr_seq", 	false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"note_seq", 		false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"prc_cust_tp_cd", 	false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"svc_scp_cd", 		false, "", dfNone, 0, false, false);
                     
 					 ColHidden("del_chk") = true;
                     WaitImageVisible = false;		
                 }
                 break;

             case "sheet2":      //t1sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 160;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(16, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "|Sel.|Del Seq|Seq.|Content|Creation Staff/Team|Creation Date|Conversion|Conversion|dp_seq|note_hdr_seq|note_seq|note_ctnt_seq|prc_cust_tp_cd|svc_scp_cd|";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,   	"ibflag");
                     InitDataProperty(0, cnt++,  dtHidden, 		 	 40,    daCenter,  false, 		"chk");
                     InitDataProperty(0, cnt++,  dtDelCheck, 		 40, 	daCenter,  false, 		"del_chk");
                     InitDataProperty(0, cnt++ , dtSeq,    			 50,    daCenter,  true,    	"seq");
                     InitDataProperty(0, cnt++ , dtData,     		 550,   daLeft,	   false,     	"note_ctnt",		false,  "", dfNone, 0, false,false);
 					 InitDataProperty(0, cnt++ , dtData,     		 160,   daCenter,  false,     	"cre_usr_id",		false, "", dfNone, 0, false,false);
 					 InitDataProperty(0, cnt++ , dtData,     		 90,    daCenter,  false,     	"cre_dt",			false, "", dfDateYmd, 0, false,false);
 					 InitDataProperty(0, cnt++ , dtCheckBox,         30,	daCenter,  false,   	"note_conv_flg",	false, "", dfNone, 0, false,false);
					 InitDataProperty(0, cnt++ , dtPopup,   	 	 70,    daLeft,    false,    	"conversion_pop",	false, "", dfNone, 0, true, false);
					 InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"dp_seq", 			false, "", dfNone, 0, false, false);
 					 InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"note_hdr_seq", 	false, "", dfNone, 0, false, false);
 					 InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"note_seq", 		false, "", dfNone, 0, false, false);
 					 InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"note_ctnt_seq", 	false, "", dfNone, 0, false, false);
 					 InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"prc_cust_tp_cd", 	false, "", dfNone, 0, false, false);
 					 InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"svc_scp_cd", 		false, "", dfNone, 0, false, false);
 					 
 					 InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"note_conv_mapg_id");

 	                 //Edit 불가능 한 셀 구분하기
 	                 UnEditableColor = RgbColor(0,0,0);
 					 
 					 ShowButtonImage = 2; 					 
 					 ColHidden("del_chk") = true;
 					 AutoRowHeight = false;
                     WaitImageVisible = false;
 		         }
                 break; 

         }
     }


     /**
      * OnClick 이벤트 발생시 호출되는 function <br>
      * sheet의 Row를 선택하면 해당 Row를 하이라이트처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
      * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
      * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
      * @return 없음
      * @author 최성민
      * @version 2009.05.19
      */	
 	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
	}

    /**
     * SHEET의 ROW을 클릭할때 호출되는 function <br>
     * sheet의 Row를 선택하면 해당 Row를 해당하는 자식SHEET를 조회한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
     * </pre>
     * @param {ibsheet} sheetM 필수 HTML태그(Object) 오브젝트
     * @param {ibsheet} sheetD 필수 HTML태그(Object) 오브젝트
     * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} appendRow 필수 SHEET Row 추가 유무
     * @return 없음
     * @author 최성민
     * @version 2009.05.19
     */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
		if (OldRow != NewRow) {			
			formObj.note_seq.value = sheetM.CellValue(adjNewRow, "note_seq");
			if(formObj.note_seq.value == "undefined" || ComIsEmpty(formObj.note_seq.value)) {
            	formObj.note_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_seq");
            }
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
		}
		
		//memopad
		showMemoPad(sheetM, NewRow, NewCol);
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
    * @author 최성민
    * @version 2009.05.22
    */
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 try {
	         sheetObj.ShowDebugMsg = false;
	         switch(sAction) {
		         case IBCREATE: // Service Scope 선택시, Duration 조회
			 			formObj.f_cmd.value = SEARCH05;
			 			var sXml = sheetObj.GetSearchXml("ESM_PRI_0010GS.do", FormQueryString(formObj));
			 			ComPriXml2ComboItem(sXml, formObj.gline_seq, "eff_dt", "eff_dt|exp_dt");
			 			break;	
		 		
		         case IBSEARCH:      //조회
		        	   if (validateForm(sheetObj, formObj, sAction)) {
			  				ComOpenWait(true);
		        		   if ( sheetObj.id == "sheet0") {
		        			   
		            	        formObj.f_cmd.value = SEARCH01;	            	        	            	        
		            		    var sXml = sheetObj.GetSearchXml("ESM_PRI_0010GS.do", FormQueryString(formObj));
			       				var arrData = ComPriXml2Array(sXml, "note_hdr_seq|prc_cust_tp_cd|cfm_flg|note_nm|note_ref_yr|eff_dt|exp_dt|svc_scp_cd");
			       				if (arrData != null && arrData.length > 0) {
			       					formObj.note_hdr_seq.value = arrData[0][0];
			       					formObj.note_ref_yr.value 		 = arrData[0][4];
			       					comboObjects[3].Code  			 = arrData[0][1];
			       					comboObjects[2].Code  			 = arrData[0][0];
			       					
			       					formObj.svc_scp_cd_hidden.value  = arrData[0][7];
			       					formObj.note_nm_hidden.value 	 = arrData[0][3];
			       					formObj.note_ref_yr_hidden.value = arrData[0][4];
			       					formObj.eff_dt_hidden.value 	 = arrData[0][5];
			       					formObj.exp_dt_hidden.value 	 = arrData[0][6];
			       					formObj.prc_cust_tp_cd_hidden.value = arrData[0][1];
			       							       					
			       					//듀레이션
			       					comboObjects[1].Code2	 		 = arrData[0][5];
			       					formObj.exp_dt.value 			 = arrData[0][6];
			       							       					
			       				} else {
			       					formObj.note_hdr_seq.value = "";
			       					formObj.note_nm.value = "";
			       					
			       					formObj.svc_scp_cd_hidden.value  = "";
			       					formObj.note_nm_hidden.value 	 = "";
			       					formObj.note_ref_yr_hidden.value = "";
			       					formObj.eff_dt_hidden.value 	 = "";
			       					formObj.exp_dt_hidden.value 	 = "";
			       					formObj.prc_cust_tp_cd_hidden.value = "";
			       				}
			       				
			       			}
		            		   
			                else if ( sheetObj.id == "sheet1") {
							  formObj.f_cmd.value = SEARCH02;
							  
							  for (var i = 0; i < sheetObjects.length; i++) {
								  sheetObjects[i].RemoveAll();
							  }
							  
							  sheetObj.DoSearch("ESM_PRI_0010GS.do", FormQueryString(formObj));
							  						 
						   }		
						   else if ( sheetObj.id == "sheet2") {
							  formObj.f_cmd.value = SEARCH03;
							  sheetObj.DoSearch("ESM_PRI_0010GS.do", FormQueryString(formObj));
		
						   }
							ComOpenWait(false);
		        	   }	   
		        	   break;
						
				case IBSEARCH_ASYNC05:        //NOTE_NM COMBO SEARCH
					
						if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
						    formObj.f_cmd.value = SEARCH01;
	           	        
		           	        //키값을 새로 조회 하므로  clear
		           	        formObj.note_hdr_seq.value = "";
	    					formObj.note_nm.value = "";
	    					formObj.prc_cust_tp_cd_hidden.value = "";
	    					
				 			var sXml = sheetObj.GetSearchXml("ESM_PRI_0010GS.do", FormQueryString(formObj));
				 			ComPriXml2ComboItem(sXml, formObj.note_nm_cd, "note_hdr_seq", "note_nm");
				 			
				 			formObj.note_nm_cd.Index = "-1";
				 			break;	
					    }
						break;				
	         	}
    	 }catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}finally {
			 ComOpenWait(false);
		}
     }

    /**
     * IBCOMBO를 초기화하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo의 순번
     * @return 없음
     * @author 최성민
     * @version 2009.07.15
     */ 
     function initCombo(comboObj, comboNo) {
 	    switch(comboObj.id) {
 	        case "svc_scp_cd":
 	            var i=0;
 	            with(comboObj) {
 	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	IMEMode = 0;
	            	ValidChar(2, 0);
	                MaxLength = 3;      // 3자리만 입력
 	            }
 	            break;
 	        
 	       case "gline_seq":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            }
	            break;
	            
 	      case "note_nm_cd":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            }
	            break;      
	            
 	      case "prc_cust_tp_cd":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            	Enable = false;
	            }
	            break;     
 	            
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
     * @author 최성민
     * @version 2009.04.17
     */
     function validateForm(sheetObj,formObj,sAction){
    	  switch (sAction) {
    	 
	    	 case IBCREATE: // service scope 선택시
	    		
	    		 if ( sheetObj.id == "sheet0") {
		    		 if (ComIsEmpty(formObj.note_ref_yr.value)) {
		 				ComPriInputValueFailed("input","year",formObj.note_ref_yr);
		 				return false;
		 			 }
	    		 } else if( sheetObj.id == "sheet1") {
	    			 if (ComIsEmpty(formObj.note_ref_yr.value)) {
		 				ComPriInputValueFailed("i","year",formObj.note_ref_yr);
		 				return false;
		 			 }
	    			 if (ComIsEmpty(comboObjects[0].Text)) {
	 	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
	 					return false;
	 				 }
	    		 }
	    		 return true;
	 			
	 			 break;
    	 
	 		case IBSEARCH: // 조회
	 			
	 			if ( sheetObj.id == "sheet0") {
		 			
	 				if (ComIsEmpty(formObj.note_ref_yr.value)) {
	 					ComPriInputValueFailed("input","year",formObj.note_ref_yr);
		 				return false;
		 			 }	
	 						 			
		 			if (ComIsEmpty(comboObjects[0].Text)) {
		 				ComShowCodeMessage('PRI08002');
		 				return false;
		 			}	 			
	 			} else if ( sheetObj.id == "sheet1") {	
	 				
	 				if (ComIsEmpty(formObj.note_ref_yr.value)) {
	 					ComPriInputValueFailed("input","year",formObj.note_ref_yr);
		 				return false;
		 			}	
		 			
	 				if (ComIsEmpty(comboObjects[0].Text)) {
	 					ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
						return false;
					}
	 			
		 			if (ComIsEmpty(comboObjects[1].Text)) {
		 				ComPriInputValueFailed("input","Duration",comboObjects[1]);
		 				return false;
					}
		 			
		 			if (ComIsEmpty(formObj.exp_dt.value)) {
		 				ComPriInputValueFailed("input","Duration",formObj.exp_dt);
						return false;
					}
		 			
		 			if (ComIsEmpty(comboObjects[2].Text)) {
		 				ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
		 				return false;
					}
	 			}
	 			
				return true;
	 			break;	 	
		}

         return true;
     }

   /**
    * service scope 의 OnChange 이벤트를 호출하는 함수 <br>
    * <br><b>Example :</b>
    * <pre>
    *     
    * </pre>
    * @param {ibcombo} comboObj 필수 IBCombo Object
    * @param {string} code 필수 IBCombo Code 값
    * @param {string} text 필수 IBCombo Code 명
    * @returns 없음
    * @author 최성민
    * @version 2009.04.17
    */
  	function svc_scp_cd_OnChange(comboObj, code, text) {
  		
  		
  		if(comboObjects[0].GetCount () > 0 && comboObjects[0].Index != "-1") {
 	 		if (validateForm(sheetObjects[0],document.form,IBCREATE)) {
 	 	 		
 				var formObj = document.form;
 				var arrText = text.split("|");
 				
				if (arrText[1] != null && arrText[1] != "undefined" && arrText[1].length > 1) {
 					formObj.svc_scp_nm.value = formObj.svc_scp_cd.GetText(code,1);
 					
					searchConditionReset(formObj,"1");
					
					if(eventStatus != "IBCOPY") doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
					
					formObj.svc_scp_nm.focus();
 				}
 				
 	 		} else {
 	 			comboObjects[0].Index = "-1";
 	  		}
  		}	
 	}
  	
    /**
     * service scope 의 OnClear 이벤트를 호출하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibcombo} comboObj 필수 IBCombo Object
     * @returns 없음
     * @author 최성민
     * @version 2009.04.17
     */
  	function svc_scp_cd_OnClear(comboObj) {
		var formObject = document.form;
		formObject.svc_scp_nm.value = "";
		
		comboObj.Index2 = -1;
	}
  	
    /**
    * service scope 의 OnBlur 이벤트를 호출하는 함수 <br>
    * <br><b>Example :</b>
    * <pre>
    *     
    * </pre>
    * @param {ibcombo} comboObj 필수 IBCombo Object
    * @returns 없음
    * @author 최성민
    * @version 2009.04.17
    */
  	function svc_scp_cd_OnBlur(comboObj) {
  		
		var formObj = document.form;
		
		if (!validateForm(sheetObjects[0],document.form,IBCREATE)) return;
		
		var code = comboObj.FindIndex(comboObj.Code, 0);
		if (code != null && code != "") {
			
			var text = comboObj.GetText(code, 1);
			
			if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
				formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
				searchConditionReset(formObj,"1");
				
				if(eventStatus != "IBCOPY")	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
				
				formObj.svc_scp_nm.focus();
			}
		}
	}
  	  
    /**
     * IBCombo 인 경우 날짜 체크 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *     isDateIBCombo(comboObj);
     * </pre>
     * @param {ibcombo} comboObj 필수 IBCombo Object
     * @returns boolean
     * @author 최성민
     * @version 2009.04.17
     */
  	function isDateIBCombo(comboObj) {
  		
  		if(ComIsEmpty(comboObj.Text)) return;

	  	if(!ComIsDate(comboObj.Text)) {
	  		ComPriDateFormatFailed("Effective Date");
			comboObj.Text2 = "";
			comboObj.focus();
			return false;
		}
	  	
	  	return true;
  	}
 	
  /**
   * gline_seq 의 OnChange 이벤트를 호출하는 함수 <br>
   * <br><b>Example :</b>
   * <pre>
   *     
   * </pre>
   * @param {ibcombo} comboObj 필수 IBCombo Object
   * @param {string} code 필수 IBCombo Code 값
   * @param {string} text 필수 IBCombo Code 명
   * @returns 없음
   * @author 최성민
   * @version 2009.04.17
   */
 	function gline_seq_OnChange(comboObj, code, text) {
 		if(comboObjects[1].GetCount () > 0 && comboObjects[1].Index != "-1") {
 			if (validateForm(sheetObjects[1],document.form,IBCREATE)) {
 				
 				if(!isDateIBCombo(comboObj)) return;
 		
		 		var formObj = document.form;
		 		
		 		var arrText = text.split("|");
		 		if (arrText[1] != null && arrText[1] != "undefined") {
 					formObj.eff_dt.value =  setDash(formObj.gline_seq.GetText(code,0));
 					
 					if(!ComIsEmpty(formObj.gline_seq.GetText(code,1))) {
 						formObj.exp_dt.value =  setDash(formObj.gline_seq.GetText(code,1));
 						
 						//콤보 선택 여부 세팅 
 	 					formObj.exp_dt_hidden_select.value = "selected";
 	 					//NOTE NAME COMBO SEARCH
 	 					setNoteNmCd();
 					} 					
 				}
			
 			} else {
 	 			comboObjects[1].Index = "-1";
 	 		}
 		}
	}
 	
 	
  /**
   * gline_seq 의 OnBlur 이벤트를 호출하는 함수 <br>
   * <br><b>Example :</b>
   * <pre>
   *     
   * </pre>
   * @param {ibcombo} comboObj 필수 IBCombo Object
   * @returns 없음
   * @author 최성민
   * @version 2009.04.17
   */
   	function gline_seq_OnBlur(comboObj) {
   		
		var formObj = document.form;
		
		var code = comboObj.FindIndex(setDash(comboObj.Text), 0);
		//code를 직접 입력시 값이 없음
		var text = comboObj.GetText(comboObj.Text, 1);
		
		//OnBlur 시 매번 이벤트 발생 방지
		if (ComIsEmpty(text) && !ComIsEmpty(getSvcScpCd()) && !ComIsEmpty(comboObj.Text)) {
			if(!isDateIBCombo(comboObj)) return;
			
			if(code != "-1") {
				formObj.eff_dt.value = setDash(comboObj.Text);
				comboObj.Text2 = setDash(comboObj.Text);
			}
			//입력한 날짜를 insert
			else {
			
				//combo item insert
				comboObj.InsertItem(-1,setDash(comboObj.Text) + "|", setDash(comboObj.Text));
				comboObj.Code = setDash(comboObj.Text);
				formObj.eff_dt.value = setDash(comboObj.Text);
			} 
			
		} 
		
		//직접 입력이 아니라  auto search or select
		else {
			if(formObj.eff_dt_hidden.value != setDash(comboObj.GetText(code, 0)) 
					&& formObj.exp_dt_hidden.value != setDash(comboObj.GetText(code, 1))
					&& setDash(comboObj.GetText(code, 1)) != "undefined") {
				if(!isDateIBCombo(comboObj)) return;
				formObj.eff_dt.value = setDash(comboObj.GetText(code, 0));
			}	
		}
		
   	}
   	
  /**
   * exp_dt onFocus 시 히든 에 값 세팅하는 함수 <br>
   * <br><b>Example :</b>
   * <pre>
   *     setExpDtBefore();
   * </pre>
   * @returns 없음
   * @author 최성민
   * @version 2009.04.17
   */
   	function setExpDtBefore(){
   		var formObj = document.form;
   		formObj.exp_dt_before.value = setDash(formObj.exp_dt.value);
   	}
  
  /**
   * exp_dt blur 시 호출하는 함수 <br>
   * <br><b>Example :</b>
   * <pre>
   *     setNoteNmCd();
   * </pre>
   * @returns boolean
   * @author 최성민
   * @version 2009.04.17
   */
 	function setNoteNmCd() {
 		
 		var formObj = document.form;
 		
 		if(eventStatus == "IBCOPY") return;
 		 		
 		//처음 날짜를 입력
 		if(ComIsEmpty(formObj.note_hdr_seq.value)) {
 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
 			formObj.exp_dt_hidden_select.value = ""; 	 		
 	 		return;
 		}
 		
 		//eff_dt combo를 선택한 경우 
 		if(!ComIsEmpty(formObj.exp_dt_hidden_select.value) ) {
 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
 			formObj.exp_dt_hidden_select.value = ""; 	 		
 	 		return;
 		}
 		
 		
	}
 	
 	
    /**
     * note_nm_cd  변경시 호출하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibcombo} comboObj 필수 IBCombo Object
     * @param {string} code 필수 IBCombo Code 값
     * @param {string} text 필수 IBCombo Code 명
     * @returns 없음
     * @author 최성민
     * @version 2009.04.17
     */
 	function note_nm_cd_OnChange(comboObj, code, text) {
 		var formObj = document.form;
 		if(eventStatus != "IBCOPY") {
	 		if(comboObjects[2].GetCount () > 0 && comboObjects[2].Index != "-1") {
	 			if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
		 			
	 				formObj.eff_dt.value = setDash(formObj.eff_dt.value);
	 				formObj.exp_dt.value = setDash(formObj.exp_dt.value);
	 				
	 				//note_nm_cd의 키 값을 세팅
					formObj.note_hdr_seq.value = code;
					
					//note_nm_cd의 text 값을 세팅
					formObj.note_nm.value = getNoteNmTxt(code);
	 				
			 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			 		
			 		if(eventStatus != "IBSAVE")
			 			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
		 			
	 			} 
	 		}	
 		}	
	}
 
 	
   /**
     * 화면 리셋하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {form} formObj 필수 form Object
     * @returns 없음
     * @author 최성민
     * @version 2009.04.17
     */
 	function removeAll2(formObj) {
 		
 		comboObjects[0].Index = "-1";
 		comboObjects[1].Index = "-1";
 		comboObjects[1].RemoveAll();
 		
 		comboObjects[2].Index = "-1";
 		comboObjects[2].RemoveAll();
 		
 		comboObjects[3].Index = "-1";
 		
 		formObj.reset();
 		sheetObjects[1].RemoveAll();
 		sheetObjects[2].RemoveAll();
 	 		
 		eventStatus = ""
 		
	}
 	
    /**
     * 화면 리셋하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {form} formObj 필수 form Object
     * @returns 없음
     * @author 최성민
     * @version 2009.04.17
     */
 	function removeAll(formObj) {
 		
 		if (checkModified(formObj)) {
 			
 			if (ComShowCodeConfirm("PRI00006")) {
 				supressConfirm = true;
 				doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
 				supressConfirm = false;
 			} else {
 				comboObjects[0].Index = "-1";
 		 		comboObjects[1].Index = "-1";
 		 		comboObjects[1].RemoveAll();
 		 		
 		 		comboObjects[2].Index = "-1";
 		 		comboObjects[2].RemoveAll();
 		 		
 		 		comboObjects[3].Index = "-1";
 		 		
 		 		formObj.reset();
 		 		sheetObjects[1].RemoveAll();
 		 		sheetObjects[2].RemoveAll();
 		 		
 			}
 		} else {	
 			comboObjects[0].Index = "-1";
 	 		comboObjects[1].Index = "-1";
 	 		comboObjects[1].RemoveAll();
 	 		
 	 		comboObjects[2].Index = "-1";
 	 		comboObjects[2].RemoveAll();
 	 		
 	 		comboObjects[3].Index = "-1";
 	 		
 	 		formObj.reset();
 	 		sheetObjects[1].RemoveAll();
 	 		sheetObjects[2].RemoveAll();
 	 		
 		}
 		
 		eventStatus = ""
 		
	}
 	
 	
    /**
     * 조회 조건 리셋하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     *     searchConditionReset(formObj,"1");
     * </pre>
     * @param {form} formObj 필수 form Object
     * @param {String} gubun 필수 구분값
     * @returns 없음
     * @author 최성민
     * @version 2009.04.17
     */
 	function searchConditionReset(formObj,gubun) {
 		
 		if(eventStatus == "IBCOPY") return;
 		
 		//sc change
 		if(gubun == "1") {
	 		
	 		comboObjects[1].Index = "-1";
	 		comboObjects[1].RemoveAll();
	 		formObj.eff_dt.value = "";
	 		formObj.exp_dt.value = "";
	 		comboObjects[2].Index = "-1";
	 		comboObjects[2].RemoveAll();
	 		comboObjects[3].Index = "-1";
	 		formObj.note_nm.value = "";
	 		
	 		sheetObjects[1].RemoveAll();
	 		sheetObjects[2].RemoveAll();
 		} 
 		//eff_dt change
 		else if(gubun == "2") {	
 			comboObjects[2].Index = "-1";
	 		comboObjects[2].RemoveAll();
	 		comboObjects[3].Index = "-1";
	 		formObj.note_nm.value = "";
	 		sheetObjects[1].RemoveAll();
	 		sheetObjects[2].RemoveAll();
	 		
 		}
	}
 	
 	
    /**
     * 기존 조회 조건을 히든값에 카피한 후 조회조건 리셋하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     *     removeCopy(formObj);
     * </pre>
     * @param {form} formObj 필수 form Object
     * @returns 없음
     * @author 최성민
     * @version 2009.04.17
     */
 	function removeCopy(formObj) {
 		
 		if (eventStatus == "IBCOPY") {
			return false;
		}
 		var svc_scp_cd_beforeCopy 		= comboObjects[0].Code;
 		var prc_cust_tp_cd_beforeCopy   = comboObjects[2].Code;
 		var note_hdr_seq_beforeCopy 	= formObj.note_hdr_seq.value;
 		
 		comboObjects[0].Index = "-1";
 		
 		comboObjects[1].Index = "-1";
 		comboObjects[1].RemoveAll();
 		comboObjects[2].Index = "-1";
 		comboObjects[2].RemoveAll();
 		comboObjects[3].Index = "-1";
 		
 		formObj.reset();
 		formObj.svc_scp_cd_copy.value 		= svc_scp_cd_beforeCopy;
 		formObj.prc_cust_tp_cd_copy.value 	= prc_cust_tp_cd_beforeCopy;
 		formObj.note_hdr_seq_copy.value 	= note_hdr_seq_beforeCopy;
 		formObj.note_hdr_seq.value 			= note_hdr_seq_beforeCopy;
 		
 		formObj.note_ref_yr.focus();
 	}
 
	
   /**
    * svc_scp_cd 값을 리턴하는 함수 <br>
    * <br><b>Example :</b>
    * <pre>
    *     getSvcScpCd();
    * </pre>
    * @returns String
    * @author 최성민
    * @version 2009.04.17
    */
	function getSvcScpCd() {
		return comboObjects[0].Code;
	}
  /**
    * gline_seq 값을 리턴하는 함수 <br>
    * <br><b>Example :</b>
    * <pre>
    *     getGlineSeq();
    * </pre>
    * @returns String
    * @author 최성민
    * @version 2009.04.17
    */
	function getGlineSeq() {
		return comboObjects[1].Code;
	}
  /**
    * note_nm_cd 값을 리턴하는 함수 <br>
    * <br><b>Example :</b>
    * <pre>
    *     getNoteNmCd();
    * </pre>
    * @returns String
    * @author 최성민
    * @version 2009.04.17
    */
	function getNoteNmCd() {
   		return comboObjects[2].Code;
   	}
    /**
     * note_nm_txt 값을 리턴하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     *     getNoteNmTxt();
     * </pre>
     * @returns String
     * @author 최성민
     * @version 2009.04.17
     */
	function getNoteNmTxt() {
   		//return comboObjects[2].GetText(code,0);
    	 return comboObjects[2].Text;
   	}
    /**
    * cust_type_cd 값을 리턴하는 함수 <br>
    * <br><b>Example :</b>
    * <pre>
    *     getCustTypeCd();
    * </pre>
    * @returns String
    * @author 최성민
    * @version 2009.04.17
    */
	function getCustTypeCd() {
  		return comboObjects[3].Code;
  	}
    /**
    * eff_dt 값을 리턴하는 함수 <br>
    * <br><b>Example :</b>
    * <pre>
    *     getEffDt();
    * </pre>
    * @returns String
    * @author 최성민
    * @version 2009.04.17
    */
	function getEffDt() {
		return document.form.eff_dt.value;
	}
    /**
    * exp_dt 값을 리턴하는 함수 <br>
    * <br><b>Example :</b>
    * <pre>
    *     getExpDt();
    * </pre>
    * @returns String
    * @author 최성민
    * @version 2009.04.17
    */
	function getExpDt() {
		return document.form.exp_dt.value;
	}
	
	
    /**
    * 변경사항이 있으면 true 리턴하는 함수 <br>
    * <br><b>Example :</b>
    * <pre>
    *     checkModified(formObj);
    * </pre>
    * @returns boolean
    * @author 최성민
    * @version 2009.04.17
    */
 	function checkModified(formObj) {
 		isModified = false;
		if (formObj.note_ref_yr.value != formObj.note_ref_yr_hidden.value 
    		|| formObj.exp_dt.value != formObj.exp_dt_hidden.value
    		|| getGlineSeq() != formObj.eff_dt_hidden.value 
    		|| getNoteNmTxt() != formObj.note_nm_hidden.value
    		|| getSvcScpCd() != formObj.svc_scp_cd_hidden.value
    		|| getCustTypeCd() != formObj.prc_cust_tp_cd_hidden.value 
    		|| sheetObjects[1].IsDataModified 
    		|| sheetObjects[2].IsDataModified) {
			
			isModified = true;
		}
 			
 		return isModified;
 	}
	
	
 	/**
     * 날짜에 -를 세팅한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *      setDash(comboObject)
     * </pre>
     * @param {string} 날짜 comboObject
     * @return string
     * @author 이승준
     * @version 2009.05.18
     */
	function setDashIBCombo(obj) {
	
	   if(obj.Text == "" || obj.Text.length == 0) return;
	   
	   var date = obj.Text.replace(/-/g, ""); 
	   
	   if(!ComIsNumber(date,'0123456789')) {
			ComShowCodeMessage('PRI00311');
			obj.Text2 = "";
			return;
		}
	   
	   var str = "";
	   for(var i=0; i<date.length; i++) {
		   if(i == 4 || i == 6) {
			  str += "-" + date.substring(i,i+1);
		   } 
		   else {
			  str += date.substring(i,i+1);
		   }
	   }
	   obj.Text2 = str;
	   
	}
	
	/**
     * 날짜에 -를 세팅한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *      setDash(date)
     * </pre>
     * @param {string} 날짜 input box의 value
     * @return string
     * @author 이승준
     * @version 2009.05.18
     */
	function setDash(value) {
		
	   if(value == "" || value.length == 0) return;
	   
	   var date = ComTrimAll(value).replace(/-/g, ""); 
	   
	   var str = "";
	   for(var i=0; i<date.length; i++) {
		   if(i == 4 || i == 6) {
			  str += "-" + date.substring(i,i+1);
		   } 
		   else {
			  str += date.substring(i,i+1);
		   }
	   }
	   return str;

	}
	
	
	/**
     * 날짜에 -를 remove한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *      removeDash(date)
     * </pre>
     * @param {string} 날짜 input box의 value
     * @return string
     * @author 이승준
     * @version 2009.05.18
     */
	function removeDash(date) {
		
	   if(date == "" || date.length == 0) return;
	   
	   date = date.replace(/-/g, ""); 
	

	   return date;

	}
	
 	/**
      * MODE에 따라서 버튼을 컨트롤하는 함수 <br>
      * <br><b>Example :</b>
      * <pre>
      *     toggleButtons(mode);
      * </pre>
      * @param {string} mode MODE값
      * @return 없음
      * @author 이승준
      * @version 2009.05.18
      */
	function toggleButtons(mode) {
		
		switch (mode) {
		
		case "CONF_YES":
			enableButton("btn_retrieve");
			enableButton("btn_new");
			disableButton("btn_save");
			disableButton("btn_confirm");
			enableButton("btn_cancel");
			disableButton("btn_delete3");
			enableButton("btn_copy");
			break;
		case "CONF_NO":
			enableButton("btn_retrieve");
			enableButton("btn_new");
			enableButton("btn_save");
			enableButton("btn_confirm");
			disableButton("btn_cancel");
			enableButton("btn_delete3");
			enableButton("btn_copy");
			break;
		case "IBCOPY":
			enableButton("btn_retrieve");
			enableButton("btn_new");
			enableButton("btn_save");
			disableButton("btn_confirm");
			disableButton("btn_cancel");
			disableButton("btn_delete3");
			disableButton("btn_copy");
			break;	
		case "CONV":
			enableButton("btn_save");
			break;	
			
		}
	}


 	/**
     * 저장시 dp_seq 세팅하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 이승준
     * @version 2009.05.18
     */
 	function setDpSeq(sheetObj)  {
 		if(!sheetObj.IsDataModified) return;
 		
 		for(var i=1; i<=sheetObj.RowCount; i++) {
 			sheetObj.CellValue2(i, "dp_seq") = i;

 			if(sheetObj.RowStatus(i) == "R") {
 				sheetObj.RowStatus(i) = "U";
 			}
 			
 		}

 	}
 	
 	/**
     * 년도 OnKeyPress 시 duration 을 세팅하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     *     searchDuration();
     * </pre>
     * @return boolean
     * @author 이승준
     * @version 2009.05.18
     */
 	function searchDuration() {
 		
 		if(ComIsEmpty(document.form.note_ref_yr)) return;
 		
 		if(!ComIsNumber(document.form.note_ref_yr,'0123456789')) {
 			ComShowCodeMessage('PRI00311');
 			document.form.note_ref_yr.value = "";
 			return;
 		}
 		
 		var formObj = document.form;
 		
 		var length = document.form.note_ref_yr.value.length;
 		
 		if(eventStatus == "IBCOPY") return;
 		
 		if(length == 4) {
 			var note_ref_year = formObj.note_ref_yr.value;
 			if(!ComIsEmpty(formObj.note_hdr_seq.value)) {
	 			if (note_ref_year != formObj.eff_dt.value.substr(0,4) && note_ref_year != formObj.exp_dt.value.substr(0,4)) {
	 				ComShowCodeMessage('PRI00323');
	 				formObj.note_ref_yr.value = formObj.note_ref_yr_hidden.value;
	 				formObj.note_ref_yr.focus();
					return false;
				}
 			}
 		}
 		
	}
 	
 	/**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * 주소입력시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *		ShowMemoPad
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 이승준
     * @version 2009.06.03
     */  	           
     function showMemoPad(sheetObj, Row, Col) {

    	var colname = sheetObj.ColSaveName(Col);  	 
	     
     	switch(colname)
     	{
 	    	case "note_tit_nm":
 	    		ComShowMemoPad(sheetObj,Row,Col,true,932,200);
 	    		
 	    		break;
     	}    	 

    }
 	
 	
 	 /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * 주소입력시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 공백진
     * @version 2009.06.03
     */  	           
     function sheet2_OnClick(sheetObj, Row, Col, Value) {
	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	    var colname = sheetObj.ColSaveName(Col);  	 
	     
     	switch(colname)
     	{
 	    	case "note_ctnt":
 	    		ComShowMemoPad(sheetObj,Row,Col,true,550,200);
 	    		
 	    		break;
     	}    	 

    }
     
     /**
      * OnPopupClick 이벤트 발생시 호출되는 function <br>
      * Standard Note Conversion PopUp을 호출한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
      * @return 없음
      * @author 최성민
      * @version 2009.05.07
      */ 
  	function sheet2_OnPopupClick(sheetObj, Row, Col) {
  		var colName = sheetObj.ColSaveName(Col);
  		var formObj = document.form;
  		var effDt = formObj.eff_dt.value;
  		var expDt = formObj.exp_dt.value;
  		
  		if (colName == "conversion_pop") {
  			if(!ComIsNull(sheetObj.CellValue(Row, "note_conv_mapg_id")))	{
	  			var sParam = "";
	  			sParam += "svc_scp_cd=" + getSvcScpCd();
	  			sParam += "&note_conv_mapg_id=" + sheetObj.CellValue(Row, "note_conv_mapg_id");
	  			sParam += "&prc_ctrt_tp_cd=" + getCustTypeCd();
	  			sParam += "&note_hdr_seq=" + sheetObj.CellValue(Row, "note_hdr_seq");
	  			sParam += "&note_ctnt=" + encodeURIComponent(sheetObj.CellValue( Row, "note_ctnt"));
	  			sParam += "&eff_dt=" + effDt;
	  			sParam += "&exp_dt=" + expDt;
	  			  			
	  			var sUrl = "/hanjin/ESM_PRI_0012.do?"+sParam;
	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_0012", 823, 485, true);
	          
	  			if (rtnVal != null) {
	  				sheetObj.CellValue2(Row, "note_conv_flg") = rtnVal.note_conv_flg;
	  				eventStatus2 = "CONV";
	  				toggleButtons("CONV");
	  			}
  			} else {
  				ComShowCodeMessage("PRI08015");
  			}
  		}
  	}
 	
    
	/* 개발자 작업  끝 */