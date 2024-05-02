/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HldNtcStaffInfoVO.java
*@FileTitle : HldNtcStaffInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.10.22 박미옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author 박미옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HldNtcStaffInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HldNtcStaffInfoVO> models = new ArrayList<HldNtcStaffInfoVO>();
	
	/* Column Info */
	private String ntcEml = null;
	/* Column Info */
	private String cstmsLocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ntcMzdCd = null;
	/* Column Info */
	private String ntcUsrNm = null;
	/* Column Info */
	private String ntcEnblFlg = null;
	/* Column Info */
	private String ntcUsrId = null;
	/* Column Info */
	private String hldSeq = null;
	/* Column Info */
	private String cstmsDspoCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HldNtcStaffInfoVO() {}

	public HldNtcStaffInfoVO(String ibflag, String pagerows, String hldSeq, String cstmsLocCd, String ntcUsrId, String cstmsDspoCd, String ntcMzdCd, String ntcEnblFlg, String ntcEml, String ntcUsrNm) {
		this.ntcEml = ntcEml;
		this.cstmsLocCd = cstmsLocCd;
		this.ibflag = ibflag;
		this.ntcMzdCd = ntcMzdCd;
		this.ntcUsrNm = ntcUsrNm;
		this.ntcEnblFlg = ntcEnblFlg;
		this.ntcUsrId = ntcUsrId;
		this.hldSeq = hldSeq;
		this.cstmsDspoCd = cstmsDspoCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("cstms_loc_cd", getCstmsLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ntc_mzd_cd", getNtcMzdCd());
		this.hashColumns.put("ntc_usr_nm", getNtcUsrNm());
		this.hashColumns.put("ntc_enbl_flg", getNtcEnblFlg());
		this.hashColumns.put("ntc_usr_id", getNtcUsrId());
		this.hashColumns.put("hld_seq", getHldSeq());
		this.hashColumns.put("cstms_dspo_cd", getCstmsDspoCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("cstms_loc_cd", "cstmsLocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ntc_mzd_cd", "ntcMzdCd");
		this.hashFields.put("ntc_usr_nm", "ntcUsrNm");
		this.hashFields.put("ntc_enbl_flg", "ntcEnblFlg");
		this.hashFields.put("ntc_usr_id", "ntcUsrId");
		this.hashFields.put("hld_seq", "hldSeq");
		this.hashFields.put("cstms_dspo_cd", "cstmsDspoCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ntcEml
	 */
	public String getNtcEml() {
		return this.ntcEml;
	}
	
	/**
	 * Column Info
	 * @return cstmsLocCd
	 */
	public String getCstmsLocCd() {
		return this.cstmsLocCd;
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
	 * @return ntcMzdCd
	 */
	public String getNtcMzdCd() {
		return this.ntcMzdCd;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrNm
	 */
	public String getNtcUsrNm() {
		return this.ntcUsrNm;
	}
	
	/**
	 * Column Info
	 * @return ntcEnblFlg
	 */
	public String getNtcEnblFlg() {
		return this.ntcEnblFlg;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId
	 */
	public String getNtcUsrId() {
		return this.ntcUsrId;
	}
	
	/**
	 * Column Info
	 * @return hldSeq
	 */
	public String getHldSeq() {
		return this.hldSeq;
	}
	
	/**
	 * Column Info
	 * @return cstmsDspoCd
	 */
	public String getCstmsDspoCd() {
		return this.cstmsDspoCd;
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
	 * @param ntcEml
	 */
	public void setNtcEml(String ntcEml) {
		this.ntcEml = ntcEml;
	}
	
	/**
	 * Column Info
	 * @param cstmsLocCd
	 */
	public void setCstmsLocCd(String cstmsLocCd) {
		this.cstmsLocCd = cstmsLocCd;
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
	 * @param ntcMzdCd
	 */
	public void setNtcMzdCd(String ntcMzdCd) {
		this.ntcMzdCd = ntcMzdCd;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrNm
	 */
	public void setNtcUsrNm(String ntcUsrNm) {
		this.ntcUsrNm = ntcUsrNm;
	}
	
	/**
	 * Column Info
	 * @param ntcEnblFlg
	 */
	public void setNtcEnblFlg(String ntcEnblFlg) {
		this.ntcEnblFlg = ntcEnblFlg;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId
	 */
	public void setNtcUsrId(String ntcUsrId) {
		this.ntcUsrId = ntcUsrId;
	}
	
	/**
	 * Column Info
	 * @param hldSeq
	 */
	public void setHldSeq(String hldSeq) {
		this.hldSeq = hldSeq;
	}
	
	/**
	 * Column Info
	 * @param cstmsDspoCd
	 */
	public void setCstmsDspoCd(String cstmsDspoCd) {
		this.cstmsDspoCd = cstmsDspoCd;
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
		setNtcEml(JSPUtil.getParameter(request, "ntc_eml", ""));
		setCstmsLocCd(JSPUtil.getParameter(request, "cstms_loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNtcMzdCd(JSPUtil.getParameter(request, "ntc_mzd_cd", ""));
		setNtcUsrNm(JSPUtil.getParameter(request, "ntc_usr_nm", ""));
		setNtcEnblFlg(JSPUtil.getParameter(request, "ntc_enbl_flg", ""));
		setNtcUsrId(JSPUtil.getParameter(request, "ntc_usr_id", ""));
		setHldSeq(JSPUtil.getParameter(request, "hld_seq", ""));
		setCstmsDspoCd(JSPUtil.getParameter(request, "cstms_dspo_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HldNtcStaffInfoVO[]
	 */
	public HldNtcStaffInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HldNtcStaffInfoVO[]
	 */
	public HldNtcStaffInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HldNtcStaffInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml", length));
			String[] cstmsLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ntcMzdCd = (JSPUtil.getParameter(request, prefix	+ "ntc_mzd_cd", length));
			String[] ntcUsrNm = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_nm", length));
			String[] ntcEnblFlg = (JSPUtil.getParameter(request, prefix	+ "ntc_enbl_flg", length));
			String[] ntcUsrId = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id", length));
			String[] hldSeq = (JSPUtil.getParameter(request, prefix	+ "hld_seq", length));
			String[] cstmsDspoCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dspo_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new HldNtcStaffInfoVO();
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (cstmsLocCd[i] != null)
					model.setCstmsLocCd(cstmsLocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ntcMzdCd[i] != null)
					model.setNtcMzdCd(ntcMzdCd[i]);
				if (ntcUsrNm[i] != null)
					model.setNtcUsrNm(ntcUsrNm[i]);
				if (ntcEnblFlg[i] != null)
					model.setNtcEnblFlg(ntcEnblFlg[i]);
				if (ntcUsrId[i] != null)
					model.setNtcUsrId(ntcUsrId[i]);
				if (hldSeq[i] != null)
					model.setHldSeq(hldSeq[i]);
				if (cstmsDspoCd[i] != null)
					model.setCstmsDspoCd(cstmsDspoCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHldNtcStaffInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HldNtcStaffInfoVO[]
	 */
	public HldNtcStaffInfoVO[] getHldNtcStaffInfoVOs(){
		HldNtcStaffInfoVO[] vos = (HldNtcStaffInfoVO[])models.toArray(new HldNtcStaffInfoVO[models.size()]);
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
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsLocCd = this.cstmsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcMzdCd = this.ntcMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrNm = this.ntcUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEnblFlg = this.ntcEnblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId = this.ntcUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldSeq = this.hldSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDspoCd = this.cstmsDspoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
