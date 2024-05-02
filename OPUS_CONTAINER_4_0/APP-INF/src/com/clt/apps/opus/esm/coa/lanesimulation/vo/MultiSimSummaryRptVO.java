/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MultiSimSummaryRptVO.java
*@FileTitle : MultiSimSummaryRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.11 윤진영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.lanesimulation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MultiSimSummaryRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MultiSimSummaryRptVO> models = new ArrayList<MultiSimSummaryRptVO>();
	
	/* Column Info */
	private String ldfRto = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bnkCostAmt = null;
	/* Column Info */
	private String simRmk = null;
	/* Column Info */
	private String simRptNo = null;
	/* Column Info */
	private String grsRpbRev = null;
	/* Column Info */
	private String simDt = null;
	/* Column Info */
	private String sectNo = null;
	/* Column Info */
	private String simNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MultiSimSummaryRptVO() {}

	public MultiSimSummaryRptVO(String ibflag, String pagerows, String ldfRto, String grsRpbRev, String simDt, String simNo, String sectNo, String simRptNo, String bnkCostAmt, String simRmk, String creUsrId, String updUsrId) {
		this.ldfRto = ldfRto;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.bnkCostAmt = bnkCostAmt;
		this.simRmk = simRmk;
		this.simRptNo = simRptNo;
		this.grsRpbRev = grsRpbRev;
		this.simDt = simDt;
		this.sectNo = sectNo;
		this.simNo = simNo;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ldf_rto", getLdfRto());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bnk_cost_amt", getBnkCostAmt());
		this.hashColumns.put("sim_rmk", getSimRmk());
		this.hashColumns.put("sim_rpt_no", getSimRptNo());
		this.hashColumns.put("grs_rpb_rev", getGrsRpbRev());
		this.hashColumns.put("sim_dt", getSimDt());
		this.hashColumns.put("sect_no", getSectNo());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ldf_rto", "ldfRto");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bnk_cost_amt", "bnkCostAmt");
		this.hashFields.put("sim_rmk", "simRmk");
		this.hashFields.put("sim_rpt_no", "simRptNo");
		this.hashFields.put("grs_rpb_rev", "grsRpbRev");
		this.hashFields.put("sim_dt", "simDt");
		this.hashFields.put("sect_no", "sectNo");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ldfRto
	 */
	public String getLdfRto() {
		return this.ldfRto;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return bnkCostAmt
	 */
	public String getBnkCostAmt() {
		return this.bnkCostAmt;
	}
	
	/**
	 * Column Info
	 * @return simRmk
	 */
	public String getSimRmk() {
		return this.simRmk;
	}
	
	/**
	 * Column Info
	 * @return simRptNo
	 */
	public String getSimRptNo() {
		return this.simRptNo;
	}
	
	/**
	 * Column Info
	 * @return grsRpbRev
	 */
	public String getGrsRpbRev() {
		return this.grsRpbRev;
	}
	
	/**
	 * Column Info
	 * @return simDt
	 */
	public String getSimDt() {
		return this.simDt;
	}
	
	/**
	 * Column Info
	 * @return sectNo
	 */
	public String getSectNo() {
		return this.sectNo;
	}
	
	/**
	 * Column Info
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param ldfRto
	 */
	public void setLdfRto(String ldfRto) {
		this.ldfRto = ldfRto;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param bnkCostAmt
	 */
	public void setBnkCostAmt(String bnkCostAmt) {
		this.bnkCostAmt = bnkCostAmt;
	}
	
	/**
	 * Column Info
	 * @param simRmk
	 */
	public void setSimRmk(String simRmk) {
		this.simRmk = simRmk;
	}
	
	/**
	 * Column Info
	 * @param simRptNo
	 */
	public void setSimRptNo(String simRptNo) {
		this.simRptNo = simRptNo;
	}
	
	/**
	 * Column Info
	 * @param grsRpbRev
	 */
	public void setGrsRpbRev(String grsRpbRev) {
		this.grsRpbRev = grsRpbRev;
	}
	
	/**
	 * Column Info
	 * @param simDt
	 */
	public void setSimDt(String simDt) {
		this.simDt = simDt;
	}
	
	/**
	 * Column Info
	 * @param sectNo
	 */
	public void setSectNo(String sectNo) {
		this.sectNo = sectNo;
	}
	
	/**
	 * Column Info
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setLdfRto(JSPUtil.getParameter(request, "ldf_rto", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBnkCostAmt(JSPUtil.getParameter(request, "bnk_cost_amt", ""));
		setSimRmk(JSPUtil.getParameter(request, "sim_rmk", ""));
		setSimRptNo(JSPUtil.getParameter(request, "sim_rpt_no", ""));
		setGrsRpbRev(JSPUtil.getParameter(request, "grs_rpb_rev", ""));
		setSimDt(JSPUtil.getParameter(request, "sim_dt", ""));
		setSectNo(JSPUtil.getParameter(request, "sect_no", ""));
		setSimNo(JSPUtil.getParameter(request, "sim_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MultiSimSummaryRptVO[]
	 */
	public MultiSimSummaryRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MultiSimSummaryRptVO[]
	 */
	public MultiSimSummaryRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MultiSimSummaryRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "sim_dt");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "sim_dt").length;
  
		try {
			String[] ldfRto = (JSPUtil.getParameter(request, prefix	+ "ldf_rto", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bnkCostAmt = (JSPUtil.getParameter(request, prefix	+ "bnk_cost_amt", length));
			String[] simRmk = (JSPUtil.getParameter(request, prefix	+ "sim_rmk", length));
			String[] simRptNo = (JSPUtil.getParameter(request, prefix	+ "sim_rpt_no", length));
			String[] grsRpbRev = (JSPUtil.getParameter(request, prefix	+ "grs_rpb_rev", length));
			String[] simDt = (JSPUtil.getParameter(request, prefix	+ "sim_dt", length));
			String[] sectNo = (JSPUtil.getParameter(request, prefix	+ "sect_no", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MultiSimSummaryRptVO();
				if (ldfRto[i] != null)
					model.setLdfRto(ldfRto[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bnkCostAmt[i] != null)
					model.setBnkCostAmt(bnkCostAmt[i]);
				if (simRmk[i] != null)
					model.setSimRmk(simRmk[i]);
				if (simRptNo[i] != null)
					model.setSimRptNo(simRptNo[i]);
				if (grsRpbRev[i] != null)
					model.setGrsRpbRev(grsRpbRev[i]);
				if (simDt[i] != null)
					model.setSimDt(simDt[i]);
				if (sectNo[i] != null)
					model.setSectNo(sectNo[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMultiSimSummaryRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MultiSimSummaryRptVO[]
	 */
	public MultiSimSummaryRptVO[] getMultiSimSummaryRptVOs(){
		MultiSimSummaryRptVO[] vos = (MultiSimSummaryRptVO[])models.toArray(new MultiSimSummaryRptVO[models.size()]);
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
		this.ldfRto = this.ldfRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkCostAmt = this.bnkCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simRmk = this.simRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simRptNo = this.simRptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRpbRev = this.grsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDt = this.simDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sectNo = this.sectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
