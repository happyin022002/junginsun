/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SimulationNoVO.java
*@FileTitle : SimulationNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.26
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.06.26 김영오
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SimulationNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SimulationNoVO> models = new ArrayList<SimulationNoVO>();

	/* Column Info */
	private String simFlg = null;
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String simUsrOfcNm = null;
	/* Column Info */
	private String simBkgKnt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String simNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String simRmk = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String simUsrOfcCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SimulationNoVO() {}

	public SimulationNoVO(String ibflag, String pagerows, String simNo, String simBkgKnt, String simUsrOfcCd, String simRmk, String deltFlg, String creUsrId, String creDt, String updUsrId, String usrId, String updDt, String simUsrOfcNm, String dateFm, String dateTo, String simFlg) {
		this.simFlg = simFlg;
		this.dateFm = dateFm;
		this.updDt = updDt;
		this.simUsrOfcNm = simUsrOfcNm;
		this.simBkgKnt = simBkgKnt;
		this.deltFlg = deltFlg;
		this.dateTo = dateTo;
		this.creDt = creDt;
		this.simNo = simNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.simRmk = simRmk;
		this.usrId = usrId;
		this.simUsrOfcCd = simUsrOfcCd;
		this.updUsrId = updUsrId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sim_flg", getSimFlg());
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sim_usr_ofc_nm", getSimUsrOfcNm());
		this.hashColumns.put("sim_bkg_knt", getSimBkgKnt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("sim_rmk", getSimRmk());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("sim_usr_ofc_cd", getSimUsrOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sim_flg", "simFlg");
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sim_usr_ofc_nm", "simUsrOfcNm");
		this.hashFields.put("sim_bkg_knt", "simBkgKnt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("sim_rmk", "simRmk");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("sim_usr_ofc_cd", "simUsrOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return simFlg
	 */
	public String getSimFlg() {
		return this.simFlg;
	}
	
	
	/**
	 * Column Info
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
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
	 * @return simUsrOfcNm
	 */
	public String getSimUsrOfcNm() {
		return this.simUsrOfcNm;
	}

	/**
	 * Column Info
	 * @return simBkgKnt
	 */
	public String getSimBkgKnt() {
		return this.simBkgKnt;
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
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
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
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
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
	 * @return simRmk
	 */
	public String getSimRmk() {
		return this.simRmk;
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
	 * @return simUsrOfcCd
	 */
	public String getSimUsrOfcCd() {
		return this.simUsrOfcCd;
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
	 * @param simFlg
	 */
	public void setSimFlg(String simFlg) {
		this.simFlg = simFlg;
	}
	
	/**
	 * Column Info
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
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
	 * @param simUsrOfcNm
	 */
	public void setSimUsrOfcNm(String simUsrOfcNm) {
		this.simUsrOfcNm = simUsrOfcNm;
	}

	/**
	 * Column Info
	 * @param simBkgKnt
	 */
	public void setSimBkgKnt(String simBkgKnt) {
		this.simBkgKnt = simBkgKnt;
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
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
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
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
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
	 * @param simRmk
	 */
	public void setSimRmk(String simRmk) {
		this.simRmk = simRmk;
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
	 * @param simUsrOfcCd
	 */
	public void setSimUsrOfcCd(String simUsrOfcCd) {
		this.simUsrOfcCd = simUsrOfcCd;
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
		setSimFlg(JSPUtil.getParameter(request, prefix + "sim_flg", ""));
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSimUsrOfcNm(JSPUtil.getParameter(request, prefix + "sim_usr_ofc_nm", ""));
		setSimBkgKnt(JSPUtil.getParameter(request, prefix + "sim_bkg_knt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSimNo(JSPUtil.getParameter(request, prefix + "sim_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSimRmk(JSPUtil.getParameter(request, prefix + "sim_rmk", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSimUsrOfcCd(JSPUtil.getParameter(request, prefix + "sim_usr_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SimulationNoVO[]
	 */
	public SimulationNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SimulationNoVO[]
	 */
	public SimulationNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SimulationNoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] simFlg = (JSPUtil.getParameter(request, prefix	+ "sim_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] simUsrOfcNm = (JSPUtil.getParameter(request, prefix	+ "sim_usr_ofc_nm", length));
			String[] simBkgKnt = (JSPUtil.getParameter(request, prefix	+ "sim_bkg_knt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] simRmk = (JSPUtil.getParameter(request, prefix	+ "sim_rmk", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] simUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "sim_usr_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));

			for (int i = 0; i < length; i++) {
				model = new SimulationNoVO();
				if (simFlg[i] != null)
					model.setSimFlg(simFlg[i]);
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (simUsrOfcNm[i] != null)
					model.setSimUsrOfcNm(simUsrOfcNm[i]);
				if (simBkgKnt[i] != null)
					model.setSimBkgKnt(simBkgKnt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (simRmk[i] != null)
					model.setSimRmk(simRmk[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (simUsrOfcCd[i] != null)
					model.setSimUsrOfcCd(simUsrOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSimulationNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SimulationNoVO[]
	 */
	public SimulationNoVO[] getSimulationNoVOs(){
		SimulationNoVO[] vos = (SimulationNoVO[])models.toArray(new SimulationNoVO[models.size()]);
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
		this.simFlg = this.simFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simUsrOfcNm = this.simUsrOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simBkgKnt = this.simBkgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simRmk = this.simRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simUsrOfcCd = this.simUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
