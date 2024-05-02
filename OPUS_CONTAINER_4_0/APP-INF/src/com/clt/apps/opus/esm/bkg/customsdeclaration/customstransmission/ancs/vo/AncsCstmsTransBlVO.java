/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AncsCstmsTransBlVO.java
*@FileTitle : AncsCstmsTransBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class AncsCstmsTransBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsTransBlVO> models = new ArrayList<AncsCstmsTransBlVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String shprName = null;
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String prevDocno = null;
	/* Column Info */
	private String ssRefNo = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String anrMsgStsCd = null;
	/* Column Info */
	private String mrn = null;
	/* Column Info */
	private String lloydCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String berthCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String post = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String pkg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String refSeq = null;
	/* Column Info */
	private String artNo = null;
	/* Column Info */
	private String cneeName = null;
	/* Column Info */
	private String sequence = null;
	/* Column Info */
	private String pre = null;
	/* Column Info */
	private String ntfyName = null;
	/* Column Info */
	private String wgtU = null;
	/* Column Info */
	private String kind = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AncsCstmsTransBlVO() {}

	public AncsCstmsTransBlVO(String ibflag, String pagerows, String vvd, String lloydCd, String ssRefNo, String refSeq, String wgt, String wgtU, String artNo, String blNo, String mrn, String pkg, String pod, String berthCd, String pol, String pre, String post, String por, String del, String shprName, String shprAddr, String cneeName, String cneeAddr, String ntfyName, String ntfyAddr, String bkgNo, String vslCd, String skdVoyNo, String skdDirCd, String anrMsgStsCd, String status, String sequence, String prevDocno) {
		this.vslCd = vslCd;
		this.shprName = shprName;
		this.cneeAddr = cneeAddr;
		this.prevDocno = prevDocno;
		this.ssRefNo = ssRefNo;
		this.por = por;
		this.anrMsgStsCd = anrMsgStsCd;
		this.mrn = mrn;
		this.lloydCd = lloydCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.berthCd = berthCd;
		this.ibflag = ibflag;
		this.shprAddr = shprAddr;
		this.wgt = wgt;
		this.pol = pol;
		this.del = del;
		this.pod = pod;
		this.ntfyAddr = ntfyAddr;
		this.post = post;
		this.status = status;
		this.skdVoyNo = skdVoyNo;
		this.pkg = pkg;
		this.skdDirCd = skdDirCd;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.refSeq = refSeq;
		this.artNo = artNo;
		this.cneeName = cneeName;
		this.sequence = sequence;
		this.pre = pre;
		this.ntfyName = ntfyName;
		this.wgtU = wgtU;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("shpr_name", getShprName());
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("prev_docno", getPrevDocno());
		this.hashColumns.put("ss_ref_no", getSsRefNo());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("anr_msg_sts_cd", getAnrMsgStsCd());
		this.hashColumns.put("mrn", getMrn());
		this.hashColumns.put("lloyd_cd", getLloydCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("berth_cd", getBerthCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("post", getPost());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pkg", getPkg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("art_no", getArtNo());
		this.hashColumns.put("cnee_name", getCneeName());
		this.hashColumns.put("sequence", getSequence());
		this.hashColumns.put("pre", getPre());
		this.hashColumns.put("ntfy_name", getNtfyName());
		this.hashColumns.put("wgt_u", getWgtU());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("shpr_name", "shprName");
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("prev_docno", "prevDocno");
		this.hashFields.put("ss_ref_no", "ssRefNo");
		this.hashFields.put("por", "por");
		this.hashFields.put("anr_msg_sts_cd", "anrMsgStsCd");
		this.hashFields.put("mrn", "mrn");
		this.hashFields.put("lloyd_cd", "lloydCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("berth_cd", "berthCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("del", "del");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("post", "post");
		this.hashFields.put("status", "status");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pkg", "pkg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("art_no", "artNo");
		this.hashFields.put("cnee_name", "cneeName");
		this.hashFields.put("sequence", "sequence");
		this.hashFields.put("pre", "pre");
		this.hashFields.put("ntfy_name", "ntfyName");
		this.hashFields.put("wgt_u", "wgtU");
		return this.hashFields;
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
	 * @return shprName
	 */
	public String getShprName() {
		return this.shprName;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr
	 */
	public String getCneeAddr() {
		return this.cneeAddr;
	}
	
	/**
	 * Column Info
	 * @return prevDocno
	 */
	public String getPrevDocno() {
		return this.prevDocno;
	}
	
	/**
	 * Column Info
	 * @return ssRefNo
	 */
	public String getSsRefNo() {
		return this.ssRefNo;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return anrMsgStsCd
	 */
	public String getAnrMsgStsCd() {
		return this.anrMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @return mrn
	 */
	public String getMrn() {
		return this.mrn;
	}
	
	/**
	 * Column Info
	 * @return lloydCd
	 */
	public String getLloydCd() {
		return this.lloydCd;
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
	 * @return berthCd
	 */
	public String getBerthCd() {
		return this.berthCd;
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
	 * @return shprAddr
	 */
	public String getShprAddr() {
		return this.shprAddr;
	}
	
	/**
	 * Column Info
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
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
	 * @return del
	 */
	public String getDel() {
		return this.del;
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
	 * @return ntfyAddr
	 */
	public String getNtfyAddr() {
		return this.ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @return post
	 */
	public String getPost() {
		return this.post;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
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
	 * @return pkg
	 */
	public String getPkg() {
		return this.pkg;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
	}
	
	/**
	 * Column Info
	 * @return artNo
	 */
	public String getArtNo() {
		return this.artNo;
	}
	
	/**
	 * Column Info
	 * @return cneeName
	 */
	public String getCneeName() {
		return this.cneeName;
	}
	
	/**
	 * Column Info
	 * @return sequence
	 */
	public String getSequence() {
		return this.sequence;
	}
	
	/**
	 * Column Info
	 * @return pre
	 */
	public String getPre() {
		return this.pre;
	}
	
	/**
	 * Column Info
	 * @return ntfyName
	 */
	public String getNtfyName() {
		return this.ntfyName;
	}
	
	/**
	 * Column Info
	 * @return wgtU
	 */
	public String getWgtU() {
		return this.wgtU;
	}

	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
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
	 * @param shprName
	 */
	public void setShprName(String shprName) {
		this.shprName = shprName;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr
	 */
	public void setCneeAddr(String cneeAddr) {
		this.cneeAddr = cneeAddr;
	}
	
	/**
	 * Column Info
	 * @param prevDocno
	 */
	public void setPrevDocno(String prevDocno) {
		this.prevDocno = prevDocno;
	}
	
	/**
	 * Column Info
	 * @param ssRefNo
	 */
	public void setSsRefNo(String ssRefNo) {
		this.ssRefNo = ssRefNo;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param anrMsgStsCd
	 */
	public void setAnrMsgStsCd(String anrMsgStsCd) {
		this.anrMsgStsCd = anrMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @param mrn
	 */
	public void setMrn(String mrn) {
		this.mrn = mrn;
	}
	
	/**
	 * Column Info
	 * @param lloydCd
	 */
	public void setLloydCd(String lloydCd) {
		this.lloydCd = lloydCd;
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
	 * @param berthCd
	 */
	public void setBerthCd(String berthCd) {
		this.berthCd = berthCd;
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
	 * @param shprAddr
	 */
	public void setShprAddr(String shprAddr) {
		this.shprAddr = shprAddr;
	}
	
	/**
	 * Column Info
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
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
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
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
	 * @param ntfyAddr
	 */
	public void setNtfyAddr(String ntfyAddr) {
		this.ntfyAddr = ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @param post
	 */
	public void setPost(String post) {
		this.post = post;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @param pkg
	 */
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
	}
	
	/**
	 * Column Info
	 * @param artNo
	 */
	public void setArtNo(String artNo) {
		this.artNo = artNo;
	}
	
	/**
	 * Column Info
	 * @param cneeName
	 */
	public void setCneeName(String cneeName) {
		this.cneeName = cneeName;
	}
	
	/**
	 * Column Info
	 * @param sequence
	 */
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	/**
	 * Column Info
	 * @param pre
	 */
	public void setPre(String pre) {
		this.pre = pre;
	}
	
	/**
	 * Column Info
	 * @param ntfyName
	 */
	public void setNtfyName(String ntfyName) {
		this.ntfyName = ntfyName;
	}
	
	/**
	 * Column Info
	 * @param wgtU
	 */
	public void setWgtU(String wgtU) {
		this.wgtU = wgtU;
	}
	
	/**
	 * Column Info
	 * @param wgtU
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setShprName(JSPUtil.getParameter(request, prefix + "shpr_name", ""));
		setCneeAddr(JSPUtil.getParameter(request, prefix + "cnee_addr", ""));
		setPrevDocno(JSPUtil.getParameter(request, prefix + "prev_docno", ""));
		setSsRefNo(JSPUtil.getParameter(request, prefix + "ss_ref_no", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setAnrMsgStsCd(JSPUtil.getParameter(request, prefix + "anr_msg_sts_cd", ""));
		setMrn(JSPUtil.getParameter(request, prefix + "mrn", ""));
		setLloydCd(JSPUtil.getParameter(request, prefix + "lloyd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBerthCd(JSPUtil.getParameter(request, prefix + "berth_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setShprAddr(JSPUtil.getParameter(request, prefix + "shpr_addr", ""));
		setWgt(JSPUtil.getParameter(request, prefix + "wgt", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setNtfyAddr(JSPUtil.getParameter(request, prefix + "ntfy_addr", ""));
		setPost(JSPUtil.getParameter(request, prefix + "post", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPkg(JSPUtil.getParameter(request, prefix + "pkg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRefSeq(JSPUtil.getParameter(request, prefix + "ref_seq", ""));
		setArtNo(JSPUtil.getParameter(request, prefix + "art_no", ""));
		setCneeName(JSPUtil.getParameter(request, prefix + "cnee_name", ""));
		setSequence(JSPUtil.getParameter(request, prefix + "sequence", ""));
		setPre(JSPUtil.getParameter(request, prefix + "pre", ""));
		setNtfyName(JSPUtil.getParameter(request, prefix + "ntfy_name", ""));
		setWgtU(JSPUtil.getParameter(request, prefix + "wgt_u", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsTransBlVO[]
	 */
	public AncsCstmsTransBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsTransBlVO[]
	 */
	public AncsCstmsTransBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsTransBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] shprName = (JSPUtil.getParameter(request, prefix	+ "shpr_name", length));
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr", length));
			String[] prevDocno = (JSPUtil.getParameter(request, prefix	+ "prev_docno", length));
			String[] ssRefNo = (JSPUtil.getParameter(request, prefix	+ "ss_ref_no", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] anrMsgStsCd = (JSPUtil.getParameter(request, prefix	+ "anr_msg_sts_cd", length));
			String[] mrn = (JSPUtil.getParameter(request, prefix	+ "mrn", length));
			String[] lloydCd = (JSPUtil.getParameter(request, prefix	+ "lloyd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] berthCd = (JSPUtil.getParameter(request, prefix	+ "berth_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] post = (JSPUtil.getParameter(request, prefix	+ "post", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] pkg = (JSPUtil.getParameter(request, prefix	+ "pkg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] refSeq = (JSPUtil.getParameter(request, prefix	+ "ref_seq", length));
			String[] artNo = (JSPUtil.getParameter(request, prefix	+ "art_no", length));
			String[] cneeName = (JSPUtil.getParameter(request, prefix	+ "cnee_name", length));
			String[] sequence = (JSPUtil.getParameter(request, prefix	+ "sequence", length));
			String[] pre = (JSPUtil.getParameter(request, prefix	+ "pre", length));
			String[] ntfyName = (JSPUtil.getParameter(request, prefix	+ "ntfy_name", length));
			String[] wgtU = (JSPUtil.getParameter(request, prefix	+ "wgt_u", length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsTransBlVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (shprName[i] != null)
					model.setShprName(shprName[i]);
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (prevDocno[i] != null)
					model.setPrevDocno(prevDocno[i]);
				if (ssRefNo[i] != null)
					model.setSsRefNo(ssRefNo[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (anrMsgStsCd[i] != null)
					model.setAnrMsgStsCd(anrMsgStsCd[i]);
				if (mrn[i] != null)
					model.setMrn(mrn[i]);
				if (lloydCd[i] != null)
					model.setLloydCd(lloydCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (berthCd[i] != null)
					model.setBerthCd(berthCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (post[i] != null)
					model.setPost(post[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (pkg[i] != null)
					model.setPkg(pkg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (artNo[i] != null)
					model.setArtNo(artNo[i]);
				if (cneeName[i] != null)
					model.setCneeName(cneeName[i]);
				if (sequence[i] != null)
					model.setSequence(sequence[i]);
				if (pre[i] != null)
					model.setPre(pre[i]);
				if (ntfyName[i] != null)
					model.setNtfyName(ntfyName[i]);
				if (wgtU[i] != null)
					model.setWgtU(wgtU[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsTransBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsTransBlVO[]
	 */
	public AncsCstmsTransBlVO[] getAncsCstmsTransBlVOs(){
		AncsCstmsTransBlVO[] vos = (AncsCstmsTransBlVO[])models.toArray(new AncsCstmsTransBlVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprName = this.shprName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevDocno = this.prevDocno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ssRefNo = this.ssRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrMsgStsCd = this.anrMsgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrn = this.mrn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydCd = this.lloydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.berthCd = this.berthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.post = this.post .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkg = this.pkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSeq = this.refSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.artNo = this.artNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeName = this.cneeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sequence = this.sequence .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre = this.pre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyName = this.ntfyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtU = this.wgtU .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
