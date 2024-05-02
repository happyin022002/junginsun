/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CstSkdByPolPodVO.java
*@FileTitle : CstSkdByPolPodVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.06.24 정진우 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CstSkdByPolPodVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CstSkdByPolPodVO> models = new ArrayList<CstSkdByPolPodVO>();

    /* Column Info */
    private String podTmlCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String podEtd = null;

    /* Column Info */
    private String fmDt = null;

    /* Column Info */
    private String polYard = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String polTmlCd = null;

    /* Column Info */
    private String podPort = null;

    /* Column Info */
    private String vslSlanCd = null;

    /* Column Info */
    private String carrierCd = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String toDt = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String polEtd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String delayDate = null;

    /* Column Info */
    private String podEtb = null;

    /* Column Info */
    private String polEta = null;

    /* Column Info */
    private String podEta = null;

    /* Column Info */
    private String podYard = null;

    /* Column Info */
    private String polPort = null;

    /* Column Info */
    private String polEtb = null;

    /* Column Info */
    private String ibCssmVoyNo = null;

    /* Column Info */
    private String obCssmVoyNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CstSkdByPolPodVO() {
    }

    public CstSkdByPolPodVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String vslSlanCd, String polPort, String polYard, String polTmlCd, String polEta, String polEtb, String polEtd, String podPort, String podYard, String podTmlCd, String podEta, String podEtb, String podEtd, String delayDate, String carrierCd, String fmDt, String toDt, String ibCssmVoyNo, String obCssmVoyNo) {
        this.podTmlCd = podTmlCd;
        this.vslCd = vslCd;
        this.podEtd = podEtd;
        this.fmDt = fmDt;
        this.polYard = polYard;
        this.skdVoyNo = skdVoyNo;
        this.polTmlCd = polTmlCd;
        this.podPort = podPort;
        this.vslSlanCd = vslSlanCd;
        this.carrierCd = carrierCd;
        this.skdDirCd = skdDirCd;
        this.pagerows = pagerows;
        this.toDt = toDt;
        this.vvd = vvd;
        this.polEtd = polEtd;
        this.ibflag = ibflag;
        this.delayDate = delayDate;
        this.podEtb = podEtb;
        this.polEta = polEta;
        this.podEta = podEta;
        this.podYard = podYard;
        this.polPort = polPort;
        this.polEtb = polEtb;
        this.ibCssmVoyNo = ibCssmVoyNo;
        this.obCssmVoyNo = obCssmVoyNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pod_tml_cd", getPodTmlCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("pod_etd", getPodEtd());
        this.hashColumns.put("fm_dt", getFmDt());
        this.hashColumns.put("pol_yard", getPolYard());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("pol_tml_cd", getPolTmlCd());
        this.hashColumns.put("pod_port", getPodPort());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("carrier_cd", getCarrierCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("to_dt", getToDt());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("pol_etd", getPolEtd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("delay_date", getDelayDate());
        this.hashColumns.put("pod_etb", getPodEtb());
        this.hashColumns.put("pol_eta", getPolEta());
        this.hashColumns.put("pod_eta", getPodEta());
        this.hashColumns.put("pod_yard", getPodYard());
        this.hashColumns.put("pol_port", getPolPort());
        this.hashColumns.put("pol_etb", getPolEtb());
        this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("pod_tml_cd", "podTmlCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("pod_etd", "podEtd");
        this.hashFields.put("fm_dt", "fmDt");
        this.hashFields.put("pol_yard", "polYard");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("pol_tml_cd", "polTmlCd");
        this.hashFields.put("pod_port", "podPort");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("carrier_cd", "carrierCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("to_dt", "toDt");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("pol_etd", "polEtd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("delay_date", "delayDate");
        this.hashFields.put("pod_etb", "podEtb");
        this.hashFields.put("pol_eta", "polEta");
        this.hashFields.put("pod_eta", "podEta");
        this.hashFields.put("pod_yard", "podYard");
        this.hashFields.put("pol_port", "polPort");
        this.hashFields.put("pol_etb", "polEtb");
        this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return podTmlCd
	 */
    public String getPodTmlCd() {
        return this.podTmlCd;
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
	 * @return podEtd
	 */
    public String getPodEtd() {
        return this.podEtd;
    }

    /**
	 * Column Info
	 * @return fmDt
	 */
    public String getFmDt() {
        return this.fmDt;
    }

    /**
	 * Column Info
	 * @return polYard
	 */
    public String getPolYard() {
        return this.polYard;
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
	 * @return polTmlCd
	 */
    public String getPolTmlCd() {
        return this.polTmlCd;
    }

    /**
	 * Column Info
	 * @return podPort
	 */
    public String getPodPort() {
        return this.podPort;
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
	 * @return carrierCd
	 */
    public String getCarrierCd() {
        return this.carrierCd;
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
	 * @return toDt
	 */
    public String getToDt() {
        return this.toDt;
    }

    /**
	 * Column Info
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	 * Column Info
	 * @return polEtd
	 */
    public String getPolEtd() {
        return this.polEtd;
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
	 * @return delayDate
	 */
    public String getDelayDate() {
        return this.delayDate;
    }

    /**
	 * Column Info
	 * @return podEtb
	 */
    public String getPodEtb() {
        return this.podEtb;
    }

    /**
	 * Column Info
	 * @return polEta
	 */
    public String getPolEta() {
        return this.polEta;
    }

    /**
	 * Column Info
	 * @return podEta
	 */
    public String getPodEta() {
        return this.podEta;
    }

    /**
	 * Column Info
	 * @return podYard
	 */
    public String getPodYard() {
        return this.podYard;
    }

    /**
	 * Column Info
	 * @return polPort
	 */
    public String getPolPort() {
        return this.polPort;
    }

    /**
	 * Column Info
	 * @return polEtb
	 */
    public String getPolEtb() {
        return this.polEtb;
    }

    /**
	 * Column Info
	 * @param podTmlCd
	 */
    public void setPodTmlCd(String podTmlCd) {
        this.podTmlCd = podTmlCd;
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
	 * @param podEtd
	 */
    public void setPodEtd(String podEtd) {
        this.podEtd = podEtd;
    }

    /**
	 * Column Info
	 * @param fmDt
	 */
    public void setFmDt(String fmDt) {
        this.fmDt = fmDt;
    }

    /**
	 * Column Info
	 * @param polYard
	 */
    public void setPolYard(String polYard) {
        this.polYard = polYard;
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
	 * @param polTmlCd
	 */
    public void setPolTmlCd(String polTmlCd) {
        this.polTmlCd = polTmlCd;
    }

    /**
	 * Column Info
	 * @param podPort
	 */
    public void setPodPort(String podPort) {
        this.podPort = podPort;
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
	 * @param carrierCd
	 */
    public void setCarrierCd(String carrierCd) {
        this.carrierCd = carrierCd;
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
	 * @param toDt
	 */
    public void setToDt(String toDt) {
        this.toDt = toDt;
    }

    /**
	 * Column Info
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param polEtd
	 */
    public void setPolEtd(String polEtd) {
        this.polEtd = polEtd;
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
	 * @param delayDate
	 */
    public void setDelayDate(String delayDate) {
        this.delayDate = delayDate;
    }

    /**
	 * Column Info
	 * @param podEtb
	 */
    public void setPodEtb(String podEtb) {
        this.podEtb = podEtb;
    }

    /**
	 * Column Info
	 * @param polEta
	 */
    public void setPolEta(String polEta) {
        this.polEta = polEta;
    }

    /**
	 * Column Info
	 * @param podEta
	 */
    public void setPodEta(String podEta) {
        this.podEta = podEta;
    }

    /**
	 * Column Info
	 * @param podYard
	 */
    public void setPodYard(String podYard) {
        this.podYard = podYard;
    }

    /**
	 * Column Info
	 * @param polPort
	 */
    public void setPolPort(String polPort) {
        this.polPort = polPort;
    }

    /**
	 * Column Info
	 * @param polEtb
	 */
    public void setPolEtb(String polEtb) {
        this.polEtb = polEtb;
    }

    public void setIbCssmVoyNo(String ibCssmVoyNo) {
        this.ibCssmVoyNo = ibCssmVoyNo;
    }

    public String getIbCssmVoyNo() {
        return this.ibCssmVoyNo;
    }

    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setPodTmlCd(JSPUtil.getParameter(request, "pod_tml_cd", ""));
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setPodEtd(JSPUtil.getParameter(request, "pod_etd", ""));
        setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
        setPolYard(JSPUtil.getParameter(request, "pol_yard", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
        setPolTmlCd(JSPUtil.getParameter(request, "pol_tml_cd", ""));
        setPodPort(JSPUtil.getParameter(request, "pod_port", ""));
        setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
        setCarrierCd(JSPUtil.getParameter(request, "carrier_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setToDt(JSPUtil.getParameter(request, "to_dt", ""));
        setVvd(JSPUtil.getParameter(request, "vvd", ""));
        setPolEtd(JSPUtil.getParameter(request, "pol_etd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setDelayDate(JSPUtil.getParameter(request, "delay_date", ""));
        setPodEtb(JSPUtil.getParameter(request, "pod_etb", ""));
        setPolEta(JSPUtil.getParameter(request, "pol_eta", ""));
        setPodEta(JSPUtil.getParameter(request, "pod_eta", ""));
        setPodYard(JSPUtil.getParameter(request, "pod_yard", ""));
        setPolPort(JSPUtil.getParameter(request, "pol_port", ""));
        setPolEtb(JSPUtil.getParameter(request, "pol_etb", ""));
        setIbCssmVoyNo(JSPUtil.getParameter(request, "ib_cssm_voy_no", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, "ob_cssm_voy_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstSkdByPolPodVO[]
	 */
    public CstSkdByPolPodVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstSkdByPolPodVO[]
	 */
    public CstSkdByPolPodVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CstSkdByPolPodVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] podTmlCd = (JSPUtil.getParameter(request, prefix + "pod_tml_cd".trim(), length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd".trim(), length));
            String[] podEtd = (JSPUtil.getParameter(request, prefix + "pod_etd".trim(), length));
            String[] fmDt = (JSPUtil.getParameter(request, prefix + "fm_dt".trim(), length));
            String[] polYard = (JSPUtil.getParameter(request, prefix + "pol_yard".trim(), length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no".trim(), length));
            String[] polTmlCd = (JSPUtil.getParameter(request, prefix + "pol_tml_cd".trim(), length));
            String[] podPort = (JSPUtil.getParameter(request, prefix + "pod_port".trim(), length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd".trim(), length));
            String[] carrierCd = (JSPUtil.getParameter(request, prefix + "carrier_cd".trim(), length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] toDt = (JSPUtil.getParameter(request, prefix + "to_dt".trim(), length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd".trim(), length));
            String[] polEtd = (JSPUtil.getParameter(request, prefix + "pol_etd".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] delayDate = (JSPUtil.getParameter(request, prefix + "delay_date".trim(), length));
            String[] podEtb = (JSPUtil.getParameter(request, prefix + "pod_etb".trim(), length));
            String[] polEta = (JSPUtil.getParameter(request, prefix + "pol_eta".trim(), length));
            String[] podEta = (JSPUtil.getParameter(request, prefix + "pod_eta".trim(), length));
            String[] podYard = (JSPUtil.getParameter(request, prefix + "pod_yard".trim(), length));
            String[] polPort = (JSPUtil.getParameter(request, prefix + "pol_port".trim(), length));
            String[] polEtb = (JSPUtil.getParameter(request, prefix + "pol_etb".trim(), length));
            String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", length));
	    	String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CstSkdByPolPodVO();
                if (podTmlCd[i] != null)
                    model.setPodTmlCd(podTmlCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (podEtd[i] != null)
                    model.setPodEtd(podEtd[i]);
                if (fmDt[i] != null)
                    model.setFmDt(fmDt[i]);
                if (polYard[i] != null)
                    model.setPolYard(polYard[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (polTmlCd[i] != null)
                    model.setPolTmlCd(polTmlCd[i]);
                if (podPort[i] != null)
                    model.setPodPort(podPort[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (carrierCd[i] != null)
                    model.setCarrierCd(carrierCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (toDt[i] != null)
                    model.setToDt(toDt[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (polEtd[i] != null)
                    model.setPolEtd(polEtd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (delayDate[i] != null)
                    model.setDelayDate(delayDate[i]);
                if (podEtb[i] != null)
                    model.setPodEtb(podEtb[i]);
                if (polEta[i] != null)
                    model.setPolEta(polEta[i]);
                if (podEta[i] != null)
                    model.setPodEta(podEta[i]);
                if (podYard[i] != null)
                    model.setPodYard(podYard[i]);
                if (polPort[i] != null)
                    model.setPolPort(polPort[i]);
                if (polEtb[i] != null)
                    model.setPolEtb(polEtb[i]);
                if (ibCssmVoyNo[i] != null) 
		    		model.setIbCssmVoyNo(ibCssmVoyNo[i]);
				if (obCssmVoyNo[i] != null) 
		    		model.setObCssmVoyNo(obCssmVoyNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCstSkdByPolPodVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CstSkdByPolPodVO[]
	 */
    public CstSkdByPolPodVO[] getCstSkdByPolPodVOs() {
        CstSkdByPolPodVO[] vos = (CstSkdByPolPodVO[]) models.toArray(new CstSkdByPolPodVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
                        ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
                    }
                } else {
                    ret.append(field[i].getName() + " =  null \n");
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return ret.toString();
    }

    /**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.podTmlCd = this.podTmlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podEtd = this.podEtd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmDt = this.fmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYard = this.polYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polTmlCd = this.polTmlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podPort = this.podPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.carrierCd = this.carrierCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toDt = this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polEtd = this.polEtd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delayDate = this.delayDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podEtb = this.podEtb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polEta = this.polEta.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podEta = this.podEta.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYard = this.podYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polPort = this.polPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polEtb = this.polEtb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCssmVoyNo = this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
