/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ResultRemarkVO.java
*@FileTitle : ResultRemarkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.08.27 정진우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ResultRemarkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ResultRemarkVO> models = new ArrayList<ResultRemarkVO>();
	
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ieFlg = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String condition = null;
	/* Column Info */
	private String rsnCd = null;
	/* Column Info */
	private String delayTm = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String arrDep = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String portSkpTpCd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String reasonPort = null;
	/* Column Info */
	private String tabFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String grpFlg = null;
	/* Column Info */
	private String laneGrpNm = null;
	/* Column Info */
	private String igFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ResultRemarkVO() {}

	public ResultRemarkVO(String ibflag, String pagerows, String vvd, String vpsPortCd, String reasonPort, String arrDep, String rsnCd, String delayTm, String rmk, String fmDt, String toDt, String igFlg, String vslSlanCd, String vslCd, String crrCd, String tabFlg, String grpFlg, String condition, String usrId, String laneGrpNm, String ieFlg, String portSkpTpCd) {
		this.rmk = rmk;
		this.vslCd = vslCd;
		this.ieFlg = ieFlg;
		this.fmDt = fmDt;
		this.condition = condition;
		this.rsnCd = rsnCd;
		this.delayTm = delayTm;
		this.vslSlanCd = vslSlanCd;
		this.arrDep = arrDep;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.toDt = toDt;
		this.portSkpTpCd = portSkpTpCd;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.reasonPort = reasonPort;
		this.tabFlg = tabFlg;
		this.usrId = usrId;
		this.grpFlg = grpFlg;
		this.laneGrpNm = laneGrpNm;
		this.igFlg = igFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ie_flg", getIeFlg());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("condition", getCondition());
		this.hashColumns.put("rsn_cd", getRsnCd());
		this.hashColumns.put("delay_tm", getDelayTm());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("arr_dep", getArrDep());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("port_skp_tp_cd", getPortSkpTpCd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("reason_port", getReasonPort());
		this.hashColumns.put("tab_flg", getTabFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("grp_flg", getGrpFlg());
		this.hashColumns.put("lane_grp_nm", getLaneGrpNm());
		this.hashColumns.put("ig_flg", getIgFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ie_flg", "ieFlg");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("condition", "condition");
		this.hashFields.put("rsn_cd", "rsnCd");
		this.hashFields.put("delay_tm", "delayTm");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("arr_dep", "arrDep");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("port_skp_tp_cd", "portSkpTpCd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("reason_port", "reasonPort");
		this.hashFields.put("tab_flg", "tabFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("grp_flg", "grpFlg");
		this.hashFields.put("lane_grp_nm", "laneGrpNm");
		this.hashFields.put("ig_flg", "igFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return ieFlg
	 */
	public String getIeFlg() {
		return this.ieFlg;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return condition
	 */
	public String getCondition() {
		return this.condition;
	}
	
	/**
	 * Column Info
	 * @return rsnCd
	 */
	public String getRsnCd() {
		return this.rsnCd;
	}
	
	/**
	 * Column Info
	 * @return delayTm
	 */
	public String getDelayTm() {
		return this.delayTm;
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
	 * @return arrDep
	 */
	public String getArrDep() {
		return this.arrDep;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return portSkpTpCd
	 */
	public String getPortSkpTpCd() {
		return this.portSkpTpCd;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return reasonPort
	 */
	public String getReasonPort() {
		return this.reasonPort;
	}
	
	/**
	 * Column Info
	 * @return tabFlg
	 */
	public String getTabFlg() {
		return this.tabFlg;
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
	 * @return grpFlg
	 */
	public String getGrpFlg() {
		return this.grpFlg;
	}
	
	/**
	 * Column Info
	 * @return laneGrpNm
	 */
	public String getLaneGrpNm() {
		return this.laneGrpNm;
	}
	
	/**
	 * Column Info
	 * @return igFlg
	 */
	public String getIgFlg() {
		return this.igFlg;
	}
	

	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param ieFlg
	 */
	public void setIeFlg(String ieFlg) {
		this.ieFlg = ieFlg;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	/**
	 * Column Info
	 * @param rsnCd
	 */
	public void setRsnCd(String rsnCd) {
		this.rsnCd = rsnCd;
	}
	
	/**
	 * Column Info
	 * @param delayTm
	 */
	public void setDelayTm(String delayTm) {
		this.delayTm = delayTm;
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
	 * @param arrDep
	 */
	public void setArrDep(String arrDep) {
		this.arrDep = arrDep;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param portSkpTpCd
	 */
	public void setPortSkpTpCd(String portSkpTpCd) {
		this.portSkpTpCd = portSkpTpCd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param reasonPort
	 */
	public void setReasonPort(String reasonPort) {
		this.reasonPort = reasonPort;
	}
	
	/**
	 * Column Info
	 * @param tabFlg
	 */
	public void setTabFlg(String tabFlg) {
		this.tabFlg = tabFlg;
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
	 * @param grpFlg
	 */
	public void setGrpFlg(String grpFlg) {
		this.grpFlg = grpFlg;
	}
	
	/**
	 * Column Info
	 * @param laneGrpNm
	 */
	public void setLaneGrpNm(String laneGrpNm) {
		this.laneGrpNm = laneGrpNm;
	}
	
	/**
	 * Column Info
	 * @param igFlg
	 */
	public void setIgFlg(String igFlg) {
		this.igFlg = igFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRmk(JSPUtil.getParameter(request, "rmk", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIeFlg(JSPUtil.getParameter(request, "ie_flg", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setCondition(JSPUtil.getParameter(request, "condition", ""));
		setRsnCd(JSPUtil.getParameter(request, "rsn_cd", ""));
		setDelayTm(JSPUtil.getParameter(request, "delay_tm", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setArrDep(JSPUtil.getParameter(request, "arr_dep", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setPortSkpTpCd(JSPUtil.getParameter(request, "port_skp_tp_cd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setReasonPort(JSPUtil.getParameter(request, "reason_port", ""));
		setTabFlg(JSPUtil.getParameter(request, "tab_flg", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setGrpFlg(JSPUtil.getParameter(request, "grp_flg", ""));
		setLaneGrpNm(JSPUtil.getParameter(request, "lane_grp_nm", ""));
		setIgFlg(JSPUtil.getParameter(request, "ig_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ResultRemarkVO[]
	 */
	public ResultRemarkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ResultRemarkVO[]
	 */
	public ResultRemarkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ResultRemarkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ieFlg = (JSPUtil.getParameter(request, prefix	+ "ie_flg", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] condition = (JSPUtil.getParameter(request, prefix	+ "condition", length));
			String[] rsnCd = (JSPUtil.getParameter(request, prefix	+ "rsn_cd", length));
			String[] delayTm = (JSPUtil.getParameter(request, prefix	+ "delay_tm", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] arrDep = (JSPUtil.getParameter(request, prefix	+ "arr_dep", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] portSkpTpCd = (JSPUtil.getParameter(request, prefix	+ "port_skp_tp_cd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] reasonPort = (JSPUtil.getParameter(request, prefix	+ "reason_port", length));
			String[] tabFlg = (JSPUtil.getParameter(request, prefix	+ "tab_flg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] grpFlg = (JSPUtil.getParameter(request, prefix	+ "grp_flg", length));
			String[] laneGrpNm = (JSPUtil.getParameter(request, prefix	+ "lane_grp_nm", length));
			String[] igFlg = (JSPUtil.getParameter(request, prefix	+ "ig_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ResultRemarkVO();
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ieFlg[i] != null)
					model.setIeFlg(ieFlg[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (condition[i] != null)
					model.setCondition(condition[i]);
				if (rsnCd[i] != null)
					model.setRsnCd(rsnCd[i]);
				if (delayTm[i] != null)
					model.setDelayTm(delayTm[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (arrDep[i] != null)
					model.setArrDep(arrDep[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (portSkpTpCd[i] != null)
					model.setPortSkpTpCd(portSkpTpCd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (reasonPort[i] != null)
					model.setReasonPort(reasonPort[i]);
				if (tabFlg[i] != null)
					model.setTabFlg(tabFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (grpFlg[i] != null)
					model.setGrpFlg(grpFlg[i]);
				if (laneGrpNm[i] != null)
					model.setLaneGrpNm(laneGrpNm[i]);
				if (igFlg[i] != null)
					model.setIgFlg(igFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getResultRemarkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ResultRemarkVO[]
	 */
	public ResultRemarkVO[] getResultRemarkVOs(){
		ResultRemarkVO[] vos = (ResultRemarkVO[])models.toArray(new ResultRemarkVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ieFlg = this.ieFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condition = this.condition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnCd = this.rsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delayTm = this.delayTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDep = this.arrDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpTpCd = this.portSkpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reasonPort = this.reasonPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabFlg = this.tabFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpFlg = this.grpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrpNm = this.laneGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.igFlg = this.igFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
