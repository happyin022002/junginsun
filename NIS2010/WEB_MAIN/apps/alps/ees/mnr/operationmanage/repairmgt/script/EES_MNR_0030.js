/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0030.js
*@FileTitle : W/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : WanGyu Kim
*@LastVersion : 1.0
* 2009.08.03 WanGyu Kim
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
     * @class ees_mnr_0030 : ees_mnr_0030 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0030() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
	
/* ********* General Functions ************* */	
	// 공통전역변수
	var comboObjects = new Array();
	var comboCnt = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var combo1;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		var sheetObject1= sheetObjects[1];
		
		/*******************************************************/
		var formObject = document.form;
		
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_New":
					doActionIBSheet(sheetObject,document.form,IBCLEAR,1);
					break;

				case "btn_retrive":
			        doActionIBSheet(sheetObject,formObject,IBSEARCH,0);
			        break;
				
				case "btn_Creation":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
			        break;
				
				case "btn_DocSend":
					doActionIBSheet(sheetObject1,formObject,"docSend");
			        break;
				
				//달력
				case "apro_dt_cal":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.apro_dt_fr, formObject.apro_dt_to, 'yyyy-MM-dd');
					break;
                
				//W/O No popup
				case "wo_no_popup":
				    ComOpenPopup("EES_MNR_0211.do?", 725, 400, 'setEES_MNR_0211', '0,0', true);
					break;
				
				case "btn_Detail":
					if(sheetObjects[1].RowCount < 1) {return;}
					var selectedRow = sheetObjects[1].SelectRow;
					var rqstEqNo     = sheetObjects[1].CellValue(selectedRow, "rqst_eq_no");
					var rprRqstSeq   = sheetObjects[1].CellValue(selectedRow, "rpr_rqst_seq");
					var rprRqstVerNo = sheetObjects[1].CellValue(selectedRow, "rpr_rqst_ver_no");
					var eqKndCd      = sheetObjects[1].CellValue(selectedRow, "eq_knd_cd");
					ComOpenPopup('/hanjin/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd, 1024, 768, '', '0,0', false);
					break;	
								
				case "btn_DownExcel":
					sheetObjects[1].SpeedDown2Excel(-1); 
					break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
				ComFuncErrMsg(e); 
    		} else {
				ComFuncErrMsg(e); 
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//버튼 설정
    	MnrWaitControl(true);
    	
        //IBMultiCombo초기화
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
		
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		//Axon이벤트 초기화
		initControl();
		
		//화면 초기화
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,0);
		
		//set Focus
		document.form.status.focus();
    }

  	/**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
	    var cnt  = 0 ;
	    var formObject = document.form
	   
	    switch(comboNo) {
	    	case 1: 
	    	case 2: 
	            with (comboObj) { 
			        SetColAlign("left|left");        
			        SetColWidth("25|75")   
		        }
	            break;
	    	case 3: 
	            with (comboObj) { 
			   	  	SetTitle("S/P Name|S/P Code|AGMT No|AGMT Office|EQ TYPE|Effective Date|Reference No|Tariff No"); 
					SetColAlign("left|left|center|center|left|center|left|left");   
					SetColWidth("150|70|70|90|70|155|90|140");                                                  
					DropHeight = 160;  
		        }
	            break;
	     } 
	}

  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param	{IBSheet}	sheetObj	초기설정될 시트오브젝트 
     * @param	{String}	sheetNo		시트오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;

        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 332;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq.|Service\nProvider|Transmission\nMode|Pend.";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++,	dtSeq,	30,	daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++, 	dtData, 75, daLeft,  	false,	"vndr_nm",  	false,  "",	dfNone);
                    InitDataProperty(0, cnt++, 	dtData, 80, daLeft,  	false,  "trsm_mod_nm",	false,  "", dfNone,	0);
                    InitDataProperty(0, cnt++, 	dtData,	50, daCenter,	false,  "pending",		false,	"", dfNone);
                    //Hidden
                    InitDataProperty(0, cnt++, 	dtHidden, 50, daLeft,  	false,	"vndr_seq",  	false,  "",	dfNone);
                    InitDataProperty(0, cnt++, 	dtHidden, 50, daLeft,  	false,	"trsm_mod_cd",  false,  "",	dfNone);

                    ScrollBar = 2;

					//SELECT 로우 배경색
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   

					ShowButtonImage = 2;
					CountPosition = 0;
                }
                break;

            case 2:      //t1sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 332;
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
                    InitColumnInfo(22, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel|Seq.|EQ Type|EQ No.|TP/SZ|EST No.|Repair\nYard|Cur.|Total\nAmount|Audit\nOffice|Audit\nUSER|Audit\nDate|Input\nDate|DMG\nFlag|W/O No.|W/O Date|W/O Send Date";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		        	InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,	"sel_chk",     		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtSeq,      	30, 	daCenter,  	false,  "seq",     			false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,     	55, 	daLeft,  	false,  "eq_knd_nm",		false,  "", dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,     	80, 	daCenter,  	false,  "rqst_eq_no",   	false,  "", dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,     	40, 	daCenter,  	false,  "eq_tpsz_cd",   	false,  "", dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,     	115,	daCenter,  	false,  "rqst_ref_no",  	false,  "", dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,     	55, 	daCenter,  	false,  "rpr_yd_cd",		false,  "", dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,     	30, 	daCenter,  	false,  "curr_cd",     		false,  "", dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,     	80, 	daRight,  	false,  "mnr_wrk_amt",  	false,  "", dfFloat,	2,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,     	50, 	daCenter,  	false,  "apro_ofc_cd",  	false,  "", dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,     	70, 	daCenter,  	false,  "apro_usr_id",  	false,  "", dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,     	70, 	daCenter,  	false,  "apro_dt",   		false,  "", dfNone,		0,	false,	false);
		    		InitDataProperty(0, cnt++ , dtData,     	70, 	daCenter,  	false,  "rqst_dt",    		false,  "", dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		55, 	daCenter,  	false,  "mnr_dmg_flg",  	false,  "", dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,     	68, 	daCenter,  	false,  "wo_no",     		false,  "", dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,     	68, 	daCenter,  	false,  "wo_dt",     		false,  "", dfDateYmd,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,     	85, 	daCenter,  	false,  "mnr_ord_snd_dt",   false,  "", dfDateYmd,	0,	false,	false);
                    //Hidden
                    InitDataProperty(0, cnt++ , dtHidden,     	50, 	daCenter,  	false,  "rpr_rqst_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	50, 	daCenter,  	false,  "rpr_rqst_ver_no");
                    InitDataProperty(0, cnt++ , dtCheckBox,     50, 	daCenter,  	false,  "hidden_mnr_dmg_flg");
                    InitDataProperty(0, cnt++ , dtHidden,     	50, 	daCenter,  	false,  "eq_knd_cd");
                    
					//SELECT 로우 배경색
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
	
					ShowButtonImage = 2;
					CountPosition = 0;
                }
                break;
        }
    }

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); //- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); //- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);	//- 키입력 할때
    }

	/** 
	 * IBCombo Object를 배열로 등록
	 * @param    {IBCombo}	combo_obj	배열로 등록될 IBCombo Object
	 */	
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj; 
 	}

	/** 
	 * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
	 * @param    {IBSheet}	sheet_obj	배열로 등록될 IBSheet Object
	 */	
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

	/**
     * combo1 사용을 위한 객체배열 
     */
	function combo1List(){
		this.items = [];		
	}
	
	/**
     * combo1 사용을 위한 객체 
     */
	function combo1AGMT(vndr_seq,vndr_nm,agmt_no,agmt_ver_no,eff_dt,exp_dt,trf_no,agmt_ref_no,eq_knd_cd,curr_cd,trsm_mod_cd,edi_id){
		this.vndr_seq           = vndr_seq;         
		this.vndr_nm	        = vndr_nm;	        
		this.agmt_no            = agmt_no;         
		this.eff_dt	        	= eff_dt;	        
		this.exp_dt             = exp_dt;          
		this.agmt_ref_no		= agmt_ref_no;      
		this.trf_no             = trf_no;          
		this.agmt_ver_no        = agmt_ver_no;     
		this.eq_knd_cd	        = eq_knd_cd;	
		this.curr_cd            = curr_cd;         
		this.trsm_mod_cd		= trsm_mod_cd; 
		this.edi_id				= edi_id;   
	}	

	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}	
	
	/**
     * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_focus(){
		ComClearSeparator(event.srcElement);
    }
	
	/**
	 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
		switch(obj.dataformat) {
	        case "engup":
	          	if(obj.name=="wo_no"){
					ComKeyOnlyAlphabet('uppernum','44'); //','	
				} else {
					ComKeyOnlyAlphabet('uppernum');	
				}          
	            break;
			
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
	    } 
	}
    
	/** 
	 * COMBO 변경 이벤트
	 *     Status 변경시 버튼(W/O Creation, Doc Send) Display 설정
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function status_OnChange(comboObj,Index_Code, Text){
		//모든 쉬트를 초기화 	 
	    for(i=0;i<sheetObjects.length;i++){
	    	sheetObjects[i].RemoveAll(); 
        }

		var status = ComGetObjValue(comboObj);
		if(status=="I") {
			document.getElementById("btn_wo").style.display = "inline";
			document.getElementById("bnt_doc").style.display = "none";
		} else if (status=="R") {
			document.getElementById("btn_wo").style.display = "none";
			document.getElementById("bnt_doc").style.display = "inline";
			for (var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].LastRow; i++) {
				sheetObjects[1].CellEditable(i, "mnr_dmg_flg") = false;
			}
		} else {
			ComShowCodeMessage("MNR00036","Status");
		}
	}   

	/** 
	 * COMBO 변경 이벤트
	 *     Service Provider 변경시 EQ Type 과 Hidden Service Provider 설정
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function comboVndrSeq_OnChange(comboObj,Index_Code, Text){
		var formObj  = document.form;        
		var selectedIndex = comboObj.Code;  
		if(selectedIndex=="A") {
			formObj.vndr_seq.value = "A";
			formObj.eq_knd_cd.Code = "A";
		} else {
			formObj.vndr_seq.value = combo1.items[selectedIndex].vndr_seq;
			formObj.eq_knd_cd.Code = combo1.items[selectedIndex].eq_knd_cd;
		}
	}   
	
	/** 
	 * 조회된 Master Sheet에 포커스가 선택될때 발생하는 이벤트
	 *     Master Sheet 조회후 선택된 Row 에 해당하는 Detail Sheet 조회
	 * @param	{Sheet}			sheetObj	프로세스 처리될 시트오브젝트
	 * @param	{Long}			OldRow		선택한 셀의 Row Index
	 * @param	{Long/String}	OldCol		선택한 셀의 Column Index 또는 SaveName
	 * @param	{Long}			NewRow		선택할 셀의 Row Index
	 * @param	{Long/String}	NewCol		선택할 셀의 Column Index 또는 SaveName
	 */
	function sheetMaster_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        var formObject = document.form;
        formObject.selected_vndr_seq.value = sheetObj.CellValue(NewRow, "vndr_seq");
        doActionIBSheet(sheetObjects[1],formObject,IBSEARCH, 1);
	}

	/** 
	 * 조회후 설정
	 * Status 가 W/O Send 이면 DMG Flg 를 선택하지 못하도록 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheetDetail_OnSearchEnd(sheetObj, ErrMsg) {
		var status = ComGetObjValue(document.form.status);
		if(status == "R") {
			for (var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].LastRow; i++) {
				sheetObjects[1].CellEditable(i, "mnr_dmg_flg") = false;
			}
		} else {
			for (var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].LastRow; i++) {
				sheetObjects[1].CellEditable(i, "mnr_dmg_flg") = true;
			}
		}
	}
	
	/** 
	 * 저장후 결과메세지 표시
	 * @param	{IBSheet}	sheetObj	저장이벤트의 시트 오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheetDetail_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00073");
			document.form.status.Code = 'R'; //Status
			document.form.wo_no.value = sheetObj.EtcData("wo_nos");
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, 0);
		} 
		else { 
			ComShowCodeMessage("MNR00008",ErrMsg);  
		} 
	}     
	
  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction, sheetIdx) {
        sheetObj.ShowDebugMsg = false;
    	switch(sAction){
			//초기화
			case IBCLEAR:
				sheetObj.WaitImageVisible = false;
		    	MnrWaitControl(true);

				//모든 쉬트를 초기화 	 
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll(); 
		        }
			    //Only Loading
				if(sheetIdx == 0) {
		        	//조건부 콤보데이타 초기화
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();	
					}
					//조건부 콤보데이타 조회(Status)
					var sCondition = new Array (
						new Array("MnrGenCd","CD00025", "COMMON"), 	//Status
						new Array("MnrGenCd","SELHO","CUSTOM9")     //EQ Type
					)             
					var comboList = MnrComSearchCombo(sheetObj,sCondition);
					//조건부 콤보데이타에 값을 세팅함        
					for(var i=0; i<comboList.length ; i++){
						if(comboList[i] != null){
							//Display[CODE_NAME]:Status 
							for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|");    
								comboObjects[i].InsertItem(j, tempText[1] ,tempText[0]);
							}
						}
					}
					formObj.eq_knd_cd.InsertItem(0, "ALL" ,"A" );
					//Service Provider Combo
					combo1 = new combo1List();	
					var sXml = MnrAGMTHdrCombo(sheetObj,formObj.cost_ofc_cd.value);
					var arrResult = MnrXmlToArray(sXml);
					//0 trsm_mod_cd|1 vndr_seq|2 agmt_ref_no|3 eq_type_name|4 agmt_ofc_cty_cd|5 agmt_dt|6 agmt_seq|7 agmt_rmk|8 vndr_nm|9 agmt_no|10 agmt_type_tpsz|11 pagerows|12 agmt_ver_no|13 eff_dt|14 curr_cd|15 exp_dt|16 ibflag|17 cre_dt|18 upd_usr_id|19 delt_flg|20 agmt_prifix|21 pay_term_dys|22 edi_id|23 cre_usr_id|24 agmt_lst_ver_flg|25 trf_no|26 isversionup|27 agmt_display_type|28 eq_knd_cd|29 mnr_meas_ut_nm|30 agmt_ofc_cd|31 upd_dt|
					if(arrResult != null){	  	     
						for(var i = 0; i < arrResult.length;i ++){ 			
							combo1.items.push(new combo1AGMT(arrResult[i][1],arrResult[i][8],arrResult[i][9],arrResult[i][12],arrResult[i][13],arrResult[i][15],arrResult[i][25],arrResult[i][2],arrResult[i][28],arrResult[i][14],arrResult[i][0],arrResult[i][22]));		
							var tempComboText = arrResult[i][8] + "|" + arrResult[i][1] + "|" + arrResult[i][9] + "|" + arrResult[i][30] + "|" + arrResult[i][3] + "|" + arrResult[i][13] + " ~ " + arrResult[i][15] + "|" + arrResult[i][2] + "|" + " " + arrResult[i][25];  					
							formObj.comboVndrSeq.InsertItem(i, tempComboText ,String(i));                
						}	 			 						
						formObj.comboVndrSeq.InsertItem(0, "ALL" ,"A" );
					} else {		
						ComShowCodeMessage("MNR00056");         
					} 	  
				}
				    
				//콤보초기값 설정
				formObj.status.Code 		= "I"; //Status
				formObj.eq_knd_cd.Code		= "A"; //EQ Type
			    formObj.comboVndrSeq.Code 	= "A"; //Service Provider
			    //조건부 값 초기화       
				formObj.apro_dt_fr.value = ComGetDateAdd(ComGetNowInfo("ymd"), "D", -7);
			    formObj.apro_dt_to.value = ComGetNowInfo("ymd");
				formObj.wo_no.value = "";
				formObj.rqst_eq_no.value = "";
				//Hidden 컬럼 설정
				sheetObjects[1].ColHidden("hidden_mnr_dmg_flg") = true;
		    	
				MnrWaitControl(false);
				sheetObj.WaitImageVisible = true;
				
				break;

			//조회
            case IBSEARCH:
            	//Master 조회
            	if(sheetIdx == 0) {
                    if(validateForm(sheetObj,formObj,sAction)) {
    					sheetObj.WaitImageVisible = true;
    					formObj.f_cmd.value = SEARCH;
    					var sXml = sheetObj.GetSearchXml("EES_MNR_0030GS.do", FormQueryString(formObj));
    					sheetObj.LoadSearchXml(sXml);
    				}
                //Detail 조회
            	} else if(sheetIdx == 1){
					sheetObj.WaitImageVisible = true;
					formObj.f_cmd.value = SEARCH01;
					var sXml = sheetObj.GetSearchXml("EES_MNR_0030GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
            	}
                break;

            //저장
            case IBSAVE:        
                if(validateForm(sheetObj,formObj,sAction)) {
                	//Status 설정
                	setStatusBySelChk(sheetObj);
					
                	formObj.f_cmd.value = MULTI;
					var sParam = ComGetSaveString(sheetObjects);
				    if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
				    var sXml = sheetObj.GetSaveXml("EES_MNR_0030GS.do", sParam);
				    sheetObj.LoadSaveXml(sXml); 
				}
                break;

            //Doc Send
            case "docSend":
            	if(validateForm(sheetObj,formObj,sAction)) {
					var wo_nos = new Array();
					var cnt = 0;
					for(var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].LastRow; i++) {
						var selChk = sheetObjects[1].CellValue(i, "sel_chk");
					    if(selChk=="1") {
					    	wo_nos[cnt] = sheetObjects[1].CellValue(i, "wo_no");
					    	cnt++;
					    }
					}
					var wo_no = ComGetAryJoin(wo_nos, "|");
				    ComOpenPopup('/hanjin/EES_MNR_0036.do?wo_no='+wo_no, 900, 600, '', '0,1,1,1,1,1,1,1', true);
            	}
            	break;
            	
            default:
                break;
        }
    }

  	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
	        //W/O Creation
        	if(sAction==IBSAVE) {
        		//Detail Sheet 에 조회된 값이 없을 때 
        		if(sheetObj.SearchRows < 1) {return false;}
        		//Sel 에 checked 가 되어 있지 않을 때 
				if(sheetObj.FindCheckedRow("sel_chk") == ""){ 
					ComShowCodeMessage("MNR00038","W/O Creation ");
					return false;             	   
				}
				//W/O No 가  존재하는 Row 를 선택했을 때
				for(var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].LastRow; i++) {
					var selChk = sheetObjects[1].CellValue(i, "sel_chk");
					var woNo   = sheetObjects[1].CellValue(i, "wo_no");
					if(selChk=="1" && woNo!="") {
						ComShowCodeMessage("MNR00208",i+" row\'s W/O No.", "Creation ");
						sheetObjects[1].SelectCell(i, "sel_chk", true);
						return false;
					}
				}
	        }
        	//Doc Send
        	else if (sAction=="docSend") {
        		//Detail Sheet 에 조회된 값이 없을 때 
        		if(sheetObj.SearchRows < 1) {return false;}
        		//Sel 에 checked 가 되어 있지 않을 때 
				if(sheetObj.FindCheckedRow("sel_chk") == ""){ 
					ComShowCodeMessage("MNR00038","Doc Send ");
					return false;             	   
				}
        	}
    	}
        return true;
    }


/* ********* User Functions ************* */
  	/**
     * 저장시 Sel 체크박스에 체크된 Row 만 저장되도록 Status 설정
     * 
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     */
    function setStatusBySelChk(sheetObj){
		for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
			var selChk   = sheetObj.CellValue(i, "sel_chk");
			if(selChk=="1") {
				sheetObj.RowStatus(i) = "U";
			} else {
				sheetObj.RowStatus(i) = "R";
			}
		}
    	
    }

    /**
     * 팝업에서 리턴 받은 값을 세팅함.
     * 
     * @param	{Array}	array	리턴 받은 배열 
     */
    function setEES_MNR_0211(array) {
        if(array == null)return;
        var formObj = document.form;
           var str = array + "";
           var arr = str.split(',');
           
           formObj.wo_no.value = arr[4];
     }