/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AcepChkHdrVO.java
*@FileTitle : AcepChkHdrVO
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
public class AcepChkHdrVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<AcepChkHdrVO> models = new ArrayList<AcepChkHdrVO>();

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String mnrOrdSeq = null;

    /* Column Info */
    private String mnrWoTpCd = null;

    /* Column Info */
    private String eqNo = null;

    /* Column Info */
    private String inspDt = null;

    /* Column Info */
    private String rprRqstSeq = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String mnrOrdOfcCtyCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String lstInspDt = null;

    /* Column Info */
    private String inspYdCd = null;

    /* Column Info */
    private String ordDtlSeq = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String acepSeq = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String mftDt = null;

    /* Column Info */
    private String creUsrNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public AcepChkHdrVO() {
    }

    public AcepChkHdrVO(String ibflag, String pagerows, String acepSeq, String mnrWoTpCd, String eqNo, String rprRqstSeq, String mnrOrdOfcCtyCd, String mnrOrdSeq, String ordDtlSeq, String inspYdCd, String lstInspDt, String inspDt, String creUsrId, String creDt, String updUsrId, String updDt, String cntrTpszCd, String mftDt, String creUsrNm) {
        this.pagerows = pagerows;
        this.mnrOrdSeq = mnrOrdSeq;
        this.mnrWoTpCd = mnrWoTpCd;
        this.eqNo = eqNo;
        this.inspDt = inspDt;
        this.rprRqstSeq = rprRqstSeq;
        this.ibflag = ibflag;
        this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
        this.updUsrId = updUsrId;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.lstInspDt = lstInspDt;
        this.inspYdCd = inspYdCd;
        this.ordDtlSeq = ordDtlSeq;
        this.updDt = updDt;
        this.acepSeq = acepSeq;
        this.cntrTpszCd = cntrTpszCd;
        this.mftDt = mftDt;
        this.creUsrNm = creUsrNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
        this.hashColumns.put("mnr_wo_tp_cd", getMnrWoTpCd());
        this.hashColumns.put("eq_no", getEqNo());
        this.hashColumns.put("insp_dt", getInspDt());
        this.hashColumns.put("rpr_rqst_seq", getRprRqstSeq());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("lst_insp_dt", getLstInspDt());
        this.hashColumns.put("insp_yd_cd", getInspYdCd());
        this.hashColumns.put("ord_dtl_seq", getOrdDtlSeq());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("acep_seq", getAcepSeq());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("mft_dt", getMftDt());
        this.hashColumns.put("cre_usr_nm", getCreUsrNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
        this.hashFields.put("mnr_wo_tp_cd", "mnrWoTpCd");
        this.hashFields.put("eq_no", "eqNo");
        this.hashFields.put("insp_dt", "inspDt");
        this.hashFields.put("rpr_rqst_seq", "rprRqstSeq");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("lst_insp_dt", "lstInspDt");
        this.hashFields.put("insp_yd_cd", "inspYdCd");
        this.hashFields.put("ord_dtl_seq", "ordDtlSeq");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("acep_seq", "acepSeq");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("mft_dt", "mftDt");
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
	 * Column Info
	 * @return mnrOrdSeq
	 */
    public String getMnrOrdSeq() {
        return this.mnrOrdSeq;
    }

    /**
	 * Column Info
	 * @return mnrWoTpCd
	 */
    public String getMnrWoTpCd() {
        return this.mnrWoTpCd;
    }

    /**
	 * Column Info
	 * @return eqNo
	 */
    public String getEqNo() {
        return this.eqNo;
    }

    /**
	 * Column Info
	 * @return inspDt
	 */
    public String getInspDt() {
        return this.inspDt;
    }

    /**
	 * Column Info
	 * @return rprRqstSeq
	 */
    public String getRprRqstSeq() {
        return this.rprRqstSeq;
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
	 * @return mnrOrdOfcCtyCd
	 */
    public String getMnrOrdOfcCtyCd() {
        return this.mnrOrdOfcCtyCd;
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
	 * @return lstInspDt
	 */
    public String getLstInspDt() {
        return this.lstInspDt;
    }

    /**
	 * Column Info
	 * @return inspYdCd
	 */
    public String getInspYdCd() {
        return this.inspYdCd;
    }

    /**
	 * Column Info
	 * @return ordDtlSeq
	 */
    public String getOrdDtlSeq() {
        return this.ordDtlSeq;
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
	 * Column Info
	 * @param mnrOrdSeq
	 */
    public void setMnrOrdSeq(String mnrOrdSeq) {
        this.mnrOrdSeq = mnrOrdSeq;
    }

    /**
	 * Column Info
	 * @param mnrWoTpCd
	 */
    public void setMnrWoTpCd(String mnrWoTpCd) {
        this.mnrWoTpCd = mnrWoTpCd;
    }

    /**
	 * Column Info
	 * @param eqNo
	 */
    public void setEqNo(String eqNo) {
        this.eqNo = eqNo;
    }

    /**
	 * Column Info
	 * @param inspDt
	 */
    public void setInspDt(String inspDt) {
        this.inspDt = inspDt;
    }

    /**
	 * Column Info
	 * @param rprRqstSeq
	 */
    public void setRprRqstSeq(String rprRqstSeq) {
        this.rprRqstSeq = rprRqstSeq;
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
	 * @param mnrOrdOfcCtyCd
	 */
    public void setMnrOrdOfcCtyCd(String mnrOrdOfcCtyCd) {
        this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
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
	 * @param lstInspDt
	 */
    public void setLstInspDt(String lstInspDt) {
        this.lstInspDt = lstInspDt;
    }

    /**
	 * Column Info
	 * @param inspYdCd
	 */
    public void setInspYdCd(String inspYdCd) {
        this.inspYdCd = inspYdCd;
    }

    /**
	 * Column Info
	 * @param ordDtlSeq
	 */
    public void setOrdDtlSeq(String ordDtlSeq) {
        this.ordDtlSeq = ordDtlSeq;
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

    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    public void setMftDt(String mftDt) {
        this.mftDt = mftDt;
    }

    public String getMftDt() {
        return this.mftDt;
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
        setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
        setMnrWoTpCd(JSPUtil.getParameter(request, prefix + "mnr_wo_tp_cd", ""));
        setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
        setInspDt(JSPUtil.getParameter(request, prefix + "insp_dt", ""));
        setRprRqstSeq(JSPUtil.getParameter(request, prefix + "rpr_rqst_seq", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setLstInspDt(JSPUtil.getParameter(request, prefix + "lst_insp_dt", ""));
        setInspYdCd(JSPUtil.getParameter(request, prefix + "insp_yd_cd", ""));
        setOrdDtlSeq(JSPUtil.getParameter(request, prefix + "ord_dtl_seq", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setAcepSeq(JSPUtil.getParameter(request, prefix + "acep_seq", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setMftDt(JSPUtil.getParameter(request, prefix + "mft_dt", ""));
        setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AcepChkHdrVO[]
	 */
    public AcepChkHdrVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AcepChkHdrVO[]
	 */
    public AcepChkHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        AcepChkHdrVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix + "mnr_ord_seq", length));
            String[] mnrWoTpCd = (JSPUtil.getParameter(request, prefix + "mnr_wo_tp_cd", length));
            String[] eqNo = (JSPUtil.getParameter(request, prefix + "eq_no", length));
            String[] inspDt = (JSPUtil.getParameter(request, prefix + "insp_dt", length));
            String[] rprRqstSeq = (JSPUtil.getParameter(request, prefix + "rpr_rqst_seq", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] lstInspDt = (JSPUtil.getParameter(request, prefix + "lst_insp_dt", length));
            String[] inspYdCd = (JSPUtil.getParameter(request, prefix + "insp_yd_cd", length));
            String[] ordDtlSeq = (JSPUtil.getParameter(request, prefix + "ord_dtl_seq", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] acepSeq = (JSPUtil.getParameter(request, prefix + "acep_seq", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] mftDt = (JSPUtil.getParameter(request, prefix + "mft_dt", length));
            String[] creUsrNm = (JSPUtil.getParameter(request, prefix + "cre_usr_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new AcepChkHdrVO();
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (mnrOrdSeq[i] != null)
                    model.setMnrOrdSeq(mnrOrdSeq[i]);
                if (mnrWoTpCd[i] != null)
                    model.setMnrWoTpCd(mnrWoTpCd[i]);
                if (eqNo[i] != null)
                    model.setEqNo(eqNo[i]);
                if (inspDt[i] != null)
                    model.setInspDt(inspDt[i]);
                if (rprRqstSeq[i] != null)
                    model.setRprRqstSeq(rprRqstSeq[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (mnrOrdOfcCtyCd[i] != null)
                    model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (lstInspDt[i] != null)
                    model.setLstInspDt(lstInspDt[i]);
                if (inspYdCd[i] != null)
                    model.setInspYdCd(inspYdCd[i]);
                if (ordDtlSeq[i] != null)
                    model.setOrdDtlSeq(ordDtlSeq[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (acepSeq[i] != null)
                    model.setAcepSeq(acepSeq[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (mftDt[i] != null)
                    model.setMftDt(mftDt[i]);
                if (creUsrNm[i] != null) 
		    		model.setCreUsrNm(creUsrNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getAcepChkHdrVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return AcepChkHdrVO[]
	 */
    public AcepChkHdrVO[] getAcepChkHdrVOs() {
        AcepChkHdrVO[] vos = (AcepChkHdrVO[]) models.toArray(new AcepChkHdrVO[models.size()]);
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
        this.mnrOrdSeq = this.mnrOrdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrWoTpCd = this.mnrWoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqNo = this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inspDt = this.inspDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rprRqstSeq = this.rprRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lstInspDt = this.lstInspDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inspYdCd = this.inspYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ordDtlSeq = this.ordDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acepSeq = this.acepSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mftDt = this.mftDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrNm = this.creUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
