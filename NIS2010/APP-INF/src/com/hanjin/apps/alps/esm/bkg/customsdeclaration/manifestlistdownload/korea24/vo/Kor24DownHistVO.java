/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24DownHistVO.java
*@FileTitle : Kor24DownHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.12 박상훈
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Kor24DownHistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<Kor24DownHistVO> models = new ArrayList<Kor24DownHistVO>();

	/* Column Info */
	private String office = null;
	/* Column Info */
	private String kdhSeq = null;
	/* Column Info */
	private String mrnUpdateCnt = null;
	/* Column Info */
	private String actionTime = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mrnPort = null;
	/* Column Info */
	private String mrnChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String username = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String mrnNbr = null;
	/* Column Info */
	private String blKnt = null;
	/* Column Info */
	private String bound = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public Kor24DownHistVO() {}

	public Kor24DownHistVO(String ibflag, String pagerows, String office, String mrnPort, String mrnChk, String username, String vvdCd, String kdhSeq, String mrnNbr, String mrnUpdateCnt, String actionTime, String bound, String blKnt) {
		this.office = office;
		this.kdhSeq = kdhSeq;
		this.mrnUpdateCnt = mrnUpdateCnt;
		this.actionTime = actionTime;
		this.pagerows = pagerows;
		this.mrnPort = mrnPort;
		this.mrnChk = mrnChk;
		this.ibflag = ibflag;
		this.username = username;
		this.vvdCd = vvdCd;
		this.mrnNbr = mrnNbr;
		this.blKnt = blKnt;
		this.bound = bound;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("kdh_seq", getKdhSeq());
		this.hashColumns.put("mrn_update_cnt", getMrnUpdateCnt());
		this.hashColumns.put("action_time", getActionTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mrn_port", getMrnPort());
		this.hashColumns.put("mrn_chk", getMrnChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("username", getUsername());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("mrn_nbr", getMrnNbr());
		this.hashColumns.put("bl_knt", getBlKnt());
		this.hashColumns.put("bound", getBound());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("kdh_seq", "kdhSeq");
		this.hashFields.put("mrn_update_cnt", "mrnUpdateCnt");
		this.hashFields.put("action_time", "actionTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mrn_port", "mrnPort");
		this.hashFields.put("mrn_chk", "mrnChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("username", "username");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("mrn_nbr", "mrnNbr");
		this.hashFields.put("bl_knt", "blKnt");
		this.hashFields.put("bound", "bound");
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
	 * @return kdhSeq
	 */
	public String getKdhSeq() {
		return this.kdhSeq;
	}

	/**
	 * Column Info
	 * @return mrnUpdateCnt
	 */
	public String getMrnUpdateCnt() {
		return this.mrnUpdateCnt;
	}

	/**
	 * Column Info
	 * @return actionTime
	 */
	public String getActionTime() {
		return this.actionTime;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * @return username
	 */
	public String getUsername() {
		return this.username;
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
	 * @return mrnNbr
	 */
	public String getMrnNbr() {
		return this.mrnNbr;
	}

	/**
	 * Column Info
	 * @return blKnt
	 */
	public String getBlKnt() {
		return this.blKnt;
	}

	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
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
	 * @param kdhSeq
	 */
	public void setKdhSeq(String kdhSeq) {
		this.kdhSeq = kdhSeq;
	}

	/**
	 * Column Info
	 * @param mrnUpdateCnt
	 */
	public void setMrnUpdateCnt(String mrnUpdateCnt) {
		this.mrnUpdateCnt = mrnUpdateCnt;
	}

	/**
	 * Column Info
	 * @param actionTime
	 */
	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @param mrnNbr
	 */
	public void setMrnNbr(String mrnNbr) {
		this.mrnNbr = mrnNbr;
	}

	/**
	 * Column Info
	 * @param blKnt
	 */
	public void setBlKnt(String blKnt) {
		this.blKnt = blKnt;
	}

	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}

/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
		setKdhSeq(JSPUtil.getParameter(request, prefix + "kdh_seq", ""));
		setMrnUpdateCnt(JSPUtil.getParameter(request, prefix + "mrn_update_cnt", ""));
		setActionTime(JSPUtil.getParameter(request, prefix + "action_time", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMrnPort(JSPUtil.getParameter(request, prefix + "mrn_port", ""));
		setMrnChk(JSPUtil.getParameter(request, prefix + "mrn_chk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsername(JSPUtil.getParameter(request, prefix + "username", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setMrnNbr(JSPUtil.getParameter(request, prefix + "mrn_nbr", ""));
		setBlKnt(JSPUtil.getParameter(request, prefix + "bl_knt", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Kor24DownHistVO[]
	 */
	public Kor24DownHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return Kor24DownHistVO[]
	 */
	public Kor24DownHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Kor24DownHistVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] kdhSeq = (JSPUtil.getParameter(request, prefix	+ "kdh_seq", length));
			String[] mrnUpdateCnt = (JSPUtil.getParameter(request, prefix	+ "mrn_update_cnt", length));
			String[] actionTime = (JSPUtil.getParameter(request, prefix	+ "action_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mrnPort = (JSPUtil.getParameter(request, prefix	+ "mrn_port", length));
			String[] mrnChk = (JSPUtil.getParameter(request, prefix	+ "mrn_chk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] username = (JSPUtil.getParameter(request, prefix	+ "username", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] mrnNbr = (JSPUtil.getParameter(request, prefix	+ "mrn_nbr", length));
			String[] blKnt = (JSPUtil.getParameter(request, prefix	+ "bl_knt", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));

			for (int i = 0; i < length; i++) {
				model = new Kor24DownHistVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (kdhSeq[i] != null)
					model.setKdhSeq(kdhSeq[i]);
				if (mrnUpdateCnt[i] != null)
					model.setMrnUpdateCnt(mrnUpdateCnt[i]);
				if (actionTime[i] != null)
					model.setActionTime(actionTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mrnPort[i] != null)
					model.setMrnPort(mrnPort[i]);
				if (mrnChk[i] != null)
					model.setMrnChk(mrnChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (username[i] != null)
					model.setUsername(username[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (mrnNbr[i] != null)
					model.setMrnNbr(mrnNbr[i]);
				if (blKnt[i] != null)
					model.setBlKnt(blKnt[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKor24DownHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Kor24DownHistVO[]
	 */
	public Kor24DownHistVO[] getKor24DownHistVOs(){
		Kor24DownHistVO[] vos = (Kor24DownHistVO[])models.toArray(new Kor24DownHistVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kdhSeq = this.kdhSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnUpdateCnt = this.mrnUpdateCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionTime = this.actionTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPort = this.mrnPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnChk = this.mrnChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.username = this.username .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNbr = this.mrnNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blKnt = this.blKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
