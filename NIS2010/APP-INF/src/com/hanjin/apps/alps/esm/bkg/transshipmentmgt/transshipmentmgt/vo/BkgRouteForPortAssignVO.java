/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgRouteForPortAssignVO.java
*@FileTitle : BkgRouteForPortAssignVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.14 최영희 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

import java.lang.reflect.Field;
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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgRouteForPortAssignVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgRouteForPortAssignVO> models = new ArrayList<BkgRouteForPortAssignVO>();

    /* Column Info */
    private String rmk = null;

    /* Column Info */
    private String postVvd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String preVvd = null;

    /* Column Info */
    private String bkgCount = null;

    /* Column Info */
    private String preRelay = null;

    /* Column Info */
    private String postRelay = null;

    /* Column Info */
    private String tvvd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String polNodCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgRouteForPortAssignVO() {
    }

    public BkgRouteForPortAssignVO(String ibflag, String pagerows, String polCd, String podCd, String bkgCount, String tvvd, String preVvd, String preRelay, String postVvd, String postRelay, String rmk, String porCd, String delCd, String polNodCd) {
        this.rmk = rmk;
        this.postVvd = postVvd;
        this.podCd = podCd;
        this.polCd = polCd;
        this.porCd = porCd;
        this.delCd = delCd;
        this.ibflag = ibflag;
        this.preVvd = preVvd;
        this.bkgCount = bkgCount;
        this.preRelay = preRelay;
        this.postRelay = postRelay;
        this.tvvd = tvvd;
        this.pagerows = pagerows;
        this.polNodCd = polNodCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("rmk", getRmk());
        this.hashColumns.put("post_vvd", getPostVvd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pre_vvd", getPreVvd());
        this.hashColumns.put("bkg_count", getBkgCount());
        this.hashColumns.put("pre_relay", getPreRelay());
        this.hashColumns.put("post_relay", getPostRelay());
        this.hashColumns.put("tvvd", getTvvd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_nod_cd", getPolNodCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("rmk", "rmk");
        this.hashFields.put("post_vvd", "postVvd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pre_vvd", "preVvd");
        this.hashFields.put("bkg_count", "bkgCount");
        this.hashFields.put("pre_relay", "preRelay");
        this.hashFields.put("post_relay", "postRelay");
        this.hashFields.put("tvvd", "tvvd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_nod_cd", "polNodCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return rmk
	 */
    public String getRmk() {
        return this.rmk;
    }

    /**
	 * Column Info
	 * @return postVvd
	 */
    public String getPostVvd() {
        return this.postVvd;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 * Column Info
	 * @return porCd
	 */
    public String getPorCd() {
        return this.porCd;
    }

    /**
	 * Column Info
	 * @return delCd
	 */
    public String getDelCd() {
        return this.delCd;
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
	 * @return preVvd
	 */
    public String getPreVvd() {
        return this.preVvd;
    }

    /**
	 * Column Info
	 * @return bkgCount
	 */
    public String getBkgCount() {
        return this.bkgCount;
    }

    /**
	 * Column Info
	 * @return preRelay
	 */
    public String getPreRelay() {
        return this.preRelay;
    }

    /**
	 * Column Info
	 * @return postRelay
	 */
    public String getPostRelay() {
        return this.postRelay;
    }

    /**
	 * Column Info
	 * @return tvvd
	 */
    public String getTvvd() {
        return this.tvvd;
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
	 * @param rmk
	 */
    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    /**
	 * Column Info
	 * @param postVvd
	 */
    public void setPostVvd(String postVvd) {
        this.postVvd = postVvd;
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
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @param delCd
	 */
    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    /**
	 * Column Info
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param preVvd
	 */
    public void setPreVvd(String preVvd) {
        this.preVvd = preVvd;
    }

    /**
	 * Column Info
	 * @param bkgCount
	 */
    public void setBkgCount(String bkgCount) {
        this.bkgCount = bkgCount;
    }

    /**
	 * Column Info
	 * @param preRelay
	 */
    public void setPreRelay(String preRelay) {
        this.preRelay = preRelay;
    }

    /**
	 * Column Info
	 * @param postRelay
	 */
    public void setPostRelay(String postRelay) {
        this.postRelay = postRelay;
    }

    /**
	 * Column Info
	 * @param tvvd
	 */
    public void setTvvd(String tvvd) {
        this.tvvd = tvvd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setPolNodCd(String polNodCd) {
        this.polNodCd = polNodCd;
    }

    public String getPolNodCd() {
        return this.polNodCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setRmk(JSPUtil.getParameter(request, "rmk", ""));
        setPostVvd(JSPUtil.getParameter(request, "post_vvd", ""));
        setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
        setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
        setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
        setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setPreVvd(JSPUtil.getParameter(request, "pre_vvd", ""));
        setBkgCount(JSPUtil.getParameter(request, "bkg_count", ""));
        setPreRelay(JSPUtil.getParameter(request, "pre_relay", ""));
        setPostRelay(JSPUtil.getParameter(request, "post_relay", ""));
        setTvvd(JSPUtil.getParameter(request, "tvvd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgRouteForPortAssignVO[]
	 */
    public BkgRouteForPortAssignVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgRouteForPortAssignVO[]
	 */
    public BkgRouteForPortAssignVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgRouteForPortAssignVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] rmk = (JSPUtil.getParameter(request, prefix + "rmk", length));
            String[] postVvd = (JSPUtil.getParameter(request, prefix + "post_vvd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] preVvd = (JSPUtil.getParameter(request, prefix + "pre_vvd", length));
            String[] bkgCount = (JSPUtil.getParameter(request, prefix + "bkg_count", length));
            String[] preRelay = (JSPUtil.getParameter(request, prefix + "pre_relay", length));
            String[] postRelay = (JSPUtil.getParameter(request, prefix + "post_relay", length));
            String[] tvvd = (JSPUtil.getParameter(request, prefix + "tvvd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] polNodCd = (JSPUtil.getParameter(request, prefix + "pol_nod_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgRouteForPortAssignVO();
                if (rmk[i] != null)
                    model.setRmk(rmk[i]);
                if (postVvd[i] != null)
                    model.setPostVvd(postVvd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (preVvd[i] != null)
                    model.setPreVvd(preVvd[i]);
                if (bkgCount[i] != null)
                    model.setBkgCount(bkgCount[i]);
                if (preRelay[i] != null)
                    model.setPreRelay(preRelay[i]);
                if (postRelay[i] != null)
                    model.setPostRelay(postRelay[i]);
                if (tvvd[i] != null)
                    model.setTvvd(tvvd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polNodCd[i] != null) 
		    		model.setPolNodCd(polNodCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgRouteForPortAssignVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgRouteForPortAssignVO[]
	 */
    public BkgRouteForPortAssignVO[] getBkgRouteForPortAssignVOs() {
        BkgRouteForPortAssignVO[] vos = (BkgRouteForPortAssignVO[]) models.toArray(new BkgRouteForPortAssignVO[models.size()]);
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
        this.rmk = this.rmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.postVvd = this.postVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preVvd = this.preVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCount = this.bkgCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preRelay = this.preRelay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.postRelay = this.postRelay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tvvd = this.tvvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNodCd = this.polNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
