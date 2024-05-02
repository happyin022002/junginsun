/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SearchRollOverInformationVO.java
*@FileTitle : SearchRollOverInformationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.06  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class SearchRollOverInformationVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchRollOverInformationVO> models = new ArrayList<SearchRollOverInformationVO>();

    /* Column Info */
    private String bkgOfcCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String rhqCd = null;

    /* Column Info */
    private String bkgToDt = null;

    /* Column Info */
    private String bkgFromDt = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String custCntCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String evntDt = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String preVvd = null;

    /* Column Info */
    private String newVvd = null;

    /* Column Info */
    private String rhqOfc = null;

    /* Column Info */
    private String rollOvrRsnCd = null;

    /* Column Info */
    private String ctrtCd = null;

    /* Column Info */
    private String ctrtNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public SearchRollOverInformationVO() {
    }

    public SearchRollOverInformationVO(String ibflag, String pagerows, String blNo, String bkgFromDt, String bkgToDt, String rhqCd, String bkgOfcCd, String custCntCd, String custSeq, String custNm, String evntDt, String custCd, String preVvd, String newVvd, String rhqOfc, String rollOvrRsnCd, String ctrtCd, String ctrtNo) {
        this.bkgOfcCd = bkgOfcCd;
        this.ibflag = ibflag;
        this.rhqCd = rhqCd;
        this.bkgToDt = bkgToDt;
        this.bkgFromDt = bkgFromDt;
        this.custSeq = custSeq;
        this.blNo = blNo;
        this.custCntCd = custCntCd;
        this.pagerows = pagerows;
        this.custNm = custNm;
        this.evntDt = evntDt;
        this.custCd = custCd;
        this.preVvd = preVvd;
        this.newVvd = newVvd;
        this.rhqOfc = rhqOfc;
        this.rollOvrRsnCd = rollOvrRsnCd;
        this.ctrtCd = ctrtCd;
        this.ctrtNo = ctrtNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("rhq_cd", getRhqCd());
        this.hashColumns.put("bkg_to_dt", getBkgToDt());
        this.hashColumns.put("bkg_from_dt", getBkgFromDt());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("evnt_dt", getEvntDt());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("pre_vvd", getPreVvd());
        this.hashColumns.put("new_vvd", getNewVvd());
        this.hashColumns.put("rhq_ofc", getRhqOfc());
        this.hashColumns.put("roll_ovr_rsn_cd", getRollOvrRsnCd());
        this.hashColumns.put("ctrt_cd", getCtrtCd());
        this.hashColumns.put("ctrt_no", getCtrtNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("rhq_cd", "rhqCd");
        this.hashFields.put("bkg_to_dt", "bkgToDt");
        this.hashFields.put("bkg_from_dt", "bkgFromDt");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("evnt_dt", "evntDt");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("pre_vvd", "preVvd");
        this.hashFields.put("new_vvd", "newVvd");
        this.hashFields.put("rhq_ofc", "rhqOfc");
        this.hashFields.put("roll_ovr_rsn_cd", "rollOvrRsnCd");
        this.hashFields.put("ctrt_cd", "ctrtCd");
        this.hashFields.put("ctrt_no", "ctrtNo");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return rhqCd
	 */
    public String getRhqCd() {
        return this.rhqCd;
    }

    /**
	 * Column Info
	 * @return bkgToDt
	 */
    public String getBkgToDt() {
        return this.bkgToDt;
    }

    /**
	 * Column Info
	 * @return bkgFromDt
	 */
    public String getBkgFromDt() {
        return this.bkgFromDt;
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
	 * Column Info
	 * @return custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
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
	 * @param bkgOfcCd
	 */
    public void setBkgOfcCd(String bkgOfcCd) {
        this.bkgOfcCd = bkgOfcCd;
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
	 * @param rhqCd
	 */
    public void setRhqCd(String rhqCd) {
        this.rhqCd = rhqCd;
    }

    /**
	 * Column Info
	 * @param bkgToDt
	 */
    public void setBkgToDt(String bkgToDt) {
        this.bkgToDt = bkgToDt;
    }

    /**
	 * Column Info
	 * @param bkgFromDt
	 */
    public void setBkgFromDt(String bkgFromDt) {
        this.bkgFromDt = bkgFromDt;
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
	 * Column Info
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    public String getCustNm() {
        return this.custNm;
    }

    public void setEvntDt(String evntDt) {
        this.evntDt = evntDt;
    }

    public String getEvntDt() {
        return this.evntDt;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    public String getCustCd() {
        return this.custCd;
    }

    public void setPreVvd(String preVvd) {
        this.preVvd = preVvd;
    }

    public String getPreVvd() {
        return this.preVvd;
    }

    public void setNewVvd(String newVvd) {
        this.newVvd = newVvd;
    }

    public String getNewVvd() {
        return this.newVvd;
    }

    public void setRhqOfc(String rhqOfc) {
        this.rhqOfc = rhqOfc;
    }

    public String getRhqOfc() {
        return this.rhqOfc;
    }

    public void setRollOvrRsnCd(String rollOvrRsnCd) {
        this.rollOvrRsnCd = rollOvrRsnCd;
    }

    public String getRollOvrRsnCd() {
        return this.rollOvrRsnCd;
    }

    public void setCtrtCd(String ctrtCd) {
        this.ctrtCd = ctrtCd;
    }

    public String getCtrtCd() {
        return this.ctrtCd;
    }

    public void setCtrtNo(String ctrtNo) {
        this.ctrtNo = ctrtNo;
    }

    public String getCtrtNo() {
        return this.ctrtNo;
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
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
        setBkgToDt(JSPUtil.getParameter(request, prefix + "bkg_to_dt", ""));
        setBkgFromDt(JSPUtil.getParameter(request, prefix + "bkg_from_dt", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
        setNewVvd(JSPUtil.getParameter(request, prefix + "new_vvd", ""));
        setRhqOfc(JSPUtil.getParameter(request, prefix + "rhq_ofc", ""));
        setRollOvrRsnCd(JSPUtil.getParameter(request, prefix + "roll_ovr_rsn_cd", ""));
        setCtrtCd(JSPUtil.getParameter(request, prefix + "ctrt_cd", ""));
        setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRollOverInformationVO[]
	 */
    public SearchRollOverInformationVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRollOverInformationVO[]
	 */
    public SearchRollOverInformationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchRollOverInformationVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] rhqCd = (JSPUtil.getParameter(request, prefix + "rhq_cd", length));
            String[] bkgToDt = (JSPUtil.getParameter(request, prefix + "bkg_to_dt", length));
            String[] bkgFromDt = (JSPUtil.getParameter(request, prefix + "bkg_from_dt", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] evntDt = (JSPUtil.getParameter(request, prefix + "evnt_dt", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] preVvd = (JSPUtil.getParameter(request, prefix + "pre_vvd", length));
            String[] newVvd = (JSPUtil.getParameter(request, prefix + "new_vvd", length));
            String[] rhqOfc = (JSPUtil.getParameter(request, prefix + "rhq_ofc", length));
            String[] rollOvrRsnCd = (JSPUtil.getParameter(request, prefix + "roll_ovr_rsn_cd", length));
            String[] ctrtCd = (JSPUtil.getParameter(request, prefix + "ctrt_cd", length));
            String[] ctrtNo = (JSPUtil.getParameter(request, prefix + "ctrt_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchRollOverInformationVO();
                if (bkgOfcCd[i] != null)
                    model.setBkgOfcCd(bkgOfcCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (rhqCd[i] != null)
                    model.setRhqCd(rhqCd[i]);
                if (bkgToDt[i] != null)
                    model.setBkgToDt(bkgToDt[i]);
                if (bkgFromDt[i] != null)
                    model.setBkgFromDt(bkgFromDt[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (evntDt[i] != null)
                    model.setEvntDt(evntDt[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (preVvd[i] != null)
                    model.setPreVvd(preVvd[i]);
                if (newVvd[i] != null)
                    model.setNewVvd(newVvd[i]);
                if (rhqOfc[i] != null)
                    model.setRhqOfc(rhqOfc[i]);
                if (rollOvrRsnCd[i] != null)
                    model.setRollOvrRsnCd(rollOvrRsnCd[i]);
                if (ctrtCd[i] != null)
                    model.setCtrtCd(ctrtCd[i]);
                if (ctrtNo[i] != null) 
		    		model.setCtrtNo(ctrtNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchRollOverInformationVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchRollOverInformationVO[]
	 */
    public SearchRollOverInformationVO[] getSearchRollOverInformationVOs() {
        SearchRollOverInformationVO[] vos = (SearchRollOverInformationVO[]) models.toArray(new SearchRollOverInformationVO[models.size()]);
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
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqCd = this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgToDt = this.bkgToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgFromDt = this.bkgFromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.evntDt = this.evntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preVvd = this.preVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newVvd = this.newVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqOfc = this.rhqOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rollOvrRsnCd = this.rollOvrRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtCd = this.ctrtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtNo = this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
