/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSpInqVO.java
*@FileTitle : RsltPriSpInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.28 공백진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSpInqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSpInqVO> models = new ArrayList<RsltPriSpInqVO>();
	
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String propSrepCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String propMqcQty = null;
	/* Column Info */
	private String cntrLodUtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String propStsNm = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String propStsCd = null;
	/* Column Info */
	private String unitNm = null;
	/* Column Info */
	private String expDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSpInqVO() {}

	public RsltPriSpInqVO(String ibflag, String pagerows, String scNo, String amdtSeq, String propNo, String ctrtPtyNm, String propOfcCd, String propSrepCd, String srepNm, String propMqcQty, String cntrLodUtCd, String unitNm, String creDt, String effDt, String expDt, String fileDt, String propStsCd, String propStsNm) {
		this.fileDt = fileDt;
		this.propSrepCd = propSrepCd;
		this.amdtSeq = amdtSeq;
		this.creDt = creDt;
		this.propMqcQty = propMqcQty;
		this.cntrLodUtCd = cntrLodUtCd;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.ctrtPtyNm = ctrtPtyNm;
		this.propStsNm = propStsNm;
		this.propOfcCd = propOfcCd;
		this.propNo = propNo;
		this.scNo = scNo;
		this.srepNm = srepNm;
		this.propStsCd = propStsCd;
		this.unitNm = unitNm;
		this.expDt = expDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("prop_srep_cd", getPropSrepCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("prop_mqc_qty", getPropMqcQty());
		this.hashColumns.put("cntr_lod_ut_cd", getCntrLodUtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("prop_sts_nm", getPropStsNm());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("unit_nm", getUnitNm());
		this.hashColumns.put("exp_dt", getExpDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("prop_srep_cd", "propSrepCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("prop_mqc_qty", "propMqcQty");
		this.hashFields.put("cntr_lod_ut_cd", "cntrLodUtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("prop_sts_nm", "propStsNm");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("unit_nm", "unitNm");
		this.hashFields.put("exp_dt", "expDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return propSrepCd
	 */
	public String getPropSrepCd() {
		return this.propSrepCd;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
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
	 * @return propMqcQty
	 */
	public String getPropMqcQty() {
		return this.propMqcQty;
	}
	
	/**
	 * Column Info
	 * @return cntrLodUtCd
	 */
	public String getCntrLodUtCd() {
		return this.cntrLodUtCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @return propStsNm
	 */
	public String getPropStsNm() {
		return this.propStsNm;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return propStsCd
	 */
	public String getPropStsCd() {
		return this.propStsCd;
	}
	
	/**
	 * Column Info
	 * @return unitNm
	 */
	public String getUnitNm() {
		return this.unitNm;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	

	/**
	 * Column Info
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param propSrepCd
	 */
	public void setPropSrepCd(String propSrepCd) {
		this.propSrepCd = propSrepCd;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
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
	 * @param propMqcQty
	 */
	public void setPropMqcQty(String propMqcQty) {
		this.propMqcQty = propMqcQty;
	}
	
	/**
	 * Column Info
	 * @param cntrLodUtCd
	 */
	public void setCntrLodUtCd(String cntrLodUtCd) {
		this.cntrLodUtCd = cntrLodUtCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @param propStsNm
	 */
	public void setPropStsNm(String propStsNm) {
		this.propStsNm = propStsNm;
	}
	
	/**
	 * Column Info
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param propStsCd
	 */
	public void setPropStsCd(String propStsCd) {
		this.propStsCd = propStsCd;
	}
	
	/**
	 * Column Info
	 * @param unitNm
	 */
	public void setUnitNm(String unitNm) {
		this.unitNm = unitNm;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFileDt(JSPUtil.getParameter(request, "file_dt", ""));
		setPropSrepCd(JSPUtil.getParameter(request, "prop_srep_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPropMqcQty(JSPUtil.getParameter(request, "prop_mqc_qty", ""));
		setCntrLodUtCd(JSPUtil.getParameter(request, "cntr_lod_ut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, "ctrt_pty_nm", ""));
		setPropStsNm(JSPUtil.getParameter(request, "prop_sts_nm", ""));
		setPropOfcCd(JSPUtil.getParameter(request, "prop_ofc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setSrepNm(JSPUtil.getParameter(request, "srep_nm", ""));
		setPropStsCd(JSPUtil.getParameter(request, "prop_sts_cd", ""));
		setUnitNm(JSPUtil.getParameter(request, "unit_nm", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSpInqVO[]
	 */
	public RsltPriSpInqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSpInqVO[]
	 */
	public RsltPriSpInqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSpInqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] propSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_srep_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] propMqcQty = (JSPUtil.getParameter(request, prefix	+ "prop_mqc_qty", length));
			String[] cntrLodUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_lod_ut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] propStsNm = (JSPUtil.getParameter(request, prefix	+ "prop_sts_nm", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] propStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_sts_cd", length));
			String[] unitNm = (JSPUtil.getParameter(request, prefix	+ "unit_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSpInqVO();
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (propSrepCd[i] != null)
					model.setPropSrepCd(propSrepCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (propMqcQty[i] != null)
					model.setPropMqcQty(propMqcQty[i]);
				if (cntrLodUtCd[i] != null)
					model.setCntrLodUtCd(cntrLodUtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (propStsNm[i] != null)
					model.setPropStsNm(propStsNm[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (propStsCd[i] != null)
					model.setPropStsCd(propStsCd[i]);
				if (unitNm[i] != null)
					model.setUnitNm(unitNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSpInqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSpInqVO[]
	 */
	public RsltPriSpInqVO[] getRsltPriSpInqVOs(){
		RsltPriSpInqVO[] vos = (RsltPriSpInqVO[])models.toArray(new RsltPriSpInqVO[models.size()]);
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
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepCd = this.propSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propMqcQty = this.propMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodUtCd = this.cntrLodUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsNm = this.propStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd = this.propStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitNm = this.unitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
