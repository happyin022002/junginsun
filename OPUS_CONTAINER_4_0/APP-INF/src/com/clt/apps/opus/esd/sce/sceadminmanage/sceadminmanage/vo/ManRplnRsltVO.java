/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ManRplnRsltVO.java
*@FileTitle : ManRplnRsltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.03
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.01.03 김인수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ManRplnRsltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManRplnRsltVO> models = new ArrayList<ManRplnRsltVO>();
	
	/* Column Info */
	private String mstCopNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String byPreset = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bkgInfo = null;
	/* Column Info */
	private String rplnRslt = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String regenPc = null;
	/* Column Info */
	private String pctlNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManRplnRsltVO() {}

	public ManRplnRsltVO(String ibflag, String pagerows, String bkgInfo, String regenPc, String byPreset, String copNo, String bkgNo, String cntrNo, String mstCopNo, String pctlNo, String rplnRslt) {
		this.mstCopNo = mstCopNo;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.byPreset = byPreset;
		this.cntrNo = cntrNo;
		this.bkgInfo = bkgInfo;
		this.rplnRslt = rplnRslt;
		this.copNo = copNo;
		this.regenPc = regenPc;
		this.pctlNo = pctlNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mst_cop_no", getMstCopNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("by_preset", getByPreset());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bkg_info", getBkgInfo());
		this.hashColumns.put("rpln_rslt", getRplnRslt());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("regen_pc", getRegenPc());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mst_cop_no", "mstCopNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("by_preset", "byPreset");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bkg_info", "bkgInfo");
		this.hashFields.put("rpln_rslt", "rplnRslt");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("regen_pc", "regenPc");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mstCopNo
	 */
	public String getMstCopNo() {
		return this.mstCopNo;
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
	 * @return byPreset
	 */
	public String getByPreset() {
		return this.byPreset;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return bkgInfo
	 */
	public String getBkgInfo() {
		return this.bkgInfo;
	}
	
	/**
	 * Column Info
	 * @return rplnRslt
	 */
	public String getRplnRslt() {
		return this.rplnRslt;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return regenPc
	 */
	public String getRegenPc() {
		return this.regenPc;
	}
	
	/**
	 * Column Info
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
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
	 * @param mstCopNo
	 */
	public void setMstCopNo(String mstCopNo) {
		this.mstCopNo = mstCopNo;
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
	 * @param byPreset
	 */
	public void setByPreset(String byPreset) {
		this.byPreset = byPreset;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param bkgInfo
	 */
	public void setBkgInfo(String bkgInfo) {
		this.bkgInfo = bkgInfo;
	}
	
	/**
	 * Column Info
	 * @param rplnRslt
	 */
	public void setRplnRslt(String rplnRslt) {
		this.rplnRslt = rplnRslt;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param regenPc
	 */
	public void setRegenPc(String regenPc) {
		this.regenPc = regenPc;
	}
	
	/**
	 * Column Info
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setMstCopNo(JSPUtil.getParameter(request, prefix + "mst_cop_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setByPreset(JSPUtil.getParameter(request, prefix + "by_preset", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setBkgInfo(JSPUtil.getParameter(request, prefix + "bkg_info", ""));
		setRplnRslt(JSPUtil.getParameter(request, prefix + "rpln_rslt", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setRegenPc(JSPUtil.getParameter(request, prefix + "regen_pc", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManRplnRsltVO[]
	 */
	public ManRplnRsltVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManRplnRsltVO[]
	 */
	public ManRplnRsltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManRplnRsltVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mstCopNo = (JSPUtil.getParameter(request, prefix	+ "mst_cop_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] byPreset = (JSPUtil.getParameter(request, prefix	+ "by_preset", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bkgInfo = (JSPUtil.getParameter(request, prefix	+ "bkg_info", length));
			String[] rplnRslt = (JSPUtil.getParameter(request, prefix	+ "rpln_rslt", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] regenPc = (JSPUtil.getParameter(request, prefix	+ "regen_pc", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManRplnRsltVO();
				if (mstCopNo[i] != null)
					model.setMstCopNo(mstCopNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (byPreset[i] != null)
					model.setByPreset(byPreset[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bkgInfo[i] != null)
					model.setBkgInfo(bkgInfo[i]);
				if (rplnRslt[i] != null)
					model.setRplnRslt(rplnRslt[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (regenPc[i] != null)
					model.setRegenPc(regenPc[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManRplnRsltVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManRplnRsltVO[]
	 */
	public ManRplnRsltVO[] getManRplnRsltVOs(){
		ManRplnRsltVO[] vos = (ManRplnRsltVO[])models.toArray(new ManRplnRsltVO[models.size()]);
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
		this.mstCopNo = this.mstCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.byPreset = this.byPreset .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgInfo = this.bkgInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnRslt = this.rplnRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regenPc = this.regenPc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
