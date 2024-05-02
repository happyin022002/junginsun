/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ComAproSndLogVO.java
*@FileTitle : ComAproSndLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.irep.alps.FNS0080004Document;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComComAproSndLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComComAproSndLogVO> models = new ArrayList<ComComAproSndLogVO>();
	
	/* Column Info */
	/* 임의로 추가하니 table변경시 꼭 VO 재작업해야함  - getter와 setter만 추가됨 */
	private FNS0080004Document docReq = null;
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sndLogSeq = null;
	/* Column Info */
	private String sndRmk = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String exeStsCd = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String exeActTpCd = null;
	/* Column Info */
	private String exeDt = null;
	/* Column Info */
	private String srcCtnt = null;
	/* Column Info */
	private String csrTpCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComComAproSndLogVO() {}

	public ComComAproSndLogVO(String ibflag, String pagerows, String sndLogSeq, String csrNo, String srcCtnt, String exeStsCd, String exeActTpCd, String exeDt, String ifDt, String sndRmk, String deltFlg, String csrTpCd, String aproUsrId, String aproOfcCd, String aproDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.ifDt = ifDt;
		this.csrNo = csrNo;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.aproOfcCd = aproOfcCd;
		this.aproDt = aproDt;
		this.pagerows = pagerows;
		this.sndLogSeq = sndLogSeq;
		this.sndRmk = sndRmk;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.exeStsCd = exeStsCd;
		this.aproUsrId = aproUsrId;
		this.exeActTpCd = exeActTpCd;
		this.exeDt = exeDt;
		this.srcCtnt = srcCtnt;
		this.csrTpCd = csrTpCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("snd_log_seq", getSndLogSeq());
		this.hashColumns.put("snd_rmk", getSndRmk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("exe_sts_cd", getExeStsCd());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("exe_act_tp_cd", getExeActTpCd());
		this.hashColumns.put("exe_dt", getExeDt());
		this.hashColumns.put("src_ctnt", getSrcCtnt());
		this.hashColumns.put("csr_tp_cd", getCsrTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("snd_log_seq", "sndLogSeq");
		this.hashFields.put("snd_rmk", "sndRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("exe_sts_cd", "exeStsCd");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("exe_act_tp_cd", "exeActTpCd");
		this.hashFields.put("exe_dt", "exeDt");
		this.hashFields.put("src_ctnt", "srcCtnt");
		this.hashFields.put("csr_tp_cd", "csrTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	
	/**
	 * Column Info
	 * @return docReq
	 */
	public FNS0080004Document getDocReq() {
		return this.docReq;
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
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return sndLogSeq
	 */
	public String getSndLogSeq() {
		return this.sndLogSeq;
	}
	
	/**
	 * Column Info
	 * @return sndRmk
	 */
	public String getSndRmk() {
		return this.sndRmk;
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
	 * @return exeStsCd
	 */
	public String getExeStsCd() {
		return this.exeStsCd;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return exeActTpCd
	 */
	public String getExeActTpCd() {
		return this.exeActTpCd;
	}
	
	/**
	 * Column Info
	 * @return exeDt
	 */
	public String getExeDt() {
		return this.exeDt;
	}
	
	/**
	 * Column Info
	 * @return srcCtnt
	 */
	public String getSrcCtnt() {
		return this.srcCtnt;
	}
	
	/**
	 * Column Info
	 * @return csrTpCd
	 */
	public String getCsrTpCd() {
		return this.csrTpCd;
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
	 * @param  docReq
	 */
	public void setDocReq(FNS0080004Document docReq) {
		this.docReq = docReq;
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
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * @param sndLogSeq
	 */
	public void setSndLogSeq(String sndLogSeq) {
		this.sndLogSeq = sndLogSeq;
	}
	
	/**
	 * Column Info
	 * @param sndRmk
	 */
	public void setSndRmk(String sndRmk) {
		this.sndRmk = sndRmk;
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
	 * @param exeStsCd
	 */
	public void setExeStsCd(String exeStsCd) {
		this.exeStsCd = exeStsCd;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param exeActTpCd
	 */
	public void setExeActTpCd(String exeActTpCd) {
		this.exeActTpCd = exeActTpCd;
	}
	
	/**
	 * Column Info
	 * @param exeDt
	 */
	public void setExeDt(String exeDt) {
		this.exeDt = exeDt;
	}
	
	/**
	 * Column Info
	 * @param srcCtnt
	 */
	public void setSrcCtnt(String srcCtnt) {
		this.srcCtnt = srcCtnt;
	}
	
	/**
	 * Column Info
	 * @param csrTpCd
	 */
	public void setCsrTpCd(String csrTpCd) {
		this.csrTpCd = csrTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSndLogSeq(JSPUtil.getParameter(request, prefix + "snd_log_seq", ""));
		setSndRmk(JSPUtil.getParameter(request, prefix + "snd_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExeStsCd(JSPUtil.getParameter(request, prefix + "exe_sts_cd", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setExeActTpCd(JSPUtil.getParameter(request, prefix + "exe_act_tp_cd", ""));
		setExeDt(JSPUtil.getParameter(request, prefix + "exe_dt", ""));
		setSrcCtnt(JSPUtil.getParameter(request, prefix + "src_ctnt", ""));
		setCsrTpCd(JSPUtil.getParameter(request, prefix + "csr_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComAproSndLogVO[]
	 */
	public ComComAproSndLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComAproSndLogVO[]
	 */
	public ComComAproSndLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComComAproSndLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sndLogSeq = (JSPUtil.getParameter(request, prefix	+ "snd_log_seq", length));
			String[] sndRmk = (JSPUtil.getParameter(request, prefix	+ "snd_rmk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] exeStsCd = (JSPUtil.getParameter(request, prefix	+ "exe_sts_cd", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] exeActTpCd = (JSPUtil.getParameter(request, prefix	+ "exe_act_tp_cd", length));
			String[] exeDt = (JSPUtil.getParameter(request, prefix	+ "exe_dt", length));
			String[] srcCtnt = (JSPUtil.getParameter(request, prefix	+ "src_ctnt", length));
			String[] csrTpCd = (JSPUtil.getParameter(request, prefix	+ "csr_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComComAproSndLogVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sndLogSeq[i] != null)
					model.setSndLogSeq(sndLogSeq[i]);
				if (sndRmk[i] != null)
					model.setSndRmk(sndRmk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (exeStsCd[i] != null)
					model.setExeStsCd(exeStsCd[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (exeActTpCd[i] != null)
					model.setExeActTpCd(exeActTpCd[i]);
				if (exeDt[i] != null)
					model.setExeDt(exeDt[i]);
				if (srcCtnt[i] != null)
					model.setSrcCtnt(srcCtnt[i]);
				if (csrTpCd[i] != null)
					model.setCsrTpCd(csrTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComAproSndLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComAproSndLogVO[]
	 */
	public ComComAproSndLogVO[] getComAproSndLogVOs(){
		ComComAproSndLogVO[] vos = (ComComAproSndLogVO[])models.toArray(new ComComAproSndLogVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndLogSeq = this.sndLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRmk = this.sndRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeStsCd = this.exeStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeActTpCd = this.exeActTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeDt = this.exeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCtnt = this.srcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrTpCd = this.csrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
