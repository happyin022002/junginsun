/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : JapanManifestTransmitCondVO.java
*@FileTitle : JapanManifestTransmitCondVO
*Open Issues :
*Change history :
*	2017.09.07 하대성 cmfCd, cmfReason Culumn Add
*@LastModifyDate : 2017.09.07
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2010.03.30  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo;

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
public class JapanManifestTransmitCondVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<JapanManifestTransmitCondVO> models = new ArrayList<JapanManifestTransmitCondVO>();

    /* Column Info */
    private String inMfrGubun = null;

    /* Column Info */
    private String inSkdVoyNo = null;

    /* Column Info */
    private String inSkdDirCd = null;

    /* Column Info */
    private String inCallSgnNo = null;

    /* Column Info */
    private String inCyOprCd = null;

    /* Column Info */
    private String inVslCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String inVpsEtaDt = null;

    /* Column Info */
    private String inPodSplitCd = null;

    /* Column Info */
    private String inMsgFlag = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String inPolCd = null;

    /* Column Info */
    private String inVvdCd = null;

    /* Column Info */
    private String inMsgTp = null;

    /* Column Info */
    private String inPodCd = null;

    /* Column Info */
    private String inVoyageNo = null;

    /* Column Info */
    private String cmfCd = null;

    /* Column Info */
    private String cmfReason = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public JapanManifestTransmitCondVO() {
    }

    public JapanManifestTransmitCondVO(String ibflag, String pagerows, String inSkdVoyNo, String inSkdDirCd, String inCallSgnNo, String inCyOprCd, String inVslCd, String inVpsEtaDt, String inPodSplitCd, String inMsgFlag, String inPolCd, String inVvdCd, String inMsgTp, String inPodCd, String inMfrGubun, String inVoyageNo, String cmfCd, String cmfReason) {
        this.inMfrGubun = inMfrGubun;
        this.inSkdVoyNo = inSkdVoyNo;
        this.inSkdDirCd = inSkdDirCd;
        this.inCallSgnNo = inCallSgnNo;
        this.inCyOprCd = inCyOprCd;
        this.inVslCd = inVslCd;
        this.pagerows = pagerows;
        this.inVpsEtaDt = inVpsEtaDt;
        this.inPodSplitCd = inPodSplitCd;
        this.inMsgFlag = inMsgFlag;
        this.ibflag = ibflag;
        this.inPolCd = inPolCd;
        this.inVvdCd = inVvdCd;
        this.inMsgTp = inMsgTp;
        this.inPodCd = inPodCd;
        this.inVoyageNo = inVoyageNo;
        this.cmfCd = cmfCd;
        this.cmfReason = cmfReason;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("in_mfr_gubun", getInMfrGubun());
        this.hashColumns.put("in_skd_voy_no", getInSkdVoyNo());
        this.hashColumns.put("in_skd_dir_cd", getInSkdDirCd());
        this.hashColumns.put("in_call_sgn_no", getInCallSgnNo());
        this.hashColumns.put("in_cy_opr_cd", getInCyOprCd());
        this.hashColumns.put("in_vsl_cd", getInVslCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("in_vps_eta_dt", getInVpsEtaDt());
        this.hashColumns.put("in_pod_split_cd", getInPodSplitCd());
        this.hashColumns.put("in_msg_flag", getInMsgFlag());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("in_pol_cd", getInPolCd());
        this.hashColumns.put("in_vvd_cd", getInVvdCd());
        this.hashColumns.put("in_msg_tp", getInMsgTp());
        this.hashColumns.put("in_pod_cd", getInPodCd());
        this.hashColumns.put("in_voyage_no", getInVoyageNo());
        this.hashColumns.put("cmf_cd", getCmfCd());
        this.hashColumns.put("cmf_reason", getCmfReason());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("in_mfr_gubun", "inMfrGubun");
        this.hashFields.put("in_skd_voy_no", "inSkdVoyNo");
        this.hashFields.put("in_skd_dir_cd", "inSkdDirCd");
        this.hashFields.put("in_call_sgn_no", "inCallSgnNo");
        this.hashFields.put("in_cy_opr_cd", "inCyOprCd");
        this.hashFields.put("in_vsl_cd", "inVslCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("in_vps_eta_dt", "inVpsEtaDt");
        this.hashFields.put("in_pod_split_cd", "inPodSplitCd");
        this.hashFields.put("in_msg_flag", "inMsgFlag");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("in_pol_cd", "inPolCd");
        this.hashFields.put("in_vvd_cd", "inVvdCd");
        this.hashFields.put("in_msg_tp", "inMsgTp");
        this.hashFields.put("in_pod_cd", "inPodCd");
        this.hashFields.put("in_voyage_no", "inVoyageNo");
        this.hashFields.put("cmf_cd", "cmfCd");
        this.hashFields.put("cmf_reason", "cmfReason");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return inMfrGubun
	 */
    public String getInMfrGubun() {
        return this.inMfrGubun;
    }

    /**
	 * Column Info
	 * @return inSkdVoyNo
	 */
    public String getInSkdVoyNo() {
        return this.inSkdVoyNo;
    }

    /**
	 * Column Info
	 * @return inSkdDirCd
	 */
    public String getInSkdDirCd() {
        return this.inSkdDirCd;
    }

    /**
	 * Column Info
	 * @return inCallSgnNo
	 */
    public String getInCallSgnNo() {
        return this.inCallSgnNo;
    }

    /**
	 * Column Info
	 * @return inCyOprCd
	 */
    public String getInCyOprCd() {
        return this.inCyOprCd;
    }

    /**
	 * Column Info
	 * @return inVslCd
	 */
    public String getInVslCd() {
        return this.inVslCd;
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
	 * @return inVpsEtaDt
	 */
    public String getInVpsEtaDt() {
        return this.inVpsEtaDt;
    }

    /**
	 * Column Info
	 * @return inPodSplitCd
	 */
    public String getInPodSplitCd() {
        return this.inPodSplitCd;
    }

    /**
	 * Column Info
	 * @return inMsgFlag
	 */
    public String getInMsgFlag() {
        return this.inMsgFlag;
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
	 * @return inPolCd
	 */
    public String getInPolCd() {
        return this.inPolCd;
    }

    /**
	 * Column Info
	 * @return inVvdCd
	 */
    public String getInVvdCd() {
        return this.inVvdCd;
    }

    /**
	 * Column Info
	 * @return inMsgTp
	 */
    public String getInMsgTp() {
        return this.inMsgTp;
    }

    /**
	 * Column Info
	 * @return inPodCd
	 */
    public String getInPodCd() {
        return this.inPodCd;
    }

    /**
	 * Column Info
	 * @param inMfrGubun
	 */
    public void setInMfrGubun(String inMfrGubun) {
        this.inMfrGubun = inMfrGubun;
    }

    /**
	 * Column Info
	 * @param inSkdVoyNo
	 */
    public void setInSkdVoyNo(String inSkdVoyNo) {
        this.inSkdVoyNo = inSkdVoyNo;
    }

    /**
	 * Column Info
	 * @param inSkdDirCd
	 */
    public void setInSkdDirCd(String inSkdDirCd) {
        this.inSkdDirCd = inSkdDirCd;
    }

    /**
	 * Column Info
	 * @param inCallSgnNo
	 */
    public void setInCallSgnNo(String inCallSgnNo) {
        this.inCallSgnNo = inCallSgnNo;
    }

    /**
	 * Column Info
	 * @param inCyOprCd
	 */
    public void setInCyOprCd(String inCyOprCd) {
        this.inCyOprCd = inCyOprCd;
    }

    /**
	 * Column Info
	 * @param inVslCd
	 */
    public void setInVslCd(String inVslCd) {
        this.inVslCd = inVslCd;
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
	 * @param inVpsEtaDt
	 */
    public void setInVpsEtaDt(String inVpsEtaDt) {
        this.inVpsEtaDt = inVpsEtaDt;
    }

    /**
	 * Column Info
	 * @param inPodSplitCd
	 */
    public void setInPodSplitCd(String inPodSplitCd) {
        this.inPodSplitCd = inPodSplitCd;
    }

    /**
	 * Column Info
	 * @param inMsgFlag
	 */
    public void setInMsgFlag(String inMsgFlag) {
        this.inMsgFlag = inMsgFlag;
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
	 * @param inPolCd
	 */
    public void setInPolCd(String inPolCd) {
        this.inPolCd = inPolCd;
    }

    /**
	 * Column Info
	 * @param inVvdCd
	 */
    public void setInVvdCd(String inVvdCd) {
        this.inVvdCd = inVvdCd;
    }

    /**
	 * Column Info
	 * @param inMsgTp
	 */
    public void setInMsgTp(String inMsgTp) {
        this.inMsgTp = inMsgTp;
    }

    /**
	 * Column Info
	 * @param inPodCd
	 */
    public void setInPodCd(String inPodCd) {
        this.inPodCd = inPodCd;
    }

    public void setCmfCd(String cmfCd) {
        this.cmfCd = cmfCd;
    }

    public String getCmfCd() {
        return this.cmfCd;
    }

    public void setCmfReason(String cmfReason) {
        this.cmfReason = cmfReason;
    }

    public String getCmfReason() {
        return this.cmfReason;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    public String getInVoyageNo() {
        return inVoyageNo;
    }

    public void setInVoyageNo(String inVoyageNo) {
        this.inVoyageNo = inVoyageNo;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setInMfrGubun(JSPUtil.getParameter(request, prefix + "in_mfr_gubun", ""));
        setInSkdVoyNo(JSPUtil.getParameter(request, prefix + "in_skd_voy_no", ""));
        setInSkdDirCd(JSPUtil.getParameter(request, prefix + "in_skd_dir_cd", ""));
        setInCallSgnNo(JSPUtil.getParameter(request, prefix + "in_call_sgn_no", ""));
        setInCyOprCd(JSPUtil.getParameter(request, prefix + "in_cy_opr_cd", ""));
        setInVslCd(JSPUtil.getParameter(request, prefix + "in_vsl_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setInVpsEtaDt(JSPUtil.getParameter(request, prefix + "in_vps_eta_dt", ""));
        setInPodSplitCd(JSPUtil.getParameter(request, prefix + "in_pod_split_cd", ""));
        setInMsgFlag(JSPUtil.getParameter(request, prefix + "in_msg_flag", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setInPolCd(JSPUtil.getParameter(request, prefix + "in_pol_cd", ""));
        setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
        setInMsgTp(JSPUtil.getParameter(request, prefix + "in_msg_tp", ""));
        setInPodCd(JSPUtil.getParameter(request, prefix + "in_pod_cd", ""));
        setInVoyageNo(JSPUtil.getParameter(request, prefix + "in_voyage_no", ""));
        setCmfCd(JSPUtil.getParameter(request, prefix + "cmf_cd", ""));
        setCmfReason(JSPUtil.getParameter(request, prefix + "cmf_reason", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestTransmitCondVO[]
	 */
    public JapanManifestTransmitCondVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestTransmitCondVO[]
	 */
    public JapanManifestTransmitCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        JapanManifestTransmitCondVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] inMfrGubun = (JSPUtil.getParameter(request, prefix + "in_mfr_gubun", length));
            String[] inSkdVoyNo = (JSPUtil.getParameter(request, prefix + "in_skd_voy_no", length));
            String[] inSkdDirCd = (JSPUtil.getParameter(request, prefix + "in_skd_dir_cd", length));
            String[] inCallSgnNo = (JSPUtil.getParameter(request, prefix + "in_call_sgn_no", length));
            String[] inCyOprCd = (JSPUtil.getParameter(request, prefix + "in_cy_opr_cd", length));
            String[] inVslCd = (JSPUtil.getParameter(request, prefix + "in_vsl_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] inVpsEtaDt = (JSPUtil.getParameter(request, prefix + "in_vps_eta_dt", length));
            String[] inPodSplitCd = (JSPUtil.getParameter(request, prefix + "in_pod_split_cd", length));
            String[] inMsgFlag = (JSPUtil.getParameter(request, prefix + "in_msg_flag", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] inPolCd = (JSPUtil.getParameter(request, prefix + "in_pol_cd", length));
            String[] inVvdCd = (JSPUtil.getParameter(request, prefix + "in_vvd_cd", length));
            String[] inMsgTp = (JSPUtil.getParameter(request, prefix + "in_msg_tp", length));
            String[] inPodCd = (JSPUtil.getParameter(request, prefix + "in_pod_cd", length));
            String[] inVoyageNo = (JSPUtil.getParameter(request, prefix + "in_voyage_no", length));
            String[] cmfCd = (JSPUtil.getParameter(request, prefix + "cmf_cd", length));
	    	String[] cmfReason = (JSPUtil.getParameter(request, prefix + "cmf_reason", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new JapanManifestTransmitCondVO();
                if (inMfrGubun[i] != null)
                    model.setInMfrGubun(inMfrGubun[i]);
                if (inSkdVoyNo[i] != null)
                    model.setInSkdVoyNo(inSkdVoyNo[i]);
                if (inSkdDirCd[i] != null)
                    model.setInSkdDirCd(inSkdDirCd[i]);
                if (inCallSgnNo[i] != null)
                    model.setInCallSgnNo(inCallSgnNo[i]);
                if (inCyOprCd[i] != null)
                    model.setInCyOprCd(inCyOprCd[i]);
                if (inVslCd[i] != null)
                    model.setInVslCd(inVslCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (inVpsEtaDt[i] != null)
                    model.setInVpsEtaDt(inVpsEtaDt[i]);
                if (inPodSplitCd[i] != null)
                    model.setInPodSplitCd(inPodSplitCd[i]);
                if (inMsgFlag[i] != null)
                    model.setInMsgFlag(inMsgFlag[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (inPolCd[i] != null)
                    model.setInPolCd(inPolCd[i]);
                if (inVvdCd[i] != null)
                    model.setInVvdCd(inVvdCd[i]);
                if (inMsgTp[i] != null)
                    model.setInMsgTp(inMsgTp[i]);
                if (inPodCd[i] != null)
                    model.setInPodCd(inPodCd[i]);
                if (inVoyageNo[i] != null)
                    model.setInVoyageNo(inVoyageNo[i]);
                if (cmfCd[i] != null) 
		    		model.setCmfCd(cmfCd[i]);
				if (cmfReason[i] != null) 
		    		model.setCmfReason(cmfReason[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getJapanManifestTransmitCondVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return JapanManifestTransmitCondVO[]
	 */
    public JapanManifestTransmitCondVO[] getJapanManifestTransmitCondVOs() {
        JapanManifestTransmitCondVO[] vos = (JapanManifestTransmitCondVO[]) models.toArray(new JapanManifestTransmitCondVO[models.size()]);
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
        this.inMfrGubun = this.inMfrGubun.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inSkdVoyNo = this.inSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inSkdDirCd = this.inSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inCallSgnNo = this.inCallSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inCyOprCd = this.inCyOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inVslCd = this.inVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inVpsEtaDt = this.inVpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inPodSplitCd = this.inPodSplitCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inMsgFlag = this.inMsgFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inPolCd = this.inPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inVvdCd = this.inVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inMsgTp = this.inMsgTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inPodCd = this.inPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inVoyageNo = this.inVoyageNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmfCd = this.cmfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmfReason = this.cmfReason.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
