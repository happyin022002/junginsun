/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0668_01.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.06.16 안진응
* 1.0 Creation
* History
* 2010.10.05 이지영 [CHM-201006263-01] INBOUND C/S USA_INSTRUCTION MAX 변경 요청
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
     * @class esm_bkg_0668_01 : esm_bkg_0668_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0668_01() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업  */

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    var t1beforetab = 1;
    var t3beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    
    var t1sheet1 = 0;
    var t1sheet3 = 1;
    var t1sheet1_1 = 2;
    var t1sheet1_2 = 3;
    var t1sheet1_3 = 4;
    var t1sheet5 = 5;
    var t1sheet6 = 6;
    
//  var t1sheet2 = 1;
//  var t1sheet4 = 3;
//  var t1sheet7 = 9;

    var sheet2   = 0;
    
    var t1BkgNo = "";
    var t2BkgNo = "";
    var t3BkgNo = "";
    var t4BkgNo = "";
    var t5BkgNo = "";
    var t6BkgNo = "";

    var t1BlNo = "";
    var t2BlNo = "";
    var t3BlNo = "";
    var t4BlNo = "";
    var t5BlNo = "";
    var t6BlNo = "";
    
    var comboFlg = null;
    var cntrQtySum = 0;
    
    var chgFlag = null;
    var frt_term_cd = null;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

    				case "btn_retrieve":
    					if (formObject.h_old_bl_no.value != formObject.combo_bl_no.text ||
                    			formObject.h_old_bkg_no.value != formObject.bkg_no.value) {
                    		
                    		// 검색조건이 변경된 경우에는 기존에 조회된 데이터를 모두 Clear한다.
                    		fnBlInfoClear();
                    		
                    		fnSearch();		//조회 처리 모듈을 호출한다.
                    	} else {
                    		fnSearch();			//조회 처리 모듈을 호출한다.
                    	}
                        break;

                    case "btn_new":
                    	fnQueryCondClear();
                        break;

                    case "btn_inquiry":
                    	if(ComIsEmpty(document.form.combo_bl_no.text) && ComIsEmpty(document.form.bkg_no.value)){
                            ComShowCodeMessage('BKG40031', document.form.combo_bl_no.text);
                            document.form.combo_bl_no.focus();
                            return false;
                        }
                    	
                    	var bkg_no = document.form.bkg_no.value;
                    	var bl_no  = document.form.combo_bl_no.text;
            	        var strTemp = bl_no.substring(bl_no.length-1);
            	        
            	        if (strTemp == "W" || strTemp == "S" || strTemp == "B") {
                	        bl_no = bl_no.substring(0, bl_no.length-1);
            	        }
            	        
                    	var param="?bkg_no="+bkg_no+ "&bl_no="+bl_no + "&pgmNo=ESM_BKG_0034-01";                	
                    	ComOpenWindow("/hanjin/ESM_BKG_0034.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:700px;dialogLeft:0;dialogTop:0", true);
                        break;
                    	
                    case "btn_history":
                    	
                    	if(ComIsEmpty(document.form.combo_bl_no.text) && ComIsEmpty(document.form.bkg_no.value)){
                            ComShowCodeMessage('BKG40031', document.form.combo_bl_no.text);
                            document.form.combo_bl_no.focus();
                            return false;
                        }
                    	
                    	var bkg_no = document.form.bkg_no.value;
                    	var param="?bkg_no="+bkg_no+ "&pgmNo=ESM_BKG_0566";                	
                    	ComOpenWindow("/hanjin/ESM_BKG_0566.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:900px;dialogHeight:700px;dialogLeft:0;dialogTop:0", true);
                        break;

                    case "btn_preview":
                    	if(ComIsEmpty(document.form.combo_bl_no.text) && ComIsEmpty(document.form.bkg_no.value)){
                            ComShowCodeMessage('BKG40031', document.form.combo_bl_no.text);
                            document.form.combo_bl_no.focus();
                            return false;
                        }
                    	
                    	var bkg_no = document.form.bkg_no.value;
                    	var blNo   = document.form.combo_bl_no.text;
            	        var blType = "";

//            	        var strTemp = blNo.substring(blNo.length-1);
//            	        
//            	        if (strTemp == "W") {
//                	        blType = "W";
//            	        } else {
//            	        	blType = "";
//            	        }
                    	
            			var param = 'bkg_no=' + bkg_no + '&pgmNo=ESM_BKG_0927' + '&bl_tp_cd=D&form_level=6';
            			var url = "ESM_BKG_0927.do?" + param;
            			ComOpenWindow("/hanjin/ESM_BKG_0927.do?" + param, "PopupEsmBkg0927", "scroll:yes;status:no;help:no;dialogWidth:900px;dialogHeight:700px;dialogLeft:0;dialogTop:0", true);
            			break;                	
                     
                    case "btn_BkgMain":
                    	if(ComIsEmpty(document.form.combo_bl_no.text) && ComIsEmpty(document.form.bkg_no.value)){
                            ComShowCodeMessage('BKG40031', document.form.combo_bl_no.text);
                            document.form.combo_bl_no.focus();
                            return false;
                        }
                    	
                    	var bkgNo = document.form.bkg_no.value;

//            	        var strTemp = blNo.substring(blNo.length-1);
//            	        
//            	        if (strTemp == "W" || strTemp == "S") {
//            	        	blNo = blNo.substring(0, blNo.length-1);
//            	        }
            	        
//                    	var param="?pgmNo=ESM_BKG_0079&bkg_no="+bkgNo;                	
//                    	ComOpenWindow("/hanjin/ESM_BKG_0079.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:700px;dialogLeft:0;dialogTop:0", true);

                    	var sUrl = "/hanjin/alpsMain.screen";
    		        	sUrl += "?parentPgmNo=ESM_BKG_M001";
    		        	sUrl += "&pgmUrl=^hanjin^ESM_BKG_0079.do";
    		        	sUrl += "&pgmNo=ESM_BKG_0079";
    		        	sUrl += "&bkg_no="+bkgNo;
    		        	
    		        	comBkgCallPopBkgDetail(bkgNo);
    		        	
    		        	//ComOpenWindowCenter(sUrl, "ESM_BKG_0079", 1024, 768, true, 'yes');
                    	
                        break;
                    case "btn_charge":
                    	if(ComIsEmpty(document.form.combo_bl_no.text) && ComIsEmpty(document.form.bkg_no.value)){
                            ComShowCodeMessage('BKG40031', document.form.combo_bl_no.text);
                            document.form.combo_bl_no.focus();
                            return false;
                        }
                    	
                    	var bkgNo = document.form.bkg_no.value;
            	        
