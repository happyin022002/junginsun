/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CalculationParmVO.java
*@FileTitle : CalculationParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.07.17 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CalculationParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CalculationParmVO> models = new ArrayList<CalculationParmVO>();
	
	/* Column Info */
	private String curCd = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String overDay = null;
	/* Column Info */
	private String divOverDay = null;
	/* Column Info */
	private String scVerSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dcApplRate = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String grpSeq = null;
	/* Column Info */
	private String cntrts = null;
	/* Column Info */
	private String mapgSeq = null;
	/* Column Info */
	private String cmbSeq = null;
	/* Column Info */
	private String dtlSeq = null;
	/* Column Info */
	private String trfGrpSeq = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String trfSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CalculationParmVO() {}

	public CalculationParmVO(String ibflag, String pagerows, String svrId, String dmdtTrfCd, String trfSeq, String trfGrpSeq, String propNo, String scVerSeq, String grpSeq, String darNo, String mapgSeq, String verSeq, String dtlSeq, String cmbSeq, String cntrts, String overDay, String divOverDay, String dcApplRate, String curCd) {
		this.curCd = curCd;
		this.darNo = darNo;
		this.overDay = overDay;
		this.divOverDay = divOverDay;
		this.scVerSeq = scVerSeq;
		this.pagerows = pagerows;
		this.verSeq = verSeq;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.dcApplRate = dcApplRate;
		this.propNo = propNo;
		this.grpSeq = grpSeq;
		this.cntrts = cntrts;
		this.mapgSeq = mapgSeq;
		this.cmbSeq = cmbSeq;
		this.dtlSeq = dtlSeq;
		this.trfGrpSeq = trfGrpSeq;
		this.dmdtTrfCd = dmdtTrfCd;
		this.trfSeq = trfSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cur_cd", getCurCd());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("over_day", getOverDay());
		this.hashColumns.put("div_over_day", getDivOverDay());
		this.hashColumns.put("sc_ver_seq", getScVerSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dc_appl_rate", getDcApplRate());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("grp_seq", getGrpSeq());
		this.hashColumns.put("cntrts", getCntrts());
		this.hashColumns.put("mapg_seq", getMapgSeq());
		this.hashColumns.put("cmb_seq", getCmbSeq());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("trf_seq", getTrfSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cur_cd", "curCd");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("over_day", "overDay");
		this.hashFields.put("div_over_day", "divOverDay");
		this.hashFields.put("sc_ver_seq", "scVerSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dc_appl_rate", "dcApplRate");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("grp_seq", "grpSeq");
		this.hashFields.put("cntrts", "cntrts");
		this.hashFields.put("mapg_seq", "mapgSeq");
		this.hashFields.put("cmb_seq", "cmbSeq");
		this.hashFields.put("dtl_seq", "dtlSeq");
		this.hashFields.put("trf_grp_seq", "trfGrpSeq");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("trf_seq", "trfSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return curCd
	 */
	public String getCurCd() {
		return this.curCd;
	}
	
	/**
	 * Column Info
	 * @return darNo
	 */
	public String getDarNo() {
		return this.darNo;
	}
	
	/**
	 * Column Info
	 * @return overDay
	 */
	public String getOverDay() {
		return this.overDay;
	}
	
	/**
	 * Column Info
	 * @return divOverDay
	 */
	public String getDivOverDay() {
		return this.divOverDay;
	}
	
	/**
	 * Column Info
	 * @return scVerSeq
	 */
	public String getScVerSeq() {
		return this.scVerSeq;
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
	 * @return verSeq
	 */
	public String getVerSeq() {
		return this.verSeq;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return dcApplRate
	 */
	public String getDcApplRate() {
		return this.dcApplRate;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return grpSeq
	 */
	public String getGrpSeq() {
		return this.grpSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrts
	 */
	public String getCntrts() {
		return this.cntrts;
	}
	
	/**
	 * Column Info
	 * @return mapgSeq
	 */
	public String getMapgSeq() {
		return this.mapgSeq;
	}
	
	/**
	 * Column Info
	 * @return cmbSeq
	 */
	public String getCmbSeq() {
		return this.cmbSeq;
	}
	
	/**
	 * Column Info
	 * @return dtlSeq
	 */
	public String getDtlSeq() {
		return this.dtlSeq;
	}
	
	/**
	 * Column Info
	 * @return trfGrpSeq
	 */
	public String getTrfGrpSeq() {
		return this.trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return trfSeq
	 */
	public String getTrfSeq() {
		return this.trfSeq;
	}
	

	/**
	 * Column Info
	 * @param curCd
	 */
	public void setCurCd(String curCd) {
		this.curCd = curCd;
	}
	
	/**
	 * Column Info
	 * @param darNo
	 */
	public void setDarNo(String darNo) {
		this.darNo = darNo;
	}
	
	/**
	 * Column Info
	 * @param overDay
	 */
	public void setOverDay(String overDay) {
		this.overDay = overDay;
	}
	
	/**
	 * Column Info
	 * @param divOverDay
	 */
	public void setDivOverDay(String divOverDay) {
		this.divOverDay = divOverDay;
	}
	
	/**
	 * Column Info
	 * @param scVerSeq
	 */
	public void setScVerSeq(String scVerSeq) {
		this.scVerSeq = scVerSeq;
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
	 * @param verSeq
	 */
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param dcApplRate
	 */
	public void setDcApplRate(String dcApplRate) {
		this.dcApplRate = dcApplRate;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param grpSeq
	 */
	public void setGrpSeq(String grpSeq) {
		this.grpSeq = grpSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrts
	 */
	public void setCntrts(String cntrts) {
		this.cntrts = cntrts;
	}
	
	/**
	 * Column Info
	 * @param mapgSeq
	 */
	public void setMapgSeq(String mapgSeq) {
		this.mapgSeq = mapgSeq;
	}
	
	/**
	 * Column Info
	 * @param cmbSeq
	 */
	public void setCmbSeq(String cmbSeq) {
		this.cmbSeq = cmbSeq;
	}
	
	/**
	 * Column Info
	 * @param dtlSeq
	 */
	public void setDtlSeq(String dtlSeq) {
		this.dtlSeq = dtlSeq;
	}
	
	/**
	 * Column Info
	 * @param trfGrpSeq
	 */
	public void setTrfGrpSeq(String trfGrpSeq) {
		this.trfGrpSeq = trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param trfSeq
	 */
	public void setTrfSeq(String trfSeq) {
		this.trfSeq = trfSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurCd(JSPUtil.getParameter(request, "cur_cd", ""));
		setDarNo(JSPUtil.getParameter(request, "dar_no", ""));
		setOverDay(JSPUtil.getParameter(request, "over_day", ""));
		setDivOverDay(JSPUtil.getParameter(request, "div_over_day", ""));
		setScVerSeq(JSPUtil.getParameter(request, "sc_ver_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVerSeq(JSPUtil.getParameter(request, "ver_seq", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDcApplRate(JSPUtil.getParameter(request, "dc_appl_rate", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setGrpSeq(JSPUtil.getParameter(request, "grp_seq", ""));
		setCntrts(JSPUtil.getParameter(request, "cntrts", ""));
		setMapgSeq(JSPUtil.getParameter(request, "mapg_seq", ""));
		setCmbSeq(JSPUtil.getParameter(request, "cmb_seq", ""));
		setDtlSeq(JSPUtil.getParameter(request, "dtl_seq", ""));
		setTrfGrpSeq(JSPUtil.getParameter(request, "trf_grp_seq", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setTrfSeq(JSPUtil.getParameter(request, "trf_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CalculationParmVO[]
	 */
	public CalculationParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CalculationParmVO[]
	 */
	public CalculationParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CalculationParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] curCd = (JSPUtil.getParameter(request, prefix	+ "cur_cd", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] overDay = (JSPUtil.getParameter(request, prefix	+ "over_day", length));
			String[] divOverDay = (JSPUtil.getParameter(request, prefix	+ "div_over_day", length));
			String[] scVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_ver_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dcApplRate = (JSPUtil.getParameter(request, prefix	+ "dc_appl_rate", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] grpSeq = (JSPUtil.getParameter(request, prefix	+ "grp_seq", length));
			String[] cntrts = (JSPUtil.getParameter(request, prefix	+ "cntrts", length));
			String[] mapgSeq = (JSPUtil.getParameter(request, prefix	+ "mapg_seq", length));
			String[] cmbSeq = (JSPUtil.getParameter(request, prefix	+ "cmb_seq", length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq", length));
			String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "trf_grp_seq", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] trfSeq = (JSPUtil.getParameter(request, prefix	+ "trf_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new CalculationParmVO();
				if (curCd[i] != null)
					model.setCurCd(curCd[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (overDay[i] != null)
					model.setOverDay(overDay[i]);
				if (divOverDay[i] != null)
					model.setDivOverDay(divOverDay[i]);
				if (scVerSeq[i] != null)
					model.setScVerSeq(scVerSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dcApplRate[i] != null)
					model.setDcApplRate(dcApplRate[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (grpSeq[i] != null)
					model.setGrpSeq(grpSeq[i]);
				if (cntrts[i] != null)
					model.setCntrts(cntrts[i]);
				if (mapgSeq[i] != null)
					model.setMapgSeq(mapgSeq[i]);
				if (cmbSeq[i] != null)
					model.setCmbSeq(cmbSeq[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				if (trfGrpSeq[i] != null)
					model.setTrfGrpSeq(trfGrpSeq[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (trfSeq[i] != null)
					model.setTrfSeq(trfSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCalculationParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CalculationParmVO[]
	 */
	public CalculationParmVO[] getCalculationParmVOs(){
		CalculationParmVO[] vos = (CalculationParmVO[])models.toArray(new CalculationParmVO[models.size()]);
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
		this.curCd = this.curCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDay = this.overDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divOverDay = this.divOverDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scVerSeq = this.scVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcApplRate = this.dcApplRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSeq = this.grpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrts = this.cntrts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgSeq = this.mapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbSeq = this.cmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfGrpSeq = this.trfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfSeq = this.trfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
