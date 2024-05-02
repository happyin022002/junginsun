/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4021Event.java
*@FileTitle : Continent-Subcontinent Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.14 김재연
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.continent.event;

import com.hanjin.apps.alps.esm.pri.primasterdata.continent.vo.ContinentVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmContinentVO;
import com.hanjin.syscommon.common.table.MdmSubcontinentVO;


/**
 * ESM_PRI_4021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmContinentVO mdmContinentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmContinentVO[] mdmContinentVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmSubcontinentVO mdmSubcontinentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmSubcontinentVO[] mdmSubcontinentVOs = null;
	
	private ContinentVO continentVO = null;
	
	public EsmPri4021Event(){}
	
	public void setMdmContinentVO(MdmContinentVO mdmContinentVO){
		this. mdmContinentVO = mdmContinentVO;
	}

	public void setMdmContinentVOS(MdmContinentVO[] mdmContinentVOs){
		if(mdmContinentVOs != null){
			MdmContinentVO[] tmpVOs = new MdmContinentVO[mdmContinentVOs.length];
			System.arraycopy(mdmContinentVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmContinentVOs = tmpVOs;
		}
	}

	public void setMdmSubcontinentVO(MdmSubcontinentVO mdmSubcontinentVO){
		this. mdmSubcontinentVO = mdmSubcontinentVO;
	}

	public void setMdmSubcontinentVOS(MdmSubcontinentVO[] mdmSubcontinentVOs){
		if(mdmSubcontinentVOs != null){
			MdmSubcontinentVO[] tmpVOs = new MdmSubcontinentVO[mdmSubcontinentVOs.length];
			System.arraycopy(mdmSubcontinentVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmSubcontinentVOs = tmpVOs;
		}
	}

	public MdmContinentVO getMdmContinentVO(){
		return mdmContinentVO;
	}

	public MdmContinentVO[] getMdmContinentVOS(){
		MdmContinentVO[] rtnVOs = null;
		if (this.mdmContinentVOs != null) {
			rtnVOs = new MdmContinentVO[mdmContinentVOs.length];
			System.arraycopy(mdmContinentVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public MdmSubcontinentVO getMdmSubcontinentVO(){
		return mdmSubcontinentVO;
	}

	public MdmSubcontinentVO[] getMdmSubcontinentVOS(){
		MdmSubcontinentVO[] rtnVOs = null;
		if (this.mdmSubcontinentVOs != null) {
			rtnVOs = new MdmSubcontinentVO[mdmSubcontinentVOs.length];
			System.arraycopy(mdmSubcontinentVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setContinentVO(ContinentVO continentVO){
		this. continentVO = continentVO;
	}
	
	public ContinentVO getContinentVO(){
		return continentVO;
	}
}