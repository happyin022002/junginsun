/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0618.js
*@FileTitle : Loading Confirmation by Shipper (Fax / E-Mail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.25 김기종
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.06.03 이일민 [CHM-201111164] Loading Confimation by Shipper기능 - VVD조회조건 FEEDER포함
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
     * @class esm_bkg_0618 : esm_bkg_0618 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0618() {
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

    var rdObjects = new Array();
    var rdCnt = 0;
    
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;
             var param="";
        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
    						
    					case "btn_CheckAll":
    						CellCheckAll(sheetObject,true,"rcheck");
    						break;
    						
    					case "btn_UncheckAll":
    						CellCheckAll(sheetObject,false,"rcheck");
    						break;
    						
    					case "btn_Preview":
    						/*FAX / Email로 전송되는 내용 미리 보기
    						복수 선택 시, 한 개의 PDF 파일로 묶어서 볼 수 있도록 함		UI_BKG-0806
    						*/
    						/*FAX / Email로 전송되는 내용 미리 보기
    						복수 선택 시, 한 개의 PDF 파일로 묶어서 볼 수 있도록 함		UI_BKG-0806
    						*/
    						
    						if (CheckGrid(sheetObject,"")){
    							var param="";
    							param=RdParam(formObject,sheetObject,"");
    							ComSetObjValue(formObject.com_mrdPath,"apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0806.mrd");
    							ComSetObjValue(formObject.com_mrdArguments,param); 
    							ComSetObjValue(formObject.com_mrdTitle,"Loading Confirmation by Shipper Preview & Print");
    							ComOpenRDPopup('resizable=yes,width=1000,height=600,left=0,top=0');
    						}
    						break;
    						
    					case "btn_EditFAXEmail":
    						/*
    						UI_BKG-0221	"btnDisableFlg = 'N',
    						editDisableFlg = 'N',
    						rdId, bkgNoList"""	"Fax No
    						E-Mail 주소"	"입력된 Fax,E-Mail주소를 
    						전체 해당되는 Fax,Mail로 변경한다"
    						 */
     						if (CheckGrid(sheetObject,"")){ 
     				        	var width = 355;
     							var height = 170;
     							var left = (screen.width-width)/2;
     							var top = (screen.height-height)/2;
     							ComOpenWindow("about:blank","ESM_BKG_0221","width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
     							//send popup
     							var formObject3 = document.form3;
     							formObject3.elements["pop_mode"   ].value = "1";
     							formObject3.elements["display"    ].value = "1,0,1,1,1,1,1";
     							formObject3.elements["func"       ].value = "getCOM_Fax_Email_POPUP";
     							formObject3.elements["row"        ].value = "0";
     							formObject3.elements["col"        ].value = "0";
     							formObject3.elements["sheetIdx"   ].value = "0";
     							formObject3.elements["bkg_no"     ].value = "";
     							formObject3.elements["send_hidden"].value = "Y";
     							formObject3.action = "/hanjin/ESM_BKG_0221.do";
     							formObject3.target = "ESM_BKG_0221";
     							formObject3.submit();
     						}
     						break;					
    					case "btn_FAX":
    						doActionIBSheet(sheetObjects[0],formObject,"FAX");
    						break;  
    						
    					case "btn_EMail":
    						doActionIBSheet(sheetObjects[0],formObject,"EMAIL");
    						break;  
    						
    					case "btn_Retrieve":
    						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    						break;  
    						
    					case "btn_New":
    						sheetObjects[0].RemoveAll();
    	 					ComResetAll();
    	 					break;
    					case "btn_DownExcel":
    	 					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
    	 					break;
    	 					
    					case "btn_Print":
    						alert("btn_Print");
    						break;
    						
    					case "btn_ComEns041Pop":
    	 					openWindowCustomer(formObject);
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

    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
    			ComEndConfigSheet(sheetObjects[i]);
                 
    			
    		}
    		initRdConfig(rdObjects[0]);
    		initControl();
    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    		document.form.vvd_cd.focus();
    		
    		if(!(document.form.strCnt_cd.value == "KR" || document.form.strCnt_cd.value == "VN")){
    			ComSetDisplay("btn_Fax1", false);
    		}

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
        	//** Date 구분자 **/
        	DATE_SEPARATOR = "-";
        	
        	var formObject = document.form;
        	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
        	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
     	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
     	   
        	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        	
        	ComSetObjValue(formObject.snd_dt,ComGetNowInfo());
        	
        }

      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                case 1:      //sheet1 init
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 380;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 2, 100);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, true, false, true, false,false);

                        var HeadTitle1 = "|Sel.|Seq.|Booking Ref. No.|Booking No.|S/C|POR|POD|DEL|Container No.|ST|Fax|E-mail|subgroup_title||||";
                        var headCount = ComCountHeadTitle(HeadTitle1);
                        
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);
                        
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //데이터속성    [		ROW, COL,  	DATATYPE,   			WIDTH, DATAALIGN, 	COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    	InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	true,		"ibflag");
                    	InitDataProperty(0,	cnt++,	dtData,					40, 	daCenter,	false,		"rcheck",        	false,			"",		 dfNone,			0,		true);                    
						InitDataProperty(0, cnt++ , dtData,	       			40,     daCenter,   true,       "Seq",				false,			"",      dfNone,			0,		false,		false,		-1,			false,		false);
						InitDataProperty(0, cnt++ , dtData,					120,	daCenter,	true,		"bkg_ref_no",		false,			"",      dfNone,			0,		false,		false,		-1,			false,		false);
						InitDataProperty(0, cnt++ , dtData,					110,	daCenter,	true,		"bkg_no",			false,			"",      dfNone,			0,		false,		false,		-1,			false,		false);
						InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		"sc_no",			false,			"",      dfNone,			0,		false,		false,		-1,			false,		false);
						InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		"por_cd",			false,			"",      dfNone,			0,		false,		false,		-1,			false,		false);
						InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		"pod_cd",			false,			"",      dfNone,			0,		false,		false,		-1,			false,		false);
						InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		"del_cd",			false,			"",      dfNone,			0,		false,		false,		-1,			false,		false);

						InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		"cntr_no",			false,			"",      dfNone,			0,		false,		false,		-1,			false,		false);
						InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		"cnmv_sts_cd",		false,			"",      dfNone,			0,		false,		false,		-1,			false,		false);
						InitDataProperty(0, cnt++ , dtData,					130,	daLeft,	true,		"cntc_pson_fax_no",	false,			"",      dfNone,			0,		true,		true,		100,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					200,	daLeft,	true,		"cntc_pson_eml",	false,			"",      dfNone,			0,		true,		true,		200,		false,		false);
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"subgroup_title");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"bkg_cust_tp_cd");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"vvd_cd");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"bkg_ofc_cd");
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	false,		"bkg_c_person");
						
						
						//숫자와 "-", "," 입력하기
						InitDataValid(0, "cntc_pson_fax_no", vtNumericOther, "-,");
						//영문과 "1", "2", "3", "9" ,'@' 글자도 입력하기
						InitDataValid(0, "cntc_pson_eml", vtEngOther, "1234567890@_-.");

						FocusEditMode = -1;
						//FrozenCols  = 5;
                    }
                    break;

            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            var rdParam = "";
            switch(sAction) {
	            case IBCLEAR: // 화면 로딩시 코드 조회
					formObj.f_cmd.value = COMMAND01;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0618GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0) 
						ComXml2ComboItem(arrXml[0], formObj.bkg_cust_tp_cd, "val", "name");	
					
					ComSetObjValue(formObj.bkg_cust_tp_cd,"S");
					break;
	           case IBSEARCH:      //조회
	 	          if(validateForm(sheetObj,formObj,sAction)){
	 	        	 formObj.f_cmd.value = SEARCH;
	 	        	var sXml = sheetObj.GetSearchXml("ESM_BKG_0618_1GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					if (arrXml.length > 0) 
						sheetObj.LoadSearchXml(arrXml[0]); 
					
	 	          }	  
	              break;
	              
	           case IBDOWNEXCEL:      // 입력
	   				sheetObj.SpeedDown2Excel(-1);
	   				break;	
	   		   
	           case "EMAIL":  
	        	   if (CheckGrid(sheetObj,"")){ 
	        		   if (ComShowCodeConfirm("BKG01081") == false) return;
		        	   formObj.f_cmd.value = MULTI01;
		        	   formObj.rd_param.value = RdParam(formObj,sheetObj,"");
		        	   sheetObj.DoSave("ESM_BKG_0618GS.do", FormQueryString(formObj),-1,false);
	        	   }
	   				break;			
	           case "FAX":   
	        	   if (CheckGrid(sheetObj,"")){ 
	        		   if (ComShowCodeConfirm("BKG01082") == false) return;
	        		   rdParam = RdParam(formObj,sheetObj,"");
		        	   formObj.rd_param.value =RdParam(formObj,sheetObj,"");
		        	   formObj.f_cmd.value = MULTI02;
		        	   sheetObj.DoSave("ESM_BKG_0618GS.do", FormQueryString(formObj),-1,false);
	        	   }
	   				break;			
            }
        }

        function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	
        	var formObj = document.form;
	   	 	if (ErrMsg == "") {
	   	 		 	if (formObj.f_cmd.value == MULTI01){
	   	 		 		ComShowCodeMessage('BKG00497');
	   	 	 		}else if (formObj.f_cmd.value == MULTI02){
	   	 	 			ComShowCodeMessage('BKG00496');
	   	 	 		}
	    	} 	 	
        }
       
        /*
    	* Rd 파라함수
    	*/
    	function RdParam(formObject,sheetObject,prefix) { 
    		var strResult = ""; 
    		var pArray = new Array(9);
    		for(var idx=0;idx<pArray.length-1;idx++){
    			pArray[idx] = "";
    		}
    		var vsNM ="";
    		var tabflag="";
    		var iCheckRow = sheetObject.FindCheckedRow(prefix + "rcheck"); 
    		
    		var arrRow = iCheckRow.split("|"); 
    		
    		for (idx=0; idx<arrRow.length-1; idx++) {	
    			if(sheetObject.CellValue(arrRow[idx],prefix+"rcheck")==true){ 
    				sheetObject.RowStatus(arrRow[idx]) = "U";
    				if (pArray[0].length > 1){
    					pArray[0]+=","+"'"+sheetObject.CellValue(arrRow[idx],prefix+"bkg_no")+"'";
    					pArray[1]+=","+"'"+sheetObject.CellValue(arrRow[idx],prefix+"cntr_no")+"'";
    					pArray[2]+=","+"'"+sheetObject.CellValue(arrRow[idx],prefix+"bkg_cust_tp_cd")+"'";
    				}else{
    					pArray[0]="('"+sheetObject.CellValue(arrRow[idx],prefix+"bkg_no")+"'";
    					pArray[1]="('"+sheetObject.CellValue(arrRow[idx],prefix+"cntr_no")+"'";
    					pArray[2]="('"+sheetObject.CellValue(arrRow[idx],prefix+"bkg_cust_tp_cd")+"'";
    				}
    			}
    		}
    		
    		pArray[3] = ComGetObjValue(formObject.language);
    		pArray[4] = ComGetObjValue(formObject.mphn_no);
    		pArray[5] = ComGetObjValue(formObject.fax_no);
    		pArray[6] = ComGetObjValue(formObject.snd_dt);
    		pArray[7] = ComGetObjValue(formObject.strUsr_id);
    		pArray[8] = ComGetObjValue(formObject.strOffice_cd);
    		if(formObject.cnmv_sts_cd[0].checked){
        		pArray[9] = ComGetObjValue(formObject.cnmv_sts_cd[0]);
    		}else{
    			pArray[9] = ComGetObjValue(formObject.cnmv_sts_cd[1]);
    		}
    		pArray[10] = ComGetObjValue(formObject.vvd_cd);
    		
    		strResult ="/rv bkg_no["+ pArray[0]+")] " + "cntr_no["+ pArray[1]+")] " + "bkg_cust_tp_cd["+ pArray[2]+")] " + "language['"+ pArray[3]+"'] "+ "mphn_no['"+ pArray[4]+"'] "+ "fax_no['"+ pArray[5]+"'] "+ "snd_dt['"+ pArray[6]+"'] "+ "strUsr_id['"+ pArray[7]+"'] " + "strOffice_cd['"+ pArray[8]+"'] "  + "cnmv_sts_cd['"+ pArray[9]+"'] " + "vvd_cd['"+ pArray[10]+"'] ";
    		
    		return strResult; 
    	}

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	with(formObj){
             	switch(sAction) {

					case IBSEARCH: // 조회시 확인
					if (formObj.vvd_cd.value == "" 
							&& formObj.pol_cd.value=="" ) {
						/* office는  madantory 아님 	&& formObj.bkg_ofc_cd.value ==""){*/
	        	
		        		ComShowCodeMessage('BKG00626', 'VVD or POL');
		        		formObj.vvd_cd.focus();
		        		 return false;
		        	 }else if (formObj.vvd_cd.value !="" 
		        		 	&& formObj.pol_cd.value !=""){
		        		 null;
		        	 }else if (formObj.vvd_cd.value != "" 
		        		 	&& formObj.bkg_ofc_cd.value !=""){
		        		 null;	 
		        	 }else{
		        		 ComShowCodeMessage('BKG00626', 'BKG Office or POL');
		        		 formObj.pol_cd.focus();
		        		 return false;
		        	 }
		        	 
	         		if (!ComChkValid(formObj)) return false;
	         		break;
             	}	
             }
             return true;
        }

        /*
    	*Rd 설정
    	*/
    	function initRdConfig(rdObject){
    		var Rdviewer = rdObject;

    		Rdviewer.AutoAdjust = true;
    		Rdviewer.ViewShowMode(0); 
    		Rdviewer.setbackgroundcolor(128,128,128);
    		Rdviewer.SetPageLineColor(128,128,128);
    	}

    	function CheckGrid(sheetObject,prefix){
    		var iCheckRow = sheetObject.FindCheckedRow(prefix + "rcheck"); 
    		if (iCheckRow== "") {
    			ComShowCodeMessage('BKG00249');
    			return false;
    		}

    		return true;
    	}
    	function openWindowCustomer(formObj){
    		var param = FormQueryString(formObj);	
    		ComOpenPopup('COM_ENS_041.do?'+param, 780, 470, 'getCOM_ENS_041', '1,0,1,1,1,1,1,1,1,1', true);
    	}	
    	
    	function getCOM_ENS_041(aryPopupData) {
    		
      		var formObject = document.form;
      		var customer= aryPopupData[0][3];
      		
      		ComSetObjValue(formObject.cust_cnt_cd,customer.substr(0,2));
      		ComSetObjValue(formObject.cust_seq,customer.substr(2));
      		//formObject.vsl_cd.value = aryPopupData[0][7];
      	} 

        //edit fax/email 팝업에서 호출됨
        function getCOM_Fax_Email_POPUP(rowArray) {

        	if (rowArray && 0<rowArray.length && 5<rowArray[0].length) {
    	    	var faxno = rowArray[0][21];
    	        var email = rowArray[0][22];
    	    	var sheetObject = sheetObjects[0];
    			var arrRow = sheetObject.FindCheckedRow("rcheck").split("|");
    			if (arrRow && 0<arrRow.length) {
    				for (var i=0; i<arrRow.length-1; i++) {
    					sheetObject.CellValue2(arrRow[i], "cntc_pson_fax_no") = faxno;
    					sheetObject.CellValue2(arrRow[i], "cntc_pson_eml") = email;
    				}
    			}
        	}
        }
        
	/* 개발자 작업  끝 */