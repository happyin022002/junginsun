/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0026.js
*@FileTitle : Undeclared History
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.16
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.12.16 김도현
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
     * @class vop_scg_0026 : vop_scg_0026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0026() {
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
 var IBSEARCH01  = 29;
 var comboObjects = new Array();
 var comboCnt = 0;
 var uploadObjects = new Array();
 var uploadCnt     = 0;


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
	
				case "btn_add":										
					sheetObject1.DataInsert(-1);
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
					break;
					
				case "btn_del":					
					ComRowHideDelete(sheetObject1, "del_chk");
					break;	
			   
				case "btn_save":
			        doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			        break;		
				
				case "btn_new":
					formObject.reset();
					sheetObject1.RemoveAll();
					sheetObject1.Editable = true;
					comboObjects[0].Code = "";
					break;
 					
		        case "btns_period": // From 달력버튼
		        	var cal = new ComCalendarFromTo();
		        	cal.select(formObject.rqst_dt_fr, formObject.rqst_dt_to, 'yyyy-MM-dd');
		            break;
		            
				case "btn_update":
					selectFile(sheetObject1, false);
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
      * 파일 선택하기 <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {ibsheet} addRowFlag  sheetObj에 Row추가 여부
      **/
 	function selectFile(sheetObj, addRowFlag){
 		if(addRowFlag) {
 			sheetObj.DataInsert(-1,0);								//File Add인 경우 New Row 생성
 		} else {
 		
 			var filePath = sheetObj.OpenFileDialog('Please choose target file to upload.');
 			
 			if(filePath.indexOf("\\") !=-1) {
 				with(sheetObj) {
 					CellValue2(SelectRow, "file_set_yn") = "Y";				//로컬파일 선택여부 설정
 					CellValue2(SelectRow, "file_sav_id") = filePath;			//파일 로컬경로 설정
 		
 					fileName = filePath.substr(filePath.lastIndexOf("\\")+1);
 					CellValue2(SelectRow, "file_nm")= fileName;			    //파일명 설정
 					
 					CellFontUnderline(SelectRow, "file_nm") = false;			//다운로드 링크 해제
 				}
 			}
 		}
 	}

     /**
      * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
     function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
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
      * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
      * @param {ibupload} uploadObj    IBUpload Object
      **/
 	function setUploadObject(uploadObj) {
 		uploadObjects[uploadCnt++] = uploadObj;
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
         
         //IBMultiCombo초기화
         for(var k = 0; k < comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }
         
         //UPLOAD 환경 설정
         for(var i=0;i<uploadObjects.length;i++){
 		    //1. 기본 환경 설정
 		    ComConfigUpload(uploadObjects[i], "/hanjin/VOP_SCG_0026GS.do");
 		}
         
         axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
 	     axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		 axon_event.addListenerFormat('keydown',	      'obj_keydown',	 form); //- 키 눌렸을때
		 axon_event.addListenerFormat('keypress',         'obj_keypress',	 form); //- 키 눌렸을때
		 axon_event.addListenerForm('keydown',	'ComKeyEnter',	    form); //- 키 눌렸을때	
		 axon_event.addListenerForm('blur', 	'obj_blur', 	document.form);
		 axon_event.addListenerForm('focus', 	'obj_focus', 	document.form);
		 
 		var formObj = document.form;
	    formObj.rqst_dt_fr.value = frDt;
	    formObj.rqst_dt_to.value = toDt;
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
			case "rqst_dt_fr":	case "rqst_dt_to":
			ComAddSeparator(event.srcElement);
			break;    	 		
		}
	}
 	
    // 업무 자바스크립트 OnFocus 이벤트 처리
    function obj_focus() {
   	 
    	switch(event.srcElement.name){ 
	    	case "rqst_dt_fr":	case "rqst_dt_to":
	    		ComAddSeparator(event.srcElement);
	        	break;
    	}
    }

    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
     function initCombo(comboObj, comboNo) {
   	  switch(comboObj.id) {
   	  	case "rgn_shp_opr_cd":    
   	  		var i=0;
   	  		with(comboObj) {
   	  			SetTitle("Code|Description");
   	  			SetColAlign("center|left");
   	  			SetColWidth("50|150");
   	  			DropHeight = 200;
  	         	}
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
                 style.height = 370;
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
                 InitColumnInfo(31, 5, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, false, true, true, false,false);

                 var HeadTitle1 = "||REQUEST DATE|UNDECLARED DATE|BKG NO.|RHQ|OFFIC|LANE|VVD|POL|POL ETD|TYPE|KEYWORD|Customs Description|Container Description|BKG Description|BKG Description|BKG Description|Ext.Remark|Int.Remark|Shipper|Onboard|Actual Commodity|Result|Remark|FileSetYn|File Sav Id|File Name";

                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                
                 InitDataProperty(0, cnt++ , dtHiddenStatus, 		 10,  daCenter, false, 	  "ibflag");
                 InitDataProperty(0, cnt++ , dtDummyCheck, 			 20,  daCenter, true,     "del_chk");
                 InitDataProperty(0, cnt++ , dtData,	 			120, daCenter, true,     "rqst_dt",    			false,      "",      dfNone, 	    0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,	 			120, daCenter, true,     "udecl_dt",    		false,      "",      dfNone, 	    0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,	 			100, daCenter, true,     "bkg_no",    			true,       "",      dfNone, 	    0,     false,       true, 13);
                 InitDataProperty(0, cnt++ , dtData,	 			 60, daCenter, true,     "rhq",    				false,      "",      dfNone, 	    0,     false,       true, 5);
                 InitDataProperty(0, cnt++ , dtData,	 			 60, daCenter, true,     "rqst_ofc_cd", 		false,      "",      dfNone, 	    0,     false,       true, 5);
                 InitDataProperty(0, cnt++ , dtData,	 			 60, daCenter, true,     "slan_cd",    			false,      "",      dfNone, 	    0,     false,       true, 3);
                 InitDataProperty(0, cnt++ , dtData,	 			 80, daCenter, true,     "vvd",    				false,      "",      dfNone, 	    0,     false,       true, 9);
                 InitDataProperty(0, cnt++ , dtData,	 			 60, daCenter, true,     "pol_cd",    			false,      "",      dfNone, 	    0,     false,       true, 5);
                 InitDataProperty(0, cnt++ , dtData,	 			120, daCenter, true,     "pol_eta_dt",    		false,      "",      dfNone, 	    0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "keyword_type",    	false,      "",      dfNone, 	    0,     false,       false);
                 InitDataProperty(0, cnt++ , dtHidden,	 			 80, daLeft	 , true,     "keyword",    			false,      "",      dfNone, 	    0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,	 			150, daLeft	 , true,     "cstms_desc",    		false,      "",      dfNone, 	    0,     false,       true);
                 InitDataProperty(0, cnt++ , dtData,	 			150, daLeft	 , true,     "cntr_mf_gds_desc",	false,      "",      dfNone, 	    0,     false,       true);
                 InitDataProperty(0, cnt++ , dtData,			 	 25, daLeft	 , true,	 "sb_cmdt_desc",		false,		"",		 dfNone,		0,	   false,		false);
                 InitDataProperty(0, cnt++ , dtHidden,	 			  0, daLeft	 , true,     "cmdt_desc",    		false,      "",      dfNone, 	    0,     false,       true);
                 InitDataProperty(0, cnt++ , dtData,	 			150, daLeft	 , true,     "cst_cmdt_desc",    	false,      "",      dfNone, 	    0,     false,       true);
                 InitDataProperty(0, cnt++ , dtData,	 			 80, daLeft	 , true,     "xter_rmk",    		false,      "",      dfNone, 	    0,     false,       true);
                 InitDataProperty(0, cnt++ , dtData,	 			 80, daLeft	 , true,     "inter_rmk",    		false,      "",      dfNone, 	    0,     false,       true);
                 InitDataProperty(0, cnt++ , dtData,	 			150, daLeft	 , true,     "shipper",    			false,      "",      dfNone, 	    0,     false,       true);
                 InitDataProperty(0, cnt++ , dtCombo,	 			 70, daCenter, true,     "on_brd_flg",    		false,      "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			120, daLeft	 , true,     "cmdt_ctnt",    		false,      "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 80, daLeft	 , true,     "rslt_rmk1",    		false,      "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 80, daLeft	 , true,     "rslt_rmk2",    		false,      "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtHidden,          	  0, daCenter, true,     "file_set_yn",		    true,       "",      dfNone,      	0,     true,    	true);
                 InitDataProperty(0, cnt++ , dtHidden,   	   		  0, daLeft,   true,     "file_sav_id", 		true,       "",      dfNone,      	0,     true,    	true);
                 InitDataProperty(0, cnt++ , dtData,			    100, daCenter, true,     "file_nm", 	    	false,      "",      dfNone,      	0,     false,   	false, 200);
                 InitDataProperty(0, cnt++ , dtHidden,	 			 80, daLeft	 , true,     "vsl_cd",    			false,      "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtHidden,	 			 80, daLeft	 , true,     "skd_voy_no",    		false,      "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtHidden,	 			 80, daLeft	 , true,     "skd_dir_cd",    		false,      "",      dfNone, 	    0,     true,        true);
                 
 				// 대문자 처리
   				InitDataValid(0, "rhq", vtEngUpOther, "1234567890-");	 
  				InitDataValid(0, "rqst_ofc_cd", vtEngUpOther, "1234567890-");	 
  				InitDataValid(0, "slan_cd", vtEngUpOther, "1234567890-");	 
  				InitDataValid(0, "pol_cd", vtEngUpOther, "1234567890-");	 
  				InitDataValid(0, "bkg_no", vtEngUpOther, "1234567890-");	 
 				InitDataValid(0, "vvd", vtEngUpOther, "1234567890-");	 
 				InitDataCombo (0, "on_brd_flg", "Y|N", "Y|N","N");
// 				InitDataCombo (0, "keyword_type", "I|II|III|IV", "A|B|C|D","A");
         
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

         if(validateForm(sheetObj,formObj,sAction)){
			  sheetObj.WaitImageVisible=false;
			  ComOpenWait(true);        			  
			  formObj.f_cmd.value = SEARCH;
			
			  sheetObj.DoSearch("VOP_SCG_0026GS.do", FormQueryString(formObj));
			  ComOpenWait(false);
         }
       break;
       
		case IBSEARCH01:
			sheetObj.WaitImageVisible = false;
			formObj.f_cmd.value = SEARCH01;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_SCG_0026GS.do", sParam);
			var chkBkgNo = ComGetEtcData(sXml, "CHKBKGNO");
		    return chkBkgNo;
			break;
     
       case IBSAVE:        //저장
           if(!validateForm(sheetObj,formObj,sAction)){
				return;
			}
    	   
           var sParam =  ComGetSaveString(sheetObjects );
           
           if( sParam == ""){ return;}
           formObj.f_cmd.value = MULTI;         
           var aryPrefix = new Array("sheet1_");
           /*
           sParam += "&" + FormQueryString(formObj);
		   var aryPrefix = new Array("sheet1_");
		   var sXml = sheetObjects[0].GetSaveXml("VOP_SCG_0026GS.do", sParam+"&" + ComGetPrefixParam( aryPrefix ) );
		   
		   sheetObjects[0].LoadSaveXml(sXml);//Hidden Object 에 로드
           var error = ComGetEtcData(sXml, "ERROR");
           */
           
            //1.IBUpload에 파일 추가하기
			var upObj = uploadObjects[0];	
			upObj.Files="";					//먼저기존파일을 모두 지운후 추가함
			setFileUpload(sheetObj, upObj);	//Sheet의 추가 파일정보를 IBUpload로 Copy
			if (upObj.LocalFiles == "") {
				/*******파일이 없는 경우 IBSheet 이용하기********/
				//2.IBSheet 데이터 QueryString으로 묶기
				var sParam = ComGetSaveString(sheetObj);					
				if (sParam == "") return;
				
				//3.Form 데이터 QueryString으로 묶기
				sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
				
				ComOpenWait(true, true);	//키보드나 마우스를 대기상태 & 대기이미지
				
				//4. 서버에 request전달하고, reponse 받기
				var sXml = sheetObj.GetSaveXml("VOP_SCG_0026GS.do", sParam);
			
			} else {
				/*******파일이 있는 경우 IBUpload 이용하기********/
				//2.IBSheet 데이터 QueryString으로 묶기
				var sParam = ComGetSaveString(sheetObj, true);
				if (sParam == "") return;
				//3.Form 데이터 QueryString으로 묶기				
				sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
				ComOpenWait(true, true);	//키보드나 마우스를 대기상태 & 대기이미지
				//4. 서버에 request전달하고, reponse 받기
				upObj.ExtendParam = sParam;
				upObj.ParamDecoding = true;
				var sXml = upObj.DoUpload(true);
			}
			
			if (sXml.length > 0) sheetObj.LoadSaveXml(sXml);
			
			ComOpenWait(false);
			
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
           
    	case IBSEARCH_ASYNC01: //RSO 조회
     		sheetObj.WaitImageVisible = false;
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("VOP_SCG_0034GS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, formObj.rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
			
   			comboObjects[0].InsertItem(0, "ALL","");
   			comboObjects[0].Text = "ALL";
			
			break;
           
     }
   }
   
   function validateForm(sheetObj,formObj,sAction){
       with(formObj){
      	     if(sAction == IBSAVE){
          	     if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
          	    	 return false;	 
          	     }
        	 }else if (sAction == IBSEARCH) {
        		 if (comboObjects[0].Code == "") {
    				 ComShowCodeMessage('SCG50011','RSO');
        			 formObj.rgn_shp_opr_cd.focus();
        			 return;
        		 }
        		 
        		 if (formObj.rqst_dt_fr.value == "" || formObj.rqst_dt_to.value == "") {
        			ComShowCodeMessage('SCG50011','Request Date');
    				formObj.rqst_dt_fr.focus();
    				return false;
        		 }
             }
       }
       return true;
   }


   function sheet1_OnLoadFinish(sheetObj) {
       doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);	//RSO Combo생성
   }

   function sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
	
	 	switch(colName) {
			case "bkg_no":
	             if (sheetObj.CellValue(row, col).length < 10) {
	            	 ComShowCodeMessage("SCG50010", sheetObj.CellValue(row, "bkg_no"));
	            	 sheetObj.CellValue2(row, "bkg_no") = "";
	            	 return false;
	             }else{
	 	 			formObj.chk_bkg_no.value 		 = sheetObj.CellValue(row, "bkg_no");
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH01);

					if(data == '0'){
						ComShowCodeMessage("SCG50010", sheetObj.CellValue(row, "bkg_no"));
						sheetObj.CellValue2(row, "bkg_no") = "";
						formObj.chk_bkg_no.value = "";
				   		return false;
					}else{
			 	 		if(sheetObj.RowCount > 0){
			 	 			for(var i=sheetObj.HeaderRows ; i < sheetObj.LastRow ; i++){
		 						if(formObj.chk_bkg_no.value == sheetObj.CellValue(i,"bkg_no")){
		 							ComShowCodeMessage("SCG50004", sheetObj.CellValue(row, "bkg_no"));
									sheetObj.CellValue2(row, "bkg_no") = "";
							   		return false;
		 						}
			 	 			}
			 	 		}
					}
	             }
	 		break;
	 		
			case "vvd":
	             if (sheetObj.CellValue(row, col).length < 9) {
	            	 ComShowCodeMessage("SCG50010", sheetObj.CellValue(row, "vvd"));
	            	 sheetObj.CellValue2(row, "vvd") = "";
	            	 return false;
	             }else{
	            	var vvd = sheetObj.CellValue(row, "vvd");
	            	
	            	sheetObj.CellValue2(row, "vsl_cd") = vvd.substr(0,4);
	            	sheetObj.CellValue2(row, "skd_voy_no") = vvd.substr(4,4);
	            	sheetObj.CellValue2(row, "skd_dir_cd") = vvd.substr(8,1);
	             }
	 		break;
	 	}
	}
   
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
   	 with(sheetObj)
   	 {
   		 if(LastRow >= 1){
//   	   		 if(LastRow > 1){
    		 for (var i=1; i <= LastRow; i++)
    		 {
    			 
    			 CellFontColor(i, "bkg_no") = sheetObj.RgbColor(38, 99, 224);
    			 CellFont("FontUnderline", i, "bkg_no") = true;
    			 
    			// Booking Description of Goods 한줄 이상일경우, 한줄만 보여준다 
 		 		var cmdt_desc_split = sheetObj.CellValue(i,"cmdt_desc").split('\n');
 		 		if(cmdt_desc_split.length > 1){
 		 			sheetObj.CellValue2(i,"cst_cmdt_desc") = cmdt_desc_split[0];
 		 			sheetObj.CellValue2(i,"sb_cmdt_desc") = "(+)";
 		 			CellFontColor(i, "sb_cmdt_desc") = sheetObj.RgbColor(255, 0, 0);
 		 		}else{
 		 			sheetObj.CellValue2(i,"cst_cmdt_desc") = sheetObj.CellValue(i,"cmdt_desc");
 		 		}
    			 
    		 }
   		 }
   	 }
    }
    
    function sheet1_OnClick(sheetObj, Row, Col, Val)
    {
   	 with(sheetObj)
   	 {
   		 var colname = ColSaveName(Col);
   		 var formObj = document.form;
   		 switch(colname)
   		 {
	 		 	case "bkg_no":
	 		 		if(sheetObj.CellValue(Row,"bkg_no") != ''){
	 		 			comBkgCallPopBkgDetail(sheetObj.CellValue(Row,"bkg_no"));
	 		 		}
			 		break;
   		 }
   	 }
    }
    
    function sheet1_OnDblClick(sheetObj, Row, Col, Val)
    {
		 with(sheetObj)
		 {
			 var colname = ColSaveName(Col);
			 var formObj = document.form;
			 switch(colname)
			 {
				case "cst_cmdt_desc":
				bookingDescPop(sheetObj, Row, "cmdt_desc");
				break;

				case "file_nm":

					//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
					if(sheetObj.CellText(Row, "file_nm") == "" 
						|| sheetObj.RowStatus(Row) == "I" 
						|| sheetObj.CellValue(Row, "file_set_yn") == "Y") {			
						selectFile(sheetObj, false);			
						return;
					}
					parent.location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, "file_sav_id");
					return;

				break;
				
				
			 
			 }
		 }
    }
 	
 	function bookingDescPop(sheetObj, Row, Col) {
 		var formObj = document.form;
 		var content = "";
		var non_dcgo_kw_nm = sheetObj.CellValue(Row,"keyword").split('\n');
		var non_dcgo_kw_nm_split = [];
		var desc_pop = sheetObj.CellValue(Row,Col);
		if(desc_pop != ''){
	 		var desc_pop_split = desc_pop.split('\n');
	
	 		var a = 0;
	 		for(var b=0; b<non_dcgo_kw_nm.length; b++) {
	 			var space_non_dcgo_kw_nm_1 = non_dcgo_kw_nm[b].split(' ');
		 		for(var c=0; c<space_non_dcgo_kw_nm_1.length; c++) {
		 			non_dcgo_kw_nm_split[a] = space_non_dcgo_kw_nm_1[c];
		 			a++;
		 		}
	 		}
	 		
	 		for(var i=0; i<desc_pop_split.length; i++) {
	 			var space_desc_pop_split = desc_pop_split[i].split(' ');
	
	 			for(var j=0; j<space_desc_pop_split.length; j++) {
	 				
	 				for(var k=0; k<non_dcgo_kw_nm_split.length; k++) {
		 				if(specialTrim(space_desc_pop_split[j]) == ComTrim(non_dcgo_kw_nm_split[k])){
		 					content += "<FONT COLOR='RED'>";
		 				}
	 				}
	 				
	 				content += space_desc_pop_split[j];
	 				
	 				for(var k=0; k<non_dcgo_kw_nm_split.length; k++) {
		 				if(specialTrim(space_desc_pop_split[j]) == ComTrim(non_dcgo_kw_nm_split[k])){
		 					content += "</FONT> ";
		 				}
	 				}
	 				
	 				content += " ";
	 				
	 			}
	 			content += "<BR>";
	 			
	 		}
	 		formObj.content.value = content;
		   	var theURL = "VOP_SCG_0025.do";
		   	var winName = "Booking Description of Goods Detail";
		   	var features = "scroll:yes;status:no;resizable=yes;help:no;dialogWidth:500px;dialogHeight:500px";
		   	ComOpenWindow(theURL,winName,features,true);
		} 		
 	} 	
    
 	function specialTrim(str) {
 		str = ComTrimAll(str,",","`","~","!","@","#","$","%","^",";","|",";","/","?").replace(/\s/g, "");
 		return str;
 	} 	
     
	/**
	 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
	 * @param {ibsheet}   sheetObj    IBSheet Object
	 * @param {ibupload}  upObj    	  IBUpload Object
	 **/
	function setFileUpload(sheetObj, upObj) {	
		for (var rowIdx=1; rowIdx<=sheetObj.RowCount; rowIdx++){ 
			var fileSetYn = sheetObj.CellValue(rowIdx, "file_set_yn");
			
			//파일 경로 가져오기
			if(fileSetYn == 'Y') {
				var sFile = sheetObj.CellValue(rowIdx, "file_sav_id");		
				if (sFile=="") ComShowCodeMessage('SCG50004', 'Data');	//'{?msg1} is not available.'
				
				//IBUpload에 파일 추가하기
				var ret = upObj.AddFile(sFile);
			}
		}
	
		return; 
	}
 	
	/* 개발자 작업  끝 */