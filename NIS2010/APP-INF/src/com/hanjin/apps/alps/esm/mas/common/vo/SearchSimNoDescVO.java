/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSimNoDescVO.java
*@FileTitle : SearchSimNoDescVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2010.03.23 김기식 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.common.vo;

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
 * @author 김기식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimNoDescVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimNoDescVO> models = new ArrayList<SearchSimNoDescVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String simUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String simRmk = null;
	/* Column Info */
	private String simDeptCd = null;
	/* Column Info */
	private String simDt = null;
	/* Column Info */
	private String simNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimNoDescVO() {}

	public SearchSimNoDescVO(String ibflag, String pagerows, String slanCd, String simDeptCd, String simDt, String simNo, String simUsrId, String simRmk) {
		this.ibflag = ibflag;
		this.simUsrId = simUsrId;
		this.slanCd = slanCd;
		this.simRmk = simRmk;
		this.simDeptCd = simDeptCd;
		this.simDt = simDt;
		this.simNo = simNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sim_usr_id", getSimUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("sim_rmk", getSimRmk());
		this.hashColumns.put("sim_dept_cd", getSimDeptCd());
		this.hashColumns.put("sim_dt", getSimDt());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sim_usr_id", "simUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("sim_rmk", "simRmk");
		this.hashFields.put("sim_dept_cd", "simDeptCd");
		this.hashFields.put("sim_dt", "simDt");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return simUsrId
	 */
	public String getSimUsrId() {
		return this.simUsrId;
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
	 * @return simRmk
	 */
	public String getSimRmk() {
		return this.simRmk;
	}
	
	/**
	 * Column Info
	 * @return simDeptCd
	 */
	public String getSimDeptCd() {
		return this.simDeptCd;
	}
	
	/**
	 * Column Info
	 * @return simDt
	 */
	public String getSimDt() {
		return this.simDt;
	}
	
	/**
	 * Column Info
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param simUsrId
	 */
	public void setSimUsrId(String simUsrId) {
		this.simUsrId = simUsrId;
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
	 * @param simRmk
	 */
	public void setSimRmk(String simRmk) {
		this.simRmk = simRmk;
	}
	
	/**
	 * Column Info
	 * @param simDeptCd
	 */
	public void setSimDeptCd(String simDeptCd) {
		this.simDeptCd = simDeptCd;
	}
	
	/**
	 * Column Info
	 * @param simDt
	 */
	public void setSimDt(String simDt) {
		this.simDt = simDt;
	}
	
	/**
	 * Column Info
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSimUsrId(JSPUtil.getParameter(request, "sim_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setSimRmk(JSPUtil.getParameter(request, "sim_rmk", ""));
		setSimDeptCd(JSPUtil.getParameter(request, "sim_dept_cd", ""));
		setSimDt(JSPUtil.getParameter(request, "sim_dt", ""));
		setSimNo(JSPUtil.getParameter(request, "sim_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSimNoDescVO[]
	 */
	public SearchSimNoDescVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSimNoDescVO[]
	 */
	public SearchSimNoDescVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimNoDescVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] simUsrId = (JSPUtil.getParameter(request, prefix	+ "sim_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] simRmk = (JSPUtil.getParameter(request, prefix	+ "sim_rmk", length));
			String[] simDeptCd = (JSPUtil.getParameter(request, prefix	+ "sim_dept_cd", length));
			String[] simDt = (JSPUtil.getParameter(request, prefix	+ "sim_dt", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimNoDescVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (simUsrId[i] != null)
					model.setSimUsrId(simUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (simRmk[i] != null)
					model.setSimRmk(simRmk[i]);
				if (simDeptCd[i] != null)
					model.setSimDeptCd(simDeptCd[i]);
				if (simDt[i] != null)
					model.setSimDt(simDt[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSimNoDescVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSimNoDescVO[]
	 */
	public SearchSimNoDescVO[] getSearchSimNoDescVOs(){
		SearchSimNoDescVO[] vos = (SearchSimNoDescVO[])models.toArray(new SearchSimNoDescVO[models.size()]);
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
		this.simUsrId = this.simUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simRmk = this.simRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDeptCd = this.simDeptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDt = this.simDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
