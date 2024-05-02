/*=========================================================
* Copyright(c) 2009 CyberLogitec
* @FileName : ESM_FMS_0073.js
* @FileTitle : Offhire Expenses from VMS
* Open Issues :
* Change history :
* @LastModifyDate : 2009.05.20
* @LastModifier : 정윤태
* @LastVersion : 1.0
* 2009.05.20 정윤태
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview Offhire Expenses from VMS 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     * @author 한진해운
     */

    /**
     * @extends FMS
     * @class Offhire Expenses from VMS : 운항 불가동 손실 중 VMS로부터 반영하여야 할 (Offhired 된) 전표 반영 결정의 무대.
     */
    function ESM_FMS_0073() {
    	this.initControl        	= initControl;
        this.validateForm       	= validateForm;
        this.setSheetObject			= setSheetObject;
        this.processButtonClick		= processButtonClick;
        this.loadPage				= loadPage;
        this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
        this.initSheet				= initSheet;
        this.doActionIBSheet		= doActionIBSheet;
        this.initTab				= initTab;
        this.obj_keypress			= obj_keypress;
        this.obj_deactivate			= obj_deactivate;
        this.obj_activate			= obj_activate;
        this.durationDayCheck		= durationDayCheck;
        this.initConfirm			= initConfirm;
        this.gridReset				= gridReset;
        this.formReset				= formReset;
        this.checkYn				= checkYn;
        this.sheet1_OnChange		= sheet1_OnChange;
        this.getInvUsdDys			= getInvUsdDys;
        this.gridDurationDayCheck 	= gridDurationDayCheck;
        this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
    }
    
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
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
					
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					
                    break;
                    
            	case "btn_new":
            		if(!initConfirm()) return;
            		
            		formReset();
            		
            		gridReset();
                    break;
                    
            	case "btn_price_retrieve":
            		if(!checkYn(sheetObject, "P")) return;
            		
            		var row = sheetObj.FindCheckedRow("radio");
            		
            		row = row.trimAll("|");
            		
            		var from_dt = sheetObject.CellText(row,"off_offh_dt_day");
            		var to_dt = sheetObject.CellText(row,"off_onh_dt_day");
            		
            		ComOpenPopup("ESM_FMS_0071.do?from_dt="+from_dt+"&to_dt="+to_dt, 520, 345, "setPrice", "1,0,1,1,1,1", false, false, 0, 0, 0, "price");

                    break;

				case "btn_confirm":
					if(!checkYn(sheetObject)) return;
					
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					
                    break;

				case "btn_close":
					window.close();
                    break;
                    
				case "from_dt": 
					var cal = new ComCalendar();
					cal.select(form.offh_dt, 'yyyy-MM-dd');
					break;
				 
				case "to_dt":
				    var cal = new ComCalendar();
					cal.select(form.onh_dt, 'yyyy-MM-dd');	
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

        	//khlee-시작 환경 설정 함수 이름변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        //html컨트롤 이벤트초기화
        initControl();

    }
     
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	CoFmsGetCombo('FORM', document.form, sheetObj, 'CD01524', 'flet_acc_tp_cd', 'flet_acc_tp_nm');
		
		sheetObj.WaitImageVisible = true;   
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {
                	var prefix = "off_";

                    // 높이 설정
                    style.height = 240;
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
                    InitColumnInfo(19, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

					var HeadTitle = "||Vessel Code|Off hire Day|Off hire Time|On hire Day|On hire Time|Days|Accident Type|IFO|F.O Price|MDO|D.O Price|FMS Approved|Reason|Description|Off Seq|Use Flg|";


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, 	dtRadioCheck,	0,    	daCenter,  	false,		"radio",   					false,      	"",      dfNone,	    0,     true,        true);
                    InitDataProperty(0, cnt++, 	dtCheckBox,  	0,    	daCenter,  	false,   	"check",   					false,      	"",      dfNone,   		0,     true,        true);
                    InitDataProperty(0, cnt++ , dtData,     	88,    	daCenter,  	true,    	prefix + "vsl_cd",     		false,          "",      dfNone,   		0,     false,   	false);
					InitDataProperty(0, cnt++ , dtData,     	100,    daCenter,  	true,    	prefix + "offh_dt_day", 	true,           "",      dfDateYmd,   	0,     true,    	true);
					InitDataProperty(0, cnt++ , dtData,     	105,    daCenter,  	false,   	prefix + "offh_dt_time",	true,           "",      dfTimeHm,   	0,     true,    	true);
					InitDataProperty(0, cnt++ , dtData,     	100,    daCenter,  	true,    	prefix + "onh_dt_day",     	true,           "",      dfDateYmd, 	0,     true,    	true);
					InitDataProperty(0, cnt++ , dtData,   		105,    daCenter,  	true,   	prefix + "onh_dt_time",   	true,           "",      dfTimeHm, 		0,     true,    	true);

					InitDataProperty(0, cnt++ , dtData,     	60,    	daRight,   	true,    	prefix + "offh_dur_dys",   	false,          "",      dfNullFloat,	4,     false,		false);
					InitDataProperty(0, cnt++ , dtData,   		135,    daLeft,  	true,    	prefix + "flet_acc_tp_cd",  false,          "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,     	70,    	daRight,   	true,    	prefix + "foil_qty",  		false,          "",      dfNullFloat,	2,     false,		false,	12);
					InitDataProperty(0, cnt++ , dtData,     	100,    daRight,   	true,    	prefix + "foil_prc",  		false,          "",      dfNullFloat,	2,     true,		true,	13);
					InitDataProperty(0, cnt++ , dtData,     	70,    	daRight,   	true,    	prefix + "doil_qty",  		false,          "",      dfNullFloat,	2,     false,		false,	12);
					InitDataProperty(0, cnt++ , dtData,     	100,    daRight,   	true,    	prefix + "doil_prc",  		false,          "",      dfNullFloat,	2,     true,		true,	13);
					InitDataProperty(0, cnt++ , dtData,     	100,    daCenter,  	true,    	prefix + "csr_slp_flg",  	false,          "",      dfNone, 		0,     false,		false);
                                                                                                                                         
					InitDataProperty(0, cnt++ , dtData,     	150,    daLeft,  	true,    	prefix + "offh_rsn",  		false,          "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,     	250,   	daLeft,  	true,    	prefix + "offh_desc",  		false,          "",      dfNone, 		0,     true,    	true,	50);
					InitDataProperty(0, cnt++ , dtHidden,     	40,   	daCenter,  	true,    	prefix + "offh_seq",  		false,          "",      dfNone, 		0,     true,    	true);
					InitDataProperty(0, cnt++ , dtHidden,     	40,   	daCenter,  	true,    	prefix + "use_flg",  		false,          "",      dfNone, 		0,     true,    	true);
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,     daCenter,   true,       prefix + "ibflag");
					
					//UseDefaultTime = false;//현재 시간을 표시하지 않고 공백의 마스크 상태 표시
					
					//날짜구분자를 설정한다.
					//DateFormatChar = "/";
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
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회

                if(!validateForm(sheetObj,formObj,sAction)) return;

                formObj.f_cmd.value = SEARCH;
                
                var aryPrefix = new Array("off_");
                
                var sXml = sheetObj.GetSearchXml("ESM_FMS_0073GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
                
                var arrXml = sXml.split("|$$|");
                
                if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
                
                break;

        	case IBSAVE:        //저장
        		if(!validateForm(sheetObj,formObj,sAction)) return;
        	
        		if(!gridDurationDayCheck(sheetObj)) return;
        		
        		formObj.f_cmd.value = MULTI;
        		
        		var arrSheets = new Array(sheetObjects[0]);
				//var sParam = ComGetSaveString(arrSheets);
				
				var sParam = sheetObj.GetSaveString(); 
				if (sheetObj.IsDataModified && sParam == "") {
					return; 
				}

				
				var aryPrefix = new Array("off_");
				
				sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
				 
				//ComOpenWait(true);
					 
				var sXml = sheetObj.GetSaveXml("ESM_FMS_0073GS.do", sParam);
				
				//ComOpenWait(false);
				
				comPopupOK();
				
                break;

			case IBINSERT:      // 입력
                break;
        }
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
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        
        //CoFmsGetCombo('FORM', document.form, sheetObjects[0], 'CD01524', 'flet_acc_tp_cd', 'flet_acc_tp_nm');
    }
    
    //Axon 이벤트 처리2. 이벤트처리함수 --- start
    
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
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
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){	
	    	case "offh_dt":
	    	case "onh_dt":
	    		ComChkObjValid(event.srcElement);
	    		
	    		durationDayCheck();

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
    
    //Axon 이벤트 처리2. 이벤트처리함수 --- end

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function validateForm(sheetObj,formObj,sAction){

    	if(formObj.offh_dt.value == "" && formObj.onh_dt.value == "") return true;
    	
    	if(formObj.offh_dt.value != "" && formObj.onh_dt.value == "") {
    		ComAlertFocus(formObj.onh_dt, ComGetMsg('FMS01150'));
			return false;
		} else if(formObj.offh_dt.value == "" && formObj.onh_dt.value != "") {
			ComAlertFocus(formObj.onh_dt, ComGetMsg('FMS01151'));
			return false;
		} else {
			if(durationDayCheck()) { 
				return true;
			} else {
				return false;
			}
		}
    }
    
    /**
     * Duration 기간 체크<br>
     * @return boolean true:이상없음, false:이상
     * @see #ComChkPeriod
     */
	function durationDayCheck() {
		
		if(form.offh_dt.value == "" || form.onh_dt.value == "") return;
    	
    	if(ComChkPeriod(form.offh_dt.value.trimAll("-"), form.onh_dt.value.trimAll("-")) < 1) {
    		ComShowMessage(ComGetMsg('FMS01152'));
			return false;
		}
    	
    	return true;
	}
    
    /**
     * 이벤트 발생시 실행여부 확인 <br>
     * @return {boolean} okYn   메세지 확인창에서 확인버튼 클릭하면 okYn:true 아니면 okYn:false
     **/
    function initConfirm() {
    	var okYn = true;

    	if(sheetObjects[0].isDataModified) {
    		
    		var okYn = confirm(ComGetMsg('FMS00002'));
    	}
    	
    	return okYn;
    }
    
    /**
     * IBSheet.RemoveAll()처리한다.<br>
     * @return 없음
     * @see #ComClearManyObjects
     */
    function gridReset(){

        try {
        	sheetObjects[0].RemoveAll();
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
     * document 안에 있는 모든 Object의 값을 초기화한다.(Disabled 값 제외) <br>
     * @return 없음
     * @see #ComClearManyObjects
     */
    function formReset(){

        try {
        	form.flet_acc_tp_cd.selectedIndex = 0;
        	form.csr_slp_flg.selectedIndex = 0;
        	
        	form.offh_dt.value = "";
    		form.onh_dt.value = "";
    		
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
     * Price Retrieve/Confirm 시 선택여부 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {string} 	flag    	Price Retrieve/Confirm(이벤트 구분값)
     * @return {boolean} true:선택, false:미선택
     **/
	function checkYn(sheetObj, flag) {
		var prefix = "off_";
		
		var sRow = sheetObj.FindCheckedRow("radio");

		if(flag == "P") {
			if(sRow == "") {
				ComShowMessage(ComGetMsg('COM12189'));
				//ComShowMessage(ComGetMsg('FMS01153'));
				return false;
			} else {
			
				//가져온 행을 배열로 반든다.
				var arrRow = sRow.split("|"); //결과 : "1|3|5|"
				for (var idx=arrRow.length-2; idx>=0; idx--){
					var row = arrRow[idx];
					if(sheetObj.CellValue(row, prefix+"csr_slp_flg") == "Y") {
						ComShowMessage(ComGetMsg('FMS01160'));
						return false;
					}
				}
			}
			
		} else {
			if(sRow == "") {
				ComShowMessage(ComGetMsg('COM12189'));
				//ComShowMessage(ComGetMsg('FMS01153'));
				return false;
			}
		}
		
		return true;
	}
	
    /**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 row
     * @param {ibsheet} col     	sheetObj의 선택된 col
     * @return {없음 } 
     * @see #getInvUsdDys
     **/
	function sheet1_OnChange(sheetObj,row,col) {
		var prefix = "off_";
		
		if(   sheetObj.ColSaveName(col)==prefix+"offh_dt_day"
		   || sheetObj.ColSaveName(col)==prefix+"offh_dt_time"
		   || sheetObj.ColSaveName(col)==prefix+"onh_dt_day"
		   || sheetObj.ColSaveName(col)==prefix+"onh_dt_time") {
			
			var offhDtDayCol = sheetObj.SaveNameCol(prefix+"offh_dt_day");
    		var offhDtDayValue = sheetObj.CellValue(row,offhDtDayCol);
    		
    		var offhDtTimeCol = sheetObj.SaveNameCol(prefix+"offh_dt_time");
    		var offhDtTimeValue = sheetObj.CellValue(row,offhDtTimeCol);
    		
    		var onhDtDayCol = sheetObj.SaveNameCol(prefix+"onh_dt_day");
    		var onhDtDayValue = sheetObj.CellValue(row,onhDtDayCol);
    		
    		var onhDtTimeCol = sheetObj.SaveNameCol(prefix+"onh_dt_time");
    		var onhDtTimeValue = sheetObj.CellValue(row,onhDtTimeCol);
    		
    		if(offhDtDayValue == "" || offhDtTimeValue == "" || onhDtDayValue == "" || onhDtTimeValue == "") return;
    		
    		var fromDate = offhDtDayValue + offhDtTimeValue;
    		var toDate = onhDtDayValue + onhDtTimeValue;
    		
    		if(fromDate > toDate) {
    			ComShowMessage(ComGetMsg('FMS01159'));
    			sheetObj.SelectCell(row,col);
				sheetObj.ValidateFail = true;
    			return;
    		}
    		
    		var offhDurDys = getInvUsdDys(fromDate, toDate);
    		
    		sheetObj.CellValue(row,prefix+"offh_dur_dys") = offhDurDys;
		}
	}
	
    /**
     * Duration 의 일수를 계산한다 <br>
     * @param {String} fromDate     From Date
     * @param {String} toDate   	To Date
     * @return {String } differTime From Date - To Date
     * @see #getArgValue
     * 		#getDateObj
     **/
	function getInvUsdDys(fromDate, toDate) {
		
		try {
			//문자열 또는 HTML태그(Object)인 경우 처리
			var sFromDate = getArgValue(fromDate);
			var sToDate   = getArgValue(toDate);
			
			if(sFromDate.length != sToDate.length) return NaN;

			var iFromTime = getDateObj(sFromDate);
			var iToTime   = getDateObj(sToDate);

			var differTime = (iToTime - iFromTime) / (60*60*24*1000);

			return differTime.toFixed(4);
			
		} catch(err) {ComFuncErrMsg(err.message);}
	}
    
     /**
      * GetSearchXml로 조회 완료후 발생하는 이벤트 <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {String} 	ErrMsg    	Error메세지
      **/
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix = "off_";
 		
     	if (sheetObj.SearchRows <=0) return;

     	for (var ir=1; ir<=sheetObj.LastRow; ir++){
     		if(sheetObj.CellValue(ir, prefix+"csr_slp_flg") == "Y") {
     			sheetObj.CellEditable(ir, prefix+"offh_dt_day")=false;
     			sheetObj.CellEditable(ir, prefix+"offh_dt_time")=false;
     			sheetObj.CellEditable(ir, prefix+"onh_dt_day")=false;
     			sheetObj.CellEditable(ir, prefix+"onh_dt_time")=false;
     			
     			sheetObj.CellEditable(ir, prefix+"foil_prc")=false;
     			sheetObj.CellEditable(ir, prefix+"doil_prc")=false;
     			sheetObj.CellEditable(ir, prefix+"offh_desc")=false;
     		}
     	}
    }
    
    /**
	 * Price 입력부분(Price Retrieve)<br>
	 * @param {arry} aryPopupData
	 */
	function setPrice(aryPopupData){
		var prefix = "off_";
		
		var sRow = sheetObj.FindCheckedRow("radio");
		
		if(sRow == "") return;
		
		sRow = sRow.trimAll("|");

		sheetObjects[0].CellValue2(sRow,prefix+"foil_prc") = aryPopupData[0][4];
		sheetObjects[0].CellValue2(sRow,prefix+"doil_prc") = aryPopupData[0][5];
	}
	 
	/**
     * Grid Duration 기간 체크<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return boolean true:이상없음, false:이상
     */
	function gridDurationDayCheck(sheetObj) {
		
		var prefix = "off_";
    	
    	var fromDate = "";
    	var toDate = "";
    	var checkYn = "N";

    	for (var ir=1; ir<=sheetObj.LastRow; ir++){
    		fromDate = sheetObj.CellValue(ir, prefix+"offh_dt_day") + sheetObj.CellValue(ir, prefix+"offh_dt_time");
    		toDate = sheetObj.CellValue(ir, prefix+"onh_dt_day") + sheetObj.CellValue(ir, prefix+"onh_dt_time");

    		if(fromDate > toDate) {
    			ComShowMessage(ComGetMsg('FMS01159'));
    			sheetObj.SelectCell(ir,prefix+"offh_dt_day");
				sheetObj.ValidateFail = true;
				checkYn = "N";
    			break;
    		}
    		
    		checkYn = "Y";
    	}
    	
    	if(checkYn == "Y") {
    		return true;
    	} else {
    		return false;
    	}
	}
     
    /**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
   	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 
    	for(var ir=1; ir<=sheetObj.LastRow; ir++){
    		if(sheetObj.CellValue(ir, "off_use_flg") != "") {
    			sheetObj.CellEditable(ir, "radio") = false;
    		}
    	}
   		
   		ComColFontName(sheetObj, "2"); 
   	}
    