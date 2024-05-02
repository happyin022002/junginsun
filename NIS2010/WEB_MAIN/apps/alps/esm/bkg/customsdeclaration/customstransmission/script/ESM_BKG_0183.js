/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0183.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.16 정재엽
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    
    /**
     * @extends 
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0183() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	//this.sheet1_OnClick         = sheet1_OnClick;
    	//this.sheet1_OnKeyUp         = sheet1_OnKeyUp;
    }
    
    
    /* 개발자 작업	*/
    

	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
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

 						case "btn_retrieve":
 							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 						break;

 						case "btn_new":
 							sheetObject1.RemoveAll();
							formObject.reset();
 						break;
 						
 						case "btn_sendfile":
 							if (validateForm(sheetObjects[0], formObject, COMMAND01)) {
 								
 								ComOpenPopup("/hanjin/ESM_BKG_0184.do?msg_tp_cd=C&rcv_snd_div_cd=S&popup=y" 
 										+ "&ref_seq="	+sheetObjects[0].CellValue(sheetObjects[0].selectRow, "ref_seq" ) 
 										+ "&anr_decl_no="	+sheetObjects[0].CellValue(sheetObjects[0].selectRow, "anr_decl_no" )
 										, 700, 640, "0002", "1,0", false);
 								
 								
 							}
 						break;
 						
 						case "btn_receivefile":
 							if (validateForm(sheetObjects[0], formObject, COMMAND01)) {
 								ComOpenPopup("/hanjin/ESM_BKG_0184.do?msg_tp_cd=C&rcv_snd_div_cd=R&popup=y" 
 										+ "&ref_seq="	+sheetObjects[0].CellValue(sheetObjects[0].selectRow, "ref_seq" ) 
 										+ "&anr_decl_no="	+sheetObjects[0].CellValue(sheetObjects[0].selectRow, "anr_decl_no" )
 										, 700, 640, "0002", "1,0", false);
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
	    
	    if( document.form.bl_no.value != '' ){
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
	    //alert("test1_1");
	    if( document.form.popup.value == 'y' ){
        	//document.getElementById("navi").style.display = "none";
        	//document.getElementById("headtitle").innerHTML="<tr><td class='title'><img src='img/icon_title_dot.gif' align='absmiddle'><span id='title'></span></td></tr>"
        }
	    //alert("test1_2");
	    
	    
	    //document.form.bl_no.value = 'JXBE02310007' ;
	    initControl();
	    
	}
	
	function initControl() {
	     //Axon 이벤트 처리1. 이벤트catch(개발자변경)
		 axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		 axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		 axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	 }

	/**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	
    	var formObject = document.form;
    	var blno   = formObject.bl_no.value;
    	var cntrno = formObject.cntr_no.value;
    	if ( ComChkLen(blno, 12) == "2" ) {
    		formObject.cntr_no.focus();
    	}
    	if ( ComChkLen(cntrno, 14) == "2" ) {
    		formObject.target_bl.focus();
    	}
    	
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

 					case "sheet1":
 							with (sheetObj) {

 								// 높이 설정
 								style.height = 430;
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

 								var HeadTitle1 = "|Seq.|DIV|Number|VVD|Send\nStatus|Receive\nStatus|Send ID|Send\nOffice|Send Date|Receive Date|Error\nCode|Error Description|Declaration No";
 								
 								var headCount = ComCountHeadTitle(HeadTitle1);

 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(14, 0, 0, true);

 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(true, true, false, true, false,false);

 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 																
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,	10,		daCenter,		true,		"ibflag");
 								//InitDataProperty(0,		cnt++ , dtDataSeq,					50,		daCenter,		true,		"SEQ",             false,		"",		dfNone,					0,		false,		false,	6);
 								InitDataProperty(0,		cnt++ , dtData,				55,		daCenter,		true,		"ref_seq",     false,		"",		dfNone,					0,		false,		false,	14);	
 								InitDataProperty(0,		cnt++ , dtData,					45,		daCenter,		true,		"div",             false,		"",		dfNone,					0,		false,		false);
 								InitDataProperty(0,		cnt++ , dtData,					95,		daCenter,		true,		"bl_cntr_no",          false,		"",		dfNone,					0,		false,		false);
 								// 2015.11.11 ADD
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"vvd",          false,		"",		dfNone,					0,		false,		false);
 								
 								InitDataProperty(0,		cnt++ , dtData,					55,		daCenter,		true,		"edi_snd_sts_cd",       		 false,		"",		dfNone,					0,		false,		false);
                                                                                                                                                 
 								InitDataProperty(0,		cnt++ , dtData,					65,		daCenter,		true,		"edi_rcv_sts_cd",         false,		"",		dfNone,					0,		false,		false);
 								InitDataProperty(0,		cnt++ , dtData,					65,		daCenter,		true,		"edi_snd_usr_id",          false,		"",		dfNone,					0,		false,		false,	8); 
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"snd_ofc_cd",      false,		"",		dfNone,					0,		false,		false,	6);
 								InitDataProperty(0,		cnt++ , dtData,					140,	daCenter,		true,		"snd_dt",        false,		"",		dfUserFormat2,	0,		false,		false);
 								InitDataProperty(0,		cnt++ , dtData,					135,	daCenter,		true,		"rcv_dt",		 false,		"",		dfUserFormat2,	0,		false,		false);
                                                                                                                                                 
 								InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		"edi_msg_err_id",       false,		"",		dfNone,					0,		false,		false);
 								InitDataProperty(0,		cnt++ , dtData,					120,	daCenter,		true,		"err_desc",     false,		"",		dfNone,					0,		false,		false); 
 								InitDataProperty(0,		cnt++ , dtData,					65,		daCenter,		true,		"anr_decl_no",     false,		"",		dfNone,					0,		false,		false,	14);
 								Ellipsis = true;
 								
 								InitUserFormat2(0, "snd_dt", "####-##-## ##:##:##", "-|:" );
 								InitUserFormat2(0, "rcv_dt", "####-##-## ##:##:##", "-|:" );				
 												
 						}
 						break;


 			}
 	}

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					//alert("test1");
					var target;
					if ( formObj.target_bl.checked ){
						target = 'bl_log';
						if ( formObj.target_cntr.checked )
							target = 'all';
					} else if( formObj.target_cntr.checked ) {
						target = 'cntr_log';
					} else {
						target = 'bl_log';
					}
					//alert("test2");
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0183GS.do?target=" +target, FormQueryString(formObj));
					//alert("test3");
					sheetObj.Redraw = false; 
					sheetObj.LoadSearchXml(sXml); 
					sheetObj.Redraw = true;  
					//alert("test4");
					
				}
			
			break;
						
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
	 		case IBSEARCH: // 조회
	 			if (formObj.bl_no.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00626', 'B/L No');
	 				formObj.bl_no.focus();
	 				return false;
	 			}
	 							
	 			return true;
	 		break;
	 		case COMMAND01: //EDIT BL
	 			if (sheetObjects[0].RowCount <= 0) {
					ComShowCodeMessage("BKG00395");
					return false;
				}
	 			return true;
    		break;
    	 }
    }

     /**
      * 셀에 데이터를 메모패드에서 보여지게 하는 메서드.
      * 
      * @param sheetObj
      * @param row
      * @param col
      * @return
      */
     function sheet1_OnClick(sheetObj, row, col){
    	 if( col == 11 ) {
    		 //alert( sheetObj.CellValue(row,col) );
    		 if( sheetObj.CellValue(row,col) != '' )
    			 ComShowMemoPad(sheetObj, null, null, true, 400, 80);	//홀수줄 편집불가능
    	 }
     }

	/* 개발자 작업  끝 */    