//                    	var param="?bkg_no="+bkgNo+ "&pgmNo=ESM_BKG_0079_08";                	
//                    	ComOpenWindow("/hanjin/ESM_BKG_0079_08.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:620px;dialogLeft:0;dialogTop:0", true);
                    	
    		        	var sUrl = "/hanjin/alpsMain.screen";
    		        	sUrl += "?parentPgmNo=ESM_BKG_M001";
    		        	sUrl += "&pgmUrl=^hanjin^ESM_BKG_0079.do";
    		        	sUrl += "&pgmNo=ESM_BKG_0079&openTab=B9";
    		        	sUrl += "&bkg_no="+bkgNo;
    		        	
    		        	comBkgCallPopBkgCharge(bkgNo);
    		        	
    		        	//ComOpenWindowCenter(sUrl, "ESM_BKG_0079", 1024, 768, false, 'yes');
                    	
                    	break;

        			case "btn_ts_route":
    					if (sheetObjects[t1sheet1].RowCount == 0) return;
    					if (document.form.bkg_no.value.length == 0) retuen;
    					
    					var bkg_no = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_bkg_no"); 
    					
    					param="?bkg_no="+bkg_no+ "&pgmNo=ESM_BKG_0650";
						
	                    ComOpenWindow("/hanjin/ESM_BKG_0650.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:710px;dialogHeight:310px;dialogLeft:0;dialogTop:0", true);

						break;
	    			case "btn_corr_flg":
	    				if (sheetObjects[t1sheet1].RowCount == 0) return;
	    				
	    				if (document.form.frm_t1sheet1_corr_flg.checked == true) {
	    					
	    					var bkg_no = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_bkg_no"); 
	    					
	    					param="?bkg_no="+bkg_no+ "&pgmNo=ESM_BKG_0651";
							
							ComOpenWindow("/hanjin/ESM_BKG_0651.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:700px;dialogHeight:400px;dialogLeft:0;dialogTop:0", true);							
	    				}
	
	    				break;
	    			case "btn_contract_no":
	    				if (sheetObjects[t1sheet1].RowCount == 0) return;
	    				
	                    if (sheetObjects[t1sheet1].CellValue(1,"t1sheet1_rfa_no").length > 0) {
	                        // RFA_NO 값이 존재하면 RFA 화면 호출
	                        var rfaNo = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_rfa_no"); 
	                        var pgmNo = "ESM_PRI_2019";
	                        var params = "?s_rfa_no=" + rfaNo+"&pgmNo=" + pgmNo;
	                        var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes"; 
//	                        ComOpenWindow("/hanjin/ESM_PRI_2019.do"+params, "myWin", sFeatures, false);
	                        ComOpenWindowCenter("/hanjin/ESM_PRI_2019.do"+params, "myWin", 1024, 700, true, "yes");
	                    } else {
	                        if (sheetObjects[t1sheet1].CellValue(1,"t1sheet1_sc_no").length > 0) {
	                            // SC 화면 호출
	                            var scRfaNo = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_sc_no");
	                            var pgmNo = "ESM_PRI_0004";
	                            var scRfaNoP = scRfaNo.substr(0, 3);
	                            var scRfaNoS = scRfaNo.substr(3);
	                            
	                            var params = "?sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS+ "&pgmNo=" + pgmNo;
	                            var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
//	                            ComOpenWindow("/hanjin/ESM_PRI_0004.do"+params, "myWin", sFeatures, false);
	                            ComOpenWindowCenter("/hanjin/ESM_PRI_0004.do"+params, "myWin", 1024, 700, true, "yes");
	                            
	                        }                  
	                    }
	    					
	    				
	    				break;
	    			case "btn_consignee":
	    				if (sheetObjects[t1sheet1].RowCount == 0) return;
	                    //Consignee의 값의 존재여부에 따라서 버튼을 활성화 시킴
	                    if (sheetObjects[t1sheet1].CellValue(1,"t1sheet1_csg_cust_nm").length > 0) {
	    					var bkg_no = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_bkg_no"); 
	    					
	    					param="?bkg_no="+bkg_no+"&tab_idx=0"+ "&pgmNo=ESM_BKG_0242";

	    					ComOpenWindow("/hanjin/ESM_BKG_0242.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:530px;dialogHeight:380px;dialogLeft:0;dialogTop:0", true);
	                    	
	                    }
	    				break;
	    			case "btn_notify":
	    				if (sheetObjects[t1sheet1].RowCount == 0) return;
	                    //Notify의 값의 존재여부에 따라서 버튼을 활성화 시킴
	                    if (sheetObjects[t1sheet1].CellValue(1,"t1sheet1_noy_cust_nm").length > 0) {
	    					var bkg_no = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_bkg_no"); 
	    					
	    					param="?bkg_no="+bkg_no+"&tab_idx=1"+ "&pgmNo=ESM_BKG_0242";
	    					
							ComOpenWindow("/hanjin/ESM_BKG_0242.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:530px;dialogHeight:380px;dialogLeft:0;dialogTop:0", true);
	                    
	                    }
	    				break;
	    			case "btn_a_notify":
	    				if (sheetObjects[t1sheet1].RowCount == 0) return;
	                    //A.Notify의 값의 존재여부에 따라서 버튼을 활성화 시킴
	                    if (sheetObjects[t1sheet1].CellValue(1,"t1sheet1_aoy_cust_nm").length > 0) {
	    					var bkg_no = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_bkg_no"); 
	    					
	    					param="?bkg_no="+bkg_no+"&tab_idx=2"+ "&pgmNo=ESM_BKG_0242";
							
							ComOpenWindow("/hanjin/ESM_BKG_0242.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:530px;dialogHeight:380px;dialogLeft:0;dialogTop:0", true);							
	                    }
	    				break;
	                case "btn_split":
	                	if (document.form.h_split.value != "red") return;
	                	
	                    document.form.xmlData.value = null;
	                    sheetObjects[sheetObjects.length-1].RemoveAll();
	                    doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND05);

	                	break;
	                	
	    			case "btn_c_flag":
	    				if (sheetObjects[t1sheet1].RowCount == 0) return;

	    				var bl_no = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_bl_no"); 
    					
    					param="?bl_no="+bl_no+ "&pgmNo=ESM_BKG_0041";

    					ComOpenWindowCenter("/hanjin/ESM_BKG_0041.do"+param, "ESM_BKG_0041", 1024, 650, false);
	                	break;
	                	
	    			case "btn_instruction":
	    				if (sheetObjects[t1sheet1].RowCount == 0) return;

	    				var bkg_no = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_bkg_no"); 
    					
    					param="?bkg_no="+bkg_no+ "&pgmNo=ESM_BKG_1093";

    					ComOpenWindowCenter("/hanjin/ESM_BKG_1093.do"+param, "ESM_BKG_0041", 1050, 400, false, "yes");
	                	break;
	    			
	    			case "btn_pu_history":
	    				if (sheetObjects[t1sheet1].RowCount == 0) return;

	    				var bl_no = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_bl_no"); 
    					
	    				param = "&autoSearchFlg=Y&sch_tp=B&bl_no=" + bl_no;
	    				ComOpenPopupWithTarget('/hanjin/ESM_BKG_0414.do?pgmNo=ESM_BKG_0414' + param, 1024, 680, "", "none", false);
	    				
	                	break;
	                	
	    			case "btn_customer": //formObject.cnee_cnt_cd.value formObject.cnee_cust_seq.value  
	    			
	    			if (sheetObjects[t1sheet1].RowCount == 0) return;
	    			var cust_cnt_cd = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_csg_cust_cd").substr(0,2);
	    			var cust_seq = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_csg_cust_cd").substr(2,5);
	    				ComOpenWindowCenter("/hanjin/ESM_BKG_0240.do?pgmNo=ESM_BKG_0240&autoSearchFlg=Y&cust_cnt_cd=" + cust_cnt_cd + "&cust_seq=" + cust_seq  , "cust2", 1024, 640, true);
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
         */
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++] = sheet_obj;
        }



        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	 
            for(i=0;i<sheetObjects.length;i++){
            	if (sheetObjects[i].id == "t1sheet3" || sheetObjects[i].id == "t1sheet1_1" || sheetObjects[i].id == "t1sheet1_2") {
                	ComConfigSheet (sheetObjects[i] );

                    initSheet(sheetObjects[i],i+1);

                    ComEndConfigSheet(sheetObjects[i]);            		
            	} else {
                    initSheet(sheetObjects[i],i+1);            		
            	}            	
            }

            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }

            //IBMultiCombo초기화
            for(var j=0;j<comboObjects.length;j++){
                initCombo(comboObjects[j],j+1);
            }
            
            sheet2 = sheetObjects.length - 2;
            
            initControl();
            
            if (document.form.bkg_no.value != "") {
            	fnSearch();
            }            
        }

         //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
         function setComboObject(combo_obj){
            comboObjects[comboCnt++] = combo_obj;
         }
         
         function initCombo(comboObj, comboNo) {
        	 comboObj.RemoveAll(); 
        	 comboObj.UseEdit = true; 
             comboObj.ValidChar(2, 1);		//영어 대문자, 숫자 입력 가능
             comboObj.IMEMODE = 0;			//IMEMODE = 영문
             comboObj.MaxLength = 13;
             comboObj.UseCode = true;
         }
         
         function initControl() {
        	 
//        	 axon_event.addListenerForm  ('blur',      'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
        	 axon_event.addListenerFormat('keypress',  'obj_keypress',    form); //- 키보드 입력할때
             axon_event.addListenerForm  ('click',     'obj_click',       form);        	 
             axon_event.addListenerForm	 ('beforedeactivate', 	'obj_066801_deactivate', form); //- 포커스 나갈때
             
             document.form.combo_bl_no.focus();
             
//             ifr.location.href="/hanjin/ESM_BKG_0668_09.do?blNo=" + "";
             
             fnButtonInit();
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
            case "sheet1":
                
            	with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

				    var HeadTitle1 = "|Seq.||B/L No.|CNEE Name|Bkg No.|B/L Type|SPLIT FLG";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
 
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    prefix = "sheet1_";

                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,	COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	true,		prefix + "ibflag");
 					InitDataProperty(0, cnt++ , dtSeq,					30,		daCenter,	false,		prefix + "Seq");
 					InitDataProperty(0, cnt++ , dtRadioCheck,           0,      daCenter,   false,      prefix + "radio",           false,      "",     dfNone,         0,      true,       true);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		prefix + "bl_no",	        false,		"",		dfNone,			0,		false,		true); 					
					InitDataProperty(0, cnt++ , dtData,					200,	daLeft,		false,		prefix + "cstms_desc",		false,		"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			        100,	daCenter,	false,		prefix + "bkg_no",		    false,		"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			        100,	daCenter,	false,		prefix + "bl_tp_cd",		false,		"",		dfNone,			0,		false,		true);
                    InitDataProperty(0, cnt++ , dtData,                 100,    daCenter,   false,      prefix + "split_flg",       false,      "",     dfNone,         0,      false,      true);
					
					CountPosition = 0;
			}
			break;

            case "sheet2":
            	
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "ibflag|partial|bl_no|bkg_no|split_no|bl_tp_cd";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    prefix = "sheet2_";
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,     30,	daCenter,  true,	 prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtData,      	    50,	daCenter,  false,    prefix + "partial",    		false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "bl_no",            	false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "bkg_no",   		    false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "split_flg", 		    false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,			    30,	daCenter,	false,	 prefix + "bl_tp_cd",		    false,		    "",		dfNone,			0,		false,		true);
					
					CountPosition = 0;

               }
            	break;
			
            case "t1sheet1":
            	
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "ibflag|arrival_vvd|arrival_vvd_nm|partial|vps_eta_dt|vps_etb_dt|slan_cd|rcv_term_cd|de_term_cd|por_cd|pol_cd|pod_cd|pod_nm|del_cd|del_nm|bkg_sts_cd|bdr_flg|corr_usr_id|pck_qty|pck_tp_cd|act_wgt|wgt_ut_cd|sc_no|rfa_no|cstms_desc|us_obl_rdem_flg|obl_rdem_dt|obl_rdem_ofc_cd|shp_cust_cd|shp_cust_nm|csg_cust_cd|csg_cust_nm|noy_cust_cd|noy_cust_nm|aoy_cust_cd|aoy_cust_nm|bl_no|bkg_no|split_no|bkg_cre_dt|bkg_ofc_cd|bl_tp_cd|Customs Clearance|Filer|MIB No.|IT Date|cstms_clr_cd|cstms_clr_lst_dt|evnt_ofc_cd|frtCltFlg|hisSeq|frtCltLstDt|frtCltOfcCd|tot_ots_sts_cd|tot_ots_curr_cd1|tot_ots_curr_cd2|tot_ots_curr_cd3|tot_ots_curr_cd4|tot_ots_curr_cd5|tot_ots_amt1|tot_ots_amt2|tot_ots_amt3|tot_ots_amt4|tot_ots_amt5|pod_yd_cd|del_yd_cd|instruction|coll_ofc_cd|free_trd_zn_flg|dir_de_flg";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    prefix = "t1sheet1_";
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,     30,	daCenter,  true,	 prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtData,			    40,	daCenter,  false,    prefix + "arrival_vvd",    	false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      	    50,	daCenter,  false,    prefix + "arrival_vvd_nm",    	false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      	    50,	daCenter,  false,    prefix + "partial",    		false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		90,	daCenter,  false,    prefix + "vps_eta_dt",    	    false,          "",      dfNone,      0,     false);

					InitDataProperty(0, cnt++ , dtData,         	90,	daCenter,  false,    prefix + "vps_etb_dt",         false,          "",      dfNone,      0,     false);										
					InitDataProperty(0, cnt++ , dtData,      	    50,	daCenter,  false,    prefix + "slan_cd",    		false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		60,	daCenter,  false,    prefix + "rcv_term_cd",        false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "de_term_cd",    		false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,    	        30,	daCenter,  true,	 prefix + "por_cd",    		    false,          "",      dfNone,      0,     false);

					InitDataProperty(0, cnt++ , dtData,      		80,	daCenter,  false,    prefix + "pol_cd",             false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "pod_cd",    		    false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "pod_nm",    		    false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "del_cd",    		    false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      	    50,	daCenter,  false,    prefix + "del_nm",    		    false,          "",      dfNone,      0,     false);

					
					InitDataProperty(0, cnt++ , dtData,				40,	daCenter,  false,    prefix + "bkg_sts_cd",    		false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		70,	daCenter,  false,    prefix + "bdr_flg",            false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      	    50,	daCenter,  false,    prefix + "corr_usr_id",    	false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		60,	daCenter,  false,    prefix + "pck_qty",            false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "pck_tp_cd",     	    false,          "",      dfNone,      0,     false);

					InitDataProperty(0, cnt++ , dtData,      	    50,	daCenter,  false,    prefix + "act_wgt",    		false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "wgt_ut_cd",          false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "sc_no",              false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		70,	daCenter,  false,    prefix + "rfa_no",             false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		60,	daCenter,  false,    prefix + "cstms_desc",     	false,          "",      dfNone,      0,     false);
					
					InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "us_obl_rdem_flg",   	false,          "",      dfNone,      0,     false);					
					InitDataProperty(0, cnt++ , dtData,      		90,	daCenter,  false,    prefix + "obl_rdem_dt",        false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "obl_rdem_ofc_cd",   	false,          "",      dfNone,      0,     false);					
					InitDataProperty(0, cnt++ , dtData,      	    50,	daCenter,  false,    prefix + "shp_cust_cd",    	false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "shp_cust_nm",    	false,          "",      dfNone,      0,     false);
					
					InitDataProperty(0, cnt++ , dtData,      		80,	daCenter,  false,    prefix + "csg_cust_cd",        false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "csg_cust_nm",    	false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "noy_cust_cd",    	false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      	    50,	daCenter,  false,    prefix + "noy_cust_nm",    	false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "aoy_cust_cd",    	false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "aoy_cust_nm",   		false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "bl_no",            	false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "bkg_no",   		    false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "split_flg", 		    false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "bkg_cre_dt",		    false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "bkg_ofc_cd",		    false,          "",      dfNone,      0,     false);
					InitDataProperty(0, cnt++ , dtData,			    30,	daCenter,  false,	 prefix + "bl_tp_cd",		    false,		    "",		dfNone,		  0,	 false,		true);
					
                  	InitDataProperty(0, cnt++ , dtData,             50, daCenter,  false,    prefix + "cstms_loc_cd",       false,          "",      dfNone,      0,     false);
                  	InitDataProperty(0, cnt++ , dtData,            100, daCenter,  false,    prefix + "cstms_file_tp_cd",   false,          "",      dfNone,      0,     false);
                  	InitDataProperty(0, cnt++ , dtData,            100, daCenter,  false,    prefix + "ibd_trsp_no",        false,          "",      dfNone,      0,     false);
                  	InitDataProperty(0, cnt++ , dtData,            100, daCenter,  false,    prefix + "ibd_trsp_iss_dt",    false,          "",      dfNone,      0,     false);
					
                  	InitDataProperty(0, cnt++ , dtData,             50, daCenter,  false,    prefix + "cstms_clr_cd",       false,          "",      dfNone,      0,     false);
                  	InitDataProperty(0, cnt++ , dtData,            100, daCenter,  false,    prefix + "cstms_clr_lst_dt",   false,          "",      dfNone,      0,     false);
                  	InitDataProperty(0, cnt++ , dtData,            100, daCenter,  false,    prefix + "evnt_ofc_cd",        false,          "",      dfNone,      0,     false);

                  	InitDataProperty(0, cnt++ , dtData,             50, daCenter,  false,    prefix + "frt_clt_flg",        false,          "",      dfNone,      0,     false);
                  	InitDataProperty(0, cnt++ , dtData,            100, daCenter,  false,    prefix + "his_seq",            false,          "",      dfNone,      0,     false);
                  	InitDataProperty(0, cnt++ , dtData,            100, daCenter,  false,    prefix + "frt_clt_lst_dt",     false,          "",      dfNone,      0,     false);
                  	InitDataProperty(0, cnt++ , dtData,            100, daCenter,  false,    prefix + "frt_clt_ofc_cd",     false,          "",      dfNone,      0,     false);
                  	
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"tot_ots_sts_cd"   ,   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"tot_ots_curr_cd1" ,   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"tot_ots_curr_cd2" ,   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"tot_ots_curr_cd3" ,   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"tot_ots_curr_cd4" ,   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"tot_ots_curr_cd5" ,   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"tot_ots_amt1"     ,   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"tot_ots_amt2"     ,   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"tot_ots_amt3"     ,   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"tot_ots_amt4"     ,   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"tot_ots_amt5"     ,   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"pod_yd_cd" ,          false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"del_yd_cd" ,          false,          "",      dfNone,      0,     false,       false);	                
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"instruction" ,        false,          "",      dfNone,      0,     false,       false);	                
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"coll_ofc_cd" ,        false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"free_trd_zn_flg" ,    false,          "",      dfNone,      0,     false,       false);	                
                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix +"dir_de_flg" ,         false,          "",      dfNone,      0,     false,       false);
                    
					CountPosition = 0;

               }
            	break;

//            	case "t1sheet2":      //t1sheet2 init
//	                with (sheetObj) {
//	                    // 높이 설정
//	                    style.height = 0;
//	                    //전체 너비 설정
//	                    SheetWidth = mainTable.clientWidth;
//	
//	                    //Host정보 설정[필수][HostIp, Port, PagePath]
//	                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//	
//	                    //전체Merge 종류 [선택, Default msNone]
//	                    MergeSheet = msNone;
//	
//	                   //전체Edit 허용 여부 [선택, Default false]
//	                    Editable = true;
//	
//	                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//	                    InitRowInfo( 1, 1, 3, 100);
//	                    var HeadTitle = "|Customs Clearance|Filer|MIB No.|IT Date";
//	                    var headCount = ComCountHeadTitle(HeadTitle);
//	                    
//	                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//	                    InitColumnInfo(headCount, 0, 0, true);
//	
//	                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//	                    InitHeadMode(true, false, true, true, false,false)
//	
//	
//	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//	                    InitHeadRow(0, HeadTitle, true);
//	
//	                    prefix = "t1sheet2_";
//	                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//	                  	InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,    daCenter,    true,  	  prefix + "ibflag");
//	                  	InitDataProperty(0, cnt++ , dtData,         50,    daCenter,    false,    prefix + "cstms_loc_cd",     false,          "",      dfNone,      0,     false);
//	                  	InitDataProperty(0, cnt++ , dtData,        100,    daCenter,    false,    prefix + "cstms_file_tp_cd", false,          "",      dfNone,      0,     false);
//	                  	InitDataProperty(0, cnt++ , dtData,        100,    daCenter,    false,    prefix + "ibd_trsp_no",      false,          "",      dfNone,      0,     false);
//	                  	InitDataProperty(0, cnt++ , dtData,        100,    daCenter,    false,    prefix + "ibd_trsp_iss_dt",  false,          "",      dfNone,      0,     false);
//		                  	
//	                  	CountPosition = 0;
//	               }
//	                break;

//            	case "t1sheet7":      //t1sheet7 init
//                with (sheetObj) {
//                    // 높이 설정
//                    style.height = 0;
//                    //전체 너비 설정
//                    SheetWidth = mainTable.clientWidth;
//
//                    //Host정보 설정[필수][HostIp, Port, PagePath]
//                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msNone;
//
//                   //전체Edit 허용 여부 [선택, Default false]
//                    Editable = true;
//
//                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                    InitRowInfo( 1, 1, 3, 100);
//                    var HeadTitle = "|cstms_clr_cd|cstms_clr_lst_dt|evnt_ofc_cd";
//                    var headCount = ComCountHeadTitle(HeadTitle);
//                    
//                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                    InitColumnInfo(headCount, 0, 0, true);
//
//                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                    InitHeadMode(true, false, true, true, false,false)
//
//
//                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle, true);
//
//                    prefix = "t1sheet7_";
//                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                  	InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,    daCenter,    true,  	  prefix + "ibflag");
//                  	InitDataProperty(0, cnt++ , dtData,         50,    daCenter,    false,    prefix + "cstms_clr_cd",     false,          "",      dfNone,      0,     false);
//                  	InitDataProperty(0, cnt++ , dtData,        100,    daCenter,    false,    prefix + "cstms_clr_lst_dt", false,          "",      dfNone,      0,     false);
//                  	InitDataProperty(0, cnt++ , dtData,        100,    daCenter,    false,    prefix + "evnt_ofc_cd",      false,          "",      dfNone,      0,     false);
//	                  	
//                  	CountPosition = 0;
//               }
//                break;

            	case "t1sheet3":      //t1sheet3 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 110;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "|TP/SZ|BKG Q'ty|CNTR Q'ty";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, true, true, false,false)


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    prefix = "t1sheet3_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  	InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,    daCenter,    true,  	  prefix + "ibflag");
                  	InitDataProperty(0, cnt++ , dtData,         50,    daCenter,    false,    prefix + "cntr_tpsz_cd",     false,          "",      dfNone,      0,     false);
                  	InitDataProperty(0, cnt++ , dtData,        100,    daCenter,    false,    prefix + "bkg_qty",          false,          "",      dfNone,      0,     false);
                  	InitDataProperty(0, cnt++ , dtData,        100,    daCenter,    false,    prefix + "cntr_qty",         false,          "",      dfNone,      0,     false);
                  	
                  	CountPosition = 0;
                    ScrollBar = 2;

            	}
                break;
	                
