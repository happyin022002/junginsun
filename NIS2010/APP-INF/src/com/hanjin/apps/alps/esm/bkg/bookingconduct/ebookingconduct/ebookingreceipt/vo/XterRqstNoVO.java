/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : XterRqstNoVO.java
*@FileTitle : XterRqstNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.05.25 전용진
* 1.0 Creation
* 2011.06.09 손은주 [CHM-201111364-01] EDI BKG# prefix 처리 로직 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class XterRqstNoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<XterRqstNoVO> models = new ArrayList<XterRqstNoVO>();

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String blNoCtnt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String rqstNo = null;

    /* Column Info */
    private String ffRefNo = null;

    /* Column Info */
    private String rqstSeq = null;

    /* Column Info */
    private String senderId = null;

    /* Column Info */
    private String siNo = null;

    /* Column Info */
    private String xterBlTpCd = null;

    /* Column Info */
    private String docTpCd = null;

    /* Column Info */
    private String preSeqDeltFlg = null;

    /* Column Info */
    private String custId = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String ctrtNm = null;

    /* Column Info */
    private String multiReject = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public XterRqstNoVO() {
    }

    public XterRqstNoVO(String ibflag, String pagerows, String bkgNo, String blNoCtnt, String ffRefNo, String rqstNo, String rqstSeq, String senderId, String siNo, String xterBlTpCd, String docTpCd, String preSeqDeltFlg, String custId, String porCd, String polCd, String podCd, String vvd, String ctrtNm, String multiReject) {
        this.bkgNo = bkgNo;
        this.blNoCtnt = blNoCtnt;
        this.ibflag = ibflag;
        this.rqstNo = rqstNo;
        this.ffRefNo = ffRefNo;
        this.rqstSeq = rqstSeq;
        this.senderId = senderId;
        this.siNo = siNo;
        this.xterBlTpCd = xterBlTpCd;
        this.docTpCd = docTpCd;
        this.preSeqDeltFlg = preSeqDeltFlg;
        this.custId = custId;
        this.pagerows = pagerows;
        this.porCd = porCd;
        this.polCd = polCd;
        this.podCd = podCd;
        this.vvd = vvd;
        this.ctrtNm = ctrtNm;
        this.multiReject = multiReject;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("bl_no_ctnt", getBlNoCtnt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("rqst_no", getRqstNo());
        this.hashColumns.put("ff_ref_no", getFfRefNo());
        this.hashColumns.put("rqst_seq", getRqstSeq());
        this.hashColumns.put("sender_id", getSenderId());
        this.hashColumns.put("si_no", getSiNo());
        this.hashColumns.put("xter_bl_tp_cd", getXterBlTpCd());
        this.hashColumns.put("doc_tp_cd", getDocTpCd());
        this.hashColumns.put("pre_seq_delt_flg", getPreSeqDeltFlg());
        this.hashColumns.put("cust_id", getCustId());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("ctrt_nm", getCtrtNm());
        this.hashColumns.put("multi_reject", getMultiReject());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("bl_no_ctnt", "blNoCtnt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("rqst_no", "rqstNo");
        this.hashFields.put("ff_ref_no", "ffRefNo");
        this.hashFields.put("rqst_seq", "rqstSeq");
        this.hashFields.put("sender_id", "senderId");
        this.hashFields.put("si_no", "siNo");
        this.hashFields.put("xter_bl_tp_cd", "xterBlTpCd");
        this.hashFields.put("doc_tp_cd", "docTpCd");
        this.hashFields.put("pre_seq_delt_flg", "preSeqDeltFlg");
        this.hashFields.put("cust_id", "custId");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("ctrt_nm", "ctrtNm");
        this.hashFields.put("multi_reject", "multiReject");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBlNoCtnt() {
        return this.blNoCtnt;
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
	 * @return rqstNo
	 */
    public String getRqstNo() {
        return this.rqstNo;
    }

    /**
	 * Column Info
	 * @return ffRefNo
	 */
    public String getFfRefNo() {
        return this.ffRefNo;
    }

    /**
	 * Column Info
	 * @return rqstSeq
	 */
    public String getRqstSeq() {
        return this.rqstSeq;
    }

    /**
	 * Column Info
	 * @return senderId
	 */
    public String getSenderId() {
        return this.senderId;
    }

    /**
	 * Column Info
	 * @return siNo
	 */
    public String getSiNo() {
        return siNo;
    }

    /**
	 * Column Info
	 * @return xterBlTpCd
	 */
    public String getXterBlTpCd() {
        return xterBlTpCd;
    }

    /**
	 * Column Info
	 * @return docTpCd
	 */
    public String getDocTpCd() {
        return docTpCd;
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
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNoCtnt(String blNoCtnt) {
        this.blNoCtnt = blNoCtnt;
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
	 * @param rqstNo
	 */
    public void setRqstNo(String rqstNo) {
        this.rqstNo = rqstNo;
    }

    /**
	 * Column Info
	 * @param ffRefNo
	 */
    public void setFfRefNo(String ffRefNo) {
        this.ffRefNo = ffRefNo;
    }

    /**
	 * Column Info
	 * @param rqstSeq
	 */
    public void setRqstSeq(String rqstSeq) {
        this.rqstSeq = rqstSeq;
    }

    /**
	 * Column Info
	 * @param senderId
	 */
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    /**
	 * Column Info
	 * @param siNo
	 */
    public void setSiNo(String siNo) {
        this.siNo = siNo;
    }

    /**
	 * Column Info
	 * @param xterBlTpCd
	 */
    public void setXterBlTpCd(String xterBlTpCd) {
        this.xterBlTpCd = xterBlTpCd;
    }

    /**
	 * Column Info
	 * @param docTpCd
	 */
    public void setDocTpCd(String docTpCd) {
        this.docTpCd = docTpCd;
    }

    public String getPreSeqDeltFlg() {
        return preSeqDeltFlg;
    }

    public void setPreSeqDeltFlg(String preSeqDeltFlg) {
        this.preSeqDeltFlg = preSeqDeltFlg;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    public String getPorCd() {
        return this.porCd;
    }

    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    public String getPolCd() {
        return this.polCd;
    }

    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    public String getPodCd() {
        return this.podCd;
    }

    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    public String getVvd() {
        return this.vvd;
    }

    public void setCtrtNm(String ctrtNm) {
        this.ctrtNm = ctrtNm;
    }

    public String getCtrtNm() {
        return this.ctrtNm;
    }

    public void setMultiReject(String multiReject) {
        this.multiReject = multiReject;
    }

    public String getMultiReject() {
        return this.multiReject;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
        setBlNoCtnt(JSPUtil.getParameter(request, "bl_no_ctnt", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setRqstNo(JSPUtil.getParameter(request, "rqst_no", ""));
        setFfRefNo(JSPUtil.getParameter(request, "ff_ref_no", ""));
        setRqstSeq(JSPUtil.getParameter(request, "rqst_seq", ""));
        setSenderId(JSPUtil.getParameter(request, "sender_id", ""));
        setSiNo(JSPUtil.getParameter(request, "si_no", ""));
        setXterBlTpCd(JSPUtil.getParameter(request, "xter_bl_tp_cd", ""));
        setDocTpCd(JSPUtil.getParameter(request, "doc_tp_cd", ""));
        setPreSeqDeltFlg(JSPUtil.getParameter(request, "pre_seq_delt_flg", ""));
        setCustId(JSPUtil.getParameter(request, "cust_id", ""));
        setMultiReject(JSPUtil.getParameter(request, "multi_reject", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setBlNoCtnt(JSPUtil.getParameter(request, prefix + "bl_no_ctnt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
        setFfRefNo(JSPUtil.getParameter(request, prefix + "ff_ref_no", ""));
        setRqstSeq(JSPUtil.getParameter(request, prefix + "rqst_seq", ""));
        setSenderId(JSPUtil.getParameter(request, prefix + "sender_id", ""));
        setSiNo(JSPUtil.getParameter(request, prefix + "si_no", ""));
        setXterBlTpCd(JSPUtil.getParameter(request, prefix + "xter_bl_tp_cd", ""));
        setDocTpCd(JSPUtil.getParameter(request, prefix + "doc_tp_cd", ""));
        setPreSeqDeltFlg(JSPUtil.getParameter(request, prefix + "pre_seq_delt_flg", ""));
        setCustId(JSPUtil.getParameter(request, prefix + "cust_id", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setCtrtNm(JSPUtil.getParameter(request, prefix + "ctrt_nm", ""));
        setMultiReject(JSPUtil.getParameter(request, prefix + "multi_reject", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterRqstNoVO[]
	 */
    public XterRqstNoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return XterRqstNoVO[]
	 */
    public XterRqstNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        XterRqstNoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no".trim(), length));
            String[] blNoCtnt = (JSPUtil.getParameter(request, prefix + "bl_no_ctnt".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] rqstNo = (JSPUtil.getParameter(request, prefix + "rqst_no".trim(), length));
            String[] ffRefNo = (JSPUtil.getParameter(request, prefix + "ff_ref_no".trim(), length));
            String[] rqstSeq = (JSPUtil.getParameter(request, prefix + "rqst_seq".trim(), length));
            String[] senderId = (JSPUtil.getParameter(request, prefix + "sender_id".trim(), length));
            String[] siNo = (JSPUtil.getParameter(request, prefix + "si_no".trim(), length));
            String[] xterBlTpCd = (JSPUtil.getParameter(request, prefix + "xter_bl_tp_cd".trim(), length));
            String[] docTpCd = (JSPUtil.getParameter(request, prefix + "doc_tp_cd".trim(), length));
            String[] preSeqDeltFlg = (JSPUtil.getParameter(request, prefix + "pre_seq_delt_flg".trim(), length));
            String[] custId = (JSPUtil.getParameter(request, prefix + "cust_id".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] ctrtNm = (JSPUtil.getParameter(request, prefix + "ctrt_nm", length));
            String[] multiReject = (JSPUtil.getParameter(request, prefix + "multi_reject", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new XterRqstNoVO();
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (blNoCtnt[i] != null)
                    model.setBlNoCtnt(blNoCtnt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (rqstNo[i] != null)
                    model.setRqstNo(rqstNo[i]);
                if (ffRefNo[i] != null)
                    model.setFfRefNo(ffRefNo[i]);
                if (rqstSeq[i] != null)
                    model.setRqstSeq(rqstSeq[i]);
                if (senderId[i] != null)
                    model.setSenderId(senderId[i]);
                if (siNo[i] != null)
                    model.setSiNo(siNo[i]);
                if (xterBlTpCd[i] != null)
                    model.setXterBlTpCd(xterBlTpCd[i]);
                if (docTpCd[i] != null)
                    model.setDocTpCd(docTpCd[i]);
                if (preSeqDeltFlg[i] != null)
                    model.setPreSeqDeltFlg(preSeqDeltFlg[i]);
                if (custId[i] != null)
                    model.setCustId(custId[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (ctrtNm[i] != null)
                    model.setCtrtNm(ctrtNm[i]);
                if (multiReject[i] != null) 
		    		model.setMultiReject(multiReject[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getXterRqstNoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return XterRqstNoVO[]
	 */
    public XterRqstNoVO[] getXterRqstNoVOs() {
        XterRqstNoVO[] vos = (XterRqstNoVO[]) models.toArray(new XterRqstNoVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
                        ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
                    }
                } else {
                    ret.append(field[i].getName() + " =  null \n");
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return ret.toString();
    }

    /**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNoCtnt = this.blNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstNo = this.rqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffRefNo = this.ffRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstSeq = this.rqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.senderId = this.senderId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siNo = this.siNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterBlTpCd = this.xterBlTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docTpCd = this.docTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preSeqDeltFlg = this.preSeqDeltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custId = this.custId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtNm = this.ctrtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.multiReject = this.multiReject.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
