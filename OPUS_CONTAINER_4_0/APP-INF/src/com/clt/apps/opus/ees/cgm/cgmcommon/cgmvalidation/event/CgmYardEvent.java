/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Check yardEvent.java
*@FileTitle : Check Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.05.27 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.YardINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.YardMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * Check Yard 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  Check YardHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see Check YardHTMLAction 참조
 * @since J2EE 1.6
 */

public class CgmYardEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private YardMGTVO cgmYardMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private YardMGTVO[] cgmYardMGTVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private YardINVO cgmYardINVO = null;

	/**
	 * @return the cgmYardINVO
	 */
	public YardINVO getCgmYardINVO() {
		return cgmYardINVO;
	}

	/**
	 * @param cgmYardINVO the cgmYardINVO to set
	 */
	public void setCgmYardINVO(YardINVO cgmYardINVO) {
		this.cgmYardINVO = cgmYardINVO;
	}

	public CgmYardEvent(){}
	
	public void setCgmYardMGTVO(YardMGTVO cgmYardMGTVO){
		this. cgmYardMGTVO = cgmYardMGTVO;
	}

	public void setCgmYardMGTVOS(YardMGTVO[] cgmYardMGTVOs){
		if(cgmYardMGTVOs != null){
			YardMGTVO[] tmpVOs = java.util.Arrays.copyOf(cgmYardMGTVOs, cgmYardMGTVOs.length);
			this.cgmYardMGTVOs = tmpVOs;
		}
	}

	public YardMGTVO getCgmYardMGTVO(){
		return cgmYardMGTVO;
	}

	public YardMGTVO[] getCgmYardMGTVOS(){
		YardMGTVO[] rtnVOs = null;
		if (this.cgmYardMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cgmYardMGTVOs, cgmYardMGTVOs.length);
		}
		return rtnVOs;
	}

}