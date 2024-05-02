/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgCustAvcNtcSchVO.java
*@FileTitle : BkgCustAvcNtcSchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.25  
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.02.19 김보배 [CHM-201322482] [BKG] 개발:Split 01-Customer Advisory 기능 추가 (BST Download)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
public class BkgCustAvcNtcSchVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgCustAvcNtcSchVO> models = new ArrayList<BkgCustAvcNtcSchVO>();

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String eDirCd = null;

    /* Column Info */
    private String wDirCd = null;

    /* Column Info */
    private String sDirCd = null;

    /* Column Info */
    private String nDirCd = null;

    /* Column Info */
    private String dirStsCd = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String bkgCustTpCd = null;

    /* Column Info */
    private String srcDatTpCd = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String searchClssType = null;

    /* Column Info */
    private String keyAcctFlg = null;

    /* Column Info */
    private String gloAcctFlg = null;

    /* Column Info */
    private String rgnAcctFlg = null;

    /* Column Info */
    private String lclAcctFlg = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String cntrNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgCustAvcNtcSchVO() {
    }

    public BkgCustAvcNtcSchVO(String ibflag, String vvd, String eDirCd, String wDirCd, String dirStsCd, String polCd, String podCd, String delCd, String custCntCd, String custSeq, String bkgCustTpCd, String porCd, String srcDatTpCd, String ofcCd, String searchClssType, String keyAcctFlg, String gloAcctFlg, String rgnAcctFlg, String lclAcctFlg, String sDirCd, String nDirCd, String bkgNo, String cntrNo) {
        this.vvd = vvd;
        this.eDirCd = eDirCd;
        this.wDirCd = wDirCd;
        this.dirStsCd = dirStsCd;
        this.polCd = polCd;
        this.podCd = podCd;
        this.delCd = delCd;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.bkgCustTpCd = bkgCustTpCd;
        this.ibflag = ibflag;
        this.porCd = porCd;
        this.srcDatTpCd = srcDatTpCd;
        this.ofcCd = ofcCd;
        this.searchClssType = searchClssType;
        this.keyAcctFlg = keyAcctFlg;
        this.gloAcctFlg = gloAcctFlg;
        this.rgnAcctFlg = rgnAcctFlg;
        this.lclAcctFlg = lclAcctFlg;
        this.sDirCd = sDirCd;
        this.nDirCd = nDirCd;
        this.bkgNo = bkgNo;
        this.cntrNo = cntrNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("e_dir_cd", getEDirCd());
        this.hashColumns.put("w_dir_cd", getWDirCd());
        this.hashColumns.put("dir_sts_cd", getDirStsCd());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
        this.hashColumns.put("src_dat_tp_cd", getSrcDatTpCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("search_clss_type", getSearchClssType());
        this.hashColumns.put("key_acct_flg", getKeyAcctFlg());
        this.hashColumns.put("glo_acct_flg", getGloAcctFlg());
        this.hashColumns.put("rgn_acct_flg", getRgnAcctFlg());
        this.hashColumns.put("lcl_acct_flg", getLclAcctFlg());
        this.hashColumns.put("s_dir_cd", getSDirCd());
        this.hashColumns.put("n_dir_cd", getNDirCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cntr_no", getCntrNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("e_dir_cd", "eDirCd");
        this.hashFields.put("w_dir_cd", "wDirCd");
        this.hashFields.put("dir_sts_cd", "dirStsCd");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
        this.hashFields.put("src_dat_tp_cd", "srcDatTpCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("searchClssType", "searchClssType");
        this.hashFields.put("key_acct_flg", "keyAcctFlg");
        this.hashFields.put("glo_acct_flg", "gloAcctFlg");
        this.hashFields.put("rgn_acct_flg", "rgnAcctFlg");
        this.hashFields.put("lcl_acct_flg", "lclAcctFlg");
        this.hashFields.put("s_dir_cd", "sDirCd");
        this.hashFields.put("n_dir_cd", "nDirCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cntr_no", "cntrNo");
        return this.hashFields;
    }

    public Collection<BkgCustAvcNtcSchVO> getModels() {
        return models;
    }

    public void setModels(Collection<BkgCustAvcNtcSchVO> models) {
        this.models = models;
    }

    public String getVvd() {
        return vvd;
    }

    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    public String getEDirCd() {
        return eDirCd;
    }

    public void setEDirCd(String eDirCd) {
        this.eDirCd = eDirCd;
    }

    public String getWDirCd() {
        return wDirCd;
    }

    public void setWDirCd(String wDirCd) {
        this.wDirCd = wDirCd;
    }

    public String getSDirCd() {
        return sDirCd;
    }

    public void setSDirCd(String sDirCd) {
        this.sDirCd = sDirCd;
    }

    public String getNDirCd() {
        return nDirCd;
    }

    public void setNDirCd(String nDirCd) {
        this.nDirCd = nDirCd;
    }

    public String getDirStsCd() {
        return dirStsCd;
    }

    public void setDirStsCd(String dirStsCd) {
        this.dirStsCd = dirStsCd;
    }

    public String getSearchClssType() {
        return searchClssType;
    }

    public void setSearchClssType(String searchClssType) {
        this.searchClssType = searchClssType;
    }

    public String getPorCd() {
        return porCd;
    }

    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    public String getPolCd() {
        return polCd;
    }

    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    public String getPodCd() {
        return podCd;
    }

    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    public String getDelCd() {
        return delCd;
    }

    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    public String getCustCntCd() {
        return custCntCd;
    }

    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    public String getCustSeq() {
        return custSeq;
    }

    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    public String getBkgCustTpCd() {
        return bkgCustTpCd;
    }

    public void setBkgCustTpCd(String bkgCustTpCd) {
        this.bkgCustTpCd = bkgCustTpCd;
    }

    public String getIbflag() {
        return ibflag;
    }

    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    public String getOfcCd() {
        return ofcCd;
    }

    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    public HashMap<String, String> getHashColumns() {
        return hashColumns;
    }

    public void setHashColumns(HashMap<String, String> hashColumns) {
        this.hashColumns = hashColumns;
    }

    public HashMap<String, String> getHashFields() {
        return hashFields;
    }

    public void setHashFields(HashMap<String, String> hashFields) {
        this.hashFields = hashFields;
    }

    /**
	 * Column Info
	 * @return srcDatTpCd
	 */
    public String getSrcDatTpCd() {
        return this.srcDatTpCd;
    }

    /**
	 * Column Info
	 * @param srcDatTpCd
	 */
    public void setSrcDatTpCd(String srcDatTpCd) {
        this.srcDatTpCd = srcDatTpCd;
    }

    /**
	 * Column Info
	 * @return keyAcctFlg
	 */
    public String getKeyAcctFlg() {
        return this.keyAcctFlg;
    }

    /**
	 * Column Info
	 * @return gloAcctFlg
	 */
    public String getGloAcctFlg() {
        return this.gloAcctFlg;
    }

    /**
	 * Column Info
	 * @return rgnAcctFlg
	 */
    public String getRgnAcctFlg() {
        return this.rgnAcctFlg;
    }

    /**
	 * Column Info
	 * @return lclAcctFlg
	 */
    public String getLclAcctFlg() {
        return this.lclAcctFlg;
    }

    /**
	 * Column Info
	 * @param keyAcctFlg
	 */
    public void setKeyAcctFlg(String keyAcctFlg) {
        this.keyAcctFlg = keyAcctFlg;
    }

    /**
	 * Column Info
	 * @param gloAcctFlg
	 */
    public void setGloAcctFlg(String gloAcctFlg) {
        this.gloAcctFlg = gloAcctFlg;
    }

    /**
	 * Column Info
	 * @param rgnAcctFlg
	 */
    public void setRgnAcctFlg(String rgnAcctFlg) {
        this.rgnAcctFlg = rgnAcctFlg;
    }

    /**
	 * Column Info
	 * @param lclAcctFlg
	 */
    public void setLclAcctFlg(String lclAcctFlg) {
        this.lclAcctFlg = lclAcctFlg;
    }

    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    public String getBkgNo() {
        return this.bkgNo;
    }

    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    public String getCntrNo() {
        return this.cntrNo;
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
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setEDirCd(JSPUtil.getParameter(request, prefix + "e_dir_cd", ""));
        setWDirCd(JSPUtil.getParameter(request, prefix + "w_dir_cd", ""));
        setDirStsCd(JSPUtil.getParameter(request, prefix + "dir_sts_cd", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
        setSrcDatTpCd(JSPUtil.getParameter(request, prefix + "src_dat_tp_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setSearchClssType(JSPUtil.getParameter(request, prefix + "search_clss_type", ""));
        setKeyAcctFlg(JSPUtil.getParameter(request, prefix + "key_acct_flg", ""));
        setGloAcctFlg(JSPUtil.getParameter(request, prefix + "glo_acct_flg", ""));
        setRgnAcctFlg(JSPUtil.getParameter(request, prefix + "rgn_acct_flg", ""));
        setLclAcctFlg(JSPUtil.getParameter(request, prefix + "lcl_acct_flg", ""));
        setSDirCd(JSPUtil.getParameter(request, prefix + "s_dir_cd", ""));
        setNDirCd(JSPUtil.getParameter(request, prefix + "n_dir_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCustAvcNtcSchVO[]
	 */
    public BkgCustAvcNtcSchVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCustAvcNtcSchVO[]
	 */
    public BkgCustAvcNtcSchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgCustAvcNtcSchVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] eDirCd = (JSPUtil.getParameter(request, prefix + "e_dir_cd", length));
            String[] wDirCd = (JSPUtil.getParameter(request, prefix + "w_dir_cd", length));
            String[] sDirCd = (JSPUtil.getParameter(request, prefix + "s_dir_cd", length));
            String[] nDirCd = (JSPUtil.getParameter(request, prefix + "n_dir_cd", length));
            String[] dirStsCd = (JSPUtil.getParameter(request, prefix + "dir_sts_cd", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", length));
            String[] srcDatTpCd = (JSPUtil.getParameter(request, prefix + "src_dat_tp_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] searchClssType = (JSPUtil.getParameter(request, prefix + "search_clss_type", length));
            String[] keyAcctFlg = (JSPUtil.getParameter(request, prefix + "key_acct_flg", length));
            String[] gloAcctFlg = (JSPUtil.getParameter(request, prefix + "glo_acct_flg", length));
            String[] rgnAcctFlg = (JSPUtil.getParameter(request, prefix + "rgn_acct_flg", length));
            String[] lclAcctFlg = (JSPUtil.getParameter(request, prefix + "lcl_acct_flg", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgCustAvcNtcSchVO();
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (eDirCd[i] != null)
                    model.setEDirCd(eDirCd[i]);
                if (wDirCd[i] != null)
                    model.setWDirCd(wDirCd[i]);
                if (sDirCd[i] != null)
                    model.setSDirCd(sDirCd[i]);
                if (nDirCd[i] != null)
                    model.setNDirCd(nDirCd[i]);
                if (dirStsCd[i] != null)
                    model.setDirStsCd(dirStsCd[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (bkgCustTpCd[i] != null)
                    model.setBkgCustTpCd(bkgCustTpCd[i]);
                if (srcDatTpCd[i] != null)
                    model.setSrcDatTpCd(srcDatTpCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (searchClssType[i] != null)
                    model.setSearchClssType(searchClssType[i]);
                if (keyAcctFlg[i] != null)
                    model.setKeyAcctFlg(keyAcctFlg[i]);
                if (gloAcctFlg[i] != null)
                    model.setGloAcctFlg(gloAcctFlg[i]);
                if (rgnAcctFlg[i] != null)
                    model.setRgnAcctFlg(rgnAcctFlg[i]);
                if (lclAcctFlg[i] != null)
                    model.setLclAcctFlg(lclAcctFlg[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (cntrNo[i] != null) 
		    		model.setCntrNo(cntrNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgCustAvcNtcSchVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgCustAvcNtcSchVO[]
	 */
    public BkgCustAvcNtcSchVO[] getBkgCustAvcNtcSchVOs() {
        BkgCustAvcNtcSchVO[] vos = (BkgCustAvcNtcSchVO[]) models.toArray(new BkgCustAvcNtcSchVO[models.size()]);
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
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eDirCd = this.eDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wDirCd = this.wDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dirStsCd = this.dirStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCustTpCd = this.bkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srcDatTpCd = this.srcDatTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.searchClssType = this.searchClssType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctFlg = this.keyAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gloAcctFlg = this.gloAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnAcctFlg = this.rgnAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lclAcctFlg = this.lclAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sDirCd = this.sDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nDirCd = this.nDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
