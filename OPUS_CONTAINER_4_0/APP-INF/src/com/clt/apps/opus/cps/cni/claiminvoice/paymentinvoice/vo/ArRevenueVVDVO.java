/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArRevenueVVDVO.java
*@FileTitle : ArRevenueVVDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.03.10 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArRevenueVVDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArRevenueVVDVO> models = new ArrayList<ArRevenueVVDVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String revPortCd = null;
	/* Column Info */
	private String portChkFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String voyTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String rlaneDirCd = null;
	/* Column Info */
	private String comVvdFlg = null;
	/* Column Info */
	private String vvdComLvl = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArRevenueVVDVO() {}

	public ArRevenueVVDVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String rlaneDirCd, String voyTpCd, String slanCd, String portChkFlg, String revPortCd, String lodQty, String revYrmon, String comVvdFlg, String vvdComLvl, String rlaneCd) {
		this.vslCd = vslCd;
		this.lodQty = lodQty;
		this.revYrmon = revYrmon;
		this.skdVoyNo = skdVoyNo;
		this.rlaneCd = rlaneCd;
		this.revPortCd = revPortCd;
		this.portChkFlg = portChkFlg;
		this.skdDirCd = skdDirCd;
		this.voyTpCd = voyTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.rlaneDirCd = rlaneDirCd;
		this.comVvdFlg = comVvdFlg;
		this.vvdComLvl = vvdComLvl;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rev_port_cd", getRevPortCd());
		this.hashColumns.put("port_chk_flg", getPortChkFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("voy_tp_cd", getVoyTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("rlane_dir_cd", getRlaneDirCd());
		this.hashColumns.put("com_vvd_flg", getComVvdFlg());
		this.hashColumns.put("vvd_com_lvl", getVvdComLvl());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rev_port_cd", "revPortCd");
		this.hashFields.put("port_chk_flg", "portChkFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("voy_tp_cd", "voyTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("rlane_dir_cd", "rlaneDirCd");
		this.hashFields.put("com_vvd_flg", "comVvdFlg");
		this.hashFields.put("vvd_com_lvl", "vvdComLvl");
		return this.hashFields;
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
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return revPortCd
	 */
	public String getRevPortCd() {
		return this.revPortCd;
	}
	
	/**
	 * Column Info
	 * @return portChkFlg
	 */
	public String getPortChkFlg() {
		return this.portChkFlg;
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
	 * @return voyTpCd
	 */
	public String getVoyTpCd() {
		return this.voyTpCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneDirCd
	 */
	public String getRlaneDirCd() {
		return this.rlaneDirCd;
	}
	
	/**
	 * Column Info
	 * @return comVvdFlg
	 */
	public String getComVvdFlg() {
		return this.comVvdFlg;
	}
	
	/**
	 * Column Info
	 * @return vvdComLvl
	 */
	public String getVvdComLvl() {
		return this.vvdComLvl;
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
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param revPortCd
	 */
	public void setRevPortCd(String revPortCd) {
		this.revPortCd = revPortCd;
	}
	
	/**
	 * Column Info
	 * @param portChkFlg
	 */
	public void setPortChkFlg(String portChkFlg) {
		this.portChkFlg = portChkFlg;
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
	 * @param voyTpCd
	 */
	public void setVoyTpCd(String voyTpCd) {
		this.voyTpCd = voyTpCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneDirCd
	 */
	public void setRlaneDirCd(String rlaneDirCd) {
		this.rlaneDirCd = rlaneDirCd;
	}
	
	/**
	 * Column Info
	 * @param comVvdFlg
	 */
	public void setComVvdFlg(String comVvdFlg) {
		this.comVvdFlg = comVvdFlg;
	}
	
	/**
	 * Column Info
	 * @param vvdComLvl
	 */
	public void setVvdComLvl(String vvdComLvl) {
		this.vvdComLvl = vvdComLvl;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setRevPortCd(JSPUtil.getParameter(request, prefix + "rev_port_cd", ""));
		setPortChkFlg(JSPUtil.getParameter(request, prefix + "port_chk_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVoyTpCd(JSPUtil.getParameter(request, prefix + "voy_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setRlaneDirCd(JSPUtil.getParameter(request, prefix + "rlane_dir_cd", ""));
		setComVvdFlg(JSPUtil.getParameter(request, prefix + "com_vvd_flg", ""));
		setVvdComLvl(JSPUtil.getParameter(request, prefix + "vvd_com_lvl", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArRevenueVVDVO[]
	 */
	public ArRevenueVVDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArRevenueVVDVO[]
	 */
	public ArRevenueVVDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArRevenueVVDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] revPortCd = (JSPUtil.getParameter(request, prefix	+ "rev_port_cd", length));
			String[] portChkFlg = (JSPUtil.getParameter(request, prefix	+ "port_chk_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] voyTpCd = (JSPUtil.getParameter(request, prefix	+ "voy_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] rlaneDirCd = (JSPUtil.getParameter(request, prefix	+ "rlane_dir_cd", length));
			String[] comVvdFlg = (JSPUtil.getParameter(request, prefix	+ "com_vvd_flg", length));
			String[] vvdComLvl = (JSPUtil.getParameter(request, prefix	+ "vvd_com_lvl", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArRevenueVVDVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (revPortCd[i] != null)
					model.setRevPortCd(revPortCd[i]);
				if (portChkFlg[i] != null)
					model.setPortChkFlg(portChkFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (voyTpCd[i] != null)
					model.setVoyTpCd(voyTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (rlaneDirCd[i] != null)
					model.setRlaneDirCd(rlaneDirCd[i]);
				if (comVvdFlg[i] != null)
					model.setComVvdFlg(comVvdFlg[i]);
				if (vvdComLvl[i] != null)
					model.setVvdComLvl(vvdComLvl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArRevenueVVDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArRevenueVVDVO[]
	 */
	public ArRevenueVVDVO[] getArRevenueVVDVOs(){
		ArRevenueVVDVO[] vos = (ArRevenueVVDVO[])models.toArray(new ArRevenueVVDVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPortCd = this.revPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portChkFlg = this.portChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyTpCd = this.voyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneDirCd = this.rlaneDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comVvdFlg = this.comVvdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdComLvl = this.vvdComLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
