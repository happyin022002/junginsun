/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSebletRevenueListVO.java
*@FileTitle : SearchSebletRevenueListVO
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
public class SearchSubletRevenueListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchSubletRevenueListVO> models = new ArrayList<SearchSubletRevenueListVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String csrDesc = null;

    /* Column Info */
    private String csrCurrCd = null;

    /* Column Info */
    private String csrAmt = null;

    /* Column Info */
    private String toInvNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String csrNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchSubletRevenueListVO() {
    }

    public SearchSubletRevenueListVO(String ibflag, String pagerows, String toInvNo, String vvdCd, String csrCurrCd, String csrAmt, String csrDesc, String csrNo) {
        this.ibflag = ibflag;
        this.vvdCd = vvdCd;
        this.csrDesc = csrDesc;
        this.csrCurrCd = csrCurrCd;
        this.csrAmt = csrAmt;
        this.toInvNo = toInvNo;
        this.pagerows = pagerows;
        this.csrNo = csrNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("csr_desc", getCsrDesc());
        this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
        this.hashColumns.put("csr_amt", getCsrAmt());
        this.hashColumns.put("to_inv_no", getToInvNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("csr_no", getCsrNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("csr_desc", "csrDesc");
        this.hashFields.put("csr_curr_cd", "csrCurrCd");
        this.hashFields.put("csr_amt", "csrAmt");
        this.hashFields.put("to_inv_no", "toInvNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("csr_no", "csrNo");
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
	 * @return csrDesc
	 */
    public String getCsrDesc() {
        return this.csrDesc;
    }

    /**
	 * Column Info
	 * @return csrCurrCd
	 */
    public String getCsrCurrCd() {
        return this.csrCurrCd;
    }

    /**
	 * Column Info
	 * @return csrAmt
	 */
    public String getCsrAmt() {
        return this.csrAmt;
    }

    /**
	 * Column Info
	 * @return toInvNo
	 */
    public String getToInvNo() {
        return this.toInvNo;
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
	 * @param csrDesc
	 */
    public void setCsrDesc(String csrDesc) {
        this.csrDesc = csrDesc;
    }

    /**
	 * Column Info
	 * @param csrCurrCd
	 */
    public void setCsrCurrCd(String csrCurrCd) {
        this.csrCurrCd = csrCurrCd;
    }

    /**
	 * Column Info
	 * @param csrAmt
	 */
    public void setCsrAmt(String csrAmt) {
        this.csrAmt = csrAmt;
    }

    /**
	 * Column Info
	 * @param toInvNo
	 */
    public void setToInvNo(String toInvNo) {
        this.toInvNo = toInvNo;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setCsrNo(String csrNo) {
        this.csrNo = csrNo;
    }

    public String getCsrNo() {
        return this.csrNo;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
        setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
        setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
        setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
        setToInvNo(JSPUtil.getParameter(request, "to_inv_no", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSebletRevenueListVO[]
	 */
    public SearchSubletRevenueListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSebletRevenueListVO[]
	 */
    public SearchSubletRevenueListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchSubletRevenueListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] csrDesc = (JSPUtil.getParameter(request, prefix + "csr_desc", length));
            String[] csrCurrCd = (JSPUtil.getParameter(request, prefix + "csr_curr_cd", length));
            String[] csrAmt = (JSPUtil.getParameter(request, prefix + "csr_amt", length));
            String[] toInvNo = (JSPUtil.getParameter(request, prefix + "to_inv_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchSubletRevenueListVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (csrDesc[i] != null)
                    model.setCsrDesc(csrDesc[i]);
                if (csrCurrCd[i] != null)
                    model.setCsrCurrCd(csrCurrCd[i]);
                if (csrAmt[i] != null)
                    model.setCsrAmt(csrAmt[i]);
                if (toInvNo[i] != null)
                    model.setToInvNo(toInvNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (csrNo[i] != null) 
		    		model.setCsrNo(csrNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchSebletRevenueListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchSebletRevenueListVO[]
	 */
    public SearchSubletRevenueListVO[] getSearchSebletRevenueListVOs() {
        SearchSubletRevenueListVO[] vos = (SearchSubletRevenueListVO[]) models.toArray(new SearchSubletRevenueListVO[models.size()]);
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
        this.csrDesc = this.csrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrCurrCd = this.csrCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrAmt = this.csrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toInvNo = this.toInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
