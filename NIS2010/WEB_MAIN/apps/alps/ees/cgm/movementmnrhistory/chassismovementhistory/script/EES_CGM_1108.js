/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1108.js
*@FileTitle : Bare Chassis Movement Manual Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.29 최민회
* 1.0 Creation
* 2011.03.02 김영오 [CHM-201109164-01] Bare Chassis Movement Update/Creation   'BI', 'BO'라도 수정 및 삭제가 가능하도록 수정 -315라인
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
     * @class ees_cgm_1108 : ees_cgm_1108 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_1108() {
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

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		var sheetObject1 = sheetObjects[0];
 		var sheetObj = sheetObjects[0];
          /*******************************************************/
        var formObject = document.form;
        var formObj = document.form;
     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
			            case "btn_retrieve":
			            	//sheetObj.WaitImageVisible=false;
			 			 	//ComOpenWait(true);
							doActionIBSheet(sheetObj, formObj, IBSEARCH);
		 	  			    //ComOpenWait(false);
							break;
						case "btn_new":
							sheetObject1.RemoveAll();
							formObject.eq_no.value = '';
							formObject.str_mvmt_dt.value = formObject.calend1.value;
							formObject.end_mvmt_dt.value = formObject.calend1.value;
							formObj.str_gubun[0].checked = true;
							from_Chk();
							formObject.eq_no.focus();
							break;

						case "btn_save":
							doActionIBSheet(sheetObject1, formObject, IBSAVE);
						break;

						case "btn_verify":
							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
							break;

						case "btn_add":
							sheetObject1.DataInsert();
						break;

						case "btn_delete":
							doActionIBSheet(sheetObject1,formObject,REMOVE);
						break;
		                case "btn_loadexcel":
// 			                  	sheetObject1.SpeedDown2Excel(-1);

		                 	 doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
		                 	break;
		 		        case "btns_Calendar1" :		// Agreement Date (From Date)
 			 				var cal = new ComCalendar();
 			 				cal.select(formObject.str_mvmt_dt, "yyyy-MM-dd");
 			 				break;

 			 			case "btns_Calendar2" :		// Agreement Date (To Date)
// 			 				var cal = new ComCalendar();
// 			 	    		cal.select(formObject.end_mvmt_dt, "yyyy-MM-dd");
 			 	    		var cal = new ComCalendarFromTo();
 				            cal.select(formObject.str_mvmt_dt,  formObject.end_mvmt_dt,  'yyyy-MM-dd');
 			 	    		break;
 		               case "btn_downexcel":
 		                	 sheetObject1.SpeedDown2Excel(-1);
 		                	break;

             } // end switch
             tRoleApply();
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

      }

      /**
      *
      * @param sheetObj
      * @return
      */
     function sheet1_OnLoadFinish(sheetObj) {
         sheetObj.WaitImageVisible = false;
       formObj = document.form;
       axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
       axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
       axon_event.addListenerFormat('beforeactivate',	  'obj_activate',	formObj);
       axon_event.addListener('change', 'obj_change' , 'eq_no');
         // 초기화
         initControl(sheetObjects[0]);
         tRoleApply();
         sheetObj.WaitImageVisible = true;
    }

      /**
       * Form의 Conrol 를 초기화 시킨다. <br>
       * @param  {object} sheetObj	필수
       * @return 없음
       * @author 최민회
       * @version 2009.05.20
       */
      function initControl(sheetObj){
      	// Form 객체 선언
      	  formObj = document.form;
          // axon event 등록


      	 doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
      	 from_Chk();
         formObj.eq_no.focus();

      }

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 400;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(25, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)



                     var HeadTitle = "||Chassis No.|Current Yard|Last MVMT Date|Origin Yard|Destination Yard|Movement Date|Movement Date|Status|In/Out|Used|Trucker|Reason|M.G.Set|Remark(s)|Verify Result|Created Date|Created By|Updated Date|Updated By|ATDT Status|||Input Status";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                 	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                 	InitDataProperty(0, cnt++ , dtStatus, 40, daCenter,  false,   "ibflag");
                 	InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter,  false,   "ibflag");
                 	InitDataProperty(0, cnt++ , dtCheckBox,     30, daCenter,  false,   "del_chk",	        false, "", dfNone,   0,  true,   true);
                 	InitDataProperty(0, cnt++ , dtData,        100, daCenter,  false,   "eq_no",   	        false, "", dfNone,   0, false,   true, 10);
                 	InitDataProperty(0, cnt++ , dtPopupEdit,    85, daCenter,  false,   "crnt_yd_cd",    	false, "", dfNone,   0, false,  false);
                 	InitDataProperty(0, cnt++ , dtData, 	   120, daCenter,  false,   "chss_mvmt_dt",     false, "", dfNone,   0, false,  false);

                 	InitDataProperty(0, cnt++ , dtPopupEdit,    75, daCenter,  false,   "yd_cd",    	    false, "", dfNone,   0,  true,  false,  7);
                 	InitDataProperty(0, cnt++ , dtPopupEdit,   110, daCenter,  false,   "dest_yd_cd",       false, "", dfNone,   0,  true,  false,  7);
                 	InitDataProperty(0, cnt++ , dtData,   	    90, daCenter,  false,   "mvmt_dt_day",  	false, "", dfDateYmd,0, false,  false);
                 	InitDataProperty(0, cnt++ , dtData,   	    60, daCenter,  false,   "mvmt_dt_hd",   	false, "", dfTimeHm, 0, false,  false);
