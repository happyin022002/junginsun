/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RhqOfcCodeVO.java
*@FileTitle : RhqOfcCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.05.13 황효근 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RhqOfcCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RhqOfcCodeVO> models = new ArrayList<RhqOfcCodeVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String shdRhqCd = null;
	/* Column Info */
	private String clkStopNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String otsFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RhqOfcCodeVO() {}

	public RhqOfcCodeVO(String ibflag, String pagerows, String clkStopNo, String shdRhqCd, String otsFlg) {
		this.ibflag = ibflag;
		this.shdRhqCd = shdRhqCd;
		this.clkStopNo = clkStopNo;
		this.pagerows = pagerows;
		this.otsFlg = otsFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("shd_rhq_cd", getShdRhqCd());
		this.hashColumns.put("clk_stop_no", getClkStopNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ots_flg", getOtsFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shd_rhq_cd", "shdRhqCd");
		this.hashFields.put("clk_stop_no", "clkStopNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ots_flg", "otsFlg");
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
	 * @return shdRhqCd
	 */
	public String getShdRhqCd() {
		return this.shdRhqCd;
	}
	
	/**
	 * Column Info
	 * @return clkStopNo
	 */
	public String getClkStopNo() {
		return this.clkStopNo;
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
	 * @param shdRhqCd
	 */
	public void setShdRhqCd(String shdRhqCd) {
		this.shdRhqCd = shdRhqCd;
	}
	
	/**
	 * Column Info
	 * @param clkStopNo
	 */
	public void setClkStopNo(String clkStopNo) {
		this.clkStopNo = clkStopNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	

	public String getOtsFlg() {
		return otsFlg;
	}

	public void setOtsFlg(String otsFlg) {
		this.otsFlg = otsFlg;
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
		setShdRhqCd(JSPUtil.getParameter(request, prefix + "shd_rhq_cd", ""));
		setClkStopNo(JSPUtil.getParameter(request, prefix + "clk_stop_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOtsFlg(JSPUtil.getParameter(request, prefix + "ots_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RhqOfcCodeVO[]
	 */
	public RhqOfcCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RhqOfcCodeVO[]
	 */
	public RhqOfcCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RhqOfcCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] shdRhqCd = (JSPUtil.getParameter(request, prefix	+ "shd_rhq_cd", length));
			String[] clkStopNo = (JSPUtil.getParameter(request, prefix	+ "clk_stop_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] otsFlg = (JSPUtil.getParameter(request, prefix	+ "ots_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new RhqOfcCodeVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (shdRhqCd[i] != null)
					model.setShdRhqCd(shdRhqCd[i]);
				if (clkStopNo[i] != null)
					model.setClkStopNo(clkStopNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (otsFlg[i] != null)
					model.setOtsFlg(otsFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRhqOfcCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RhqOfcCodeVO[]
	 */
	public RhqOfcCodeVO[] getRhqOfcCodeVOs(){
		RhqOfcCodeVO[] vos = (RhqOfcCodeVO[])models.toArray(new RhqOfcCodeVO[models.size()]);
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
		this.shdRhqCd = this.shdRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopNo = this.clkStopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsFlg = this.otsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
