/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MGSTermChangeResultINVO.java
*@FileTitle : MGSTermChangeResultINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.03 김창식 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo;

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
 * @author 김창식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSTermChangeResultINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSTermChangeResultINVO> models = new ArrayList<MGSTermChangeResultINVO>();
	
	/* Column Info */
	private String stsEvntOfcCd = null;
	/* Column Info */
	private String stsEvntDtFr = null;
	/* Column Info */
	private String eqTpszCdUmg = null;
	/* Column Info */
	private String newAgmtLstmCd = null;
	/* Column Info */
	private String oldAgmtLstmCd = null;
	/* Column Info */
	private String newAgmtNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String viewflg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newVndrSeq = null;
	/* Column Info */
	private String eqTpszCdClg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String oldAgmtNo = null;
	/* Column Info */
	private String stsEvntDtTo = null;
	/* Column Info */
	private String oldVndrSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSTermChangeResultINVO() {}

	public MGSTermChangeResultINVO(String ibflag, String pagerows, String eqKndCd, String stsEvntDtFr, String stsEvntDtTo, String viewflg, String vndrSeq, String stsEvntOfcCd, String oldVndrSeq, String oldAgmtNo, String oldAgmtLstmCd, String newVndrSeq, String newAgmtNo, String newAgmtLstmCd, String eqTpszCdClg, String eqTpszCdUmg) {
		this.stsEvntOfcCd = stsEvntOfcCd;
		this.stsEvntDtFr = stsEvntDtFr;
		this.eqTpszCdUmg = eqTpszCdUmg;
		this.newAgmtLstmCd = newAgmtLstmCd;
		this.oldAgmtLstmCd = oldAgmtLstmCd;
		this.newAgmtNo = newAgmtNo;
		this.eqKndCd = eqKndCd;
		this.viewflg = viewflg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.newVndrSeq = newVndrSeq;
		this.eqTpszCdClg = eqTpszCdClg;
		this.vndrSeq = vndrSeq;
		this.oldAgmtNo = oldAgmtNo;
		this.stsEvntDtTo = stsEvntDtTo;
		this.oldVndrSeq = oldVndrSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sts_evnt_ofc_cd", getStsEvntOfcCd());
		this.hashColumns.put("sts_evnt_dt_fr", getStsEvntDtFr());
		this.hashColumns.put("eq_tpsz_cd_umg", getEqTpszCdUmg());
		this.hashColumns.put("new_agmt_lstm_cd", getNewAgmtLstmCd());
		this.hashColumns.put("old_agmt_lstm_cd", getOldAgmtLstmCd());
		this.hashColumns.put("new_agmt_no", getNewAgmtNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("viewflg", getViewflg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("new_vndr_seq", getNewVndrSeq());
		this.hashColumns.put("eq_tpsz_cd_clg", getEqTpszCdClg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("old_agmt_no", getOldAgmtNo());
		this.hashColumns.put("sts_evnt_dt_to", getStsEvntDtTo());
		this.hashColumns.put("old_vndr_seq", getOldVndrSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sts_evnt_ofc_cd", "stsEvntOfcCd");
		this.hashFields.put("sts_evnt_dt_fr", "stsEvntDtFr");
		this.hashFields.put("eq_tpsz_cd_umg", "eqTpszCdUmg");
		this.hashFields.put("new_agmt_lstm_cd", "newAgmtLstmCd");
		this.hashFields.put("old_agmt_lstm_cd", "oldAgmtLstmCd");
		this.hashFields.put("new_agmt_no", "newAgmtNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("viewflg", "viewflg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("new_vndr_seq", "newVndrSeq");
		this.hashFields.put("eq_tpsz_cd_clg", "eqTpszCdClg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("old_agmt_no", "oldAgmtNo");
		this.hashFields.put("sts_evnt_dt_to", "stsEvntDtTo");
		this.hashFields.put("old_vndr_seq", "oldVndrSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stsEvntOfcCd
	 */
	public String getStsEvntOfcCd() {
		return this.stsEvntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return stsEvntDtFr
	 */
	public String getStsEvntDtFr() {
		return this.stsEvntDtFr;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdUmg
	 */
	public String getEqTpszCdUmg() {
		return this.eqTpszCdUmg;
	}
	
	/**
	 * Column Info
	 * @return newAgmtLstmCd
	 */
	public String getNewAgmtLstmCd() {
		return this.newAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return oldAgmtLstmCd
	 */
	public String getOldAgmtLstmCd() {
		return this.oldAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return newAgmtNo
	 */
	public String getNewAgmtNo() {
		return this.newAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return viewflg
	 */
	public String getViewflg() {
		return this.viewflg;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return newVndrSeq
	 */
	public String getNewVndrSeq() {
		return this.newVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdClg
	 */
	public String getEqTpszCdClg() {
		return this.eqTpszCdClg;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return oldAgmtNo
	 */
	public String getOldAgmtNo() {
		return this.oldAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return stsEvntDtTo
	 */
	public String getStsEvntDtTo() {
		return this.stsEvntDtTo;
	}
	
	/**
	 * Column Info
	 * @return oldVndrSeq
	 */
	public String getOldVndrSeq() {
		return this.oldVndrSeq;
	}
	

	/**
	 * Column Info
	 * @param stsEvntOfcCd
	 */
	public void setStsEvntOfcCd(String stsEvntOfcCd) {
		this.stsEvntOfcCd = stsEvntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param stsEvntDtFr
	 */
	public void setStsEvntDtFr(String stsEvntDtFr) {
		this.stsEvntDtFr = stsEvntDtFr;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdUmg
	 */
	public void setEqTpszCdUmg(String eqTpszCdUmg) {
		this.eqTpszCdUmg = eqTpszCdUmg;
	}
	
	/**
	 * Column Info
	 * @param newAgmtLstmCd
	 */
	public void setNewAgmtLstmCd(String newAgmtLstmCd) {
		this.newAgmtLstmCd = newAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param oldAgmtLstmCd
	 */
	public void setOldAgmtLstmCd(String oldAgmtLstmCd) {
		this.oldAgmtLstmCd = oldAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param newAgmtNo
	 */
	public void setNewAgmtNo(String newAgmtNo) {
		this.newAgmtNo = newAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param viewflg
	 */
	public void setViewflg(String viewflg) {
		this.viewflg = viewflg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param newVndrSeq
	 */
	public void setNewVndrSeq(String newVndrSeq) {
		this.newVndrSeq = newVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdClg
	 */
	public void setEqTpszCdClg(String eqTpszCdClg) {
		this.eqTpszCdClg = eqTpszCdClg;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param oldAgmtNo
	 */
	public void setOldAgmtNo(String oldAgmtNo) {
		this.oldAgmtNo = oldAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param stsEvntDtTo
	 */
	public void setStsEvntDtTo(String stsEvntDtTo) {
		this.stsEvntDtTo = stsEvntDtTo;
	}
	
	/**
	 * Column Info
	 * @param oldVndrSeq
	 */
	public void setOldVndrSeq(String oldVndrSeq) {
		this.oldVndrSeq = oldVndrSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStsEvntOfcCd(JSPUtil.getParameter(request, "sts_evnt_ofc_cd", ""));
		setStsEvntDtFr(JSPUtil.getParameter(request, "sts_evnt_dt_fr", ""));
		setEqTpszCdUmg(JSPUtil.getParameter(request, "eq_tpsz_cd_umg", ""));
		setNewAgmtLstmCd(JSPUtil.getParameter(request, "new_agmt_lstm_cd", ""));
		setOldAgmtLstmCd(JSPUtil.getParameter(request, "old_agmt_lstm_cd", ""));
		setNewAgmtNo(JSPUtil.getParameter(request, "new_agmt_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setViewflg(JSPUtil.getParameter(request, "viewflg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNewVndrSeq(JSPUtil.getParameter(request, "new_vndr_seq", ""));
		setEqTpszCdClg(JSPUtil.getParameter(request, "eq_tpsz_cd_clg", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setOldAgmtNo(JSPUtil.getParameter(request, "old_agmt_no", ""));
		setStsEvntDtTo(JSPUtil.getParameter(request, "sts_evnt_dt_to", ""));
		setOldVndrSeq(JSPUtil.getParameter(request, "old_vndr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSTermChangeResultINVO[]
	 */
	public MGSTermChangeResultINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MGSTermChangeResultINVO[]
	 */
	public MGSTermChangeResultINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSTermChangeResultINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stsEvntOfcCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_ofc_cd", length));
			String[] stsEvntDtFr = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt_fr", length));
			String[] eqTpszCdUmg = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_umg", length));
			String[] newAgmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "new_agmt_lstm_cd", length));
			String[] oldAgmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "old_agmt_lstm_cd", length));
			String[] newAgmtNo = (JSPUtil.getParameter(request, prefix	+ "new_agmt_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] viewflg = (JSPUtil.getParameter(request, prefix	+ "viewflg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] newVndrSeq = (JSPUtil.getParameter(request, prefix	+ "new_vndr_seq", length));
			String[] eqTpszCdClg = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_clg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] oldAgmtNo = (JSPUtil.getParameter(request, prefix	+ "old_agmt_no", length));
			String[] stsEvntDtTo = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt_to", length));
			String[] oldVndrSeq = (JSPUtil.getParameter(request, prefix	+ "old_vndr_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSTermChangeResultINVO();
				if (stsEvntOfcCd[i] != null)
					model.setStsEvntOfcCd(stsEvntOfcCd[i]);
				if (stsEvntDtFr[i] != null)
					model.setStsEvntDtFr(stsEvntDtFr[i]);
				if (eqTpszCdUmg[i] != null)
					model.setEqTpszCdUmg(eqTpszCdUmg[i]);
				if (newAgmtLstmCd[i] != null)
					model.setNewAgmtLstmCd(newAgmtLstmCd[i]);
				if (oldAgmtLstmCd[i] != null)
					model.setOldAgmtLstmCd(oldAgmtLstmCd[i]);
				if (newAgmtNo[i] != null)
					model.setNewAgmtNo(newAgmtNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (viewflg[i] != null)
					model.setViewflg(viewflg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newVndrSeq[i] != null)
					model.setNewVndrSeq(newVndrSeq[i]);
				if (eqTpszCdClg[i] != null)
					model.setEqTpszCdClg(eqTpszCdClg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (oldAgmtNo[i] != null)
					model.setOldAgmtNo(oldAgmtNo[i]);
				if (stsEvntDtTo[i] != null)
					model.setStsEvntDtTo(stsEvntDtTo[i]);
				if (oldVndrSeq[i] != null)
					model.setOldVndrSeq(oldVndrSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMGSTermChangeResultINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MGSTermChangeResultINVO[]
	 */
	public MGSTermChangeResultINVO[] getMGSTermChangeResultINVOs(){
		MGSTermChangeResultINVO[] vos = (MGSTermChangeResultINVO[])models.toArray(new MGSTermChangeResultINVO[models.size()]);
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
		this.stsEvntOfcCd = this.stsEvntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDtFr = this.stsEvntDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdUmg = this.eqTpszCdUmg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtLstmCd = this.newAgmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtLstmCd = this.oldAgmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtNo = this.newAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewflg = this.viewflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVndrSeq = this.newVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdClg = this.eqTpszCdClg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtNo = this.oldAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDtTo = this.stsEvntDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldVndrSeq = this.oldVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
