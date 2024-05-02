/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0046Event.java
*@FileTitle : Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.25
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.04 유혁
* 1.0 Creation
*
* History
* 2011.03.25 진마리아 CHM-201109579-01 Lane Code의 Direction 조회 칼럼 추가 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event;

import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LaneDirVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;


/**
 * VOP_VSK_0046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0046HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0046Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmVslSvcLaneVO[] mdmVslSvcLaneVOs = null;
	
	private LaneDirVO laneDirVO = null;
	
	private LaneDirVO[] laneDirVOs = null;
	
	public VopVsk0046Event(){}
	
	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO){
		this.mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}

	public void setMdmVslSvcLaneVOS(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs){
		if(mdmVslSvcLaneVOs != null){
			MdmVslSvcLaneVO[] tmpVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
			System.arraycopy(mdmVslSvcLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmVslSvcLaneVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this.mdmVslSvcLaneVOs = mdmVslSvcLaneVOs;
	}

	public MdmVslSvcLaneVO getMdmVslSvcLaneVO(){
		return mdmVslSvcLaneVO;
	}

	public MdmVslSvcLaneVO[] getMdmVslSvcLaneVOS(){
		MdmVslSvcLaneVO[] rtnVOs =  null;
		if(this.mdmVslSvcLaneVOs != null){
			rtnVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
			System.arraycopy(mdmVslSvcLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return mdmVslSvcLaneVOs;
	}

	public LaneDirVO getLaneDirVO() {
		return laneDirVO;
	}

	public void setLaneDirVO(LaneDirVO laneDirVO) {
		this.laneDirVO = laneDirVO;
	}

	public LaneDirVO[] getLaneDirVOs() {
		LaneDirVO[] rtnVOs =  null;
		if(this.laneDirVOs != null){
			rtnVOs = new LaneDirVO[laneDirVOs.length];
			System.arraycopy(laneDirVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return laneDirVOs;
	}

	public void setLaneDirVOs(LaneDirVO[] laneDirVOs) {
		if(laneDirVOs != null){
			LaneDirVO[] tmpVOs = new LaneDirVO[laneDirVOs.length];
			System.arraycopy(laneDirVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.laneDirVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this.laneDirVOs = laneDirVOs;
	}

}