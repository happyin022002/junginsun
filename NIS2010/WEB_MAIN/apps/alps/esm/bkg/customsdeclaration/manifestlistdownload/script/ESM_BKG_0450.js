/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0450.js
*@FileTitle : ESM_BKG-0450
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.01 임재택
* 1.0 Creation
* 2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련
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
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0450() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick         = sheet1_OnClick;    	 
    }

 // 공통전역변수

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var sel_row = 0;
 var sel_col = 0;

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
 							
 							case "btn_downexcel":
 								sheetObject1.SpeedDown2Excel(0,false,false,"","",false,false,"",false,"Chk","",false,"");
 							break;
 							
 							case "btn_view":
 								doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
 							break;
 							
 							case "btn_history":
 								doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
 							break;																					
 											
 							case "btn_print":
 								doActionIBSheet(sheetObjects[0],document.form,COMMAND03); 					 								
 								break;
 							break;	
 							case "btn_calendar": //달력버튼
				        	// 조회전 일땐 사용못하게 ...
 							if(formObject.vps_eta_start_dt.disabled) return;
				            var cal = new ComCalendarFromTo();
				            cal.select(formObject.vps_eta_start_dt,formObject.vps_eta_end_dt, 'yyyy-MM-dd');
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

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         if(document.form.from_vvd_number.value != "" || document.form.from_pod_cd.value != "")
         {
        	document.form.vvd_number.value = document.form.from_vvd_number.value;
         	document.form.pod_cd.value = document.form.from_pod_cd.value;
         	
         	if(document.form.from_pod_clpt_ind_seq.value != ""){
         		document.form.pod_clpt_ind_seq.value = document.form.from_pod_clpt_ind_seq.value;
         	}
         	
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         }
        	 
         axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
     	 axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
     	 axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
     	 axon_event.addListenerForm("click","obj_click", document.form);
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
           case "sheet1":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 360;
                                         
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

 					          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(13, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "Sel.|Seq.|History|MSG|B/L No.|Sent Date|SND Seq.|Office|USER ID|VVD|POL|POD|POD Calling\nSeq.";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtRadioCheck,	 	40,  	daCenter,    false,  "Chk");  
                     InitDataProperty(0, cnt++ , dtDataSeq,			60,     daCenter,    false,     "Seq",      				false,    "",      dfNone, 			0,     false,		false);                   
                     InitDataProperty(0, cnt++ , dtData,			70,     daCenter,    false,     "hist",      				false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,     		80,    daCenter,    false,     "rtm_edi_msg_tp_cd",      	false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		120,    daCenter,    false,     "bl_no",      				false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		150,    daCenter,    false,     "msg_snd_dt",      			false,    "",      dfUserFormat2, 	0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		70,     daCenter,    false,     "rowcnt",     				false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		70,    daCenter,    false,     "ofc_cd",      				false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		80,    daCenter,    false,     "cre_usr_id",      			false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		110,    daCenter,    false,     "vvd_number",      			false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
  					 InitDataProperty(0, cnt++ , dtData,      		70,     daCenter,    false,     "pol_cd",     				false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		70,     daCenter,    false,     "pod_cd",     				false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		50,     daCenter,    false,     "pod_clpt_ind_seq", 		false,    "",      dfNone, 			0,     false,		false);
 					 
  					 InitUserFormat2(0, "msg_snd_dt", "####-##-## ##:##:##", "-|:" );											
                }
                 break;
           case "sheet2":
                 with (sheetObj) {
                	 // 높이 설정
                     style.height = 230;
                                         
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

 					          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(13, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "Sel.|Seq.|History|MSG|B/L No.|Sent Date|SND Seq.|Office|USER ID|VVD|POL|POD|POD Calling\nSeq.";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtRadioCheck,	 	40,  	daCenter,    false,  "Chk");  
                     InitDataProperty(0, cnt++ , dtDataSeq,			50,     daCenter,    false,     "Seq",      				false,    "",      dfNone, 			0,     false,		false);                   
                     InitDataProperty(0, cnt++ , dtData,			100,     daCenter,    false,     "hist",      				false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,     		115,    daCenter,    false,     "rtm_edi_msg_tp_cd",      	false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		115,    daCenter,    false,     "bl_no",      				false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		150,    daCenter,    false,     "msg_snd_dt",      			false,    "",      dfUserFormat2, 	0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		100,     daCenter,    false,     "rowcnt",     				false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		120,    daCenter,    false,     "ofc_cd",      				false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		120,    daCenter,    false,     "cre_usr_id",      			false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		130,    daCenter,    false,     "vvd_number",      			false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
  					 InitDataProperty(0, cnt++ , dtData,      		75,     daCenter,    false,     "pol_cd",     				false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		75,     daCenter,    false,     "pod_cd",     				false,    "",      dfNone, 			0,     false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      		75,     daCenter,    false,     "pod_clpt_ind_seq", 		false,    "",      dfNone, 			0,     false,		false);
 					 
  					 InitUserFormat2(0, "msg_snd_dt", "####-##-## ##:##:##", "-|:" );								
                }
                 break;
           case "sheet3":
               with (sheetObj) {
                   // 높이 설정
                   style.height = 175;
                                       
                   //전체 너비 설정
                   SheetWidth = mainTable.clientWidth;

                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msHeaderOnly;

                  //전체Edit 허용 여부 [선택, Default false]
                   Editable = true;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo( 1, 1, 3, 100);

					          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                   InitColumnInfo(12, 0, 0, true);

                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   
                   InitHeadMode(true, true, true, true, false,false)

                   var HeadTitle = "Seq.|History|MSG|B/L No.|Sent Date|SND Seq.|Office|USER ID|VVD|POL|POD|POD Callig\nSeq.";

                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle, true);


                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtDataSeq,			50,     daCenter,    false,     "Seq",      				false,    "",      dfNone, 			0,     false,		false);                   
                     InitDataProperty(0, cnt++ , dtData,			50,     daCenter,    false,     "hist",      				false,    "",      dfNone, 			0,     false,		false);
					 InitDataProperty(0, cnt++ , dtData,     		115,    daCenter,    false,     "rtm_edi_msg_tp_cd",      	false,    "",      dfNone, 			0,     false,		false);
					 InitDataProperty(0, cnt++ , dtData,      		115,    daCenter,    false,     "bl_no",      				false,    "",      dfNone, 			0,     false,		false);
					 InitDataProperty(0, cnt++ , dtData,      		150,    daCenter,    false,     "msg_snd_dt",      			false,    "",      dfUserFormat2, 	0,     false,		false);
					 InitDataProperty(0, cnt++ , dtData,      		95,     daCenter,    false,     "rowcnt",     				false,    "",      dfNone, 			0,     false,		false);
					 InitDataProperty(0, cnt++ , dtData,      		100,    daCenter,    false,     "ofc_cd",      				false,    "",      dfNone, 			0,     false,		false);
					 InitDataProperty(0, cnt++ , dtData,      		110,    daCenter,    false,     "user_id",      			false,    "",      dfNone, 			0,     false,		false);
					 InitDataProperty(0, cnt++ , dtData,      		100,    daCenter,    false,     "vvd_number",      			false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
					 InitDataProperty(0, cnt++ , dtData,      		80,     daCenter,    false,     "pol_cd",     				false,    "",      dfNone, 			0,     false,		false);
					 InitDataProperty(0, cnt++ , dtData,      		80,     daCenter,    false,     "pod_cd",     				false,    "",      dfNone, 			0,     false,		false);
					 
					 InitDataProperty(0, cnt++ , dtData,      		80,     daCenter,    false,     "pod_clpt_ind_seq",			false,    "",      dfNone, 			0,     false,		false);
					 
					 InitUserFormat2(0, "msg_snd_dt", "######## ##:##:##", "-|:" );										
              }
               break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 					case IBSEARCH:      //조회 		
 					if(!validateForm(sheetObj,formObj,sAction)) {
 						return false;
 					}
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true); 
 					if(formObj.vvd_number.value.length > 0)
 	            	{
 						formObj.vsl_cd.value     = formObj.vvd_number.value.substring(0,4);
 						formObj.skd_voy_no.value = formObj.vvd_number.value.substring(4,8);
 						formObj.skd_dir_cd.value = formObj.vvd_number.value.substring(8); 	            		 
 	            	}
 					
 					 
 					 formObj.f_cmd.value = SEARCH;
 					 formObj.msg_type.value = formObj.sel_msg_type.value;
 					 sheetObj.DoSearch("ESM_BKG_0450GS.do", FormQueryString(formObj));
 					ComOpenWait(false);  
 					break;
 					
 					case IBSAVE:        //저장
 						if(validateForm(sheetObj,formObj,sAction))
 							alert (" Save .. ");
 					break;
 					
 					case COMMAND01:        //히스토리
 						if(!validateForm(sheetObj,formObj,sAction)) {
 							return false;
 						}
 						view_history(sel_row,sel_col);
					break;
 					case COMMAND03:        //print
						sheetObjects[2].RemoveAll();
						 if(sheetObjects[0].RowCount >0)
					     {
	 						 
					    	for(var i=0; i<=sheetObjects[0].RowCount; i++){
					    		sheetObjects[2].DataInsert(i);  
					    		sheetObjects[2].CellValue2(i,"Seq") = sheetObjects[0].CellValue(i,"Seq");
					    		sheetObjects[2].CellValue2(i,"hist") = sheetObjects[0].CellValue(i,"hist");
					    		sheetObjects[2].CellValue2(i,"rtm_edi_msg_tp_cd") = sheetObjects[0].CellValue(i,"rtm_edi_msg_tp_cd");
					    		sheetObjects[2].CellValue2(i,"bl_no") = sheetObjects[0].CellValue(i,"bl_no");
					    		//str = sheetObjects[0].CellValue(i,"msg_snd_dt");
					    		//sheetObjects[2].CellValue2(i,"msg_snd_dt") = str.substring(2);
					    		sheetObjects[2].CellValue2(i,"msg_snd_dt") = sheetObjects[0].CellValue(i,"msg_snd_dt");				    		 
					    		sheetObjects[2].CellValue2(i,"vvd_number") = sheetObjects[0].CellValue(i,"vvd_number");
					    		sheetObjects[2].CellValue2(i,"pol_cd") = sheetObjects[0].CellValue(i,"pol_cd");
					    		sheetObjects[2].CellValue2(i,"pod_cd") = sheetObjects[0].CellValue(i,"pod_cd");
					    		sheetObjects[2].CellValue2(i,"rowcnt") = sheetObjects[0].CellValue(i,"rowcnt");
					    		sheetObjects[2].CellValue2(i,"ofc_cd") = sheetObjects[0].CellValue(i,"ofc_cd");
					    		sheetObjects[2].CellValue2(i,"user_id") = sheetObjects[0].CellValue(i,"cre_usr_id");				    		 		    		
					    		
					    		// Add. 2015.04.20
					    		sheetObjects[2].CellValue2(i,"pod_clpt_ind_seq") = sheetObjects[0].CellValue(i,"pod_clpt_ind_seq");
					    	}
					     }
	 					 
	 					sheetObjects[2].RowDelete(sheetObjects[2].RowCount,false);
 						if( sheetObjects[2].RowCount==0 ) {
							ComShowCodeMessage("BKG00889");
							return;
						} 						
						ComOpenWindowCenter("/hanjin/ESM_BKG_0450_1.do?pgmNo=ESM_BKG_0450_1", "0450_1", 1000, 700, false);
					break;
 					case COMMAND02:        //LOG View
 						if(!validateForm(sheetObj,formObj,sAction)) {
							return false;
						} 
 						var sUrl = "/hanjin/ESM_BKG_1027.do?pgmNo=ESM_BKG_10278&rcv_snd_div_cd=S&sheet_msg_snd_dt="+formObj.sheet_msg_snd_dt.value+"&sheet_bl_no="+formObj.sheet_bl_no.value;
 						ComOpenWindowCenter(sUrl, "ESM_BKG_1027", 500, 410, true);
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
     	 	
     	 	if(formObj.date_gubun.value == "2" && formObj.vps_eta_start_dt.value.length > 0 && !ComIsDate(formObj.vps_eta_start_dt.value, "ymd"))
  			{
  				ComShowCodeMessage('BKG00377');
  				formObj.vps_eta_start_dt.focus();
  				return false;
  			}
       		if(formObj.date_gubun.value == "2" &&formObj.vps_eta_end_dt.value.length > 0 && !ComIsDate(formObj.vps_eta_end_dt.value, "ymd"))
  			{
  				ComShowCodeMessage('BKG00377');
  				formObj.vps_eta_end_dt.focus();
  				return false;
  			}
       		if (formObj.date_gubun.value == "2" && ComChkPeriod(formObj.vps_eta_start_dt.value, formObj.vps_eta_end_dt.value) < 1 )
			{
				//alert("기간이 정확하지 않습니다.");
       			ComShowCodeMessage('BKG00377');
				formObj.vps_eta_start_dt.focus();
				return false;				
			}
       		if(formObj.date_gubun.value == "2" && !ComIsTime(formObj.fromtime.value, "hm"))
       		{
       			ComShowCodeMessage('BKG00421');
       			formObj.fromtime.focus();
   				return false;
       		}
       		if(formObj.date_gubun.value == "2" && !ComIsTime(formObj.totime.value, "hm"))
       		{
       			ComShowCodeMessage('BKG00421');
       			formObj.totime.focus();
   				return false;
       		}
       		if(formObj.date_gubun.value == "2")
       		{
       			var iDays = ComGetDaysBetween(formObj.vps_eta_start_dt.value, formObj.vps_eta_end_dt.value);
       			if(iDays > 14)
       			{
       				ComShowCodeMessage('BKG40014','2');
       				return false;
       			}
       		}
       		 
       		if( ComGetLenByByte(formObj.bl_no) > 0 && ComGetLenByByte(formObj.bl_no) < 12)
		     {
		    	ComShowCodeMessage('BKG00709');
 				formObj.bl_no.focus();
 				return false;
		     }
       		if( ComGetLenByByte(formObj.pol_cd) > 0 && ComGetLenByByte(formObj.pol_cd) < 5)
		     {
		    	ComShowCodeMessage('BKG00711');
				formObj.pol_cd.focus();
				return false;
		     }
       		if( ComGetLenByByte(formObj.pod_cd) > 0 && ComGetLenByByte(formObj.pod_cd) < 5)
		     {
		    	ComShowCodeMessage('BKG00712');
				formObj.pod_cd.focus();
				return false;
		     }
       		if(formObj.date_gubun.value == "1" && ComGetLenByByte(formObj.vvd_number) > 0 && ComGetLenByByte(formObj.vvd_number) < 9)
 		     {
 		    	ComShowCodeMessage('BKG00710');
  				formObj.vvd_number.focus();
  				return false;
 		     }
       		if(formObj.date_gubun.value == "1" && ComGetLenByByte(formObj.vvd_number) == 0)
		     {
		    	ComShowCodeMessage('BKG00710');
 				formObj.vvd_number.focus();
 				return false;
		     }
       		
       		// Add. 2015.04.20
       		if(ComGetLenByByte(formObj.pod_cd) <5 && ComGetLenByByte(formObj.pod_clpt_ind_seq)>0)
		     {
		    	ComShowCodeMessage('BKG00210');
				formObj.pod_cd.focus();
				return false;
		     }
		      
     	 return true;
				break;
     	 	case COMMAND01: // 히스토리
     	 	if(sel_row == 0 )
       		{       		 
     	 		ComShowCodeMessage('BKG00249');
       			return false;       			
       		}
     	 	if(sheetObjects[0].CellValue(sel_row,"hist") == "H")
	        {     	 		  
	        	  ComShowCodeMessage('BKG06034');
	        	  return false;
	        }
     	 	return true;
			break;
			
     	 	case COMMAND02: // 히스토리
     	 	if(sel_row == 0 )
       		{       		 
     	 		ComShowCodeMessage('BKG00249');
       			return false;       			
       		}
     	 	return true;
			break;
     	 	
     	 }            
     }
      /**
       * 화면에서 검색조건으로 radio버트 선택에 따라서 검색조건 화면 화성화 비활성화 작업
       * @return
       */
      function obj_click(){
     	 
     	 for(var i = 0; i < document.form.gubun.length; i++) {
     		    if(document.form.gubun[i].checked) {
     		      if(document.form.gubun[i].value == 1)
     		      {
     		    	  document.form.vvd_number.disabled = false;
     		    	  document.form.vps_eta_start_dt.disabled = true;
     		    	  document.form.vps_eta_end_dt.disabled = true;
     		    	  document.form.fromtime.disabled = true;
     		    	  document.form.totime.disabled = true;     		    	  
     		    	  document.form.date_gubun.value = "1";
     		    	  
     		      }
     		      if(document.form.gubun[i].value == 2)
     		      {
     		    	  document.form.vvd_number.disabled = true;
     		    	  document.form.vvd_number.value = "";
     		    	  document.form.vsl_cd.value = "";
     		    	  document.form.skd_voy_no.value = "";
     		    	  document.form.skd_dir_cd.value = "";
     		    	  document.form.vps_eta_start_dt.disabled = false;
     		    	  document.form.vps_eta_end_dt.disabled = false;
     		    	  document.form.fromtime.disabled = false;
     		    	  document.form.totime.disabled = false;     		    	  
     		    	  document.form.date_gubun.value = "2";
     		      }
     		 }
         }
      }  
      
      /**
       * 그리드에서 선택한 row갑을 변수명에 넣는다.(히스토리 조회하기 위해서)
       * @param SheetObj
       * @param Row
       * @param Col
       * @return
       */ 
      function sheet1_OnClick(SheetObj, Row, Col){
    	  sel_row = Row;
    	  sel_col = Col;    	   
     	  document.form.sheet_bl_no.value = sheetObjects[0].CellValue( Row, "bl_no" );
     	  document.form.sheet_msg_snd_dt.value = sheetObjects[0].CellValue( Row, "msg_snd_dt" );
       }
       
       /**
        * 조회된 ROW를 선택하면 해당 bl_no 의 이전History 데이타를 보여준다.
        * @param row
        * @param col
        * @return
        */
       function view_history(row,col)
       {
    	  
     	  document.form.f_cmd.value = SEARCH01; 
     	  var rownumber = 0;     	  
     	  sheetObjects[1].DoSearch("ESM_BKG_0450GS.do", FormQueryString(document.form));     	   
     	  for(var i=0; i<sheetObjects[1].RowCount+1; i++) {     		 
     		  if (i > 0) {
     			 sheetObjects[0].CellValue2(row,"hist") = "H";
     			  rownumber = sheetObjects[0].DataInsert();
     		  }
     		  for(var col=0;col<=sheetObjects[1].LastCol ;col++){
     			 sheetObjects[0].CellValue2(rownumber, col) = sheetObjects[1].CellValue(i, col);
 	            }
     	  }
       }
        
        /**
         * Enter 이벤트(조회처리)
         * @return
         */
        function obj_ComKeyEnter() {
        	
         	var formObject = document.form;
         	var srcName    = window.event.srcElement.getAttribute("name");
            
         	if( srcName != "") {         		 
         		ComKeyEnter();
         	}         	         
        }
        
        /**
        * HTML Control의 onkeyUp이벤트에서 키보드 입력을 제어한다.
        **/
        function obj_KeyUp() {
        	     
        	    var formObject = document.form;        
        	    var srcName = window.event.srcElement.getAttribute("name");
        	    var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
        	    var srcValue = window.event.srcElement.getAttribute("value");
        	    if (ComChkLen(srcValue, srcMaxLength) == "2") {
        	    	ComSetNextFocus();        	    		
        	    }
        }
        
        