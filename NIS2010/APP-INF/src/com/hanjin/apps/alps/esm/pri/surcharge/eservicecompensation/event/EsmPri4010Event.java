/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmsPri4009Event.java
*@FileTitle : E-Service Compensation Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.109 김대호
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo.PriCmpnEsvcVO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo.MdmSvcScpLmtVO;
/**
 * EMS_PRI_4010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EMS_PRI_4010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author day-hoh Kim
 * @see ESM_PRI_4010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriCmpnEsvcVO priCmpnEsvcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriCmpnEsvcVO[] priCmpnEsvcVOS = null;

	/** Table Value Object 조회 조건 및 단건 처리 - orgin 콤보 */
	private MdmSvcScpLmtVO mdmSvcScpLmtVO = null;

	/** Table Value Object 조회 조건 및 단건 처리 - sc no 조회*/
	private PriSpHdrVO priSpHdrVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리 - RFA no 조회*/
	private PriRpHdrVO priRpHdrVO = null;

	public EsmPri4010Event(){}
	
	public void setPriCmpnEsvcVO(PriCmpnEsvcVO priCmpnEsvcVO){
		this.priCmpnEsvcVO = priCmpnEsvcVO;
	}

	public void setPriCmpnEsvcVOS(PriCmpnEsvcVO[] priCmpnEsvcVOS){
		if(priCmpnEsvcVOS != null){
			PriCmpnEsvcVO[] tmpVOs = new PriCmpnEsvcVO[priCmpnEsvcVOS.length];
			System.arraycopy(priCmpnEsvcVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priCmpnEsvcVOS = tmpVOs;
		}
	}

	public void setMdmSvcScpLmtVO(MdmSvcScpLmtVO mdmSvcScpLmtVO){
		this.mdmSvcScpLmtVO = mdmSvcScpLmtVO;
	}

	public void setPriSpHdrVO(PriSpHdrVO priSpHdrVO){
		this.priSpHdrVO = priSpHdrVO;
	}

	public void setPriRpHdrVO(PriRpHdrVO priRpHdrVO){
		this.priRpHdrVO = priRpHdrVO;
	}

	public PriCmpnEsvcVO getPriCmpnEsvcVO(){
		return priCmpnEsvcVO;
	}

	public PriCmpnEsvcVO[] getPriCmpnEsvcVOS(){
		PriCmpnEsvcVO[] rtnVOs = null;
		if (this.priCmpnEsvcVOS != null) {
			rtnVOs = new PriCmpnEsvcVO[priCmpnEsvcVOS.length];
			System.arraycopy(priCmpnEsvcVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public MdmSvcScpLmtVO getMdmSvcScpLmtVO(){
		return mdmSvcScpLmtVO;
	}

	public PriSpHdrVO getPriSpHdrVO(){
		return priSpHdrVO;
	}

	public PriRpHdrVO getPriRpHdrVO(){
		return priRpHdrVO;
	}

}