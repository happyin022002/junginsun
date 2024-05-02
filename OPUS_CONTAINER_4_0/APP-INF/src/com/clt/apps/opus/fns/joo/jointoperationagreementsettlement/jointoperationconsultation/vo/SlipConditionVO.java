/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SlipConditionVO.java
*@FileTitle : SlipConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.19 함대성 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

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
 * @author 함대성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SlipConditionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SlipConditionVO> models = new ArrayList<SlipConditionVO>();

    /* Column Info */
    private String toDt = null;

    /* Column Info */
    private String csrNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String gubun = null;

    /* Column Info */
    private String slpOfcCdSel = null;

    /* Column Info */
    private String frDt = null;

    /* Column Info */
    private String slpOfcCd = null;

    /* Column Info */
    private String slpOfcCd2 = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String authOfcCd = null;

    /* Column Info */
    private String schTpCd = null;

    /* Column Info */
    private String slpIssDt = null;

    /* Column Info */
    private String ifFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SlipConditionVO() {
    }

    public SlipConditionVO(String ibflag, String pagerows, String csrNo, String frDt, String toDt, String gubun, String slpOfcCd2, String slpOfcCd, String slpOfcCdSel, String authOfcCd, String schTpCd, String slpIssDt, String ifFlg) {
        this.toDt = toDt;
        this.csrNo = csrNo;
        this.ibflag = ibflag;
        this.gubun = gubun;
        this.slpOfcCdSel = slpOfcCdSel;
        this.frDt = frDt;
        this.slpOfcCd = slpOfcCd;
        this.slpOfcCd2 = slpOfcCd2;
        this.pagerows = pagerows;
        this.authOfcCd = authOfcCd;
        this.schTpCd = schTpCd;
        this.slpIssDt = slpIssDt;
        this.ifFlg = ifFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("to_dt", getToDt());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("gubun", getGubun());
        this.hashColumns.put("slp_ofc_cd_sel", getSlpOfcCdSel());
        this.hashColumns.put("fr_dt", getFrDt());
        this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
        this.hashColumns.put("slp_ofc_cd2", getSlpOfcCd2());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
        this.hashColumns.put("sch_tp_cd", getSchTpCd());
        this.hashColumns.put("slp_iss_dt", getSlpIssDt());
        this.hashColumns.put("if_flg", getIfFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("to_dt", "toDt");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("gubun", "gubun");
        this.hashFields.put("slp_ofc_cd_sel", "slpOfcCdSel");
        this.hashFields.put("fr_dt", "frDt");
        this.hashFields.put("slp_ofc_cd", "slpOfcCd");
        this.hashFields.put("slp_ofc_cd2", "slpOfcCd2");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("auth_ofc_cd", "authOfcCd");
        this.hashFields.put("sch_tp_cd", "schTpCd");
        this.hashFields.put("slp_iss_dt", "slpIssDt");
        this.hashFields.put("if_flg", "ifFlg");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return toDt
	 */
    public String getToDt() {
        return this.toDt;
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
	 * @return gubun
	 */
    public String getGubun() {
        return this.gubun;
    }

    /**
	 * Column Info
	 * @return slpOfcCdSel
	 */
    public String getSlpOfcCdSel() {
        return this.slpOfcCdSel;
    }

    /**
	 * Column Info
	 * @return frDt
	 */
    public String getFrDt() {
        return this.frDt;
    }

    /**
	 * Column Info
	 * @return slpOfcCd
	 */
    public String getSlpOfcCd() {
        return this.slpOfcCd;
    }

    /**
	 * Column Info
	 * @return slpOfcCd2
	 */
    public String getSlpOfcCd2() {
        return this.slpOfcCd2;
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
	 * @param toDt
	 */
    public void setToDt(String toDt) {
        this.toDt = toDt;
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
	 * @param gubun
	 */
    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    /**
	 * Column Info
	 * @param slpOfcCdSel
	 */
    public void setSlpOfcCdSel(String slpOfcCdSel) {
        this.slpOfcCdSel = slpOfcCdSel;
    }

    /**
	 * Column Info
	 * @param frDt
	 */
    public void setFrDt(String frDt) {
        this.frDt = frDt;
    }

    /**
	 * Column Info
	 * @param slpOfcCd
	 */
    public void setSlpOfcCd(String slpOfcCd) {
        this.slpOfcCd = slpOfcCd;
    }

    /**
	 * Column Info
	 * @param slpOfcCd2
	 */
    public void setSlpOfcCd2(String slpOfcCd2) {
        this.slpOfcCd2 = slpOfcCd2;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setAuthOfcCd(String authOfcCd) {
        this.authOfcCd = authOfcCd;
    }

    public String getAuthOfcCd() {
        return this.authOfcCd;
    }

    public void setSchTpCd(String schTpCd) {
        this.schTpCd = schTpCd;
    }

    public String getSchTpCd() {
        return this.schTpCd;
    }

    public void setSlpIssDt(String slpIssDt) {
        this.slpIssDt = slpIssDt;
    }

    public String getSlpIssDt() {
        return this.slpIssDt;
    }

    public void setIfFlg(String ifFlg) {
        this.ifFlg = ifFlg;
    }

    public String getIfFlg() {
        return this.ifFlg;
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
        setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
        setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
        setSlpOfcCdSel(JSPUtil.getParameter(request, prefix + "slp_ofc_cd_sel", ""));
        setFrDt(JSPUtil.getParameter(request, prefix + "fr_dt", ""));
        setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
        setSlpOfcCd2(JSPUtil.getParameter(request, prefix + "slp_ofc_cd2", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setAuthOfcCd(JSPUtil.getParameter(request, prefix + "auth_ofc_cd", ""));
        setSchTpCd(JSPUtil.getParameter(request, prefix + "sch_tp_cd", ""));
        setSlpIssDt(JSPUtil.getParameter(request, prefix + "slp_iss_dt", ""));
        setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SlipConditionVO[]
	 */
    public SlipConditionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SlipConditionVO[]
	 */
    public SlipConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SlipConditionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] toDt = (JSPUtil.getParameter(request, prefix + "to_dt", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] gubun = (JSPUtil.getParameter(request, prefix + "gubun", length));
            String[] slpOfcCdSel = (JSPUtil.getParameter(request, prefix + "slp_ofc_cd_sel", length));
            String[] frDt = (JSPUtil.getParameter(request, prefix + "fr_dt", length));
            String[] slpOfcCd = (JSPUtil.getParameter(request, prefix + "slp_ofc_cd", length));
            String[] slpOfcCd2 = (JSPUtil.getParameter(request, prefix + "slp_ofc_cd2", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] authOfcCd = (JSPUtil.getParameter(request, prefix + "auth_ofc_cd", length));
            String[] schTpCd = (JSPUtil.getParameter(request, prefix + "sch_tp_cd", length));
            String[] slpIssDt = (JSPUtil.getParameter(request, prefix + "slp_iss_dt", length));
            String[] ifFlg = (JSPUtil.getParameter(request, prefix + "if_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SlipConditionVO();
                if (toDt[i] != null)
                    model.setToDt(toDt[i]);
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (gubun[i] != null)
                    model.setGubun(gubun[i]);
                if (slpOfcCdSel[i] != null)
                    model.setSlpOfcCdSel(slpOfcCdSel[i]);
                if (frDt[i] != null)
                    model.setFrDt(frDt[i]);
                if (slpOfcCd[i] != null)
                    model.setSlpOfcCd(slpOfcCd[i]);
                if (slpOfcCd2[i] != null)
                    model.setSlpOfcCd2(slpOfcCd2[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (authOfcCd[i] != null)
                    model.setAuthOfcCd(authOfcCd[i]);
                if (schTpCd[i] != null)
                    model.setSchTpCd(schTpCd[i]);
                if (slpIssDt[i] != null)
                    model.setSlpIssDt(slpIssDt[i]);
                if (ifFlg[i] != null) 
		    		model.setIfFlg(ifFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSlipConditionVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SlipConditionVO[]
	 */
    public SlipConditionVO[] getSlipConditionVOs() {
        SlipConditionVO[] vos = (SlipConditionVO[]) models.toArray(new SlipConditionVO[models.size()]);
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
        this.toDt = this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gubun = this.gubun.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpOfcCdSel = this.slpOfcCdSel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frDt = this.frDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpOfcCd = this.slpOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpOfcCd2 = this.slpOfcCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authOfcCd = this.authOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.schTpCd = this.schTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpIssDt = this.slpIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ifFlg = this.ifFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
