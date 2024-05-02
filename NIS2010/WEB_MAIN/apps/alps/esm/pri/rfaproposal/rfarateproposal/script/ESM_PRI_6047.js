/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6047.js
*@FileTitle : S/C Proposal/Amendment CMPB/OPB View All
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.12 송민석
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
     * @class ESM_PRI_6047 : ESM_PRI_6047 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6047() {
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
    var isShowOp = true;
    var TITLE_TEXT_CM = "RFA CMPB View All";
    var TITLE_TEXT_OP = "RFA OPB View All";
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

                    case "btn1_Retrieve":
                   	 doActionIBSheet(sheetObject1,document.form,IBSEARCH);
                        break; 
                    

                    case "btn1_Close":
    					 self.close();
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
           ComOpenWait(true);
            var formObj = document.form;
           initParams(document.form);
           initCombo(formObj)
           initVisibleColSheet(sheetObjects[0],isShowOp);
           initViewTexts();
    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	   ComOpenWait(false);
        }
         
         /**  
          * Combo에서 필요한 코드를 조회해서 Combo에 Assign한다.
          * 화면에 Setting 해 놓는다.
          *  
          * <br><b>Example :</b>
          * <pre>
          *   initCombo(formObj);
          * </pre>
          * 
          * @param {object} formObj 필수, html document form Object
          * @return 없음
          */             
         function initCombo(formObj){  
           	var sheetObj = sheetObjects[0];
           	 //currency combo
       		formObj.f_cmd.value = COMMAND16;
       		var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
       		setIBCombo(sheetObj,sXml,"curr_cd",true,0,"USD");
       			
       		// per combo
       		formObj.f_cmd.value = SEARCH03;
       		sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
       		setIBCombo(sheetObj, sXml, "rat_ut_cd", true, 0);
       		
             //공통 cargo
             formObj.f_cmd.value = SEARCH19;
             sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01701");
             setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", true, 0);		
       		
         }       
         
         /** 
          * CM,OP에 따라 <BR>
          * 제목과 remark 부분의 text를 변경 시켜준다.
          *
          * <br><b>Example :</b>
          * <pre>
          *      initViewTexts()
          * </pre>
          * 
          * @return 없음
          */          
        function initViewTexts(){
       	 //remark text설정
       	 if(isShowOp){//OP관련 내용으로 변경
       	 	document.getElementById("titletext").innerText = TITLE_TEXT_OP;  
       	 }else{ //CM관련 내용으로 변경
   	 		document.getElementById("titletext").innerText = TITLE_TEXT_CM;      		 
       	 }
        }
         
  	  /**  
  	   * 팝업이 오픈될때 메인화면으로 부터 받은 초기 파라메터를<BR> 
  	   * 저장해 놓는다.
  	   *  
  	   * <br><b>Example :</b>
  	   * <pre>
  	   *   initParams(formObj)
  	   * </pre>
  	   *
  	   * @param {object} formObj 필수, html document form Object
  	   * @return 없음
  	   */           
        function initParams(formObj){
  		   if( formObj.cost_tp.value =="O"){
  			   isShowOp = true;
  		   }else{
  			   isShowOp = false;
  		   }
        }
        

        /** 
        * sheet의 OP,OPB column 들을 파라메터에 따라 보여주거나 숨긴다. <BR>
        * 
        *
        * <br><b>Example :</b>
        * <pre>
        *      initVisibleColSheet(sheetObj,isShow)
        * </pre>
        * 
        * @param {object} sheetObj 필수, sheet Object
        * @param {boolean} isShow 필수, true: 해당컬럼을 보여줌, false : 해당컬럼을 숨김
        * @return 없음
        */         
        function initVisibleColSheet(sheetObj,isShowOp){
        	if( !isShowOp ){ //CM데이터를 보여준다
	      		sheetObj.ColHidden("prs_respb_opfit_uc_amt") = true;
	      		sheetObj.ColHidden("prs_respb_opb_amt") = true;
	      		 
	      		sheetObj.ColHidden("prs_respb_cm_uc_amt") = false;
	      		sheetObj.ColHidden("prs_gid_cmpb_amt") = false;
	      		sheetObj.ColHidden("diff") = false;
        	}else{
	      		sheetObj.ColHidden("prs_respb_opfit_uc_amt") = false;
	      		sheetObj.ColHidden("prs_respb_opb_amt") = false;
	      		 
	      		sheetObj.ColHidden("prs_respb_cm_uc_amt") = true;
	      		sheetObj.ColHidden("prs_gid_cmpb_amt") = true;
	      		sheetObj.ColHidden("diff") = true;
        	}

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
            switch(sheetNo) {
                 case 1:      //sheet1 init
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 300;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 15, 100);

                        var HeadTitle1 = "|Seq.|CMDT|Actual\nCustomer|Route|Route|Route|Route|Per|CGO\nType|Cur.|Rate|Surcharge|Cost|Cost|CMPB|OPB|CMPB\nGuideline|Diff.|||||||prc_cmdt_def_nm|cust_nm";
    					 var HeadTitle2 = "|Seq.|CMDT|Actual\nCustomer|Origin|O.VIA|D.VIA|Dest.|Per|CGO\nType|Cur.|Rate|Surcharge|Cost|Cost|CMPB|OPB|CMPB\nGuideline|Diff.|||||||prc_cmdt_def_nm|cust_nm";
    					 var headCount = ComCountHeadTitle(HeadTitle1);
                        
    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
    					InitHeadRow(1, HeadTitle2, true);
 
    					
                        //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                        
    					InitDataProperty(0, cnt++ , dtSeq,    			30,   	daCenter,  	true,		"seq",   			false,          "",      dfNone,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"prc_cmdt_def_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			70,   	daLeft,  	true,		"cust_cd",   			false,          "",      dfNone,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    			75,   	daLeft,  	true,		"ori_rout_pnt_loc_def_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"ori_rout_via_port_def_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"dst_rout_via_port_def_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			75,   	daLeft,  	true,		"dst_rout_pnt_loc_def_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtCombo,    		35,   	daCenter,  	true,		"rat_ut_cd",   	false,          "",      dfNone,      		0,			false,       false);
     					InitDataProperty(0, cnt++ , dtCombo,    		40,   	daCenter,  	true,		"prc_cgo_tp_cd",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtCombo,    		40,   	daCenter,  	true,		"curr_cd",   false,          "",      dfNone,      		0,			false,       false);

     					InitDataProperty(0, cnt++ , dtData,    		85,   	daRight,  	true,		"prop_frt_rt_amt",   			false,          "",      dfFloat,      	2,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    		75,   	daRight,  	true,		"prs_scg_amt",   			false,          "",      dfFloat,      	2,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    		85,   	daRight,  	true,		"prs_respb_cm_uc_amt",   			false,          "",      dfFloat,      	2,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    		85,   	daRight,  	true,		"prs_respb_opfit_uc_amt",   			false,          "",      dfFloat,      	2,			false,       false);

    					InitDataProperty(0, cnt++ , dtData,    		60,   	daRight,  	true,		"prs_respb_cmpb_amt",   			false,          "",      dfFloat,      	1,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    		50,   	daRight,  	true,		"prs_respb_opb_amt",   			false,          "",      dfFloat,      	2,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    		50,   	daRight,  	true,		"prs_gid_cmpb_amt",   			false,          "",      dfFloat,      	2,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    		55,   	daRight,  	true,		"diff",   			false,          "",      dfFloat,      	2,			false,       false);
    					
    					
     					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"prop_no",   			false,          "",      dfNone,      		0,			false,      false);
     					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"amdt_seq",   			false,          "",      dfNone,      		0,			false,      false);
     					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"svc_scp_cd",   			false,          "",      dfNone,      		0,			false,      false);
     					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"gen_spcl_rt_tp_cd",   			false,          "",      dfNone,      		0,			false,      false);
     					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"cmdt_hdr_seq",   			false,          "",      dfNone,      		0,			false,      false);
     					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"rout_seq",   			false,          "",      dfNone,      		0,			false,      false);
    					InitDataProperty(0, cnt++ , dtHidden,    			50,   	daLeft,  	true,		"prc_cmdt_def_nm",   			false,          "",      dfNone,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtHidden,    			50,   	daLeft,  	true,		"cust_nm",   			false,          "",      dfNone,      		0,			false,       true);

     					
     					
    					CountPosition = 0;
    					

    					

    					//풍선도움말
    					ToolTipOption="balloon:true;width:320;icon:1";
    					Ellipsis = true;


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
    			ComOpenWait(true);
   				if(validateForm(sheetObj,formObj,sAction))
   		        formObj.f_cmd.value = SEARCH;
   		        sheetObj.DoSearch("ESM_PRI_6047GS.do", FormQueryString(formObj) );
   		        ComOpenWait(false);
   	            break;


    			case IBSAVE:        //저장
    				ComOpenWait(true);
    				if(validateForm(sheetObj,formObj,sAction))
    				formObj.f_cmd.value = MULTI;
   					sheetObj.DoSave("ESM_PRI_6047GS.do", FormQueryString(formObj) );
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
         * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         * @param {object} sheetObj 필수, sheet Object
         * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
         * @param {int} x 필수, X 좌표
         * @param {int} y 필수, Y 좌표
         * @return 없음
         */   
    	function sheet1_OnMouseMove(sheetObj, shift, x, y){
    	      var row = sheetObj.MouseRow;
    	      var col = sheetObj.MouseCol;
    	      var colName = sheetObj.ColSaveName(col);
    	      if( colName == "prc_cmdt_def_cd" ){
    	    	  var sText = sheetObj.CellText(row,"prc_cmdt_def_nm");
    	    	  sheetObj.ToolTipText(row,col) = sText;
    	      }else if( colName == "cust_cd" ){
    	    	  var sText = sheetObj.CellText(row,"cust_nm");
    	    	  
      	    	  sheetObj.ToolTipText(row,col) = sText;    	    	    	      
    	      }else if( colName == "ori_rout_pnt_loc_def_cd"
    	      		|| colName == "ori_rout_via_port_def_cd"
    	      		|| colName == "dst_rout_via_port_def_cd"
    	      		|| colName == "dst_rout_pnt_loc_def_cd" ){
    	    	  var sText = sheetObj.CellText(row,col);
    	    	  sheetObj.ToolTipText(row,col) = sText;
    	      }

    	}
   	
 
    	
    				

	/* 개발자 작업  끝 */