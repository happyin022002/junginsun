/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorDgCgoManifestCondVO.java
*@FileTitle : KorDgCgoManifestCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.27 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DgCgoManifestCondVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see DgCgoManifestCondVO
 */

public class KorDgCgoManifestCondVO extends DgCgoManifestCondVO {

	private static final long serialVersionUID = 1L;

	private Collection<KorDgCgoManifestCondVO> models = new ArrayList<KorDgCgoManifestCondVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String userId = null;
	/* Page Number */
	private String pagerows = null;
	/* Delete Button check YN */
	private String deleteBtnChkYN = null;

	private BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO = null;
	private BkgCstmsKrDgCgoVO[] bkgCstmsKrDgCgoVOs = null;

	/**
	 * @return the bkgCstmsKrDgCgoVvdVO
	 */
	public BkgCstmsKrDgCgoVvdVO getBkgCstmsKrDgCgoVvdVO() {
		return bkgCstmsKrDgCgoVvdVO;
	}

	/**
	 * @param bkgCstmsKrDgCgoVvdVO the bkgCstmsKrDgCgoVvdVO to set
	 */
	public void setBkgCstmsKrDgCgoVvdVO(BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO) {
		this.bkgCstmsKrDgCgoVvdVO = bkgCstmsKrDgCgoVvdVO;
	}

	/**
	 * @return the bkgCstmsKrDgCgoVOs
	 */
	public BkgCstmsKrDgCgoVO[] getBkgCstmsKrDgCgoVOs() {
		return bkgCstmsKrDgCgoVOs;
	}

	/**
	 * @param bkgCstmsKrDgCgoVOs the bkgCstmsKrDgCgoVOs to set
	 */
	public void setBkgCstmsKrDgCgoVOs(BkgCstmsKrDgCgoVO[] bkgCstmsKrDgCgoVOs) {
		this.bkgCstmsKrDgCgoVOs = bkgCstmsKrDgCgoVOs;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorDgCgoManifestCondVO() {}

	public KorDgCgoManifestCondVO(String ibflag, String deleteBtnChkYN, String pagerows, String userId) {
		this.ibflag = ibflag;
		this.userId = userId;
		this.pagerows = pagerows;
		this.deleteBtnChkYN = deleteBtnChkYN;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("deleteBtnChkYN", getDeleteBtnChkYN());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("deleteBtnChkYN", "deleteBtnChkYN");
		return this.hashFields;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Column Info
	 * @return deleteBtnChkYN
	 */
	public String getDeleteBtnChkYN() {
		return this.deleteBtnChkYN;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * @param userId
	 */
	public void setDeleteBtnChkYN(String deleteBtnChkYN) {
		this.deleteBtnChkYN = deleteBtnChkYN;
	}

	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setDeleteBtnChkYN (JSPUtil.getParameter(request, "deleteBtnChkYN", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorDgCgoManifestCondVO[]
	 */
	public KorDgCgoManifestCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorDgCgoManifestCondVO[]
	 */
	public KorDgCgoManifestCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorDgCgoManifestCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] deleteBtnChkYN = (JSPUtil.getParameter(request, prefix	+ "deleteBtnChkYN", length));

			for (int i = 0; i < length; i++) {
				model = new KorDgCgoManifestCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (deleteBtnChkYN[i] != null)
					model.setDeleteBtnChkYN(deleteBtnChkYN[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorDgCgoManifestCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorDgCgoManifestCondVO[]
	 */
	public KorDgCgoManifestCondVO[] getKorDgCgoManifestCondVOs(){
		KorDgCgoManifestCondVO[] vos = (KorDgCgoManifestCondVO[])models.toArray(new KorDgCgoManifestCondVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deleteBtnChkYN = this.deleteBtnChkYN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
