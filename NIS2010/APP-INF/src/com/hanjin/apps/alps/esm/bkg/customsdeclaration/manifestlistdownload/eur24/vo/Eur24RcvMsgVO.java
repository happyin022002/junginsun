/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24RcvMsgVO.java
*@FileTitle : Eur24RcvMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.12.21 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eur24RcvMsgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24RcvMsgVO> models = new ArrayList<Eur24RcvMsgVO>();
	
	/* Column Info */
	private String rjctRsnRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eurCstmsRjctCd = null;
	/* Column Info */
	private String ediRcvMsgCtnt = null;
	/* Column Info */
	private String errId = null;
	/* Column Info */
	private String errImg = null;
	/* Column Info */
	private String ackRcvStsCd = null;
	/* Column Info */
	private String column1 = null;
	/* Column Info */
	private String remark1 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24RcvMsgVO() {}

	public Eur24RcvMsgVO(String ibflag, String pagerows, String rjctRsnRmk, String eurCstmsRjctCd, String ediRcvMsgCtnt, String ackRcvStsCd, String column1, String remark1, String errImg, String errId) {
		this.rjctRsnRmk = rjctRsnRmk;
		this.ibflag = ibflag;
		this.eurCstmsRjctCd = eurCstmsRjctCd;
		this.ediRcvMsgCtnt = ediRcvMsgCtnt;
		this.errId = errId;
		this.errImg = errImg;
		this.ackRcvStsCd = ackRcvStsCd;
		this.column1 = column1;
		this.remark1 = remark1;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rjct_rsn_rmk", getRjctRsnRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eur_cstms_rjct_cd", getEurCstmsRjctCd());
		this.hashColumns.put("edi_rcv_msg_ctnt", getEdiRcvMsgCtnt());
		this.hashColumns.put("err_id", getErrId());
		this.hashColumns.put("err_img", getErrImg());
		this.hashColumns.put("ack_rcv_sts_cd", getAckRcvStsCd());
		this.hashColumns.put("column1", getColumn1());
		this.hashColumns.put("remark1", getRemark1());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rjct_rsn_rmk", "rjctRsnRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eur_cstms_rjct_cd", "eurCstmsRjctCd");
		this.hashFields.put("edi_rcv_msg_ctnt", "ediRcvMsgCtnt");
		this.hashFields.put("err_id", "errId");
		this.hashFields.put("err_img", "errImg");
		this.hashFields.put("ack_rcv_sts_cd", "ackRcvStsCd");
		this.hashFields.put("column1", "column1");
		this.hashFields.put("remark1", "remark1");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rjctRsnRmk
	 */
	public String getRjctRsnRmk() {
		return this.rjctRsnRmk;
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
	 * @return eurCstmsRjctCd
	 */
	public String getEurCstmsRjctCd() {
		return this.eurCstmsRjctCd;
	}
	
	/**
	 * Column Info
	 * @return ediRcvMsgCtnt
	 */
	public String getEdiRcvMsgCtnt() {
		return this.ediRcvMsgCtnt;
	}
	
	/**
	 * Column Info
	 * @return errId
	 */
	public String getErrId() {
		return this.errId;
	}
	
	/**
	 * Column Info
	 * @return errImg
	 */
	public String getErrImg() {
		return this.errImg;
	}
	
	/**
	 * Column Info
	 * @return ackRcvStsCd
	 */
	public String getAckRcvStsCd() {
		return this.ackRcvStsCd;
	}
	
	/**
	 * Column Info
	 * @return column1
	 */
	public String getColumn1() {
		return this.column1;
	}
	
	/**
	 * Column Info
	 * @return remark1
	 */
	public String getRemark1() {
		return this.remark1;
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
	 * @param rjctRsnRmk
	 */
	public void setRjctRsnRmk(String rjctRsnRmk) {
		this.rjctRsnRmk = rjctRsnRmk;
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
	 * @param eurCstmsRjctCd
	 */
	public void setEurCstmsRjctCd(String eurCstmsRjctCd) {
		this.eurCstmsRjctCd = eurCstmsRjctCd;
	}
	
	/**
	 * Column Info
	 * @param ediRcvMsgCtnt
	 */
	public void setEdiRcvMsgCtnt(String ediRcvMsgCtnt) {
		this.ediRcvMsgCtnt = ediRcvMsgCtnt;
	}
	
	/**
	 * Column Info
	 * @param errId
	 */
	public void setErrId(String errId) {
		this.errId = errId;
	}
	
	/**
	 * Column Info
	 * @param errImg
	 */
	public void setErrImg(String errImg) {
		this.errImg = errImg;
	}
	
	/**
	 * Column Info
	 * @param ackRcvStsCd
	 */
	public void setAckRcvStsCd(String ackRcvStsCd) {
		this.ackRcvStsCd = ackRcvStsCd;
	}
	
	/**
	 * Column Info
	 * @param column1
	 */
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	
	/**
	 * Column Info
	 * @param remark1
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
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
		setRjctRsnRmk(JSPUtil.getParameter(request, prefix + "rjct_rsn_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEurCstmsRjctCd(JSPUtil.getParameter(request, prefix + "eur_cstms_rjct_cd", ""));
		setEdiRcvMsgCtnt(JSPUtil.getParameter(request, prefix + "edi_rcv_msg_ctnt", ""));
		setErrId(JSPUtil.getParameter(request, prefix + "err_id", ""));
		setErrImg(JSPUtil.getParameter(request, prefix + "err_img", ""));
		setAckRcvStsCd(JSPUtil.getParameter(request, prefix + "ack_rcv_sts_cd", ""));
		setColumn1(JSPUtil.getParameter(request, prefix + "column1", ""));
		setRemark1(JSPUtil.getParameter(request, prefix + "remark1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24RcvMsgVO[]
	 */
	public Eur24RcvMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24RcvMsgVO[]
	 */
	public Eur24RcvMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24RcvMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rjctRsnRmk = (JSPUtil.getParameter(request, prefix	+ "rjct_rsn_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eurCstmsRjctCd = (JSPUtil.getParameter(request, prefix	+ "eur_cstms_rjct_cd", length));
			String[] ediRcvMsgCtnt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_msg_ctnt", length));
			String[] errId = (JSPUtil.getParameter(request, prefix	+ "err_id", length));
			String[] errImg = (JSPUtil.getParameter(request, prefix	+ "err_img", length));
			String[] ackRcvStsCd = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_sts_cd", length));
			String[] column1 = (JSPUtil.getParameter(request, prefix	+ "column1", length));
			String[] remark1 = (JSPUtil.getParameter(request, prefix	+ "remark1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24RcvMsgVO();
				if (rjctRsnRmk[i] != null)
					model.setRjctRsnRmk(rjctRsnRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eurCstmsRjctCd[i] != null)
					model.setEurCstmsRjctCd(eurCstmsRjctCd[i]);
				if (ediRcvMsgCtnt[i] != null)
					model.setEdiRcvMsgCtnt(ediRcvMsgCtnt[i]);
				if (errId[i] != null)
					model.setErrId(errId[i]);
				if (errImg[i] != null)
					model.setErrImg(errImg[i]);
				if (ackRcvStsCd[i] != null)
					model.setAckRcvStsCd(ackRcvStsCd[i]);
				if (column1[i] != null)
					model.setColumn1(column1[i]);
				if (remark1[i] != null)
					model.setRemark1(remark1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24RcvMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24RcvMsgVO[]
	 */
	public Eur24RcvMsgVO[] getEur24RcvMsgVOs(){
		Eur24RcvMsgVO[] vos = (Eur24RcvMsgVO[])models.toArray(new Eur24RcvMsgVO[models.size()]);
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
		this.rjctRsnRmk = this.rjctRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurCstmsRjctCd = this.eurCstmsRjctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvMsgCtnt = this.ediRcvMsgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errId = this.errId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errImg = this.errImg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvStsCd = this.ackRcvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.column1 = this.column1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark1 = this.remark1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
