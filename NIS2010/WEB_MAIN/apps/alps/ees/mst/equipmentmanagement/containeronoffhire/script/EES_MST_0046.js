/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0046.js
*@FileTitle : Manufacture Date & Manufacturer Inquiry and Update
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.02.18 이호선
* 1.0 Creation
=========================================================
*2010.06.24 : NKJH 
     - Manufacture Date|Manufacturer Code가 "" 인경우도 UPDate 되게처리
                  현재는 ""인경우 에러로 처리해 저장하지 않는다.
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
     * @class ees_mst_0046 : ees_mst_0046 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0046() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
		this.clearForm 				= clearForm;    
		this.sheet1_OnChange        = sheet1_OnChange;
		this.sheet1_OnAfterEdit     = sheet1_OnAfterEdit;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var IBSEARCH01  = 29;
 var IBSEARCH02  = 30;
 var tcnt = 0;
 var blurflg = false;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

     // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

         try {
             var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
	     		case "btns_vndr":	// Lessor Code 가져오기 팝업
	     			ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 480, "vndr_seq:vndr_seq|vndr_lgl_eng_nm:vndr_lgl_eng_nm", "0,0,1,1,1,1", true);
				break;	           	
             
				case "btn_retrieve":
					if (formObject.vndr_seq.value == "") {
						ComShowCodeMessage("MST00001", "Lessor");
					} else {
						formObject.cntr_nos.value = "";
						sheetObject1.RemoveAll();
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					
				break;
				
				case "btn_loadexcel" :
					sheetObject1.RemoveAll();
					var ccheck = sheetObject1.LoadExcel(-1,1,"",-1,-1,"",false);

					formObject.cntr_nos.value = "";
					for (var i = 1; i <= sheetObject1.RowCount; i++){
						if (formObject.cntr_nos.value == ""){
							formObject.cntr_nos.value = sheetObject1.CellValue(i,"cntr_no");
						} else {
							formObject.cntr_nos.value = formObject.cntr_nos.value + "," + sheetObject1.CellValue(i,"cntr_no");
						}
						
						var tmpmftdt = sheetObject1.CellValue(i,"mft_dt");
						var mftdt = tmpmftdt.replace(/-/gi,"");
						if (isNumber(mftdt) == false || mftdt == "")
							sheetObject1.CellValue(i,"ceflg") = "E";
						
						var tmpmftrvndrseq =  sheetObject1.CellValue(i,"mftr_vndr_seq");
						if (isNumber(tmpmftrvndrseq) == false || tmpmftrvndrseq == "")
							sheetObject1.CellValue(i,"beflg") = "E";
					}
//					2010.06.24 mftr_vndr_seq와 mft_dt가 null일경우도 업데이트 처리함    
//					for(var i = sheetObject1.RowCount; i >= 1; i--){  
//						if (sheetObject1.CellValue(i,"mftr_vndr_seq") == "" || sheetObject1.CellValue(i,"mft_dt") == ""){ 
//							sheetObject1.RowDelete(i,false);  
//						}
//					} 
					if (sheetObject1.RowCount > 0){
					    doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					} else {
	            		//ComShowCodeMessage("MST00001","Row");
	            		return;							
					}					
				break;
				
				case "btn_downexcel" :
					sheetObject1.SpeedDown2Excel(-1);
				break;	
				
				case "btn_new":
					sheetObject1.RemoveAll();
					formObject.vndr_seq.value = "";
					formObject.vndr_lgl_eng_nm.value = "";
					formObject.lstmcd.value = ""
					formObject.cntr_nos.value = "";
					formObject.md_flg[1].checked = true;
					formObject.m_flg[1].checked = true;
					formObject.agmt_seq.value = "";
					formObject.agmt_cty_cd.value = "HHO";
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE)
				break;
				
                case "ComOpenPopupWithTargetAgmtNo": //agmt no
                if (formObject.agmt_seq.readOnly == false)
   			       ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '0,0,1', true); 			                	
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

         //IBSheet 초기화하기
         for(i=0;i<sheetObjects.length;i++){

             //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
     }
      
     function sheet1_OnLoadFinish(sheetObj) {
     }      
      
 	 // Axon 이벤트 처리
 	 // 1. 이벤트catch
 	 function initControl() {
 		var formObj = document.form;
 		axon_event.addListenerFormat('blur',	'obj_blur',          form);   //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리 		
        axon_event.addListenerFormat('focus',   'obj_focus',         form);   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
 	    axon_event.addListener('keydown',		'ComKeyEnter',	     'form'); //- 키 눌렸을때
 	    axon_event.addListenerFormat('keypress','obj_keypress',	     form);   //- 키 눌렸을때
  	}

 	function obj_keypress(){
	    
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    var vKeyCode = event.keyCode;

	    switch(obj.dataformat) {
	        case "engup":
	            if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum');	  
	            if(obj.name=="agmt_cty_cd") ComKeyOnlyAlphabet('upper');
	            if(obj.name=="agmt_seq") ComKeyOnlyNumber('int');
	            break;
	        case "ymd":
	        	if(obj.name=="hire_date") ComKeyOnlyNumber('int', "-");
	        	break;
	    }
	}
 	
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_blur(){
		var formObj = document.form;
		var obj = event.srcElement;
		
	    if (event.srcElement.name == "hire_date"){

	    }
	    else {
            //Validation 전체 체크(길이,format,최대,최소 등등)
            ComChkObjValid(obj);
	    }
	}
	
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_focus(){
		var formObj = document.form;
		var obj = event.srcElement;
		
	    if (event.srcElement.name == "hire_date"){		
	    	ComClearSeparator(formObj.hire_date, "ymd");
	    	ComSetFocus(formObj.hire_date);
	    }	
	}	
      
     /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetNo) {
             case 1:      // t1sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 410;
                     
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     var HeadTitle1 = "|CNTR No.|TP/SZ|Term|On Hire Date|On Hire Yard|Manufacture Date|Manufacturer Code|Manufacturer Name|a|b|c|d|e";

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtHiddenStatus,0,    daCenter,  true,   "ibflag");
                     InitDataProperty(0, cnt++, dtData,        100,  daCenter,  false,  "cntr_no",       false,  "",     dfNone,      0,     false,		false, 11);
                     InitDataProperty(0, cnt++, dtData,        70,  daCenter,  false,  "cntr_tpsz_cd",   false,  "",     dfNone,      0,     false,		false,2);
                     InitDataProperty(0, cnt++, dtData,        70,  daCenter,  false,  "lstm_cd",        false,  "",     dfNone,      0,     false,		false,2);
                     InitDataProperty(0, cnt++, dtData,        100,  daCenter,  false,  "onh_dt",        false,  "",     dfNone,      0,     false,		false, 2);
                     InitDataProperty(0, cnt++, dtData,        100,   daCenter,  false,  "onh_yd_cd",    false,  "",     dfNone,      0,     false,		false, 2);
                     InitDataProperty(0, cnt++, dtData,        130,  daCenter,  false,  "mft_dt",        false,  "",     dfNone,      0,     false,		false, 3);
                     InitDataProperty(0, cnt++, dtData,        130,  daLeft,    false,  "mftr_vndr_seq", false,  "",     dfNone,      0,     false,		false, 20);
                     InitDataProperty(0, cnt++, dtData,        150,   daCenter,  false,  "mftr_vndr_nm", false,  "",     dfNone,      0,     false,		false, 6);
                     
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "aeflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "beflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "ceflg",       false,     "",      dfNone,        0,     true,       true);                     
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "deflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "eeflg",       false,     "",      dfNone,        0,     true,       true);                     
                     
                     PopupImage  =  "img/btns_search.gif";
                     ShowButtonImage = 1;
                     SelectFontBold = true;
                     SelectHighLight = false;
                 }
                 break;
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
			case IBSEARCH:      //조회
            if(validateForm(sheetObj,formObj,sAction)){
            	
				 var aecnt = 0;
				 var becnt = 0;
				 var cecnt = 0;
				 var decnt = 0;
				 var eecnt = 0;            	
				 var tmpCntrNo ="";
				 
			     // 동일한  cntr_no 있으면  첫번째 중복행에 대해서  메세지 출력
        		 var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
        		 var arrRow = dupRows.split(",");
        		
		         if (dupRows != ""){
		        	 //오류메시지 : 데이터가 중복됩니다.	       			 
		             for( var t=0; t<arrRow.length; t++){
		            	 tmpCntrNo = tmpCntrNo + sheetObj.CellValue(arrRow[t],"cntr_no")+",";
//			         	for (var i = 1; i <= sheetObj.RowCount; i++){
			            	 if (sheetObj.CellValue(arrRow[t],"cntr_no")   == sheetObj.CellValue(arrRow[t],"cntr_no") ){
			       			     sheetObj.SelectCell(arrRow[t], "cntr_no", true);
			       			     sheetObj.CellValue(arrRow[t],"deflg") = "E";
			       			     decnt++;
			       			     sheetObj.CellFontColor(arrRow[t],"cntr_no") = sheetObj.RgbColor(255, 0, 0);
//			       			     break;
			            	 }
//			             }
		             }
		             ComShowCodeMessage("MST00002", tmpCntrNo);
		         }
            	
				 if (formObj.cntr_nos.value != ""){
					 
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);				
					formObj.f_cmd.value = SEARCH;
		     	    var sParam = ComGetSaveString(sheetObjects[0]);
		     	    sParam += "&" + FormQueryString(formObj);
		     	    var sXml = sheetObj.GetSearchXml("EES_MST_0046GS.do", sParam);
		     	    ComOpenWait(false);
		     	    var chk = sXml.indexOf("ERROR");
					if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchXml(sXml);
					   return;
					} else {
					   sheetObj.LoadSearchXml(sXml);
					} 		     	    
				    for (var i = 1; i <= sheetObj.RowCount; i++){
				    	sheetObj.RowStatus(i) = "U";
						if (sheetObj.CellValue(i,"aeflg") == "E"){ //Term Error
							sheetObj.CellFontColor(i,"lstm_cd") = sheetObj.RgbColor(255, 0, 0);
							sheetObj.RowStatus(i) = "R";           //대상이아닌경우 Status를 R로 변경
						    aecnt++;
						}
						
						if (sheetObj.CellValue(i,"beflg") == "E"){ //Manufacturer Code Error
							sheetObj.CellFontColor(i,"mftr_vndr_seq") = sheetObj.RgbColor(255, 0, 0);
							sheetObj.RowStatus(i) = "R";	  //대상이아닌경우 Status를 R로 변경
						    becnt++;
						}
						
						var retval = sheetObj.CellValue(i,"mft_dt");
						retval = sReplace_str(retval, "-","");
						var retalt = false;
						if (retval.length == 8){
						   retalt = isValidDay(retval.substr(0,4),retval.substr(4,2),retval.substr(6,2));
						   if (!retalt){
							   sheetObj.CellValue(i,"ceflg") = "E";
						   }
						} else {
							if (retval!="")sheetObj.CellValue(i,"ceflg") = "E";
						}   
						if (sheetObj.CellValue(i,"ceflg") == "E"){ //Manufacturer Date Error
							sheetObj.CellFontColor(i,"mft_dt") = sheetObj.RgbColor(255, 0, 0);
							sheetObj.RowStatus(i) = "R";		   //대상이아닌경우 Status를 R로 변경
						    cecnt++;
						}
						
						if (sheetObj.CellValue(i,"deflg") == "E"){ //Manufacturer container 중복 Error
							sheetObj.CellFontColor(i,"cntr_no") = sheetObj.RgbColor(255, 0, 0);
							sheetObj.RowStatus(i) = "R";
						    decnt++;
						}
						
						if (sheetObj.CellValue(i,"cntr_tpsz_cd") == ""){ //존재하지않는 컨테이너
							sheetObj.CellFontColor(i,"cntr_no") = sheetObj.RgbColor(255, 0, 0);
						    sheetObj.CellValue(i,"deflg")='E';
							sheetObj.RowStatus(i) = "R";
						    decnt++;
						}
					}

				    if (aecnt > 0 || becnt > 0 || cecnt > 0 || decnt > 0){
				    	ComShowCodeMessage("MST01026");
				    }
				 } else {
	                 sheetObj.WaitImageVisible=false;
	                 ComOpenWait(true); 						
					 formObj.f_cmd.value = SEARCH01;
		     	     var sParam = ComGetSaveString(sheetObjects[0]);
		     	     sParam += "&" + FormQueryString(formObj);
		     	     var sXml = sheetObj.GetSearchXml("EES_MST_0046GS.do", sParam);

		     	     ComOpenWait(false);
		     	     var chk = sXml.indexOf("ERROR");
					 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchXml(sXml);
					   return;
					 } else {
					   sheetObj.LoadSearchXml(sXml);
					 } 					 
				 }
             }
			break;
			
			case IBSAVE:
				//dup 체크
