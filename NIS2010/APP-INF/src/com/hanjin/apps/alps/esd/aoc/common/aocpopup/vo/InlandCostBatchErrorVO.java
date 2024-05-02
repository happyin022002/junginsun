/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostBatchErrorVO.java
*@FileTitle : InlandCostBatchErrorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.30  
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

public class InlandCostBatchErrorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InlandCostBatchErrorVO> models = new ArrayList<InlandCostBatchErrorVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errDesc = null;
	/* Column Info */
	private String portLoc = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String portNodCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String locNodCd = null;
	/* Column Info */
	private String costErrCd = null;
	/* Column Info */
	private String hubNodCd = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String rhqCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InlandCostBatchErrorVO() {}

	public InlandCostBatchErrorVO(String ibflag, String pagerows, String costTrfNo, String portLoc, String rcvDeTermCd, String portNodCd, String hubNodCd, String locNodCd, String trspCrrModCd, String costErrCd, String errDesc, String rhqCd) {
		this.ibflag = ibflag;
		this.errDesc = errDesc;
		this.portLoc = portLoc;
		this.costTrfNo = costTrfNo;
		this.portNodCd = portNodCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.locNodCd = locNodCd;
		this.costErrCd = costErrCd;
		this.hubNodCd = hubNodCd;
		this.trspCrrModCd = trspCrrModCd;
		this.pagerows = pagerows;
		this.rhqCd = rhqCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_desc", getErrDesc());
		this.hashColumns.put("port_loc", getPortLoc());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("port_nod_cd", getPortNodCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("loc_nod_cd", getLocNodCd());
		this.hashColumns.put("cost_err_cd", getCostErrCd());
		this.hashColumns.put("hub_nod_cd", getHubNodCd());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rhq_cd", getRhqCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_desc", "errDesc");
		this.hashFields.put("port_loc", "portLoc");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("port_nod_cd", "portNodCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("loc_nod_cd", "locNodCd");
		this.hashFields.put("cost_err_cd", "costErrCd");
		this.hashFields.put("hub_nod_cd", "hubNodCd");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rhq_cd", "rhqCd");
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
	 * @return errDesc
	 */
	public String getErrDesc() {
		return this.errDesc;
	}
	
	/**
	 * Column Info
	 * @return portLoc
	 */
	public String getPortLoc() {
		return this.portLoc;
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
	 * @return portNodCd
	 */
	public String getPortNodCd() {
		return this.portNodCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return locNodCd
	 */
	public String getLocNodCd() {
		return this.locNodCd;
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
	 * @return hubNodCd
	 */
	public String getHubNodCd() {
		return this.hubNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
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
	 * @param portLoc
	 */
	public void setPortLoc(String portLoc) {
		this.portLoc = portLoc;
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
	 * @param portNodCd
	 */
	public void setPortNodCd(String portNodCd) {
		this.portNodCd = portNodCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param locNodCd
	 */
	public void setLocNodCd(String locNodCd) {
		this.locNodCd = locNodCd;
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
	 * @param hubNodCd
	 */
	public void setHubNodCd(String hubNodCd) {
		this.hubNodCd = hubNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setErrDesc(JSPUtil.getParameter(request, prefix + "err_desc", ""));
		setPortLoc(JSPUtil.getParameter(request, prefix + "port_loc", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setPortNodCd(JSPUtil.getParameter(request, prefix + "port_nod_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setLocNodCd(JSPUtil.getParameter(request, prefix + "loc_nod_cd", ""));
		setCostErrCd(JSPUtil.getParameter(request, prefix + "cost_err_cd", ""));
		setHubNodCd(JSPUtil.getParameter(request, prefix + "hub_nod_cd", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InlandCostBatchErrorVO[]
	 */
	public InlandCostBatchErrorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InlandCostBatchErrorVO[]
	 */
	public InlandCostBatchErrorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InlandCostBatchErrorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errDesc = (JSPUtil.getParameter(request, prefix	+ "err_desc", length));
			String[] portLoc = (JSPUtil.getParameter(request, prefix	+ "port_loc", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] portNodCd = (JSPUtil.getParameter(request, prefix	+ "port_nod_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] locNodCd = (JSPUtil.getParameter(request, prefix	+ "loc_nod_cd", length));
			String[] costErrCd = (JSPUtil.getParameter(request, prefix	+ "cost_err_cd", length));
			String[] hubNodCd = (JSPUtil.getParameter(request, prefix	+ "hub_nod_cd", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InlandCostBatchErrorVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errDesc[i] != null)
					model.setErrDesc(errDesc[i]);
				if (portLoc[i] != null)
					model.setPortLoc(portLoc[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (portNodCd[i] != null)
					model.setPortNodCd(portNodCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (locNodCd[i] != null)
					model.setLocNodCd(locNodCd[i]);
				if (costErrCd[i] != null)
					model.setCostErrCd(costErrCd[i]);
				if (hubNodCd[i] != null)
					model.setHubNodCd(hubNodCd[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pagerows[i] != null)
					model.setRhqCd(rhqCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInlandCostBatchErrorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InlandCostBatchErrorVO[]
	 */
	public InlandCostBatchErrorVO[] getSearchInlandCostBatchErrorVOs(){
		InlandCostBatchErrorVO[] vos = (InlandCostBatchErrorVO[])models.toArray(new InlandCostBatchErrorVO[models.size()]);
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
		this.errDesc = this.errDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLoc = this.portLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNodCd = this.portNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNodCd = this.locNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costErrCd = this.costErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubNodCd = this.hubNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
