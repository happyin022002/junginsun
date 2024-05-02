/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1018.js
*@FileTitle : Lost 되었던 Chassis 가 시스템상에 Movement가 EDI로 들어올 경우 Found 처리하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.22 최민회
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
     * @class ees_cgm_1018 : ees_cgm_1018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_1018() {
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
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

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

                 case "btn_new":
                	 formObject.reset();
                	 formObject.location.text = "";
               		 sheetObject1.RemoveAll();
                	 
                     break; 

                 case "btn_save":
                	 doActionIBSheet(sheetObject1,formObject,IBSAVE);
                     break;
                      
                 case "btn_retrieve":
                	
                	 doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                     break;                   
                 case "ComOpenPopupWithTarget":
                 	var tmp = formObject.location.text;
                 	if(tmp == "RCC")
                 	{
                 		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"rcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                 	}else if(tmp == "LCC")
                 	{
                 		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"lcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                 	}else if(tmp == "SCC")
                 	{
                 		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"scc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                 	}
           			
           			break;
                 case "btn_del":
                	 doActionIBSheet(sheetObject1,formObject,REMOVE);

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
      * Sheet 기본 설정  및 초기화
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
             comboObjects[comboCnt++] = document.location;
           	 for(var k=0;k<comboObjects.length;k++){
       	        initCombo(comboObjects[k]);
      	     }  

           //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
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
          axon_event.addListenerFormat('beforeactivate',	  'obj_activate',		formObj);
//          axon_event.addListener('change', 'obj_change' , 'scc_cd'  ); 
          axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
          initControl(sheetObjects[0]); 
          sheetObj.WaitImageVisible = true; 
     }
      
      /**
       * AXON 이벤트 처리
       */
      function obj_activate(){
          ComClearSeparator(event.srcElement);
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
      	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
        axon_event.addListener(  'scc_cd'   ); 

          
       // Lease Term Combo Control에  초기값을  설정한다.
//          doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
        doActionIBSheet(sheetObjects[0], document.form, IBRESET);
//          formObj.agmt_lstm_cd.text ='ALL';
          formObj.location.text ='RCC';
//          // 초기 focus
          formObj.location.focus();
        
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
                     style.height = 470;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(14, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false) 
                      
                      
                     var HeadTitle = "||Chassis No.|TP/SZ|Term|Lessor|MVMT|Status|Found Yard|Found Date|Lost/TLL Created Date|Lost/TLL Created By|";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	 30, daCenter, false, "ibflag");
//                   
                     InitDataProperty(0, cnt++ , dtCheckBox, 	30,   daCenter,  false,   "del_chk",   		false,          "",      dfNone,     	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,  		90,   daCenter,  false,   "eq_no",       	false,          "",      dfNone,      	0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,   	 	45,   daCenter,  false,   "eq_tpsz_cd",   	false,          "",      dfNone,     	0,     false,       true);
 		             InitDataProperty(0, cnt++ , dtData,  		50,   daCenter,  false,   "agmt_lstm_cd",  	false,          "",      dfNone,      	0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       180,   daLeft,    false,   "vndr_lgl_eng_nm",false,          "",      dfNone,  	0,     false,       true);

                     InitDataProperty(0, cnt++ , dtData,  		50,   daCenter,  false,   "chss_mvmt_sts_cd",false,         "",      dfNone,      	0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,   	 	50,   daCenter,  false,   "eq_aset_sts_cd",  false,         "",      dfNone,     	0,     false,       true);
 		             InitDataProperty(0, cnt++ , dtPopupEdit,   85,   daCenter,  false,   "sts_evnt_yd_cd",  false,         "",      dfNone,      	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,        100,  daCenter,  false,   "mvmts_dt",   	 false,         "",      dfUserFormat2,  	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,   	 	140,  daCenter,  false,   "sts_evnt_dt", 	 false,         "",      dfNone,     0,     false,       true);

                     InitDataProperty(0, cnt++ , dtData,  		130,   daCenter,  false,   "cre_usr_id",     false,         "",      dfNone,    0,     false,       true);
                     InitDataProperty(0, cnt++ , dtHidden, 		150,   daCenter,  false,   "mvmt_dt",        false,         "",      dfNone,    0,     false,       true);
                     InitDataProperty(0, cnt++ , dtHidden, 		150,   daCenter,  false,   "sys_seq",        false,         "",      dfNone,    0,     false,       true);
                      
 			
                     InitUserFormat2(0, "mvmts_dt", "####-##-## ##:##", "-|:" );
 				    ImageList(0) = "img/btns_calendar.gif";
// 				    PopupButtonImage(0,"mvmts_dt") = 0;
 				    ShowButtonImage = 1;
 				 

                }
                sheetObj.InitDataValid(0, "sts_evnt_yd_cd", vtEngUpOther, "1234567890"); // 영문 대문자와 숫
                 break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

           case IBSEARCH:      //조회
	 	          if(validateForm(sheetObj,formObj,sAction)){
	 	        	 formObj.f_cmd.value = SEARCH;
		             var params = FormQueryString(formObj);
			  		 sheetObj.WaitImageVisible=false;
			 	     ComOpenWait(true);
		             sheetObj.DoSearch("EES_CGM_1018GS.do",  params);
		             ComOpenWait(false);
	 	          }
                 break;
           /* chungpa 20100117 QA 요청사항 사용하지 않는 CASE 삭제
           case IBSEARCH_ASYNC01:	// Term Code Combo 조회
		       	formObj.f_cmd.value = SEARCH;
		       	formObj.intg_cd_id.value = COM_CD_TYPE_CD02117;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
		   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		   			    			
		   		var sStr = ComGetEtcData(sXml,"comboList");    	
//		   		alert(sStr);
		   		var arrStr = sStr.split("@");
		   			
		   		// combo control, 결과 문자열, Text Index, Code Index
	  			MakeComboObject(formObj.location, arrStr, 0, 0);
	  			break;
	  	   */
 			case IBSAVE:        //저장
//           	if(validateForm(sheetObj,formObj,sAction))
	 			for(i=1; i<sheetObj.rowCount+1; i++){
					if(sheetObj.CellValue(i, "del_chk") != "1"){
						sheetObj.RowStatus(i) = "R";
					}
					
					if(sheetObj.CellValue(i, "del_chk") == "1" &&  sheetObj.CellValue(i, "mvmts_dt") == ""){
						sheetObj.RowStatus(i) = "R";
						ComShowCodeMessage('CGM10004','Found date');
						sheetObj.CellValue(i, "del_chk") = "0";
						return ;
					}
					
					if(sheetObj.CellValue(i, "del_chk") == "1"  ){
						
						var dt3  = ComReplaceStr(ComReplaceStr(ComReplaceStr(sheetObj.CellValue(i, "sts_evnt_dt"),"-","")," ",""),":","");
						var dt2 = sheetObj.CellValue(i, "mvmts_dt");
						if(dt2 < dt3){
			      			 ComShowCodeMessage("CGM10055");
			      			 sheetObj.SelectCell(i, "mvmts_dt");
				           	 return ;
			    	    } 
					 
						
					}
				}
	 			formObj.f_cmd.value = MODIFY01;
				queryString = "f_cmd=" + MODIFY01 ;
				
				var params = sheetObj.GetSaveString(true);
				sheetObj.WaitImageVisible=false;
		 	    ComOpenWait(true);
				if(sheetObj.DoSave("EES_CGM_1018GS.do",queryString + "&" + ComGetPrefixParam("")),'del_chk')
				{
					//취소시 
//					for(i=1; i<sheetObj.rowCount+1; i++){
//						if(sheetObj.CellValue(i, "del_chk") == "1"){
//							sheetObj.RowStatus(i) = "R";
//						}
//					}
				}  
				ComOpenWait(false);
                break;

            case REMOVE: 	
           		formObj.f_cmd.value = MODIFY02;
				queryString = "f_cmd=" + MODIFY02 ;
				for(i=1; i<sheetObj.rowCount+1; i++){
					if(sheetObj.CellValue(i, "del_chk") == "1"){
						sheetObj.RowStatus(i) = "D";
					}
				}
				var params = sheetObj.GetSaveString(true);
					
				if(sheetObj.DoSave("EES_CGM_1018GS.do",queryString + "&" + ComGetPrefixParam("")),'del_chk')
				{
					//취소시 
					for(i=1; i<sheetObj.rowCount+1; i++){
						if(sheetObj.CellValue(i, "del_chk") == "1"){
							sheetObj.RowStatus(i) = "R";
						}
					}
				}  
				 break;
			/*	 
	       	  case IBSEARCH_ASYNC02:	// ( location)조회
		       	formObj.f_cmd.value = SEARCH;
		       	formObj.loc_cd.value = formObj.scc_cd.value;		//   ( location)
		   		var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
		   			    			
		   	// 데이터 건수
		        var dataCount = ComGetTotalRows(sXml);
		        if(dataCount==0){
		        	ComShowCodeMessage('CGM10009','location cd');
			   		formObj.scc_cd.value = "";
			   		formObj.scc_cd.focus();
		        }
		        break;
		    */
	       	case IBSEARCH_ASYNC08:
	        	formObj.f_cmd.value = SEARCH17;
	        	var location = formObj.location.text;
	        	
	        	if(location == "RCC")
	        	{
	        		formObj.eq_orz_cht_chktype.value = "RCC";
	        		formObj.eq_orz_cht_rcc_cd.value = formObj.scc_cd.value;
	        	}else if(location == "LCC")
	        	{
	        		formObj.eq_orz_cht_chktype.value = "LCC";
	        		formObj.eq_orz_cht_lcc_cd.value = formObj.scc_cd.value;
	        	}else if(location == "SCC")
	        	{
	        		formObj.eq_orz_cht_chktype.value = "SCC";
	        		formObj.eq_orz_cht_scc_cd.value = formObj.scc_cd.value;
	        	}else
	        	{
	        		formObj.eq_orz_cht_chktype.value = "";
	        		formObj.eq_orz_cht_scc_cd.value = "";
	        	}
	     		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
	       		// 데이터 건수
	            var dataCount = ComGetTotalRows(sXml);
	            if(dataCount==0){
	            	ComShowCodeMessage('CGM10009','location cd');
	    	   		formObj.scc_cd.value = "";
	    	   		formObj.scc_cd.focus();
	            }
	      	    break;			
	        case IBRESET:
		 		var idx = 0
		 		var sXml2 = document.form2.sXml.value;
		 		var arrXml = sXml2.split("|$$|");
		
		 		
		 		
		 		if ( arrXml[idx] == null ) {return;}
		 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
		 	    var arrStr1 = new Array();
		 		for ( var i = 0; i < vArrayListData.length; i++) {
		 		    vListData = vArrayListData[i];
		 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
		 		}
		 		// combo control, 결과 문자열, Text Index, Code Index
			  	MakeComboObject(formObj.location, arrStr1, 0, 0);
		 		idx++;       
		 		break;
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	  with(formObj){
     		 switch(sAction) {
     		 	case IBSEARCH:
     		 		location.value  = location.text;
     		 		if(location.value == ''){
        				ComShowCodeMessage('CGM10004','location ');
        				location.focus();
        				
        				return false;
        			}
     		 		if(scc_cd.value == ''){
        				ComShowCodeMessage('CGM10004','scc_cd');
        				scc_cd.focus();
        				
        				return false;
        			}
     		 		if(scc_cd.value.length !=5){
    		 			ComShowCodeMessage('CGM10044','Location (5)');
           				scc_cd.focus();
           				
           				return false;
           			}
            		break;
     		 }      
     	 }

          return true;
     }
     
    
         /** 
          * Combo Object 초기화  <br>
          * @param  {object} comboObj	필수 Combo Object
          * @return 없음
          * @author 최민회
          * @version 2009.05.25
          */ 
         function initCombo(comboObj) {
          	switch(comboObj.id) {
       	       case "agmt_lstm_cd":
       	           var cnt=0;
       	           with(comboObj) {
       	            	Code = "";
       	            	Text = "";
       	            	DropHeight = 100;
       	            	MultiSelect = false;
       	            	MaxSelect = 1;	    
       	            	UseCode = true;
       	            	Enable = true;
       	            }
       	            break;
       	    }
       	} 
          
         /** 
          * Combo Object 에 값을 추가하는 처리 <br>
          * @param  {object} cmbObj	필수 Combo Object
          * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
          * @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
          * @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
          * @return 없음
          * @author 최민회
          * @version 2009.05.20
          */ 
         function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
             	cmbObj.RemoveAll();
               	for (var i = 0; i < arrStr.length;i++ ) {
               		var arrCode = arrStr[i].split("|");
               		cmbObj.InsertItem(i, arrCode[1], arrCode[codeCol]);
                }
               	cmbObj.Index2 = "" ;
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
         	 if(obj.dataformat == null) return;
         	 	
         	 window.defaultStatus = obj.dataformat;
         	 switch(obj.dataformat) {
         	    case "engup":
         	        if(obj.name=="scc_cd") ComKeyOnlyAlphabet('uppernum')
         	        else ComKeyOnlyAlphabet('upper');
         	        break;
         	    
         	 }
         	 
         	 
          }
           
        // 저장후 조회 기능 
   	    function sheet1_OnSaveEnd(sheetObj, errMsg) {
   	    	if(errMsg =='') {   
   	    		ComShowCodeMessage('CGM00003');
   	        	set_serch();
   			}
   	    }    
        
        // 조회 기능 
        function set_serch()
        {
       	   var sheetObject1 = sheetObjects[0];
           var formObject = document.form;
       	   doActionIBSheet(sheetObject1, formObject, IBSEARCH);
        }
        
        /**
         * 시트내 팝업 클릭(달력 호출)
         */
        function sheet1_OnPopupClick(sheetObj, row, col){
        	switch (sheetObj.ColSaveName(col)) {
        	case "mvmts_dt" :
        		if (sheetObj.ColSaveName(col) != "mvmts_dt"){
        			return;
        		}
        		
        		var cal = new ComCalendarGrid("myCal");
        		cal.setEndFunction("processEndCal");    // Calendar 선택 후의 이벤트를 발생시키기 위해 (onChange Event 대용)
        		cal.select(sheetObj, row, col, 'yyyy-MM-dd');

        		break;
        	case "sts_evnt_yd_cd" :
        		ComOpenPopup('/hanjin/COM_ENS_061.do' , 800, 475, 'setPrntUsrRoleCd','0,1,1,1,1,1,1', true, false, row, col, 0);
        		break;
        	 
        	}
        }

         function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
    			var sheetObject = sheetObjects[0];
    			sheetObject.CellValue(row, "sts_evnt_yd_cd") = aryPopupData[0][3];
     	 }
         
         /**
          * Found date 입력시, 현재 날짜/시간 이후를 입력시 오류.
          * "Found Date cannot be later than now."
          * @return
          */
         function processEndCal(){
        	 var sheetObj = sheetObjects[0];
        	
             if(sheetObj.CellValue(sheetObj.SelectRow, "mvmts_dt") > document.form.form_day.value){
     	    	sheetObj.CellValue(sheetObj.SelectRow, "mvmts_dt") = "";
     	    	sheetObj.CellValue(sheetObj.SelectRow, "del_chk") = "";
     	    	sheetObj.focus();
     	    	sheetObj.SelectCell(sheetObj.SelectRow,sheetObj.SelectCol-1, false);     	    	 
				ComShowCodeMessage("CGM10058");
     	    } else {
     	    	sheetObj.CellValue(sheetObj.SelectRow, "del_chk") = "1";
     	    }
     
         }
         
         /**
     	 * 선택된 셀이 바뀌었을때 발생하는 Event 처리
     	 * Agreement No 과 Referece No 의 유효성을 체크한다. 
     	 */
     	function sheet1_OnChange(sheetObj, Row, Col){
           var formObj = document.form;
           var chk      = true;
           switch (sheetObj.ColSaveName(Col)) {
        	  
        	 
              case "mvmts_dt" :
//            	  alert(document.form.form_day.value.substring(0, 8));
//            	  alert(sheetObj.CellValue(Row, "mvmts_dt").substring(0, 8));
            	    if(sheetObj.CellValue(Row, "mvmts_dt").substring(0, 8) >  document.form.form_day.value.substring(0, 8) ){
            	    	sheetObj.CellValue2(Row, "mvmts_dt") = "";
            	    	sheetObj.CellValue(Row, "del_chk") = "";
            	    	sheetObj.focus();
            	    	//sheetObj.SelectCell(Row,Col-1, false);
            	    	ComShowCodeMessage("CGM10058");
            	    } else {
            	    	sheetObj.CellValue(Row, "del_chk") = "1";
            	    }
        	   		
    		 	    break;
    	      case "sts_evnt_yd_cd" :
    	   			formObj.f_cmd.value = COMMAND01;
    			   	formObj.yd_cd.value =sheetObj.CellValue(Row, "sts_evnt_yd_cd");
    			   	if(formObj.yd_cd.value!="")
    			   	{
    			   		var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
    				   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
    				   	if(sCheckResult == COM_VALIDATION_FALSE){
    				   		ComShowCodeMessage('CGM10009','Yard');
    				   		sheetObj.CellValue2(Row, "sts_evnt_yd_cd") = "";
    				   		sheetObj.SelectCell(Row, Col-1, true);
//    				   	    sheetObj.CellValue(Row, "ibflag") = "";
//    				   		formObj.sts_evnt_yd_cd.focus();
    				   	} else {
    				   		sheetObj.CellValue(Row, "del_chk") = "1";
    				   		
    				   	} 
    				   	
    			   	}
    		 	    break;
  
        	}
       }
     	 
     	    /** 
     * Object 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 최민회
     * @version 2009.05.20
     */  
