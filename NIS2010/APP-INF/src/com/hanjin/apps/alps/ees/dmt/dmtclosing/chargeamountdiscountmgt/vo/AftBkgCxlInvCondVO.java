/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AftBkgCxlInvCondVO.java
*@FileTitle : AftBkgCxlInvCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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
public class AftBkgCxlInvCondVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<AftBkgCxlInvCondVO> models = new ArrayList<AftBkgCxlInvCondVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String aftExptDarNo = null;

    /* Column Info */
    private String dmdtExptRqstStsCd = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String ofcCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public AftBkgCxlInvCondVO() {
    }

    public AftBkgCxlInvCondVO(String ibflag, String pagerows, String aftExptDarNo, String dmdtExptRqstStsCd, String usrId, String ofcCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.aftExptDarNo = aftExptDarNo;
        this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
        this.usrId = usrId;
        this.ofcCd = ofcCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
        this.hashColumns.put("dmdt_expt_rqst_sts_cd", getDmdtExptRqstStsCd());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("ofc_cd", getOfcCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
        this.hashFields.put("dmdt_expt_rqst_sts_cd", "dmdtExptRqstStsCd");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("ofc_cd", "ofcCd");
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
	 * @param String aftExptDarNo
	 */
    public void setAftExptDarNo(String aftExptDarNo) {
        this.aftExptDarNo = aftExptDarNo;
    }

    /**
	 * 
	 * @return String aftExptDarNo
	 */
    public String getAftExptDarNo() {
        return this.aftExptDarNo;
    }

    public void setDmdtExptRqstStsCd(String dmdtExptRqstStsCd) {
        this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
    }

    public String getDmdtExptRqstStsCd() {
        return this.dmdtExptRqstStsCd;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrId() {
        return this.usrId;
    }

    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    public String getOfcCd() {
        return this.ofcCd;
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
        setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
        setDmdtExptRqstStsCd(JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_cd", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AftBkgCxlInvCondVO[]
	 */
    public AftBkgCxlInvCondVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AftBkgCxlInvCondVO[]
	 */
    public AftBkgCxlInvCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        AftBkgCxlInvCondVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", length));
            String[] dmdtExptRqstStsCd = (JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_cd", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
	    	String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new AftBkgCxlInvCondVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (aftExptDarNo[i] != null)
                    model.setAftExptDarNo(aftExptDarNo[i]);
                if (dmdtExptRqstStsCd[i] != null)
                    model.setDmdtExptRqstStsCd(dmdtExptRqstStsCd[i]);
                if (usrId[i] != null) 
		    		model.setUsrId(usrId[i]);
				if (ofcCd[i] != null) 
		    		model.setOfcCd(ofcCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getAftBkgCxlInvCondVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return AftBkgCxlInvCondVO[]
	 */
    public AftBkgCxlInvCondVO[] getAftBkgCxlInvCondVOs() {
        AftBkgCxlInvCondVO[] vos = (AftBkgCxlInvCondVO[]) models.toArray(new AftBkgCxlInvCondVO[models.size()]);
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
        this.aftExptDarNo = this.aftExptDarNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtExptRqstStsCd = this.dmdtExptRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
