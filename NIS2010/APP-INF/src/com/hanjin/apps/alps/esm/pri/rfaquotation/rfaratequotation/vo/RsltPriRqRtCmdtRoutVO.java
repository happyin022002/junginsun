/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltPriRqRtCmdtRoutVO.java
*@FileTitle : RsltPriRqRtCmdtRoutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.30
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.11.30 이은섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo;

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
 * @author 이은섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriRqRtCmdtRoutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriRqRtCmdtRoutVO> models = new ArrayList<RsltPriRqRtCmdtRoutVO>();
	
	/* Column Info */
	private String destBsePortLocCd = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String destCyDorRtTpCd = null;
	/* Column Info */
	private String orgCyDorRtTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String routSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String qttnNo = null;
	/* Column Info */
	private String qttnVerNo = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String orgBsePortLocCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriRqRtCmdtRoutVO() {}

	public RsltPriRqRtCmdtRoutVO(String ibflag, String pagerows, String qttnNo, String qttnVerNo, String cmdtHdrSeq, String routSeq, String orgRoutPntLocDefCd, String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefCd, String seq, String orgCyDorRtTpCd, String destCyDorRtTpCd, String orgBsePortLocCd, String destBsePortLocCd) {
		this.destBsePortLocCd = destBsePortLocCd;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.destCyDorRtTpCd = destCyDorRtTpCd;
		this.orgCyDorRtTpCd = orgCyDorRtTpCd;
		this.pagerows = pagerows;
		this.routSeq = routSeq;
		this.ibflag = ibflag;
		this.qttnNo = qttnNo;
		this.qttnVerNo = qttnVerNo;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.orgBsePortLocCd = orgBsePortLocCd;
		this.seq = seq;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dest_bse_port_loc_cd", getDestBsePortLocCd());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("dest_cy_dor_rt_tp_cd", getDestCyDorRtTpCd());
		this.hashColumns.put("org_cy_dor_rt_tp_cd", getOrgCyDorRtTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("org_bse_port_loc_cd", getOrgBsePortLocCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dest_bse_port_loc_cd", "destBsePortLocCd");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("dest_cy_dor_rt_tp_cd", "destCyDorRtTpCd");
		this.hashFields.put("org_cy_dor_rt_tp_cd", "orgCyDorRtTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("org_bse_port_loc_cd", "orgBsePortLocCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return destBsePortLocCd
	 */
	public String getDestBsePortLocCd() {
		return this.destBsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return destCyDorRtTpCd
	 */
	public String getDestCyDorRtTpCd() {
		return this.destCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return orgCyDorRtTpCd
	 */
	public String getOrgCyDorRtTpCd() {
		return this.orgCyDorRtTpCd;
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
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @return qttnNo
	 */
	public String getQttnNo() {
		return this.qttnNo;
	}
	
	/**
	 * Column Info
	 * @return qttnVerNo
	 */
	public String getQttnVerNo() {
		return this.qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return orgBsePortLocCd
	 */
	public String getOrgBsePortLocCd() {
		return this.orgBsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
	}
	

	/**
	 * Column Info
	 * @param destBsePortLocCd
	 */
	public void setDestBsePortLocCd(String destBsePortLocCd) {
		this.destBsePortLocCd = destBsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param destCyDorRtTpCd
	 */
	public void setDestCyDorRtTpCd(String destCyDorRtTpCd) {
		this.destCyDorRtTpCd = destCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param orgCyDorRtTpCd
	 */
	public void setOrgCyDorRtTpCd(String orgCyDorRtTpCd) {
		this.orgCyDorRtTpCd = orgCyDorRtTpCd;
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
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
	 * @param qttnNo
	 */
	public void setQttnNo(String qttnNo) {
		this.qttnNo = qttnNo;
	}
	
	/**
	 * Column Info
	 * @param qttnVerNo
	 */
	public void setQttnVerNo(String qttnVerNo) {
		this.qttnVerNo = qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param orgBsePortLocCd
	 */
	public void setOrgBsePortLocCd(String orgBsePortLocCd) {
		this.orgBsePortLocCd = orgBsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
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
		setDestBsePortLocCd(JSPUtil.getParameter(request, prefix + "dest_bse_port_loc_cd", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd", ""));
		setDestCyDorRtTpCd(JSPUtil.getParameter(request, prefix + "dest_cy_dor_rt_tp_cd", ""));
		setOrgCyDorRtTpCd(JSPUtil.getParameter(request, prefix + "org_cy_dor_rt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setQttnNo(JSPUtil.getParameter(request, prefix + "qttn_no", ""));
		setQttnVerNo(JSPUtil.getParameter(request, prefix + "qttn_ver_no", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd", ""));
		setOrgBsePortLocCd(JSPUtil.getParameter(request, prefix + "org_bse_port_loc_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriRqRtCmdtRoutVO[]
	 */
	public RsltPriRqRtCmdtRoutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriRqRtCmdtRoutVO[]
	 */
	public RsltPriRqRtCmdtRoutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriRqRtCmdtRoutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] destBsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_bse_port_loc_cd", length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] destCyDorRtTpCd = (JSPUtil.getParameter(request, prefix	+ "dest_cy_dor_rt_tp_cd", length));
			String[] orgCyDorRtTpCd = (JSPUtil.getParameter(request, prefix	+ "org_cy_dor_rt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] qttnNo = (JSPUtil.getParameter(request, prefix	+ "qttn_no", length));
			String[] qttnVerNo = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] orgBsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "org_bse_port_loc_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriRqRtCmdtRoutVO();
				if (destBsePortLocCd[i] != null)
					model.setDestBsePortLocCd(destBsePortLocCd[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (destCyDorRtTpCd[i] != null)
					model.setDestCyDorRtTpCd(destCyDorRtTpCd[i]);
				if (orgCyDorRtTpCd[i] != null)
					model.setOrgCyDorRtTpCd(orgCyDorRtTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (qttnNo[i] != null)
					model.setQttnNo(qttnNo[i]);
				if (qttnVerNo[i] != null)
					model.setQttnVerNo(qttnVerNo[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (orgBsePortLocCd[i] != null)
					model.setOrgBsePortLocCd(orgBsePortLocCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriRqRtCmdtRoutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriRqRtCmdtRoutVO[]
	 */
	public RsltPriRqRtCmdtRoutVO[] getRsltPriRqRtCmdtRoutVOs(){
		RsltPriRqRtCmdtRoutVO[] vos = (RsltPriRqRtCmdtRoutVO[])models.toArray(new RsltPriRqRtCmdtRoutVO[models.size()]);
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
		this.destBsePortLocCd = this.destBsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCyDorRtTpCd = this.destCyDorRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCyDorRtTpCd = this.orgCyDorRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo = this.qttnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo = this.qttnVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBsePortLocCd = this.orgBsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
