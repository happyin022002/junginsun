/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ZoneVO.java
*@FileTitle : ZoneVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.bcm.ccd.commoncode.location.vo;
 
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

public class ZoneVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ZoneVO> models = new ArrayList<ZoneVO>();
	
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String cgoHndlTmHrs = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String znNm = null;
	/* Column Info */
	private String znCd = null;
	/* Column Info */
	private String distUtCd = null;
	/* Column Info */
	private String tztmHrs = null;
	/* Column Info */
	private String repYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String rqstNo = null;
	private String creUsrId = null;
	private String creDt = null;
	private String updUsrId = null;
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ZoneVO() {}

	public ZoneVO(String ibflag, String pagerows, String znCd, String znNm, String cgoHndlTmHrs, String tztmHrs, String repYdCd, String lnkDist, String distUtCd, String deltFlg, String usrId, String locCd, String rqstNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.lnkDist = lnkDist;
		this.cgoHndlTmHrs = cgoHndlTmHrs;
		this.usrId = usrId;
		this.deltFlg = deltFlg;
		this.znNm = znNm;
		this.znCd = znCd;
		this.distUtCd = distUtCd;
		this.tztmHrs = tztmHrs;
		this.repYdCd = repYdCd;
		this.pagerows = pagerows;
		this.rqstNo = rqstNo;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lnk_dist", getLnkDist());
		this.hashColumns.put("cgo_hndl_tm_hrs", getCgoHndlTmHrs());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("zn_nm", getZnNm());
		this.hashColumns.put("zn_cd", getZnCd());
		this.hashColumns.put("dist_ut_cd", getDistUtCd());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("rep_yd_cd", getRepYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lnk_dist", "lnkDist");
		this.hashFields.put("cgo_hndl_tm_hrs", "cgoHndlTmHrs");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("zn_nm", "znNm");
		this.hashFields.put("zn_cd", "znCd");
		this.hashFields.put("dist_ut_cd", "distUtCd");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("rep_yd_cd", "repYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
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
	 * @return lnkDist
	 */
	public String getLnkDist() {
		return this.lnkDist;
	}
	
	/**
	 * Column Info
	 * @return cgoHndlTmHrs
	 */
	public String getCgoHndlTmHrs() {
		return this.cgoHndlTmHrs;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return znNm
	 */
	public String getZnNm() {
		return this.znNm;
	}
	
	/**
	 * Column Info
	 * @return znCd
	 */
	public String getZnCd() {
		return this.znCd;
	}
	
	/**
	 * Column Info
	 * @return distUtCd
	 */
	public String getDistUtCd() {
		return this.distUtCd;
	}
	
	/**
	 * Column Info
	 * @return tztmHrs
	 */
	public String getTztmHrs() {
		return this.tztmHrs;
	}
	
	/**
	 * Column Info
	 * @return repYdCd
	 */
	public String getRepYdCd() {
		return this.repYdCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Request Number
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
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
	 * @param lnkDist
	 */
	public void setLnkDist(String lnkDist) {
		this.lnkDist = lnkDist;
	}
	
	/**
	 * Column Info
	 * @param cgoHndlTmHrs
	 */
	public void setCgoHndlTmHrs(String cgoHndlTmHrs) {
		this.cgoHndlTmHrs = cgoHndlTmHrs;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param znNm
	 */
	public void setZnNm(String znNm) {
		this.znNm = znNm;
	}
	
	/**
	 * Column Info
	 * @param znCd
	 */
	public void setZnCd(String znCd) {
		this.znCd = znCd;
	}
	
	/**
	 * Column Info
	 * @param distUtCd
	 */
	public void setDistUtCd(String distUtCd) {
		this.distUtCd = distUtCd;
	}
	
	/**
	 * Column Info
	 * @param tztmHrs
	 */
	public void setTztmHrs(String tztmHrs) {
		this.tztmHrs = tztmHrs;
	}
	
	/**
	 * Column Info
	 * @param repYdCd
	 */
	public void setRepYdCd(String repYdCd) {
		this.repYdCd = repYdCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request Number
	 * @param pagerows
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLnkDist(JSPUtil.getParameter(request, prefix + "lnk_dist", ""));
		setCgoHndlTmHrs(JSPUtil.getParameter(request, prefix + "cgo_hndl_tm_hrs", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setZnNm(JSPUtil.getParameter(request, prefix + "zn_nm", ""));
		setZnCd(JSPUtil.getParameter(request, prefix + "zn_cd", ""));
		setDistUtCd(JSPUtil.getParameter(request, prefix + "dist_ut_cd", ""));
		setTztmHrs(JSPUtil.getParameter(request, prefix + "tztm_hrs", ""));
		setRepYdCd(JSPUtil.getParameter(request, prefix + "rep_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ZoneVO[]
	 */
	public ZoneVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ZoneVO[]
	 */
	public ZoneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ZoneVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lnkDist = (JSPUtil.getParameter(request, prefix	+ "lnk_dist", length));
			String[] cgoHndlTmHrs = (JSPUtil.getParameter(request, prefix	+ "cgo_hndl_tm_hrs", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] znNm = (JSPUtil.getParameter(request, prefix	+ "zn_nm", length));
			String[] znCd = (JSPUtil.getParameter(request, prefix	+ "zn_cd", length));
			String[] distUtCd = (JSPUtil.getParameter(request, prefix	+ "dist_ut_cd", length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs", length));
			String[] repYdCd = (JSPUtil.getParameter(request, prefix	+ "rep_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ZoneVO();
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (cgoHndlTmHrs[i] != null)
					model.setCgoHndlTmHrs(cgoHndlTmHrs[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (znNm[i] != null)
					model.setZnNm(znNm[i]);
				if (znCd[i] != null)
					model.setZnCd(znCd[i]);
				if (distUtCd[i] != null)
					model.setDistUtCd(distUtCd[i]);
				if (tztmHrs[i] != null)
					model.setTztmHrs(tztmHrs[i]);
				if (repYdCd[i] != null)
					model.setRepYdCd(repYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getZoneVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ZoneVO[]
	 */
	public ZoneVO[] getZoneVOs(){
		ZoneVO[] vos = (ZoneVO[])models.toArray(new ZoneVO[models.size()]);
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
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist = this.lnkDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoHndlTmHrs = this.cgoHndlTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znNm = this.znNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znCd = this.znCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distUtCd = this.distUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repYdCd = this.repYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
