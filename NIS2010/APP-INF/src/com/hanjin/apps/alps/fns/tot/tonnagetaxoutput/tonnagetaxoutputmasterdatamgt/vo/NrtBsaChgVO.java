/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : NrtBsaChgVO.java
*@FileTitle : NrtBsaChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.03
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2012.01.03 이준범 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이준범
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NrtBsaChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NrtBsaChgVO> models = new ArrayList<NrtBsaChgVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String stlYrmon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nrtAft = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String nrtBfr = null;
	/* Column Info */
	private String bsaBfr = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bsaAft = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NrtBsaChgVO() {}

	public NrtBsaChgVO(String ibflag, String pagerows, String stlYrmon, String slanCd, String vslCd, String vvd, String nrtBfr, String nrtAft, String bsaBfr, String bsaAft, String updUsrId) {
		this.vvd = vvd;
		this.vslCd = vslCd;
		this.stlYrmon = stlYrmon;
		this.ibflag = ibflag;
		this.nrtAft = nrtAft;
		this.slanCd = slanCd;
		this.nrtBfr = nrtBfr;
		this.bsaBfr = bsaBfr;
		this.updUsrId = updUsrId;
		this.bsaAft = bsaAft;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("stl_yrmon", getStlYrmon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nrt_aft", getNrtAft());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("nrt_bfr", getNrtBfr());
		this.hashColumns.put("bsa_bfr", getBsaBfr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bsa_aft", getBsaAft());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("stl_yrmon", "stlYrmon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nrt_aft", "nrtAft");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("nrt_bfr", "nrtBfr");
		this.hashFields.put("bsa_bfr", "bsaBfr");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bsa_aft", "bsaAft");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return stlYrmon
	 */
	public String getStlYrmon() {
		return this.stlYrmon;
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
	 * @return nrtAft
	 */
	public String getNrtAft() {
		return this.nrtAft;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return nrtBfr
	 */
	public String getNrtBfr() {
		return this.nrtBfr;
	}
	
	/**
	 * Column Info
	 * @return bsaBfr
	 */
	public String getBsaBfr() {
		return this.bsaBfr;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return bsaAft
	 */
	public String getBsaAft() {
		return this.bsaAft;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param stlYrmon
	 */
	public void setStlYrmon(String stlYrmon) {
		this.stlYrmon = stlYrmon;
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
	 * @param nrtAft
	 */
	public void setNrtAft(String nrtAft) {
		this.nrtAft = nrtAft;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param nrtBfr
	 */
	public void setNrtBfr(String nrtBfr) {
		this.nrtBfr = nrtBfr;
	}
	
	/**
	 * Column Info
	 * @param bsaBfr
	 */
	public void setBsaBfr(String bsaBfr) {
		this.bsaBfr = bsaBfr;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param bsaAft
	 */
	public void setBsaAft(String bsaAft) {
		this.bsaAft = bsaAft;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setStlYrmon(JSPUtil.getParameter(request, prefix + "stl_yrmon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNrtAft(JSPUtil.getParameter(request, prefix + "nrt_aft", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setNrtBfr(JSPUtil.getParameter(request, prefix + "nrt_bfr", ""));
		setBsaBfr(JSPUtil.getParameter(request, prefix + "bsa_bfr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBsaAft(JSPUtil.getParameter(request, prefix + "bsa_aft", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NrtBsaChgVO[]
	 */
	public NrtBsaChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NrtBsaChgVO[]
	 */
	public NrtBsaChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NrtBsaChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] stlYrmon = (JSPUtil.getParameter(request, prefix	+ "stl_yrmon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nrtAft = (JSPUtil.getParameter(request, prefix	+ "nrt_aft", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] nrtBfr = (JSPUtil.getParameter(request, prefix	+ "nrt_bfr", length));
			String[] bsaBfr = (JSPUtil.getParameter(request, prefix	+ "bsa_bfr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bsaAft = (JSPUtil.getParameter(request, prefix	+ "bsa_aft", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new NrtBsaChgVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (stlYrmon[i] != null)
					model.setStlYrmon(stlYrmon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nrtAft[i] != null)
					model.setNrtAft(nrtAft[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (nrtBfr[i] != null)
					model.setNrtBfr(nrtBfr[i]);
				if (bsaBfr[i] != null)
					model.setBsaBfr(bsaBfr[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bsaAft[i] != null)
					model.setBsaAft(bsaAft[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNrtBsaChgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NrtBsaChgVO[]
	 */
	public NrtBsaChgVO[] getNrtBsaChgVOs(){
		NrtBsaChgVO[] vos = (NrtBsaChgVO[])models.toArray(new NrtBsaChgVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlYrmon = this.stlYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrtAft = this.nrtAft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrtBfr = this.nrtBfr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaBfr = this.bsaBfr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaAft = this.bsaAft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
