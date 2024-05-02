/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoSpc.js
*@FileTitle  : SPC common js 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
//AS-IS message
	if(msgs == undefined){
		msgs=new Array();
	}
    msgs['SPE10001']='Can not create anymore.';
    msgs['SPE10002']='{?msg1} does not exist.';
	msgs['SPE10003']='Enter a numeric value between {?msg1} and {?msg2}, please.';
	msgs['SPE10004']='{?msg1} one must be selected.';
	msgs['SPE10005']='The value of portion {?msg1} must be.';
	msgs['SPE10006']='Process completed.';	
	msgs['SPE10007']='Please check {?msg1} first.';
	msgs['SPE10008']='Can create after retrieve.';
	 /**
	  * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
	  * 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
	  * <b>Example :</b>
	  *  
	  * <pre>
	  * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
	  * var arrData = ComXmlString(xmlStr, nm);
	  * 
	  * </pre>
	  * 
	  * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	  * @param {string} Text컬럼명.
	  * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
	  */
	 function ComXmlString(xmlStr, codeCol) {
	 	var rtnArr=new Array();
	 	if (xmlStr == null || xmlStr == "") {
	 		return rtnArr;
	 	}
	 	if (codeCol == null || codeCol == "") {
	 		return rtnArr;
	 	}
	 	try {
	          var xmlDoc = ComGetXmlDoc(xmlStr);
	          if (xmlDoc == null) return;
	          var xmlRoot = xmlDoc.documentElement;
	          
	 		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
	 		if (dataNode == null || dataNode.attributes.length < 3) {
	 			return rtnArr;
	 		}
	 		var col=dataNode.getAttribute("COLORDER");
	 		var colArr=col.split("|");
	 		var sep=dataNode.getAttribute("COLSEPARATOR");
	 		var total=dataNode.getAttribute("TOTAL");
	 		var dataChildNodes=dataNode.childNodes;
	 		if (dataChildNodes == null) {
	 			return rtnArr;
	 		}
	 		var colListIdx=Array();
	 		for ( var i=0; i < colArr.length; i++) {
	 			if (colArr[i] == codeCol) {
	 				colListIdx[0]=i;
	 			}
	 		}
	 		var sCode="";
	 		for ( var i=0; i < dataChildNodes.length; i++) {
	 			if (dataChildNodes[i].nodeType != 1) {
	 				continue;
	 			}
	 			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
	 			sCode += arrData[colListIdx[0]];
	 			if (i != dataChildNodes.length - 1) {
	 				sCode += "|";
	 			}
	 		}
	 		
			if(sCode.length > 0 &&  sCode.slice(-1) == "|"){
				sCode = sCode.substring(0,sCode.length-1)
			}
			
	 		rtnArr.push(sCode);
	 	} catch (err) {
	 		ComFuncErrMsg(err.message);
	 	}
	 	return rtnArr;
	 }
	 /**
	  * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. 빈값은 넣어주지 않는다.<br>
	  * @param{form} str  Form 객체  
	  * @param{chkElmNms} str   chkElmNms값들만 form elemente name으로 구성한다. 
	  */  
	  function speFormString(form, chkElmNms) {                 
	      if (typeof form != "object" ) {
	          //Msg : Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag. <== 모듈별 Error Msg 등록하여 사용
	          showMsg("");
	          return "";
	      }
	      var name=new Array(form.elements.length);
	      var value=new Array(form.elements.length);
	      var j=0;
	      var plain_text="";
	      //사용가능한 컨트롤을 배열로 생성한다.
	      len=form.elements.length;
	      for (i=0; i < len; i++) {
	        //클래스 아이디로 제품을 구분함-아래는 HTMl제품
	        switch (form.elements[i].type) {
	          case "button":
	          case "reset":
	          case "submit":
	                                break;
	          case "radio":
	          case "checkbox":
	                 if (form.elements[i].checked == true) {
	                         name[j]=form.elements[i].name;
	                         value[j]=form.elements[i].value;
	                          j++;
	                      }
	                      break;
	          case "select-one":
	                      name[j]=form.elements[i].name;
	                      var ind=form.elements[i].selectedIndex;
	                      if(ind >= 0) {
	                          if (form.elements[i].options[ind].value != '')
	                              value[j]=form.elements[i].options[ind].value;
	                          else
	                              value[j]='';
	                      } else {
	                          value[j]="";
	                      }
	                      j++;
	                      break;
	          case "select-multiple":
	                      name[j]=form.elements[i].name;
	                      var llen=form.elements[i].length;
	                      var increased=0;
	                      for( k=0; k < llen; k++) {
	                          if (form.elements[i].options[k].selected) {
	                              name[j]=form.elements[i].name;
	                              if (form.elements[i].options[k].value != '')
	                                  value[j]=form.elements[i].options[k].value;
	                              else
	                                  value[j]='';
	                              j++;
	                              increased++;
	                          }
	                      }
	                      if(increased > 0) {
	                          j--;
	                      } else {
	                          value[j]="";
	                      }
	                      j++;
	                      break;
	          default :
	                      if(form.elements[i].value.length >0 ) {
	                       if(chkElmNms!=null && chkElmNms!='' && chkElmNms!=undefined){
	                        if(checkExcludeElements(form.elements[i].name, chkElmNms)){
	                         name[j]=form.elements[i].name;
	                         value[j]=form.elements[i].value;
	                         j++;
	                        }
	                       } else {
	                       name[j]=form.elements[i].name;
	                        value[j]=form.elements[i].value;
	                        j++;
	                       }
	                      }
	          }
	      }
	      for (i=0; i < j; i++) {
	          if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
	      }
	      
	    if (plain_text != "")
	      plain_text=plain_text.substr(0, plain_text.length -1);
	    
	      return plain_text;
	  }
	  function checkExcludeElements(elmNm, chkElmNms){
	   var arr_chkElmNms='';
	   var rstTF=false;
	  try{
	    if(chkElmNms != null && chkElmNms != '' && chkElmNms != undefined){
	    	arr_chkElmNms=chkElmNms.split(',');
	     for(var i=0; i < arr_chkElmNms.length; i++){
	      if(arr_chkElmNms[i] != "") {
	       if(elmNm==null || elmNm=='' || elmNm==undefined){
	        rstTF=true;
	        break;
	       }else if(elmNm == arr_chkElmNms[i]){
	        rstTF=true;
	        break;
	       }
	      }
	     }
	     }
	  }catch(e){
	   rstTF=true;
	  }
	   return rstTF;
	  }
