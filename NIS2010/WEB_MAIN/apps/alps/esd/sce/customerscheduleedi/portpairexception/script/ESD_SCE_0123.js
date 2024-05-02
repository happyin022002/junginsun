/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_SCE_0123.js
*@FileTitle : 화주전송 Schedule 관리화면
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.01.08 함대성
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
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_SCE_0123 : ESD_SCE_0123 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SCE_0123() {
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
  //IBMultiCombo
    var comboList;
    var comboObjects = new Array();
    var comboCnt = 0;
    
    
    var prefix = "sheet2_";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
     function setComboObject(combo_obj){
         comboObjects[comboCnt++] = combo_obj;
     }

     /**
      * 콤보 초기설정값
      * @param {IBMultiCombo} comboObj  comboObj
      */
     function initCombo(comboObj) {
         comboObj.UseCode = true;
         comboObj.LineColor = "#ffffff";
         comboObj.SetColAlign("left|left");
         comboObj.MultiSeparator = ",";
         comboObj.DropHeight = 120;
         
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
 		initControl();
 		comboCnt = comboObjects.length;
 	    for(var k=0;k<comboCnt;k++){
 	        initCombo(comboObjects[k]);
 	    }
 	    
 	    // TP ID을 조회한다.
 	    doActionIBSheet(sheetObjects[0], document.form, SEARCHLIST);
 		document.getElementById("mainTable2").style.display = "";
     }
     
     /**
      * 콤보박스의 값을 불러오는함수  
      */
     function setComboList(){
         var formObj = document.form;
         if (formObj.f_cmd.value == SEARCHLIST){
        	 comboObjects[0].RemoveAll();
             for(var i=0 ; i < comboList.length ; i++ ) {
                 var combo = comboList[i];               
                 comboObjects[0].InsertItem(i,combo["cust_trd_prnr_id"]+"|"+combo["cust_trd_prnr_nm"],combo["cust_trd_prnr_id"]);
                 comboObjects[0].Index = [6];
             }
         }   
         
     }
    
    /*
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     */
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "/";
    	var formObj = document.form; 
        
        axon_event.addListenerForm  ('keypress', 'fnObjKeyPress',  formObj );
        axon_event.addListenerFormat('change',	 'obj_change',	formObj); //- 변경될때.
     }
    
 
    /**
     * <pre>
     *    form Element의 KeyPress Event 발생시 처리.
     *    
     * </pre>
     * @return
     */ 
    function fnObjKeyPress(){
        var obj = event.srcElement;
        var formObj = document.form;
        var attr    = obj.getAttribute("dataformat");
        
        switch (attr){
        	case  '':
        		break;
            case  'ymd':
                  ComKeyOnlyNumber( obj );
                  break;

            case  'engup':
                  ComKeyOnlyAlphabet( 'upper' );
                  break;     
            case  'engupnum':
                  ComKeyOnlyAlphabet( 'uppernum' );
                  break;   
 
        }
    }
    var preText = null; 
  	function cust_trd_prnr_id_OnChange(obj){
  		var txt = obj.Text;
  		if(sheetObjects[0].RowCount !=0){
  			if(ComShowConfirm(ComGetMsg('SCE02002', "If you change the TP ID, the page will be renewed"))){
  				sheetObjects[0].RemoveAll();
  			}else{
  				comboObjects[0].Text2 = preText;
  				return false;
  			}
  		}
  		if(txt != ""){
  			var combo = comboList[obj.Index];
  			document.form.partnerName.value = combo["cust_trd_prnr_nm"];
  			document.form.cust_trd_prnr_id.value = txt;
		}
  		preText = txt;
	}
     

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];

    	/*******************************************************/
    	var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch (srcName) { 
    		case "btn_retrieve":
    				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
    			
    			break;

    		case "btn_new":
    			sheetObject1.RemoveAll();
    			//sheetObject0.RemoveAll();
    			
    			comboObjects[0].Text = "";
    			formObj.partnerName.value = "";
    			formObj.pol_cd.value = "";
    			formObj.pol_cnt.value = "";
    			formObj.pod_cd.value = "";
    			formObj.pod_cnt.value = "";
    			formObj.slan_cds.value = "";
    			
    			comboObjects[0].focus();
    			comboObjects[0].Index = [6];
    			break;

    		case "btn_save":
    			doActionIBSheet(sheetObject1, formObj, IBSAVE);
    			break;
    			
			case "btn_RowAdd":
				//sheetObject1.DataCopy();	//선택행아래 복사[Sheet1]
				//doRowAdd(sheetObject1, formObj);
				if(comboObjects[0].Text ==""){
					ComShowMessage(ComGetMsg('SCE02002', "Please select TP ID before add a new row"));
					return false;
				}
				var iRow = sheetObject1.DataInsert(-1);
				var i    = sheetObject1.selectRow;
				//key
				if(i == 2){
					sheetObject1.CellValue(i,prefix+"cust_trd_prnr_id") = comboObjects[0].Text;
				}else{
					sheetObject1.CellValue(i,prefix+"cust_trd_prnr_id") = sheetObject1.CellValue(i-1,prefix+"cust_trd_prnr_id");
				}
				//기타  
				sheetObject1.CellValue(i,prefix+"etd_adj_dy") = "";
				sheetObject1.CellValue(i,prefix+"dct_adj_dy") = "";
				sheetObject1.CellValue(i,prefix+"cct_adj_dy") = "";
				
				sheetObj = sheetObject1;
				
				allEdit1(sheetObj, i);
				allEdit2(sheetObj, i);
				break;
			
			case "btn_RowDelete":
				ComRowHideDelete(sheetObject1,prefix+"check");
			break;
			
			case "btns_country1":
        	    var classId = "COM_ENS_0M1";
    		    var param = '?classId='+classId;
    		    var v_display = "1,0,1,1,1,1,1,1";
    		    //sUrl, iWidth, iHeight, sTargetObjList,sDisplay, bModal, sScroll) 	
    		    ComOpenPopup('/hanjin/COM_ENS_0M1.do', 700, 440, "setPopData_POLCountry", v_display, true);
				break;
				
			case "btns_country2":
        	    var classId = "COM_ENS_0M1";
    		    var param = '?classId='+classId;
    		    var v_display = "1,0,1,1,1,1,1,1";
    		    ComOpenPopup('/hanjin/COM_ENS_0M1.do' , 700, 440, "setPopData_PODCountry", v_display, true);
				break;
    		} // end switch
    	} catch (e) {
    		if (e == "[object Error]") {
    			ComShowCodeMessage('JOO00001');
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    
    /**
	 * Country Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_POLCountry(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.pol_cnt, aryPopupData[0][3]);
		}
	}
	
	function setPopData_PODCountry(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.pod_cnt, aryPopupData[0][3]);
		}
	}
	
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo, rlaneSheetList) {
    	var cnt = 0;

        switch(sheetNo) {
        
        case 1:      //IBSheet1 init
           
        	with (sheetObj) {
            //전체 너비 설정
            style.height = 260 ;
            SheetWidth = mainTable2.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 2, 1, 9, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(30, 7, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            var HeadTitle =  "SEQ|Sel.|STS|POL|POL|POD|POD|Adj Lane|ETD|ETD|DCT|DCT|DCT|DCT|DCT|DCT|DCT|CCT|CCT|CCT|CCT|CCT|CCT|CCT";
            var HeadTitle1 = "SEQ|Sel.|STS|POL|COUNTRY|POD|COUNTRY|Adj Lane|Day|Time|Day|Day|ETB|ETB|ETD|ETD|Time|Day|Day|ETB|ETB|ETD|ETD|Time";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);
            InitHeadRow(1, HeadTitle1, false);

        	
            //데이터속성    	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  true,    prefix+"seq",     	  false,          "",       dfNone,   	0,  	false, 		false, 3,         true);
            InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  true,    prefix+"check",      false,          "",       dfNone,	    0,  	true,  		true, 1,         true);
            InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter,  true,    prefix+"ibflag",  	  false,          "",       dfNone,	    0,  	true,  		true,  5,         true);
            InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,    prefix+"pol_cd",     false,          "",       dfEngUpKey, 0,  	false, 		true,  5,     false);
            InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,    prefix+"pol_cnt_cd",     false,          "",       dfEngUpKey, 0,  	false, 		true,  5,     false);
            InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,    prefix+"pod_cd",     false,          "",       dfEngUpKey, 0,  	false, 		true,  5,     false);
            InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,    prefix+"pod_cnt_cd",     false,          "",       dfEngUpKey, 0,  	false, 		true,  5,     false);
            //InitDataProperty(0, cnt++,  dtPopup, 	  60,    daCenter,  true,    prefix+"block_lane", false , 		  "",       dfNone,  	0,  	true, 		true,  1,      false);
            
            InitDataProperty(0, cnt++,  dtPopup ,  	  60,    daCenter,  true,    prefix+"slan_cds",    false , 	  	  "",       dfEngUpKey, 0,  	true, 		true,  5,      false);
            
            InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    prefix+"etd_adj_dy", false,          "",       dfNone,  	0,  	true, 		true,  5,         false);
            InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    prefix+"etd_adj_hrmnt",   false,     "",  		dfUserFormat,0,  	true, 		true,  4,         false);
            
            InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  true,    prefix+"is_dct_adj_dy",   	 	  false,          "",       dfNone,  	0,  	true, 		false,  5,         false);
            InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    prefix+"dct_adj_dy", false,       	  "",       dfNone,  	0, 	 	true, 		false,  5,         false);
            InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  true,    prefix+"is_dct_adj_etb",    	  false,      	  "",       dfNone,  	0,  	true, 		false,  5,         false);
            InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    prefix+"dct_adj_etb_dys",    false,  "",       dfNullFloat,1,  	true, 		false,  5,         false);
            InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  true,    prefix+"is_dct_adj_etd",    	  false,      	  "",       dfNone,  	0,  	true, 		false,  5,         false);
            InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    prefix+"dct_adj_etd_dys",    false,  "",       dfNullFloat,1,  	true, 		false,  5,         false);
            InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    prefix+"dct_adj_hrmnt",    false,    "",  		dfUserFormat,0,  	true, 		false,  4,         false);
            	
            InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  true,    prefix+"is_cct_adj_dy",   	 	  false,          "",       dfNone,  	0,  	true, 		false,  5,         false);
            InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    prefix+"cct_adj_dy",    false,       "",       dfNullFloat,0,  	true, 		false,  5,         false);
            InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  true,    prefix+"is_cct_adj_etb",    	  false,      	  "",       dfNone,  	0,  	true, 		false,  5,         false);
            InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    prefix+"cct_adj_etb_dys",    false,  "",       dfNullFloat,1,  	true, 		false,  5,         false);
            InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  true,    prefix+"is_cct_adj_etd",    	  false,      	  "",       dfNone,  	0,  	true, 		false,  5,         false);
            InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    prefix+"cct_adj_etd_dys",    false,  "", 		dfNullFloat,1,  	true, 		false,  5,         false);
            InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    prefix+"cct_adj_hrmnt",    false,    "",   	dfUserFormat,0,  	true, 		false,  4,         false);
            
            //hidden fields 
            InitDataProperty(0, cnt++  , dtHidden,    100,   daCenter,  true,    prefix+"cust_trd_prnr_id", false,    "",       dfEngUpKey,  0,  	false, 		true,  5,     false);
            InitDataProperty(0, cnt++ , dtHidden,    50,    daCenter,  true,    prefix+"adj_rgst_dt", 		false,        "",       dfNone, 	 0, 	false, 		false, 8,         true);
             InitDataProperty(0, cnt++ , dtHidden,    50,    daCenter,  true,    prefix+"adj_seq", 		false,        "",       dfNone, 	 0, 	false, 		false, 9,         true);
             InitDataProperty(0, cnt++ , dtHidden,    50,    daCenter,  true,    prefix+"dct_adj_tp_nm", false,       "",       dfNone, 	 0, 	false, 		false, 20,        false);
             InitDataProperty(0, cnt++ , dtHidden,    50,    daCenter,  true,    prefix+"cct_adj_tp_nm", false,       "",       dfNone, 	 0, 	false, 		false, 20,        false);
             
             InitDataProperty(0, cnt++ , dtHidden,    50,    daCenter,  true,    prefix+"rout_seq", false,            "",       dfNone, 	 0, 	false, 		false, 1,         true);
             
			 InitDataValid(0, prefix+"pol_cd", vtEngUpOnly);			
			 InitDataValid(0, prefix+"pod_cd", vtEngUpOnly);	
			 
             //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
			 InitUserFormat(0, prefix+"etd_adj_hrmnt", "####", "" );	
			 InitUserFormat(0, prefix+"dct_adj_hrmnt", "####", "" );
			 InitUserFormat(0, prefix+"cct_adj_hrmnt", "####", "" );
			 //InitUserFormat2(0, prefix+"updDt", "####-##-## ##:##", "-|:" );
			 InitDataCombo(0, prefix+"etd_adj_dy", "SUN|MON|TUE|WED|THU|FRI|SAT"      , "1|2|3|4|5|6|7");
			 InitDataCombo(0, prefix+"dct_adj_dy", "SUN|MON|TUE|WED|THU|FRI|SAT"      , "1|2|3|4|5|6|7");
			 InitDataCombo(0, prefix+"cct_adj_dy", "SUN|MON|TUE|WED|THU|FRI|SAT"      , "1|2|3|4|5|6|7");
			 
	         RangeBackColor(1, 5, 1, 9) = RgbColor(222, 251, 248);   // ENIS
	         HeadRowHeight = 20 ;
    		} 
        break;
            
        }
    }
     
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	switch (sAction) { 
    	case IBSEARCH: //조회
    		if (validateForm(sheetObj, formObj, sAction)){
    			/*if(formObj.partnerName.value == ""){
	    		    form.f_cmd.value = SEARCH01; 
	    		    var formObj = document.form;
	    			//sheetObjects[0].WaitImageVisible = false;
	    		    var sXml = sheetObjects[0].GetSearchXml("ESD_SCE_0122GS.do" , SceFrmQryString(form));
	    		    //텍스트 가져오기[partnerName]
	    		    if(sXml != ""){
		    		    var partnerName = ComGetEtcData(sXml,"partnerName");
		    		    var custTrdPrnrId = ComGetEtcData(sXml,"custTrdPrnrId") == "" ? "" : ComGetEtcData(sXml,"custTrdPrnrId");
		    		    formObj.partnerName.value  = partnerName;
	
		    		    checkOption(custTrdPrnrId);
	    		    }
    			}*/
    			
    			formObj.f_cmd.value = SEARCH;
    			formObj.cust_trd_prnr_id.value = comboObjects[0].Text;
    			sheetObj.DoSearch("ESD_SCE_0123GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam(prefix));
    		}
    	break;
    	
    	

    	case IBSAVE: //저장 : C1T0W
    		if (validateForm(sheetObj, formObj, sAction)){
    			var SaveStr = ComGetSaveString(sheetObj);
    			if (SaveStr == ""){
    				ComShowCodeMessage("SCE01222");
    				return;
    			}
    			
    			formObj.f_cmd.value = MULTI;
    			var aryPrefix = new Array("sheet2_");	//prefix 문자열 배열	
    			var sXml = sheetObj.GetSaveXml("ESD_SCE_0123GS.do", SaveStr + "&" + SceFrmQryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
    			
    			sheetObj.LoadSearchXml(sXml);
    			//저장후 조회 
    			doActionIBSheet(sheetObj, formObj, IBSEARCH);
    	 		//document.form.cust_trd_prnr_id.focus();
    		}
    	break;
		
        case SEARCH01:
			document.getElementByName('cust_trd_prnr_id').value = document.getElementByName('cust_trd_prnr_id').value.toUpperCase();
			sheetObj.ShowDebugMsg = false;
			formObj.f_cmd.value = SEARCH01; 
			sheetObj.DoSearch("ESD_SCE_0123GS.do",SceFrmQryString(formObj));
			var partnerName = sheetObj.EtcData("partnerName");
			document.getElementById('partnerName').value = sheetObj.EtcData("partnerName");
			//IBS_EtcDataToForm2(formObj,sheetObj) ;
			sheetObj.RemoveAll();
		break; 
		
        case SEARCHLIST:
        	formObj.f_cmd.value = SEARCHLIST;
            var sXml = sheetObj.GetSearchXml("ESD_SCE_0123GS.do", SceFrmQryString(formObj));
            comboList = ComXml2ListMap(sXml);  
            setComboList();
            break;
		break; 
    	}
    }
   
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
   function validateForm(sheetObj, formObj, sAction) {
   	sheetObj.ShowDebugMsg = false;
   	switch (sAction) {
   			case IBSEARCH:	//조회
   				if(comboObjects[0].Text == ""){
   					ComShowMessage(ComGetMsg('SCE01221', "TP ID"));
   					return false;
   				}
   			break;
   			
			case IBSAVE:   //저장
				
				for (var inx=2; inx <= sheetObj.RowCount+1; inx++){
					if (sheetObj.CellValue(inx, prefix+"ibflag") == "I" || sheetObj.CellValue(inx, prefix+"ibflag") == "U"){
						//Key Check
						
						//pol_cd 나 pol_cnt_cd 중 하나만 입력되어있어야 함
						if(sheetObj.CellValue(inx, prefix+"pol_cd") == "" && sheetObj.CellValue(inx, prefix+"pol_cnt_cd") == ""){
							ComShowMessage(ComGetMsg('SCE02002', "Please enter either pol code or pol country code"));
							sheetObj.SelectCell(inx, prefix+"pol_cd" , true );
							return false;
						}
						if(sheetObj.CellValue(inx, prefix+"pol_cd") != "" && sheetObj.CellValue(inx, prefix+"pol_cnt_cd") != ""){
							ComShowMessage(ComGetMsg('SCE02002', "Please enter only one between pol code and pol country code"));
							sheetObj.SelectCell(inx, prefix+"pol_cd" , true ); 
							return false;
						}
						//pod_cd 나 pod_cnt_cd 중 하나만 입력되어있어야 함
						if(sheetObj.CellValue(inx, prefix+"pod_cd") == "" && sheetObj.CellValue(inx, prefix+"pod_cnt_cd") == ""){
							ComShowMessage(ComGetMsg('SCE02002', "Please enter either pod code or pod country code"));
							sheetObj.SelectCell(inx, prefix+"pod_cd" , true ); 
							return false;
						}
						if(sheetObj.CellValue(inx, prefix+"pod_cd") != "" && sheetObj.CellValue(inx, prefix+"pod_cnt_cd") != ""){
							ComShowMessage(ComGetMsg('SCE02002', "Please enter only one between pod code and pod country code"));
							sheetObj.SelectCell(inx, prefix+"pod_cd" , true ); 
							return false;
						}
						
						
						if(sheetObj.CellValue(inx, prefix+"slan_cds") == ""){
							ComShowMessage(ComGetMsg('SCE01221', "Lane"));
							return false;
						}
						//sheetObj.CellValue(inx,prefix+"cust_trd_prnr_id") = formObj.cust_trd_prnr_id.value;
						
						
						
						//Time Check
						if(sheetObj.CellValue(inx, prefix+"etd_adj_dy") != "" && sheetObj.CellValue(inx, prefix+"etd_adj_hrmnt") == ""){
							ComShowMessage(ComGetMsg('SCE01221', "ETD Time"));
							return false;
						}
						if((sheetObj.CellValue(inx, prefix+"dct_adj_dy") != "" || sheetObj.CellValue(inx, prefix+"dct_adj_etb_dys") != "" || sheetObj.CellValue(inx, prefix+"dct_adj_etd_dys") != "") && sheetObj.CellValue(inx, prefix+"dct_adj_hrmnt") == ""){
							ComShowMessage(ComGetMsg('SCE01221', "DCT Time"));
							return false;
						}
						if((sheetObj.CellValue(inx, prefix+"cct_adj_dy") != "" || sheetObj.CellValue(inx, prefix+"cct_adj_etb_dys") != "" || sheetObj.CellValue(inx, prefix+"cct_adj_etd_dys") != "") && sheetObj.CellValue(inx, prefix+"cct_adj_hrmnt") == ""){
							ComShowMessage(ComGetMsg('SCE01221', "CCT Time"));
							return false;
						}

						if(sheetObj.cellvalue(inx, prefix+"is_dct_adj_dy") == 1 && sheetObj.CellValue(inx, prefix+"dct_adj_dy") == ""){
							ComShowMessage(ComGetMsg('SCE01221', "DCT Day"));
							return false;
						}
						if(sheetObj.cellvalue(inx, prefix+"is_dct_adj_etb") == 1 && sheetObj.CellValue(inx, prefix+"dct_adj_etb_dys") == ""){
							ComShowMessage(ComGetMsg('SCE01221', "DCT ETB"));
							return false;
						}
						if(sheetObj.cellvalue(inx, prefix+"is_dct_adj_etd") == 1 && sheetObj.CellValue(inx, prefix+"dct_adj_etd_dys") == ""){
							ComShowMessage(ComGetMsg('SCE01221', "DCT ETD"));
							return false;
						}
						if(sheetObj.cellvalue(inx, prefix+"is_cct_adj_dy") == 1 && sheetObj.CellValue(inx, prefix+"cct_adj_dy") == ""){
							ComShowMessage(ComGetMsg('SCE01221', "CCT Day"));
							return false;
						}
						if(sheetObj.cellvalue(inx, prefix+"is_cct_adj_etb") == 1 && sheetObj.CellValue(inx, prefix+"cct_adj_etb_dys") == ""){
							ComShowMessage(ComGetMsg('SCE01221', "CCT ETB"));
							return false;
						}
						if(sheetObj.cellvalue(inx, prefix+"is_cct_adj_etd") == 1 && sheetObj.CellValue(inx, prefix+"cct_adj_etd_dys") == ""){
							ComShowMessage(ComGetMsg('SCE01221', "CCT ETD"));
							return false;
						}
					}
				}
			break;
   	}
   	return true;
   } 
    
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }
    
    /*
    * 숫자체크 
    */
      function checkNumber(sValue){
   	  try{
   		var value = sValue.search(/^\d*(\.?\d*)$/gi);
   	    if(value !=-1){
   	    	return true;
   	    }else{
   	        return false;
   	    }
   	  }catch(errorObject){
   	    showErrorDig("checkNumber()", errorObject);
   	  }
   	}
   
    function ComGetDateAdd2(sDate, sFlag, iVal, sDelim){
      try {
          if (sDelim==null || sDelim==undefined) sDelim = "-";

          if (sDate==null || sDate==undefined) {
              sDate = new Date();
          } else {
              //문자열 또는 HTML태그(Object)인 경우 처리
              sDate = getArgValue(sDate); 
          }

          var yy = eval(sDate); 
          iVal = ComParseInt(iVal);	//인자가 문자열로 들어온 경우 에러 발생함

          switch(sFlag.toLowerCase()) {
              case "y":   yy += eval(iVal);    break;
          }

          return yy ;
      } catch(err) { ComFuncErrMsg(err.message); }
     }
    /*
    function sheet2_OnSearchEnd(sheetObj,errMsg){
		for (var i=1; i<=sheetObj.RowCount+1; i++) {
			var a = sheetObj.CellValue(i,prefix+"is_dct_adj_dy");
			var b = sheetObj.CellValue(i,prefix+"is_dct_adj_etb");
			var c = sheetObj.CellValue(i,prefix+"is_dct_adj_etd");
			var d = sheetObj.CellValue(i,prefix+"is_cct_adj_dy");
			var e = sheetObj.CellValue(i,prefix+"is_cct_adj_etb");
			var f = sheetObj.CellValue(i,prefix+"is_cct_adj_etd");
			
			if(a==0 && b==0 && c==0){
				allEdit1(sheetObj, i);
			}else if (a == 1) { 
				sheetObj.CellEditable(i,prefix+"is_dct_adj_dy") = true;
				sheetObj.CellEditable(i,prefix+"dct_adj_dy") = true;
				sheetObj.CellEditable(i,prefix+"dct_adj_hrmnt")= true;
			}else if (b == 1) { 
				sheetObj.CellEditable(i,prefix+"is_dct_adj_etb") = true;
				sheetObj.CellEditable(i,prefix+"dct_adj_etb_dys") = true;
				sheetObj.CellEditable(i,prefix+"dct_adj_hrmnt")= true;
			}else if (c == 1) { 
				sheetObj.CellEditable(i,prefix+"is_dct_adj_etd") = true;
				sheetObj.CellEditable(i,prefix+"dct_adj_etd_dys") = true;
				sheetObj.CellEditable(i,prefix+"dct_adj_hrmnt")= true;
			}
			
			if(d==0 && e==0 && f==0){
				allEdit2(sheetObj, i);
			}else if (d == 1) {
				sheetObj.CellEditable(i,prefix+"is_cct_adj_dy") = true;
				sheetObj.CellEditable(i,prefix+"cct_adj_dy") = true;
				sheetObj.CellEditable(i,prefix+"cct_adj_hrmnt")= true;
			}else if (e == 1) { 
				sheetObj.CellEditable(i,prefix+"is_cct_adj_etb") = true;
				sheetObj.CellEditable(i,prefix+"cct_adj_etb_dys") = true;
				sheetObj.CellEditable(i,prefix+"cct_adj_hrmnt")= true;
			}else if (f == 1) {
				sheetObj.CellEditable(i,prefix+"is_cct_adj_etd") = true;
				sheetObj.CellEditable(i,prefix+"cct_adj_etd_dys") = true;
				sheetObj.CellEditable(i,prefix+"cct_adj_hrmnt")= true;
			}
		}
    }
    */
    
    function chkOnSearchEnd(sheetObj,i){
			var a = sheetObj.CellValue(i,prefix+"is_dct_adj_dy");
			var b = sheetObj.CellValue(i,prefix+"is_dct_adj_etb");
			var c = sheetObj.CellValue(i,prefix+"is_dct_adj_etd");
			var d = sheetObj.CellValue(i,prefix+"is_cct_adj_dy");
			var e = sheetObj.CellValue(i,prefix+"is_cct_adj_etb");
			var f = sheetObj.CellValue(i,prefix+"is_cct_adj_etd");
			
			if(a==0 && b==0 && c==0){
				allEdit1(sheetObj, i);
			}else if (a == 1) { 
				sheetObj.CellEditable(i,prefix+"is_dct_adj_dy") = true;
				sheetObj.CellEditable(i,prefix+"dct_adj_dy") = true;
				sheetObj.CellEditable(i,prefix+"dct_adj_hrmnt")= true;
			}else if (b == 1) { 
				sheetObj.CellEditable(i,prefix+"is_dct_adj_etb") = true;
				sheetObj.CellEditable(i,prefix+"dct_adj_etb_dys") = true;
				sheetObj.CellEditable(i,prefix+"dct_adj_hrmnt")= true;
			}else if (c == 1) { 
				sheetObj.CellEditable(i,prefix+"is_dct_adj_etd") = true;
				sheetObj.CellEditable(i,prefix+"dct_adj_etd_dys") = true;
				sheetObj.CellEditable(i,prefix+"dct_adj_hrmnt")= true;
			}
			 
			if(d==0 && e==0 && f==0){
				allEdit2(sheetObj, i);
			}else if (d == 1) {
				sheetObj.CellEditable(i,prefix+"is_cct_adj_dy") = true;
				sheetObj.CellEditable(i,prefix+"cct_adj_dy") = true;
				sheetObj.CellEditable(i,prefix+"cct_adj_hrmnt")= true;
			}else if (e == 1) { 
				sheetObj.CellEditable(i,prefix+"is_cct_adj_etb") = true;
				sheetObj.CellEditable(i,prefix+"cct_adj_etb_dys") = true;
				sheetObj.CellEditable(i,prefix+"cct_adj_hrmnt")= true;
			}else if (f == 1) {
				sheetObj.CellEditable(i,prefix+"is_cct_adj_etd") = true;
				sheetObj.CellEditable(i,prefix+"cct_adj_etd_dys") = true;
				sheetObj.CellEditable(i,prefix+"cct_adj_hrmnt")= true;
			}
    }
    
    function allEdit1(sheetObj, i){
		sheetObj.CellEditable(i,prefix+"is_dct_adj_dy") = true;
		sheetObj.CellEditable(i,prefix+"is_dct_adj_etb") = true;
		sheetObj.CellEditable(i,prefix+"is_dct_adj_etd") = true;
    }
    
    function allEdit2(sheetObj, i){
		sheetObj.CellEditable(i,prefix+"is_cct_adj_dy") = true;
		sheetObj.CellEditable(i,prefix+"is_cct_adj_etb") = true;
		sheetObj.CellEditable(i,prefix+"is_cct_adj_etd") = true;
    }
    
      /**
      * 셀의 값이 바뀌었을 때 발생하는 Event
      * @param sheetObj
      * @param row
      * @param col
      * @return
      */
      function sheet2_OnChange(sheetObj, row, col) {
			
    	//chkOnSearchEnd(sheetObj,row);
     	var rows = sheetObj.Rows;
     	
     	switch (sheetObj.ColSaveName(col)) {
     	 //1 
     	 
     	 	case prefix+"is_dct_adj_dy" :
     	 		if(row > 0){
     				if(sheetObj.cellvalue(row,prefix+"is_dct_adj_dy") == 1) {	//check
     					sheetObj.CellValue2(row,prefix+"is_dct_adj_etb") = 0;
     					sheetObj.CellValue2(row,prefix+"is_dct_adj_etd") = 0;
     					
       					sheetObj.CellEditable(row,prefix+"is_dct_adj_etb") = false;
       					sheetObj.CellEditable(row,prefix+"is_dct_adj_etd") = false;
               			  
       					sheetObj.CellEditable(row,prefix+"dct_adj_dy") = true;
       					sheetObj.CellEditable(row,prefix+"dct_adj_hrmnt")= true;
       					
       					sheetObj.CellEditable(row,prefix+"dct_adj_etb_dys") = false;
       					sheetObj.CellEditable(row,prefix+"dct_adj_etd_dys") = false;
       					
       					sheetObj.CellValue2(row,prefix+"dct_adj_etb_dys") = "";
       					sheetObj.CellValue2(row,prefix+"dct_adj_etd_dys") = "";
       					
       					sheetObj.CellValue2(row,prefix+"dct_adj_tp_nm") = "DAY";
     					return;
     				}
     				if(sheetObj.cellvalue(row,prefix+"is_dct_adj_dy") == 0) {	//uncheck
     					sheetObj.CellValue2(row,prefix+"is_dct_adj_etb") = 0;
     					sheetObj.CellValue2(row,prefix+"is_dct_adj_etd") = 0;
         					
       					sheetObj.CellEditable(row,prefix+"is_dct_adj_etb") = true;
       					sheetObj.CellEditable(row,prefix+"is_dct_adj_etd") = true;
       					
       					sheetObj.CellEditable(row,prefix+"dct_adj_dy") = false;
       					sheetObj.CellEditable(row,prefix+"dct_adj_hrmnt")= false;
   
       					sheetObj.CellValue2(row,prefix+"dct_adj_dy") = "";
       					sheetObj.CellValue2(row,prefix+"dct_adj_hrmnt")= "";
       					sheetObj.CellValue2(row,prefix+"dct_adj_etb_dys") = "";
       					sheetObj.CellValue2(row,prefix+"dct_adj_etd_dys") = "";
       					
       					sheetObj.CellValue2(row,prefix+"dct_adj_tp_nm") = "";
       					
     					return;
     				}
     	 		}
     	 	break;
     	 		
     	 	case prefix+"is_dct_adj_etb" :
     	 		if(row > 0){
     				if(sheetObj.cellvalue(row,prefix+"is_dct_adj_etb") == 1) {	//check
     					sheetObj.CellValue2(row,prefix+"is_dct_adj_dy") = 0;
     					sheetObj.CellValue2(row,prefix+"is_dct_adj_etd") = 0;
         					
       					sheetObj.CellEditable(row,prefix+"is_dct_adj_dy") = false;
       					sheetObj.CellEditable(row,prefix+"is_dct_adj_etd") = false;
               			  
       					sheetObj.CellEditable(row,prefix+"dct_adj_etb_dys") = true;
       					sheetObj.CellEditable(row,prefix+"dct_adj_hrmnt")= true;
       					
       					sheetObj.CellEditable(row,prefix+"dct_adj_dy") = false;
       					sheetObj.CellEditable(row,prefix+"dct_adj_etd_dys") = false;
       					
       					sheetObj.CellValue2(row,prefix+"dct_adj_dy") = "";
       					sheetObj.CellValue2(row,prefix+"dct_adj_etd_dys") = "";
       					
       					sheetObj.CellValue2(row,prefix+"dct_adj_tp_nm") = "ETB";
     					return;
     				}
     				if(sheetObj.cellvalue(row,prefix+"is_dct_adj_etb") == 0) {	//uncheck
     					sheetObj.CellValue2(row,prefix+"is_dct_adj_dy") = 0;
     					sheetObj.CellValue2(row,prefix+"is_dct_adj_etd") = 0;
     					
       					sheetObj.CellEditable(row,prefix+"is_dct_adj_dy") = true;
       					sheetObj.CellEditable(row,prefix+"is_dct_adj_etd") = true;
       					
       					sheetObj.CellEditable(row,prefix+"dct_adj_etb_dys") = false;
       					sheetObj.CellEditable(row,prefix+"dct_adj_hrmnt")= false;
   
       					sheetObj.CellValue2(row,prefix+"dct_adj_dy") = "";
       					sheetObj.CellValue2(row,prefix+"dct_adj_hrmnt")= "";
       					sheetObj.CellValue2(row,prefix+"dct_adj_etb_dys") = "";
       					sheetObj.CellValue2(row,prefix+"dct_adj_etd_dys") = "";
       					
       					sheetObj.CellValue2(row,prefix+"dct_adj_tp_nm") = "";
     					return;
     				}
     	 		}
     	 	break;
     	 	
     	 	case prefix+"is_dct_adj_etd" :
     	 		if(row > 0){
     				if(sheetObj.cellvalue(row,prefix+"is_dct_adj_etd") == 1) {	//check
     					sheetObj.CellValue2(row,prefix+"is_dct_adj_dy") = 0;
     					sheetObj.CellValue2(row,prefix+"is_dct_adj_etb") = 0;
     					
       					sheetObj.CellEditable(row,prefix+"is_dct_adj_dy") = false;
       					sheetObj.CellEditable(row,prefix+"is_dct_adj_etb") = false;
               			  
       					sheetObj.CellEditable(row,prefix+"dct_adj_etd_dys") = true;
       					sheetObj.CellEditable(row,prefix+"dct_adj_hrmnt")= true;
       					
       					sheetObj.CellEditable(row,prefix+"dct_adj_dy") = false;
       					sheetObj.CellEditable(row,prefix+"dct_adj_etb_dys") = false;
       					
       					sheetObj.CellValue2(row,prefix+"dct_adj_dy") = "";
       					sheetObj.CellValue2(row,prefix+"dct_adj_etb_dys") = "";
       					
       					sheetObj.CellValue2(row,prefix+"dct_adj_tp_nm") = "ETD";
     					return;
     				}
     				if(sheetObj.cellvalue(row,prefix+"is_dct_adj_etd") == 0) {	//uncheck
     					sheetObj.CellValue2(row,prefix+"is_dct_adj_dy") = 0;
     					sheetObj.CellValue2(row,prefix+"is_dct_adj_etb") = 0;
     					
       					sheetObj.CellEditable(row,prefix+"is_dct_adj_dy") = true;
       					sheetObj.CellEditable(row,prefix+"is_dct_adj_etb") = true;
       					
       					sheetObj.CellEditable(row,prefix+"dct_adj_etd_dys") = false;
       					sheetObj.CellEditable(row,prefix+"dct_adj_hrmnt")= false;
   
       					sheetObj.CellValue2(row,prefix+"dct_adj_dy") = "";
       					sheetObj.CellValue2(row,prefix+"dct_adj_hrmnt")= "";
       					sheetObj.CellValue2(row,prefix+"dct_adj_etb_dys") = "";
       					sheetObj.CellValue2(row,prefix+"dct_adj_etd_dys") = "";
       					
       					sheetObj.CellValue2(row,prefix+"dct_adj_tp_nm") = "";
     					return;
     				}
     	 		}
     	 	break;
     	 	
     	 	//2 
     	 	case prefix+"is_cct_adj_dy" :
     	 		if(row > 0){
     				if(sheetObj.cellvalue(row,prefix+"is_cct_adj_dy") == 1) {	//check
     					sheetObj.CellValue2(row,prefix+"is_cct_adj_etb") = 0;
     					sheetObj.CellValue2(row,prefix+"is_cct_adj_etd") = 0;
     					
       					sheetObj.CellEditable(row,prefix+"is_cct_adj_etb") = false;
       					sheetObj.CellEditable(row,prefix+"is_cct_adj_etd") = false;
               			  
       					sheetObj.CellEditable(row,prefix+"cct_adj_dy") = true;
       					sheetObj.CellEditable(row,prefix+"cct_adj_hrmnt")= true;
       					
       					sheetObj.CellEditable(row,prefix+"cct_adj_etb_dys") = false;
       					sheetObj.CellEditable(row,prefix+"cct_adj_etd_dys") = false;
       					
       					sheetObj.CellValue2(row,prefix+"cct_adj_etb_dys") = "";
       					sheetObj.CellValue2(row,prefix+"cct_adj_etd_dys") = "";
       					
       					sheetObj.CellValue2(row,prefix+"cct_adj_tp_nm") = "DAY";
     					return;
     				}
     				if(sheetObj.cellvalue(row,prefix+"is_cct_adj_dy") == 0) {	//uncheck
     					sheetObj.CellValue2(row,prefix+"is_cct_adj_etb") = 0;
     					sheetObj.CellValue2(row,prefix+"is_cct_adj_etd") = 0;
     					
       					sheetObj.CellEditable(row,prefix+"is_cct_adj_etb") = true;
       					sheetObj.CellEditable(row,prefix+"is_cct_adj_etd") = true;
       					
       					sheetObj.CellEditable(row,prefix+"cct_adj_dy") = false;
       					sheetObj.CellEditable(row,prefix+"cct_adj_hrmnt")= false;
   
       					sheetObj.CellValue2(row,prefix+"cct_adj_dy") = "";
       					sheetObj.CellValue2(row,prefix+"cct_adj_hrmnt")= "";
       					sheetObj.CellValue2(row,prefix+"cct_adj_etb_dys") = ""; 
       					sheetObj.CellValue2(row,prefix+"cct_adj_etd_dys") = "";
       					
       					sheetObj.CellValue2(row,prefix+"cct_adj_tp_nm") = "";
     					return;
     				}
     	 		}
     	 	break;
     	 		
     	 	case prefix+"is_cct_adj_etb" :
     	 		if(row > 0){
     				if(sheetObj.cellvalue(row,prefix+"is_cct_adj_etb") == 1) {	//check
     					sheetObj.CellValue2(row,prefix+"is_cct_adj_dy") = 0;
     					sheetObj.CellValue2(row,prefix+"is_cct_adj_etd") = 0;
     					
       					sheetObj.CellEditable(row,prefix+"is_cct_adj_dy") = false;
       					sheetObj.CellEditable(row,prefix+"is_cct_adj_etd") = false;
               			  
       					sheetObj.CellEditable(row,prefix+"cct_adj_etb_dys") = true;
       					sheetObj.CellEditable(row,prefix+"cct_adj_hrmnt")= true;
       					
       					sheetObj.CellEditable(row,prefix+"cct_adj_dy") = false;
       					sheetObj.CellEditable(row,prefix+"cct_adj_etd_dys") = false;
       					
       					sheetObj.CellValue2(row,prefix+"cct_adj_dy") = "";
       					sheetObj.CellValue2(row,prefix+"cct_adj_etd_dys") = "";
       					
       					sheetObj.CellValue2(row,prefix+"cct_adj_tp_nm") = "ETB";
     					return;
     				}
     				if(sheetObj.cellvalue(row,prefix+"is_cct_adj_etb") == 0) {	//uncheck
     					sheetObj.CellValue2(row,prefix+"is_cct_adj_dy") = 0;
     					sheetObj.CellValue2(row,prefix+"is_cct_adj_etd") = 0;
     					
       					sheetObj.CellEditable(row,prefix+"is_cct_adj_dy") = true;
       					sheetObj.CellEditable(row,prefix+"is_cct_adj_etd") = true;
       					
       					sheetObj.CellEditable(row,prefix+"cct_adj_etb_dys") = false;
       					sheetObj.CellEditable(row,prefix+"cct_adj_hrmnt")= false;
   
       					sheetObj.CellValue2(row,prefix+"cct_adj_dy") = "";
       					sheetObj.CellValue2(row,prefix+"cct_adj_hrmnt")= "";
       					sheetObj.CellValue2(row,prefix+"cct_adj_etb_dys") = "";
       					sheetObj.CellValue2(row,prefix+"cct_adj_etd_dys") = "";
       					
       					sheetObj.CellValue2(row,prefix+"cct_adj_tp_nm") = "";
     					return;
     				}
     	 		}
     	 	break;
     	 	
     	 	case prefix+"is_cct_adj_etd" :
     	 		if(row > 0){
     				if(sheetObj.cellvalue(row,prefix+"is_cct_adj_etd") == 1) {	//check
     					sheetObj.CellValue2(row,prefix+"is_cct_adj_dy") = 0;
     					sheetObj.CellValue2(row,prefix+"is_cct_adj_etb") = 0;
     					
       					sheetObj.CellEditable(row,prefix+"is_cct_adj_dy") = false;
       					sheetObj.CellEditable(row,prefix+"is_cct_adj_etb") = false;
               			  
       					sheetObj.CellEditable(row,prefix+"cct_adj_etd_dys") = true;
       					sheetObj.CellEditable(row,prefix+"cct_adj_hrmnt")= true;
       					
       					sheetObj.CellEditable(row,prefix+"cct_adj_dy") = false;
       					sheetObj.CellEditable(row,prefix+"cct_adj_etb_dys") = false;
       					
       					sheetObj.CellValue2(row,prefix+"cct_adj_dy") = "";
       					sheetObj.CellValue2(row,prefix+"cct_adj_etb_dys") = "";
       					
       					sheetObj.CellValue2(row,prefix+"cct_adj_tp_nm") = "ETD";
     					return;
     				}
     				if(sheetObj.cellvalue(row,prefix+"is_cct_adj_etd") == 0) {	//uncheck
     					sheetObj.CellValue2(row,prefix+"is_cct_adj_dy") = 0;
     					sheetObj.CellValue2(row,prefix+"is_cct_adj_etb") = 0;
     					
       					sheetObj.CellEditable(row,prefix+"is_cct_adj_dy") = true;
       					sheetObj.CellEditable(row,prefix+"is_cct_adj_etb") = true;
   
       					sheetObj.CellEditable(row,prefix+"cct_adj_etd_dys") = false;
       					sheetObj.CellEditable(row,prefix+"cct_adj_hrmnt")= false;
       					
       					sheetObj.CellValue2(row,prefix+"cct_adj_dy") = "";
       					sheetObj.CellValue2(row,prefix+"cct_adj_hrmnt")= "";
       					sheetObj.CellValue2(row,prefix+"cct_adj_etb_dys") = "";
       					sheetObj.CellValue2(row,prefix+"cct_adj_etd_dys") = "";
       					
       					sheetObj.CellValue2(row,prefix+"cct_adj_tp_nm") = "";
     					return;
     				}
     	 		}
     	 	break;
     	 }
     }
      
  	function getPartnerName(){
	    form.f_cmd.value = SEARCH01;
	    var formObj = document.form;
		
	    var sXml = sheetObjects[0].GetSearchXml("ESD_SCE_0122GS.do" , SceFrmQryString(form));
	    //텍스트 가져오기[partnerName]
	    var partnerName = ComGetEtcData(sXml,"partnerName");
	    var custTrdPrnrId = ComGetEtcData(sXml,"custTrdPrnrId") == "" ? "" : ComGetEtcData(sXml,"custTrdPrnrId");
	    formObj.partnerName.value  = partnerName;
	    
	}
  	
  	function resetCnt(inx){
  		var formObj = document.form;
  		if(inx == 1){
  			if(formObj.pol_cnt.value == "" ){
  				//formObj.pol_cnt_nm.value = "";
  				formObj.pol_cnt.value = "";
  			}
  		}else{
  			if(formObj.pod_cnt.value == ""){
  				//formObj.pod_conti_nm.value = "";
  				formObj.pod_cnt.value = "";
  			}
  		}
  	}
  	
    
  	
     
     /**
      * sheet1에서 이미지버튼을 클릭한 경우 를 처리한다.
      * gubun B인경우 C1T0W 인 경우
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
      function sheet2_OnPopupClick(sheetObj, Row, Col){
  		var sUrl = "/hanjin/ESD_SCE_0127.do";
  		var cust_trd_prnr_id = comboObjects[0].Text;
  		var adj_rgst_dt = sheetObj.CellValue(Row,  sheetObj.SaveNameCol(prefix+"adj_rgst_dt"));
  		var adj_seq = sheetObj.CellValue(Row,  sheetObj.SaveNameCol(prefix+"adj_seq"));
  		var slan_cds = sheetObj.CellValue(Row,  sheetObj.SaveNameCol(prefix+"slan_cds"));

  		var param = "?gubun=B&adj_rgst_dt="+adj_rgst_dt+"&adj_seq="+adj_seq +"&slan_cds="+slan_cds +"&f_cmd=101";
  		ComOpenPopup(sUrl + param, 428, 430, "", "none",true);
  		
      }
      
      function popOk(gubun, blockSel){
    	  var sheetObj = "";
    	  if(gubun == "is_dct_adj_dy"){
	    	  
    	  }else{	//B
	    	  var i = sheetObjects[0].selectRow;
    	  	  sheetObjects[0].CellValue2(i, sheetObjects[0].SaveNameCol(prefix+"block_lane"))  = blockSel;
    	  }
      }
      
      /**
      * VoList를 array[array[name]]형태로 변환 
      * @param {xml} xmlStr 조회 결과 setRsVoList , setRsVo 
      */
      function ComXml2ListMap(xmlStr) {
      	
      	var rtnArr = new Array();

      	if (xmlStr == null || xmlStr == "") {
      		return rtnArr;
      	}

      	try {
      		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
      		xmlDoc.loadXML(xmlStr);

      		var xmlRoot = xmlDoc.documentElement;
      		if (xmlRoot == null) {
      			return rtnArr;
      		}

      		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
      		if (dataNode == null || dataNode.attributes.length < 3) {
      			return rtnArr;
      		}

      		var col = dataNode.getAttribute("COLORDER");
      		var colArr = col.split("|");
      		var sep = dataNode.getAttribute("COLSEPARATOR");
      		var total = dataNode.getAttribute("TOTAL");

      		if (total == 0) {
      			return rtnArr;
      		}
      		
      		var dataChileNodes = dataNode.childNodes;
      		if (dataChileNodes == null) {
      			return rtnArr;
      		}

      		for ( var i = 0; i < dataChileNodes.length; i++) {
      			if (dataChileNodes[i].nodeType != 1) {
      				continue;
      			}
      			
      			var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);

      			var subDataArr = new Array();
      			
      			for ( var j = 0; j < arrData.length; j++) {
      				subDataArr[colArr[j]] = arrData[j];
      			}
      			
      			rtnArr[i] = (subDataArr);
      		}

      	} catch (err) {
      		ComFuncErrMsg(err.message);
      	}

      	return rtnArr;
      }

      
	/* 개발자 작업  끝 */