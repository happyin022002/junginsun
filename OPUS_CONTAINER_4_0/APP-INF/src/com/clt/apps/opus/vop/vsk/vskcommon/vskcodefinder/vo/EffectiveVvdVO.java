/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EffectiveVvdVO.java
*@FileTitle : EffectiveVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.11  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo;

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
public class EffectiveVvdVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<EffectiveVvdVO> models = new ArrayList<EffectiveVvdVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String callSgnNo = null;

    /* Column Info */
    private String ibCssmVoyNo = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String effectiveVvdChkRsltRmk = null;

    /* Column Info */
    private String vpsPortCd = null;
    
    /* Column Info */
    private String clptSeq = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String lloydNo = null;

    /* Column Info */
    private String obCssmVoyNo = null;

    /* Column Info */
    private String effectiveVvdChkRsltCd = null;

    /* Column Info */
    private String matchedVvdCount = null;

    /* Column Info */
    private String vslSlanCd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String clptIndSeq = null;

    /* Column Info */
    private String polClptIndSeq = null;

    /* Column Info */
    private String podClptIndSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public EffectiveVvdVO() {
    }

    public EffectiveVvdVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptSeq, String ibCssmVoyNo, String obCssmVoyNo, String callSgnNo, String lloydNo, String polCd, String effectiveVvdChkRsltCd, String effectiveVvdChkRsltRmk, String matchedVvdCount, String vslSlanCd, String podCd, String clptIndSeq, String polClptIndSeq, String podClptIndSeq) {
        this.vslCd = vslCd;
        this.callSgnNo = callSgnNo;
        this.ibCssmVoyNo = ibCssmVoyNo;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.pagerows = pagerows;
        this.effectiveVvdChkRsltRmk = effectiveVvdChkRsltRmk;
        this.vpsPortCd = vpsPortCd;
        this.clptSeq = clptSeq;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.lloydNo = lloydNo;
        this.obCssmVoyNo = obCssmVoyNo;
        this.effectiveVvdChkRsltCd = effectiveVvdChkRsltCd;
        this.matchedVvdCount = matchedVvdCount;
        this.vslSlanCd = vslSlanCd;
        this.podCd = podCd;
        this.clptIndSeq = clptIndSeq;
        this.polClptIndSeq = polClptIndSeq;
        this.podClptIndSeq = podClptIndSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("call_sgn_no", getCallSgnNo());
        this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("effective_vvd_chk_rslt_rmk", getEffectiveVvdChkRsltRmk());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("clpt_seq", getClptSeq());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("lloyd_no", getLloydNo());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("effective_vvd_chk_rslt_cd", getEffectiveVvdChkRsltCd());
        this.hashColumns.put("matched_vvd_count", getMatchedVvdCount());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
        this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
        this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("call_sgn_no", "callSgnNo");
        this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("effective_vvd_chk_rslt_rmk", "effectiveVvdChkRsltRmk");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("clpt_seq", "clptSeq");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("lloyd_no", "lloydNo");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("effective_vvd_chk_rslt_cd", "effectiveVvdChkRsltCd");
        this.hashFields.put("matched_vvd_count", "matchedVvdCount");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("clpt_ind_seq", "clptIndSeq");
        this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
        this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
        return this.hashFields;
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
	 * @return callSgnNo
	 */
    public String getCallSgnNo() {
        return this.callSgnNo;
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
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
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
	 * @return effectiveVvdChkRsltRmk
	 */
    public String getEffectiveVvdChkRsltRmk() {
        return this.effectiveVvdChkRsltRmk;
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
	 * @return clptSeq
	 */
    public String getClptSeq() {
        return this.clptSeq;
    }

    /**
	 * Column Info
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return lloydNo
	 */
    public String getLloydNo() {
        return this.lloydNo;
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
	 * @return effectiveVvdChkRsltCd
	 */
    public String getEffectiveVvdChkRsltCd() {
        return this.effectiveVvdChkRsltCd;
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
	 * @param callSgnNo
	 */
    public void setCallSgnNo(String callSgnNo) {
        this.callSgnNo = callSgnNo;
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
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
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
	 * @param effectiveVvdChkRsltRmk
	 */
    public void setEffectiveVvdChkRsltRmk(String effectiveVvdChkRsltRmk) {
        this.effectiveVvdChkRsltRmk = effectiveVvdChkRsltRmk;
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
	 * @param clptSeq
	 */
    public void setClptSeq(String clptSeq) {
        this.clptSeq = clptSeq;
    }

    /**
	 * Column Info
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param lloydNo
	 */
    public void setLloydNo(String lloydNo) {
        this.lloydNo = lloydNo;
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
	 * @param effectiveVvdChkRsltCd
	 */
    public void setEffectiveVvdChkRsltCd(String effectiveVvdChkRsltCd) {
        this.effectiveVvdChkRsltCd = effectiveVvdChkRsltCd;
    }

    public void setMatchedVvdCount(String matchedVvdCount) {
        this.matchedVvdCount = matchedVvdCount;
    }

    public String getMatchedVvdCount() {
        return this.matchedVvdCount;
    }

    public void setVslSlanCd(String vslSlanCd) {
        this.vslSlanCd = vslSlanCd;
    }

    public String getVslSlanCd() {
        return this.vslSlanCd;
    }

    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    public String getPodCd() {
        return this.podCd;
    }

    public void setClptIndSeq(String clptIndSeq) {
        this.clptIndSeq = clptIndSeq;
    }

    public String getClptIndSeq() {
        return this.clptIndSeq;
    }

    public void setPolClptIndSeq(String polClptIndSeq) {
        this.polClptIndSeq = polClptIndSeq;
    }

    public String getPolClptIndSeq() {
        return this.polClptIndSeq;
    }

    public void setPodClptIndSeq(String podClptIndSeq) {
        this.podClptIndSeq = podClptIndSeq;
    }

    public String getPodClptIndSeq() {
        return this.podClptIndSeq;
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
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
        setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setEffectiveVvdChkRsltRmk(JSPUtil.getParameter(request, prefix + "effective_vvd_chk_rslt_rmk", ""));
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
        setEffectiveVvdChkRsltCd(JSPUtil.getParameter(request, prefix + "effective_vvd_chk_rslt_cd", ""));
        setMatchedVvdCount(JSPUtil.getParameter(request, prefix + "matched_vvd_count", ""));
        setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
        setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
        setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EffectiveVvdVO[]
	 */
    public EffectiveVvdVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EffectiveVvdVO[]
	 */
    public EffectiveVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        EffectiveVvdVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] callSgnNo = (JSPUtil.getParameter(request, prefix + "call_sgn_no", length));
            String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] effectiveVvdChkRsltRmk = (JSPUtil.getParameter(request, prefix + "effective_vvd_chk_rslt_rmk", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] clptSeq = (JSPUtil.getParameter(request, prefix + "clpt_seq", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] lloydNo = (JSPUtil.getParameter(request, prefix + "lloyd_no", length));
            String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
            String[] effectiveVvdChkRsltCd = (JSPUtil.getParameter(request, prefix + "effective_vvd_chk_rslt_cd", length));
            String[] matchedVvdCount = (JSPUtil.getParameter(request, prefix + "matched_vvd_count", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
	    	String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", length));
	    	String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new EffectiveVvdVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (callSgnNo[i] != null)
                    model.setCallSgnNo(callSgnNo[i]);
                if (ibCssmVoyNo[i] != null)
                    model.setIbCssmVoyNo(ibCssmVoyNo[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (effectiveVvdChkRsltRmk[i] != null)
                    model.setEffectiveVvdChkRsltRmk(effectiveVvdChkRsltRmk[i]);
                    model.setVpsPortCd(vpsPortCd[i]);
                if (clptSeq[i] != null)
                    model.setClptSeq(clptSeq[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (lloydNo[i] != null)
                    model.setLloydNo(lloydNo[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (effectiveVvdChkRsltCd[i] != null)
                    model.setEffectiveVvdChkRsltCd(effectiveVvdChkRsltCd[i]);
                if (matchedVvdCount[i] != null)
                    model.setMatchedVvdCount(matchedVvdCount[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (clptIndSeq[i] != null) 
		    		model.setClptIndSeq(clptIndSeq[i]);
				if (polClptIndSeq[i] != null) 
		    		model.setPolClptIndSeq(polClptIndSeq[i]);
				if (podClptIndSeq[i] != null) 
		    		model.setPodClptIndSeq(podClptIndSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getEffectiveVvdVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return EffectiveVvdVO[]
	 */
    public EffectiveVvdVO[] getEffectiveVvdVOs() {
        EffectiveVvdVO[] vos = (EffectiveVvdVO[]) models.toArray(new EffectiveVvdVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callSgnNo = this.callSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCssmVoyNo = this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effectiveVvdChkRsltRmk = this.effectiveVvdChkRsltRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptSeq = this.clptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lloydNo = this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effectiveVvdChkRsltCd = this.effectiveVvdChkRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.matchedVvdCount = this.matchedVvdCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polClptIndSeq = this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podClptIndSeq = this.podClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
