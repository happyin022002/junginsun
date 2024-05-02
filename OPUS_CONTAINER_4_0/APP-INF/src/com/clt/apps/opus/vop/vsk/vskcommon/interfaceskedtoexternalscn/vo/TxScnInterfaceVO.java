/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TxScnInterfaceVO.java
*@FileTitle : TxScnInterfaceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.12  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.vo;

import java.lang.reflect.Field;
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
public class TxScnInterfaceVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<TxScnInterfaceVO> models = new ArrayList<TxScnInterfaceVO>();

    /* Column Info */
    private String vpsPortCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String insfCnqeVal = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String insfDvCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String cssmVoyNoIfSeq = null;

    private String newInsfCnqeVal = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String newInsfDvCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String newTxTpCd = null;

    /* Column Info */
    private String ibCssmVoyNo = null;

    /* Column Info */
    private String obCssmVoyNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public TxScnInterfaceVO() {
    }

    public TxScnInterfaceVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String cssmVoyNoIfSeq, String insfCnqeVal, String insfDvCd, String newInsfCnqeVal, String newInsfDvCd, String newTxTpCd, String ibCssmVoyNo, String obCssmVoyNo) {
        this.vpsPortCd = vpsPortCd;
        this.vslCd = vslCd;
        this.insfCnqeVal = insfCnqeVal;
        this.ibflag = ibflag;
        this.insfDvCd = insfDvCd;
        this.skdVoyNo = skdVoyNo;
        this.cssmVoyNoIfSeq = cssmVoyNoIfSeq;
        this.newInsfCnqeVal = newInsfCnqeVal;
        this.skdDirCd = skdDirCd;
        this.newInsfDvCd = newInsfDvCd;
        this.pagerows = pagerows;
        this.newTxTpCd = newTxTpCd;
        this.ibCssmVoyNo = ibCssmVoyNo;
        this.obCssmVoyNo = obCssmVoyNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("insf_cnqe_val", getInsfCnqeVal());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("insf_dv_cd", getInsfDvCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("cssm_voy_no_if_seq", getCssmVoyNoIfSeq());
        this.hashColumns.put("new_insf_cnqe_val", getNewInsfCnqeVal());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("new_insf_dv_cd", getNewInsfDvCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("new_tx_tp_cd", getNewTxTpCd());
        this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("insf_dv_cd", "insfDvCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("cssm_voy_no_if_seq", "cssmVoyNoIfSeq");
        this.hashFields.put("new_insf_cnqe_val", "newInsfCnqeVal");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("new_insf_dv_cd", "newInsfDvCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("new_tx_tp_cd", "newTxTpCd");
        this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return vpsPortCd
	 */
    public String getVpsPortCd() {
        return this.vpsPortCd;
    }

    /**
	 * Column Info
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 * Column Info
	 * @return insfCnqeVal
	 */
    public String getInsfCnqeVal() {
        return this.insfCnqeVal;
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
	 * @return insfDvCd
	 */
    public String getInsfDvCd() {
        return this.insfDvCd;
    }

    /**
	 * Column Info
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return cssmVoyNoIfSeq
	 */
    public String getCssmVoyNoIfSeq() {
        return this.cssmVoyNoIfSeq;
    }

    /**
	 * Column Info
	 * @return newInsfCnqeVal
	 */
    public String getNewInsfCnqeVal() {
        return this.newInsfCnqeVal;
    }

    /**
	 * Column Info
	 * @return skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 * Column Info
	 * @return newInsfDvCd
	 */
    public String getNewInsfDvCd() {
        return this.newInsfDvCd;
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
	 * @param vpsPortCd
	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
    }

    /**
	 * Column Info
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param insfCnqeVal
	 */
    public void setInsfCnqeVal(String insfCnqeVal) {
        this.insfCnqeVal = insfCnqeVal;
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
	 * @param insfDvCd
	 */
    public void setInsfDvCd(String insfDvCd) {
        this.insfDvCd = insfDvCd;
    }

    /**
	 * Column Info
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param cssmVoyNoIfSeq
	 */
    public void setCssmVoyNoIfSeq(String cssmVoyNoIfSeq) {
        this.cssmVoyNoIfSeq = cssmVoyNoIfSeq;
    }

    /**
	 * Column Info
	 * @param skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param newInsfDvCd
	 */
    public void setNewInsfDvCd(String newInsfDvCd) {
        this.newInsfDvCd = newInsfDvCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setNewInsfCnqeVal(String newInsfCnqeVal) {
        this.newInsfCnqeVal = newInsfCnqeVal;
    }

    public void setNewTxTpCd(String newTxTpCd) {
        this.newTxTpCd = newTxTpCd;
    }

    public String getNewTxTpCd() {
        return this.newTxTpCd;
    }

    public void setIbCssmVoyNo(String ibCssmVoyNo) {
        this.ibCssmVoyNo = ibCssmVoyNo;
    }

    public String getIbCssmVoyNo() {
        return this.ibCssmVoyNo;
    }

    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
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
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setInsfCnqeVal(JSPUtil.getParameter(request, prefix + "insf_cnqe_val", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setInsfDvCd(JSPUtil.getParameter(request, prefix + "insf_dv_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setCssmVoyNoIfSeq(JSPUtil.getParameter(request, prefix + "cssm_voy_no_if_seq", ""));
        setNewInsfCnqeVal(JSPUtil.getParameter(request, prefix + "new_insf_cnqe_val", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setNewInsfDvCd(JSPUtil.getParameter(request, prefix + "new_insf_dv_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setNewInsfCnqeVal(JSPUtil.getParameter(request, prefix + "new_insf_cnqe_val", ""));
        setNewTxTpCd(JSPUtil.getParameter(request, prefix + "new_tx_tp_cd", ""));
        setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TxScnInterfaceVO[]
	 */
    public TxScnInterfaceVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TxScnInterfaceVO[]
	 */
    public TxScnInterfaceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        TxScnInterfaceVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] insfCnqeVal = (JSPUtil.getParameter(request, prefix + "insf_cnqe_val", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] insfDvCd = (JSPUtil.getParameter(request, prefix + "insf_dv_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] cssmVoyNoIfSeq = (JSPUtil.getParameter(request, prefix + "cssm_voy_no_if_seq", length));
            String[] newInsfCnqeVal = (JSPUtil.getParameter(request, prefix + "new_insf_cnqe_val", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] newInsfDvCd = (JSPUtil.getParameter(request, prefix + "new_insf_dv_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] newTxTpCd = (JSPUtil.getParameter(request, prefix + "new_tx_tp_cd", length));
            String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", length));
	    	String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new TxScnInterfaceVO();
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (insfCnqeVal[i] != null)
                    model.setInsfCnqeVal(insfCnqeVal[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (insfDvCd[i] != null)
                    model.setInsfDvCd(insfDvCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (cssmVoyNoIfSeq[i] != null)
                    model.setCssmVoyNoIfSeq(cssmVoyNoIfSeq[i]);
                if (newInsfCnqeVal[i] != null)
                    model.setNewInsfCnqeVal(newInsfCnqeVal[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (newInsfDvCd[i] != null)
                    model.setNewInsfDvCd(newInsfDvCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (newInsfCnqeVal[i] != null)
                    model.setNewInsfCnqeVal(newInsfCnqeVal[i]);
                if (newTxTpCd[i] != null)
                    model.setNewTxTpCd(newTxTpCd[i]);
                if (ibCssmVoyNo[i] != null) 
		    		model.setIbCssmVoyNo(ibCssmVoyNo[i]);
				if (obCssmVoyNo[i] != null) 
		    		model.setObCssmVoyNo(obCssmVoyNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getTxScnInterfaceVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return TxScnInterfaceVO[]
	 */
    public TxScnInterfaceVO[] getTxScnInterfaceVOs() {
        TxScnInterfaceVO[] vos = (TxScnInterfaceVO[]) models.toArray(new TxScnInterfaceVO[models.size()]);
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
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfCnqeVal = this.insfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfDvCd = this.insfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cssmVoyNoIfSeq = this.cssmVoyNoIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newInsfCnqeVal = this.newInsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newInsfDvCd = this.newInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newInsfCnqeVal = this.newInsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newTxTpCd = this.newTxTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCssmVoyNo = this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
