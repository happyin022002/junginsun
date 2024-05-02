/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CreatorVO.java
*@FileTitle : CreatorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.16 손윤석
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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CreatorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CreatorVO> models = new ArrayList<CreatorVO>();

	/* Column Info */
	private String office = null;
	/* Column Info */
	private String mrnPort = null;
	/* Column Info */
	private String mrnChk = null;
	/* Column Info */
	private String username = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String kdhSeq = null;
	/* Column Info */
	private String mrnNbr = null;
	/* Column Info */
	private String actionTime = null;
	/* Column Info */
	private String bound = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CreatorVO() {}

	public CreatorVO(String ibflag, String pagerows, String mrnNbr, String mrnChk, String vvdCd, String kdhSeq, String bound, String mrnPort, String office, String username, String actionTime) {
		this.office = office;
		this.mrnPort = mrnPort;
		this.mrnChk = mrnChk;
		this.username = username;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.kdhSeq = kdhSeq;
		this.mrnNbr = mrnNbr;
		this.actionTime = actionTime;
		this.bound = bound;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("mrn_port", getMrnPort());
		this.hashColumns.put("mrn_chk", getMrnChk());
		this.hashColumns.put("username", getUsername());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("kdh_seq", getKdhSeq());
		this.hashColumns.put("mrn_nbr", getMrnNbr());
		this.hashColumns.put("action_time", getActionTime());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("mrn_port", "mrnPort");
		this.hashFields.put("mrn_chk", "mrnChk");
		this.hashFields.put("username", "username");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("kdh_seq", "kdhSeq");
		this.hashFields.put("mrn_nbr", "mrnNbr");
		this.hashFields.put("action_time", "actionTime");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}

	/**
	 * Column Info
	 * @return mrnPort
	 */
	public String getMrnPort() {
		return this.mrnPort;
	}

	/**
	 * Column Info
	 * @return mrnChk
	 */
	public String getMrnChk() {
		return this.mrnChk;
	}

	/**
	 * Column Info
	 * @return username
	 */
	public String getUsername() {
		return this.username;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}

	/**
	 * Column Info
	 * @return kdhSeq
	 */
	public String getKdhSeq() {
		return this.kdhSeq;
	}

	/**
	 * Column Info
	 * @return mrnNbr
	 */
	public String getMrnNbr() {
		return this.mrnNbr;
	}

	/**
	 * Column Info
	 * @return actionTime
	 */
	public String getActionTime() {
		return this.actionTime;
	}

	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
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
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}

	/**
	 * Column Info
	 * @param mrnPort
	 */
	public void setMrnPort(String mrnPort) {
		this.mrnPort = mrnPort;
	}

	/**
	 * Column Info
	 * @param mrnChk
	 */
	public void setMrnChk(String mrnChk) {
		this.mrnChk = mrnChk;
	}

	/**
	 * Column Info
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * Column Info
	 * @param kdhSeq
	 */
	public void setKdhSeq(String kdhSeq) {
		this.kdhSeq = kdhSeq;
	}

	/**
	 * Column Info
	 * @param mrnNbr
	 */
	public void setMrnNbr(String mrnNbr) {
		this.mrnNbr = mrnNbr;
	}

	/**
	 * Column Info
	 * @param actionTime
	 */
	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
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
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setMrnPort(JSPUtil.getParameter(request, "mrn_port", ""));
		setMrnChk(JSPUtil.getParameter(request, "mrn_chk", ""));
		setUsername(JSPUtil.getParameter(request, "username", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setKdhSeq(JSPUtil.getParameter(request, "kdh_seq", ""));
		setMrnNbr(JSPUtil.getParameter(request, "mrn_nbr", ""));
		setActionTime(JSPUtil.getParameter(request, "action_time", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreatorVO[]
	 */
	public CreatorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CreatorVO[]
	 */
	public CreatorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreatorVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] mrnPort = (JSPUtil.getParameter(request, prefix	+ "mrn_port", length));
			String[] mrnChk = (JSPUtil.getParameter(request, prefix	+ "mrn_chk", length));
			String[] username = (JSPUtil.getParameter(request, prefix	+ "username", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] kdhSeq = (JSPUtil.getParameter(request, prefix	+ "kdh_seq", length));
			String[] mrnNbr = (JSPUtil.getParameter(request, prefix	+ "mrn_nbr", length));
			String[] actionTime = (JSPUtil.getParameter(request, prefix	+ "action_time", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new CreatorVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (mrnPort[i] != null)
					model.setMrnPort(mrnPort[i]);
				if (mrnChk[i] != null)
					model.setMrnChk(mrnChk[i]);
				if (username[i] != null)
					model.setUsername(username[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (kdhSeq[i] != null)
					model.setKdhSeq(kdhSeq[i]);
				if (mrnNbr[i] != null)
					model.setMrnNbr(mrnNbr[i]);
				if (actionTime[i] != null)
					model.setActionTime(actionTime[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreatorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreatorVO[]
	 */
	public CreatorVO[] getCreatorVOs(){
		CreatorVO[] vos = (CreatorVO[])models.toArray(new CreatorVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPort = this.mrnPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnChk = this.mrnChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.username = this.username .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kdhSeq = this.kdhSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNbr = this.mrnNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionTime = this.actionTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
