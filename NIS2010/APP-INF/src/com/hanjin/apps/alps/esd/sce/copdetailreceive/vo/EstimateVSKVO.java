/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EstimateVSKVO.java
*@FileTitle : EstimateVSKVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.30 김성일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copdetailreceive.vo;

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
 * @author 김성일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EstimateVSKVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EstimateVSKVO> models = new ArrayList<EstimateVSKVO>();
	
	/* Column Info */
	private String inClptIndSeq = null;
	/* Column Info */
	private String vlSkdDate = null;
	/* Column Info */
	private String inVpsPortCd = null;
	/* Column Info */
	private String inActDt = null;
	/* Column Info */
	private String railRcvCoffFmDt = null;
	/* Column Info */
	private String inSkdVoyNo = null;
	/* Column Info */
	private String inSkdDirCd = null;
	/* Column Info */
	private String inActStsMapgCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String skdRcvTpCd = null;
	/* Column Info */
	private String trnkCop = null;
	/* Column Info */
	private String inVslCd = null;
	/* Column Info */
	private String estmGap = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inActRcvNo = null;
	/* Column Info */
	private String vlRow = null;
	/* Column Info */
	private String inActRcvDt = null;
	/* Column Info */
	private String inUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EstimateVSKVO() {}

	public EstimateVSKVO(String ibflag, String pagerows, String inActRcvDt, String inActRcvNo, String inVslCd, String inSkdVoyNo, String inSkdDirCd, String inVpsPortCd, String inClptIndSeq, String inActDt, String inActStsMapgCd, String inUsrId, String copNo, String copDtlSeq, String estmGap, String trnkCop, String vlRow, String vlSkdDate, String skdRcvTpCd, String railRcvCoffFmDt) {
		this.inClptIndSeq = inClptIndSeq;
		this.vlSkdDate = vlSkdDate;
		this.inVpsPortCd = inVpsPortCd;
		this.inActDt = inActDt;
		this.railRcvCoffFmDt = railRcvCoffFmDt;
		this.inSkdVoyNo = inSkdVoyNo;
		this.inSkdDirCd = inSkdDirCd;
		this.inActStsMapgCd = inActStsMapgCd;
		this.copNo = copNo;
		this.skdRcvTpCd = skdRcvTpCd;
		this.trnkCop = trnkCop;
		this.inVslCd = inVslCd;
		this.estmGap = estmGap;
		this.copDtlSeq = copDtlSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.inActRcvNo = inActRcvNo;
		this.vlRow = vlRow;
		this.inActRcvDt = inActRcvDt;
		this.inUsrId = inUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_clpt_ind_seq", getInClptIndSeq());
		this.hashColumns.put("vl_skd_date", getVlSkdDate());
		this.hashColumns.put("in_vps_port_cd", getInVpsPortCd());
		this.hashColumns.put("in_act_dt", getInActDt());
		this.hashColumns.put("rail_rcv_coff_fm_dt", getRailRcvCoffFmDt());
		this.hashColumns.put("in_skd_voy_no", getInSkdVoyNo());
		this.hashColumns.put("in_skd_dir_cd", getInSkdDirCd());
		this.hashColumns.put("in_act_sts_mapg_cd", getInActStsMapgCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("skd_rcv_tp_cd", getSkdRcvTpCd());
		this.hashColumns.put("trnk_cop", getTrnkCop());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("estm_gap", getEstmGap());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_act_rcv_no", getInActRcvNo());
		this.hashColumns.put("vl_row", getVlRow());
		this.hashColumns.put("in_act_rcv_dt", getInActRcvDt());
		this.hashColumns.put("in_usr_id", getInUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_clpt_ind_seq", "inClptIndSeq");
		this.hashFields.put("vl_skd_date", "vlSkdDate");
		this.hashFields.put("in_vps_port_cd", "inVpsPortCd");
		this.hashFields.put("in_act_dt", "inActDt");
		this.hashFields.put("rail_rcv_coff_fm_dt", "railRcvCoffFmDt");
		this.hashFields.put("in_skd_voy_no", "inSkdVoyNo");
		this.hashFields.put("in_skd_dir_cd", "inSkdDirCd");
		this.hashFields.put("in_act_sts_mapg_cd", "inActStsMapgCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("skd_rcv_tp_cd", "skdRcvTpCd");
		this.hashFields.put("trnk_cop", "trnkCop");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("estm_gap", "estmGap");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_act_rcv_no", "inActRcvNo");
		this.hashFields.put("vl_row", "vlRow");
		this.hashFields.put("in_act_rcv_dt", "inActRcvDt");
		this.hashFields.put("in_usr_id", "inUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inClptIndSeq
	 */
	public String getInClptIndSeq() {
		return this.inClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return vlSkdDate
	 */
	public String getVlSkdDate() {
		return this.vlSkdDate;
	}
	
	/**
	 * Column Info
	 * @return inVpsPortCd
	 */
	public String getInVpsPortCd() {
		return this.inVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return inActDt
	 */
	public String getInActDt() {
		return this.inActDt;
	}
	
	/**
	 * Column Info
	 * @return railRcvCoffFmDt
	 */
	public String getRailRcvCoffFmDt() {
		return this.railRcvCoffFmDt;
	}
	
	/**
	 * Column Info
	 * @return inSkdVoyNo
	 */
	public String getInSkdVoyNo() {
		return this.inSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return inSkdDirCd
	 */
	public String getInSkdDirCd() {
		return this.inSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return inActStsMapgCd
	 */
	public String getInActStsMapgCd() {
		return this.inActStsMapgCd;
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
	 * @return skdRcvTpCd
	 */
	public String getSkdRcvTpCd() {
		return this.skdRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @return trnkCop
	 */
	public String getTrnkCop() {
		return this.trnkCop;
	}
	
	/**
	 * Column Info
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
	}
	
	/**
	 * Column Info
	 * @return estmGap
	 */
	public String getEstmGap() {
		return this.estmGap;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return inActRcvNo
	 */
	public String getInActRcvNo() {
		return this.inActRcvNo;
	}
	
	/**
	 * Column Info
	 * @return vlRow
	 */
	public String getVlRow() {
		return this.vlRow;
	}
	
	/**
	 * Column Info
	 * @return inActRcvDt
	 */
	public String getInActRcvDt() {
		return this.inActRcvDt;
	}
	
	/**
	 * Column Info
	 * @return inUsrId
	 */
	public String getInUsrId() {
		return this.inUsrId;
	}
	

	/**
	 * Column Info
	 * @param inClptIndSeq
	 */
	public void setInClptIndSeq(String inClptIndSeq) {
		this.inClptIndSeq = inClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param vlSkdDate
	 */
	public void setVlSkdDate(String vlSkdDate) {
		this.vlSkdDate = vlSkdDate;
	}
	
	/**
	 * Column Info
	 * @param inVpsPortCd
	 */
	public void setInVpsPortCd(String inVpsPortCd) {
		this.inVpsPortCd = inVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param inActDt
	 */
	public void setInActDt(String inActDt) {
		this.inActDt = inActDt;
	}
	
	/**
	 * Column Info
	 * @param railRcvCoffFmDt
	 */
	public void setRailRcvCoffFmDt(String railRcvCoffFmDt) {
		this.railRcvCoffFmDt = railRcvCoffFmDt;
	}
	
	/**
	 * Column Info
	 * @param inSkdVoyNo
	 */
	public void setInSkdVoyNo(String inSkdVoyNo) {
		this.inSkdVoyNo = inSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param inSkdDirCd
	 */
	public void setInSkdDirCd(String inSkdDirCd) {
		this.inSkdDirCd = inSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param inActStsMapgCd
	 */
	public void setInActStsMapgCd(String inActStsMapgCd) {
		this.inActStsMapgCd = inActStsMapgCd;
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
	 * @param skdRcvTpCd
	 */
	public void setSkdRcvTpCd(String skdRcvTpCd) {
		this.skdRcvTpCd = skdRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @param trnkCop
	 */
	public void setTrnkCop(String trnkCop) {
		this.trnkCop = trnkCop;
	}
	
	/**
	 * Column Info
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
	}
	
	/**
	 * Column Info
	 * @param estmGap
	 */
	public void setEstmGap(String estmGap) {
		this.estmGap = estmGap;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param inActRcvNo
	 */
	public void setInActRcvNo(String inActRcvNo) {
		this.inActRcvNo = inActRcvNo;
	}
	
	/**
	 * Column Info
	 * @param vlRow
	 */
	public void setVlRow(String vlRow) {
		this.vlRow = vlRow;
	}
	
	/**
	 * Column Info
	 * @param inActRcvDt
	 */
	public void setInActRcvDt(String inActRcvDt) {
		this.inActRcvDt = inActRcvDt;
	}
	
	/**
	 * Column Info
	 * @param inUsrId
	 */
	public void setInUsrId(String inUsrId) {
		this.inUsrId = inUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInClptIndSeq(JSPUtil.getParameter(request, "in_clpt_ind_seq", ""));
		setVlSkdDate(JSPUtil.getParameter(request, "vl_skd_date", ""));
		setInVpsPortCd(JSPUtil.getParameter(request, "in_vps_port_cd", ""));
		setInActDt(JSPUtil.getParameter(request, "in_act_dt", ""));
		setRailRcvCoffFmDt(JSPUtil.getParameter(request, "rail_rcv_coff_fm_dt", ""));
		setInSkdVoyNo(JSPUtil.getParameter(request, "in_skd_voy_no", ""));
		setInSkdDirCd(JSPUtil.getParameter(request, "in_skd_dir_cd", ""));
		setInActStsMapgCd(JSPUtil.getParameter(request, "in_act_sts_mapg_cd", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setSkdRcvTpCd(JSPUtil.getParameter(request, "skd_rcv_tp_cd", ""));
		setTrnkCop(JSPUtil.getParameter(request, "trnk_cop", ""));
		setInVslCd(JSPUtil.getParameter(request, "in_vsl_cd", ""));
		setEstmGap(JSPUtil.getParameter(request, "estm_gap", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, "cop_dtl_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInActRcvNo(JSPUtil.getParameter(request, "in_act_rcv_no", ""));
		setVlRow(JSPUtil.getParameter(request, "vl_row", ""));
		setInActRcvDt(JSPUtil.getParameter(request, "in_act_rcv_dt", ""));
		setInUsrId(JSPUtil.getParameter(request, "in_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstimateVSKVO[]
	 */
	public EstimateVSKVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstimateVSKVO[]
	 */
	public EstimateVSKVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EstimateVSKVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "in_clpt_ind_seq", length));
			String[] vlSkdDate = (JSPUtil.getParameter(request, prefix	+ "vl_skd_date", length));
			String[] inVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "in_vps_port_cd", length));
			String[] inActDt = (JSPUtil.getParameter(request, prefix	+ "in_act_dt", length));
			String[] railRcvCoffFmDt = (JSPUtil.getParameter(request, prefix	+ "rail_rcv_coff_fm_dt", length));
			String[] inSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "in_skd_voy_no", length));
			String[] inSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "in_skd_dir_cd", length));
			String[] inActStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "in_act_sts_mapg_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] skdRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "skd_rcv_tp_cd", length));
			String[] trnkCop = (JSPUtil.getParameter(request, prefix	+ "trnk_cop", length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd", length));
			String[] estmGap = (JSPUtil.getParameter(request, prefix	+ "estm_gap", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inActRcvNo = (JSPUtil.getParameter(request, prefix	+ "in_act_rcv_no", length));
			String[] vlRow = (JSPUtil.getParameter(request, prefix	+ "vl_row", length));
			String[] inActRcvDt = (JSPUtil.getParameter(request, prefix	+ "in_act_rcv_dt", length));
			String[] inUsrId = (JSPUtil.getParameter(request, prefix	+ "in_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EstimateVSKVO();
				if (inClptIndSeq[i] != null)
					model.setInClptIndSeq(inClptIndSeq[i]);
				if (vlSkdDate[i] != null)
					model.setVlSkdDate(vlSkdDate[i]);
				if (inVpsPortCd[i] != null)
					model.setInVpsPortCd(inVpsPortCd[i]);
				if (inActDt[i] != null)
					model.setInActDt(inActDt[i]);
				if (railRcvCoffFmDt[i] != null)
					model.setRailRcvCoffFmDt(railRcvCoffFmDt[i]);
				if (inSkdVoyNo[i] != null)
					model.setInSkdVoyNo(inSkdVoyNo[i]);
				if (inSkdDirCd[i] != null)
					model.setInSkdDirCd(inSkdDirCd[i]);
				if (inActStsMapgCd[i] != null)
					model.setInActStsMapgCd(inActStsMapgCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (skdRcvTpCd[i] != null)
					model.setSkdRcvTpCd(skdRcvTpCd[i]);
				if (trnkCop[i] != null)
					model.setTrnkCop(trnkCop[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (estmGap[i] != null)
					model.setEstmGap(estmGap[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inActRcvNo[i] != null)
					model.setInActRcvNo(inActRcvNo[i]);
				if (vlRow[i] != null)
					model.setVlRow(vlRow[i]);
				if (inActRcvDt[i] != null)
					model.setInActRcvDt(inActRcvDt[i]);
				if (inUsrId[i] != null)
					model.setInUsrId(inUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEstimateVSKVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EstimateVSKVO[]
	 */
	public EstimateVSKVO[] getEstimateVSKVOs(){
		EstimateVSKVO[] vos = (EstimateVSKVO[])models.toArray(new EstimateVSKVO[models.size()]);
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
		this.inClptIndSeq = this.inClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vlSkdDate = this.vlSkdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVpsPortCd = this.inVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActDt = this.inActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRcvCoffFmDt = this.railRcvCoffFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdVoyNo = this.inSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdDirCd = this.inSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActStsMapgCd = this.inActStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdRcvTpCd = this.skdRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkCop = this.trnkCop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmGap = this.estmGap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActRcvNo = this.inActRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vlRow = this.vlRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActRcvDt = this.inActRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUsrId = this.inUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
