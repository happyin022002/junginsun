/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24IbMtInfoVO.java
*@FileTitle : Kor24IbMtInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.31
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.12.31 박상훈
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Kor24IbMtInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<Kor24IbMtInfoVO> models = new ArrayList<Kor24IbMtInfoVO>();

	/* Column Info */
	private String inBkg = null;
	/* Column Info */
	private String inCBl = null;
	/* Column Info */
	private String inTpCd = null;
	/* Column Info */
	private String inDir = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inVsl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inCgoTp = null;
	/* Column Info */
	private String inSeq = null;
	/* Column Info */
	private String inVoy = null;
	/* Column Info */
	private String inEta = null;
	/* Column Info */
	private String inPort = null;
	/* Column Info */
	private String inMsn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public Kor24IbMtInfoVO() {}

	public Kor24IbMtInfoVO(String ibflag, String pagerows, String inVsl, String inVoy, String inDir, String inEta, String inSeq, String inPort, String inTpCd, String inCBl, String inBkg, String inMsn, String inCgoTp) {
		this.inBkg = inBkg;
		this.inCBl = inCBl;
		this.inTpCd = inTpCd;
		this.inDir = inDir;
		this.pagerows = pagerows;
		this.inVsl = inVsl;
		this.ibflag = ibflag;
		this.inCgoTp = inCgoTp;
		this.inSeq = inSeq;
		this.inVoy = inVoy;
		this.inEta = inEta;
		this.inPort = inPort;
		this.inMsn = inMsn;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_bkg", getInBkg());
		this.hashColumns.put("in_c_bl", getInCBl());
		this.hashColumns.put("in_tp_cd", getInTpCd());
		this.hashColumns.put("in_dir", getInDir());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_vsl", getInVsl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_cgo_tp", getInCgoTp());
		this.hashColumns.put("in_seq", getInSeq());
		this.hashColumns.put("in_voy", getInVoy());
		this.hashColumns.put("in_eta", getInEta());
		this.hashColumns.put("in_port", getInPort());
		this.hashColumns.put("in_msn", getInMsn());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_bkg", "inBkg");
		this.hashFields.put("in_c_bl", "inCBl");
		this.hashFields.put("in_tp_cd", "inTpCd");
		this.hashFields.put("in_dir", "inDir");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_vsl", "inVsl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_cgo_tp", "inCgoTp");
		this.hashFields.put("in_seq", "inSeq");
		this.hashFields.put("in_voy", "inVoy");
		this.hashFields.put("in_eta", "inEta");
		this.hashFields.put("in_port", "inPort");
		this.hashFields.put("in_msn", "inMsn");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return inBkg
	 */
	public String getInBkg() {
		return this.inBkg;
	}

	/**
	 * Column Info
	 * @return inCBl
	 */
	public String getInCBl() {
		return this.inCBl;
	}

	/**
	 * Column Info
	 * @return inTpCd
	 */
	public String getInTpCd() {
		return this.inTpCd;
	}

	/**
	 * Column Info
	 * @return inDir
	 */
	public String getInDir() {
		return this.inDir;
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
	 * @return inVsl
	 */
	public String getInVsl() {
		return this.inVsl;
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
	 * @return inCgoTp
	 */
	public String getInCgoTp() {
		return this.inCgoTp;
	}

	/**
	 * Column Info
	 * @return inSeq
	 */
	public String getInSeq() {
		return this.inSeq;
	}

	/**
	 * Column Info
	 * @return inVoy
	 */
	public String getInVoy() {
		return this.inVoy;
	}

	/**
	 * Column Info
	 * @return inEta
	 */
	public String getInEta() {
		return this.inEta;
	}

	/**
	 * Column Info
	 * @return inPort
	 */
	public String getInPort() {
		return this.inPort;
	}

	/**
	 * Column Info
	 * @return inMsn
	 */
	public String getInMsn() {
		return this.inMsn;
	}


	/**
	 * Column Info
	 * @param inBkg
	 */
	public void setInBkg(String inBkg) {
		this.inBkg = inBkg;
	}

	/**
	 * Column Info
	 * @param inCBl
	 */
	public void setInCBl(String inCBl) {
		this.inCBl = inCBl;
	}

	/**
	 * Column Info
	 * @param inTpCd
	 */
	public void setInTpCd(String inTpCd) {
		this.inTpCd = inTpCd;
	}

	/**
	 * Column Info
	 * @param inDir
	 */
	public void setInDir(String inDir) {
		this.inDir = inDir;
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
	 * @param inVsl
	 */
	public void setInVsl(String inVsl) {
		this.inVsl = inVsl;
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
	 * @param inCgoTp
	 */
	public void setInCgoTp(String inCgoTp) {
		this.inCgoTp = inCgoTp;
	}

	/**
	 * Column Info
	 * @param inSeq
	 */
	public void setInSeq(String inSeq) {
		this.inSeq = inSeq;
	}

	/**
	 * Column Info
	 * @param inVoy
	 */
	public void setInVoy(String inVoy) {
		this.inVoy = inVoy;
	}

	/**
	 * Column Info
	 * @param inEta
	 */
	public void setInEta(String inEta) {
		this.inEta = inEta;
	}

	/**
	 * Column Info
	 * @param inPort
	 */
	public void setInPort(String inPort) {
		this.inPort = inPort;
	}

	/**
	 * Column Info
	 * @param inMsn
	 */
	public void setInMsn(String inMsn) {
		this.inMsn = inMsn;
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
		setInBkg(JSPUtil.getParameter(request, prefix + "in_bkg", ""));
		setInCBl(JSPUtil.getParameter(request, prefix + "in_c_bl", ""));
		setInTpCd(JSPUtil.getParameter(request, prefix + "in_tp_cd", ""));
		setInDir(JSPUtil.getParameter(request, prefix + "in_dir", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInVsl(JSPUtil.getParameter(request, prefix + "in_vsl", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInCgoTp(JSPUtil.getParameter(request, prefix + "in_cgo_tp", ""));
		setInSeq(JSPUtil.getParameter(request, prefix + "in_seq", ""));
		setInVoy(JSPUtil.getParameter(request, prefix + "in_voy", ""));
		setInEta(JSPUtil.getParameter(request, prefix + "in_eta", ""));
		setInPort(JSPUtil.getParameter(request, prefix + "in_port", ""));
		setInMsn(JSPUtil.getParameter(request, prefix + "in_msn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Kor24IbMtInfoVO[]
	 */
	public Kor24IbMtInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return Kor24IbMtInfoVO[]
	 */
	public Kor24IbMtInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Kor24IbMtInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inBkg = (JSPUtil.getParameter(request, prefix	+ "in_bkg", length));
			String[] inCBl = (JSPUtil.getParameter(request, prefix	+ "in_c_bl", length));
			String[] inTpCd = (JSPUtil.getParameter(request, prefix	+ "in_tp_cd", length));
			String[] inDir = (JSPUtil.getParameter(request, prefix	+ "in_dir", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inVsl = (JSPUtil.getParameter(request, prefix	+ "in_vsl", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inCgoTp = (JSPUtil.getParameter(request, prefix	+ "in_cgo_tp", length));
			String[] inSeq = (JSPUtil.getParameter(request, prefix	+ "in_seq", length));
			String[] inVoy = (JSPUtil.getParameter(request, prefix	+ "in_voy", length));
			String[] inEta = (JSPUtil.getParameter(request, prefix	+ "in_eta", length));
			String[] inPort = (JSPUtil.getParameter(request, prefix	+ "in_port", length));
			String[] inMsn = (JSPUtil.getParameter(request, prefix	+ "in_msn", length));

			for (int i = 0; i < length; i++) {
				model = new Kor24IbMtInfoVO();
				if (inBkg[i] != null)
					model.setInBkg(inBkg[i]);
				if (inCBl[i] != null)
					model.setInCBl(inCBl[i]);
				if (inTpCd[i] != null)
					model.setInTpCd(inTpCd[i]);
				if (inDir[i] != null)
					model.setInDir(inDir[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inVsl[i] != null)
					model.setInVsl(inVsl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inCgoTp[i] != null)
					model.setInCgoTp(inCgoTp[i]);
				if (inSeq[i] != null)
					model.setInSeq(inSeq[i]);
				if (inVoy[i] != null)
					model.setInVoy(inVoy[i]);
				if (inEta[i] != null)
					model.setInEta(inEta[i]);
				if (inPort[i] != null)
					model.setInPort(inPort[i]);
				if (inMsn[i] != null)
					model.setInMsn(inMsn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKor24IbMtInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Kor24IbMtInfoVO[]
	 */
	public Kor24IbMtInfoVO[] getKor24IbMtInfoVOs(){
		Kor24IbMtInfoVO[] vos = (Kor24IbMtInfoVO[])models.toArray(new Kor24IbMtInfoVO[models.size()]);
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
		this.inBkg = this.inBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCBl = this.inCBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTpCd = this.inTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDir = this.inDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVsl = this.inVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCgoTp = this.inCgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSeq = this.inSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVoy = this.inVoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inEta = this.inEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPort = this.inPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inMsn = this.inMsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
