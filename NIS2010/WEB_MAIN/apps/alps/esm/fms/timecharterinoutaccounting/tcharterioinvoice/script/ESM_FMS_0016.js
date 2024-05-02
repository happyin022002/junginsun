/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0016.js
*@FileTitle : Charterer's Account
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.13
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.13 정윤태
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
* 
* --------------------------------------------------------------------------------
* 2016.02.01 손진환 [CHM-201639985] Inquiry 화면 불필요 Validation정리 
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
     * @class Charterer's Account : Charterer's Account 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0016() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnChangeSum	    = sheet1_OnChangeSum;
		this.setVslCd			    = setVslCd;
		this.sheet1_OnPopupClick    = sheet1_OnPopupClick;
		this.setProgramNo		    = setProgramNo;
		this.rowRemove			    = rowRemove;
		this.clearAll			    = clearAll;
		this.obj_deactivate		    = obj_deactivate;
		this.obj_activate			= obj_activate;
		this.obj_keypress		    = obj_keypress;
		this.eng_keypress		    = eng_keypress;
		this.vsl_cd_change		    = vsl_cd_change;
		this.inputReadOnly		    = inputReadOnly;
		this.setContractNo		    = setContractNo;
		this.contract_no_change	    = contract_no_change;
		this.initConfirm			= initConfirm;
		this.rowChangeYn			= rowChangeYn;
		this.setItemNm				= setItemNm;
		this.setGridItemNm			= setGridItemNm;
		this.sheet1_OnChange		= sheet1_OnChange;
		this.setCurrCd				= setCurrCd;
		this.sheet1_OnClick			= sheet1_OnClick;
		this.setVvdCombo			= setVvdCombo;
		this.setVvdMakeCombo		= setVvdMakeCombo;
		this.setItemClear			= setItemClear;
		this.setDataClear			= setDataClear;
		this.controlScrollBar		= controlScrollBar;
		this.setTotalAmount			= setTotalAmount;
		this.getMaxInvDtlSeq		= getMaxInvDtlSeq;
    }
    
    // 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//2017.05.15 contract type 콤보로 변경
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

            	case "btn_sdms":
            		if(!validateForm(sheetObject,formObject)) return;
            		
            		initCheckBox(sheetObject, "inv_");
            		
            		for (var ir=sheetObject.LastRow; ir>=sheetObject.HeaderRows; ir--) {
	        			if(sheetObject.CellValue(ir,"inv_pop_gb") == "SDMS") {
	        				sheetObject.CellValue2(ir,"inv_DelChk") = 1;
	        				rowRemove(sheetObject, "inv_");
	        			}
	        		}
            		
            		sheetObjects[1].RemoveAll();
            		
            		var flet_ctrt_no = formObject.flet_ctrt_no.value;
            		var vsl_cd = formObject.vsl_cd.value;
            		
            		var vsl_eng_nm = formObject.vsl_eng_nm.value;
            		var ownr_nm = formObject.ownr_nm.value;
            		var cust_cnt_cd = formObject.cust_cnt_cd.value;
            		var cust_seq = formObject.cust_seq.value;
            		
            		ComOpenPopup("ESM_FMS_0017.do?flet_ctrt_no="+flet_ctrt_no+"&vsl_cd="+vsl_cd+"&vsl_eng_nm="+vsl_eng_nm+"&ownr_nm="+escape(ownr_nm)+"&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq, 920, 520,"setSDMS", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0017");
            		
                    break;

				case "btn_add":
					if(!validateForm(sheetObject,formObject)) return;
					
					var row = sheetObject.DataInsert(-1);

					sheetObject.CellText(row,"inv_slp_tp_cd") = "N";
					sheetObject.CellText(row,"inv_flet_ctrt_no") = formObject.flet_ctrt_no.value;
					
					var inv_dtl_seq = getMaxInvDtlSeq(sheetObject);

					if(inv_dtl_seq == "") {
						inv_dtl_seq = 1;
					} else {
						inv_dtl_seq = parseInt(inv_dtl_seq) + 1;
					}

					sheetObject.CellText(row,"inv_inv_dtl_seq") = inv_dtl_seq;
					sheetObject.CellText(row,"inv_inv_seq") = "1";
					
