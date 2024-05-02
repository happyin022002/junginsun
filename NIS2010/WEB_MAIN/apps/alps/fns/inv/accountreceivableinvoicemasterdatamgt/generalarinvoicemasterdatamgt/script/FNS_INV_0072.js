/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0072.js
*@FileTitle : Cut-off VVD Entry for New A/R Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.05 한동훈
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.09.07 최도순 [CHM-201005726] ALPS > Cut Over VVD Creation for New A/R Office 보완 요청
* 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
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
     * @class fns_inv_0072 : fns_inv_0072 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0072() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnChange  		= sheet1_OnChange;
    }
    
   	/* 개발자 작업	*/


	 // 공통전역변수
	
	 var sheetObjects = new Array();
	 var sheetCnt = 0;
	 
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	
	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick = processButtonClick;

	 /** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 한동훈
	 * @version 2009.10.19
	 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");


            switch(srcName) {

 				case "btn_RowAdd":
 					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
                    break;
                     
                 case "btn_RowCopy":
                	var index = sheetObjects[0].DataCopy();	
                	rowCopy(index, true);
 					break;
                     
                 case "btn_Delete":
	            	 if(!validateForm(sheetObjects[0],formObject,IBDELETE)) {
	     				return false;
         			 }
                	ComRowHideDelete(sheetObjects[0], "DelChk");
                	break;

                 case "btn_Retrieve":
                	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                    break;

                 case "btn_Save":
                	 doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                     break;
                 
                 case "btn_New":
                	 ComResetAll();
                	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
                     break;

                 case "btn_DownExcel":
                	 sheetObjects[0].SpeedDown2Excel(0, false, false, "", "", false, false, "", false, "|ibflag|DelChk|vsl_cd|skd_voy_no|skd_dir_cd");
                	 //sheetObjects[0].Down2Excel(0, false, false, true, "", "", false, false, "", false, "|ibflag|DelChk|vsl_cd|skd_voy_no|skd_dir_cd");
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
      * IBSheet Object를 sheetObjects 배열로 등록 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj IBSheet Object
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }

     /** 
  	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 * </pre>
  	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
  	 * @return 없음
  	 * @see #
  	 * @author 한동훈
  	 * @version 2009.10.19
  	 */
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++] = combo_obj;
  	}

     /** 
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
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
  		for(var k=0; k<comboObjects.length; k++){
  			initCombo(comboObjects[k],k+1);
  		}  		     		
     }
     
     /** 
  	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object        
       * @return 없음
       * @see #
       * @author 한동훈
       * @version 2009.10.19
       */  	
  	function sheet1_OnLoadFinish(sheetObj){
  		sheetObjects[0].WaitImageVisible = false; 
  		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
        ComSetFocus(document.form.old_ar_ofc_cd2);
        sheetObjects[0].WaitImageVisible = true;
  	}
     
     /** 
  	 * 콤보 초기설정값<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * 
  	 * </pre>
  	 * @param {IBMultiCombo} comboObj  comboObj
  	 * @return 없음
  	 * @see #
  	 * @author 박정진
  	 * @version 2009.10.19
  	 */
    	function initCombo(comboObj, comboNo) {
  		switch (comboObj.id) {
  			case "old_ar_ofc_cd2":
  				with (comboObj) {
  					ValidChar(2,1);
  					MaxLength = 6;
  				}
  				break;
  			case "new_ar_ofc_cd2":
  				with (comboObj) {
  					ValidChar(2,1);
  					MaxLength = 6;
  				}
  				break;
  			}
    	}

     /** 
      * Sheet 기본 설정 및 초기화 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {IBSheet} sheetObj : 시트오브젝트
      * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
 				var sheetID = sheetObj.id;
         switch(sheetID) {

              case "sheet1":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 440;
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

                     var HeadTitle1 = "|Sel|Basis Date|Bound|Lane|Port|VVD|Date|Description|User ID|Updated Date|vsl_cd|skd_voy_no|skd_dir_cd|Old ArOfcCd|New ArOfcCd";
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     var rowCnt = 0;

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,		00,		daCenter,		false,		"ibflag");
					InitDataProperty(0, 		cnt++, 	dtDummyCheck, 		40,		daCenter, 		false,		"DelChk");					
					InitDataProperty(rowCnt,	cnt++,	dtCombo,    		100,	daCenter,		false,		"cut_off_aply_dt_tp_cd",	true,		"",		dfNone,				0,		true,	true);
					
					InitDataProperty(rowCnt,	cnt++,	dtCombo,   		 	90,		daCenter,		false,		"io_bnd_cd",				true,		"",		dfNone,				0,		true,	true);				
					InitDataProperty(rowCnt,	cnt++,	dtData,    			90,		daCenter,		false,		"slan_cd",					true,		"",		dfNone,				0,		true,	true,	3);
					InitDataProperty(rowCnt,	cnt++,	dtData,    			90,		daCenter,		false,		"port_cd",					true,		"",		dfNone,				0,		true,	true,	5);					
					InitDataProperty(rowCnt,	cnt++,	dtData,    			90,		daCenter,		false,		"vvd_cd",					false,		"",		dfNone,				0,		true,	true,	9);					
					InitDataProperty(rowCnt,	cnt++,	dtPopupEdit,   		100,	daCenter,		false,		"aply_dt",					true,		"",		dfDateYmd,			0,		false,	true);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,    		 	200,	daLeft,			false,		"ofc_rmk",					false,		"",		dfNone,				0,		true,	true,	100);
					InitDataProperty(rowCnt,	cnt++,	dtData,    		 	90,		daCenter,		false,		"upd_usr_id",				false,		"",		dfNone,				0,		false,	false);					
					InitDataProperty(rowCnt,	cnt++,	dtData,    		 	70,		daCenter,		false,		"upd_dt",					false,		"",		dfDateYmd,			0,		false,	false);					
					InitDataProperty(rowCnt,	cnt++,	dtHidden,  		 	70,		daCenter,		false,		"vsl_cd",					false,		"",		dfNone,				0,		false);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,  		 	70,		daCenter,		false,		"skd_voy_no",				false,		"",		dfNone,				0,		false);
					
					InitDataProperty(rowCnt,	cnt++,	dtHidden,  		 	70,		daCenter,		false,		"skd_dir_cd",				false,		"",		dfNone,				0,		false);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,  		 	70,		daCenter,		false,		"old_ar_ofc_cd",			false,		"",		dfNone,				0,		false);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,  		 	70,		daCenter,		false,		"new_ar_ofc_cd",			false,		"",		dfNone,				0,		false);

 										
 										//InitDataCombo(0, "io_bnd_cd", "All|O/B|I/B", "A|O|I");
										InitDataCombo(0, "io_bnd_cd", "O/B|I/B", "O|I");
 										InitDataCombo(0, "cut_off_aply_dt_tp_cd", "S/A Date|I/F Date", "S|I");
 										InitDataValid(0, "slan_cd",   	vtEngUpOther,	'0123456789');
 										InitDataValid(0, "port_cd",   	vtEngUpOther,	'0123456789');
 										InitDataValid(0, "vvd_cd",   	vtEngUpOther,	'0123456789');
 										
 										PopupImage = "img/btns_calendar.gif";
 										ShowButtonImage = 2;
 										//CountPosition = 0;
 										
 										
 										
 								}
                 break;

         }
     }

     /** 
      * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
      * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
      * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
      * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function doActionIBSheet(sheetObj,formObj,sAction, Row, Col, Val) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	   case IBSEARCH_ASYNC10: //CreditCustomer Office 조회
         		   //ComboObject_OfcCd2(sheetObj, formObj, formObj.old_ar_ofc_cd2, "N", "N");
         		   //ComboObject_OfcCd2(sheetObj, formObj, formObj.new_ar_ofc_cd2, "N", "N");
         		   var cmbObj = formObj.old_ar_ofc_cd2;
         		   var cmbObj2 = formObj.new_ar_ofc_cd2;
         		    formObj.f_cmd.value = SEARCH04;
         			var sXml = sheetObj.GetSearchXml("FNS_INV_0072GS.do", FormQueryString(formObj));
         			
         			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
         			var arrStr = sStr.split("|");
         			MakeComboObject_OfcCd2(cmbObj, arrStr, "N");
         			MakeComboObject_OfcCd2(cmbObj2, arrStr, "N");

         			var arrStr2 = arrStr[1].split("^");
         			var ar_ofc_cd = arrStr2[1];
         			/*
         			if(select_yn != "N"){
         				cmbObj.text = ar_ofc_cd;
         			}
         			*/
         	        cmbObj.DropHeight = 190;
         	        cmbObj2.DropHeight = 190;
			        break;
	           case IBSEARCH:      //조회
	        	   if(!validateForm(sheetObj,formObj,sAction)) return;
	        	   	if (sheetObj.id == "sheet1") {						
						formObj.f_cmd.value = SEARCH;
         				formObj.old_ar_ofc_cd.value = formObj.old_ar_ofc_cd2.Text;
         				formObj.new_ar_ofc_cd.value = formObj.new_ar_ofc_cd2.Text;
						sheetObj.DoSearch("FNS_INV_0072GS.do", FormQueryString(formObj));
					}
	        	   	//rowCopy(0, false);
	        	   	
	        	   	for (var i=1; i<=sheetObj.RowCount; i++) {
						rowCopy(i, false);
					}
	                 break;
	
	           case IBSAVE:        //저장
	        	   	if(!validateForm(sheetObj,formObj,sAction)) return;
	        	   	if(sheetObj.RowCount == 0) return;
	        	   	
					formObj.f_cmd.value = MULTI;					
					var sParam = ComGetSaveString(sheetObjects);
					if (sheetObj.IsDataModified && sParam == "") return; 
					
                    sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var SaveXml = sheetObj.GetSaveXml("FNS_INV_0072GS.do", sParam );
					sheetObj.LoadSaveXml(SaveXml);
					
					if (SaveXml.indexOf(">OK<") > -1){
						for (var i=1; i<=sheetObj.RowCount; i++) {
							rowCopy(i, false);
						}
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					}
					break;
	
	 			case IBINSERT:      // 입력
	 				if(!validateForm(sheetObj,formObj,sAction)) return;
					var sheetIdx = sheetObj.DataInsert(-1);
					sheetObj.CellValue2(sheetIdx,"old_ar_ofc_cd") = formObj.old_ar_ofc_cd2.Text;
					sheetObj.CellValue2(sheetIdx,"new_ar_ofc_cd") = formObj.new_ar_ofc_cd2.Text;
					BasesDate_change(sheetObj,sheetIdx,Col,"S");
					//sheetObj.CellValue2(sheetIdx,"slan_cd") = "QQQ";
					//sheetObj.CellValue2(sheetIdx,"port_cd") = "ADSJL";
					//sheetObj.CellValue2(sheetIdx,"vvd_cd") = "1AHT0302N";					
	                 break;
	                 
	 			case IBSEARCH_ASYNC01:      //조회	
	 				if(Val != ""){
	 					formObj.f_cmd.value = SEARCH01;					
						var sXml = sheetObj.GetSearchXml("FNS_INV_0072GS.do", FormQueryString(formObj));
						
						var arrXml = sXml.split("|$$|");
						var dataVal = ComGetEtcData(arrXml[0],"dataVal");
						if(dataVal == ""){          									
							ComShowCodeMessage("INV00041","["+Val+"]");
							//alert(Row+"----"+Col);
							var selCol = sheetObj.SelectCol
							sheetObj.SelectCell(Row, Col);
						}						
					}
	                 break; 
	 			case IBSEARCH_ASYNC02:      //조회		
	 				if(Val != ""){
	 					formObj.f_cmd.value = SEARCH02;					
						var sXml = sheetObj.GetSearchXml("FNS_INV_0072GS.do", FormQueryString(formObj));
						var arrXml = sXml.split("|$$|");
						var dataVal = ComGetEtcData(arrXml[0],"dataVal");
						if(dataVal == ""){
							ComShowCodeMessage("INV00041","["+Val+"]");
							sheetObj.SelectCell(Row, Col);
						}
					}
	                 break; 
	 			case IBSEARCH_ASYNC03:      //조회	
	 				if(Val != ""){	 					
	 					formObj.f_cmd.value = SEARCH03;					
						var sXml = sheetObj.GetSearchXml("FNS_INV_0072GS.do", FormQueryString(formObj));
						var arrXml = sXml.split("|$$|");
						var dataVal = ComGetEtcData(arrXml[0],"dataVal");						
						if(dataVal == ""){
							ComShowCodeMessage("INV00041","["+Val+"]");
							sheetObj.SelectCell(Row, Col);
						}else{
							var saDate = ComGetEtcData(arrXml[0],"saDate");
							sheetObj.CellValue(Row, 'aply_dt') = saDate;
							if(saDate == ""){
								ComShowCodeMessage("INV00011");
								sheetObj.SelectCell(Row, 'aply_dt');
							}
						}	
					}	
	                 break;      
         }
     }     
     
     /** 
      * Sheet Cell의 editable에 대한 속성을 세팅함. <br>
      * state : true(활성화), false(비활성화)
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {int} sheetIdx : 선택한 sheet의 cell에 대한 row값  
      * @param  {boolean} state : true(활성화), false(비활성화)
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function rowCopy(sheetIdx, state){
    	sheetObjects[0].CellEditable(sheetIdx,'io_bnd_cd') = state;
 		sheetObjects[0].CellEditable(sheetIdx,'slan_cd') = state;
 		sheetObjects[0].CellEditable(sheetIdx,'port_cd') = state;
 		sheetObjects[0].CellEditable(sheetIdx,'vvd_cd') = state;
 		sheetObjects[0].CellEditable(sheetIdx,'cut_off_aply_dt_tp_cd') = state;
 		sheetObjects[0].CellEditable(sheetIdx,'aply_dt') = state;
     }
          
     /** 
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
      * @return true, false
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction) {
 			case IBSEARCH:
	         	if (formObj.old_ar_ofc_cd2.text == "") {
	         		ComShowCodeMessage('INV00004');
    				ComSetFocus(form.old_ar_ofc_cd2);
	 				return false;
	 			}
	         	if (formObj.new_ar_ofc_cd2.text == "") {
	         		ComShowCodeMessage('INV00004');
    				ComSetFocus(form.new_ar_ofc_cd2);
	 				return false;
	 			}
	 			break;
 			case IBSAVE:
 				if (formObj.old_ar_ofc_cd2.text == "") {
	         		ComShowCodeMessage('INV00004');
    				ComSetFocus(form.old_ar_ofc_cd2);
	 				return false;
	 			}
	         	if (formObj.new_ar_ofc_cd2.text == "") {
	         		ComShowCodeMessage('INV00004');
    				ComSetFocus(form.new_ar_ofc_cd2);
	 				return false;
	 			}
 				if (formObj.old_ar_ofc_cd2.text == formObj.new_ar_ofc_cd2.text){
 					ComShowCodeMessage('INV00058');
    				ComSetFocus(form.old_ar_ofc_cd2);
	 				return false;
 				}	         	
	 			break;	
 			case IBINSERT:
 				if (formObj.old_ar_ofc_cd2.text == "") {
	         		ComShowCodeMessage('INV00004');
    				ComSetFocus(form.old_ar_ofc_cd2);
	 				return false;
	 			}
	         	if (formObj.new_ar_ofc_cd2.text == "") {
	         		ComShowCodeMessage('INV00004');
    				ComSetFocus(form.new_ar_ofc_cd2);
	 				return false;
	 			}
 				if (formObj.old_ar_ofc_cd2.text == formObj.new_ar_ofc_cd2.text){
 					ComShowCodeMessage('INV00058');
    				ComSetFocus(form.old_ar_ofc_cd2);
	 				return false;
 				}	         	
	 			break;
 			case IBDELETE:
 				if (sheetObj.CheckedRows("DelChk") == 0) {
 					ComShowMessage(msgs["INV00025"]);
 					return false;
 				} else if (sheetObj.CheckedRows("DelChk") > 0) {
 					if(!ComShowCodeConfirm("INV00028")) return;
 				}
 				break;
    	 }
         return true;
     }
    
     /** 
      * 업무 자바스크립트 OnChange 이벤트 처리 <br>
      * 선택한 항목이 combo list에 있는 데이타 인지 체크 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {object} comboObj : 폼 오브젝트
      * @param  {int} Index_Code : 선택한 항목에 대한 value값
      * @param  {String} Text : 선택한 항목에 대한 text값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */ 
    function old_ar_ofc_cd2_OnChange(comboObj,Index_Code, Text){
    	var formObject = document.form.old_ar_ofc_cd2;
    	var ar_ofc_cd2 = formObject.text;
    	if(ar_ofc_cd2 != ""){
    		formObject.text=ar_ofc_cd2.toUpperCase(); 
	    	//리스트에 있는 ofc_cd 인지 체크
    		if(!ar_ofc_cd_chk(formObject)){
	    		ComSetFocus(formObject);
	    		formObject.focus();
	    		formObject.text = "";
	    		return;
	    	}
    	}
    }
    
    /** 
     * 업무 자바스크립트 OnChange 이벤트 처리 <br>
     * 선택한 항목이 combo list에 있는 데이타 인지 체크 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} comboObj : 폼 오브젝트
     * @param  {int} Index_Code : 선택한 항목에 대한 value값
     * @param  {String} Text : 선택한 항목에 대한 text값
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
    function new_ar_ofc_cd2_OnChange(comboObj,Index_Code, Text){
    	var formObject = document.form.new_ar_ofc_cd2;
    	var ar_ofc_cd2 = formObject.text;
    	if(ar_ofc_cd2 != ""){
    		formObject.text=ar_ofc_cd2.toUpperCase(); 
	    	//리스트에 있는 ofc_cd 인지 체크
	    	if(!ar_ofc_cd_chk(formObject)){
	    		ComSetFocus(formObject);
	    		formObject.focus();
	    		formObject.text = "";
	    		return;
	    	}
    	}
    }
    
    /** 
     * 업무 자바스크립트 체크 이벤트 처리 <br>
     * 선택한 항목이 combo list에 있는 데이타 인지 체크하여 없는 데이타일 경우, 메시지를 출력
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} obj : 폼 오브젝트
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
    function ar_ofc_cd_chk(obj){
    	var formObject = document.form;
    	var ar_ofc_cd_all = formObject.ar_ofc_cd_all.value;
    	var arrStrChg = ar_ofc_cd_all.split("|");
    	var arrStrChg_gb = "N";
    	for (var i = 1; i < arrStrChg.length;i++ ) {
    		if(arrStrChg[i] == obj.text){
    			arrStrChg_gb = "Y";
    		}
    	}
    	if(arrStrChg_gb == "N"){
    		ComShowCodeMessage('INV00041',"["+obj.text+"]");
    		return false;
    	}
    	return true;
    }
     
    /** 
     * sheet상에서 팝업(돋보기) 버튼 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
     * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
  	function sheet1_OnPopupClick(sheetObj, Row,Col)
  		{
  			var formObject = document.form;
  			var param = "";
  			if (sheetObj.ColSaveName(Col) == "aply_dt") {
  				var cal = new ComCalendarGrid("myCal");
  	            cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
  			}
  			
  		}  	
  	/*
  	function sheet1_OnMouseDown111(sheetObj, Button, Shift, X, Y){
  		alert(Button+"::"+Shift+"::"+X+"::"+Y);
  		var Val = sheetObj.CellText(Row,Col);
  		if(sheetObj.MouseRow == -1){
			alert("sheet1_OnMouseDown");
			sheet1_OnChange_event(sheetObj,Row,Col, Val);
		}
  	}
  	*/
  	
  	/** 
     * 업무 자바스크립트 Sheet의 OnSelectCell 이벤트 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {int} OldRow : 포커스가 이동하기 전에 위치해 있는 sheet의 Row
     * @param  {int} OldCol : 포커스가 이동하기 전에 위치해 있는 sheet의 Col
     * @param  {int} NewRow : 포커스가 이동한 후에 위치해 있는 sheet의 Row
     * @param  {int} NewCol : 포커스가 이동한 후에 위치해 있는 sheet의 Col
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
  	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
  		var Val = sheetObj.CellText(OldRow,OldCol);
  		//alert(OldRow+"::"+OldCol+"::"+NewRow+"::"+NewCol+"::"+Val);
  		//alert(sheetObj.MouseCol);
  		//alert("111==="+sheetObjects[0].MouseRow);
  		sheet1_OnChange_event(sheetObj,OldRow,OldCol, Val);
  	}  
  	
  	/*
  	function sheet1_OnAfterEdit11(sheetObj, Row, Col){
  		var Val = sheetObj.CellText(Row,Col);
  		//alert("222==="+sheetObjects[0].MouseRow);  		
		if(sheetObjects[0].MouseRow == -1){
			//alert(Row+"=="+Col);
			sheet1_OnChange_event(sheetObj,Row,Col, Val);
		}
  	}
  	*/
  	
  	/** 
     * 업무 자바스크립트 Sheet의 OnChange 이벤트 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트 
     * @param  {int} Row : 포커스가 위치해 있는 sheet의 Row
     * @param  {int} Col : 포커스가 위치해 있는 sheet의 Col 
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
  	function sheet1_OnChange(sheetObj, Row, Col){
  		var Val = sheetObj.CellText(Row,Col);
  		//alert("222==="+sheetObjects[0].MouseRow);  		
		//if(sheetObjects[0].MouseRow == -1){
			//alert(Row+"=="+Col);
			sheet1_OnChange_event(sheetObj,Row,Col, Val);
		//}
  	}
  	
  	/** 
     * 업무 자바스크립트 Sheet의 OnChange 이벤트에서 호출하는 함수<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트 
     * @param  {int} Row : 포커스가 위치해 있는 sheet의 Row
     * @param  {int} Col : 포커스가 위치해 있는 sheet의 Col 
     * @param  {int} Val : 포커스가 위치해 있는 sheet의 Row,Col의 value값
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
  	function sheet1_OnChange_event(sheetObj,Row,Col, Val){  		
  		if(sheetObj.CellEditable(Row, Col) == false) return; 
  		if(Val == "" || Val == "Lane"|| Val == "Port" || Val == "VVD") return;
  		var formObject = document.form;
  		var cut_off_aply_dt_tp_cd = sheetObj.CellValue(Row,"cut_off_aply_dt_tp_cd");
  		if (sheetObj.ColSaveName(Col) == "cut_off_aply_dt_tp_cd") {
  			BasesDate_change(sheetObj,Row,Col,cut_off_aply_dt_tp_cd);
  		}
  		if(sheetObj.CellValue(Row,"cut_off_aply_dt_tp_cd") == "I"){
  			return;
  		}
  		if (sheetObj.ColSaveName(Col) == "slan_cd") {
  			formObject.slan_cd.value = sheetObj.CellValue(Row,"slan_cd");
  			formObject.f_cmd.value = SEARCH01;
  			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01, Row, Col, Val);
  		}
  		if (sheetObj.ColSaveName(Col) == "port_cd") {
  			if(Val != "ALL"){
  				formObject.port_cd.value = sheetObj.CellValue(Row,"port_cd");
  				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02, Row, Col, Val);
  			}
  		}
  		if (sheetObj.ColSaveName(Col) == "vvd_cd") {
  			sheetObj.CellValue2(Row,"vsl_cd") = Val.substring(0,4);
  			sheetObj.CellValue2(Row,"skd_voy_no") = Val.substring(4,8);
  			sheetObj.CellValue2(Row,"skd_dir_cd") = Val.substring(8,9);
  			formObject.vsl_cd.value = sheetObj.CellValue(Row,"vsl_cd");
  			formObject.skd_voy_no.value = sheetObj.CellValue(Row,"skd_voy_no");
  			formObject.skd_dir_cd.value = sheetObj.CellValue(Row,"skd_dir_cd");
  			formObject.io_bnd_cd.value = sheetObj.CellValue(Row,"io_bnd_cd");
  			
  			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03, Row, Col, Val);
  		}  		
  	}
  	
  	/** 
     * Sheet의 cut_off_aply_dt_tp_cd - OnChange 이벤트에서 호출하는 함수<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트 
     * @param  {int} Row : 포커스가 위치해 있는 sheet의 Row
     * @param  {int} Col : 포커스가 위치해 있는 sheet의 Col 
     * @param  {int} Val : 포커스가 위치해 있는 sheet의 Row,Col의 value값
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
  	function BasesDate_change(sheetObj,Row,Col,Val){
  		if(Val == "S"){
  			sheetObj.InitDataCombo(0, "io_bnd_cd", "O/B|I/B", "O|I");
  			sheetObj.CellValue(Row,"io_bnd_cd") = "O";
  			sheetObj.CellValue(Row,"slan_cd") = "";
  			sheetObj.CellValue(Row,"port_cd") = "";
  			sheetObj.CellValue(Row,"vvd_cd") = "";
  			sheetObjects[0].CellEditable(Row,'io_bnd_cd') = true;
  			sheetObjects[0].CellEditable(Row,'slan_cd') = true;
  			sheetObjects[0].CellEditable(Row,'port_cd') = true;
  			sheetObjects[0].CellEditable(Row,'vvd_cd') = true;
  		}else{
  			sheetObj.InitDataCombo(0, "io_bnd_cd", "All|O/B|I/B", "A|O|I");
  			sheetObj.CellValue(Row,"io_bnd_cd") = "A";
  			sheetObj.CellValue(Row,"slan_cd") = "ALL";
  			sheetObj.CellValue(Row,"port_cd") = "ALL";
  			sheetObj.CellValue(Row,"vvd_cd") = "ALL";
  			sheetObjects[0].CellEditable(Row,'io_bnd_cd') = false;
  			sheetObjects[0].CellEditable(Row,'slan_cd') = false;
  			sheetObjects[0].CellEditable(Row,'port_cd') = false;
  			sheetObjects[0].CellEditable(Row,'vvd_cd') = false;
  		}
  	}
	
	/** 
     * off_cd 콤보박스 출력시 데이타를 추가하기위해 사용<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} cmbObj :  offc_cd 콤보박스 오브젝트
     * @param  {String} arrStr : combo list  데이타
     * @param  {String} allYn : combo - 항목에 ALL|ALL 추가 여부
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function MakeComboObject_OfcCd2(cmbObj, arrStr, allYn) {
		cmbObj.RemoveAll(); 
		var ar_ofc_cd_all = "";
   		for (var i = 1; i < arrStr.length;i++ ) {
   			var arrStr2 = arrStr[i].split("^");
   			var ar_ofc_cd = arrStr2[0];
   			var delt_flg = arrStr2[2];
   			cmbObj.InsertItem(i-1, ar_ofc_cd+"|"+delt_flg, arrStr[i]);
   			ar_ofc_cd_all = ar_ofc_cd_all +"|"+ ar_ofc_cd;
   		}
   		document.form.ar_ofc_cd_all.value = ar_ofc_cd_all;
   		if(allYn=='Y'){
   		cmbObj.InsertItem(0, "ALL", "ALL^ALL");
   		}
   		cmbObj.BackColor = "#CCFFFD";
   		cmbObj.ColFontColor(1) = "Red"; 
   		cmbObj.SetColWidth("80|20");

   	 }
	/* 개발자 작업  끝 */