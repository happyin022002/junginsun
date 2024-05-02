/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ManilaSearchVvdDtlVO.java
*@FileTitle : ManilaSearchVvdDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.14  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ManilaSearchVvdDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManilaSearchVvdDtlVO> models = new ArrayList<ManilaSearchVvdDtlVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String regNumber = null;
	/* Column Info */
	private String polcd = null;
	/* Column Info */
	private String etadt = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String gTongWgt = null;
	/* Column Info */
	private String discharge = null;
	/* Column Info */
	private String vname = null;
	/* Column Info */
	private String nTongWgt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ManilaSearchVvdDtlVO() {}

	public ManilaSearchVvdDtlVO(String ibflag, String pagerows, String regNumber, String polcd, String seq, String etadt, String discharge, String vname, String gTongWgt, String nTongWgt) {
		this.ibflag = ibflag;
		this.regNumber = regNumber;
		this.polcd = polcd;
		this.etadt = etadt;
		this.seq = seq;
		this.gTongWgt = gTongWgt;
		this.discharge = discharge;
		this.vname = vname;
		this.nTongWgt = nTongWgt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("reg_number", getRegNumber());
		this.hashColumns.put("polcd", getPolcd());
		this.hashColumns.put("etadt", getEtadt());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("g_tong_wgt", getGTongWgt());
		this.hashColumns.put("discharge", getDischarge());
		this.hashColumns.put("vname", getVname());
		this.hashColumns.put("n_tong_wgt", getNTongWgt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("reg_number", "regNumber");
		this.hashFields.put("polcd", "polcd");
		this.hashFields.put("etadt", "etadt");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("g_tong_wgt", "gTongWgt");
		this.hashFields.put("discharge", "discharge");
		this.hashFields.put("vname", "vname");
		this.hashFields.put("n_tong_wgt", "nTongWgt");
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
	 * @return regNumber
	 */
	public String getRegNumber() {
		return this.regNumber;
	}
	
	/**
	 * Column Info
	 * @return polcd
	 */
	public String getPolcd() {
		return this.polcd;
	}
	
	/**
	 * Column Info
	 * @return etadt
	 */
	public String getEtadt() {
		return this.etadt;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return gTongWgt
	 */
	public String getGTongWgt() {
		return this.gTongWgt;
	}
	
	/**
	 * Column Info
	 * @return discharge
	 */
	public String getDischarge() {
		return this.discharge;
	}
	
	/**
	 * Column Info
	 * @return vname
	 */
	public String getVname() {
		return this.vname;
	}
	
	/**
	 * Column Info
	 * @return nTongWgt
	 */
	public String getNTongWgt() {
		return this.nTongWgt;
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
	 * @param regNumber
	 */
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	
	/**
	 * Column Info
	 * @param polcd
	 */
	public void setPolcd(String polcd) {
		this.polcd = polcd;
	}
	
	/**
	 * Column Info
	 * @param etadt
	 */
	public void setEtadt(String etadt) {
		this.etadt = etadt;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param gTongWgt
	 */
	public void setGTongWgt(String gTongWgt) {
		this.gTongWgt = gTongWgt;
	}
	
	/**
	 * Column Info
	 * @param discharge
	 */
	public void setDischarge(String discharge) {
		this.discharge = discharge;
	}
	
	/**
	 * Column Info
	 * @param vname
	 */
	public void setVname(String vname) {
		this.vname = vname;
	}
	
	/**
	 * Column Info
	 * @param nTongWgt
	 */
	public void setNTongWgt(String nTongWgt) {
		this.nTongWgt = nTongWgt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRegNumber(JSPUtil.getParameter(request, prefix + "reg_number", ""));
		setPolcd(JSPUtil.getParameter(request, prefix + "polcd", ""));
		setEtadt(JSPUtil.getParameter(request, prefix + "etadt", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setGTongWgt(JSPUtil.getParameter(request, prefix + "g_tong_wgt", ""));
		setDischarge(JSPUtil.getParameter(request, prefix + "discharge", ""));
		setVname(JSPUtil.getParameter(request, prefix + "vname", ""));
		setNTongWgt(JSPUtil.getParameter(request, prefix + "n_tong_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManilaSearchVvdDtlVO[]
	 */
	public ManilaSearchVvdDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManilaSearchVvdDtlVO[]
	 */
	public ManilaSearchVvdDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManilaSearchVvdDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] regNumber = (JSPUtil.getParameter(request, prefix	+ "reg_number", length));
			String[] polcd = (JSPUtil.getParameter(request, prefix	+ "polcd", length));
			String[] etadt = (JSPUtil.getParameter(request, prefix	+ "etadt", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] gTongWgt = (JSPUtil.getParameter(request, prefix	+ "g_tong_wgt", length));
			String[] discharge = (JSPUtil.getParameter(request, prefix	+ "discharge", length));
			String[] vname = (JSPUtil.getParameter(request, prefix	+ "vname", length));
			String[] nTongWgt = (JSPUtil.getParameter(request, prefix	+ "n_tong_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManilaSearchVvdDtlVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (regNumber[i] != null)
					model.setRegNumber(regNumber[i]);
				if (polcd[i] != null)
					model.setPolcd(polcd[i]);
				if (etadt[i] != null)
					model.setEtadt(etadt[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (gTongWgt[i] != null)
					model.setGTongWgt(gTongWgt[i]);
				if (discharge[i] != null)
					model.setDischarge(discharge[i]);
				if (vname[i] != null)
					model.setVname(vname[i]);
				if (nTongWgt[i] != null)
					model.setNTongWgt(nTongWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManilaSearchVvdDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManilaSearchVvdDtlVO[]
	 */
	public ManilaSearchVvdDtlVO[] getManilaSearchVvdDtlVOs(){
		ManilaSearchVvdDtlVO[] vos = (ManilaSearchVvdDtlVO[])models.toArray(new ManilaSearchVvdDtlVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regNumber = this.regNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polcd = this.polcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etadt = this.etadt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gTongWgt = this.gTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discharge = this.discharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vname = this.vname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nTongWgt = this.nTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
