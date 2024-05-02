/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InPriCommodityRouteVO.java
*@FileTitle : InPriCommodityRouteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.11 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InPriCommodityRouteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InPriCommodityRouteVO> models = new ArrayList<InPriCommodityRouteVO>();
	
	/* Column Info */
	private String opTpCd = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String oriViaDefCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String destLocDefCd = null;
	/* Column Info */
	private String destViaDefCd = null;
	/* Column Info */
	private String oriLocDefCd = null;
	/* Column Info */
	private String qttnNo = null;
	/* Column Info */
	private String qttnVerNo = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String rateAdjust = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InPriCommodityRouteVO() {}

	public InPriCommodityRouteVO(String ibflag, String pagerows, String qttnNo, String qttnVerNo, String genSpclRtTpCd, String rateAdjust, String custCntCd, String custSeq, String cmdtHdrSeq, String orgDestTpCd, String oriLocDefCd, String destLocDefCd, String oriViaDefCd, String destViaDefCd, String opTpCd) {
		this.opTpCd = opTpCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.orgDestTpCd = orgDestTpCd;
		this.oriViaDefCd = oriViaDefCd;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.destLocDefCd = destLocDefCd;
		this.destViaDefCd = destViaDefCd;
		this.oriLocDefCd = oriLocDefCd;
		this.qttnNo = qttnNo;
		this.qttnVerNo = qttnVerNo;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.rateAdjust = rateAdjust;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("op_tp_cd", getOpTpCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("ori_via_def_cd", getOriViaDefCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dest_loc_def_cd", getDestLocDefCd());
		this.hashColumns.put("dest_via_def_cd", getDestViaDefCd());
		this.hashColumns.put("ori_loc_def_cd", getOriLocDefCd());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("rate_adjust", getRateAdjust());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("op_tp_cd", "opTpCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("ori_via_def_cd", "oriViaDefCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dest_loc_def_cd", "destLocDefCd");
		this.hashFields.put("dest_via_def_cd", "destViaDefCd");
		this.hashFields.put("ori_loc_def_cd", "oriLocDefCd");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("rate_adjust", "rateAdjust");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return opTpCd
	 */
	public String getOpTpCd() {
		return this.opTpCd;
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
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return oriViaDefCd
	 */
	public String getOriViaDefCd() {
		return this.oriViaDefCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return destLocDefCd
	 */
	public String getDestLocDefCd() {
		return this.destLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return destViaDefCd
	 */
	public String getDestViaDefCd() {
		return this.destViaDefCd;
	}
	
	/**
	 * Column Info
	 * @return oriLocDefCd
	 */
	public String getOriLocDefCd() {
		return this.oriLocDefCd;
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
	 * @return genSpclRtTpCd
	 */
	public String getGenSpclRtTpCd() {
		return this.genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return rateAdjust
	 */
	public String getRateAdjust() {
		return this.rateAdjust;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param opTpCd
	 */
	public void setOpTpCd(String opTpCd) {
		this.opTpCd = opTpCd;
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
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param oriViaDefCd
	 */
	public void setOriViaDefCd(String oriViaDefCd) {
		this.oriViaDefCd = oriViaDefCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param destLocDefCd
	 */
	public void setDestLocDefCd(String destLocDefCd) {
		this.destLocDefCd = destLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param destViaDefCd
	 */
	public void setDestViaDefCd(String destViaDefCd) {
		this.destViaDefCd = destViaDefCd;
	}
	
	/**
	 * Column Info
	 * @param oriLocDefCd
	 */
	public void setOriLocDefCd(String oriLocDefCd) {
		this.oriLocDefCd = oriLocDefCd;
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
	 * @param genSpclRtTpCd
	 */
	public void setGenSpclRtTpCd(String genSpclRtTpCd) {
		this.genSpclRtTpCd = genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param rateAdjust
	 */
	public void setRateAdjust(String rateAdjust) {
		this.rateAdjust = rateAdjust;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOpTpCd(JSPUtil.getParameter(request, "op_tp_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setOriViaDefCd(JSPUtil.getParameter(request, "ori_via_def_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDestLocDefCd(JSPUtil.getParameter(request, "dest_loc_def_cd", ""));
		setDestViaDefCd(JSPUtil.getParameter(request, "dest_via_def_cd", ""));
		setOriLocDefCd(JSPUtil.getParameter(request, "ori_loc_def_cd", ""));
		setQttnNo(JSPUtil.getParameter(request, "qttn_no", ""));
		setQttnVerNo(JSPUtil.getParameter(request, "qttn_ver_no", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, "gen_spcl_rt_tp_cd", ""));
		setRateAdjust(JSPUtil.getParameter(request, "rate_adjust", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InPriCommodityRouteVO[]
	 */
	public InPriCommodityRouteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InPriCommodityRouteVO[]
	 */
	public InPriCommodityRouteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InPriCommodityRouteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] opTpCd = (JSPUtil.getParameter(request, prefix	+ "op_tp_cd", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] oriViaDefCd = (JSPUtil.getParameter(request, prefix	+ "ori_via_def_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] destLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_def_cd", length));
			String[] destViaDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_via_def_cd", length));
			String[] oriLocDefCd = (JSPUtil.getParameter(request, prefix	+ "ori_loc_def_cd", length));
			String[] qttnNo = (JSPUtil.getParameter(request, prefix	+ "qttn_no", length));
			String[] qttnVerNo = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] rateAdjust = (JSPUtil.getParameter(request, prefix	+ "rate_adjust", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InPriCommodityRouteVO();
				if (opTpCd[i] != null)
					model.setOpTpCd(opTpCd[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (oriViaDefCd[i] != null)
					model.setOriViaDefCd(oriViaDefCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (destLocDefCd[i] != null)
					model.setDestLocDefCd(destLocDefCd[i]);
				if (destViaDefCd[i] != null)
					model.setDestViaDefCd(destViaDefCd[i]);
				if (oriLocDefCd[i] != null)
					model.setOriLocDefCd(oriLocDefCd[i]);
				if (qttnNo[i] != null)
					model.setQttnNo(qttnNo[i]);
				if (qttnVerNo[i] != null)
					model.setQttnVerNo(qttnVerNo[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (rateAdjust[i] != null)
					model.setRateAdjust(rateAdjust[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInPriCommodityRouteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InPriCommodityRouteVO[]
	 */
	public InPriCommodityRouteVO[] getInPriCommodityRouteVOs(){
		InPriCommodityRouteVO[] vos = (InPriCommodityRouteVO[])models.toArray(new InPriCommodityRouteVO[models.size()]);
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
		this.opTpCd = this.opTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriViaDefCd = this.oriViaDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocDefCd = this.destLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destViaDefCd = this.destViaDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriLocDefCd = this.oriLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo = this.qttnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo = this.qttnVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateAdjust = this.rateAdjust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
