/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OldBkgInfoVO.java
*@FileTitle : OldBkgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.29 류대영 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.lang.reflect.Field;
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
public class OldBkgInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<OldBkgInfoVO> models = new ArrayList<OldBkgInfoVO>();

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String bkgCgoTpCd = null;

    /* Column Info */
    private String preRlyPortCd = null;

    /* Column Info */
    private String porNodCd = null;

    /* Column Info */
    private String firstVvd = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String mtyPkupYdCd = null;

    /* Column Info */
    private String polNodCd = null;

    /* Column Info */
    private String fullRtnYdCd = null;

    /* Column Info */
    private String pctlNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String bkgTrunkVvd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String podNodCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String delNodCd = null;

    /* Column Info */
    private String obSlsOfcCd = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String pstRlyPortCd = null;

    /* Column Info */
    private String bkgCtrlPtyCustCntCd = null;

    /* Column Info */
    private String bkgCtrlPtyCustSeq = null;

    /* Column Info */
    private String slanCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public OldBkgInfoVO() {
    }

    public OldBkgInfoVO(String ibflag, String pagerows, String rcvTermCd, String deTermCd, String bkgCgoTpCd, String obSlsOfcCd, String bkgTrunkVvd, String firstVvd, String porCd, String porNodCd, String polCd, String polNodCd, String podCd, String podNodCd, String delCd, String delNodCd, String preRlyPortCd, String pstRlyPortCd, String mtyPkupYdCd, String fullRtnYdCd, String pctlNo, String bkgCtrlPtyCustCntCd, String bkgCtrlPtyCustSeq, String slanCd) {
        this.porCd = porCd;
        this.bkgCgoTpCd = bkgCgoTpCd;
        this.preRlyPortCd = preRlyPortCd;
        this.porNodCd = porNodCd;
        this.firstVvd = firstVvd;
        this.delCd = delCd;
        this.mtyPkupYdCd = mtyPkupYdCd;
        this.polNodCd = polNodCd;
        this.fullRtnYdCd = fullRtnYdCd;
        this.pctlNo = pctlNo;
        this.pagerows = pagerows;
        this.bkgTrunkVvd = bkgTrunkVvd;
        this.podCd = podCd;
        this.deTermCd = deTermCd;
        this.podNodCd = podNodCd;
        this.ibflag = ibflag;
        this.polCd = polCd;
        this.delNodCd = delNodCd;
        this.obSlsOfcCd = obSlsOfcCd;
        this.rcvTermCd = rcvTermCd;
        this.pstRlyPortCd = pstRlyPortCd;
        this.bkgCtrlPtyCustCntCd = bkgCtrlPtyCustCntCd;
        this.bkgCtrlPtyCustSeq = bkgCtrlPtyCustSeq;
        this.slanCd = slanCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
        this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
        this.hashColumns.put("por_nod_cd", getPorNodCd());
        this.hashColumns.put("first_vvd", getFirstVvd());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
        this.hashColumns.put("pol_nod_cd", getPolNodCd());
        this.hashColumns.put("full_rtn_yd_cd", getFullRtnYdCd());
        this.hashColumns.put("pctl_no", getPctlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_trunk_vvd", getBkgTrunkVvd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("pod_nod_cd", getPodNodCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("del_nod_cd", getDelNodCd());
        this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
        this.hashColumns.put("bkg_ctrl_pty_cust_cnt_cd", getBkgCtrlPtyCustCntCd());
        this.hashColumns.put("bkg_ctrl_pty_cust_seq", getBkgCtrlPtyCustSeq());
        this.hashColumns.put("slan_cd", getSlanCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
        this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
        this.hashFields.put("por_nod_cd", "porNodCd");
        this.hashFields.put("first_vvd", "firstVvd");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
        this.hashFields.put("pol_nod_cd", "polNodCd");
        this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
        this.hashFields.put("pctl_no", "pctlNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bkg_trunk_vvd", "bkgTrunkVvd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("pod_nod_cd", "podNodCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("del_nod_cd", "delNodCd");
        this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
        this.hashFields.put("bkg_ctrl_pty_cust_cnt_cd", "bkgCtrlPtyCustCntCd");
        this.hashFields.put("bkg_ctrl_pty_cust_seq", "bkgCtrlPtyCustSeq");
        this.hashFields.put("slan_cd", "slanCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return porCd
	 */
    public String getPorCd() {
        return this.porCd;
    }

    /**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
    public String getBkgCgoTpCd() {
        return this.bkgCgoTpCd;
    }

    /**
	 * Column Info
	 * @return preRlyPortCd
	 */
    public String getPreRlyPortCd() {
        return this.preRlyPortCd;
    }

    /**
	 * Column Info
	 * @return porNodCd
	 */
    public String getPorNodCd() {
        return this.porNodCd;
    }

    /**
	 * Column Info
	 * @return firstVvd
	 */
    public String getFirstVvd() {
        return this.firstVvd;
    }

    /**
	 * Column Info
	 * @return delCd
	 */
    public String getDelCd() {
        return this.delCd;
    }

    /**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
    public String getMtyPkupYdCd() {
        return this.mtyPkupYdCd;
    }

    /**
	 * Column Info
	 * @return polNodCd
	 */
    public String getPolNodCd() {
        return this.polNodCd;
    }

    /**
	 * Column Info
	 * @return fullRtnYdCd
	 */
    public String getFullRtnYdCd() {
        return this.fullRtnYdCd;
    }

    /**
	 * Column Info
	 * @return pctlNo
	 */
    public String getPctlNo() {
        return this.pctlNo;
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
	 * @return bkgTrunkVvd
	 */
    public String getBkgTrunkVvd() {
        return this.bkgTrunkVvd;
    }

    /**
	 * Column Info
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
    }

    /**
	 * Column Info
	 * @return deTermCd
	 */
    public String getDeTermCd() {
        return this.deTermCd;
    }

    /**
	 * Column Info
	 * @return podNodCd
	 */
    public String getPodNodCd() {
        return this.podNodCd;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 * Column Info
	 * @return delNodCd
	 */
    public String getDelNodCd() {
        return this.delNodCd;
    }

    /**
	 * Column Info
	 * @return obSlsOfcCd
	 */
    public String getObSlsOfcCd() {
        return this.obSlsOfcCd;
    }

    /**
	 * Column Info
	 * @return rcvTermCd
	 */
    public String getRcvTermCd() {
        return this.rcvTermCd;
    }

    /**
	 * Column Info
	 * @return pstRlyPortCd
	 */
    public String getPstRlyPortCd() {
        return this.pstRlyPortCd;
    }

    /**
	 * Column Info
	 * @return bkgCtrlPtyCustCntCd
	 */
    public String getBkgCtrlPtyCustCntCd() {
        return this.bkgCtrlPtyCustCntCd;
    }

    /**
	 * Column Info
	 * @return bkgCtrlPtyCustSeq
	 */
    public String getBkgCtrlPtyCustSeq() {
        return this.bkgCtrlPtyCustSeq;
    }

    /**
	 * Column Info
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
    public void setBkgCgoTpCd(String bkgCgoTpCd) {
        this.bkgCgoTpCd = bkgCgoTpCd;
    }

    /**
	 * Column Info
	 * @param preRlyPortCd
	 */
    public void setPreRlyPortCd(String preRlyPortCd) {
        this.preRlyPortCd = preRlyPortCd;
    }

    /**
	 * Column Info
	 * @param porNodCd
	 */
    public void setPorNodCd(String porNodCd) {
        this.porNodCd = porNodCd;
    }

    /**
	 * Column Info
	 * @param firstVvd
	 */
    public void setFirstVvd(String firstVvd) {
        this.firstVvd = firstVvd;
    }

    /**
	 * Column Info
	 * @param delCd
	 */
    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    /**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
    public void setMtyPkupYdCd(String mtyPkupYdCd) {
        this.mtyPkupYdCd = mtyPkupYdCd;
    }

    /**
	 * Column Info
	 * @param polNodCd
	 */
    public void setPolNodCd(String polNodCd) {
        this.polNodCd = polNodCd;
    }

    /**
	 * Column Info
	 * @param fullRtnYdCd
	 */
    public void setFullRtnYdCd(String fullRtnYdCd) {
        this.fullRtnYdCd = fullRtnYdCd;
    }

    /**
	 * Column Info
	 * @param pctlNo
	 */
    public void setPctlNo(String pctlNo) {
        this.pctlNo = pctlNo;
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
	 * @param bkgTrunkVvd
	 */
    public void setBkgTrunkVvd(String bkgTrunkVvd) {
        this.bkgTrunkVvd = bkgTrunkVvd;
    }

    /**
	 * Column Info
	 * @param podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @param deTermCd
	 */
    public void setDeTermCd(String deTermCd) {
        this.deTermCd = deTermCd;
    }

    /**
	 * Column Info
	 * @param podNodCd
	 */
    public void setPodNodCd(String podNodCd) {
        this.podNodCd = podNodCd;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * @param delNodCd
	 */
    public void setDelNodCd(String delNodCd) {
        this.delNodCd = delNodCd;
    }

    /**
	 * Column Info
	 * @param obSlsOfcCd
	 */
    public void setObSlsOfcCd(String obSlsOfcCd) {
        this.obSlsOfcCd = obSlsOfcCd;
    }

    /**
	 * Column Info
	 * @param rcvTermCd
	 */
    public void setRcvTermCd(String rcvTermCd) {
        this.rcvTermCd = rcvTermCd;
    }

    /**
	 * Column Info
	 * @param pstRlyPortCd
	 */
    public void setPstRlyPortCd(String pstRlyPortCd) {
        this.pstRlyPortCd = pstRlyPortCd;
    }

    /**
	 * Column Info
	 * @param bkgCtrlPtyCustCntCd
	 */
    public void setBkgCtrlPtyCustCntCd(String bkgCtrlPtyCustCntCd) {
        this.bkgCtrlPtyCustCntCd = bkgCtrlPtyCustCntCd;
    }

    /**
	 * Column Info
	 * @param bkgCtrlPtyCustSeq
	 */
    public void setBkgCtrlPtyCustSeq(String bkgCtrlPtyCustSeq) {
        this.bkgCtrlPtyCustSeq = bkgCtrlPtyCustSeq;
    }

    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    public String getSlanCd() {
        return this.slanCd;
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
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
        setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
        setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
        setFirstVvd(JSPUtil.getParameter(request, prefix + "first_vvd", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
        setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
        setFullRtnYdCd(JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", ""));
        setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setBkgTrunkVvd(JSPUtil.getParameter(request, prefix + "bkg_trunk_vvd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
        setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setPstRlyPortCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", ""));
        setBkgCtrlPtyCustCntCd(JSPUtil.getParameter(request, "bkg_ctrl_pty_cust_cnt_cd", ""));
        setBkgCtrlPtyCustSeq(JSPUtil.getParameter(request, "bkg_ctrl_pty_cust_seq", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OldBkgInfoVO[]
	 */
    public OldBkgInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OldBkgInfoVO[]
	 */
    public OldBkgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        OldBkgInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", length));
            String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", length));
            String[] porNodCd = (JSPUtil.getParameter(request, prefix + "por_nod_cd", length));
            String[] firstVvd = (JSPUtil.getParameter(request, prefix + "first_vvd", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", length));
            String[] polNodCd = (JSPUtil.getParameter(request, prefix + "pol_nod_cd", length));
            String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", length));
            String[] pctlNo = (JSPUtil.getParameter(request, prefix + "pctl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] bkgTrunkVvd = (JSPUtil.getParameter(request, prefix + "bkg_trunk_vvd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] podNodCd = (JSPUtil.getParameter(request, prefix + "pod_nod_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] delNodCd = (JSPUtil.getParameter(request, prefix + "del_nod_cd", length));
            String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", length));
            String[] bkgCtrlPtyCustCntCd = (JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_cnt_cd", length));
            String[] bkgCtrlPtyCustSeq = (JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_seq", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new OldBkgInfoVO();
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (bkgCgoTpCd[i] != null)
                    model.setBkgCgoTpCd(bkgCgoTpCd[i]);
                if (preRlyPortCd[i] != null)
                    model.setPreRlyPortCd(preRlyPortCd[i]);
                if (porNodCd[i] != null)
                    model.setPorNodCd(porNodCd[i]);
                if (firstVvd[i] != null)
                    model.setFirstVvd(firstVvd[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (mtyPkupYdCd[i] != null)
                    model.setMtyPkupYdCd(mtyPkupYdCd[i]);
                if (polNodCd[i] != null)
                    model.setPolNodCd(polNodCd[i]);
                if (fullRtnYdCd[i] != null)
                    model.setFullRtnYdCd(fullRtnYdCd[i]);
                if (pctlNo[i] != null)
                    model.setPctlNo(pctlNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgTrunkVvd[i] != null)
                    model.setBkgTrunkVvd(bkgTrunkVvd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (podNodCd[i] != null)
                    model.setPodNodCd(podNodCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (delNodCd[i] != null)
                    model.setDelNodCd(delNodCd[i]);
                if (obSlsOfcCd[i] != null)
                    model.setObSlsOfcCd(obSlsOfcCd[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (pstRlyPortCd[i] != null)
                    model.setPstRlyPortCd(pstRlyPortCd[i]);
                if (bkgCtrlPtyCustCntCd[i] != null)
                    model.setBkgCtrlPtyCustCntCd(bkgCtrlPtyCustCntCd[i]);
                if (bkgCtrlPtyCustSeq[i] != null)
                    model.setBkgCtrlPtyCustSeq(bkgCtrlPtyCustSeq[i]);
                if (slanCd[i] != null) 
		    		model.setSlanCd(slanCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getOldBkgInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return OldBkgInfoVO[]
	 */
    public OldBkgInfoVO[] getOldBkgInfoVOs() {
        OldBkgInfoVO[] vos = (OldBkgInfoVO[]) models.toArray(new OldBkgInfoVO[models.size()]);
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
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCgoTpCd = this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preRlyPortCd = this.preRlyPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNodCd = this.porNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.firstVvd = this.firstVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupYdCd = this.mtyPkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNodCd = this.polNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullRtnYdCd = this.fullRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgTrunkVvd = this.bkgTrunkVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNodCd = this.podNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delNodCd = this.delNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSlsOfcCd = this.obSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pstRlyPortCd = this.pstRlyPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCtrlPtyCustCntCd = this.bkgCtrlPtyCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCtrlPtyCustSeq = this.bkgCtrlPtyCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
