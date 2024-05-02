/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMdmVndrCntcPntVO.java
*@FileTitle : SearchMdmVndrCntcPntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.22 최 선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.common.mdmSync.jms.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMdmVndrCntcPntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMdmVndrCntcPntVO> models = new ArrayList<SearchMdmVndrCntcPntVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vndrCntcPntSeq = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntcDivCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prmryChkFlg = null;
	/* Column Info */
	private String intlPhnNo = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String vndrEml = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String intlFaxNo = null;
	/* Column Info */
	private String eaiIfId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMdmVndrCntcPntVO() {}

	public SearchMdmVndrCntcPntVO(String ibflag, String pagerows, String vndrSeq, String vndrCntcPntSeq, String intlPhnNo, String phnNo, String intlFaxNo, String faxNo, String vndrEml, String eaiEvntDt, String prmryChkFlg, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String cntcDivCd, String eaiIfId) {
		this.updDt = updDt;
		this.vndrCntcPntSeq = vndrCntcPntSeq;
		this.deltFlg = deltFlg;
		this.vndrSeq = vndrSeq;
		this.eaiEvntDt = eaiEvntDt;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
		this.cntcDivCd = cntcDivCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.prmryChkFlg = prmryChkFlg;
		this.intlPhnNo = intlPhnNo;
		this.phnNo = phnNo;
		this.vndrEml = vndrEml;
		this.creDt = creDt;
		this.faxNo = faxNo;
		this.intlFaxNo = intlFaxNo;
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vndr_cntc_pnt_seq", getVndrCntcPntSeq());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntc_div_cd", getCntcDivCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("vndr_eml", getVndrEml());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vndr_cntc_pnt_seq", "vndrCntcPntSeq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntc_div_cd", "cntcDivCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("vndr_eml", "vndrEml");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("intl_fax_no", "intlFaxNo");
		this.hashFields.put("eai_if_id", "eaiIfId");
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
	 * @return vndrCntcPntSeq
	 */
	public String getVndrCntcPntSeq() {
		return this.vndrCntcPntSeq;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return cntcDivCd
	 */
	public String getCntcDivCd() {
		return this.cntcDivCd;
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
	 * @return prmryChkFlg
	 */
	public String getPrmryChkFlg() {
		return this.prmryChkFlg;
	}
	
	/**
	 * Column Info
	 * @return intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return vndrEml
	 */
	public String getVndrEml() {
		return this.vndrEml;
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
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return intlFaxNo
	 */
	public String getIntlFaxNo() {
		return this.intlFaxNo;
	}
	
	/**
	 * Column Info
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
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
	 * @param vndrCntcPntSeq
	 */
	public void setVndrCntcPntSeq(String vndrCntcPntSeq) {
		this.vndrCntcPntSeq = vndrCntcPntSeq;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param cntcDivCd
	 */
	public void setCntcDivCd(String cntcDivCd) {
		this.cntcDivCd = cntcDivCd;
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
	 * @param prmryChkFlg
	 */
	public void setPrmryChkFlg(String prmryChkFlg) {
		this.prmryChkFlg = prmryChkFlg;
	}
	
	/**
	 * Column Info
	 * @param intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param vndrEml
	 */
	public void setVndrEml(String vndrEml) {
		this.vndrEml = vndrEml;
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
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param intlFaxNo
	 */
	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
	}
	
	/**
	 * Column Info
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setVndrCntcPntSeq(JSPUtil.getParameter(request, "vndr_cntc_pnt_seq", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, "eai_evnt_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntcDivCd(JSPUtil.getParameter(request, "cntc_div_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPrmryChkFlg(JSPUtil.getParameter(request, "prmry_chk_flg", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, "intl_phn_no", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setVndrEml(JSPUtil.getParameter(request, "vndr_eml", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, "intl_fax_no", ""));
		setEaiIfId(JSPUtil.getParameter(request, "eai_if_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMdmVndrCntcPntVO[]
	 */
	public SearchMdmVndrCntcPntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMdmVndrCntcPntVO[]
	 */
	public SearchMdmVndrCntcPntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMdmVndrCntcPntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vndrCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cntc_pnt_seq", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntcDivCd = (JSPUtil.getParameter(request, prefix	+ "cntc_div_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix	+ "prmry_chk_flg", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] vndrEml = (JSPUtil.getParameter(request, prefix	+ "vndr_eml", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMdmVndrCntcPntVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vndrCntcPntSeq[i] != null)
					model.setVndrCntcPntSeq(vndrCntcPntSeq[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntcDivCd[i] != null)
					model.setCntcDivCd(cntcDivCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prmryChkFlg[i] != null)
					model.setPrmryChkFlg(prmryChkFlg[i]);
				if (intlPhnNo[i] != null)
					model.setIntlPhnNo(intlPhnNo[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (vndrEml[i] != null)
					model.setVndrEml(vndrEml[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (intlFaxNo[i] != null)
					model.setIntlFaxNo(intlFaxNo[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreateMdmVndrCntcPntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMdmVndrCntcPntVO[]
	 */
	public SearchMdmVndrCntcPntVO[] getCreateMdmVndrCntcPntVOs(){
		SearchMdmVndrCntcPntVO[] vos = (SearchMdmVndrCntcPntVO[])models.toArray(new SearchMdmVndrCntcPntVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntcPntSeq = this.vndrCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcDivCd = this.cntcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmryChkFlg = this.prmryChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrEml = this.vndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
