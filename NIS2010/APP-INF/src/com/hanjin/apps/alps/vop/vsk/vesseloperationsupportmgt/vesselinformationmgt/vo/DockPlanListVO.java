/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DockPlanListVO.java
*@FileTitle : DockPlanListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.08 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DockPlanListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DockPlanListVO> models = new ArrayList<DockPlanListVO>();
	
	/* Column Info */
	private String scontiNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String dckTgtSkd = null;
	/* Column Info */
	private String dckDurDys = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String phsOutPortCd = null;
	/* Column Info */
	private String fletDckSveyTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String phsOutDt = null;
	/* Column Info */
	private String fletDckStsCd = null;
	/* Column Info */
	private String dckSelCd = null;
	/* Column Info */
	private String dckFmDt = null;
	/* Column Info */
	private String dckToDt = null;
	/* Column Info */
	private String dckLocCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dckSeq = null;
	/* Column Info */
	private String phsInDt = null;
	/* Column Info */
	private String phsInPortCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DockPlanListVO() {}

	public DockPlanListVO(String ibflag, String pagerows, String vslCd, String dckSelCd, String dckSeq, String dckFmDt, String dckToDt, String dckDurDys, String phsOutDt, String phsOutPortCd, String phsInDt, String phsInPortCd, String dckLocCd, String creUsrId, String creDt, String updUsrId, String updDt, String scontiNm, String dckTgtSkd, String fletDckSveyTpCd, String fletDckStsCd) {
		this.scontiNm = scontiNm;
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.dckTgtSkd = dckTgtSkd;
		this.dckDurDys = dckDurDys;
		this.creDt = creDt;
		this.phsOutPortCd = phsOutPortCd;
		this.fletDckSveyTpCd = fletDckSveyTpCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.phsOutDt = phsOutDt;
		this.fletDckStsCd = fletDckStsCd;
		this.dckSelCd = dckSelCd;
		this.dckFmDt = dckFmDt;
		this.dckToDt = dckToDt;
		this.dckLocCd = dckLocCd;
		this.updUsrId = updUsrId;
		this.dckSeq = dckSeq;
		this.phsInDt = phsInDt;
		this.phsInPortCd = phsInPortCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dck_tgt_skd", getDckTgtSkd());
		this.hashColumns.put("dck_dur_dys", getDckDurDys());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("phs_out_port_cd", getPhsOutPortCd());
		this.hashColumns.put("flet_dck_svey_tp_cd", getFletDckSveyTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("phs_out_dt", getPhsOutDt());
		this.hashColumns.put("flet_dck_sts_cd", getFletDckStsCd());
		this.hashColumns.put("dck_sel_cd", getDckSelCd());
		this.hashColumns.put("dck_fm_dt", getDckFmDt());
		this.hashColumns.put("dck_to_dt", getDckToDt());
		this.hashColumns.put("dck_loc_cd", getDckLocCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dck_seq", getDckSeq());
		this.hashColumns.put("phs_in_dt", getPhsInDt());
		this.hashColumns.put("phs_in_port_cd", getPhsInPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dck_tgt_skd", "dckTgtSkd");
		this.hashFields.put("dck_dur_dys", "dckDurDys");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("phs_out_port_cd", "phsOutPortCd");
		this.hashFields.put("flet_dck_svey_tp_cd", "fletDckSveyTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("phs_out_dt", "phsOutDt");
		this.hashFields.put("flet_dck_sts_cd", "fletDckStsCd");
		this.hashFields.put("dck_sel_cd", "dckSelCd");
		this.hashFields.put("dck_fm_dt", "dckFmDt");
		this.hashFields.put("dck_to_dt", "dckToDt");
		this.hashFields.put("dck_loc_cd", "dckLocCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dck_seq", "dckSeq");
		this.hashFields.put("phs_in_dt", "phsInDt");
		this.hashFields.put("phs_in_port_cd", "phsInPortCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scontiNm
	 */
	public String getScontiNm() {
		return this.scontiNm;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return dckTgtSkd
	 */
	public String getDckTgtSkd() {
		return this.dckTgtSkd;
	}
	
	/**
	 * Column Info
	 * @return dckDurDys
	 */
	public String getDckDurDys() {
		return this.dckDurDys;
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
	 * @return phsOutPortCd
	 */
	public String getPhsOutPortCd() {
		return this.phsOutPortCd;
	}
	
	/**
	 * Column Info
	 * @return fletDckSveyTpCd
	 */
	public String getFletDckSveyTpCd() {
		return this.fletDckSveyTpCd;
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
	 * @return phsOutDt
	 */
	public String getPhsOutDt() {
		return this.phsOutDt;
	}
	
	/**
	 * Column Info
	 * @return fletDckStsCd
	 */
	public String getFletDckStsCd() {
		return this.fletDckStsCd;
	}
	
	/**
	 * Column Info
	 * @return dckSelCd
	 */
	public String getDckSelCd() {
		return this.dckSelCd;
	}
	
	/**
	 * Column Info
	 * @return dckFmDt
	 */
	public String getDckFmDt() {
		return this.dckFmDt;
	}
	
	/**
	 * Column Info
	 * @return dckToDt
	 */
	public String getDckToDt() {
		return this.dckToDt;
	}
	
	/**
	 * Column Info
	 * @return dckLocCd
	 */
	public String getDckLocCd() {
		return this.dckLocCd;
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
	 * @return dckSeq
	 */
	public String getDckSeq() {
		return this.dckSeq;
	}
	
	/**
	 * Column Info
	 * @return phsInDt
	 */
	public String getPhsInDt() {
		return this.phsInDt;
	}
	
	/**
	 * Column Info
	 * @return phsInPortCd
	 */
	public String getPhsInPortCd() {
		return this.phsInPortCd;
	}
	

	/**
	 * Column Info
	 * @param scontiNm
	 */
	public void setScontiNm(String scontiNm) {
		this.scontiNm = scontiNm;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param dckTgtSkd
	 */
	public void setDckTgtSkd(String dckTgtSkd) {
		this.dckTgtSkd = dckTgtSkd;
	}
	
	/**
	 * Column Info
	 * @param dckDurDys
	 */
	public void setDckDurDys(String dckDurDys) {
		this.dckDurDys = dckDurDys;
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
	 * @param phsOutPortCd
	 */
	public void setPhsOutPortCd(String phsOutPortCd) {
		this.phsOutPortCd = phsOutPortCd;
	}
	
	/**
	 * Column Info
	 * @param fletDckSveyTpCd
	 */
	public void setFletDckSveyTpCd(String fletDckSveyTpCd) {
		this.fletDckSveyTpCd = fletDckSveyTpCd;
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
	 * @param phsOutDt
	 */
	public void setPhsOutDt(String phsOutDt) {
		this.phsOutDt = phsOutDt;
	}
	
	/**
	 * Column Info
	 * @param fletDckStsCd
	 */
	public void setFletDckStsCd(String fletDckStsCd) {
		this.fletDckStsCd = fletDckStsCd;
	}
	
	/**
	 * Column Info
	 * @param dckSelCd
	 */
	public void setDckSelCd(String dckSelCd) {
		this.dckSelCd = dckSelCd;
	}
	
	/**
	 * Column Info
	 * @param dckFmDt
	 */
	public void setDckFmDt(String dckFmDt) {
		this.dckFmDt = dckFmDt;
	}
	
	/**
	 * Column Info
	 * @param dckToDt
	 */
	public void setDckToDt(String dckToDt) {
		this.dckToDt = dckToDt;
	}
	
	/**
	 * Column Info
	 * @param dckLocCd
	 */
	public void setDckLocCd(String dckLocCd) {
		this.dckLocCd = dckLocCd;
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
	 * @param dckSeq
	 */
	public void setDckSeq(String dckSeq) {
		this.dckSeq = dckSeq;
	}
	
	/**
	 * Column Info
	 * @param phsInDt
	 */
	public void setPhsInDt(String phsInDt) {
		this.phsInDt = phsInDt;
	}
	
	/**
	 * Column Info
	 * @param phsInPortCd
	 */
	public void setPhsInPortCd(String phsInPortCd) {
		this.phsInPortCd = phsInPortCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setScontiNm(JSPUtil.getParameter(request, "sconti_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setDckTgtSkd(JSPUtil.getParameter(request, "dck_tgt_skd", ""));
		setDckDurDys(JSPUtil.getParameter(request, "dck_dur_dys", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPhsOutPortCd(JSPUtil.getParameter(request, "phs_out_port_cd", ""));
		setFletDckSveyTpCd(JSPUtil.getParameter(request, "flet_dck_svey_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPhsOutDt(JSPUtil.getParameter(request, "phs_out_dt", ""));
		setFletDckStsCd(JSPUtil.getParameter(request, "flet_dck_sts_cd", ""));
		setDckSelCd(JSPUtil.getParameter(request, "dck_sel_cd", ""));
		setDckFmDt(JSPUtil.getParameter(request, "dck_fm_dt", ""));
		setDckToDt(JSPUtil.getParameter(request, "dck_to_dt", ""));
		setDckLocCd(JSPUtil.getParameter(request, "dck_loc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDckSeq(JSPUtil.getParameter(request, "dck_seq", ""));
		setPhsInDt(JSPUtil.getParameter(request, "phs_in_dt", ""));
		setPhsInPortCd(JSPUtil.getParameter(request, "phs_in_port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DockPlanListVO[]
	 */
	public DockPlanListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DockPlanListVO[]
	 */
	public DockPlanListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DockPlanListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scontiNm = (JSPUtil.getParameter(request, prefix	+ "sconti_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] dckTgtSkd = (JSPUtil.getParameter(request, prefix	+ "dck_tgt_skd", length));
			String[] dckDurDys = (JSPUtil.getParameter(request, prefix	+ "dck_dur_dys", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] phsOutPortCd = (JSPUtil.getParameter(request, prefix	+ "phs_out_port_cd", length));
			String[] fletDckSveyTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_dck_svey_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] phsOutDt = (JSPUtil.getParameter(request, prefix	+ "phs_out_dt", length));
			String[] fletDckStsCd = (JSPUtil.getParameter(request, prefix	+ "flet_dck_sts_cd", length));
			String[] dckSelCd = (JSPUtil.getParameter(request, prefix	+ "dck_sel_cd", length));
			String[] dckFmDt = (JSPUtil.getParameter(request, prefix	+ "dck_fm_dt", length));
			String[] dckToDt = (JSPUtil.getParameter(request, prefix	+ "dck_to_dt", length));
			String[] dckLocCd = (JSPUtil.getParameter(request, prefix	+ "dck_loc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dckSeq = (JSPUtil.getParameter(request, prefix	+ "dck_seq", length));
			String[] phsInDt = (JSPUtil.getParameter(request, prefix	+ "phs_in_dt", length));
			String[] phsInPortCd = (JSPUtil.getParameter(request, prefix	+ "phs_in_port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DockPlanListVO();
				if (scontiNm[i] != null)
					model.setScontiNm(scontiNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (dckTgtSkd[i] != null)
					model.setDckTgtSkd(dckTgtSkd[i]);
				if (dckDurDys[i] != null)
					model.setDckDurDys(dckDurDys[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (phsOutPortCd[i] != null)
					model.setPhsOutPortCd(phsOutPortCd[i]);
				if (fletDckSveyTpCd[i] != null)
					model.setFletDckSveyTpCd(fletDckSveyTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (phsOutDt[i] != null)
					model.setPhsOutDt(phsOutDt[i]);
				if (fletDckStsCd[i] != null)
					model.setFletDckStsCd(fletDckStsCd[i]);
				if (dckSelCd[i] != null)
					model.setDckSelCd(dckSelCd[i]);
				if (dckFmDt[i] != null)
					model.setDckFmDt(dckFmDt[i]);
				if (dckToDt[i] != null)
					model.setDckToDt(dckToDt[i]);
				if (dckLocCd[i] != null)
					model.setDckLocCd(dckLocCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dckSeq[i] != null)
					model.setDckSeq(dckSeq[i]);
				if (phsInDt[i] != null)
					model.setPhsInDt(phsInDt[i]);
				if (phsInPortCd[i] != null)
					model.setPhsInPortCd(phsInPortCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDockPlanListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DockPlanListVO[]
	 */
	public DockPlanListVO[] getDockPlanListVOs(){
		DockPlanListVO[] vos = (DockPlanListVO[])models.toArray(new DockPlanListVO[models.size()]);
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
		this.scontiNm = this.scontiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckTgtSkd = this.dckTgtSkd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckDurDys = this.dckDurDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsOutPortCd = this.phsOutPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletDckSveyTpCd = this.fletDckSveyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsOutDt = this.phsOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletDckStsCd = this.fletDckStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckSelCd = this.dckSelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckFmDt = this.dckFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckToDt = this.dckToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckLocCd = this.dckLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckSeq = this.dckSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsInDt = this.phsInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsInPortCd = this.phsInPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
