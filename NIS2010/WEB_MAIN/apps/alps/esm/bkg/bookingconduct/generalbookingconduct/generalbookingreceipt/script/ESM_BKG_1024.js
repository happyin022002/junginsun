/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1024.js
*@FileTitle : VVD Change for partial container booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.08.18 김병규
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
     * @class ESM_BKG_1024 : ESM_BKG_1024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1024() {
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
 				case "btn_Ok":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
 					break;
 				case "btn_Close":
 					window.close();
 					break; 					
 				
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111"); 
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
 			initSheet(sheetObjects[i],i+1,"");
 			ComEndConfigSheet(sheetObjects[i]);
         }			  		
     }

 	 function sheet1_OnLoadFinish(sheetObj) {   
		 sheetObj.WaitImageVisible = false;   
         if(ComIsNull(ComGetObjValue(document.form.bkg_no))){
        	 ComShowCodeMessage("BKG00255");
         }else{
        	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         }
		 sheetObj.WaitImageVisible = true;   
	 }         
      
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo,colName) {
         var cnt = 0;
         switch(sheetObj.id){
             case "sheet1":
                 with (sheetObj){

                     // 높이 설정
                     style.height = 152;
                     
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);
                     
                     var colArr = colName.split("|");

  					 var HeadTitle1 = "";
 					 var HeadTitle2 = ""; 					 
 					 
                     if(colName != "" && colArr != null && colArr.length > 0){
                    	 HeadTitle1 = "BKG No.";
                    	 for(var i = 0 ; i < colArr.length ; i++){
                    		 HeadTitle1 = HeadTitle1 + "|CNTR No.";
                    	 }                    	 
                    	 HeadTitle2 = "BKG No.|"+ colName.toUpperCase();
                     }else{
      					HeadTitle1 = "BKG No.|CNTR No.";
     					HeadTitle2 = "BKG No.|";                    	 
                     }
 					var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);
                    
                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					
 					InitDataProperty(0, cnt++ , dtData,						100,		daCenter,		true,			"bkg_no",				false,		"",			dfNone,		0,			false,		false);
 					if(colName != "" && colArr != null && colArr.length > 0){
 						for(var i = 0 ; i < colArr.length ; i++){
 							InitDataProperty(0, cnt++ , dtCheckBox,		80,		daCenter,		true,			colArr[i],				false,		"",			dfNone,		0,			false,		false);
 						}
 					}else{
 						InitDataProperty(0, cnt++ , dtCheckBox,			80,		daCenter,		true,			"cntr_no",				false,		"",			dfNone,		0,			false,		false);	
 					}
 					CountPosition = 0;
 				}
 				break;
             case "sheet2":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 162;
                     
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

 					var HeadTitle1 = "|BKG No.|I/R Change|I/R Change|Origin Inland|Origin Inland|Origin Inland|Origin Inland|Origin Inland|1st|1st|1st|1st|1st|2nd|2nd|2nd|2nd|2nd|3rd|3rd|3rd|3rd|3rd|4th|4th|4th|4th|4th|Destination Inland|Destination Inland|Destination Inland|Destination Inland||||";
 					var HeadTitle2 = "||ORG|DEST|POR|POR|POL|POL|S/O|1st VVD|POL|POL|POD|POD|2nd VVD|POL|POL|POD|POD|3rd VVD|POL|POL|POD|POD|4th VVD|POL|POL|POD|POD|POD|POD|DEL|DEL||||";
 					var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     //InitColumnInfo(headCount, 0, 0, true);
 					InitColumnInfo(49, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);
                    
                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0,  cnt++ , 	dtHiddenStatus,		30,		daCenter,		false,		"ibflag");
 					 InitDataProperty(0, 	cnt++ , 	dtData,					100,		daCenter,		true,			"bkg_no",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtCombo,				35,		daCenter,		true,			"org",				false,		"",					dfNone,				0,					true,					true);
 					 InitDataProperty(0, 	cnt++ , 	dtCombo,				35,		daCenter,		true,			"dest",				false,		"",					dfNone,				0,					true,					true);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					50,		daCenter,		true,			"por_cd",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					20,		daCenter,		true,			"por_nod_cd",		false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					50,		daCenter,		true,			"pol_cd",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					20,		daCenter,		true,			"pol_nod_cd",		false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					30,		daCenter,		true,			"ob_so",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					80,		daCenter,		true,			"vvd1",				false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					50,		daCenter,		true,			"pol1",				false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					20,		daCenter,		true,			"polyd1",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					50,		daCenter,		true,			"pod1",				false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					20,		daCenter,		true,			"podyd1",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					80,		daCenter,		true,			"vvd2",				false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					50,		daCenter,		true,			"pol2",				false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					20,		daCenter,		true,			"polyd2",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					50,		daCenter,		true,			"pod2",				false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					20,		daCenter,		true,			"podyd2",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					80,		daCenter,		true,			"vvd3",				false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					50,		daCenter,		true,			"pol3",				false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					20,		daCenter,		true,			"polyd3",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					50,		daCenter,		true,			"podyd3",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					20,		daCenter,		true,			"podyd1",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					80,		daCenter,		true,			"vvd4",				false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					50,		daCenter,		true,			"pol4",				false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					20,		daCenter,		true,			"polyd4",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					50,		daCenter,		true,			"pod4",				false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					20,		daCenter,		true,			"podyd4",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					50,		daCenter,		true,			"pod_cd",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					20,		daCenter,		true,			"pod_nod_cd",		false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					50,		daCenter,		true,			"del_cd",			false,		"",					dfNone,				0,					false,				false);
 					 InitDataProperty(0, 	cnt++ , 	dtData,					20,		daCenter,		true,			"del_nod_cd",		false,		"",					dfNone,				0,					false,				false); 					 
 					 
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"bkg_trunk_vvd",	false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"pre_rly_port_cd",	false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"pst_rly_port_cd",	false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"ocp_cd",			false,		"",					dfNone,				0,					false,				false); 			
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"mty_pkup_yd_cd",	false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"full_rtn_yd_cd",	false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"mty_pkup_dt",		false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"org_trns_mod_cd",	false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"lodg_due_dt",		false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"mty_dor_arr_dt",	false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"full_pkup_yd_cd",	false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"mty_rtn_yd_cd",	false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"dest_trns_mod_cd",	false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"de_due_dt",		false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"rcv_term_cd",		false,		"",					dfNone,				0,					false,				false);
 					InitDataProperty(0, 	cnt++ , 	dtHidden,				20,		daCenter,		true,			"de_term_cd",		false,		"",					dfNone,				0,					false,				false); 					
		
 					
 					InitDataCombo(0, "org", "Y|N", "Y|N");
 					InitDataCombo(0, "dest", "Y|N", "Y|N");
 					 CountPosition = 0;
 				}
 				break;
 		}
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
 			case IBSEARCH:      //조회
 				ComSetObjValue(formObj.f_cmd, SEARCH);
 				var sXml = sheetObj.GetSearchXml("ESM_BKG_1024GS.do", FormQueryString(formObj));    	
 				var arrXml = sXml.split("|$$|");  
				if (arrXml.length > 0){	
					var saveName = ComGetEtcData(arrXml[0], "SaveName");
					
					sheetObj.RemoveAll();
					sheetObj.Reset();
					initSheet(sheetObjects[0],1,saveName);
					
					sheetObjects[0].LoadSearchXml(arrXml[0]);
					
					sheetObjects[0].FitColWidth();
					
					sheetObj.RowFontColor(sheetObj.FindText("bkg_no",ComGetObjValue(formObj.bkg_no))) = sheetObj.RgbColor(0,0,255);
					sheetObj.CellFont("FontBold", sheetObj.FindText("bkg_no",ComGetObjValue(formObj.bkg_no)),0) = true;
				}             		
				
				if (arrXml.length > 1){	
					sheetObjects[1].LoadSearchXml(arrXml[1]);
				}      				
				// ** 기준 Booking정보(Booking Main의 정보)를 맨 첫Line에 Display한다 (Start)***
				var mainSheetObj = window.dialogArguments.sheetObjects[1];
				var mainFormObj = window.dialogArguments.document.form;         				

				sheetObjects[1].DataInsert(0);
				var addRow = sheetObjects[1].HeaderRows;
				sheetObjects[1].RowEditable(addRow) = false;
				sheetObjects[1].CellValue(addRow,"bkg_no") = ComGetObjValue(formObj.bkg_no);
				sheetObjects[1].CellValue(addRow,"org") = "";
				sheetObjects[1].CellValue(addRow,"dest") = "";				
				sheetObjects[1].CellValue(addRow,"por_cd") = ComGetObjValue(mainFormObj.bkg_por_cd);
				sheetObjects[1].CellValue(addRow,"por_nod_cd") = ComGetObjValue(mainFormObj.bkg_por_yd_cd);
				sheetObjects[1].CellValue(addRow,"pol_cd") = ComGetObjValue(mainFormObj.bkg_pol_cd);
				sheetObjects[1].CellValue(addRow,"pol_nod_cd") = ComGetObjValue(mainFormObj.bkg_pol_yd_cd);				
				var idx = 1;
				for(var i = mainSheetObj.HeaderRows; i < mainSheetObj.Rows; i++){
					sheetObjects[1].CellValue(addRow,"vvd"+idx) = mainSheetObj.CellValue(i,"bkg_vvd_cd");
					sheetObjects[1].CellValue(addRow,"pol"+idx) = mainSheetObj.CellValue(i,"pol_cd");
					sheetObjects[1].CellValue(addRow,"polyd"+idx) = mainSheetObj.CellValue(i,"pol_yd_cd");
					sheetObjects[1].CellValue(addRow,"pod"+idx) = mainSheetObj.CellValue(i,"pod_cd");
					sheetObjects[1].CellValue(addRow,"podyd"+idx) = mainSheetObj.CellValue(i,"pod_yd_cd");
					idx++;
				}
				// Main에 있는 정보를 가져온다.
				sheetObjects[1].CellValue(addRow,"pod_cd") = ComGetObjValue(mainFormObj.bkg_pod_cd);
				sheetObjects[1].CellValue(addRow,"pod_nod_cd") = ComGetObjValue(mainFormObj.bkg_pod_yd_cd);
				sheetObjects[1].CellValue(addRow,"del_cd") = ComGetObjValue(mainFormObj.bkg_del_cd);
				sheetObjects[1].CellValue(addRow,"del_nod_cd") = ComGetObjValue(mainFormObj.bkg_del_yd_cd);	
				
				sheetObjects[1].CellValue(addRow,"bkg_trunk_vvd") = ComGetObjValue(mainFormObj.bkg_trunk_vvd);
				sheetObjects[1].CellValue(addRow,"pre_rly_port_cd") = ComGetObjValue(mainFormObj.pre_rly_port_cd);
				sheetObjects[1].CellValue(addRow,"pst_rly_port_cd") = ComGetObjValue(mainFormObj.pst_rly_port_cd);
				sheetObjects[1].CellValue(addRow,"ocp_cd") = ComGetObjValue(mainFormObj.ocp_cd);
				sheetObjects[1].CellValue(addRow,"mty_pkup_yd_cd") = ComGetObjValue(mainFormObj.mty_pkup_yd_cd);
				sheetObjects[1].CellValue(addRow,"full_rtn_yd_cd") = ComGetObjValue(mainFormObj.full_rtn_yd_cd);
				sheetObjects[1].CellValue(addRow,"mty_pkup_dt") = ComGetObjValue(mainFormObj.mty_pkup_dt);
				sheetObjects[1].CellValue(addRow,"org_trns_mod_cd") = ComGetObjValue(mainFormObj.org_trns_mod_cd);
				sheetObjects[1].CellValue(addRow,"lodg_due_dt") = ComGetObjValue(mainFormObj.lodg_due_dt);
				sheetObjects[1].CellValue(addRow,"mty_dor_arr_dt") = ComGetObjValue(mainFormObj.mty_dor_arr_dt);
				sheetObjects[1].CellValue(addRow,"full_pkup_yd_cd") = ComGetObjValue(mainFormObj.full_pkup_yd_cd);
				sheetObjects[1].CellValue(addRow,"mty_rtn_yd_cd") = ComGetObjValue(mainFormObj.mty_rtn_yd_cd);
				sheetObjects[1].CellValue(addRow,"dest_trns_mod_cd") = ComGetObjValue(mainFormObj.dest_trns_mod_cd);
				sheetObjects[1].CellValue(addRow,"de_due_dt") = ComGetObjValue(mainFormObj.de_due_dt);
				sheetObjects[1].CellValue(addRow,"rcv_term_cd") = ComGetObjValue(mainFormObj.rcv_term_cd);
				sheetObjects[1].CellValue(addRow,"de_term_cd") = ComGetObjValue(mainFormObj.de_term_cd);				
				// ** 기준 Booking정보(Booking Main의 정보)를 맨 첫Line에 Display한다.(End)***
				// ** 기준 Booking정보의 TS Route 정보를 다른 Booking에 Copy한다 (Start).
				var startIdx = sheetObjects[1].HeaderRows;
				for(var i = startIdx+1; i < sheetObjects[1].Rows; i++){
					sheetObjects[1].CellValue(i,"vvd1") = sheetObjects[1].CellValue(startIdx,"vvd1");
					sheetObjects[1].CellValue(i,"pol1") = sheetObjects[1].CellValue(startIdx,"pol1");
					sheetObjects[1].CellValue(i,"polyd1") = sheetObjects[1].CellValue(startIdx,"polyd1");
					sheetObjects[1].CellValue(i,"pod1") = sheetObjects[1].CellValue(startIdx,"pod1");
					sheetObjects[1].CellValue(i,"podyd1") = sheetObjects[1].CellValue(startIdx,"podyd1");			
					sheetObjects[1].CellValue(i,"vvd2") = sheetObjects[1].CellValue(startIdx,"vvd2");
					sheetObjects[1].CellValue(i,"pol2") = sheetObjects[1].CellValue(startIdx,"pol2");
					sheetObjects[1].CellValue(i,"polyd2") = sheetObjects[1].CellValue(startIdx,"polyd2");
					sheetObjects[1].CellValue(i,"pod2") = sheetObjects[1].CellValue(startIdx,"pod2");
					sheetObjects[1].CellValue(i,"podyd2") = sheetObjects[1].CellValue(startIdx,"podyd2");	
					sheetObjects[1].CellValue(i,"vvd3") = sheetObjects[1].CellValue(startIdx,"vvd3");
					sheetObjects[1].CellValue(i,"pol3") = sheetObjects[1].CellValue(startIdx,"pol3");
					sheetObjects[1].CellValue(i,"polyd3") = sheetObjects[1].CellValue(startIdx,"polyd3");
					sheetObjects[1].CellValue(i,"pod3") = sheetObjects[1].CellValue(startIdx,"pod3");
					sheetObjects[1].CellValue(i,"podyd3") = sheetObjects[1].CellValue(startIdx,"podyd3");	
					sheetObjects[1].CellValue(i,"vvd4") = sheetObjects[1].CellValue(startIdx,"vvd4");
					sheetObjects[1].CellValue(i,"pol4") = sheetObjects[1].CellValue(startIdx,"pol4");
					sheetObjects[1].CellValue(i,"polyd4") = sheetObjects[1].CellValue(startIdx,"polyd4");
					sheetObjects[1].CellValue(i,"pod4") = sheetObjects[1].CellValue(startIdx,"pod4");
					sheetObjects[1].CellValue(i,"podyd4") = sheetObjects[1].CellValue(startIdx,"podyd4");		

					sheetObjects[1].CellValue(i,"bkg_trunk_vvd") = sheetObjects[1].CellValue(startIdx,"bkg_trunk_vvd");
					sheetObjects[1].CellValue(i,"pre_rly_port_cd") = sheetObjects[1].CellValue(startIdx,"pre_rly_port_cd");
					sheetObjects[1].CellValue(i,"pst_rly_port_cd") = sheetObjects[1].CellValue(startIdx,"pst_rly_port_cd");						
				}
				// ** 기준 Booking정보의 TS Route 정보를 다른 Booking에 Copy한다 (End).								
 				break;

 			case IBSAVE:        //저장
 				ComSetObjValue(formObj.f_cmd, MULTI);					
 				var params = FormQueryString(formObj);	
 				params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true),"sheet2_");
 				var mainSheetObj = window.dialogArguments.sheetObjects[1];
 				
				var startIdx = sheetObjects[1].HeaderRows;
				for(var i = startIdx+1; i < sheetObjects[1].Rows; i++){
					if(sheetObjects[1].CellValue(i,"vvd1")==null||(ComChkLen(sheetObjects[1].CellValue(i, "vvd1"),9)<2)){
						ComShowCodeMessage('BKG00144', 1);
						return false;
					}

					if(sheetObjects[1].CellValue(i,"bkg_trunk_vvd")==null||(ComChkLen(sheetObjects[1].CellValue(i, "bkg_trunk_vvd"),9)<2)){
						ComShowCodeMessage("BKG00051", sheetObjects[1].CellValue(i, "bkg_vvd_cd"));
						return false;
					}
				}
				
 				params = params + "&" + ComSetPrifix(mainSheetObj.GetSaveString(true),"sheetM_");
 				var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_1024GS.do", params);	
 				sheetObjects[1].LoadSearchXml(sXml);

 				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
 					window.close();
 			 		var calllFunc = ComGetObjValue(formObj.func);
 			 		
 					if(calllFunc != ''){
 						eval('window.dialogArguments.'+calllFunc)();
 					}
 				}

 				break;
         }
     }
     /**
     * Sheet2 변경시
     */
 	function sheet2_OnChange(sheetObj, Row, Col, Value)
	{
		var formObject = document.form;		
		var saveName = sheetObj.ColSaveName(Col);
		if(saveName == "org"){
			if(sheetObj.CellValue(Row, Col) == "Y"){
				sheetObj.CellValue2(Row, "por_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "por_cd");
				sheetObj.CellValue2(Row, "por_nod_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "por_nod_cd");
				sheetObj.CellValue2(Row, "pol_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "pol_cd");
				sheetObj.CellValue2(Row, "pol_nod_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "pol_nod_cd");
				
				sheetObj.CellValue2(Row, "mty_pkup_yd_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "mty_pkup_yd_cd");
				sheetObj.CellValue2(Row, "full_rtn_yd_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "full_rtn_yd_cd");
				sheetObj.CellValue2(Row, "mty_pkup_dt") = sheetObj.CellValue(sheetObj.HeaderRows, "mty_pkup_dt");
				sheetObj.CellValue2(Row, "org_trns_mod_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "org_trns_mod_cd");
				sheetObj.CellValue2(Row, "lodg_due_dt") = sheetObj.CellValue(sheetObj.HeaderRows, "lodg_due_dt");
				sheetObj.CellValue2(Row, "mty_dor_arr_dt") = sheetObj.CellValue(sheetObj.HeaderRows, "mty_dor_arr_dt");
				sheetObj.CellValue2(Row, "rcv_term_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "rcv_term_cd");
			}else{
				sheetObj.CellValue2(Row, "por_cd") = sheetObj.CellSearchValue(Row, "por_cd");
				sheetObj.CellValue2(Row, "por_nod_cd") = sheetObj.CellSearchValue(Row, "por_nod_cd");
				sheetObj.CellValue2(Row, "pol_cd") = sheetObj.CellSearchValue(Row, "pol_cd");
				sheetObj.CellValue2(Row, "pol_nod_cd") = sheetObj.CellSearchValue(Row, "pol_nod_cd");
				
				sheetObj.CellValue2(Row, "mty_pkup_yd_cd") = sheetObj.CellSearchValue(Row, "mty_pkup_yd_cd");
				sheetObj.CellValue2(Row, "full_rtn_yd_cd") = sheetObj.CellSearchValue(Row, "full_rtn_yd_cd");
				sheetObj.CellValue2(Row, "mty_pkup_dt") = sheetObj.CellSearchValue(Row, "mty_pkup_dt");
				sheetObj.CellValue2(Row, "org_trns_mod_cd") = sheetObj.CellSearchValue(Row, "org_trns_mod_cd");
				sheetObj.CellValue2(Row, "lodg_due_dt") = sheetObj.CellSearchValue(Row, "lodg_due_dt");
				sheetObj.CellValue2(Row, "mty_dor_arr_dt") = sheetObj.CellSearchValue(Row, "mty_dor_arr_dt");
				sheetObj.CellValue2(Row, "rcv_term_cd") = sheetObj.CellSearchValue(Row, "rcv_term_cd");				
			}
		}else if(saveName == "dest"){
			if(sheetObj.CellValue(Row, Col) == "Y"){
				sheetObj.CellValue2(Row, "pod_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "pod_cd");
				sheetObj.CellValue2(Row, "pod_nod_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "pod_nod_cd");
				sheetObj.CellValue2(Row, "del_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "del_cd");
				sheetObj.CellValue2(Row, "del_nod_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "del_nod_cd");
				
				sheetObj.CellValue2(Row, "full_pkup_yd_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "full_pkup_yd_cd");
				sheetObj.CellValue2(Row, "mty_rtn_yd_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "mty_rtn_yd_cd");
				sheetObj.CellValue2(Row, "dest_trns_mod_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "dest_trns_mod_cd");
				sheetObj.CellValue2(Row, "org_trns_mod_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "de_due_dt");
				sheetObj.CellValue2(Row, "de_term_cd") = sheetObj.CellValue(sheetObj.HeaderRows, "de_term_cd");
			}else{
				sheetObj.CellValue2(Row, "pod_cd") = sheetObj.CellSearchValue(Row, "pod_cd");
				sheetObj.CellValue2(Row, "pod_nod_cd") = sheetObj.CellSearchValue(Row, "pod_nod_cd");
				sheetObj.CellValue2(Row, "del_cd") = sheetObj.CellSearchValue(Row, "del_cd");
				sheetObj.CellValue2(Row, "del_nod_cd") = sheetObj.CellSearchValue(Row, "del_nod_cd");

				sheetObj.CellValue2(Row, "full_pkup_yd_cd") = sheetObj.CellSearchValue(Row, "full_pkup_yd_cd");
				sheetObj.CellValue2(Row, "mty_rtn_yd_cd") = sheetObj.CellSearchValue(Row, "mty_rtn_yd_cd");
				sheetObj.CellValue2(Row, "dest_trns_mod_cd") = sheetObj.CellSearchValue(Row, "dest_trns_mod_cd");
				sheetObj.CellValue2(Row, "de_due_dt") = sheetObj.CellSearchValue(Row, "de_due_dt");
				sheetObj.CellValue2(Row, "de_term_cd") = sheetObj.CellSearchValue(Row, "de_term_cd");				
			}			
		}
	}	
 	
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }

	/* 개발자 작업  끝 */