/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCstmsChnCustVO.java
*@FileTitle : BkgCstmsChnCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.02  
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgCstmsChnCustVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgCstmsChnCustVO> models = new ArrayList<BkgCstmsChnCustVO>();

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String custAddr = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String bkgCustTpCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String chnMfSndIndCd = null;

    /* Column Info */
    private String rgstNo = null;

    /* Column Info */
    private String custPhnNo = null;

    /* Column Info */
    private String custFaxNo = null;

    /* Column Info */
    private String custEml = null;

    /* Column Info */
    private String chnCstmsStNm = null;

    /* Column Info */
    private String coChnTpCd = null;

    /* Column Info */
    private String custCnt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgCstmsChnCustVO() {
    }

    public BkgCstmsChnCustVO(String ibflag, String pagerows, String chnMfSndIndCd, String blNo, String bkgCustTpCd, String cntCd, String custSeq, String custNm, String custAddr, String creUsrId, String creDt, String updUsrId, String updDt, String rgstNo, String custPhnNo, String custFaxNo, String custEml, String chnCstmsStNm, String coChnTpCd, String custCnt) {
        this.updDt = updDt;
        this.custNm = custNm;
        this.creDt = creDt;
        this.custAddr = custAddr;
        this.custSeq = custSeq;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.creUsrId = creUsrId;
        this.cntCd = cntCd;
        this.bkgCustTpCd = bkgCustTpCd;
        this.updUsrId = updUsrId;
        this.chnMfSndIndCd = chnMfSndIndCd;
        this.rgstNo = rgstNo;
        this.custPhnNo = custPhnNo;
        this.custFaxNo = custFaxNo;
        this.custEml = custEml;
        this.chnCstmsStNm = chnCstmsStNm;
        this.coChnTpCd = coChnTpCd;
        this.custCnt = custCnt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("cust_addr", getCustAddr());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("chn_mf_snd_ind_cd", getChnMfSndIndCd());
        this.hashColumns.put("rgst_no", getRgstNo());
        this.hashColumns.put("cust_phn_no", getCustPhnNo());
        this.hashColumns.put("cust_fax_no", getCustFaxNo());
        this.hashColumns.put("cust_eml", getCustEml());
        this.hashColumns.put("chn_cstms_st_nm", getChnCstmsStNm());
        this.hashColumns.put("co_chn_tp_cd", getCoChnTpCd());
        this.hashColumns.put("cust_cnt", getCustCnt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("cust_addr", "custAddr");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("chn_mf_snd_ind_cd", "chnMfSndIndCd");
        this.hashFields.put("rgst_no", "rgstNo");
        this.hashFields.put("cust_phn_no", "custPhnNo");
        this.hashFields.put("cust_fax_no", "custFaxNo");
        this.hashFields.put("cust_eml", "custEml");
        this.hashFields.put("chn_cstms_st_nm", "chnCstmsStNm");
        this.hashFields.put("co_chn_tp_cd", "coChnTpCd");
        this.hashFields.put("cust_cnt", "custCnt");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
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
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Column Info
	 * @return custAddr
	 */
    public String getCustAddr() {
        return this.custAddr;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return cntCd
	 */
    public String getCntCd() {
        return this.cntCd;
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
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 * Column Info
	 * @return chnMfSndIndCd
	 */
    public String getChnMfSndIndCd() {
        return this.chnMfSndIndCd;
    }

    /**
	 * Column Info
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
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
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param custAddr
	 */
    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param cntCd
	 */
    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
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
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param chnMfSndIndCd
	 */
    public void setChnMfSndIndCd(String chnMfSndIndCd) {
        this.chnMfSndIndCd = chnMfSndIndCd;
    }

    public void setRgstNo(String rgstNo) {
        this.rgstNo = rgstNo;
    }

    public String getRgstNo() {
        return this.rgstNo;
    }

    public void setCustPhnNo(String custPhnNo) {
        this.custPhnNo = custPhnNo;
    }

    public String getCustPhnNo() {
        return this.custPhnNo;
    }

    public void setCustFaxNo(String custFaxNo) {
        this.custFaxNo = custFaxNo;
    }

    public String getCustFaxNo() {
        return this.custFaxNo;
    }

    public void setCustEml(String custEml) {
        this.custEml = custEml;
    }

    public String getCustEml() {
        return this.custEml;
    }

    public void setChnCstmsStNm(String chnCstmsStNm) {
        this.chnCstmsStNm = chnCstmsStNm;
    }

    public String getChnCstmsStNm() {
        return this.chnCstmsStNm;
    }

    public void setCoChnTpCd(String coChnTpCd) {
        this.coChnTpCd = coChnTpCd;
    }

    public String getCoChnTpCd() {
        return this.coChnTpCd;
    }

    public void setCustCnt(String custCnt) {
        this.custCnt = custCnt;
    }

    public String getCustCnt() {
        return this.custCnt;
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
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setChnMfSndIndCd(JSPUtil.getParameter(request, prefix + "chn_mf_snd_ind_cd", ""));
        setRgstNo(JSPUtil.getParameter(request, prefix + "rgst_no", ""));
        setCustPhnNo(JSPUtil.getParameter(request, prefix + "cust_phn_no", ""));
        setCustFaxNo(JSPUtil.getParameter(request, prefix + "cust_fax_no", ""));
        setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
        setChnCstmsStNm(JSPUtil.getParameter(request, prefix + "chn_cstms_st_nm", ""));
        setCoChnTpCd(JSPUtil.getParameter(request, prefix + "co_chn_tp_cd", ""));
        setCustCnt(JSPUtil.getParameter(request, prefix + "cust_cnt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsChnCustVO[]
	 */
    public BkgCstmsChnCustVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsChnCustVO[]
	 */
    public BkgCstmsChnCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgCstmsChnCustVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] custAddr = (JSPUtil.getParameter(request, prefix + "cust_addr", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] chnMfSndIndCd = (JSPUtil.getParameter(request, prefix + "chn_mf_snd_ind_cd", length));
            String[] rgstNo = (JSPUtil.getParameter(request, prefix + "rgst_no", length));
            String[] custPhnNo = (JSPUtil.getParameter(request, prefix + "cust_phn_no", length));
            String[] custFaxNo = (JSPUtil.getParameter(request, prefix + "cust_fax_no", length));
            String[] custEml = (JSPUtil.getParameter(request, prefix + "cust_eml", length));
            String[] chnCstmsStNm = (JSPUtil.getParameter(request, prefix + "chn_cstms_st_nm", length));
            String[] coChnTpCd = (JSPUtil.getParameter(request, prefix + "co_chn_tp_cd", length));
            String[] custCnt = (JSPUtil.getParameter(request, prefix + "cust_cnt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgCstmsChnCustVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (custAddr[i] != null)
                    model.setCustAddr(custAddr[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (bkgCustTpCd[i] != null)
                    model.setBkgCustTpCd(bkgCustTpCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (chnMfSndIndCd[i] != null)
                    model.setChnMfSndIndCd(chnMfSndIndCd[i]);
                if (rgstNo[i] != null)
                    model.setRgstNo(rgstNo[i]);
                if (custPhnNo[i] != null)
                    model.setCustPhnNo(custPhnNo[i]);
                if (custFaxNo[i] != null)
                    model.setCustFaxNo(custFaxNo[i]);
                if (custEml[i] != null)
                    model.setCustEml(custEml[i]);
                if (chnCstmsStNm[i] != null)
                    model.setChnCstmsStNm(chnCstmsStNm[i]);
                if (coChnTpCd[i] != null)
                    model.setCoChnTpCd(coChnTpCd[i]);
                if (custCnt[i] != null) 
		    		model.setCustCnt(custCnt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgCstmsChnCustVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgCstmsChnCustVO[]
	 */
    public BkgCstmsChnCustVO[] getBkgCstmsChnCustVOs() {
        BkgCstmsChnCustVO[] vos = (BkgCstmsChnCustVO[]) models.toArray(new BkgCstmsChnCustVO[models.size()]);
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
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAddr = this.custAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCustTpCd = this.bkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chnMfSndIndCd = this.chnMfSndIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstNo = this.rgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custPhnNo = this.custPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custFaxNo = this.custFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custEml = this.custEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chnCstmsStNm = this.chnCstmsStNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.coChnTpCd = this.coChnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCnt = this.custCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
