/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0440.js
*@FileTitle : ESM_BKG-0440
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
* 2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
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
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0440() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick         = sheet1_OnClick;
    }
    
   	/* 개발자 작업	*/
    
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1; 

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
    	/*******************************************************/
    	var formObject = document.form;
    	
    	try {
       		var srcName = window.event.srcElement.getAttribute("name");
       		var sUrl = "";
       		var sId = "";
       		switch(srcName) {
       		case "btn_new":
					initForm(formObject);
					break;
			
       		case "btn_search":
    			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
    			break;
    			
       		case "btn_1":
    			doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
    			break;
       		case "btn_2":
    			doActionIBSheet(sheetObjects[0], formObject, COMMAND02);
    			break;
       		case "btn_3":
    			doActionIBSheet(sheetObjects[0], formObject, COMMAND03);
    			break;
       		case "btn_4":
    			doActionIBSheet(sheetObjects[0], formObject, COMMAND04);
    			break;
       		case "btn_5_1":
       			doActionIBSheet(sheetObjects[0], formObject, COMMAND05); 
       			break;
       		case "btn_6_1":
       			doActionIBSheet(sheetObjects[0], formObject, COMMAND06);
    			break;
       		case "btn_7":
       			doActionIBSheet(sheetObjects[0], formObject, COMMAND07);
    			break;
       		case "btn_8":
       			doActionIBSheet(sheetObjects[0], formObject, COMMAND08);
    			break;
       		case "btn_9":
    			doActionIBSheet(sheetObjects[0], formObject, COMMAND09);
    			break;
       		case "btn_10":
       			doActionIBSheet(sheetObjects[0], formObject, COMMAND10);
    			break;
       		case "btn_11":
       			doActionIBSheet(sheetObjects[0], formObject, COMMAND11);
    			break;
				 				
            } // end switch
            //if (sId != "") module_pop(sUrl, sId);
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    function module_pop(url, id) {
        try {
            var iWidth = 1200;
            var iHeight = 650;
            var leftpos = (screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
            var toppos  = (screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
            var sFeatures = "status=no, width="+iWidth+", height="+iHeight+", resizable=yes, scrollbars=yes, left="+leftpos+", top="+toppos;
            var winObj = window.open("/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^" + url, id, sFeatures);
            winObj.focus();
        } catch(err) { alert(err.message); }
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;
			
    }
     
     function initForm(formObj){    	 
    	 formObj.frm_crn_number.value = "";
    	 formObj.frm_vvd_number.value = "";
    	 formObj.frm_vps_eta_dt.value = "";
    	 formObj.frm_pod_clpt_ind_seq.value = "";
    	 sheetObjects[0].RemoveAll();
     }



    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */                    
    function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
	        //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form, INIT);

		//화면에서 필요한 이벤트
    	 
		var formObject = document.form;
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
    				
        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 100;
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

                    var HeadTitle1 = "|crn_number|vsl_call_ref_no|vsl_cd|skd_voy_no|skd_dir_cd|vps_eta_dt|vsl_eng_nm|vvd_number|pod_clpt_ind_seq";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                                        
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	false,	"ibflag");
					
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"crn_number",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"vsl_call_ref_no",	false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"vsl_cd",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"skd_voy_no",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"skd_dir_cd",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"vps_eta_dt",		false,	"",	dfNone,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"vsl_eng_nm",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"vvd_number",		false,	"",	dfNone,	0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"pod_clpt_ind_seq",	false,	"",	dfNone,	0,	false,	false);
	            }
                break;
            }
        }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        
    	sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        
			case SEARCH:      //Retrieve
				
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true); 
					formObj.vsl_cd.value     = formObj.frm_vvd_number.value.substring(0,4);
					formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
					formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);	
					sheetObj.DoSearch("ESM_BKG_0440GS.do", FormQueryString(formObj));
                    
					if(sheetObj.RowCount > 0){
						//alert("test1");
						IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
						formObj.frm_crn_number.value = sheetObj.CellValue(1, "vsl_call_ref_no");
					}
					ComOpenWait(false); 
					
				}
			break;
			 
			 
			case COMMAND01:
				 
				var sUrl = "/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^ESM_BKG_0443.do&pgmNo=ESM_BKG_0443";
				ComOpenWindowCenter(sUrl, "ESM_BKG_0443", 1024, 700, false);
				
				break;	
				
				
			case COMMAND02:
				 
				var sUrl = "/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^ESM_BKG_0444.do&mainPage=true&pgmNo=ESM_BKG_0444&crn_no="+formObj.frm_crn_number.value+"&vvd_no="+formObj.frm_vvd_number.value;
				ComOpenWindowCenter(sUrl, "ESM_BKG_0444", 1024, 700, true);
				
				break;
				
				
			case COMMAND03:
				 
				var sUrl = "/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^ESM_BKG_0061.do&mainPage=true&&pgmNo=ESM_BKG_0061&crn_no="+formObj.frm_crn_number.value+"&vvd_no="+formObj.frm_vvd_number.value;
				ComOpenWindowCenter(sUrl, "ESM_BKG_0061", 1024, 720, true);
				
				break;
				
				
			case COMMAND04:
				 
				var sUrl = "/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^ESM_BKG_0442.do&mainPage=true&&pgmNo=ESM_BKG_0442&crn_no="+formObj.frm_crn_number.value;
				ComOpenWindowCenter(sUrl, "ESM_BKG_0442", 1024, 760, true);
				
				break;	
				
				
			case COMMAND05:
				 
				var sUrl = "/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^ESM_BKG_0450.do&pgmNo=ESM_BKG_0450&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM"
							+ "&from_pod_clpt_ind_seq="+formObj.frm_pod_clpt_ind_seq.value;
				ComOpenWindowCenter(sUrl, "ESM_BKG_0450", 1024, 750, false);	
							
				break;
				
				
			case COMMAND06:
				 
				var sUrl = "/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^ESM_BKG_0448.do&pgmNo=ESM_BKG_0448&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM"
							+ "&from_pod_clpt_ind_seq="+formObj.frm_pod_clpt_ind_seq.value;
				ComOpenWindowCenter(sUrl, "ESM_BKG_0448", 1024, 750, false);	
							
				break;
				
				
			case COMMAND07:
				 
				var sUrl = "/hanjin/alpsMain.screen?mainPage=true&parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^ESM_BKG_0381.do&pgmNo=ESM_BKG_0381&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM";
				ComOpenWindowCenter(sUrl, "ESM_BKG_0381", 1024, 750, true);
								
				break;
				
				
			case COMMAND08:
				 
				var sUrl = "/hanjin/alpsMain.screen?mainPage=true&parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^ESM_BKG_0240.do&pgmNo=ESM_BKG_0240&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM";
				ComOpenWindowCenter(sUrl, "ESM_BKG_0240", 1024, 750, true);		
						
				break;
				
				
			case COMMAND09:
				 
				var sUrl = "/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^ESM_BKG_0351.do&pgmNo=ESM_BKG_0351&crn_no="+formObj.frm_crn_number.value+"&vvd_no="+formObj.frm_vvd_number.value+"&pod_clpt_ind_seq="+formObj.frm_pod_clpt_ind_seq.value;
				ComOpenWindowCenter(sUrl, "ESM_BKG_0351", 1024, 750, true);		
						
				break;
				
				
			case COMMAND10:
				 
				var sUrl = "/hanjin/ESM_BKG_0728.do?pgmNo=ESM_BKG_0728&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM";
				ComOpenWindowCenter(sUrl, "ESM_BKG_0728", 1024, 750, true);
								
				break;
				
				
			case COMMAND11:
				 
				var sUrl = "/hanjin/alpsMain.screen?mainPage=true&parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^ESM_BKG_0001.do&pgmNo=ESM_BKG_0001&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM";
				ComOpenWindowCenter(sUrl, "ESM_BKG_0001", 1024, 750, true);	
							
				break;
			 
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	
    	   /*	
    	 with(formObj){
//           if (!isNumber(formObj.iPage)) {
//               return false;
//           }
       }
*/
    	switch (sAction) {
     		case SEARCH: // 조회
     			if (formObj.frm_vvd_number.value.length > 0 && formObj.frm_vvd_number.value.length < 9) {
     				ComShowCodeMessage('BKG00538');
     				formObj.combo_vvd_cd.focus();
     				return false;
     			}
     			if(!ComIsNull(formObj.frm_vvd_number) && ComIsNull(formObj.frm_pod_clpt_ind_seq)){
        			
        			ComShowCodeMessage('BKG00626','POD Calling Seq');
        			return false;
        		}
     			if(!ComIsNull(formObj.frm_vvd_number) && !ComIsNull(formObj.frm_pod_clpt_ind_seq) && formObj.frm_pod_clpt_ind_seq.value !="1" && formObj.frm_pod_clpt_ind_seq.value!="2"){
     				ComShowCodeMessage('BKG02223');
        			return false;
        		}
     			
     			return true;
     			break;
    	}
    	return true;
    }    
   /**
    * 
    * @return
    */ 
   function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");		
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	if (srcName == "frm_crn_number" && ComIsKorean(formObject.frm_crn_number.value)) 
    	{				    			
    			formObject.frm_crn_number.focus();			 
    	}
    }
    	 
    /**
    * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
    **/
    function obj_keypress() {
    	
    	 	switch(event.srcElement.dataformat){
    	 	case "uppernum":
             //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
             ComKeyOnlyAlphabet('uppernum');
             break;
    	 	default:
             //숫자만입력하기(정수,날짜,시간)
             ComKeyOnlyNumber(event.srcElement);
    	 	}
    	    	var formObject = document.form;
    	    	var srcName = window.event.srcElement.getAttribute("name");
    	    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	    	var srcValue = window.event.srcElement.getAttribute("value");
    	    	var crn_number = formObject.frm_crn_number.value;
    	    	var vvd_cd     = formObject.frm_vvd_number.value; 
    	    	if(window.event.keyCode == 13)
    	    	{
    	    		if (srcName == "frm_crn_number" && crn_number.length > 0 && crn_number.length != 13 ) 
        	      	{
        	      		ComShowCodeMessage('BKG00537');
        	      		formObject.frm_crn_number.focus(); 			 
        	      	}
    	    		if (srcName == "frm_crn_number" && crn_number.length > 0 && crn_number.length != 13 ) 
    	          	{
    	          		ComShowCodeMessage('BKG00537');
    	          		formObject.frm_crn_number.focus(); 			 
    	          	}
    	          	if (srcName == "frm_vvd_number" && vvd_cd.length > 0 && vvd_cd.length < 9 ) 
    	          	{
    	          		ComShowCodeMessage('BKG00538');
    	          		formObject.frm_vvd_number.focus(); 			 
    	          	}
    	          	if (ComChkLen(srcValue, srcMaxLength) == "2") {
        	    		ComSetNextFocus();        	    		
        	    	}
    	        	if (srcName == "frm_vvd_number" && vvd_cd.length == 9)
    	        	{
    	        		doActionIBSheet(sheetObjects[0],document.form,SEARCH);
    	            	
    	        		
    	        	} else if (srcName == "frm_vvd_number" || srcName == "frm_crn_number")
    	          	{
    	          		//alert("here2");
    	          		if ( crn_number.length > 0 && crn_number.length == 13 && vvd_cd.length == 0 )
    	          		{
    	          			formObject.frm_pod_clpt_ind_seq.value = "";
    	          			
    	          			doActionIBSheet(sheetObjects[0],document.form,SEARCH);    	          			 
    	          		}else if ( crn_number.length == 13 && vvd_cd.length == 9  ){
    	          			
    	          			doActionIBSheet(sheetObjects[0],document.form,SEARCH);
        	            	
    	          		}
    	          		
    	          	} else if (srcName == "frm_pod_clpt_ind_seq"){
    	          		
    	          		if (vvd_cd.length > 0 && vvd_cd.length < 9 ) 
        	          	{
        	          		ComShowCodeMessage('BKG00538');
        	          		formObject.frm_vvd_number.focus();
        	          		
        	          	}else if(vvd_cd.length==0){
        	          		ComShowCodeMessage('BKG00754');
        	          		formObject.frm_vvd_number.focus();
        	          		
        	          	}else if (vvd_cd.length==9){
        	          		if(crn_number.length>0 && crn_number.length<13){
        	          			ComShowCodeMessage('BKG00537');
        	          		}else{
        	          			doActionIBSheet(sheetObjects[0],document.form,SEARCH);
        	          		}
        	          	}
    	          	}
    	          		
    	    	}
    	 	
     }
    
    
	/* 개발자 작업  끝 */