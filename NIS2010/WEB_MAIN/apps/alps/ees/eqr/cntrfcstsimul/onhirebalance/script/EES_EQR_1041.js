/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1041.js
*@FileTitle : LT ST OW Plan and Approval
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.28 문동선
* 1.0 Creation
=========================================================*/
    /**
     * @extends 
     * @class EES_EQR_1041 : EES_EQR_1041 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1041() { 
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
        this.setTabObject           = setTabObject;
        this.sheet1_OnPopupClick = sheet1_OnPopupClick;    
    }
    // 공통전역변수
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var HeadTitleCnt = 0;
    var yyyyMm = "";
    
    var comboObjects = new Array();
    var comboCnt = 0 ;
    
    var rowInsertSeq = 0; // 신규 Row Merge 방지
    var rccCdList = ""; 
	var lccCdList = ""; 
	var searchFlag = false; // sheet 가 조회 되었는지에 대한 flag 
	var save_flag = false;  // save 성공 가부에 대한 flag
    
    // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //     
    var tpszallText = "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|A5"; 
    var tpszallCode = "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|A5"; 
    var tpszdryText = "D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode = "D2|D4|D5|D7";
    var tpszrfrText = "R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode = "R2|R5|R9";
    var tpszotText  = "O2|O4|O5|S2|S4"; // OT  TYPE SIZE 
    var tpszotCode  = "O2|O4|O5|S2|S4";
    var tpszfrText  = "F2|F4|F5|A2|A4|A5"; // FR  TYPE SIZE 
    var tpszfrCode  = "F2|F4|F5|A2|A4|A5";    
    
    var consTpsz      = "D2,D4,D5,D7,R2,R5,R9,O2,O4,O5,S2,S4,F2,F4,F5,A2,A4,A5";
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = "D2,D4,D5,D7";
    var consTpszRfr   = "R2,R5,R9";
    var consTpszOt    = "O2,O4,O5,S2,S4";
    var consTpszFr    = "F2,F4,F5,A2,A4,A5";
    // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var shtCnt = 0;
        var sheet1 = sheetObjects[shtCnt];
        var formObject = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;
			case "btn_new":
                sheetObjects[0].RemoveAll();
				doActionIBSheet(sheetObjects[0],formObject,SEARCH02);
                break;	
            case "btn_save":
                doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                break;
			case "btn_request":
                doActionIBSheet(sheetObjects[0], formObject, MULTI02);
                break;	
			case "btn_cancel":
                doActionIBSheet(sheetObjects[0], formObject, MULTI03);
                break;	
            case "btn_downExcel":
                ComOpenWait(true);
                sheetObjects[0].Down2Excel(-1,false,false,true,"","",false,false,"",false,"delchk");
                ComOpenWait(false);
                break;
            
			case "btn_rowadd":
			    var newRow = sheetObjects[0].DataInsert(-1);
				if (document.form.div_flag[0].checked == true) { // WK 가 선택
				    sheetObjects[0].CellValue2(newRow,"onh_pln_yrwk") = document.form.yrwk.value;
				}
				if(formObject.lcc_cd.Code != "" && formObject.lcc_cd.Code != "ALL"){ // LCC 조회 옵션 있으면 그걸로 넣어 줌
				    sheetObjects[0].CellValue2(newRow,"rcc_cd") = formObject.rcc_cd.Code;
					sheetObjects[0].CellValue2(newRow,"lcc_cd") = formObject.lcc_cd.Code;
				}
				if(formObject.pop_mode.value == "Y"){
					//sheetObjects[0].CellEditable(newRow,"onh_pln_yrwk") = false;
					if(sheetObjects[0].CellValue(newRow,"lcc_cd")!=""){
					    sheetObjects[0].CellEditable(newRow,"lcc_cd") = false;
					}
				}
				
				break;
			case "btn_rowdel":
			    var delStr = sheetObjects[0].FindCheckedRow("delchk"); 
				if(delStr != ""){
					var delArr = delStr.split("|");
					
					for(var i=0; i<delArr.length; i++){ // STS_CD 체크
						if(delArr[i]!="" && !(sheetObjects[0].CellValue(delArr[i],"sts_cd")=="S"
						|| sheetObjects[0].CellValue(delArr[i],"sts_cd")=="")){
							ComShowCodeMessage("EQR01024"); // 'Only New row and Saved row can be Deleted.'
							sheetObjects[0].SelectCell(delArr[i],"lse_rqst_no");
							return false;
						}
					}
					for(var i=delArr.length-1; i>=0; i--){ // RowDelete 때문에 꺼꾸로 roop 함
						if(delArr[i]!=""){
	                        if(sheetObjects[0].CellValue(delArr[i],"ibflag")=="I"){ // 신규 입력 건, 완전 삭제
	                            sheetObjects[0].RowDelete(delArr[i], false);
	                        }else{                                // 히든, ibflag = D
	                            sheetObjects[0].CellValue(delArr[i],"ibflag") = "D";
	                            sheetObjects[0].RowHidden(delArr[i]) = true;
	                        }
						}
                    }
				}
				break;
			
			case "btn_close":
                window.close();
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
     * 초기 이벤트 등록 
     */
    function initControl() {
         axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);                 //form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
         axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);               //form OnBeforeDeactivate이벤트에 코드 처리
         axon_event.addListener('keydown', 'ComKeyEnter', 'form');                             //엔터키 조회 이벤트처리
         axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);                     //알파벳 대문자,숫자만 입력허용
         axon_event.addListenerForm('change','form_change',form);
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
     * 설  명 : IBCombo Object를 배열로 등록 <br>
     *          향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     *          배열은 소스 상단에 정의<br>
     * <br><b>Example : </b>
     * <pre>
     *     setComboObject(combo_obj)
     * </pre>
     * @param {object}  combo_obj - Combo Object
     * @see #링크연결
     * @author 작성자
     * @version 
     */
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
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
        
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }

		var level_cd = document.form.level_cd.value;
		
        doActionIBSheet(sheetObjects[0],document.form,SEARCH02); // RCC 콤보 조회
		
		if(document.form.pop_mode.value == "Y"){ 
		// popup mode 로 열렸을 경우, 계산 결과를 부모창에 보내야 하기 때문에 조회 조건 잠금 
		    ComBtnDisable("btn_new");      // NEW 버튼 잠금
		
		    document.form.div_flag[2].checked = true;
		    
			document.form.div_flag[0].disabled = true;
            document.form.div_flag[1].disabled = true; 
            document.form.div_flag[2].disabled = true; 
            document.form.div_flag[3].disabled = true;    
            
			document.form.yrwk.className      		= "input2";
            document.form.fmperiod.className  		= "input2";
            document.form.toperiod.className  		= "input2";
			document.form.yrwk_pkup.className      	= "input2";
            document.form.fmperiod_pkup.className  	= "input2";
            document.form.toperiod_pkup.className  	= "input2";            
			document.form.yrwk.readOnly       		= true;
            document.form.fmperiod.readOnly   		= true;
            document.form.toperiod.readOnly   		= true;
			document.form.yrwk_pkup.readOnly       	= true;
            document.form.fmperiod_pkup.readOnly   	= true;
            document.form.toperiod_pkup.readOnly   	= true;            
			
			document.form.periodtp.className   = "input2";
			document.form.periodtp.disabled    = true;			
			document.form.periodtp_pkup.className   = "input2";
			document.form.periodtp_pkup.disabled    = true;
			
			document.form.sts_cd.className     = "input2";			
			document.form.sts_cd.disabled      = true;
			
			comboObjects[0].enable = false;
			comboObjects[1].enable = false;
			
			if (document.form.pop_lcc.value != "") {
				// 해당 LCC 의 RCC 를 조회
				var sXml = sheetObjects[0].GetSearchXml("EES_EQR_1041GS.do", "f_cmd=" + SEARCH02 + "&loc_grp_cd=R" + "&loc_cd=" + document.form.pop_lcc.value);
				if (ComGetTotalRows(sXml) > 0) {
					var tmpRccCd = ComXml2ComboString(sXml, "code", "name")[0].split('|')[0];
					comboObjects[0].Text = tmpRccCd;
					comboObjects[1].Text = document.form.pop_lcc.value;
				}
				else {
					comboObjects[0].Text = "ALL";
					comboObjects[1].Text = "ALL";
				}
			}else if (document.form.pop_rcc.value != "") {
				comboObjects[1].Text = document.form.pop_rcc.value;
			}else{
			    comboObjects[0].Text = "ALL";
                comboObjects[1].Text = "ALL";		
			}
			document.form.cntrTpsz.selectedIndex = 1; // Dry 선택
			document.form.tpsztype.Text = document.form.pop_tpsz.value;
			
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); // 조회 
			
		}else{
            document.form.cntrTpsz.selectedIndex = 1; // Dry 선택
            tpszChange('D'); // Dry 선택
        }
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        var shtID = sheetObj.id;
    
        switch(shtID) {
            
            case "sheet1":      //sheet1 init
            with (sheetObj) {
                   // 높이 설정
                   style.height = 438;
                   //전체 너비 설정
                   SheetWidth = mainTable.clientWidth;    
                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                   Editable = true;
                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo(1, 1, 22, 100);
                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(false, false, false, true, false,false);
                   
                   var HeadTitle1 = "ibflag|Del.|Request No.|Order\nYear|Approval\nWK|Pick-up\nWK|RCC|LCC|Term|lse_pln_seq|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|O5|S4|F2|A2|F4|A4|F5|A5|Auth No.|M/Year|AGMT No.|Lessor|sts_cd|Status|request_flag";
                   
                   HeadTitleCnt = ComCountHeadTitle(HeadTitle1);
                   InitColumnInfo(HeadTitleCnt, 0, 0, true);
                   
                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle1, true);
                   sheetObj.FrozenCols = 3;

                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   
				   InitDataProperty(0, cnt++, dtHiddenStatus,  0, daCenter, true, "ibflag");
				   InitDataProperty(0, cnt++, dtDummyCheck,   28, daCenter, true, "delchk");
                   
				   InitDataProperty(0, cnt++, dtData, 140, daCenter, false, "lse_rqst_no",   false, "", dfNone, 0, false, false); 
				   InitDataProperty(0, cnt++, dtData,  55, daCenter, false, "onh_ord_yr",    false, "", dfNone, 0, true, true,  4); 				   
				   InitDataProperty(0, cnt++, dtData,  70, daCenter, false, "onh_pln_yrwk",  true,  "", dfNone, 0, false, true,  6);  
				   InitDataProperty(0, cnt++, dtData,  70, daCenter, false, "onh_pkup_yrwk", true,  "", dfNone, 0, true,  true,  6);  				   
				   InitDataProperty(0, cnt++, dtData,  60, daCenter, false, "rcc_cd",        false, "", dfNone, 0, false, false, 5); 
				   InitDataProperty(0, cnt++, dtData,  60, daCenter, false, "lcc_cd",        true,  "", dfNone, 0, false, true,  5); 
				   InitDataProperty(0, cnt++, dtCombo, 48, daCenter, true,  "eq_lstm_cd",    true,  "", dfNone, 0, false, true,  2);
				   InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "lse_pln_seq",   false, "", dfNone, 0, false, false);
				   
                   InitDataProperty(0, cnt++, dtData, 46, daRight, false, "ttl",    false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "d2_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "d4_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "d5_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "d7_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "r2_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "r5_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "r9_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "o2_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "s2_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "o4_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "o5_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "s4_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "f2_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "a2_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "f4_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "a4_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "f5_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtData, 40, daRight, false, "a5_qty", false, "", dfInteger, 0, true,  true, 6);
				   
				   InitDataProperty(0, cnt++, dtData,  120, daCenter, true, "cntr_onh_auth_no", false, "", dfNone,0, false, false);
                   InitDataProperty(0, cnt++, dtData,   55, daCenter, true, "mft_yr",           false, "", dfNone, 0, false, false);
				   InitDataProperty(0, cnt++, dtData,   80, daCenter, true, "agmt_no",          false, "", dfNone, 0, false, false);
				   InitDataProperty(0, cnt++, dtData,   55, daCenter, true, "onh_loc_cd",       false, "", dfNone, 0, false, false);
				   InitDataProperty(0, cnt++, dtHidden, 55, daCenter, true, "sts_cd",           false, "", dfNone, 0, false, false);
				   InitDataProperty(0, cnt++, dtData,   50, daCenter, true, "sts_nm",           false, "", dfNone, 0, false, false);
				   
				   InitDataProperty(0, cnt++, dtHidden,  0, daCenter, true, "request_flag",     false, "", dfNone, 0, true, true);
				   
				   // 입력 형식 지정
                   InitDataValid(0, "onh_ord_yr",    vtNumericOnly);  // 숫자만 입력
                   InitDataValid(0, "onh_pln_yrwk",  vtNumericOnly);  // 숫자만 입력
                   InitDataValid(0, "onh_pkup_yrwk", vtNumericOnly);  // 숫자만 입력
                   
                   InitDataValid(0, "lcc_cd", vtEngUpOther, "1234567890");
                   
				   InitDataCombo(0, "eq_lstm_cd", " |LT|ST|OW", " |LT|ST|OW", "", "");
				   
                   WaitImageVisible=false;
                   CountPosition = 0;        
                   AutoRowHeight = false;    // 높이를 자동으로 조정하지 않고, 1줄 높이로 고정한다
                   
                   SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
                   SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
                   SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지

                   InitComboNoMatchText(true); // Combo 항목에 없는 데이터도 보여줌
                   
				   MultiSelection = false;
				   SelectionMode = smSelectionRow;
            }
            break;
            
        }
    }
    
      // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
        sheetObj.ShowDebugMsg = false;  
        switch(sAction) {
           case IBSAVE:        //저장 Save
	            if (validateForm(sheetObj, formObj, sAction)) {
					var SaveStr = sheetObj.GetSaveString(false,true,"ibflag");
					if (SaveStr == "") {
						return;
					}
					ComOpenWait(true);
                    var insRowStr = sheetObj.FindStatusRow("I"); 
					var insRowArr = insRowStr.split(";");
					
					sParam = "f_cmd=" + MULTI + "&" + SaveStr;

                    var sXml = sheetObj.GetSaveXml("EES_EQR_1041GS.do", sParam);
					var newLsePlnSeqStr = ComGetEtcData(sXml, "new_lse_pln_seq_str");
					
					if(ComGetEtcData(sXml,"TRANS_RESULT_KEY")=="S"){ // 저장 성공했으면
					
						if(newLsePlnSeqStr!=""){ // insert row 가 있었으면
							var newLsePlnSeqArr = newLsePlnSeqStr.split(",");
							
							for(var i=0; i<insRowArr.length; i++){
								if(insRowArr[i]!=""){
									sheetObj.CellValue2(insRowArr[i],"lse_pln_seq") = newLsePlnSeqArr[i];
									sheetObj.CellValue2(insRowArr[i],"sts_cd") = "S";
									sheetObj.CellValue2(insRowArr[i],"sts_nm") = "Saved";
									sheetObj.CellValue2(insRowArr[i],"ibflag") = "R";
								}
							}
						}
						save_flag = true;
						
						ComShowCodeMessage("EQR01020","Saved"); // '{?msg1} Successfully.'
					}else{
						// 저장 실패 메시지
						
						save_flag = false;
					}
					sheetObj.LoadSaveXml(sXml); 
					
					ComOpenWait(false);
				}
				
                break;
           
		   case MULTI02:        //저장 Request
                if (validateForm(sheetObj, formObj, sAction) && ComShowCodeConfirm("EQR01028")) {
                    ComOpenWait(true);
					
					var selRow = sheetObj.SelectRow;
					
					sheetObj.CellValue2(selRow, "sts_cd")       = "R"; // Request 면 R
					sheetObj.CellValue2(selRow, "request_flag") = "Y";
					
					var sParam = "f_cmd="+MULTI02;
                    sParam = sParam+"&"+sheetObj.GetSaveString(false,true,"request_flag");
                    var sXml = sheetObj.GetSaveXml("EES_EQR_1041GS.do", sParam);
					
					var newLseRqstNoStr = ComGetEtcData(sXml, "new_lse_rqst_no_str");
									
					if(ComGetEtcData(sXml,"TRANS_RESULT_KEY")=="S" 
					    && newLseRqstNoStr!="" ){ // 저장 성공했고, 반환된 lse_rqst_no 있으면

						var newLseRqstNoArr = newLseRqstNoStr.split(",");
						sheetObj.CellValue2(selRow,"lse_rqst_no") = newLseRqstNoArr[0];
                        sheetObj.CellValue2(selRow,"sts_cd") = "R";
                        sheetObj.CellValue2(selRow,"sts_nm") = "Requested";
						sheetObj.CellValue2(selRow, "request_flag") = "";
                        sheetObj.CellValue2(selRow,"ibflag") = "R";
						sheetObj.RowEditable(selRow) = false;
						
						ComShowCodeMessage("EQR01020","Requested"); // '{?msg1} Successfully.'
					}else{
						sheetObj.CellValue2(selRow, "sts_cd")       = "S"; // 원복
                        sheetObj.CellValue2(selRow, "request_flag") = "";  // 원복
					}
					
                    ComOpenWait(false);
                }
                break;
		   
		   case MULTI03:        // Request Cancel (주의, 위와 거의 똑같음)
                if (validateForm(sheetObj, formObj, sAction) && ComShowCodeConfirm("EQR01028")) {
                    ComOpenWait(true);
                    
                    var selRow = sheetObj.SelectRow;
                    sheetObj.CellValue2(selRow, "sts_cd")       = "S"; // Request Cancel 이면 S
                    sheetObj.CellValue2(selRow, "request_flag") = "Y";
                    
                    var sParam = "f_cmd="+MULTI02;
                    sParam = sParam+"&"+sheetObj.GetSaveString(false,true,"request_flag");
                    var sXml = sheetObj.GetSaveXml("EES_EQR_1041GS.do", sParam);
                    
                    var newLseRqstNoStr = ComGetEtcData(sXml, "new_lse_rqst_no_str");

					if(ComGetEtcData(sXml,"TRANS_RESULT_KEY")=="S"){ // 저장 성공했으면
                        sheetObj.CellValue2(selRow,"lse_rqst_no") = "";
                        sheetObj.CellValue2(selRow,"sts_cd") = "S";
                        sheetObj.CellValue2(selRow,"sts_nm") = "Saved";
						sheetObj.CellValue2(selRow, "request_flag") = "";
                        sheetObj.CellValue2(selRow,"ibflag") = "R";
						sheetObj.RowEditable(selRow) = true;
						
						ComShowCodeMessage("EQR01020","Request Canceled"); // '{?msg1} Successfully.'
                    }else{
						sheetObj.CellValue2(selRow, "sts_cd")       = "R"; // 원복
                        sheetObj.CellValue2(selRow, "request_flag") = "";  // 원복
					}
					
                    ComOpenWait(false);
                }
                break;
		   
		   
           case IBSEARCH:        //조회
                // 벨리데이션
				ComOpenWait(true); 
                if (validateForm(sheetObj, formObj, sAction)) {
				
					sheetObjects[0].Redraw = false;
					formObj.f_cmd.value = SEARCH;
					
					//setSheetCombo(sheetObj); // 조회조건에 맞게 sheet 내 combo 옵션값 설정
					var sXml = sheetObj.GetSearchXml("EES_EQR_1041GS.do", FormQueryString(formObj));
					//sheetObjects[0].RemoveAll();
					sheetObjects[0].LoadSearchXml(sXml);
					
					// setSearchFlag(true);
					sheetObjects[0].Redraw = true;
				}
                ComOpenWait(false);                
                break;
             
			 case SEARCH02: // RCC_CD 콤보 리스트 조회
			     formObj.f_cmd.value = SEARCH02;
				 var sXml = sheetObj.GetSearchXml("EES_EQR_1041GS.do" , FormQueryString(formObj)+"&loc_grp_cd=R");
				 ComXml2ComboItem(sXml, formObj.rcc_cd, "code", "name");
				 rccCdList = ComXml2ComboString(sXml,"code","name")[0];
				 formObj.rcc_cd.InsertItem(0,"ALL","ALL");
				 formObj.rcc_cd.Text = 'ALL';
				 break;
			
			case SEARCH03: // LCC_CD 콤보 리스트 조회
                 formObj.f_cmd.value = SEARCH02; // 주의, 위와 같음
                 var sXml = sheetObj.GetSearchXml("EES_EQR_1041GS.do" , FormQueryString(formObj)+"&loc_grp_cd=L"+"&loc_cd="+formObj.rcc_cd.Code);
                 ComXml2ComboItem(sXml, formObj.lcc_cd, "code", "name");
				 if(ComGetTotalRows(sXml)*1>0){
				    lccCdList = ComXml2ComboString(sXml,"code","name")[0];	
				 }
				 formObj.lcc_cd.InsertItem(0,"ALL","ALL");
				 formObj.lcc_cd.Text = 'ALL';
				 break;	 
			          
        }
    }
	
    /**
     * sheet1 조회 후 이벤트 발생
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount("R")>0){
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				if(sheetObj.CellValue(i,"sts_cd") != "S"){
					sheetObj.rowEditable(i) = false;
				}
			}
			
			// Col TTL 계산
			calcColTtl(sheetObj);
		}
    }
	
    /**
     * sheet1 값 변경 시 이벤트 발생
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
		 
		 var formObj = document.form;
		 
		 with (sheetObj) {
		 	  var colName = ColSaveName(Col);
		 	  switch (colName) {
			  
			  	case "lcc_cd":
					  if(Value == ""){
					       sheetObj.CellValue2(Row, "lcc_cd") = "";
                           sheetObj.CellValue2(Row, "rcc_cd") = "";
					  }else{
						   formObj.f_cmd.value = SEARCH02;
                           var sXml = sheetObj.GetSearchXml("EES_EQR_1041GS.do" , "f_cmd="+SEARCH02+"&loc_grp_cd=R"+"&loc_cd="+Value);
                           if (ComGetTotalRows(sXml) > 0) {
						   	  var tmpRccCd = ComXml2ComboString(sXml, "code", "name")[0].split('|')[0];
						      sheetObj.CellValue2(Row, "rcc_cd") = tmpRccCd;
							  
							  if(formObj.rcc_cd.Code!="" && formObj.rcc_cd.Code!="ALL"){ // 조회 조건 RCC_CD 있을 경우, 그에 해당하는 LCC 만 입력 가능
							  	  if(formObj.rcc_cd.Code != tmpRccCd){
									  ComShowCodeMessage("EQR01027",formObj.rcc_cd.Code); // 'LCC code is invalid.'
									  sheetObj.CellValue2(Row, "rcc_cd") = "";
									  return false;
								  }
							  }
							  
						   }else{
						   	  // 유효하지 않은 LCC_CD 인 것임
							  ComShowCodeMessage("EQR01005"); // 'LCC code is invalid.'
						   	  sheetObj.CellValue2(Row, "lcc_cd") = "";
						      sheetObj.CellValue2(Row, "rcc_cd") = "";
						   }
					  }
				      break;   
				default:
				    if(sheetObj.RowCount > 0){
			            // Col TTL 계산
			            calcColTtl(sheetObj);
			        } 
					break;
			  }
         }
     }
	 
     /**
      * 저장 완료시 처리
      */
     function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	 	var formObj = document.form;
	 	if(formObj.pop_mode.value == "Y"){ // popup mode 일 때만 수행
	 	 if (ErrMsg == "") {
	 		if (save_flag) {
	 		
	 			var opener_obj = window.opener;
	 			var week_seq = formObj.dp_seq.value;
	 			var sheet_row = formObj.row.value;
	 			
	 			for (var j = 9; j <= 24; j++) { // QTY 만 선택
						if (sheetObjects[0].rowCount > 0) {
							var tmpSum = sheetObj.ComputeSum("|"+j+"|");
							opener_obj.setRepoInValue(week_seq, sheet_row, sheetObjects[0].ColSaveName(j).substr(0, 2), tmpSum);
						}
						else { //sheet_num
							// 0 으로 셋팅합니다.(모두 삭제한 경우)
							opener_obj.setRepoInValue(week_seq, sheet_row, sheetObjects[0].ColSaveName(j).substr(0, 2), 0);
						}
					}
				}
				ComShowCodeMessage("EQR70002");
			}
		}
     }	 

    /**
     * 설  명 :  Combo 기본 설정 <br>
     * <br><b>Example : </b>
     * <pre>
     *     initCombo(comboObj,comboNo)
     * </pre>
     * @param {object}  comboObj - Combo Object
     * @param {Number}  comboNo  - Combo Number
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function initCombo (comboObj, comboNo) {
        var cnt  = 0 ;
        
        switch(comboNo) {   
			
			// RCC_CD
            case 1:
                with (comboObj) {               
                    DropHeight = 12 * 20;
                    MultiSelect = false;
                }
                break;
			
			// LCC_CD
            case 2:
                with (comboObj) {               
                    DropHeight = 12 * 20;
                    MultiSelect = false;
                }
                break;
				    
            // CNTR Type Size
            case 3:
                with (comboObj) {               
                    DropHeight = 12 * 20;
                    
                    var menuname = tpszallText.split('|'); 
                    var menucode = tpszallCode.split('|'); 
                    
                    MultiSelect = true;
                    MaxSelect = menuname.length;
                    MultiSeparator = ",";
                    
                    for(i=0; i<menuname.length; i++) {
                        InsertItem(cnt++, menuname[i], menucode[i]);                            
                    } 
                }
                break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(sheetObj){
            switch (sAction) {
            case IBSAVE:
			    
			    // WK 형식 
				var trnRowStr = FindStatusRow("U|I"); 
				if(trnRowStr != ""){
	                var trnRowArr = trnRowStr.split(";");
					
					for(var i=0; i<trnRowArr.length; i++){
						if (trnRowArr[i] != "") {
							var tmpWeek = CellValue(trnRowArr[i], "onh_pln_yrwk");
							if (tmpWeek == "" ||
							tmpWeek.length != 6 ||
							!ComIsWeek(tmpWeek.substr(4, 2))) {
								ComShowCodeMessage("EQR01101", "right WK (YYYYMM)"); // 'Please input {?msg1}.';
								SelectCell(trnRowArr[i], "onh_pln_yrwk");
								return false;
							}
						}
					}
				}else if(FindStatusRow("U|I|D")==""){
					// 저장할 데이터가 없습니다.
                    ComShowCodeMessage("EQR01107"); // 'There is no data to save.'
				}
				break;
			case MULTI02:
			    // 선택한 로우 있는 가?
				var selRow = sheetObj.SelectRow;
				if(selRow == ""){
					ComShowCodeMessage("EQR01101", "row"); //'Please select {?msg1}.'
					return false;
				}else if(sheetObj.CellValue(selRow,"sts_cd")!="S"){
					ComShowCodeMessage("EQR01021"); //'Only Saved row can be Requested.'
					return false;
				}
			    break;
			
			case MULTI03:
                // 선택한 로우 있는 가?
                var selRow = sheetObj.SelectRow;
                if(selRow == ""){
                    ComShowCodeMessage("EQR01101", "row"); //'Please select {?msg1}.'
                    return false;
                }else if(sheetObj.CellValue(selRow,"sts_cd")!="R"){
                    ComShowCodeMessage("EQR01022"); //'Only Requested row can be Request Canceled.'
                    return false;
                }
                break;
				
			case IBSEARCH:
				if (document.form.div_flag[0].checked == true) { // Approval WK 가 선택
                    if(formObj.yrwk.value == ""
					   || formObj.yrwk.value.length != 6
					   || !ComIsWeek(formObj.yrwk.value.substr(4,2))){

						ComShowCodeMessage("EQR01101", "Approval WK (YYYYWW)"); // 'Please input {?msg1}.';
                        return false;
					}
				}else if (document.form.div_flag[2].checked == true) { // Pick-up WK 가 선택
                        if(formObj.yrwk_pkup.value == ""
    					   || formObj.yrwk_pkup.value.length != 6
    					   || !ComIsWeek(formObj.yrwk_pkup.value.substr(4,2))){

    						ComShowCodeMessage("EQR01101", "Pick-up  WK (YYYYWW)"); // 'Please input {?msg1}.';
                            return false;
    					}                    
				}else if (document.form.div_flag[1].checked == true) { // Approval WK - Period 가 선택
					if(formObj.periodtp.value == "W"){ // yyyyww
						if(formObj.fmperiod.value == "" || formObj.fmperiod.value.length != 6
	                       || !ComIsWeek(formObj.fmperiod.value.substr(4,2))){
						   	
	                        ComShowCodeMessage("EQR01101", "From Period (YYYYWW)"); // 'Please input {?msg1}.';
							return false;
	                    }
						if(formObj.toperiod.value == ""
                           || formObj.toperiod.value.length != 6
                           || !ComIsWeek(formObj.toperiod.value.substr(4,2))){
    
                            ComShowCodeMessage("EQR01101", "To Period (YYYYWW)"); // 'Please input {?msg1}.';
                            return false;
                        }
						if(formObj.fmperiod.value > formObj.toperiod.value){
							ComShowCodeMessage("EQR01101", "right Period"); // 'Please input {?msg1}.';
							return false;
						}
						if((((formObj.toperiod.value.substr(0,4)*1-formObj.fmperiod.value.substr(0,4)*1)*52)
						    +(formObj.toperiod.value.substr(4,2)*1-formObj.fmperiod.value.substr(4,2)*1)) > 11){
							ComShowCodeMessage("EQR01106", "12 Weeks"); // 'Maximum period is {?msg1}.'
                            return false;
						}
					}else{ // yyyymm
						if(formObj.fmperiod.value == ""
                           || formObj.fmperiod.value.length != 6
                           || !ComIsMonth(formObj.fmperiod.value.substr(4,2))){
    
                            ComShowCodeMessage("EQR01101", "From Period (YYYYMM)"); // 'Please input {?msg1}.';
                            return false;
                        }
                        if(formObj.toperiod.value == ""
                           || formObj.toperiod.value.length != 6
                           || !ComIsMonth(formObj.toperiod.value.substr(4,2))){
    
                            ComShowCodeMessage("EQR01101", "To Period (YYYYMM)"); // 'Please input {?msg1}.';
                            return false;
                        }
						if(formObj.fmperiod.value > formObj.toperiod.value){
                            ComShowCodeMessage("EQR01101", "right Period"); // 'Please input {?msg1}.';
                            return false;
                        }
                        if((((formObj.toperiod.value.substr(0,4)*1-formObj.fmperiod.value.substr(0,4)*1)*12)
                            +(formObj.toperiod.value.substr(4,2)*1-formObj.fmperiod.value.substr(4,2)*1)) > 11){
                            ComShowCodeMessage("EQR01106", "12 Months"); // 'Maximum period is {?msg1}.'
                            return false;
                        }
					}
				}else if (document.form.div_flag[3].checked == true) { // Pick-up WK - Period 가 선택
					if(formObj.periodtp_pkup.value == "W"){ // yyyyww
						if(formObj.fmperiod_pkup.value == "" || formObj.fmperiod_pkup.value.length != 6
	                       || !ComIsWeek(formObj.fmperiod_pkup.value.substr(4,2))){
						   	
	                        ComShowCodeMessage("EQR01101", "From Period (YYYYWW)"); // 'Please input {?msg1}.';
							return false;
	                    }
						if(formObj.toperiod_pkup.value == ""
                           || formObj.toperiod_pkup.value.length != 6
                           || !ComIsWeek(formObj.toperiod_pkup.value.substr(4,2))){
    
                            ComShowCodeMessage("EQR01101", "To Period (YYYYWW)"); // 'Please input {?msg1}.';
                            return false;
                        }
						if(formObj.fmperiod_pkup.value > formObj.toperiod_pkup.value){
							ComShowCodeMessage("EQR01101", "right Period"); // 'Please input {?msg1}.';
							return false;
						}
						if((((formObj.toperiod_pkup.value.substr(0,4)*1-formObj.fmperiod_pkup.value.substr(0,4)*1)*52)
						    +(formObj.toperiod_pkup.value.substr(4,2)*1-formObj.fmperiod_pkup.value.substr(4,2)*1)) > 11){
							ComShowCodeMessage("EQR01106", "12 Weeks"); // 'Maximum period is {?msg1}.'
                            return false;
						}
					}else{ // yyyymm
						if(formObj.fmperiod_pkup.value == ""
                           || formObj.fmperiod_pkup.value.length != 6
                           || !ComIsMonth(formObj.fmperiod_pkup.value.substr(4,2))){
    
                            ComShowCodeMessage("EQR01101", "From Period (YYYYMM)"); // 'Please input {?msg1}.';
                            return false;
                        }
                        if(formObj.toperiod_pkup.value == ""
                           || formObj.toperiod_pkup.value.length != 6
                           || !ComIsMonth(formObj.toperiod_pkup.value.substr(4,2))){
    
                            ComShowCodeMessage("EQR01101", "To Period (YYYYMM)"); // 'Please input {?msg1}.';
                            return false;
                        }
						if(formObj.fmperiod_pkup.value > formObj.toperiod_pkup.value){
                            ComShowCodeMessage("EQR01101", "right Period"); // 'Please input {?msg1}.';
                            return false;
                        }
                        if((((formObj.toperiod_pkup.value.substr(0,4)*1-formObj.fmperiod_pkup.value.substr(0,4)*1)*12)
                            +(formObj.toperiod_pkup.value.substr(4,2)*1-formObj.fmperiod_pkup.value.substr(4,2)*1)) > 11){
                            ComShowCodeMessage("EQR01106", "12 Months"); // 'Maximum period is {?msg1}.'
                            return false;
                        }
					}
				}
            }
        }
        return true;
    }  
    
    /**
     * 설  명 : TP/SZ 종류 변경시 코드 설정 <br>
     * <br><b>Example : </b>
     * <pre>
     *     tpszChange('')
     * </pre>
     * @param {String}  key - tpsz Combo Value('' - ALL, D - Dry, R - Refer, O - O/T, F - F/R)
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function tpszChange(key){
        switch (key) {
        case "":
            document.form.tpsztype.Code = consTpsz;                              
            break;
        case "D":
            document.form.tpsztype.Code = consTpszDry;                
            break;
        case "R":
            document.form.tpsztype.Code = consTpszRfr;
            break;
        case "O":
            document.form.tpsztype.Code = consTpszOt;
            break;
        case "F":
            document.form.tpsztype.Code = consTpszFr;
            break;
        }
    }
    
    /**
     * 설  명 : Form Object의 Change Event <br>
     * <br><b>Example : </b>
     * <pre>
     *     form_change()
     * </pre>
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function form_change(){
        var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName){
            case "cntrTpsz":
                var index = document.form.cntrTpsz.selectedIndex;
                tpszChange(document.form.cntrTpsz.options[index].value);
		        break;
		}
    }

    function rcc_cd_OnChange() {
        doActionIBSheet(sheetObjects[0],document.form,SEARCH03);
    }    
	
    function tpsztype_OnChange(){
        setGridHidden(form.tpsztype.Text);
		// Col TTL 계산
        calcColTtl(sheetObjects[0]);
    }
    
    /*
     * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
     * OnloadPage,OnSearchEnd event에서 호출
     * @param {String} tpsz_cd
     * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
     */
    function setGridHidden(tpsz_cd){
        var sheetObj = sheetObjects[0]; 
        var arr_tpsz = tpsz_cd.split(",");

        for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
            for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
                if(consTpszArr[i] == arr_tpsz[j]){
                    sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_qty")   = false;
                    break;
                }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                    sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_qty")   = true;
                }
            }       
        }  
    }    
	
	function radioToggle(){
        var formObj = document.form;
        if(document.form.div_flag[0].checked == true){ // Approval WK 가 선택
            formObj.yrwk.className            = "input1";
            formObj.periodtp.className        = "input";
            formObj.fmperiod.className        = "input";
            formObj.toperiod.className   	  = "input";
            
            formObj.yrwk_pkup.className       = "input";
            formObj.periodtp_pkup.className   = "input";
            formObj.fmperiod_pkup.className   = "input";
            formObj.toperiod_pkup.className   = "input";
            
        }else if(document.form.div_flag[1].checked == true){ // Approval WK - Period 가 선택
            formObj.yrwk.className            = "input";
            formObj.periodtp.className        = "input1";
            formObj.fmperiod.className        = "input1";
            formObj.toperiod.className   	  = "input1";
            
            formObj.yrwk_pkup.className       = "input";
            formObj.periodtp_pkup.className   = "input";
            formObj.fmperiod_pkup.className   = "input";
            formObj.toperiod_pkup.className   = "input";
        }else if(document.form.div_flag[2].checked == true){ // Pick-up WK  선택
            formObj.yrwk.className            = "input";
            formObj.periodtp.className        = "input";
            formObj.fmperiod.className        = "input";
            formObj.toperiod.className   	  = "input";
            
            formObj.yrwk_pkup.className       = "input1";
            formObj.periodtp_pkup.className   = "input";
            formObj.fmperiod_pkup.className   = "input";
            formObj.toperiod_pkup.className   = "input";
        }else if(document.form.div_flag[3].checked == true){ // Pick-up WK -period  선택
            formObj.yrwk.className            = "input";
            formObj.periodtp.className        = "input";
            formObj.fmperiod.className        = "input";
            formObj.toperiod.className   	  = "input";
            
            formObj.yrwk_pkup.className       = "input";
            formObj.periodtp_pkup.className   = "input1";
            formObj.fmperiod_pkup.className   = "input1";
            formObj.toperiod_pkup.className   = "input1";
        } 
    }
	
    // Column TTL 을 계산한다
	function calcColTtl(sheetObj){
		
		if(document.form.tpsztype.Text == ""){// 선택된 TPSZ 없으면
			for (var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++) {
				var rowSts = sheetObj.CellValue(i,"ibflag"); // ibflag 유지
			    sheetObj.CellValue2(i,"ttl")    = 0;  
				sheetObj.CellValue2(i,"ibflag") = rowSts;
			}
		}else{
			var arr_tpsz = document.form.tpsztype.Text.split(","); // 선택된 TP/SZ	
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				var rowSts = sheetObj.CellValue(i,"ibflag"); // ibflag 유지
				var tmpSum = 0;
				
				for(var t=0; t<arr_tpsz.length; t++){
				    tmpSum = tmpSum + sheetObj.CellValue(i,arr_tpsz[t].toLowerCase()+"_qty")*1;
				}
				sheetObj.CellValue2(i,"ttl")    = tmpSum;   
				sheetObj.CellValue2(i,"ibflag") = rowSts;
			}
		}
	}	
    /* 개발자 작업  끝 */