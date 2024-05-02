/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IdaDoRlseStsVO.java
*@FileTitle : IdaDoRlseStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.30  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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

public class IdaDoRlseStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IdaDoRlseStsVO> models = new ArrayList<IdaDoRlseStsVO>();
	
	/* Column Info */
	private String doNoSplit = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String doVtyDt = null;
	/* Column Info */
	private String rlseStsCtnt = null;
	/* Column Info */
	private String doDmdtPayTpCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String evntUsrNm = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String rlseStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String doDmdtPayTpCd = null;
	/* Column Info */
	private String evntDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IdaDoRlseStsVO() {}

	public IdaDoRlseStsVO(String ibflag, String pagerows, String rlseStsCd, String rlseStsCtnt, String doNo, String doNoSplit, String evntDt, String doVtyDt, String doDmdtPayTpCd, String doDmdtPayTpCtnt, String evntUsrId, String evntUsrNm, String evntOfcCd) {
		this.doNoSplit = doNoSplit;
		this.evntOfcCd = evntOfcCd;
		this.doVtyDt = doVtyDt;
		this.rlseStsCtnt = rlseStsCtnt;
		this.doDmdtPayTpCtnt = doDmdtPayTpCtnt;
		this.pagerows = pagerows;
		this.evntUsrNm = evntUsrNm;
		this.doNo = doNo;
		this.rlseStsCd = rlseStsCd;
		this.ibflag = ibflag;
		this.evntUsrId = evntUsrId;
		this.doDmdtPayTpCd = doDmdtPayTpCd;
		this.evntDt = evntDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_no_split", getDoNoSplit());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("do_vty_dt", getDoVtyDt());
		this.hashColumns.put("rlse_sts_ctnt", getRlseStsCtnt());
		this.hashColumns.put("do_dmdt_pay_tp_ctnt", getDoDmdtPayTpCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("evnt_usr_nm", getEvntUsrNm());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("rlse_sts_cd", getRlseStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("do_dmdt_pay_tp_cd", getDoDmdtPayTpCd());
		this.hashColumns.put("evnt_dt", getEvntDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("do_no_split", "doNoSplit");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("do_vty_dt", "doVtyDt");
		this.hashFields.put("rlse_sts_ctnt", "rlseStsCtnt");
		this.hashFields.put("do_dmdt_pay_tp_ctnt", "doDmdtPayTpCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("evnt_usr_nm", "evntUsrNm");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("rlse_sts_cd", "rlseStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("do_dmdt_pay_tp_cd", "doDmdtPayTpCd");
		this.hashFields.put("evnt_dt", "evntDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return doNoSplit
	 */
	public String getDoNoSplit() {
		return this.doNoSplit;
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
	 * @return doVtyDt
	 */
	public String getDoVtyDt() {
		return this.doVtyDt;
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
	 * @return evntUsrNm
	 */
	public String getEvntUsrNm() {
		return this.evntUsrNm;
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
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
	}
	
	/**
	 * Column Info
	 * @return doDmdtPayTpCd
	 */
	public String getDoDmdtPayTpCd() {
		return this.doDmdtPayTpCd;
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
	 * @param doNoSplit
	 */
	public void setDoNoSplit(String doNoSplit) {
		this.doNoSplit = doNoSplit;
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
	 * @param doVtyDt
	 */
	public void setDoVtyDt(String doVtyDt) {
		this.doVtyDt = doVtyDt;
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
	 * @param evntUsrNm
	 */
	public void setEvntUsrNm(String evntUsrNm) {
		this.evntUsrNm = evntUsrNm;
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
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Column Info
	 * @param doDmdtPayTpCd
	 */
	public void setDoDmdtPayTpCd(String doDmdtPayTpCd) {
		this.doDmdtPayTpCd = doDmdtPayTpCd;
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
		setDoNoSplit(JSPUtil.getParameter(request, "do_no_split", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setDoVtyDt(JSPUtil.getParameter(request, "do_vty_dt", ""));
		setRlseStsCtnt(JSPUtil.getParameter(request, "rlse_sts_ctnt", ""));
		setDoDmdtPayTpCtnt(JSPUtil.getParameter(request, "do_dmdt_pay_tp_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEvntUsrNm(JSPUtil.getParameter(request, "evnt_usr_nm", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setRlseStsCd(JSPUtil.getParameter(request, "rlse_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setDoDmdtPayTpCd(JSPUtil.getParameter(request, "do_dmdt_pay_tp_cd", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IdaDoRlseStsVO[]
	 */
	public IdaDoRlseStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IdaDoRlseStsVO[]
	 */
	public IdaDoRlseStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IdaDoRlseStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] doNoSplit = (JSPUtil.getParameter(request, prefix	+ "do_no_split", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] doVtyDt = (JSPUtil.getParameter(request, prefix	+ "do_vty_dt", length));
			String[] rlseStsCtnt = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_ctnt", length));
			String[] doDmdtPayTpCtnt = (JSPUtil.getParameter(request, prefix	+ "do_dmdt_pay_tp_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] evntUsrNm = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_nm", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] rlseStsCd = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] doDmdtPayTpCd = (JSPUtil.getParameter(request, prefix	+ "do_dmdt_pay_tp_cd", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new IdaDoRlseStsVO();
				if (doNoSplit[i] != null)
					model.setDoNoSplit(doNoSplit[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (doVtyDt[i] != null)
					model.setDoVtyDt(doVtyDt[i]);
				if (rlseStsCtnt[i] != null)
					model.setRlseStsCtnt(rlseStsCtnt[i]);
				if (doDmdtPayTpCtnt[i] != null)
					model.setDoDmdtPayTpCtnt(doDmdtPayTpCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (evntUsrNm[i] != null)
					model.setEvntUsrNm(evntUsrNm[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (rlseStsCd[i] != null)
					model.setRlseStsCd(rlseStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (doDmdtPayTpCd[i] != null)
					model.setDoDmdtPayTpCd(doDmdtPayTpCd[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIdaDoRlseStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IdaDoRlseStsVO[]
	 */
	public IdaDoRlseStsVO[] getIdaDoRlseStsVOs(){
		IdaDoRlseStsVO[] vos = (IdaDoRlseStsVO[])models.toArray(new IdaDoRlseStsVO[models.size()]);
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
		this.doNoSplit = this.doNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doVtyDt = this.doVtyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCtnt = this.rlseStsCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doDmdtPayTpCtnt = this.doDmdtPayTpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrNm = this.evntUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCd = this.rlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doDmdtPayTpCd = this.doDmdtPayTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
