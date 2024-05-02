/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtBatHisVO.java
*@FileTitle : DmtBatHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.10 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtBatHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtBatHisVO> models = new ArrayList<DmtBatHisVO>();
	
	/* Column Info */
	private String swaBatTm = null;
	/* Column Info */
	private String batHisDt = null;
	/* Column Info */
	private String korBatTyp = null;
	/* Column Info */
	private String chnBatTm = null;
	/* Column Info */
	private String eurBatTm = null;
	/* Column Info */
	private String usaBatTm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eurBatTyp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chnBatTyp = null;
	/* Column Info */
	private String swaBatTyp = null;
	/* Column Info */
	private String korBatTm = null;
	/* Column Info */
	private String usaBatTyp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtBatHisVO() {}
	/*	테이블 컬럼에 대응되는 멤버변수를 저장함수 */
	public DmtBatHisVO(String ibflag, String pagerows, String chnBatTyp, String eurBatTm, String usaBatTm, String batHisDt, String swaBatTm, String eurBatTyp, String korBatTm, String korBatTyp, String swaBatTyp, String usaBatTyp, String chnBatTm) {
		this.swaBatTm = swaBatTm;
		this.batHisDt = batHisDt;
		this.korBatTyp = korBatTyp;
		this.chnBatTm = chnBatTm;
		this.eurBatTm = eurBatTm;
		this.usaBatTm = usaBatTm;
		this.pagerows = pagerows;
		this.eurBatTyp = eurBatTyp;
		this.ibflag = ibflag;
		this.chnBatTyp = chnBatTyp;
		this.swaBatTyp = swaBatTyp;
		this.korBatTm = korBatTm;
		this.usaBatTyp = usaBatTyp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("swa_bat_tm", getSwaBatTm());
		this.hashColumns.put("bat_his_dt", getBatHisDt());
		this.hashColumns.put("kor_bat_typ", getKorBatTyp());
		this.hashColumns.put("chn_bat_tm", getChnBatTm());
		this.hashColumns.put("eur_bat_tm", getEurBatTm());
		this.hashColumns.put("usa_bat_tm", getUsaBatTm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eur_bat_typ", getEurBatTyp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chn_bat_typ", getChnBatTyp());
		this.hashColumns.put("swa_bat_typ", getSwaBatTyp());
		this.hashColumns.put("kor_bat_tm", getKorBatTm());
		this.hashColumns.put("usa_bat_typ", getUsaBatTyp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("swa_bat_tm", "swaBatTm");
		this.hashFields.put("bat_his_dt", "batHisDt");
		this.hashFields.put("kor_bat_typ", "korBatTyp");
		this.hashFields.put("chn_bat_tm", "chnBatTm");
		this.hashFields.put("eur_bat_tm", "eurBatTm");
		this.hashFields.put("usa_bat_tm", "usaBatTm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eur_bat_typ", "eurBatTyp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chn_bat_typ", "chnBatTyp");
		this.hashFields.put("swa_bat_typ", "swaBatTyp");
		this.hashFields.put("kor_bat_tm", "korBatTm");
		this.hashFields.put("usa_bat_typ", "usaBatTyp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return swaBatTm
	 */
	public String getSwaBatTm() {
		return this.swaBatTm;
	}
	
	/**
	 * Column Info
	 * @return batHisDt
	 */
	public String getBatHisDt() {
		return this.batHisDt;
	}
	
	/**
	 * Column Info
	 * @return korBatTyp
	 */
	public String getKorBatTyp() {
		return this.korBatTyp;
	}
	
	/**
	 * Column Info
	 * @return chnBatTm
	 */
	public String getChnBatTm() {
		return this.chnBatTm;
	}
	
	/**
	 * Column Info
	 * @return eurBatTm
	 */
	public String getEurBatTm() {
		return this.eurBatTm;
	}
	
	/**
	 * Column Info
	 * @return usaBatTm
	 */
	public String getUsaBatTm() {
		return this.usaBatTm;
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
	 * @return eurBatTyp
	 */
	public String getEurBatTyp() {
		return this.eurBatTyp;
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
	 * @return chnBatTyp
	 */
	public String getChnBatTyp() {
		return this.chnBatTyp;
	}
	
	/**
	 * Column Info
	 * @return swaBatTyp
	 */
	public String getSwaBatTyp() {
		return this.swaBatTyp;
	}
	
	/**
	 * Column Info
	 * @return korBatTm
	 */
	public String getKorBatTm() {
		return this.korBatTm;
	}
	
	/**
	 * Column Info
	 * @return usaBatTyp
	 */
	public String getUsaBatTyp() {
		return this.usaBatTyp;
	}
	

	/**
	 * Column Info
	 * @param swaBatTm
	 */
	public void setSwaBatTm(String swaBatTm) {
		this.swaBatTm = swaBatTm;
	}
	
	/**
	 * Column Info
	 * @param batHisDt
	 */
	public void setBatHisDt(String batHisDt) {
		this.batHisDt = batHisDt;
	}
	
	/**
	 * Column Info
	 * @param korBatTyp
	 */
	public void setKorBatTyp(String korBatTyp) {
		this.korBatTyp = korBatTyp;
	}
	
	/**
	 * Column Info
	 * @param chnBatTm
	 */
	public void setChnBatTm(String chnBatTm) {
		this.chnBatTm = chnBatTm;
	}
	
	/**
	 * Column Info
	 * @param eurBatTm
	 */
	public void setEurBatTm(String eurBatTm) {
		this.eurBatTm = eurBatTm;
	}
	
	/**
	 * Column Info
	 * @param usaBatTm
	 */
	public void setUsaBatTm(String usaBatTm) {
		this.usaBatTm = usaBatTm;
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
	 * @param eurBatTyp
	 */
	public void setEurBatTyp(String eurBatTyp) {
		this.eurBatTyp = eurBatTyp;
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
	 * @param chnBatTyp
	 */
	public void setChnBatTyp(String chnBatTyp) {
		this.chnBatTyp = chnBatTyp;
	}
	
	/**
	 * Column Info
	 * @param swaBatTyp
	 */
	public void setSwaBatTyp(String swaBatTyp) {
		this.swaBatTyp = swaBatTyp;
	}
	
	/**
	 * Column Info
	 * @param korBatTm
	 */
	public void setKorBatTm(String korBatTm) {
		this.korBatTm = korBatTm;
	}
	
	/**
	 * Column Info
	 * @param usaBatTyp
	 */
	public void setUsaBatTyp(String usaBatTyp) {
		this.usaBatTyp = usaBatTyp;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSwaBatTm(JSPUtil.getParameter(request, "swa_bat_tm", ""));
		setBatHisDt(JSPUtil.getParameter(request, "bat_his_dt", ""));
		setKorBatTyp(JSPUtil.getParameter(request, "kor_bat_typ", ""));
		setChnBatTm(JSPUtil.getParameter(request, "chn_bat_tm", ""));
		setEurBatTm(JSPUtil.getParameter(request, "eur_bat_tm", ""));
		setUsaBatTm(JSPUtil.getParameter(request, "usa_bat_tm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEurBatTyp(JSPUtil.getParameter(request, "eur_bat_typ", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChnBatTyp(JSPUtil.getParameter(request, "chn_bat_typ", ""));
		setSwaBatTyp(JSPUtil.getParameter(request, "swa_bat_typ", ""));
		setKorBatTm(JSPUtil.getParameter(request, "kor_bat_tm", ""));
		setUsaBatTyp(JSPUtil.getParameter(request, "usa_bat_typ", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtBatHisVO[]
	 */
	public DmtBatHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtBatHisVO[]
	 */
	public DmtBatHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtBatHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] swaBatTm = (JSPUtil.getParameter(request, prefix	+ "swa_bat_tm", length));
			String[] batHisDt = (JSPUtil.getParameter(request, prefix	+ "bat_his_dt", length));
			String[] korBatTyp = (JSPUtil.getParameter(request, prefix	+ "kor_bat_typ", length));
			String[] chnBatTm = (JSPUtil.getParameter(request, prefix	+ "chn_bat_tm", length));
			String[] eurBatTm = (JSPUtil.getParameter(request, prefix	+ "eur_bat_tm", length));
			String[] usaBatTm = (JSPUtil.getParameter(request, prefix	+ "usa_bat_tm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eurBatTyp = (JSPUtil.getParameter(request, prefix	+ "eur_bat_typ", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chnBatTyp = (JSPUtil.getParameter(request, prefix	+ "chn_bat_typ", length));
			String[] swaBatTyp = (JSPUtil.getParameter(request, prefix	+ "swa_bat_typ", length));
			String[] korBatTm = (JSPUtil.getParameter(request, prefix	+ "kor_bat_tm", length));
			String[] usaBatTyp = (JSPUtil.getParameter(request, prefix	+ "usa_bat_typ", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtBatHisVO();
				if (swaBatTm[i] != null)
					model.setSwaBatTm(swaBatTm[i]);
				if (batHisDt[i] != null)
					model.setBatHisDt(batHisDt[i]);
				if (korBatTyp[i] != null)
					model.setKorBatTyp(korBatTyp[i]);
				if (chnBatTm[i] != null)
					model.setChnBatTm(chnBatTm[i]);
				if (eurBatTm[i] != null)
					model.setEurBatTm(eurBatTm[i]);
				if (usaBatTm[i] != null)
					model.setUsaBatTm(usaBatTm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eurBatTyp[i] != null)
					model.setEurBatTyp(eurBatTyp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chnBatTyp[i] != null)
					model.setChnBatTyp(chnBatTyp[i]);
				if (swaBatTyp[i] != null)
					model.setSwaBatTyp(swaBatTyp[i]);
				if (korBatTm[i] != null)
					model.setKorBatTm(korBatTm[i]);
				if (usaBatTyp[i] != null)
					model.setUsaBatTyp(usaBatTyp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtBatHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtBatHisVO[]
	 */
	public DmtBatHisVO[] getDmtBatHisVOs(){
		DmtBatHisVO[] vos = (DmtBatHisVO[])models.toArray(new DmtBatHisVO[models.size()]);
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
		this.swaBatTm = this.swaBatTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batHisDt = this.batHisDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.korBatTyp = this.korBatTyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnBatTm = this.chnBatTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurBatTm = this.eurBatTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBatTm = this.usaBatTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurBatTyp = this.eurBatTyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnBatTyp = this.chnBatTyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.swaBatTyp = this.swaBatTyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.korBatTm = this.korBatTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBatTyp = this.usaBatTyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
