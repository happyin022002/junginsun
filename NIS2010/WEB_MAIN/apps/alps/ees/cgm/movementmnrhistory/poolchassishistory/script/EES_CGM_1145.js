/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EES_CGM_1145.js
*@FileTitle : Invoice File Import(Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.15 최민회
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
     * @class EES_CGM_1145 : EES_CGM_1145 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1145() {
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

 
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
 
	//파일업로드를 사용하기 위한 
	var uploadObjects = new Array();
	var uploadCnt = 0;
 
	//파일Seq저장변수 (추가될때 )
	var uploadFileSeq  = "";
	var fileUploadFlag = false;

	var fileSaveFlag = false; 

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject = sheetObjects[0];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
	             case "btn_rowadd":
	            	 sheetObject.DataInsert();
	            	 for(i=1; i<sheetObject.rowCount+1; i++){
	     				if(sheetObject.CellValue(i, "ibflag") == "I"){
	     					sheetObject.CellEditable(i, "org_file_nm") = true;
	     				}
	     			}
	            	 break;
	             case "btn_retrieve":
	            	 doActionIBSheet(sheetObject,document.form,IBSEARCH)
	            	 break;
     			// 히든 컬럼값 셋팅(CUD Query에서 필수 컬럼값)
	     		case "btn_delete":
	    			// 화면에서만 삭제(삭제함수 호출)
	    			rowDelete(sheetObject);
	    			break;
                 case "btn_save":
                	 doActionIBSheet(sheetObject,document.form,IBSAVE)
 					 break;


                 case "btn_close":
                     window.close();
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
  	 * IBUpload Object를 uploadObjects 배열에 등록
  	 * 배열은 소스 상단에 정의
  	 */
  	function setUploadObject(uploadObj){
  		uploadObjects[uploadCnt++] = uploadObj;
  	}

  	function initUpload(uploadObj, uploadNo) {
  		uploadObj.Files = "";
  	}

      /**
       * 선택된 ROW 삭제 
       */
      function rowDelete(sheetObj){
      	for(i=sheetObj.rowCount; i>0; i--){
      		if( sheetObj.CellValue(i, "del_chk") == "1") {
      			if(sheetObj.CellValue(i, "file_imp_proc_sts_cd")!="C" 
      			&& sheetObj.CellValue(i, "file_seq")!=""){
      				ComShowCodeMessage('CGM10083');
      				return ;
      			} else {
      				if(sheetObj.CellValue(i, "file_seq")==""){
      					sheetObj.RowDelete(i, false);
      				} else {
      					sheetObj.RowHidden(i)= true;	//2.행 숨기기
        				sheetObj.RowStatus(i)= "D";		//3.트랜잭션 상태 "삭제"로 만
      				}
      				
      			}
      		}
      	}
      }

     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {

  		for ( var i = 0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

  		 //alset(uploadObjects[0]);
         ComConfigUpload(uploadObjects[0], "/hanjin/CGM_INTGS.do");
     }
      
      /**
       * 
       * @param sheetObj
       * @return
       */
      function sheet1_OnLoadFinish(sheetObj) {
          sheetObj.WaitImageVisible = false;
          
   	     
  		 initControl(sheetObjects[0]);   
  		 
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
      	
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 
      }


   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 280;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     var HeadTitle = "|Seq.|Sel.|Lessor File Name|Import Process Status|Import Result|Import Time|Import User ID||||";
 										
 										
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq,       30,    daCenter,   false,     "Seq");
                     InitDataProperty(0, cnt++ , dtCheckBox,      30,    daCenter,   false,     "del_chk");
                     
                     InitDataProperty(0, cnt++ , dtPopup, 140, daCenter, false, "org_file_nm", 	        false, "",   dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,  140, daCenter, false, "file_imp_proc_sts_nm", false, "",   dfNone, 0, false, false);
                     
                     InitDataProperty(0, cnt++ , dtData,  250, daCenter, false, "imp_rslt_desc",        false, "",   dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,  120, daCenter, false, "file_imp_dt",     	    false, "",   dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,   50, daCenter, false, "cre_usr_id",  	        false, "",   dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtHidden,  200, daCenter, false, "org_file_path",	    false, "",	dfNone,	0, false, true); 
                     InitDataProperty(0, cnt++ , dtHidden,  150, daCenter, false, "sav_file_nm",	        false, "",	dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtHidden,  150, daCenter, false, "file_seq",	            false, "",	dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtHidden,  140, daCenter, false, "file_imp_proc_sts_cd", false, "",   dfNone, 0, false, false);

                     
 										
                }
                 break;

  

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

            case IBSEARCH:      //조회
               formObj.f_cmd.value = SEARCH;
			   queryString = "f_cmd=" + SEARCH ;
			   var params = FormQueryString(formObj);
			   sheetObj.WaitImageVisible=false;
			   ComOpenWait(true);
			   sheetObj.DoSearch("EES_CGM_1145GS.do",  params);
			   ComOpenWait(false);
                 break;

 			 case IBSAVE:        //저장
// 			     var params = sheetObj.GetSaveXml(true);
	 			 if(validateForm(sheetObj,formObj,sAction)){
	 				 var sParam = "";
				     var sParam1 = sheetObj.GetSaveString(true);
				     formObj.f_cmd.value = MULTI;
				     queryString = "f_cmd=" + MULTI ;
				     var params = FormQueryString(formObj);
				   //  sParam = sParam1 + "&"+ params;
				     var sXml = sheetObj.DoSave("EES_CGM_1145GS.do" , params);
	 			 }
 			     
                 break;

 		 
         }
     }




     /**
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;

     }

    /**
     * upload 객체 수행 오류 이벤트 처리
     * @param Message
     * @param MsgCode
     * @param Description
     * @param EventFile
     * @param File2
     * @return
     */
    function upload1_OnMessage(uObj, Message, MsgCode, Description, EventFile, File2)
    {
    	/*
    	//alert("chungpa>>>Message:"+ Message+ "\nMsgCode:" + MsgCode+ "\nDescription:"+Description+"\nEventFile:"+EventFile+"\nFile2:"+File2 );
    	if(MsgCode.substr(0,4) == "INFO")
    	{
    		
    	}
    	else if(MsgCode.substr(0,3) == "ERR")
    	{
    		if(MsgCode == "ERR-008")
    		{
    			ComShowCodeMessage('CGM10082');
    			return;
    		}else
    		{
    			ComShowCodeMessage('CGM20036',MsgCode); 
    			return;
    		}
    	}
    	*/
    }
      
    /**
  	 * 파일 선택하기 <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
  	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
  	 **/
  	function sheet1_OnPopupClick(sheetObj, Row, Col) {
  		var colName = sheetObj.ColSaveName(Col);

  		switch (colName) {
  			case "org_file_nm":
  				if ( fileUploadFlag ) {
  		    		return;
  		    	}

  		    	var upObj = uploadObjects[0];
  			    var fileName = sheetObj.OpenFileDialog("");
  			 	//var fileName = sheetObj.OpenFileDialog("", "", "", "Excel|*.xls|Excel|*.XLS|Text|*.txt|Text|*.TXT");
  			 	var relativePath = "";
  			 	var fileType     = "";
  				var badFile = false;

  				if ( fileName.indexOf("\\") == -1 ) {
  					badFile = true;		
  				} else {
  					relativePath = fileName.substr(fileName.lastIndexOf("\\") + 1);         // File Name
  					fileType     = relativePath.substr(relativePath.lastIndexOf(".") + 1);  // File Type

  					//TXT, XLS
  					if ( fileType.toUpperCase() != "CSV" && fileType.toUpperCase() != "ZIP" 
  						&& fileType.toUpperCase() != "XLS"&& fileType.toUpperCase() != "XLSX" ) {
  						badFile = true;
  					}
  				}

  			 	if ( !badFile ) {
  			 		ComOpenWait(true);
  			 		fileUploadFlag = true;

  			 		sheetObj.CellValue2(Row, "org_file_nm")   = relativePath;
  			 	//	sheetObj.CellValue2(Row, "org_file_path") = fileName;

  			 		// 기존파일을 모두 지운후 추가함
  			 		upObj.Files = "";
  			 		var ret  = upObj.AddFile(fileName);
  					var sXml = upObj.DoUpload(true);
  					uploadFileName = ComGetEtcData(sXml,"filename");
  					sheetObj.CellValue2(Row, "sav_file_nm") = uploadFileName;
  					if(sheetObj.CellValue(Row, "sav_file_nm")==""){
  						//chungpa 20100126 OnMessage로 이전
  						//ComShowCodeMessage('CGM10082');
  						ComShowCodeMessage('CGM20036'); 
  						sheetObj.CellValue2(Row, "org_file_nm") = "";
  					} 

  					fileUploadFlag = false;
  					ComOpenWait(false);
  			 	} else {
  			 		ComShowCodeMessage('CGM10081');
  				}

  			 	break;
  		}
  	} 
  	  /**
  	   * 에러 로그 보기
  	   * @param sheetObj
  	   * @param Row
  	   * @param Col
  	   * @return
  	   */
  	  function sheet1_OnDblClick(sheetObj, Row, Col){
	  		if(Col==5  ){
	  			var param = "?pgmNo=EES_CGM_1149";
		       	
		       	param = param + "&file_seq=" + sheetObj.CellValue(Row, "file_seq") ; 
		    	ComOpenPopup('/hanjin/EES_CGM_1149.do' + param, 700, 460, "", "1,0", true, false);

	  		}
  	   }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
      function validateForm(sheetObj,formObj,sAction){
    	  switch(sAction) {

			case IBSAVE:      //조회
	 
			for(i=1;i<sheetObj.rowCount+1;   i++){
			 
	      		if( sheetObj.CellValue(i, "del_chk") == "1" &&  sheetObj.CellValue(i, "ibflag") == "I") {
	      			if(sheetObj.CellValue(i, "sav_file_nm") == ""){
	      				sheetObj.RowStatus(i)= "R";		 
		      			sheetObj.CellValue(i, "del_chk") = "0";
	      			} else {
	      				sheetObj.RowStatus(i)= "I";	 
	      			}
					
	      		} else if( sheetObj.CellValue(i, "ibflag") == "D") {
	      			sheetObj.RowStatus(i)= "D";	
	      		} else if( sheetObj.CellValue(i, "del_chk") == "1" && sheetObj.CellValue(i, "ibflag") == "U") {
	      			if( sheetObj.CellValue(i, "file_seq") != ""){
	      				sheetObj.RowStatus(i)= "R";	
	      				sheetObj.CellValue(i, "del_chk") = "0";
	      			} else {
	      				sheetObj.RowStatus(i)= "I";
	      			}
	      		} else {
	      			sheetObj.RowStatus(i)= "R";		 
	      			sheetObj.CellValue(i, "del_chk") = "0";
	      		}
	      		 
	      	}
			
	    		
            break;
			
    	  }
         return true;
     }
 	
      function sheet1_OnSaveEnd(sheetObj, errMsg) {
    		 if(errMsg =='') {   
    			 ComShowCodeMessage('CGM00003');
    	    	 var sheetObject1 = sheetObjects[0];
    		     
    			 doActionIBSheet(sheetObject1,document.form,IBSEARCH); 
    		 }
    	 }   

	/* 개발자 작업  끝 */