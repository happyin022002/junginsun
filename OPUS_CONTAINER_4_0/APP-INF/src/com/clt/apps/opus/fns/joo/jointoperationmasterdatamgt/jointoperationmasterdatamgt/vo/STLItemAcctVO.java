/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : STLItemAcctVO.java
*@FileTitle : STLItemAcctVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.08 박희동 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class STLItemAcctVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<STLItemAcctVO> models = new ArrayList<STLItemAcctVO>();

    /* Column Info */
    private String rDrAcctCd = null;

    /* Column Info */
    private String rCrAcctCd = null;

    /* Column Info */
    private String eEsAcctCd = null;

    /* Column Info */
    private String rEsAcctCd = null;

    /* Column Info */
    private String joStlItmCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String eDrAcctCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String joStlItmNm = null;

    /* Column Info */
    private String eCrAcctCd = null;

    /* Column Info */
    private String joMnlCreFlg = null;

    /* Column Info */
    private String joAutoCreFlg = null;

    /* Column Info */
    private String ordSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public STLItemAcctVO() {
    }

    public STLItemAcctVO(String ibflag, String pagerows, String joStlItmCd, String joStlItmNm, String joAutoCreFlg, String joMnlCreFlg, String eDrAcctCd, String eCrAcctCd, String eEsAcctCd, String rDrAcctCd, String rCrAcctCd, String rEsAcctCd, String usrId, String reDivrCd, String ordSeq) {
        this.rDrAcctCd = rDrAcctCd;
        this.rCrAcctCd = rCrAcctCd;
        this.eEsAcctCd = eEsAcctCd;
        this.rEsAcctCd = rEsAcctCd;
        this.joStlItmCd = joStlItmCd;
        this.pagerows = pagerows;
        this.eDrAcctCd = eDrAcctCd;
        this.ibflag = ibflag;
        this.usrId = usrId;
        this.reDivrCd = reDivrCd;
        this.joStlItmNm = joStlItmNm;
        this.eCrAcctCd = eCrAcctCd;
        this.joMnlCreFlg = joMnlCreFlg;
        this.joAutoCreFlg = joAutoCreFlg;
        this.ordSeq = ordSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("r_dr_acct_cd", getRDrAcctCd());
        this.hashColumns.put("r_cr_acct_cd", getRCrAcctCd());
        this.hashColumns.put("e_es_acct_cd", getEEsAcctCd());
        this.hashColumns.put("r_es_acct_cd", getREsAcctCd());
        this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("e_dr_acct_cd", getEDrAcctCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("jo_stl_itm_nm", getJoStlItmNm());
        this.hashColumns.put("e_cr_acct_cd", getECrAcctCd());
        this.hashColumns.put("jo_mnl_cre_flg", getJoMnlCreFlg());
        this.hashColumns.put("jo_auto_cre_flg", getJoAutoCreFlg());
        this.hashColumns.put("ord_seq", getOrdSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("r_dr_acct_cd", "rDrAcctCd");
        this.hashFields.put("r_cr_acct_cd", "rCrAcctCd");
        this.hashFields.put("e_es_acct_cd", "eEsAcctCd");
        this.hashFields.put("r_es_acct_cd", "rEsAcctCd");
        this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("e_dr_acct_cd", "eDrAcctCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("jo_stl_itm_nm", "joStlItmNm");
        this.hashFields.put("e_cr_acct_cd", "eCrAcctCd");
        this.hashFields.put("jo_mnl_cre_flg", "joMnlCreFlg");
        this.hashFields.put("jo_auto_cre_flg", "joAutoCreFlg");
        this.hashFields.put("ord_seq", "ordSeq");
        return this.hashFields;
    }

    /**
	 * hashColumnInpo
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues(String reDivrCd) {
        this.hashColumns.put("jo_mnl_cre_flg", getJoMnlCreFlg());
        this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("re_divr_cd", reDivrCd);
        if ("E".equals(reDivrCd)) {
            this.hashColumns.put("cr_acct_cd", getECrAcctCd());
            this.hashColumns.put("dr_acct_cd", getEDrAcctCd());
            this.hashColumns.put("jo_estm_acct_cd", getEEsAcctCd());
        } else if ("R".equals(reDivrCd)) {
            this.hashColumns.put("dr_acct_cd", getRDrAcctCd());
            this.hashColumns.put("cr_acct_cd", getRCrAcctCd());
            this.hashColumns.put("jo_estm_acct_cd", getREsAcctCd());
        }
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("jo_auto_cre_flg", getJoAutoCreFlg());
        this.hashColumns.put("jo_stl_itm_nm", getJoStlItmNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ord_seq", getOrdSeq());
        return this.hashColumns;
    }

    /**
	 * Column Info
	 * @return rDrAcctCd
	 */
    public String getRDrAcctCd() {
        return this.rDrAcctCd;
    }

    /**
	 * Column Info
	 * @return rCrAcctCd
	 */
    public String getRCrAcctCd() {
        return this.rCrAcctCd;
    }

    /**
	 * Column Info
	 * @return eEsAcctCd
	 */
    public String getEEsAcctCd() {
        return this.eEsAcctCd;
    }

    /**
	 * Column Info
	 * @return rEsAcctCd
	 */
    public String getREsAcctCd() {
        return this.rEsAcctCd;
    }

    /**
	 * Column Info
	 * @return joStlItmCd
	 */
    public String getJoStlItmCd() {
        return this.joStlItmCd;
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
	 * @return eDrAcctCd
	 */
    public String getEDrAcctCd() {
        return this.eDrAcctCd;
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
	 * @return usrId
	 */
    public String getUsrId() {
        return this.usrId;
    }

    /**
	 * Column Info
	 * @return reDivrCd
	 */
    public String getReDivrCd() {
        return this.reDivrCd;
    }

    /**
	 * Column Info
	 * @return joStlItmNm
	 */
    public String getJoStlItmNm() {
        return this.joStlItmNm;
    }

    /**
	 * Column Info
	 * @return eCrAcctCd
	 */
    public String getECrAcctCd() {
        return this.eCrAcctCd;
    }

    /**
	 * Column Info
	 * @return joMnlCreFlg
	 */
    public String getJoMnlCreFlg() {
        return this.joMnlCreFlg;
    }

    /**
	 * Column Info
	 * @return joAutoCreFlg
	 */
    public String getJoAutoCreFlg() {
        return this.joAutoCreFlg;
    }

    /**
	 * Column Info
	 * @param rDrAcctCd
	 */
    public void setRDrAcctCd(String rDrAcctCd) {
        this.rDrAcctCd = rDrAcctCd;
    }

    /**
	 * Column Info
	 * @param rCrAcctCd
	 */
    public void setRCrAcctCd(String rCrAcctCd) {
        this.rCrAcctCd = rCrAcctCd;
    }

    /**
	 * Column Info
	 * @param eEsAcctCd
	 */
    public void setEEsAcctCd(String eEsAcctCd) {
        this.eEsAcctCd = eEsAcctCd;
    }

    /**
	 * Column Info
	 * @param rEsAcctCd
	 */
    public void setREsAcctCd(String rEsAcctCd) {
        this.rEsAcctCd = rEsAcctCd;
    }

    /**
	 * Column Info
	 * @param joStlItmCd
	 */
    public void setJoStlItmCd(String joStlItmCd) {
        this.joStlItmCd = joStlItmCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param eDrAcctCd
	 */
    public void setEDrAcctCd(String eDrAcctCd) {
        this.eDrAcctCd = eDrAcctCd;
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
	 * @param usrId
	 */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
	 * Column Info
	 * @param reDivrCd
	 */
    public void setReDivrCd(String reDivrCd) {
        this.reDivrCd = reDivrCd;
    }

    /**
	 * Column Info
	 * @param joStlItmNm
	 */
    public void setJoStlItmNm(String joStlItmNm) {
        this.joStlItmNm = joStlItmNm;
    }

    /**
	 * Column Info
	 * @param eCrAcctCd
	 */
    public void setECrAcctCd(String eCrAcctCd) {
        this.eCrAcctCd = eCrAcctCd;
    }

    /**
	 * Column Info
	 * @param joMnlCreFlg
	 */
    public void setJoMnlCreFlg(String joMnlCreFlg) {
        this.joMnlCreFlg = joMnlCreFlg;
    }

    /**
	 * Column Info
	 * @param joAutoCreFlg
	 */
    public void setJoAutoCreFlg(String joAutoCreFlg) {
        this.joAutoCreFlg = joAutoCreFlg;
    }

    public void setOrdSeq(String ordSeq) {
        this.ordSeq = ordSeq;
    }

    public String getOrdSeq() {
        return this.ordSeq;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setRDrAcctCd(JSPUtil.getParameter(request, "r_dr_acct_cd", ""));
        setRCrAcctCd(JSPUtil.getParameter(request, "r_cr_acct_cd", ""));
        setEEsAcctCd(JSPUtil.getParameter(request, "e_es_acct_cd", ""));
        setREsAcctCd(JSPUtil.getParameter(request, "r_es_acct_cd", ""));
        setJoStlItmCd(JSPUtil.getParameter(request, "jo_stl_itm_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setEDrAcctCd(JSPUtil.getParameter(request, "e_dr_acct_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
        setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
        setJoStlItmNm(JSPUtil.getParameter(request, "jo_stl_itm_nm", ""));
        setECrAcctCd(JSPUtil.getParameter(request, "e_cr_acct_cd", ""));
        setJoMnlCreFlg(JSPUtil.getParameter(request, "jo_mnl_cre_flg", ""));
        setJoAutoCreFlg(JSPUtil.getParameter(request, "jo_auto_cre_flg", ""));
        setOrdSeq(JSPUtil.getParameter(request, "ord_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return STLItemAcctVO[]
	 */
    public STLItemAcctVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return STLItemAcctVO[]
	 */
    public STLItemAcctVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        STLItemAcctVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] rDrAcctCd = (JSPUtil.getParameter(request, prefix + "r_dr_acct_cd", length));
            String[] rCrAcctCd = (JSPUtil.getParameter(request, prefix + "r_cr_acct_cd", length));
            String[] eEsAcctCd = (JSPUtil.getParameter(request, prefix + "e_es_acct_cd", length));
            String[] rEsAcctCd = (JSPUtil.getParameter(request, prefix + "r_es_acct_cd", length));
            String[] joStlItmCd = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] eDrAcctCd = (JSPUtil.getParameter(request, prefix + "e_dr_acct_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] joStlItmNm = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_nm", length));
            String[] eCrAcctCd = (JSPUtil.getParameter(request, prefix + "e_cr_acct_cd", length));
            String[] joMnlCreFlg = (JSPUtil.getParameter(request, prefix + "jo_mnl_cre_flg", length));
            String[] joAutoCreFlg = (JSPUtil.getParameter(request, prefix + "jo_auto_cre_flg", length));
            String[] ordSeq = (JSPUtil.getParameter(request, prefix + "ord_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new STLItemAcctVO();
                if (rDrAcctCd[i] != null)
                    model.setRDrAcctCd(rDrAcctCd[i]);
                if (rCrAcctCd[i] != null)
                    model.setRCrAcctCd(rCrAcctCd[i]);
                if (eEsAcctCd[i] != null)
                    model.setEEsAcctCd(eEsAcctCd[i]);
                if (rEsAcctCd[i] != null)
                    model.setREsAcctCd(rEsAcctCd[i]);
                if (joStlItmCd[i] != null)
                    model.setJoStlItmCd(joStlItmCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (eDrAcctCd[i] != null)
                    model.setEDrAcctCd(eDrAcctCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (joStlItmNm[i] != null)
                    model.setJoStlItmNm(joStlItmNm[i]);
                if (eCrAcctCd[i] != null)
                    model.setECrAcctCd(eCrAcctCd[i]);
                if (joMnlCreFlg[i] != null)
                    model.setJoMnlCreFlg(joMnlCreFlg[i]);
                if (joAutoCreFlg[i] != null)
                    model.setJoAutoCreFlg(joAutoCreFlg[i]);
                if (ordSeq[i] != null) 
		    		model.setOrdSeq(ordSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSTLItemAcctVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return STLItemAcctVO[]
	 */
    public STLItemAcctVO[] getSTLItemAcctVOs() {
        STLItemAcctVO[] vos = (STLItemAcctVO[]) models.toArray(new STLItemAcctVO[models.size()]);
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
        this.rDrAcctCd = this.rDrAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rCrAcctCd = this.rCrAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eEsAcctCd = this.eEsAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rEsAcctCd = this.rEsAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCd = this.joStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eDrAcctCd = this.eDrAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmNm = this.joStlItmNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eCrAcctCd = this.eCrAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joMnlCreFlg = this.joMnlCreFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joAutoCreFlg = this.joAutoCreFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ordSeq = this.ordSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
