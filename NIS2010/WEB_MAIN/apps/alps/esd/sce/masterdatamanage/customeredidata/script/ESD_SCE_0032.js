
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var isSearch = false;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject = sheetObjects[0];
		 var sheetObject1 = sheetObjects[1];
		 /*******************************************************/
		 var formObject = document.form;

		 try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet1(sheetObject,formObject,IBSEARCH);
					doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_new":
					sheetObject.removeAll();
					sheetObject1.removeAll();
					
					formObject.grp_nm.value = '';
					formObject.cs_grp_id.value = '';
					
					formObject.cs_nm.value = '';
					formObject.cs_cd.value = '';
					
					formObject.cs_tp_id.value = '';
					formObject.hj_tp_id.value = '';
					
					formObject.sc_no.value = '';
					break;
				case "btn_downexcel":
				    if(beforetab == 0){
					   sheetObject.Down2Excel();
				    }
				    else if(beforetab == 1){
                        sheetObject1.Down2Excel();
				    }
				    else{
				        sheetObject.Down2Excel();
				        sheetObject1.Down2Excel(-1,true);
				        
				    }
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

					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 5, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 3, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					var HeadTitle = "SEQ|EDI Customer\nGroup Code|EDI Customer\nGroup Name|Customer\nTP ID|Hanjin\nTP ID|Customer\nCode|Customer Name|S/C No.|S/C Effective\nFrom|S/C Effective\nTo";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					/*InitDataProperty(0, cnt++ , dtData,       30,   daCenter,  true,    "",     false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      110,   daCenter,  true,    "",     false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      150,   daCenter,  true,    "",     false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      110,   daCenter,  true,    "",     false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      110,   daCenter,  true,    "",     false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      110,   daCenter,  true,    "",     false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,     300,   daLeft,    true,    "",     false,          "",      dfNone,      0,         true,       true,          30);
					//InitDataProperty(0, cnt++ , dtData,     130,   daCenter,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      70,   daCenter,  true,    "",     false,          "",      dfNone,      0,         true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      90,   daCenter,  true,    "",     false,          "",      dfNone,      0,         true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,    "",     false,          "",      dfNone,      0,         true,       true,          30);

					*/
					
					//ImageList(0) = "/hanjin/img/enis/button/btns_calendar.gif";
					//PopupButtonImage(0, 5) = 0;
					//PopupButtonImage(0, 6) = 0;

					//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
					//InitDataCombo (0,"co1", "All|Shipper|Consignee|Forwarder|Notify|EDI Reference", "All|Shipper|Consignee|Forwarder|Notify|EDI Reference");
					var prefix="sheet1_";
					//InitDataProperty(0, cnt++ , dtHiddenStatus,30,daCenter,false,prefix +"ibflag");
					//InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix +"ibflag",		     false,	         "",      dfNone,	   0,		 true,		 true,          30);
					InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,    prefix +"rownum",           false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      110,   daCenter,  true,    prefix +"edi_grp_cd",       false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      150,   daLeft,  true,    prefix +"edi_grp_desc",     false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      110,   daCenter,  true,    prefix +"cust_trd_prnr_id", false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      110,   daCenter,  true,    prefix +"prov_trd_prnr_id", false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      110,   daCenter,  true,    prefix +"cust_id",          false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      300,   daLeft,    true,    prefix +"cust_lgl_eng_nm",  false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,    prefix +"sc_no",            false,          "",      dfNone,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      90,    daCenter,  true,    prefix +"sc_eff_st_dt",     false,          "",      dfDateYmd,      0,        true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    prefix +"sc_eff_end_dt",    false,          "",      dfDateYmd,      0,        true,       true,          30);
					// 높이 설정
					style.height = GetSheetHeight(13) ;

			   }
				break;
			case 2:     //sheet2 init
				with (sheetObj) {

					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 5, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(15, 3, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					var HeadTitle = "Seq.|EDI Customer\nGroup Code|EDI Customer\nGroup Name|Customer\nTP ID|Hanjin\nTP ID|Stadard EDI\nStatus Code|Status\nDescription| Sending Flag|Origin|Destination|Vessel|Event\nSequence|Interval\nHour|CNTR\nSending\nType|Customer\nEDI Status Code";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					/*
					InitDataProperty(0, cnt++ , dtData,       30,   daCenter,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      90,   daCenter,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      90,   daCenter,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      70,   daCenter,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      90,   daCenter,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      300,   daLeft,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,     90,   daCenter,  true,    "co1",     false ,          "",      dfNone,      0,     true,       true,          30);
					
					InitDataProperty(0, cnt++ , dtHidden,     90,   daCenter,  true,    "co2",     false ,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtHidden,     90,   daCenter,  true,    "co3",     false ,          "",      dfNone,      0,     true,       true,          30);
					
					InitDataProperty(0, cnt++ , dtData,     80,   daCenter,  true,    "co4",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,     80,   daCenter,  true,    "co5",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      90,   daCenter,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      70,   daCenter,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
                    */
					var prefix="sheet2_";
					InitDataProperty(0, cnt++ , dtData,      30,   daCenter,  true,    prefix +"rownum",               false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      90,   daCenter,  true,    prefix +"edi_grp_cd",           false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      90,   daCenter,  true,    prefix +"edi_grp_desc",         false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      70,   daCenter,  true,    prefix +"cust_trd_prnr_id",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      90,   daCenter,  true,    prefix +"prov_trd_prnr_id",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  true,    prefix +"edi_stnd_sts_cd",      false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      300,  daLeft,    true,    prefix +"edi_sts_desc",         false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      90,   daCenter,  true,    prefix +"edi_snd_flg",          false ,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtHidden,    90,   daCenter,  true,    prefix +"edi_org_tp_cd",        false ,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtHidden,    90,   daCenter,  true,    prefix +"edi_dest_tp_cd",       false ,          "",      dfNone,      0,     true,       true,          30);					
					InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  true,    prefix +"edi_vsl_tp_cd",        false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  true,    prefix +"edi_evnt_cd",          false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      90,   daCenter,  true,    prefix +"EDI_SND_ITVAL_HRMNT",  false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      70,   daCenter,  true,    prefix +"EDI_CNTR_SND_TP_CD",   false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  true,    prefix +"cust_edi_sts_cd",      false,          "",      dfNone,      0,     true,       true,          30);					
					
					//InitDataCombo(0, "co1", "Yes|No", "Yes|No");
					var ComboText1 = "America|Asia|Europe|America+Asia|America+Europe|Asia+Europe|All";
					//InitDataCombo(0, "co2", ComboText1, ComboText1);
					//InitDataCombo(0, "co3", "All","All");
					//InitDataCombo(0, "co4","All|Trunk|Not Trunk","All|Trunk|Not Trunk");
					//InitDataCombo(0, "co5","All|First|Not first|Last|Not Last","All|First|Not first|Last|Not Last");
					// 높이 설정
					style.height = GetSheetHeight(13) ;

			  }
				break;

		}
	}

  // Sheet관련 프로세스 처리
	function doActionIBSheet1(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		isSearch = true;

		switch(sAction) {
		
		   case IBSEARCH:      //조회
			 if(validateForm(sheetObj,formObj,sAction)){
		        formObj.f_cmd.value = SEARCH01;
			    sheetObj.DoSearch4Post("ESD_SCE_0032GS.do", SceFrmQryString(formObj)  + "&" + ComGetPrefixParam("sheet1_"));
			 }else{
			     isSearch = false;
			 }
			 
			break;
		}
	}

  // Sheet관련 프로세스 처리
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

		   case IBSEARCH:      //조회
              if(isSearch){
    				  if(validateForm(sheetObj,formObj,sAction)){
    			        formObj.f_cmd.value = SEARCH02;
    				    sheetObj.DoSearch4Post("ESD_SCE_0032GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
    				 }
              }
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
					InsertTab( cnt++ , " Customer " , -1 );
					InsertTab( cnt++ , "EDI Status" , -1 );
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
//		with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
//		}
       var result = false ;
       
        if(
              !ComIsEmpty(formObj.cs_grp_id) ||
              !ComIsEmpty(formObj.cs_tp_id) ||
              !ComIsEmpty(formObj.hj_tp_id) ||
              !ComIsEmpty(formObj.sc_no) ||
              !ComIsEmpty(formObj.cs_cd) 

                             
           ){
            result =  true;  
//            if(!ComIsEmpty(formObj.vvd) || !ComIsEmpty(formObj.bkg_no_) 
//            || !ComIsEmpty(formObj.bl_no) || !ComIsEmpty(formObj.cntr_no_)){
//                result =  true;
//                if(!ComIsEmpty(formObj.vvd)){
//                    result = chkVVD(formObj);
//                }
//            }else {
//            	//alert(formObj.cntr_no.value);
//                showErrMessage(getMsg('SCE90024'));
//                result = false;
//            }          
        }else{
            ComShowMessage(ComGetMsg('COM12113',"EDI Customer Group"));
            result = false;
        }
        
        return result;

//		return true;
	}
	
	
	function onValueChange(selectName, formObj){
    	switch(selectName){
    	    case 'cs_grp_id' :
    	       formObj.grp_nm.value = formObj.cs_grp_id.value;
    	    break;
    	    case 'cs_tp_id' :
    	    break;
    	    case 'hj_tp_id' :
    	    break;
    	    case 'cs_cd' :
    	       formObj.cs_nm.value = formObj.cs_cd.value;
    	    break;
    	    case 'sc_no' :
    	    break;
    	}
	}
	
	function onObjectFocusout(fromname, toname, fromObj){
    	//alert(document.getElementById(fromnmae).value);
    	 var formObj = document.form;
    	document.getElementById(fromname).value = toUpperCase(document.getElementById(fromname).value);
    	document.getElementById(toname).value = document.getElementById(fromname).value;
    	
	    	formObj.cs_grp_id.value = toUpperCase(formObj.cs_grp_id.value);
	    	var sheetObj = sheetObjects[0];
	    	var sheetObj1 = sheetObjects[1];
	    	sheetObj.ShowDebugMsg = false;
	    	sheetObj.WaitImageVisible = false;
	    	formObj.f_cmd.value = SEARCH03;
	    	sheetObj.RemoveEtcData();
	    	sheetObj.RemoveAll();
	    	sheetObj1.RemoveAll();
	    	if(formObj.cs_grp_id.value !=''){  
	    	  sheetObj.DoSearch("ESD_SCE_0032GS.do",SceFrmQryString(formObj));

  		      ComEtcDataToForm(formObj,sheetObj);
  		      /*초기화*/
  		      if(formObj.tp_id.value == ''){
  		    	formObj.cs_grp_id.value = ''
  		      }
	    	}
	    	sheetObj.WaitImageVisible = true;
    }
    
    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); //소문자는 대문자로
        }  
        return str;      
    }
    
    // Customer 입력 받는 메소드(POP UP 에서 호출한다.)
    function openCustomer(){
 //   	window.open ("ESD_SCE_0062.do?mycust=3", "list", "scrollbars=no,resizable=yes,fullscreen=no,width=500,height=500");
    	var newWin = window.showModalDialog("ESD_SCE_0062.do?mycust=4", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:500px");
    }
    
    function openESD009Screen(cs_grp_id, tp_id, grp_nm){

    	var formObject = document.form;
    	formObject.cs_grp_id.value = cs_grp_id;
    	//onObjectFocusout(formObject);

    	formObject.cs_grp_id.value = cs_grp_id;
    	formObject.grp_nm.value = cs_grp_id;
    	formObject.tp_id.value = tp_id;
    	
    	//formObject.cs_grp_id.value = cs_grp_id;
    	//formObject.tp_id.value = tp_id;
    	//formObject.grp_nm.value = grp_nm;
    	//formObject.mycust.value = cs_grp_id+"%"+tp_id+"%"+grp_nm ;
    }
