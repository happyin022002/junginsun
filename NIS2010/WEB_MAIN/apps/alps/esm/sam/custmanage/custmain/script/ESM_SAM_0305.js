// 공통전역변수
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
 
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

        	    case "btn_New":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
        	        break;
        	        
                case "btn_Close":
    	            self.close();
        	        break;
        	        
                case "btn_com_ens_051": // location pop-up
    				var param="";
    	    		param=param + "&" + "loc_cd=" + form.loc_cd.value;
    	    		ComOpenPopup('/hanjin/COM_ENS_051.do?' + param, 780, 470, 'setCallBack0B1', '1,0,1,1,1,1,1,1', true);
    				break;
    				
                case "btn_com_ens_071": // office pop-up
     				var param="";
     	    		param=param + "&" + "ofc_cd=" + form.ofc_cd.value;
     	    		ComOpenPopup('/hanjin/COM_ENS_071.do?' + param, 780, 520, 'setCallBack0B3', '1,0,1,1,1,1,1,1', true);
     				break;

        	    case "btn2_Down_Excel":
        	    	sheetObject.Down2Excel(false,false,true,false,"","",false,false,"",false,"0|1");        	    	
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

    function initControl() {
    	var formObject = document.form;
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	axon_event.addListenerFormat('keypress', 'obj_keypress_loc', document.form);
        axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
    
  //업무 자바스크립트 OnKeyPress 이벤트 처리
    function keypressFormat() {
    	obj = event.srcElement;
  	    if(obj.dataformat == null) return;
  	    window.defaultStatus = obj.dataformat;
  	    switch(obj.name) {
  	        case "cust":
  	        	ComKeyOnlyNumber(obj);
  	            break;
  	        case "ofc_cd":
  	        	ComKeyOnlyAlphabet('upper');
  	        	break;
  	        case "cust_nm":
//  	        	ComKeyOnlyAlphabet('upper','32');
	            break;
  	        case "cust_cd":
	        	ComKeyOnlyAlphabet('upper');
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
    
	function setCallBack0B1(aryPopupData) {
		var form=document.form;
		form.loc_cd.value=aryPopupData[0][3];
	} 
	
	function setCallBack0B3(aryPopupData) {
		var form=document.form;
		form.ofc_cd.value=aryPopupData[0][3];
	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var formObj=document.form;
		var sheetObj=sheetObjects[0];
		
        axon_event.addListenerForm  ('keyup',    'obj_keyup',        document.form); 
        
        doActionIBSheet(sheetObjects[0],formObj,SEARCH04);
        
        initControl();
    }
	// 업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress_loc() {
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		switch(event.srcElement.dataformat){
	       case "float":
	           //숫자+"."입력하기
	           ComKeyOnlyNumber(event.srcElement, ".");
	           break;
	       case "eng":
	           //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	           ComKeyOnlyAlphabet();
	           break;
	       case "engdn":
	           //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	           ComKeyOnlyAlphabet('lower');
	           break;
	       case "engup":
	           //영문 대문자만 입력하기
	           ComKeyOnlyAlphabet('upper');
	           break;
	       case "int":
	           //숫자만입력하기(정수,날짜,시간)
	           ComKeyOnlyNumber(event.srcElement);
	           break;
	       case "uppernum": //모든 문자 가능하지만 영문은 대문자로
	       	   if(keyValue >= 97 && keyValue <= 122) {//소문자
	     			event.keyCode = keyValue + 65 - 97;
	     		}
	           break;
	       case "tel":
		        // 숫자+"-"입력하기
		        ComKeyOnlyNumber(event.srcElement, "-"); 
		        break;
           case "engupspecial": // 영문대문자+숫자 + Space + &*-,./
	   		   ComKeyOnlyAlphabet('uppernum', "32|38|42|45|44|46|47");
	    	   break;
	    }
	}
    
	function obj_keyup() {
		var formObj = document.form;
		with (formObj) {
			//textarea : enter 제외
			if (event.srcElement.type == "textarea") {
				return;
			}			
		}
	}
	
	/**
     * Event 처리 <br>
     * </pre>
     * @return 없음
     * @version 2014.01.07
    */
	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		switch(event.srcElement.dataformat){
			case "engupnum":
				ComKeyOnlyAlphabet("uppernum");
			break;
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
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 5000);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    
                    
                    var HeadTitle = "|Seq.|Cust. Code|Customer Name|REP.OFC|Address|ST|ZIP|Location|Type|Group Code|GST NO.|Vndr Code|Status" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHidden,30,    daCenter,  false,    	"radio",   				false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    	"seq",     				false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  false,    	"cust_cd", 				false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     200,    daLeft  ,  false,    	"cust_nm", 				false,          "",       dfNone,       0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  false,    	"ofc_cd",  				false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     220,    daLeft,  false,    	 	"bzet_addr",   			false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     0,    daCenter,  false,    	 	"ste_cd",   			false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     60,    daCenter,  false,    	"zip_cd",   			false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     0,    daCenter,  false,    	 	"loc_cd",   			false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     0,    daCenter,  false,    	 	"rvis_cntr_cust_tp_cd", false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     0,    daCenter,  false,    	 	"cust_grp_id",   		false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     150,    daCenter,  false,     	"ida_gst_rgst_no",   	false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       0,    daCenter,  false,   	"vndr_seq",     		false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,   	"delt_flg",     		false,          "",       dfNone,   	0,     false,       true);
                    
                    CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
               }
                break;

        }
    }

    function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
       // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.zz
       doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    } 

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)) {
                	
                	 formObj.f_cmd.value = SEARCH;
                     selectVal = FormQueryString(formObj);
//                     sheetObj.UseZipFile = true;
                     var sXml = sheetObj.GetSearchXml("ESM_SAM_0305GS.do", selectVal);
                     sheetObj.LoadSearchXml(sXml);
//                     sheetObj.ShowDebugMsg = false;
//                     sheetObj.DoSearch("COM_ENS_041GS.do?UseZipFile=true", selectVal);
                }else{
                	return true;
                }
           
           break;
           case IBSEARCHAPPEND:  // 페이징 조회
           
                formObj.f_cmd.value = SEARCH;         
                sheetObj.DoSearch4Post("ESM_SAM_0305GS.do", selectVal, "iPage=" + PageNo, true);  
           break;
           
           case SEARCH04:      //Office Code check
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH04;
					formObj.ofc_cd.value=formObj.usr_ofc_cd.value;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSearchXml("ESM_SAM_0302GS.do", sParam);
			        var country=ComGetEtcData(sXml, "country");

			        if(country=="IN"){
			        	sheetObj.ColHidden("ida_gst_rgst_no") = false;
			        } else {
			        	sheetObj.ColHidden("ida_gst_rgst_no") = true;
			        }
			        formObj.ofc_cd.value="";
					ComOpenWait(false);
				}
				break;

        }
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
           
        }

        return true;
    }
    
   	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		sheetObj.ColFontUnderline("cust_cd")   = true;
		sheetObj.ColFontUnderline("cust_grp_id")   = true;
	}
   	
    /**
     * 시트를 더블클릭했을 때 처리
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
    	var formObj=document.form;
		if ( col != 10 ) {
			var param = "";
			var chkCustCd = sheetObjects[0].CellValue(row, "cust_cd");
			if ( chkCustCd != "" ) {	
	    		param=param + "&" + "cust_cd=" + chkCustCd + "&cnt_cd="+chkCustCd.substring(0,2) + "&cust_seq="+chkCustCd.substring(2,8);
	    		ComOpenWindowCenter("/hanjin/ESM_SAM_0302.do?"+param, "ESM_SAM_0302", 1024, 600, true, "yes");
			}
		} else {
			var param = "";
			var chkCustGrpId = sheetObjects[0].CellValue(row, "cust_grp_id");
			if ( chkCustCd != "" ) {	
	    		param=param + "&" + "cust_grp_id=" + chkCustGrpId;
	    		ComOpenWindowCenter("/hanjin/ESM_SAM_0306.do?"+param, "ESM_SAM_0306", 1024, 600, true, "yes");
			}
		}
    }

	
