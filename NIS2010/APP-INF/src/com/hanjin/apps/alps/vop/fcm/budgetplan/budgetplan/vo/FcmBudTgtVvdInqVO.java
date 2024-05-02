/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FcmBudTgtVvdInqVO.java
*@FileTitle : FcmBudTgtVvdInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.28
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo;

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

public class FcmBudTgtVvdInqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmBudTgtVvdInqVO> models = new ArrayList<FcmBudTgtVvdInqVO>();
	
	/* Column Info */
	private String toDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String snDt = null;
	/* Column Info */
	private String snCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmBudTgtVvdInqVO() {}

	public FcmBudTgtVvdInqVO(String ibflag, String pagerows, String fmDt, String toDt, String snDt, String snCd) {
		this.toDt = toDt;
		this.ibflag = ibflag;
		this.fmDt = fmDt;
		this.snDt = snDt;
		this.snCd = snCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("sn_dt", getSnDt());
		this.hashColumns.put("sn_cd", getSnCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("sn_dt", "snDt");
		this.hashFields.put("sn_cd", "snCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return snDt
	 */
	public String getSnDt() {
		return this.snDt;
	}
	
	/**
	 * Column Info
	 * @return snCd
	 */
	public String getSnCd() {
		return this.snCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param snDt
	 */
	public void setSnDt(String snDt) {
		this.snDt = snDt;
	}
	
	/**
	 * Column Info
	 * @param snCd
	 */
	public void setSnCd(String snCd) {
		this.snCd = snCd;
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
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setSnDt(JSPUtil.getParameter(request, prefix + "sn_dt", ""));
		setSnCd(JSPUtil.getParameter(request, prefix + "sn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmBudTgtVvdInqVO[]
	 */
	public FcmBudTgtVvdInqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmBudTgtVvdInqVO[]
	 */
	public FcmBudTgtVvdInqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmBudTgtVvdInqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] snDt = (JSPUtil.getParameter(request, prefix	+ "sn_dt", length));
			String[] snCd = (JSPUtil.getParameter(request, prefix	+ "sn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmBudTgtVvdInqVO();
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (snDt[i] != null)
					model.setSnDt(snDt[i]);
				if (snCd[i] != null)
					model.setSnCd(snCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmBudTgtVvdInqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmBudTgtVvdInqVO[]
	 */
	public FcmBudTgtVvdInqVO[] getFcmBudTgtVvdInqVOs(){
		FcmBudTgtVvdInqVO[] vos = (FcmBudTgtVvdInqVO[])models.toArray(new FcmBudTgtVvdInqVO[models.size()]);
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
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snDt = this.snDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snCd = this.snCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