//                case "t1sheet4":      //ERP 데이터 조회
//	                with (sheetObj) {
//	                    // 높이 설정
//	                    style.height = 0;
//	                    //전체 너비 설정
//	                    SheetWidth = mainTable.clientWidth;
//	
//	                    //Host정보 설정[필수][HostIp, Port, PagePath]
//	                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//	
//	                    //전체Merge 종류 [선택, Default msNone]
//	                    MergeSheet = msNone;
//	
//	                    //전체Edit 허용 여부 [선택, Default false]
//	                    Editable = true;
//	
//	                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//	                    InitRowInfo( 1, 1, 3, 100);
//	
//	                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//	                    InitHeadMode(true, false, false, true, false,false)
//	
//	                    var HeadTitle = " |tot_ots_sts_cd|tot_ots_curr_cd1|tot_ots_curr_cd2|tot_ots_curr_cd3|tot_ots_curr_cd4|tot_ots_curr_cd5|tot_ots_amt1|tot_ots_amt2|tot_ots_amt3|tot_ots_amt4|tot_ots_amt5|ppt_sts_cd|ppt_rcv_ofc_cd|ppt_rcv_usr_id|ppt_rcv_dt|cct_sts_cd|cct_rcv_ofc_cd|cct_rcv_usr_id|cct_rcv_dt|cct_ots_curr_cd1|cct_ots_curr_cd2|cct_ots_curr_cd3|cct_ots_curr_cd4|cct_ots_curr_cd5|cct_ots_amt1|cct_ots_amt2|cct_ots_amt3|cct_ots_amt4|cct_ots_amt5|n3pty_ppt_sts_cd|n3pty_ppt_rcv_ofc_cd|n3pty_ppt_rcv_usr_id|n3pty_ppt_rcv_dt|n3pty_cct_sts_cd|n3pty_cct_rcv_ofc_cd|n3pty_cct_rcv_usr_id|n3pty_cct_rcv_dt|n3pty_cct_ots_curr_cd1|n3pty_cct_ots_curr_cd2|n3pty_cct_ots_curr_cd3|n3pty_cct_ots_curr_cd4|n3pty_cct_ots_curr_cd5|n3pty_cct_ots_amt1|n3pty_cct_ots_amt2|n3pty_cct_ots_amt3|n3pty_cct_ots_amt4|n3pty_cct_ots_amt5";
//	
//	                    var headCount = ComCountHeadTitle(HeadTitle);
//	
//	                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//	                    InitColumnInfo(headCount, 0, 0, true);
//	
//	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//	                    InitHeadRow(0, HeadTitle, true);
//	
//	
//	                    //데이터속성    [ROW, COL,    DATATYPE,        WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//	                    var prefix="t1sheet4_";
//	                    
//	                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  80,    daCenter,  false,   prefix +"ibflag");
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_sts_cd"         ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd1"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd2"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd3"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd4"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd5"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt1"           ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt2"           ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt3"           ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt4"           ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt5"           ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_sts_cd"             ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_ofc_cd"         ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_usr_id"         ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_dt"             ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_sts_cd"             ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_ofc_cd"         ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_usr_id"         ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_dt"             ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd1"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd2"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd3"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd4"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd5"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt1"           ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt2"           ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt3"           ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt4"           ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt5"           ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_sts_cd"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_sts_cd"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd1" ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd2" ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd3" ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd4" ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd5" ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt1"     ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt2"     ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt3"     ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt4"     ,   false,     "",        dfNone,     0,          false,       false);
//	                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt5"     ,   false,     "",        dfNone,     0,          false,       false);
//	
//	                    CountPosition = 0;
//	                }
//	            	break;
    			
	            case "t1sheet1_1":      //t1sheet1_1 init
	                    with (sheetObj) {
	                        // 높이 설정
	                        style.height = 182;  //82
	                        //전체 너비 설정
	                        SheetWidth = mainTable.clientWidth;
	
	                        //Host정보 설정[필수][HostIp, Port, PagePath]
	                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                        //전체Merge 종류 [선택, Default msNone]
	                        MergeSheet = msHeaderOnly;
	
	                       //전체Edit 허용 여부 [선택, Default false]
	                        Editable = false;
	
	                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                        InitRowInfo( 2, 1, 3, 100);

	                        var HeadTitle1 = "|Seq.|Container No.|TS|Pickup Information|Pickup Information|Pickup Information|Pickup Information|Pickup Information|Pickup Information|Weight|Weight|Package|Package|SPC|Pick up Notice Information|Pick up Notice Information|Pick up Notice Information|Pick up Notice Information";
	                        var HeadTitle2 = "|Seq.|Container No.|TS|Pickup No.|Yard|AVL DT|Free DT|TP|Updated Date|Weight|Weight|Package|Package|SPC|(Exp)Send Date|OFC|User Name|Remark(s)";
	
	                        var headCount = ComCountHeadTitle(HeadTitle1);
	                        
	                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                        InitColumnInfo(headCount, 4, 0, true);
	
	                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                        InitHeadMode(true, false, false, true, false,false)
	
	
	                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                        InitHeadRow(0, HeadTitle1, true);
	                        InitHeadRow(1, HeadTitle2, true);
	
	                        var prefix="t1sheet1_1_";
	                        
	                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		                    InitDataProperty(0, cnt++ , dtHiddenStatus, 80,      daCenter,  false,   prefix + "ibflag");
	                        InitDataProperty(0, cnt++ , dtSeq,    		40,      daCenter,  true,    prefix + "Seq");
	                        InitDataProperty(0, cnt++ , dtData,		    95,		 daCenter,	true,	 prefix + "cntr_no",		false,	"",	dfNone,				0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			60,	 	 daCenter,	true,	 prefix + "tpsz_cd",		false,	"",	dfNone, 			0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			80,	 	 daCenter,	false,	 prefix + "pkup_no",		false,	"",	dfNone,   			0,		false);
	
	                        InitDataProperty(0, cnt++ , dtData,			80,	 	 daCenter,	false,	 prefix + "pkup_yd",		false,	"",	dfNone,     		0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			100,	 daCenter,	false,	 prefix + "aval_dt",		false,	"",	dfNone,  	     	0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			100,		 daCenter,	false,	 prefix + "free_dt",		false,	"",	dfNone,			    0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			50,	 	 daCenter,	false,	 prefix + "ntc_tp",			false,	"",	dfNone,     		0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			110,	 daCenter,	false,	 prefix + "pkup_upd_dt",  	false,	"",	dfNone, 	        0,		false);
	
	                        InitDataProperty(0, cnt++ , dtData,			100,	 daRight,	true,	 prefix + "cntr_wgt",		false,	"",	dfNone,             0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			50,		 daCenter,	true,	 prefix + "wgt_ut_cd",		false,	"",	dfNone,     		0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			50,		 daRight,	true,	 prefix + "pck_qty",		false,	"",	dfNone,				0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			60,		 daCenter,	true,	 prefix + "pck_tp_cd",		false,	"",	dfNone,     		0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			60,		 daCenter,	true,	 prefix + "spc",     		false,	"",	dfNone,     		0,		false);

	                        InitDataProperty(0, cnt++ , dtData,			110,	 daCenter,	false,	 prefix + "pkup_evnt_dt",  	false,	"",	dfNone, 	        0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			60,	 	 daCenter,	false,	 prefix + "ofc_cd",	    	false,	"",	dfNone,   			0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			100,	 daCenter,	false,	 prefix + "usr_nm",	    	false,	"",	dfNone,     		0,		false);
	                        InitDataProperty(0, cnt++ , dtData,			120, 	 daCenter,	false,	 prefix + "pkup_rmk",		false,	"",	dfNone,     		0,		false);

							CountPosition = 0;
							
							SetMergeCell(0, 10, 2, 2)
							SetMergeCell(0, 12, 2, 2)
	
	                   }
                    break;

    				case "t1sheet1_2":      //t1sheet1_2 init
	                    with (sheetObj) {
	                        // 높이 설정
	                        style.height = 200; //102
	                        //전체 너비 설정
	                        SheetWidth = mainTable.clientWidth;
	
	                        //Host정보 설정[필수][HostIp, Port, PagePath]
	                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                        //전체Merge 종류 [선택, Default msNone]
	                        MergeSheet = msHeaderOnly;
	
	                       //전체Edit 허용 여부 [선택, Default false]
	                        Editable = true;
	
	                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                        InitRowInfo( 1, 1, 3, 100);
	
	                        var HeadTitle = "|Seq.|Container No.|F/M|TS|ESTIMATE\nFree Time|SAT\nExcl.|SUN\nExcl.|HOLI\nExcl.|ESTIMATE\nPOD LFD|Daily\nDemurrage|Fixed\nFreeTime|Fixed\nPOD LFD|Outstanding\nDemurrage|Bil Amt|Paid Amt|Seal No.|Package|Package|Weight|Weight|Measure|Measure|R/Term|D/Term|AS|ST|DG|BB|AK|RF(ºC)|RD|SOC";
	                        var headCount = ComCountHeadTitle(HeadTitle);
	                        
	                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                        InitColumnInfo(headCount, 5, 0, true);
	
	                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
		                    InitHeadMode(true, false, false, true, false,false)
	
	
	                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                        InitHeadRow(0, HeadTitle, true);
	
	                        prefix = "t1sheet1_2_";
	                        
	                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,     30,	daCenter,  true,	 prefix + "ibflag");
							InitDataProperty(0, cnt++ , dtSeq,    	        30,	daCenter,  true,	 prefix + "Seq");
							InitDataProperty(0, cnt++ , dtData,         	90,	daCenter,  false,    prefix + "cntr_no",                false,          "",      dfNone,      0,     false);										
							InitDataProperty(0, cnt++ , dtData,			    40,	daCenter,  false,    prefix + "fm_sts_cd",    		    false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtData,				40,	daCenter,  false,    prefix + "cntr_tpsz_cd",    		false,          "",      dfNone,      0,     false);

		                    InitDataProperty(0, cnt++ , dtData,             80, daCenter,  false,    prefix + "ft_dys"          ,       false,          "",      dfNone,      0,     false,       false);
		                    InitDataProperty(0, cnt++ , dtCheckBox,         60, daCenter,  false,    prefix + "xcld_sat_flg"    ,       false,          "",      dfNone,      0,     false,       false);
		                    InitDataProperty(0, cnt++ , dtCheckBox,         60, daCenter,  false,    prefix + "xcld_sun_flg"    ,       false,          "",      dfNone,      0,     false,       false);
		                    InitDataProperty(0, cnt++ , dtCheckBox,         60, daCenter,  false,    prefix + "xcld_hol_flg"   ,        false,          "",      dfNone,      0,     false,       false);
		                    InitDataProperty(0, cnt++ , dtHidden,           80, daCenter,  false,    prefix + ""   ,                    false,          "",      dfNone,      0,     false,       false);
		                    InitDataProperty(0, cnt++ , dtHidden,           80, daCenter,  false,    prefix + "cntr_rt_amt"      ,      false,          "",      dfNone,      0,     false,       false);
		                    InitDataProperty(0, cnt++ , dtData,             70, daCenter,  false,    prefix + "ft_dys_calc"     ,       false,          "",      dfNone,      0,     false,       false);
		                    InitDataProperty(0, cnt++ , dtData,             65, daCenter,  false,    prefix + "ft_end_dt"       ,       false,          "",      dfDateYmd,   0,     false,       false);
	  					    InitDataProperty(0, cnt++ , dtData,				90,	daCenter,  false,    prefix + "out_amt",                false,          "",      dfNone,      0,     false);
	  					    InitDataProperty(0, cnt++ , dtHidden,	    	90,	daCenter,  false,    prefix + "bil_amt",                false,          "",      dfNone,      0,     false);
	  					    InitDataProperty(0, cnt++ , dtHidden,		    90,	daCenter,  false,    prefix + "paid_amt",               false,          "",      dfNone,      0,     false);
							
							InitDataProperty(0, cnt++ , dtCombo,      	    70,	daCenter,  false,    prefix + "cntr_seal_no",           false,          "",      dfNone,      0,     true,       false);
							InitDataProperty(0, cnt++ , dtData,      		70,	daRight,   false,    prefix + "pck_qty",                false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtData,      		40,	daCenter,  false,    prefix + "pck_tp_cd",    	        false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtData,      		70,	daRight,   false,    prefix + "cntr_wgt",               false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtData,      		40,	daCenter,  false,    prefix + "wgt_ut_cd",              false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtData,      		70,	daRight,   false,    prefix + "meas_qty",               false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtData,      		40,	daCenter,  false,    prefix + "meas_ut_cd",     	    false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtData,      		70,	daCenter,  false,    prefix + "rcv_term_cd",            false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtData,      		70,	daCenter,  false,    prefix + "de_term_cd",             false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "adv_shtg_cd",            false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "cnmv_sts_cd",            false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtPopup,      		50,	daCenter,  false,    prefix + "dcgo_flg",     	        false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtPopup,      		50,	daCenter,  false,    prefix + "bb_cgo_flg",    		    false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtPopup,      		50,	daCenter,  false,    prefix + "in_ga_flg",    		    false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtPopup,      	    50,	daCenter,  false,    prefix + "cdo_temp",  		        false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "rd_cgo_flg",    		    false,          "",      dfNone,      0,     false);
							InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "soc_flg",    		    false,          "",      dfNone,      0,     false);

			                ImageList(0)  =  "img/btns_search.gif";
			                ImageList(1)  =  "img/btns_search_off.gif";

							ShowButtonImage = 2;
							CountPosition = 0;
							PopupImage = "img/btns_search.gif";
	
	                   }
	                    break;
    				case "t1sheet1_3":      //t1sheet1_3 init
	                    /****************************************************************
	                    //컨테이너 별 Demurrage
	                    *****************************************************************/

	                    with (sheetObj) {
	                        // 높이 설정
	                        style.height = 0;
	                        //전체 너비 설정
	                        SheetWidth = mainTable.clientWidth;

	                        //Host정보 설정[필수][HostIp, Port, PagePath]
	                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                        //전체Merge 종류 [선택, Default msNone]
	                        //MergeSheet = msNone;
	                        MergeSheet = msHeaderOnly;

	                        //전체Edit 허용 여부 [선택, Default false]
	                        Editable = false;

	                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                        InitRowInfo( 1, 1, 3, 100);

	                        var HeadTitle = " |Invoicing|Settled|DEMCMNC|PaidUpto|Paid Amount|Paid Amount|CNTR_NO|BIL_AMT";

	                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                        InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

	                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                        InitHeadMode(false, false, false, false, false,false)

	                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                        InitHeadRow(0, HeadTitle, true);

	                        //데이터속성    [ROW, COL,    DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,                    KEYFIELD,    CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                        var prefix="t1sheet1_3_";
	                        InitDataProperty(0,   cnt++ , dtHiddenStatus,  30,    daCenter,  false,     prefix +"ibflag");
	                        InitDataProperty(0,   cnt++ , dtData,          90,    daCenter,  false,     prefix +"dmdt_inv_sts_cd",  false,       "",         dfNone,     0,          false,       true);
	                        InitDataProperty(0,   cnt++ , dtData,          90,    daCenter,  false,     prefix +"dmdt_ar_if_cd",    false,       "",         dfNone,     0,          false,       true);
	                        InitDataProperty(0,   cnt++ , dtData,          80,    daCenter,  false,     prefix +"ft_end_dt",        false,       "",         dfDateYmd,  0,          false,       true);
	                        InitDataProperty(0,   cnt++ , dtData,          80,    daCenter,  false,     prefix +"to_mvmt_dt",       false,       "",         dfDateYmd,  0,          false,       true);
	                        InitDataProperty(0,   cnt++ , dtData,          40,    daCenter,  false,     prefix +"inv_curr_cd",      false,       "",         dfNone,     0,          false,       true);
	                        InitDataProperty(0,   cnt++ , dtHidden,        80,    daRight,   false,     prefix +"bil_amt",          false,       "",         dfNumber,   0,          false,       true);
	                        InitDataProperty(0,   cnt++ , dtHidden,        80,    daCenter,  false,     prefix +"cntr_no",          false,       "",         dfNone,     0,          false,       true);
	                        InitDataProperty(0,   cnt++ , dtData,          70,    daCenter,  false,     prefix +"inv_chg_amt",      false,       "",         dfNumber,   0,          false,       true);

	                        CountPosition = 0;
	                    }
	                break;
	                    
    	            case "t1sheet5":
    	                
    	            	with (sheetObj) {

    	                    // 높이 설정
    	                    style.height = 0;
    	                    //전체 너비 설정
    	                    SheetWidth = mainTable.clientWidth;

    	                    //Host정보 설정[필수][HostIp, Port, PagePath]
    	                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    	                    //전체Merge 종류 [선택, Default msNone]
    	                    MergeSheet = msAll;

    	                   //전체Edit 허용 여부 [선택, Default false]
    	                    Editable = true;

    	                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    	                    InitRowInfo(1, 1, 15, 100);

    						 var HeadTitle1 = "|Container No.|Seal No.";
    	                    var headCount = ComCountHeadTitle(HeadTitle1);

    	                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	                    InitColumnInfo(headCount, 0, 0, true);
    	 
    	                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
    	                    InitHeadMode(true, false, false, true, false,false)

    	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    	                    InitHeadRow(0, HeadTitle1, true);

    	                    prefix = "t1sheet5_";

    	                    
    	                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,	COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    						InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	true,		prefix + "ibflag");
    						InitDataProperty(0, cnt++ , dtData,         	    90,	    daCenter,   false,      prefix + "cntr_no",                false,          "",      dfNone,      0,     false);										
    						InitDataProperty(0, cnt++ , dtData,			        100,	daCenter,	false,		prefix + "cntr_seal_no",	       false,		   "",		dfNone,		 0,		false,		true);
    						
    						CountPosition = 0;
    				}
    				break;
                    case "t1sheet6":
                        with (sheetObj) {
                            // 높이 설정
                            style.height = 0;
                            //전체 너비 설정
                            SheetWidth = mainTable.clientWidth;

                            //Host정보 설정[필수][HostIp, Port, PagePath]
                            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                            //전체Merge 종류 [선택, Default msNone]
                            MergeSheet = msAll;

                           //전체Edit 허용 여부 [선택, Default false]
                            Editable = true;

                            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                            InitRowInfo(1, 1, 15, 100);

                            var HeadTitle1 = "|curr_cd|tot_bil_amt";
                            var headCount = ComCountHeadTitle(HeadTitle1);

                            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                            InitColumnInfo(headCount, 0, 0, true);

                            // 해더에서 처리할 수 있는 각종 기능을 설정한다
                            InitHeadMode(true, true, false, true, false,false)

                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                            InitHeadRow(0, HeadTitle1, true);

                            prefix = "t1sheet6_";

                            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,   COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                            InitDataProperty(0, cnt++ , dtHiddenStatus,         30,     daCenter,   true,       prefix + "ibflag");
                            InitDataProperty(0, cnt++ , dtData,                 100,    daCenter,   false,      prefix + "curr_cd",         false,      "",     dfNone,         0,      false,      true);
                            InitDataProperty(0, cnt++ , dtData,                 100,    daLeft,     false,      prefix + "tot_bil_amt",     false,      "",     dfNone,         0,      false,      true);

                            CountPosition = 0;
                    }
                    break;
            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            //sheetObj.ShowDebugMsg = false;
            var param = "";
            
            switch(sAction) {

               case IBSEARCH:      //조회
               		if(!validateForm(sheetObj,formObj,sAction)) return false;
                    document.form.xmlData.value = null;

            		if (!ComIsEmpty(formObj.combo_bl_no.text)) {
//	       				formObj.bl_no.value = formObj.combo_bl_no.text;
	       				formObj.bl_no.value = document.getElementById("combo_bl_no").text.trim();
	       			}
                       		
                    var temp_bl = formObj.combo_bl_no.text;
                    var temp_bkg = formObj.bkg_no.value;
                    
                	ComOpenWait(true);

                	formObj.combo_bl_no.text =temp_bl;
                	formObj.bkg_no.value = temp_bkg;
                	
                	//BL_TP_CD가 W Or S이면 BL_TP_CD 제거하기
                    if(formObj.bl_no.value !=''){
                        var blNo   = formObj.bl_no.value;
                        var suffix = blNo.substring(formObj.bl_no.value.length-1)

                        if(suffix =='W' || suffix =='S'){
                            formObj.bl_no.value = blNo.substring(0, blNo.lastIndexOf(suffix));
                        }
                    }
                    
            		
       				if ( sheetObj.id == "t1sheet1"){
	           			formObj.f_cmd.value = SEARCH;
	
	           			var aryPrefix = new Array("t1sheet1_", "t1sheet3_", "t1sheet1_1_", "t1sheet1_2_", "t1sheet1_3_", "t1sheet5_", "t1sheet6_"); //prefix 문자열 배열
	           			param = "f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value + "&cntr_no=" + formObj.cntr_no.value;
//	           			var sXml = sheetObj.GetSearchXml("ESM_BKG_0668_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	           			var sXml = sheetObj.GetSearchXml("ESM_BKG_0668_01GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
		        		
		         		var arrXml = sXml.split("|$$|");
	
		         		for(var idx = 0; idx < arrXml.length; idx++){
		         			
	                        sheetObjects[idx].Redraw = false;
	                        if(idx > 0) {
	                            sheetObjects[idx].WaitImageVisible = false;
	                        }
	                        
	                        sheetObjects[idx].LoadSearchXml(arrXml[idx]);
	                        sheetObjects[idx].Redraw = true;
	                    }
		         		
		         		frt_term_cd = ComGetEtcData(arrXml[0], "frtTermCd");
               		} else if ( sheetObj.id == "sheet2"){
	           			sheetObjects[sheet2].WaitImageVisible = false;
//	           			if (beforetab == 1) {
//	           				formObj.f_cmd.value = SEARCH10;	//US Cargo Release는 체크로직이 존재
//	           			} else {
//	           				formObj.f_cmd.value = SEARCH09;
//	           			}

	           			formObj.f_cmd.value = SEARCH09;
	           			
	           			var aryPrefix = new Array("sheet2_"); //prefix 문자열 배열

	           			param = "f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value;
	           			
//		                sheetObj.DoSearch("ESM_BKG_0668_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		                sheetObj.DoSearch("ESM_BKG_0668_01GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
		                
		                sheetObjects[sheet2].WaitImageVisible = true;
               		}

//       				if (document.form.pop_mode.value == "") {
//                    	fnTabEnable(true);
//                    } else {
//                    	document.form.pop_mode.value = "";
//                    }
	         		ComOpenWait(false);

                    break;

    			case COMMAND01:
                    formObj.f_cmd.value = SEARCH01;
                    document.form.xmlData.value = null;
                    
                    param = "f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value + "&cntr_no=" + formObj.cntr_no.value;
                    
//                    sheetObj.DoSearch("ESM_BKG_0292GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
                    sheetObj.DoSearch("ESM_BKG_0292GS.do",param + "&" + ComGetPrefixParam("sheet1_"));
    	        	break;
    			case COMMAND02:
                    formObj.f_cmd.value = SEARCH02;
                    document.form.xmlData.value = null;
                    param = "f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value + "&po_no=" + formObj.po_no.value;
                    
//                    sheetObj.DoSearch("ESM_BKG_0292GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
                    sheetObj.DoSearch("ESM_BKG_0292GS.do",param + "&" + ComGetPrefixParam("sheet1_"));
		        	break;
    			case COMMAND03:
    				formObj.f_cmd.value = SEARCH03;
            	 	document.form.xmlData.value = null;
                    param = "f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value + "&hbl_no=" + formObj.hbl_no.value;
					
//		        	sheetObj.DoSearch("ESM_BKG_0668_01GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
		        	sheetObj.DoSearch("ESM_BKG_0668_01GS.do",param + "&" + ComGetPrefixParam("sheet1_"));
		        	break;
                case COMMAND05:
                    formObj.f_cmd.value = SEARCH04;
                    document.form.xmlData.value = null;
                    param = "f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value;
                    
//                    sheetObj.DoSearch("ESM_BKG_0292GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
                    sheetObj.DoSearch("ESM_BKG_0292GS.do",param + "&" + ComGetPrefixParam("sheet1_"));
                    break;
            }
        }

        /**
         * IBTab Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setTabObject(tab_obj){
            tabObjects[tabCnt++] = tab_obj;
        }


        /**
         * Tab 기본 설정
         * 탭의 항목을 설정한다.
         */
        function initTab(tabObj , tabNo) {
             
        	 switch(tabNo) {
                 case 1:
                    with (tabObj) {

                        var cnt  = 0 ;
                        InsertTab( cnt++ , "B/L Info" , -1 );
                        InsertTab( cnt++ , "Cargo Release" , -1 );
                        InsertTab( cnt++ , "Movement" , -1 );
                        InsertTab( cnt++ , "Customs Result" , -1 );
                        InsertTab( cnt++ , "S/O Info" , -1 );
                        InsertTab( cnt++ , "A/N Sent" , -1 );
                        InsertTab( cnt++ , "Pickup Notice" , -1 );
                    }
                 break;

                 case 2:
                    with (tabObj) {

                        var cnt  = 0 ;
                        InsertTab( cnt++ , "US" , -1 );
                        InsertTab( cnt++ , "General" , -1 );

             			BaseColor = "#F3F2F8";

                    }
                 break;
             }
        }



        /**
         * Tab 클릭시 이벤트 관련
         * 선택한 탭의 요소가 활성화 된다.
         */
        function tab1_OnChange(tabObj , nItem)
        {

            var objs = document.all.item("tabLayer");

    	    	objs[nItem].style.display = "Inline";
    	    	objs[beforetab].style.display = "none";

    	    	//--------------- 요기가 중요 --------------------------//
    	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	    	//------------------------------------------------------//
    	    	beforetab= nItem;
    	    	
    	    	if (beforetab == 0) {
    	    		if (document.form.mainPage.value != "") {
    	    			fnTabChangeQuery();	//탭을 변경시 조회 조건 변경 여부를 체크하여, 조회 조건이 변경된 경우 자동으로 조회 모듈을 호출한다.
    	    		} else {
    	    			document.form.mainPage.value = "Y";
    	    		}
    	        } else {
    	        	loadTabPage(beforetab);
    	        }    	    	
        }

        /**
         * Tab 클릭시 이벤트 관련
         * 선택한 탭의 요소가 활성화 된다.
         *  B/L Info 안에 들어있는 텝
         */
        function t1tab1_OnChange(tabObj , nItem)
        {


            var objs = document.all.item("t1tabLayer");

    	    	objs[nItem].style.display = "Inline";
    	    	objs[t1beforetab].style.display = "none";


    	    	//--------------- 요기가 중요 --------------------------//
    	    	objs[t1beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	    	//------------------------------------------------------//
    	    	t1beforetab= nItem;


        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
      		switch(sAction) {       	 
				case IBSEARCH:
					conditionTrim();
					
					if(ComIsEmpty(formObj.combo_bl_no.text) && ComIsEmpty(formObj.bkg_no.value)){
	                    ComShowCodeMessage('BKG40097');
	                    formObj.combo_bl_no.focus();
	                    return false;
	                }
		        	
		            if(!ComChkObjValid(formObj.bkg_no)) {
		                return false;
		            }        	
	                
//	                if (ComIsEmpty(formObj.combo_bl_no.text) == false) {
//	                	if (ComChkLen(formObj.combo_bl_no.text, 12) == 1 || ComChkLen(formObj.combo_bl_no.text, 13) == 0) {
//	                		// BlNo가 12이거나 13이면 정상임 (맨 뒤에 W 또는 S가 붙을 수 있음, W와 S는 java에서 제거함)
//	                        ComShowCodeMessage('BKG40031', document.form.combo_bl_no.text);
//	                		return false;
//	                	}
//	                }
//	                
//	                if (ComIsEmpty(formObj.bkg_no.value) == false) {
//	                	if (ComChkLen(formObj.bkg_no.value, 11) == 1 || ComChkLen(formObj.bkg_no.value, 13) == 0) {
//	                		// Bkg No가 11이거나 13이면 정상임
//	                		ComShowCodeMessage('BKG00255');
//	                		return false;
//	                	}
//	                }
	                
	                return true;
	
	                break;
      		}
 		
      		return true;
        }

         /**
          * 엔터키 수행 시 조회 함수 호출
          */
         function enterKeySearch(){
             var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
             var formObject = document.form;
             var srcName = window.event.srcElement.getAttribute("name");

             if(ComIsEmpty(srcName)){
                 return;
             }

             // 엔터키(13)이면
             if (keyCode == 13) {
 	            if (srcName == "cntr_no" || srcName == "po_no" || srcName == "hbl_no") {
 	            	obj_deactivate();
 	            } else {
 	            	fnTabChangeQuery();			//조회 모듈을 호출한다.
 	            	
 	            }
             }            
             
         }                    

         function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){

             if (ErrMsg == "") {
                 if(sheetObj.RowCount > 0){
                     //Grid의 Data를 Html의 인자값으로 Copy한다.
                     IBS_CopyRowToForm(sheetObj, document.form, 1, "frm_");
                     
                     document.form.btn_ts_route.style.cursor = 'hand';
                     
                     if (sheetObj.CellValue(1,"t1sheet1_bdr_flg") == "Y") {
                     	document.form.frm_t1sheet1_bdr_flg.checked = true;
                     } else {
                     	document.form.frm_t1sheet1_bdr_flg.checked = false;
                     }
                     
                     if (sheetObj.CellValue(1,"t1sheet1_corr_usr_id") != "Y") {
                     	document.form.frm_t1sheet1_corr_flg.checked = false;
                        document.form.btn_corr_flg.src =  'img/btns_search_off.gif'; 
                        document.form.btn_corr_flg.style.cursor = 'default';
                     } else {
                     	document.form.frm_t1sheet1_corr_flg.checked = true;
                        document.form.btn_corr_flg.src =  'img/btns_search.gif';
                        document.form.btn_corr_flg.style.cursor = 'hand';
                     }
                     
                     //Partial의 값에 따라서 Font Color를 설정한다.
                     if (sheetObj.CellValue(1,"t1sheet1_partial") == "Y") {						//Partial의 값이 Y인 경우 빨강색
                     	document.getElementById("frm_t1sheet1_partial").style.color = "red";
                     } else {																	//Y가 아닌경우 검정색
                     	document.getElementById("frm_t1sheet1_partial").style.color = "";
                     }
                     
                     var blNo = null;
                     
                     if (sheetObj.CellValue(1,"t1sheet1_bl_tp_cd") != "B") {
                    	 blNo = sheetObj.CellValue(1,"t1sheet1_bl_no") + sheetObj.CellValue(1,"t1sheet1_bl_tp_cd");
                     } else {
                    	 blNo = sheetObj.CellValue(1,"t1sheet1_bl_no");
                     }
                     
                     if (document.form.combo_bl_no.GetCount == 0) {                    	 
                     	 document.form.combo_bl_no.InsertItem(-1, blNo, sheetObj.CellValue(1,"t1sheet1_bkg_no"));
                     	 document.form.combo_bl_no.index = 0;
                     } else {

 						var itemindex = document.form.combo_bl_no.FindIndex( blNo, 0); 
 						
 						if (itemindex == -1) {
 							document.form.combo_bl_no.RemoveAll();
                     		document.form.combo_bl_no.InsertItem(-1, blNo, sheetObj.CellValue(1,"t1sheet1_bkg_no"));
                         	document.form.combo_bl_no.index = 0;
 						} else {
// 							document.form.combo_bl_no.index = itemindex;
 							document.form.combo_bl_no.Code = itemindex;
 						}
                     }
                     
                     document.form.bkg_no.value = sheetObj.CellValue(1,"t1sheet1_bkg_no");

                    if (sheetObj.CellValue(1,"t1sheet1_split_flg") == "Y") {
              	    	buttonColorSet('btn_split', 'red');
                    } else {
               	    	buttonColorSet('btn_split', 'gray');
                    }
                     
                     
                     //T/S Route 버튼 활성화 시킴
                     document.form.btn_ts_route.src =  'img/btns_search.gif';

                     //Contract No의 값의 존재여부에 따라서 버튼을 활성화 시킴
                     if (sheetObj.CellValue(1,"t1sheet1_rfa_no").length > 0) {
                         document.form.btn_contract_no.src =  'img/btns_search.gif';
                         document.form.btn_contract_no.style.cursor = 'hand';
                         
                         document.form.frm_t1sheet1_sc_no.value = sheetObj.CellValue(1,"t1sheet1_rfa_no"); 
                     } else {
                     	if (sheetObj.CellValue(1,"t1sheet1_sc_no").length > 0) {
                             document.form.btn_contract_no.src =  'img/btns_search.gif';
                             document.form.btn_contract_no.style.cursor = 'hand';                		
                             
                             document.form.frm_t1sheet1_sc_no.value = sheetObj.CellValue(1,"t1sheet1_sc_no");
                     	} else {
                     		document.form.btn_contract_no.src =  'img/btns_search_off.gif';
     	                    document.form.btn_contract_no.style.cursor = 'default';

     	                    document.form.frm_t1sheet1_sc_no.value = "";
                     	}
                     }

                     //Consignee의 값의 존재여부에 따라서 버튼을 활성화 시킴
                     if (sheetObj.CellValue(1,"t1sheet1_csg_cust_nm").length == 0) {
                         document.form.btn_consignee.src =  'img/btns_search_off.gif';
                         document.form.btn_consignee.style.cursor = 'default';
                     } else {
                         document.form.btn_consignee.src =  'img/btns_search.gif';
                         document.form.btn_consignee.style.cursor = 'hand';
                     }

                     //Notify의 값의 존재여부에 따라서 버튼을 활성화 시킴
                     if (sheetObj.CellValue(1,"t1sheet1_noy_cust_nm").length == 0) {
                         document.form.btn_notify.src =  'img/btns_search_off.gif';
                         document.form.btn_notify.style.cursor = 'default';
                     } else {
                         document.form.btn_notify.src =  'img/btns_search.gif';
                         document.form.btn_notify.style.cursor = 'hand';
                     }

                     //A.Notify의 값의 존재여부에 따라서 버튼을 활성화 시킴
                     if (sheetObj.CellValue(1,"t1sheet1_aoy_cust_nm").length == 0) {
                         document.form.btn_a_notify.src =  'img/btns_search_off.gif';
                         document.form.btn_a_notify.style.cursor = 'default';
                     } else {
                         document.form.btn_a_notify.src =  'img/btns_search.gif';
                         document.form.btn_a_notify.style.cursor = 'hand';
                     }
                     
                     if (document.form.frm_t1sheet1_noy_cust_cd.value == "0") {
                    	 document.form.frm_t1sheet1_noy_cust_cd.value = "";
                     }

                     if (document.form.frm_t1sheet1_aoy_cust_cd.value == "0") {
                    	 document.form.frm_t1sheet1_aoy_cust_cd.value = "";
                     }
                     
                     if (sheetObj.CellValue(1,"t1sheet1_act_wgt") != "0") {
                     	document.form.frm_t1sheet1_act_wgt.value = ComAddComma2(sheetObj.CellValue(1,"t1sheet1_act_wgt"), "#,###.00");
                     }
                     
                     document.form.frm_t1sheet1_pod_nm.title = sheetObj.CellValue(1,"t1sheet1_pod_nm");
                     document.form.frm_t1sheet1_del_cd.title = sheetObj.CellValue(1,"t1sheet1_del_cd");
                     document.form.frm_t1sheet1_del_nm.title = sheetObj.CellValue(1,"t1sheet1_del_nm");
                     document.form.frm_t1sheet1_pck_qty.title = sheetObj.CellValue(1,"t1sheet1_pck_qty");
                     document.form.frm_t1sheet1_act_wgt.title = sheetObj.CellValue(1,"t1sheet1_act_wgt");
                     document.form.frm_t1sheet1_cstms_desc.title = sheetObj.CellValue(1,"t1sheet1_cstms_desc");
                     document.form.frm_t1sheet1_shp_cust_nm.title = sheetObj.CellValue(1,"t1sheet1_shp_cust_nm");
                     document.form.frm_t1sheet1_csg_cust_nm.title = sheetObj.CellValue(1,"t1sheet1_csg_cust_nm");
                     document.form.frm_t1sheet1_noy_cust_nm.title = sheetObj.CellValue(1,"t1sheet1_noy_cust_nm");
                     document.form.frm_t1sheet1_aoy_cust_nm.title = sheetObj.CellValue(1,"t1sheet1_aoy_cust_nm");
                     document.form.frm_t1sheet1_free_trd_zn_flg.title = sheetObj.CellValue(1,"t1sheet1_free_trd_zn_flg");
                     document.form.frm_t1sheet1_dir_de_flg.title = sheetObj.CellValue(1,"t1sheet1_dir_de_flg");
                     
                     addSel(sheetObj);
                     
                     buttonColorSet('btn_c_flag', 'black');
                     buttonColorSet('btn_pu_history', 'black');

                     if (sheetObj.CellValue(1,"t1sheet1_instruction") == "Y") {
                    	 buttonColorSet('btn_instruction', 'red');
                     } else {
                    	 buttonColorSet('btn_instruction', 'black');
                     }
                     
                     
                     fnSetHiddenKey();
                 } else {
                	 fnBlInfoClear();
                	 
                	 addSelZero();
                 }
             }
         }

