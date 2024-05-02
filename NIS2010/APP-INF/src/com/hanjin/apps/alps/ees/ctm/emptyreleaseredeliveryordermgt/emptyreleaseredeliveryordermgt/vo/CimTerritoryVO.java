/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CimTerritoryVO.java
*@FileTitle : CimTerritoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.06.10 김상수
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CimTerritoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CimTerritoryVO> models = new ArrayList<CimTerritoryVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ofcCd0 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntrStkTerrCd0 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String cntNm0 = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cntrStkTerrCd = null;
	/* Column Info */
	private String cntCd0 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CimTerritoryVO() {}

	public CimTerritoryVO(String ibflag, String pagerows, String cntrStkTerrCd, String cntNm, String cntNm0, String cntCd, String ofcCd, String usrId, String creDt, String updDt, String cntrStkTerrCd0, String cntCd0, String ofcCd0) {
		this.updDt = updDt;
		this.ofcCd0 = ofcCd0;
		this.creDt = creDt;
		this.cntrStkTerrCd0 = cntrStkTerrCd0;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.cntNm = cntNm;
		this.cntNm0 = cntNm0;
		this.usrId = usrId;
		this.cntCd = cntCd;
		this.cntrStkTerrCd = cntrStkTerrCd;
		this.cntCd0 = cntCd0;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ofc_cd0", getOfcCd0());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntr_stk_terr_cd0", getCntrStkTerrCd0());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("cnt_nm0", getCntNm0());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cntr_stk_terr_cd", getCntrStkTerrCd());
		this.hashColumns.put("cnt_cd0", getCntCd0());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ofc_cd0", "ofcCd0");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntr_stk_terr_cd0", "cntrStkTerrCd0");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("cnt_nm0", "cntNm0");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cntr_stk_terr_cd", "cntrStkTerrCd");
		this.hashFields.put("cnt_cd0", "cntCd0");
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
	 * @return ofcCd0
	 */
	public String getOfcCd0() {
		return this.ofcCd0;
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
	 * @return cntrStkTerrCd0
	 */
	public String getCntrStkTerrCd0() {
		return this.cntrStkTerrCd0;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return cntNm0
	 */
	public String getCntNm0() {
		return this.cntNm0;
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
	 * @return cntrStkTerrCd
	 */
	public String getCntrStkTerrCd() {
		return this.cntrStkTerrCd;
	}

	/**
	 * Column Info
	 * @return cntCd0
	 */
	public String getCntCd0() {
		return this.cntCd0;
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
	 * @param ofcCd0
	 */
	public void setOfcCd0(String ofcCd0) {
		this.ofcCd0 = ofcCd0;
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
	 * @param cntrStkTerrCd0
	 */
	public void setCntrStkTerrCd0(String cntrStkTerrCd0) {
		this.cntrStkTerrCd0 = cntrStkTerrCd0;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param cntNm0
	 */
	public void setCntNm0(String cntNm0) {
		this.cntNm0 = cntNm0;
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
	 * @param cntrStkTerrCd
	 */
	public void setCntrStkTerrCd(String cntrStkTerrCd) {
		this.cntrStkTerrCd = cntrStkTerrCd;
	}

	/**
	 * Column Info
	 * @param cntCd0
	 */
	public void setCntCd0(String cntCd0) {
		this.cntCd0 = cntCd0;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setOfcCd0(JSPUtil.getParameter(request, "ofc_cd0", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCntrStkTerrCd0(JSPUtil.getParameter(request, "cntr_stk_terr_cd0", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntNm(JSPUtil.getParameter(request, "cnt_nm", ""));
		setCntNm0(JSPUtil.getParameter(request, "cnt_nm0", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setCntrStkTerrCd(JSPUtil.getParameter(request, "cntr_stk_terr_cd", ""));
		setCntCd0(JSPUtil.getParameter(request, "cnt_cd0", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CimTerritoryVO[]
	 */
	public CimTerritoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CimTerritoryVO[]
	 */
	public CimTerritoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CimTerritoryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ofcCd0 = (JSPUtil.getParameter(request, prefix	+ "ofc_cd0", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntrStkTerrCd0 = (JSPUtil.getParameter(request, prefix	+ "cntr_stk_terr_cd0", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] cntNm0 = (JSPUtil.getParameter(request, prefix	+ "cnt_nm0", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cntrStkTerrCd = (JSPUtil.getParameter(request, prefix	+ "cntr_stk_terr_cd", length));
			String[] cntCd0 = (JSPUtil.getParameter(request, prefix	+ "cnt_cd0", length));

			for (int i = 0; i < length; i++) {
				model = new CimTerritoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ofcCd0[i] != null)
					model.setOfcCd0(ofcCd0[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntrStkTerrCd0[i] != null)
					model.setCntrStkTerrCd0(cntrStkTerrCd0[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (cntNm0[i] != null)
					model.setCntNm0(cntNm0[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cntrStkTerrCd[i] != null)
					model.setCntrStkTerrCd(cntrStkTerrCd[i]);
				if (cntCd0[i] != null)
					model.setCntCd0(cntCd0[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCimTerritoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CimTerritoryVO[]
	 */
	public CimTerritoryVO[] getCimTerritoryVOs(){
		CimTerritoryVO[] vos = (CimTerritoryVO[])models.toArray(new CimTerritoryVO[models.size()]);
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
		this.ofcCd0 = this.ofcCd0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStkTerrCd0 = this.cntrStkTerrCd0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm0 = this.cntNm0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStkTerrCd = this.cntrStkTerrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd0 = this.cntCd0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
