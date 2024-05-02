/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AusSearchCuscarVO.java
*@FileTitle : AusSearchCuscarVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo;

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

public class AusSearchCuscarVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AusSearchCuscarVO> models = new ArrayList<AusSearchCuscarVO>();
	
	/* Column Info */
	private String dstPrms = null;
	/* Column Info */
	private String searchDiv = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ediInd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String inTransit = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String onCrrg = null;
	/* Column Info */
	private String itMode = null;
	/* Column Info */
	private String reqReason = null;
	/* Column Info */
	private String orgPrms = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AusSearchCuscarVO() {}

	public AusSearchCuscarVO(String ibflag, String pagerows, String blNo, String delCd, String dstPrms, String ediInd, String inTransit, String itMode, String lloydNo, String onCrrg, String orgPrms, String podCd, String reqReason, String searchDiv, String vvd) {
		this.dstPrms = dstPrms;
		this.searchDiv = searchDiv;
		this.delCd = delCd;
		this.blNo = blNo;
		this.ediInd = ediInd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.inTransit = inTransit;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.lloydNo = lloydNo;
		this.onCrrg = onCrrg;
		this.itMode = itMode;
		this.reqReason = reqReason;
		this.orgPrms = orgPrms;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dst_prms", getDstPrms());
		this.hashColumns.put("search_div", getSearchDiv());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("edi_ind", getEdiInd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("in_transit", getInTransit());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("on_crrg", getOnCrrg());
		this.hashColumns.put("it_mode", getItMode());
		this.hashColumns.put("req_reason", getReqReason());
		this.hashColumns.put("org_prms", getOrgPrms());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dst_prms", "dstPrms");
		this.hashFields.put("search_div", "searchDiv");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("edi_ind", "ediInd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("in_transit", "inTransit");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("on_crrg", "onCrrg");
		this.hashFields.put("it_mode", "itMode");
		this.hashFields.put("req_reason", "reqReason");
		this.hashFields.put("org_prms", "orgPrms");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dstPrms
	 */
	public String getDstPrms() {
		return this.dstPrms;
	}
	
	/**
	 * Column Info
	 * @return searchDiv
	 */
	public String getSearchDiv() {
		return this.searchDiv;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return ediInd
	 */
	public String getEdiInd() {
		return this.ediInd;
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
	 * @return inTransit
	 */
	public String getInTransit() {
		return this.inTransit;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return onCrrg
	 */
	public String getOnCrrg() {
		return this.onCrrg;
	}
	
	/**
	 * Column Info
	 * @return itMode
	 */
	public String getItMode() {
		return this.itMode;
	}
	
	/**
	 * Column Info
	 * @return reqReason
	 */
	public String getReqReason() {
		return this.reqReason;
	}
	
	/**
	 * Column Info
	 * @return orgPrms
	 */
	public String getOrgPrms() {
		return this.orgPrms;
	}
	

	/**
	 * Column Info
	 * @param dstPrms
	 */
	public void setDstPrms(String dstPrms) {
		this.dstPrms = dstPrms;
	}
	
	/**
	 * Column Info
	 * @param searchDiv
	 */
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param ediInd
	 */
	public void setEdiInd(String ediInd) {
		this.ediInd = ediInd;
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
	 * @param inTransit
	 */
	public void setInTransit(String inTransit) {
		this.inTransit = inTransit;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param onCrrg
	 */
	public void setOnCrrg(String onCrrg) {
		this.onCrrg = onCrrg;
	}
	
	/**
	 * Column Info
	 * @param itMode
	 */
	public void setItMode(String itMode) {
		this.itMode = itMode;
	}
	
	/**
	 * Column Info
	 * @param reqReason
	 */
	public void setReqReason(String reqReason) {
		this.reqReason = reqReason;
	}
	
	/**
	 * Column Info
	 * @param orgPrms
	 */
	public void setOrgPrms(String orgPrms) {
		this.orgPrms = orgPrms;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setDstPrms(JSPUtil.getParameter(request, prefix + "dst_prms", ""));
		setSearchDiv(JSPUtil.getParameter(request, prefix + "search_div", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setEdiInd(JSPUtil.getParameter(request, prefix + "edi_ind", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setInTransit(JSPUtil.getParameter(request, prefix + "in_transit", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setOnCrrg(JSPUtil.getParameter(request, prefix + "on_crrg", ""));
		setItMode(JSPUtil.getParameter(request, prefix + "it_mode", ""));
		setReqReason(JSPUtil.getParameter(request, prefix + "req_reason", ""));
		setOrgPrms(JSPUtil.getParameter(request, prefix + "org_prms", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusSearchCuscarVO[]
	 */
	public AusSearchCuscarVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AusSearchCuscarVO[]
	 */
	public AusSearchCuscarVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusSearchCuscarVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dstPrms = (JSPUtil.getParameter(request, prefix	+ "dst_prms", length));
			String[] searchDiv = (JSPUtil.getParameter(request, prefix	+ "search_div", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ediInd = (JSPUtil.getParameter(request, prefix	+ "edi_ind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] inTransit = (JSPUtil.getParameter(request, prefix	+ "in_transit", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] onCrrg = (JSPUtil.getParameter(request, prefix	+ "on_crrg", length));
			String[] itMode = (JSPUtil.getParameter(request, prefix	+ "it_mode", length));
			String[] reqReason = (JSPUtil.getParameter(request, prefix	+ "req_reason", length));
			String[] orgPrms = (JSPUtil.getParameter(request, prefix	+ "org_prms", length));
			
			for (int i = 0; i < length; i++) {
				model = new AusSearchCuscarVO();
				if (dstPrms[i] != null)
					model.setDstPrms(dstPrms[i]);
				if (searchDiv[i] != null)
					model.setSearchDiv(searchDiv[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ediInd[i] != null)
					model.setEdiInd(ediInd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (inTransit[i] != null)
					model.setInTransit(inTransit[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (onCrrg[i] != null)
					model.setOnCrrg(onCrrg[i]);
				if (itMode[i] != null)
					model.setItMode(itMode[i]);
				if (reqReason[i] != null)
					model.setReqReason(reqReason[i]);
				if (orgPrms[i] != null)
					model.setOrgPrms(orgPrms[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusSearchCuscarVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusSearchCuscarVO[]
	 */
	public AusSearchCuscarVO[] getAusSearchCuscarVOs(){
		AusSearchCuscarVO[] vos = (AusSearchCuscarVO[])models.toArray(new AusSearchCuscarVO[models.size()]);
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
		this.dstPrms = this.dstPrms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDiv = this.searchDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediInd = this.ediInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTransit = this.inTransit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onCrrg = this.onCrrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itMode = this.itMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqReason = this.reqReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPrms = this.orgPrms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
