/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CoveredBlListVO.java
*@FileTitle : CoveredBlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.01.29 이진서 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CoveredBlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CoveredBlListVO> models = new ArrayList<CoveredBlListVO>();
	
	/* Column Info */
	private String mstCvrdBlNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blCvrdTpCd = null;
	/* Column Info */
	private String oldBlNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CoveredBlListVO() {}

	public CoveredBlListVO(String ibflag, String pagerows, String mstCvrdBlNo, String bkgNo, String blCvrdTpCd, String oldBlNo, String blNo, String userId) {
		this.mstCvrdBlNo = mstCvrdBlNo;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.blCvrdTpCd = blCvrdTpCd;
		this.oldBlNo = oldBlNo;
		this.userId = userId;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mst_cvrd_bl_no", getMstCvrdBlNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_cvrd_tp_cd", getBlCvrdTpCd());
		this.hashColumns.put("old_bl_no", getOldBlNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mst_cvrd_bl_no", "mstCvrdBlNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_cvrd_tp_cd", "blCvrdTpCd");
		this.hashFields.put("old_bl_no", "oldBlNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mstCvrdBlNo
	 */
	public String getMstCvrdBlNo() {
		return this.mstCvrdBlNo;
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
	 * @return blCvrdTpCd
	 */
	public String getBlCvrdTpCd() {
		return this.blCvrdTpCd;
	}
	
	/**
	 * Column Info
	 * @return oldBlNo
	 */
	public String getOldBlNo() {
		return this.oldBlNo;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @param mstCvrdBlNo
	 */
	public void setMstCvrdBlNo(String mstCvrdBlNo) {
		this.mstCvrdBlNo = mstCvrdBlNo;
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
	 * @param blCvrdTpCd
	 */
	public void setBlCvrdTpCd(String blCvrdTpCd) {
		this.blCvrdTpCd = blCvrdTpCd;
	}
	
	/**
	 * Column Info
	 * @param oldBlNo
	 */
	public void setOldBlNo(String oldBlNo) {
		this.oldBlNo = oldBlNo;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
		setMstCvrdBlNo(JSPUtil.getParameter(request, "mst_cvrd_bl_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBlCvrdTpCd(JSPUtil.getParameter(request, "bl_cvrd_tp_cd", ""));
		setOldBlNo(JSPUtil.getParameter(request, "old_bl_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CoveredBlListVO[]
	 */
	public CoveredBlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CoveredBlListVO[]
	 */
	public CoveredBlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CoveredBlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mstCvrdBlNo = (JSPUtil.getParameter(request, prefix	+ "mst_cvrd_bl_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blCvrdTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_cvrd_tp_cd", length));
			String[] oldBlNo = (JSPUtil.getParameter(request, prefix	+ "old_bl_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CoveredBlListVO();
				if (mstCvrdBlNo[i] != null)
					model.setMstCvrdBlNo(mstCvrdBlNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blCvrdTpCd[i] != null)
					model.setBlCvrdTpCd(blCvrdTpCd[i]);
				if (oldBlNo[i] != null)
					model.setOldBlNo(oldBlNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCoveredBlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CoveredBlListVO[]
	 */
	public CoveredBlListVO[] getCoveredBlListVOs(){
		CoveredBlListVO[] vos = (CoveredBlListVO[])models.toArray(new CoveredBlListVO[models.size()]);
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
		this.mstCvrdBlNo = this.mstCvrdBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCvrdTpCd = this.blCvrdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldBlNo = this.oldBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
