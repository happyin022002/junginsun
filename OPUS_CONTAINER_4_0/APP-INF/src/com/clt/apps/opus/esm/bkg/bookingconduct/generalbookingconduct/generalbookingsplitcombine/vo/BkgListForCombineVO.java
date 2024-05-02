/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgListForCombineVO.java
*@FileTitle : BkgListForCombineVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.10  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgListForCombineVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgListForCombineVO> models = new ArrayList<BkgListForCombineVO>();

    /* Column Info */
    private String bkgOfcCd = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String porNodCd = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String bdrFlg = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String polNodCd = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String podCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String podNodCd = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String delNodCd = null;

    /* Column Info */
    private String broker = null;

    /* Column Info */
    private String cntrVol = null;

    /* Column Info */
    private String irrBlNoFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgListForCombineVO() {
    }

    public BkgListForCombineVO(String ibflag, String pagerows, String bkgNo, String blNo, String bkgStsCd, String custNm, String porCd, String porNodCd, String polCd, String polNodCd, String podCd, String podNodCd, String delCd, String delNodCd, String cntrVol, String vvd, String custCd, String bdrFlg, String broker, String bkgOfcCd, String irrBlNoFlg) {
        this.bkgOfcCd = bkgOfcCd;
        this.porCd = porCd;
        this.porNodCd = porNodCd;
        this.custNm = custNm;
        this.bdrFlg = bdrFlg;
        this.bkgStsCd = bkgStsCd;
        this.delCd = delCd;
        this.polNodCd = polNodCd;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.vvd = vvd;
        this.podCd = podCd;
        this.ibflag = ibflag;
        this.bkgNo = bkgNo;
        this.polCd = polCd;
        this.podNodCd = podNodCd;
        this.custCd = custCd;
        this.delNodCd = delNodCd;
        this.broker = broker;
        this.cntrVol = cntrVol;
        this.irrBlNoFlg = irrBlNoFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("por_nod_cd", getPorNodCd());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("bdr_flg", getBdrFlg());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("pol_nod_cd", getPolNodCd());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("pod_nod_cd", getPodNodCd());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("del_nod_cd", getDelNodCd());
        this.hashColumns.put("broker", getBroker());
        this.hashColumns.put("cntr_vol", getCntrVol());
        this.hashColumns.put("irr_bl_no_flg", getIrrBlNoFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("por_nod_cd", "porNodCd");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("bdr_flg", "bdrFlg");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("pol_nod_cd", "polNodCd");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("pod_nod_cd", "podNodCd");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("del_nod_cd", "delNodCd");
        this.hashFields.put("broker", "broker");
        this.hashFields.put("cntr_vol", "cntrVol");
        this.hashFields.put("irr_bl_no_flg", "irrBlNoFlg");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return bkgOfcCd
	 */
    public String getBkgOfcCd() {
        return this.bkgOfcCd;
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
	 * @return porNodCd
	 */
    public String getPorNodCd() {
        return this.porNodCd;
    }

    /**
	 * Column Info
	 * @return custNm
	 */
    public String getCustNm() {
        return this.custNm;
    }

    /**
	 * Column Info
	 * @return bdrFlg
	 */
    public String getBdrFlg() {
        return this.bdrFlg;
    }

    /**
	 * Column Info
	 * @return bkgStsCd
	 */
    public String getBkgStsCd() {
        return this.bkgStsCd;
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
	 * @return polNodCd
	 */
    public String getPolNodCd() {
        return this.polNodCd;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
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
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	 * Column Info
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
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
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
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
	 * @return podNodCd
	 */
    public String getPodNodCd() {
        return this.podNodCd;
    }

    /**
	 * Column Info
	 * @return custCd
	 */
    public String getCustCd() {
        return this.custCd;
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
	 * @return broker
	 */
    public String getBroker() {
        return this.broker;
    }

    /**
	 * Column Info
	 * @return cntrVol
	 */
    public String getCntrVol() {
        return this.cntrVol;
    }

    /**
	 * Column Info
	 * @param bkgOfcCd
	 */
    public void setBkgOfcCd(String bkgOfcCd) {
        this.bkgOfcCd = bkgOfcCd;
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
	 * @param porNodCd
	 */
    public void setPorNodCd(String porNodCd) {
        this.porNodCd = porNodCd;
    }

    /**
	 * Column Info
	 * @param custNm
	 */
    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    /**
	 * Column Info
	 * @param bdrFlg
	 */
    public void setBdrFlg(String bdrFlg) {
        this.bdrFlg = bdrFlg;
    }

    /**
	 * Column Info
	 * @param bkgStsCd
	 */
    public void setBkgStsCd(String bkgStsCd) {
        this.bkgStsCd = bkgStsCd;
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
	 * @param polNodCd
	 */
    public void setPolNodCd(String polNodCd) {
        this.polNodCd = polNodCd;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
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
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
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
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
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
	 * @param podNodCd
	 */
    public void setPodNodCd(String podNodCd) {
        this.podNodCd = podNodCd;
    }

    /**
	 * Column Info
	 * @param custCd
	 */
    public void setCustCd(String custCd) {
        this.custCd = custCd;
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
	 * @param broker
	 */
    public void setBroker(String broker) {
        this.broker = broker;
    }

    /**
	 * Column Info
	 * @param cntrVol
	 */
    public void setCntrVol(String cntrVol) {
        this.cntrVol = cntrVol;
    }

    public void setIrrBlNoFlg(String irrBlNoFlg) {
        this.irrBlNoFlg = irrBlNoFlg;
    }

    public String getIrrBlNoFlg() {
        return this.irrBlNoFlg;
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
        setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
        setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
        setBroker(JSPUtil.getParameter(request, prefix + "broker", ""));
        setCntrVol(JSPUtil.getParameter(request, prefix + "cntr_vol", ""));
        setIrrBlNoFlg(JSPUtil.getParameter(request, prefix + "irr_bl_no_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForCombineVO[]
	 */
    public BkgListForCombineVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgListForCombineVO[]
	 */
    public BkgListForCombineVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgListForCombineVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] porNodCd = (JSPUtil.getParameter(request, prefix + "por_nod_cd", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] bdrFlg = (JSPUtil.getParameter(request, prefix + "bdr_flg", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] polNodCd = (JSPUtil.getParameter(request, prefix + "pol_nod_cd", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] podNodCd = (JSPUtil.getParameter(request, prefix + "pod_nod_cd", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] delNodCd = (JSPUtil.getParameter(request, prefix + "del_nod_cd", length));
            String[] broker = (JSPUtil.getParameter(request, prefix + "broker", length));
            String[] cntrVol = (JSPUtil.getParameter(request, prefix + "cntr_vol", length));
            String[] irrBlNoFlg = (JSPUtil.getParameter(request, prefix + "irr_bl_no_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgListForCombineVO();
                if (bkgOfcCd[i] != null)
                    model.setBkgOfcCd(bkgOfcCd[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (porNodCd[i] != null)
                    model.setPorNodCd(porNodCd[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (bdrFlg[i] != null)
                    model.setBdrFlg(bdrFlg[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (polNodCd[i] != null)
                    model.setPolNodCd(polNodCd[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (podNodCd[i] != null)
                    model.setPodNodCd(podNodCd[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (delNodCd[i] != null)
                    model.setDelNodCd(delNodCd[i]);
                if (broker[i] != null)
                    model.setBroker(broker[i]);
                if (cntrVol[i] != null)
                    model.setCntrVol(cntrVol[i]);
                if (irrBlNoFlg[i] != null) 
		    		model.setIrrBlNoFlg(irrBlNoFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgListForCombineVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgListForCombineVO[]
	 */
    public BkgListForCombineVO[] getBkgListForCombineVOs() {
        BkgListForCombineVO[] vos = (BkgListForCombineVO[]) models.toArray(new BkgListForCombineVO[models.size()]);
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
        this.bkgOfcCd = this.bkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNodCd = this.porNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdrFlg = this.bdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNodCd = this.polNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNodCd = this.podNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delNodCd = this.delNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.broker = this.broker.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVol = this.cntrVol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.irrBlNoFlg = this.irrBlNoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
