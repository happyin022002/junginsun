/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0036.js
*@FileTitle : 항로 생성/조회/변경
*Open Issues :
*Change history :
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.10.23 김기대 New FrameWork 적용
* 2009.12.23 최인경 IBSHEET컬럼 2개 추가
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이행지 FormQueryString =>coaFormQueryString 변경
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.06.17 이행지 Lane History PopUP창 가로 사이즈 조정 (700->900)
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2011.09.15 최성민 [CHM-201113373-01] AES Trade VSL Pool노선의 OP1 및 OP4 산출 로직 변경
* 2012.06.08 이석준 [CHM-201218114-01] 삭제된 데이터를 원복할 수 있도록 기능 변경
* 2012.09.17 이석준[CHM-201220161] 실시간 영업현황 관련 UI- Create Lane Table 기능 추가
* 2013.10.17 박찬민 [CHM-201327089] [COA] Trade Dir. 당팀 직접 수정 가능하게 변경
* 2015.08.31 손진환 [CHM-201536992] Split14-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
*/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_COA_0036 : ESM_COA_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0036() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.sheet1_OnSearchEnd = sheet1_OnSearchEnd ;
    this.sheet1_OnChange    = sheet1_OnChange    ;
    this.sheet1_OnDblClick  = sheet1_OnDblClick  ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.retrieve           = retrieve           ;
    this.validateForm       = validateForm       ;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet_height = 20; // sheet의 height
var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_Retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_Downexcel":
    	            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;

        	    case "btn_Save":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

        	    case "btn_Rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;

    			case "bu_zoom_in":
    				sheet_height = getSheetHeightCnt(sheetObject,"MAX",1);
    				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "none";
    				div_zoom_out.style.display = "inline";
    				if (parent && parent.syncHeight) {
    					parent.syncHeight();
    				}
    				break;
    
    			case "bu_zoom_out":
    				sheet_height = getSheetHeightCnt(sheetObject,"MIN",0);
    				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "inline";
    				div_zoom_out.style.display = "none";
    				if (parent && parent.syncHeight) {
    			    	parent.syncHeight();
    			    }
    				break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg("COM12111", "", ""));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		loadingMode = true;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode = false;
        btn_Retrieve.focus();
    }

    /**
     * IBCOMBO를 초기화하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo의 순번
     * @return 없음
     * @author 최성민
     * @version 2011.09.15
 	*/
 	function initCombo(comboObj, comboId) {
 		switch(comboObj.id) {
 	     	case "f_cbotrade":
 	     		with(comboObj) {
 	     			DropHeight = 300;
 	     			MultiSelect = false;
 	     			MaxSelect = 1;
 	     			MaxLength = 3;
 	     			UseAutoComplete = false;
 	     			ValidChar(2, 1);	//영문대문자+숫자
 	     			Index = 0;
 	     		}
 	     		break;
 	     	case "f_cboslane":
 	     		with(comboObj) {
 	     			DropHeight = 300;
 	     			MultiSelect = false;
 	     			MaxSelect = 1;
 	     			MaxLength = 3;
 	     			UseAutoComplete = false;
 	     			ValidChar(2, 1);	//영문대문자+숫자
 	     			Index = 0;
 	     		}
 	     		break;
 	     }
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
					
					SheetWidth = mainTable.clientWidth;														//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);	//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msNone;																	//전체Merge 종류 [선택, Default msNone]
					Editable = true;																		//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo(1 , 1, 9, 100);																//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(26, 3, 0, true);															//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false);										// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle  = "Del.|STS|Trade|Sub Trade|S.Lane|R.Lane|Bound|Trade Dir.|IAS Region|IOC|Lane T/P|Lane T/P2|Lane T/P3(SNT)|Step Up/Down|Sector Price|T/P|Eur.|T/A|Intra Asia/\nIntra Europe|Trunk IPC|BSA to Load|Reverse Bound|Market Rate|Sub Desc|History\nFlag|Del Mark";
					var AuthControl = false;
					if(document.form.f_usr_ofc_cd.value=="SELCSG"){
						AuthControl = true;
					}
					InitHeadRow(0, HeadTitle, false);														//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,	30,		daCenter,	false,		"");
					InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++ , dtCombo,	60,		daCenter,	true,		"trd_cd",			true,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtCombo,	80,		daCenter,	true,		"sub_trd_cd",		true,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"slan_cd",			true,		"",		dfEngUpKey,	0,		true,		true,  3, true);
					                                           		         	     		   		      		   		       		  		     		
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"rlane_cd",			true,		"",		dfEngUpKey,	0,		false,		true,  5, true);
					InitDataProperty(0, cnt++ , dtCombo,	60,		daCenter,	true,		"dir_cd",	        true,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtCombo,	80,		daCenter,	true,		"hul_bnd_cd",	    true,		"",		dfNone,		0,		AuthControl,		true);
					InitDataProperty(0, cnt++ , dtComboEdit,90,		daCenter,	true,		"ias_rgn_cd",	    false,		"",		dfNone,		0,		false,		false, 2);
					InitDataProperty(0, cnt++ , dtCombo,	60,		daCenter,	true,		"ioc_cd",			true,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtCombo,	60,		daCenter,	true,		"vsl_lane_tp_cd",	false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtCombo,	100,	daCenter,	true,		"op_lane_tp_cd",	false,		"",		dfNone,		0,		true,		true);//추가(2009.09.07)==>Vessel Pool,표준단가,기타구분 인식자표시위해
					InitDataProperty(0, cnt++ , dtCheckBox,	100,	daCenter,	true,		"pctl_lane_chk_flg",false,		"",		dfNone,		0,		true,		true);//추가(snt flag)=>2009.12.15
					InitDataProperty(0, cnt++ , dtCheckBox,	90,		daCenter,	true,		"stup_flg",			false,		"",		dfNone,		0,		true,		true);
					                                           		         	     		   		      		   		       		  		     		
					InitDataProperty(0, cnt++ , dtCheckBox,	80,		daCenter,	true,		"sctr_prc_flg",		false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"trns_pcf_flg",		false,		"",		dfEngUpKey,	0,		true,		true, 1, true);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"eur_flg",			false,		"",		dfEngUpKey,	0,		true,		true, 1, true);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"trns_atlan_flg",	false,		"",		dfEngUpKey,	0,		true,		true, 1, true);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"intr_asia_flg",	false,		"",		dfEngUpKey,	0,		true,		true, 1, true);
					                                           		         	     		   		      		   		       		  		     		
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"trnk_ipt_flg",		false,		"",		dfEngUpKey,	0,		true,		true, 1, true);
					InitDataProperty(0, cnt++ , dtCheckBox,	80,		daCenter,	true,		"lod_spl_cng_flg",	false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtCheckBox,	100,	daCenter,	true,	    "rvs_bnd_flg",	    false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtCheckBox,	80,		daCenter,	true,		"mkt_rt_flg",	    false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		150,	daLeft,	    true,		"sub_trd_desc",		false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	    70,		daCenter,	true,		"lane_tp_his_flg",	false,		"",		dfNone,	    0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"delt_flg",			false,		"",		dfEngUpKey,	0,		false,		false);
					
					CountPosition  = 0 ;
					style.height = GetSheetHeight(sheet_height) ;

                    InitDataValid(0, "trns_pcf_flg", vtCharOnly, "YN");
                    InitDataValid(0, "eur_flg", vtCharOnly, "YN");
                    InitDataValid(0, "trns_atlan_flg", vtCharOnly, "YN");
                    InitDataValid(0, "intr_asia_flg", vtCharOnly, "YN");
                    InitDataValid(0, "trnk_ipt_flg", vtCharOnly, "YN");
                    InitDataValid(0, "delt_flg", vtCharOnly, "YN");
                    InitDataValid(0, "ias_rgn_cd", vtEngUpOnly);
					
               }
                break;

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

    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        var formObj = document.form;
        for(l=0; l<sheetObj.LastRow+1 ; l++){
        	if(sheetObj.CellValue(l,"trd_cd")=="IAS"){
        		sheetObj.CellEditable(l,"ias_rgn_cd")=true;
        	}
        }
        	
