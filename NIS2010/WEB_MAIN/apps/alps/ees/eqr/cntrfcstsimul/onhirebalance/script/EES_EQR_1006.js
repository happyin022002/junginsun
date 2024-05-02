/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1006.js
*@FileTitle : On-Hire Status
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.13 문동선
* 1.0 Creation
=========================================================*/
    /**
     * @extends 
     * @class EES_EQR_1006 : EES_EQR_1006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1006() { 
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
	//var searchFlag = false; // sheet 가 조회 되었는지에 대한 flag 
    
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
            case "btn_downExcel":
                ComOpenWait(true);
                sheetObjects[0].Down2Excel(-1,false,false,true,"","",false,false,"",false,"");
                ComOpenWait(false);
                break;
            
			case "btn_rowadd":
			    if(sheetObjects[0].SelectHighLight && 
				   (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"merge_flag").substr(0,1)=="Y"
				    ||sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"merge_flag").substr(0,1)=="N")){ // 선택된 row 있고, 조회행/ 선택생성행이면
					var selRow = sheetObjects[0].SelectRow;
					for(var i=selRow; i<sheetObjects[0].LastRow; i++){
						if (sheetObjects[0].CellValue(i, "merge_flag").substr(0,1) != "Y"
						    && sheetObjects[0].CellValue(i, "merge_flag").substr(0,1) != "N"
							&& sheetObjects[0].CellValue(i, "merge_flag").substr(0,1) != "X") {
							sheetObjects[0].SelectCell(i - 1, "onh_ord_yr");
							break;
						}						
					}
					var newRow = sheetObjects[0].DataInsert();
					rowInsertSeq++; // 신규 Row Merge 방지
					sheetObjects[0].CellValue2(newRow,"merge_flag") = "N"+rowInsertSeq;
                    sheetObjects[0].CellValue2(newRow,"x_merge_flag") = "Y"; // RCC, LCC 는 merge					
					sheetObjects[0].CellValue2(newRow,"rcc_cd") = sheetObjects[0].CellValue(selRow,"rcc_cd");
					sheetObjects[0].CellValue2(newRow,"lcc_cd") = sheetObjects[0].CellValue(selRow,"lcc_cd");
				}else{
					var newRow = sheetObjects[0].DataInsert(0);
					rowInsertSeq++; // 신규 Row Merge 방지
					sheetObjects[0].CellValue2(newRow,"merge_flag") = "X"+rowInsertSeq; // Row 선택 없이 추가된 경우
					sheetObjects[0].CellValue2(newRow,"x_merge_flag") = "X"+rowInsertSeq; // RCC, LCC 도 merge 방지 
					sheetObjects[0].RowSumable(selRow) = false; // 소계 계산에서 제외
					sheetObjects[0].CellEditable(newRow,"rcc_cd") = true;
					sheetObjects[0].CellEditable(newRow,"lcc_cd") = true;
				}
				break;
			case "btn_rowdel":
			    if (sheetObjects[0].SelectHighLight) { // 선택된 row 있으면
				    var selRow = sheetObjects[0].SelectRow;
					
					if(sheetObjects[0].CellValue(selRow,"ibflag")=="I"){ // 신규 입력 건
                        // 완전 삭제
						sheetObjects[0].RowDelete(selRow, false);
						sheetObjects[0].SelectCell(selRow,"rcc_cd");
                    }else if(sheetObjects[0].CellValue(selRow,"merge_flag").substr(0,1)=="Y"
					           || sheetObjects[0].CellValue(selRow,"merge_flag").substr(0,1)=="X"
							   || sheetObjects[0].CellValue(selRow,"merge_flag").substr(0,1)=="N"){ // 합계행이 아닌 경우
                        // 히든, sts = D
						sheetObjects[0].SelectCell(selRow+1,"rcc_cd");
                        sheetObjects[0].CellValue(selRow,"ibflag") = "D";
//						sheetObjects[0].RowStatus(selRow) = "D";
						 
						for(var j=8; j<sheetObjects[0].LastCol; j++){ // row 의 모든 값을 "0" 으로 바꿈 (showSubSum 의 IsSumEx 버그 때문)
							sheetObjects[0].CellValue2(selRow,j) = 0 ;
						}
						sheetObjects[0].RowSumable(selRow) = false; // 소계 계산에서 제외
						sheetObjects[0].RowHidden(selRow) = true;
						calcSubsum(sheetObjects[0]);
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
//            sheetObjects[i].Visible = true;
        }
        initControl();
        
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
        document.form.cntrTpsz.selectedIndex = 1; // Dry 선택
        tpszChange('D'); // Dry 선택
        
        var level_cd = document.form.level_cd.value;
        
		doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
		
		setSheetCombo(sheetObjects[0]); // sheet 의 콤보 Item 세팅
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
                   style.height = 445;
                   //전체 너비 설정
                   SheetWidth = mainTable.clientWidth;    
                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msPrevColumnMerge + msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                   Editable = true;
                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo(2, 1, 22, 100);
                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(false, false, false, true, false,false);
                   
                   var HeadTitle1 = "|RCC|LCC||Year|Term|Period|STS|"
									+ "Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|"
									+ "P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|"
									+ "P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|"
									+ "On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|"
									+ "On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|"
									+ "Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|"
									+ "Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|"
									+ "Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|"
									+ "Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|"
									+ "Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|"
									+ "Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|"
									+ "Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|"
									+ "Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|"
									+ "Remark";
                   var HeadTitle2 = "|RCC|LCC||Year|Term|Period|STS|"
									+ "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|A5|TTL|"
									+ "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|A5|TTL|"
									+ "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|A5|TTL|"
									+ "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|A5|TTL|"
									+ "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|A5|TTL|"
									+ "Remark" ;
                   
                   HeadTitleCnt = ComCountHeadTitle(HeadTitle1);
                   InitColumnInfo(HeadTitleCnt, 0, 0, true);
                   
                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle1, true);
                   InitHeadRow(1, HeadTitle2, true);
                   sheetObj.FrozenCols = 8;

                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   
				   InitDataProperty(0, cnt++, dtHidden,  0, daCenter, true, "x_merge_flag",false,"", dfNone, 0, true,  true);
                   InitDataProperty(0, cnt++, dtCombo,  60, daCenter, true, "rcc_cd",      true, "", dfNone, 0, false, false);
                   InitDataProperty(0, cnt++, dtCombo,  60, daCenter, true, "lcc_cd",      true, "", dfNone, 0, false, false);
				   
                   InitDataProperty(0, cnt++, dtHidden,  0, daCenter, true, "merge_flag",  false,"", dfNone, 0, true,  true);
                   InitDataProperty(0, cnt++, dtCombo,  50, daCenter, true, "onh_ord_yr",  true, "", dfNone, 0, false, true);
                   InitDataProperty(0, cnt++, dtCombo,  50, daCenter, true, "eq_lstm_cd",  true, "", dfNone, 0, false, true);
                   InitDataProperty(0, cnt++, dtCombo,  55, daCenter, true, "lse_prd_seq", true, "", dfNone, 0, false, true);                   
                   InitDataProperty(0, cnt++, dtHiddenStatus,  0, daCenter, true, "ibflag");
                   
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_d2_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_d4_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_d5_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_d7_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_r2_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_r5_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_r9_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_o2_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_o4_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_o5_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_s2_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_s4_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_f2_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_f4_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_f5_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_a2_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_a4_qty", false, "", dfInteger, 0, true,  true, 6);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "order_a5_qty", false, "", dfInteger, 0, true,  true, 6);
				   InitDataProperty(0, cnt++, dtAutoSumEx, 46, daRight, false, "order_ttl",    false, "", dfInteger, 0, false, false);
                   
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_d2_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_d4_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_d5_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_d7_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_r2_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_r5_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_r9_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_o2_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_o4_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_o5_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_s2_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_s4_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_f2_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_f4_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_f5_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_a2_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_a4_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "appr_a5_qty", false, "", dfInteger, 0, false, false);
				   InitDataProperty(0, cnt++, dtAutoSumEx, 46, daRight, false, "appr_ttl",    false, "", dfInteger, 0, false, false);                   

                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_d2_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_d4_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_d5_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_d7_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_r2_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_r5_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_r9_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_o2_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_o4_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_o5_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_s2_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_s4_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_f2_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_f4_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_f5_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_a2_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_a4_qty", false, "", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rslt_a5_qty", false, "", dfInteger, 0, false, false);
				   InitDataProperty(0, cnt++, dtAutoSumEx, 46, daRight, false, "rslt_ttl",    false, "", dfInteger, 0, false, false); 
                   
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_d2_qty", false, "|order_d2_qty|-|rslt_d2_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_d4_qty", false, "|order_d4_qty|-|rslt_d4_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_d5_qty", false, "|order_d5_qty|-|rslt_d5_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_d7_qty", false, "|order_d7_qty|-|rslt_d7_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_r2_qty", false, "|order_r2_qty|-|rslt_r2_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_r5_qty", false, "|order_r5_qty|-|rslt_r5_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_r9_qty", false, "|order_r9_qty|-|rslt_r9_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_o2_qty", false, "|order_o2_qty|-|rslt_o2_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_o4_qty", false, "|order_o4_qty|-|rslt_o4_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_o5_qty", false, "|order_o5_qty|-|rslt_o5_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_s2_qty", false, "|order_s2_qty|-|rslt_s2_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_s4_qty", false, "|order_s4_qty|-|rslt_s4_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_f2_qty", false, "|order_f2_qty|-|rslt_f2_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_f4_qty", false, "|order_f4_qty|-|rslt_f4_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_f5_qty", false, "|order_f5_qty|-|rslt_f5_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_a2_qty", false, "|order_a2_qty|-|rslt_a2_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_a4_qty", false, "|order_a4_qty|-|rslt_a4_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "rsltblnc_a5_qty", false, "|order_a5_qty|-|rslt_a5_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 46, daRight, false, "rsltblnc_ttl",    false, "|order_ttl|-|rslt_ttl|", dfInteger, 0, false, false); 
                   
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_d2_qty", false, "|order_d2_qty|-|appr_d2_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_d4_qty", false, "|order_d4_qty|-|appr_d4_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_d5_qty", false, "|order_d5_qty|-|appr_d5_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_d7_qty", false, "|order_d7_qty|-|appr_d7_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_r2_qty", false, "|order_r2_qty|-|appr_r2_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_r5_qty", false, "|order_r5_qty|-|appr_r5_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_r9_qty", false, "|order_r9_qty|-|appr_r9_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_o2_qty", false, "|order_o2_qty|-|appr_o2_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_o4_qty", false, "|order_o4_qty|-|appr_o4_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_o5_qty", false, "|order_o5_qty|-|appr_o5_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_s2_qty", false, "|order_s2_qty|-|appr_s2_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_s4_qty", false, "|order_s4_qty|-|appr_s4_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_f2_qty", false, "|order_f2_qty|-|appr_f2_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_f4_qty", false, "|order_f4_qty|-|appr_f4_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_f5_qty", false, "|order_f5_qty|-|appr_f5_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_a2_qty", false, "|order_a2_qty|-|appr_a2_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_a4_qty", false, "|order_a4_qty|-|appr_a4_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_a5_qty", false, "|order_a5_qty|-|appr_a5_qty|", dfInteger, 0, false, false);
                   InitDataProperty(0, cnt++, dtAutoSumEx, 40, daRight, false, "apprblnc_ttl", false, "|order_ttl|-|appr_ttl|", dfInteger, 0, false, false); 
                   
                   InitDataProperty(0, cnt++, dtData, 200, daLeft,  true,  "onh_ord_rmk",     false, "", dfNone, 0, false, false, 500);
                   
                   ImageList(0) = "img/btns_search_off.gif";
                   ImageList(1) = "img/btns_search.gif";     // popup icon 이미지
                   ImageList(2) = "img/btns_note.gif";  
                   
                   WaitImageVisible=false;
                   CountPosition = 0;        
                   AutoRowHeight = false;    // 높이를 자동으로 조정하지 않고, 1줄 높이로 고정한다
                   
                   SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
                   SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
                   SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지

                   InitComboNoMatchText(true); // Combo 항목에 없는 데이터도 보여줌

                   SpeedOption="NOSUM";
            }
            break;
            
        }
    }
    
      // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
        sheetObj.ShowDebugMsg = false;  
        switch(sAction) {
           case IBSAVE:        //저장
	            if (validateForm(sheetObj, formObj, sAction)) {
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					var sXml = sheetObj.DoSave("EES_EQR_1006GS.do", FormQueryString(formObj), "ibflag");

					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") { // 저장 성공했으면
                        ComShowCodeMessage("EQR01020","Saved"); // '{?msg1} Successfully.'
                    }
					ComOpenWait(false);
				}
                break;
           
           case IBSEARCH:        //조회
                if(formObj.years.Text == ""){
					ComShowCodeMessage("EQR01102", "Year"); // 'Please select {?msg1}.'
					return false;
                }
                
                ComOpenWait(true); 
                sheetObjects[0].Redraw = false;
                formObj.f_cmd.value = SEARCH;

                //setSheetCombo(sheetObj); // 조회조건에 맞게 sheet 내 combo 옵션값 설정
                var sXml = sheetObj.GetSearchXml("EES_EQR_1006GS.do",FormQueryString(formObj));
                //sheetObjects[0].RemoveAll();
                sheetObjects[0].LoadSearchXml(sXml);
				
                //setSearchFlag(true);
                sheetObjects[0].Redraw = true;
                ComOpenWait(false);                
                break;
             
			 case SEARCH02: // RCC_CD 콤보 리스트 조회
			     formObj.f_cmd.value = SEARCH02;
				 var sXml = sheetObj.GetSearchXml("EES_EQR_1006GS.do" , FormQueryString(formObj)+"&loc_grp_cd=R");
				 ComXml2ComboItem(sXml, formObj.rcc_cd, "code", "name");
				 rccCdList = ComXml2ComboString(sXml,"code","name")[0];
				 formObj.rcc_cd.InsertItem(0,"ALL","ALL");
				 formObj.rcc_cd.Text = 'ALL';
				 break;
			
			case SEARCH03: // LCC_CD 콤보 리스트 조회
                 formObj.f_cmd.value = SEARCH02; // 주의, 위와 같음
                 var sXml = sheetObj.GetSearchXml("EES_EQR_1006GS.do" , FormQueryString(formObj)+"&loc_grp_cd=L"+"&loc_cd="+formObj.rcc_cd.Code);
                 ComXml2ComboItem(sXml, formObj.lcc_cd, "code", "name");
				 if(ComGetTotalRows(sXml)*1>0){
				    lccCdList = ComXml2ComboString(sXml,"code","name")[0];	
				 }
				 formObj.lcc_cd.InsertItem(0,"ALL","ALL");
				 formObj.lcc_cd.Text = 'ALL';
				 break;	 
			          
        }
    }
	
	
	// 조회 조건에 맞게 sheet의 combo의 option 값을 설정함
	// LoadSearchXml 에 앞서 실행 함
	function setSheetCombo(sheetObj){
		var formObj = document.form;

		// 조회 조건 내용으로 sheet 내 combo 제한 없앰, java 에서 insert, update 구분
        // RCC
        sheetObj.InitDataCombo(0, "rcc_cd", " |"+rccCdList, " |"+rccCdList, "", "");
        
        // LCC   
        sheetObj.InitDataCombo(0, "lcc_cd", " |"+lccCdList, " |"+lccCdList, "", "");
        
        // Year
		var currYear = document.form.curr_year.value;
		var inserYear = currYear*1 +1;
        var inserItem = " ";            
		for(i=0; i<7; i++) {
             inserItem = inserItem + "|" + (inserYear-i) ;                            
        } 
        sheetObj.InitDataCombo(0, "onh_ord_yr", inserItem, inserItem, "", "");
        
        // Term
        sheetObj.InitDataCombo(0, "eq_lstm_cd", " |LT|ST|OW", " |LT|ST|OW", "", "");
        
        // Pefiod
        sheetObj.InitDataCombo(0, "lse_prd_seq", " |1st|2nd|3rd|4th|5th|6th|7th|8th|9th|10th", " |1|2|3|4|5|6|7|8|9|10", "", "");
	}
    
	// sheet1 조회 후 처리
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        sheetObj.SelectHighLight = false;
		
		sheetObj.ColBackColor("onh_ord_rmk") = sheetObj.RgbColor(255,255,255); // rmk 배경색 흰색으로 함
		
		// Col TTL 계산
		calcColTtl(sheetObj, "");
		
		// Sub Sum 계산
		calcSubsum(sheetObj);
		
		// merge 영역 마지막 줄의 Approval/Result 값이 Order 보다 클 때 빨간색으로 표시
		// BCImpl 에서 Approval/Result 값을 Row 별로 분배하는 로직이 있는데, 이 때 Order 값에 비해 큰 경우엔 마지막줄에 모두 넣게 된다
		// 이에 대한 mark 로서 빨간색으로 표시함.
		// 화면에서 Balance 가 이미 이들의 차를 구하고 있으므로 Balance 값이 마이너스인 경우를 찾으면 된다. 		
		
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i,"merge_flag")=="Y"){
				for(var t=0; t<consTpszArr.length; t++){
				    if(sheetObj.CellValue(i,"apprblnc_"+consTpszArr[t].toLowerCase()+"_qty")*1 < 0){
						sheetObj.CellFontColor(i,"appr_"+consTpszArr[t].toLowerCase()+"_qty") = sheetObj.RgbColor(255,0,0);
					}
					if(sheetObj.CellValue(i,"rsltblnc_"+consTpszArr[t].toLowerCase()+"_qty")*1 < 0){
                        sheetObj.CellFontColor(i,"rslt_"+consTpszArr[t].toLowerCase()+"_qty") = sheetObj.RgbColor(255,0,0);
                    }	
				}
			}
		}
		sheetObj.RowFontColor(sheetObj.LastRow) = sheetObj.RgbColor(0,0,0); // 합계행 font 검정색으로
		
        // 첫 Row 와 RCC, LCC 같은 Row 가 맨 윗줄에 추가 될 경우, SubSum 이 합산 되는 것을 방지하기 위해 Hidden Row 를 추가
		if(sheetObj.RowCount("R")>0){
            newRow = sheetObjects[0].DataInsert(0);  
            sheetObj.RowHidden(newRow) = true;
            sheetObj.CellValue2(newRow,"ibflag")="R";
		}
    }

    // Column TTL 을 계산한다
	// row 인자에 값이 있을 땐(OnChange 에서 호출) 그 row 의 Order 만을 계산한다.
    function calcColTtl(sheetObj, row){
		var arr_tpsz = document.form.tpsztype.Text.split(","); // 선택된 TP/SZ
		
		if (row != "") { // sheet1_OnChange 에서 호출 (값 수정)
		     var i = row;
			 
		     if(sheetObj.CellValue(i,"merge_flag")=="Y"                     // 조회 해온 Data Row
                    ||sheetObj.CellValue(i,"merge_flag").substr(0,1)=="N"   // 선택 후 추가 된 Row
                    ||sheetObj.CellValue(i,"merge_flag").substr(0,1)=="X"){ // 선택 없이 추가 된 Row
                    var rowSts = sheetObj.CellValue(i,"ibflag"); // ibflag 유지
                    var order_tmpSum = 0;
                    for(var t=0; t<arr_tpsz.length; t++){
                        order_tmpSum    = order_tmpSum    + sheetObj.CellValue(i,"order_"+arr_tpsz[t].toLowerCase()+"_qty")*1;
                    }
                    sheetObj.CellValue2(i,"order_ttl")    = order_tmpSum;   
					sheetObj.CellValue2(i,"ibflag") = rowSts;
             }
		}else{	
			for(var i=0; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
	            if(sheetObj.CellValue(i,"merge_flag")=="Y"                  // 조회 해온 Data Row
				    ||sheetObj.CellValue(i,"merge_flag").substr(0,1)=="N"   // 선택 후 추가 된 Row
					||sheetObj.CellValue(i,"merge_flag").substr(0,1)=="X"){ // 선택 없이 추가 된 Row
					var rowSts = sheetObj.CellValue(i,"ibflag"); // ibflag 유지
                    var order_tmpSum = 0;
					var appr_tmpSum = 0;
					var rslt_tmpSum = 0;
                    for(var t=0; t<arr_tpsz.length; t++){
						order_tmpSum    = order_tmpSum    + sheetObj.CellValue(i,"order_"+arr_tpsz[t].toLowerCase()+"_qty")*1;
						appr_tmpSum     = appr_tmpSum     + sheetObj.CellValue(i,"appr_"+arr_tpsz[t].toLowerCase()+"_qty")*1;
						rslt_tmpSum     = rslt_tmpSum     + sheetObj.CellValue(i,"rslt_"+arr_tpsz[t].toLowerCase()+"_qty")*1;
					}
					sheetObj.CellValue2(i,"order_ttl")    = order_tmpSum;   
					sheetObj.CellValue2(i,"appr_ttl")     = appr_tmpSum;   
					sheetObj.CellValue2(i,"rslt_ttl")     = rslt_tmpSum;   
					sheetObj.CellValue2(i,"ibflag") = rowSts;
				}
	        }
		}
	}

    // 합계행 및 소계행을 구한다
	// 조회 후 및 편집 후에 호출된다. 
    function calcSubsum(sheetObj){
		sheetObj.Redraw = false;
		
		var order_subsum = "order_d2_qty|order_d4_qty|order_d5_qty|order_d7_qty|order_r2_qty|order_r5_qty|order_r9_qty|order_o2_qty|order_s2_qty|order_o4_qty|order_o5_qty|order_s4_qty|order_f2_qty|order_a2_qty|order_f4_qty|order_a4_qty|order_a5_qty|order_f5_qty|order_ttl";
        var appr_subsum  = "appr_d2_qty|appr_d4_qty|appr_d5_qty|appr_d7_qty|appr_r2_qty|appr_r5_qty|appr_r9_qty|appr_o2_qty|appr_s2_qty|appr_o4_qty|appr_o5_qty|appr_s4_qty|appr_f2_qty|appr_a2_qty|appr_f4_qty|appr_a4_qty|appr_a5_qty|appr_f5_qty|appr_ttl";                   
        var rslt_subsum = "rslt_d2_qty|rslt_d4_qty|rslt_d5_qty|rslt_d7_qty|rslt_r2_qty|rslt_r5_qty|rslt_r9_qty|rslt_o2_qty|rslt_s2_qty|rslt_o4_qty|rslt_o5_qty|rslt_s4_qty|rslt_f2_qty|rslt_a2_qty|rslt_f4_qty|rslt_a4_qty|rslt_a5_qty|rslt_f5_qty|rslt_ttl";                       
        var rsltblnc_subsum = "rsltblnc_d2_qty|rsltblnc_d4_qty|rsltblnc_d5_qty|rsltblnc_d7_qty|rsltblnc_r2_qty|rsltblnc_r5_qty|rsltblnc_r9_qty|rsltblnc_o2_qty|rsltblnc_s2_qty|rsltblnc_o4_qty|rsltblnc_o5_qty|rsltblnc_s4_qty|rsltblnc_f2_qty|rsltblnc_a2_qty|rsltblnc_f4_qty|rsltblnc_a4_qty|rsltblnc_a5_qty|rsltblnc_f5_qty|rsltblnc_ttl";                                    
        var apprblnc_subsum = "apprblnc_d2_qty|apprblnc_d4_qty|apprblnc_d5_qty|apprblnc_d7_qty|apprblnc_r2_qty|apprblnc_r5_qty|apprblnc_r9_qty|apprblnc_o2_qty|apprblnc_s2_qty|apprblnc_o4_qty|apprblnc_o5_qty|apprblnc_s4_qty|apprblnc_f2_qty|apprblnc_a2_qty|apprblnc_f4_qty|apprblnc_a4_qty|apprblnc_a5_qty|apprblnc_f5_qty|apprblnc_ttl";                   
        var all_subsum = order_subsum+"|"+appr_subsum+"|"+rslt_subsum+"|"+rsltblnc_subsum+"|"+apprblnc_subsum;
        
        sheetObj.ShowSubSum("rcc_cd", all_subsum, -1, false, false, 1, "", "", true); 
		sheetObj.ShowSubSum("lcc_cd", all_subsum, -1, false, false, 1, "", "", true);
		
        var lcc_subsum_rows = sheetObj.FindSubSumRow("lcc_cd");
        var rcc_subsum_rows = sheetObj.FindSubSumRow("rcc_cd");
        
        var lcc_subsum_arr = lcc_subsum_rows.split("|");
        var rcc_subsum_arr = rcc_subsum_rows.split("|");
        
        for(var i=0; i<lcc_subsum_arr.length-1; i++){ // LCC 소계
			if(sheetObj.CellValue(lcc_subsum_arr[i]-1,"merge_flag").substr(0,1)=="X"){ // 선택 없이 Row Add 된 경우
                sheetObj.RowHidden(lcc_subsum_arr[i]) = true; // subsum row 숨김
            }else{
				sheetObj.CellValue2(lcc_subsum_arr[i],"x_merge_flag") = "Y"; // RCC, LCC  merge
	            sheetObj.CellValue2(lcc_subsum_arr[i],"rcc_cd") = sheetObj.CellText(lcc_subsum_arr[i]-1,"rcc_cd");
	            sheetObj.CellValue2(lcc_subsum_arr[i],"lcc_cd") = sheetObj.CellText(lcc_subsum_arr[i]-1,"lcc_cd");
	            sheetObj.CellValue2(lcc_subsum_arr[i],4)="S.TOTAL";
			}
        }
        for(var i=0; i<rcc_subsum_arr.length-1; i++){ // RCC 소계
			if(sheetObj.CellValue(rcc_subsum_arr[i]-2,"merge_flag").substr(0,1) =="X"){ // 선택 없이 Row Add 된 경우
                sheetObj.RowHidden(rcc_subsum_arr[i]) = true; // subsum row 숨김
            }else{
				sheetObj.CellValue2(rcc_subsum_arr[i],"x_merge_flag") = "Y"; // RCC, LCC  merge
                sheetObj.CellValue2(rcc_subsum_arr[i],"rcc_cd") = sheetObj.CellText(rcc_subsum_arr[i]-2,"rcc_cd");
				sheetObj.CellValue2(rcc_subsum_arr[i],2)="S.TOTAL";
			}
        }
		
		sheetObj.ShowSum();
		if (sheetObj.RowCount("R") > 0) {
			sheetObj.CellValue2(sheetObj.LastRow,1)="G.TOTAL";
		}
		
		sheetObj.Redraw = true;
	}   

	/**
	* shee1 클릭시 이벤트 발생
	*/
	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
		var level_cd = document.form.level_cd.value;
		with (sheetObj) {
			
			if (CellValue(Row, "merge_flag").substr(0,1) == "X") { // 선택 없이 신규 생성
				InitDataProperty(0, 1, dtCombo, 60, daCenter, true, "rcc_cd", true, "", dfNone, 0, false, false);
				InitDataProperty(0, 2, dtCombo, 60, daCenter, true, "lcc_cd", true, "", dfNone, 0, false, false);
			}else{
				InitDataProperty(0, 1, dtData, 60, daCenter, true, "rcc_cd", true, "", dfNone, 0, false, false);
				InitDataProperty(0, 2, dtData, 60, daCenter, true, "lcc_cd", true, "", dfNone, 0, false, false);
			}
			
			if(ColSaveName(Col)=="onh_ord_rmk"){
				ComShowMemoPad(sheetObj, Row, Col, false, 230, 200, 500);
			}
		}
	}
   
    /**
     * sheet1 값 변경 시 이벤트 발생
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
         calcSubsum(sheetObj);
		 
		 var formObj = document.form;
		 
		 with (sheetObj) {
		 	  var colName = ColSaveName(Col);
		 	  switch (colName) {
			  
			  	case "rcc_cd":
			  		
					  if(Value == ""){
					       CellComboItem(Row, "lcc_cd", " ", " ");
					  }else if(CellValue(Row,"merge_flag").substr(0,1)=="X"){
						   formObj.f_cmd.value = SEARCH02;
                           var sXml = sheetObj.GetSearchXml("EES_EQR_1006GS.do" , FormQueryString(formObj)+"&loc_grp_cd=L"+"&loc_cd="+Value);
                           var tmpLccCdList = ComXml2ComboString(sXml,"code","name")[0];
						   
                           CellComboItem(Row, "lcc_cd", " |"+tmpLccCdList, " |"+tmpLccCdList);
					  }
				      break;   
				default:
				    // Col TTL 계산
                    calcColTtl(sheetObj, Row);	  
					break;
			  }
         }
     }


	/**
	* shee1 클릭시 이벤트 발생
	* diselect 체크
	*/
	function sheet1_OnMouseUp(sheetObj, Button, Shift, X, Y)  {
		if(Button==1) {   // 왼쪽버튼
			if (sheetObj.CellValue(sheetObj.MouseRow, "merge_flag").substr(0, 1) == "Y" ||
				sheetObj.CellValue(sheetObj.MouseRow, "merge_flag").substr(0, 1) == "N" ||
				sheetObj.CellValue(sheetObj.MouseRow, "merge_flag").substr(0, 1) == "X") { // 합계행이 아니면 선택 표시
				
				sheetObj.SelectHighLight = true;
			}else{
			    sheetObj.SelectHighLight = false;
			}
		}else if(Button==2) {  // 오른쪽 버튼
            sheetObj.SelectHighLight = false;
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
		    // Years
            case 1:
                with (comboObj) {               
                    DropHeight = 12 * 20;
                    
					var currYear = document.form.curr_year.value;
					var inserYear = currYear*1 +1;
                    
                    MultiSelect = true;
                    MaxSelect = 7;
                    MultiSeparator = ",";
                    
					for(i=0; i<7; i++) {
                        InsertItem(cnt++, inserYear-i, inserYear-i);                            
                    } 
					comboObj.Text = currYear;
                }
                break;
			
			// RCC_CD
            case 2:
                with (comboObj) {               
                    DropHeight = 12 * 20;
                    MultiSelect = false;
                }
                break;
			
			// LCC_CD
            case 3:
                with (comboObj) {               
                    DropHeight = 12 * 20;
                    MultiSelect = false;
                }
                break;
				    
            // CNTR Type Size
            case 4:
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

                // 중복체크
                var dupRow = ColValueDup("onh_ord_yr|lcc_cd|eq_lstm_cd|lse_prd_seq");
                if(dupRow != -1) {
                    ComShowCodeMessage("EQR01015"); // 'There are duplicated row with same condition. Please update data on the pre-created row.'
                    return false;
                }
				// 수량체크
				for(var i=HeaderRows; i<HeaderRows+RowCount; i++){
					if(CellValue(i,"ibflag")=="I" || CellValue(i,"ibflag")=="U"){
						var tmpSum = 0;
						for(var j=0; j<consTpszArr.length; j++){
							tmpSum = tmpSum + CellValue(i,"order_"+consTpszArr[j].toLowerCase()+"_qty")*1;
						}
						if(tmpSum == 0){
							ComShowCodeMessage("EQR01019"); // 'Total Quantity is zero.'
							SelectCell(i,"order_"+consTpszArr[0].toLowerCase()+"_qty");
							return false;
						}
					}
				}
				
				break;
				
			case IBSEARCH:
			    if(formObj.years.Text == ""){
					ComShowCodeMessage("EQR01102", "Year"); // 'Please select {?msg1}.'
					return false;
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
			
			case "eq_lstm_cd":
			case "lse_prd_seq":
			    //sheetObjects[0].RemoveAll();
				//setSearchFlag(false);
			    break;
		}
    }
    
	function years_OnChange(){
		//sheetObjects[0].RemoveAll();
		//setSearchFlag(false);
	}

    function rcc_cd_OnChange() {
		//sheetObjects[0].RemoveAll();
        doActionIBSheet(sheetObjects[0],document.form,SEARCH03);
		//setSearchFlag(false);
    }    
	function lcc_cd_OnChange(){
        //sheetObjects[0].RemoveAll();
		//setSearchFlag(false);
    }
	
	
    function tpsztype_OnChange(){
        setGridHidden(form.tpsztype.Text);
		// Col TTL 계산
        calcColTtl(sheetObjects[0], "");
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
                    sheetObj.ColHidden("order_"+consTpszArr[i].toLowerCase()+"_qty")   = false;
					sheetObj.ColHidden("appr_"+consTpszArr[i].toLowerCase()+"_qty")    = false;
					sheetObj.ColHidden("rslt_"+consTpszArr[i].toLowerCase()+"_qty")    = false;
					sheetObj.ColHidden("rsltblnc_"+consTpszArr[i].toLowerCase()+"_qty")= false;
					sheetObj.ColHidden("apprblnc_"+consTpszArr[i].toLowerCase()+"_qty")= false;
                    break;
                }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                    sheetObj.ColHidden("order_"+consTpszArr[i].toLowerCase()+"_qty")   = true;
                    sheetObj.ColHidden("appr_"+consTpszArr[i].toLowerCase()+"_qty")    = true;
                    sheetObj.ColHidden("rslt_"+consTpszArr[i].toLowerCase()+"_qty")    = true;
                    sheetObj.ColHidden("rsltblnc_"+consTpszArr[i].toLowerCase()+"_qty")= true;
                    sheetObj.ColHidden("apprblnc_"+consTpszArr[i].toLowerCase()+"_qty")= true;
                }
            }       
        }  
    }    


    /* 개발자 작업  끝 */