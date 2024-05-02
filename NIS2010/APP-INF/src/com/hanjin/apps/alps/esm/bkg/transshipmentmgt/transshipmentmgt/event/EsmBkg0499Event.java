/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmBkg0499Event.java
*@FileTitle : Transit Time Report at T/S Port
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.16
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2012.01.16 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSTimeRptVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByTypeSizeVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0499 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0499HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Gyound Sub
 * @see ESM_BKG_0499HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0499Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TSTimeRptVO tSTimeRptVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TSTimeRptVO[] tSTimeRptVOs = null;

	/** Table Value Object 조회건  */
	private TurnTimeByTypeSizeVO turntimebytypesizevo = null;

	public EsmBkg0499Event(){}
	 
	public void setTSTimeRptVO(TSTimeRptVO tSTimeRptVO){
		this. tSTimeRptVO = tSTimeRptVO;
	}

	public void setTSTimeRptVOS(TSTimeRptVO[] tSTimeRptVOs){
		this. tSTimeRptVOs = tSTimeRptVOs;
	}

	public void setTurnTimeByTypeSizeVO(TurnTimeByTypeSizeVO turntimebytypesizevo){
		this. turntimebytypesizevo = turntimebytypesizevo;
	}

	public TSTimeRptVO getTSTimeRptVO(){
		return tSTimeRptVO;
	}

	public TSTimeRptVO[] getTSTimeRptVOS(){
		return tSTimeRptVOs;
	}

	public TurnTimeByTypeSizeVO getTurnTimeByTypeSizeVO(){
		return turntimebytypesizevo;
	}

}