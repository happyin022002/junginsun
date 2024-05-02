/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FmsCommonVO.java
*@FileTitle : FmsCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class FmsCommonVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<FmsCommonVO> models = new ArrayList<FmsCommonVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String fletCtrtNo = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String revDirCd = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String vvdCds = null;

    /* Column Info */
    private String comVvdFlg = null;

    /* Column Info */
    private String chkVvdCnt = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String fletCtrtTpCd = null;

    /* Column Info */
    private String effDt = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String slanDirCd = null;

    /* Column Info */
    private String rlaneDirCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String usedYn = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public FmsCommonVO() {
    }

    public FmsCommonVO(String ibflag, String pagerows, String fletCtrtNo, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String vvdCd, String vvdCds, String comVvdFlg, String chkVvdCnt, String acctCd, String fletCtrtTpCd, String effDt, String slanCd, String slanDirCd, String rlaneDirCd, String rlaneCd, String usedYn) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.fletCtrtNo = fletCtrtNo;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.revDirCd = revDirCd;
        this.vvdCd = vvdCd;
        this.vvdCds = vvdCds;
        this.comVvdFlg = comVvdFlg;
        this.chkVvdCnt = chkVvdCnt;
        this.acctCd = acctCd;
        this.fletCtrtTpCd = fletCtrtTpCd;
        this.effDt = effDt;
        this.slanCd = slanCd;
        this.slanDirCd = slanDirCd;
        this.rlaneDirCd = rlaneDirCd;
        this.rlaneCd = rlaneCd;
        this.usedYn = usedYn;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("rev_dir_cd", getRevDirCd());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("vvd_cds", getVvdCds());
        this.hashColumns.put("com_vvd_flg", getComVvdFlg());
        this.hashColumns.put("chk_vvd_cnt", getChkVvdCnt());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
        this.hashColumns.put("eff_dt", getEffDt());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("slan_dir_cd", getSlanDirCd());
        this.hashColumns.put("rlane_dir_cd", getRlaneDirCd());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("used_yn", getUsedYn());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("rev_dir_cd", "revDirCd");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("vvd_cds", "vvdCds");
        this.hashFields.put("com_vvd_flg", "comVvdFlg");
        this.hashFields.put("chk_vvd_cnt", "chkVvdCnt");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
        this.hashFields.put("eff_dt", "effDt");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("slan_dir_cd", "slanDirCd");
        this.hashFields.put("rlane_dir_cd", "rlaneDirCd");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("used_yn", "usedYn");
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

    /**
	 *
	 * @param String fletCtrtNo
	 */
    public void setFletCtrtNo(String fletCtrtNo) {
        this.fletCtrtNo = fletCtrtNo;
    }

    /**
	 * 
	 * @return String fletCtrtNo
	 */
    public String getFletCtrtNo() {
        return this.fletCtrtNo;
    }

    /**
	 *
	 * @param String vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * 
	 * @return String vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 *
	 * @param String skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * 
	 * @return String skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 *
	 * @param String skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * 
	 * @return String skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 *
	 * @param String revDirCd
	 */
    public void setRevDirCd(String revDirCd) {
        this.revDirCd = revDirCd;
    }

    /**
	 * 
	 * @return String revDirCd
	 */
    public String getRevDirCd() {
        return this.revDirCd;
    }

    /**
	 *
	 * @param String vvdCd
	 */
    public void setVvdCd(String vvdCd) {
        this.vvdCd = vvdCd;
    }

    /**
	 * 
	 * @return String vvdCd
	 */
    public String getVvdCd() {
        return this.vvdCd;
    }

    /**
	 *
	 * @param String vvdCds
	 */
    public void setVvdCds(String vvdCds) {
        this.vvdCds = vvdCds;
    }

    /**
	 * 
	 * @return String vvdCds
	 */
    public String getVvdCds() {
        return this.vvdCds;
    }

    /**
	 *
	 * @param String comVvdFlg
	 */
    public void setComVvdFlg(String comVvdFlg) {
        this.comVvdFlg = comVvdFlg;
    }

    /**
	 * 
	 * @return String comVvdFlg
	 */
    public String getComVvdFlg() {
        return this.comVvdFlg;
    }

    /**
	 *
	 * @param String chkVvdCnt
	 */
    public void setChkVvdCnt(String chkVvdCnt) {
        this.chkVvdCnt = chkVvdCnt;
    }

    /**
	 * 
	 * @return String chkVvdCnt
	 */
    public String getChkVvdCnt() {
        return this.chkVvdCnt;
    }

    /**
	 *
	 * @param String acctCd
	 */
    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    /**
	 * 
	 * @return String acctCd
	 */
    public String getAcctCd() {
        return this.acctCd;
    }

    /**
	 *
	 * @param String fletCtrtTpCd
	 */
    public void setFletCtrtTpCd(String fletCtrtTpCd) {
        this.fletCtrtTpCd = fletCtrtTpCd;
    }

    /**
	 * 
	 * @return String fletCtrtTpCd
	 */
    public String getFletCtrtTpCd() {
        return this.fletCtrtTpCd;
    }

    public void setEffDt(String effDt) {
        this.effDt = effDt;
    }

    public String getEffDt() {
        return this.effDt;
    }

    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    public String getSlanCd() {
        return this.slanCd;
    }

    public void setSlanDirCd(String slanDirCd) {
        this.slanDirCd = slanDirCd;
    }

    public String getSlanDirCd() {
        return this.slanDirCd;
    }

    public void setRlaneDirCd(String rlaneDirCd) {
        this.rlaneDirCd = rlaneDirCd;
    }

    public String getRlaneDirCd() {
        return this.rlaneDirCd;
    }

    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
    }

    public String getRlaneCd() {
        return this.rlaneCd;
    }

    public void setUsedYn(String usedYn) {
        this.usedYn = usedYn;
    }

    public String getUsedYn() {
        return this.usedYn;
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
        setFletCtrtNo(JSPUtil.getParameter(request, prefix + "flet_ctrt_no", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
        setVvdCds(JSPUtil.getParameter(request, prefix + "vvd_cds", ""));
        setComVvdFlg(JSPUtil.getParameter(request, prefix + "com_vvd_flg", ""));
        setChkVvdCnt(JSPUtil.getParameter(request, prefix + "chk_vvd_cnt", ""));
        setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
        setFletCtrtTpCd(JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", ""));
        setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setSlanDirCd(JSPUtil.getParameter(request, prefix + "slan_dir_cd", ""));
        setRlaneDirCd(JSPUtil.getParameter(request, prefix + "rlane_dir_cd", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setUsedYn(JSPUtil.getParameter(request, prefix + "used_yn", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FmsCommonVO[]
	 */
    public FmsCommonVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FmsCommonVO[]
	 */
    public FmsCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        FmsCommonVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix + "flet_ctrt_no", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] revDirCd = (JSPUtil.getParameter(request, prefix + "rev_dir_cd", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] vvdCds = (JSPUtil.getParameter(request, prefix + "vvd_cds", length));
            String[] comVvdFlg = (JSPUtil.getParameter(request, prefix + "com_vvd_flg", length));
            String[] chkVvdCnt = (JSPUtil.getParameter(request, prefix + "chk_vvd_cnt", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", length));
            String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
	    	String[] slanDirCd = (JSPUtil.getParameter(request, prefix + "slan_dir_cd", length));
	    	String[] rlaneDirCd = (JSPUtil.getParameter(request, prefix + "rlane_dir_cd", length));
	    	String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
	    	String[] usedYn = (JSPUtil.getParameter(request, prefix + "used_yn", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new FmsCommonVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (fletCtrtNo[i] != null)
                    model.setFletCtrtNo(fletCtrtNo[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (revDirCd[i] != null)
                    model.setRevDirCd(revDirCd[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (vvdCds[i] != null)
                    model.setVvdCds(vvdCds[i]);
                if (comVvdFlg[i] != null)
                    model.setComVvdFlg(comVvdFlg[i]);
                if (chkVvdCnt[i] != null)
                    model.setChkVvdCnt(chkVvdCnt[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (fletCtrtTpCd[i] != null)
                    model.setFletCtrtTpCd(fletCtrtTpCd[i]);
                if (effDt[i] != null)
                    model.setEffDt(effDt[i]);
                if (slanCd[i] != null) 
		    		model.setSlanCd(slanCd[i]);
				if (slanDirCd[i] != null) 
		    		model.setSlanDirCd(slanDirCd[i]);
				if (rlaneDirCd[i] != null) 
		    		model.setRlaneDirCd(rlaneDirCd[i]);
				if (rlaneCd[i] != null) 
		    		model.setRlaneCd(rlaneCd[i]);
				if (usedYn[i] != null) 
		    		model.setUsedYn(usedYn[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getFmsCommonVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return FmsCommonVO[]
	 */
    public FmsCommonVO[] getFmsCommonVOs() {
        FmsCommonVO[] vos = (FmsCommonVO[]) models.toArray(new FmsCommonVO[models.size()]);
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
        this.fletCtrtNo = this.fletCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revDirCd = this.revDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCds = this.vvdCds.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.comVvdFlg = this.comVvdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkVvdCnt = this.chkVvdCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletCtrtTpCd = this.fletCtrtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanDirCd = this.slanDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneDirCd = this.rlaneDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usedYn = this.usedYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
