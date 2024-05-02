/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PsoInvOfcYdVO.java
*@FileTitle : PsoInvOfcYdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.10.07 김진일 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo;

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
public class PsoInvOfcYdVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PsoInvOfcYdVO> models = new ArrayList<PsoInvOfcYdVO>();

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String ydCd1 = null;

    /* Column Info */
    private String ydCd2 = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String canalFlag = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String creDt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public PsoInvOfcYdVO() {
    }

    public PsoInvOfcYdVO(String ibflag, String pagerows, String ydCd1, String ydCd2, String ofcCd, String currCd, String creUsrId, String canalFlag, String updUsrId, String updDt, String creDt) {
        this.ofcCd = ofcCd;
        this.creUsrId = creUsrId;
        this.ibflag = ibflag;
        this.currCd = currCd;
        this.ydCd1 = ydCd1;
        this.ydCd2 = ydCd2;
        this.pagerows = pagerows;
        this.canalFlag = canalFlag;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.creDt = creDt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("yd_cd1", getYdCd1());
        this.hashColumns.put("yd_cd2", getYdCd2());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("canal_flag", getCanalFlag());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cre_dt", getCreDt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("yd_cd1", "ydCd1");
        this.hashFields.put("yd_cd2", "ydCd2");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("canal_flag", "canalFlag");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("cre_dt", "creDt");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 * Column Info
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
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
	 * @return currCd
	 */
    public String getCurrCd() {
        return this.currCd;
    }

    /**
	 * Column Info
	 * @return ydCd1
	 */
    public String getYdCd1() {
        return this.ydCd1;
    }

    /**
	 * Column Info
	 * @return ydCd2
	 */
    public String getYdCd2() {
        return this.ydCd2;
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
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
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
	 * @param currCd
	 */
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    /**
	 * Column Info
	 * @param ydCd1
	 */
    public void setYdCd1(String ydCd1) {
        this.ydCd1 = ydCd1;
    }

    /**
	 * Column Info
	 * @param ydCd2
	 */
    public void setYdCd2(String ydCd2) {
        this.ydCd2 = ydCd2;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setCanalFlag(String canalFlag) {
        this.canalFlag = canalFlag;
    }

    public String getCanalFlag() {
        return this.canalFlag;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
        setYdCd1(JSPUtil.getParameter(request, "yd_cd1", ""));
        setYdCd2(JSPUtil.getParameter(request, "yd_cd2", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setCanalFlag(JSPUtil.getParameter(request, "canal_flag", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
        setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsoInvOfcYdVO[]
	 */
    public PsoInvOfcYdVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsoInvOfcYdVO[]
	 */
    public PsoInvOfcYdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PsoInvOfcYdVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] ydCd1 = (JSPUtil.getParameter(request, prefix + "yd_cd1", length));
            String[] ydCd2 = (JSPUtil.getParameter(request, prefix + "yd_cd2", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] canalFlag = (JSPUtil.getParameter(request, prefix + "canal_flag", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
	    	String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
	    	String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new PsoInvOfcYdVO();
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (ydCd1[i] != null)
                    model.setYdCd1(ydCd1[i]);
                if (ydCd2[i] != null)
                    model.setYdCd2(ydCd2[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (canalFlag[i] != null)
                    model.setCanalFlag(canalFlag[i]);
                if (updUsrId[i] != null) 
		    		model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
		    		model.setUpdDt(updDt[i]);
				if (creDt[i] != null) 
		    		model.setCreDt(creDt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getPsoInvOfcYdVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return PsoInvOfcYdVO[]
	 */
    public PsoInvOfcYdVO[] getPsoInvOfcYdVOs() {
        PsoInvOfcYdVO[] vos = (PsoInvOfcYdVO[]) models.toArray(new PsoInvOfcYdVO[models.size()]);
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
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd1 = this.ydCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd2 = this.ydCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.canalFlag = this.canalFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
