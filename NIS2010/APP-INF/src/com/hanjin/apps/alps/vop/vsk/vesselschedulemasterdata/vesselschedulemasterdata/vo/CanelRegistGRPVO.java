package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;

public class CanelRegistGRPVO {

	private List<VendorVO> vendorVOs = null;
	private List<CanalAgencyLaneVO> canalAgencyLaneVOs = null;
	
	public CanelRegistGRPVO(){
		vendorVOs = new ArrayList<VendorVO>();
		canalAgencyLaneVOs = new ArrayList<CanalAgencyLaneVO>();
	}
	
	public void setVendorVOs(List<VendorVO> vendorVOs){
		this.vendorVOs = vendorVOs;
	}
	
	public List<VendorVO> getVendorVOs(){
		return this.vendorVOs;
	}
	
	public void setCanalAgencyLaneVOs(List<CanalAgencyLaneVO> canalAgencyLaneVOs){
		this.canalAgencyLaneVOs = canalAgencyLaneVOs;
	}
	
	public List<CanalAgencyLaneVO> getCanalAgencyLaneVOs(){
		return this.canalAgencyLaneVOs;
	}
	
}
