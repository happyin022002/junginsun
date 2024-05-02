/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ExternalRqstListInputVO.java
 *@FileTitle : ExternalRqstListInputVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.24
 *@LastModifier : 민동진
 *@LastVersion : 1.0
 * 2009.12.24 민동진 
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
 * @author 민동진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ExternalRqstListInputVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    /* Column Info */
    private String bkgCustTpCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String bkgNoSplit = null;

    /* Column Info */
    private String bkgUpldStsCd = null;

    /* Column Info */
    private String cnCnt = null;

    /* Column Info */
    private String cnNm = null;

    /* Column Info */
    private String cnSeq = null;

    /* Column Info */
    private String cntcEml = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String delivery = null;

    /* Column Info */
    private String docTpCd = null;

    /* Column Info */
    private String excelFlg = null;

    /* Column Info */
    private String ffCnt = null;

    /* Column Info */
    private String ffNm = null;

    /* Column Info */
    private String ffSeq = null;

    /* Column Info */
    private String split = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    /* Column Info */
    private String hndlOfcCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    private Collection<ExternalRqstListInputVO> models = new ArrayList<ExternalRqstListInputVO>();

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String origin = null;

    /* Column Info */
    private String pageNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String poNo = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String rqstFromDt = null;

    /* Column Info */
    private String rqstToDt = null;

    /* Column Info */
    private String setQryWhere = null;

    /* Column Info */
    private String setSlctFlg = null;

    /* Column Info */
    private String shCnt = null;

    /* Column Info */
    private String shNm = null;

    /* Column Info */
    private String shSeq = null;

    /* Column Info */
    private String xterBkgRqstStsCd = null;

    /* Column Info */
    private String xterRqstNo = null;

    /* Column Info */
    private String xterRqstSeq = null;

    /* Column Info */
    private String xterRqstViaCd = null;

    /* Column Info */
    private String xterSndrId = null;

    /* Column Info */
    private String chnAgnCd = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String lane = null;

    public ExternalRqstListInputVO() {
    }

    public ExternalRqstListInputVO(String ibflag, String pagerows, String porCd, String cntcEml, String bkgUpldStsCd, String xterBkgRqstStsCd, String docTpCd, String hndlOfcCd, String shSeq, String polCd, String cnSeq, String ffSeq, String shNm, String xterRqstViaCd, String cnCnt, String xterSndrId, String bkgNoSplit, String origin, String delCd, String ffCnt, String ffNm, String rqstFromDt, String podCd, String ofcCd, String poNo, String bkgNo, String shCnt, String rqstToDt, String xterRqstSeq, String delivery, String xterRqstNo, String cnNm, String setSlctFlg, String setQryWhere, String pageNo, String excelFlg, String bkgCustTpCd, String custCntCd, String custSeq, String custNm, String chnAgnCd, String vvd, String lane, String split) {
        this.porCd = porCd;
        this.custNm = custNm;
        this.cntcEml = cntcEml;
        this.hndlOfcCd = hndlOfcCd;
        this.docTpCd = docTpCd;
        this.xterBkgRqstStsCd = xterBkgRqstStsCd;
        this.bkgUpldStsCd = bkgUpldStsCd;
        this.shSeq = shSeq;
        this.pagerows = pagerows;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.cnSeq = cnSeq;
        this.ffSeq = ffSeq;
        this.setQryWhere = setQryWhere;
        this.shNm = shNm;
        this.bkgCustTpCd = bkgCustTpCd;
        this.custCntCd = custCntCd;
        this.xterRqstViaCd = xterRqstViaCd;
        this.cnCnt = cnCnt;
        this.xterSndrId = xterSndrId;
        this.bkgNoSplit = bkgNoSplit;
        this.origin = origin;
        this.delCd = delCd;
        this.ffCnt = ffCnt;
        this.custSeq = custSeq;
        this.ffNm = ffNm;
        this.rqstFromDt = rqstFromDt;
        this.podCd = podCd;
        this.ofcCd = ofcCd;
        this.bkgNo = bkgNo;
        this.poNo = poNo;
        this.shCnt = shCnt;
        this.excelFlg = excelFlg;
        this.pageNo = pageNo;
        this.rqstToDt = rqstToDt;
        this.setSlctFlg = setSlctFlg;
        this.xterRqstSeq = xterRqstSeq;
        this.xterRqstNo = xterRqstNo;
        this.delivery = delivery;
        this.cnNm = cnNm;
        this.chnAgnCd = chnAgnCd;
        this.vvd = vvd;
        this.lane = lane;
        this.split = split;
    }

    public void setSplit(String split) {
        this.split = split;
    }

    public String getSplit() {
        return this.split;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
        setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
        setCntcEml(JSPUtil.getParameter(request, "cntc_eml", ""));
        setHndlOfcCd(JSPUtil.getParameter(request, "hndl_ofc_cd", ""));
        setDocTpCd(JSPUtil.getParameter(request, "doc_tp_cd", ""));
        setXterBkgRqstStsCd(JSPUtil.getParameter(request, "xter_bkg_rqst_sts_cd", ""));
        setBkgUpldStsCd(JSPUtil.getParameter(request, "bkg_upld_sts_cd", ""));
        setShSeq(JSPUtil.getParameter(request, "sh_seq", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setCnSeq(JSPUtil.getParameter(request, "cn_seq", ""));
        setFfSeq(JSPUtil.getParameter(request, "ff_seq", ""));
        setSetQryWhere(JSPUtil.getParameter(request, "set_qry_where", ""));
        setShNm(JSPUtil.getParameter(request, "sh_nm", ""));
        setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
        setXterRqstViaCd(JSPUtil.getParameter(request, "xter_rqst_via_cd", ""));
        setCnCnt(JSPUtil.getParameter(request, "cn_cnt", ""));
        setXterSndrId(JSPUtil.getParameter(request, "xter_sndr_id", ""));
        setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
        setOrigin(JSPUtil.getParameter(request, "origin", ""));
        setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
        setFfCnt(JSPUtil.getParameter(request, "ff_cnt", ""));
        setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
        setFfNm(JSPUtil.getParameter(request, "ff_nm", ""));
        setRqstFromDt(JSPUtil.getParameter(request, "rqst_from_dt", ""));
        setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
        setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
        setPoNo(JSPUtil.getParameter(request, "po_no", ""));
        setShCnt(JSPUtil.getParameter(request, "sh_cnt", ""));
        setExcelFlg(JSPUtil.getParameter(request, "excel_flg", ""));
        setPageNo(JSPUtil.getParameter(request, "page_no", ""));
        setRqstToDt(JSPUtil.getParameter(request, "rqst_to_dt", ""));
        setSetSlctFlg(JSPUtil.getParameter(request, "set_slct_flg", ""));
        setXterRqstSeq(JSPUtil.getParameter(request, "xter_rqst_seq", ""));
        setXterRqstNo(request.getParameter("xter_rqst_no"));
//        setXterRqstNo(JSPUtil.getParameter(request, "xter_rqst_no", ""));
        setDelivery(JSPUtil.getParameter(request, "delivery", ""));
        setCnNm(JSPUtil.getParameter(request, "cn_nm", ""));
        setChnAgnCd(JSPUtil.getParameter(request, "chn_agn_cd", ""));
        setVvd(JSPUtil.getParameter(request, "vvd", ""));
        setLane(JSPUtil.getParameter(request, "lane", ""));
        setSplit(JSPUtil.getParameter(request, "split", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExternalRqstListInputVO[]
	 */
    public ExternalRqstListInputVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExternalRqstListInputVO[]
	 */
    public ExternalRqstListInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ExternalRqstListInputVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] cntcEml = (JSPUtil.getParameter(request, prefix + "cntc_eml", length));
            String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", length));
            String[] docTpCd = (JSPUtil.getParameter(request, prefix + "doc_tp_cd", length));
            String[] xterBkgRqstStsCd = (JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_sts_cd", length));
            String[] bkgUpldStsCd = (JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", length));
            String[] shSeq = (JSPUtil.getParameter(request, prefix + "sh_seq", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cnSeq = (JSPUtil.getParameter(request, prefix + "cn_seq", length));
            String[] ffSeq = (JSPUtil.getParameter(request, prefix + "ff_seq", length));
            String[] setQryWhere = (JSPUtil.getParameter(request, prefix + "set_qry_where", length));
            String[] shNm = (JSPUtil.getParameter(request, prefix + "sh_nm", length));
            String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] xterRqstViaCd = (JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd", length));
            String[] cnCnt = (JSPUtil.getParameter(request, prefix + "cn_cnt", length));
            String[] xterSndrId = (JSPUtil.getParameter(request, prefix + "xter_sndr_id", length));
            String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix + "bkg_no_split", length));
            String[] origin = (JSPUtil.getParameter(request, prefix + "origin", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] ffCnt = (JSPUtil.getParameter(request, prefix + "ff_cnt", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] ffNm = (JSPUtil.getParameter(request, prefix + "ff_nm", length));
            String[] rqstFromDt = (JSPUtil.getParameter(request, prefix + "rqst_from_dt", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] poNo = (JSPUtil.getParameter(request, prefix + "po_no", length));
            String[] shCnt = (JSPUtil.getParameter(request, prefix + "sh_cnt", length));
            String[] excelFlg = (JSPUtil.getParameter(request, prefix + "excel_flg", length));
            String[] pageNo = (JSPUtil.getParameter(request, prefix + "page_no", length));
            String[] rqstToDt = (JSPUtil.getParameter(request, prefix + "rqst_to_dt", length));
            String[] setSlctFlg = (JSPUtil.getParameter(request, prefix + "set_slct_flg", length));
            String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix + "xter_rqst_seq", length));
            String[] xterRqstNo = (JSPUtil.getParameter(request, prefix + "xter_rqst_no", length));
            String[] delivery = (JSPUtil.getParameter(request, prefix + "delivery", length));
            String[] cnNm = (JSPUtil.getParameter(request, prefix + "cn_nm", length));
            String[] chnAgnCd = (JSPUtil.getParameter(request, prefix + "chn_agn_cd", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] lane = (JSPUtil.getParameter(request, prefix + "lane", length));
            String[] split = (JSPUtil.getParameter(request, prefix + "split", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ExternalRqstListInputVO();
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (cntcEml[i] != null)
                    model.setCntcEml(cntcEml[i]);
                if (hndlOfcCd[i] != null)
                    model.setHndlOfcCd(hndlOfcCd[i]);
                if (docTpCd[i] != null)
                    model.setDocTpCd(docTpCd[i]);
                if (xterBkgRqstStsCd[i] != null)
                    model.setXterBkgRqstStsCd(xterBkgRqstStsCd[i]);
                if (bkgUpldStsCd[i] != null)
                    model.setBkgUpldStsCd(bkgUpldStsCd[i]);
                if (shSeq[i] != null)
                    model.setShSeq(shSeq[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cnSeq[i] != null)
                    model.setCnSeq(cnSeq[i]);
                if (ffSeq[i] != null)
                    model.setFfSeq(ffSeq[i]);
                if (setQryWhere[i] != null)
                    model.setSetQryWhere(setQryWhere[i]);
                if (shNm[i] != null)
                    model.setShNm(shNm[i]);
                if (bkgCustTpCd[i] != null)
                    model.setBkgCustTpCd(bkgCustTpCd[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (xterRqstViaCd[i] != null)
                    model.setXterRqstViaCd(xterRqstViaCd[i]);
                if (cnCnt[i] != null)
                    model.setCnCnt(cnCnt[i]);
                if (xterSndrId[i] != null)
                    model.setXterSndrId(xterSndrId[i]);
                if (bkgNoSplit[i] != null)
                    model.setBkgNoSplit(bkgNoSplit[i]);
                if (origin[i] != null)
                    model.setOrigin(origin[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (ffCnt[i] != null)
                    model.setFfCnt(ffCnt[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (ffNm[i] != null)
                    model.setFfNm(ffNm[i]);
                if (rqstFromDt[i] != null)
                    model.setRqstFromDt(rqstFromDt[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (poNo[i] != null)
                    model.setPoNo(poNo[i]);
                if (shCnt[i] != null)
                    model.setShCnt(shCnt[i]);
                if (excelFlg[i] != null)
                    model.setExcelFlg(excelFlg[i]);
                if (pageNo[i] != null)
                    model.setPageNo(pageNo[i]);
                if (rqstToDt[i] != null)
                    model.setRqstToDt(rqstToDt[i]);
                if (setSlctFlg[i] != null)
                    model.setSetSlctFlg(setSlctFlg[i]);
                if (xterRqstSeq[i] != null)
                    model.setXterRqstSeq(xterRqstSeq[i]);
                if (xterRqstNo[i] != null)
                    model.setXterRqstNo(xterRqstNo[i]);
                if (delivery[i] != null)
                    model.setDelivery(delivery[i]);
                if (cnNm[i] != null)
                    model.setCnNm(cnNm[i]);
                if (chnAgnCd[i] != null)
                    model.setCnNm(chnAgnCd[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (lane[i] != null)
                    model.setLane(lane[i]);
                if (split[i] != null) 
		    		model.setSplit(split[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getExternalRqstListInputVOs();
    }

    /**
	 * Column Info
	 * @return bkgCustTpCd
	 */
    public String getBkgCustTpCd() {
        return this.bkgCustTpCd;
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
	 * @return bkgNoSplit
	 */
    public String getBkgNoSplit() {
        return this.bkgNoSplit;
    }

    /**
	 * Column Info
	 * @return bkgUpldStsCd
	 */
    public String getBkgUpldStsCd() {
        return this.bkgUpldStsCd;
    }

    /**
	 * Column Info
	 * @return cnCnt
	 */
    public String getCnCnt() {
        return this.cnCnt;
    }

    /**
	 * Column Info
	 * @return cnNm
	 */
    public String getCnNm() {
        return this.cnNm;
    }

    /**
	 * Column Info
	 * @return chnAgnCd
	 */
    public String getChnAgnCd() {
        return chnAgnCd;
    }

    /**
	 * Column Info
	 * @return cnSeq
	 */
    public String getCnSeq() {
        return this.cnSeq;
    }

    /**
	 * Column Info
	 * @return cntcEml
	 */
    public String getCntcEml() {
        return this.cntcEml;
    }

    /**
	 * Column Info
	 * @return vvd
	 */
    public String getVvd() {
        return vvd;
    }

    /**
	 * Column Info
	 * @return lane
	 */
    public String getLane() {
        return lane;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("cntc_eml", getCntcEml());
        this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
        this.hashColumns.put("doc_tp_cd", getDocTpCd());
        this.hashColumns.put("xter_bkg_rqst_sts_cd", getXterBkgRqstStsCd());
        this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());
        this.hashColumns.put("sh_seq", getShSeq());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cn_seq", getCnSeq());
        this.hashColumns.put("ff_seq", getFfSeq());
        this.hashColumns.put("set_qry_where", getSetQryWhere());
        this.hashColumns.put("sh_nm", getShNm());
        this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("xter_rqst_via_cd", getXterRqstViaCd());
        this.hashColumns.put("cn_cnt", getCnCnt());
        this.hashColumns.put("xter_sndr_id", getXterSndrId());
        this.hashColumns.put("bkg_no_split", getBkgNoSplit());
        this.hashColumns.put("origin", getOrigin());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("ff_cnt", getFfCnt());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("ff_nm", getFfNm());
        this.hashColumns.put("rqst_from_dt", getRqstFromDt());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("po_no", getPoNo());
        this.hashColumns.put("sh_cnt", getShCnt());
        this.hashColumns.put("excel_flg", getExcelFlg());
        this.hashColumns.put("page_no", getPageNo());
        this.hashColumns.put("rqst_to_dt", getRqstToDt());
        this.hashColumns.put("set_slct_flg", getSetSlctFlg());
        this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
        this.hashColumns.put("xter_rqst_no", getXterRqstNo());
        this.hashColumns.put("delivery", getDelivery());
        this.hashColumns.put("cn_nm", getCnNm());
        this.hashColumns.put("chn_agn_cd", getChnAgnCd());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("lane", getLane());
        this.hashColumns.put("split", getSplit());
        return this.hashColumns;
    }

    /**
	 * Column Info
	 * @return custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
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
	 * @return custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
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
	 * @return delivery
	 */
    public String getDelivery() {
        return this.delivery;
    }

    /**
	 * Column Info
	 * @return docTpCd
	 */
    public String getDocTpCd() {
        return this.docTpCd;
    }

    /**
	 * Column Info
	 * @return excelFlg
	 */
    public String getExcelFlg() {
        return this.excelFlg;
    }

    /**
	 * VO 배열을 반환
	 * @return ExternalRqstListInputVO[]
	 */
    public ExternalRqstListInputVO[] getExternalRqstListInputVOs() {
        ExternalRqstListInputVO[] vos = (ExternalRqstListInputVO[]) models.toArray(new ExternalRqstListInputVO[models.size()]);
        return vos;
    }

    /**
	 * Column Info
	 * @return ffCnt
	 */
    public String getFfCnt() {
        return this.ffCnt;
    }

    /**
	 * Column Info
	 * @return ffNm
	 */
    public String getFfNm() {
        return this.ffNm;
    }

    /**
	 * Column Info
	 * @return ffSeq
	 */
    public String getFfSeq() {
        return this.ffSeq;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("cntc_eml", "cntcEml");
        this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
        this.hashFields.put("doc_tp_cd", "docTpCd");
        this.hashFields.put("xter_bkg_rqst_sts_cd", "xterBkgRqstStsCd");
        this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
        this.hashFields.put("sh_seq", "shSeq");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cn_seq", "cnSeq");
        this.hashFields.put("ff_seq", "ffSeq");
        this.hashFields.put("set_qry_where", "setQryWhere");
        this.hashFields.put("sh_nm", "shNm");
        this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("xter_rqst_via_cd", "xterRqstViaCd");
        this.hashFields.put("cn_cnt", "cnCnt");
        this.hashFields.put("xter_sndr_id", "xterSndrId");
        this.hashFields.put("bkg_no_split", "bkgNoSplit");
        this.hashFields.put("origin", "origin");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("ff_cnt", "ffCnt");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("ff_nm", "ffNm");
        this.hashFields.put("rqst_from_dt", "rqstFromDt");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("po_no", "poNo");
        this.hashFields.put("sh_cnt", "shCnt");
        this.hashFields.put("excel_flg", "excelFlg");
        this.hashFields.put("page_no", "pageNo");
        this.hashFields.put("rqst_to_dt", "rqstToDt");
        this.hashFields.put("set_slct_flg", "setSlctFlg");
        this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
        this.hashFields.put("xter_rqst_no", "xterRqstNo");
        this.hashFields.put("delivery", "delivery");
        this.hashFields.put("cn_nm", "cnNm");
        this.hashFields.put("chn_agn_cd", "chnAgnCd");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("lane", "lane");
        this.hashFields.put("split", "split");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return hndlOfcCd
	 */
    public String getHndlOfcCd() {
        return this.hndlOfcCd;
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
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 * Column Info
	 * @return origin
	 */
    public String getOrigin() {
        return this.origin;
    }

    /**
	 * Column Info
	 * @return pageNo
	 */
    public String getPageNo() {
        return this.pageNo;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 * Column Info
	 * @return poNo
	 */
    public String getPoNo() {
        return this.poNo;
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
	 * @return rqstFromDt
	 */
    public String getRqstFromDt() {
        return this.rqstFromDt;
    }

    /**
	 * Column Info
	 * @return rqstToDt
	 */
    public String getRqstToDt() {
        return this.rqstToDt;
    }

    /**
	 * Column Info
	 * @return setQryWhere
	 */
    public String getSetQryWhere() {
        return this.setQryWhere;
    }

    /**
	 * Column Info
	 * @return setSlctFlg
	 */
    public String getSetSlctFlg() {
        return this.setSlctFlg;
    }

    /**
	 * Column Info
	 * @return shCnt
	 */
    public String getShCnt() {
        return this.shCnt;
    }

    /**
	 * Column Info
	 * @return shNm
	 */
    public String getShNm() {
        return this.shNm;
    }

    /**
	 * Column Info
	 * @return shSeq
	 */
    public String getShSeq() {
        return this.shSeq;
    }

    /**
	 * Column Info
	 * @return xterBkgRqstStsCd
	 */
    public String getXterBkgRqstStsCd() {
        return this.xterBkgRqstStsCd;
    }

    /**
	 * Column Info
	 * @return xterRqstNo
	 */
    public String getXterRqstNo() {
        return this.xterRqstNo;
    }

    /**
	 * Column Info
	 * @return xterRqstSeq
	 */
    public String getXterRqstSeq() {
        return this.xterRqstSeq;
    }

    /**
	 * Column Info
	 * @return xterRqstViaCd
	 */
    public String getXterRqstViaCd() {
        return this.xterRqstViaCd;
    }

    /**
	 * Column Info
	 * @return xterSndrId
	 */
    public String getXterSndrId() {
        return this.xterSndrId;
    }

    /**
	 * Column Info
	 * @param bkgCustTpCd
	 */
    public void setBkgCustTpCd(String bkgCustTpCd) {
        this.bkgCustTpCd = bkgCustTpCd;
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
	 * @param bkgNoSplit
	 */
    public void setBkgNoSplit(String bkgNoSplit) {
        this.bkgNoSplit = bkgNoSplit;
    }

    /**
	 * Column Info
	 * @param bkgUpldStsCd
	 */
    public void setBkgUpldStsCd(String bkgUpldStsCd) {
        this.bkgUpldStsCd = bkgUpldStsCd;
    }

    /**
	 * Column Info
	 * @param cnCnt
	 */
    public void setCnCnt(String cnCnt) {
        this.cnCnt = cnCnt;
    }

    /**
	 * Column Info
	 * @param cnNm
	 */
    public void setCnNm(String cnNm) {
        this.cnNm = cnNm;
    }

    /**
	 * Column Info
	 * @param cnSeq
	 */
    public void setCnSeq(String cnSeq) {
        this.cnSeq = cnSeq;
    }

    /**
	 * Column Info
	 * @param cntcEml
	 */
    public void setCntcEml(String cntcEml) {
        this.cntcEml = cntcEml;
    }

    /**
	 * Column Info
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
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
	 * @param custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
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
	 * @param delivery
	 */
    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    /**
	 * Column Info
	 * @param docTpCd
	 */
    public void setDocTpCd(String docTpCd) {
        this.docTpCd = docTpCd;
    }

    /**
	 * Column Info
	 * @param excelFlg
	 */
    public void setExcelFlg(String excelFlg) {
        this.excelFlg = excelFlg;
    }

    /**
	 * Column Info
	 * @param ffCnt
	 */
    public void setFfCnt(String ffCnt) {
        this.ffCnt = ffCnt;
    }

    /**
	 * Column Info
	 * @param ffNm
	 */
    public void setFfNm(String ffNm) {
        this.ffNm = ffNm;
    }

    /**
	 * Column Info
	 * @param ffSeq
	 */
    public void setFfSeq(String ffSeq) {
        this.ffSeq = ffSeq;
    }

    /**
	 * Column Info
	 * @param hndlOfcCd
	 */
    public void setHndlOfcCd(String hndlOfcCd) {
        this.hndlOfcCd = hndlOfcCd;
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
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @param origin
	 */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
	 * Column Info
	 * @param pageNo
	 */
    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * @param poNo
	 */
    public void setPoNo(String poNo) {
        this.poNo = poNo;
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
	 * @param rqstFromDt
	 */
    public void setRqstFromDt(String rqstFromDt) {
        this.rqstFromDt = rqstFromDt;
    }

    /**
	 * Column Info
	 * @param rqstToDt
	 */
    public void setRqstToDt(String rqstToDt) {
        this.rqstToDt = rqstToDt;
    }

    /**
	 * Column Info
	 * @param setQryWhere
	 */
    public void setSetQryWhere(String setQryWhere) {
        this.setQryWhere = setQryWhere;
    }

    /**
	 * Column Info
	 * @param setSlctFlg
	 */
    public void setSetSlctFlg(String setSlctFlg) {
        this.setSlctFlg = setSlctFlg;
    }

    /**
	 * Column Info
	 * @param shCnt
	 */
    public void setShCnt(String shCnt) {
        this.shCnt = shCnt;
    }

    /**
	 * Column Info
	 * @param shNm
	 */
    public void setShNm(String shNm) {
        this.shNm = shNm;
    }

    /**
	 * Column Info
	 * @param shSeq
	 */
    public void setShSeq(String shSeq) {
        this.shSeq = shSeq;
    }

    /**
	 * Column Info
	 * @param xterBkgRqstStsCd
	 */
    public void setXterBkgRqstStsCd(String xterBkgRqstStsCd) {
        this.xterBkgRqstStsCd = xterBkgRqstStsCd;
    }

    /**
	 * Column Info
	 * @param xterRqstNo
	 */
    public void setXterRqstNo(String xterRqstNo) {
        this.xterRqstNo = xterRqstNo;
    }

    /**
	 * Column Info
	 * @param xterRqstSeq
	 */
    public void setXterRqstSeq(String xterRqstSeq) {
        this.xterRqstSeq = xterRqstSeq;
    }

    /**
	 * Column Info
	 * @param xterRqstViaCd
	 */
    public void setXterRqstViaCd(String xterRqstViaCd) {
        this.xterRqstViaCd = xterRqstViaCd;
    }

    /**
	 * Column Info
	 * @param xterSndrId
	 */
    public void setXterSndrId(String xterSndrId) {
        this.xterSndrId = xterSndrId;
    }

    /**
	 * Column Info
	 * @return chnAgnCd
	 */
    public void setChnAgnCd(String chnAgnCd) {
        this.chnAgnCd = chnAgnCd;
    }

    /**
	 * Column Info
	 * @return vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @return lane
	 */
    public void setLane(String lane) {
        this.lane = lane;
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
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcEml = this.cntcEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hndlOfcCd = this.hndlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docTpCd = this.docTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterBkgRqstStsCd = this.xterBkgRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgUpldStsCd = this.bkgUpldStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shSeq = this.shSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnSeq = this.cnSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffSeq = this.ffSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.setQryWhere = this.setQryWhere.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shNm = this.shNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCustTpCd = this.bkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstViaCd = this.xterRqstViaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnCnt = this.cnCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterSndrId = this.xterSndrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNoSplit = this.bkgNoSplit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.origin = this.origin.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffCnt = this.ffCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffNm = this.ffNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstFromDt = this.rqstFromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.poNo = this.poNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shCnt = this.shCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.excelFlg = this.excelFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pageNo = this.pageNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstToDt = this.rqstToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.setSlctFlg = this.setSlctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstSeq = this.xterRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstNo = this.xterRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delivery = this.delivery.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnNm = this.cnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chnAgnCd = this.chnAgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lane = this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.split = this.split.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
