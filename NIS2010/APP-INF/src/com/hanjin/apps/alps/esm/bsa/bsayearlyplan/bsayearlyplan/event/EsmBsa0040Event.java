/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBsa0040Event.java
*@FileTitle : BSA Creation (Yearly Plan)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.17 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.17 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event;

import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.BsaYearlyPlanConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BsaBudJntOpBzcVO;
import com.hanjin.syscommon.common.table.BsaBudJntOpCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaBudSltChtrBzcVO;
import com.hanjin.syscommon.common.table.BsaBudSltChtrCrrCapaVO;


/**
 * ESM_BSA_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see ESM_BSA_0040HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBsa0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** 조회 조건 단건처리 */
	private BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO = null;
	
	private BsaBudJntOpBzcVO bsaBudJntOpBzcVO = null;
	private BsaBudJntOpBzcVO[] bsaBudJntOpBzcVOs = null;
	
	private BsaBudJntOpCrrCapaVO bsaBudJntOpCrrCapaVO = null;
	private BsaBudJntOpCrrCapaVO[] bsaBudJntOpCrrCapaVOs = null;
	
	private BsaBudSltChtrBzcVO bsaBudSltChtrBzcVO = null;
	private BsaBudSltChtrBzcVO[] bsaBudSltChtrBzcVOs = null;
	
	private BsaBudSltChtrCrrCapaVO bsaBudSltChtrCrrCapaVO = null;
	private BsaBudSltChtrCrrCapaVO[] bsaBudSltChtrCrrCapaVOs = null;
	

	/** Constructor */
	public EsmBsa0040Event(){}	
	
	/** Search Condition Getter */
	public BsaYearlyPlanConditionVO getSearchBsaConditionVO() {
		return bsaYearlyPlanConditionVO;
	}

	/** Search Condition Setter */
	public void setBsaYearlyPlanConditionVO(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO) {
		this.bsaYearlyPlanConditionVO = bsaYearlyPlanConditionVO;
	}

	public BsaBudJntOpBzcVO getBsaBudJntOpBzcVO() {
		return bsaBudJntOpBzcVO;
	}

	public void setBsaBudJntOpBzcVO(BsaBudJntOpBzcVO bsaBudJntOpBzcVO) {
		this.bsaBudJntOpBzcVO = bsaBudJntOpBzcVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaBudJntOpBzcVO[] getBsaBudJntOpBzcVOs() {
		BsaBudJntOpBzcVO[] ret = null;
		if(this.bsaBudJntOpBzcVOs != null){
			ret = new BsaBudJntOpBzcVO[bsaBudJntOpBzcVOs.length];
			for(int i=0; i< bsaBudJntOpBzcVOs.length; i++){
				ret[i] = this.bsaBudJntOpBzcVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaBudJntOpBzcVOs(BsaBudJntOpBzcVO[] bsaBudJntOpBzcVOs) {
		this.bsaBudJntOpBzcVOs = new BsaBudJntOpBzcVO[bsaBudJntOpBzcVOs.length];
		for(int i=0; i< bsaBudJntOpBzcVOs.length; ++i){
			this.bsaBudJntOpBzcVOs[i] = bsaBudJntOpBzcVOs[i];
		}
	}

	public BsaBudJntOpCrrCapaVO getBsaBudJntOpCrrCapaVO() {
		return bsaBudJntOpCrrCapaVO;
	}

	public void setBsaBudJntOpCrrCapaVO(BsaBudJntOpCrrCapaVO bsaBudJntOpCrrCapaVO) {
		this.bsaBudJntOpCrrCapaVO = bsaBudJntOpCrrCapaVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaBudJntOpCrrCapaVO[] getBsaBudJntOpCrrCapaVOs() {
		BsaBudJntOpCrrCapaVO[] ret = null;
		if(this.bsaBudJntOpCrrCapaVOs != null){
			ret = new BsaBudJntOpCrrCapaVO[bsaBudJntOpCrrCapaVOs.length];
			for(int i=0; i< bsaBudJntOpCrrCapaVOs.length; i++){
				ret[i] = this.bsaBudJntOpCrrCapaVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaBudJntOpCrrCapaVOs(
			BsaBudJntOpCrrCapaVO[] bsaBudJntOpCrrCapaVOs) {
		this.bsaBudJntOpCrrCapaVOs = new BsaBudJntOpCrrCapaVO[bsaBudJntOpCrrCapaVOs.length];
		for(int i=0; i< bsaBudJntOpCrrCapaVOs.length; ++i){
			this.bsaBudJntOpCrrCapaVOs[i] = bsaBudJntOpCrrCapaVOs[i];
		}
	}

	public BsaBudSltChtrBzcVO getBsaBudSltChtrBzcVO() {
		return bsaBudSltChtrBzcVO;
	}

	public void setBsaBudSltChtrBzcVO(BsaBudSltChtrBzcVO bsaBudSltChtrBzcVO) {
		this.bsaBudSltChtrBzcVO = bsaBudSltChtrBzcVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaBudSltChtrBzcVO[] getBsaBudSltChtrBzcVOs() {
		BsaBudSltChtrBzcVO[] ret = null;
		if(this.bsaBudSltChtrBzcVOs != null){
			ret = new BsaBudSltChtrBzcVO[bsaBudSltChtrBzcVOs.length];
			for(int i=0; i< bsaBudSltChtrBzcVOs.length; i++){
				ret[i] = this.bsaBudSltChtrBzcVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaBudSltChtrBzcVOs(BsaBudSltChtrBzcVO[] bsaBudSltChtrBzcVOs) {
		this.bsaBudSltChtrBzcVOs = new BsaBudSltChtrBzcVO[bsaBudSltChtrBzcVOs.length];
		for(int i=0; i< bsaBudSltChtrBzcVOs.length; ++i){
			this.bsaBudSltChtrBzcVOs[i] = bsaBudSltChtrBzcVOs[i];
		}
	}

	public BsaBudSltChtrCrrCapaVO getBsaBudSltChtrCrrCapaVO() {
		return bsaBudSltChtrCrrCapaVO;
	}

	public void setBsaBudSltChtrCrrCapaVO(
			BsaBudSltChtrCrrCapaVO bsaBudSltChtrCrrCapaVO) {
		this.bsaBudSltChtrCrrCapaVO = bsaBudSltChtrCrrCapaVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaBudSltChtrCrrCapaVO[] getBsaBudSltChtrCrrCapaVOs() {
		BsaBudSltChtrCrrCapaVO[] ret = null;
		if(this.bsaBudSltChtrCrrCapaVOs != null){
			ret = new BsaBudSltChtrCrrCapaVO[bsaBudSltChtrCrrCapaVOs.length];
			for(int i=0; i< bsaBudSltChtrCrrCapaVOs.length; i++){
				ret[i] = this.bsaBudSltChtrCrrCapaVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaBudSltChtrCrrCapaVOs(
			BsaBudSltChtrCrrCapaVO[] bsaBudSltChtrCrrCapaVOs) {
		this.bsaBudSltChtrCrrCapaVOs = new BsaBudSltChtrCrrCapaVO[bsaBudSltChtrCrrCapaVOs.length];
		for(int i=0; i< bsaBudSltChtrCrrCapaVOs.length; ++i){
			this.bsaBudSltChtrCrrCapaVOs[i] = bsaBudSltChtrCrrCapaVOs[i];
		}
	}

	public BsaYearlyPlanConditionVO getBsaYearlyPlanConditionVO() {
		return bsaYearlyPlanConditionVO;
	}

}