/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCstmsPnmRcvLogVO.java
*@FileTitle : BkgCstmsPnmRcvLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.16 
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
public class BkgCstmsPnmRcvLogVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgCstmsPnmRcvLogVO> models = new ArrayList<BkgCstmsPnmRcvLogVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String rcvDt = null;

    /* Column Info */
    private String rcvLogSeq = null;

    /* Column Info */
    private String vstNo = null;

    /* Column Info */
    private String cstmsAckCd = null;

    /* Column Info */
    private String ediRcvMsgCtnt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String crrBatNo = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String type = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgCstmsPnmRcvLogVO() {
    }

    public BkgCstmsPnmRcvLogVO(String ibflag, String pagerows, String rcvDt, String rcvLogSeq, String vstNo, String cstmsAckCd, String ediRcvMsgCtnt, String creUsrId, String creDt, String updUsrId, String updDt, String crrBatNo, String vvdCd, String type) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.rcvDt = rcvDt;
        this.rcvLogSeq = rcvLogSeq;
        this.vstNo = vstNo;
        this.cstmsAckCd = cstmsAckCd;
        this.ediRcvMsgCtnt = ediRcvMsgCtnt;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.crrBatNo = crrBatNo;
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
        this.hashColumns.put("rcv_dt", getRcvDt());
        this.hashColumns.put("rcv_log_seq", getRcvLogSeq());
        this.hashColumns.put("vst_no", getVstNo());
        this.hashColumns.put("cstms_ack_cd", getCstmsAckCd());
        this.hashColumns.put("edi_rcv_msg_ctnt", getEdiRcvMsgCtnt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("crr_bat_no", getCrrBatNo());
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
        this.hashFields.put("rcv_dt", "rcvDt");
        this.hashFields.put("rcv_log_seq", "rcvLogSeq");
        this.hashFields.put("vst_no", "vstNo");
        this.hashFields.put("cstms_ack_cd", "cstmsAckCd");
        this.hashFields.put("edi_rcv_msg_ctnt", "ediRcvMsgCtnt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("crr_bat_no", "crrBatNo");
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
	 * @param String creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * 
	 * @return String creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 *
	 * @param String creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * 
	 * @return String creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 *
	 * @param String updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * 
	 * @return String updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 *
	 * @param String updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * 
	 * @return String updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    public void setCrrBatNo(String crrBatNo) {
        this.crrBatNo = crrBatNo;
    }

    public String getCrrBatNo() {
        return this.crrBatNo;
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
        setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
        setRcvLogSeq(JSPUtil.getParameter(request, prefix + "rcv_log_seq", ""));
        setVstNo(JSPUtil.getParameter(request, prefix + "vst_no", ""));
        setCstmsAckCd(JSPUtil.getParameter(request, prefix + "cstms_ack_cd", ""));
        setEdiRcvMsgCtnt(JSPUtil.getParameter(request, prefix + "edi_rcv_msg_ctnt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCrrBatNo(JSPUtil.getParameter(request, prefix + "crr_bat_no", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
        setType(JSPUtil.getParameter(request, prefix + "type", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsPnmRcvLogVO[]
	 */
    public BkgCstmsPnmRcvLogVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsPnmRcvLogVO[]
	 */
    public BkgCstmsPnmRcvLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgCstmsPnmRcvLogVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] rcvDt = (JSPUtil.getParameter(request, prefix + "rcv_dt", length));
            String[] rcvLogSeq = (JSPUtil.getParameter(request, prefix + "rcv_log_seq", length));
            String[] vstNo = (JSPUtil.getParameter(request, prefix + "vst_no", length));
            String[] cstmsAckCd = (JSPUtil.getParameter(request, prefix + "cstms_ack_cd", length));
            String[] ediRcvMsgCtnt = (JSPUtil.getParameter(request, prefix + "edi_rcv_msg_ctnt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] crrBatNo = (JSPUtil.getParameter(request, prefix + "crr_bat_no", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] type = (JSPUtil.getParameter(request, prefix + "type", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgCstmsPnmRcvLogVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (rcvDt[i] != null)
                    model.setRcvDt(rcvDt[i]);
                if (rcvLogSeq[i] != null)
                    model.setRcvLogSeq(rcvLogSeq[i]);
                if (vstNo[i] != null)
                    model.setVstNo(vstNo[i]);
                if (cstmsAckCd[i] != null)
                    model.setCstmsAckCd(cstmsAckCd[i]);
                if (ediRcvMsgCtnt[i] != null)
                    model.setEdiRcvMsgCtnt(ediRcvMsgCtnt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (crrBatNo[i] != null)
                    model.setCrrBatNo(crrBatNo[i]);
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
        return getBkgCstmsPnmRcvLogVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgCstmsPnmRcvLogVO[]
	 */
    public BkgCstmsPnmRcvLogVO[] getBkgCstmsPnmRcvLogVOs() {
        BkgCstmsPnmRcvLogVO[] vos = (BkgCstmsPnmRcvLogVO[]) models.toArray(new BkgCstmsPnmRcvLogVO[models.size()]);
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
        this.rcvDt = this.rcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvLogSeq = this.rcvLogSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vstNo = this.vstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsAckCd = this.cstmsAckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediRcvMsgCtnt = this.ediRcvMsgCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrBatNo = this.crrBatNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.type = this.type.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
