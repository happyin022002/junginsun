/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6071.js
*@FileTitle : PRS-Surcharge Adjust
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.07 송민석
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
     * @class ESM_PRI_6071 : ESM_PRI_6071 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6071() {
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
 var xchgYrMon = "";

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


	            case "btn_Add":
	           	 	doActionIBSheet(sheetObject1, formObject, IBINSERT);
	                break; 
	            case "btn_Copy":
	           	 	doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
	                break; 	                
	                
	            case "btn_Delete":
	           	 	doActionIBSheet(sheetObject1, formObject, IBDELETE);
					 break;
	            case "btn_OK":
	           	 	doActionIBSheet(sheetObjects[1], formObject, IBSEARCH_ASYNC01);
	                break; 	  
	            case "btn_Save":
	           	 	doActionIBSheet(sheetObject1, formObject, IBSAVE);
	                break; 
				case "btn_Close":
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
         loadInitData();         
         changeButtonStatus(sheetObjects[0]);
         ComOpenWait(false);
     }

     /**  
     * 화면 loading시 필요한 최초 데이터를 조회해서<br>
     * 화면에 Setting 해 놓는다.
     *  
     * <br><b>Example :</b>
     * <pre>
     *   loadInitData();
     * </pre>
     * 
     * @return 없음
     */    
      function loadInitData( ){
     	 var formObj = document.form;
     	 initCombo(formObj);
     	 xchgYrMon = getXChgRateFromYrMon();
     	 doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
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

                     // 높이 설정
                     style.height = 260;
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

                     var HeadTitle1 = "|Sel.|Seq.|Commodity|Origin|Origin|O.Via|D.Via|Dest.|Dest.|Per|CGO\nType|Surcharge|Surcharge|Surcharge|Surcharge|||||prc_cmdt_tp_cd|org_loc_tp_cd|org_via_loc_tp_cd|dest_via_loc_tp_cd|dest_loc_tp_cd";
 					var HeadTitle2 = "|Sel.|Seq.|Commodity|Code|Term|O.Via|D.Via|Code|Term|Per|CGO\nType|Code|Cur.|Amount|(USD)|||||prc_cmdt_tp_cd|org_loc_tp_cd|org_via_loc_tp_cd|dest_via_loc_tp_cd|dest_loc_tp_cd";
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
                     
 					InitDataProperty(0, cnt++ , dtDummyCheck,			30,   	daCenter,  	true,		"sel_chk",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtSeq,    			30,   	daCenter,  	true,		"seq",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopup,    		80,   	daCenter,  	true,		"prc_cmdt_def_cd",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopup,    		75,   	daCenter,  	true,		"org_loc_def_cd",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtCombo,    		55,   	daCenter,  	true,		"prc_rcv_term_cd",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopup,    		75,   	daCenter,  	true,		"org_via_loc_def_cd",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopup,    		75,   	daCenter,  	true,		"dest_via_loc_def_cd",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopup,    		75,   	daCenter,  	true,		"dest_loc_def_cd",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtCombo,    		60,   	daCenter,  	true,		"prc_de_term_cd",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtCombo,    		40,   	daCenter,  	true,		"bkg_rat_ut_cd",   	false,          "",      dfNone,      		0,			true,       true);
 					
 					InitDataProperty(0, cnt++ , dtCombo,    		40,   	daCenter,  	true,		"prc_cgo_tp_cd",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtComboEdit,    		50,   	daCenter,  	true,		"chg_cd", true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtCombo,    		45,   	daCenter,  	true,		"curr_cd",   true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			70,   	daRight,  	true,		"adj_scg_amt", true,          "",      dfFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			0,   	daRight,  	true,		"adj_scg_usd_amt",   false,          "",      dfFloat,      	2,			false,       true);
 					
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"qttn_no",   			false,          "",      dfNone,      		0,			false,      false); 					
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"qttn_ver_no",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"gen_spcl_rt_tp_cd",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"scg_adj_seq",   			false,          "",      dfNone,      		0,			false,      false);
 					
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"prc_cmdt_tp_cd",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"org_loc_tp_cd",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"org_via_loc_tp_cd",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"dest_via_loc_tp_cd",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"dest_loc_tp_cd",   			false,          "",      dfNone,      		0,			false,      false);
 					
 					InitDataValid(0, "chg_cd", vtEngUpOnly);	// 영문대문자만 입력

 					CountPosition = 0;
 					
 					ImageList(0) = "img/btns_search.gif";
 					ImageList(1) = "img/btns_search.gif";
 					
 					PopupButtonImage(0, 4) = 0;
 					PopupButtonImage(0, 5) = 1;
 					PopupButtonImage(0, 7) = 1;
 					PopupButtonImage(0, 8) = 1;
 					PopupButtonImage(0, 9) = 1;


 					ShowButtonImage = 1;
                }
                break;

              case "sheet2":      //sheet2 init
              with (sheetObj) {

                  // 높이 설정
                  style.height = 260;
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

                  var HeadTitle1 = "|prop_no|amdt_seq|svc_scp_cd|gen_spcl_rt_tp_cd";
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
                  
 					
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"qttn_no",   			false,          "",      dfNone,      		0,			false,      false); 					
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"qttn_ver_no",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"gen_spcl_rt_tp_cd",   			false,          "",      dfNone,      		0,			false,      false);
					     
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
	            sheetObj.DoSearch("ESM_PRI_6071GS.do", FormQueryString(formObj) + "&table_cd=SP");
	            ComOpenWait(false);
                break;
 			case IBSAVE:        //저장
 				ComOpenWait(true);
				if( !validateForm(sheetObj,document.form,sAction) ){
					ComOpenWait(false);
					return false;
				}	
				formObj.f_cmd.value = MULTI; 
				
				var sXml = sheetObj.GetSaveXml("ESM_PRI_6071GS.do", sheetObj.GetSaveString() + "&" + FormQueryString(formObj)  );
				
				SAVE_STATE = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
				break;
			case IBINSERT:      // 입력
				var idx = sheetObj.DataInsert(-1);
				setFormDataToSheet(idx,sheetObj, formObj);
				break;
			case IBDELETE: //삭제
				if (!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				deleteRowCheck(sheetObj, "sel_chk") ;
				changeButtonStatus(sheetObj);
				break;
			case IBCOPYROW:      // 입력
				var idx = sheetObj.DataCopy();
				sheetObj.CellValue(idx,"sel_chk") = 0;
				break;				
 			case IBSEARCH_ASYNC01:        //Calculate 수행
 				ComOpenWait(true);
 				if(!validateForm(sheetObjects[0],formObj,sAction)){
 					ComOpenWait(false);
 					return;
 				}
				formObj.f_cmd.value = MULTI01;
				var idx = sheetObj.DataInsert(-1);
				setFormDataToSheet(idx,sheetObj, formObj);
				var sXml = sheetObj.GetSaveXml("ESM_PRI_6071GS.do", sheetObj.GetSaveString() + "&" + FormQueryString(formObj)  );
	
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
          switch (sAction) {
	          case IBSEARCH:
	        	  break;
	          case IBSAVE: // 저장
	 	         if (sheetObj.IsDataModified == false) {
	 	             return false;
	 	         }
			   //저장 String 가져오기 - 트랜잭션이 발생한 것만 저장할 경우
			     var saveStr = sheetObj.GetSaveString(false);
			   //필수 입력과 같은 확인이 이루어짐
			     if ( saveStr == ""){
			    	return false;
			     }   	          
	          	 var colNames = "prc_cmdt_def_cd|org_loc_def_cd|prc_rcv_term_cd|org_via_loc_def_cd|dest_via_loc_def_cd|dest_loc_def_cd|prc_de_term_cd|bkg_rat_ut_cd|prc_cgo_tp_cd|chg_cd";
	          	 //중복체크
	 	         var dupRow = sheetObj.ColValueDup(colNames,false); 
	 	     	 if (dupRow >= 0) {
	 	     		sheetObj.SelectRow = dupRow;
	 				ComShowCodeMessage("PRI00302");
	 				return false;
	 	     	 }
	         	break;
	          case IBSEARCH_ASYNC01: //OK
	          	if( sheetObj.IsDataModified ){
	          		ComShowCodeMessage("PRI03017");
	          		return false;
	          	}
	          	break;	  	         	
          }
          return true;
     }		

     
     /**  
     * HTML Form에 있는 특정 데이터들을 Sheet의 특정 Cell들에<BR>  
     * SETTING한다.
     *  
     * <br><b>Example :</b>
     * <pre>
     *   setFormDataToSheet(idx, sheetObj, formObj)
     * </pre>
     *
     * @param {int} idx 필수, form의 값을 assign하고자 하는 Cell이 있는 row index
     * @param {object} sheetObj 필수, sheet Object
     * @param {object} formObj 필수, html document form Object
     * @return 없음
     */    
     function setFormDataToSheet(idx, sheetObj, formObj){
    	 sheetObj.CellValue(idx, "qttn_no") = formObj.qttn_no.value;
    	 sheetObj.CellValue(idx, "qttn_ver_no") = formObj.qttn_ver_no.value;
    	 sheetObj.CellValue(idx, "gen_spcl_rt_tp_cd") = formObj.gen_spcl_rt_tp_cd.value;
    	 
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
 	 	//surcharge scope cd combo
  		formObj.f_cmd.value = COMMAND12;
  		var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+formObj.svc_scp_cd.value);
  		setIBCombo(sheetObj,sXml,"chg_cd",true,0,"","",true);

  		
  		
      	 //currency combo
  		formObj.f_cmd.value = COMMAND16;
  		var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
  		setIBCombo(sheetObj,sXml,"curr_cd",true,0,"USD");
  			
  		// per combo
  		formObj.f_cmd.value = COMMAND18;
  		sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
  		setIBCombo(sheetObj, sXml, "bkg_rat_ut_cd", true, 0);
  		
 		formObj.f_cmd.value = SEARCH20;
 		//공통  CD02138 SC RECEIVING TERM CODE     		
		var sXml = sheetObj.GetSearchXml("PRICommonGS.do" , FormQueryString(formObj)+"&cd=CD02138");
		var arrXml = sXml.split("|$$|");
		if ( arrXml[0] != null)	setIBCombo(sheetObj, arrXml[0], "prc_rcv_term_cd", true, 0);						
 		formObj.f_cmd.value = SEARCH20;
 		//공통  CD02139 SC RECEIVING TERM CODE
		var sXml = sheetObj.GetSearchXml("PRICommonGS.do" , FormQueryString(formObj)+"&cd=CD02139");
		var arrXml = sXml.split("|$$|");
		if ( arrXml[0] != null)	setIBCombo(sheetObj, arrXml[0], "prc_de_term_cd", true, 0);						
  		
		
        //공통 cargo
        formObj.f_cmd.value = SEARCH19;
        sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02202");
        setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", true, 0);		
    }          
     /**  
     * prop_no, amdt_seq, svc_scp_cd 조회 조건을 이용하여<BR>
     * Surcharge Detail에 사용된 <BR>
     * 환율의 년월을 조회해 return한다.<BR>
     *  
     * <br><b>Example :</b>
     * <pre>
     *   xchgYrMon = getXChgRateFromYrMon();  // 결과 : "200910"
     * </pre>
     *
     * @return string, 환율계산 기준 년월
     */   
	function getXChgRateFromYrMon(){
    	var tmpXchgYrMon = "";
       	var formObj = document.form
 		var formParam = "f_cmd="+COMMAND36+"&etc1="+formObj.qttn_no.value;
 		formParam = formParam + "&etc2="+formObj.qttn_ver_no.value;
 		
 		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", formParam );
 		var arrData = ComXml2ComboString(sXml, "cd", "nm");
 		if( arrData != "" ){
 			tmpXchgYrMon = arrData[1];
 		}
 		return tmpXchgYrMon;
    }   	
    /** 
     * 현재 조회중인 데이터를 생성한 년월을 이용해서 Local Amt를 USD로 환산해준다. 
     * 
     * <br><b>Example :</b>
     * <pre>
     *       getLocalAmtToUSD(sheetObj,row);
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {int} row 필수, 변경하고자 하는 row index
     * @return 없음
     */  
   	function getLocalAmtToUSD(sheetObj,row){
			//USD이면 DB조회가 필요 없다.
		if(  sheetObj.Cellvalue(row,"curr_cd") == "USD"){
			sheetObj.Cellvalue2(row,"adj_scg_usd_amt") = sheetObj.Cellvalue(row,"adj_scg_amt")
		}else{
   	    	//USD AMOUNT
 	      	var formObj = document.form
			var formParam = "f_cmd="+COMMAND03+"&etc1="+sheetObj.Cellvalue(row,"curr_cd");
			formParam = formParam + "&etc2="+sheetObj.Cellvalue(row,"adj_scg_amt");
			formParam = formParam + "&etc3="+xchgYrMon;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", formParam );
			var arrData = ComXml2ComboString(sXml, "cd", "nm");
			sheetObj.Cellvalue2(row,"adj_scg_usd_amt") = arrData[1];
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
   			if(auth == "S" || auth == "A") {
   	   			enableButton("btn_Add");
   	   	   		if(sheetObj.IsDataModified == true   ){   		
   	        		enableButton("btn_Save");
   	   	   		}else{
   	   	   			disableButton("btn_Save");
   	   	   		}
   	    		if(sheetObj.RowCount > 0 ){
   	    			enableButton("btn_Copy");
   	    			enableButton("btn_Delete");
   	    		}else{
   	    			disableButton("btn_Copy");
   	    			disableButton("btn_Delete");
   	    		}   	   	   		
   			}else{
   				disableButton("btn_Add");
   				disableButton("btn_Save");
   				disableButton("btn_Copy");
   				disableButton("btn_Delete");
   			}
   		}else{
   			disableButton("btn_Add");
   			disableButton("btn_Save");
   			disableButton("btn_Copy");
   			disableButton("btn_Delete");
   		} 	
   		

 	}
 	  	 
 	
   /** 
    * sheet의 DATA TYPE이 dtPopup, dtEditPopup의 column을 클릭했을 경우 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {int} row 필수, click한 cell의 row index
    * @param {int} col 필수, click한 cell의 col index
    * @return 없음
    */   	
 	function sheet1_OnPopupClick(sheetObj,row,Col) {
 		var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		var loc_type="";
 		
       	switch(colName)
       	{
   	    	case "prc_cmdt_def_cd":		
 	  	  		var sUrl = "ESM_PRI_6078.do";
 	  	  		var params = new Array();  	  		
 	  	  		params["qttn_no"] = formObj.qttn_no.value;
 	  	  		params["qttn_ver_no"] = formObj.qttn_ver_no.value;
 	  	  		params["cmdt_def_cd"] = sheetObj.CellValue(row,"prc_cmdt_def_cd");
 	  	  		window.Params = params;
 	  	  		
 	  			var rtnVal = ComPriOpenWindowCenter(sUrl , "ESM_PRI_6078", 900, 339, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue(sheetObj.SelectRow, "prc_cmdt_def_cd") = rtnVal.prcCmdtDefCd;
 	  				sheetObj.CellValue(sheetObj.SelectRow, "prc_cmdt_tp_cd") = rtnVal.prcCmdtTpCd;
 	  			}
   	    		break;   	    		
   	    	case "org_loc_def_cd":	
   	    		loc_type = "OG";
   	    	case "org_via_loc_def_cd":
   	    		if(loc_type == "") loc_type = "OV";
   	    	case "dest_via_loc_def_cd":
   	    		if(loc_type == "") loc_type = "DV";
   	    	case "dest_loc_def_cd":
   	    		if(loc_type == "") loc_type = "DS";
   	    		
 	  	  		var sUrl = "ESM_PRI_6081.do";
 	  	  		var params = new Array();  	  		
 	  	  		params["qttn_no"] = formObj.qttn_no.value;
 	  	  		params["qttn_ver_no"] = formObj.qttn_ver_no.value;
 	  	  		params["org_loc_def_cd"] = sheetObj.CellValue(row,"org_loc_def_cd");
 	  	  		params["org_via_loc_def_cd"] = sheetObj.CellValue(row,"org_via_loc_def_cd");
 	  	  		params["dest_via_loc_def_cd"] = sheetObj.CellValue(row,"dest_via_loc_def_cd");
 	  	 		params["dest_loc_def_cd"] = sheetObj.CellValue(row,"dest_loc_def_cd");
 	  	 		
	 	  	 	params["org_loc_tp_cd"] = sheetObj.CellValue(row,"org_loc_tp_cd");
			  	params["org_via_loc_tp_cd"] = sheetObj.CellValue(row,"org_via_loc_tp_cd");
			  	params["dest_via_loc_tp_cd"] = sheetObj.CellValue(row,"dest_via_loc_tp_cd");
			  	params["dest_loc_tp_cd"] = sheetObj.CellValue(row,"dest_loc_tp_cd");
 	  	 		
 	  	 		params["loc_type"] = loc_type;
 	  	  		window.Params = params; 	  	  		
 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6081", 900, 374, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue(sheetObj.SelectRow, "org_loc_def_cd") = rtnVal.orgLocDefCd;
 	  				sheetObj.CellValue(sheetObj.SelectRow, "org_via_loc_def_cd") = rtnVal.orgViaLocDefCd;
 	  				sheetObj.CellValue(sheetObj.SelectRow, "dest_via_loc_def_cd") = rtnVal.destViaLocDefCd;
 	  				sheetObj.CellValue(sheetObj.SelectRow, "dest_loc_def_cd") = rtnVal.destLocDefCd;
 	  				
 	  				sheetObj.CellValue(sheetObj.SelectRow, "org_loc_tp_cd") = rtnVal.orgLocTpCd;
 	  				sheetObj.CellValue(sheetObj.SelectRow, "org_via_loc_tp_cd") = rtnVal.orgViaLocTpCd;
 	  				sheetObj.CellValue(sheetObj.SelectRow, "dest_via_loc_tp_cd") = rtnVal.destViaLocTpCd;
 	  				sheetObj.CellValue(sheetObj.SelectRow, "dest_loc_tp_cd") = rtnVal.destLocTpCd;
 	  			}
   	    		break;
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
    	changeButtonStatus(sheetObjects[0]);
   		if( SAVE_STATE != "S" ){
 			errMsg = ErrMsg;
 			alert(errMsg);
 		}else{
 			window.returnValue="SUCCESS";
 	 
 		}
 	}  	
    /** 
    * sheet를 이용해 Save를 했을경우 Save 완료후 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {String} ErrMsg 필수, sheet의 결과 메시지
    * @return 없음
    */     
    function sheet2_OnSaveEnd(sheetObj, errMsg){
		if( SAVE_STATE != "S" ){
 			errMsg = ErrMsg;
 			alert(errMsg);
 		}else{
 			window.returnValue="SUCCESS";
 			self.close();
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
   		if( colname == "curr_cd" || colname == "adj_scg_amt"){
   			//현재 조회중인 데이터를 생성한 년월을 이용해서 Local Amt를 USD로 환산해준다. 
   			getLocalAmtToUSD(sheetObj,row);
   		}else if(colname == "chg_cd" ){
			var sCode = sheetObj.GetComboInfo(0, "chg_cd", "Code");
			var sText = sheetObj.GetComboInfo(0, "chg_cd", "Text");
			if (sCode.indexOf(value) < 0) {
				var formObj = document.form;
				formObj.f_cmd.value = COMMAND09;
				sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + value);
				var arrData = ComPriXml2Array(sXml, "cd|nm");
				if (arrData != null && arrData.length > 0) {
					sCode += "|" + value;
					sText += "|"+ value+"\t"+ arrData[0][1];
					sheetObj.InitDataCombo(0, "chg_cd", sText, sCode);
					ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
				} else {
					sheetObj.CellValue2(row, "chg_cd") = "";
				}
			}
   		}
   		changeButtonStatus(sheetObj);
   	}
   	
	/* 개발자 작업  끝 */