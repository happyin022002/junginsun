/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_SPC_0099.js
*@FileTitle : Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.24
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.24 진마리아
* 1.0 Creation
* 2013.01.24 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.03.06 [CHM-20142960] SMP/Allocation control보완 요청 - 재생성 기능 추가
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
     * @class ESM_SPC_0099 : ESM_SPC_0099 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0099() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.doActionIBSheet 		= doActionIBSheet;
    }
    
   	/* 개발자 작업	*/
    
    // 공통전역변수
    var comObjects = new Array();
    var comboCnt   = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	
        /*******************************************************/
    	var formObject = document.form;
    	
       	try {
       		var srcName = window.event.srcElement.getAttribute("name");
       		
       		switch(srcName) {
	       		
	       		case "btn_ok":
	       			okData();
	       			break;
	       			
       			case "btn_close":
       				window.returnValue = "";
       				self.close();
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
     * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
     * 상단에 정의
     */
    function setComboObject(combo_obj) {
    	comObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
     * 추가한다
     */
    function loadPage() {
    	var frm = document.form;
    	if(frm.src.value=="CONFIRM"){
			document.getElementById("week_txt").innerText = "Version Week";
		}else{
			document.getElementById("week_txt").innerText = "Performance Week";
		}
    	 
    	SpcSearchOptionYear("from_year");
		SpcSearchOptionWeek("from_week");
		SpcSearchOptionYear("to_year");
		SpcSearchOptionWeek("to_week");
		
		if(frm.src.value=="CONFIRM"){
			var toPrd = frm.cfm_ver_prd_to.value;
	        var expt_yrwk = frm.expt_yrwk_hidden.value;

			if(toPrd != ""){
				frm.to_year.value = toPrd.substring(0,4);
				frm.to_week.value = toPrd.substring(4,6);
			}else{
//				frm.to_year.value = "";
				frm.to_week.value = "";
			}
            frm.expt_yrwk.value =expt_yrwk;

			frm.from_year.focus();
		} else if(frm.src.value=="REGENERATION"){
			var toPrd = frm.re_cre_prd_to.value;
			if(toPrd != ""){
				frm.from_year.value = toPrd.substring(0,4);
				frm.from_week.value = toPrd.substring(4,6);
				frm.to_year.value   = toPrd.substring(9,13);
				frm.to_week.value   = toPrd.substring(13,15);
//				frm.from_year.disabled = true;
//				frm.from_week.disabled = true;
//				frm.to_year.disabled   = true;
//				frm.to_week.disabled   = true;
			} else {
				frm.from_year.value = "";
				frm.from_week.value = "";
				frm.to_year.value   = "";
				frm.to_week.value   = "";
			}
		} else { //CREATION
//			frm.from_year.value = "";
			frm.from_week.value = "";
			
			frm.from_year.focus();
		}
    }
    
	
    function okData() {
    	var frm = document.form;
        var from_year = frm.from_year.value
        var from_week = frm.from_week.value
        var to_year   = frm.to_year.value
        var to_week   = frm.to_week.value;
        var expt_yrwk   = frm.expt_yrwk.value;

        
        if(validation()){
            expt_yrwk= expt_yrwk.replace(/ /gi, ""); 
            
        	var rtn = from_year
        	+ from_week
        	+ "|"
        	+ to_year
        	+ to_week
        	+ "|"
        	+ expt_yrwk;
        	alert(rtn)
        	if(frm.src.value=="CREATION"){
        		var popup = window.showModalDialog("ESM_SPC_0094.do?", window, "dialogWidth:450px;dialogHeight:330px;scroll:no");
        		if(popup!="" && popup!=undefined){
        			var opener = window.dialogArguments;
        			opener.document.form.ctrl_grp_xml.value = frm.ctrl_grp_xml.value;
        			window.returnValue = rtn;
        			window.close();
        		}
        	}else{
        		window.returnValue = rtn;
        		window.close();
        	}
        	
        }
    }
    
function validation(){
	var formObj = document.form;
	
	var from_year = formObj.from_year.value;
    var from_week = formObj.from_week.value;
    var to_year   = formObj.to_year.value;
    var to_week   = formObj.to_week.value;
    var firVirStWk = formObj.fir_vir_st_wk.value
    var expt_yrwk   = ComTrim(formObj.expt_yrwk.value);
 
    
    if(from_year=="" || from_week=="" || to_year=="" || to_week==""){
    	ComShowCodeMessage("COM130201", "All Period");
    	return false;
    }
    if(Number(from_year+""+from_week)>Number(to_year+""+to_week)){
    	ComShowCodeMessage("COM12133", "To week", "From week", "greater");
    	return false;
    }
    if(formObj.src.value=="CONFIRM" && firVirStWk!=""){ //첫 version이 컨펌되어 있는 상태일때, 첫 ver의 st week보다 앞당길 수 없음.
    	if(Number(from_year+""+from_week)<Number(formObj.fir_vir_st_wk.value)){
    		ComShowMessage("Start Week of First Version is "+firVirStWk+". Choose Start Week after then.");
    		return false;
    	}
    }
    if( expt_yrwk != ""){
        var expt_arr = expt_yrwk.split(",");
        var bCheck = true;

        for(var i=0 ; i < expt_arr.length ; i++){
            bCheck = true;
            expt_arr[i]=ComTrim(expt_arr[i])
            //alert(expt_arr[i].substring(0,4))
            // alert(expt_arr[i].substring(4,6))
            if( expt_arr[i].length != 6){
                bCheck = false;
                break;
            }else if( expt_arr[i] < (from_year + from_week)
                    ||  expt_arr[i]  > (to_year+to_week) ){
                bCheck = false;
                break;
            } 
        }
        if( bCheck == false){
            ComShowCodeMessage("COM12114", "Exception Week");//Please check {?msg1}
            return false;   
        }
    }
    return true;
}
     
	/* 개발자 작업  끝 */