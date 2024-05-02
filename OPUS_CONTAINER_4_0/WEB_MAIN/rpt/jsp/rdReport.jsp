<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : rdReport.jsp
*@FileTitle  : Report Common
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/11
=========================================================*/
%>
<script language="javascript" src="/opuscntr/rpt/script/rdviewer50.js"></script>
<script language="javascript">
function setupPage(){
	rdOpen();
}
</script>
<form name="form">
<div class="layer_popup_title">	
	<div class="page_title_area clear">
		<div class="opus_design_btn">
			   <button type="button" class="btn_normal" onclick="Save_OnClick()">Save</button><!--
			--><button type="button" class="btn_normal" onclick="Print_OnClick()">Print</button><!--
			--><button type="button" class="btn_normal" onclick="First_OnClick()">First</button><!--
			--><button type="button" class="btn_normal" onclick="Prev_OnClick()">Back</button><!--
			--><button type="button" class="btn_normal" onclick="Next_OnClick()">Next</button><!--
			--><button type="button" class="btn_normal" onclick="Last_OnClick()">Last</button><!--
			--><button type="button" class="btn_normal" onclick="ZoomIn_OnClick()">Zoom In(+)</button><!--
			--><button type="button" class="btn_normal" onclick="ZoomOut_OnClick()">Zoom Out(-)</button><!--
			--><button type="button" class="btn_normal" onclick="ComClosePopup()">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_RD"> 
			<script type="text/javascript">comRdObject('Rdviewer');</script>
	    </div>
	</div>
</div>
</form>