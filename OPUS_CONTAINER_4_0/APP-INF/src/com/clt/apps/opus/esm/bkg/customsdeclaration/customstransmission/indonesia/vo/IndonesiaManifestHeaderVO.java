/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndonesiaManifestHeaderVO.java
*@FileTitle : IndonesiaManifestHeaderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.10.07 민동진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo;

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
 * @author 민동진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IndonesiaManifestHeaderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndonesiaManifestHeaderVO> models = new ArrayList<IndonesiaManifestHeaderVO>();
	
	/* Column Info */
	private String firstClptSeq = null;
	/* Column Info */
	private String lastClptEtaDt = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String portClptSeq = null;
	/* Column Info */
	private String nextClptPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String firstClptPortCd = null;
	/* Column Info */
	private String lastClptSeq = null;
	/* Column Info */
	private String previousClptPortCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndonesiaManifestHeaderVO() {}

	public IndonesiaManifestHeaderVO(String ibflag, String pagerows, String vslEngNm, String callSgnNo, String vslRgstCntCd, String skdVoyNo, String skdDirCd, String firstClptSeq, String firstClptPortCd, String portClptSeq, String previousClptPortCd, String nextClptPortCd, String lastClptSeq, String lastClptEtaDt) {
		this.firstClptSeq = firstClptSeq;
		this.lastClptEtaDt = lastClptEtaDt;
		this.callSgnNo = callSgnNo;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.portClptSeq = portClptSeq;
		this.nextClptPortCd = nextClptPortCd;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.vslRgstCntCd = vslRgstCntCd;
		this.firstClptPortCd = firstClptPortCd;
		this.lastClptSeq = lastClptSeq;
		this.previousClptPortCd = previousClptPortCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("first_clpt_seq", getFirstClptSeq());
		this.hashColumns.put("last_clpt_eta_dt", getLastClptEtaDt());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("port_clpt_seq", getPortClptSeq());
		this.hashColumns.put("next_clpt_port_cd", getNextClptPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("first_clpt_port_cd", getFirstClptPortCd());
		this.hashColumns.put("last_clpt_seq", getLastClptSeq());
		this.hashColumns.put("previous_clpt_port_cd", getPreviousClptPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("first_clpt_seq", "firstClptSeq");
		this.hashFields.put("last_clpt_eta_dt", "lastClptEtaDt");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("port_clpt_seq", "portClptSeq");
		this.hashFields.put("next_clpt_port_cd", "nextClptPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("first_clpt_port_cd", "firstClptPortCd");
		this.hashFields.put("last_clpt_seq", "lastClptSeq");
		this.hashFields.put("previous_clpt_port_cd", "previousClptPortCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return firstClptSeq
	 */
	public String getFirstClptSeq() {
		return this.firstClptSeq;
	}
	
	/**
	 * Column Info
	 * @return lastClptEtaDt
	 */
	public String getLastClptEtaDt() {
		return this.lastClptEtaDt;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
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
	 * @return portClptSeq
	 */
	public String getPortClptSeq() {
		return this.portClptSeq;
	}
	
	/**
	 * Column Info
	 * @return nextClptPortCd
	 */
	public String getNextClptPortCd() {
		return this.nextClptPortCd;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @return firstClptPortCd
	 */
	public String getFirstClptPortCd() {
		return this.firstClptPortCd;
	}
	
	/**
	 * Column Info
	 * @return lastClptSeq
	 */
	public String getLastClptSeq() {
		return this.lastClptSeq;
	}
	
	/**
	 * Column Info
	 * @return previousClptPortCd
	 */
	public String getPreviousClptPortCd() {
		return this.previousClptPortCd;
	}
	

	/**
	 * Column Info
	 * @param firstClptSeq
	 */
	public void setFirstClptSeq(String firstClptSeq) {
		this.firstClptSeq = firstClptSeq;
	}
	
	/**
	 * Column Info
	 * @param lastClptEtaDt
	 */
	public void setLastClptEtaDt(String lastClptEtaDt) {
		this.lastClptEtaDt = lastClptEtaDt;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
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
	 * @param portClptSeq
	 */
	public void setPortClptSeq(String portClptSeq) {
		this.portClptSeq = portClptSeq;
	}
	
	/**
	 * Column Info
	 * @param nextClptPortCd
	 */
	public void setNextClptPortCd(String nextClptPortCd) {
		this.nextClptPortCd = nextClptPortCd;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @param firstClptPortCd
	 */
	public void setFirstClptPortCd(String firstClptPortCd) {
		this.firstClptPortCd = firstClptPortCd;
	}
	
	/**
	 * Column Info
	 * @param lastClptSeq
	 */
	public void setLastClptSeq(String lastClptSeq) {
		this.lastClptSeq = lastClptSeq;
	}
	
	/**
	 * Column Info
	 * @param previousClptPortCd
	 */
	public void setPreviousClptPortCd(String previousClptPortCd) {
		this.previousClptPortCd = previousClptPortCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFirstClptSeq(JSPUtil.getParameter(request, "first_clpt_seq", ""));
		setLastClptEtaDt(JSPUtil.getParameter(request, "last_clpt_eta_dt", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPortClptSeq(JSPUtil.getParameter(request, "port_clpt_seq", ""));
		setNextClptPortCd(JSPUtil.getParameter(request, "next_clpt_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, "vsl_rgst_cnt_cd", ""));
		setFirstClptPortCd(JSPUtil.getParameter(request, "first_clpt_port_cd", ""));
		setLastClptSeq(JSPUtil.getParameter(request, "last_clpt_seq", ""));
		setPreviousClptPortCd(JSPUtil.getParameter(request, "previous_clpt_port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndonesiaManifestHeaderVO[]
	 */
	public IndonesiaManifestHeaderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndonesiaManifestHeaderVO[]
	 */
	public IndonesiaManifestHeaderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndonesiaManifestHeaderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] firstClptSeq = (JSPUtil.getParameter(request, prefix	+ "first_clpt_seq", length));
			String[] lastClptEtaDt = (JSPUtil.getParameter(request, prefix	+ "last_clpt_eta_dt", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] portClptSeq = (JSPUtil.getParameter(request, prefix	+ "port_clpt_seq", length));
			String[] nextClptPortCd = (JSPUtil.getParameter(request, prefix	+ "next_clpt_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] firstClptPortCd = (JSPUtil.getParameter(request, prefix	+ "first_clpt_port_cd", length));
			String[] lastClptSeq = (JSPUtil.getParameter(request, prefix	+ "last_clpt_seq", length));
			String[] previousClptPortCd = (JSPUtil.getParameter(request, prefix	+ "previous_clpt_port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndonesiaManifestHeaderVO();
				if (firstClptSeq[i] != null)
					model.setFirstClptSeq(firstClptSeq[i]);
				if (lastClptEtaDt[i] != null)
					model.setLastClptEtaDt(lastClptEtaDt[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (portClptSeq[i] != null)
					model.setPortClptSeq(portClptSeq[i]);
				if (nextClptPortCd[i] != null)
					model.setNextClptPortCd(nextClptPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (firstClptPortCd[i] != null)
					model.setFirstClptPortCd(firstClptPortCd[i]);
				if (lastClptSeq[i] != null)
					model.setLastClptSeq(lastClptSeq[i]);
				if (previousClptPortCd[i] != null)
					model.setPreviousClptPortCd(previousClptPortCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndonesiaManifestHeaderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndonesiaManifestHeaderVO[]
	 */
	public IndonesiaManifestHeaderVO[] getIndonesiaManifestHeaderVOs(){
		IndonesiaManifestHeaderVO[] vos = (IndonesiaManifestHeaderVO[])models.toArray(new IndonesiaManifestHeaderVO[models.size()]);
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
		this.firstClptSeq = this.firstClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastClptEtaDt = this.lastClptEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portClptSeq = this.portClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextClptPortCd = this.nextClptPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstClptPortCd = this.firstClptPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastClptSeq = this.lastClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.previousClptPortCd = this.previousClptPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
