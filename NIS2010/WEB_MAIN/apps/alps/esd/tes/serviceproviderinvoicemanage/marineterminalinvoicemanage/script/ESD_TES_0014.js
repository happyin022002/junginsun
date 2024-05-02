/******************************************************************
 * 
 * 2009-03-11 [R200903110001] : 조회조건 중 nod_cd와 yd_cd 조건 체크 추가
 *            기존 조회조건에서 loc_cd가 공백이 아니고 nod_cd가 값이 없으면 yd_cd에 값이 null 조건에서 제외되는 현상 방지
 * 2009-08-17 : [CHM-200900760] NEW button기능에 tes_removeTESCommonALLIframes()추가
 * 2010-01-13 : [CHM-201002178] eNIS > TES > INV Inquiry 조회조건 수정
 * 2011.06.10 [CHM-201111056-01] Split 03-Split 07-ALPS Error 처리 요청
 ******************************************************************/
// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var node;
var comboObjects = new Array();
var comboCnt = 0 ;


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject  = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];


         /*******************************************************/
         var formObject = document.form;

        var OnePageRow = 10000;	// ViewRow Per Page
         
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
        	    case "btn_retrieve":
        	    	if ( ComGetDaysBetween(formObject.fm_prd_dt.value, formObject.to_prd_dt.value) < 0 ) {
						ComShowCodeMessage('TES24012'); // Start date must be earlier than end date.
						return false;
					}
        	    	if ( ComGetDaysBetween(formObject.fm_prd_dt.value, formObject.to_prd_dt.value) > 365){
                        ComShowMessage('Invoice DT must inputted within 365 days.');
        	            tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
        	            formObject.vol_show_mode[0].checked  = true;
        	            vol_show_mode_sts();
        	            return false;
                    }
					if (document.form.inv_date_type.value==undefined || document.form.inv_date_type.value==null || document.form.inv_date_type.value.trim()=='')
					{
						ComShowMessage('Please select \'Inv. Date\' type');
						return false;
					}
					// 조회조건 중 nod_cd.Code와 yd_cd 조건 체크 추가 ( 2009-03-11 )
					// 기존 조회조건에서 loc_cd가 공백이 아니고 nod_cd가 값이 없으면 yd_cd에 값이 null 조건에서 제외되는 현상 방지 추가
					if (!((document.form.loc_cd.value!=undefined && document.form.loc_cd.value!=null && document.form.loc_cd.value.trim()!='' && document.form.loc_cd.value.trim().length == 5 &&
					       document.form.nod_cd.Code!=undefined && document.form.nod_cd.Code!=null && document.form.nod_cd.Code.trim()!='' )  ||
						  (document.form.yd_cd.value!=undefined && document.form.yd_cd.value!=null && document.form.yd_cd.value.trim()!='')   ||
						  (document.form.vndr_seq.value!=undefined && document.form.vndr_seq.value!=null && document.form.vndr_seq.value.trim()!='') ||
						  (document.form.cost_ofc_cd.value!=undefined && document.form.cost_ofc_cd.value!=null && document.form.cost_ofc_cd.value.trim()!='') ||
						  (document.form.inv_ofc_cd.value!=undefined && document.form.inv_ofc_cd.value!=null && document.form.inv_ofc_cd.value.trim()!=''))) 
					{
						ComShowMessage('Please enter one of \'Yard Code\', \'S/P Code\', \'Cost OFC\' or \'INV OFC\'.');
						return false;
					}
					//if (confirm('pause')){return false;}
					
					/** 2013.02.27 log-in office가 특정 Inv(FDRCIV201301~FDRCIV201312)가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...1년 후 삭제 예정 **/
					/** 그룹사 조직 코드 변경 HAMUOG->HAMRUO, SELCOT->SELOPA (2015-08-03) **/
					if ((document.form.cre_ofc_cd.value == "HAMRUO") || (document.form.cre_ofc_cd.value == "SELOPA")) {						
						document.form.cre_ofc_cd.value = "HAMSEL";							
					}
					
					if(formObject.vol_show_mode[0].checked  == false){
   	                    //Hide 부분 조회
   	                    doActionIBSheet(sheetObject, formObject, IBSEARCH);
   	                }else{
   	                    //cost code, cntr sty code를 SQL에 넣을 수 있는 문장으로 만들어준다.
   	                    if(formObject.cost_tp[0].checked == true){
   	                        formObject.cost_code.value = "";
   	                        formObject.cntr_sty_code.value = "";
   	                    }else{
   	                        for(var i=1; i<7; i++){
   	                            if(formObject.cost_tp[i].checked == true){
   	                                formObject.cost_code.value = formObject.cost_code.value + formObject.cost_tp[i].desc;
   	                            }
   	                        }
   	                        for(var j=0; j<2; j++){
   	                            if(formObject.cntr_tp[j].checked == true){
   	                                formObject.cntr_sty_code.value = formObject.cntr_sty_code.value + formObject.cntr_tp[j].desc;
   	                            }
   	                        }
   	                    }
   	                    
   	                    doActionIBSheet1(sheetObject1, formObject, IBSEARCH);
   	                }

        	        break;

        	    case "btn_new":
					try {
						tes_removeTESCommonALLIframes();
					} catch (e){
					}
    	            formObject.reset();
    	            sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
    	            formObject.vol_show_mode[0].checked  = true;
    	            vol_show_mode_sts();
        	        break;

                case "btns_calendar1":
        	         var cal = new ComCalendar();
            		 cal.select(formObject.fm_prd_dt, 'yyyy-MM-dd');
        	        break;

        	    case "btns_calendar2":
        	         var cal = new ComCalendar();
            		 cal.select(formObject.to_prd_dt, 'yyyy-MM-dd');
        	        break;

          	    case "btn_yard":
                    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
          	       	var classId = "COM_ENS_061";

          		   		var param = '?classId='+classId;

          		   		var chkStr = dispaly.substring(0,3)

                     // radio PopUp
                     if(chkStr == "1,0") {
                    	 ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getYard', dispaly);
                      } else {
                    	  ComShowCodeMessage('TES21906'); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                           return;
                      }
          	        break;

          	    case "btn_vndr":
                    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
          	       	var classId = "COM_ENS_0C1";

          		   		var param = '?classId='+classId;

          		   		var chkStr = dispaly.substring(0,3)

                         // radio PopUp
                         if(chkStr == "1,0") {
                        	 ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, 'getVender', dispaly);
                        } else {
                        	ComShowCodeMessage('TES21906'); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                             return;
                        }
          	        break;

          	   case "btn_cost_ofc_cd" :
          	    	   
         	    	var formObject = document.form;
        			var cmdt_cd_val ="";   //향후 사용가능 예정변수
        			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
        			var cmdt_desc_val ="";   //향후 사용가능 예정변수
        			var classId ="getCOM_ENS_ofc";
        			var xx1="";  //CONTI
        			var xx2="";  //SUB CONTI
        			var xx3="";  //COUNTRY
        			var xx4="";  //STATE
        			var xx5="";  //CONTROL OFFIC
        			var xx6="";  //LOC CODE
        			var xx7="";  //LOC NAME
        			var xx8="";
        			var xx9="";

        			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
        			ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'getCostOfc', '1,0,1,1,1,1,1,1,1,1,1,1', true);
        			break;


          	   case "btn_inv_ofc_cd" :
            	    var formObject = document.form;
         			var cmdt_cd_val ="";   //향후 사용가능 예정변수
         			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
         			var cmdt_desc_val ="";   //향후 사용가능 예정변수
         			var classId ="getCOM_ENS_ofc";
         			var xx1="";  //CONTI
         			var xx2="";  //SUB CONTI
         			var xx3="";  //COUNTRY
         			var xx4="";  //STATE
         			var xx5="";  //CONTROL OFFIC
         			var xx6="";  //LOC CODE
         			var xx7="";  //LOC NAME
         			var xx8="";
         			var xx9="";

         			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
         			ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'getInvOfc', '1,0,1,1,1,1,1,1,1,1,1,1', true);
           	        break;

           	        
                case "btng_print":
                	ComShowMessage('Print service will be available soon');


