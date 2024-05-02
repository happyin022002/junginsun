/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgUserSmsInputVO.java
*@FileTitle : BkgUserSmsInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.08  
* 1.0 Creation
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgUserSmsInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgUserSmsInputVO> models = new ArrayList<BkgUserSmsInputVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chkSlanCd = null;
	/* Column Info */
	private String chkDirCd = null;
	/* Column Info */
	private String loclTsIndCd = null;
	/* Column Info */
	private String portCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgUserSmsInputVO() {}

	public BkgUserSmsInputVO(String ibflag, String pagerows, String slanCd, String dirCd, String chkSlanCd, String chkDirCd, String loclTsIndCd, String portCd) {
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.dirCd = dirCd;
		this.pagerows = pagerows;
		this.chkSlanCd = chkSlanCd;
		this.chkDirCd = chkDirCd;
		this.loclTsIndCd = loclTsIndCd;
		this.portCd = portCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chk_slan_cd", getChkSlanCd());
		this.hashColumns.put("chk_dir_cd", getChkDirCd());
		this.hashColumns.put("locl_ts_ind_cd", getLoclTsIndCd());
		this.hashColumns.put("port_cd", getPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chk_slan_cd", "chkSlanCd");
		this.hashFields.put("chk_dir_cd", "chkDirCd");
		this.hashFields.put("locl_ts_ind_cd", "loclTsIndCd");
		this.hashFields.put("port_cd", "portCd");
		return this.hashFields;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	public String getChkSlanCd() {
		return chkSlanCd;
	}

	public String getChkDirCd() {
		return chkDirCd;
	}
	
	/**
	 * Column Info
	 * @return loclTsIndCd
	 */
	public String getLoclTsIndCd() {
		return loclTsIndCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return portCd;
	}

	public void setChkDirCd(String chkDirCd) {
		this.chkDirCd = chkDirCd;
	}

	public void setChkSlanCd(String chkSlanCd) {
		this.chkSlanCd = chkSlanCd;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
	 * @param loclTsIndCd
	 */
	public void setLoclTsIndCd(String loclTsIndCd) {
		this.loclTsIndCd = loclTsIndCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setChkSlanCd(JSPUtil.getParameter(request, prefix + "chk_slan_cd", ""));
		setChkDirCd(JSPUtil.getParameter(request, prefix + "chk_dir_cd", ""));
		setLoclTsIndCd(JSPUtil.getParameter(request, prefix + "locl_ts_ind_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgUserSmsInputVO[]
	 */
	public BkgUserSmsInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgUserSmsInputVO[]
	 */
	public BkgUserSmsInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgUserSmsInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chkSlanCd = (JSPUtil.getParameter(request, prefix	+ "chk_slan_cd", length));
			String[] chkDirCd = (JSPUtil.getParameter(request, prefix	+ "chk_dir_cd", length));
			String[] loclTsIndCd = (JSPUtil.getParameter(request, prefix	+ "locl_ts_ind_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgUserSmsInputVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chkSlanCd[i] != null)
					model.setChkSlanCd(chkSlanCd[i]);
				if (chkDirCd[i] != null)
					model.setChkDirCd(chkDirCd[i]);
				if (loclTsIndCd[i] != null)
					model.setLoclTsIndCd(loclTsIndCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgUserSmsInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgUserSmsInputVO[]
	 */
	public BkgUserSmsInputVO[] getBkgUserSmsInputVOs(){
		BkgUserSmsInputVO[] vos = (BkgUserSmsInputVO[])models.toArray(new BkgUserSmsInputVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkSlanCd = this.chkSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDirCd = this.chkDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsIndCd = this.loclTsIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
