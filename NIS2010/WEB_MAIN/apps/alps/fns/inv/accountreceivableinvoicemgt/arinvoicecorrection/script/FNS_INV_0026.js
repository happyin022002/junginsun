/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0026.js
*@FileTitle : Invoice Update by User ID
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.29 한동훈
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
     * @class fns_inv_0026 : fns_inv_0026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0026() {
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
            	
							case "btn_retrieve":
								doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
							break;
							
							case "btn_new":
								ComResetAll();
								doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
								ComSetFocus(form.vvd);
							break;

							case "btn_downexcel":
								sheetObjects[0].SpeedDown2Excel(0, false, false, "", "", false, false, "", false, "|ibflag|chk");
								//sheetObjects[0].Down2Excel(0, false, false, true, "", "", false, false, "", false, "|ibflag|chk");								
							break;

							case "btn_save":
								doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
							break; 
							
							case "btn_print":
								alert(srcName);
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
 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);	//office,scope 콤보조회
        ComSetFocus(form.vvd);
        initControl();
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
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
				var sheetID = sheetObj.id;
        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 442;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //var HeadTitle = "|Slt|Seq|B/L No|BKG No|BKG Ofc|Type|Customer|POL|POD|I/F No|S/A Date|User ID|Curr|Amount|Local Amount";
                    //Curr, Local Amount 삭제
                    var HeadTitle = "|Sel.|Seq.|B/L No.|BKG No.|BKG Ofc|Type|Cust Code|POL|POD|I/F No|S/A Date|User ID|Local Amount";

                
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,		 40,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,  		 40,    daCenter,  true,    "chk");
                    InitDataProperty(0, cnt++ , dtSeq,	     		 40,    daCenter,  true,    "seq");                    
                    InitDataProperty(0, cnt++ , dtData,     		 110,    daCenter,  true,   "bl_src_no",      	false,    "",      dfNone,		0,	false,		false);
                    InitDataProperty(0, cnt++ , dtData,     		 100,    daCenter,  true,    "bkg_no",      		false,    "",      dfNone,		0,	false,		false);
                                                                                                                                          
                    InitDataProperty(0, cnt++ , dtData,     		 70,    daCenter,  true,    "bkg_ofc_cd",    	false,    "",      dfNone,		0,	false,		false);
                    InitDataProperty(0, cnt++ , dtData,     		 60,    daCenter,  true,    "rev_tp_cd",    	false,    "",      dfNone,		0,	false,		false);
                    InitDataProperty(0, cnt++ , dtData,     		 80,    daCenter,  true,    "act_cust_cnt_cd", 	false,    "",      dfNone,		0,	false,		false);                   
                    InitDataProperty(0, cnt++ , dtData,     		 60,    daCenter,  true,    "pol_cd",     		false,    "",      dfNone,		0,	false,		false);                    
                    InitDataProperty(0, cnt++ , dtData,     		 60,    daCenter,  true,    "pod_cd",        	false,    "",      dfNone,		0,	false,		false);                    
										                                                                                 
                    InitDataProperty(0, cnt++ , dtData,     		 100,    daCenter,  true,    "ar_if_no",     	false,    "",      dfNone,		0,	false,		false);
                    InitDataProperty(0, cnt++ , dtData,     		 80,    daCenter,  true,    "sail_arr_dt",     	false,    "",      dfDateYmd,	0,	false,		false);
                    InitDataProperty(0, cnt++ , dtData,     		 70,    daCenter,  true,    "upd_usr_id",     	false,    "",      dfNone,		0,	false,		false);
                    //InitDataProperty(0, cnt++ , dtData,     		 40,    daCenter,  true,    "locl_curr_cd",     false,    "",      dfNone,		0,	false,		false);                   
                    InitDataProperty(0, cnt++ , dtData,     		 80,    daRight,   true,    "inv_ttl_locl_amt", false,    "",      dfNullFloat,		2,	false,		false);
                    //InitDataProperty(0, cnt++ , dtData,     		 70,    daRight,   true,    "local_amount", 	false,    "",      dfNullFloat,		2,	false,		false);
                    
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
			case IBSEARCH_ASYNC10: //CreditCustomer Office 조회
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0026GS.do", FormQueryString(formObj));
				// ofc cd
				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
				var arrStr = sStr.split("|");
				MakeComboObject_OfcCd_Re(formObj.ofc, arrStr, "N");

				var arrStr2 = arrStr[1].split("^");
				var ar_ofc_cd = arrStr2[3];
				formObj.ofc.text = ar_ofc_cd;
				formObj.ofc.DropHeight = 190;
				// scope cd
				var sStr2 = ComGetEtcData(sXml,"svc_scp_cd1");
				var arrStr2 = sStr2.split("|");				
				MakeComboObject(formObj.svc_scp_cd1, arrStr2);
				formObj.svc_scp_cd1.Code = "ALL"
			break;
           case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction) == false) return false;  
				if (sheetObj.id == "sheet1") {						
					formObj.f_cmd.value = SEARCH;
					
					var vvd = formObj.vvd.value;					
					formObj.vsl_cd.value = vvd.substring(0,4);
					formObj.skd_voy_no.value = vvd.substring(4,8);
					formObj.skd_dir_cd.value = vvd.substring(8,9);
					
					var arrStr2 = formObj.ofc.Code.split("^");
         			formObj.ofc2.value = arrStr2[1];
         			formObj.locl_curr_cd.value = arrStr2[4];
         			
         			formObj.svc_scp_cd.value = formObj.svc_scp_cd1.text;
         			

					var sXml = sheetObj.GetSearchXml("FNS_INV_0026GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					var sa_date = ComGetEtcData(arrXml[0],"sa_date");
					if(sa_date == undefined || sa_date == "null") sa_date = "";
					
					var inv_xch_rt = ComGetEtcData(arrXml[0],"inv_xch_rt");
					if(inv_xch_rt == undefined || inv_xch_rt == "null") inv_xch_rt = "";
					
					formObj.sa_date.value = sa_date;
					formObj.inv_xch_rt.value = inv_xch_rt;
					sheetObjects[0].LoadSearchXml(arrXml[0]);
					/*
					for (var i=1; i<=sheetObj.RowCount; i++) {
						sheetObj.CellFontUnderline(i,'bl_src_no') = true;
						//sheetObj.CellFontUnderline(i,'inv_no') = true;
					}	*/
				}

                break;

				case IBSAVE:        //저장
	                if(!validateForm(sheetObj,formObj,sAction)) return;
					formObj.f_cmd.value = MULTI;
					sheetObj.DoSave("FNS_INV_0026GS.do", FormQueryString(formObj));
                break;

					case IBINSERT:      // 입력
                break;
        }
    }
    
    /** 
  	 * off_cd 콤보박스 출력시 사용-콤보박스 세팅<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
  	 * @param cmbObj : 대상객체, arrStr : 데이타 배열, allYn : ALL 추가여부(Y)
  	 * @return 없음
  	 * @see #
  	 * @author 한동훈
  	 * @version 2009.10.19
  	 */
	function MakeComboObject(cmbObj, arrStr) {
	    //IBMultiCombo초기화
		for (var i = 0; i < arrStr.length;i++ ) {
			cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
		}
   		cmbObj.DropHeight = 190;

	}
    
    /** 
     * off_cd 콤보박스 출력시 데이타를 추가하기위해 사용<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} cmbObj :  offc_cd 콤보박스 오브젝트
     * @param  {String} arrStr : combo list  데이타
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function MakeComboObject2(cmbObj, arrStr) {
     	cmbObj.RemoveAll(); 
  		for (var i = 1; i < arrStr.length;i++ ) {
  			var arrStr2 = arrStr[i].split("^");
  			var ar_ofc_cd = arrStr2[1];
  			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
  		}
  		cmbObj.InsertItem(0, "ALL", "ALL^ALL");
  		cmbObj.BackColor = "#CCFFFD";
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
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {			
			case IBSEARCH: //조회	
				if (ComIsNull(formObj.vvd)){
					ComShowCodeMessage('INV00004');
					ComSetFocus(form.vvd);
    				return false;	
				}else if(formObj.vvd.value.length != 9){
					ComShowCodeMessage('INV00041');
					ComSetFocus(form.vvd);
    				return false;	
				}					
			break;
			
			case IBSAVE:   //저장
			
			break;
		}
		return true;
    }
    
    /** 
     * sheet상에서 더블클릭했을때 발생하는 이벤트로 팝업화면을 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {int} Row : 포커스가 위치해 있는 sheet의 Row
     * @param  {int} Col : 포커스가 위치해 있는 sheet의 Col 
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function sheet1_OnDblClick(sheetObj, row, col) {
		//alert(sheetObjects[0].ColSaveName(col)+"::"+col);
		var rev_tp_cd = sheetObj.CellText(row, 'rev_tp_cd');
		var bl_src_no = sheetObj.CellText(row, 'bl_src_no');
		var bkg_no = sheetObj.CellText(row, 'bkg_no');
		var bkg_ofc_cd = sheetObj.CellText(row, 'bkg_ofc_cd');
		var ar_if_no = sheetObj.CellText(row, 'ar_if_no');		
		
		if(rev_tp_cd == 'MTM'){
			var param = '?pgmNo=FNS_INV_0071-01&ar_if_no='+ar_if_no+'&ar_ofc_cd='+bkg_ofc_cd+'&classId=FNS_INV_0071';			
			ComOpenWindow('/hanjin/FNS_INV_0071.do' + param, 'FNS_INV_0071', 'width=1000,height=495');
			//ComOpenPopup("/hanjin/FNS_INV_0071.do"+param, 1000, 544, "0028", "1,0", false);
		}else if(rev_tp_cd.substring(0,1) != 'M'){
			var param = '?pgmNo=FNS_INV_0016-01&bl_src_no='+bl_src_no+'&ar_ofc_cd='+bkg_ofc_cd+'&classId=FNS_INV_0016';
			ComOpenWindow('/hanjin/FNS_INV_0016.do' + param, 'FNS_INV_0016', 'width=1050,height=500');
			//ComOpenPopup("/hanjin/FNS_INV_0071.do"+param, 924, 544, "0028", "1,0", false);			
		}
	}


	/* 개발자 작업  끝 */