/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ManualBookingCopyVO.java
*@FileTitle : ManualBookingCopyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : Moon Hwan Choi
*@LastVersion : 1.0
* 2015.03.24 Moon Hwan Choi 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author Moon Hwan Choi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ManualBookingCopyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManualBookingCopyVO> models = new ArrayList<ManualBookingCopyVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnlBkgSts = null;
	/* Column Info */
	private String mnlFlg = null;
	/* Column Info */
	private String mnlBkgNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ManualBookingCopyVO() {}

	public ManualBookingCopyVO(String ibflag, String pagerows, String mnlBkgSts, String mnlBkgNo, String mnlFlg) {
		this.ibflag = ibflag;
		this.mnlBkgSts = mnlBkgSts;
		this.mnlFlg = mnlFlg;
		this.mnlBkgNo = mnlBkgNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnl_bkg_sts", getMnlBkgSts());
		this.hashColumns.put("mnl_flg", getMnlFlg());
		this.hashColumns.put("mnl_bkg_no", getMnlBkgNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnl_bkg_sts", "mnlBkgSts");
		this.hashFields.put("mnl_flg", "mnlFlg");
		this.hashFields.put("mnl_bkg_no", "mnlBkgNo");
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
	 * @return mnlBkgSts
	 */
	public String getMnlBkgSts() {
		return this.mnlBkgSts;
	}
	
	/**
	 * Column Info
	 * @return mnlFlg
	 */
	public String getMnlFlg() {
		return this.mnlFlg;
	}
	
	/**
	 * Column Info
	 * @return mnlBkgNo
	 */
	public String getMnlBkgNo() {
		return this.mnlBkgNo;
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
	 * @param mnlBkgSts
	 */
	public void setMnlBkgSts(String mnlBkgSts) {
		this.mnlBkgSts = mnlBkgSts;
	}
	
	/**
	 * Column Info
	 * @param mnlFlg
	 */
	public void setMnlFlg(String mnlFlg) {
		this.mnlFlg = mnlFlg;
	}
	
	/**
	 * Column Info
	 * @param mnlBkgNo
	 */
	public void setMnlBkgNo(String mnlBkgNo) {
		this.mnlBkgNo = mnlBkgNo;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMnlBkgSts(JSPUtil.getParameter(request, prefix + "mnl_bkg_sts", ""));
		setMnlFlg(JSPUtil.getParameter(request, prefix + "mnl_flg", ""));
		setMnlBkgNo(JSPUtil.getParameter(request, prefix + "mnl_bkg_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManualBookingCopyVO[]
	 */
	public ManualBookingCopyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManualBookingCopyVO[]
	 */
	public ManualBookingCopyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManualBookingCopyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnlBkgSts = (JSPUtil.getParameter(request, prefix	+ "mnl_bkg_sts", length));
			String[] mnlFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_flg", length));
			String[] mnlBkgNo = (JSPUtil.getParameter(request, prefix	+ "mnl_bkg_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManualBookingCopyVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnlBkgSts[i] != null)
					model.setMnlBkgSts(mnlBkgSts[i]);
				if (mnlFlg[i] != null)
					model.setMnlFlg(mnlFlg[i]);
				if (mnlBkgNo[i] != null)
					model.setMnlBkgNo(mnlBkgNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManualBookingCopyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManualBookingCopyVO[]
	 */
	public ManualBookingCopyVO[] getManualBookingCopyVOs(){
		ManualBookingCopyVO[] vos = (ManualBookingCopyVO[])models.toArray(new ManualBookingCopyVO[models.size()]);
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
		this.mnlBkgSts = this.mnlBkgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlg = this.mnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlBkgNo = this.mnlBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
