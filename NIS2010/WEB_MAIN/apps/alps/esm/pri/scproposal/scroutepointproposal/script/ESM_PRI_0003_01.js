/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003_01.js
*@FileTitle : S/C Proposal Org/Dst Location Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.21 최성민
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
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
     * @class ESM_PRI_0003_01 : ESM_PRI_0003_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0003_01() {
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

 var tabLoad = new Array();
 tabLoad[0]= 0;
 tabLoad[1]= 0;


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
         
         initControl();         
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

         switch(sheetID) {

             case "sheet1":

                 with (sheetObj) {
                     // 높이 설정
                     style.height = 280;
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

                     var HeadTitle = "|Sel.|Seq.|amdt_seq|rout_pnt_seq|Location Type|Location Code|Description|EFF Date|EXP Date|Source|Status" +
                     		"|1|2|3|4|5|6";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
 					 InitDataProperty(0, cnt++ , dtDummyCheck,     	40,    	daCenter,  	false,	"chk");
                     InitDataProperty(0, cnt++ , dtDataSeq,   		50,    	daCenter,  	false, 	"seq");
                     InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "amdt_seq"); //
                     InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false, 	"rout_pnt_seq");
                     InitDataProperty(0, cnt++ , dtCombo,     		140,   	daCenter,  	false,	"rout_pnt_loc_tp_cd",	true,	"",      dfNone, 			0,     true,       true);
 					 
                     InitDataProperty(0, cnt++ , dtPopupEdit, 		140,   	daCenter,  	false,	"rout_pnt_loc_def_cd",	true,	"",      dfNone, 			0,     true,       true, 5);
                     InitDataProperty(0, cnt++ , dtData,      		300,   	daLeft, 	false,	"rout_pnt_loc_def_nm",	false,	"",      dfNone, 			0,     false,      false);
 					 InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,  	false,	"eff_dt",    	  		false,	"",      dfDateYmd, 		0,     false,      false);
                     InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,  	false,	"exp_dt",      			false,	"",      dfDateYmd, 		0,     false,      false);
 					 InitDataProperty(0, cnt++ , dtCombo,      		70,    	daCenter,  	false,	"src_info_cd",			false,	"",      dfNone, 			0,     false,      false);
 					 
 					 InitDataProperty(0, cnt++ , dtCombo,      		60,		daCenter,  	false,	"prc_prog_sts_cd",		false,	"",      dfNone, 			0,     false,      false);
 					 
 					 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "svc_scp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "prop_no");
	                 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "org_dest_tp_cd"); 
	                 InitDataProperty(0, cnt++ , dtHidden, 			80, 	daCenter, 	false, 	"src_info_dtl");
					 InitDataProperty(0, cnt++ , dtHidden, 			80, 	daCenter, 	false, 	"prc_prog_sts_dtl");
					 InitDataProperty(0, cnt++ , dtHidden, 			80, 	daCenter, 	false, 	"n1st_cmnc_amdt_seq");

					 InitDataCombo(0, "rout_pnt_loc_tp_cd", LOCATION_TYPE1[1], LOCATION_TYPE1[0], " ", " ", 0);
					 InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue, "", "NW");            
					 InitDataCombo(0, "prc_prog_sts_cd", prcProgStsCdComboText, prcProgStsCdComboValue, "", "I");
	                
	                 //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
		 			 InitDataValid(0,  "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

 					 ShowButtonImage = 2;

                     WaitImageVisible = false;
                }
                 break;
                 
             case "sheet2":

                 with (sheetObj) {
                     // 높이 설정
                     style.height = 270;
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

                     var HeadTitle = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq,   		50,    	daCenter,  	false, 	"seq");
 					 InitDataProperty(0, cnt++ , dtHidden,     		70,    	daCenter,  	false,	"src_info_cd");
 					 InitDataProperty(0, cnt++ , dtHidden,     		60,		daCenter,  	false,	"prc_prog_sts_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "org_dest_tp_cd"); 
	                 
                     InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "amdt_seq");
                     InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "svc_scp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "prop_no"); 
					 InitDataProperty(0, cnt++ , dtHidden, 			80, 	daCenter, 	false, 	"n1st_cmnc_amdt_seq"); 
					 
 					 InitDataProperty(0, cnt++ , dtHidden,     		70,    	daCenter,  	false,	"org_src_info_cd");
 					 InitDataProperty(0, cnt++ , dtHidden,     		60,		daCenter,  	false,	"org_prc_prog_sts_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "org_tp_cd");
 					 InitDataProperty(0, cnt++ , dtHidden,     		70,    	daCenter,  	false,	"dest_src_info_cd");
 					 InitDataProperty(0, cnt++ , dtHidden,     		60,		daCenter,  	false,	"dest_prc_prog_sts_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "dest_tp_cd");

	                 WaitImageVisible = false;
                }
                 break;

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
    	 try{
	         sheetObj.ShowDebugMsg = false;
	         switch(sAction) {
		         case IBSEARCH_ASYNC01: 
		  			ComOpenWait(true);
		        	 //1)TAB선택시 tabLoadSheet()에서 호출
		        	 //2)OPEN시 데이터가 존재하는지 조회한다.
		        	 //3)ROUTE TYPE의 DEFAULT는 ORIGIN이 선택되어지나 DESTINATION에만 데이터가 존재할경우  DESTINATION이 선택된다. 
		        	formObj.f_cmd.value = SEARCH02;	 	        
					var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_0003_01GS.do" , FormQueryString(formObj));
					var arrData = ComPriXml2Array(sXml, "org_tp_cd|dest_tp_cd");
	
					if(arrData != null && arrData.length > 0) {
						if(arrData[0][0] == "" && arrData[0][1] == "D" ) {
							formObj.org_dest_tp_cd[1].checked = true;
						} else {
							formObj.org_dest_tp_cd[0].checked = true;
						}
					}
					break;
				
		        case IBSEARCH: // 조회
	  				ComOpenWait(true);
		        	//1)ROUTE TYPE 색/볼드 지정을 위해 조회-ACCEPT, AMEND 등등
		        	//2)검색
			        formObj.f_cmd.value = SEARCH;
		     		var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_01GS.do" , sParam);
					var arrXml = sXml.split("|$$|");
					
					if ( arrXml[0] != null) {
						 //type 색/볼드 지정을 위해 조회
						var arrData = ComPriXml2Array(arrXml[0], "org_src_info_cd|org_prc_prog_sts_cd|org_tp_cd|dest_src_info_cd|dest_prc_prog_sts_cd|dest_tp_cd");
						manageRouteRadioButton(arrData);
					}
					
					if ( arrXml[1] != null) {
						sheetObjects[0].LoadSearchXml(arrXml[1]);
					}
					buttonControl();
					break;
	
	 			case IBSAVE:        //저장
		  			formObj.f_cmd.value = MULTI;
	  				var sParam = FormQueryString(formObj);
	  				var sParamSheet = sheetObj.GetSaveString();
	  				if (sParamSheet != "") {
	  					sParam = ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
	  				} else {
	  				    return false;
	  				}
	  				
	  				if (!ComPriConfirmSave()) {
	  					return false;
	  				}
	
	  				ComOpenWait(true);
	  				var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_01GS.do", sParam);
	  				
					//1)ROUTE TYPE  색/볼드 지정을 위해 사용
	  				//2)저장완료 메세지가 뜨기전에 호출한다.
					searchRouteTypeColor();
	  				
	  				sheetObj.LoadSaveXml(sXml);
	  				buttonControl();
					break;
	
	 			case IBINSERT:       // Row Add				
	
		 			var prop_no      = formObj.prop_no.value;
					var amdt_seq     = formObj.amdt_seq.value; 
					var svc_scp_cd   = formObj.svc_scp_cd.value;
					var eff_dt		 = formObj.eff_dt.value;
					var exp_dt		 = formObj.exp_dt.value;
	 			
					if(amdt_seq == 0){
						var idx = sheetObj.DataInsert();
											
						sheetObj.CellValue2(idx, "org_dest_tp_cd") = ComGetObjValue(formObj.org_dest_tp_cd);
						sheetObj.CellValue2(idx, "prop_no") = prop_no;
						sheetObj.CellValue2(idx, "svc_scp_cd") = svc_scp_cd;
						sheetObj.CellValue2(idx, "amdt_seq") = amdt_seq;
						sheetObj.CellValue2(idx, "eff_dt") = eff_dt;
						sheetObj.CellValue2(idx, "exp_dt") = exp_dt;
						sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
						sheetObj.CellValue2(idx, "rout_pnt_seq") = parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1;										
						sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
						sheetObj.CellValue2(idx, "src_info_cd") = "NW";
						sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd");
						
					}else{
						
						// insert Amend 중 Amend pair 사이에 끼어들게 되는 경우를 제외							
						if(sheetObj.SearchRows!=0 && sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!= amdt_seq ){	
							ComShowCodeMessage("PRI01002");		
						 	return;
						}							
						
						var idx = sheetObj.DataInsert();	   // 신규 row			
						sheetObj.CellValue2(idx, "org_dest_tp_cd") = ComGetObjValue(formObj.org_dest_tp_cd);
						sheetObj.CellValue2(idx, "prop_no") = prop_no;
						sheetObj.CellValue2(idx, "svc_scp_cd") = svc_scp_cd;
						sheetObj.CellValue2(idx, "amdt_seq") = amdt_seq;	
						sheetObj.CellValue2(idx, "eff_dt") = eff_dt;
						sheetObj.CellValue2(idx, "exp_dt") = exp_dt;
						sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
						sheetObj.CellValue2(idx, "rout_pnt_seq") = parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1;										
						sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
						sheetObj.CellValue2(idx, "src_info_cd") = "NW";
	
						sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
						sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd");
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
						if(sheetObj.CellValue(Number(chkArr[j])+sRow, "n1st_cmnc_amdt_seq")!= amdt_seq){
							comSheetAmendRow(sheetObj,formObj,Number(chkArr[j])+sRow,"D","rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");			
							sRow++;								
						}
					}
					
					deleteRowCheck(sheetObj, "chk");
					break;
					
	 			case MODIFY01: // Accept All
		 			if(ComShowCodeConfirm("PRI01015")) {
						formObj.f_cmd.value = MULTI02;	
						//1)ROUTE TYPE 색처리때문에 공통함수를 사용하지 않고 별도 함수를 생성하여 사용
						//2)ACCEPT 메세지 창 호출보다  색처리가 우선임
						comSheetAcceptCheckedRowsRoute(sheetObj,document.form,"ESM_PRI_0003_01GS.do",true);				
		 			}
					
					break;
					
	 			case MODIFY02: // Cancel All
		 			if(ComShowCodeConfirm("PRI01010")) {
						formObj.f_cmd.value = MULTI03;
						//1)ROUTE TYPE 색처리때문에 공통함수를 사용하지 않고 별도 함수를 생성하여 사용
						//2)ACCEPT 메세지 창 호출보다  색처리가 우선임
						comSheetAcceptCancelCheckedRowsRoute(sheetObjects[0],document.form,"ESM_PRI_0003_01GS.do",true);	 				
		 			}
					break;		
			
					
	 	      	case MODIFY03: // Accept
	 	      		if(ComShowCodeConfirm("PRI00008")) {
		 				formObj.f_cmd.value = MULTI04;
						//1)ROUTE TYPE 색처리때문에 공통함수를 사용하지 않고 별도 함수를 생성하여 사용
						//2)ACCEPT 메세지 창 호출보다  색처리가 우선임
		 				comSheetAcceptCheckedRowsRoute(sheetObjects[0],document.form,"ESM_PRI_0003_01GS.do",false);		            
	 	      		}
	 				break;
	 				
	 	      	case MODIFY04: // Accept Cancel
		 	      	if(ComShowCodeConfirm("PRI00009")) {
						formObj.f_cmd.value = MULTI05;
						//1)ROUTE TYPE 색처리때문에 공통함수를 사용하지 않고 별도 함수를 생성하여 사용
						//2)ACCEPT 메세지 창 호출보다  색처리가 우선임
						comSheetAcceptCancelCheckedRowsRoute(sheetObjects[0],document.form,"ESM_PRI_0003_01GS.do",false);	 	      		
		 	      	}
					break;			
	 				
				case COMMAND01: // Amend
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{			
							comSheetAmendRow(sheetObj,formObj,chkArr[0],"M","rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");
						}
					}else{ 
						comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"M","rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");	
					}
					sheetObj.SelectCell(sheetObj.SelectRow, "rout_pnt_loc_def_cd");
				
					break;		
				
				case COMMAND02: // Amend Cancel
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");
							setEditableFlag(sheetObj,chkArr[0],"rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");
						}
					}else{ 
						comSheetAmendCancelRow(sheetObj,formObj,sheetObj.SelectRow,"M", "rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");
						setEditableFlag(sheetObj,sheetObj.SelectRow,"rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");
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
  	* @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} sRow 필수IBSheet Object Row
    * @param {string} sCols IBSheet Object SAVENAME
  	* @return 없음
  	* @author 최성민
  	* @version 2010.01.19
  	*/
     function setEditableFlag(sheetObj,sRow,sCols){
    	 var arrCols = sCols.split("|");    	          
         for(var i=0;arrCols != null && i<arrCols.length;i++){
             sheetObj.CellEditable(sRow, arrCols[i]) = false;
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

			if (sheetObjects[0].IsDataModified && sheetObjects[0].GetSaveString() == "") {
				return false;
			}
			
            if (sheetObjects[0].IsDataModified ) {
                var dupRow = ComPriAmendDupCheck(sheetObjects[0], "rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|n1st_cmnc_amdt_seq", formObj.amdt_seq.value);

                if (dupRow >= 0) {
                    sheetObjects[0].SelectRow = dupRow;
                     ComShowCodeMessage("PRI00302");
                     return false;
                }
            } else {    // 저장할 데이터가 없는 경우
                ComShowCodeMessage("PRI00301");
                return false;
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
    	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
    	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
    	 * @return 없음
         * @author 최성민
         * @version 2009.04.17
    	 **/
    	function initControl() {    
    		axon_event.addListenerForm  ('click', 'obj_OnClick', form); 
    	}

	    /**
    	 * HTML Control의 onClick이벤트에서 Validation을 체크한다. <br>
    	 * 1)SHEET데이터가 수정된 상태에서 ROUTE TYPE를 선택했을경우 저장메세지를 호출한다. <br>
    	 * 2)저장시 ROUTE TYPE CODE는 SHEET상의 데이터를 사용함.
    	 * @return 없음
         * @author 최성민
         * @version 2009.04.17
    	 **/
	   	function obj_OnClick(){
	   		var sheetObj = sheetObjects[0];
	   		var formObj = document.form;
	   		
	   		if (event.srcElement.name == "org_dest_tp_cd") {
	   			
	   			if (sheetObj.IsDataModified) {
					var rslt = false;
					if (ComShowCodeConfirm("PRI00006")) {
						
						if(!validateForm(sheetObjects[0],document.form,IBSAVE)) {							
							ComSetObjValue(formObj.org_dest_tp_cd, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "org_dest_tp_cd"));
							return false;
						}
						
						var sParamSheet = sheetObj.GetSaveString(false);
						sParamSheet += "&f_cmd="+MULTI;
						var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_01GS.do", sParamSheet);
						
						//ROUTE TYPE  색/볼드 지정을 위해 사용
						searchRouteTypeColor();
			        	
		  				sheetObj.LoadSaveXml(sXml);
					}
				}
	   			
	   			formObj.org_dest_tp_cd.value = ComGetObjValue(formObj.org_dest_tp_cd);
	   			doActionIBSheet(sheetObj, formObj, IBSEARCH);
	   			
	   		}
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
        	    	case "rout_pnt_loc_def_cd":
        	    		if (Value.length==2){
        	    			formObj.f_cmd.value = SEARCH07;
        	    			formObj.cd.value=sheetObj.Cellvalue(Row,Col);    	
      	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));	  			
      	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");	  				
        					if (arrData[1] != ""){
        						sheetObj.CellValue2(Row,"rout_pnt_loc_def_nm") = arrData[1];
        						sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = "C" ;
        					}else{
        						locationCellClear(sheetObj,Row);
        					}	  				
        	    		}else if(Value.length==5){
        	    			formObj.f_cmd.value = SEARCH05;
        	    			formObj.cd.value=sheetObj.Cellvalue(Row,Col);  	
	      	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));	  			
	      	  				var arrData = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		  			
	      	  				if (arrData != null && arrData.length > 0) {
	      	  					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrData[0][1];
	      	  					sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = "L" ;
	        					}else{  		
	        						locationCellClear(sheetObj,Row);
	      					}	
        	    		}else{
        	    			locationCellClear(sheetObj,Row);
         			
        	    		}
        	    		break;
       	    	case "rout_pnt_loc_tp_cd": 	    	
       	    		sheetObj.CellValue2(Row,"rout_pnt_loc_def_nm")= ""; 		
       	  	  		sheetObj.CellValue2(Row,"rout_pnt_loc_def_cd")= "";
       	  	  		sheetObj.SelectCell(Row,"rout_pnt_loc_def_cd");
       	    		break;  	    		
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
  			manageCellEditable (sheetObj);
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
  	     * @author 공백진
  	     * @version 2009.04.17
  	     */  	    
  	  	function locationCellClear(sheetObj,Row){
  	    	sheetObj.CellValue2(Row,"rout_pnt_loc_def_nm")= ""; 		
  	  		sheetObj.CellValue2(Row,"rout_pnt_loc_def_cd")= "";
  	  		sheetObj.SelectCell(Row,"rout_pnt_loc_def_cd");
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
	    	
	    	 manageCellEditable (sheetObj)
	    	
	    	 //Main 의 Amendment Summary 관련 function
	    	 if(ComGetObjValue(formObj.org_dest_tp_cd)=="O") {
	    		 parent.comUpdateProposalStatusSummary("41", formObj.svc_scp_cd.value);
	    	 } else if(ComGetObjValue(formObj.org_dest_tp_cd)=="D") {
	    		 parent.comUpdateProposalStatusSummary("42", formObj.svc_scp_cd.value);
	    	 }
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
	   	    	case "rout_pnt_loc_def_cd":
	   	    		
	 	  	  		var sUrl = "/hanjin/ESM_PRI_4026.do?";
	 	  	  		sUrl += "group_cmd=" + PRI_SG;
	 	  	  		sUrl += "&location_cmd=LC";
	 	  	  		sUrl += "&svc_scp_cd=" + formObj.svc_scp_cd.value;
	 	  	  		sUrl += "&loc_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "rout_pnt_loc_tp_cd");
	 	  	  		
	 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
	 	  			if (rtnVal != null){
	 	  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
	 	  				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;
	 	  				sheetObj.CellValue2(Row, Col - 1) = rtnVal.tp;
	 	  			}
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
 				
 				document.getElementById("org_dest_tp_cd1").style.fontWeight = "";
	  			document.getElementById("org_dest_tp_cd1").style.color = "black";  	  			
				document.getElementById("org_dest_tp_cd2").style.fontWeight = "";
	  			document.getElementById("org_dest_tp_cd2").style.color = "black";
	        	
 				buttonControl();
 				//페이지로딩시 데이터가 존재하는 ROUTE TYPE을 자동으로 선택하게 한다.

 				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01); 				
 				doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
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

			document.getElementById("org_dest_tp_cd1").style.fontWeight = "";
			document.getElementById("org_dest_tp_cd2").style.fontWeight = "";
			document.getElementById("org_dest_tp_cd1").style.color = "black";
			document.getElementById("org_dest_tp_cd2").style.color = "black";
			
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
	     * ROUTE RADIO 버튼의 폰트색을 변경하는 function <br>
	     * 1) ALL ACCEPT일 경우는 파란색 <br>
	     * 2) AMEND할 건수가 존재할 경우 빨간색 <br>
	     * <br><b>Example :</b>
	     * <pre>
	     * manageRouteRadioButton(arrData);
	     * </pre>
	     * @param {Array} arrData 배열
	     * @return 없음
	     * @author 최성민
	     * @version 2009.06.15
	     */
  	    function manageRouteRadioButton(arrData){
  	    	var formObj = document.form;
	    	var sLgcyIfFlg = formObj.lgcy_if_flg.value;
	    	
  			try {  				
  				if (arrData != null && arrData.length > 0) {
	  	  			//BOLD지정
  					//ORG_TP_CD
	  				if(arrData[0][2] == "O") {
	  					document.getElementById("org_dest_tp_cd1").style.fontWeight = "bold";
	  				} else if(arrData[0][2] == "") {
	  					document.getElementById("org_dest_tp_cd1").style.fontWeight = "";
	  				} 
	  				//DEST_TP_CD
	  				if(arrData[0][5] =="D") {
	  					document.getElementById("org_dest_tp_cd2").style.fontWeight = "bold";
	  				} else if(arrData[0][5] =="") {
	  					document.getElementById("org_dest_tp_cd2").style.fontWeight = "";
	  				} 
	  				
	  				
  					//빨간색 지정
	  				//ORG_SRC_INFO_CD
  					if(arrData[0][0] == "AM" && sLgcyIfFlg != "Y") {
  						document.getElementById("org_dest_tp_cd1").style.color = "red";
  					} else {
  						document.getElementById("org_dest_tp_cd1").style.color = "black";
  					}
  					//DEST_SRC_INFO_CD
  					if(arrData[0][3] == "AM" && sLgcyIfFlg != "Y") {
  						document.getElementById("org_dest_tp_cd2").style.color = "red";
  					} else {
  						document.getElementById("org_dest_tp_cd2").style.color = "black";
  					}
  					
  					
  	  				//파란색 지정
  					//ORG_PRC_PROG_STS_CD
  	  				if(arrData[0][1] == "A" && sLgcyIfFlg != "Y") {
  	  					document.getElementById("org_dest_tp_cd1").style.color = "blue";
  	  				} else if(arrData[0][1] == "I" && arrData[0][0] == "AM" && sLgcyIfFlg != "Y") {
  	  					document.getElementById("org_dest_tp_cd1").style.color = "red";
  	  				} else {
  	  					document.getElementById("org_dest_tp_cd1").style.color = "black";
  	  				}
  	  				//DEST_PRC_PROG_STS_CD
  	  				if(arrData[0][4] == "A" && sLgcyIfFlg != "Y") {
	  					document.getElementById("org_dest_tp_cd2").style.color = "blue";
	  				} else if(arrData[0][4] == "I" && arrData[0][3] == "AM" && sLgcyIfFlg != "Y") {
	  					document.getElementById("org_dest_tp_cd2").style.color = "red";
	  				} else {
	  					document.getElementById("org_dest_tp_cd2").style.color = "black";
	  				}
  				} else {
  					document.getElementById("org_dest_tp_cd1").style.fontWeight = "";
  					document.getElementById("org_dest_tp_cd2").style.fontWeight = "";
  					document.getElementById("org_dest_tp_cd1").style.color = "black";
  					document.getElementById("org_dest_tp_cd2").style.color = "black";
  				}  			
  			}catch(e) {}
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
	    	 var eff_dt 		= formObj.eff_dt.value;
	    	 var amdt_seq 		= formObj.amdt_seq.value;
	    	 var prop_sts_cd 	= formObj.prop_sts_cd.value;
	    	 var sLgcyIfFlg		= formObj.lgcy_if_flg.value;
	    	
	    	 for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
	    		  
	    		  if(sheetObj.CellValue(i,"amdt_seq") != amdt_seq){ 
	    			  sheetObj.CellFont("FontStrikethru", i, "chk", i, sheetObj.LastCol)=true;
	    			  sheetObj.RowEditable(i) = false;
	    		  }
			
	    		  if(sheetObj.CellValue(i,"amdt_seq") == amdt_seq && amdt_seq > 0 && sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") != amdt_seq){
	    			  
	    			  sheetObj.CellEditable(i,"rout_pnt_loc_tp_cd") = false;
	    			  sheetObj.CellEditable(i,"rout_pnt_loc_def_cd") = false;
	    		  }
				
	    		  if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq && amdt_seq > 0 && sLgcyIfFlg != "Y"){
	    			  sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);	
	    		  }
	    		  
	    		  if(prop_sts_cd != "I" || sheetObj.CellValue(i,"prc_prog_sts_cd") != "I") {
	    			  sheetObj.CellEditable(i,"rout_pnt_loc_tp_cd") = false;
	    			  sheetObj.CellEditable(i,"rout_pnt_loc_def_cd") = false;
	    		  }
	    	 }
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
	 			ComBtnDisable("btn_glinecopy");
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
	 					if(apro_usr_flg== "true" || req_usr_flg== "true" ){
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
	 					if(apro_usr_flg== "true"){
	 						ComBtnEnable("btn_acceptall");
	 						ComBtnEnable("btn_cancelall");
	 						ComBtnEnable("btn_accept");
	 						ComBtnEnable("btn_acceptcancel");
	 					}
	 					break;
	 					
	 				case 'R':   // Returned
			 			ComBtnEnable("btn_retrieve");
	 					if(apro_usr_flg== "true" || req_usr_flg== "true" ){
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
	     * ROUTE TYPE 색/볼드 지정을 위해 조회하는 function
	     * 	
	     * @return 없음
	     * @author 최성민
	     * @version 2009.06.29
	     */	
	 	function searchRouteTypeColor() {
	 		var formObj = document.form;
	        formObj.f_cmd.value = SEARCH02;
	        var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_0003_01GS.do" , FormQueryString(formObj));
			var arrData = ComPriXml2Array(sXml, "org_src_info_cd|org_prc_prog_sts_cd|org_tp_cd|dest_src_info_cd|dest_prc_prog_sts_cd|dest_tp_cd");
			manageRouteRadioButton(arrData);
	 	}
	     

      /**
      * sheet 에 대하여 check 된 Row 를 Accept 처리한다.
      * sheetObj    : 처리 대상 sheet object
      * formObj     : 처리 대상 form object
      * sUrl        : 처리 대상 Row
      * isAll       : 대상 Row 전체에 적용할 것인지 여부
      *           ex) comSheetAcceptCheckedRowsRoute(sheetObjects[1],document.form,"ESM_PRI_0003GS.do",true);
      * @return {string}
      * @author 변영주
      * @version 2009.05.29
      */
      function comSheetAcceptCheckedRowsRoute(sheetObj,formObj,sUrl, isAll){
      	var amdt_seq  	= formObj.amdt_seq.value;
          var prop_sts_cd = formObj.prop_sts_cd.value;
          var eff_dt      = formObj.eff_dt.value;

          if(isAll == undefined || isAll ==""){
              isAll = false;
          }

          if(prop_sts_cd == "R") {
              if(isAll){
                  comChangeValue(sheetObj, "chk", "0");
                  comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|R");
                  if(sheetObj.CheckedRows("chk") == 0) {
                      ComShowCodeMessage("PRI00301");
                      return false;
                  }
              }

              var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")

              if(chkArr.length == 0){
                  sheetObj.CellValue2(sheetObj.SelectRow,"chk") = "1";
                  chkArr[0] = sheetObj.SelectRow;
              }
              for(i=0;i<chkArr.length;i++){
                  if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="R" || sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                      sheetObj.CellValue2(chkArr[i],"chk") = "0";
                      ComShowCodeMessage("PRI00313");
                      return false;
                  }
              }

              comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "A|Accepted|U", "chk", "1");

              var sParam = FormQueryString(formObj);
              var sParamSheet = sheetObj.GetSaveString(false, false, "chk");
              if (sParamSheet != "") {
            	  sParam = ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
              }
              var sXml = sheetObj.GetSaveXml(sUrl, sParam);
              sheetObj.LoadSaveXml(sXml, false, "chk");

              comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");
          } else {
          if(isAll){
              comChangeValue(sheetObj, "chk", "0");
              comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|I");
              if(sheetObj.CheckedRows("chk")==0){
                  ComShowCodeMessage("PRI00329");
                  return false;
              }
          }

          var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")

          if(chkArr.length == 0){
              sheetObj.CellValue2(sheetObj.SelectRow,"chk") = "1";
              chkArr[0] = sheetObj.SelectRow;
          }
          for(i=0;i<chkArr.length;i++){
          	if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="I"){
                  sheetObj.CellValue2(chkArr[i],"chk") = "0";
                  ComShowCodeMessage("PRI01037");
                  return false;
              }
          	
          	if(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                  sheetObj.CellValue2(chkArr[i],"chk") = "0";
                  ComShowCodeMessage("PRI00313");
                  return false;
              }
          }

          comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "A|Accepted|U", "chk", "1");


		  ComOpenWait(true);
          var sParam = FormQueryString(formObj);
          var sParamSheet = sheetObj.GetSaveString(false, false, "chk");
          if (sParamSheet != "") {
        	  sParam = ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
          }
          var sXml = sheetObj.GetSaveXml(sUrl, sParam);

          searchRouteTypeColor();
		  ComOpenWait(false);
          
          sheetObj.LoadSaveXml(sXml, false, "chk");

          comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");
          }
          return true;

      }

      /**
      * sheet 에 대하여 check 된 Row 를 Accept Cancel 처리한다.
      * sheetObj    : 처리 대상 sheet object
      * formObj     : 처리 대상 form object
      * sUrl        : 처리 대상 Row
      * isAll       : 대상 Row 전체에 적용할 것인지 여부
      *           ex) comSheetAcceptCancelCheckedRowsRoute(sheetObjects[1],document.form,"ESM_PRI_0003GS.do",true);
      * @return {string}
      * @author 변영주
      * @version 2009.05.29
      */
      function comSheetAcceptCancelCheckedRowsRoute(sheetObj,formObj,sUrl,isAll){
          var eff_dt       = formObj.eff_dt.value;
          var amdt_seq     = formObj.amdt_seq.value;
          
          if(isAll == undefined || isAll ==""){
              isAll = false;
          }

          if(isAll){
              comChangeValue(sheetObj, "chk", "0");
              comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|A");
              if(sheetObj.CheckedRows("chk")==0){
                  ComShowCodeMessage("PRI00301");
                  return false;
              }
          }

          var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")

          if(chkArr.length == 0){
              sheetObj.CellValue2(sheetObj.SelectRow,"chk") = "1";
              chkArr[0] = sheetObj.SelectRow;
          }

          for(i=0;i<chkArr.length;i++){
              if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="A" || sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                  sheetObj.CellValue2(chkArr[i],"chk") = "0";
                  ComShowCodeMessage("PRI00313");
                  return false;
              }
          }
          
          comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "I|Initial|U", "chk", "1");

		  ComOpenWait(true);
          var sParam = FormQueryString(formObj);
          var sParamSheet = sheetObj.GetSaveString(false, false, "chk");
          if (sParamSheet != "") {
        	  sParam = ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
          }
          var sXml = sheetObj.GetSaveXml(sUrl, sParam);
          
          searchRouteTypeColor();
		  ComOpenWait(false);          
          
          sheetObj.LoadSaveXml(sXml, false, "chk");

          comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");

          return true;
      }
	 
	/* 개발자 작업  끝 */