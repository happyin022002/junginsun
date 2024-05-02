/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgCntrShpVO.java
*@FileTitle : BkgCntrShpVO
*Open Issues :
*Change history : 
*@LastModifyDate : 2016.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.26  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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
public class BkgCntrShpVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgCntrShpVO> models = new ArrayList<BkgCntrShpVO>();

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cntrVolQty = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String measQty = null;

    /* Column Info */
    private String cntrMfWgt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String cmdtDesc = null;

    /* Column Info */
    private String mkDesc = null;

    /* Column Info */
    private String prnFlg = null;

    /* Column Info */
    private String measUtCd = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String cntrMfSeq = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String cntrSealNo1 = null;

    /* Column Info */
    private String cntrSealNo2 = null;

    /* Column Info */
    private String cmdtHsCd = null;

    /* Column Info */
    private String hamoTrfCd = null;

    /* Column Info */
    private String ncmNo = null;

    /* Column Info */
    private String poNo = null;

    /* Column Info */
    private String cntrSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgCntrShpVO() {
    }

    public BkgCntrShpVO(String ibflag, String pagerows, String bkgNo, String cntrMfSeq, String cntrNo, String cntrTpszCd, String cntrVolQty, String pckQty, String pckTpCd, String cntrMfWgt, String wgtUtCd, String measQty, String measUtCd, String mkDesc, String cmdtDesc, String prnFlg, String cntrSealNo1, String cntrSealNo2, String cmdtHsCd, String hamoTrfCd, String ncmNo, String poNo, String cntrSeq) {
        this.pagerows = pagerows;
        this.cntrVolQty = cntrVolQty;
        this.pckTpCd = pckTpCd;
        this.measQty = measQty;
        this.cntrMfWgt = cntrMfWgt;
        this.ibflag = ibflag;
        this.bkgNo = bkgNo;
        this.cmdtDesc = cmdtDesc;
        this.mkDesc = mkDesc;
        this.prnFlg = prnFlg;
        this.measUtCd = measUtCd;
        this.wgtUtCd = wgtUtCd;
        this.cntrTpszCd = cntrTpszCd;
        this.cntrMfSeq = cntrMfSeq;
        this.pckQty = pckQty;
        this.cntrNo = cntrNo;
        this.cntrSealNo1 = cntrSealNo1;
        this.cntrSealNo2 = cntrSealNo2;
        this.cmdtHsCd = cmdtHsCd;
        this.hamoTrfCd = hamoTrfCd;
        this.ncmNo = ncmNo;
        this.poNo = poNo;
        this.cntrSeq = cntrSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cmdt_desc", getCmdtDesc());
        this.hashColumns.put("mk_desc", getMkDesc());
        this.hashColumns.put("prn_flg", getPrnFlg());
        this.hashColumns.put("meas_ut_cd", getMeasUtCd());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("cntr_seal_no1", getCntrSealNo1());
        this.hashColumns.put("cntr_seal_no2", getCntrSealNo2());
        this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
        this.hashColumns.put("hamo_trf_cd", getHamoTrfCd());
        this.hashColumns.put("ncm_no", getNcmNo());
        this.hashColumns.put("po_no", getPoNo());
        this.hashColumns.put("cntr_seq", getCntrSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cntr_vol_qty", "cntrVolQty");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cmdt_desc", "cmdtDesc");
        this.hashFields.put("mk_desc", "mkDesc");
        this.hashFields.put("prn_flg", "prnFlg");
        this.hashFields.put("meas_ut_cd", "measUtCd");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("cntr_seal_no1", "cntrSealNo1");
        this.hashFields.put("cntr_seal_no2", "cntrSealNo2");
        this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
        this.hashFields.put("hamo_trf_cd", "hamoTrfCd");
        this.hashFields.put("ncm_no", "ncmNo");
        this.hashFields.put("po_no", "poNo");
        this.hashFields.put("cntr_seq", "cntrSeq");
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
	 * @return cntrVolQty
	 */
    public String getCntrVolQty() {
        return this.cntrVolQty;
    }

    /**
	 * Column Info
	 * @return pckTpCd
	 */
    public String getPckTpCd() {
        return this.pckTpCd;
    }

    /**
	 * Column Info
	 * @return measQty
	 */
    public String getMeasQty() {
        return this.measQty;
    }

    /**
	 * Column Info
	 * @return cntrMfWgt
	 */
    public String getCntrMfWgt() {
        return this.cntrMfWgt;
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
	 * @return cmdtDesc
	 */
    public String getCmdtDesc() {
        return this.cmdtDesc;
    }

    /**
	 * Column Info
	 * @return mkDesc
	 */
    public String getMkDesc() {
        return this.mkDesc;
    }

    /**
	 * Column Info
	 * @return prnFlg
	 */
    public String getPrnFlg() {
        return this.prnFlg;
    }

    /**
	 * Column Info
	 * @return measUtCd
	 */
    public String getMeasUtCd() {
        return this.measUtCd;
    }

    /**
	 * Column Info
	 * @return wgtUtCd
	 */
    public String getWgtUtCd() {
        return this.wgtUtCd;
    }

    /**
	 * Column Info
	 * @return cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    /**
	 * Column Info
	 * @return cntrMfSeq
	 */
    public String getCntrMfSeq() {
        return this.cntrMfSeq;
    }

    /**
	 * Column Info
	 * @return pckQty
	 */
    public String getPckQty() {
        return this.pckQty;
    }

    /**
	 * Column Info
	 * @return cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
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
	 * @param cntrVolQty
	 */
    public void setCntrVolQty(String cntrVolQty) {
        this.cntrVolQty = cntrVolQty;
    }

    /**
	 * Column Info
	 * @param pckTpCd
	 */
    public void setPckTpCd(String pckTpCd) {
        this.pckTpCd = pckTpCd;
    }

    /**
	 * Column Info
	 * @param measQty
	 */
    public void setMeasQty(String measQty) {
        this.measQty = measQty;
    }

    /**
	 * Column Info
	 * @param cntrMfWgt
	 */
    public void setCntrMfWgt(String cntrMfWgt) {
        this.cntrMfWgt = cntrMfWgt;
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
	 * @param cmdtDesc
	 */
    public void setCmdtDesc(String cmdtDesc) {
        this.cmdtDesc = cmdtDesc;
    }

    /**
	 * Column Info
	 * @param mkDesc
	 */
    public void setMkDesc(String mkDesc) {
        this.mkDesc = mkDesc;
    }

    /**
	 * Column Info
	 * @param prnFlg
	 */
    public void setPrnFlg(String prnFlg) {
        this.prnFlg = prnFlg;
    }

    /**
	 * Column Info
	 * @param measUtCd
	 */
    public void setMeasUtCd(String measUtCd) {
        this.measUtCd = measUtCd;
    }

    /**
	 * Column Info
	 * @param wgtUtCd
	 */
    public void setWgtUtCd(String wgtUtCd) {
        this.wgtUtCd = wgtUtCd;
    }

    /**
	 * Column Info
	 * @param cntrTpszCd
	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
	 * Column Info
	 * @param cntrMfSeq
	 */
    public void setCntrMfSeq(String cntrMfSeq) {
        this.cntrMfSeq = cntrMfSeq;
    }

    /**
	 * Column Info
	 * @param pckQty
	 */
    public void setPckQty(String pckQty) {
        this.pckQty = pckQty;
    }

    /**
	 * Column Info
	 * @param cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    public void setCntrSealNo1(String cntrSealNo1) {
        this.cntrSealNo1 = cntrSealNo1;
    }

    public String getCntrSealNo1() {
        return this.cntrSealNo1;
    }

    public void setCntrSealNo2(String cntrSealNo2) {
        this.cntrSealNo2 = cntrSealNo2;
    }

    public String getCntrSealNo2() {
        return this.cntrSealNo2;
    }

    public void setCmdtHsCd(String cmdtHsCd) {
        this.cmdtHsCd = cmdtHsCd;
    }

    public String getCmdtHsCd() {
        return this.cmdtHsCd;
    }

    public void setHamoTrfCd(String hamoTrfCd) {
        this.hamoTrfCd = hamoTrfCd;
    }

    public String getHamoTrfCd() {
        return this.hamoTrfCd;
    }

    public void setNcmNo(String ncmNo) {
        this.ncmNo = ncmNo;
    }

    public String getNcmNo() {
        return this.ncmNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getPoNo() {
        return this.poNo;
    }

    public void setCntrSeq(String cntrSeq) {
        this.cntrSeq = cntrSeq;
    }

    public String getCntrSeq() {
        return this.cntrSeq;
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
        setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setCntrMfWgt(JSPUtil.getParameter(request, prefix + "cntr_mf_wgt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
        setMkDesc(JSPUtil.getParameter(request, prefix + "mk_desc", ""));
        setPrnFlg(JSPUtil.getParameter(request, prefix + "prn_flg", ""));
        setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setCntrMfSeq(JSPUtil.getParameter(request, prefix + "cntr_mf_seq", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setCntrSealNo1(JSPUtil.getParameter(request, prefix + "cntr_seal_no1", ""));
        setCntrSealNo2(JSPUtil.getParameter(request, prefix + "cntr_seal_no2", ""));
        setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
        setHamoTrfCd(JSPUtil.getParameter(request, prefix + "hamo_trf_cd", ""));
        setNcmNo(JSPUtil.getParameter(request, prefix + "ncm_no", ""));
        setPoNo(JSPUtil.getParameter(request, prefix + "po_no", ""));
        setCntrSeq(JSPUtil.getParameter(request, prefix + "cntr_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCntrShpVO[]
	 */
    public BkgCntrShpVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCntrShpVO[]
	 */
    public BkgCntrShpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgCntrShpVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] cntrVolQty = (JSPUtil.getParameter(request, prefix + "cntr_vol_qty", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix + "cntr_mf_wgt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] cmdtDesc = (JSPUtil.getParameter(request, prefix + "cmdt_desc", length));
            String[] mkDesc = (JSPUtil.getParameter(request, prefix + "mk_desc", length));
            String[] prnFlg = (JSPUtil.getParameter(request, prefix + "prn_flg", length));
            String[] measUtCd = (JSPUtil.getParameter(request, prefix + "meas_ut_cd", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix + "cntr_mf_seq", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] cntrSealNo1 = (JSPUtil.getParameter(request, prefix + "cntr_seal_no1", length));
            String[] cntrSealNo2 = (JSPUtil.getParameter(request, prefix + "cntr_seal_no2", length));
            String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", length));
            String[] hamoTrfCd = (JSPUtil.getParameter(request, prefix + "hamo_trf_cd", length));
            String[] ncmNo = (JSPUtil.getParameter(request, prefix + "ncm_no", length));
            String[] poNo = (JSPUtil.getParameter(request, prefix + "po_no", length));
            String[] cntrSeq = (JSPUtil.getParameter(request, prefix + "cntr_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgCntrShpVO();
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (cntrVolQty[i] != null)
                    model.setCntrVolQty(cntrVolQty[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
                if (cntrMfWgt[i] != null)
                    model.setCntrMfWgt(cntrMfWgt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (cmdtDesc[i] != null)
                    model.setCmdtDesc(cmdtDesc[i]);
                if (mkDesc[i] != null)
                    model.setMkDesc(mkDesc[i]);
                if (prnFlg[i] != null)
                    model.setPrnFlg(prnFlg[i]);
                if (measUtCd[i] != null)
                    model.setMeasUtCd(measUtCd[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (cntrMfSeq[i] != null)
                    model.setCntrMfSeq(cntrMfSeq[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (cntrSealNo1[i] != null)
                    model.setCntrSealNo1(cntrSealNo1[i]);
                if (cntrSealNo2[i] != null)
                    model.setCntrSealNo2(cntrSealNo2[i]);
                if (cmdtHsCd[i] != null)
                    model.setCmdtHsCd(cmdtHsCd[i]);
                if (hamoTrfCd[i] != null)
                    model.setHamoTrfCd(hamoTrfCd[i]);
                if (ncmNo[i] != null)
                    model.setNcmNo(ncmNo[i]);
                if (poNo[i] != null)
                    model.setPoNo(poNo[i]);
                if (cntrSeq[i] != null) 
		    		model.setCntrSeq(cntrSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgCntrShpVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgCntrShpVO[]
	 */
    public BkgCntrShpVO[] getBkgCntrShpVOs() {
        BkgCntrShpVO[] vos = (BkgCntrShpVO[]) models.toArray(new BkgCntrShpVO[models.size()]);
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
        this.cntrVolQty = this.cntrVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrMfWgt = this.cntrMfWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtDesc = this.cmdtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mkDesc = this.mkDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnFlg = this.prnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measUtCd = this.measUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrMfSeq = this.cntrMfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSealNo1 = this.cntrSealNo1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSealNo2 = this.cntrSealNo2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtHsCd = this.cmdtHsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hamoTrfCd = this.hamoTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ncmNo = this.ncmNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.poNo = this.poNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSeq = this.cntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
