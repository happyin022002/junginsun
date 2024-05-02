/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrComboVO.java
*@FileTitle : CntrComboVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.09.10 이병규 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

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
 * @author 이병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CntrComboVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CntrComboVO> models = new ArrayList<CntrComboVO>();

    /* Column Info */
    private String val = null;

    /* Column Info */
    private String deTermCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String name = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String cntrVolQty = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cntrWgt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CntrComboVO() {
    }

    public CntrComboVO(String ibflag, String pagerows, String val, String name, String cntrTpszCd, String cntrVolQty, String rcvTermCd, String deTermCd, String cntrWgt) {
        this.val = val;
        this.deTermCd = deTermCd;
        this.ibflag = ibflag;
        this.cntrTpszCd = cntrTpszCd;
        this.name = name;
        this.rcvTermCd = rcvTermCd;
        this.cntrVolQty = cntrVolQty;
        this.pagerows = pagerows;
        this.cntrWgt = cntrWgt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("val", getVal());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("name", getName());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cntr_wgt", getCntrWgt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("val", "val");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("name", "name");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("cntr_vol_qty", "cntrVolQty");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cntr_wgt", "cntrWgt");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return val
	 */
    public String getVal() {
        return this.val;
    }

    /**
	 * Column Info
	 * @return deTermCd
	 */
    public String getDeTermCd() {
        return this.deTermCd;
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
	 * @return name
	 */
    public String getName() {
        return this.name;
    }

    /**
	 * Column Info
	 * @return rcvTermCd
	 */
    public String getRcvTermCd() {
        return this.rcvTermCd;
    }

    /**
	 * Column Info
	 * @return cntrVolQty
	 */
    public String getCntrVolQty() {
        return this.cntrVolQty;
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
	 * @param val
	 */
    public void setVal(String val) {
        this.val = val;
    }

    /**
	 * Column Info
	 * @param deTermCd
	 */
    public void setDeTermCd(String deTermCd) {
        this.deTermCd = deTermCd;
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
	 * @param name
	 */
    public void setName(String name) {
        this.name = name;
    }

    /**
	 * Column Info
	 * @param rcvTermCd
	 */
    public void setRcvTermCd(String rcvTermCd) {
        this.rcvTermCd = rcvTermCd;
    }

    /**
	 * Column Info
	 * @param cntrVolQty
	 */
    public void setCntrVolQty(String cntrVolQty) {
        this.cntrVolQty = cntrVolQty;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setCntrWgt(String cntrWgt) {
        this.cntrWgt = cntrWgt;
    }

    public String getCntrWgt() {
        return this.cntrWgt;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setVal(JSPUtil.getParameter(request, "val", ""));
        setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
        setName(JSPUtil.getParameter(request, "name", ""));
        setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
        setCntrVolQty(JSPUtil.getParameter(request, "cntr_vol_qty", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrComboVO[]
	 */
    public CntrComboVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrComboVO[]
	 */
    public CntrComboVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CntrComboVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] val = (JSPUtil.getParameter(request, prefix + "val", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] name = (JSPUtil.getParameter(request, prefix + "name", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] cntrVolQty = (JSPUtil.getParameter(request, prefix + "cntr_vol_qty", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] cntrWgt = (JSPUtil.getParameter(request, prefix + "cntr_wgt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CntrComboVO();
                if (val[i] != null)
                    model.setVal(val[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (name[i] != null)
                    model.setName(name[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (cntrVolQty[i] != null)
                    model.setCntrVolQty(cntrVolQty[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (cntrWgt[i] != null) 
		    		model.setCntrWgt(cntrWgt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCntrComboVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CntrComboVO[]
	 */
    public CntrComboVO[] getCntrComboVOs() {
        CntrComboVO[] vos = (CntrComboVO[]) models.toArray(new CntrComboVO[models.size()]);
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
        this.val = this.val.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.name = this.name.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVolQty = this.cntrVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrWgt = this.cntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
