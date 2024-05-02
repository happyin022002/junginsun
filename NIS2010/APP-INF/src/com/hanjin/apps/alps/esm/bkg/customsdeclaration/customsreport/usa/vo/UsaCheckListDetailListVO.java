/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCheckListDetailListVO.java
*@FileTitle : UsaCheckListDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.05 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo;

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
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaCheckListDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaCheckListDetailListVO> models = new ArrayList<UsaCheckListDetailListVO>();
	
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String bOfc = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sentTime = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String updateDt = null;
	/* Column Info */
	private String mi = null;
	/* Column Info */
	private String filer = null;
	/* Column Info */
	private String tPol2 = null;
	/* Column Info */
	private String amsFileNo = null;
	/* Column Info */
	private String currStage = null;
	/* Column Info */
	private String tPod = null;
	/* Column Info */
	private String vMi = null;
	/* Column Info */
	private String tPol = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String filer2 = null;
	/* Column Info */
	private String tmp2 = null;
	/* Column Info */
	private String tmp1 = null;
	/* Column Info */
	private String mF = null;
	/* Column Info */
	private String tmp3 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String mblNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String oPol = null;
	/* Column Info */
	private String userAction = null;
	/* Column Info */
	private String mfSts = null;
	/* Column Info */
	private String tVvd2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaCheckListDetailListVO() {}

	public UsaCheckListDetailListVO(String ibflag, String pagerows, String seq, String gubun, String amsFileNo, String mF, String filer, String mblNo, String oPol, String tPol, String tPod, String tVvd, String sts, String vMi, String mi, String vvd, String sentTime, String currStage, String updateDt, String bOfc, String cntrNo, String mfSts, String userAction, String tVvd2, String tPol2, String filer2, String tmp1, String tmp2, String tmp3) {
		this.gubun = gubun;
		this.bOfc = bOfc;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.sentTime = sentTime;
		this.tVvd = tVvd;
		this.updateDt = updateDt;
		this.mi = mi;
		this.filer = filer;
		this.tPol2 = tPol2;
		this.amsFileNo = amsFileNo;
		this.currStage = currStage;
		this.tPod = tPod;
		this.vMi = vMi;
		this.tPol = tPol;
		this.vvd = vvd;
		this.filer2 = filer2;
		this.tmp2 = tmp2;
		this.tmp1 = tmp1;
		this.mF = mF;
		this.tmp3 = tmp3;
		this.cntrNo = cntrNo;
		this.sts = sts;
		this.mblNo = mblNo;
		this.seq = seq;
		this.oPol = oPol;
		this.userAction = userAction;
		this.mfSts = mfSts;
		this.tVvd2 = tVvd2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("b_ofc", getBOfc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sent_time", getSentTime());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("update_dt", getUpdateDt());
		this.hashColumns.put("mi", getMi());
		this.hashColumns.put("filer", getFiler());
		this.hashColumns.put("t_pol2", getTPol2());
		this.hashColumns.put("ams_file_no", getAmsFileNo());
		this.hashColumns.put("curr_stage", getCurrStage());
		this.hashColumns.put("t_pod", getTPod());
		this.hashColumns.put("v_mi", getVMi());
		this.hashColumns.put("t_pol", getTPol());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("filer2", getFiler2());
		this.hashColumns.put("tmp2", getTmp2());
		this.hashColumns.put("tmp1", getTmp1());
		this.hashColumns.put("m_f", getMF());
		this.hashColumns.put("tmp3", getTmp3());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sts", getSts());
		this.hashColumns.put("mbl_no", getMblNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("o_pol", getOPol());
		this.hashColumns.put("user_action", getUserAction());
		this.hashColumns.put("mf_sts", getMfSts());
		this.hashColumns.put("t_vvd2", getTVvd2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("b_ofc", "bOfc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sent_time", "sentTime");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("update_dt", "updateDt");
		this.hashFields.put("mi", "mi");
		this.hashFields.put("filer", "filer");
		this.hashFields.put("t_pol2", "tPol2");
		this.hashFields.put("ams_file_no", "amsFileNo");
		this.hashFields.put("curr_stage", "currStage");
		this.hashFields.put("t_pod", "tPod");
		this.hashFields.put("v_mi", "vMi");
		this.hashFields.put("t_pol", "tPol");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("filer2", "filer2");
		this.hashFields.put("tmp2", "tmp2");
		this.hashFields.put("tmp1", "tmp1");
		this.hashFields.put("m_f", "mF");
		this.hashFields.put("tmp3", "tmp3");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("mbl_no", "mblNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("o_pol", "oPol");
		this.hashFields.put("user_action", "userAction");
		this.hashFields.put("mf_sts", "mfSts");
		this.hashFields.put("t_vvd2", "tVvd2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return bOfc
	 */
	public String getBOfc() {
		return this.bOfc;
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
	 * @return sentTime
	 */
	public String getSentTime() {
		return this.sentTime;
	}
	
	/**
	 * Column Info
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return updateDt
	 */
	public String getUpdateDt() {
		return this.updateDt;
	}
	
	/**
	 * Column Info
	 * @return mi
	 */
	public String getMi() {
		return this.mi;
	}
	
	/**
	 * Column Info
	 * @return filer
	 */
	public String getFiler() {
		return this.filer;
	}
	
	/**
	 * Column Info
	 * @return tPol2
	 */
	public String getTPol2() {
		return this.tPol2;
	}
	
	/**
	 * Column Info
	 * @return amsFileNo
	 */
	public String getAmsFileNo() {
		return this.amsFileNo;
	}
	
	/**
	 * Column Info
	 * @return currStage
	 */
	public String getCurrStage() {
		return this.currStage;
	}
	
	/**
	 * Column Info
	 * @return tPod
	 */
	public String getTPod() {
		return this.tPod;
	}
	
	/**
	 * Column Info
	 * @return vMi
	 */
	public String getVMi() {
		return this.vMi;
	}
	
	/**
	 * Column Info
	 * @return tPol
	 */
	public String getTPol() {
		return this.tPol;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return filer2
	 */
	public String getFiler2() {
		return this.filer2;
	}
	
	/**
	 * Column Info
	 * @return tmp2
	 */
	public String getTmp2() {
		return this.tmp2;
	}
	
	/**
	 * Column Info
	 * @return tmp1
	 */
	public String getTmp1() {
		return this.tmp1;
	}
	
	/**
	 * Column Info
	 * @return mF
	 */
	public String getMF() {
		return this.mF;
	}
	
	/**
	 * Column Info
	 * @return tmp3
	 */
	public String getTmp3() {
		return this.tmp3;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return sts
	 */
	public String getSts() {
		return this.sts;
	}
	
	/**
	 * Column Info
	 * @return mblNo
	 */
	public String getMblNo() {
		return this.mblNo;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return oPol
	 */
	public String getOPol() {
		return this.oPol;
	}
	
	/**
	 * Column Info
	 * @return userAction
	 */
	public String getUserAction() {
		return this.userAction;
	}
	
	/**
	 * Column Info
	 * @return mfSts
	 */
	public String getMfSts() {
		return this.mfSts;
	}
	
	/**
	 * Column Info
	 * @return tVvd2
	 */
	public String getTVvd2() {
		return this.tVvd2;
	}
	

	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param bOfc
	 */
	public void setBOfc(String bOfc) {
		this.bOfc = bOfc;
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
	 * @param sentTime
	 */
	public void setSentTime(String sentTime) {
		this.sentTime = sentTime;
	}
	
	/**
	 * Column Info
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param updateDt
	 */
	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}
	
	/**
	 * Column Info
	 * @param mi
	 */
	public void setMi(String mi) {
		this.mi = mi;
	}
	
	/**
	 * Column Info
	 * @param filer
	 */
	public void setFiler(String filer) {
		this.filer = filer;
	}
	
	/**
	 * Column Info
	 * @param tPol2
	 */
	public void setTPol2(String tPol2) {
		this.tPol2 = tPol2;
	}
	
	/**
	 * Column Info
	 * @param amsFileNo
	 */
	public void setAmsFileNo(String amsFileNo) {
		this.amsFileNo = amsFileNo;
	}
	
	/**
	 * Column Info
	 * @param currStage
	 */
	public void setCurrStage(String currStage) {
		this.currStage = currStage;
	}
	
	/**
	 * Column Info
	 * @param tPod
	 */
	public void setTPod(String tPod) {
		this.tPod = tPod;
	}
	
	/**
	 * Column Info
	 * @param vMi
	 */
	public void setVMi(String vMi) {
		this.vMi = vMi;
	}
	
	/**
	 * Column Info
	 * @param tPol
	 */
	public void setTPol(String tPol) {
		this.tPol = tPol;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param filer2
	 */
	public void setFiler2(String filer2) {
		this.filer2 = filer2;
	}
	
	/**
	 * Column Info
	 * @param tmp2
	 */
	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
	}
	
	/**
	 * Column Info
	 * @param tmp1
	 */
	public void setTmp1(String tmp1) {
		this.tmp1 = tmp1;
	}
	
	/**
	 * Column Info
	 * @param mF
	 */
	public void setMF(String mF) {
		this.mF = mF;
	}
	
	/**
	 * Column Info
	 * @param tmp3
	 */
	public void setTmp3(String tmp3) {
		this.tmp3 = tmp3;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	/**
	 * Column Info
	 * @param mblNo
	 */
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param oPol
	 */
	public void setOPol(String oPol) {
		this.oPol = oPol;
	}
	
	/**
	 * Column Info
	 * @param userAction
	 */
	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}
	
	/**
	 * Column Info
	 * @param mfSts
	 */
	public void setMfSts(String mfSts) {
		this.mfSts = mfSts;
	}
	
	/**
	 * Column Info
	 * @param tVvd2
	 */
	public void setTVvd2(String tVvd2) {
		this.tVvd2 = tVvd2;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setBOfc(JSPUtil.getParameter(request, "b_ofc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSentTime(JSPUtil.getParameter(request, "sent_time", ""));
		setTVvd(JSPUtil.getParameter(request, "t_vvd", ""));
		setUpdateDt(JSPUtil.getParameter(request, "update_dt", ""));
		setMi(JSPUtil.getParameter(request, "mi", ""));
		setFiler(JSPUtil.getParameter(request, "filer", ""));
		setTPol2(JSPUtil.getParameter(request, "t_pol2", ""));
		setAmsFileNo(JSPUtil.getParameter(request, "ams_file_no", ""));
		setCurrStage(JSPUtil.getParameter(request, "curr_stage", ""));
		setTPod(JSPUtil.getParameter(request, "t_pod", ""));
		setVMi(JSPUtil.getParameter(request, "v_mi", ""));
		setTPol(JSPUtil.getParameter(request, "t_pol", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setFiler2(JSPUtil.getParameter(request, "filer2", ""));
		setTmp2(JSPUtil.getParameter(request, "tmp2", ""));
		setTmp1(JSPUtil.getParameter(request, "tmp1", ""));
		setMF(JSPUtil.getParameter(request, "m_f", ""));
		setTmp3(JSPUtil.getParameter(request, "tmp3", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setSts(JSPUtil.getParameter(request, "sts", ""));
		setMblNo(JSPUtil.getParameter(request, "mbl_no", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setOPol(JSPUtil.getParameter(request, "o_pol", ""));
		setUserAction(JSPUtil.getParameter(request, "user_action", ""));
		setMfSts(JSPUtil.getParameter(request, "mf_sts", ""));
		setTVvd2(JSPUtil.getParameter(request, "t_vvd2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaCheckListDetailListVO[]
	 */
	public UsaCheckListDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaCheckListDetailListVO[]
	 */
	public UsaCheckListDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaCheckListDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] bOfc = (JSPUtil.getParameter(request, prefix	+ "b_ofc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sentTime = (JSPUtil.getParameter(request, prefix	+ "sent_time", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] updateDt = (JSPUtil.getParameter(request, prefix	+ "update_dt", length));
			String[] mi = (JSPUtil.getParameter(request, prefix	+ "mi", length));
			String[] filer = (JSPUtil.getParameter(request, prefix	+ "filer", length));
			String[] tPol2 = (JSPUtil.getParameter(request, prefix	+ "t_pol2", length));
			String[] amsFileNo = (JSPUtil.getParameter(request, prefix	+ "ams_file_no", length));
			String[] currStage = (JSPUtil.getParameter(request, prefix	+ "curr_stage", length));
			String[] tPod = (JSPUtil.getParameter(request, prefix	+ "t_pod", length));
			String[] vMi = (JSPUtil.getParameter(request, prefix	+ "v_mi", length));
			String[] tPol = (JSPUtil.getParameter(request, prefix	+ "t_pol", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] filer2 = (JSPUtil.getParameter(request, prefix	+ "filer2", length));
			String[] tmp2 = (JSPUtil.getParameter(request, prefix	+ "tmp2", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp1", length));
			String[] mF = (JSPUtil.getParameter(request, prefix	+ "m_f", length));
			String[] tmp3 = (JSPUtil.getParameter(request, prefix	+ "tmp3", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] mblNo = (JSPUtil.getParameter(request, prefix	+ "mbl_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] oPol = (JSPUtil.getParameter(request, prefix	+ "o_pol", length));
			String[] userAction = (JSPUtil.getParameter(request, prefix	+ "user_action", length));
			String[] mfSts = (JSPUtil.getParameter(request, prefix	+ "mf_sts", length));
			String[] tVvd2 = (JSPUtil.getParameter(request, prefix	+ "t_vvd2", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaCheckListDetailListVO();
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (bOfc[i] != null)
					model.setBOfc(bOfc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sentTime[i] != null)
					model.setSentTime(sentTime[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (updateDt[i] != null)
					model.setUpdateDt(updateDt[i]);
				if (mi[i] != null)
					model.setMi(mi[i]);
				if (filer[i] != null)
					model.setFiler(filer[i]);
				if (tPol2[i] != null)
					model.setTPol2(tPol2[i]);
				if (amsFileNo[i] != null)
					model.setAmsFileNo(amsFileNo[i]);
				if (currStage[i] != null)
					model.setCurrStage(currStage[i]);
				if (tPod[i] != null)
					model.setTPod(tPod[i]);
				if (vMi[i] != null)
					model.setVMi(vMi[i]);
				if (tPol[i] != null)
					model.setTPol(tPol[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (filer2[i] != null)
					model.setFiler2(filer2[i]);
				if (tmp2[i] != null)
					model.setTmp2(tmp2[i]);
				if (tmp1[i] != null)
					model.setTmp1(tmp1[i]);
				if (mF[i] != null)
					model.setMF(mF[i]);
				if (tmp3[i] != null)
					model.setTmp3(tmp3[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);
				if (mblNo[i] != null)
					model.setMblNo(mblNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (oPol[i] != null)
					model.setOPol(oPol[i]);
				if (userAction[i] != null)
					model.setUserAction(userAction[i]);
				if (mfSts[i] != null)
					model.setMfSts(mfSts[i]);
				if (tVvd2[i] != null)
					model.setTVvd2(tVvd2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaCheckListDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaCheckListDetailListVO[]
	 */
	public UsaCheckListDetailListVO[] getUsaCheckListDetailListVOs(){
		UsaCheckListDetailListVO[] vos = (UsaCheckListDetailListVO[])models.toArray(new UsaCheckListDetailListVO[models.size()]);
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
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bOfc = this.bOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentTime = this.sentTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateDt = this.updateDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mi = this.mi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filer = this.filer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPol2 = this.tPol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsFileNo = this.amsFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currStage = this.currStage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPod = this.tPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vMi = this.vMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPol = this.tPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filer2 = this.filer2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp2 = this.tmp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp1 = this.tmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mF = this.mF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp3 = this.tmp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblNo = this.mblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oPol = this.oPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userAction = this.userAction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSts = this.mfSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd2 = this.tVvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
