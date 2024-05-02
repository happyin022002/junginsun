/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UdevVskTActskdEvent
*@FileTitle : EDI to Terminal
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.10 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * MQ에서 전문을 받는다<br>
 * <br>
 * <br>
 *
 * @author Chang Yul Seo
 * @see 
 * @since J2EE 1.6
 */

public class UdevVskTActskdEvent extends EventSupport {

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

	public UdevVskTActskdEvent(){
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
		ActSkdMgtVO[] rtnVOs = null;
		if (this.actSkdMgtVOs != null) {
			rtnVOs = Arrays.copyOf(actSkdMgtVOs, actSkdMgtVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param actSkdMgtVOs the actSkdMgtVOs to set
	 */
	public void setActSkdMgtVOs(ActSkdMgtVO[] actSkdMgtVOs) {
		if(actSkdMgtVOs != null){
			ActSkdMgtVO[] tmpVOs = Arrays.copyOf(actSkdMgtVOs, actSkdMgtVOs.length);
			this.actSkdMgtVOs = tmpVOs;
		}
	}

}