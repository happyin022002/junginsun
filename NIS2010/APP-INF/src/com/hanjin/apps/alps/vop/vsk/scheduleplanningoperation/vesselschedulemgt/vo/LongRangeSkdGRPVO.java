/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : LongRangeSkdGRPVO.java
 *@FileTitle : LongRangeSkdGRPVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.05.21 유혁 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

public class LongRangeSkdGRPVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<LongRangeSkdGRPVO> models = new ArrayList<LongRangeSkdGRPVO>();

	/* Column Info */
	private String vslSlanCd;
	/* Column Info */
	private String pfSvcTpCd;
	/* Column Info */
	private String vslSvcTpCd;
	/* Column Info */
	private String endDate;
	/* Column Info */
	private String opType;
	/* Column Info */
	private String phaseinCol;
	/* Column Info */
	private String phaseinRow;
	/* Column Info */
	private String phaseinStartDate;
	/* Column Info */
	private String phaseinVslCd;
	/* Column Info */
	private String phaseinVoyNo;
	/* Column Info */
	private String addCallPoint;
	/* Column Info */
	private String addVvdPoint;
	/* Column Info */
	private String addCallPortCd;
	/* Column Info */
	private String addCallYardCd;
	/* Column Info */
	private String addCallEtb;
	/* Column Info */
	private String addCallEtd;
	/* Column Info */
	private String addCallTurnInd;
	/* Column Info */
	private String addCallPosition;
	/* Column Info */
	private String HeadTitle1;
	/* Column Info */
	private String HeadTitle2;
	/* Column Info */
	private String HeadTitle3;
	/* Column Info */
	private String HeadTitle4;
	/* Column Info */
	private String HeadTitle5;
	/* Column Info */
	private String HeadTitle6;
	/* Column Info */
	private String[] VVD1;
	/* Column Info */
	private String[] VVD2;
	/* Column Info */
	private String[] VVD3;
	/* Column Info */
	private String[] skdRmk;
	/* Column Info */
	private String[] pOutFlag;
	/* Column Info */
	private String[] pInFlag;
	/* Column Info */
	private List<String[]> vslInfo;
	/* Column Info */
	private Map<String, String[]> vslInfoMap;
	/* Column Info */
	private Map<String, String[]> simInfoMap;
	/* Column Info */
	private PfSkdVO[] pfSkdVOs;
	/* Column Info */
	private String creUsrId;
	/* Column Info */
	private String updUsrId;
	/* Column Info */
	private String voyNoType;
	/* Column Info */
	private String svcDurDys;
	/* Column Info */
	private String vslCount;
	
	private ActivationVvdVO[] bkgVVDs;
	private ActivationVvdVO[] virVVDs;
	private ActivationVvdVO[] bkgVirVVDs;
	private ActivationVvdVO[] nonBkgVVDs;
	
	private List<VskVslSkdVO> vskVslSkdList;
	
	/* hashColumnInpo */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* hashFildInpo */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public LongRangeSkdGRPVO() {
	}

	public LongRangeSkdGRPVO(String vslSlanCd, String pfSvcTpCd,
			String vslSvcTpCd, String endDate, String opType,
			String phaseinCol, String phaseinRow, String phaseinStartDate, String phaseinVslCd,
			String phaseinVoyNo, String addCallPoint, String addVvdPoint, String addCallPortCd, String addCallYardCd,
			String addCallEtb, String addCallEtd, String addCallTurnInd, String addCallPosition,
			String HeadTitle1, String HeadTitle2, String HeadTitle3, String HeadTitle4, String HeadTitle5, String HeadTitle6, String voyNoType, String svcDurDys, String vslCount) {
		this.vslSlanCd = vslSlanCd;
		this.pfSvcTpCd = pfSvcTpCd;
		this.vslSvcTpCd = vslSvcTpCd;
		this.endDate = endDate;
		this.opType = opType;
		this.phaseinCol = phaseinCol;
		this.phaseinRow = phaseinRow;
		this.phaseinStartDate = phaseinStartDate;
		this.phaseinVslCd = phaseinVslCd;
		this.phaseinVoyNo = phaseinVoyNo;
		this.addCallPoint = addCallPoint;
		this.addVvdPoint = addVvdPoint;
		this.addCallPortCd = addCallPortCd;
		this.addCallYardCd = addCallYardCd;
		this.addCallEtb = addCallEtb;
		this.addCallEtd = addCallEtd;
		this.addCallTurnInd = addCallTurnInd;
		this.addCallPosition = addCallPosition;
		this.HeadTitle1 = HeadTitle1;
		this.HeadTitle2 = HeadTitle2;
		this.HeadTitle3 = HeadTitle3;
		this.HeadTitle4 = HeadTitle4;
		this.HeadTitle5 = HeadTitle5;
		this.HeadTitle6 = HeadTitle6;
		this.voyNoType = voyNoType;
		this.svcDurDys = svcDurDys;
		this.vslCount = vslCount;
	}

	/**
	 * hashColumnInpo
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("end_date", getEndDate());
		this.hashColumns.put("op_type", getOpType());
		this.hashColumns.put("phasein_col", getPhaseinCol());
		this.hashColumns.put("phasein_row", getPhaseinRow());
		this.hashColumns.put("phasein_start_date", getPhaseinStartDate());
		this.hashColumns.put("phasein_vsl_cd", getPhaseinVslCd());
		this.hashColumns.put("phasein_voy_no", getPhaseinVoyNo());
		this.hashColumns.put("add_call_point", getAddCallPoint());
		this.hashColumns.put("add_vvd_point", getAddVvdPoint());
		this.hashColumns.put("add_call_port_cd", getAddCallPortCd());
		this.hashColumns.put("add_call_yard_cd", getAddCallYardCd());
		this.hashColumns.put("add_call_etb", getAddCallEtb());
		this.hashColumns.put("add_call_etd", getAddCallEtd());
		this.hashColumns.put("add_call_turn_ind", getAddCallTurnInd());
		this.hashColumns.put("add_call_position", getAddCallPosition());
		this.hashColumns.put("HeadTitle1", getHeadTitle1());
		this.hashColumns.put("HeadTitle2", getHeadTitle2());
		this.hashColumns.put("HeadTitle3", getHeadTitle3());
		this.hashColumns.put("HeadTitle4", getHeadTitle4());
		this.hashColumns.put("HeadTitle5", getHeadTitle5());
		this.hashColumns.put("HeadTitle6", getHeadTitle6());
		this.hashColumns.put("voy_no_type", getVoyNoType());
		this.hashColumns.put("svc_dur_dys", getSvcDurDys());
		this.hashColumns.put("vsl_count", getVslCount());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("end_date", "endDate");
		this.hashFields.put("op_type", "opType");
		this.hashFields.put("phasein_col", "phaseinCol");
		this.hashFields.put("phasein_row", "phaseinRow");
		this.hashFields.put("phasein_start_date", "phaseinStartDate");
		this.hashFields.put("phasein_vsl_cd", "phaseinVslCd");
		this.hashFields.put("phasein_voy_no", "phaseinVoyNo");
		this.hashFields.put("add_call_point", "addCallPoint");
		this.hashFields.put("add_vvd_point", "addVvdPoint");
		this.hashFields.put("add_call_port_cd", "addCallPortCd");
		this.hashFields.put("add_call_yard_cd", "addCallYardCd");
		this.hashFields.put("add_call_etb", "addCallEtb");
		this.hashFields.put("add_call_etd", "addCallEtd");
		this.hashFields.put("add_call_turn_ind", "addCallTurnInd");
		this.hashFields.put("add_call_position", "addCallPosition");
		this.hashFields.put("HeadTitle1", "HeadTitle1");
		this.hashFields.put("HeadTitle2", "HeadTitle2");
		this.hashFields.put("HeadTitle3", "HeadTitle3");
		this.hashFields.put("HeadTitle4", "HeadTitle4");
		this.hashFields.put("HeadTitle5", "HeadTitle5");
		this.hashFields.put("HeadTitle6", "HeadTitle6");
		this.hashFields.put("voy_no_type", "voyNoType");
		this.hashFields.put("svc_dur_dys", "svcDurDys");
		this.hashFields.put("vsl_count", "vslCount");
		return this.hashFields;
	}

	public String getVslSlanCd() {
		return this.vslSlanCd;
	}

	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
	}

	public String getVslSvcTpCd() {
		return this.vslSvcTpCd;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public String getOpType() {
		return this.opType;
	}

	public String getPhaseinCol() {
		return this.phaseinCol;
	}
	
	public String getPhaseinRow() {
		return this.phaseinRow;
	}

	public String getPhaseinStartDate() {
		return this.phaseinStartDate;
	}

	public String getPhaseinVslCd() {
		return this.phaseinVslCd;
	}

	public String getPhaseinVoyNo() {
		return this.phaseinVoyNo;
	}

	public String getAddCallPoint() {
		return this.addCallPoint;
	}
	
	public String getAddVvdPoint() {
		return this.addVvdPoint;
	}
	
	public String getAddCallPortCd() {
		return this.addCallPortCd;
	}
	
	public String getAddCallYardCd() {
		return this.addCallYardCd;
	}
	
	public String getAddCallEtb() {
		return this.addCallEtb;
	}
	
	public String getAddCallEtd() {
		return this.addCallEtd;
	}
	
	public String getAddCallTurnInd() {
		return this.addCallTurnInd;
	}
	
	public String getAddCallPosition() {
		return this.addCallPosition;
	}

	public String getHeadTitle1() {
		return this.HeadTitle1;
	}

	public String getHeadTitle2() {
		return this.HeadTitle2;
	}

	public String getHeadTitle3() {
		return this.HeadTitle3;
	}

	public String getHeadTitle4() {
		return this.HeadTitle4;
	}
	
	public String getHeadTitle5() {
		return this.HeadTitle5;
	}
	
	public String getHeadTitle6() {
		return this.HeadTitle6;
	}
	
	public String getVoyNoType(){
		return this.voyNoType;
	}
	
	public String getSvcDurDys(){
		return this.svcDurDys;
	}
	
	public String getVslCount(){
		return vslCount;
	}

	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}

	public void setPfSvcTpCd(String pfSvcTpCd) {
		this.pfSvcTpCd = pfSvcTpCd;
	}

	public void setVslSvcTpCd(String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public void setPhaseinCol(String phaseinCol) {
		this.phaseinCol = phaseinCol;
	}
	
	public void setPhaseinRow(String phaseinRow) {
		this.phaseinRow = phaseinRow;
	}

	public void setPhaseinStartDate(String phaseinStartDate) {
		this.phaseinStartDate = phaseinStartDate;
	}

	public void setPhaseinVslCd(String phaseinVslCd) {
		this.phaseinVslCd = phaseinVslCd;
	}

	public void setPhaseinVoyNo(String phaseinVoyNo) {
		this.phaseinVoyNo = phaseinVoyNo;
	}

	public void setAddCallPoint(String addCallPoint) {
		this.addCallPoint = addCallPoint;
	}
	
	public void setAddVvdPoint(String addVvdPoint) {
		this.addVvdPoint = addVvdPoint;
	}
	
	public void setAddCallPortCd(String addCallPortCd) {
		this.addCallPortCd = addCallPortCd;
	}
	
	public void setAddCallYardCd(String addCallYardCd) {
		this.addCallYardCd = addCallYardCd;
	}
	
	public void setAddCallEtb(String addCallEtb) {
		this.addCallEtb = addCallEtb;
	}
	
	public void setAddCallEtd(String addCallEtd) {
		this.addCallEtd = addCallEtd;
	}
	
	public void setAddCallTurnInd(String addCallTurnInd) {
		this.addCallTurnInd = addCallTurnInd;
	}
	
	public void setAddCallPosition(String addCallPosition) {
		this.addCallPosition = addCallPosition;
	}

	public void setHeadTitle1(String HeadTitle1) {
		this.HeadTitle1 = HeadTitle1;
	}

	public void setHeadTitle2(String HeadTitle2) {
		this.HeadTitle2 = HeadTitle2;
	}

	public void setHeadTitle3(String HeadTitle3) {
		this.HeadTitle3 = HeadTitle3;
	}

	public void setHeadTitle4(String HeadTitle4) {
		this.HeadTitle4 = HeadTitle4;
	}
	
	public void setHeadTitle5(String HeadTitle5) {
		this.HeadTitle5 = HeadTitle5;
	}
	
	public void setHeadTitle6(String HeadTitle6) {
		this.HeadTitle6 = HeadTitle6;
	}
	
	public void setVoyNoType(String voyNoType) {
		this.voyNoType = voyNoType;
	}
	
	public void setSvcDurDys(String svcDurDys) {
		this.svcDurDys = svcDurDys;
	}
	
	public void setVslCount(String vslCount) {
		this.vslCount = vslCount;
	}

	public void fromRequest(HttpServletRequest request) {
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, "pf_svc_tp_cd", ""));
		setVslSvcTpCd(JSPUtil.getParameter(request, "vsl_svc_tp_cd", ""));
		setEndDate(JSPUtil.getParameter(request, "end_date", ""));
		setOpType(JSPUtil.getParameter(request, "op_type", ""));
		setPhaseinCol(JSPUtil.getParameter(request, "phasein_col", ""));
		setPhaseinRow(JSPUtil.getParameter(request, "phasein_row", ""));
		setPhaseinStartDate(JSPUtil.getParameter(request, "phasein_start_date", ""));
		setPhaseinVslCd(JSPUtil.getParameter(request, "phasein_vsl_cd", ""));
		setPhaseinVoyNo(JSPUtil.getParameter(request, "phasein_voy_no", ""));
		setAddCallPoint(JSPUtil.getParameter(request, "add_call_point", ""));
		setAddVvdPoint(JSPUtil.getParameter(request, "add_vvd_point", ""));
		setAddCallPortCd(JSPUtil.getParameter(request, "add_call_port_cd", ""));
		setAddCallYardCd(JSPUtil.getParameter(request, "add_call_yard_cd", ""));
		setAddCallEtb(JSPUtil.getParameter(request, "add_call_etb", ""));
		setAddCallEtd(JSPUtil.getParameter(request, "add_call_etd", ""));
		setAddCallTurnInd(JSPUtil.getParameter(request, "add_call_turn_ind", ""));
		setAddCallPosition(JSPUtil.getParameter(request, "add_call_position", ""));
		setHeadTitle1(JSPUtil.getParameter(request, "HeadTitle1", ""));
		setHeadTitle2(JSPUtil.getParameter(request, "HeadTitle2", ""));
		setHeadTitle3(JSPUtil.getParameter(request, "HeadTitle3", ""));
		setHeadTitle4(JSPUtil.getParameter(request, "HeadTitle4", ""));
		setHeadTitle5(JSPUtil.getParameter(request, "HeadTitle5", ""));
		setHeadTitle6(JSPUtil.getParameter(request, "HeadTitle6", ""));
		setVoyNoType(JSPUtil.getParameter(request, "voy_no_type", ""));
		setSvcDurDys(JSPUtil.getParameter(request, "svc_dur_dys", ""));
		setVslCount(JSPUtil.getParameter(request, "vsl_count", ""));
	}

	public LongRangeSkdGRPVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public LongRangeSkdGRPVO[] fromRequestGrid(HttpServletRequest request,
			String prefix) {
		LongRangeSkdGRPVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix
					+ "vsl_slan_cd".trim(), length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix
					+ "pf_svc_tp_cd".trim(), length));
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix
					+ "vsl_svc_tp_cd".trim(), length));
			String[] endDate = (JSPUtil.getParameter(request, prefix
					+ "end_date".trim(), length));
			String[] opType = (JSPUtil.getParameter(request, prefix
					+ "op_type".trim(), length));
			String[] phaseinCol = (JSPUtil.getParameter(request, prefix
					+ "phasein_col".trim(), length));
			String[] phaseinRow = (JSPUtil.getParameter(request, prefix
					+ "phasein_row".trim(), length));
			String[] phaseinStartDate = (JSPUtil.getParameter(request, prefix
					+ "phasein_start_date".trim(), length));
			String[] phaseinVslCd = (JSPUtil.getParameter(request, prefix
					+ "phasein_vsl_cd".trim(), length));
			String[] phaseinVoyNo = (JSPUtil.getParameter(request, prefix
					+ "phasein_voy_no".trim(), length));
			String[] addCallPoint = (JSPUtil.getParameter(request, prefix
					+ "add_call_point".trim(), length));
			String[] addVvdPoint = (JSPUtil.getParameter(request, prefix
					+ "add_vvd_point".trim(), length));
			String[] addCallPortCd = (JSPUtil.getParameter(request, prefix
					+ "add_call_port_cd".trim(), length));
			String[] addCallYardCd = (JSPUtil.getParameter(request, prefix
					+ "add_call_yard_cd".trim(), length));
			String[] addCallEtb = (JSPUtil.getParameter(request, prefix
					+ "add_call_etb".trim(), length));
			String[] addCallEtd = (JSPUtil.getParameter(request, prefix
					+ "add_call_etd".trim(), length));
			String[] addCallTurnInd = (JSPUtil.getParameter(request, prefix
					+ "add_call_turn_ind".trim(), length));
			String[] addCallPosition = (JSPUtil.getParameter(request, prefix
					+ "add_call_position".trim(), length));
			String[] HeadTitle1 = (JSPUtil.getParameter(request, prefix
					+ "HeadTitle1".trim(), length));
			String[] HeadTitle2 = (JSPUtil.getParameter(request, prefix
					+ "HeadTitle2".trim(), length));
			String[] HeadTitle3 = (JSPUtil.getParameter(request, prefix
					+ "HeadTitle3".trim(), length));
			String[] HeadTitle4 = (JSPUtil.getParameter(request, prefix
					+ "HeadTitle4".trim(), length));
			String[] HeadTitle5 = (JSPUtil.getParameter(request, prefix
					+ "HeadTitle5".trim(), length));
			String[] HeadTitle6 = (JSPUtil.getParameter(request, prefix
					+ "HeadTitle6".trim(), length));
			String[] voyNoType = (JSPUtil.getParameter(request, prefix
					+ "voy_no_type".trim(), length));
			String[] svcDurDys = (JSPUtil.getParameter(request, prefix
					+ "svc_dur_dys".trim(), length));
			String[] vslCount = (JSPUtil.getParameter(request, prefix
					+ "vsl_count".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new LongRangeSkdGRPVO();
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (endDate[i] != null)
					model.setEndDate(endDate[i]);
				if (opType[i] != null)
					model.setOpType(opType[i]);
				if (phaseinCol[i] != null)
					model.setPhaseinCol(phaseinCol[i]);
				if (phaseinRow[i] != null)
					model.setPhaseinRow(phaseinRow[i]);
				if (phaseinStartDate[i] != null)
					model.setPhaseinStartDate(phaseinStartDate[i]);
				if (phaseinVslCd[i] != null)
					model.setPhaseinVslCd(phaseinVslCd[i]);
				if (phaseinVoyNo[i] != null)
					model.setPhaseinVoyNo(phaseinVoyNo[i]);
				if (addCallPoint[i] != null)
					model.setAddCallPoint(addCallPoint[i]);
				if (addVvdPoint[i] != null)
					model.setAddVvdPoint(addVvdPoint[i]);
				if (addCallPortCd[i] != null)
					model.setAddCallPortCd(addCallPortCd[i]);
				if (addCallYardCd[i] != null)
					model.setAddCallYardCd(addCallYardCd[i]);
				if (addCallEtb[i] != null)
					model.setAddCallEtb(addCallEtb[i]);
				if (addCallEtd[i] != null)
					model.setAddCallEtd(addCallEtd[i]);
				if (addCallTurnInd[i] != null)
					model.setAddCallTurnInd(addCallTurnInd[i]);
				if (addCallPosition[i] != null)
					model.setAddCallPosition(addCallPosition[i]);
				if (HeadTitle1[i] != null)
					model.setHeadTitle1(HeadTitle1[i]);
				if (HeadTitle2[i] != null)
					model.setHeadTitle2(HeadTitle2[i]);
				if (HeadTitle3[i] != null)
					model.setHeadTitle3(HeadTitle3[i]);
				if (HeadTitle4[i] != null)
					model.setHeadTitle4(HeadTitle4[i]);
				if (HeadTitle5[i] != null)
					model.setHeadTitle5(HeadTitle5[i]);
				if (HeadTitle6[i] != null)
					model.setHeadTitle6(HeadTitle6[i]);
				if (voyNoType[i] != null)
					model.setVoyNoType(voyNoType[i]);
				if (svcDurDys[i] != null)
					model.setSvcDurDys(svcDurDys[i]);
				if (vslCount[i] != null)
					model.setVslCount(vslCount[i]);
				models.add(model);
			}
		} catch (Exception e) {
		}
		return getLongRangeSkdGRPVOs();
	}

	public LongRangeSkdGRPVO[] getLongRangeSkdGRPVOs() {
		LongRangeSkdGRPVO[] vos = (LongRangeSkdGRPVO[]) models
				.toArray(new LongRangeSkdGRPVO[models.size()]);
		return vos;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(
								0, 30).concat("= ")
								+ arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
		}
		return ret.toString();
	}

	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i)
			throws IllegalAccessException {
		String[] arr;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}

	/**
	 * DataFormat 설정
	 */
	public void onDataFormat() {
		this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.vslSvcTpCd = this.vslSvcTpCd.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.endDate = this.endDate.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.opType = this.opType.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.phaseinCol = this.phaseinCol.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.phaseinRow = this.phaseinRow.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.phaseinStartDate = this.phaseinStartDate.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phaseinVslCd = this.phaseinVslCd.replaceAll(",", "").replaceAll(
				"-", "").replaceAll("/", "").replaceAll(":", "");
		this.phaseinVoyNo = this.phaseinVoyNo.replaceAll(",", "").replaceAll(
				"-", "").replaceAll("/", "").replaceAll(":", "");
		this.addCallPoint = this.addCallPoint.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.addCallPortCd = this.addCallPortCd.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.addCallYardCd = this.addCallYardCd.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.addCallEtb = this.addCallEtb.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.addCallEtd = this.addCallEtd.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.addCallTurnInd = this.addCallTurnInd.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.addCallPosition = this.addCallPosition.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.HeadTitle1 = this.HeadTitle1.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.HeadTitle2 = this.HeadTitle2.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.HeadTitle3 = this.HeadTitle3.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.HeadTitle4 = this.HeadTitle4.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.HeadTitle5 = this.HeadTitle5.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.HeadTitle6 = this.HeadTitle6.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.voyNoType = this.voyNoType.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.svcDurDys = this.svcDurDys.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.vslCount = this.vslCount.replaceAll(",", "").replaceAll("-",
		"").replaceAll("/", "").replaceAll(":", "");
	}

	// appened getter/setter

	public List<String[]> getVslInfo() {
		return vslInfo;
	}

	public void setVslInfo(List<String[]> vslInfo) {
		this.vslInfo = vslInfo;
	}

	public Map<String, String[]> getVslInfoMap() {
		return vslInfoMap;
	}

	public void setVslInfoMap(Map<String, String[]> vslInfoMap) {
		this.vslInfoMap = vslInfoMap;
	}

	public Map<String, String[]> getSimInfoMap() {
		return simInfoMap;
	}

	public void setSimInfoMap(Map<String, String[]> simInfoMap) {
		this.simInfoMap = simInfoMap;
	}

	public String[] getVVD1() {
		return VVD1;
	}

	public void setVVD1(String[] vvd1) {
		VVD1 = vvd1;
	}

	public String[] getVVD2() {
		return VVD2;
	}

	public void setVVD2(String[] vvd2) {
		VVD2 = vvd2;
	}

	public String[] getVVD3() {
		return VVD3;
	}

	public void setVVD3(String[] vvd3) {
		VVD3 = vvd3;
	}
	
	public String[] getSkdRmk() {
		return skdRmk;
	}
	
	public void setSkdRmk(String[] skdRmk) {
		this.skdRmk = skdRmk;
	}
	
	public String[] getPOutFlag() {
		return pOutFlag;
	}
	
	public void setPOutFlag(String[] pOutFlag) {
		this.pOutFlag = pOutFlag;
	}
	
	public String[] getPInFlag() {
		return pInFlag;
	}
	
	public void setPInFlag(String[] pInFlag) {
		this.pInFlag = pInFlag;
	}
	
	public PfSkdVO[] getPfSkdVOs(){
		return pfSkdVOs;
	}
	
	public void setPfSkdVOs(PfSkdVO[] pfSkdVOs){
		this.pfSkdVOs = pfSkdVOs;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public void setVskVslSkdList(List<VskVslSkdVO> vskVslSkdList) {
		this.vskVslSkdList = vskVslSkdList;
	}
	
	public List<VskVslSkdVO> getVskVslSkdList(){
		return vskVslSkdList;
	}

	public ActivationVvdVO[] getBkgVVDs() {
		return bkgVVDs;
	}

	public void setBkgVVDs(ActivationVvdVO[] bkgVVDs) {
		this.bkgVVDs = bkgVVDs;
	}

	public ActivationVvdVO[] getVirVVDs() {
		return virVVDs;
	}

	public void setVirVVDs(ActivationVvdVO[] virVVDs) {
		this.virVVDs = virVVDs;
	}

	public ActivationVvdVO[] getBkgVirVVDs() {
		return bkgVirVVDs;
	}

	public void setBkgVirVVDs(ActivationVvdVO[] bkgVirVVDs) {
		this.bkgVirVVDs = bkgVirVVDs;
	}

	public ActivationVvdVO[] getNonBkgVVDs() {
		return nonBkgVVDs;
	}

	public void setNonBkgVVDs(ActivationVvdVO[] nonBkgVVDs) {
		this.nonBkgVVDs = nonBkgVVDs;
	}
	
	
	
	
	
}