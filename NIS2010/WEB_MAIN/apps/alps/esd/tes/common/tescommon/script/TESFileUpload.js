
	// 공통전역변수
	var opener_obj = window.dialogArguments;

    /**
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
	function loadPage() {
		if (strSuccessFlag!=undefined && strSuccessFlag!=null) {
			if (strSuccessFlag.trim()=='SUCCESS') {
				opener_obj.fileRetreive();
				window.close();
			} else if (strSuccessFlag.trim()=='FAILURE') {
				ComShowMessage('FAILURE');
			}
		}
	}


	/**
	 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
	 **/
	document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
	 **/
    function processButtonClick() {
			
         var formObj = document.fileUploadForm;

    	 try {

    		var srcName = window.event.srcElement.getAttribute("name");
            
			switch(srcName) {
         	    case "btn_ok":
					if (formObj.uploadfile.value.length>0) {
						var last_index_idx = formObj.uploadfile.value.lastIndexOf('.');
						if (last_index_idx > 0){
							if (formObj.uploadfile.value.substring(last_index_idx+1).toUpperCase()!='PDF'){
								ComShowCodeMessage('TES90102');    // 'It is NOT PDF file!'
								return false;
							}
						} else if (last_index_idx == 0) {
							ComShowMessage('It is NOT PDF file!');
							return false;
						}
						formObj.f_cmd.value = SEARCHLIST05;
						formObj.target = "ifr_file";
						formObj.action = "TESFileUpload2.do";
						formObj.submit();
					} else {
						ComShowCodeMessage('TES90103');    // No file is selected.
						return false;
					}
        	        break;

				case "btn_delete": //아직은 미사용
					ComShowMessage('btn_delete');
        	        break;

         	    case "btn_close":
    	            window.close();
        	        break;
 
            }
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }


