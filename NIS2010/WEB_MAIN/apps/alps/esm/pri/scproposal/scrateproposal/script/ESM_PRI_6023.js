/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6023.js
*@FileTitle : PRS- Cost Detail - Pre CM/OP Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.07 송민석
* 1.0 Creation
=========================================================
* History
* 2013-08-05 송호진 [CHM-201325819] 7월 PRS 배치작업 요청 - Pre CM/OP Simulation 조회 시 BackEndJob 조회 방식 적용 
* Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
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
     * @class ESM_PRI_6023 : ESM_PRI_6023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6023() {
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
 var comboObjects = new Array();
 var comboCnt = 0;
 var total_index = 8;//Total을 구하기 위해 계정이 시작하는 Row

 
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
 		 var sheetObject2 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

                                           
            switch(srcName) {

 				case "btn2_Retrieve":
     				formObject.f_pc_creation.value = "N";
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                     break; 
 				case "btn2_CostDetail":
					doActionIBSheet(sheetObject2,formObject,IBSEARCH);
                     break;                      
 				case "btn1_OK":
	           	 	doActionIBSheet( sheetObjects[2], formObject, IBSAVE);
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
       * IBCombo Object를 배열로 등록
       * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
       * 배열은 소스 상단에 정의
        * <br><b>Example :</b>
        * <pre>
        * </pre>
        *
        * @param  {object}   combo_obj 필수, IBMultiCombo Object
        * @return 없음
        */       
      function setComboObject(combo_obj){
          comboObjects[comboCnt++] = combo_obj;
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
         changeButtonStatus();
         changeOfficeInputStatus();
 		 chageCntrTpSz();
 		 initCombo();
 		 initControl();
     }
       
      
       /** 
        * CM일 경우 Loading Office,Booking Office를 필수입력 모양으로
        * 그외는 option 모양으로 style을 변경시킨다.
        * <br><b>Example :</b>
        * changeOfficeInputStatus()
        * <pre>
        * </pre>
        * 
        * @return 없음
        */        
       function changeOfficeInputStatus(){
    	   var formObj = document.form;
    	   var f_cob_profit_lv = formObj.f_cob_profit_lv.value  
    	   
    	   if( f_cob_profit_lv == "C"){
    		   formObj.f_sls_ofc_cd.setAttribute("className","input");
    		   formObj.f_bkg_ofc_cd.setAttribute("className", "input");
    	   }else{
    		   formObj.f_sls_ofc_cd.setAttribute("className","input1");
        	   formObj.f_bkg_ofc_cd.setAttribute("className", "input1");    		   
    	   }
       }
       
       
       /** 
        *  R2,R4,R5.. 와같이 R로 시작하는 Type Size와 Cargo Type이 DR일경우<BR>
        *  Type Size를 RD2,RD4... 와 같이 code를 변경한다.
        * <br><b>Example :</b>
        * <pre>
        * </pre>
        * 
        * @return 없음
        */        
       function chageCntrTpSz(){
// 2010/03/05 요청사항에 의해 해당 로직을 삭제함
//    	   var formObj = document.form;
//    	   var typeSize = formObj.f_cntr_tpsz_cd.value;
//    	   var cargo = formObj.cargo.value;
//    	   if( cargo == "DR"){
//    		   var v = typeSize.substring(0,1);
//    		   if( v == "R"){
//    			   formObj.tmp_spcl_soc.checked = true;
//    			   formObj.f_spcl_soc.value = "Y";
//    			   //formObj.f_cntr_tpsz_cd.value = "RD" +typeSize.substring(1,2) ;
//    		   }
//    	   }
       }
       
       /** 
        * document에서 일어나는 event들의 listener를 정의 한다.. <BR>
        * 
        *
        * <br><b>Example :</b>
        * <pre>
        * </pre>
        * 
        * @return 없음
        */  
       function initControl() {
          axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
  	    
     }           
      
     /**  
     * Combo에서 필요한 코드를 조회해서 Combo에 Assign한다.
     * 화면에 Setting 해 놓는다.
     *  
     * <br><b>Example :</b>
     * <pre>
     *   initCombo();
     * </pre>
     * 
     * @return 없음
     */          
     function initCombo(){
    	var formObj = document.form;
		formObj.f_cmd.value = SEARCH20;
		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do" , FormQueryString(formObj)+"&cd=CD02070");
		ComPriXml2ComboItem(sXml, formObj.f_r_term, "cd", "nm");    	
		formObj.f_cmd.value = SEARCH20;
		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do" , FormQueryString(formObj)+"&cd=CD02071");
		ComPriXml2ComboItem(sXml, formObj.f_d_term, "cd", "nm");   
		
	   with(formObj.f_r_term){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
		   	ValidChar(2,0);
	   }
	   with(formObj.f_d_term){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
		   	ValidChar(2,0);
	   }
     }

     /**  
     * 화면에서 Key가 눌렸을경우의 이벤트처리
     *  
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * 
     * @return 없음
     */      
  	 function obj_keypress() {
        switch (event.srcElement.dataformat) {
            case "engup":
                ComKeyOnlyAlphabet('upper');
                break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            
            default:
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
         switch(sheetObj.id) {
              case "sheet1":      //sheet1 init
                 with (sheetObj) {

                  SheetWidth = mainTable.clientWidth;//전체 너비 설정
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
                  MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
                  Editable = false; //전체Edit 허용 여부 [선택, Default false]
                  InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                  InitColumnInfo(16, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                  InitHeadMode(true, true, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다

                  var HeadTitle = "SEQ|Constraint\n/Ref.|Rem|Ocean\nFlag|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|T/Time\n(day/HR)" ;
                  var HeadTitle1 = "SEQ|Constraint\n/Ref.|Rem|Ocean\nFlag|POR|Inter Change|POL|T/S Route|POD|Inter Change|DEL|T/Time\n(day/HR)" ;

                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                  InitHeadRow(0, HeadTitle, true);
                  InitHeadRow(1, HeadTitle1, false);

                  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  true,   "",             false,          "",       dfNone,   	0,     false,       false);
                  InitDataProperty(0, cnt++ , dtImage,      50,    daCenter,  true,   "remark_img",   false,          "",       dfNone,   	0,     false,       false);
                  InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,   "remark",       false,          "",       dfNone,   	0,     false,       false);
                  InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   "routFlag",     false,          "",       dfNone,       0,     false,       false);
                  InitDataProperty(0, cnt++ , dtData,       43,    daCenter,  true,   "por",          false,          "",       dfNone,	    0,     false,       false);
                  InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,   "ob_itchg_ctnt",false,          "",       dfNone,   	0,     false,       false);
                  InitDataProperty(0, cnt++ , dtData,       43,    daCenter,  true,   "pol",          false,          "",       dfNone,       0,     false,       false);
                  InitDataProperty(0, cnt++ , dtData,      230,    daCenter,  true,   "ts_route",     false,          "",       dfNone, 	    0,     false,       false);
                  InitDataProperty(0, cnt++ , dtData,       43,    daCenter,  true,   "pod",          false,          "",       dfNone,	    0,     false,       false);
                  InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,   "ib_itchg_ctnt",false,          "",       dfNone,   	0,     false,       false);
                  InitDataProperty(0, cnt++ , dtData,       43,    daCenter,  true,   "del",          false,          "",       dfNone,       0,     false,       false);
                  InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,   "ttl_tztm_hrs", false,          "",       dfUserFormat2,0,     false,       false);
                  //hidden
                  InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,   "pctl_no",      false,          "",       dfNone,       0,     false,       false);
                  InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,   "cnst_seq",     false,          "",       dfNone,       0,     false,       false);
                  InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,   "trnk_lane",    false,          "",       dfNone,       0,     false,       false);
                  InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,   "cnst_rmk",     false,          "",       dfNone,       0,     false,       false);

                  HeadRowHeight = "10" ;
                  InitUserFormat2(0, "ttl_tztm_hrs", "##D ##H" , "D|H"  );
                  CountPosition	= 0 ;
                  
      		    CellBackColor(1,"por") = RgbColor(231,250,249);
      		    CellBackColor(1,"ob_itchg_ctnt") = CellBackColor(1,"por")
      		    CellBackColor(1,"pol") = CellBackColor(1,"por")
      		    CellBackColor(1,"ts_route") = CellBackColor(1,"por")
      		    CellBackColor(1,"pod") = CellBackColor(1,"por")
      		    CellBackColor(1,"ib_itchg_ctnt") = CellBackColor(1,"por")
      		    CellBackColor(1,"del") = CellBackColor(1,"por")
                  ImageList(0) = "/hanjin/img/alps/ico_b.gif" ;
                  ImageList(1) = "/hanjin/img/alps/ico_r.gif" ;

         		    style.height = GetSheetHeight(7) ;
                }
                break;
              case "sheet2":      //sheet1 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly;//msHeaderOnly; //msAll;
					Editable = false;
					InitRowInfo(2, 1, 9, 100);
					InitColumnInfo(10, 0, 0, true);
					InitHeadMode(false, false, false, true, false,false);

					var HeadTitle  = "Node Link|Activity Group|Activity Group|Activity Group|Cost Group/Cost Element|Cost Group/Cost Element|Feeder Term|Feeder Term|Amount|level" ;
					var HeadTitle1 = "Node Link|Activity Group|Activity Group|Activity Group|Cost Group/Cost Element|Cost Group/Cost Element|Rev_Term|Del_Term|Amount|level" ;
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, false);
                     
					InitDataProperty(0, cnt++, dtData,		200,	daCenter,	true,	"nod_cd");
					InitDataProperty(0, cnt++, dtData,		130,	daLeft,	    true,	"grp");
					InitDataProperty(0, cnt++, dtData,		200,	daCenter,	true,	"dw_nod_cd");
					InitDataProperty(0, cnt++, dtData,		130,	daCenter,	true,	"dw_grp");
					InitDataProperty(0, cnt++, dtData,		220,	daLeft,		true,	"tree_col");  // sheet 에서 보여줄 정보
					InitDataProperty(0, cnt++, dtData,		220,	daLeft,		true,	"dw_tree_col"); // excel down 시 보여줄 정보

					InitDataProperty(0, cnt++ ,dtData,		70,		daCenter,	true,	"wtr_rcv_term_cd");
					InitDataProperty(0, cnt++ ,dtData,		70,		daCenter,	true,	"wtr_de_term_cd");
					InitDataProperty(0, cnt++ ,dtData,	    80,		daRight,    true,	"amt",		false,	"",		dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ ,dtHidden,	70,		daCenter,	true,	"lvl");
					RangeBackColor(1, 6, 1, 7) = RgbColor(222, 251, 248);

					InitTreeInfo("tree_col", "", RgbColor(0,0,255), false);
					CountPosition	= 0 ;
					style.height = GetSheetHeight(16) ;
					ColHidden("nod_cd")    = false;
					ColHidden("grp")       = false;
					ColHidden("tree_col")  = false;
					ColHidden("dw_nod_cd") = true;
					ColHidden("dw_grp")    = true;
					ColHidden("dw_tree_col") = true;
					ColHidden("lvl") = true;
				}
				break;     
				
              case "sheet3":      //sheet1 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;
					style.height = 70;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly;//msHeaderOnly; //msAll;
					Editable = false;
					InitRowInfo(1, 1, 9, 100);
					
					InitHeadMode(false, false, false, true, false,false);
					

                     
                     
					                           
					var HeadTitle  = "ibflag|prop_no|amdt_seq|qttn_no|qttn_ver_no|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|rt_seq|respb_usd_ttl_amt|cost_tp" ;
					
 					var headCount = ComCountHeadTitle(HeadTitle);
					
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
  					InitHeadRow(0, HeadTitle, true);
                     
                     
                   
					InitDataProperty(0, cnt++, dtStatus,		70,	daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++, dtData,		70,	daLeft,	    true,	"prop_no");
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"amdt_seq");
					InitDataProperty(0, cnt++, dtData,		70,	daLeft,	    true,	"qttn_no");
					InitDataProperty(0, cnt++, dtData,		70,	daLeft,	    true,	"qttn_ver_no");

					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"svc_scp_cd");
					InitDataProperty(0, cnt++, dtData,		70,	daLeft,		true,	"gen_spcl_rt_tp_cd");  

					InitDataProperty(0, cnt++ ,dtData,		70,		daCenter,	true,	"cmdt_hdr_seq");
					InitDataProperty(0, cnt++ ,dtData,		70,		daCenter,	true,	"rout_seq");
					InitDataProperty(0, cnt++ ,dtData,	    80,		daRight,    true,	"rt_seq");
					InitDataProperty(0, cnt++ ,dtHidden,	70,		daCenter,	true,	"respb_usd_ttl_amt");
					InitDataProperty(0, cnt++ ,dtHidden,	70,		daCenter,	true,	"cost_tp");
				}
				break;   				
         }
     }

      /**
       * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
       * <br><b>Example :</b>
       * <pre>
       *      getBackEndJobStatus();
       * </pre>
       * @return 없음
       * @author 김종준
       * @version 2012.02.20
       */     
      function getBackEndJobStatus() {
      	var formObj = document.form;
      	var sheetObj = sheetObjects[0];
      	ComOpenWait(true);
      	formObj.f_cmd.value = SEARCHLIST03;
      	var sXml = sheetObj.GetSearchXml("ESM_MAS_0153GS2.do", FormQueryString(formObj) + "&f_mty_pkup_yd_cd=&f_mty_pkup_yd_node=&f_mty_rtn_yd_cd=&f_mty_rtn_yd_node=" );
      	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
      	if (jobState == "3") {
      		getBackEndJobSearch();
      		clearInterval(backEndJobTimer);
      	} else if (jobState == "4") {
      		ComShowCodeMessage("MAS00001");
      		ComOpenWait(false);
      		clearInterval(backEndJobTimer);
      	} else if (jobState == "5") {
      		ComShowCodeMessage("MAS00002");
      		ComOpenWait(false);
      		clearInterval(backEndJobTimer);
      	}
      }          
      
      /**
       * BackEndJob의 결과가 완료되면 결과를 조회하여 메세지를 출력한다.<br>
       * <br><b>Example :</b>
       * <pre>
       *      getBackEndJobSearch();
       * </pre>
       * @return 없음
       * @author 김종준
       * @version 2012.02.20
       */       
      function getBackEndJobSearch() {
      	var formObj = document.form;
      	var sheetObj = sheetObjects[1];
      	formObj.f_cmd.value = SEARCHLIST04;    	
      	var sXml = sheetObj.GetSearchXml("ESM_MAS_0153GS2.do", FormQueryString(formObj) + "&f_mty_pkup_yd_cd=&f_mty_pkup_yd_node=&f_mty_rtn_yd_cd=&f_mty_rtn_yd_node=" );
      	var err_cd = ComGetEtcData(sXml, "err_cd");
      	var err_msg = ComGetEtcData(sXml, "err_msg");    	
  		
  		ComOpenWait(false);
  		
  		if (err_cd == "00000") {
  			formObj.f_cmd.value = SEARCHLIST05;    	
  			sheetObj.DoSearch4Post("ESM_MAS_0153GS2.do", FormQueryString(formObj) + "&f_mty_pkup_yd_cd=&f_mty_pkup_yd_node=&f_mty_rtn_yd_cd=&f_mty_rtn_yd_node=" );
  		} else if (err_cd == "00028") {
  			ComShowMessage("ERROR(MAS00153): " + err_msg);
  		} else{
  			ComShowMessage("ERROR(MAS00153): " + err_msg);
  		}		
  	}
      
  	 /**
        * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
        * <br><b>Example :</b>
        * <pre>
        *      getBackEndJobStatus();
        * </pre>
        */     
       function getPrdBackEndJobStatus() {
       	var formObj = document.form;
       	var sheetObj = sheetObjects[0];
       	ComOpenWait(true);
       	formObj.f_cmd.value = SEARCHLIST06;
       	var sXml = sheetObj.GetSearchXml("ESM_MAS_0153GS2.do", FormQueryString(formObj) + "&f_mty_pkup_yd_cd=&f_mty_pkup_yd_node=&f_mty_rtn_yd_cd=&f_mty_rtn_yd_node=");
       	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
       	var prd_msg  = ComGetEtcData(sXml, "prd_msg");
       	
       	if (jobState == "3") {
       		getPrdBackEndJobSearch();
       		clearInterval(backEndJobTimer);
       	} else if (jobState == "4") {
       		ComShowMessage(prd_msg);
       		ComOpenWait(false);
       		clearInterval(backEndJobTimer);
       	} else if (jobState == "5") {
       		ComShowCodeMessage("MAS00002");
       		ComOpenWait(false);
       		clearInterval(backEndJobTimer);
       	}
       }   
       /**
        * PRD Route BackEndJob의 결과가 완료되면 결과를 조회하여 메세지를 출력한다.<br>
        * <br><b>Example :</b>
        * <pre>
        *      getBackEndJobStatus();
        * </pre>
        */ 
       function getPrdBackEndJobSearch() {
       	var formObj = document.form;
       	var sheetObj = sheetObjects[0];
       	formObj.f_cmd.value = SEARCHLIST07;    	
       	var sXml = sheetObj.GetSearchXml("ESM_MAS_0153GS2.do", FormQueryString(formObj) + "&f_mty_pkup_yd_cd=&f_mty_pkup_yd_node=&f_mty_rtn_yd_cd=&f_mty_rtn_yd_node=" );
   		ComOpenWait(false);
   		
   		result_key = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
           if(result_key != ""){
               // header
               //-------------------------
           	sheetObj.Redraw = false;
           	sheetObj.RemoveAll();
           	sheetObj.Reset();
               initSheet(sheetObj, 1 );
               sheetObj.Redraw = true;
               // data
               //-------------------------
               sheetObj.LoadSearchXml(sXml);
               //-------------------------
           }
           ComOpenWait(false);
		//viewCreation();    		
		
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
				if(validateForm(sheetObj,formObj,sAction)) {
					
					if ( sheetObj.id == "sheet1" ) {
						sheetObjects[0].RemoveAll();
						sheetObjects[1].RemoveAll();
						
						// 업무처리중 버튼사용 금지 처리
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						//prd backend job으로     						
						formObj.f_cmd.value = SEARCHLIST01;
						
						var sXml = sheetObj.GetSearchXml("ESM_MAS_0153GS.do", FormQueryString(formObj) + "&f_mty_pkup_yd_cd=&f_mty_pkup_yd_node=&f_mty_rtn_yd_cd=&f_mty_rtn_yd_node=" );

						//prd pc생성 backendjob
						var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
						if (backendJobKey != null && backendJobKey.length > 0) {
							ComSetObjValue(formObj.backendjob_key, backendJobKey);
							sheetObj.RequestTimeOut = 600; //초 - 10분
							backEndJobTimer = setInterval(getPrdBackEndJobStatus, 10000);	//밀리초  - 10초
						}	
						
						/*
						setSearchedValues(true);
						formObj.f_cmd.value = SEARCHLIST01;
						sheetObj.DoSearch4Post("ESM_MAS_0153GS.do", FormQueryString(formObj) + "&f_mty_pkup_yd_cd=&f_mty_pkup_yd_node=");
						ComOpenWait(false);
						*/
	//					viewCreation();
					}
					else if ( sheetObj.id == "sheet2" ) {
						if(sheetObjects[0].RowCount>0){//sheet1에 데이터가 있을때
							
							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);
														
							formObj.f_cmd.value = SEARCHLIST02;
							var sheetObject = sheetObjects[0];
							//sheet1의 선택된 행들을 쿼리로
							var selrow = sheetObject.SelectRow;							
							formObj.f_pctl_no.value = sheetObject.CellValue(selrow, "pctl_no");
							formObj.pctl_no.value = sheetObject.CellValue(selrow, "pctl_no");
							
							var sXml = sheetObj.GetSearchXml("ESM_MAS_0153GS2.do", FormQueryString(formObj) + "&f_mty_pkup_yd_cd=&f_mty_pkup_yd_node=&f_mty_rtn_yd_cd=&f_mty_rtn_yd_node=" );
							var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
							if (backendJobKey != null && backendJobKey.length > 0) {
								ComSetObjValue(formObj.backendjob_key, backendJobKey);
								sheetObj.RequestTimeOut = 7200; //초 - 2시간
								backEndJobTimer = setInterval(getBackEndJobStatus, 10000);	//밀리초  - 10초
							}				
	
						} else {
							ComShowMessage(ComGetMsg('MAS10005', 'Sheet1'));
						}
					}
				}

			break;
 			case IBSAVE:        //저장
 				ComOpenWait(true);
 				addSaveData(sheetObj);
				if( !validateForm(sheetObj,document.form,sAction) ){
					ComOpenWait(false);
					return false;
				}	
				var popup_type = formObj.popup_type.value


				formObj.f_cmd.value = MULTI01;
				var param = FormQueryString(formObj) + "&total_cost="+sheetObj.CellValue(total_index,"amt");
				
				var r = "";
				
				
				if( popup_type == "SP"){ //S/C Proposal 화면에서 호출 됐음
					r = sheetObj.DoSave("ESM_PRI_6016GS.do", param );
				}else if( popup_type == "SQ"){ //S/C Quotation 화면에서 호출 됐음
					r = sheetObj.DoSave("ESM_PRI_6062GS.do", param );
				}else if( popup_type == "RP"){ //RFA Proposal 화면에서 호출 됐음
					r = sheetObj.DoSave("ESM_PRI_6064GS.do", param );
				}else if( popup_type == "RQ"){ //RFA Quotation 화면에서 호출 됐음
					r = sheetObj.DoSave("ESM_PRI_6063GS.do", param );		
				}else if( popup_type == "TP"){ //TRI  화면에서 호출 됐음
					r = sheetObj.DoSave("ESM_PRI_6084GS.do", param );						
				}
			
				if( r == true ){
					if( sheetObj.IsDataModified == true){
					}else{
						window.returnValue="SUCCESS";
						self.close();
					}
				}		
				ComOpenWait(false);
				break;

         }
     }
      
      /** 
       * Data의 Insert를 위해 sheet에 값을 Insert시켜주는 함수
       * <br><b>Example :</b>
       * <pre>
       *      addSaveData(sheetObj)
       * </pre>
       * @param {object} sheetObj 필수, sheet Object
       */   
      function addSaveData(sheetObj){
    	  var formObj = document.form;
    	  var sheetObj1 = sheetObjects[1];
    	  
    	  sheetObj.RemoveAll();
    	  
    	  if( sheetObj1.RowCount < total_index ){
    		  return;
    	  }
    	  sheetObj.DataInsert(-1);
    	  sheetObj.CellValue2(1,"prop_no") = formObj.prop_no.value;
    	  sheetObj.CellValue2(1,"amdt_seq") = formObj.amdt_seq.value;
    	  sheetObj.CellValue2(1,"qttn_no") = formObj.qttn_no.value;
    	  sheetObj.CellValue2(1,"qttn_ver_no") = formObj.qttn_ver_no.value;
    	  sheetObj.CellValue2(1,"svc_scp_cd") = formObj.svc_scp_cd.value;
    	  sheetObj.CellValue2(1,"gen_spcl_rt_tp_cd") = formObj.gen_spcl_rt_tp_cd.value;
    	  sheetObj.CellValue2(1,"cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
    	  sheetObj.CellValue2(1,"rout_seq") = formObj.rout_seq.value;
    	  sheetObj.CellValue2(1,"rt_seq") = formObj.rt_seq.value;
    	  sheetObj.CellValue2(1,"respb_usd_ttl_amt") = sheetObj1.CellValue(total_index,"amt");
    	  sheetObj.CellValue2(1,"cost_tp") = formObj.cost_tp.value;
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
  		var rt = false;
        switch(sAction) {
        case IBSEARCH:      //조회
	  		with(formObj){
	  		    if(f_g_rev.value == ""){
	  			    ComAlertFocus(f_g_rev, ComGetMsg("COM12114", "G.Rev"));
	  			} else if (f_por_cd.value == "") {
	  			    ComAlertFocus(f_por_cd, ComGetMsg("COM12114", "POR"));
	  			//} else if(f_pol_cd.value == ""){
	  			 //   ComAlertFocus(f_pol_cd, ComGetMsg("COM12114", "POL"));
	  			} else if(f_del_cd.value == ""){
	  			    ComAlertFocus(f_del_cd, ComGetMsg("COM12114", "DEL"));
	  			} else if( f_r_term.Text == "" ){
	  				ComAlertFocus(f_r_term, ComGetMsg("COM12114", "R Term"));
				} else if( f_d_term.Text == "" ){
					ComAlertFocus(f_d_term, ComGetMsg("COM12114", "D Term"));	  	
				} else if( f_sls_ofc_cd.value == "" && f_cob_profit_lv.value == "O" ){ //CM일때만 필수 입력
					ComAlertFocus(f_sls_ofc_cd, ComGetMsg("COM12114", "Loading OFC"));	  		
				} else if( f_bkg_ofc_cd.value == ""  && f_cob_profit_lv.value == "O" ){//CM일때만 필수 입력
					ComAlertFocus(f_bkg_ofc_cd, ComGetMsg("COM12114", "Booking OFC"));	  						
	  			//} else if(comboObjects[0].Text == ""){
	  			 //   ComAlertFocus(comboObjects[0], ComGetMsg("COM12113", "TP/SZ"));
	  			} else if(f_qty.value == ""){
	  			    ComAlertFocus(f_qty, ComGetMsg("COM12114", "QTY (BOX)"));
	//  			} else if(comboObjects[1].Text == "" && (officLv.style.display == 'inline' && f_cob_profit_lv.selectedIndex == 1)){//f_agmt_sgn_ofc_cd
	//  			    ComAlertFocus(f_agmt_sgn_ofc_cd, ComGetMsg("COM12114", "Contract OFC"));
	//  			} else if(comboObjects[2].Text == "" && (officLv.style.display == 'inline' && f_cob_profit_lv.selectedIndex == 1)){//f_sls_ofc_cd
	//  			    ComAlertFocus(f_sls_ofc_cd, ComGetMsg("COM12114", "Loading OFC"));
	//  			} else if(comboObjects[3].Text == "" && (officLv.style.display == 'inline' && f_cob_profit_lv.selectedIndex == 1)){//f_bkg_ofc_cd
	//  			    ComAlertFocus(f_bkg_ofc_cd, ComGetMsg("COM12114", "Booking OFC"));
	  			}
	  			
	  			else {
	  			    if(f_void_qty.value == ""){
	  			      f_void_qty.value = 0;
	  			    }			    
	  			    rt = true;
	  			}	
	  			//TP/SZ의 경우는 combo에서 처리함
	
	  		}
        break;
        case IBSAVE:        //저장
        	if( sheetObj.RowCount == 0 ){
        		rt = false;
        	}else{
        		rt = true;
        	}
        break;
        
        }
  		
  		return rt;
  		//return true;
  	}	

      
  	/**
  	* sheet1을 더블클릭하여 상세조회한다
  	*/
  	function sheet1_OnDblClick(sheetObj, row, col){
  	    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
  	}

 	/** 
    * 현재 화면의 데이터 상태를 고려해 버튼들의 상태를 바꾼다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      changeButtonStatus();
	 * </pre>
	 * @return 없음
	 */  
    function changeButtonStatus(){
       	disableButton("btn1_OK");
       	disableButton("btn2_CostDetail");

    	var cnt =  sheetObjects[0].RowCount;
    	if( cnt == 0 ){
    		return;
    	}
    	if( sheetObjects[0].SelectRow > 0 ){
    		enableButton("btn2_CostDetail");
    	}
    	var cnt =  sheetObjects[1].RowCount;
    	if( cnt == 0 ){
    		return;
    	}
    	enableButton("btn1_OK");
 
    }
  	
  
	function sheet1_OnSearchEnd(sheetObj, errMessge) {
		setSearchedValues(false);
		changeButtonStatus();
	}
	
	
	
	   
    /** 
     * 조회 완료후 조회 할 당시의 조회 조건들을 다른 변수에 저장한다.<BR>
     * 만약 flag값이 true 일경우 조회 완료후 조건값을 초기화 한다.<BR> 
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *      setSearchedValues(false);
 	 * </pre>
 	 * 
 	 * @param {boolean} bClearValues 필수, true : 값을 초기화, false : 현재 화면의 값을 다른 변수에 저장해 놓는다.
 	 * @return 없음
 	 */
 	function setSearchedValues(bClearValues){
 		
 		var formObj = document.form;
 		if(bClearValues != true){

					
			formObj.por_cd.value = formObj.f_por_cd.value
			formObj.pol_cd.value = formObj.f_pol_cd.value
			formObj.pod_cd.value = formObj.f_pod_cd.value
			formObj.del_cd.value = formObj.f_del_cd.value
			formObj.bkg_rcv_term_cd.value = formObj.f_r_term.Code; 
			formObj.bkg_de_term_cd.value = formObj.f_d_term.Code
			formObj.bkg_ofc_cd.value = formObj.f_bkg_ofc_cd.value
			formObj.ctrt_ofc_cd.value = formObj.f_agmt_sgn_ofc_cd.value
			formObj.ob_sls_ofc_cd.value = formObj.f_sls_ofc_cd.value
			formObj.rat_ut_cd.value = formObj.f_cntr_tpsz_cd.value
			formObj.prc_cgo_tp_cd.value = formObj.cargo.value;
			formObj.teu_frt_rev.value = formObj.f_g_rev.value;
 			
			
 		}else{
 			formObj.por_cd.value = "";
 			formObj.pol_cd.value = "";
 			formObj.pod_cd.value = "";
 			formObj.del_cd.value = "";
 			formObj.bkg_rcv_term_cd.value = "";
 			formObj.bkg_de_term_cd.value = "";
 			formObj.bkg_ofc_cd.value = "";
 			formObj.ctrt_ofc_cd.value = "";
 			formObj.ob_sls_ofc_cd.value = "";
 			formObj.rat_ut_cd.value = "";
 			formObj.prc_cgo_tp_cd.value = "";
 			formObj.teu_frt_rev.value = "";
 		}
 	}
 	
 	
 	
   	/**
	트리 접기
	*/
	function sheet2_OnSearchEnd(sheetObj, errMessge) {
	    //1:Freight Rev, 2:DEM/DET, 3:SMU, 4:Misc OP Rev, 5:BKG CM, 6:BKG OP, 7:Total Cost    
	    var cm_index = 6;
	    var op_index = 7;
	    var dem_det_index = 3//
	    var total_cost = 0;
	    var smu_cost = 0;//SMU
	    var dmdt_rev = 0;//DEM/DET
	    var f_rev = 0;//Freight Rev
	    var misc_rev = 0;//Misc OP Rev
	    var cm_minus_cost = 0;//OP Cost에서 CM계산을 위해 활동원가&장비비 추출 
	     
	    var bkg_op_visible = sheetObj.EtcData("bkg_op_visible");//OP항목 보여줄지 여부
 	    if(bkg_op_visible == "Y") smu_cost = parseFloat(sheetObj.CellValue(4, "amt"));//OP의 경우만 SMU값을 가져온다.
	    dmdt_rev =  parseFloat(sheetObj.CellValue(dem_det_index, "amt"));
	    f_rev =  parseFloat(sheetObj.CellValue(2, "amt"));
	    misc_rev =  parseFloat(sheetObj.CellValue(5, "amt"));
	    
	    //cost SUM 구하기
	    var k = 0;
	    for(k=total_index+1; k <= sheetObj.LastRow; k++) {
	        if(sheetObj.CellValue(k, "lvl") == 1) {
	            total_cost = total_cost + parseFloat(sheetObj.CellValue(k, "amt"));
                if((ComTrim(sheetObj.CellValue(k, "tree_col")) == 'Business Activity Cost') ||( ComTrim(sheetObj.CellValue(k, "tree_col")) == 'EQ Cost')){
                    cm_minus_cost = cm_minus_cost + parseFloat(sheetObj.CellValue(k, "amt"));
                }               
	        }
	    }
	    
        //Total Cost Setting
		sheetObj.CellValue2(total_index, "amt") = total_cost;
    	
    	//BKG CM Setting REV + DEM/DET - SMU를 제외한 Cost
    	//sheetObj.CellValue2(cm_index, "amt") = f_rev + misc_rev + dmdt_rev - (total_cost - smu_cost);
    	sheetObj.CellValue2(cm_index, "amt") = f_rev + misc_rev - (total_cost - smu_cost - cm_minus_cost);//CM에서 DEMDET 및 OP비용 제외

 		//BKG OP
		if(bkg_op_visible == "Y") {//OP였을 경우 BKG OP = REV + DEM/DET - SMU를 포함한 Cost
		    sheetObj.CellValue2(op_index, "amt") =  f_rev + misc_rev + dmdt_rev - total_cost;
            sheetObj.CellFont("FontBold", op_index,  "nod_cd") = true;
            sheetObj.CellFont("FontBold", op_index,  "amt") = true;   		      	       
		} 		
		//Revenue관련 색상 변경 
				
        //글자 Bold 설정
        sheetObj.CellFont("FontBold", total_index, "nod_cd") = true;
        sheetObj.CellFont("FontBold", cm_index, "nod_cd") = true;
        sheetObj.CellFont("FontBold", total_index, "amt") = true;
        sheetObj.CellFont("FontBold", cm_index, "amt") = true;        
       
        //minus CM 빨강색으로
        if(parseFloat(sheetObj.CellValue(cm_index, "amt")) < 0) sheetObj.CellFontColor (cm_index,  "amt") = sheetObj.RgbColor(255, 0, 0);
        //minus OP 빨강색으로
        if(parseFloat(sheetObj.CellValue(op_index, "amt")) < 0) sheetObj.CellFontColor (op_index,  "amt") = sheetObj.RgbColor(255, 0, 0);
        //OP가 아닌 경우 OP Hidden
        if(bkg_op_visible == "N") {
            sheetObj.RowHidden(op_index) = true;
            sheetObj.RowHidden(dem_det_index) = true;            
        }
        //SMU Hidden
        sheetObj.RowHidden(4) = true;
		
		//TREE 접기
		sheetObj.ShowTreeLevel(1);
		sheetObj.SelectCell(8, 0);//Total Cost에 Focus
		changeButtonStatus();

	}	
   

	/* 개발자 작업  끝 */