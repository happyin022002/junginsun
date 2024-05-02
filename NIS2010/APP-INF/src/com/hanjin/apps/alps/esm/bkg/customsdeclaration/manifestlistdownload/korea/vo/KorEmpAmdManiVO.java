/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorEmpAmdManiVO.java
*@FileTitle : KorEmpAmdManiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.13 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.EmpAmdManiVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see EmpAmdManiVO
 */

public class KorEmpAmdManiVO extends EmpAmdManiVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorEmpAmdManiVO> models = new ArrayList<KorEmpAmdManiVO>();
	
	/* Column Info */
	private String ibTsBkgno = null;
	/* Column Info */
	private String receiver = null;
	/* Column Info */
	private String ibTsPort = null;
	/* Column Info */
	private String ibTsVvd = null;
	/* Column Info */
	private String ibTsSeq = null;
	/* Column Info */
	private String ibTsCblno = null;
	/* Column Info */
	private String ibTsType = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String corrReason = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String subNo = null;
	/* Column Info */
	private String corrCd = null;
	/* Column Info */
	private String usrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorEmpAmdManiVO() {}

	public KorEmpAmdManiVO(String ibflag, String pagerows, String ibTsSeq, String ibTsCblno, String ibTsPort, String ibTsBkgno, String ibTsType, String ibTsVvd, String corrCd, String corrReason, String usrId, String subNo, String blNo, String receiver, String ofcCd) {
		this.ibTsBkgno = ibTsBkgno;
		this.receiver = receiver;
		this.ibTsPort = ibTsPort;
		this.ibTsVvd = ibTsVvd;
		this.ibTsSeq = ibTsSeq;
		this.ibTsCblno = ibTsCblno;
		this.ibTsType = ibTsType;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.corrReason = corrReason;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.subNo = subNo;
		this.corrCd = corrCd;
		this.usrId = usrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ib_ts_bkgno", getIbTsBkgno());
		this.hashColumns.put("receiver", getReceiver());
		this.hashColumns.put("ib_ts_port", getIbTsPort());
		this.hashColumns.put("ib_ts_vvd", getIbTsVvd());
		this.hashColumns.put("ib_ts_seq", getIbTsSeq());
		this.hashColumns.put("ib_ts_cblno", getIbTsCblno());
		this.hashColumns.put("ib_ts_type", getIbTsType());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("corr_reason", getCorrReason());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sub_no", getSubNo());
		this.hashColumns.put("corr_cd", getCorrCd());
		this.hashColumns.put("usr_id", getUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ib_ts_bkgno", "ibTsBkgno");
		this.hashFields.put("receiver", "receiver");
		this.hashFields.put("ib_ts_port", "ibTsPort");
		this.hashFields.put("ib_ts_vvd", "ibTsVvd");
		this.hashFields.put("ib_ts_seq", "ibTsSeq");
		this.hashFields.put("ib_ts_cblno", "ibTsCblno");
		this.hashFields.put("ib_ts_type", "ibTsType");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("corr_reason", "corrReason");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sub_no", "subNo");
		this.hashFields.put("corr_cd", "corrCd");
		this.hashFields.put("usr_id", "usrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ibTsBkgno
	 */
	public String getIbTsBkgno() {
		return this.ibTsBkgno;
	}
	
	/**
	 * Column Info
	 * @return receiver
	 */
	public String getReceiver() {
		return this.receiver;
	}
	
	/**
	 * Column Info
	 * @return ibTsPort
	 */
	public String getIbTsPort() {
		return this.ibTsPort;
	}
	
	/**
	 * Column Info
	 * @return ibTsVvd
	 */
	public String getIbTsVvd() {
		return this.ibTsVvd;
	}
	
	/**
	 * Column Info
	 * @return ibTsSeq
	 */
	public String getIbTsSeq() {
		return this.ibTsSeq;
	}
	
	/**
	 * Column Info
	 * @return ibTsCblno
	 */
	public String getIbTsCblno() {
		return this.ibTsCblno;
	}
	
	/**
	 * Column Info
	 * @return ibTsType
	 */
	public String getIbTsType() {
		return this.ibTsType;
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
	 * Column Info
	 * @return corrReason
	 */
	public String getCorrReason() {
		return this.corrReason;
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
	 * @return subNo
	 */
	public String getSubNo() {
		return this.subNo;
	}
	
	/**
	 * Column Info
	 * @return corrCd
	 */
	public String getCorrCd() {
		return this.corrCd;
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
	 * @param ibTsBkgno
	 */
	public void setIbTsBkgno(String ibTsBkgno) {
		this.ibTsBkgno = ibTsBkgno;
	}
	
	/**
	 * Column Info
	 * @param receiver
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	/**
	 * Column Info
	 * @param ibTsPort
	 */
	public void setIbTsPort(String ibTsPort) {
		this.ibTsPort = ibTsPort;
	}
	
	/**
	 * Column Info
	 * @param ibTsVvd
	 */
	public void setIbTsVvd(String ibTsVvd) {
		this.ibTsVvd = ibTsVvd;
	}
	
	/**
	 * Column Info
	 * @param ibTsSeq
	 */
	public void setIbTsSeq(String ibTsSeq) {
		this.ibTsSeq = ibTsSeq;
	}
	
	/**
	 * Column Info
	 * @param ibTsCblno
	 */
	public void setIbTsCblno(String ibTsCblno) {
		this.ibTsCblno = ibTsCblno;
	}
	
	/**
	 * Column Info
	 * @param ibTsType
	 */
	public void setIbTsType(String ibTsType) {
		this.ibTsType = ibTsType;
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
	 * Column Info
	 * @param corrReason
	 */
	public void setCorrReason(String corrReason) {
		this.corrReason = corrReason;
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
	 * @param subNo
	 */
	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}
	
	/**
	 * Column Info
	 * @param corrCd
	 */
	public void setCorrCd(String corrCd) {
		this.corrCd = corrCd;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
		setIbTsBkgno(JSPUtil.getParameter(request, prefix + "ib_ts_bkgno", ""));
		setReceiver(JSPUtil.getParameter(request, prefix + "receiver", ""));
		setIbTsPort(JSPUtil.getParameter(request, prefix + "ib_ts_port", ""));
		setIbTsVvd(JSPUtil.getParameter(request, prefix + "ib_ts_vvd", ""));
		setIbTsSeq(JSPUtil.getParameter(request, prefix + "ib_ts_seq", ""));
		setIbTsCblno(JSPUtil.getParameter(request, prefix + "ib_ts_cblno", ""));
		setIbTsType(JSPUtil.getParameter(request, prefix + "ib_ts_type", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCorrReason(JSPUtil.getParameter(request, prefix + "corr_reason", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSubNo(JSPUtil.getParameter(request, prefix + "sub_no", ""));
		setCorrCd(JSPUtil.getParameter(request, prefix + "corr_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorEmpAmdManiVO[]
	 */
	public KorEmpAmdManiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorEmpAmdManiVO[]
	 */
	public KorEmpAmdManiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorEmpAmdManiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibTsBkgno = (JSPUtil.getParameter(request, prefix	+ "ib_ts_bkgno", length));
			String[] receiver = (JSPUtil.getParameter(request, prefix	+ "receiver", length));
			String[] ibTsPort = (JSPUtil.getParameter(request, prefix	+ "ib_ts_port", length));
			String[] ibTsVvd = (JSPUtil.getParameter(request, prefix	+ "ib_ts_vvd", length));
			String[] ibTsSeq = (JSPUtil.getParameter(request, prefix	+ "ib_ts_seq", length));
			String[] ibTsCblno = (JSPUtil.getParameter(request, prefix	+ "ib_ts_cblno", length));
			String[] ibTsType = (JSPUtil.getParameter(request, prefix	+ "ib_ts_type", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] corrReason = (JSPUtil.getParameter(request, prefix	+ "corr_reason", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] subNo = (JSPUtil.getParameter(request, prefix	+ "sub_no", length));
			String[] corrCd = (JSPUtil.getParameter(request, prefix	+ "corr_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorEmpAmdManiVO();
				if (ibTsBkgno[i] != null)
					model.setIbTsBkgno(ibTsBkgno[i]);
				if (receiver[i] != null)
					model.setReceiver(receiver[i]);
				if (ibTsPort[i] != null)
					model.setIbTsPort(ibTsPort[i]);
				if (ibTsVvd[i] != null)
					model.setIbTsVvd(ibTsVvd[i]);
				if (ibTsSeq[i] != null)
					model.setIbTsSeq(ibTsSeq[i]);
				if (ibTsCblno[i] != null)
					model.setIbTsCblno(ibTsCblno[i]);
				if (ibTsType[i] != null)
					model.setIbTsType(ibTsType[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (corrReason[i] != null)
					model.setCorrReason(corrReason[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (subNo[i] != null)
					model.setSubNo(subNo[i]);
				if (corrCd[i] != null)
					model.setCorrCd(corrCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorEmpAmdManiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorEmpAmdManiVO[]
	 */
	public KorEmpAmdManiVO[] getKorEmpAmdManiVOs(){
		KorEmpAmdManiVO[] vos = (KorEmpAmdManiVO[])models.toArray(new KorEmpAmdManiVO[models.size()]);
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
		this.ibTsBkgno = this.ibTsBkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiver = this.receiver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTsPort = this.ibTsPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTsVvd = this.ibTsVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTsSeq = this.ibTsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTsCblno = this.ibTsCblno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTsType = this.ibTsType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrReason = this.corrReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subNo = this.subNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrCd = this.corrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
