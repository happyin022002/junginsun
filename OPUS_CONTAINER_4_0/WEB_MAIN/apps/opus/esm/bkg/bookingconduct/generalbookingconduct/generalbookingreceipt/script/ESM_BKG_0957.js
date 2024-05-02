/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0957.js
*@FileTitle  : Code Creation Request Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 var sheetObjects=new Array();
 var sheetCnt=0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick=processButtonClick;
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          /*******************************************************/
         var formObject=document.form;
 		 var sheetObject1=sheetObjects[0];
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {             
 		     	case "btn1_Send":
 		     		var opener=window.dialogArguments;
 		     		if (!opener) opener=parent;
 		     		
		     		if(!opener){
 		        		mainFormObj=opener.document.form;	  
 		     		} else {
 		     			try {	  
 							mainFormObj=opener.document.form;   
 						}catch(e) {
 							ComShowCodeMessage("COM12111");
 						}		 		        	  
 		        	}		  
 					var reqContents="<table border=0 style='font-size: 10pt'>";
 		        	if(formObject.shipper.checked){
 		        		reqContents=reqContents + "<tr><td colspan=2><b> Shipper</b></td></tr>";
 		        		reqContents=reqContents + "<tr><td width=80>- Name : </td><td>"+ComGetObjValue(mainFormObj.sh_cust_nm) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- Address : </td><td>"+ComGetObjValue(mainFormObj.sh_cust_addr) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- City : </td><td>"+ComGetObjValue(mainFormObj.sh_cust_cty_nm) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- State : </td><td>"+ComGetObjValue(mainFormObj.sh_cust_ste_cd) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- Country : </td><td>"+ComGetObjValue(mainFormObj.sh_cstms_decl_cnt_cd) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- ZIP Code : </td><td>"+ComGetObjValue(mainFormObj.sh_cust_zip_id) +"</td></tr>";
 		        	}
 		        	if(formObject.consignee.checked){
 		        		reqContents=reqContents + "<tr><td colspan=2><b> Consignee</b></td></tr>";
 		        		reqContents=reqContents + "<tr><td width=80>- Name : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_nm) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- Address : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_addr) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- City : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_cty_nm) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- State : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_ste_cd) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- Country : </td><td>"+ComGetObjValue(mainFormObj.cn_cstms_decl_cnt_cd) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- ZIP Code : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_zip_id) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- Fax : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_fax_no) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- E-mail : </td><td>"+ComGetObjValue(mainFormObj.cn_cust_eml) +"</td></tr>"; 		        		
 		        	}
 		        	if(formObject.notify.checked){
 		        		reqContents=reqContents + "<tr><td colspan=2><b> Notify</b></td></tr>";
 		        		reqContents=reqContents + "<tr><td width=80>- Name : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_nm) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- Address : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_addr) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- City : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_cty_nm) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- State : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_ste_cd) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- Country : </td><td>"+ComGetObjValue(mainFormObj.nf_cstms_decl_cnt_cd) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- ZIP Code : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_zip_id) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- Fax : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_fax_no) +"</td></tr>";
 		        		reqContents=reqContents + "<tr><td>- E-mail : </td><td>"+ComGetObjValue(mainFormObj.nf_cust_eml) +"</td></tr>"; 		        		
 		        	} 		        	
 		        	reqContents=reqContents + "</table>";
// 		        	ComSetObjValue(formObject.gw_subject,"Code Creation Request. (BKG#:"+ComGetObjValue(formObject.bkg_no)+")");
// 		        	var args = document.getElementsByName("gw_args");
// 		        	args[0].value ="bkgno; - BKG No. : "+ComGetObjValue(formObject.bkg_no);
// 		        	args[1].value ="blno; - B/L No. : "+ComGetObjValue(formObject.bl_no); 		        	
// 		        	args[2].value ="reqcontents;" + reqContents;
 		       // 	ComOpenGroupwareMail(sheetObject1,formObject);
 		        	ComSetObjValue(formObject.com_subject, "Code Creation Request. (BKG#:"+ComGetObjValue(formObject.bkg_no)+")");
// 		        	reqContents = "BKG No. : "+ComGetObjValue(formObject.bkg_no) + "\n" +
// 		        				  "B/L No. : "+ComGetObjValue(formObject.bl_no) + "\n" +
// 		        				 reqContents; 		        	
 		        	
 		        	ComSetObjValue(formObject.com_content, reqContents);
 		        	//ComSendMailModal();
 		        	ComSendMail();
 		        	break;
 		        case "btn1_Close":
 		        	ComClosePopup(); 
 					break;  
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111"); 
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
 	 function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
 		}         
         initControl();
         var formObject=document.form;
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
     	var formObject=document.form;
         axon_event.addListenerForm('click', 'bkg0957_click',    formObject); //- 클릭시
     } 	 
	 /**
	 * Click 일때 
	 */    
	function bkg0957_click(){
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	if(srcName == "shipper"){
    		if(ComGetObjValue(formObject.shipper) == "Y"){
    			formObject.consignee.disabled=true;
    			formObject.notify.disabled=true;
    		}else{
    			formObject.consignee.disabled=false;
    			formObject.notify.disabled=false;    			
    		}
    	}else if(srcName == "consignee"){
    		if(ComGetObjValue(formObject.consignee) == "Y"){
    			formObject.shipper.disabled=true;
    		}else{
    			if(ComGetObjValue(formObject.notify) != "Y"){
    				formObject.shipper.disabled=false;	
    			}    			
    		}
    	}else if(srcName == "notify"){
    		if(ComGetObjValue(formObject.notify) == "Y"){
    			formObject.shipper.disabled=true;
    		}else{
    			if(ComGetObjValue(formObject.consignee) != "Y"){
    				formObject.shipper.disabled=false;	
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
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
				with (sheetObj) {
			        var HeadTitle="|";
			        SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			               {Type:"Radio",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" } ];
			         
			        InitColumns(cols);
					SetEditable(1);
					SetCountPosition(0);
					SetVisible(false);
				}
				break;
	    }
	}
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }
	/* 개발자 작업  끝 */
