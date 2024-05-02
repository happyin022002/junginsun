/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMdmCustAddrListVO.java
*@FileTitle : SearchMdmCustAddrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.22 김성일 
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
 * @author 김성일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMdmCustAddrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMdmCustAddrVO> models = new ArrayList<SearchMdmCustAddrVO>();
	
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String crmRowId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String cntcEml = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String addrSeq = null;
	/* Column Info */
	private String bzetAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bzetRmk = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String addrTpCd = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String prmryChkFlg = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String eaiIfId = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMdmCustAddrVO() {}

	public SearchMdmCustAddrVO(String ibflag, String pagerows, String custSeq, String addrTpCd, String addrSeq, String prmryChkFlg, String bzetAddr, String ctyNm, String steCd, String zipCd, String cntcEml, String cntcPsonNm, String bzetRmk, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String crmRowId,String custCntCd, String eaiIfId, String cntCd) {
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.crmRowId = crmRowId;
		this.creDt = creDt;
		this.eaiEvntDt = eaiEvntDt;
		this.cntcEml = cntcEml;
		this.custSeq = custSeq;
		this.addrSeq = addrSeq;
		this.bzetAddr = bzetAddr;
		this.pagerows = pagerows;
		this.bzetRmk = bzetRmk;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.addrTpCd = addrTpCd;
		this.zipCd = zipCd;
		this.cntcPsonNm = cntcPsonNm;
		this.prmryChkFlg = prmryChkFlg;
		this.ctyNm = ctyNm;
		this.steCd = steCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.cntCd = cntCd;
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("crm_row_id", getCrmRowId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("cntc_eml", getCntcEml());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("addr_seq", getAddrSeq());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bzet_rmk", getBzetRmk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("addr_tp_cd", getAddrTpCd());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("crm_row_id", "crmRowId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("cntc_eml", "cntcEml");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("addr_seq", "addrSeq");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bzet_rmk", "bzetRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("addr_tp_cd", "addrTpCd");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cnt_cd", "cntCd");
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return crmRowId
	 */
	public String getCrmRowId() {
		return this.crmRowId;
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
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return cntcEml
	 */
	public String getCntcEml() {
		return this.cntcEml;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return addrSeq
	 */
	public String getAddrSeq() {
		return this.addrSeq;
	}
	
	/**
	 * Column Info
	 * @return bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
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
	 * @return bzetRmk
	 */
	public String getBzetRmk() {
		return this.bzetRmk;
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
	 * @return addrTpCd
	 */
	public String getAddrTpCd() {
		return this.addrTpCd;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
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
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param crmRowId
	 */
	public void setCrmRowId(String crmRowId) {
		this.crmRowId = crmRowId;
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
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param cntcEml
	 */
	public void setCntcEml(String cntcEml) {
		this.cntcEml = cntcEml;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param addrSeq
	 */
	public void setAddrSeq(String addrSeq) {
		this.addrSeq = addrSeq;
	}
	
	/**
	 * Column Info
	 * @param bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
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
	 * @param bzetRmk
	 */
	public void setBzetRmk(String bzetRmk) {
		this.bzetRmk = bzetRmk;
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
	 * @param addrTpCd
	 */
	public void setAddrTpCd(String addrTpCd) {
		this.addrTpCd = addrTpCd;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
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
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
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
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCrmRowId(JSPUtil.getParameter(request, "crm_row_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, "eai_evnt_dt", ""));
		setCntcEml(JSPUtil.getParameter(request, "cntc_eml", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setAddrSeq(JSPUtil.getParameter(request, "addr_seq", ""));
		setBzetAddr(JSPUtil.getParameter(request, "bzet_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBzetRmk(JSPUtil.getParameter(request, "bzet_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAddrTpCd(JSPUtil.getParameter(request, "addr_tp_cd", ""));
		setZipCd(JSPUtil.getParameter(request, "zip_cd", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setPrmryChkFlg(JSPUtil.getParameter(request, "prmry_chk_flg", ""));
		setCtyNm(JSPUtil.getParameter(request, "cty_nm", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setEaiIfId(JSPUtil.getParameter(request, "eai_if_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMdmCustAddrListVO[]
	 */
	public SearchMdmCustAddrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMdmCustAddrListVO[]
	 */
	public SearchMdmCustAddrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMdmCustAddrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] crmRowId = (JSPUtil.getParameter(request, prefix	+ "crm_row_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] cntcEml = (JSPUtil.getParameter(request, prefix	+ "cntc_eml", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] addrSeq = (JSPUtil.getParameter(request, prefix	+ "addr_seq", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bzetRmk = (JSPUtil.getParameter(request, prefix	+ "bzet_rmk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] addrTpCd = (JSPUtil.getParameter(request, prefix	+ "addr_tp_cd", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix	+ "prmry_chk_flg", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMdmCustAddrVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (crmRowId[i] != null)
					model.setCrmRowId(crmRowId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (cntcEml[i] != null)
					model.setCntcEml(cntcEml[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (addrSeq[i] != null)
					model.setAddrSeq(addrSeq[i]);
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bzetRmk[i] != null)
					model.setBzetRmk(bzetRmk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (addrTpCd[i] != null)
					model.setAddrTpCd(addrTpCd[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (prmryChkFlg[i] != null)
					model.setPrmryChkFlg(prmryChkFlg[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMdmCustAddrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMdmCustAddrListVO[]
	 */
	public SearchMdmCustAddrVO[] getSearchMdmCustAddrVOs(){
		SearchMdmCustAddrVO[] vos = (SearchMdmCustAddrVO[])models.toArray(new SearchMdmCustAddrVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crmRowId = this.crmRowId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcEml = this.cntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addrSeq = this.addrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetRmk = this.bzetRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addrTpCd = this.addrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmryChkFlg = this.prmryChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
