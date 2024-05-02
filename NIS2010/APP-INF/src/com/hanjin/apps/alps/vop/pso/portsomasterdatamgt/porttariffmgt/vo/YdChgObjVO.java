/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : YdChgObjVO.java
*@FileTitle : YdChgObjVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.23
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.12.24 정명훈 
* 1.0 Creation
*
* History
* 2011.11.23 진마리아 CHM-201114406-01 Tariff Value Management 화면 로직 변경(EDIT_ENBL_FLG 추가)
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class YdChgObjVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<YdChgObjVO> models = new ArrayList<YdChgObjVO>();
	
	/* Column Info */
	private String dfltCtnt = null;
	/* Column Info */
	private String psoMeasUtCdDsp = null;
	/* Column Info */
	private String dfltFlg = null;
	/* Column Info */
	private String psoMeasUtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String psoObjCdDsp = null;
	/* Column Info */
	private String ydChgVerSeq = null;
	/* Column Info */
	private String dfltVal = null;
	/* Column Info */
	private String objListNm = null;
	/* Column Info */
	private String regularValue = null;
	/* Column Info */
	private String objListNo = null;
	/* Column Info */
	private String psoObjCd = null;
	/* Column Info */
	private String ydChgNo = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String editEnblFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public YdChgObjVO() {}

	public YdChgObjVO(String ibflag, String pagerows, String dfltCtnt, String psoMeasUtCdDsp, String dfltFlg, String psoMeasUtCd, String psoObjCdDsp, String ydChgVerSeq, String dfltVal, String regularValue, String objListNo, String psoObjCd, String ydChgNo, String objListNm, String flag, String creUsrId, String editEnblFlg) {
		this.dfltCtnt = dfltCtnt;
		this.psoMeasUtCdDsp = psoMeasUtCdDsp;
		this.dfltFlg = dfltFlg;
		this.psoMeasUtCd = psoMeasUtCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.psoObjCdDsp = psoObjCdDsp;
		this.ydChgVerSeq = ydChgVerSeq;
		this.dfltVal = dfltVal;
		this.objListNm = objListNm;
		this.regularValue = regularValue;
		this.objListNo = objListNo;
		this.psoObjCd = psoObjCd;
		this.ydChgNo = ydChgNo;
		this.flag = flag;
		this.creUsrId = creUsrId;
		this.editEnblFlg = editEnblFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dflt_ctnt", getDfltCtnt());
		this.hashColumns.put("pso_meas_ut_cd_dsp", getPsoMeasUtCdDsp());
		this.hashColumns.put("dflt_flg", getDfltFlg());
		this.hashColumns.put("pso_meas_ut_cd", getPsoMeasUtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pso_obj_cd_dsp", getPsoObjCdDsp());
		this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
		this.hashColumns.put("dflt_val", getDfltVal());
		this.hashColumns.put("obj_list_nm", getObjListNm());
		this.hashColumns.put("regular_value", getRegularValue());
		this.hashColumns.put("obj_list_no", getObjListNo());
		this.hashColumns.put("pso_obj_cd", getPsoObjCd());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("edit_enbl_flg", getEditEnblFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dflt_ctnt", "dfltCtnt");
		this.hashFields.put("pso_meas_ut_cd_dsp", "psoMeasUtCdDsp");
		this.hashFields.put("dflt_flg", "dfltFlg");
		this.hashFields.put("pso_meas_ut_cd", "psoMeasUtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pso_obj_cd_dsp", "psoObjCdDsp");
		this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
		this.hashFields.put("dflt_val", "dfltVal");
		this.hashFields.put("obj_list_nm", "objListNm");
		this.hashFields.put("regular_value", "regularValue");
		this.hashFields.put("obj_list_no", "objListNo");
		this.hashFields.put("pso_obj_cd", "psoObjCd");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("edit_enbl_flg", "editEnblFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dfltCtnt
	 */
	public String getDfltCtnt() {
		return this.dfltCtnt;
	}
	
	/**
	 * Column Info
	 * @return psoMeasUtCdDsp
	 */
	public String getPsoMeasUtCdDsp() {
		return this.psoMeasUtCdDsp;
	}
	
	/**
	 * Column Info
	 * @return dfltFlg
	 */
	public String getDfltFlg() {
		return this.dfltFlg;
	}
	
	/**
	 * Column Info
	 * @return psoMeasUtCd
	 */
	public String getPsoMeasUtCd() {
		return this.psoMeasUtCd;
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
	 * @return psoObjCdDsp
	 */
	public String getPsoObjCdDsp() {
		return this.psoObjCdDsp;
	}
	
	/**
	 * Column Info
	 * @return ydChgVerSeq
	 */
	public String getYdChgVerSeq() {
		return this.ydChgVerSeq;
	}
	
	/**
	 * Column Info
	 * @return dfltVal
	 */
	public String getDfltVal() {
		return this.dfltVal;
	}
	
	/**
	 * Column Info
	 * @return objListNm
	 */
	public String getObjListNm() {
		return this.objListNm;
	}
	
	/**
	 * Column Info
	 * @return regularValue
	 */
	public String getRegularValue() {
		return this.regularValue;
	}
	
	/**
	 * Column Info
	 * @return objListNo
	 */
	public String getObjListNo() {
		return this.objListNo;
	}
	
	/**
	 * Column Info
	 * @return psoObjCd
	 */
	public String getPsoObjCd() {
		return this.psoObjCd;
	}
	
	/**
	 * Column Info
	 * @return ydChgNo
	 */
	public String getYdChgNo() {
		return this.ydChgNo;
	}
	
	/**
	 * Column Info
	 * @return editEnblFlg
	 */
	public String getEditEnblFlg() {
		return this.editEnblFlg;
	}
	

	/**
	 * Column Info
	 * @param dfltCtnt
	 */
	public void setDfltCtnt(String dfltCtnt) {
		this.dfltCtnt = dfltCtnt;
	}
	
	/**
	 * Column Info
	 * @param psoMeasUtCdDsp
	 */
	public void setPsoMeasUtCdDsp(String psoMeasUtCdDsp) {
		this.psoMeasUtCdDsp = psoMeasUtCdDsp;
	}
	
	/**
	 * Column Info
	 * @param dfltFlg
	 */
	public void setDfltFlg(String dfltFlg) {
		this.dfltFlg = dfltFlg;
	}
	
	/**
	 * Column Info
	 * @param psoMeasUtCd
	 */
	public void setPsoMeasUtCd(String psoMeasUtCd) {
		this.psoMeasUtCd = psoMeasUtCd;
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
	 * @param psoObjCdDsp
	 */
	public void setPsoObjCdDsp(String psoObjCdDsp) {
		this.psoObjCdDsp = psoObjCdDsp;
	}
	
	/**
	 * Column Info
	 * @param ydChgVerSeq
	 */
	public void setYdChgVerSeq(String ydChgVerSeq) {
		this.ydChgVerSeq = ydChgVerSeq;
	}
	
	/**
	 * Column Info
	 * @param dfltVal
	 */
	public void setDfltVal(String dfltVal) {
		this.dfltVal = dfltVal;
	}
	
	/**
	 * Column Info
	 * @param objListNm
	 */
	public void setObjListNm(String objListNm) {
		this.objListNm = objListNm;
	}
	
	/**
	 * Column Info
	 * @param regularValue
	 */
	public void setRegularValue(String regularValue) {
		this.regularValue = regularValue;
	}
	
	/**
	 * Column Info
	 * @param objListNo
	 */
	public void setObjListNo(String objListNo) {
		this.objListNo = objListNo;
	}
	
	/**
	 * Column Info
	 * @param psoObjCd
	 */
	public void setPsoObjCd(String psoObjCd) {
		this.psoObjCd = psoObjCd;
	}
	
	/**
	 * Column Info
	 * @param ydChgNo
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
	}
	
	/**
	 * Column Info
	 * @param editEnblFlg
	 */
	public void setEditEnblFlg(String editEnblFlg) {
		this.editEnblFlg = editEnblFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDfltCtnt(JSPUtil.getParameter(request, "dflt_ctnt", ""));
		setPsoMeasUtCdDsp(JSPUtil.getParameter(request, "pso_meas_ut_cd_dsp", ""));
		setDfltFlg(JSPUtil.getParameter(request, "dflt_flg", ""));
		setPsoMeasUtCd(JSPUtil.getParameter(request, "pso_meas_ut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPsoObjCdDsp(JSPUtil.getParameter(request, "pso_obj_cd_dsp", ""));
		setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
		setDfltVal(JSPUtil.getParameter(request, "dflt_val", ""));
		setObjListNm(JSPUtil.getParameter(request, "obj_list_nm", ""));
		setRegularValue(JSPUtil.getParameter(request, "regular_value", ""));
		setObjListNo(JSPUtil.getParameter(request, "obj_list_no", ""));
		setPsoObjCd(JSPUtil.getParameter(request, "pso_obj_cd", ""));
		setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
		setFlag(JSPUtil.getParameter(request, "flag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEditEnblFlg(JSPUtil.getParameter(request, "edit_enbl_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return YdChgObjVO[]
	 */
	public YdChgObjVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return YdChgObjVO[]
	 */
	public YdChgObjVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		YdChgObjVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dfltCtnt = (JSPUtil.getParameter(request, prefix	+ "dflt_ctnt", length));
			String[] psoMeasUtCdDsp = (JSPUtil.getParameter(request, prefix	+ "pso_meas_ut_cd_dsp", length));
			String[] dfltFlg = (JSPUtil.getParameter(request, prefix	+ "dflt_flg", length));
			String[] psoMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "pso_meas_ut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] psoObjCdDsp = (JSPUtil.getParameter(request, prefix	+ "pso_obj_cd_dsp", length));
			String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix	+ "yd_chg_ver_seq", length));
			String[] dfltVal = (JSPUtil.getParameter(request, prefix	+ "dflt_val", length));
			String[] objListNm = (JSPUtil.getParameter(request, prefix	+ "obj_list_nm", length));
			String[] regularValue = (JSPUtil.getParameter(request, prefix	+ "regular_value", length));
			String[] objListNo = (JSPUtil.getParameter(request, prefix	+ "obj_list_no", length));
			String[] psoObjCd = (JSPUtil.getParameter(request, prefix	+ "pso_obj_cd", length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_no", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] editEnblFlg = (JSPUtil.getParameter(request, prefix	+ "edit_enbl_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new YdChgObjVO();
				if (dfltCtnt[i] != null)
					model.setDfltCtnt(dfltCtnt[i]);
				if (psoMeasUtCdDsp[i] != null)
					model.setPsoMeasUtCdDsp(psoMeasUtCdDsp[i]);
				if (dfltFlg[i] != null)
					model.setDfltFlg(dfltFlg[i]);
				if (psoMeasUtCd[i] != null)
					model.setPsoMeasUtCd(psoMeasUtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (psoObjCdDsp[i] != null)
					model.setPsoObjCdDsp(psoObjCdDsp[i]);
				if (ydChgVerSeq[i] != null)
					model.setYdChgVerSeq(ydChgVerSeq[i]);
				if (dfltVal[i] != null)
					model.setDfltVal(dfltVal[i]);
				if (objListNm[i] != null)
					model.setObjListNm(objListNm[i]);
				if (regularValue[i] != null)
					model.setRegularValue(regularValue[i]);
				if (objListNo[i] != null)
					model.setObjListNo(objListNo[i]);
				if (psoObjCd[i] != null)
					model.setPsoObjCd(psoObjCd[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (editEnblFlg[i] != null)
					model.setEditEnblFlg(editEnblFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getYdChgObjVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return YdChgObjVO[]
	 */
	public YdChgObjVO[] getYdChgObjVOs(){
		YdChgObjVO[] vos = (YdChgObjVO[])models.toArray(new YdChgObjVO[models.size()]);
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
		this.dfltCtnt = this.dfltCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoMeasUtCdDsp = this.psoMeasUtCdDsp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltFlg = this.dfltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoMeasUtCd = this.psoMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoObjCdDsp = this.psoObjCdDsp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgVerSeq = this.ydChgVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltVal = this.dfltVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objListNm = this.objListNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regularValue = this.regularValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objListNo = this.objListNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoObjCd = this.psoObjCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.editEnblFlg = this.editEnblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
}
