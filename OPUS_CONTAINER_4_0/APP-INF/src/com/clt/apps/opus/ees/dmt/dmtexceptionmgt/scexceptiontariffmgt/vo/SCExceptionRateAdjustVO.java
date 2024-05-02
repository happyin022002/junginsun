/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionRateAdjustVO.java
*@FileTitle : SCExceptionRateAdjustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.29  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SCExceptionRateAdjustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SCExceptionRateAdjustVO> models = new ArrayList<SCExceptionRateAdjustVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ftToDys = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String scExptVerSeq = null;
	/* Column Info */
	private String cntrHcRtAmt = null;
	/* Column Info */
	private String cntr20ftRtAmt = null;
	/* Column Info */
	private String cntr45ftRtAmt = null;
	/* Column Info */
	private String scExptGrpSeq = null;
	/* Column Info */
	private String ftFmDys = null;
	/* Column Info */
	private String rtSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntr40ftRtAmt = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SCExceptionRateAdjustVO() {}

	public SCExceptionRateAdjustVO(String ibflag, String pagerows, String propNo, String scExptVerSeq, String scExptGrpSeq, String rtSeq, String ftFmDys, String ftToDys, String cntr20ftRtAmt, String cntr40ftRtAmt, String cntrHcRtAmt, String cntr45ftRtAmt, String creUsrId, String creOfcCd, String creDt, String updUsrId, String updOfcCd, String updDt) {
		this.updDt = updDt;
		this.ftToDys = ftToDys;
		this.creDt = creDt;
		this.scExptVerSeq = scExptVerSeq;
		this.cntrHcRtAmt = cntrHcRtAmt;
		this.cntr20ftRtAmt = cntr20ftRtAmt;
		this.cntr45ftRtAmt = cntr45ftRtAmt;
		this.scExptGrpSeq = scExptGrpSeq;
		this.ftFmDys = ftFmDys;
		this.rtSeq = rtSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.propNo = propNo;
		this.creOfcCd = creOfcCd;
		this.cntr40ftRtAmt = cntr40ftRtAmt;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ft_to_dys", getFtToDys());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sc_expt_ver_seq", getScExptVerSeq());
		this.hashColumns.put("cntr_hc_rt_amt", getCntrHcRtAmt());
		this.hashColumns.put("cntr_20ft_rt_amt", getCntr20ftRtAmt());
		this.hashColumns.put("cntr_45ft_rt_amt", getCntr45ftRtAmt());
		this.hashColumns.put("sc_expt_grp_seq", getScExptGrpSeq());
		this.hashColumns.put("ft_fm_dys", getFtFmDys());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cntr_40ft_rt_amt", getCntr40ftRtAmt());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ft_to_dys", "ftToDys");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sc_expt_ver_seq", "scExptVerSeq");
		this.hashFields.put("cntr_hc_rt_amt", "cntrHcRtAmt");
		this.hashFields.put("cntr_20ft_rt_amt", "cntr20ftRtAmt");
		this.hashFields.put("cntr_45ft_rt_amt", "cntr45ftRtAmt");
		this.hashFields.put("sc_expt_grp_seq", "scExptGrpSeq");
		this.hashFields.put("ft_fm_dys", "ftFmDys");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cntr_40ft_rt_amt", "cntr40ftRtAmt");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
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
	 * @return ftToDys
	 */
	public String getFtToDys() {
		return this.ftToDys;
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
	 * @return scExptVerSeq
	 */
	public String getScExptVerSeq() {
		return this.scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrHcRtAmt
	 */
	public String getCntrHcRtAmt() {
		return this.cntrHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cntr20ftRtAmt
	 */
	public String getCntr20ftRtAmt() {
		return this.cntr20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cntr45ftRtAmt
	 */
	public String getCntr45ftRtAmt() {
		return this.cntr45ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return scExptGrpSeq
	 */
	public String getScExptGrpSeq() {
		return this.scExptGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return ftFmDys
	 */
	public String getFtFmDys() {
		return this.ftFmDys;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
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
	 * @return cntr40ftRtAmt
	 */
	public String getCntr40ftRtAmt() {
		return this.cntr40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @param ftToDys
	 */
	public void setFtToDys(String ftToDys) {
		this.ftToDys = ftToDys;
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
	 * @param scExptVerSeq
	 */
	public void setScExptVerSeq(String scExptVerSeq) {
		this.scExptVerSeq = scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrHcRtAmt
	 */
	public void setCntrHcRtAmt(String cntrHcRtAmt) {
		this.cntrHcRtAmt = cntrHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cntr20ftRtAmt
	 */
	public void setCntr20ftRtAmt(String cntr20ftRtAmt) {
		this.cntr20ftRtAmt = cntr20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cntr45ftRtAmt
	 */
	public void setCntr45ftRtAmt(String cntr45ftRtAmt) {
		this.cntr45ftRtAmt = cntr45ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param scExptGrpSeq
	 */
	public void setScExptGrpSeq(String scExptGrpSeq) {
		this.scExptGrpSeq = scExptGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param ftFmDys
	 */
	public void setFtFmDys(String ftFmDys) {
		this.ftFmDys = ftFmDys;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
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
	 * @param cntr40ftRtAmt
	 */
	public void setCntr40ftRtAmt(String cntr40ftRtAmt) {
		this.cntr40ftRtAmt = cntr40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
		setFtToDys(JSPUtil.getParameter(request, "ft_to_dys", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setScExptVerSeq(JSPUtil.getParameter(request, "sc_expt_ver_seq", ""));
		setCntrHcRtAmt(JSPUtil.getParameter(request, "cntr_hc_rt_amt", ""));
		setCntr20ftRtAmt(JSPUtil.getParameter(request, "cntr_20ft_rt_amt", ""));
		setCntr45ftRtAmt(JSPUtil.getParameter(request, "cntr_45ft_rt_amt", ""));
		setScExptGrpSeq(JSPUtil.getParameter(request, "sc_expt_grp_seq", ""));
		setFtFmDys(JSPUtil.getParameter(request, "ft_fm_dys", ""));
		setRtSeq(JSPUtil.getParameter(request, "rt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCntr40ftRtAmt(JSPUtil.getParameter(request, "cntr_40ft_rt_amt", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SCExceptionRateAdjustVO[]
	 */
	public SCExceptionRateAdjustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SCExceptionRateAdjustVO[]
	 */
	public SCExceptionRateAdjustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SCExceptionRateAdjustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ftToDys = (JSPUtil.getParameter(request, prefix	+ "ft_to_dys", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] scExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_ver_seq", length));
			String[] cntrHcRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_hc_rt_amt", length));
			String[] cntr20ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_20ft_rt_amt", length));
			String[] cntr45ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_45ft_rt_amt", length));
			String[] scExptGrpSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_grp_seq", length));
			String[] ftFmDys = (JSPUtil.getParameter(request, prefix	+ "ft_fm_dys", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntr40ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_40ft_rt_amt", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SCExceptionRateAdjustVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ftToDys[i] != null)
					model.setFtToDys(ftToDys[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (scExptVerSeq[i] != null)
					model.setScExptVerSeq(scExptVerSeq[i]);
				if (cntrHcRtAmt[i] != null)
					model.setCntrHcRtAmt(cntrHcRtAmt[i]);
				if (cntr20ftRtAmt[i] != null)
					model.setCntr20ftRtAmt(cntr20ftRtAmt[i]);
				if (cntr45ftRtAmt[i] != null)
					model.setCntr45ftRtAmt(cntr45ftRtAmt[i]);
				if (scExptGrpSeq[i] != null)
					model.setScExptGrpSeq(scExptGrpSeq[i]);
				if (ftFmDys[i] != null)
					model.setFtFmDys(ftFmDys[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntr40ftRtAmt[i] != null)
					model.setCntr40ftRtAmt(cntr40ftRtAmt[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSCExceptionRateAdjustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SCExceptionRateAdjustVO[]
	 */
	public SCExceptionRateAdjustVO[] getSCExceptionRateAdjustVOs(){
		SCExceptionRateAdjustVO[] vos = (SCExceptionRateAdjustVO[])models.toArray(new SCExceptionRateAdjustVO[models.size()]);
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
		this.ftToDys = this.ftToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptVerSeq = this.scExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHcRtAmt = this.cntrHcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20ftRtAmt = this.cntr20ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr45ftRtAmt = this.cntr45ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptGrpSeq = this.scExptGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftFmDys = this.ftFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr40ftRtAmt = this.cntr40ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