//                 	InitDataProperty(0, cnt++ , dtCombo,        60, daCenter,  false,   "mvmt_sts_cd",	    false, "", dfNone,   0, false,   true);
                 	InitDataProperty(0, cnt++ , dtData,         50, daCenter,  false,   "mvmt_sts_cd",	    false, "", dfNone,   0, false,  false);
                    InitDataProperty(0, cnt++ , dtCombo,  	    65, daCenter,  false,   "gate_io_cd",       false, "", dfNone,   0,  true,  false);

                 	InitDataProperty(0, cnt++ , dtCombo,   	    60, daCenter,  false,   "mvmt_co_cd", 	    false, "", dfNone,   0, false,  false);
                 	InitDataProperty(0, cnt++ , dtPopupEdit,  	80, daCenter,  false,   "vndr_abbr_nm",     false, "", dfNone,   0,  true,  false,  6);
                 	InitDataProperty(0, cnt++ , dtCombo,       100, daCenter,  false,   "mvmt_rsn_cd",	    false, "", dfNone,   0,  true,  false);
                 	InitDataProperty(0, cnt++ , dtData,   	   150, daCenter,  false,   "mgst_no",       	false, "", dfNone,   0,  true,  false, 11);
                 	InitDataProperty(0, cnt++ , dtData,  	   100, daCenter,  false,   "diff_rmk",         false, "", dfNone,   0,  true,  false);

                 	InitDataProperty(0, cnt++ , dtData,  	    90, daCenter,  false,   "verify",           false, "", dfNone,   0, false,  false);
                 	InitDataProperty(0, cnt++ , dtData,  	   120, daCenter,  false,   "cre_dt",           false, "", dfNone,   0, false,  false);
                 	InitDataProperty(0, cnt++ , dtData,  	    90, daCenter,  false,   "cre_usr_id",       false, "", dfNone,   0, false,  false);
                 	InitDataProperty(0, cnt++ , dtData,  	   120, daCenter,  false,   "upd_dt",           false, "", dfNone,   0, false,  false);
                 	InitDataProperty(0, cnt++ , dtData,  	    90, daCenter,  false,   "upd_usr_id",       false, "", dfNone,   0, false,  false);

                 	InitDataProperty(0, cnt++ , dtHidden,  	    90, daCenter,  false,   "at_dt_status",     false, "", dfNone,   0, false,  false);
                 	InitDataProperty(0, cnt++ , dtHidden,  	    90, daCenter,  false,   "mvmt_dt",          false, "", dfNone,   0, false,  false);
                 	InitDataProperty(0, cnt++ , dtHidden,  	    90, daCenter,  false,   "sys_seq",          false, "", dfNone,   0, false,  false);
                 	InitDataProperty(0, cnt++ , dtData,  	    90, daCenter,  false,   "mnl_inp_flg",      false, "", dfNone,   0, false,  false);

