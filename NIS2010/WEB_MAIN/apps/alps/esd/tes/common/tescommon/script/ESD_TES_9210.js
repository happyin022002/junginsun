

	String.prototype.trim = function()
	{
		return this.replace(/(^\s*)|(\s*$)/g, "");
	}

	/**
	 * Input Value Check. 
	 * @param {obj}  	obj
	 **/
	function tes_chkInput(obj) {
//		ComShowMessage(obj.maxLength + ' / ' + obj.value.length + ' -- strleng: '+tes_getStrLen(obj.value));
		if (obj.maxLength < tes_getStrLen(obj.value))
		{
			obj.value = '';
			obj.focus();
			return false;
		}
	}

	/**
	 * 한글 및 영문 str의 길이를 구함
	 * 
	 * @param {src}  	src
	 **/
	function tes_getStrLen(src) {

		src = new String(src);
		var byteLength = 0;
		for (var inx = 0; inx < src.length; inx++) {
			var oneChar = escape(src.charAt(inx));
			if (oneChar.length == 1) {
				byteLength ++;
			} else if (oneChar.indexOf("%u") != -1) {
				byteLength = byteLength + 2;
			} else if (oneChar.indexOf("%") != -1) {
				byteLength = byteLength + oneChar.length/3;
			}
		}
		return byteLength;
	}

    /**
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
//		ComShowMessage(hld_rmk_inp_nm);
//		document.form.hld_rmk.value = opener.document.form.hld_rmk.value;

		document.form.hld_rmk.value = eval('window.dialogArguments.document.form.'+hld_rmk_inp_nm+'.value');
    }


	/**
	 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
	 **/
	document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
	 **/
    function processButtonClick(){

        var formObj = document.form;

    	 try {

    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_save":
//					opener.document.form.hld_rmk.value = formObj.hld_rmk.value;
					var opr_hld_rmk_obj = eval('window.dialogArguments.document.form.'+hld_rmk_inp_nm);
					opr_hld_rmk_obj.value = formObj.hld_rmk.value;
					window.close();
        	        break;

         	    case "btn_close":
    	            window.close();
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


