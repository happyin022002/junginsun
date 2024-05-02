/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CurCaUsrVO.java
*@FileTitle : CurCaUsrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.14 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CurCaUsrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CurCaUsrVO> models = new ArrayList<CurCaUsrVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String corrDt = null;
	/* Column Info */
	private String corrUsrId = null;
	/* Column Info */
	private String corrOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CurCaUsrVO() {}

	public CurCaUsrVO(String ibflag, String pagerows, String corrUsrId, String corrOfcCd, String corrDt) {
		this.ibflag = ibflag;
		this.corrDt = corrDt;
		this.corrUsrId = corrUsrId;
		this.corrOfcCd = corrOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("corr_dt", getCorrDt());
		this.hashColumns.put("corr_usr_id", getCorrUsrId());
		this.hashColumns.put("corr_ofc_cd", getCorrOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("corr_dt", "corrDt");
		this.hashFields.put("corr_usr_id", "corrUsrId");
		this.hashFields.put("corr_ofc_cd", "corrOfcCd");
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
	 * @return corrDt
	 */
	public String getCorrDt() {
		return this.corrDt;
	}
	
	/**
	 * Column Info
	 * @return corrUsrId
	 */
	public String getCorrUsrId() {
		return this.corrUsrId;
	}
	
	/**
	 * Column Info
	 * @return corrOfcCd
	 */
	public String getCorrOfcCd() {
		return this.corrOfcCd;
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
	 * @param corrDt
	 */
	public void setCorrDt(String corrDt) {
		this.corrDt = corrDt;
	}
	
	/**
	 * Column Info
	 * @param corrUsrId
	 */
	public void setCorrUsrId(String corrUsrId) {
		this.corrUsrId = corrUsrId;
	}
	
	/**
	 * Column Info
	 * @param corrOfcCd
	 */
	public void setCorrOfcCd(String corrOfcCd) {
		this.corrOfcCd = corrOfcCd;
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
		setCorrDt(JSPUtil.getParameter(request, "corr_dt", ""));
		setCorrUsrId(JSPUtil.getParameter(request, "corr_usr_id", ""));
		setCorrOfcCd(JSPUtil.getParameter(request, "corr_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CurCaUsrVO[]
	 */
	public CurCaUsrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CurCaUsrVO[]
	 */
	public CurCaUsrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CurCaUsrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] corrDt = (JSPUtil.getParameter(request, prefix	+ "corr_dt", length));
			String[] corrUsrId = (JSPUtil.getParameter(request, prefix	+ "corr_usr_id", length));
			String[] corrOfcCd = (JSPUtil.getParameter(request, prefix	+ "corr_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CurCaUsrVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (corrDt[i] != null)
					model.setCorrDt(corrDt[i]);
				if (corrUsrId[i] != null)
					model.setCorrUsrId(corrUsrId[i]);
				if (corrOfcCd[i] != null)
					model.setCorrOfcCd(corrOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCurCaUsrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CurCaUsrVO[]
	 */
	public CurCaUsrVO[] getCurCaUsrVOs(){
		CurCaUsrVO[] vos = (CurCaUsrVO[])models.toArray(new CurCaUsrVO[models.size()]);
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
		this.corrDt = this.corrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrUsrId = this.corrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrOfcCd = this.corrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
