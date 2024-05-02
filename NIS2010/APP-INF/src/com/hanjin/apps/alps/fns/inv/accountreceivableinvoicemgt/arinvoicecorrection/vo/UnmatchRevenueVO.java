/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchRevenueVO.java
*@FileTitle : UnmatchRevenueVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.08 최우석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UnmatchRevenueVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UnmatchRevenueVO> models = new ArrayList<UnmatchRevenueVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String newLane = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldVvd = null;
	/* Column Info */
	private String newVvd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UnmatchRevenueVO() {}

	public UnmatchRevenueVO(String ibflag, String pagerows, String blNo, String newVvd, String newLane, String oldVvd, String creUsrId, String updUsrId) {
		this.creUsrId = creUsrId;
		this.newLane = newLane;
		this.ibflag = ibflag;
		this.oldVvd = oldVvd;
		this.newVvd = newVvd;
		this.blNo = blNo;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("new_lane", getNewLane());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("old_vvd", getOldVvd());
		this.hashColumns.put("new_vvd", getNewVvd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("new_lane", "newLane");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("old_vvd", "oldVvd");
		this.hashFields.put("new_vvd", "newVvd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return newLane
	 */
	public String getNewLane() {
		return this.newLane;
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
	 * @return oldVvd
	 */
	public String getOldVvd() {
		return this.oldVvd;
	}
	
	/**
	 * Column Info
	 * @return newVvd
	 */
	public String getNewVvd() {
		return this.newVvd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param newLane
	 */
	public void setNewLane(String newLane) {
		this.newLane = newLane;
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
	 * @param oldVvd
	 */
	public void setOldVvd(String oldVvd) {
		this.oldVvd = oldVvd;
	}
	
	/**
	 * Column Info
	 * @param newVvd
	 */
	public void setNewVvd(String newVvd) {
		this.newVvd = newVvd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setNewLane(JSPUtil.getParameter(request, "new_lane", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOldVvd(JSPUtil.getParameter(request, "old_vvd", ""));
		setNewVvd(JSPUtil.getParameter(request, "new_vvd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UnmatchRevenueVO[]
	 */
	public UnmatchRevenueVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UnmatchRevenueVO[]
	 */
	public UnmatchRevenueVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UnmatchRevenueVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] newLane = (JSPUtil.getParameter(request, prefix	+ "new_lane", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldVvd = (JSPUtil.getParameter(request, prefix	+ "old_vvd", length));
			String[] newVvd = (JSPUtil.getParameter(request, prefix	+ "new_vvd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UnmatchRevenueVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (newLane[i] != null)
					model.setNewLane(newLane[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldVvd[i] != null)
					model.setOldVvd(oldVvd[i]);
				if (newVvd[i] != null)
					model.setNewVvd(newVvd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUnmatchRevenueVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UnmatchRevenueVO[]
	 */
	public UnmatchRevenueVO[] getUnmatchRevenueVOs(){
		UnmatchRevenueVO[] vos = (UnmatchRevenueVO[])models.toArray(new UnmatchRevenueVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newLane = this.newLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldVvd = this.oldVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVvd = this.newVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
