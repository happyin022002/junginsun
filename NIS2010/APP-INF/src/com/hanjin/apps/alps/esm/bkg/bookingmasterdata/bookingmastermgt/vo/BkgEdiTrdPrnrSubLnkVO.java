/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgEdiTrdPrnrSubLnkVO.java
*@FileTitle : BkgEdiTrdPrnrSubLnkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.10.06 이일민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 이일민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgEdiTrdPrnrSubLnkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgEdiTrdPrnrSubLnkVO> models = new ArrayList<BkgEdiTrdPrnrSubLnkVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String prnrSubLnkDivCd = null;
	/* Column Info */
	private String sndrTrdPrnrId = null;
	/* Column Info */
	private String trdPrnrSubLnkSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String prnrPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rcvrTrdPrnrId = null;
	/* Column Info */
	private String prnrSubLnkCd = null;
	/* Column Info */
	private String ediSndFlg = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgEdiTrdPrnrSubLnkVO() {}

	public BkgEdiTrdPrnrSubLnkVO(String ibflag, String pagerows, String trdPrnrSubLnkSeq, String prnrSubLnkDivCd, String prnrSubLnkCd, String sndrTrdPrnrId, String rcvrTrdPrnrId, String prnrPortCd, String ediSndFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.prnrSubLnkDivCd = prnrSubLnkDivCd;
		this.sndrTrdPrnrId = sndrTrdPrnrId;
		this.trdPrnrSubLnkSeq = trdPrnrSubLnkSeq;
		this.creDt = creDt;
		this.prnrPortCd = prnrPortCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.rcvrTrdPrnrId = rcvrTrdPrnrId;
		this.prnrSubLnkCd = prnrSubLnkCd;
		this.ediSndFlg = ediSndFlg;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("prnr_sub_lnk_div_cd", getPrnrSubLnkDivCd());
		this.hashColumns.put("sndr_trd_prnr_id", getSndrTrdPrnrId());
		this.hashColumns.put("trd_prnr_sub_lnk_seq", getTrdPrnrSubLnkSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("prnr_port_cd", getPrnrPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rcvr_trd_prnr_id", getRcvrTrdPrnrId());
		this.hashColumns.put("prnr_sub_lnk_cd", getPrnrSubLnkCd());
		this.hashColumns.put("edi_snd_flg", getEdiSndFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("prnr_sub_lnk_div_cd", "prnrSubLnkDivCd");
		this.hashFields.put("sndr_trd_prnr_id", "sndrTrdPrnrId");
		this.hashFields.put("trd_prnr_sub_lnk_seq", "trdPrnrSubLnkSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("prnr_port_cd", "prnrPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rcvr_trd_prnr_id", "rcvrTrdPrnrId");
		this.hashFields.put("prnr_sub_lnk_cd", "prnrSubLnkCd");
		this.hashFields.put("edi_snd_flg", "ediSndFlg");
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
	 * @return prnrSubLnkDivCd
	 */
	public String getPrnrSubLnkDivCd() {
		return this.prnrSubLnkDivCd;
	}
	
	/**
	 * Column Info
	 * @return sndrTrdPrnrId
	 */
	public String getSndrTrdPrnrId() {
		return this.sndrTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return trdPrnrSubLnkSeq
	 */
	public String getTrdPrnrSubLnkSeq() {
		return this.trdPrnrSubLnkSeq;
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
	 * @return prnrPortCd
	 */
	public String getPrnrPortCd() {
		return this.prnrPortCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return rcvrTrdPrnrId
	 */
	public String getRcvrTrdPrnrId() {
		return this.rcvrTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return prnrSubLnkCd
	 */
	public String getPrnrSubLnkCd() {
		return this.prnrSubLnkCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndFlg
	 */
	public String getEdiSndFlg() {
		return this.ediSndFlg;
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
	 * @param prnrSubLnkDivCd
	 */
	public void setPrnrSubLnkDivCd(String prnrSubLnkDivCd) {
		this.prnrSubLnkDivCd = prnrSubLnkDivCd;
	}
	
	/**
	 * Column Info
	 * @param sndrTrdPrnrId
	 */
	public void setSndrTrdPrnrId(String sndrTrdPrnrId) {
		this.sndrTrdPrnrId = sndrTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param trdPrnrSubLnkSeq
	 */
	public void setTrdPrnrSubLnkSeq(String trdPrnrSubLnkSeq) {
		this.trdPrnrSubLnkSeq = trdPrnrSubLnkSeq;
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
	 * @param prnrPortCd
	 */
	public void setPrnrPortCd(String prnrPortCd) {
		this.prnrPortCd = prnrPortCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param rcvrTrdPrnrId
	 */
	public void setRcvrTrdPrnrId(String rcvrTrdPrnrId) {
		this.rcvrTrdPrnrId = rcvrTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param prnrSubLnkCd
	 */
	public void setPrnrSubLnkCd(String prnrSubLnkCd) {
		this.prnrSubLnkCd = prnrSubLnkCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndFlg
	 */
	public void setEdiSndFlg(String ediSndFlg) {
		this.ediSndFlg = ediSndFlg;
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
		setPrnrSubLnkDivCd(JSPUtil.getParameter(request, "prnr_sub_lnk_div_cd", ""));
		setSndrTrdPrnrId(JSPUtil.getParameter(request, "sndr_trd_prnr_id", ""));
		setTrdPrnrSubLnkSeq(JSPUtil.getParameter(request, "trd_prnr_sub_lnk_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPrnrPortCd(JSPUtil.getParameter(request, "prnr_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRcvrTrdPrnrId(JSPUtil.getParameter(request, "rcvr_trd_prnr_id", ""));
		setPrnrSubLnkCd(JSPUtil.getParameter(request, "prnr_sub_lnk_cd", ""));
		setEdiSndFlg(JSPUtil.getParameter(request, "edi_snd_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgEdiTrdPrnrSubLnkVO[]
	 */
	public BkgEdiTrdPrnrSubLnkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgEdiTrdPrnrSubLnkVO[]
	 */
	public BkgEdiTrdPrnrSubLnkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgEdiTrdPrnrSubLnkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] prnrSubLnkDivCd = (JSPUtil.getParameter(request, prefix	+ "prnr_sub_lnk_div_cd", length));
			String[] sndrTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "sndr_trd_prnr_id", length));
			String[] trdPrnrSubLnkSeq = (JSPUtil.getParameter(request, prefix	+ "trd_prnr_sub_lnk_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] prnrPortCd = (JSPUtil.getParameter(request, prefix	+ "prnr_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rcvrTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "rcvr_trd_prnr_id", length));
			String[] prnrSubLnkCd = (JSPUtil.getParameter(request, prefix	+ "prnr_sub_lnk_cd", length));
			String[] ediSndFlg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgEdiTrdPrnrSubLnkVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (prnrSubLnkDivCd[i] != null)
					model.setPrnrSubLnkDivCd(prnrSubLnkDivCd[i]);
				if (sndrTrdPrnrId[i] != null)
					model.setSndrTrdPrnrId(sndrTrdPrnrId[i]);
				if (trdPrnrSubLnkSeq[i] != null)
					model.setTrdPrnrSubLnkSeq(trdPrnrSubLnkSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (prnrPortCd[i] != null)
					model.setPrnrPortCd(prnrPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rcvrTrdPrnrId[i] != null)
					model.setRcvrTrdPrnrId(rcvrTrdPrnrId[i]);
				if (prnrSubLnkCd[i] != null)
					model.setPrnrSubLnkCd(prnrSubLnkCd[i]);
				if (ediSndFlg[i] != null)
					model.setEdiSndFlg(ediSndFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgEdiTrdPrnrSubLnkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgEdiTrdPrnrSubLnkVO[]
	 */
	public BkgEdiTrdPrnrSubLnkVO[] getBkgEdiTrdPrnrSubLnkVOs(){
		BkgEdiTrdPrnrSubLnkVO[] vos = (BkgEdiTrdPrnrSubLnkVO[])models.toArray(new BkgEdiTrdPrnrSubLnkVO[models.size()]);
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
		this.prnrSubLnkDivCd = this.prnrSubLnkDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrTrdPrnrId = this.sndrTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPrnrSubLnkSeq = this.trdPrnrSubLnkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnrPortCd = this.prnrPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrTrdPrnrId = this.rcvrTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnrSubLnkCd = this.prnrSubLnkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndFlg = this.ediSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
