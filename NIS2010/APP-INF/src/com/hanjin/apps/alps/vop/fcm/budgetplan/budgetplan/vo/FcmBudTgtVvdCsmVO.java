/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FcmBudTgtVvdCsmVO.java
*@FileTitle : FcmBudTgtVvdCsmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.28 진마리아 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmBudTgtVvdCsmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmBudTgtVvdCsmVO> models = new ArrayList<FcmBudTgtVvdCsmVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String portDys = null;
	/* Column Info */
	private String mnvrDys = null;
	/* Column Info */
	private String doilSeaCsmWgt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String foilCsmCostAmt = null;
	/* Column Info */
	private String doilPortCsmWgt = null;
	/* Column Info */
	private String doilCsmCostAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String seaDys = null;
	/* Column Info */
	private String foilPortCsmWgt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String foilMnvrCsmWgt = null;
	/* Column Info */
	private String foilUcAmt = null;
	/* Column Info */
	private String doilUcAmt = null;
	/* Column Info */
	private String budTgtVvdSeq = null;
	/* Column Info */
	private String foilSeaCsmWgt = null;
	/* Column Info */
	private String doilMnvrCsmWgt = null;
	/* Column Info */
	private String ttlCsmAmt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmBudTgtVvdCsmVO() {}

	public FcmBudTgtVvdCsmVO(String ibflag, String pagerows, String budTgtVvdSeq, String portDys, String seaDys, String mnvrDys, String foilPortCsmWgt, String foilSeaCsmWgt, String foilMnvrCsmWgt, String foilUcAmt, String foilCsmCostAmt, String doilPortCsmWgt, String doilSeaCsmWgt, String doilMnvrCsmWgt, String doilUcAmt, String doilCsmCostAmt, String ttlCsmAmt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.portDys = portDys;
		this.mnvrDys = mnvrDys;
		this.doilSeaCsmWgt = doilSeaCsmWgt;
		this.creDt = creDt;
		this.foilCsmCostAmt = foilCsmCostAmt;
		this.doilPortCsmWgt = doilPortCsmWgt;
		this.doilCsmCostAmt = doilCsmCostAmt;
		this.pagerows = pagerows;
		this.seaDys = seaDys;
		this.foilPortCsmWgt = foilPortCsmWgt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.foilMnvrCsmWgt = foilMnvrCsmWgt;
		this.foilUcAmt = foilUcAmt;
		this.doilUcAmt = doilUcAmt;
		this.budTgtVvdSeq = budTgtVvdSeq;
		this.foilSeaCsmWgt = foilSeaCsmWgt;
		this.doilMnvrCsmWgt = doilMnvrCsmWgt;
		this.ttlCsmAmt = ttlCsmAmt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("port_dys", getPortDys());
		this.hashColumns.put("mnvr_dys", getMnvrDys());
		this.hashColumns.put("doil_sea_csm_wgt", getDoilSeaCsmWgt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("foil_csm_cost_amt", getFoilCsmCostAmt());
		this.hashColumns.put("doil_port_csm_wgt", getDoilPortCsmWgt());
		this.hashColumns.put("doil_csm_cost_amt", getDoilCsmCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sea_dys", getSeaDys());
		this.hashColumns.put("foil_port_csm_wgt", getFoilPortCsmWgt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("foil_mnvr_csm_wgt", getFoilMnvrCsmWgt());
		this.hashColumns.put("foil_uc_amt", getFoilUcAmt());
		this.hashColumns.put("doil_uc_amt", getDoilUcAmt());
		this.hashColumns.put("bud_tgt_vvd_seq", getBudTgtVvdSeq());
		this.hashColumns.put("foil_sea_csm_wgt", getFoilSeaCsmWgt());
		this.hashColumns.put("doil_mnvr_csm_wgt", getDoilMnvrCsmWgt());
		this.hashColumns.put("ttl_csm_amt", getTtlCsmAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("port_dys", "portDys");
		this.hashFields.put("mnvr_dys", "mnvrDys");
		this.hashFields.put("doil_sea_csm_wgt", "doilSeaCsmWgt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("foil_csm_cost_amt", "foilCsmCostAmt");
		this.hashFields.put("doil_port_csm_wgt", "doilPortCsmWgt");
		this.hashFields.put("doil_csm_cost_amt", "doilCsmCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sea_dys", "seaDys");
		this.hashFields.put("foil_port_csm_wgt", "foilPortCsmWgt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("foil_mnvr_csm_wgt", "foilMnvrCsmWgt");
		this.hashFields.put("foil_uc_amt", "foilUcAmt");
		this.hashFields.put("doil_uc_amt", "doilUcAmt");
		this.hashFields.put("bud_tgt_vvd_seq", "budTgtVvdSeq");
		this.hashFields.put("foil_sea_csm_wgt", "foilSeaCsmWgt");
		this.hashFields.put("doil_mnvr_csm_wgt", "doilMnvrCsmWgt");
		this.hashFields.put("ttl_csm_amt", "ttlCsmAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return portDys
	 */
	public String getPortDys() {
		return this.portDys;
	}
	
	/**
	 * Column Info
	 * @return mnvrDys
	 */
	public String getMnvrDys() {
		return this.mnvrDys;
	}
	
	/**
	 * Column Info
	 * @return doilSeaCsmWgt
	 */
	public String getDoilSeaCsmWgt() {
		return this.doilSeaCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return foilCsmCostAmt
	 */
	public String getFoilCsmCostAmt() {
		return this.foilCsmCostAmt;
	}
	
	/**
	 * Column Info
	 * @return doilPortCsmWgt
	 */
	public String getDoilPortCsmWgt() {
		return this.doilPortCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return doilCsmCostAmt
	 */
	public String getDoilCsmCostAmt() {
		return this.doilCsmCostAmt;
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
	 * @return seaDys
	 */
	public String getSeaDys() {
		return this.seaDys;
	}
	
	/**
	 * Column Info
	 * @return foilPortCsmWgt
	 */
	public String getFoilPortCsmWgt() {
		return this.foilPortCsmWgt;
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
	 * @return foilMnvrCsmWgt
	 */
	public String getFoilMnvrCsmWgt() {
		return this.foilMnvrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return foilUcAmt
	 */
	public String getFoilUcAmt() {
		return this.foilUcAmt;
	}
	
	/**
	 * Column Info
	 * @return doilUcAmt
	 */
	public String getDoilUcAmt() {
		return this.doilUcAmt;
	}
	
	/**
	 * Column Info
	 * @return budTgtVvdSeq
	 */
	public String getBudTgtVvdSeq() {
		return this.budTgtVvdSeq;
	}
	
	/**
	 * Column Info
	 * @return foilSeaCsmWgt
	 */
	public String getFoilSeaCsmWgt() {
		return this.foilSeaCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return doilMnvrCsmWgt
	 */
	public String getDoilMnvrCsmWgt() {
		return this.doilMnvrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return ttlCsmAmt
	 */
	public String getTtlCsmAmt() {
		return this.ttlCsmAmt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param portDys
	 */
	public void setPortDys(String portDys) {
		this.portDys = portDys;
	}
	
	/**
	 * Column Info
	 * @param mnvrDys
	 */
	public void setMnvrDys(String mnvrDys) {
		this.mnvrDys = mnvrDys;
	}
	
	/**
	 * Column Info
	 * @param doilSeaCsmWgt
	 */
	public void setDoilSeaCsmWgt(String doilSeaCsmWgt) {
		this.doilSeaCsmWgt = doilSeaCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param foilCsmCostAmt
	 */
	public void setFoilCsmCostAmt(String foilCsmCostAmt) {
		this.foilCsmCostAmt = foilCsmCostAmt;
	}
	
	/**
	 * Column Info
	 * @param doilPortCsmWgt
	 */
	public void setDoilPortCsmWgt(String doilPortCsmWgt) {
		this.doilPortCsmWgt = doilPortCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param doilCsmCostAmt
	 */
	public void setDoilCsmCostAmt(String doilCsmCostAmt) {
		this.doilCsmCostAmt = doilCsmCostAmt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param seaDys
	 */
	public void setSeaDys(String seaDys) {
		this.seaDys = seaDys;
	}
	
	/**
	 * Column Info
	 * @param foilPortCsmWgt
	 */
	public void setFoilPortCsmWgt(String foilPortCsmWgt) {
		this.foilPortCsmWgt = foilPortCsmWgt;
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
	 * @param foilMnvrCsmWgt
	 */
	public void setFoilMnvrCsmWgt(String foilMnvrCsmWgt) {
		this.foilMnvrCsmWgt = foilMnvrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param foilUcAmt
	 */
	public void setFoilUcAmt(String foilUcAmt) {
		this.foilUcAmt = foilUcAmt;
	}
	
	/**
	 * Column Info
	 * @param doilUcAmt
	 */
	public void setDoilUcAmt(String doilUcAmt) {
		this.doilUcAmt = doilUcAmt;
	}
	
	/**
	 * Column Info
	 * @param budTgtVvdSeq
	 */
	public void setBudTgtVvdSeq(String budTgtVvdSeq) {
		this.budTgtVvdSeq = budTgtVvdSeq;
	}
	
	/**
	 * Column Info
	 * @param foilSeaCsmWgt
	 */
	public void setFoilSeaCsmWgt(String foilSeaCsmWgt) {
		this.foilSeaCsmWgt = foilSeaCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param doilMnvrCsmWgt
	 */
	public void setDoilMnvrCsmWgt(String doilMnvrCsmWgt) {
		this.doilMnvrCsmWgt = doilMnvrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param ttlCsmAmt
	 */
	public void setTtlCsmAmt(String ttlCsmAmt) {
		this.ttlCsmAmt = ttlCsmAmt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPortDys(JSPUtil.getParameter(request, prefix + "port_dys", ""));
		setMnvrDys(JSPUtil.getParameter(request, prefix + "mnvr_dys", ""));
		setDoilSeaCsmWgt(JSPUtil.getParameter(request, prefix + "doil_sea_csm_wgt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFoilCsmCostAmt(JSPUtil.getParameter(request, prefix + "foil_csm_cost_amt", ""));
		setDoilPortCsmWgt(JSPUtil.getParameter(request, prefix + "doil_port_csm_wgt", ""));
		setDoilCsmCostAmt(JSPUtil.getParameter(request, prefix + "doil_csm_cost_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSeaDys(JSPUtil.getParameter(request, prefix + "sea_dys", ""));
		setFoilPortCsmWgt(JSPUtil.getParameter(request, prefix + "foil_port_csm_wgt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFoilMnvrCsmWgt(JSPUtil.getParameter(request, prefix + "foil_mnvr_csm_wgt", ""));
		setFoilUcAmt(JSPUtil.getParameter(request, prefix + "foil_uc_amt", ""));
		setDoilUcAmt(JSPUtil.getParameter(request, prefix + "doil_uc_amt", ""));
		setBudTgtVvdSeq(JSPUtil.getParameter(request, prefix + "bud_tgt_vvd_seq", ""));
		setFoilSeaCsmWgt(JSPUtil.getParameter(request, prefix + "foil_sea_csm_wgt", ""));
		setDoilMnvrCsmWgt(JSPUtil.getParameter(request, prefix + "doil_mnvr_csm_wgt", ""));
		setTtlCsmAmt(JSPUtil.getParameter(request, prefix + "ttl_csm_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmBudTgtVvdCsmVO[]
	 */
	public FcmBudTgtVvdCsmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmBudTgtVvdCsmVO[]
	 */
	public FcmBudTgtVvdCsmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmBudTgtVvdCsmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] portDys = (JSPUtil.getParameter(request, prefix	+ "port_dys", length));
			String[] mnvrDys = (JSPUtil.getParameter(request, prefix	+ "mnvr_dys", length));
			String[] doilSeaCsmWgt = (JSPUtil.getParameter(request, prefix	+ "doil_sea_csm_wgt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] foilCsmCostAmt = (JSPUtil.getParameter(request, prefix	+ "foil_csm_cost_amt", length));
			String[] doilPortCsmWgt = (JSPUtil.getParameter(request, prefix	+ "doil_port_csm_wgt", length));
			String[] doilCsmCostAmt = (JSPUtil.getParameter(request, prefix	+ "doil_csm_cost_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] seaDys = (JSPUtil.getParameter(request, prefix	+ "sea_dys", length));
			String[] foilPortCsmWgt = (JSPUtil.getParameter(request, prefix	+ "foil_port_csm_wgt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] foilMnvrCsmWgt = (JSPUtil.getParameter(request, prefix	+ "foil_mnvr_csm_wgt", length));
			String[] foilUcAmt = (JSPUtil.getParameter(request, prefix	+ "foil_uc_amt", length));
			String[] doilUcAmt = (JSPUtil.getParameter(request, prefix	+ "doil_uc_amt", length));
			String[] budTgtVvdSeq = (JSPUtil.getParameter(request, prefix	+ "bud_tgt_vvd_seq", length));
			String[] foilSeaCsmWgt = (JSPUtil.getParameter(request, prefix	+ "foil_sea_csm_wgt", length));
			String[] doilMnvrCsmWgt = (JSPUtil.getParameter(request, prefix	+ "doil_mnvr_csm_wgt", length));
			String[] ttlCsmAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_csm_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmBudTgtVvdCsmVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (portDys[i] != null)
					model.setPortDys(portDys[i]);
				if (mnvrDys[i] != null)
					model.setMnvrDys(mnvrDys[i]);
				if (doilSeaCsmWgt[i] != null)
					model.setDoilSeaCsmWgt(doilSeaCsmWgt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (foilCsmCostAmt[i] != null)
					model.setFoilCsmCostAmt(foilCsmCostAmt[i]);
				if (doilPortCsmWgt[i] != null)
					model.setDoilPortCsmWgt(doilPortCsmWgt[i]);
				if (doilCsmCostAmt[i] != null)
					model.setDoilCsmCostAmt(doilCsmCostAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (seaDys[i] != null)
					model.setSeaDys(seaDys[i]);
				if (foilPortCsmWgt[i] != null)
					model.setFoilPortCsmWgt(foilPortCsmWgt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (foilMnvrCsmWgt[i] != null)
					model.setFoilMnvrCsmWgt(foilMnvrCsmWgt[i]);
				if (foilUcAmt[i] != null)
					model.setFoilUcAmt(foilUcAmt[i]);
				if (doilUcAmt[i] != null)
					model.setDoilUcAmt(doilUcAmt[i]);
				if (budTgtVvdSeq[i] != null)
					model.setBudTgtVvdSeq(budTgtVvdSeq[i]);
				if (foilSeaCsmWgt[i] != null)
					model.setFoilSeaCsmWgt(foilSeaCsmWgt[i]);
				if (doilMnvrCsmWgt[i] != null)
					model.setDoilMnvrCsmWgt(doilMnvrCsmWgt[i]);
				if (ttlCsmAmt[i] != null)
					model.setTtlCsmAmt(ttlCsmAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmBudTgtVvdCsmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmBudTgtVvdCsmVO[]
	 */
	public FcmBudTgtVvdCsmVO[] getFcmBudTgtVvdCsmVOs(){
		FcmBudTgtVvdCsmVO[] vos = (FcmBudTgtVvdCsmVO[])models.toArray(new FcmBudTgtVvdCsmVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDys = this.portDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrDys = this.mnvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilSeaCsmWgt = this.doilSeaCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilCsmCostAmt = this.foilCsmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilPortCsmWgt = this.doilPortCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilCsmCostAmt = this.doilCsmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDys = this.seaDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilPortCsmWgt = this.foilPortCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilMnvrCsmWgt = this.foilMnvrCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilUcAmt = this.foilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilUcAmt = this.doilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budTgtVvdSeq = this.budTgtVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilSeaCsmWgt = this.foilSeaCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilMnvrCsmWgt = this.doilMnvrCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCsmAmt = this.ttlCsmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
