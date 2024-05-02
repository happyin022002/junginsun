/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DgValidationCondVO.java
*@FileTitle : DgValidationCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.24
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class DgValidationCondVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<DgValidationCondVO> models = new ArrayList<DgValidationCondVO>();

    /* Column Info */
    private String condType = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String condValue = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String dType = null;

    /* Column Info */
    private String portCd = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String cgoOprCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public DgValidationCondVO() {
    }

    public DgValidationCondVO(String ibflag, String pagerows, String condType, String condValue, String vvdCd, String dType, String portCd, String blNo, String cgoOprCd) {
        this.condType = condType;
        this.ibflag = ibflag;
        this.vvdCd = vvdCd;
        this.condValue = condValue;
        this.pagerows = pagerows;
        this.dType = dType;
        this.portCd = portCd;
        this.blNo = blNo;
        this.cgoOprCd = cgoOprCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("cond_type", getCondType());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("cond_value", getCondValue());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("d_type", getDType());
        this.hashColumns.put("port_cd", getPortCd());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("cond_type", "condType");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("cond_value", "condValue");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("d_type", "dType");
        this.hashFields.put("port_cd", "portCd");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("cgo_opr_cd", "cgoOprCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return condType
	 */
    public String getCondType() {
        return this.condType;
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
	 * @return condValue
	 */
    public String getCondValue() {
        return this.condValue;
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
	 * @param condType
	 */
    public void setCondType(String condType) {
        this.condType = condType;
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
	 * @param condValue
	 */
    public void setCondValue(String condValue) {
        this.condValue = condValue;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setDType(String dType) {
        this.dType = dType;
    }

    public String getDType() {
        return this.dType;
    }

    public void setPortCd(String portCd) {
        this.portCd = portCd;
    }

    public String getPortCd() {
        return this.portCd;
    }

    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    public String getBlNo() {
        return this.blNo;
    }

    public void setCgoOprCd(String cgoOprCd) {
        this.cgoOprCd = cgoOprCd;
    }

    public String getCgoOprCd() {
        return this.cgoOprCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setCondType(JSPUtil.getParameter(request, "cond_type", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
        setCondValue(JSPUtil.getParameter(request, "cond_value", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setDType(JSPUtil.getParameter(request, "d_type", ""));
        setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
        setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
        setCgoOprCd(JSPUtil.getParameter(request, "cgo_opr_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgValidationCondVO[]
	 */
    public DgValidationCondVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DgValidationCondVO[]
	 */
    public DgValidationCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        DgValidationCondVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] condType = (JSPUtil.getParameter(request, prefix + "cond_type", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] condValue = (JSPUtil.getParameter(request, prefix + "cond_value", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] dType = (JSPUtil.getParameter(request, prefix + "d_type", length));
            String[] portCd = (JSPUtil.getParameter(request, prefix + "port_cd", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] cgoOprCd = (JSPUtil.getParameter(request, prefix + "cgo_opr_cd", length));
            for (int i = 0; i < length; i++) {
                model = new DgValidationCondVO();
                if (condType[i] != null)
                    model.setCondType(condType[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (condValue[i] != null)
                    model.setCondValue(condValue[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (dType[i] != null)
                    model.setDType(dType[i]);
                if (portCd[i] != null)
                    model.setPortCd(portCd[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (cgoOprCd[i] != null)
                    model.setCgoOprCd(cgoOprCd[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getDgValidationCondVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return DgValidationCondVO[]
	 */
    public DgValidationCondVO[] getDgValidationCondVOs() {
        DgValidationCondVO[] vos = (DgValidationCondVO[]) models.toArray(new DgValidationCondVO[models.size()]);
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
        this.condType = this.condType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.condValue = this.condValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dType = this.dType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portCd = this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoOprCd = this.cgoOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
