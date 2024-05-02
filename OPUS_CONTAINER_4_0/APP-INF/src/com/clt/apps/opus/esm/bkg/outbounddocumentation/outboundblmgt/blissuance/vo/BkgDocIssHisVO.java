/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgDocIssHisVO.java
*@FileTitle : BkgDocIssHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.28 이진서 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgDocIssHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgDocIssHisVO> models = new ArrayList<BkgDocIssHisVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rissRsn = null;
	/* Column Info */
	private String bkgEvntKndCd = null;
	/* Column Info */
	private String blRissRsnCd = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String rissFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String issCxlFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgDocIssHisVO() {}

	public BkgDocIssHisVO(String ibflag, String pagerows, String bkgNo, String hisSeq, String bkgEvntKndCd, String rissFlg, String blRissRsnCd, String rissRsn, String creUsrId, String issCxlFlg, String updUsrId) {
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.rissRsn = rissRsn;
		this.bkgEvntKndCd = bkgEvntKndCd;
		this.blRissRsnCd = blRissRsnCd;
		this.hisSeq = hisSeq;
		this.rissFlg = rissFlg;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
		this.issCxlFlg = issCxlFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("riss_rsn", getRissRsn());
		this.hashColumns.put("bkg_evnt_knd_cd", getBkgEvntKndCd());
		this.hashColumns.put("bl_riss_rsn_cd", getBlRissRsnCd());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("riss_flg", getRissFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("iss_cxl_flg", getIssCxlFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("riss_rsn", "rissRsn");
		this.hashFields.put("bkg_evnt_knd_cd", "bkgEvntKndCd");
		this.hashFields.put("bl_riss_rsn_cd", "blRissRsnCd");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("riss_flg", "rissFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("iss_cxl_flg", issCxlFlg);
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
	 * @return rissRsn
	 */
	public String getRissRsn() {
		return this.rissRsn;
	}
	
	/**
	 * Column Info
	 * @return bkgEvntKndCd
	 */
	public String getBkgEvntKndCd() {
		return this.bkgEvntKndCd;
	}
	
	/**
	 * Column Info
	 * @return blRissRsnCd
	 */
	public String getBlRissRsnCd() {
		return this.blRissRsnCd;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return rissFlg
	 */
	public String getRissFlg() {
		return this.rissFlg;
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
	 * @return issCxlFlg
	 */
	public String getIssCxlFlg() {
		return this.issCxlFlg;
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
	 * @param rissRsn
	 */
	public void setRissRsn(String rissRsn) {
		this.rissRsn = rissRsn;
	}
	
	/**
	 * Column Info
	 * @param bkgEvntKndCd
	 */
	public void setBkgEvntKndCd(String bkgEvntKndCd) {
		this.bkgEvntKndCd = bkgEvntKndCd;
	}
	
	/**
	 * Column Info
	 * @param blRissRsnCd
	 */
	public void setBlRissRsnCd(String blRissRsnCd) {
		this.blRissRsnCd = blRissRsnCd;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param rissFlg
	 */
	public void setRissFlg(String rissFlg) {
		this.rissFlg = rissFlg;
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
	 * @param issCxlFlg
	 */
	public void setIssCxlFlg(String issCxlFlg) {
		this.issCxlFlg = issCxlFlg;
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
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRissRsn(JSPUtil.getParameter(request, "riss_rsn", ""));
		setBkgEvntKndCd(JSPUtil.getParameter(request, "bkg_evnt_knd_cd", ""));
		setBlRissRsnCd(JSPUtil.getParameter(request, "bl_riss_rsn_cd", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setRissFlg(JSPUtil.getParameter(request, "riss_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setIssCxlFlg(JSPUtil.getParameter(request, "iss_cxl_flg",""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgDocIssHisVO[]
	 */
	public BkgDocIssHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgDocIssHisVO[]
	 */
	public BkgDocIssHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgDocIssHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rissRsn = (JSPUtil.getParameter(request, prefix	+ "riss_rsn", length));
			String[] bkgEvntKndCd = (JSPUtil.getParameter(request, prefix	+ "bkg_evnt_knd_cd", length));
			String[] blRissRsnCd = (JSPUtil.getParameter(request, prefix	+ "bl_riss_rsn_cd", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] rissFlg = (JSPUtil.getParameter(request, prefix	+ "riss_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] issCxlFlg = (JSPUtil.getParameter(request, prefix+"iss_cxl_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgDocIssHisVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rissRsn[i] != null)
					model.setRissRsn(rissRsn[i]);
				if (bkgEvntKndCd[i] != null)
					model.setBkgEvntKndCd(bkgEvntKndCd[i]);
				if (blRissRsnCd[i] != null)
					model.setBlRissRsnCd(blRissRsnCd[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (rissFlg[i] != null)
					model.setRissFlg(rissFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if(issCxlFlg[i] !=null){
					model.setIssCxlFlg(issCxlFlg[i]);
				}
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgDocIssHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgDocIssHisVO[]
	 */
	public BkgDocIssHisVO[] getBkgDocIssHisVOs(){
		BkgDocIssHisVO[] vos = (BkgDocIssHisVO[])models.toArray(new BkgDocIssHisVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rissRsn = this.rissRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgEvntKndCd = this.bkgEvntKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRissRsnCd = this.blRissRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rissFlg = this.rissFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCxlFlg=this.issCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
