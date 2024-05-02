/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UdevhjsAlpsvskTActskdEvent.java
*@FileTitle : EDI to Terminal
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.10 서창열
* 1.0 Creation
* 
* History
* 2015.07.24 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * MQ에서 전문을 받는다<br>
 * <br>
 * <br>
 *
 * @author Chang Yul Seo
 * @see 
 * @since J2EE 1.6
 */

public class UdevhjsAlpsvskTActskdEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	public String flatFile = null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActSkdMgtVO actSkdMgtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActSkdMgtVO[] actSkdMgtVOs = null;
	
	private List<ActSkdMgtVO>actSkdMgtVOS = null;

	public UdevhjsAlpsvskTActskdEvent(){
		actSkdMgtVO = new ActSkdMgtVO();
		actSkdMgtVOS = new ArrayList<ActSkdMgtVO>();
	}

	/**
	 * @return the actSkdMgtVO
	 */
	public ActSkdMgtVO getActSkdMgtVO() {
		return actSkdMgtVO;
	}

	/**
	 * @param actSkdMgtVO the ActSkdMgtVO to set
	 */
	public void setActSkdMgtVO(ActSkdMgtVO actSkdMgtVO) {
		this.actSkdMgtVO = actSkdMgtVO;
	}

	/**
	 * @return the actSkdMgtVOs
	 */
	public ActSkdMgtVO[] getActSkdMgtVOs() {
//		return actSkdMgtVOs;
		ActSkdMgtVO[] rtnVOs = null;
		if (this.actSkdMgtVOs != null) {
			rtnVOs = new ActSkdMgtVO[actSkdMgtVOs.length];
			System.arraycopy(actSkdMgtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param actSkdMgtVOs the actSkdMgtVOs to set
	 */
	public void setActSkdMgtVOs(ActSkdMgtVO[] actSkdMgtVOs) {
//		this.actSkdMgtVOs = actSkdMgtVOs;
		if (actSkdMgtVOs != null) {
			ActSkdMgtVO[] tmpVOs = new ActSkdMgtVO[actSkdMgtVOs.length];
			System.arraycopy(actSkdMgtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.actSkdMgtVOs = tmpVOs;
		}
	}

}