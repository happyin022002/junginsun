/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0205.js
*@FileTitle : Phase In/Out Information
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.16
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.02 유혁
* 1.0 Creation
* 
* History
* 2010.09.16 유혁 CHM-201005617-01 미지정시 Direction, Port Code에 대해 유저가 선택 가능하도록 변경
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
     * @class VOP_VSK_0205 : VOP_VSK_0205 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0205() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/


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
         
         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		var cal = new ComCalendar();

            switch(srcName) {

				case "btn_OK":
					if(!validateForm(formObj, "btn_OK")){
						return false;
					}
					
					if(formObj.parentUI.value == "0010"){
			        	with(formObj){
			        		if(phaseType.value=="O"){
			        			window.returnValue = phase_rsn_code.options[phase_rsn_code.selectedIndex].text+":"+port_skp_tp_cd.value;
			        			//Force Majeure indicator of Phase Out (F:Yes, I:No)
								
			        		}else if(phaseType.value=="I"){
			        			var obj = new Object();
			        			obj.vvd = src_vsl_cd.value + src_skd_voy_no.value + src_skd_dir_cd.value;
			        			// 스케쥴이 시작될 날짜(yyyyMMdd) + P/F 상의 시간(HHmm)
			        			obj.date = src_phase_date.value.replace(/\/|\-/g, "") + src_pf_date.value.replace(/\/|\-|\ |\:/g,"").substring(8);
			        			obj.rsn_cd = phase_rsn_code.options[phase_rsn_code.selectedIndex].text+":"+port_skp_tp_cd.value;
			        			
			        			if(src_skd_dir_cd.selectedIndex=="0"){
			        				obj.phasein_col = src_port_cd.selectedIndex+1;
			        			}else{
			        				obj.phasein_col = firstPortCds.value.split("|").length + src_port_cd.selectedIndex+1;
			        			}
			        			
			        			window.returnValue = obj;
			        		} 
			        	}
					}else if(formObj.parentUI.value == "0015"){
						if(formObj.phaseType.value == "O"){
							var obj = new Object();
							obj.phs_io_rsn_cd = formObj.phase_rsn_code.options[formObj.phase_rsn_code.selectedIndex].text;
							obj.phs_io_rmk = formObj.phase_rsn_name.value;
							
							
							//Force Majeure indicator of Phase Out (F:Yes, I:No)
							obj.port_skp_tp_cd = formObj.port_skp_tp_cd.value;
							
							
							window.returnValue = obj;
						
							
						}
					}
					comPopupOK();
					break;

				case "btn_Close":
					window.close();
					break;
					
				case "btns_search1":
					if(!formObj.src_vsl_cd.disabled){
						if(formObj.src_vsl_cd.value==''){
							openVslCdHelp();
						}else if(formObj.src_skd_voy_no.value==''){
							openVoyNoHelp();
						}
					}
					break;
					
				case "btns_cal1":
					cal.select(formObj.src_phase_date, 'yyyy-MM-dd');
					break;
					
				case "btns_cal11":
					//cal.select(formObj.src_phase_date, 'yyyy-MM-dd');
					cal.select(formObj.src_pf_date, 'yyyy-MM-dd');
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
    	
    	var formObj = document.form;
    	
        for(i=0;i<sheetObjects.length;i++){

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

        }
        
        formObj.phase_rsn_name.value = formObj.phase_rsn_code.value;
        formObj.src_phase_date.value = ComGetMaskedValue(formObj.src_phase_date.value, "ymd");
        
        initControl();
        
        if(formObj.parentUI.value=="0010"){
        	with(formObj){
        		if(phaseType.value=="O"){
        			
        			src_vsl_cd.readOnly = true;
        			src_skd_voy_no.readOnly = true;
        			src_skd_dir_cd.readOnly = true;
        			
       	        	clpt_ind_seq_1.value = src_clpt_ind_seq.value;
       	        	// 사용자가 clpt_ind_seq를 선택하고 phase in 하는 경우 clpt_ind_seq 선택 콤보를 고정시키고
       	        	// 서버에 전송하는 값은 formObj.clptIndSeq.value
       	        	clpt_ind_seq_1.disabled = true;
       	        	
	        		//src_phase_date.className = "input2";
	        		src_phase_date.readOnly = true;
	        		src_phase_date.disabled = true;
	        		
	        		btns_cal1.name = "no_btns_cal1";
	        		phase_rsn_code.focus();
	        		
        		}else if(phaseType.value=="I"){
        			
        			clpt_ind_seq_1.value = src_clpt_ind_seq.value;
       	        	// 사용자가 clpt_ind_seq를 선택하고 phase in 하는 경우 clpt_ind_seq 선택 콤보를 고정시키고
       	        	// 서버에 전송하는 값은 formObj.clptIndSeq.value
       	        	clpt_ind_seq_1.disabled = true;
       	        	
	        		//src_phase_date.className = "input2";
//	        		src_phase_date.readOnly = true;
//	        		src_phase_date.disabled = true;
       	        	var srcdate = src_pf_date.value;
	        		var dDate = new Date(getDateFromFormat(srcdate, 'MM/ddyyyyHHmm'));
	        		srcdate = srcdate.replace(/\/|\ /g, ""); // 날짜구분자,스페이스 없애기
	        		
	        		src_pf_date.value = srcdate.substr(4, 4) + "-" + srcdate.substr(0, 2) + "-" + srcdate.substr(2, 2); // + " " + srcdate.substr(8, 2) + ":" + srcdate.substr(10, 2);
	        		
	        		src_pf_date.value = ComGetDateAdd(src_pf_date.value, "D", 7)
	        		
       	        	src_pf_date.readOnly = true;
       	        	src_phase_date.value = srcdate.substr(4, 4) + "-" + srcdate.substr(0, 2) + "-" + srcdate.substr(2, 2);
       	        	
       	        	src_phase_date.value = ComGetDateAdd(src_phase_date.value, "D", 7)
	        		phase_rsn_code.focus();
	        		
        		}
        	}
        }

        

    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetId = sheetObj.id;

        switch(sheetId) {
            case "sheet1":      // sheet1 init
                with (sheetObj) {
                	
                	tabIndex = -1;
                	
                    // 높이 설정
                    style.height = 0;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(1, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		0,	daCenter,		true,		"ibflag");

			   }
                break;
                 
                

        }
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	
        switch(sAction) {

           case SEARCH01:
        	   if(validateForm(formObj, SEARCH01)){
					formObj.f_cmd.value = COMMAND16;
					var sParam = FormQueryString(formObj) + "&vsl_cd=" + formObj.src_vsl_cd.value;
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0205GS.do", sParam);
					var vslEngNm = ComGetEtcData(sXml, "vsl_eng_nm");
					if(vslEngNm){
						return true;
					}else{
						sheetObj.LoadSearchXml(sXml);
			    		formObj.src_vsl_cd.value = "";
			    		return false;
			    	}
				}
				break;
				
           case SEARCH02:
      			if(formObj.src_vsl_cd.value!='' &&
      					formObj.src_skd_voy_no.value!='' &&
      					formObj.src_skd_dir_cd.value!=''){
      				
      				formObj.f_cmd.value = SEARCH02;
      				var sParam = FormQueryString(formObj) + "&vsl_cd=" + formObj.src_vsl_cd.value + "&skd_voy_no=" + formObj.src_skd_voy_no.value + "&skd_dir_cd=" + formObj.src_skd_dir_cd.value;
      				var rXml = sheetObj.GetSearchXml("VOP_VSK_0249GS.do" , sParam);
      				var vvd = ComGetEtcData(rXml, "vvd");
      				if(vvd==null){
      					ComShowCodeMessage('VSK00028', formObj.src_vsl_cd.value + formObj.src_skd_voy_no.value + formObj.src_skd_dir_cd.value );
      					formObj.src_vsl_cd.value = '';
          				formObj.src_skd_voy_no.value = '';
          				formObj.src_skd_dir_cd.value = '';
          				formObj.src_vsl_cd.focus();
      				}
      				break;
      			}
      			break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(formObj,sAction){
    	switch(sAction){
	    	case "btn_OK":
	    		if(!formObj.src_vsl_cd.value || !formObj.src_skd_voy_no.value || !formObj.src_skd_dir_cd.value){
	    			ComShowCodeMessage('VSK00027', 'VVD');
	    			return false;
	    		}
	    		break;
	    		
	    	case SEARCH01:
	    		if(!formObj.src_vsl_cd.value || ComChkLen(formObj.src_vsl_cd.value, 4)!=2){
	    			ComShowCodeMessage('VSK00027', 'Vessel Code');
	    			formObj.src_vsl_cd.value = "";
	    			return false;
	    		}
	    		// 메인창(VOP_VSK_0010)에서 사용하고 있는 Vessel Code는 사용안됨.
	    		var vesselList = dialogArguments.getVesselList();
	    		if(vesselList[formObj.src_vsl_cd.value]){
	    			ComShowCodeMessage('VSK00085');
	    			formObj.src_vsl_cd.value = "";
	    			return false;
	    		}
	    		break;
    	}
        return true;
    }
    
    function initControl() {
    	var formObj = document.form;
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('change', 'obj_change', formObj);
    	axon_event.addListenerForm('focus', 'obj_focus', formObj);
    	axon_event.addListenerForm('blur', 'obj_blur', formObj);
    	axon_event.addListenerForm('keypress', 'eng_keypress' , formObj);	//- 영문 대문자만 입력하기
    	axon_event.addListenerForm('keyup', "VskKeyFocus", formObj);			//- 자동포커스 처리
    	
    	//axon_event.addListener('change', 'obj_change' , 'src_phase_date');
    	//axon_event.addListener('change', 'obj_change' , 'dest_phase_date');
    	
	}
    
    function obj_focus() {
    	// 마스크구분자 없애기
    	switch(event.srcElement.name){
    		case "src_phase_date":
//    		case "dst_phase_date":
    			ComClearSeparator(event.srcElement);
    			break;
    	}
    	if(event.srcElement.options){
    		event.srcElement.focus();
    	}else{
    		event.srcElement.select();
    	}
    }

    function obj_blur() {
    	//입력Validation 확인 및 마스킹 처리
    	switch(event.srcElement.name){
	    	case "src_phase_date":
//			case "dst_phase_date":
    			ComChkObjValid(event.srcElement);
    			break;
    	}
    	
    }
    
    function obj_change(){
		var formObj = document.form;
		var obj = event.srcElement;
		switch(event.srcElement.name){
			case "src_vsl_cd":
				if(doActionIBSheet(sheetObj, formObj, SEARCH01)){
					formObj.src_skd_voy_no.focus();
            	}else{
            		formObj.src_vsl_cd.focus();
            		return false;
            	}
            	break;
			case "phase_rsn_code":
				formObj.phase_rsn_name.value = formObj.phase_rsn_code.value;
				break;
			case "src_phase_date":
//			case "dst_phase_date":
				if(!ComIsDate(obj.value, "ymd")){
					ComShowCodeMessage('VSK00003');
					obj.value = '';
					event.returnValue = false;
				}else{
					formObj.oldday.value = obj.value;
				}
				break;
		}
	}
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문자 입력 처리한다. <br>
     **/
    function eng_keypress() {
    	var name = event.srcElement.name;
    	switch(name){
    		case "src_vsl_cd":
    			ComKeyOnlyAlphabet('uppernum');
    			break;
    		
    		case "src_skd_dir_cd":
    			ComKeyOnlyAlphabet('upper');
    			break;
    			
    		case "src_skd_voy_no":
    		case "src_phase_date":
    			ComKeyOnlyNumber(event.srcElement); 
    			break;
    		default:
    	}
    }
    
    /**
     * Vessel Code Help 화면을 오픈한다.
     */
    function openVslCdHelp(){
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	//var sUrl = "/hanjin/VOP_VSK_0219.do?op_=0219";
    	var sUrl = "/hanjin/VOP_VSK_0219.do";
		var rVal = ComOpenPopupWithTarget(sUrl, 464, 500, "", "0,0", true);
		if(rVal){
			formObj.src_vsl_cd.value = rVal;
		}
    }
    
    /**
     * Voyage No Help 화면을 오픈한다.
     */
    function openVoyNoHelp(){
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	var sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd=" + formObj.src_vsl_cd.value;
		ComOpenPopupWithTarget(sUrl, 340, 420, "skd_voy_no:src_skd_voy_no|skd_dir_cd:src_skd_dir_cd", "0,0", true);
    }
    
    function changePortList(){
    	var formObj = document.form;
    	var vpsPortCd;
    	
    	// 이전 Port List 제거
    	for(i=0, m=formObj.src_port_cd.options.length; i<m; i++){
    		formObj.src_port_cd.options.remove(0);
    	}
    	
    	if(formObj.src_skd_dir_cd.selectedIndex=="0"){
    		// 첫번째 Direction Port List
    		vpsPortCd = formObj.firstPortCds.value.split("|");
    	}else{
    		// 두번째 Direction Port List
    		vpsPortCd = formObj.secondPortCds.value.split("|");
    	}
    	
    	for(i=0; i<vpsPortCd.length; i++){
			formObj.src_port_cd.options[formObj.src_port_cd.options.length] = new Option(vpsPortCd[i], vpsPortCd[i]);
		}
    }
    
    /* 개발자 작업  끝 */
    