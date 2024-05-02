/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Esmagt0003Event.java
*@FileTitle : Agent Agreement Rate Creation 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.08.17 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.AgtAgnAgmtMstVO;
import com.hanjin.syscommon.common.table.AgtAgnAgmtVO;
import com.hanjin.syscommon.common.table.AgtAgnAgmtRtVO;
import com.hanjin.syscommon.common.table.AgtAgnChgRefVO;
import com.hanjin.syscommon.common.table.AgtAgnOtrRefVO;
import com.hanjin.syscommon.common.table.AgtAgnRoutRefVO;;


/**
 * EsmAgt0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EsmAgt0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Jin
 * @see EsmAgt0003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnAgmtMstVO agtAgnAgmtMstVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtAgnAgmtMstVO[] agtAgnAgmtMstVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnAgmtVO agtAgnAgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtAgnAgmtVO[] agtAgnAgmtVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnAgmtRtVO agtAgnAgmtRtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtAgnAgmtRtVO[] agtAgnAgmtRtVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnOtrRefVO agtAgnOtrRefVO = null;

	private AgtAgnOtrRefVO[] agtAgnOtrRefVOs = null;
	
	private AgtAgnChgRefVO agtAgnChgRefVO = null;
	
	private AgtAgnChgRefVO[] agtAgnChgRefVOs = null;
	
	private AgtAgnRoutRefVO agtAgnRoutRefVO = null;
	
	private AgtAgnRoutRefVO[] agtAgnRoutRefVOs = null;

	

	public EsmAgt0003Event(){}
	
	public void setAgtAgnAgmtMstVO(AgtAgnAgmtMstVO agtAgnAgmtMstVO){
		this. agtAgnAgmtMstVO = agtAgnAgmtMstVO;
	}

	public void setAgtAgnAgmtMstVOS(AgtAgnAgmtMstVO[] agtAgnAgmtMstVOs){
		this. agtAgnAgmtMstVOs = agtAgnAgmtMstVOs;
	}

	public void setAgtAgnAgmtVO(AgtAgnAgmtVO agtAgnAgmtVO){
		this. agtAgnAgmtVO = agtAgnAgmtVO;
	}

	public void setAgtAgnAgmtVOS(AgtAgnAgmtVO[] agtAgnAgmtVOs){
		this. agtAgnAgmtVOs = agtAgnAgmtVOs;
	}

	public void setAgtAgnAgmtRtVO(AgtAgnAgmtRtVO agtAgnAgmtRtVO){
		this. agtAgnAgmtRtVO = agtAgnAgmtRtVO;
	}

	public void setAgtAgnAgmtRtVOS(AgtAgnAgmtRtVO[] agtAgnAgmtRtVOs){
		this. agtAgnAgmtRtVOs = agtAgnAgmtRtVOs;
	}
	
	public void setAgtAgnOtrRefVO(AgtAgnOtrRefVO agtAgnOtrRefVO) {
    	this.agtAgnOtrRefVO = agtAgnOtrRefVO;
    }
	
	public void setAgtAgnOtrRefVOs(AgtAgnOtrRefVO[] agtAgnOtrRefVOs) {
    	this.agtAgnOtrRefVOs = agtAgnOtrRefVOs;
    }
	
	public void setAgtAgnChgRefVO(AgtAgnChgRefVO agtAgnChgRefVO) {
    	this.agtAgnChgRefVO = agtAgnChgRefVO;
    }
	
	public void setAgtAgnChgRefVOs(AgtAgnChgRefVO[] agtAgnChgRefVOs) {
    	this.agtAgnChgRefVOs = agtAgnChgRefVOs;
    }
	
	public void setAgtAgnRoutRefVO(AgtAgnRoutRefVO agtAgnRoutRefVO) {
    	this.agtAgnRoutRefVO = agtAgnRoutRefVO;
    }

	public void setAgtAgnRoutRefVOs(AgtAgnRoutRefVO[] agtAgnRoutRefVOs) {
    	this.agtAgnRoutRefVOs = agtAgnRoutRefVOs;
    }
	
	public AgtAgnAgmtMstVO getAgtAgnAgmtMstVO(){
		return agtAgnAgmtMstVO;
	}

	public AgtAgnAgmtMstVO[] getAgtAgnAgmtMstVOS(){
		return agtAgnAgmtMstVOs;
	}

	public AgtAgnAgmtVO getAgtAgnAgmtVO(){
		return agtAgnAgmtVO;
	}

	public AgtAgnAgmtVO[] getAgtAgnAgmtVOS(){
		return agtAgnAgmtVOs;
	}

	public AgtAgnAgmtRtVO getAgtAgnAgmtRtVO(){
		return agtAgnAgmtRtVO;
	}

	public AgtAgnAgmtRtVO[] getAgtAgnAgmtRtVOS(){
		return agtAgnAgmtRtVOs;
	}
	
	public AgtAgnOtrRefVO getAgtAgnOtrRefVO() {
    	return agtAgnOtrRefVO;
    }
	
	public AgtAgnOtrRefVO[] getAgtAgnOtrRefVOs() {
    	return agtAgnOtrRefVOs;
    }

	public AgtAgnChgRefVO getAgtAgnChgRefVO() {
    	return agtAgnChgRefVO;
    }

	public AgtAgnChgRefVO[] getAgtAgnChgRefVOs() {
    	return agtAgnChgRefVOs;
    }

	public AgtAgnRoutRefVO getAgtAgnRoutRefVO() {
    	return agtAgnRoutRefVO;
    }

	public AgtAgnRoutRefVO[] getAgtAgnRoutRefVOs() {
    	return agtAgnRoutRefVOs;
    }
}