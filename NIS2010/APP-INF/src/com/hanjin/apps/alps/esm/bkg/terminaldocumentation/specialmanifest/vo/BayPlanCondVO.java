/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BayPlanCondVO.java
*@FileTitle : BayPlanCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.09
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.09.09 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BayPlanCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BayPlanCondVO> models = new ArrayList<BayPlanCondVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cellPsnNo = null;
	/* Column Info */
	private String bayPlnId = null;
	/* Column Info */
	private String eurDgCntrId = null;
	/* Column Info */
	private String cntrOprId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BayPlanCondVO() {}

	public BayPlanCondVO(String ibflag, String pagerows, String cellPsnNo, String eurDgCntrId, String bayPlnId, String cntrOprId) {
		this.ibflag = ibflag;
		this.cellPsnNo = cellPsnNo;
		this.bayPlnId = bayPlnId;
		this.eurDgCntrId = eurDgCntrId;
		this.cntrOprId = cntrOprId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cell_psn_no", getCellPsnNo());
		this.hashColumns.put("bay_pln_id", getBayPlnId());
		this.hashColumns.put("eur_dg_cntr_id", getEurDgCntrId());
		this.hashColumns.put("cntr_opr_id", getCntrOprId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cell_psn_no", "cellPsnNo");
		this.hashFields.put("bay_pln_id", "bayPlnId");
		this.hashFields.put("eur_dg_cntr_id", "eurDgCntrId");
		this.hashFields.put("cntr_opr_id", "cntrOprId");
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
	 * @return cellPsnNo
	 */
	public String getCellPsnNo() {
		return this.cellPsnNo;
	}
	
	/**
	 * Column Info
	 * @return bayPlnId
	 */
	public String getBayPlnId() {
		return this.bayPlnId;
	}
	
	/**
	 * Column Info
	 * @return eurDgCntrId
	 */
	public String getEurDgCntrId() {
		return this.eurDgCntrId;
	}
	
	/**
	 * Column Info
	 * @return cntrOprId
	 */
	public String getCntrOprId() {
		return this.cntrOprId;
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
	 * @param cellPsnNo
	 */
	public void setCellPsnNo(String cellPsnNo) {
		this.cellPsnNo = cellPsnNo;
	}
	
	/**
	 * Column Info
	 * @param bayPlnId
	 */
	public void setBayPlnId(String bayPlnId) {
		this.bayPlnId = bayPlnId;
	}
	
	/**
	 * Column Info
	 * @param eurDgCntrId
	 */
	public void setEurDgCntrId(String eurDgCntrId) {
		this.eurDgCntrId = eurDgCntrId;
	}
	
	/**
	 * Column Info
	 * @param cntrOprId
	 */
	public void setCntrOprId(String cntrOprId) {
		this.cntrOprId = cntrOprId;
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
		setCellPsnNo(JSPUtil.getParameter(request, prefix + "cell_psn_no", ""));
		setBayPlnId(JSPUtil.getParameter(request, prefix + "bay_pln_id", ""));
		setEurDgCntrId(JSPUtil.getParameter(request, prefix + "eur_dg_cntr_id", ""));
		setCntrOprId(JSPUtil.getParameter(request, prefix + "cntr_opr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BayPlanCondVO[]
	 */
	public BayPlanCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BayPlanCondVO[]
	 */
	public BayPlanCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BayPlanCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cellPsnNo = (JSPUtil.getParameter(request, prefix	+ "cell_psn_no", length));
			String[] bayPlnId = (JSPUtil.getParameter(request, prefix	+ "bay_pln_id", length));
			String[] eurDgCntrId = (JSPUtil.getParameter(request, prefix	+ "eur_dg_cntr_id", length));
			String[] cntrOprId = (JSPUtil.getParameter(request, prefix	+ "cntr_opr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BayPlanCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cellPsnNo[i] != null)
					model.setCellPsnNo(cellPsnNo[i]);
				if (bayPlnId[i] != null)
					model.setBayPlnId(bayPlnId[i]);
				if (eurDgCntrId[i] != null)
					model.setEurDgCntrId(eurDgCntrId[i]);
				if (cntrOprId[i] != null)
					model.setCntrOprId(cntrOprId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBayPlanCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BayPlanCondVO[]
	 */
	public BayPlanCondVO[] getBayPlanCondVOs(){
		BayPlanCondVO[] vos = (BayPlanCondVO[])models.toArray(new BayPlanCondVO[models.size()]);
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
		this.cellPsnNo = this.cellPsnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayPlnId = this.bayPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurDgCntrId = this.eurDgCntrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOprId = this.cntrOprId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
