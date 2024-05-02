/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0053.js
*@FileTitle : ESM_BKG-0053
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.01 임재택
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
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0053() {
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
        	var sheetObject1 = sheetObjects[0];
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

    				case "btn_transmit":
    					doActionIBSheet(sheetObject1,document.form,IBSAVE);
    					break;

    				case "btn_close":
    					window.close();
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
        
     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
        	 
             switch(sAction) {
                case IBSAVE:        //저장
                
                if(!validateForm(sheetObj,formObj,sAction)) {
				 		return false;
				}
                
                formObj.frm_vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
    			formObj.frm_skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
	 	    	formObj.frm_skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);
	 	    	
	 	    	if(formObj.edi_gubun.checked)
	 	    		formObj.frm_trans_gubun.value = "M";
	 	    	if(formObj.edi_gubun2.checked)
	 	    		formObj.frm_trans_gubun.value = "P";
	 	    	if(formObj.edi_gubun.checked && formObj.edi_gubun2.checked)
	 	    		formObj.frm_trans_gubun.value = "A";
	 	    	
		 	    if (document.form.pol_gubun(0).checked)
	 	    	{
	 	    		document.form.frm_pol_cd.value = document.form.frm_port_cd.value;
	 	    		document.form.frm_pod_cd.value = "";
	 	    	} else {
	 	    		document.form.frm_pol_cd.value = "";
	 	    		document.form.frm_pod_cd.value = document.form.frm_port_cd.value;
	 	    	}
	 	    	
	 	    	//Manifest Type 값을 구한다.
	 	    	for(var i = 0; i < document.form.type_gubun.length; i++) {
	 	    		if(document.form.type_gubun[i].checked)
	 	    			document.form.frm_edi_ind.value = document.form.type_gubun[i].value;
	 	    	}
	 	    	IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
	 	    	
	 	    	sheetObj.CellValue2(1, "ibflag") = "I";
				formObj.f_cmd.value = MULTI;
				
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				
			    var sParam = "";
				var sParamSheet2 = sheetObjects[0].GetSaveString();
				if (sParamSheet2 != "") {
					sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1_");
				}
				sParam += "&" + FormQueryString(formObj);
				ComOpenWait(true);
				
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0053GS.do", sParam);
				//sheetObj.DoAllSave("ESM_BKG_0723GS.do", FormQueryString(formObj));
				var key = ComGetEtcData(sXml, "KEY");
				ComOpenWait(true);
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
				
				//var sXml = sheetObj.GetSaveXml("ESM_BKG_0053GS.do", sParam);
				//ComOpenWait(false); 
				//sheetObjects[0].LoadSaveXml(sXml);
				//sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
				//formObj.output.value=sheetObjects[0].EtcData("flatFile");
                break;
             }
      }
     
     /**
      * BackEndJob 실행결과조회.
      */
     function doActionValidationResult(sheetObj, sKey) {
     	 sheetObjects[0].WaitImageVisble = false;
     	 var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0053GS.do?f_cmd=" + SEARCH03
     			+ "&key=" + sKey);
     	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

     	// 에러가 발생했을 경우 대기사항을 종료한다.
     	if (!ComBkgErrMessage(sheetObj, sXml)) {
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		return;
     	}
     	if (sJbStsFlg == "SUCCESS") {
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		// 성공메시지 보여주고
     		ComShowCodeMessage('BKG00204');
     		//ComShowMessage(ComResultMessage(sXml));
     		return;
     	} else if (sJbStsFlg == "FAIL") {
     		//에러
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		// 에러메시지 보여주고
     		ComShowMessage(ComResultMessage(sXml));
     	}
     	
     	
     }

        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	 
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            initSheetData(sheetObjects[0], document.form);
             axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
        	 axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
        	 axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
        	 axon_event.addListenerForm("click","obj_click", document.form);

        }

         function initSheetData(sheetObj, formObj) {       		 
     		sheetObj.RemoveAll();
     		sheetObj.DataInsert(-1);
     		IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
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

                         var HeadTitle1 = "|vvd_number|VSL_CD|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|edi_ind|trans_gubun|port_cd";
                         var headCount = ComCountHeadTitle(HeadTitle1);

                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                         InitColumnInfo(headCount, 0, 0, true);

                         // 해더에서 처리할 수 있는 각종 기능을 설정한다
                         InitHeadMode(true, true, false, true, false,false);
                         
                         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                         InitHeadRow(0, HeadTitle1, true);
                         
                         //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     					 InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	false,	"ibflag");
     					
     					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"vvd_number",			false,	"",	dfNone,	0,	false,	false);
     					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"vsl_cd",			false,	"",	dfNone,	0,	false,	false);
     					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"skd_voy_no",			false,	"",	dfNone,	0,	false,	false);
     					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"skd_dir_cd",			false,	"",	dfNone,	0,	false,	false);
     					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"pol_cd",		false,	"",	dfNone,	0,	false,	false);
     					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"pod_cd",		false,	"",	dfNone,	0,	false,	false);
     					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"edi_ind",		false,	"",	dfNone,	0,	false,	false);
     					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"trans_gubun",		false,	"",	dfNone,	0,	false,	false);
     					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"port_cd",		false,	"",	dfNone,	0,	false,	false);
     	            }
                     break;
                 }
             }
        
          /**
      	* HTML Control의 onkeyUp이벤트에서 키보드 입력을 제어한다.
      	**/
      	function obj_KeyUp() {
      		    
      		    var formObject = document.form;
      		    var srcName = window.event.srcElement.getAttribute("name");
      		    var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
      		    var srcValue = window.event.srcElement.getAttribute("value");
      		    if (ComChkLen(srcValue, srcMaxLength) == "2") {
      		    	ComSetNextFocus();
      		    }
      	}
      	
      	/**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	 switch (sAction) {
        	 case IBSAVE:
        		 if (formObj.frm_vvd_number.value == "" ) 
     			 {
     				ComShowCodeMessage('BKG00227');
     				formObj.frm_vvd_number.focus();
     				return false;
     			 } 
        		 if (formObj.frm_vvd_number.value.length > 0 && formObj.frm_vvd_number.value.length < 9) {
     				ComShowCodeMessage('BKG00227');
     				formObj.frm_vvd_number.focus();
     				return false;
     			 }
        		 for(var i = 0; i < document.form.pol_gubun.length; i++) {
         		    if(document.form.pol_gubun[i].checked) {
         		    	if(document.form.pol_gubun[i].value == 1)
         		    	{
         		    		if ( formObj.frm_port_cd.value == "" ) 
         	     			{
         	     				ComShowCodeMessage('BKG00209');
         	     				formObj.frm_port_cd.focus();
         	     				return false;
         	     			}
         		    		if (formObj.frm_port_cd.value.length > 0 && formObj.frm_port_cd.value.length < 5) {
         						ComShowCodeMessage('BKG00209');
         						formObj.frm_port_cd.focus();
         						return false;
         					}
         		    	}
         		    	if(document.form.pol_gubun[i].value == 2)
         		    	{
         		    		if ( formObj.frm_port_cd.value == "" ) 
         	     			{
         	     				ComShowCodeMessage('BKG00210');
         	     				formObj.frm_port_cd.focus();
         	     				return false;
         	     			}
         		    		if (formObj.frm_port_cd.value.length > 0 && formObj.frm_port_cd.value.length < 5) {
         						ComShowCodeMessage('BKG00210');
         						formObj.frm_port_cd.focus();
         						return false;
         					}
         		    	}
         		    }
        		 }
        		
        		 
        		/**
        		 * VVD의 등록 여부를 체크 
        		 */ 
        		 
        		formObj.frm_vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
     			formObj.frm_skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
 	 	    	formObj.frm_skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);
 	 	   		formObj.f_cmd.value = SEARCH01;
        		 
  	   			var searchXml = sheetObj.GetSearchXml("ESM_BKG_0053GS.do" , FormQueryString(formObj));
  	   			if (ComGetEtcData(searchXml,"vvdExist") == "none"){
  	   			
  	   				ComShowCodeMessage("BKG02106");//VVD is NOT Registered
  	   				formObj.frm_vvd_number.focus();
  	   				return false;
  	   			}
  	   			
        		 var isCheck = 0;
        		 if(formObj.edi_gubun.checked || formObj.edi_gubun2.checked)
        			 isCheck++;
        		 if(isCheck == 0)
        		 {
        			 ComShowCodeMessage('BKG00212');
					 return false;
        		 }
        		 
        	 return true;
        	 break;
            }
        }
        
         
         
         
         
         
         
         
         
         
         