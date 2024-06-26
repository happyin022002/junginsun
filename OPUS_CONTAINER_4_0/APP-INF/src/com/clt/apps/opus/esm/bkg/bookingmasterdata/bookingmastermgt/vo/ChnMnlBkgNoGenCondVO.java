/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChnMnlBkgNoGenListCondVO.java
*@FileTitle : ChnMnlBkgNoGenListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.09.18 민동진 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 민동진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ChnMnlBkgNoGenCondVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ChnMnlBkgNoGenCondVO> models = new ArrayList<ChnMnlBkgNoGenCondVO>();

    /* Column Info */
    private String noOfBkg = null;

    /* Column Info */
    private String fmCreDt = null;

    /* Column Info */
    private String docUsrId = null;

    /* Column Info */
    private String actCreOfcCd = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creOfcCd = null;

    /* Column Info */
    private String bkgCreDt = null;

    /* Column Info */
    private String actCreUsrId = null;

    /* Column Info */
    private String chnAgnCd = null;

    /* Column Info */
    private String bkgNoUseFlg = null;

    /* Column Info */
    private String actChnAgnCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String toCreDt = null;

    /* Column Info */
    private String agnFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ChnMnlBkgNoGenCondVO() {
    }

    public ChnMnlBkgNoGenCondVO(String ibflag, String pagerows, String bkgNo, String chnAgnCd, String bkgNoUseFlg, String bkgCreDt, String creOfcCd, String docUsrId, String creUsrId, String updUsrId, String fmCreDt, String toCreDt, String noOfBkg, String actChnAgnCd, String actCreOfcCd, String actCreUsrId, String agnFlg) {
        this.noOfBkg = noOfBkg;
        this.fmCreDt = fmCreDt;
        this.docUsrId = docUsrId;
        this.actCreOfcCd = actCreOfcCd;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.bkgNo = bkgNo;
        this.creUsrId = creUsrId;
        this.creOfcCd = creOfcCd;
        this.bkgCreDt = bkgCreDt;
        this.actCreUsrId = actCreUsrId;
        this.chnAgnCd = chnAgnCd;
        this.bkgNoUseFlg = bkgNoUseFlg;
        this.actChnAgnCd = actChnAgnCd;
        this.updUsrId = updUsrId;
        this.toCreDt = toCreDt;
        this.agnFlg = agnFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("no_of_bkg", getNoOfBkg());
        this.hashColumns.put("fm_cre_dt", getFmCreDt());
        this.hashColumns.put("doc_usr_id", getDocUsrId());
        this.hashColumns.put("act_cre_ofc_cd", getActCreOfcCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
        this.hashColumns.put("act_cre_usr_id", getActCreUsrId());
        this.hashColumns.put("chn_agn_cd", getChnAgnCd());
        this.hashColumns.put("bkg_no_use_flg", getBkgNoUseFlg());
        this.hashColumns.put("act_chn_agn_cd", getactChnAgnCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("to_cre_dt", getToCreDt());
        this.hashColumns.put("agn_flg", getAgnFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("no_of_bkg", "noOfBkg");
        this.hashFields.put("fm_cre_dt", "fmCreDt");
        this.hashFields.put("doc_usr_id", "docUsrId");
        this.hashFields.put("act_cre_ofc_cd", "actCreOfcCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("bkg_cre_dt", "bkgCreDt");
        this.hashFields.put("act_cre_usr_id", "actCreUsrId");
        this.hashFields.put("chn_agn_cd", "chnAgnCd");
        this.hashFields.put("bkg_no_use_flg", "bkgNoUseFlg");
        this.hashFields.put("act_chn_agn_cd", "actChnAgnCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("to_cre_dt", "toCreDt");
        this.hashFields.put("agn_flg", "agnFlg");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return noOfBkg
	 */
    public String getNoOfBkg() {
        return this.noOfBkg;
    }

    /**
	 * Column Info
	 * @return fmCreDt
	 */
    public String getFmCreDt() {
        return this.fmCreDt;
    }

    /**
	 * Column Info
	 * @return docUsrId
	 */
    public String getDocUsrId() {
        return this.docUsrId;
    }

    /**
	 * Column Info
	 * @return actCreOfcCd
	 */
    public String getActCreOfcCd() {
        return this.actCreOfcCd;
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
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return creOfcCd
	 */
    public String getCreOfcCd() {
        return this.creOfcCd;
    }

    /**
	 * Column Info
	 * @return bkgCreDt
	 */
    public String getBkgCreDt() {
        return this.bkgCreDt;
    }

    /**
	 * Column Info
	 * @return actCreUsrId
	 */
    public String getActCreUsrId() {
        return this.actCreUsrId;
    }

    /**
	 * Column Info
	 * @return chnAgnCd
	 */
    public String getChnAgnCd() {
        return this.chnAgnCd;
    }

    /**
	 * Column Info
	 * @return bkgNoUseFlg
	 */
    public String getBkgNoUseFlg() {
        return this.bkgNoUseFlg;
    }

    /**
	 * Column Info
	 * @return actChnAgnCd
	 */
    public String getactChnAgnCd() {
        return this.actChnAgnCd;
    }

    /**
	 * Column Info
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 * Column Info
	 * @return toCreDt
	 */
    public String getToCreDt() {
        return this.toCreDt;
    }

    /**
	 * Column Info
	 * @param noOfBkg
	 */
    public void setNoOfBkg(String noOfBkg) {
        this.noOfBkg = noOfBkg;
    }

    /**
	 * Column Info
	 * @param fmCreDt
	 */
    public void setFmCreDt(String fmCreDt) {
        this.fmCreDt = fmCreDt;
    }

    /**
	 * Column Info
	 * @param docUsrId
	 */
    public void setDocUsrId(String docUsrId) {
        this.docUsrId = docUsrId;
    }

    /**
	 * Column Info
	 * @param actCreOfcCd
	 */
    public void setActCreOfcCd(String actCreOfcCd) {
        this.actCreOfcCd = actCreOfcCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
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
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param creOfcCd
	 */
    public void setCreOfcCd(String creOfcCd) {
        this.creOfcCd = creOfcCd;
    }

    /**
	 * Column Info
	 * @param bkgCreDt
	 */
    public void setBkgCreDt(String bkgCreDt) {
        this.bkgCreDt = bkgCreDt;
    }

    /**
	 * Column Info
	 * @param actCreUsrId
	 */
    public void setActCreUsrId(String actCreUsrId) {
        this.actCreUsrId = actCreUsrId;
    }

    /**
	 * Column Info
	 * @param chnAgnCd
	 */
    public void setChnAgnCd(String chnAgnCd) {
        this.chnAgnCd = chnAgnCd;
    }

    /**
	 * Column Info
	 * @param bkgNoUseFlg
	 */
    public void setBkgNoUseFlg(String bkgNoUseFlg) {
        this.bkgNoUseFlg = bkgNoUseFlg;
    }

    /**
	 * Column Info
	 * @param actChnAgnCd
	 */
    public void setactChnAgnCd(String actChnAgnCd) {
        this.actChnAgnCd = actChnAgnCd;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param toCreDt
	 */
    public void setToCreDt(String toCreDt) {
        this.toCreDt = toCreDt;
    }

    public void setAgnFlg(String agnFlg) {
        this.agnFlg = agnFlg;
    }

    public String getAgnFlg() {
        return this.agnFlg;
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
        setNoOfBkg(JSPUtil.getParameter(request, prefix + "no_of_bkg", ""));
        setFmCreDt(JSPUtil.getParameter(request, prefix + "fm_cre_dt", ""));
        setDocUsrId(JSPUtil.getParameter(request, prefix + "doc_usr_id", ""));
        setActCreOfcCd(JSPUtil.getParameter(request, prefix + "act_cre_ofc_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
        setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
        setActCreUsrId(JSPUtil.getParameter(request, prefix + "act_cre_usr_id", ""));
        setChnAgnCd(JSPUtil.getParameter(request, prefix + "chn_agn_cd", ""));
        setBkgNoUseFlg(JSPUtil.getParameter(request, prefix + "bkg_no_use_flg", ""));
        setactChnAgnCd(JSPUtil.getParameter(request, prefix + "act_chn_agn_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setToCreDt(JSPUtil.getParameter(request, prefix + "to_cre_dt", ""));
        setAgnFlg(JSPUtil.getParameter(request, prefix + "agn_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChnMnlBkgNoGenCondVO[]
	 */
    public ChnMnlBkgNoGenCondVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChnMnlBkgNoGenCondVO[]
	 */
    public ChnMnlBkgNoGenCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ChnMnlBkgNoGenCondVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] noOfBkg = (JSPUtil.getParameter(request, prefix + "no_of_bkg", length));
            String[] fmCreDt = (JSPUtil.getParameter(request, prefix + "fm_cre_dt", length));
            String[] docUsrId = (JSPUtil.getParameter(request, prefix + "doc_usr_id", length));
            String[] actCreOfcCd = (JSPUtil.getParameter(request, prefix + "act_cre_ofc_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] bkgCreDt = (JSPUtil.getParameter(request, prefix + "bkg_cre_dt", length));
            String[] actCreUsrId = (JSPUtil.getParameter(request, prefix + "act_cre_usr_id", length));
            String[] chnAgnCd = (JSPUtil.getParameter(request, prefix + "chn_agn_cd", length));
            String[] bkgNoUseFlg = (JSPUtil.getParameter(request, prefix + "bkg_no_use_flg", length));
            String[] actChnAgnCd = (JSPUtil.getParameter(request, prefix + "act_chn_agn_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] toCreDt = (JSPUtil.getParameter(request, prefix + "to_cre_dt", length));
            String[] agnFlg = (JSPUtil.getParameter(request, prefix + "agn_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ChnMnlBkgNoGenCondVO();
                if (noOfBkg[i] != null)
                    model.setNoOfBkg(noOfBkg[i]);
                if (fmCreDt[i] != null)
                    model.setFmCreDt(fmCreDt[i]);
                if (docUsrId[i] != null)
                    model.setDocUsrId(docUsrId[i]);
                if (actCreOfcCd[i] != null)
                    model.setActCreOfcCd(actCreOfcCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (bkgCreDt[i] != null)
                    model.setBkgCreDt(bkgCreDt[i]);
                if (actCreUsrId[i] != null)
                    model.setActCreUsrId(actCreUsrId[i]);
                if (chnAgnCd[i] != null)
                    model.setChnAgnCd(chnAgnCd[i]);
                if (bkgNoUseFlg[i] != null)
                    model.setBkgNoUseFlg(bkgNoUseFlg[i]);
                if (actChnAgnCd[i] != null)
                    model.setactChnAgnCd(actChnAgnCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (toCreDt[i] != null)
                    model.setToCreDt(toCreDt[i]);
                if (agnFlg[i] != null) 
		    		model.setAgnFlg(agnFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getChnMnlBkgNoGenCondVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ChnMnlBkgNoGenCondVO[]
	 */
    public ChnMnlBkgNoGenCondVO[] getChnMnlBkgNoGenCondVOs() {
        ChnMnlBkgNoGenCondVO[] vos = (ChnMnlBkgNoGenCondVO[]) models.toArray(new ChnMnlBkgNoGenCondVO[models.size()]);
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
        this.noOfBkg = this.noOfBkg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmCreDt = this.fmCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docUsrId = this.docUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actCreOfcCd = this.actCreOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCreDt = this.bkgCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actCreUsrId = this.actCreUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chnAgnCd = this.chnAgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNoUseFlg = this.bkgNoUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actChnAgnCd = this.actChnAgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toCreDt = this.toCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agnFlg = this.agnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
