/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VendorContactVO.java
*@FileTitle : VendorContactVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2011.03.07  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
public class VendorContactVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<VendorContactVO> models = new ArrayList<VendorContactVO>();

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String phnNo = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String eaiEvntDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vndrEml = null;

    /* Column Info */
    private String cntcDivCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String vndrCntcPntSeq = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String prmryChkFlg = null;

    /* Column Info */
    private String faxNo = null;

    /* Column Info */
    private String intlFaxNo = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String intlPhnNo = null;

    /* Column Info */
    private String rqstNo = null;

    /* Column Info */
    private String cudFlg = null;

    /* Column Info */
    private String usrId = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public VendorContactVO() {
    }

    public VendorContactVO(String ibflag, String pagerows, String vndrSeq, String vndrCntcPntSeq, String intlPhnNo, String phnNo, String intlFaxNo, String faxNo, String vndrEml, String eaiEvntDt, String prmryChkFlg, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String cntcDivCd, String rqstNo, String cudFlg, String usrId) {
        this.updDt = updDt;
        this.phnNo = phnNo;
        this.deltFlg = deltFlg;
        this.creDt = creDt;
        this.eaiEvntDt = eaiEvntDt;
        this.pagerows = pagerows;
        this.vndrEml = vndrEml;
        this.cntcDivCd = cntcDivCd;
        this.ibflag = ibflag;
        this.creUsrId = creUsrId;
        this.vndrCntcPntSeq = vndrCntcPntSeq;
        this.vndrSeq = vndrSeq;
        this.prmryChkFlg = prmryChkFlg;
        this.faxNo = faxNo;
        this.intlFaxNo = intlFaxNo;
        this.updUsrId = updUsrId;
        this.intlPhnNo = intlPhnNo;
        this.rqstNo = rqstNo;
        this.cudFlg = cudFlg;
        this.usrId = usrId;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("phn_no", getPhnNo());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vndr_eml", getVndrEml());
        this.hashColumns.put("cntc_div_cd", getCntcDivCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("vndr_cntc_pnt_seq", getVndrCntcPntSeq());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
        this.hashColumns.put("fax_no", getFaxNo());
        this.hashColumns.put("intl_fax_no", getIntlFaxNo());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("intl_phn_no", getIntlPhnNo());
        this.hashColumns.put("rqst_no", getRqstNo());
        this.hashColumns.put("cud_flg", getCudFlg());
        this.hashColumns.put("usr_id", getUsrId());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vndr_eml", "vndrEml");
        this.hashFields.put("cntc_div_cd", "cntcDivCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("vndr_cntc_pnt_seq", "vndrCntcPntSeq");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("intl_fax_no", "intlFaxNo");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("intl_phn_no", "intlPhnNo");
        this.hashFields.put("rqst_no", "rqstNo");
        this.hashFields.put("cud_flg", "cudFlg");
        this.hashFields.put("usr_id", "usrId");
        return this.hashFields;
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
	 * @return phnNo
	 */
    public String getPhnNo() {
        return this.phnNo;
    }

    /**
	 * Column Info
	 * @return deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
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
	 * @return eaiEvntDt
	 */
    public String getEaiEvntDt() {
        return this.eaiEvntDt;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 * Column Info
	 * @return vndrEml
	 */
    public String getVndrEml() {
        return this.vndrEml;
    }

    /**
	 * Column Info
	 * @return cntcDivCd
	 */
    public String getCntcDivCd() {
        return this.cntcDivCd;
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
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return vndrCntcPntSeq
	 */
    public String getVndrCntcPntSeq() {
        return this.vndrCntcPntSeq;
    }

    /**
	 * Column Info
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 * Column Info
	 * @return prmryChkFlg
	 */
    public String getPrmryChkFlg() {
        return this.prmryChkFlg;
    }

    /**
	 * Column Info
	 * @return faxNo
	 */
    public String getFaxNo() {
        return this.faxNo;
    }

    /**
	 * Column Info
	 * @return intlFaxNo
	 */
    public String getIntlFaxNo() {
        return this.intlFaxNo;
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
	 * @return intlPhnNo
	 */
    public String getIntlPhnNo() {
        return this.intlPhnNo;
    }

    /**
	 * Column Info
	 * @return rqstNo
	 */
    public String getRqstNo() {
        return this.rqstNo;
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
	 * @param phnNo
	 */
    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    /**
	 * Column Info
	 * @param deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
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
	 * @param eaiEvntDt
	 */
    public void setEaiEvntDt(String eaiEvntDt) {
        this.eaiEvntDt = eaiEvntDt;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param vndrEml
	 */
    public void setVndrEml(String vndrEml) {
        this.vndrEml = vndrEml;
    }

    /**
	 * Column Info
	 * @param cntcDivCd
	 */
    public void setCntcDivCd(String cntcDivCd) {
        this.cntcDivCd = cntcDivCd;
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
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param vndrCntcPntSeq
	 */
    public void setVndrCntcPntSeq(String vndrCntcPntSeq) {
        this.vndrCntcPntSeq = vndrCntcPntSeq;
    }

    /**
	 * Column Info
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * Column Info
	 * @param prmryChkFlg
	 */
    public void setPrmryChkFlg(String prmryChkFlg) {
        this.prmryChkFlg = prmryChkFlg;
    }

    /**
	 * Column Info
	 * @param faxNo
	 */
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    /**
	 * Column Info
	 * @param intlFaxNo
	 */
    public void setIntlFaxNo(String intlFaxNo) {
        this.intlFaxNo = intlFaxNo;
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
	 * @param intlPhnNo
	 */
    public void setIntlPhnNo(String intlPhnNo) {
        this.intlPhnNo = intlPhnNo;
    }

    /**
	 * Column Info
	 * @param rqstNo
	 */
    public void setRqstNo(String rqstNo) {
        this.rqstNo = rqstNo;
    }

    public void setCudFlg(String cudFlg) {
        this.cudFlg = cudFlg;
    }

    public String getCudFlg() {
        return this.cudFlg;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrId() {
        return this.usrId;
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
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVndrEml(JSPUtil.getParameter(request, prefix + "vndr_eml", ""));
        setCntcDivCd(JSPUtil.getParameter(request, prefix + "cntc_div_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setVndrCntcPntSeq(JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_seq", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setPrmryChkFlg(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
        setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
        setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
        setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
        setCudFlg(JSPUtil.getParameter(request, prefix + "cud_flg", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VendorContactVO[]
	 */
    public VendorContactVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VendorContactVO[]
	 */
    public VendorContactVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        VendorContactVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] phnNo = (JSPUtil.getParameter(request, prefix + "phn_no", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix + "eai_evnt_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vndrEml = (JSPUtil.getParameter(request, prefix + "vndr_eml", length));
            String[] cntcDivCd = (JSPUtil.getParameter(request, prefix + "cntc_div_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] vndrCntcPntSeq = (JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_seq", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix + "prmry_chk_flg", length));
            String[] faxNo = (JSPUtil.getParameter(request, prefix + "fax_no", length));
            String[] intlFaxNo = (JSPUtil.getParameter(request, prefix + "intl_fax_no", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] intlPhnNo = (JSPUtil.getParameter(request, prefix + "intl_phn_no", length));
            String[] rqstNo = (JSPUtil.getParameter(request, prefix + "rqst_no", length));
            String[] cudFlg = (JSPUtil.getParameter(request, prefix + "cud_flg", length));
	    	String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new VendorContactVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (phnNo[i] != null)
                    model.setPhnNo(phnNo[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (eaiEvntDt[i] != null)
                    model.setEaiEvntDt(eaiEvntDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vndrEml[i] != null)
                    model.setVndrEml(vndrEml[i]);
                if (cntcDivCd[i] != null)
                    model.setCntcDivCd(cntcDivCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (vndrCntcPntSeq[i] != null)
                    model.setVndrCntcPntSeq(vndrCntcPntSeq[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (prmryChkFlg[i] != null)
                    model.setPrmryChkFlg(prmryChkFlg[i]);
                if (faxNo[i] != null)
                    model.setFaxNo(faxNo[i]);
                if (intlFaxNo[i] != null)
                    model.setIntlFaxNo(intlFaxNo[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (intlPhnNo[i] != null)
                    model.setIntlPhnNo(intlPhnNo[i]);
                if (rqstNo[i] != null)
                    model.setRqstNo(rqstNo[i]);
                if (cudFlg[i] != null) 
		    		model.setCudFlg(cudFlg[i]);
				if (usrId[i] != null) 
		    		model.setUsrId(usrId[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getVendorContactVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return VendorContactVO[]
	 */
    public VendorContactVO[] getVendorContactVOs() {
        VendorContactVO[] vos = (VendorContactVO[]) models.toArray(new VendorContactVO[models.size()]);
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
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phnNo = this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiEvntDt = this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrEml = this.vndrEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcDivCd = this.cntcDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCntcPntSeq = this.vndrCntcPntSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prmryChkFlg = this.prmryChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxNo = this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlFaxNo = this.intlFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlPhnNo = this.intlPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstNo = this.rqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cudFlg = this.cudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
