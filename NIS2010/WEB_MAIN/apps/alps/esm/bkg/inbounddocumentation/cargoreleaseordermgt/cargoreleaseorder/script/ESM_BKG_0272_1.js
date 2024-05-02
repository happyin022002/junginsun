/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0272_1.js
*@FileTitle : E-mail / Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.27 손윤석
* 1.0 Creation
* ===============================================================================
 History
* 2012.11.13 조정민 [CHM-201221007] [EUR Cargo Release] P/up Date 시간변경 (0000->2400)
* 2012.11.22 조정민 [CHM-201221094] POD DE일 경우 EU Full CNTR Release 에서 Email 전송시 전송내역 추가 요청
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
     * @class E-mail / Print : E-mail / Print 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0272_1() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnChangeSum	    = sheet1_OnChangeSum;
    }

	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var pageCnt = 0;
	
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

            switch(srcName) {

                case "btn_new":
                	formObject.recipient.value = "";
                    break;

                case "btn_E-mail":
                	fnMailSendSet();
                	
                	doActionIBSheet(sheetObject,formObject,MULTI02);
                    break;

                case "btn_close":
                	window.close();
                    break;

                case "btn_Prev":
                	
                	//메일 주소 유효성 검증
					fnSendMailDataSet();
                	
                	if (pageCnt < 2) {
                		pageCnt = 1;
                	} else {
                    	pageCnt = pageCnt - 1;                		
                	}
                	
                	fnPageSet();
                	
                	break;

                case "btn_Next":
                	
                	//메일 주소 유효성 검증
					fnSendMailDataSet();
                	
                	if (pageCnt == sheetObjects[0].RowCount) {
                		pageCnt = sheetObjects[0].RowCount;
                	} else {
                    	pageCnt = pageCnt + 1;                		
                	}
                	
                	fnPageSet();
                	
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
    function loadPage() 
    {
        for(i=0;i<sheetObjects.length;i++)
        {
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

		 ComBtnDisable("btn_Prev");
		 ComBtnDisable("btn_Next");
        
		 SheetGetData();

		 // 터미널 Yard 에게 보내는 경우
		 if(emailParam == "TMNL") {
			 doActionIBSheet(sheetObjects[0],document.form,COMMAND03);
			 
	     // 화주에게 보내는 경우
		 } else {
			 doActionIBSheet(sheetObjects[0],document.form,COMMAND04);
		 }

    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) 
    {
    	var cnt = 0;
    	switch(sheetObj.id) 
        {
            case "sheet1":      //t1sheet1 init
                with(sheetObj) {
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
	                InitRowInfo(1, 1, 2, 100);
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(25, 0, 0, true);
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false);
	
	                var HeadTitle1 = "|B/L No.|BKG No.|Container|POD|Yard|P/Up DT|Yard Name|Email|Phone No|Release Expiry Date|Fax No.|Remark|VslNm|VVD|LOC_NM|CUST_NM|TRSP_MOD|SEND_DATE|PIN_NO|Contents|||";
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	
	                prefix = "sheet1_";
	                
	                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,   30,    daCenter,    false,   prefix + "ibflag");
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "bl_no",           false,    "",      dfNone,            0,    false,    false);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "bkg_no",          false,    "",      dfNone,            0,    false,    false);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "cntr_no",         false,    "",      dfNone,            0,    false,    false);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "pod_cd",          false,    "",      dfNone,            0,    false,    false);	            
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "yd_cd",           false,    "",      dfEngUpKey,        0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "cgo_pkup_dt",     false,    "",      dfDateYmd,     0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "yd_nm",           false,    "",      dfNone,            0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "yd_eml",          false,    "",      dfNone,            0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "phn_no",          false,    "",      dfNone,            0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          120,    daCenter,    true,    prefix + "fax_no",          false,    "",      dfNone,            0,    false,    false);
	                InitDataProperty(0, cnt++ , dtData,          180,    daCenter,    true,    prefix + "diff_rmk",        false,    "",      dfNone,            0,    true,    true);
	              
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "vsl_nm",          false,    "",      dfNone,            0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "vvd",             false,    "",      dfNone,            0,    false,    false);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "loc_nm",          false,    "",      dfNone,            0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          180,    daCenter,    true,    prefix + "cust_nm",         false,    "",      dfNone,            0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          180,    daCenter,    true,    prefix + "cust_eml",        false,    "",      dfNone,            0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "bkg_trsp_mod_cd",  false,    "",     dfNone,    0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "send_date",       false,    "",      dfNone,    0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "do_no",           false,    "",      dfNone,    0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "do_iss_dt",       false,    "",      dfNone,    0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "pin_no",          false,    "",      dfNone,    0,    true,    true);
	                
	                InitDataProperty(0, cnt++ , dtData,          150,    daCenter,    true,    prefix + "msg_acpt_ref_no", false,    "",      dfNone,            0,    false,    false);
	                InitDataProperty(0, cnt++ , dtData,          130,    daCenter,    true,    prefix + "rlse_exp_dt",     false,    "",      dfDateYmd,         0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          120,    daCenter,    true,    prefix + "content",         false,    "",      dfNone,            0,    false,    false);
	            	
	               // InitDataCombo(0, prefix + "bkg_trsp_mod_cd", "Truck|Rail|Feeder|Barge", "T|R|F|B");

            	}
            	break;
            case "sheet2":      //t1sheet1 init
	            with(sheetObj) {
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
	                InitRowInfo(1, 1, 2, 100);
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(15, 0, 0, true);
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false);
	
	                var HeadTitle1 = "|B/L No.|BKG No.|Container|yd_cd|yd_eml|from|recipient|file_key|subject|carbon_copy|blind_carbon_copy|content|argument|template";
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	
	                prefix = "sheet2_";
	                
	                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,   30,    daCenter,    false,   prefix + "ibflag");
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "bl_no",           false,    "",      dfNone,            0,    false,    false);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "bkg_no",          false,    "",      dfNone,            0,    false,    false);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "cntr_no",         false,    "",      dfNone,            0,    false,    false);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "yd_cd",           false,    "",      dfNone,            0,    false,    false);
		        
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "yd_eml",          false,    "",      dfNone,            0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          120,    daCenter,    true,    prefix + "from",            false,    "",      dfNone,            0,    false,    false);
	                InitDataProperty(0, cnt++ , dtData,          120,    daCenter,    true,    prefix + "recipient",       false,    "",      dfNone,            0,    false,    false);
	
	                InitDataProperty(0, cnt++ , dtData,          180,    daLeft,      true,    prefix + "file_key",        false,    "",      dfNone,            0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daLeft,      true,    prefix + "subject",         false,    "",      dfNone,            0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "carbon_copy",     false,    "",      dfNone,            0,    false,    false);
	                InitDataProperty(0, cnt++ , dtData,          100,    daLeft,      true,    prefix + "blind_carbon_copy",false,    "",      dfNone,            0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          180,    daLeft,      true,    prefix + "content",         false,    "",      dfNone,            0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "argument",        false,    "",      dfNone,    0,    true,    true);
	                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    prefix + "template",        false,    "",      dfNone,    0,    true,    true);
	
		        }
		        break;

        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,MULTI02,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     * @param {String}  gubun     	처리할 gubun 값
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) 
    {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) 
        {
			case MULTI02:        //EMAIL 전송
				if(validateForm(sheetObj,formObj,sAction)) {
				    if(!ComShowCodeConfirm("BKG01069")) return;
				    
                	//메일 주소 유효성 검증
				    fnSendMailDataSet();

					formObj.f_cmd.value = MULTI02;

	                var sParam1 = sheetObjects[0].GetSaveString();
	                var sParam2 = sheetObjects[1].GetSaveString();
	                
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0272GS.do", sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj));
        			
        	        var rMsg = ComResultMessage(sXml);
        	    
        	        if(sXml != ''){
                    	var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
                     	
        				if(State == "S"){
        				   alert(rMsg.split('<||>').join('\n'));
        				   self.close();
         				// ComDeleteMsg(sXml);
        				} else {
        				   alert(rMsg.split('<||>').join('\n'));
        				}
        			 }
         		}
			
				break;
			case COMMAND03:      //터미널 Yard 에게 보내는 경우
	            formObj.f_cmd.value = COMMAND03;
	            
                var aryPrefix = new Array("sheet1_", "sheet2_"); //prefix 문자열 배열

                var sParam1 = sheetObjects[0].GetSaveString();

                var sXml = sheetObj.GetSearchXml("ESM_BKG_0272GS.do", sParam1 + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
         	            
                var arrXml = sXml.split("|$$|");

                for(var idx = 0; idx < arrXml.length; idx++){
                    
                    sheetObjects[idx].Redraw = false;
                    if(idx > 0) {
                        sheetObjects[idx].WaitImageVisible = false;
                    }
                    
                    sheetObjects[idx].LoadSearchXml(arrXml[idx]);
                    sheetObjects[idx].Redraw = true;
                }
	            
				State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
	            if(State == "F"){
					self.close();
				}
	            break;
	            
			case COMMAND04:      //화주에게 보내는 경우
	            formObj.f_cmd.value = COMMAND04;
	            
                var aryPrefix = new Array("sheet1_", "sheet2_"); //prefix 문자열 배열

                var sParam1 = sheetObjects[0].GetSaveString();
                var sXml = sheetObj.GetSearchXml("ESM_BKG_0272GS.do", sParam1 + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
      
                var arrXml = sXml.split("|$$|");

                for(var idx = 0; idx < arrXml.length; idx++){
                    
                    sheetObjects[idx].Redraw = false;
                    if(idx > 0) {
                        sheetObjects[idx].WaitImageVisible = false;
                    }
                    
                    sheetObjects[idx].LoadSearchXml(arrXml[idx]);
                    sheetObjects[idx].Redraw = true;
                }
	            
				State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
	            if(State == "F"){
					self.close();
				}
	            break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	if(form.recipient.value == "") {
    		ComAlertFocus(form.recipient, ComGetMsg('FMS01146'));
    		return false;
    	}

        return true;
    }
     
     /**
      * Opener의 Sheet에서 Data를 가져온다.
      * @param {void}
      * @return void
      * @author Park Mangeon
      * @version 2009.10.01
      */      
     function SheetGetData() {
         //
         var sXml = opener.form.mailXml.value;
         
         sheetObjects[0].LoadSearchXml(sXml);
         
         for(i=0;i<sheetObjects[0].RowCount;i++){
        	 sheetObjects[0].RowStatus(i+1) = "U";
         }
         
     }     
     
      /**
       * Opener의 Sheet에서 Data를 가져온다.
       * @param {void}
       * @return void
       * @author Park Mangeon
       * @version 2009.10.01
       */      
      function fnMailSendSet() {
    	   for(i=0;i<sheetObjects[0].RowCount;i++){
           	 sheetObjects[0].RowStatus(i+1) = "U";
            } 
    	   
          for(i=0;i<sheetObjects[1].RowCount;i++){
         	 sheetObjects[1].RowStatus(i+1) = "U";
          }          
      }           
      
      /**
       * sheet2의 조회가 완료된 시점에 값을 설정한다.
       * @param Object sheetObj IBSheet Object
       * @param Object ErrMsg   에러메시지
       * @return void
       * @author An JinEung
       * @version 2009.11.01
       **/
     function sheet2_OnSearchEnd(sheetObj, ErrMsg){

     	var prefix = "sheet2_";
     	
         if (ErrMsg == "") {
             if(sheetObj.RowCount > 0){
            	 for(i=0;i<sheetObjects[1].RowCount;i++){
	           	    sheetObjects[1].CellValue2(pageCnt, "sheet2_recipient") = sheetObjects[1].CellValue(pageCnt, "sheet2_yd_eml");
           	     	sheetObjects[1].CellValue2(pageCnt, "sheet2_subject") = document.form.subject.value;                 	 
                  }
            	 
            	 pageCnt = 1;
            	 
            	 fnPageSet();
             }

         } else {
        	 fnClear();
         }
     }      
     
     function fnPageSet() {
    	 var prefix = "sheet2_";
    	 
    	 if (pageCnt == 0) {
    		 fnClear();
    	 }
    	 
    	 
    	 document.form.pageCount.value = pageCnt + " of " + sheetObjects[1].RowCount;
    	 
    	 if (pageCnt == sheetObjects[1].RowCount) {
    		 ComBtnEnable("btn_Prev");
    		 ComBtnDisable("btn_Next")
    	 } else if (pageCnt == 1) {
    		 ComBtnDisable("btn_Prev")
    		 ComBtnEnable("btn_Next");    		 
    	 } else {
    		 ComBtnEnable("btn_Prev");
    		 ComBtnEnable("btn_Next");    		 
    	 }
    	 
    	 document.form.subject.value = sheetObjects[1].CellValue(pageCnt, prefix + "subject");
    	 document.form.recipient.value = sheetObjects[1].CellValue(pageCnt, prefix + "yd_eml");
    	 document.form.content.value = sheetObjects[1].CellValue(pageCnt, prefix + "content");
     }
     
     function fnClear() {
    	 document.form.pageCount.value = "";
    	 document.form.recipient.value = "";
    	 document.form.content.value = "";
     }

     function fnSendMailDataSet() {
    	    //메일 주소 유효성 검증
			/*
    	    if(!ComIsEmailAddr(document.form.recipient)) 
			{
			     ComShowCodeMessage("BKG40021", document.form.recipient.value );
			     document.form.recipient.focus();
			         
				return;
			}
			*/
     	
     	sheetObjects[1].CellValue2(pageCnt, "sheet2_yd_eml") = document.form.recipient.value;
     	sheetObjects[1].CellValue2(pageCnt, "sheet2_recipient") = document.form.recipient.value;
     	sheetObjects[1].CellValue2(pageCnt, "sheet2_subject") = document.form.subject.value;
     }