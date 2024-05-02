/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgCustAvcNtcSndCtntVO.java
*@FileTitle : BkgCustAvcNtcSndCtntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.06  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
public class BkgCustAvcNtcSndCtntVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgCustAvcNtcSndCtntVO> models = new ArrayList<BkgCustAvcNtcSndCtntVO>();

    /* Column Info */
    private String rmk = null;

    /* Column Info */
    private String emlSubjCtnt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String sndDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String fileDesc = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgCustAvcNtcSndCtntVO() {
    }

    public BkgCustAvcNtcSndCtntVO(String ibflag, String pagerows, String sndDt, String cntrNo, String rmk, String emlSubjCtnt, String fileDesc) {
        this.rmk = rmk;
        this.emlSubjCtnt = emlSubjCtnt;
        this.ibflag = ibflag;
        this.cntrNo = cntrNo;
        this.sndDt = sndDt;
        this.pagerows = pagerows;
        this.fileDesc = fileDesc;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("rmk", getRmk());
        this.hashColumns.put("eml_subj_ctnt", getRmk());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("snd_dt", getSndDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("file_desc", getFileDesc());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("rmk", "rmk");
        this.hashFields.put("eml_subj_ctnt", "emlSubjCtnt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("snd_dt", "sndDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("file_desc", "fileDesc");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return rmk
	 */
    public String getRmk() {
        return this.rmk;
    }

    /**
	 * Column Info
	 * @return emlSubjCtnt
	 */
    public String getEmlSubjCtnt() {
        return this.emlSubjCtnt;
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
	 * @return cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 * Column Info
	 * @return sndDt
	 */
    public String getSndDt() {
        return this.sndDt;
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
	 * @param rmk
	 */
    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    /**
	 * Column Info
	 * @param emlSubjCtnt
	 */
    public void setEmlSubjCtnt(String emlSubjCtnt) {
        this.emlSubjCtnt = emlSubjCtnt;
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
	 * @param cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * Column Info
	 * @param sndDt
	 */
    public void setSndDt(String sndDt) {
        this.sndDt = sndDt;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }

    public String getFileDesc() {
        return this.fileDesc;
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
        setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
        setEmlSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setFileDesc(JSPUtil.getParameter(request, prefix + "file_desc", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCustAvcNtcSndCtntVO[]
	 */
    public BkgCustAvcNtcSndCtntVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCustAvcNtcSndCtntVO[]
	 */
    public BkgCustAvcNtcSndCtntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgCustAvcNtcSndCtntVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] rmk = (JSPUtil.getParameter(request, prefix + "rmk", length));
            String[] emlSubjCtnt = (JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] sndDt = (JSPUtil.getParameter(request, prefix + "snd_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] fileDesc = (JSPUtil.getParameter(request, prefix + "file_desc", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgCustAvcNtcSndCtntVO();
                if (rmk[i] != null)
                    model.setRmk(rmk[i]);
                if (emlSubjCtnt[i] != null)
                    model.setEmlSubjCtnt(emlSubjCtnt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (sndDt[i] != null)
                    model.setSndDt(sndDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (fileDesc[i] != null) 
		    		model.setFileDesc(fileDesc[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgCustAvcNtcSndCtntVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgCustAvcNtcSndCtntVO[]
	 */
    public BkgCustAvcNtcSndCtntVO[] getBkgCustAvcNtcSndCtntVOs() {
        BkgCustAvcNtcSndCtntVO[] vos = (BkgCustAvcNtcSndCtntVO[]) models.toArray(new BkgCustAvcNtcSndCtntVO[models.size()]);
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
        this.rmk = this.rmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSubjCtnt = this.emlSubjCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sndDt = this.sndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fileDesc = this.fileDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
