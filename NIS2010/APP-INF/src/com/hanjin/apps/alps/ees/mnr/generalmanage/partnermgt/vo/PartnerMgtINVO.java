/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartnerMgtINVO.java
*@FileTitle : PartnerMgtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.11.11 권영법 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo;

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
 * @author 권영법
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PartnerMgtINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PartnerMgtINVO> models = new ArrayList<PartnerMgtINVO>();
	
	/* Column Info */
	private String mnrPrnrCreSeq = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String mnrMnrPrnrCntCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PartnerMgtINVO() {}

	public PartnerMgtINVO(String ibflag, String pagerows, String mnrPrnrSeq, String mnrPrnrCreSeq, String mnrGrpTpCd, String mnrMnrPrnrCntCd) {
		this.mnrPrnrCreSeq = mnrPrnrCreSeq;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.ibflag = ibflag;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.mnrMnrPrnrCntCd = mnrMnrPrnrCntCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_prnr_cre_seq", getMnrPrnrCreSeq());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("mnr_mnr_prnr_cnt_cd", getMnrMnrPrnrCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_prnr_cre_seq", "mnrPrnrCreSeq");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("mnr_mnr_prnr_cnt_cd", "mnrMnrPrnrCntCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrCreSeq
	 */
	public String getMnrPrnrCreSeq() {
		return this.mnrPrnrCreSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrSeq
	 */
	public String getMnrPrnrSeq() {
		return this.mnrPrnrSeq;
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
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrMnrPrnrCntCd
	 */
	public String getMnrMnrPrnrCntCd() {
		return this.mnrMnrPrnrCntCd;
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
	 * @param mnrPrnrCreSeq
	 */
	public void setMnrPrnrCreSeq(String mnrPrnrCreSeq) {
		this.mnrPrnrCreSeq = mnrPrnrCreSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrSeq
	 */
	public void setMnrPrnrSeq(String mnrPrnrSeq) {
		this.mnrPrnrSeq = mnrPrnrSeq;
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
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrMnrPrnrCntCd
	 */
	public void setMnrMnrPrnrCntCd(String mnrMnrPrnrCntCd) {
		this.mnrMnrPrnrCntCd = mnrMnrPrnrCntCd;
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
		setMnrPrnrCreSeq(JSPUtil.getParameter(request, "mnr_prnr_cre_seq", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, "mnr_prnr_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setMnrMnrPrnrCntCd(JSPUtil.getParameter(request, "mnr_mnr_prnr_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PartnerMgtINVO[]
	 */
	public PartnerMgtINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PartnerMgtINVO[]
	 */
	public PartnerMgtINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PartnerMgtINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrPrnrCreSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cre_seq", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] mnrMnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_mnr_prnr_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PartnerMgtINVO();
				if (mnrPrnrCreSeq[i] != null)
					model.setMnrPrnrCreSeq(mnrPrnrCreSeq[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (mnrMnrPrnrCntCd[i] != null)
					model.setMnrMnrPrnrCntCd(mnrMnrPrnrCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPartnerMgtINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PartnerMgtINVO[]
	 */
	public PartnerMgtINVO[] getPartnerMgtINVOs(){
		PartnerMgtINVO[] vos = (PartnerMgtINVO[])models.toArray(new PartnerMgtINVO[models.size()]);
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
		this.mnrPrnrCreSeq = this.mnrPrnrCreSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrMnrPrnrCntCd = this.mnrMnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
