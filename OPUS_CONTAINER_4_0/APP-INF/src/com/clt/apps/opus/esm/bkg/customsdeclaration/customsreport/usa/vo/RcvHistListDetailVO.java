/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RcvHistListDetailVO.java
*@FileTitle : RcvHistListDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.16  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistDetailVO;
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
public class RcvHistListDetailVO extends RcvHistDetailVO {

    private static final long serialVersionUID = 1L;

    private Collection<RcvHistListDetailVO> models = new ArrayList<RcvHistListDetailVO>();

    /* Column Info */
    private String total = null;

    /* Column Info */
    private String reason = null;

    /* Column Info */
    private String rcvSeq = null;

    /* Column Info */
    private String ioBndCd = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String cstmsRjctMsg = null;

    /* Column Info */
    private String rjctFlg = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String cndAckErrNoteDesc = null;

    /* Column Info */
    private String vpodCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String rcvDate = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String scacCd = null;

    /* Column Info */
    private String rnum = null;

    /* Column Info */
    private String rcvDt = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String rcvTm = null;

    /* Column Info */
    private String cstmsBatNo = null;

    /* Column Info */
    private String rcvMsgTpId = null;

    /* Column Info */
    private String totCnt = null;

    /* Column Info */
    private String sucCnt = null;

    /* Column Info */
    private String errCnt = null;
    
    /* Column Info */
    private String dspoCd = null;
    

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public RcvHistListDetailVO() {
    }

