/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : YardChargeVO.java
*@FileTitle : YardChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.12.24 정명훈 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class YardChargeVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<YardChargeVO> models = new ArrayList<YardChargeVO>();

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String cplsFlg = null;

    /* Column Info */
    private String toDate = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vndrNm = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String effDt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String yardCd = null;

    /* Column Info */
    private String costCd = null;

    /* Column Info */
    private String fromDate = null;

    /* Column Info */
    private String lstFlg = null;

    /* Column Info */
    private String ydChgVerSeq = null;

    /* Column Info */
    private String ydCd = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String portCd = null;

    /* Column Info */
    private String ydChgNo = null;

    /* Column Info */
    private String expDt = null;

    /* Column Info */
    private String chkCplsFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public YardChargeVO() {
    }

    public YardChargeVO(String ibflag, String pagerows, String ydChgNo, String ydChgVerSeq, String ydCd, String vndrSeq, String effDt, String expDt, String currCd, String cplsFlg, String lstFlg, String creUsrId, String vndrNm, String portCd, String yardCd, String fromDate, String toDate, String acctCd, String costCd, String chkCplsFlg) {
        this.currCd = currCd;
        this.cplsFlg = cplsFlg;
        this.toDate = toDate;
        this.pagerows = pagerows;
        this.vndrNm = vndrNm;
        this.ibflag = ibflag;
        this.effDt = effDt;
        this.creUsrId = creUsrId;
        this.yardCd = yardCd;
        this.costCd = costCd;
        this.fromDate = fromDate;
        this.lstFlg = lstFlg;
        this.ydChgVerSeq = ydChgVerSeq;
        this.ydCd = ydCd;
        this.vndrSeq = vndrSeq;
        this.acctCd = acctCd;
        this.portCd = portCd;
        this.ydChgNo = ydChgNo;
        this.expDt = expDt;
        this.chkCplsFlg = chkCplsFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("cpls_flg", getCplsFlg());
        this.hashColumns.put("to_date", getToDate());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vndr_nm", getVndrNm());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("eff_dt", getEffDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("yard_cd", getYardCd());
        this.hashColumns.put("cost_cd", getCostCd());
        this.hashColumns.put("from_date", getFromDate());
        this.hashColumns.put("lst_flg", getLstFlg());
        this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("port_cd", getPortCd());
        this.hashColumns.put("yd_chg_no", getYdChgNo());
        this.hashColumns.put("exp_dt", getExpDt());
        this.hashColumns.put("chk_cpls_flg", getChkCplsFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("cpls_flg", "cplsFlg");
        this.hashFields.put("to_date", "toDate");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vndr_nm", "vndrNm");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("eff_dt", "effDt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("yard_cd", "yardCd");
        this.hashFields.put("cost_cd", "costCd");
        this.hashFields.put("from_date", "fromDate");
        this.hashFields.put("lst_flg", "lstFlg");
        this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("port_cd", "portCd");
        this.hashFields.put("yd_chg_no", "ydChgNo");
        this.hashFields.put("exp_dt", "expDt");
        this.hashFields.put("chk_cpls_flg", "chkCplsFlg");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return currCd
	 */
    public String getCurrCd() {
        return this.currCd;
    }

    /**
	 * Column Info
	 * @return cplsFlg
	 */
    public String getCplsFlg() {
        return this.cplsFlg;
    }

    /**
	 * Column Info
	 * @return toDate
	 */
    public String getToDate() {
        return this.toDate;
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
	 * @return vndrNm
	 */
    public String getVndrNm() {
        return this.vndrNm;
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
	 * @return effDt
	 */
    public String getEffDt() {
        return this.effDt;
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
	 * @return yardCd
	 */
    public String getYardCd() {
        return this.yardCd;
    }

    /**
	 * Column Info
	 * @return costCd
	 */
    public String getCostCd() {
        return this.costCd;
    }

    /**
	 * Column Info
	 * @return fromDate
	 */
    public String getFromDate() {
        return this.fromDate;
    }

    /**
	 * Column Info
	 * @return lstFlg
	 */
    public String getLstFlg() {
        return this.lstFlg;
    }

    /**
	 * Column Info
	 * @return ydChgVerSeq
	 */
    public String getYdChgVerSeq() {
        return this.ydChgVerSeq;
    }

    /**
	 * Column Info
	 * @return ydCd
	 */
    public String getYdCd() {
        return this.ydCd;
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
	 * @return acctCd
	 */
    public String getAcctCd() {
        return this.acctCd;
    }

    /**
	 * Column Info
	 * @return portCd
	 */
    public String getPortCd() {
        return this.portCd;
    }

    /**
	 * Column Info
	 * @return ydChgNo
	 */
    public String getYdChgNo() {
        return this.ydChgNo;
    }

    /**
	 * Column Info
	 * @return expDt
	 */
    public String getExpDt() {
        return this.expDt;
    }

    /**
	 * Column Info
	 * @param currCd
	 */
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    /**
	 * Column Info
	 * @param cplsFlg
	 */
    public void setCplsFlg(String cplsFlg) {
        this.cplsFlg = cplsFlg;
    }

    /**
	 * Column Info
	 * @param toDate
	 */
    public void setToDate(String toDate) {
        this.toDate = toDate;
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
	 * @param vndrNm
	 */
    public void setVndrNm(String vndrNm) {
        this.vndrNm = vndrNm;
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
	 * @param effDt
	 */
    public void setEffDt(String effDt) {
        this.effDt = effDt;
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
	 * @param yardCd
	 */
    public void setYardCd(String yardCd) {
        this.yardCd = yardCd;
    }

    /**
	 * Column Info
	 * @param costCd
	 */
    public void setCostCd(String costCd) {
        this.costCd = costCd;
    }

    /**
	 * Column Info
	 * @param fromDate
	 */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
	 * Column Info
	 * @param lstFlg
	 */
    public void setLstFlg(String lstFlg) {
        this.lstFlg = lstFlg;
    }

    /**
	 * Column Info
	 * @param ydChgVerSeq
	 */
    public void setYdChgVerSeq(String ydChgVerSeq) {
        this.ydChgVerSeq = ydChgVerSeq;
    }

    /**
	 * Column Info
	 * @param ydCd
	 */
    public void setYdCd(String ydCd) {
        this.ydCd = ydCd;
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
	 * @param acctCd
	 */
    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    /**
	 * Column Info
	 * @param portCd
	 */
    public void setPortCd(String portCd) {
        this.portCd = portCd;
    }

    /**
	 * Column Info
	 * @param ydChgNo
	 */
    public void setYdChgNo(String ydChgNo) {
        this.ydChgNo = ydChgNo;
    }

    /**
	 * Column Info
	 * @param expDt
	 */
    public void setExpDt(String expDt) {
        this.expDt = expDt;
    }

    public void setChkCplsFlg(String chkCplsFlg) {
        this.chkCplsFlg = chkCplsFlg;
    }

    public String getChkCplsFlg() {
        return this.chkCplsFlg;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
        setCplsFlg(JSPUtil.getParameter(request, "cpls_flg", ""));
        setToDate(JSPUtil.getParameter(request, "to_date", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
        setYardCd(JSPUtil.getParameter(request, "yard_cd", ""));
        setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
        setFromDate(JSPUtil.getParameter(request, "from_date", ""));
        setLstFlg(JSPUtil.getParameter(request, "lst_flg", ""));
        setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
        setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
        setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
        setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
        setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
        setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
        setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
        setChkCplsFlg(JSPUtil.getParameter(request, "chk_cpls_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return YardChargeVO[]
	 */
    public YardChargeVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return YardChargeVO[]
	 */
    public YardChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        YardChargeVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] cplsFlg = (JSPUtil.getParameter(request, prefix + "cpls_flg", length));
            String[] toDate = (JSPUtil.getParameter(request, prefix + "to_date", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vndrNm = (JSPUtil.getParameter(request, prefix + "vndr_nm", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] yardCd = (JSPUtil.getParameter(request, prefix + "yard_cd", length));
            String[] costCd = (JSPUtil.getParameter(request, prefix + "cost_cd", length));
            String[] fromDate = (JSPUtil.getParameter(request, prefix + "from_date", length));
            String[] lstFlg = (JSPUtil.getParameter(request, prefix + "lst_flg", length));
            String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix + "yd_chg_ver_seq", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] portCd = (JSPUtil.getParameter(request, prefix + "port_cd", length));
            String[] ydChgNo = (JSPUtil.getParameter(request, prefix + "yd_chg_no", length));
            String[] expDt = (JSPUtil.getParameter(request, prefix + "exp_dt", length));
            String[] chkCplsFlg = (JSPUtil.getParameter(request, prefix + "chk_cpls_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new YardChargeVO();
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (cplsFlg[i] != null)
                    model.setCplsFlg(cplsFlg[i]);
                if (toDate[i] != null)
                    model.setToDate(toDate[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vndrNm[i] != null)
                    model.setVndrNm(vndrNm[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (effDt[i] != null)
                    model.setEffDt(effDt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (yardCd[i] != null)
                    model.setYardCd(yardCd[i]);
                if (costCd[i] != null)
                    model.setCostCd(costCd[i]);
                if (fromDate[i] != null)
                    model.setFromDate(fromDate[i]);
                if (lstFlg[i] != null)
                    model.setLstFlg(lstFlg[i]);
                if (ydChgVerSeq[i] != null)
                    model.setYdChgVerSeq(ydChgVerSeq[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (portCd[i] != null)
                    model.setPortCd(portCd[i]);
                if (ydChgNo[i] != null)
                    model.setYdChgNo(ydChgNo[i]);
                if (expDt[i] != null)
                    model.setExpDt(expDt[i]);
                if (chkCplsFlg[i] != null) 
		    		model.setChkCplsFlg(chkCplsFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getYardChargeVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return YardChargeVO[]
	 */
    public YardChargeVO[] getYardChargeVOs() {
        YardChargeVO[] vos = (YardChargeVO[]) models.toArray(new YardChargeVO[models.size()]);
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
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cplsFlg = this.cplsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toDate = this.toDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrNm = this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.yardCd = this.yardCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costCd = this.costCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fromDate = this.fromDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lstFlg = this.lstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydChgVerSeq = this.ydChgVerSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portCd = this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydChgNo = this.ydChgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expDt = this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkCplsFlg = this.chkCplsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
