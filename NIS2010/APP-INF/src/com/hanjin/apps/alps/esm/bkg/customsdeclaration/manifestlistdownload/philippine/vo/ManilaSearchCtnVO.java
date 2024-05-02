/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ManilaSearchCtnVO.java
*@FileTitle : ManilaSearchCtnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class ManilaSearchCtnVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ManilaSearchCtnVO> models = new ArrayList<ManilaSearchCtnVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String regNo = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String cntrTpsz = null;

    /* Column Info */
    private String cgoTp = null;

    /* Column Info */
    private String cntrSealNo = null;

    /* Column Info */
    private String cntrSealNo2 = null;

    /* Column Info */
    private String cntrSealNo3 = null;

    /* Column Info */
    private String sealPtyCd = null;

    /* Column Info */
    private String seq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ManilaSearchCtnVO() {
    }

    public ManilaSearchCtnVO(String ibflag, String pagerows, String ofcCd, String regNo, String blNo, String cntrNo, String cntrTpsz, String cgoTp, String cntrSealNo, String cntrSealNo2, String cntrSealNo3, String sealPtyCd, String seq) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.ofcCd = ofcCd;
        this.regNo = regNo;
        this.blNo = blNo;
        this.cntrNo = cntrNo;
        this.cntrTpsz = cntrTpsz;
        this.cgoTp = cgoTp;
        this.cntrSealNo = cntrSealNo;
        this.cntrSealNo2 = cntrSealNo2;
        this.cntrSealNo3 = cntrSealNo3;
        this.sealPtyCd = sealPtyCd;
        this.seq = seq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("reg_no", getRegNo());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("cntr_tpsz", getCntrTpsz());
        this.hashColumns.put("cgo_tp", getCgoTp());
        this.hashColumns.put("cntr_seal_no", getCntrSealNo());
        this.hashColumns.put("cntr_seal_no2", getCntrSealNo2());
        this.hashColumns.put("cntr_seal_no3", getCntrSealNo3());
        this.hashColumns.put("seal_pty_cd", getSealPtyCd());
        this.hashColumns.put("seq", getSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("reg_no", "regNo");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("cntr_tpsz", "cntrTpsz");
        this.hashFields.put("cgo_tp", "cgoTp");
        this.hashFields.put("cntr_seal_no", "cntrSealNo");
        this.hashFields.put("cntr_seal_no2", "cntrSealNo2");
        this.hashFields.put("cntr_seal_no3", "cntrSealNo3");
        this.hashFields.put("seal_pty_cd", "sealPtyCd");
        this.hashFields.put("seq", "seq");
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
	 * @param String ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * 
	 * @return String ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 *
	 * @param String regNo
	 */
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
	 * 
	 * @return String regNo
	 */
    public String getRegNo() {
        return this.regNo;
    }

    /**
	 *
	 * @param String blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
	 * 
	 * @return String blNo
	 */
    public String getBlNo() {
        return this.blNo;
    }

    /**
	 *
	 * @param String cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * 
	 * @return String cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 *
	 * @param String cntrTpsz
	 */
    public void setCntrTpsz(String cntrTpsz) {
        this.cntrTpsz = cntrTpsz;
    }

    /**
	 * 
	 * @return String cntrTpsz
	 */
    public String getCntrTpsz() {
        return this.cntrTpsz;
    }

    /**
	 *
	 * @param String cgoTp
	 */
    public void setCgoTp(String cgoTp) {
        this.cgoTp = cgoTp;
    }

    /**
	 * 
	 * @return String cgoTp
	 */
    public String getCgoTp() {
        return this.cgoTp;
    }

    /**
	 *
	 * @param String cntrSealNo
	 */
    public void setCntrSealNo(String cntrSealNo) {
        this.cntrSealNo = cntrSealNo;
    }

    /**
	 * 
	 * @return String cntrSealNo
	 */
    public String getCntrSealNo() {
        return this.cntrSealNo;
    }

    /**
	 *
	 * @param String cntrSealNo2
	 */
    public void setCntrSealNo2(String cntrSealNo2) {
        this.cntrSealNo2 = cntrSealNo2;
    }

    /**
	 * 
	 * @return String cntrSealNo2
	 */
    public String getCntrSealNo2() {
        return this.cntrSealNo2;
    }

    /**
	 *
	 * @param String cntrSealNo3
	 */
    public void setCntrSealNo3(String cntrSealNo3) {
        this.cntrSealNo3 = cntrSealNo3;
    }

    /**
	 * 
	 * @return String cntrSealNo3
	 */
    public String getCntrSealNo3() {
        return this.cntrSealNo3;
    }

    /**
	 *
	 * @param String sealPtyCd
	 */
    public void setSealPtyCd(String sealPtyCd) {
        this.sealPtyCd = sealPtyCd;
    }

    /**
	 * 
	 * @return String sealPtyCd
	 */
    public String getSealPtyCd() {
        return this.sealPtyCd;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getSeq() {
        return this.seq;
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
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setRegNo(JSPUtil.getParameter(request, prefix + "reg_no", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setCntrTpsz(JSPUtil.getParameter(request, prefix + "cntr_tpsz", ""));
        setCgoTp(JSPUtil.getParameter(request, prefix + "cgo_tp", ""));
        setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
        setCntrSealNo2(JSPUtil.getParameter(request, prefix + "cntr_seal_no2", ""));
        setCntrSealNo3(JSPUtil.getParameter(request, prefix + "cntr_seal_no3", ""));
        setSealPtyCd(JSPUtil.getParameter(request, prefix + "seal_pty_cd", ""));
        setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManilaSearchCtnVO[]
	 */
    public ManilaSearchCtnVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManilaSearchCtnVO[]
	 */
    public ManilaSearchCtnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ManilaSearchCtnVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] regNo = (JSPUtil.getParameter(request, prefix + "reg_no", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] cntrTpsz = (JSPUtil.getParameter(request, prefix + "cntr_tpsz", length));
            String[] cgoTp = (JSPUtil.getParameter(request, prefix + "cgo_tp", length));
            String[] cntrSealNo = (JSPUtil.getParameter(request, prefix + "cntr_seal_no", length));
            String[] cntrSealNo2 = (JSPUtil.getParameter(request, prefix + "cntr_seal_no2", length));
            String[] cntrSealNo3 = (JSPUtil.getParameter(request, prefix + "cntr_seal_no3", length));
            String[] sealPtyCd = (JSPUtil.getParameter(request, prefix + "seal_pty_cd", length));
            String[] seq = (JSPUtil.getParameter(request, prefix + "seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ManilaSearchCtnVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (regNo[i] != null)
                    model.setRegNo(regNo[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (cntrTpsz[i] != null)
                    model.setCntrTpsz(cntrTpsz[i]);
                if (cgoTp[i] != null)
                    model.setCgoTp(cgoTp[i]);
                if (cntrSealNo[i] != null)
                    model.setCntrSealNo(cntrSealNo[i]);
                if (cntrSealNo2[i] != null)
                    model.setCntrSealNo2(cntrSealNo2[i]);
                if (cntrSealNo3[i] != null)
                    model.setCntrSealNo3(cntrSealNo3[i]);
                if (sealPtyCd[i] != null)
                    model.setSealPtyCd(sealPtyCd[i]);
                if (seq[i] != null) 
		    		model.setSeq(seq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getManilaSearchCtnVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ManilaSearchCtnVO[]
	 */
    public ManilaSearchCtnVO[] getManilaSearchCtnVOs() {
        ManilaSearchCtnVO[] vos = (ManilaSearchCtnVO[]) models.toArray(new ManilaSearchCtnVO[models.size()]);
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
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.regNo = this.regNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpsz = this.cntrTpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoTp = this.cgoTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSealNo = this.cntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSealNo2 = this.cntrSealNo2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSealNo3 = this.cntrSealNo3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sealPtyCd = this.sealPtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seq = this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
