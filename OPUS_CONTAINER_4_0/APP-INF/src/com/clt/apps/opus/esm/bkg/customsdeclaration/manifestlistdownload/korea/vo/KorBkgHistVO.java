/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorBkgHistVO.java
*@FileTitle : KorBkgHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.13 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorBkgHistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorBkgHistVO> models = new ArrayList<KorBkgHistVO>();

	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldMsnDiscloc = null;
	/* Column Info */
	private String histDtlSeq = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String newMsnDiscloc = null;
	/* Column Info */
	private String histSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorBkgHistVO() {}

	public KorBkgHistVO(String ibflag, String pagerows, String histDtlSeq, String usrId, String histSeq, String bkgNo, String oldMsnDiscloc, String newMsnDiscloc) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.oldMsnDiscloc = oldMsnDiscloc;
		this.histDtlSeq = histDtlSeq;
		this.usrId = usrId;
		this.newMsnDiscloc = newMsnDiscloc;
		this.histSeq = histSeq;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("old_msn_discloc", getOldMsnDiscloc());
		this.hashColumns.put("hist_dtl_seq", getHistDtlSeq());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("new_msn_discloc", getNewMsnDiscloc());
		this.hashColumns.put("hist_seq", getHistSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("old_msn_discloc", "oldMsnDiscloc");
		this.hashFields.put("hist_dtl_seq", "histDtlSeq");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("new_msn_discloc", "newMsnDiscloc");
		this.hashFields.put("hist_seq", "histSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return oldMsnDiscloc
	 */
	public String getOldMsnDiscloc() {
		return this.oldMsnDiscloc;
	}

	/**
	 * Column Info
	 * @return histDtlSeq
	 */
	public String getHistDtlSeq() {
		return this.histDtlSeq;
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
	 * @return newMsnDiscloc
	 */
	public String getNewMsnDiscloc() {
		return this.newMsnDiscloc;
	}

	/**
	 * Column Info
	 * @return histSeq
	 */
	public String getHistSeq() {
		return this.histSeq;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param oldMsnDiscloc
	 */
	public void setOldMsnDiscloc(String oldMsnDiscloc) {
		this.oldMsnDiscloc = oldMsnDiscloc;
	}

	/**
	 * Column Info
	 * @param histDtlSeq
	 */
	public void setHistDtlSeq(String histDtlSeq) {
		this.histDtlSeq = histDtlSeq;
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
	 * @param newMsnDiscloc
	 */
	public void setNewMsnDiscloc(String newMsnDiscloc) {
		this.newMsnDiscloc = newMsnDiscloc;
	}

	/**
	 * Column Info
	 * @param histSeq
	 */
	public void setHistSeq(String histSeq) {
		this.histSeq = histSeq;
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
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOldMsnDiscloc(JSPUtil.getParameter(request, "old_msn_discloc", ""));
		setHistDtlSeq(JSPUtil.getParameter(request, "hist_dtl_seq", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setNewMsnDiscloc(JSPUtil.getParameter(request, "new_msn_discloc", ""));
		setHistSeq(JSPUtil.getParameter(request, "hist_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorBkgHistVO[]
	 */
	public KorBkgHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorBkgHistVO[]
	 */
	public KorBkgHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBkgHistVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldMsnDiscloc = (JSPUtil.getParameter(request, prefix	+ "old_msn_discloc", length));
			String[] histDtlSeq = (JSPUtil.getParameter(request, prefix	+ "hist_dtl_seq", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] newMsnDiscloc = (JSPUtil.getParameter(request, prefix	+ "new_msn_discloc", length));
			String[] histSeq = (JSPUtil.getParameter(request, prefix	+ "hist_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorBkgHistVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldMsnDiscloc[i] != null)
					model.setOldMsnDiscloc(oldMsnDiscloc[i]);
				if (histDtlSeq[i] != null)
					model.setHistDtlSeq(histDtlSeq[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (newMsnDiscloc[i] != null)
					model.setNewMsnDiscloc(newMsnDiscloc[i]);
				if (histSeq[i] != null)
					model.setHistSeq(histSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorBkgHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorBkgHistVO[]
	 */
	public KorBkgHistVO[] getKorBkgHistVOs(){
		KorBkgHistVO[] vos = (KorBkgHistVO[])models.toArray(new KorBkgHistVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldMsnDiscloc = this.oldMsnDiscloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.histDtlSeq = this.histDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newMsnDiscloc = this.newMsnDiscloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.histSeq = this.histSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
