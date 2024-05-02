/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSlipApprovalOwnerVO.java
*@FileTitle : SearchSlipApprovalOwnerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.08.19 윤세영 
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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchSlipApprovalOwnerVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchSlipApprovalOwnerVO> models = new ArrayList<SearchSlipApprovalOwnerVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String genPayTermCd = null;

    /* Column Info */
    private String cdCnt = null;

    /* Column Info */
    private String cdName = null;

    /* Column Info */
    private String cdSeq = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String payMzdCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchSlipApprovalOwnerVO() {
    }

    public SearchSlipApprovalOwnerVO(String ibflag, String pagerows, String cdSeq, String cdName, String cdCnt, String genPayTermCd, String payMzdCd) {
        this.ibflag = ibflag;
        this.genPayTermCd = genPayTermCd;
        this.cdCnt = cdCnt;
        this.cdName = cdName;
        this.cdSeq = cdSeq;
        this.pagerows = pagerows;
        this.payMzdCd = payMzdCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("gen_pay_term_cd", getGenPayTermCd());
        this.hashColumns.put("cd_cnt", getCdCnt());
        this.hashColumns.put("cd_name", getCdName());
        this.hashColumns.put("cd_seq", getCdSeq());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pay_mzd_cd", getPayMzdCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("gen_pay_term_cd", "genPayTermCd");
        this.hashFields.put("cd_cnt", "cdCnt");
        this.hashFields.put("cd_name", "cdName");
        this.hashFields.put("cd_seq", "cdSeq");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pay_mzd_cd", "payMzdCd");
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
	 * @return genPayTermCd
	 */
    public String getGenPayTermCd() {
        return this.genPayTermCd;
    }

    /**
	 * Column Info
	 * @return cdCnt
	 */
    public String getCdCnt() {
        return this.cdCnt;
    }

    /**
	 * Column Info
	 * @return cdName
	 */
    public String getCdName() {
        return this.cdName;
    }

    /**
	 * Column Info
	 * @return cdSeq
	 */
    public String getCdSeq() {
        return this.cdSeq;
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
	 * @param genPayTermCd
	 */
    public void setGenPayTermCd(String genPayTermCd) {
        this.genPayTermCd = genPayTermCd;
    }

    /**
	 * Column Info
	 * @param cdCnt
	 */
    public void setCdCnt(String cdCnt) {
        this.cdCnt = cdCnt;
    }

    /**
	 * Column Info
	 * @param cdName
	 */
    public void setCdName(String cdName) {
        this.cdName = cdName;
    }

    /**
	 * Column Info
	 * @param cdSeq
	 */
    public void setCdSeq(String cdSeq) {
        this.cdSeq = cdSeq;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setPayMzdCd(String payMzdCd) {
        this.payMzdCd = payMzdCd;
    }

    public String getPayMzdCd() {
        return this.payMzdCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setGenPayTermCd(JSPUtil.getParameter(request, "gen_pay_term_cd", ""));
        setCdCnt(JSPUtil.getParameter(request, "cd_cnt", ""));
        setCdName(JSPUtil.getParameter(request, "cd_name", ""));
        setCdSeq(JSPUtil.getParameter(request, "cd_seq", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setPayMzdCd(JSPUtil.getParameter(request, "pay_mzd_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSlipApprovalOwnerVO[]
	 */
    public SearchSlipApprovalOwnerVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSlipApprovalOwnerVO[]
	 */
    public SearchSlipApprovalOwnerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchSlipApprovalOwnerVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] genPayTermCd = (JSPUtil.getParameter(request, prefix + "gen_pay_term_cd", length));
            String[] cdCnt = (JSPUtil.getParameter(request, prefix + "cd_cnt", length));
            String[] cdName = (JSPUtil.getParameter(request, prefix + "cd_name", length));
            String[] cdSeq = (JSPUtil.getParameter(request, prefix + "cd_seq", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] payMzdCd = (JSPUtil.getParameter(request, prefix + "pay_mzd_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchSlipApprovalOwnerVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (genPayTermCd[i] != null)
                    model.setGenPayTermCd(genPayTermCd[i]);
                if (cdCnt[i] != null)
                    model.setCdCnt(cdCnt[i]);
                if (cdName[i] != null)
                    model.setCdName(cdName[i]);
                if (cdSeq[i] != null)
                    model.setCdSeq(cdSeq[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (payMzdCd[i] != null) 
		    		model.setPayMzdCd(payMzdCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchSlipApprovalOwnerVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchSlipApprovalOwnerVO[]
	 */
    public SearchSlipApprovalOwnerVO[] getSearchSlipApprovalOwnerVOs() {
        SearchSlipApprovalOwnerVO[] vos = (SearchSlipApprovalOwnerVO[]) models.toArray(new SearchSlipApprovalOwnerVO[models.size()]);
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
        this.genPayTermCd = this.genPayTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cdCnt = this.cdCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cdName = this.cdName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cdSeq = this.cdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payMzdCd = this.payMzdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
