/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchForCopyBlVO.java
*@FileTitle : searchForCopyBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.08.24 이일민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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
 * @author 이일민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlCopyInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlCopyInVO> models = new ArrayList<BlCopyInVO>();
	
	/* Column Info */
	private String copyBkgNo = null;
	private String bkgNo = null;
	private String custFlg = null;
	private String markFlg = null;
	private String descFlg = null;
	private String resultMsg = null;
	private String bkgStatus = null;
	private String bdrFlg = null;
	private String shprCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlCopyInVO() {}

	public BlCopyInVO(String copyBkgNo, String bkgNo, String custFlg, String markFlg, String descFlg, String resultMsg,
			String bkgStatus, String bdrFlg, String shprCd) {
		this.copyBkgNo = copyBkgNo;
		this.bkgNo = bkgNo;
		this.custFlg = custFlg;
		this.markFlg = markFlg;
		this.descFlg = descFlg;
		this.resultMsg = resultMsg;
		this.bkgStatus = bkgStatus;
		this.bdrFlg = bdrFlg;
		this.shprCd = shprCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("copy_bkg_no", getCopyBkgNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("custFlg", getCustFlg());
		this.hashColumns.put("markFlg", getMarkFlg());
		this.hashColumns.put("descFlg", getDescFlg());
		this.hashColumns.put("resultMsg", getResultMsg());
		this.hashColumns.put("bkgStatus", getBkgStatus());
		this.hashColumns.put("bdrFlg", getBdrFlg());
		this.hashColumns.put("shprCd", getShprCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("copy_bkg_no", "copyBkgNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("custFlg", "custFlg");
		this.hashFields.put("markFlg", "markFlg");
		this.hashFields.put("descFlg", "descFlg");
		this.hashFields.put("resultMsg", "resultMsg");
		this.hashFields.put("bkgStatus", "bkgStatus");
		this.hashFields.put("bdrFlg", "bdrFlg");
		this.hashFields.put("shprCd", "shprCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return copyBkgNo
	 */
	public String getCopyBkgNo() {
		return this.copyBkgNo;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	public String getCustFlg() {
		return custFlg;
	}

	public String getMarkFlg() {
		return markFlg;
	}

	public String getDescFlg() {
		return descFlg;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public String getBkgStatus() {
		return this.bkgStatus;
	}

	public String getBdrFlg() {
		return this.bdrFlg;
	}

	public String getShprCd() {
		return this.shprCd;
	}

	/**
	 * Column Info
	 * @param copyBkgNo
	 */
	public void setCopyBkgNo(String copyBkgNo) {
		this.copyBkgNo = copyBkgNo;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public void setCustFlg(String custFlg) {
		this.custFlg = custFlg;
	}

	public void setMarkFlg(String markFlg) {
		this.markFlg = markFlg;
	}

	public void setDescFlg(String descFlg) {
		this.descFlg = descFlg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public void setBkgStatus(String bkgStatus) {
		this.bkgStatus = bkgStatus;
	}

	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}

	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCopyBkgNo(JSPUtil.getParameter(request, "copy_bkg_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCustFlg(JSPUtil.getParameter(request, "custFlg", ""));
		setMarkFlg(JSPUtil.getParameter(request, "markFlg", ""));
		setDescFlg(JSPUtil.getParameter(request, "descFlg", ""));
		setResultMsg(JSPUtil.getParameter(request, "resultMsg", ""));
		setBkgStatus(JSPUtil.getParameter(request, "bkgStatus", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdrFlg", ""));
		setShprCd(JSPUtil.getParameter(request, "shprCd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlCopyInVO[]
	 */
	public BlCopyInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlCopyInVO[]
	 */
	public BlCopyInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlCopyInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] copyBkgNo = (JSPUtil.getParameter(request, prefix	+ "copy_bkg_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] custFlg = (JSPUtil.getParameter(request, prefix	+ "custFlg", length));
			String[] markFlg = (JSPUtil.getParameter(request, prefix	+ "markFlg", length));
			String[] descFlg = (JSPUtil.getParameter(request, prefix	+ "descFlg", length));
			String[] resultMsg = (JSPUtil.getParameter(request, prefix	+ "resultMsg", length));
			String[] bkgStatus = (JSPUtil.getParameter(request, prefix	+ "bkgStatus", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdrFlg", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shprCd", length));

			for (int i = 0; i < length; i++) {
				model = new BlCopyInVO();
				if (copyBkgNo[i] != null)
					model.setCopyBkgNo(copyBkgNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (custFlg[i] != null)
					model.setCustFlg(custFlg[i]);
				if (markFlg[i] != null)
					model.setMarkFlg(markFlg[i]);
				if (descFlg[i] != null)
					model.setDescFlg(descFlg[i]);
				if (resultMsg[i] != null)
					model.setResultMsg(resultMsg[i]);
				if (bkgStatus[i] != null)
					model.setBkgStatus(bkgStatus[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlCopyInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlCopyInVO[]
	 */
	public BlCopyInVO[] getBlCopyInVOs(){
		BlCopyInVO[] vos = (BlCopyInVO[])models.toArray(new BlCopyInVO[models.size()]);
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
		this.copyBkgNo = this.copyBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFlg = this.custFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.markFlg = this.markFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descFlg = this.descFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resultMsg = this.resultMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStatus = this.bkgStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}
