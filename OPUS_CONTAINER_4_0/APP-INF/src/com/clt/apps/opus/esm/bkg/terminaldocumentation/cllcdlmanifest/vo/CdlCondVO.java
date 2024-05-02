/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CdlCondVO.java
*@FileTitle : CdlCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.30
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class CdlCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CdlCondVO> models = new ArrayList<CdlCondVO>();

	/* Column Info */
	private String inEdiRptMsgRcvDtStart = null;
	/* Column Info */
	private String inTmlVvdId = null;
	/* Column Info */
	private String inCallSgnNo = null;
	/* Column Info */
	private String inVslNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inCntrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inEdiRptMsgRcvDtEnd = null;
	/* Column Info */
	private String inCntrLdisDtEnd = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String inEventYdCd = null;
	/* Column Info */
	private String inPodCd = null;
	/* Column Info */
	private String inCntrLdisDtStart = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CdlCondVO() {}

	public CdlCondVO(String ibflag, String pagerows, String inEdiRptMsgRcvDtStart, String inEdiRptMsgRcvDtEnd, String inCntrLdisDtStart, String inCntrLdisDtEnd, String inEventYdCd, String inPolCd, String inPodCd, String inTmlVvdId, String inCallSgnNo, String inVslNm, String inCntrNo) {
		this.inEdiRptMsgRcvDtStart = inEdiRptMsgRcvDtStart;
		this.inTmlVvdId = inTmlVvdId;
		this.inCallSgnNo = inCallSgnNo;
		this.inVslNm = inVslNm;
		this.pagerows = pagerows;
		this.inCntrNo = inCntrNo;
		this.ibflag = ibflag;
		this.inEdiRptMsgRcvDtEnd = inEdiRptMsgRcvDtEnd;
		this.inCntrLdisDtEnd = inCntrLdisDtEnd;
		this.inPolCd = inPolCd;
		this.inEventYdCd = inEventYdCd;
		this.inPodCd = inPodCd;
		this.inCntrLdisDtStart = inCntrLdisDtStart;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_edi_rpt_msg_rcv_dt_start", getInEdiRptMsgRcvDtStart());
		this.hashColumns.put("in_tml_vvd_id", getInTmlVvdId());
		this.hashColumns.put("in_call_sgn_no", getInCallSgnNo());
		this.hashColumns.put("in_vsl_nm", getInVslNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_cntr_no", getInCntrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_edi_rpt_msg_rcv_dt_end", getInEdiRptMsgRcvDtEnd());
		this.hashColumns.put("in_cntr_ldis_dt_end", getInCntrLdisDtEnd());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("in_event_yd_cd", getInEventYdCd());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		this.hashColumns.put("in_cntr_ldis_dt_start", getInCntrLdisDtStart());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_edi_rpt_msg_rcv_dt_start", "inEdiRptMsgRcvDtStart");
		this.hashFields.put("in_tml_vvd_id", "inTmlVvdId");
		this.hashFields.put("in_call_sgn_no", "inCallSgnNo");
		this.hashFields.put("in_vsl_nm", "inVslNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_cntr_no", "inCntrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_edi_rpt_msg_rcv_dt_end", "inEdiRptMsgRcvDtEnd");
		this.hashFields.put("in_cntr_ldis_dt_end", "inCntrLdisDtEnd");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("in_event_yd_cd", "inEventYdCd");
		this.hashFields.put("in_pod_cd", "inPodCd");
		this.hashFields.put("in_cntr_ldis_dt_start", "inCntrLdisDtStart");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return inEdiRptMsgRcvDtStart
	 */
	public String getInEdiRptMsgRcvDtStart() {
		return this.inEdiRptMsgRcvDtStart;
	}

	/**
	 * Column Info
	 * @return inTmlVvdId
	 */
	public String getInTmlVvdId() {
		return this.inTmlVvdId;
	}

	/**
	 * Column Info
	 * @return inCallSgnNo
	 */
	public String getInCallSgnNo() {
		return this.inCallSgnNo;
	}

	/**
	 * Column Info
	 * @return inVslNm
	 */
	public String getInVslNm() {
		return this.inVslNm;
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
	 * @return inCntrNo
	 */
	public String getInCntrNo() {
		return this.inCntrNo;
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
	 * @return inEdiRptMsgRcvDtEnd
	 */
	public String getInEdiRptMsgRcvDtEnd() {
		return this.inEdiRptMsgRcvDtEnd;
	}

	/**
	 * Column Info
	 * @return inCntrLdisDtEnd
	 */
	public String getInCntrLdisDtEnd() {
		return this.inCntrLdisDtEnd;
	}

	/**
	 * Column Info
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
	}

	/**
	 * Column Info
	 * @return inEventYdCd
	 */
	public String getInEventYdCd() {
		return this.inEventYdCd;
	}

	/**
	 * Column Info
	 * @return inPodCd
	 */
	public String getInPodCd() {
		return this.inPodCd;
	}

	/**
	 * Column Info
	 * @return inCntrLdisDtStart
	 */
	public String getInCntrLdisDtStart() {
		return this.inCntrLdisDtStart;
	}


	/**
	 * Column Info
	 * @param inEdiRptMsgRcvDtStart
	 */
	public void setInEdiRptMsgRcvDtStart(String inEdiRptMsgRcvDtStart) {
		this.inEdiRptMsgRcvDtStart = inEdiRptMsgRcvDtStart;
	}

	/**
	 * Column Info
	 * @param inTmlVvdId
	 */
	public void setInTmlVvdId(String inTmlVvdId) {
		this.inTmlVvdId = inTmlVvdId;
	}

	/**
	 * Column Info
	 * @param inCallSgnNo
	 */
	public void setInCallSgnNo(String inCallSgnNo) {
		this.inCallSgnNo = inCallSgnNo;
	}

	/**
	 * Column Info
	 * @param inVslNm
	 */
	public void setInVslNm(String inVslNm) {
		this.inVslNm = inVslNm;
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
	 * @param inCntrNo
	 */
	public void setInCntrNo(String inCntrNo) {
		this.inCntrNo = inCntrNo;
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
	 * @param inEdiRptMsgRcvDtEnd
	 */
	public void setInEdiRptMsgRcvDtEnd(String inEdiRptMsgRcvDtEnd) {
		this.inEdiRptMsgRcvDtEnd = inEdiRptMsgRcvDtEnd;
	}

	/**
	 * Column Info
	 * @param inCntrLdisDtEnd
	 */
	public void setInCntrLdisDtEnd(String inCntrLdisDtEnd) {
		this.inCntrLdisDtEnd = inCntrLdisDtEnd;
	}

	/**
	 * Column Info
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
	}

	/**
	 * Column Info
	 * @param inEventYdCd
	 */
	public void setInEventYdCd(String inEventYdCd) {
		this.inEventYdCd = inEventYdCd;
	}

	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
	}

	/**
	 * Column Info
	 * @param inCntrLdisDtStart
	 */
	public void setInCntrLdisDtStart(String inCntrLdisDtStart) {
		this.inCntrLdisDtStart = inCntrLdisDtStart;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInEdiRptMsgRcvDtStart(JSPUtil.getParameter(request, "in_edi_rpt_msg_rcv_dt_start", ""));
		setInTmlVvdId(JSPUtil.getParameter(request, "in_tml_vvd_id", ""));
		setInCallSgnNo(JSPUtil.getParameter(request, "in_call_sgn_no", ""));
		setInVslNm(JSPUtil.getParameter(request, "in_vsl_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInCntrNo(JSPUtil.getParameter(request, "in_cntr_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInEdiRptMsgRcvDtEnd(JSPUtil.getParameter(request, "in_edi_rpt_msg_rcv_dt_end", ""));
		setInCntrLdisDtEnd(JSPUtil.getParameter(request, "in_cntr_ldis_dt_end", ""));
		setInPolCd(JSPUtil.getParameter(request, "in_pol_cd", ""));
		setInEventYdCd(JSPUtil.getParameter(request, "in_event_yd_cd", ""));
		setInPodCd(JSPUtil.getParameter(request, "in_pod_cd", ""));
		setInCntrLdisDtStart(JSPUtil.getParameter(request, "in_cntr_ldis_dt_start", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CdlCondVO[]
	 */
	public CdlCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CdlCondVO[]
	 */
	public CdlCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CdlCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inEdiRptMsgRcvDtStart = (JSPUtil.getParameter(request, prefix	+ "in_edi_rpt_msg_rcv_dt_start", length));
			String[] inTmlVvdId = (JSPUtil.getParameter(request, prefix	+ "in_tml_vvd_id", length));
			String[] inCallSgnNo = (JSPUtil.getParameter(request, prefix	+ "in_call_sgn_no", length));
			String[] inVslNm = (JSPUtil.getParameter(request, prefix	+ "in_vsl_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inCntrNo = (JSPUtil.getParameter(request, prefix	+ "in_cntr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inEdiRptMsgRcvDtEnd = (JSPUtil.getParameter(request, prefix	+ "in_edi_rpt_msg_rcv_dt_end", length));
			String[] inCntrLdisDtEnd = (JSPUtil.getParameter(request, prefix	+ "in_cntr_ldis_dt_end", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] inEventYdCd = (JSPUtil.getParameter(request, prefix	+ "in_event_yd_cd", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));
			String[] inCntrLdisDtStart = (JSPUtil.getParameter(request, prefix	+ "in_cntr_ldis_dt_start", length));

			for (int i = 0; i < length; i++) {
				model = new CdlCondVO();
				if (inEdiRptMsgRcvDtStart[i] != null)
					model.setInEdiRptMsgRcvDtStart(inEdiRptMsgRcvDtStart[i]);
				if (inTmlVvdId[i] != null)
					model.setInTmlVvdId(inTmlVvdId[i]);
				if (inCallSgnNo[i] != null)
					model.setInCallSgnNo(inCallSgnNo[i]);
				if (inVslNm[i] != null)
					model.setInVslNm(inVslNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inCntrNo[i] != null)
					model.setInCntrNo(inCntrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inEdiRptMsgRcvDtEnd[i] != null)
					model.setInEdiRptMsgRcvDtEnd(inEdiRptMsgRcvDtEnd[i]);
				if (inCntrLdisDtEnd[i] != null)
					model.setInCntrLdisDtEnd(inCntrLdisDtEnd[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (inEventYdCd[i] != null)
					model.setInEventYdCd(inEventYdCd[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				if (inCntrLdisDtStart[i] != null)
					model.setInCntrLdisDtStart(inCntrLdisDtStart[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCdlCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CdlCondVO[]
	 */
	public CdlCondVO[] getCdlCondVOs(){
		CdlCondVO[] vos = (CdlCondVO[])models.toArray(new CdlCondVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.inEdiRptMsgRcvDtStart = this.inEdiRptMsgRcvDtStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTmlVvdId = this.inTmlVvdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCallSgnNo = this.inCallSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslNm = this.inVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrNo = this.inCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inEdiRptMsgRcvDtEnd = this.inEdiRptMsgRcvDtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrLdisDtEnd = this.inCntrLdisDtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inEventYdCd = this.inEventYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrLdisDtStart = this.inCntrLdisDtStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
