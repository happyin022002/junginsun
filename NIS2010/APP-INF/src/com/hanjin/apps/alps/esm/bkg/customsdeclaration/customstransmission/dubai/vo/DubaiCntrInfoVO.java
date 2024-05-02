/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiCntrInfoVO.java
*@FileTitle : DubaiCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.03 김민정 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.dubai.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class DubaiCntrInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<DubaiCntrInfoVO> models = new ArrayList<DubaiCntrInfoVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String duPckTpCd = null;

    /* Column Info */
    private String cntrTareWgt = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String checkDigit = null;

    /* Column Info */
    private String cntrSealNo = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String sz = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cntrTpszIsoCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public DubaiCntrInfoVO() {
    }

    public DubaiCntrInfoVO(String ibflag, String pagerows, String blNo, String cntrNo, String checkDigit, String duPckTpCd, String cntrTareWgt, String cntrSealNo, String sz, String cntrTpszIsoCd) {
        this.ibflag = ibflag;
        this.duPckTpCd = duPckTpCd;
        this.cntrTareWgt = cntrTareWgt;
        this.cntrNo = cntrNo;
        this.checkDigit = checkDigit;
        this.cntrSealNo = cntrSealNo;
        this.blNo = blNo;
        this.sz = sz;
        this.pagerows = pagerows;
        this.cntrTpszIsoCd = cntrTpszIsoCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("du_pck_tp_cd", getDuPckTpCd());
        this.hashColumns.put("cntr_tare_wgt", getCntrTareWgt());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("check_digit", getCheckDigit());
        this.hashColumns.put("cntr_seal_no", getCntrSealNo());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("sz", getSz());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cntr_tpsz_iso_cd", getCntrTpszIsoCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("du_pck_tp_cd", "duPckTpCd");
        this.hashFields.put("cntr_tare_wgt", "cntrTareWgt");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("check_digit", "checkDigit");
        this.hashFields.put("cntr_seal_no", "cntrSealNo");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("sz", "sz");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cntr_tpsz_iso_cd", "cntrTpszIsoCd");
        return this.hashFields;
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
	 * @return duPckTpCd
	 */
    public String getDuPckTpCd() {
        return this.duPckTpCd;
    }

    /**
	 * Column Info
	 * @return cntrTareWgt
	 */
    public String getCntrTareWgt() {
        return this.cntrTareWgt;
    }

    /**
	 * Column Info
	 * @return cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 * Column Info
	 * @return checkDigit
	 */
    public String getCheckDigit() {
        return this.checkDigit;
    }

    /**
	 * Column Info
	 * @return cntrSealNo
	 */
    public String getCntrSealNo() {
        return this.cntrSealNo;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
    }

    /**
	 * Column Info
	 * @return sz
	 */
    public String getSz() {
        return this.sz;
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
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param duPckTpCd
	 */
    public void setDuPckTpCd(String duPckTpCd) {
        this.duPckTpCd = duPckTpCd;
    }

    /**
	 * Column Info
	 * @param cntrTareWgt
	 */
    public void setCntrTareWgt(String cntrTareWgt) {
        this.cntrTareWgt = cntrTareWgt;
    }

    /**
	 * Column Info
	 * @param cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * Column Info
	 * @param checkDigit
	 */
    public void setCheckDigit(String checkDigit) {
        this.checkDigit = checkDigit;
    }

    /**
	 * Column Info
	 * @param cntrSealNo
	 */
    public void setCntrSealNo(String cntrSealNo) {
        this.cntrSealNo = cntrSealNo;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
	 * Column Info
	 * @param sz
	 */
    public void setSz(String sz) {
        this.sz = sz;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setCntrTpszIsoCd(String cntrTpszIsoCd) {
        this.cntrTpszIsoCd = cntrTpszIsoCd;
    }

    public String getCntrTpszIsoCd() {
        return this.cntrTpszIsoCd;
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
        setDuPckTpCd(JSPUtil.getParameter(request, prefix + "du_pck_tp_cd", ""));
        setCntrTareWgt(JSPUtil.getParameter(request, prefix + "cntr_tare_wgt", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setCheckDigit(JSPUtil.getParameter(request, prefix + "check_digit", ""));
        setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setSz(JSPUtil.getParameter(request, prefix + "sz", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCntrTpszIsoCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_iso_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DubaiCntrInfoVO[]
	 */
    public DubaiCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DubaiCntrInfoVO[]
	 */
    public DubaiCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        DubaiCntrInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] duPckTpCd = (JSPUtil.getParameter(request, prefix + "du_pck_tp_cd", length));
            String[] cntrTareWgt = (JSPUtil.getParameter(request, prefix + "cntr_tare_wgt", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] checkDigit = (JSPUtil.getParameter(request, prefix + "check_digit", length));
            String[] cntrSealNo = (JSPUtil.getParameter(request, prefix + "cntr_seal_no", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] sz = (JSPUtil.getParameter(request, prefix + "sz", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] cntrTpszIsoCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_iso_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new DubaiCntrInfoVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (duPckTpCd[i] != null)
                    model.setDuPckTpCd(duPckTpCd[i]);
                if (cntrTareWgt[i] != null)
                    model.setCntrTareWgt(cntrTareWgt[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (checkDigit[i] != null)
                    model.setCheckDigit(checkDigit[i]);
                if (cntrSealNo[i] != null)
                    model.setCntrSealNo(cntrSealNo[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (sz[i] != null)
                    model.setSz(sz[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (cntrTpszIsoCd[i] != null) 
		    		model.setCntrTpszIsoCd(cntrTpszIsoCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getDubaiCntrInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return DubaiCntrInfoVO[]
	 */
    public DubaiCntrInfoVO[] getDubaiCntrInfoVOs() {
        DubaiCntrInfoVO[] vos = (DubaiCntrInfoVO[]) models.toArray(new DubaiCntrInfoVO[models.size()]);
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
        this.duPckTpCd = this.duPckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTareWgt = this.cntrTareWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.checkDigit = this.checkDigit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSealNo = this.cntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sz = this.sz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszIsoCd = this.cntrTpszIsoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
