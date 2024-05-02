/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgXterQtyVO.java
*@FileTitle : BkgXterQtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.07.07 전용진 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgXterQtyVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgXterQtyVO> models = new ArrayList<BkgXterQtyVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String cntrQty = null;

    /* Column Info */
    private String rd = null;

    /* Column Info */
    private String socQty = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String eqSubstCntrTpszCd = null;

    /* Column Info */
    private String eqSubstCgoQty = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgXterQtyVO() {
    }

    public BkgXterQtyVO(String ibflag, String pagerows, String cntrTpszCd, String cntrQty, String socQty, String rd, String eqSubstCntrTpszCd, String eqSubstCgoQty) {
        this.ibflag = ibflag;
        this.cntrTpszCd = cntrTpszCd;
        this.cntrQty = cntrQty;
        this.rd = rd;
        this.socQty = socQty;
        this.pagerows = pagerows;
        this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
        this.eqSubstCgoQty = eqSubstCgoQty;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("cntr_qty", getCntrQty());
        this.hashColumns.put("rd", getRd());
        this.hashColumns.put("soc_qty", getSocQty());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("eq_subst_cntr_tpsz_cd", getEqSubstCntrTpszCd());
        this.hashColumns.put("eq_subst_cgo_qty", getEqSubstCgoQty());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("cntr_qty", "cntrQty");
        this.hashFields.put("rd", "rd");
        this.hashFields.put("soc_qty", "socQty");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("eq_subst_cntr_tpsz_cd", "eqSubstCntrTpszCd");
        this.hashFields.put("eq_subst_cgo_qty", "eqSubstCgoQty");
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
	 * @return cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    /**
	 * Column Info
	 * @return cntrQty
	 */
    public String getCntrQty() {
        return this.cntrQty;
    }

    /**
	 * Column Info
	 * @return rd
	 */
    public String getRd() {
        return this.rd;
    }

    /**
	 * Column Info
	 * @return socQty
	 */
    public String getSocQty() {
        return this.socQty;
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
	 * @param cntrTpszCd
	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
	 * Column Info
	 * @param cntrQty
	 */
    public void setCntrQty(String cntrQty) {
        this.cntrQty = cntrQty;
    }

    /**
	 * Column Info
	 * @param rd
	 */
    public void setRd(String rd) {
        this.rd = rd;
    }

    /**
	 * Column Info
	 * @param socQty
	 */
    public void setSocQty(String socQty) {
        this.socQty = socQty;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setEqSubstCntrTpszCd(String eqSubstCntrTpszCd) {
        this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
    }

    public String getEqSubstCntrTpszCd() {
        return this.eqSubstCntrTpszCd;
    }

    public void setEqSubstCgoQty(String eqSubstCgoQty) {
        this.eqSubstCgoQty = eqSubstCgoQty;
    }

    public String getEqSubstCgoQty() {
        return this.eqSubstCgoQty;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
        setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
        setRd(JSPUtil.getParameter(request, "rd", ""));
        setSocQty(JSPUtil.getParameter(request, "soc_qty", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterQtyVO[]
	 */
    public BkgXterQtyVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgXterQtyVO[]
	 */
    public BkgXterQtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgXterQtyVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] cntrQty = (JSPUtil.getParameter(request, prefix + "cntr_qty", length));
            String[] rd = (JSPUtil.getParameter(request, prefix + "rd", length));
            String[] socQty = (JSPUtil.getParameter(request, prefix + "soc_qty", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] eqSubstCntrTpszCd = (JSPUtil.getParameter(request, prefix + "eq_subst_cntr_tpsz_cd", length));
	    	String[] eqSubstCgoQty = (JSPUtil.getParameter(request, prefix + "eq_subst_cgo_qty", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgXterQtyVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (cntrQty[i] != null)
                    model.setCntrQty(cntrQty[i]);
                if (rd[i] != null)
                    model.setRd(rd[i]);
                if (socQty[i] != null)
                    model.setSocQty(socQty[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (eqSubstCntrTpszCd[i] != null) 
		    		model.setEqSubstCntrTpszCd(eqSubstCntrTpszCd[i]);
				if (eqSubstCgoQty[i] != null) 
		    		model.setEqSubstCgoQty(eqSubstCgoQty[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgXterQtyVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgXterQtyVO[]
	 */
    public BkgXterQtyVO[] getBkgXterQtyVOs() {
        BkgXterQtyVO[] vos = (BkgXterQtyVO[]) models.toArray(new BkgXterQtyVO[models.size()]);
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
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrQty = this.cntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rd = this.rd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.socQty = this.socQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSubstCntrTpszCd = this.eqSubstCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSubstCgoQty = this.eqSubstCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
