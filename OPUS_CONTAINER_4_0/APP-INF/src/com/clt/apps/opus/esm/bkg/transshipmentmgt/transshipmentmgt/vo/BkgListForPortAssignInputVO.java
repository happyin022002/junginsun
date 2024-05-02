/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgListForPortAssignInputVO.java
*@FileTitle : BkgListForPortAssignInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.16 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgListForPortAssignInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgListForPortAssignInputVO> models = new ArrayList<BkgListForPortAssignInputVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String vvd = null;
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
	private String tvvd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String delCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgListForPortAssignInputVO() {}

	public BkgListForPortAssignInputVO(String ibflag, String pagerows, String polCd, String podCd, String tvvd, String preVvd, String postVvd, String vvd, String port, String bkgOfcCd,String porCd, String delCd) {
		this.bkgOfcCd = bkgOfcCd;
		this.port = port;
		this.vvd = vvd;
		this.postVvd = postVvd;
		this.podCd = podCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.preVvd = preVvd;
		this.tvvd = tvvd;
		this.pagerows = pagerows;
		this.porCd = porCd;
		this.delCd = delCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("post_vvd", getPostVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("del_cd", getDelCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("port", "port");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("post_vvd", "postVvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("del_cd", "delCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
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
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setPort(JSPUtil.getParameter(request, "port", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPostVvd(JSPUtil.getParameter(request, "post_vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPreVvd(JSPUtil.getParameter(request, "pre_vvd", ""));
		setTvvd(JSPUtil.getParameter(request, "tvvd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForPortAssignInputVO[]
	 */
	public BkgListForPortAssignInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgListForPortAssignInputVO[]
	 */
	public BkgListForPortAssignInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgListForPortAssignInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] postVvd = (JSPUtil.getParameter(request, prefix	+ "post_vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgListForPortAssignInputVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (postVvd[i] != null)
					model.setPostVvd(postVvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgListForPortAssignInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgListForPortAssignInputVO[]
	 */
	public BkgListForPortAssignInputVO[] getBkgListForPortAssignInputVOs(){
		BkgListForPortAssignInputVO[] vos = (BkgListForPortAssignInputVO[])models.toArray(new BkgListForPortAssignInputVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVvd = this.postVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
