/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchDryDockScheduleListVO.java
*@FileTitle : SearchDryDockScheduleListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo;

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

public class SearchDryDockScheduleListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDryDockScheduleListVO> models = new ArrayList<SearchDryDockScheduleListVO>();
	
	/* Column Info */
	private String vslDzndCapa = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String recDckToDt = null;
	/* Column Info */
	private String lastDckLocCd = null;
	/* Column Info */
	private String nextDckFmDt = null;
	/* Column Info */
	private String nextDckLocCd = null;
	/* Column Info */
	private String nextShipYard = null;
	/* Column Info */
	private String nextFletDckSveyTpCd = null;
	/* Column Info */
	private String nextDckToDt = null;
	/* Column Info */
	private String lastFletDckSveyTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String lastDckToDt = null;
	/* Column Info */
	private String recDckFmDt = null;
	/* Column Info */
	private String lastDckFmDt = null;
	/* Column Info */
	private String lastShipYard = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDryDockScheduleListVO() {}

	public SearchDryDockScheduleListVO(String ibflag, String pagerows, String vslCd, String slanCd, String vslDzndCapa, String lastDckFmDt, String lastDckToDt, String lastDckLocCd, String lastShipYard, String lastFletDckSveyTpCd, String nextDckFmDt, String nextDckToDt, String nextDckLocCd, String nextShipYard, String nextFletDckSveyTpCd, String recDckFmDt, String recDckToDt) {
		this.vslDzndCapa = vslDzndCapa;
		this.vslCd = vslCd;
		this.recDckToDt = recDckToDt;
		this.lastDckLocCd = lastDckLocCd;
		this.nextDckFmDt = nextDckFmDt;
		this.nextDckLocCd = nextDckLocCd;
		this.nextShipYard = nextShipYard;
		this.nextFletDckSveyTpCd = nextFletDckSveyTpCd;
		this.nextDckToDt = nextDckToDt;
		this.lastFletDckSveyTpCd = lastFletDckSveyTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.lastDckToDt = lastDckToDt;
		this.recDckFmDt = recDckFmDt;
		this.lastDckFmDt = lastDckFmDt;
		this.lastShipYard = lastShipYard;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_dznd_capa", getVslDzndCapa());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rec_dck_to_dt", getRecDckToDt());
		this.hashColumns.put("last_dck_loc_cd", getLastDckLocCd());
		this.hashColumns.put("next_dck_fm_dt", getNextDckFmDt());
		this.hashColumns.put("next_dck_loc_cd", getNextDckLocCd());
		this.hashColumns.put("next_ship_yard", getNextShipYard());
		this.hashColumns.put("next_flet_dck_svey_tp_cd", getNextFletDckSveyTpCd());
		this.hashColumns.put("next_dck_to_dt", getNextDckToDt());
		this.hashColumns.put("last_flet_dck_svey_tp_cd", getLastFletDckSveyTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("last_dck_to_dt", getLastDckToDt());
		this.hashColumns.put("rec_dck_fm_dt", getRecDckFmDt());
		this.hashColumns.put("last_dck_fm_dt", getLastDckFmDt());
		this.hashColumns.put("last_ship_yard", getLastShipYard());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_dznd_capa", "vslDzndCapa");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rec_dck_to_dt", "recDckToDt");
		this.hashFields.put("last_dck_loc_cd", "lastDckLocCd");
		this.hashFields.put("next_dck_fm_dt", "nextDckFmDt");
		this.hashFields.put("next_dck_loc_cd", "nextDckLocCd");
		this.hashFields.put("next_ship_yard", "nextShipYard");
		this.hashFields.put("next_flet_dck_svey_tp_cd", "nextFletDckSveyTpCd");
		this.hashFields.put("next_dck_to_dt", "nextDckToDt");
		this.hashFields.put("last_flet_dck_svey_tp_cd", "lastFletDckSveyTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("last_dck_to_dt", "lastDckToDt");
		this.hashFields.put("rec_dck_fm_dt", "recDckFmDt");
		this.hashFields.put("last_dck_fm_dt", "lastDckFmDt");
		this.hashFields.put("last_ship_yard", "lastShipYard");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslDzndCapa
	 */
	public String getVslDzndCapa() {
		return this.vslDzndCapa;
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
	 * @return recDckToDt
	 */
	public String getRecDckToDt() {
		return this.recDckToDt;
	}
	
	/**
	 * Column Info
	 * @return lastDckLocCd
	 */
	public String getLastDckLocCd() {
		return this.lastDckLocCd;
	}
	
	/**
	 * Column Info
	 * @return nextDckFmDt
	 */
	public String getNextDckFmDt() {
		return this.nextDckFmDt;
	}
	
	/**
	 * Column Info
	 * @return nextDckLocCd
	 */
	public String getNextDckLocCd() {
		return this.nextDckLocCd;
	}
	
	/**
	 * Column Info
	 * @return nextShipYard
	 */
	public String getNextShipYard() {
		return this.nextShipYard;
	}
	
	/**
	 * Column Info
	 * @return nextFletDckSveyTpCd
	 */
	public String getNextFletDckSveyTpCd() {
		return this.nextFletDckSveyTpCd;
	}
	
	/**
	 * Column Info
	 * @return nextDckToDt
	 */
	public String getNextDckToDt() {
		return this.nextDckToDt;
	}
	
	/**
	 * Column Info
	 * @return lastFletDckSveyTpCd
	 */
	public String getLastFletDckSveyTpCd() {
		return this.lastFletDckSveyTpCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return lastDckToDt
	 */
	public String getLastDckToDt() {
		return this.lastDckToDt;
	}
	
	/**
	 * Column Info
	 * @return recDckFmDt
	 */
	public String getRecDckFmDt() {
		return this.recDckFmDt;
	}
	
	/**
	 * Column Info
	 * @return lastDckFmDt
	 */
	public String getLastDckFmDt() {
		return this.lastDckFmDt;
	}
	
	/**
	 * Column Info
	 * @return lastShipYard
	 */
	public String getLastShipYard() {
		return this.lastShipYard;
	}
	

	/**
	 * Column Info
	 * @param vslDzndCapa
	 */
	public void setVslDzndCapa(String vslDzndCapa) {
		this.vslDzndCapa = vslDzndCapa;
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
	 * @param recDckToDt
	 */
	public void setRecDckToDt(String recDckToDt) {
		this.recDckToDt = recDckToDt;
	}
	
	/**
	 * Column Info
	 * @param lastDckLocCd
	 */
	public void setLastDckLocCd(String lastDckLocCd) {
		this.lastDckLocCd = lastDckLocCd;
	}
	
	/**
	 * Column Info
	 * @param nextDckFmDt
	 */
	public void setNextDckFmDt(String nextDckFmDt) {
		this.nextDckFmDt = nextDckFmDt;
	}
	
	/**
	 * Column Info
	 * @param nextDckLocCd
	 */
	public void setNextDckLocCd(String nextDckLocCd) {
		this.nextDckLocCd = nextDckLocCd;
	}
	
	/**
	 * Column Info
	 * @param nextShipYard
	 */
	public void setNextShipYard(String nextShipYard) {
		this.nextShipYard = nextShipYard;
	}
	
	/**
	 * Column Info
	 * @param nextFletDckSveyTpCd
	 */
	public void setNextFletDckSveyTpCd(String nextFletDckSveyTpCd) {
		this.nextFletDckSveyTpCd = nextFletDckSveyTpCd;
	}
	
	/**
	 * Column Info
	 * @param nextDckToDt
	 */
	public void setNextDckToDt(String nextDckToDt) {
		this.nextDckToDt = nextDckToDt;
	}
	
	/**
	 * Column Info
	 * @param lastFletDckSveyTpCd
	 */
	public void setLastFletDckSveyTpCd(String lastFletDckSveyTpCd) {
		this.lastFletDckSveyTpCd = lastFletDckSveyTpCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param lastDckToDt
	 */
	public void setLastDckToDt(String lastDckToDt) {
		this.lastDckToDt = lastDckToDt;
	}
	
	/**
	 * Column Info
	 * @param recDckFmDt
	 */
	public void setRecDckFmDt(String recDckFmDt) {
		this.recDckFmDt = recDckFmDt;
	}
	
	/**
	 * Column Info
	 * @param lastDckFmDt
	 */
	public void setLastDckFmDt(String lastDckFmDt) {
		this.lastDckFmDt = lastDckFmDt;
	}
	
	/**
	 * Column Info
	 * @param lastShipYard
	 */
	public void setLastShipYard(String lastShipYard) {
		this.lastShipYard = lastShipYard;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslDzndCapa(JSPUtil.getParameter(request, "vsl_dznd_capa", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setRecDckToDt(JSPUtil.getParameter(request, "rec_dck_to_dt", ""));
		setLastDckLocCd(JSPUtil.getParameter(request, "last_dck_loc_cd", ""));
		setNextDckFmDt(JSPUtil.getParameter(request, "next_dck_fm_dt", ""));
		setNextDckLocCd(JSPUtil.getParameter(request, "next_dck_loc_cd", ""));
		setNextShipYard(JSPUtil.getParameter(request, "next_ship_yard", ""));
		setNextFletDckSveyTpCd(JSPUtil.getParameter(request, "next_flet_dck_svey_tp_cd", ""));
		setNextDckToDt(JSPUtil.getParameter(request, "next_dck_to_dt", ""));
		setLastFletDckSveyTpCd(JSPUtil.getParameter(request, "last_flet_dck_svey_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setLastDckToDt(JSPUtil.getParameter(request, "last_dck_to_dt", ""));
		setRecDckFmDt(JSPUtil.getParameter(request, "rec_dck_fm_dt", ""));
		setLastDckFmDt(JSPUtil.getParameter(request, "last_dck_fm_dt", ""));
		setLastShipYard(JSPUtil.getParameter(request, "last_ship_yard", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDryDockScheduleListVO[]
	 */
	public SearchDryDockScheduleListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDryDockScheduleListVO[]
	 */
	public SearchDryDockScheduleListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDryDockScheduleListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslDzndCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_capa", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] recDckToDt = (JSPUtil.getParameter(request, prefix	+ "rec_dck_to_dt", length));
			String[] lastDckLocCd = (JSPUtil.getParameter(request, prefix	+ "last_dck_loc_cd", length));
			String[] nextDckFmDt = (JSPUtil.getParameter(request, prefix	+ "next_dck_fm_dt", length));
			String[] nextDckLocCd = (JSPUtil.getParameter(request, prefix	+ "next_dck_loc_cd", length));
			String[] nextShipYard = (JSPUtil.getParameter(request, prefix	+ "next_ship_yard", length));
			String[] nextFletDckSveyTpCd = (JSPUtil.getParameter(request, prefix	+ "next_flet_dck_svey_tp_cd", length));
			String[] nextDckToDt = (JSPUtil.getParameter(request, prefix	+ "next_dck_to_dt", length));
			String[] lastFletDckSveyTpCd = (JSPUtil.getParameter(request, prefix	+ "last_flet_dck_svey_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] lastDckToDt = (JSPUtil.getParameter(request, prefix	+ "last_dck_to_dt", length));
			String[] recDckFmDt = (JSPUtil.getParameter(request, prefix	+ "rec_dck_fm_dt", length));
			String[] lastDckFmDt = (JSPUtil.getParameter(request, prefix	+ "last_dck_fm_dt", length));
			String[] lastShipYard = (JSPUtil.getParameter(request, prefix	+ "last_ship_yard", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDryDockScheduleListVO();
				if (vslDzndCapa[i] != null)
					model.setVslDzndCapa(vslDzndCapa[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (recDckToDt[i] != null)
					model.setRecDckToDt(recDckToDt[i]);
				if (lastDckLocCd[i] != null)
					model.setLastDckLocCd(lastDckLocCd[i]);
				if (nextDckFmDt[i] != null)
					model.setNextDckFmDt(nextDckFmDt[i]);
				if (nextDckLocCd[i] != null)
					model.setNextDckLocCd(nextDckLocCd[i]);
				if (nextShipYard[i] != null)
					model.setNextShipYard(nextShipYard[i]);
				if (nextFletDckSveyTpCd[i] != null)
					model.setNextFletDckSveyTpCd(nextFletDckSveyTpCd[i]);
				if (nextDckToDt[i] != null)
					model.setNextDckToDt(nextDckToDt[i]);
				if (lastFletDckSveyTpCd[i] != null)
					model.setLastFletDckSveyTpCd(lastFletDckSveyTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (lastDckToDt[i] != null)
					model.setLastDckToDt(lastDckToDt[i]);
				if (recDckFmDt[i] != null)
					model.setRecDckFmDt(recDckFmDt[i]);
				if (lastDckFmDt[i] != null)
					model.setLastDckFmDt(lastDckFmDt[i]);
				if (lastShipYard[i] != null)
					model.setLastShipYard(lastShipYard[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDryDockScheduleListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDryDockScheduleListVO[]
	 */
	public SearchDryDockScheduleListVO[] getSearchDryDockScheduleListVOs(){
		SearchDryDockScheduleListVO[] vos = (SearchDryDockScheduleListVO[])models.toArray(new SearchDryDockScheduleListVO[models.size()]);
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
		this.vslDzndCapa = this.vslDzndCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recDckToDt = this.recDckToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastDckLocCd = this.lastDckLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextDckFmDt = this.nextDckFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextDckLocCd = this.nextDckLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextShipYard = this.nextShipYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextFletDckSveyTpCd = this.nextFletDckSveyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextDckToDt = this.nextDckToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastFletDckSveyTpCd = this.lastFletDckSveyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastDckToDt = this.lastDckToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recDckFmDt = this.recDckFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastDckFmDt = this.lastDckFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastShipYard = this.lastShipYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
