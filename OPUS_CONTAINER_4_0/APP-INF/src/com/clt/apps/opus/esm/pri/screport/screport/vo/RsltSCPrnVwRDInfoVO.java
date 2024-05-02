/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltSCPrnVwRDInfoVO.java
*@FileTitle : RsltSCPrnVwRDInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.04  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

import java.lang.reflect.Field;
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

public class RsltSCPrnVwRDInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSCPrnVwRDInfoVO> models = new ArrayList<RsltSCPrnVwRDInfoVO>();
	
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String propSrepCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String blplAmdtFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String aproUsrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSCPrnVwRDInfoVO() {}

	public RsltSCPrnVwRDInfoVO(String ibflag, String pagerows, String scNo, String propNo, String amdtSeq, String effDt, String expDt, String fileDt, String propOfcCd, String propSrepCd, String propAproOfcCd, String creDt, String aproUsrNm, String aproUsrFlg, String blplAmdtFlg) {
		this.fileDt = fileDt;
		this.propSrepCd = propSrepCd;
		this.amdtSeq = amdtSeq;
		this.creDt = creDt;
		this.aproUsrNm = aproUsrNm;
		this.blplAmdtFlg = blplAmdtFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.propOfcCd = propOfcCd;
		this.propAproOfcCd = propAproOfcCd;
		this.propNo = propNo;
		this.scNo = scNo;
		this.expDt = expDt;
		this.aproUsrFlg = aproUsrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("prop_srep_cd", getPropSrepCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("blpl_amdt_flg", getBlplAmdtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("apro_usr_flg", getAproUsrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("prop_srep_cd", "propSrepCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("blpl_amdt_flg", "blplAmdtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("apro_usr_flg", "aproUsrFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return propSrepCd
	 */
	public String getPropSrepCd() {
		return this.propSrepCd;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return blplAmdtFlg
	 */
	public String getBlplAmdtFlg() {
		return this.blplAmdtFlg;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return propAproOfcCd
	 */
	public String getPropAproOfcCd() {
		return this.propAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return aproUsrFlg
	 */
	public String getAproUsrFlg() {
		return this.aproUsrFlg;
	}
	

	/**
	 * Column Info
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param propSrepCd
	 */
	public void setPropSrepCd(String propSrepCd) {
		this.propSrepCd = propSrepCd;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param blplAmdtFlg
	 */
	public void setBlplAmdtFlg(String blplAmdtFlg) {
		this.blplAmdtFlg = blplAmdtFlg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @param propAproOfcCd
	 */
	public void setPropAproOfcCd(String propAproOfcCd) {
		this.propAproOfcCd = propAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param aproUsrFlg
	 */
	public void setAproUsrFlg(String aproUsrFlg) {
		this.aproUsrFlg = aproUsrFlg;
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
		setFileDt(JSPUtil.getParameter(request, prefix + "file_dt", ""));
		setPropSrepCd(JSPUtil.getParameter(request, prefix + "prop_srep_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setBlplAmdtFlg(JSPUtil.getParameter(request, prefix + "blpl_amdt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, prefix + "prop_apro_ofc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setAproUsrFlg(JSPUtil.getParameter(request, prefix + "apro_usr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSCPrnVwRDInfoVO[]
	 */
	public RsltSCPrnVwRDInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSCPrnVwRDInfoVO[]
	 */
	public RsltSCPrnVwRDInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSCPrnVwRDInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] propSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_srep_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] blplAmdtFlg = (JSPUtil.getParameter(request, prefix	+ "blpl_amdt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] aproUsrFlg = (JSPUtil.getParameter(request, prefix	+ "apro_usr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSCPrnVwRDInfoVO();
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (propSrepCd[i] != null)
					model.setPropSrepCd(propSrepCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (blplAmdtFlg[i] != null)
					model.setBlplAmdtFlg(blplAmdtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (aproUsrFlg[i] != null)
					model.setAproUsrFlg(aproUsrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSCPrnVwRDInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSCPrnVwRDInfoVO[]
	 */
	public RsltSCPrnVwRDInfoVO[] getRsltSCPrnVwRDInfoVOs(){
		RsltSCPrnVwRDInfoVO[] vos = (RsltSCPrnVwRDInfoVO[])models.toArray(new RsltSCPrnVwRDInfoVO[models.size()]);
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
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepCd = this.propSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplAmdtFlg = this.blplAmdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrFlg = this.aproUsrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
