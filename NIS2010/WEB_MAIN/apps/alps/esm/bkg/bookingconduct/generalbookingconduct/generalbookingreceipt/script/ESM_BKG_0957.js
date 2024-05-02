/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0957.js
*@FileTitle : Code Creation Request Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.08.17 김병규
* 1.0 Creation
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
     * @class ESM_BKG_0957 : ESM_BKG_0957 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0957() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var custTpCd = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	/*******************************************************/
    	var formObject = document.form;
    	var sheetObject1 = sheetObjects[0];

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		switch(srcName) {             
 		     	case "btn1_Send":
 		     		if(!opener){
 		        		mainFormObj = window.dialogArguments.document.form;	  
 		     		} else {
 		     			try {	  
 							mainFormObj = opener.document.form;   
 						}catch(e) {
 							ComShowCodeMessage("COM12111");
 						}		 		        	  
 		        	}		  

 					var reqContents = "<table border=0 style='font-size: 10pt'>";
 		        	if(formObject.shipper.checked){
 		        		custTpCd = "S";
 		        		reqContents = reqContents + "<tr><td colspan=2><b>> Shipper</b></td></tr>";
 		        		reqContents = reqContents + "<tr><td width=80>- Name : </td><td>"+ComGetObjValue(mainFormObj.sh_cust_nm) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- Address : </td><td>"+ComGetObjValue(mainFormObj.sh_cust_addr) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- City : </td><td>"+ComGetObjValue(mainFormObj.sh_cust_cty_nm) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- State : </td><td>"+ComGetObjValue(mainFormObj.sh_cust_ste_cd) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- Country : </td><td>"+ComGetObjValue(mainFormObj.sh_cstms_decl_cnt_cd) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- ZIP Code : </td><td>"+ComGetObjValue(mainFormObj.sh_cust_zip_id) +"</td></tr>";
 		        	}
 		        	if(formObject.consignee.checked){
 		        		custTpCd = "C";
 		        		reqContents = reqContents + "<tr><td colspan=2><b>> Consignee</b></td></tr>";
 		        		reqContents = reqContents + "<tr><td width=80>- Name : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_nm) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- Address : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_addr) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- City : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_cty_nm) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- State : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_ste_cd) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- Country : </td><td>"+ComGetObjValue(mainFormObj.cn_cstms_decl_cnt_cd) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- ZIP Code : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_zip_id) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- Fax : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_fax_no) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- E-mail : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_eml) +"</td></tr>"; 		        		
 		        	}
 		        	if(formObject.notify.checked){
 		        		custTpCd = "N";
 		        		reqContents = reqContents + "<tr><td colspan=2><b>> Notify</b></td></tr>";
 		        		reqContents = reqContents + "<tr><td width=80>- Name : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_nm) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- Address : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_addr) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- City : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_cty_nm) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- State : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_ste_cd) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- Country : </td><td>"+ComGetObjValue(mainFormObj.nf_cstms_decl_cnt_cd) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- ZIP Code : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_zip_id) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- Fax : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_fax_no) +"</td></tr>";
 		        		reqContents = reqContents + "<tr><td>- E-mail : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_eml) +"</td></tr>"; 		        		
 		        	} 		        	
 		        	reqContents = reqContents + "</table>";
 		        	
 		        	ComSetObjValue(formObject.gw_subject,"Code Creation Request. (BKG#:"+ComGetObjValue(formObject.bkg_no)+")");
 		        	var args = document.getElementsByName("gw_args");
 		        	args[0].value ="bkgno; - BKG No. : "+ComGetObjValue(formObject.bkg_no);
 		        	args[1].value ="blno; - B/L No. : "+ComGetObjValue(formObject.bl_no);
 		        	args[2].value ="podCd; - POD : " + ComGetObjValue(mainFormObj.pod_cd);
 		        	args[3].value ="delCd; - DEL : " + ComGetObjValue(mainFormObj.del_cd);	    	
 		        	args[4].value ="reqcontents;" + reqContents;

 		        	
 		        	if(ComGetObjValue(mainFormObj.pod_cd) == "DEHAM"){
// 		        		formObject.gw_to.value = "LEEWS@hanjin.com";
 		        		formObject.gw_cc.value = ComGetObjValue(mainFormObj.eml_info);
 		        		
 		        		var caution = "<font color='blue' size=2><u><b>Attn Code creation offices for Smuggling Features in case of POD (DEHAM):</b><br>";
 		        		caution = caution + "In case any of below items is applicable, pls contact HAMSC C/I immediately</u><br>";
 		        		caution = caution + "- Cnee / Notify located in countries like Romania, Bulgaria, Moldavia, Ukraine, Belarus, Lithuania, Latvia<br>";
 		        		caution = caution + "with POD / DEL (HAMBURG) and no contact available<br>";
 		        		caution = caution + "- The only available contact details (Cnee / Notify) are a private address<br>";
 		        		caution = caution + "- The only available contact telephone number is a mobile phone number<br>";
 		        		caution = caution + "- The only available company contact (Cnee / Notify) cannot be found on the Internet<br>";
 		        		caution = caution + "- It is hard to reach the given contact point (Cnee / Notify)<br>";
 		        		
 		        		caution = caution + "</font>";

 		        		args[5].value ="caution;" + caution;
 		        	}else{
 		        		args[5].value ="caution;";
 		        	}
 		        	ComOpenGroupwareMail(sheetObject1,formObject);

 		     		formObject.cfm_flg.disabled = false;
 		        	break;
 		     	case "btn1_Confirm":
 		     		var param = "f_cmd="+MULTI
 		     				+"&bkg_no="+formObject.bkg_no.value
 		     				+"&cust_tp_cd="+custTpCd;
 		     		var sXml = sheetObject1.GetSearchXml("ESM_BKG_0957GS.do", param); 
 		     		sheetObject1.LoadSearchXml(sXml);
 		   		
 					window.close();
 		     		break;
 		        case "btn1_Close":
 					window.close();
 					break;
            } // end switch
     	} catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111"); 
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

 	function loadPage() {		
        var formObject = document.form;
  		if(ComIsNull(formObject.bkg_no)){
  			ComShowCodeMessage("BKG00255");
  			window.close();
  		}
 		for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
 		}         
        initControl();
         
        // 최초 로딩시 Name이 있는 항목은 자동체크해준다.
        // 20090909 Default 3개 모두 UnCheck
        if(!ComIsNull(formObject.sh_cust_nm)){
        	//formObject.shipper.checked = true;
        }
        if(!ComIsNull(formObject.cn_cust_nm)){
        	//formObject.consignee.checked = true;
        }
        if(!ComIsNull(formObject.nf_cust_nm)){
        	//formObject.notify.checked = true;
        }         

  		ComBtnDisable("btn1_Confirm");
  		formObject.cfm_flg.disabled = true;  		
    }

     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * 
      * @param {ibsheet}
      *            sheetObj IBSheet Object
      * @param {int}
      *            sheetNo sheetObjects 배열에서 순번
      */
    function initControl() {
     	var formObject = document.form;
        axon_event.addListenerForm('click', 'bkg0957_click',    formObject); //- 클릭시
    } 	 

	 /**
	 * Click 일때 
	 */    
	function bkg0957_click(){
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");

    	if(srcName == "shipper"){
    		if(ComGetObjValue(formObject.shipper) == "Y"){
    			formObject.consignee.disabled = true;
    			formObject.notify.disabled = true;
    		}else{
    			formObject.consignee.disabled = false;
    			formObject.notify.disabled = false;    			
    		}
    	}else if(srcName == "consignee"){
    		if(ComGetObjValue(formObject.consignee) == "Y"){
    			formObject.shipper.disabled = true;
    		}else{
    			if(ComGetObjValue(formObject.notify) != "Y"){
    				formObject.shipper.disabled = false;	
    			}    			
    		}
    	}else if(srcName == "notify"){
    		if(ComGetObjValue(formObject.notify) == "Y"){
    			formObject.shipper.disabled = true;
    		}else{
    			if(ComGetObjValue(formObject.consignee) != "Y"){
    				formObject.shipper.disabled = false;	
    			}    			
    		}
    	}else if(srcName == "cfm_flg"){
	     	ComBtnEnable("btn1_Confirm");
	     	ComBtnDisable("btn1_Send");
    	}
	}     
     
     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
	function initSheet(sheetObj,sheetNo) {	
		var cnt = 0;
		var sheetID = sheetObj.id;
	
		switch(sheetID) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
					
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
					InitColumnInfo(2, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
					
					var HeadTitle = "|";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);					
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++ , dtRadioCheck,	35,     daCenter,   false,     	"chk");
	
					CountPosition = 0;	
				}
				break;
	    }
	}
    /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
//      	if (!isNumber(formObj.iPage)) {
//          	return false;
//          }
        }

        return true;
    }      
	/* 개발자 작업  끝 */