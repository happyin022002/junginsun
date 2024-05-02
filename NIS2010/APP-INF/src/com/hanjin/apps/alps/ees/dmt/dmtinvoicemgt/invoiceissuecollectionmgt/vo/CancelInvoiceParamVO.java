/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CancelInvoiceParamVO.java
*@FileTitle : CancelInvoiceParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.15 김태균 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CancelInvoiceParamVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CancelInvoiceParamVO> models = new ArrayList<CancelInvoiceParamVO>();

    /* Column Info */
    private String cxlRmk = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String dmdtCxlRsnCd = null;

    /* Column Info */
    private String intgCdValDpDesc = null;

    /* Column Info */
    private String creOfcCd = null;

    /* Column Info */
    private String dmdtInvNo = null;

    /* Column Info */
    private String intgCdValCtnt = null;

    /* Column Info */
    private String dmdtTrfCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String suthChnIssFlg = null;

    /* Column Info */
    private String crInvNo = null;

    /* Column Info */
    private String arIfIoBndCd = null;

    /* Column Info */
    private String autoArIfYn = null;

    /* Column Info */
    private String idaTaxApplTm = null;

    /* Column Info */
    private String creCntCd = null;

    /* Column Info */
    private String invTpCd = null;

    /* Column Info */
    private String aftBkgCxlYn = null;

    /* Column Info */
    private String aftExptDarNo = null;

    /* Column Info */
    private String updOfcCd = null;

    /* Column Info */
    private String updUsrId = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CancelInvoiceParamVO() {
    }

    public CancelInvoiceParamVO(String ibflag, String pagerows, String dmdtInvNo, String creOfcCd, String dmdtTrfCd, String dmdtCxlRsnCd, String cxlRmk, String intgCdValCtnt, String intgCdValDpDesc, String suthChnIssFlg, String crInvNo, String arIfIoBndCd, String autoArIfYn, String idaTaxApplTm, String creCntCd, String invTpCd, String aftBkgCxlYn, String aftExptDarNo, String updOfcCd, String updUsrId) {
        this.cxlRmk = cxlRmk;
        this.ibflag = ibflag;
        this.dmdtCxlRsnCd = dmdtCxlRsnCd;
        this.intgCdValDpDesc = intgCdValDpDesc;
        this.creOfcCd = creOfcCd;
        this.dmdtInvNo = dmdtInvNo;
        this.intgCdValCtnt = intgCdValCtnt;
        this.dmdtTrfCd = dmdtTrfCd;
        this.pagerows = pagerows;
        this.suthChnIssFlg = suthChnIssFlg;
        this.crInvNo = crInvNo;
        this.arIfIoBndCd = arIfIoBndCd;
        this.autoArIfYn = autoArIfYn;
        this.idaTaxApplTm = idaTaxApplTm;
        this.creCntCd = creCntCd;
        this.invTpCd = invTpCd;
        this.aftBkgCxlYn = aftBkgCxlYn;
        this.aftExptDarNo = aftExptDarNo;
        this.updOfcCd = updOfcCd;
        this.updUsrId = updUsrId;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("cxl_rmk", getCxlRmk());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("dmdt_cxl_rsn_cd", getDmdtCxlRsnCd());
        this.hashColumns.put("intg_cd_val_dp_desc", getIntgCdValDpDesc());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
        this.hashColumns.put("intg_cd_val_ctnt", getIntgCdValCtnt());
        this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("suth_chn_iss_flg", getSuthChnIssFlg());
        this.hashColumns.put("cr_inv_no", getCrInvNo());
        this.hashColumns.put("ar_if_io_bnd_cd", getArIfIoBndCd());
        this.hashColumns.put("auto_ar_if_yn", getAutoArIfYn());
        this.hashColumns.put("ida_tax_appl_tm", getIdaTaxApplTm());
        this.hashColumns.put("cre_cnt_cd", getCreCntCd());
        this.hashColumns.put("inv_tp_cd", getInvTpCd());
        this.hashColumns.put("aft_bkg_cxl_yn", getAftBkgCxlYn());
        this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
        this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("cxl_rmk", "cxlRmk");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("dmdt_cxl_rsn_cd", "dmdtCxlRsnCd");
        this.hashFields.put("intg_cd_val_dp_desc", "intgCdValDpDesc");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
        this.hashFields.put("intg_cd_val_ctnt", "intgCdValCtnt");
        this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("suth_chn_iss_flg", "suthChnIssFlg");
        this.hashFields.put("cr_inv_no", "crInvNo");
        this.hashFields.put("ar_if_io_bnd_cd", "arIfIoBndCd");
        this.hashFields.put("auto_ar_if_yn", "autoArIfYn");
        this.hashFields.put("ida_tax_appl_tm", "idaTaxApplTm");
        this.hashFields.put("cre_cnt_cd", "creCntCd");
        this.hashFields.put("inv_tp_cd", "invTpCd");
        this.hashFields.put("aft_bkg_cxl_yn", "aftBkgCxlYn");
        this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
        this.hashFields.put("upd_ofc_cd", "updOfcCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return cxlRmk
	 */
    public String getCxlRmk() {
        return this.cxlRmk;
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
	 * @return dmdtCxlRsnCd
	 */
    public String getDmdtCxlRsnCd() {
        return this.dmdtCxlRsnCd;
    }

    /**
	 * Column Info
	 * @return intgCdValDpDesc
	 */
    public String getIntgCdValDpDesc() {
        return this.intgCdValDpDesc;
    }

    /**
	 * Column Info
	 * @return creOfcCd
	 */
    public String getCreOfcCd() {
        return this.creOfcCd;
    }

    /**
	 * Column Info
	 * @return dmdtInvNo
	 */
    public String getDmdtInvNo() {
        return this.dmdtInvNo;
    }

    /**
	 * Column Info
	 * @return intgCdValCtnt
	 */
    public String getIntgCdValCtnt() {
        return this.intgCdValCtnt;
    }

    /**
	 * Column Info
	 * @return dmdtTrfCd
	 */
    public String getDmdtTrfCd() {
        return this.dmdtTrfCd;
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
	 * @return suthChnIssFlg
	 */
    public String getSuthChnIssFlg() {
        return this.suthChnIssFlg;
    }

    /**
	 * Column Info
	 * @return crInvNo
	 */
    public String getCrInvNo() {
        return this.crInvNo;
    }

    /**
	 * Column Info
	 * @return arIfIoBndCd
	 */
    public String getArIfIoBndCd() {
        return this.arIfIoBndCd;
    }

    /**
	 * Column Info
	 * @return autoArIfYn
	 */
    public String getAutoArIfYn() {
        return this.autoArIfYn;
    }

    /**
	 * Column Info
	 * @param cxlRmk
	 */
    public void setCxlRmk(String cxlRmk) {
        this.cxlRmk = cxlRmk;
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
	 * @param dmdtCxlRsnCd
	 */
    public void setDmdtCxlRsnCd(String dmdtCxlRsnCd) {
        this.dmdtCxlRsnCd = dmdtCxlRsnCd;
    }

    /**
	 * Column Info
	 * @param intgCdValDpDesc
	 */
    public void setIntgCdValDpDesc(String intgCdValDpDesc) {
        this.intgCdValDpDesc = intgCdValDpDesc;
    }

    /**
	 * Column Info
	 * @param creOfcCd
	 */
    public void setCreOfcCd(String creOfcCd) {
        this.creOfcCd = creOfcCd;
    }

    /**
	 * Column Info
	 * @param dmdtInvNo
	 */
    public void setDmdtInvNo(String dmdtInvNo) {
        this.dmdtInvNo = dmdtInvNo;
    }

    /**
	 * Column Info
	 * @param intgCdValCtnt
	 */
    public void setIntgCdValCtnt(String intgCdValCtnt) {
        this.intgCdValCtnt = intgCdValCtnt;
    }

    /**
	 * Column Info
	 * @param dmdtTrfCd
	 */
    public void setDmdtTrfCd(String dmdtTrfCd) {
        this.dmdtTrfCd = dmdtTrfCd;
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
	 * @param suthChnIssFlg
	 */
    public void setSuthChnIssFlg(String suthChnIssFlg) {
        this.suthChnIssFlg = suthChnIssFlg;
    }

    /**
	 * Column Info
	 * @param crInvNo
	 */
    public void setCrInvNo(String crInvNo) {
        this.crInvNo = crInvNo;
    }

    /**
	 * Column Info
	 * @param arIfIoBndCd
	 */
    public void setArIfIoBndCd(String arIfIoBndCd) {
        this.arIfIoBndCd = arIfIoBndCd;
    }

    /**
	 * Column Info
	 * @param autoArIfYn
	 */
    public void setAutoArIfYn(String autoArIfYn) {
        this.autoArIfYn = autoArIfYn;
    }

    public void setIdaTaxApplTm(String idaTaxApplTm) {
        this.idaTaxApplTm = idaTaxApplTm;
    }

    public String getIdaTaxApplTm() {
        return this.idaTaxApplTm;
    }

    public void setCreCntCd(String creCntCd) {
        this.creCntCd = creCntCd;
    }

    public String getCreCntCd() {
        return this.creCntCd;
    }

    public void setInvTpCd(String invTpCd) {
        this.invTpCd = invTpCd;
    }

    public String getInvTpCd() {
        return this.invTpCd;
    }

    public void setAftBkgCxlYn(String aftBkgCxlYn) {
        this.aftBkgCxlYn = aftBkgCxlYn;
    }

    public String getAftBkgCxlYn() {
        return this.aftBkgCxlYn;
    }

    public void setAftExptDarNo(String aftExptDarNo) {
        this.aftExptDarNo = aftExptDarNo;
    }

    public String getAftExptDarNo() {
        return this.aftExptDarNo;
    }

    public void setUpdOfcCd(String updOfcCd) {
        this.updOfcCd = updOfcCd;
    }

    public String getUpdOfcCd() {
        return this.updOfcCd;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setCxlRmk(JSPUtil.getParameter(request, "cxl_rmk", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setDmdtCxlRsnCd(JSPUtil.getParameter(request, "dmdt_cxl_rsn_cd", ""));
        setIntgCdValDpDesc(JSPUtil.getParameter(request, "intg_cd_val_dp_desc", ""));
        setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
        setDmdtInvNo(JSPUtil.getParameter(request, "dmdt_inv_no", ""));
        setIntgCdValCtnt(JSPUtil.getParameter(request, "intg_cd_val_ctnt", ""));
        setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setSuthChnIssFlg(JSPUtil.getParameter(request, "suth_chn_iss_flg", ""));
        setCrInvNo(JSPUtil.getParameter(request, "cr_inv_no", ""));
        setArIfIoBndCd(JSPUtil.getParameter(request, "ar_if_io_bnd_cd", ""));
        setAutoArIfYn(JSPUtil.getParameter(request, "auto_ar_if_yn", ""));
        setIdaTaxApplTm(JSPUtil.getParameter(request, "ida_tax_appl_tm", ""));
        setCreCntCd(JSPUtil.getParameter(request, "cre_cnt_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CancelInvoiceParamVO[]
	 */
    public CancelInvoiceParamVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CancelInvoiceParamVO[]
	 */
    public CancelInvoiceParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CancelInvoiceParamVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] cxlRmk = (JSPUtil.getParameter(request, prefix + "cxl_rmk", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] dmdtCxlRsnCd = (JSPUtil.getParameter(request, prefix + "dmdt_cxl_rsn_cd", length));
            String[] intgCdValDpDesc = (JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_desc", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix + "dmdt_inv_no", length));
            String[] intgCdValCtnt = (JSPUtil.getParameter(request, prefix + "intg_cd_val_ctnt", length));
            String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] suthChnIssFlg = (JSPUtil.getParameter(request, prefix + "suth_chn_iss_flg", length));
            String[] crInvNo = (JSPUtil.getParameter(request, prefix + "cr_inv_no", length));
            String[] arIfIoBndCd = (JSPUtil.getParameter(request, prefix + "ar_if_io_bnd_cd", length));
            String[] autoArIfYn = (JSPUtil.getParameter(request, prefix + "auto_ar_if_yn", length));
            String[] idaTaxApplTm = (JSPUtil.getParameter(request, prefix + "ida_tax_appl_tm", length));
            String[] creCntCd = (JSPUtil.getParameter(request, prefix + "cre_cnt_cd", length));
            String[] invTpCd = (JSPUtil.getParameter(request, prefix + "inv_tp_cd", length));
            String[] aftBkgCxlYn = (JSPUtil.getParameter(request, prefix + "aft_bkg_cxl_yn", length));
            String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", length));
            String[] updOfcCd = (JSPUtil.getParameter(request, prefix + "upd_ofc_cd", length));
	    	String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CancelInvoiceParamVO();
                if (cxlRmk[i] != null)
                    model.setCxlRmk(cxlRmk[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (dmdtCxlRsnCd[i] != null)
                    model.setDmdtCxlRsnCd(dmdtCxlRsnCd[i]);
                if (intgCdValDpDesc[i] != null)
                    model.setIntgCdValDpDesc(intgCdValDpDesc[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (dmdtInvNo[i] != null)
                    model.setDmdtInvNo(dmdtInvNo[i]);
                if (intgCdValCtnt[i] != null)
                    model.setIntgCdValCtnt(intgCdValCtnt[i]);
                if (dmdtTrfCd[i] != null)
                    model.setDmdtTrfCd(dmdtTrfCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (suthChnIssFlg[i] != null)
                    model.setSuthChnIssFlg(suthChnIssFlg[i]);
                if (crInvNo[i] != null)
                    model.setCrInvNo(crInvNo[i]);
                if (arIfIoBndCd[i] != null)
                    model.setArIfIoBndCd(arIfIoBndCd[i]);
                if (autoArIfYn[i] != null)
                    model.setAutoArIfYn(autoArIfYn[i]);
                if (idaTaxApplTm[i] != null)
                    model.setIdaTaxApplTm(idaTaxApplTm[i]);
                if (creCntCd[i] != null)
                    model.setCreCntCd(creCntCd[i]);
                if (invTpCd[i] != null)
                    model.setInvTpCd(invTpCd[i]);
                if (aftBkgCxlYn[i] != null)
                    model.setAftBkgCxlYn(aftBkgCxlYn[i]);
                if (aftExptDarNo[i] != null)
                    model.setAftExptDarNo(aftExptDarNo[i]);
                if (updOfcCd[i] != null) 
		    		model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null) 
		    		model.setUpdUsrId(updUsrId[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCancelInvoiceParamVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CancelInvoiceParamVO[]
	 */
    public CancelInvoiceParamVO[] getCancelInvoiceParamVOs() {
        CancelInvoiceParamVO[] vos = (CancelInvoiceParamVO[]) models.toArray(new CancelInvoiceParamVO[models.size()]);
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
        this.cxlRmk = this.cxlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtCxlRsnCd = this.dmdtCxlRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intgCdValDpDesc = this.intgCdValDpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvNo = this.dmdtInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intgCdValCtnt = this.intgCdValCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtTrfCd = this.dmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.suthChnIssFlg = this.suthChnIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crInvNo = this.crInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfIoBndCd = this.arIfIoBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoArIfYn = this.autoArIfYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaTaxApplTm = this.idaTaxApplTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creCntCd = this.creCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invTpCd = this.invTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftBkgCxlYn = this.aftBkgCxlYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftExptDarNo = this.aftExptDarNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updOfcCd = this.updOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
