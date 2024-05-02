/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchYardDetailVO.java
*@FileTitle : SearchYardDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.07.29 노승배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo;

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
 * @author 노승배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchYardDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchYardDetailVO> models = new ArrayList<SearchYardDetailVO>();
	
	/* Column Info */
	private String operator1Name = null;
	/* Column Info */
	private String operator3Name = null;
	/* Column Info */
	private String gateWeekClose = null;
	/* Column Info */
	private String officeCode = null;
	/* Column Info */
	private String person = null;
	/* Column Info */
	private String yardOwnership = null;
	/* Column Info */
	private String tel = null;
	/* Column Info */
	private String operator2Name = null;
	/* Column Info */
	private String gateSatOpen = null;
	/* Column Info */
	private String demIbCollection = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String yardOperator2 = null;
	/* Column Info */
	private String gateSunOpen = null;
	/* Column Info */
	private String demObCollection = null;
	/* Column Info */
	private String yardOperator3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String postalCode = null;
	/* Column Info */
	private String serviceTypeRailramp = null;
	/* Column Info */
	private String bondedYard = null;
	/* Column Info */
	private String yardCode = null;
	/* Column Info */
	private String yardOperator1 = null;
	/* Column Info */
	private String gateHolidayClose = null;
	/* Column Info */
	private String serviceTypeMarinet = null;
	/* Column Info */
	private String nodeType = null;
	/* Column Info */
	private String serviceTypeBarget = null;
	/* Column Info */
	private String nodeCode = null;
	/* Column Info */
	private String hubNode = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String serviceTypeCfs = null;
	/* Column Info */
	private String serviceTypePseudoy = null;
	/* Column Info */
	private String gateSunClose = null;
	/* Column Info */
	private String gateWeekOpen = null;
	/* Column Info */
	private String cTpat = null;
	/* Column Info */
	private String gateHolidayOpen = null;
	/* Column Info */
	private String locationCode = null;
	/* Column Info */
	private String yardAddress = null;
	/* Column Info */
	private String email = null;
	/* Column Info */
	private String yardOnOff = null;
	/* Column Info */
	private String freeTime = null;
	/* Column Info */
	private String serviceTypeCy = null;
	/* Column Info */
	private String gateSatClose = null;
	/* Column Info */
	private String yardName = null;
	/* Column Info */
	private String ibAverageDwellR = null;
	/* Column Info */
	private String ibAverageDwellD = null;
	/* Column Info */
	private String ibMinimumDwellR = null;
	/* Column Info */
	private String ibMinimumDwellD = null;
	/* Column Info */
	private String obAverageDwellR = null;
	/* Column Info */
	private String obAverageDwellD = null;
	/* Column Info */
	private String obMinimumDwellR = null;
	/* Column Info */
	private String obMinimumDwellD = null;
	
	private String copObDryAvgDwllHrs = null;
	private String copIbDryAvgDwllHrs = null;
	private String copObRfAvgDwllHrs = null;
	private String copIbRfAvgDwllHrs = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchYardDetailVO() {}

	public SearchYardDetailVO(String ibflag, String pagerows, String yardCode, String locationCode, String yardName, String nodeType, String hubNode, String serviceTypeMarinet, String serviceTypeBarget, String serviceTypeCy, String serviceTypeCfs, String serviceTypeRailramp, String serviceTypePseudoy, String person, String email, String tel, String fax, String postalCode, String yardAddress, String gateWeekOpen, String gateWeekClose, String gateSatOpen, String gateSatClose, String gateSunOpen, String gateSunClose, String gateHolidayOpen, String gateHolidayClose,  String freeTime, String yardOperator1, String operator1Name, String yardOperator2, String operator2Name, String yardOperator3, String operator3Name, String officeCode, String demIbCollection, String demObCollection, String yardOwnership, String bondedYard, String cTpat, String yardOnOff, String nodeCode
			                 ,String ibAverageDwellR , String ibAverageDwellD , String ibMinimumDwellR , String ibMinimumDwellD , String obAverageDwellR ,String obAverageDwellD ,String obMinimumDwellR , String obMinimumDwellD
			                 ,String copObDryAvgDwllHrs, String copIbDryAvgDwllHrs, String copObRfAvgDwllHrs, String copIbRfAvgDwllHrs) {
		this.operator1Name = operator1Name;
		this.operator3Name = operator3Name;
		this.gateWeekClose = gateWeekClose;
		this.officeCode = officeCode;
		this.person = person;
		this.yardOwnership = yardOwnership;
		this.tel = tel;
		this.operator2Name = operator2Name;
		this.gateSatOpen = gateSatOpen;
		this.demIbCollection = demIbCollection;
		this.pagerows = pagerows;
		this.yardOperator2 = yardOperator2;
		this.gateSunOpen = gateSunOpen;
		this.demObCollection = demObCollection;
		this.yardOperator3 = yardOperator3;
		this.ibflag = ibflag;
		this.postalCode = postalCode;
		this.serviceTypeRailramp = serviceTypeRailramp;
		this.bondedYard = bondedYard;
		this.yardCode = yardCode;
		this.yardOperator1 = yardOperator1;
		this.gateHolidayClose = gateHolidayClose;
		this.serviceTypeMarinet = serviceTypeMarinet;
		this.nodeType = nodeType;
		this.serviceTypeBarget = serviceTypeBarget;
		this.nodeCode = nodeCode;
		this.hubNode = hubNode;
		this.fax = fax;
		this.serviceTypeCfs = serviceTypeCfs;
		this.serviceTypePseudoy = serviceTypePseudoy;
		this.gateSunClose = gateSunClose;
		this.gateWeekOpen = gateWeekOpen;
		this.cTpat = cTpat;
		this.gateHolidayOpen = gateHolidayOpen;
		this.locationCode = locationCode;
		this.yardAddress = yardAddress;
		this.email = email;
		this.yardOnOff = yardOnOff;
		this.freeTime = freeTime;
		this.serviceTypeCy = serviceTypeCy;
		this.gateSatClose = gateSatClose;
		this.yardName = yardName;
		this.ibAverageDwellD = ibAverageDwellD;
		this.ibAverageDwellR = ibAverageDwellR;
		this.ibMinimumDwellD = ibMinimumDwellD;
		this.ibMinimumDwellR = ibMinimumDwellR;
		this.obAverageDwellD = obAverageDwellD;
		this.obAverageDwellR = obAverageDwellR;
		this.obMinimumDwellD = obMinimumDwellD;
		this.obMinimumDwellR = obMinimumDwellR;
		
		this.copObDryAvgDwllHrs   = copObDryAvgDwllHrs;
		this.copIbDryAvgDwllHrs   = copIbDryAvgDwllHrs;
		this.copObRfAvgDwllHrs    = copObRfAvgDwllHrs ;
		this.copIbRfAvgDwllHrs    = copIbRfAvgDwllHrs ;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("operator1_name", getOperator1Name());
		this.hashColumns.put("operator3_name", getOperator3Name());
		this.hashColumns.put("gate_week_close", getGateWeekClose());
		this.hashColumns.put("office_code", getOfficeCode());
		this.hashColumns.put("person", getPerson());
		this.hashColumns.put("yard_ownership", getYardOwnership());
		this.hashColumns.put("tel", getTel());
		this.hashColumns.put("operator2_name", getOperator2Name());
		this.hashColumns.put("gate_sat_open", getGateSatOpen());
		this.hashColumns.put("dem_ib_collection", getDemIbCollection());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("yard_operator2", getYardOperator2());
		this.hashColumns.put("gate_sun_open", getGateSunOpen());
		this.hashColumns.put("dem_ob_collection", getDemObCollection());
		this.hashColumns.put("yard_operator3", getYardOperator3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("postal_code", getPostalCode());
		this.hashColumns.put("service_type_railramp", getServiceTypeRailramp());
		this.hashColumns.put("bonded_yard", getBondedYard());
		this.hashColumns.put("yard_code", getYardCode());
		this.hashColumns.put("yard_operator1", getYardOperator1());
		this.hashColumns.put("gate_holiday_close", getGateHolidayClose());
		this.hashColumns.put("service_type_marinet", getServiceTypeMarinet());
		this.hashColumns.put("node_type", getNodeType());
		this.hashColumns.put("service_type_barget", getServiceTypeBarget());
		this.hashColumns.put("node_code", getNodeCode());
		this.hashColumns.put("hub_node", getHubNode());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("service_type_cfs", getServiceTypeCfs());
		this.hashColumns.put("service_type_pseudoy", getServiceTypePseudoy());
		this.hashColumns.put("gate_sun_close", getGateSunClose());
		this.hashColumns.put("gate_week_open", getGateWeekOpen());
		this.hashColumns.put("c_tpat", getCTpat());
		this.hashColumns.put("gate_holiday_open", getGateHolidayOpen());
		this.hashColumns.put("location_code", getLocationCode());
		this.hashColumns.put("yard_address", getYardAddress());
		this.hashColumns.put("email", getEmail());
		this.hashColumns.put("yard_on_off", getYardOnOff());
		this.hashColumns.put("free_time", getFreeTime());
		this.hashColumns.put("service_type_cy", getServiceTypeCy());
		this.hashColumns.put("gate_sat_close", getGateSatClose());
		this.hashColumns.put("yard_name", getYardName());
		this.hashColumns.put("ib_average_dwell_r", getIbAverageDwellR());
		this.hashColumns.put("ib_average_dwell_d", getIbAverageDwellD());
		this.hashColumns.put("ib_minimum_dwell_r", getIbMinimumDwellR());
		this.hashColumns.put("ib_minimum_dwell_d", getIbMinimumDwellD());
		this.hashColumns.put("ob_average_dwell_r", getObAverageDwellR());
		this.hashColumns.put("ob_average_dwell_d", getObAverageDwellD());
		this.hashColumns.put("ob_minimum_dwell_r", getObMinimumDwellR());
		this.hashColumns.put("ob_minimum_dwell_d", getObMinimumDwellD());
		
		this.hashColumns.put("cop_ob_dry_avg_dwll_hrs", getCopObDryAvgDwllHrs());
		this.hashColumns.put("cop_ib_dry_avg_dwll_hrs", getCopIbDryAvgDwllHrs());
		this.hashColumns.put("cop_ob_rf_avg_dwll_hrs", getCopObRfAvgDwllHrs ());
		this.hashColumns.put("cop_ib_rf_avg_dwll_hrs", getCopIbRfAvgDwllHrs ());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("operator1_name", "operator1Name");
		this.hashFields.put("operator3_name", "operator3Name");
		this.hashFields.put("gate_week_close", "gateWeekClose");
		this.hashFields.put("office_code", "officeCode");
		this.hashFields.put("person", "person");
		this.hashFields.put("yard_ownership", "yardOwnership");
		this.hashFields.put("tel", "tel");
		this.hashFields.put("operator2_name", "operator2Name");
		this.hashFields.put("gate_sat_open", "gateSatOpen");
		this.hashFields.put("dem_ib_collection", "demIbCollection");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("yard_operator2", "yardOperator2");
		this.hashFields.put("gate_sun_open", "gateSunOpen");
		this.hashFields.put("dem_ob_collection", "demObCollection");
		this.hashFields.put("yard_operator3", "yardOperator3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("postal_code", "postalCode");
		this.hashFields.put("service_type_railramp", "serviceTypeRailramp");
		this.hashFields.put("bonded_yard", "bondedYard");
		this.hashFields.put("yard_code", "yardCode");
		this.hashFields.put("yard_operator1", "yardOperator1");
		this.hashFields.put("gate_holiday_close", "gateHolidayClose");
		this.hashFields.put("service_type_marinet", "serviceTypeMarinet");
		this.hashFields.put("node_type", "nodeType");
		this.hashFields.put("service_type_barget", "serviceTypeBarget");
		this.hashFields.put("node_code", "nodeCode");
		this.hashFields.put("hub_node", "hubNode");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("service_type_cfs", "serviceTypeCfs");
		this.hashFields.put("service_type_pseudoy", "serviceTypePseudoy");
		this.hashFields.put("gate_sun_close", "gateSunClose");
		this.hashFields.put("gate_week_open", "gateWeekOpen");
		this.hashFields.put("c_tpat", "cTpat");
		this.hashFields.put("gate_holiday_open", "gateHolidayOpen");
		this.hashFields.put("location_code", "locationCode");
		this.hashFields.put("yard_address", "yardAddress");
		this.hashFields.put("email", "email");
		this.hashFields.put("yard_on_off", "yardOnOff");
		this.hashFields.put("free_time", "freeTime");
		this.hashFields.put("service_type_cy", "serviceTypeCy");
		this.hashFields.put("gate_sat_close", "gateSatClose");
		this.hashFields.put("yard_name", "yardName");
		this.hashFields.put("ib_average_dwell_r" ,"ibAverageDwellR");
		this.hashFields.put("ib_average_dwell_d" ,"ibAverageDwellD");
		this.hashFields.put("ib_minimum_dwell_r" ,"ibMinimumDwellR");
		this.hashFields.put("ib_minimum_dwell_d" ,"ibMinimumDwellD");
		this.hashFields.put("ob_average_dwell_r" ,"obAverageDwellR");
		this.hashFields.put("ob_average_dwell_d", "obAverageDwellD");
		this.hashFields.put("ob_minimum_dwell_r", "obMinimumDwellR");
		this.hashFields.put("ob_minimum_dwell_d", "obMinimumDwellD");
		
		this.hashFields.put("cop_ob_dry_avg_dwll_hrs", "copObDryAvgDwllHrs");
		this.hashFields.put("cop_ib_dry_avg_dwll_hrs", "copIbDryAvgDwllHrs");
		this.hashFields.put("cop_ob_rf_avg_dwll_hrs", "copObRfAvgDwllHrs");
		this.hashFields.put("cop_ib_rf_avg_dwll_hrs", "copIbRfAvgDwllHrs");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return operator1Name
	 */
	public String getOperator1Name() {
		return this.operator1Name;
	}
	
	/**
	 * Column Info
	 * @return operator3Name
	 */
	public String getOperator3Name() {
		return this.operator3Name;
	}
	
	/**
	 * Column Info
	 * @return gateWeekClose
	 */
	public String getGateWeekClose() {
		return this.gateWeekClose;
	}
	
	/**
	 * Column Info
	 * @return officeCode
	 */
	public String getOfficeCode() {
		return this.officeCode;
	}
	
	/**
	 * Column Info
	 * @return person
	 */
	public String getPerson() {
		return this.person;
	}
	
	/**
	 * Column Info
	 * @return yardOwnership
	 */
	public String getYardOwnership() {
		return this.yardOwnership;
	}

	
	/**
	 * Column Info
	 * @return tel
	 */
	public String getTel() {
		return this.tel;
	}
	
	/**
	 * Column Info
	 * @return operator2Name
	 */
	public String getOperator2Name() {
		return this.operator2Name;
	}
	
	/**
	 * Column Info
	 * @return gateSatOpen
	 */
	public String getGateSatOpen() {
		return this.gateSatOpen;
	}
	
	/**
	 * Column Info
	 * @return demIbCollection
	 */
	public String getDemIbCollection() {
		return this.demIbCollection;
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
	 * @return yardOperator2
	 */
	public String getYardOperator2() {
		return this.yardOperator2;
	}
	
	/**
	 * Column Info
	 * @return gateSunOpen
	 */
	public String getGateSunOpen() {
		return this.gateSunOpen;
	}
	
	/**
	 * Column Info
	 * @return demObCollection
	 */
	public String getDemObCollection() {
		return this.demObCollection;
	}
	
	/**
	 * Column Info
	 * @return yardOperator3
	 */
	public String getYardOperator3() {
		return this.yardOperator3;
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
	 * @return postalCode
	 */
	public String getPostalCode() {
		return this.postalCode;
	}
	
	/**
	 * Column Info
	 * @return serviceTypeRailramp
	 */
	public String getServiceTypeRailramp() {
		return this.serviceTypeRailramp;
	}
	
	/**
	 * Column Info
	 * @return bondedYard
	 */
	public String getBondedYard() {
		return this.bondedYard;
	}
	
	/**
	 * Column Info
	 * @return yardCode
	 */
	public String getYardCode() {
		return this.yardCode;
	}
	
	/**
	 * Column Info
	 * @return yardOperator1
	 */
	public String getYardOperator1() {
		return this.yardOperator1;
	}
	
	/**
	 * Column Info
	 * @return gateHolidayClose
	 */
	public String getGateHolidayClose() {
		return this.gateHolidayClose;
	}
	
	/**
	 * Column Info
	 * @return serviceTypeMarinet
	 */
	public String getServiceTypeMarinet() {
		return this.serviceTypeMarinet;
	}
	
	/**
	 * Column Info
	 * @return nodeType
	 */
	public String getNodeType() {
		return this.nodeType;
	}
	
	/**
	 * Column Info
	 * @return serviceTypeBarget
	 */
	public String getServiceTypeBarget() {
		return this.serviceTypeBarget;
	}
	
	/**
	 * Column Info
	 * @return nodeCode
	 */
	public String getNodeCode() {
		return this.nodeCode;
	}
	
	/**
	 * Column Info
	 * @return hubNode
	 */
	public String getHubNode() {
		return this.hubNode;
	}
	/**
	 * Column Info
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
	}
	
	/**
	 * Column Info
	 * @return serviceTypeCfs
	 */
	public String getServiceTypeCfs() {
		return this.serviceTypeCfs;
	}
	
	/**
	 * Column Info
	 * @return serviceTypePseudoy
	 */
	public String getServiceTypePseudoy() {
		return this.serviceTypePseudoy;
	}
	
	/**
	 * Column Info
	 * @return gateSunClose
	 */
	public String getGateSunClose() {
		return this.gateSunClose;
	}
	
	/**
	 * Column Info
	 * @return gateWeekOpen
	 */
	public String getGateWeekOpen() {
		return this.gateWeekOpen;
	}
	
	/**
	 * Column Info
	 * @return cTpat
	 */
	public String getCTpat() {
		return this.cTpat;
	}
	
	/**
	 * Column Info
	 * @return gateHolidayOpen
	 */
	public String getGateHolidayOpen() {
		return this.gateHolidayOpen;
	}
	
	/**
	 * Column Info
	 * @return locationCode
	 */
	public String getLocationCode() {
		return this.locationCode;
	}
	
	/**
	 * Column Info
	 * @return yardAddress
	 */
	public String getYardAddress() {
		return this.yardAddress;
	}
	
	/**
	 * Column Info
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Column Info
	 * @return yardOnOff
	 */
	public String getYardOnOff() {
		return this.yardOnOff;
	}
	
	/**
	 * Column Info
	 * @return freeTime
	 */
	public String getFreeTime() {
		return this.freeTime;
	}
	
	/**
	 * Column Info
	 * @return serviceTypeCy
	 */
	public String getServiceTypeCy() {
		return this.serviceTypeCy;
	}
	
	/**
	 * Column Info
	 * @return gateSatClose
	 */
	public String getGateSatClose() {
		return this.gateSatClose;
	}
	
	/**
	 * Column Info
	 * @return yardName
	 */
	public String getYardName() {
		return this.yardName;
	}
	

	public String getCopObDryAvgDwllHrs() {
		return copObDryAvgDwllHrs;
	}

	public void setCopObDryAvgDwllHrs(String copObDryAvgDwllHrs) {
		this.copObDryAvgDwllHrs = copObDryAvgDwllHrs;
	}

	public String getCopIbDryAvgDwllHrs() {
		return copIbDryAvgDwllHrs;
	}

	public void setCopIbDryAvgDwllHrs(String copIbDryAvgDwllHrs) {
		this.copIbDryAvgDwllHrs = copIbDryAvgDwllHrs;
	}

	public String getCopObRfAvgDwllHrs() {
		return copObRfAvgDwllHrs;
	}

	public void setCopObRfAvgDwllHrs(String copObRfAvgDwllHrs) {
		this.copObRfAvgDwllHrs = copObRfAvgDwllHrs;
	}

	public String getCopIbRfAvgDwllHrs() {
		return copIbRfAvgDwllHrs;
	}

	public void setCopIbRfAvgDwllHrs(String copIbRfAvgDwllHrs) {
		this.copIbRfAvgDwllHrs = copIbRfAvgDwllHrs;
	}

	/**
	 * Column Info
	 * @param operator1Name
	 */
	public void setOperator1Name(String operator1Name) {
		this.operator1Name = operator1Name;
	}
	
	/**
	 * Column Info
	 * @param operator3Name
	 */
	public void setOperator3Name(String operator3Name) {
		this.operator3Name = operator3Name;
	}
	
	/**
	 * Column Info
	 * @param gateWeekClose
	 */
	public void setGateWeekClose(String gateWeekClose) {
		this.gateWeekClose = gateWeekClose;
	}
	
	/**
	 * Column Info
	 * @param officeCode
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
	/**
	 * Column Info
	 * @param person
	 */
	public void setPerson(String person) {
		this.person = person;
	}
	
	/**
	 * Column Info
	 * @param yardOwnership
	 */
	public void setYardOwnership(String yardOwnership) {
		this.yardOwnership = yardOwnership;
	}
	
	/**
	 * Column Info
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * Column Info
	 * @param operator2Name
	 */
	public void setOperator2Name(String operator2Name) {
		this.operator2Name = operator2Name;
	}
	
	/**
	 * Column Info
	 * @param gateSatOpen
	 */
	public void setGateSatOpen(String gateSatOpen) {
		this.gateSatOpen = gateSatOpen;
	}
	
	/**
	 * Column Info
	 * @param demIbCollection
	 */
	public void setDemIbCollection(String demIbCollection) {
		this.demIbCollection = demIbCollection;
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
	 * @param yardOperator2
	 */
	public void setYardOperator2(String yardOperator2) {
		this.yardOperator2 = yardOperator2;
	}
	
	/**
	 * Column Info
	 * @param gateSunOpen
	 */
	public void setGateSunOpen(String gateSunOpen) {
		this.gateSunOpen = gateSunOpen;
	}
	
	/**
	 * Column Info
	 * @param demObCollection
	 */
	public void setDemObCollection(String demObCollection) {
		this.demObCollection = demObCollection;
	}
	
	/**
	 * Column Info
	 * @param yardOperator3
	 */
	public void setYardOperator3(String yardOperator3) {
		this.yardOperator3 = yardOperator3;
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
	 * @param postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	/**
	 * Column Info
	 * @param serviceTypeRailramp
	 */
	public void setServiceTypeRailramp(String serviceTypeRailramp) {
		this.serviceTypeRailramp = serviceTypeRailramp;
	}
	
	/**
	 * Column Info
	 * @param bondedYard
	 */
	public void setBondedYard(String bondedYard) {
		this.bondedYard = bondedYard;
	}
	
	/**
	 * Column Info
	 * @param yardCode
	 */
	public void setYardCode(String yardCode) {
		this.yardCode = yardCode;
	}
	
	/**
	 * Column Info
	 * @param yardOperator1
	 */
	public void setYardOperator1(String yardOperator1) {
		this.yardOperator1 = yardOperator1;
	}
	
	/**
	 * Column Info
	 * @param gateHolidayClose
	 */
	public void setGateHolidayClose(String gateHolidayClose) {
		this.gateHolidayClose = gateHolidayClose;
	}
	
	/**
	 * Column Info
	 * @param serviceTypeMarinet
	 */
	public void setServiceTypeMarinet(String serviceTypeMarinet) {
		this.serviceTypeMarinet = serviceTypeMarinet;
	}
	
	/**
	 * Column Info
	 * @param nodeType
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	
	/**
	 * Column Info
	 * @param serviceTypeBarget
	 */
	public void setServiceTypeBarget(String serviceTypeBarget) {
		this.serviceTypeBarget = serviceTypeBarget;
	}
	
	/**
	 * Column Info
	 * @param nodeCode
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	
	/**
	 * Column Info
	 * @param hubNode
	 */
	public void setHubNode(String hubNode) {
		this.hubNode = hubNode;
	}
	
	/**
	 * Column Info
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * Column Info
	 * @param serviceTypeCfs
	 */
	public void setServiceTypeCfs(String serviceTypeCfs) {
		this.serviceTypeCfs = serviceTypeCfs;
	}
	
	/**
	 * Column Info
	 * @param serviceTypePseudoy
	 */
	public void setServiceTypePseudoy(String serviceTypePseudoy) {
		this.serviceTypePseudoy = serviceTypePseudoy;
	}
	
	/**
	 * Column Info
	 * @param gateSunClose
	 */
	public void setGateSunClose(String gateSunClose) {
		this.gateSunClose = gateSunClose;
	}
	
	/**
	 * Column Info
	 * @param gateWeekOpen
	 */
	public void setGateWeekOpen(String gateWeekOpen) {
		this.gateWeekOpen = gateWeekOpen;
	}
	
	/**
	 * Column Info
	 * @param cTpat
	 */
	public void setCTpat(String cTpat) {
		this.cTpat = cTpat;
	}
	
	/**
	 * Column Info
	 * @param gateHolidayOpen
	 */
	public void setGateHolidayOpen(String gateHolidayOpen) {
		this.gateHolidayOpen = gateHolidayOpen;
	}
	
	/**
	 * Column Info
	 * @param locationCode
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	/**
	 * Column Info
	 * @param yardAddress
	 */
	public void setYardAddress(String yardAddress) {
		this.yardAddress = yardAddress;
	}
	
	/**
	 * Column Info
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Column Info
	 * @param yardOnOff
	 */
	public void setYardOnOff(String yardOnOff) {
		this.yardOnOff = yardOnOff;
	}
	
	/**
	 * Column Info
	 * @param freeTime
	 */
	public void setFreeTime(String freeTime) {
		this.freeTime = freeTime;
	}
	
	/**
	 * Column Info
	 * @param serviceTypeCy
	 */
	public void setServiceTypeCy(String serviceTypeCy) {
		this.serviceTypeCy = serviceTypeCy;
	}
	
	/**
	 * Column Info
	 * @param gateSatClose
	 */
	public void setGateSatClose(String gateSatClose) {
		this.gateSatClose = gateSatClose;
	}
	
	/**
	 * Column Info
	 * @param yardName
	 */
	public void setYardName(String yardName) {
		this.yardName = yardName;
	}
	
	
	/**
	 * @return the ibAverageDwellR
	 */
	public String getIbAverageDwellR() {
		return ibAverageDwellR;
	}

	/**
	 * @param ibAverageDwellR the ibAverageDwellR to set
	 */
	public void setIbAverageDwellR(String ibAverageDwellR) {
		this.ibAverageDwellR = ibAverageDwellR;
	}

	/**
	 * @return the ibAverageDwellD
	 */
	public String getIbAverageDwellD() {
		return ibAverageDwellD;
	}

	/**
	 * @param ibAverageDwellD the ibAverageDwellD to set
	 */
	public void setIbAverageDwellD(String ibAverageDwellD) {
		this.ibAverageDwellD = ibAverageDwellD;
	}

	/**
	 * @return the ibMinimumDwellR
	 */
	public String getIbMinimumDwellR() {
		return ibMinimumDwellR;
	}

	/**
	 * @param ibMinimumDwellR the ibMinimumDwellR to set
	 */
	public void setIbMinimumDwellR(String ibMinimumDwellR) {
		this.ibMinimumDwellR = ibMinimumDwellR;
	}

	/**
	 * @return the ibMinimumDwellD
	 */
	public String getIbMinimumDwellD() {
		return ibMinimumDwellD;
	}

	/**
	 * @param ibMinimumDwellD the ibMinimumDwellD to set
	 */
	public void setIbMinimumDwellD(String ibMinimumDwellD) {
		this.ibMinimumDwellD = ibMinimumDwellD;
	}

	/**
	 * @return the obAverageDwellR
	 */
	public String getObAverageDwellR() {
		return obAverageDwellR;
	}

	/**
	 * @param obAverageDwellR the obAverageDwellR to set
	 */
	public void setObAverageDwellR(String obAverageDwellR) {
		this.obAverageDwellR = obAverageDwellR;
	}

	/**
	 * @return the obAverageDwellD
	 */
	public String getObAverageDwellD() {
		return obAverageDwellD;
	}

	/**
	 * @param obAverageDwellD the obAverageDwellD to set
	 */
	public void setObAverageDwellD(String obAverageDwellD) {
		this.obAverageDwellD = obAverageDwellD;
	}

	/**
	 * @return the obMinimumDwellR
	 */
	public String getObMinimumDwellR() {
		return obMinimumDwellR;
	}

	/**
	 * @param obMinimumDwellR the obMinimumDwellR to set
	 */
	public void setObMinimumDwellR(String obMinimumDwellR) {
		this.obMinimumDwellR = obMinimumDwellR;
	}

	/**
	 * @return the obMinimumDwellD
	 */
	public String getObMinimumDwellD() {
		return obMinimumDwellD;
	}

	/**
	 * @param obMinimumDwellD the obMinimumDwellD to set
	 */
	public void setObMinimumDwellD(String obMinimumDwellD) {
		this.obMinimumDwellD = obMinimumDwellD;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOperator1Name(JSPUtil.getParameter(request, "operator1_name", ""));
		setOperator3Name(JSPUtil.getParameter(request, "operator3_name", ""));
		setGateWeekClose(JSPUtil.getParameter(request, "gate_week_close", ""));
		setOfficeCode(JSPUtil.getParameter(request, "office_code", ""));
		setPerson(JSPUtil.getParameter(request, "person", ""));
		setYardOwnership(JSPUtil.getParameter(request, "yard_ownership", ""));
		setTel(JSPUtil.getParameter(request, "tel", ""));
		setOperator2Name(JSPUtil.getParameter(request, "operator2_name", ""));
		setGateSatOpen(JSPUtil.getParameter(request, "gate_sat_open", ""));
		setDemIbCollection(JSPUtil.getParameter(request, "dem_ib_collection", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setYardOperator2(JSPUtil.getParameter(request, "yard_operator2", ""));
		setGateSunOpen(JSPUtil.getParameter(request, "gate_sun_open", ""));
		setDemObCollection(JSPUtil.getParameter(request, "dem_ob_collection", ""));
		setYardOperator3(JSPUtil.getParameter(request, "yard_operator3", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPostalCode(JSPUtil.getParameter(request, "postal_code", ""));
		setServiceTypeRailramp(JSPUtil.getParameter(request, "service_type_railramp", ""));
		setBondedYard(JSPUtil.getParameter(request, "bonded_yard", ""));
		setYardCode(JSPUtil.getParameter(request, "yard_code", ""));
		setYardOperator1(JSPUtil.getParameter(request, "yard_operator1", ""));
		setGateHolidayClose(JSPUtil.getParameter(request, "gate_holiday_close", ""));
		setServiceTypeMarinet(JSPUtil.getParameter(request, "service_type_marinet", ""));
		setNodeType(JSPUtil.getParameter(request, "node_type", ""));
		setServiceTypeBarget(JSPUtil.getParameter(request, "service_type_barget", ""));
		setNodeCode(JSPUtil.getParameter(request, "node_code", ""));
		setHubNode(JSPUtil.getParameter(request, "hub_node", ""));
		setFax(JSPUtil.getParameter(request, "fax", ""));
		setServiceTypeCfs(JSPUtil.getParameter(request, "service_type_cfs", ""));
		setServiceTypePseudoy(JSPUtil.getParameter(request, "service_type_pseudoy", ""));
		setGateSunClose(JSPUtil.getParameter(request, "gate_sun_close", ""));
		setGateWeekOpen(JSPUtil.getParameter(request, "gate_week_open", ""));
		setCTpat(JSPUtil.getParameter(request, "c_tpat", ""));
		setGateHolidayOpen(JSPUtil.getParameter(request, "gate_holiday_open", ""));
		setLocationCode(JSPUtil.getParameter(request, "location_code", ""));
		setYardAddress(JSPUtil.getParameter(request, "yard_address", ""));
		setEmail(JSPUtil.getParameter(request, "email", ""));
		setYardOnOff(JSPUtil.getParameter(request, "yard_on_off", ""));
		setFreeTime(JSPUtil.getParameter(request, "free_time", ""));
		setServiceTypeCy(JSPUtil.getParameter(request, "service_type_cy", ""));
		setGateSatClose(JSPUtil.getParameter(request, "gate_sat_close", ""));
		setYardName(JSPUtil.getParameter(request, "yard_name", ""));
		setIbAverageDwellR(JSPUtil.getParameter(request, "ib_average_dwell_r", ""));
		setIbAverageDwellD(JSPUtil.getParameter(request, "ib_average_dwell_d", ""));
		setIbMinimumDwellR(JSPUtil.getParameter(request, "ib_minimum_dwell_r", ""));
		setIbMinimumDwellD(JSPUtil.getParameter(request, "ib_minimum_dwell_d", ""));
		setObAverageDwellR(JSPUtil.getParameter(request, "ob_average_dwell_r", ""));
		setObAverageDwellD(JSPUtil.getParameter(request, "ob_average_dwell_d", ""));
		setObMinimumDwellR(JSPUtil.getParameter(request, "ob_minimum_dwell_r", ""));
		setObMinimumDwellD(JSPUtil.getParameter(request, "ob_minimum_dwell_d", ""));

		setCopObDryAvgDwllHrs(JSPUtil.getParameter(request, "cop_ob_dry_avg_dwll_hrs", ""));
		setCopIbDryAvgDwllHrs(JSPUtil.getParameter(request, "cop_ib_dry_avg_dwll_hrs", ""));
		setCopObRfAvgDwllHrs (JSPUtil.getParameter(request, "cop_ob_rf_avg_dwll_hrs", ""));
		setCopIbRfAvgDwllHrs(JSPUtil.getParameter(request, "cop_ib_rf_avg_dwll_hrs", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchYardDetailVO[]
	 */
	public SearchYardDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchYardDetailVO[]
	 */
	public SearchYardDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchYardDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] operator1Name = (JSPUtil.getParameter(request, prefix	+ "operator1_name", length));
			String[] operator3Name = (JSPUtil.getParameter(request, prefix	+ "operator3_name", length));
			String[] gateWeekClose = (JSPUtil.getParameter(request, prefix	+ "gate_week_close", length));
			String[] officeCode = (JSPUtil.getParameter(request, prefix	+ "office_code", length));
			String[] person = (JSPUtil.getParameter(request, prefix	+ "person", length));
			String[] yardOwnership = (JSPUtil.getParameter(request, prefix	+ "yard_ownership", length));
			String[] tel = (JSPUtil.getParameter(request, prefix	+ "tel", length));
			String[] operator2Name = (JSPUtil.getParameter(request, prefix	+ "operator2_name", length));
			String[] gateSatOpen = (JSPUtil.getParameter(request, prefix	+ "gate_sat_open", length));
			String[] demIbCollection = (JSPUtil.getParameter(request, prefix	+ "dem_ib_collection", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] yardOperator2 = (JSPUtil.getParameter(request, prefix	+ "yard_operator2", length));
			String[] gateSunOpen = (JSPUtil.getParameter(request, prefix	+ "gate_sun_open", length));
			String[] demObCollection = (JSPUtil.getParameter(request, prefix	+ "dem_ob_collection", length));
			String[] yardOperator3 = (JSPUtil.getParameter(request, prefix	+ "yard_operator3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] postalCode = (JSPUtil.getParameter(request, prefix	+ "postal_code", length));
			String[] serviceTypeRailramp = (JSPUtil.getParameter(request, prefix	+ "service_type_railramp", length));
			String[] bondedYard = (JSPUtil.getParameter(request, prefix	+ "bonded_yard", length));
			String[] yardCode = (JSPUtil.getParameter(request, prefix	+ "yard_code", length));
			String[] yardOperator1 = (JSPUtil.getParameter(request, prefix	+ "yard_operator1", length));
			String[] gateHolidayClose = (JSPUtil.getParameter(request, prefix	+ "gate_holiday_close", length));
			String[] serviceTypeMarinet = (JSPUtil.getParameter(request, prefix	+ "service_type_marinet", length));
			String[] nodeType = (JSPUtil.getParameter(request, prefix	+ "node_type", length));
			String[] serviceTypeBarget = (JSPUtil.getParameter(request, prefix	+ "service_type_barget", length));
			String[] nodeCode = (JSPUtil.getParameter(request, prefix	+ "node_code", length));
			String[] hubNode = (JSPUtil.getParameter(request, prefix	+ "hub_node", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] serviceTypeCfs = (JSPUtil.getParameter(request, prefix	+ "service_type_cfs", length));
			String[] serviceTypePseudoy = (JSPUtil.getParameter(request, prefix	+ "service_type_pseudoy", length));
			String[] gateSunClose = (JSPUtil.getParameter(request, prefix	+ "gate_sun_close", length));
			String[] gateWeekOpen = (JSPUtil.getParameter(request, prefix	+ "gate_week_open", length));
			String[] cTpat = (JSPUtil.getParameter(request, prefix	+ "c_tpat", length));
			String[] gateHolidayOpen = (JSPUtil.getParameter(request, prefix	+ "gate_holiday_open", length));
			String[] locationCode = (JSPUtil.getParameter(request, prefix	+ "location_code", length));
			String[] yardAddress = (JSPUtil.getParameter(request, prefix	+ "yard_address", length));
			String[] email = (JSPUtil.getParameter(request, prefix	+ "email", length));
			String[] yardOnOff = (JSPUtil.getParameter(request, prefix	+ "yard_on_off", length));
			String[] freeTime = (JSPUtil.getParameter(request, prefix	+ "free_time", length));
			String[] serviceTypeCy = (JSPUtil.getParameter(request, prefix	+ "service_type_cy", length));
			String[] gateSatClose = (JSPUtil.getParameter(request, prefix	+ "gate_sat_close", length));
			String[] yardName = (JSPUtil.getParameter(request, prefix	+ "yard_name", length));
			
			String[] ibAverageDwellR = (JSPUtil.getParameter(request, prefix	+ "ib_average_dwell_r", length));
			String[] ibAverageDwellD = (JSPUtil.getParameter(request, prefix	+ "ib_average_dwell_d", length));
			String[] ibMinimumDwellR = (JSPUtil.getParameter(request, prefix	+ "ib_minimum_dwell_r", length));
			String[] ibMinimumDwellD = (JSPUtil.getParameter(request, prefix	+ "ib_minimum_dwell_d", length));
			String[] obAverageDwellR = (JSPUtil.getParameter(request, prefix	+ "ob_average_dwell_r", length));
			String[] obAverageDwellD = (JSPUtil.getParameter(request, prefix	+ "ob_average_dwell_d", length));
			String[] obMinimumDwellR = (JSPUtil.getParameter(request, prefix	+ "ob_minimum_dwell_r", length));
			String[] obMinimumDwellD = (JSPUtil.getParameter(request, prefix	+ "ob_minimum_dwell_d", length));
			
			String[] copObDryAvgDwllHrs = (JSPUtil.getParameter(request, prefix	+ "cop_ob_dry_avg_dwll_hrs", length));
			String[] copIbDryAvgDwllHrs = (JSPUtil.getParameter(request, prefix	+ "cop_ib_dry_avg_dwll_hrs", length));
			String[] copObRfAvgDwllHrs  = (JSPUtil.getParameter(request, prefix	+ "cop_ob_rf_avg_dwll_hrs", length));
			String[] copIbRfAvgDwllHrs = (JSPUtil.getParameter(request, prefix	+ "cop_ib_rf_avg_dwll_hrs", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchYardDetailVO();
				if (operator1Name[i] != null)
					model.setOperator1Name(operator1Name[i]);
				if (operator3Name[i] != null)
					model.setOperator3Name(operator3Name[i]);
				if (gateWeekClose[i] != null)
					model.setGateWeekClose(gateWeekClose[i]);
				if (officeCode[i] != null)
					model.setOfficeCode(officeCode[i]);
				if (person[i] != null)
					model.setPerson(person[i]);
				if (yardOwnership[i] != null)
					model.setYardOwnership(yardOwnership[i]);
				if (tel[i] != null)
					model.setTel(tel[i]);
				if (operator2Name[i] != null)
					model.setOperator2Name(operator2Name[i]);
				if (gateSatOpen[i] != null)
					model.setGateSatOpen(gateSatOpen[i]);
				if (demIbCollection[i] != null)
					model.setDemIbCollection(demIbCollection[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (yardOperator2[i] != null)
					model.setYardOperator2(yardOperator2[i]);
				if (gateSunOpen[i] != null)
					model.setGateSunOpen(gateSunOpen[i]);
				if (demObCollection[i] != null)
					model.setDemObCollection(demObCollection[i]);
				if (yardOperator3[i] != null)
					model.setYardOperator3(yardOperator3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (postalCode[i] != null)
					model.setPostalCode(postalCode[i]);
				if (serviceTypeRailramp[i] != null)
					model.setServiceTypeRailramp(serviceTypeRailramp[i]);
				if (bondedYard[i] != null)
					model.setBondedYard(bondedYard[i]);
				if (yardCode[i] != null)
					model.setYardCode(yardCode[i]);
				if (yardOperator1[i] != null)
					model.setYardOperator1(yardOperator1[i]);
				if (gateHolidayClose[i] != null)
					model.setGateHolidayClose(gateHolidayClose[i]);
				if (serviceTypeMarinet[i] != null)
					model.setServiceTypeMarinet(serviceTypeMarinet[i]);
				if (nodeType[i] != null)
					model.setNodeType(nodeType[i]);
				if (serviceTypeBarget[i] != null)
					model.setServiceTypeBarget(serviceTypeBarget[i]);
				if (nodeCode[i] != null)
					model.setNodeCode(nodeCode[i]);
				if (hubNode[i] != null)
					model.setHubNode(hubNode[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (serviceTypeCfs[i] != null)
					model.setServiceTypeCfs(serviceTypeCfs[i]);
				if (serviceTypePseudoy[i] != null)
					model.setServiceTypePseudoy(serviceTypePseudoy[i]);
				if (gateSunClose[i] != null)
					model.setGateSunClose(gateSunClose[i]);
				if (gateWeekOpen[i] != null)
					model.setGateWeekOpen(gateWeekOpen[i]);
				if (cTpat[i] != null)
					model.setCTpat(cTpat[i]);
				if (gateHolidayOpen[i] != null)
					model.setGateHolidayOpen(gateHolidayOpen[i]);
				if (locationCode[i] != null)
					model.setLocationCode(locationCode[i]);
				if (yardAddress[i] != null)
					model.setYardAddress(yardAddress[i]);
				if (email[i] != null)
					model.setEmail(email[i]);
				if (yardOnOff[i] != null)
					model.setYardOnOff(yardOnOff[i]);
				if (freeTime[i] != null)
					model.setFreeTime(freeTime[i]);
				if (serviceTypeCy[i] != null)
					model.setServiceTypeCy(serviceTypeCy[i]);
				if (gateSatClose[i] != null)
					model.setGateSatClose(gateSatClose[i]);
				if (yardName[i] != null)
					model.setYardName(yardName[i]);
				if (ibAverageDwellR[i] != null)
					model.setIbAverageDwellR(ibAverageDwellR[i]);
				if (ibAverageDwellD[i] != null)
					model.setIbAverageDwellD(ibAverageDwellD[i]);
				if (ibMinimumDwellR[i] != null)
					model.setIbMinimumDwellR(ibMinimumDwellR[i]);
				if (ibMinimumDwellD[i] != null)
					model.setIbMinimumDwellD(ibMinimumDwellD[i]);
				if (obAverageDwellR[i] != null)
					model.setObMinimumDwellR(obAverageDwellR[i]);
				if (obAverageDwellD[i] != null)
					model.setObMinimumDwellD(obAverageDwellD[i]);
				if (obMinimumDwellR[i] != null)
					model.setObMinimumDwellR(obMinimumDwellR[i]);
				if (obMinimumDwellD[i] != null)
					model.setObMinimumDwellD(obMinimumDwellD[i]);

				if (copObDryAvgDwllHrs[i] != null)
					model.setCopObDryAvgDwllHrs(copObDryAvgDwllHrs[i]);
				if (copIbDryAvgDwllHrs[i] != null)
					model.setCopIbDryAvgDwllHrs(copIbDryAvgDwllHrs[i]);
				if (copObRfAvgDwllHrs [i] != null)
					model.setCopObRfAvgDwllHrs (copObRfAvgDwllHrs [i]);
				if (copIbRfAvgDwllHrs [i] != null)
					model.setCopIbRfAvgDwllHrs (copIbRfAvgDwllHrs [i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchYardDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchYardDetailVO[]
	 */
	public SearchYardDetailVO[] getSearchYardDetailVOs(){
		SearchYardDetailVO[] vos = (SearchYardDetailVO[])models.toArray(new SearchYardDetailVO[models.size()]);
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
		this.operator1Name = this.operator1Name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operator3Name = this.operator3Name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateWeekClose = this.gateWeekClose .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.officeCode = this.officeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.person = this.person .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardOwnership = this.yardOwnership .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tel = this.tel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operator2Name = this.operator2Name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateSatOpen = this.gateSatOpen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demIbCollection = this.demIbCollection .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardOperator2 = this.yardOperator2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateSunOpen = this.gateSunOpen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demObCollection = this.demObCollection .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardOperator3 = this.yardOperator3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postalCode = this.postalCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serviceTypeRailramp = this.serviceTypeRailramp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bondedYard = this.bondedYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCode = this.yardCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardOperator1 = this.yardOperator1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateHolidayClose = this.gateHolidayClose .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serviceTypeMarinet = this.serviceTypeMarinet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeType = this.nodeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serviceTypeBarget = this.serviceTypeBarget .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeCode = this.nodeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubNode = this.hubNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serviceTypeCfs = this.serviceTypeCfs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serviceTypePseudoy = this.serviceTypePseudoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateSunClose = this.gateSunClose .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateWeekOpen = this.gateWeekOpen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cTpat = this.cTpat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateHolidayOpen = this.gateHolidayOpen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCode = this.locationCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardAddress = this.yardAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.email = this.email .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardOnOff = this.yardOnOff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeTime = this.freeTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serviceTypeCy = this.serviceTypeCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateSatClose = this.gateSatClose .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardName = this.yardName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibAverageDwellD = this.ibAverageDwellD.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");;
		this.ibAverageDwellR = this.ibAverageDwellR.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");;
		this.ibMinimumDwellD = this.ibMinimumDwellD.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");;
		this.ibMinimumDwellR = this.ibMinimumDwellR.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");;
		this.obAverageDwellR = this.obAverageDwellR.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");;
		this.obMinimumDwellR = this.obMinimumDwellR.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");;
		this.obAverageDwellD = this.obAverageDwellD.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");;
		this.obMinimumDwellD = this.obMinimumDwellD.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");;
		
		this.copObDryAvgDwllHrs = this.copObDryAvgDwllHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");;
		this.copIbDryAvgDwllHrs = this.copIbDryAvgDwllHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");;
		this.copObRfAvgDwllHrs  = this.copObRfAvgDwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");;
		this.copIbRfAvgDwllHrs = this.copIbRfAvgDwllHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");;
	}
}