//					InitDataCombo(0, "mvmt_sts_cd", "ID|OP|OC|MT", "ID|OP|OC|MT");
					InitDataCombo(0, "gate_io_cd", "Gate In|Gate Out", "I|O");
					InitDataCombo(0, "mvmt_co_cd", "SML|Others", "H|O");

					sheetObj.InitDataValid(0, "yd_cd", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
					sheetObj.InitDataValid(0, "dest_yd_cd", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
					sheetObj.InitDataValid(0, "mgst_no", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
					sheetObj.InitDataValid(0, "diff_rmk", vtEngOther, "1234567890 -!@#=~$%^&*()+\'., \" "); // 영문 대문자와 숫자만 입력
					InitDataCombo(0, "mvmt_rsn_cd" , "", "");	// 콤보
					InitDataValid(0,  "eq_no", vtEngUpOther, "1234567890");
//					ShowButtonImage = 2;
					 ImageList(0) = "img/btns_calendar.gif";
				     ShowButtonImage = 1;
				     SelectionMode   = smSelectionFree;
				     FrozenCols = 6;
                }
                 break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         //sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 					case IBSEARCH:      //조회
	 			 		var params = FormQueryString(formObj);
	 			 		if(formObj.str_gubun[0].checked == true){
	 						  queryString = "f_cmd=" + SEARCH ;

	 	 	  			 	  if(!validateForm(sheetObj,formObj,sAction)) return;
	 	 					  sheetObj.WaitImageVisible=false;
	 		 			 	  ComOpenWait(true);
	 		 			 	  //chungpa 2010011 popup안뜨는 문제점. sheetObj.DoSearch("EES_CGM_1108GS.do",  queryString+"&"+params);
	 	 	  			 	  var sXml = sheetObj.GetSearchXml("EES_CGM_1108GS.do", queryString+"&"+params);
	 	 	 			      sheetObj.LoadSearchXml(sXml);
	 	 	                  ComOpenWait(false);
	 	 	                  for(i=1;i<sheetObj.LastRow+1;i++)
	 	 	                  {
								  //ComShowMessage("|"+sheetObj.CellValue(i, "verify")+"|");
	 	 	                	  if(sheetObj.CellValue(i, "mnl_inp_flg")!= 'Y'){
	 	 	                		
	 	 	                			sheetObj.RowEditable(i) = true;
	 	 	                			sheetObj.CellEditable(i,"del_chk") = true;
	 	 	                			sheetObj.CellEditable(i,"yd_cd") = false;
	 	 	                			sheetObj.CellEditable(i,"dest_yd_cd") = false;
	 	 	                			sheetObj.CellEditable(i,"gate_io_cd") = false;
	 	 	                			sheetObj.CellEditable(i,"vndr_abbr_nm") = false;
	 	 	                			sheetObj.CellEditable(i,"mvmt_rsn_cd") = false;
	 	 	                			sheetObj.CellEditable(i,"mgst_no") = false;
	 	 	                			sheetObj.CellEditable(i,"diff_rmk") = false;
	 	 	                	  } else {
	 	 	                		sheetObj.RowEditable(i) = true;
	 	 	                	  }

	 	 	                  }
	 	 	                  return;
	 					} else {
		 						queryString = "f_cmd=" + SEARCHLIST ;
		 						var params = sheetObj.GetSaveString(true);
		//	 	  			 	 sheetObj.Redraw = false;
			 	  			 	if(!validateForm(sheetObj,formObj,sAction)) return;
		 	 					sheetObj.WaitImageVisible=false;
		 		 			 	ComOpenWait(true);
		 		 			    //chungpa 2010011 popup안뜨는 문제점. if(sheetObj.DoSearch("EES_CGM_1108GS.do",  queryString+"&"+params,'del_chk')){}
		 	 	  			 	var sXml = sheetObj.GetSearchXml("EES_CGM_1108GS.do", queryString+"&"+params,'del_chk');
		 	 	 			    sheetObj.LoadSearchXml(sXml);
		 		 			 	ComOpenWait(false);
		//	 	                ComShowMessage(sheetObj.LastRow);
			 	  			 	for(i=1;i<sheetObj.LastRow+1;i++)
				                {
									  if(    sheetObj.CellValue(i, "del_chk") == "1"
										  && sheetObj.CellValue(i, "verify") != 'OK'
										  && sheetObj.CellValue(i, "verify") != ''){
										 sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);	// Row 전체 Font Color 를 Red 로 설정
		//								 sheetObj.RowEditable(i) = false;
										 sheet1_edit(i,true);
									  }  else {
										  sheetObj.RowFontColor(i) = sheetObj.RgbColor(0, 0, 0);	// Row 전체 Font Color 를 Red 로 설정
										  sheet1_edit(i,true);
									  }
				                }
	 					}


 	                 break;
 					case IBSAVE:        //저장
// 					 if(!validateForm(sheetObj,formObj,sAction)) return;

	 					if(formObj.str_gubun[0].checked == true){
	 						var params = sheetObj.GetSaveString(true);
	 						formObj.f_cmd.value = MODIFY01;
	 						queryString = "f_cmd=" + MODIFY01 ;
	 						for(i=1;i<sheetObj.LastRow+1;i++)
 		                    {
	 						  if(sheetObj.CellValue(i, "del_chk") == "1" && sheetObj.CellValue(i, "at_dt_status")!= 'OK' && sheetObj.RowStatus(i) !='D'){
								 sheetObj.CellValue(i, "del_chk") = "0";
//									 sheetObj.CellValue(i, "RowStatus") = "";
								sheetObj.RowStatus(i) = "R";
							  } else if (sheetObj.CellValue(i, "del_chk") == "0" && sheetObj.RowStatus(i) !='D') {
//								 sheetObj.CellValue(i, "ibflag") = "";
								 sheetObj.RowStatus(i) = "R";
							  } else if (sheetObj.RowStatus(i) == "D") {
								  sheetObj.RowStatus(i) = "D";
							  } else{
								  sheetObj.RowStatus(i) = "U";
							  }
 		                    }

	 					} else {
	 						formObj.f_cmd.value = MODIFY02;
	 						queryString = "f_cmd=" + MODIFY02 ;
	 						 for(i=1;i<sheetObj.LastRow+1;i++)
	 		                  {
	 							  if(sheetObj.CellValue(i, "del_chk") == "1" && sheetObj.CellValue(i, "verify")!= 'OK'){
	 								 sheetObj.CellValue(i, "del_chk") = "0";
//	 								 sheetObj.CellValue(i, "RowStatus") = "";
	 								sheetObj.RowStatus(i) = "R";
	 							  } else if (sheetObj.CellValue(i, "del_chk") == "0") {
//	 								 sheetObj.CellValue(i, "ibflag") = "";
	 								 sheetObj.RowStatus(i) = "R";
	 							  }
	 							  if(sheetObj.CellValue(i, "gate_io_cd")=="I" && sheetObj.CellValue(i, "mvmt_rsn_cd") =="PUID"){
	 					       		  ComShowCodeMessage('CGM10039');
	 					       	      sheetObj.SelectCell(i, Col, true);
	 				       		  } else if (sheetObj.CellValue(i, "gate_io_cd")=="O" && sheetObj.CellValue(i, "mvmt_rsn_cd") =="IDRE"){
	 				       			  ComShowCodeMessage('CGM10039');
	 				       			  sheetObj.SelectCell(i, Col, true);
	 				       			  return false;
	 				       		  }
	 		                  }
	 						var params = sheetObj.GetSaveString(true);

	 					}

 						if(sheetObj.DoSave("EES_CGM_1108GS.do",queryString + "&" + ComGetPrefixParam("")),'del_chk')
 						{

 						}

 					break;

 					case REMOVE:
 						if(formObj.str_gubun[0].checked == true){
 							ComRowHideDelete(sheetObj,"del_chk");
 						} else {
 							for(i=sheetObj.rowCount; i>0; i--){

 					   			if(sheetObj.CellValue(i, "del_chk") != "0" ) {
 					   				sheetObj.RowDelete(i, false);
 					   			}
 					   		 }
 						}


 		   				break;
 			       	 case IBSEARCH_ASYNC01:	// Term Code Combo 조회
 			            //그리드내  다중콤보
	 			       	formObj.f_cmd.value = SEARCH;
	 			       	formObj.intg_cd_id.value = COM_CD_TYPE_CD01946;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
	 			        formObj.code1.value = "1108";
//	 			   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
	 			        var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
//	 			   		ComShowMessage(sXml);
//	 			     	var cols = ComCgmXml2ComboString(sXml, "code1", "desc1", "|");
//	 			   		ComShowMessage(sXml);
		 			   	var sStr = ComGetEtcData(sXml,"comboList");
		 		   		var arrStr = sStr.split("@");

			 		    var arrCode1 ="";
			 		    var arrCode2 ="";
				 		for (var i = 0; i < arrStr.length;i++ ) {
				        	var arrCode = arrStr[i].split("|");
			          		if(i==0)
			          		{
			          			arrCode1 = arrCode1 + arrCode[1];
			          			arrCode2 = arrCode2 + arrCode[0];
			          		}else
			          		{
			          			arrCode1 = arrCode1 +"|"+ arrCode[1];
			          			arrCode2 = arrCode2 +"|"+ arrCode[0];
			          		}

			          	}
				 		sheetObj.InitDataCombo(0, "mvmt_rsn_cd",   arrCode1,   arrCode2, "", "", 0);
 				       	break;
 			       	case IBSEARCH_ASYNC02:	// Term Code Combo 조회
			            //그리드내  다중콤보
	 			       	formObj.f_cmd.value = SEARCH;
 			       	    formObj.eq_knd_cd.value ="Z";
//	 			        var sXml = sheetObj.GetSearchXml("CGM_CHS_MASTERGS.do", FormQueryString(formObj));
	 			        var sXml = sheetObj.GetSearchXml("CGM_CHS_MASTERGS.do", FormQueryString(formObj));
					    // 데이터 건수
					    var dataCount = ComGetTotalRows(sXml);
					    // 데이터가 존재할 경우
					    if(dataCount == 0){
					    	ComShowCodeMessage('CGM10009','Chassis No');
//					   		formObj.eq_no.value="";
					   		formObj.eq_no.focus();
					   	} else {
					   		formObj.str_mvmt_dt.focus();
					   	}
// 			       	formObj.intg_cd_id.value = COM_CD_TYPE_CD01946;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
// 			   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
// 			   		ComShowMessage(sXml);
// 			     	var cols = ComCgmXml2ComboString(sXml, "code1", "desc1", "|");
// 			   		ComShowMessage(cols);

				    break;
 			 	case IBLOADEXCEL:	// EXCEL UPLOAD
 		 			if (sheetObj.id == "sheet1") {
 		 				sheetObj.RemoveAll();
 		 				sheetObj.LoadExcel();
 		 			};
 		 			break;

         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	  switch(sAction) {

			case IBSEARCH:      //조회
			if(formObj.str_gubun[0].checked == true){
				if(formObj.eq_no.value == ''){
					ComShowCodeMessage('CGM10004','Chassis No. ');
					formObj.eq_no.focus();

					return false;
				}
			     var dt_str = ComReplaceStr(document.form.str_mvmt_dt.value,"-","");
	 			 var dt_end = ComReplaceStr(document.form.end_mvmt_dt.value,"-","");


		    		if(dt_str != '' && dt_end != ''){
		    			if(dt_end < dt_str){
		    				ComShowCodeMessage('COM12133','To date','From date','greater');
		    				formObj.str_mvmt_dt.value='';

		    				formObj.str_mvmt_dt.focus();
		    				return false;
		    			}
		    		} else
		    		{
		    			if(dt_str == ''){
		    				ComShowCodeMessage('CGM10004','From date. ');
		    				formObj.str_mvmt_dt.value='';

		    				formObj.str_mvmt_dt.focus();
		    				return false;
		    			} else {
		    				ComShowCodeMessage('CGM10004','to date. ');
		    				formObj.end_mvmt_dt.value='';

		    				formObj.end_mvmt_dt.focus();
		    				return false;
		    			}
		    		}
			} else {
				if(sheetObj.RowCount == 0) {
					ComShowMessage(sheetObj.MessageText("UserMsg13"));
					return false;
				}

				  for(i=1;i<sheetObj.LastRow+1;i++)
                  {
					  if(sheetObj.CellValue(i, "del_chk") == "1"){


						  if(sheetObj.CellValue(i, "yd_cd")=='' ){
							  ComShowCodeMessage('CGM10004','Origin Yard');
							  sheetObj.SelectCell(i, 'yd_cd', true);
							  return false;
						  }

						  if(sheetObj.CellValue(i, "mvmt_dt_day")=='' ){
							  ComShowCodeMessage('CGM10004','Movement Date');
							  sheetObj.SelectCell(i, 'mvmt_dt_day', true);
							  return false;
						  }

						  if(  sheetObj.CellValue(i, "mvmt_dt_hd")==''){
							  ComShowCodeMessage('CGM10004','Movement Date');
							  sheetObj.SelectCell(i, 'mvmt_dt_hd', true);
							  return false;
						  }
						  formObj.chss_mvmt_dt.value = ComReplaceStr(sheetObj.CellValue(i, "chss_mvmt_dt"),"-","");
//						  ComShowMessage(formObj.chss_mvmt_dt.value);
						  formObj.chss_mvmt_dt.value = ComReplaceStr(formObj.chss_mvmt_dt.value,":","");
//						  ComShowMessage(formObj.chss_mvmt_dt.value);
//						  if(formObj.chss_mvmt_dt.value>=(sheetObj.CellValue(i, "mvmt_dt_day")+" " + sheetObj.CellValue(i, "mvmt_dt_hd"))){
//							  sheetObj.SelectCell(i, 'mvmt_dt_day', true);
//							  return false;
//						  }
						  if(sheetObj.CellValue(i, "gate_io_cd")=="I" && sheetObj.CellValue(i, "mvmt_rsn_cd") =="PUID"){
				       		  ComShowCodeMessage('CGM10039');
				       	      sheetObj.SelectCell(i, Col, true);
			       		  } else if (sheetObj.CellValue(i, "gate_io_cd")=="O" && sheetObj.CellValue(i, "mvmt_rsn_cd") =="IDRE"){
			       			  ComShowCodeMessage('CGM10039');
			       			  sheetObj.SelectCell(i, Col, true);
			       			  return false;
			       		  }

//						  ComShowMessage(sheetObj.CellValue(i, "gate_io_cd"));
					  }
                  }
			}


            break;

}
         return true;
     }



     	/**
        * Object 의 Keypress 이벤트에 대한 처리  <br>
        * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
        * @param  없음
        * @return 없음
        * @author 최민회
        * @version 2009.05.20
        */
       function obj_keypress(){
      	 obj = event.srcElement;
      	 var sheetObject1 = sheetObjects[0];
      	 var formObject = document.form;
      	 if(obj.dataformat == null) return;

      	 window.defaultStatus = obj.dataformat;
      	 switch(obj.dataformat) {
      	 	case "ymd":
      	 		//alert(event.keyCode)
      	 		if(event.keyCode==13){doActionIBSheet(sheetObject1, formObject, IBSEARCH);}
      	 		ComKeyOnlyNumber(obj);
      	        break;
      	    case "eng":
      	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
      	        else ComKeyOnlyAlphabet('upper');
      	        break;
      	    case "engup":
      	    	if(event.keyCode == 13) {doActionIBSheet(sheetObject1,formObject,IBSEARCH);}
      	        if(obj.name=="eq_no") ComKeyOnlyAlphabet('uppernum')
      	        else ComKeyOnlyAlphabet('upper');
      	        break;

      	 }


       }

        /**
         * Object 의 deactivate 이벤트에 대한 처리  <br>
         * @param  없음
         * @return 없음
         * @author 최민회
         * @version 2009.05.20
         */
         function domFunFocusDel(a)
         {
         	var formObj = document.form;
           	 obj = event.srcElement;
           	if(obj.name=="str_mvmt_dt"  ){

           		document.form.str_mvmt_dt.value = ComReplaceStr(document.form.str_mvmt_dt.value,"-","");
               }
             if(obj.name=="end_mvmt_dt"  ){

             		document.form.end_mvmt_dt.value = ComReplaceStr(document.form.end_mvmt_dt.value,"-","");
              }

            //ComShowMessage("domFunFocusDel");
         }

         /**
          * AXON 이벤트 처리
          */
         function obj_activate(){
             ComClearSeparator(event.srcElement);
         }

         /**
          * Object 의 deactivate 이벤트에 대한 처리  <br>
          * @param  없음
          * @return 없음
          * @author 최민회
          * @version 2009.05.20
          */
         function obj_deactivate(){
        	 var formObj = document.form;
        	 obj = event.srcElement;

        	 if(obj.name=="str_mvmt_dt"  ){

        		 with(formObj){

        			 var creDtFr = ComReplaceStr(str_mvmt_dt.value,"-","");
     	        }

     	        ComChkObjValid(event.srcElement);
            }
          	if(obj.name=="end_mvmt_dt"  ){

       		 with(formObj){

       			 var creDtFr = ComReplaceStr(end_mvmt_dt.value,"-","");
     	        }

     	        ComChkObjValid(event.srcElement);
           }

         }

          /**
           * Form 의 Date yard 제어
           * @return
           * @author 최민회
           * @version 2009.06.04
           */
          function from_Chk(){
        	  formObj = document.form;
        	  var sheetObject1 = sheetObjects[0];
        	  var l_chk ,f_chk;
        	  var l_cName;
        	  if(formObj.str_gubun[0].checked == true){
        		  l_chk = false;
        		  f_chk = true;
        		  l_cName = "input1";
        		  ComBtnDisable("btn_add");
        		  ComBtnDisable("btn_loadexcel");
      	    	  ComBtnDisable("btn_verify");

      	    	  ComBtnEnable("btn_retrieve");
        	  } else {
           		  l_chk = true;
        		  f_chk = false;
        		  ComBtnEnable("btn_add");
        		  ComBtnEnable("btn_loadexcel");
        		  ComBtnEnable("btn_verify");

        		  ComBtnDisable("btn_retrieve");
        		  l_cName = "input2";
        	  }

        	  formObj.eq_no.readOnly = l_chk;
              formObj.str_mvmt_dt.readOnly = l_chk;
              formObj.end_mvmt_dt.readOnly = l_chk;

              ComEnableObject(formObj.btns_Calendar2, f_chk);

              sheetObject1.RemoveAll();
//
              formObj.eq_no.className = l_cName;
              formObj.str_mvmt_dt.className = l_cName;
              formObj.end_mvmt_dt.className = l_cName;
          }


           /**
        	 * 선택된 셀이 바뀌었을때 발생하는 Event 처리
        	 * Agreement No 과 Referece No 의 유효성을 체크한다.
        	 */
        	function sheet1_OnChange(sheetObj, Row, Col){
              var formObj = document.form;
              var chk      = true;
           	  switch (sheetObj.ColSaveName(Col)) {

           	 case "eq_no" :
        	    formObj.f_cmd.value = SEARCH;
// 			   	formObj.eq_no.value =sheetObj.CellValue(Row, "mgst_no");
 			   	formObj.eq_knd_cd.value = "Z"
 			   	var cellValue = sheetObj.cellValue(Row, Col);
 			   	if(sheetObj.CellValue(Row, "eq_no")!="")
 			   	{
	 			   	if(Row >1)
	 				{
	 					// chassis no 체크
	 					for(i=1; i<sheetObj.rowCount; i++){

	 						if(sheetObj.CellValue(i, "eq_no")== cellValue && Row != i )
		 					{
		 						chk = false;
		 					}
		 				}


	 				}

	 			    if(chk == true)
					{
	 			    	eq_no_chkeck(sheetObj,Row,"");

					}
					else
					{

			        	ComShowCodeMessage("CGM10017"," Chassis No.");
			        	// 해당 Cell 값을 Null로 설정
						sheetObj.CellValue2(Row, "eq_no") = "";
						sheetObj.CellValue2(Row, "del_chk") = "";
						sheetObj.CellValue2(Row, "crnt_yd_cd")  = "";
						sheetObj.CellValue2(Row, "chss_mvmt_dt") = "";
						sheetObj.CellValue2(Row, "mvmt_dt_hd")   = "";
						sheetObj.CellValue2(Row, "mvmt_sts_cd")  = "";
						sheetObj.CellValue2(Row, "verify") = "";
						sheetObj.RowFontColor(Row) = sheetObj.RgbColor(0, 0, 0);
						sheet1_edit(Row,false);
					}
//


 			   	} else {
	 			   	sheetObj.CellValue2(Row, "eq_no") = "";
					sheetObj.CellValue2(Row, "del_chk") = "";
					sheetObj.CellValue2(Row, "crnt_yd_cd")  = "";
					sheetObj.CellValue2(Row, "chss_mvmt_dt") = "";
					sheetObj.CellValue2(Row, "mvmt_dt_hd")   = "";
					sheetObj.CellValue2(Row, "mvmt_sts_cd")  = "";

					sheetObj.CellValue2(Row, "verify") = "";
					sheetObj.RowFontColor(Row) = sheetObj.RgbColor(0, 0, 0);
 			   	}
 			    break;
              case "crnt_yd_cd" :
       	   			formObj.f_cmd.value = COMMAND01;
       			   	formObj.yd_cd.value =sheetObj.CellValue(Row, "crnt_yd_cd");
       			   	if(formObj.yd_cd.value!="")
       			   	{
       			   		var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
       				   	var sCheckResult = ComGetEtcData(sXml,"checkResult");
       				   	if(sCheckResult == COM_VALIDATION_FALSE){
       				   		ComShowCodeMessage('CGM10009','Current Yard');
       				   		sheetObj.CellValue(Row, "crnt_yd_cd") = "";
       				   		sheetObj.SelectCell(Row, Col-1, true);
//       				   	    sheetObj.CellValue(Row, "ibflag") = "";
//       				   		formObj.sts_evnt_yd_cd.focus();
       				   	} else {
       				   		sheetObj.CellValue(Row, "del_chk") = "1";

       				   	}
       			   	}
       			    sheetObj.CellValue2(Row, "verify") = "";
       		 	    break;
       	      case "yd_cd" :
       	   			formObj.f_cmd.value = COMMAND01;
       			   	formObj.yd_cd.value =sheetObj.CellValue(Row, "yd_cd");
       			   	if(formObj.yd_cd.value!="")
       			   	{
       			   		var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
       				   	var sCheckResult = ComGetEtcData(sXml,"checkResult");
       				   	if(sCheckResult == COM_VALIDATION_FALSE){
       				   		ComShowCodeMessage('CGM10009','Yard');
       				   		sheetObj.CellValue(Row, "yd_cd") = "";
       				   		sheetObj.SelectCell(Row, Col-1, true);
//       				   	    sheetObj.CellValue(Row, "ibflag") = "";
//       				   		formObj.sts_evnt_yd_cd.focus();
       				   	} else {
       				   		sheetObj.CellValue(Row, "del_chk") = "1";

       				   	}
       			   	}
       			    sheetObj.CellValue2(Row, "verify") = "";
       		 	    break;
       	     case "dest_yd_cd" :
    	   			formObj.f_cmd.value = COMMAND01;
    			   	formObj.yd_cd.value =sheetObj.CellValue(Row, "dest_yd_cd");
    			   	if(formObj.yd_cd.value!="")
    			   	{
    			   		var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
    				   	var sCheckResult = ComGetEtcData(sXml,"checkResult");
    				   	if(sCheckResult == COM_VALIDATION_FALSE){
    				   		ComShowCodeMessage('CGM10009','Yard');
    				   		sheetObj.CellValue(Row, "dest_yd_cd") = "";
    				   		sheetObj.SelectCell(Row, Col-1, true);
//    				   	    sheetObj.CellValue(Row, "ibflag") = "";
//    				   		formObj.sts_evnt_yd_cd.focus();

    				   	} else {
    				   		sheetObj.CellValue(Row, "del_chk") = "1";
    				   	}


    			   	}
    			   	sheetObj.CellValue2(Row, "verify") = "";
    		 	    break;
       	     case "mvmt_dt_day":
       	  	      sheetObj.CellValue2(Row, "verify") = "";
		          break;
       	     case "mvmt_dt_hd":
    	  	      sheetObj.CellValue2(Row, "verify") = "";
		          break;
       	     case "vndr_abbr_nm":
 		 	  formObj.f_cmd.value = SEARCH;
//			   	formObj.eq_no.value =sheetObj.CellValue(Row, "mgst_no");
			   	formObj.vndr_seq.value = sheetObj.CellValue(Row, "vndr_abbr_nm")
			   	if(formObj.vndr_seq.value !="")
			   	{
			   		var sXml = sheetObj.GetSearchXml("CGM_MDM_VENDORGS.do", FormQueryString(formObj));
				    // 데이터 건수
				    var dataCount = ComGetTotalRows(sXml);
				    // 데이터가 존재할 경우
				    if(dataCount > 0){
				    	sheetObj.CellValue(Row, "del_chk") = "1";
				   	} else {
				   		ComShowCodeMessage('CGM10009','Trucker');
				   		sheetObj.CellValue(Row, "vndr_abbr_nm") = "";
				   		sheetObj.SelectCell(Row, Col, true);
//				   	    sheetObj.CellValue(Row, "ibflag") = "";
//				   		formObj.sts_evnt_yd_cd.focus();
				   	}
			   	}
			   	sheetObj.CellValue2(Row, "verify") = "";
			    break;
			    // ComShowMessage(sheetObj.CellValue(i, "gate_io_cd"));
       	   case "gate_io_cd" :
	       		if(sheetObj.CellValue(Row, "gate_io_cd")=="I"){
	   				sheetObj.CellValue(Row, "mvmt_sts_cd") ="BI";
	   			} else {
	   				sheetObj.CellValue(Row, "mvmt_sts_cd") ="BO";
	   			}

	       		if(sheetObj.CellValue(Row, "gate_io_cd")=="I" && sheetObj.CellValue(Row, "mvmt_rsn_cd") =="PUID"){
	       			ComShowCodeMessage('CGM10039');
	       			sheetObj.CellValue(Row, "mvmt_rsn_cd") ="CHON";
//	       			sheetObj.SelectCell(Row, Col, true);
	       		} else if (sheetObj.CellValue(Row, "gate_io_cd")=="O" && sheetObj.CellValue(Row, "mvmt_rsn_cd") =="IDRE"){
	       			ComShowCodeMessage('CGM10039');
	       			sheetObj.CellValue(Row, "mvmt_rsn_cd") ="CHON";
//	       			sheetObj.SelectCell(Row, Col, true);
	       		}
	       		sheetObj.CellValue2(Row, "verify") = "";
		   		break;
       	    case "mvmt_rsn_cd" :
	       		if(sheetObj.CellValue(Row, "gate_io_cd")=="I" && sheetObj.CellValue(Row, "mvmt_rsn_cd") =="PUID"){
	       			ComShowCodeMessage('CGM10039');
	       			sheetObj.CellValue(Row, "mvmt_rsn_cd") ="CHON";
//	       			sheetObj.SelectCell(Row, Col, true);
	       		} else if (sheetObj.CellValue(Row, "gate_io_cd")=="O" && sheetObj.CellValue(Row, "mvmt_rsn_cd") =="IDRE"){
	       			ComShowCodeMessage('CGM10039');
	       			sheetObj.CellValue(Row, "mvmt_rsn_cd") ="CHON";
//	       			sheetObj.SelectCell(Row, Col, true);
	       		}
	       		sheetObj.CellValue2(Row, "verify") = "";
		   		break;
       	    case "mgst_no" :
       	    	formObj.f_cmd.value = SEARCH;
//			   	formObj.eq_no.value =sheetObj.CellValue(Row, "mgst_no");
			   	formObj.eq_knd_cd.value = "G"
			   	if(sheetObj.CellValue(Row, "mgst_no")!="")
			   	{
			   		var sXml = sheetObj.GetSearchXml("CGM_CHS_MASTERGS.do?eq_no="+sheetObj.CellValue(Row, "mgst_no"), FormQueryString(formObj));
				    // 데이터 건수
				    var dataCount = ComGetTotalRows(sXml);
				    // 데이터가 존재할 경우
				    if(dataCount > 0){
				    	sheetObj.CellValue(Row, "del_chk") = "1";
				   	} else {
				   		ComShowCodeMessage('CGM10009','M.G.SET');
				   		sheetObj.CellValue(Row, "mgst_no") = "";
				   		sheetObj.SelectCell(Row, Col, true);
//				   	    sheetObj.CellValue(Row, "ibflag") = "";
//				   		formObj.sts_evnt_yd_cd.focus();
				   	}

			   	}
			   	sheetObj.CellValue2(Row, "verify") = "";
		   		break;
         	case "diff_rmk" :
         		sheetObj.CellValue(Row, "del_chk") = "1";
         		sheetObj.CellValue2(Row, "verify") = "";
         		break;
         	case "gate_io_cd" :
         		sheetObj.CellValue(Row, "del_chk") = "1";
         		sheetObj.CellValue2(Row, "verify") = "";
         		break;
           	}
          }

             /**
              * 시트네 팝업 클릭
              * @param sheetObj
              * @param row
              * @param col
              * @return
              */
             function sheet1_OnPopupClick(sheetObj, row, col){
           		switch (sheetObj.ColSaveName(col)) {
	           		case "crnt_yd_cd" :
	           			//ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', false, false, row, col, 0);
	           			ComOpenPopup('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
	           			//ComOpenPopup('/hanjin/EES_CGM_1117.do' , 820, 420, 'setPopupAgreementNo','1,0,1,1,1,1,1,1,1', true, false, Row, Col, 0);
	           			break
           	       	case "yd_cd" :
           	        ComOpenPopup('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
           	       	    break;
           	 	    case "dest_yd_cd" :
           	 	    ComOpenPopup('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
           	 	        break;
	           	 	case "vndr_abbr_nm" :
	           	 	ComOpenPopup('/hanjin/COM_ENS_0C1.do?pgmNo=COM_ENS_0C1' , 700, 455, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
	           	 	    break;
           		}
           	}
              /**
               * 시트네 팝업 값 넣기
               * @param aryPopupData
               * @param row
               * @param col
               * @param sheetIdx
               * @return
               */
            function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
     			var sheetObject = sheetObjects[0];

     			//alert(aryPopupData + " : " + row + " : "+ col);

//     			ComShowMessage(col);
     			if(col == 3 || col == 5 || col == 6) // ya_cd
     			{
     				sheetObject.CellValue2(row, col) = aryPopupData[0][3];
     			} else if(col == 12)     // trucker
     			{
     				sheetObject.CellValue2(row, col) = aryPopupData[0][2];
     			}

     			sheetObject.CellValue(row, "del_chk") = "1";
     			sheetObject.CellValue(row, "verify") = "";
//     			sheetObject.CellValue(row,col)= aryPopupData[0][4];
      	    }

            /**
             * Object 의 deactivate 이벤트에 대한 처리  <br>
             * @param  없음
             * @return 없음
             * @author 최민회
             * @version 2009.05.20
             */
             function domFunFocusDel(a)
             {
             	var formObj = document.form;
               	 obj = event.srcElement;
               	if(obj.name=="str_mvmt_dt"  ){

               		document.form.str_mvmt_dt.value = ComReplaceStr(document.form.str_mvmt_dt.value,"-","");
                   }
                 if(obj.name=="str_mvmt_dt"  ){

                 		document.form.end_mvmt_dt.value = ComReplaceStr(document.form.end_mvmt_dt.value,"-","");
                  }

                //ComShowMessage("domFunFocusDel");
             }

            /**
       	    *
       	    * @param ROW
       	    * @return
       	    */
       	   function sheet1_edit(ROW,status)
  	   	   {
       		   sheetObjects[0].CellEditable(ROW, "yd_cd")        = status;
       		   sheetObjects[0].CellEditable(ROW, "dest_yd_cd")   = status;
       		   sheetObjects[0].CellEditable(ROW, "mvmt_dt_day")  = status;
       		   sheetObjects[0].CellEditable(ROW, "mvmt_dt_hd")   = status;
//       		   sheetObjects[0].CellEditable(ROW, "mvmt_sts_cd")  = status;
       		   sheetObjects[0].CellEditable(ROW, "gate_io_cd")   = status;
       		   sheetObjects[0].CellEditable(ROW, "mvmt_co_cd")   = status;
       		   sheetObjects[0].CellEditable(ROW, "vndr_abbr_nm") = status;
       		   sheetObjects[0].CellEditable(ROW, "mvmt_rsn_cd")  = status;
       		   sheetObjects[0].CellEditable(ROW, "mgst_no")      = status;
    		   sheetObjects[0].CellEditable(ROW, "diff_rmk")     = status;

  	   	   }

       	 // 저장후 조회 기능
      	    function sheet1_OnSaveEnd(sheetObj, errMsg) {
      	    	if(errMsg =='') {
      	    		ComShowCodeMessage('CGM00003');
      	    		for(i=sheetObj.LastRow; i>0; i--){
					  if(sheetObj.CellValue(i, "del_chk") == "1" && sheetObj.CellValue(i, "verify")== 'OK'){
						  sheetObj.RowDelete(i, false);
					  }
					}
      			}
      	    }

       /**
     * Object 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 최민회
     * @version 2009.05.20
     */
    function obj_change(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 obj = event.srcElement;
    	 switch(obj.name){

    	   case "eq_no":
    	 		if(formObj.eq_no.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
    	 			break;
    	 		}


    	 }
    }

     /**
      * 엑셀 업로드시 eq_no 중복 체크
      * @param sheetObj
      * @return
      */
  	function sheet1_OnLoadExcel(sheetObj){

//		   	var cellValue = sheetObj.cellValue(Row, Col);
 				// chassis no 체크
			for(isheet1_OnLoadExcel=1; isheet1_OnLoadExcel<sheetObj.rowCount+1; isheet1_OnLoadExcel++){
                 for(iChk = isheet1_OnLoadExcel+1;iChk<sheetObj.rowCount+1; iChk++)
                 {
                	 if(sheetObj.CellValue(iChk, "eq_no")== sheetObj.CellValue(isheet1_OnLoadExcel, "eq_no")
                			 && sheetObj.CellValue(isheet1_OnLoadExcel, "eq_no")!="")
 					 {
						sheetObj.CellValue2(iChk, "eq_no") = "";
						sheetObj.CellValue2(iChk, "del_chk") = "";
						sheetObj.CellValue2(iChk, "crnt_yd_cd")  = "";
						sheetObj.CellValue2(iChk, "chss_mvmt_dt") = "";
						sheetObj.CellValue2(iChk, "mvmt_dt_hd")   = "";
						sheetObj.CellValue2(iChk, "mvmt_sts_cd")  = "";
						sheetObj.CellValue2(iChk, "verify") = "";
 					 }
                 }

                 if(sheetObj.CellValue(isheet1_OnLoadExcel, "eq_no")!=""){
                	 eq_no_chkeck(sheetObj,isheet1_OnLoadExcel,"excel");
                 }

			}


  	}

     /**
      * eq_no 체크
      * @param sheetObj
      * @param Row
      * @param chk
      * @return
      */
     function eq_no_chkeck(sheetObj,Row,chk){
    	    var formObj = document.form;
	  	    formObj.f_cmd.value = SEARCH;
	//	   	formObj.eq_no.value =sheetObj.CellValue(Row, "mgst_no");
		   	formObj.eq_knd_cd.value = "Z"
    	    var sXml = sheetObj.GetSearchXml("CGM_CHS_MASTERGS.do?eq_no="+sheetObj.CellValue(Row, "eq_no"), FormQueryString(formObj));
		    // 데이터 건수
		    var dataCount = ComGetTotalRows(sXml);
		    // 데이터가 존재할 경우
		    if(dataCount > 0){
		    	sheetObj.CellValue(Row, "del_chk") = "1";
		    	sheetObj.CellValue(Row, "crnt_yd_cd")   = DomXml2String(sXml,"crnt_yd_cd");
		    	sheetObj.CellValue(Row, "chss_mvmt_dt") = DomXml2String(sXml,"chss_mvmt_dt");
		    	sheetObj.CellValue(Row, "mvmt_dt_hd")   = "0000";
		    	if(sheetObj.CellValue(Row, "gate_io_cd")=="I"){
	   				sheetObj.CellValue(Row, "mvmt_sts_cd") ="BI";
	   			} else {
	   				sheetObj.CellValue(Row, "mvmt_sts_cd") ="BO";
	   			}

		    	sheet1_edit(Row,true);
		   	} else {
		   		if(chk==""){
		   			ComShowCodeMessage('CGM10009','Chassis No');
		   		}
		     	sheetObj.CellValue(Row, "eq_no") = "";
		   		sheetObj.CellValue(Row, "mgst_no") = "";
		   		sheetObj.SelectCell(Row, "eq_no", true);
		     	sheetObj.CellValue(Row, "crnt_yd_cd")   = "";
		    	sheetObj.CellValue(Row, "chss_mvmt_dt") = "";

		    	sheet1_edit(Row,false);
		   	}

		    sheetObj.CellValue2(Row, "verify") = "";
     }

  /**
   * 기능(ex:btn_save)에 권한(trole) 적용  <br>
   * @param  없음
   * @return 없음
   * @author 조재성
   * @version 2010.03.05
   */
   function tRoleApply() {
 	  var formObj = document.form;
 	  if(formObj.trole.value == "Authenticated")
 	  {

 	  }else
 	  {
 		  //ComBtnDisable("btn_save");
 		  ComBtnDisable("btn_delete");
 		  ComBtnDisable("btn_add");
 	  }
   }
	/* 개발자 작업  끝 */