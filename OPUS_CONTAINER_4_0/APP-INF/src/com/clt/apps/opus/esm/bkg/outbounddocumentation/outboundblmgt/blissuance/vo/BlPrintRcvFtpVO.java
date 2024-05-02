/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlPrintRcvFtpVO.java
*@FileTitle : BlPrintRcvFtpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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

public class BlPrintRcvFtpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlPrintRcvFtpVO> models = new ArrayList<BlPrintRcvFtpVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blGrpSeq = null;
	/* Column Info */
	private String ftpSvrUsrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blVwRtTpCd = null;
	/* Column Info */
	private String ftpFile = null;
	/* Column Info */
	private String rtyKnt = null;
	/* Column Info */
	private String rtyItvalNo = null;
	/* Column Info */
	private String ftpSvrPwd = null;
	/* Column Info */
	private String ftpSvrNm = null;
	/* Column Info */
	private String ftpSvrDirNm = null;
	/* Column Info */
	private String xptFileNm = null;
	/* Column Info */
	private String ftpDirCtnt = null;
	/* Column Info */
	private String blTpCd = null;
	
	private String errNtcFlg = null;
	private String scsNtcFlg = null;
	private String emlPdfAddr = null;
	private String ftpDirCtnt2 = null;
	private String ftpDirCtnt3 = null;
	private String ftpDirCtnt4 = null;
	private String ffrefno = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BlPrintRcvFtpVO() {}

	public BlPrintRcvFtpVO(String ibflag, String pagerows, String blGrpSeq, String blVwRtTpCd, String ftpSvrNm, String ftpSvrUsrNm, String ftpSvrPwd, String ftpSvrDirNm, String rtyKnt, String rtyItvalNo, String ftpFile, String xptFileNm, String ftpDirCtnt, String blTpCd, String errNtcFlg, String scsNtcFlg, String emlPdfAddr, String ftpDirCtnt2, String ftpDirCtnt3, String ftpDirCtnt4, String ffrefno) {
		this.pagerows = pagerows;
		this.blGrpSeq = blGrpSeq;
		this.ftpSvrUsrNm = ftpSvrUsrNm;
		this.ibflag = ibflag;
		this.blVwRtTpCd = blVwRtTpCd;
		this.ftpFile = ftpFile;
		this.rtyKnt = rtyKnt;
		this.rtyItvalNo = rtyItvalNo;
		this.ftpSvrPwd = ftpSvrPwd;
		this.ftpSvrNm = ftpSvrNm;
		this.ftpSvrDirNm = ftpSvrDirNm;
		this.xptFileNm = xptFileNm;
		this.ftpDirCtnt = ftpDirCtnt;
		this.blTpCd = blTpCd;
		this.errNtcFlg = errNtcFlg;
		this.scsNtcFlg = scsNtcFlg;
		this.emlPdfAddr = emlPdfAddr;
		this.ftpDirCtnt2 = ftpDirCtnt2;
		this.ftpDirCtnt3 = ftpDirCtnt3;
		this.ftpDirCtnt4 = ftpDirCtnt4;
		this.ffrefno = ffrefno;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_grp_seq", getBlGrpSeq());
		this.hashColumns.put("ftp_svr_usr_nm", getFtpSvrUsrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_vw_rt_tp_cd", getBlVwRtTpCd());
		this.hashColumns.put("ftp_file", getFtpFile());
		this.hashColumns.put("rty_knt", getRtyKnt());
		this.hashColumns.put("rty_itval_no", getRtyItvalNo());
		this.hashColumns.put("ftp_svr_pwd", getFtpSvrPwd());
		this.hashColumns.put("ftp_svr_nm", getFtpSvrNm());
		this.hashColumns.put("ftp_svr_dir_nm", getFtpSvrDirNm());
		this.hashColumns.put("xpt_file_nm", getXptFileNm());
		this.hashColumns.put("ftp_dir_ctnt", getFtpDirCtnt());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("err_ntc_flg", getErrNtcFlg());
		this.hashColumns.put("scs_ntc_flg", getScsNtcFlg());
		this.hashColumns.put("eml_pdf_addr", getEmlPdfAddr());
		this.hashColumns.put("ftp_dir_ctnt2", getFtpDirCtnt2());
		this.hashColumns.put("ftp_dir_ctnt2", getFtpDirCtnt3());
		this.hashColumns.put("ftp_dir_ctnt2", getFtpDirCtnt4());
		this.hashColumns.put("ffrefno", getFfrefno());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_grp_seq", "blGrpSeq");
		this.hashFields.put("ftp_svr_usr_nm", "ftpSvrUsrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_vw_rt_tp_cd", "blVwRtTpCd");
		this.hashFields.put("ftp_file", "ftpFile");
		this.hashFields.put("rty_knt", "rtyKnt");
		this.hashFields.put("rty_itval_no", "rtyItvalNo");
		this.hashFields.put("ftp_svr_pwd", "ftpSvrPwd");
		this.hashFields.put("ftp_svr_nm", "ftpSvrNm");
		this.hashFields.put("ftp_svr_dir_nm", "ftpSvrDirNm");
		this.hashFields.put("xpt_file_nm", "xptFileNm");
		this.hashFields.put("ftp_dir_ctnt", "ftpDirCtnt");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("err_ntc_flg", "errNtcFlg");
		this.hashFields.put("scs_ntc_flg", "scsNtcFlg");
		this.hashFields.put("eml_pdf_addr", "emlPdfAddr");
		this.hashFields.put("ftp_dir_ctnt2", "ftpDirCtnt2");
		this.hashFields.put("ftp_dir_ctnt3", "ftpDirCtnt3");
		this.hashFields.put("ftp_dir_ctnt4", "ftpDirCtnt4");
		this.hashFields.put("ffrefno", "ffrefno");
		return this.hashFields;
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
	 * @return blGrpSeq
	 */
	public String getBlGrpSeq() {
		return this.blGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return ftpSvrUsrNm
	 */
	public String getFtpSvrUsrNm() {
		return this.ftpSvrUsrNm;
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
	 * @return blVwRtTpCd
	 */
	public String getBlVwRtTpCd() {
		return this.blVwRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return ftpFile
	 */
	public String getFtpFile() {
		return this.ftpFile;
	}
	
	/**
	 * Column Info
	 * @return rtyKnt
	 */
	public String getRtyKnt() {
		return this.rtyKnt;
	}
	
	/**
	 * Column Info
	 * @return rtyItvalNo
	 */
	public String getRtyItvalNo() {
		return this.rtyItvalNo;
	}
	
	/**
	 * Column Info
	 * @return ftpSvrPwd
	 */
	public String getFtpSvrPwd() {
		return this.ftpSvrPwd;
	}
	
	/**
	 * Column Info
	 * @return ftpSvrNm
	 */
	public String getFtpSvrNm() {
		return this.ftpSvrNm;
	}
	
	/**
	 * Column Info
	 * @return ftpSvrDirNm
	 */
	public String getFtpSvrDirNm() {
		return this.ftpSvrDirNm;
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
	 * @param blGrpSeq
	 */
	public void setBlGrpSeq(String blGrpSeq) {
		this.blGrpSeq = blGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param ftpSvrUsrNm
	 */
	public void setFtpSvrUsrNm(String ftpSvrUsrNm) {
		this.ftpSvrUsrNm = ftpSvrUsrNm;
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
	 * @param blVwRtTpCd
	 */
	public void setBlVwRtTpCd(String blVwRtTpCd) {
		this.blVwRtTpCd = blVwRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param ftpFile
	 */
	public void setFtpFile(String ftpFile) {
		this.ftpFile = ftpFile;
	}
	
	/**
	 * Column Info
	 * @param rtyKnt
	 */
	public void setRtyKnt(String rtyKnt) {
		this.rtyKnt = rtyKnt;
	}
	
	/**
	 * Column Info
	 * @param rtyItvalNo
	 */
	public void setRtyItvalNo(String rtyItvalNo) {
		this.rtyItvalNo = rtyItvalNo;
	}
	
	/**
	 * Column Info
	 * @param ftpSvrPwd
	 */
	public void setFtpSvrPwd(String ftpSvrPwd) {
		this.ftpSvrPwd = ftpSvrPwd;
	}
	
	/**
	 * Column Info
	 * @param ftpSvrNm
	 */
	public void setFtpSvrNm(String ftpSvrNm) {
		this.ftpSvrNm = ftpSvrNm;
	}
	
	/**
	 * Column Info
	 * @param ftpSvrDirNm
	 */
	public void setFtpSvrDirNm(String ftpSvrDirNm) {
		this.ftpSvrDirNm = ftpSvrDirNm;
	}
	
	/**
	 * @return the xptFileNm
	 */
	public String getXptFileNm() {
		return xptFileNm;
	}

	/**
	 * @param xptFileNm the xptFileNm to set
	 */
	public void setXptFileNm(String xptFileNm) {
		this.xptFileNm = xptFileNm;
	}

	/**
	 * @return the ftpDirCtnt
	 */
	public String getFtpDirCtnt() {
		return ftpDirCtnt;
	}

	/**
	 * @param ftpDirCtnt the ftpDirCtnt to set
	 */
	public void setFtpDirCtnt(String ftpDirCtnt) {
		this.ftpDirCtnt = ftpDirCtnt;
	}
	
	/**
	 * @return the blTpCd
	 */
	public final String getBlTpCd() {
		return blTpCd;
	}

	/**
	 * @param blTpCd the blTpCd to set
	 */
	public final void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}

	/**
	 * @return the errNtcFlg
	 */
	public String getErrNtcFlg() {
		return errNtcFlg;
	}

	/**
	 * @param errNtcFlg the errNtcFlg to set
	 */
	public void setErrNtcFlg(String errNtcFlg) {
		this.errNtcFlg = errNtcFlg;
	}

	/**
	 * @return the scsNtcFlg
	 */
	public String getScsNtcFlg() {
		return scsNtcFlg;
	}

	/**
	 * @param scsNtcFlg the scsNtcFlg to set
	 */
	public void setScsNtcFlg(String scsNtcFlg) {
		this.scsNtcFlg = scsNtcFlg;
	}
	
	/**
	 * @return the emlPdfAddr
	 */
	public String getEmlPdfAddr() {
		return emlPdfAddr;
	}

	/**
	 * @param emlPdfAddr the emlPdfAddr to set
	 */
	public void setEmlPdfAddr(String emlPdfAddr) {
		this.emlPdfAddr = emlPdfAddr;
	}
	/**
	 * @return the ftpDirCtnt2
	 */
	public String getFtpDirCtnt2() {
		return ftpDirCtnt2;
	}

	/**
	 * @param ftpDirCtnt2 the ftpDirCtnt2 to set
	 */
	public void setFtpDirCtnt2(String ftpDirCtnt2) {
		this.ftpDirCtnt2 = ftpDirCtnt2;
	}

	/**
	 * @return the ftpDirCtnt3
	 */
	public String getFtpDirCtnt3() {
		return ftpDirCtnt3;
	}

	/**
	 * @param ftpDirCtnt3 the ftpDirCtnt3 to set
	 */
	public void setFtpDirCtnt3(String ftpDirCtnt3) {
		this.ftpDirCtnt3 = ftpDirCtnt3;
	}

	/**
	 * @return the ftpDirCtnt4
	 */
	public String getFtpDirCtnt4() {
		return ftpDirCtnt4;
	}

	/**
	 * @param ftpDirCtnt4 the ftpDirCtnt4 to set
	 */
	public void setFtpDirCtnt4(String ftpDirCtnt4) {
		this.ftpDirCtnt4 = ftpDirCtnt4;
	}

	/**
	 * @return the ffrefno
	 */
	public String getFfrefno() {
		return ffrefno;
	}

	/**
	 * @param ffrefno the ffrefno to set
	 */
	public void setFfrefno(String ffrefno) {
		this.ffrefno = ffrefno;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlGrpSeq(JSPUtil.getParameter(request, prefix + "bl_grp_seq", ""));
		setFtpSvrUsrNm(JSPUtil.getParameter(request, prefix + "ftp_svr_usr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlVwRtTpCd(JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd", ""));
		setFtpFile(JSPUtil.getParameter(request, prefix + "ftp_file", ""));
		setRtyKnt(JSPUtil.getParameter(request, prefix + "rty_knt", ""));
		setRtyItvalNo(JSPUtil.getParameter(request, prefix + "rty_itval_no", ""));
		setFtpSvrPwd(JSPUtil.getParameter(request, prefix + "ftp_svr_pwd", ""));
		setFtpSvrNm(JSPUtil.getParameter(request, prefix + "ftp_svr_nm", ""));
		setFtpSvrDirNm(JSPUtil.getParameter(request, prefix + "ftp_svr_dir_nm", ""));
		setXptFileNm(JSPUtil.getParameter(request, prefix + "xpt_file_nm", ""));
		setFtpDirCtnt(JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setErrNtcFlg(JSPUtil.getParameter(request, prefix + "err_ntc_flg"));
		setScsNtcFlg(JSPUtil.getParameter(request, prefix + "scs_ntc_flg"));
		setEmlPdfAddr(JSPUtil.getParameter(request, prefix + "eml_pdf_addr"));
		setFtpDirCtnt2(JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt2"));
		setFtpDirCtnt3(JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt3"));
		setFtpDirCtnt4(JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt4"));
		setFfrefno(JSPUtil.getParameter(request, prefix + "ffrefno"));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlPrintRcvFtpVO[]
	 */
	public BlPrintRcvFtpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlPrintRcvFtpVO[]
	 */
	public BlPrintRcvFtpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlPrintRcvFtpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blGrpSeq = (JSPUtil.getParameter(request, prefix	+ "bl_grp_seq", length));
			String[] ftpSvrUsrNm = (JSPUtil.getParameter(request, prefix	+ "ftp_svr_usr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blVwRtTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_vw_rt_tp_cd", length));
			String[] ftpFile = (JSPUtil.getParameter(request, prefix	+ "ftp_file", length));
			String[] rtyKnt = (JSPUtil.getParameter(request, prefix	+ "rty_knt", length));
			String[] rtyItvalNo = (JSPUtil.getParameter(request, prefix	+ "rty_itval_no", length));
			String[] ftpSvrPwd = (JSPUtil.getParameter(request, prefix	+ "ftp_svr_pwd", length));
			String[] ftpSvrNm = (JSPUtil.getParameter(request, prefix	+ "ftp_svr_nm", length));
			String[] ftpSvrDirNm = (JSPUtil.getParameter(request, prefix	+ "ftp_svr_dir_nm", length));
			String[] xptFileNm = (JSPUtil.getParameter(request, prefix	+ "xpt_file_nm", length));
			String[] ftpDirCtnt = (JSPUtil.getParameter(request, prefix	+ "ftp_dir_ctnt", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] errNtcFlg = (JSPUtil.getParameter(request, prefix + "err_ntc_flg", length));
			String[] scsNtcFlg = (JSPUtil.getParameter(request, prefix + "scs_ntc_flg", length));
			String[] emlPdfAddr = (JSPUtil.getParameter(request, prefix + "eml_pdf_addr", length));
			String[] ftpDirCtnt2 = (JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt2", length));
			String[] ftpDirCtnt3 = (JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt3", length));
			String[] ftpDirCtnt4 = (JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt4", length));
			String[] ffrefno = (JSPUtil.getParameter(request, prefix + "ffrefno", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlPrintRcvFtpVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blGrpSeq[i] != null)
					model.setBlGrpSeq(blGrpSeq[i]);
				if (ftpSvrUsrNm[i] != null)
					model.setFtpSvrUsrNm(ftpSvrUsrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blVwRtTpCd[i] != null)
					model.setBlVwRtTpCd(blVwRtTpCd[i]);
				if (ftpFile[i] != null)
					model.setFtpFile(ftpFile[i]);
				if (rtyKnt[i] != null)
					model.setRtyKnt(rtyKnt[i]);
				if (rtyItvalNo[i] != null)
					model.setRtyItvalNo(rtyItvalNo[i]);
				if (ftpSvrPwd[i] != null)
					model.setFtpSvrPwd(ftpSvrPwd[i]);
				if (ftpSvrNm[i] != null)
					model.setFtpSvrNm(ftpSvrNm[i]);
				if (ftpSvrDirNm[i] != null)
					model.setFtpSvrDirNm(ftpSvrDirNm[i]);
				if (xptFileNm[i] != null)
					model.setXptFileNm(xptFileNm[i]);
				if (ftpDirCtnt[i] != null)
					model.setFtpDirCtnt(ftpDirCtnt[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (errNtcFlg[i] != null)
					model.setErrNtcFlg(errNtcFlg[i]);
				if (scsNtcFlg[i] != null)
					model.setScsNtcFlg(scsNtcFlg[i]);
				if (emlPdfAddr[i] != null)
					model.setEmlPdfAddr(emlPdfAddr[i]);
				if (ftpDirCtnt2[i] != null)
					model.setFtpDirCtnt2(ftpDirCtnt2[i]);
				if (ftpDirCtnt3[i] != null)
					model.setFtpDirCtnt3(ftpDirCtnt3[i]);
				if (ftpDirCtnt4[i] != null)
					model.setFtpDirCtnt4(ftpDirCtnt4[i]);
				if (ffrefno[i] != null)
					model.setFfrefno(ffrefno[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlPrintRcvFtpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlPrintRcvFtpVO[]
	 */
	public BlPrintRcvFtpVO[] getBlPrintRcvFtpVOs(){
		BlPrintRcvFtpVO[] vos = (BlPrintRcvFtpVO[])models.toArray(new BlPrintRcvFtpVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blGrpSeq = this.blGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftpSvrUsrNm = this.ftpSvrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blVwRtTpCd = this.blVwRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftpFile = this.ftpFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtyKnt = this.rtyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtyItvalNo = this.rtyItvalNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftpSvrPwd = this.ftpSvrPwd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftpSvrNm = this.ftpSvrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftpSvrDirNm = this.ftpSvrDirNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptFileNm = this.xptFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftpDirCtnt = this.ftpDirCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errNtcFlg = this.errNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scsNtcFlg = this.scsNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlPdfAddr = this.emlPdfAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftpDirCtnt2 = this.ftpDirCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftpDirCtnt3 = this.ftpDirCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftpDirCtnt4 = this.ftpDirCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffrefno = this.ffrefno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
