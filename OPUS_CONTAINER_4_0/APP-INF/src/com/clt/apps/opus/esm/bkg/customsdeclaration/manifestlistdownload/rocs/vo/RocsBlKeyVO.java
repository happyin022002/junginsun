/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsBlKeyVO.java
*@FileTitle : RocsBlKeyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.11 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsBlKeyVO extends BlKeyVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsBlKeyVO> models = new ArrayList<RocsBlKeyVO>();
	
	 
	/* Column Info */
	private String crnNumber = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String mtFlag = null; 
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String blNo = null; 
	
	/* Column Info */
	private String blNoTp = null; 
	
	/* Column Info */
	private String blTp = null; 
	
	/* Column Info */
	private String blNoChk = null; 
	/* Column Info */
	private String ofcCd = null; 
	/* Column Info */
	private String userId = null; 
	/* Column Info */
	private String difChr = null;
	
	/* Column Info */
	private String cntrNo = null;
	
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsBlKeyVO() {}

	public RocsBlKeyVO(String ibflag, String pagerows, String crnNumber, String bkgNo, 
			String bkgNoSplit,String mtFlag,String blNo,String blNoTp,String blNoChk,
			String blTp,String difChr,String cntrNo,String blTpCd,String ofcCd,String userId) {
		this.bkgNo = bkgNo;
		this.crnNumber = crnNumber;
		this.ibflag = ibflag;
		this.bkgNoSplit = bkgNoSplit;
		this.mtFlag = mtFlag;
		this.blTp = blTp;
		this.blNo = blNo;
		this.blNoTp = blNoTp;
		this.blNoChk = blNoChk;
		this.difChr = difChr;
		this.cntrNo = cntrNo;
		this.blTpCd = blTpCd;
		this.ofcCd = ofcCd;
		this.userId = userId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("frm_crn_number", getCrnNumber());		
		this.hashColumns.put("bkg_no_split", getBkgNOSplit());	
		this.hashColumns.put("mt_flag", getMtFlag());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("bl_tp", getBlTp());
		this.hashColumns.put("dif_chr", getDifChr());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("frm_crn_number", "crnNumber");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");		 
		this.hashFields.put("mt_flag", "mtFlag");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("bl_tp", "blTp");
		this.hashFields.put("dif_chr", "difChr");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		return this.hashFields;
	}
	
	public String getBlNo() {
		return this.blNo;
	}
	public String getDifChr() {
		return this.difChr;
	}
	public String getOfcCd() {
		return this.ofcCd;
	}
	public String getUserId() {
		return this.userId;
	}
	public String getCntrNo() {
		return this.cntrNo;
	}
	public String getBlTp() {
		return this.blTp;
	}
	
	public String getBlNoTp() {
		return this.blNoTp;
	}
	
	public String getBlNoChk() {
		return this.blNoChk;
	}
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
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
	 * @return bkgNoSplit
	 */
	public String getBkgNOSplit() {
		return this.bkgNoSplit;
	}
	
	public String getMtFlag() {
		return this.mtFlag;
	}
	
	/**
	 * Column Info
	 * @return crnNumber
	 */
	public String getCrnNumber() {
		return this.crnNumber;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	 
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	 
	
	public void setBlNO(String blNo) {
		this.blNo = blNo;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setDifChr(String difChr) {
		this.difChr = difChr;
	}
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
	}
	public void setBlTp(String blTp) {
		this.blTp = blTp;
	}
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
		//this.ibflag=true;
	}
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNO(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param crnNumber
	 */
	public void setCrnNumber(String crnNumber) {
		this.crnNumber = crnNumber;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	public void setMtFlag(String mtFlag) {
		this.mtFlag = mtFlag;
		//this.skdVoyNo=true;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
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
		setBkgNO(JSPUtil.getParameter(request, "bkg_no", ""));
		setCrnNumber(JSPUtil.getParameter(request, "frm_crn_number", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));		 
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));	
		setMtFlag(JSPUtil.getParameter(request, "mt_flag", ""));		
		setBlTp(JSPUtil.getParameter(request, "bl_tp", ""));	
		setBlNO(JSPUtil.getParameter(request, "bl_no", ""));		
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));		
		setDifChr(JSPUtil.getParameter(request, "dif_chr", ""));		
		setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));	
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocscrnVO[]
	 */
	public RocsBlKeyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocscrnVO[]
	 */
	public RocsBlKeyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsBlKeyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] crnNumber = (JSPUtil.getParameter(request, prefix	+ "frm_crn_number".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split".trim(), length));			
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));						
			String[] mtFlag = (JSPUtil.getParameter(request, prefix	+ "mt_flag".trim(), length));	
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));	
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp".trim(), length));	
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk".trim(), length));	
			String[] blTp = (JSPUtil.getParameter(request, prefix	+ "bl_tp".trim(), length));	
			String[] difChr = (JSPUtil.getParameter(request, prefix	+ "dif_chr".trim(), length));	
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id".trim(), length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new RocsBlKeyVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (bkgNo[i] != null)
					model.setBkgNO(bkgNo[i]);
				if (blNo[i] != null)
					model.setBlNO(blNo[i]);
				if (difChr[i] != null)
					model.setDifChr(difChr[i]);
				if (blTp[i] != null)
					model.setBlTp(blTp[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (crnNumber[i] != null)
					model.setCrnNumber(crnNumber[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);				 
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (mtFlag[i] != null)
					model.setMtFlag(mtFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsBlKeyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocscrnVO[]
	 */
	public RocsBlKeyVO[] getRocsBlKeyVOs(){
		RocsBlKeyVO[] vos = (RocsBlKeyVO[])models.toArray(new RocsBlKeyVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnNumber = this.crnNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtFlag = this.mtFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTp = this.blTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difChr = this.difChr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
