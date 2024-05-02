/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransmissionChkListCondVO.java
*@FileTitle : TransmissionChkListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.29 김도완 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo;

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
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TransmissionChkListCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TransmissionChkListCondVO> models = new ArrayList<TransmissionChkListCondVO>();
	
	/* Column Info */
	private String trunkfirst = null;
	/* Column Info */
	private String allerror = null;
	/* Column Info */
	private String blmi = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bofc = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmp2 = null;
	/* Column Info */
	private String pgmno = null;
	/* Column Info */
	private String tmp1 = null;
	/* Column Info */
	private String tmp3 = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TransmissionChkListCondVO() {}

	public TransmissionChkListCondVO(String ibflag, String pagerows, String vvd, String pod, String pol, String trunkfirst, String bofc, String blmi, String allerror, String pgmno, String tmp1, String tmp2, String tmp3) {
		this.trunkfirst = trunkfirst;
		this.allerror = allerror;
		this.blmi = blmi;
		this.pagerows = pagerows;
		this.bofc = bofc;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.tmp2 = tmp2;
		this.pgmno = pgmno;
		this.tmp1 = tmp1;
		this.tmp3 = tmp3;
		this.pol = pol;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trunkfirst", getTrunkfirst());
		this.hashColumns.put("allerror", getAllerror());
		this.hashColumns.put("blmi", getBlmi());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bofc", getBofc());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tmp2", getTmp2());
		this.hashColumns.put("pgmno", getPgmno());
		this.hashColumns.put("tmp1", getTmp1());
		this.hashColumns.put("tmp3", getTmp3());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trunkfirst", "trunkfirst");
		this.hashFields.put("allerror", "allerror");
		this.hashFields.put("blmi", "blmi");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bofc", "bofc");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tmp2", "tmp2");
		this.hashFields.put("pgmno", "pgmno");
		this.hashFields.put("tmp1", "tmp1");
		this.hashFields.put("tmp3", "tmp3");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trunkfirst
	 */
	public String getTrunkfirst() {
		return this.trunkfirst;
	}
	
	/**
	 * Column Info
	 * @return allerror
	 */
	public String getAllerror() {
		return this.allerror;
	}
	
	/**
	 * Column Info
	 * @return blmi
	 */
	public String getBlmi() {
		return this.blmi;
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
	 * @return bofc
	 */
	public String getBofc() {
		return this.bofc;
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
	 * @return tmp2
	 */
	public String getTmp2() {
		return this.tmp2;
	}
	
	/**
	 * Column Info
	 * @return pgmno
	 */
	public String getPgmno() {
		return this.pgmno;
	}
	
	/**
	 * Column Info
	 * @return tmp1
	 */
	public String getTmp1() {
		return this.tmp1;
	}
	
	/**
	 * Column Info
	 * @return tmp3
	 */
	public String getTmp3() {
		return this.tmp3;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param trunkfirst
	 */
	public void setTrunkfirst(String trunkfirst) {
		this.trunkfirst = trunkfirst;
	}
	
	/**
	 * Column Info
	 * @param allerror
	 */
	public void setAllerror(String allerror) {
		this.allerror = allerror;
	}
	
	/**
	 * Column Info
	 * @param blmi
	 */
	public void setBlmi(String blmi) {
		this.blmi = blmi;
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
	 * @param bofc
	 */
	public void setBofc(String bofc) {
		this.bofc = bofc;
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
	 * @param tmp2
	 */
	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
	}
	
	/**
	 * Column Info
	 * @param pgmno
	 */
	public void setPgmno(String pgmno) {
		this.pgmno = pgmno;
	}
	
	/**
	 * Column Info
	 * @param tmp1
	 */
	public void setTmp1(String tmp1) {
		this.tmp1 = tmp1;
	}
	
	/**
	 * Column Info
	 * @param tmp3
	 */
	public void setTmp3(String tmp3) {
		this.tmp3 = tmp3;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTrunkfirst(JSPUtil.getParameter(request, "trunkfirst", ""));
		setAllerror(JSPUtil.getParameter(request, "allerror", ""));
		setBlmi(JSPUtil.getParameter(request, "blmi", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBofc(JSPUtil.getParameter(request, "bofc", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTmp2(JSPUtil.getParameter(request, "tmp2", ""));
		setPgmno(JSPUtil.getParameter(request, "pgmno", ""));
		setTmp1(JSPUtil.getParameter(request, "tmp1", ""));
		setTmp3(JSPUtil.getParameter(request, "tmp3", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TransmissionChkListCondVO[]
	 */
	public TransmissionChkListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TransmissionChkListCondVO[]
	 */
	public TransmissionChkListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TransmissionChkListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trunkfirst = (JSPUtil.getParameter(request, prefix	+ "trunkfirst", length));
			String[] allerror = (JSPUtil.getParameter(request, prefix	+ "allerror", length));
			String[] blmi = (JSPUtil.getParameter(request, prefix	+ "blmi", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bofc = (JSPUtil.getParameter(request, prefix	+ "bofc", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmp2 = (JSPUtil.getParameter(request, prefix	+ "tmp2", length));
			String[] pgmno = (JSPUtil.getParameter(request, prefix	+ "pgmno", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp1", length));
			String[] tmp3 = (JSPUtil.getParameter(request, prefix	+ "tmp3", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new TransmissionChkListCondVO();
				if (trunkfirst[i] != null)
					model.setTrunkfirst(trunkfirst[i]);
				if (allerror[i] != null)
					model.setAllerror(allerror[i]);
				if (blmi[i] != null)
					model.setBlmi(blmi[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bofc[i] != null)
					model.setBofc(bofc[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmp2[i] != null)
					model.setTmp2(tmp2[i]);
				if (pgmno[i] != null)
					model.setPgmno(pgmno[i]);
				if (tmp1[i] != null)
					model.setTmp1(tmp1[i]);
				if (tmp3[i] != null)
					model.setTmp3(tmp3[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTransmissionChkListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TransmissionChkListCondVO[]
	 */
	public TransmissionChkListCondVO[] getTransmissionChkListCondVOs(){
		TransmissionChkListCondVO[] vos = (TransmissionChkListCondVO[])models.toArray(new TransmissionChkListCondVO[models.size()]);
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
		this.trunkfirst = this.trunkfirst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allerror = this.allerror .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blmi = this.blmi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bofc = this.bofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp2 = this.tmp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmno = this.pgmno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp1 = this.tmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp3 = this.tmp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
