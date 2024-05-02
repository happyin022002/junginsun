/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchHubConstraintListVO.java
*@FileTitle : SearchHubConstraintListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo;

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

public class SearchHubConstraintListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchHubConstraintListVO> models = new ArrayList<SearchHubConstraintListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String hubLocCnstRmk = null;
	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cnstLaneCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String spclCgoCntrTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String svcUseFlg = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hubLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchHubConstraintListVO() {}

	public SearchHubConstraintListVO(String ibflag, String pagerows, String portCd, String hubLocCd, String nodCd, String ioBndCd, String cnstLaneCd, String spclCgoCntrTpCd, String svcUseFlg, String hubLocCnstRmk, String creOfcCd, String creUsrId, String creDt, String updUsrId, String updDt, String dirCd, String cntrTpCd, String cntrSzCd) {
		this.updDt = updDt;
		this.hubLocCnstRmk = hubLocCnstRmk;
		this.cntrSzCd = cntrSzCd;
		this.creDt = creDt;
		this.cnstLaneCd = cnstLaneCd;
		this.ioBndCd = ioBndCd;
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cntrTpCd = cntrTpCd;
		this.creOfcCd = creOfcCd;
		this.svcUseFlg = svcUseFlg;
		this.nodCd = nodCd;
		this.dirCd = dirCd;
		this.portCd = portCd;
		this.updUsrId = updUsrId;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("hub_loc_cnst_rmk", getHubLocCnstRmk());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cnst_lane_cd", getCnstLaneCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("spcl_cgo_cntr_tp_cd", getSpclCgoCntrTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("svc_use_flg", getSvcUseFlg());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("hub_loc_cnst_rmk", "hubLocCnstRmk");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cnst_lane_cd", "cnstLaneCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("spcl_cgo_cntr_tp_cd", "spclCgoCntrTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("svc_use_flg", "svcUseFlg");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
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
	 * @return hubLocCnstRmk
	 */
	public String getHubLocCnstRmk() {
		return this.hubLocCnstRmk;
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
	 * @return cnstLaneCd
	 */
	public String getCnstLaneCd() {
		return this.cnstLaneCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return spclCgoCntrTpCd
	 */
	public String getSpclCgoCntrTpCd() {
		return this.spclCgoCntrTpCd;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return svcUseFlg
	 */
	public String getSvcUseFlg() {
		return this.svcUseFlg;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
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
	 * @param hubLocCnstRmk
	 */
	public void setHubLocCnstRmk(String hubLocCnstRmk) {
		this.hubLocCnstRmk = hubLocCnstRmk;
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
	 * @param cnstLaneCd
	 */
	public void setCnstLaneCd(String cnstLaneCd) {
		this.cnstLaneCd = cnstLaneCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param spclCgoCntrTpCd
	 */
	public void setSpclCgoCntrTpCd(String spclCgoCntrTpCd) {
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param svcUseFlg
	 */
	public void setSvcUseFlg(String svcUseFlg) {
		this.svcUseFlg = svcUseFlg;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
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
		setHubLocCnstRmk(JSPUtil.getParameter(request, prefix + "hub_loc_cnst_rmk", ""));
		setCntrSzCd(JSPUtil.getParameter(request, prefix + "cntr_sz_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCnstLaneCd(JSPUtil.getParameter(request, prefix + "cnst_lane_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setSpclCgoCntrTpCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cntr_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrTpCd(JSPUtil.getParameter(request, prefix + "cntr_tp_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setSvcUseFlg(JSPUtil.getParameter(request, prefix + "svc_use_flg", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchHubConstraintListVO[]
	 */
	public SearchHubConstraintListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchHubConstraintListVO[]
	 */
	public SearchHubConstraintListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchHubConstraintListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] hubLocCnstRmk = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cnst_rmk", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cnstLaneCd = (JSPUtil.getParameter(request, prefix	+ "cnst_lane_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] spclCgoCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cntr_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] svcUseFlg = (JSPUtil.getParameter(request, prefix	+ "svc_use_flg", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchHubConstraintListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (hubLocCnstRmk[i] != null)
					model.setHubLocCnstRmk(hubLocCnstRmk[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cnstLaneCd[i] != null)
					model.setCnstLaneCd(cnstLaneCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (spclCgoCntrTpCd[i] != null)
					model.setSpclCgoCntrTpCd(spclCgoCntrTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (svcUseFlg[i] != null)
					model.setSvcUseFlg(svcUseFlg[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchHubConstraintListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchHubConstraintListVO[]
	 */
	public SearchHubConstraintListVO[] getSearchHubConstraintListVOs(){
		SearchHubConstraintListVO[] vos = (SearchHubConstraintListVO[])models.toArray(new SearchHubConstraintListVO[models.size()]);
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
		this.hubLocCnstRmk = this.hubLocCnstRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnstLaneCd = this.cnstLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCntrTpCd = this.spclCgoCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcUseFlg = this.svcUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
