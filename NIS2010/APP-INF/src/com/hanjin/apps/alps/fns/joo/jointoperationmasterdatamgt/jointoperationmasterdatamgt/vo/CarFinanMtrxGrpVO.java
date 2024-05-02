package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo;

import java.util.ArrayList;
import java.util.List;

public class CarFinanMtrxGrpVO {
	
	private CarrierVO carrierVO = null;
	private List<CarFinanMtrxVO> rCarFinanMtrxVOs = null;
	private List<CarFinanMtrxVO> eCarFinanMtrxVOs = null;

	public CarFinanMtrxGrpVO(){
		carrierVO = new CarrierVO();
		rCarFinanMtrxVOs = new ArrayList<CarFinanMtrxVO>();
		eCarFinanMtrxVOs = new ArrayList<CarFinanMtrxVO>();
	}
	
	public void setCarrierVO(CarrierVO pCarrierVO){
		carrierVO = pCarrierVO;
	}
	
	public CarrierVO getCarrierVO(){
		return carrierVO;
	}
	
	public void setRCarFinanMtrxVOs(List<CarFinanMtrxVO> carFinanMtrxVOs){
		rCarFinanMtrxVOs = carFinanMtrxVOs;
	}
	
	public List<CarFinanMtrxVO> getRCarFinanMtrxVOs(){
		return rCarFinanMtrxVOs;
	}

	public void setECarFinanMtrxVOs(List<CarFinanMtrxVO> carFinanMtrxVOs){
		eCarFinanMtrxVOs = carFinanMtrxVOs;
	}
	
	public List<CarFinanMtrxVO> getECarFinanMtrxVOs(){
		return eCarFinanMtrxVOs;
	}
}