//    function obj_change(){
//    	 var formObj = document.form;
//    	 var sheetObj = sheetObjects[0]; 
//    	 obj = event.srcElement;
//    	 switch(obj.name){
//    	   
//	 		case "scc_cd":
//    	 		if(formObj.scc_cd.value != ''){
//    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
//    	 		}
//    	 			break;
//    	 }   
//    }
     
     /**
      * YA_CD 값 체크
      * @return
      */
     function obj_keyup(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 obj = event.srcElement;
    	 switch(obj.name){
	  	 	case "scc_cd":
		 		var crntLocCd = ComTrimAll(formObj.scc_cd.value);
		   		var arrCrntLocCd = crntLocCd.split(",");
		   		
		   		for(var i = 0; i < arrCrntLocCd.length; i++){
		   		// 입력오류 체크 (예> ,,)
		 			if(arrCrntLocCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Location');
		 				formObj.scc_cd.value = "";
		 				ComSetFocus(formObj.scc_cd);
		 				break;
		 			}else{
		    	 		//if(formObj.scc_cd.value != ''){
		    	 		if(formObj.scc_cd.value.length == 5){
		    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		    	 		}
		    	 	}
		 		}
		 		break;
    	 }
    }
    	 
  function sheet1_OnDblClick(sheetObj, Row, Col){
	   if(Col==2 && sheetObj.CellValue(Row, "eq_no")!=""){
	       	var param = "?pgmNo=EES_CGM_1105";
	       	
	       	var sts_evnt_dt =  sheetObj.CellValue(Row, "sts_evnt_dt");
	       	sts_evnt_dt = ComReplaceStr(sts_evnt_dt.substring(0,10),"-");
	       	param = param + "&eq_no=" + sheetObj.CellValue(Row, "eq_no") +"&to_day="+sts_evnt_dt; 
	    	ComOpenPopup('/hanjin/EES_CGM_1105.do' + param, 1000, 600, "", "1,0", true, false);
	   }
  }
	/* 개발자 작업  끝 */