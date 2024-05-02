/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchMSExptSaveVO.java
*@FileTitle : SearchMSExptSaveVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.dwellnotification.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SearchMSExptSaveVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMSExptSaveVO> models = new ArrayList<SearchMSExptSaveVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String actId = null;
	/* Column Info */
	private String estmId = null;
	/* Column Info */
	private String msDwllRmk = null;
	/* Column Info */
	private String diff = null;
	/* Column Info */
	private String actTt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String msDwllRsnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String estmTt = null;
	/* Column Info */
	private String estmOc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String actOc = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchMSExptSaveVO() {}

	public SearchMSExptSaveVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String vvd, String estmOc, String estmId, String estmTt, String actOc, String actId, String actTt, String diff, String msDwllRsnCd, String msDwllRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.actId = actId;
		this.estmId = estmId;
		this.msDwllRmk = msDwllRmk;
		this.diff = diff;
		this.actTt = actTt;
		this.creDt = creDt;
		this.msDwllRsnCd = msDwllRsnCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.estmTt = estmTt;
		this.estmOc = estmOc;
		this.cntrNo = cntrNo;
		this.actOc = actOc;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("act_id", getActId());
		this.hashColumns.put("estm_id", getEstmId());
		this.hashColumns.put("ms_dwll_rmk", getMsDwllRmk());
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("act_tt", getActTt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ms_dwll_rsn_cd", getMsDwllRsnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("estm_tt", getEstmTt());
		this.hashColumns.put("estm_oc", getEstmOc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("act_oc", getActOc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("act_id", "actId");
		this.hashFields.put("estm_id", "estmId");
		this.hashFields.put("ms_dwll_rmk", "msDwllRmk");
		this.hashFields.put("diff", "diff");
		this.hashFields.put("act_tt", "actTt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ms_dwll_rsn_cd", "msDwllRsnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("estm_tt", "estmTt");
		this.hashFields.put("estm_oc", "estmOc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("act_oc", "actOc");
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
	 * @return actId
	 */
	public String getActId() {
		return this.actId;
	}
	
	/**
	 * Column Info
	 * @return estmId
	 */
	public String getEstmId() {
		return this.estmId;
	}
	
	/**
	 * Column Info
	 * @return msDwllRmk
	 */
	public String getMsDwllRmk() {
		return this.msDwllRmk;
	}
	
	/**
	 * Column Info
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
	}
	
	/**
	 * Column Info
	 * @return actTt
	 */
	public String getActTt() {
		return this.actTt;
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
	 * @return msDwllRsnCd
	 */
	public String getMsDwllRsnCd() {
		return this.msDwllRsnCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return estmTt
	 */
	public String getEstmTt() {
		return this.estmTt;
	}
	
	/**
	 * Column Info
	 * @return estmOc
	 */
	public String getEstmOc() {
		return this.estmOc;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return actOc
	 */
	public String getActOc() {
		return this.actOc;
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
	 * @param actId
	 */
	public void setActId(String actId) {
		this.actId = actId;
	}
	
	/**
	 * Column Info
	 * @param estmId
	 */
	public void setEstmId(String estmId) {
		this.estmId = estmId;
	}
	
	/**
	 * Column Info
	 * @param msDwllRmk
	 */
	public void setMsDwllRmk(String msDwllRmk) {
		this.msDwllRmk = msDwllRmk;
	}
	
	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}
	
	/**
	 * Column Info
	 * @param actTt
	 */
	public void setActTt(String actTt) {
		this.actTt = actTt;
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
	 * @param msDwllRsnCd
	 */
	public void setMsDwllRsnCd(String msDwllRsnCd) {
		this.msDwllRsnCd = msDwllRsnCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param estmTt
	 */
	public void setEstmTt(String estmTt) {
		this.estmTt = estmTt;
	}
	
	/**
	 * Column Info
	 * @param estmOc
	 */
	public void setEstmOc(String estmOc) {
		this.estmOc = estmOc;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param actOc
	 */
	public void setActOc(String actOc) {
		this.actOc = actOc;
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
		setActId(JSPUtil.getParameter(request, prefix + "act_id", ""));
		setEstmId(JSPUtil.getParameter(request, prefix + "estm_id", ""));
		setMsDwllRmk(JSPUtil.getParameter(request, prefix + "ms_dwll_rmk", ""));
		setDiff(JSPUtil.getParameter(request, prefix + "diff", ""));
		setActTt(JSPUtil.getParameter(request, prefix + "act_tt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMsDwllRsnCd(JSPUtil.getParameter(request, prefix + "ms_dwll_rsn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setEstmTt(JSPUtil.getParameter(request, prefix + "estm_tt", ""));
		setEstmOc(JSPUtil.getParameter(request, prefix + "estm_oc", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setActOc(JSPUtil.getParameter(request, prefix + "act_oc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMSExptSaveVO[]
	 */
	public SearchMSExptSaveVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMSExptSaveVO[]
	 */
	public SearchMSExptSaveVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMSExptSaveVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] actId = (JSPUtil.getParameter(request, prefix	+ "act_id", length));
			String[] estmId = (JSPUtil.getParameter(request, prefix	+ "estm_id", length));
			String[] msDwllRmk = (JSPUtil.getParameter(request, prefix	+ "ms_dwll_rmk", length));
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));
			String[] actTt = (JSPUtil.getParameter(request, prefix	+ "act_tt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] msDwllRsnCd = (JSPUtil.getParameter(request, prefix	+ "ms_dwll_rsn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] estmTt = (JSPUtil.getParameter(request, prefix	+ "estm_tt", length));
			String[] estmOc = (JSPUtil.getParameter(request, prefix	+ "estm_oc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] actOc = (JSPUtil.getParameter(request, prefix	+ "act_oc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMSExptSaveVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (actId[i] != null)
					model.setActId(actId[i]);
				if (estmId[i] != null)
					model.setEstmId(estmId[i]);
				if (msDwllRmk[i] != null)
					model.setMsDwllRmk(msDwllRmk[i]);
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (actTt[i] != null)
					model.setActTt(actTt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (msDwllRsnCd[i] != null)
					model.setMsDwllRsnCd(msDwllRsnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (estmTt[i] != null)
					model.setEstmTt(estmTt[i]);
				if (estmOc[i] != null)
					model.setEstmOc(estmOc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (actOc[i] != null)
					model.setActOc(actOc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMSExptSaveVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMSExptSaveVO[]
	 */
	public SearchMSExptSaveVO[] getSearchMSExptSaveVOs(){
		SearchMSExptSaveVO[] vos = (SearchMSExptSaveVO[])models.toArray(new SearchMSExptSaveVO[models.size()]);
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
		this.actId = this.actId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmId = this.estmId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msDwllRmk = this.msDwllRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actTt = this.actTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msDwllRsnCd = this.msDwllRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmTt = this.estmTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmOc = this.estmOc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actOc = this.actOc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
