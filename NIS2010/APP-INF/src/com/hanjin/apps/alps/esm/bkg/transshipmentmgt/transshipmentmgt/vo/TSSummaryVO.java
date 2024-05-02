/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TSSummaryVO.java
*@FileTitle : TSSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.13  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

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
public class TSSummaryVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<TSSummaryVO> models = new ArrayList<TSSummaryVO>();

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String eta = null;

    /* Column Info */
    private String rf40 = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String polYdCd = null;

    /* Column Info */
    private String podYdCd = null;

    /* Column Info */
    private String pYdCd = null;

    /* Column Info */
    private String ft40 = null;

    /* Column Info */
    private String rf20 = null;

    /* Column Info */
    private String ft20 = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String lane = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public TSSummaryVO() {
    }

    public TSSummaryVO(String ibflag, String pagerows, String vvd, String rf40, String rf20, String ft20, String ft40, String podYdCd, String polYdCd, String eta, String pYdCd, String lane) {
        this.vvd = vvd;
        this.eta = eta;
        this.rf40 = rf40;
        this.ibflag = ibflag;
        this.polYdCd = polYdCd;
        this.podYdCd = podYdCd;
        this.pYdCd = pYdCd;
        this.ft40 = ft40;
        this.rf20 = rf20;
        this.ft20 = ft20;
        this.pagerows = pagerows;
        this.lane = lane;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("eta", getEta());
        this.hashColumns.put("rf40", getRf40());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("p_yd_cd", getPYdCd());
        this.hashColumns.put("ft40", getFt40());
        this.hashColumns.put("rf20", getRf20());
        this.hashColumns.put("ft20", getFt20());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("lane", getLane());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("eta", "eta");
        this.hashFields.put("rf40", "rf40");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("p_yd_cd", "pYdCd");
        this.hashFields.put("ft40", "ft40");
        this.hashFields.put("rf20", "rf20");
        this.hashFields.put("ft20", "ft20");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("lane", "lane");
        return this.hashFields;
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
	 * @return eta
	 */
    public String getEta() {
        return this.eta;
    }

    /**
	 * Column Info
	 * @return rf40
	 */
    public String getRf40() {
        return this.rf40;
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
	 * @return polYdCd
	 */
    public String getPolYdCd() {
        return this.polYdCd;
    }

    /**
	 * Column Info
	 * @return podYdCd
	 */
    public String getPodYdCd() {
        return this.podYdCd;
    }

    /**
	 * Column Info
	 * @return pYdCd
	 */
    public String getPYdCd() {
        return this.pYdCd;
    }

    /**
	 * Column Info
	 * @return ft40
	 */
    public String getFt40() {
        return this.ft40;
    }

    /**
	 * Column Info
	 * @return rf20
	 */
    public String getRf20() {
        return this.rf20;
    }

    /**
	 * Column Info
	 * @return ft20
	 */
    public String getFt20() {
        return this.ft20;
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
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param eta
	 */
    public void setEta(String eta) {
        this.eta = eta;
    }

    /**
	 * Column Info
	 * @param rf40
	 */
    public void setRf40(String rf40) {
        this.rf40 = rf40;
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
	 * @param polYdCd
	 */
    public void setPolYdCd(String polYdCd) {
        this.polYdCd = polYdCd;
    }

    /**
	 * Column Info
	 * @param podYdCd
	 */
    public void setPodYdCd(String podYdCd) {
        this.podYdCd = podYdCd;
    }

    /**
	 * Column Info
	 * @param pYdCd
	 */
    public void setPYdCd(String pYdCd) {
        this.pYdCd = pYdCd;
    }

    /**
	 * Column Info
	 * @param ft40
	 */
    public void setFt40(String ft40) {
        this.ft40 = ft40;
    }

    /**
	 * Column Info
	 * @param rf20
	 */
    public void setRf20(String rf20) {
        this.rf20 = rf20;
    }

    /**
	 * Column Info
	 * @param ft20
	 */
    public void setFt20(String ft20) {
        this.ft20 = ft20;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getLane() {
        return this.lane;
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
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
        setRf40(JSPUtil.getParameter(request, prefix + "rf40", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
        setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
        setPYdCd(JSPUtil.getParameter(request, prefix + "p_yd_cd", ""));
        setFt40(JSPUtil.getParameter(request, prefix + "ft40", ""));
        setRf20(JSPUtil.getParameter(request, prefix + "rf20", ""));
        setFt20(JSPUtil.getParameter(request, prefix + "ft20", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TSSummaryVO[]
	 */
    public TSSummaryVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TSSummaryVO[]
	 */
    public TSSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        TSSummaryVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] eta = (JSPUtil.getParameter(request, prefix + "eta", length));
            String[] rf40 = (JSPUtil.getParameter(request, prefix + "rf40", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd", length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd", length));
            String[] pYdCd = (JSPUtil.getParameter(request, prefix + "p_yd_cd", length));
            String[] ft40 = (JSPUtil.getParameter(request, prefix + "ft40", length));
            String[] rf20 = (JSPUtil.getParameter(request, prefix + "rf20", length));
            String[] ft20 = (JSPUtil.getParameter(request, prefix + "ft20", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] lane = (JSPUtil.getParameter(request, prefix + "lane", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new TSSummaryVO();
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (eta[i] != null)
                    model.setEta(eta[i]);
                if (rf40[i] != null)
                    model.setRf40(rf40[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (pYdCd[i] != null)
                    model.setPYdCd(pYdCd[i]);
                if (ft40[i] != null)
                    model.setFt40(ft40[i]);
                if (rf20[i] != null)
                    model.setRf20(rf20[i]);
                if (ft20[i] != null)
                    model.setFt20(ft20[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (lane[i] != null) 
		    		model.setLane(lane[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getTSSummaryVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return TSSummaryVO[]
	 */
    public TSSummaryVO[] getTSSummaryVOs() {
        TSSummaryVO[] vos = (TSSummaryVO[]) models.toArray(new TSSummaryVO[models.size()]);
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
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eta = this.eta.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rf40 = this.rf40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pYdCd = this.pYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ft40 = this.ft40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rf20 = this.rf20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ft20 = this.ft20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lane = this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
