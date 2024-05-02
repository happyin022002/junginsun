/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrMasterUpdateIFVO.java
*@FileTitle : CntrMasterUpdateIFVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.09.24 이호선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrMasterUpdateIFVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrMasterUpdateIFVO> models = new ArrayList<CntrMasterUpdateIFVO>();
	
	/* Column Info */
	private String lifid = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String ifTtlRowKnt = null;
	/* Column Info */
	private String faEqNo = null;
	/* Column Info */
	private String retAproNo = null;
	/* Column Info */
	private String faIfGrpSeqNo = null;
	/* Column Info */
	private String ifSeq = null;
	/* Column Info */
	private String faIfTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eaiIfNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String faIfStsCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String createdBy = null;
	/* Column Info */
	private String faIfDt = null;
	/* Column Info */
	private String faIfErrMsg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrMasterUpdateIFVO() {}

	public CntrMasterUpdateIFVO(String ibflag, String pagerows, String lifid, String ifTtlRowKnt, String faEqNo, String retAproNo, String faIfGrpSeqNo, String ifSeq, String faIfTpCd, String eaiIfNo, String faIfStsCd, String eqNo, String createdBy, String faIfDt, String faIfErrMsg, String gubun) {
		this.lifid = lifid;
		this.gubun = gubun;
		this.ifTtlRowKnt = ifTtlRowKnt;
		this.faEqNo = faEqNo;
		this.retAproNo = retAproNo;
		this.faIfGrpSeqNo = faIfGrpSeqNo;
		this.ifSeq = ifSeq;
		this.faIfTpCd = faIfTpCd;
		this.pagerows = pagerows;
		this.eaiIfNo = eaiIfNo;
		this.ibflag = ibflag;
		this.faIfStsCd = faIfStsCd;
		this.eqNo = eqNo;
		this.createdBy = createdBy;
		this.faIfDt = faIfDt;
		this.faIfErrMsg = faIfErrMsg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lifid", getLifid());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("if_ttl_row_knt", getIfTtlRowKnt());
		this.hashColumns.put("fa_eq_no", getFaEqNo());
		this.hashColumns.put("ret_apro_no", getRetAproNo());
		this.hashColumns.put("fa_if_grp_seq_no", getFaIfGrpSeqNo());
		this.hashColumns.put("if_seq", getIfSeq());
		this.hashColumns.put("fa_if_tp_cd", getFaIfTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eai_if_no", getEaiIfNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fa_if_sts_cd", getFaIfStsCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("created_by", getCreatedBy());
		this.hashColumns.put("fa_if_dt", getFaIfDt());
		this.hashColumns.put("fa_if_err_msg", getFaIfErrMsg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lifid", "lifid");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("if_ttl_row_knt", "ifTtlRowKnt");
		this.hashFields.put("fa_eq_no", "faEqNo");
		this.hashFields.put("ret_apro_no", "retAproNo");
		this.hashFields.put("fa_if_grp_seq_no", "faIfGrpSeqNo");
		this.hashFields.put("if_seq", "ifSeq");
		this.hashFields.put("fa_if_tp_cd", "faIfTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eai_if_no", "eaiIfNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fa_if_sts_cd", "faIfStsCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("created_by", "createdBy");
		this.hashFields.put("fa_if_dt", "faIfDt");
		this.hashFields.put("fa_if_err_msg", "faIfErrMsg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lifid
	 */
	public String getLifid() {
		return this.lifid;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return ifTtlRowKnt
	 */
	public String getIfTtlRowKnt() {
		return this.ifTtlRowKnt;
	}
	
	/**
	 * Column Info
	 * @return faEqNo
	 */
	public String getFaEqNo() {
		return this.faEqNo;
	}
	
	/**
	 * Column Info
	 * @return retAproNo
	 */
	public String getRetAproNo() {
		return this.retAproNo;
	}
	
	/**
	 * Column Info
	 * @return faIfGrpSeqNo
	 */
	public String getFaIfGrpSeqNo() {
		return this.faIfGrpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return ifSeq
	 */
	public String getIfSeq() {
		return this.ifSeq;
	}
	
	/**
	 * Column Info
	 * @return faIfTpCd
	 */
	public String getFaIfTpCd() {
		return this.faIfTpCd;
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
	 * @return eaiIfNo
	 */
	public String getEaiIfNo() {
		return this.eaiIfNo;
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
	 * @return faIfStsCd
	 */
	public String getFaIfStsCd() {
		return this.faIfStsCd;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return createdBy
	 */
	public String getCreatedBy() {
		return this.createdBy;
	}
	
	/**
	 * Column Info
	 * @return faIfDt
	 */
	public String getFaIfDt() {
		return this.faIfDt;
	}
	
	/**
	 * Column Info
	 * @return faIfErrMsg
	 */
	public String getFaIfErrMsg() {
		return this.faIfErrMsg;
	}
	

	/**
	 * Column Info
	 * @param lifid
	 */
	public void setLifid(String lifid) {
		this.lifid = lifid;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param ifTtlRowKnt
	 */
	public void setIfTtlRowKnt(String ifTtlRowKnt) {
		this.ifTtlRowKnt = ifTtlRowKnt;
	}
	
	/**
	 * Column Info
	 * @param faEqNo
	 */
	public void setFaEqNo(String faEqNo) {
		this.faEqNo = faEqNo;
	}
	
	/**
	 * Column Info
	 * @param retAproNo
	 */
	public void setRetAproNo(String retAproNo) {
		this.retAproNo = retAproNo;
	}
	
	/**
	 * Column Info
	 * @param faIfGrpSeqNo
	 */
	public void setFaIfGrpSeqNo(String faIfGrpSeqNo) {
		this.faIfGrpSeqNo = faIfGrpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param ifSeq
	 */
	public void setIfSeq(String ifSeq) {
		this.ifSeq = ifSeq;
	}
	
	/**
	 * Column Info
	 * @param faIfTpCd
	 */
	public void setFaIfTpCd(String faIfTpCd) {
		this.faIfTpCd = faIfTpCd;
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
	 * @param eaiIfNo
	 */
	public void setEaiIfNo(String eaiIfNo) {
		this.eaiIfNo = eaiIfNo;
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
	 * @param faIfStsCd
	 */
	public void setFaIfStsCd(String faIfStsCd) {
		this.faIfStsCd = faIfStsCd;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * Column Info
	 * @param faIfDt
	 */
	public void setFaIfDt(String faIfDt) {
		this.faIfDt = faIfDt;
	}
	
	/**
	 * Column Info
	 * @param faIfErrMsg
	 */
	public void setFaIfErrMsg(String faIfErrMsg) {
		this.faIfErrMsg = faIfErrMsg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLifid(JSPUtil.getParameter(request, "lifid", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setIfTtlRowKnt(JSPUtil.getParameter(request, "if_ttl_row_knt", ""));
		setFaEqNo(JSPUtil.getParameter(request, "fa_eq_no", ""));
		setRetAproNo(JSPUtil.getParameter(request, "ret_apro_no", ""));
		setFaIfGrpSeqNo(JSPUtil.getParameter(request, "fa_if_grp_seq_no", ""));
		setIfSeq(JSPUtil.getParameter(request, "if_seq", ""));
		setFaIfTpCd(JSPUtil.getParameter(request, "fa_if_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEaiIfNo(JSPUtil.getParameter(request, "eai_if_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFaIfStsCd(JSPUtil.getParameter(request, "fa_if_sts_cd", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setCreatedBy(JSPUtil.getParameter(request, "created_by", ""));
		setFaIfDt(JSPUtil.getParameter(request, "fa_if_dt", ""));
		setFaIfErrMsg(JSPUtil.getParameter(request, "fa_if_err_msg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrMasterUpdateIFVO[]
	 */
	public CntrMasterUpdateIFVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrMasterUpdateIFVO[]
	 */
	public CntrMasterUpdateIFVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrMasterUpdateIFVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lifid = (JSPUtil.getParameter(request, prefix	+ "lifid", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] ifTtlRowKnt = (JSPUtil.getParameter(request, prefix	+ "if_ttl_row_knt", length));
			String[] faEqNo = (JSPUtil.getParameter(request, prefix	+ "fa_eq_no", length));
			String[] retAproNo = (JSPUtil.getParameter(request, prefix	+ "ret_apro_no", length));
			String[] faIfGrpSeqNo = (JSPUtil.getParameter(request, prefix	+ "fa_if_grp_seq_no", length));
			String[] ifSeq = (JSPUtil.getParameter(request, prefix	+ "if_seq", length));
			String[] faIfTpCd = (JSPUtil.getParameter(request, prefix	+ "fa_if_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eaiIfNo = (JSPUtil.getParameter(request, prefix	+ "eai_if_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] faIfStsCd = (JSPUtil.getParameter(request, prefix	+ "fa_if_sts_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] createdBy = (JSPUtil.getParameter(request, prefix	+ "created_by", length));
			String[] faIfDt = (JSPUtil.getParameter(request, prefix	+ "fa_if_dt", length));
			String[] faIfErrMsg = (JSPUtil.getParameter(request, prefix	+ "fa_if_err_msg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrMasterUpdateIFVO();
				if (lifid[i] != null)
					model.setLifid(lifid[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (ifTtlRowKnt[i] != null)
					model.setIfTtlRowKnt(ifTtlRowKnt[i]);
				if (faEqNo[i] != null)
					model.setFaEqNo(faEqNo[i]);
				if (retAproNo[i] != null)
					model.setRetAproNo(retAproNo[i]);
				if (faIfGrpSeqNo[i] != null)
					model.setFaIfGrpSeqNo(faIfGrpSeqNo[i]);
				if (ifSeq[i] != null)
					model.setIfSeq(ifSeq[i]);
				if (faIfTpCd[i] != null)
					model.setFaIfTpCd(faIfTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eaiIfNo[i] != null)
					model.setEaiIfNo(eaiIfNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (faIfStsCd[i] != null)
					model.setFaIfStsCd(faIfStsCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (createdBy[i] != null)
					model.setCreatedBy(createdBy[i]);
				if (faIfDt[i] != null)
					model.setFaIfDt(faIfDt[i]);
				if (faIfErrMsg[i] != null)
					model.setFaIfErrMsg(faIfErrMsg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrMasterUpdateIFVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrMasterUpdateIFVO[]
	 */
	public CntrMasterUpdateIFVO[] getCntrMasterUpdateIFVOs(){
		CntrMasterUpdateIFVO[] vos = (CntrMasterUpdateIFVO[])models.toArray(new CntrMasterUpdateIFVO[models.size()]);
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
		this.lifid = this.lifid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifTtlRowKnt = this.ifTtlRowKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faEqNo = this.faEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.retAproNo = this.retAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfGrpSeqNo = this.faIfGrpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSeq = this.ifSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfTpCd = this.faIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfNo = this.eaiIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfStsCd = this.faIfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.createdBy = this.createdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfDt = this.faIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfErrMsg = this.faIfErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
