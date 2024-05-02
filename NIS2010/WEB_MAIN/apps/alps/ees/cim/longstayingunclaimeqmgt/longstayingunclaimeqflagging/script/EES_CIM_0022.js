/*=========================================================
*Copyright(c) 2009 CyberLogitec  
*@FileName : EES_CIM_0022.js
*@FileTitle : Container Staying Days (Summary)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.09.01 김종준
* 1.0 Creation
*========================================================
* 2011.01.12 [CHM-201108185-01] 남궁진호  sheet1_OnChange,sheet1_OnSearchEnd
*      - MTY Container에 대해 U/C Flagging을 제거할수 있도록 로직 변경
*      - MTY Container일때 L/C Pending 안되던 오류 수정
* 2012.09.19 신자영 [CHM-201220003-01] L/S U/C CREATION - COR DRAFT 기능 개발
* 2013.03.15 이영두 [CHM-201323425] LOAD EXCEL 기능 추가 개발
=========================================================*/
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var IBSEARCH01  = 29;
var IBSEARCH02  = 30;
var IBSEARCH03  = 31;

var tot_cntr_tpsz_cd ="";
var tot_cnmv_sts_cd ="";

var comboObjects = new Array();
var comboCnt = 0 ;

var pendingFalg = false;
var focCntrTpszCd = "";
var focCnmvStsCd = "";
var focFullFlg = "";
var focLocTypeCode = "";
var focLocCd = "";
var focLstmCd ="";

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
			            if ( formObject.loc_type_code.value != '' ) {	
		        			var loc_code = "";
		                    
		        			if ( form.loc_type_code.value == "1" ) {
		        				loc_code = "rcc_cd";
		        			} else if ( form.loc_type_code.value == "2" ) {
		        				loc_code = "ecc_cd";
		        			} else if ( form.loc_type_code.value == "3" ) {
		        				loc_code = "scc_cd";
		        			} else if ( form.loc_type_code.value == "4" ) {
		        				loc_code = "rcc_cd";
		        			}
		        			
							var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
							ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 456, loc_code+":loc_cd", "0,1,1,1,1,1", true);
			            }
						break; 	
					case "search_cust_cd":
						ComOpenPopupWithTarget('/hanjin/COM_ENS_041.do', 770, 473, "cust_cd:cust_cd", '1,0,1,1,1,1,1,1,1,1', true);
						break; 	
					case "search_rep_cmdt_cd":
						ComOpenPopupWithTarget('/hanjin/COM_ENS_011.do', 770, 470, "3:rep_cmdt_nm|2:rep_cmdt_cd", '0,0,1,1,1,1,1', true);
						break; 	
					case "btn_New":
						formObject.reset();
						sheetObjects[0].WaitImageVisible = false;
						sheetObjects[0].ColHidden("uc_flg") = false;
						sheetObjects[0].ColHidden("uclm_dt") = false;

					    comboObjects[0].Code = "";
					    comboObjects[1].Code = "";
					    comboObjects[2].Code = "";
					    comboObjects[3].Code = "";
						sheetObjects[0].Redraw = false;
						sheetObjects[0].RemoveAll();
						sheetObjects[0].Redraw = true;

					    break;

					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;
					case "btn_Cor":
						initSheet(sheetObjects[1],2);
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH03);
						break;
		            case "btn_DownExcel":
		            	doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
		                break;
		    		case "btn_loadExcel":
	                	sheetObjects[0].RemoveAll();
	                	sheetObjects[0].LoadExcel();
	
		    			break;	
		            case "btn_SelectAll":
		            	if ( pendingFalg ) {
		            		pendingFalg = false;
		            	} else {
		            		pendingFalg = true;
		            	}
		            	for ( var i=1; i<=sheetObjects[0].rowCount; i++ ) {
		            		if ( sheetObjects[0].CellValue(i,"uc_flg") ==0 ) {
			            		if ( pendingFalg ) {
			            			sheetObjects[0].CellValue(i,"ls_flg") = 1;
			            		} else {
			            			sheetObjects[0].CellValue(i,"ls_flg") = 0;
			            		}
		            		}
		            	}
		                break;
					case "btn_movement":
						if ( sheetObjects[0].rowCount != 0 ) {
			                var cnmv_dt = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cnmv_dt");
			                ComOpenWindowCenter("/hanjin/EES_CTM_0408.do?" +
			                                    "p_cntrno=" 	+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cntr_no").substring(0,10) + "&" +
			                                    "check_digit=" 	+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cntr_no").substring(10,11) + "&" +
			                                    "ctnr_tpsz_cd=" + sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cntr_tpsz_cd") + "&" +
			                                    "p_date1=" 		+ ComGetDateAdd(cnmv_dt, "M", -6, "-", true) + "&" +
			                                    "p_date2=" 		+ ComGetDateAdd(cnmv_dt, "M", 0, "-", true) + "&" +
			                                    "pop_mode=1"
			                                    , "EES_CTM_0408", 1020, 682);						
						}
						break;		                
					case "btns_search":		//Office Code
						ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 755, 435, "ofc_cd:sales_ofc_cd", "1,0,1,1,1,1,1,1", true);

	 					break;
	                case "btn_Close":
	    	            self.close();
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
    function loadPage( cnmv_sts_cd, cnmv_sts_nm, cntrTpszCd, cnmvStsCd, fullFlg, locTypeCode, locCd, lstmCd) {

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
        focCntrTpszCd = cntrTpszCd;
        focCnmvStsCd = cnmvStsCd;
        focFullFlg = fullFlg;
        focLocTypeCode = locTypeCode;
        focLocCd = locCd;
        focLstmCd = lstmCd;
        rcvDelTermSet();
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
    	switch(comboObj.id) {
    	case "rcv_del_term":
    		with(comboObj) {
    			//BackColor = "cyan";
    			DropHeight = 150;
    			MultiSelect = false;
    			//MaxSelect = 1;
    			FontName = "Courier New";
    		}
    		break;
    	}
    } 
    function sheet1_OnLoadFinish(sheetObj) {
    	
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //TP/SZ,MVMT Status,Lease Term 데이타 가져오기
    	ComSetFocus(document.form.loc_cd);
    	document.getElementById("bkg_bl_type_cd").setAttribute("maxLength",13);
    	
    	 var formObject = document.form;
    	 
    	if(formObject.loc_cd.value !='' && formObject.over_stay_days.value !=''){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
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
     * 초기 이벤트 등록 
     */
    function initControl() {
		axon_event.addListener('change', 'bkg_bl_type_code_change', 'bkg_bl_type_code');	//
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');							//엔터키 조회 이벤트처리
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 				//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 			//form OnBeforeDeactivate이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress'  , form);					//알파벳 대문자,숫자만 입력허용
    	axon_event.addListener('blur', 'obj_blur', 'loc_cd');
        axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code');		//Location by 변경시 이벤트 처리
        axon_event.addListener('change', 'bkg_cust_tp_cd_onchange', 'bkg_cust_tp_cd');
        axon_event.addListener('change', 'code_flg_onchange', 'code_flg');
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
     * MVMT Status  클릭 이벤트 등록
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
            document.getElementById("loc_cd").setAttribute("maxLength",5);
    	    if ( formObject.loc_cd.value.length == 5 ) {
    	    	ComSetFocus(document.form.over_stay_days);
    	    }
	        formObject.loc_cd.value = formObject.loc_cd.value.toUpperCase();
        }
    }

    /**
     * Location by 변경시 이벤트 처리
     * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
     * 나머지 활성화
     */
    function loc_type_code_onchange() {
    	var formObject = document.form;
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);
    }
    
    function bkg_cust_tp_cd_onchange() {
    	obj = event.srcElement;
    	var formObject = document.form;
    	if(obj.value =='T'){
    		document.getElementById("search_cust_cd").style.display = "none";
            formObject.cust_cd.readOnly = false;
            formObject.cust_cd.className = "input";
    	}else{
    		document.getElementById("search_cust_cd").style.display = "";
            formObject.cust_cd.readOnly = true;
            formObject.cust_cd.className = "input2";
            formObject.cust_cd.value = "";
    	}
    }
    
    function code_flg_onchange() {
    	rcvDelTermSet();
    }
    
    function rcvDelTermSet(){
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
    }

	/**
	 * Location  blur 이벤트 처리
	 * Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
	}
    
    /**
     * 키이벤트 목록
    */
 	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "loc_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "cust_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "bkg_bl_type_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "sales_ofc_cd":
				ComKeyOnlyAlphabet('upper');   // 알파벳 대문자만 입력허용
				break;
			case "over_stay_days":
				ComKeyOnlyNumber(event.srcElement);// 알파벳 대문자,숫자만 입력허용
				break;
				
		}
	} 
 	
    /**
     * 키UP이벤트 처리
    */ 	
 	function obj_keyup() {
		var formObject = document.form;
		if ( formObject.rep_cmdt_nm.value =='' ) {
			formObject.rep_cmdt_cd.value = '';
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
      * BKG.NO,B/L NO,CNTR_NO 변경시 이벤트 처리
      */   
     function bkg_bl_type_code_change() {
         var formObject = document.form;
         if ( formObject.bkg_bl_type_code.value == 'bkg' ) {
        	 document.getElementById("bkg_bl_type_cd").setAttribute("maxLength",13);
         } else if ( formObject.bkg_bl_type_code.value == 'bl' ) {
        	 document.getElementById("bkg_bl_type_cd").setAttribute("maxLength",12);
         } else if ( formObject.bkg_bl_type_code.value == 'cntr' ) {
        	 document.getElementById("bkg_bl_type_cd").setAttribute("maxLength",11);
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
                    style.height = 402;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    var HeadTitle1 = "||Seq.|CNTR No.|TP/SZ|Term|MVMT|Yard|BKG No.|B/L No.|Event Date|S.Days|L/S|U/C|U/C Date|F.Days|End Date|Act S.Ds|Reason|Plan/Progress|Contact Point|SHPR|CNEE|NTFY|CMDT|CMDT(Customs)|Lane|VVD|Sales OFC|POR|POL|POD|DEL|RCV TERM|DEL TERM|Contract No|Contract Customer Name|Update User Name|Update Date|SP Code|SP Name|Phone No|E-Mail|DMG|DISP|a|b|c|d|e|f|g|h|i";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] 
                    InitHeadRow(0, HeadTitle1, true); 

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty(0, cnt++ , dtHiddenStatus, 		0,		daCenter, 	false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,     		30,  	daCenter, 	true,  	"chk",    				false, 	"", 	dfNone, 				0, 		true,  	true, 0, true, false, "", 1);
                    InitDataProperty(0, cnt++ , dtDataSeq,				40, 	daRight,	false,	"seq",   				false,	"",		dfNone,					0,		true,	true);
                    InitDataProperty(0, cnt++ , dtData,					90, 	daCenter,	false,	"cntr_no",				false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					40, 	daCenter,	false,	"cntr_tpsz_cd",			false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					40, 	daCenter,	false,	"lstm_cd",		        false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					40, 	daCenter,	false,	"cnmv_sts_cd",   		false,	"",		dfNone,					0,		false,	true);

                    InitDataProperty(0, cnt++ , dtData,					60, 	daCenter,	false,	"crnt_yd_cd",   		false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					95, 	daCenter,	false,	"bkg_no",				false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					95, 	daCenter,	false,	"bl_no",				false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					70,   	daCenter,  	true,	"cnmv_dt",     			false,	"",		dfDateYmd,				0,      false,	true);
                    InitDataProperty(0, cnt++ , dtData,					50, 	daRight,	false,	"stay_days",			false,	"",		dfNullInteger,	 		0,		false,	true);
                    InitDataProperty(0, cnt++ , dtCheckBox,				45, 	daCenter,	false,	"ls_flg",     			false,	"",		dfNone,					0,		false,	true);

                    InitDataProperty(0, cnt++ , dtCheckBox,				45, 	daCenter,	false,	"uc_flg",     			false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					70, 	daCenter,	false,	"uclm_dt",		 		false,	"",		dfDateYmd,				0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					45, 	daRight,	false,	"ft_dys",				false,	"",		dfNullInteger,			0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					70, 	daCenter,	false,	"ft_end_dt",	 		false,	"",		dfDateYmd,				0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					60, 	daRight,	false,	"act_dys",				false,	"",		dfNullInteger,			0,		false,	true);
                    
                    InitDataProperty(0, cnt++ , dtComboEdit,			140, 	daLeft,		false,	"uclm_rsn",				true,	"",		dfNone,					0,		false,	true,		200);
                    //InitDataProperty(0, cnt++ , dtData,			        200, 	daLeft,		false,	"fact_fnd_act_desc",	false,	"",		dfNone,					0,		false,	true,		200);
                    
                    InitDataProperty(0, cnt++ , dtData,					150, 	daLeft,		false,	"uclm_pln_rmk",			false,	"",		dfNone,					0,		false,	true,		200);
                    InitDataProperty(0, cnt++ , dtData,					100, 	daLeft,		false,	"uclm_cntc_pnt_nm",		false,	"",		dfNone,					0,		false,	true,		50);
                    InitDataProperty(0, cnt++ , dtData,					100, 	daLeft,		false,	"shpr",					false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					100, 	daLeft,		false,	"cnee",					false,	"",		dfNone,					0,		false,	true);

                    InitDataProperty(0, cnt++ , dtData,					100, 	daLeft,		false,	"ntfy",					false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					100, 	daLeft,		false,	"rep_cmdt_nm",			false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					100, 	daLeft,		false,	"mk_desc",				false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtHidden,				45, 	daCenter,	false,	"vsl_slan_cd",			false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtHidden,				70, 	daLeft,		false,	"vvd",					false,	"",		dfNone,					0,		false,	true);

                    InitDataProperty(0, cnt++ , dtData,					80, 	daCenter,	false,	"ob_sls_ofc_cd",		false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					80, 	daCenter,	false,	"por_cd",		        false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					80, 	daCenter,	false,	"pol_cd",		        false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					80, 	daCenter,	false,	"pod_cd",		        false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					80, 	daCenter,	false,	"del_cd",		        false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					80, 	daCenter,	false,	"rcv_term_cd",		    false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					80, 	daCenter,	false,	"de_term_cd",		    false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					80, 	daCenter,	false,	"ctrt_no",		        false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					200, 	daCenter,	false,	"cust_lgl_eng_nm",		false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,				    140, 	daLeft,		false,	"upd_usr_id",			false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,				    80, 	daCenter,	false,	"upd_dt",				false,	"",		dfDateYmd,				0,		false,	true);
                    
                    InitDataProperty(0, cnt++ , dtData,				    80, 	daCenter,	false,	"vndr_seq2",			false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,				    80, 	daLeft,		false,	"vndr_lgl_eng_nm",		false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,				    80, 	daLeft,		false,	"phn_no",			    false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,				    130, 	daLeft,		false,	"vndr_eml",			    false,	"",		dfNone,					0,		false,	true);
                    
                    InitDataProperty(0, cnt++ , dtData,					35, 	daCenter,	false,	"dmg_flg",				false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					35, 	daCenter,	false,	"disp_flg",				false,	"",		dfNone,					0,		false,	true);

                    InitDataProperty(0, cnt++ , dtHidden,				70, 	daCenter,	false,	"cnmv_yr",				false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtHidden,				70, 	daCenter,	false,	"cnmv_id_no",			false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtHidden,				70, 	daCenter,	false,	"cnmv_gmt_dt",			false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtHidden,				70, 	daCenter,	false,	"uclm_free_dys",		false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtHidden,				70, 	daCenter,	false,	"uclm_end_dt",			false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtHidden,				70, 	daCenter,	false,	"full_flg",				false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtHidden,				70, 	daCenter,	false,	"temp_uclm_rsn",		false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtHidden,				30, 	daCenter,	false,	"org_ls_flg",     		false,	"",		dfNone,					0,		true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,				30, 	daCenter,	false,	"org_uc_flg",     		false,	"",		dfNone,					0,		true,	true);

                    InitDataCombo(0, "uclm_rsn", "Warehouse Working Delay, under pushing|Confiscated by Customs|Documentation Clearance Problems|Free time Extention|Unclaimed Cargo|Consignee/ Notifier Bankruptcy|Will be delivered soon|Others", "Warehouse Working Delay, under pushing|Confiscated by Customs|Documentation Clearance Problems|Free time Extention|Unclaimed Cargo|Consignee/ Notifier Bankruptcy|Will be delivered soon|Others");
                    
                    InitComboNoMatchText(true,"");
                    EditableColorDiff = false;
                    CountPosition = 0;	//페이지카운트 없애기
                    FrozenCols = 8;
                }
                break;
                
            case 2:      //sheet2 init
            	with (sheetObj) {
            		
                    // 높이 설정
                    //style.height = 300;
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    var HeadTitle1 = "Title|Contents";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    //InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] 
                    InitHeadRow(0, HeadTitle1, true); 

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,					150, 	daLeft,	false,	"title",				false,	"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,					300, 	daLeft,	false,	"contents",				false,	"",		dfNone,					0,		false,	true);
                    
                    InitComboNoMatchText(true,"");
                    EditableColorDiff = false;
                    CountPosition = 0;	//페이지카운트 없애기
                    //FrozenCols = 8;
                }
                break;
                
        	}
     	}

    /**
     * Sheet관련 프로세스 처리
     */    
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회

         		if(!validateForm(sheetObj,formObj,sAction)) return;
         		sheetObj.WaitImageVisible=false;
         		ComOpenWait(true); 
         		sheetObj.Redraw = false;
	            formObj.f_cmd.value = SEARCH;
		        sheetObj.DoSearch("EES_CIM_0022GS.do",FormQueryString(formObj));
		        ComOpenWait(false); 
         		break;
        	case IBSEARCH01:      //공통조회
         		sheetObj.WaitImageVisible = false;
    			form.f_cmd.value = SEARCH01;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0022GS.do" , FormQueryString(form));
    			var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");	   //TP/SZ 조회
    			tot_cntr_tpsz_cd = cntr_tpsz_cd;
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
    	        if ( focCntrTpszCd != '' ) {
    	        	comboObjects[0].Code = focCntrTpszCd;
    	        }
    	        if ( focCnmvStsCd != '' ) {
    	        	comboObjects[1].Code = focCnmvStsCd;
    	        }
    	        if ( focFullFlg != '' ) {
    	        	document.form.full_flg.value = focFullFlg;
    	        }
    	        if ( focLocTypeCode != '' ) {
    	        	document.form.loc_type_code.value = focLocTypeCode;
    	        }
    	        if ( focLocTypeCode != '' ) {
    	        	document.form.loc_cd.value = focLocCd;
    	        }
    	        
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
   	             	
   	                var arrLstmCd = focLstmCd.split(",");
   	             	
   	             	for ( var i=1; i<=arrLeaseTermCd.length; i++) {
   	             		for(var x=0; x<=arrLstmCd.length; x++){
   	   	             		if(arrLeaseTermCd[i-1] == arrLstmCd[x]){
   	   	             		CheckIndex(i)=true;
   	   	             		}
   	             		}  	             				
   	             	}
   	         	}  

    			break; 
        	case IBSEARCH02:      //location cd유효성 체크
				var inquiryLevel = "";
				if ( formObj.loc_type_code.value == '1') {
					inquiryLevel = "L";
				} else if  ( formObj.loc_type_code.value == '2' ) {
					inquiryLevel = "E";
				} else if  ( formObj.loc_type_code.value == '3' ) {
					inquiryLevel = "S";
				} else if  ( formObj.loc_type_code.value == '4' ) {
					inquiryLevel = "R";
				}
				formObj.inquiryLevel.value = inquiryLevel;
				formObj.location.value = formObj.loc_cd.value;
				
				formObj.f_cmd.value = SEARCH02;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0022GS.do",FormQueryString(formObj));
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
					return false;
				}
				break;
			//COR draft 조회	
        	case IBSEARCH03:      //조회
        		var inBkgNo = "";
        		var inCntrNo = "";

     			//if(!validateForm(sheetObj,formObj,sAction)) return;
        		//sheetObj.WaitImageVisible=false;
     			//ComOpenWait(true); 
     			//sheetObj.Redraw = false;
     			formObj.f_cmd.value = SEARCH03;

        		for (var i=0; i<sheetObjects[0].RowCount; i++) {
        			// check가 된 booking/container no 조회조건으로 사용하기 위함
        			if (sheetObjects[0].CellValue(i+1,"chk") == "1") {
        				inBkgNo += sheetObjects[0].CellValue(i+1,"bkg_no") + ',';
        				inCntrNo += sheetObjects[0].CellValue(i+1,"cntr_no") + ',';	
        			}
        		}

        		// 마지막 , 제거
        		formObj.in_bkg_no.value = inBkgNo.substr(0, inBkgNo.length - 1);
        		formObj.in_cntr_no.value = inCntrNo.substr(0, inCntrNo.length - 1);;
        		
     			sheetObjects[1].DoSearch("EES_CIM_0022GS.do",FormQueryString(formObj));
     			sheetObjects[1].SpeedDown2Excel(-1);    
     			//ComOpenWait(false); 
     		
     		break;
     		
        	case IBSEARCH_ASYNC01:     
    			formObj.f_cmd.value = SEARCH04;
    			sheetObj.WaitImageVisible = false;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0022GS.do", FormQueryString(formObj));

    			if ( sXml != "" ) {
    				ComXml2ComboItem(sXml, comboObjects[3], "intg_cd_val_ctnt", "intg_cd_val_ctnt");
    			}
        	break;
     		
        	case IBSAVE:        //저장
				var saveFlag = false;
			 	if(!ComShowCodeConfirm("CIM00008")) return; 
			 	 
				for ( var i=0; i<=sheetObj.rowCount; i++ ) {
					if ( sheetObj.RowStatus(i) == "U" || sheetObj.RowStatus(i) == "I" ) {
						if ( sheetObj.CellValue(i,"org_ls_flg") != sheetObj.CellValue(i,"ls_flg")) {
							if ( sheetObj.CellValue(i,"ls_flg") == 0 && sheetObj.CellValue(i,"uc_flg") == 0 ) {
								ComShowCodeMessage("CIM30014","L/S or U/C"); 
								sheetObj.SelectCell(i, "ls_flg", true);
								return;
							}
						}
						if ( sheetObj.CellValue(i,"org_uc_flg") == sheetObj.CellValue(i,"uc_flg")) {
							if ( ComTrimAll(sheetObj.CellValue(i,"uclm_rsn")) != '') {
								if ( sheetObj.CellValue(i,"ls_flg") == 0 && sheetObj.CellValue(i,"uc_flg") == 0 ) {
									ComShowCodeMessage("CIM30014","L/S or U/C");
									sheetObj.SelectCell(i, "ls_flg", true);
									return;
								} else {
									if ( ComTrimAll(sheetObj.CellValue(i,"uclm_rsn")) == '') {
										//메세지 변경 30014 -> 30022 modified by jy.shin
										ComShowCodeMessage("CIM30022", "'REASON'");
										sheetObj.SelectCell(i, "uclm_rsn", true);
										return;
										 
									}
								}
							} else {
								//메세지 변경 30014 -> 30022 modified by jy.shin
								ComShowCodeMessage("CIM30022", "'REASON'");
								sheetObj.SelectCell(i, "uclm_rsn", true);
								return;
							}	
						}
						 
						if ( ComTrimAll(sheetObj.CellValue(i,"uclm_rsn")) == '') {
							//메세지 변경 30014 -> 30022 modified by jy.shin
							ComShowCodeMessage("CIM30022", "'REASON'");
							sheetObj.SelectCell(i, "uclm_rsn", true);
							return;
						}
						
						if ( sheetObj.CellValue(i,"ls_flg") != 0 && sheetObj.CellValue(i,"uc_flg") != 0 ) {
							//Upload 시에 L/S와 U/C이 2개 다 Check 된 경우 2013.03.15
							ComShowCodeMessage("CIM30025", i);
							sheetObj.SelectCell(i, "ls_flg", true);
							return;
						}
						
						if ( sheetObj.CellValue(i,"ls_flg") == 1 && sheetObj.CellValue(i,"uclm_dt") != '' ) {
							//L/S 가 체크 되어 있고 U/C DATE가 있는 경우  2013.03.15
							ComShowCodeMessage("CIM30026", i);
							sheetObj.SelectCell(i, "uclm_dt", true);
							return;
						}
						 
						sheetObj.CellValue2(i,"org_ls_flg") = sheetObj.CellValue(i,"ls_flg");	//저장후 재조회 없이 체크하기 위한 세팅 
						sheetObj.CellValue2(i,"org_uc_flg") = sheetObj.CellValue(i,"uc_flg");
						 
						saveFlag = true;
					}
				}
				 
				//if(validateForm(sheetObj,formObj,sAction))  Upload 시에  Validation 할 필요 없음 2013.03.15

				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("EES_CIM_0022GS.do",FormQueryString(formObj),"ibflag",false);
				break;
			case IBDOWNEXCEL:      // 입력
				sheetObj.SpeedDown2Excel(0);      //전부 내려 받기
				break;
                
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	if(document.form.sales_ofc_cd.value != ''){
     	    if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
     	        return false;
     	    }
    
    	}else{
    		if(document.form.loc_cd.value == ''){
    			alert("'loc_cd'  is mandatory item.");
    			return false;
    		}
    	}
       
    	if (!ComChkValid(formObj)) return false;
              	
        return true;
    }

    /**
     * sheet1 클릭
     * sheet1 클릭 이벤트 호출
    */
    function sheet1_OnClick(sheetObj, row, col, value) {
    	switch (sheetObj.ColSaveName(col)) {
    		case "uclm_rsn" :	
    			if ( sheetObj.RowStatus(row) == "R" ) {
	    			if (  document.form.param_full_flg.value == 'N' ) {
	    				if ( sheetObj.CellValue(row,"uclm_rsn") != '' ) {
	    					sheetObj.CellComboItem(row, "uclm_rsn", sheetObj.CellValue(row,"uclm_rsn")+"|Idling|Damaged|For Sale|For Off-hire|For Disposal|Others", sheetObj.CellValue(row,"uclm_rsn")+"|Idling|Damaged|For Sale|For Off-hire|For Disposal|Others");
	    				} else {
	    					sheetObj.CellComboItem(row, "uclm_rsn", " |Idling|Damaged|For Sale|For Off-hire|For Disposal|Others", " |Idling|Damaged|For Sale|For Off-hire|For Disposal|Others");
	    					sheetObj.CellValue2(row,"uclm_rsn") = ''
	    				}
	    				
	    			} else if ( document.form.param_full_flg.value == 'Y' ) { 
	    				if ( sheetObj.CellValue(row,"uclm_rsn") != '' ) {
	    					sheetObj.CellComboItem(row, "uclm_rsn", sheetObj.CellValue(row,"uclm_rsn")+"|Warehouse Working Delay, under pushing|Confiscated by Customs|Documentation Clearance Problems|Free time Extention|Unclaimed Cargo|Consignee/ Notifier Bankruptcy|Will be delivered soon|Others",  sheetObj.CellValue(row,"uclm_rsn")+"|Warehouse Working Delay, under pushing|Confiscated by Customs|Documentation Clearance Problems|Free time Extention|Unclaimed Cargo|Consignee/ Notifier Bankruptcy|Will be delivered soon|Others");
	    				} else {
	    					sheetObj.CellComboItem(row, "uclm_rsn", " |Warehouse Working Delay, under pushing|Confiscated by Customs|Documentation Clearance Problems|Free time Extention|Unclaimed Cargo|Consignee/ Notifier Bankruptcy|Will be delivered soon|Others",  " |Warehouse Working Delay, under pushing|Confiscated by Customs|Documentation Clearance Problems|Free time Extention|Unclaimed Cargo|Consignee/ Notifier Bankruptcy|Will be delivered soon|Others");
	    					sheetObj.CellValue2(row,"uclm_rsn") = ''
	    				}
	    			}
    			}
    			
    			if ( sheetObj.CellValue(row,"uc_flg") == 0  ) {
					sheetObj.CellEditable(row,"uclm_rsn") = true;
				}
    			break;
    		case "uclm_pln_rmk" :	
    			/*if ( sheetObj.CellValue(row,"uc_flg") == 0  ) {
    				ComShowMemoPad(sheetObj,row,col,false,300,200);
    			}*/
    			ComShowMemoPad(sheetObj,row,col,false,300,200,450);
    			break;
    		case "ls_flg" :
    			if ( sheetObj.CellValue(row,"ls_flg") == 0  ) {
    				if ( ComTrimAll(sheetObj.CellValue(row,"uclm_dt")) != ''  && sheetObj.CellValue(row,"uc_flg") != 1 ) {
    					sheetObj.CellValue2(row,"uclm_dt") = '';
    				}
					sheetObj.CellEditable(row,"uclm_dt") = false;
    			} else {
					sheetObj.CellEditable(row,"uclm_dt") = true;
				}
    			if ( sheetObj.CellValue(row,"uc_flg") == 0  ) {
					sheetObj.CellEditable(row,"ls_flg") = true;
				}
    			break;
    		case "uc_flg" :	
    			if ( sheetObj.CellValue(row,"uc_flg") == 0  ) {
					sheetObj.CellEditable(row,"uclm_dt") = true;
				}
    			break;
    		case "cnmv_dt" :	
    			if ( sheetObj.CellValue(row,"uc_flg") == 0  ) {
					sheetObj.CellEditable(row,"cnmv_dt") = true;
				}
    			break;
    		case "uclm_cntc_pnt_nm" :	
    			if ( sheetObj.CellValue(row,"uc_flg") == 0  ) {
					sheetObj.CellEditable(row,"uclm_cntc_pnt_nm") = true;
				}
    			break;
    			
    		case "fact_fnd_act_desc" :
    			if ( sheetObj.CellValue(row,"fact_fnd_act_desc") != "") {
    				ComShowMemoPad(sheetObj, Row, Col, true);
				}
    			break;
    	}
    }

    /**
     * sheet1 클릭
     * sheet1 클릭 이벤트 호출
    */
    function sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift) {
		if ( sheetObj.CellText(Row,Col) !='' ) {
	    	switch (sheetObj.ColSaveName(Col)) {
	    		case "uclm_rsn" :
    				sheetObj.ToolTipText(Row,Col) = sheetObj.CellText(Row,Col);
	                break;
	    		case "uclm_pln_rmk" :
    				sheetObj.ToolTipText(Row,Col) = sheetObj.CellText(Row,Col);
	                break;
	    		case "uclm_cntc_pnt_nm" :
    				sheetObj.ToolTipText(Row,Col) = sheetObj.CellText(Row,Col);
	                break;
	    	}
		}
    }

    /**
     * sheet1 클릭
     * sheet1 클릭 이벤트 호출
    */
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	switch (sheetObj.ColSaveName(Col)) {
    		case "uclm_dt" :
            	if ( sheetObj.EditValue.length == 8 && ComIsDate(sheetObj.EditValue) ) {
            		sheetObj.SelectCell(Row, "uclm_rsn", true);
            	}    
            	break;
                
    	}
    }
    
    /**
     * sheet1 포커서 이동시
     * sheet1 Reason컬럼 마우스 클릭시 값이 사라지는 문제 보완
    */
    function sheet1_OnSelectCell(OldRow, OldCol, NewRow, NewCol) {
    	if ( NewRow ==15 ) {	//uclm_rsn
    		if (  document.form.param_full_flg.value == 'N' ) {
				if ( sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"uclm_rsn") != '' ) {
					sheetObjects[0].CellComboItem(sheetObjects[0].SelectRow, "uclm_rsn", sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"uclm_rsn")+"|Idling|Damaged|For Sale|For Off-hire|For Disposal|Others", sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"uclm_rsn")+"|Idling|Damaged|For Sale|For Off-hire|For Disposal|Others");
				} else {
					sheetObjects[0].CellComboItem(sheetObjects[0].SelectRow, "uclm_rsn", " |Idling|Damaged|For Sale|For Off-hire|For Disposal|Others", " |Idling|Damaged|For Sale|For Off-hire|For Disposal|Others");
					sheetObjects[0].CellValue2(sheetObjects[0].SelectRow,"uclm_rsn") = ''
				}
				
			} else if ( document.form.param_full_flg.value == 'Y' ) {
				if ( sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"uclm_rsn") != '' ) {
					sheetObjects[0].CellComboItem(sheetObjects[0].SelectRow, "uclm_rsn", sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"uclm_rsn")+"|Warehouse Working Delay, under pushing|Confiscated by Customs|Documentation Clearance Problems|Free time Extention|Unclaimed Cargo|Consignee/ Notifier Bankruptcy|Will be delivered soon|Others",  sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"uclm_rsn")+"|Warehouse Working Delay, under pushing|Confiscated by Customs|Documentation Clearance Problems|Free time Extention|Unclaimed Cargo|Consignee/ Notifier Bankruptcy|Will be delivered soon|Others");
				} else {
					sheetObjects[0].CellComboItem(sheetObjects[0].SelectRow, "uclm_rsn", " |Warehouse Working Delay, under pushing|Confiscated by Customs|Documentation Clearance Problems|Free time Extention|Unclaimed Cargo|Consignee/ Notifier Bankruptcy|Will be delivered soon|Others",  " |Warehouse Working Delay, under pushing|Confiscated by Customs|Documentation Clearance Problems|Free time Extention|Unclaimed Cargo|Consignee/ Notifier Bankruptcy|Will be delivered soon|Others");
					sheetObjects[0].CellValue2(sheetObjects[0].SelectRow,"uclm_rsn") = ''
				}
			}
    	}
    }

    /**
     * sheet1 클릭
     * sheet1 클릭 이벤트 호출
    */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		Row = sheetObjects[0].MouseRow;
		Col = sheetObjects[0].MouseCol;
		
        var colSaveName = sheetObjects[0].ColSaveName(Col);
		
		if(colSaveName == "uclm_rsn") {
			sText = sheetObjects[0].CellText(Row,Col);
		} else {
			sText = "";
		}

		sheetObjects[0].MouseToolTipText = sText;	//풍선도움말 만들기
    }    
    
    /**
     * sheet1 콤보 변경시
     * sheet1 콤보 변경시 이벤트 호출
    */
    function sheet1_OnComboChange(sheetObj,Row, Col, Code, Text) {
    	if ( sheetObj.CellValue(Row,"uclm_rsn") == "Others" || sheetObj.CellValue(Row,"uclm_rsn") == "select") {
    		sheetObj.CellText(Row, Col) = "";
    	}
    }
    /**
     * 화면 조회 종료후 프로세스 처리
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		sheetObj.SelectHighLight = false;
		if ( document.form.uclm_ls_div_cd.value == 'P' ) {
			ComBtnEnable('btn_SelectAll');			
		} else {
			ComBtnDisable('btn_SelectAll');			
		}

		sheetObj.ColBackColor("ls_flg") 			= sheetObj.WebColor2SysColor("#FFEAEA");;
		sheetObj.ColBackColor("uc_flg") 			= sheetObj.WebColor2SysColor("#FFEAEA");
		sheetObj.ColBackColor("uclm_dt") 			= sheetObj.WebColor2SysColor("#FFEAEA");
		sheetObj.ColBackColor("uclm_rsn") 			= sheetObj.WebColor2SysColor("#FFEAEA");
		sheetObj.ColBackColor("uclm_pln_rmk") 		= sheetObj.WebColor2SysColor("#FFEAEA");
		sheetObj.ColBackColor("uclm_cntc_pnt_nm") 	= sheetObj.WebColor2SysColor("#FFEAEA");
		 
		if ( document.form.full_flg.value == 'N' && document.form.uclm_ls_div_cd.value=='P' ) {
			sheetObj.ColHidden("uc_flg") = true;
			sheetObj.ColHidden("uclm_dt") = true;
		} else {
			sheetObj.ColHidden("uc_flg") = false;
			sheetObj.ColHidden("uclm_dt") = false;
		}
		document.form.param_full_flg.value = document.form.full_flg.value;
		
		sheetObj.SelectFontBold = true;
		sheetObj.Redraw = true;
		initSheet(sheetObjects[1],2);
	}

    /**
     * sheet1 값이 변경됬을때 이벤트 발생
     */
	function sheet1_OnChange(sheetObj, Row, Col, Val)
	{
		with(sheetObj)
		{
			var sName = ColSaveName(Col);
			switch(sName)
			{
				case "ls_flg":		// L/S, U/C 중 하나만 체크 가능
					if (1 == Val) {
						if (document.form.param_full_flg.value == 'N'&& document.form.uclm_ls_div_cd.value=='C' ){
							CellValue2(Row, "ls_flg") = 0;
						}else{
							CellValue2(Row, "uc_flg") = 0;
							sheetObj.SelectCell(Row, "uclm_rsn", true);
						}
					} else {
						if ( sheetObj.CellValue(Row,"org_ls_flg") ==1 ) {
							CellValue2(Row, "ls_flg") = 1;
							CellValue2(Row, "uc_flg") = 0;
						}
					}
					break;
				
				case "uc_flg":		// L/S, U/C 중 하나만 체크 가능
					if (1 == Val) {
						if (document.form.param_full_flg.value == 'N' ){
							if ( sheetObj.CellValue(Row,"org_uc_flg") ==0 ) {
								CellValue2(Row, "uc_flg") = 0;
								ComShowCodeMessage("CIM29045");
							}else{
								CellValue2(Row, "ls_flg") = 0;								
							}
						}else{
							CellValue2(Row, "ls_flg") = 0;
							sheetObj.SelectCell(Row, "uclm_dt", true);
						}
					} else {
						if ( sheetObj.CellValue(Row,"org_ls_flg") == 1 && sheetObj.CellValue(Row,"org_uc_flg") == 0 ) {
							if ( sheetObj.CellValue(Row,"uc_flg") == 0 ) {
								CellValue2(Row, "uc_flg") = 1;
							}
						}
					}
					break;
			}
		}
	}
