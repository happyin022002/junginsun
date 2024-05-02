
<%@ page contentType="text/html; charset=UTF-8"%>

<script language="javascript">
    function setupPage(){  
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">

<div class="page_title_area clear">
	
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_Transmit" id="btn_Transmit">Transmit</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="100px" />
            <col width="*" />
        </colgroup>
		<tbody>
			<tr>
				<th>County</th>
				<td>
					<input type="text" name="cnt_cd" dataformat="engup" required>
				</td>
			</tr>
			<tr>
				<th>Message</th>
				<td>
					<textarea  name="flat_file" required style="width:600px" rows="20"></textarea>
				</td>
			</tr>
			
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->
<div style="display: none">
<script language="javascript">ComSheetObject('sheet1');</script>
</div>
</form>
