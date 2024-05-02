/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0186.js
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
    function esm_bkg_0186() {
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
         initControl();	 
         //if( document.form.popup.value == 'y' ){
        //	 document.getElementById("navi").style.display = "none";
         //}
    	 if( document.form.vvd.value != '' ){
        	document.form.f_cmd.value = SEARCH01;
 	 		var aryPrefix = new Array("sheet2_"); //prefix 문자열 배열
 	     	sheetObjects[1].DoSearch("ESM_BKG_0186GS_1.do?vvd="+document.form.vvd.value, FormQueryString(document.form) + "&" + ComGetPrefixParam(aryPrefix));
 	     	
 	     	//vvdValue = sheetObjects[1].CellValue( 1, 2 );
 	     	var vvdNm      = sheetObjects[1].CellValue( 1, 2 );
 	     	var accept     = sheetObjects[1].CellValue( 1, 3 );
 	     	var ssrNoValue = sheetObjects[1].CellValue( 1, 4 );
 	
 	     	document.form.vvd_nm.value = vvdNm;
 	     	document.form.svc_rqst_no.value = ssrNoValue;
 		    
 	     	
	     	if( 'A' != accept )
	     		document.form.anr_msg_sts_cd.src = 'img/btng_icon_r.gif'; 
	     	else
	     		document.form.anr_msg_sts_cd.src = 'img/btng_icon_b.gif';
 	    
	     	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        	//document.getElementById("headtitle").innerHTML="<tr><td class='title'><img src='img/icon_title_dot.gif' align='absmiddle'><span id='title'></span></td></tr>"
        }
        
         //document.form.vvd.value = 'AENA0052'
 		 //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
	 	
	 	var vvdValue   = formObject.vvd.value;
	 	//var ssrNoValue = formObject.ssr_no.value;
	 	if ( ComChkLen(vvdValue, 9) == "2" ) {
	 		document.form.f_cmd.value = SEARCH01;
	 		var aryPrefix = new Array("sheet2_"); //prefix 문자열 배열
	     	sheetObjects[1].DoSearch("ESM_BKG_0186GS_1.do?vvd="+vvdValue, FormQueryString(document.form) + "&" + ComGetPrefixParam(aryPrefix));
	     	
	     	//vvdValue = sheetObjects[1].CellValue( 1, 2 );
	     	var vvdNm      = sheetObjects[1].CellValue( 1, 2 );
	     	var accept     = sheetObjects[1].CellValue( 1, 3 );
	     	var ssrNoValue = sheetObjects[1].CellValue( 1, 4 );
	
	     	document.form.vvd_nm.value = vvdNm;
	     	document.form.svc_rqst_no.value = ssrNoValue;
	     	
	     	if( 'A' != accept )
	     		document.form.anr_msg_sts_cd.src = 'img/btng_icon_r.gif'; 
	     	else
	     		document.form.anr_msg_sts_cd.src = 'img/btng_icon_b.gif';
	     	
	 	}
	 	
	 	if (ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
	 }

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		         var sheetObject1 = sheetObjects[0];
 		         var sheetObject2 = sheetObjects[1];
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 					switch(srcName) {

 						case "btn_retrieve":
 							doActionIBSheet(sheetObject1,document.form,IBSEARCH);
 						break;

 						case "btn_new":
 							sheetObject1.RemoveAll();
							formObject.reset();
 						break;
 						
 						case "btn_sendfile":
 							if (validateForm(sheetObjects[0], formObject, COMMAND01)) {
 								var selrow = sheetObjects[0].selectRow;
 								var rowNum = sheetObjects[0].selectRow;
 								if( rowNum%2 == 1 ) rowNum = rowNum - 1 ;
 								ComOpenPopup("/hanjin/ESM_BKG_0184.do?popup=y&cusrep=y&msg_tp_cd=R&rcv_snd_div_cd=S" 
 										+ "&ref_seq="	+sheetObjects[0].CellValue(rowNum, "ref_seq" ) 
 										+ "&anr_decl_no="	+sheetObjects[0].CellValue(rowNum, "anr_decl_no" )
 										, 700, 640, "0002", "1,0", false);
 								
 								/*
 								ComOpenWindow2("/hanjin/ESM_BKG_0184.do?msg_tp_cd=R&rcv_snd_div_cd=S" 
 										+ "&ref_seq="	+sheetObjects[0].CellValue(sheetObjects[1].selectRow, "ref_seq" ) 
 									    + "&anr_decl_no="	+sheetObjects[0].CellValue(sheetObjects[1].selectRow, "anr_decl_no" )
 									     ,"openGJSrch", "statebar=no,width=400,height=250,left=200,top=0"); 
 								*/
 							}
 						break;
 						
 						case "btn_receivefile":
 							var rowNum = sheetObjects[0].selectRow;
 							var selrow = sheetObjects[0].selectRow;
							var rowNum = sheetObjects[0].selectRow;
							if( rowNum%2 == 1 ) rowNum = rowNum - 1 ;
 							if (validateForm(sheetObjects[0], formObject, COMMAND01)) {
 								ComOpenPopup("/hanjin/ESM_BKG_0184.do?popup=y&cusrep=y&msg_tp_cd=R&rcv_snd_div_cd=R" 
 										+ "&ref_seq="	+sheetObjects[0].CellValue(rowNum, "ref_seq" )  
 										+ "&anr_decl_no="	+sheetObjects[0].CellValue(rowNum, "anr_decl_no" )
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
 								style.height = 400;
 								//전체 너비 설정
 								SheetWidth = mainTable.clientWidth;

 								//Host정보 설정[필수][HostIp, Port, PagePath]
 								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 								//전체Merge 종류 [선택, Default msNone]
 								MergeSheet = msAll;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = false;

 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(2, 2, 3, 100);

 								var HeadTitle1 = "|Seq.|Send Status|Send Date|Send ID|Send Office|VVD|Declaration No.|REF Seq.";
 								var HeadTitle2 = "|Seq.|Receive Status|Receive Date|Error Code|Error Description|Error Description|Error Description|Error Description|Error Description";
 																
 								//var headCount = ComCountHeadTitle(HeadTitle1);

 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(9, 0, 0, true);

 								// //해더모드[선택][SORT=true,COLUMNMOVE=false,ALLCHECK=true,USERRESIZE=true]
 								InitHeadMode(false, true, false, true, false,false);
 								//InitHeadMode(true, true, false);
 								
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								InitHeadRow(1, HeadTitle2, true);
 																
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,	10,		daCenter,		true,		"ibflag");
 								InitDataProperty(0,		cnt++ , dtSeq,					45,		daCenter,		true,		"SEQ");
 								InitDataProperty(0,		cnt++ , dtData,					110,	daCenter,		false,		"edi_snd_sts_cd");
 								InitDataProperty(0,		cnt++ , dtData,					200,	daCenter,		false,		"snd_dt",				false,		"",		dfUserFormat2,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					120,	daCenter,		false,		"edi_snd_usr_id");
                                                                                                                                             
 								InitDataProperty(0,		cnt++ , dtData,					110,	daCenter,		true,		"snd_ofc_cd");
 								InitDataProperty(0,		cnt++ , dtData,					120,	daCenter,		true,		"vvd");
 								InitDataProperty(0,		cnt++ , dtData,					190,	daCenter,		true,		"anr_decl_no");
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"ref_seq");
                                                                                                                                             
                                                                                                                                             
 								cnt = 0;												                                                                                            
 								InitDataProperty(1,		cnt++ , dtHiddenStatus,	10,		daCenter,		true,		"ibflag");                                       
 								InitDataProperty(1,		cnt++ , dtSeq,					45,		daCenter,		true,		"SEQ");
 								InitDataProperty(1,		cnt++ , dtData,					110,	daCenter,		false,		"edi_rcv_sts_cd");
 								InitDataProperty(1,		cnt++ , dtData,					200,	daCenter,		false,		"rcv_dt",				false,		"",		dfUserFormat2,			0,		false,	true);
 								InitDataProperty(1,		cnt++ , dtData,					120,	daCenter,		true,		"edi_msg_err_id");
                                                                                                                                             
 								InitDataProperty(1,		cnt++ , dtData,					110,	daCenter,		true,		"err");
 								InitDataProperty(1,		cnt++ , dtData,					120,	daCenter,		true,		"err");
 								InitDataProperty(1,		cnt++ , dtData,					190,	daCenter,		true,		"err");
 								InitDataProperty(1,		cnt++ , dtData,					50,		daCenter,		true,		"err");

 								Ellipsis = true;
 								//WordWrap = true;
 								
 								InitUserFormat2(0, "snd_dt", "####-##-## ##:##:##", "-|:" ); 
 								InitUserFormat2(1, "rcv_dt", "####-##-## ##:##:##", "-|:" );	
 								
 								DataRowMerge(1) = true; // 짝수 행은 가로로 머지가 된다.
 			    				
 								
 					}
 						break;
 					case "sheet2":
						with (sheetObj) {

							// 높이 설정
							style.height = 0;
							//전체 너비 설정
							SheetWidth = mainTable.clientWidth;

							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msAll; //msPrevColumnMerge + msHeaderOnly;
							
							//전체Edit 허용 여부 [선택, Default false]
							Editable = true;

							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 2, 3, 100);

							var HeadTitle1 = "|Seq.|vvdNm|accept|ssrNo|";
															
							var headCount = ComCountHeadTitle(HeadTitle1);

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(5, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, false, true, false,false);

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
															
							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							var prefix = 'sheet2_';
							InitDataProperty(0,		cnt++ , dtHiddenStatus,	10,		daCenter,		true,		prefix+"ibflag");
							InitDataProperty(0,		cnt++ , dtData,			45,		daCenter,		true,		prefix+"SEQ",                false,		"",		dfNone,					0,		false,	false);
							InitDataProperty(0,		cnt++ , dtData,			110,	daCenter,		true,		prefix+"vvd_nm",     false,		"",		dfNone,					0,		false,	false);
							InitDataProperty(0,		cnt++ , dtData,			110,	daCenter,		true,		prefix+"anr_msg_sts_cd",     false,		"",		dfNone,					0,		false,	false);
							InitDataProperty(0,		cnt++ , dtData,			200,	daCenter,		true,		prefix+"ssr_no",        false,		"",		dfNone,	                0,		false,	false);
														
					}
					break;				
 			}
 	}
     
     /**
      * 코드값을 읽어와서 Desc 로 바꾸어주는 메서드.
      * @return
      */
     function changeSendStatusCodeToDesc( sCode ){
    	 switch(sCode){
    	 	case 'O':
    	 		return 'Original';
    	 		break;
    	 	case 'C':
    	 		return 'Cancel';
    	 		break;
    	 	case 'R':
    	 		return 'Replace';
    	 		break;
    	 		
    	 }
     }
     
     /**
      * 코드값을 읽어와서 Desc 로 바꾸어주는 메서드.
      * @return
      */
     function changeRecvStatusCodeToDesc( sCode ){
    	 switch(sCode){
    	 	case 'A':
    	 		return 'Accepted';
    	 		break;
    	 	case 'E':
    	 		return 'Error';
    	 		break;
    	 	case 'N':
    	 		return 'Waiting';
    	 		break;
    	 }
     }
     
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

				case IBSEARCH:      //조회
					if(validateForm(sheetObj,formObj,sAction)) {
						
    					formObj.f_cmd.value = SEARCH;
    					var sXml = sheetObj.GetSearchXml("ESM_BKG_0186GS.do", FormQueryString(formObj));
    					sheetObj.Redraw = false; 
    					sheetObj.LoadSearchXml(sXml); 
    					sheetObj.Redraw = true;  
    					
    					for( var i=1; i<sheetObj.RowCount +1; i++ ){
    						sheetObj.CellValue( i+1,2 ) = changeSendStatusCodeToDesc( sheetObj.CellValue( i+1,2 ) );
    						i++;
    						sheetObj.CellValue( i+1,2 ) = changeRecvStatusCodeToDesc( sheetObj.CellValue( i+1,2 ) );
    					}
    					
    				}
    				break;
				
				break;
				
				case IBSAVE:        //저장
					if(validateForm(sheetObj,formObj,sAction))
						alert (" Save .. ");
				break;
				
				case IBINSERT:      // 입력
				break;
 					
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
     	switch (sAction) {
	 		case IBSEARCH: // 조회
	 			if (formObj.vvd.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00626');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 							
	 			return true;
	 		break;	 	
	 		case COMMAND01: //EDIT BL
				if (sheetObjects[1].RowCount <= 0) {
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
    	 if( ( row%2 == 1 ) && ( col == 5 || col == 6 || col == 7 || col == 8 ) ) {
    		 //alert( sheetObj.CellValue(row,col) );
    		 if( sheetObj.CellValue(row,col) != '' )
    			 ComShowMemoPad(sheetObj, null, null, true, 600, 80);	//홀수줄 편집불가능
    	 }
     }

	 		
	/* 개발자 작업  끝 */    