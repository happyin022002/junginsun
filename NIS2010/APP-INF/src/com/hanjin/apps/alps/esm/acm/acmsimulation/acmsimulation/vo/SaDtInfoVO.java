/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SaDtInfoVO.java
*@FileTitle : SaDtInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.01
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.01 김봉균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SaDtInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SaDtInfoVO> models = new ArrayList<SaDtInfoVO>();
	
	/* Column Info */
	private String ibRevDirCd = null;
	/* Column Info */
	private String obVvd = null;
	/* Column Info */
	private String ibSkdDirCd = null;
	/* Column Info */
	private String obVslCd = null;
	/* Column Info */
	private String obSkdVoyNo = null;
	/* Column Info */
	private String obSaDt = null;
	/* Column Info */
	private String ibSkdVoyNo = null;
	/* Column Info */
	private String obRlaneCd = null;
	/* Column Info */
	private String ibRlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obRevDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String obSlanCd = null;
	/* Column Info */
	private String obSkdDirCd = null;
	/* Column Info */
	private String ibPort = null;
	/* Column Info */
	private String ibSlanCd = null;
	/* Column Info */
	private String obPort = null;
	/* Column Info */
	private String ibVslCd = null;
	/* Column Info */
	private String ibVvd = null;
	/* Column Info */
	private String ibSaDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SaDtInfoVO() {}

	public SaDtInfoVO(String ibflag, String pagerows, String bkgNo, String obSaDt, String obVvd, String obVslCd, String obSkdVoyNo, String obSkdDirCd, String obPort, String obSlanCd, String obRlaneCd, String obRevDirCd, String ibSaDt, String ibVvd, String ibVslCd, String ibSkdVoyNo, String ibSkdDirCd, String ibPort, String ibSlanCd, String ibRlaneCd, String ibRevDirCd) {
		this.ibRevDirCd = ibRevDirCd;
		this.obVvd = obVvd;
		this.ibSkdDirCd = ibSkdDirCd;
		this.obVslCd = obVslCd;
		this.obSkdVoyNo = obSkdVoyNo;
		this.obSaDt = obSaDt;
		this.ibSkdVoyNo = ibSkdVoyNo;
		this.obRlaneCd = obRlaneCd;
		this.ibRlaneCd = ibRlaneCd;
		this.pagerows = pagerows;
		this.obRevDirCd = obRevDirCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.obSlanCd = obSlanCd;
		this.obSkdDirCd = obSkdDirCd;
		this.ibPort = ibPort;
		this.ibSlanCd = ibSlanCd;
		this.obPort = obPort;
		this.ibVslCd = ibVslCd;
		this.ibVvd = ibVvd;
		this.ibSaDt = ibSaDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ib_rev_dir_cd", getIbRevDirCd());
		this.hashColumns.put("ob_vvd", getObVvd());
		this.hashColumns.put("ib_skd_dir_cd", getIbSkdDirCd());
		this.hashColumns.put("ob_vsl_cd", getObVslCd());
		this.hashColumns.put("ob_skd_voy_no", getObSkdVoyNo());
		this.hashColumns.put("ob_sa_dt", getObSaDt());
		this.hashColumns.put("ib_skd_voy_no", getIbSkdVoyNo());
		this.hashColumns.put("ob_rlane_cd", getObRlaneCd());
		this.hashColumns.put("ib_rlane_cd", getIbRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_rev_dir_cd", getObRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ob_slan_cd", getObSlanCd());
		this.hashColumns.put("ob_skd_dir_cd", getObSkdDirCd());
		this.hashColumns.put("ib_port", getIbPort());
		this.hashColumns.put("ib_slan_cd", getIbSlanCd());
		this.hashColumns.put("ob_port", getObPort());
		this.hashColumns.put("ib_vsl_cd", getIbVslCd());
		this.hashColumns.put("ib_vvd", getIbVvd());
		this.hashColumns.put("ib_sa_dt", getIbSaDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ib_rev_dir_cd", "ibRevDirCd");
		this.hashFields.put("ob_vvd", "obVvd");
		this.hashFields.put("ib_skd_dir_cd", "ibSkdDirCd");
		this.hashFields.put("ob_vsl_cd", "obVslCd");
		this.hashFields.put("ob_skd_voy_no", "obSkdVoyNo");
		this.hashFields.put("ob_sa_dt", "obSaDt");
		this.hashFields.put("ib_skd_voy_no", "ibSkdVoyNo");
		this.hashFields.put("ob_rlane_cd", "obRlaneCd");
		this.hashFields.put("ib_rlane_cd", "ibRlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_rev_dir_cd", "obRevDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ob_slan_cd", "obSlanCd");
		this.hashFields.put("ob_skd_dir_cd", "obSkdDirCd");
		this.hashFields.put("ib_port", "ibPort");
		this.hashFields.put("ib_slan_cd", "ibSlanCd");
		this.hashFields.put("ob_port", "obPort");
		this.hashFields.put("ib_vsl_cd", "ibVslCd");
		this.hashFields.put("ib_vvd", "ibVvd");
		this.hashFields.put("ib_sa_dt", "ibSaDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ibRevDirCd
	 */
	public String getIbRevDirCd() {
		return this.ibRevDirCd;
	}
	
	/**
	 * Column Info
	 * @return obVvd
	 */
	public String getObVvd() {
		return this.obVvd;
	}
	
	/**
	 * Column Info
	 * @return ibSkdDirCd
	 */
	public String getIbSkdDirCd() {
		return this.ibSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return obVslCd
	 */
	public String getObVslCd() {
		return this.obVslCd;
	}
	
	/**
	 * Column Info
	 * @return obSkdVoyNo
	 */
	public String getObSkdVoyNo() {
		return this.obSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return obSaDt
	 */
	public String getObSaDt() {
		return this.obSaDt;
	}
	
	/**
	 * Column Info
	 * @return ibSkdVoyNo
	 */
	public String getIbSkdVoyNo() {
		return this.ibSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return obRlaneCd
	 */
	public String getObRlaneCd() {
		return this.obRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return ibRlaneCd
	 */
	public String getIbRlaneCd() {
		return this.ibRlaneCd;
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
	 * @return obRevDirCd
	 */
	public String getObRevDirCd() {
		return this.obRevDirCd;
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
	 * @return obSlanCd
	 */
	public String getObSlanCd() {
		return this.obSlanCd;
	}
	
	/**
	 * Column Info
	 * @return obSkdDirCd
	 */
	public String getObSkdDirCd() {
		return this.obSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return ibPort
	 */
	public String getIbPort() {
		return this.ibPort;
	}
	
	/**
	 * Column Info
	 * @return ibSlanCd
	 */
	public String getIbSlanCd() {
		return this.ibSlanCd;
	}
	
	/**
	 * Column Info
	 * @return obPort
	 */
	public String getObPort() {
		return this.obPort;
	}
	
	/**
	 * Column Info
	 * @return ibVslCd
	 */
	public String getIbVslCd() {
		return this.ibVslCd;
	}
	
	/**
	 * Column Info
	 * @return ibVvd
	 */
	public String getIbVvd() {
		return this.ibVvd;
	}
	
	/**
	 * Column Info
	 * @return ibSaDt
	 */
	public String getIbSaDt() {
		return this.ibSaDt;
	}
	

	/**
	 * Column Info
	 * @param ibRevDirCd
	 */
	public void setIbRevDirCd(String ibRevDirCd) {
		this.ibRevDirCd = ibRevDirCd;
	}
	
	/**
	 * Column Info
	 * @param obVvd
	 */
	public void setObVvd(String obVvd) {
		this.obVvd = obVvd;
	}
	
	/**
	 * Column Info
	 * @param ibSkdDirCd
	 */
	public void setIbSkdDirCd(String ibSkdDirCd) {
		this.ibSkdDirCd = ibSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param obVslCd
	 */
	public void setObVslCd(String obVslCd) {
		this.obVslCd = obVslCd;
	}
	
	/**
	 * Column Info
	 * @param obSkdVoyNo
	 */
	public void setObSkdVoyNo(String obSkdVoyNo) {
		this.obSkdVoyNo = obSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param obSaDt
	 */
	public void setObSaDt(String obSaDt) {
		this.obSaDt = obSaDt;
	}
	
	/**
	 * Column Info
	 * @param ibSkdVoyNo
	 */
	public void setIbSkdVoyNo(String ibSkdVoyNo) {
		this.ibSkdVoyNo = ibSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param obRlaneCd
	 */
	public void setObRlaneCd(String obRlaneCd) {
		this.obRlaneCd = obRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param ibRlaneCd
	 */
	public void setIbRlaneCd(String ibRlaneCd) {
		this.ibRlaneCd = ibRlaneCd;
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
	 * @param obRevDirCd
	 */
	public void setObRevDirCd(String obRevDirCd) {
		this.obRevDirCd = obRevDirCd;
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
	 * @param obSlanCd
	 */
	public void setObSlanCd(String obSlanCd) {
		this.obSlanCd = obSlanCd;
	}
	
	/**
	 * Column Info
	 * @param obSkdDirCd
	 */
	public void setObSkdDirCd(String obSkdDirCd) {
		this.obSkdDirCd = obSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param ibPort
	 */
	public void setIbPort(String ibPort) {
		this.ibPort = ibPort;
	}
	
	/**
	 * Column Info
	 * @param ibSlanCd
	 */
	public void setIbSlanCd(String ibSlanCd) {
		this.ibSlanCd = ibSlanCd;
	}
	
	/**
	 * Column Info
	 * @param obPort
	 */
	public void setObPort(String obPort) {
		this.obPort = obPort;
	}
	
	/**
	 * Column Info
	 * @param ibVslCd
	 */
	public void setIbVslCd(String ibVslCd) {
		this.ibVslCd = ibVslCd;
	}
	
	/**
	 * Column Info
	 * @param ibVvd
	 */
	public void setIbVvd(String ibVvd) {
		this.ibVvd = ibVvd;
	}
	
	/**
	 * Column Info
	 * @param ibSaDt
	 */
	public void setIbSaDt(String ibSaDt) {
		this.ibSaDt = ibSaDt;
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
		setIbRevDirCd(JSPUtil.getParameter(request, prefix + "ib_rev_dir_cd", ""));
		setObVvd(JSPUtil.getParameter(request, prefix + "ob_vvd", ""));
		setIbSkdDirCd(JSPUtil.getParameter(request, prefix + "ib_skd_dir_cd", ""));
		setObVslCd(JSPUtil.getParameter(request, prefix + "ob_vsl_cd", ""));
		setObSkdVoyNo(JSPUtil.getParameter(request, prefix + "ob_skd_voy_no", ""));
		setObSaDt(JSPUtil.getParameter(request, prefix + "ob_sa_dt", ""));
		setIbSkdVoyNo(JSPUtil.getParameter(request, prefix + "ib_skd_voy_no", ""));
		setObRlaneCd(JSPUtil.getParameter(request, prefix + "ob_rlane_cd", ""));
		setIbRlaneCd(JSPUtil.getParameter(request, prefix + "ib_rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObRevDirCd(JSPUtil.getParameter(request, prefix + "ob_rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setObSlanCd(JSPUtil.getParameter(request, prefix + "ob_slan_cd", ""));
		setObSkdDirCd(JSPUtil.getParameter(request, prefix + "ob_skd_dir_cd", ""));
		setIbPort(JSPUtil.getParameter(request, prefix + "ib_port", ""));
		setIbSlanCd(JSPUtil.getParameter(request, prefix + "ib_slan_cd", ""));
		setObPort(JSPUtil.getParameter(request, prefix + "ob_port", ""));
		setIbVslCd(JSPUtil.getParameter(request, prefix + "ib_vsl_cd", ""));
		setIbVvd(JSPUtil.getParameter(request, prefix + "ib_vvd", ""));
		setIbSaDt(JSPUtil.getParameter(request, prefix + "ib_sa_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SaDtInfoVO[]
	 */
	public SaDtInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SaDtInfoVO[]
	 */
	public SaDtInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SaDtInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibRevDirCd = (JSPUtil.getParameter(request, prefix	+ "ib_rev_dir_cd", length));
			String[] obVvd = (JSPUtil.getParameter(request, prefix	+ "ob_vvd", length));
			String[] ibSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "ib_skd_dir_cd", length));
			String[] obVslCd = (JSPUtil.getParameter(request, prefix	+ "ob_vsl_cd", length));
			String[] obSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "ob_skd_voy_no", length));
			String[] obSaDt = (JSPUtil.getParameter(request, prefix	+ "ob_sa_dt", length));
			String[] ibSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_skd_voy_no", length));
			String[] obRlaneCd = (JSPUtil.getParameter(request, prefix	+ "ob_rlane_cd", length));
			String[] ibRlaneCd = (JSPUtil.getParameter(request, prefix	+ "ib_rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obRevDirCd = (JSPUtil.getParameter(request, prefix	+ "ob_rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] obSlanCd = (JSPUtil.getParameter(request, prefix	+ "ob_slan_cd", length));
			String[] obSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "ob_skd_dir_cd", length));
			String[] ibPort = (JSPUtil.getParameter(request, prefix	+ "ib_port", length));
			String[] ibSlanCd = (JSPUtil.getParameter(request, prefix	+ "ib_slan_cd", length));
			String[] obPort = (JSPUtil.getParameter(request, prefix	+ "ob_port", length));
			String[] ibVslCd = (JSPUtil.getParameter(request, prefix	+ "ib_vsl_cd", length));
			String[] ibVvd = (JSPUtil.getParameter(request, prefix	+ "ib_vvd", length));
			String[] ibSaDt = (JSPUtil.getParameter(request, prefix	+ "ib_sa_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SaDtInfoVO();
				if (ibRevDirCd[i] != null)
					model.setIbRevDirCd(ibRevDirCd[i]);
				if (obVvd[i] != null)
					model.setObVvd(obVvd[i]);
				if (ibSkdDirCd[i] != null)
					model.setIbSkdDirCd(ibSkdDirCd[i]);
				if (obVslCd[i] != null)
					model.setObVslCd(obVslCd[i]);
				if (obSkdVoyNo[i] != null)
					model.setObSkdVoyNo(obSkdVoyNo[i]);
				if (obSaDt[i] != null)
					model.setObSaDt(obSaDt[i]);
				if (ibSkdVoyNo[i] != null)
					model.setIbSkdVoyNo(ibSkdVoyNo[i]);
				if (obRlaneCd[i] != null)
					model.setObRlaneCd(obRlaneCd[i]);
				if (ibRlaneCd[i] != null)
					model.setIbRlaneCd(ibRlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obRevDirCd[i] != null)
					model.setObRevDirCd(obRevDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (obSlanCd[i] != null)
					model.setObSlanCd(obSlanCd[i]);
				if (obSkdDirCd[i] != null)
					model.setObSkdDirCd(obSkdDirCd[i]);
				if (ibPort[i] != null)
					model.setIbPort(ibPort[i]);
				if (ibSlanCd[i] != null)
					model.setIbSlanCd(ibSlanCd[i]);
				if (obPort[i] != null)
					model.setObPort(obPort[i]);
				if (ibVslCd[i] != null)
					model.setIbVslCd(ibVslCd[i]);
				if (ibVvd[i] != null)
					model.setIbVvd(ibVvd[i]);
				if (ibSaDt[i] != null)
					model.setIbSaDt(ibSaDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSaDtInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SaDtInfoVO[]
	 */
	public SaDtInfoVO[] getSaDtInfoVOs(){
		SaDtInfoVO[] vos = (SaDtInfoVO[])models.toArray(new SaDtInfoVO[models.size()]);
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
		this.ibRevDirCd = this.ibRevDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obVvd = this.obVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSkdDirCd = this.ibSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obVslCd = this.obVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSkdVoyNo = this.obSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSaDt = this.obSaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSkdVoyNo = this.ibSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obRlaneCd = this.obRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibRlaneCd = this.ibRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obRevDirCd = this.obRevDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlanCd = this.obSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSkdDirCd = this.obSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPort = this.ibPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSlanCd = this.ibSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obPort = this.obPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibVslCd = this.ibVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibVvd = this.ibVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSaDt = this.ibSaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
