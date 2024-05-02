/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RfaListInputVO.java
*@FileTitle : RfaListInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.22 김병규 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class RfaListInputVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<RfaListInputVO> models = new ArrayList<RfaListInputVO>();

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String tilCd = null;

    /* Column Info */
    private String sCustSeq = null;

    /* Column Info */
    private String sCustNm = null;

    /* Column Info */
    private String includeFlag = null;

    /* Column Info */
    private String svcScpCd = null;

    /* Column Info */
    private String cCustNm = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String sCustCntCd = null;

    /* Column Info */
    private String cCustSeq = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String bkgVvd = null;

    /* Column Info */
    private String cCustCntCd = null;

    /* Column Info */
    private String rfaNo = null;

    /* Column Info */
    private String bkgCtrlPtyCustCntCd = null;

    /* Column Info */
    private String bkgCtrlPtyCustSeq = null;

    /* Column Info */
    private String bkgCtrlPtyCustNm = null;

    /* Column Info */
    private String lodgDueDt = null;

    /* Column Info */
    private String bkgStsCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public RfaListInputVO() {
    }

    public RfaListInputVO(String ibflag, String pagerows, String bkgNo, String sCustCntCd, String sCustSeq, String sCustNm, String cCustCntCd, String cCustSeq, String cCustNm, String includeFlag, String porCd, String delCd, String svcScpCd, String tilCd, String bkgVvd, String rfaNo, String bkgCtrlPtyCustCntCd, String bkgCtrlPtyCustSeq, String bkgCtrlPtyCustNm, String lodgDueDt, String bkgStsCd) {
        this.porCd = porCd;
        this.tilCd = tilCd;
        this.sCustSeq = sCustSeq;
        this.sCustNm = sCustNm;
        this.includeFlag = includeFlag;
        this.svcScpCd = svcScpCd;
        this.cCustNm = cCustNm;
        this.delCd = delCd;
        this.sCustCntCd = sCustCntCd;
        this.cCustSeq = cCustSeq;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.bkgNo = bkgNo;
        this.bkgVvd = bkgVvd;
        this.cCustCntCd = cCustCntCd;
        this.rfaNo = rfaNo;
        this.bkgCtrlPtyCustCntCd = bkgCtrlPtyCustCntCd;
        this.bkgCtrlPtyCustSeq = bkgCtrlPtyCustSeq;
        this.bkgCtrlPtyCustNm = bkgCtrlPtyCustNm;
        this.lodgDueDt = lodgDueDt;
        this.bkgStsCd = bkgStsCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("til_cd", getTilCd());
        this.hashColumns.put("s_cust_seq", getSCustSeq());
        this.hashColumns.put("s_cust_nm", getSCustNm());
        this.hashColumns.put("include_flag", getIncludeFlag());
        this.hashColumns.put("svc_scp_cd", getSvcScpCd());
        this.hashColumns.put("c_cust_nm", getCCustNm());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
        this.hashColumns.put("c_cust_seq", getCCustSeq());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("bkg_vvd", getBkgVvd());
        this.hashColumns.put("c_cust_cnt_cd", getCCustCntCd());
        this.hashColumns.put("rfa_no", getRfaNo());
        this.hashColumns.put("bkg_ctrl_pty_cust_cnt_cd", getBkgCtrlPtyCustCntCd());
        this.hashColumns.put("bkg_ctrl_pty_cust_seq", getBkgCtrlPtyCustSeq());
        this.hashColumns.put("bkg_ctrl_pty_cust_nm", getBkgCtrlPtyCustNm());
        this.hashColumns.put("lodg_due_dt", getLodgDueDt());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("til_cd", "tilCd");
        this.hashFields.put("s_cust_seq", "sCustSeq");
        this.hashFields.put("s_cust_nm", "sCustNm");
        this.hashFields.put("include_flag", "includeFlag");
        this.hashFields.put("svc_scp_cd", "svcScpCd");
        this.hashFields.put("c_cust_nm", "cCustNm");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
        this.hashFields.put("c_cust_seq", "cCustSeq");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("bkg_vvd", "bkgVvd");
        this.hashFields.put("c_cust_cnt_cd", "cCustCntCd");
        this.hashFields.put("rfa_no", "rfaNo");
        this.hashFields.put("bkg_ctrl_pty_cust_cnt_cd", "bkgCtrlPtyCustCntCd");
        this.hashFields.put("bkg_ctrl_pty_cust_seq", "bkgCtrlPtyCustSeq");
        this.hashFields.put("bkg_ctrl_pty_cust_nm", "bkgCtrlPtyCustNm");
        this.hashFields.put("lodg_due_dt", "lodgDueDt");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
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
	 * @return tilCd
	 */
    public String getTilCd() {
        return this.tilCd;
    }

    /**
	 * Column Info
	 * @return sCustSeq
	 */
    public String getSCustSeq() {
        return this.sCustSeq;
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
	 * @return includeFlag
	 */
    public String getIncludeFlag() {
        return this.includeFlag;
    }

    /**
	 * Column Info
	 * @return svcScpCd
	 */
    public String getSvcScpCd() {
        return this.svcScpCd;
    }

    /**
	 * Column Info
	 * @return cCustNm
	 */
    public String getCCustNm() {
        return this.cCustNm;
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
	 * @return sCustCntCd
	 */
    public String getSCustCntCd() {
        return this.sCustCntCd;
    }

    /**
	 * Column Info
	 * @return cCustSeq
	 */
    public String getCCustSeq() {
        return this.cCustSeq;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
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
	 * @return bkgVvd
	 */
    public String getBkgVvd() {
        return this.bkgVvd;
    }

    /**
	 * Column Info
	 * @return cCustCntCd
	 */
    public String getCCustCntCd() {
        return this.cCustCntCd;
    }

    /**
	 * Column Info
	 * @return rfaNo
	 */
    public String getRfaNo() {
        return this.rfaNo;
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
	 * @return bkgCtrlPtyCustNm
	 */
    public String getBkgCtrlPtyCustNm() {
        return this.bkgCtrlPtyCustNm;
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
	 * @param tilCd
	 */
    public void setTilCd(String tilCd) {
        this.tilCd = tilCd;
    }

    /**
	 * Column Info
	 * @param sCustSeq
	 */
    public void setSCustSeq(String sCustSeq) {
        this.sCustSeq = sCustSeq;
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
	 * @param includeFlag
	 */
    public void setIncludeFlag(String includeFlag) {
        this.includeFlag = includeFlag;
    }

    /**
	 * Column Info
	 * @param svcScpCd
	 */
    public void setSvcScpCd(String svcScpCd) {
        this.svcScpCd = svcScpCd;
    }

    /**
	 * Column Info
	 * @param cCustNm
	 */
    public void setCCustNm(String cCustNm) {
        this.cCustNm = cCustNm;
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
	 * @param sCustCntCd
	 */
    public void setSCustCntCd(String sCustCntCd) {
        this.sCustCntCd = sCustCntCd;
    }

    /**
	 * Column Info
	 * @param cCustSeq
	 */
    public void setCCustSeq(String cCustSeq) {
        this.cCustSeq = cCustSeq;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
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
	 * @param bkgVvd
	 */
    public void setBkgVvd(String bkgVvd) {
        this.bkgVvd = bkgVvd;
    }

    /**
	 * Column Info
	 * @param cCustCntCd
	 */
    public void setCCustCntCd(String cCustCntCd) {
        this.cCustCntCd = cCustCntCd;
    }

    /**
	 * Column Info
	 * @param rfaNo
	 */
    public void setRfaNo(String rfaNo) {
        this.rfaNo = rfaNo;
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

    /**
	 * Column Info
	 * @param bkgCtrlPtyCustNm
	 */
    public void setBkgCtrlPtyCustNm(String bkgCtrlPtyCustNm) {
        this.bkgCtrlPtyCustNm = bkgCtrlPtyCustNm;
    }

    public void setLodgDueDt(String lodgDueDt) {
        this.lodgDueDt = lodgDueDt;
    }

    public String getLodgDueDt() {
        return this.lodgDueDt;
    }

    public void setBkgStsCd(String bkgStsCd) {
        this.bkgStsCd = bkgStsCd;
    }

    public String getBkgStsCd() {
        return this.bkgStsCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
        setTilCd(JSPUtil.getParameter(request, "til_cd", ""));
        setSCustSeq(JSPUtil.getParameter(request, "s_cust_seq", ""));
        setSCustNm(JSPUtil.getParameter(request, "s_cust_nm", ""));
        setIncludeFlag(JSPUtil.getParameter(request, "include_flag", ""));
        setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
        setCCustNm(JSPUtil.getParameter(request, "c_cust_nm", ""));
        setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
        setSCustCntCd(JSPUtil.getParameter(request, "s_cust_cnt_cd", ""));
        setCCustSeq(JSPUtil.getParameter(request, "c_cust_seq", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
        setBkgVvd(JSPUtil.getParameter(request, "bkg_vvd", ""));
        setCCustCntCd(JSPUtil.getParameter(request, "c_cust_cnt_cd", ""));
        setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
        setBkgCtrlPtyCustCntCd(JSPUtil.getParameter(request, "bkg_ctrl_pty_cust_cnt_cd", ""));
        setBkgCtrlPtyCustSeq(JSPUtil.getParameter(request, "bkg_ctrl_pty_cust_seq", ""));
        setBkgCtrlPtyCustNm(JSPUtil.getParameter(request, "bkg_ctrl_pty_cust_nm", ""));
        setLodgDueDt(JSPUtil.getParameter(request, "lodg_due_dt", ""));
        setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RfaListInputVO[]
	 */
    public RfaListInputVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RfaListInputVO[]
	 */
    public RfaListInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        RfaListInputVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] tilCd = (JSPUtil.getParameter(request, prefix + "til_cd", length));
            String[] sCustSeq = (JSPUtil.getParameter(request, prefix + "s_cust_seq", length));
            String[] sCustNm = (JSPUtil.getParameter(request, prefix + "s_cust_nm", length));
            String[] includeFlag = (JSPUtil.getParameter(request, prefix + "include_flag", length));
            String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
            String[] cCustNm = (JSPUtil.getParameter(request, prefix + "c_cust_nm", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] sCustCntCd = (JSPUtil.getParameter(request, prefix + "s_cust_cnt_cd", length));
            String[] cCustSeq = (JSPUtil.getParameter(request, prefix + "c_cust_seq", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] bkgVvd = (JSPUtil.getParameter(request, prefix + "bkg_vvd", length));
            String[] cCustCntCd = (JSPUtil.getParameter(request, prefix + "c_cust_cnt_cd", length));
            String[] rfaNo = (JSPUtil.getParameter(request, prefix + "rfa_no", length));
            String[] bkgCtrlPtyCustCntCd = (JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_cnt_cd", length));
            String[] bkgCtrlPtyCustSeq = (JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_seq", length));
            String[] bkgCtrlPtyCustNm = (JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_nm", length));
            String[] lodgDueDt = (JSPUtil.getParameter(request, prefix + "lodg_due_dt", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new RfaListInputVO();
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (tilCd[i] != null)
                    model.setTilCd(tilCd[i]);
                if (sCustSeq[i] != null)
                    model.setSCustSeq(sCustSeq[i]);
                if (sCustNm[i] != null)
                    model.setSCustNm(sCustNm[i]);
                if (includeFlag[i] != null)
                    model.setIncludeFlag(includeFlag[i]);
                if (svcScpCd[i] != null)
                    model.setSvcScpCd(svcScpCd[i]);
                if (cCustNm[i] != null)
                    model.setCCustNm(cCustNm[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (sCustCntCd[i] != null)
                    model.setSCustCntCd(sCustCntCd[i]);
                if (cCustSeq[i] != null)
                    model.setCCustSeq(cCustSeq[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (bkgVvd[i] != null)
                    model.setBkgVvd(bkgVvd[i]);
                if (cCustCntCd[i] != null)
                    model.setCCustCntCd(cCustCntCd[i]);
                if (rfaNo[i] != null)
                    model.setRfaNo(rfaNo[i]);
                if (bkgCtrlPtyCustCntCd[i] != null)
                    model.setBkgCtrlPtyCustCntCd(bkgCtrlPtyCustCntCd[i]);
                if (bkgCtrlPtyCustSeq[i] != null)
                    model.setBkgCtrlPtyCustSeq(bkgCtrlPtyCustSeq[i]);
                if (bkgCtrlPtyCustNm[i] != null)
                    model.setBkgCtrlPtyCustNm(bkgCtrlPtyCustNm[i]);
                if (lodgDueDt[i] != null)
                    model.setLodgDueDt(lodgDueDt[i]);
                if (bkgStsCd[i] != null) 
		    		model.setBkgStsCd(bkgStsCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getRfaListInputVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return RfaListInputVO[]
	 */
    public RfaListInputVO[] getRfaListInputVOs() {
        RfaListInputVO[] vos = (RfaListInputVO[]) models.toArray(new RfaListInputVO[models.size()]);
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
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tilCd = this.tilCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCustSeq = this.sCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCustNm = this.sCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.includeFlag = this.includeFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cCustNm = this.cCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCustCntCd = this.sCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cCustSeq = this.cCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgVvd = this.bkgVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cCustCntCd = this.cCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCtrlPtyCustCntCd = this.bkgCtrlPtyCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCtrlPtyCustSeq = this.bkgCtrlPtyCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCtrlPtyCustNm = this.bkgCtrlPtyCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lodgDueDt = this.lodgDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
