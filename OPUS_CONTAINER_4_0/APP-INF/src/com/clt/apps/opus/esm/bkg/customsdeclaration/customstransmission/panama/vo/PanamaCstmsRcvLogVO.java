/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PanamaCstmsRcvLogVO.java
*@FileTitle : PanamaCstmsRcvLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo;

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
public class PanamaCstmsRcvLogVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PanamaCstmsRcvLogVO> models = new ArrayList<PanamaCstmsRcvLogVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ediRcvMsgCtnt = null;

    /* Column Info */
    private String rcvDt = null;

    /* Column Info */
    private String vstNo = null;

    /* Column Info */
    private String rcvLogSeq = null;

    /* Column Info */
    private String cstmsAckCd = null;

    /* Column Info */
    private String cstmsErrId = null;

    /* Column Info */
    private String cstmsErrMsg = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String type = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public PanamaCstmsRcvLogVO() {
    }

    public PanamaCstmsRcvLogVO(String ibflag, String pagerows, String ediRcvMsgCtnt, String rcvDt, String vstNo, String rcvLogSeq, String cstmsAckCd, String cstmsErrId, String cstmsErrMsg, String vvdCd, String type) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.ediRcvMsgCtnt = ediRcvMsgCtnt;
        this.rcvDt = rcvDt;
        this.vstNo = vstNo;
        this.rcvLogSeq = rcvLogSeq;
        this.cstmsAckCd = cstmsAckCd;
        this.cstmsErrId = cstmsErrId;
        this.cstmsErrMsg = cstmsErrMsg;
        this.vvdCd = vvdCd;
        this.type = type;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("edi_rcv_msg_ctnt", getEdiRcvMsgCtnt());
        this.hashColumns.put("rcv_dt", getRcvDt());
        this.hashColumns.put("vst_no", getVstNo());
        this.hashColumns.put("rcv_log_seq", getRcvLogSeq());
        this.hashColumns.put("cstms_ack_cd", getCstmsAckCd());
        this.hashColumns.put("cstms_err_id", getCstmsErrId());
        this.hashColumns.put("cstms_err_msg", getCstmsErrMsg());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("type", getType());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("edi_rcv_msg_ctnt", "ediRcvMsgCtnt");
        this.hashFields.put("rcv_dt", "rcvDt");
        this.hashFields.put("vst_no", "vstNo");
        this.hashFields.put("rcv_log_seq", "rcvLogSeq");
        this.hashFields.put("cstms_ack_cd", "cstmsAckCd");
        this.hashFields.put("cstms_err_id", "cstmsErrId");
        this.hashFields.put("cstms_err_msg", "cstmsErrMsg");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("type", "type");
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
	 * @param String ediRcvMsgCtnt
	 */
    public void setEdiRcvMsgCtnt(String ediRcvMsgCtnt) {
        this.ediRcvMsgCtnt = ediRcvMsgCtnt;
    }

    /**
	 * 
	 * @return String ediRcvMsgCtnt
	 */
    public String getEdiRcvMsgCtnt() {
        return this.ediRcvMsgCtnt;
    }

    /**
	 *
	 * @param String rcvDt
	 */
    public void setRcvDt(String rcvDt) {
        this.rcvDt = rcvDt;
    }

    /**
	 * 
	 * @return String rcvDt
	 */
    public String getRcvDt() {
        return this.rcvDt;
    }

    /**
	 *
	 * @param String vstNo
	 */
    public void setVstNo(String vstNo) {
        this.vstNo = vstNo;
    }

    /**
	 * 
	 * @return String vstNo
	 */
    public String getVstNo() {
        return this.vstNo;
    }

    /**
	 *
	 * @param String rcvLogSeq
	 */
    public void setRcvLogSeq(String rcvLogSeq) {
        this.rcvLogSeq = rcvLogSeq;
    }

    /**
	 * 
	 * @return String rcvLogSeq
	 */
    public String getRcvLogSeq() {
        return this.rcvLogSeq;
    }

    /**
	 *
	 * @param String cstmsAckCd
	 */
    public void setCstmsAckCd(String cstmsAckCd) {
        this.cstmsAckCd = cstmsAckCd;
    }

    /**
	 * 
	 * @return String cstmsAckCd
	 */
    public String getCstmsAckCd() {
        return this.cstmsAckCd;
    }

    /**
	 *
	 * @param String cstmsErrId
	 */
    public void setCstmsErrId(String cstmsErrId) {
        this.cstmsErrId = cstmsErrId;
    }

    /**
	 * 
	 * @return String cstmsErrId
	 */
    public String getCstmsErrId() {
        return this.cstmsErrId;
    }

    /**
	 *
	 * @param String cstmsErrMsg
	 */
    public void setCstmsErrMsg(String cstmsErrMsg) {
        this.cstmsErrMsg = cstmsErrMsg;
    }

    /**
	 * 
	 * @return String cstmsErrMsg
	 */
    public String getCstmsErrMsg() {
        return this.cstmsErrMsg;
    }

    public void setVvdCd(String vvdCd) {
        this.vvdCd = vvdCd;
    }

    public String getVvdCd() {
        return this.vvdCd;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
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
        setEdiRcvMsgCtnt(JSPUtil.getParameter(request, prefix + "edi_rcv_msg_ctnt", ""));
        setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
        setVstNo(JSPUtil.getParameter(request, prefix + "vst_no", ""));
        setRcvLogSeq(JSPUtil.getParameter(request, prefix + "rcv_log_seq", ""));
        setCstmsAckCd(JSPUtil.getParameter(request, prefix + "cstms_ack_cd", ""));
        setCstmsErrId(JSPUtil.getParameter(request, prefix + "cstms_err_id", ""));
        setCstmsErrMsg(JSPUtil.getParameter(request, prefix + "cstms_err_msg", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
        setType(JSPUtil.getParameter(request, prefix + "type", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PanamaCstmsRcvLogVO[]
	 */
    public PanamaCstmsRcvLogVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PanamaCstmsRcvLogVO[]
	 */
    public PanamaCstmsRcvLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PanamaCstmsRcvLogVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ediRcvMsgCtnt = (JSPUtil.getParameter(request, prefix + "edi_rcv_msg_ctnt", length));
            String[] rcvDt = (JSPUtil.getParameter(request, prefix + "rcv_dt", length));
            String[] vstNo = (JSPUtil.getParameter(request, prefix + "vst_no", length));
            String[] rcvLogSeq = (JSPUtil.getParameter(request, prefix + "rcv_log_seq", length));
            String[] cstmsAckCd = (JSPUtil.getParameter(request, prefix + "cstms_ack_cd", length));
            String[] cstmsErrId = (JSPUtil.getParameter(request, prefix + "cstms_err_id", length));
            String[] cstmsErrMsg = (JSPUtil.getParameter(request, prefix + "cstms_err_msg", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] type = (JSPUtil.getParameter(request, prefix + "type", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new PanamaCstmsRcvLogVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ediRcvMsgCtnt[i] != null)
                    model.setEdiRcvMsgCtnt(ediRcvMsgCtnt[i]);
                if (rcvDt[i] != null)
                    model.setRcvDt(rcvDt[i]);
                if (vstNo[i] != null)
                    model.setVstNo(vstNo[i]);
                if (rcvLogSeq[i] != null)
                    model.setRcvLogSeq(rcvLogSeq[i]);
                if (cstmsAckCd[i] != null)
                    model.setCstmsAckCd(cstmsAckCd[i]);
                if (cstmsErrId[i] != null)
                    model.setCstmsErrId(cstmsErrId[i]);
                if (cstmsErrMsg[i] != null)
                    model.setCstmsErrMsg(cstmsErrMsg[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (type[i] != null) 
		    		model.setType(type[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getPanamaCstmsRcvLogVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return PanamaCstmsRcvLogVO[]
	 */
    public PanamaCstmsRcvLogVO[] getPanamaCstmsRcvLogVOs() {
        PanamaCstmsRcvLogVO[] vos = (PanamaCstmsRcvLogVO[]) models.toArray(new PanamaCstmsRcvLogVO[models.size()]);
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
        this.ediRcvMsgCtnt = this.ediRcvMsgCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvDt = this.rcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vstNo = this.vstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvLogSeq = this.rcvLogSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsAckCd = this.cstmsAckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsErrId = this.cstmsErrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsErrMsg = this.cstmsErrMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.type = this.type.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
