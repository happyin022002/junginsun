/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IdaDoRlseListVO.java
*@FileTitle : IdaDoRlseListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.08.18 박만건 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.07.23 김보배 [CHM-201219143] [BKG] India Cargo Release Performance 기능 보완 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IdaDoRlseListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IdaDoRlseListVO> models = new ArrayList<IdaDoRlseListVO>();
	
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String dmdtPayTpCdDesc = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String doNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String dmdtPayTpCd = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String doVtyDt = null;
	/* Column Info */
	private String hblNo = null;
	/* Column Info */
	private String rcvrCneeNm = null;
	/* Column Info */
	private String rcvrCoNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IdaDoRlseListVO() {}

	public IdaDoRlseListVO(String ibflag, String pagerows, String dmdtPayTpCd, String dmdtPayTpCdDesc, String blNo, String cntrNo, String podCd, String delCd, String doNo, String evntDt, String evntOfcCd, String evntUsrId, String rowCount, String doVtyDt, String hblNo, String rcvrCneeNm, String rcvrCoNm) {
		this.evntOfcCd = evntOfcCd;
		this.dmdtPayTpCdDesc = dmdtPayTpCdDesc;
		this.delCd = delCd;
		this.rowCount = rowCount;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.doNo = doNo;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.evntUsrId = evntUsrId;
		this.dmdtPayTpCd = dmdtPayTpCd;
		this.evntDt = evntDt;
		this.doVtyDt = doVtyDt;
		this.hblNo = hblNo;
		this.rcvrCneeNm = rcvrCneeNm;
		this.rcvrCoNm = rcvrCoNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("dmdt_pay_tp_cd_desc", getDmdtPayTpCdDesc());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("dmdt_pay_tp_cd", getDmdtPayTpCd());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("do_vty_dt", getDoVtyDt());
		this.hashColumns.put("hbl_no", getHblNo());
		this.hashColumns.put("rcvr_cnee_nm", getRcvrCneeNm());
		this.hashColumns.put("rcvr_co_nm", getRcvrCoNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("dmdt_pay_tp_cd_desc", "dmdtPayTpCdDesc");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("dmdt_pay_tp_cd", "dmdtPayTpCd");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("do_vty_dt", "doVtyDt");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("rcvr_cnee_nm", "rcvrCneeNm");
		this.hashFields.put("rcvr_co_nm", "rcvrCoNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayTpCdDesc
	 */
	public String getDmdtPayTpCdDesc() {
		return this.dmdtPayTpCdDesc;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayTpCd
	 */
	public String getDmdtPayTpCd() {
		return this.dmdtPayTpCd;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	
	
	/**
	 * Column Info
	 * @return doVtyDt
	 */
	public String getDoVtyDt() {
		return this.doVtyDt;
	}
	
	/**
	 * Column Info
	 * @return hblNo
	 */
	public String getHblNo() {
		return this.hblNo;
	}
	
	/**
	 * Column Info
	 * @return rcvrCneeNm
	 */
	public String getRcvrCneeNm() {
		return this.rcvrCneeNm;
	}
	
	/**
	 * Column Info
	 * @return rcvrCoNm
	 */
	public String getRcvrCoNm() {
		return this.rcvrCoNm;
	}
	

	/**
	 * Column Info
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayTpCdDesc
	 */
	public void setDmdtPayTpCdDesc(String dmdtPayTpCdDesc) {
		this.dmdtPayTpCdDesc = dmdtPayTpCdDesc;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayTpCd
	 */
	public void setDmdtPayTpCd(String dmdtPayTpCd) {
		this.dmdtPayTpCd = dmdtPayTpCd;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Column Info
	 * @param doVtyDt
	 */
	public void setDoVtyDt (String doVtyDt) {
		this.doVtyDt = doVtyDt;
	}
	
	/**
	 * Column Info
	 * @param hblNo
	 */
	public void setHblNo (String hblNo) {
		this.hblNo = hblNo;
	}
	
	/**
	 * Column Info
	 * @param rcvrCneeNm
	 */
	public void setRcvrCneeNm (String rcvrCneeNm) {
		this.rcvrCneeNm = rcvrCneeNm;
	}
	
	/**
	 * Column Info
	 * @param rcvrCoNm
	 */
	public void setRcvrCoNm (String rcvrCoNm) {
		this.rcvrCoNm = rcvrCoNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setDmdtPayTpCdDesc(JSPUtil.getParameter(request, "dmdt_pay_tp_cd_desc", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setRowCount(JSPUtil.getParameter(request, "row_count", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setDmdtPayTpCd(JSPUtil.getParameter(request, "dmdt_pay_tp_cd", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setEvntDt(JSPUtil.getParameter(request, "do_vty_dt", ""));
		
		setHblNo(JSPUtil.getParameter(request, "hbl_no", ""));
		setRcvrCneeNm(JSPUtil.getParameter(request, "rcvr_cnee_nm", ""));
		setRcvrCoNm(JSPUtil.getParameter(request, "rcvr_co_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IdaDoRlseListVO[]
	 */
	public IdaDoRlseListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IdaDoRlseListVO[]
	 */
	public IdaDoRlseListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IdaDoRlseListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] dmdtPayTpCdDesc = (JSPUtil.getParameter(request, prefix	+ "dmdt_pay_tp_cd_desc", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] dmdtPayTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_pay_tp_cd", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] doVtyDt = (JSPUtil.getParameter(request, prefix	+ "do_vty_dt", length));
			String[] hblNo = (JSPUtil.getParameter(request, prefix	+ "hbl_no", length));
			String[] rcvrCneeNm = (JSPUtil.getParameter(request, prefix	+ "rcvr_cnee_nm", length));
			String[] rcvrCoNm = (JSPUtil.getParameter(request, prefix	+ "rcvr_co_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new IdaDoRlseListVO();
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (dmdtPayTpCdDesc[i] != null)
					model.setDmdtPayTpCdDesc(dmdtPayTpCdDesc[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (dmdtPayTpCd[i] != null)
					model.setDmdtPayTpCd(dmdtPayTpCd[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (doVtyDt[i] != null)
					model.setDoVtyDt(doVtyDt[i]);
				
				if (hblNo[i] != null)
					model.setHblNo(hblNo[i]);
				if (rcvrCneeNm[i] != null)
					model.setRcvrCneeNm(rcvrCneeNm[i]);
				if (rcvrCoNm[i] != null)
					model.setRcvrCoNm(rcvrCoNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIdaDoRlseListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IdaDoRlseListVO[]
	 */
	public IdaDoRlseListVO[] getIdaDoRlseListVOs(){
		IdaDoRlseListVO[] vos = (IdaDoRlseListVO[])models.toArray(new IdaDoRlseListVO[models.size()]);
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
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayTpCdDesc = this.dmdtPayTpCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayTpCd = this.dmdtPayTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doVtyDt = this.doVtyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.hblNo = this.hblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCneeNm = this.rcvrCneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCoNm = this.rcvrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
