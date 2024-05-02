/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MtyRlseOrdExcelBKgVvdVO.java
*@FileTitle : MtyRlseOrdExcelBKgVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo;

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
public class MtyRlseOrdExcelBKgVvdVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MtyRlseOrdExcelBKgVvdVO> models = new ArrayList<MtyRlseOrdExcelBKgVvdVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String legSeq = null;

    /* Column Info */
    private String vslPrePstCd = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String lloydNo = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String callsign = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String unLocCd = null;

    /* Column Info */
    private String polYdCd = null;

    /* Column Info */
    private String polClptIndSeq = null;

    /* Column Info */
    private String locNm = null;

    /* Column Info */
    private String vpsEtaDt = null;

    /* Column Info */
    private String vpsEtdDt = null;

    /* Column Info */
    private String unLocCd1 = null;

    /* Column Info */
    private String podYdCd = null;

    /* Column Info */
    private String locNm1 = null;

    /* Column Info */
    private String obCssmVoyNo = null;

    /* Column Info */
    private String consVvdArr = null;

    /* Column Info */
    private String consVvdDep = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public MtyRlseOrdExcelBKgVvdVO() {
    }

    public MtyRlseOrdExcelBKgVvdVO(String ibflag, String pagerows, String bkgNo, String legSeq, String vslPrePstCd, String slanCd, String vslCd, String lloydNo, String vslEngNm, String callsign, String skdVoyNo, String skdDirCd, String unLocCd, String polYdCd, String polClptIndSeq, String locNm, String vpsEtaDt, String vpsEtdDt, String unLocCd1, String podYdCd, String locNm1, String obCssmVoyNo, String consVvdArr, String consVvdDep) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.bkgNo = bkgNo;
        this.legSeq = legSeq;
        this.vslPrePstCd = vslPrePstCd;
        this.slanCd = slanCd;
        this.vslCd = vslCd;
        this.lloydNo = lloydNo;
        this.vslEngNm = vslEngNm;
        this.callsign = callsign;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.unLocCd = unLocCd;
        this.polYdCd = polYdCd;
        this.polClptIndSeq = polClptIndSeq;
        this.locNm = locNm;
        this.vpsEtaDt = vpsEtaDt;
        this.vpsEtdDt = vpsEtdDt;
        this.unLocCd1 = unLocCd1;
        this.podYdCd = podYdCd;
        this.locNm1 = locNm1;
        this.obCssmVoyNo = obCssmVoyNo;
        this.consVvdArr = consVvdArr;
        this.consVvdDep = consVvdDep;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("leg_seq", getLegSeq());
        this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("lloyd_no", getLloydNo());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("callsign", getCallsign());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("un_loc_cd", getUnLocCd());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
        this.hashColumns.put("loc_nm", getLocNm());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
        this.hashColumns.put("un_loc_cd1", getUnLocCd1());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("loc_nm1", getLocNm1());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("cons_vvd_arr", getConsVvdArr());
        this.hashColumns.put("cons_vvd_dep", getConsVvdDep());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("leg_seq", "legSeq");
        this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("lloyd_no", "lloydNo");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("callsign", "callsign");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("un_loc_cd", "unLocCd");
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
        this.hashFields.put("loc_nm", "locNm");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("vps_etd_dt", "vpsEtdDt");
        this.hashFields.put("un_loc_cd1", "unLocCd1");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("loc_nm1", "locNm1");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("cons_vvd_arr", "consVvdArr");
        this.hashFields.put("cons_vvd_dep", "consVvdDep");
        return this.hashFields;
    }

    /**
	 *
	 * @param String ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * 
	 * @return String ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 *
	 * @param String pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * 
	 * @return String pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 *
	 * @param String bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * 
	 * @return String bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 *
	 * @param String legSeq
	 */
    public void setLegSeq(String legSeq) {
        this.legSeq = legSeq;
    }

    /**
	 * 
	 * @return String legSeq
	 */
    public String getLegSeq() {
        return this.legSeq;
    }

    /**
	 *
	 * @param String vslPrePstCd
	 */
    public void setVslPrePstCd(String vslPrePstCd) {
        this.vslPrePstCd = vslPrePstCd;
    }

    /**
	 * 
	 * @return String vslPrePstCd
	 */
    public String getVslPrePstCd() {
        return this.vslPrePstCd;
    }

    /**
	 *
	 * @param String slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * 
	 * @return String slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    /**
	 *
	 * @param String vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * 
	 * @return String vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 *
	 * @param String lloydNo
	 */
    public void setLloydNo(String lloydNo) {
        this.lloydNo = lloydNo;
    }

    /**
	 * 
	 * @return String lloydNo
	 */
    public String getLloydNo() {
        return this.lloydNo;
    }

    /**
	 *
	 * @param String vslEngNm
	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * 
	 * @return String vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	 *
	 * @param String callsign
	 */
    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    /**
	 * 
	 * @return String callsign
	 */
    public String getCallsign() {
        return this.callsign;
    }

    /**
	 *
	 * @param String skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * 
	 * @return String skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 *
	 * @param String skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * 
	 * @return String skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 *
	 * @param String unLocCd
	 */
    public void setUnLocCd(String unLocCd) {
        this.unLocCd = unLocCd;
    }

    /**
	 * 
	 * @return String unLocCd
	 */
    public String getUnLocCd() {
        return this.unLocCd;
    }

    /**
	 *
	 * @param String polYdCd
	 */
    public void setPolYdCd(String polYdCd) {
        this.polYdCd = polYdCd;
    }

    /**
	 * 
	 * @return String polYdCd
	 */
    public String getPolYdCd() {
        return this.polYdCd;
    }

    /**
	 *
	 * @param String polClptIndSeq
	 */
    public void setPolClptIndSeq(String polClptIndSeq) {
        this.polClptIndSeq = polClptIndSeq;
    }

    /**
	 * 
	 * @return String polClptIndSeq
	 */
    public String getPolClptIndSeq() {
        return this.polClptIndSeq;
    }

    /**
	 *
	 * @param String locNm
	 */
    public void setLocNm(String locNm) {
        this.locNm = locNm;
    }

    /**
	 * 
	 * @return String locNm
	 */
    public String getLocNm() {
        return this.locNm;
    }

    /**
	 *
	 * @param String vpsEtaDt
	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
    }

    /**
	 * 
	 * @return String vpsEtaDt
	 */
    public String getVpsEtaDt() {
        return this.vpsEtaDt;
    }

    /**
	 *
	 * @param String vpsEtdDt
	 */
    public void setVpsEtdDt(String vpsEtdDt) {
        this.vpsEtdDt = vpsEtdDt;
    }

    /**
	 * 
	 * @return String vpsEtdDt
	 */
    public String getVpsEtdDt() {
        return this.vpsEtdDt;
    }

    /**
	 *
	 * @param String unLocCd1
	 */
    public void setUnLocCd1(String unLocCd1) {
        this.unLocCd1 = unLocCd1;
    }

    /**
	 * 
	 * @return String unLocCd1
	 */
    public String getUnLocCd1() {
        return this.unLocCd1;
    }

    /**
	 *
	 * @param String podYdCd
	 */
    public void setPodYdCd(String podYdCd) {
        this.podYdCd = podYdCd;
    }

    /**
	 * 
	 * @return String podYdCd
	 */
    public String getPodYdCd() {
        return this.podYdCd;
    }

    /**
	 *
	 * @param String locNm1
	 */
    public void setLocNm1(String locNm1) {
        this.locNm1 = locNm1;
    }

    /**
	 * 
	 * @return String locNm1
	 */
    public String getLocNm1() {
        return this.locNm1;
    }

    /**
	 *
	 * @param String obCssmVoyNo
	 */
    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    /**
	 * 
	 * @return String obCssmVoyNo
	 */
    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
    }

    public void setConsVvdArr(String consVvdArr) {
        this.consVvdArr = consVvdArr;
    }

    public String getConsVvdArr() {
        return this.consVvdArr;
    }

    public void setConsVvdDep(String consVvdDep) {
        this.consVvdDep = consVvdDep;
    }

    public String getConsVvdDep() {
        return this.consVvdDep;
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
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setLegSeq(JSPUtil.getParameter(request, prefix + "leg_seq", ""));
        setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setCallsign(JSPUtil.getParameter(request, prefix + "callsign", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setUnLocCd(JSPUtil.getParameter(request, prefix + "un_loc_cd", ""));
        setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
        setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
        setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
        setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
        setUnLocCd1(JSPUtil.getParameter(request, prefix + "un_loc_cd1", ""));
        setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
        setLocNm1(JSPUtil.getParameter(request, prefix + "loc_nm1", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
        setConsVvdArr(JSPUtil.getParameter(request, prefix + "cons_vvd_arr", ""));
        setConsVvdDep(JSPUtil.getParameter(request, prefix + "cons_vvd_dep", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyRlseOrdExcelBKgVvdVO[]
	 */
    public MtyRlseOrdExcelBKgVvdVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyRlseOrdExcelBKgVvdVO[]
	 */
    public MtyRlseOrdExcelBKgVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MtyRlseOrdExcelBKgVvdVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] legSeq = (JSPUtil.getParameter(request, prefix + "leg_seq", length));
            String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] lloydNo = (JSPUtil.getParameter(request, prefix + "lloyd_no", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] callsign = (JSPUtil.getParameter(request, prefix + "callsign", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] unLocCd = (JSPUtil.getParameter(request, prefix + "un_loc_cd", length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd", length));
            String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", length));
            String[] locNm = (JSPUtil.getParameter(request, prefix + "loc_nm", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix + "vps_etd_dt", length));
            String[] unLocCd1 = (JSPUtil.getParameter(request, prefix + "un_loc_cd1", length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd", length));
            String[] locNm1 = (JSPUtil.getParameter(request, prefix + "loc_nm1", length));
            String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
            String[] consVvdArr = (JSPUtil.getParameter(request, prefix + "cons_vvd_arr", length));
	    	String[] consVvdDep = (JSPUtil.getParameter(request, prefix + "cons_vvd_dep", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MtyRlseOrdExcelBKgVvdVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (legSeq[i] != null)
                    model.setLegSeq(legSeq[i]);
                if (vslPrePstCd[i] != null)
                    model.setVslPrePstCd(vslPrePstCd[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (lloydNo[i] != null)
                    model.setLloydNo(lloydNo[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (callsign[i] != null)
                    model.setCallsign(callsign[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (unLocCd[i] != null)
                    model.setUnLocCd(unLocCd[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (polClptIndSeq[i] != null)
                    model.setPolClptIndSeq(polClptIndSeq[i]);
                if (locNm[i] != null)
                    model.setLocNm(locNm[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (vpsEtdDt[i] != null)
                    model.setVpsEtdDt(vpsEtdDt[i]);
                if (unLocCd1[i] != null)
                    model.setUnLocCd1(unLocCd1[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (locNm1[i] != null)
                    model.setLocNm1(locNm1[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (consVvdArr[i] != null) 
		    		model.setConsVvdArr(consVvdArr[i]);
				if (consVvdDep[i] != null) 
		    		model.setConsVvdDep(consVvdDep[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getMtyRlseOrdExcelBKgVvdVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return MtyRlseOrdExcelBKgVvdVO[]
	 */
    public MtyRlseOrdExcelBKgVvdVO[] getMtyRlseOrdExcelBKgVvdVOs() {
        MtyRlseOrdExcelBKgVvdVO[] vos = (MtyRlseOrdExcelBKgVvdVO[]) models.toArray(new MtyRlseOrdExcelBKgVvdVO[models.size()]);
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
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.legSeq = this.legSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslPrePstCd = this.vslPrePstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lloydNo = this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callsign = this.callsign.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unLocCd = this.unLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polClptIndSeq = this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locNm = this.locNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt = this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unLocCd1 = this.unLocCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locNm1 = this.locNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.consVvdArr = this.consVvdArr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.consVvdDep = this.consVvdDep.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
