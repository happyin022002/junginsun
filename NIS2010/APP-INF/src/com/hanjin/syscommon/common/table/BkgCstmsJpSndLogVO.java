/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCstmsJpSndLogVO.java
*@FileTitle : BkgCstmsJpSndLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCstmsJpSndLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsJpSndLogVO> models = new ArrayList<BkgCstmsJpSndLogVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String msgRgstId = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String sndFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String logDt = null;
	/* Column Info */
	private String jpSndLogId = null;
	/* Column Info */
	private String logSeq = null;
	/* Column Info */
	private String cstmsRqstFlg = null;
	/* Column Info */
	private String logFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String porYdCd = null;
	/* Column Info */
	private String polYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCstmsJpSndLogVO() {}

	public BkgCstmsJpSndLogVO(String ibflag, String pagerows, String polCd ,String porCd, String porYdCd, String polYdCd,String jpSndLogId, String sndDt, String ofcCd, String logSeq, String vslCd, String skdVoyNo, String skdDirCd, String podCd, String logFlg, String logDt, String blNo, String doNo, String sndFlg, String msgRgstId, String cstmsRqstFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.msgRgstId = msgRgstId;
		this.vslCd = vslCd;
		this.sndFlg = sndFlg;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.doNo = doNo;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.logDt = logDt;
		this.jpSndLogId = jpSndLogId;
		this.logSeq = logSeq;
		this.cstmsRqstFlg = cstmsRqstFlg;
		this.logFlg = logFlg;
		this.updUsrId = updUsrId;
		this.polCd = polCd;
		this.porCd = porCd;
		this.porYdCd = porYdCd;
		this.polYdCd = polYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("msg_rgst_id", getMsgRgstId());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("snd_flg", getSndFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("log_dt", getLogDt());
		this.hashColumns.put("jp_snd_log_id", getJpSndLogId());
		this.hashColumns.put("log_seq", getLogSeq());
		this.hashColumns.put("cstms_rqst_flg", getCstmsRqstFlg());
		this.hashColumns.put("log_flg", getLogFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("por_yd_cd", getPorYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("msg_rgst_id", "msgRgstId");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("snd_flg", "sndFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("log_dt", "logDt");
		this.hashFields.put("jp_snd_log_id", "jpSndLogId");
		this.hashFields.put("log_seq", "logSeq");
		this.hashFields.put("cstms_rqst_flg", "cstmsRqstFlg");
		this.hashFields.put("log_flg", "logFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("por_yd_cd", "porYdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return msgRgstId
	 */
	public String getMsgRgstId() {
		return this.msgRgstId;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return sndFlg
	 */
	public String getSndFlg() {
		return this.sndFlg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return logDt
	 */
	public String getLogDt() {
		return this.logDt;
	}
	
	/**
	 * Column Info
	 * @return jpSndLogId
	 */
	public String getJpSndLogId() {
		return this.jpSndLogId;
	}
	
	/**
	 * Column Info
	 * @return logSeq
	 */
	public String getLogSeq() {
		return this.logSeq;
	}
	
	/**
	 * Column Info
	 * @return cstmsRqstFlg
	 */
	public String getCstmsRqstFlg() {
		return this.cstmsRqstFlg;
	}
	
	/**
	 * Column Info
	 * @return logFlg
	 */
	public String getLogFlg() {
		return this.logFlg;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return porYdCd
	 */
	public String getPorYdCd() {
		return this.porYdCd;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param msgRgstId
	 */
	public void setMsgRgstId(String msgRgstId) {
		this.msgRgstId = msgRgstId;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param sndFlg
	 */
	public void setSndFlg(String sndFlg) {
		this.sndFlg = sndFlg;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param logDt
	 */
	public void setLogDt(String logDt) {
		this.logDt = logDt;
	}
	
	/**
	 * Column Info
	 * @param jpSndLogId
	 */
	public void setJpSndLogId(String jpSndLogId) {
		this.jpSndLogId = jpSndLogId;
	}
	
	/**
	 * Column Info
	 * @param logSeq
	 */
	public void setLogSeq(String logSeq) {
		this.logSeq = logSeq;
	}
	
	/**
	 * Column Info
	 * @param cstmsRqstFlg
	 */
	public void setCstmsRqstFlg(String cstmsRqstFlg) {
		this.cstmsRqstFlg = cstmsRqstFlg;
	}
	
	/**
	 * Column Info
	 * @param logFlg
	 */
	public void setLogFlg(String logFlg) {
		this.logFlg = logFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param porYdCd
	 */
	public void setPorYdCd(String porYdCd) {
		this.porYdCd = porYdCd;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMsgRgstId(JSPUtil.getParameter(request, "msg_rgst_id", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSndFlg(JSPUtil.getParameter(request, "snd_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLogDt(JSPUtil.getParameter(request, "log_dt", ""));
		setJpSndLogId(JSPUtil.getParameter(request, "jp_snd_log_id", ""));
		setLogSeq(JSPUtil.getParameter(request, "log_seq", ""));
		setCstmsRqstFlg(JSPUtil.getParameter(request, "cstms_rqst_flg", ""));
		setLogFlg(JSPUtil.getParameter(request, "log_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setPorYdCd(JSPUtil.getParameter(request, "por_yd_cd", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsJpSndLogVO[]
	 */
	public BkgCstmsJpSndLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsJpSndLogVO[]
	 */
	public BkgCstmsJpSndLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsJpSndLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] msgRgstId = (JSPUtil.getParameter(request, prefix	+ "msg_rgst_id", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] sndFlg = (JSPUtil.getParameter(request, prefix	+ "snd_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] logDt = (JSPUtil.getParameter(request, prefix	+ "log_dt", length));
			String[] jpSndLogId = (JSPUtil.getParameter(request, prefix	+ "jp_snd_log_id", length));
			String[] logSeq = (JSPUtil.getParameter(request, prefix	+ "log_seq", length));
			String[] cstmsRqstFlg = (JSPUtil.getParameter(request, prefix	+ "cstms_rqst_flg", length));
			String[] logFlg = (JSPUtil.getParameter(request, prefix	+ "log_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] porYdCd = (JSPUtil.getParameter(request, prefix	+ "por_yd_cd", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsJpSndLogVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (msgRgstId[i] != null)
					model.setMsgRgstId(msgRgstId[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (sndFlg[i] != null)
					model.setSndFlg(sndFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (logDt[i] != null)
					model.setLogDt(logDt[i]);
				if (jpSndLogId[i] != null)
					model.setJpSndLogId(jpSndLogId[i]);
				if (logSeq[i] != null)
					model.setLogSeq(logSeq[i]);
				if (cstmsRqstFlg[i] != null)
					model.setCstmsRqstFlg(cstmsRqstFlg[i]);
				if (logFlg[i] != null)
					model.setLogFlg(logFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (porYdCd[i] != null)
					model.setPorYdCd(porYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsJpSndLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsJpSndLogVO[]
	 */
	public BkgCstmsJpSndLogVO[] getBkgCstmsJpSndLogVOs(){
		BkgCstmsJpSndLogVO[] vos = (BkgCstmsJpSndLogVO[])models.toArray(new BkgCstmsJpSndLogVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRgstId = this.msgRgstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndFlg = this.sndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logDt = this.logDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpSndLogId = this.jpSndLogId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logSeq = this.logSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRqstFlg = this.cstmsRqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logFlg = this.logFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porYdCd = this.porYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
