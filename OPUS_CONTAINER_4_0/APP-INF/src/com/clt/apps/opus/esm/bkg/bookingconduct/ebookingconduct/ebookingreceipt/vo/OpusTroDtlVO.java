/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpusTroDtlVO.java
*@FileTitle : OpusTroDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.11.04 이남경 
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
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class OpusTroDtlVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<OpusTroDtlVO> models = new ArrayList<OpusTroDtlVO>();

    /* Column Info */
    private String troQty = null;

    /* Column Info */
    private String pkupYdCd = null;

    /* Column Info */
    private String rtnLocCd = null;

    /* Column Info */
    private String troSubSeq = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String dorArrDt = null;

    /* Column Info */
    private String troSeq = null;

    /* Column Info */
    private String cxlFlg = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String rtnYdCd = null;

    /* Column Info */
    private String pkupLocCd = null;

    /* Column Info */
    private String pkupDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String dorAddr = null;

    /* Column Info */
    private String cntcPsonNm = null;

    /* Column Info */
    private String cntcPhnNo = null;

    /* Column Info */
    private String cntcEml = null;

    /* Column Info */
    private String dorZipId = null;

    /* Column Info */
    private String xterTroSeq = null;

    /* Column Info */
    private String xterTroSubSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public OpusTroDtlVO() {
    }

    public OpusTroDtlVO(String ibflag, String pagerows, String troSeq, String troSubSeq, String cntrTpszCd, String troQty, String dorArrDt, String pkupLocCd, String pkupYdCd, String rtnLocCd, String rtnYdCd, String cxlFlg, String pkupDt, String dorAddr, String cntcPsonNm, String cntcPhnNo, String cntcEml, String dorZipId, String xterTroSeq, String xterTroSubSeq) {
        this.troQty = troQty;
        this.pkupYdCd = pkupYdCd;
        this.rtnLocCd = rtnLocCd;
        this.troSubSeq = troSubSeq;
        this.ibflag = ibflag;
        this.dorArrDt = dorArrDt;
        this.troSeq = troSeq;
        this.cxlFlg = cxlFlg;
        this.cntrTpszCd = cntrTpszCd;
        this.rtnYdCd = rtnYdCd;
        this.pkupLocCd = pkupLocCd;
        this.pagerows = pagerows;
        this.pkupDt = pkupDt;
        this.dorAddr = dorAddr;
        this.cntcPsonNm = cntcPsonNm;
        this.cntcPhnNo = cntcPhnNo;
        this.cntcEml = cntcEml;
        this.dorZipId = dorZipId;
        this.xterTroSeq = xterTroSeq;
        this.xterTroSubSeq = xterTroSubSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("tro_qty", getTroQty());
        this.hashColumns.put("pkup_yd_cd", getPkupYdCd());
        this.hashColumns.put("rtn_loc_cd", getRtnLocCd());
        this.hashColumns.put("tro_sub_seq", getTroSubSeq());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("dor_arr_dt", getDorArrDt());
        this.hashColumns.put("tro_seq", getTroSeq());
        this.hashColumns.put("cxl_flg", getCxlFlg());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("rtn_yd_cd", getRtnYdCd());
        this.hashColumns.put("pkup_loc_cd", getPkupLocCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pkup_dt", getPkupDt());
        this.hashColumns.put("dor_addr", getDorAddr());
        this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
        this.hashColumns.put("cntc_phn_no", getCntcPhnNo());
        this.hashColumns.put("cntc_eml", getCntcEml());
        this.hashColumns.put("dor_zip_id", getDorZipId());
        this.hashColumns.put("xter_tro_seq", getXterTroSeq());
        this.hashColumns.put("xter_tro_sub_seq", getXterTroSubSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("tro_qty", "troQty");
        this.hashFields.put("pkup_yd_cd", "pkupYdCd");
        this.hashFields.put("rtn_loc_cd", "rtnLocCd");
        this.hashFields.put("tro_sub_seq", "troSubSeq");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("dor_arr_dt", "dorArrDt");
        this.hashFields.put("tro_seq", "troSeq");
        this.hashFields.put("cxl_flg", "cxlFlg");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("rtn_yd_cd", "rtnYdCd");
        this.hashFields.put("pkup_loc_cd", "pkupLocCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pkup_dt", "pkupDt");
        this.hashFields.put("dor_addr", "dorAddr");
        this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
        this.hashFields.put("cntc_phn_no", "cntcPhnNo");
        this.hashFields.put("cntc_eml", "cntcEml");
        this.hashFields.put("dor_zip_id", "dorZipId");
        this.hashFields.put("xter_tro_seq", "xterTroSeq");
        this.hashFields.put("xter_tro_sub_seq", "xterTroSubSeq");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return troQty
	 */
    public String getTroQty() {
        return this.troQty;
    }

    /**
	 * Column Info
	 * @return pkupYdCd
	 */
    public String getPkupYdCd() {
        return this.pkupYdCd;
    }

    /**
	 * Column Info
	 * @return rtnLocCd
	 */
    public String getRtnLocCd() {
        return this.rtnLocCd;
    }

    /**
	 * Column Info
	 * @return troSubSeq
	 */
    public String getTroSubSeq() {
        return this.troSubSeq;
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
	 * @return dorArrDt
	 */
    public String getDorArrDt() {
        return this.dorArrDt;
    }

    /**
	 * Column Info
	 * @return troSeq
	 */
    public String getTroSeq() {
        return this.troSeq;
    }

    /**
	 * Column Info
	 * @return cxlFlg
	 */
    public String getCxlFlg() {
        return this.cxlFlg;
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
	 * @return rtnYdCd
	 */
    public String getRtnYdCd() {
        return this.rtnYdCd;
    }

    /**
	 * Column Info
	 * @return pkupLocCd
	 */
    public String getPkupLocCd() {
        return this.pkupLocCd;
    }

    /**
	 * Column Info
	 * @return pkupDt
	 */
    public String getPkupDt() {
        return this.pkupDt;
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
	 * @param troQty
	 */
    public void setTroQty(String troQty) {
        this.troQty = troQty;
    }

    /**
	 * Column Info
	 * @param pkupYdCd
	 */
    public void setPkupYdCd(String pkupYdCd) {
        this.pkupYdCd = pkupYdCd;
    }

    /**
	 * Column Info
	 * @param rtnLocCd
	 */
    public void setRtnLocCd(String rtnLocCd) {
        this.rtnLocCd = rtnLocCd;
    }

    /**
	 * Column Info
	 * @param troSubSeq
	 */
    public void setTroSubSeq(String troSubSeq) {
        this.troSubSeq = troSubSeq;
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
	 * @param dorArrDt
	 */
    public void setDorArrDt(String dorArrDt) {
        this.dorArrDt = dorArrDt;
    }

    /**
	 * Column Info
	 * @param troSeq
	 */
    public void setTroSeq(String troSeq) {
        this.troSeq = troSeq;
    }

    /**
	 * Column Info
	 * @param cxlFlg
	 */
    public void setCxlFlg(String cxlFlg) {
        this.cxlFlg = cxlFlg;
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
	 * @param rtnYdCd
	 */
    public void setRtnYdCd(String rtnYdCd) {
        this.rtnYdCd = rtnYdCd;
    }

    /**
	 * Column Info
	 * @param pkupLocCd
	 */
    public void setPkupLocCd(String pkupLocCd) {
        this.pkupLocCd = pkupLocCd;
    }

    /**
	 * Column Info
	 * @param pkupLocCd
	 */
    public void setPkupDt(String pkupDt) {
        this.pkupDt = pkupDt;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setDorAddr(String dorAddr) {
        this.dorAddr = dorAddr;
    }

    public String getDorAddr() {
        return this.dorAddr;
    }

    public void setCntcPsonNm(String cntcPsonNm) {
        this.cntcPsonNm = cntcPsonNm;
    }

    public String getCntcPsonNm() {
        return this.cntcPsonNm;
    }

    public void setCntcPhnNo(String cntcPhnNo) {
        this.cntcPhnNo = cntcPhnNo;
    }

    public String getCntcPhnNo() {
        return this.cntcPhnNo;
    }

    public void setCntcEml(String cntcEml) {
        this.cntcEml = cntcEml;
    }

    public String getCntcEml() {
        return this.cntcEml;
    }

    public void setDorZipId(String dorZipId) {
        this.dorZipId = dorZipId;
    }

    public String getDorZipId() {
        return this.dorZipId;
    }

    public void setXterTroSeq(String xterTroSeq) {
        this.xterTroSeq = xterTroSeq;
    }

    public String getXterTroSeq() {
        return this.xterTroSeq;
    }

    public void setXterTroSubSeq(String xterTroSubSeq) {
        this.xterTroSubSeq = xterTroSubSeq;
    }

    public String getXterTroSubSeq() {
        return this.xterTroSubSeq;
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
        setTroQty(JSPUtil.getParameter(request, prefix + "tro_qty", ""));
        setPkupYdCd(JSPUtil.getParameter(request, prefix + "pkup_yd_cd", ""));
        setRtnLocCd(JSPUtil.getParameter(request, prefix + "rtn_loc_cd", ""));
        setTroSubSeq(JSPUtil.getParameter(request, prefix + "tro_sub_seq", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setDorArrDt(JSPUtil.getParameter(request, prefix + "dor_arr_dt", ""));
        setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
        setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setRtnYdCd(JSPUtil.getParameter(request, prefix + "rtn_yd_cd", ""));
        setPkupLocCd(JSPUtil.getParameter(request, prefix + "pkup_loc_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPkupDt(JSPUtil.getParameter(request, prefix + "pkup_dt", ""));
        setDorAddr(JSPUtil.getParameter(request, prefix + "dor_addr", ""));
        setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
        setCntcPhnNo(JSPUtil.getParameter(request, prefix + "cntc_phn_no", ""));
        setCntcEml(JSPUtil.getParameter(request, prefix + "cntc_eml", ""));
        setDorZipId(JSPUtil.getParameter(request, prefix + "dor_zip_id", ""));
        setXterTroSeq(JSPUtil.getParameter(request, prefix + "xter_tro_seq", ""));
        setXterTroSubSeq(JSPUtil.getParameter(request, prefix + "xter_tro_sub_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpusTroDtlVO[]
	 */
    public OpusTroDtlVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpusTroDtlVO[]
	 */
    public OpusTroDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        OpusTroDtlVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] troQty = (JSPUtil.getParameter(request, prefix + "tro_qty", length));
            String[] pkupYdCd = (JSPUtil.getParameter(request, prefix + "pkup_yd_cd", length));
            String[] rtnLocCd = (JSPUtil.getParameter(request, prefix + "rtn_loc_cd", length));
            String[] troSubSeq = (JSPUtil.getParameter(request, prefix + "tro_sub_seq", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] dorArrDt = (JSPUtil.getParameter(request, prefix + "dor_arr_dt", length));
            String[] troSeq = (JSPUtil.getParameter(request, prefix + "tro_seq", length));
            String[] cxlFlg = (JSPUtil.getParameter(request, prefix + "cxl_flg", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] rtnYdCd = (JSPUtil.getParameter(request, prefix + "rtn_yd_cd", length));
            String[] pkupLocCd = (JSPUtil.getParameter(request, prefix + "pkup_loc_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] pkupDt = (JSPUtil.getParameter(request, prefix + "pkup_dt", length));
            String[] dorAddr = (JSPUtil.getParameter(request, prefix + "dor_addr", length));
            String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix + "cntc_pson_nm", length));
            String[] cntcPhnNo = (JSPUtil.getParameter(request, prefix + "cntc_phn_no", length));
            String[] cntcEml = (JSPUtil.getParameter(request, prefix + "cntc_eml", length));
            String[] dorZipId = (JSPUtil.getParameter(request, prefix + "dor_zip_id", length));
            String[] xterTroSeq = (JSPUtil.getParameter(request, prefix + "xter_tro_seq", length));
	    	String[] xterTroSubSeq = (JSPUtil.getParameter(request, prefix + "xter_tro_sub_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new OpusTroDtlVO();
                if (troQty[i] != null)
                    model.setTroQty(troQty[i]);
                if (pkupYdCd[i] != null)
                    model.setPkupYdCd(pkupYdCd[i]);
                if (rtnLocCd[i] != null)
                    model.setRtnLocCd(rtnLocCd[i]);
                if (troSubSeq[i] != null)
                    model.setTroSubSeq(troSubSeq[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (dorArrDt[i] != null)
                    model.setDorArrDt(dorArrDt[i]);
                if (troSeq[i] != null)
                    model.setTroSeq(troSeq[i]);
                if (cxlFlg[i] != null)
                    model.setCxlFlg(cxlFlg[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (rtnYdCd[i] != null)
                    model.setRtnYdCd(rtnYdCd[i]);
                if (pkupLocCd[i] != null)
                    model.setPkupLocCd(pkupLocCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (pkupDt[i] != null)
                    model.setPkupDt(pkupDt[i]);
                if (dorAddr[i] != null)
                    model.setDorAddr(dorAddr[i]);
                if (cntcPsonNm[i] != null)
                    model.setCntcPsonNm(cntcPsonNm[i]);
                if (cntcPhnNo[i] != null)
                    model.setCntcPhnNo(cntcPhnNo[i]);
                if (cntcEml[i] != null)
                    model.setCntcEml(cntcEml[i]);
                if (dorZipId[i] != null)
                    model.setDorZipId(dorZipId[i]);
                if (xterTroSeq[i] != null) 
		    		model.setXterTroSeq(xterTroSeq[i]);
				if (xterTroSubSeq[i] != null) 
		    		model.setXterTroSubSeq(xterTroSubSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getOpusTroDtlVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return OpusTroDtlVO[]
	 */
    public OpusTroDtlVO[] getOpusTroDtlVOs() {
        OpusTroDtlVO[] vos = (OpusTroDtlVO[]) models.toArray(new OpusTroDtlVO[models.size()]);
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
        this.troQty = this.troQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkupYdCd = this.pkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtnLocCd = this.rtnLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.troSubSeq = this.troSubSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dorArrDt = this.dorArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.troSeq = this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cxlFlg = this.cxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtnYdCd = this.rtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkupLocCd = this.pkupLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkupDt = this.pkupDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dorAddr = this.dorAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcPsonNm = this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcPhnNo = this.cntcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcEml = this.cntcEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dorZipId = this.dorZipId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterTroSeq = this.xterTroSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterTroSubSeq = this.xterTroSubSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
