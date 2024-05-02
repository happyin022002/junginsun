/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESDPRD0020.js
*@FileTitle : EsdPrd0080
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 노승배
*@LastVersion : 1.0 
* 2009.10.12 노승배
* 1.0 Creation
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;
var retValidate = 0;
var succFlag ="";
var strErrMsg ="";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;
         var por = document.getElementById('por');
         var rcv_t = document.getElementById('rcv_t');
         var del_t = document.getElementById('del_t');

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

        	    case "btn_retrieve":
    	            sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	            document.form.search_pctl_no.value='';
        	        break;

        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            formObject.reset();
//    	    		ComEnableObject(formObject.por, true);
//    	    		ComEnableObject(formObject.por_n, true);
//    	    		ComEnableObject(formObject.del_n, true);
//    	    		ComEnableObject(formObject.rcv_t, true);
//    	    		ComEnableObject(formObject.del_t, true);
//    	    		ComEnableObject(formObject.skd_date_fm, true);
//    	    		ComEnableObject(formObject.bkg_ofc, true);
//    	    		ComEnableObject(formObject.sc_ofc, true);
//    	    		ComEnableObject(formObject.com, true);
//    	    		ComEnableObject(formObject.btn_por, true);
//    	    		ComEnableObject(formObject.btn_calendar, true);
//    	    		ComEnableObject(formObject.btn_com, true);
    	    		por.setAttribute('required','');
    	    		por.className = 'input1';
    	    		rcv_t.className = 'input1';
    	    		del_t.className = 'input1';
    	            break;

                case "btn_por":
                    selectNode('POR');
                    break; 
                case "btn_del":
                    selectNode('DEL');
                    break;        
                case "btn_pol":
                    selectLoc('POL');
                    break;    
                case "btn_pod":
                    selectLoc('POD');
                    break;  
                case "btn_com":
                    selectCom('COM');
                    break;         
                    
        	    case "btn_calendar":
					var cal = new ComCalendar();
					cal.select(formObject.skd_date_fm, 'yyyy-MM-dd');
        	        break;      
        	    case "btng_costdetail":
        	       var pctl_no = document.form.search_pctl_no.value;
        	       if(pctl_no ==''){
					   ComShowCodeMessage("PRD90026");
        	           return;
        	       }
        	       //noRtnPopup('ESM_COA_141.do?f_pctl_no='+pctl_no, 'width=850,height=520,menubar=0,status=1,scrollbars=0,resizable=0') ;
				   ComOpenPopup('ESM_MAS_0141.do?f_pctl_no=' + pctl_no, 905, 550, '', "1,0,1,1,1,1,1,1,1,1,1,1", true);
        	       break;
				case "btn_vvd":
					openWindowVvd(formObject);
					break;        	       
