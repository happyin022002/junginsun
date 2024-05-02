/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UpdBkgForBkgCodVO.java
*@FileTitle : UpdBkgForBkgCodVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class UpdBkgForBkgCodVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UpdBkgForBkgCodVO> models = new ArrayList<UpdBkgForBkgCodVO>();
	
	/* Column Info */
	private String newDelYdCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldDelYdCd = null;
	/* Column Info */
	private String oldPodYdCd = null;
	/* Column Info */
	private String newPodYdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UpdBkgForBkgCodVO() {}

	public UpdBkgForBkgCodVO(String ibflag, String pagerows, String bkgNo, String oldPodYdCd, String oldDelYdCd, String newPodYdCd, String newDelYdCd) {
		this.newDelYdCd = newDelYdCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.oldDelYdCd = oldDelYdCd;
		this.oldPodYdCd = oldPodYdCd;
		this.newPodYdCd = newPodYdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("new_del_yd_cd", getNewDelYdCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("old_del_yd_cd", getOldDelYdCd());
		this.hashColumns.put("old_pod_yd_cd", getOldPodYdCd());
		this.hashColumns.put("new_pod_yd_cd", getNewPodYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("new_del_yd_cd", "newDelYdCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("old_del_yd_cd", "oldDelYdCd");
		this.hashFields.put("old_pod_yd_cd", "oldPodYdCd");
		this.hashFields.put("new_pod_yd_cd", "newPodYdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return newDelYdCd
	 */
	public String getNewDelYdCd() {
		return this.newDelYdCd;
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
	 * @return oldDelYdCd
	 */
	public String getOldDelYdCd() {
		return this.oldDelYdCd;
	}
	
	/**
	 * Column Info
	 * @return oldPodYdCd
	 */
	public String getOldPodYdCd() {
		return this.oldPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return newPodYdCd
	 */
	public String getNewPodYdCd() {
		return this.newPodYdCd;
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
	 * @param newDelYdCd
	 */
	public void setNewDelYdCd(String newDelYdCd) {
		this.newDelYdCd = newDelYdCd;
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
	 * @param oldDelYdCd
	 */
	public void setOldDelYdCd(String oldDelYdCd) {
		this.oldDelYdCd = oldDelYdCd;
	}
	
	/**
	 * Column Info
	 * @param oldPodYdCd
	 */
	public void setOldPodYdCd(String oldPodYdCd) {
		this.oldPodYdCd = oldPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param newPodYdCd
	 */
	public void setNewPodYdCd(String newPodYdCd) {
		this.newPodYdCd = newPodYdCd;
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
		setNewDelYdCd(JSPUtil.getParameter(request, prefix + "new_del_yd_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOldDelYdCd(JSPUtil.getParameter(request, prefix + "old_del_yd_cd", ""));
		setOldPodYdCd(JSPUtil.getParameter(request, prefix + "old_pod_yd_cd", ""));
		setNewPodYdCd(JSPUtil.getParameter(request, prefix + "new_pod_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UpdBkgForBkgCodVO[]
	 */
	public UpdBkgForBkgCodVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UpdBkgForBkgCodVO[]
	 */
	public UpdBkgForBkgCodVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UpdBkgForBkgCodVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] newDelYdCd = (JSPUtil.getParameter(request, prefix	+ "new_del_yd_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldDelYdCd = (JSPUtil.getParameter(request, prefix	+ "old_del_yd_cd", length));
			String[] oldPodYdCd = (JSPUtil.getParameter(request, prefix	+ "old_pod_yd_cd", length));
			String[] newPodYdCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UpdBkgForBkgCodVO();
				if (newDelYdCd[i] != null)
					model.setNewDelYdCd(newDelYdCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldDelYdCd[i] != null)
					model.setOldDelYdCd(oldDelYdCd[i]);
				if (oldPodYdCd[i] != null)
					model.setOldPodYdCd(oldPodYdCd[i]);
				if (newPodYdCd[i] != null)
					model.setNewPodYdCd(newPodYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUpdBkgForBkgCodVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UpdBkgForBkgCodVO[]
	 */
	public UpdBkgForBkgCodVO[] getUpdBkgForBkgCodVOs(){
		UpdBkgForBkgCodVO[] vos = (UpdBkgForBkgCodVO[])models.toArray(new UpdBkgForBkgCodVO[models.size()]);
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
		this.newDelYdCd = this.newDelYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDelYdCd = this.oldDelYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodYdCd = this.oldPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodYdCd = this.newPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
