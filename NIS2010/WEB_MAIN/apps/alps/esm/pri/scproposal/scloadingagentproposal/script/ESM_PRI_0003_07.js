/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003_07.js
*@FileTitle : S/C Proposal Loading Agent Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.01 최성민
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2011.03.30 이행지 [CHM-201109659-01] OTI Bond / Tariff Title page / OTI License Attach / Signing POA 기능 개발(Customer section) 및 Loading Agent POA Attach(L/Agent section) 기능 개발요청
*                                    - POA Attach File 첨부기능 추가
* 2011.04.22 이행지 [선조치] TPE로 클릭되어진 경우만 POA Attach File 첨부기능 활성화 및 저장 Validation 체크
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
     * @class ESM_PRI_0003_07 : ESM_PRI_0003_07 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0003_07() {
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

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var uploadObjects = new Array();
 var uploadCnt = 0;

 var tabLoad = new Array();
 tabLoad[0]= 0;
 tabLoad[1]= 0;
 
 var mnlInpFlg = false; // manual input 가능유무


 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

/**
  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return 없음
  * @author 최성민
  * @version 2009.10.28
  */
 function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

     var sheetObject1 = sheetObjects[0];
     
     var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
        	if (getButtonTable(srcName).disabled) {
        		return false;
        	}
        }
        switch(srcName) {
	
			case "btn_retrieve":
				if(validateForm(sheetObject1,formObject,IBSEARCH)) {
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				} 
				break;

			case "btn_save":
				if(validateForm(sheetObject1,formObject,IBSAVE)) {
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				}
				break;

			case "btn_acceptall":
				if(validateForm(sheetObject1,formObject,MODIFY01)) {
					doActionIBSheet(sheetObject1,formObject,MODIFY01);
				}
				break;

			case "btn_cancelall":
				if(validateForm(sheetObject1,formObject,MODIFY02)) {
					doActionIBSheet(sheetObject1,formObject,MODIFY02);
				}
				break;
			 					
			case "btn_rowadd":
				if(validateForm(sheetObject1,formObject,IBINSERT)) {
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
				}
				break;

			case "btn_delete":
				if(validateForm(sheetObject1,formObject,IBDELETE)) {
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
				}
				break;	
				
			case "btn_amend":
				if(validateForm(sheetObject1,formObject,COMMAND01)) {
					doActionIBSheet(sheetObject1,formObject,COMMAND01);
				}
				break;

			case "btn_amendcancel":
				if(validateForm(sheetObject1,formObject,COMMAND02)) {
					doActionIBSheet(sheetObject1,formObject,COMMAND02);
				}
				break;
				
			case "btn_accept":
				if(validateForm(sheetObject1,formObject,MODIFY03)) {
					doActionIBSheet(sheetObject1,document.form,MODIFY03);
				}
				break;
				
			case "btn_acceptcancel":
				if(validateForm(sheetObject1,formObject,MODIFY04)) {
					doActionIBSheet(sheetObject1,document.form,MODIFY04);
				}
				break;
					

        } // end switch
	}catch(e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

 /**
  * IBSheet Object를 배열로 등록 <br>
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
  * 배열은 소스 상단에 정의 <br>
  * <br><b>Example :</b>
  * <pre>
  *     setSheetObject(sheetObj);
  * </pre>
  * @param {ibsheet} sheet_obj 필수 IBSheet Object
  * @return 없음
  * @author 최성민
  * @version 2009.10.28
  */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }



     /**
      * Sheet 기본 설정 및 초기화 <br>
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage();
      * </pre>
      * @return 없음
      * @author 최성민
      * @version 2009.05.17
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         //UPLOAD 환경 설정
         for(var i=0;i<uploadObjects.length;i++){
 		    //1. 기본 환경 설정
 		    ComConfigUpload(uploadObjects[i], "/hanjin/ESM_PRI_0003_07GS.do");

 	        //각종 확인 메시지의 표시를 표시할지 여부를 설정한다.
	        uploadObjects[i].AutoConfirm = "UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";

 		    //2. Upload 초기화
 		    //initUpload(uploadObjects[i],i+1);
 		 }

         buttonControl();
 		 parent.loadTabPage();
     }

     /**
      * 시트 초기설정값, 헤더 정의 <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
      * <br><b>Example :</b>
      * <pre>
      *     initSheet(sheetObj,1);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
      * @return 없음
      * @author 최성민
      * @version 2009.05.22
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
 		 var sheetID = sheetObj.id;
 		 var formObj = document.form;

         switch(sheetID) {             
             case "sheet1":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 300;
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

                     var HeadTitle = "|Sel.|Seq.|lodg_agn_seq|amdt_seq|Customer Code|Customer Code|Mannual Input|Customer Name|Address|POA Attach|POA Attach|POA Attach|Location|EFF Date|EXP Date|Source|Status" +
                     		"|1|2|3|4|5";
                     var headCount = ComCountHeadTitle(HeadTitle);
                                          
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
 	                 InitDataProperty(0, cnt++ , dtDummyCheck, 		40,    	daCenter,  	false,	"chk");
 	                 InitDataProperty(0, cnt++ , dtDataSeq,   		40,    	daCenter,  	false, 	"seq");
 	                 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "lodg_agn_seq");
 	                 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "amdt_seq");
                     
 	                 InitDataProperty(0, cnt++ , dtData,     		40,    	daCenter,  	false,	"cust_cnt_cd",   	false,	"",      dfNone, 			0,     true,       true,	2);
                     InitDataProperty(0, cnt++ , dtPopupEdit,  	 	80,    	daCenter,  	false,  "cust_seq",   		false,	"",      dfNone, 			0,     true,       true,	6);
 					 InitDataProperty(0, cnt++ , dtCheckBox,    	105,   	daCenter,  	false,  "mnl_inp_flg",    	false,	"",      dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,      	 	285,   	daLeft,   	false,  "cust_nm",    		false,	"",      dfNone, 			0,     false,      false);
                     InitDataProperty(0, cnt++ , dtData,      	 	200,   	daLeft,   	false,  "cust_addr",   		false,	"",      dfNone, 			0,     false,      false);
                     InitDataProperty(0, cnt++ , dtPopupEdit,       100,    daRight,    false,  "poa_atch_file_nm",     false, 	"",      dfNone,			0,     false,      true,	32);
                     InitDataProperty(0, cnt++ , dtHidden,          100,    daRight,    false,  "poa_atch_file_id", false, 	"",      dfNone,			0,     false,      true);
                     InitDataProperty(0, cnt++ , dtImage,        	20,     daCenter,   false,  "poa_atch_file_del",         false, 	"",      dfNone,			0,     true,       false);
                     
                     InitDataProperty(0, cnt++ , dtData,      	 	100,   	daCenter,  	false,  "cust_loc_cd",     	false,	"",      dfNone, 			0,     false,      false,	5);
                     InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,  	false,  "eff_dt", 			false,	"",      dfDateYmd, 		0,     false,      false);
                     InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,  	false,  "exp_dt",      	 	false,	"",      dfDateYmd, 		0,     false,      false);
                     InitDataProperty(0, cnt++ , dtCombo,      	 	80,    	daCenter,  	false,  "src_info_cd",   	false,	"",      dfNone, 			0,     false,      false);
                     InitDataProperty(0, cnt++ , dtCombo,      	 	80,    	daCenter,  	false,  "prc_prog_sts_cd", 	false,	"",      dfNone, 			0,     false,      false);                     
                     
                     InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "svc_scp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "prop_no");		                 
	                 InitDataProperty(0, cnt++ , dtHidden, 			80, 	daCenter, 	false, 	"src_info_dtl");
					 InitDataProperty(0, cnt++ , dtHidden, 			80, 	daCenter, 	false, 	"prc_prog_sts_dtl");
					 InitDataProperty(0, cnt++ , dtHidden, 			80, 	daCenter, 	false, 	"n1st_cmnc_amdt_seq");

					 InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue, "", "NW");            
					 InitDataCombo(0, "prc_prog_sts_cd", prcProgStsCdComboText, prcProgStsCdComboValue, "", "I");
		                
	                 InitDataValid(0,  "cust_cnt_cd",	vtEngUpOnly);		// 영문대문자만 입력
	                 InitDataValid(0,  "cust_seq",		vtNumericOnly);		// 숫자만 입력
	                 
	                 //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
		 			 InitDataValid(0, "cust_loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

		 			 ImageList(0)= "/hanjin/img/nolines_minus.gif";
		 			 ImageList(1)= "/hanjin/img/ico_attach.gif";
		 			 PopupButtonImage(0, "poa_atch_file_nm") = 1;
		 			 
		 			 ToolTipOption="balloon:true;width:500;icon:1;";
		 			 
 					 ShowButtonImage = 2; 
 					 AutoRowHeight = false;
 					 Ellipsis = true;
                     WaitImageVisible = false;
                }
                break
         }
     }

     /**
      * Sheet관련 프로세스 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 html form object
      * @param {int} sAction 필수 프로세스 플래그 상수
      * @return 없음
      * @author 최성민
      * @version 2009.05.22
      */
      function doActionIBSheet(sheetObj,formObj,sAction) {
    	  try {
	          sheetObj.ShowDebugMsg = false;
	          switch(sAction) {
	 	        case IBSEARCH: // 조회	
	  				ComOpenWait(true);
	 	         	formObj.f_cmd.value = SEARCH;
	 				sheetObj.DoSearch("ESM_PRI_0003_07GS.do", FormQueryString(formObj)); 
	 				break;
	
	  			case IBSAVE:        //저장	 			
		  			if(ComShowCodeConfirm("PRI00001")) {
		  				ComOpenWait(true);
			  			formObj.f_cmd.value = MULTI01;
						var sParam = FormQueryString(formObj);
		  				var sParamSheet = sheetObj.GetSaveString();
		  				
		  				if (sParamSheet != "") {
		  					sParam = ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
		  				}
		  				
		  				var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_07GS.do", sParam); 
		  				sheetObj.LoadSaveXml(sXml);
		  			}
	 				break;
	
	  			case IBINSERT:       // Row Add
	 				
	  				var prop_no      = formObj.prop_no.value;
					var amdt_seq     = formObj.amdt_seq.value; 
					var svc_scp_cd   = formObj.svc_scp_cd.value;
					var eff_dt 		 = formObj.eff_dt.value;
					var exp_dt 		 = formObj.exp_dt.value;
	 			
					if(amdt_seq == 0){
						var idx = sheetObj.DataInsert();										
						sheetObj.CellValue2(idx, "prop_no") = prop_no;
						sheetObj.CellValue2(idx, "svc_scp_cd") = svc_scp_cd;
						sheetObj.CellValue2(idx, "amdt_seq") = amdt_seq;	
						sheetObj.CellValue2(idx, "eff_dt") = eff_dt;
						sheetObj.CellValue2(idx, "exp_dt") = exp_dt;
						sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
						sheetObj.CellValue2(idx, "lodg_agn_seq") = parseInt(ComPriGetMax(sheetObj, "lodg_agn_seq"))+ 1;										
						sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
						sheetObj.CellValue2(idx, "src_info_cd") = "NW";
						sheetObj.SelectCell(idx, "cust_cnt_cd");						
					}else{
						
						// insert Amend 중 Amend pair 사이에 끼어들게 되는 경우를 제외							
						if(sheetObj.SearchRows!=0 && sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!= amdt_seq ){	
							ComShowCodeMessage("PRI01002");		
						 	return;
						}							
						
						var idx = sheetObj.DataInsert();	   // 신규 row			
						sheetObj.CellValue2(idx, "prop_no") = prop_no;
						sheetObj.CellValue2(idx, "svc_scp_cd") = svc_scp_cd;
						sheetObj.CellValue2(idx, "amdt_seq") = amdt_seq;
						sheetObj.CellValue2(idx, "eff_dt") = eff_dt;
						sheetObj.CellValue2(idx, "exp_dt") = exp_dt;
						sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
						sheetObj.CellValue2(idx, "lodg_agn_seq") = parseInt(ComPriGetMax(sheetObj, "lodg_agn_seq"))+ 1;										
						sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
						sheetObj.CellValue2(idx, "src_info_cd") = "NW";
						sheetObj.SelectCell(idx, "cust_cnt_cd");
						sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
						//sheetObj.CellBackColor(idx,"cust_addr") = sheetObj.RgbColor(255,255,255);
					}
	
	    			//하이라이트처리
					changeSelectBackColor(sheetObj, sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
					
	 				break;
	 				
	  			case IBDELETE: // Delete
	 				var eff_dt = formObj.eff_dt.value;
	 				var amdt_seq = formObj.amdt_seq.value;
	
	 				// 선택된 ROW 리스트/////////////////////////////////
					var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length == 0){
						sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
					}	
					chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
									
					for(var i=0;i < chkArr.length;i++){
						if(sheetObj.CellValue(chkArr[i],"amdt_seq")!=amdt_seq
								||(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq
										&& (sheetObj.CellValue(chkArr[i],"src_info_cd")=="AM" || sheetObj.CellValue(chkArr[i],"src_info_cd")=="AD" || sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="I"))){
							ComShowCodeMessage("PRI01002");
							return;
						}
					}
					var sRow = 0;
					for(var j=0;j < chkArr.length;j++){
						if(sheetObj.CellValue(Number(chkArr[j])+sRow,"n1st_cmnc_amdt_seq")!= amdt_seq){
							//9.30 추가 - AMEND시 TAW/TAE/ASE/ASW이외의 SCOPE이 추가됬을 경우 해당ROW AMEND DELETE불가
							if(mnlInpFlg && sheetObj.CellValue(Number(chkArr[j])+sRow, "mnl_inp_flg") == "1") {
								sheetObj.CellValue2(Number(chkArr[j])+sRow,"chk")=0;
	 							ComShowCodeMessage("PRI01002");
	 							return false;
	 						}
							comSheetAmendRow(sheetObj,formObj,Number(chkArr[j])+sRow,"D","cust_cnt_cd|cust_seq|mnl_inp_flg|cust_nm|cust_loc_cd");	
							sRow++;								
						}
					}
					
					deleteRowCheck(sheetObj, "chk");
					fileColumnControl(sheetObj);
					break;
					
	  			case MODIFY01: // Accept All
		  			if(ComShowCodeConfirm("PRI01015")) {
		  				formObj.f_cmd.value = MULTI02;
		  				comSheetAcceptCheckedRows(sheetObj,document.form,"ESM_PRI_0003_07GS.do",true);
		  				parent.comUpdateProposalStatusSummary("15", formObj.svc_scp_cd.value);
					}
	 				break;
	 				
	  			case MODIFY02: // Cancel 
		  			if(ComShowCodeConfirm("PRI01010")) {
		  				formObj.f_cmd.value = MULTI03;
		  				comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0003_07GS.do", true);
		  				parent.comUpdateProposalStatusSummary("15", formObj.svc_scp_cd.value);
					}
	 				break;		
	 		
	 				
	  	      	case MODIFY03: // Accept
		  	      	if(ComShowCodeConfirm("PRI00008")) {
		  				formObj.f_cmd.value = MULTI04;
		  				comSheetAcceptCheckedRows(sheetObjects[0],document.form,"ESM_PRI_0003_07GS.do",false);
		  				parent.comUpdateProposalStatusSummary("15", formObj.svc_scp_cd.value);
		  	      	}
	  				break;
	  				
	  	      	case MODIFY04: // Accept Cancel
		  	      	if(ComShowCodeConfirm("PRI00009")) {
		 				formObj.f_cmd.value = MULTI05;
		  	      		comSheetAcceptCancelCheckedRows(sheetObjects[0],document.form,"ESM_PRI_0003_07GS.do",false);
		  	      		parent.comUpdateProposalStatusSummary("15", formObj.svc_scp_cd.value);
		  	      	}
	 				break;			
	  				
	 			case COMMAND01: // Amend
	 				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
	 				if(chkArr.length > 0){
	 					if(chkArr.length > 1){					
	 						ComShowCodeMessage("PRI00310");
	 					}else{
	 						//9.30 추가 - AMEND시 TAW/TAE/ASE/ASW이외의 SCOPE이 추가됬을 경우 해당ROW AMEND 불가
	 						if(mnlInpFlg && sheetObj.CellValue(sheetObj.SelectRow, "mnl_inp_flg") == "1") {
	 							ComShowCodeMessage("PRI01002");
	 							return false;
	 						} 						
	 						comSheetAmendRow(sheetObjects[0],document.form,sheetObjects[0].SelectRow,"M", "cust_cnt_cd|cust_seq|mnl_inp_flg|poa_atch_file_del");
		 					sheetObjects[0].CellBackColor(sheetObjects[0].SelectRow,"cust_addr") = sheetObj.RgbColor(255,255,255);
		 					sheetObjects[0].CellBackColor(sheetObjects[0].SelectRow,"cust_nm") = sheetObj.RgbColor(255,255,255);
	 					}
	 				}else{ 
	 					//9.30 추가 - AMEND시 TAW/TAE/ASE/ASW이외의 SCOPE이 추가됬을 경우 해당ROW AMEND 불가
	 					if(mnlInpFlg && sheetObj.CellValue(sheetObj.SelectRow, "mnl_inp_flg") == "1") {
	 						ComShowCodeMessage("PRI01002");
							return false;
						} 					
	 					comSheetAmendRow(sheetObjects[0],document.form,sheetObjects[0].SelectRow,"M", "cust_cnt_cd|cust_seq|mnl_inp_flg|poa_atch_file_del");
	 					sheetObjects[0].CellBackColor(sheetObjects[0].SelectRow,"cust_addr") = sheetObj.RgbColor(255,255,255);
	 					sheetObjects[0].CellBackColor(sheetObjects[0].SelectRow,"cust_nm") = sheetObj.RgbColor(255,255,255);
					}
					sheetObj.SelectCell(sheetObj.SelectRow, "cust_cnt_cd");
					fileColumnControl(sheetObj);
	 			
	 				break;		
	 			
	 			case COMMAND02: // Amend Cancel
	 				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
	 				if(chkArr.length > 0){
	 					if(chkArr.length > 1){					
	 						ComShowCodeMessage("PRI00310");
	 					}else{
	 						//9.30 추가 - AMEND시 TAW/TAE/ASE/ASW이외의 SCOPE이 추가됬을 경우 해당ROW AMEND CANCEL불가
	 						if(mnlInpFlg && sheetObj.CellValue(sheetObj.SelectRow, "mnl_inp_flg") == "1") {
	 							ComShowCodeMessage("PRI01002");
	 							return false;
	 						}
	 						comSheetAmendCancelRow(sheetObjects[0],document.form,sheetObjects[0].SelectRow,"M", "cust_cnt_cd|cust_seq|mnl_inp_flg|cust_nm|cust_loc_cd");
	 						sheetObj.CellEditable(sheetObj.SelectRow,"cust_cnt_cd") = false;
	 						sheetObj.CellEditable(sheetObj.SelectRow,"cust_seq") = false;
	 						sheetObj.CellEditable(sheetObj.SelectRow,"mnl_inp_flg") = false;
	 						sheetObj.CellEditable(sheetObj.SelectRow,"cust_loc_cd") = false;
	 						//sheetObj.CellEditable(sheetObj.SelectRow,"cust_nm") = false;
	 					
	 					}
	 				}else{ 
	 					//9.30 추가 - AMEND시 TAW/TAE/ASE/ASW이외의 SCOPE이 추가됬을 경우 해당ROW AMEND CANCEL불가
	 					if(mnlInpFlg && sheetObj.CellValue(sheetObj.SelectRow, "mnl_inp_flg") == "1") {
							ComShowCodeMessage("PRI01002");
							return false;
						}
	 					comSheetAmendCancelRow(sheetObjects[0],document.form,sheetObjects[0].SelectRow,"M", "cust_cnt_cd|cust_seq|mnl_inp_flg|cust_nm|cust_loc_cd");
	 					sheetObj.CellEditable(sheetObj.SelectRow,"cust_cnt_cd") = false;
						sheetObj.CellEditable(sheetObj.SelectRow,"cust_seq") = false;
						sheetObj.CellEditable(sheetObj.SelectRow,"mnl_inp_flg") = false;
						sheetObj.CellEditable(sheetObj.SelectRow,"cust_loc_cd") = false;
						//sheetObj.CellEditable(sheetObj.SelectRow,"cust_nm") = false;
	 				}
	 				break;
	  			
	          }
    	  }catch(e){
    			if (e == "[object Error]") {
    				ComShowMessage(OBJECT_ERROR);
    			} else {
    				ComShowMessage(e);
    			}
    		}finally {
    			 ComOpenWait(false);
    		}
      }

      /**
     	* IBTab Object를 배열로 등록 <br>
     	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     	* 배열은 소스 상단에 정의 <br>
     	* <br><b>Example :</b>
     	* <pre>
     	*     setTabObject(tab_obj);
     	* </pre>
     	* @param {ibtab} tab_obj 필수 IBTab Object
     	* @return 없음
     	* @author 최성민
     	* @version 2009.10.28
     	*/
      function setTabObject(tab_obj){
          tabObjects[tabCnt++] = tab_obj;

      }

       /**
        * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
        * <br><b>Example :</b>
        * <pre>
        *     if (validateForm(sheetObj,document.form,IBSAVE)) {
        *         로직처리;
        *     }
        * </pre>
        * @param {ibsheet} sheetObj 필수 IBSheet Object
        * @param {form} formObj 필수 html form object
        * @param {int} sAction 필수 프로세스 플래그 상수
        * @returns bool <br>
        *          true  : 폼입력값이 유효할 경우<br>
        *          false : 폼입력값이 유효하지 않을 경우
        * @author 최성민
        * @version 2009.04.17
        */
       function validateForm(sheetObj,formObj,sAction){
    		switch (sAction) {
	   		case IBSEARCH: // 조회		
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
	   			break;
	   	
	   		case IBSAVE: // 저장
	   			
				if (!sheetObjects[0].IsDataModified) {
					ComShowCodeMessage("PRI00301");
					return false;
				}
					
				
	 	  		if (sheetObjects[0].IsDataModified && sheetObjects[0].GetSaveString() == "") {
	 				return false;
	 			}
	   		
	   			
	   			//////////////////////////////////////////////////////////////////////////////
	   			//필수체크
	   			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
	   				
	   				//이전 SEQ는 체크하지 않는다.
	   				if(sheetObj.CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
	   					continue;
	   				}
	   				
	   				//Amend Delete 때는 모든 항목에 대해서  필수체크를 하지 않는다.
	   				if(sheetObj.CellValue(i, "src_info_cd") == "AD") {
	   					continue;
	   				}
	   				
	   				if(sheetObj.CellValue(i, "mnl_inp_flg") == "1") {
	   					if(sheetObj.CellValue(i, "cust_nm") == "") {
	   						ComShowCodeMessage("PRI08010", i, "Customer Name");
	   						sheetObj.SelectCell(i, "cust_nm");
	   						return false;
	   					}
	   				} else {
	   					if(sheetObj.CellValue(i, "cust_cnt_cd") == "") {
	   						ComShowCodeMessage("PRI08010", i, "Customer Code");
	   						sheetObj.SelectCell(i, "cust_cnt_cd");
	   						return false;
	   					} else if(sheetObj.CellValue(i, "cust_seq") == "") {
	   						ComShowCodeMessage("PRI08010", i, "Customer Code");
	   						sheetObj.SelectCell(i, "cust_seq");
	   						return false;
	   					} else if(sheetObj.CellValue(i, "cust_nm") == "") {
	   						ComShowCodeMessage("PRI08010", i, "Customer Name");
	   						sheetObj.SelectCell(i, "cust_nm");
	   						return false;
	   					}
	   				}
	   				// EFF Date 체크는 추후 삭제가능함 -- 임시적으로 사용
	   				var svc_scp_cd = document.form.svc_scp_cd.value;
	   				if(sheetObj.CellEditable(i, "cust_cnt_cd") && sheetObj.CellValue(i, "eff_dt") >= "20110501" && svc_scp_cd == "TPE"){
	   					if (sheetObj.CellValue(i, "poa_atch_file_id") == ""){
		   					ComShowCodeMessage("PRI00316", "POA Attach");
	   						sheetObj.SelectCell(i, "poa_atch_file_id");
	   						return false;
		   				}
	   				}
	   			}
	   		
	   		
	
				if (sheetObjects[0].IsDataModified ) {
					
					var dupRow = ComPriAmendDupCheck(sheetObjects[0], "cust_cnt_cd|cust_seq|cust_nm", formObj.amdt_seq.value);
	
					if (dupRow >= 0) {
						sheetObjects[0].SelectRow = dupRow;
			             ComShowCodeMessage("PRI00302");
			             return false;
					}
				}				
	   			break;
	   			
	   		case IBINSERT: // Row Add
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
	   			break;
	   			
	   		  			
	   		case IBDELETE: // Delete  	
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
	   			break;
	   			
	   		case MODIFY01: // Accept All
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
				if (getValidRowCount(sheetObj) <= 0) {
		            return false;
				}
	 			break;
	 			
	   		case MODIFY02: // Cancel
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
				if (getValidRowCount(sheetObj) <= 0) {
		            return false;
				}
	 			break;	
	 			
	 			
			case MODIFY03: // Accept
			
				// 선택된 ROW 리스트/////////////////////////////////
				var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
				if(chkArr.length == 0){
					if(formObj.amdt_seq.value != sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) {
						ComShowCodeMessage("PRI00313");
						return false;
					}
					sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
				}	
				chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
			
				for(var i=0;i < chkArr.length;i++){
					if(formObj.amdt_seq.value != sheetObj.CellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
						ComShowCodeMessage("PRI00313");
						return false;
					}
				
					if(sheetObj.CellValue(chkArr[i], "prc_prog_sts_cd") == "A") {
						ComShowCodeMessage("PRI01037");
						return false;
					}
				}
				break;
				
			case MODIFY04: // Accept cancel
				// 선택된 ROW 리스트/////////////////////////////////
				var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
				if(chkArr.length == 0){
					if(formObj.amdt_seq.value != sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) {
						ComShowCodeMessage("PRI00313");
						return false;
					}
					sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
				}	
				chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
			
				for(var i=0;i < chkArr.length;i++){
					if(formObj.amdt_seq.value != sheetObj.CellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
						ComShowCodeMessage("PRI00313");
						return false;
					}
			
					if(sheetObj.CellValue(chkArr[i], "prc_prog_sts_cd") == "I") {
						ComShowCodeMessage("PRI01038");
						return false;
					}
				}
				break;	
		
	 			
	   		case COMMAND01: // Amend	
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
		  		
	 			break;
	 			
	   		case COMMAND02: // Amend Cancel	
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
		  		
	 			break;
	  
	   		}     
    		
    		return true;
       }

        /**
         * OnSelectCell 이벤트 발생시 호출되는 function <br>
         * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
         * <br><b>Example :</b>
         * <pre>
         * 
         * </pre>
         * @param {ibsheet} sheetObj 필수, IBSheet Object
         * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
         * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
         * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
         * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
         * @return 없음
         * @author 문동규
         * @version 2009.04.17
         */         
        function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
            if (OldRow != NewRow) {
                changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
            }
        } 

          /**
           * OnChange 이벤트 발생시 호출되는 function <br>
           * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
           * <br><b>Example :</b>
           * <pre>
           *
           * </pre>
           * @param {ibsheet} sheetObj 필수 IBSheet Object
           * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
           * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
           * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
           * @return 없음
           * @author 최성민
           * @version 2009.04.17
           */  	
   		  function sheet1_OnChange(sheetObj, Row, Col, Value){
             	var colname = sheetObj.ColSaveName(Col);  
             	var formObj = document.form
             	switch(colname)
             	{
             	
	             	case "cust_cnt_cd":
	             		if (Value.length != 2){
	             			ComShowCodeMessage("PRI00315");
	             			sheetObj.SelectCell(Row, "cust_cnt_cd");
	             		} else {
	             			sheetObj.CellValue2(Row,"cust_seq") = "";
	             		}
	     	    		break;
	     	    		
         	    	case "cust_seq":
         	    		
         	    		if (Value.length > 0 && sheetObj.Cellvalue(Row,"cust_cnt_cd").length == 2){

         	    			formObj.f_cmd.value = SEARCH01;
         	    			formObj.cust_cnt_cd.value=sheetObj.Cellvalue(Row,"cust_cnt_cd");  
         	    			formObj.cust_seq.value=sheetObj.Cellvalue(Row,"cust_seq");         	    			
	       	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_4014GS.do", FormQueryString(formObj)+"&nmd_cust_flg=N");	  			
	       	  				var arrData = ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd");
	       	  	
         					if (arrData != null){
         						sheetObj.CellValue2(Row,"cust_nm") = arrData[0][0];
         						sheetObj.CellValue2(Row,"cust_addr") = arrData[0][1];
         						sheetObj.CellValue2(Row,"cust_loc_cd") = arrData[0][2];
         						
         						//CUST_SEQ 앞에 '0'문자로 채움
                 	    		if (Value.length < 6 && Value.length != 0){	 	    		
                	 	    		sheetObj.CellValue2(Row,"cust_seq") = ComLpad(Value, 6, "0");
                	 	    	}
                 	    		
         					}else{
         						ComShowCodeMessage("PRI00315");
         						locationCellClear(sheetObj,Row);
         					}
         					
         					//customer Code 가 존재하면 customer name, address, location 은 변경불가
             	    		//sheetObj.CellEditable(Row,"cust_nm") = false;
            	   	  		sheetObj.CellEditable(Row,"cust_loc_cd") = false;
            	   	  		             	    		
         	    		} else {
         	    			ComShowCodeMessage("PRI00315");
         	    			locationCellClear(sheetObj,Row);
         	    			
         	    			//sheetObj.CellEditable(Row,"cust_nm") = false;
            	   	  		sheetObj.CellEditable(Row,"cust_loc_cd") = true;           	   	  		
         	    		}
         	    		
         	    		break;
        	    	
         	    	case "mnl_inp_flg": 	    	
         	    		if (sheetObj.CellValue(Row,Col) == 1 ){
         	    			mnuInput(false,Row);
         	    		}else{   		
         	    			mnuInput(true,Row);
         	    		}
         	    		locationCellClear(sheetObj,Row)
         	    		break;
        	    	
         	    	case "cust_loc_cd":
         	    		if (Value.length==5){
         	    			formObj.f_cmd.value = SEARCH05;
         	    			formObj.cd.value=sheetObj.Cellvalue(Row,Col);       	    			
	       	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));	  			
	       	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	       	  	
         					if (arrData == null){
         						//ComShowCodeMessage("PRI00315");
         						sheetObj.CellValue2(Row,"cust_loc_cd")= "";
         					}	  				
         	    		} else {
         	    			//ComShowCodeMessage("PRI00315");
         	    			sheetObj.CellValue2(Row,"cust_loc_cd")= "";
         	    		}
         	    		break;        
             	}
             }

       	
   	    /**
   	     * sheet의 특정 cell의 값을 빈칸으로 초기화하는 function <br>
   	     * <br><b>Example :</b>
   	     * <pre>
   	     * 		locationCellClear(sheetObj,Row)
   	     * </pre>
   	     * @param {ibsheet} sheetObj 필수 IBSheet Object
   	     * @param {int} Row 필수 값을 초기화할 해당 셀의 Row Index  
   	     * @return 없음
   	     * @author 최성민
   	     * @version 2009.04.17
   	     */  
   	  	
   	  	function locationCellClear(sheetObj,Row){
   	    	var check = sheetObj.CellValue(Row,"mnl_inp_flg");
   	    	
   	    	if(check ==1) {
	   	  		sheetObj.CellEditable(Row,"cust_seq") = false;
	   	  		sheetObj.CellEditable(Row,"cust_cnt_cd") = false;

	   	  		sheetObj.CellBackColor(Row,"cust_addr") = sheetObj.RgbColor(255,255,255);
	   	  		sheetObj.CellBackColor(Row,"cust_nm") = sheetObj.RgbColor(255,255,255);
	   	 
   	  		} else {
	   	  		sheetObj.CellEditable(Row,"cust_seq") = true;
	   	  		sheetObj.CellEditable(Row,"cust_cnt_cd") = true;

	   	  		sheetObj.CellBackColor(Row,"cust_addr") = -1;
	   	  		sheetObj.CellBackColor(Row,"cust_nm") = -1;
   	  		}
   	    	
    
    		sheetObj.CellValue2(Row,"cust_seq")= ""; 		
   	  		sheetObj.CellValue2(Row,"cust_cnt_cd")= "";
   	  		sheetObj.CellValue2(Row,"cust_nm")= "";
   	  		sheetObj.CellValue2(Row,"cust_addr")= "";
   	  		sheetObj.CellValue2(Row,"cust_loc_cd")= "";
   	  		sheetObj.SelectCell(Row, "cust_cnt_cd");
   	  	}   

       	
   	    /**
   	     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
   	     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
   	     * <br><b>Example :</b>
   	     * <pre>
   	     * 
   	     * </pre>
   	     * @param {ibsheet} sheetObj 필수 IBSheet Object
   	     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
   	     * @return 없음
   	     * @author 최성민
   	     * @version 2009.04.17
   	     */ 		
   	   	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
   	    	var formObj = document.form;   				
			//Main 의 Amendment Summary 관련 function
			parent.comUpdateProposalStatusSummary("15", formObj.svc_scp_cd.value);
   		} 
   	   	
   	    /**
  	    * OnPopupClick 이벤트 발생시 호출되는 function <br>
  	    * Location PopUp을 호출한다. <br>
  	    * <br><b>Example :</b>
  	    * <pre>
  	    *
  	    * </pre>
  	    * @param {ibsheet} sheetObj 필수 IBSheet Object
  	    * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
  	    * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
  	    * @return 없음
  	    * @author 최성민
  	    * @version 2009.04.17
  	    */  	      	 
 	 	function sheet1_OnPopupClick(sheetObj, Row, Col)
 	 	{
 	 		var colName = sheetObj.ColSaveName(Col);
 	 		var formObj = document.form;
 	 		
 	       	switch(colName)
 	       	{
 	   	    	case "cust_seq":		
 	 	  	  		var sUrl = "/hanjin/ESM_PRI_4014.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+sheetObj.CellValue(Row, "cust_cnt_cd")+"&cust_seq="+sheetObj.CellValue(Row, "cust_seq");
 	 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4014", 640, 460, true);
 	 	  			
 	 	  			if (rtnVal != null){
 	 	  				sheetObj.CellValue2(Row, "cust_cnt_cd") = rtnVal.custCntCd;
 	 	  				sheetObj.CellValue2(Row, "cust_seq") = ComLpad(rtnVal.custSeq, 6, "0");
 	 	  				sheetObj.CellValue2(Row, "cust_nm") = rtnVal.custNm;
 	 	  				sheetObj.CellValue2(Row, "cust_addr") = rtnVal.Addr;
 	 	  				sheetObj.CellValue2(Row, "cust_loc_cd") = rtnVal.LocCd;
 	 	  			}
 	   	    		break;

 		    	case "poa_atch_file_nm":
 		    		doFileUpload(sheetObj, Row, Col, "poa_atch_file_");
 		    		break;
 	       	}
 	 	} 

  	   /**
   	    * OnClick 이벤트 발생시 호출되는 function <br>
   	    * 멀티라인일 경우에 ComShowMemoPad()을 호출한다. <br>
   	    * <br><b>Example :</b>
   	    * <pre>
   	    *	
   	    * </pre>
   	    * @param {ibsheet} sheetObj 필수 IBSheet Object
   	    * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
   	    * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
   	    * @return 없음
   	    * @author 최성민
   	    * @version 2009.04.17
   	    */  
   	    function sheet1_OnClick(sheetObj, Row, Col, Value) {
   		    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
   		    var colname = sheetObj.ColSaveName(Col);  	 
   		    var amdtSeq = document.form.amdt_seq.value;
   		    var sts = document.form.prop_sts_cd.value;
   		    var readOnly = false;

   	     	switch(colname)
   	     	{
   	 	    	case "cust_addr":
	 	    		if (amdtSeq == 0){
	 	    			if (sheetObj.CellValue(Row, "mnl_inp_flg") == 1 && !sheetObj.ColHidden("mnl_inp_flg")){
							readOnly = false;
							sheetObj.CellBackColor(Row,"cust_addr") = sheetObj.RgbColor(255,255,255);
	 	    			}else{
	 	    				readOnly = true;
	 	    				sheetObj.CellBackColor(Row,"cust_addr") = -1;
	 	    			}
	 	    		} else if(amdtSeq > 0 && sheetObj.CellValue(Row, "n1st_cmnc_amdt_seq") == amdtSeq ){
	 					if (sheetObj.CellValue(Row , "src_info_cd") == "AM"){	
							readOnly = false;
							sheetObj.CellBackColor(Row,"cust_addr") = sheetObj.RgbColor(255,255,255);
	 					} else if (sheetObj.CellValue(Row , "src_info_cd") == "AD"){
	 						readOnly = true;
	 						sheetObj.CellBackColor(Row,"cust_addr") = -1;
	 					} else {
	 						if (sheetObj.CellValue(Row, "mnl_inp_flg") == 1 && !sheetObj.ColHidden("mnl_inp_flg")){
 								readOnly = false;
 								sheetObj.CellBackColor(Row,"cust_addr") = sheetObj.RgbColor(255,255,255);
	 						}else{
 								readOnly = true;
 								sheetObj.CellBackColor(Row,"cust_addr") = -1;
	 						} 
	 					}
	 				} else {
	 					readOnly = true;
	 					sheetObj.CellBackColor(Row,"cust_addr") = -1;
	 				}
	 	    			 	    		
	 	    		if (sts != "I" || sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") != "I"){
   	 	    			readOnly = true;
						sheetObj.CellBackColor(Row,"cust_addr") = -1;
   	 	    		}
	 	    		
	 	    		ComShowMemoPad(sheetObj, Row, Col, readOnly, 200);
	 	    		break;
	 	    		
	 	    		
   	 	    	case "cust_nm":
	 	    		if (amdtSeq == 0){
	 	    			if (sheetObj.CellValue(Row, "mnl_inp_flg") == 1 && !sheetObj.ColHidden("mnl_inp_flg")){
							readOnly = false;
							sheetObj.CellBackColor(Row,"cust_nm") = sheetObj.RgbColor(255,255,255);
	 	    			}else{
	 	    				readOnly = true;
	 	    				sheetObj.CellBackColor(Row,"cust_nm") = -1;
	 	    			}
	 	    		} else if(amdtSeq > 0 && sheetObj.CellValue(Row, "n1st_cmnc_amdt_seq") == amdtSeq ){
	 					if (sheetObj.CellValue(Row , "src_info_cd") == "AM"){	
							readOnly = false;
							sheetObj.CellBackColor(Row,"cust_nm") = sheetObj.RgbColor(255,255,255);
	 					} else if (sheetObj.CellValue(Row , "src_info_cd") == "AD"){
	 						readOnly = true;
	 						sheetObj.CellBackColor(Row,"cust_nm") = -1;
	 					} else {
	 						if (sheetObj.CellValue(Row, "mnl_inp_flg") == 1 && !sheetObj.ColHidden("mnl_inp_flg")){
 								readOnly = false;
 								sheetObj.CellBackColor(Row,"cust_nm") = sheetObj.RgbColor(255,255,255);
	 						}else{
 								readOnly = true;
 								sheetObj.CellBackColor(Row,"cust_nm") = -1;
	 						} 
	 					}
	 				} else {
	 					readOnly = true;
	 					sheetObj.CellBackColor(Row,"cust_nm") = -1;
	 				}
	 	    			 	    		
	 	    		if (sts != "I" || sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") != "I"){
   	 	    			readOnly = true;
						sheetObj.CellBackColor(Row,"cust_nm") = -1;
   	 	    		}
	 	    		
	 	    		ComShowMemoPad(sheetObj, Row, Col, readOnly, 285);
	 	    		break;
   	 	    	case "poa_atch_file_del":
   	 	    		fileColumnEvent(sheetObj, Row, "OnClick", "poa_atch_file_");
   	 	    		break;
   	     	}
   	    }

	 	/**
	     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
	     * 화면이 보여지며 조회를 한다.<br>
	     * <br><b>Example :</b>
	     * <pre>
	     * tabLoadSheet("ACE", "1")
	     * </pre>
	     * @param {string} sPropNo 필수 prop_no 값
	     * @param {string} sAmdtSeq 필수 amdt_seq 값
	     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
	     * @param {string} sPreAmdtSeq 필수 pre_amdt_seq 값
	     * @param {string} sPropStsCd 필수 pro_sts_cd 값
	     * @param {string} sEffDt 필수 eff_dt 값
	     * @param {string} sExpDt 필수 exp_dt 값
	     * @param {string} sPreExpDt 필수 pre_exp_dt 값
	     * @return 없음
	     * @author 최성민
	     * @version 2009.05.21
	     */ 
  		function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg) {
  			var formObject = document.form;
  			if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd || formObject.pre_amdt_seq.value != sPreAmdtSeq ||
  				formObject.prop_sts_cd.value != sPropStsCd || formObject.eff_dt.value != sEffDt || formObject.pre_exp_dt.value != sPreExpDt || formObject.exp_dt.value != sExpDt) {
  				formObject.prop_no.value = sPropNo;
  				formObject.amdt_seq.value = sAmdtSeq;
  				formObject.svc_scp_cd.value = sSvcScpCd;
  				formObject.pre_amdt_seq.value = sPreAmdtSeq;
  				formObject.prop_sts_cd.value = sPropStsCd; 
  				formObject.eff_dt.value = sEffDt;
  				formObject.exp_dt.value = sExpDt;			
  				formObject.pre_exp_dt.value = sPreExpDt ;
  				formObject.req_usr_flg.value = sIsReqUsr ;
  				formObject.apro_usr_flg.value = sIsAproUsr ;	
  	 			formObject.lgcy_if_flg .value = sLgcyIfFlg ;
	 			formObject.dur_dup_flg.value = "Y" ;

  				buttonControl();
  				
  				//MnlInpFlg컬럼 disable 처리
  				initCheckMnlInpFlg(sheetObjects[0], formObject);
  				doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
  				
  				if(sSvcScpCd != "TPE"){
  					sheetObjects[0].ColHidden("poa_atch_file_nm")  = true;
  					sheetObjects[0].ColHidden("poa_atch_file_del") = true;
  				} else {
  					sheetObjects[0].ColHidden("poa_atch_file_nm")  = false; 
  					sheetObjects[0].ColHidden("poa_atch_file_del") = false; 					
  				}
  			}
  		}
	     
 		/**
	     * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
	     * <br><b>Example :</b>
	     * <pre>
	     * tabClearSheet()
	     * </pre>
	     * @param 없음
	     * @return 없음
	     * @author 최성민
	     * @version 2009.05.20
	     */ 
  		function tabClearSheet() {
  			var formObject = document.form;

 			formObject.prop_no.value = "";
			formObject.amdt_seq.value = "";
			formObject.svc_scp_cd.value = "";
			formObject.pre_amdt_seq.value = "";
			formObject.prop_sts_cd.value = "";
			formObject.eff_dt.value = "";
			formObject.exp_dt.value = "";
			formObject.pre_exp_dt.value = "";
			formObject.req_usr_flg.value = "";
			formObject.apro_usr_flg.value = "";
 			formObject.lgcy_if_flg .value = "";
 			formObject.dur_dup_flg.value = "";
  			
  			sheetObjects[0].RemoveAll();
 			buttonControl("CLEAR");
  		}
  		
  		var enableFlag = true;

 		/**
 	     * 메인에서 호출하는 function <br>
 	     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
 	     * <br><b>Example :</b>
 	     * <pre>
 	     * tabEnableSheet(flag)
 	     * </pre>
 	     * @param {boolean} flag 필수 메인화면에서 넘긴다.
 	     * @return 없음
 	     * @author 최성민
 	     * @version 2009.04.17
 	     */
  		function tabEnableSheet(flag) {
  			var formObject = document.form;
  			
  			enableFlag = flag;
  			
  			sheetObjects[0].Editable = flag;
  		}

           
   		/**
  	     * 버튼 권한 컨트롤 function <br>
  	     * 버튼을 제어한다. <br>
  	     * <br><b>Example :</b>
  	     * <pre>
  	     * buttonControl(mode)
  	     * </pre>
  	     * @param {string} mode 필수 사용자 권한이나 모드
  	     * @return 없음
  	     * @author 최성민
  	     * @version 2009.04.17
  	     */
  	 	function buttonControl(mode){
  			var formObj = document.form;
  			var req_usr_flg = formObj.req_usr_flg.value;
  			var apro_usr_flg = formObj.apro_usr_flg.value;
  			var amdt_seq = formObj.amdt_seq.value;
  			var sts = formObj.prop_sts_cd.value;
  			var row_cnt = sheetObjects[0].RowCount;
  			
  			
  			try{		
  				ComBtnDisable("btn_retrieve");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_acceptall");
				ComBtnDisable("btn_cancelall");
				ComBtnDisable("btn_rowadd");
				ComBtnDisable("btn_delete");				
				ComBtnDisable("btn_accept");
				ComBtnDisable("btn_acceptcancel");
				
				if(amdt_seq > 0){
					showButton("btn_amend");
					showButton("btn_amendcancel");
					ComBtnDisable("btn_amendcancel");
					ComBtnDisable("btn_amend");
				} else {
					hiddenButton("btn_amend");
					hiddenButton("btn_amendcancel");
				}

				if(mode == "CLEAR") {
					return;
				}
				
  				switch(sts) {
  					case 'I':   // Initial
  		  				ComBtnEnable("btn_retrieve");
  						if(apro_usr_flg=="true" || req_usr_flg=="true" ){
  							ComBtnEnable("btn_save");
  							ComBtnEnable("btn_rowadd");
  							ComBtnEnable("btn_delete");
  							ComBtnEnable("btn_amend");
  							ComBtnEnable("btn_amendcancel");
  							
  							if(amdt_seq > 0){
  								showButton("btn_amend");
  								showButton("btn_amendcancel");
  							}
  						}				
  						break;
  						
  					case 'Q':   // Requested
  		  				ComBtnEnable("btn_retrieve");
  						if(apro_usr_flg=="true" ){
  							ComBtnEnable("btn_acceptall");
  							ComBtnEnable("btn_cancelall");
  							ComBtnEnable("btn_accept");
  							ComBtnEnable("btn_acceptcancel");
  						}
  						break;
  						
  					case 'R':   // Returned
  		  				ComBtnEnable("btn_retrieve");
  						if(apro_usr_flg=="true" || req_usr_flg=="true" ){
  							ComBtnEnable("btn_accept");
  							ComBtnEnable("btn_acceptcancel");
  						}				
  						break;
  						
  					case 'A':   // Approved
  		  				ComBtnEnable("btn_retrieve");
  					case 'F':   // Filed
  		  				ComBtnEnable("btn_retrieve");
  					case 'C':   // Cancled
  		  				ComBtnEnable("btn_retrieve");
  						break;		
  				}	
  				
  			} catch (e) {
  				if (e == "[object Error]") {
  					ComShowMessage(OBJECT_ERROR);
  				} else {
  					ComShowMessage(e);
  				}
  			}
  		}

 		/**
 	    * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 	    * <br><b>Example :</b>
 	    * <pre>
 	    * 
 	    * </pre>
 	    * @param {ibsheet} sheetObj 필수 IBSheet Object
 	    * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 	    * @return 없음
 	    * @author 최성민
 	    * @version 2009.05.20
 	    */ 
 	    function sheet1_OnSearchEnd(sheetObj, errMsg){
 	    	manageCellEditable(sheetObj);
 		} 
 	    
 	   /**
 	    * SVC SCOPE이 TAW/TAE/ASE/ASW인경우 Mannual Input를 Display <br>
 	    * 
 	    * <br><b>Example :</b>
 	    * <pre>
 	    * 	initCheckMnlInpFlg(sheetObj, formObj);
 	    * </pre>
 	    * @param {ibsheet} sheetObj 필수 IBSheet Object
 	    * @param {string} formObj 필수 form Object
 	    * @return 없음
 	    * @author 최성민
 	    * @version 2009.06.02
 	    */  	    
 	    function initCheckMnlInpFlg(sheetObj, formObj) {

			formObj.f_cmd.value = SEARCH02;   	    			
			var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_07GS.do", FormQueryString(formObj));	
			var arrData = ComPriXml2Array(sXml, "cnt");
						
			if (arrData != null){
				var count = arrData[0][0];
				
				if(count > 0) {
					sheetObj.ColHidden("mnl_inp_flg") = true;	
					mnlInpFlg = true;
				} else {
					sheetObj.ColHidden("mnl_inp_flg") = false;
					mnlInpFlg = false;
				}
			}
 	    }
 	    
 	    /**
 	    * manual input일 경우 컬럼의 edit 여부를 수정하는 function <br>
 	    *  <br>
 	    * <br><b>Example :</b>
 	    * <pre>
 	    *		mnuInput(true,1)
 	    * </pre>
 	    * @param {boolean} sw 필수 true,false
 	    * @param {int} Row 필수 적용컬럼
 	    * @return 없음
 	    * @author 공백진
 	    * @version 2009.04.17
 	    */      
 	    function mnuInput(sw,Row){  	
 	    	var sheetObj = sheetObjects[0];
 	    	var amdt_seq = document.form.amdt_seq.value;
 	    	if (amdt_seq == 0 ){
 	    		sheetObj.CellEditable(Row,"cust_cnt_cd") = sw;
 	    		sheetObj.CellEditable(Row,"cust_seq") = sw;
 	    		sheetObj.CellEditable(Row, "cust_loc_cd") = !sw;
 	    		
 	    	}else{
 	    		sheetObj.CellEditable(Row,"cust_cnt_cd") = sw;
 	    		sheetObj.CellEditable(Row,"cust_seq") = sw;
 	    		sheetObj.CellEditable(Row, "cust_loc_cd") = !sw;
 	    	}
 	    }    
 	    
 	    
 		/**
	     * SHEET의 CELL 수정권한을 제어하는 function <br>
	     * 
	     * <br><b>Example :</b>
	     * <pre>
	     * 	manageCellEditable (sheetObj);
	     * </pre>
	     * @param {ibsheet} sheetObj 필수 IBSheet Object
	     * @return 없음
	     * @author 최성민
	     * @version 2009.04.17
	     */
	     function manageCellEditable (sheetObj) {
	    	    	  		
	    	 var formObj 		= document.form;
	    	 var amdtSeq 		= formObj.amdt_seq.value;
	    	 var propStsCd 		= formObj.prop_sts_cd.value;
	  		 var aproUsrFlg     = formObj.apro_usr_flg.value;
	    	 var sLgcyIfFlg		= formObj.lgcy_if_flg.value;
	    	 var reqUsrFlg      = formObj.req_usr_flg.value;
	  		 var sts            = formObj.prop_sts_cd.value;	  			
	    		    	 
	    	 for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
	    		  	    			    		 
	    		  // AMDT_SEQ가 다르면 DISABLE
	    		  if(sheetObj.CellValue(i,"amdt_seq") != amdtSeq){ 
	    			  sheetObj.CellFont("FontStrikethru", i, "chk", i, sheetObj.LastCol)=true;
	    			  sheetObj.RowEditable(i) = false;
	    		  }
				  
	    		  
	    		  if(amdtSeq == 0) {
	    			  if (sheetObj.CellValue(i, "mnl_inp_flg") == 1 && !sheetObj.ColHidden("mnl_inp_flg")){
	    				  sheetObj.CellEditable(i, "cust_cnt_cd") = false;
	    				  sheetObj.CellEditable(i, "cust_seq") = false;
	    				  sheetObj.CellEditable(i, "cust_loc_cd") = true;
	    				  sheetObj.CellEditable(i, "mnl_inp_flg") = true;
	    				  sheetObj.CellBackColor(i,"cust_addr") = sheetObj.RgbColor(255,255,255);
	    				  sheetObj.CellBackColor(i,"cust_nm") = sheetObj.RgbColor(255,255,255);
	    			  } else {
	    				  sheetObj.CellEditable(i, "cust_cnt_cd") = true;
	    				  sheetObj.CellEditable(i, "cust_seq") = true;
	    				  sheetObj.CellEditable(i, "cust_loc_cd") = false;
	    				  sheetObj.CellEditable(i, "mnl_inp_flg") = true;
    					  sheetObj.CellBackColor(i,"cust_addr") = -1;
    					  sheetObj.CellBackColor(i,"cust_nm") = -1;
	    			  }
	    		  } else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdtSeq && amdtSeq > 0 && sLgcyIfFlg != "Y"){
	    			  // AMEND 존재시 EFF_DT가 같으면 빨간색 처리
	    			  sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
	    			  
	    			  if (sheetObj.CellValue(i, "src_info_cd") == "AM"){
	    				  if (sheetObj.CellValue(i, "mnl_inp_flg") == 1 && !sheetObj.ColHidden("mnl_inp_flg")){
	    					  sheetObj.CellEditable(i, "cust_cnt_cd") = false;
	    					  sheetObj.CellEditable(i, "cust_seq") = false;
	    					  sheetObj.CellEditable(i, "cust_loc_cd") = true;
	    					  sheetObj.CellEditable(i, "mnl_inp_flg") = true;
	    					  sheetObj.CellBackColor(i,"cust_addr") = sheetObj.RgbColor(255,255,255);
	    					  sheetObj.CellBackColor(i,"cust_nm") = sheetObj.RgbColor(255,255,255);
	    				  } else {
	    					  sheetObj.CellEditable(i, "cust_cnt_cd") = true;
	    					  sheetObj.CellEditable(i, "cust_seq") = true;
	    					  sheetObj.CellEditable(i, "cust_loc_cd") = false;
	    					  sheetObj.CellEditable(i, "mnl_inp_flg") = true;
	    					  sheetObj.CellBackColor(i,"cust_addr") = sheetObj.RgbColor(255,255,255);
	    					  sheetObj.CellBackColor(i,"cust_nm") = sheetObj.RgbColor(255,255,255);
	    				  }
	    			  } else if (sheetObj.CellValue(i, "src_info_cd") == "AD"){
	    				  sheetObj.CellEditable(i, "cust_cnt_cd") = false;
	    				  sheetObj.CellEditable(i, "cust_seq") = false;
	    				  sheetObj.CellEditable(i, "cust_loc_cd") = false;
	    				  sheetObj.CellEditable(i, "mnl_inp_flg") = false;
	    			  } else {
	    				  if (sheetObj.CellValue(i, "mnl_inp_flg") == 1 && !sheetObj.ColHidden("mnl_inp_flg")){
	    					  sheetObj.CellEditable(i, "cust_cnt_cd") = false;
	    					  sheetObj.CellEditable(i, "cust_seq") = false;
	    					  sheetObj.CellEditable(i, "cust_loc_cd") = true;
	    					  sheetObj.CellEditable(i, "mnl_inp_flg") = true;
	    					  sheetObj.CellBackColor(i,"cust_addr") = sheetObj.RgbColor(255,255,255);
	    					  sheetObj.CellBackColor(i,"cust_nm") = sheetObj.RgbColor(255,255,255);
	    				  } else {
	    					  sheetObj.CellEditable(i, "cust_cnt_cd") = true;
	    					  sheetObj.CellEditable(i, "cust_seq") = true;
	    					  sheetObj.CellEditable(i, "cust_loc_cd") = false;
	    					  sheetObj.CellEditable(i, "mnl_inp_flg") = true;
	    					  sheetObj.CellBackColor(i,"cust_addr") = -1;
	    					  sheetObj.CellBackColor(i,"cust_nm") = -1;
	    				  }
	    			  }	    			  
	    		  } else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq && amdtSeq > 0){
	    			  	sheetObj.CellEditable(i,"cust_cnt_cd") = false;
						sheetObj.CellEditable(i,"cust_seq") = false;
						sheetObj.CellEditable(i,"mnl_inp_flg") = false;
						sheetObj.CellEditable(i,"cust_loc_cd") = false;
						sheetObj.CellBackColor(i,"cust_addr") = -1;
						sheetObj.CellBackColor(i,"cust_nm") = -1;
	    		  } else {
	    			  	sheetObj.CellEditable(i,"cust_cnt_cd") = false;
						sheetObj.CellEditable(i,"cust_seq") = false;
						sheetObj.CellEditable(i,"mnl_inp_flg") = false;
						sheetObj.CellEditable(i,"cust_loc_cd") = false;
						sheetObj.CellBackColor(i,"cust_addr") = -1;
						sheetObj.CellBackColor(i,"cust_nm") = -1;
	    		  }

	    		  if(propStsCd != "I" || sheetObj.CellValue(i,"prc_prog_sts_cd")!="I") {
	    			  	sheetObj.CellEditable(i,"cust_cnt_cd") = false;
						sheetObj.CellEditable(i,"cust_seq") = false;
						sheetObj.CellEditable(i,"mnl_inp_flg") = false;
						sheetObj.CellEditable(i,"cust_loc_cd") = false;
						sheetObj.CellBackColor(i,"cust_addr") = -1;
						sheetObj.CellBackColor(i,"cust_nm") = -1;
	    		  }
	    	 }
	    	 fileColumnControl(sheetObj);
	     }

	/**
	 * IBUpload Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setUploadObject(uploadObj);
	 * </pre>
	 * @param {ibupload} uploadObj 필수 IBUpload Object
	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
	 */
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}
    /**
     * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return 없음
     * @author 최성민
     * @version 2010.10.13
     */
 	function setFileUpload(sheetObj, filePathUrl) {
 		//트랜잭션 상태가 "입력"인 행을 찾아 온다.
 		var sRow = sheetObj.SelectRow;
 		var upObj = uploadObjects[0];
		
		//IBUpload에 파일 추가하기
		var ret = upObj.AddFile(filePathUrl);
		return ret;
 	}
     
	/**
 	 * OnDblClick 이벤트 발생시 호출되는 function <br>
 	 * Sheet의 해당 Sel을 더블클릭 시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 공백진
     * @version 2009.06.03
     */
 	function sheet1_OnDblClick(sheetObj, Row, Col, Value) {
 		//desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
   
 		var colname = sheetObj.ColSaveName(Col);
 		var sts = document.form.prop_sts_cd.value;

 		switch(colname){
 			case "poa_atch_file_nm":
	 	    	fileColumnEvent(sheetObj, Row, "OnDblClick", "poa_atch_file_");
 				break;
 		}
 	}
    
    function doFileUpload(sheetObj, Row, Col, colName){
    	if(sheetObj.CellValue(Row, colName+"id") == ""){
     		//파일선택 다이얼로그 표시하기
  	   		var filePathUrl = sheetObj.OpenFileDialog("Open File");
  	   		
  	   		//선택된 파일명이 있는 경우 처리하기
  	   		if(filePathUrl.indexOf("\\") !=-1 ) {	 	   			
  	   			//IBUpload에 파일 추가하기
 				var uploadObj = uploadObjects[0];
 				uploadObj.Files="";	//-먼저기존파일을 모두 지운후 추가함
 				
 				var comFileMaxCount = 1;    // 업로드 가능한 파일의 최대 개수, 기본 256개
 				var maxFileSize = 1024;  // 업로드 가능한 파일의 최대 용량, 기본 100MB, 단위 KB
 				uploadObj.SetLimit(comFileMaxCount, maxFileSize, maxFileSize);

		        ComOpenWait(true); //->waiting->start 
 				var ret = setFileUpload(sheetObj, filePathUrl);
 				if(ret != ""){
					ComShowCodeMessage("PRI01138");
			        ComOpenWait(false); //->waiting->start 
 					return;
 				}
	  	   		sheetObj.CellEditable(Row, colName+"nm") = false;
 				
  	   			var formObj = document.form;
  	   			
  	   			formObj.f_cmd.value = MULTI06;
 				var sParam = FormQueryString(formObj);
 				
 				//서버에 request전달하고, reponse 받기	
 	            if (uploadObj.LocalFiles != "") {
 		            //*******파일이 있는 경우 IBUpload 이용하기*******
 					uploadObj.ExtendParam = sParam;
 					uploadObj.ParamDecoding = true;
 		            sXml = uploadObj.DoUpload(true);
 		            
 		            var keyId = ComGetEtcData(sXml,"keyId");
 		            sheetObj.CellValue2(Row, colName+"id") = keyId;
 	            }
 	            
 	            if (sheetObj.CellValue(Row, colName+"id") != ""){
 					sheetObj.CellImage(Row, colName+"del") = 0;
 					
 					//선택된 파일의 이름만 팝업 셀에 설정하기
 	  	   			var fileName = filePathUrl.substr(filePathUrl.lastIndexOf("\\")+1);
 	  	   			sheetObj.CellValue2(Row, Col)= fileName;
 	  	   			
 	            }
		        ComOpenWait(false); //->waiting->start 
  	   		}
    	}
    }

    function fileColumnControl(sheetObj){
    	var sts = document.form.prop_sts_cd.value;
    	var fileColArray = new Array("poa_atch_file_");

	    for(var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
	        if( sts == "I" && sheetObj.CellValue(i,"prc_prog_sts_cd") == "I" && sheetObj.CellEditable(i, "cust_cnt_cd")){
	    		for( var j=0; j < fileColArray.length; j++ ){
        	    	if(sheetObj.CellValue(i,fileColArray[j]+"id") != "")
        	    		sheetObj.CellImage(i,fileColArray[j]+"del") = 0;
        	    	else
        	    		sheetObj.CellEditable(i, fileColArray[j]+"nm") = true;
        	    }
    		}
    	}
    }
    
    function fileColumnEvent(sheetObj, Row, event, colName){
    	var sts = document.form.prop_sts_cd.value;
    	
    	if ( event == "OnClick" ){
		    if( sts == "I" && sheetObj.CellValue(Row, "prc_prog_sts_cd") == "I"  && sheetObj.CellEditable(Row, "cust_cnt_cd")){
		    	if( sheetObj.CellValue(Row, colName+"id") != "" ){
		    		sheetObj.CellValue(Row, colName+"id") = "";
		    		sheetObj.CellValue(Row, colName+"nm") = "";
		    		sheetObj.CellEditable(Row,colName+"nm") = true;
		    		sheetObj.CellImage(Row, colName+"del") = "";
				}
		    }
	    } else if ( event == "OnDblClick" ){
	    	if(sheetObj.CellValue(Row, colName+"id") != "")
				location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, colName+"id");
	    }
    }
    
    /** 
     * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param {int} x 필수, X 좌표
     * @param {int} y 필수, Y 좌표
     * @return 없음
     */   
	function sheet1_OnMouseMove(sheetObj, shift, x, y){
	      var row = sheetObj.MouseRow;
	      var col = sheetObj.MouseCol;
	      var colName = sheetObj.ColSaveName(col);
	      if( colName == "poa_atch_file_nm" ){
	    	  var sText = sheetObj.CellText(row,col);
	    	  sheetObj.ToolTipText(row,col) = sText;
	      }

	}
	/* 개발자 작업  끝 */