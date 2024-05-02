/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Sb45RulingExceptionVO.java
*@FileTitle : Sb45RulingExceptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.26
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.01.26 김성욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo;

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
 * @author 김성욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Sb45RulingExceptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Sb45RulingExceptionVO> models = new ArrayList<Sb45RulingExceptionVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String edwUpdDt = null;
	/* Column Info */
	private String excluSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String demDetTpCd = null;
	/* Column Info */
	private String seq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public Sb45RulingExceptionVO() {}

	public Sb45RulingExceptionVO(String ibflag, String pagerows, String cntCd, String locCd, String ydCd, String ioBndCd, String excluSeq, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String effDt, String expDt, String creUsrId, String creDt, String updUsrId, String updDt, String edwUpdDt, String demDetTpCd, String seq) {
		this.pagerows = pagerows;
		this.xcldSunFlg = xcldSunFlg;
		this.xcldHolFlg = xcldHolFlg;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.effDt = effDt;
		this.expDt = expDt;
		this.cntCd = cntCd;
		this.updUsrId = updUsrId;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.ydCd = ydCd;
		this.edwUpdDt = edwUpdDt;
		this.excluSeq = excluSeq;
		this.updDt = updDt;
		this.ioBndCd = ioBndCd;
		this.xcldSatFlg = xcldSatFlg;
		this.demDetTpCd= demDetTpCd; 
		this.seq = seq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("edw_upd_dt", getEdwUpdDt());
		this.hashColumns.put("exclu_seq", getExcluSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("dem_det_tp_cd", getDemDetTpCd());
		this.hashColumns.put("seq", getSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("edw_upd_dt", "edwUpdDt");
		this.hashFields.put("exclu_seq", "excluSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("dem_det_tp_cd", "demDetTpCd");
		this.hashFields.put("seq", "seq");
		return this.hashFields;
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
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return edwUpdDt
	 */
	public String getEdwUpdDt() {
		return this.edwUpdDt;
	}
	
	/**
	 * Column Info
	 * @return excluSeq
	 */
	public String getExcluSeq() {
		return this.excluSeq;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
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
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param edwUpdDt
	 */
	public void setEdwUpdDt(String edwUpdDt) {
		this.edwUpdDt = edwUpdDt;
	}
	
	/**
	 * Column Info
	 * @param excluSeq
	 */
	public void setExcluSeq(String excluSeq) {
		this.excluSeq = excluSeq;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
	}

	public String getDemDetTpCd() {
		return demDetTpCd;
	}

	public void setDemDetTpCd(String demDetTpCd) {
		this.demDetTpCd = demDetTpCd;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, prefix + "xcld_sun_flg", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, prefix + "xcld_hol_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setEdwUpdDt(JSPUtil.getParameter(request, prefix + "edw_upd_dt", ""));
		setExcluSeq(JSPUtil.getParameter(request, prefix + "exclu_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setXcldSatFlg(JSPUtil.getParameter(request, prefix + "xcld_sat_flg", ""));
		setDemDetTpCd(JSPUtil.getParameter(request, prefix + "dem_det_tp_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Sb45RulingExceptionVO[]
	 */
	public Sb45RulingExceptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Sb45RulingExceptionVO[]
	 */
	public Sb45RulingExceptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Sb45RulingExceptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] edwUpdDt = (JSPUtil.getParameter(request, prefix	+ "edw_upd_dt", length));
			String[] excluSeq = (JSPUtil.getParameter(request, prefix	+ "exclu_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] demDetTpCd = (JSPUtil.getParameter(request, prefix	+ "dem_det_tp_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new Sb45RulingExceptionVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (edwUpdDt[i] != null)
					model.setEdwUpdDt(edwUpdDt[i]);
				if (excluSeq[i] != null)
					model.setExcluSeq(excluSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (demDetTpCd[i] != null)
					model.setDemDetTpCd(demDetTpCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSb45RulingExceptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Sb45RulingExceptionVO[]
	 */
	public Sb45RulingExceptionVO[] getSb45RulingExceptionVOs(){
		Sb45RulingExceptionVO[] vos = (Sb45RulingExceptionVO[])models.toArray(new Sb45RulingExceptionVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edwUpdDt = this.edwUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excluSeq = this.excluSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demDetTpCd = this.demDetTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
