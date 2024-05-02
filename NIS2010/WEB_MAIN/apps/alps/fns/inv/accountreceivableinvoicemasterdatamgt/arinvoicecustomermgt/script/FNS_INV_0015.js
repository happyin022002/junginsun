/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0015.js
*@FileTitle : Customer Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.21 한동훈
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
     * @class fns_inv_0015 : fns_inv_0015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0015() {
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
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 한동훈
	 * @version 2009.10.19
	 */ 
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];


         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_new":
                    ComResetAll();
                    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
					ComSetFocus(form.frm_cust_cnt_cd);	
					break;

		        case "btn_downExcel":                   	
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);								
                    break;

                 case "btn_multi":
                    alert("btn_multi");
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
   	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
   	 * 배열은 소스 상단에 정의
   	 * </pre>
   	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
   	 * @return 없음
   	 * @see #
   	 * @author 한동훈
   	 * @version 2009.10.19
   	 */
   	function setComboObject(combo_obj){
   		comboObjects[comboCnt++] = combo_obj;
   	}
    
    /** 
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }



    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
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
   		for(var k=0; k<comboObjects.length; k++){
   			initCombo(comboObjects[k],k+1);
   		}
        
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
    }
    
    /** 
  	 * 콤보 초기설정값<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * 
  	 * </pre>
  	 * @param {IBMultiCombo} comboObj  comboObj
  	 * @return 없음
  	 * @see #
  	 * @author 박정진
  	 * @version 2009.10.19
  	 */
    	function initCombo(comboObj, comboNo) {
    		switch (comboObj.id) {
  			case "ofc":
  				with (comboObj) {
  					SetColAlign("left");
	                SetColWidth("50");
	                //SetTitle("Office Code");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,1);
					MaxLength = 6;
  				}
  				break;  
  			}	
    	}
    	
    /** 
     * Sheet 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : 시트오브젝트
     * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
    				var sheetID = sheetObj.id;

            switch(sheetID) {

                case "sheet1":
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 222;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 2, 100);

                        var HeadTitle1 = "|cust code|cust eng name|cust register no|owner name|bzct nm|bztp nm|ofc code|cust address|City nm|zip code|fax no|contact person name|cntc_pson_nm|credit curr|credit amount|credit start date|credit end date|ib credit term|ob credit term|credit ctrl ofc|release ctrl|updated date|actual cust|cust secu amt";
    										var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        		var prefix="sheet1_";

                        		InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	false,	"ibflag");
                        		InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_cnt_cd"			 ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daLeft,		false,	"cust_lgl_eng_nm"        ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_rgst_no"           ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ownr_nm"                ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"bzct_nm"                ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"bztp_nm"                ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ofc_cd"                 ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daLeft,		false,	"cust_addr"              ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cty_nm"                 ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"zip_cd"                 ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"fax_no"                 ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"phn_no"                 ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daLeft,		false,	"cntc_pson_nm"           ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cr_curr_cd"             ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daRight,	false,	"cr_amt"                 ,	false,	"",	dfInteger,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cr_st_dt"               ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cr_end_dt"              ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ib_cr_term_dys"         ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"ob_cr_term_dys"         ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cr_clt_ofc_cd"          ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"cust_rlse_ctrl_flg"     ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"upd_dt"                 ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daCenter,	false,	"act_cust_cnt_cd"        ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,	0,	daRight,	false,	"cust_scr_locl_amt"      ,	false,	"",	dfInteger,	0,	false,	false);							                        		
    				}
                    break;
            }
    }

    /** 
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH_ASYNC10: //CreditCustomer Office 조회
				ComboObject_OfcCd(sheetObj, formObj, formObj.ofc, "Y");	
				formObj.creSelOfc.value = formObj.ofc.text;
			break;
			
			case IBSEARCH_ASYNC20: //SalesCustomer Office 조회
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0015GS.do", FormQueryString(formObj));
							
				var sStr = ComGetEtcData(sXml,"ofc");
				var arrStr = sStr.split("|");
				MakeComboObject2(formObj.ofc, arrStr, "Y");

				var arrStr2 = arrStr[1].split("^");
				//var ofc = arrStr[2];
		        formObj.ofc.text = formObj.creSelOfc.value;
		        //formObj.ofc.text = "ALL";
	        
			break;
			
           	case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction) == false) return false;  			
				if (sheetObj.id == "sheet1") {						
					formObj.f_cmd.value = SEARCH;
					
					var arrStr2 = "";
					var filePath = "";
					var release = "";
					if(formObj.cust_rlse_ctrl_flg[0].checked){
						release = "AllRelease";
					}else if(formObj.cust_rlse_ctrl_flg[1].checked){	
						release = "Release";
					}else if(formObj.cust_rlse_ctrl_flg[2].checked){	
						release = "NonRelease";
					}	
					if(form.cust_flag[0].checked){
						//arrStr2 = formObj.ofc.Code.split("^");
         				//formObj.ofc2.value = arrStr2[1];
         				formObj.ofc2.value = formObj.ofc.text;
         				filePath = "C:\\users\\"+ formObj.ofc2.value +"_CRD_"+ release +".xls";
         			}else{
         				formObj.ofc2.value = formObj.ofc.text;
         				filePath = "C:\\users\\"+ formObj.ofc2.value +"_SAL_"+ release +".xls";
         			}	         			
					//sheetObj.Reset();
					ComOpenWait(true);  //대기이미지 표시		
					sheetObj.DoSearch("FNS_INV_0015GS.do", FormQueryString(formObj));
					//alert("sheetObj.RowCount : "+sheetObj.RowCount);
					if(sheetObj.RowCount > 0){
						if(ComShowCodeConfirm("INV00049")) {
							ComOpenWait(false); //대기이미지 숨김	
							//sheetObj.Down2Excel(-1);
							sheetObj.SpeedDown2Excel(-1);
						}else{
							//var downResult = sheetObj.Down2Excel(-1, false,false,true, filePath);
							var downResult = sheetObj.SpeedDown2Excel(-1, false,false,filePath);
							ComOpenWait(false); //대기이미지 숨김
							if(downResult){
								alert("Saved File Path : "+ filePath);
							}
						}
					}else{
						ComOpenWait(false); //대기이미지 숨김
					}
				}
                break;

			 case IBSAVE:        //저장
              if(validateForm(sheetObj,formObj,sAction))
                  alert (" Save .. ");
                break;

			case IBINSERT:      // 입력
                break;
        }
    }
    
    /** 
     * combo List에 데이타를 세팅하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} cmbObj : 폼 오브젝트
     * @param  {String} arrStr : | 구분자로 구분되는 스트링 문자
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function MakeComboObject2(cmbObj, arrStr) {
  	 	cmbObj.RemoveAll(); 
  		for (var i = 1; i < arrStr.length;i++ ) {
  			var arrStr2 = arrStr[i].split("^");  			
  			var ar_ofc_cd = arrStr2[1];
  			cmbObj.InsertItem(i-1, arrStr[i], arrStr[i]);
  		}
  		cmbObj.InsertItem(0, "ALL", "ALL");
  		cmbObj.BackColor = "#CCFFFD";
  	 }    


    
  	/** 
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
      * @return true, false
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */ 
	function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
    		case IBSEARCH:
    		//alert(form.cust_flag[1].checked+"::"+formObj.ofc.text);
    		//alert(ComIsNull(formObj.cust_flag[0])+"::"+ComIsNull(formObj.ofc));
            	if (ComIsNull(formObj.cust_flag[0])) {            		
    				ComShowCodeMessage('INV00041');
    				ComSetFocus(form.cust_flag);
    				return false;
    			}
            	//sales customer && ALL office  데이터량이 많아서 조회제한
    			if (form.cust_flag[1].checked && formObj.ofc.text=="ALL" ) {
    				ComShowCodeMessage('INV00174');
    				ComSetFocus(form.ofc);
    				return false;
    			}
    			break;
    		case MULTI:

    			break;
    	}
    	return true;
    }

	/** 
     * Option 선택에 따라 CreditCustomer Office, SalesCustomer Office 조회 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  
     * @return
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
	function fn_custFlag() {
   		if(form.cust_flag[0].checked){  
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
   		} 
   		if(form.cust_flag[1].checked){  
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC20);
   		} 

	}
	
	/* 개발자 작업  끝 */