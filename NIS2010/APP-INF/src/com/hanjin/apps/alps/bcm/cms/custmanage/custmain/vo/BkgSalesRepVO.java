/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : BkgSalesRepVO.java
*@FileTitle : BkgSalesRepVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.17
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.07.17 김태경 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgSalesRepVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgSalesRepVO> models = new ArrayList<BkgSalesRepVO>();

    /* Column Info */
    private String dpSeq = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String srepCustClssCd = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String opCd = null;

    /* Column Info */
    private String userId = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String srepCd = null;

    /* Column Info */
    private String custCntCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String prmyChkFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgSalesRepVO() {
    }

    public BkgSalesRepVO(String ibflag, String pagerows, String srepCd, String custCntCd, String custSeq, String deltFlg, String dpSeq, String srepCustClssCd, String userId, String opCd, String prmyChkFlg) {
        this.dpSeq = dpSeq;
        this.ibflag = ibflag;
        this.srepCustClssCd = srepCustClssCd;
        this.deltFlg = deltFlg;
        this.opCd = opCd;
        this.userId = userId;
        this.custSeq = custSeq;
        this.srepCd = srepCd;
        this.custCntCd = custCntCd;
        this.pagerows = pagerows;
        this.prmyChkFlg = prmyChkFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("dp_seq", getDpSeq());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("srep_cust_clss_cd", getSrepCustClssCd());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("op_cd", getOpCd());
        this.hashColumns.put("user_id", getUserId());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("prmy_chk_flg", getPrmyChkFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("dp_seq", "dpSeq");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("srep_cust_clss_cd", "srepCustClssCd");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("op_cd", "opCd");
        this.hashFields.put("user_id", "userId");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("prmy_chk_flg", "prmyChkFlg");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return dpSeq
	 */
    public String getDpSeq() {
        return this.dpSeq;
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
	 * @return srepCustClssCd
	 */
    public String getSrepCustClssCd() {
        return this.srepCustClssCd;
    }

    /**
	 * Column Info
	 * @return deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
    }

    /**
	 * Column Info
	 * @return opCd
	 */
    public String getOpCd() {
        return this.opCd;
    }

    /**
	 * Column Info
	 * @return userId
	 */
    public String getUserId() {
        return this.userId;
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
	 * @return srepCd
	 */
    public String getSrepCd() {
        return this.srepCd;
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
	 * @param dpSeq
	 */
    public void setDpSeq(String dpSeq) {
        this.dpSeq = dpSeq;
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
	 * @param srepCustClssCd
	 */
    public void setSrepCustClssCd(String srepCustClssCd) {
        this.srepCustClssCd = srepCustClssCd;
    }

    /**
	 * Column Info
	 * @param deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * Column Info
	 * @param opCd
	 */
    public void setOpCd(String opCd) {
        this.opCd = opCd;
    }

    /**
	 * Column Info
	 * @param userId
	 */
    public void setUserId(String userId) {
        this.userId = userId;
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
	 * @param srepCd
	 */
    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
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

    public void setPrmyChkFlg(String prmyChkFlg) {
        this.prmyChkFlg = prmyChkFlg;
    }

    public String getPrmyChkFlg() {
        return this.prmyChkFlg;
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
        setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setSrepCustClssCd(JSPUtil.getParameter(request, prefix + "srep_cust_clss_cd", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setOpCd(JSPUtil.getParameter(request, prefix + "op_cd", ""));
        setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPrmyChkFlg(JSPUtil.getParameter(request, prefix + "prmy_chk_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgSalesRepVO[]
	 */
    public BkgSalesRepVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgSalesRepVO[]
	 */
    public BkgSalesRepVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgSalesRepVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] dpSeq = (JSPUtil.getParameter(request, prefix + "dp_seq", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] srepCustClssCd = (JSPUtil.getParameter(request, prefix + "srep_cust_clss_cd", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] opCd = (JSPUtil.getParameter(request, prefix + "op_cd", length));
            String[] userId = (JSPUtil.getParameter(request, prefix + "user_id", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] prmyChkFlg = (JSPUtil.getParameter(request, prefix + "prmy_chk_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgSalesRepVO();
                if (dpSeq[i] != null)
                    model.setDpSeq(dpSeq[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (srepCustClssCd[i] != null)
                    model.setSrepCustClssCd(srepCustClssCd[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (opCd[i] != null)
                    model.setOpCd(opCd[i]);
                if (userId[i] != null)
                    model.setUserId(userId[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (prmyChkFlg[i] != null) 
		    		model.setPrmyChkFlg(prmyChkFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgSalesRepVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgSalesRepVO[]
	 */
    public BkgSalesRepVO[] getBkgSalesRepVOs() {
        BkgSalesRepVO[] vos = (BkgSalesRepVO[]) models.toArray(new BkgSalesRepVO[models.size()]);
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
        this.dpSeq = this.dpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCustClssCd = this.srepCustClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opCd = this.opCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.userId = this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prmyChkFlg = this.prmyChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
