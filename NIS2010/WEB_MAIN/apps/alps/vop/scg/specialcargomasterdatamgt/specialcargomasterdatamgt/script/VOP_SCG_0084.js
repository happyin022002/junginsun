/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0084.js
*@FileTitle : HJS Chemical Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* ========================================================
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
     * @class vop_scg_0084 : vop_scg_0084 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0084() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
		this.sheet1_OnChange        = sheet1_OnChange;    	
    	this.validateForm 			= validateForm;
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
				   
				    ComBtnEnable("btn_RowAdd");
				    ComBtnEnable("btn_RowDelete");
				    ComBtnEnable("btn_save");
					
			 	   break;
	
				case "btn_RowAdd":										
					sheetObject1.DataInsert(-1);
					break;
				
				case "btns_period": // From 달력버튼
			        	var cal = new ComCalendarFromTo();
			        	cal.select(formObject.rqst_fr_dt, formObject.rqst_to_dt, 'yyyy-MM-dd');
			            break;
					
				case "btn_RowDelete":					
					ComRowHideDelete(sheetObject1, "del_chk");
					break;	
			   
				case "btn_save":
			        doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			        break;		
				
				case "btn_new":
					
					formObject.reset();
					sheetObject1.RemoveAll();
					sheetObject1.Editable = true;
					break;
				
				case "btn_application":		
					onPopupClick(srcName);
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
         axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
 	     axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		 axon_event.addListenerFormat('keydown',	      'obj_keydown',	 form); //- 키 눌렸을때
		 axon_event.addListenerFormat('keypress',         'obj_keypress',	 form); //- 키 눌렸을때
		 axon_event.addListenerForm('keydown',	'ComKeyEnter',	    form); //- 키 눌렸을때	
		 axon_event.addListenerForm('blur', 	'obj_blur', 	document.form);
		 axon_event.addListenerForm('focus', 	'obj_focus', 	document.form);
		 
		    ComBtnDisable("btn_add");
			ComBtnDisable("btn_del");
			ComBtnDisable("btn_save");
			
			var formObj = document.form;
		    formObj.rqst_fr_dt.value = frDt;
		    formObj.rqst_to_dt.value = toDt;

    }
    

  	//Axon 이벤트 처리2. 이벤트처리함수
  	function obj_deactivate(){
  	    ComChkObjValid(event.srcElement);
  	}
  	
  	function obj_activate(){
  	    ComClearSeparator(event.srcElement);
  	}
  	
  	function obj_blur() {
		var formObj = document.form;
		switch(event.srcElement.name){
			case "rqst_fr_dt":	case "rqst_to_dt":
			ComAddSeparator(event.srcElement);
			break;    	 		
		}
	}
  	
    // 업무 자바스크립트 OnFocus 이벤트 처리
    function obj_focus() {
   	 
    	switch(event.srcElement.name){ 
	    	case "rqst_fr_dt":	case "rqst_to_dt":
	    		ComAddSeparator(event.srcElement);
	        	break;
    	}
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
                 InitRowInfo( 2, 1, 3, 100);
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(15, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, false, true, true, false,false);

                 var HeadTitle =  "|Sel.|Inquiry|Inquiry|Inquiry|Inquiry|Inquiry|Inquiry|Inquiry|Inquiry|Inquiry|Inquiry|Inquiry|Inquiry|Inquiry|Answered|Answered|Answered|Answered|Answered|Email||";
                 var HeadTitle1 = "|Sel.|SEQ|Chemical Name|CAS NO|CAS NO|CAS NO|Mixture|Manufacturer|MSDS|Photo|Test Report|Office|ID|DATE|Opinion|Comment|Special provision|ID|DATE|Email||";

                 var headCount = ComCountHeadTitle(HeadTitle);

     			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
     			InitColumnInfo(headCount, 4, 0, true);

     			// 해더에서 처리할 수 있는 각종 기능을 설정한다
     			InitHeadMode(true, true, false, true, false, false)

     			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
     			InitHeadRow(0, HeadTitle, true);
     			InitHeadRow(1, HeadTitle1, true);
                
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus,   30,   daCenter, false,    "ibflag");
                 InitDataProperty(0, cnt++ , dtDummyCheck, 	   40,   daCenter, true,      "del_chk");
                 InitDataProperty(0, cnt++ , dtDataSeq,	 	   30,   daCenter) ;
                 InitDataProperty(0, cnt++ , dtData,	 	   120,  daLeft,    true,     "chem_nm",           true,      "",      dfNone, 	    0,     true,       true);
                 InitDataProperty(0, cnt++ , dtData, 	 	   70,   daLeft,    true,     "chem_abst_svc_no1", false,     "",      dfNone, 	    0,     true,       true, 10);
                 InitDataProperty(0, cnt++ , dtData, 	 	   20,   daLeft,    true,     "chem_abst_svc_no2", false,     "",      dfNone, 		0,     true,       true, 2);
                 InitDataProperty(0, cnt++ , dtData, 	 	   20,   daLeft,    true,     "chem_abst_svc_no3", false,     "",      dfNone, 		0,     true,       true, 1);
                 InitDataProperty(0, cnt++ , dtCombo, 	 	   50,   daCenter,  true,     "spcl_cgo_flg",      false,     "",      dfNone, 		0,     true,       true);
                 InitDataProperty(0, cnt++ , dtData, 	 	   120,  daLeft,    true,     "co_nm",             false,     "",      dfNone, 		0,     true,       true);
                 InitDataProperty(0, cnt++ , dtPopup, 	 	   50,   daCenter,  true,     "file1",             false,     "",      dfNone, 		0,     true,       true);
                 InitDataProperty(0, cnt++ , dtPopup, 	 	   50,   daCenter,  true,     "file2",             false,     "",      dfNone, 		0,     true,       true);
                 InitDataProperty(0, cnt++ , dtPopup, 	 	   50,   daCenter,  true,     "file3",             false,     "",      dfNone, 		0,     true,       true);
                 InitDataProperty(0, cnt++ , dtData, 	 	   60,   daCenter,  true,     "rqst_ofc_cd",       false,     "",      dfNone, 		0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData, 	       70,   daCenter,  true,     "rqst_id",           false,     "",      dfNone, 		0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData, 	 	   70,   daCenter,  true,     "rqst_dt",           false,     "",      dfNone, 		0,     false,      false);
                 InitDataProperty(0, cnt++ , dtCombo, 	 	   70,   daCenter,  true,     "chem_opin_knd_cd",  false,     "",      dfNone, 		0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData, 	 	   200,  daLeft,    true,     "cmt_ctnt",          false,     "",      dfNone, 		0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData, 	 	   50,   daCenter,  true,     "imdg_spcl_provi_no",false,     "",      dfNone, 		0,     false,      false, 3);
                 InitDataProperty(0, cnt++ , dtData, 	 	   70,   daCenter,  true,     "re_msg_id",         false,     "",      dfNone, 		0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData, 	       80,   daCenter,  true,     "re_msg_dt",         false,     "",      dfNone, 		0,     false,      false);
                 InitDataProperty(0, cnt++ , dtHidden, 	       50,   daCenter,  true,     "eml_snd_no_pop",    false,     "",      dfNone, 		0,     false,      false);
                 InitDataProperty(0, cnt++ , dtHidden, 	 	   50,   daLeft,    true,     "chem_abst_svc_no",  false,     "",      dfNone, 		0,     false,      true);
                 InitDataProperty(0, cnt++ , dtHidden,	 	   30,   daCenter,  true,     "chem_seq",          false,     "",      dfNone, 	    0,     false,      false);
                 
                
               
                 InitDataValid(0, "chem_abst_svc_no1", vtNumericOnly);
                 InitDataValid(0, "chem_abst_svc_no2", vtNumericOnly);
                 InitDataValid(0, "chem_abst_svc_no3", vtNumericOnly);
                 InitDataCombo (0, "chem_opin_knd_cd", "DG|Conditionally Non-DG|NON DG|Pending", "D|C|N|P","DG");
                 InitDataCombo (0, "spcl_cgo_flg","Y|N","Y|N","N");
                 
                 ImageList(0) = "img/btng_detail.gif";		// Detail
				 CountPosition = 0;
         
         }
         break;
             
        
      }
   }

   // Sheet관련 프로세스 처리
   function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
        var sheetObject1 = sheetObjects[0];
		var saveObjs = new Array(1);
		saveObjs[0] = sheetObject1;


		sheetObject1.WaitImageVisible=false;

		
     switch(sAction) {
       case IBSEARCH:        //조회

         // if(validateForm(sheetObj,formObj,sAction)){
			  sheetObj.WaitImageVisible=false;
			  ComOpenWait(true);        			  
			  formObj.f_cmd.value = SEARCH;
			  sheetObj.DoSearch("VOP_SCG_0084GS.do", FormQueryString(formObj));
			  ComOpenWait(false);
       //   }
       break;
       
       case IBSAVE:        //저장
           if(!validateForm(sheetObj,formObj,sAction)){
				return;
			}
    	   
           var sParam =  ComGetSaveString(sheetObjects );
           
           if( sParam == ""){ return;}
           formObj.f_cmd.value = MULTI;                  
        
           sParam += "&" + FormQueryString(formObj);
		   var aryPrefix = new Array("sheet1_");
		   var sXml = sheetObjects[0].GetSaveXml("VOP_SCG_0084GS.do", sParam+"&" + ComGetPrefixParam( aryPrefix ) );
		   
		   sheetObjects[0].LoadSaveXml(sXml);//Hidden Object 에 로드
           var error = ComGetEtcData(sXml, "ERROR");
          
           if(error != undefined){
        		ComShowMessage( error + '\n'+ "Please check Keyword name because of duplication.");
				return ;
			}
           else {
                sheetObj.ShowDebugMsg = false; 
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
           break;
     }
   }
   
   
   function validateForm(sheetObj,formObj,sAction){
       with(formObj){
      	     if(sAction == IBSAVE){
          	     if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
          	    	 return false;	 
          	     }
             }
       }
       return true;
   }

   function onPopupClick(srcName){
	  var nseq = sheetObjects[0].CellText(sheetObjects[0].SelectRow, "chem_seq");
	  var nm = sheetObjects[0].CellText(sheetObjects[0].SelectRow, "chem_nm");
	  var sParam = "chem_seq="+nseq+"&chem_nm="+nm;
    
	  if(nseq!="")  ComOpenWindowCenter("VOP_SCG_0109.do?"+sParam, "winDtl", "600", "300", true, "yes");
	 } 		 
  		 
   
   function sheet1_OnPopupClick(sheetObj,Row,Col){
	   var nseq = sheetObjects[0].CellText(sheetObjects[0].SelectRow, "chem_seq");
	  
	   switch (sheetObj.ColSaveName(Col)) {
			case "file1" :
				if(nseq!="") popupAtchFile('M',Row);
	     	    break;
	     	
			case "file2" :				//attach 팝업
				if(nseq!="") popupAtchFile('P',Row);
     	        break;
     	    
			case "file3" :				//attach 팝업
				if(nseq!="") popupAtchFile('R',Row);
     	        break;
     	
		}
	}
   
	function popupAtchFile(div, Row){
		var formObj = document.form;
		seq = sheetObjects[0].CellValue(Row, "chem_seq");
	  	var url = "VOP_SCG_0112.do?atch_file_div_cd=" + div +"&chem_seq=" + seq ;
	    var popup = window.showModalDialog(url, self, "dialogHeight:440px;dialogWidth:640px;center:yes;location:no;resizable:no;scroll:no;status:no;");
		
		reload();
	}
  		 
   function sheet1_OnDblClick(sheetObj,Row,Col,Value) {
	    var formObj = document.form;
		var colName = sheetObj.ColSaveName(Col);
	 	
		switch(colName) {
		case('imdg_spcl_provi_no'):
		  var no = sheetObj.CellValue(Row, "imdg_spcl_provi_no");
		  if(no!="") {
	      sParam = "imdg_spcl_provi_no="+sheetObj.CellValue(Row, "imdg_spcl_provi_no");
	      ComOpenWindowCenter("VOP_SCG_0041.do?"+sParam, "winDtl", "1040", "700", true, "yes");
		  }
	   break;
	}
   }
	 
     
	/* 개발자 작업  끝 */