/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ScgPrnrRqstUnmapVO.java
*@FileTitle : ScgPrnrRqstUnmapVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.11  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo;

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
public class ScgPrnrRqstUnmapVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ScgPrnrRqstUnmapVO> models = new ArrayList<ScgPrnrRqstUnmapVO>();

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String spclCgoRqstSeq = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String edwUpdDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ediUnmapSeq = null;

    /* Column Info */
    private String ediUnmapCorrRsltCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String ediUnmapCorrDt = null;

    /* Column Info */
    private String prnrCgoRqstSeq = null;

    /* Column Info */
    private String ediUnmapDtlCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String crrCd = null;

    /* Column Info */
    private String cgoOprCd = null;

    /* Column Info */
    private String bkgRefNo = null;

    /* Column Info */
    private String spclCgoCateCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String podCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ScgPrnrRqstUnmapVO() {
    }

    public ScgPrnrRqstUnmapVO(String ibflag, String pagerows, String crrCd, String bkgRefNo, String spclCgoRqstSeq, String prnrCgoRqstSeq, String ediUnmapSeq, String ediUnmapDtlCd, String ediUnmapCorrRsltCd, String ediUnmapCorrDt, String creUsrId, String creDt, String updUsrId, String updDt, String edwUpdDt, String cgoOprCd, String spclCgoCateCd, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd) {
        this.updDt = updDt;
        this.spclCgoRqstSeq = spclCgoRqstSeq;
        this.creDt = creDt;
        this.edwUpdDt = edwUpdDt;
        this.crrCd = crrCd;
        this.pagerows = pagerows;
        this.ediUnmapSeq = ediUnmapSeq;
        this.bkgRefNo = bkgRefNo;
        this.ediUnmapCorrRsltCd = ediUnmapCorrRsltCd;
        this.ibflag = ibflag;
        this.creUsrId = creUsrId;
        this.ediUnmapCorrDt = ediUnmapCorrDt;
        this.prnrCgoRqstSeq = prnrCgoRqstSeq;
        this.ediUnmapDtlCd = ediUnmapDtlCd;
        this.updUsrId = updUsrId;
        this.crrCd = crrCd;
        this.cgoOprCd = cgoOprCd;
        this.bkgRefNo = bkgRefNo;
        this.spclCgoCateCd = spclCgoCateCd;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.polCd = polCd;
        this.podCd = podCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("edw_upd_dt", getEdwUpdDt());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("edi_unmap_seq", getEdiUnmapSeq());
        this.hashColumns.put("bkg_ref_no", getBkgRefNo());
        this.hashColumns.put("edi_unmap_corr_rslt_cd", getEdiUnmapCorrRsltCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("edi_unmap_corr_dt", getEdiUnmapCorrDt());
        this.hashColumns.put("prnr_cgo_rqst_seq", getPrnrCgoRqstSeq());
        this.hashColumns.put("edi_unmap_dtl_cd", getEdiUnmapDtlCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
        this.hashColumns.put("bkg_ref_no", getBkgRefNo());
        this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("pod_cd", getPodCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("edw_upd_dt", "edwUpdDt");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("edi_unmap_seq", "ediUnmapSeq");
        this.hashFields.put("bkg_ref_no", "bkgRefNo");
        this.hashFields.put("edi_unmap_corr_rslt_cd", "ediUnmapCorrRsltCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("edi_unmap_corr_dt", "ediUnmapCorrDt");
        this.hashFields.put("prnr_cgo_rqst_seq", "prnrCgoRqstSeq");
        this.hashFields.put("edi_unmap_dtl_cd", "ediUnmapDtlCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("cgo_opr_cd", "cgoOprCd");
        this.hashFields.put("bkg_ref_no", "bkgRefNo");
        this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("pod_cd", "podCd");
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
	 * @return spclCgoRqstSeq
	 */
    public String getSpclCgoRqstSeq() {
        return this.spclCgoRqstSeq;
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
	 * @return edwUpdDt
	 */
    public String getEdwUpdDt() {
        return this.edwUpdDt;
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
	 * @return ediUnmapSeq
	 */
    public String getEdiUnmapSeq() {
        return this.ediUnmapSeq;
    }

    /**
	 * Column Info
	 * @return ediUnmapCorrRsltCd
	 */
    public String getEdiUnmapCorrRsltCd() {
        return this.ediUnmapCorrRsltCd;
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
	 * @return ediUnmapCorrDt
	 */
    public String getEdiUnmapCorrDt() {
        return this.ediUnmapCorrDt;
    }

    /**
	 * Column Info
	 * @return prnrCgoRqstSeq
	 */
    public String getPrnrCgoRqstSeq() {
        return this.prnrCgoRqstSeq;
    }

    /**
	 * Column Info
	 * @return ediUnmapDtlCd
	 */
    public String getEdiUnmapDtlCd() {
        return this.ediUnmapDtlCd;
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
	 * @param spclCgoRqstSeq
	 */
    public void setSpclCgoRqstSeq(String spclCgoRqstSeq) {
        this.spclCgoRqstSeq = spclCgoRqstSeq;
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
	 * @param edwUpdDt
	 */
    public void setEdwUpdDt(String edwUpdDt) {
        this.edwUpdDt = edwUpdDt;
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
	 * @param ediUnmapSeq
	 */
    public void setEdiUnmapSeq(String ediUnmapSeq) {
        this.ediUnmapSeq = ediUnmapSeq;
    }

    /**
	 * Column Info
	 * @param ediUnmapCorrRsltCd
	 */
    public void setEdiUnmapCorrRsltCd(String ediUnmapCorrRsltCd) {
        this.ediUnmapCorrRsltCd = ediUnmapCorrRsltCd;
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
	 * @param ediUnmapCorrDt
	 */
    public void setEdiUnmapCorrDt(String ediUnmapCorrDt) {
        this.ediUnmapCorrDt = ediUnmapCorrDt;
    }

    /**
	 * Column Info
	 * @param prnrCgoRqstSeq
	 */
    public void setPrnrCgoRqstSeq(String prnrCgoRqstSeq) {
        this.prnrCgoRqstSeq = prnrCgoRqstSeq;
    }

    /**
	 * Column Info
	 * @param ediUnmapDtlCd
	 */
    public void setEdiUnmapDtlCd(String ediUnmapDtlCd) {
        this.ediUnmapDtlCd = ediUnmapDtlCd;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public void setCrrCd(String crrCd) {
        this.crrCd = crrCd;
    }

    public String getCrrCd() {
        return this.crrCd;
    }

    public void setCgoOprCd(String cgoOprCd) {
        this.cgoOprCd = cgoOprCd;
    }

    public String getCgoOprCd() {
        return this.cgoOprCd;
    }

    public void setBkgRefNo(String bkgRefNo) {
        this.bkgRefNo = bkgRefNo;
    }

    public String getBkgRefNo() {
        return this.bkgRefNo;
    }

    public void setSpclCgoCateCd(String spclCgoCateCd) {
        this.spclCgoCateCd = spclCgoCateCd;
    }

    public String getSpclCgoCateCd() {
        return this.spclCgoCateCd;
    }

    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    public String getVslCd() {
        return this.vslCd;
    }

    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    public String getPolCd() {
        return this.polCd;
    }

    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    public String getPodCd() {
        return this.podCd;
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
        setSpclCgoRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setEdwUpdDt(JSPUtil.getParameter(request, prefix + "edw_upd_dt", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setEdiUnmapSeq(JSPUtil.getParameter(request, prefix + "edi_unmap_seq", ""));
        setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
        setEdiUnmapCorrRsltCd(JSPUtil.getParameter(request, prefix + "edi_unmap_corr_rslt_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setEdiUnmapCorrDt(JSPUtil.getParameter(request, prefix + "edi_unmap_corr_dt", ""));
        setPrnrCgoRqstSeq(JSPUtil.getParameter(request, prefix + "prnr_cgo_rqst_seq", ""));
        setEdiUnmapDtlCd(JSPUtil.getParameter(request, prefix + "edi_unmap_dtl_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setCgoOprCd(JSPUtil.getParameter(request, prefix + "cgo_opr_cd", ""));
        setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
        setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPrnrRqstUnmapVO[]
	 */
    public ScgPrnrRqstUnmapVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPrnrRqstUnmapVO[]
	 */
    public ScgPrnrRqstUnmapVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ScgPrnrRqstUnmapVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] edwUpdDt = (JSPUtil.getParameter(request, prefix + "edw_upd_dt", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ediUnmapSeq = (JSPUtil.getParameter(request, prefix + "edi_unmap_seq", length));
            String[] bkgRefNo = (JSPUtil.getParameter(request, prefix + "bkg_ref_no", length));
            String[] ediUnmapCorrRsltCd = (JSPUtil.getParameter(request, prefix + "edi_unmap_corr_rslt_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] ediUnmapCorrDt = (JSPUtil.getParameter(request, prefix + "edi_unmap_corr_dt", length));
            String[] prnrCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "prnr_cgo_rqst_seq", length));
            String[] ediUnmapDtlCd = (JSPUtil.getParameter(request, prefix + "edi_unmap_dtl_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
	    	String[] cgoOprCd = (JSPUtil.getParameter(request, prefix + "cgo_opr_cd", length));
	    	String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", length));
	    	String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
	    	String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
	    	String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
	    	String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
	    	String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ScgPrnrRqstUnmapVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (spclCgoRqstSeq[i] != null)
                    model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (edwUpdDt[i] != null)
                    model.setEdwUpdDt(edwUpdDt[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ediUnmapSeq[i] != null)
                    model.setEdiUnmapSeq(ediUnmapSeq[i]);
                if (bkgRefNo[i] != null)
                    model.setBkgRefNo(bkgRefNo[i]);
                if (ediUnmapCorrRsltCd[i] != null)
                    model.setEdiUnmapCorrRsltCd(ediUnmapCorrRsltCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (ediUnmapCorrDt[i] != null)
                    model.setEdiUnmapCorrDt(ediUnmapCorrDt[i]);
                if (prnrCgoRqstSeq[i] != null)
                    model.setPrnrCgoRqstSeq(prnrCgoRqstSeq[i]);
                if (ediUnmapDtlCd[i] != null)
                    model.setEdiUnmapDtlCd(ediUnmapDtlCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (crrCd[i] != null) 
		    		model.setCrrCd(crrCd[i]);
				if (cgoOprCd[i] != null) 
		    		model.setCgoOprCd(cgoOprCd[i]);
				if (bkgRefNo[i] != null) 
		    		model.setBkgRefNo(bkgRefNo[i]);
				if (spclCgoCateCd[i] != null) 
		    		model.setSpclCgoCateCd(spclCgoCateCd[i]);
				if (vslCd[i] != null) 
		    		model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null) 
		    		model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null) 
		    		model.setSkdDirCd(skdDirCd[i]);
				if (polCd[i] != null) 
		    		model.setPolCd(polCd[i]);
				if (podCd[i] != null) 
		    		model.setPodCd(podCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getScgPrnrRqstUnmapVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ScgPrnrRqstUnmapVO[]
	 */
    public ScgPrnrRqstUnmapVO[] getScgPrnrRqstUnmapVOs() {
        ScgPrnrRqstUnmapVO[] vos = (ScgPrnrRqstUnmapVO[]) models.toArray(new ScgPrnrRqstUnmapVO[models.size()]);
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
        this.spclCgoRqstSeq = this.spclCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.edwUpdDt = this.edwUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapSeq = this.ediUnmapSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgRefNo = this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapCorrRsltCd = this.ediUnmapCorrRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapCorrDt = this.ediUnmapCorrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrCgoRqstSeq = this.prnrCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapDtlCd = this.ediUnmapDtlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoOprCd = this.cgoOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgRefNo = this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoCateCd = this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
