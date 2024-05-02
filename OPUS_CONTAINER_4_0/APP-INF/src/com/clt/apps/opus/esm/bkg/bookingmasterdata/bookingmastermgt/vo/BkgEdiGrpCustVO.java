/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgEdiGrpCustVO.java
*@FileTitle : BkgEdiGrpCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.05  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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

public class BkgEdiGrpCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgEdiGrpCustVO> models = new ArrayList<BkgEdiGrpCustVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String esvcGrpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String bkgCfmAutoFlg = null;
	/* Column Info */
	private String blDrftAutoFlg = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blDrftFlg = null;
	/* Column Info */
	private String eaiSts = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgCfmFlg = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String anFlg = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String cgoTrakFlg = null;
	/* Column Info */
	private String esvcBlTpCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgEdiGrpCustVO() {}

	public BkgEdiGrpCustVO(String ibflag, String pagerows, String esvcGrpCd, String coCd, String cntCd, String custSeq, String scNo, String bkgCfmFlg, String bkgCfmAutoFlg, String blDrftAutoFlg, String blDrftFlg, String cgoTrakFlg, String anFlg, String esvcBlTpCd, String bkgCtrtTpCd, String deltFlg, String eaiSts, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.coCd = coCd;
		this.deltFlg = deltFlg;
		this.esvcGrpCd = esvcGrpCd;
		this.creDt = creDt;
		this.bkgCfmAutoFlg = bkgCfmAutoFlg;
		this.blDrftAutoFlg = blDrftAutoFlg;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.blDrftFlg = blDrftFlg;
		this.eaiSts = eaiSts;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.bkgCfmFlg = bkgCfmFlg;
		this.scNo = scNo;
		this.cntCd = cntCd;
		this.anFlg = anFlg;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.cgoTrakFlg = cgoTrakFlg;
		this.esvcBlTpCd = esvcBlTpCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("esvc_grp_cd", getEsvcGrpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bkg_cfm_auto_flg", getBkgCfmAutoFlg());
		this.hashColumns.put("bl_drft_auto_flg", getBlDrftAutoFlg());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_drft_flg", getBlDrftFlg());
		this.hashColumns.put("eai_sts", getEaiSts());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_cfm_flg", getBkgCfmFlg());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("an_flg", getAnFlg());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("cgo_trak_flg", getCgoTrakFlg());
		this.hashColumns.put("esvc_bl_tp_cd", getEsvcBlTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("esvc_grp_cd", "esvcGrpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bkg_cfm_auto_flg", "bkgCfmAutoFlg");
		this.hashFields.put("bl_drft_auto_flg", "blDrftAutoFlg");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_drft_flg", "blDrftFlg");
		this.hashFields.put("eai_sts", "eaiSts");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_cfm_flg", "bkgCfmFlg");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("an_flg", "anFlg");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("cgo_trak_flg", "cgoTrakFlg");
		this.hashFields.put("esvc_bl_tp_cd", "esvcBlTpCd");
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
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return esvcGrpCd
	 */
	public String getEsvcGrpCd() {
		return this.esvcGrpCd;
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
	 * @return bkgCfmAutoFlg
	 */
	public String getBkgCfmAutoFlg() {
		return this.bkgCfmAutoFlg;
	}
	
	/**
	 * Column Info
	 * @return blDrftAutoFlg
	 */
	public String getBlDrftAutoFlg() {
		return this.blDrftAutoFlg;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return blDrftFlg
	 */
	public String getBlDrftFlg() {
		return this.blDrftFlg;
	}
	
	/**
	 * Column Info
	 * @return eaiSts
	 */
	public String getEaiSts() {
		return this.eaiSts;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return bkgCfmFlg
	 */
	public String getBkgCfmFlg() {
		return this.bkgCfmFlg;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return anFlg
	 */
	public String getAnFlg() {
		return this.anFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return cgoTrakFlg
	 */
	public String getCgoTrakFlg() {
		return this.cgoTrakFlg;
	}
	
	/**
	 * Column Info
	 * @return esvcBlTpCd
	 */
	public String getEsvcBlTpCd() {
		return this.esvcBlTpCd;
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
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param esvcGrpCd
	 */
	public void setEsvcGrpCd(String esvcGrpCd) {
		this.esvcGrpCd = esvcGrpCd;
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
	 * @param bkgCfmAutoFlg
	 */
	public void setBkgCfmAutoFlg(String bkgCfmAutoFlg) {
		this.bkgCfmAutoFlg = bkgCfmAutoFlg;
	}
	
	/**
	 * Column Info
	 * @param blDrftAutoFlg
	 */
	public void setBlDrftAutoFlg(String blDrftAutoFlg) {
		this.blDrftAutoFlg = blDrftAutoFlg;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param blDrftFlg
	 */
	public void setBlDrftFlg(String blDrftFlg) {
		this.blDrftFlg = blDrftFlg;
	}
	
	/**
	 * Column Info
	 * @param eaiSts
	 */
	public void setEaiSts(String eaiSts) {
		this.eaiSts = eaiSts;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param bkgCfmFlg
	 */
	public void setBkgCfmFlg(String bkgCfmFlg) {
		this.bkgCfmFlg = bkgCfmFlg;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param anFlg
	 */
	public void setAnFlg(String anFlg) {
		this.anFlg = anFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param cgoTrakFlg
	 */
	public void setCgoTrakFlg(String cgoTrakFlg) {
		this.cgoTrakFlg = cgoTrakFlg;
	}
	
	/**
	 * Column Info
	 * @param esvcBlTpCd
	 */
	public void setEsvcBlTpCd(String esvcBlTpCd) {
		this.esvcBlTpCd = esvcBlTpCd;
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
		setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setEsvcGrpCd(JSPUtil.getParameter(request, prefix + "esvc_grp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBkgCfmAutoFlg(JSPUtil.getParameter(request, prefix + "bkg_cfm_auto_flg", ""));
		setBlDrftAutoFlg(JSPUtil.getParameter(request, prefix + "bl_drft_auto_flg", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlDrftFlg(JSPUtil.getParameter(request, prefix + "bl_drft_flg", ""));
		setEaiSts(JSPUtil.getParameter(request, prefix + "eai_sts", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgCfmFlg(JSPUtil.getParameter(request, prefix + "bkg_cfm_flg", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setAnFlg(JSPUtil.getParameter(request, prefix + "an_flg", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setCgoTrakFlg(JSPUtil.getParameter(request, prefix + "cgo_trak_flg", ""));
		setEsvcBlTpCd(JSPUtil.getParameter(request, prefix + "esvc_bl_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgEdiGrpCustVO[]
	 */
	public BkgEdiGrpCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgEdiGrpCustVO[]
	 */
	public BkgEdiGrpCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgEdiGrpCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] esvcGrpCd = (JSPUtil.getParameter(request, prefix	+ "esvc_grp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] bkgCfmAutoFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_cfm_auto_flg", length));
			String[] blDrftAutoFlg = (JSPUtil.getParameter(request, prefix	+ "bl_drft_auto_flg", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blDrftFlg = (JSPUtil.getParameter(request, prefix	+ "bl_drft_flg", length));
			String[] eaiSts = (JSPUtil.getParameter(request, prefix	+ "eai_sts", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgCfmFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_cfm_flg", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] anFlg = (JSPUtil.getParameter(request, prefix	+ "an_flg", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] cgoTrakFlg = (JSPUtil.getParameter(request, prefix	+ "cgo_trak_flg", length));
			String[] esvcBlTpCd = (JSPUtil.getParameter(request, prefix	+ "esvc_bl_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgEdiGrpCustVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (esvcGrpCd[i] != null)
					model.setEsvcGrpCd(esvcGrpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (bkgCfmAutoFlg[i] != null)
					model.setBkgCfmAutoFlg(bkgCfmAutoFlg[i]);
				if (blDrftAutoFlg[i] != null)
					model.setBlDrftAutoFlg(blDrftAutoFlg[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blDrftFlg[i] != null)
					model.setBlDrftFlg(blDrftFlg[i]);
				if (eaiSts[i] != null)
					model.setEaiSts(eaiSts[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgCfmFlg[i] != null)
					model.setBkgCfmFlg(bkgCfmFlg[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (anFlg[i] != null)
					model.setAnFlg(anFlg[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (cgoTrakFlg[i] != null)
					model.setCgoTrakFlg(cgoTrakFlg[i]);
				if (esvcBlTpCd[i] != null)
					model.setEsvcBlTpCd(esvcBlTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgEdiGrpCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgEdiGrpCustVO[]
	 */
	public BkgEdiGrpCustVO[] getBkgEdiGrpCustVOs(){
		BkgEdiGrpCustVO[] vos = (BkgEdiGrpCustVO[])models.toArray(new BkgEdiGrpCustVO[models.size()]);
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
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esvcGrpCd = this.esvcGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCfmAutoFlg = this.bkgCfmAutoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDrftAutoFlg = this.blDrftAutoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDrftFlg = this.blDrftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiSts = this.eaiSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCfmFlg = this.bkgCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anFlg = this.anFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTrakFlg = this.cgoTrakFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esvcBlTpCd = this.esvcBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
