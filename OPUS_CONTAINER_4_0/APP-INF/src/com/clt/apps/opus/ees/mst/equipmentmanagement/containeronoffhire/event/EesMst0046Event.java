/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0046Event.java
*@FileTitle :  Manufacture Date & Manufacturer Inquiry and Update
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.02.18 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureListVO;
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

public class EesMst0046Event extends EventSupport {

	/**
	 * @return the cntrManufactureListVO
	 */
	public CntrManufactureListVO getCntrManufactureListVO() {
		return cntrManufactureListVO;
	}

	/**
	 * @param cntrManufactureListVO the cntrManufactureListVO to set
	 */
	public void setCntrManufactureListVO(CntrManufactureListVO cntrManufactureListVO) {
		this.cntrManufactureListVO = cntrManufactureListVO;
	}

	/**
	 * @return the cntrManufactureInfoVOs
	 */
	public CntrManufactureInfoVO[] getCntrManufactureInfoVOs() {
		CntrManufactureInfoVO[] tmpVOs = null;
		  if (this.cntrManufactureInfoVOs != null) {
		   tmpVOs = new CntrManufactureInfoVO[cntrManufactureInfoVOs.length];
		   System.arraycopy(cntrManufactureInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}
	/**
	 * @param cntrManufactureInfoVOs the cntrManufactureInfoVOs to set
	 */
	public void setCntrManufactureInfoVOs(
			CntrManufactureInfoVO[] cntrManufactureInfoVOs) {
		if (cntrManufactureInfoVOs != null) {
			CntrManufactureInfoVO[] tmpVOs = new CntrManufactureInfoVO[cntrManufactureInfoVOs.length];
			   System.arraycopy(cntrManufactureInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.cntrManufactureInfoVOs = tmpVOs;
			  }

	}
	/**
	 * @return the cntrManufactureListVOs
	 */
	public CntrManufactureListVO[] getCntrManufactureListVOs() {
		CntrManufactureListVO[] tmpVOs = null;
		  if (this.cntrManufactureListVOs != null) {
		   tmpVOs = new CntrManufactureListVO[cntrManufactureListVOs.length];
		   System.arraycopy(cntrManufactureListVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}
	/**
	 * @param cntrManufactureListVOs the cntrManufactureListVOs to set
	 */
	public void setCntrManufactureListVOs(
			CntrManufactureListVO[] cntrManufactureListVOs) {
		if (cntrManufactureListVOs != null) {
			CntrManufactureListVO[] tmpVOs = new CntrManufactureListVO[cntrManufactureListVOs.length];
			   System.arraycopy(cntrManufactureListVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.cntrManufactureListVOs = tmpVOs;
			  }

	}

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrManufactureListVO cntrManufactureListVO= null;
	
	/** 검색결과 **/
	private CntrManufactureInfoVO[] cntrManufactureInfoVOs = null;	
	/** 검색결과 **/
	private CntrManufactureListVO[] cntrManufactureListVOs = null;	
}