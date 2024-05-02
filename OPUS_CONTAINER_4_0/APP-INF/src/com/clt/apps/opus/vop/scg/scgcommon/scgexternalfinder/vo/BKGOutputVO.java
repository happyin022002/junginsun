/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BKGOutputVO.java
*@FileTitle : BKGOutputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.01 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo;

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
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BKGOutputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BKGOutputVO> models = new ArrayList<BKGOutputVO>();
	
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String fCustNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BKGOutputVO() {}

	public BKGOutputVO(String ibflag, String pagerows, String splitFlg, String bkgNo, String bkgNoSplit, String blNo, String porCd, String polCd, String podCd, String delCd, String sCustNm, String fCustNm, String cCustNm) {
		this.splitFlg = splitFlg;
		this.porCd = porCd;
		this.sCustNm = sCustNm;
		this.bkgNoSplit = bkgNoSplit;
		this.cCustNm = cCustNm;
		this.delCd = delCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.fCustNm = fCustNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("f_cust_nm", getFCustNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("f_cust_nm", "fCustNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return fCustNm
	 */
	public String getFCustNm() {
		return this.fCustNm;
	}
	

	/**
	 * Column Info
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param fCustNm
	 */
	public void setFCustNm(String fCustNm) {
		this.fCustNm = fCustNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSplitFlg(JSPUtil.getParameter(request, "split_flg", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setSCustNm(JSPUtil.getParameter(request, "s_cust_nm", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setCCustNm(JSPUtil.getParameter(request, "c_cust_nm", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setFCustNm(JSPUtil.getParameter(request, "f_cust_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BKGOutputVO[]
	 */
	public BKGOutputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BKGOutputVO[]
	 */
	public BKGOutputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BKGOutputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg".trim(), length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd".trim(), length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm".trim(), length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split".trim(), length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] fCustNm = (JSPUtil.getParameter(request, prefix	+ "f_cust_nm".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BKGOutputVO();
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (fCustNm[i] != null)
					model.setFCustNm(fCustNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBKGOutputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BKGOutputVO[]
	 */
	public BKGOutputVO[] getBKGOutputVOs(){
		BKGOutputVO[] vos = (BKGOutputVO[])models.toArray(new BKGOutputVO[models.size()]);
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
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustNm = this.fCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
