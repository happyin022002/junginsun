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
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

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

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String bkgCntcPsonEml = null;

    /* Column Info */
    private String blPrfShprFlg = null;

    /* Column Info */
    private String newEmail = null;

    /* Column Info */
    private String newOfcCd = null;

    /* Column Info */
    private String docTp = null;

    /* Column Info */
    private String userId = null;

    /* Column Info */
    private String upldFlg = null;

    /* Column Info */
    private String ackRcv = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public XterRqstNoVO() {
    }

    public XterRqstNoVO(String ibflag, String pagerows, String bkgNo, String ffRefNo, String rqstNo, String rqstSeq, String senderId, String siNo, String xterBlTpCd, String docTpCd, String bkgCntcPsonEml, String blPrfShprFlg, String newEmail, String newOfcCd, String docTp, String userId, String upldFlg, String ackRcv) {
        this.bkgNo = bkgNo;
        this.ibflag = ibflag;
        this.rqstNo = rqstNo;
        this.ffRefNo = ffRefNo;
        this.rqstSeq = rqstSeq;
        this.senderId = senderId;
        this.siNo = siNo;
        this.xterBlTpCd = xterBlTpCd;
        this.docTpCd = docTpCd;
        this.pagerows = pagerows;
        this.bkgCntcPsonEml = bkgCntcPsonEml;
        this.blPrfShprFlg = blPrfShprFlg;
        this.newEmail = newEmail;
        this.newOfcCd = newOfcCd;
        this.docTp = docTp;
        this.userId = userId;
        this.upldFlg = upldFlg;
        this.ackRcv = ackRcv;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("rqst_no", getRqstNo());
        this.hashColumns.put("ff_ref_no", getFfRefNo());
        this.hashColumns.put("rqst_seq", getRqstSeq());
        this.hashColumns.put("sender_id", getSenderId());
        this.hashColumns.put("si_no", getSiNo());
        this.hashColumns.put("xter_bl_tp_cd", getXterBlTpCd());
        this.hashColumns.put("doc_tp_cd", getDocTpCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_cntc_pson_eml", getBkgCntcPsonEml());
        this.hashColumns.put("bl_prf_shpr_flg", getBlPrfShprFlg());
        this.hashColumns.put("new_email", getNewEmail());
        this.hashColumns.put("new_ofc_cd", getNewOfcCd());
        this.hashColumns.put("doc_tp", getDocTp());
        this.hashColumns.put("user_id", getUserId());
        this.hashColumns.put("upld_flg", getUpldFlg());
        this.hashColumns.put("ack_rcv", getAckRcv());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("rqst_no", "rqstNo");
        this.hashFields.put("ff_ref_no", "ffRefNo");
        this.hashFields.put("rqst_seq", "rqstSeq");
        this.hashFields.put("sender_id", "senderId");
        this.hashFields.put("si_no", "siNo");
        this.hashFields.put("xter_bl_tp_cd", "xterBlTpCd");
        this.hashFields.put("doc_tp_cd", "docTpCd");
        this.hashFields.put("edi_seq", "ediSeq");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bkg_cntc_pson_eml", "bkgCntcPsonEml");
        this.hashFields.put("bl_prf_shpr_flg", "blPrfShprFlg");
        this.hashFields.put("new_email", "newEmail");
        this.hashFields.put("new_ofc_cd", "newOfcCd");
        this.hashFields.put("doc_tp", "docTp");
        this.hashFields.put("user_id", "userId");
        this.hashFields.put("flat_file_str", "flatFileStr");
        this.hashFields.put("upld_flg", "upldFlg");
        this.hashFields.put("ack_rcv", "ackRcv");
        this.hashFields.put("edi_no", "ediNo");
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
	 * @return newEmail
	 */
    public String getNewEmail() {
        return newEmail;
    }

    /**
	 * Column Info
	 * @return newOfcCd
	 */
    public String getNewOfcCd() {
        return newOfcCd;
    }

    /**
	 * Column Info
	 * @return docTp
	 */
    public String getDocTp() {
        return docTp;
    }

    /**
	 * Column Info
	 * @return userId
	 */
    public String getUserId() {
        return userId;
    }

    /**
	 * Column Info
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
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

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setBkgCntcPsonEml(String bkgCntcPsonEml) {
        this.bkgCntcPsonEml = bkgCntcPsonEml;
    }

    public String getBkgCntcPsonEml() {
        return this.bkgCntcPsonEml;
    }

    public void setBlPrfShprFlg(String blPrfShprFlg) {
        this.blPrfShprFlg = blPrfShprFlg;
    }

    public String getBlPrfShprFlg() {
        return this.blPrfShprFlg;
    }

    /**
	 * Column Info
	 * @param newEmail
	 */
    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    /**
	 * Column Info
	 * @param newOfcCd
	 */
    public void setNewOfcCd(String newOfcCd) {
        this.newOfcCd = newOfcCd;
    }

    /**
	 * Column Info
	 * @param docTp
	 */
    public void setDocTp(String docTp) {
        this.docTp = docTp;
    }

    /**
	 * Column Info
	 * @param userId
	 */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUpldFlg(String upldFlg) {
        this.upldFlg = upldFlg;
    }

    public String getUpldFlg() {
        return this.upldFlg;
    }

    public void setAckRcv(String ackRcv) {
        this.ackRcv = ackRcv;
    }

    public String getAckRcv() {
        return this.ackRcv;
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
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
        setFfRefNo(JSPUtil.getParameter(request, prefix + "ff_ref_no", ""));
        setRqstSeq(JSPUtil.getParameter(request, prefix + "rqst_seq", ""));
        setSenderId(JSPUtil.getParameter(request, prefix + "sender_id", ""));
        setSiNo(JSPUtil.getParameter(request, prefix + "si_no", ""));
        setXterBlTpCd(JSPUtil.getParameter(request, prefix + "xter_bl_tp_cd", ""));
        setDocTpCd(JSPUtil.getParameter(request, prefix + "doc_tp_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setBkgCntcPsonEml(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_eml", ""));
        setBlPrfShprFlg(JSPUtil.getParameter(request, prefix + "bl_prf_shpr_flg", ""));
        setNewEmail(JSPUtil.getParameter(request, prefix + "new_email", ""));
        setNewOfcCd(JSPUtil.getParameter(request, prefix + "new_ofc_cd", ""));
        setDocTp(JSPUtil.getParameter(request, prefix + "doc_tp", ""));
        setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
        setUpldFlg(JSPUtil.getParameter(request, prefix + "upld_flg", ""));
        setAckRcv(JSPUtil.getParameter(request, prefix + "ack_rcv", ""));
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
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] rqstNo = (JSPUtil.getParameter(request, prefix + "rqst_no".trim(), length));
            String[] ffRefNo = (JSPUtil.getParameter(request, prefix + "ff_ref_no".trim(), length));
            String[] rqstSeq = (JSPUtil.getParameter(request, prefix + "rqst_seq".trim(), length));
            String[] senderId = (JSPUtil.getParameter(request, prefix + "sender_id".trim(), length));
            String[] siNo = (JSPUtil.getParameter(request, prefix + "si_no".trim(), length));
            String[] xterBlTpCd = (JSPUtil.getParameter(request, prefix + "xter_bl_tp_cd".trim(), length));
            String[] docTpCd = (JSPUtil.getParameter(request, prefix + "doc_tp_cd".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] bkgCntcPsonEml = (JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_eml", length));
            String[] blPrfShprFlg = (JSPUtil.getParameter(request, prefix + "bl_prf_shpr_flg", length));
            String[] newEmail = (JSPUtil.getParameter(request, prefix + "new_email", length));
            String[] newOfcCd = (JSPUtil.getParameter(request, prefix + "new_ofc_cd", length));
            String[] docTp = (JSPUtil.getParameter(request, prefix + "doc_tp".trim(), length));
            String[] userId = (JSPUtil.getParameter(request, prefix + "user_id".trim(), length));
            String[] upldFlg = (JSPUtil.getParameter(request, prefix + "upld_flg", length));
            String[] ackRcv = (JSPUtil.getParameter(request, prefix + "ack_rcv", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new XterRqstNoVO();
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
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
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgCntcPsonEml[i] != null)
                    model.setBkgCntcPsonEml(bkgCntcPsonEml[i]);
                if (blPrfShprFlg[i] != null)
                    model.setBlPrfShprFlg(blPrfShprFlg[i]);
                if (newEmail[i] != null)
                    model.setNewEmail(newEmail[i]);
                if (newOfcCd[i] != null)
                    model.setNewOfcCd(newOfcCd[i]);
                if (docTp[i] != null)
                    model.setDocTp(docTp[i]);
                if (userId[i] != null)
                    model.setUserId(userId[i]);
                if (upldFlg[i] != null)
                    model.setUpldFlg(upldFlg[i]);
                if (ackRcv[i] != null)
                    model.setAckRcv(ackRcv[i]);
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
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstNo = this.rqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffRefNo = this.ffRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstSeq = this.rqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.senderId = this.senderId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siNo = this.siNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterBlTpCd = this.xterBlTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docTpCd = this.docTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCntcPsonEml = this.bkgCntcPsonEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blPrfShprFlg = this.blPrfShprFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newEmail = this.blPrfShprFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newOfcCd = this.blPrfShprFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docTp = this.docTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.userId = this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.upldFlg = this.upldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ackRcv = this.ackRcv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
