/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_S027.js
*@FileTitle  : SPP Repair Cancellation and Deletion
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
/* 개발자 작업	*/ 	
// 공통전역변수      
var tabObjects=new Array(); 
var tabCnt=0 ;  
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0; 
var msgFlag="";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_New": 
					doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[1],formObject,IBSAVE);
					break;		   	 
				case "btn_Delete":	 	
					doActionIBSheet(sheetObjects[1],formObject,IBDELETE);
					break;  
				case "btn_DownExcel": 
					if(sheetObjects[1].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
					}
					break;		
				case "btn_Retrieve": 
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
					break;
				case "btn_Detail": 
						if(sheetObjects[1].RowCount()== 0){
							ComShowCodeMessage("MNR00309");			
						} else {
							if(MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rqst_eq_no")) != ''){
								//있다면 팝업호출 
								var rqstEqNo=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rqst_eq_no");
								var rprRqstSeq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rpr_rqst_seq");
								var rprRqstVerNo=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rpr_rqst_ver_no");
								var eqKndCd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"eq_knd_cd");
								ComOpenPopup('/opuscntr/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd+"&spp_type=Y", 1024, 768, '', '0,0', false);   		
							}	    	 
						}		
					break;
				case "btns_calendar": 
					var cal=new ComCalendarFromTo();
					cal.select(form.fm_est_dt,  form.to_est_dt,  'yyyy-MM-dd'); 
					break;	
				//멀티입력
				case "eq_no_multi1":  
					rep_Multiful_inquiry("rqst_eq_no"); 
					break;	
				//멀티입력
				case "eq_no_multi2": 
					rep_Multiful_inquiry("rqst_ref_no"); 
					break; 	
				//멀티입력
				case "eq_no_multi3": 
				    rep_Multiful_inquiry("wo_no"); 
					break;	
				case "btn_vndr":      
					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;   
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		MnrWaitControl(true);
		initControl();   
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        } 
		for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);   
	    }	
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);   
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) { 
			case "sheet1": 		
                with (sheetObj) {
                    SetVisible(false);
				}		 
            case "sheet2":      // sheet1 init
                with (sheetObj) {
	                var HeadTitle1="|Sel.|Seq.|EST No.|EQ No.|TP/SZ|AGMT Office|C.Office|System Verify Result|Dmg Flag|TPB|CURR|Amount|Status|Creation Date";
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                    {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		                    {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rqst_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rqst_eq_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Combo",     Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"mnr_vrfy_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dmg_flag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"total_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rpr_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_ver_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	                InitColumns(cols);
	                SetEditable(1);
	                SetSheetHeight(400);
			}			
         	break;	
        }
    }
    // Sheet관련 프로세스 처리 
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {	
          case IBSEARCH:      //목록조회    
                 if(validateForm(sheetObj,formObj,sAction)){    
						formObj.f_cmd.value=SEARCH;  
						var sParam=FormQueryString(formObj);
						sheetObj.DoSearch("EES_MNR_S027GS.do",sParam );
				  } 	        
                break; 		
			case IBSEARCH_ASYNC01:	//조회(sevice provider No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					if(Number(formObj.vndr_seq.value)){
						//서비스 프로바이더 조회     
						var sCondition=new Array (  
							new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
						)                             
						//조회 값이 있다면 세팅
						var comboList=MnrComSearchCombo(sheetObjects[0],sCondition); 
						if(comboList[0] != null){  
							var tempText=comboList[0][0].split("|");  
							formObj.vndr_nm.value=tempText[1];   
						} else {        
							ComShowCodeMessage("MNR00005", "Service Provider");              
							ComSetObjValue(formObj.vndr_nm, "");  
							ComSetObjValue(formObj.vndr_seq, ""); 
							ComSetFocus(formObj.vndr_seq);
						}  
					} else {        
						ComShowCodeMessage("MNR00005", "Service Provider");              
						ComSetObjValue(formObj.vndr_nm, "");  
						ComSetObjValue(formObj.vndr_seq, ""); 
						ComSetFocus(formObj.vndr_seq);
					}  
				}	
				break; 		
			case IBDELETE:        //Delete 
	             if(validateForm(sheetObj,formObj,sAction)){ 
						formObj.f_cmd.value=COMMAND02;   	   
						var sParam=sheetObjects[1].GetSaveString(false, true,"del_chk");
						sParam=ComSetPrifix(sParam,"sheet2"); 
					    sParam += "&" + FormQueryString(formObj); 	
					    var sXml=sheetObj.GetSaveData("EES_MNR_S027GS.do", sParam);
						msgFlag="Delete"; 					 	  	
						sheetObjects[1].LoadSaveData(sXml);
				  }		
				 break;	
			case IBCLEAR:      // 초기화 
				MnrWaitControl(true);
				sheetObj.SetWaitImageVisible(0);
				//START 
				formObj.reset();  
				formObj.vndr_seq.value=ComLpad(formObj.vndr_seq.value,6,"0");
				//콤보 초기화	  
				for(var i=0; i < comboObjects.length;i++){ 
					comboObjects[i].SetSelectCode("-1");
					comboObjects[i].RemoveAll();
				}	 	
				//공통 콤보 조회 
				var sCondition=new Array ( 
					//multi 콤보 설정
					new Array("MnrGenCd","CD00073", "COMMON"),
					new Array("MnrGenCd","","CUSTOM9"),
					//sheetObjects[1] 콤보 설정        
					new Array("MnrGenCd","CD00004", "COMMON"),
					new Array("MnrGenCd","CD00008", "COMMON") 
				) 	
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				if(comboList[0] != null){	 	
					for(var j=0; j < comboList[0].length;j++){ 
						var tempText=comboList[0][j].split("|"); 
						status_cd.InsertItem(j , tempText[1] ,tempText[0]);
					} 	   	    	         			  	    
					status_cd.SetSelectIndex(0);
				}	
				if(comboList[1] != null){	 	
					for(var j=0; j < comboList[1].length;j++){ 
						var tempText=comboList[1][j].split("|"); 
						eq_knd_cd.InsertItem(j , tempText[1] ,tempText[0]);
					} 	   	    	         			  	    
					eq_knd_cd.SetSelectIndex(0);  
				}		    
				var sheetComboText="";	 		 
				var sheetComboCode="";			
				var sheetComboDefault=new Array();  
				var comboSaveNames=new Array();
				comboSaveNames[0]="mnr_vrfy_tp_cd";
				comboSaveNames[1]="rpr_sts_cd";          
				for(var i=2; i < comboList.length;i++){
					if(comboList[i] != null){
						sheetComboText=""; 
						sheetComboCode="";
						for(var j=0; j < comboList[i].length;j++){ 
							var tempText=comboList[i][j].split("|");    
							sheetComboCode +=  tempText[0] + "|";   
							sheetComboText +=  tempText[1] + "|";  
							if(j == 0){
								sheetComboDefault[i - 2]=tempText[0];  	       	
							}	 	   		   
						}    	   			
						//sheetObjects[1] 쉬트 콤보 설정  
						sheetComboCode=MnrDelLastDelim(sheetComboCode); 																				
						sheetComboText=MnrDelLastDelim(sheetComboText);  
						sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 2], sheetComboText, sheetComboCode ,sheetComboDefault[i - 2]); 
					}						      
				}
				formObj.fm_est_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "D", -7); 	         
				formObj.to_est_dt.value=ComGetNowInfo("ymd"); 
				//END 
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false); 
				//DELETE 버튼 다시 세팅  SS만 삭제 가능
				if(status_cd.GetSelectCode()== "SS")
				{ 
					ComBtnEnable("btn_Delete");
				} else{
					ComBtnDisable("btn_Delete");
				}
                break;
        }
    }
	/**  
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){	     
    	comboObjects[comboCnt++]=combo_obj;  
	} 
	/**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {   
	    var formObject=document.form
	    switch(comboNo) {      
			   default :   
		           with (comboObj) { 
				   SetColAlign(0, "left");
					   SetDropHeight(200);
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
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                }
             break;
         }	
    }
	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index 
	 */	
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;      
		if ( aryPopupData.length > 0 ) {  
			formObj.vndr_seq.value=ComLpad(aryPopupData[0][2],6,"0");
			formObj.vndr_nm.value=aryPopupData[0][4];
		}		
	}	
	/** 
	 * rep_Multiful_inquiry의 리턴처리 메서드
	 * @param	{Array}		rowArray	반환되는 Array
	 * @param	{String}	return_val	반환되는 form element명
	 */
	function getMnr_Multi(rowArray,return_val) { 
 		var formObj=document.form; 	 
 		var tempText="";       
 		//초기화     
		eval("document.form." + return_val + ".value='';"); 
 		for(var i=0; i < rowArray.length; i++) {     
 			tempText +=  rowArray[i] + ',';      
 		}     
 		//마지막에 ,를 없애기 위함      
		tempText=MnrDelLastDelim(tempText);		
 		eval("document.form." + return_val + ".value='" + tempText + "';"); 
 	} 
	function sheet2_OnDblClick(sheetObj,Row,Col){
		var formObj=document.form;  
		if(MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"rqst_eq_no")) != ''){
			//있다면 팝업호출		  
			var rqstEqNo=sheetObjects[1].GetCellValue(Row,"rqst_eq_no");
			var rprRqstSeq=sheetObjects[1].GetCellValue(Row,"rpr_rqst_seq");
			var rprRqstVerNo=sheetObjects[1].GetCellValue(Row,"rpr_rqst_ver_no");
			var eqKndCd=eq_knd_cd.GetSelectCode();
			ComOpenPopup('/opuscntr/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd+"&spp_type=Y", 1024, 768, '', '0,0', false);   		
		}									  	   	 		 			
	} 
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "" || ErrMsg==undefined) {  
			if(msgFlag == "Cancel"){
				ComShowCodeMessage("MNR00104"); 
			} else {
				ComShowCodeMessage("MNR00105");  
			}			
		} else {	
			/*		
			if(msgFlag == "Cancel"){
				ComShowCodeMessage("MNR00008",ErrMsg);
			} else {
				ComShowCodeMessage("MNR00027",ErrMsg);
			} 	
			*/    
		}  	 		      
	} 
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */ 
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){ 	       
        	switch(sAction) { 	 
				case IBROWSEARCH:
					if (!ComChkValid(formObj)) return false;
				 	break;	
				case IBSAVE: 	  //Approval Cancel
					var sRow=sheetObj.FindCheckedRow("del_chk");
					if (sRow == ""){ 
						ComShowCodeMessage("MNR00038","Approval Cancel "); 	
						return false;
					} 
					//Approval Cancel 저장  의사 확인   	
					if (!ComShowCodeConfirm("MNR00275","Estimate","Approval Cancel")){return false;}         
					break;	
				case IBDELETE:   //Delete    		
					var sRow=sheetObj.FindCheckedRow("del_chk");
					if (sRow == ""){
						ComShowCodeMessage("MNR00038","Delete ");	
						return false;	
					} 	
					if (!ComShowCodeConfirm("MNR00275","Repair WorkOrder and Estimate","Delete")){return false;}	
					break; 		
			}   
		}
        return true;
    }
	function status_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
		sheetObjects[1].RemoveAll();
		if(comboObj.GetSelectCode()== "SS" || comboObj.GetSelectCode()== "SC")
		{ 			
			ComBtnEnable("btn_Delete");
		} else{		
			ComBtnDisable("btn_Delete");
		}
	}      
	function initControl() {        
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject=document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
//	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
//	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',		formObject); 			//- 변경될때.
	}             
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){      
	    ComChkObjValid(ComGetEvent()); 
	} 
	function obj_activate(){   
	    ComClearSeparator(ComGetEvent());
	}        
	function obj_change(){	     
		var obj=ComGetEvent();  
		var formObj=document.form;  
		var sheetObj=sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {       
	    		case "vndr_seq":    
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;   
			}       
	    } else {
			switch(ComGetEvent("name")) {      
	    		case "vndr_seq":    
					ComSetObjValue(formObj.vndr_nm,"")
				   	break;   	
			}  		
		}
	}    
	
	/* 개발자 작업  끝 */