//					inputReadOnly();
					
                    break;

				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "inv_DelChk")) {
						rowRemove(sheetObject,"inv_");
					}
                    break;

				case "btn_retrieve":
					if(!initConfirm()) return;
					
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                
				case "btn_new":
					if(!initConfirm()) return;
					
					ComBtnEnable("btn_sdms");
					
					clearAll();
                    break;

				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;

				case "btn_savetofile":
					sheetObject.SpeedDown2Excel(-1);
                    break;
                    
				case "from_inv_dt": 
					var cal = new ComCalendar();
					cal.select(form.from_chtr_inv_dt, 'yyyy-MM-dd');
					break;
				 
				case "to_inv_dt":
					var cal = new ComCalendar();
					cal.select(form.to_chtr_inv_dt, 'yyyy-MM-dd');	
					break;
					 
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0022");
					break;
					 
				case "contract_no":
					if(formObject.vsl_cd.value == "") {
						ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01138'));
						return;
					}
					 
					ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value, 520, 405,"setContractNo", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0023");
					break;
					 
				case "item_name":
					ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=CH", 550, 455, "setItemNm", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0076");
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

    //2017.05.15 contract type 콤보로 변경
    function setComboObject(combo_obj){          
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

        	//khlee-시작 환경 설정 함수 이름변경
        	ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        //마지막 컬럼을 전체 너='비에 맞춘다.
        sheetObjects[0].ExtendLastCol = false;

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        //html컨트롤 이벤트초기화
        initControl();
        
        //2017.05.15 contract type 콤보로 변경
        doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ComCd");
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
                	var prefix = "inv_";

                    // 높이 설정(160)
                    style.height = 340;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(21, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					var HeadTitle = "|Sel|Seq|Item Name|Account Code|Curr|Amount|Approval|Invoice DT|Invoice No.|VVD CD|Description|Update Date|Update User|Acct Item Seq|Contract No|FletIssTpCd|InvSeq|InvDtlSeq|SDMS No|PopGb";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  true,    prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,    30,    daCenter,  false,   prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtDataSeq,    	 30,    daCenter,  false,   prefix + "Seq");                 
					InitDataProperty(0, cnt++ , dtPopup,        200,    daLeft,    false,   prefix + "acct_itm_nm",   	true,          "",      dfNone,      	0,		true,       true);
					InitDataProperty(0, cnt++ , dtData,          97,    daCenter,  false,   prefix + "acct_cd",     	true,          "",      dfNone,      	0,    	false,      false);	
					
					InitDataProperty(0, cnt++ , dtData,      	 45,    daCenter,  false,   prefix + "curr_cd",	 		true,          "",      dfNone,   		0,     	true,       true, 3);
					InitDataProperty(0, cnt++ , dtData,          88,    daRight,   false,   prefix + "inv_amt",  		true,          "",      dfNullFloat, 	2,     	true,       true, 15);
					InitDataProperty(0, cnt++ , dtData,      	 60,    daCenter,  false,   prefix + "slp_tp_cd",     	false,         "",      dfNone, 		0,    	false,      false);
					InitDataProperty(0, cnt++ , dtData,   	   	 80,    daCenter,  false,   prefix + "chtr_inv_dt",   	true,          "",      dfDateYmd, 		0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	 90,    daLeft,    false,   prefix + "to_inv_no",   	true,          "",      dfNone, 		0,     	true,       true, 20);
                                         	   
					InitDataProperty(0, cnt++ , dtData,   	   	 95,    daCenter,  false,   prefix + "bunker_vvd",   	true,          "",      dfNone, 		0,    	false,      false);
					InitDataProperty(0, cnt++ , dtData,      	150,    daLeft,    false,   prefix + "inv_desc",  	    true,          "",      dfNone, 		0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,  false,   prefix + "upd_dt",  	    false,         "",      dfDateYmd, 		0,     	false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 100,   daCenter,  false,   prefix + "upd_usr_id",  	false,         "",      dfNone, 		0,     	false,      false);
					
					InitDataProperty(0, cnt++ , dtHidden,	   	 30,    daCenter,  false,   prefix + "acct_itm_seq",   	false,         "",      dfNone,      	0,     	true,       false);
					InitDataProperty(0, cnt++ , dtHidden,	     30,    daCenter,  false,   prefix + "flet_ctrt_no",    false,         "",      dfNone,      	0,     	true,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	 62,    daCenter,  false,   prefix + "flet_iss_tp_cd",  false,         "",      dfNone,        	0,     	false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 62,    daCenter,  false,   prefix + "inv_seq",     	false,         "",      dfNone,        	0,     	false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 62,    daCenter,  false,   prefix + "inv_dtl_seq",     false,         "",      dfNone,        	0,     	false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 62,    daCenter,  false,   prefix + "sdms_no",     	false,         "",      dfNone,        	0,     	false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 62,    daCenter,  false,   prefix + "pop_gb",     		false,         "",      dfNone,        	0,     	false,      false);
					
					InitDataValid(0, prefix + "curr_cd", vtEngUpOnly);
					
					DataLinkMouse(prefix + "acct_itm_nm") = true;
					
					ShowButtonImage = 2;
               }
                break;
            case 2:      //sheet2 init
	            with (sheetObj) {
	            	var prefix = "sdms_";
	
	                // 높이 설정(160)
	                style.height = 340;
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
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(12, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false);
	
					var HeadTitle = "| |SDMS No.|Currency|Amount|INV No.|SDMS Date|Description|Status Cd|SHP_OWNR_CO_NM|PAY_ACCT_NO|CRE_USR_ID";
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  	                InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  	true,   	prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,      30,    daCenter,  	true,   	prefix + "DelChk");                    
                    InitDataProperty(0, cnt++ , dtData,      	 80,   	daCenter,  	true,    	prefix + "stv_dmg_no",     				false,          "",      dfNone,   		0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,   	   	 60,    daCenter,  	true,    	prefix + "pay_curr_cd",     			false,          "",      dfNone, 		0,     true,       true,	3);

					InitDataProperty(0, cnt++ , dtData,      	 80,    daRight,   	true,    	prefix + "pay_locl_amt",  				false,          "",      dfNullFloat,	2,     true,       true,	18);
					InitDataProperty(0, cnt++ , dtData,      	 110,   daLeft,  	true,    	prefix + "bil_inv_no",  				false,          "",      dfNone, 		0,     true,       true,	20);
					InitDataProperty(0, cnt++ , dtData,   	 	 70,    daCenter,  	true,   	prefix + "pay_dt",  					false,          "",      dfDateYmd, 	0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	 300,   daLeft,	 	true,    	prefix + "stv_dmg_rmk",  				false,          "",      dfNone, 		0,     true,       true,	500);
					InitDataProperty(0, cnt++ , dtData,      	 30,    daCenter,	true,    	prefix + "stv_dmg_stl_proc_sts_cd",  	false,          "",      dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	 80,    daCenter,	true,    	prefix + "shp_ownr_co_nm",  			false,          "",      dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	 30,    daCenter,	true,    	prefix + "pay_acct_no",  				false,          "",      dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	 30,    daCenter,	true,    	prefix + "cre_usr_id",  				false,          "",      dfNone, 		0,     true,       true);
	           }
	            break;
        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     * @param {String}  gubun     	처리할 gubun 값
     **/
    function doActionIBSheet(sheetObj,formObj,sAction,gubun,row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회

        		if(validateForm(sheetObj,formObj,sAction)){
       	   	  		formObj.f_cmd.value = SEARCH;
       	   	  		
       	   	  		var aryPrefix = new Array("inv_", "");
       	   	  
       	   	  		var sXml = sheetObj.GetSearchXml("ESM_FMS_0016GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
       	   	  		
       	   	  		var arrXml = sXml.split("|$$|");
			   		
			   		if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
			   		
			   		var totalAmount1 = "";
			   		
			   		if (arrXml.length > 0) {		
						
						var list = ComFmsSheetXml2ListMap(arrXml[1]);
						
						totalAmount1 = ComFmsMakeTotalAmtHtml(list, "1")
				
					}
			   		
			   		//var totalAmount1 = sheetObjects[0].EtcData("totalAmount1");
			   		
			   		if(   (typeof totalAmount1 != "undefined"
	 				    && totalAmount1 != "")) {
			   			
			   			setTotalAmount(totalAmount1);
	 				} else {
	 					document.all.totalAmount.style.display = "none";
	 				}
			   		
//			   		inputReadOnly();
       	   	  	}

                 break;

			 case IBSAVE:        //저장
				 
				 if(validateForm(sheetObj,formObj,sAction)) {

					 var prefix = "inv_";
					 var prefix2 = "sdms_";
					 
					 for (var i=1; i<=sheetObjects[0].LastRow; i++){
						 
						 var sdms_no_inv = sheetObjects[0].CellValue(i,prefix+"sdms_no");
						 
						 for(var j=1; j<=sheetObjects[1].LastRow; j++){							  
								 var sdms_no_stv = sheetObjects[1].CellValue(j,prefix2+"stv_dmg_no");	
								 
								 if(sdms_no_inv == sdms_no_stv) { 
									 sheetObjects[1].CellValue2(j, prefix2+"stv_dmg_rmk") = sheetObjects[0].CellValue(i,prefix+"inv_desc");
								 }								 
						 } 			 				 
					 }
					 
				     formObj.f_cmd.value = MULTI;
				     
				     var arrSheets = new Array(sheetObjects[0], sheetObjects[1]);
					 var sParam = ComGetSaveString(arrSheets);					 			

					 if (sParam == "") return;
				     
					 setItemClear();
					 
					 //var aryPrefix = new Array("inv_", "sdms_");
				     var aryPrefix = new Array("inv_", "", "sdms_");
				     
				     sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
        			
				     var sXml = sheetObj.GetSaveXml("ESM_FMS_0016GS.do", sParam);
				     
				     var arrXml = sXml.split("|$$|");
				     
				     if (arrXml.length > 0) {
				    	 sheetObjects[0].LoadSearchXml(arrXml[0]);
				    	 sheetObjects[1].RemoveAll();
				     }
				     
				     var totalAmount1 = "";

			   		 if (arrXml.length > 0) {		
						
					     var list = ComFmsSheetXml2ListMap(arrXml[1]);
					     
					     totalAmount1 = ComFmsMakeTotalAmtHtml(list, "1");
				
					 }
				     
				     //var totalAmount1 = sheetObjects[0].EtcData("totalAmount1");
				     
				     if(   (typeof totalAmount1 != "undefined"
				         && totalAmount1 != "")) {
				    	 
				    	 setTotalAmount(totalAmount1);
	 				 } else {
	 				     document.all.totalAmount.style.display = "none";
	 				 }
				 }
				 break;
				 
			 case IBROWSEARCH:   //조회	
		    	
				if(gubun == "Vvd") {
					
					formObj.f_cmd.value = SEARCH01;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0016GS.do" , FormQueryString(formObj));
		
		   			var vvd = ComGetEtcData(sXml, "vvd");

		   			if(typeof vvd != "undefined" && vvd != "") {
		   				sheetObj.CellText(row, "inv_bunker_vvd") = "";
		   				
	    				var comboText = vvd;

	    				setVvdMakeCombo(sheetObj, comboText, row);
	    			} else {
	    				ComShowMessage(ComGetMsg('FMS01144'));
	    				sheetObj.SelectCell(row, "inv_chtr_inv_dt");
	    			}
		   			
				} else if(gubun == "Contract") {
					
					var acctItmNm = form.acct_itm_nm.value;
    				var acctCd = form.acct_cd.value;
    				var acctItmSeq = form.acct_itm_seq.value;
    				
    				var fromChtrInvDt = form.from_chtr_inv_dt.value;
    				var toChtrInvDt = form.to_chtr_inv_dt.value;
    				
					formObj.f_cmd.value = SEARCH05;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0001GS.do" , FormQueryString(formObj));
		   			
		   			var arrXml = sXml.split("|$$|");
	    			if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
	    			
	    			ComEtcDataToForm2(formObj,sheetObjects[0],"",true);
	    			
	    			formObj.chkItemName.checked = true;
	    			
	    			if(acctItmNm != "") {
	    				form.acct_itm_nm.value = acctItmNm;
	    				form.acct_cd.value = acctCd;
	    				form.acct_itm_seq.value = acctItmSeq;
	    			}
	    			
	    			if(fromChtrInvDt != "") {
	    				form.from_chtr_inv_dt.value = fromChtrInvDt;
	    			}
	    			
	    			if(toChtrInvDt != "") {
	    				form.to_chtr_inv_dt.value = toChtrInvDt;
	    			}
	    			
				} else if(gubun == "CurrCd") {
					var prefix = "inv_";
					
					formObj.f_cmd.value = SEARCH01;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0076GS.do" , FormQueryString(formObj));
		
		   			var currCd = ComGetEtcData(sXml, "currCd");

		   			if(typeof currCd == "undefined" || currCd == "") {
		   				ComShowMessage(ComGetMsg('FMS01142'));
                        sheetObj.CellValue2(row,prefix+"curr_cd") = "";
                        sheetObj.SelectCell(row,prefix+"curr_cd");
                        
	    			} else {
	   					var currCd = sheetObj.CellValue(row, prefix + "curr_cd");
	   					
	   					ComFmsSetInitCellProperty(sheetObj, row, 6, "inv_amt", currCd, prefix, 2);
	   				}
		   		
				} else if(gubun == "ComCd") {			//2017.05.15 contract type 콤보로 변경
					
					sheetObj.WaitImageVisible = false;
					
					formObj.f_cmd.value = SEARCH04;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0001GS.do" , FormQueryString(formObj));
		   			
		   			var fletCtrtTpCd   = ComGetEtcData(sXml, "fletCtrtTpCd");
		   			var fletCtrtTpNm   = ComGetEtcData(sXml, "fletCtrtTpNm");
		   			
		   			if(typeof fletCtrtTpCd != "undefined" && fletCtrtTpCd != "") {
	    				var comboCode = fletCtrtTpCd;
	    				var comboText = fletCtrtTpNm;

	    				setDataCombo(comboObjects[0], comboText, comboCode);
	    			}
		   			
		   			sheetObj.WaitImageVisible = true;
		   			
				} else {
					formObj.f_cmd.value = SEARCH01;
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		
		   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
		   			
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value = vslEngNm;
		   				initDefaultContractNo(); //선박 대 계약 자동 매치
					} else {
						formObj.vsl_cd.value = "";
						formObj.vsl_eng_nm.value = "";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01234'));
						return;
					}
				}
				break;

			case IBINSERT:      // 입력
                break;
                
			case IBSEARCH_ASYNC02: //선박 대 계약 자동 매치			
				if(formObj.vsl_cd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdAll; 
				
				var sXml = sheetObj.GetSearchXml("FMS_COMGS.do",f_query);

	   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
	   			var varFletCtrtTpCd = ComGetEtcData(sXml, "flet_ctrt_tp_cd");		//2017.05.15 contract type 콤보로 변경
	   			
	   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
					formObj.flet_ctrt_no.value = varFletCtrtNo;
					formObj.flet_ctrt_tp_cd.Code2 = varFletCtrtTpCd;		//2017.05.15 contract type 콤보로 변경
				}else{
					ComShowCodeMessage("FMS20001","Agreement");
					clearAll();
					return;
				}
				if(formObj.flet_ctrt_no.value != ""){
					contract_no_change();
				}
				break;    
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	화면 form Object
     * @param {ibsheet} sAction     IBSheet Object
fullfillfullfillfullfillfullfill     * @param {String}  value    	sheetObj의 입력값
     * @return {boolean} 정상 여부
     * @see #ComChkValid
     **/
    function validateForm(sheetObj,formObj,sAction){
    	//필수 입력 등 Validation 체크
    	// Vessel Code 필수 입력 제외 2016.07.08 ㅛㅇ
    	/*if(form.vsl_cd.value == "") {
    		ComAlertFocus(form.vsl_cd, ComGetMsg('FMS01138'));
    		return false;
    	}*/
    	
    	if(form.from_chtr_inv_dt.value != "" && form.to_chtr_inv_dt.value == "") {
    		ComAlertFocus(form.to_chtr_inv_dt, ComGetMsg('FMS01139'));
    		return false;
    	}
    	
    	if(form.from_chtr_inv_dt.value == "" && form.to_chtr_inv_dt.value != "") {
    		ComAlertFocus(form.from_chtr_inv_dt, ComGetMsg('FMS01140'));
    		return false;
    	}
    	
    	if(form.from_chtr_inv_dt.value != "" && form.to_chtr_inv_dt.value != "") {
    		if(form.from_chtr_inv_dt.value.trimAll("-") > form.to_chtr_inv_dt.value.trimAll("-")) {
    			ComAlertFocus(form.to_chtr_inv_dt, ComGetMsg('FMS01141'));
    			return false;
    		}
    	}
    	
        if (!ComChkValid(formObj)) return false;

        return true;
    }

    /**
     * IBSheet Object 합 구하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} sheetObj    IBSheet Row
     **/
	function sheet1_OnChangeSum( sheetObj, Row ) {
		/*
		sheetObj.SumText(0,"Seq") = "";
		sheetObj.SumText(0,"ItemName") = "Total Amount";
		sheetObj.SumText(0,"AccountCode") = "USD"; 

		sheetObj.CellAlign(sheetObj.LastRow,"AccountCode") = daCenter;
		sheetObj.CellAlign(sheetObj.LastRow,"ItemName") = daCenter;		
		*/
	}
	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "-";
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
    	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        //2010.11.24 이상민 [CHM-201007233-01] vsl_cd 는 engnum_keypress로 변경
        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd');			//- Vessel Code 입력 시 영문 대문자만 입력하기
        axon_event.addListener  ('change'  , 'vsl_cd_change', 'vsl_cd');			//- Vessel Code 입력 후 Name 정보 가져오기
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
    			
	    	case "bnk_yrmon":
	    		ComChkObjValid(event.srcElement);
    			break;
    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(event.srcElement);
    	}
    }
     
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
    	//마스크구분자 없애기
    	ComClearSeparator(event.srcElement);
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
    
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
     function engnum_keypress() {
         //영대문자 자동변환
         ComKeyOnlyAlphabet('uppernum');
     } 
    /**
     * VslCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cd_change() {
    	form.flet_ctrt_no.value = "";
    	form.vsl_eng_nm.value = "";
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
    }
    
    /**
	 * Vessel Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기
		
		//선박 대 계약 자동 매치
		if(form.vsl_cd.value != ""){
			vsl_cd_change();
		}
	}
	
	/**
	 * Contract No 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value = aryPopupData[0][3];
		form.flet_ctrt_tp_cd.Code2 = aryPopupData[0][5];	//2017.05.15 contract type 콤보로 변경
		contract_no_change();
	}
	
	/**
     * Contract No 선택 시 해당 Name 을 가져온다. <br>
     **/
    function contract_no_change() {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'Contract');
    }
    
    /**
	 * setItemNm 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setItemNm(aryPopupData, row, col, sheetIdx){
		form.acct_itm_nm.value = aryPopupData[0][2];
		form.acct_cd.value = aryPopupData[0][3];
		form.acct_itm_seq.value = aryPopupData[0][4];
		
		form.chkItemName.disabled = false;
		form.chkItemName.checked = true;
	}
	
	/**
	 * setGridItemNm 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setGridItemNm(aryPopupData, row, col, sheetIdx){
		sheetObjects[0].CellValue2(row,col) = aryPopupData[0][2];
		sheetObjects[0].CellValue2(row,"inv_acct_cd") = aryPopupData[0][3];
		sheetObjects[0].CellValue2(row,"inv_acct_itm_seq") = aryPopupData[0][4];
	}
	
	/**
     * Event에 따른 화면 처리 <br>
     * @param {String} flag     	Event 구분값
     **/
    function inputReadOnly(flag) {
    	if(flag == "New") {
	    	form.vsl_cd.readOnly = false;
	    	
	    	document.images["contract_no"].name = "contract_no";
	    	document.images["btn_vslpop"].name = "btn_vslpop";
	    	
	    	form.contract_no.style.cursor = "hand";
	    	form.btn_vslpop.style.cursor = "hand";
	    	
	    	form.chkItemName.disabled = true;
	    	
    	} else {
	    	if(sheetObjects[0].RowCount > 0) {
		    	form.vsl_cd.readOnly = true;
		    	
		    	document.images["contract_no"].name = "no_contract_no";
		    	document.images["btn_vslpop"].name = "no_btn_vslpop";
		    	
		    	form.contract_no.style.cursor = "default";
		    	form.btn_vslpop.style.cursor = "default";
	    	}
    	}
    }
    
    /**
     * 화면을 초기화한다. <br>
     * @return 없음
     * @see #ComResetAll
     **/
	function clearAll() {
		ComResetAll();
		document.all.totalAmount.style.display = "none";
		inputReadOnly("New");
		
		controlScrollBar();
	}
	
	/**
     * 이벤트 발생시 실행여부 확인 <br>
     * @return {boolean} okYn   메세지 확인창에서 확인버튼 클릭하면 okYn:true 아니면 okYn:false
     **/
    function initConfirm() {
    	var okYn = true;
    	
    	//if(sheetObjects[0].RowCount > 0 && rowChangeYn()) {
    	if(sheetObjects[0].isDataModified) {
    		var okYn = confirm(ComGetMsg('FMS00002'));
    	}
    	
    	return okYn;
    }
    
    /**
     * 이벤트 발생시 변경사항이 있는지 체크 <br>
     * @return {boolean} changeYn   row 의 변경사항이 발생하면 changeYn:true 아니면 changeYn:false
     **/
    function rowChangeYn() {
    	var changeYn = false;

    	for(var ir=1; ir<=sheetObjects[0].LastRow; ir++){
    		if(sheetObjects[0].RowStatus(ir) != "R") {
    			changeYn = true;
    			break;
    		}
		}
    	
    	return changeYn;
    }
    
    /**
     * IBSheet 입력값에 대한 날짜 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @see #ComRowHideDelete
     **/
	function rowRemove(sheetObj, prefix) {
		ComRowHideDelete(sheetObj, prefix + "DelChk");
	}
	
	/**
     * Popup호출하기(Item Name) <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @see #setProgramNo
     **/
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=CH", 550, 455, "setGridItemNm", "1,0,1,1,1,1", false, false, Row, Col, 0, "ESM_FMS_0076");
	}
	
	/**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     **/
	function sheet1_OnChange(sheetObj,row,col) {
		if(sheetObj.ColSaveName(col)=="inv_curr_cd") {
			var currCdCol = sheetObj.SaveNameCol("inv_curr_cd");
    		var currCdValue = sheetObj.CellValue(row,currCdCol);
    		
    		if(currCdValue == "") return;
    		
    		form.curr_cd.value = currCdValue;
			setCurrCd(row);
		} else if(sheetObj.ColSaveName(col)=="inv_chtr_inv_dt") {
			sheetObj.CellValue(row,"inv_bunker_vvd") = "";
			sheetObj.CellEditable(row, "inv_bunker_vvd")= false;
			sheetObj.InitCellProperty(row, "inv_bunker_vvd", dtData); 
		} else if(sheetObj.ColSaveName(col)=="inv_bunker_vvd" || 
				  sheetObj.ColSaveName(col)=="inv_acct_itm_nm") {
					  
				  if(sheetObj.CellValue(row, "inv_bunker_vvd") != "" &&	  
				     sheetObj.CellValue(row, "inv_acct_itm_nm") != "") {

					  for(var i=0;i<=sheetObj.LastRow; i++ ) {
							if(i != row) {
								  if(sheetObj.CellValue(row, "inv_bunker_vvd") == sheetObj.CellValue(i, "inv_bunker_vvd") &&	  
								     sheetObj.CellValue(row, "inv_acct_itm_nm") == sheetObj.CellValue(i, "inv_acct_itm_nm") )  {
									  
									 if(!confirm(ComGetMsg('FMS20005', i))) {
										 sheetObj.CellValue(row,"inv_bunker_vvd") = "";
										 sheetObj.SelectCell(row, col);
									 }
							      }	
							}	  
					  }		
				  }	
		} else if(sheetObj.ColSaveName(col)== "inv_to_inv_no") {
					  
				  if(sheetObj.CellValue(row, "inv_to_inv_no") != "") {

					  for(var i=0;i<=sheetObj.LastRow; i++ ) {
							if(i != row) {
								  if(sheetObj.CellValue(row, "inv_to_inv_no") == sheetObj.CellValue(i, "inv_to_inv_no"))  {
									  
									 ComShowMessage(ComGetMsg('FMS20006', i));
									 sheetObj.CellValue(row,"inv_to_inv_no") = "";
									 sheetObj.SelectCell(row, col);
							      }	
							}	  
					  }		
				  }
		}
	}
	
	/**
     * Currency Code 정보를 가져온다 <br>
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     **/
    function setCurrCd(row) {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'CurrCd', row);
    }
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     **/
    function sheet1_OnClick(sheetObj, row, col) {
    	
    	var prefix = "inv_";
    	
    	if(sheetObj.CellValue(row, prefix + "pop_gb") != "SDMS") {
    		
	    	if(sheetObj.ColSaveName(col)== prefix + "bunker_vvd") {
	    		
	    		if(   (   sheetObj.CellValue(row, prefix + "slp_tp_cd") == "Y" 
	    			   || sheetObj.CellValue(row, prefix + "sdms_no") != "") 
	    		   && sheetObj.CellEditable(row, prefix + "bunker_vvd") == false) return;
	    		
	    		var chtrInvDtCol = sheetObj.SaveNameCol(prefix + "chtr_inv_dt");
	    		var chtrInvDtValue = sheetObj.CellValue(row,chtrInvDtCol);
	    		
	    		if(chtrInvDtValue == "" || chtrInvDtValue.length < 8) {
	    			ComShowMessage(ComGetMsg('FMS01143'));
	    			sheetObj.SelectCell(row, prefix + "chtr_inv_dt", true, "");
	    			sheetObj.ValidateFail = true;
	    			
	    			return;
	    		}
	
	    		var iType = sheetObj.ReadDataProperty(row, prefix + "bunker_vvd", dpDataType);
	    		
	    		if(iType == 6) return;
	
	    		form.rev_yrmon.value = chtrInvDtValue;
	 
	    		setVvdCombo(row);
	    	}
    	}
    }
    
    /**
     * Vvd 정보를 가져온다 <br>
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     **/
    function setVvdCombo(row) {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "Vvd", row);
    }
    
    /**
     * Vvd Combo 박스를 만든다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Vvd 의 코드값
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     **/
    function setVvdMakeCombo(sheetObj, comboText, row) {
    	if(comboText != "" ) {
    		var vvdCode = comboText.substring(0,comboText.length-1);
    		var vvdText = vvdCode;
        	var comboList = vvdCode.split("|");
        	
        	var dfCode = comboList[0];
 
        	sheetObj.InitCellProperty(row, "inv_bunker_vvd", dtCombo); 
        	sheetObj.CellComboItem(row, "inv_bunker_vvd", vvdText, vvdCode);
        	
        	sheetObj.CellEditable(row, "inv_bunker_vvd")= true;
    	}
    }
    
    /**
     * Invoice Date 와 Item Name 항목을 초기화한다 <br>
     **/
    function setItemClear() {
    	form.from_chtr_inv_dt.value = "";
    	form.to_chtr_inv_dt.value = "";
    	form.acct_itm_nm.value = "";
    	form.acct_cd.value = "";
    	form.acct_itm_seq.value = "";
    }
     
    /**
     * Charterer / Owner 변경시 Grid Data를 초기화한다 <br>
     **/
    function setDataClear(val) {
    	sheetObjects[0].RemoveAll();
    	sheetObjects[1].RemoveAll();
    	
    	document.all.totalAmount.style.display = "none";
    	
    	if(val == "P") {
    		ComBtnEnable("btn_sdms");
    	} else {
    		ComBtnDisable("btn_sdms");
    	}
    }
    
    
    /**
     * 데이타 조회시 스크롤바를  자동으로 컨트롤한다 <br>
     **/
	function controlScrollBar() {
		try{
			top.syncHeight()
		} catch(err){ComFuncErrMsg(err.message);}
	}
	
	/**
     * Currency 별 통화금액을 보여준다 <br>
     * @param {String}  totalAmount1   Currency 별 통화금액
     **/
	function setTotalAmount(totalAmount1) {
		document.all.totalAmount.style.display = "";
		document.all.totalAmount1.innerHTML = totalAmount1;
		document.all.totalAmount2.innerHTML = "&nbsp;";
		 
		controlScrollBar();
	}
	
	/**
     * Item Name 항목 초기화 <br>
     **/
	function setItemNameClear() {
		if(!form.chkItemName.checked) {
			form.acct_itm_nm.value = "";
			form.acct_cd.value = "";
			form.acct_itm_seq.value = "";
		}
	}
     
    /**
     * Check Box 초기화하기. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	변수 구분값
     * @return {없음}
     **/
	function initCheckBox(sheetObj, prefix) {
		for (var ir=1; ir<=sheetObj.LastRow; ir++) {
			sheetObj.CellValue2(ir,prefix+"DelChk") = 0;
		}
	}
     
    /**
     * IBSheet Grid의 입력값 중 숨겨지지 않은 가장 큰 값을 찾는다. <br>
     * @param {ibsheet} 	sheetObj    IBSheet Object
     * @return {arrExpDt} 	arrExpDt	가장 큰 To Date
     **/ 
  	function getMaxInvDtlSeq(sheetObj){
  		var arrInvDtlSeq = new Array();
  		var i = 0;
  		
  		for (var ir=sheetObj.HeaderRows; ir<=sheetObj.LastRow; ir++){
  			arrInvDtlSeq[i++] = sheetObj.CellText(ir,"inv_inv_dtl_seq");
  		}
  		
  		for(var j=0; j<arrInvDtlSeq.length; j++) {
  			for(var k=j; k<arrInvDtlSeq.length; k++) {
  				if(arrInvDtlSeq[j]<arrInvDtlSeq[k]) {
  					var tmp = arrInvDtlSeq[j];
  					arrInvDtlSeq[j] = arrInvDtlSeq[k];
  					arrInvDtlSeq[k] = tmp;
  				}
  			}
  		}
  		
  		return arrInvDtlSeq[0];
  	}
     
    /**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	
    	var prefix = "inv_";
    	
    	for(var ir=1; ir<=sheetObj.LastRow; ir++){
    		
    		if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, prefix + "curr_cd"))) {
				sheetObj.InitCellProperty(ir, 6, dtNull, daRight, prefix+ "inv_amt", "", dfNullInteger);
			}
    		
    		if(sheetObj.CellValue(ir, prefix + "slp_tp_cd") == "Y") {
    			sheetObj.CellEditable(ir, prefix + "DelChk") = false;
    			sheetObj.CellEditable(ir, prefix + "acct_itm_nm") = false;
    			sheetObj.CellEditable(ir, prefix + "curr_cd") = false;
    			sheetObj.CellEditable(ir, prefix + "inv_amt") = false;
    			sheetObj.CellEditable(ir, prefix + "chtr_inv_dt") = false;
    			sheetObj.CellEditable(ir, prefix + "to_inv_no") = false;
    			sheetObj.CellEditable(ir, prefix + "bunker_vvd") = false;
    			sheetObj.CellEditable(ir, prefix + "inv_desc") = false;
    		} else {
    			if(sheetObj.CellValue(ir, prefix + "sdms_no") != "") {
    				//sheetObj.CellEditable(ir, prefix + "DelChk") = false;
        			sheetObj.CellEditable(ir, prefix + "acct_itm_nm") = false;
        			sheetObj.CellEditable(ir, prefix + "curr_cd") = false;
        			sheetObj.CellEditable(ir, prefix + "inv_amt") = false;
        			sheetObj.CellEditable(ir, prefix + "chtr_inv_dt") = false;
        			sheetObj.CellEditable(ir, prefix + "to_inv_no") = false;
        			sheetObj.CellEditable(ir, prefix + "bunker_vvd") = false;
        			sheetObj.CellEditable(ir, prefix + "inv_desc") = false;
    			}
    		}
    	}
    	
 		ComColFontName(sheetObj, "10"); 	
	}	
 	
 	//선박 대 계약 자동 매치
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }	
    
    //2017.05.15 contract type 콤보로 변경
    function setDataCombo(comboObj, comboText, comboCode) {
		
        switch(comboObj.id) {
            case "flet_ctrt_tp_cd":
            	
            	if(comboText != "" ) {
	            	var comboTextList = comboText.split("|");
	            	var comboCodeList = comboCode.split("|");
	            	
	            	for(var i=0; i < comboTextList.length-1; i++) {
	            		comboObj.InsertItem(i, comboTextList[i], comboCodeList[i]);
	            	}
	            	
	            	comboObj.Code = comboCodeList[0];
	            	
	            	comboObj.BackColor = "#CCFFFD";
            	}
                break;
                
        } 
    }

    //2017.05.15 contract type 콤보로 변경
	function flet_ctrt_tp_cd_OnChange(idx_cd, text) {
		
		if(form.vsl_cd.value == "") return;	
	
		var f_query = "";					
		f_query += "f_cmd=" + SEARCH01; 
		f_query += "&vsl_cd="+form.vsl_cd.value;	 			
		f_query += "&type_flag="+text;  
	
		var sXml = sheetObjects[0].GetSearchXml("FMS_COMGS.do",f_query);
		var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
			
		if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
			form.flet_ctrt_no.value = varFletCtrtNo;
		}else{
			ComShowCodeMessage("FMS20001","Agreement");
			clearAll();
			return;
		}
			
		if(form.flet_ctrt_no.value != ""){
			contract_no_change();
		}
	}