/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomAcctItmVO.java
*@FileTitle : CustomAcctItmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.21 윤세영 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 윤세영
 * @since J2EE 1.5
 * @see ESM_FMS_0069HTMLAction
 */
public class CustomAcctItmVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CustomAcctItmVO> models = new ArrayList<CustomAcctItmVO>();

    /* updUsrId */
    private String updUsrId = null;

    /* acctCd */
    private String acctCd = null;

    /* ibflag */
    private String ibflag = null;

    /* updDt */
    private String updDt = null;

    /* creDt */
    private String creDt = null;

    /* creUsrId */
    private String creUsrId = null;

    /* acctEngNm */
    private String acctEngNm = null;

    /*acctItmNm */
    private String acctItmNm = null;

    /* Page Number */
    private String pagerows = null;

    /*acctItmSeq */
    private String acctItmSeq = null;

    /* Column Info */
    private String acctNm = null;

    /* Column Info */
    private String apCrAcctCd = null;

    /* Column Info */
    private String apCrAcctNm = null;

    /* Column Info */
    private String arCrAcctCd = null;

    /* Column Info */
    private String arCrAcctNm = null;

    /* Column Info */
    private String pndTgtFlg = null;

    /*	hashColumnInpo	*/
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	hashFildInpo	*/
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    /**
	  * 생성자
	  * @param
	  * @return 
	  */
    public CustomAcctItmVO() {
    }

    /**
	 * 생성자
	 * @param String ibflag, String pagerows, String acctCd, String acctItmSeq, String acctItmNm, String creUsrId, String creDt, String updUsrId, String updDt, String acctEngNm
	 * @return 
	 */
    public CustomAcctItmVO(String ibflag, String pagerows, String acctCd, String acctItmSeq, String acctItmNm, String creUsrId, String creDt, String updUsrId, String updDt, String acctEngNm, String acctNm, String apCrAcctCd, String apCrAcctNm, String arCrAcctCd, String arCrAcctNm, String pndTgtFlg) {
        this.updUsrId = updUsrId;
        this.acctCd = acctCd;
        this.ibflag = ibflag;
        this.updDt = updDt;
        this.creDt = creDt;
        this.creUsrId = creUsrId;
        this.acctEngNm = acctEngNm;
        this.acctItmNm = acctItmNm;
        this.pagerows = pagerows;
        this.acctItmSeq = acctItmSeq;
        this.acctNm = acctNm;
        this.apCrAcctCd = apCrAcctCd;
        this.apCrAcctNm = apCrAcctNm;
        this.arCrAcctCd = arCrAcctCd;
        this.arCrAcctNm = arCrAcctNm;
        this.pndTgtFlg = pndTgtFlg;
    }

    /**
	 * hashColumnInpo
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("acct_eng_nm", getAcctEngNm());
        this.hashColumns.put("acct_itm_nm", getAcctItmNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
        this.hashColumns.put("acct_nm", getAcctNm());
        this.hashColumns.put("ap_cr_acct_cd", getApCrAcctCd());
        this.hashColumns.put("ap_cr_acct_nm", getApCrAcctNm());
        this.hashColumns.put("ar_cr_acct_cd", getArCrAcctCd());
        this.hashColumns.put("ar_cr_acct_nm", getArCrAcctNm());
        this.hashColumns.put("pnd_tgt_flg", getPndTgtFlg());
        return this.hashColumns;
    }

    /**
	 * hashFildInpo
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("acct_eng_nm", "acctEngNm");
        this.hashFields.put("acct_itm_nm", "acctItmNm");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("acct_itm_seq", "acctItmSeq");
        this.hashFields.put("acct_nm", "acctNm");
        this.hashFields.put("ap_cr_acct_cd", "apCrAcctCd");
        this.hashFields.put("ap_cr_acct_nm", "apCrAcctNm");
        this.hashFields.put("ar_cr_acct_cd", "arCrAcctCd");
        this.hashFields.put("ar_cr_acct_nm", "arCrAcctNm");
        this.hashFields.put("pnd_tgt_flg", "pndTgtFlg");
        return this.hashFields;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public String getAcctCd() {
        return this.acctCd;
    }

    public String getIbflag() {
        return this.ibflag;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    public String getCreDt() {
        return this.creDt;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public String getAcctEngNm() {
        return this.acctEngNm;
    }

    public String getAcctItmNm() {
        return this.acctItmNm;
    }

    public String getPagerows() {
        return this.pagerows;
    }

    public String getAcctItmSeq() {
        return this.acctItmSeq;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public void setAcctEngNm(String acctEngNm) {
        this.acctEngNm = acctEngNm;
    }

    public void setAcctItmNm(String acctItmNm) {
        this.acctItmNm = acctItmNm;
    }

    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setAcctItmSeq(String acctItmSeq) {
        this.acctItmSeq = acctItmSeq;
    }

    public void setAcctNm(String acctNm) {
        this.acctNm = acctNm;
    }

    public String getAcctNm() {
        return this.acctNm;
    }

    public void setApCrAcctCd(String apCrAcctCd) {
        this.apCrAcctCd = apCrAcctCd;
    }

    public String getApCrAcctCd() {
        return this.apCrAcctCd;
    }

    public void setApCrAcctNm(String apCrAcctNm) {
        this.apCrAcctNm = apCrAcctNm;
    }

    public String getApCrAcctNm() {
        return this.apCrAcctNm;
    }

    public void setArCrAcctCd(String arCrAcctCd) {
        this.arCrAcctCd = arCrAcctCd;
    }

    public String getArCrAcctCd() {
        return this.arCrAcctCd;
    }

    public void setArCrAcctNm(String arCrAcctNm) {
        this.arCrAcctNm = arCrAcctNm;
    }

    public String getArCrAcctNm() {
        return this.arCrAcctNm;
    }

    public void setPndTgtFlg(String pndTgtFlg) {
        this.pndTgtFlg = pndTgtFlg;
    }

    public String getPndTgtFlg() {
        return this.pndTgtFlg;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    public void fromRequest(HttpServletRequest request, String prefix) {
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setAcctEngNm(JSPUtil.getParameter(request, prefix + "acct_eng_nm", ""));
        setAcctItmNm(JSPUtil.getParameter(request, prefix + "acct_itm_nm", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setAcctItmSeq(JSPUtil.getParameter(request, prefix + "acct_itm_seq", ""));
        setAcctNm(JSPUtil.getParameter(request, prefix + "acct_nm", ""));
        setApCrAcctCd(JSPUtil.getParameter(request, prefix + "ap_cr_acct_cd", ""));
        setApCrAcctNm(JSPUtil.getParameter(request, prefix + "ap_cr_acct_nm", ""));
        setArCrAcctCd(JSPUtil.getParameter(request, prefix + "ar_cr_acct_cd", ""));
        setArCrAcctNm(JSPUtil.getParameter(request, prefix + "ar_cr_acct_nm", ""));
        setPndTgtFlg(JSPUtil.getParameter(request, prefix + "pnd_tgt_flg", ""));
    }

    public CustomAcctItmVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    public CustomAcctItmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CustomAcctItmVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id".trim(), length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt".trim(), length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt".trim(), length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id".trim(), length));
            String[] acctEngNm = (JSPUtil.getParameter(request, prefix + "acct_eng_nm".trim(), length));
            String[] acctItmNm = (JSPUtil.getParameter(request, prefix + "acct_itm_nm".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] acctItmSeq = (JSPUtil.getParameter(request, prefix + "acct_itm_seq".trim(), length));
            String[] acctNm = (JSPUtil.getParameter(request, prefix + "acct_nm", length));
            String[] apCrAcctCd = (JSPUtil.getParameter(request, prefix + "ap_cr_acct_cd", length));
            String[] apCrAcctNm = (JSPUtil.getParameter(request, prefix + "ap_cr_acct_nm", length));
            String[] arCrAcctCd = (JSPUtil.getParameter(request, prefix + "ar_cr_acct_cd", length));
            String[] arCrAcctNm = (JSPUtil.getParameter(request, prefix + "ar_cr_acct_nm", length));
            String[] pndTgtFlg = (JSPUtil.getParameter(request, prefix + "pnd_tgt_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CustomAcctItmVO();
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (acctEngNm[i] != null)
                    model.setAcctEngNm(acctEngNm[i]);
                if (acctItmNm[i] != null)
                    model.setAcctItmNm(acctItmNm[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (acctItmSeq[i] != null)
                    model.setAcctItmSeq(acctItmSeq[i]);
                if (acctNm[i] != null)
                    model.setAcctNm(acctNm[i]);
                if (apCrAcctCd[i] != null)
                    model.setApCrAcctCd(apCrAcctCd[i]);
                if (apCrAcctNm[i] != null)
                    model.setApCrAcctNm(apCrAcctNm[i]);
                if (arCrAcctCd[i] != null)
                    model.setArCrAcctCd(arCrAcctCd[i]);
                if (arCrAcctNm[i] != null)
                    model.setArCrAcctNm(arCrAcctNm[i]);
                if (pndTgtFlg[i] != null) 
		    		model.setPndTgtFlg(pndTgtFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
        }
        return getCustomAcctItmVOs();
    }

    public CustomAcctItmVO[] getCustomAcctItmVOs() {
        CustomAcctItmVO[] vos = (CustomAcctItmVO[]) models.toArray(new CustomAcctItmVO[models.size()]);
        return vos;
    }

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
        }
        return ret.toString();
    }

    /**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
    private String[] getField(Field[] field, int i) throws IllegalAccessException {
        String[] arr;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = new String[1];
            arr[0] = String.valueOf(field[i].get(this));
        }
        return arr;
    }

    /**
	* DataFormat 설정
	*/
    public void onDataFormat() {
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctEngNm = this.acctEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctItmNm = this.acctItmNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctItmSeq = this.acctItmSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
