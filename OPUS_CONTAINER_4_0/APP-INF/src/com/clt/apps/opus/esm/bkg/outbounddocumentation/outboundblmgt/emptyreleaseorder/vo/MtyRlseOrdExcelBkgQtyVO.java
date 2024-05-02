/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MtyRlseOrdExcelDownLoadVO.java
*@FileTitle : MtyRlseOrdExcelDownLoadVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo;

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
public class MtyRlseOrdExcelBkgQtyVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MtyRlseOrdExcelBkgQtyVO> models = new ArrayList<MtyRlseOrdExcelBkgQtyVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String cntrTpszIsoCd = null;

    /* Column Info */
    private String opCntrQty = null;

    /* Column Info */
    private String socInd = null;

    /* Column Info */
    private String eqSubstCntrTpszCd = null;

    /* Column Info */
    private String chsS = null;

    /* Column Info */
    private String chsD = null;

    /* Column Info */
    private String chsT = null;

    /* Column Info */
    private String mhg = null;

    /* Column Info */
    private String masterBkg = null;
    /* Column Info */
    private String spiltCombine = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public MtyRlseOrdExcelBkgQtyVO() {
    }

    public MtyRlseOrdExcelBkgQtyVO(String ibflag, String pagerows, String bkgNo, String cntrTpszCd, String cntrTpszIsoCd, String opCntrQty, String socInd, String eqSubstCntrTpszCd, String chsS, String chsD, String chsT, String mhg, String masterBkg, String spiltCombine) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.bkgNo = bkgNo;
        this.cntrTpszCd = cntrTpszCd;
        this.cntrTpszIsoCd = cntrTpszIsoCd;
        this.opCntrQty = opCntrQty;
        this.socInd = socInd;
        this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
        this.chsS = chsS;
        this.chsD = chsD;
        this.chsT = chsT;
        this.mhg = mhg;
        this.masterBkg = masterBkg;
        this.spiltCombine = spiltCombine;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("cntr_tpsz_iso_cd", getCntrTpszIsoCd());
        this.hashColumns.put("op_cntr_qty", getOpCntrQty());
        this.hashColumns.put("soc_ind", getSocInd());
        this.hashColumns.put("eq_subst_cntr_tpsz_cd", getEqSubstCntrTpszCd());
        this.hashColumns.put("chs_s", getChsS());
        this.hashColumns.put("chs_d", getChsD());
        this.hashColumns.put("chs_t", getChsT());
        this.hashColumns.put("mhg", getMhg());
        this.hashColumns.put("master_bkg", getMasterBkg());
        this.hashColumns.put("spilt_combine", getSpiltCombine());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("cntr_tpsz_iso_cd", "cntrTpszIsoCd");
        this.hashFields.put("op_cntr_qty", "opCntrQty");
        this.hashFields.put("soc_ind", "socInd");
        this.hashFields.put("eq_subst_cntr_tpsz_cd", "eqSubstCntrTpszCd");
        this.hashFields.put("chs_s", "chsS");
        this.hashFields.put("chs_d", "chsD");
        this.hashFields.put("chs_t", "chsT");
        this.hashFields.put("mhg", "mhg");
        this.hashFields.put("master_bkg", "masterBkg");
        this.hashFields.put("spilt_combine", "spiltCombine");
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
	 * @param String bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * 
	 * @return String bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 *
	 * @param String cntrTpszCd
	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
	 * 
	 * @return String cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    /**
	 *
	 * @param String cntrTpszIsoCd
	 */
    public void setCntrTpszIsoCd(String cntrTpszIsoCd) {
        this.cntrTpszIsoCd = cntrTpszIsoCd;
    }

    /**
	 * 
	 * @return String cntrTpszIsoCd
	 */
    public String getCntrTpszIsoCd() {
        return this.cntrTpszIsoCd;
    }

    /**
	 *
	 * @param String opCntrQty
	 */
    public void setOpCntrQty(String opCntrQty) {
        this.opCntrQty = opCntrQty;
    }

    /**
	 * 
	 * @return String opCntrQty
	 */
    public String getOpCntrQty() {
        return this.opCntrQty;
    }

    /**
	 *
	 * @param String socInd
	 */
    public void setSocInd(String socInd) {
        this.socInd = socInd;
    }

    /**
	 * 
	 * @return String socInd
	 */
    public String getSocInd() {
        return this.socInd;
    }

    /**
	 *
	 * @param String eqSubstCntrTpszCd
	 */
    public void setEqSubstCntrTpszCd(String eqSubstCntrTpszCd) {
        this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
    }

    /**
	 * 
	 * @return String eqSubstCntrTpszCd
	 */
    public String getEqSubstCntrTpszCd() {
        return this.eqSubstCntrTpszCd;
    }

    public void setChsS(String chsS) {
        this.chsS = chsS;
    }

    public String getChsS() {
        return this.chsS;
    }

    public void setChsD(String chsD) {
        this.chsD = chsD;
    }

    public String getChsD() {
        return this.chsD;
    }

    public void setChsT(String chsT) {
        this.chsT = chsT;
    }

    public String getChsT() {
        return this.chsT;
    }

    public void setMhg(String mhg) {
        this.mhg = mhg;
    }

    public String getMhg() {
        return this.mhg;
    }

    /**
	 *
	 * @param String masterBkg
	 */
    public void setMasterBkg(String masterBkg) {
        this.masterBkg = masterBkg;
    }

    /**
	 * 
	 * @return String masterBkg
	 */
    public String getMasterBkg() {
        return this.masterBkg;
    }

    /**
	 *
	 * @param String spiltCombine
	 */
    public void setSpiltCombine(String spiltCombine) {
        this.spiltCombine = spiltCombine;
    }

    /**
	 * 
	 * @return String spiltCombine
	 */
    public String getSpiltCombine() {
        return this.spiltCombine;
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
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setCntrTpszIsoCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_iso_cd", ""));
        setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
        setSocInd(JSPUtil.getParameter(request, prefix + "soc_ind", ""));
        setEqSubstCntrTpszCd(JSPUtil.getParameter(request, prefix + "eq_subst_cntr_tpsz_cd", ""));
        setChsS(JSPUtil.getParameter(request, prefix + "chs_s", ""));
        setChsD(JSPUtil.getParameter(request, prefix + "chs_d", ""));
        setChsT(JSPUtil.getParameter(request, prefix + "chs_t", ""));
        setMhg(JSPUtil.getParameter(request, prefix + "mhg", ""));
        setMasterBkg(JSPUtil.getParameter(request, prefix + "master_bkg", ""));
        setSpiltCombine(JSPUtil.getParameter(request, prefix + "spilt_combine", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyRlseOrdExcelDownLoadVO[]
	 */
    public MtyRlseOrdExcelBkgQtyVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyRlseOrdExcelDownLoadVO[]
	 */
    public MtyRlseOrdExcelBkgQtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MtyRlseOrdExcelBkgQtyVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] cntrTpszIsoCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_iso_cd", length));
            String[] opCntrQty = (JSPUtil.getParameter(request, prefix + "op_cntr_qty", length));
            String[] socInd = (JSPUtil.getParameter(request, prefix + "soc_ind", length));
            String[] eqSubstCntrTpszCd = (JSPUtil.getParameter(request, prefix + "eq_subst_cntr_tpsz_cd", length));
            String[] chsS = (JSPUtil.getParameter(request, prefix + "chs_s", length));
	    	String[] chsD = (JSPUtil.getParameter(request, prefix + "chs_d", length));
	    	String[] chsT = (JSPUtil.getParameter(request, prefix + "chs_t", length));
	    	String[] mhg = (JSPUtil.getParameter(request, prefix + "mhg", length));
	    	String[] masterBkg = (JSPUtil.getParameter(request, prefix + "master_bkg", length));
	    	String[] spiltCombine = (JSPUtil.getParameter(request, prefix + "spilt_combine", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MtyRlseOrdExcelBkgQtyVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (cntrTpszIsoCd[i] != null)
                    model.setCntrTpszIsoCd(cntrTpszIsoCd[i]);
                if (opCntrQty[i] != null)
                    model.setOpCntrQty(opCntrQty[i]);
                if (socInd[i] != null)
                    model.setSocInd(socInd[i]);
                if (eqSubstCntrTpszCd[i] != null)
                    model.setEqSubstCntrTpszCd(eqSubstCntrTpszCd[i]);
                if (chsS[i] != null) 
		    		model.setChsS(chsS[i]);
				if (chsD[i] != null) 
		    		model.setChsD(chsD[i]);
				if (chsT[i] != null) 
		    		model.setChsT(chsT[i]);
				if (mhg[i] != null) 
		    		model.setMhg(mhg[i]);
				if (masterBkg[i] != null) 
		    		model.setMasterBkg(masterBkg[i]);
				if (spiltCombine[i] != null) 
		    		model.setSpiltCombine(spiltCombine[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getMtyRlseOrdExcelDownLoadVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return MtyRlseOrdExcelDownLoadVO[]
	 */
    public MtyRlseOrdExcelBkgQtyVO[] getMtyRlseOrdExcelDownLoadVOs() {
        MtyRlseOrdExcelBkgQtyVO[] vos = (MtyRlseOrdExcelBkgQtyVO[]) models.toArray(new MtyRlseOrdExcelBkgQtyVO[models.size()]);
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
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszIsoCd = this.cntrTpszIsoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opCntrQty = this.opCntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.socInd = this.socInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSubstCntrTpszCd = this.eqSubstCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chsS = this.chsS.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chsD = this.chsD.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chsT = this.chsT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mhg = this.mhg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spiltCombine = this.spiltCombine.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
