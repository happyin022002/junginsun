/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsManifestVO.java
*@FileTitle : CndCstmsManifestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.06.11 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CndCstmsManifestVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsManifestVO> models = new ArrayList<CndCstmsManifestVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String[] blNos;
	/* Column Info */
	private String miSndDt = null;
	/* Column Info */
	private String pgmNo = null;
	/* Column Info */
	private String terminalAutoSnd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String[] vvdCds;	
	/**
	 * 화면ID
	 * @return pgmNo
	 */
	public String getPgmNo () {
		return pgmNo; 
	}
	
	/**
	 * 화면ID세팅
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * 화면vvd_cd
	 * @return vvdCd
	 */
	public String getVvdCd () {
		return vvdCd; 
	}
	
	/**
	 * 화면ID세팅
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	
	/**
	 * 터미널자동전송
	 * @return terminalAutoSnd
	 */
	public String getTerminalAutoSnd () {
		return terminalAutoSnd; 
	}
	
	/**
	 * 터미널자동전송
	 * @param terminalAutoSnd
	 */
	public void setTerminalAutoSnd(String terminalAutoSnd) {
		this.terminalAutoSnd = terminalAutoSnd;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsManifestVO() {}

	public CndCstmsManifestVO(String ibflag, String pagerows, String blNo, String vvdCd) {
		this.ibflag = ibflag;
		this.blNo = blNo;
		this.vvdCd = vvdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));		
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsManifestVO[]
	 */
	public CndCstmsManifestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsManifestVO[]
	 */
	public CndCstmsManifestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsManifestVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsManifestVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsManifestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsManifestVO[]
	 */
	public CndCstmsManifestVO[] getCndCstmsManifestVOs(){
		CndCstmsManifestVO[] vos = (CndCstmsManifestVO[])models.toArray(new CndCstmsManifestVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
	/**
	 * Column Info
	 * @param miSndDt
	 */
	public void setBlNos(String[] blNos) {
		this.blNos = blNos;
	}
	/**
	 * Column Info
	 * @return miSndDt
	 */
	public String[] getBlNos() {
		return blNos;
	}
	
	/**
	 * Column Info
	 * @param vvdCds
	 */
	public void setVvdCds(String[] vvdCds) {
		this.vvdCds = vvdCds;
	}
	/**
	 * Column Info
	 * @return vvdCds
	 */
	public String[] getVvdCds() {
		return vvdCds;
	}
	
	/**
	 * Column Info
	 * @return miSndDt
	 */
	public String getMiSndDt() {
		return this.miSndDt;
	}
	/**
	 * Column Info
	 * @param miSndDt
	 */
	public void setMiSndDt(String miSndDt) {
		this.miSndDt = miSndDt;
	}
}