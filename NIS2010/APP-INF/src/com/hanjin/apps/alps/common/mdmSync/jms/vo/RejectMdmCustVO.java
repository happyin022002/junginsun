/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RejectMdmCustVO.java
*@FileTitle : RejectMdmCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.08
*@LastModifier : jklim
*@LastVersion : 1.0
* 2017.08.08 jklim 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class RejectMdmCustVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<RejectMdmCustVO> models = new ArrayList<RejectMdmCustVO>();

    /* Column Info */
    private String updDt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String eaiEvntDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String eaiIfId = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String custRqstId = null;

    /* Column Info */
    private String actCd = null;

    /* Column Info */
    private String actRsn = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String rtnEml = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public RejectMdmCustVO() {
    }

    public RejectMdmCustVO(String ibflag, String pagerows, String updUsrId, String updDt, String eaiEvntDt, String custCntCd, String custSeq, String eaiIfId, String custCd, String custRqstId, String actCd, String actRsn, String usrId, String rtnEml) {
        this.updDt = updDt;
        this.ibflag = ibflag;
        this.custSeq = custSeq;
        this.custCntCd = custCntCd;
        this.eaiEvntDt = eaiEvntDt;
        this.updUsrId = updUsrId;
        this.pagerows = pagerows;
        this.eaiIfId = eaiIfId;
        this.custCd = custCd;
        this.custRqstId = custRqstId;
        this.actCd = actCd;
        this.actRsn = actRsn;
        this.usrId = usrId;
        this.rtnEml = rtnEml;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("eai_if_id", getEaiIfId());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("cust_rqst_id", getCustRqstId());
        this.hashColumns.put("act_cd", getActCd());
        this.hashColumns.put("act_rsn", getActRsn());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("rtn_eml", getRtnEml());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("eai_if_id", "eaiIfId");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("cust_rqst_id", "custRqstId");
        this.hashFields.put("act_cd", "actCd");
        this.hashFields.put("act_rsn", "actRsn");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("rtn_eml", "rtnEml");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	 * Column Info
	 * @return custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 * Column Info
	 * @return eaiEvntDt
	 */
    public String getEaiEvntDt() {
        return this.eaiEvntDt;
    }

    /**
	 * Column Info
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
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
	 * @return eaiIfId
	 */
    public String getEaiIfId() {
        return this.eaiIfId;
    }

    /**
	 * Column Info
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
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
	 * @param custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * Column Info
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * Column Info
	 * @param eaiEvntDt
	 */
    public void setEaiEvntDt(String eaiEvntDt) {
        this.eaiEvntDt = eaiEvntDt;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
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
	 * @param eaiIfId
	 */
    public void setEaiIfId(String eaiIfId) {
        this.eaiIfId = eaiIfId;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    public String getCustCd() {
        return this.custCd;
    }

    public void setCustRqstId(String custRqstId) {
        this.custRqstId = custRqstId;
    }

    public String getCustRqstId() {
        return this.custRqstId;
    }

    public void setActCd(String actCd) {
        this.actCd = actCd;
    }

    public String getActCd() {
        return this.actCd;
    }

    public void setActRsn(String actRsn) {
        this.actRsn = actRsn;
    }

    public String getActRsn() {
        return this.actRsn;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrId() {
        return this.usrId;
    }

    public void setRtnEml(String rtnEml) {
        this.rtnEml = rtnEml;
    }

    public String getRtnEml() {
        return this.rtnEml;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
        setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
        setEaiEvntDt(JSPUtil.getParameter(request, "eai_evnt_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setEaiIfId(JSPUtil.getParameter(request, "eai_if_id", ""));
        
        setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
        setCustRqstId(JSPUtil.getParameter(request, "cust_rqst_id", ""));
        setActCd(JSPUtil.getParameter(request, "act_cd", ""));
        setActRsn(JSPUtil.getParameter(request, "act_rsn", ""));
        setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
        setRtnEml(JSPUtil.getParameter(request, "rtn_eml", ""));
        
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RejectMdmCustVO[]
	 */
    public RejectMdmCustVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RejectMdmCustVO[]
	 */
    public RejectMdmCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        RejectMdmCustVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix + "eai_evnt_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] eaiIfId = (JSPUtil.getParameter(request, prefix + "eai_if_id", length));
            
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] custRqstId = (JSPUtil.getParameter(request, prefix + "cust_rqst_id", length));
            String[] actCd = (JSPUtil.getParameter(request, prefix + "act_cd", length));
            String[] actRsn = (JSPUtil.getParameter(request, prefix + "act_rsn", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] rtnEml = (JSPUtil.getParameter(request, prefix + "rtn_eml", length));
            
				/* Add a Method line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new RejectMdmCustVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (eaiEvntDt[i] != null)
                    model.setEaiEvntDt(eaiEvntDt[i]);
                if (eaiEvntDt[i] != null)
                    model.setEaiEvntDt(eaiEvntDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (eaiIfId[i] != null)
                    model.setEaiIfId(eaiIfId[i]);
                if (custCd[i] != null) 
		    		model.setCustCd(custCd[i]);
				if (custRqstId[i] != null) 
		    		model.setCustRqstId(custRqstId[i]);
				if (actCd[i] != null) 
		    		model.setActCd(actCd[i]);
				if (actRsn[i] != null) 
		    		model.setActRsn(actRsn[i]);
				if (usrId[i] != null) 
		    		model.setUsrId(usrId[i]);
				if (rtnEml[i] != null) 
		    		model.setRtnEml(rtnEml[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getRejectMdmCustVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return RejectMdmCustVO[]
	 */
    public RejectMdmCustVO[] getRejectMdmCustVOs() {
        RejectMdmCustVO[] vos = (RejectMdmCustVO[]) models.toArray(new RejectMdmCustVO[models.size()]);
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
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiEvntDt = this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiIfId = this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRqstId = this.custRqstId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actCd = this.actCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actRsn = this.actRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtnEml = this.rtnEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