//        	    case "precmChk":
//        	    	if(formObject.precmChk.checked==true){
//        	    		formObject.reset();
//        	            sheetObject.RemoveAll();
//        	            sheetObject1.RemoveAll();
//        	    		formObject.precmChk.checked=true;
//        	    		ComEnableObject(formObject.por, false);
//        	    		ComEnableObject(formObject.por_n, false);
//        	    		ComEnableObject(formObject.del_n, false);
//        	    		ComEnableObject(formObject.rcv_t, false);
//        	    		ComEnableObject(formObject.del_t, false);
//        	    		ComEnableObject(formObject.skd_date_fm, false);
//        	    		ComEnableObject(formObject.bkg_ofc, false);
//        	    		ComEnableObject(formObject.sc_ofc, false);
//        	    		ComEnableObject(formObject.com, false);
//        	    		ComEnableObject(formObject.btn_por, false);
//        	    		ComEnableObject(formObject.btn_calendar, false);
//        	    		ComEnableObject(formObject.btn_com, false);
//        	    		por.removeAttribute('required');
//        	    	} else {
//        	    		formObject.reset();
//        	            sheetObject.RemoveAll();
//        	            sheetObject1.RemoveAll();
//        	    		ComEnableObject(formObject.por, true);
//        	    		ComEnableObject(formObject.por_n, true);
//        	    		ComEnableObject(formObject.del_n, true);
//        	    		ComEnableObject(formObject.rcv_t, true);
//        	    		ComEnableObject(formObject.del_t, true);
//        	    		ComEnableObject(formObject.skd_date_fm, true);
//        	    		ComEnableObject(formObject.bkg_ofc, true);
//        	    		ComEnableObject(formObject.sc_ofc, true);
//        	    		ComEnableObject(formObject.com, true);
//        	    		ComEnableObject(formObject.btn_por, true);
//        	    		ComEnableObject(formObject.btn_calendar, true);
//        	    		ComEnableObject(formObject.btn_com, true);
//        	    		por.setAttribute('required','');
//        	    		por.className = 'input1';
//        	    		rcv_t.className = 'input1';
//        	    		del_t.className = 'input1';
//        	    	}
//        	    	break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    

    /*----------------------------------------------------------------*/
    var portInd = '';
	function selectNode(pt){
		var param = '?loc_port_ind=1';
		portInd = pt;
		if(portInd == 'POR'){
          param = param+'&node_cd='+form.por.value;
		}
		if(portInd == 'DEL'){
		  param = param+'&node_cd='+form.del.value;
		}		
		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true);
	}
	
    function getNode(rowArray) {
//        alertComPopupData(rowArray);
    	var colArray = rowArray[0];
 
		if(portInd == 'POR'){
        	document.all.por.value =  colArray[3].substring(0,5);    	
        	document.all.por_n.value = colArray[3].substring(5);
		}
		if(portInd == 'DEL'){
        	document.all.del.value =  colArray[3].substring(0,5);    	
//        	if(document.all.precmChk.checked==false){
//        		document.all.del_n.value = colArray[3].substring(5);  
//        	}        	
		}	    	  	
    }
    /*----------------------------------------------------------------*/	
    var locInd = '';
	function selectLoc(pt){
		var param = '?loc_port_ind=1';
		//ComShowMessage(" $ param : " + param);
		locInd = pt;
		if(locInd == 'POL'){
          param = param+'&loc_cd='+form.pol.value;
		}
		if(locInd == 'POD'){
		  param = param+'&loc_cd='+form.pod.value;
		}		
		ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getLoc', "1,0,1,1,1,1,1,1,1,1,1,1", true);
	}	
	
    function getLoc(rowArray) {
        var frm = document.form;
//        alertComPopupData(rowArray);
    	var colArray = rowArray[0];
 
		if(locInd == 'POL'){
        	frm.pol.value =  colArray[3];//.substring(0,5);    	
		}
		if(locInd == 'POD'){
        	frm.pod.value =  colArray[3];//.substring(0,5);    	
		}	    	  	
    }	
	/*----------------------------------------------------------------*/
    var comInd = '';
	function selectCom(pt){
		var param = '';
		//ComShowMessage(" $ param : " + param);
		comInd = pt;
		if(comInd == 'COM'){
          param = param+'?cmdt_cd='+form.com.value;
		}
	
		ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 770, 470, 'getCom', "1,0,1,1,1,1,1,1,1,1,1,1", true);
	}	
	
    function getCom(rowArray) {
    	var colArray = rowArray[0];
		if(comInd == 'COM'){
        	document.form.com.value =  colArray[3];//.substring(0,5);
		}
    	  	
    }		
	/*----------------------------------------------------------------*/
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
    	 var formObject = document.form;
    	 
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        toolTip();
        
//        if(CRUD != "S") {
//        	document.getElementById('precmChk').className = 'trans';
//        	ComEnableObject(formObject.precmChk, false);
//        }
        
		//Axon 이벤트 처리1. 이벤트catch
        axon_event.addListenerForm('change', 'obj_change', document.form);
 		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'por', 'por_n', 'pol', 'pod', 'del', 'del_n', 'rcv_t', 'del_t', 'c_tpsz', 'c_qty', 'skd_date_fm', 'bkg_ofc', 'sc_ofc', 'com');
		
