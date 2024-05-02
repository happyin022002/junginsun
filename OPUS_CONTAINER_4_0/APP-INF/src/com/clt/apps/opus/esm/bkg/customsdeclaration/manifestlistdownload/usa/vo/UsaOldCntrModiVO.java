/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaOldCntrModiVO.java
*@FileTitle : UsaOldCntrModiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaOldCntrModiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaOldCntrModiVO> models = new ArrayList<UsaOldCntrModiVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String priorNtcSndFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cmdtGdsSeq = null;
	/* Column Info */
	private String hamoCmdtCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaOldCntrModiVO() {}

	public UsaOldCntrModiVO(String ibflag, String pagerows, String blNo, String cntrNo, String cmdtGdsSeq, String hamoCmdtCd, String priorNtcSndFlg) {
		this.ibflag = ibflag;
		this.priorNtcSndFlg = priorNtcSndFlg;
		this.cntrNo = cntrNo;
		this.cmdtGdsSeq = cmdtGdsSeq;
		this.hamoCmdtCd = hamoCmdtCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prior_ntc_snd_flg", getPriorNtcSndFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cmdt_gds_seq", getCmdtGdsSeq());
		this.hashColumns.put("hamo_cmdt_cd", getHamoCmdtCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prior_ntc_snd_flg", "priorNtcSndFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cmdt_gds_seq", "cmdtGdsSeq");
		this.hashFields.put("hamo_cmdt_cd", "hamoCmdtCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return priorNtcSndFlg
	 */
	public String getPriorNtcSndFlg() {
		return this.priorNtcSndFlg;
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
	 * @return cmdtGdsSeq
	 */
	public String getCmdtGdsSeq() {
		return this.cmdtGdsSeq;
	}
	
	/**
	 * Column Info
	 * @return hamoCmdtCd
	 */
	public String getHamoCmdtCd() {
		return this.hamoCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param priorNtcSndFlg
	 */
	public void setPriorNtcSndFlg(String priorNtcSndFlg) {
		this.priorNtcSndFlg = priorNtcSndFlg;
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
	 * @param cmdtGdsSeq
	 */
	public void setCmdtGdsSeq(String cmdtGdsSeq) {
		this.cmdtGdsSeq = cmdtGdsSeq;
	}
	
	/**
	 * Column Info
	 * @param hamoCmdtCd
	 */
	public void setHamoCmdtCd(String hamoCmdtCd) {
		this.hamoCmdtCd = hamoCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPriorNtcSndFlg(JSPUtil.getParameter(request, prefix + "prior_ntc_snd_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCmdtGdsSeq(JSPUtil.getParameter(request, prefix + "cmdt_gds_seq", ""));
		setHamoCmdtCd(JSPUtil.getParameter(request, prefix + "hamo_cmdt_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaOldCntrModiVO[]
	 */
	public UsaOldCntrModiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaOldCntrModiVO[]
	 */
	public UsaOldCntrModiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaOldCntrModiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] priorNtcSndFlg = (JSPUtil.getParameter(request, prefix	+ "prior_ntc_snd_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cmdtGdsSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_gds_seq", length));
			String[] hamoCmdtCd = (JSPUtil.getParameter(request, prefix	+ "hamo_cmdt_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaOldCntrModiVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (priorNtcSndFlg[i] != null)
					model.setPriorNtcSndFlg(priorNtcSndFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cmdtGdsSeq[i] != null)
					model.setCmdtGdsSeq(cmdtGdsSeq[i]);
				if (hamoCmdtCd[i] != null)
					model.setHamoCmdtCd(hamoCmdtCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaOldCntrModiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaOldCntrModiVO[]
	 */
	public UsaOldCntrModiVO[] getUsaOldCntrModiVOs(){
		UsaOldCntrModiVO[] vos = (UsaOldCntrModiVO[])models.toArray(new UsaOldCntrModiVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.priorNtcSndFlg = this.priorNtcSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtGdsSeq = this.cmdtGdsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hamoCmdtCd = this.hamoCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
