/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SendDetailLogVO.java
*@FileTitle : SendDetailLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.09 김민정 
* 1.0 Creation
* 
* 2012.01.31 민정호 [CHM-201215726-01] AMS 전송시 Customs 로직 추가 요청 
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SendDetailLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SendDetailLogVO> models = new ArrayList<SendDetailLogVO>();
	
	/* Column Info */
	private String cntrCount = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String msg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmp2 = null;
	/* Column Info */
	private String isfActCd = null;
	/* Column Info */
	private String tmp1 = null;
	/* Column Info */
	private String tmp3 = null;
	/* Column Info */
	private String sndProcId = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String dtlSeq = null;
	/* Column Info */
	private String pod = null;
	private String cstmsPortCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SendDetailLogVO() {}

	public SendDetailLogVO(String ibflag, String pagerows, String sndProcId, String seq, String vvd, String pol, String pod, String cntrCount, String ofcCd, String usrId, String msg, String tmp1, String tmp2, String tmp3, String sndDt, String dtlSeq, String blNo, String isfActCd, String cstmsPortCd) {
		this.cntrCount = cntrCount;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.msg = msg;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.tmp2 = tmp2;
		this.isfActCd = isfActCd;
		this.tmp1 = tmp1;
		this.tmp3 = tmp3;
		this.sndProcId = sndProcId;
		this.usrId = usrId;
		this.pol = pol;
		this.seq = seq;
		this.dtlSeq = dtlSeq;
		this.pod = pod;
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_count", getCntrCount());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("msg", getMsg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tmp2", getTmp2());
		this.hashColumns.put("isf_act_cd", getIsfActCd());
		this.hashColumns.put("tmp1", getTmp1());
		this.hashColumns.put("tmp3", getTmp3());
		this.hashColumns.put("snd_proc_id", getSndProcId());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_count", "cntrCount");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("msg", "msg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tmp2", "tmp2");
		this.hashFields.put("isf_act_cd", "isfActCd");
		this.hashFields.put("tmp1", "tmp1");
		this.hashFields.put("tmp3", "tmp3");
		this.hashFields.put("snd_proc_id", "sndProcId");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("dtl_seq", "dtlSeq");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");		

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrCount
	 */
	public String getCntrCount() {
		return this.cntrCount;
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
	 * @return msg
	 */
	public String getMsg() {
		return this.msg;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return tmp2
	 */
	public String getTmp2() {
		return this.tmp2;
	}
	
	/**
	 * Column Info
	 * @return isfActCd
	 */
	public String getIsfActCd() {
		return this.isfActCd;
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
	 * @return tmp3
	 */
	public String getTmp3() {
		return this.tmp3;
	}
	
	/**
	 * Column Info
	 * @return sndProcId
	 */
	public String getSndProcId() {
		return this.sndProcId;
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
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
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
	 * @return dtlSeq
	 */
	public String getDtlSeq() {
		return this.dtlSeq;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}	
	
	/**
	 * Column Info
	 * @param cntrCount
	 */
	public void setCntrCount(String cntrCount) {
		this.cntrCount = cntrCount;
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
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param tmp2
	 */
	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
	}
	
	/**
	 * Column Info
	 * @param isfActCd
	 */
	public void setIsfActCd(String isfActCd) {
		this.isfActCd = isfActCd;
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
	 * @param tmp3
	 */
	public void setTmp3(String tmp3) {
		this.tmp3 = tmp3;
	}
	
	/**
	 * Column Info
	 * @param sndProcId
	 */
	public void setSndProcId(String sndProcId) {
		this.sndProcId = sndProcId;
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
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
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
	 * @param dtlSeq
	 */
	public void setDtlSeq(String dtlSeq) {
		this.dtlSeq = dtlSeq;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrCount(JSPUtil.getParameter(request, "cntr_count", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setMsg(JSPUtil.getParameter(request, "msg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTmp2(JSPUtil.getParameter(request, "tmp2", ""));
		setIsfActCd(JSPUtil.getParameter(request, "isf_act_cd", ""));
		setTmp1(JSPUtil.getParameter(request, "tmp1", ""));
		setTmp3(JSPUtil.getParameter(request, "tmp3", ""));
		setSndProcId(JSPUtil.getParameter(request, "snd_proc_id", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setDtlSeq(JSPUtil.getParameter(request, "dtl_seq", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, "cstmsPortCd", ""));		
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendDetailLogVO[]
	 */
	public SendDetailLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SendDetailLogVO[]
	 */
	public SendDetailLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SendDetailLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrCount = (JSPUtil.getParameter(request, prefix	+ "cntr_count", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] msg = (JSPUtil.getParameter(request, prefix	+ "msg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmp2 = (JSPUtil.getParameter(request, prefix	+ "tmp2", length));
			String[] isfActCd = (JSPUtil.getParameter(request, prefix	+ "isf_act_cd", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp1", length));
			String[] tmp3 = (JSPUtil.getParameter(request, prefix	+ "tmp3", length));
			String[] sndProcId = (JSPUtil.getParameter(request, prefix	+ "snd_proc_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstmsPortCd", length));			
					
			for (int i = 0; i < length; i++) {
				model = new SendDetailLogVO();
				if (cntrCount[i] != null)
					model.setCntrCount(cntrCount[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (msg[i] != null)
					model.setMsg(msg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmp2[i] != null)
					model.setTmp2(tmp2[i]);
				if (isfActCd[i] != null)
					model.setIsfActCd(isfActCd[i]);
				if (tmp1[i] != null)
					model.setTmp1(tmp1[i]);
				if (tmp3[i] != null)
					model.setTmp3(tmp3[i]);
				if (sndProcId[i] != null)
					model.setSndProcId(sndProcId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSendDetailLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SendDetailLogVO[]
	 */
	public SendDetailLogVO[] getSendDetailLogVOs(){
		SendDetailLogVO[] vos = (SendDetailLogVO[])models.toArray(new SendDetailLogVO[models.size()]);
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
		this.cntrCount = this.cntrCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msg = this.msg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp2 = this.tmp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfActCd = this.isfActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp1 = this.tmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp3 = this.tmp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndProcId = this.sndProcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		
	}
}
