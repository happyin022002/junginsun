/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0028.js
*@FileTitle : Stock Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.12 김종준
* 1.0 Creation
 * ======================================================
 * 2011.03.16 남궁진호 [CHM-201109288-01]Location Code 숫자입력가능하게수정
 *                    ComKeyOnlyAlphabet('upper') ->ComKeyOnlyAlphabet('uppernum')
=========================================================*/

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var headCnt  = 0;
var tot_cntr_tpsz_cd ="";
var obj_cntr_tpsz_cd ="";
var comboObjects = new Array();
var comboCnt = 0 ;

var IBSEARCH01  = 29;
var IBSEARCH02  = 30;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var shtCnt = 0;
        var sheet1 = sheetObjects[shtCnt++];


        /*******************************************************/
        var formObject = document.form;
 		var yard_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"loc_cd");
		var cntr_tpsz_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cntr_tpsz_cd");
		var loc_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"loc_cd");
		var lvl = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"lvl");

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_Retrieve":
                    doActionIBSheet(sheet1,formObject,IBSEARCH);
                    break;

                case "btn_downexcel":
                	doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
                    break;

                case "btn_new":
                    sheet1.RemoveAll();
                    formObject.reset();
                    comboObjects[0].Code = "";
                    ComSetFocus(document.form.loc_cd);
                    break;

                case "btn_cntrdata":
                	if ( sheetObjects[0].rowCount > 0 ) {
                		if ( formObject.param_loc_type_code.value == '4' ) {	//yard
                			yard_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"loc_cd"); 
                		} else {
                			yard_cd = '';
                		}
                		if ( yard_cd == 'Total' ) {
                			yard_cd = '';
                		}
                		if ( sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"lvl") == '10' ) {	//total
                			loc_cd = formObject.param_loc_cd.value;
                		} else if ( sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"lvl") == '01' ) {	//sub total
                			cntr_tpsz_cd = "";
                		} else {
                			loc_cd = loc_cd.substr(0,5);
                		}
                		
                    	var param = "loc_cd=" + loc_cd
                		   +"&loc_type_code=" + formObject.param_loc_type_code.value
                		   +"&cntr_tpsz_cd=" + cntr_tpsz_cd
                		   +"&fm_stk_jb_dt=" + formObject.param_fm_stk_jb_dt.value
                		   +"&to_stk_jb_dt=" + formObject.param_to_stk_jb_dt.value
                		   +"&yard_cd=" + yard_cd
                		   +"&lvl=" + lvl
                		   +"&obj_cntr_tpsz_cd=" + obj_cntr_tpsz_cd;
		 		 		ComOpenPopup("/hanjin/EES_CIM_0029.do?"+ param,700, 468, "", "1,0,1,1,1,1,1,1", true);
                	}
                    break; 
                     
                case "btn_duedata":
                	if ( sheetObjects[0].rowCount > 0 ) {
                		if ( formObject.param_loc_type_code.value == '4' ) {	//yard
                			yard_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"loc_cd"); 
                		} else {
                			yard_cd = '';
                		}
                		if ( yard_cd == 'Total' ) {
                			yard_cd = '';
                		}
                		if ( sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"lvl") == '10' ) {	//total
                			loc_cd = formObject.param_loc_cd.value;
                		} else if ( sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"lvl") == '01' ) {	//sub total
                			cntr_tpsz_cd = "";
                		} else {
                			loc_cd = loc_cd.substr(0,5);
                		}
                		
                    	var param = "loc_cd=" + loc_cd
                		   +"&loc_type_code=" + formObject.param_loc_type_code.value
                		   +"&cntr_tpsz_cd=" + cntr_tpsz_cd
                		   +"&fm_stk_jb_dt=" + formObject.param_fm_stk_jb_dt.value
                		   +"&to_stk_jb_dt=" + formObject.param_to_stk_jb_dt.value
                		   +"&yard_cd=" + yard_cd
                		   +"&lvl=" + lvl
                		   +"&obj_cntr_tpsz_cd=" + obj_cntr_tpsz_cd;
                		ComOpenPopup("/hanjin/EES_CIM_0030.do?"+ param,900, 445, "", "1,0,1,1,1,1,1,1", true);
                	}
	 		 		break;
                case "btn_detail":
                	if ( formObject.param_loc_type_code.value != '4' && sheetObjects[0].rowCount > 0 ) {
                		if ( sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"lvl") == '10' ) {
                			yard_cd = "";
                			loc_cd = formObject.param_loc_cd.value;
                		} else if ( sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"lvl") == '01' ) {
                			cntr_tpsz_cd = "";
                		}
                    	var param = "loc_cd=" + loc_cd
                		   +"&loc_type_code=" + formObject.param_loc_type_code.value
                		   +"&fm_stk_jb_dt=" + formObject.param_fm_stk_jb_dt.value
                		   +"&to_stk_jb_dt=" + formObject.param_to_stk_jb_dt.value
                		   +"&yard_cd=" + yard_cd
                		   +"&obj_cntr_tpsz_cd=" + obj_cntr_tpsz_cd;                    		
                		ComOpenPopup("/hanjin/EES_CIM_0031.do?"+ param,930, 435, "", "1,0,1,1,1,1,1,1", true);
                	}
                    break;
    			case "btn_loc_cd":	//Location 조회 팝업
    		    	var loc_code = "";
    		      	if ( document.form.loc_type_code[0].checked ) {
    		      		loc_code = 'rcc_cd';
    		      	} else if ( document.form.loc_type_code[1].checked ) {
    		      		loc_code = 'lcc_cd';
    		      	} else if ( document.form.loc_type_code[2].checked ) {
    		      		loc_code = 'ecc_cd';
    		      	} else if ( document.form.loc_type_code[3].checked ) {
    		      		loc_code = 'scc_cd';
    		      	}
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, loc_code+":loc_cd", "0,1,1,1,1,1", true);
    				break;
    			case "btns_calendarfm":
					var cal = new ComCalendar();
					cal.select(formObject.fm_stk_jb_dt, 'yyyy-MM-dd');
    				break;	
    			case "btns_calendarto":
					var cal = new ComCalendar();
					cal.select(formObject.to_stk_jb_dt, 'yyyy-MM-dd');
    				break;	
        		case "btn_save":
        			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
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

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1); 
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

	    for(p=0;p< comboObjects.length;p++){
	    	initCombo (comboObjects[p],p+1);
	    }
        
        initControl();
    }

    /**
     * sheet1 로딩 완료시 이벤트 후출
     * TP/SZ 데이타 가져오기
    */
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
    }        
    
    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
     function setComboObject(combo_obj){
         comboObjects[comboCnt++] = combo_obj;
     }
     
     /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
     function initCombo (comboObj, comboNo) {
     	
     }    
    
    /**
     * 초기 이벤트 등록 
     */
    function initControl() {
    	axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');							//LOC_CD keyup 이벤트 처리
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');								//엔터키 조회 이벤트처리
     	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 					//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
     	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 				//form OnBeforeDeactivate이벤트에 코드 처리
     	axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , form);
     	axon_event.addListenerFormat('keyup'        , 'obj_keyup'  , form);
     	axon_event.addListenerFormat('blur', 'obj_blur', form);
    } 

    /**
     * TP/SZ  클릭 이벤트 등록
     */
    function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
    }
	/**
	 * Location  blur 이벤트 처리
	 * Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		switch (event.srcElement.name) {
			case "loc_cd":
				if ( document.form.loc_cd.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
				}
				break;
				
		}
	}

    /**
     * key press 처리
    */
	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "loc_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "fm_stk_jb_dt":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "to_stk_jb_dt":
				ComKeyOnlyNumber(event.srcElement);
				break;	
		}
	}

    /**
     * KEY UP 이벤트 처리
    */
	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "fm_stk_jb_dt":
				if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40  && event.keyCode != 229 ) {
					if ( document.form.fm_stk_jb_dt.value.length == 8 ) {
						document.form.to_stk_jb_dt.value = ''
						ComSetFocus(document.form.to_stk_jb_dt);
					}
				}
				break;
			case "to_stk_jb_dt":
				if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 && event.keyCode != 229 ) {
					if ( document.form.to_stk_jb_dt.value.length == 8 ) {
						if(ComChkPeriod(document.form.fm_stk_jb_dt.value.trimAll("-"), document.form.to_stk_jb_dt.value.trimAll("-")) < 1) {
		    	  			ComShowMessage(ComGetMsg("CIM30020", "To", "FM", "greater"));
		    	  			document.form.to_stk_jb_dt.value = ''
		    	  			document.form.to_stk_jb_dt.focus();
		    	  			return false;
		    	  		}
						
					}
				}
				break;
				
		}
	}	
	
    /**
     * LOC_CD keyup 이벤트 처리
     * LOC_CD keyup시 대분자로 처리
     */
    function loc_cd_onkeyUp() {
    	var formObject = document.form;
		if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
			document.getElementById("loc_cd").setAttribute("maxLength",5);
		    if ( formObject.loc_cd.value.length == 5 ) {
		    	ComSetFocus(document.form.cntr_tpsz_cd);
		    }
		    formObject.loc_cd.value = formObject.loc_cd.value.toUpperCase();
		}
    }

    /**
     * Period FM  beforeactivate 이벤트 처리
     * Period FM  beforeactivate -없애기
     */    
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
    /**
	* Period to  beforedeactivate 이벤트 처리
	* Period to  beforedeactivate YYYY-MM 포멧 처리
	*/	
	function obj_deactivate() {
		ComClearSeparator(event.srcElement);
		obj = event.srcElement;
		if (obj.name == "fm_stk_jb_dt") {
			ComAddSeparator(event.srcElement);
		} else if (obj.name == "to_stk_jb_dt") {
			ComAddSeparator(event.srcElement);
		}
		

	}
	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id ; 

        switch(sheetID) {
            
             case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 422;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);


                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false)
                   
                    var HeadTitle1 = "SCC|TP/SZ|Available|Sound|Damage|Total|Due Out|Due In|Optimum|Variance||";
                     
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    headCnt  = HeadTitle1.split("|").length;
                    InitColumnInfo(headCnt, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtAutoSum, 	  	 65,    daCenterTop, 	true,     "loc_cd",    		false,          "",      dfNone     );
                    InitDataProperty(0, cnt++ , dtData, 	  	 100,   daCenterTop, 	true,     "cntr_tpsz_cd",  	false,          "",      dfNone     );

                    InitDataProperty(0, cnt++ , dtData, 		98,  	daRight,  		true,     "aval_qty",  		false,          "",      dfNullInteger,       0     );
                    InitDataProperty(0, cnt++ , dtData, 		95,    	daRight,  		true,     "snd_qty",      	false,          "",      dfNullInteger,       0     );
                    InitDataProperty(0, cnt++ , dtData, 	 	100,    daRight,  		true,     "dmg_qty",     	false,          "",      dfNullInteger,       0     );
                    InitDataProperty(0, cnt++ , dtData,     	100,    daRight,  		true,     "tot_qty", 		false,          "",      dfNullInteger,       0     );
                                                                                                                               
                    InitDataProperty(0, cnt++ , dtData,    		95,    	daRight,  		true,     "due_out_qty",  	false,          "",      dfNullInteger,       0     );
                    InitDataProperty(0, cnt++ , dtData,     	95,    	daRight,  		true,     "due_in_qty",     false,          "",      dfNullInteger,       0     );
                    InitDataProperty(0, cnt++ , dtData,   		95,    	daRight,  		true,     "cntr_qty",    	false,          "",      dfNone,       0, true, true,6     );
                    InitDataProperty(0, cnt++ , dtData,  		95,    	daRight,  		true,     "vari_qty",		false,          "",      dfNullInteger,       0     );
                    InitDataProperty(0, cnt++ , dtHidden,  		95,    	daRight,  		true,     "lvl",			false,          "",      dfNone,      		  0     );
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  	daCenter, 		false, 	  "ibflag");

                    InitDataValid(0, "cntr_qty", vtNumericOnly);
                    
                    EditableColorDiff = false; 
                    CountPosition = 0;	//페이지카운트 없애기
                    
                }
                break; 

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

           case IBSEARCH:      //조회
	    	   if(!validateForm(sheetObj,formObj,sAction)) return;

	    	  	if(formObj.fm_stk_jb_dt.value != "" && formObj.to_stk_jb_dt.value != "") {
	    	  		if(ComReplaceStr(formObj.fm_stk_jb_dt.value,"-","") > ComReplaceStr(formObj.to_stk_jb_dt.value,"-","")) {
	    	  			ComShowMessage(ComGetMsg("CIM30020", "To", "FM", "greater"));
	    	  			formObj.to_stk_jb_dt.focus();
	    	  			return false;
	    	  		}
	    	  	}
	    	  	if ( eval(ComGetDaysBetween(formObj.chk_date.value, formObj.fm_stk_jb_dt.value)) < 0 ) {	//시스템날짜 기준 90일 이전이라면
	    	  		if ( formObj.to_stk_jb_dt.value == "" ) {	//to는 필수
	    	  			ComShowMessage(ComGetMsg("CIM30014", "To"));
	    	  			ComSetFocus(formObj.to_stk_jb_dt);
	    	  			return false;
	    	  		} else {
	    	  			if ( eval(ComGetDaysBetween(formObj.fm_stk_jb_dt.value, formObj.to_stk_jb_dt.value)) > 100 ) {	//from ~ to 기간이 100일 이상이라면
	    	  				ComShowMessage(ComGetMsg("COM132001","Period","100 Day"));
	    	  				ComSetFocus(formObj.fm_stk_jb_dt);
	    	  				return false;
	    	  			}
	    	  		}
	    	  	}

	    	   sheetObj.WaitImageVisible=false;
	    	   ComOpenWait(true); 
	    	   formObj.f_cmd.value = SEARCH;
	    	   sheetObj.DoSearch("EES_CIM_0028GS.do",FormQueryString(formObj));
	    	   ComOpenWait(false); 
	    	   break;
           case IBSEARCH01:      //공통조회
        	   sheetObj.WaitImageVisible = false;
        	   form.f_cmd.value = SEARCH01;
        	   var sXml = sheetObj.GetSearchXml("EES_CIM_0028GS.do" , FormQueryString(form));
        	   var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");	   //TP/SZ 조회
        	   tot_cntr_tpsz_cd = cntr_tpsz_cd;
        	   obj_cntr_tpsz_cd = cntr_tpsz_cd;
        	   var strCntrTpszCd  = cntr_tpsz_cd.split("|");
        	   //멀티콤보초기화
        	   with (form.cntr_tpsz_cd) {
        		   MultiSelect = true;
        		   MultiSeparator = ",";
        		   DropHeight = 330;
        		   InsertItem(0 , 'ALL','');
        		   for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
        			   InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
        		   }
        	   }    
        	   ComSetFocus(document.form.loc_cd);
	    	   break;
	       	case IBSEARCH02:      //location cd유효성 체크
				var inquiryLevel = "";
		      	if ( document.form.loc_type_code[0].checked ) {
		      		inquiryLevel = 'R';
		      	} else if ( document.form.loc_type_code[1].checked ) {
		      		inquiryLevel = 'L';
		      	} else if ( document.form.loc_type_code[2].checked ) {
		      		inquiryLevel = 'E';
		      	} else if ( document.form.loc_type_code[3].checked ) {
		      		inquiryLevel = 'S';
		      	}
		      	
				formObj.inquiryLevel.value = inquiryLevel;
				formObj.location.value = formObj.loc_cd.value;
				
				formObj.f_cmd.value = SEARCH02;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0028GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						ComShowCodeMessage("CIM30017");
						document.form.loc_cd.value = "";
						ComSetFocus(document.form.loc_cd);
						return false;
	
					} else {
						ComSetFocus(document.form.loc_cd);
						return true;
					}
				} else {
					ComSetFocus(document.form.cntr_tpsz_cd);
				}
				break;	    		    	   
           case IBSAVE:        //저장
	    	   if ( document.form.param_loc_type_code.value != '4' ) {	//yard
	    		   ComShowCodeMessage("CIM30018");
	    		   return;
	    	   }
	    	   if(validateForm(sheetObj,formObj,sAction))
	    		   
	    	   formObj.f_cmd.value = MULTI;
	    	   sheetObj.DoSave("EES_CIM_0028GS.do",FormQueryString(formObj),"ibflag",true);
		       break;
   		case IBDOWNEXCEL:      // 엑섹다운로드 
   			sheetObj.Down2Excel(0,false,false,true,'','',false,false,'',false,'lvl|ibflag');
			break;		       
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	
            if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
            	return false;
            }

        	if (!ComChkValid(formObj)) return false;
        }
        return true;
    }

    /**
     * sheet1 조회종료
     * sheet1 조회종료후 이벤트 호출
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObject = document.form;

      	if ( sheetObj.rowCount > 0 ) {
		   	for ( var j=0; j<headCnt; j++ ) {
				sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
				if ( eval(ComReplaceStr(sheetObj.CellValue(sheetObj.LastRow,"cntr_qty"),",","")) >= 0 ) {
					sheetObj.CellFontColor(sheetObj.LastRow,"cntr_qty") = sheetObj.RgbColor(0,0,255);
				} else {
					sheetObj.CellFontColor(sheetObj.LastRow,"cntr_qty") = sheetObj.RgbColor(255,0,0);
				}
				if ( eval(ComReplaceStr(sheetObj.CellValue(sheetObj.LastRow,"vari_qty"),",","")) >= 0 ) {
					sheetObj.CellFontColor(sheetObj.LastRow,"vari_qty") = sheetObj.RgbColor(0,0,255);
				} else {
					sheetObj.CellFontColor(sheetObj.LastRow,"vari_qty") = sheetObj.RgbColor(255,0,0);
				}
				
			}
		   	sheetObj.RowDelete(sheetObj.LastRow-1, false);
	    	sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
	    	sheetObj.CellValue(sheetObj.LastRow,"loc_cd") = '';

	      	sheetObj.CellValue2(sheetObj.LastRow, "loc_cd") = "G.Total";
	      	sheetObj.SetMergeCell (sheetObj.LastRow, 0, 1, 2);
	    	
	    	var param_loc_type_code = "";
	      	if ( document.form.loc_type_code[0].checked ) {
	      		sheetObj.CellValue(0,"loc_cd") = 'SCC';
	      		param_loc_type_code = "1";
	      	} else if ( document.form.loc_type_code[1].checked ) {
	      		sheetObj.CellValue(0,"loc_cd") = 'SCC';
	      		param_loc_type_code = "2";
	      	} else if ( document.form.loc_type_code[2].checked ) {
	      		sheetObj.CellValue(0,"loc_cd") = 'SCC';
	      		param_loc_type_code = "3";
	      	} else if ( document.form.loc_type_code[3].checked ) {
	      		sheetObj.CellValue(0,"loc_cd") = 'Yard';
	      		param_loc_type_code = "4";
	      	}
	      	
	      	formObject.param_loc_cd.value = formObject.loc_cd.value; 
	      	formObject.param_loc_type_code.value = param_loc_type_code; 
	      	formObject.param_cntr_tpsz_cd.value = comboObjects[0].Code; 
	      	formObject.param_fm_stk_jb_dt.value = formObject.fm_stk_jb_dt.value; 
	      	formObject.param_to_stk_jb_dt.value = formObject.to_stk_jb_dt.value;
	      	
	      	if ( param_loc_type_code == '4') { 
	      		ComBtnDisable('btn_detail');
	      	} else {
	      		ComBtnEnable('btn_detail');
	      	}
      	}
      	sheetObj.SelectHighLight = false;
    }

    /**
     * Location by loc_cd 팝업에서 선택한 값 Setting.
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
       var sheetObject = sheetObjects[0];
       var formObject = document.form;
       formObject.loc_cd.value = aryPopupData[0][3] 
    }
    
    /**
     * 셀에 키입력 했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     **/
    function sheet1_OnAfterEdit(sheetObj, Row, Col) {
    	switch (sheetObj.ColSaveName(Col)) {
    		case "cntr_qty":
    			setCaluValue(sheetObj, Row, Col);
    			break;
    	}
    }

    /**
     * Variance = Available - Optimum 계산식 적용
    */    
	function setCaluValue(sheetObj, Row, Col) {
		sheetObj.CellValue2(Row, "vari_qty") = sheetObj.CellValue(Row, "aval_qty") - sheetObj.CellValue(Row, "cntr_qty");
		var tot_pos_cntr_qty = 0;	//Yard 별 합산  Total 로우
		var tot_row_cntr_qty = 0;	
		var tot_cntr_qty = 0;

		var tot_pos_vari_qty = 0;	//Yard 별 합산  Total 로우

		var tot_fos_tpsz_row = 0;
		var tot_row_vari_row = 0;

		var tot_fos_tpsz_row = 0;
		var tot_vari_qty = 0;
		for ( var i=1; i<=sheetObj.rowCount; i++ ) {
			if ( sheetObj.CellValue(i, "loc_cd") == sheetObj.CellValue(Row, "loc_cd") && sheetObj.CellValue(i, "lvl") != "01"  ) {
				tot_pos_cntr_qty = tot_pos_cntr_qty + eval(ComReplaceStr(sheetObj.CellValue(i, "cntr_qty"),",",""));
				tot_pos_vari_qty = tot_pos_vari_qty + eval(ComReplaceStr(sheetObj.CellValue(i, "vari_qty"),",",""));
			}
			if ( sheetObj.CellValue(i, "loc_cd") == sheetObj.CellValue(Row, "loc_cd") && sheetObj.CellValue(i, "lvl") == "01"  ) {
				tot_row_cntr_qty = i;
			}
			
			if ( sheetObj.CellValue(i, "cntr_tpsz_cd") == sheetObj.CellValue(Row, "cntr_tpsz_cd") && sheetObj.CellValue(i, "lvl") == "00" ) {
				tot_fos_tpsz_row = tot_fos_tpsz_row + eval(ComReplaceStr(sheetObj.CellValue(i, "cntr_qty"),",",""));
				tot_row_vari_row = tot_row_vari_row + eval(ComReplaceStr(sheetObj.CellValue(i, "vari_qty"),",",""));
			}
			if ( sheetObj.CellValue(i, "cntr_tpsz_cd") == sheetObj.CellValue(Row, "cntr_tpsz_cd") && sheetObj.CellValue(i, "lvl") == "10" ) {
				tot_row_tpsz_row = i;
			}
				
		}
		sheetObj.CellValue2(tot_row_cntr_qty, "cntr_qty") = tot_pos_cntr_qty;
		sheetObj.CellValue2(tot_row_tpsz_row, "cntr_qty") = tot_fos_tpsz_row;

		sheetObj.CellValue2(tot_row_cntr_qty, "vari_qty") = tot_pos_vari_qty;
		sheetObj.CellValue2(tot_row_tpsz_row, "vari_qty") = tot_row_vari_row;
		sheetObj.RowStatus(tot_row_cntr_qty) = "R";
		sheetObj.RowStatus(tot_row_tpsz_row) = "R";
		for ( var i=1; i<=sheetObj.rowCount; i++ ) {
			if ( sheetObj.CellValue(i, "lvl") == "10"  ) {
				tot_cntr_qty = tot_cntr_qty + eval(ComReplaceStr(sheetObj.CellValue(i, "cntr_qty"),",",""));
				tot_vari_qty = tot_vari_qty + eval(ComReplaceStr(sheetObj.CellValue(i, "vari_qty"),",",""));
			}
		}
		sheetObj.CellValue2(sheetObj.LastRow, "cntr_qty") = tot_cntr_qty; 
		sheetObj.CellValue2(sheetObj.LastRow, "vari_qty") = tot_vari_qty;

		if ( eval(ComReplaceStr(sheetObj.CellValue(sheetObj.LastRow,"cntr_qty"),",","")) >= 0 ) {
			sheetObj.CellFontColor(sheetObj.LastRow,"cntr_qty") = sheetObj.RgbColor(0,0,255);
		} else {
			sheetObj.CellFontColor(sheetObj.LastRow,"cntr_qty") = sheetObj.RgbColor(255,0,0);
		}
		if ( eval(ComReplaceStr(sheetObj.CellValue(sheetObj.LastRow,"vari_qty"),",","")) >= 0 ) {
			sheetObj.CellFontColor(sheetObj.LastRow,"vari_qty") = sheetObj.RgbColor(0,0,255);
		} else {
			sheetObj.CellFontColor(sheetObj.LastRow,"vari_qty") = sheetObj.RgbColor(255,0,0);
		}

		
		sheetObj.CellValue2(sheetObj.LastRow, "loc_cd") = "G.Total";
		sheetObj.SetMergeCell (sheetObj.LastRow, 0, 1, 2);
		
		if ( eval(sheetObj.CellValue(Row, "vari_qty")) >= 0 ) {
			sheetObj.CellFontColor(Row,"vari_qty") = sheetObj.RgbColor(0,0,255);
		} else {
			sheetObj.CellFontColor(Row,"vari_qty") = sheetObj.RgbColor(255,0,0);
		}
	}
    
    /**
     * 저장 완료시 처리
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
      	sheetObj.CellValue2(sheetObj.LastRow, "loc_cd") = "G.Total";
      	sheetObj.CellValue2(sheetObj.LastRow, "cntr_tpsz_cd") = "G.Total";
      	sheetObj.SetMergeCell (sheetObj.LastRow, 0, 1, 2);
      	sheetObj.Redraw = true;
    }

    /**
     * 재조회
    */    
	function popupCloseEnd() {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}

	/**
	 * 화면 폼입력시 널입력시 0으로 변환
	 */	
    function sheet1_OnKeyUp(sheetObject, Row, Col, Value) {
    	if (Col ==8) {	//image_button 아닐때
	    	if ( sheetObject.CellValue(Row,Col) == '' ) {	//data format int형 널 방지
	    		sheetObject.CellValue2(Row,Col) = 0;
	    	}
    	}
    }    
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트
     * 선택시 선택행 배경색 세팅
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }	    