//		changeOP('L');
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
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hWostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(17, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "SEQ|Constraint\n/Ref.|Rem|Ocean\nFlag|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|T/Time\n(day/HR)|Total Cost" ;
                    var HeadTitle1 = "SEQ|Constraint\n/Ref.|Rem|Ocean\nFlag|POR|Inter Change|POL|T/S Route|POD|Inter Change|DEL|T/Time\n(day/HR)|Total Cost" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  true,   "",             false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtImage,      70,    daCenter,  true,   "remark_img",   false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,   "remark",       false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,   "rout_flag",    false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       43,    daCenter,  true,   "por_cd",       false,          "",       dfNone,	    0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       140,   daCenter,  true,   "ob_itchg_ctnt",false,          "",       dfNone,   	0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       43,    daCenter,  true,   "pol_cd",       false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       190,    daCenter,  true,   "ts_route",     false,          "",       dfNone, 	    0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       43,    daCenter,  true,   "pod_cd",       false,          "",       dfNone,	    0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       140,   daCenter,  true,   "ib_itchg_ctnt",false,          "",       dfNone,   	0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       43,    daCenter,  true,   "del_cd",       false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,   "ttl_tztm_hrs", false,          "",       dfUserFormat2,0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "total_cost",   false,          "",       dfFloat,   	3,     false,      true);
                    //hidden
                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,   "pctl_no",      false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,   "rout_cnst_seq",false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,   "trnk_lane",    false,          "",       dfNone,       0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,   "cnst_rmk",     false,          "",       dfNone,       0,     false,      true);
                    

                    HeadRowHeight = "10" ;
                    InitUserFormat2(0, "ttl_tztm_hrs", "##D ##H" , "D|H"  );

					// TODO delete noh
        		    //CellBackColor(1,"por_cd") = RgbColor(231,250,249);
        		    //CellBackColor(1,"ob_itchg_ctnt") = CellBackColor(1,"por_cd")
        		    //CellBackColor(1,"pol_cd") = CellBackColor(1,"por_cd")
        		    //CellBackColor(1,"ts_route") = CellBackColor(1,"por_cd")
        		    //CellBackColor(1,"pod_cd") = CellBackColor(1,"por_cd")
        		    //CellBackColor(1,"ib_itchg_ctnt") = CellBackColor(1,"por_cd")
        		    //CellBackColor(1,"del_cd") = CellBackColor(1,"por_cd")
                    ImageList(0) = "/hanjin/img/alps/ico_b.gif" ;
                    ImageList(1) = "/hanjin/img/alps/ico_r.gif" ;


        		    style.height = 150 ;
               }
                break;

              case 2:      //IBSheet2 init

                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    var HeadTitle = "Ref|Rem|Node / Link|Vvd|Mode|T. Time / D. Time|Arr. Time|Dep. Time" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtImage,     40,    daCenter,  true,   "remark_img",    false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    130,   daCenter,  true,   "remark",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      200,   daCenter,  false,  "node_link",     false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      150,   daCenter,  false,  "vvd",     false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,  "trsp_mod_cd",   false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      130,   daCenter,  false,  "fmt_tz_dwll_tm",false,          "",       dfUserFormat2,0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      170,    daCenter,  false,  "arr_time",     false,           "",       dfNone, 	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      170,    daCenter,  false,  "dep_time",    false,            "",       dfNone, 	    0,     true,       true);
                    
                    //hidden
                    InitDataProperty(0, cnt++ , dtHidden,    50,    daCenter,  true,   "pctl_no",       false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    50,    daCenter,  true,   "cnst_rmk",      false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    10,    daCenter,  true,   "org_nod_cd",    false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    10,    daCenter,  true,   "dest_nod_cd",   false,          "",       dfNone,       0,     true,       true);
                    
        		    style.height = 210 ;
                    ImageList(0) = "/hanjin/img/alps/ico_b.gif" ;
                    ImageList(1) = "/hanjin/img/alps/ico_r.gif" ;
                    InitUserFormat2(0, "fmt_tz_dwll_tm", "##D ##H" , "D|H"  );
        
        		    DataAltanateBackColor = RgbColor(235,245,225);  //  짝수행 색상 변경, 해당페이지의 경우에는  sheet명_OnSearchEnd() 같이 적용
               }
                break;

        }
    }

    //   특정컬럼(열) 의 색상을 변경
    function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    {
    	var rowCount  = sheetObj.RowCount;
		var routFlag = '';

		for(i=0+parseInt(sheetObj.HeaderRows);i<rowCount+parseInt(sheetObj.HeaderRows);i++){
			routFlag = sheetObj.CellValue(i, "routFlag");
//			alert(i);
			if(routFlag=='Validation' ){
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 255, 204);
			} else if(routFlag=='Temporary') {
			    sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 204, 204);
			}
			else if(routFlag=='Add Call') {
			    sheetObj.RowBackColor(i) = sheetObj.RgbColor(204, 204, 255);
			} else{
				//sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,255,192);
			}
		}
    }
    
    //   특정컬럼(열) 의 색상을 변경
    function sheet2_OnSearchEnd(sheetObj,ErrMsg)
    {
    	  sheetObj.ColBackColor("section") = sheetObj.RgbColor(255,255,255);
    	  sheetObj.SumText(0,"td_time") = "계산된 값 입력" ;
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var uid ;
    	var sXml ;
	    sheetObj.ShowDebugMsg = false;
	  
        switch(sAction) {

           case IBSEARCH:      //list 조회
                if(!ComChkRequired(formObj)) return; 
//		    	if(formObj.precmChk.checked==true){
//		    		formObj.f_cmd.value = SEARCHLIST01;
//		    	} else {
		    		formObj.f_cmd.value = SEARCHLIST;
//		    	}
		    	
		    	/**
			     * por+por_yd_cd으로 변경하여 por_n에 반영한다. <br>
			    **/	
		    	if (formObj.por_yd_cd.value.length == 2 && formObj.por.value.length == 5){
		    		formObj.por_n.value = formObj.por.value + formObj.por_yd_cd.value
		       	    
		       	}else {
		       		formObj.por_n.value ="";
		       	    
		       	}
		    	
//		    	alert(formObj.c_tpsz.value.substr(0,1));
		    	if(formObj.c_tpsz.value.length > 0 && formObj.c_tpsz.value.substr(0,1)=="R" ){
		    		formObj.rf_f.value="Y";
		    	}else{
		    		formObj.rf_f.value="";
		    	}
		    	
		    	 /**
		    	  * del+del_yd_cd으로 변경하여 del_n에 반영한다. <br>
		    	 **/
		    	if (formObj.del_yd_cd.value.length == 2 && formObj.del.value.length == 5){
		    		formObj.del_n.value = formObj.del.value + formObj.del_yd_cd.value
		  	 	   
		  	 	}else {
		  	 		formObj.del_n.value ="";
		  	 		
		  	 	}
		    	 
		    	detail_form_clear(); 
		    	
		    	formObj.ld_dt.value = formObj.skd_date_fm.value.split("-").join("");
		    	sheetObj.DoSearch4Post("ESD_PRD_0020GS.do",PrdFQString(formObj));
		    	var costResult = sheetObj.EtcData("costResult");
               
                // 실패시 처리 --------------------- 
                succFlag = sheetObj.EtcData("succFlag");
                strErrMsg = sheetObj.EtcData("strErrMsg");
                
                if(succFlag == "FAIL") {
                    ComShowMessage( strErrMsg);
                }
                // 실패시 처리 ---------------------   
                               
                if(costResult == "N") {
                    // msgs['PRD90036'] = 	'COST가 반영되지 않았습니다.';
					ComShowCodeMessage('PRD90036');
                } 
                break;
            
            case SEARCH02:
              formObj.f_cmd.value = SEARCH02;
              //sheetObj.DoRowSearch("ESD_PRD_0004VALIDATION.do", PrdFQString(formObj));
    	
              //var SaveStr = sheetObj.GetSaveString(true);  
              uid= "ESD_PRD_0020";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&chkData="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              break;   
              
              
            case "CNSTSEARCH":
				formObj.f_cmd.value = SEARCH10;
				var row = sheetObj.SelectRow;
	       	 	
				sXml = sheetObj.GetSearchXml("ESD_PRD_0020GS.do", "f_cmd="+SEARCH10+"&prdCtlNo="+sheetObj.CellValue(row,"pctl_no")+
		                    "&pol="+sheetObj.CellValue(row,"pol_cd")+"&pod="+sheetObj.CellValue(row,"pod_cd")+
		                    "&del="+sheetObj.CellValue(row,"del_cd")+
		                    "&trnkLane="+sheetObj.CellValue(row,"trnk_lane")+"&cnst_seq="+sheetObj.CellValue(row,"rout_cnst_seq")+
		                    "&row="+row+"&cnstFlg="+sheetObj.CellValue(row,"remark"));
				
				var arrXml = sXml.split("|$$|"); 
				if(arrXml.length ==1) { 
					var cnst_remark = ComGetEtcData(arrXml[0],"cnst_rmk");
					ComShowMessage(cnst_remark);
				}
              
				break;             
        }
    }


