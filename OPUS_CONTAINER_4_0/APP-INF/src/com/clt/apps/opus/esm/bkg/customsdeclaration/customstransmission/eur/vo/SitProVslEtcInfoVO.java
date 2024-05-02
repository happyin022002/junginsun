/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SitProVslEtcInfoVO.java
*@FileTitle : SitProVslEtcInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.02  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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

public class SitProVslEtcInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProVslEtcInfoVO> models = new ArrayList<SitProVslEtcInfoVO>();
	
	/* Column Info */
	private String vvdtype = null;
	/* Column Info */
	private String podYd = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String blpod1 = null;
	/* Column Info */
	private String bvvd1 = null;
	/* Column Info */
	private String poletd1 = null;
	/* Column Info */
	private String vslLloydcode1 = null;
	/* Column Info */
	private String blpol1 = null;
	/* Column Info */
	private String podeta1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podetd1 = null;
	/* Column Info */
	private String vslCallsign1 = null;
	/* Column Info */
	private String vslFullname1 = null;
	/* Column Info */
	private String opCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polYd = null;
	/* Column Info */
	private String poleta1 = null;
	/* Column Info */
	private String polFullname1 = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String vslRgstCntCd1 = null;
	/* Column Info */
	private String podFullname1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SitProVslEtcInfoVO() {}

	public SitProVslEtcInfoVO(String ibflag, String pagerows, String vvdtype, String vslPrePstCd, String laneCd, String bvvd1, String vslCallsign1, String vslLloydcode1, String vslFullname1, String vslRgstCntCd1, String blpol1, String polYd, String polFullname1, String blpod1, String podYd, String podFullname1, String poleta1, String poletd1, String podeta1, String podetd1, String opCode) {
		this.vvdtype = vvdtype;
		this.podYd = podYd;
		this.laneCd = laneCd;
		this.blpod1 = blpod1;
		this.bvvd1 = bvvd1;
		this.poletd1 = poletd1;
		this.vslLloydcode1 = vslLloydcode1;
		this.blpol1 = blpol1;
		this.podeta1 = podeta1;
		this.pagerows = pagerows;
		this.podetd1 = podetd1;
		this.vslCallsign1 = vslCallsign1;
		this.vslFullname1 = vslFullname1;
		this.opCode = opCode;
		this.ibflag = ibflag;
		this.polYd = polYd;
		this.poleta1 = poleta1;
		this.polFullname1 = polFullname1;
		this.vslPrePstCd = vslPrePstCd;
		this.vslRgstCntCd1 = vslRgstCntCd1;
		this.podFullname1 = podFullname1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvdtype", getVvdtype());
		this.hashColumns.put("pod_yd", getPodYd());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("blpod1", getBlpod1());
		this.hashColumns.put("bvvd1", getBvvd1());
		this.hashColumns.put("poletd1", getPoletd1());
		this.hashColumns.put("vsl_lloydcode1", getVslLloydcode1());
		this.hashColumns.put("blpol1", getBlpol1());
		this.hashColumns.put("podeta1", getPodeta1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("podetd1", getPodetd1());
		this.hashColumns.put("vsl_callsign1", getVslCallsign1());
		this.hashColumns.put("vsl_fullname1", getVslFullname1());
		this.hashColumns.put("op_code", getOpCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_yd", getPolYd());
		this.hashColumns.put("poleta1", getPoleta1());
		this.hashColumns.put("pol_fullname1", getPolFullname1());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("vsl_rgst_cnt_cd1", getVslRgstCntCd1());
		this.hashColumns.put("pod_fullname1", getPodFullname1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvdtype", "vvdtype");
		this.hashFields.put("pod_yd", "podYd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("blpod1", "blpod1");
		this.hashFields.put("bvvd1", "bvvd1");
		this.hashFields.put("poletd1", "poletd1");
		this.hashFields.put("vsl_lloydcode1", "vslLloydcode1");
		this.hashFields.put("blpol1", "blpol1");
		this.hashFields.put("podeta1", "podeta1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("podetd1", "podetd1");
		this.hashFields.put("vsl_callsign1", "vslCallsign1");
		this.hashFields.put("vsl_fullname1", "vslFullname1");
		this.hashFields.put("op_code", "opCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_yd", "polYd");
		this.hashFields.put("poleta1", "poleta1");
		this.hashFields.put("pol_fullname1", "polFullname1");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("vsl_rgst_cnt_cd1", "vslRgstCntCd1");
		this.hashFields.put("pod_fullname1", "podFullname1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvdtype
	 */
	public String getVvdtype() {
		return this.vvdtype;
	}
	
	/**
	 * Column Info
	 * @return podYd
	 */
	public String getPodYd() {
		return this.podYd;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return blpod1
	 */
	public String getBlpod1() {
		return this.blpod1;
	}
	
	/**
	 * Column Info
	 * @return bvvd1
	 */
	public String getBvvd1() {
		return this.bvvd1;
	}
	
	/**
	 * Column Info
	 * @return poletd1
	 */
	public String getPoletd1() {
		return this.poletd1;
	}
	
	/**
	 * Column Info
	 * @return vslLloydcode1
	 */
	public String getVslLloydcode1() {
		return this.vslLloydcode1;
	}
	
	/**
	 * Column Info
	 * @return blpol1
	 */
	public String getBlpol1() {
		return this.blpol1;
	}
	
	/**
	 * Column Info
	 * @return podeta1
	 */
	public String getPodeta1() {
		return this.podeta1;
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
	 * @return podetd1
	 */
	public String getPodetd1() {
		return this.podetd1;
	}
	
	/**
	 * Column Info
	 * @return vslCallsign1
	 */
	public String getVslCallsign1() {
		return this.vslCallsign1;
	}
	
	/**
	 * Column Info
	 * @return vslFullname1
	 */
	public String getVslFullname1() {
		return this.vslFullname1;
	}
	
	/**
	 * Column Info
	 * @return opCode
	 */
	public String getOpCode() {
		return this.opCode;
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
	 * @return polYd
	 */
	public String getPolYd() {
		return this.polYd;
	}
	
	/**
	 * Column Info
	 * @return poleta1
	 */
	public String getPoleta1() {
		return this.poleta1;
	}
	
	/**
	 * Column Info
	 * @return polFullname1
	 */
	public String getPolFullname1() {
		return this.polFullname1;
	}
	
	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @return vslRgstCntCd1
	 */
	public String getVslRgstCntCd1() {
		return this.vslRgstCntCd1;
	}
	
	/**
	 * Column Info
	 * @return podFullname1
	 */
	public String getPodFullname1() {
		return this.podFullname1;
	}
	

	/**
	 * Column Info
	 * @param vvdtype
	 */
	public void setVvdtype(String vvdtype) {
		this.vvdtype = vvdtype;
	}
	
	/**
	 * Column Info
	 * @param podYd
	 */
	public void setPodYd(String podYd) {
		this.podYd = podYd;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param blpod1
	 */
	public void setBlpod1(String blpod1) {
		this.blpod1 = blpod1;
	}
	
	/**
	 * Column Info
	 * @param bvvd1
	 */
	public void setBvvd1(String bvvd1) {
		this.bvvd1 = bvvd1;
	}
	
	/**
	 * Column Info
	 * @param poletd1
	 */
	public void setPoletd1(String poletd1) {
		this.poletd1 = poletd1;
	}
	
	/**
	 * Column Info
	 * @param vslLloydcode1
	 */
	public void setVslLloydcode1(String vslLloydcode1) {
		this.vslLloydcode1 = vslLloydcode1;
	}
	
	/**
	 * Column Info
	 * @param blpol1
	 */
	public void setBlpol1(String blpol1) {
		this.blpol1 = blpol1;
	}
	
	/**
	 * Column Info
	 * @param podeta1
	 */
	public void setPodeta1(String podeta1) {
		this.podeta1 = podeta1;
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
	 * @param podetd1
	 */
	public void setPodetd1(String podetd1) {
		this.podetd1 = podetd1;
	}
	
	/**
	 * Column Info
	 * @param vslCallsign1
	 */
	public void setVslCallsign1(String vslCallsign1) {
		this.vslCallsign1 = vslCallsign1;
	}
	
	/**
	 * Column Info
	 * @param vslFullname1
	 */
	public void setVslFullname1(String vslFullname1) {
		this.vslFullname1 = vslFullname1;
	}
	
	/**
	 * Column Info
	 * @param opCode
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
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
	 * @param polYd
	 */
	public void setPolYd(String polYd) {
		this.polYd = polYd;
	}
	
	/**
	 * Column Info
	 * @param poleta1
	 */
	public void setPoleta1(String poleta1) {
		this.poleta1 = poleta1;
	}
	
	/**
	 * Column Info
	 * @param polFullname1
	 */
	public void setPolFullname1(String polFullname1) {
		this.polFullname1 = polFullname1;
	}
	
	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @param vslRgstCntCd1
	 */
	public void setVslRgstCntCd1(String vslRgstCntCd1) {
		this.vslRgstCntCd1 = vslRgstCntCd1;
	}
	
	/**
	 * Column Info
	 * @param podFullname1
	 */
	public void setPodFullname1(String podFullname1) {
		this.podFullname1 = podFullname1;
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
		setVvdtype(JSPUtil.getParameter(request, prefix + "vvdtype", ""));
		setPodYd(JSPUtil.getParameter(request, prefix + "pod_yd", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setBlpod1(JSPUtil.getParameter(request, prefix + "blpod1", ""));
		setBvvd1(JSPUtil.getParameter(request, prefix + "bvvd1", ""));
		setPoletd1(JSPUtil.getParameter(request, prefix + "poletd1", ""));
		setVslLloydcode1(JSPUtil.getParameter(request, prefix + "vsl_lloydcode1", ""));
		setBlpol1(JSPUtil.getParameter(request, prefix + "blpol1", ""));
		setPodeta1(JSPUtil.getParameter(request, prefix + "podeta1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodetd1(JSPUtil.getParameter(request, prefix + "podetd1", ""));
		setVslCallsign1(JSPUtil.getParameter(request, prefix + "vsl_callsign1", ""));
		setVslFullname1(JSPUtil.getParameter(request, prefix + "vsl_fullname1", ""));
		setOpCode(JSPUtil.getParameter(request, prefix + "op_code", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolYd(JSPUtil.getParameter(request, prefix + "pol_yd", ""));
		setPoleta1(JSPUtil.getParameter(request, prefix + "poleta1", ""));
		setPolFullname1(JSPUtil.getParameter(request, prefix + "pol_fullname1", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
		setVslRgstCntCd1(JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_cd1", ""));
		setPodFullname1(JSPUtil.getParameter(request, prefix + "pod_fullname1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProVslEtcInfoVO[]
	 */
	public SitProVslEtcInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProVslEtcInfoVO[]
	 */
	public SitProVslEtcInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProVslEtcInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvdtype = (JSPUtil.getParameter(request, prefix	+ "vvdtype", length));
			String[] podYd = (JSPUtil.getParameter(request, prefix	+ "pod_yd", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] blpod1 = (JSPUtil.getParameter(request, prefix	+ "blpod1", length));
			String[] bvvd1 = (JSPUtil.getParameter(request, prefix	+ "bvvd1", length));
			String[] poletd1 = (JSPUtil.getParameter(request, prefix	+ "poletd1", length));
			String[] vslLloydcode1 = (JSPUtil.getParameter(request, prefix	+ "vsl_lloydcode1", length));
			String[] blpol1 = (JSPUtil.getParameter(request, prefix	+ "blpol1", length));
			String[] podeta1 = (JSPUtil.getParameter(request, prefix	+ "podeta1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podetd1 = (JSPUtil.getParameter(request, prefix	+ "podetd1", length));
			String[] vslCallsign1 = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign1", length));
			String[] vslFullname1 = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname1", length));
			String[] opCode = (JSPUtil.getParameter(request, prefix	+ "op_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polYd = (JSPUtil.getParameter(request, prefix	+ "pol_yd", length));
			String[] poleta1 = (JSPUtil.getParameter(request, prefix	+ "poleta1", length));
			String[] polFullname1 = (JSPUtil.getParameter(request, prefix	+ "pol_fullname1", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] vslRgstCntCd1 = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd1", length));
			String[] podFullname1 = (JSPUtil.getParameter(request, prefix	+ "pod_fullname1", length));
			
			for (int i = 0; i < length; i++) {
				model = new SitProVslEtcInfoVO();
				if (vvdtype[i] != null)
					model.setVvdtype(vvdtype[i]);
				if (podYd[i] != null)
					model.setPodYd(podYd[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (blpod1[i] != null)
					model.setBlpod1(blpod1[i]);
				if (bvvd1[i] != null)
					model.setBvvd1(bvvd1[i]);
				if (poletd1[i] != null)
					model.setPoletd1(poletd1[i]);
				if (vslLloydcode1[i] != null)
					model.setVslLloydcode1(vslLloydcode1[i]);
				if (blpol1[i] != null)
					model.setBlpol1(blpol1[i]);
				if (podeta1[i] != null)
					model.setPodeta1(podeta1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podetd1[i] != null)
					model.setPodetd1(podetd1[i]);
				if (vslCallsign1[i] != null)
					model.setVslCallsign1(vslCallsign1[i]);
				if (vslFullname1[i] != null)
					model.setVslFullname1(vslFullname1[i]);
				if (opCode[i] != null)
					model.setOpCode(opCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polYd[i] != null)
					model.setPolYd(polYd[i]);
				if (poleta1[i] != null)
					model.setPoleta1(poleta1[i]);
				if (polFullname1[i] != null)
					model.setPolFullname1(polFullname1[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (vslRgstCntCd1[i] != null)
					model.setVslRgstCntCd1(vslRgstCntCd1[i]);
				if (podFullname1[i] != null)
					model.setPodFullname1(podFullname1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProVslEtcInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProVslEtcInfoVO[]
	 */
	public SitProVslEtcInfoVO[] getSitProVslEtcInfoVOs(){
		SitProVslEtcInfoVO[] vos = (SitProVslEtcInfoVO[])models.toArray(new SitProVslEtcInfoVO[models.size()]);
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
		this.vvdtype = this.vvdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYd = this.podYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod1 = this.blpod1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bvvd1 = this.bvvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poletd1 = this.poletd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloydcode1 = this.vslLloydcode1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol1 = this.blpol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podeta1 = this.podeta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podetd1 = this.podetd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign1 = this.vslCallsign1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname1 = this.vslFullname1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCode = this.opCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYd = this.polYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poleta1 = this.poleta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFullname1 = this.polFullname1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd1 = this.vslRgstCntCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFullname1 = this.podFullname1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
