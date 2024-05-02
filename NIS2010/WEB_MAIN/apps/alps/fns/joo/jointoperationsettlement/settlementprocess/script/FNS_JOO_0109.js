/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0100.js
*@FileTitle : ROB Container List Inquiry 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.30 민정호
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
     * @class ees_ctm_0408 : ees_ctm_0408 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0109() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject        	= setSheetObject;
        this.loadPage              		= loadPage;
        this.initSheet             		= initSheet;        
    	this.initControl 					= initControl;        
        this.doActionIBSheet       	= doActionIBSheet;
    } 

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

        var sheetObj = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];
        
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
	            case "btn_call_batch":                	
					doActionIBSheet(sheetObj, formObj, "CALLBATCH");
	                break;
	                
	            case "btn_call_batch_all":                	
					doActionIBSheet(sheetObj, formObj, "CALLBATCHALL");
	                break;
	                
                case "btn_retrieve":                	
        			doActionIBSheet(sheetObj, formObj, IBSEARCH);
                    break;
                    
                case "btn_save":                	
        			doActionIBSheet(sheetObj, formObj, IBSAVE);
                    break;

                case "btn_set":
                	fnEvntSetting();
                    break;
                                        
                case "btn_new":
        			document.form.reset();
        			sheetObj.RemoveAll();
        			sheetObj2.RemoveAll();
        			comboObjects[0].RemoveAll();
        			
        			formObj.in_vvd_cd.focus();        	        			
                    break;
            } // end switch
        } catch(e) {
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

    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
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
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
    	// IBMultiCombo초기화
    	for ( var k = 0; k < comboObjects.length; k++) {
    	    initCombo(comboObjects[k],k+1);
    	}        
            	
    	comboObjects[1].Index = 1;
    	
    	initControl();    	
    }

    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 배열에서 순번
     */
    function initControl() {
    	// ** Date 구분자 **/
    	DATE_SEPARATOR = "-";

    	var formObject = document.form;
    	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - 포커스
    	// 나갈때
    	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - 포커스
    	// 들어갈때
    	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
    	// 키보드
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);    	
    	
    	document.form.in_vvd_cd.focus();    	
    }

    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
        var obj     = event.srcElement;    	
    	    	                
        switch (obj.name){
	        case  'in_vvd_cd':	        	     
	        	
	              if( obj.value.length == 9   ){
	                  doActionIBSheet(sheetObjects[0], formObject, SEARCHLIST01);
	              }else{
	                  sheetObjects[0].RemoveAll();
	                  sheetObjects[1].RemoveAll();
 	            	  comboObjects[0].RemoveAll();
	            	  formObject.in_pol_yd.value = ''; 	            	  
	              }	        	
	        	
	        	break;
	        }    	
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
     */
    function obj_keypress() {
    	switch (event.srcElement.dataformat) {
    	case "uppernum":
    		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
    		ComKeyOnlyAlphabet('uppernum');
    		break;
    	case "upper":
    		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
    		ComKeyOnlyAlphabet('upper');
    		break;
    	case "uppernum2":
    		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
    		ComKeyAlphabetNChar('uppernum');
    		break;
        case "engupspecial": // 영문대문자 + Space + &-,.
        	ComKeyOnlyAlphabet('uppernum', "32|38|45|44|46");
    	    break;
    	default:
    		// 숫자만입력하기(정수,날짜,시간)
    		ComKeyOnlyNumber(event.srcElement);
    	}
    }
          
    /**
     * 콤보 초기설정값
     * 
     * @param {IBMultiCombo}
     *            comboObj comboObj
     */
    function initCombo(comboObj, comboNo) {
        var formObj = document.form
        
        switch(comboNo) {       		
        	case 1: 
                with (comboObj) { 
        		    UseCode = false;
     				MultiSelect = false; 
     				UseAutoComplete = true;
     				SetColAlign("left|left|left|left|left|left");        
     				SetColWidth("50|70|50|50|130|130"); 				 				
      				DropHeight = 160;
     				ValidChar(2,0);//영문대문자
    				SetTitle("Seq.|Port|Yard|Ind|ETA DT|ETD DT");     				
    				ShowCol(1);
      		    }
      			break;
      			
    		case 2: 
    			with (comboObj) { 
    				MultiSelect = false; 
    				UseAutoComplete = true;	
    				SetColAlign("left");        
    				SetColWidth("30");
    				DropHeight = 160;
    				ValidChar(2,0);//영문대문자만 입력가능
    				MaxLength=3;
    			}

    			comboObj.InsertItem(0, "", "");
    			comboObj.InsertItem(1, "0", "0");
    			comboObj.InsertItem(2, "1", "1");
    			comboObj.InsertItem(3, "2", "2");
    			comboObj.InsertItem(4, "3", "3");

    			break;	      			
     	}                 
    }    

    /**
     * ROB Port 세팅, Yard 세팅
     * 
     */    
    function rob_port_cd_OnChange(comboObj) {
        var formObj = document.form
        
        if(comboObjects[0].GetCount() > 0){                        
	        formObj.in_pol_cd.value = comboObj.GetText (comboObj.Index,1);   
	        formObj.in_pol_yd_cd.value = comboObj.GetText (comboObj.Index,2);
	        formObj.clpt_ind_seq.value = comboObj.GetText (comboObj.Index,3);
	        if(comboObj.GetText (comboObj.Index,3) == 1){
	        	formObj.in_pol_yd.value = comboObj.GetText (comboObj.Index,1)+comboObj.GetText (comboObj.Index,2);	
	        }else{
	        	formObj.in_pol_yd.value = comboObj.GetText (comboObj.Index,1)+comboObj.GetText (comboObj.Index,2);
	        }
	        
        }
    }    
        
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
    	var cnt = 0;
    	var sheetID = sheetObj.id;    	

    	switch (sheetID) {
    	case "sheet1":  //sheet1 init
    		with (sheetObj) {
    			// 높이 설정
    			style.height = 340;
    			//전체 너비 설정
    			SheetWidth = mainTable.clientWidth;

    			//Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "")
    				InitHostInfo(location.hostname, location.port, page_path);

    			//전체Merge 종류 [선택, Default msNone]
//    			MergeSheet = msPrevColumnMerge + msHeaderOnly;
    			MergeSheet = msHeaderOnly;    			

    			//전체Edit 허용 여부 [선택, Default false]
    			Editable = true;

    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo(1, 1, 5, 100);

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, false, true, false, false);

    			var HeadTitle  = "STS| |Container|Year|CNMV_ID_NO|MVMT|Event Date|Yard|VSL|VOY|DIR|IND|(New)IND|(Change)Event Date";
    			var headCount = ComCountHeadTitle(HeadTitle);

    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(headCount, 0, 0, true);
    			
    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle, true);
    			
    			var prefix = "sheet1_";
    			
    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++, dtStatus  ,  30, daCenter, false , prefix+"ibflag"   );    			
    			InitDataProperty(0, cnt++, dtCheckBox ,  30, daCenter, false , prefix+"del_chk"  );    			
    			InitDataProperty(0, cnt++, dtData     ,  80, daCenter, false,  prefix+"cntr_no" , 				false, "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  60, daCenter, false,  prefix+"cnmv_yr",		 		false, "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtHidden  ,  60, daCenter, false, prefix+"cnmv_id_no", 			false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  60, daCenter, false, prefix+"mvmt_sts_cd", 		false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  130, daCenter, false, prefix+"cnmv_evnt_dt", 		false , "", dfUserFormat2, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  60, daCenter, false, prefix+"inp_yd_cd", 		 		false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  60, daCenter, false, prefix+"crnt_vsl_cd", 	 		false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  60, daCenter, false, prefix+"crnt_skd_voy_no", 	false , "", dfNone, 0, false, false);    			
    			InitDataProperty(0, cnt++, dtData     ,  60, daCenter, false, prefix+"crnt_skd_dir_cd", 		false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  60, daCenter, false, prefix+"clpt_ind_seq2", 		false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  60, daCenter, false, prefix+"clpt_ind_seq3", 		false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  130, daCenter, false, prefix+"cnmv_dt", 				false , "", dfUserFormat2, 0, false, false);    			
    			    	        
    			InitUserFormat2(0, prefix+"cnmv_evnt_dt", "####-##-## ##:##:##", "-|:" );
    	        InitUserFormat2(0, prefix+"cnmv_dt", "####-##-## ##:##:##", "-|:" );    			
	    	}
	    	break;

    	case "sheet2": //sheet2 init
    		with (sheetObj) {

    			// 높이 설정
    			style.height = 100;
    			//전체 너비 설정
    			SheetWidth = mainTable.clientWidth;

    			//Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "")
    				InitHostInfo(location.hostname, location.port, page_path);

    			//전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msHeaderOnly;

    			//전체Edit 허용 여부 [선택, Default false]
    			Editable = true;

    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo(1, 1, 3, 100);

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, false, true, false, false);

    			var HeadTitle  = "STS||CNTR_NO|CNMV_YR|CNMV_ID_NO|MVMT|Event Date|VSL|VOY|DIR|YARDD|IND" +
    								   "|ETA|ETB|ETD|(Change)Event Date";
    			var headCount = ComCountHeadTitle(HeadTitle);

    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(headCount, 0, 0, true);
    			
    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle, true);

    			var prefix = "sheet2_";
    			
    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++, dtStatus   ,  30, daCenter, true , prefix+"ibflag"   );
    			InitDataProperty(0, cnt++, dtCheckBox ,  30, daCenter, true , prefix+"del_chk"  );
    			InitDataProperty(0, cnt++, dtHidden     ,  30, daCenter, true , prefix+"cntr_no"      , false, "", dfNone, 0, false, false);    			
    			InitDataProperty(0, cnt++, dtHidden     ,  30, daCenter, true , prefix+"cnmv_yr"      , false, "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtHidden     ,  30, daCenter, false, prefix+"cnmv_id_no"    , false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  60, daCenter, false, prefix+"mvmt_sts_cd"     , false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  120, daCenter, false, prefix+"cnmv_evnt_dt"     , false , "", dfUserFormat2, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  40, daCenter, false, prefix+"vsl_cd"    , false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  40, daCenter, false, prefix+"skd_voy_no"     , false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  40, daCenter, false, prefix+"skd_dir_cd"     , false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  60, daCenter, false, prefix+"yd_cd"     , false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  30, daCenter, false, prefix+"clpt_ind_seq"     , false , "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  120, daCenter, false, prefix+"vps_eta_dt"     , false , "", dfUserFormat2, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  120, daCenter, false, prefix+"vps_etb_dt"     , false , "", dfUserFormat2, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  120, daCenter, false, prefix+"vps_etd_dt"     , false , "", dfUserFormat2, 0, false, false);
    			InitDataProperty(0, cnt++, dtData     ,  120, daCenter, false, prefix+"cnmv_dt"     , false , "", dfUserFormat2, 0, false, false);			

    	        InitUserFormat2(0, prefix+"cnmv_evnt_dt", "####-##-## ##:##:##", "-|:" );
    	        InitUserFormat2(0, prefix+"vps_eta_dt", "####-##-## ##:##:##", "-|:" );
    	        InitUserFormat2(0, prefix+"vps_etb_dt", "####-##-## ##:##:##", "-|:" );
    	        InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##:##", "-|:" );
    	        InitUserFormat2(0, prefix+"cnmv_dt", "####-##-## ##:##:##", "-|:" );    	        

    		}
    		break;    	
    	}
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
	        case "CALLBATCH": // JOO_CNTR_MVMT_EVNT_DT_SLAN_PRC 프로시저 호출

	        	formObj.slane.value = formObj.in_slan_cd.value;

	        	if(formObj.slane.value == ""){
	        		ComShowCodeMessage("JOO00116", "Lane Code");
	        		return false;
	        	}
				formObj.f_cmd.value = COMMAND01;
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0109GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml, false);
				
	    		break;

	        case "CALLBATCHALL": // JOO_CNTR_MVMT_EVNT_DT_ALL_PRC 프로시저 호출

				formObj.f_cmd.value = COMMAND02;
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0109GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml, false);
				
	    		break;
	    		
            case IBSEARCH:      //조회    			
            	            	
            	formObj.vvd.value = formObj.in_vvd_cd.value;
            	formObj.inp_yd_cd.value = formObj.in_pol_yd.value;            	            	
            	formObj.clpt_ind_seq2.value = comboObjects[1].Code;		
            	
            	
                formObj.f_cmd.value = SEARCH;

                var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열    		
    			var sXml = sheetObj.GetSearchXml("FNS_JOO_0109GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));    					
				sheetObjects[0].LoadSearchXml(sXml);
            	
                break;
                
            case IBSEARCH_ASYNC01:      //조회    			
                formObj.f_cmd.value = SEARCH01;

                var aryPrefix = new Array("sheet2_");	//prefix 문자열 배열    		
    			var sXml = sheetObj.GetSearchXml("FNS_JOO_0109GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));    					
				sheetObjects[1].LoadSearchXml(sXml);
            	
                break;

            case IBSAVE:      //조회    			
                formObj.f_cmd.value = MULTI;
                
    			var SaveStr = ComGetSaveString(sheetObjects);		
    			
    			if (SaveStr == ""){
    				ComShowCodeMessage("JOO00036");
    				return false;
    			}
    						
    			if (!ComShowCodeConfirm("JOO00046")){
    				return false;
    			}    			

                var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열    		
    			var sXml = sheetObj.GetSaveXml("FNS_JOO_0109GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));    			
				sheetObjects[0].LoadSearchXml(sXml);
				sheetObjects[1].RemoveAll();
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            	
                break;                
                
            case SEARCHLIST01:      //ROB Port 조회
            	formObj.f_cmd.value = SEARCHLIST01;            
                var param =  FormQueryString(formObj);
                var sXml  =  sheetObj.GetSearchXml("FNS_JOO_0100GS.do", param);
                                
				var clptSeqList = ComGetEtcData(sXml, "clpt_seq").split("|");
				var portCdList = ComGetEtcData(sXml, "vps_port_cd").split("|");
				var tmlCdlList = ComGetEtcData(sXml, "tml_cd").split("|");			
				var clptIndSeqList = ComGetEtcData(sXml, "clpt_ind_seq").split("|");
				var etaDtList = ComGetEtcData(sXml, "eta_dt").split("|");
				var etdDtList = ComGetEtcData(sXml, "etd_dt").split("|");				
                
				comboObjects[0].RemoveAll();
		        formObj.in_pol_cd.value = "";				
				formObj.in_pol_yd_cd.value = '';
				formObj.clpt_ind_seq.value = '';
				formObj.in_pol_yd.value = '';
												
				for(var i=0; i < clptSeqList.length; i++){
					if(clptSeqList[i] != ''){
						comboObjects[0].InsertItem(i, clptSeqList[i]+"|"+portCdList[i]+"|"+tmlCdlList[i]+"|"+clptIndSeqList[i]+"|"+etaDtList[i]+"|"+etdDtList[i], portCdList[i]);
					}
				}
				
                break;                   
                
        }
    }
    
    /**
     * 셀을 마우스 더블클릭했을때 발생하는 이벤트 <br>
     */
    function sheet1_OnDblClick(sheetObj, Row, Col ){    	
    	var formObj = document.form;
		var prefix = "sheet1_";

		formObj.cntr_no.value = sheetObj.CellValue(Row, prefix+"cntr_no");
		formObj.cnmv_yr.value = sheetObj.CellValue(Row, prefix+"cnmv_yr");
		formObj.cnmv_id_no.value = sheetObj.CellValue(Row, prefix+"cnmv_id_no");
		formObj.mvmt_sts_cd.value = sheetObj.CellValue(Row, prefix+"mvmt_sts_cd");
		formObj.cnmv_evnt_dt.value = sheetObj.CellValue(Row, prefix+"cnmv_evnt_dt");		
		formObj.vsl_cd.value = sheetObj.CellValue(Row, prefix+"crnt_vsl_cd");
		formObj.skd_voy_no.value = sheetObj.CellValue(Row, prefix+"crnt_skd_voy_no");
		formObj.skd_dir_cd.value = sheetObj.CellValue(Row, prefix+"crnt_skd_dir_cd");
		formObj.yd_cd.value = sheetObj.CellValue(Row, prefix+"inp_yd_cd");
		
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		
    }
    
    /**
     * 셀을 마우스 더블클릭했을때 발생하는 이벤트 <br>
     */
    function sheet2_OnClick(sheetObj, Row, Col ){
    	var formObj = document.form;
		var prefix = "sheet2_";
    	
		if(Col == '1'){
			if(sheetObj.CellValue(Row, prefix+"del_chk") == '0'){
				if(sheetObj.CellValue(Row, prefix+"mvmt_sts_cd") == 'VL'){
					sheetObj.CellValue(Row, prefix+"cnmv_dt") = sheetObj.CellValue(Row, prefix+"vps_eta_dt"); 					
				}else if(sheetObj.CellValue(Row, prefix+"mvmt_sts_cd") == 'VD'){
					sheetObj.CellValue(Row, prefix+"cnmv_dt") = sheetObj.CellValue(Row, prefix+"vps_etd_dt");					
				}
			}else{
				sheetObj.CellValue(Row, prefix+"cnmv_dt") = '';				
			}
		}		
    }

    /**
     * Event Date Setting<br>
     */    
    function fnEvntSetting(){
    	
    	var sel = 0;
    	var selCnt = 0;
    	var sheet2_cnmv_dt = '';
    	var sheet2_clpt_ind_seq = '';    
    	var vsl_cd = '';
    	var skd_voy_no = '';
    	var skd_dir_cd = '';    	
    	    	
    	for(var i=1; i<=sheetObjects[1].RowCount; i++){    			
    		if(sheetObjects[1].CellValue(i,"sheet2_"+"del_chk") == '1'){
    			selCnt = selCnt + 1;
    			sel = i;
    		}
        }
    	    	
    	if(selCnt == 1){
    		sheet2_cnmv_dt 		= sheetObjects[1].CellValue(sel,"sheet2_"+"cnmv_dt");
    		sheet2_clpt_ind_seq 	= sheetObjects[1].CellValue(sel,"sheet2_"+"clpt_ind_seq");
    		sheet2_yd_cd 			= sheetObjects[1].CellValue(sel,"sheet2_"+"yd_cd");    		
    		vsl_cd 			= sheetObjects[1].CellValue(sel,"sheet2_"+"vsl_cd");
    		skd_voy_no 			= sheetObjects[1].CellValue(sel,"sheet2_"+"skd_voy_no");
    		skd_dir_cd 			= sheetObjects[1].CellValue(sel,"sheet2_"+"skd_dir_cd");    		
    		    		    		    		
        	for(var row=1; row<=sheetObjects[0].RowCount; row++){    			
//        		if(sheetObjects[0].CellValue(row,"sheet1_"+"del_chk") == '1' &&
//        				sheetObjects[0].CellValue(row,"sheet1_"+"inp_yd_cd") == sheet2_yd_cd &&
//        				sheetObjects[0].CellValue(row,"sheet1_"+"clpt_ind_seq2") == '0'        				        					
//        			){
        		
        		if( sheetObjects[0].CellValue(row,"sheet1_"+"inp_yd_cd") == sheet2_yd_cd &&
        		    sheetObjects[0].CellValue(row,"sheet1_"+"clpt_ind_seq2") == '0' &&
        		    sheetObjects[0].CellValue(row,"sheet1_"+"crnt_vsl_cd") == vsl_cd &&
        		    sheetObjects[0].CellValue(row,"sheet1_"+"crnt_skd_voy_no") == skd_voy_no &&
        		    sheetObjects[0].CellValue(row,"sheet1_"+"crnt_skd_dir_cd") == skd_dir_cd
        		){

        			sheetObjects[0].CellValue(row,"sheet1_"+"del_chk") = '1';
        			sheetObjects[0].CellValue(row, "sheet1_"+"cnmv_dt") = sheet2_cnmv_dt;
        			sheetObjects[0].CellValue(row, "sheet1_"+"clpt_ind_seq3") = sheet2_clpt_ind_seq;        			
        		}else{
        			sheetObjects[0].CellValue(row,"sheet1_"+"ibflag") = ''; 
        			sheetObjects[0].CellValue(row,"sheet1_"+"del_chk") = '0';        			
        		}
            }    		
    	}
    	
    }
/* 개발자 작업  끝 */
