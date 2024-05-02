/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VskGloEvent.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.05.21 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.portselectpopup.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.common.portselectpopup.vo.PortVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmCountryVO;


/**
 * VSK_GLO 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VSK_GLO_HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_GLO_HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdTrs0981Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 업무 구분자 */
	private String op;
	
	/** LocationVO 조회 조건 및 단건 처리  */
	private PortVO portVO = null;
	
	/** LocationVO Multi Data 처리 */
	private PortVO[] portVOs = null;
	
	/** MdmCountryVO 조회 조건 및 단건 처리  */
	private MdmCountryVO mdmCountryVO = null;
	
	/** MdmCountryVO Multi Data 처리 */
	private MdmCountryVO[] mdmCountryVOs = null;
	
	public EsdTrs0981Event(){}
	
	/**
	 * 업무 구분자를 구한다.
	 * 
	 * @return String
	 */
	public String getOp() {
		return op;
	}

	/**
	 * 업무 구분자를 설정한다.
	 * 
	 * @param op String
	 */
	public void setOp(String op) {
		this.op = op;
	}

	/**
	 * PortVO 정보를 설정한다.
	 * 
	 * @param locationVO
	 */
	public void setPortVO(PortVO portVO){
		this.portVO = portVO;
	}

	/**
	 * PortVO 다건 정보를 설정한다.
	 * 
	 * @param locationVOs
	 */
	public void setPortVOS(PortVO[] portVOs){
		if (portVOs != null) {
			PortVO[] tmpVOs = Arrays.copyOf(portVOs, portVOs.length);
			this.portVOs = tmpVOs;
		} // end if
	}

	/**
	 * PortVO 정보를 구한다.
	 * 
	 * @return LocationVO
	 */
	public PortVO getPortVO(){
		return this.portVO;
	}

	/**
	 * PortVO 다건 정보를 구한다.
	 * 
	 * @return LocationVO[]
	 */
	public PortVO[] getPortVOS(){
		PortVO[] rtnVOs = null;
		if (this.portVOs != null) {
			rtnVOs = Arrays.copyOf(this.portVOs, this.portVOs.length);
		} // end if
		return rtnVOs;
	}
	
	/**
	 * MdmCountryVO 정보를 설정한다.
	 * 
	 * @param mdmCountryVO
	 */
	public void setMdmCountryVO(MdmCountryVO mdmCountryVO){
		this. mdmCountryVO = mdmCountryVO;
	}

	/**
	 * MdmCountryVO 다건 정보를 설정한다.
	 * 
	 * @param mdmCountryVOs
	 */
	public void setMdmCountryVOS(MdmCountryVO[] mdmCountryVOs){
		if (mdmCountryVOs != null) {
			MdmCountryVO[] tmpVOs = Arrays.copyOf(mdmCountryVOs, mdmCountryVOs.length);
			this.mdmCountryVOs = tmpVOs;
		} // end if
	}

	/**
	 * MdmCountryVO 정보를 구한다.
	 * 
	 * @return MdmCountryVO
	 */
	public MdmCountryVO getMdmCountryVO(){
		return mdmCountryVO;
	}

	/**
	 * MdmCountryVO 다건 정보를 구한다.
	 * 
	 * @return MdmCountryVO[]
	 */
	public MdmCountryVO[] getMdmCountryVOS(){
		MdmCountryVO[] rtnVOs = null;
		if (this.mdmCountryVOs != null) {
			rtnVOs = Arrays.copyOf(this.mdmCountryVOs, this.mdmCountryVOs.length);
		} // end if
		return rtnVOs;
	}
	
}