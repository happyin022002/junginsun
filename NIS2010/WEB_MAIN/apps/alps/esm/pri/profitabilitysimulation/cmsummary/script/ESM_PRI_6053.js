/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6053.js
*@FileTitle : CM/OP Summary And Simulation - Revenue Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.22 송민석
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
     * @class ESM_PRI_6053 : ESM_PRI_6053 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6053() {
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
 var TITLE_TEXT = new Array();
 TITLE_TEXT["C"] = "CM Summary & Simulation – G.Revenue Detail (Contract Approval)";
 TITLE_TEXT["O"] = "OP Summary & Simulation – G.Revenue Detail (Contract Approval)";
 var BACKEND_JOB_ID  = "";
 var TIMER_ID = "";
 
 
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
 
 				case "btn1_Down_Excel":
 					var msgStr = ComGetMsg("PRI03002");

 			    	var rtn = ComPriShowDialogExcel(sheetObject1,msgStr );
 
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

     }
      
  /** 
   * SHEET가 로딩이 완료 된후 자동 호출됨
   *  
   * <pre>
   * </pre>
   * @param {object} sheetObj 필수, sheet Object
   * @return 없음
   */       
     function sheet1_OnLoadFinish(sheetObj){
	   	//초기 파라메터 set
	   	initParams();
	   	//Profit Level에 따른 제목변경
	   	changeTitle(document.form.frm_profit_level.value);
	   	//조회
	   	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
     }
   	      
  /**  
   *  CM/OP 구분 Code에 따라 화면의 title을 변경한다. 
   *  
   * <br><b>Example :</b>
   * <pre>
   * 		changeTitle(code);
   * </pre>
   * 
   * @param {string} code 필수, CM/OP 구분 Code 
   * @return 없음
   */  
    function changeTitle(code){
   		document.getElementById("TITLE_TEXT").innerText = TITLE_TEXT[code];
    }
    	
      
 	
	  /**  
	   * 팝업이 오픈될때 메인화면으로 부터 받은 초기 파라메터를<BR> 
	   * 저장해 놓는다.
	   *  
	   * <br><b>Example :</b>
	   * <pre>
	   *   initParams()
	   * </pre>
	   *
	   * @return 없음
	   */        
 	function initParams(){
 		var formObj = document.form;
 		var openerForm = opener.document.form

 		formObj.frm_customer_type.value =	openerForm.searched_customer_type.value;        
 		formObj.frm_prop_apro_ofc_cd.value = 	openerForm.searched_prop_apro_ofc_cd.value;     
 		formObj.frm_contract_type.value = 	openerForm.searched_contract_type.value;        
 		formObj.frm_ctrt_eff_yr.value = 	openerForm.searched_ctrt_eff_yr.value;          
 		formObj.frm_ctrt_eff_wk.value = 	openerForm.searched_ctrt_eff_wk.value;          
 		formObj.frm_ctrt_exp_yr.value = 	openerForm.searched_ctrt_exp_yr.value;          
 		formObj.frm_ctrt_exp_wk.value = 	openerForm.searched_ctrt_exp_wk.value;          
 		formObj.frm_smr_eff_yr.value = 		openerForm.searched_smr_eff_yr.value;           
 		formObj.frm_smr_eff_wk.value = 		openerForm.searched_smr_eff_wk.value;           
 		formObj.frm_smr_exp_yr.value = 		openerForm.searched_smr_exp_yr.value;           
 		formObj.frm_smr_exp_wk.value = 		openerForm.searched_smr_exp_wk.value;           
 		formObj.frm_rfrc_eff_yr.value = 	openerForm.searched_rfrc_eff_yr.value;          
 		formObj.frm_rfrc_eff_wk.value = 	openerForm.searched_rfrc_eff_wk.value;          
 		formObj.frm_rfrc_exp_yr.value = 	openerForm.searched_rfrc_exp_yr.value;          
 		formObj.frm_rfrc_exp_wk.value = 	openerForm.searched_rfrc_exp_wk.value;          
 		formObj.frm_prop_ofc_cd.value = 	openerForm.searched_prop_ofc_cd.value;          
 		formObj.frm_prop_srep_cd.value = 	openerForm.searched_prop_srep_cd.value;         
 		formObj.frm_prop_srep_nm.value = 	openerForm.searched_prop_srep_nm.value;         
 		formObj.frm_cust_list.value = 		openerForm.searched_cust_list.value;            
 		formObj.frm_trd_cd.value = 		openerForm.searched_trd_cd.value;               
 		formObj.frm_dir_cd.value = 		openerForm.searched_dir_cd.value;               
 		formObj.frm_sub_trd_cd.value = 		openerForm.searched_sub_trd_cd.value;           
 		formObj.frm_rlane_cd.value = 		openerForm.searched_rlane_cd.value;             
 		formObj.frm_crg_tp_dry.value = 		openerForm.searched_crg_tp_dry.value;           
 		formObj.frm_crg_tp_dg.value = 		openerForm.searched_crg_tp_dg.value;            
 		formObj.frm_crg_tp_rf.value = 		openerForm.searched_crg_tp_rf.value;            
 		formObj.frm_crg_tp_ak.value = 		openerForm.searched_crg_tp_ak.value;            
 		formObj.frm_crg_tp_bb.value = 		openerForm.searched_crg_tp_bb.value;  
 		
 		formObj.frm_ori_rout_cd.value = 		openerForm.searched_ori_rout_cd.value;  
 		formObj.frm_ori_loc_tp.value = 		openerForm.searched_ori_loc_tp.value;  
 		formObj.frm_dest_rout_cd.value = 		openerForm.searched_dest_rout_cd.value;  
 		formObj.frm_dest_loc_tp.value = 		openerForm.searched_dest_loc_tp.value;  
 		formObj.frm_profit_level.value = openerForm.frm_profit_level.Code
 		
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
 			case "sheet2":      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 242;
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

                     var HeadTitle1  = "|Seq.|Contract|Request\nOffice|Contract No.|Customer Name|MQC\n(Target MVC)|Load|Load|Load|Gross Revenue|Gross Revenue|Gross Revenue|OFT|OFT|OFT|BUC|BUC|BUC|PSC|PSC|PSC|IFC|IFC|IFC|Others|Others|Others";
 					var HeadTitle2  = "|Seq.|Contract|Request\nOffice|Contract No.|Customer Name|MQC\n(Target MVC)|Actual|Estimate|Sum|Actual|Estimate|Sum|Actual|Estimate|Sum|Actual|Estimate|Sum|Actual|Estimate|Sum|Actual|Estimate|Sum|Actual|Estimate|Sum|";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 6, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,   true,   	"ibflag");

					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"contract_nm",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    			60,   	daLeft,  	true,		"prop_ofc_cd",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"a_sc_no",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			140,   	daLeft,  	true,		"cust_nm",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	true,		"mqc_qty",	false,  "",			dfNullFloat,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"a1_load",	false,  "",			dfNullFloat,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"e1_load",	false,  "",			dfNullFloat,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		60,		daRight,	false,		"sum_load",	false,	"",			dfNullFloat,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"a1_g_rev",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"e1_g_rev",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		60,		daRight,	false,		"sum_g_rev",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"a1_oft_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"e1_oft_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		60,		daRight,	false,		"sum_oft_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"a1_buc_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"e1_buc_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		60,		daRight,	false,		"sum_buc_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"a1_ifc_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"e1_ifc_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		60,		daRight,	false,		"sum_ifc_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"a1_psc_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"e1_psc_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		60,		daRight,	false,		"sum_psc_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"a1_others_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,		"e1_others_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 					InitDataProperty(0, cnt++ , dtAutoSum,		60,		daRight,	false,		"sum_others_surcharge",	false,  "",			dfNullInteger,2,	false,		true);
 																				
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
 				switch (sheetObj.id){
 					case "sheet1":
 					case "sheet2":
 		   		        formObj.f_cmd.value = SEARCH;
 		   		        var params = FormQueryString(formObj) ;
 		   		        
 		   		        
 			             	
 						ComOpenWait(true);		
 						sheetObj.RemoveAll();
 						var sXml = sheetObj.GetSearchXml("ESM_PRI_6053GS.do", params );
 						var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
 						if (backendJobKey.length > 0) {
 							BACKEND_JOB_ID = backendJobKey;
 							sheetObj.RequestTimeOut = 10000;
 							TIMER_ID = setInterval(getBackEndJobStatus, 3000); // 3초 후에
 																			// getBackEndJobStatus함수
 																			// 실행 - 재귀호출
 						}else{
 							ComOpenWait(false);

 						}

 						
 						
 						break;
 				}
 				break;

 			 case IBSAVE:        //저장
                 break;

 			case IBINSERT:      // 입력
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
     	with(sheetObj){

 			/*토탈 라인 합쳐지기. */
 			var row = LastRow;
 			var startCol = SaveNameCol("Seq");
 			var endCol = SaveNameCol("Route");
 					
 			for (var j = startCol; j <= endCol; j ++){
 				SumText(0, j) = "Total";
 			}
 			RowMerge(row) = true;
     	}
     }
      

      /** 
       * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
       * 
       * <br><b>Example :</b>
       * <pre>
       *      sheet6LoadEnd(sheetObj)
       * </pre>
       * 
       * 
       * @return 없음
       */              
      function getBackEndJobStatus() {
      	var form = document.form;	
  		var sheetObj = sheetObjects[1];
      	form.f_cmd.value = SEARCH03;
      	var sXml = sheetObj.GetSearchXml("ESM_PRI_6053GS.do", "f_cmd="+SEARCH03+"&backendjob_key="+BACKEND_JOB_ID);
      	var jobStatus = ComGetEtcData(sXml, "jb_sts_flg");
      	if (jobStatus == "3") {
      		getBackEndJobLoadFile();
      		clearInterval(TIMER_ID);
      	} else if (jobStatus == "4") { // BackEndJob을 실패 하였습니다.
      		ComShowCodeMessage("PRI00338"); //msgs['PRI00338'] = 'Failed to download. Please try again.';
      		clearInterval(TIMER_ID);
      		ComOpenWait(false);	
      	} else if (jobStatus == "5") {
      		ComShowCodeMessage("PRI00339"); //msgs['PRI00339'] = 'Data was downloaded successfully.';
      		clearInterval(TIMER_ID);
      		ComOpenWait(false);	
      	}
      }
      /** 
      * BackEndJob이 완료 된후 그 결과를 sheet에 loading한다.<BR>
      * 
      * <br><b>Example :</b>
      * <pre>
      *      getBackEndJobLoadFile()
      * </pre>
      * 
      * 
      * @return 없음
      */          
      function getBackEndJobLoadFile() {
  		var form = document.form;
  		var sheetObj = sheetObjects[0];
  		form.f_cmd.value = SEARCHLIST;
  		
  		var sXml = sheetObj.GetSearchXml("ESM_PRI_6053GS.do", "f_cmd="+SEARCHLIST+"&backendjob_key="+BACKEND_JOB_ID);
  		sheetObj.LoadSearchXml(sXml);	
  		ComOpenWait(false);		

      }      
	/* 개발자 작업  끝 */