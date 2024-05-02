/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaRailYardManageVO.java
*@FileTitle : UsaRailYardManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaRailYardManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaRailYardManageVO> models = new ArrayList<UsaRailYardManageVO>();
	
	/* Column Info */
	private String ydCtrlOfcCtyNm = null;
	/* Column Info */
	private String ydCtrlOfcSteCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCtrlOfcZipCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String ydCtrlOfcAddr = null;
	/* Column Info */
	private String ydLocSteCd = null;
	/* Column Info */
	private String ydLocCtyNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaRailYardManageVO() {}

	public UsaRailYardManageVO(String ibflag, String pagerows, String ydCd, String ydNm, String ydLocCtyNm, String ydLocSteCd, String ydCtrlOfcAddr, String ydCtrlOfcCtyNm, String ydCtrlOfcSteCd, String ydCtrlOfcZipCd) {
		this.ydCtrlOfcCtyNm = ydCtrlOfcCtyNm;
		this.ydCtrlOfcSteCd = ydCtrlOfcSteCd;
		this.ibflag = ibflag;
		this.ydCtrlOfcZipCd = ydCtrlOfcZipCd;
		this.ydCd = ydCd;
		this.ydNm = ydNm;
		this.ydCtrlOfcAddr = ydCtrlOfcAddr;
		this.ydLocSteCd = ydLocSteCd;
		this.ydLocCtyNm = ydLocCtyNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yd_ctrl_ofc_cty_nm", getYdCtrlOfcCtyNm());
		this.hashColumns.put("yd_ctrl_ofc_ste_cd", getYdCtrlOfcSteCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_ctrl_ofc_zip_cd", getYdCtrlOfcZipCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("yd_ctrl_ofc_addr", getYdCtrlOfcAddr());
		this.hashColumns.put("yd_loc_ste_cd", getYdLocSteCd());
		this.hashColumns.put("yd_loc_cty_nm", getYdLocCtyNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yd_ctrl_ofc_cty_nm", "ydCtrlOfcCtyNm");
		this.hashFields.put("yd_ctrl_ofc_ste_cd", "ydCtrlOfcSteCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_ctrl_ofc_zip_cd", "ydCtrlOfcZipCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("yd_ctrl_ofc_addr", "ydCtrlOfcAddr");
		this.hashFields.put("yd_loc_ste_cd", "ydLocSteCd");
		this.hashFields.put("yd_loc_cty_nm", "ydLocCtyNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ydCtrlOfcCtyNm
	 */
	public String getYdCtrlOfcCtyNm() {
		return this.ydCtrlOfcCtyNm;
	}
	
	/**
	 * Column Info
	 * @return ydCtrlOfcSteCd
	 */
	public String getYdCtrlOfcSteCd() {
		return this.ydCtrlOfcSteCd;
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
	 * @return ydCtrlOfcZipCd
	 */
	public String getYdCtrlOfcZipCd() {
		return this.ydCtrlOfcZipCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return ydCtrlOfcAddr
	 */
	public String getYdCtrlOfcAddr() {
		return this.ydCtrlOfcAddr;
	}
	
	/**
	 * Column Info
	 * @return ydLocSteCd
	 */
	public String getYdLocSteCd() {
		return this.ydLocSteCd;
	}
	
	/**
	 * Column Info
	 * @return ydLocCtyNm
	 */
	public String getYdLocCtyNm() {
		return this.ydLocCtyNm;
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
	 * @param ydCtrlOfcCtyNm
	 */
	public void setYdCtrlOfcCtyNm(String ydCtrlOfcCtyNm) {
		this.ydCtrlOfcCtyNm = ydCtrlOfcCtyNm;
	}
	
	/**
	 * Column Info
	 * @param ydCtrlOfcSteCd
	 */
	public void setYdCtrlOfcSteCd(String ydCtrlOfcSteCd) {
		this.ydCtrlOfcSteCd = ydCtrlOfcSteCd;
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
	 * @param ydCtrlOfcZipCd
	 */
	public void setYdCtrlOfcZipCd(String ydCtrlOfcZipCd) {
		this.ydCtrlOfcZipCd = ydCtrlOfcZipCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param ydCtrlOfcAddr
	 */
	public void setYdCtrlOfcAddr(String ydCtrlOfcAddr) {
		this.ydCtrlOfcAddr = ydCtrlOfcAddr;
	}
	
	/**
	 * Column Info
	 * @param ydLocSteCd
	 */
	public void setYdLocSteCd(String ydLocSteCd) {
		this.ydLocSteCd = ydLocSteCd;
	}
	
	/**
	 * Column Info
	 * @param ydLocCtyNm
	 */
	public void setYdLocCtyNm(String ydLocCtyNm) {
		this.ydLocCtyNm = ydLocCtyNm;
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
		setYdCtrlOfcCtyNm(JSPUtil.getParameter(request, "yd_ctrl_ofc_cty_nm", ""));
		setYdCtrlOfcSteCd(JSPUtil.getParameter(request, "yd_ctrl_ofc_ste_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdCtrlOfcZipCd(JSPUtil.getParameter(request, "yd_ctrl_ofc_zip_cd", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setYdNm(JSPUtil.getParameter(request, "yd_nm", ""));
		setYdCtrlOfcAddr(JSPUtil.getParameter(request, "yd_ctrl_ofc_addr", ""));
		setYdLocSteCd(JSPUtil.getParameter(request, "yd_loc_ste_cd", ""));
		setYdLocCtyNm(JSPUtil.getParameter(request, "yd_loc_cty_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaRailYardManageVO[]
	 */
	public UsaRailYardManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaRailYardManageVO[]
	 */
	public UsaRailYardManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaRailYardManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ydCtrlOfcCtyNm = (JSPUtil.getParameter(request, prefix	+ "yd_ctrl_ofc_cty_nm", length));
			String[] ydCtrlOfcSteCd = (JSPUtil.getParameter(request, prefix	+ "yd_ctrl_ofc_ste_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCtrlOfcZipCd = (JSPUtil.getParameter(request, prefix	+ "yd_ctrl_ofc_zip_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] ydCtrlOfcAddr = (JSPUtil.getParameter(request, prefix	+ "yd_ctrl_ofc_addr", length));
			String[] ydLocSteCd = (JSPUtil.getParameter(request, prefix	+ "yd_loc_ste_cd", length));
			String[] ydLocCtyNm = (JSPUtil.getParameter(request, prefix	+ "yd_loc_cty_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaRailYardManageVO();
				if (ydCtrlOfcCtyNm[i] != null)
					model.setYdCtrlOfcCtyNm(ydCtrlOfcCtyNm[i]);
				if (ydCtrlOfcSteCd[i] != null)
					model.setYdCtrlOfcSteCd(ydCtrlOfcSteCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCtrlOfcZipCd[i] != null)
					model.setYdCtrlOfcZipCd(ydCtrlOfcZipCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (ydCtrlOfcAddr[i] != null)
					model.setYdCtrlOfcAddr(ydCtrlOfcAddr[i]);
				if (ydLocSteCd[i] != null)
					model.setYdLocSteCd(ydLocSteCd[i]);
				if (ydLocCtyNm[i] != null)
					model.setYdLocCtyNm(ydLocCtyNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaRailYardManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaRailYardManageVO[]
	 */
	public UsaRailYardManageVO[] getUsaRailYardManageVOs(){
		UsaRailYardManageVO[] vos = (UsaRailYardManageVO[])models.toArray(new UsaRailYardManageVO[models.size()]);
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
		this.ydCtrlOfcCtyNm = this.ydCtrlOfcCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCtrlOfcSteCd = this.ydCtrlOfcSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCtrlOfcZipCd = this.ydCtrlOfcZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCtrlOfcAddr = this.ydCtrlOfcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydLocSteCd = this.ydLocSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydLocCtyNm = this.ydLocCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
