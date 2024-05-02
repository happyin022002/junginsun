/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RestrictCmdtFileVO.java
*@FileTitle : RestrictCmdtFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.26  Lee InYoung
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgImpImgStoVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Lee InYoung
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RestrictCmdtFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	private SignOnUserAccount account = null;
	private BkgImpImgStoVO[] bkgImpImgStoVOs = null;
	private String[] Keys= null;

	private Collection<RestrictCmdtFileVO> models = new ArrayList<RestrictCmdtFileVO>();
	
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String dpSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;

	/**
	 * @return the keys
	 */
	public String[] getKeys() {
		return Keys;
	}

	/**
	 * @param keys the keys to set
	 */
	public void setKeys(String[] keys) {
		Keys = keys;
	}
	/**
	 * @return the bkgImgStoVOs
	 */
	public BkgImpImgStoVO[] getBkgImpImgStoVOs() {
		return bkgImpImgStoVOs;
	}

	/**
	 * @param BkgImpImgStoVO the bkgImpImgStoVOs to set
	 */
	public void setBkgImpImgStoVOs(BkgImpImgStoVO[] bkgImpImgStoVOs) {
		this.bkgImpImgStoVOs = bkgImpImgStoVOs;
	}

	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RestrictCmdtFileVO() {}

	public RestrictCmdtFileVO(String ibflag, String pagerows, String rgnOfcCd, String locCd, String cntCd, String dpSeq) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.rgnOfcCd = rgnOfcCd;
		this.locCd = locCd;
		this.cntCd = cntCd;
		this.dpSeq =dpSeq;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("dp_seq", getDpSeq());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("dp_seq", "dpSeq");
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getRgnOfcCd() {
		return rgnOfcCd;
	}

	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}

	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	public String getDpSeq() {
		return dpSeq;
	}

	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, "rgn_ofc_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setDpSeq(JSPUtil.getParameter(request, "dp_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RestrictCmdtFileVO[]
	 */
	public RestrictCmdtFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SpclRiderInVO[]
	 */
	public RestrictCmdtFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RestrictCmdtFileVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new RestrictCmdtFileVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRestrictCmdtFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RestrictCmdtFileVO[]
	 */
	public RestrictCmdtFileVO[] getRestrictCmdtFileVOs(){
		RestrictCmdtFileVO[] vos = (RestrictCmdtFileVO[])models.toArray(new RestrictCmdtFileVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
