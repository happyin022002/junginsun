/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CountryVO.java
*@FileTitle : CountryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.bcm.ccd.commoncode.location.vo;

import java.lang.reflect.Field;
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

public class CountryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CountryVO> models = new ArrayList<CountryVO>();
	
	/* Column Info */
	private String cntIsoCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String znDivBselCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String scontiCd = null;
	/* Column Info */
	private String euCntFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CountryVO() {}

	public CountryVO(String ibflag, String pagerows, String cntNm, String scontiCd, String currCd, String cntIsoCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String znDivBselCd, String usrId, String cntCd, String euCntFlg) {
		this.cntIsoCd = cntIsoCd;
		this.updDt = updDt;
		this.znDivBselCd = znDivBselCd;
		this.currCd = currCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntNm = cntNm;
		this.creUsrId = creUsrId;
		this.usrId = usrId;
		this.cntCd = cntCd;
		this.updUsrId = updUsrId;
		this.scontiCd = scontiCd;
		this.euCntFlg = euCntFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnt_iso_cd", getCntIsoCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("zn_div_bsel_cd", getZnDivBselCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("eu_cnt_flg", getEuCntFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnt_iso_cd", "cntIsoCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("zn_div_bsel_cd", "znDivBselCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("eu_cnt_flg", "euCntFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntIsoCd
	 */
	public String getCntIsoCd() {
		return this.cntIsoCd;
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
	 * @return znDivBselCd
	 */
	public String getZnDivBselCd() {
		return this.znDivBselCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
	}
	

	/**
	 * Column Info
	 * @param cntIsoCd
	 */
	public void setCntIsoCd(String cntIsoCd) {
		this.cntIsoCd = cntIsoCd;
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
	 * @param znDivBselCd
	 */
	public void setZnDivBselCd(String znDivBselCd) {
		this.znDivBselCd = znDivBselCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}
	
	public String getEuCntFlg() {
		return euCntFlg;
	}

	public void setEuCntFlg(String euCntFlg) {
		this.euCntFlg = euCntFlg;
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
		setCntIsoCd(JSPUtil.getParameter(request, prefix + "cnt_iso_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setZnDivBselCd(JSPUtil.getParameter(request, prefix + "zn_div_bsel_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setScontiCd(JSPUtil.getParameter(request, prefix + "sconti_cd", ""));
		setEuCntFlg(JSPUtil.getParameter(request, prefix + "eu_cnt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CountryVO[]
	 */
	public CountryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CountryVO[]
	 */
	public CountryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CountryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntIsoCd = (JSPUtil.getParameter(request, prefix	+ "cnt_iso_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] znDivBselCd = (JSPUtil.getParameter(request, prefix	+ "zn_div_bsel_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));
			String[] euCntFlg = (JSPUtil.getParameter(request, prefix	+ "eu_cnt_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CountryVO();
				if (cntIsoCd[i] != null)
					model.setCntIsoCd(cntIsoCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (znDivBselCd[i] != null)
					model.setZnDivBselCd(znDivBselCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (euCntFlg[i] != null)
					model.setEuCntFlg(euCntFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCountryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CountryVO[]
	 */
	public CountryVO[] getCountryVOs(){
		CountryVO[] vos = (CountryVO[])models.toArray(new CountryVO[models.size()]);
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
		this.cntIsoCd = this.cntIsoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znDivBselCd = this.znDivBselCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euCntFlg = this.euCntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
