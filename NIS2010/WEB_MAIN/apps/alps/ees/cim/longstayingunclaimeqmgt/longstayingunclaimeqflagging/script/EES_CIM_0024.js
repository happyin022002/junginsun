/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0024.js
*@FileTitle : L/S Flag Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.09.07 김종준
* 1.0 Creation
=========================================================*/
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var IBSEARCH01  = 29;
var IBSEARCH02  = 30;

var tot_cntr_tpsz_cd ="";
var obj_cntr_tpsz_cd ="";
var tot_cnmv_sts_cd ="";
var HeadTitleCnt =0;

var comboObjects = new Array();
var comboCnt = 0 ;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var shtCnt = 0;
         var sheetObject = sheetObjects[shtCnt++];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_loc_cd":	//Location 조회 팝업
	    	        var cnt_cd = "";
	    	        var loc_cd = "";
		            cnt_cd = formObject.loc_type_code.value;
		            loc_cd = formObject.loc_cd.value;
					if ( formObject.loc_type_code.value == '5' ) {	//yard
						ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do', 800, 480, "3:loc_cd", "1,0,1,1,1,1,1", true);
					} else {
	        			var loc_code = "";
	                    
	        			if ( form.loc_type_code.value == "1" ) {
	        				loc_code = "lcc_cd";
	        			} else if ( form.loc_type_code.value == "2" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( form.loc_type_code.value == "3" ) {
	        				loc_code = "ecc_cd";
	        			} else if ( form.loc_type_code.value == "4" ) {
	        				loc_code = "scc_cd";
	        			}
						var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, loc_code+":loc_cd", "0,1,1,1,1,1", true);
		            } 
					break; 	
				case "btn_new":
					formObject.reset();
					sheetObjects[0].WaitImageVisible = false;
					sheetObjects[0].CellValue2(0,"loc_cd") =  'Location';
				    comboObjects[0].Code = "";
				    comboObjects[1].Code = "";
				    comboObjects[2].Code = "";
					sheetObjects[0].Redraw = false;
					sheetObjects[0].RemoveAll();
					sheetObjects[0].Redraw = true;

				    break;
				case "btn_DownExcel":
	            	doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
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
    function loadPage( cnmv_sts_cd, cnmv_sts_nm ) {

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
	    makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
    }
    
    /**
     * MVMT Status 생성
     */    
    function makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm) {
        var arr_cnmv_sts_cd = cnmv_sts_cd.split("|");
        var arr_cnmv_sts_nm = cnmv_sts_nm.split("|");
        tot_cnmv_sts_cd = arr_cnmv_sts_cd;
        with (form.cnmv_sts_cd) {
        	MultiSelect = true;
            MultiSeparator = ",";
            DropHeight = 320;
        	InsertItem(0 , 'ALL','');
        	for ( var i=1; i<=arr_cnmv_sts_cd.length; i++) {
        		InsertItem(i, arr_cnmv_sts_cd[i-1], arr_cnmv_sts_nm[i-1]);
        	}
        } 
    }    

    /**
     *	sheet1 Load 종료시 이벤트 처리
     */    
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //TP/SZ,MVMT Status,Lease Term 데이타 가져오기
    	ComSetFocus(document.form.loc_cd);
    	document.getElementById("loc_cd").setAttribute("maxLength",5);
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
    	axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code', '');	//Location by 변경시 이벤트 처리
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');							//엔터키 조회 이벤트처리
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 				//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 			//form OnBeforeDeactivate이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress'  , form);						//알파벳 대문자,숫자만 입력허용
    	axon_event.addListener('blur', 'obj_blur', 'loc_cd');
    	axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');						//LOC_CD keyup 이벤트 처리
    }

	/**
     * TP/SZ 클릭 이벤트 처리
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
     * MVMT Status  클릭 이벤트 처리
    */
    function cnmv_sts_cd_OnCheckClick(comboObj, index, code) {
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
     * Lease Term  클릭 이벤트 처리
    */    
    function lstm_cd_OnCheckClick(comboObj, index, code) {
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
	* LOC_CD keyup 이벤트 처리
	* LOC_CD keyup시 대분자로 처리
	*/
    function loc_cd_onkeyUp() {
        var formObject = document.form;
        if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	        if ( formObject.loc_type_code.value == '5' ) {
	            if ( formObject.loc_cd.value.length > 1) {
	        	    document.getElementById("loc_cd").setAttribute("maxLength",7);
	        	    formObject.loc_cd.value = formObject.loc_cd.value.substring(0,7).toUpperCase();
	        	    if ( formObject.loc_cd.value.length == 7 ) {
	        	    	ComSetFocus(document.form.over_stay_days);
	        	    }
	            }
	        } else {
	            document.getElementById("loc_cd").setAttribute("maxLength",5);
        	    if ( formObject.loc_cd.value.length == 5 ) {
        	    	ComSetFocus(document.form.over_stay_days);
        	    }
	        }
	        formObject.loc_cd.value = formObject.loc_cd.value.toUpperCase();
        }
    }
    
    /**
     * loc_type_code 변경시 이벤트 처리
     */   
    function loc_type_code_onchange() {
        var formObject = document.form;
		if  ( formObject.loc_type_code.value == '5' ) {
			document.getElementById("loc_cd").setAttribute("maxLength",7);
		} else {
			document.getElementById("loc_cd").setAttribute("maxLength",5);
		}
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);		
    }   

	/**
	 * Location  blur 이벤트 처리
	 * Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
	}
    
	/**
     * 키이벤트 처리
    */  
 	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "loc_cd":
				ComKeyOnlyAlphabet('uppernum');		// 알파벳 대문자,숫자만 입력허용
				break;
			case "bkg_bl_type_cd":
				ComKeyOnlyAlphabet('uppernum');		// 알파벳 대문자,숫자만 입력허용
				break;
			case "over_stay_days":
				ComKeyOnlyNumber(event.srcElement);	// 알파벳 대문자,숫자만 입력허용
				break;
		}
	} 
 	
    /**
     * beforeactivate 이벤트 처리
     * beforeactivate -없애기
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
  	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,headTitle) {

        var cnt = 0;
        var shtID = sheetObj.id;

        switch(shtID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 430;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 3, 10, 100);
                    if (headTitle==null || headTitle =="") {
                    	headTitle = "Location|MVMT|Flag Status|Total|D2|D4|D5|D7|R2|R4|R5|R7|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4|T2|T4";
                    }
                    var headCount = ComCountHeadTitle(headTitle);                    

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount+1, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, headTitle, true);
                    sheetObj.FrozenCols = 4;
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtAutoSum,		75,	daCenterTop,	true,	"loc_cd",		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			80,	daCenterTop,	true,	"cnmv_sts_cd",			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			90, daCenterTop,  	false,	"flag_status",  false,	"",	dfNone);
                                                                              	
                    InitDataProperty(0, cnt++ , dtData,			60, daRight,  	false,	"total",   		false,	"",	dfNullInteger);
                    
                    for(var i=1 ; i <= headCount - 4 ; i++){
                    	InitDataProperty(0, cnt++ , dtData,  55,    daRight,		true,		"qty"+(i),			false,           "",      dfNullInteger,	0,     true,       true);
                    }
                    
                    cnt = 0;
                    InitDataProperty(1, cnt++ , dtData,			75,	daCenterTop,	true,	"loc_cd",		false,	"",	dfNone);
                    InitDataProperty(1, cnt++ , dtData,			80,	daCenterTop,	true,	"cnmv_sts_cd",			false,	"",	dfNone);
                    InitDataProperty(1, cnt++ , dtData,			90, daCenterTop,  	false,	"flag_status",  false,	"",	dfNone);
                                                                              	
                    InitDataProperty(1, cnt++ , dtData,			60, daRight,  	false,	"total",   		false,	"",	dfNullInteger);
                    
                    for(var i=1 ; i <= headCount - 4 ; i++){
                    	InitDataProperty(1, cnt++ , dtData,  55,    daRight,		true,		"qty"+(i),			false,           "",      dfNullInteger,	0,     true,       true);
                    }

                    cnt = 0;
                    InitDataProperty(2, cnt++ , dtData,			75,	daCenterTop,	true,	"loc_cd",		false,	"",	dfNone);
                    InitDataProperty(2, cnt++ , dtData,			80,	daCenterTop,	true,	"cnmv_sts_cd",			false,	"",	dfNone);
                    InitDataProperty(2, cnt++ , dtData,			90, daCenterTop,  	false,	"flag_status",  false,	"",	dfNone);
                                                                              	
                    InitDataProperty(2, cnt++ , dtData,			60, daRight,  	false,	"total",   		false,	"",	dfNone);
                    
                    for(var i=1 ; i <= headCount - 4 ; i++){
                    	InitDataProperty(2, cnt++ , dtData,  55,    daRight,		true,		"qty"+(i),			false,           "",      dfNone,	0,     true,       true);
                    }

                    
                    InitDataProperty(0, cnt++ , dtHidden,      100,    daLeft,		true,		"lvl",			false,  "",      dfNone,			0,     true,       true);
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
         		sheetObj.WaitImageVisible=false;
         		ComOpenWait(true); 

	            formObj.f_cmd.value = SEARCH;
	            sheetObj.Redraw = false;
		        sheetObj.DoSearch("EES_CIM_0024GS.do",FormQueryString(formObj));
         		ComOpenWait(false); 
         		break;
        	case IBSEARCH01:      //공통조회
         		sheetObj.WaitImageVisible = false;
    			form.f_cmd.value = SEARCH01;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0024GS.do" , FormQueryString(form));
    			var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");	   //TP/SZ 조회
    			formObj.tot_cntr_tpsz_cd.value = cntr_tpsz_cd;
    			tot_cntr_tpsz_cd = cntr_tpsz_cd;
    			var strCntrTpszCd  = cntr_tpsz_cd.split("|");
    			HeadTitleCnt = strCntrTpszCd.length+4;
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
    			//헤더 타이틀 세팅
				for ( var i=0; i<cntr_tpsz_cd.split("|").length; i++) {
					sheetObj.CellValue2(0,i+4) =  strCntrTpszCd[i];
				}
				
				var location ="";
				if ( document.form.loc_type_code.value == '1' ) {
					location =  'ECC';
				} else if  ( document.form.loc_type_code.value == '2' ) {
					location =  'LCC';
				} else if  ( document.form.loc_type_code.value == '3' ) {
					location =  'SCC';
				} else if  ( document.form.loc_type_code.value == '4' ) {
					location =  'Yard';
				} else if  ( document.form.loc_type_code.value == '5' ) {
					location =  'Yard';
				}
	            var HeadTitle = "Location|MVMT|Flag Status|Total|"+tot_cntr_tpsz_cd;
	             
	            sheetObj.Redraw = false;
	            sheetObj.RemoveAll();
	            sheetObj.Reset();
	            initSheet(sheetObj,1,HeadTitle);
	            sheetObj.Redraw = true;                
    			
                //Lease Term
                var sLeaseTermNm = ComGetEtcData(sXml,"lease_term_nm");
                var sLeaseTermCd = ComGetEtcData(sXml,"lease_term_cd");
   	            
                var arrLeaseTermNm = sLeaseTermNm.split("|");
                var arrLeaseTermCd = sLeaseTermCd.split("|");
                tot_lstm_cd = arrLeaseTermCd;
   	            
                with (form.lstm_cd) {
                	MultiSelect = true;
   	             	MultiSeparator = ",";
   	             	DropHeight = 320;
   	             	InsertItem(0 , 'ALL','');
   	             	for ( var i=1; i<=arrLeaseTermCd.length; i++) {
   	             		InsertItem(i, arrLeaseTermCd[i-1], arrLeaseTermNm[i-1]);
   	             	}
   	         	}   
    			
    			break; 
        	case IBSEARCH02:      //location cd유효성 체크
				var inquiryLevel = "";
				if ( formObj.loc_type_code.value == '1') {
					inquiryLevel = "L";
				} else if  ( formObj.loc_type_code.value == '2' ) {
					inquiryLevel = "R";
				} else if  ( formObj.loc_type_code.value == '3' ) {
					inquiryLevel = "E";
				} else if  ( formObj.loc_type_code.value == '4' ) {
					inquiryLevel = "S";
				} else if  ( formObj.loc_type_code.value == '5' ) {
					inquiryLevel = "Y";
				} 
				formObj.inquiryLevel.value = inquiryLevel;
				formObj.location.value = formObj.loc_cd.value;
				
				formObj.f_cmd.value = SEARCH02;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0024GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						ComShowCodeMessage("CIM30013","Location code");
						document.form.loc_cd.value = "";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						ComSetFocus(document.form.loc_cd); 
						return true;
					}
				} else {
					ComSetFocus(document.form.over_stay_days);
				}
				break;	    			
			case IBDOWNEXCEL:      // 입력
				sheetObj.Down2Excel(-1, false, false, true);
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
     	    } else {

     	    	if (!ComChkValid(formObj)) return false;
     	    }
        }
        return true;
    }

    /**
     * 화면 조회 종료후 프로세스 처리
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		if ( document.form.loc_type_code.value == '1' ) {
			sheetObj.CellValue2(0,"loc_cd") =  'ECC';
		} else if  ( document.form.loc_type_code.value == '2' ) {
			sheetObj.CellValue2(0,"loc_cd") =  'LCC';
		} else if  ( document.form.loc_type_code.value == '3' ) {
			sheetObj.CellValue2(0,"loc_cd") =  'SCC';
		} else if  ( document.form.loc_type_code.value == '4' ) {
			sheetObj.CellValue2(0,"loc_cd") =  'Yard';
		} else if  ( document.form.loc_type_code.value == '5' ) {
			sheetObj.CellValue2(0,"loc_cd") =  'Yard';
		}
		if ( sheetObj.rowCount != 0 ) {
			for(var i = 1; i <= sheetObj.LastRow; i++)
			{
	    		if( sheetObj.CellValue(i,"lvl") == '001' || sheetObj.CellValue(i,"lvl") == '011'){
	    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
	    			
	    		}
			}
	    	for ( var i=sheetObj.LastRow-5; i<sheetObj.LastRow-2; i++) {
	    		for ( var j=2; j<HeadTitleCnt; j++ ) {
	    			sheetObj.CellValue2(i+3,j) =  sheetObj.CellValue(i, j);
	    	    	sheetObj.CellAlign(i+3,"cnmv_sts_cd") = daCenter;
	    			
	    		}
	    	}
	    	sheetObj.RowDelete(sheetObj.LastRow-5, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-4, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-3, false);
	    	sheetObj.CellValue2 (sheetObj.LastRow-2,0) = 'G.Total';

	    	sheetObj.CellAlign(sheetObj.LastRow-2,"flag_status") = daCenter;
	    	sheetObj.CellAlign(sheetObj.LastRow-1,"flag_status") = daCenter;
	    	sheetObj.CellAlign(sheetObj.LastRow,"flag_status") = daCenter;

	    	sheetObj.CellAlign(sheetObj.LastRow-2,"loc_cd") = daCenterTop;
	    	sheetObj.CellAlign(sheetObj.LastRow-1,"loc_cd") = daCenterTop;
	    	sheetObj.CellAlign(sheetObj.LastRow,"loc_cd") = daCenterTop;
	    	
	    	sheetObj.SetMergeCell (sheetObj.LastRow-2, 0, 3, 2);
		}    	
		sheetObj.SelectHighLight = false;
		sheetObj.Redraw = true;
	}
	
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }	
		