    public RcvHistListDetailVO(String ibflag, String pagerows, String cntCd, String ioBndCd, String rcvDate, String rcvDt, String rcvTm, String rcvSeq, String rcvMsgTpId, String vvd, String polCd, String podCd, String vpodCd, String cstmsBatNo, String scacCd, String cstmsRjctMsg, String cndAckErrNoteDesc, String rjctFlg, String blNo, String reason, String rnum, String total, String totCnt, String sucCnt, String errCnt, String dspoCd) {
        this.total = total;
        this.reason = reason;
        this.rcvSeq = rcvSeq;
        this.ioBndCd = ioBndCd;
        this.blNo = blNo;
        this.cstmsRjctMsg = cstmsRjctMsg;
        this.rjctFlg = rjctFlg;
        this.pagerows = pagerows;
        this.vvd = vvd;
        this.podCd = podCd;
        this.cndAckErrNoteDesc = cndAckErrNoteDesc;
        this.vpodCd = vpodCd;
        this.ibflag = ibflag;
        this.rcvDate = rcvDate;
        this.polCd = polCd;
        this.scacCd = scacCd;
        this.rnum = rnum;
        this.rcvDt = rcvDt;
        this.cntCd = cntCd;
        this.rcvTm = rcvTm;
        this.cstmsBatNo = cstmsBatNo;
        this.rcvMsgTpId = rcvMsgTpId;
        this.totCnt = totCnt;
        this.sucCnt = sucCnt;
        this.errCnt = errCnt;
        this.dspoCd = dspoCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("total", getTotal());
        this.hashColumns.put("reason", getReason());
        this.hashColumns.put("rcv_seq", getRcvSeq());
        this.hashColumns.put("io_bnd_cd", getIoBndCd());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("cstms_rjct_msg", getCstmsRjctMsg());
        this.hashColumns.put("rjct_flg", getRjctFlg());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("cnd_ack_err_note_desc", getCndAckErrNoteDesc());
        this.hashColumns.put("vpod_cd", getVpodCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("rcv_date", getRcvDate());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("scac_cd", getScacCd());
        this.hashColumns.put("rnum", getRnum());
        this.hashColumns.put("rcv_dt", getRcvDt());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("rcv_tm", getRcvTm());
        this.hashColumns.put("cstms_bat_no", getCstmsBatNo());
        this.hashColumns.put("rcv_msg_tp_id", getRcvMsgTpId());
        this.hashColumns.put("tot_cnt", getTotCnt());
        this.hashColumns.put("suc_cnt", getSucCnt());
        this.hashColumns.put("err_cnt", getErrCnt());
        this.hashColumns.put("dspo_cd", getDspoCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("total", "total");
        this.hashFields.put("reason", "reason");
        this.hashFields.put("rcv_seq", "rcvSeq");
        this.hashFields.put("io_bnd_cd", "ioBndCd");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("cstms_rjct_msg", "cstmsRjctMsg");
        this.hashFields.put("rjct_flg", "rjctFlg");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("cnd_ack_err_note_desc", "cndAckErrNoteDesc");
        this.hashFields.put("vpod_cd", "vpodCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("rcv_date", "rcvDate");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("scac_cd", "scacCd");
        this.hashFields.put("rnum", "rnum");
        this.hashFields.put("rcv_dt", "rcvDt");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("rcv_tm", "rcvTm");
        this.hashFields.put("cstms_bat_no", "cstmsBatNo");
        this.hashFields.put("rcv_msg_tp_id", "rcvMsgTpId");
        this.hashFields.put("tot_cnt", "totCnt");
        this.hashFields.put("suc_cnt", "sucCnt");
        this.hashFields.put("err_cnt", "errCnt");
        this.hashFields.put("dspo_cd", "dspoCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return total
	 */
    public String getTotal() {
        return this.total;
    }

    /**
	 * Column Info
	 * @return reason
	 */
    public String getReason() {
        return this.reason;
    }

    /**
	 * Column Info
	 * @return rcvSeq
	 */
    public String getRcvSeq() {
        return this.rcvSeq;
    }

    /**
	 * Column Info
	 * @return ioBndCd
	 */
    public String getIoBndCd() {
        return this.ioBndCd;
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
	 * @return cstmsRjctMsg
	 */
    public String getCstmsRjctMsg() {
        return this.cstmsRjctMsg;
    }

    /**
	 * Column Info
	 * @return rjctFlg
	 */
    public String getRjctFlg() {
        return this.rjctFlg;
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
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	 * Column Info
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
    }

    /**
	 * Column Info
	 * @return cndAckErrNoteDesc
	 */
    public String getCndAckErrNoteDesc() {
        return this.cndAckErrNoteDesc;
    }

    /**
	 * Column Info
	 * @return vpodCd
	 */
    public String getVpodCd() {
        return this.vpodCd;
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
	 * @return rcvDate
	 */
    public String getRcvDate() {
        return this.rcvDate;
    }

    /**
	 * Column Info
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 * Column Info
	 * @return scacCd
	 */
    public String getScacCd() {
        return this.scacCd;
    }

    /**
	 * Column Info
	 * @return rnum
	 */
    public String getRnum() {
        return this.rnum;
    }

    /**
	 * Column Info
	 * @return rcvDt
	 */
    public String getRcvDt() {
        return this.rcvDt;
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
	 * @return rcvTm
	 */
    public String getRcvTm() {
        return this.rcvTm;
    }

    /**
	 * Column Info
	 * @return cstmsBatNo
	 */
    public String getCstmsBatNo() {
        return this.cstmsBatNo;
    }

    /**
	 * Column Info
	 * @return rcvMsgTpId
	 */
    public String getRcvMsgTpId() {
        return this.rcvMsgTpId;
    }
    
    /**
     * Column Info
     * @return totCnt
     */
    public String getTotCnt() {
        return this.totCnt;
    }

    /**
     * Column Info
     * @return sucCnt
     */
    public String getSucCnt() {
        return this.sucCnt;
    }

    /**
     * Column Info
     * @return errCnt
     */
    public String getErrCnt() {
        return this.errCnt;
    }
    
    /**
     * Column Info
     * @return dspoCd
     */
    public String getDspoCd(){
    	return this.dspoCd;
    }

    /**
	 * Column Info
	 * @param total
	 */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
	 * Column Info
	 * @param reason
	 */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
	 * Column Info
	 * @param rcvSeq
	 */
    public void setRcvSeq(String rcvSeq) {
        this.rcvSeq = rcvSeq;
    }

    /**
	 * Column Info
	 * @param ioBndCd
	 */
    public void setIoBndCd(String ioBndCd) {
        this.ioBndCd = ioBndCd;
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
	 * @param cstmsRjctMsg
	 */
    public void setCstmsRjctMsg(String cstmsRjctMsg) {
        this.cstmsRjctMsg = cstmsRjctMsg;
    }

    /**
	 * Column Info
	 * @param rjctFlg
	 */
    public void setRjctFlg(String rjctFlg) {
        this.rjctFlg = rjctFlg;
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
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @param cndAckErrNoteDesc
	 */
    public void setCndAckErrNoteDesc(String cndAckErrNoteDesc) {
        this.cndAckErrNoteDesc = cndAckErrNoteDesc;
    }

    /**
	 * Column Info
	 * @param vpodCd
	 */
    public void setVpodCd(String vpodCd) {
        this.vpodCd = vpodCd;
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
	 * @param rcvDate
	 */
    public void setRcvDate(String rcvDate) {
        this.rcvDate = rcvDate;
    }

    /**
	 * Column Info
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * @param scacCd
	 */
    public void setScacCd(String scacCd) {
        this.scacCd = scacCd;
    }

    /**
	 * Column Info
	 * @param rnum
	 */
    public void setRnum(String rnum) {
        this.rnum = rnum;
    }

    /**
	 * Column Info
	 * @param rcvDt
	 */
    public void setRcvDt(String rcvDt) {
        this.rcvDt = rcvDt;
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
	 * @param rcvTm
	 */
    public void setRcvTm(String rcvTm) {
        this.rcvTm = rcvTm;
    }

    /**
	 * Column Info
	 * @param cstmsBatNo
	 */
    public void setCstmsBatNo(String cstmsBatNo) {
        this.cstmsBatNo = cstmsBatNo;
    }

    /**
	 * Column Info
	 * @param rcvMsgTpId
	 */
    public void setRcvMsgTpId(String rcvMsgTpId) {
        this.rcvMsgTpId = rcvMsgTpId;
    }

    /**
     * Column Info
     * @param totCnt
     */
    public void setTotCnt(String totCnt) {
        this.totCnt = totCnt;
    }

    /**
     * Column Info
     * @param sucCnt
     */
    public void setSucCnt(String sucCnt) {
        this.sucCnt = sucCnt;
    }

    /**
     * Column Info
     * @param errCnt
     */
    public void setErrCnt(String errCnt) {
        this.errCnt = errCnt;
    }
    
    /**
     * Column Info
     * @param dspoCd
     */
    public void setDspoCd(String dspoCd) {
    	this.dspoCd = dspoCd;
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
        setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
        setReason(JSPUtil.getParameter(request, prefix + "reason", ""));
        setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
        setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setCstmsRjctMsg(JSPUtil.getParameter(request, prefix + "cstms_rjct_msg", ""));
        setRjctFlg(JSPUtil.getParameter(request, prefix + "rjct_flg", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setCndAckErrNoteDesc(JSPUtil.getParameter(request, prefix + "cnd_ack_err_note_desc", ""));
        setVpodCd(JSPUtil.getParameter(request, prefix + "vpod_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setRcvDate(JSPUtil.getParameter(request, prefix + "rcv_date", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setScacCd(JSPUtil.getParameter(request, prefix + "scac_cd", ""));
        setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
        setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setRcvTm(JSPUtil.getParameter(request, prefix + "rcv_tm", ""));
        setCstmsBatNo(JSPUtil.getParameter(request, prefix + "cstms_bat_no", ""));
        setRcvMsgTpId(JSPUtil.getParameter(request, prefix + "rcv_msg_tp_id", ""));
        setTotCnt(JSPUtil.getParameter(request, prefix + "tot_cnt", ""));
        setSucCnt(JSPUtil.getParameter(request, prefix + "suc_cnt", ""));
        setErrCnt(JSPUtil.getParameter(request, prefix + "err_cnt", ""));
        setDspoCd(JSPUtil.getParameter(request, prefix + "dspo_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RcvHistListDetailVO[]
	 */
    public RcvHistListDetailVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RcvHistListDetailVO[]
	 */
    public RcvHistListDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        RcvHistListDetailVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] total = (JSPUtil.getParameter(request, prefix + "total", length));
            String[] reason = (JSPUtil.getParameter(request, prefix + "reason", length));
            String[] rcvSeq = (JSPUtil.getParameter(request, prefix + "rcv_seq", length));
            String[] ioBndCd = (JSPUtil.getParameter(request, prefix + "io_bnd_cd", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] cstmsRjctMsg = (JSPUtil.getParameter(request, prefix + "cstms_rjct_msg", length));
            String[] rjctFlg = (JSPUtil.getParameter(request, prefix + "rjct_flg", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] cndAckErrNoteDesc = (JSPUtil.getParameter(request, prefix + "cnd_ack_err_note_desc", length));
            String[] vpodCd = (JSPUtil.getParameter(request, prefix + "vpod_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] rcvDate = (JSPUtil.getParameter(request, prefix + "rcv_date", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] scacCd = (JSPUtil.getParameter(request, prefix + "scac_cd", length));
            String[] rnum = (JSPUtil.getParameter(request, prefix + "rnum", length));
            String[] rcvDt = (JSPUtil.getParameter(request, prefix + "rcv_dt", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] rcvTm = (JSPUtil.getParameter(request, prefix + "rcv_tm", length));
            String[] cstmsBatNo = (JSPUtil.getParameter(request, prefix + "cstms_bat_no", length));
            String[] rcvMsgTpId = (JSPUtil.getParameter(request, prefix + "rcv_msg_tp_id", length));
            String[] totCnt = (JSPUtil.getParameter(request, prefix + "tot_cnt", length));
            String[] sucCnt = (JSPUtil.getParameter(request, prefix + "suc_cnt", length));
            String[] errCnt = (JSPUtil.getParameter(request, prefix + "err_cnt", length));
            String[] dspoCd = (JSPUtil.getParameter(request, prefix + "dspo_cd", length));
            for (int i = 0; i < length; i++) {
                model = new RcvHistListDetailVO();
                if (total[i] != null)
                    model.setTotal(total[i]);
                if (reason[i] != null)
                    model.setReason(reason[i]);
                if (rcvSeq[i] != null)
                    model.setRcvSeq(rcvSeq[i]);
                if (ioBndCd[i] != null)
                    model.setIoBndCd(ioBndCd[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (cstmsRjctMsg[i] != null)
                    model.setCstmsRjctMsg(cstmsRjctMsg[i]);
                if (rjctFlg[i] != null)
                    model.setRjctFlg(rjctFlg[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (cndAckErrNoteDesc[i] != null)
                    model.setCndAckErrNoteDesc(cndAckErrNoteDesc[i]);
                if (vpodCd[i] != null)
                    model.setVpodCd(vpodCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (rcvDate[i] != null)
                    model.setRcvDate(rcvDate[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (scacCd[i] != null)
                    model.setScacCd(scacCd[i]);
                if (rnum[i] != null)
                    model.setRnum(rnum[i]);
                if (rcvDt[i] != null)
                    model.setRcvDt(rcvDt[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (rcvTm[i] != null)
                    model.setRcvTm(rcvTm[i]);
                if (cstmsBatNo[i] != null)
                    model.setCstmsBatNo(cstmsBatNo[i]);
                if (rcvMsgTpId[i] != null)
                    model.setRcvMsgTpId(rcvMsgTpId[i]);
                if (totCnt[i] != null)
                    model.setTotCnt(totCnt[i]);
                if (sucCnt[i] != null)
                    model.setSucCnt(sucCnt[i]);
                if (errCnt[i] != null)
                    model.setErrCnt(errCnt[i]);
                if (dspoCd[i] != null)
                    model.setDspoCd(dspoCd[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getRcvHistListDetailVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return RcvHistListDetailVO[]
	 */
    public RcvHistListDetailVO[] getRcvHistListDetailVOs() {
        RcvHistListDetailVO[] vos = (RcvHistListDetailVO[]) models.toArray(new RcvHistListDetailVO[models.size()]);
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
        this.total = this.total.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reason = this.reason.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvSeq = this.rcvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ioBndCd = this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsRjctMsg = this.cstmsRjctMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rjctFlg = this.rjctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cndAckErrNoteDesc = this.cndAckErrNoteDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpodCd = this.vpodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvDate = this.rcvDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scacCd = this.scacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rnum = this.rnum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvDt = this.rcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTm = this.rcvTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsBatNo = this.cstmsBatNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvMsgTpId = this.rcvMsgTpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totCnt = this.totCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sucCnt = this.sucCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errCnt = this.errCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dspoCd = this.dspoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
