/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DoHisVO.java
*@FileTitle : DoHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.07  
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

public class DoHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DoHisVO> models = new ArrayList<DoHisVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String doCngEvntNm = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String preCtntNm = null;
	/* Column Info */
	private String crntCtnt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String doCngEvntCd = null;
	/* Column Info */
	private String crntCtntNm = null;
	/* Column Info */
	private String doSeq = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String preCtnt = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String evntDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DoHisVO() {}

	public DoHisVO(String ibflag, String pagerows, String bkgNo, String doSeq, String doCngEvntCd, String doCngEvntNm, String preCtnt, String preCtntNm, String crntCtnt, String crntCtntNm, String evntDt, String evntUsrId, String evntOfcCd, String creUsrId, String creDt, String updUsrId, String updUsrNm, String updDt, String blNo) {
		this.updDt = updDt;
		this.doCngEvntNm = doCngEvntNm;
		this.evntOfcCd = evntOfcCd;
		this.creDt = creDt;
		this.preCtntNm = preCtntNm;
		this.crntCtnt = crntCtnt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.doCngEvntCd = doCngEvntCd;
		this.crntCtntNm = crntCtntNm;
		this.doSeq = doSeq;
		this.evntUsrId = evntUsrId;
		this.preCtnt = preCtnt;
		this.updUsrNm = updUsrNm;
		this.updUsrId = updUsrId;
		this.evntDt = evntDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("do_cng_evnt_nm", getDoCngEvntNm());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pre_ctnt_nm", getPreCtntNm());
		this.hashColumns.put("crnt_ctnt", getCrntCtnt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("do_cng_evnt_cd", getDoCngEvntCd());
		this.hashColumns.put("crnt_ctnt_nm", getCrntCtntNm());
		this.hashColumns.put("do_seq", getDoSeq());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("pre_ctnt", getPreCtnt());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("evnt_dt", getEvntDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("do_cng_evnt_nm", "doCngEvntNm");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pre_ctnt_nm", "preCtntNm");
		this.hashFields.put("crnt_ctnt", "crntCtnt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("do_cng_evnt_cd", "doCngEvntCd");
		this.hashFields.put("crnt_ctnt_nm", "crntCtntNm");
		this.hashFields.put("do_seq", "doSeq");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("pre_ctnt", "preCtnt");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("evnt_dt", "evntDt");
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
	 * @return doCngEvntNm
	 */
	public String getDoCngEvntNm() {
		return this.doCngEvntNm;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return preCtntNm
	 */
	public String getPreCtntNm() {
		return this.preCtntNm;
	}
	
	/**
	 * Column Info
	 * @return crntCtnt
	 */
	public String getCrntCtnt() {
		return this.crntCtnt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return doCngEvntCd
	 */
	public String getDoCngEvntCd() {
		return this.doCngEvntCd;
	}
	
	/**
	 * Column Info
	 * @return crntCtntNm
	 */
	public String getCrntCtntNm() {
		return this.crntCtntNm;
	}
	
	/**
	 * Column Info
	 * @return doSeq
	 */
	public String getDoSeq() {
		return this.doSeq;
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
	 * @return preCtnt
	 */
	public String getPreCtnt() {
		return this.preCtnt;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
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
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
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
	 * @param doCngEvntNm
	 */
	public void setDoCngEvntNm(String doCngEvntNm) {
		this.doCngEvntNm = doCngEvntNm;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param preCtntNm
	 */
	public void setPreCtntNm(String preCtntNm) {
		this.preCtntNm = preCtntNm;
	}
	
	/**
	 * Column Info
	 * @param crntCtnt
	 */
	public void setCrntCtnt(String crntCtnt) {
		this.crntCtnt = crntCtnt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param doCngEvntCd
	 */
	public void setDoCngEvntCd(String doCngEvntCd) {
		this.doCngEvntCd = doCngEvntCd;
	}
	
	/**
	 * Column Info
	 * @param crntCtntNm
	 */
	public void setCrntCtntNm(String crntCtntNm) {
		this.crntCtntNm = crntCtntNm;
	}
	
	/**
	 * Column Info
	 * @param doSeq
	 */
	public void setDoSeq(String doSeq) {
		this.doSeq = doSeq;
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
	 * @param preCtnt
	 */
	public void setPreCtnt(String preCtnt) {
		this.preCtnt = preCtnt;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDoCngEvntNm(JSPUtil.getParameter(request, "do_cng_evnt_nm", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPreCtntNm(JSPUtil.getParameter(request, "pre_ctnt_nm", ""));
		setCrntCtnt(JSPUtil.getParameter(request, "crnt_ctnt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDoCngEvntCd(JSPUtil.getParameter(request, "do_cng_evnt_cd", ""));
		setCrntCtntNm(JSPUtil.getParameter(request, "crnt_ctnt_nm", ""));
		setDoSeq(JSPUtil.getParameter(request, "do_seq", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setPreCtnt(JSPUtil.getParameter(request, "pre_ctnt", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, "upd_usr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoHisVO[]
	 */
	public DoHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoHisVO[]
	 */
	public DoHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] doCngEvntNm = (JSPUtil.getParameter(request, prefix	+ "do_cng_evnt_nm", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] preCtntNm = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt_nm", length));
			String[] crntCtnt = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] doCngEvntCd = (JSPUtil.getParameter(request, prefix	+ "do_cng_evnt_cd", length));
			String[] crntCtntNm = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt_nm", length));
			String[] doSeq = (JSPUtil.getParameter(request, prefix	+ "do_seq", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] preCtnt = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DoHisVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (doCngEvntNm[i] != null)
					model.setDoCngEvntNm(doCngEvntNm[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (preCtntNm[i] != null)
					model.setPreCtntNm(preCtntNm[i]);
				if (crntCtnt[i] != null)
					model.setCrntCtnt(crntCtnt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (doCngEvntCd[i] != null)
					model.setDoCngEvntCd(doCngEvntCd[i]);
				if (crntCtntNm[i] != null)
					model.setCrntCtntNm(crntCtntNm[i]);
				if (doSeq[i] != null)
					model.setDoSeq(doSeq[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (preCtnt[i] != null)
					model.setPreCtnt(preCtnt[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoHisVO[]
	 */
	public DoHisVO[] getDoHisVOs(){
		DoHisVO[] vos = (DoHisVO[])models.toArray(new DoHisVO[models.size()]);
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
		this.doCngEvntNm = this.doCngEvntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtntNm = this.preCtntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt = this.crntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doCngEvntCd = this.doCngEvntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtntNm = this.crntCtntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doSeq = this.doSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt = this.preCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
