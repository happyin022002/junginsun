/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : usCustSvcInstrsVO.java
*@FileTitle : usCustSvcInstrsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

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

public class UsCustSvcInstrsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsCustSvcInstrsVO> models = new ArrayList<UsCustSvcInstrsVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String updLoclGdt = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String instrRmk = null;
	/* Column Info */
	private String instrRmkSeq = null;
	/* Page Number */
	private String pagerows = null;
	
	private String ediEvntOfcCd = null;
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsCustSvcInstrsVO() {}

	public UsCustSvcInstrsVO(String ibflag, String pagerows, String bkgNo, String instrRmkSeq, String instrRmk, String creUsrId, String updUsrId, String usrNm, String updLoclDt, String updLoclGdt, String ediEvntOfcCd) {
		this.creUsrId = creUsrId;
		this.ediEvntOfcCd = ediEvntOfcCd;
		this.updUsrId = updUsrId;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.usrNm = usrNm;
		this.updLoclGdt = updLoclGdt;
		this.updLoclDt = updLoclDt;
		this.instrRmk = instrRmk;
		this.instrRmkSeq = instrRmkSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("edi_evnt_ofc_cd", getEdiEvntOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("upd_locl_gdt", getUpdLoclGdt());
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());
		this.hashColumns.put("instr_rmk", getInstrRmk());
		this.hashColumns.put("instr_rmk_seq", getInstrRmkSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("edi_evnt_ofc_cd", "ediEvntOfcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("upd_locl_gdt", "updLoclGdt");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("instr_rmk", "instrRmk");
		this.hashFields.put("instr_rmk_seq", "instrRmkSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return ediEvntOfcCd
	 */
	public String getEdiEvntOfcCd() {
		return this.ediEvntOfcCd;
	}
	
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return updLoclGdt
	 */
	public String getUpdLoclGdt() {
		return this.updLoclGdt;
	}
	
	/**
	 * Column Info
	 * @return updLoclDt
	 */
	public String getUpdLoclDt() {
		return this.updLoclDt;
	}
	
	/**
	 * Column Info
	 * @return instrRmk
	 */
	public String getInstrRmk() {
		return this.instrRmk;
	}
	
	/**
	 * Column Info
	 * @return instrRmkSeq
	 */
	public String getInstrRmkSeq() {
		return this.instrRmkSeq;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * @param ediEvntOfcCd
	 */
	public void setEdiEvntOfcCd(String ediEvntOfcCd) {
		this.ediEvntOfcCd = ediEvntOfcCd;
	}
	
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param updLoclGdt
	 */
	public void setUpdLoclGdt(String updLoclGdt) {
		this.updLoclGdt = updLoclGdt;
	}
	
	/**
	 * Column Info
	 * @param updLoclDt
	 */
	public void setUpdLoclDt(String updLoclDt) {
		this.updLoclDt = updLoclDt;
	}
	
	/**
	 * Column Info
	 * @param instrRmk
	 */
	public void setInstrRmk(String instrRmk) {
		this.instrRmk = instrRmk;
	}
	
	/**
	 * Column Info
	 * @param instrRmkSeq
	 */
	public void setInstrRmkSeq(String instrRmkSeq) {
		this.instrRmkSeq = instrRmkSeq;
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
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEdiEvntOfcCd(JSPUtil.getParameter(request, prefix + "edi_evnt_ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setUpdLoclGdt(JSPUtil.getParameter(request, prefix + "upd_locl_gdt", ""));
		setUpdLoclDt(JSPUtil.getParameter(request, prefix + "upd_locl_dt", ""));
		setInstrRmk(JSPUtil.getParameter(request, prefix + "instr_rmk", ""));
		setInstrRmkSeq(JSPUtil.getParameter(request, prefix + "instr_rmk_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return usCustSvcInstrsVO[]
	 */
	public UsCustSvcInstrsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return usCustSvcInstrsVO[]
	 */
	public UsCustSvcInstrsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsCustSvcInstrsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ediEvntOfcCd = (JSPUtil.getParameter(request, prefix	+ "edi_evnt_ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] updLoclGdt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_gdt", length));
			String[] updLoclDt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_dt", length));
			String[] instrRmk = (JSPUtil.getParameter(request, prefix	+ "instr_rmk", length));
			String[] instrRmkSeq = (JSPUtil.getParameter(request, prefix	+ "instr_rmk_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsCustSvcInstrsVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ediEvntOfcCd[i] != null)
					model.setEdiEvntOfcCd(ediEvntOfcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (updLoclGdt[i] != null)
					model.setUpdLoclGdt(updLoclGdt[i]);
				if (updLoclDt[i] != null)
					model.setUpdLoclDt(updLoclDt[i]);
				if (instrRmk[i] != null)
					model.setInstrRmk(instrRmk[i]);
				if (instrRmkSeq[i] != null)
					model.setInstrRmkSeq(instrRmkSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getusCustSvcInstrsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return usCustSvcInstrsVO[]
	 */
	public UsCustSvcInstrsVO[] getusCustSvcInstrsVOs(){
		UsCustSvcInstrsVO[] vos = (UsCustSvcInstrsVO[])models.toArray(new UsCustSvcInstrsVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediEvntOfcCd = this.ediEvntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclGdt = this.updLoclGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt = this.updLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instrRmk = this.instrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instrRmkSeq = this.instrRmkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
