/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCllRemarkVO.java
*@FileTitle : KorCllRemarkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.14
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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

public class KorCllRemarkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorCllRemarkVO> models = new ArrayList<KorCllRemarkVO>();

	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String setFm = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String cntrListNo = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String krTmlRmkTpId = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String setTo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorCllRemarkVO() {}

	public KorCllRemarkVO(String ibflag, String pagerows, String cntrListNo, String krTmlRmkTpId, String diffRmk, String creUsrId, String updUsrId, String remark, String setTo, String setFm, String inVvdCd, String inPolCd) {
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.setFm = setFm;
		this.remark = remark;
		this.cntrListNo = cntrListNo;
		this.inPolCd = inPolCd;
		this.krTmlRmkTpId = krTmlRmkTpId;
		this.inVvdCd = inVvdCd;
		this.updUsrId = updUsrId;
		this.setTo = setTo;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("set_fm", getSetFm());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("cntr_list_no", getCntrListNo());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("kr_tml_rmk_tp_id", getKrTmlRmkTpId());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("set_to", getSetTo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("set_fm", "setFm");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("cntr_list_no", "cntrListNo");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("kr_tml_rmk_tp_id", "krTmlRmkTpId");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("set_to", "setTo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}

	/**
	 * Column Info
	 * @return setFm
	 */
	public String getSetFm() {
		return this.setFm;
	}

	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * Column Info
	 * @return cntrListNo
	 */
	public String getCntrListNo() {
		return this.cntrListNo;
	}

	/**
	 * Column Info
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
	}

	/**
	 * Column Info
	 * @return krTmlRmkTpId
	 */
	public String getKrTmlRmkTpId() {
		return this.krTmlRmkTpId;
	}

	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
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
	 * @return setTo
	 */
	public String getSetTo() {
		return this.setTo;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}

	/**
	 * Column Info
	 * @param setFm
	 */
	public void setSetFm(String setFm) {
		this.setFm = setFm;
	}

	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Column Info
	 * @param cntrListNo
	 */
	public void setCntrListNo(String cntrListNo) {
		this.cntrListNo = cntrListNo;
	}

	/**
	 * Column Info
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
	}

	/**
	 * Column Info
	 * @param krTmlRmkTpId
	 */
	public void setKrTmlRmkTpId(String krTmlRmkTpId) {
		this.krTmlRmkTpId = krTmlRmkTpId;
	}

	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
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
	 * @param setTo
	 */
	public void setSetTo(String setTo) {
		this.setTo = setTo;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setSetFm(JSPUtil.getParameter(request, "set_fm", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setCntrListNo(JSPUtil.getParameter(request, "cntr_list_no", ""));
		setInPolCd(JSPUtil.getParameter(request, "in_pol_cd", ""));
		setKrTmlRmkTpId(JSPUtil.getParameter(request, "kr_tml_rmk_tp_id", ""));
		setInVvdCd(JSPUtil.getParameter(request, "in_vvd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSetTo(JSPUtil.getParameter(request, "set_to", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllRemarkVO[]
	 */
	public KorCllRemarkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorCllRemarkVO[]
	 */
	public KorCllRemarkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCllRemarkVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] setFm = (JSPUtil.getParameter(request, prefix	+ "set_fm", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] cntrListNo = (JSPUtil.getParameter(request, prefix	+ "cntr_list_no", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] krTmlRmkTpId = (JSPUtil.getParameter(request, prefix	+ "kr_tml_rmk_tp_id", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] setTo = (JSPUtil.getParameter(request, prefix	+ "set_to", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorCllRemarkVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (setFm[i] != null)
					model.setSetFm(setFm[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (cntrListNo[i] != null)
					model.setCntrListNo(cntrListNo[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (krTmlRmkTpId[i] != null)
					model.setKrTmlRmkTpId(krTmlRmkTpId[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (setTo[i] != null)
					model.setSetTo(setTo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCllRemarkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCllRemarkVO[]
	 */
	public KorCllRemarkVO[] getKorCllRemarkVOs(){
		KorCllRemarkVO[] vos = (KorCllRemarkVO[])models.toArray(new KorCllRemarkVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.setFm = this.setFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrListNo = this.cntrListNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krTmlRmkTpId = this.krTmlRmkTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.setTo = this.setTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
