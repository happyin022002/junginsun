/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpaceAllocationModelRun0054ListVO.java
*@FileTitle : SearchSpaceAllocationModelRun0054ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2009.11.18 서관영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

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
 * @author 서관영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceAllocationModelRun0054ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceAllocationModelRun0054ListVO> models = new ArrayList<SearchSpaceAllocationModelRun0054ListVO>();
	
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String verNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String endDt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String exeDt = null;
	/* Column Info */
	private String stDt = null;
	/* Column Info */
	private String stsNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceAllocationModelRun0054ListVO() {}

	public SearchSpaceAllocationModelRun0054ListVO(String ibflag, String pagerows, String verNo, String stsCd, String stsNm, String usrId, String exeDt, String stDt, String endDt) {
		this.stsCd = stsCd;
		this.verNo = verNo;
		this.ibflag = ibflag;
		this.endDt = endDt;
		this.usrId = usrId;
		this.exeDt = exeDt;
		this.stDt = stDt;
		this.stsNm = stsNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("ver_no", getVerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("exe_dt", getExeDt());
		this.hashColumns.put("st_dt", getStDt());
		this.hashColumns.put("sts_nm", getStsNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("ver_no", "verNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("exe_dt", "exeDt");
		this.hashFields.put("st_dt", "stDt");
		this.hashFields.put("sts_nm", "stsNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 * Column Info
	 * @return verNo
	 */
	public String getVerNo() {
		return this.verNo;
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
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return exeDt
	 */
	public String getExeDt() {
		return this.exeDt;
	}
	
	/**
	 * Column Info
	 * @return stDt
	 */
	public String getStDt() {
		return this.stDt;
	}
	
	/**
	 * Column Info
	 * @return stsNm
	 */
	public String getStsNm() {
		return this.stsNm;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * Column Info
	 * @param verNo
	 */
	public void setVerNo(String verNo) {
		this.verNo = verNo;
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
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param exeDt
	 */
	public void setExeDt(String exeDt) {
		this.exeDt = exeDt;
	}
	
	/**
	 * Column Info
	 * @param stDt
	 */
	public void setStDt(String stDt) {
		this.stDt = stDt;
	}
	
	/**
	 * Column Info
	 * @param stsNm
	 */
	public void setStsNm(String stsNm) {
		this.stsNm = stsNm;
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
		setStsCd(JSPUtil.getParameter(request, "sts_cd", ""));
		setVerNo(JSPUtil.getParameter(request, "ver_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEndDt(JSPUtil.getParameter(request, "end_dt", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setExeDt(JSPUtil.getParameter(request, "exe_dt", ""));
		setStDt(JSPUtil.getParameter(request, "st_dt", ""));
		setStsNm(JSPUtil.getParameter(request, "sts_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceAllocationModelRun0054ListVO[]
	 */
	public SearchSpaceAllocationModelRun0054ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceAllocationModelRun0054ListVO[]
	 */
	public SearchSpaceAllocationModelRun0054ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceAllocationModelRun0054ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] verNo = (JSPUtil.getParameter(request, prefix	+ "ver_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] exeDt = (JSPUtil.getParameter(request, prefix	+ "exe_dt", length));
			String[] stDt = (JSPUtil.getParameter(request, prefix	+ "st_dt", length));
			String[] stsNm = (JSPUtil.getParameter(request, prefix	+ "sts_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceAllocationModelRun0054ListVO();
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (verNo[i] != null)
					model.setVerNo(verNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (exeDt[i] != null)
					model.setExeDt(exeDt[i]);
				if (stDt[i] != null)
					model.setStDt(stDt[i]);
				if (stsNm[i] != null)
					model.setStsNm(stsNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceAllocationModelRun0054ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceAllocationModelRun0054ListVO[]
	 */
	public SearchSpaceAllocationModelRun0054ListVO[] getSearchSpaceAllocationModelRun0054ListVOs(){
		SearchSpaceAllocationModelRun0054ListVO[] vos = (SearchSpaceAllocationModelRun0054ListVO[])models.toArray(new SearchSpaceAllocationModelRun0054ListVO[models.size()]);
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
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verNo = this.verNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeDt = this.exeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stDt = this.stDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsNm = this.stsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
