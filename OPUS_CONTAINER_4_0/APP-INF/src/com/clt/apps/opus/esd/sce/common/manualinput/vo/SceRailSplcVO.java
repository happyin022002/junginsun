/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SceRailSplcVO.java
*@FileTitle : SceRailSplcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.24
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.04.24 이준근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.common.manualinput.vo;

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
 * @author 이준근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SceRailSplcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SceRailSplcVO> models = new ArrayList<SceRailSplcVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String splcAbbrLocNm = null;
	/* Column Info */
	private String splcDfltFlg = null;
	/* Column Info */
	private String splcLocNm = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String splcVndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cutyNm = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String splcCd = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SceRailSplcVO() {}

	public SceRailSplcVO(String ibflag, String pagerows, String splcCd, String splcVndrNm, String ydCd, String splcAbbrLocNm, String steCd, String cutyNm, String splcLocNm, String splcDfltFlg, String locCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.splcAbbrLocNm = splcAbbrLocNm;
		this.splcDfltFlg = splcDfltFlg;
		this.splcLocNm = splcLocNm;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.splcVndrNm = splcVndrNm;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.creUsrId = creUsrId;
		this.cutyNm = cutyNm;
		this.ydCd = ydCd;
		this.splcCd = splcCd;
		this.steCd = steCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("splc_abbr_loc_nm", getSplcAbbrLocNm());
		this.hashColumns.put("splc_dflt_flg", getSplcDfltFlg());
		this.hashColumns.put("splc_loc_nm", getSplcLocNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("splc_vndr_nm", getSplcVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cuty_nm", getCutyNm());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("splc_cd", getSplcCd());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("splc_abbr_loc_nm", "splcAbbrLocNm");
		this.hashFields.put("splc_dflt_flg", "splcDfltFlg");
		this.hashFields.put("splc_loc_nm", "splcLocNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("splc_vndr_nm", "splcVndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cuty_nm", "cutyNm");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("splc_cd", "splcCd");
		this.hashFields.put("ste_cd", "steCd");
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
	 * @return splcAbbrLocNm
	 */
	public String getSplcAbbrLocNm() {
		return this.splcAbbrLocNm;
	}
	
	/**
	 * Column Info
	 * @return splcDfltFlg
	 */
	public String getSplcDfltFlg() {
		return this.splcDfltFlg;
	}
	
	/**
	 * Column Info
	 * @return splcLocNm
	 */
	public String getSplcLocNm() {
		return this.splcLocNm;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return splcVndrNm
	 */
	public String getSplcVndrNm() {
		return this.splcVndrNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cutyNm
	 */
	public String getCutyNm() {
		return this.cutyNm;
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
	 * @return splcCd
	 */
	public String getSplcCd() {
		return this.splcCd;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
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
	 * @param splcAbbrLocNm
	 */
	public void setSplcAbbrLocNm(String splcAbbrLocNm) {
		this.splcAbbrLocNm = splcAbbrLocNm;
	}
	
	/**
	 * Column Info
	 * @param splcDfltFlg
	 */
	public void setSplcDfltFlg(String splcDfltFlg) {
		this.splcDfltFlg = splcDfltFlg;
	}
	
	/**
	 * Column Info
	 * @param splcLocNm
	 */
	public void setSplcLocNm(String splcLocNm) {
		this.splcLocNm = splcLocNm;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param splcVndrNm
	 */
	public void setSplcVndrNm(String splcVndrNm) {
		this.splcVndrNm = splcVndrNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cutyNm
	 */
	public void setCutyNm(String cutyNm) {
		this.cutyNm = cutyNm;
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
	 * @param splcCd
	 */
	public void setSplcCd(String splcCd) {
		this.splcCd = splcCd;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
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
		setSplcAbbrLocNm(JSPUtil.getParameter(request, prefix + "splc_abbr_loc_nm", ""));
		setSplcDfltFlg(JSPUtil.getParameter(request, prefix + "splc_dflt_flg", ""));
		setSplcLocNm(JSPUtil.getParameter(request, prefix + "splc_loc_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSplcVndrNm(JSPUtil.getParameter(request, prefix + "splc_vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCutyNm(JSPUtil.getParameter(request, prefix + "cuty_nm", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setSplcCd(JSPUtil.getParameter(request, prefix + "splc_cd", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SceRailSplcVO[]
	 */
	public SceRailSplcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SceRailSplcVO[]
	 */
	public SceRailSplcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SceRailSplcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] splcAbbrLocNm = (JSPUtil.getParameter(request, prefix	+ "splc_abbr_loc_nm", length));
			String[] splcDfltFlg = (JSPUtil.getParameter(request, prefix	+ "splc_dflt_flg", length));
			String[] splcLocNm = (JSPUtil.getParameter(request, prefix	+ "splc_loc_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] splcVndrNm = (JSPUtil.getParameter(request, prefix	+ "splc_vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cutyNm = (JSPUtil.getParameter(request, prefix	+ "cuty_nm", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] splcCd = (JSPUtil.getParameter(request, prefix	+ "splc_cd", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SceRailSplcVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (splcAbbrLocNm[i] != null)
					model.setSplcAbbrLocNm(splcAbbrLocNm[i]);
				if (splcDfltFlg[i] != null)
					model.setSplcDfltFlg(splcDfltFlg[i]);
				if (splcLocNm[i] != null)
					model.setSplcLocNm(splcLocNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (splcVndrNm[i] != null)
					model.setSplcVndrNm(splcVndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cutyNm[i] != null)
					model.setCutyNm(cutyNm[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (splcCd[i] != null)
					model.setSplcCd(splcCd[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSceRailSplcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SceRailSplcVO[]
	 */
	public SceRailSplcVO[] getSceRailSplcVOs(){
		SceRailSplcVO[] vos = (SceRailSplcVO[])models.toArray(new SceRailSplcVO[models.size()]);
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
		this.splcAbbrLocNm = this.splcAbbrLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splcDfltFlg = this.splcDfltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splcLocNm = this.splcLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splcVndrNm = this.splcVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cutyNm = this.cutyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splcCd = this.splcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
