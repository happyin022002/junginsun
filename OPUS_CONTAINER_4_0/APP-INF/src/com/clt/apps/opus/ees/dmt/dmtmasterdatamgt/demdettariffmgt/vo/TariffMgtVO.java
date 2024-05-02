/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffMgtVO.java
*@FileTitle : Tariff Group을 생성하는 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 6. 26.
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009. 6. 26. 김태균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class TariffMgtVO {
	
	private TariffGroupVO tariffGroupVO = null;
	
	private DmtTariffTypeVO dmtTariffTypeVO = null;
	
	private List<TariffGroupVO> tariffGroupVOs = null;

	private List<TariffCombinationVO> tariffCombinationVOs = null;

	private List<TariffFreeTimeVO> tariffFreeTimeVOs = null;

	private List<TariffRateVO> tariffRateVOs = null;
	
	public TariffGroupVO getTariffGroupVO() {
		return tariffGroupVO;
	}

	public List<TariffGroupVO> getTariffGroupVOs() {
		return tariffGroupVOs;
	}

	public List<TariffCombinationVO> getTariffCombinationVOs() {
		return tariffCombinationVOs;
	}

	public List<TariffFreeTimeVO> getTariffFreeTimeVOs() {
		return tariffFreeTimeVOs;
	}

	public List<TariffRateVO> getTariffRateVOs() {
		return tariffRateVOs;
	}
	
	
	public DmtTariffTypeVO getDmtTariffTypeVO() {
		return dmtTariffTypeVO;
	}

	public void setTariffGroupVO(TariffGroupVO tariffGroupVO) {
		this.tariffGroupVO = tariffGroupVO;
	}

	public void setTariffRateVOs(List<TariffRateVO> tariffRateVOs) {
		this.tariffRateVOs = tariffRateVOs;
	}
	public void setTariffGroupVOs(List<TariffGroupVO> tariffGroupVOs) {
		this.tariffGroupVOs = tariffGroupVOs;
	}

	public void setTariffCombinationVOs(
			List<TariffCombinationVO> tariffCombinationVOs) {
		this.tariffCombinationVOs = tariffCombinationVOs;
	}

	public void setTariffFreeTimeVOs(List<TariffFreeTimeVO> tariffFreeTimeVOs) {
		this.tariffFreeTimeVOs = tariffFreeTimeVOs;
	}

	
	public void setDmtTariffTypeVO(DmtTariffTypeVO dmtTariffTypeVO) {
		this.dmtTariffTypeVO = dmtTariffTypeVO;
	}

	public void setTariffGroupVOs(TariffGroupVO[] tariffGroupVOList) {
		if(tariffGroupVOList != null && tariffGroupVOList.length > 0) {
			tariffGroupVOs = new ArrayList<TariffGroupVO>();
			for(int i = 0 ; i < tariffGroupVOList.length ; i++ ) {
				tariffGroupVOs.add(tariffGroupVOList[i]);
			}
		}
	}
	
	public void setTariffCombinationVOs(TariffCombinationVO[] tariffCombinationVOList) {
		if(tariffCombinationVOList != null && tariffCombinationVOList.length > 0) {
			tariffCombinationVOs = new ArrayList<TariffCombinationVO>();
			for(int i = 0 ; i < tariffCombinationVOList.length ; i++ ) {
				tariffCombinationVOs.add(tariffCombinationVOList[i]);
			}
		}
	}

	public void setTariffFreeTimeVOs(TariffFreeTimeVO[] tariffFreeTimeVOList) {
		if(tariffFreeTimeVOList != null && tariffFreeTimeVOList.length > 0) {
			tariffFreeTimeVOs = new ArrayList<TariffFreeTimeVO>();
			for(int i = 0 ; i < tariffFreeTimeVOList.length ; i++ ) {
				tariffFreeTimeVOs.add(tariffFreeTimeVOList[i]);
			}
		}
	}
	
	public void setTariffRateVOs(TariffRateVO[] tariffRateVOList) {
		if(tariffRateVOList != null && tariffRateVOList.length > 0) {
			tariffRateVOs = new ArrayList<TariffRateVO>();
			for(int i = 0 ; i < tariffRateVOList.length ; i++ ) {
				tariffRateVOs.add(tariffRateVOList[i]);
			}
		}
	}
}
