/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0108.js
*@FileTitle : Exception Reason 추가 및 Insert 방식 변경
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2008-07-21 Hun-Il Jung
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* 공통전역변수 */
	var sheetObjects = new Array(); // 실질적으로 Popup 에 sheet 가 없어 사용되지 않지만 common.jsp 에서 sheet 할당 부분이 있어 선언 해 줌 2008.09.22 김인수 

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    

    
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var opener = window.dialogArguments;
    	 switch(srcName) {
        	    case "btn_ok":
        	    	if(formObject.dist.value=='expt_rsn'){
        	    	    //alert("btn_ok");
        	    		ischkExptRsnIns(formObject);
        	    	}else{
        	    	    //alert("processButton:btn_ok");
        	    		ischkExptRsn(formObject);
        	    	}
        	    break;
        	    case "btn_close":
        	    	self.close();
        	    break;
			case "btn_new":
			//alert("document.form.expt_rsn_inq:"+document.form.expt_rsn_inq+" document.form.expt_rsn:"+document.form.expt_rsn);
        	    	if(formObject.dist.value=='expt_rsn'){
                    	var exptrsnObj = document.form.expt_rsn ;
        	    	}else{
        	    	    var exptrsnObj = document.form.expt_rsn_inq ;
        	    	}
        	    	
                	for( i=0; i<exptrsnObj.length; i++ ) {
                		exptrsnObj[i].checked = false ;
                	}
			//alert("just");
        	    	if(formObject.dist.value=='expt_rsn'){
        	    	    opener.rtn_ExptRsnIns_code("; ");
        	    	}else{
                    	opener.rtn_ExptRsn_code("CLR");
        	    	}
        	    	
                	
				break;        	    
    	 }
    }
 
 // ESD_SCE_0011.JSP에서 expt_rsn_inq onClick시 체크박스 단일선택 체크   
 function chkExptRsn(chkObj) {	
	var exptrsnObj = document.form.expt_rsn_inq ;
	var chkFlg = chkObj.checked ;

//	for( i=0; i<exptrsnObj.length; i++ ) {
//		exptrsnObj[i].checked = false ;
//	}
	chkObj.checked = chkFlg;
//alert("chkExptRsn:"+chgFlg);	
	//alert(chkObj.value);
}

 // ESD_SCE_0011.JSP에서 expt_rsn_ins onClick시 체크박스 단일선택 체크   
 function chkExptRsnIns(chkObj) {	
	var exptrsninsObj = document.form.expt_rsn ;
	var chkFlg = chkObj.checked ;

	for( i=0; i<exptrsninsObj.length; i++ ) {
		exptrsninsObj[i].checked = false ;
	}
	chkObj.checked = chkFlg;
//alert("chkExptRsnIns:"+chgFlg);	
}

// ESD_SCE_0011.JSP로 expt_rsn_inq체크박스에서 선택된값을 보낸다.
function ischkExptRsn(formObject){

	var exptrsnObj = document.form.expt_rsn_inq ;
	var val	   = "";	// Target Object에 세팅할 값
	var iCheckRow = exptrsnObj.length;

	if(iCheckRow == 0) {
		return null;
	}
	else {
		var ik = 0;
		for(var i = 0; i < iCheckRow; i++) {			
			if(exptrsnObj[i].checked == true) {
			    if(val==""){
	  				val = exptrsnObj[i].value;			        
			    }else{
	  				val = val + "," + exptrsnObj[i].value;
			    }

	  		}		

  		}
        //alert("val:"+val);
  	}
  	
  	if(val=="" || val.length==0){
  		ComShowMessage("Check Exception Reason") ;
  	}else{
  		var opener = window.dialogArguments;
  		opener.rtn_ExptRsn_code(val);
  		self.close();
	}
}

// ESD_SCE_0011.JSP로 expt_rsn_ins체크박스에서 선택된값을 보낸다.
function ischkExptRsnIns(formObject){
    //alert("ischkExptRsnIns");
	var exptrsninsObj = document.form.expt_rsn ;
	var val	   = "";	// Target Object에 세팅할 값
	var iCheckRow = exptrsninsObj.length;

	if(iCheckRow == 0) {
		return null;
	}
	else {
		var ik = 0;

		for(var i = 0; i < iCheckRow; i++) {			
			if(exptrsninsObj[i].checked == true) {
//				if(exptrsninsObj[i].value == '99') {
//					alert("Others");
//				}		
	  				val = exptrsninsObj[i].value;
	  				//alert("checkRow:"+val);
	  		}		

  		}

  	}
  	
  	//alert("if:"+val);
  	if(val=="" || val.length==0){
  		ComShowMessage("Check Exception Reason") ;
  	}else{
  	    //alert("1");
  	var opener = window.dialogArguments;	
  	opener.rtn_ExptRsnIns_code(val);
  	 //alert("2");
  	self.close();
	}  	
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

    //Exception Reason 읽어오기
    fun_getExptRSN();

}

