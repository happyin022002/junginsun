/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QueueStatusVO.java
*@FileTitle : QueueStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class QueueStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<QueueStatusVO> models = new ArrayList<QueueStatusVO>();
	
	/* Column Info */
	private String blAudFlg = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String blDocInpFlg = null;
	/* Column Info */
	private String audPndCnt = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String inpPndCnt = null;
	/* Column Info */
	private String blRtFlg = null;
	/* Column Info */
	private String toTm = null;
	/* Column Info */
	private String fmTm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inpCnt = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String ttlCnt = null;
	/* Column Info */
	private String rtPndCnt = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String rtCnt = null;
	/* Column Info */
	private String audCnt = null;
	/* Column Info */
	private String ttlPndCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public QueueStatusVO() {}

	public QueueStatusVO(String ibflag, String pagerows, String rgnOfcCd, String bkgOfcCd, String inpCnt, String inpPndCnt, String rtCnt, String rtPndCnt, String audCnt, String audPndCnt, String ttlCnt, String ttlPndCnt, String fmDt, String toDt, String fmTm, String toTm, String srAmdTpCd, String blDocInpFlg, String blRtFlg, String blAudFlg) {
		this.blAudFlg = blAudFlg;
		this.bkgOfcCd = bkgOfcCd;
		this.blDocInpFlg = blDocInpFlg;
		this.audPndCnt = audPndCnt;
		this.fmDt = fmDt;
		this.inpPndCnt = inpPndCnt;
		this.blRtFlg = blRtFlg;
		this.toTm = toTm;
		this.fmTm = fmTm;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.ibflag = ibflag;
		this.inpCnt = inpCnt;
		this.srAmdTpCd = srAmdTpCd;
		this.ttlCnt = ttlCnt;
		this.rtPndCnt = rtPndCnt;
		this.rgnOfcCd = rgnOfcCd;
		this.rtCnt = rtCnt;
		this.audCnt = audCnt;
		this.ttlPndCnt = ttlPndCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_aud_flg", getBlAudFlg());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bl_doc_inp_flg", getBlDocInpFlg());
		this.hashColumns.put("aud_pnd_cnt", getAudPndCnt());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("inp_pnd_cnt", getInpPndCnt());
		this.hashColumns.put("bl_rt_flg", getBlRtFlg());
		this.hashColumns.put("to_tm", getToTm());
		this.hashColumns.put("fm_tm", getFmTm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inp_cnt", getInpCnt());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("ttl_cnt", getTtlCnt());
		this.hashColumns.put("rt_pnd_cnt", getRtPndCnt());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("rt_cnt", getRtCnt());
		this.hashColumns.put("aud_cnt", getAudCnt());
		this.hashColumns.put("ttl_pnd_cnt", getTtlPndCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_aud_flg", "blAudFlg");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bl_doc_inp_flg", "blDocInpFlg");
		this.hashFields.put("aud_pnd_cnt", "audPndCnt");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("inp_pnd_cnt", "inpPndCnt");
		this.hashFields.put("bl_rt_flg", "blRtFlg");
		this.hashFields.put("to_tm", "toTm");
		this.hashFields.put("fm_tm", "fmTm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inp_cnt", "inpCnt");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("ttl_cnt", "ttlCnt");
		this.hashFields.put("rt_pnd_cnt", "rtPndCnt");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("rt_cnt", "rtCnt");
		this.hashFields.put("aud_cnt", "audCnt");
		this.hashFields.put("ttl_pnd_cnt", "ttlPndCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blAudFlg
	 */
	public String getBlAudFlg() {
		return this.blAudFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blDocInpFlg
	 */
	public String getBlDocInpFlg() {
		return this.blDocInpFlg;
	}
	
	/**
	 * Column Info
	 * @return audPndCnt
	 */
	public String getAudPndCnt() {
		return this.audPndCnt;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return inpPndCnt
	 */
	public String getInpPndCnt() {
		return this.inpPndCnt;
	}
	
	/**
	 * Column Info
	 * @return blRtFlg
	 */
	public String getBlRtFlg() {
		return this.blRtFlg;
	}
	
	/**
	 * Column Info
	 * @return toTm
	 */
	public String getToTm() {
		return this.toTm;
	}
	
	/**
	 * Column Info
	 * @return fmTm
	 */
	public String getFmTm() {
		return this.fmTm;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return inpCnt
	 */
	public String getInpCnt() {
		return this.inpCnt;
	}
	
	/**
	 * Column Info
	 * @return srAmdTpCd
	 */
	public String getSrAmdTpCd() {
		return this.srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return ttlCnt
	 */
	public String getTtlCnt() {
		return this.ttlCnt;
	}
	
	/**
	 * Column Info
	 * @return rtPndCnt
	 */
	public String getRtPndCnt() {
		return this.rtPndCnt;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rtCnt
	 */
	public String getRtCnt() {
		return this.rtCnt;
	}
	
	/**
	 * Column Info
	 * @return audCnt
	 */
	public String getAudCnt() {
		return this.audCnt;
	}
	
	/**
	 * Column Info
	 * @return ttlPndCnt
	 */
	public String getTtlPndCnt() {
		return this.ttlPndCnt;
	}
	

	/**
	 * Column Info
	 * @param blAudFlg
	 */
	public void setBlAudFlg(String blAudFlg) {
		this.blAudFlg = blAudFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blDocInpFlg
	 */
	public void setBlDocInpFlg(String blDocInpFlg) {
		this.blDocInpFlg = blDocInpFlg;
	}
	
	/**
	 * Column Info
	 * @param audPndCnt
	 */
	public void setAudPndCnt(String audPndCnt) {
		this.audPndCnt = audPndCnt;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param inpPndCnt
	 */
	public void setInpPndCnt(String inpPndCnt) {
		this.inpPndCnt = inpPndCnt;
	}
	
	/**
	 * Column Info
	 * @param blRtFlg
	 */
	public void setBlRtFlg(String blRtFlg) {
		this.blRtFlg = blRtFlg;
	}
	
	/**
	 * Column Info
	 * @param toTm
	 */
	public void setToTm(String toTm) {
		this.toTm = toTm;
	}
	
	/**
	 * Column Info
	 * @param fmTm
	 */
	public void setFmTm(String fmTm) {
		this.fmTm = fmTm;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param inpCnt
	 */
	public void setInpCnt(String inpCnt) {
		this.inpCnt = inpCnt;
	}
	
	/**
	 * Column Info
	 * @param srAmdTpCd
	 */
	public void setSrAmdTpCd(String srAmdTpCd) {
		this.srAmdTpCd = srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param ttlCnt
	 */
	public void setTtlCnt(String ttlCnt) {
		this.ttlCnt = ttlCnt;
	}
	
	/**
	 * Column Info
	 * @param rtPndCnt
	 */
	public void setRtPndCnt(String rtPndCnt) {
		this.rtPndCnt = rtPndCnt;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rtCnt
	 */
	public void setRtCnt(String rtCnt) {
		this.rtCnt = rtCnt;
	}
	
	/**
	 * Column Info
	 * @param audCnt
	 */
	public void setAudCnt(String audCnt) {
		this.audCnt = audCnt;
	}
	
	/**
	 * Column Info
	 * @param ttlPndCnt
	 */
	public void setTtlPndCnt(String ttlPndCnt) {
		this.ttlPndCnt = ttlPndCnt;
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
		setBlAudFlg(JSPUtil.getParameter(request, prefix + "bl_aud_flg", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBlDocInpFlg(JSPUtil.getParameter(request, prefix + "bl_doc_inp_flg", ""));
		setAudPndCnt(JSPUtil.getParameter(request, prefix + "aud_pnd_cnt", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setInpPndCnt(JSPUtil.getParameter(request, prefix + "inp_pnd_cnt", ""));
		setBlRtFlg(JSPUtil.getParameter(request, prefix + "bl_rt_flg", ""));
		setToTm(JSPUtil.getParameter(request, prefix + "to_tm", ""));
		setFmTm(JSPUtil.getParameter(request, prefix + "fm_tm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInpCnt(JSPUtil.getParameter(request, prefix + "inp_cnt", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_tp_cd", ""));
		setTtlCnt(JSPUtil.getParameter(request, prefix + "ttl_cnt", ""));
		setRtPndCnt(JSPUtil.getParameter(request, prefix + "rt_pnd_cnt", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setRtCnt(JSPUtil.getParameter(request, prefix + "rt_cnt", ""));
		setAudCnt(JSPUtil.getParameter(request, prefix + "aud_cnt", ""));
		setTtlPndCnt(JSPUtil.getParameter(request, prefix + "ttl_pnd_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return QueueStatusVO[]
	 */
	public QueueStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return QueueStatusVO[]
	 */
	public QueueStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		QueueStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blAudFlg = (JSPUtil.getParameter(request, prefix	+ "bl_aud_flg", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] blDocInpFlg = (JSPUtil.getParameter(request, prefix	+ "bl_doc_inp_flg", length));
			String[] audPndCnt = (JSPUtil.getParameter(request, prefix	+ "aud_pnd_cnt", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] inpPndCnt = (JSPUtil.getParameter(request, prefix	+ "inp_pnd_cnt", length));
			String[] blRtFlg = (JSPUtil.getParameter(request, prefix	+ "bl_rt_flg", length));
			String[] toTm = (JSPUtil.getParameter(request, prefix	+ "to_tm", length));
			String[] fmTm = (JSPUtil.getParameter(request, prefix	+ "fm_tm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inpCnt = (JSPUtil.getParameter(request, prefix	+ "inp_cnt", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] ttlCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_cnt", length));
			String[] rtPndCnt = (JSPUtil.getParameter(request, prefix	+ "rt_pnd_cnt", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] rtCnt = (JSPUtil.getParameter(request, prefix	+ "rt_cnt", length));
			String[] audCnt = (JSPUtil.getParameter(request, prefix	+ "aud_cnt", length));
			String[] ttlPndCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_pnd_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new QueueStatusVO();
				if (blAudFlg[i] != null)
					model.setBlAudFlg(blAudFlg[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (blDocInpFlg[i] != null)
					model.setBlDocInpFlg(blDocInpFlg[i]);
				if (audPndCnt[i] != null)
					model.setAudPndCnt(audPndCnt[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (inpPndCnt[i] != null)
					model.setInpPndCnt(inpPndCnt[i]);
				if (blRtFlg[i] != null)
					model.setBlRtFlg(blRtFlg[i]);
				if (toTm[i] != null)
					model.setToTm(toTm[i]);
				if (fmTm[i] != null)
					model.setFmTm(fmTm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inpCnt[i] != null)
					model.setInpCnt(inpCnt[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (ttlCnt[i] != null)
					model.setTtlCnt(ttlCnt[i]);
				if (rtPndCnt[i] != null)
					model.setRtPndCnt(rtPndCnt[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (rtCnt[i] != null)
					model.setRtCnt(rtCnt[i]);
				if (audCnt[i] != null)
					model.setAudCnt(audCnt[i]);
				if (ttlPndCnt[i] != null)
					model.setTtlPndCnt(ttlPndCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getQueueStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return QueueStatusVO[]
	 */
	public QueueStatusVO[] getQueueStatusVOs(){
		QueueStatusVO[] vos = (QueueStatusVO[])models.toArray(new QueueStatusVO[models.size()]);
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
		this.blAudFlg = this.blAudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDocInpFlg = this.blDocInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audPndCnt = this.audPndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpPndCnt = this.inpPndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRtFlg = this.blRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTm = this.toTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTm = this.fmTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpCnt = this.inpCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCnt = this.ttlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtPndCnt = this.rtPndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCnt = this.rtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audCnt = this.audCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPndCnt = this.ttlPndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
