/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VendorContactVO.java
*@FileTitle : VendorContactVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2011.03.07  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class VendorCheckDeliveryIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<VendorCheckDeliveryIfVO> models = new ArrayList<VendorCheckDeliveryIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String chkDeAddr1 = null;

    /* Column Info */
    private String chkDeAddr2 = null;

    /* Column Info */
    private String chkDeAddr3 = null;

    /* Column Info */
    private String chkDeCtyNm = null;

    /* Column Info */
    private String chkDeSteCd = null;

    /* Column Info */
    private String chkDeZipCd = null;

    /* Column Info */
    private String chkDeCntCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String cudFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public VendorCheckDeliveryIfVO() {
    }

    public VendorCheckDeliveryIfVO(String ibflag, String vndrSeq, String chkDeAddr1, String chkDeAddr2, String chkDeAddr3, String chkDeCtyNm, String chkDeSteCd, String chkDeZipCd, String chkDeCntCd, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String usrId, String cudFlg) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.vndrSeq = vndrSeq;
        this.chkDeAddr1 = chkDeAddr1;
        this.chkDeAddr2 = chkDeAddr2;
        this.chkDeAddr3 = chkDeAddr3;
        this.chkDeCtyNm = chkDeCtyNm;
        this.chkDeSteCd = chkDeSteCd;
        this.chkDeZipCd = chkDeZipCd;
        this.chkDeCntCd = chkDeCntCd;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.usrId = usrId;
        this.cudFlg = cudFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("chk_de_addr1", getChkDeAddr1());
        this.hashColumns.put("chk_de_addr2", getChkDeAddr2());
        this.hashColumns.put("chk_de_addr3", getChkDeAddr3());
        this.hashColumns.put("chk_de_cty_nm", getChkDeCtyNm());
        this.hashColumns.put("chk_de_ste_cd", getChkDeSteCd());
        this.hashColumns.put("chk_de_zip_cd", getChkDeZipCd());
        this.hashColumns.put("chk_de_cnt_cd", getChkDeCntCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("cud_flg", getCudFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("chk_de_addr1", "chkDeAddr1");
        this.hashFields.put("chk_de_addr2", "chkDeAddr2");
        this.hashFields.put("chk_de_addr3", "chkDeAddr3");
        this.hashFields.put("chk_de_cty_nm", "chkDeCtyNm");
        this.hashFields.put("chk_de_ste_cd", "chkDeSteCd");
        this.hashFields.put("chk_de_zip_cd", "chkDeZipCd");
        this.hashFields.put("chk_de_cnt_cd", "chkDeCntCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("cud_flg", "cudFlg");
        return this.hashFields;
    }

    /**
	 *
	 * @param String ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * 
	 * @return String ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 *
	 * @param String pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * 
	 * @return String pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    public String getVndrSeq() {
        return this.vndrSeq;
    }

    public void setChkDeAddr1(String chkDeAddr1) {
        this.chkDeAddr1 = chkDeAddr1;
    }

    public String getChkDeAddr1() {
        return this.chkDeAddr1;
    }

    public void setChkDeAddr2(String chkDeAddr2) {
        this.chkDeAddr2 = chkDeAddr2;
    }

    public String getChkDeAddr2() {
        return this.chkDeAddr2;
    }

    public void setChkDeAddr3(String chkDeAddr3) {
        this.chkDeAddr3 = chkDeAddr3;
    }

    public String getChkDeAddr3() {
        return this.chkDeAddr3;
    }

    public void setChkDeCtyNm(String chkDeCtyNm) {
        this.chkDeCtyNm = chkDeCtyNm;
    }

    public String getChkDeCtyNm() {
        return this.chkDeCtyNm;
    }

    public void setChkDeSteCd(String chkDeSteCd) {
        this.chkDeSteCd = chkDeSteCd;
    }

    public String getChkDeSteCd() {
        return this.chkDeSteCd;
    }

    public void setChkDeZipCd(String chkDeZipCd) {
        this.chkDeZipCd = chkDeZipCd;
    }

    public String getChkDeZipCd() {
        return this.chkDeZipCd;
    }

    public void setChkDeCntCd(String chkDeCntCd) {
        this.chkDeCntCd = chkDeCntCd;
    }

    public String getChkDeCntCd() {
        return this.chkDeCntCd;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public String getCreDt() {
        return this.creDt;
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

    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    public String getDeltFlg() {
        return this.deltFlg;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrId() {
        return this.usrId;
    }

    public void setCudFlg(String cudFlg) {
        this.cudFlg = cudFlg;
    }

    public String getCudFlg() {
        return this.cudFlg;
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
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setChkDeAddr1(JSPUtil.getParameter(request, prefix + "chk_de_addr1", ""));
        setChkDeAddr2(JSPUtil.getParameter(request, prefix + "chk_de_addr2", ""));
        setChkDeAddr3(JSPUtil.getParameter(request, prefix + "chk_de_addr3", ""));
        setChkDeCtyNm(JSPUtil.getParameter(request, prefix + "chk_de_cty_nm", ""));
        setChkDeSteCd(JSPUtil.getParameter(request, prefix + "chk_de_ste_cd", ""));
        setChkDeZipCd(JSPUtil.getParameter(request, prefix + "chk_de_zip_cd", ""));
        setChkDeCntCd(JSPUtil.getParameter(request, prefix + "chk_de_cnt_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setCudFlg(JSPUtil.getParameter(request, prefix + "cud_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VendorIfVO[]
	 */
    public VendorCheckDeliveryIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VendorIfVO[]
	 */
    public VendorCheckDeliveryIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        VendorCheckDeliveryIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
	    	String[] chkDeAddr1 = (JSPUtil.getParameter(request, prefix + "chk_de_addr1", length));
	    	String[] chkDeAddr2 = (JSPUtil.getParameter(request, prefix + "chk_de_addr2", length));
	    	String[] chkDeAddr3 = (JSPUtil.getParameter(request, prefix + "chk_de_addr3", length));
	    	String[] chkDeCtyNm = (JSPUtil.getParameter(request, prefix + "chk_de_cty_nm", length));
	    	String[] chkDeSteCd = (JSPUtil.getParameter(request, prefix + "chk_de_ste_cd", length));
	    	String[] chkDeZipCd = (JSPUtil.getParameter(request, prefix + "chk_de_zip_cd", length));
	    	String[] chkDeCntCd = (JSPUtil.getParameter(request, prefix + "chk_de_cnt_cd", length));
	    	String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
	    	String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
	    	String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
	    	String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
	    	String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
	    	String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
	    	String[] cudFlg = (JSPUtil.getParameter(request, prefix + "cud_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new VendorCheckDeliveryIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vndrSeq[i] != null) 
		    		model.setVndrSeq(vndrSeq[i]);
				if (chkDeAddr1[i] != null) 
		    		model.setChkDeAddr1(chkDeAddr1[i]);
				if (chkDeAddr2[i] != null) 
		    		model.setChkDeAddr2(chkDeAddr2[i]);
				if (chkDeAddr3[i] != null) 
		    		model.setChkDeAddr3(chkDeAddr3[i]);
				if (chkDeCtyNm[i] != null) 
		    		model.setChkDeCtyNm(chkDeCtyNm[i]);
				if (chkDeSteCd[i] != null) 
		    		model.setChkDeSteCd(chkDeSteCd[i]);
				if (chkDeZipCd[i] != null) 
		    		model.setChkDeZipCd(chkDeZipCd[i]);
				if (chkDeCntCd[i] != null) 
		    		model.setChkDeCntCd(chkDeCntCd[i]);
				if (creUsrId[i] != null) 
		    		model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null) 
		    		model.setCreDt(creDt[i]);
				if (updUsrId[i] != null) 
		    		model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
		    		model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null) 
		    		model.setDeltFlg(deltFlg[i]);
				if (usrId[i] != null) 
		    		model.setUsrId(usrId[i]);
				if (cudFlg[i] != null) 
		    		model.setCudFlg(cudFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getVendorCheckDeliveryIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return VendorCheckDeliveryIfVO[]
	 */
    public VendorCheckDeliveryIfVO[] getVendorCheckDeliveryIfVOs() {
        VendorCheckDeliveryIfVO[] vos = (VendorCheckDeliveryIfVO[]) models.toArray(new VendorCheckDeliveryIfVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
    public void unDataFormat() {
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeAddr1 = this.chkDeAddr1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeAddr2 = this.chkDeAddr2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeAddr3 = this.chkDeAddr3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeCtyNm = this.chkDeCtyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeSteCd = this.chkDeSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeZipCd = this.chkDeZipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDeCntCd = this.chkDeCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cudFlg = this.cudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