//         function t1sheet2_OnSearchEnd(sheetObj, ErrMsg){
//
//        	 var formObj = document.form;
//        	 var prefix = "t1sheet2_";
//             if (ErrMsg == "") {
//                 if(sheetObj.RowCount > 0){
//                     //Grid의 Data를 Html의 인자값으로 Copy한다.
//                     
//                     IBS_CopyRowToForm(sheetObj, document.form, 1, "frm_");
//                 }
//             }
//         }

//         function t1sheet7_OnSearchEnd(sheetObj, ErrMsg){
//        	 var formObj = document.form;
//        	 var prefix = "t1sheet7_";
//             if (ErrMsg == "") {
//                 if(sheetObj.RowCount > 0){
//                     //Grid의 Data를 Html의 인자값으로 Copy한다.
//                     
//                     IBS_CopyRowToForm(sheetObj, document.form, 1, "frm_");
//                 }
//             }
//         }

         function t1sheet3_OnSearchEnd(sheetObj, ErrMsg){
        	 cntrQtySum = 0;
         	
         	if (ErrMsg == "") {
                 if(sheetObj.RowCount > 0){
                 	for(var i=1; i<=sheetObj.RowCount; i++) {                	
                 		//Bkg Qty와  Cntr Qty가 차이가 나는지 체크한다. 차이가 나면 글자를 빨간색 굵은 문자로 설정한다.
                 		if (sheetObj.CellValue(i,"t1sheet3_bkg_qty") != sheetObj.CellValue(i,"t1sheet3_cntr_qty")) {
                 			sheetObj.CellFont("FontBold", i,"t1sheet3_bkg_qty", i, "t1sheet3_cntr_qty") = true;		//Bold 값을 설정
                 			sheetObj.CellFontColor(i, "t1sheet3_bkg_qty" ) = sheetObj.RgbColor(255, 0, 0);			//빨간색 설정
                 			sheetObj.CellFontColor(i, "t1sheet3_cntr_qty" ) = sheetObj.RgbColor(255, 0, 0);			//빨간색 설정
                 		}
                 	
                 		//Bkg Qty와  Cntr Qty가 소수인 경우 연두색 굵은 문자로 설정한다. 102, 204, 0
                 		if (isFloat(sheetObj.CellValue(i,"t1sheet3_bkg_qty")) == true) {
                 			sheetObj.CellFont("FontBold", i,"t1sheet3_bkg_qty", i, "t1sheet3_cntr_qty") = true;		//Bold 값을 설정
                 			sheetObj.CellFontColor(i, "t1sheet3_bkg_qty" ) = sheetObj.RgbColor(102, 204, 0);		//연두색 설정
                 			sheetObj.CellFontColor(i, "t1sheet3_cntr_qty" ) = sheetObj.RgbColor(102, 204, 0);		//연두색 설정
                 		} else if (isFloat(sheetObj.CellValue(i,"t1sheet3_cntr_qty")) == true) {
                 			sheetObj.CellFont("FontBold", i,"t1sheet3_bkg_qty", i, "t1sheet3_cntr_qty") = true;		//Bold 값을 설정
                 			sheetObj.CellFontColor(i, "t1sheet3_bkg_qty" ) = sheetObj.RgbColor(102, 204, 0);		//연두색 설정
                 			sheetObj.CellFontColor(i, "t1sheet3_cntr_qty" ) = sheetObj.RgbColor(102, 204, 0);		//연두색 설정
                 		} else {
                 			cntrQtySum = parseInt(cntrQtySum) + parseInt(sheetObj.CellValue(i,"t1sheet3_cntr_qty"));
                 		}                 		
                 	}
                 }
         	}
         }

