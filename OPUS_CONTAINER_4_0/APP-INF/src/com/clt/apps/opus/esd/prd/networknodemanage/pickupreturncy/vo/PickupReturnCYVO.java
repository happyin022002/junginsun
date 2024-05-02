/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PickupReturnCYVO.java
*@FileTitle : PickupReturnCYVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PickupReturnCYVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PickupReturnCYVO> models = new ArrayList<PickupReturnCYVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String porDelCd = null;
	/* Column Info */
	private String mtyPkupRtnYdCd = null;
	/* Column Info */
	private String polPodCd = null;
	/* Column Info */
	private String spclCgoCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PickupReturnCYVO() {}

	public PickupReturnCYVO(String ibflag, String pagerows, String porDelCd, String polPodCd, String vslSlanCd, String ioBndCd, String spclCgoCd, String mtyPkupRtnYdCd, String cntrTpCd, String cntrSzCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.cntrSzCd = cntrSzCd;
		this.creDt = creDt;
		this.vslSlanCd = vslSlanCd;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cntrTpCd = cntrTpCd;
		this.porDelCd = porDelCd;
		this.mtyPkupRtnYdCd = mtyPkupRtnYdCd;
		this.polPodCd = polPodCd;
		this.spclCgoCd = spclCgoCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("por_del_cd", getPorDelCd());
		this.hashColumns.put("mty_pkup_rtn_yd_cd", getMtyPkupRtnYdCd());
		this.hashColumns.put("pol_pod_cd", getPolPodCd());
		this.hashColumns.put("spcl_cgo_cd", getSpclCgoCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("por_del_cd", "porDelCd");
		this.hashFields.put("mty_pkup_rtn_yd_cd", "mtyPkupRtnYdCd");
		this.hashFields.put("pol_pod_cd", "polPodCd");
		this.hashFields.put("spcl_cgo_cd", "spclCgoCd");
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrSzCd
	 */
	public String getCntrSzCd() {
		return this.cntrSzCd;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return this.cntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return porDelCd
	 */
	public String getPorDelCd() {
		return this.porDelCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupRtnYdCd
	 */
	public String getMtyPkupRtnYdCd() {
		return this.mtyPkupRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return polPodCd
	 */
	public String getPolPodCd() {
		return this.polPodCd;
	}
	
	/**
	 * Column Info
	 * @return spclCgoCd
	 */
	public String getSpclCgoCd() {
		return this.spclCgoCd;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrSzCd
	 */
	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param porDelCd
	 */
	public void setPorDelCd(String porDelCd) {
		this.porDelCd = porDelCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupRtnYdCd
	 */
	public void setMtyPkupRtnYdCd(String mtyPkupRtnYdCd) {
		this.mtyPkupRtnYdCd = mtyPkupRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param polPodCd
	 */
	public void setPolPodCd(String polPodCd) {
		this.polPodCd = polPodCd;
	}
	
	/**
	 * Column Info
	 * @param spclCgoCd
	 */
	public void setSpclCgoCd(String spclCgoCd) {
		this.spclCgoCd = spclCgoCd;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCntrSzCd(JSPUtil.getParameter(request, prefix + "cntr_sz_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrTpCd(JSPUtil.getParameter(request, prefix + "cntr_tp_cd", ""));
		setPorDelCd(JSPUtil.getParameter(request, prefix + "por_del_cd", ""));
		setMtyPkupRtnYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_rtn_yd_cd", ""));
		setPolPodCd(JSPUtil.getParameter(request, prefix + "pol_pod_cd", ""));
		setSpclCgoCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PickupReturnCYVO[]
	 */
	public PickupReturnCYVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PickupReturnCYVO[]
	 */
	public PickupReturnCYVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PickupReturnCYVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd", length));
			String[] porDelCd = (JSPUtil.getParameter(request, prefix	+ "por_del_cd", length));
			String[] mtyPkupRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_rtn_yd_cd", length));
			String[] polPodCd = (JSPUtil.getParameter(request, prefix	+ "pol_pod_cd", length));
			String[] spclCgoCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new PickupReturnCYVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (porDelCd[i] != null)
					model.setPorDelCd(porDelCd[i]);
				if (mtyPkupRtnYdCd[i] != null)
					model.setMtyPkupRtnYdCd(mtyPkupRtnYdCd[i]);
				if (polPodCd[i] != null)
					model.setPolPodCd(polPodCd[i]);
				if (spclCgoCd[i] != null)
					model.setSpclCgoCd(spclCgoCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPickupReturnCYVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PickupReturnCYVO[]
	 */
	public PickupReturnCYVO[] getPickupReturnCYVOs(){
		PickupReturnCYVO[] vos = (PickupReturnCYVO[])models.toArray(new PickupReturnCYVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDelCd = this.porDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupRtnYdCd = this.mtyPkupRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPodCd = this.polPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCd = this.spclCgoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
