/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : YardChargeVersionVO.java
*@FileTitle : YardChargeVersionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.30 김진일 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class YardChargeVersionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<YardChargeVersionVO> models = new ArrayList<YardChargeVersionVO>();

    /* Column Info */
    private String updDt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String rn = null;

    /* Column Info */
    private String ydChgVerSeq = null;

    /* Column Info */
    private String ydChgNo = null;

    /* Column Info */
    private String updUsrId = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String updMnuNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public YardChargeVersionVO() {
    }

    public YardChargeVersionVO(String ibflag, String pagerows, String rn, String ydChgNo, String ydChgVerSeq, String updUsrId, String updDt, String updMnuNo) {
        this.updDt = updDt;
        this.ibflag = ibflag;
        this.rn = rn;
        this.ydChgVerSeq = ydChgVerSeq;
        this.ydChgNo = ydChgNo;
        this.updUsrId = updUsrId;
        this.pagerows = pagerows;
        this.updMnuNo = updMnuNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("rn", getRn());
        this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
        this.hashColumns.put("yd_chg_no", getYdChgNo());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("upd_mnu_no", getUpdMnuNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("rn", "rn");
        this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
        this.hashFields.put("yd_chg_no", "ydChgNo");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("upd_mnu_no", "updMnuNo");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
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
	 * @return rn
	 */
    public String getRn() {
        return this.rn;
    }

    /**
	 * Column Info
	 * @return ydChgVerSeq
	 */
    public String getYdChgVerSeq() {
        return this.ydChgVerSeq;
    }

    /**
	 * Column Info
	 * @return ydChgNo
	 */
    public String getYdChgNo() {
        return this.ydChgNo;
    }

    /**
	 * Column Info
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
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
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
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
	 * @param rn
	 */
    public void setRn(String rn) {
        this.rn = rn;
    }

    /**
	 * Column Info
	 * @param ydChgVerSeq
	 */
    public void setYdChgVerSeq(String ydChgVerSeq) {
        this.ydChgVerSeq = ydChgVerSeq;
    }

    /**
	 * Column Info
	 * @param ydChgNo
	 */
    public void setYdChgNo(String ydChgNo) {
        this.ydChgNo = ydChgNo;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setUpdMnuNo(String updMnuNo) {
        this.updMnuNo = updMnuNo;
    }

    public String getUpdMnuNo() {
        return this.updMnuNo;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setRn(JSPUtil.getParameter(request, "rn", ""));
        setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
        setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setUpdMnuNo(JSPUtil.getParameter(request, "upd_mnu_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return YardChargeVersionVO[]
	 */
    public YardChargeVersionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return YardChargeVersionVO[]
	 */
    public YardChargeVersionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        YardChargeVersionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] rn = (JSPUtil.getParameter(request, prefix + "rn", length));
            String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix + "yd_chg_ver_seq", length));
            String[] ydChgNo = (JSPUtil.getParameter(request, prefix + "yd_chg_no", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] updMnuNo = (JSPUtil.getParameter(request, prefix + "upd_mnu_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new YardChargeVersionVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (rn[i] != null)
                    model.setRn(rn[i]);
                if (ydChgVerSeq[i] != null)
                    model.setYdChgVerSeq(ydChgVerSeq[i]);
                if (ydChgNo[i] != null)
                    model.setYdChgNo(ydChgNo[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (updMnuNo[i] != null) 
		    		model.setUpdMnuNo(updMnuNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getYardChargeVersionVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return YardChargeVersionVO[]
	 */
    public YardChargeVersionVO[] getYardChargeVersionVOs() {
        YardChargeVersionVO[] vos = (YardChargeVersionVO[]) models.toArray(new YardChargeVersionVO[models.size()]);
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
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rn = this.rn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydChgVerSeq = this.ydChgVerSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydChgNo = this.ydChgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updMnuNo = this.updMnuNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
