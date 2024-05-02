/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6075.js
*@FileTitle : SC CM/OP View All
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.17 송민석
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
     * @class ESM_PRI_6075 : ESM_PRI_6075 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6075() {
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
 var REMARK_TEXT_OP = "» CM= CMPB * PFMC , OP= OPB * PFMC\n» Previous: Figures for Previous S/C of the same customer\n» Estimate: Estimated Figures for current S/C";
 var REMARK_TEXT_CM = "» CM= CMPB * PFMC\n» Previous: Figures for Previous S/C of the same customer\n» Estimate: Estimated Figures for current S/C";
 var TITLE_TEXT_CM = "S/C Quotation CM View All";
 var TITLE_TEXT_OP = "S/C Quotation OP View All";
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
         		case "rate_type" :
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
   		var qttn_sts_cd = formObj.qttn_sts_cd.value;
   		var auth = formObj.auth_code.value;
   		
		
		//상태가 proposed 인 경우가 아니면
   		if(qttn_sts_cd == "N" ){
   			if(sheetObj.RowCount > 0 && sheetObj.IsDataModified == true   ){   		
	   			if(auth == "S" || auth == "A") {
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
    	 formObj.rate_type[0].checked = true;
    	 if( formObj.cost_tp.value == "O" ){
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
     function initVisibleColSheet(sheetObj,isShow){
   		 sheetObj.ColHidden("prs_pre_respb_opb_amt") = !isShow;
   		 sheetObj.ColHidden("pre_op") = !isShow;
   		 sheetObj.ColHidden("prs_estm_respb_opb_amt") = !isShow;
   		 sheetObj.ColHidden("estm_op") = !isShow;

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
                     style.height = 322;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "|Seq.|Rate Type|Rate Type|CMDT|Route|Route|Route|Route|Previous|Previous|Previous|Previous|Previous|Previous|Estimate|Estimate|Estimate|Estimate|Estimate|Estimate|qttn_no|qttn_ver_no|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|prs_rat_ut_cd|ori_prs_estm_lod_qty";
 					 var HeadTitle2 = "|Seq.|G/Rate|S/Rate |CMDT|Origin|O.VIA|D.VIA|Dest.|PFMC|Share|CMPB|CM|OPB|OP|PFMC|Share|CMPB|CM|OPB|OP|qttn_no|qttn_ver_no|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|prs_rat_ut_cd|ori_prs_estm_lod_qty";
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
 					InitDataProperty(0, cnt++ , dtCheckBox,    	50,   	daCenter,  	true,		"g_rate_type",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtCheckBox,    	50,   	daCenter,  	true,		"s_rate_type",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"prc_cmdt_def_cd",   			false,          "",      dfNone,      		0,			false,       true);
 					InitDataProperty(0, cnt++ , dtData,    			75,   	daLeft,  	true,		"ori_rout_pnt_loc_def_cd",   			false,          "",      dfNone,      		0,			false,       true);
 					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"ori_rout_via_port_def_cd",   			false,          "",      dfNone,      		0,			false,       true);
 					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"dst_rout_via_port_def_cd",   			false,          "",      dfNone,      		0,			false,       true);
 					InitDataProperty(0, cnt++ , dtData,    			75,   	daLeft,  	true,		"dst_rout_pnt_loc_def_cd",   			false,          "",      dfNone,      		0,			false,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	true,		"prs_pre_lod_qty",   			false,          "",      dfNullFloat,      	1,			false,       true);
 					InitDataProperty(0, cnt++ , dtData,    		50,   	daRight,  	true,		"pre_share",   			false,          "",      dfNone,      	2,			false,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		55,   	daRight,  	true,		"prs_pre_respb_cmpb_amt",   			false,          "",      dfNullFloat,      	2,			false,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		85,   	daRight,  	true,		"pre_cm",   			false,          "",      dfNullInteger,      	2,			false,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		55,   	daRight,  	true,		"prs_pre_respb_opb_amt",   			false,          "",      dfNullFloat,      	2,			false,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		85,   	daRight,  	true,		"pre_op",   			false,          "",      dfNullInteger,      	2,			false,       true);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	true,		"prs_estm_lod_qty",   			false,          "",      dfNullFloat,      	1,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    		50,   	daRight,  	true,		"estm_share",   			false,          "",      dfNone,      	2,			false,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		55,   	daRight,  	true,		"prs_estm_respb_cmpb_amt",   			false,          "",      dfNullFloat,      	2,			false,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		85,   	daRight,  	true,		"estm_cm",   			false,          "",      dfNullInteger,      	2,			false,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		55,   	daRight,  	true,		"prs_estm_respb_opb_amt",   			false,          "",      dfNullFloat,      	2,			false,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		85,   	daRight,  	true,		"estm_op",   			false,          "",      dfNullInteger,      	2,			false,       true);
 		
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"qttn_no",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"qttn_ver_no",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"gen_spcl_rt_tp_cd",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"cmdt_hdr_seq",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"rout_seq",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"prs_rat_ut_cd",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"ori_prs_estm_lod_qty",   			false,          "",      dfNullFloat,      		1,			false,      false);
 					
 					CountPosition = 0;
 					

 					

 					//풍선도움말
 					ToolTipOption="balloon:true;width:320;icon:1";
 					FrozenCols = 9;
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
		        sheetObj.DoSearch("ESM_PRI_6075GS.do", FormQueryString(formObj)  );
		        ComOpenWait(false);
	            break;


 			case IBSAVE:        //저장
 				ComOpenWait(true);
 				if(validateForm(sheetObj,formObj,sAction))
 				formObj.f_cmd.value = MULTI;
	 			
				var sXml = sheetObj.GetSaveXml("ESM_PRI_6075GS.do", sheetObj.GetSaveString() + "&" + FormQueryString(formObj)  );
				
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
  	 *      calcSheetFromChangingLod(sheetObjects[0],row);
  	 * </pre>
  	 * @param {object} sheetObj 필수, sheet Object
  	 * @param {int} row 필수, 변경된 row index
  	 * @return 없음
  	 */           
    function calcSheetFromChangingLod(sheetObj,row){
    	
    	var COL_LOD ="prs_estm_lod_qty";
    	var COL_ORI_LOD ="ori_prs_estm_lod_qty";
    	var COL_SHARE = "estm_share";
    	var COL_CM = "estm_cm";
    	var COL_CMPB = "prs_estm_respb_cmpb_amt";    	
    	var COL_OP = "estm_op";
    	var COL_OPB = "prs_estm_respb_opb_amt";    	
    	var COL_PRE_SHARE = "pre_share";
    	var COL_PRE_OPB = "prs_pre_respb_opb_amt";    
    	var COL_PRE_OP = "pre_op";
    	var COL_PRE_LOD ="prs_pre_lod_qty";
    	var COL_PRE_CM = "pre_cm";
    	var COL_PRE_CMPB = "prs_pre_respb_cmpb_amt"; 
    	sheetObj.RedrawSum = false;
    	calcAllShareData(sheetObj,COL_LOD,COL_SHARE);
    	calcCmData(sheetObj,row,COL_LOD,COL_CM,COL_CMPB);
    	calcOpData(sheetObj,row,COL_LOD,COL_OP,COL_OPB);
    	
    	sheetObj.RedrawSum = true;
    	
       	//AutoSum 된 그리드 아래쪽 cmbp와 opb의 값을 재 계산해준다. -- 
       	calcBottomCmpbOpb(sheetObj,COL_LOD,COL_CM,COL_CMPB);
       	calcBottomCmpbOpb(sheetObj,COL_LOD,COL_OP,COL_OPB);	
       	calcBottomCmpbOpb(sheetObj,COL_PRE_LOD,COL_PRE_OP,COL_PRE_OPB);    
       	calcBottomCmpbOpb(sheetObj,COL_PRE_LOD,COL_PRE_CM,COL_PRE_CMPB);	
       	
       	
       	calcBottomShare(sheetObj,COL_SHARE,COL_LOD);
       	calcBottomShare(sheetObj,COL_PRE_SHARE,COL_PRE_LOD);
       	
    	calcAllRowStatus(sheetObj,COL_LOD,COL_ORI_LOD);
    	
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
       	var sVal = 0;
       	for(var i = sheetObj.HeaderRows ; i < last_row ; i++ ){
       		
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
    * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {String} ErrMsg 필수, sheet의 결과 메시지
    * @return 없음
    */       
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		//Total 자리이동..
 		sheetObj.SumText(0,1)="";
 		sheetObj.SumText(0,4)="Total";
 		
 		if( sheetObj.SearchRows != 0){
		    //Estimate
	 		
	    	var COL_ESTM_LOD ="prs_estm_lod_qty";
	    	var COL_ESTM_CM = "estm_cm";
	    	var COL_ESTM_CMPB = "prs_estm_respb_cmpb_amt";    	
	    	var COL_ESTM_OP = "estm_op";
	    	var COL_ESTM_OPB = "prs_estm_respb_opb_amt";    	
	    	var COL_ESTM_SHARE = "estm_share";
	 
	    	var COL_PRE_LOD ="prs_pre_lod_qty";
	    	var COL_PRE_CM = "pre_cm";
	    	var COL_PRE_CMPB = "prs_pre_respb_cmpb_amt";    	
	    	var COL_PRE_OP = "pre_op";
	    	var COL_PRE_OPB = "prs_pre_respb_opb_amt";    
	    	var COL_PRE_SHARE = "pre_share";
	    	
	       	//AutoSum 된 그리드 아래쪽 cmbp와 opb의 값을 재 계산해준다. -- ACTUAL
	    	
	       	calcBottomCmpbOpb(sheetObj,COL_ESTM_LOD,COL_ESTM_CM,COL_ESTM_CMPB);
	       	calcBottomCmpbOpb(sheetObj,COL_PRE_LOD,COL_PRE_CM,COL_PRE_CMPB);	       	
	       	calcBottomCmpbOpb(sheetObj,COL_ESTM_LOD,COL_ESTM_OP,COL_ESTM_OPB);	       	
	       	calcBottomCmpbOpb(sheetObj,COL_PRE_LOD,COL_PRE_OP,COL_PRE_OPB);    
	       	
	       	calcBottomShare(sheetObj,COL_ESTM_SHARE,COL_ESTM_LOD);
	       	calcBottomShare(sheetObj,COL_PRE_SHARE,COL_PRE_LOD);
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
 	      if( colName == "prc_cmdt_def_cd"
 	   			|| colName == "ori_rout_pnt_loc_def_cd"
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
    * @param {int} col 필수, 변경된 col index
    * @param {string} value 필수, 변경된 cell의 값
    * @return 없음
    */   
   	function sheet1_OnChange(sheetObj,row,col,value){
		var colname = sheetObj.ColSaveName(col);  
   		if( colname == "prs_estm_lod_qty" ){
   			//변경된 lod_qty에 따라 cm, share 값을 변경해 준다.
   			calcSheetFromChangingLod(sheetObj,row);
   		}
   		changeButtonStatus(sheetObj);
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
   		changeButtonStatus(sheetObjects[0]);
 		if( SAVE_STATE != "S" ){
 			errMsg = ErrMsg;
 			alert(errMsg);
 		}else{
 			window.returnValue="SUCCESS";
 			doActionIBSheet(sheetObj,document.form,IBSEARCH);
 		}
 	}  	
 	
 				

	/* 개발자 작업  끝 */