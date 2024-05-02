/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MisUseContainerInfoVO.java
*@FileTitle : MisUseContainerInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo;

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
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MisUseContainerInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<MisUseContainerInfoVO> models = new ArrayList<MisUseContainerInfoVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String pdmAmt = null;
	/* Column Info */
	private String lonAmt = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public MisUseContainerInfoVO() {}

	public MisUseContainerInfoVO(String ibflag, String pagerows, String mvmtStsCd, String podCd, String polCd, String pdmAmt, String lonAmt, String cntrNo, String agmtCtyCd, String agmtSeq, String cntrTpszCd, String lstmCd, String cnmvDt, String crntYdCd) {
		this.ibflag = ibflag;
		this.cnmvDt = cnmvDt;
		this.agmtSeq = agmtSeq;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.agmtCtyCd = agmtCtyCd;
		this.crntYdCd = crntYdCd;
		this.lstmCd = lstmCd;
		this.pdmAmt = pdmAmt;
		this.lonAmt = lonAmt;
		this.mvmtStsCd = mvmtStsCd;
		this.podCd = podCd;
		this.polCd = polCd;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("pdm_amt", getPdmAmt());
		this.hashColumns.put("lon_amt", getLonAmt());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("pdm_amt", "pdmAmt");
		this.hashFields.put("lon_amt", "lonAmt");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return cnmvDt
	 */
	public String getCnmvDt() {
		return this.cnmvDt;
	}

	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}

	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}

	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * @param cnmvDt
	 */
	public void setCnmvDt(String cnmvDt) {
		this.cnmvDt = cnmvDt;
	}

	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}

	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * @return the pdmAmt
	 */
	public String getPdmAmt() {
		return pdmAmt;
	}

	/**
	 * @param pdmAmt the pdmAmt to set
	 */
	public void setPdmAmt(String pdmAmt) {
		this.pdmAmt = pdmAmt;
	}

	/**
	 * @return the lonAmt
	 */
	public String getLonAmt() {
		return lonAmt;
	}

	/**
	 * @param lonAmt the lonAmt to set
	 */
	public void setLonAmt(String lonAmt) {
		this.lonAmt = lonAmt;
	}

	/**
	 * @return the mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return mvmtStsCd;
	}

	/**
	 * @param mvmtStsCd the mvmtStsCd to set
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}

	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	/**
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * @return the polCd
	 */
	public String getPolCd() {
		return polCd;
	}

	/**
	 * @param polCd the polCd to set
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnmvDt(JSPUtil.getParameter(request, "cnmv_dt", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setPdmAmt(JSPUtil.getParameter(request, "pdm_amt", ""));
		setLonAmt(JSPUtil.getParameter(request, "lon_amt", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MisUseContainerInfoVO[]
	 */
	public MisUseContainerInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return MisUseContainerInfoVO[]
	 */
	public MisUseContainerInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MisUseContainerInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] pdmAmt = (JSPUtil.getParameter(request, prefix	+ "pdm_amt", length));
			String[] lonAmt = (JSPUtil.getParameter(request, prefix	+ "lon_amt", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new MisUseContainerInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (pdmAmt[i] != null)
					model.setPdmAmt(pdmAmt[i]);
				if (lonAmt[i] != null)
					model.setLonAmt(lonAmt[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMisUseReqContainerInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MisUseContainerInfoVO[]
	 */
	public MisUseContainerInfoVO[] getMisUseReqContainerInfoVOs(){
		MisUseContainerInfoVO[] vos = (MisUseContainerInfoVO[])models.toArray(new MisUseContainerInfoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdmAmt = this.pdmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lonAmt = this.lonAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
