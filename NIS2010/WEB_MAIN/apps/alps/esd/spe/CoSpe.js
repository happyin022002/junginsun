 var IBSEARCH01  = 29;  
 var IBSEARCH02  = 30;  
 var IBSEARCH03  = 31;  
 var IBSEARCH04  = 32;  
 var IBSEARCH05  = 33;  
 var IBSEARCH06  = 34;  

// SPE 추가 메세지
    msgs['SPE10001'] = 'Can not create anymore.';
    msgs['SPE10002'] = '{?msg1} does not exist.';
	msgs['SPE10003'] = 'Enter a numeric value between {?msg1} and {?msg2}, please.';
	msgs['SPE10004'] = '{?msg1} one must be selected.';
	msgs['SPE10005'] = 'The value of portion {?msg1} must be.';
	msgs['SPE10006'] = 'Process completed.';	
	msgs['SPE10007'] = 'Please check {?msg1} first.';
	msgs['SPE10008'] = 'Can create after retrieve.';
	msgs['SPE10009'] = 'Please Save the Basic {?msg1} first.';
	msgs['SPE10010'] = 'Cannot exceed the amount of 100.';
	msgs['SPE10011'] = 'You can not delete the data used';
	msgs['SPE10012'] = 'The sum of the {?msg1} must be 100';
	msgs['SPE10013'] = 'you need to check all qualitative evaluation items';
	msgs['SPE10014'] = "you didn't implement the qualitative evaluation in checked period";
	msgs['SPE10015'] = "If you save Performance Data, you cannot change it again.\nDo you want to save? ";
	
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
	 	var rtnArr = new Array();
	 	
	 	if (xmlStr == null || xmlStr == "") {
	 		return rtnArr;
	 	}
	 	
	 	if (codeCol == null || codeCol == "") {
	 		return rtnArr;
	 	}

	 	try {
	 		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
	 		xmlDoc.loadXML(xmlStr);

	 		var xmlRoot = xmlDoc.documentElement;
	 		if (xmlRoot == null) {
	 			return rtnArr;
	 		}

	 		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
	 		if (dataNode == null || dataNode.attributes.length < 3) {
	 			return rtnArr;
	 		}

	 		var col = dataNode.getAttribute("COLORDER");
	 		var colArr = col.split("|");
	 		var sep = dataNode.getAttribute("COLSEPARATOR");
	 		var total = dataNode.getAttribute("TOTAL");

	 		var dataChildNodes = dataNode.childNodes;
	 		if (dataChildNodes == null) {
	 			return rtnArr;
	 		}
	 		
	 		var colListIdx = Array();
	 		for ( var i = 0; i < colArr.length; i++) {
	 			if (colArr[i] == codeCol) {
	 				colListIdx[0] = i;
	 			}
	 		}
	 		
	 		var sCode = "";
	 		for ( var i = 0; i < dataChildNodes.length; i++) {
	 			if (dataChildNodes[i].nodeType != 1) {
	 				continue;
	 			}
	 			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
	 			
	 			sCode += arrData[colListIdx[0]];
	 			
	 			if (i != dataChildNodes.length - 1) {
	 				sCode += "|";
	 			}
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
	      if (typeof form != "object" || form.tagName != "FORM") {
	          //Msg : Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag. <== 모듈별 Error Msg 등록하여 사용
	          showMsg("");
	          return "";
	      }
	      var name = new Array(form.elements.length);
	      var value = new Array(form.elements.length);
	      var j = 0;
	      var plain_text="";
	 
	      //사용가능한 컨트롤을 배열로 생성한다.
	      len = form.elements.length;

	      for (i = 0; i < len; i++) {

	        //클래스 아이디로 제품을 구분함-아래는 HTMl제품
	        if(form.elements[i].classid==undefined && checkExcludeElements(form.elements[i].name, chkElmNms)){
	        	
	        switch (form.elements[i].type) {
	          case "button":
	          case "reset":
	          case "submit":
	                                break;
	          case "radio":
	          case "checkbox":
	                 if (form.elements[i].checked == true) {
	                         name[j] = form.elements[i].name;
	                         value[j] = form.elements[i].value;
	                          j++;
	                      }
	                      break;
	          case "select-one":
	                      name[j] = form.elements[i].name;
	                      var ind = form.elements[i].selectedIndex;
	                      if(ind >= 0) {
	                          if (form.elements[i].options[ind].value != '')
	                              value[j] = form.elements[i].options[ind].value;
	                          else
	                              value[j] = '';
	                      } else {
	                          value[j] = "";
	                      }
	                      j++;
	                      break;
	          case "select-multiple":
	                      name[j] = form.elements[i].name;
	                      var llen = form.elements[i].length;
	                      var increased = 0;
	                      for( k = 0; k < llen; k++) {
	                          if (form.elements[i].options[k].selected) {
	                              name[j] = form.elements[i].name;
	                              if (form.elements[i].options[k].value != '')
	                                  value[j] = form.elements[i].options[k].value;
	                              else
	                                  value[j] = '';
	                              j++;
	                              increased++;
	                          }
	                      }
	                      if(increased > 0) {
	                          j--;
	                      } else {
	                          value[j] = "";
	                      }
	                      j++;
	                      break;
	          default :
	                      if(form.elements[i].value.length >0 ) {
	                       if(chkElmNms!=null && chkElmNms!='' && chkElmNms!=undefined){
	                        if(checkExcludeElements(form.elements[i].name, chkElmNms)){
	                         name[j] = form.elements[i].name;
	                         value[j] = form.elements[i].value;
	                         j++;
	                        }
	                       } else {
	                       name[j] = form.elements[i].name;
	                        value[j] = form.elements[i].value;
	                        j++;
	                       }
	                      }
	          }

	      //IB에서 제공하는 컨트롤의 값을 조합한다.
	      }else{
	        switch(form.elements[i].classid){
	          case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":          // IBMaskEdit 경우
	            name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
	                  value[j] = form.elements[i].Value;
	                  j++;
	            break;
	          case CLSID_IBMCOMBO: // IBMultiCombo 경우
	            name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
	              if(form.elements[i].UseCode)
	               value[j] = form.elements[i].Code;
	              else
	               value[j] = form.elements[i].Text;
	                  j++;
	                  break;
	        }
	      }
	      }
	      // QueryString을 조합한다.
	      //   1) Explorer 5.5 이상일 경우, encodeURIComponent() 를 이용하여 URL Encode
	      //   2) 기타 경우는 IB Sheet 를 이용하여 URL Encode
	      var webBrowserName = navigator.appName;
	      var webBrowserVer  = navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE") + 5,
	                                                          navigator.appVersion.indexOf("MSIE") + 8)
	      if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
	          for (i = 0; i < j; i++) {
	              // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
	              if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
	          }
	      } else {
	          var tmpUrlEncodeSheet    = document.getElementById("formquerystring");
	          if( tmpUrlEncodeSheet == undefined || tmpUrlEncodeSheet == null || tmpUrlEncodeSheet == '')
	          {
	              //인코딩을 위해 숨겨진IBSheet를 만든다.
	              var sTag = ComGetSheetObjectTag("formquerystring");
	              form.insertAdjacentHTML('afterEnd', sTag);
	          }
	          for (i = 0; i < j; i++) {
	              // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
	              if (name[i] != '') plain_text += name[i]+ "=" + formquerystring.UrlEncoding(value[i]) + "&";
	          }
	      }

	    //마지막에 &를 없애기 위함
	    if (plain_text != "")
	      plain_text = plain_text.substr(0, plain_text.length -1);
	      return plain_text;
	  }
	   
	  function checkExcludeElements(elmNm, chkElmNms){
	   var arr_chkElmNms = '';
	   var rstTF = false;
	 
	  try{
	    if(chkElmNms != null && chkElmNms != '' && chkElmNms != undefined){
	    	arr_chkElmNms = chkElmNms.split(',');
	      
	     for(var i =0; i < arr_chkElmNms.length; i++){
	      if(arr_chkElmNms[i] != "") {
	       if(elmNm==null || elmNm=='' || elmNm==undefined){
	        rstTF = true;
	        break;
	       }else if(elmNm == arr_chkElmNms[i]){
	        rstTF = true;
	        break;
	       }
	      }
	     }
	     
	     }
	  }catch(e){
	   rstTF = true;
	  }
	   
	   return rstTF;
	  }
	  
		/**
		 * 조회한 값을 String 형태로 변경한다.. <br>
		 * <br><b>Example :</b>
		 * <pre>
		 * </pre>
		 * @param IBSheet 의 sXml 값
		 * @return string
		 * @version 1.0.0.0
		 */    
		function SpeXmlString(xmlStr, codeCol) {
			var rtnArr = new Array();
			if (xmlStr == null || xmlStr == "") {
				return;
			}
			if (codeCol == null || codeCol == "" ) {
				return;
			}
		
			try {
				var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
					xmlDoc.loadXML(xmlStr);
				
				var xmlRoot = xmlDoc.documentElement;
				if (xmlRoot == null) {
					return;
				}
				
				var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
				if (dataNode == null){
					return;
				
				}
				
				if(dataNode.getAttribute("TOTAL")==0){
					return 0;
				}
				
				if( dataNode.attributes.length < 3) {
					return;
				}
				
				
				var col = dataNode.getAttribute("COLORDER");
				var colArr = col.split("|");
				var total = dataNode.getAttribute("TOTAL");
				var sep = dataNode.getAttribute("COLSEPARATOR");
				    
				
				var dataChildNodes = dataNode.childNodes;
				if (dataChildNodes == null) {
					return;
				}
				
				var colListIdx = Array();
				for ( var i = 0; i < colArr.length; i++) {
					if (colArr[i] == codeCol) {
						colListIdx[0] = i;
					}
				}
				
				var sCode = "";
				
				for ( var i = 0; i < dataChildNodes.length; i++) {
					if (dataChildNodes[i].nodeType != 1) {
						continue;
					}
					var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
					
					sCode += arrData[colListIdx[0]];
					
					if (i != dataChildNodes.length - 1) {
							sCode += "|";
					}
				}
		
			} catch (err) {
				ComFuncErrMsg(err.message);
			}

			return sCode;
		}	  
	  
		// 공통테이블에 등록된 코드값을 조회 한다.    
		function searchCommonCombo(codeKey,comboObj,sheetObj){
			if(sheetObj==null){
				sheetObj = sheetObjects[1];
			}
				frm.f_cmd.value = SEARCH01;
				// 공통 테이블에서 조회할 키
				frm.code_key.value = codeKey
				var sXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
				ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
				
				return sXml; 
		}		
		
		// 공통테이블에 등록된 코드값을 조회 한다.    
		function search03CommonCombo(codeKey,comboObj,sheetObj){
			if(sheetObj==null){
				sheetObj = sheetObjects[1];
			}
			frm.f_cmd.value = SEARCH03;
			// 공통 테이블에서 조회할 키
			frm.code_key.value = codeKey
			var sXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
			ComXml2ComboItem(sXml, comboObj, "code_cd", "code_cd");	
			
			
			return sXml; 
		}
		
		 /**
		  * select box onChange시 포커스 아웃
		  * 
		  */
		 function focusOut() {
		 	document.body.focus();
		 }
		 
		 
		 		
	  