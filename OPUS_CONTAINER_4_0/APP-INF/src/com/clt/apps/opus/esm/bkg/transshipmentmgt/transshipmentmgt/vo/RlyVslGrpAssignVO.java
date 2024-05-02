/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RlyVslGrpAssignVO.java
*@FileTitle : RlyVslGrpAssignVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.02.08 김기종 
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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RlyVslGrpAssignVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RlyVslGrpAssignVO> models = new ArrayList<RlyVslGrpAssignVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String formerVvd = null;
	/* Column Info */
	private String relay = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String nextVslPrePstCd = null;
	/* Column Info */
	private String formerVslPrePstCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String nextYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String formerYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String nextSlanCd = null;
	/* Column Info */
	private String formerSlanCd = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String spcl = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RlyVslGrpAssignVO() {}

	public RlyVslGrpAssignVO(String ibflag, String pagerows, String bkgNo, String blNo, String polCd, String podCd, String formerVvd, String formerSlanCd, String etb, String relay, String nextVvd, String nextSlanCd, String etd, String spcl, String formerVslPrePstCd, String nextVslPrePstCd, String formerYdCd, String nextYdCd) {
		this.etb = etb;
		this.formerVvd = formerVvd;
		this.relay = relay;
		this.etd = etd;
		this.nextVslPrePstCd = nextVslPrePstCd;
		this.formerVslPrePstCd = formerVslPrePstCd;
		this.blNo = blNo;
		this.nextYdCd = nextYdCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.formerYdCd = formerYdCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.nextSlanCd = nextSlanCd;
		this.formerSlanCd = formerSlanCd;
		this.nextVvd = nextVvd;
		this.spcl = spcl;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("former_vvd", getFormerVvd());
		this.hashColumns.put("relay", getRelay());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("next_vsl_pre_pst_cd", getNextVslPrePstCd());
		this.hashColumns.put("former_vsl_pre_pst_cd", getFormerVslPrePstCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("next_yd_cd", getNextYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("former_yd_cd", getFormerYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("next_slan_cd", getNextSlanCd());
		this.hashColumns.put("former_slan_cd", getFormerSlanCd());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("spcl", getSpcl());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("former_vvd", "formerVvd");
		this.hashFields.put("relay", "relay");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("next_vsl_pre_pst_cd", "nextVslPrePstCd");
		this.hashFields.put("former_vsl_pre_pst_cd", "formerVslPrePstCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("next_yd_cd", "nextYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("former_yd_cd", "formerYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("next_slan_cd", "nextSlanCd");
		this.hashFields.put("former_slan_cd", "formerSlanCd");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("spcl", "spcl");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
	}
	
	/**
	 * Column Info
	 * @return formerVvd
	 */
	public String getFormerVvd() {
		return this.formerVvd;
	}
	
	/**
	 * Column Info
	 * @return relay
	 */
	public String getRelay() {
		return this.relay;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return nextVslPrePstCd
	 */
	public String getNextVslPrePstCd() {
		return this.nextVslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @return formerVslPrePstCd
	 */
	public String getFormerVslPrePstCd() {
		return this.formerVslPrePstCd;
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
	 * @return nextYdCd
	 */
	public String getNextYdCd() {
		return this.nextYdCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return formerYdCd
	 */
	public String getFormerYdCd() {
		return this.formerYdCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return nextSlanCd
	 */
	public String getNextSlanCd() {
		return this.nextSlanCd;
	}
	
	/**
	 * Column Info
	 * @return formerSlanCd
	 */
	public String getFormerSlanCd() {
		return this.formerSlanCd;
	}
	
	/**
	 * Column Info
	 * @return nextVvd
	 */
	public String getNextVvd() {
		return this.nextVvd;
	}
	
	/**
	 * Column Info
	 * @return spcl
	 */
	public String getSpcl() {
		return this.spcl;
	}
	

	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
	}
	
	/**
	 * Column Info
	 * @param formerVvd
	 */
	public void setFormerVvd(String formerVvd) {
		this.formerVvd = formerVvd;
	}
	
	/**
	 * Column Info
	 * @param relay
	 */
	public void setRelay(String relay) {
		this.relay = relay;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param nextVslPrePstCd
	 */
	public void setNextVslPrePstCd(String nextVslPrePstCd) {
		this.nextVslPrePstCd = nextVslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @param formerVslPrePstCd
	 */
	public void setFormerVslPrePstCd(String formerVslPrePstCd) {
		this.formerVslPrePstCd = formerVslPrePstCd;
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
	 * @param nextYdCd
	 */
	public void setNextYdCd(String nextYdCd) {
		this.nextYdCd = nextYdCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param formerYdCd
	 */
	public void setFormerYdCd(String formerYdCd) {
		this.formerYdCd = formerYdCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param nextSlanCd
	 */
	public void setNextSlanCd(String nextSlanCd) {
		this.nextSlanCd = nextSlanCd;
	}
	
	/**
	 * Column Info
	 * @param formerSlanCd
	 */
	public void setFormerSlanCd(String formerSlanCd) {
		this.formerSlanCd = formerSlanCd;
	}
	
	/**
	 * Column Info
	 * @param nextVvd
	 */
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
	}
	
	/**
	 * Column Info
	 * @param spcl
	 */
	public void setSpcl(String spcl) {
		this.spcl = spcl;
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
		setEtb(JSPUtil.getParameter(request, prefix + "etb", ""));
		setFormerVvd(JSPUtil.getParameter(request, prefix + "former_vvd", ""));
		setRelay(JSPUtil.getParameter(request, prefix + "relay", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setNextVslPrePstCd(JSPUtil.getParameter(request, prefix + "next_vsl_pre_pst_cd", ""));
		setFormerVslPrePstCd(JSPUtil.getParameter(request, prefix + "former_vsl_pre_pst_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setNextYdCd(JSPUtil.getParameter(request, prefix + "next_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setFormerYdCd(JSPUtil.getParameter(request, prefix + "former_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setNextSlanCd(JSPUtil.getParameter(request, prefix + "next_slan_cd", ""));
		setFormerSlanCd(JSPUtil.getParameter(request, prefix + "former_slan_cd", ""));
		setNextVvd(JSPUtil.getParameter(request, prefix + "next_vvd", ""));
		setSpcl(JSPUtil.getParameter(request, prefix + "spcl", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RlyVslGrpAssignVO[]
	 */
	public RlyVslGrpAssignVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RlyVslGrpAssignVO[]
	 */
	public RlyVslGrpAssignVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RlyVslGrpAssignVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] formerVvd = (JSPUtil.getParameter(request, prefix	+ "former_vvd", length));
			String[] relay = (JSPUtil.getParameter(request, prefix	+ "relay", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] nextVslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "next_vsl_pre_pst_cd", length));
			String[] formerVslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "former_vsl_pre_pst_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] nextYdCd = (JSPUtil.getParameter(request, prefix	+ "next_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] formerYdCd = (JSPUtil.getParameter(request, prefix	+ "former_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] nextSlanCd = (JSPUtil.getParameter(request, prefix	+ "next_slan_cd", length));
			String[] formerSlanCd = (JSPUtil.getParameter(request, prefix	+ "former_slan_cd", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] spcl = (JSPUtil.getParameter(request, prefix	+ "spcl", length));
			
			for (int i = 0; i < length; i++) {
				model = new RlyVslGrpAssignVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (formerVvd[i] != null)
					model.setFormerVvd(formerVvd[i]);
				if (relay[i] != null)
					model.setRelay(relay[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (nextVslPrePstCd[i] != null)
					model.setNextVslPrePstCd(nextVslPrePstCd[i]);
				if (formerVslPrePstCd[i] != null)
					model.setFormerVslPrePstCd(formerVslPrePstCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (nextYdCd[i] != null)
					model.setNextYdCd(nextYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (formerYdCd[i] != null)
					model.setFormerYdCd(formerYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (nextSlanCd[i] != null)
					model.setNextSlanCd(nextSlanCd[i]);
				if (formerSlanCd[i] != null)
					model.setFormerSlanCd(formerSlanCd[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (spcl[i] != null)
					model.setSpcl(spcl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRlyVslGrpAssignVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RlyVslGrpAssignVO[]
	 */
	public RlyVslGrpAssignVO[] getRlyVslGrpAssignVOs(){
		RlyVslGrpAssignVO[] vos = (RlyVslGrpAssignVO[])models.toArray(new RlyVslGrpAssignVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formerVvd = this.formerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.relay = this.relay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVslPrePstCd = this.nextVslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formerVslPrePstCd = this.formerVslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextYdCd = this.nextYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formerYdCd = this.formerYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextSlanCd = this.nextSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formerSlanCd = this.formerSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcl = this.spcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
