/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurFeederMgtCondVO.java
*@FileTitle : EurFeederMgtCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo;

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

public class EurFeederMgtCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurFeederMgtCondVO> models = new ArrayList<EurFeederMgtCondVO>();
	
	/* Column Info */
	private String inToNodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inOfcCd = null;
	/* Column Info */
	private String inCostTrfNo = null;
	/* Column Info */
	private String inRhqCd = null;
	/* Column Info */
	private String inFromNodCd = null;
	/* Column Info */
	private String inBtnSts = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurFeederMgtCondVO() {}

	public EurFeederMgtCondVO(String ibflag, String pagerows, String inCostTrfNo, String inOfcCd, String inBtnSts, String inFromNodCd, String inToNodCd, String inRhqCd) {
		this.inToNodCd = inToNodCd;
		this.ibflag = ibflag;
		this.inOfcCd = inOfcCd;
		this.inCostTrfNo = inCostTrfNo;
		this.inRhqCd = inRhqCd;
		this.inFromNodCd = inFromNodCd;
		this.inBtnSts = inBtnSts;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_to_nod_cd", getInToNodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_ofc_cd", getInOfcCd());
		this.hashColumns.put("in_cost_trf_no", getInCostTrfNo());
		this.hashColumns.put("in_rhq_cd", getInRhqCd());
		this.hashColumns.put("in_from_nod_cd", getInFromNodCd());
		this.hashColumns.put("in_btn_sts", getInBtnSts());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_to_nod_cd", "inToNodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_ofc_cd", "inOfcCd");
		this.hashFields.put("in_cost_trf_no", "inCostTrfNo");
		this.hashFields.put("in_rhq_cd", "inRhqCd");
		this.hashFields.put("in_from_nod_cd", "inFromNodCd");
		this.hashFields.put("in_btn_sts", "inBtnSts");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inToNodCd
	 */
	public String getInToNodCd() {
		return this.inToNodCd;
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
	 * @return inOfcCd
	 */
	public String getInOfcCd() {
		return this.inOfcCd;
	}
	
	/**
	 * Column Info
	 * @return inCostTrfNo
	 */
	public String getInCostTrfNo() {
		return this.inCostTrfNo;
	}
	
	/**
	 * Column Info
	 * @return inRhqCd
	 */
	public String getInRhqCd() {
		return this.inRhqCd;
	}
	
	/**
	 * Column Info
	 * @return inFromNodCd
	 */
	public String getInFromNodCd() {
		return this.inFromNodCd;
	}
	
	/**
	 * Column Info
	 * @return inBtnSts
	 */
	public String getInBtnSts() {
		return this.inBtnSts;
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
	 * @param inToNodCd
	 */
	public void setInToNodCd(String inToNodCd) {
		this.inToNodCd = inToNodCd;
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
	 * @param inOfcCd
	 */
	public void setInOfcCd(String inOfcCd) {
		this.inOfcCd = inOfcCd;
	}
	
	/**
	 * Column Info
	 * @param inCostTrfNo
	 */
	public void setInCostTrfNo(String inCostTrfNo) {
		this.inCostTrfNo = inCostTrfNo;
	}
	
	/**
	 * Column Info
	 * @param inRhqCd
	 */
	public void setInRhqCd(String inRhqCd) {
		this.inRhqCd = inRhqCd;
	}
	
	/**
	 * Column Info
	 * @param inFromNodCd
	 */
	public void setInFromNodCd(String inFromNodCd) {
		this.inFromNodCd = inFromNodCd;
	}
	
	/**
	 * Column Info
	 * @param inBtnSts
	 */
	public void setInBtnSts(String inBtnSts) {
		this.inBtnSts = inBtnSts;
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
		setInToNodCd(JSPUtil.getParameter(request, prefix + "in_to_nod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInOfcCd(JSPUtil.getParameter(request, prefix + "in_ofc_cd", ""));
		setInCostTrfNo(JSPUtil.getParameter(request, prefix + "in_cost_trf_no", ""));
		setInRhqCd(JSPUtil.getParameter(request, prefix + "in_rhq_cd", ""));
		setInFromNodCd(JSPUtil.getParameter(request, prefix + "in_from_nod_cd", ""));
		setInBtnSts(JSPUtil.getParameter(request, prefix + "in_btn_sts", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurFeederMgtCondVO[]
	 */
	public EurFeederMgtCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurFeederMgtCondVO[]
	 */
	public EurFeederMgtCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurFeederMgtCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inToNodCd = (JSPUtil.getParameter(request, prefix	+ "in_to_nod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inOfcCd = (JSPUtil.getParameter(request, prefix	+ "in_ofc_cd", length));
			String[] inCostTrfNo = (JSPUtil.getParameter(request, prefix	+ "in_cost_trf_no", length));
			String[] inRhqCd = (JSPUtil.getParameter(request, prefix	+ "in_rhq_cd", length));
			String[] inFromNodCd = (JSPUtil.getParameter(request, prefix	+ "in_from_nod_cd", length));
			String[] inBtnSts = (JSPUtil.getParameter(request, prefix	+ "in_btn_sts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurFeederMgtCondVO();
				if (inToNodCd[i] != null)
					model.setInToNodCd(inToNodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inOfcCd[i] != null)
					model.setInOfcCd(inOfcCd[i]);
				if (inCostTrfNo[i] != null)
					model.setInCostTrfNo(inCostTrfNo[i]);
				if (inRhqCd[i] != null)
					model.setInRhqCd(inRhqCd[i]);
				if (inFromNodCd[i] != null)
					model.setInFromNodCd(inFromNodCd[i]);
				if (inBtnSts[i] != null)
					model.setInBtnSts(inBtnSts[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurFeederMgtCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurFeederMgtCondVO[]
	 */
	public EurFeederMgtCondVO[] getEurFeederMgtCondVOs(){
		EurFeederMgtCondVO[] vos = (EurFeederMgtCondVO[])models.toArray(new EurFeederMgtCondVO[models.size()]);
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
		this.inToNodCd = this.inToNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOfcCd = this.inOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCostTrfNo = this.inCostTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inRhqCd = this.inRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inFromNodCd = this.inFromNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBtnSts = this.inBtnSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
