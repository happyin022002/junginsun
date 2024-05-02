/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0020.js
*@FileTitle : (Spain)Local Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.25 한동훈
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
     * @class fns_inv_0020 : fns_inv_0020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0020() {
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
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");


           switch(srcName) {

                case "btn_add":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);			
                    break;

                case "btn_copy":
					var index = sheetObjects[0].DataCopy();	
					rowCopy(index, true);					
                    break;

                case "btn_del":
                	if(!validateForm(sheetObjects[0],formObject,IBDELETE)) {
        				return false;
        			}
					var delNum = ComRowHideDelete(sheetObjects[0], "DelChk");
					getCountFormat(sheetObjects[0], formObject, "delete", delNum)
                    break;

                case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                    break;
                    
                case "btn_new":
                	ComResetAll();
                	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
             		ComSetFocus(document.form.office2);
                    break;
                    
                case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                    break;
                    
                case "btn_downexcel":
                	sheetObjects[0].SpeedDown2Excel(0, false, false, "", "", false, false, "", false, "|ibflag|DelChk|cust_cnt_cd|CustCode2|cust_seq|upd_usr_id|upd_dt");
                	//sheetObjects[0].Down2Excel(0, false, false, true, "", "", false, false, "", false, "|ibflag|DelChk|cust_cnt_cd|CustCode2|cust_seq|upd_usr_id|upd_dt");
                    break;

                case "btn_close":
					self.close();
                    break;

				case "btns_SCP": //SCP 조회버튼
					var v_svc_scp_cd = "";
					var classId = "COM_ENS_0L1";
					var param = '?svc_scp_cd='+v_svc_scp_cd+'&classId='+classId;
			
					//ComOpenPopup('/hanjin/COM_ENS_0L1.do' + param, 420, 450, 'getCOM_ENS_0L1_1', '1,0,1,1,1', true);
					ComOpenPopup("ESM_FMS_0083.do", 500, 350, "setOwnerName", "1,0,1,1,1,1", false, false, Row, Col, 0);
				break;
				case "btns_port": //port 조회버튼
					var loc_cd_val = formObject.loc_cd.value;
					var loc_cd_val = "";
					var sys_code = "ENIS";
	            
					var loc_port_ind_val = "1";
	            
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";
					var classId = "COM_ENS_051";
					var param = '?loc_cd='+loc_cd_val+'&sysCode='+sys_code+'&classId='+classId;
	 			  
					//ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 900, 450, 'getCOM_ENS_051_1', dispaly);
					ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 900, 450, 'getCOM_ENS_051_1', dispaly);
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
    }
    
    /** 
 	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object        
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */  	
 	function sheet1_OnLoadFinish(sheetObj){
 		sheetObjects[0].WaitImageVisible = false; 
 		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
 		ComSetFocus(document.form.office2);
 		sheetObjects[0].WaitImageVisible = true; 
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
  			case "loc_cd":
  				with (comboObj) {
  					ValidChar(2,1);
  					MaxLength = 5;
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

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    //style.height = 240;
                	style.height = 440;
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

					//var HeadTitle = "|Sel|Scope|Charge|BND|Cust. Code|Cust. Code|Cust. Code|Cur.|Rate|Per|A/M|Description";
					var HeadTitle = "|Sel|Office|RHQ|Location|Scope|Charge|BND|Cust. Code|Cust. Code|Cust. Code|Cust Code|CURR|PER|Account|A/M|RATE|Description|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    var prefix="sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  "ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck, 	40,		daCenter, 	false,	"DelChk");
					InitDataProperty(0, cnt++ , dtData,    	70,    	daCenter,  	false,	"ar_ofc_cd",   			false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    	70,    	daCenter,  	false,	"ar_hd_qtr_ofc_cd",   			false,    "",    dfNone, 		0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    	70,    	daCenter,  	false,	"loc_cd",   			false,    "",    dfNone, 		0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,  		70,    	daCenter,  	false,	"svc_scp_cd",   		true,    "",    dfNone,			0,     true,       true,	3);
                    InitDataProperty(0, cnt++ , dtCombo,    	70,    	daCenter,  	false,	"chg_cd",   			true,    "",    dfNone,			0,     true,       true,	3);
                    InitDataProperty(0, cnt++ , dtCombo,    	60,    	daCenter,  	false,	"io_bnd_cd",   			true,    "",    dfNone, 		0,     true,       true,	3);
                    InitDataProperty(0, cnt++ , dtData,    		30,    	daCenter,  	false,	"cust_cnt_cd",   		true,    "",    dfEngKey, 		0,     true,       true,	2);
                    InitDataProperty(0, cnt++ , dtData,    		15,    	daCenter,  	false,	"CustCode2",   			true,    "",    dfNone, 		0,     false,      false,	1);
                    InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,	"cust_seq",   			true,    "",    dfNone, 		0,     true,       true,	6);
                    InitDataProperty(0, cnt++ , dtHidden,    	100,    daCenter,  	false,	"cust_cnt_cd2",   		true,    "",    dfEngKey, 		0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,    	60,    	daCenter,  	false,	"curr_cd",   			true,    "",    dfNone, 		0,     true,       true,	3);                    
                    InitDataProperty(0, cnt++ , dtCombo,    	60,    	daCenter,  	false,	"inv_chg_ut_div_cd", 	true,    "",    dfNone, 		0,     true,       true,	4);
                    InitDataProperty(0, cnt++ , dtData,    		70,    	daCenter,  	false,	"acct_cd",		   		false,   "",    dfNone, 		0,     true,       true,	6);
                    InitDataProperty(0, cnt++ , dtCombo,    	50,    	daCenter,  	false,	"locl_chg_if_auto_cd",  false,   "",    dfNone, 		0,     true,       true,	1);
                    InitDataProperty(0, cnt++ , dtData,    		70,    	daRight,  	false,	"trf_rt_amt",   		true,    "",    dfNullFloat, 	2,     true,       true,	22);
                    InitDataProperty(0, cnt++ , dtData,    		140,   	daLeft,  	false,	"chg_rmk",   			false,    "",    dfNone, 		0,     true,       true,	100);                                        
                    InitDataProperty(0, cnt++ , dtHidden,    	70,    	daCenter,  	false,	"cre_usr_id",   		false,    "",    dfNone, 		0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    	70,    	daCenter,  	false,	"cre_dt",   			false,    "",    dfNone, 		0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    	70,    	daCenter,  	false,	"upd_usr_id",   		false,    "",    dfNone, 		0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    	70,    	daCenter,  	false,	"upd_dt",   			false,    "",    dfNone, 		0,     true,       true);
                    
										InitDataCombo(0,'io_bnd_cd',"|ALL|I/B|O/B","|A|I|O");
										//InitDataCombo(0,  "curr_cd",  "CHF|GBP|NOK|USD",  "1|2|3|4",  "CHF",  "1");  
										InitDataCombo(0,'inv_chg_ut_div_cd',"B/L|CNTR|DAY|TON","BL|CNTR|DAY|TON");
										InitDataCombo(0,'locl_chg_if_auto_cd',"A|M","A|M");
										//InitDataValid(0,    "svc_scp_cd",   vtEngUpOnly);
										//InitDataValid(0,    "chg_cd",   	vtEngUpOnly);
										InitDataValid(0,    "cust_cnt_cd",  vtEngUpOnly);
										InitDataValid(0,    "cust_seq",   	vtNumericOnly);
										InitDataValid(0,    "acct_cd",   	vtNumericOnly);
										
										PopupImage  =  "img/btns_search.gif"; 
										ShowButtonImage = 2;

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
     * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
     * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
     * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
    function doActionIBSheet(sheetObj,formObj,sAction, Row, Col, Val) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBCLEAR:
        		formObj.f_cmd.value = SEARCH03;
        		var sXml = sheetObj.GetSearchXml("FNS_INV_0020GS.do", FormQueryString(formObj));
    			//====== combo list ====================//
        		var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
        		var arrStr = sStr.split("|");
        		MakeComboObject_OfcCd_2(formObj.office2, arrStr, "Y"); // 2016.07 Office code에 ALL 추가 CSR: Y로 변경
        		var arrStr2 = arrStr[1].split("^");
        		var ar_ofc_cd = arrStr2[3];
        		formObj.office2.text = ar_ofc_cd;        			
        		formObj.office2.DropHeight = 190;
                
        		var svc_scp_cd = ComGetEtcData(sXml, "svc_scp_cd");	
    			addCellComboItem(sheetObj,svc_scp_cd,"svc_scp_cd",false);
    			
    			var chg_cd = ComGetEtcData(sXml, "chg_cd");	
    			addCellComboItem(sheetObj,chg_cd,"chg_cd",false);
    			
    			var comboValues = ComGetEtcData(sXml, "currInfo");
    			addCellComboItem(sheetObj,comboValues,"curr_cd",false);
        		break;
        	case IBSEARCH_ASYNC10: //Location 조회
        		formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0020GS.do", FormQueryString(formObj));
				var sStrLoc = ComGetEtcData(sXml,"loc_cd");
				var arrStrLoc = sStrLoc.split("|");	
				MakeComboObject3(formObj.loc_cd, arrStrLoc);
				formObj.loc_cd.DropHeight = 200;
			    break;
        	case IBSEARCH_ASYNC20: //acct_cd 조회
        		formObj.f_cmd.value = SEARCH02;
        		formObj.acct_cd.value = Val;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0020GS.do", FormQueryString(formObj));
				var sStrAcct = ComGetEtcData(sXml,"acct_cd");
				if(sStrAcct == ""){
					ComShowCodeMessage("INV00130");
					sheetObj.SelectCell(Row, Col);
					sheetObj.CellText(Row,Col) = "";
				}
			    break;        	
        	case IBSEARCH_ASYNC11: // customer name 조회	

				formObj.f_cmd.value = SEARCH03;				
				var actCustCntCd = formObj.act_cust_cnt_cd.value;
				var actCustSeq = formObj.act_cust_seq.value;				
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);	
	
				if(CoInvShowXmlMessage(sXml) != "") {
					//sheetObj.CellValue(Row,Col)= "";
					ComShowCodeMessage("INV00008");						
					sheetObj.SelectCell(Row, Col);					
				}
				break;
        	case IBSEARCH_ASYNC12: //loc_cd 체크
        		formObj.f_cmd.value = SEARCH04;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0020GS.do", FormQueryString(formObj));
				var sStrLocCd = ComGetEtcData(sXml,"loc_cd");
				if(sStrLocCd == ""){
					ComShowCodeMessage("INV00041","["+formObj.loc_cd.Text+"]");
					ComSetFocus(formObj.loc_cd);
					document.form.loc_cd.Text = "";
					return false;
				}
			    break;			
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction) == false) return false; 
				if (sheetObj.id == "sheet1") {				
					sheetObjects[0].RemoveAll();
					sheetObjects[0].RemoveEtcData();
					formObj.f_cmd.value = SEARCH;
					formObj.loc_cd.Code = formObj.loc_cd.Text;
					sheetObj.DoSearch("FNS_INV_0020GS.do", FormQueryString(formObj));
					getCountFormat(sheetObj, formObj, "search"); //조회 후 카운트
				}
				for (var i=1; i<=sheetObj.RowCount; i++) {
					sheetObj.CellText(i,"CustCode2") = "-";
					rowCopy(i, false);
				}	
                break;
                			
			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) return;
				if(sheetObj.RowCount == 0) return;			
				
				//loc_cd 체크
				formObj.loc_cd2.value = formObj.loc_cd.Text;
				if(formObj.loc_cd.Text != "ALL"){
					formObj.f_cmd.value = SEARCH04;
					var sXml = sheetObj.GetSearchXml("FNS_INV_0020GS.do", FormQueryString(formObj));
					var sStrLocCd = ComGetEtcData(sXml,"loc_cd");
					if(sStrLocCd == ""){
						//ComShowCodeMessage("INV00041","["+formObj.loc_cd.Text+"]");
						ComShowCodeMessage('INV00133');
						document.form.loc_cd.DeleteItem(formObj.loc_cd.Text);
						document.form.loc_cd.Text = "";
						ComSetFocus(formObj.loc_cd);					
						return false;
					}
					for (var i=1; i<=sheetObjects[0].RowCount; i++) {
						  sheetObjects[0].CellText(i,"loc_cd") = document.form.loc_cd.Text;
					  } 
				}
				
				formObj.f_cmd.value = MULTI;
				//var result = sheetObj.DoSave("FNS_INV_0020GS.do", FormQueryString(formObj));
				//return;
				var sParam = ComGetSaveString(sheetObjects);
				if (sheetObj.IsDataModified && sParam == "") return; 

                sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var SaveXml = sheetObj.GetSaveXml("FNS_INV_0020GS.do", sParam );
				sheetObj.LoadSaveXml(SaveXml);

				if (SaveXml.indexOf(">OK<") > -1){
					for (var i=1; i<=sheetObj.RowCount; i++) {
						rowCopy(i, false);
					}
				}	
				getCountFormat(sheetObj, formObj, "search");	//저장 후  카운트
				
                break;

			case IBINSERT:      // 입력
				if(!validateForm(sheetObj,formObj,sAction)) return;
				var sheetIdx = sheetObj.DataInsert(-1);
				sheetObj.CellText(sheetIdx,"loc_cd") = formObj.loc_cd.text;
				sheetObj.CellText(sheetIdx,"ar_ofc_cd") = formObj.office2.text;
				sheetObj.CellText(sheetIdx,"CustCode2") = "-";
				sheetObj.CellText(sheetIdx,"io_bnd_cd") = "O/B";
				var arrStr2 = formObj.office2.Code.split("^");
	   			var curr_cd = arrStr2[4];
				sheetObj.CellText(sheetIdx,"curr_cd") = curr_cd;
				sheetObj.CellText(sheetIdx,"inv_chg_ut_div_cd") = "B/L";
				sheetObj.CellText(sheetIdx,"locl_chg_if_auto_cd") = "M";
				sheetObj.CellText(sheetIdx,"svc_scp_cd") = "ALL";
				//sheetObj.InitCellProperty(sheetIdx,"svc_scp_cd",dtPopupEdit);
				sheetObj.InitCellProperty(sheetIdx,"cust_seq",dtPopupEdit);
                break;  
                			
        }
    }
    
    /** 
     * Sheet Cell의 editable에 대한 속성을 세팅함. <br>
     * state : true(활성화), false(비활성화)
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {int} sheetIdx : 선택한 sheet의 cell에 대한 row값  
     * @param  {boolean} state : true(활성화), false(비활성화)
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
    function rowCopy(sheetIdx, state){
    	sheetObjects[0].CellEditable(sheetIdx,'svc_scp_cd') = state;
		sheetObjects[0].CellEditable(sheetIdx,'chg_cd') = state;
		sheetObjects[0].CellEditable(sheetIdx,'io_bnd_cd') = state;
		sheetObjects[0].CellEditable(sheetIdx,'cust_cnt_cd') = state;
		sheetObjects[0].CellEditable(sheetIdx,'cust_seq') = state;
		sheetObjects[0].CellEditable(sheetIdx,'cust_cnt_cd2') = state;
		sheetObjects[0].CellEditable(sheetIdx,'curr_cd') = state;
		sheetObjects[0].CellEditable(sheetIdx,'inv_chg_ut_div_cd') = state;
		//sheetObjects[0].CellEditable(sheetIdx,'locl_chg_if_auto_cd') = state;
		if(state == true){
			//sheetObjects[0].InitCellProperty(sheetIdx,"svc_scp_cd",dtPopupEdit);
			sheetObjects[0].InitCellProperty(sheetIdx,"cust_seq",dtPopupEdit);
		}else{
			//sheetObjects[0].InitCellProperty(sheetIdx,"svc_scp_cd",dtData);
			sheetObjects[0].InitCellProperty(sheetIdx,"cust_seq",dtData);
		}
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
    	switch (sAction) {
    	case IBSEARCH:
    		if(formObj.office2.value == ""){
				ComShowCodeMessage('INV00004');
				ComSetFocus(formObj.office2);
				return false;
			}
			if(formObj.loc_cd.text == ""){
				ComShowCodeMessage('INV00004');
				ComSetFocus(formObj.loc_cd);
				return false;
			}
    		break;
		case IBDELETE:
			if (sheetObj.CheckedRows("DelChk") == 0) {
				ComShowMessage(msgs["INV00025"]);
				return false;
			} else if (sheetObj.CheckedRows("DelChk") > 0) {
				if(!ComShowCodeConfirm("INV00028")) return;
			}
			break;
		case IBSAVE:
			if(formObj.office2.value == ""){
				ComShowCodeMessage('INV00004');
				ComSetFocus(formObj.office2);
				return false;
			}
			if(formObj.loc_cd.text == ""){
				ComShowCodeMessage('INV00004');
				ComSetFocus(formObj.loc_cd);
				return false;
			}
			break;
		case IBINSERT:
			if(formObj.office2.value == ""){
				ComShowCodeMessage('INV00004');
				ComSetFocus(formObj.office2);
				return false;
			}
			if(formObj.loc_cd.text == ""){
				ComShowCodeMessage('INV00004');
				ComSetFocus(formObj.loc_cd);
				return false;
			}
			break;			
    	}
        return true;
    }

	
    /** 
     * sheet상에서 팝업(돋보기) 버튼 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
     * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
 	function sheet1_OnPopupClick(sheetObj, Row,Col)
 		{
 			var formObject = document.form;
 			var param = "";
 			
 			if (sheetObj.ColSaveName(Col) == "svc_scp_cd") {
 				/*
 				var v_svc_scp_cd = "";
				var classId = "COM_ENS_0L1";
				param = '?svc_scp_cd='+v_svc_scp_cd+'&classId='+classId;
		
				ComOpenPopup('/hanjin/COM_ENS_0L1.do' + param, 420, 400, 'getCOM_ENS_0L1_1', '1,0', false, false, Row, Col, 0);
 				 */	 				
 			} else if (sheetObj.ColSaveName(Col) == "cust_seq") {
 				param = '?cust_seq='+sheetObj.CellValue(Row,Col)+'&cust_cnt_cd='+sheetObj.CellValue(Row,Col-2);
 				ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086_1', '1,0', false, false, Row, Col, 0);
 			}
 			
 		}
	
 	/** 
     * 팝업창(COM_ENS_0L1)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
     * @param  {int} row : 부모창의 sheet에서 현재 마우스로 선택되어 있는 Row
     * @param  {int} col : 부모창의 sheet에서 현재 마우스로 선택되어 있는 Col
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function getCOM_ENS_0L1_1(rowArray, row, col) {
		var colArray = rowArray[0];	
		var sheetObject = sheetObjects[0];
        sheetObject.CellValue(row,col)= colArray[3];
		//document.all.svc_scp_cd.value = colArray[3];
		//document.all.svc_scp_nm.value = colArray[4];
	}
	
	/** 
     * 팝업창(FNS_INV_0086)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
     * @param  {int} row : 부모창의 sheet에서 현재 마우스로 선택되어 있는 Row
     * @param  {int} col : 부모창의 sheet에서 현재 마우스로 선택되어 있는 Col
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function getFNS_INV_0086_1(rowArray, row, col) {
		var colArray = rowArray[0];	
		var sheetObject = sheetObjects[0];
		sheetObject.CellValue(row,col-2)= colArray[8];	//cust_cnt_cd
        sheetObject.CellValue(row,col)= lpad(colArray[9], 6, '0');	//cust_seq
        //alert(colArray[10]);	//locl_nm
        	//lpad(colArray[9], 6, '0');        
		//document.all.svc_scp_cd.value = colArray[3];
		//document.all.svc_scp_nm.value = colArray[4];		
	}
	
	/** 
     * 문자열을 받아서 왼쪽에 정해진 char를 길이만큼 채움. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {String} newValue : 문자열  
     * @param  {int} len : 문자열에서 char를 채울 길이
     * @param  {int} ch : 문자열에서 채울 char 문자
     * @return (String) ret : 리턴되는 문자열
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function lpad(newValue, len, ch){
		// 왼쪽에 ch 문자 채우기
		 var strlen = newValue.length;
		 var ret = "";
		 var alen = len - strlen;
		 var astr = ""; 
		 
		 //부족한 숫자만큼  len 크기로 ch 문자로 채우기
		 for (i=0; i<alen; ++i)
		 {
		  astr = astr + ch;
		 }
		 ret = astr + newValue; //앞에서 채우기
		 return ret;
	}

	/** 
     * sheet상에서 데이타를 받아 sheet의 콤보박스에 세팅. <br>
     * curr_cd : currency code 세팅
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {String} comboValues : 세팅할 값
     * @param  {String} colName : sheet에서 세팅할 컬럼
     * @return (boolean) isCellCombo : CellComboItem, InitDataCombo
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */		
	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo) {
		var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
		var ROWMARK = "|";
		var FIELDMARK = "=";

		comboValues = "|"+" "+comboValues;
		if (comboValues != undefined) {
			comboItems = comboValues.split(ROWMARK);
			for (var i = 1 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
				if (comboItem[0] != "") {
					comboTxt += comboItem[0];
					comboVal += comboItem[0];
				}
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}				
			}
		}
		
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName,comboTxt,comboVal);
		}
		else {
			sheetObj.InitDataCombo(0,colName,comboTxt,comboVal);
		}
	}
	
	/** 
     * 업무 자바스크립트 OnChange 이벤트 처리 <br>
     * office 에 따라 Location 조회
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} comboObj : 폼 오브젝트
     * @param  {int} Index_Code : 선택한 항목에 대한 value값
     * @param  {String} Text : 선택한 항목에 대한 text값
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
   function office2_OnChange(comboObj,Index_Code, Text){
	   document.form.office.value = document.form.office2.Text; 
	   sheetObjects[0].RemoveAll();
	   doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
	   
	   if(document.form.office.value == 'ALL'){
		   ComBtnDisable("btn_add");
		   ComBtnDisable("btn_copy");
		   ComBtnDisable("btn_del");
		   ComBtnDisable("btn_save");
	   }else{
		   ComBtnEnable("btn_add");
		   ComBtnEnable("btn_copy");
		   ComBtnEnable("btn_del");
		   ComBtnEnable("btn_save");
	   }
   }
   
   /** 
    * 업무 자바스크립트 OnChange 이벤트 처리 <br>
    * loc_cd 코드를 콤보박스에 넣는다.
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param  {object} comboObj : 폼 오브젝트
    * @param  {int} Index_Code : 선택한 항목에 대한 value값
    * @param  {String} Text : 선택한 항목에 대한 text값
    * @return 없음
    * @see #
    * @author 한동훈
    * @version 2009.10.19
    */ 
  function loc_cd_OnChange(comboObj,Index_Code, Text){	  
	  if(Index_Code == ""){
		  if(Text != "" && Text != "ALL"){
			  if(Text.length != 5){
				  ComShowCodeMessage("INV00041","[not 5 length] Location");
		    	  return false;
			  }
			  if(Text != ""){
				  //sheetObjects[0].RemoveAll();
				  comboObj.InsertItem(0, Text, Text);
			  }			   
			  //doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC12);
		  }
	  }	  
  }
  /** 
   * 업무 자바스크립트 Sheet의 OnSelectCell 이벤트 처리 <br>
   * <br><b>Example :</b>
   * <pre>
   * </pre>
   * @param  {IBSheet} sheetObj : 시트오브젝트  
   * @param  {int} OldRow : 포커스가 이동하기 전에 위치해 있는 sheet의 Row
   * @param  {int} OldCol : 포커스가 이동하기 전에 위치해 있는 sheet의 Col
   * @param  {int} NewRow : 포커스가 이동한 후에 위치해 있는 sheet의 Row
   * @param  {int} NewCol : 포커스가 이동한 후에 위치해 있는 sheet의 Col
   * @return 없음
   * @see #
   * @author 한동훈
   * @version 2009.10.19
   */
