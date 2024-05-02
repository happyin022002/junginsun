/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsBlNtfyVO.java
*@FileTitle : AncsCstmsBlNtfyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.05 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsCstmsBlNtfyVO extends BlDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsBlNtfyVO> models = new ArrayList<AncsCstmsBlNtfyVO>();
	
	/* Column Info */
	private String svcRqstNo = null;
	/* Column Info */
	private String shprName = null;
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String anrMsgStsCd = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cstmsPrcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ntfyEml = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String cneeName = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String blLastEdi = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String ntfyName = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsCstmsBlNtfyVO() {}

	public AncsCstmsBlNtfyVO(String ibflag, String pagerows, String blNo, String vvdSeq, String vvd, String svcRqstNo, 
			String cstmsPrcCd, String anrMsgStsCd, String blLastEdi, String faxNo, String ntfyEml, String shprAddr, 
			String shprName, String cneeAddr, String cneeName, String ntfyNm, String ntfyAddr, String ntfyName) {
		this.svcRqstNo = svcRqstNo;
		this.shprName = shprName;
		this.cneeAddr = cneeAddr;
		this.anrMsgStsCd = anrMsgStsCd;
		this.ntfyNm = ntfyNm;
		this.blNo = blNo;
		this.cstmsPrcCd = cstmsPrcCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.ntfyEml = ntfyEml;
		this.shprAddr = shprAddr;
		this.cneeName = cneeName;
		this.faxNo = faxNo;
		this.blLastEdi = blLastEdi;
		this.vvdSeq = vvdSeq;
		this.ntfyAddr = ntfyAddr;
		this.ntfyName = ntfyName;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_rqst_no", getSvcRqstNo());
		this.hashColumns.put("shpr_name", getShprName());
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("anr_msg_sts_cd", getAnrMsgStsCd());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cstms_prc_cd", getCstmsPrcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ntfy_eml", getNtfyEml());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("cnee_name", getCneeName());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("bl_last_edi", getBlLastEdi());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("ntfy_name", getNtfyName());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_rqst_no", "svcRqstNo");
		this.hashFields.put("shpr_name", "shprName");
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("anr_msg_sts_cd", "anrMsgStsCd");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cstms_prc_cd", "cstmsPrcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ntfy_eml", "ntfyEml");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("cnee_name", "cneeName");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("bl_last_edi", "blLastEdi");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("ntfy_name", "ntfyName");
		return this.hashFields;
	}
	
	
	public String getNtfyName() {
		return ntfyName;
	}

	public void setNtfyName(String ntfyName) {
		this.ntfyName = ntfyName;
	}

	/**
	 * Column Info
	 * @return svcRqstNo
	 */
	public String getSvcRqstNo() {
		return this.svcRqstNo;
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
	 * @return anrMsgStsCd
	 */
	public String getAnrMsgStsCd() {
		return this.anrMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsPrcCd
	 */
	public String getCstmsPrcCd() {
		return this.cstmsPrcCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return ntfyEml
	 */
	public String getNtfyEml() {
		return this.ntfyEml;
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
	 * @return cneeName
	 */
	public String getCneeName() {
		return this.cneeName;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return blLastEdi
	 */
	public String getBlLastEdi() {
		return this.blLastEdi;
	}
	
	/**
	 * Column Info
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
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
	 * @param svcRqstNo
	 */
	public void setSvcRqstNo(String svcRqstNo) {
		this.svcRqstNo = svcRqstNo;
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
	 * @param anrMsgStsCd
	 */
	public void setAnrMsgStsCd(String anrMsgStsCd) {
		this.anrMsgStsCd = anrMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsPrcCd
	 */
	public void setCstmsPrcCd(String cstmsPrcCd) {
		this.cstmsPrcCd = cstmsPrcCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param ntfyEml
	 */
	public void setNtfyEml(String ntfyEml) {
		this.ntfyEml = ntfyEml;
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
	 * @param cneeName
	 */
	public void setCneeName(String cneeName) {
		this.cneeName = cneeName;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param blLastEdi
	 */
	public void setBlLastEdi(String blLastEdi) {
		this.blLastEdi = blLastEdi;
	}
	
	/**
	 * Column Info
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr
	 */
	public void setNtfyAddr(String ntfyAddr) {
		this.ntfyAddr = ntfyAddr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSvcRqstNo(JSPUtil.getParameter(request, "svc_rqst_no", ""));
		setShprName(JSPUtil.getParameter(request, "shpr_name", ""));
		setCneeAddr(JSPUtil.getParameter(request, "cnee_addr", ""));
		setAnrMsgStsCd(JSPUtil.getParameter(request, "anr_msg_sts_cd", ""));
		setNtfyNm(JSPUtil.getParameter(request, "ntfy_nm", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCstmsPrcCd(JSPUtil.getParameter(request, "cstms_prc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNtfyEml(JSPUtil.getParameter(request, "ntfy_eml", ""));
		setShprAddr(JSPUtil.getParameter(request, "shpr_addr", ""));
		setCneeName(JSPUtil.getParameter(request, "cnee_name", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setBlLastEdi(JSPUtil.getParameter(request, "bl_last_edi", ""));
		setVvdSeq(JSPUtil.getParameter(request, "vvd_seq", ""));
		setNtfyAddr(JSPUtil.getParameter(request, "ntfy_addr", ""));
		setNtfyName(JSPUtil.getParameter(request, "ntfy_name", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsBlNtVO[]
	 */
	public AncsCstmsBlNtfyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsBlNtVO[]
	 */
	public AncsCstmsBlNtfyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsBlNtfyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svcRqstNo = (JSPUtil.getParameter(request, prefix	+ "svc_rqst_no".trim(), length));
			String[] shprName = (JSPUtil.getParameter(request, prefix	+ "shpr_name".trim(), length));
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr".trim(), length));
			String[] anrMsgStsCd = (JSPUtil.getParameter(request, prefix	+ "anr_msg_sts_cd".trim(), length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] cstmsPrcCd = (JSPUtil.getParameter(request, prefix	+ "cstms_prc_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ntfyEml = (JSPUtil.getParameter(request, prefix	+ "ntfy_eml".trim(), length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr".trim(), length));
			String[] cneeName = (JSPUtil.getParameter(request, prefix	+ "cnee_name".trim(), length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no".trim(), length));
			String[] blLastEdi = (JSPUtil.getParameter(request, prefix	+ "bl_last_edi".trim(), length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq".trim(), length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr".trim(), length));
			String[] ntfyName = (JSPUtil.getParameter(request, prefix	+ "ntfy_name".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsBlNtfyVO();
				if (svcRqstNo[i] != null)
					model.setSvcRqstNo(svcRqstNo[i]);
				if (shprName[i] != null)
					model.setShprName(shprName[i]);
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (anrMsgStsCd[i] != null)
					model.setAnrMsgStsCd(anrMsgStsCd[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cstmsPrcCd[i] != null)
					model.setCstmsPrcCd(cstmsPrcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ntfyEml[i] != null)
					model.setNtfyEml(ntfyEml[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (cneeName[i] != null)
					model.setCneeName(cneeName[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (blLastEdi[i] != null)
					model.setBlLastEdi(blLastEdi[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (ntfyName[i] != null)
					model.setNtfyName(ntfyName[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsBlNtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsBlNtVO[]
	 */
	public AncsCstmsBlNtfyVO[] getAncsCstmsBlNtVOs(){
		AncsCstmsBlNtfyVO[] vos = (AncsCstmsBlNtfyVO[])models.toArray(new AncsCstmsBlNtfyVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.svcRqstNo = this.svcRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprName = this.shprName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrMsgStsCd = this.anrMsgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPrcCd = this.cstmsPrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyEml = this.ntfyEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeName = this.cneeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blLastEdi = this.blLastEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyName = this.ntfyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
