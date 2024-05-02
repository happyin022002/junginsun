/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1120.js
*@FileTitle  : Europe Advanced Manifest - ENS Monitoring
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var combo1=null;
var comboCnt=0;   

var intervalId="";

							
    //Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	// Event handler processing by button name */
	function processButtonClick(){
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		var srcName=ComGetEvent("name");
	 	switch(srcName) {
	        case "btn_retrieve":
	        	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	        	break;
	        case "btn_new":
	        	formObject.reset();
	        	document.getElementById("p_pol_ofc").style.display="";
	        	document.getElementById("p_bkg_ofc").style.display="none";
	        	rhq.index=-1;
	        	sheetObjects[0].RemoveAll();
	        	//div_init();    
	         
	        	break;
	        case "btn_downexcel":
	     	
	        	if(sheetObject1.RowCount() < 1){//no data
	        		ComShowCodeMessage("COM132501");
	        	}else{
	        		//     		sheetObject1.Down2Excel({ HiddenColumn:-1});
	        		sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), Merge:1});
	        	}
	        	break;
	        case "btn_date":    
	        	var cal=new ComCalendarFromTo();
	        	cal.setEndFunction("endDateSet");
	        	cal.select(formObject.p_from_dt, formObject.p_to_dt,'yyyy-MM-dd');
	        	break;
	    } // end switch
	}
		
	/**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
	function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++]=sheet_obj;
	}
	
	/**
     * registering combo Object at comboObjects list 
     * @param combo_obj
     * @return
     */
	function setComboObject(combo_obj) {
	    comboObjects[comboCnt++]=combo_obj; 
	}
	
	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */                     
	function loadPage() {
	    var formObj=document.form;
	    for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	      //initializing MultiCombo
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].id);
	    }
	    
	    initControl();
	}

	function initControl() {
	    var formObject=document.form;
	    axon_event.addListenerForm  ('click', 'bkg_click',  formObject); //- onClick     
	    axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
	    axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
	    axon_event.addListenerForm  ('change', 'bkg_change', formObject);
	    axon_event.addListenerFormat('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
	    axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
	    axon_event.addListenerFormat('keyup', 'obj_KeyUp', formObject); //- 키보드 입력할때
	    axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');
	    // IBMultiCombo초기화
	    for(var k=0; k<comboObjects.length; k++){
	        initCombo(comboObjects[k]);
	    }
	    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);       
	    
	    
	}

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
	* @param {String} comboId 필수,combo ID
	* @return 없음. 
	 */ 
	function initCombo(comboObj, comboId) {
	    comboObj.SetDropHeight(150);
	}
	
	/*********************** KEY EVENT START ********************/   
	/**
	 * HTML Control의 onBlur을 제어한다.
	 **/
	function bkg_blur() {
	    var formObj=document.form; 
	    switch (ComGetEvent("name")) {
	        case "p_from_dt":
	            ComAddSeparator(ComGetEvent());
	                break;              
	        case "p_to_dt":
	            ComAddSeparator(ComGetEvent());
	                break;              
	        case "bkg_from_dt":
	            ComAddSeparator(ComGetEvent());
	                break;              
	        case "bkg_to_dt":
	            ComAddSeparator(ComGetEvent());
	                break;              
	            default:
	                break;
	    }
	}           
	
	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_focus(){
	    //입력Validation 확인하기
	    switch(ComGetEvent("name")){  
	        case "p_from_dt":
	            ComClearSeparator(ComGetEvent());
	                break;
	        case "p_to_dt":
	            ComClearSeparator(ComGetEvent());
	                break;
	    }
	}       
	
	function div_init(){
		sheetObjects[0].RemoveAll();
	    form.div_total_bl_cnt.value="";
	    form.div_acc_bl_cnt.value="";
	    form.div_rej_bl_cnt.value="";
	    form.div_nrcv_bl_cnt.value="";
	    form.div_donld_bl_cnt.value="";
	    form.div_unsent_bl_cnt.value="";
	    form.div_total_amd_cnt.value="";
	    form.div_total_vvd_cnt.value="";
	    form.div_total_ens_amt.value="";
//	    form.div_total_shaas_ens.value="";
//	    form.div_total_nycna_ens.value="";
//	    form.div_total_hamur_ens.value="";
//	    form.div_total_sinwa_ens.value="";
	    form.div_total_mcf_amt.value="";
//	    form.div_total_shaas_mcf.value="";
//	    form.div_total_nycna_mcf.value="";
//	    form.div_total_hamur_mcf.value="";
//	    form.div_total_sinwa_mcf.value="";

		for ( var j = 1; j < rhq.GetItemCount(); j++)
		{
        	// 현재는 RHQ 가 8개 밖에 없어서 jsp 에서 총 8개의 폼만 생성해두었음
        	// 추후 RHQ 가 더 늘어나게 되면 동적으로 구성된 화면 수정 필요
        	if(j < 9){
        		eval("form.tot_ens_val" + j).value = "";
        		eval("form.tot_mcf_val" + j).value = "";
        	}
		}
	}
	
	function bkg_click(){
	    switch(ComGetEvent("name")){  
	    case "p_rhq_gb":
            var ofcTitle = "BKG OFC";
	        if(document.form.p_rhq_gb[0].checked){
	            // 초기화
	            ofcTitle = "POL OFC";
	            document.getElementById("p_pol_ofc").style.display="";
	            document.getElementById("p_bkg_ofc").style.display="none";
	            
	        } else if(document.form.p_rhq_gb[1].checked) {
	            // 초기화
	            document.getElementById("p_pol_ofc").style.display="none";
	            document.getElementById("p_bkg_ofc").style.display="";
	        }
            div_init();
    		sheetObjects[0].SetCellValue(0, "bkg_ofc_cd", ofcTitle);
    		sheetObjects[0].SetCellValue(1, "bkg_ofc_cd", ofcTitle);
    		sheetObjects[0].SetCellValue(2, "bkg_ofc_cd", ofcTitle);
    		
	            break;
	    }
	}
	
	/**
	* 조회후 이벤트 처리 >>> 폰트 칼라변경
	*/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	    with (sheetObj) {
	        var redColor="#FF0000";
	        for(var i=HeaderRows(); i<= LastRow(); i++) {
	            if (GetCellValue(i,"ens_snt_rej") != "0") {
	                SetCellFontColor(i,"ens_snt_rej",redColor);
	            }
	
	            if (GetCellValue(i,"ens_snt_nrcv") != "0") {
	                SetCellFontColor(i,"ens_snt_nrcv",redColor);
	            }
	
	            if (GetCellValue(i,"ens_unsnt_cnt") != "0") {
	                SetCellFontColor(i,"ens_unsnt_cnt",redColor);
	            }
	        }
	        ColumnSort("1|2|3|4|5|6");
	    }//end width
	}
	
	/**
	* 컬럼이동 전 validation 처리 >>> 이동취소
	*/
	function sheet1_OnBeforeColumnMove(sheetObj, Col, NewPos) {
	    with (sheetObj) {
	        if(NewPos>6){
	         MoveColumnFail(true);
	        }
	        if(Col>6){
	         MoveColumnFail(true);
	        }
	    }
	}
	
	/**
	* 컬럼이동 후 이벤트 처리 >>> 재소트
	*/
	function sheet1_OnAfterColumnMove(sheetObj, Col, NewPos) {
	    with (sheetObj) {
	        var colNo="";
	        for(var i=NewPos; i< LastCol(); i++) {
	         colNo=colNo + "|" + i;
	        }
	        ColumnSort(colNo);
	    }
	}

	function endDateSet(){
	    if (ComIsNull(form.p_from_mt)) {
	        form.p_from_mt.value="00:00";
	    }
	    if (ComIsNull(form.p_to_mt)) {
	        form.p_to_mt.value="23:59";
	    }
	}
	
	/**
	 * Sheet관련 프로세스 처리<br>
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	        case IBCLEAR: // 화면 로딩시 코드 조회
	            formObj.f_cmd.value=COMMAND01;
	            var sXml=sheetObj.GetSearchData("ESM_BKG_1120GS.do", FormQueryString(formObj));
	            var arrXml=sXml.split("|$$|");
	            
	            if (arrXml.length > 0) 
	                ComXml2ComboItem(arrXml[0], rhq, "val", "desc");
	            rhq.index=-1;

	            for (var i=1; i<rhq.GetItemCount(); i++)
            	{
	            	// 현재는 RHQ 가 8개 밖에 없어서 jsp 에서 총 8개의 폼만 생성해두었음
	            	// 추후 RHQ 가 더 늘어나게 되면 동적으로 구성된 화면 수정 필요
	            	if(i < 9){
		            	var rhqText = rhq.GetText(i,  0);
		            	if (i > 1) rhqText = "+&nbsp;&nbsp;" + rhq.GetText(i,  0);
		            	document.getElementById('rhq_ens_txt' + i ).innerHTML= rhqText;
		            	document.getElementById('rhq_ens_val' + i).innerHTML= "<input type='text' style='width:60px;text-align:right;' class='input2' name='tot_ens_val" + i + "'/>";
		            	
		            	document.getElementById('rhq_mcf_txt' + i ).innerHTML= rhqText;
		            	document.getElementById('rhq_mcf_val' + i).innerHTML= "<input type='text' style='width:60px;text-align:right;' class='input2' name='tot_mcf_val" + i + "'/>";
	            	}
            	}
	        break;
	        case IBSEARCH : // 조회
	            if(!validateForm(sheetObj,formObj,sAction)) return;
	            //sheetObj.RenderSheet(0);
	            sheetObj.SetWaitImageVisible(1);
	            formObj.f_cmd.value=SEARCH;
	            sheetObj.RemoveAll();
	            var sXml=sheetObj.GetSearchData("ESM_BKG_1120GS.do", FormQueryString(formObj));
	            sheetObj.LoadSearchData(sXml,{Sync:1} );
	            if(ComGetEtcData(sXml,"total_bl_cnt") == undefined){
	                formObj.div_total_bl_cnt.value="0";
	                formObj.div_acc_bl_cnt.value="0";
	                formObj.div_rej_bl_cnt.value="0";
	                formObj.div_nrcv_bl_cnt.value="0";
	                formObj.div_donld_bl_cnt.value="0";
	                formObj.div_unsent_bl_cnt.value="0";
	                formObj.div_total_amd_cnt.value="0";
	                formObj.div_total_vvd_cnt.value="0";
	                formObj.div_total_ens_amt.value="0";
//	                formObj.div_total_shaas_ens.value="0";
//	                formObj.div_total_nycna_ens.value="0";
//	                formObj.div_total_hamur_ens.value="0";
//	                formObj.div_total_sinwa_ens.value="0";
	                formObj.div_total_mcf_amt.value="0";
//	                formObj.div_total_shaas_mcf.value="0";
//	                formObj.div_total_nycna_mcf.value="0";
//	                formObj.div_total_hamur_mcf.value="0";
//	                formObj.div_total_sinwa_mcf.value="0";
	            }else{
	                formObj.div_total_bl_cnt.value=ComGetEtcData(sXml,"total_bl_cnt");
	                formObj.div_acc_bl_cnt.value=ComGetEtcData(sXml,"acc_bl_cnt");
	                formObj.div_rej_bl_cnt.value=ComGetEtcData(sXml,"rej_bl_cnt");
	                formObj.div_nrcv_bl_cnt.value=ComGetEtcData(sXml,"nrcv_bl_cnt");
	                formObj.div_donld_bl_cnt.value=ComGetEtcData(sXml,"donld_bl_cnt");
	                formObj.div_unsent_bl_cnt.value=ComGetEtcData(sXml,"unsent_bl_cnt");
	                formObj.div_total_amd_cnt.value=ComGetEtcData(sXml,"total_amd_cnt");
	                formObj.div_total_vvd_cnt.value=ComGetEtcData(sXml,"total_vvd_cnt");
	                formObj.div_total_ens_amt.value=ComGetEtcData(sXml,"total_ens_amt");
//	                formObj.div_total_shaas_ens.value=ComGetEtcData(sXml,"total_shaas_ens");
//	                formObj.div_total_nycna_ens.value=ComGetEtcData(sXml,"total_nycna_ens");
//	                formObj.div_total_hamur_ens.value=ComGetEtcData(sXml,"total_hamur_ens");
//	                formObj.div_total_sinwa_ens.value=ComGetEtcData(sXml,"total_sinwa_ens");
	                formObj.div_total_mcf_amt.value=ComGetEtcData(sXml,"total_mcf_amt");
//	                formObj.div_total_shaas_mcf.value=ComGetEtcData(sXml,"total_shaas_mcf");
//	                formObj.div_total_nycna_mcf.value=ComGetEtcData(sXml,"total_nycna_mcf");
//	                formObj.div_total_hamur_mcf.value=ComGetEtcData(sXml,"total_hamur_mcf");
//	                formObj.div_total_sinwa_mcf.value=ComGetEtcData(sXml,"total_sinwa_mcf");
	            }
	            
	            
	            formObj.div_rej_bl_cnt.style.color="#FF0000";
				formObj.div_nrcv_bl_cnt.style.color="#FF0000";
				formObj.div_donld_bl_cnt.style.color="#FF0000";
				formObj.div_unsent_bl_cnt.style.color="#FF0000";   
	            
	            //sheetObj.RenderSheet(1);
	            sheetObj.SetWaitImageVisible(0);
	            break;
	    }//end switch
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	    switch(sAction) {
	        case IBSEARCH:
	            if (!ComIsNull(formObj.p_from_mt)) {
	                var from_mt_temp="";
	                var arr_mt=formObj.p_from_mt.value.split(":")
	                if(ComIsNull(arr_mt[0])){
	                    from_mt_temp="00:";
	                }else{
	                    if(eval(arr_mt[0])> 23 ) from_mt_temp="23:";
	                    else from_mt_temp=eval(arr_mt[0])< 10 ? "0"+eval(arr_mt[0])+":":arr_mt[0]+":";
	                }
	                if(ComIsNull(arr_mt[1])){
	                    from_mt_temp +="00";
	                }else{
	                    if(eval(arr_mt[1])> 59 ) from_mt_temp +="59";
	                    else from_mt_temp += eval(arr_mt[1])< 10 ? "0"+eval(arr_mt[1]):arr_mt[1];
	                }
	                formObj.p_from_mt.value=from_mt_temp;
	            }
	            if (!ComIsNull(formObj.p_to_mt)) {
	                var to_mt_temp="";
	                var arr_mt2=formObj.p_to_mt.value.split(":")
	                if(ComIsNull(arr_mt2[0])){
	                    to_mt_temp="00:";
	                }else{
	                    if(eval(arr_mt2[0])> 23 ) to_mt_temp="23:";
	                    else to_mt_temp=eval(arr_mt2[0])< 10 ? "0"+eval(arr_mt2[0])+":":arr_mt2[0]+":";
	                }
	                if(ComIsNull(arr_mt2[1])){
	                    to_mt_temp +="00";
	                }else{
	                    if(eval(arr_mt2[1])> 59 ) to_mt_temp +="59";
	                    else to_mt_temp += eval(arr_mt2[1])< 10 ? "0"+eval(arr_mt2[1]):arr_mt2[1];
	                }
	                formObj.p_to_mt.value=to_mt_temp;
	            }
	            if(form.p_pofe.value != "" && 
	                    (form.p_pofe.value.length < 5 || form.p_pofe.value.length > 7) ){
	                ComShowCodeMessage('BKG06065','POFE(5~7 Digits)');
	                return false;
	            }
	            if ( (!ComIsNull(formObj.p_from_dt) && !ComIsNull(formObj.p_to_dt)) ) {
	                if( ComGetDaysBetween(formObj.p_from_dt.value,formObj.p_to_dt.value) +1 > 31){
	                    ComShowCodeMessage('COM132001','Send/Received Date','31 Days');
	                    formObj.p_from_dt.focus();
	                    return false;
	                }
	                return true;
	            }
	            //기본포멧체크
	            if (ComIsNull(formObj.p_vvd)) {
	                if (ComIsNull(formObj.p_from_dt)) {
	                    ComShowCodeMessage('BKG00104','From Date');
	                    formObj.p_from_dt.focus();
	                    return false;    
	                }
	                if (ComIsNull(formObj.p_to_dt)) {
	                    ComShowCodeMessage('BKG00104','To Date');
	                    formObj.p_to_dt.focus();
	                    return false;    
	                }
	            }
	            break;
	    }
	    return true;
	}
	
	/**
	 * 조회조건 입력할 때 처리
	 */
	function obj_KeyUp() {
	    var formObject=document.form;
	    var srcName=ComGetEvent("name");
	    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	    var srcValue=window.event.srcElement.getAttribute("value");
	    if ((srcName == "p_vvd" || srcName == "p_pol") && ComChkLen(srcValue, srcMaxLength) == "2") {
	        ComSetNextFocus();
	    }
	}
	
	 /**
	  * 시트 초기설정값, 헤더 정의
	  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	  */
	 function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
	    var sheetID=sheetObj.id;
	    switch(sheetID) {
	        case "sheet1":
	            with(sheetObj){
	                var HeadTitle1="";
	                var HeadTitle2="";
	                var HeadTitle3="";
	                if(document.form.p_rhq_gb[0].checked){
	                    HeadTitle1="|VVD|LANE|POFE|RHQ|POL OFC|POL|B/L Count|ENS (B/L)|ENS (B/L)|ENS (B/L)|ENS (B/L)|ENS (B/L)|ENS (B/L)|Surcharge (USD)|Surcharge (USD)";
	                    HeadTitle2="|VVD|LANE|POFE|RHQ|POL OFC|POL|B/L Count|Sent|Sent|Sent|Sent|Unsent|Amend|ESD|AMA";
	                    HeadTitle3="|VVD|LANE|POFE|RHQ|POL OFC|POL|B/L Count|Acpt|Rjct|N.rcvd|DNL|Unsent|Amend|ESD|AMA";
	                } else if (document.form.p_rhq_gb[1].checked){
	                    HeadTitle1="|VVD|LANE|POFE|RHQ|BKG OFC|POL|B/L Count|ENS (B/L)|ENS (B/L)|ENS (B/L)|ENS (B/L)|ENS (B/L)|ENS (B/L)|Surcharge (USD)|Surcharge (USD)";
	                    HeadTitle2="|VVD|LANE|POFE|RHQ|BKG OFC|POL|B/L Count|Sent|Sent|Sent|Sent|Unsent|Amend|ESD|AMA";
	                    HeadTitle3="|VVD|LANE|POFE|RHQ|BKG OFC|POL|B/L Count|Acpt|Rjct|N.rcvd|DNL|Unsent|Amend|ESD|AMA";
	                }
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                headCount=ComCountHeadTitle(HeadTitle1);
	                
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
	//                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	                
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                                { Text:HeadTitle2, Align:"Center"},
	                                { Text:HeadTitle3, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                            {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lane",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"pofe",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rhq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pol",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bl_tot_cnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ens_snt_acc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ens_snt_rej",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ens_snt_nrcv",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ens_snt_donld",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ens_unsnt_cnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ens_amd_cnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:70,   Align:"Center",   ColMerge:0,   SaveName:"ens_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"mcf_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                                                                   
	                InitColumns(cols);
	                
	                SetEditable(1);
	                SetCountPosition(0);
	                SetSheetHeight(440);
	//                FitColWidth();
	                FitColWidth("9|7|9|8|8|7|8|5|5|5|5|6|5|6|6");
	            }
	
	            break;
	    }//end switch
	}
	 
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var form = document.form;
		var ensTot = new Array();
		var mcfTot = new Array();
		for (var i=1; i<rhq.GetItemCount(); i++)
		{
        	// 현재는 RHQ 가 8개 밖에 없어서 jsp 에서 총 8개의 폼만 생성해두었음
        	// 추후 RHQ 가 더 늘어나게 되면 동적으로 구성된 화면 수정 필요
        	if(i < 9){
        		ensTot[i-1] = 0;
        		mcfTot[i-1] = 0;
        	}
		}
		for (var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++)
		{
			for ( var j = 1; j < rhq.GetItemCount(); j++)
			{
            	// 현재는 RHQ 가 8개 밖에 없어서 jsp 에서 총 8개의 폼만 생성해두었음
            	// 추후 RHQ 가 더 늘어나게 되면 동적으로 구성된 화면 수정 필요
            	if(j < 9){
            		if (rhq.GetText(j,  0) == sheetObj.GetCellValue(i,"rhq"))
            		{
            			ensTot[j-1] += parseFloat(sheetObj.GetCellValue(i,"ens_amt"));
            			mcfTot[j-1] += parseFloat(sheetObj.GetCellValue(i,"mcf_amt"));
            		}
            	}
			}
		}
		for ( var j = 1; j < rhq.GetItemCount(); j++)
		{
        	// 현재는 RHQ 가 8개 밖에 없어서 jsp 에서 총 8개의 폼만 생성해두었음
        	// 추후 RHQ 가 더 늘어나게 되면 동적으로 구성된 화면 수정 필요
        	if(j < 9){
        		eval("form.tot_ens_val" + j).value = ensTot[j - 1];
        		eval("form.tot_mcf_val" + j).value = mcfTot[j - 1];
        	}
		}
	}