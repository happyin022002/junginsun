/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VendorClassificationVO.java
*@FileTitle : VendorClassificationVO
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
public class VendorClassificationVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<VendorClassificationVO> models = new ArrayList<VendorClassificationVO>();

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String cntrVndrSvcCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vndrCostCd = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Page Number */
    private String pagerows = null;

    /* Request Number */
    private String rqstNo = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String cudFlg = null;

    /* Column Info */
    private String preVndrCostCd = null;

    /* Column Info */
    private String preCntrVndrSvcCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public VendorClassificationVO() {
    }

    public VendorClassificationVO(String ibflag, String pagerows, String vndrSeq, String vndrCostCd, String cntrVndrSvcCd, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String rqstNo, String usrId, String cudFlg, String preVndrCostCd, String preCntrVndrSvcCd) {
        this.updDt = updDt;
        this.cntrVndrSvcCd = cntrVndrSvcCd;
        this.creUsrId = creUsrId;
        this.ibflag = ibflag;
        this.vndrCostCd = vndrCostCd;
        this.deltFlg = deltFlg;
        this.vndrSeq = vndrSeq;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.pagerows = pagerows;
        this.rqstNo = rqstNo;
        this.usrId = usrId;
        this.cudFlg = cudFlg;
        this.preVndrCostCd = preVndrCostCd;
        this.preCntrVndrSvcCd = preCntrVndrSvcCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cntr_vndr_svc_cd", getCntrVndrSvcCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vndr_cost_cd", getVndrCostCd());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("rqst_no", getRqstNo());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("cud_flg", getCudFlg());
        this.hashColumns.put("pre_vndr_cost_cd", getPreVndrCostCd());
        this.hashColumns.put("pre_cntr_vndr_svc_cd", getPreCntrVndrSvcCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("cntr_vndr_svc_cd", "cntrVndrSvcCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vndr_cost_cd", "vndrCostCd");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("rqst_no", "rqstNo");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("cud_flg", "cudFlg");
        this.hashFields.put("pre_vndr_cost_cd", "preVndrCostCd");
        this.hashFields.put("pre_cntr_vndr_svc_cd", "preCntrVndrSvcCd");
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
	 * @return cntrVndrSvcCd
	 */
    public String getCntrVndrSvcCd() {
        return this.cntrVndrSvcCd;
    }

    /**
	 * Column Info
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
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
	 * @return vndrCostCd
	 */
    public String getVndrCostCd() {
        return this.vndrCostCd;
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
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
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
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 * Request Number
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
	 * @param cntrVndrSvcCd
	 */
    public void setCntrVndrSvcCd(String cntrVndrSvcCd) {
        this.cntrVndrSvcCd = cntrVndrSvcCd;
    }

    /**
	 * Column Info
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
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
	 * @param vndrCostCd
	 */
    public void setVndrCostCd(String vndrCostCd) {
        this.vndrCostCd = vndrCostCd;
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
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
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
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Request Number
	 * @param rqstNo
	 */
    public void setRqstNo(String rqstNo) {
        this.rqstNo = rqstNo;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrId() {
        return this.usrId;
    }

    public void setCudFlg(String cudFlg) {
        this.cudFlg = cudFlg;
    }

    public String getCudFlg() {
        return this.cudFlg;
    }

    public void setPreVndrCostCd(String preVndrCostCd) {
        this.preVndrCostCd = preVndrCostCd;
    }

    public String getPreVndrCostCd() {
        return this.preVndrCostCd;
    }

    public void setPreCntrVndrSvcCd(String preCntrVndrSvcCd) {
        this.preCntrVndrSvcCd = preCntrVndrSvcCd;
    }

    public String getPreCntrVndrSvcCd() {
        return this.preCntrVndrSvcCd;
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
        setCntrVndrSvcCd(JSPUtil.getParameter(request, prefix + "cntr_vndr_svc_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVndrCostCd(JSPUtil.getParameter(request, prefix + "vndr_cost_cd", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setCudFlg(JSPUtil.getParameter(request, prefix + "cud_flg", ""));
        setPreVndrCostCd(JSPUtil.getParameter(request, prefix + "pre_vndr_cost_cd", ""));
        setPreCntrVndrSvcCd(JSPUtil.getParameter(request, prefix + "pre_cntr_vndr_svc_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VendorClassificationVO[]
	 */
    public VendorClassificationVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VendorClassificationVO[]
	 */
    public VendorClassificationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        VendorClassificationVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] cntrVndrSvcCd = (JSPUtil.getParameter(request, prefix + "cntr_vndr_svc_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vndrCostCd = (JSPUtil.getParameter(request, prefix + "vndr_cost_cd", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] rqstNo = (JSPUtil.getParameter(request, prefix + "rqst_no", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] cudFlg = (JSPUtil.getParameter(request, prefix + "cud_flg", length));
            String[] preVndrCostCd = (JSPUtil.getParameter(request, prefix + "pre_vndr_cost_cd", length));
	    	String[] preCntrVndrSvcCd = (JSPUtil.getParameter(request, prefix + "pre_cntr_vndr_svc_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new VendorClassificationVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (cntrVndrSvcCd[i] != null)
                    model.setCntrVndrSvcCd(cntrVndrSvcCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vndrCostCd[i] != null)
                    model.setVndrCostCd(vndrCostCd[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (rqstNo[i] != null)
                    model.setRqstNo(rqstNo[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (cudFlg[i] != null)
                    model.setCudFlg(cudFlg[i]);
                if (preVndrCostCd[i] != null) 
		    		model.setPreVndrCostCd(preVndrCostCd[i]);
				if (preCntrVndrSvcCd[i] != null) 
		    		model.setPreCntrVndrSvcCd(preCntrVndrSvcCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getVendorClassificationVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return VendorClassificationVO[]
	 */
    public VendorClassificationVO[] getVendorClassificationVOs() {
        VendorClassificationVO[] vos = (VendorClassificationVO[]) models.toArray(new VendorClassificationVO[models.size()]);
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
        this.cntrVndrSvcCd = this.cntrVndrSvcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCostCd = this.vndrCostCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstNo = this.rqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cudFlg = this.cudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preVndrCostCd = this.preVndrCostCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preCntrVndrSvcCd = this.preCntrVndrSvcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
