/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_6090.js
*@FileTitle : SC Proposal MQC estimate
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.10 송민석
* 1.0 Creation
* *=========================================================
* History :
* 2012.04.18 이석준[CHM-201217045-01] S/C Filed Cancel 기능및 조회 기능 추가
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
     * @class ESM_PRI_0122 : ESM_PRI_6090 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0122() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;
 
    var is_save_ok = false; // row 추가를 저장이 성공하면 하지 않기 위해서
    var is_upd_dt_chk = false; //update date check가 성공했는지
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

   	 /** 
   	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
   	  * <br><b>Example :</b>
   	  * <pre>
   	  * </pre>
   	  *
   	  * @return 없음
   	  */ 
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             
    		var sheetObject1 = sheetObjects[0];	
             
             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
    	
    				case "btn1_Close":
    					if (is_upd_dt_chk == true){ // Check해보니 이미 다른 사용자가 데이터 변경을 했다는 뜻
    						window.returnValue="SUCCESS"; //0003을 다시 조회하라는 뜻
    					}
    					
    					self.close();
    					break;
    					
    				case "btn1_filed_cancel":
    					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
//    					sheetObject1.DataInsert(0);
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
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         *
         * @param  {object}   sheet_obj 필수, sheet Object
         * @return 없음
         */ 
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++] = sheet_obj;
        }
        /** 
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         * 
         * @return 없음
         */ 
    	function loadPage() {
    		for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
    		}
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    		

        }
    
  
       /** 
       * 시트 초기설정값, 헤더 정의
       * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
       * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
       * <br><b>Example :</b>
       * <pre>
       * </pre>
       * @param {object} sheetObj 필수, sheet Object
       * @param {String} sheetNo 필수, sheet의 ID
       * @return 없음
       */ 
        function initSheet(sheetObj,sheetNo) {
            var cnt = 0;
            sheetObj.WaitImageVisible = false; 
            switch(sheetObj.id) {
            
    			case "sheet1":      // sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 300;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge + msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 15, 100);

                        var HeadTitle1  = "||Request Date|Request Staff|Request Staff|RQST OFC|Creation Staff|Creation Staff|Reason|S/C No|Proposal No|AMD No|Creation Date";
    					var headCount = ComCountHeadTitle(HeadTitle1);
                        
    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 13, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,   true,   	"ibflag");

    					InitDataProperty(0, cnt++ , dtHidden,		     40,   	daCenter,  	true,		"file_cxl_seq",   		false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			100,   	daCenter,  	true,		"rqst_dt",   	false,          "",      dfUserFormat,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    			140,   	daCenter,  	true,		"rqst_usr_nm",   	true,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtPopup,    		60,   	daCenter,  	true,		"rqst_usr_id",   	true,          "",      dfNone,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"rqst_ofc_cd",   	true,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			140,   	daCenter,  	true,		"cre_usr_nm",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"cre_usr_id",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			100,   	daCenter,  	true,		"file_cxl_rsn",   	true,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"sc_no",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"prop_no",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daCenter,  	true,		"amdt_seq",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			100,   	daCenter,  	true,		"cre_dt",   	false,          "",      dfNone,      		0,			false,       false);
    					
    					InitUserFormat(0, "rqst_dt", "####-##-##", "-" );
    					
    					CountPosition = 0;

    			   }
    			break;
            }
        }

        /** 
         * sheet에 관련된 실제 Action(Retrieve, Add, Delete)을 일으키는 함수
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         * @param {object} sheetObj 필수, sheet Object
         * @param {object} formObj 필수, html document form Object
         * @param {int} sAction 필수, action의 구분
         * @return 없음
         */   
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

               case IBSEARCH:      //조회
    
      		    formObj.f_cmd.value = SEARCH;
 
   				ComOpenWait(true);   
   				sheetObj.RemoveAll();
   				var sXml = sheetObj.GetSearchXml("ESM_PRI_0122GS.do", FormQueryString(formObj) );
   				sheetObj.LoadSearchXml(sXml)	
   				
   		       	// 첫번째 row 추가 로직 
   	    		if (is_save_ok == false){
   	    		  var formObject = document.form;
   	    		  var inst_line = sheetObj.DataInsert(0);
   	    		  
   		    		sheetObj.CellValue(inst_line,"prop_no")    = formObject.frm_prop_no.value;
   		    		sheetObj.CellValue(inst_line,"amdt_seq")   = formObject.frm_amdt_seq.value;
   		    		sheetObj.CellValue(inst_line,"sc_no")      = formObject.frm_sc_no.value;
   		    		sheetObj.CellValue(inst_line,"cre_usr_id") = formObject.in_usr_id.value;
   		    		sheetObj.CellValue(inst_line,"cre_usr_nm") = formObject.in_usr_nm.value;
   		    		
   		    		var rDate = new Date();
   		            var yy = rDate.getFullYear();
   		            var mm = rDate.getMonth() + 1 +"";
   		            var dd = rDate.getDate() +"";
   		            if (mm.length == 1) mm = "0" + mm;
   		            if (dd.length == 1) dd = "0" + dd;              
   		        	
   		            sheetObj.CellValue(inst_line,"rqst_dt") = ComGetMaskedValue(yy+mm+dd,"ymd","-");
   		        	
   		        	
   	    		}
   				
				ComOpenWait(false);
   				break;

			 case IBSAVE:        //저장
			 	ComOpenWait(true);   
			 	
		        /////////////////////////////////////////////////////////////////////
		        // update date 검사
		        var checkSheetObj = sheetObjects[0];
		        var checkTpCd = "CHECK1";
		        is_upd_dt_chk = checkChangingUpdateDate(checkSheetObj, checkTpCd )
		        if(is_upd_dt_chk){
		        	ComOpenWait(false);
		        	return false;
		        }
		        /////////////////////////////////////////////////////////////////////
		        
			 	formObj.f_cmd.value = MULTI;
			 	
			 	if (sheetObj.IsDataModified) {
			 	   sheetObj.DoSave("ESM_PRI_0122GS.do",FormQueryString(formObj) );			 	   
			 	} else {
			 	   ComShowCodeMessage('PRI00115');  
			 	}
			 	ComOpenWait(false);
                break;
            }
        }


        /** 
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         * <br><b>Example :</b>
         * <pre>
         *      if (!validateForm(sheetObj,document.form,sAction)) {
         *          return false;
         *       }
         * </pre>
         * @param {object} sheetObj 필수, sheet Object
         * @param {object} formObj 필수, html document form Object
         * @param {int} sAction 필수, action의 구분
         *
         * @return boolean, true: 유효, false: 비유효
         */  
        function validateForm(sheetObj,formObj,sAction){
        	//저장할때 필수값 확인 로직
            return true;
        }


        /** 
         * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         * @param {object} sheetObj 필수, sheet Object
         * @param {String} ErrMsg 필수, sheet의 결과 메시지
         * @return 없음
         */  
    	function sheet1_OnSearchEnd(sheetObj, ErrMsg){

        }
         
         /** 
          * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
          * <br><b>Example :</b>
          * <pre>
          * </pre>
          * @param {object} sheetObj 필수, sheet Object
          * @param {String} ErrMsg 필수, sheet의 결과 메시지
          * @return 없음
          */  
     	function sheet1_OnSaveEnd(sheetObj, ErrMsg){
         	 var result = sheetObj.EtcData("TRANS_RESULT_KEY");
         	 if( result == "S"){
         		 window.returnValue="SUCCESS"; //0003을 다시 조회 하라는 뜻
//         		 self.close();
         		is_save_ok = true;
         		self.close();
//         		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         	 }
         	
         }         
     	
    	 /**
    	    * OnPopupClick 이벤트 발생시 호출되는 function <br>
    	    * Scope Duration,Scope MQC, G/L Copy 를 호출한다. <br>
    	    * <br><b>Example :</b>
    	    * <pre>
    	    *
    	    * </pre>
    	    * @param {ibsheet} sheetObj 필수 IBSheet Object
    	    * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
    	    * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
    	    * @return 없음
    	    * @author 공백진
    	    * @version 2009.05.07
    	    */      
    	    function sheet1_OnPopupClick(sheetObj, Row, Col)
    	    {
    	        var colName = sheetObj.ColSaveName(Col);
    	        var formObj = document.form;
    	          
    	        switch(colName)
    	        {
    	            case "rqst_usr_id": //유저 아이디 선택 ui 선택
//    	            	  var param = '?ofc_cd='+v1+'&user_cd='+v2+'&user_nm='+v3+'&classId='+classId+"&f_cmd=2";
    	                ComOpenPopup('/hanjin/COM_ENS_091.do', 780, 535, 'getCOM_ENS_091_1', '1,0,1,1,1,1,1,1',true, true);

    	                break;    	                    	         
    	        }
    	    }          	
    	    /**
    	     * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
    	     */
    	    function getCOM_ENS_091_1(rowArray) {
    	    	var gubun = '';
    	    	var sheetObject1 = sheetObjects[0];	
    	    	var colArray = rowArray[0];

    	      	sheetObject1.CellValue(1,"rqst_usr_id") = colArray[4]
    	      	sheetObject1.CellValue(1,"rqst_usr_nm") = colArray[5]
    	      	sheetObject1.CellValue(1,"rqst_ofc_cd") = colArray[3]
    	      	                                                 
    	    }
    	    
    	    function sheet1_OnClick(sheetObj, Row, Col, Value) {
    	      	var colname = sheetObj.ColSaveName(Col);
    	        	switch(colname)
    	        		{
    	    	    	case "file_cxl_rsn":	    		
    	    	  			ComShowMemoPad(sheetObj,Row,Col,false,300,200);  
                         break;
    	        		}
    	    }
    	    
   /**
    * 화면에서 계약번호로 조회 후 amend, request등의 이벤트를 일으키기전에 <BR>
    * 같은 계약번호로 다른 사용자가 먼저 데이타를 변경시켰는지 확은을 한다.<BR>
    * <br><b>Example :</b>
    * <pre>
    *     checkChangingUpdateDate(sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} checkSheetObj update date와 key를 가진 sheet object
    * @param {String} checkTpCd update date를 check해야 하는 table이 다를 수 있다 이를 구분하는 code
    *  
    * @return boolean , true : 변경된 데이터 있음, false: 변경된 데이터 없음.
    * @author 송민석
    * @version 2010.06.29
    */
   function checkChangingUpdateDate(checkSheetObj, checkTpCd ){
    	
    	var returnValue = false;
    	var formObj = document.form;
//    	var amdt_seq = getMaxProposalAmendSeq(checkSheetObj,checkSheetObj.CellValue(1, "sc_no"));
//    	alert(amdt_seq);
        /////////////////////////////////////////////////////////////////////
        // update date 검사
	   switch(checkTpCd){
	   case "CHECK1" :
	        var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_SP_MN&page_name=S/C&key1=" + checkSheetObj.CellValue(1, "prop_no") + "&key2="+checkSheetObj.CellValue(1, "amdt_seq")+"&upd_dt="+formObj.frm_upd_dt.value;
	        var cXml = checkSheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }
	        break;
	   }
       return returnValue;
        /////////////////////////////////////////////////////////////////////
    }   
//   function getMaxProposalAmendSeq(checkSheetObj,ScNo){
//	        var maxAmdtSeq = 0;
//			var param = "f_cmd="+SEARCH01+"&sc_no="+ScNo ;
//		 	var sXml = checkSheetObj.GetSearchXml("ESM_PRI_0057GS.do" , param);		 	
//			
//		if (ComGetEtcData(sXml,"amdt_seq") != undefined){
//			maxAmdtSeq =  ComGetEtcData(sXml,"amdt_seq");
//		}	
//		return maxAmdtSeq;
//   }
//  /* 개발자 작업  끝 */