/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3514Event.java
*@FileTitle : Inland Rates Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.21 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.event;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.PriTrfInlndListVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.PriTrfInlndParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTrfInlndRtVO;
import com.hanjin.syscommon.common.table.PriTrfInlndVO;


/**
 * ESM_PRI_3514 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3514HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNGMIN
 * @see ESM_PRI_3514HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3514Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 */
	PriTrfInlndListVO priTrfInlndListVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfInlndParamVO priTrfInlndParamVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfInlndRtVO priTrfInlndRtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTrfInlndRtVO[] priTrfInlndRtVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfInlndVO priTrfInlndVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTrfInlndVO[] priTrfInlndVOs = null;
	
	/** File Upload Key */
	private List<String> keys = null;

	public EsmPri3514Event(){}
	
	public void setPriTrfInlndRtVO(PriTrfInlndRtVO priTrfInlndRtVO){
		this. priTrfInlndRtVO = priTrfInlndRtVO;
	}

	public void setPriTrfInlndRtVOS(PriTrfInlndRtVO[] priTrfInlndRtVOs){
		this. priTrfInlndRtVOs = priTrfInlndRtVOs;
	}

	public PriTrfInlndRtVO getPriTrfInlndRtVO(){
		return priTrfInlndRtVO;
	}

	public PriTrfInlndRtVO[] getPriTrfInlndRtVOS(){
		return priTrfInlndRtVOs;
	}
	

	public void setPriTrfInlndVO(PriTrfInlndVO priTrfInlndVO){
		this. priTrfInlndVO = priTrfInlndVO;
	}

	public void setPriTrfInlndVOS(PriTrfInlndVO[] priTrfInlndVOs){
		this. priTrfInlndVOs = priTrfInlndVOs;
	}

	public PriTrfInlndVO getPriTrfInlndVO(){
		return priTrfInlndVO;
	}

	public PriTrfInlndVO[] getPriTrfInlndVOS(){
		return priTrfInlndVOs;
	}

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	public PriTrfInlndListVO getPriTrfInlndListVO() {
		return priTrfInlndListVO;
	}

	public void setPriTrfInlndListVO(PriTrfInlndListVO priTrfInlndListVO) {
		this.priTrfInlndListVO = priTrfInlndListVO;
	}

	public PriTrfInlndParamVO getPriTrfInlndParamVO() {
		return priTrfInlndParamVO;
	}

	public void setPriTrfInlndParamVO(PriTrfInlndParamVO priTrfInlndParamVO) {
		this.priTrfInlndParamVO = priTrfInlndParamVO;
	}

	
}