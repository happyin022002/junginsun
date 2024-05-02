/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RocsSearchCmInfoVO.java
*@FileTitle : RocsSearchCmInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo;

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
public class RocsSearchCmInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<RocsSearchCmInfoVO> models = new ArrayList<RocsSearchCmInfoVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cmCntrNo = null;

    /* Column Info */
    private String markno = null;

    /* Column Info */
    private String cmDesc = null;

    /* Column Info */
    private String cmWgtU = null;

    /* Column Info */
    private String cmSeqNo = null;

    /* Column Info */
    private String cmPkgCd = null;

    /* Column Info */
    private String cmPkgNo = null;

    /* Column Info */
    private String cmWgt = null;

    /* Column Info */
    private String cmHsCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cmPkgDesc = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public RocsSearchCmInfoVO() {
    }

    public RocsSearchCmInfoVO(String ibflag, String pagerows, String cmSeqNo, String cmPkgNo, String cmPkgCd, String cmHsCd, String cmDesc, String cmWgt, String cmWgtU, String cmCntrNo, String markno, String cmPkgDesc) {
        this.ibflag = ibflag;
        this.cmCntrNo = cmCntrNo;
        this.markno = markno;
        this.cmDesc = cmDesc;
        this.cmWgtU = cmWgtU;
        this.cmSeqNo = cmSeqNo;
        this.cmPkgCd = cmPkgCd;
        this.cmPkgNo = cmPkgNo;
        this.cmWgt = cmWgt;
        this.cmHsCd = cmHsCd;
        this.pagerows = pagerows;
        this.cmPkgDesc = cmPkgDesc;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cm_cntr_no", getCmCntrNo());
        this.hashColumns.put("markno", getMarkno());
        this.hashColumns.put("cm_desc", getCmDesc());
        this.hashColumns.put("cm_wgt_u", getCmWgtU());
        this.hashColumns.put("cm_seq_no", getCmSeqNo());
        this.hashColumns.put("cm_pkg_cd", getCmPkgCd());
        this.hashColumns.put("cm_pkg_no", getCmPkgNo());
        this.hashColumns.put("cm_wgt", getCmWgt());
        this.hashColumns.put("cm_hs_cd", getCmHsCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cm_pkg_desc", getCmPkgDesc());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cm_cntr_no", "cmCntrNo");
        this.hashFields.put("markno", "markno");
        this.hashFields.put("cm_desc", "cmDesc");
        this.hashFields.put("cm_wgt_u", "cmWgtU");
        this.hashFields.put("cm_seq_no", "cmSeqNo");
        this.hashFields.put("cm_pkg_cd", "cmPkgCd");
        this.hashFields.put("cm_pkg_no", "cmPkgNo");
        this.hashFields.put("cm_wgt", "cmWgt");
        this.hashFields.put("cm_hs_cd", "cmHsCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cm_pkg_desc", "cmPkgDesc");
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
	 * @return cmCntrNo
	 */
    public String getCmCntrNo() {
        return this.cmCntrNo;
    }

    /**
	 * Column Info
	 * @return markno
	 */
    public String getMarkno() {
        return this.markno;
    }

    /**
	 * Column Info
	 * @return cmDesc
	 */
    public String getCmDesc() {
        return this.cmDesc;
    }

    /**
	 * Column Info
	 * @return cmWgtU
	 */
    public String getCmWgtU() {
        return this.cmWgtU;
    }

    /**
	 * Column Info
	 * @return cmSeqNo
	 */
    public String getCmSeqNo() {
        return this.cmSeqNo;
    }

    /**
	 * Column Info
	 * @return cmPkgCd
	 */
    public String getCmPkgCd() {
        return this.cmPkgCd;
    }

    /**
	 * Column Info
	 * @return cmPkgNo
	 */
    public String getCmPkgNo() {
        return this.cmPkgNo;
    }

    /**
	 * Column Info
	 * @return cmWgt
	 */
    public String getCmWgt() {
        return this.cmWgt;
    }

    /**
	 * Column Info
	 * @return cmHsCd
	 */
    public String getCmHsCd() {
        return this.cmHsCd;
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
	 * @param cmCntrNo
	 */
    public void setCmCntrNo(String cmCntrNo) {
        this.cmCntrNo = cmCntrNo;
    }

    /**
	 * Column Info
	 * @param markno
	 */
    public void setMarkno(String markno) {
        this.markno = markno;
    }

    /**
	 * Column Info
	 * @param cmDesc
	 */
    public void setCmDesc(String cmDesc) {
        this.cmDesc = cmDesc;
    }

    /**
	 * Column Info
	 * @param cmWgtU
	 */
    public void setCmWgtU(String cmWgtU) {
        this.cmWgtU = cmWgtU;
    }

    /**
	 * Column Info
	 * @param cmSeqNo
	 */
    public void setCmSeqNo(String cmSeqNo) {
        this.cmSeqNo = cmSeqNo;
    }

    /**
	 * Column Info
	 * @param cmPkgCd
	 */
    public void setCmPkgCd(String cmPkgCd) {
        this.cmPkgCd = cmPkgCd;
    }

    /**
	 * Column Info
	 * @param cmPkgNo
	 */
    public void setCmPkgNo(String cmPkgNo) {
        this.cmPkgNo = cmPkgNo;
    }

    /**
	 * Column Info
	 * @param cmWgt
	 */
    public void setCmWgt(String cmWgt) {
        this.cmWgt = cmWgt;
    }

    /**
	 * Column Info
	 * @param cmHsCd
	 */
    public void setCmHsCd(String cmHsCd) {
        this.cmHsCd = cmHsCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setCmPkgDesc(String cmPkgDesc) {
        this.cmPkgDesc = cmPkgDesc;
    }

    public String getCmPkgDesc() {
        return this.cmPkgDesc;
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
        setCmCntrNo(JSPUtil.getParameter(request, prefix + "cm_cntr_no", ""));
        setMarkno(JSPUtil.getParameter(request, prefix + "markno", ""));
        setCmDesc(JSPUtil.getParameter(request, prefix + "cm_desc", ""));
        setCmWgtU(JSPUtil.getParameter(request, prefix + "cm_wgt_u", ""));
        setCmSeqNo(JSPUtil.getParameter(request, prefix + "cm_seq_no", ""));
        setCmPkgCd(JSPUtil.getParameter(request, prefix + "cm_pkg_cd", ""));
        setCmPkgNo(JSPUtil.getParameter(request, prefix + "cm_pkg_no", ""));
        setCmWgt(JSPUtil.getParameter(request, prefix + "cm_wgt", ""));
        setCmHsCd(JSPUtil.getParameter(request, prefix + "cm_hs_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCmPkgDesc(JSPUtil.getParameter(request, prefix + "cm_pkg_desc", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchCmInfoVO[]
	 */
    public RocsSearchCmInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchCmInfoVO[]
	 */
    public RocsSearchCmInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        RocsSearchCmInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cmCntrNo = (JSPUtil.getParameter(request, prefix + "cm_cntr_no", length));
            String[] markno = (JSPUtil.getParameter(request, prefix + "markno", length));
            String[] cmDesc = (JSPUtil.getParameter(request, prefix + "cm_desc", length));
            String[] cmWgtU = (JSPUtil.getParameter(request, prefix + "cm_wgt_u", length));
            String[] cmSeqNo = (JSPUtil.getParameter(request, prefix + "cm_seq_no", length));
            String[] cmPkgCd = (JSPUtil.getParameter(request, prefix + "cm_pkg_cd", length));
            String[] cmPkgNo = (JSPUtil.getParameter(request, prefix + "cm_pkg_no", length));
            String[] cmWgt = (JSPUtil.getParameter(request, prefix + "cm_wgt", length));
            String[] cmHsCd = (JSPUtil.getParameter(request, prefix + "cm_hs_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            for (int i = 0; i < length; i++) {
                model = new RocsSearchCmInfoVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cmCntrNo[i] != null)
                    model.setCmCntrNo(cmCntrNo[i]);
                if (markno[i] != null)
                    model.setMarkno(markno[i]);
                if (cmDesc[i] != null)
                    model.setCmDesc(cmDesc[i]);
                if (cmWgtU[i] != null)
                    model.setCmWgtU(cmWgtU[i]);
                if (cmSeqNo[i] != null)
                    model.setCmSeqNo(cmSeqNo[i]);
                if (cmPkgCd[i] != null)
                    model.setCmPkgCd(cmPkgCd[i]);
                if (cmPkgNo[i] != null)
                    model.setCmPkgNo(cmPkgNo[i]);
                if (cmWgt[i] != null)
                    model.setCmWgt(cmWgt[i]);
                if (cmHsCd[i] != null)
                    model.setCmHsCd(cmHsCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getRocsSearchCmInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return RocsSearchCmInfoVO[]
	 */
    public RocsSearchCmInfoVO[] getRocsSearchCmInfoVOs() {
        RocsSearchCmInfoVO[] vos = (RocsSearchCmInfoVO[]) models.toArray(new RocsSearchCmInfoVO[models.size()]);
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
        this.cmCntrNo = this.cmCntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.markno = this.markno.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmDesc = this.cmDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmWgtU = this.cmWgtU.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmSeqNo = this.cmSeqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmPkgCd = this.cmPkgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmPkgNo = this.cmPkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmWgt = this.cmWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmHsCd = this.cmHsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmPkgDesc = this.cmPkgDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
