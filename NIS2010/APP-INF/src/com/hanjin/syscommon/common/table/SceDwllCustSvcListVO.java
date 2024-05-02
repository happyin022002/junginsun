/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SceDwllCustSvcListVO.java
*@FileTitle : SceDwllCustSvcListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.05.24 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SceDwllCustSvcListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SceDwllCustSvcListVO> models = new ArrayList<SceDwllCustSvcListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dwllCustSeq = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String emlBkgOrgFlg = null;
	/* Column Info */
	private String subscEml = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sndOptCd = null;
	/* Column Info */
	private String deltDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntfcSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String dwllCustCntCd = null;
	/* Column Info */
	private String emlBkgDestFlg = null;
	/* Column Info */
	private String emlBkgOtrFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String subscRmk = null;
	/* Column Info */
	private String emlFmCrmFlg = null;
	/* Column Info */
	private String deltUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SceDwllCustSvcListVO() {}

	public SceDwllCustSvcListVO(String ibflag, String pagerows, String dwllCustCntCd, String dwllCustSeq, String ntfcSeq, String subscEml, String subscRmk, String emlFmCrmFlg, String emlBkgOrgFlg, String emlBkgDestFlg, String emlBkgOtrFlg, String deltUsrId, String deltFlg, String deltDt, String creOfcCd, String creUsrId, String creDt, String updUsrId, String updDt, String sndOptCd) {
		this.updDt = updDt;
		this.dwllCustSeq = dwllCustSeq;
		this.deltFlg = deltFlg;
		this.emlBkgOrgFlg = emlBkgOrgFlg;
		this.subscEml = subscEml;
		this.creDt = creDt;
		this.sndOptCd = sndOptCd;
		this.deltDt = deltDt;
		this.pagerows = pagerows;
		this.ntfcSeq = ntfcSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.dwllCustCntCd = dwllCustCntCd;
		this.emlBkgDestFlg = emlBkgDestFlg;
		this.emlBkgOtrFlg = emlBkgOtrFlg;
		this.updUsrId = updUsrId;
		this.subscRmk = subscRmk;
		this.emlFmCrmFlg = emlFmCrmFlg;
		this.deltUsrId = deltUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dwll_cust_seq", getDwllCustSeq());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("eml_bkg_org_flg", getEmlBkgOrgFlg());
		this.hashColumns.put("subsc_eml", getSubscEml());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("snd_opt_cd", getSndOptCd());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntfc_seq", getNtfcSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("dwll_cust_cnt_cd", getDwllCustCntCd());
		this.hashColumns.put("eml_bkg_dest_flg", getEmlBkgDestFlg());
		this.hashColumns.put("eml_bkg_otr_flg", getEmlBkgOtrFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("subsc_rmk", getSubscRmk());
		this.hashColumns.put("eml_fm_crm_flg", getEmlFmCrmFlg());
		this.hashColumns.put("delt_usr_id", getDeltUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dwll_cust_seq", "dwllCustSeq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("eml_bkg_org_flg", "emlBkgOrgFlg");
		this.hashFields.put("subsc_eml", "subscEml");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("snd_opt_cd", "sndOptCd");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntfc_seq", "ntfcSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("dwll_cust_cnt_cd", "dwllCustCntCd");
		this.hashFields.put("eml_bkg_dest_flg", "emlBkgDestFlg");
		this.hashFields.put("eml_bkg_otr_flg", "emlBkgOtrFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("subsc_rmk", "subscRmk");
		this.hashFields.put("eml_fm_crm_flg", "emlFmCrmFlg");
		this.hashFields.put("delt_usr_id", "deltUsrId");
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
	 * @return dwllCustSeq
	 */
	public String getDwllCustSeq() {
		return this.dwllCustSeq;
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
	 * @return emlBkgOrgFlg
	 */
	public String getEmlBkgOrgFlg() {
		return this.emlBkgOrgFlg;
	}
	
	/**
	 * Column Info
	 * @return subscEml
	 */
	public String getSubscEml() {
		return this.subscEml;
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
	 * @return sndOptCd
	 */
	public String getSndOptCd() {
		return this.sndOptCd;
	}
	
	/**
	 * Column Info
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
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
	 * @return ntfcSeq
	 */
	public String getNtfcSeq() {
		return this.ntfcSeq;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dwllCustCntCd
	 */
	public String getDwllCustCntCd() {
		return this.dwllCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return emlBkgDestFlg
	 */
	public String getEmlBkgDestFlg() {
		return this.emlBkgDestFlg;
	}
	
	/**
	 * Column Info
	 * @return emlBkgOtrFlg
	 */
	public String getEmlBkgOtrFlg() {
		return this.emlBkgOtrFlg;
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
	 * @return subscRmk
	 */
	public String getSubscRmk() {
		return this.subscRmk;
	}
	
	/**
	 * Column Info
	 * @return emlFmCrmFlg
	 */
	public String getEmlFmCrmFlg() {
		return this.emlFmCrmFlg;
	}
	
	/**
	 * Column Info
	 * @return deltUsrId
	 */
	public String getDeltUsrId() {
		return this.deltUsrId;
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
	 * @param dwllCustSeq
	 */
	public void setDwllCustSeq(String dwllCustSeq) {
		this.dwllCustSeq = dwllCustSeq;
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
	 * @param emlBkgOrgFlg
	 */
	public void setEmlBkgOrgFlg(String emlBkgOrgFlg) {
		this.emlBkgOrgFlg = emlBkgOrgFlg;
	}
	
	/**
	 * Column Info
	 * @param subscEml
	 */
	public void setSubscEml(String subscEml) {
		this.subscEml = subscEml;
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
	 * @param sndOptCd
	 */
	public void setSndOptCd(String sndOptCd) {
		this.sndOptCd = sndOptCd;
	}
	
	/**
	 * Column Info
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
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
	 * @param ntfcSeq
	 */
	public void setNtfcSeq(String ntfcSeq) {
		this.ntfcSeq = ntfcSeq;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dwllCustCntCd
	 */
	public void setDwllCustCntCd(String dwllCustCntCd) {
		this.dwllCustCntCd = dwllCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param emlBkgDestFlg
	 */
	public void setEmlBkgDestFlg(String emlBkgDestFlg) {
		this.emlBkgDestFlg = emlBkgDestFlg;
	}
	
	/**
	 * Column Info
	 * @param emlBkgOtrFlg
	 */
	public void setEmlBkgOtrFlg(String emlBkgOtrFlg) {
		this.emlBkgOtrFlg = emlBkgOtrFlg;
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
	 * @param subscRmk
	 */
	public void setSubscRmk(String subscRmk) {
		this.subscRmk = subscRmk;
	}
	
	/**
	 * Column Info
	 * @param emlFmCrmFlg
	 */
	public void setEmlFmCrmFlg(String emlFmCrmFlg) {
		this.emlFmCrmFlg = emlFmCrmFlg;
	}
	
	/**
	 * Column Info
	 * @param deltUsrId
	 */
	public void setDeltUsrId(String deltUsrId) {
		this.deltUsrId = deltUsrId;
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
		setDwllCustSeq(JSPUtil.getParameter(request, prefix + "dwll_cust_seq", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setEmlBkgOrgFlg(JSPUtil.getParameter(request, prefix + "eml_bkg_org_flg", ""));
		setSubscEml(JSPUtil.getParameter(request, prefix + "subsc_eml", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSndOptCd(JSPUtil.getParameter(request, prefix + "snd_opt_cd", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNtfcSeq(JSPUtil.getParameter(request, prefix + "ntfc_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setDwllCustCntCd(JSPUtil.getParameter(request, prefix + "dwll_cust_cnt_cd", ""));
		setEmlBkgDestFlg(JSPUtil.getParameter(request, prefix + "eml_bkg_dest_flg", ""));
		setEmlBkgOtrFlg(JSPUtil.getParameter(request, prefix + "eml_bkg_otr_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSubscRmk(JSPUtil.getParameter(request, prefix + "subsc_rmk", ""));
		setEmlFmCrmFlg(JSPUtil.getParameter(request, prefix + "eml_fm_crm_flg", ""));
		setDeltUsrId(JSPUtil.getParameter(request, prefix + "delt_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SceDwllCustSvcListVO[]
	 */
	public SceDwllCustSvcListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SceDwllCustSvcListVO[]
	 */
	public SceDwllCustSvcListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SceDwllCustSvcListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dwllCustSeq = (JSPUtil.getParameter(request, prefix	+ "dwll_cust_seq", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] emlBkgOrgFlg = (JSPUtil.getParameter(request, prefix	+ "eml_bkg_org_flg", length));
			String[] subscEml = (JSPUtil.getParameter(request, prefix	+ "subsc_eml", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sndOptCd = (JSPUtil.getParameter(request, prefix	+ "snd_opt_cd", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntfcSeq = (JSPUtil.getParameter(request, prefix	+ "ntfc_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] dwllCustCntCd = (JSPUtil.getParameter(request, prefix	+ "dwll_cust_cnt_cd", length));
			String[] emlBkgDestFlg = (JSPUtil.getParameter(request, prefix	+ "eml_bkg_dest_flg", length));
			String[] emlBkgOtrFlg = (JSPUtil.getParameter(request, prefix	+ "eml_bkg_otr_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] subscRmk = (JSPUtil.getParameter(request, prefix	+ "subsc_rmk", length));
			String[] emlFmCrmFlg = (JSPUtil.getParameter(request, prefix	+ "eml_fm_crm_flg", length));
			String[] deltUsrId = (JSPUtil.getParameter(request, prefix	+ "delt_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SceDwllCustSvcListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dwllCustSeq[i] != null)
					model.setDwllCustSeq(dwllCustSeq[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (emlBkgOrgFlg[i] != null)
					model.setEmlBkgOrgFlg(emlBkgOrgFlg[i]);
				if (subscEml[i] != null)
					model.setSubscEml(subscEml[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sndOptCd[i] != null)
					model.setSndOptCd(sndOptCd[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntfcSeq[i] != null)
					model.setNtfcSeq(ntfcSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (dwllCustCntCd[i] != null)
					model.setDwllCustCntCd(dwllCustCntCd[i]);
				if (emlBkgDestFlg[i] != null)
					model.setEmlBkgDestFlg(emlBkgDestFlg[i]);
				if (emlBkgOtrFlg[i] != null)
					model.setEmlBkgOtrFlg(emlBkgOtrFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (subscRmk[i] != null)
					model.setSubscRmk(subscRmk[i]);
				if (emlFmCrmFlg[i] != null)
					model.setEmlFmCrmFlg(emlFmCrmFlg[i]);
				if (deltUsrId[i] != null)
					model.setDeltUsrId(deltUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSceDwllCustSvcListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SceDwllCustSvcListVO[]
	 */
	public SceDwllCustSvcListVO[] getSceDwllCustSvcListVOs(){
		SceDwllCustSvcListVO[] vos = (SceDwllCustSvcListVO[])models.toArray(new SceDwllCustSvcListVO[models.size()]);
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
		this.dwllCustSeq = this.dwllCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlBkgOrgFlg = this.emlBkgOrgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subscEml = this.subscEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOptCd = this.sndOptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfcSeq = this.ntfcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllCustCntCd = this.dwllCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlBkgDestFlg = this.emlBkgDestFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlBkgOtrFlg = this.emlBkgOtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subscRmk = this.subscRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFmCrmFlg = this.emlFmCrmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId = this.deltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
