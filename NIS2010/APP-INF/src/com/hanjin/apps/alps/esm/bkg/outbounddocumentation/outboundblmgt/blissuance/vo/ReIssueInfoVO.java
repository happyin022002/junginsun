/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReIssueInfoVO.java
*@FileTitle : ReIssueInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.28 이진서 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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

public class ReIssueInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReIssueInfoVO> models = new ArrayList<ReIssueInfoVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oblSrndFlg = null;
	/* Column Info */
	private String oblIssFlg = null;
	/* Column Info */
	private String shipperName = null;
	/* Column Info */
	private String doYn = null;
	/* Column Info */
	private String oblIssKnt = null;
	/* Column Info */
	private String shipperCode = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String blTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ReIssueInfoVO() {}

	public ReIssueInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String blTpCd, String shipperCode, String shipperName, String oblIssKnt, String oblSrndFlg, String oblIssFlg, String doYn) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.oblSrndFlg = oblSrndFlg;
		this.oblIssFlg = oblIssFlg;
		this.shipperName = shipperName;
		this.doYn = doYn;
		this.oblIssKnt = oblIssKnt;
		this.shipperCode = shipperCode;
		this.blNo = blNo;
		this.blTpCd = blTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("obl_srnd_flg", getOblSrndFlg());
		this.hashColumns.put("obl_iss_flg", getOblIssFlg());
		this.hashColumns.put("shipper_name", getShipperName());
		this.hashColumns.put("do_yn", getDoYn());
		this.hashColumns.put("obl_iss_knt", getOblIssKnt());
		this.hashColumns.put("shipper_code", getShipperCode());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("obl_srnd_flg", "oblSrndFlg");
		this.hashFields.put("obl_iss_flg", "oblIssFlg");
		this.hashFields.put("shipper_name", "shipperName");
		this.hashFields.put("do_yn", "doYn");
		this.hashFields.put("obl_iss_knt", "oblIssKnt");
		this.hashFields.put("shipper_code", "shipperCode");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return oblSrndFlg
	 */
	public String getOblSrndFlg() {
		return this.oblSrndFlg;
	}
	
	/**
	 * Column Info
	 * @return oblIssFlg
	 */
	public String getOblIssFlg() {
		return this.oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @return shipperName
	 */
	public String getShipperName() {
		return this.shipperName;
	}
	
	/**
	 * Column Info
	 * @return doYn
	 */
	public String getDoYn() {
		return this.doYn;
	}
	
	/**
	 * Column Info
	 * @return oblIssKnt
	 */
	public String getOblIssKnt() {
		return this.oblIssKnt;
	}
	
	/**
	 * Column Info
	 * @return shipperCode
	 */
	public String getShipperCode() {
		return this.shipperCode;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
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
	 * @param oblSrndFlg
	 */
	public void setOblSrndFlg(String oblSrndFlg) {
		this.oblSrndFlg = oblSrndFlg;
	}
	
	/**
	 * Column Info
	 * @param oblIssFlg
	 */
	public void setOblIssFlg(String oblIssFlg) {
		this.oblIssFlg = oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @param shipperName
	 */
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	
	/**
	 * Column Info
	 * @param doYn
	 */
	public void setDoYn(String doYn) {
		this.doYn = doYn;
	}
	
	/**
	 * Column Info
	 * @param oblIssKnt
	 */
	public void setOblIssKnt(String oblIssKnt) {
		this.oblIssKnt = oblIssKnt;
	}
	
	/**
	 * Column Info
	 * @param shipperCode
	 */
	public void setShipperCode(String shipperCode) {
		this.shipperCode = shipperCode;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
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
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOblSrndFlg(JSPUtil.getParameter(request, "obl_srnd_flg", ""));
		setOblIssFlg(JSPUtil.getParameter(request, "obl_iss_flg", ""));
		setShipperName(JSPUtil.getParameter(request, "shipper_name", ""));
		setDoYn(JSPUtil.getParameter(request, "do_yn", ""));
		setOblIssKnt(JSPUtil.getParameter(request, "obl_iss_knt", ""));
		setShipperCode(JSPUtil.getParameter(request, "shipper_code", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReIssueInfoVO[]
	 */
	public ReIssueInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReIssueInfoVO[]
	 */
	public ReIssueInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReIssueInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oblSrndFlg = (JSPUtil.getParameter(request, prefix	+ "obl_srnd_flg", length));
			String[] oblIssFlg = (JSPUtil.getParameter(request, prefix	+ "obl_iss_flg", length));
			String[] shipperName = (JSPUtil.getParameter(request, prefix	+ "shipper_name", length));
			String[] doYn = (JSPUtil.getParameter(request, prefix	+ "do_yn", length));
			String[] oblIssKnt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_knt", length));
			String[] shipperCode = (JSPUtil.getParameter(request, prefix	+ "shipper_code", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReIssueInfoVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oblSrndFlg[i] != null)
					model.setOblSrndFlg(oblSrndFlg[i]);
				if (oblIssFlg[i] != null)
					model.setOblIssFlg(oblIssFlg[i]);
				if (shipperName[i] != null)
					model.setShipperName(shipperName[i]);
				if (doYn[i] != null)
					model.setDoYn(doYn[i]);
				if (oblIssKnt[i] != null)
					model.setOblIssKnt(oblIssKnt[i]);
				if (shipperCode[i] != null)
					model.setShipperCode(shipperCode[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReIssueInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReIssueInfoVO[]
	 */
	public ReIssueInfoVO[] getReIssueInfoVOs(){
		ReIssueInfoVO[] vos = (ReIssueInfoVO[])models.toArray(new ReIssueInfoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblSrndFlg = this.oblSrndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFlg = this.oblIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperName = this.shipperName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doYn = this.doYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssKnt = this.oblIssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCode = this.shipperCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
