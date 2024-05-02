/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BrCmVO.java
*@FileTitle : BrCmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.27 경종윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BrCmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrCmVO> models = new ArrayList<BrCmVO>();
	
	/* Column Info */
	private String hamoTrfCd = "";
	/* Column Info */
	private String dMark = "";
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = "";
	/* Column Info */
	private String dMeas = "";
	/* Column Info */
	private String dDesc = "";
	/* Column Info */
	private String dPunit = "";
	/* Column Info */
	private String dPkg = "";
	/* Column Info */
	private String dNcmCd = "";
	/* Column Info */
	private String dWgt = "";
	/* Column Info */
	private String dCmdt = "";
	/* Page Number */
	private String pagerows = "";
	/* Page Number */
	private String cntrMfSeq = "";
	/* Column Info */
	private String wpm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrCmVO() {}

	public BrCmVO(String ibflag, String pagerows, String dCmdt, String dPunit, String dPkg, String dWgt, String dMeas, String dDesc, String hamoTrfCd, String dNcmCd, String dMark, String cntrMfSeq, String wpm) {
		this.hamoTrfCd = hamoTrfCd;
		this.dMark = dMark;
		this.ibflag = ibflag;
		this.dMeas = dMeas;
		this.dDesc = dDesc;
		this.dPunit = dPunit;
		this.dPkg = dPkg;
		this.dNcmCd = dNcmCd;
		this.dWgt = dWgt;
		this.dCmdt = dCmdt;
		this.pagerows = pagerows;
		this.cntrMfSeq = cntrMfSeq;
		this.wpm = wpm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hamo_trf_cd", getHamoTrfCd());
		this.hashColumns.put("d_mark", getDMark());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d_meas", getDMeas());
		this.hashColumns.put("d_desc", getDDesc());
		this.hashColumns.put("d_punit", getDPunit());
		this.hashColumns.put("d_pkg", getDPkg());
		this.hashColumns.put("d_ncm_cd", getDNcmCd());
		this.hashColumns.put("d_wgt", getDWgt());
		this.hashColumns.put("d_cmdt", getDCmdt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("wpm", getWpm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hamo_trf_cd", "hamoTrfCd");
		this.hashFields.put("d_mark", "dMark");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d_meas", "dMeas");
		this.hashFields.put("d_desc", "dDesc");
		this.hashFields.put("d_punit", "dPunit");
		this.hashFields.put("d_pkg", "dPkg");
		this.hashFields.put("d_ncm_cd", "dNcmCd");
		this.hashFields.put("d_wgt", "dWgt");
		this.hashFields.put("d_cmdt", "dCmdt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("wpm", "wpm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hamoTrfCd
	 */
	public String getHamoTrfCd() {
		return this.hamoTrfCd;
	}
	
	/**
	 * Column Info
	 * @return dMark
	 */
	public String getDMark() {
		return this.dMark;
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
	 * @return dMeas
	 */
	public String getDMeas() {
		return this.dMeas;
	}
	
	/**
	 * Column Info
	 * @return dDesc
	 */
	public String getDDesc() {
		return this.dDesc;
	}
	
	/**
	 * Column Info
	 * @return dPunit
	 */
	public String getDPunit() {
		return this.dPunit;
	}
	
	/**
	 * Column Info
	 * @return dPkg
	 */
	public String getDPkg() {
		return this.dPkg;
	}
	
	/**
	 * Column Info
	 * @return dNcmCd
	 */
	public String getDNcmCd() {
		return this.dNcmCd;
	}
	
	/**
	 * Column Info
	 * @return dWgt
	 */
	public String getDWgt() {
		return this.dWgt;
	}
	
	/**
	 * Column Info
	 * @return dCmdt
	 */
	public String getDCmdt() {
		return this.dCmdt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
	}
	
	/**
	 * Column Info
	 * @return wpm
	 */
	public String getWpm() {
		return this.wpm;
	}
	
	/**
	 * Column Info
	 * @param hamoTrfCd
	 */
	public void setHamoTrfCd(String hamoTrfCd) {
		this.hamoTrfCd = hamoTrfCd;
	}
	
	/**
	 * Column Info
	 * @param dMark
	 */
	public void setDMark(String dMark) {
		this.dMark = dMark;
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
	 * @param dMeas
	 */
	public void setDMeas(String dMeas) {
		this.dMeas = dMeas;
	}
	
	/**
	 * Column Info
	 * @param dDesc
	 */
	public void setDDesc(String dDesc) {
		this.dDesc = dDesc;
	}
	
	/**
	 * Column Info
	 * @param dPunit
	 */
	public void setDPunit(String dPunit) {
		this.dPunit = dPunit;
	}
	
	/**
	 * Column Info
	 * @param dPkg
	 */
	public void setDPkg(String dPkg) {
		this.dPkg = dPkg;
	}
	
	/**
	 * Column Info
	 * @param dNcmCd
	 */
	public void setDNcmCd(String dNcmCd) {
		this.dNcmCd = dNcmCd;
	}
	
	/**
	 * Column Info
	 * @param dWgt
	 */
	public void setDWgt(String dWgt) {
		this.dWgt = dWgt;
	}
	
	/**
	 * Column Info
	 * @param dCmdt
	 */
	public void setDCmdt(String dCmdt) {
		this.dCmdt = dCmdt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
	}
	
	/**
	 * Column Info
	 * @param wpm
	 */
	public void setWpm(String wpm) {
		this.wpm = wpm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setHamoTrfCd(JSPUtil.getParameter(request, "hamo_trf_cd", ""));
		setDMark(JSPUtil.getParameter(request, "d_mark", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDMeas(JSPUtil.getParameter(request, "d_meas", ""));
		setDDesc(JSPUtil.getParameter(request, "d_desc", ""));
		setDPunit(JSPUtil.getParameter(request, "d_punit", ""));
		setDPkg(JSPUtil.getParameter(request, "d_pkg", ""));
		setDNcmCd(JSPUtil.getParameter(request, "d_ncm_cd", ""));
		setDWgt(JSPUtil.getParameter(request, "d_wgt", ""));
		setDCmdt(JSPUtil.getParameter(request, "d_cmdt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, "cntr_mf_seq", ""));
		setWpm(JSPUtil.getParameter(request, "wpm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrCmVO[]
	 */
	public BrCmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrCmVO[]
	 */
	public BrCmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrCmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hamoTrfCd = (JSPUtil.getParameter(request, prefix	+ "hamo_trf_cd".trim(), length));
			String[] dMark = (JSPUtil.getParameter(request, prefix	+ "d_mark".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] dMeas = (JSPUtil.getParameter(request, prefix	+ "d_meas".trim(), length));
			String[] dDesc = (JSPUtil.getParameter(request, prefix	+ "d_desc".trim(), length));
			String[] dPunit = (JSPUtil.getParameter(request, prefix	+ "d_punit".trim(), length));
			String[] dPkg = (JSPUtil.getParameter(request, prefix	+ "d_pkg".trim(), length));
			String[] dNcmCd = (JSPUtil.getParameter(request, prefix	+ "d_ncm_cd".trim(), length));
			String[] dWgt = (JSPUtil.getParameter(request, prefix	+ "d_wgt".trim(), length));
			String[] dCmdt = (JSPUtil.getParameter(request, prefix	+ "d_cmdt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq".trim(), length));
			String[] wpm = (JSPUtil.getParameter(request, prefix	+ "wpm", length));
			
			for (int i = 0; i < length; i++) {
				model = new BrCmVO();
				if (hamoTrfCd[i] != null)
					model.setHamoTrfCd(hamoTrfCd[i]);
				if (dMark[i] != null)
					model.setDMark(dMark[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dMeas[i] != null)
					model.setDMeas(dMeas[i]);
				if (dDesc[i] != null)
					model.setDDesc(dDesc[i]);
				if (dPunit[i] != null)
					model.setDPunit(dPunit[i]);
				if (dPkg[i] != null)
					model.setDPkg(dPkg[i]);
				if (dNcmCd[i] != null)
					model.setDNcmCd(dNcmCd[i]);
				if (dWgt[i] != null)
					model.setDWgt(dWgt[i]);
				if (dCmdt[i] != null)
					model.setDCmdt(dCmdt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrMfSeq[i] != null)
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (wpm[i] != null)
					model.setWpm(wpm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBrCmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BrCmVO[]
	 */
	public BrCmVO[] getBrCmVOs(){
		BrCmVO[] vos = (BrCmVO[])models.toArray(new BrCmVO[models.size()]);
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
		this.hamoTrfCd = this.hamoTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dMark = this.dMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dMeas = this.dMeas .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDesc = this.dDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPunit = this.dPunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPkg = this.dPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dNcmCd = this.dNcmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dWgt = this.dWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmdt = this.dCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wpm = this.wpm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