//        if(formObj.f_chkdel.checked){
//            sheetObj.ColHidden(0) = true;
//        }else{
//            sheetObj.ColHidden(0) = false;
//        }
        
    }
    
    // trade code가 변경되었을때 sub trade combo를 변경시킨다.
    function sheet1_OnChange(sheetObj, row, col, value){
        var formObj = document.form;
        if ("trd_cd"==sheetObj.ColSaveName(col)) {
            doActionIBSheet(sheetObj,formObj,IBROWSEARCH);
            if(sheetObj.CellValue(row,"trd_cd")=="IAS"){
            	sheetObj.CellEditable(row,"ias_rgn_cd")=true;
            }else{
            	sheetObj.CellValue(row,"ias_rgn_cd")="";
            	sheetObj.CellEditable(row,"ias_rgn_cd")=false;
            }
        }
    }
    
     /**
      * 더블클릭시 Lane History관리하는 화면이 열린다.
      */
     function sheet1_OnDblClick(sheetObj, row, col, value){
         var param = "?";
         param = param + "f_trd_cd=" + sheetObj.CellValue(row, "trd_cd");
         param = param + "&f_rlane_cd=" + sheetObj.CellValue(row, "rlane_cd");
         param = param + "&f_dir_cd=" + sheetObj.CellValue(row, "dir_cd");
         param = param + "&f_ioc_cd=" + sheetObj.CellValue(row, "ioc_cd");
         ComOpenWindow2('ESM_COA_0145.do'+param,'', 'width=900,height=400,menubar=0,status=0,scrollbars=0,resizable=0');
    }

	/**
	 * Sheet관련 프로세스 처리
	 */ 
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
	
		switch(sAction) {
		
			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				
				var sXml = sheetObj.GetSearchXml("ESM_COA_0036GS3.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_cbotrade, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_cboslane, "code", "name");
				if (arrXml.length > 2)
					ComCoaSetIBCombo(sheetObj, arrXml[2], "trd_cd", true, 0);
				if (arrXml.length > 3)
					ComCoaSetIBCombo(sheetObj, arrXml[3], "sub_trd_cd", true, 0);
				if (arrXml.length > 4)
					ComCoaSetIBCombo(sheetObj, arrXml[4], "vsl_lane_tp_cd", true, 0);
				if (arrXml.length > 5)
					ComCoaSetIBCombo(sheetObj, arrXml[5], "dir_cd", true, 0);
				if (arrXml.length > 6)
					ComCoaSetIBCombo(sheetObj, arrXml[6], "ioc_cd", true, 0);
				if (arrXml.length > 7) {
					// 2011.09.15 Lane T/P2 콤보코드 변경
					var arrData = ComXml2ComboString(arrXml[7], "code", "name");
					if (arrData != null && arrData.length > 0) {
						var sCode = "LA|OT|" + arrData[0];
						var sName = "Lane Avg U/C|Other(OP1)|" + arrData[1];
						
						sheetObj.InitDataCombo(0,"op_lane_tp_cd", sName, sCode,"", "OT", 0, "", "");
					}
				}
				if (arrXml.length > 8)
					ComCoaSetIBCombo(sheetObj, arrXml[8], "hul_bnd_cd", true, 0);
				if (arrXml.length > 9)
					ComCoaSetIBCombo(sheetObj, arrXml[9], "ias_rgn_cd", true, 0);
				

				ComOpenWait(false);
				break;	

			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST01;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0036GS.do", coaFormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
				
				//sheetObj.DoSearch4Post("ESM_COA_0036GS.do", coaFormQueryString(formObj));
				ComOpenWait(false);
				break;
				
			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// T/P, Eur., T/A, Intra Asia, Trunk IPC중 하나만 입력할수 있다
				// 다중입력시 에러 메시지를 출력한다.
				//-------------------------------------------------------------------------------
				var findData = sheetObj.FindStatusRow("I|U");
				var arRow = findData.split(";");
				var cnt = 0;
				if(arRow.length > 1){
    				for(j=0; j<arRow.length ; j++){
    				    if(arRow[j] != ""){
        				    if(sheetObj.CellValue(arRow[j], "trns_pcf_flg") == "Y") cnt++;
        				    if(sheetObj.CellValue(arRow[j], "eur_flg") == "Y") cnt++;
        				    if(sheetObj.CellValue(arRow[j], "trns_atlan_flg") == "Y") cnt++;
        				    if(sheetObj.CellValue(arRow[j], "intr_asia_flg") == "Y") cnt++;
        				    if(sheetObj.CellValue(arRow[j], "trnk_ipt_flg") == "Y") cnt++;
        				  
            				if(cnt>1){
            				    // [COA10026] : T/P, Eur., T/A, Intra Asia, Trunk IPC 중 하나만 입력하세요.
            				    ComShowMessage(ComGetMsg("COA10026", "T/P, Eur., T/A, Intra Asia, Trunk IPC "));
            				    sheetObj.SelectCell(arRow[j], "trns_pcf_flg");
            				    return false;
            				}
            				cnt = 0;
	            			if(sheetObj.CellValue(arRow[j], "trd_cd") == "IAS" && sheetObj.CellValue(arRow[j], "ias_rgn_cd") == ""){
	            				ComShowMessage(ComGetMsg("COA10068", "IAS Region"));
	            				return false;
	            			}
    				    }
    				}
				}
				//-------------------------------------------------------------------------------
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("ESM_COA_0036GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);
				
				ComOpenWait(false);
				break;

			case IBROWSEARCH:
			    formObj.f_cmd.value = MULTI02;
			    sheetObj.DoRowSearch("ESM_COA_0036GS2.do?sRow=" +sheetObj.SelectRow+ "&trade=" +sheetObj.CellValue(sheetObj.SelectRow, "trd_cd") , coaFormQueryString(formObj,'f_cmd',true));
			    break;
			
			case IBINSERT:      // 입력
			    //sheetObj.DataCopy(); //행복사
				sheetObj.DataInsert(-1); // 마지막행에 행삽입
				sheetObj.CellValue2(sheetObj.LastRow, "delt_flg") = "N";
				sheetObj.CellValue2(sheetObj.LastRow, "stup_flg") = "0";
				break;
			
			case IBDOWNEXCEL:        //엑셀 다운로드
				//sheetObj.SpeedDown2Excel(-1);
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }               
				break;

		
		}
	}

    /**
     * LANE HISTORY[ESM_COA_145] 팝업 화면이 닫히면서 콜하는 메소드
     * 
     */
    function retrieve(){
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){

        }
        return true;
    }
    
	/**
	* 저장메세지 지정
	*/
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		var formObj = document.form;
		if(errMsg == ""){
			ComShowMessage(ComGetMsg("COA10006"));
			
			formObj.f_cmd.value = INIT;
			formObj.f_strlane.value = "Y";// service lane combo만 다리 refresh
			
			var sXml = sheetObj.GetSearchXml("ESM_COA_0036GS3.do", coaFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
				ComXml2ComboItem(arrXml[0], formObj.f_cboslane, "code", "name")		
			formObj.f_cboslane.Index = 0;
		}
	}
