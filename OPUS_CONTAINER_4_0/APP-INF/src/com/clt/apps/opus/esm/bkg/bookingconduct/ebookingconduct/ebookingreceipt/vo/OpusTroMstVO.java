/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OpusTroMstVO.java
*@FileTitle : OpusTroMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.18 류대영 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class OpusTroMstVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<OpusTroMstVO> models = new ArrayList<OpusTroMstVO>();

    /* Column Info */
    private String rqstDt = null;

    /* Column Info */
    private String dorPstNo = null;

    /* Column Info */
    private String troSeq = null;

    /* Column Info */
    private String cxlFlg = null;

    /* Column Info */
    private String ownrTrkFlg = null;

    /* Column Info */
    private String ioBndCd = null;

    /* Column Info */
    private String cfmFlg = null;

    /* Column Info */
    private String requestResult = null;

    /* Column Info */
    private String cntcPhnNo = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String diffRmk = null;

    /* Column Info */
    private String isEur = null;

    /* Column Info */
    private String cntcPsonNm = null;

    /* Column Info */
    private String cntcMphnNo = null;

    /* Column Info */
    private String actShprNm = null;

    /* Column Info */
    private String actShprAddr = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String xterTroSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public OpusTroMstVO() {
    }

    public OpusTroMstVO(String ibflag, String pagerows, String troSeq, String ownrTrkFlg, String requestResult, String rqstDt, String actShprNm, String cntcPsonNm, String cntcPhnNo, String cntcMphnNo, String dorPstNo, String actShprAddr, String diffRmk, String cxlFlg, String cfmFlg, String isEur, String ioBndCd, String cntrTpszCd, String xterTroSeq) {
        this.rqstDt = rqstDt;
        this.dorPstNo = dorPstNo;
        this.troSeq = troSeq;
        this.cxlFlg = cxlFlg;
        this.ownrTrkFlg = ownrTrkFlg;
        this.ioBndCd = ioBndCd;
        this.cfmFlg = cfmFlg;
        this.requestResult = requestResult;
        this.cntcPhnNo = cntcPhnNo;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.diffRmk = diffRmk;
        this.isEur = isEur;
        this.cntcPsonNm = cntcPsonNm;
        this.cntcMphnNo = cntcMphnNo;
        this.actShprNm = actShprNm;
        this.actShprAddr = actShprAddr;
        this.cntrTpszCd = cntrTpszCd;
        this.xterTroSeq = xterTroSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("dor_pst_no", getDorPstNo());
        this.hashColumns.put("tro_seq", getTroSeq());
        this.hashColumns.put("cxl_flg", getCxlFlg());
        this.hashColumns.put("ownr_trk_flg", getOwnrTrkFlg());
        this.hashColumns.put("io_bnd_cd", getIoBndCd());
        this.hashColumns.put("cfm_flg", getCfmFlg());
        this.hashColumns.put("request_result", getRequestResult());
        this.hashColumns.put("cntc_phn_no", getCntcPhnNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("is_eur", getIsEur());
        this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
        this.hashColumns.put("cntc_mphn_no", getCntcMphnNo());
        this.hashColumns.put("act_shpr_nm", getActShprNm());
        this.hashColumns.put("act_shpr_addr", getActShprAddr());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("xter_tro_seq", getXterTroSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("dor_pst_no", "dorPstNo");
        this.hashFields.put("tro_seq", "troSeq");
        this.hashFields.put("cxl_flg", "cxlFlg");
        this.hashFields.put("ownr_trk_flg", "ownrTrkFlg");
        this.hashFields.put("io_bnd_cd", "ioBndCd");
        this.hashFields.put("cfm_flg", "cfmFlg");
        this.hashFields.put("request_result", "requestResult");
        this.hashFields.put("cntc_phn_no", "cntcPhnNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("is_eur", "isEur");
        this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
        this.hashFields.put("cntc_mphn_no", "cntcMphnNo");
        this.hashFields.put("act_shpr_nm", "actShprNm");
        this.hashFields.put("act_shpr_addr", "actShprAddr");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("xter_tro_seq", "xterTroSeq");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return rqstDt
	 */
    public String getRqstDt() {
        return this.rqstDt;
    }

    /**
	 * Column Info
	 * @return dorPstNo
	 */
    public String getDorPstNo() {
        return this.dorPstNo;
    }

    /**
	 * Column Info
	 * @return troSeq
	 */
    public String getTroSeq() {
        return this.troSeq;
    }

    /**
	 * Column Info
	 * @return cxlFlg
	 */
    public String getCxlFlg() {
        return this.cxlFlg;
    }

    /**
	 * Column Info
	 * @return ownrTrkFlg
	 */
    public String getOwnrTrkFlg() {
        return this.ownrTrkFlg;
    }

    /**
	 * Column Info
	 * @return ioBndCd
	 */
    public String getIoBndCd() {
        return this.ioBndCd;
    }

    /**
	 * Column Info
	 * @return cfmFlg
	 */
    public String getCfmFlg() {
        return this.cfmFlg;
    }

    /**
	 * Column Info
	 * @return requestResult
	 */
    public String getRequestResult() {
        return this.requestResult;
    }

    /**
	 * Column Info
	 * @return cntcPhnNo
	 */
    public String getCntcPhnNo() {
        return this.cntcPhnNo;
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
	 * @return diffRmk
	 */
    public String getDiffRmk() {
        return this.diffRmk;
    }

    /**
	 * Column Info
	 * @return isEur
	 */
    public String getIsEur() {
        return this.isEur;
    }

    /**
	 * Column Info
	 * @return cntcPsonNm
	 */
    public String getCntcPsonNm() {
        return this.cntcPsonNm;
    }

    /**
	 * Column Info
	 * @return cntcMphnNo
	 */
    public String getCntcMphnNo() {
        return this.cntcMphnNo;
    }

    /**
	 * Column Info
	 * @return actShprNm
	 */
    public String getActShprNm() {
        return this.actShprNm;
    }

    /**
	 * Column Info
	 * @return actShprAddr
	 */
    public String getActShprAddr() {
        return this.actShprAddr;
    }

    /**
	 * Column Info
	 * @param rqstDt
	 */
    public void setRqstDt(String rqstDt) {
        this.rqstDt = rqstDt;
    }

    /**
	 * Column Info
	 * @param dorPstNo
	 */
    public void setDorPstNo(String dorPstNo) {
        this.dorPstNo = dorPstNo;
    }

    /**
	 * Column Info
	 * @param troSeq
	 */
    public void setTroSeq(String troSeq) {
        this.troSeq = troSeq;
    }

    /**
	 * Column Info
	 * @param cxlFlg
	 */
    public void setCxlFlg(String cxlFlg) {
        this.cxlFlg = cxlFlg;
    }

    /**
	 * Column Info
	 * @param ownrTrkFlg
	 */
    public void setOwnrTrkFlg(String ownrTrkFlg) {
        this.ownrTrkFlg = ownrTrkFlg;
    }

    /**
	 * Column Info
	 * @param ioBndCd
	 */
    public void setIoBndCd(String ioBndCd) {
        this.ioBndCd = ioBndCd;
    }

    /**
	 * Column Info
	 * @param cfmFlg
	 */
    public void setCfmFlg(String cfmFlg) {
        this.cfmFlg = cfmFlg;
    }

    /**
	 * Column Info
	 * @param requestResult
	 */
    public void setRequestResult(String requestResult) {
        this.requestResult = requestResult;
    }

    /**
	 * Column Info
	 * @param cntcPhnNo
	 */
    public void setCntcPhnNo(String cntcPhnNo) {
        this.cntcPhnNo = cntcPhnNo;
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
	 * @param diffRmk
	 */
    public void setDiffRmk(String diffRmk) {
        this.diffRmk = diffRmk;
    }

    /**
	 * Column Info
	 * @param isEur
	 */
    public void setIsEur(String isEur) {
        this.isEur = isEur;
    }

    /**
	 * Column Info
	 * @param cntcPsonNm
	 */
    public void setCntcPsonNm(String cntcPsonNm) {
        this.cntcPsonNm = cntcPsonNm;
    }

    /**
	 * Column Info
	 * @param cntcMphnNo
	 */
    public void setCntcMphnNo(String cntcMphnNo) {
        this.cntcMphnNo = cntcMphnNo;
    }

    /**
	 * Column Info
	 * @param actShprNm
	 */
    public void setActShprNm(String actShprNm) {
        this.actShprNm = actShprNm;
    }

    /**
	 * Column Info
	 * @param actShprAddr
	 */
    public void setActShprAddr(String actShprAddr) {
        this.actShprAddr = actShprAddr;
    }

    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    public void setXterTroSeq(String xterTroSeq) {
        this.xterTroSeq = xterTroSeq;
    }

    public String getXterTroSeq() {
        return this.xterTroSeq;
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
        setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
        setDorPstNo(JSPUtil.getParameter(request, prefix + "dor_pst_no", ""));
        setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
        setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
        setOwnrTrkFlg(JSPUtil.getParameter(request, prefix + "ownr_trk_flg", ""));
        setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
        setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
        setRequestResult(JSPUtil.getParameter(request, prefix + "request_result", ""));
        setCntcPhnNo(JSPUtil.getParameter(request, prefix + "cntc_phn_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setIsEur(JSPUtil.getParameter(request, prefix + "is_eur", ""));
        setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
        setCntcMphnNo(JSPUtil.getParameter(request, prefix + "cntc_mphn_no", ""));
        setActShprNm(JSPUtil.getParameter(request, prefix + "act_shpr_nm", ""));
        setActShprAddr(JSPUtil.getParameter(request, prefix + "act_shpr_addr", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setXterTroSeq(JSPUtil.getParameter(request, prefix + "xter_tro_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpusTroMstVO[]
	 */
    public OpusTroMstVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpusTroMstVO[]
	 */
    public OpusTroMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        OpusTroMstVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] dorPstNo = (JSPUtil.getParameter(request, prefix + "dor_pst_no", length));
            String[] troSeq = (JSPUtil.getParameter(request, prefix + "tro_seq", length));
            String[] cxlFlg = (JSPUtil.getParameter(request, prefix + "cxl_flg", length));
            String[] ownrTrkFlg = (JSPUtil.getParameter(request, prefix + "ownr_trk_flg", length));
            String[] ioBndCd = (JSPUtil.getParameter(request, prefix + "io_bnd_cd", length));
            String[] cfmFlg = (JSPUtil.getParameter(request, prefix + "cfm_flg", length));
            String[] requestResult = (JSPUtil.getParameter(request, prefix + "request_result", length));
            String[] cntcPhnNo = (JSPUtil.getParameter(request, prefix + "cntc_phn_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] isEur = (JSPUtil.getParameter(request, prefix + "is_eur", length));
            String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix + "cntc_pson_nm", length));
            String[] cntcMphnNo = (JSPUtil.getParameter(request, prefix + "cntc_mphn_no", length));
            String[] actShprNm = (JSPUtil.getParameter(request, prefix + "act_shpr_nm", length));
            String[] actShprAddr = (JSPUtil.getParameter(request, prefix + "act_shpr_addr", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] xterTroSeq = (JSPUtil.getParameter(request, prefix + "xter_tro_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new OpusTroMstVO();
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (dorPstNo[i] != null)
                    model.setDorPstNo(dorPstNo[i]);
                if (troSeq[i] != null)
                    model.setTroSeq(troSeq[i]);
                if (cxlFlg[i] != null)
                    model.setCxlFlg(cxlFlg[i]);
                if (ownrTrkFlg[i] != null)
                    model.setOwnrTrkFlg(ownrTrkFlg[i]);
                if (ioBndCd[i] != null)
                    model.setIoBndCd(ioBndCd[i]);
                if (cfmFlg[i] != null)
                    model.setCfmFlg(cfmFlg[i]);
                if (requestResult[i] != null)
                    model.setRequestResult(requestResult[i]);
                if (cntcPhnNo[i] != null)
                    model.setCntcPhnNo(cntcPhnNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (isEur[i] != null)
                    model.setIsEur(isEur[i]);
                if (cntcPsonNm[i] != null)
                    model.setCntcPsonNm(cntcPsonNm[i]);
                if (cntcMphnNo[i] != null)
                    model.setCntcMphnNo(cntcMphnNo[i]);
                if (actShprNm[i] != null)
                    model.setActShprNm(actShprNm[i]);
                if (actShprAddr[i] != null)
                    model.setActShprAddr(actShprAddr[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (xterTroSeq[i] != null) 
		    		model.setXterTroSeq(xterTroSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getOpusTroMstVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return OpusTroMstVO[]
	 */
    public OpusTroMstVO[] getOpusTroMstVOs() {
        OpusTroMstVO[] vos = (OpusTroMstVO[]) models.toArray(new OpusTroMstVO[models.size()]);
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
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dorPstNo = this.dorPstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.troSeq = this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cxlFlg = this.cxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ownrTrkFlg = this.ownrTrkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ioBndCd = this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfmFlg = this.cfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.requestResult = this.requestResult.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcPhnNo = this.cntcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.isEur = this.isEur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcPsonNm = this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcMphnNo = this.cntcMphnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actShprNm = this.actShprNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actShprAddr = this.actShprAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterTroSeq = this.xterTroSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
