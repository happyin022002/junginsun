/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaArrHeaderCondVO.java
*@FileTitle : UsaArrHeaderCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class UsaArrHeaderCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaArrHeaderCondVO> models = new ArrayList<UsaArrHeaderCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vslLloyd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslFlag = null;
	/* Column Info */
	private String crrBatNo = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String tmpstr4 = null;
	/* Column Info */
	private String blCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaArrHeaderCondVO() {}

	public UsaArrHeaderCondVO(String ibflag, String pagerows, String vvd, String vslFlag, String blCnt, String vslEngNm, String tmpstr4, String vslLloyd, String vpsEtaDt, String crrBatNo) {
		this.vvd = vvd;
		this.vslLloyd = vslLloyd;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.vslFlag = vslFlag;
		this.crrBatNo = crrBatNo;
		this.vpsEtaDt = vpsEtaDt;
		this.tmpstr4 = tmpstr4;
		this.blCnt = blCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vsl_lloyd", getVslLloyd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_flag", getVslFlag());
		this.hashColumns.put("crr_bat_no", getCrrBatNo());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("tmpstr4", getTmpstr4());
		this.hashColumns.put("bl_cnt", getBlCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vsl_lloyd", "vslLloyd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_flag", "vslFlag");
		this.hashFields.put("crr_bat_no", "crrBatNo");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("tmpstr4", "tmpstr4");
		this.hashFields.put("bl_cnt", "blCnt");
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
	 * @return vslLloyd
	 */
	public String getVslLloyd() {
		return this.vslLloyd;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return vslFlag
	 */
	public String getVslFlag() {
		return this.vslFlag;
	}
	
	/**
	 * Column Info
	 * @return crrBatNo
	 */
	public String getCrrBatNo() {
		return this.crrBatNo;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return tmpstr4
	 */
	public String getTmpstr4() {
		return this.tmpstr4;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
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
	 * @param vslLloyd
	 */
	public void setVslLloyd(String vslLloyd) {
		this.vslLloyd = vslLloyd;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param vslFlag
	 */
	public void setVslFlag(String vslFlag) {
		this.vslFlag = vslFlag;
	}
	
	/**
	 * Column Info
	 * @param crrBatNo
	 */
	public void setCrrBatNo(String crrBatNo) {
		this.crrBatNo = crrBatNo;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param tmpstr4
	 */
	public void setTmpstr4(String tmpstr4) {
		this.tmpstr4 = tmpstr4;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
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
		setVslLloyd(JSPUtil.getParameter(request, prefix + "vsl_lloyd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setVslFlag(JSPUtil.getParameter(request, prefix + "vsl_flag", ""));
		setCrrBatNo(JSPUtil.getParameter(request, prefix + "crr_bat_no", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setTmpstr4(JSPUtil.getParameter(request, prefix + "tmpstr4", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaArrHeaderCondVO[]
	 */
	public UsaArrHeaderCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaArrHeaderCondVO[]
	 */
	public UsaArrHeaderCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaArrHeaderCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vslLloyd = (JSPUtil.getParameter(request, prefix	+ "vsl_lloyd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] vslFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_flag", length));
			String[] crrBatNo = (JSPUtil.getParameter(request, prefix	+ "crr_bat_no", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] tmpstr4 = (JSPUtil.getParameter(request, prefix	+ "tmpstr4", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaArrHeaderCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vslLloyd[i] != null)
					model.setVslLloyd(vslLloyd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslFlag[i] != null)
					model.setVslFlag(vslFlag[i]);
				if (crrBatNo[i] != null)
					model.setCrrBatNo(crrBatNo[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (tmpstr4[i] != null)
					model.setTmpstr4(tmpstr4[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaArrHeaderCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaArrHeaderCondVO[]
	 */
	public UsaArrHeaderCondVO[] getUsaArrHeaderCondVOs(){
		UsaArrHeaderCondVO[] vos = (UsaArrHeaderCondVO[])models.toArray(new UsaArrHeaderCondVO[models.size()]);
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
		this.vslLloyd = this.vslLloyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag = this.vslFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBatNo = this.crrBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpstr4 = this.tmpstr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