function doActionIBSheet2(sheetObj,formObj,sAction) {

	switch(sAction) {
            
		case IBSEARCH:      //detail 조회
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_PRD_0020_DETAIL.do", PrdFQString(formObj));
			formObj.init_eta.value = sheetObj.EtcData("INIT_ETA");
			formObj.vps_eta.value = sheetObj.EtcData("VPS_ETA");
			
			
			formObj.rail_erd.value = ComGetMaskedValue(sheetObj.EtcData("RAIL_ERD").substring(0,8), "ymd");
			formObj.rail_lrd.value = ComGetMaskedValue(sheetObj.EtcData("RAIL_LRD").substring(0,8), "ymd");
			formObj.port_cct.value = sheetObj.EtcData("PORT_CCT");
			formObj.erd.value = sheetObj.EtcData("ERD");
			break;

		case "CNSTSEARCH2":
			formObj.f_cmd.value = SEARCH10;
			var row = sheetObj.SelectRow;

			var sXml = sheetObj.GetSearchXml("ESD_PRD_0020GS.do", "f_cmd="+SEARCH10+"&prdCtlNo="+sheetObj.CellValue(row,"pctl_no")+
                           "&row="+row+"&cnstFlg="+sheetObj.CellValue(row,"remark")+
                           "&nod_cd="+sheetObj.CellValue(row, "node_link")+
                           "&org_nod_cd="+sheetObj.CellValue(row, "org_nod_cd")+"&dest_nod_cd="+sheetObj.CellValue(row,"dest_nod_cd"));

			var arrXml = sXml.split("|$$|"); 
			if(arrXml.length ==1) { 
				var cnst_remark = ComGetEtcData(arrXml[0],"cnst_rmk");
				ComShowMessage(cnst_remark);
			}	
			
			break;
        }
    }

    // sheet1 에서 더블클릭 이벤트 발생시 
    function sheet1_OnDblClick(sheetObj, row, col) {
        var formObj = document.form;

        if(sheetObj.ColSaveName(col) == "remark_img"){
        	if(sheetObj.CellValue(row, "remark").length == 1) {
        		doActionIBSheet(sheetObjects[0], document.form, "CNSTSEARCH");
        		ComShowMessage(sheetObj.CellValue(row, "cnst_rmk"));
        	}
        }
        
        if(parseInt(sheetObjects[1].Rows)==1 || (parseInt(sheetObjects[1].Rows)>1 && sheetObj.CellValue(row, "pctl_no")!=formObj.search_pctl_no.value)){
        		formObj.search_pctl_no.value = sheetObj.CellValue(row,"pctl_no");
        		doActionIBSheet2(sheetObjects[1],document.form, IBSEARCH);  //sheetObjects[1]->sheet2
        }
    }
    
    // sheet2 에서 더블클릭 이벤트 발생시 
    function sheet2_OnDblClick(sheetObj, row, col) {
    	var formObj = document.form;

    	if(sheetObj.ColSaveName(col) == "remark_img"){
    		
    		if(sheetObj.CellValue(row, "remark") == 'N' || sheetObj.CellValue(row, "remark") == 'L' || sheetObj.CellValue(row, "remark") == 'X') {
    			doActionIBSheet2(sheetObjects[1], document.form, "CNSTSEARCH2");
    			ComShowMessage(sheetObj.CellValue(row, "cnst_rmk"));
    		}
    	}
    }    
    
    // dtPopupEdit 로 처리 할 경우 팝업오픈 처리
    function sheet1_OnPopupClick(sheetObj, row, col)
    {
        if ( sheetObj.ColSaveName(col) == "from" )
        {
           ComShowMessage("From Search Popup Open!! row=" + row );
        }
    
        if ( sheetObj.ColSaveName(col) == "to" )
        {
           ComShowMessage("To Search Popup Open!! row=" + row );
        }
        if ( sheetObj.ColSaveName(col) == "sp" )
        {
           ComShowMessage("S/P Search Popup Open!! row=" + row );
        }
    }

    
	function obj_change() {
		var formObj = document.form;
		obj = event.srcElement;
		if (obj.name == "inquiryLevel") {
			if (obj.value == "L") { //ldd
				document.getElementById('skd_type_0').style.display = 'block';
				document.getElementById('skd_type_1').style.display = 'none';
//				document.getElementById("location").setAttribute("maxLength", 7);
//				document.getElementById("location").focus();
				formObj.t_vvd.value ="";
				
			} else { //vvd
				document.getElementById('skd_type_0').style.display = 'none';
				document.getElementById('skd_type_1').style.display = 'block';
//				document.getElementById("location").setAttribute("maxLength", 5);
//				document.getElementById("location").focus();
				formObj.skd_date_fm.value ="";
			}
		}  
	}	
	
	function detail_form_clear() {
		var formObj = document.form;
		formObj.rail_lrd.value = '';
		formObj.init_eta.value = '';
		formObj.vps_eta.value = '';
		formObj.rail_erd.value = '';
		formObj.port_cct.value = '';
		formObj.erd.value = '';
	}
    function openWindowVvd(formObj) {
    	var formObj = document.form;
  		var param = "";
  	    param += "vvd_cd="+ComGetObjValue(formObj.t_vvd);
      
  		ComOpenPopup('/hanjin/COM_ENS_0B2.do?'+param , 780, 465, 'getCOM_ENS_0B2', '1,0,1,1,1,1,1,1', true);
 	}
  	/**
  	 * Vessel SKD & Code Inquiry부분.<br>
  	 * @param {arry} aryPopupData
  	 */
  	function getCOM_ENS_0B2(aryPopupData) {
  		var formObject = document.form;
  		formObject.t_vvd.value = aryPopupData[0][7];
  	} 