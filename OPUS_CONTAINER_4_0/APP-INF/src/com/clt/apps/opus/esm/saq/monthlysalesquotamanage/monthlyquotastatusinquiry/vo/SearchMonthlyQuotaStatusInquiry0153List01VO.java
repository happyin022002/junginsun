/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyQuotaStatusInquiry0153List01VO.java
*@FileTitle : SearchMonthlyQuotaStatusInquiry0153List01VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.24 주선영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.vo;

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
 * @author 주선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaStatusInquiry0153List01VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaStatusInquiry0153List01VO> models = new ArrayList<SearchMonthlyQuotaStatusInquiry0153List01VO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String mqtaVerGrpNo = null;
	/* Column Info */
	private String subOfcCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String stage = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String version = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String filter1 = null;
	/* Column Info */
	private String prOfcCd = null;
	/* Column Info */
	private String filter3 = null;
	/* Column Info */
	private String grpStatus = null;
	/* Column Info */
	private String filter2 = null;
	/* Column Info */
	private String filter4 = null;
	/* Column Info */
	private String step = null;
	/* Column Info */
	private String mqtaVerNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaStatusInquiry0153List01VO() {}

	public SearchMonthlyQuotaStatusInquiry0153List01VO(String ibflag, String pagerows, String step, String seq, String stage, String grpStatus, String filter1, String filter2, String filter3, String filter4, String prOfcCd, String subOfcCd, String version, String updDt, String bseYr, String bseQtrCd, String mqtaVerGrpNo, String status, String mqtaVerNo) {
		this.updDt = updDt;
		this.status = status;
		this.mqtaVerGrpNo = mqtaVerGrpNo;
		this.subOfcCd = subOfcCd;
		this.bseYr = bseYr;
		this.stage = stage;
		this.pagerows = pagerows;
		this.version = version;
		this.bseQtrCd = bseQtrCd;
		this.ibflag = ibflag;
		this.seq = seq;
		this.filter1 = filter1;
		this.prOfcCd = prOfcCd;
		this.filter3 = filter3;
		this.grpStatus = grpStatus;
		this.filter2 = filter2;
		this.filter4 = filter4;
		this.step = step;
		this.mqtaVerNo = mqtaVerNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("mqta_ver_grp_no", getMqtaVerGrpNo());
		this.hashColumns.put("sub_ofc_cd", getSubOfcCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("stage", getStage());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("version", getVersion());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("filter1", getFilter1());
		this.hashColumns.put("pr_ofc_cd", getPrOfcCd());
		this.hashColumns.put("filter3", getFilter3());
		this.hashColumns.put("grp_status", getGrpStatus());
		this.hashColumns.put("filter2", getFilter2());
		this.hashColumns.put("filter4", getFilter4());
		this.hashColumns.put("step", getStep());
		this.hashColumns.put("mqta_ver_no", getMqtaVerNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("status", "status");
		this.hashFields.put("mqta_ver_grp_no", "mqtaVerGrpNo");
		this.hashFields.put("sub_ofc_cd", "subOfcCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("stage", "stage");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("version", "version");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("filter1", "filter1");
		this.hashFields.put("pr_ofc_cd", "prOfcCd");
		this.hashFields.put("filter3", "filter3");
		this.hashFields.put("grp_status", "grpStatus");
		this.hashFields.put("filter2", "filter2");
		this.hashFields.put("filter4", "filter4");
		this.hashFields.put("step", "step");
		this.hashFields.put("mqta_ver_no", "mqtaVerNo");
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
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return mqtaVerGrpNo
	 */
	public String getMqtaVerGrpNo() {
		return this.mqtaVerGrpNo;
	}
	
	/**
	 * Column Info
	 * @return subOfcCd
	 */
	public String getSubOfcCd() {
		return this.subOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return stage
	 */
	public String getStage() {
		return this.stage;
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
	 * @return version
	 */
	public String getVersion() {
		return this.version;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return filter1
	 */
	public String getFilter1() {
		return this.filter1;
	}
	
	/**
	 * Column Info
	 * @return prOfcCd
	 */
	public String getPrOfcCd() {
		return this.prOfcCd;
	}
	
	/**
	 * Column Info
	 * @return filter3
	 */
	public String getFilter3() {
		return this.filter3;
	}
	
	/**
	 * Column Info
	 * @return grpStatus
	 */
	public String getGrpStatus() {
		return this.grpStatus;
	}
	
	/**
	 * Column Info
	 * @return filter2
	 */
	public String getFilter2() {
		return this.filter2;
	}
	
	/**
	 * Column Info
	 * @return filter4
	 */
	public String getFilter4() {
		return this.filter4;
	}
	
	/**
	 * Column Info
	 * @return step
	 */
	public String getStep() {
		return this.step;
	}
	
	/**
	 * Column Info
	 * @return mqtaVerNo
	 */
	public String getMqtaVerNo() {
		return this.mqtaVerNo;
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
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param mqtaVerGrpNo
	 */
	public void setMqtaVerGrpNo(String mqtaVerGrpNo) {
		this.mqtaVerGrpNo = mqtaVerGrpNo;
	}
	
	/**
	 * Column Info
	 * @param subOfcCd
	 */
	public void setSubOfcCd(String subOfcCd) {
		this.subOfcCd = subOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param stage
	 */
	public void setStage(String stage) {
		this.stage = stage;
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
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param filter1
	 */
	public void setFilter1(String filter1) {
		this.filter1 = filter1;
	}
	
	/**
	 * Column Info
	 * @param prOfcCd
	 */
	public void setPrOfcCd(String prOfcCd) {
		this.prOfcCd = prOfcCd;
	}
	
	/**
	 * Column Info
	 * @param filter3
	 */
	public void setFilter3(String filter3) {
		this.filter3 = filter3;
	}
	
	/**
	 * Column Info
	 * @param grpStatus
	 */
	public void setGrpStatus(String grpStatus) {
		this.grpStatus = grpStatus;
	}
	
	/**
	 * Column Info
	 * @param filter2
	 */
	public void setFilter2(String filter2) {
		this.filter2 = filter2;
	}
	
	/**
	 * Column Info
	 * @param filter4
	 */
	public void setFilter4(String filter4) {
		this.filter4 = filter4;
	}
	
	/**
	 * Column Info
	 * @param step
	 */
	public void setStep(String step) {
		this.step = step;
	}
	
	/**
	 * Column Info
	 * @param mqtaVerNo
	 */
	public void setMqtaVerNo(String mqtaVerNo) {
		this.mqtaVerNo = mqtaVerNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setMqtaVerGrpNo(JSPUtil.getParameter(request, "mqta_ver_grp_no", ""));
		setSubOfcCd(JSPUtil.getParameter(request, "sub_ofc_cd", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setStage(JSPUtil.getParameter(request, "stage", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVersion(JSPUtil.getParameter(request, "version", ""));
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFilter1(JSPUtil.getParameter(request, "filter1", ""));
		setPrOfcCd(JSPUtil.getParameter(request, "pr_ofc_cd", ""));
		setFilter3(JSPUtil.getParameter(request, "filter3", ""));
		setGrpStatus(JSPUtil.getParameter(request, "grp_status", ""));
		setFilter2(JSPUtil.getParameter(request, "filter2", ""));
		setFilter4(JSPUtil.getParameter(request, "filter4", ""));
		setStep(JSPUtil.getParameter(request, "step", ""));
		setMqtaVerNo(JSPUtil.getParameter(request, "mqta_ver_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaStatusInquiry0153List01VO[]
	 */
	public SearchMonthlyQuotaStatusInquiry0153List01VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaStatusInquiry0153List01VO[]
	 */
	public SearchMonthlyQuotaStatusInquiry0153List01VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaStatusInquiry0153List01VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] mqtaVerGrpNo = (JSPUtil.getParameter(request, prefix	+ "mqta_ver_grp_no", length));
			String[] subOfcCd = (JSPUtil.getParameter(request, prefix	+ "sub_ofc_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] stage = (JSPUtil.getParameter(request, prefix	+ "stage", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] version = (JSPUtil.getParameter(request, prefix	+ "version", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] filter1 = (JSPUtil.getParameter(request, prefix	+ "filter1", length));
			String[] prOfcCd = (JSPUtil.getParameter(request, prefix	+ "pr_ofc_cd", length));
			String[] filter3 = (JSPUtil.getParameter(request, prefix	+ "filter3", length));
			String[] grpStatus = (JSPUtil.getParameter(request, prefix	+ "grp_status", length));
			String[] filter2 = (JSPUtil.getParameter(request, prefix	+ "filter2", length));
			String[] filter4 = (JSPUtil.getParameter(request, prefix	+ "filter4", length));
			String[] step = (JSPUtil.getParameter(request, prefix	+ "step", length));
			String[] mqtaVerNo = (JSPUtil.getParameter(request, prefix	+ "mqta_ver_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaStatusInquiry0153List01VO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (mqtaVerGrpNo[i] != null)
					model.setMqtaVerGrpNo(mqtaVerGrpNo[i]);
				if (subOfcCd[i] != null)
					model.setSubOfcCd(subOfcCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (stage[i] != null)
					model.setStage(stage[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (version[i] != null)
					model.setVersion(version[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (filter1[i] != null)
					model.setFilter1(filter1[i]);
				if (prOfcCd[i] != null)
					model.setPrOfcCd(prOfcCd[i]);
				if (filter3[i] != null)
					model.setFilter3(filter3[i]);
				if (grpStatus[i] != null)
					model.setGrpStatus(grpStatus[i]);
				if (filter2[i] != null)
					model.setFilter2(filter2[i]);
				if (filter4[i] != null)
					model.setFilter4(filter4[i]);
				if (step[i] != null)
					model.setStep(step[i]);
				if (mqtaVerNo[i] != null)
					model.setMqtaVerNo(mqtaVerNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaStatusInquiry0153List01VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaStatusInquiry0153List01VO[]
	 */
	public SearchMonthlyQuotaStatusInquiry0153List01VO[] getSearchMonthlyQuotaStatusInquiry0153List01VOs(){
		SearchMonthlyQuotaStatusInquiry0153List01VO[] vos = (SearchMonthlyQuotaStatusInquiry0153List01VO[])models.toArray(new SearchMonthlyQuotaStatusInquiry0153List01VO[models.size()]);
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
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaVerGrpNo = this.mqtaVerGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOfcCd = this.subOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stage = this.stage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.version = this.version .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filter1 = this.filter1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prOfcCd = this.prOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filter3 = this.filter3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpStatus = this.grpStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filter2 = this.filter2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filter4 = this.filter4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.step = this.step .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaVerNo = this.mqtaVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
