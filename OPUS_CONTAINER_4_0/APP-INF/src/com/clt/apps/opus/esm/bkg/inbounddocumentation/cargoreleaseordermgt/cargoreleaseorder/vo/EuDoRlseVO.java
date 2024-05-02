/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EuDoRlseVO.java
*@FileTitle : EuDoRlseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.24  
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

public class EuDoRlseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EuDoRlseVO> models = new ArrayList<EuDoRlseVO>();
	
	/* Column Info */
	private String doSplitFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cstmsRefNm = null;
	/* Column Info */
	private String oblRdemKnt = null;
	/* Column Info */
	private String cstmsAsgnCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String otrDocCgorFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cstmsRefCtnt = null;
	/* Column Info */
	private String cstmsAsgnNm = null;
	/* Column Info */
	private String blOtrDocRcvCd = null;
	/* Column Info */
	private String oblCngFlg = null;
	/* Column Info */
	private String doHldFlg = null;
	/* Column Info */
	private String doNo = null;
	/* F.O.C가 'Y' 가 아닐경우 남기는 Remark */
	private String cgorRmk = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EuDoRlseVO() {}

	public EuDoRlseVO(String ibflag, String pagerows, String bkgNo, String blNo, String doSplitFlg, String cstmsRefNm, String cstmsRefCtnt, String cstmsAsgnNm, String cstmsAsgnCtnt, String interRmk, String oblRdemKnt, String blOtrDocRcvCd, String otrDocCgorFlg, String usrId, String usrOfcCd, String oblCngFlg, String doHldFlg, String doNo,String cgorRmk) {
		this.doSplitFlg = doSplitFlg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cstmsRefNm = cstmsRefNm;
		this.oblRdemKnt = oblRdemKnt;
		this.cstmsAsgnCtnt = cstmsAsgnCtnt;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.usrOfcCd = usrOfcCd;
		this.interRmk = interRmk;
		this.otrDocCgorFlg = otrDocCgorFlg;
		this.usrId = usrId;
		this.cstmsRefCtnt = cstmsRefCtnt;
		this.cstmsAsgnNm = cstmsAsgnNm;
		this.blOtrDocRcvCd = blOtrDocRcvCd;
		this.oblCngFlg = oblCngFlg;
		this.doHldFlg = doHldFlg;
		this.doNo = doNo;
		this.cgorRmk = cgorRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_split_flg", getDoSplitFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_ref_nm", getCstmsRefNm());
		this.hashColumns.put("obl_rdem_knt", getOblRdemKnt());
		this.hashColumns.put("cstms_asgn_ctnt", getCstmsAsgnCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("otr_doc_cgor_flg", getOtrDocCgorFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cstms_ref_ctnt", getCstmsRefCtnt());
		this.hashColumns.put("cstms_asgn_nm", getCstmsAsgnNm());
		this.hashColumns.put("bl_otr_doc_rcv_cd", getBlOtrDocRcvCd());
		this.hashColumns.put("bl_otr_doc_rcv_cd", getBlOtrDocRcvCd());
		this.hashColumns.put("obl_cng_flg", getOblCngFlg());
		this.hashColumns.put("do_hld_flg", getDoHldFlg());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("cgor_rmk", getCgorRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("do_split_flg", "doSplitFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_ref_nm", "cstmsRefNm");
		this.hashFields.put("obl_rdem_knt", "oblRdemKnt");
		this.hashFields.put("cstms_asgn_ctnt", "cstmsAsgnCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("otr_doc_cgor_flg", "otrDocCgorFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cstms_ref_ctnt", "cstmsRefCtnt");
		this.hashFields.put("cstms_asgn_nm", "cstmsAsgnNm");
		this.hashFields.put("bl_otr_doc_rcv_cd", "blOtrDocRcvCd");
		this.hashFields.put("obl_cng_flg", "oblCngFlg");
		this.hashFields.put("do_hld_flg", "doHldFlg");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("cgor_rmk", "cgorRmk");
		return this.hashFields;
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
	 * @return cstmsRefNm
	 */
	public String getCstmsRefNm() {
		return this.cstmsRefNm;
	}
	
	/**
	 * Column Info
	 * @return oblRdemKnt
	 */
	public String getOblRdemKnt() {
		return this.oblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @return cstmsAsgnCtnt
	 */
	public String getCstmsAsgnCtnt() {
		return this.cstmsAsgnCtnt;
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
	 * @return usrOfcCd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
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
	 * @return otrDocCgorFlg
	 */
	public String getOtrDocCgorFlg() {
		return this.otrDocCgorFlg;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return blOtrDocRcvCd
	 */
	public String getBlOtrDocRcvCd() {
		return this.blOtrDocRcvCd;
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
	 * @return doHldFlg
	 */
	public String getDoHldFlg() {
		return this.doHldFlg;
	}

	/**
	 * Column Info
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * F.O.C 가 'Y'가 아닐경우 남기는 Remark
	 * @return cgor_rmk
	 */
	public String getCgorRmk() {
		return this.cgorRmk;
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
	 * @param cstmsRefNm
	 */
	public void setCstmsRefNm(String cstmsRefNm) {
		this.cstmsRefNm = cstmsRefNm;
	}
	
	/**
	 * Column Info
	 * @param oblRdemKnt
	 */
	public void setOblRdemKnt(String oblRdemKnt) {
		this.oblRdemKnt = oblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @param cstmsAsgnCtnt
	 */
	public void setCstmsAsgnCtnt(String cstmsAsgnCtnt) {
		this.cstmsAsgnCtnt = cstmsAsgnCtnt;
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
	 * @param usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
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
	 * @param otrDocCgorFlg
	 */
	public void setOtrDocCgorFlg(String otrDocCgorFlg) {
		this.otrDocCgorFlg = otrDocCgorFlg;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * Column Info
	 * @param blOtrDocRcvCd
	 */
	public void setBlOtrDocRcvCd(String blOtrDocRcvCd) {
		this.blOtrDocRcvCd = blOtrDocRcvCd;
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
	 * @param doHldFlg
	 */
	public void setDoHldFlg(String doHldFlg) {
		this.doHldFlg = doHldFlg;
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
	 * @param doNo
	 */
	public void setCgorRmk(String cgorRmk) {
		this.cgorRmk = cgorRmk;
	}
	
	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDoSplitFlg(JSPUtil.getParameter(request, "do_split_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCstmsRefNm(JSPUtil.getParameter(request, "cstms_ref_nm", ""));
		setOblRdemKnt(JSPUtil.getParameter(request, "obl_rdem_knt", ""));
		setCstmsAsgnCtnt(JSPUtil.getParameter(request, "cstms_asgn_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, "usr_ofc_cd", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setOtrDocCgorFlg(JSPUtil.getParameter(request, "otr_doc_cgor_flg", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCstmsRefCtnt(JSPUtil.getParameter(request, "cstms_ref_ctnt", ""));
		setCstmsAsgnNm(JSPUtil.getParameter(request, "cstms_asgn_nm", ""));
		setBlOtrDocRcvCd(JSPUtil.getParameter(request, "bl_otr_doc_rcv_cd", ""));
		setOblCngFlg(JSPUtil.getParameter(request, "obl_cng_flg", ""));
		setDoHldFlg(JSPUtil.getParameter(request, "do_hld_flg", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setCgorRmk(JSPUtil.getParameter(request, "cgor_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EuDoRlseVO[]
	 */
	public EuDoRlseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EuDoRlseVO[]
	 */
	public EuDoRlseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EuDoRlseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] doSplitFlg = (JSPUtil.getParameter(request, prefix	+ "do_split_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cstmsRefNm = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_nm", length));
			String[] oblRdemKnt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_knt", length));
			String[] cstmsAsgnCtnt = (JSPUtil.getParameter(request, prefix	+ "cstms_asgn_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] otrDocCgorFlg = (JSPUtil.getParameter(request, prefix	+ "otr_doc_cgor_flg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cstmsRefCtnt = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_ctnt", length));
			String[] cstmsAsgnNm = (JSPUtil.getParameter(request, prefix	+ "cstms_asgn_nm", length));
			String[] blOtrDocRcvCd = (JSPUtil.getParameter(request, prefix	+ "bl_otr_doc_rcv_cd", length));
			String[] oblCngFlg = (JSPUtil.getParameter(request, prefix	+ "obl_cng_flg", length));
			String[] doHldFlg = (JSPUtil.getParameter(request, prefix	+ "do_hld_flg", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] cgorRmk = (JSPUtil.getParameter(request, prefix	+ "cgor_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EuDoRlseVO();
				if (doSplitFlg[i] != null)
					model.setDoSplitFlg(doSplitFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsRefNm[i] != null)
					model.setCstmsRefNm(cstmsRefNm[i]);
				if (oblRdemKnt[i] != null)
					model.setOblRdemKnt(oblRdemKnt[i]);
				if (cstmsAsgnCtnt[i] != null)
					model.setCstmsAsgnCtnt(cstmsAsgnCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (otrDocCgorFlg[i] != null)
					model.setOtrDocCgorFlg(otrDocCgorFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cstmsRefCtnt[i] != null)
					model.setCstmsRefCtnt(cstmsRefCtnt[i]);
				if (cstmsAsgnNm[i] != null)
					model.setCstmsAsgnNm(cstmsAsgnNm[i]);
				if (blOtrDocRcvCd[i] != null)
					model.setBlOtrDocRcvCd(blOtrDocRcvCd[i]);
				if (oblCngFlg[i] != null)
					model.setOblCngFlg(oblCngFlg[i]);
				if (doHldFlg[i] != null)
					model.setDoHldFlg(doHldFlg[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (cgorRmk[i] != null)
					model.setCgorRmk(cgorRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEuDoRlseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EuDoRlseVO[]
	 */
	public EuDoRlseVO[] getEuDoRlseVOs(){
		EuDoRlseVO[] vos = (EuDoRlseVO[])models.toArray(new EuDoRlseVO[models.size()]);
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
		this.doSplitFlg = this.doSplitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefNm = this.cstmsRefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemKnt = this.oblRdemKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAsgnCtnt = this.cstmsAsgnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocCgorFlg = this.otrDocCgorFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefCtnt = this.cstmsRefCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAsgnNm = this.cstmsAsgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blOtrDocRcvCd = this.blOtrDocRcvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblCngFlg = this.oblCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doHldFlg = this.doHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorRmk = this.cgorRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
