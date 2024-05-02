
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab1 = 1;
var beforetab2 = 1

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];

		/*******************************************************/
		var formObject = document.form;
		try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {


                case "btn_close":
//					alert(srcName);
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;	
    }

	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
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

            doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }

		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
//        var formObj = document.form;
//        var sXml = formObj.sXml.value; 
//        alert(sXml);
//        sheetObjects[0].ShowDebugMsg = true;
       // sheetObjects[0].LoadSearchXml(sXml);
//        var arrXml = sXml.split("|$$|");   
//        for(var i = 0; i < arrXml.length; i++){  
////       	 sheetObjects[i].ShowDebugMsg = true;
//                sheetObjects[i].Redraw = false;       
//                if(i > 0) {   
//                sheetObjects[i].WaitImageVisible = false;     
//                }     
//                sheetObjects[i].LoadSearchXml(arrXml[i]);   
//                sheetObjects[i].Redraw = true;   
//        }  
		
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
					style.height = 300;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);
						       

					var HeadTitle1 = "Constraint|Point|Node/Link|Mode|Arrival|Departure|Transit|Carrier||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"cnst",			false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"loc",			false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,		130,		daCenter,	true,		"node_link",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"trsp_mod_cd",			false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,		"arr_time",			false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,		"dep_time",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,		"fmt_tz_dwll_tm",			false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,	true,		"vvd",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		130,		daCenter,	true,		"org_nod_nm",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		130,		daCenter,	true,		"dest_nod_nm",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		130,		daCenter,	true,		"nod_nm_tool_tip",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		130,		daCenter,	true,		"rout_rmk",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		130,		daCenter,	true,		"nod_rmk",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		130,		daCenter,	true,		"lnk_rmk",			false,		"",				dfNone,		0,			true,		true);
	
					CountPosition = 0;
					
					WaitImageVisible=false;
               }
                break;
			
        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction))
					formObj.f_cmd.value = SEARCHLIST;
					if(sheetObj.id == "sheet1")sheetObj.DoSearch("ESD_PRD_0081GS.do?pctl_no="+formObj.pctl_no.value+ "&pop_mode=1&display=1,0,1,1,1&func=", PrdFQString(formObj));  
			break;

        }
    }

    function  sheet1_OnMouseMove(SheetObj,Button, Shift, X, Y){
    	Row = SheetObj.MouseRow;
        Col = SheetObj.MouseCol;
        org_txt = SheetObj.CellText(Row,"org_nod_nm");
        dest_txt = SheetObj.CellText(Row,"dest_nod_nm");
        tooltip_txt ='';
        if(dest_txt.length > 0) {
        	tooltip_txt = org_txt+' -> '+dest_txt;
        }else {
        	tooltip_txt = org_txt;
        }
         
        if(Col=="node_link"){
        	alert(tooltip_txt);
        }
        tooltip_txt = SheetObj.CellText(Row,"nod_nm_tool_tip");
        if(SheetObj.MouseRow > 0 && SheetObj.MouseCol == 2){
        	SheetObj.MouseToolTipText = tooltip_txt;
        }
        var cnst_rmk ='';
        cnst_rmk = SheetObj.CellText(Row,"rout_rmk")+
        		   SheetObj.CellText(Row,"nod_rmk")+
        		   SheetObj.CellText(Row,"lnk_rmk");
        if(SheetObj.MouseRow > 0 && SheetObj.MouseCol == 0){
        	SheetObj.MouseToolTipText = cnst_rmk;
        }        
//        SheetObj.MouseToolTipText = tooltip_txt
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }

	
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	*/
	function tab2_OnChange(tabObj , nItem){

		var objs = document.all.item("tabLayer2");

			objs[nItem].style.display = "Inline";
			objs[beforetab2].style.display = "none";

			//--------------- 요기가 중요 --------------------------//
			objs[beforetab2].style.zIndex = objs[nItem].style.zIndex -1 ;
			//------------------------------------------------------//
			beforetab2= nItem;
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		sheetObj.ColFontColor("cnst") = sheetObj.RgbColor(0,0,255);
	   	 for(i = parseInt(sheetObj.HeaderRows) ; i<= parseInt(sheetObj.HeaderRows)+sheetObj.RowCount ; i++){
				if(sheetObj.CellValue(i,'rout_rmk')!=''){
					sheetObj.CellValue2(i,'cnst') ='YES';
					
				} 
			}

	
	}
