/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrStatusReportListVO.java
*@FileTitle : CntrStatusReportListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.07.15 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrStatusReportListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrStatusReportListVO> models = new ArrayList<CntrStatusReportListVO>();
	
	/* Column Info */
	private String tpSz = null;
	/* Column Info */
	private String lessor = null;
	/* Column Info */
	private String lstYd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String fndDt = null;
	/* Column Info */
	private String lstDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String containerNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String days = null;
	/* Column Info */
	private String fM = null;
	/* Column Info */
	private String preMovemert = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String fndYd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String lessorName = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrStatusReportListVO() {}

	public CntrStatusReportListVO(String ibflag, String pagerows, String cntrNo, String tpSz, String term, String agmtNo, String containerNo, String lessor, String lessorName, String fM, String preMovemert, String lstDt, String lstYd, String fndDt, String fndYd, String days) {
		this.tpSz = tpSz;
		this.lessor = lessor;
		this.lstYd = lstYd;
		this.agmtNo = agmtNo;
		this.fndDt = fndDt;
		this.lstDt = lstDt;
		this.pagerows = pagerows;
		this.containerNo = containerNo;
		this.ibflag = ibflag;
		this.days = days;
		this.fM = fM;
		this.preMovemert = preMovemert;
		this.term = term;
		this.fndYd = fndYd;
		this.cntrNo = cntrNo;
		this.lessorName = lessorName;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tp_sz", getTpSz());
		this.hashColumns.put("lessor", getLessor());
		this.hashColumns.put("lst_yd", getLstYd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("fnd_dt", getFndDt());
		this.hashColumns.put("lst_dt", getLstDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("container_no", getContainerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("days", getDays());
		this.hashColumns.put("f_m", getFM());
		this.hashColumns.put("pre_movemert", getPreMovemert());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("fnd_yd", getFndYd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("lessor_name", getLessorName());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tp_sz", "tpSz");
		this.hashFields.put("lessor", "lessor");
		this.hashFields.put("lst_yd", "lstYd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("fnd_dt", "fndDt");
		this.hashFields.put("lst_dt", "lstDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("container_no", "containerNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("days", "days");
		this.hashFields.put("f_m", "fM");
		this.hashFields.put("pre_movemert", "preMovemert");
		this.hashFields.put("term", "term");
		this.hashFields.put("fnd_yd", "fndYd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("lessor_name", "lessorName");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tpSz
	 */
	public String getTpSz() {
		return this.tpSz;
	}
	
	/**
	 * Column Info
	 * @return lessor
	 */
	public String getLessor() {
		return this.lessor;
	}
	
	/**
	 * Column Info
	 * @return lstYd
	 */
	public String getLstYd() {
		return this.lstYd;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return fndDt
	 */
	public String getFndDt() {
		return this.fndDt;
	}
	
	/**
	 * Column Info
	 * @return lstDt
	 */
	public String getLstDt() {
		return this.lstDt;
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
	 * @return containerNo
	 */
	public String getContainerNo() {
		return this.containerNo;
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
	 * @return days
	 */
	public String getDays() {
		return this.days;
	}
	
	/**
	 * Column Info
	 * @return fM
	 */
	public String getFM() {
		return this.fM;
	}
	
	/**
	 * Column Info
	 * @return preMovemert
	 */
	public String getPreMovemert() {
		return this.preMovemert;
	}
	
	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * Column Info
	 * @return fndYd
	 */
	public String getFndYd() {
		return this.fndYd;
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
	 * @return lessorName
	 */
	public String getLessorName() {
		return this.lessorName;
	}
	

	/**
	 * Column Info
	 * @param tpSz
	 */
	public void setTpSz(String tpSz) {
		this.tpSz = tpSz;
	}
	
	/**
	 * Column Info
	 * @param lessor
	 */
	public void setLessor(String lessor) {
		this.lessor = lessor;
	}
	
	/**
	 * Column Info
	 * @param lstYd
	 */
	public void setLstYd(String lstYd) {
		this.lstYd = lstYd;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param fndDt
	 */
	public void setFndDt(String fndDt) {
		this.fndDt = fndDt;
	}
	
	/**
	 * Column Info
	 * @param lstDt
	 */
	public void setLstDt(String lstDt) {
		this.lstDt = lstDt;
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
	 * @param containerNo
	 */
	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
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
	 * @param days
	 */
	public void setDays(String days) {
		this.days = days;
	}
	
	/**
	 * Column Info
	 * @param fM
	 */
	public void setFM(String fM) {
		this.fM = fM;
	}
	
	/**
	 * Column Info
	 * @param preMovemert
	 */
	public void setPreMovemert(String preMovemert) {
		this.preMovemert = preMovemert;
	}
	
	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	/**
	 * Column Info
	 * @param fndYd
	 */
	public void setFndYd(String fndYd) {
		this.fndYd = fndYd;
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
	 * @param lessorName
	 */
	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTpSz(JSPUtil.getParameter(request, "tp_sz", ""));
		setLessor(JSPUtil.getParameter(request, "lessor", ""));
		setLstYd(JSPUtil.getParameter(request, "lst_yd", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setFndDt(JSPUtil.getParameter(request, "fnd_dt", ""));
		setLstDt(JSPUtil.getParameter(request, "lst_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setContainerNo(JSPUtil.getParameter(request, "container_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDays(JSPUtil.getParameter(request, "days", ""));
		setFM(JSPUtil.getParameter(request, "f_m", ""));
		setPreMovemert(JSPUtil.getParameter(request, "pre_movemert", ""));
		setTerm(JSPUtil.getParameter(request, "term", ""));
		setFndYd(JSPUtil.getParameter(request, "fnd_yd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setLessorName(JSPUtil.getParameter(request, "lessor_name", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrStatusReportListVO[]
	 */
	public CntrStatusReportListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrStatusReportListVO[]
	 */
	public CntrStatusReportListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrStatusReportListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tpSz = (JSPUtil.getParameter(request, prefix	+ "tp_sz", length));
			String[] lessor = (JSPUtil.getParameter(request, prefix	+ "lessor", length));
			String[] lstYd = (JSPUtil.getParameter(request, prefix	+ "lst_yd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] fndDt = (JSPUtil.getParameter(request, prefix	+ "fnd_dt", length));
			String[] lstDt = (JSPUtil.getParameter(request, prefix	+ "lst_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] containerNo = (JSPUtil.getParameter(request, prefix	+ "container_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] days = (JSPUtil.getParameter(request, prefix	+ "days", length));
			String[] fM = (JSPUtil.getParameter(request, prefix	+ "f_m", length));
			String[] preMovemert = (JSPUtil.getParameter(request, prefix	+ "pre_movemert", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] fndYd = (JSPUtil.getParameter(request, prefix	+ "fnd_yd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] lessorName = (JSPUtil.getParameter(request, prefix	+ "lessor_name", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrStatusReportListVO();
				if (tpSz[i] != null)
					model.setTpSz(tpSz[i]);
				if (lessor[i] != null)
					model.setLessor(lessor[i]);
				if (lstYd[i] != null)
					model.setLstYd(lstYd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (fndDt[i] != null)
					model.setFndDt(fndDt[i]);
				if (lstDt[i] != null)
					model.setLstDt(lstDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (containerNo[i] != null)
					model.setContainerNo(containerNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (days[i] != null)
					model.setDays(days[i]);
				if (fM[i] != null)
					model.setFM(fM[i]);
				if (preMovemert[i] != null)
					model.setPreMovemert(preMovemert[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (fndYd[i] != null)
					model.setFndYd(fndYd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (lessorName[i] != null)
					model.setLessorName(lessorName[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrStatusReportListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrStatusReportListVO[]
	 */
	public CntrStatusReportListVO[] getCntrStatusReportListVOs(){
		CntrStatusReportListVO[] vos = (CntrStatusReportListVO[])models.toArray(new CntrStatusReportListVO[models.size()]);
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
		this.tpSz = this.tpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessor = this.lessor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstYd = this.lstYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fndDt = this.fndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDt = this.lstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.containerNo = this.containerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.days = this.days .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fM = this.fM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preMovemert = this.preMovemert .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fndYd = this.fndYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessorName = this.lessorName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
