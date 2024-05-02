/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IdaDoCntrRlseStsVO.java
*@FileTitle : IdaDoCntrRlseStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.09.30 박만건 
* 1.0 Creation
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

public class IdaDoCntrRlseStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IdaDoCntrRlseStsVO> models = new ArrayList<IdaDoCntrRlseStsVO>();
	
	/* Column Info */
	private String doVtyDt = null;
	/* Column Info */
	private String rlseSeq = null;
	/* Column Info */
	private String rlseStsCtnt = null;
	/* Column Info */
	private String doDmdtPayTpCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String rlseStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rlseStsSeq = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dmdtPayTpCd = null;
	/* Column Info */
	private String evntDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IdaDoCntrRlseStsVO() {}

	public IdaDoCntrRlseStsVO(String ibflag, String pagerows, String bkgNo, String rlseSeq, String rlseStsSeq, String cntrNo, String rlseStsCd, String rlseStsCtnt, String doNo, String doVtyDt, String dmdtPayTpCd, String doDmdtPayTpCtnt, String evntDt, String evntUsrId) {
		this.doVtyDt = doVtyDt;
		this.rlseSeq = rlseSeq;
		this.rlseStsCtnt = rlseStsCtnt;
		this.doDmdtPayTpCtnt = doDmdtPayTpCtnt;
		this.pagerows = pagerows;
		this.doNo = doNo;
		this.rlseStsCd = rlseStsCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.rlseStsSeq = rlseStsSeq;
		this.evntUsrId = evntUsrId;
		this.cntrNo = cntrNo;
		this.dmdtPayTpCd = dmdtPayTpCd;
		this.evntDt = evntDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_vty_dt", getDoVtyDt());
		this.hashColumns.put("rlse_seq", getRlseSeq());
		this.hashColumns.put("rlse_sts_ctnt", getRlseStsCtnt());
		this.hashColumns.put("do_dmdt_pay_tp_ctnt", getDoDmdtPayTpCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("rlse_sts_cd", getRlseStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rlse_sts_seq", getRlseStsSeq());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dmdt_pay_tp_cd", getDmdtPayTpCd());
		this.hashColumns.put("evnt_dt", getEvntDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("do_vty_dt", "doVtyDt");
		this.hashFields.put("rlse_seq", "rlseSeq");
		this.hashFields.put("rlse_sts_ctnt", "rlseStsCtnt");
		this.hashFields.put("do_dmdt_pay_tp_ctnt", "doDmdtPayTpCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("rlse_sts_cd", "rlseStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rlse_sts_seq", "rlseStsSeq");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dmdt_pay_tp_cd", "dmdtPayTpCd");
		this.hashFields.put("evnt_dt", "evntDt");
		return this.hashFields;
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
	 * @return rlseSeq
	 */
	public String getRlseSeq() {
		return this.rlseSeq;
	}
	
	/**
	 * Column Info
	 * @return rlseStsCtnt
	 */
	public String getRlseStsCtnt() {
		return this.rlseStsCtnt;
	}
	
	/**
	 * Column Info
	 * @return doDmdtPayTpCtnt
	 */
	public String getDoDmdtPayTpCtnt() {
		return this.doDmdtPayTpCtnt;
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
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * Column Info
	 * @return rlseStsCd
	 */
	public String getRlseStsCd() {
		return this.rlseStsCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return rlseStsSeq
	 */
	public String getRlseStsSeq() {
		return this.rlseStsSeq;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @param doVtyDt
	 */
	public void setDoVtyDt(String doVtyDt) {
		this.doVtyDt = doVtyDt;
	}
	
	/**
	 * Column Info
	 * @param rlseSeq
	 */
	public void setRlseSeq(String rlseSeq) {
		this.rlseSeq = rlseSeq;
	}
	
	/**
	 * Column Info
	 * @param rlseStsCtnt
	 */
	public void setRlseStsCtnt(String rlseStsCtnt) {
		this.rlseStsCtnt = rlseStsCtnt;
	}
	
	/**
	 * Column Info
	 * @param doDmdtPayTpCtnt
	 */
	public void setDoDmdtPayTpCtnt(String doDmdtPayTpCtnt) {
		this.doDmdtPayTpCtnt = doDmdtPayTpCtnt;
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
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	
	/**
	 * Column Info
	 * @param rlseStsCd
	 */
	public void setRlseStsCd(String rlseStsCd) {
		this.rlseStsCd = rlseStsCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param rlseStsSeq
	 */
	public void setRlseStsSeq(String rlseStsSeq) {
		this.rlseStsSeq = rlseStsSeq;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDoVtyDt(JSPUtil.getParameter(request, "do_vty_dt", ""));
		setRlseSeq(JSPUtil.getParameter(request, "rlse_seq", ""));
		setRlseStsCtnt(JSPUtil.getParameter(request, "rlse_sts_ctnt", ""));
		setDoDmdtPayTpCtnt(JSPUtil.getParameter(request, "do_dmdt_pay_tp_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setRlseStsCd(JSPUtil.getParameter(request, "rlse_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRlseStsSeq(JSPUtil.getParameter(request, "rlse_sts_seq", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setDmdtPayTpCd(JSPUtil.getParameter(request, "dmdt_pay_tp_cd", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IdaDoCntrRlseStsVO[]
	 */
	public IdaDoCntrRlseStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IdaDoCntrRlseStsVO[]
	 */
	public IdaDoCntrRlseStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IdaDoCntrRlseStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] doVtyDt = (JSPUtil.getParameter(request, prefix	+ "do_vty_dt", length));
			String[] rlseSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_seq", length));
			String[] rlseStsCtnt = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_ctnt", length));
			String[] doDmdtPayTpCtnt = (JSPUtil.getParameter(request, prefix	+ "do_dmdt_pay_tp_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] rlseStsCd = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rlseStsSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_seq", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dmdtPayTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_pay_tp_cd", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new IdaDoCntrRlseStsVO();
				if (doVtyDt[i] != null)
					model.setDoVtyDt(doVtyDt[i]);
				if (rlseSeq[i] != null)
					model.setRlseSeq(rlseSeq[i]);
				if (rlseStsCtnt[i] != null)
					model.setRlseStsCtnt(rlseStsCtnt[i]);
				if (doDmdtPayTpCtnt[i] != null)
					model.setDoDmdtPayTpCtnt(doDmdtPayTpCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (rlseStsCd[i] != null)
					model.setRlseStsCd(rlseStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rlseStsSeq[i] != null)
					model.setRlseStsSeq(rlseStsSeq[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dmdtPayTpCd[i] != null)
					model.setDmdtPayTpCd(dmdtPayTpCd[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIdaDoCntrRlseStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IdaDoCntrRlseStsVO[]
	 */
	public IdaDoCntrRlseStsVO[] getIdaDoCntrRlseStsVOs(){
		IdaDoCntrRlseStsVO[] vos = (IdaDoCntrRlseStsVO[])models.toArray(new IdaDoCntrRlseStsVO[models.size()]);
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
		this.doVtyDt = this.doVtyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseSeq = this.rlseSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCtnt = this.rlseStsCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doDmdtPayTpCtnt = this.doDmdtPayTpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCd = this.rlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsSeq = this.rlseStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayTpCd = this.dmdtPayTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
