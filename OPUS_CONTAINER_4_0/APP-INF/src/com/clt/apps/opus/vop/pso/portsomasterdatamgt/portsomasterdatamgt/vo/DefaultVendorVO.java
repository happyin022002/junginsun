/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DefaultVendorVO.java
*@FileTitle : DefaultVendorVO
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
import java.util.LinkedHashMap;
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
public class DefaultVendorVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<DefaultVendorVO> models = new ArrayList<DefaultVendorVO>();

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Status */
    private String ibflag = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String vndrLglEngNm = null;

    /* Column Info */
    private String deltFlg = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cnlAgnFlg = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String creDt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public DefaultVendorVO() {
    }

    public DefaultVendorVO(String ibflag, String pagerows, String vndrSeq, String vndrLglEngNm, String ofcCd, String creUsrId, String deltFlg, String cnlAgnFlg, String updUsrId, String updDt, String creDt) {
        this.ofcCd = ofcCd;
        this.creUsrId = creUsrId;
        this.ibflag = ibflag;
        this.vndrSeq = vndrSeq;
        this.vndrLglEngNm = vndrLglEngNm;
        this.deltFlg = deltFlg;
        this.pagerows = pagerows;
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
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("pagerows", getPagerows());
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
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("pagerows", "pagerows");
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
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 * Column Info
	 * @return vndrLglEngNm
	 */
    public String getVndrLglEngNm() {
        return this.vndrLglEngNm;
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
	 * @return deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
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
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * Column Info
	 * @param vndrLglEngNm
	 */
    public void setVndrLglEngNm(String vndrLglEngNm) {
        this.vndrLglEngNm = vndrLglEngNm;
    }

    /**
	 * Column Info
	 * @param deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
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
        setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
        setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
        setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setCnlAgnFlg(JSPUtil.getParameter(request, "cnl_agn_flg", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
        setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DefaultVendorVO[]
	 */
    public DefaultVendorVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DefaultVendorVO[]
	 */
    public DefaultVendorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        DefaultVendorVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd".trim(), length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq".trim(), length));
            String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm".trim(), length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] cnlAgnFlg = (JSPUtil.getParameter(request, prefix + "cnl_agn_flg", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
	    	String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
	    	String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new DefaultVendorVO();
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (vndrLglEngNm[i] != null)
                    model.setVndrLglEngNm(vndrLglEngNm[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
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
        return getDefaultVendorVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return DefaultVendorVO[]
	 */
    public DefaultVendorVO[] getDefaultVendorVOs() {
        DefaultVendorVO[] vos = (DefaultVendorVO[]) models.toArray(new DefaultVendorVO[models.size()]);
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
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrLglEngNm = this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnlAgnFlg = this.cnlAgnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
