package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.syscommon.common.table.MdmYardVO;
/**
 * Container Value Object<br>
 * - 조회결과를 전송하는 Container VO<br>
 *
 * @author 최영희
 * @since J2EE 1.6
 */
public class VslDischargingVO {
	List<VslDchgYdListVO> vslDchgYdListVO = new ArrayList<VslDchgYdListVO>();
	List<MdmYardVO> mdmYardVO = new ArrayList<MdmYardVO>();
	
	 
	public List<VslDchgYdListVO> getVslDchgYdListVO() {
		return vslDchgYdListVO;
	}
	public void setVslDchgYdListVO(List<VslDchgYdListVO> vslDchgYdListVO) {
		this.vslDchgYdListVO = vslDchgYdListVO;
	}
	public List<MdmYardVO> getMdmYardVO() {
		return mdmYardVO;
	}
	public void setMdmYardVO(List<MdmYardVO> mdmYardVO) {
		this.mdmYardVO = mdmYardVO;
	} 
	
}
