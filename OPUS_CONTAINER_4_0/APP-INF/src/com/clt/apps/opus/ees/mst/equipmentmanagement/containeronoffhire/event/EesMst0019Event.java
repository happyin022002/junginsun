/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0019Event.java
*@FileTitle : Container Master Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.16 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterInquiryVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
import com.clt.framework.support.layer.event.EventSupport;
/**
 * EES_MST_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MstEtcVO mstEtcVO = null;
	
	/** 검색리스트 처리  */
	private CntrMasterInquiryVO[] cntrMasterInquiryVO = null;
	
	/**
	 * @return the mstEtcVO
	 */
	public MstEtcVO getMstEtcVO() {
		return mstEtcVO;
	}

	/**
	 * @return the cntrMasterInquiryVO
	 */
	public CntrMasterInquiryVO[] getCntrMasterInquiryVO() {
		CntrMasterInquiryVO[] tmpVOs = null;
		  if (this.cntrMasterInquiryVO != null) {
		   tmpVOs = new CntrMasterInquiryVO[cntrMasterInquiryVO.length];
		   System.arraycopy(cntrMasterInquiryVO, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}

	/**
	 * @param cntrMasterInquiryVO the cntrMasterInquiryVO to set
	 */
	public void setCntrMasterInquiryVO(CntrMasterInquiryVO[] cntrMasterInquiryVO) {
		  if (cntrMasterInquiryVO != null) {
			  CntrMasterInquiryVO[] tmpVOs = new CntrMasterInquiryVO[cntrMasterInquiryVO.length];
			   System.arraycopy(cntrMasterInquiryVO, 0, tmpVOs, 0, tmpVOs.length);
			   this.cntrMasterInquiryVO = tmpVOs;
			  }

	}

	/**
	 * @param mstEtcVO the mstEtcVO to set
	 */
	public void setMstEtcVO(MstEtcVO mstEtcVO) {
		this.mstEtcVO = mstEtcVO;
	}
}