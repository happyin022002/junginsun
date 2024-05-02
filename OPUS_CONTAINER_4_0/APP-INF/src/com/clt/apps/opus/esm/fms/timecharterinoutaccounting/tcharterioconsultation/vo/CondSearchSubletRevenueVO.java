/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondSearchSebletRevenueVO.java
*@FileTitle : CondSearchSebletRevenueVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.24 최우석 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CondSearchSubletRevenueVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CondSearchSubletRevenueVO> models = new ArrayList<CondSearchSubletRevenueVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String toInvNo = null;

    /* Column Info */
    private String fletCtrtNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String debitAcctCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CondSearchSubletRevenueVO() {
    }

    public CondSearchSubletRevenueVO(String ibflag, String pagerows, String fletCtrtNo, String vvdCd, String toInvNo, String debitAcctCd) {
        this.ibflag = ibflag;
        this.vvdCd = vvdCd;
        this.toInvNo = toInvNo;
        this.fletCtrtNo = fletCtrtNo;
        this.pagerows = pagerows;
        this.debitAcctCd = debitAcctCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("to_inv_no", getToInvNo());
        this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("debit_acct_cd", getDebitAcctCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("to_inv_no", "toInvNo");
        this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("debit_acct_cd", "debitAcctCd");
        return this.hashFields;
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
	 * @return vvdCd
	 */
    public String getVvdCd() {
        return this.vvdCd;
    }

    /**
	 * Column Info
	 * @return toInvNo
	 */
    public String getToInvNo() {
        return this.toInvNo;
    }

    /**
	 * Column Info
	 * @return fletCtrtNo
	 */
    public String getFletCtrtNo() {
        return this.fletCtrtNo;
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
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param vvdCd
	 */
    public void setVvdCd(String vvdCd) {
        this.vvdCd = vvdCd;
    }

    /**
	 * Column Info
	 * @param toInvNo
	 */
    public void setToInvNo(String toInvNo) {
        this.toInvNo = toInvNo;
    }

    /**
	 * Column Info
	 * @param fletCtrtNo
	 */
    public void setFletCtrtNo(String fletCtrtNo) {
        this.fletCtrtNo = fletCtrtNo;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setDebitAcctCd(String debitAcctCd) {
        this.debitAcctCd = debitAcctCd;
    }

    public String getDebitAcctCd() {
        return this.debitAcctCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
        setToInvNo(JSPUtil.getParameter(request, "to_inv_no", ""));
        setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setDebitAcctCd(JSPUtil.getParameter(request, "debit_acct_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondSearchSebletRevenueVO[]
	 */
    public CondSearchSubletRevenueVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondSearchSebletRevenueVO[]
	 */
    public CondSearchSubletRevenueVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CondSearchSubletRevenueVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] toInvNo = (JSPUtil.getParameter(request, prefix + "to_inv_no", length));
            String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix + "flet_ctrt_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] debitAcctCd = (JSPUtil.getParameter(request, prefix + "debit_acct_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CondSearchSubletRevenueVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (toInvNo[i] != null)
                    model.setToInvNo(toInvNo[i]);
                if (fletCtrtNo[i] != null)
                    model.setFletCtrtNo(fletCtrtNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (debitAcctCd[i] != null) 
		    		model.setDebitAcctCd(debitAcctCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCondSearchSebletRevenueVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CondSearchSebletRevenueVO[]
	 */
    public CondSearchSubletRevenueVO[] getCondSearchSebletRevenueVOs() {
        CondSearchSubletRevenueVO[] vos = (CondSearchSubletRevenueVO[]) models.toArray(new CondSearchSubletRevenueVO[models.size()]);
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
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toInvNo = this.toInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletCtrtNo = this.fletCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.debitAcctCd = this.debitAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
