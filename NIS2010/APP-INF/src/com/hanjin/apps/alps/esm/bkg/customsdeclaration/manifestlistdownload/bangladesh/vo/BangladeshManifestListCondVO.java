/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BangladeshManifestListCondVO.java
*@FileTitle : BangladeshManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BangladeshManifestListCondVO extends ManifestListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<BangladeshManifestListCondVO> models = new ArrayList<BangladeshManifestListCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podYd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podCode = null;
	/* Column Info */
	private String polYd = null;
	/* Column Info */
	private String bkgCgoTpCode = null;
	/* Column Info */
	private String polCode = null;
	/* Column Info */
	private String ioFlag = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String dataFlag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BangladeshManifestListCondVO() {}

	public BangladeshManifestListCondVO(String ibflag, String pagerows, String vvd, String polCode, String polYd, String podCode, String podYd, String bkgCgoTpCode, String blNo, String ioFlag, String dataFlag) {
		this.vvd = vvd;
		this.podYd = podYd;
		this.ibflag = ibflag;
		this.podCode = podCode;
		this.polYd = polYd;
		this.bkgCgoTpCode = bkgCgoTpCode;
		this.polCode = polCode;
		this.ioFlag = ioFlag;
		this.blNo = blNo;
		this.dataFlag = dataFlag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_yd", getPodYd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_code", getPodCode());
		this.hashColumns.put("pol_yd", getPolYd());
		this.hashColumns.put("bkg_cgo_tp_code", getBkgCgoTpCode());
		this.hashColumns.put("pol_code", getPolCode());
		this.hashColumns.put("io_flag", getIoFlag());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("data_flag", getDataFlag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_yd", "podYd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_code", "podCode");
		this.hashFields.put("pol_yd", "polYd");
		this.hashFields.put("bkg_cgo_tp_code", "bkgCgoTpCode");
		this.hashFields.put("pol_code", "polCode");
		this.hashFields.put("io_flag", "ioFlag");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("data_flag", "dataFlag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return podYd
	 */
	public String getPodYd() {
		return this.podYd;
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
	 * @return podCode
	 */
	public String getPodCode() {
		return this.podCode;
	}
	
	/**
	 * Column Info
	 * @return polYd
	 */
	public String getPolYd() {
		return this.polYd;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCode
	 */
	public String getBkgCgoTpCode() {
		return this.bkgCgoTpCode;
	}
	
	/**
	 * Column Info
	 * @return polCode
	 */
	public String getPolCode() {
		return this.polCode;
	}
	
	/**
	 * Column Info
	 * @return ioFlag
	 */
	public String getIoFlag() {
		return this.ioFlag;
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
	 * @return dataFlag
	 */
	public String getDataFlag() {
		return this.dataFlag;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param podYd
	 */
	public void setPodYd(String podYd) {
		this.podYd = podYd;
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
	 * @param podCode
	 */
	public void setPodCode(String podCode) {
		this.podCode = podCode;
	}
	
	/**
	 * Column Info
	 * @param polYd
	 */
	public void setPolYd(String polYd) {
		this.polYd = polYd;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCode
	 */
	public void setBkgCgoTpCode(String bkgCgoTpCode) {
		this.bkgCgoTpCode = bkgCgoTpCode;
	}
	
	/**
	 * Column Info
	 * @param polCode
	 */
	public void setPolCode(String polCode) {
		this.polCode = polCode;
	}
	
	/**
	 * Column Info
	 * @param ioFlag
	 */
	public void setIoFlag(String ioFlag) {
		this.ioFlag = ioFlag;
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
	 * @param dataFlag
	 */
	public void setDataFlag(String dataFlag) {
		this.dataFlag = dataFlag;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodYd(JSPUtil.getParameter(request, "pod_yd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPodCode(JSPUtil.getParameter(request, "pod_code", ""));
		setPolYd(JSPUtil.getParameter(request, "pol_yd", ""));
		setBkgCgoTpCode(JSPUtil.getParameter(request, "bkg_cgo_tp_code", ""));
		setPolCode(JSPUtil.getParameter(request, "pol_code", ""));
		setIoFlag(JSPUtil.getParameter(request, "io_flag", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setDataFlag(JSPUtil.getParameter(request, "data_flag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BangladeshManifestListCondVO[]
	 */
	public BangladeshManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BangladeshManifestListCondVO[]
	 */
	public BangladeshManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BangladeshManifestListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podYd = (JSPUtil.getParameter(request, prefix	+ "pod_yd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podCode = (JSPUtil.getParameter(request, prefix	+ "pod_code", length));
			String[] polYd = (JSPUtil.getParameter(request, prefix	+ "pol_yd", length));
			String[] bkgCgoTpCode = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_code", length));
			String[] polCode = (JSPUtil.getParameter(request, prefix	+ "pol_code", length));
			String[] ioFlag = (JSPUtil.getParameter(request, prefix	+ "io_flag", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] dataFlag = (JSPUtil.getParameter(request, prefix	+ "data_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BangladeshManifestListCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podYd[i] != null)
					model.setPodYd(podYd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podCode[i] != null)
					model.setPodCode(podCode[i]);
				if (polYd[i] != null)
					model.setPolYd(polYd[i]);
				if (bkgCgoTpCode[i] != null)
					model.setBkgCgoTpCode(bkgCgoTpCode[i]);
				if (polCode[i] != null)
					model.setPolCode(polCode[i]);
				if (ioFlag[i] != null)
					model.setIoFlag(ioFlag[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (dataFlag[i] != null)
					model.setDataFlag(dataFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBangladeshManifestListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BangladeshManifestListCondVO[]
	 */
	public BangladeshManifestListCondVO[] getBangladeshManifestListCondVOs(){
		BangladeshManifestListCondVO[] vos = (BangladeshManifestListCondVO[])models.toArray(new BangladeshManifestListCondVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYd = this.podYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCode = this.podCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYd = this.polYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCode = this.bkgCgoTpCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCode = this.polCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioFlag = this.ioFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataFlag = this.dataFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
