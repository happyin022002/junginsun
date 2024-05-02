/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpListVO.java
*@FileTitle : SpListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.07.05 함대성 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.serviceprovider.vo;

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
 * @author 함대성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SpListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SpListVO> models = new ArrayList<SpListVO>();

    /* Column Info */
    private String prntVndrSeq = null;

    /* Column Info */
    private String vndrCntCd = null;

    /* Column Info */
    private String engAddr = null;

    /* Column Info */
    private String lgsFlg = null;

    /* Column Info */
    private String pSpType = null;

    /* Column Info */
    private String vndrLglEngNm = null;

    /* Column Info */
    private String vndrCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ofcCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String iPage = null;

    /* Column Info */
    private String vndrNmEng = null;

    /* Column Info */
    private String vndrAbbrNm = null;

    /* Column Info */
    private String ptsVndrCd = null;

    /* Column Info */
    private String orgVndrSeq = null;
	/* Column Info */
	private String idaGstRgstStsCd = null;
	/* Column Info */
	private String idaGstRgstNo = null;
	/* Column Info */
	private String idaSteNm = null;
	/* Column Info */
	private String idaSteCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SpListVO() {
    }

    public SpListVO(String ibflag, String pagerows, String vndrSeq, String ofcCd, String vndrLglEngNm, String vndrAbbrNm, String prntVndrSeq, String vndrCntCd, String orgVndrSeq, String engAddr, String cntCd, String vndrNmEng, String ptsVndrCd, String vndrCd, String pSpType, String lgsFlg, String iPage, String idaGstRgstStsCd, String idaGstRgstNo, String idaSteCd, String idaSteNm) {
        this.prntVndrSeq = prntVndrSeq;
        this.vndrCntCd = vndrCntCd;
        this.engAddr = engAddr;
        this.lgsFlg = lgsFlg;
        this.pSpType = pSpType;
        this.vndrLglEngNm = vndrLglEngNm;
        this.vndrCd = vndrCd;
        this.pagerows = pagerows;
        this.ofcCd = ofcCd;
        this.ibflag = ibflag;
        this.vndrSeq = vndrSeq;
        this.cntCd = cntCd;
        this.iPage = iPage;
        this.vndrNmEng = vndrNmEng;
        this.vndrAbbrNm = vndrAbbrNm;
        this.ptsVndrCd = ptsVndrCd;
        this.orgVndrSeq = orgVndrSeq;
        this.idaGstRgstStsCd = idaGstRgstStsCd;
        this.idaGstRgstNo = idaGstRgstNo;
        this.idaSteCd = idaSteCd;
        this.idaSteNm = idaSteNm;
    }
    
    
    

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("prnt_vndr_seq", getPrntVndrSeq());
        this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
        this.hashColumns.put("eng_addr", getEngAddr());
        this.hashColumns.put("lgs_flg", getLgsFlg());
        this.hashColumns.put("p_sp_type", getPSpType());
        this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
        this.hashColumns.put("vndr_cd", getVndrCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("i_page", getIPage());
        this.hashColumns.put("vndr_nm_eng", getVndrNmEng());
        this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
        this.hashColumns.put("pts_vndr_cd", getPtsVndrCd());
        this.hashColumns.put("org_vndr_seq", getOrgVndrSeq());
        
        this.hashColumns.put("ida_gst_rgst_sts_cd", getIdaGstRgstStsCd());
        this.hashColumns.put("ida_gst_rgst_no", getIdaGstRgstNo());
        this.hashColumns.put("ida_ste_cd", getIdaSteCd());
        this.hashColumns.put("ida_ste_nm", getIdaSteNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("prnt_vndr_seq", "prntVndrSeq");
        this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
        this.hashFields.put("eng_addr", "engAddr");
        this.hashFields.put("lgs_flg", "lgsFlg");
        this.hashFields.put("p_sp_type", "pSpType");
        this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
        this.hashFields.put("vndr_cd", "vndrCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("i_page", "iPage");
        this.hashFields.put("vndr_nm_eng", "vndrNmEng");
        this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
        this.hashFields.put("pts_vndr_cd", "ptsVndrCd");
        this.hashFields.put("org_vndr_seq", "orgVndrSeq");
        this.hashFields.put("ida_gst_rgst_sts_cd", "idaGstRgstStsCd");
        this.hashFields.put("ida_gst_rgst_no", "idaGstRgstNo");
        this.hashFields.put("ida_ste_cd", "idaSteCd");
        this.hashFields.put("ida_ste_nm", "idaSteNm");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return prntVndrSeq
	 */
    public String getPrntVndrSeq() {
        return this.prntVndrSeq;
    }

    /**
	 * Column Info
	 * @return vndrCntCd
	 */
    public String getVndrCntCd() {
        return this.vndrCntCd;
    }

    /**
	 * Column Info
	 * @return engAddr
	 */
    public String getEngAddr() {
        return this.engAddr;
    }

    /**
	 * Column Info
	 * @return lgsFlg
	 */
    public String getLgsFlg() {
        return this.lgsFlg;
    }

    /**
	 * Column Info
	 * @return pSpType
	 */
    public String getPSpType() {
        return this.pSpType;
    }

    /**
	 * Column Info
	 * @return vndrLglEngNm
	 */
    public String getVndrLglEngNm() {
        return this.vndrLglEngNm;
    }

    /**
	 * Column Info
	 * @return vndrCd
	 */
    public String getVndrCd() {
        return this.vndrCd;
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
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
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
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
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
	 * @return iPage
	 */
    public String getIPage() {
        return this.iPage;
    }

    /**
	 * Column Info
	 * @return vndrNmEng
	 */
    public String getVndrNmEng() {
        return this.vndrNmEng;
    }

    /**
	 * Column Info
	 * @return vndrAbbrNm
	 */
    public String getVndrAbbrNm() {
        return this.vndrAbbrNm;
    }

    /**
	 * Column Info
	 * @return ptsVndrCd
	 */
    public String getPtsVndrCd() {
        return this.ptsVndrCd;
    }

    /**
	 * Column Info
	 * @return orgVndrSeq
	 */
    public String getOrgVndrSeq() {
        return this.orgVndrSeq;
    }

    /**
	 * Column Info
	 * @param prntVndrSeq
	 */
    public void setPrntVndrSeq(String prntVndrSeq) {
        this.prntVndrSeq = prntVndrSeq;
    }

    /**
	 * Column Info
	 * @param vndrCntCd
	 */
    public void setVndrCntCd(String vndrCntCd) {
        this.vndrCntCd = vndrCntCd;
    }

    /**
	 * Column Info
	 * @param engAddr
	 */
    public void setEngAddr(String engAddr) {
        this.engAddr = engAddr;
    }

    /**
	 * Column Info
	 * @param lgsFlg
	 */
    public void setLgsFlg(String lgsFlg) {
        this.lgsFlg = lgsFlg;
    }

    /**
	 * Column Info
	 * @param pSpType
	 */
    public void setPSpType(String pSpType) {
        this.pSpType = pSpType;
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
	 * @param vndrCd
	 */
    public void setVndrCd(String vndrCd) {
        this.vndrCd = vndrCd;
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
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
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
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
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
	 * @param iPage
	 */
    public void setIPage(String iPage) {
        this.iPage = iPage;
    }

    /**
	 * Column Info
	 * @param vndrNmEng
	 */
    public void setVndrNmEng(String vndrNmEng) {
        this.vndrNmEng = vndrNmEng;
    }

    /**
	 * Column Info
	 * @param vndrAbbrNm
	 */
    public void setVndrAbbrNm(String vndrAbbrNm) {
        this.vndrAbbrNm = vndrAbbrNm;
    }

    /**
	 * Column Info
	 * @param ptsVndrCd
	 */
    public void setPtsVndrCd(String ptsVndrCd) {
        this.ptsVndrCd = ptsVndrCd;
    }

    /**
	 * Column Info
	 * @param orgVndrSeq
	 */
    public void setOrgVndrSeq(String orgVndrSeq) {
        this.orgVndrSeq = orgVndrSeq;
    }
    /**
	 * Column Info
	 * @param idaGstRgstStsCd
	 */
    public String getIdaGstRgstStsCd() {
		return idaGstRgstStsCd;
	}
    /**
	 * Column Info
	 * @param idaGstRgstNo
	 */
	public String getIdaGstRgstNo() {
		return idaGstRgstNo;
	}
    /**
	 * Column Info
	 * @param idaSteNm
	 */
	public String getIdaSteNm() {
		return idaSteNm;
	}
    /**
	 * Column Info
	 * @param idaSteCd
	 */
	public String getIdaSteCd() {
		return idaSteCd;
	}
    /**
	 * Column Info
	 * @param idaGstRgstStsCd
	 */
	public void setIdaGstRgstStsCd(String idaGstRgstStsCd) {
		this.idaGstRgstStsCd = idaGstRgstStsCd;
	}
    /**
	 * Column Info
	 * @param idaGstRgstNo
	 */
	public void setIdaGstRgstNo(String idaGstRgstNo) {
		this.idaGstRgstNo = idaGstRgstNo;
	}
    /**
	 * Column Info
	 * @param idaSteNm
	 */
	public void setIdaSteNm(String idaSteNm) {
		this.idaSteNm = idaSteNm;
	}
    /**
	 * Column Info
	 * @param idaSteCd
	 */
	public void setIdaSteCd(String idaSteCd) {
		this.idaSteCd = idaSteCd;
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
        setPrntVndrSeq(JSPUtil.getParameter(request, prefix + "prnt_vndr_seq", ""));
        setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
        setEngAddr(JSPUtil.getParameter(request, prefix + "eng_addr", ""));
        setLgsFlg(JSPUtil.getParameter(request, prefix + "lgs_flg", ""));
        setPSpType(JSPUtil.getParameter(request, prefix + "p_sp_type", ""));
        setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
        setVndrCd(JSPUtil.getParameter(request, prefix + "vndr_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setIPage(JSPUtil.getParameter(request, prefix + "i_page", ""));
        setVndrNmEng(JSPUtil.getParameter(request, prefix + "vndr_nm_eng", ""));
        setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
        setPtsVndrCd(JSPUtil.getParameter(request, prefix + "pts_vndr_cd", ""));
        setOrgVndrSeq(JSPUtil.getParameter(request, prefix + "org_vndr_seq", ""));
        setIdaGstRgstStsCd(JSPUtil.getParameter(request, prefix + "ida_gst_rgst_sts_cd", ""));
        setIdaGstRgstNo(JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", ""));
        setIdaSteCd(JSPUtil.getParameter(request, prefix + "ida_ste_cd", ""));
        setIdaSteNm(JSPUtil.getParameter(request, prefix + "ida_ste_nm", ""));
    
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpListVO[]
	 */
    public SpListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpListVO[]
	 */
    public SpListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SpListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] prntVndrSeq = (JSPUtil.getParameter(request, prefix + "prnt_vndr_seq", length));
            String[] vndrCntCd = (JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", length));
            String[] engAddr = (JSPUtil.getParameter(request, prefix + "eng_addr", length));
            String[] lgsFlg = (JSPUtil.getParameter(request, prefix + "lgs_flg", length));
            String[] pSpType = (JSPUtil.getParameter(request, prefix + "p_sp_type", length));
            String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", length));
            String[] vndrCd = (JSPUtil.getParameter(request, prefix + "vndr_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] iPage = (JSPUtil.getParameter(request, prefix + "i_page", length));
            String[] vndrNmEng = (JSPUtil.getParameter(request, prefix + "vndr_nm_eng", length));
            String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", length));
            String[] ptsVndrCd = (JSPUtil.getParameter(request, prefix + "pts_vndr_cd", length));
            String[] orgVndrSeq = (JSPUtil.getParameter(request, prefix + "org_vndr_seq", length));
            String[] idaGstRgstStsCd = (JSPUtil.getParameter(request, prefix + "ida_gst_rgst_sts_cd", length));
	    	String[] idaGstRgstNo = (JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", length));
	    	String[] idaSteCd = (JSPUtil.getParameter(request, prefix + "ida_ste_cd", length));
	    	String[] idaSteNm = (JSPUtil.getParameter(request, prefix + "ida_ste_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SpListVO();
                if (prntVndrSeq[i] != null)
                    model.setPrntVndrSeq(prntVndrSeq[i]);
                if (vndrCntCd[i] != null)
                    model.setVndrCntCd(vndrCntCd[i]);
                if (engAddr[i] != null)
                    model.setEngAddr(engAddr[i]);
                if (lgsFlg[i] != null)
                    model.setLgsFlg(lgsFlg[i]);
                if (pSpType[i] != null)
                    model.setPSpType(pSpType[i]);
                if (vndrLglEngNm[i] != null)
                    model.setVndrLglEngNm(vndrLglEngNm[i]);
                if (vndrCd[i] != null)
                    model.setVndrCd(vndrCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (iPage[i] != null)
                    model.setIPage(iPage[i]);
                if (vndrNmEng[i] != null)
                    model.setVndrNmEng(vndrNmEng[i]);
                if (vndrAbbrNm[i] != null)
                    model.setVndrAbbrNm(vndrAbbrNm[i]);
                if (ptsVndrCd[i] != null)
                    model.setPtsVndrCd(ptsVndrCd[i]);
                if (orgVndrSeq[i] != null)
                    model.setOrgVndrSeq(orgVndrSeq[i]);
                if (idaGstRgstStsCd[i] != null) 
		    		model.setIdaGstRgstStsCd(idaGstRgstStsCd[i]);
				if (idaGstRgstNo[i] != null) 
		    		model.setIdaGstRgstNo(idaGstRgstNo[i]);
				if (idaSteCd[i] != null) 
		    		model.setIdaSteCd(idaSteCd[i]);
				if (idaSteNm[i] != null) 
		    		model.setIdaSteNm(idaSteNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSpListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SpListVO[]
	 */
    public SpListVO[] getSpListVOs() {
        SpListVO[] vos = (SpListVO[]) models.toArray(new SpListVO[models.size()]);
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
        this.prntVndrSeq = this.prntVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCntCd = this.vndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.engAddr = this.engAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lgsFlg = this.lgsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pSpType = this.pSpType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrLglEngNm = this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCd = this.vndrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.iPage = this.iPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrNmEng = this.vndrNmEng.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrAbbrNm = this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ptsVndrCd = this.ptsVndrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgVndrSeq = this.orgVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaGstRgstStsCd = this.idaGstRgstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaGstRgstNo = this.idaGstRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSteCd = this.idaSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSteNm = this.idaSteNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
