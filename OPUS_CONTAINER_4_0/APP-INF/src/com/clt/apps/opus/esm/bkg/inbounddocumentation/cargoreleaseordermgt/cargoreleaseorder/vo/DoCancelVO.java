/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DoCancelVO.java
*@FileTitle : DoCancelVO
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

public class DoCancelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DoCancelVO> models = new ArrayList<DoCancelVO>();
	
	/* Column Info */
	private String doNoSplit = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String rlseSeq = null;
	/* Column Info */
	private String lastRlseStsCd = null;
	/* Column Info */
	private String crntCtnt = null;
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
	private String doCngEvntCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String preCtnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String resetFlg = null;
	/* Column Info */
	private String splitFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DoCancelVO() {}

	public DoCancelVO(String ibflag, String pagerows, String bkgNo, String rlseSeq, String rlseStsCd, String lastRlseStsCd, String preCtnt, String crntCtnt, String doCngEvntCd, String creUsrId, String updUsrId, String evntOfcCd, String doNo, String doNoSplit, String resetFlg, String splitFlg) {
		this.doNoSplit = doNoSplit;
		this.evntOfcCd = evntOfcCd;
		this.rlseSeq = rlseSeq;
		this.lastRlseStsCd = lastRlseStsCd;
		this.crntCtnt = crntCtnt;
		this.pagerows = pagerows;
		this.doNo = doNo;
		this.rlseStsCd = rlseStsCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.doCngEvntCd = doCngEvntCd;
		this.creUsrId = creUsrId;
		this.preCtnt = preCtnt;
		this.updUsrId = updUsrId;
		this.resetFlg = resetFlg;
		this.splitFlg = splitFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_no_split", getDoNoSplit());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("rlse_seq", getRlseSeq());
		this.hashColumns.put("last_rlse_sts_cd", getLastRlseStsCd());
		this.hashColumns.put("crnt_ctnt", getCrntCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("rlse_sts_cd", getRlseStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("do_cng_evnt_cd", getDoCngEvntCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pre_ctnt", getPreCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("reset_flg", getResetFlg());
		this.hashColumns.put("split_flg", getSplitFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("do_no_split", "doNoSplit");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("rlse_seq", "rlseSeq");
		this.hashFields.put("last_rlse_sts_cd", "lastRlseStsCd");
		this.hashFields.put("crnt_ctnt", "crntCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("rlse_sts_cd", "rlseStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("do_cng_evnt_cd", "doCngEvntCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pre_ctnt", "preCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("reset_flg", "resetFlg");
		this.hashFields.put("split_flg", "splitFlg");
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
	 * @return rlseSeq
	 */
	public String getRlseSeq() {
		return this.rlseSeq;
	}
	
	/**
	 * Column Info
	 * @return lastRlseStsCd
	 */
	public String getLastRlseStsCd() {
		return this.lastRlseStsCd;
	}
	
	/**
	 * Column Info
	 * @return crntCtnt
	 */
	public String getCrntCtnt() {
		return this.crntCtnt;
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
	 * @return doCngEvntCd
	 */
	public String getDoCngEvntCd() {
		return this.doCngEvntCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return resetFlg
	 */
	public String getResetFlg() {
		return this.resetFlg;
	}
	
	/**
	 * Column Info
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
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
	 * @param rlseSeq
	 */
	public void setRlseSeq(String rlseSeq) {
		this.rlseSeq = rlseSeq;
	}
	
	/**
	 * Column Info
	 * @param lastRlseStsCd
	 */
	public void setLastRlseStsCd(String lastRlseStsCd) {
		this.lastRlseStsCd = lastRlseStsCd;
	}
	
	/**
	 * Column Info
	 * @param crntCtnt
	 */
	public void setCrntCtnt(String crntCtnt) {
		this.crntCtnt = crntCtnt;
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
	 * @param doCngEvntCd
	 */
	public void setDoCngEvntCd(String doCngEvntCd) {
		this.doCngEvntCd = doCngEvntCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param resetFlg
	 */
	public void setResetFlg(String resetFlg) {
		this.resetFlg = resetFlg;
	}

	/**
	 * Column Info
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}

	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDoNoSplit(JSPUtil.getParameter(request, "do_no_split", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setRlseSeq(JSPUtil.getParameter(request, "rlse_seq", ""));
		setLastRlseStsCd(JSPUtil.getParameter(request, "last_rlse_sts_cd", ""));
		setCrntCtnt(JSPUtil.getParameter(request, "crnt_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setRlseStsCd(JSPUtil.getParameter(request, "rlse_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDoCngEvntCd(JSPUtil.getParameter(request, "do_cng_evnt_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPreCtnt(JSPUtil.getParameter(request, "pre_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setResetFlg(JSPUtil.getParameter(request, "reset_flg", ""));
		setSplitFlg(JSPUtil.getParameter(request, "split_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoCancelVO[]
	 */
	public DoCancelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoCancelVO[]
	 */
	public DoCancelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoCancelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] doNoSplit = (JSPUtil.getParameter(request, prefix	+ "do_no_split", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] rlseSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_seq", length));
			String[] lastRlseStsCd = (JSPUtil.getParameter(request, prefix	+ "last_rlse_sts_cd", length));
			String[] crntCtnt = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] rlseStsCd = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] doCngEvntCd = (JSPUtil.getParameter(request, prefix	+ "do_cng_evnt_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] preCtnt = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] resetFlg = (JSPUtil.getParameter(request, prefix	+ "reset_flg", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new DoCancelVO();
				if (doNoSplit[i] != null)
					model.setDoNoSplit(doNoSplit[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (rlseSeq[i] != null)
					model.setRlseSeq(rlseSeq[i]);
				if (lastRlseStsCd[i] != null)
					model.setLastRlseStsCd(lastRlseStsCd[i]);
				if (crntCtnt[i] != null)
					model.setCrntCtnt(crntCtnt[i]);
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
				if (doCngEvntCd[i] != null)
					model.setDoCngEvntCd(doCngEvntCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (preCtnt[i] != null)
					model.setPreCtnt(preCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (resetFlg[i] != null)
					model.setResetFlg(resetFlg[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoCancelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoCancelVO[]
	 */
	public DoCancelVO[] getDoCancelVOs(){
		DoCancelVO[] vos = (DoCancelVO[])models.toArray(new DoCancelVO[models.size()]);
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
		this.rlseSeq = this.rlseSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastRlseStsCd = this.lastRlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt = this.crntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCd = this.rlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doCngEvntCd = this.doCngEvntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt = this.preCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resetFlg = this.resetFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
