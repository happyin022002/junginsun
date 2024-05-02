/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgListForCompFirmVO.java
*@FileTitle : BkgListForCompFirmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.09  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

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
public class BkgListForCompFirmVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgListForCompFirmVO> models = new ArrayList<BkgListForCompFirmVO>();

    /* Column Info */
    private String feu = null;

    /* Column Info */
    private String sCustNm = null;

    /* Column Info */
    private String bkgNumber = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String bdrFlg = null;

    /* Column Info */
    private String bkgTVvd = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String fCustNm = null;

    /* Column Info */
    private String ton = null;

    /* Column Info */
    private String teu = null;

    /* Column Info */
    private String bkgWtChkFlg = null;

    /* Column Info */
    private String ediHldFlg = null;

    /* Column Info */
    private String porCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgListForCompFirmVO() {
    }

    public BkgListForCompFirmVO(String ibflag, String pagerows, String bkgNumber, String bkgTVvd, String polCd, String sCustNm, String fCustNm, String cmdtCd, String cmdtNm, String feu, String teu, String ton, String podCd, String bkgNo, String bdrFlg, String bkgStsCd, String bkgWtChkFlg, String ediHldFlg, String porCd) {
        this.feu = feu;
        this.sCustNm = sCustNm;
        this.bkgNumber = bkgNumber;
        this.bkgStsCd = bkgStsCd;
        this.bdrFlg = bdrFlg;
        this.bkgTVvd = bkgTVvd;
        this.cmdtNm = cmdtNm;
        this.pagerows = pagerows;
        this.podCd = podCd;
        this.bkgNo = bkgNo;
        this.ibflag = ibflag;
        this.polCd = polCd;
        this.cmdtCd = cmdtCd;
        this.fCustNm = fCustNm;
        this.ton = ton;
        this.teu = teu;
        this.bkgWtChkFlg = bkgWtChkFlg;
        this.ediHldFlg = ediHldFlg;
        this.porCd = porCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("feu", getFeu());
        this.hashColumns.put("s_cust_nm", getSCustNm());
        this.hashColumns.put("bkg_number", getBkgNumber());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("bdr_flg", getBdrFlg());
        this.hashColumns.put("bkg_t_vvd", getBkgTVvd());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("f_cust_nm", getFCustNm());
        this.hashColumns.put("ton", getTon());
        this.hashColumns.put("teu", getTeu());
        this.hashColumns.put("bkg_wt_chk_flg", getBkgWtChkFlg());
        this.hashColumns.put("edi_hld_flg", getEdiHldFlg());
        this.hashColumns.put("por_cd", getPorCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("feu", "feu");
        this.hashFields.put("s_cust_nm", "sCustNm");
        this.hashFields.put("bkg_number", "bkgNumber");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("bdr_flg", "bdrFlg");
        this.hashFields.put("bkg_t_vvd", "bkgTVvd");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("f_cust_nm", "fCustNm");
        this.hashFields.put("ton", "ton");
        this.hashFields.put("teu", "teu");
        this.hashFields.put("bkg_wt_chk_flg", "bkgWtChkFlg");
        this.hashFields.put("edi_hld_flg", "ediHldFlg");
        this.hashFields.put("por_cd", "porCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return feu
	 */
    public String getFeu() {
        return this.feu;
    }

    /**
	 * Column Info
	 * @return sCustNm
	 */
    public String getSCustNm() {
        return this.sCustNm;
    }

    /**
	 * Column Info
	 * @return bkgNumber
	 */
    public String getBkgNumber() {
        return this.bkgNumber;
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
	 * @return bdrFlg
	 */
    public String getBdrFlg() {
        return this.bdrFlg;
    }

    /**
	 * Column Info
	 * @return bkgTVvd
	 */
    public String getBkgTVvd() {
        return this.bkgTVvd;
    }

    /**
	 * Column Info
	 * @return cmdtNm
	 */
    public String getCmdtNm() {
        return this.cmdtNm;
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
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
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
	 * @return cmdtCd
	 */
    public String getCmdtCd() {
        return this.cmdtCd;
    }

    /**
	 * Column Info
	 * @return fCustNm
	 */
    public String getFCustNm() {
        return this.fCustNm;
    }

    /**
	 * Column Info
	 * @return ton
	 */
    public String getTon() {
        return this.ton;
    }

    /**
	 * Column Info
	 * @return teu
	 */
    public String getTeu() {
        return this.teu;
    }

    /**
	 * Column Info
	 * @param feu
	 */
    public void setFeu(String feu) {
        this.feu = feu;
    }

    /**
	 * Column Info
	 * @param sCustNm
	 */
    public void setSCustNm(String sCustNm) {
        this.sCustNm = sCustNm;
    }

    /**
	 * Column Info
	 * @param bkgNumber
	 */
    public void setBkgNumber(String bkgNumber) {
        this.bkgNumber = bkgNumber;
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
	 * @param bdrFlg
	 */
    public void setBdrFlg(String bdrFlg) {
        this.bdrFlg = bdrFlg;
    }

    /**
	 * Column Info
	 * @param bkgTVvd
	 */
    public void setBkgTVvd(String bkgTVvd) {
        this.bkgTVvd = bkgTVvd;
    }

    /**
	 * Column Info
	 * @param cmdtNm
	 */
    public void setCmdtNm(String cmdtNm) {
        this.cmdtNm = cmdtNm;
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
	 * @param podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
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
	 * @param cmdtCd
	 */
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
    }

    /**
	 * Column Info
	 * @param fCustNm
	 */
    public void setFCustNm(String fCustNm) {
        this.fCustNm = fCustNm;
    }

    /**
	 * Column Info
	 * @param ton
	 */
    public void setTon(String ton) {
        this.ton = ton;
    }

    /**
	 * Column Info
	 * @param teu
	 */
    public void setTeu(String teu) {
        this.teu = teu;
    }

    public void setBkgWtChkFlg(String bkgWtChkFlg) {
        this.bkgWtChkFlg = bkgWtChkFlg;
    }

    public String getBkgWtChkFlg() {
        return this.bkgWtChkFlg;
    }

    public void setEdiHldFlg(String ediHldFlg) {
        this.ediHldFlg = ediHldFlg;
    }

    public String getEdiHldFlg() {
        return this.ediHldFlg;
    }

    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    public String getPorCd() {
        return this.porCd;
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
        setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
        setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
        setBkgNumber(JSPUtil.getParameter(request, prefix + "bkg_number", ""));
        setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
        setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
        setBkgTVvd(JSPUtil.getParameter(request, prefix + "bkg_t_vvd", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setFCustNm(JSPUtil.getParameter(request, prefix + "f_cust_nm", ""));
        setTon(JSPUtil.getParameter(request, prefix + "ton", ""));
        setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
        setBkgWtChkFlg(JSPUtil.getParameter(request, prefix + "bkg_wt_chk_flg", ""));
        setEdiHldFlg(JSPUtil.getParameter(request, prefix + "edi_hld_flg", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForCompFirmVO[]
	 */
    public BkgListForCompFirmVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgListForCompFirmVO[]
	 */
    public BkgListForCompFirmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgListForCompFirmVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] feu = (JSPUtil.getParameter(request, prefix + "feu", length));
            String[] sCustNm = (JSPUtil.getParameter(request, prefix + "s_cust_nm", length));
            String[] bkgNumber = (JSPUtil.getParameter(request, prefix + "bkg_number", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] bdrFlg = (JSPUtil.getParameter(request, prefix + "bdr_flg", length));
            String[] bkgTVvd = (JSPUtil.getParameter(request, prefix + "bkg_t_vvd", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] fCustNm = (JSPUtil.getParameter(request, prefix + "f_cust_nm", length));
            String[] ton = (JSPUtil.getParameter(request, prefix + "ton", length));
            String[] teu = (JSPUtil.getParameter(request, prefix + "teu", length));
            String[] bkgWtChkFlg = (JSPUtil.getParameter(request, prefix + "bkg_wt_chk_flg", length));
            String[] ediHldFlg = (JSPUtil.getParameter(request, prefix + "edi_hld_flg", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgListForCompFirmVO();
                if (feu[i] != null)
                    model.setFeu(feu[i]);
                if (sCustNm[i] != null)
                    model.setSCustNm(sCustNm[i]);
                if (bkgNumber[i] != null)
                    model.setBkgNumber(bkgNumber[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (bdrFlg[i] != null)
                    model.setBdrFlg(bdrFlg[i]);
                if (bkgTVvd[i] != null)
                    model.setBkgTVvd(bkgTVvd[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (fCustNm[i] != null)
                    model.setFCustNm(fCustNm[i]);
                if (ton[i] != null)
                    model.setTon(ton[i]);
                if (teu[i] != null)
                    model.setTeu(teu[i]);
                if (bkgWtChkFlg[i] != null)
                    model.setBkgWtChkFlg(bkgWtChkFlg[i]);
                if (ediHldFlg[i] != null)
                    model.setEdiHldFlg(ediHldFlg[i]);
                if (porCd[i] != null) 
		    		model.setPorCd(porCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgListForCompFirmVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgListForCompFirmVO[]
	 */
    public BkgListForCompFirmVO[] getBkgListForCompFirmVOs() {
        BkgListForCompFirmVO[] vos = (BkgListForCompFirmVO[]) models.toArray(new BkgListForCompFirmVO[models.size()]);
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
        this.feu = this.feu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCustNm = this.sCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNumber = this.bkgNumber.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdrFlg = this.bdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgTVvd = this.bkgTVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCustNm = this.fCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ton = this.ton.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.teu = this.teu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgWtChkFlg = this.bkgWtChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediHldFlg = this.ediHldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
