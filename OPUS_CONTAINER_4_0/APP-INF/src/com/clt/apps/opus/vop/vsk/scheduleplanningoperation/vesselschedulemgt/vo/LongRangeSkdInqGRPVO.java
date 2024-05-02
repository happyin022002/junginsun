/**
 * 
 */
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.util.List;
import java.util.Map;


/**
 * @author Hyuk Ryu
 *
 */
public class LongRangeSkdInqGRPVO {
	
	private static final long serialVersionUID = 1L;
	
	private List<List<PortSkdOnLongRangeVO>> portSkdVOs;
	private Map<String, List<PfSkdDetailVO>> pfSkdDetails;
	private Map<String, List<PfSkdDetailVO>> pfSkdDetailsByGroup;
	
	private Map<String, String> portNms;
	private Map<String, String> vslEngNms;
	
	
	public Map<String, List<PfSkdDetailVO>> getPfSkdDetailsByGroup() {
		return pfSkdDetailsByGroup;
	}

	public void setPfSkdDetailsByGroup(
			Map<String, List<PfSkdDetailVO>> pfSkdDetailsByGroup) {
		this.pfSkdDetailsByGroup = pfSkdDetailsByGroup;
	}

	private List<LongRangeSkdInqVO> remarks;
	private List<List<List<PortSkdOnLongRangeVO>>> portSkdVOsByPf;
	
	public LongRangeSkdInqGRPVO() {}

	public List<List<PortSkdOnLongRangeVO>> getPortSkdVOs() {
		return portSkdVOs;
	}

	public void setPortSkdVOs(List<List<PortSkdOnLongRangeVO>> portSkdVOs) {
		this.portSkdVOs = portSkdVOs;
	}

	public Map<String, List<PfSkdDetailVO>> getPfSkdDetails() {
		return pfSkdDetails;
	}

	public void setPfSkdDetails(Map<String, List<PfSkdDetailVO>> pfSkdDetails) {
		this.pfSkdDetails = pfSkdDetails;
	}
	
	public List<LongRangeSkdInqVO> getRemarks(){
		return remarks;
	}
	
	public void setRemarks(List<LongRangeSkdInqVO> remarks){
		this.remarks = remarks;
	}
	
	public List<List<List<PortSkdOnLongRangeVO>>> getPortSkdVOsByPf() {
		return portSkdVOsByPf;
	}

	public void setPortSkdVOsByPf(List<List<List<PortSkdOnLongRangeVO>>> portSkdVOsByPf) {
		this.portSkdVOsByPf = portSkdVOsByPf;
	}

	public Map<String, String> getPortNms() {
		return portNms;
	}

	public void setPortNms(Map<String, String> portNms) {
		this.portNms = portNms;
	}

	public Map<String, String> getVslEngNms() {
		return vslEngNms;
	}

	public void setVslEngNms(Map<String, String> vslEngNms) {
		this.vslEngNms = vslEngNms;
	}
	
}
