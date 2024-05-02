/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgEdiSubLnkMsgVO.java
*@FileTitle : BkgEdiSubLnkMsgVO
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

public class BkgEdiSubLnkMsgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgEdiSubLnkMsgVO> models = new ArrayList<BkgEdiSubLnkMsgVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String msgTpDesc = null;
	/* Column Info */
	private String ediMsgIndCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediStupNo = null;
	/* Column Info */
	private String trdPrnrSubLnkSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ediMsgTpId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgEdiSubLnkMsgVO() {}

	public BkgEdiSubLnkMsgVO(String ibflag, String pagerows, String trdPrnrSubLnkSeq, String ediMsgTpId, String ediMsgIndCd, String msgTpDesc, String ediStupNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.msgTpDesc = msgTpDesc;
		this.ediMsgIndCd = ediMsgIndCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.ediStupNo = ediStupNo;
		this.trdPrnrSubLnkSeq = trdPrnrSubLnkSeq;
		this.creDt = creDt;
		this.ediMsgTpId = ediMsgTpId;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("msg_tp_desc", getMsgTpDesc());
		this.hashColumns.put("edi_msg_ind_cd", getEdiMsgIndCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_stup_no", getEdiStupNo());
		this.hashColumns.put("trd_prnr_sub_lnk_seq", getTrdPrnrSubLnkSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("edi_msg_tp_id", getEdiMsgTpId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("msg_tp_desc", "msgTpDesc");
		this.hashFields.put("edi_msg_ind_cd", "ediMsgIndCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_stup_no", "ediStupNo");
		this.hashFields.put("trd_prnr_sub_lnk_seq", "trdPrnrSubLnkSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("edi_msg_tp_id", "ediMsgTpId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return msgTpDesc
	 */
	public String getMsgTpDesc() {
		return this.msgTpDesc;
	}
	
	/**
	 * Column Info
	 * @return ediMsgIndCd
	 */
	public String getEdiMsgIndCd() {
		return this.ediMsgIndCd;
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
	 * @return ediStupNo
	 */
	public String getEdiStupNo() {
		return this.ediStupNo;
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
	 * @return ediMsgTpId
	 */
	public String getEdiMsgTpId() {
		return this.ediMsgTpId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param msgTpDesc
	 */
	public void setMsgTpDesc(String msgTpDesc) {
		this.msgTpDesc = msgTpDesc;
	}
	
	/**
	 * Column Info
	 * @param ediMsgIndCd
	 */
	public void setEdiMsgIndCd(String ediMsgIndCd) {
		this.ediMsgIndCd = ediMsgIndCd;
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
	 * @param ediStupNo
	 */
	public void setEdiStupNo(String ediStupNo) {
		this.ediStupNo = ediStupNo;
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
	 * @param ediMsgTpId
	 */
	public void setEdiMsgTpId(String ediMsgTpId) {
		this.ediMsgTpId = ediMsgTpId;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMsgTpDesc(JSPUtil.getParameter(request, "msg_tp_desc", ""));
		setEdiMsgIndCd(JSPUtil.getParameter(request, "edi_msg_ind_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEdiStupNo(JSPUtil.getParameter(request, "edi_stup_no", ""));
		setTrdPrnrSubLnkSeq(JSPUtil.getParameter(request, "trd_prnr_sub_lnk_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setEdiMsgTpId(JSPUtil.getParameter(request, "edi_msg_tp_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgEdiSubLnkMsgVO[]
	 */
	public BkgEdiSubLnkMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgEdiSubLnkMsgVO[]
	 */
	public BkgEdiSubLnkMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgEdiSubLnkMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] msgTpDesc = (JSPUtil.getParameter(request, prefix	+ "msg_tp_desc", length));
			String[] ediMsgIndCd = (JSPUtil.getParameter(request, prefix	+ "edi_msg_ind_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediStupNo = (JSPUtil.getParameter(request, prefix	+ "edi_stup_no", length));
			String[] trdPrnrSubLnkSeq = (JSPUtil.getParameter(request, prefix	+ "trd_prnr_sub_lnk_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ediMsgTpId = (JSPUtil.getParameter(request, prefix	+ "edi_msg_tp_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgEdiSubLnkMsgVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (msgTpDesc[i] != null)
					model.setMsgTpDesc(msgTpDesc[i]);
				if (ediMsgIndCd[i] != null)
					model.setEdiMsgIndCd(ediMsgIndCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediStupNo[i] != null)
					model.setEdiStupNo(ediStupNo[i]);
				if (trdPrnrSubLnkSeq[i] != null)
					model.setTrdPrnrSubLnkSeq(trdPrnrSubLnkSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ediMsgTpId[i] != null)
					model.setEdiMsgTpId(ediMsgTpId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgEdiSubLnkMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgEdiSubLnkMsgVO[]
	 */
	public BkgEdiSubLnkMsgVO[] getBkgEdiSubLnkMsgVOs(){
		BkgEdiSubLnkMsgVO[] vos = (BkgEdiSubLnkMsgVO[])models.toArray(new BkgEdiSubLnkMsgVO[models.size()]);
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
		this.msgTpDesc = this.msgTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgIndCd = this.ediMsgIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStupNo = this.ediStupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPrnrSubLnkSeq = this.trdPrnrSubLnkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgTpId = this.ediMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
