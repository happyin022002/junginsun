/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TesEqLandStayVO.java
*@FileTitle : TesEqLandStayVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.25 yOng hO lEE 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author yOng hO lEE
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesEqLandStayVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesEqLandStayVO> models = new ArrayList<TesEqLandStayVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String staySmryDt = null;
	/* Column Info */
	private String dwUpdDt = null;
	/* Column Info */
	private String cntrFullFlg = null;
	/* Column Info */
	private String nisEvntDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntrKntQty = null;
	/* Column Info */
	private String ttlStayDys = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String avgStayDys = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesEqLandStayVO() {}

	public TesEqLandStayVO(String ibflag, String pagerows, String staySmryDt, String crrCd, String cnmvStsCd, String ydCd, String cntrTpszCd, String lstmCd, String cntrFullFlg, String cntrDmgFlg, String cntrKntQty, String avgStayDys, String dwUpdDt, String ttlStayDys, String nisEvntDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.staySmryDt = staySmryDt;
		this.dwUpdDt = dwUpdDt;
		this.cntrFullFlg = cntrFullFlg;
		this.nisEvntDt = nisEvntDt;
		this.creDt = creDt;
		this.cntrKntQty = cntrKntQty;
		this.ttlStayDys = ttlStayDys;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.cntrDmgFlg = cntrDmgFlg;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.ydCd = ydCd;
		this.cntrTpszCd = cntrTpszCd;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.avgStayDys = avgStayDys;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("stay_smry_dt", getStaySmryDt());
		this.hashColumns.put("dw_upd_dt", getDwUpdDt());
		this.hashColumns.put("cntr_full_flg", getCntrFullFlg());
		this.hashColumns.put("nis_evnt_dt", getNisEvntDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntr_knt_qty", getCntrKntQty());
		this.hashColumns.put("ttl_stay_dys", getTtlStayDys());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("avg_stay_dys", getAvgStayDys());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("stay_smry_dt", "staySmryDt");
		this.hashFields.put("dw_upd_dt", "dwUpdDt");
		this.hashFields.put("cntr_full_flg", "cntrFullFlg");
		this.hashFields.put("nis_evnt_dt", "nisEvntDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntr_knt_qty", "cntrKntQty");
		this.hashFields.put("ttl_stay_dys", "ttlStayDys");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("avg_stay_dys", "avgStayDys");
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
	 * @return staySmryDt
	 */
	public String getStaySmryDt() {
		return this.staySmryDt;
	}
	
	/**
	 * Column Info
	 * @return dwUpdDt
	 */
	public String getDwUpdDt() {
		return this.dwUpdDt;
	}
	
	/**
	 * Column Info
	 * @return cntrFullFlg
	 */
	public String getCntrFullFlg() {
		return this.cntrFullFlg;
	}
	
	/**
	 * Column Info
	 * @return nisEvntDt
	 */
	public String getNisEvntDt() {
		return this.nisEvntDt;
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
	 * @return cntrKntQty
	 */
	public String getCntrKntQty() {
		return this.cntrKntQty;
	}
	
	/**
	 * Column Info
	 * @return ttlStayDys
	 */
	public String getTtlStayDys() {
		return this.ttlStayDys;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return avgStayDys
	 */
	public String getAvgStayDys() {
		return this.avgStayDys;
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
	 * @param staySmryDt
	 */
	public void setStaySmryDt(String staySmryDt) {
		this.staySmryDt = staySmryDt;
	}
	
	/**
	 * Column Info
	 * @param dwUpdDt
	 */
	public void setDwUpdDt(String dwUpdDt) {
		this.dwUpdDt = dwUpdDt;
	}
	
	/**
	 * Column Info
	 * @param cntrFullFlg
	 */
	public void setCntrFullFlg(String cntrFullFlg) {
		this.cntrFullFlg = cntrFullFlg;
	}
	
	/**
	 * Column Info
	 * @param nisEvntDt
	 */
	public void setNisEvntDt(String nisEvntDt) {
		this.nisEvntDt = nisEvntDt;
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
	 * @param cntrKntQty
	 */
	public void setCntrKntQty(String cntrKntQty) {
		this.cntrKntQty = cntrKntQty;
	}
	
	/**
	 * Column Info
	 * @param ttlStayDys
	 */
	public void setTtlStayDys(String ttlStayDys) {
		this.ttlStayDys = ttlStayDys;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param avgStayDys
	 */
	public void setAvgStayDys(String avgStayDys) {
		this.avgStayDys = avgStayDys;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setStaySmryDt(JSPUtil.getParameter(request, "stay_smry_dt", ""));
		setDwUpdDt(JSPUtil.getParameter(request, "dw_upd_dt", ""));
		setCntrFullFlg(JSPUtil.getParameter(request, "cntr_full_flg", ""));
		setNisEvntDt(JSPUtil.getParameter(request, "nis_evnt_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCntrKntQty(JSPUtil.getParameter(request, "cntr_knt_qty", ""));
		setTtlStayDys(JSPUtil.getParameter(request, "ttl_stay_dys", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, "cntr_dmg_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAvgStayDys(JSPUtil.getParameter(request, "avg_stay_dys", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesEqLandStayVO[]
	 */
	public TesEqLandStayVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesEqLandStayVO[]
	 */
	public TesEqLandStayVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesEqLandStayVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] staySmryDt = (JSPUtil.getParameter(request, prefix	+ "stay_smry_dt", length));
			String[] dwUpdDt = (JSPUtil.getParameter(request, prefix	+ "dw_upd_dt", length));
			String[] cntrFullFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_full_flg", length));
			String[] nisEvntDt = (JSPUtil.getParameter(request, prefix	+ "nis_evnt_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntrKntQty = (JSPUtil.getParameter(request, prefix	+ "cntr_knt_qty", length));
			String[] ttlStayDys = (JSPUtil.getParameter(request, prefix	+ "ttl_stay_dys", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] avgStayDys = (JSPUtil.getParameter(request, prefix	+ "avg_stay_dys", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesEqLandStayVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (staySmryDt[i] != null)
					model.setStaySmryDt(staySmryDt[i]);
				if (dwUpdDt[i] != null)
					model.setDwUpdDt(dwUpdDt[i]);
				if (cntrFullFlg[i] != null)
					model.setCntrFullFlg(cntrFullFlg[i]);
				if (nisEvntDt[i] != null)
					model.setNisEvntDt(nisEvntDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntrKntQty[i] != null)
					model.setCntrKntQty(cntrKntQty[i]);
				if (ttlStayDys[i] != null)
					model.setTtlStayDys(ttlStayDys[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (avgStayDys[i] != null)
					model.setAvgStayDys(avgStayDys[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesEqLandStayVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesEqLandStayVO[]
	 */
	public TesEqLandStayVO[] getTesEqLandStayVOs(){
		TesEqLandStayVO[] vos = (TesEqLandStayVO[])models.toArray(new TesEqLandStayVO[models.size()]);
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
		this.staySmryDt = this.staySmryDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwUpdDt = this.dwUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFullFlg = this.cntrFullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nisEvntDt = this.nisEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrKntQty = this.cntrKntQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlStayDys = this.ttlStayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgStayDys = this.avgStayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
