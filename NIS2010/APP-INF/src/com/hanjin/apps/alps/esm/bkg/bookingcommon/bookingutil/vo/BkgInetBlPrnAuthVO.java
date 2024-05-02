/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BkgInetBlPrnAuthVO.java
*@FileTitle : BkgInetBlPrnAuthVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo;

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
public class BkgInetBlPrnAuthVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgInetBlPrnAuthVO> models = new ArrayList<BkgInetBlPrnAuthVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String oblInterSerNo = null;

    /* Column Info */
    private String oblInterSerNoChkUsrId = null;

    /* Column Info */
    private String oblInterSerNoChkDt = null;

    /* Column Info */
    private String bkgNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgInetBlPrnAuthVO() {
    }

    public BkgInetBlPrnAuthVO(String ibflag, String pagerows, String oblInterSerNo, String oblInterSerNoChkUsrId, String oblInterSerNoChkDt, String bkgNo) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.oblInterSerNo = oblInterSerNo;
        this.oblInterSerNoChkUsrId = oblInterSerNoChkUsrId;
        this.oblInterSerNoChkDt = oblInterSerNoChkDt;
        this.bkgNo = bkgNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("obl_inter_ser_no", getOblInterSerNo());
        this.hashColumns.put("obl_inter_ser_no_chk_usr_id", getOblInterSerNoChkUsrId());
        this.hashColumns.put("obl_inter_ser_no_chk_dt", getOblInterSerNoChkDt());
        this.hashColumns.put("bkg_no", getBkgNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("obl_inter_ser_no", "oblInterSerNo");
        this.hashFields.put("obl_inter_ser_no_chk_usr_id", "oblInterSerNoChkUsrId");
        this.hashFields.put("obl_inter_ser_no_chk_dt", "oblInterSerNoChkDt");
        this.hashFields.put("bkg_no", "bkgNo");
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
	 * @param String oblInterSerNo
	 */
    public void setOblInterSerNo(String oblInterSerNo) {
        this.oblInterSerNo = oblInterSerNo;
    }

    /**
	 * 
	 * @return String oblInterSerNo
	 */
    public String getOblInterSerNo() {
        return this.oblInterSerNo;
    }

    /**
	 *
	 * @param String oblInterSerNoChkUsrId
	 */
    public void setOblInterSerNoChkUsrId(String oblInterSerNoChkUsrId) {
        this.oblInterSerNoChkUsrId = oblInterSerNoChkUsrId;
    }

    /**
	 * 
	 * @return String oblInterSerNoChkUsrId
	 */
    public String getOblInterSerNoChkUsrId() {
        return this.oblInterSerNoChkUsrId;
    }

    /**
	 *
	 * @param String oblInterSerNoChkDt
	 */
    public void setOblInterSerNoChkDt(String oblInterSerNoChkDt) {
        this.oblInterSerNoChkDt = oblInterSerNoChkDt;
    }

    /**
	 * 
	 * @return String oblInterSerNoChkDt
	 */
    public String getOblInterSerNoChkDt() {
        return this.oblInterSerNoChkDt;
    }

    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    public String getBkgNo() {
        return this.bkgNo;
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
        setOblInterSerNo(JSPUtil.getParameter(request, prefix + "obl_inter_ser_no", ""));
        setOblInterSerNoChkUsrId(JSPUtil.getParameter(request, prefix + "obl_inter_ser_no_chk_usr_id", ""));
        setOblInterSerNoChkDt(JSPUtil.getParameter(request, prefix + "obl_inter_ser_no_chk_dt", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgInetBlPrnAuthVO[]
	 */
    public BkgInetBlPrnAuthVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgInetBlPrnAuthVO[]
	 */
    public BkgInetBlPrnAuthVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgInetBlPrnAuthVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] oblInterSerNo = (JSPUtil.getParameter(request, prefix + "obl_inter_ser_no", length));
            String[] oblInterSerNoChkUsrId = (JSPUtil.getParameter(request, prefix + "obl_inter_ser_no_chk_usr_id", length));
            String[] oblInterSerNoChkDt = (JSPUtil.getParameter(request, prefix + "obl_inter_ser_no_chk_dt", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgInetBlPrnAuthVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (oblInterSerNo[i] != null)
                    model.setOblInterSerNo(oblInterSerNo[i]);
                if (oblInterSerNoChkUsrId[i] != null)
                    model.setOblInterSerNoChkUsrId(oblInterSerNoChkUsrId[i]);
                if (oblInterSerNoChkDt[i] != null)
                    model.setOblInterSerNoChkDt(oblInterSerNoChkDt[i]);
                if (bkgNo[i] != null) 
		    		model.setBkgNo(bkgNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgInetBlPrnAuthVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgInetBlPrnAuthVO[]
	 */
    public BkgInetBlPrnAuthVO[] getBkgInetBlPrnAuthVOs() {
        BkgInetBlPrnAuthVO[] vos = (BkgInetBlPrnAuthVO[]) models.toArray(new BkgInetBlPrnAuthVO[models.size()]);
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
        this.oblInterSerNo = this.oblInterSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oblInterSerNoChkUsrId = this.oblInterSerNoChkUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oblInterSerNoChkDt = this.oblInterSerNoChkDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
