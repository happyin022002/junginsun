/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfChgExpSumVO.java
*@FileTitle : KrWhfChgExpSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.08.14 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfChgExpSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfChgExpSumVO> models = new ArrayList<KrWhfChgExpSumVO>();
	
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String ts = null;
	/* Column Info */
	private String singoyejeonggumaek = null;
	/* Column Info */
	private String ipi = null;
	/* Column Info */
	private String ratingamount = null;
	/* Column Info */
	private String bulk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String military = null;
	/* Column Info */
	private String dongbujekang = null;
	/* Column Info */
	private String hyundaehi = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String exempttotal = null;
	/* Column Info */
	private String hyosung = null;
	/* Column Info */
	private String jodalcheong = null;
	/* Column Info */
	private String incloft = null;
	/* Column Info */
	private String buguadaesang = null;
	/* Column Info */
	private String mty = null;
	/* Column Info */
	private String daewoomot = null;
	/* Column Info */
	private String donggukjekang = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfChgExpSumVO() {}

	public KrWhfChgExpSumVO(String ibflag, String pagerows, String gubun, String buguadaesang, String hyosung, String daewoomot, String dongbujekang, String hyundaehi, String donggukjekang, String ts, String ipi, String military, String jodalcheong, String mty, String bulk, String incloft, String exempttotal, String ratingamount, String singoyejeonggumaek) {
		this.gubun = gubun;
		this.ts = ts;
		this.singoyejeonggumaek = singoyejeonggumaek;
		this.ipi = ipi;
		this.ratingamount = ratingamount;
		this.bulk = bulk;
		this.pagerows = pagerows;
		this.military = military;
		this.dongbujekang = dongbujekang;
		this.hyundaehi = hyundaehi;
		this.ibflag = ibflag;
		this.exempttotal = exempttotal;
		this.hyosung = hyosung;
		this.jodalcheong = jodalcheong;
		this.incloft = incloft;
		this.buguadaesang = buguadaesang;
		this.mty = mty;
		this.daewoomot = daewoomot;
		this.donggukjekang = donggukjekang;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("ts", getTs());
		this.hashColumns.put("singoyejeonggumaek", getSingoyejeonggumaek());
		this.hashColumns.put("ipi", getIpi());
		this.hashColumns.put("ratingamount", getRatingamount());
		this.hashColumns.put("bulk", getBulk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("military", getMilitary());
		this.hashColumns.put("dongbujekang", getDongbujekang());
		this.hashColumns.put("hyundaehi", getHyundaehi());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("exempttotal", getExempttotal());
		this.hashColumns.put("hyosung", getHyosung());
		this.hashColumns.put("jodalcheong", getJodalcheong());
		this.hashColumns.put("incloft", getIncloft());
		this.hashColumns.put("buguadaesang", getBuguadaesang());
		this.hashColumns.put("mty", getMty());
		this.hashColumns.put("daewoomot", getDaewoomot());
		this.hashColumns.put("donggukjekang", getDonggukjekang());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("ts", "ts");
		this.hashFields.put("singoyejeonggumaek", "singoyejeonggumaek");
		this.hashFields.put("ipi", "ipi");
		this.hashFields.put("ratingamount", "ratingamount");
		this.hashFields.put("bulk", "bulk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("military", "military");
		this.hashFields.put("dongbujekang", "dongbujekang");
		this.hashFields.put("hyundaehi", "hyundaehi");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("exempttotal", "exempttotal");
		this.hashFields.put("hyosung", "hyosung");
		this.hashFields.put("jodalcheong", "jodalcheong");
		this.hashFields.put("incloft", "incloft");
		this.hashFields.put("buguadaesang", "buguadaesang");
		this.hashFields.put("mty", "mty");
		this.hashFields.put("daewoomot", "daewoomot");
		this.hashFields.put("donggukjekang", "donggukjekang");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
	}
	
	/**
	 * Column Info
	 * @return singoyejeonggumaek
	 */
	public String getSingoyejeonggumaek() {
		return this.singoyejeonggumaek;
	}
	
	/**
	 * Column Info
	 * @return ipi
	 */
	public String getIpi() {
		return this.ipi;
	}
	
	/**
	 * Column Info
	 * @return ratingamount
	 */
	public String getRatingamount() {
		return this.ratingamount;
	}
	
	/**
	 * Column Info
	 * @return bulk
	 */
	public String getBulk() {
		return this.bulk;
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
	 * @return military
	 */
	public String getMilitary() {
		return this.military;
	}
	
	/**
	 * Column Info
	 * @return dongbujekang
	 */
	public String getDongbujekang() {
		return this.dongbujekang;
	}
	
	/**
	 * Column Info
	 * @return hyundaehi
	 */
	public String getHyundaehi() {
		return this.hyundaehi;
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
	 * @return exempttotal
	 */
	public String getExempttotal() {
		return this.exempttotal;
	}
	
	/**
	 * Column Info
	 * @return hyosung
	 */
	public String getHyosung() {
		return this.hyosung;
	}
	
	/**
	 * Column Info
	 * @return jodalcheong
	 */
	public String getJodalcheong() {
		return this.jodalcheong;
	}
	
	/**
	 * Column Info
	 * @return incloft
	 */
	public String getIncloft() {
		return this.incloft;
	}
	
	/**
	 * Column Info
	 * @return buguadaesang
	 */
	public String getBuguadaesang() {
		return this.buguadaesang;
	}
	
	/**
	 * Column Info
	 * @return mty
	 */
	public String getMty() {
		return this.mty;
	}
	
	/**
	 * Column Info
	 * @return daewoomot
	 */
	public String getDaewoomot() {
		return this.daewoomot;
	}
	
	/**
	 * Column Info
	 * @return donggukjekang
	 */
	public String getDonggukjekang() {
		return this.donggukjekang;
	}
	

	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	/**
	 * Column Info
	 * @param singoyejeonggumaek
	 */
	public void setSingoyejeonggumaek(String singoyejeonggumaek) {
		this.singoyejeonggumaek = singoyejeonggumaek;
	}
	
	/**
	 * Column Info
	 * @param ipi
	 */
	public void setIpi(String ipi) {
		this.ipi = ipi;
	}
	
	/**
	 * Column Info
	 * @param ratingamount
	 */
	public void setRatingamount(String ratingamount) {
		this.ratingamount = ratingamount;
	}
	
	/**
	 * Column Info
	 * @param bulk
	 */
	public void setBulk(String bulk) {
		this.bulk = bulk;
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
	 * @param military
	 */
	public void setMilitary(String military) {
		this.military = military;
	}
	
	/**
	 * Column Info
	 * @param dongbujekang
	 */
	public void setDongbujekang(String dongbujekang) {
		this.dongbujekang = dongbujekang;
	}
	
	/**
	 * Column Info
	 * @param hyundaehi
	 */
	public void setHyundaehi(String hyundaehi) {
		this.hyundaehi = hyundaehi;
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
	 * @param exempttotal
	 */
	public void setExempttotal(String exempttotal) {
		this.exempttotal = exempttotal;
	}
	
	/**
	 * Column Info
	 * @param hyosung
	 */
	public void setHyosung(String hyosung) {
		this.hyosung = hyosung;
	}
	
	/**
	 * Column Info
	 * @param jodalcheong
	 */
	public void setJodalcheong(String jodalcheong) {
		this.jodalcheong = jodalcheong;
	}
	
	/**
	 * Column Info
	 * @param incloft
	 */
	public void setIncloft(String incloft) {
		this.incloft = incloft;
	}
	
	/**
	 * Column Info
	 * @param buguadaesang
	 */
	public void setBuguadaesang(String buguadaesang) {
		this.buguadaesang = buguadaesang;
	}
	
	/**
	 * Column Info
	 * @param mty
	 */
	public void setMty(String mty) {
		this.mty = mty;
	}
	
	/**
	 * Column Info
	 * @param daewoomot
	 */
	public void setDaewoomot(String daewoomot) {
		this.daewoomot = daewoomot;
	}
	
	/**
	 * Column Info
	 * @param donggukjekang
	 */
	public void setDonggukjekang(String donggukjekang) {
		this.donggukjekang = donggukjekang;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setTs(JSPUtil.getParameter(request, "ts", ""));
		setSingoyejeonggumaek(JSPUtil.getParameter(request, "singoyejeonggumaek", ""));
		setIpi(JSPUtil.getParameter(request, "ipi", ""));
		setRatingamount(JSPUtil.getParameter(request, "ratingamount", ""));
		setBulk(JSPUtil.getParameter(request, "bulk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMilitary(JSPUtil.getParameter(request, "military", ""));
		setDongbujekang(JSPUtil.getParameter(request, "dongbujekang", ""));
		setHyundaehi(JSPUtil.getParameter(request, "hyundaehi", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setExempttotal(JSPUtil.getParameter(request, "exempttotal", ""));
		setHyosung(JSPUtil.getParameter(request, "hyosung", ""));
		setJodalcheong(JSPUtil.getParameter(request, "jodalcheong", ""));
		setIncloft(JSPUtil.getParameter(request, "incloft", ""));
		setBuguadaesang(JSPUtil.getParameter(request, "buguadaesang", ""));
		setMty(JSPUtil.getParameter(request, "mty", ""));
		setDaewoomot(JSPUtil.getParameter(request, "daewoomot", ""));
		setDonggukjekang(JSPUtil.getParameter(request, "donggukjekang", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfChgExpSumVO[]
	 */
	public KrWhfChgExpSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfChgExpSumVO[]
	 */
	public KrWhfChgExpSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfChgExpSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			String[] singoyejeonggumaek = (JSPUtil.getParameter(request, prefix	+ "singoyejeonggumaek", length));
			String[] ipi = (JSPUtil.getParameter(request, prefix	+ "ipi", length));
			String[] ratingamount = (JSPUtil.getParameter(request, prefix	+ "ratingamount", length));
			String[] bulk = (JSPUtil.getParameter(request, prefix	+ "bulk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] military = (JSPUtil.getParameter(request, prefix	+ "military", length));
			String[] dongbujekang = (JSPUtil.getParameter(request, prefix	+ "dongbujekang", length));
			String[] hyundaehi = (JSPUtil.getParameter(request, prefix	+ "hyundaehi", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] exempttotal = (JSPUtil.getParameter(request, prefix	+ "exempttotal", length));
			String[] hyosung = (JSPUtil.getParameter(request, prefix	+ "hyosung", length));
			String[] jodalcheong = (JSPUtil.getParameter(request, prefix	+ "jodalcheong", length));
			String[] incloft = (JSPUtil.getParameter(request, prefix	+ "incloft", length));
			String[] buguadaesang = (JSPUtil.getParameter(request, prefix	+ "buguadaesang", length));
			String[] mty = (JSPUtil.getParameter(request, prefix	+ "mty", length));
			String[] daewoomot = (JSPUtil.getParameter(request, prefix	+ "daewoomot", length));
			String[] donggukjekang = (JSPUtil.getParameter(request, prefix	+ "donggukjekang", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfChgExpSumVO();
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (ts[i] != null)
					model.setTs(ts[i]);
				if (singoyejeonggumaek[i] != null)
					model.setSingoyejeonggumaek(singoyejeonggumaek[i]);
				if (ipi[i] != null)
					model.setIpi(ipi[i]);
				if (ratingamount[i] != null)
					model.setRatingamount(ratingamount[i]);
				if (bulk[i] != null)
					model.setBulk(bulk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (military[i] != null)
					model.setMilitary(military[i]);
				if (dongbujekang[i] != null)
					model.setDongbujekang(dongbujekang[i]);
				if (hyundaehi[i] != null)
					model.setHyundaehi(hyundaehi[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (exempttotal[i] != null)
					model.setExempttotal(exempttotal[i]);
				if (hyosung[i] != null)
					model.setHyosung(hyosung[i]);
				if (jodalcheong[i] != null)
					model.setJodalcheong(jodalcheong[i]);
				if (incloft[i] != null)
					model.setIncloft(incloft[i]);
				if (buguadaesang[i] != null)
					model.setBuguadaesang(buguadaesang[i]);
				if (mty[i] != null)
					model.setMty(mty[i]);
				if (daewoomot[i] != null)
					model.setDaewoomot(daewoomot[i]);
				if (donggukjekang[i] != null)
					model.setDonggukjekang(donggukjekang[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfChgExpSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfChgExpSumVO[]
	 */
	public KrWhfChgExpSumVO[] getKrWhfChgExpSumVOs(){
		KrWhfChgExpSumVO[] vos = (KrWhfChgExpSumVO[])models.toArray(new KrWhfChgExpSumVO[models.size()]);
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
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.singoyejeonggumaek = this.singoyejeonggumaek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipi = this.ipi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratingamount = this.ratingamount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bulk = this.bulk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.military = this.military .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dongbujekang = this.dongbujekang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hyundaehi = this.hyundaehi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exempttotal = this.exempttotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hyosung = this.hyosung .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jodalcheong = this.jodalcheong .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incloft = this.incloft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buguadaesang = this.buguadaesang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty = this.mty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daewoomot = this.daewoomot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.donggukjekang = this.donggukjekang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
