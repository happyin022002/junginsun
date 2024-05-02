<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Hold Notice Send Batch Test</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function sendPage() {
        var frm = document.form;
        frm.target = "_blank";
        
        if (frm.bl_no.value == "") {
            alert("BL No.");
            return;
        }
        
        if (frm.cstms_loc_cd.value == "") {
            alert("Loc CD");
            return;
        }
        
        if (frm.hld_cd.value == "") {
            alert("Pre Code");
            return;
        }
        
        if (frm.hld_type.value == "CF") {
            if (frm.rlse_hld_cd.value == "") {
                alert("Release Code");
                return;
            }
        }
        frm.submit();        
    }
</script>
</head>

<body>
<form name="form" action="/opuscntr/ESM_BKG_0510GS.do">
<input type="hidden" name="f_cmd" value="50" />
<!-- 개발자 작업	-->

<table>
    <tr>
        <td>
            Pre-Hold<input type="radio" name="hld_type" id="hld_type" value="PH" checked="" />
            Confirm-Hold<input type="radio" name="hld_type" id="hld_type" value="CF" />
            <input type="button" value="전송" onclick="sendPage()" />
        </td>
    </tr>
    <tr>
        <td>
            BL No. <input type="text" name="bl_no" id="bl_no" /> <br />
            Loc CD <input type="text" name="cstms_loc_cd" id="cstms_loc_cd" /><br />
            Pre Code<input type="text" size="2" name="hld_cd" id="hld_cd" /><br />
            Pre Date<input type="text" name="hld_dt" id="hld_dt" /> ex)2009-10-01 <br />
            Release Code<input type="text" size="2" name="rlse_hld_cd" id="rlse_hld_cd" /><br />            
            Release Date<input type="text" name="rlse_hld_dt" id="rlse_hld_dt" /> ex) 2009-10-01
        </td>
    </tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>