/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvEdiRcvFileVO.java
*@FileTitle : InvEdiRcvFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.30
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.30 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvEdiRcvFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvEdiRcvFileVO> models = new ArrayList<InvEdiRcvFileVO>();
	
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String fileSavId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fileRmk = null;
	/* Column Info */
	private String invVndrSeq = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String savCfmFlg = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String invEdiRcvFileSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvEdiRcvFileVO() {}

	public InvEdiRcvFileVO(String ibflag, String pagerows, String invEdiRcvFileSeq, String fileNm, String fileSavId, String invNo, String invVndrSeq, String savCfmFlg, String fileRmk, String deltFlg) {
		this.invNo = invNo;
		this.fileSavId = fileSavId;
		this.ibflag = ibflag;
		this.fileRmk = fileRmk;
		this.invVndrSeq = invVndrSeq;
		this.deltFlg = deltFlg;
		this.savCfmFlg = savCfmFlg;
		this.fileNm = fileNm;
		this.invEdiRcvFileSeq = invEdiRcvFileSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("file_rmk", getFileRmk());
		this.hashColumns.put("inv_vndr_seq", getInvVndrSeq());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("sav_cfm_flg", getSavCfmFlg());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("inv_edi_rcv_file_seq", getInvEdiRcvFileSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("file_rmk", "fileRmk");
		this.hashFields.put("inv_vndr_seq", "invVndrSeq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("sav_cfm_flg", "savCfmFlg");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("inv_edi_rcv_file_seq", "invEdiRcvFileSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
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
	 * @return fileRmk
	 */
	public String getFileRmk() {
		return this.fileRmk;
	}
	
	/**
	 * Column Info
	 * @return invVndrSeq
	 */
	public String getInvVndrSeq() {
		return this.invVndrSeq;
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
	 * @return savCfmFlg
	 */
	public String getSavCfmFlg() {
		return this.savCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return fileNm
	 */
	public String getFileNm() {
		return this.fileNm;
	}
	
	/**
	 * Column Info
	 * @return invEdiRcvFileSeq
	 */
	public String getInvEdiRcvFileSeq() {
		return this.invEdiRcvFileSeq;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
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
	 * @param fileRmk
	 */
	public void setFileRmk(String fileRmk) {
		this.fileRmk = fileRmk;
	}
	
	/**
	 * Column Info
	 * @param invVndrSeq
	 */
	public void setInvVndrSeq(String invVndrSeq) {
		this.invVndrSeq = invVndrSeq;
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
	 * @param savCfmFlg
	 */
	public void setSavCfmFlg(String savCfmFlg) {
		this.savCfmFlg = savCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param fileNm
	 */
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}
	
	/**
	 * Column Info
	 * @param invEdiRcvFileSeq
	 */
	public void setInvEdiRcvFileSeq(String invEdiRcvFileSeq) {
		this.invEdiRcvFileSeq = invEdiRcvFileSeq;
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
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFileRmk(JSPUtil.getParameter(request, prefix + "file_rmk", ""));
		setInvVndrSeq(JSPUtil.getParameter(request, prefix + "inv_vndr_seq", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setSavCfmFlg(JSPUtil.getParameter(request, prefix + "sav_cfm_flg", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setInvEdiRcvFileSeq(JSPUtil.getParameter(request, prefix + "inv_edi_rcv_file_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvEdiRcvFileVO[]
	 */
	public InvEdiRcvFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvEdiRcvFileVO[]
	 */
	public InvEdiRcvFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvEdiRcvFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fileRmk = (JSPUtil.getParameter(request, prefix	+ "file_rmk", length));
			String[] invVndrSeq = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_seq", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] savCfmFlg = (JSPUtil.getParameter(request, prefix	+ "sav_cfm_flg", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] invEdiRcvFileSeq = (JSPUtil.getParameter(request, prefix	+ "inv_edi_rcv_file_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvEdiRcvFileVO();
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fileRmk[i] != null)
					model.setFileRmk(fileRmk[i]);
				if (invVndrSeq[i] != null)
					model.setInvVndrSeq(invVndrSeq[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (savCfmFlg[i] != null)
					model.setSavCfmFlg(savCfmFlg[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (invEdiRcvFileSeq[i] != null)
					model.setInvEdiRcvFileSeq(invEdiRcvFileSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvEdiRcvFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvEdiRcvFileVO[]
	 */
	public InvEdiRcvFileVO[] getInvEdiRcvFileVOs(){
		InvEdiRcvFileVO[] vos = (InvEdiRcvFileVO[])models.toArray(new InvEdiRcvFileVO[models.size()]);
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
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileRmk = this.fileRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVndrSeq = this.invVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savCfmFlg = this.savCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiRcvFileSeq = this.invEdiRcvFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
