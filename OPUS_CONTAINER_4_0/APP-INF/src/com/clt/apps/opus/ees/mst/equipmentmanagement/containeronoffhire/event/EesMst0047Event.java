/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0047Event.java
*@FileTitle :  Reefer Unit Info Inquiry and Update
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.20
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.10.18 남궁진호
* 1.0 Creation [CHM-201006507-01]
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitListVO;
import com.clt.framework.support.layer.event.EventSupport;
/**
 * EES_MST_0046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0046HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0047Event extends EventSupport {

	/**
	 * @return the cntrReeferUnitListVO
	 */
	public CntrReeferUnitListVO getCntrReeferUnitListVO() {
		return cntrReeferUnitListVO;
	}

	/**
	 * @param cntrReeferUnitListVO the cntrReeferUnitListVO to set
	 */
	public void setCntrReeferUnitListVO(CntrReeferUnitListVO cntrReeferUnitListVO) {
		this.cntrReeferUnitListVO = cntrReeferUnitListVO;
	}

	/**
	 * @return the cntrReeferUnitInfoVOs
	 */
	public CntrReeferUnitInfoVO[] getCntrReeferUnitInfoVOs() {
		CntrReeferUnitInfoVO[] tmpVOs = null;
		  if (this.cntrReeferUnitInfoVOs != null) {
		   tmpVOs = new CntrReeferUnitInfoVO[cntrReeferUnitInfoVOs.length];
		   System.arraycopy(cntrReeferUnitInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}
	/**
	 * @param cntrReeferUnitInfoVOs the cntrReeferUnitInfoVOs to set
	 */
	public void setCntrReeferUnitInfoVOs(
			CntrReeferUnitInfoVO[] cntrReeferUnitInfoVOs) {
		  if (cntrReeferUnitInfoVOs != null) {
			  CntrReeferUnitInfoVO[] tmpVOs = new CntrReeferUnitInfoVO[cntrReeferUnitInfoVOs.length];
			   System.arraycopy(cntrReeferUnitInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.cntrReeferUnitInfoVOs = tmpVOs;
			  }

	}
	/**
	 * @return the cntrReeferUnitListVOs
	 */
	public CntrReeferUnitListVO[] getCntrReeferUnitListVOs() {
		CntrReeferUnitListVO[] tmpVOs = null;
		  if (this.cntrReeferUnitListVOs != null) {
		   tmpVOs = new CntrReeferUnitListVO[cntrReeferUnitListVOs.length];
		   System.arraycopy(cntrReeferUnitListVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}
	/**
	 * @param cntrReeferUnitListVOs the cntrReeferUnitListVOs to set
	 */
	public void setCntrReeferUnitListVOs(
			CntrReeferUnitListVO[] cntrReeferUnitListVOs) {
		  if (cntrReeferUnitListVOs != null) {
			  CntrReeferUnitListVO[] tmpVOs = new CntrReeferUnitListVO[cntrReeferUnitListVOs.length];
			   System.arraycopy(cntrReeferUnitListVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.cntrReeferUnitListVOs = tmpVOs;
			  }

	}

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrReeferUnitListVO cntrReeferUnitListVO= null;
	
	/** 검색결과 **/
	private CntrReeferUnitInfoVO[] cntrReeferUnitInfoVOs = null;	
	/** 검색결과 **/
	private CntrReeferUnitListVO[] cntrReeferUnitListVOs = null;	
}