/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmendAuthRefUserVO.java
*@FileTitle : ChargeAmendAuthRefUserVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.22
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2015.01.22 김진주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김진주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeAmendAuthRefUserVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeAmendAuthRefUserVO> models = new ArrayList<ChargeAmendAuthRefUserVO>();
	
	/* Column Info */
	private String aproRqstRefTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aproRqstRefUsrEml = null;
	/* Column Info */
	private String chgAmdSeq = null;
	/* Column Info */
	private String aproRqstRefUsrId = null;
	/* Column Info */
	private String aproRqstRefUsrSeq = null;
	/* Column Info */
	private String aproRqstRefUsrOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChargeAmendAuthRefUserVO() {}

	public ChargeAmendAuthRefUserVO(String ibflag, String pagerows, String bkgNo, String chgAmdSeq, String aproRqstRefTpCd, String aproRqstRefUsrSeq, String aproRqstRefUsrOfcCd, String aproRqstRefUsrId, String aproRqstRefUsrEml, String creUsrId, String updUsrId) {
		this.aproRqstRefTpCd = aproRqstRefTpCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.aproRqstRefUsrEml = aproRqstRefUsrEml;
		this.chgAmdSeq = chgAmdSeq;
		this.aproRqstRefUsrId = aproRqstRefUsrId;
		this.aproRqstRefUsrSeq = aproRqstRefUsrSeq;
		this.aproRqstRefUsrOfcCd = aproRqstRefUsrOfcCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_rqst_ref_tp_cd", getAproRqstRefTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("apro_rqst_ref_usr_eml", getAproRqstRefUsrEml());
		this.hashColumns.put("chg_amd_seq", getChgAmdSeq());
		this.hashColumns.put("apro_rqst_ref_usr_id", getAproRqstRefUsrId());
		this.hashColumns.put("apro_rqst_ref_usr_seq", getAproRqstRefUsrSeq());
		this.hashColumns.put("apro_rqst_ref_usr_ofc_cd", getAproRqstRefUsrOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_rqst_ref_tp_cd", "aproRqstRefTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("apro_rqst_ref_usr_eml", "aproRqstRefUsrEml");
		this.hashFields.put("chg_amd_seq", "chgAmdSeq");
		this.hashFields.put("apro_rqst_ref_usr_id", "aproRqstRefUsrId");
		this.hashFields.put("apro_rqst_ref_usr_seq", "aproRqstRefUsrSeq");
		this.hashFields.put("apro_rqst_ref_usr_ofc_cd", "aproRqstRefUsrOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aproRqstRefTpCd
	 */
	public String getAproRqstRefTpCd() {
		return this.aproRqstRefTpCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return aproRqstRefUsrEml
	 */
	public String getAproRqstRefUsrEml() {
		return this.aproRqstRefUsrEml;
	}
	
	/**
	 * Column Info
	 * @return chgAmdSeq
	 */
	public String getChgAmdSeq() {
		return this.chgAmdSeq;
	}
	
	/**
	 * Column Info
	 * @return aproRqstRefUsrId
	 */
	public String getAproRqstRefUsrId() {
		return this.aproRqstRefUsrId;
	}
	
	/**
	 * Column Info
	 * @return aproRqstRefUsrSeq
	 */
	public String getAproRqstRefUsrSeq() {
		return this.aproRqstRefUsrSeq;
	}
	
	/**
	 * Column Info
	 * @return aproRqstRefUsrOfcCd
	 */
	public String getAproRqstRefUsrOfcCd() {
		return this.aproRqstRefUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param aproRqstRefTpCd
	 */
	public void setAproRqstRefTpCd(String aproRqstRefTpCd) {
		this.aproRqstRefTpCd = aproRqstRefTpCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param aproRqstRefUsrEml
	 */
	public void setAproRqstRefUsrEml(String aproRqstRefUsrEml) {
		this.aproRqstRefUsrEml = aproRqstRefUsrEml;
	}
	
	/**
	 * Column Info
	 * @param chgAmdSeq
	 */
	public void setChgAmdSeq(String chgAmdSeq) {
		this.chgAmdSeq = chgAmdSeq;
	}
	
	/**
	 * Column Info
	 * @param aproRqstRefUsrId
	 */
	public void setAproRqstRefUsrId(String aproRqstRefUsrId) {
		this.aproRqstRefUsrId = aproRqstRefUsrId;
	}
	
	/**
	 * Column Info
	 * @param aproRqstRefUsrSeq
	 */
	public void setAproRqstRefUsrSeq(String aproRqstRefUsrSeq) {
		this.aproRqstRefUsrSeq = aproRqstRefUsrSeq;
	}
	
	/**
	 * Column Info
	 * @param aproRqstRefUsrOfcCd
	 */
	public void setAproRqstRefUsrOfcCd(String aproRqstRefUsrOfcCd) {
		this.aproRqstRefUsrOfcCd = aproRqstRefUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setAproRqstRefTpCd(JSPUtil.getParameter(request, prefix + "apro_rqst_ref_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAproRqstRefUsrEml(JSPUtil.getParameter(request, prefix + "apro_rqst_ref_usr_eml", ""));
		setChgAmdSeq(JSPUtil.getParameter(request, prefix + "chg_amd_seq", ""));
		setAproRqstRefUsrId(JSPUtil.getParameter(request, prefix + "apro_rqst_ref_usr_id", ""));
		setAproRqstRefUsrSeq(JSPUtil.getParameter(request, prefix + "apro_rqst_ref_usr_seq", ""));
		setAproRqstRefUsrOfcCd(JSPUtil.getParameter(request, prefix + "apro_rqst_ref_usr_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeAmendAuthRefUserVO[]
	 */
	public ChargeAmendAuthRefUserVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeAmendAuthRefUserVO[]
	 */
	public ChargeAmendAuthRefUserVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeAmendAuthRefUserVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproRqstRefTpCd = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_ref_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aproRqstRefUsrEml = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_ref_usr_eml", length));
			String[] chgAmdSeq = (JSPUtil.getParameter(request, prefix	+ "chg_amd_seq", length));
			String[] aproRqstRefUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_ref_usr_id", length));
			String[] aproRqstRefUsrSeq = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_ref_usr_seq", length));
			String[] aproRqstRefUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_ref_usr_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeAmendAuthRefUserVO();
				if (aproRqstRefTpCd[i] != null)
					model.setAproRqstRefTpCd(aproRqstRefTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aproRqstRefUsrEml[i] != null)
					model.setAproRqstRefUsrEml(aproRqstRefUsrEml[i]);
				if (chgAmdSeq[i] != null)
					model.setChgAmdSeq(chgAmdSeq[i]);
				if (aproRqstRefUsrId[i] != null)
					model.setAproRqstRefUsrId(aproRqstRefUsrId[i]);
				if (aproRqstRefUsrSeq[i] != null)
					model.setAproRqstRefUsrSeq(aproRqstRefUsrSeq[i]);
				if (aproRqstRefUsrOfcCd[i] != null)
					model.setAproRqstRefUsrOfcCd(aproRqstRefUsrOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeAmendAuthRefUserVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeAmendAuthRefUserVO[]
	 */
	public ChargeAmendAuthRefUserVO[] getChargeAmendAuthRefUserVOs(){
		ChargeAmendAuthRefUserVO[] vos = (ChargeAmendAuthRefUserVO[])models.toArray(new ChargeAmendAuthRefUserVO[models.size()]);
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
		this.aproRqstRefTpCd = this.aproRqstRefTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstRefUsrEml = this.aproRqstRefUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmdSeq = this.chgAmdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstRefUsrId = this.aproRqstRefUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstRefUsrSeq = this.aproRqstRefUsrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstRefUsrOfcCd = this.aproRqstRefUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
