/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_6091.js
*@FileTitle : SC Proposal MQC estimate
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.10 송민석
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
     * @class ESM_PRI_6091 : ESM_PRI_6091 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6091() {
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
    					self.close();
    					break;
    					
    				case "btn1_OK":
    					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
    		changeHeaderName();
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    		
    		

        }
         
        function changeHeaderName(){
    		var formObj = document.form;
    		sheetObjects[0].CellValue(0,"prs_prop_scp_mqc_qty") = "Target MVC("+formObj.frm_cntr_lod_ut_text.value+")";
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
            var mqc = document.form.frm_tgt_mvc_qty.value;
            if( mqc == ""){
            	mqc = "0";
            }
            switch(sheetObj.id) {
            
    			case "sheet1":      // sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 150;
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

                        var HeadTitle1  = "|Seq.|SVC Scope|Target MVC(FEU)|Share(%)|calc_flg|prop_no|amdt_seq";
    					var headCount = ComCountHeadTitle(HeadTitle1);
                        
    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 6, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,   true,   	"ibflag");

    					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			140,   	daCenter,  	true,		"svc_scp_cd",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtAutoSum,		120,		daRight,	false,		"prs_prop_scp_mqc_qty",	false,  "",			dfNullFloat,2,	true,		true);
    					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"share",	false,  "|prs_prop_scp_mqc_qty|/"+mqc+"*100",			dfNullFloat,2,	false,		false);
    					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,	false,		"calc_flg",	false,  "",			dfNone,2,	false,		false);
    					InitDataProperty(0, cnt++ , dtHidden,    			80,   	daCenter,  	true,		"prop_no",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtHidden,    			80,   	daCenter,  	true,		"amdt_seq",   			false,          "",      dfNone,      		0,			false,       false);
    																				
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
   				var sXml = sheetObj.GetSearchXml("ESM_PRI_6091GS.do", FormQueryString(formObj) );
   				sheetObj.LoadSearchXml(sXml)	
				ComOpenWait(false);
   				break;

			 case IBSAVE:        //저장
			 	ComOpenWait(true);   
			 	formObj.f_cmd.value = MULTI;
			 	sheetObj.DoSave("ESM_PRI_6091GS.do",FormQueryString(formObj) );
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
        	 changeCellStatus(sheetObj);
        	 changeButtonStatus(sheetObj);
        	 mergeTotalLine(sheetObj);
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
         		window.returnValue="SUCCESS";
         		 self.close();
         	 }
         	changeButtonStatus(sheetObj);
    
         }         
         
         
        

         /** 
          * sheet의 내용이 변경 
          * <br><b>Example :</b>
          * <pre>
          * </pre>
          * @param {object} sheetObj 필수, sheet Object
          * @param {String} ErrMsg 필수, sheet의 결과 메시지
          * @return 없음
          */  
     	function sheet1_OnChange(sheetObj, ErrMsg){
     		mergeTotalLine(sheetObj);
     		changeButtonStatus(sheetObj);
         }  

     	function changeCellStatus(sheetObj){
         	with(sheetObj){	
     			for (var i = HeaderRows ; i < LastRow; i ++){
     				if(CellValue(i,"calc_flg") == "Y"){
     					CellEditable(i,"prs_prop_scp_mqc_qty") = false;
     				}
     			}
         	}
     	}
     	
     	function mergeTotalLine(sheetObj){
         	with(sheetObj){

     			/*토탈 라인 합쳐지기. */
     			var row = LastRow;
     			var startCol = SaveNameCol("seq");
     			var endCol = SaveNameCol("svc_scp_cd");
     				
 				SumText(0, "seq") = "";
 				SumText(0, "svc_scp_cd") = "Total";
         	}
     	}
     	
     	
     	
     	/** 
         * 현재 화면의 데이터 상태를 고려해 버튼들의 상태를 바꾼다.
    	 * <br><b>Example :</b>
    	 * <pre>
    	 *      changeButtonStatus(sheetObjects[0]);
    	 * </pre>
    	 * @param {object} sheetObj 필수, sheet Object
    	 * @return 없음
    	 */  	
    	function changeButtonStatus(sheetObj){
    		var formObj = document.form;
    		var is_req_usr = formObj.is_req_usr.value;
    		var is_apro_usr = formObj.is_apro_usr.value;
    		var prc_prop_sts_cd = formObj.prc_prop_sts_cd.value;
     	
    	 
    		if(prc_prop_sts_cd == "I"){
       	   		if(is_req_usr == "Y" || is_apro_usr == "Y" ){   
       	   			if( sheetObj.IsDataModified == true  ){
       	   				ComBtnEnable("btn1_OK");
       	   			}else{
       	   				ComBtnDisable("btn1_OK");
       	   			}
       	   		}
       		}else if(prc_prop_sts_cd == "R"){
       	   		if(is_req_usr == "Y" ){   			
       	   			if( sheetObj.IsDataModified == true  ){
       	   				ComBtnEnable("btn1_OK");
       	   			}else{
       	   				ComBtnDisable("btn1_OK");
       	   			}
       	   		}
       		}else{
       			ComBtnDisable("btn1_OK");
       			 
       		}
       		
       		
    	   		
    	   		
    	   		 
    	}
          	
 
	/* 개발자 작업  끝 */