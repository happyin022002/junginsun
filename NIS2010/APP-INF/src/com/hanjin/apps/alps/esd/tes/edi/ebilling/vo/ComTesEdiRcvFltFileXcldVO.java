/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TesEdiRcvFltFileXcldVO.java
*@FileTitle : TesEdiRcvFltFileXcldVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.edi.ebilling.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComTesEdiRcvFltFileXcldVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComTesEdiRcvFltFileXcldVO> models = new ArrayList<ComTesEdiRcvFltFileXcldVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dfltValCtnt = null;
	/* Column Info */
	private String qttnConcFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rplcValFlg = null;
	/* Column Info */
	private String rplcValCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ediVndrSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fltFileTagNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String savSeq = null;
	/* Column Info */
	private String ediRcvRuleMnSeq = null;
	/* Column Info */
	private String fltFileKeyNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComTesEdiRcvFltFileXcldVO() {}

	public ComTesEdiRcvFltFileXcldVO(String ibflag, String pagerows, String ediRcvRuleMnSeq, String ediVndrSeq, String fltFileTagNm, String fltFileKeyNm, String dfltValCtnt, String qttnConcFlg, String rplcValFlg, String rplcValCtnt, String creUsrId, String creDt, String updUsrId, String updDt, String savSeq) {
		this.updDt = updDt;
		this.dfltValCtnt = dfltValCtnt;
		this.qttnConcFlg = qttnConcFlg;
		this.creDt = creDt;
		this.rplcValFlg = rplcValFlg;
		this.rplcValCtnt = rplcValCtnt;
		this.pagerows = pagerows;
		this.ediVndrSeq = ediVndrSeq;
		this.ibflag = ibflag;
		this.fltFileTagNm = fltFileTagNm;
		this.creUsrId = creUsrId;
		this.savSeq = savSeq;
		this.ediRcvRuleMnSeq = ediRcvRuleMnSeq;
		this.fltFileKeyNm = fltFileKeyNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dflt_val_ctnt", getDfltValCtnt());
		this.hashColumns.put("qttn_conc_flg", getQttnConcFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rplc_val_flg", getRplcValFlg());
		this.hashColumns.put("rplc_val_ctnt", getRplcValCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("edi_vndr_seq", getEdiVndrSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flt_file_tag_nm", getFltFileTagNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("sav_seq", getSavSeq());
		this.hashColumns.put("edi_rcv_rule_mn_seq", getEdiRcvRuleMnSeq());
		this.hashColumns.put("flt_file_key_nm", getFltFileKeyNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dflt_val_ctnt", "dfltValCtnt");
		this.hashFields.put("qttn_conc_flg", "qttnConcFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rplc_val_flg", "rplcValFlg");
		this.hashFields.put("rplc_val_ctnt", "rplcValCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("edi_vndr_seq", "ediVndrSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flt_file_tag_nm", "fltFileTagNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("sav_seq", "savSeq");
		this.hashFields.put("edi_rcv_rule_mn_seq", "ediRcvRuleMnSeq");
		this.hashFields.put("flt_file_key_nm", "fltFileKeyNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return dfltValCtnt
	 */
	public String getDfltValCtnt() {
		return this.dfltValCtnt;
	}
	
	/**
	 * Column Info
	 * @return qttnConcFlg
	 */
	public String getQttnConcFlg() {
		return this.qttnConcFlg;
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
	 * @return rplcValFlg
	 */
	public String getRplcValFlg() {
		return this.rplcValFlg;
	}
	
	/**
	 * Column Info
	 * @return rplcValCtnt
	 */
	public String getRplcValCtnt() {
		return this.rplcValCtnt;
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
	 * @return ediVndrSeq
	 */
	public String getEdiVndrSeq() {
		return this.ediVndrSeq;
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
	 * @return fltFileTagNm
	 */
	public String getFltFileTagNm() {
		return this.fltFileTagNm;
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
	 * @return savSeq
	 */
	public String getSavSeq() {
		return this.savSeq;
	}
	
	/**
	 * Column Info
	 * @return ediRcvRuleMnSeq
	 */
	public String getEdiRcvRuleMnSeq() {
		return this.ediRcvRuleMnSeq;
	}
	
	/**
	 * Column Info
	 * @return fltFileKeyNm
	 */
	public String getFltFileKeyNm() {
		return this.fltFileKeyNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param dfltValCtnt
	 */
	public void setDfltValCtnt(String dfltValCtnt) {
		this.dfltValCtnt = dfltValCtnt;
	}
	
	/**
	 * Column Info
	 * @param qttnConcFlg
	 */
	public void setQttnConcFlg(String qttnConcFlg) {
		this.qttnConcFlg = qttnConcFlg;
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
	 * @param rplcValFlg
	 */
	public void setRplcValFlg(String rplcValFlg) {
		this.rplcValFlg = rplcValFlg;
	}
	
	/**
	 * Column Info
	 * @param rplcValCtnt
	 */
	public void setRplcValCtnt(String rplcValCtnt) {
		this.rplcValCtnt = rplcValCtnt;
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
	 * @param ediVndrSeq
	 */
	public void setEdiVndrSeq(String ediVndrSeq) {
		this.ediVndrSeq = ediVndrSeq;
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
	 * @param fltFileTagNm
	 */
	public void setFltFileTagNm(String fltFileTagNm) {
		this.fltFileTagNm = fltFileTagNm;
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
	 * @param savSeq
	 */
	public void setSavSeq(String savSeq) {
		this.savSeq = savSeq;
	}
	
	/**
	 * Column Info
	 * @param ediRcvRuleMnSeq
	 */
	public void setEdiRcvRuleMnSeq(String ediRcvRuleMnSeq) {
		this.ediRcvRuleMnSeq = ediRcvRuleMnSeq;
	}
	
	/**
	 * Column Info
	 * @param fltFileKeyNm
	 */
	public void setFltFileKeyNm(String fltFileKeyNm) {
		this.fltFileKeyNm = fltFileKeyNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDfltValCtnt(JSPUtil.getParameter(request, prefix + "dflt_val_ctnt", ""));
		setQttnConcFlg(JSPUtil.getParameter(request, prefix + "qttn_conc_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRplcValFlg(JSPUtil.getParameter(request, prefix + "rplc_val_flg", ""));
		setRplcValCtnt(JSPUtil.getParameter(request, prefix + "rplc_val_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEdiVndrSeq(JSPUtil.getParameter(request, prefix + "edi_vndr_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFltFileTagNm(JSPUtil.getParameter(request, prefix + "flt_file_tag_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSavSeq(JSPUtil.getParameter(request, prefix + "sav_seq", ""));
		setEdiRcvRuleMnSeq(JSPUtil.getParameter(request, prefix + "edi_rcv_rule_mn_seq", ""));
		setFltFileKeyNm(JSPUtil.getParameter(request, prefix + "flt_file_key_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesEdiRcvFltFileXcldVO[]
	 */
	public ComTesEdiRcvFltFileXcldVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesEdiRcvFltFileXcldVO[]
	 */
	public ComTesEdiRcvFltFileXcldVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComTesEdiRcvFltFileXcldVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dfltValCtnt = (JSPUtil.getParameter(request, prefix	+ "dflt_val_ctnt", length));
			String[] qttnConcFlg = (JSPUtil.getParameter(request, prefix	+ "qttn_conc_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rplcValFlg = (JSPUtil.getParameter(request, prefix	+ "rplc_val_flg", length));
			String[] rplcValCtnt = (JSPUtil.getParameter(request, prefix	+ "rplc_val_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ediVndrSeq = (JSPUtil.getParameter(request, prefix	+ "edi_vndr_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fltFileTagNm = (JSPUtil.getParameter(request, prefix	+ "flt_file_tag_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] savSeq = (JSPUtil.getParameter(request, prefix	+ "sav_seq", length));
			String[] ediRcvRuleMnSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_rule_mn_seq", length));
			String[] fltFileKeyNm = (JSPUtil.getParameter(request, prefix	+ "flt_file_key_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComTesEdiRcvFltFileXcldVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dfltValCtnt[i] != null)
					model.setDfltValCtnt(dfltValCtnt[i]);
				if (qttnConcFlg[i] != null)
					model.setQttnConcFlg(qttnConcFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rplcValFlg[i] != null)
					model.setRplcValFlg(rplcValFlg[i]);
				if (rplcValCtnt[i] != null)
					model.setRplcValCtnt(rplcValCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ediVndrSeq[i] != null)
					model.setEdiVndrSeq(ediVndrSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fltFileTagNm[i] != null)
					model.setFltFileTagNm(fltFileTagNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (savSeq[i] != null)
					model.setSavSeq(savSeq[i]);
				if (ediRcvRuleMnSeq[i] != null)
					model.setEdiRcvRuleMnSeq(ediRcvRuleMnSeq[i]);
				if (fltFileKeyNm[i] != null)
					model.setFltFileKeyNm(fltFileKeyNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesEdiRcvFltFileXcldVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesEdiRcvFltFileXcldVO[]
	 */
	public ComTesEdiRcvFltFileXcldVO[] getTesEdiRcvFltFileXcldVOs(){
		ComTesEdiRcvFltFileXcldVO[] vos = (ComTesEdiRcvFltFileXcldVO[])models.toArray(new ComTesEdiRcvFltFileXcldVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltValCtnt = this.dfltValCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnConcFlg = this.qttnConcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplcValFlg = this.rplcValFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplcValCtnt = this.rplcValCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVndrSeq = this.ediVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileTagNm = this.fltFileTagNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savSeq = this.savSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvRuleMnSeq = this.ediRcvRuleMnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileKeyNm = this.fltFileKeyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
