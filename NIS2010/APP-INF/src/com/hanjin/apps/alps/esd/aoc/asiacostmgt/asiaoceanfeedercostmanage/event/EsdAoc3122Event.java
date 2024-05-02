/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3122Event.java
*@FileTitle : Ocean Feeder Cost Management(Asia)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.event;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederDgCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederMgtCondVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederReeferCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3122 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3122HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3122HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3122Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AsiaFeederCostTariffInfoVO asiaFeederCostTariffInfoVO = null;
	private AsiaFeederCostVO asiaFeederCostVO = null;
	private AsiaFeederCostSpecialCargoVO asiaFeederCostSpecialCargoVO = null;
	private AsiaFeederDgCostVO asiaFeederDgCostVO = null;
	private AsiaFeederReeferCostVO asiaFeederReeferCostVO = null;
	private AsiaFeederMgtCondVO asiaFeederMgtCondVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AsiaFeederCostTariffInfoVO[] asiaFeederCostTariffInfoVOs = null;
	private AsiaFeederCostVO[] asiaFeederCostVOs = null;
	private AsiaFeederCostSpecialCargoVO[] asiaFeederCostSpecialCargoVOs = null;
	private AsiaFeederDgCostVO[] asiaFeederDgCostVOs = null;
	private AsiaFeederReeferCostVO[] asiaFeederReeferCostVOs = null;
	private AsiaFeederMgtCondVO[] asiaFeederMgtCondVOs = null;
	
	public EsdAoc3122Event(){}

	public AsiaFeederCostTariffInfoVO getAsiaFeederCostTariffInfoVO() {
		return asiaFeederCostTariffInfoVO;
	}

	public void setAsiaFeederCostTariffInfoVO(
			AsiaFeederCostTariffInfoVO asiaFeederCostTariffInfoVO) {
		this.asiaFeederCostTariffInfoVO = asiaFeederCostTariffInfoVO;
	}

	public AsiaFeederCostVO getAsiaFeederCostVO() {
		return asiaFeederCostVO;
	}

	public void setAsiaFeederCostVO(AsiaFeederCostVO asiaFeederCostVO) {
		this.asiaFeederCostVO = asiaFeederCostVO;
	}

	public AsiaFeederCostSpecialCargoVO getAsiaFeederCostSpecialCargoVO() {
		return asiaFeederCostSpecialCargoVO;
	}

	public void setAsiaFeederCostSpecialCargoVO(
			AsiaFeederCostSpecialCargoVO asiaFeederCostSpecialCargoVO) {
		this.asiaFeederCostSpecialCargoVO = asiaFeederCostSpecialCargoVO;
	}

	public AsiaFeederDgCostVO getAsiaFeederDgCostVO() {
		return asiaFeederDgCostVO;
	}

	public void setAsiaFeederDgCostVO(AsiaFeederDgCostVO asiaFeederDgCostVO) {
		this.asiaFeederDgCostVO = asiaFeederDgCostVO;
	}

	public AsiaFeederReeferCostVO getAsiaFeederReeferCostVO() {
		return asiaFeederReeferCostVO;
	}

	public void setAsiaFeederReeferCostVO(
			AsiaFeederReeferCostVO asiaFeederReeferCostVO) {
		this.asiaFeederReeferCostVO = asiaFeederReeferCostVO;
	}

	public AsiaFeederMgtCondVO getAsiaFeederMgtCondVO() {
		return asiaFeederMgtCondVO;
	}

	public void setAsiaFeederMgtCondVO(AsiaFeederMgtCondVO asiaFeederMgtCondVO) {
		this.asiaFeederMgtCondVO = asiaFeederMgtCondVO;
	}

	public AsiaFeederCostTariffInfoVO[] getAsiaFeederCostTariffInfoVOs() {
		AsiaFeederCostTariffInfoVO[] rtnVOs = null;
		if (this.asiaFeederCostTariffInfoVOs != null) {
			rtnVOs = new AsiaFeederCostTariffInfoVO[asiaFeederCostTariffInfoVOs.length];
			System.arraycopy(asiaFeederCostTariffInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setAsiaFeederCostTariffInfoVOs(AsiaFeederCostTariffInfoVO[] asiaFeederCostTariffInfoVOs){
		if(asiaFeederCostTariffInfoVOs != null){
			AsiaFeederCostTariffInfoVO[] tmpVOs = new AsiaFeederCostTariffInfoVO[asiaFeederCostTariffInfoVOs.length];
			System.arraycopy(asiaFeederCostTariffInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaFeederCostTariffInfoVOs = tmpVOs;
		}
	}

	public AsiaFeederCostVO[] getAsiaFeederCostVOs() {
		AsiaFeederCostVO[] rtnVOs = null;
		if (this.asiaFeederCostVOs != null) {
			rtnVOs = new AsiaFeederCostVO[asiaFeederCostVOs.length];
			System.arraycopy(asiaFeederCostVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setAsiaFeederCostVOs(AsiaFeederCostVO[] asiaFeederCostVOs){
		if(asiaFeederCostVOs != null){
			AsiaFeederCostVO[] tmpVOs = new AsiaFeederCostVO[asiaFeederCostVOs.length];
			System.arraycopy(asiaFeederCostVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaFeederCostVOs = tmpVOs;
		}
	}

	public AsiaFeederCostSpecialCargoVO[] getAsiaFeederCostSpecialCargoVOs() {
		AsiaFeederCostSpecialCargoVO[] rtnVOs = null;
		if (this.asiaFeederCostSpecialCargoVOs != null) {
			rtnVOs = new AsiaFeederCostSpecialCargoVO[asiaFeederCostSpecialCargoVOs.length];
			System.arraycopy(asiaFeederCostSpecialCargoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setAsiaFeederCostSpecialCargoVOs(AsiaFeederCostSpecialCargoVO[] asiaFeederCostSpecialCargoVOs){
		if(asiaFeederCostSpecialCargoVOs != null){
			AsiaFeederCostSpecialCargoVO[] tmpVOs = new AsiaFeederCostSpecialCargoVO[asiaFeederCostSpecialCargoVOs.length];
			System.arraycopy(asiaFeederCostSpecialCargoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaFeederCostSpecialCargoVOs = tmpVOs;
		}
	}

	public AsiaFeederDgCostVO[] getAsiaFeederDgCostVOs() {
		AsiaFeederDgCostVO[] rtnVOs = null;
		if (this.asiaFeederDgCostVOs != null) {
			rtnVOs = new AsiaFeederDgCostVO[asiaFeederDgCostVOs.length];
			System.arraycopy(asiaFeederDgCostVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setAsiaFeederDgCostVOs(AsiaFeederDgCostVO[] asiaFeederDgCostVOs){
		if(asiaFeederDgCostVOs != null){
			AsiaFeederDgCostVO[] tmpVOs = new AsiaFeederDgCostVO[asiaFeederDgCostVOs.length];
			System.arraycopy(asiaFeederDgCostVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaFeederDgCostVOs = tmpVOs;
		}
	}

	public AsiaFeederReeferCostVO[] getAsiaFeederReeferCostVOs() {
		AsiaFeederReeferCostVO[] rtnVOs = null;
		if (this.asiaFeederReeferCostVOs != null) {
			rtnVOs = new AsiaFeederReeferCostVO[asiaFeederReeferCostVOs.length];
			System.arraycopy(asiaFeederReeferCostVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setAsiaFeederReeferCostVOs(AsiaFeederReeferCostVO[] asiaFeederReeferCostVOs){
		if(asiaFeederReeferCostVOs != null){
			AsiaFeederReeferCostVO[] tmpVOs = new AsiaFeederReeferCostVO[asiaFeederReeferCostVOs.length];
			System.arraycopy(asiaFeederReeferCostVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaFeederReeferCostVOs = tmpVOs;
		}
	}

	public AsiaFeederMgtCondVO[] getAsiaFeederMgtCondVOs() {
		AsiaFeederMgtCondVO[] rtnVOs = null;
		if (this.asiaFeederMgtCondVOs != null) {
			rtnVOs = new AsiaFeederMgtCondVO[asiaFeederMgtCondVOs.length];
			System.arraycopy(asiaFeederMgtCondVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setAsiaFeederMgtCondVOs(AsiaFeederMgtCondVO[] asiaFeederMgtCondVOs){
		if(asiaFeederMgtCondVOs != null){
			AsiaFeederMgtCondVO[] tmpVOs = new AsiaFeederMgtCondVO[asiaFeederMgtCondVOs.length];
			System.arraycopy(asiaFeederMgtCondVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaFeederMgtCondVOs = tmpVOs;
		}
	}
}
