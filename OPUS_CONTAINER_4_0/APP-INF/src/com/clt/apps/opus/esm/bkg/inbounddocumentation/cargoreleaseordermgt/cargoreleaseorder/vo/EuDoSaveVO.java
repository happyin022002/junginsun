/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EuDoSaveVO.java
*@FileTitle : EuDoSaveVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.28  
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
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EuDoSaveVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EuDoSaveVO> models = new ArrayList<EuDoSaveVO>();

	private SignOnUserAccount acount = null;
	/* Column Info */
	private String oblCngFlg = null;
	/* Column Info */
	private String doNoSplit = null;
	/* Column Info */
	private String cyOpCd = null;
	/* Column Info */
	private String doSplitFlg = null;
	/* Column Info */
	private String infoCgoFlg = null;
	/* Column Info */
	private String newOblRdemKnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cstmsRefNm = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String cstmsAsgnCtnt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String doCngEvntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String oldOblRdemKnt = null;
	/* Column Info */
	private String cstmsRefCtnt = null;
	/* Column Info */
	private String cstmsAsgnNm = null;
	
	private String doHldFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EuDoSaveVO() {}

	public EuDoSaveVO(String ibflag, String pagerows, String bkgNo, String cstmsRefNm, String cstmsRefCtnt, String cstmsAsgnNm, String cstmsAsgnCtnt, String interRmk, String doNo, String doNoSplit, String doSplitFlg, String userId, String ofcCd, String oblCngFlg, String doCngEvntCd, String oldOblRdemKnt, String newOblRdemKnt, String cyOpCd, String infoCgoFlg, String doHldFlg) {
		this.oblCngFlg = oblCngFlg;
		this.doNoSplit = doNoSplit;
		this.cyOpCd = cyOpCd;
		this.doSplitFlg = doSplitFlg;
		this.infoCgoFlg = infoCgoFlg;
		this.newOblRdemKnt = newOblRdemKnt;
		this.pagerows = pagerows;
		this.cstmsRefNm = cstmsRefNm;
		this.doNo = doNo;
		this.cstmsAsgnCtnt = cstmsAsgnCtnt;
		this.ofcCd = ofcCd;
		this.doCngEvntCd = doCngEvntCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.interRmk = interRmk;
		this.userId = userId;
		this.oldOblRdemKnt = oldOblRdemKnt;
		this.cstmsRefCtnt = cstmsRefCtnt;
		this.cstmsAsgnNm = cstmsAsgnNm;
		this.doHldFlg = doHldFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("obl_cng_flg", getOblCngFlg());
		this.hashColumns.put("do_no_split", getDoNoSplit());
		this.hashColumns.put("cy_op_cd", getCyOpCd());
		this.hashColumns.put("do_split_flg", getDoSplitFlg());
		this.hashColumns.put("info_cgo_flg", getInfoCgoFlg());
		this.hashColumns.put("new_obl_rdem_knt", getNewOblRdemKnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_ref_nm", getCstmsRefNm());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("cstms_asgn_ctnt", getCstmsAsgnCtnt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("do_cng_evnt_cd", getDoCngEvntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("old_obl_rdem_knt", getOldOblRdemKnt());
		this.hashColumns.put("cstms_ref_ctnt", getCstmsRefCtnt());
		this.hashColumns.put("cstms_asgn_nm", getCstmsAsgnNm());
		this.hashColumns.put("do_hld_flg", getDoHldFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("obl_cng_flg", "oblCngFlg");
		this.hashFields.put("do_no_split", "doNoSplit");
		this.hashFields.put("cy_op_cd", "cyOpCd");
		this.hashFields.put("do_split_flg", "doSplitFlg");
		this.hashFields.put("info_cgo_flg", "infoCgoFlg");
		this.hashFields.put("new_obl_rdem_knt", "newOblRdemKnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_ref_nm", "cstmsRefNm");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("cstms_asgn_ctnt", "cstmsAsgnCtnt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("do_cng_evnt_cd", "doCngEvntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("old_obl_rdem_knt", "oldOblRdemKnt");
		this.hashFields.put("cstms_ref_ctnt", "cstmsRefCtnt");
		this.hashFields.put("cstms_asgn_nm", "cstmsAsgnNm");
		this.hashFields.put("do_hld_flg", "doHldFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return oblCngFlg
	 */
	public String getOblCngFlg() {
		return this.oblCngFlg;
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
	 * @return cyOpCd
	 */
	public String getCyOpCd() {
		return this.cyOpCd;
	}
	
	/**
	 * Column Info
	 * @return doSplitFlg
	 */
	public String getDoSplitFlg() {
		return this.doSplitFlg;
	}
	
	/**
	 * Column Info
	 * @return infoCgoFlg
	 */
	public String getInfoCgoFlg() {
		return this.infoCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return newOblRdemKnt
	 */
	public String getNewOblRdemKnt() {
		return this.newOblRdemKnt;
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
	 * @return cstmsRefNm
	 */
	public String getCstmsRefNm() {
		return this.cstmsRefNm;
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
	 * @return cstmsAsgnCtnt
	 */
	public String getCstmsAsgnCtnt() {
		return this.cstmsAsgnCtnt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return doCngEvntCd
	 */
	public String getDoCngEvntCd() {
		return this.doCngEvntCd;
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
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return oldOblRdemKnt
	 */
	public String getOldOblRdemKnt() {
		return this.oldOblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @return cstmsRefCtnt
	 */
	public String getCstmsRefCtnt() {
		return this.cstmsRefCtnt;
	}
	
	/**
	 * Column Info
	 * @return cstmsAsgnNm
	 */
	public String getCstmsAsgnNm() {
		return this.cstmsAsgnNm;
	}
	
	/**
	 * Column Info
	 * @return doHldFlg
	 */
	public String getDoHldFlg() {
		return this.doHldFlg;
	}

	/**
	 * Column Info
	 * @param doHldFlg
	 */
	public void setDoHldFlg(String doHldFlg) {
		this.doHldFlg = doHldFlg;
	}

	
	/**
	 * Column Info
	 * @param oblCngFlg
	 */
	public void setOblCngFlg(String oblCngFlg) {
		this.oblCngFlg = oblCngFlg;
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
	 * @param cyOpCd
	 */
	public void setCyOpCd(String cyOpCd) {
		this.cyOpCd = cyOpCd;
	}
	
	/**
	 * Column Info
	 * @param doSplitFlg
	 */
	public void setDoSplitFlg(String doSplitFlg) {
		this.doSplitFlg = doSplitFlg;
	}
	
	/**
	 * Column Info
	 * @param infoCgoFlg
	 */
	public void setInfoCgoFlg(String infoCgoFlg) {
		this.infoCgoFlg = infoCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param newOblRdemKnt
	 */
	public void setNewOblRdemKnt(String newOblRdemKnt) {
		this.newOblRdemKnt = newOblRdemKnt;
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
	 * @param cstmsRefNm
	 */
	public void setCstmsRefNm(String cstmsRefNm) {
		this.cstmsRefNm = cstmsRefNm;
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
	 * @param cstmsAsgnCtnt
	 */
	public void setCstmsAsgnCtnt(String cstmsAsgnCtnt) {
		this.cstmsAsgnCtnt = cstmsAsgnCtnt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param doCngEvntCd
	 */
	public void setDoCngEvntCd(String doCngEvntCd) {
		this.doCngEvntCd = doCngEvntCd;
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
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param oldOblRdemKnt
	 */
	public void setOldOblRdemKnt(String oldOblRdemKnt) {
		this.oldOblRdemKnt = oldOblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @param cstmsRefCtnt
	 */
	public void setCstmsRefCtnt(String cstmsRefCtnt) {
		this.cstmsRefCtnt = cstmsRefCtnt;
	}
	
	/**
	 * Column Info
	 * @param cstmsAsgnNm
	 */
	public void setCstmsAsgnNm(String cstmsAsgnNm) {
		this.cstmsAsgnNm = cstmsAsgnNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOblCngFlg(JSPUtil.getParameter(request, "obl_cng_flg", ""));
		setDoNoSplit(JSPUtil.getParameter(request, "do_no_split", ""));
		setCyOpCd(JSPUtil.getParameter(request, "cy_op_cd", ""));
		setDoSplitFlg(JSPUtil.getParameter(request, "do_split_flg", ""));
		setInfoCgoFlg(JSPUtil.getParameter(request, "info_cgo_flg", ""));
		setNewOblRdemKnt(JSPUtil.getParameter(request, "new_obl_rdem_knt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCstmsRefNm(JSPUtil.getParameter(request, "cstms_ref_nm", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setCstmsAsgnCtnt(JSPUtil.getParameter(request, "cstms_asgn_ctnt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setDoCngEvntCd(JSPUtil.getParameter(request, "do_cng_evnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setOldOblRdemKnt(JSPUtil.getParameter(request, "old_obl_rdem_knt", ""));
		setCstmsRefCtnt(JSPUtil.getParameter(request, "cstms_ref_ctnt", ""));
		setCstmsAsgnNm(JSPUtil.getParameter(request, "cstms_asgn_nm", ""));
		setDoHldFlg(JSPUtil.getParameter(request, "do_hld_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EuDoSaveVO[]
	 */
	public EuDoSaveVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EuDoSaveVO[]
	 */
	public EuDoSaveVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EuDoSaveVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oblCngFlg = (JSPUtil.getParameter(request, prefix	+ "obl_cng_flg", length));
			String[] doNoSplit = (JSPUtil.getParameter(request, prefix	+ "do_no_split", length));
			String[] cyOpCd = (JSPUtil.getParameter(request, prefix	+ "cy_op_cd", length));
			String[] doSplitFlg = (JSPUtil.getParameter(request, prefix	+ "do_split_flg", length));
			String[] infoCgoFlg = (JSPUtil.getParameter(request, prefix	+ "info_cgo_flg", length));
			String[] newOblRdemKnt = (JSPUtil.getParameter(request, prefix	+ "new_obl_rdem_knt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cstmsRefNm = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_nm", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] cstmsAsgnCtnt = (JSPUtil.getParameter(request, prefix	+ "cstms_asgn_ctnt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] doCngEvntCd = (JSPUtil.getParameter(request, prefix	+ "do_cng_evnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] oldOblRdemKnt = (JSPUtil.getParameter(request, prefix	+ "old_obl_rdem_knt", length));
			String[] cstmsRefCtnt = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_ctnt", length));
			String[] cstmsAsgnNm = (JSPUtil.getParameter(request, prefix	+ "cstms_asgn_nm", length));
			String[] doHldFlg = (JSPUtil.getParameter(request, prefix	+ "do_hld_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new EuDoSaveVO();
				if (oblCngFlg[i] != null)
					model.setOblCngFlg(oblCngFlg[i]);
				if (doNoSplit[i] != null)
					model.setDoNoSplit(doNoSplit[i]);
				if (cyOpCd[i] != null)
					model.setCyOpCd(cyOpCd[i]);
				if (doSplitFlg[i] != null)
					model.setDoSplitFlg(doSplitFlg[i]);
				if (infoCgoFlg[i] != null)
					model.setInfoCgoFlg(infoCgoFlg[i]);
				if (newOblRdemKnt[i] != null)
					model.setNewOblRdemKnt(newOblRdemKnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsRefNm[i] != null)
					model.setCstmsRefNm(cstmsRefNm[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (cstmsAsgnCtnt[i] != null)
					model.setCstmsAsgnCtnt(cstmsAsgnCtnt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (doCngEvntCd[i] != null)
					model.setDoCngEvntCd(doCngEvntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (oldOblRdemKnt[i] != null)
					model.setOldOblRdemKnt(oldOblRdemKnt[i]);
				if (cstmsRefCtnt[i] != null)
					model.setCstmsRefCtnt(cstmsRefCtnt[i]);
				if (cstmsAsgnNm[i] != null)
					model.setCstmsAsgnNm(cstmsAsgnNm[i]);
				if (doHldFlg[i] != null)
					model.setDoHldFlg(doHldFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEuDoSaveVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EuDoSaveVO[]
	 */
	public EuDoSaveVO[] getEuDoSaveVOs(){
		EuDoSaveVO[] vos = (EuDoSaveVO[])models.toArray(new EuDoSaveVO[models.size()]);
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
		this.oblCngFlg = this.oblCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNoSplit = this.doNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyOpCd = this.cyOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doSplitFlg = this.doSplitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.infoCgoFlg = this.infoCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newOblRdemKnt = this.newOblRdemKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefNm = this.cstmsRefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAsgnCtnt = this.cstmsAsgnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doCngEvntCd = this.doCngEvntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOblRdemKnt = this.oldOblRdemKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefCtnt = this.cstmsRefCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAsgnNm = this.cstmsAsgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doHldFlg = this.doHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @return the acount
	 */
	public SignOnUserAccount getAcount() {
		return acount;
	}

	/**
	 * @param acount the acount to set
	 */
	public void setAcount(SignOnUserAccount acount) {
		this.acount = acount;
	}
}
