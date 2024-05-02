/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1300.js
*@FileTitle  : Hazardous Parties
*@author     : CLT
*@version    : 1.0
*@since      : 2015/11/17
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)){
				return false;
			}
     		
     		switch(srcName) {
     			case "btn_save":
     				if(validateForm(sheetObjects[0],document.form,MULTI)){
         				doActionIBSheet(sheetObjects[0],document.form,MULTI);     					
     				}
     				break;
     			case "btn_sh_cust":
					var custCntCd=ComGetObjValue(formObject.sh_cust_cnt_cd);
					var custSeq=ComGetObjValue(formObject.sh_cust_seq);
					var custNm="";
					var custAddr="";
					if(ComChkLen(formObject.sh_cust_nm) != 1){
						custNm=ComGetObjValue(formObject.sh_cust_nm).substring(0,10);
					}else{
						custNm=ComGetObjValue(formObject.sh_cust_nm);
					}
					if(ComChkLen(formObject.sh_cust_addr) != 1){
						custAddr=ComGetObjValue(formObject.sh_cust_addr).substring(0,10);
					}else{
						custAddr=ComGetObjValue(formObject.sh_cust_addr);
					}    					
					var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&cust_addr=";
					ComOpenPopup(url,970, 580, "callBackSh0192","0,0,1,1,1", true);
					break;    	
     			case "btn_cn_cust":
					var custCntCd=formObject.cn_cust_cnt_cd.value;
					var custSeq=formObject.cn_cust_seq.value;
					var custNm="";
					var custAddr="";
					if(ComChkLen(formObject.cn_cust_nm) != 1){
						custNm=ComGetObjValue(formObject.cn_cust_nm).substring(0,10);
					}else{
						custNm=ComGetObjValue(formObject.cn_cust_nm);
					}
					if(ComChkLen(formObject.cn_cust_addr) != 1){
						custAddr=ComGetObjValue(formObject.cn_cust_addr).substring(0,10);
					}else{
						custAddr=ComGetObjValue(formObject.cn_cust_addr);
					}    					
					var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&cust_addr=";    					
					ComOpenPopup(url,970, 580, "callBackCn0192","0,0,1,1,1", true);
     				break;
				case "btn_ShZipCode":
					var zip_cd=formObject.sh_cust_zip_id.value;
					var cnt_cd=formObject.sh_cust_cnt_cd.value;
					ComOpenPopup("/opuscntr/ESM_BKG_1114_POP.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd,1000, 520, "callBackShZipCode","0,1,1,1,1", true);
					break;
				case "btn_CnZipCode":
					var zip_cd=formObject.cn_cust_zip_id.value;
					var cnt_cd=formObject.cn_cust_cnt_cd.value;
					ComOpenPopup("/opuscntr/ESM_BKG_1114_POP.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd,1000, 520, "callBackCnZipCode","0,1,1,1,1", true);
					break;
     			case "btn_close":
     				ComClosePopup(); 
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
	function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
    	if(document.form.pop_type.value=="R"){
    		ComBtnDisable("btn_save");
    		ComBtnDisable("btn_sh_cust");
    		ComBtnDisable("btn_ShZipCode");
    		ComBtnDisable("btn_cn_cust");
    		ComBtnDisable("btn_CnZipCode");
    		
    		setBookingEditable(false);
    		
    	}
        
//		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		doActionIBSheet(sheetObjects[0],document.form,SEARCH);
	}
	
	function setBookingEditable(isEnable) {
		var formObj=document.form;
		BkgEnableObject(formObj.decl_nm, isEnable);
		BkgEnableObject(formObj.sh_cust_cnt_cd, isEnable);
		BkgEnableObject(formObj.sh_cust_seq, isEnable);
		BkgEnableObject(formObj.sh_cust_nm, isEnable);
		BkgEnableObject(formObj.sh_cust_addr, isEnable);
		BkgEnableObject(formObj.sh_cust_cty_nm, isEnable);
		BkgEnableObject(formObj.sh_cust_ste_cd, isEnable);
		BkgEnableObject(formObj.sh_cust_zip_id, isEnable);
		BkgEnableObject(formObj.sh_cstms_decl_cnt_cd, isEnable);
		BkgEnableObject(formObj.sh_phn_no, isEnable);
		BkgEnableObject(formObj.sh_cust_fax_no, isEnable);
		BkgEnableObject(formObj.sh_cust_eml, isEnable);
		BkgEnableObject(formObj.cn_cust_cnt_cd, isEnable);
		BkgEnableObject(formObj.cn_cust_seq, isEnable);
		BkgEnableObject(formObj.cn_cust_nm, isEnable);
		BkgEnableObject(formObj.cn_cust_addr, isEnable);
		BkgEnableObject(formObj.cn_cust_cty_nm, isEnable);
		BkgEnableObject(formObj.cn_cust_ste_cd, isEnable);
		BkgEnableObject(formObj.cn_cust_zip_id, isEnable);
		BkgEnableObject(formObj.cn_cstms_decl_cnt_cd, isEnable);
		BkgEnableObject(formObj.cn_phn_no, isEnable);
		BkgEnableObject(formObj.cn_cust_fax_no, isEnable);
		BkgEnableObject(formObj.cn_cust_eml, isEnable);
	}
	
	 /**
	  * setting sheet initial values and header
	  * @param sheetObj
	  * @param sheetNo
	  * @return
	  */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
				with(sheetObj){		    
					var HeadTitle="|";	
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );	
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);	
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Text",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" } ];			       
					InitColumns(cols);	
					SetEditable(1);			    
					SetVisible(false);
		        }
				break;
			case "sheet2":
				with(sheetObj){		    
					var HeadTitle="||Seq|Container No|TS";	
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );	
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);	
					var cols = [ 
					    {Type:"Status",		Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" }
					   ,{Type:"DummyCheck",	Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"chk",			UpdateEdit:1 }
					   ,{Type:"Seq",		Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" }
					   ,{Type:"Text",		Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",		UpdateEdit:0 }
					   ,{Type:"Text",		Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",	UpdateEdit:0 }
					   ,{Type:"Text",		Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"dg_cntr_seq" }
					];			       
					InitColumns(cols);	
					SetEditable(1);
				    SetSheetHeight(327);
		        }
				break;
		}
	}	
	
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 * @param sheet_obj IBSheet Object
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	
	/**
	 * Sheet process handling
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
			case SEARCH: //Retrieve
				// 1. setting parameter before retrieve
				ComSetObjValue(formObj.f_cmd, SEARCH);
				// 2. retrieve
				var sXml=sheetObj.GetSearchData("ESM_BKG_1300GS.do", FormQueryString(formObj));
				var State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
				if ( State == "S" ) {
					BkgEtcDataXmlToForm(sXml, formObj);
					sheetObjects[1].LoadSearchData(sXml,{Sync:1});
					
					//Check on flags of containers which are selected at the previous screen.
					checkOnContainer();
				}
			break;
			case MULTI:
				formObj.f_cmd.value=MULTI;
				var updList = updateIbflag(); //Update ibflag. Selected row -> U. Not selected -> R. And get list of undated dg_cntr_seq.
				var sParamSheet1=sheetObjects[1].GetSaveString();
				var sXml = sheetObj.GetSaveData("ESM_BKG_1300GS.do", FormQueryString(formObj) + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_'));
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					ComShowMessage(ComGetMsg("BKG00166"));
					ComSetObjValue(formObj.dg_cntr_seq_upd, updList);
					doActionIBSheet(sheetObj, formObj, SEARCH);
					FuncTrsCall();
				}else{
					ComBkgErrMessage(sheetObj, sXml);
				}
			break;
		}
	}
	
	function FuncTrsCall() {
		if(trsfunc != '') {
			var openObj = opener;
			if(openObj) {
				eval("opener." + trsfunc +".call()");
			} else {
				eval("parent." + trsfunc +".call()");
			}
		}
	}

	/**
     *From 'B/L Customer' received value Save<br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackSh0192(rArray, rArray2);
     * </pre>
     * @param Popup -> received values ​​ 
     * @return 
     * @author 
     * @version 2009.05.14
     */
    function callBackSh0192(rArray, rArray2) {
  		var formObj=document.form;  		
		if (rArray2) {
			
  	  		if (!ComIsNull(formObj.sh_cust_nm) || !ComIsNull(formObj.sh_cust_addr)) {
  	  			if (!ComShowCodeConfirm("BKG00343")) return;
  	  		}
  	  		ComSetObjValue(formObj.sh_cust_cnt_cd      , rArray2[1]);
  	  		ComSetObjValue(formObj.sh_cust_seq         , ComLpad(rArray2[2],6,"0"));
  	  		ComSetObjValue(formObj.sh_cust_cty_nm      , rArray2[11]);  //City
  	  		ComSetObjValue(formObj.sh_cust_ste_cd      , rArray2[12]);  //State
  	  		ComSetObjValue(formObj.sh_cstms_decl_cnt_cd, rArray2[13]);  //Country
  	  		ComSetObjValue(formObj.sh_cust_zip_id      , rArray2[14]);  //ZIP Code
			ComSetObjValue(formObj.sh_cust_nm    	   , getMakeBrData("NAME",chekcSpecialValue(rArray2[6]))); // cust_nm
			ComSetObjValue(formObj.sh_cust_addr    	   , replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray2[7])), "@*", "\n")); // Addr
			
			//phone, fax, email
  	  		ComSetObjValue(formObj.sh_phn_no      	   , rArray2[8]);  //Tel. No.
  	  		ComSetObjValue(formObj.sh_cust_fax_no      , rArray2[9]);  //Fax No.
  	  		ComSetObjValue(formObj.sh_cust_eml         , rArray2[15]);  //E-mail

  		} else {
  	  		ComSetObjValue(formObj.sh_cust_cnt_cd      , rArray[0]);
  			ComSetObjValue(formObj.sh_cust_seq         , ComLpad(rArray[1],6,"0"));
  			ComSetObjValue(formObj.sh_cust_cty_nm      , rArray[10]);  //City
  			ComSetObjValue(formObj.sh_cust_ste_cd      , rArray[11]);  //State
  			ComSetObjValue(formObj.sh_cust_zip_id      , rArray[12]);  //ZIP Code
			ComSetObjValue(formObj.sh_cust_nm    	   , getMakeBrData("NAME",chekcSpecialValue(rArray[7]))); // cust_nm
			ComSetObjValue(formObj.sh_cust_addr    	   , replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray[8])), "@*", "\n")); // Addr
  		}
    }	
	
	/**
     * From 'B/L Customer' received value Save <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackCn0192(rArray, rArray2);
     * </pre>
     * @param Popup -> received values ​​ 
     * @return 
     * @author 
     * @version 2009.05.14
     */
    function callBackCn0192(rArray, rArray2) {
   		var formObj=document.form;
  		if (rArray2) {
  	  		if (!ComIsNull(formObj.cn_cust_nm) || !ComIsNull(formObj.cn_cust_addr)) {
  	  			if (!ComShowCodeConfirm("BKG00343")) return;
  	  		}
  	  		ComSetObjValue(formObj.cn_cust_cnt_cd      , rArray2[1]);
  	  		ComSetObjValue(formObj.cn_cust_seq         , ComLpad(rArray2[2],6,"0"));
  	  		ComSetObjValue(formObj.cn_cust_cty_nm      , rArray2[11]);  //City
  	  		ComSetObjValue(formObj.cn_cust_ste_cd      , rArray2[12]);  //State
  	  		ComSetObjValue(formObj.cn_cstms_decl_cnt_cd, rArray2[13]);  //Country
  	  		ComSetObjValue(formObj.cn_cust_zip_id      , rArray2[14]);  //ZIP Code
			ComSetObjValue(formObj.cn_cust_nm    	   , getMakeBrData("NAME",chekcSpecialValue(rArray2[6]))); // cust_nm
			ComSetObjValue(formObj.cn_cust_addr    	   , replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray2[7])), "@*", "\n")); // Addr
			
			//phone, fax, email
  	  		ComSetObjValue(formObj.cn_phn_no      	   , rArray2[8]);  //Tel. No.
  	  		ComSetObjValue(formObj.cn_cust_fax_no      , rArray2[9]);  //Fax No.
  	  		ComSetObjValue(formObj.cn_cust_eml         , rArray2[15]);  //E-mail
  		} else {
  	  		ComSetObjValue(formObj.cn_cust_cnt_cd      , rArray[0]);
  			ComSetObjValue(formObj.cn_cust_seq         , ComLpad(rArray[1],6,"0"));
  			ComSetObjValue(formObj.cn_cust_cty_nm      , rArray[10]);  //City
  			ComSetObjValue(formObj.cn_cust_ste_cd      , rArray[11]);  //State
  			ComSetObjValue(formObj.cn_cust_zip_id      , rArray[12]);  //ZIP Code
			ComSetObjValue(formObj.cn_cust_nm    	   , getMakeBrData("NAME",rArray[7])); // cust_nm
			ComSetObjValue(formObj.cn_cust_addr    	   , replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray[8])), "@*", "\n")); // Addr
  		}
	}
    
	function getMakeBrData(dataNm, dataValue){
		var rtnValue="";
		var strValue="";
		var resArray=dataValue.split("\n");
		var resValue="";
		
		if(dataValue != null && dataValue.length > 0){
			if(dataNm == "NAME"){
				for(var i=0; i<resArray.length; i++){
					strValue = resArray[i];
					
					if(strValue.length > 35){
						rtnValue=strValue.substring(0,35) + "\n" + strValue.substring(35);
					}else{
						rtnValue=strValue;
					}
					
					if(i==0){
						resValue=rtnValue;
					}else{
						resValue=resValue+"\n"+rtnValue;
					}
				}
			}else if(dataNm == "ADDR"){
				for(var i=0; i<resArray.length; i++){
					strValue = resArray[i];

					if(strValue.length > 70){
						rtnValue=strValue.substring(0,35) + "\n" + strValue.substring(35,70) + "\n" + strValue.substring(70);
					}else if(strValue.length > 35){
						rtnValue=strValue.substring(0,35) + "\n" + strValue.substring(35);
					}else{
						rtnValue=strValue;
					}
					if(i==0){
						resValue=rtnValue;
					}else{
						resValue=resValue+"\n"+rtnValue;
					}
				}
			}			 
		}else{
			resValue="";
		}
		return resValue.toUpperCase();		 
	}    
    function replaceAll(str, orgStr, repStr){
    	return str.split(orgStr).join(repStr); 
    }
    
	/**
	 * 'Zip Code' received value Save (Shipper)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     callBackShZipCode(rArray);
	 * </pre>
	 * @param Popup -> received values
	 * @return 
	 * @author 
	 * @version 2010.12.27
	 */
    function callBackShZipCode(rArray){
	   	var formObj=document.form;
	   	if(rArray != null){
	   		ComSetObjValue(formObj.sh_cust_cty_nm, rArray[0]);
	   		ComSetObjValue(formObj.sh_cust_ste_cd, rArray[1]);
	   		ComSetObjValue(formObj.sh_cstms_decl_cnt_cd, rArray[2]);
	   		ComSetObjValue(formObj.sh_cust_zip_id, rArray[3]);
	   	}
    }
    /**
     * 'Zip Code' received value Save (Consignee)<br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackShZipCode(rArray);
     * </pre>
     * @param Popup -> received values
     * @return 
     * @author 
     * @version 2010.12.27
     */
    function callBackCnZipCode(rArray){
	   	var formObj=document.form;
	   	if(rArray != null){
	   		ComSetObjValue(formObj.cn_cust_cty_nm, rArray[0]);
	   		ComSetObjValue(formObj.cn_cust_ste_cd, rArray[1]);
	   		ComSetObjValue(formObj.cn_cstms_decl_cnt_cd, rArray[2]);
	   		ComSetObjValue(formObj.cn_cust_zip_id, rArray[3]);
	   	}
    }
    
	/**
	 * Update ibflag to 'U' if checked<br>
	*/
    function updateIbflag(){
    	var rowCount = sheetObjects[1].RowCount();
    	var updList = "";
    	for(var i=1; i<rowCount+1; i++){
    		if(sheetObjects[1].GetCellValue(i,"chk")==0){
    			sheetObjects[1].SetCellValue(i, "ibflag", "R", 0);
    		}else{
    			sheetObjects[1].SetCellValue(i, "ibflag", "U", 0);
    	    	updList += sheetObjects[1].GetCellValue(i, "dg_cntr_seq") + "|";
    		}
    	}
    	
    	return updList;
    }
   
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case MULTI:
				var checkedRows = sheetObjects[1].FindCheckedRow("chk");
				if(checkedRows == ""){
					ComShowCodeMessage("BKG95031", "containers to be updated");
					return false;
				}				
			break;
		}
		return true;
	}
	
	/**
	 * Check on the flag of containers which are selected at previous screen
	 */
	function checkOnContainer(){
		var formObj=document.form;
		var dgCntrSeqUpdTarget = "";
		if(ComGetObjValue(formObj.dg_cntr_seq_upd)!=""){
			dgCntrSeqUpdTarget = ComGetObjValue(formObj.dg_cntr_seq_upd); //Multiple rows are selected
		}else{
			dgCntrSeqUpdTarget = ComGetObjValue(formObj.dg_cntr_seq); 
		}
		if(dgCntrSeqUpdTarget !=""){
			var arrDgCntrSeqUpdTarget = dgCntrSeqUpdTarget.split("|");
			var dgCntrSeqTemp = 0;
			for(var i=0;i<arrDgCntrSeqUpdTarget.length;i++){
				dgCntrSeqTemp = sheetObjects[1].FindText("dg_cntr_seq", arrDgCntrSeqUpdTarget[i],1,-1);
				if(dgCntrSeqTemp>0){
					sheetObjects[1].SetCellValue(dgCntrSeqTemp,"chk", 1, 0);
				}
			}
		}		
	}
     
/* 개발자 작업  끝 */
