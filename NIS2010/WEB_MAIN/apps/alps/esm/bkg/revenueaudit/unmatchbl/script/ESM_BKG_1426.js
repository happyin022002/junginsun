/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1426.js
*@FileTitle : Multi Rate BKG List for Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.19
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2016.08.19 조정민
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
     * @class esm_bkg_1426 : esm_bkg_1426 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1426() {
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


    var sheetObjects = new Array();
    var sheetCnt = 0;

    
    var comboObjects = new Array();
    var comboCnt = 0;
    

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author 조정민
	  * @version 2009.04.17
	  */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		         var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

            	switch(srcName) {
	    	        case "btns_calendar1": //달력버튼
			        	var cal = new ComCalendar();
			        	cal.select(form.from_dt, 'yyyy-MM-dd');
			        	break;
	        
	    	        case "btns_calendar2":
				        var cal = new ComCalendar();
				        cal.select(form.to_dt, 'yyyy-MM-dd');
				        break;
            	
					case "btn_Retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						break;
					
					case "btn_New":
						removeAll(formObject);
						break;
					

					case "btn_DownExcel":						
						sheetObjects[0].Down2Excel(-1);
						break;

					case "btn_com_ens_ob2":
						var param = "";
			    		//param = param + "lane_cd=" + ComGetObjValue(form.vsl_slan_cd);
						//param = "loc_cd="+ComGetObjValue(form.pol_cd);
			    		//param = param + "&" + "pod_cd="+ComGetObjValue(form.pod_cd);
			    		param = param + "&" + "vvd_cd=" + form.t_vvd.value;
			    		//param = param + "&" + "etd_cd="+form.etd_cd.value;
			    		ComOpenPopup('/hanjin/COM_ENS_0B2.do?' + param, 780, 470, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
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
          * IBSheet Object를 배열로 등록 <br>
          * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
          * 배열은 소스 상단에 정의 <br>
          * <br><b>Example :</b>
          * <pre>
          *     setSheetObject(sheetObj);
          * </pre>
          * @param {ibsheet} sheet_obj 필수 IBSheet Object
          * @return 없음
          * @author 조정민
          * @version 2009.04.17
          */
        function setSheetObject(sheet_obj){

           sheetObjects[sheetCnt++] = sheet_obj;
    			
        }
        /**
         * IBMulti Combo Object를 배열로 등록 <br>
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
         * 배열은 소스 상단에 정의 <br>
         * <br><b>Example :</b>
         * <pre>
         *     setComboObject(combo_obj);
         * </pre>
         * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
         * @return 없음
         * @author 조정민
         * @version 2009.04.17
         */ 
        function setComboObject(combo_obj){
     		comboObjects[comboCnt++] = combo_obj;
     	}
        
        /**
         * Sheet 기본 설정 및 초기화 <br>
         * body 태그의 onLoad 이벤트핸들러 구현 <br>
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     loadPage();
         * </pre>
         * @return 없음
         * @author 조정민
         * @version 2009.04.17
         */
        function loadPage() {

        	 var form = document.form;

        	 
 			//IBMultiCombo초기화
      	    for(var k = 0; k < comboObjects.length; k++){
      	        initCombo(comboObjects[k], k + 1);
      	    }
     
			for(i=0;i<sheetObjects.length;i++){
				//khlee-시작 환경 설정 함수 이름 변경
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
				//khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
			}

     		axon_event.addListenerForm('keypress', 'obj_keypress', document.form);			
     	    axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
   		    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
   	        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		    
   	    
    	}
        
        function sheet1_OnLoadFinish(sheetObj) {
// Error Status 칼럼을 강제로 Merge 시키는 Script 가 IBSheet Error 를 발생시켜서 임시로 막아둠.         	 
//       	 sheetObj.SetMergeCell (0, 20, 2, 2);
	       	initIBComboItem();
        } 
        
        
        
        function obj_deactivate() {
        	var form = document.form;
        	var formObj = event.srcElement;
            var srcName = formObj.getAttribute("name");
            switch(srcName) {
            
	    		case "t_vvd":
	    		case "ctrt_no":
	    			break;
        		default :
        			ComChkObjValid(formObj);

        	}

        }
/** 
* Object 의 Keypress 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.21
*/ 
function obj_keypress(){
	var obj = event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus = obj.dataformat;
	switch(obj.dataformat){
 	case "ymd": //날짜 입력하기
		ComKeyOnlyNumber(obj,"-"); 
		break;
 	case "int": //숫자만 입력
 	case "number": //숫자만 입력 	
 		ComKeyOnlyNumber(obj);
 		break;
 	case "engup":
 		ComKeyOnlyAlphabet('upper');
 		break;
 	case "uppernum":
 		ComKeyOnlyAlphabet('uppernum');

 		break;
 	default:
 		//ComKeyOnlyNumber(obj);
 		break;
	}
}         
		

 
 /**
  * OnBeforeActivate   event를 처리한다. <br>
  * <br><b>Example :</b>
  * <pre>
  *     obj_activate()
  * </pre>
  * @param 없음
  * @return 없음
  * @author 조정민
  * @version 2009.04.17
  */  
 function obj_activate() {
 	ComClearSeparator (event.srcElement);	   
 }
 
     	/**
         * IBSHEET COMBO를 LOAD하는 함수<br>
         * <br><b>Example :</b>
         * <pre>
         * 		initCombo(comboObj, comboNo)
         * </pre>
         * @return 없음
         * @author 조정민
         * @version 2009.06.10
         */ 
        function initCombo(comboObj, comboNo) {
            switch(comboObj.id) {
            case "rct_rhq_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;
                            
            case "bkg_ofc_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;
                

            
            case "bkg_ctrt_tp_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(2, 2);    // 영문대문자만 입력 + 특수문자
                }
                break;      
                
    
                
            case "bdr_flg":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(1, 2);    // 영문만 입력 + 특수문자
                }
                break;     

            }
      	}

        /**
         * rct_rhq_cd 변경시 활성화됨<br>
         * qttn_ver_no로 조회한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj    필수,comboObj Object
         * @param {String} code    
         * @param {String} text 
         * @return 없음   
         * @author 조정민
         * @version 2009.06.10
         */ 
        function rct_rhq_cd_OnChange(comboObj, code, text) {
        	
        	if(comboObj.Index == "0") {
 				comboObjects[1].removeAll();
 				return;
 			}	
        		
     		if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
     			
 				var formObj = document.form;
 				formObj.etc2.value 	= code;
 				
 				// 조직도 combo2
 	        	formObj.f_cmd.value = COMMAND02;
 				var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
 				ComXml2ComboItem(sXml, formObj.bkg_ofc_cd, "cd", "cd");
 				formObj.bkg_ofc_cd.Code = formObj.strOfc_cd.value;
 				formObj.bkg_ofc_cd.InsertItem(0,'','');
     		} 
     		
       	}
        
        


 /**
  * IBMultiCombo 에 Item을 setting한다. <br>
  * <br><b>Example :</b>
  * <pre>
  *     initIBComboItem();
  * </pre>
  * @return 없음
  * @author 김대호
  * @version 2009.12.15
  */
