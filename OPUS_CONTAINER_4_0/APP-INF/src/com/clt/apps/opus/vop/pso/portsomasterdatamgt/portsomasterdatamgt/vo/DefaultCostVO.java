/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DefaultCostVO.java
*@FileTitle : DefaultCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.23
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.23 박명종 
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
 * @author 박명종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class DefaultCostVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<DefaultCostVO> models = new ArrayList<DefaultCostVO>();

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Status */
    private String ibflag = null;

    /* Column Info */
    private String chk = null;

    /* Column Info */
    private String lgsCostCd = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String lgsCostFullNm = null;

    /* Page Number */
    private String pagerows = null;

    /*[2009.08.17:jmh]*/
    private String chargeType = null;

    /* Column Info */
    private String acctEngNm = null;

    /* Column Info */
    private String cnlAgnFlg = null;

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

    public DefaultCostVO() {
    }

    public DefaultCostVO(String ibflag, String pagerows, String acctCd, String lgsCostCd, String lgsCostFullNm, String chk, String ofcCd, String creUsrId, String chargeType, String acctEngNm, String cnlAgnFlg, String updUsrId, String updDt, String creDt) {
        this.ofcCd = ofcCd;
        this.creUsrId = creUsrId;
        this.ibflag = ibflag;
        this.chk = chk;
        this.lgsCostCd = lgsCostCd;
        this.acctCd = acctCd;
        this.lgsCostFullNm = lgsCostFullNm;
        this.pagerows = pagerows;
        this.chargeType = chargeType;
        this.acctEngNm = acctEngNm;
        this.cnlAgnFlg = cnlAgnFlg;
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
        this.hashColumns.put("chk", getChk());
        this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("charge_type", getChargeType());
        this.hashColumns.put("acct_eng_nm", getAcctEngNm());
        this.hashColumns.put("cnl_agn_flg", getCnlAgnFlg());
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
        this.hashFields.put("chk", "chk");
        this.hashFields.put("lgs_cost_cd", "lgsCostCd");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("charge_type", "chargeType");
        this.hashFields.put("acct_eng_nm", "acctEngNm");
        this.hashFields.put("cnl_agn_flg", "cnlAgnFlg");
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
	 * Status
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return chk
	 */
    public String getChk() {
        return this.chk;
    }

    /**
	 * Column Info
	 * @return lgsCostCd
	 */
    public String getLgsCostCd() {
        return this.lgsCostCd;
    }

    /**
	 * Column Info
	 * @return acctCd
	 */
    public String getAcctCd() {
        return this.acctCd;
    }

    /**
	 * Column Info
	 * @return lgsCostFullNm
	 */
    public String getLgsCostFullNm() {
        return this.lgsCostFullNm;
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
	 * Status
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param chk
	 */
    public void setChk(String chk) {
        this.chk = chk;
    }

    /**
	 * Column Info
	 * @param lgsCostCd
	 */
    public void setLgsCostCd(String lgsCostCd) {
        this.lgsCostCd = lgsCostCd;
    }

    /**
	 * Column Info
	 * @param acctCd
	 */
    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    /**
	 * Column Info
	 * @param lgsCostFullNm
	 */
    public void setLgsCostFullNm(String lgsCostFullNm) {
        this.lgsCostFullNm = lgsCostFullNm;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setAcctEngNm(String acctEngNm) {
        this.acctEngNm = acctEngNm;
    }

    public String getAcctEngNm() {
        return this.acctEngNm;
    }

    public void setCnlAgnFlg(String cnlAgnFlg) {
        this.cnlAgnFlg = cnlAgnFlg;
    }

    public String getCnlAgnFlg() {
        return this.cnlAgnFlg;
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
        setChk(JSPUtil.getParameter(request, "chk", ""));
        setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
        setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
        setLgsCostFullNm(JSPUtil.getParameter(request, "lgs_cost_full_nm", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setChargeType(JSPUtil.getParameter(request, "charge_type", ""));
        setAcctEngNm(JSPUtil.getParameter(request, "acct_eng_nm", ""));
        setCnlAgnFlg(JSPUtil.getParameter(request, "cnl_agn_flg", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
        setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DefaultCostVO[]
	 */
    public DefaultCostVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DefaultCostVO[]
	 */
    public DefaultCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        DefaultCostVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd".trim(), length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] chk = (JSPUtil.getParameter(request, prefix + "chk".trim(), length));
            String[] lgsCostCd = (JSPUtil.getParameter(request, prefix + "lgs_cost_cd".trim(), length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd".trim(), length));
            String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] chargeType = (JSPUtil.getParameter(request, prefix + "charge_type".trim(), length));
            String[] acctEngNm = (JSPUtil.getParameter(request, prefix + "acct_eng_nm", length));
            String[] cnlAgnFlg = (JSPUtil.getParameter(request, prefix + "cnl_agn_flg", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
	    	String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
	    	String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new DefaultCostVO();
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (chk[i] != null)
                    model.setChk(chk[i]);
                if (lgsCostCd[i] != null)
                    model.setLgsCostCd(lgsCostCd[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (lgsCostFullNm[i] != null)
                    model.setLgsCostFullNm(lgsCostFullNm[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (chargeType[i] != null)
                    model.setChargeType(chargeType[i]);
                if (acctEngNm[i] != null)
                    model.setAcctEngNm(acctEngNm[i]);
                if (cnlAgnFlg[i] != null)
                    model.setCnlAgnFlg(cnlAgnFlg[i]);
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
        return getDefaultCostVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return DefaultCostVO[]
	 */
    public DefaultCostVO[] getDefaultCostVOs() {
        DefaultCostVO[] vos = (DefaultCostVO[]) models.toArray(new DefaultCostVO[models.size()]);
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
        this.chk = this.chk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lgsCostCd = this.lgsCostCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lgsCostFullNm = this.lgsCostFullNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chargeType = this.chargeType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctEngNm = this.acctEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnlAgnFlg = this.cnlAgnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }

    /**
	 * @return the chargeType
	 */
    public String getChargeType() {
        return chargeType;
    }

    /**
	 * @param chargeType the chargeType to set
	 */
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }
}
