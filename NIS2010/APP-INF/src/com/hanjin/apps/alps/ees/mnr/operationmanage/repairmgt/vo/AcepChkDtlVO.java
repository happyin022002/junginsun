/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AcepChkDtlVO.java
*@FileTitle : AcepChkDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.03  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class AcepChkDtlVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<AcepChkDtlVO> models = new ArrayList<AcepChkDtlVO>();

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String inspItmNm = null;

    /* Column Info */
    private String acepChk = null;

    /* Column Info */
    private String acepDtlSeq = null;

    /* Column Info */
    private String acepUnchk = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String inspChkFlg = null;

    /* Column Info */
    private String inspItmNo = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String acepSeq = null;

    /* Column Info */
    private String creUsrNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public AcepChkDtlVO() {
    }

    public AcepChkDtlVO(String ibflag, String pagerows, String acepSeq, String acepDtlSeq, String inspItmNo, String inspItmNm, String acepChk, String acepUnchk, String creUsrId, String creDt, String updUsrId, String updDt, String inspChkFlg, String creUsrNm) {
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.inspItmNm = inspItmNm;
        this.acepChk = acepChk;
        this.acepDtlSeq = acepDtlSeq;
        this.acepUnchk = acepUnchk;
        this.updUsrId = updUsrId;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.inspChkFlg = inspChkFlg;
        this.inspItmNo = inspItmNo;
        this.updDt = updDt;
        this.acepSeq = acepSeq;
        this.creUsrNm = creUsrNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("insp_itm_nm", getInspItmNm());
        this.hashColumns.put("acep_chk", getAcepChk());
        this.hashColumns.put("acep_dtl_seq", getAcepDtlSeq());
        this.hashColumns.put("acep_unchk", getAcepUnchk());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("insp_chk_flg", getInspChkFlg());
        this.hashColumns.put("insp_itm_no", getInspItmNo());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("acep_seq", getAcepSeq());
        this.hashColumns.put("cre_usr_nm", getCreUsrNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("insp_itm_nm", "inspItmNm");
        this.hashFields.put("acep_chk", "acepChk");
        this.hashFields.put("acep_dtl_seq", "acepDtlSeq");
        this.hashFields.put("acep_unchk", "acepUnchk");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("insp_chk_flg", "inspChkFlg");
        this.hashFields.put("insp_itm_no", "inspItmNo");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("acep_seq", "acepSeq");
        this.hashFields.put("cre_usr_nm", "creUsrNm");
        return this.hashFields;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return inspItmNm
	 */
    public String getInspItmNm() {
        return this.inspItmNm;
    }

    /**
	 * Column Info
	 * @return acepChk
	 */
    public String getAcepChk() {
        return this.acepChk;
    }

    /**
	 * Column Info
	 * @return acepDtlSeq
	 */
    public String getAcepDtlSeq() {
        return this.acepDtlSeq;
    }

    /**
	 * Column Info
	 * @return acepUnchk
	 */
    public String getAcepUnchk() {
        return this.acepUnchk;
    }

    /**
	 * Column Info
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 * Column Info
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Column Info
	 * @return inspChkFlg
	 */
    public String getInspChkFlg() {
        return this.inspChkFlg;
    }

    /**
	 * Column Info
	 * @return inspItmNo
	 */
    public String getInspItmNo() {
        return this.inspItmNo;
    }

    /**
	 * Column Info
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Column Info
	 * @return acepSeq
	 */
    public String getAcepSeq() {
        return this.acepSeq;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param inspItmNm
	 */
    public void setInspItmNm(String inspItmNm) {
        this.inspItmNm = inspItmNm;
    }

    /**
	 * Column Info
	 * @param acepChk
	 */
    public void setAcepChk(String acepChk) {
        this.acepChk = acepChk;
    }

    /**
	 * Column Info
	 * @param acepDtlSeq
	 */
    public void setAcepDtlSeq(String acepDtlSeq) {
        this.acepDtlSeq = acepDtlSeq;
    }

    /**
	 * Column Info
	 * @param acepUnchk
	 */
    public void setAcepUnchk(String acepUnchk) {
        this.acepUnchk = acepUnchk;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param inspChkFlg
	 */
    public void setInspChkFlg(String inspChkFlg) {
        this.inspChkFlg = inspChkFlg;
    }

    /**
	 * Column Info
	 * @param inspItmNo
	 */
    public void setInspItmNo(String inspItmNo) {
        this.inspItmNo = inspItmNo;
    }

    /**
	 * Column Info
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param acepSeq
	 */
    public void setAcepSeq(String acepSeq) {
        this.acepSeq = acepSeq;
    }

    public void setCreUsrNm(String creUsrNm) {
        this.creUsrNm = creUsrNm;
    }

    public String getCreUsrNm() {
        return this.creUsrNm;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setInspItmNm(JSPUtil.getParameter(request, prefix + "insp_itm_nm", ""));
        setAcepChk(JSPUtil.getParameter(request, prefix + "acep_chk", ""));
        setAcepDtlSeq(JSPUtil.getParameter(request, prefix + "acep_dtl_seq", ""));
        setAcepUnchk(JSPUtil.getParameter(request, prefix + "acep_unchk", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setInspChkFlg(JSPUtil.getParameter(request, prefix + "insp_chk_flg", ""));
        setInspItmNo(JSPUtil.getParameter(request, prefix + "insp_itm_no", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setAcepSeq(JSPUtil.getParameter(request, prefix + "acep_seq", ""));
        setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AcepChkDtlVO[]
	 */
    public AcepChkDtlVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AcepChkDtlVO[]
	 */
    public AcepChkDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        AcepChkDtlVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] inspItmNm = (JSPUtil.getParameter(request, prefix + "insp_itm_nm", length));
            String[] acepChk = (JSPUtil.getParameter(request, prefix + "acep_chk", length));
            String[] acepDtlSeq = (JSPUtil.getParameter(request, prefix + "acep_dtl_seq", length));
            String[] acepUnchk = (JSPUtil.getParameter(request, prefix + "acep_unchk", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] inspChkFlg = (JSPUtil.getParameter(request, prefix + "insp_chk_flg", length));
            String[] inspItmNo = (JSPUtil.getParameter(request, prefix + "insp_itm_no", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] acepSeq = (JSPUtil.getParameter(request, prefix + "acep_seq", length));
            String[] creUsrNm = (JSPUtil.getParameter(request, prefix + "cre_usr_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new AcepChkDtlVO();
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (inspItmNm[i] != null)
                    model.setInspItmNm(inspItmNm[i]);
                if (acepChk[i] != null)
                    model.setAcepChk(acepChk[i]);
                if (acepDtlSeq[i] != null)
                    model.setAcepDtlSeq(acepDtlSeq[i]);
                if (acepUnchk[i] != null)
                    model.setAcepUnchk(acepUnchk[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (inspChkFlg[i] != null)
                    model.setInspChkFlg(inspChkFlg[i]);
                if (inspItmNo[i] != null)
                    model.setInspItmNo(inspItmNo[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (acepSeq[i] != null)
                    model.setAcepSeq(acepSeq[i]);
                if (creUsrNm[i] != null) 
		    		model.setCreUsrNm(creUsrNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getAcepChkDtlVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return AcepChkDtlVO[]
	 */
    public AcepChkDtlVO[] getAcepChkDtlVOs() {
        AcepChkDtlVO[] vos = (AcepChkDtlVO[]) models.toArray(new AcepChkDtlVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inspItmNm = this.inspItmNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acepChk = this.acepChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acepDtlSeq = this.acepDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acepUnchk = this.acepUnchk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inspChkFlg = this.inspChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inspItmNo = this.inspItmNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acepSeq = this.acepSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrNm = this.creUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