//            	var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
//        		var arrRow = dupRows.split(",");
//		        if (dupRows != ""){
//	       			 //오류메시지 : 데이터가 중복됩니다.
//	       			 ComShowCodeMessage("MST00002", sheetObj.CellValue(arrRow[0],"cntr_no"));
//		             sheetObj.SelectCell(arrRow[0], "cntr_no", true);
//	       			 return;
//		        }
		        
		        var chkUpdate = false;
		        for (var i = 1; i <= sheetObj.RowCount; i++){
		        	if (sheetObj.RowStatus(i) == "U"){
		        		chkUpdate = true;
		        		break;
		        	}	
		        }
		        if (!chkUpdate){
		        	ComShowCodeMessage("MST00012");
		        	return;
		        }
		        
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);				
		    	formObj.f_cmd.value = MULTI;
     	        var sParam = ComGetSaveString(sheetObjects[0]);
     	        sParam += "&" + FormQueryString(formObj);
     	        var sXml = sheetObj.GetSaveXml("EES_MST_0046GS.do", sParam);
     	        ComOpenWait(false);
     	        
				var chk = sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					sheetObj.LoadSearchXml(sXml);
					return;
				} else {  	     	        
					ComShowCodeMessage("MST01025");
				}
				
				for(var i = sheetObj.RowCount; i >= 1; i--){
					if (sheetObj.CellValue(i,"aeflg") != "E" && 
						sheetObj.CellValue(i,"beflg") != "E" &&
						sheetObj.CellValue(i,"ceflg") != "E" &&
						sheetObj.CellValue(i,"deflg") != "E"){
						sheetObj.RowDelete(i,false);
					}
				}				
			break;
         }
         sheetObj.ShowDebugMsg = false;
     }
				
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
      
    function sheet1_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift){
    	var formObj = document.form;
    	var sName = SheetObj.ColSaveName(Col);
    	
     	var celltxt  = SheetObj.EditValue;
       	var celltxt1 = SheetObj.CellValue(Row, "cntr_no");
    }
    
    function setsheetRowColorBlack(cnt){
   	 	 var formObj = document.form;
	   	 for (var i = 1; i <= 25; i++){
	   	    sheetObjects[0].CellFontColor(cnt,i) = sheetObjects[0].RgbColor(0, 0, 0);
	   	 }
    }
    
    function setsheetRowColorRed(cnt){
	   	 var formObj = document.form;
	   	 for (var i = 1; i <= 25; i++){
	   	    sheetObjects[0].CellFontColor(cnt,i) = sheetObjects[0].RgbColor(255, 0, 0);
	   	 }
    }
    
    function isNumber(input) {
        var chars = "0123456789";
        return containsCharsOnly(input,chars);
        //return true;
    } 
    
    /**
     * 입력값이 특정 문자(chars)만으로 되어있는지 체크
     * 특정 문자만 허용하려 할 때 사용
     * ex) if (!containsCharsOnly(form.blood,"ABO")) {
     *         alert("혈액형 필드에는 A,B,O 문자만 사용할 수 있습니다.");
     *     }
     */
    function containsCharsOnly(input,chars) {
        for (var inx = 0; inx < input.length; inx++) {
           if (chars.indexOf(input.charAt(inx)) == -1)
               return false;
        }
        return true;
    }
     
   	/**
   	 * Currency Pop-up Return Value 처리 부분<br>
   	 * @param {arry} returnedValues Pop-up 화면의 Return value array
   	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
   	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
   	 * @param 대상IBSheet의 Sheet Array index
   	 */
  	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
  	    var formObj  = document.form;
  	    var sheetObj = sheetObjects[0];
  	    if ( aryPopupData.length > 0 ) {
  	        ComSetObjValue(formObj.agmt_cty_cd, aryPopupData[0][3]);
  	        ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);
  	    }
  	} 	     
	/* 개발자 작업  끝 */