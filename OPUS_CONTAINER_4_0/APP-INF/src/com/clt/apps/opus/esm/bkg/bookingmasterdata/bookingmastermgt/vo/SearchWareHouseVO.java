/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchWareHouseVO.java
*@FileTitle : SearchWareHouseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.20 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김기종
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class SearchWareHouseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchWareHouseVO> models = new ArrayList<SearchWareHouseVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String whCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cstmsCd = null;
	/* Column Info */
	private String psonNm = null;
	/* Column Info */
	private String locNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String whNm = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String whAddr = null;
	/* Column Info */
	private String updUsrId = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchWareHouseVO() {}

	public SearchWareHouseVO(String ibflag, String pagerows, String cntCd, String whCd, String whNm, String whAddr, String locCd, String cstmsCd, String phnNo, String faxNo, String psonNm, String diffRmk, String creUsrId, String creDt, String updUsrId, String updDt, String locNm) {
		this.updDt = updDt;
		this.phnNo = phnNo;
		this.whCd = whCd;
		this.creDt = creDt;
		this.cstmsCd = cstmsCd;
		this.psonNm = psonNm;
		this.locNm = locNm;
		this.pagerows = pagerows;
		this.whNm = whNm;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.creUsrId = creUsrId;
		this.diffRmk = diffRmk;
		this.cntCd = cntCd;
		this.faxNo = faxNo;
		this.whAddr = whAddr;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("wh_cd", getWhCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cstms_cd", getCstmsCd());
		this.hashColumns.put("pson_nm", getPsonNm());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("wh_nm", getWhNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("wh_addr", getWhAddr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("wh_cd", "whCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cstms_cd", "cstmsCd");
		this.hashFields.put("pson_nm", "psonNm");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("wh_nm", "whNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("wh_addr", "whAddr");
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
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return whCd
	 */
	public String getWhCd() {
		return this.whCd;
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
	 * @return cstmsCd
	 */
	public String getCstmsCd() {
		return this.cstmsCd;
	}
	
	/**
	 * Column Info
	 * @return psonNm
	 */
	public String getPsonNm() {
		return this.psonNm;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
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
	 * @return whNm
	 */
	public String getWhNm() {
		return this.whNm;
	}
	
	/**
	 * Status
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return whAddr
	 */
	public String getWhAddr() {
		return this.whAddr;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param whCd
	 */
	public void setWhCd(String whCd) {
		this.whCd = whCd;
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
	 * @param cstmsCd
	 */
	public void setCstmsCd(String cstmsCd) {
		this.cstmsCd = cstmsCd;
	}
	
	/**
	 * Column Info
	 * @param psonNm
	 */
	public void setPsonNm(String psonNm) {
		this.psonNm = psonNm;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
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
	 * @param whNm
	 */
	public void setWhNm(String whNm) {
		this.whNm = whNm;
	}
	
	/**
	 * Status
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param whAddr
	 */
	public void setWhAddr(String whAddr) {
		this.whAddr = whAddr;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setWhCd(JSPUtil.getParameter(request, "wh_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCstmsCd(JSPUtil.getParameter(request, "cstms_cd", ""));
		setPsonNm(JSPUtil.getParameter(request, "pson_nm", ""));
		setLocNm(JSPUtil.getParameter(request, "loc_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setWhNm(JSPUtil.getParameter(request, "wh_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setWhAddr(JSPUtil.getParameter(request, "wh_addr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return SearchWareHouseVO[]
	 */
	public SearchWareHouseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchWareHouseVO[]
	 */
	public SearchWareHouseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchWareHouseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no".trim(), length));
			String[] whCd = (JSPUtil.getParameter(request, prefix	+ "wh_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] cstmsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_cd".trim(), length));
			String[] psonNm = (JSPUtil.getParameter(request, prefix	+ "pson_nm".trim(), length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] whNm = (JSPUtil.getParameter(request, prefix	+ "wh_nm".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no".trim(), length));
			String[] whAddr = (JSPUtil.getParameter(request, prefix	+ "wh_addr".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchWareHouseVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (whCd[i] != null)
					model.setWhCd(whCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cstmsCd[i] != null)
					model.setCstmsCd(cstmsCd[i]);
				if (psonNm[i] != null)
					model.setPsonNm(psonNm[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (whNm[i] != null)
					model.setWhNm(whNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (whAddr[i] != null)
					model.setWhAddr(whAddr[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchWareHouseVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return SearchWareHouseVO[]
	 */
	public SearchWareHouseVO[] getSearchWareHouseVOs(){
		SearchWareHouseVO[] vos = (SearchWareHouseVO[])models.toArray(new SearchWareHouseVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whCd = this.whCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd = this.cstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psonNm = this.psonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whNm = this.whNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whAddr = this.whAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
