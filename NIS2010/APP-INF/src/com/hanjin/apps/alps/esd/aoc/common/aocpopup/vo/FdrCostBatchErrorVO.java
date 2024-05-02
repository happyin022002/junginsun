/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FdrCostBatchErrorVO.java
*@FileTitle : FdrCostBatchErrorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.31  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.common.aocpopup.vo;

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

public class FdrCostBatchErrorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FdrCostBatchErrorVO> models = new ArrayList<FdrCostBatchErrorVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errDesc = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String costErrCd = null;
	/* Column Info */
	private String pctlIoBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String rhqCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FdrCostBatchErrorVO() {}

	public FdrCostBatchErrorVO(String ibflag, String pagerows, String costTrfNo, String fmNodCd, String toNodCd, String pctlIoBndCd, String dirCd, String costErrCd, String errDesc, String rhqCd) {
		this.toNodCd = toNodCd;
		this.fmNodCd = fmNodCd;
		this.ibflag = ibflag;
		this.errDesc = errDesc;
		this.costTrfNo = costTrfNo;
		this.dirCd = dirCd;
		this.costErrCd = costErrCd;
		this.pctlIoBndCd = pctlIoBndCd;
		this.pagerows = pagerows;
		this.rhqCd = rhqCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_desc", getErrDesc());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("cost_err_cd", getCostErrCd());
		this.hashColumns.put("pctl_io_bnd_cd", getPctlIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rhq_cd", getRhqCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_desc", "errDesc");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("cost_err_cd", "costErrCd");
		this.hashFields.put("pctl_io_bnd_cd", "pctlIoBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rhq_cd", "rhqCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
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
	 * @return errDesc
	 */
	public String getErrDesc() {
		return this.errDesc;
	}
	
	/**
	 * Column Info
	 * @return costTrfNo
	 */
	public String getCostTrfNo() {
		return this.costTrfNo;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return costErrCd
	 */
	public String getCostErrCd() {
		return this.costErrCd;
	}
	
	/**
	 * Column Info
	 * @return pctlIoBndCd
	 */
	public String getPctlIoBndCd() {
		return this.pctlIoBndCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Page Number
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
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
	 * @param errDesc
	 */
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	/**
	 * Column Info
	 * @param costTrfNo
	 */
	public void setCostTrfNo(String costTrfNo) {
		this.costTrfNo = costTrfNo;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param costErrCd
	 */
	public void setCostErrCd(String costErrCd) {
		this.costErrCd = costErrCd;
	}
	
	/**
	 * Column Info
	 * @param pctlIoBndCd
	 */
	public void setPctlIoBndCd(String pctlIoBndCd) {
		this.pctlIoBndCd = pctlIoBndCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setErrDesc(JSPUtil.getParameter(request, prefix + "err_desc", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setCostErrCd(JSPUtil.getParameter(request, prefix + "cost_err_cd", ""));
		setPctlIoBndCd(JSPUtil.getParameter(request, prefix + "pctl_io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FdrCostBatchErrorVO[]
	 */
	public FdrCostBatchErrorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FdrCostBatchErrorVO[]
	 */
	public FdrCostBatchErrorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FdrCostBatchErrorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errDesc = (JSPUtil.getParameter(request, prefix	+ "err_desc", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] costErrCd = (JSPUtil.getParameter(request, prefix	+ "cost_err_cd", length));
			String[] pctlIoBndCd = (JSPUtil.getParameter(request, prefix	+ "pctl_io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FdrCostBatchErrorVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errDesc[i] != null)
					model.setErrDesc(errDesc[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (costErrCd[i] != null)
					model.setCostErrCd(costErrCd[i]);
				if (pctlIoBndCd[i] != null)
					model.setPctlIoBndCd(pctlIoBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pagerows[i] != null)
					model.setRhqCd(rhqCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFdrCostBatchErrorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FdrCostBatchErrorVO[]
	 */
	public FdrCostBatchErrorVO[] getSearchFdrCostBatchErrorVOs(){
		FdrCostBatchErrorVO[] vos = (FdrCostBatchErrorVO[])models.toArray(new FdrCostBatchErrorVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDesc = this.errDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costErrCd = this.costErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlIoBndCd = this.pctlIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
