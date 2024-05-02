/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeRemarkVO.java
*@FileTitle : ChargeRemarkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.02 이진서 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeRemarkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeRemarkVO> models = new ArrayList<ChargeRemarkVO>();
	
	/* Column Info */
	private String mstCvrdBlNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String blCvrdTpCd = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String thirdPartyFreight = null;
	/* Column Info */
	private String docInterRmk = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeRemarkVO() {}

	public ChargeRemarkVO(String ibflag, String pagerows, String bkgNo, String blCvrdTpCd, String interRmk, String diffRmk, String mstCvrdBlNo, String thirdPartyFreight, String docInterRmk) {
		this.mstCvrdBlNo = mstCvrdBlNo;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.blCvrdTpCd = blCvrdTpCd;
		this.interRmk = interRmk;
		this.thirdPartyFreight = thirdPartyFreight;
		this.docInterRmk = docInterRmk;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mst_cvrd_bl_no", getMstCvrdBlNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("bl_cvrd_tp_cd", getBlCvrdTpCd());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("third_party_freight", getThirdPartyFreight());
		this.hashColumns.put("doc_inter_rmk", getDocInterRmk());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mst_cvrd_bl_no", "mstCvrdBlNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("bl_cvrd_tp_cd", "blCvrdTpCd");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("third_party_freight", "thirdPartyFreight");
		this.hashFields.put("doc_inter_rmk", "docInterRmk");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mstCvrdBlNo
	 */
	public String getMstCvrdBlNo() {
		return this.mstCvrdBlNo;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return blCvrdTpCd
	 */
	public String getBlCvrdTpCd() {
		return this.blCvrdTpCd;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return docInterRmk
	 */
	public String getDocInterRmk() {
		return this.docInterRmk;
	}
	
	/**
	 * Column Info
	 * @return thirdPartyFreight
	 */
	public String getThirdPartyFreight() {
		return this.thirdPartyFreight;
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
	 * @param mstCvrdBlNo
	 */
	public void setMstCvrdBlNo(String mstCvrdBlNo) {
		this.mstCvrdBlNo = mstCvrdBlNo;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param blCvrdTpCd
	 */
	public void setBlCvrdTpCd(String blCvrdTpCd) {
		this.blCvrdTpCd = blCvrdTpCd;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param docInterRmk
	 */
	public void setDocInterRmk(String docInterRmk) {
		this.docInterRmk = docInterRmk;
	}
	
	
	/**
	 * Column Info
	 * @param thirdPartyFreight
	 */
	public void setThirdPartyFreight(String thirdPartyFreight) {
		this.thirdPartyFreight = thirdPartyFreight;
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
		setMstCvrdBlNo(JSPUtil.getParameter(request, "mst_cvrd_bl_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setBlCvrdTpCd(JSPUtil.getParameter(request, "bl_cvrd_tp_cd", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setThirdPartyFreight(JSPUtil.getParameter(request, "third_party_freight", ""));
		setDocInterRmk(JSPUtil.getParameter(request, "doc_inter_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeRemarkVO[]
	 */
	public ChargeRemarkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeRemarkVO[]
	 */
	public ChargeRemarkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeRemarkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mstCvrdBlNo = (JSPUtil.getParameter(request, prefix	+ "mst_cvrd_bl_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] blCvrdTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_cvrd_tp_cd", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] thirdPartyFreight = (JSPUtil.getParameter(request, prefix	+ "third_party_freight", length));
			String[] docInterRmk = (JSPUtil.getParameter(request, prefix	+ "doc_inter_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeRemarkVO();
				if (mstCvrdBlNo[i] != null)
					model.setMstCvrdBlNo(mstCvrdBlNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (blCvrdTpCd[i] != null)
					model.setBlCvrdTpCd(blCvrdTpCd[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (thirdPartyFreight[i] != null)
					model.setThirdPartyFreight(thirdPartyFreight[i]);
				if (docInterRmk[i] != null)
					model.setDocInterRmk(docInterRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeRemarkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeRemarkVO[]
	 */
	public ChargeRemarkVO[] getChargeRemarkVOs(){
		ChargeRemarkVO[] vos = (ChargeRemarkVO[])models.toArray(new ChargeRemarkVO[models.size()]);
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
		this.mstCvrdBlNo = this.mstCvrdBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCvrdTpCd = this.blCvrdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thirdPartyFreight = this.thirdPartyFreight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docInterRmk = this.docInterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