/*
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){;
		sheet1_OnChange_event(sheetObj,OldRow,OldCol);
	}
*/	
   /** 
    * 업무 자바스크립트 Sheet의 OnChange 이벤트 처리 <br>
    * 입력된 acct_cd 유효성체크
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param  {IBSheet} sheetObj : 시트오브젝트 
    * @param  {int} Row : 포커스가 위치해 있는 sheet의 Row
    * @param  {int} Col : 포커스가 위치해 있는 sheet의 Col 
    * @return 없음
    * @see #
    * @author 한동훈
    * @version 2009.10.19
    */
 	function sheet1_OnChange(sheetObj, Row, Col){
 		sheet1_OnChange_event(sheetObj, Row, Col); 		
 	}
 	
 	function sheet1_OnChange_event(sheetObj, Row, Col){
 		if (sheetObj.ColSaveName(Col) == "acct_cd") {
 			var Val = sheetObj.CellText(Row,Col);
 			if(Val != ""){
 				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC20, Row, Col, Val);
 			}	
 		}
 		/*
 		if (sheetObj.ColSaveName(Col) == "cust_cnt_cd") {
 			var Val = sheetObj.CellText(Row,Col);
 			var Val2 = sheetObj.CellText(Row,Col+2);
 			if(Val != "" && Val2 != ""){
	 			document.form.act_cust_cnt_cd.value = Val;
	 			document.form.act_cust_seq.value = Val2;
	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11, Row, Col, Val);
 			}	
 		}
 		if (sheetObj.ColSaveName(Col) == "cust_seq") {
 			var Val = sheetObj.CellText(Row,Col);
 			var Val2 = sheetObj.CellText(Row,Col-2);
 			if(Val != "" && Val2 != ""){
	 			document.form.act_cust_cnt_cd.value = Val2;
	 			document.form.act_cust_seq.value = Val;
	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11, Row, Col, Val);
 			}	
 		}
 		*/
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
  			var arrStr2 = arrStr[i].split("|");
  			if(arrStr2 != ""){
  				cmbObj.InsertItem(i-1, arrStr2, arrStr2);
  			}
  			//var ar_ofc_cd = arrStr2[1];
  			//cmbObj.InsertItem(i-1, arrStr[i], arrStr[i]);
  		}
  		cmbObj.text = arrStr[1];
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
	function MakeComboObject3(cmbObj, arrStr) {
  	 	cmbObj.RemoveAll();
  	 	
  		for (var i = 1; i < arrStr.length;i++ ) {
  			var arrStr2 = arrStr[i].split("|");
  			if(arrStr2 != ""){
  				cmbObj.InsertItem(i-1, arrStr2, arrStr2);
  			}  			
  		}
  		cmbObj.DeleteItem("ALL");
  		cmbObj.InsertItem(0, "ALL", "ALL");
  		cmbObj.text = "ALL";
  		//cmbObj.text = arrStr[1];
  	 }   
	
	/** 
	 * 팝업창(COM_ENS_051_1)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.03
	 */
	function getCOM_ENS_051_1(rowArray) {
		var colArray = rowArray[0];
		document.form.loc_cd.InsertItem(0, colArray[3], colArray[3]);
		document.form.loc_cd.Text = colArray[3];
	}
	
	/** 
  	 * off_cd 콤보박스 출력시 사용-콤보박스 세팅<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
  	 * @param cmbObj : 대상객체, arrStr : 데이타 배열, allYn : ALL 추가여부(Y)
  	 * @return 없음
  	 * @see #
  	 * @author 한동훈
  	 * @version 2009.10.19
  	 */
	function MakeComboObject_OfcCd_2(cmbObj, arrStr, allYn) {
		cmbObj.RemoveAll(); 
   		for (var i = 1; i < arrStr.length;i++ ) {
   			var arrStr2 = arrStr[i].split("^");
   			var ar_ofc_cd = arrStr2[1];
   			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
   		}
   		if(allYn=='Y'){
   		cmbObj.InsertItem(0, "ALL", "ALL^ALL");
   		}
   		cmbObj.BackColor = "#CCFFFD";
   	 }
	/* 개발자 작업  끝 */