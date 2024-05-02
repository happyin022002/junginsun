/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3022Event.java
*@FileTitle : Ocean Feeder Cost Management(EUR)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Ocean Feeder Cost Management 수정 및 신규 탭 추가
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.event;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederDgCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederMgtCondVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederReeferCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3022HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3022Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EurFeederCostTariffInfoVO eurFeederCostTariffInfoVO = null;
	private EurFeederCostVO eurFeederCostVO = null;
	private EurFeederCostSpecialCargoVO eurFeederCostSpecialCargoVO = null;
	private EurFeederDgCostVO eurFeederDgCostVO = null;
	private EurFeederReeferCostVO eurFeederReeferCostVO = null;
	private EurFeederMgtCondVO eurFeederMgtCondVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EurFeederCostTariffInfoVO[] eurFeederCostTariffInfoVOs = null;
	private EurFeederCostVO[] eurFeederCostVOs = null;
	private EurFeederCostSpecialCargoVO[] eurFeederCostSpecialCargoVOs = null;
	private EurFeederDgCostVO[] eurFeederDgCostVOs = null;
	private EurFeederReeferCostVO[] eurFeederReeferCostVOs = null;
	private EurFeederMgtCondVO eurFeederMgtCondVOs = null;
	
	public EsdAoc3022Event(){}

	public EurFeederCostTariffInfoVO getEurFeederCostTariffInfoVO() {
		return eurFeederCostTariffInfoVO;
	}

	public void setEurFeederCostTariffInfoVO(
			EurFeederCostTariffInfoVO eurFeederCostTariffInfoVO) {
		this.eurFeederCostTariffInfoVO = eurFeederCostTariffInfoVO;
	}

	public EurFeederCostVO getEurFeederCostVO() {
		return eurFeederCostVO;
	}

	public void setEurFeederCostVO(EurFeederCostVO eurFeederCostVO) {
		this.eurFeederCostVO = eurFeederCostVO;
	}

	public EurFeederCostSpecialCargoVO getEurFeederCostSpecialCargoVO() {
		return eurFeederCostSpecialCargoVO;
	}

	public void setEurFeederCostSpecialCargoVO(
			EurFeederCostSpecialCargoVO eurFeederCostSpecialCargoVO) {
		this.eurFeederCostSpecialCargoVO = eurFeederCostSpecialCargoVO;
	}

	public EurFeederDgCostVO getEurFeederDgCostVO() {
		return eurFeederDgCostVO;
	}

	public void setEurFeederDgCostVO(EurFeederDgCostVO eurFeederDgCostVO) {
		this.eurFeederDgCostVO = eurFeederDgCostVO;
	}

	public EurFeederReeferCostVO getEurFeederReeferCostVO() {
		return eurFeederReeferCostVO;
	}

	public void setEurFeederReeferCostVO(EurFeederReeferCostVO eurFeederReeferCostVO) {
		this.eurFeederReeferCostVO = eurFeederReeferCostVO;
	}

	public EurFeederMgtCondVO getEurFeederMgtCondVO() {
		return eurFeederMgtCondVO;
	}

	public void setEurFeederMgtCondVO(EurFeederMgtCondVO eurFeederMgtCondVO) {
		this.eurFeederMgtCondVO = eurFeederMgtCondVO;
	}

	public EurFeederCostTariffInfoVO[] getEurFeederCostTariffInfoVOs() {
		EurFeederCostTariffInfoVO[] rtnVOs = null;
		if (this.eurFeederCostTariffInfoVOs != null) {
			rtnVOs = new EurFeederCostTariffInfoVO[eurFeederCostTariffInfoVOs.length];
			System.arraycopy(eurFeederCostTariffInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEurFeederCostTariffInfoVOs(EurFeederCostTariffInfoVO[] eurFeederCostTariffInfoVOs){
		if(eurFeederCostTariffInfoVOs != null){
			EurFeederCostTariffInfoVO[] tmpVOs = new EurFeederCostTariffInfoVO[eurFeederCostTariffInfoVOs.length];
			System.arraycopy(eurFeederCostTariffInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurFeederCostTariffInfoVOs = tmpVOs;
		}
	}

	public EurFeederCostVO[] getEurFeederCostVOs() {
		EurFeederCostVO[] rtnVOs = null;
		if (this.eurFeederCostVOs != null) {
			rtnVOs = new EurFeederCostVO[eurFeederCostVOs.length];
			System.arraycopy(eurFeederCostVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEurFeederCostVOs(EurFeederCostVO[] eurFeederCostVOs){
		if(eurFeederCostVOs != null){
			EurFeederCostVO[] tmpVOs = new EurFeederCostVO[eurFeederCostVOs.length];
			System.arraycopy(eurFeederCostVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurFeederCostVOs = tmpVOs;
		}
	}

	public EurFeederCostSpecialCargoVO[] getEurFeederCostSpecialCargoVOs() {
		EurFeederCostSpecialCargoVO[] rtnVOs = null;
		if (this.eurFeederCostSpecialCargoVOs != null) {
			rtnVOs = new EurFeederCostSpecialCargoVO[eurFeederCostSpecialCargoVOs.length];
			System.arraycopy(eurFeederCostSpecialCargoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEurFeederCostSpecialCargoVOs(EurFeederCostSpecialCargoVO[] eurFeederCostSpecialCargoVOs){
		if(eurFeederCostSpecialCargoVOs != null){
			EurFeederCostSpecialCargoVO[] tmpVOs = new EurFeederCostSpecialCargoVO[eurFeederCostSpecialCargoVOs.length];
			System.arraycopy(eurFeederCostSpecialCargoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurFeederCostSpecialCargoVOs = tmpVOs;
		}
	}

	public EurFeederDgCostVO[] getEurFeederDgCostVOs() {
		EurFeederDgCostVO[] rtnVOs = null;
		if (this.eurFeederDgCostVOs != null) {
			rtnVOs = new EurFeederDgCostVO[eurFeederDgCostVOs.length];
			System.arraycopy(eurFeederDgCostVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEurFeederDgCostVOs(EurFeederDgCostVO[] eurFeederDgCostVOs){
		if(eurFeederDgCostVOs != null){
			EurFeederDgCostVO[] tmpVOs = new EurFeederDgCostVO[eurFeederDgCostVOs.length];
			System.arraycopy(eurFeederDgCostVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurFeederDgCostVOs = tmpVOs;
		}
	}

	public EurFeederReeferCostVO[] getEurFeederReeferCostVOs() {
		EurFeederReeferCostVO[] rtnVOs = null;
		if (this.eurFeederReeferCostVOs != null) {
			rtnVOs = new EurFeederReeferCostVO[eurFeederReeferCostVOs.length];
			System.arraycopy(eurFeederReeferCostVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEurFeederReeferCostVOs(EurFeederReeferCostVO[] eurFeederReeferCostVOs){
		if(eurFeederReeferCostVOs != null){
			EurFeederReeferCostVO[] tmpVOs = new EurFeederReeferCostVO[eurFeederReeferCostVOs.length];
			System.arraycopy(eurFeederReeferCostVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurFeederReeferCostVOs = tmpVOs;
		}
	}

	public EurFeederMgtCondVO getEurFeederMgtCondVOs() {
		return eurFeederMgtCondVOs;
	}

	public void setEurFeederMgtCondVOs(EurFeederMgtCondVO eurFeederMgtCondVOs) {
		this.eurFeederMgtCondVOs = eurFeederMgtCondVOs;
	}

	
}