//                    if(sheetObject.RowCount<1){
//                        ComShowMessage(getMsg('TES21905')); //ComShowMessage('조회된 Data가 없습니다.');
//                        return false
//                    }else{
//                        printInvoiceSummary();
//                    }

        	        break;

                case "btn_more":
                	var formObject = document.form;
                	var sheetObj;
                	
                	if( formObject.vol_show_mode[0].checked  == false ) {
                		sheetObj = sheetObject;
                	} else {
                		sheetObj = sheetObject1;
                	}
                	
					if ( checkPage(sheetObj, formObject.iPage.value, OnePageRow) ) {
						if( formObject.vol_show_mode[0].checked  == false ) {
							sheet1_OnScrollNext(sheetObject, tesFrmQryStr(formObject), formObject.iPage.value, OnePageRow);
						} else {
							sheet2_OnScrollNext(sheetObject1, tesFrmQryStr(formObject), formObject.iPage.value, OnePageRow);
						}
					}
					
				break;
				
        	    case "btng_downexcel":
    	            if(formObject.vol_show_mode[0].checked  == false){
   	                    //Hide 부분 조회
   	                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
   	                }else{
   	                    doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);

   	                }

        	        break;


            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(e);
    			ComShowCodeMessage('TES21506'); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param(sheet_obj) sheet object 
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }


    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param(combo_obj) como object
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }


   /**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     * @param(comboObjl) 	combo object
     * @param(comboNo) 		combo number
     * @param(combo_val) 	combo value
     * @param(def_val) 		def value
     */
    function initCombo (comboObj, comboNo, combo_val, def_val) {
        var cnt  = 0 ;

        switch(comboNo) {

            case 1:   //nod_cd
                with (comboObj) {
                    SetColAlign('left');
					SetColWidth('45');
					DropHeight=150;

					var tmp = '';
					if (combo_val!=null){tmp = combo_val.split('|');}
					for (var i=0; tmp!=null && i<tmp.length; i++){
						InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
					}
					if (def_val!=undefined && def_val!=null && def_val.trim()!=''){
						Code = def_val;
					} else {
						Code = '';
					}
				}
                break;
         }
    }



    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        //for(i=0;i< comboObjects.length;i++){
        //      initCombo(comboObjects[i],i+1);
        //}
        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        try	{
			tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
			document.form.vol_show_mode[0].checked = true;
			initCheckBox();
		} catch(e){}


    }

    /**
    * check box 초기화
    */        
    function initCheckBox(){
        document.form.cost_tp[0].checked = true;
        document.form.cost_tp[1].checked = false;
        document.form.cost_tp[2].checked = false;
        document.form.cost_tp[3].checked = false;
        document.form.cost_tp[4].checked = false;
        document.form.cost_tp[5].checked = false;
        document.form.cost_tp[6].checked = false;
        document.form.cntr_tp[0].checked = true;
        document.form.cntr_tp[1].checked = true;
		// Cost Type 선택시 활성화 여부.(2010-01-13)
//        disableManyObjects(document.form.cntr_tp[0], document.form.cntr_tp[1]);
        ComEnableManyObjects(false, document.form.cntr_tp[0], document.form.cntr_tp[1]);
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param(sheetObj) 	sheet object
     * @param(sheetNo)		sheet number
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 10000);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 7, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = " |H/Q|RHQ|Inv. OFC|Cost OFC|Yard|S/P|S/P Name|Curr|INV\nAMT|TAX\nAMT|WHT\nAMT|Total\nAMT|USD";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성     [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN, COLMERGE, SAVENAME,              KEYFIELD,CALCULOGIC,DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtCheckBox,    20,    daCenter,  true,    "chk");
                    InitDataProperty(0, cnt++, dtData,        60,    daCenter,  true,    "hq_ofc_cd",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        60,    daCenter,  true,    "rhq_ofc_cd",       false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        60,    daCenter,  true,    "inv_ofc_cd",       false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        60,    daCenter,  true,    "cost_ofc_cd",      false,          "",       dfNone,    0,     true,       true);

                    InitDataProperty(0, cnt++, dtData,        80,    daCenter,  true,    "yd_cd",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        50,    daCenter,  true,    "vndr_seq",         false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        100,   daCenter,  true,    "vndr_lgl_eng_nm",  false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        45,    daCenter,  true,    "curr_cd",          false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        100,   daRight,   true,    "inv_amt",          false,          "",       dfFloat,   2,     true,       true);

                    InitDataProperty(0, cnt++, dtData,        100,   daRight,   true,    "vat_amt",          false,          "",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        100,   daRight,   true,    "whld_tax_amt",     false,          "",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        100,   daRight,   true,    "ttl_inv_amt",      false,          "",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        60,    daRight,   true,    "usd_amt",          false,          "",       dfFloat,   2,     true,       true);
                    
                    CountFormat = "[SELECTDATAROW / TOTALROWS]";

               }
                break;

             case 2:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 10000);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(64, 7, 0, true);
                   // InitColumnInfo(21, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
                    InitHeadMode(true, true, false, true, false,false);



                    //CSR No, CSR ST 추가(2006.12.15, 2007.01.29 메일 참고)
                    var HeadTitle0 = " |H/Q|RHQ|Inv. OFC|Cost OFC|Yard|S/P|S/P Name|Invoice No|Inv.ST||Issue Date|INV Updated Date|VVD|Lane|ATB Date|Cost|Cost|Curr|INV\nAMT|USD\nAMT|"
                            + "Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|"
                            + "Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|"
                            + "Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|"
                            + "Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|"
                            + "Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|"
                            + "Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|"
                            + "TEU|BOX|MOVE|Over\nDays|Total\n20'|Total\n40'|Total\nTEU|Total\nBOX|Calculation Method (AMT)|Calculation Method (AMT)|Calculation Method (AMT)";
                    var HeadTitle1 = " |H/Q|RHQ|Inv. OFC|Cost OFC|Yard|S/P|S/P Name|Invoice No|Inv.ST||Issue Date|INV Updated Date|VVD|Lane|ATB Date|Code|Description|Curr|INV\nAMT|USD\nAMT|"
                            + "D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|TEU|BOX|MOVE|Over\nDays|Total\n20'|Total\n40'|Total\nTEU|Total\nBOX|Auto Calculated|Semi-updates|Manual Input";


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성     [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN, COLMERGE, SAVENAME,              KEYFIELD,CALCULOGIC,DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtCheckBox,       20,    daCenter,  true,    "chk");
                    InitDataProperty(0, cnt++, dtData,           60,    daCenter,  true,    "hq_ofc_cd",        false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,           60,    daCenter,  true,    "rhq_ofc_cd",       false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,           60,    daCenter,  true,    "inv_ofc_cd",       false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,           60,    daCenter,  true,    "cost_ofc_cd",      false,          "",       dfNone,       0,     true,       true);

                    InitDataProperty(0, cnt++, dtData,           80,    daCenter,  true,    "yd_cd",            false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,           50,    daCenter,  true,    "vndr_seq",         false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,          150,    daCenter,  true,    "vndr_lgl_eng_nm",  false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,          100,    daCenter,  true,    "inv_no",           false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,           50,    daCenter,  true,    "tml_inv_sts_cd",   false,          "",       dfNone,       0,     true,       true);
                    
                    InitDataProperty(0, cnt++, dtHidden,        50,     daCenter,  true,    "tml_inv_sts_cd_desc",  false,      "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,          100,    daCenter,  true,    "iss_dt",           false,          "",       dfDateYmd,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,          110,    daCenter,  true,    "locl_upd_dt",      false,          "",       dfDateYmd,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,           80,    daCenter,  true,    "vvd",              false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,           80,    daCenter,  true,    "lane_cd",          false,          "",       dfNone,       0,     true,       true);
                    
                    InitDataProperty(0, cnt++, dtData,           80,    daCenter,  true,    "atb_dt",           false,          "",       dfDateYmd,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,           70,    daCenter,  true,    "lgs_cost_cd",      false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,          150,    daCenter,  true,    "lgs_cost_abbr_nm", false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,           45,    daCenter,  true,    "curr_cd",          false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        70,    daCenter,  true,    "inv_amt",          false,          "",       dfFloat,      2,     true,       true);

                    InitDataProperty(0, cnt++, dtData,        70,    daCenter,  true,    "usd_amt",          false,          "",       dfFloat,      2,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_d2",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_d4",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_d5",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_d7",           false,          "",       dfInteger,    0,     true,       true);

                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_d8",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_d9",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_dw",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_dx",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_r2",           false,          "",       dfInteger,    0,     true,       true);

                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_r4",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_r5",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_r7",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_r8",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_r9",           false,          "",       dfInteger,    0,     true,       true);
                    
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_f2",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_f4",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_f5",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_o2",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_o4",           false,          "",       dfInteger,    0,     true,       true);
                    
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_o5",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_o7",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_s2",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_s4",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_t2",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_t4",           false,          "",       dfInteger,    0,     true,       true);
                    
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_a2",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_a4",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_a5",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_p2",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_p4",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_c2",           false,          "",       dfInteger,    0,     true,       true);
                    
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "vol_c4",           false,          "",       dfInteger,    0,     true,       true);                    
                    InitDataProperty(0, cnt++, dtData,        60,    daCenter,  true,    "vol_teu",          false,          "",       dfFloat,      2,     true,       true);                    
                    InitDataProperty(0, cnt++, dtData,        45,    daCenter,  true,    "vol_box",          false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        45,    daCenter,  true,    "vol_move",         false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        45,    daCenter,  true,    "over_days",        false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "ttl_20",           false,          "",       dfInteger,    0,     true,       true);
                    
                    InitDataProperty(0, cnt++, dtData,        40,    daCenter,  true,    "ttl_40",           false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        45,    daCenter,  true,    "ttl_teu",          false,          "",       dfFloat,      2,     true,       true);                    
                    InitDataProperty(0, cnt++, dtData,        45,    daCenter,  true,    "ttl_box",          false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,        110,   daRight ,  true,    "auto_calc_amt",    false,          "",       dfFloat,      2,     false,       false);
                    InitDataProperty(0, cnt++, dtData,        100,   daRight ,  true,    "semi_auto_amt",    false,          "",       dfFloat,      2,     false,       false);
                    InitDataProperty(0, cnt++, dtData,        100,   daRight ,  true,    "manual_amt",       false,          "",       dfFloat,      2,     false,       false);
                    
                    CountFormat = "[SELECTDATAROW / TOTALROWS]";
               }
                break;
        }
    }

 
  /**  
   * Sheet 액션값에 따라 조회 엑셀다운로드를 실행한다. 
   *  
   * @param(sheetObj) 	sheet object 시트오브젝트
   * @param(formObj) 	form 폼오브젝트 
   * @param(sAction) 	action value 
   */
    function doActionIBSheet(sheetObj,formObj,sAction, PageNo) {
        sheetObj.ShowDebugMsg = false;
		if ( PageNo == undefined || PageNo == "" || PageNo == 0 ) {
			PageNo = 1;
		} else {
			PageNo	 = parseInt(PageNo) + 1;
		}
		
		formObj.iPage.value = PageNo;
		
        switch(sAction) {

           case IBSEARCH:      //조회
                 formObj.f_cmd.value = SEARCH;
                 var searchXml = sheetObj.GetSearchXml("ESD_TES_0014GS.do", tesFrmQryStr(formObj), "iPage=" + PageNo);
                 sheetObj.LoadSearchXml4Sax(searchXml);
                 searchXml = null;
                break;

           case IBSEARCHAPPEND:	//more
				formObj.f_cmd.value = SEARCH;

				var searchXml = sheetObj.GetSearchXml("ESD_TES_0014GS.do", tesFrmQryStr(formObj), "iPage=" + PageNo);
				var arrXml = searchXml.split("|$$|"); 
				sheetObj.LoadSearchXml(arrXml[0], true);
				searchXml = null;
				arrXml = null;
        	   break;
        	   
           case IBDOWNEXCEL:        //엑셀 다운로드
                sheetObj.SpeedDown2Excel(-1);
                break;
        }
    }

    /**
     * Sheet 액션값에 따라 조회 엑셀다운로드를 실행한다.
     * 
     * @param(sheetObj) 	sheet object 시트오브젝트
     * @param(formObj) 		form 폼오브젝트 
     * @param(sAction) 		action value 
     */    
    function doActionIBSheet1(sheetObj,formObj,sAction, PageNo) {
        sheetObj.ShowDebugMsg = false;
        if ( PageNo == undefined || PageNo == "" || PageNo == 0 ) {
			PageNo = 1;
		} else {
			PageNo	 = parseInt(PageNo) + 1;
		}
        
		formObj.iPage.value = PageNo;
		
        switch(sAction) {

           case IBSEARCH:      //조회
                 formObj.f_cmd.value = SEARCH01;
                 var searchXml = sheetObj.GetSearchXml("ESD_TES_0014GS.do", tesFrmQryStr(formObj), "iPage=" + PageNo);
                 sheetObj.LoadSearchXml4Sax(searchXml);
                 searchXml = null;
                break;

           case IBSEARCHAPPEND:	//more
				formObj.f_cmd.value = SEARCH01;
				
				var searchXml = sheetObj.GetSearchXml("ESD_TES_0014GS.do", tesFrmQryStr(formObj), "iPage=" + PageNo);
				var arrXml = searchXml.split("|$$|"); 
				sheetObj.LoadSearchXml(arrXml[0], true);
				searchXml = null;
				arrXml = null;
        	   break;
        	   
           case IBDOWNEXCEL:        //엑셀 다운로드
                sheetObj.SpeedDown2Excel(-1);
                break;
        }
    }
     

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param(sheetObj) 	sheet object 시트오브젝트
     * @param(formObj) 		form 폼오브젝트 
     * @param(sAction) 		action value      
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!ComIsNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }

	/**
	 * Button More Page Check
	 */
	function checkPage(sheetObject, PageNo, OnePageRow) {
		if ( PageNo > (sheetObject.TotalRows / OnePageRow) ) {
			return false;
		}
		return true;
	}

    /**
     * 기간 체크 
     */
	function setPeriodFromTo(){
		/* from 한달전 ~ to 오늘 */
		var formObj = document.form;
		var to_dt = new String(formObj.DB_DATE.value).substring(0,8);
		var fr_dt;
		if (to_dt!=undefined && to_dt!=null && to_dt.trim()!='' && to_dt.length==8){
			//fr_dt = tes_getDiffDate(to_dt, -30, 'D');
			fr_dt = tes_getDiffDate(to_dt, -1, 'M') + to_dt.substring(6,8);
			if (fr_dt!=undefined && fr_dt!=null && fr_dt.trim()!='' && fr_dt.length==8){
				if (fr_dt.substring(6,8) > ComGetLastDay(parseInt(fr_dt.substring(0,4), 10),parseInt(fr_dt.substring(4,6), 10))){
					fr_dt = fr_dt.substring(0,6) + ComGetLastDay(parseInt(fr_dt.substring(0,4), 10),parseInt(fr_dt.substring(4,6), 10));
				}
				formObj.fm_prd_dt.value = fr_dt.substring(0,4)+'-'+fr_dt.substring(4,6)+'-'+fr_dt.substring(6,8);
				formObj.to_prd_dt.value = to_dt.substring(0,4)+'-'+to_dt.substring(4,6)+'-'+to_dt.substring(6,8);
			}
		}
	}

    /**
    *  프린트 함수
    */	
	function printInvoiceSummary(){
	    var fromObj  = new Array();
	    var rdObj    = new Array();
	    var paramObj = new Array();
	    fromObj[0] = document.form;
	    rdObj[0] = sheetObjects[0];
//	    RD_path = "http://localhost:7001/hanjin/";
	    //RD로 보내기 위한 설정
	    paramObj[0] = "1";
	    paramObj[1] = "";
	    paramObj[2] = "N";
	    paramObj[3] = RD_path+"apps/alps/esd/tes/serviceproviderinvoicemanage/marineterminalinvoicemanage/report/ESD_TES_801.mrd";
	    paramObj[4] = rdObj;
	    paramObj[5] = fromObj;
	    rdObjModaless(RdReport, paramObj, 1000, 700);
	}



	/**
	 * 사용자가 입력한 검색조건 날짜를 받아서 From Date가 To Date보다 크게 입력되었는지 확인한다.
	 */
	function chkPeriod(){
	    var formObj = document.form;
	    var is_valid=0;
	    var fromVal = formObj.fm_prd_dt.value;
	    var toVal = formObj.to_prd_dt.value;

	    is_valid = ComGetDaysBetween(fromVal, toVal);
	    if(is_valid<0){
	        formObj.to_prd_dt.value = '';
	        ComAlertFocus(formObj.fm_prd_dt, "From Date is Later than To Date");
	    }
	}

	/**
	 * 사용자가 VNDR Seq를 직접 입력할 경우 해당VNDR Name을 화면에 보여준다.
	 * @param(obj) object
	 */
	 function getVndrName(obj){
	     var formObj = document.form;
	     if(tes_getStrLen(obj.value) == 6){
	         if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim()==''){
	             formObj.vndr_seq_hidden.value = '';
	             formObj.is_valid_vndr_seq.value = '';
	             return false;
	         }
	         if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim()){
	             formObj.vndr_seq_hidden.value = '';
	             formObj.is_valid_vndr_seq.value = '';
	             tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
	         }
	     }
	 }

	/**
	 * vndr code 값 null,'' 체크
	 */	 
	 function checkValidVndrCode(){
		var formObj = document.form;
		var tmp = '';
//		ComShowMessage('is_valid_vndr_seq:'+formObj.is_valid_vndr_seq.value);
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
					//여기에 이름을 넣어주셔요
					formObj.vndr_seq_name.value	= (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					ComShowCodeMessage('TES21511'); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
					formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				ComShowCodeMessage('TES21511'); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
				formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			ComShowCodeMessage('TES21511'); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
			formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

		}
	}
	 
	/**
	 * yard code 가져 옮 
	 */	 
	 function getYard(rowArray) {
        //ComShowMessage("getYard");
    	var colArray = rowArray[0];

    	document.all.loc_cd.value = colArray[3].substr(0, 5);
    	node = colArray[3].substr(5, 2);
    	tes_getComboItem('nod_cd',1,SEARCHLIST04,'','loc_cd','setNodCode');
//    	document.all.nod_cd.Code = colArray[3].substr(5, 2);
    	//document.all.yd_cd_name.value = colArray[4];
     }

	/**
	 * nod code 가져 옮 
	 */	 	 
     function setNodCode(){
         document.all.nod_cd.Code = node;
         node = ''

     }

	/**
	 * vender code 가져 옮 
	 * @param(rowArray)  
	 */	 	 
     function getVender(rowArray) {
       // ComShowMessage("getVender");
    	var colArray = rowArray[0];
    	//document.all.vndr_seq.value = colArray[2].substr(2,6);
    	document.all.vndr_seq.value = colArray[6];
    	document.all.vndr_seq_name.value = colArray[4];
     }

	/**
	 * office code 가져 옮 
	 * @param(rowArray)  
	 */	 		 
     function getOffice(rowArray){
        //ComShowMessage("getOffice");
        var colArray = rowArray[0];
        document.all.cost_ofc_cd = colArray[3];
     }

	/**
	 * cost code 가져 옮 
	 * @param(rowArray)  
	 */	 	 
     function getCostOfc(rowArray) {

		var formObject = document.form;

		for(var i=0; i<rowArray.length; i++)
		{
			var colArray = rowArray[0];
			document.form.cost_ofc_cd.value = colArray[3];
		}

	 }
 
	/**
	 * invoice code 가져 옮 
	 * @param(rowArray)  
	 */	 
	 function getInvOfc(rowArray) {
		var formObject = document.form;

		for(var i=0; i<rowArray.length; i++)
		{
			var colArray = rowArray[0];
			document.form.inv_ofc_cd.value = colArray[3];
		}

	 }

	/**
	 * yard code 값 null, '' 체크
	 */	 	 
    function validateYardCode() {
        var formObj = document.form;
        if (formObj.yd_cd.value==null || formObj.yd_cd.value.trim() == ''){
            formObj.yd_cd_hidden.value = '';
            formObj.is_valid_yd_cd.value = '';
            return false;
        }
        if ((formObj.yd_cd_hidden.value==null || formObj.yd_cd_hidden.value.trim()=='') || formObj.yd_cd.value.trim()!=formObj.yd_cd_hidden.value.trim()){
            formObj.yd_cd_hidden.value = '';
            formObj.is_valid_yd_cd.value = '';
            tes_getInputValue('is_valid_yd_cd', SEARCH20, 'yd_cd', 'checkValidYardCode');
        }
    }

	/**
	 * yard code 유효성체크
	 */	 
	function checkValidYardCode(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_yd_cd.value!=undefined && formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value.trim()!=''){
			tmp = formObj.is_valid_yd_cd.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_yd_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value == 'Y'){
					formObj.yd_cd_hidden.value = formObj.yd_cd.value;

					formObj.yd_cd_deltflg.value = (tmp[9]!=undefined&&tmp[9]!=null?tmp[9]:'');

					if(formObj.yd_cd_deltflg.value=="Y"){
							ComShowMessage('Deleted Yard Code!');
					}

					//getInputValue('cost_ofc_cd', COMMAND01, 'yd_cd', 'setCostOfcReadOnlyFalse');
				} else {
					formObj.is_valid_yd_cd.value = '';
					formObj.yd_cd_hidden.value = '';
					formObj.yd_cd.value = '';
					ComShowCodeMessage('TES10066');
				}
			} else {
				formObj.is_valid_yd_cd.value = '';
				formObj.yd_cd_hidden.value = '';
				formObj.yd_cd.value = '';
				ComShowCodeMessage('TES10066');
			}
		} else {
			formObj.is_valid_yd_cd.value = '';
			formObj.yd_cd_hidden.value = '';
			formObj.yd_cd.value = '';
			ComShowCodeMessage('TES10066');
		}
	}


	/**
	 * vndr code null, '' 값 체크
	 */	 
	function validateVNDRCode() {
        var formObj = document.form;
        if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim() == ''){
            formObj.vndr_seq_hidden.value = '';
            formObj.is_valid_vndr_seq.value = '';
            return false;
        }

		if (formObj.vndr_seq.value.length < 6){
		    formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
		}

        if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim()){
            formObj.vndr_seq_hidden.value = '';
            formObj.is_valid_vndr_seq.value = '';
            tes_getInputValue('is_valid_vndr_seq', SEARCHLIST01, 'vndr_seq', 'checkValidVNDRCode');
        }
    }

	/**
	 * vndr code 값 유효성 체크
	 */	 
	function checkValidVNDRCode(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_name.value = (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;

					formObj.vndr_seq_deltflg.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');

					if(formObj.vndr_seq_deltflg.value=="Y"){
							ComShowMessage('Deleted S/P Code!');
					}
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					ComShowCodeMessage('TES10067');//msgs['TES10067'] = '유효하지 않은 VendorCode입니다.' ;
				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				formObj.vndr_seq.value = '';
				formObj.vndr_seq_name.value = '';
				ComShowCodeMessage('TES10067');
			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			formObj.vndr_seq.value = '';
			formObj.vndr_seq_name.value = '';
			ComShowCodeMessage('TES10067');
		}
	}


	
	/**
	 * invoice office code, office code 값 체크
	 * @param(inv_ofc_cd) invoice office code
	 */
	function checkValidOFC(inv_ofc_cd){
	    if(ofc_cd == ''){
	        ComShowMessage('No Inv OFC data is found in the session');
	        return false;
	    }
	    if(inv_ofc_cd == '' || inv_ofc_cd == null){
	        ComShowMessage("Inv OFC data does not exist at the selected invoice!");
	        return false;
	    }
	    if(ofc_cd != inv_ofc_cd){
	        ComShowMessage("No authority to correct/delete selected invoice - Invoice office mismatch!");
	        return false;
	    }
	    return true;
	}
	 
		/**
		 *  cost code 값 null, '' 체크 
		 *	@return
		 */	 	
		function validateCostOFCCode() {
	        var formObj = document.form;
	        if (formObj.cost_ofc_cd.value==null || formObj.cost_ofc_cd.value.trim() == ''){
	            formObj.cost_ofc_cd_hidden.value = '';
	            formObj.is_valid_cost_ofc_cd.value = '';
	            return false;
	        }
	        if ((formObj.cost_ofc_cd_hidden.value==null || formObj.cost_ofc_cd_hidden.value.trim()=='') || formObj.cost_ofc_cd.value.trim()!=formObj.cost_ofc_cd_hidden.value.trim()){
	            formObj.cost_ofc_cd_hidden.value = '';
	            formObj.is_valid_cost_ofc_cd.value = '';
	            tes_getInputValue('is_valid_cost_ofc_cd', SEARCHLIST02, 'cost_ofc_cd', 'checkValidCostOFCCode');
	        }
	    }

		/**
		 *  cost code 값 유효성 체크 
		 *	@return
		 */		
	    function checkValidCostOFCCode(){
			var formObj = document.form;
			var tmp = '';
			
			if (formObj.is_valid_cost_ofc_cd.value!=undefined && formObj.is_valid_cost_ofc_cd.value!=null && formObj.is_valid_cost_ofc_cd.value.trim()!=''){
				tmp = formObj.is_valid_cost_ofc_cd.value.split('|');
				if (tmp.length > 0){
					formObj.is_valid_cost_ofc_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
					if (formObj.is_valid_cost_ofc_cd.value!=null && formObj.is_valid_cost_ofc_cd.value == 'Y'){
						formObj.cost_ofc_cd_hidden.value = formObj.cost_ofc_cd.value;


						formObj.cost_ofc_cd_deltflg.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');

						if(formObj.cost_ofc_cd_deltflg.value=="Y"){
							ComShowMessage('Deleted Office Code!');
						}

					} else {
						formObj.is_valid_cost_ofc_cd.value = '';
						formObj.cost_ofc_cd_hidden.value = '';
						formObj.cost_ofc_cd.value = '';
						ComShowCodeMessage('TES40052', 'Cost Office Code');
					}
				} else {
					formObj.is_valid_cost_ofc_cd.value = '';
					formObj.cost_ofc_cd_hidden.value = '';
					formObj.cost_ofc_cd.value = '';
					ComShowCodeMessage('TES40052', 'Cost Office Code');
				}
			} else {
				formObj.is_valid_cost_ofc_cd.value = '';
				formObj.cost_ofc_cd_hidden.value = '';
				formObj.cost_ofc_cd.value = '';
				ComShowCodeMessage('TES40052', 'Cost Office Code');
			}
		}	 
	 

		/**
		 *  invoice office code 값 null, '' 체크 
		 *	@return
		 */	    
	    function validateInvOFCCode() {
	        var formObj = document.form;
	        if (formObj.inv_ofc_cd.value==null || formObj.inv_ofc_cd.value.trim() == ''){
	            formObj.inv_ofc_cd_hidden.value = '';
	            formObj.is_valid_inv_ofc_cd.value = '';
	            return false;
	        }
	        if ((formObj.inv_ofc_cd_hidden.value==null || formObj.inv_ofc_cd_hidden.value.trim()=='') || formObj.inv_ofc_cd.value.trim()!=formObj.inv_ofc_cd_hidden.value.trim()){
	            formObj.inv_ofc_cd_hidden.value = '';
	            formObj.is_valid_inv_ofc_cd.value = '';
	            tes_getInputValue('is_valid_inv_ofc_cd', SEARCHLIST03, 'inv_ofc_cd', 'checkValidInvOFCCode');
	        }
	    }

		/**
		 *  invoice office 값 유효성 체크 
		 *	@return
		 */	    
		function checkValidInvOFCCode(){
			var formObj = document.form;
			var tmp = '';
			if (formObj.is_valid_inv_ofc_cd.value!=undefined && formObj.is_valid_inv_ofc_cd.value!=null && formObj.is_valid_inv_ofc_cd.value.trim()!=''){
				tmp = formObj.is_valid_inv_ofc_cd.value.split('|');
				if (tmp.length > 0){
					formObj.is_valid_inv_ofc_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
					if (formObj.is_valid_inv_ofc_cd.value!=null && formObj.is_valid_inv_ofc_cd.value == 'Y'){
						formObj.inv_ofc_cd_hidden.value = formObj.inv_ofc_cd.value;

						formObj.inv_ofc_cd_deltflg.value = (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');

						if(formObj.inv_ofc_cd_deltflg.value=="Y"){
							ComShowMessage('Deleted Office Code!');
						}

					} else {
						formObj.is_valid_inv_ofc_cd.value = '';
						formObj.inv_ofc_cd_hidden.value = '';
						formObj.inv_ofc_cd.value = '';
						ComShowCodeMessage('TES40052', 'Invoice Office Code');
					}
				} else {
					formObj.is_valid_inv_ofc_cd.value = '';
					formObj.inv_ofc_cd_hidden.value = '';
					formObj.inv_ofc_cd.value = '';
					ComShowCodeMessage('TES40052', 'Invoice Office Code');
				}
			} else {
				formObj.is_valid_inv_ofc_cd.value = '';
				formObj.inv_ofc_cd_hidden.value = '';
				formObj.inv_ofc_cd.value = '';
				ComShowCodeMessage('TES40052', 'Invoice Office Code');
				
			}
		}
	
	 
	/**
	 * layer 1,2 를 숨기고 보여줌
	 * 
	 */
    function vol_show_mode_sts(){
	    var formObj = document.form;
	    // Volume Hide 부분
	    if(formObj.vol_show_mode[0].checked  == false){
	        document.all.SearchLayer1.style.display = "inline"
	        document.all.SearchLayer2.style.display = "none"
	        //disableManyObjects(formObj.cost_tp[0], formObj.cost_tp[1], formObj.cost_tp[2], formObj.cost_tp[3], formObj.cost_tp[4],
	        //                   formObj.cost_tp[5], formObj.cost_tp[6], formObj.cntr_tp[0], formObj.cntr_tp[1]);
	        ComEnableManyObjects(false, formObj.cost_tp[0], formObj.cost_tp[1], formObj.cost_tp[2], formObj.cost_tp[3], formObj.cost_tp[4],
                    			formObj.cost_tp[5], formObj.cost_tp[6], formObj.cntr_tp[0], formObj.cntr_tp[1]);

	    }else{
	        document.all.SearchLayer1.style.display = "none"
	        document.all.SearchLayer2.style.display = "inline"
	        //enableManyObjects(formObj.cost_tp[0], formObj.cost_tp[1], formObj.cost_tp[2], formObj.cost_tp[3], formObj.cost_tp[4],
	        //                   formObj.cost_tp[5], formObj.cost_tp[6], formObj.cntr_tp[0], formObj.cntr_tp[1]);
	        ComEnableManyObjects(true, formObj.cost_tp[0], formObj.cost_tp[1], formObj.cost_tp[2], formObj.cost_tp[3], formObj.cost_tp[4],
                    			 formObj.cost_tp[5], formObj.cost_tp[6], formObj.cntr_tp[0], formObj.cntr_tp[1]);
	    }
	    initCheckBox();
	}

	/**
	 * cost type 전체를 비활성화 하는 메소드 이다.  
	 */	 
	function cost_tpOnclick(){
	    document.form.cost_tp[0].checked = false;
		// Cost Type 선택시 활성화 여부.(2010-01-13)
	    ComEnableManyObjects(true, document.form.cntr_tp[0], document.form.cntr_tp[1]);
	}

	/**
	 * code combo 값을 가져온다.
	 *  @param(obj) object
	 */	 
	function getNodeCodeCombo(obj){
	    if(obj.value.length == "5"){
	        tes_getComboItem('nod_cd',1,SEARCHLIST04,'','loc_cd','');
	    }else{
	        return false;
	    }

	}
	
	/** 글입력시 max length 체크해서 false 리턴함
	 * @param {obj}  object
	 **/
	function chkInput(obj) {
	//	ComShowMessage('strleng: '+getStrLen(obj.value));
		if (obj.maxLength < getStrLen(obj.value))
		{
			obj.value = '';
			obj.focus();
			return false;
		}
	}
 
	/** 숫자인지 체크함
	 * @param {obj}  object
	 **/	
	function isNum(obj){
		//숫자만..
		if (!ComIsNumber(obj)){
			obj.value = '';
		}
	}
	 
	/** 숫자인지 체크함, 숫자값에 대시를 넣어준다
	 * @param {obj}  object
	 **/		 
	function isNum1(obj){
			//숫자만..
			if (!ComIsNumber(obj,"-")){
				obj.value = '';
			}
		}

	/** 영문과 숫자인지 체크함
	 * @param {obj}  object
	 **/	 
	function isApNum(obj){
		//영문과 숫자만..
		if (!ComIsAlphabet(obj, 'n')){
			obj.value = '';
		}
	}

	/** 영문인지 체크함
	 * @param {obj}  object
	 **/	 
    function isAlpha(obj) {
        if(!ComIsAlphabet(obj)) {
           obj.value = "";
        }

    }

	/** 한글 및 영문 길이 체크
	 * @param {src}  문자열
	 **/ 
	function getStrLen(src) {
		// 한글 및 영문 str의 길이를 구함
		src = new String(src);
		var byteLength = 0;
		for (var inx = 0; inx < src.length; inx++) {
			var oneChar = escape(src.charAt(inx));
			if (oneChar.length == 1) {
				byteLength ++;
			} else if (oneChar.indexOf("%u") != -1) {
				byteLength += 2;
			} else if (oneChar.indexOf("%") != -1) {
				byteLength += oneChar.length/3;
			}
		}
		return byteLength;
	}

	/**
	 * yard code 변경
	 * @return
	 */ 
	function nod_cd_OnChange(){
	    var formObj = document.form;
	    formObj.yd_cd.value = formObj.loc_cd.value + formObj.nod_cd.Code;
	}
	 
//	/**
//	 * 입력날짜의 Fr~To가 1년 이상이면 메시지 뜨도록 하는 함수 & Fr DT가 To DT보다 나중이면 메시지 뜨도록 하는 함수
//	 * @param {ojbect}	obj	object
//	 */
//    function validDate(obj){
//        var formObj = document.form;
//
//        if(formObj.fm_prd_dt != null && formObj.to_prd_dt != null && formObj.fm_prd_dt.value != '' && formObj.to_prd_dt.value != ''){
//        	if(ComGetDaysBetween(formObj.fm_prd_dt, formObj.to_prd_dt) > 365){
//                ComShowMessage('Invoice DT must inputted within 365 days.');
//	            tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
//	            formObject.vol_show_mode[0].checked  = true;
//	            vol_show_mode_sts();
//	            return false;
//            }
//        	if(ComGetDaysBetween(formObj.fm_prd_dt, formObj.to_prd_dt) < 0){
//                ComShowMessage('From date must be earlier than To date.'); 
//                tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
//                return false;
//            }
//        }
//    }

    /**
     * sheetObj의 소계와 누계를 계산하여 표시한다.
     * @param sheetObj
     * @return
     */
	function sheet1_OnSearchEnd(sheetObj){
		var cols = "inv_amt|vat_amt|whld_tax_amt|ttl_inv_amt|usd_amt";
		sheetObj.HideSubSum(cols);
		sheetObj.HideSubSum(1);
	    sheetObj.ShowSubSum("hq_ofc_cd", cols, true, true);
	}

	/**
	 *  sheetObj의 소계와 누계를 계산하여 표시한다. 
	 * @param sheetObj
	 * @return
	 */
	function sheet2_OnSearchEnd(sheetObj){
	    document.form.cost_code.value = "";
	    document.form.cntr_sty_code.value = "";
	    
	    var cols = "inv_amt|usd_amt|vol_d2|vol_d4|vol_d5|vol_d7|vol_d8|vol_d9|vol_dw|vol_dx|" +
				        "vol_r2|vol_r4|vol_r5|vol_r7|vol_r8|vol_r9|vol_f2|vol_f4|vol_f5|vol_o2|vol_o4|vol_o5|vol_o7|vol_s2|vol_s4|vol_t2|vol_t4" +
				        "|vol_a2|vol_a4|vol_a5|vol_p2|vol_p4|vol_c2|vol_c4|vol_teu|vol_box|vol_move|over_days|ttl_20|ttl_40|ttl_teu|ttl_box" +
				        "|auto_calc_amt|semi_auto_amt|manual_amt";
	    
	    sheetObj.HideSubSum(cols);
	    sheetObj.HideSubSum(1);
	    sheetObj.ShowSubSum("hq_ofc_cd", cols, true, true);
	
        for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
        	if (sheetObj.CellValue(i,'tml_inv_sts_cd')!=null && sheetObj.CellValue(i,'tml_inv_sts_cd')!='' && 
        			sheetObj.CellValue(i,'tml_inv_sts_cd_desc')!=null && sheetObj.CellValue(i,'tml_inv_sts_cd_desc')!=''){
        		sheetObj.ToolTipText(i,'tml_inv_sts_cd') = sheetObj.CellValue(i,'tml_inv_sts_cd_desc');
        	}
        }
	 
	 }

	/**
	 * 
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRow
	 */
	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRow) {
		var formObject	= document.form;
		doActionIBSheet(sheetObj, formObject, IBSEARCHAPPEND, formObject.iPage.value);
	}

	/**
	 * 
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRow
	 */
	function sheet2_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRow) {
		var formObject	= document.form;
		doActionIBSheet1(sheetObj, formObject, IBSEARCHAPPEND, formObject.iPage.value);
	}
	
	function getSubOffice1(){
    	if(document.form.sub_office1.checked == true){
    		if(document.form.cost_ofc_cd.value != ''){
    			document.form.ofc_cd.value = document.form.cost_ofc_cd.value;
    			tes_getInputValue('sub_ofc_cd1', SEARCHLIST15, 'ofc_cd', 'setSubOffice1');
    		} else {
    			ComShowMessage('Please enter Cost Office.');
				document.form.sub_office1.checked = false;
    		}
    	} else {
    		document.form.sub_ofc_cd1.value = '';
    		document.form.cost_ofc_cd.value = '';
    	} 
    }
    
    function setSubOffice1(){
    	if(document.form.sub_ofc_cd1.value != ''){
    		document.form.cost_ofc_cd.value = document.form.sub_ofc_cd1.value;
    	}
    }
    	
    function getSubOffice2(){
		if(document.form.sub_office2.checked == true){
			if(document.form.inv_ofc_cd.value != ''){
				document.form.ofc_cd.value = document.form.inv_ofc_cd.value;
				tes_getInputValue('sub_ofc_cd2', SEARCHLIST15, 'ofc_cd', 'setSubOffice2');
			} else {
				ComShowMessage('Please enter Invoice Office.');
				document.form.sub_office2.checked = false;
			}
		} else {
			document.form.sub_ofc_cd2.value = '';
			document.form.inv_ofc_cd.value = '';
		}  	
    }
    
    function setSubOffice2(){
    	if(document.form.sub_ofc_cd2.value != ''){
    		document.form.inv_ofc_cd.value = document.form.sub_ofc_cd2.value;
    	}
    }