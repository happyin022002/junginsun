/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0073.js
*@FileTitle : BDR Time Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.28 김기종
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.09.21 김보배 [CHM-201220220] [BKG] Manual BDR 화면 POL display 순서 변경 요청
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
     * @class esm_bkg_0073 : esm_bkg_0073 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0073() {
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
          var sheetObject = sheetObjects[0];
          var sheetObject1 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 				switch(srcName) {

 						case "btn_RowAdd1":
 								doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
 								break;
 								
 						case "btn_DeleteRow1":
 								doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
 								break;
 								
 						case "btn_Retrieve":
 								doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
 								break;
 								
 						case "btn_Save":
 								doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
 								break;
 						
 						case "btn_Creation":
								doActionIBSheet(sheetObjects[0], formObject, IBCREATE);
								break;
								
 						case "btn_com_ens_ob2_pop":
 								openWindowVvd(formObject) 
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
 		
         doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
         initControl();
 		 checkOption();
		 	
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
     	var formObject = document.form;
     	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	axon_event.addListenerForm  ('beforedeactivate', 'getVvdPortList',  formObject); //- 포커스 나갈때
     }
     
     function checkOption(){
    	 var formObject = document.form;
    	 var flag = ComGetObjValue(formObject.opt_sel_bdr);
    	 
    	 if (flag == "VVD"){
    		 
    		/* VVD일때 필수입력 항목*/
    		 formObject.cb_slan_cd.required = null;
    		 formObject.cb_slan_cd.BackColor = "white";
    		 
    		 formObject.cb_skd_dir_cd.required = null;
    		 formObject.cb_skd_dir_cd.BackColor = "white";
    		 
    		 formObject.cb_pol_cd.required = null;
    		 formObject.cb_pol_cd.BackColor = "white";
    		 
    		 formObject.vvd.required = true;
    		 formObject.vvd.className = "input1";
    		 
    		 formObject.pol_cd.required = true;
    		 formObject.pol_cd.BackColor = "#CCFFFD";
    		 
    		
    		 searchTable[0].style.display ="none";
    		 searchTable[1].style.display ="";
    		 
    		 /*ComSetObjValue(formObject.vvd,"");
    		 ComSetObjValue(formObject.pol_cd,"");
    		 ComSetObjValue(formObject.pod_cd,"");
    		 
    		 ComSetObjValue(formObject.slan_cd,"");
    		 ComSetObjValue(formObject.etd_cd,"");*/
    		 
    		 mainTable[0].style.display ="none";
 	     	 mainTable[1].style.display ="inline";
 			
 	     	 if (location.href.indexOf("Q") < 0){
 	     		 rowButtonTable.style.display ="none";
	 	     	 ComShowObject(getButtonTable("btn_Creation"),true);
 	     	 }
    	 }else{
    		 /* Lane 일때 필수입력 항목*/
    		 formObject.cb_slan_cd.required = true;
    		 formObject.cb_slan_cd.BackColor = "#CCFFFD";
    		 
    		 formObject.cb_skd_dir_cd.required = true;
    		 formObject.cb_skd_dir_cd.BackColor = "#CCFFFD";
    		 
    		 formObject.cb_pol_cd.required = true;
    		 formObject.cb_pol_cd.BackColor = "#CCFFFD";
    		 
    		 
    		 formObject.vvd.required = null;
    		 formObject.vvd.className = "input";
    		 
    		 formObject.pol_cd.required = null;
    		 formObject.pol_cd.BackColor = "white";
    		 
    		
    		 searchTable[0].style.display ="";
    		 searchTable[1].style.display ="none";
    		 
    		 /*ComSetObjValue(formObject.cb_slan_cd,"");
    		 ComSetObjValue(formObject.cb_skd_dir_cd,"");
    		 ComSetObjValue(formObject.cb_pol_cd,"");*/
    		 

    		 mainTable[0].style.display ="inline";
 	     	 mainTable[1].style.display ="none";
 			
 	     	if (location.href.indexOf("Q") < 0){
 	     		rowButtonTable.style.display ="";
 	     		ComShowObject(getButtonTable("btn_Creation"),false);
 	     	}
    	 }
    	 
    	 /*sheetObjects[0].RemoveAll();
    	 sheetObjects[1].RemoveAll();*/
     }
     
     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
    	 var prefix ="";
         var cnt = 0;
 				var sheetId = sheetObj.id;

         switch(sheetId) {

             case "sheet1":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 420;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);

 					 var HeadTitle1 = "|Del.|POD|Trunk Time|FDR Time|User|Office|Date|||";
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     
                     //prefix = "sheet1_";
                     //데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, 		COLMERGE, 	SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    InitDataProperty(0, 	cnt++ , dtHiddenStatus,		30,		daCenter,	true,	prefix +  "ibflag");
					InitDataProperty(0,		cnt++,	dtDelCheck,			40, 	daCenter,	false,	prefix +  "del_chk",        false,		"",		dfNone,					0,		true);                    
						
					InitDataProperty(0, cnt++ , dtCombo,		120,	daCenter,		false,		prefix + "pod_cd",			true,		"",		dfEngUpKey,					0,		true,		true,5);
					InitDataProperty(0, cnt++ , dtData,			210,	daCenter,		false,		prefix + "trnk_bdr_dys",	true,		"",		dfInteger,					0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			180,	daCenter,		false,		prefix + "fdr_bdr_dys",		true,		"",		dfInteger,					0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			140,	daCenter,		false,		prefix + "upd_usr_id",		false,		"",		dfNone,					0,		false,		false);

					InitDataProperty(0, cnt++ , dtData,			140,	daCenter,		false,		prefix + "ofc_cd",			false,		"",		dfNone,					0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		false,		prefix + "upd_dt",			false,		"",		dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			140,	daCenter,		false,		prefix + "slan_cd",			false,		"",		dfNone,					0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			140,	daCenter,		false,		prefix + "skd_dir_cd",		false,		"",		dfNone,					0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			140,	daCenter,		false,		prefix + "pol_cd",			false,		"",		dfNone,					0,		false,		true);
					
					FocusEditMode = -1;
					SelectionMode =smSelectionCol;
					//CountPosition = 0;

				}
				break;

             case "sheet2":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 420;
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

					 var HeadTitle1 = "|POD|Trunk-Base BDR|Trunk-Base BDR|Trunk-Base BDR|Trunk-Base BDR|Trunk-Base BDR|First-Base BDR|First-Base BDR|First-Base BDR|First-Base BDR|First-Base BDR|Update Date|||||";
					 var HeadTitle2 = "|POD|Original BDR\n(BKG POL Local Time)|New BDR|BDR|A/M|Adjusted by|Original BDR\n(BKG POL Local Time)|New BDR|BDR|A/M|Adjusted by|Update Date|||||";
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //prefix = "sheet2_";
                     //데이터속성    [ROW, COL,  DATATYPE,   				WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, 	cnt++ , dtHiddenStatus,		30,		daCenter,	true,	prefix +  "ibflag"); 
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		false,		prefix + "pod_cd",				false,		"",		dfEngUpKey,		0,		false,		true,5);
					
					InitDataProperty(0, cnt++ , dtData,					130,	daCenter,		false,		prefix + "trnk_estm_bdr_dt",	false,		"",		dfDateYmd,		0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		false,		prefix + "trnk_mnl_bdr_dt",		false,		"",		dfDateYmd,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					35,		daCenter,		false,		prefix + "trnk_bdr_flg",		false,		"",		dfNone,			0,		false,	true);
					
					InitDataProperty(0, cnt++ , dtData,					35,		daCenter,		false,		prefix + "trnk_auto_bdr_flg",	false,		"",		dfNone,			0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		false,		prefix + "trnk_bdr_cre_usr_id",	false,		"",		dfNone,			0,		false,	true);
					
					InitDataProperty(0, cnt++ , dtData,					130,	daCenter,		false,		prefix + "fdr_estm_bdr_dt",		false,		"",		dfDateYmd,		0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		false,		prefix + "fdr_mnl_bdr_dt",		false,		"",		dfDateYmd,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					35,		daCenter,		false,		prefix + "fdr_bdr_flg",			false,		"",		dfNone,			0,		false,	true);
					
					InitDataProperty(0, cnt++ , dtData,					35,		daCenter,		false,		prefix + "fdr_auto_bdr_flg",	false,		"",		dfNone,			0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		false,		prefix + "fdr_bdr_cre_usr_id",	false,		"",		dfNone,			0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,		prefix + "fdr_bdr_upd_dt",		false,		"",		dfNone,			0,		false,	true);
					
					InitDataProperty(0, cnt++ , dtHidden,					100,	daCenter,	true,		prefix + "vsl_cd",				false,		"",		dfNone,			0,		false,	true);
					InitDataProperty(0, cnt++ , dtHidden,					100,	daCenter,	true,		prefix + "skd_voy_no",			false,		"",		dfNone,			0,		false,	true);
					InitDataProperty(0, cnt++ , dtHidden,					100,	daCenter,	true,		prefix + "skd_dir_cd",			false,		"",		dfNone,			0,		false,	true);
					InitDataProperty(0, cnt++ , dtHidden,					100,	daCenter,	true,		prefix + "pol_cd",				false,		"",		dfNone,			0,		false,	true);
					InitDataProperty(0, cnt++ , dtHidden,					100,	daCenter,	true,		prefix + "pod_clpt_ind_seq",		false,		"",		dfNone,			0,		false,	true);
					
					FocusEditMode = -1;
					//CountPosition = 0;

				}
				break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         var prefix = ""; //sheetObj.id +"_";
         
         switch(sAction) {
          
           case IBCLEAR: // 화면 로딩시 코드 조회
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0073GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
					
				if (arrXml.length > 1) 
					ComBkgXml2ComboItem(arrXml[1], formObj.cb_skd_dir_cd, "val", "name");
				if (arrXml.length > 0) 
					ComBkgXml2ComboItem(arrXml[0], formObj.cb_slan_cd, "vsl_slan_cd", "vsl_slan_nm");
				
				formObj.cb_slan_cd.DropHeight = 200;
				formObj.cb_slan_cd.UseAutoComplete = true;
				formObj.cb_skd_dir_cd.DropHeight = 100;
				sheetObj.DataAutoTrim = true;	
				
				formObj.cb_pol_cd.DropHeight = 200;
				formObj.cb_pol_cd.UseAutoComplete = true;
				
				formObj.cb_slan_cd.required = true;
				formObj.cb_slan_cd.caption="Lane";
				formObj.cb_skd_dir_cd.required = true;
				formObj.cb_skd_dir_cd.caption="Bound";
				formObj.cb_pol_cd.required = true;
				formObj.cb_pol_cd.caption="POL";
				
				break;	
           case IBSEARCH:      //조회
	          if(validateForm(sheetObj,formObj,sAction)){
	        	  formObj.f_cmd.value = SEARCH;
	        	  var sXml = sheetObj.GetSearchXml("ESM_BKG_0073GS.do", FormQueryString(formObj));
				  var arrXml = sXml.split("|$$|");
				  
				  if (ComGetObjValue(formObj.opt_sel_bdr) == "VVD"){
					  sheetObjects[1].LoadSearchXml(arrXml[0]); 
				  }else{

					  sheetObjects[0].LoadSearchXml(arrXml[0]); 
					 
				  }
	          }	
               	break;

	 		case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI;
					var sParam = ComGetSaveString(sheetObj);
					sParam += "&" + FormQueryString(formObj);
					
					if (ComGetObjValue(formObj.opt_sel_bdr) == "VVD"){
						sParam += "&" + ComSetPrifix(sheetObjects[1].GetSaveString(), "sheet2_");
						sheetObjects[1].DoSave("ESM_BKG_0073GS.do", sParam);
						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					}else{
						var rowM = sheetObjects[0].ColValueDup("pod_cd");
						if (rowM >= 0) {
							 ComShowCodeMessage("BKG00828", "Sheet", rowM);
						     return false;
					    }
						sParam += "&" + ComSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_");
						
						sheetObjects[0].DoSave("ESM_BKG_0073GS.do", sParam);
						/*
						var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0073GS.do", sParam);
						sheetObjects[0].LoadSaveXml(sXml);*/
						
					}
				}
				break;
	 		case IBCREATE:        //BDR LOG CREATION
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = COMMAND01;
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0073GS.do", FormQueryString(formObj));
					sheetObjects[0].LoadSaveXml(sXml);
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				}
				break;	
				
			case IBINSERT:      // 입력
				if(validateForm(sheetObj,formObj,sAction)){
					
					sheetObj.WaitImageVisible = true;
					getPortList(SEARCH05);
					
					//신규행 추가
	 				sheetObj.DataInsert(-1);
	 				sheetObj.CellValue2(sheetObj.RowCount, prefix +"slan_cd") 		= ComGetObjValue(formObj.cb_slan_cd);
	 				sheetObj.CellValue2(sheetObj.RowCount, prefix +"skd_dir_cd") 	= ComGetObjValue(formObj.cb_skd_dir_cd);
	 				sheetObj.CellValue2(sheetObj.RowCount, prefix +"pol_cd")	 	= ComGetObjValue(formObj.cb_pol_cd);
	 				sheetObj.SelectCell(sheetObj.RowCount,"pod_cd");
	 				sheetObj.WaitImageVisible = false;
				}
				break;
			case IBDELETE:      // 삭제
				//행 삭제 FLAG처리
				//sheetObj.CellValue2(sheetObj.SelectRow, prefix+"ibflag") = "D";
				ComRowHideDelete(sheetObj, prefix+"del_chk");
				break;	
         }
     }
     function cb_skd_dir_cd_OnChange(comboObj,value,text){
    	 getPortList(SEARCH03);
     }
     function cb_pol_cd_OnChange(comboObj,value,text){
    	 sheetObjects[0].RemoveAll();
    	 getPortList(SEARCH05);
		 sheetObjects[0].DataAutoTrim = true;
		  
     }
     
     function getPortList(val){
    	var formObj = document.form;
    	
    	if (ComGetObjValue(formObj.cb_slan_cd) == "" || ComGetObjValue(formObj.cb_skd_dir_cd) == ""){
    		return;
    	}
    	
    	formObj.f_cmd.value = val;
		var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0073GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		
		if (arrXml.length < 1) return; 
		if (val == SEARCH03 ){
			ComBkgXml2ComboItem(arrXml[0], formObj.cb_pol_cd, "port_cd", "port_cd");
		}else if (val == SEARCH05 ){
			arrXml[0] = ComReplaceStr(arrXml[0], "port_cd", "val");
			setIBCombo(sheetObjects[0], arrXml[0], "pod_cd", true, "", "","","val");
		}
     }
     
     function getVvdPortList(){
      	var formObj = document.form;
      	
      	if (ComGetObjValue(formObj.vvd) == "" || ComGetObjValue(formObj.vvd).length != 9 ){
      		return;
      	}
      	switch( event.srcElement.name ){
      		case "vvd":
	 	 		formObj.f_cmd.value = SEARCH04;
	 	 		
	 	 		var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0073GS.do", FormQueryString(formObj));
	 	 		
	 	 		var arrXml = sXml.split("|$$|");
	 	 			  
	 	 		if (arrXml.length > 0) {
	 	 			ComBkgXml2ComboItem(arrXml[0], formObj.pol_cd, "vps_port_cd", "opt_disp");
	 	 			ComBkgXml2ComboItemSort(arrXml[0], formObj.pod_cd, "vps_port_cd", "vps_port_cd", true);
	 	 			//formObj.pol_cd.InsertItem(0, '', '');
		 	 		formObj.pod_cd.InsertItem(0, '', '');
	 	 			formObj.pol_cd.Index  = 0;
	 	 			formObj.pod_cd.Index  = 0;
	 	 		}	
	 	 		
 		 	break;	
      	}	
     }
     function selVvdPortVal(){
    	 var formObj = document.form;
    	 
    	 var lane = formObj.pol_cd.GetText(ComGetObjValue(formObj.pol_cd),1);
    	 
    	 var etd = formObj.pol_cd.GetText(ComGetObjValue(formObj.pol_cd),2);
    	 
    	 ComSetObjValue(formObj.slan_cd,lane);
    	 ComSetObjValue(formObj.etd_cd,etd);
     }
     function openWindowVvd(formObj) {
    	 var param;
    	
   		param = "loc_cd="+ComGetObjValue(formObj.pol_cd);
   	 
   		param = param + "&" + "pod_cd="+ComGetObjValue(formObj.pod_cd);
   		param = param + "&" + "lane_cd="+ComGetObjValue(formObj.slan_cd);
   		param = param + "&" + "vvd_cd="+formObj.vvd.value;
   		param = param + "&" + "etd_cd="+formObj.etd_cd.value;
		
   		ComOpenPopup('/hanjin/COM_ENS_0B2.do?' + param, 750, 450, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
  	 }
     
     /**
   	 * Vessel SKD & Code Inquiry부분.<br>
   	 * @param {arry} aryPopupData
   	 */
   	function setCallBack0B2(aryPopupData) {
   		var formObject = document.form;
   		formObject.vvd.value = aryPopupData[0][7];
   		formObject.slan_cd.value = aryPopupData[0][3];
   		formObject.pol_cd.value = aryPopupData[0][4];
   		formObject.etd_cd.value = ComGetMaskedValue(aryPopupData[0][5], "ymd");
   		
   	} 
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction) {
         	case IBSEARCH: // 화면 로딩시 코드 조회
         		if (!ComChkValid(formObj)) return false;
         		break;
         	case IBINSERT: // 화면 로우 추가시
	     		if (!ComChkValid(formObj)) return false;
	     		break;	
    	 }

         return true;
     }
      function sheet1_OnSaveEnd(sheetObj, ErrMsg){
  		with(sheetObj){
  			  for (i=HeaderRows ; i<= LastRow; i++) {
  				CellEditable(i,"pod_cd") = false;
  			  }
  		}
      }	
      function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	  with(sheetObj){
  			  for (i=HeaderRows ; i<= LastRow; i++) {
  				CellEditable(i,"pod_cd") = false;
  			  }
  		 }  
      }
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj){
			
			  for (i=2; i<= LastRow; i++) {
				  if (CellText(i,"trnk_bdr_flg") == 'Y'){
					  CellEditable(i,"trnk_mnl_bdr_dt") = false;
				  }
				  if (CellText(i,"fdr_bdr_flg") == 'Y'){
					  CellEditable(i,"fdr_mnl_bdr_dt") = false;
				  }
				  
			  }
			 
		}
	}
	
	/* 개발자 작업  끝 */