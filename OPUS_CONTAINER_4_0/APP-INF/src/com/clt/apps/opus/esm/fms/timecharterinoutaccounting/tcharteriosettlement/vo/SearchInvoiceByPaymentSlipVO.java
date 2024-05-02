/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchInvoiceByPaymentSlipVO.java
*@FileTitle : SearchInvoiceByPaymentSlipVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.22 윤세영 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchInvoiceByPaymentSlipVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchInvoiceByPaymentSlipVO> models = new ArrayList<SearchInvoiceByPaymentSlipVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String fletCtrtTpCd = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String vndrLglEngNm = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String fletCtrtTpNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchInvoiceByPaymentSlipVO() {
    }

    public SearchInvoiceByPaymentSlipVO(String ibflag, String pagerows, String fletCtrtTpCd, String vndrSeq, String vndrLglEngNm, String fletCtrtTpNm) {
        this.ibflag = ibflag;
        this.fletCtrtTpCd = fletCtrtTpCd;
        this.vndrSeq = vndrSeq;
        this.vndrLglEngNm = vndrLglEngNm;
        this.pagerows = pagerows;
        this.fletCtrtTpNm = fletCtrtTpNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("flet_ctrt_tp_nm", getFletCtrtTpNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("flet_ctrt_tp_nm", "fletCtrtTpNm");
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
	 * @return fletCtrtTpCd
	 */
    public String getFletCtrtTpCd() {
        return this.fletCtrtTpCd;
    }

    /**
	 * Column Info
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 * Column Info
	 * @return vndrLglEngNm
	 */
    public String getVndrLglEngNm() {
        return this.vndrLglEngNm;
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
	 * @param fletCtrtTpCd
	 */
    public void setFletCtrtTpCd(String fletCtrtTpCd) {
        this.fletCtrtTpCd = fletCtrtTpCd;
    }

    /**
	 * Column Info
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * Column Info
	 * @param vndrLglEngNm
	 */
    public void setVndrLglEngNm(String vndrLglEngNm) {
        this.vndrLglEngNm = vndrLglEngNm;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setFletCtrtTpNm(String fletCtrtTpNm) {
        this.fletCtrtTpNm = fletCtrtTpNm;
    }

    public String getFletCtrtTpNm() {
        return this.fletCtrtTpNm;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setFletCtrtTpCd(JSPUtil.getParameter(request, "flet_ctrt_tp_cd", ""));
        setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
        setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInvoiceByPaymentSlipVO[]
	 */
    public SearchInvoiceByPaymentSlipVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInvoiceByPaymentSlipVO[]
	 */
    public SearchInvoiceByPaymentSlipVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchInvoiceByPaymentSlipVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] fletCtrtTpNm = (JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchInvoiceByPaymentSlipVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (fletCtrtTpCd[i] != null)
                    model.setFletCtrtTpCd(fletCtrtTpCd[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (vndrLglEngNm[i] != null)
                    model.setVndrLglEngNm(vndrLglEngNm[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (fletCtrtTpNm[i] != null) 
		    		model.setFletCtrtTpNm(fletCtrtTpNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchInvoiceByPaymentSlipVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchInvoiceByPaymentSlipVO[]
	 */
    public SearchInvoiceByPaymentSlipVO[] getSearchInvoiceByPaymentSlipVOs() {
        SearchInvoiceByPaymentSlipVO[] vos = (SearchInvoiceByPaymentSlipVO[]) models.toArray(new SearchInvoiceByPaymentSlipVO[models.size()]);
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
        this.fletCtrtTpCd = this.fletCtrtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrLglEngNm = this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletCtrtTpNm = this.fletCtrtTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