//         /**
//         * Hidden IBSheet를 조회하고 나서 처리할 사항
//         */
//        function t1sheet4_OnSearchEnd(sheetObj, ErrMsg){
//        	 var tot_ots_sts_cd = null;
//        	 var prefix="t1sheet4_";
//        	
//            if (ErrMsg == "") {
//           	    if(sheetObj.RowCount > 0){
//           		 
//	           		tot_ots_sts_cd = sheetObj.CellValue(1, prefix + "tot_ots_sts_cd");
//	               	if (frt_term_cd = "C" && tot_ots_sts_cd == "C") {
//	               		document.form.frm_t1sheet1_frt_clt_flg.value = "Y";
//	               		document.form.frm_t1sheet1_frt_clt_lst_dt.value = "";
//	               		document.form.frm_t1sheet1_frt_ofc_cd.value = "CREDIT";
// 	                    document.getElementById("frm_t1sheet1_frt_ofc_cd").style.color = "red";
//	               		
//	               		addSelZero();
//	               	} else if (sheetObj.CellValue(1, prefix + "cct_rcv_ofc_cd").trim() == "" && sheetObj.CellValue(1, prefix + "n3pty_cct_rcv_ofc_cd").trim() == "") {
//	               		document.form.frm_t1sheet1_frt_clt_flg.value = "";
//	               		document.form.frm_t1sheet1_frt_clt_lst_dt.value = "";
//                        document.form.frm_t1sheet1_frt_ofc_cd.value = "Non-CCT";
//                        document.getElementById("frm_t1sheet1_frt_ofc_cd").style.color = "blue";
//                        
//                        addSelZero();
//	               		
//	               	} else {
//		               	if (tot_ots_sts_cd == "C") {		//신용 화주인 경우
//		               		document.form.frm_t1sheet1_frt_clt_flg.value = "Y";
//		               		document.form.frm_t1sheet1_frt_clt_lst_dt.value = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_bkg_cre_dt").substring(0, 16);
//		               		document.form.frm_t1sheet1_frt_ofc_cd.value = sheetObjects[t1sheet1].CellValue(1, "t1sheet1_bkg_ofc_cd");
//	 	                    document.getElementById("frm_t1sheet1_frt_ofc_cd").style.color = "black";
//		               		
//		               		addSelZero();
//		               	} else if (tot_ots_sts_cd == "Y") { //미신용 화주이면서 미수금을 회수 했을 경우
//		               		document.form.frm_t1sheet1_frt_clt_flg.value = "Y";
//		               		document.form.frm_t1sheet1_frt_clt_lst_dt.value = sheetObj.CellValue(1, prefix + "cct_rcv_dt").substring(0, 16);
//		               		document.form.frm_t1sheet1_frt_ofc_cd.value = sheetObj.CellValue(1, prefix + "cct_rcv_ofc_cd");
//	 	                    document.getElementById("frm_t1sheet1_frt_ofc_cd").style.color = "black";
//		           		
//		               		addSelZero();
//		               		
//		               	} else if (tot_ots_sts_cd == "N") {
//		               		document.form.frm_t1sheet1_frt_clt_flg.value = "N";
//		               		document.form.frm_t1sheet1_frt_clt_lst_dt.value = "";
//		               		document.form.frm_t1sheet1_frt_ofc_cd.value = "";
//	 	                    document.getElementById("frm_t1sheet1_frt_ofc_cd").style.color = "black";
//		               		
//		               		addSel(sheetObj);                		
//		               	}
//	               	}
//                }
//            }
//        }

         //ERP로 부터 받아온 정보를 Select Box로 구성한다.
         function addSel(sheetObj) {
             var sel = document.form.tot_ots_amt;

             var prefix="t1sheet1_";
             
             for (i=sel.length-1; i>=0; i--){
                 sel.options[i] = null
             }
             
     		if(sheetObj.CellValue(1, prefix+"tot_ots_sts_cd") == 'N' || sheetObj.CellValue(1, prefix+"tot_ots_sts_cd") == 'Y' || sheetObj.CellValue(1, prefix+"tot_ots_sts_cd") == 'C'){
     	        var unit   = "";
     	        var amount = "";
     	        var colorFlg = "";

     	        for (j=0; j<5; j++){
     	            unit   = sheetObj.CellValue(1, "t1sheet1_"+"tot_ots_curr_cd"+parseInt(j+1));
     	            amount = sheetObj.CellValue(1, "t1sheet1_"+"tot_ots_amt"+parseInt(j+1));
     	            if(! ComIsEmpty(unit)){
    	            	if (amount > 0) {
    	            		colorFlg = "Y";
    	            	}

     	            	document.form['tot_ots_amt'][j] = new Option(unit+' '+ComAddCommaRun(amount), j);
     	            }
     	        }
     	        
     	        if (colorFlg == "Y") {
     	        	//폰트 색상을 붉고 진하게 한다.
     	        	document.getElementById("tot_ots_amt").className = "input2_1";
     	        } else {
     	        	document.getElementById("tot_ots_amt").className = "input2";
     	        }
     			
     		} else {
     			//by sungho 2010.03.04 추가
     			document.form['tot_ots_amt'][0] = new Option(sheetObj.CellValue(1, prefix+"tot_ots_amt1"));
     			document.getElementById("tot_ots_amt").className = "input2_1";
                 return;
             }
         }
         
         //tot_ots_amt 항목에 0을 셋팅한다.
         function addSelZero() {

        	 var sel = document.form.tot_ots_amt;
        	 
             for (i=sel.length-1; i>=0; i--){
                 sel.options[i] = null
             }
        	 
             document.form['tot_ots_amt'][0] = new Option('0', 0);
             
             document.getElementById("tot_ots_amt").className = "input2";


         }
         
		//Axon 이벤트 처리2. 이벤트처리함수 --- start
		/**
		 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
		 **/
		function obj_keypress(){
		    switch(event.srcElement.dataformat){
		        case "float":
		            //숫자+"."입력하기
		            ComKeyOnlyNumber(event.srcElement, ".");
		            break;
		        case "eng":
		            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		            //ComKeyOnlyAlphabet();
		            ComKeyOnlyAlphabet('uppernum');
		            break;
	            case "eng1":
	                //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	                //ComKeyOnlyAlphabet();
	                ComKeyOnlyAlphabet('uppernum', "45|95|36|46");
	                break;		            
		        case "engdn":
		            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
		            ComKeyOnlyAlphabet('lower');
		            break;
		        case "engup":
		            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		            ComKeyOnlyAlphabet('upper');
		            break;
		        default:	
		            //숫자만입력하기(정수,날짜,시간)
		            ComKeyOnlyNumber(event.srcElement);
		    }
		}
		
		function obj_066801_deactivate(){
			var formObj = document.form;
		    var srcName = window.event.srcElement.getAttribute("name");
		    var srcValue = window.event.srcElement.getAttribute("value");
			switch(event.srcElement.name){
	    		case "bkg_no":
    		    		if(!ComIsNull(document.form.bkg_no.value)){
    		    			formObj.elements[srcName].value = srcValue.toUpperCase();
    		    		}
    		    		break;
	    		case "cntr_no":
		    		if(!ComIsNull(document.form.cntr_no.value)){
		    			formObj.elements[srcName].value = srcValue.toUpperCase();
		    		}	
	    		break;
	    		case "po_no":
		    		if(!ComIsNull(document.form.po_no.value)){
		    			formObj.elements[srcName].value = srcValue.toUpperCase();
		    		}
			    break;
	    		case "hbl_no":
		    		if(!ComIsNull(document.form.hbl_no.value)){
		    			formObj.elements[srcName].value = srcValue.toUpperCase();
		    		}
	    		break;
			}
		}
        function obj_deactivate(){
         	switch(event.srcElement.name){
	    	case "cntr_no":
	    		//컨테이너 번호의 값이 존재하는지를 체크
	    		if(ComIsEmpty(document.form.cntr_no.value)){
	    			document.form.h_cntr_no.value = "";
	    			return false;
                }
	    		
	    		if (!(document.form.cntr_no.value.length == 10 || document.form.cntr_no.value.length == 11)) {
	    			ComShowCodeMessage('BKG00700');
	    			return false;
	    		}

	    		//컨테이너번호의 값이 이전에 입력한 값과 동일한 경우인지 체크(로직 삭제 2010-03-24 심영우 과장 요청)
//	    		if(document.form.cntr_no.value == document.form.h_cntr_no.value) {
//	    			return false;
//	    		} else {
	    			document.form.xmlData.value = null;
	    			sheetObjects[sheetObjects.length-1].RemoveAll();
	    			conditionReset();
	    			doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND01);
	    			document.form.h_cntr_no.value = document.form.cntr_no.value;
	    			
//	    		}
	        	break;
	    	case "po_no":	    		
	    		//PO 번호의 값이 존재하는지를 체크
	    		if(ComIsEmpty(document.form.po_no.value)){
	    			document.form.h_po_no.value = "";
	    			return false;
                }

	    		//컨테이너번호의 값이 이전에 입력한 값과 동일한 경우인지 체크(로직 삭제 2010-03-24 심영우 과장 요청)
//	    		if(document.form.po_no.value == document.form.h_po_no.value) {
//	    			return false;
//	    		} else {
	    			
	    			document.form.xmlData.value = null;
	    			sheetObjects[sheetObjects.length-1].RemoveAll();
	    			conditionReset();
	    			doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND02);
	    			document.form.h_po_no.value = document.form.po_no.value;
