/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgXterRevMsgVO.java
*@FileTitle : BkgXterRevMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.06.05 이도형 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgXterRevMsgVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgXterRevMsgVO> models = new ArrayList<BkgXterRevMsgVO>();

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String bkgXterRcvMsgSeq = null;

    /* Column Info */
    private String xterSndrId = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String xmlAndEdiMsgDesc = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String xterRqstSeq = null;

    /* Column Info */
    private String upldFlg = null;

    /* Column Info */
    private String xterRqstNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String msgType = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgXterRevMsgVO() {
    }

    public BkgXterRevMsgVO(String ibflag, String pagerows, String bkgXterRcvMsgSeq, String upldFlg, String xterSndrId, String xterRqstNo, String xterRqstSeq, String xmlAndEdiMsgDesc, String creDt, String updDt, String msgType) {
        this.updDt = updDt;
        this.bkgXterRcvMsgSeq = bkgXterRcvMsgSeq;
        this.xterSndrId = xterSndrId;
        this.ibflag = ibflag;
        this.xmlAndEdiMsgDesc = xmlAndEdiMsgDesc;
        this.creDt = creDt;
        this.xterRqstSeq = xterRqstSeq;
        this.upldFlg = upldFlg;
        this.xterRqstNo = xterRqstNo;
        this.pagerows = pagerows;
        this.msgType = msgType;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("bkg_xter_rcv_msg_seq", getBkgXterRcvMsgSeq());
        this.hashColumns.put("xter_sndr_id", getXterSndrId());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("xml_and_edi_msg_desc", getXmlAndEdiMsgDesc());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
        this.hashColumns.put("upld_flg", getUpldFlg());
        this.hashColumns.put("xter_rqst_no", getXterRqstNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("msg_type", getMsgType());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("bkg_xter_rcv_msg_seq", "bkgXterRcvMsgSeq");
        this.hashFields.put("xter_sndr_id", "xterSndrId");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("xml_and_edi_msg_desc", "xmlAndEdiMsgDesc");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
        this.hashFields.put("upld_flg", "upldFlg");
        this.hashFields.put("xter_rqst_no", "xterRqstNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("msg_type", "msgType");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Column Info
	 * @return bkgXterRcvMsgSeq
	 */
    public String getBkgXterRcvMsgSeq() {
        return this.bkgXterRcvMsgSeq;
    }

    /**
	 * Column Info
	 * @return xterSndrId
	 */
    public String getXterSndrId() {
        return this.xterSndrId;
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
	 * @return xmlAndEdiMsgDesc
	 */
    public String getXmlAndEdiMsgDesc() {
        return this.xmlAndEdiMsgDesc;
    }

    /**
	 * Column Info
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Column Info
	 * @return xterRqstSeq
	 */
    public String getXterRqstSeq() {
        return this.xterRqstSeq;
    }

    /**
	 * Column Info
	 * @return upldFlg
	 */
    public String getUpldFlg() {
        return this.upldFlg;
    }

    /**
	 * Column Info
	 * @return xterRqstNo
	 */
    public String getXterRqstNo() {
        return this.xterRqstNo;
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
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param bkgXterRcvMsgSeq
	 */
    public void setBkgXterRcvMsgSeq(String bkgXterRcvMsgSeq) {
        this.bkgXterRcvMsgSeq = bkgXterRcvMsgSeq;
    }

    /**
	 * Column Info
	 * @param xterSndrId
	 */
    public void setXterSndrId(String xterSndrId) {
        this.xterSndrId = xterSndrId;
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
	 * @param xmlAndEdiMsgDesc
	 */
    public void setXmlAndEdiMsgDesc(String xmlAndEdiMsgDesc) {
        this.xmlAndEdiMsgDesc = xmlAndEdiMsgDesc;
    }

    /**
	 * Column Info
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param xterRqstSeq
	 */
    public void setXterRqstSeq(String xterRqstSeq) {
        this.xterRqstSeq = xterRqstSeq;
    }

    /**
	 * Column Info
	 * @param upldFlg
	 */
    public void setUpldFlg(String upldFlg) {
        this.upldFlg = upldFlg;
    }

    /**
	 * Column Info
	 * @param xterRqstNo
	 */
    public void setXterRqstNo(String xterRqstNo) {
        this.xterRqstNo = xterRqstNo;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgType() {
        return this.msgType;
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
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setBkgXterRcvMsgSeq(JSPUtil.getParameter(request, prefix + "bkg_xter_rcv_msg_seq", ""));
        setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setXmlAndEdiMsgDesc(JSPUtil.getParameter(request, prefix + "xml_and_edi_msg_desc", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
        setUpldFlg(JSPUtil.getParameter(request, prefix + "upld_flg", ""));
        setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setMsgType(JSPUtil.getParameter(request, prefix + "msg_type", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterRevMsgVO[]
	 */
    public BkgXterRevMsgVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgXterRevMsgVO[]
	 */
    public BkgXterRevMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgXterRevMsgVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] bkgXterRcvMsgSeq = (JSPUtil.getParameter(request, prefix + "bkg_xter_rcv_msg_seq", length));
            String[] xterSndrId = (JSPUtil.getParameter(request, prefix + "xter_sndr_id", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] xmlAndEdiMsgDesc = (JSPUtil.getParameter(request, prefix + "xml_and_edi_msg_desc", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix + "xter_rqst_seq", length));
            String[] upldFlg = (JSPUtil.getParameter(request, prefix + "upld_flg", length));
            String[] xterRqstNo = (JSPUtil.getParameter(request, prefix + "xter_rqst_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            for (int i = 0; i < length; i++) {
                model = new BkgXterRevMsgVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (bkgXterRcvMsgSeq[i] != null)
                    model.setBkgXterRcvMsgSeq(bkgXterRcvMsgSeq[i]);
                if (xterSndrId[i] != null)
                    model.setXterSndrId(xterSndrId[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (xmlAndEdiMsgDesc[i] != null)
                    model.setXmlAndEdiMsgDesc(xmlAndEdiMsgDesc[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (xterRqstSeq[i] != null)
                    model.setXterRqstSeq(xterRqstSeq[i]);
                if (upldFlg[i] != null)
                    model.setUpldFlg(upldFlg[i]);
                if (xterRqstNo[i] != null)
                    model.setXterRqstNo(xterRqstNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgXterRevMsgVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgXterRevMsgVO[]
	 */
    public BkgXterRevMsgVO[] getBkgXterRevMsgVOs() {
        BkgXterRevMsgVO[] vos = (BkgXterRevMsgVO[]) models.toArray(new BkgXterRevMsgVO[models.size()]);
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
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgXterRcvMsgSeq = this.bkgXterRcvMsgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterSndrId = this.xterSndrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xmlAndEdiMsgDesc = this.xmlAndEdiMsgDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstSeq = this.xterRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.upldFlg = this.upldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstNo = this.xterRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgType = this.msgType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
