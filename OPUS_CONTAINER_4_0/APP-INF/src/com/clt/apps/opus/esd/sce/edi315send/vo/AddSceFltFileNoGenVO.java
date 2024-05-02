/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AddSceFltFileNoGenVO.java
*@FileTitle : AddSceFltFileNoGenVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.10.28 전병석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.edi315send.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AddSceFltFileNoGenVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AddSceFltFileNoGenVO> models = new ArrayList<AddSceFltFileNoGenVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ediStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ediSndSeq = null;
	/* Column Info */
	private String ediSndYrmondy = null;
	/* Column Info */
	private String ediSndDesc = null;
	/* Column Info */
	private String rsltFlg = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AddSceFltFileNoGenVO() {}

	public AddSceFltFileNoGenVO(String ibflag, String pagerows, String ediSndYrmondy, String ediSndSeq, String ediSndDesc, String rsltFlg, String ediStsCd, String blNo, String bkgNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.ediStsCd = ediStsCd;
		this.creDt = creDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.ediSndSeq = ediSndSeq;
		this.ediSndYrmondy = ediSndYrmondy;
		this.ediSndDesc = ediSndDesc;
		this.rsltFlg = rsltFlg;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("edi_sts_cd", getEdiStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("edi_snd_seq", getEdiSndSeq());
		this.hashColumns.put("edi_snd_yrmondy", getEdiSndYrmondy());
		this.hashColumns.put("edi_snd_desc", getEdiSndDesc());
		this.hashColumns.put("rslt_flg", getRsltFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("edi_sts_cd", "ediStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("edi_snd_seq", "ediSndSeq");
		this.hashFields.put("edi_snd_yrmondy", "ediSndYrmondy");
		this.hashFields.put("edi_snd_desc", "ediSndDesc");
		this.hashFields.put("rslt_flg", "rsltFlg");
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
	 * @return ediStsCd
	 */
	public String getEdiStsCd() {
		return this.ediStsCd;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return ediSndSeq
	 */
	public String getEdiSndSeq() {
		return this.ediSndSeq;
	}
	
	/**
	 * Column Info
	 * @return ediSndYrmondy
	 */
	public String getEdiSndYrmondy() {
		return this.ediSndYrmondy;
	}
	
	/**
	 * Column Info
	 * @return ediSndDesc
	 */
	public String getEdiSndDesc() {
		return this.ediSndDesc;
	}
	
	/**
	 * Column Info
	 * @return rsltFlg
	 */
	public String getRsltFlg() {
		return this.rsltFlg;
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
	 * @param ediStsCd
	 */
	public void setEdiStsCd(String ediStsCd) {
		this.ediStsCd = ediStsCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param ediSndSeq
	 */
	public void setEdiSndSeq(String ediSndSeq) {
		this.ediSndSeq = ediSndSeq;
	}
	
	/**
	 * Column Info
	 * @param ediSndYrmondy
	 */
	public void setEdiSndYrmondy(String ediSndYrmondy) {
		this.ediSndYrmondy = ediSndYrmondy;
	}
	
	/**
	 * Column Info
	 * @param ediSndDesc
	 */
	public void setEdiSndDesc(String ediSndDesc) {
		this.ediSndDesc = ediSndDesc;
	}
	
	/**
	 * Column Info
	 * @param rsltFlg
	 */
	public void setRsltFlg(String rsltFlg) {
		this.rsltFlg = rsltFlg;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setEdiStsCd(JSPUtil.getParameter(request, "edi_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEdiSndSeq(JSPUtil.getParameter(request, "edi_snd_seq", ""));
		setEdiSndYrmondy(JSPUtil.getParameter(request, "edi_snd_yrmondy", ""));
		setEdiSndDesc(JSPUtil.getParameter(request, "edi_snd_desc", ""));
		setRsltFlg(JSPUtil.getParameter(request, "rslt_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AddSceFltFileNoGenVO[]
	 */
	public AddSceFltFileNoGenVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AddSceFltFileNoGenVO[]
	 */
	public AddSceFltFileNoGenVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AddSceFltFileNoGenVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ediStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ediSndSeq = (JSPUtil.getParameter(request, prefix	+ "edi_snd_seq", length));
			String[] ediSndYrmondy = (JSPUtil.getParameter(request, prefix	+ "edi_snd_yrmondy", length));
			String[] ediSndDesc = (JSPUtil.getParameter(request, prefix	+ "edi_snd_desc", length));
			String[] rsltFlg = (JSPUtil.getParameter(request, prefix	+ "rslt_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new AddSceFltFileNoGenVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ediStsCd[i] != null)
					model.setEdiStsCd(ediStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ediSndSeq[i] != null)
					model.setEdiSndSeq(ediSndSeq[i]);
				if (ediSndYrmondy[i] != null)
					model.setEdiSndYrmondy(ediSndYrmondy[i]);
				if (ediSndDesc[i] != null)
					model.setEdiSndDesc(ediSndDesc[i]);
				if (rsltFlg[i] != null)
					model.setRsltFlg(rsltFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAddSceFltFileNoGenVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AddSceFltFileNoGenVO[]
	 */
	public AddSceFltFileNoGenVO[] getAddSceFltFileNoGenVOs(){
		AddSceFltFileNoGenVO[] vos = (AddSceFltFileNoGenVO[])models.toArray(new AddSceFltFileNoGenVO[models.size()]);
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
		this.ediStsCd = this.ediStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndSeq = this.ediSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndYrmondy = this.ediSndYrmondy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDesc = this.ediSndDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltFlg = this.rsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
