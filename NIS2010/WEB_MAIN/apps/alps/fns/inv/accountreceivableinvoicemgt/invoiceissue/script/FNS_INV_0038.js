/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0038.js
*@FileTitle : (N.China) Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
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
     * @class fns_inv_0038 : fns_inv_0038 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0038() {
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
	 var queryStr = "";
	
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

                 case "btn_Retrieve":
                     doActionIBSheet(sheetObject,formObject,IBSEARCH);
                     break;

                 case "btn_New":
                	 ComResetAll();
                	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);	//office 콤보조회
                     break;

                 case "btn_downExcel":
                     sheetObject.Down2Excel();
                     break;

                 case "btn_PaperIssue":
                	 doActionIBSheet(sheetObject,formObject,IBSAVE);
                	 //fnRdPrint(rdObjects[0], sheetObject, formObject);
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
    		sheetObj.WaitImageVisible = false; 
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);	//office 콤보조회            
            ComSetFocus(form.blNo);
            initControl();
            initRdConfig(rdObjects[0]);
            sheetObj.WaitImageVisible = true;
    	}
    	
    	/** 
      * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
	    axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	/** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 한동훈
      	 * @version 2009.10.19
	 */
	function obj_keypress(){
	    switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "ymd":
	            //숫자+"-"입력하기
	        	ComKeyOnlyNumber(event.srcElement);
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
	            break;
	        case "uppernum":
	        	//영문대+숫자 
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
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
     function initSheet(sheetObj,sheetNo,currCd) {

         var cnt = 0;
 				var sheetID = sheetObj.id;
         switch(sheetID) {

             case "sheet1":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 62;
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
                     if(currCd == "USD"){
                    	 var HeadTitle = "|INV No|BKG No|FRT USD|Ex. Rate|EQV USD|CHG USD|Total USD|curr_cd|ar_if_no|bl_src_no|io_bnd_cd";
                     }else if(currCd == "CNY"){
                    	 var HeadTitle = "|INV No|BKG No|FRT USD|Ex. Rate|EQV CNY|CHG CNY|Total CNY|curr_cd|ar_if_no|bl_src_no|io_bnd_cd";
                     }else if(currCd == "ALL"){
                    	 var HeadTitle = "|INV No|BKG No|FRT USD|Ex. Rate|EQV USD|CHG CNY|Total Amount|curr_cd|ar_if_no|bl_src_no|io_bnd_cd";                    	 
                     }else{
                    	 var HeadTitle = "|INV No|BKG No|FRT USD|Ex. Rate|EQV USD|CHG USD|Total USD|curr_cd|ar_if_no|bl_src_no|io_bnd_cd";
                     }
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  "ibflag");
                     InitDataProperty(0, cnt++ , dtData,    		 	130,	daCenter,		false,		"inv_no",			false,          "",      dfNone,      	0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,    		 	130,	daCenter,		false,		"bkg_no",			false,          "",      dfNone,      	0,     false,		false,		11);
                     InitDataProperty(0, cnt++ , dtData,    		 	130,	daRight,		false,		"frt_usd",			false,          "",      dfNullFloat,		2,     false,		false,		11);
                     InitDataProperty(0, cnt++ , dtData,    		 	130,	daRight,		false,		"ex_rate",			false,          "",      dfNullFloat,		6,     true,		true,		9);

					 InitDataProperty(0, cnt++ , dtData,    		 	140,	daRight,		false,		"eqv_usd",			false,          "",      dfNullFloat,		2,     false,		false,		11);
					 InitDataProperty(0, cnt++ , dtData,    		 	140,	daRight,		false,		"chg_usd",			false,          "",      dfNullFloat,		2,     false,		false,		11);
					 InitDataProperty(0, cnt++ , dtData,    		 	120,	daRight,		false,		"tot_usd",			false,          "",      dfNullFloat,		2,     false,		false,		11);
					 InitDataProperty(0, cnt++ , dtHidden,    		 	130,	daCenter,		false,		"curr_cd",			false,          "",      dfNone,      	0,     false,		false,		11);
					 InitDataProperty(0, cnt++ , dtHidden,    		 	130,	daCenter,		false,		"ar_if_no",			false,          "",      dfNone,      	0,     false,		false);
					 InitDataProperty(0, cnt++ , dtHidden,    		 	130,	daCenter,		false,		"bl_src_no",		false,          "",      dfNone,      	0,     false,		false);
					 InitDataProperty(0, cnt++ , dtHidden,    		 	130,	daCenter,		false,		"io_bnd_cd",		false,          "",      dfNone,      	0,     false,		false);


 										CountPosition = 0;
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
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBSEARCH_ASYNC10: //SalesCustomer Office 조회
         		ComOpenWait(true);  //대기이미지 표시	
         		formObj.f_cmd.value = SEARCH01;
				
				var sXml = sheetObj.GetSearchXml("FNS_INV_0038GS.do", FormQueryString(formObj));
	
				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
				var arrStr = sStr.split("|");
	
				MakeComboObject_OfcCd(formObj.ofc_cd2, arrStr);
	
				var arrStr2 = arrStr[1].split("^");
				var ofc_cd = arrStr2[3];
				formObj.ofc_cd2.text = ofc_cd;
				
        		var sStr = ComGetEtcData(sXml,"inv_prn_dvc_nm");
        		formObj.print_nm.value = sStr;        		
        		ComOpenWait(false); //대기이미지 숨김        		
         		break;
            case IBSEARCH:      //조회
            	if(validateForm(sheetObj,formObj,sAction) == false) return false; 
            	formObj.f_cmd.value = SEARCH;
				formObj.ofc_cd.value = formObj.ofc_cd2.text;
				//alert(FormQueryString(formObj));
				var sXml = sheetObj.GetSearchXml("FNS_INV_0038GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				
				sheetObjects[0].LoadSearchXml(arrXml[0]);											
                break;
 			case IBSAVE:        //저장
 				if(validateForm(sheetObj,formObj,sAction) == false) return false;
 				formObj.f_cmd.value = MULTI;
				var sParam = ComGetSaveString(sheetObjects, true, true);
				if (sheetObj.IsDataModified && sParam == "") return; 
				
                sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var SaveXml = sheetObj.GetSaveXml("FNS_INV_0038GS.do", sParam );
				//sheetObj.LoadSaveXml(SaveXml);
				
				var arrXml = SaveXml.split("|$$|");
				
				var invNo = ComGetEtcData(arrXml[0],"invNo");
				var arrStr = invNo.split("|");	
				
				for (var i=1; i<=sheetObjects[0].RowCount; i++) {
					for (var k = 0; k < arrStr.length;k++ ) {
						if(i == k+1){
						sheetObj.CellValue(i,"inv_no") = arrStr[k];
						continue;
						}
					}					
				}

				var inv_start_no = "";
				var inv_end_no = "";
				var tot_count = 0;

				for (var i=1; i<=sheetObjects[0].RowCount; i++) {
					if(sheetObjects[0].RowCount == 1){
						inv_start_no = sheetObj.CellValue(i,"inv_no");
						inv_end_no = sheetObj.CellValue(i,"inv_no");
					}else{
						if(i==1){
							inv_start_no = sheetObj.CellValue(i,"inv_no");
						}else if(i==2){
							inv_end_no = sheetObj.CellValue(i,"inv_no");
						}
					}
					//tot_count = tot_count + eval(sheetObj.CellValue(i,"tot_usd"));
				}

				formObj.inv_start_no.value = inv_start_no;
				formObj.inv_end_no.value = inv_end_no;
				formObj.tot_count.value = ComAddComma(sheetObjects[0].RowCount,"#,###");
				
				fnRdPrint(rdObjects[0], sheetObjects[0], formObj);
				
                 break;

 			case IBINSERT:      // 입력
                 break;
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
			case IBSEARCH: //조회
				if (ComIsNull(formObj.blNo)){
					ComShowCodeMessage('INV00004');
					ComSetFocus(form.blNo);
					return false;
				}				
				if (formObj.ofc_cd2.text == "") {
	         		ComShowCodeMessage('INV00004');
	         		ComSetFocus(form.ofc_cd2);
	 				return false;
	 			}				

			break;
    	 }
         return true;
     }
     
     /** 
      * Invoice Currency 변경에 따라 initSheet를 호출하여 header값을 세팅함. <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function fnCurrency() {
    		if(form.curCd[0].checked){  
    			initSheet(sheetObjects[0],1,form.curCd[0].value);
    		} 
    		if(form.curCd[1].checked){  
    			initSheet(sheetObjects[0],1,form.curCd[1].value);
    		} 
    		if(form.curCd[2].checked){  
    			initSheet(sheetObjects[0],1,form.curCd[2].value);
    		} 

     }
     
     /** 
      * 업무 자바스크립트 Sheet의 OnChange 이벤트 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트 
      * @param  {int} Row : 포커스가 위치해 있는 sheet의 Row
      * @param  {int} Col : 포커스가 위치해 있는 sheet의 Col 
      * @param  {int} Value : 포커스가 위치해 있는 sheet의 Row,Col 의 value값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function sheet1_OnChange(sheetObj, Row, Col, Value)  {
    	 with(sheetObj){
 			if(ColSaveName(Col) == "ex_rate"){
 				sheetObj.CellValue(Row, "eqv_usd") = eval(sheetObj.CellValue(Row, "frt_usd")) * eval(sheetObj.CellValue(Row, "ex_rate"));
 				sheetObj.CellValue(Row, "tot_usd") = eval(sheetObj.CellValue(Row, "eqv_usd")) + eval(sheetObj.CellValue(Row, "chg_usd"));
 			}
    	 }	
     }
     
     /** 
      * rd 생성시 초기화 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {rdObject} rdObject : rd오브젝트 
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function initRdConfig(rdObject){
		    var Rdviewer = rdObject ;
		    
			//Rdviewer.AutoAdjust = true;
			//Rdviewer.ViewShowMode(0);
			Rdviewer.style.height = 0;
		
			Rdviewer.setbackgroundcolor(128,128,128);
			Rdviewer.SetPageLineColor(128,128,128);
	}
     
     /** 
      * rd를 호출하고 생성하여 print함<br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {rdObject} rdObject : rd오브젝트 
      * @param  {IBSheet} sheetObject : 시트오브젝트 
      * @param  {object} formObject : 폼 오브젝트
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function fnRdPrint(rdObject, sheetObject, formObject){
    	 var Rdviewer = rdObject ;
    	 Rdviewer.SetAppendReport(1);
    	 var curr_cd = "";
    	 /*
    	if(form.curCd[0].checked){  
    		curr_cd = "USD";
 		} 
 		if(form.curCd[1].checked){  
 			curr_cd = "CNY";
 		} 
 		if(form.curCd[2].checked){  
 			curr_cd = "ALL";
 		} */
 		//alert(chnAmount("USD", "2,469.84"));
 		//alert(chnAmount("USD", "3,642.00"));
 		if(sheetObject.RowCount > 0){
	    	 for (var i=1; i<=sheetObject.RowCount; i++) {	    		 
	    		 //if(curr_cd != "ALL"){
	    			 //rdOpen(rdObjects[0], formObject, i, curr_cd);
	    		 //}else{
	    			 curr_cd = sheetObjects[0].CellValue(i,"curr_cd");
	    			 rdOpen(rdObjects[0], formObject, i, curr_cd);
	    		 //}
	    	 }
	    	 Rdviewer.SetAppendReport(0);
	    	 //프린트세팅
	    	 var print_nm = formObject.print_nm.value;
	    	 if(print_nm != ""){
	    		 Rdviewer.SetPrintInfo (print_nm, 1, 1, 4);
	    	 }
			 Rdviewer.CMPrint();
			 //Rdviewer.SaveAsPdfFile("C:\\a.pdf"); //PDF 파일로 저장
			 //Rdviewer.SaveAsWordFile ("C:\\a.doc");	//MS Word 파일로 저장
			 //Rdviewer.SaveAsPptFile ("C:\\a.ppt"); //PowerPoint 파일로 저장
			 //Rdviewer.SaveAsHwpFile ("C:\\a.hwp"); //HWP 파일로 저장
			 //Rdviewer.SaveAsDialog();
			 //Rdviewer.ViewPdf();
			 //Rdviewer.SaveAsMrrFile("C:\\a.mrr"); //PDF 파일로 저장
 		}	 
     }
     
     /** 
      * rd를 호출하고 생성하여 print함<br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {rdObject} rdObject : rd오브젝트 
      * @param  {object} formObject : 폼 오브젝트
      * @param  {int} i : sheet에서 선택된 row의 curr_cd
      * @param  {String} curr_cd : 
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function rdOpen(rdObject, formObject, i, curr_cd){
    	 	var Rdviewer = rdObject ;
			var ofc_cd = document.form.ofc_cd.value;									
			var inv_no = sheetObjects[0].CellValue(i,"inv_no");
			var tot_amount = sheetObjects[0].CellText(i,"tot_usd");
			var chn_amount = chnAmount(curr_cd, tot_amount);
			var rdParam = "/rv " + "frm1_inv_no["+inv_no+"] frm1_ofc_cd ["+ofc_cd+"] frm1_curr_cd ["+curr_cd+"] frm1_tot_amount["+tot_amount+"] frm1_chn_amount["+chn_amount+"]";
			var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";
			var rdFile = "FNS_INV_0516.mrd";
			//alert(rdParam);
					
			//Rdviewer.FileOpen("http://localhost:7001/hanjin/" + rdUrl + rdFile, RDServer + rdParam+ "/rpagenuminit [1] /riprnmargin /rwait");
			Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam+ "/rpagenuminit [1] /riprnmargin /rwait");
			//Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam+ "/rpagenuminit [1] /riprnmargin /rwait");

		}
     
     /** 
      * rd를 호출시 금액을 중국어로 변경하여 rd에 파라미터로 넘겨줘서 출력<br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {String} curr_cd : sheet에서 선택된 row의 curr_cd
      * @param  {int} amount : sheet에서 선택된 row의 금액
      * @return {String} 중국어 금액
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function chnAmount(cur_cd, amount){
    	 var amount = replaceAll(amount,',','');
    	 var chn_amount = "";
    	 var array_data = amount.split(".");  
    	 var a_pnt = array_data[0];	//.앞에 정수
    	 var b_pnt = array_data[1];	//.뒤에 소수
    	 
    	 if(cur_cd == "CNY"){
    		 chn_amount = "人民币";
    	 }else{
    		 chn_amount = "美元";
    	 }    	 
    	 var r_unit = "";
    	 //정수 변환
    	 var a_length = a_pnt.length;
    	 var a_unit = "";    	     	 
    	 var ak_length = "";
    	 for(i=0; i<a_length; i++){
    		 a_unit = a_pnt.substr(i, 1);
    		 //금액(일~구)
    		 if(a_unit == "1"){
    			 r_unit = r_unit + "壹";
    		 }else if(a_unit == "2"){
    			 r_unit = r_unit + "贰";
    		 }else if(a_unit == "3"){
    			 r_unit = r_unit + "叁";
    		 }else if(a_unit == "4"){
    			 r_unit = r_unit + "肆";
    		 }else if(a_unit == "5"){
    			 r_unit = r_unit + "伍";
    		 }else if(a_unit == "6"){
    			 r_unit = r_unit + "陆";
    		 }else if(a_unit == "7"){
    			 r_unit = r_unit + "柒";
    		 }else if(a_unit == "8"){
    			 r_unit = r_unit + "捌";
    		 }else if(a_unit == "9"){
    			 r_unit = r_unit + "玖";
    		 }
    		 //금액단위(십~천만)
    		 if(a_unit != "0"){
    			 ak_length = a_length - i;
    			 if(ak_length == "2"){
    				 r_unit = r_unit + "拾";
    			 }else if(ak_length == "3"){
    				 r_unit = r_unit + "佰";
    			 }else if(ak_length == "4"){
    				 r_unit = r_unit + "仟";
    			 }else if(ak_length == "5"){
    				 r_unit = r_unit + "万";
    			 }else if(ak_length == "6"){
        			 r_unit = r_unit + "拾万";
    			 }else if(ak_length == "7"){
        			 r_unit = r_unit + "佰万";
    			 }else if(ak_length == "8"){
        			 r_unit = r_unit + "仟万";
    			 }	 
    		 }
    	 }
    	 
    	//소수 변환
    	 if(b_pnt == "" || b_pnt == "00"){	//소수금액이 없는경우
    		 r_unit = r_unit + "元整";
    	 }else{				//소수금액이 있는경우
    		 r_unit = r_unit + "元";
    		 
    		 var b_length = b_pnt.length;    	 
        	 var b_unit = "";
        	 var bk_length = "";
    		 for(i=0; i<b_length; i++){
        		 b_unit = b_pnt.substr(i, 1);
        		 //금액(일~구)
        		 if(b_unit == "1"){
        			 r_unit = r_unit + "壹";
        		 }else if(b_unit == "2"){
        			 r_unit = r_unit + "贰";
        		 }else if(b_unit == "3"){
        			 r_unit = r_unit + "叁";
        		 }else if(b_unit == "4"){
        			 r_unit = r_unit + "肆";
        		 }else if(b_unit == "5"){
        			 r_unit = r_unit + "伍";
        		 }else if(b_unit == "6"){
        			 r_unit = r_unit + "陆";
        		 }else if(b_unit == "7"){
        			 r_unit = r_unit + "柒";
        		 }else if(b_unit == "8"){
        			 r_unit = r_unit + "捌";
        		 }else if(b_unit == "9"){
        			 r_unit = r_unit + "玖";
        		 }
        		 
        		//금액단위(십~천만)
        		 if(b_unit != "0"){
        			 bk_length = b_length - i;
        			 if(bk_length == "1"){
        				 r_unit = r_unit + "角";
        			 }else if(bk_length == "2"){
        				 r_unit = r_unit + "分";
        			 }
        		 }
    		 }	 
    	 }
    	 
    	 //소수 변환
    	 chn_amount = chn_amount + r_unit;
    	 return chn_amount;
     }
     
     /** 
      * 문자에 대해 특정 문자열을 다른 문자열로 치환<br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {String} strTemp : 치환 대상 문자
      * @param  {String} strValue1 : 대상문자에서 치환할 문자
      * @param  {String} strValue2 : 다른 문자열로 치환할 문자
      * @return {String} 중국어 금액
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function replaceAll(strTemp, strValue1, strValue2){
   	  while(1){
   	    if( strTemp.indexOf(strValue1) != -1 )
   	       strTemp = strTemp.replace(strValue1, strValue2);
   	    else
   	       break;
   	  }
   	   return strTemp;
   	 
   	}

	/* 개발자 작업  끝 */