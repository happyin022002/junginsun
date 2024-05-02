/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AvcNoteSetUpInfoVO.java
*@FileTitle : AvcNoteSetUpInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.07.01 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AvcNoteSetUpInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AvcNoteSetUpInfoVO> models = new ArrayList<AvcNoteSetUpInfoVO>();

	/* Column Info */
	private String pMibNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ibdLocGdsDesc = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String faxOfcCd = null;
	/* Column Info */
	private String avcNoteTpId = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AvcNoteSetUpInfoVO() {}

	public AvcNoteSetUpInfoVO(String ibflag, String pagerows, String avcNoteTpId, String blNo, String pMibNo, String ibdLocGdsDesc, String faxOfcCd, String custSeq, String custNm, String cntrNo) {
		this.pMibNo = pMibNo;
		this.ibflag = ibflag;
		this.ibdLocGdsDesc = ibdLocGdsDesc;
		this.custNm = custNm;
		this.cntrNo = cntrNo;
		this.faxOfcCd = faxOfcCd;
		this.avcNoteTpId = avcNoteTpId;
		this.custSeq = custSeq;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_mib_no", getPMibNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ibd_loc_gds_desc", getIbdLocGdsDesc());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("fax_ofc_cd", getFaxOfcCd());
		this.hashColumns.put("avc_note_tp_id", getAvcNoteTpId());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_mib_no", "pMibNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ibd_loc_gds_desc", "ibdLocGdsDesc");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("fax_ofc_cd", "faxOfcCd");
		this.hashFields.put("avc_note_tp_id", "avcNoteTpId");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pMibNo
	 */
	public String getPMibNo() {
		return this.pMibNo;
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
	 * @return ibdLocGdsDesc
	 */
	public String getIbdLocGdsDesc() {
		return this.ibdLocGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return faxOfcCd
	 */
	public String getFaxOfcCd() {
		return this.faxOfcCd;
	}
	
	/**
	 * Column Info
	 * @return avcNoteTpId
	 */
	public String getAvcNoteTpId() {
		return this.avcNoteTpId;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @param pMibNo
	 */
	public void setPMibNo(String pMibNo) {
		this.pMibNo = pMibNo;
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
	 * @param ibdLocGdsDesc
	 */
	public void setIbdLocGdsDesc(String ibdLocGdsDesc) {
		this.ibdLocGdsDesc = ibdLocGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param faxOfcCd
	 */
	public void setFaxOfcCd(String faxOfcCd) {
		this.faxOfcCd = faxOfcCd;
	}
	
	/**
	 * Column Info
	 * @param avcNoteTpId
	 */
	public void setAvcNoteTpId(String avcNoteTpId) {
		this.avcNoteTpId = avcNoteTpId;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
		setPMibNo(JSPUtil.getParameter(request, "p_mib_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIbdLocGdsDesc(JSPUtil.getParameter(request, "ibd_loc_gds_desc", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setFaxOfcCd(JSPUtil.getParameter(request, "fax_ofc_cd", ""));
		setAvcNoteTpId(JSPUtil.getParameter(request, "avc_note_tp_id", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AvcNoteSetUpInfoVO[]
	 */
	public AvcNoteSetUpInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AvcNoteSetUpInfoVO[]
	 */
	public AvcNoteSetUpInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AvcNoteSetUpInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pMibNo = (JSPUtil.getParameter(request, prefix	+ "p_mib_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ibdLocGdsDesc = (JSPUtil.getParameter(request, prefix	+ "ibd_loc_gds_desc", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] faxOfcCd = (JSPUtil.getParameter(request, prefix	+ "fax_ofc_cd", length));
			String[] avcNoteTpId = (JSPUtil.getParameter(request, prefix	+ "avc_note_tp_id", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AvcNoteSetUpInfoVO();
				if (pMibNo[i] != null)
					model.setPMibNo(pMibNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ibdLocGdsDesc[i] != null)
					model.setIbdLocGdsDesc(ibdLocGdsDesc[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (faxOfcCd[i] != null)
					model.setFaxOfcCd(faxOfcCd[i]);
				if (avcNoteTpId[i] != null)
					model.setAvcNoteTpId(avcNoteTpId[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAvcNoteSetUpInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AvcNoteSetUpInfoVO[]
	 */
	public AvcNoteSetUpInfoVO[] getAvcNoteSetUpInfoVOs(){
		AvcNoteSetUpInfoVO[] vos = (AvcNoteSetUpInfoVO[])models.toArray(new AvcNoteSetUpInfoVO[models.size()]);
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
		this.pMibNo = this.pMibNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdLocGdsDesc = this.ibdLocGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxOfcCd = this.faxOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avcNoteTpId = this.avcNoteTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
