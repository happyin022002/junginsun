/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorMrnInfoVO.java
*@FileTitle : KorMrnInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.03 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
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

public class KorMsnCreateVO extends ManifestListCondVO {

	private static final long serialVersionUID = 1L;

	private Collection<KorMsnCreateVO> models = new ArrayList<KorMsnCreateVO>();

	/* Column Info */
	private String inMrnMode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inSkdDirCd = null;
	/* Column Info */
	private String inPort = null;
	/* Column Info */
	private String inVslCd = null;
	/* Column Info */
	private String inSkdVoyageNo = null;
	/* Column Info */
	private String inMrnNo = null;
	/* Column Info */
	private String inMrnChkNo = null;
	/* Page Number */
	private String pagerows = null;
	private String userid = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorMsnCreateVO() {}

	public KorMsnCreateVO(String ibflag, String pagerows, String inMrnNo, String inVslCd, String inSkdVoyageNo, String inSkdDirCd, String inMrnMode, String inPort, String userid, String inMrnChkNo) {
		this.inMrnMode = inMrnMode;
		this.ibflag = ibflag;
		this.inSkdDirCd = inSkdDirCd;
		this.inPort = inPort;
		this.inVslCd = inVslCd;
		this.inSkdVoyageNo = inSkdVoyageNo;
		this.inMrnNo = inMrnNo;
		this.inMrnChkNo = inMrnChkNo;
		this.pagerows = pagerows;
		this.userid = userid;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_mrn_mode", getInMrnMode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_skd_dir_cd", getInSkdDirCd());
		this.hashColumns.put("in_port", getInPort());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("in_skd_voyage_no", getInSkdVoyageNo());
		this.hashColumns.put("in_mrn_no", getInMrnNo());
		this.hashColumns.put("in_mrn_chk_no", getInMrnChkNo());
		this.hashColumns.put("userid", getUserid());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_mrn_mode", "inMrnMode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_skd_dir_cd", "inSkdDirCd");
		this.hashFields.put("in_port", "inPort");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("in_skd_voyage_no", "inSkdVoyageNo");
		this.hashFields.put("in_mrn_no", "inMrnNo");
		this.hashFields.put("in_mrn_chk_no", "inMrnChkNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("userid", "userid");
		return this.hashFields;
	}

	/**
	 * @return the inMrnChkNo
	 */
	public String getInMrnChkNo() {
		return inMrnChkNo;
	}

	/**
	 * @param inMrnChkNo the inMrnChkNo to set
	 */
	public void setInMrnChkNo(String inMrnChkNo) {
		this.inMrnChkNo = inMrnChkNo;
	}

	/**
	 * Column Info
	 * @return inMrnMode
	 */
	public String getInMrnMode() {
		return this.inMrnMode;
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
	 * @return inSkdDirCd
	 */
	public String getInSkdDirCd() {
		return this.inSkdDirCd;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * Column Info
	 * @return inPort
	 */
	public String getInPort() {
		return this.inPort;
	}

	/**
	 * Column Info
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
	}

	/**
	 * Column Info
	 * @return inSkdVoyageNo
	 */
	public String getInSkdVoyageNo() {
		return this.inSkdVoyageNo;
	}

	/**
	 * Column Info
	 * @return inMrnNo
	 */
	public String getInMrnNo() {
		return this.inMrnNo;
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
	 * @param inMrnMode
	 */
	public void setInMrnMode(String inMrnMode) {
		this.inMrnMode = inMrnMode;
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
	 * @param inSkdDirCd
	 */
	public void setInSkdDirCd(String inSkdDirCd) {
		this.inSkdDirCd = inSkdDirCd;
	}

	/**
	 * Column Info
	 * @param inPort
	 */
	public void setInPort(String inPort) {
		this.inPort = inPort;
	}

	/**
	 * Column Info
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
	}

	/**
	 * Column Info
	 * @param inSkdVoyageNo
	 */
	public void setInSkdVoyageNo(String inSkdVoyageNo) {
		this.inSkdVoyageNo = inSkdVoyageNo;
	}

	/**
	 * Column Info
	 * @param inMrnNo
	 */
	public void setInMrnNo(String inMrnNo) {
		this.inMrnNo = inMrnNo;
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
		setInMrnMode(JSPUtil.getParameter(request, "in_mrn_mode", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInSkdDirCd(JSPUtil.getParameter(request, "in_skd_dir_cd", ""));
		setInPort(JSPUtil.getParameter(request, "in_port", ""));
		setInVslCd(JSPUtil.getParameter(request, "in_vsl_cd", ""));
		setInSkdVoyageNo(JSPUtil.getParameter(request, "in_skd_voyage_no", ""));
		setInMrnNo(JSPUtil.getParameter(request, "in_mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPagerows(JSPUtil.getParameter(request, "userid", ""));
		setInMrnChkNo(JSPUtil.getParameter(request, "in_mrn_chk_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMrnInfoVO[]
	 */
	public KorMsnCreateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorMrnInfoVO[]
	 */
	public KorMsnCreateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMsnCreateVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inMrnMode = (JSPUtil.getParameter(request, prefix	+ "in_mrn_mode", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "in_skd_dir_cd", length));
			String[] inPort = (JSPUtil.getParameter(request, prefix	+ "in_port", length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd", length));
			String[] inSkdVoyageNo = (JSPUtil.getParameter(request, prefix	+ "in_skd_voyage_no", length));
			String[] inMrnNo = (JSPUtil.getParameter(request, prefix	+ "in_mrn_no", length));
			String[] inMrnChkNo = (JSPUtil.getParameter(request, prefix	+ "in_mrn_chk_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] userid = (JSPUtil.getParameter(request, prefix	+ "userid", length));

			for (int i = 0; i < length; i++) {
				model = new KorMsnCreateVO();
				if (inMrnMode[i] != null)
					model.setInMrnMode(inMrnMode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inSkdDirCd[i] != null)
					model.setInSkdDirCd(inSkdDirCd[i]);
				if (inPort[i] != null)
					model.setInPort(inPort[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (inSkdVoyageNo[i] != null)
					model.setInSkdVoyageNo(inSkdVoyageNo[i]);
				if (inMrnNo[i] != null)
					model.setInMrnNo(inMrnNo[i]);
				if (inMrnChkNo[i] != null)
					model.setInMrnChkNo(inMrnChkNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (userid[i] != null)
					model.setPagerows(userid[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMrnInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMrnInfoVO[]
	 */
	public KorMsnCreateVO[] getKorMrnInfoVOs(){
		KorMsnCreateVO[] vos = (KorMsnCreateVO[])models.toArray(new KorMsnCreateVO[models.size()]);
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
		this.inMrnMode = this.inMrnMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdDirCd = this.inSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPort = this.inPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdVoyageNo = this.inSkdVoyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inMrnNo = this.inMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inMrnChkNo = this.inMrnChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userid = this.userid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
