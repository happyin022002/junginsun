/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalEdiCondVO.java
*@FileTitle : JapanTerminalEdiCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.04.03 김종옥
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapanTerminalEdiCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<JapanTerminalEdiCondVO> models = new ArrayList<JapanTerminalEdiCondVO>();

	/* Column Info */
	private String inSkdVoyNo = null;
	/* Column Info */
	private String inSkdDirCd = null;
	/* Column Info */
	private String inPorCd = null;
	/* Column Info */
	private String inEdiSndUsrId = null;
	/* Column Info */
	private String inBatSkdPrdToDt = null;
	/* Column Info */
	private String inVslCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inBatSkdPrdFmDt = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String inBkgNo = null;
	/* Column Info */
	private String inSkdDeltFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public JapanTerminalEdiCondVO() {}

	public JapanTerminalEdiCondVO(String ibflag, String pagerows, String inSkdVoyNo, String inSkdDirCd, String inPorCd, String inEdiSndUsrId, String inBatSkdPrdToDt, String inVslCd, String inBkgNo, String inBatSkdPrdFmDt, String inPolCd, String inVvdCd, String inSkdDeltFlg) {
		this.inSkdVoyNo = inSkdVoyNo;
		this.inSkdDirCd = inSkdDirCd;
		this.inPorCd = inPorCd;
		this.inEdiSndUsrId = inEdiSndUsrId;
		this.inBatSkdPrdToDt = inBatSkdPrdToDt;
		this.inVslCd = inVslCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.inBatSkdPrdFmDt = inBatSkdPrdFmDt;
		this.inPolCd = inPolCd;
		this.inVvdCd = inVvdCd;
		this.inBkgNo = inBkgNo;
		this.inSkdDeltFlg = inSkdDeltFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_skd_voy_no", getInSkdVoyNo());
		this.hashColumns.put("in_skd_dir_cd", getInSkdDirCd());
		this.hashColumns.put("in_por_cd", getInPorCd());
		this.hashColumns.put("in_edi_snd_usr_id", getInEdiSndUsrId());
		this.hashColumns.put("in_bat_skd_prd_to_dt", getInBatSkdPrdToDt());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_bat_skd_prd_fm_dt", getInBatSkdPrdFmDt());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("in_bkg_no", getInBkgNo());
		this.hashColumns.put("in_skd_delt_flg", getInSkdDeltFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_skd_voy_no", "inSkdVoyNo");
		this.hashFields.put("in_skd_dir_cd", "inSkdDirCd");
		this.hashFields.put("in_por_cd", "inPorCd");
		this.hashFields.put("in_edi_snd_usr_id", "inEdiSndUsrId");
		this.hashFields.put("in_bat_skd_prd_to_dt", "inBatSkdPrdToDt");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_bat_skd_prd_fm_dt", "inBatSkdPrdFmDt");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("in_bkg_no", "inBkgNo");
		this.hashFields.put("in_skd_delt_flg", "inSkdDeltFlg");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return inSkdVoyNo
	 */
	public String getInSkdVoyNo() {
		return this.inSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return inSkdDirCd
	 */
	public String getInSkdDirCd() {
		return this.inSkdDirCd;
	}

	/**
	 * Column Info
	 * @return inPorCd
	 */
	public String getInPorCd() {
		return this.inPorCd;
	}

	/**
	 * Column Info
	 * @return inEdiSndUsrId
	 */
	public String getInEdiSndUsrId() {
		return this.inEdiSndUsrId;
	}

	/**
	 * Column Info
	 * @return inBatSkdPrdToDt
	 */
	public String getInBatSkdPrdToDt() {
		return this.inBatSkdPrdToDt;
	}

	/**
	 * Column Info
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
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
	 * @return inBatSkdPrdFmDt
	 */
	public String getInBatSkdPrdFmDt() {
		return this.inBatSkdPrdFmDt;
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
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}

	/**
	 * Column Info
	 * @return inBkgNo
	 */
	public String getInBkgNo() {
		return this.inBkgNo;
	}

	/**
	 * Column Info
	 * @return inSkdDeltFlg
	 */
	public String getInSkdDeltFlg() {
		return this.inSkdDeltFlg;
	}


	/**
	 * Column Info
	 * @param inSkdVoyNo
	 */
	public void setInSkdVoyNo(String inSkdVoyNo) {
		this.inSkdVoyNo = inSkdVoyNo;
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
	 * @param inPorCd
	 */
	public void setInPorCd(String inPorCd) {
		this.inPorCd = inPorCd;
	}

	/**
	 * Column Info
	 * @param inEdiSndUsrId
	 */
	public void setInEdiSndUsrId(String inEdiSndUsrId) {
		this.inEdiSndUsrId = inEdiSndUsrId;
	}

	/**
	 * Column Info
	 * @param inBatSkdPrdToDt
	 */
	public void setInBatSkdPrdToDt(String inBatSkdPrdToDt) {
		this.inBatSkdPrdToDt = inBatSkdPrdToDt;
	}

	/**
	 * Column Info
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
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
	 * @param inBatSkdPrdFmDt
	 */
	public void setInBatSkdPrdFmDt(String inBatSkdPrdFmDt) {
		this.inBatSkdPrdFmDt = inBatSkdPrdFmDt;
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
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}

	/**
	 * Column Info
	 * @param inBkgNo
	 */
	public void setInBkgNo(String inBkgNo) {
		this.inBkgNo = inBkgNo;
	}

	/**
	 * Column Info
	 * @param inSkdDeltFlg
	 */
	public void setInSkdDeltFlg(String inSkdDeltFlg) {
		this.inSkdDeltFlg = inSkdDeltFlg;
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
		setInSkdVoyNo(JSPUtil.getParameter(request, prefix + "in_skd_voy_no", ""));
		setInSkdDirCd(JSPUtil.getParameter(request, prefix + "in_skd_dir_cd", ""));
		setInPorCd(JSPUtil.getParameter(request, prefix + "in_por_cd", ""));
		setInEdiSndUsrId(JSPUtil.getParameter(request, prefix + "in_edi_snd_usr_id", ""));
		setInBatSkdPrdToDt(JSPUtil.getParameter(request, prefix + "in_bat_skd_prd_to_dt", ""));
		setInVslCd(JSPUtil.getParameter(request, prefix + "in_vsl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInBatSkdPrdFmDt(JSPUtil.getParameter(request, prefix + "in_bat_skd_prd_fm_dt", ""));
		setInPolCd(JSPUtil.getParameter(request, prefix + "in_pol_cd", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setInBkgNo(JSPUtil.getParameter(request, prefix + "in_bkg_no", ""));
		setInSkdDeltFlg(JSPUtil.getParameter(request, prefix + "in_skd_delt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanTerminalEdiCondVO[]
	 */
	public JapanTerminalEdiCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return JapanTerminalEdiCondVO[]
	 */
	public JapanTerminalEdiCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanTerminalEdiCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "in_skd_voy_no", length));
			String[] inSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "in_skd_dir_cd", length));
			String[] inPorCd = (JSPUtil.getParameter(request, prefix	+ "in_por_cd", length));
			String[] inEdiSndUsrId = (JSPUtil.getParameter(request, prefix	+ "in_edi_snd_usr_id", length));
			String[] inBatSkdPrdToDt = (JSPUtil.getParameter(request, prefix	+ "in_bat_skd_prd_to_dt", length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inBatSkdPrdFmDt = (JSPUtil.getParameter(request, prefix	+ "in_bat_skd_prd_fm_dt", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] inBkgNo = (JSPUtil.getParameter(request, prefix	+ "in_bkg_no", length));
			String[] inSkdDeltFlg = (JSPUtil.getParameter(request, prefix	+ "in_skd_delt_flg", length));

			for (int i = 0; i < length; i++) {
				model = new JapanTerminalEdiCondVO();
				if (inSkdVoyNo[i] != null)
					model.setInSkdVoyNo(inSkdVoyNo[i]);
				if (inSkdDirCd[i] != null)
					model.setInSkdDirCd(inSkdDirCd[i]);
				if (inPorCd[i] != null)
					model.setInPorCd(inPorCd[i]);
				if (inEdiSndUsrId[i] != null)
					model.setInEdiSndUsrId(inEdiSndUsrId[i]);
				if (inBatSkdPrdToDt[i] != null)
					model.setInBatSkdPrdToDt(inBatSkdPrdToDt[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inBatSkdPrdFmDt[i] != null)
					model.setInBatSkdPrdFmDt(inBatSkdPrdFmDt[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (inBkgNo[i] != null)
					model.setInBkgNo(inBkgNo[i]);
				if (inSkdDeltFlg[i] != null)
					model.setInSkdDeltFlg(inSkdDeltFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanTerminalEdiCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanTerminalEdiCondVO[]
	 */
	public JapanTerminalEdiCondVO[] getJapanTerminalEdiCondVOs(){
		JapanTerminalEdiCondVO[] vos = (JapanTerminalEdiCondVO[])models.toArray(new JapanTerminalEdiCondVO[models.size()]);
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
		this.inSkdVoyNo = this.inSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdDirCd = this.inSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPorCd = this.inPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inEdiSndUsrId = this.inEdiSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBatSkdPrdToDt = this.inBatSkdPrdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBatSkdPrdFmDt = this.inBatSkdPrdFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgNo = this.inBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdDeltFlg = this.inSkdDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
