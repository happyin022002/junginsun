/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchBlESignatureListVO.java
*@FileTitle : SearchBlESignatureListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo;

import java.lang.reflect.Field;
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
public class PlaceOfIssueAssociationVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PlaceOfIssueAssociationVO> models = new ArrayList<PlaceOfIssueAssociationVO>();

    /* Column Info */
    /* Column Info */
    private String blEsigAsgnSeq = null;

    /* Column Info */
    private String regionNm = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String blIssOfcNm = null;

    /* Column Info */
    private String blIssOfcCd = null;

    /* Column Info */
    private String issOfcEmpNm = null;

    /* Column Info */
    private String agnCoNm1 = null;

    /* Column Info */
    private String agnCoNm2 = null;

    /* Column Info */
    private String agnCoNm3 = null;

    /* Column Info */
    private String blEsigSeq = null;

    /* Column Info */
    private String blEsigRmk = null;

    /* Column Info */
    private String empCd = null;

    /* Column Info */
    private String empNm = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String blEsigFlg = null;

    /* Column Info */
    private String blCpyEsigFlg = null;

    /* Column Info */
    private String blKntFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public PlaceOfIssueAssociationVO() {
    }

    public PlaceOfIssueAssociationVO(String ibflag, String pagerows, String blEsigAsgnSeq, String regionNm, String cntCd, String blIssOfcNm, String blIssOfcCd, String issOfcEmpNm, String agnCoNm1, String agnCoNm2, String agnCoNm3, String blEsigSeq, String blEsigRmk, String empCd, String empNm, String blEsigFlg, String blCpyEsigFlg, String blKntFlg) {
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.blEsigAsgnSeq = blEsigAsgnSeq;
        this.regionNm = regionNm;
        this.cntCd = cntCd;
        this.blIssOfcNm = blIssOfcNm;
        this.blIssOfcCd = blIssOfcCd;
        this.issOfcEmpNm = issOfcEmpNm;
        this.agnCoNm1 = agnCoNm1;
        this.agnCoNm2 = agnCoNm2;
        this.agnCoNm3 = agnCoNm3;
        this.blEsigSeq = blEsigSeq;
        this.blEsigRmk = blEsigRmk;
        this.empCd = empCd;
        this.empNm = empNm;
        this.blEsigFlg = blEsigFlg;
        this.blCpyEsigFlg = blCpyEsigFlg;
        this.blKntFlg = blKntFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("bl_esig_asgn_seq", getBlEsigAsgnSeq());
        this.hashColumns.put("region_nm", getRegionNm());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("bl_iss_ofc_nm", getBlIssOfcNm());
        this.hashColumns.put("bl_iss_ofc_cd", getBlIssOfcCd());
        this.hashColumns.put("iss_ofc_emp_nm", getIssOfcEmpNm());
        this.hashColumns.put("agn_co_nm1", getAgnCoNm1());
        this.hashColumns.put("agn_co_nm2", getAgnCoNm2());
        this.hashColumns.put("agn_co_nm3", getAgnCoNm3());
        this.hashColumns.put("bl_esig_seq", getBlEsigSeq());
        this.hashColumns.put("bl_esig_rmk", getBlEsigRmk());
        this.hashColumns.put("emp_cd", getEmpCd());
        this.hashColumns.put("emp_nm", getEmpNm());
        this.hashColumns.put("bl_esig_flg", getBlEsigFlg());
        this.hashColumns.put("bl_cpy_esig_flg", getBlCpyEsigFlg());
        this.hashColumns.put("bl_knt_flg", getBlKntFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("bl_esig_asgn_seq", "blEsigAsgnSeq");
        this.hashFields.put("region_nm", "regionNm");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("bl_iss_ofc_nm", "blIssOfcNm");
        this.hashFields.put("bl_iss_ofc_cd", "blIssOfcCd");
        this.hashFields.put("iss_ofc_emp_nm", "issOfcEmpNm");
        this.hashFields.put("agn_co_nm1", "agnCoNm1");
        this.hashFields.put("agn_co_nm2", "agnCoNm2");
        this.hashFields.put("agn_co_nm3", "agnCoNm3");
        this.hashFields.put("bl_esig_seq", "blEsigSeq");
        this.hashFields.put("bl_esig_rmk", "blEsigRmk");
        this.hashFields.put("emp_cd", "empCd");
        this.hashFields.put("emp_nm", "empNm");
        this.hashFields.put("bl_esig_flg", "blEsigFlg");
        this.hashFields.put("bl_cpy_esig_flg", "blCpyEsigFlg");
        this.hashFields.put("bl_knt_flg", "blKntFlg");
        return this.hashFields;
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
	 * @return blEsigAsgnSeq
	 */
    public String getBlEsigAsgnSeq() {
        return this.blEsigAsgnSeq;
    }

    /**
	 * Column Info
	 * @return regionNm
	 * @author SJH.20141114.ADD
	 */
    public String getRegionNm() {
        return this.regionNm;
    }

    /**
	 * Column Info
	 * @return cntCd
	 */
    public String getCntCd() {
        return this.cntCd;
    }

    /**
	 * Column Info
	 * @return blIssOfcNm
	 */
    public String getBlIssOfcNm() {
        return this.blIssOfcNm;
    }

    /**
	 * Column Info
	 * @return blIssOfcCd
	 */
    public String getBlIssOfcCd() {
        return this.blIssOfcCd;
    }

    /**
	 * Column Info
	 * @return issOfcEmpNm
	 */
    public String getIssOfcEmpNm() {
        return this.issOfcEmpNm;
    }

    /**
	 * Column Info
	 * @return agnCoNm1
	 */
    public String getAgnCoNm1() {
        return this.agnCoNm1;
    }

    /**
	 * Column Info
	 * @return agnCoNm2
	 */
    public String getAgnCoNm2() {
        return this.agnCoNm2;
    }

    /**
	 * Column Info
	 * @return agnCoNm3
	 */
    public String getAgnCoNm3() {
        return this.agnCoNm3;
    }

    /**
	 * Column Info
	 * @return blEsigSeq
	 */
    public String getBlEsigSeq() {
        return this.blEsigSeq;
    }

    /**
	 * Column Info
	 * @return blEsigRmk
	 */
    public String getBlEsigRmk() {
        return this.blEsigRmk;
    }

    /**
	 * Column Info
	 * @return empCd
	 */
    public String getEmpCd() {
        return this.empCd;
    }

    /**
	 * Column Info
	 * @return empNm
	 */
    public String getEmpNm() {
        return this.empNm;
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
	 * @param blEsigAsgnSeq
	 */
    public void setBlEsigAsgnSeq(String blEsigAsgnSeq) {
        this.blEsigAsgnSeq = blEsigAsgnSeq;
    }

    /**
	 * Column Info
	 * @param regionNm
	 * @author SJH.20141114.ADD
	 */
    public void setRegionNm(String regionNm) {
        this.regionNm = regionNm;
    }

    /**
	 * Column Info
	 * @param cntCd
	 */
    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
    }

    /**
	 * Column Info
	 * @param blIssOfcNm
	 */
    public void setBlIssOfcNm(String blIssOfcNm) {
        this.blIssOfcNm = blIssOfcNm;
    }

    /**
	 * Column Info
	 * @param blIssOfcCd
	 */
    public void setBlIssOfcCd(String blIssOfcCd) {
        this.blIssOfcCd = blIssOfcCd;
    }

    /**
	 * Column Info
	 * @param issOfcEmpNm
	 */
    public void setIssOfcEmpNm(String issOfcEmpNm) {
        this.issOfcEmpNm = issOfcEmpNm;
    }

    /**
	 * Column Info
	 * @param agnCoNm1
	 */
    public void setAgnCoNm1(String agnCoNm1) {
        this.agnCoNm1 = agnCoNm1;
    }

    /**
	 * Column Info
	 * @param agnCoNm2
	 */
    public void setAgnCoNm2(String agnCoNm2) {
        this.agnCoNm2 = agnCoNm2;
    }

    /**
	 * Column Info
	 * @param agnCoNm3
	 */
    public void setAgnCoNm3(String agnCoNm3) {
        this.agnCoNm3 = agnCoNm3;
    }

    /**
	 * Column Info
	 * @param blEsigSeq
	 */
    public void setBlEsigSeq(String blEsigSeq) {
        this.blEsigSeq = blEsigSeq;
    }

    /**
	 * Column Info
	 * @param blEsigRmk
	 */
    public void setBlEsigRmk(String blEsigRmk) {
        this.blEsigRmk = blEsigRmk;
    }

    /**
	 * Column Info
	 * @param empCd
	 */
    public void setEmpCd(String empCd) {
        this.empCd = empCd;
    }

    /**
	 * Column Info
	 * @param empNm
	 */
    public void setEmpNm(String empNm) {
        this.empNm = empNm;
    }

    public void setBlEsigFlg(String blEsigFlg) {
        this.blEsigFlg = blEsigFlg;
    }

    public String getBlEsigFlg() {
        return this.blEsigFlg;
    }

    public void setBlCpyEsigFlg(String blCpyEsigFlg) {
        this.blCpyEsigFlg = blCpyEsigFlg;
    }

    public String getBlCpyEsigFlg() {
        return this.blCpyEsigFlg;
    }

    public void setBlKntFlg(String blKntFlg) {
        this.blKntFlg = blKntFlg;
    }

    public String getBlKntFlg() {
        return this.blKntFlg;
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
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setBlEsigAsgnSeq(JSPUtil.getParameter(request, prefix + "bl_esig_asgn_seq", ""));
        setRegionNm(JSPUtil.getParameter(request, prefix + "init_file_path_rmk", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setBlIssOfcNm(JSPUtil.getParameter(request, prefix + "bl_iss_ofc_nm", ""));
        setBlIssOfcCd(JSPUtil.getParameter(request, prefix + "bl_iss_ofc_cd", ""));
        setIssOfcEmpNm(JSPUtil.getParameter(request, prefix + "iss_ofc_emp_nm", ""));
        setAgnCoNm1(JSPUtil.getParameter(request, prefix + "agn_co_nm1", ""));
        setAgnCoNm2(JSPUtil.getParameter(request, prefix + "agn_co_nm2", ""));
        setAgnCoNm3(JSPUtil.getParameter(request, prefix + "agn_co_nm3", ""));
        setBlEsigSeq(JSPUtil.getParameter(request, prefix + "bl_esig_seq", ""));
        setBlEsigRmk(JSPUtil.getParameter(request, prefix + "bl_esig_rmk", ""));
        setEmpCd(JSPUtil.getParameter(request, prefix + "emp_cd", ""));
        setEmpNm(JSPUtil.getParameter(request, prefix + "emp_nm", ""));
        setBlEsigFlg(JSPUtil.getParameter(request, prefix + "bl_esig_flg", ""));
        setBlCpyEsigFlg(JSPUtil.getParameter(request, prefix + "bl_cpy_esig_flg", ""));
        setBlKntFlg(JSPUtil.getParameter(request, prefix + "bl_knt_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBlESignatureListVO[]
	 */
    public PlaceOfIssueAssociationVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlESignatureVO[]
	 */
    public PlaceOfIssueAssociationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PlaceOfIssueAssociationVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] blEsigAsgnSeq = (JSPUtil.getParameter(request, prefix + "bl_esig_asgn_seq", length));
            String[] regionNm = (JSPUtil.getParameter(request, prefix + "region_nm", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] blIssOfcNm = (JSPUtil.getParameter(request, prefix + "bl_iss_ofc_nm", length));
            String[] blIssOfcCd = (JSPUtil.getParameter(request, prefix + "bl_iss_ofc_cd", length));
            String[] issOfcEmpNm = (JSPUtil.getParameter(request, prefix + "iss_ofc_emp_nm", length));
            String[] agnCoNm1 = (JSPUtil.getParameter(request, prefix + "agn_co_nm1", length));
            String[] agnCoNm2 = (JSPUtil.getParameter(request, prefix + "agn_co_nm2", length));
            String[] agnCoNm3 = (JSPUtil.getParameter(request, prefix + "agn_co_nm3", length));
            String[] blEsigSeq = (JSPUtil.getParameter(request, prefix + "bl_esig_seq", length));
            String[] blEsigRmk = (JSPUtil.getParameter(request, prefix + "bl_esig_rmk", length));
            String[] empCd = (JSPUtil.getParameter(request, prefix + "emp_cd", length));
            String[] empNm = (JSPUtil.getParameter(request, prefix + "emp_nm", length));
            String[] blEsigFlg = (JSPUtil.getParameter(request, prefix + "bl_esig_flg", length));
	    	String[] blCpyEsigFlg = (JSPUtil.getParameter(request, prefix + "bl_cpy_esig_flg", length));
	    	String[] blKntFlg = (JSPUtil.getParameter(request, prefix + "bl_knt_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new PlaceOfIssueAssociationVO();
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (blEsigAsgnSeq[i] != null)
                    model.setBlEsigAsgnSeq(blEsigAsgnSeq[i]);
                if (regionNm[i] != null)
                    model.setRegionNm(regionNm[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (blIssOfcNm[i] != null)
                    model.setBlIssOfcNm(blIssOfcNm[i]);
                if (blIssOfcCd[i] != null)
                    model.setBlIssOfcCd(blIssOfcCd[i]);
                if (issOfcEmpNm[i] != null)
                    model.setIssOfcEmpNm(issOfcEmpNm[i]);
                if (agnCoNm1[i] != null)
                    model.setAgnCoNm1(agnCoNm1[i]);
                if (agnCoNm2[i] != null)
                    model.setAgnCoNm2(agnCoNm2[i]);
                if (agnCoNm3[i] != null)
                    model.setAgnCoNm3(agnCoNm3[i]);
                if (blEsigSeq[i] != null)
                    model.setBlEsigSeq(blEsigSeq[i]);
                if (blEsigRmk[i] != null)
                    model.setBlEsigRmk(blEsigRmk[i]);
                if (empCd[i] != null)
                    model.setEmpCd(empCd[i]);
                if (empNm[i] != null)
                    model.setEmpNm(empNm[i]);
                if (blEsigFlg[i] != null) 
		    		model.setBlEsigFlg(blEsigFlg[i]);
				if (blCpyEsigFlg[i] != null) 
		    		model.setBlCpyEsigFlg(blCpyEsigFlg[i]);
				if (blKntFlg[i] != null) 
		    		model.setBlKntFlg(blKntFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchBlESignatureListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BlESignatureVO[]
	 */
    public PlaceOfIssueAssociationVO[] getSearchBlESignatureListVOs() {
        PlaceOfIssueAssociationVO[] vos = (PlaceOfIssueAssociationVO[]) models.toArray(new PlaceOfIssueAssociationVO[models.size()]);
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
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blEsigAsgnSeq = this.blEsigAsgnSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.regionNm = this.regionNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blIssOfcNm = this.blIssOfcNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blIssOfcCd = this.blIssOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issOfcEmpNm = this.issOfcEmpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agnCoNm1 = this.agnCoNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agnCoNm2 = this.agnCoNm2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agnCoNm3 = this.agnCoNm3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blEsigSeq = this.blEsigSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blEsigRmk = this.blEsigRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.empCd = this.empCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.empNm = this.empNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blEsigFlg = this.blEsigFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blCpyEsigFlg = this.blCpyEsigFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blKntFlg = this.blKntFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
