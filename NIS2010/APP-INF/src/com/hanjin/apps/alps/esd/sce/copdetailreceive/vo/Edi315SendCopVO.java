/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendCopVO.java
*@FileTitle : Edi315SendCopVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copdetailreceive.vo;

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

public class Edi315SendCopVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315SendCopVO> models = new ArrayList<Edi315SendCopVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String actStndEdiStsCd = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info of replan 315 */
	private String rplnBatSndFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315SendCopVO() {}

	public Edi315SendCopVO(String ibflag, String pagerows, String copNo, String copDtlSeq, String bkgNo, String cntrNo, String nodCd, String actStndEdiStsCd, String rplnBatSndFlg) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.copNo = copNo;
		this.nodCd = nodCd;
		this.actStndEdiStsCd = actStndEdiStsCd;
		this.copDtlSeq = copDtlSeq;
		this.pagerows = pagerows;
		this.rplnBatSndFlg = rplnBatSndFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("act_stnd_edi_sts_cd", getActStndEdiStsCd());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rpln_bat_snd_flg", getRplnBatSndFlg());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("act_stnd_edi_sts_cd", "actStndEdiStsCd");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rpln_bat_snd_flg", "rplnBatSndFlg");
		return this.hashFields;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return actStndEdiStsCd
	 */
	public String getActStndEdiStsCd() {
		return this.actStndEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return copDtlSeq
	 */
	public String getCopDtlSeq() {
		return this.copDtlSeq;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info of replan 315
	 * @return rplnBatSndFlg
	 */
	public String getRplnBatSndFlg() {
		return rplnBatSndFlg;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param actStndEdiStsCd
	 */
	public void setActStndEdiStsCd(String actStndEdiStsCd) {
		this.actStndEdiStsCd = actStndEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param copDtlSeq
	 */
	public void setCopDtlSeq(String copDtlSeq) {
		this.copDtlSeq = copDtlSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info of replan 315
	 * @param rplnBatSndFlg
	 */
	public void setRplnBatSndFlg(String rplnBatSndFlg) {
		this.rplnBatSndFlg = rplnBatSndFlg;
	}

	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setActStndEdiStsCd(JSPUtil.getParameter(request, "act_stnd_edi_sts_cd", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, "cop_dtl_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRplnBatSndFlg(JSPUtil.getParameter(request, "rpln_bat_snd_flg", ""));	
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315SendCopVO[]
	 */
	public Edi315SendCopVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315SendCopVO[]
	 */
	public Edi315SendCopVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315SendCopVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] actStndEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "act_stnd_edi_sts_cd", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rplnBatSndFlg = (JSPUtil.getParameter(request, prefix	+ "rpln_bat_snd_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315SendCopVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (actStndEdiStsCd[i] != null)
					model.setActStndEdiStsCd(actStndEdiStsCd[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rplnBatSndFlg[i] != null)
					model.setRplnBatSndFlg(rplnBatSndFlg[i]);	
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315SendCopVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315SendCopVO[]
	 */
	public Edi315SendCopVO[] getEdi315SendCopVOs(){
		Edi315SendCopVO[] vos = (Edi315SendCopVO[])models.toArray(new Edi315SendCopVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStndEdiStsCd = this.actStndEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnBatSndFlg = this.rplnBatSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
