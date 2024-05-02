/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0078Event.java
*@FileTitle : Revenue Vessel Directiion Code Conversion Matrix
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ArFincDirConvVO;
import com.hanjin.syscommon.common.table.MdmRevLaneVO;


/**
 * FNS_INV_0078 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0078HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0078HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0078Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmRevLaneVO mdmRevLaneVO = null;
	private ArFincDirConvVO arFincDirConvVO = null;
	
	private String svcLan = null;
	private String dirChg = null;
	private String delFg = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmRevLaneVO[] mdmRevLaneVOs = null;
	private ArFincDirConvVO[] arFincDirConvVOs = null;

	public FnsInv0078Event(){}
	
	public void setMdmRevLaneVO(MdmRevLaneVO mdmRevLaneVO){
		this. mdmRevLaneVO = mdmRevLaneVO;
	}

	public void setMdmRevLaneVOS(MdmRevLaneVO[] mdmRevLaneVOs){
		this. mdmRevLaneVOs = mdmRevLaneVOs;
	}

	public MdmRevLaneVO getMdmRevLaneVO(){
		return mdmRevLaneVO;
	}

	public MdmRevLaneVO[] getMdmRevLaneVOS(){
		return mdmRevLaneVOs;
	}

	
	/**
	 * @return the arFincDirConvVO
	 */
	public ArFincDirConvVO getArFincDirConvVO() {
		return arFincDirConvVO;
	}

	/**
	 * @param arFincDirConvVO the arFincDirConvVO to set
	 */
	public void setArFincDirConvVO(ArFincDirConvVO arFincDirConvVO) {
		this.arFincDirConvVO = arFincDirConvVO;
	}

	
	
	/**
	 * @return the arFincDirConvVOs
	 */
	public ArFincDirConvVO[] getArFincDirConvVOs() {
		return arFincDirConvVOs;
	}

	/**
	 * @param arFincDirConvVOs the arFincDirConvVOs to set
	 */
	public void setArFincDirConvVOs(ArFincDirConvVO[] arFincDirConvVOs) {
		this.arFincDirConvVOs = arFincDirConvVOs;
	}

	/**
	 * @return the svcLan
	 */
	public String getSvcLan() {
		return svcLan;
	}

	/**
	 * @param svcLan the svcLan to set
	 */
	public void setSvcLan(String svcLan) {
		this.svcLan = svcLan;
	}

	/**
	 * @return the dirChg
	 */
	public String getDirChg() {
		return dirChg;
	}

	/**
	 * @param dirChg the dirChg to set
	 */
	public void setDirChg(String dirChg) {
		this.dirChg = dirChg;
	}

	/**
	 * @return the delFg
	 */
	public String getDelFg() {
		return delFg;
	}

	/**
	 * @param delFg the delFg to set
	 */
	public void setDelFg(String delFg) {
		this.delFg = delFg;
	}

	
	
	
}