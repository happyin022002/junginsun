
var sheetObjects = new Array();
var sheetCnt = 0;

var optionflag = 'N';
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
                

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
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
                    //전체 너비 설정
                    style.height =0;
                    SheetWidth = 0;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "STS| |Container No.|COP No.|BKG No.|B/L No.|VVD|COP_EXPT_NO|NTFD_SUBC_ID|subsc_expt_no" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,    "",     false,          "",       dfNone,   		0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 10,  daCenter,  false,    "ibflag",        false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   20,    daCenter,  false,    "dtcheck",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,    "cntr_no",        false,          "",       dfNone,     	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,    "cop_no",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,    "bkg_no",        false,          "",       dfNone,     	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,    "bl_no",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "vvd_no",        false,          "",       dfNone,     	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  false,    "cop_expt_no",        false,          "",       dfNone,     	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  false,    "ntfd_subsc_id",        false,          "",       dfNone,     	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  false,    "cop_expt_no_",        false,          "",       dfNone,     	0,     true,       true);

               }
                break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,isAppend) {
        sheetObj.ShowDebugMsg = false;
        var actionvalue = 'N';
        var cop_dtl_seq = document.form.cop_dtl_seq.value;
        var cop_no = document.form.cop_no.value;
        var cop_grp_seq = document.form.cop_grp_seq.value;
        var vvd = document.form.vvd.value;
        var vps_port_cd = document.form.vps_port_cd.value;
        var vps_evnt_tp_cd = document.form.vps_evnt_tp_cd.value;
        var act_cd =  document.form.act_cd.value;
        var nod_cd =  document.form.nod_cd.value;
        var estm_dt =  document.form.estm_dt.value;
        var act_dt =  document.form.act_dt.value;
        switch(sAction) {
            
           case IBSEARCH:      //조회
                //if(validateForm(sheetObj,formObj,sAction))
                //       if(!comCheckRequiredField(formObj)) return;
                if(formObj.check1.status == true){
                    formObj.f_cmd.value = COMMAND01;
                    actionvalue = 'Y';
                    if(cop_dtl_seq == '' || cop_no == '' || cop_grp_seq == ''){
                        alert("Please,input the default option data");
                        return false;
                    }
                }else  if(formObj.check2.status == true){
                    formObj.f_cmd.value = COMMAND02;
                    actionvalue = 'Y';
                    
                }else  if(formObj.check3.status == true){
                    formObj.f_cmd.value = COMMAND03;
                    actionvalue = 'Y';
                }else  if(formObj.check4.status == true){
                    formObj.f_cmd.value = COMMAND04;
                    actionvalue = 'Y';
                    if(vvd == '' || vps_port_cd == '' || vps_evnt_tp_cd == ''){
                        alert("Please,input the default option data");
                        return false;
                    }
                }else  if(formObj.check5.status == true){
                    formObj.f_cmd.value = COMMAND06;
                    actionvalue = 'Y';
                    if(cop_no == '' || act_cd == '' || nod_cd == '' ){
                        alert("Please,input the default option data");
                        return false;
                    }
                    //alert(command06);
                }else  if(formObj.check6.status == true){
                    formObj.f_cmd.value = COMMAND07;
                    actionvalue = 'Y';
                    if(cop_dtl_seq == '' || cop_no == '' || cop_grp_seq == '' ){
                        alert("Please,input the default option data");
                        return false;
                    }
                }
                if(actionvalue == 'N'){ 
                    alert("");                    
                    showErrMessage(getMsg('COM12176',''));  
                    return false;
                }else{ 
                    
                }
                sheetObj.DoSearch4Post("BATCH_TESTGS.do", FormQueryString(formObj));                
                var issuccess = sheetObj.EtcData("issuccess");
                //document.form.successflag.vlaue = issuccess;
                alert(issuccess);
                break;
           
        }
    }
      
    function onCheck(checkname){
        
        if(document.getElementById(checkname).checked == true ){
            if(optionflag == 'Y'){
                alert("only one select!!!!");
                document.getElementById(checkname).checked = false;
                return false;
            }
            if(checkname == 'check1'){
                optionflag = 'Y';
                document.getElementById("cop_dtl_seq").disabled  = false;
                document.getElementById("cop_no").disabled = false;
                document.getElementById("cop_grp_seq").disabled = false;
                
                document.getElementById("vvd").disabled = true;
                document.getElementById("vps_port_cd").disabled = true;
                document.getElementById("vps_evnt_tp_cd").disabled = true;
                
                 document.getElementById("act_cd").disabled = true;
                document.getElementById("nod_cd").disabled = true;
                
                document.getElementById("estm_dt").disabled = true;
                document.getElementById("act_dt").disabled = true;
                
                document.getElementById("vvd").value = '';
                document.getElementById("vps_port_cd").value = '';
                document.getElementById("vps_evnt_tp_cd").value = '';
                document.getElementById("act_cd").value = '';
                document.getElementById("nod_cd").value = '';
                
                document.getElementById("estm_dt").value = '';
                document.getElementById("act_dt").value = '';
            }
            if(checkname == 'check2'){
                optionflag = 'Y';
                
            }
            if(checkname == 'check3'){
                optionflag = 'Y';
            }
            if(checkname == 'check4'){
                optionflag = 'Y';                
                document.getElementById("cop_dtl_seq").disabled = true;
                document.getElementById("cop_no").disabled = true;
                document.getElementById("cop_grp_seq").disabled = true;
                
                document.getElementById("vvd").disabled = false;
                document.getElementById("vps_port_cd").disabled = false;
                document.getElementById("vps_evnt_tp_cd").disabled = false;
                
                 document.getElementById("act_cd").disabled = true;
                document.getElementById("nod_cd").disabled = true;
                
                document.getElementById("estm_dt").disabled = true;
                document.getElementById("act_dt").disabled = true;
                
                document.getElementById("cop_dtl_seq").value = '';
                document.getElementById("cop_no").value = '';
                document.getElementById("cop_grp_seq").value = '';
                document.getElementById("act_cd").value = '';
                document.getElementById("nod_cd").value = '';
                
                document.getElementById("estm_dt").value = '';
                document.getElementById("act_dt").value = '';
            }
            if(checkname == 'check5'){
                optionflag = 'Y';                
                document.getElementById("cop_dtl_seq").disabled = true;
                document.getElementById("cop_no").disabled = false;
                document.getElementById("cop_grp_seq").disabled = true;
                
                document.getElementById("vvd").disabled = true;
                document.getElementById("vps_port_cd").disabled = true;
                document.getElementById("vps_evnt_tp_cd").disabled = true;
                
                document.getElementById("act_cd").disabled = false;
                document.getElementById("nod_cd").disabled = false;
                
                document.getElementById("estm_dt").disabled = false;
                document.getElementById("act_dt").disabled = false;
                
                document.getElementById("cop_dtl_seq").value = '';
                document.getElementById("cop_no").value = '';
                document.getElementById("cop_grp_seq").value = '';
                document.getElementById("vvd").value = '';
                document.getElementById("vps_port_cd").value = '';
                document.getElementById("vps_evnt_tp_cd").value = '';
            }
            if(checkname == 'check6'){
                optionflag = 'Y';                
                document.getElementById("cop_dtl_seq").disabled = false;
                document.getElementById("cop_no").disabled = false;
                document.getElementById("cop_grp_seq").disabled = false;
                
                document.getElementById("vvd").disabled = true;
                document.getElementById("vps_port_cd").disabled = true;
                document.getElementById("vps_evnt_tp_cd").disabled = true;
                
                document.getElementById("act_cd").disabled = true;
                document.getElementById("nod_cd").disabled = true;
                
                document.getElementById("estm_dt").disabled = false;
                document.getElementById("act_dt").disabled = false;
                
                document.getElementById("nod_cd").value = '';
                //document.getElementById("cop_no").value = '';
                document.getElementById("act_cd").value = '';
                document.getElementById("vvd").value = '';
                document.getElementById("vps_port_cd").value = '';
                document.getElementById("vps_evnt_tp_cd").value = '';
            }
        }else{
            if(checkname == 'check1'){
                optionflag = 'N';
                document.getElementById("cop_dtl_seq").disabled = true;
                document.getElementById("cop_no").disabled = true;
                document.getElementById("cop_grp_seq").disabled = true;
                
                document.getElementById("cop_dtl_seq").value = '';
                document.getElementById("cop_no").value = '';
                document.getElementById("cop_grp_seq").value = '';
            }
            if(checkname == 'check2'){
                optionflag = 'N';
                
            }
            if(checkname == 'check3'){
                optionflag = 'N';
            }
            if(checkname == 'check4'){
                optionflag = 'N';
                document.getElementById("vvd").disabled = true;
                document.getElementById("vps_port_cd").disabled = true;
                document.getElementById("vps_evnt_tp_cd").disabled = true;
                
                document.getElementById("vvd").value = '';
                document.getElementById("vps_port_cd").value = '';
                document.getElementById("vps_evnt_tp_cd").value = '';
            }if(checkname == 'check5'){
                optionflag = 'N';                
                document.getElementById("cop_no").disabled = true;
                
                document.getElementById("act_cd").disabled = true;
                document.getElementById("nod_cd").disabled = true;
                
                document.getElementById("estm_dt").disabled = true;
                document.getElementById("act_dt").disabled = true;
                
                document.getElementById("cop_no").value = '';
                
                document.getElementById("act_cd").value = '';
                document.getElementById("nod_cd").value = '';
                
                document.getElementById("estm_dt").value = '';
                document.getElementById("act_dt").value = '';

            }
            if(checkname == 'check6'){
                optionflag = 'N';                
                document.getElementById("cop_no").disabled = true;
                
                document.getElementById("cop_grp_seq").disabled = true;
                document.getElementById("cop_dtl_seq").disabled = true;
                
                document.getElementById("estm_dt").disabled = true;
                document.getElementById("act_dt").disabled = true;
                
                document.getElementById("cop_no").value = '';
                
                document.getElementById("cop_grp_seq").value = '';
                document.getElementById("cop_dtl_seq").value = '';
                
                document.getElementById("estm_dt").value = '';
                document.getElementById("act_dt").value = '';

            }
          
        }
        
        
    }