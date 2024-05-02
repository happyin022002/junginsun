/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSADgListCondVO.java
*@FileTitle : PSADgListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.06
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.10.06 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PSADgListCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PSADgListCondVO> models = new ArrayList<PSADgListCondVO>();
	
	/* Column Info */
	private String frmImdgUnNo = null;
	/* Column Info */
	private String dgListCopyFlag = null;
	/* Column Info */
	private String bayPlnId = null;
	/* Column Info */
	private String appendFlag = null;
	/* Column Info */
	private String pBoundCd = null;
	/* Column Info */
	private String searchType = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String frmVslCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pPodCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String frmBrthYdCd = null;
	/* Column Info */
	private String dType = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String bargeFlag = null;
	/* Column Info */
	private String uiType = null;
	/* Column Info */
	private String frmFwrdCd = null;
	/* Column Info */
	private String pPolCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PSADgListCondVO() {}

	public PSADgListCondVO(String ibflag, String pagerows, String vvdCd, String portCd, String dType, String bayPlnId, String frmVslCd, String frmBrthYdCd, String frmFwrdCd, String frmImdgUnNo, String ofcCd, String searchType, String uiType, String blNo, String dgListCopyFlag, String bargeFlag, String appendFlag, String pBoundCd, String pPolCd, String pPodCd) {
		this.frmImdgUnNo = frmImdgUnNo;
		this.dgListCopyFlag = dgListCopyFlag;
		this.bayPlnId = bayPlnId;
		this.appendFlag = appendFlag;
		this.pBoundCd = pBoundCd;
		this.searchType = searchType;
		this.blNo = blNo;
		this.frmVslCd = frmVslCd;
		this.pagerows = pagerows;
		this.pPodCd = pPodCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.frmBrthYdCd = frmBrthYdCd;
		this.dType = dType;
		this.portCd = portCd;
		this.bargeFlag = bargeFlag;
		this.uiType = uiType;
		this.frmFwrdCd = frmFwrdCd;
		this.pPolCd = pPolCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frm_imdg_un_no", getFrmImdgUnNo());
		this.hashColumns.put("dg_list_copy_flag", getDgListCopyFlag());
		this.hashColumns.put("bay_pln_id", getBayPlnId());
		this.hashColumns.put("append_flag", getAppendFlag());
		this.hashColumns.put("p_bound_cd", getPBoundCd());
		this.hashColumns.put("search_type", getSearchType());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("frm_vsl_cd", getFrmVslCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_pod_cd", getPPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("frm_brth_yd_cd", getFrmBrthYdCd());
		this.hashColumns.put("d_type", getDType());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("barge_flag", getBargeFlag());
		this.hashColumns.put("ui_type", getUiType());
		this.hashColumns.put("frm_fwrd_cd", getFrmFwrdCd());
		this.hashColumns.put("p_pol_cd", getPPolCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frm_imdg_un_no", "frmImdgUnNo");
		this.hashFields.put("dg_list_copy_flag", "dgListCopyFlag");
		this.hashFields.put("bay_pln_id", "bayPlnId");
		this.hashFields.put("append_flag", "appendFlag");
		this.hashFields.put("p_bound_cd", "pBoundCd");
		this.hashFields.put("search_type", "searchType");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("frm_vsl_cd", "frmVslCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_pod_cd", "pPodCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("frm_brth_yd_cd", "frmBrthYdCd");
		this.hashFields.put("d_type", "dType");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("barge_flag", "bargeFlag");
		this.hashFields.put("ui_type", "uiType");
		this.hashFields.put("frm_fwrd_cd", "frmFwrdCd");
		this.hashFields.put("p_pol_cd", "pPolCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frmImdgUnNo
	 */
	public String getFrmImdgUnNo() {
		return this.frmImdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return dgListCopyFlag
	 */
	public String getDgListCopyFlag() {
		return this.dgListCopyFlag;
	}
	
	/**
	 * Column Info
	 * @return bayPlnId
	 */
	public String getBayPlnId() {
		return this.bayPlnId;
	}
	
	/**
	 * Column Info
	 * @return appendFlag
	 */
	public String getAppendFlag() {
		return this.appendFlag;
	}
	
	/**
	 * Column Info
	 * @return pBoundCd
	 */
	public String getPBoundCd() {
		return this.pBoundCd;
	}
	
	/**
	 * Column Info
	 * @return searchType
	 */
	public String getSearchType() {
		return this.searchType;
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
	 * @return frmVslCd
	 */
	public String getFrmVslCd() {
		return this.frmVslCd;
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
	 * @return pPodCd
	 */
	public String getPPodCd() {
		return this.pPodCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return frmBrthYdCd
	 */
	public String getFrmBrthYdCd() {
		return this.frmBrthYdCd;
	}
	
	/**
	 * Column Info
	 * @return dType
	 */
	public String getDType() {
		return this.dType;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return bargeFlag
	 */
	public String getBargeFlag() {
		return this.bargeFlag;
	}
	
	/**
	 * Column Info
	 * @return uiType
	 */
	public String getUiType() {
		return this.uiType;
	}
	
	/**
	 * Column Info
	 * @return frmFwrdCd
	 */
	public String getFrmFwrdCd() {
		return this.frmFwrdCd;
	}
	
	/**
	 * Column Info
	 * @return pPolCd
	 */
	public String getPPolCd() {
		return this.pPolCd;
	}
	

	/**
	 * Column Info
	 * @param frmImdgUnNo
	 */
	public void setFrmImdgUnNo(String frmImdgUnNo) {
		this.frmImdgUnNo = frmImdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param dgListCopyFlag
	 */
	public void setDgListCopyFlag(String dgListCopyFlag) {
		this.dgListCopyFlag = dgListCopyFlag;
	}
	
	/**
	 * Column Info
	 * @param bayPlnId
	 */
	public void setBayPlnId(String bayPlnId) {
		this.bayPlnId = bayPlnId;
	}
	
	/**
	 * Column Info
	 * @param appendFlag
	 */
	public void setAppendFlag(String appendFlag) {
		this.appendFlag = appendFlag;
	}
	
	/**
	 * Column Info
	 * @param pBoundCd
	 */
	public void setPBoundCd(String pBoundCd) {
		this.pBoundCd = pBoundCd;
	}
	
	/**
	 * Column Info
	 * @param searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
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
	 * @param frmVslCd
	 */
	public void setFrmVslCd(String frmVslCd) {
		this.frmVslCd = frmVslCd;
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
	 * @param pPodCd
	 */
	public void setPPodCd(String pPodCd) {
		this.pPodCd = pPodCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param frmBrthYdCd
	 */
	public void setFrmBrthYdCd(String frmBrthYdCd) {
		this.frmBrthYdCd = frmBrthYdCd;
	}
	
	/**
	 * Column Info
	 * @param dType
	 */
	public void setDType(String dType) {
		this.dType = dType;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param bargeFlag
	 */
	public void setBargeFlag(String bargeFlag) {
		this.bargeFlag = bargeFlag;
	}
	
	/**
	 * Column Info
	 * @param uiType
	 */
	public void setUiType(String uiType) {
		this.uiType = uiType;
	}
	
	/**
	 * Column Info
	 * @param frmFwrdCd
	 */
	public void setFrmFwrdCd(String frmFwrdCd) {
		this.frmFwrdCd = frmFwrdCd;
	}
	
	/**
	 * Column Info
	 * @param pPolCd
	 */
	public void setPPolCd(String pPolCd) {
		this.pPolCd = pPolCd;
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
		setFrmImdgUnNo(JSPUtil.getParameter(request, prefix + "frm_imdg_un_no", ""));
		setDgListCopyFlag(JSPUtil.getParameter(request, prefix + "dg_list_copy_flag", ""));
		setBayPlnId(JSPUtil.getParameter(request, prefix + "bay_pln_id", ""));
		setAppendFlag(JSPUtil.getParameter(request, prefix + "append_flag", ""));
		setPBoundCd(JSPUtil.getParameter(request, prefix + "p_bound_cd", ""));
		setSearchType(JSPUtil.getParameter(request, prefix + "search_type", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setFrmVslCd(JSPUtil.getParameter(request, prefix + "frm_vsl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPPodCd(JSPUtil.getParameter(request, prefix + "p_pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setFrmBrthYdCd(JSPUtil.getParameter(request, prefix + "frm_brth_yd_cd", ""));
		setDType(JSPUtil.getParameter(request, prefix + "d_type", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setBargeFlag(JSPUtil.getParameter(request, prefix + "barge_flag", ""));
		setUiType(JSPUtil.getParameter(request, prefix + "ui_type", ""));
		setFrmFwrdCd(JSPUtil.getParameter(request, prefix + "frm_fwrd_cd", ""));
		setPPolCd(JSPUtil.getParameter(request, prefix + "p_pol_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PSADgListCondVO[]
	 */
	public PSADgListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PSADgListCondVO[]
	 */
	public PSADgListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PSADgListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frmImdgUnNo = (JSPUtil.getParameter(request, prefix	+ "frm_imdg_un_no", length));
			String[] dgListCopyFlag = (JSPUtil.getParameter(request, prefix	+ "dg_list_copy_flag", length));
			String[] bayPlnId = (JSPUtil.getParameter(request, prefix	+ "bay_pln_id", length));
			String[] appendFlag = (JSPUtil.getParameter(request, prefix	+ "append_flag", length));
			String[] pBoundCd = (JSPUtil.getParameter(request, prefix	+ "p_bound_cd", length));
			String[] searchType = (JSPUtil.getParameter(request, prefix	+ "search_type", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] frmVslCd = (JSPUtil.getParameter(request, prefix	+ "frm_vsl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pPodCd = (JSPUtil.getParameter(request, prefix	+ "p_pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] frmBrthYdCd = (JSPUtil.getParameter(request, prefix	+ "frm_brth_yd_cd", length));
			String[] dType = (JSPUtil.getParameter(request, prefix	+ "d_type", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] bargeFlag = (JSPUtil.getParameter(request, prefix	+ "barge_flag", length));
			String[] uiType = (JSPUtil.getParameter(request, prefix	+ "ui_type", length));
			String[] frmFwrdCd = (JSPUtil.getParameter(request, prefix	+ "frm_fwrd_cd", length));
			String[] pPolCd = (JSPUtil.getParameter(request, prefix	+ "p_pol_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PSADgListCondVO();
				if (frmImdgUnNo[i] != null)
					model.setFrmImdgUnNo(frmImdgUnNo[i]);
				if (dgListCopyFlag[i] != null)
					model.setDgListCopyFlag(dgListCopyFlag[i]);
				if (bayPlnId[i] != null)
					model.setBayPlnId(bayPlnId[i]);
				if (appendFlag[i] != null)
					model.setAppendFlag(appendFlag[i]);
				if (pBoundCd[i] != null)
					model.setPBoundCd(pBoundCd[i]);
				if (searchType[i] != null)
					model.setSearchType(searchType[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (frmVslCd[i] != null)
					model.setFrmVslCd(frmVslCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pPodCd[i] != null)
					model.setPPodCd(pPodCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (frmBrthYdCd[i] != null)
					model.setFrmBrthYdCd(frmBrthYdCd[i]);
				if (dType[i] != null)
					model.setDType(dType[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (bargeFlag[i] != null)
					model.setBargeFlag(bargeFlag[i]);
				if (uiType[i] != null)
					model.setUiType(uiType[i]);
				if (frmFwrdCd[i] != null)
					model.setFrmFwrdCd(frmFwrdCd[i]);
				if (pPolCd[i] != null)
					model.setPPolCd(pPolCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPSADgListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PSADgListCondVO[]
	 */
	public PSADgListCondVO[] getPSADgListCondVOs(){
		PSADgListCondVO[] vos = (PSADgListCondVO[])models.toArray(new PSADgListCondVO[models.size()]);
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
		this.frmImdgUnNo = this.frmImdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgListCopyFlag = this.dgListCopyFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayPlnId = this.bayPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appendFlag = this.appendFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBoundCd = this.pBoundCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchType = this.searchType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmVslCd = this.frmVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPodCd = this.pPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmBrthYdCd = this.frmBrthYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dType = this.dType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bargeFlag = this.bargeFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiType = this.uiType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmFwrdCd = this.frmFwrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPolCd = this.pPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
