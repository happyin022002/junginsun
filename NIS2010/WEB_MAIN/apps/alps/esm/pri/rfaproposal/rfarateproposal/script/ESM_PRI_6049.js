/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6049.js
*@FileTitle : PRS- S/C Amendment CM/OP View All
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.22 송민석
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
     * @class ESM_PRI_6049 : ESM_PRI_6049 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6049() {
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
    var isReqUsr = false;
    var isAproUsr = false;

    var REMARK_TEXT_OP = "» CM= CMPB * PFMC , OP= OPB * PFMC\n» Actual: Actual Figures for current RFA\n» Estimate: Estimated Figures for current RFA based on actual figures\n» Sum= Actual + Estimate";
    var REMARK_TEXT_CM = "» CM= CMPB * PFMC\n» Actual: Actual Figures for current RFA\n» Estimate: Estimated Figures for current RFA based on actual figures\n» Sum= Actual + Estimate";
    var TITLE_TEXT_CM = "RFA Amendment CM View All";
    var TITLE_TEXT_OP = "RFA Amendment OP View All";
    
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

   
                if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
                	if (getButtonTable(srcName).disabled) {
                		return false;
                	}
                }
                          
                
               switch(srcName) {

                    case "btn2_Retrieve":
                   	 doActionIBSheet(sheetObject1,document.form,IBSEARCH);
                        break; 
                    case "btn2_Save":
                   	 doActionIBSheet(sheetObject1,document.form,IBSAVE);
                        break;                       

                    case "btn1_Close":
    					 self.close();
                        break; 
            		case "pfmc_unit" :
            			doActionIBSheet(sheetObject1,document.form,IBSEARCH);
           			break;
             		case "btn2_DownExcel":
             			ComPriShowDialogExcel(sheetObject1,ComGetMsg("PRI03002"));
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
           initParams(document.form);
           initVisibleColSheet(sheetObjects[0],isShowOp);
           initViewTexts();
    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	   changeButtonStatus(sheetObjects[0]);
    	   ComOpenWait(false);
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
        		document.getElementById("remarktext").innerText = REMARK_TEXT_OP;  
        	 	document.getElementById("titletext").innerText = TITLE_TEXT_OP;  
        	 }else{ //CM관련 내용으로 변경
        		document.getElementById("remarktext").innerText = REMARK_TEXT_CM;  
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
	       	 if( formObj.cost_tp.value == "O"){
	    		 isShowOp = true;
	    	 }else{
	    		 isShowOp = false;
	    	 }
	    	 var is_req_usr = formObj.is_req_usr.value;
	    	 var is_apro_usr = formObj.is_apro_usr.value;
	    	 if( is_req_usr.toUpperCase() == "TRUE" ){
	    		 isReqUsr = true;
	    	 }
	    	 if( is_apro_usr.toUpperCase() == "TRUE" ){
	    		 isAproUsr = true;
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
        function initVisibleColSheet(sheetObj,isShow){
      		 sheetObj.ColHidden("prs_crnt_respb_opb_amt") = !isShow;
      		 sheetObj.ColHidden("crnt_op") = !isShow;
      		 sheetObj.ColHidden("prs_rmn_respb_opb_amt") = !isShow;
      		 sheetObj.ColHidden("rmn_op") = !isShow;
      		 sheetObj.ColHidden("prs_sum_opb_amt") = !isShow;
      		 sheetObj.ColHidden("sum_op") = !isShow;

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
 
       		
       		if(sheetObj.RowCount > 0 && sheetObj.IsDataModified == true ){
    	   		if(formObj.prc_prop_sts_cd.value == "I"   ){
    	   	   		if(isReqUsr || isAproUsr ){   			
    	   	   			enableButton("btn2_Save");
    	   	   		}else{
    	   	   			disableButton("btn2_Save");
    	   	   		}
    	   		}else if(formObj.prc_prop_sts_cd.value == "R"){
    	   	   		if(isReqUsr ){   			
    	   	   			enableButton("btn2_Save");
    	   	   		}else{
    	   	   			disableButton("btn2_Save");
    	   	   		}
    	   		
    	   		}else{
    	   			disableButton("btn2_Save");
    	   		}
       		}else{
       			disableButton("btn2_Save");
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
                	 	var byView = ComPriGetCheckedRadioButtonValue(document.form.by_view);

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
                        InitRowInfo(2, 1, 15, 100);

                        var HeadTitle1 = "Seq.|";
                        
    					 var HeadTitle2 = "Seq.|";
    					 if( byView == "CMDT"){
    						 HeadTitle1 += "CMDT|Actual\nCustomer|";
    						 HeadTitle2 += "CMDT|Actual\nCustomer|";
    					 }else{
    						 HeadTitle1 += "Actual\nCustomer|CMDT|";
    						 HeadTitle2 += "Actual\nCustomer|CMDT|";
    					 }
    					 HeadTitle1 += "dummy_seq|Route|Route|Route|Route|Actual|Actual|Actual|Actual|Actual|Actual|Estimate|Estimate|Estimate|Estimate|Estimate|Estimate|Sum|Sum|Sum|Sum|Sum|Sum|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|prs_rat_ut_cd|ori_prs_estm_lod_qty|prc_cmdt_def_nm|cust_nm|gid|ibflag|flg_search_cmpb";
    					 HeadTitle2 += "dummy_seq|Origin|O.VIA|D.VIA|Dest.|PFMC|Share|CMPB|CM|OPB|OP|PFMC|Share|CMPB|CM|OPB|OP|PFMC|Share|CMPB|CM|OPB|OP|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|prs_rat_ut_cd|ori_prs_estm_lod_qty|prc_cmdt_def_nm|cust_nm|gid|ibflag|flg_search_cmpb";
    					 var headCount = ComCountHeadTitle(HeadTitle1);
                        
    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 8, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
    					InitHeadRow(1, HeadTitle2, true);
    					 
    					
                        //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                        
    					InitDataProperty(0, cnt++ , dtData,    			30,   	daCenter,  	true,		"seq_num",   			false,          "",      dfNone,      		0,			false,       true);
    					if( byView == "CMDT"){
	    					InitDataProperty(0, cnt++ , dtData,    			60,   	daLeft,  	true,		"prc_cmdt_def_cd",   			false,          "",      dfNone,      		0,			false,       true);
	    					InitDataProperty(0, cnt++ , dtData,    			70,   	daLeft,  	true,		"cust_cd",   			false,          "",      dfNone,      		0,			false,       true);
    					}else{
	    					InitDataProperty(0, cnt++ , dtData,    			70,   	daLeft,  	true,		"cust_cd",   			false,          "",      dfNone,      		0,			false,       true);
	    					InitDataProperty(0, cnt++ , dtData,    			60,   	daLeft,  	true,		"prc_cmdt_def_cd",   			false,          "",      dfNone,      		0,			false,       true);
    					}
    					InitDataProperty(0, cnt++ , dtSeq,    			30,   	daCenter,  	true,		"dummy_seq",   			false,          "",      dfNone,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    			85,   	daLeft,  	true,		"ori_rout_pnt_loc_def_cd",   			false,          "",      dfNone,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"ori_rout_via_port_def_cd",   			false,          "",      dfNone,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"dst_rout_via_port_def_cd",   			false,          "",      dfNone,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    			85,   	daLeft,  	true,		"dst_rout_pnt_loc_def_cd",   			false,          "",      dfNone,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		60,   	daRight,  	true,		"prs_crnt_lod_qty",   			false,          "",      dfNullFloat,      	1,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		50,   	daRight,  	true,		"crnt_share",   			false,          "",      dfNone,      	2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		55,   	daRight,  	true,		"prs_crnt_respb_cmpb_amt",   			false,          "",      dfNullFloat,      	2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		85,   	daRight,  	true,		"crnt_cm",   			false,          "",      dfNullInteger,      	2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		55,   	daRight,  	true,		"prs_crnt_respb_opb_amt",   			false,          "",      dfNullFloat,      	2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		85,   	daRight,  	true,		"crnt_op",   			false,          "",      dfNullInteger,      	2,			false,       true);

    					InitDataProperty(0, cnt++ , dtData,    		60,   	daRight,  	true,		"prs_rmn_lod_qty",   			false,          "",      dfFloat,      	1,			true,       true);
    					InitDataProperty(0, cnt++ , dtData,    		50,   	daRight,  	true,		"rmn_share",   			false,          "",      dfNone,      	2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		55,   	daRight,  	true,		"prs_rmn_respb_cmpb_amt",   			false,          "",      dfNullFloat,      	2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		85,   	daRight,  	true,		"rmn_cm",   			false,          "|prs_rmn_respb_cmpb_amt| * |prs_rmn_lod_qty|",      dfNullInteger,      	2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		55,   	daRight,  	true,		"prs_rmn_respb_opb_amt",   			false,          "",      dfNullFloat,      	2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		85,   	daRight,  	true,		"rmn_op",   			false,          "|prs_rmn_respb_opb_amt| * |prs_rmn_lod_qty|",      dfNullInteger,      	2,			false,       true);
    		
    					
    					InitDataProperty(0, cnt++ , dtData,    		60,   	daRight,  	true,		"prs_sum_lod_qty",   			false,          "|prs_crnt_lod_qty|+|prs_rmn_lod_qty|",      dfFloat,      	1,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    		50,   	daRight,  	true,		"sum_share",   					false,          "",      dfNone,      	2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		55,   	daRight,  	true,		"prs_sum_cmpb_amt",   			false,          "((|prs_crnt_respb_cmpb_amt|*|prs_crnt_lod_qty|)+(|prs_rmn_respb_cmpb_amt|*|prs_rmn_lod_qty|) ) / (|prs_crnt_lod_qty|+|prs_rmn_lod_qty|)",      dfNullFloat,      	2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		85,   	daRight,  	true,		"sum_cm",   					false,          "(|prs_crnt_respb_cmpb_amt|*|prs_crnt_lod_qty|)+(|prs_rmn_respb_cmpb_amt|*|prs_rmn_lod_qty|)",      dfNullInteger,      	2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		55,   	daRight,  	true,		"prs_sum_opb_amt",   			false,          "((|prs_crnt_respb_opb_amt|*|prs_crnt_lod_qty|)+(|prs_rmn_respb_opb_amt|*|prs_rmn_lod_qty|) ) / (|prs_crnt_lod_qty|+|prs_rmn_lod_qty|)",      dfNullFloat,      	2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    		85,   	daRight,  	true,		"sum_op",   					false,          "(|prs_crnt_respb_opb_amt|*|prs_crnt_lod_qty|)+(|prs_rmn_respb_opb_amt|*|prs_rmn_lod_qty|) ",      dfNullInteger,      	2,			false,       true);

    					
    					
    					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"prop_no",   			false,          "",      dfNone,      		0,			false,      false);
    					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"amdt_seq",   			false,          "",      dfNone,      		0,			false,      false);
    					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"svc_scp_cd",   			false,          "",      dfNone,      		0,			false,      false);
    					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"cmdt_hdr_seq",   			false,          "",      dfNone,      		0,			false,      false);
    					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"rout_seq",   			false,          "",      dfNone,      		0,			false,      false);
    					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"prs_rat_ut_cd",   			false,          "",      dfNone,      		0,			false,      false);
    					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"ori_prs_rmn_lod_qty",   			false,          "",      dfNullFloat,      		1,			false,      false);
    					InitDataProperty(0, cnt++ , dtHidden,    			50,   	daLeft,  	true,		"prc_cmdt_def_nm",   			false,          "",      dfNone,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtHidden,    			50,   	daLeft,  	true,		"cust_nm",   			false,          "",      dfNone,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtHidden,    			50,   	daLeft,  	true,		"gid",   			false,          "",      dfNone,      		0,			false,       true);
    	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
    					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"flg_search_cmpb",   			false,          "",      dfNone,      		1,			false,      false);

    					CountPosition = 0;
    					
    					ColHidden("dummy_seq")=true;
    					
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
   				if(validateForm(sheetObj,formObj,sAction));
   				initSheet(sheetObj,1);
   		        formObj.f_cmd.value = SEARCH;
   		        sheetObj.DoSearch("ESM_PRI_6049GS.do", FormQueryString(formObj) + "&table_cd=SP");
   		        ComOpenWait(false);
   	            break;


    			case IBSAVE:        //저장
    				ComOpenWait(true);
    				if(validateForm(sheetObj,formObj,sAction))
    				formObj.f_cmd.value = MULTI;
	 
					var sXml = sheetObj.GetSaveXml("ESM_PRI_6049GS.do", sheetObj.GetSaveString() + "&" + FormQueryString(formObj) + "&table_cd=SP");
	
					SAVE_STATE = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
					sheetObj.LoadSaveXml(sXml);
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
         * Load값이 변경 됐을경우 그 값에 따라 CMPB,OPB,SHARE 값을 재 계산해준다.
      	 * <br><b>Example :</b>
      	 * <pre>
      	 *      calcSheetFromChangingLod(sheetObjects[0]);
      	 * </pre>
      	 * @param {object} sheetObj 필수, sheet Object
      	 * @param {int} row 필수, 변경된 row index
      	 * @return 없음
      	 */                
       function calcSheetFromChangingLod(sheetObj){

    	    //Estimate
	       	var COL_RMN_LOD ="prs_rmn_lod_qty";
	       	var COL_RMN_ORI_LOD ="ori_prs_rmn_lod_qty";    	 
	       	var COL_RMN_SHARE = "rmn_share";       	

	       	//SUM
	       	var COL_SUM_LOD ="prs_sum_lod_qty";
	       	var COL_SUM_SHARE = "sum_share";      
	       	
	       	
	       	 

	       
	      
	       	/**  Sub-Total, Total에 대해 Load, Cmpb, CM 값을 재 계산해 준다.      */
	       	calcTotalValues(sheetObj);
	       	
	       	//SUM의 Share를 계산한다.
	       	calcAllShareData(sheetObj,COL_SUM_LOD,COL_SUM_SHARE);
	    	calcAllShareData(sheetObj,COL_RMN_LOD,COL_RMN_SHARE);
	       	calcAllRowStatus(sheetObj,COL_RMN_LOD,COL_RMN_ORI_LOD);
       }
      	 
  	 /** 
  	  * sub-total, total의 값을 재 계산한다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      calcTotalValues(sheetObj)
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {string} COL_LOD 필수, 계산에 사용할 load column name
	 * @param {string} COL_SHARE 필수, 변경시킬 share column name
	 * @return 없음
	 */         
    function calcTotalValues(sheetObj,COL_LOD,COL_SHARE){

    	var tot_lod_qty = 0;
    	var sub_lod_qty = 0;
    	
    	var tot_cm = 0;
    	var sub_cm = 0;
    	var tot_op = 0;
    	var sub_op = 0;
    	
    	var lod = 0;
    	var op = 0;
    	var cm = 0;
    	var gid = "";
    	var last_row = sheetObj.LastRow;
	    for(var i = sheetObj.HeaderRows ; i <= last_row ; i++ ){
	    	gid = sheetObj.CellValue(i,"gid") ;
	    	if(gid == "1" ){ //sub-total
		    	sheetObj.CellValue2(i,"prs_rmn_lod_qty") = sub_lod_qty;
	    		sheetObj.CellValue2(i,"prs_rmn_respb_cmpb_amt") = sub_cm / sub_lod_qty;
	    		sheetObj.CellValue2(i,"prs_rmn_respb_opb_amt") = sub_op / sub_lod_qty;

	    		
		    	sub_lod_qty = 0;
		    	sub_cm = 0;
		    	sub_op = 0;
	    	}else if(gid == "3" ){ //total
	    		sheetObj.CellValue2(i,"prs_rmn_lod_qty") = tot_lod_qty;
	    		sheetObj.CellValue2(i,"prs_rmn_respb_cmpb_amt") = tot_cm / tot_lod_qty;
	    		sheetObj.CellValue2(i,"prs_rmn_respb_opb_amt") = tot_op / tot_lod_qty;
 
	    	}else{
		    	lod =  sheetObj.CellValue(i,"prs_rmn_lod_qty");
		    	if( lod != ""){
		    		tot_lod_qty += eval(lod);
		    		sub_lod_qty += eval(lod);
		    	}
		    	
		    	cm =  sheetObj.CellValue(i,"rmn_cm");
		    	if( cm != ""){
		    		tot_cm += eval(cm);
		    		sub_cm += eval(cm);
		    	}
		    	
		    	op =  sheetObj.CellValue(i,"rmn_op");
		    	if( op != ""){
		    		tot_op += eval(op);
		    		sub_op += eval(op);
		    	}
	    	}
	    	 
	    }
    }      	 
      	 
    
     /** 
     * Data field의 데이터가 변경 됨에 따라<BR>
     * SUM CULUMN을 재 계산해준다 
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *      calcBottomShare(sheetObjects[0],COL_SHARE,COL_LOD);
 	 * </pre>
 	 * @param {object} sheetObj 필수, sheet Object
 	 * @param {string} COL_SHARE 필수, 변경시킬 share column name
 	 * @param {string} COL_SHARE 필수, 판단근거 load column name
 	 * @return 없음
 	 */          	 
   function calcBottomShare(sheetObj,COL_SHARE,COL_LOD){
 		 
 		 
 		var vl = sheetObj.SumText(0,COL_LOD);
 		if( vl == 0 || vl == ""){
 			sheetObj.SumText(0,COL_SHARE) = "0.00%";
 		}else{
 			sheetObj.SumText(0,COL_SHARE) = "100.00%";
 		}
   }    
   
   
       
     /** 
     * Sum Column Cell 에 arrCols의 Cell의 값을 이용해 CMPB,OPB를 구해서 넣어준다
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *      calcOpbCmbpFromLoadAndOpCm(sheetObj,row,COL_LOD,COL_CMOP,COL_CMOPB)
   	 * </pre>
   	 * @param {object} sheetObj 필수, sheet Object
   	 * @param {int} row 필수, 변경할 row index
   	 * @param {string} COL_LOD 필수, 계산에 사용할 load column name
   	 * @param {string} COL_CMOP 필수, 계산에 사용할 CM,OP column name
   	 * @param {string} COL_CMOPB 필수, 계산된 OPB,CMPB 값을 넣을 cell의 column name
   	 * @return 없음
   	 */              
       function calcOpbCmbpFromLoadAndOpCm(sheetObj,row,COL_LOD,COL_CMOP,COL_CMOPB){
    	   var lod_qty =  eval(sheetObj.CellValue(row,COL_LOD));
    	   var cmop_amt =  eval(sheetObj.CellValue(row,COL_CMOP));    	   
    	   sheetObj.CellValue2(row,COL_CMOPB) = cmop_amt / lod_qty;
       }
    /** 
     * SUM ROW에 있는 CMPB, OPB 값을 계산해서 CELL에 넣어 준다.
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *      calcBottomCmpbOpb(sheetObj,COL_LOD,COL_CM,COL_CMPB)
   	 * </pre>
   	 * @param {object} sheetObj 필수, sheet Object
   	 * @param {string} COL_LOD 필수, 계산에 사용할 load column name
   	 * @param {string} COL_CM 필수, 변경시킬 CM,OP column name
   	 * @param {string} COL_CMPB 필수, 계산에 사용할 CMPB,OPB column name
   	 * @return 없음
   	 */  
       function calcBottomCmpbOpb(sheetObj,COL_LOD,COL_CM,COL_CMPB){
      	   var lod_qty =  eval(sheetObj.SumValue(0,COL_LOD));
      	   var cm_amt =  eval(sheetObj.SumValue(0,COL_CM));
      	   var rslt = 0;
      	   if( lod_qty == 0 ){
      		   rslt = 0
      	   }else{
      		   rslt = cm_amt / lod_qty;
      	   }
      	   sheetObj.SumValue(0,COL_CMPB) = rslt;
         }       
       
    /** 
     * Sum Column Cell 에 arrCols의 Cell의 값을 더해서 넣어 준다.
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *      calcSumCellData(sheetObj,row,arrCols,sumCol
   	 * </pre>
   	 * @param {object} sheetObj 필수, sheet Object
   	 * @param {int} row 필수, 변경할 row index
   	 * @param {Array} arrCols 필수, 계산에 사용할 컬럼 LIST
   	 * @param {string} sumCol 필수, 합계된 값을 넣을 cell의 column name
   	 * @return 없음
   	 */           
       function calcSumCellData(sheetObj,row,arrCols,sumCol){
    	   var sumValue = 0;
    	   for(var i = 0 ; i < arrCols.length ; i++){
    		   sumValue = sumValue+ eval(ComPriNvl(sheetObj.CellValue(row,arrCols[i]),"0"));
    	   }
    	   sheetObj.CellValue2(row,sumCol) = sumValue;
       }
       
    /** 
     * Load가 변경 되지 않았다면 ibflag값을 R 상태로 되돌린다.<BR>
     *  
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *      calcAllRowStatus(sheetObjects[0],COL_LOD,COL_ORI_LOD);
   	 * </pre>
   	 * @param {object} sheetObj 필수, sheet Object
   	 * @param {string} COL_LOD 필수, 사용자가 변경시킬수 있는 load column name
   	 * @param {string} COL_ORI_LOD 필수, 처음 조회된 load column name
   	 * @return 없음
   	 */  
       function calcAllRowStatus(sheetObj,COL_LOD,COL_ORI_LOD){
       	var last_row = sheetObj.LastRow;
       	for(var i = sheetObj.HeaderRows ; i < last_row ; i++ ){
       		if( sheetObj.CellValue(i,COL_LOD) ==  sheetObj.CellValue(i,COL_ORI_LOD) && sheetObj.RowStatus(i) != "R"){
       			sheetObj.RowStatus(i) = "R";
       		}
       	}
       }
       
    /** 
     * 모든 Share값을 변경 시켜준다.
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *      calcAllShareData(sheetObj,COL_LOD,COL_SHARE)
   	 * </pre>
   	 * @param {object} sheetObj 필수, sheet Object
   	 * @param {string} COL_LOD 필수, 계산에 사용할 load column name
   	 * @param {string} COL_SHARE 필수, 변경시킬 share column name
   	 * @return 없음
   	 */         
       function calcAllShareData(sheetObj,COL_LOD,COL_SHARE){

	       	var tot_lod_qty = sheetObj.CellValue(sheetObj.LastRow,COL_LOD);
	       	var last_row = sheetObj.LastRow;
	       	var sVal = "0";
	       	for(var i = sheetObj.HeaderRows ; i <= last_row ; i++ ){
 	       		if( tot_lod_qty == 0 ){
	       			sVal = "0";
	       		}else{
	       			sVal = String((ComRound(sheetObj.CellValue(i,COL_LOD) / tot_lod_qty*100  , 2) )) ;
	       		}
	       		
	            
	            var pos = sVal.lastIndexOf(".");
	            if(pos < 0 ){
	            	sVal = sVal+".00";
	            }else{
	            	if( sVal.substring(pos+1).length == 1 ){
	            		sVal = sVal+"0"
	            	}
	            }
	       		sheetObj.CellValue2(i,COL_SHARE) = sVal  +"%";
	       	}
       }
       
       /** 
        * CM값을 계산해서 CELL에 넣어 준다.
      	 * <br><b>Example :</b>
      	 * <pre>
      	 *      calcCmData(sheetObj,row,COL_LOD,COL_CM,COL_CMPB)
      	 * </pre>
      	 * @param {object} sheetObj 필수, sheet Object
      	 * @param {int} row 필수, 변경할 row index
      	 * @param {string} COL_LOD 필수, 계산에 사용할 load column name
      	 * @param {string} COL_CM 필수, 변경시킬 CM column name
      	 * @param {string} COL_CMPB 필수, 계산에 사용할 CMPB column name
      	 * @return 없음
      	 */          
       function calcCmData(sheetObj,row,COL_LOD,COL_CM,COL_CMPB){

       	var lod_qty = sheetObj.CellValue(row,COL_LOD);
       	var cmpb = sheetObj.CellValue(row,COL_CMPB);
       	sheetObj.CellValue2(row,COL_CM) = lod_qty * cmpb;
       }
       
    /** 
     * OP 값을 계산해서 CELL에 넣어 준다.
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *      calcOpData(sheetObj,row,COL_LOD,COL_OP,COL_OPB)
   	 * </pre>
   	 * @param {object} sheetObj 필수, sheet Object
   	 * @param {int} row 필수, 변경할 row index
   	 * @param {string} COL_LOD 필수, 계산에 사용할 load column name
   	 * @param {string} COL_OP 필수, 변경시킬 OP column name
   	 * @param {string} COL_OPB 필수, 계산에 사용할 OPB column name
   	 * @return 없음
   	 */       
       function calcOpData(sheetObj,row,COL_LOD,COL_OP,COL_OPB){
       	var lod_qty = sheetObj.CellValue(row,COL_LOD);
       	var opb = sheetObj.CellValue(row,COL_OPB);
       	sheetObj.CellValue2(row,COL_OP) = lod_qty * opb;
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
     		if( sheetObj.SearchRows != 0){
 
		       	changeTotalCells(sheetObj, "SUB-TOTAL");
		       	changeTotalCells(sheetObj, "TOTAL");
		       	
	     	    //ACTUAL
	 	       	var COL_ACT_LOD ="prs_crnt_lod_qty";
	 	       	var COL_ACT_SHARE = "crnt_share";   
		    	calcAllShareData(sheetObj,COL_ACT_LOD,COL_ACT_SHARE);
		    	
		       	calcSheetFromChangingLod(sheetObj);		       	
     		}
     		changeButtonStatus(sheetObj);
     		
    	}
        /** 
        * sheet의 sub-total, total의 컬럼들을 merge한다.
        * <br><b>Example :</b>
        * <pre>
        * 		 
        *	changeTotalCells(sheetObj,"SUB-TOTAL");
        * </pre>
        * @param {object} sheetObj 필수, sheet Object
        * @param {string} type 필수, 'SUB-TOTAL', 'TOTAL'
        * @param {string} keyList 필수, '|'로 연결된 row list
        * @return 없음
        */   
        function changeTotalCells(sheetObj, type){
        	
        	var row = 0;
 
        	switch(type){
        	case "SUB-TOTAL" :
        		row = sheetObj.FindText("gid","1",0);
            	while(row > 0){
            		
            		sheetObj.RowBackColor(row) = sheetObj.CumulateBackColor;
            		sheetObj.CellEditable(row,"prs_rmn_lod_qty") = false;
            		row = sheetObj.FindText("gid","1",row+1);
            	}
        		break;
        	case "TOTAL" :
        		row = sheetObj.FindText("gid","3",0);
            	while(row > 0){
            		sheetObj.RowBackColor(row) = sheetObj.SumBackColor;
            		sheetObj.CellEditable(row,"prs_rmn_lod_qty") = false;
            		row = sheetObj.FindText("gid","3",row+1);
            	}
        		break;
        	}
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
    	    	  var sText ="";
    	    	  if( sheetObj.CellText(row,"gid") != "1" ){
    	    		  sText = sheetObj.CellText(row,"prc_cmdt_def_nm");
    	    	  }
    	    	  sheetObj.ToolTipText(row,col) = sText;
    	      }else if( colName == "cust_cd" ){
    	    	  var sText ="";
    	    	  if( sheetObj.CellText(row,"gid") != "1" ){
    	    		  sText = sheetObj.CellText(row,"cust_nm");
    	    	  }
      	    	  sheetObj.ToolTipText(row,col) = sText;    	    	  
    	      }else if( colName == "ori_rout_pnt_loc_def_cd"
    	      		|| colName == "ori_rout_via_port_def_cd"
    	      		|| colName == "dst_rout_via_port_def_cd"
    	      		|| colName == "dst_rout_pnt_loc_def_cd" ){
    	    	  var sText = sheetObj.CellText(row,col);
    	    	  sheetObj.ToolTipText(row,col) = sText;
    	      }

    	}
   	
        /** 
         * sheet의 내용이 변경 되었을때 자동 호출됨 
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         * @param {object} sheetObj 필수, sheet Object
         * @param {int} row 필수, 변경된 row index
         * @param {string} value 필수, 변경된 cell의 값
         * @return 없음
         */  
      	function sheet1_OnChange(sheetObj,row,col,value){
   		var colname = sheetObj.ColSaveName(col);  
      		if( colname == "prs_rmn_lod_qty" ){
      			//cmpb값을 조회한다.
      			searchCMPBAndOPBData(sheetObj,row);
      			//변경된 lod_qty에 따라 cm, share 값을 변경해 준다.
      			calcSheetFromChangingLod(sheetObj);
      		}
      		changeButtonStatus(sheetObj);
      	}
         
         /** 
         * sheet의 선택 row의 cmpb, opb값을 조회한다.  
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         * @param {object} sheetObj 필수, sheet Object
         * @param {int} row 필수, 변경된 row index
         * @return 없음
         */  
      	function searchCMPBAndOPBData(sheetObj,row ){
      		var formObj = document.form;
      		
      		if( sheetObj.CellValue(row,"flg_search_cmpb") != "Y" && ( sheetObj.CellValue(row,"prs_rmn_respb_cmpb_amt") == "" || sheetObj.CellValue(row,"prs_rmn_respb_opb_amt") == "" ) ){
		        formObj.f_cmd.value = SEARCH01;
				var param = FormQueryString(formObj);
				
				param += "&cmdt_hdr_seq=" +sheetObj.CellValue(row,"cmdt_hdr_seq");
				param += "&rout_seq=" +sheetObj.CellValue(row,"rout_seq");
				var sXml = sheetObj.GetSearchXml("ESM_PRI_6049GS.do", param );
				var cmpbVl = ComGetEtcData(sXml,"PRS_RMN_RESPB_CMPB_AMT");
				var opbVl = ComGetEtcData(sXml,"PRS_RMN_RESPB_OPB_AMT");   
			    sheetObj.CellValue2(row,"flg_search_cmpb") = "Y";
			    if( sheetObj.CellValue(row,"prs_rmn_respb_cmpb_amt") == "" ){
			    	sheetObj.CellValue2(row,"prs_rmn_respb_cmpb_amt") = cmpbVl;
			    }
			    if( sheetObj.CellValue(row,"prs_rmn_respb_opb_amt") == "" ){
			    	sheetObj.CellValue2(row,"prs_rmn_respb_opb_amt") = opbVl;
			    }
      		}
   	
      	}           
         
	     var SAVE_STATE = "";
	     /** 
	     * sheet를 이용해 Save를 했을경우 Save 완료후 자동 호출됨 
	     * <br><b>Example :</b>
	     * <pre>
	     * </pre>
	     * @param {object} sheetObj 필수, sheet Object
	     * @param {String} ErrMsg 필수, sheet의 결과 메시지
	     * @return 없음
	     */     
	    function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
	     	 
	  		if( SAVE_STATE != "S" ){
	  			errMsg = ErrMsg;
	  			alert(errMsg);
	  		}else{
	  			window.returnValue="SUCCESS";
	  			doActionIBSheet(sheetObj,document.form,IBSEARCH);
	  		}
	  		changeButtonStatus(sheetObj);
	  	}  	
	  			         
      
	/* 개발자 작업  끝 */