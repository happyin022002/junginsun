/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EQCOrgChartListVO.java
*@FileTitle : EQCOrgChartListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.03
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.06.03 문동선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.eqcorgchart.vo;

import java.lang.reflect.Field;
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
 * @author 문동선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EQCOrgChartListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EQCOrgChartListVO> models = new ArrayList<EQCOrgChartListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String unit = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String locDpthCd = null;
	/* Column Info */
	private String tlevel = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String prntLocId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EQCOrgChartListVO() {}

	public EQCOrgChartListVO(String ibflag, String pagerows, String unit, String locCd, String tlevel, String locDpthCd, String prntLocId, String chk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.unit = unit;
		this.creUsrId = creUsrId;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.chk = chk;
		this.locDpthCd = locDpthCd;
		this.tlevel = tlevel;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.prntLocId = prntLocId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("loc_dpth_cd", getLocDpthCd());
		this.hashColumns.put("tlevel", getTlevel());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("prnt_loc_id", getPrntLocId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("loc_dpth_cd", "locDpthCd");
		this.hashFields.put("tlevel", "tlevel");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("prnt_loc_id", "prntLocId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return locDpthCd
	 */
	public String getLocDpthCd() {
		return this.locDpthCd;
	}
	
	/**
	 * Column Info
	 * @return tlevel
	 */
	public String getTlevel() {
		return this.tlevel;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return prntLocId
	 */
	public String getPrntLocId() {
		return this.prntLocId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param locDpthCd
	 */
	public void setLocDpthCd(String locDpthCd) {
		this.locDpthCd = locDpthCd;
	}
	
	/**
	 * Column Info
	 * @param tlevel
	 */
	public void setTlevel(String tlevel) {
		this.tlevel = tlevel;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param prntLocId
	 */
	public void setPrntLocId(String prntLocId) {
		this.prntLocId = prntLocId;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setUnit(JSPUtil.getParameter(request, prefix + "unit", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setLocDpthCd(JSPUtil.getParameter(request, prefix + "loc_dpth_cd", ""));
		setTlevel(JSPUtil.getParameter(request, prefix + "tlevel", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPrntLocId(JSPUtil.getParameter(request, prefix + "prnt_loc_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EQCOrgChartListVO[]
	 */
	public EQCOrgChartListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EQCOrgChartListVO[]
	 */
	public EQCOrgChartListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EQCOrgChartListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] locDpthCd = (JSPUtil.getParameter(request, prefix	+ "loc_dpth_cd", length));
			String[] tlevel = (JSPUtil.getParameter(request, prefix	+ "tlevel", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] prntLocId = (JSPUtil.getParameter(request, prefix	+ "prnt_loc_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EQCOrgChartListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (locDpthCd[i] != null)
					model.setLocDpthCd(locDpthCd[i]);
				if (tlevel[i] != null)
					model.setTlevel(tlevel[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (prntLocId[i] != null)
					model.setPrntLocId(prntLocId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEQCOrgChartListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EQCOrgChartListVO[]
	 */
	public EQCOrgChartListVO[] getEQCOrgChartListVOs(){
		EQCOrgChartListVO[] vos = (EQCOrgChartListVO[])models.toArray(new EQCOrgChartListVO[models.size()]);
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
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locDpthCd = this.locDpthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlevel = this.tlevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntLocId = this.prntLocId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
