/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSSMVO.java
*@FileTitle : CSSMVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.26  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CSSMVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CSSMVO> models = new ArrayList<CSSMVO>();

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String insfCnqeVal = null;

    /* Column Info */
    private String insfDvCd = null;

    /* Column Info */
    private String ibCssmVoyNo = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String vslSlanCd = null;

    /* Column Info */
    private String insfId = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vpsPortCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String insfDttm = null;

    /* Column Info */
    private String insfPrsId = null;

    /* Column Info */
    private String cssmVoyNoIfSeq = null;

    /* Column Info */
    private String obCssmVoyNo = null;

    /* Column Info */
    private String insfCnqeCont = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String clptIndSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public CSSMVO() {
    }

    public CSSMVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String cssmVoyNoIfSeq, String vslSlanCd, String ibCssmVoyNo, String obCssmVoyNo, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String insfCnqeCont, String creUsrId, String creDt, String updUsrId, String updDt, String clptIndSeq) {
        this.updDt = updDt;
        this.vslCd = vslCd;
        this.insfCnqeVal = insfCnqeVal;
        this.insfDvCd = insfDvCd;
        this.ibCssmVoyNo = ibCssmVoyNo;
        this.creDt = creDt;
        this.skdVoyNo = skdVoyNo;
        this.vslSlanCd = vslSlanCd;
        this.insfId = insfId;
        this.skdDirCd = skdDirCd;
        this.pagerows = pagerows;
        this.vpsPortCd = vpsPortCd;
        this.creUsrId = creUsrId;
        this.ibflag = ibflag;
        this.insfDttm = insfDttm;
        this.insfPrsId = insfPrsId;
        this.cssmVoyNoIfSeq = cssmVoyNoIfSeq;
        this.obCssmVoyNo = obCssmVoyNo;
        this.insfCnqeCont = insfCnqeCont;
        this.updUsrId = updUsrId;
        this.clptIndSeq = clptIndSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("insf_cnqe_val", getInsfCnqeVal());
        this.hashColumns.put("insf_dv_cd", getInsfDvCd());
        this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("insf_id", getInsfId());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("insf_dttm", getInsfDttm());
        this.hashColumns.put("insf_prs_id", getInsfPrsId());
        this.hashColumns.put("cssm_voy_no_if_seq", getCssmVoyNoIfSeq());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("insf_cnqe_cont", getInsfCnqeCont());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
        this.hashFields.put("insf_dv_cd", "insfDvCd");
        this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("insf_id", "insfId");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("insf_dttm", "insfDttm");
        this.hashFields.put("insf_prs_id", "insfPrsId");
        this.hashFields.put("cssm_voy_no_if_seq", "cssmVoyNoIfSeq");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("insf_cnqe_cont", "insfCnqeCont");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("clpt_ind_seq", "clptIndSeq");
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
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 * Column Info
	 * @return insfCnqeVal
	 */
    public String getInsfCnqeVal() {
        return this.insfCnqeVal;
    }

    /**
	 * Column Info
	 * @return insfDvCd
	 */
    public String getInsfDvCd() {
        return this.insfDvCd;
    }

    /**
	 * Column Info
	 * @return ibCssmVoyNo
	 */
    public String getIbCssmVoyNo() {
        return this.ibCssmVoyNo;
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
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return vslSlanCd
	 */
    public String getVslSlanCd() {
        return this.vslSlanCd;
    }

    /**
	 * Column Info
	 * @return insfId
	 */
    public String getInsfId() {
        return this.insfId;
    }

    /**
	 * Column Info
	 * @return skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
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
	 * @return vpsPortCd
	 */
    public String getVpsPortCd() {
        return this.vpsPortCd;
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
	 * @return insfDttm
	 */
    public String getInsfDttm() {
        return this.insfDttm;
    }

    /**
	 * Column Info
	 * @return insfPrsId
	 */
    public String getInsfPrsId() {
        return this.insfPrsId;
    }

    /**
	 * Column Info
	 * @return cssmVoyNoIfSeq
	 */
    public String getCssmVoyNoIfSeq() {
        return this.cssmVoyNoIfSeq;
    }

    /**
	 * Column Info
	 * @return obCssmVoyNo
	 */
    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
    }

    /**
	 * Column Info
	 * @return insfCnqeCont
	 */
    public String getInsfCnqeCont() {
        return this.insfCnqeCont;
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
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param insfCnqeVal
	 */
    public void setInsfCnqeVal(String insfCnqeVal) {
        this.insfCnqeVal = insfCnqeVal;
    }

    /**
	 * Column Info
	 * @param insfDvCd
	 */
    public void setInsfDvCd(String insfDvCd) {
        this.insfDvCd = insfDvCd;
    }

    /**
	 * Column Info
	 * @param ibCssmVoyNo
	 */
    public void setIbCssmVoyNo(String ibCssmVoyNo) {
        this.ibCssmVoyNo = ibCssmVoyNo;
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
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param vslSlanCd
	 */
    public void setVslSlanCd(String vslSlanCd) {
        this.vslSlanCd = vslSlanCd;
    }

    /**
	 * Column Info
	 * @param insfId
	 */
    public void setInsfId(String insfId) {
        this.insfId = insfId;
    }

    /**
	 * Column Info
	 * @param skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
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
	 * @param vpsPortCd
	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
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
	 * @param insfDttm
	 */
    public void setInsfDttm(String insfDttm) {
        this.insfDttm = insfDttm;
    }

    /**
	 * Column Info
	 * @param insfPrsId
	 */
    public void setInsfPrsId(String insfPrsId) {
        this.insfPrsId = insfPrsId;
    }

    /**
	 * Column Info
	 * @param cssmVoyNoIfSeq
	 */
    public void setCssmVoyNoIfSeq(String cssmVoyNoIfSeq) {
        this.cssmVoyNoIfSeq = cssmVoyNoIfSeq;
    }

    /**
	 * Column Info
	 * @param obCssmVoyNo
	 */
    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    /**
	 * Column Info
	 * @param insfCnqeCont
	 */
    public void setInsfCnqeCont(String insfCnqeCont) {
        this.insfCnqeCont = insfCnqeCont;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public void setClptIndSeq(String clptIndSeq) {
        this.clptIndSeq = clptIndSeq;
    }

    public String getClptIndSeq() {
        return this.clptIndSeq;
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
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setInsfCnqeVal(JSPUtil.getParameter(request, prefix + "insf_cnqe_val", ""));
        setInsfDvCd(JSPUtil.getParameter(request, prefix + "insf_dv_cd", ""));
        setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
        setInsfId(JSPUtil.getParameter(request, prefix + "insf_id", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setInsfDttm(JSPUtil.getParameter(request, prefix + "insf_dttm", ""));
        setInsfPrsId(JSPUtil.getParameter(request, prefix + "insf_prs_id", ""));
        setCssmVoyNoIfSeq(JSPUtil.getParameter(request, prefix + "cssm_voy_no_if_seq", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
        setInsfCnqeCont(JSPUtil.getParameter(request, prefix + "insf_cnqe_cont", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CSSMVO[]
	 */
    public CSSMVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CSSMVO[]
	 */
    public CSSMVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CSSMVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] insfCnqeVal = (JSPUtil.getParameter(request, prefix + "insf_cnqe_val", length));
            String[] insfDvCd = (JSPUtil.getParameter(request, prefix + "insf_dv_cd", length));
            String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
            String[] insfId = (JSPUtil.getParameter(request, prefix + "insf_id", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] insfDttm = (JSPUtil.getParameter(request, prefix + "insf_dttm", length));
            String[] insfPrsId = (JSPUtil.getParameter(request, prefix + "insf_prs_id", length));
            String[] cssmVoyNoIfSeq = (JSPUtil.getParameter(request, prefix + "cssm_voy_no_if_seq", length));
            String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
            String[] insfCnqeCont = (JSPUtil.getParameter(request, prefix + "insf_cnqe_cont", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CSSMVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (insfCnqeVal[i] != null)
                    model.setInsfCnqeVal(insfCnqeVal[i]);
                if (insfDvCd[i] != null)
                    model.setInsfDvCd(insfDvCd[i]);
                if (ibCssmVoyNo[i] != null)
                    model.setIbCssmVoyNo(ibCssmVoyNo[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (insfId[i] != null)
                    model.setInsfId(insfId[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (insfDttm[i] != null)
                    model.setInsfDttm(insfDttm[i]);
                if (insfPrsId[i] != null)
                    model.setInsfPrsId(insfPrsId[i]);
                if (cssmVoyNoIfSeq[i] != null)
                    model.setCssmVoyNoIfSeq(cssmVoyNoIfSeq[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (insfCnqeCont[i] != null)
                    model.setInsfCnqeCont(insfCnqeCont[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (clptIndSeq[i] != null) 
		    		model.setClptIndSeq(clptIndSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCSSMVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CSSMVO[]
	 */
    public CSSMVO[] getCSSMVOs() {
        CSSMVO[] vos = (CSSMVO[]) models.toArray(new CSSMVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfCnqeVal = this.insfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfDvCd = this.insfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCssmVoyNo = this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfId = this.insfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfDttm = this.insfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfPrsId = this.insfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cssmVoyNoIfSeq = this.cssmVoyNoIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfCnqeCont = this.insfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
