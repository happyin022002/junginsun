/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgRptDfltVO.java
*@FileTitle : BkgRptDfltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.04 강동윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgRptDfltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgRptDfltVO> models = new ArrayList<BkgRptDfltVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String comFlg = null;
	/* Column Info */
	private String rptNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String bzcCondSqlCtnt = null;
	/* Column Info */
	private String ownrUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bzcOrdCtnt = null;
	/* Column Info */
	private String rptId = null;
	/* Column Info */
	private String bkgRptKndCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgRptDfltVO() {}

	public BkgRptDfltVO(String ibflag, String pagerows, String bkgRptKndCd, String rptId, String rptNm, String comFlg, String bzcCondSqlCtnt, String bzcOrdCtnt, String ownrUsrId, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.comFlg = comFlg;
		this.rptNm = rptNm;
		this.creDt = creDt;
		this.bzcCondSqlCtnt = bzcCondSqlCtnt;
		this.ownrUsrId = ownrUsrId;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.bzcOrdCtnt = bzcOrdCtnt;
		this.rptId = rptId;
		this.bkgRptKndCd = bkgRptKndCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("com_flg", getComFlg());
		this.hashColumns.put("rpt_nm", getRptNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bzc_cond_sql_ctnt", getBzcCondSqlCtnt());
		this.hashColumns.put("ownr_usr_id", getOwnrUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bzc_ord_ctnt", getBzcOrdCtnt());
		this.hashColumns.put("rpt_id", getRptId());
		this.hashColumns.put("bkg_rpt_knd_cd", getBkgRptKndCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("com_flg", "comFlg");
		this.hashFields.put("rpt_nm", "rptNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bzc_cond_sql_ctnt", "bzcCondSqlCtnt");
		this.hashFields.put("ownr_usr_id", "ownrUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bzc_ord_ctnt", "bzcOrdCtnt");
		this.hashFields.put("rpt_id", "rptId");
		this.hashFields.put("bkg_rpt_knd_cd", "bkgRptKndCd");
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
	 * @return comFlg
	 */
	public String getComFlg() {
		return this.comFlg;
	}
	
	/**
	 * Column Info
	 * @return rptNm
	 */
	public String getRptNm() {
		return this.rptNm;
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
	 * @return bzcCondSqlCtnt
	 */
	public String getBzcCondSqlCtnt() {
		return this.bzcCondSqlCtnt;
	}
	
	/**
	 * Column Info
	 * @return ownrUsrId
	 */
	public String getOwnrUsrId() {
		return this.ownrUsrId;
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
	 * @return bzcOrdCtnt
	 */
	public String getBzcOrdCtnt() {
		return this.bzcOrdCtnt;
	}
	
	/**
	 * Column Info
	 * @return rptId
	 */
	public String getRptId() {
		return this.rptId;
	}
	
	/**
	 * Column Info
	 * @return bkgRptKndCd
	 */
	public String getBkgRptKndCd() {
		return this.bkgRptKndCd;
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
	 * @param comFlg
	 */
	public void setComFlg(String comFlg) {
		this.comFlg = comFlg;
	}
	
	/**
	 * Column Info
	 * @param rptNm
	 */
	public void setRptNm(String rptNm) {
		this.rptNm = rptNm;
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
	 * @param bzcCondSqlCtnt
	 */
	public void setBzcCondSqlCtnt(String bzcCondSqlCtnt) {
		this.bzcCondSqlCtnt = bzcCondSqlCtnt;
	}
	
	/**
	 * Column Info
	 * @param ownrUsrId
	 */
	public void setOwnrUsrId(String ownrUsrId) {
		this.ownrUsrId = ownrUsrId;
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
	 * @param bzcOrdCtnt
	 */
	public void setBzcOrdCtnt(String bzcOrdCtnt) {
		this.bzcOrdCtnt = bzcOrdCtnt;
	}
	
	/**
	 * Column Info
	 * @param rptId
	 */
	public void setRptId(String rptId) {
		this.rptId = rptId;
	}
	
	/**
	 * Column Info
	 * @param bkgRptKndCd
	 */
	public void setBkgRptKndCd(String bkgRptKndCd) {
		this.bkgRptKndCd = bkgRptKndCd;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setComFlg(JSPUtil.getParameter(request, "com_flg", ""));
		setRptNm(JSPUtil.getParameter(request, "rpt_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBzcCondSqlCtnt(JSPUtil.getParameter(request, "bzc_cond_sql_ctnt", ""));
		setOwnrUsrId(JSPUtil.getParameter(request, "ownr_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBzcOrdCtnt(JSPUtil.getParameter(request, "bzc_ord_ctnt", ""));
		setRptId(JSPUtil.getParameter(request, "rpt_id", ""));
		setBkgRptKndCd(JSPUtil.getParameter(request, "bkg_rpt_knd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgRptDfltVO[]
	 */
	public BkgRptDfltVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgRptDfltVO[]
	 */
	public BkgRptDfltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgRptDfltVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] comFlg = (JSPUtil.getParameter(request, prefix	+ "com_flg".trim(), length));
			String[] rptNm = (JSPUtil.getParameter(request, prefix	+ "rpt_nm".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] bzcCondSqlCtnt = (JSPUtil.getParameter(request, prefix	+ "bzc_cond_sql_ctnt".trim(), length));
			String[] ownrUsrId = (JSPUtil.getParameter(request, prefix	+ "ownr_usr_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] bzcOrdCtnt = (JSPUtil.getParameter(request, prefix	+ "bzc_ord_ctnt".trim(), length));
			String[] rptId = (JSPUtil.getParameter(request, prefix	+ "rpt_id".trim(), length));
			String[] bkgRptKndCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rpt_knd_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgRptDfltVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (comFlg[i] != null)
					model.setComFlg(comFlg[i]);
				if (rptNm[i] != null)
					model.setRptNm(rptNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (bzcCondSqlCtnt[i] != null)
					model.setBzcCondSqlCtnt(bzcCondSqlCtnt[i]);
				if (ownrUsrId[i] != null)
					model.setOwnrUsrId(ownrUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bzcOrdCtnt[i] != null)
					model.setBzcOrdCtnt(bzcOrdCtnt[i]);
				if (rptId[i] != null)
					model.setRptId(rptId[i]);
				if (bkgRptKndCd[i] != null)
					model.setBkgRptKndCd(bkgRptKndCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgRptDfltVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgRptDfltVO[]
	 */
	public BkgRptDfltVO[] getBkgRptDfltVOs(){
		BkgRptDfltVO[] vos = (BkgRptDfltVO[])models.toArray(new BkgRptDfltVO[models.size()]);
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
		this.comFlg = this.comFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptNm = this.rptNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcCondSqlCtnt = this.bzcCondSqlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrUsrId = this.ownrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcOrdCtnt = this.bzcOrdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptId = this.rptId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRptKndCd = this.bkgRptKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
