/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1032.js
*@FileTitle : ESM_BKG_1032
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.20 경종윤
* 1.0 Creation
* -------------------------------------------------------
* history
* 2011.02.28 김영철 [] Transmit History (ESM_BKG_1032) 화면에서 조건 추가 ( VVD )
* 2014.12.29 [CHM-201432728] [IE 세관] 시스템 추가 보완 요청 사항
* 2015.06.11 [CHM-201536165] APERAK EDI DAKOSY / SM Line - NSW Germany - RFD
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
     * @class ESM_BKG_1032 : ESM_BKG_1032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1032() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    // 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    
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

     			case "btn_retrieve":
     				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     				
     				break;
					
     			case "btn_calendar":
     				var cal = new ComCalendarFromTo();
     				cal.select(formObject.s_vps_eta_dt, formObject.e_vps_eta_dt, 'yyyy-MM-dd');
     				break;

     			case "btn_exceldown":
     				doActionIBSheet(sheetObjects[0],document.form,"btn_exceldown","","");
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
     * 콤보 Object를 comboObjects 배열에 등록
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj; 
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
             
            ComEndConfigSheet(sheetObjects[i]);
        }
         
 		//MultiCombo초기화 -- 2014.12.29 추가
        for(var k=0;k<comboObjects.length;k++){
 	        initCombo(comboObjects[k],comboObjects[k].id);
 	    }
 	    
		//화면에서 필요한 이벤트
    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('click', 'obj_click', document.form); // click

    	//초기셋팅
    	initPage();

    }


  	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
  	* @param {String} comboId 필수,combo ID
  	* @return 없음. 
   	 */ 
   	function initCombo(comboObj, comboId) {
   	    var formObject = document.form
   	    
   	    var cnt = 0;	
   		switch(comboObj.id) {
 	  		case "p_type":
 	  			with (comboObj) {
 		 			DropHeight = 300;
 					MultiSelect = false;
 					UseEdit = false;
 					InsertItem(cnt ++, "ALL",  "ALL");
 					InsertItem(cnt ++, "IE Manifest", "IE");
 					InsertItem(cnt ++, "APERAK", "APE"); // Add. 2015.06.11 
 					Code = "ALL";				
 	  			}
   			break;    	            
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
             case 1:      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 380;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 15, 100);


                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "|Seq.|Message Type|Massage Update|Acknowledge Type|Acknowledge Result|Acknowledge Date|Approve Date|B/L No.|Container No.|Partial|VVD|VVD|I/O|PORT Code|Reject Reason|Accept Reference No.|Declaration No.";

					 var headCount = ComCountHeadTitle(HeadTitle1);

					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					 InitColumnInfo(headCount, 0, 0, true);
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
	                 InitDataProperty(0, cnt++ , dtSeq,  30,     daCenterTop, 	 true,     "seq");
	                 InitDataProperty(0, cnt++ , dtData, 105,    daCenterTop, 	 true,     "org_msg_tp_id",      		false,       "",      dfNone,      	0,     false,		false);
	                 InitDataProperty(0, cnt++ , dtData, 125,    daCenterTop, 	 true,     "msg_func_id",  				false,       "",      dfNone,      	0,     false,		false);
	                 InitDataProperty(0, cnt++ , dtData, 125,    daCenterTop, 	 true,     "ack_knd_id",				false,       "",      dfNone,      	0,     false,		false);
	                 InitDataProperty(0, cnt++ , dtData, 125,    daCenterTop, 	 true,     "ack_rcv_sts_cd",   			false,       "",      dfNone,   	0,     false,		false);
	
	                 InitDataProperty(0, cnt++ , dtData, 125,    daCenterTop, 	 true,     "ack_dt",   					false,       "",      dfUserFormat2,0,     false,		false);
	                 InitDataProperty(0, cnt++ , dtData, 125,    daCenterTop, 	 true,     "apro_dt",      				false,       "",      dfUserFormat2,0,     false,		false);
	                 InitDataProperty(0, cnt++ , dtData, 125,    daCenterTop, 	 true,     "bl_no",  					false,       "",      dfNone,      	0,     false,		false);
	                 InitDataProperty(0, cnt++ , dtData, 125,    daCenterTop, 	 true,     "cntr_no",					false,       "",      dfNone,      	0,     false,		false);
	                 InitDataProperty(0, cnt++ , dtData,  50,	 daCenterTop,	 true,	   "cntr_prt_flg",				false,		 "",	  dfNone,		0,	   false,		false);
	                 InitDataProperty(0, cnt++ , dtData, 120,    daCenterTop, 	 true,     "vvd",						false,       "",      dfNone,      	0,     false,		false);
	                 
	                 InitDataProperty(0, cnt++ , dtData, 120,    daCenterTop, 	 true,     "ie_vvd",					false,       "",      dfNone,      	0,     false,		false);
	                 InitDataProperty(0, cnt++ , dtData, 60,    daCenterTop, 	 true,     "io_bnd_cd",					false,       "",      dfNone,      	0,     false,		false);
	                 InitDataProperty(0, cnt++ , dtData, 80,    daCenterTop, 	 true,     "port_cd",					false,       "",      dfNone,      	0,     false,		false);
	                 
	                 InitDataProperty(0, cnt++ , dtData, 300,    daLeftTop, 	 true,     "cstms_err_id",   			false,       "",      dfNone,   	0,     false,		false);
	 		
	                 InitDataProperty(0, cnt++ , dtData, 150,    daCenterTop, 	 true,     "msg_acpt_ref_no",    		false,       "",      dfNone,   	0,     false,		false);
	                 InitDataProperty(0, cnt++ , dtData, 125,    daCenterTop, 	 true,     "msg_rcv_no",    			false,       "",      dfNone,   	0,     false,		false);
 										
	                 InitUserFormat2(0, "ack_dt", "####-##-## ##:##", "-|:" );
	                 InitUserFormat2(0, "apro_dt", "####-##-## ##:##", "-|:" );
	                 
	                 WaitImageVisible=false;

	                 // 자동 행 높이 지정
	                 AutoRowHeight = false;
	                 // 행 높이 설정
	                 DataRowHeight = 22;
	                 
                }
                 
                break;

         }
     }

     /**
      * 최초 init
      * @return
      */
     function initPage() {
 		document.form.s_vps_eta_dt.value=ComGetDateAdd(null, 'd', -7, '-');
		document.form.e_vps_eta_dt.value=ComGetNowInfo('ymd','-');
		document.form.vvd_for_fr.readOnly = true;
		document.form.vvd_for_fr.style.backgroundColor= "#E8E7EC";
		
		
		// add. 2014.12.29
		document.form.p_type.Code = "ALL"; 

		sheetObjects[0].ColHidden("vvd") = false;
		sheetObjects[0].ColHidden("bl_no") = false;
		sheetObjects[0].ColHidden("cntr_no") = false;
		sheetObjects[0].ColHidden("cntr_prt_flg") = false;
		
		sheetObjects[0].ColHidden("ie_vvd") = true;
		sheetObjects[0].ColHidden("io_bnd_cd") = true;
		sheetObjects[0].ColHidden("port_cd") = true;
     }

    // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg = false;
	     
	    switch(sAction) {

	    	case IBSEARCH:      //조회

				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
				if(formObj.fr_ack.checked){
					formObj.fr_ack.value ="Y";
				}else{
					formObj.fr_ack.value ="N";
				}

				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				var sParam = FormQueryString(formObj);
				//ComShowMessage("sParam : " + sParam);
				sheetObj.DoSearch("ESM_BKG_1032GS.do",sParam);
				ComOpenWait(false);
				
//					alert(sParam);
				
				break;

	    		
			case "btn_exceldown":
				sheetObj.SpeedDown2Excel(1);
				break;
				
			case IBCLEAR:
				
				sheetObjects[0].RemoveAll();
				formObj.reset();
				
				formObj.s_vps_eta_dt.value=ComGetDateAdd(null, 'd', -7, '-');
				formObj.e_vps_eta_dt.value=ComGetNowInfo('ymd','-');
				
	     }
	 }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
 	  	
 	    	case IBSEARCH:  // 조회
				if(formObj.p_type.Code == "ALL"){
 	    			//기본포멧체크
					if (!ComChkValid(formObj)) return false;
					// 이거 빼고 기능 구현하기
					
	    			var etaDt = formObj.s_vps_eta_dt.value + formObj.e_vps_eta_dt.value;
	    			var blNo = formObj.bl_no.value;
	    			var cntrNo = formObj.cntr_no.value;
	    			
					//ComShowMessage("[" + etaDt + "][" + blNo +"]["+ cntrNo + "]");
	    			if(etaDt == "" && blNo == "" && cntrNo == "") {
						//ComShowMessage("please check a mandatory item. One of Acknowledge Date,BL No,Container No should be input.");
	    				ComShowCodeMessage("BKG06091");
						ComSetFocus(formObj.s_vps_eta_dt);
						return false;
	    			}
				}
    			else if (formObj.p_type.Code =="IE" || formObj.p_type.Code =="APE" ){
    				
    				var etaDt = formObj.s_vps_eta_dt.value + formObj.e_vps_eta_dt.value;
        			var vvd = formObj.ie_vvd.value;
        			
        			if(etaDt == "" && vvd == "") {
        				ComShowCodeMessage("BKG06092");
        				ComSetFocus(formObj.s_vps_eta_dt);
    					return false;
        			}else if(formObj.ie_vvd.value.length > 0 && formObj.ie_vvd.value.length < 9){
        				ComShowCodeMessage("BKG00566");
        				ComSetFocus(formObj.ie_vvd);
    					return false;
        			}
    			}
    			
    			break;
			
				
 	    } // end switch()
		
    	 
         return true;
     }
     
     /**
      * 조회조건 입력할 때 처리
      */
     function obj_KeyUp() {
     	var formObject = document.form;
     	var srcName = window.event.srcElement.getAttribute("name");
     	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
     	var srcValue = window.event.srcElement.getAttribute("value");
     	if (srcName=="bl_no" && ComChkLen(srcValue, srcMaxLength) == "2") {
     		ComSetNextFocus();
     	}
     }
     
     /**
      * 시트를 클릭했을 때 처리
      */
     function sheet1_OnClick(sheetObj, row, col) {

     	var rowCnt = sheetObj.RowCount;
     	var colSaveName = sheetObj.ColSaveName(col);

     	/* Row Focus 색상 및 글자  기본값으로 변경 */
     	sheetObj.SelectFontBold  = false;
     	sheetObj.SelectBackColor = "16186087";
     	
     	switch(colSaveName) {
     		/* 긴 문자열 MemoPad 처리*/
     		case "cstms_err_id" :
     			
     			if(sheetObj.CellValue(row,col) == "") return false;
     			
     			ComShowMemoPad(sheetObj, null, null, true, 420, 150);
     			break;
     			
     	} // end switch

     }
     
     /**
      * 화면 폼 입력 필드에 MaxLength 만큼 값이 들어오면,
      * 자동으로 다음 필드로 Focus 이동
      * TAB 이나 BACK TAB은 막음
      */
     function obj_click() {
     	var formObject = document.form;
     	var srcName = window.event.srcElement.getAttribute("name");
     	var srcValue = window.event.srcElement.getAttribute("value");
     	if (srcName == "fr_ack") {
     		if (formObject.fr_ack.checked == true){
//     			alert("if");
     			formObject.vvd_for_fr.readOnly = false;
    			formObject.vvd_for_fr.style.backgroundColor= "";
    			
     		
     		}else { 
//     			alert("else")
     			formObject.vvd_for_fr.readOnly = true;
     			formObject.vvd_for_fr.style.backgroundColor= "#E8E7EC";
     			formObject.vvd_for_fr.value = "";
     		
     		}
     		
     		
     	}
     }
    
    /**
 	 * Type 콤보 이벤트 처리 
 	 * @param comboObj
 	 * @param value
 	 * @param text
 	 * @return
 	 */ 
 	function p_type_OnChange(comboObj, value, text){
 		if(form.p_type.Code == "ALL") {
 			doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
			
 			document.getElementById("allView").style.display = "Inline";
 			document.getElementById("ieView").style.display = "none";
 			initPage();


			sheetObjects[0].ColHidden("vvd") = false;
			sheetObjects[0].ColHidden("bl_no") = false;
			sheetObjects[0].ColHidden("cntr_no") = false;
			sheetObjects[0].ColHidden("cntr_prt_flg") = false;
			
 			sheetObjects[0].ColHidden("ie_vvd") = true;
			sheetObjects[0].ColHidden("io_bnd_cd") = true;
			sheetObjects[0].ColHidden("port_cd") = true;
						 
 			
 		} else {

			doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
			
			document.getElementById("allView").style.display = "none";
 			document.getElementById("ieView").style.display = "Inline";

			sheetObjects[0].ColHidden("vvd") = true;
			sheetObjects[0].ColHidden("bl_no") = true;
			sheetObjects[0].ColHidden("cntr_no") = true;
			sheetObjects[0].ColHidden("cntr_prt_flg") = true;
			
			sheetObjects[0].ColHidden("ie_vvd") = false;
			sheetObjects[0].ColHidden("io_bnd_cd") = false;
			sheetObjects[0].ColHidden("port_cd") = false;
			
 		}
 	}