function initIBComboItem() {
	
	ComBkgTextCode2ComboItem(rhqComboValue,          rhqComboValue,         getComboObject(comboObjects, 'rct_rhq_cd'),         "|", "\t" );
    ComBkgTextCode2ComboItem(scpComboValue,			 scpComboText,		    getComboObject(comboObjects, 'svc_scp_cd'),         "|", "\t" );
	ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'),     "|", "\t" );

	document.form.bdr_flg.InsertItem(0,'','');
	document.form.bdr_flg.InsertItem(1,'Yes','Y');
	document.form.bdr_flg.InsertItem(2,'No','N');
	
	document.form.por_pol_equals.InsertItem(0,'','');
    document.form.por_pol_equals.InsertItem(1,'Yes','Y');
    document.form.por_pol_equals.InsertItem(2,'No','N');
    
    document.form.pod_del_equals.InsertItem(0,'','');
    document.form.pod_del_equals.InsertItem(1,'Yes','Y');
    document.form.pod_del_equals.InsertItem(2,'No','N');
    
    document.form.multi_cntr.InsertItem(0,'','');
    document.form.multi_cntr.InsertItem(1,'Yes','Y');
    document.form.multi_cntr.InsertItem(2,'No','N');

}

       /**
        * 시트 초기설정값, 헤더 정의 <br>
        * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
        * <br><b>Example :</b>
        * <pre>
        *     initSheet(sheetObj,1);
        * </pre>
        * @param {ibsheet} sheetObj 필수 IBSheet Object
        * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
        * @return 없음
        * @author 조정민
        * @version 2009.04.17
        */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
    var sheetID = sheetObj.id;
    switch(sheetID) {
    


		case "sheet1":      //sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = 370;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                //MergeSheet = msHeaderOnly;
                MergeSheet = msPrevColumnMerge + msHeaderOnly;
               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
	            InitRowInfo(2, 1, 2, 100);
	            var HeadTitle1 = "BKG No|Service\nScope|Application\nDate|BDR|Contract\nType|Contract No|Commodity|Commodity|Cargo Type|Cargo Type|Cargo Type|Cargo Type|Cargo Type|Cargo Type|POR|POL|POD|DEL|T/VVD|POR = POL|POD = DEL|Multi CNTR|";
	            var HeadTitle2 = "BKG No|Service\nScope|Application\nDate|BDR|Contract\nType|Contract No|Code|Name|DG|RF|AK|BB|RD|HG|POR|POL|POD|DEL|T/VVD|POR = POL|POD = DEL|Multi CNTR|";
	           
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
	            
	            //해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false, false);
	            
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, true);
	            
	            
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtPopup,   110, daCenter,	true,	"bkg_no",		  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,		60, daCenter,	true,	"svc_scp_cd",	  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,		80, daCenter,	true,	"rt_aply_dt",	  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,		50, daCenter,	true,	"bdr_flg",		  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,		60, daCenter,	true,	"ctrt_tp_cd",	  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,		90, daCenter,	true,	"ctrt_no",		  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,		60, daCenter,	true,	"cmdt_cd",		  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,	   190, daLeft,		true,	"cmdt_nm",		  false,	"",  dfNone,	0,	true,	true);
	    		InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,	"dcgo_flg",		  false,	"",  dfNone,	0,	true,	true);
	    		InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,	"rc_flg",		  false,	"",  dfNone,	0,	true,	true);
	    		InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,	"awk_cgo_flg",	  false,	"",  dfNone,	0,	true,	true);
	    		InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,	"bb_cgo_flg",	  false,	"",  dfNone,	0,	true,	true);
	    		InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,	"rd_cgo_flg",	  false,	"",  dfNone,	0,	true,	true);
	    		InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,	"hngr_flg",		  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,		63, daCenter,	true,	"por_cd",		  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,		63, daCenter,	true,	"pol_cd",		  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,		63, daCenter,	true,	"pod_cd",		  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,		63, daCenter,	true,	"del_cd",		  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,		80, daCenter,	true,	"t_vvd",		  false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,     80, daCenter,   true,   "por_pol_equals", false,    "",  dfNone,    0,  true,   true);
                InitDataProperty(0, cnt++ , dtData,     80, daCenter,   true,   "pod_del_equals", false,    "",  dfNone,    0,  true,   true);
                InitDataProperty(0, cnt++ , dtData,     80, daCenter,   true,   "multi_cntr",     false,    "",  dfNone,    0,  true,   true);
                InitDataProperty(0, cnt++ , dtHidden,	80, daCenter,	true,	"bl_cnt",         false,	"",  dfNone,	0,	true,	true);
                
                ShowButtonImage = 2;
				CountPosition = 0;
           }
            break;

    }
}



        /**
         * Sheet관련 프로세스 처리 <br>
         * <br><b>Example :</b>
         * <pre>
         
         *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {form} formObj 필수 html form object
         * @param {int} sAction 필수 프로세스 플래그 상수
         * @return 없음
         * @author 조정민
         * @version 2009.04.17
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
        	 
            sheetObj.ShowDebugMsg = false;
            
			var form = document.form;
            
            switch(sAction) {
              
            	case IBSEARCH:      //조회

            		if (validateForm(sheetObj,formObj,sAction)) {

        	    		ComOpenWait(true);		
        	    		sheetObj.WaitImageVisible = false;
            			formObj.f_cmd.value = SEARCH;
            			var sXml = sheetObj.GetSearchXml("ESM_BKG_1426GS.do" , FormQueryString(formObj));
            			sheetObj.LoadSearchXml(sXml);    // Grid1.
        	 			
        				ComOpenWait(false);        		
            			
    	        	}    
            	    break;
	        	
            }
            
        }


        /**
		 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
		 * <br><b>Example :</b>
		 * <pre>
		 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
		 *         로직처리;
		 *     }
		 * </pre>
		 * @param {ibsheet} sheetObj 필수 IBSheet Object
		 * @param {form} formObj 필수 html form object
		 * @param {int} sAction 필수 프로세스 플래그 상수
		 * @return bool <br>
		 *          true  : 폼입력값이 유효할 경우<br>
		 *          false : 폼입력값이 유효하지 않을 경우
		 * @author 조정민
		 * @version 2009.04.17
		 */
        function validateForm(sheetObj,formObj,sAction){
       	  switch (sAction) {
       	  
   	 		case IBSEARCH: // 조회

		 		var fmDtObj = form.from_dt;
		 		var toDtObj = form.to_dt;
				var fmDtValue = fmDtObj.value.replace(/-/g,'');
				var toDtValue = toDtObj.value.replace(/-/g,'');
				
				if("" == comboObjects[0].Code){
					ComShowCodeMessage("BKG95025", "RHQ"); 
					ComSetFocus(fmDtObj);
					return false;
				}
 		 		if("" == fmDtValue || "" == toDtValue){
					 ComShowCodeMessage("BKG95025", "Date"); // "Please input {?msg2}."
					 if("" == fmDtValue) {
	 					 ComSetFocus(fmDtObj);
					 }else{
	 					 ComSetFocus(toDtObj);
					 }
					 return false;
		 		}

	    		if(!ComChkObjValid(fmDtObj)) { return false; }
	    		if(!ComChkObjValid(toDtObj)) { return false; }

				if(!chkDate(formObj)) {  return false; }
   	 	


            return true;
       	  }
        }
    	



 	     
 	/**
	 * 화면을 전체 리셋한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     removeAll(formObj)
	 * </pre>
	 * @param {formObj} formObj    
	 * @return 없음
	 * @author 조정민
	 * @version 2009.06.10
	 */
  	 	function removeAll(formObj) {
  	 		
  	 		formObj.reset();
  	 		/***************************************/
  	 		comboObjects[1].removeAll(); // 순서중요
  	 		comboObjects[0].Index = "-1"; // 		
  	 		/***************************************/
  	 		comboObjects[2].Index = "-1";
  	 		comboObjects[3].Index = "-1";
  	 		sheetObjects[0].RemoveAll();
  	 	
  	 	
  		} 
  	 	
  	 	function setCallBack0B2(aryPopupData) {
  	 		var form = document.form;
  	 		//form.etd_cd.value = ComGetMaskedValue(aryPopupData[0][5], "ymd");
  	 		//var strValue = aryPopupData[0][7];
  	 		form.t_vvd.value = aryPopupData[0][7];
  	 		//form.vsl_cd.value = strValue.substr(0,4);
  	 		//form.skd_voy_no.value = strValue.substr(4,4);
  	 		//form.skd_dir_cd_txt.value = strValue.substr(8);
  	 	} 

  	 	function chkDate(formObj) {
  	 		
  	 		var form = document.form;
  	 		
  	 	    var fmDtObj  = form.from_dt;
  	 	    var toDtObj    = form.to_dt;
  	 		var fmDtValue = fmDtObj.value.replace(/-/g,'');
  	 		var toDtValue   = toDtObj.value.replace(/-/g,'');

  	 		if(fmDtValue != "" && toDtValue != "") {

  	 			if( parseInt(fmDtValue,10) > parseInt(toDtValue,10) ) {
  	 				ComShowCodeMessage("BKG95026", "From Date", "To Date");
  	 				event.returnValue = false;			
  	 				ComSetFocus(formObj);
  	 				return false;
  	 			}

  	 			var fromAddDays = ComGetDateAdd(fmDtValue, "D", 99, "", true); // 100일

  	 			if( parseInt(toDtValue,10) > parseInt(fromAddDays,10)  ) {
  	 				ComShowCodeMessage("BKG95027", "100 days"); // "The period of Date can't be over {?msg1}."
  	 				event.returnValue = false;		
  	 				ComSetFocus(formObj);
  	 				return false;
  	 			}
  	 		}
  	 			

  	 		return true;
  	 	}
  	 	
  	 	
  	 	
  	 	function sheet1_OnPopupClick(sheetObj, Row, Col) {
  		 	var form = document.form;
  		 	var colName = sheetObj.ColSaveName(Col);
  			var sName      = sheetObj.ColSaveName(Col);
  			var scRfaNo    = sheetObj.CellValue(Row, "ctrt_no");	
  			var ctrtTpCd   = sheetObj.CellValue(Row, "ctrt_tp_cd");	
  			var bkgNo 	   = sheetObj.CellValue(Row, "bkg_no");    	
  		 	switch(colName){
  		 		case "bkg_no":
  			    	if(null == bkgNo || "" == bkgNo) { return; }
  			    	var popParams = "bkg_no=" + bkgNo + "&openTab=B8";
  			    	comRASCallPop("ESM_BKG_0079", "ESM_BKG_1423", popParams, "");
  					break;
  		 	
//  				case "ctrt_no":
//  		        	if(null == scRfaNo || "" == scRfaNo) { return; }
//  		    		var pgmNo = "ESM_PRI_0004";
//  		    		var scRfaNoP = scRfaNo.substr(0, 3);
//  		    		var scRfaNoS = scRfaNo.substr(3);
//  		        	var popParams = "sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS + "&eff_dt=" + form.fm_dt.value + "&exp_dt=" + form.to_dt.value;
//  			    	if(ctrtTpCd == "RFA") { // RFA
//  			    		pgmNo = "ESM_PRI_2019";
//  			    		popParams = "s_rfa_no=" + scRfaNo;
//  			    	}
//  			    	else if(ctrtTpCd == "T") { // TAA
//  			    		pgmNo = "ESM_PRI_3007";
//  			    		popParams = "cond_taa_no=" + scRfaNo;  
//  			    	}
//  		        	comRASCallPop(pgmNo, "ESM_BKG_1423", popParams, "");
//  					break;
  					
  			 	}
  	}
 	function sheet1_OnSearchEnd(sheetObj, errMsg) {
 	    var form = document.form;
 	    if(sheetObj.RowCount > 0){
 	    	form.bl_cnt.value = sheetObj.CellValue(2,"bl_cnt");
 	    }else{
 	    	form.bl_cnt.value = "0";
 	    }

 	}   
	/* 개발자 작업  끝 */