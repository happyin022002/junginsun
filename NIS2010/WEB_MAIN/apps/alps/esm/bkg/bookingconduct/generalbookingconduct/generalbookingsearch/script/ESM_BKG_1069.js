
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
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

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

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

                    // 높이 설정
                    style.height = 146;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "Seq.|POL|POL|POD|POD|VVD|Lane|POL ETD|POL ETD|POD ETA|POD ETA";


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

					InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,     "vsl_pre_pst_cd",     false,          "",      dfNone,      0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,      62,    daCenter,  false,     "pol_cd",     false,          "",      dfNone,      0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "pol_yd_cd",     false,          "",      dfNone,      0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,      62,    daCenter,  false,     "pod_cd",     false,          "",      dfNone,      0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "pod_yd_cd",     false,          "",      dfNone,      0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,     "vvd",     false,          "",      dfNone,      0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,     "slan_cd",     false,          "",      dfNone,      0,     false,       true);
								
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,     "vps_etd_dt_date",     false,          "",      dfNone,      0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,     "vps_etd_dt_time",     false,          "",      dfNone,      0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,     70,    daCenter,  false,     "vps_eta_dt_date",     false,          "",      dfNone,      0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,     "vps_eta_dt_time",     false,          "",      dfNone,      0,     false,       true);
								
								
					ScrollBar = 2;
					ShowButtonImage = 2;
					CountPosition = 0;										
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

                	 formObj.f_cmd.value = SEARCH;              	
              	
					 var resultXml = sheetObj.GetSearchXml("ESM_BKG_1069GS.do", FormQueryString(formObj));					 
					 var arrXml = resultXml.split("|$$|"); 	
					 
					 var etcXml = arrXml[0];
					 
					 var org_trns_mod_cd = ComGetEtcData(etcXml, "org_trns_mod_cd");
					 var dest_trns_mod_cd = ComGetEtcData(etcXml, "dest_trns_mod_cd");
					 
					 if(org_trns_mod_cd == ""){
						 org_trns_mod_cd = "N";
					 }
					 
					 if(dest_trns_mod_cd == ""){
						 dest_trns_mod_cd = "N";
					 }					 
					 
					 BkgEtcDataXmlToForm(etcXml, formObj);
					 
					 document.getElementById("vps_eta_dt_date").value = ComGetEtcData(etcXml, "vps_eta_dt_date");
					 document.getElementById("vps_eta_dt_time").value = ComGetEtcData(etcXml, "vps_eta_dt_time");
					 document.getElementById("por_cd").value = ComGetEtcData(etcXml, "por_cd");
					 document.getElementById("por_nod_cd").value = ComGetEtcData(etcXml, "por_nod_cd");
					 document.getElementById("pol_cd").value = ComGetEtcData(etcXml, "pol_cd");
					 document.getElementById("pol_nod_cd").value = ComGetEtcData(etcXml, "pol_nod_cd");
					 document.getElementById("pod_cd").value = ComGetEtcData(etcXml, "pod_cd");
					 document.getElementById("pod_nod_cd").value = ComGetEtcData(etcXml, "pod_nod_cd");
					 document.getElementById("del_cd").value = ComGetEtcData(etcXml, "del_cd");
					 document.getElementById("del_nod_cd").value = ComGetEtcData(etcXml, "del_nod_cd");
					 document.getElementById("org_trns_mod_cd").value = org_trns_mod_cd;
					 document.getElementById("dest_trns_mod_cd").value = dest_trns_mod_cd;
										
					 sheetObjects[0].LoadSearchXml(arrXml[0], false);				 

                break;

			 
        }
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
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {

                    var cnt  = 0 ;
 //                   InsertTab( cnt++ , "Hire" , -1 );

                }
             break;

         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {


        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
		

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



	function sheet1_OnPopupClick( sheetObj, Row,Col )
	{
		alert("팝업클릭");
	}




/*


	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		sheetObj.ShowSubSum("a", "a", 0 , true, false, 3, "0=;1=;2=;");

		var sRow = sheetObj.FindSubSumRow("a");
		var arrRow = sRow.split("|");

		for(idx =0; idx < arrRow.length-1 ; idx++)
		{
			if(sheetObj.CellValue(parseInt(arrRow[idx])+1, "a") =="A" )
			{
				sheetObj.CellValue2(arrRow[idx],"d") = "▶ Auto Calculated Cost";
			}else if(sheetObj.CellValue(parseInt(arrRow[idx])+1, "a") =="M" )
			{
				sheetObj.CellValue2(arrRow[idx],"d") = "▶ Manual Input Cost";
			}
		}
	}

	*/