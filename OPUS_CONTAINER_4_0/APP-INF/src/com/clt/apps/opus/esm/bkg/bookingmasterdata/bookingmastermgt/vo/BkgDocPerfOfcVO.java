/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgDocPerfOfcVO.java
*@FileTitle : BkgDocPerfOfcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.10.13 강동윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgDocPerfOfcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgDocPerfOfcVO> models = new ArrayList<BkgDocPerfOfcVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String optionTp = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String subGrpCtnt = null;
	/* Column Info */
	private String hndlOfcCd = null;
	/* Column Info */
	private String siNtfcEml = null;
	/* Column Info */
	private String gsoOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chkOp = null;
	/* Column Info */
	private String bkgNtfcEml = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String hndlOfcSeq = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String ofcTy = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgDocPerfOfcVO() {}

	public BkgDocPerfOfcVO(String ibflag, String pagerows, String bkgOfcCd, String rgnOfcCd, String gsoOfcCd, String subGrpCtnt, String creUsrId, String creDt, String updUsrId, String updDt, String ofcCd, String chkOp, String optionTp, String ofcTy, String ctrlOfcCd, String siNtfcEml, String bkgNtfcEml, String hndlOfcCd, String hndlOfcSeq) {
		this.bkgOfcCd = bkgOfcCd;
		this.updDt = updDt;
		this.creDt = creDt;
		this.optionTp = optionTp;
		this.ctrlOfcCd = ctrlOfcCd;
		this.subGrpCtnt = subGrpCtnt;
		this.hndlOfcCd = hndlOfcCd;
		this.siNtfcEml = siNtfcEml;
		this.gsoOfcCd = gsoOfcCd;
		this.pagerows = pagerows;
		this.chkOp = chkOp;
		this.bkgNtfcEml = bkgNtfcEml;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.hndlOfcSeq = hndlOfcSeq;
		this.rgnOfcCd = rgnOfcCd;
		this.ofcTy = ofcTy;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("option_tp", getOptionTp());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("sub_grp_ctnt", getSubGrpCtnt());
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
		this.hashColumns.put("si_ntfc_eml", getSiNtfcEml());
		this.hashColumns.put("gso_ofc_cd", getGsoOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chk_op", getChkOp());
		this.hashColumns.put("bkg_ntfc_eml", getBkgNtfcEml());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("hndl_ofc_seq", getHndlOfcSeq());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("ofc_ty", getOfcTy());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("option_tp", "optionTp");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("sub_grp_ctnt", "subGrpCtnt");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("si_ntfc_eml", "siNtfcEml");
		this.hashFields.put("gso_ofc_cd", "gsoOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chk_op", "chkOp");
		this.hashFields.put("bkg_ntfc_eml", "bkgNtfcEml");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("hndl_ofc_seq", "hndlOfcSeq");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("ofc_ty", "ofcTy");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return optionTp
	 */
	public String getOptionTp() {
		return this.optionTp;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return subGrpCtnt
	 */
	public String getSubGrpCtnt() {
		return this.subGrpCtnt;
	}
	
	/**
	 * Column Info
	 * @return hndlOfcCd
	 */
	public String getHndlOfcCd() {
		return this.hndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return siNtfcEml
	 */
	public String getSiNtfcEml() {
		return this.siNtfcEml;
	}
	
	/**
	 * Column Info
	 * @return gsoOfcCd
	 */
	public String getGsoOfcCd() {
		return this.gsoOfcCd;
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
	 * @return chkOp
	 */
	public String getChkOp() {
		return this.chkOp;
	}
	
	/**
	 * Column Info
	 * @return bkgNtfcEml
	 */
	public String getBkgNtfcEml() {
		return this.bkgNtfcEml;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return hndlOfcSeq
	 */
	public String getHndlOfcSeq() {
		return this.hndlOfcSeq;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcTy
	 */
	public String getOfcTy() {
		return this.ofcTy;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param optionTp
	 */
	public void setOptionTp(String optionTp) {
		this.optionTp = optionTp;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param subGrpCtnt
	 */
	public void setSubGrpCtnt(String subGrpCtnt) {
		this.subGrpCtnt = subGrpCtnt;
	}
	
	/**
	 * Column Info
	 * @param hndlOfcCd
	 */
	public void setHndlOfcCd(String hndlOfcCd) {
		this.hndlOfcCd = hndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param siNtfcEml
	 */
	public void setSiNtfcEml(String siNtfcEml) {
		this.siNtfcEml = siNtfcEml;
	}
	
	/**
	 * Column Info
	 * @param gsoOfcCd
	 */
	public void setGsoOfcCd(String gsoOfcCd) {
		this.gsoOfcCd = gsoOfcCd;
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
	 * @param chkOp
	 */
	public void setChkOp(String chkOp) {
		this.chkOp = chkOp;
	}
	
	/**
	 * Column Info
	 * @param bkgNtfcEml
	 */
	public void setBkgNtfcEml(String bkgNtfcEml) {
		this.bkgNtfcEml = bkgNtfcEml;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param hndlOfcSeq
	 */
	public void setHndlOfcSeq(String hndlOfcSeq) {
		this.hndlOfcSeq = hndlOfcSeq;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcTy
	 */
	public void setOfcTy(String ofcTy) {
		this.ofcTy = ofcTy;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOptionTp(JSPUtil.getParameter(request, "option_tp", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setSubGrpCtnt(JSPUtil.getParameter(request, "sub_grp_ctnt", ""));
		setHndlOfcCd(JSPUtil.getParameter(request, "hndl_ofc_cd", ""));
		setSiNtfcEml(JSPUtil.getParameter(request, "si_ntfc_eml", ""));
		setGsoOfcCd(JSPUtil.getParameter(request, "gso_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChkOp(JSPUtil.getParameter(request, "chk_op", ""));
		setBkgNtfcEml(JSPUtil.getParameter(request, "bkg_ntfc_eml", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setHndlOfcSeq(JSPUtil.getParameter(request, "hndl_ofc_seq", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, "rgn_ofc_cd", ""));
		setOfcTy(JSPUtil.getParameter(request, "ofc_ty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgDocPerfOfcVO[]
	 */
	public BkgDocPerfOfcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgDocPerfOfcVO[]
	 */
	public BkgDocPerfOfcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgDocPerfOfcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] optionTp = (JSPUtil.getParameter(request, prefix	+ "option_tp", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] subGrpCtnt = (JSPUtil.getParameter(request, prefix	+ "sub_grp_ctnt", length));
			String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_cd", length));
			String[] siNtfcEml = (JSPUtil.getParameter(request, prefix	+ "si_ntfc_eml", length));
			String[] gsoOfcCd = (JSPUtil.getParameter(request, prefix	+ "gso_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chkOp = (JSPUtil.getParameter(request, prefix	+ "chk_op", length));
			String[] bkgNtfcEml = (JSPUtil.getParameter(request, prefix	+ "bkg_ntfc_eml", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] hndlOfcSeq = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_seq", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] ofcTy = (JSPUtil.getParameter(request, prefix	+ "ofc_ty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgDocPerfOfcVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (optionTp[i] != null)
					model.setOptionTp(optionTp[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (subGrpCtnt[i] != null)
					model.setSubGrpCtnt(subGrpCtnt[i]);
				if (hndlOfcCd[i] != null)
					model.setHndlOfcCd(hndlOfcCd[i]);
				if (siNtfcEml[i] != null)
					model.setSiNtfcEml(siNtfcEml[i]);
				if (gsoOfcCd[i] != null)
					model.setGsoOfcCd(gsoOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chkOp[i] != null)
					model.setChkOp(chkOp[i]);
				if (bkgNtfcEml[i] != null)
					model.setBkgNtfcEml(bkgNtfcEml[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (hndlOfcSeq[i] != null)
					model.setHndlOfcSeq(hndlOfcSeq[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (ofcTy[i] != null)
					model.setOfcTy(ofcTy[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgDocPerfOfcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgDocPerfOfcVO[]
	 */
	public BkgDocPerfOfcVO[] getBkgDocPerfOfcVOs(){
		BkgDocPerfOfcVO[] vos = (BkgDocPerfOfcVO[])models.toArray(new BkgDocPerfOfcVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optionTp = this.optionTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subGrpCtnt = this.subGrpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd = this.hndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siNtfcEml = this.siNtfcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gsoOfcCd = this.gsoOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOp = this.chkOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNtfcEml = this.bkgNtfcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcSeq = this.hndlOfcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTy = this.ofcTy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
