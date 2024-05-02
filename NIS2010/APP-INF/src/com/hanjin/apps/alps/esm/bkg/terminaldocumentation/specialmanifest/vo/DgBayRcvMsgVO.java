/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DgBayRcvMsgVO.java
*@FileTitle : DgBayRcvMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DgBayRcvMsgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DgBayRcvMsgVO> models = new ArrayList<DgBayRcvMsgVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bayPlnId = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String crrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslVoyDirNo = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String eurDgDepPortCd = null;
	/* Column Info */
	private String msgSndrCtnt = null;
	/* Column Info */
	private String eurDgNxtPortCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String eurDgCallSgnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DgBayRcvMsgVO() {}

	public DgBayRcvMsgVO(String ibflag, String pagerows, String bayPlnId, String msgSndrCtnt, String vslCd, String vslVoyDirNo, String eurDgCallSgnNo, String vslNm, String crrId, String eurDgDepPortCd, String eurDgNxtPortCd, String etaDt, String etdDt, String rcvDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.bayPlnId = bayPlnId;
		this.etaDt = etaDt;
		this.creDt = creDt;
		this.vslNm = vslNm;
		this.etdDt = etdDt;
		this.crrId = crrId;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.vslVoyDirNo = vslVoyDirNo;
		this.rcvDt = rcvDt;
		this.eurDgDepPortCd = eurDgDepPortCd;
		this.msgSndrCtnt = msgSndrCtnt;
		this.eurDgNxtPortCd = eurDgNxtPortCd;
		this.updUsrId = updUsrId;
		this.eurDgCallSgnNo = eurDgCallSgnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bay_pln_id", getBayPlnId());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("crr_id", getCrrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_voy_dir_no", getVslVoyDirNo());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("eur_dg_dep_port_cd", getEurDgDepPortCd());
		this.hashColumns.put("msg_sndr_ctnt", getMsgSndrCtnt());
		this.hashColumns.put("eur_dg_nxt_port_cd", getEurDgNxtPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eur_dg_call_sgn_no", getEurDgCallSgnNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bay_pln_id", "bayPlnId");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("crr_id", "crrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_voy_dir_no", "vslVoyDirNo");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("eur_dg_dep_port_cd", "eurDgDepPortCd");
		this.hashFields.put("msg_sndr_ctnt", "msgSndrCtnt");
		this.hashFields.put("eur_dg_nxt_port_cd", "eurDgNxtPortCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eur_dg_call_sgn_no", "eurDgCallSgnNo");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return bayPlnId
	 */
	public String getBayPlnId() {
		return this.bayPlnId;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
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
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return crrId
	 */
	public String getCrrId() {
		return this.crrId;
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
	 * @return vslVoyDirNo
	 */
	public String getVslVoyDirNo() {
		return this.vslVoyDirNo;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return eurDgDepPortCd
	 */
	public String getEurDgDepPortCd() {
		return this.eurDgDepPortCd;
	}
	
	/**
	 * Column Info
	 * @return msgSndrCtnt
	 */
	public String getMsgSndrCtnt() {
		return this.msgSndrCtnt;
	}
	
	/**
	 * Column Info
	 * @return eurDgNxtPortCd
	 */
	public String getEurDgNxtPortCd() {
		return this.eurDgNxtPortCd;
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
	 * @return eurDgCallSgnNo
	 */
	public String getEurDgCallSgnNo() {
		return this.eurDgCallSgnNo;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param bayPlnId
	 */
	public void setBayPlnId(String bayPlnId) {
		this.bayPlnId = bayPlnId;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
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
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param crrId
	 */
	public void setCrrId(String crrId) {
		this.crrId = crrId;
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
	 * @param vslVoyDirNo
	 */
	public void setVslVoyDirNo(String vslVoyDirNo) {
		this.vslVoyDirNo = vslVoyDirNo;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param eurDgDepPortCd
	 */
	public void setEurDgDepPortCd(String eurDgDepPortCd) {
		this.eurDgDepPortCd = eurDgDepPortCd;
	}
	
	/**
	 * Column Info
	 * @param msgSndrCtnt
	 */
	public void setMsgSndrCtnt(String msgSndrCtnt) {
		this.msgSndrCtnt = msgSndrCtnt;
	}
	
	/**
	 * Column Info
	 * @param eurDgNxtPortCd
	 */
	public void setEurDgNxtPortCd(String eurDgNxtPortCd) {
		this.eurDgNxtPortCd = eurDgNxtPortCd;
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
	 * @param eurDgCallSgnNo
	 */
	public void setEurDgCallSgnNo(String eurDgCallSgnNo) {
		this.eurDgCallSgnNo = eurDgCallSgnNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBayPlnId(JSPUtil.getParameter(request, "bay_pln_id", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setCrrId(JSPUtil.getParameter(request, "crr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslVoyDirNo(JSPUtil.getParameter(request, "vsl_voy_dir_no", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setEurDgDepPortCd(JSPUtil.getParameter(request, "eur_dg_dep_port_cd", ""));
		setMsgSndrCtnt(JSPUtil.getParameter(request, "msg_sndr_ctnt", ""));
		setEurDgNxtPortCd(JSPUtil.getParameter(request, "eur_dg_nxt_port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setEurDgCallSgnNo(JSPUtil.getParameter(request, "eur_dg_call_sgn_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgBayRcvMsgVO[]
	 */
	public DgBayRcvMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DgBayRcvMsgVO[]
	 */
	public DgBayRcvMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgBayRcvMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bayPlnId = (JSPUtil.getParameter(request, prefix	+ "bay_pln_id", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] crrId = (JSPUtil.getParameter(request, prefix	+ "crr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslVoyDirNo = (JSPUtil.getParameter(request, prefix	+ "vsl_voy_dir_no", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] eurDgDepPortCd = (JSPUtil.getParameter(request, prefix	+ "eur_dg_dep_port_cd", length));
			String[] msgSndrCtnt = (JSPUtil.getParameter(request, prefix	+ "msg_sndr_ctnt", length));
			String[] eurDgNxtPortCd = (JSPUtil.getParameter(request, prefix	+ "eur_dg_nxt_port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] eurDgCallSgnNo = (JSPUtil.getParameter(request, prefix	+ "eur_dg_call_sgn_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DgBayRcvMsgVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bayPlnId[i] != null)
					model.setBayPlnId(bayPlnId[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (crrId[i] != null)
					model.setCrrId(crrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslVoyDirNo[i] != null)
					model.setVslVoyDirNo(vslVoyDirNo[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (eurDgDepPortCd[i] != null)
					model.setEurDgDepPortCd(eurDgDepPortCd[i]);
				if (msgSndrCtnt[i] != null)
					model.setMsgSndrCtnt(msgSndrCtnt[i]);
				if (eurDgNxtPortCd[i] != null)
					model.setEurDgNxtPortCd(eurDgNxtPortCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (eurDgCallSgnNo[i] != null)
					model.setEurDgCallSgnNo(eurDgCallSgnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgBayRcvMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgBayRcvMsgVO[]
	 */
	public DgBayRcvMsgVO[] getDgBayRcvMsgVOs(){
		DgBayRcvMsgVO[] vos = (DgBayRcvMsgVO[])models.toArray(new DgBayRcvMsgVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayPlnId = this.bayPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrId = this.crrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslVoyDirNo = this.vslVoyDirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurDgDepPortCd = this.eurDgDepPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndrCtnt = this.msgSndrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurDgNxtPortCd = this.eurDgNxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurDgCallSgnNo = this.eurDgCallSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