//	    		}
	        	break;
	    	case "hbl_no":	    		
	    		//HBL NO 번호의 값이 존재하는지를 체크
	    		if(ComIsEmpty(document.form.hbl_no.value)){
	    			document.form.h_hbl_no.value = "";
	    			return false;
                }

	    		
	    		//컨테이너번호의 값이 이전에 입력한 값과 동일한 경우인지 체크(로직 삭제 2010-03-24 심영우 과장 요청)
//	    		if(document.form.hbl_no.value == document.form.h_hbl_no.value) {
//	    			return false;
//	    		} else {
	    			document.form.xmlData.value = null;
	    			sheetObjects[sheetObjects.length-1].RemoveAll();
	    			conditionReset();
	    			doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND03);
	    			document.form.h_hbl_no.value = document.form.hbl_no.value;
//	    		}
	        	break;
         	}
        }
         
        /**
         * BL_NO 타이핑 시 BKG_NO. CNTR_NO 초기화<br>
         **/
        function conditionReset(){
        	 
        	 if (event.srcElement.name == "bl_no") {
                document.getElementById("hbl_no").value  = '';
                document.getElementById("bkg_no").value  = '';
                document.getElementById("cntr_no").value = '';
                document.getElementById("po_no").value = '';
                document.getElementById("h_cntr_no").value  = '';
                document.getElementById("h_po_no").value  = '';
                document.getElementById("h_hbl_no").value  = '';
                buttonColorSet('btn_split', 'gray');
            }else if (event.srcElement.name == "bkg_no") {
                document.getElementById("hbl_no").value  = '';
                document.getElementById("bl_no").value  = '';
                document.getElementById("cntr_no").value = '';
                document.getElementById("po_no").value = '';
                document.getElementById("combo_bl_no").RemoveAll();
                document.getElementById("combo_bl_no").text = '';
                document.form.combo_bl_no.BackColor = "White";
                document.form.combo_bl_no.FontColor = "Black";
                document.getElementById("h_cntr_no").value  = '';
                document.getElementById("h_po_no").value  = '';
                document.getElementById("h_hbl_no").value  = '';
                buttonColorSet('btn_split', 'gray');
            }else if (event.srcElement.name == "cntr_no") {
                document.getElementById("hbl_no").value  = '';
                document.getElementById("bl_no").value  = '';
                document.getElementById("bkg_no").value = '';
                document.getElementById("combo_bl_no").RemoveAll();
                document.getElementById("combo_bl_no").text = '';
                document.form.combo_bl_no.BackColor = "White";
                document.form.combo_bl_no.FontColor = "Black";
                document.getElementById("po_no").value = '';
                document.getElementById("h_cntr_no").value  = '';
                document.getElementById("h_po_no").value  = '';
                document.getElementById("h_hbl_no").value  = '';
                buttonColorSet('btn_split', 'gray');
            }else if (event.srcElement.name == "hbl_no") {
                document.getElementById("bl_no").value  = '';
                document.getElementById("bkg_no").value = '';
                document.getElementById("cntr_no").value = '';
                document.getElementById("po_no").value = '';
                document.getElementById("combo_bl_no").RemoveAll();
                document.getElementById("combo_bl_no").text = '';
                document.form.combo_bl_no.BackColor = "White";
                document.form.combo_bl_no.FontColor = "Black";
                document.getElementById("h_cntr_no").value  = '';
                document.getElementById("h_po_no").value  = '';
                document.getElementById("h_hbl_no").value  = '';
                buttonColorSet('btn_split', 'gray');
            }else if (event.srcElement.name == "po_no") {
                document.getElementById("hbl_no").value  = '';
                document.getElementById("bl_no").value  = '';
                document.getElementById("bkg_no").value = '';
                document.getElementById("cntr_no").value = '';
                document.getElementById("combo_bl_no").RemoveAll();
                document.getElementById("combo_bl_no").text = '';
                document.form.combo_bl_no.BackColor = "White";
                document.form.combo_bl_no.FontColor = "Black";
                document.getElementById("h_cntr_no").value  = '';
                document.getElementById("h_po_no").value  = '';
                document.getElementById("h_hbl_no").value  = '';
                buttonColorSet('btn_split', 'gray');
            }
            
        }
         
         
         /**
          * 화면의 모든 항목을 Clear 시키고, 버튼도 초기화 시킨다.
          */
         function fnAllClear () {
             
             //모든 input 항목을 Clear 시킨다.	
             for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
                	document.form.getElementsByTagName("input")[i].value="";      
             }

             //모든 check 항목을 Clear 시킨다.	
             document.form.frm_t1sheet1_bdr_flg.checked = false;
             document.form.frm_t1sheet1_corr_flg.checked = false;

             document.form.combo_bl_no.RemoveAll();
             document.form.combo_bl_no.text = "";
             document.form.combo_bl_no.BackColor = "White";
             document.form.combo_bl_no.FontColor = "Black";
             
              //Outstanding Amouts 항목을 클리어한다.
              var selOtsAmt = document.form.tot_ots_amt;
     		 
     	     for (i=selOtsAmt.length-1; i>=0; i--){
     	    	 selOtsAmt.options[i] = null
     	     }
             
     	     //Outstanding Demurrage Per B/L 항목을 Clear한다.
              var selDemAmt = document.form.tot_bil_amt;
     		 
     	     for (i=selDemAmt.length-1; i>=0; i--){
     	    	 selDemAmt.options[i] = null
     	     }
     	     
     	     //모든 ibSheet를 초기화한다.
     	     for(i=0;i<sheetObjects.length;i++){
     	    	 sheetObjects[i].RemoveAll();
              }
     	     
     	     //BL_번호 항목에 포커스를 위치한다.
     	     document.form.combo_bl_no.focus();

    	     //팝업 버튼을 Disable 시킨다.
    	     fnButtonInit();
     	     
         }
        
         /**
          * Hidden IBSheet를 조회하고 나서 처리할 사항
          */
          function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        	  var blNo = null;
              
              if (ErrMsg == "") {
             	 if(sheetObj.RowCount > 1){
                      blSelectPopOpen(sheetObj);
                  } else if (sheetObj.RowCount == 1){
                      
                	  if (sheetObj.CellValue(1,"sheet1_bl_tp_cd") != "B") {
                		  blNo = sheetObj.CellValue(1,"sheet1_bl_no") + sheetObj.CellValue(1,"sheet1_bl_tp_cd");
                	  } else {
                		  blNo = sheetObj.CellValue(1,"sheet1_bl_no");
                	  }

                      document.getElementById("bkg_no").value = sheetObj.CellValue(1,"sheet1_bkg_no");
                      document.form.combo_bl_no.RemoveAll();
	                  document.form.combo_bl_no.InsertItem(-1, blNo, sheetObj.CellValue(1,"sheet1_bkg_no"));
	                  document.form.combo_bl_no.index = 0;
	                  
	                  fnTabChangeQuery();
                  } else {                	  
                	  ComShowCodeMessage('BKG00095');
                	  sheetObj.RemoveAll();
                  }
              }
          }       

          /**
           * HTML Control의 onfocus이벤트에서 Validation을 체크한다. <br>
           **/
          function blSelectPopOpen(){
              var sXml = IBS_GetDataSearchXml(sheetObjects[sheetObjects.length-1]);
              document.form.xmlData.value = sXml;
              ComOpenPopup("/hanjin/ESM_BKG_0942.do", 500, 300, "conditionSet", "1,0", true);
          }

          
          /**
           * BL_NO SELECT BOX에서 선택된 값을 BKG_NO에 세팅한다.<br>
           * 선택된 값의 배경색상을 변경 시킨다.
           **/
          function blNoSelect(idx){
              document.getElementById("bkg_no").value = sheetObjects[sheetObjects.length-1].CellValue(idx, "sheet1_bkg_no");
              document.getElementById("bl_no").value  = sheetObjects[sheetObjects.length-1].CellValue(idx, "sheet1_bl_no");

              var length = document.getElementsByName("hdn_bl_no").length;
              if(document.getElementsByName("hdn_bl_no").length > 1){
                  for(var i=1; i<=length; i++){
                      if(i==idx){
                          document.all.hdn_bl_no[i-1].style.backgroundColor= '#4169E1';
                          document.all.hdn_bl_no[i-1].style.color= '#FFFFFF';
                      }else{
                          document.all.hdn_bl_no[i-1].style.backgroundColor= '#FFFFFF';
                          document.all.hdn_bl_no[i-1].style.color= 'black';
                      }
                  }
              }
          }

          function blComboSet(bl_no) {
          	  document.getElementById("combo_bl_no").RemoveAll();
          	
          	  comboFlg = true;
          	
          	  var itemindex = null;
          	  var blNo = null;
          	
              for (idx=1; idx<=sheetObjects[sheetObjects.length-1].RowCount; idx++) {
              	  if (sheetObjects[sheetObjects.length-1].CellValue(idx,"sheet1_bl_tp_cd") != "B") {
              		  blNo = sheetObjects[sheetObjects.length-1].CellValue(idx,"sheet1_bl_no") + sheetObjects[sheetObjects.length-1].CellValue(idx,"sheet1_bl_tp_cd");
              	  } else {
              		  blNo = sheetObjects[sheetObjects.length-1].CellValue(idx,"sheet1_bl_no");
              	  }
              	
              	  document.getElementById("combo_bl_no").InsertItem(-1, blNo , sheetObjects[sheetObjects.length-1].CellValue(idx,"sheet1_bkg_no"));
              	  if (bl_no == sheetObjects[sheetObjects.length-1].CellValue(idx,"sheet1_bl_no")) {
              		  itemindex = idx -1;
              	  }
              }
              
              
              if (itemindex>-1) {        
              	  document.getElementById("combo_bl_no").index = itemindex;
              }

              if (sheetObjects[sheetObjects.length-1].RowCount > 1) {
          		  document.getElementById("combo_bl_no").BackColor = "Yellow";
          	  } else {
          		  document.getElementById("combo_bl_no").BackColor = "White";
          	  }

          }          

          function combo_bl_no_OnChange(comboObj, Index_Code, Text){
        	  conditionTrim();
        	  
              if (comboFlg != true) {
            	  if (Text.length > 0) {
            		  document.getElementById("bkg_no").value = Index_Code;
                      if (Index_Code == "") {
                      	  document.getElementById("bl_no").value  = '';
            	          document.getElementById("cntr_no").value = '';
            	          document.getElementById("po_no").value = '';
            	          document.getElementById("hbl_no").value = '';
            	          document.getElementById("h_cntr_no").value = '';
            	          document.getElementById("h_po_no").value = '';
            	          document.getElementById("h_hbl_no").value = '';
            	    	  document.getElementById("bkg_no").value = '';    	
                          buttonColorSet('btn_split', 'gray');
                      }
            		  
            	  }
              } else {
              	  comboFlg = false;
              }
              
              	//  changing the input value to upper case
         	 	var comboText =  Text.toUpperCase();
         	  	 	
         	 	//  return if selected or inserted value is in the combo
         	 	if (comboObj.FindIndex(comboText, 0) == -1) {
         	 		//alert("comboText:"+comboText);
      	   	 	var index = comboObj.InsertItem(0, comboText, comboText);
      	 		comboObj.Text2 = comboText;  //  inserting value can be selected
         	 	}
              
              fnSetComboText();              
          }          

          function combo_bl_no_OnKeyDown(comboObj, KeyCode, Shift){

        	if (KeyCode == 13 || KeyCode == 8) {
        	
        	
        	} else {

            	document.getElementById("bl_no").value  = '';
    	        document.getElementById("cntr_no").value = '';
    	        document.getElementById("po_no").value = '';
    	        document.getElementById("hbl_no").value = '';
    	        document.getElementById("h_cntr_no").value = '';
    	        document.getElementById("h_po_no").value = '';
    	        document.getElementById("h_hbl_no").value = '';
    	    	document.getElementById("bkg_no").value = '';    	
                buttonColorSet('btn_split', 'gray');
        	}
        }
          
          /**
           * TRiC SELECT BOX를 그린다.
           */
          function conditionSet(aryPopupData){

              if(aryPopupData != undefined){
                  document.getElementById("bl_no").value  = aryPopupData[0][3];
                  document.getElementById("bkg_no").value = aryPopupData[0][5];
                  
                  blComboSet(aryPopupData[0][3]);            
              }
          }          

        function t1sheet1_1_OnSearchEnd(sheetObj, ErrMsg){

        	var wgt_sum = 0;
        	var pkg_sum = 0;
        	var prefix="t1sheet1_1";
        	
            if (ErrMsg == "") {
                if(sheetObj.RowCount > 0){
                	wgt_sum = sheetObj.ComputeSum("|10|");
                	pkg_sum = sheetObj.ComputeSum("|12|");
                	
                	document.getElementById("frm_t1sheet1_1_cntr_cnt").value  = ComAddComma(sheetObj.RowCount);
                	document.getElementById("frm_t1sheet1_1_wgt_sum").value = ComAddComma(wgt_sum);
                	document.getElementById("frm_t1sheet1_1_pkg_sum").value = ComAddComma(pkg_sum);
                	
                	for(var j=1; j<=sheetObj.RowCount; j++) {
                		if (parseFloat(ComReplaceStr(sheetObj.CellValue(j+1,"t1sheet1_1_cntr_wgt"), ",","")) > 45000) {
                			sheetObj.CellFont("FontBold", j+1,"t1sheet1_1_cntr_wgt") = true;					//Bold 값을 설정
                			sheetObj.CellFontColor(j+1, "t1sheet1_1_cntr_wgt" ) = sheetObj.RgbColor(255, 0, 0);	//빨강색 설정
                		}
                	}
                	
                } else {
              	    document.getElementById("frm_t1sheet1_1_cntr_cnt").value  = '0';
       	            document.getElementById("frm_t1sheet1_1_wgt_sum").value = '0';
       	            document.getElementById("frm_t1sheet1_1_pkg_sum").value = '0';
                }
            }    
        } 
        
        /**
         * Container No별로 Seal No를 읽어서 ComboBox에 셋팅한다.
         */
         function t1sheet5_OnSearchEnd(sheetObj, ErrMsg){
       	    var t1sheet5_cntr_no = null;
         	var t1sheet5_cntr_seal_no = null;
         	var temp_cntr_no = null;
       	    var t1sheet3_cntr_no = null;
       	    var prefix6 = "t1sheet5_";
       	    var prefix3 = "t1sheet1_2_";
       	    var bStart  = true;
       	  
            if (ErrMsg == "") {
                if (sheetObj.RowCount > 0 && sheetObjects[t1sheet1_2].RowCount > 0) {

                    for(i=0;i<sheetObj.RowCount;i++){
                   	    t1sheet5_cntr_no = sheetObj.CellValue(i+1,prefix6+ "cntr_no");
                   	
                   	    if (temp_cntr_no != t1sheet5_cntr_no) {
                   		    if (bStart != true) {
                       		    setCntrSeslNo(temp_cntr_no, t1sheet5_cntr_seal_no);
                       	    } else {
                       		    bStart = false;
                       	    }

                       	    if (sheetObj.CellValue(i+1,prefix6+ "cntr_seal_no") != "") {
                       		    t1sheet5_cntr_seal_no = sheetObj.CellValue(i+1,prefix6+ "cntr_seal_no");
                       	    }
                   		
                   		    temp_cntr_no = t1sheet5_cntr_no;

                   	    } else {
                       	    if (sheetObj.CellValue(i+1,prefix6+ "cntr_seal_no") != "") {
                       		    t1sheet5_cntr_seal_no = t1sheet5_cntr_seal_no + "|" + sheetObj.CellValue(i+1,prefix6+ "cntr_seal_no");
                       	    }
                   	    }
                    }
                   
                    if (t1sheet5_cntr_seal_no != "") {
               		    setCntrSeslNo(temp_cntr_no, t1sheet5_cntr_seal_no);
                    }
           	    }
            }
         }
        
         function setCntrSeslNo(cntrNo, sealNo) {
         	
       	     var t1sheet1_2_cntr_no = null;
       	     var prefix = "t1sheet1_2_";
       	  
       	     for(k=0;k<sheetObjects[t1sheet1_2].RowCount;k++){
       		     t1sheet1_2_cntr_no = sheetObjects[t1sheet1_2].CellValue(k+1,prefix+ "cntr_no");
       		
       		     if (t1sheet1_2_cntr_no == cntrNo) {
       			     if (sealNo != null) {
       			    	 sheetObjects[t1sheet1_2].CellComboItem(k+1, prefix + "cntr_seal_no", sealNo, sealNo);
                 		 sheetObjects[t1sheet1_2].CellBackColor(k+1, prefix + "cntr_seal_no") = sheetObjects[t1sheet1_2].RgbColor(239, 235, 239);
       			     }
       			     break;
       		     }
       	     }
         }
        
         function sheet2_OnSearchEnd(sheetObj, ErrMsg){

             if (ErrMsg == "") {
                 if(sheetObj.RowCount > 0){
                     
                     var blNo = null;
                     if (sheetObj.CellValue(1,"sheet2_bl_tp_cd") != "B") {
                    	 blNo = sheetObj.CellValue(1,"sheet2_bl_no") + sheetObj.CellValue(1,"sheet2_bl_tp_cd");
                     } else {
                    	 blNo = sheetObj.CellValue(1,"sheet2_bl_no");
                     }
                     
                     if (document.form.combo_bl_no.GetCount == 0) {
                     	
                     	document.form.combo_bl_no.InsertItem(-1, blNo, sheetObj.CellValue(1,"sheet2_bkg_no"));
                     	document.form.combo_bl_no.index = 0;
                     } else {

 						var itemindex = document.form.combo_bl_no.FindIndex( blNo, 0); 
 						
 						if (itemindex == -1) {
 							document.form.combo_bl_no.RemoveAll();
                     		document.form.combo_bl_no.InsertItem(-1, blNo, sheetObj.CellValue(1,"sheet2_bkg_no"));
                         	document.form.combo_bl_no.index = 0;
 						} else {
// 							document.form.combo_bl_no.index = itemindex;
 							document.form.combo_bl_no.Code = itemindex;
 						}
                     }

                    if (document.form.combo_bl_no.GetCount > 1) {
                     	document.form.combo_bl_no.BackColor = "Yellow";
                 	} else {
                 		document.form.combo_bl_no.BackColor = "White";
                 	}
                     
                     document.form.bkg_no.value = sheetObj.CellValue(1,"sheet2_bkg_no");

                     if (sheetObj.CellValue(1,"sheet2_split_flg") == "Y") {
						buttonColorSet('btn_split', 'red');
                     } else {
						buttonColorSet('btn_split', 'gray');
                     }
                     
                     fnSetHiddenKey();
                 }
                 
                 var objTabWindow = document.getElementById("t" + (beforetab+1) + "frame").contentWindow;        
                 if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {                  
	                 if(beforetab == 1){//Cargo Release
	                	 t2frame.location.href="/hanjin/ESM_BKG_0668_09.do?bl_no=" + sheetObj.CellValue(1,"sheet2_bl_no");
	                 } else if(beforetab == 2){
	                     t3frame.location.href="/hanjin/ESM_BKG_0668_03.do?bkg_no=" + sheetObj.CellValue(1,"sheet2_bkg_no");            	
	                 } else if(beforetab == 3){
	                     t4frame.location.href="/hanjin/ESM_BKG_0668_05.do?bkg_no=" + sheetObj.CellValue(1,"sheet2_bkg_no");           	
	                 } else if(beforetab == 4){
	                     t5frame.location.href="/hanjin/ESM_BKG_0668_08.do?bkg_no=" + sheetObj.CellValue(1,"sheet2_bkg_no");           	
	                 } else if(beforetab == 5){
	                	 t6frame.location.href="/hanjin/ESM_BKG_0668_06.do?bkg_no=" + sheetObj.CellValue(1,"sheet2_bkg_no") + "&bl_no=" + sheetObj.CellValue(1,"sheet2_bl_no");           	
	                 } else if(beforetab == 6){
	                     t7frame.location.href="/hanjin/ESM_BKG_0668_07.do?bkg_no=" + sheetObj.CellValue(1,"sheet2_bkg_no") + "&bl_no=" + sheetObj.CellValue(1,"sheet2_bl_no");           	
	                 }
                 } else {
	                 if(beforetab == 1){//Cargo Release
	                	 t2frame.fnQueryExec(sheetObj.CellValue(1,"sheet2_bl_no"));
	                 } else if(beforetab == 2){
	                     t3frame.fnQueryExec(sheetObj.CellValue(1,"sheet2_bkg_no"));            	
	                 } else if(beforetab == 3){
	                     t4frame.fnQueryExec(sheetObj.CellValue(1,"sheet2_bkg_no"));           	
	                 } else if(beforetab == 4){
	                     t5frame.fnQueryExec(sheetObj.CellValue(1,"sheet2_bkg_no"));           	
	                 } else if(beforetab == 5){
	                	 t6frame.fnQueryExec(sheetObj.CellValue(1,"sheet2_bkg_no"), sheetObj.CellValue(1,"sheet2_bl_no"));           	
	                 } else if(beforetab == 6){
	                	 t7frame.fnQueryExec(sheetObj.CellValue(1,"sheet2_bkg_no"), sheetObj.CellValue(1,"sheet2_bl_no"));           	
	                 }                	 
                 }
             } else {
                 if(beforetab == 1){//Cargo Release
                	 t2frame.location.href="/hanjin/ESM_BKG_0668_09.do?bl_no=" + "";
                 } else if(beforetab == 2){
                     t3frame.location.href="/hanjin/ESM_BKG_0668_03.do?bkg_no=" + "";            	
                 } else if(beforetab == 3){
                     t4frame.location.href="/hanjin/ESM_BKG_0668_05.do?bkg_no=" + "";           	
                 } else if(beforetab == 4){
                     t5frame.location.href="/hanjin/ESM_BKG_0668_08.do?bkg_no=" + "";           	
                 } else if(beforetab == 5){
                     t6frame.location.href="/hanjin/ESM_BKG_0668_06.do?bkg_no=" + "" + "&bl_no=" + "";
                 } else if(beforetab == 6){
                     t7frame.location.href="/hanjin/ESM_BKG_0668_07.do?bkg_no=" + "" + "&bl_no=" + "";           	
                 }
             }
         }

         function loadTabPage(tabIndex) {
             if (tabIndex == null || tabIndex == "") {
                 tabIndex = tabObjects[0].SelectedIndex;
             }

             var bkgNo = document.form.bkg_no.value;
             var blNo = document.form.combo_bl_no.text;

             var sUrl = "";
             var param = "?bkg_no=" + bkgNo;
             
             var queryYn = "N";
             
             switch (tabIndex) {
             case 1:
                 sUrl = "ESM_BKG_0668_09.do";
                 
                 if (t1BkgNo != bkgNo || t1BlNo != blNo) {
                	 queryYn = "Y";
                	 t1BkgNo = bkgNo;
                	 t1BlNo  = blNo;
                 }
                 break;
             case 2:
                 sUrl = "ESM_BKG_0668_03.do"; 
                 if (t2BkgNo != bkgNo || t2BlNo != blNo) {
                	 queryYn = "Y";
                	 t2BkgNo = bkgNo;
                	 t2BlNo  = blNo;
                 }
                 break;
             case 3:
                 sUrl = "ESM_BKG_0668_05.do"; 
                 if (t3BkgNo != bkgNo || t3BlNo != blNo) {
                	 queryYn = "Y";
                	 t3BkgNo = bkgNo;
                	 t3BlNo  = blNo;            	 
                 }
                 break;
             case 4:
                 sUrl = "ESM_BKG_0668_08.do"; 
                 if (t4BkgNo != bkgNo || t4BlNo != blNo) {
                	 queryYn = "Y";
                	 t4BkgNo = bkgNo;
                	 t4BlNo  = blNo;            	 
                 }
                 break;
             case 5:
                 sUrl = "ESM_BKG_0668_06.do"; 
                 if (t5BkgNo != bkgNo || t5BlNo != blNo) {
                	 queryYn = "Y";
                	 t5BkgNo = bkgNo;
                	 t5BlNo  = blNo;            	 
                 }
                 break;
             case 6:
                 sUrl = "ESM_BKG_0668_07.do"; 
                 if (t6BkgNo != bkgNo || t6BlNo != blNo) {
                	 queryYn = "Y";
                	 t6BkgNo = bkgNo;
                	 t6BlNo  = blNo;            	 
                 }
                 break;
             }
             
             
             var objTabWindow = document.getElementById("t" + (tabIndex+1) + "frame").contentWindow;        
             if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {             
            	 if (bkgNo != "" || blNo != "") {            	 
            		 if (queryYn == "Y") {
            			 fnTabChangeQuery();
            		 }
                 } else {
                	 objTabWindow.location.href = sUrl;
                 }
                 return true;
             } else {
                 if (bkgNo != "" || blNo != "") {
        			 if (queryYn == "Y") {
        				 fnTabChangeQuery();
        			 }
                 }        	 
             }
         }            
         
        /** 
         * isFloat(str) : 숫자값인지 체크, '.' 포함
         */ 
         function isFloat(fVal) {
         	var temp = 0;
         	var sVal = null;
         	
         	
         	var sIdx = fVal.toString().indexOf(".");
         	
         	if (sIdx > 0) {
 	        	var sTemp = fVal.toString();
         		
         		sVal = sTemp.substring(parseInt(sIdx) + 1);
 	        	
 	        	if (parseInt(sVal) > 0 ) {
 	        		return true;
 	        	} else {
 	        		return false;
 	        	}
         	} else {
         		return false;
         	}
         }
        
 	    function fnSetComboText() {
 	    	
 	    	var blNo = document.form.combo_bl_no.text;
 	    	
 	    	if (ComIsEmpty(blNo) == false) {
 	 	    	var strTemp = blNo.substr(blNo.length-1);
 	    	
	 	    	if (strTemp == "W") {
	 	    		document.form.combo_bl_no.FontColor = "Blue";
	 	    	} else if (strTemp == "S") {
	 	    		document.form.combo_bl_no.FontColor = "Red";
	 	    	} else {
	 	    		document.form.combo_bl_no.FontColor = "Black";	 	    		
	 	    	}
 	    	}
 	    }
 	    
 	   function combo_bl_no_OnClear(blCombo) {
 		  blCombo.BackColor = "White";
 		  blCombo.FontColor = "Black";
 	   }
 	   

       /**
        * t1sheet1_2의 조회가 완료된 시점에 값을 설정한다.
        */
        function t1sheet1_2_OnSearchEnd(sheetObj, ErrMsg){
        	
        	var invTotBilAmt = 0;
        	
        	if (ErrMsg == "") {
                if(sheetObj.RowCount > 0){
                	if (cntrQtySum > 0 && isFloat(cntrQtySum) == false) {				//Container의 값이 정수인 경우
                		if (cntrQtySum != sheetObj.RowCount) {		//Container의 값과 t1sheet3.RowCount의 값이 틀리면 t1sheet3의 값을 파란색 굵은 문자로 설정한다. 
                			
                			for(var i=1; i<=sheetObjects[t1sheet3].RowCount; i++) {
	                			sheetObjects[t1sheet3].CellFont("FontBold", i,"t1sheet3_bkg_qty", i, "t1sheet3_cntr_qty") = true;			//Bold 값을 설정
	                			sheetObjects[t1sheet3].CellFontColor(i, "t1sheet3_bkg_qty" ) = sheetObjects[t1sheet3].RgbColor(0, 0, 255);	//파란색 설정
	                			sheetObjects[t1sheet3].CellFontColor(i, "t1sheet3_cntr_qty" ) = sheetObjects[t1sheet3].RgbColor(0, 0, 255);	//파란색 설정
                			}
                		}
                	}
                	
                	for(var j=1; j<=sheetObj.RowCount; j++) {
                		if (parseFloat(ComReplaceStr(sheetObj.CellValue(j,"t1sheet1_2_cntr_wgt"), ",","")) > 44000) {
                			sheetObj.CellFont("FontBold", j,"t1sheet1_2_cntr_wgt") = true;					//Bold 값을 설정
                			sheetObj.CellFontColor(j, "t1sheet1_2_cntr_wgt" ) = sheetObj.RgbColor(255, 0, 0);	//빨강색 설정
                		}
                		
                        invTotBilAmt += parseInt(sheetObjects[t1sheet1_2].CellValue(j, "t1sheet1_2_paid_amt"));	//돈 준 것을 저장함                		

						if (sheetObj.CellValue(j, "t1sheet1_2_dcgo_flg") == "Y") {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_dcgo_flg") = 0;
						} else {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_dcgo_flg") = 1;
						}

						if (sheetObj.CellValue(j, "t1sheet1_2_bb_cgo_flg") == "Y") {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_bb_cgo_flg") = 0;
						} else {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_bb_cgo_flg") = 1;
						}

						if (sheetObj.CellValue(j, "t1sheet1_2_in_ga_flg") == "OUT") {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_in_ga_flg") = 0;
						} else {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_in_ga_flg") = 1;
						}

						if (sheetObj.CellValue(j, "t1sheet1_2_cdo_temp") == "N") {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_cdo_temp") = 1;
						} else {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_cdo_temp") = 0;
						}                	
                	}

                	
                	document.form.invTotBilAmt.value = invTotBilAmt;
                }
        	}        	
        }
       
	    /**
	     * Hidden IBSheet를 조회하고 나서 처리할 사항
	     */
	    function t1sheet6_OnSearchEnd(sheetObj, ErrMsg){
	        var sel = document.form.tot_bil_amt;

	        var prefix="t1sheet6_";

	        //SELECT BOX 초기화
	        for (i=sel.length-1; i>=0; i--){
	            sel.options[i] = null
	        }

	        var currCd = "";
	        var bilAmt = "";
	        var invTotBilAmt = "";
	        var demSts = false;
	        
	        if (sheetObj.RowCount > 0) {
		        for (j=0; j<sheetObj.RowCount; j++){
		            currCd  = sheetObj.CellValue(parseInt(j+1), prefix+"curr_cd");
		            bilAmt  = sheetObj.CellValue(parseInt(j+1), prefix+"tot_bil_amt");
	
		            if (parseInt(bilAmt) > 0) {
		    			demSts = true;
		    		}
		            
	                document.form['tot_bil_amt'][j] = new Option(currCd+' '+ComAddCommaRun(bilAmt), j);
		            
		        }
		        
		        if (demSts == true) {
		            document.getElementById("tot_bil_amt").className = "input2_1";
		   	  	} else {
		            document.getElementById("tot_bil_amt").className = "input2";
		   	  	}
	        } else {
	            document.form['tot_bil_amt'][0] = new Option('0');
	            document.getElementById("tot_bil_amt").className = "input2";
	        }			        
	    }
	     
     /**
     * 화면의 버튼을 비 활성화 시킨다.
     */
    function buttonColorSet(btn_name, color){
	   	var tds = document.getElementsByTagName("td");
	   	var curFlag = null;
	   	 
	   	if (color == 'red' || color == 'black') {
	   		curFlag = "hand";
	   	} else {
	   		curFlag = "default";
	   	}
   	 
        for(var i = 0; i < tds.length; i++) {
            var td=tds[i];

            if(td.name == '•' + btn_name){
           	 td.style.color = color;
           	 td.style.cursor = curFlag;
           	 
           	 if (btn_name == "btn_split") {
           		 document.form.h_split.value = color;
           	 }
                break;
            }else if(td.name == btn_name){
           	 td.style.color = color;
           	 td.style.cursor = curFlag;
           	 
           	 if (btn_name == "btn_split") {
           		 document.form.h_split.value = color;
           	 }
                break;
            }else{
           	 continue;
            }
        }
    }

     function fnButtonInit() {
    	document.form.btn_ts_route.src = 'img/btns_search_off.gif';
    	document.form.btn_corr_flg.src = 'img/btns_search_off.gif';
    	document.form.btn_contract_no.src = 'img/btns_search_off.gif';
    	document.form.btn_consignee.src = 'img/btns_search_off.gif';
    	document.form.btn_notify.src = 'img/btns_search_off.gif';
    	document.form.btn_a_notify.src = 'img/btns_search_off.gif';
    	buttonColorSet('btn_split', 'gray');
    	buttonColorSet('btn_c_flag', 'gray');
    	buttonColorSet('btn_instruction', 'gray');
    	buttonColorSet('btn_pu_history', 'gray');
    	
        document.form.btn_ts_route.style.cursor = 'default';            
        document.form.btn_corr_flg.style.cursor = 'default';
        document.form.btn_contract_no.style.cursor = 'default';
        document.form.btn_consignee.style.cursor = 'default';
        document.form.btn_notify.style.cursor = 'default';
        document.form.btn_a_notify.style.cursor = 'default';
    	
    }

    function t1sheet1_2_OnClick(sheetObj, Row, Col){

		var prefix1 = "t1sheet1_";
		var prefix3 = "t1sheet1_2_";
		
		var param = null;
		var bl_no = null;
		var bkg_no = null;
		var bl_tp_cd = null;
		var cntr_no = null;
		
		bl_no = sheetObjects[t1sheet1].CellValue(1, prefix1 + "bl_no");
		bkg_no = sheetObjects[t1sheet1].CellValue(1, prefix1 + "bkg_no");
		bl_tp_cd = sheetObjects[t1sheet1].CellValue(1, prefix1 + "bl_tp_cd");
        cntr_no = sheetObjects[t1sheet1_2].CellValue(Row, prefix3 + "cntr_no");

        if (bl_tp_cd == "B") {
        	bl_tp_cd = "";
        }
        
		if (sheetObj.ColSaveName(Col) == prefix3 + "dcgo_flg"   ||
				sheetObj.ColSaveName(Col) == prefix3 + "bb_cgo_flg" ||
				sheetObj.ColSaveName(Col) == prefix3 + "in_ga_flg"  ||
				sheetObj.ColSaveName(Col) == prefix3 + "cdo_temp")  {

			if (sheetObj.ColSaveName(Col) == prefix3 + "dcgo_flg") {

				if (sheetObj.CellValue(Row, prefix3 + "dcgo_flg") == "Y") {
					param="?bl_no="+bl_no+"&bkg_no="+bkg_no;
					param+="&bl_tp_cd="+bl_tp_cd+"&cntr_no="+cntr_no;
					
//					ComOpenWindow("/hanjin/ESM_BKG_0659.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:810px;dialogHeight:400px;dialogLeft:0;dialogTop:0", true);
                    ComOpenWindow("/hanjin/ESM_BKG_0659.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:810px;dialogHeight:400px;dialogLeft:0;dialogTop:0", true);

				}
			} else if (sheetObj.ColSaveName(Col) == prefix3 + "bb_cgo_flg") {
				if (sheetObj.CellValue(Row, prefix3 + "bb_cgo_flg") == "Y") {

					param="?bl_no="+bl_no+"&bkg_no="+bkg_no;
					param+="&bl_tp_cd="+bl_tp_cd+"&cntr_no="+cntr_no;
					
//					ComOpenWindow("/hanjin/ESM_BKG_0660.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:710px;dialogHeight:380px;dialogLeft:0;dialogTop:0", true);
                    ComOpenWindow("/hanjin/ESM_BKG_0660.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:710px;dialogHeight:380px;dialogLeft:0;dialogTop:0", true);

				}
			} else if (sheetObj.ColSaveName(Col) == prefix3 + "in_ga_flg") {
				if (sheetObj.CellValue(Row, prefix3 + "in_ga_flg") == "OUT") {

					param="?bl_no="+bl_no+"&bkg_no="+bkg_no;
					param+="&bl_tp_cd="+bl_tp_cd+"&cntr_no="+cntr_no;
					
//					ComOpenWindow("/hanjin/ESM_BKG_0661.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:755px;dialogHeight:300px;dialogLeft:0;dialogTop:0", true);
                    ComOpenWindow("/hanjin/ESM_BKG_0661.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:755px;dialogHeight:300px;dialogLeft:0;dialogTop:0", true);


				}
			}else if (sheetObj.ColSaveName(Col) == prefix3 + "cdo_temp") {
				if (sheetObj.CellValue(Row, prefix3 + "cdo_temp") != "N") {

					param="?bl_no="+bl_no+"&bkg_no="+bkg_no;
					param+="&bl_tp_cd="+bl_tp_cd+"&cntr_no="+cntr_no;
					
//					ComOpenWindow("/hanjin/ESM_BKG_0498.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:500px;dialogLeft:0;dialogTop:0", true);
                    ComOpenWindow("/hanjin/ESM_BKG_0498.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:500px;dialogLeft:0;dialogTop:0", true);
				}
			}
		}
    }

    /**
    * Grid의 OnClick 이벤트가 발생하면 처리 할 사항 : 클릭 된 컨테이너 번호에 해당하는 INVOICE 정보를 보여준다.
    */
   function t1sheet1_2_OnDblClick(sheetObj, row, col){
	   
	   //컨테이너 정보의 첫 번째 컨테이너 번호
       var click_cntr_no = sheetObj.CellValue(row, "t1sheet1_2_cntr_no");

       //클릭 시 상세 팝업 호출
       demDtlPopOpen(click_cntr_no);
   }    
    
     function fnBlInfoClear() {
        //모든 input 항목을 Clear 시킨다.   
        for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
            if (document.form.getElementsByTagName("input")[i].name.substr(0, 12) == "frm_t1sheet1") {
            	document.form.getElementsByTagName("input")[i].value="";
            }     
        }

        //모든 check 항목을 Clear 시킨다.   
        document.form.frm_t1sheet1_bdr_flg.checked = false;
        document.form.frm_t1sheet1_corr_flg.checked = false;

         //Outstanding Amouts 항목을 클리어한다.
         var selOtsAmt = document.form.tot_ots_amt;
         
         for (i=selOtsAmt.length-1; i>=0; i--){
             selOtsAmt.options[i] = null
         }
        
         //Outstanding Demurrage Per B/L 항목을 Clear한다.
         var selDemAmt = document.form.tot_bil_amt;
         
         for (i=selDemAmt.length-1; i>=0; i--){
             selDemAmt.options[i] = null
         }
         
         //트릭으로 만든 B/L NO 셀렉크 박스를  지운다.
         try {
             oTbl.removeNode(true);
         }catch(e){}         
         
    	sheetObjects[t1sheet1].RemoveAll();