// 초기 화면 생성 시 Exception Type을 가져다가 뿌린다...
function fun_getExptRSN() {

		var param = "&tablefield=sce_expt_rsn_mst&valuefield=cop_expt_rsn_cd&textfield=cop_expt_rsn_nm&wherefield=";
		var url = "ESD_SCE_0108GS.do?f_cmd="+SEARCH09+param;
		createHttpRequest();
		request.open("GET", url, true);

		request.onreadystatechange = subExptRsn;

		request.send(null);

}


var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

// Exception Type의 값을 가지고 온다.
function subExptRsn() {

	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			
			var dataXml = docXml.getElementsByTagName("DATA");
			var rowXml = docXml.getElementsByTagName("TR");
			
			
			var d_row = dataXml[0].getAttribute("COLORDER").split("|");
			
			//alert(d_row.length)
			
			/*
			<td width='17%' class='stm'>
			<input name='"+dist+"' type='checkbox' "+chkString+" value='"+rowSet.getString(1)+";"+rowSet.getString(2)+"' class='trans'  onClick='"+("expt_rsn_inq".equals(dist)?"chkExptRsn(this)":"chkExptRsnIns(this)")+"'>&nbsp;"+rowSet.getString(2)+"</td>");
				rstcnt++;
				if(rstcnt%3==0){
					result.append("</tr><tr>");					
				}
			*/		
			var codeXml = null;
			var nameXml = null;

			
			var text_expt_rsn = "";
			var dist = document.form.dist.value;
			var onclkEvnt = (dist == "expt_rsn_inq") ? "chkExptRsn(this)" : "chkExptRsnIns(this)";
			var sltcd= (dist == "expt_rsn_inq") ? document.form.rsncd.value : document.form.insrtcd.value;	
			sltcd = sltcd.split(",");	
			var rstcnt = 0;
			
			//alert(sltcd.length);
					
			if( rowXml.length > 0 ){

				for( var i = 0; i < rowXml.length; i++ ) {

					chkString = "";
					
					var c_row = rowXml[i].childNodes[0].nodeValue.split("☜☞");
					//alert(c_row.length);
					
					var c_code="";
					var c_text="";
					
					for( var j = 0; j < d_row.length; j++ ) {
						if(d_row[j]=="valuefield"){
							c_code =c_row[j]; 
						}
						if(d_row[j]=="textfield"){
							c_text =c_row[j]; 
						}
					}
					
					for (var k = 0; k < sltcd.length; k++) {
						//alert(sltcd[k]);
						if(c_code==sltcd[k]){
							chkString = "checked";
							k = sltcd.length;
						}
						
					}
					
				
					text_expt_rsn +="<td width='17%' class='stm'> ";
					text_expt_rsn += 
						"<input name='"+dist+"' type='checkbox' "+chkString+" value='"+c_code+";"+c_text+"' class='trans' onClick='"+onclkEvnt+"'>&nbsp;" + c_text;
					text_expt_rsn += "</td>";
							
					rstcnt++;
					
					if(rstcnt%3==0){
						text_expt_rsn += "</tr><tr>";					
					}
				}
				text_expt_rsn += "</tr>";	
				//alert(text_expt_rsn);
			}

//		document.write(text_expt_rsn);
			document.form.all.expt_rsn_div.innerHTML = text_expt_rsn;
			//alert(document.getElementById("expt_rsn_div"));
//			document.all.expt_rsn_div.innerHTML = text_expt_rsn;
//			alert(document.all.expt_rsn_div.innerHTML);
			//alert(document.form.all.expt_rsn_div.innerHTML);
		}

	}

}

// Exception Type의 값을 가지고 온다.
/*
function subExptRsn() {

	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("ExptTP");
			var cdxml = docXml.getElementsByTagName("sub-code");
			var nmxml = docXml.getElementsByTagName("sub-name");

			var codeXml = null;
			var nameXml = null;

			var text_effS = "";
			var text_effM = "";
			var text_effE = "";

			text_effS = "<select style=\"width:150;\" name=\"i_expt_type\" onChange=\"fun_getExptDTLTP();\">";

			if( rowXml.length > 0 ){

				for( var i = 0; i < rowXml.length; i++ ) {

					codeXml = cdxml[i].childNodes[0].nodeValue;
					nameXml = nmxml[i].childNodes[0].nodeValue;

					if( i == 0){
						text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
						text_effM = text_effM + "<OPTION value=\"" + codeXml + "\" >"+nameXml+"</OPTION>";
					}else{
						text_effM = text_effM + "<OPTION value=\"" + codeXml + "\" >"+nameXml+"</OPTION>";
					}
				}
			}

			text_effE = "</SELECT>";

			if( text_effM.length < 1 ) {
				text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
			}

			document.form.all.expt_rsn_div.innerHTML = text_effS+text_effM+text_effE;
		}

	}

}
*/
 