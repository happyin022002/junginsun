/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondSearchSlipApprovalVO.java
*@FileTitle : CondSearchSlipApprovalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.08.21 윤세영 
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
public class CondSearchSlipApprovalVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CondSearchSlipApprovalVO> models = new ArrayList<CondSearchSlipApprovalVO>();

    /* Column Info */
    private String fromCreDt = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String csrNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String toEffDt = null;

    /* Column Info */
    private String vatSlpTpCd = null;

    /* Column Info */
    private String fromEffDt = null;

    /* Column Info */
    private String slipAproFlg = null;

    /* Column Info */
    private String toCreDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String fletCtrtNo = null;

    /* Column Info */
    private String csrType = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CondSearchSlipApprovalVO() {
    }

    public CondSearchSlipApprovalVO(String ibflag, String pagerows, String fromCreDt, String csrNo, String vslCd, String toEffDt, String fromEffDt, String toCreDt, String slipAproFlg, String vatSlpTpCd, String fletCtrtNo, String csrType) {
        this.fromCreDt = fromCreDt;
        this.vslCd = vslCd;
        this.csrNo = csrNo;
        this.ibflag = ibflag;
        this.toEffDt = toEffDt;
        this.vatSlpTpCd = vatSlpTpCd;
        this.fromEffDt = fromEffDt;
        this.slipAproFlg = slipAproFlg;
        this.toCreDt = toCreDt;
        this.pagerows = pagerows;
        this.fletCtrtNo = fletCtrtNo;
        this.csrType = csrType;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("from_cre_dt", getFromCreDt());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("to_eff_dt", getToEffDt());
        this.hashColumns.put("vat_slp_tp_cd", getVatSlpTpCd());
        this.hashColumns.put("from_eff_dt", getFromEffDt());
        this.hashColumns.put("slip_apro_flg", getSlipAproFlg());
        this.hashColumns.put("to_cre_dt", getToCreDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
        this.hashColumns.put("csr_type", getCsrType());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("from_cre_dt", "fromCreDt");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("to_eff_dt", "toEffDt");
        this.hashFields.put("vat_slp_tp_cd", "vatSlpTpCd");
        this.hashFields.put("from_eff_dt", "fromEffDt");
        this.hashFields.put("slip_apro_flg", "slipAproFlg");
        this.hashFields.put("to_cre_dt", "toCreDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
        this.hashFields.put("csr_type", "csrType");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return fromCreDt
	 */
    public String getFromCreDt() {
        return this.fromCreDt;
    }

    /**
	 * Column Info
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 * Column Info
	 * @return csrNo
	 */
    public String getCsrNo() {
        return this.csrNo;
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
	 * @return toEffDt
	 */
    public String getToEffDt() {
        return this.toEffDt;
    }

    /**
	 * Column Info
	 * @return vatSlpTpCd
	 */
    public String getVatSlpTpCd() {
        return this.vatSlpTpCd;
    }

    /**
	 * Column Info
	 * @return fromEffDt
	 */
    public String getFromEffDt() {
        return this.fromEffDt;
    }

    /**
	 * Column Info
	 * @return slipAproFlg
	 */
    public String getSlipAproFlg() {
        return this.slipAproFlg;
    }

    /**
	 * Column Info
	 * @return toCreDt
	 */
    public String getToCreDt() {
        return this.toCreDt;
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
	 * @param fromCreDt
	 */
    public void setFromCreDt(String fromCreDt) {
        this.fromCreDt = fromCreDt;
    }

    /**
	 * Column Info
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param csrNo
	 */
    public void setCsrNo(String csrNo) {
        this.csrNo = csrNo;
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
	 * @param toEffDt
	 */
    public void setToEffDt(String toEffDt) {
        this.toEffDt = toEffDt;
    }

    /**
	 * Column Info
	 * @param vatSlpTpCd
	 */
    public void setVatSlpTpCd(String vatSlpTpCd) {
        this.vatSlpTpCd = vatSlpTpCd;
    }

    /**
	 * Column Info
	 * @param fromEffDt
	 */
    public void setFromEffDt(String fromEffDt) {
        this.fromEffDt = fromEffDt;
    }

    /**
	 * Column Info
	 * @param slipAproFlg
	 */
    public void setSlipAproFlg(String slipAproFlg) {
        this.slipAproFlg = slipAproFlg;
    }

    /**
	 * Column Info
	 * @param toCreDt
	 */
    public void setToCreDt(String toCreDt) {
        this.toCreDt = toCreDt;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setFletCtrtNo(String fletCtrtNo) {
        this.fletCtrtNo = fletCtrtNo;
    }

    public String getFletCtrtNo() {
        return this.fletCtrtNo;
    }

    public void setCsrType(String csrType) {
        this.csrType = csrType;
    }

    public String getCsrType() {
        return this.csrType;
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
        setFromCreDt(JSPUtil.getParameter(request, prefix + "from_cre_dt", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
        setVatSlpTpCd(JSPUtil.getParameter(request, prefix + "vat_slp_tp_cd", ""));
        setFromEffDt(JSPUtil.getParameter(request, prefix + "from_eff_dt", ""));
        setSlipAproFlg(JSPUtil.getParameter(request, prefix + "slip_apro_flg", ""));
        setToCreDt(JSPUtil.getParameter(request, prefix + "to_cre_dt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setFletCtrtNo(JSPUtil.getParameter(request, prefix + "flet_ctrt_no", ""));
        setCsrType(JSPUtil.getParameter(request, prefix + "csr_type", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondSearchSlipApprovalVO[]
	 */
    public CondSearchSlipApprovalVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondSearchSlipApprovalVO[]
	 */
    public CondSearchSlipApprovalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CondSearchSlipApprovalVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] fromCreDt = (JSPUtil.getParameter(request, prefix + "from_cre_dt", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] toEffDt = (JSPUtil.getParameter(request, prefix + "to_eff_dt", length));
            String[] vatSlpTpCd = (JSPUtil.getParameter(request, prefix + "vat_slp_tp_cd", length));
            String[] fromEffDt = (JSPUtil.getParameter(request, prefix + "from_eff_dt", length));
            String[] slipAproFlg = (JSPUtil.getParameter(request, prefix + "slip_apro_flg", length));
            String[] toCreDt = (JSPUtil.getParameter(request, prefix + "to_cre_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix + "flet_ctrt_no", length));
            String[] csrType = (JSPUtil.getParameter(request, prefix + "csr_type", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CondSearchSlipApprovalVO();
                if (fromCreDt[i] != null)
                    model.setFromCreDt(fromCreDt[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (toEffDt[i] != null)
                    model.setToEffDt(toEffDt[i]);
                if (vatSlpTpCd[i] != null)
                    model.setVatSlpTpCd(vatSlpTpCd[i]);
                if (fromEffDt[i] != null)
                    model.setFromEffDt(fromEffDt[i]);
                if (slipAproFlg[i] != null)
                    model.setSlipAproFlg(slipAproFlg[i]);
                if (toCreDt[i] != null)
                    model.setToCreDt(toCreDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (fletCtrtNo[i] != null)
                    model.setFletCtrtNo(fletCtrtNo[i]);
                if (csrType[i] != null) 
		    		model.setCsrType(csrType[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCondSearchSlipApprovalVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CondSearchSlipApprovalVO[]
	 */
    public CondSearchSlipApprovalVO[] getCondSearchSlipApprovalVOs() {
        CondSearchSlipApprovalVO[] vos = (CondSearchSlipApprovalVO[]) models.toArray(new CondSearchSlipApprovalVO[models.size()]);
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
        this.fromCreDt = this.fromCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toEffDt = this.toEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vatSlpTpCd = this.vatSlpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fromEffDt = this.fromEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slipAproFlg = this.slipAproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toCreDt = this.toCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletCtrtNo = this.fletCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrType = this.csrType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