//    	sheetObjects[t1sheet2].RemoveAll();
    	sheetObjects[t1sheet3].RemoveAll();
//    	sheetObjects[t1sheet4].RemoveAll();
    	sheetObjects[t1sheet5].RemoveAll();
    	sheetObjects[t1sheet6].RemoveAll();
    	sheetObjects[t1sheet1_1].RemoveAll();
    	sheetObjects[t1sheet1_2].RemoveAll();

        //팝업 버튼을 Disable 시킨다.
        fnButtonInit();
    
    }

    // 검색조건인 BL 번호와 BKG번호를 히든 필드에 저장한다.
    function fnSetHiddenKey() {
    	var formObj = document.form;
    	
    	formObj.h_old_bl_no.value = formObj.combo_bl_no.text;
    	formObj.h_old_bkg_no.value = formObj.bkg_no.value;
    }
    
    //탭을 변경시 조회 조건 변경 여부를 체크하여, 조회 조건이 변경된 경우 자동으로 조회 모듈을 호출한다.
    function fnTabChangeQuery() {
    	var formObj = document.form;
    	
    	// Hidden BL번호와 BKG번호랑 화면에 입력한 BL번호와 BKG번호가 틀린 경우에만 조회 처리를 한다. 
    	if (formObj.h_old_bl_no.value != formObj.combo_bl_no.text ||
    			formObj.h_old_bkg_no.value != formObj.bkg_no.value) {
    		
    		// 검색조건이 변경된 경우에는 기존에 조회된 데이터를 모두 Clear한다.
    		fnBlInfoClear();
    		
    		fnSearch();		//조회 처리 모듈을 호출한다.
    	} else {

    		// 검색조건이 입력된 경우에만 처리한다.
    		if (formObj.combo_bl_no.text != '' || formObj.bkg_no.value != '') {
    		
        		if(beforetab == 0){//B/L Info
                    // 값이 존재하지 않는 경우에는 무조건 조회를 보낸다.
        			if (sheetObjects[t1sheet1].RowCount == 0) {
                    	fnSearch();		//조회 처리 모듈을 호출한다.
                    }
                }else {
                	// 값이 존재하지 않는 경우에는 무조건 조회를 보낸다.
                	fnSearch();		//조회 처리 모듈을 호출한다.
                }
    		}
    	}
    }
	        
	        
    //화면의 조회 처리 모듈을 통합적으로 관리한다.
    function fnSearch() {
    	if(beforetab == 0){//B/L Info
			doActionIBSheet(sheetObjects[t1sheet1],document.form,IBSEARCH);
    	}else {
    		doActionIBSheet(sheetObjects[sheet2],document.form,IBSEARCH,"","");
    	}
    }
    
    //현재 조회되고 있는 Tab을 제외한 나머지를 선택하지 못하도록 제어한다.
    function fnTabEnable(flag) {
    	var formObj = document.form;
    	
    	if (flag == false) {
    		formObj.tab1.Enable = false;
    	} else {
    		formObj.tab1.Enable = true;
    	}
    }

     /**
      * 검색조건을 Clear한다.
      */
     function fnQueryCondClear() {
         document.form.combo_bl_no.RemoveAll();
         document.form.combo_bl_no.text = "";
         document.form.combo_bl_no.BackColor = "White";

         document.form.bkg_no.value = "";
         document.form.cntr_no.value = "";
         document.form.po_no.value = "";
         document.form.hbl_no.value = "";
     }

      /**
      * Hidden IBSheet를 조회하고 나서 처리할 사항
      */
      function t1sheet1_3_OnSearchEnd(sheetObj){

         var invTotBilAmt = 0;

         //컨테이너 정보의 첫 번째 컨테이너 번호
         var fist_cntr_no = sheetObjects[t1sheet1_3].CellValue(1, "t1sheet1_3_cntr_no");

         for(var idx=1; idx <= sheetObj.RowCount; idx++){
             //INVOICE 정보 중 첫 번째 컨테이너 번호에 매치 되는 해당 정보만 보이도록  나머지 로우는 히든 처리
             if(fist_cntr_no != sheetObjects[t1sheet1_3].CellValue(idx, "t1sheet1_3_cntr_no")){
                 sheetObjects[t1sheet1_3].RowHidden(idx) = true;
             }
//             invTotBilAmt += parseInt(sheetObjects[t1sheet1_3].CellValue(idx, "t1sheet1_3_bil_amt"));
         }
//         document.getElementById("invTotBilAmt").value = invTotBilAmt;
     }

     /**
      * DEM.DET 상세 정보 팝업
      */
     function demDtlPopOpen(cntr_no){
         var sXml = IBS_GetDataSearchXml(sheetObjects[t1sheet1_3]);
         document.form.demDtlXmlData.value = sXml;

         var condition = "?";
             condition += "cntr_no="+cntr_no;
//         ComOpenWindow('/hanjin/ESM_BKG_1072.do'+condition, 'demDtl', 'width=500,height=275');
         ComOpenWindowCenter('/hanjin/ESM_BKG_1072.do'+condition, 'demDtl', 500, 275, true);
     }
      
      /**
       * 조회조건의 끝 공백을 제거한다.
       */
      function conditionTrim(){
     	  document.getElementById("combo_bl_no").text = document.getElementById("combo_bl_no").text.trim();
     	  document.getElementById("bl_no").value = document.getElementById("bl_no").value.trim();
     	  document.getElementById("bkg_no").value   = document.getElementById("bkg_no").value.trim();
     	  document.getElementById("cntr_no").value  = document.getElementById("cntr_no").value.trim();
      }

/* 개발자 작업  끝 */