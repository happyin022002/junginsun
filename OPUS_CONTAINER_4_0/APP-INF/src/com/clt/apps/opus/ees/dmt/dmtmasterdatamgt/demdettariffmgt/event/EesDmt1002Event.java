/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt1002Event.java
*@FileTitle : Basic Tariff Creation - Group (PopUp)
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 6. 19.
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009. 6. 19. 김태균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.BasicTariffVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffCombinationVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffGroupVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRateVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES-DMT-1002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES-DMT-1002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES-DMT-1002HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesDmt1002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private BasicTariffVO basicTarriffVO = null;

	private BasicTariffVO[] basicTarriffVOs = null;
	
	private DmtTariffTypeVO dmtTariffTypeVO = null;
	
	private DmtTariffTypeVO[] dmtTariffTypeVOs = null;
	
	private TariffCombinationVO tariffCombinationVO = null;
	
	private TariffCombinationVO[] tariffCombinationVOs = null;
	
	private TariffFreeTimeVO tariffFreeTimeVO = null;
	
	private TariffFreeTimeVO[] tariffFreeTimeVOs = null;
	
	private TariffGroupVO tariffGroupVO = null;
	
	private TariffGroupVO[] tariffGroupVOs = null;
	
	private TariffRateVO tariffRateVO = null;
	
	private TariffRateVO[] tariffRateVOs = null;
	
	public EesDmt1002Event() {}

	public BasicTariffVO getBasicTarriffVO() {
		return basicTarriffVO;
	}

	public BasicTariffVO[] getBasicTarriffVOs() {
		BasicTariffVO[] tmpVOs = null;
		if (this.basicTarriffVOs != null) {
			tmpVOs = new BasicTariffVO[basicTarriffVOs.length];
			System.arraycopy(basicTarriffVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public DmtTariffTypeVO getDmtTariffTypeVO() {
		return dmtTariffTypeVO;
	}

	public DmtTariffTypeVO[] getDmtTariffTypeVOs() {
		DmtTariffTypeVO[] tmpVOs = null;
		if (this.dmtTariffTypeVOs != null) {
			tmpVOs = new DmtTariffTypeVO[dmtTariffTypeVOs.length];
			System.arraycopy(dmtTariffTypeVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public TariffCombinationVO getTariffCombinationVO() {
		return tariffCombinationVO;
	}

	public TariffCombinationVO[] getTariffCombinationVOs() {
		TariffCombinationVO[] tmpVOs = null;
		if (this.tariffCombinationVOs != null) {
			tmpVOs = new TariffCombinationVO[tariffCombinationVOs.length];
			System.arraycopy(tariffCombinationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public TariffFreeTimeVO getTariffFreeTimeVO() {
		return tariffFreeTimeVO;
	}

	public TariffFreeTimeVO[] getTariffFreeTimeVOs() {
		TariffFreeTimeVO[] tmpVOs = null;
		if (this.tariffFreeTimeVOs != null) {
			tmpVOs = new TariffFreeTimeVO[tariffFreeTimeVOs.length];
			System.arraycopy(tariffFreeTimeVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public TariffGroupVO getTariffGroupVO() {
		return tariffGroupVO;
	}

	public TariffGroupVO[] getTariffGroupVOs() {
		TariffGroupVO[] tmpVOs = null;
		if (this.tariffGroupVOs != null) {
			tmpVOs = new TariffGroupVO[tariffGroupVOs.length];
			System.arraycopy(tariffGroupVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public TariffRateVO getTariffRateVO() {
		return tariffRateVO;
	}

	public TariffRateVO[] getTariffRateVOs() {
		TariffRateVO[] tmpVOs = null;
		if (this.tariffRateVOs != null) {
			tmpVOs = new TariffRateVO[tariffRateVOs.length];
			System.arraycopy(tariffRateVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setBasicTarriffVO(BasicTariffVO basicTarriffVO) {
		this.basicTarriffVO = basicTarriffVO;
	}

	public void setBasicTarriffVOs(BasicTariffVO[] basicTarriffVOs) {
		if (basicTarriffVOs != null) {
			BasicTariffVO[] tmpVOs = new BasicTariffVO[basicTarriffVOs.length];
			System.arraycopy(basicTarriffVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.basicTarriffVOs = tmpVOs;
		}
	}

	public void setDmtTariffTypeVO(DmtTariffTypeVO dmtTariffTypeVO) {
		this.dmtTariffTypeVO = dmtTariffTypeVO;
	}

	public void setDmtTariffTypeVOs(DmtTariffTypeVO[] dmtTariffTypeVOs) {
		if (dmtTariffTypeVOs != null) {
			DmtTariffTypeVO[] tmpVOs = new DmtTariffTypeVO[dmtTariffTypeVOs.length];
			System.arraycopy(dmtTariffTypeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtTariffTypeVOs = tmpVOs;
		}
	}

	public void setTariffCombinationVO(TariffCombinationVO tariffCombinationVO) {
		this.tariffCombinationVO = tariffCombinationVO;
	}

	public void setTariffCombinationVOs(TariffCombinationVO[] tariffCombinationVOs) {
		if (tariffCombinationVOs != null) {
			TariffCombinationVO[] tmpVOs = new TariffCombinationVO[tariffCombinationVOs.length];
			System.arraycopy(tariffCombinationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tariffCombinationVOs = tmpVOs;
		}
	}

	public void setTariffFreeTimeVO(TariffFreeTimeVO tariffFreeTimeVO) {
		this.tariffFreeTimeVO = tariffFreeTimeVO;
	}

	public void setTariffFreeTimeVOs(TariffFreeTimeVO[] tariffFreeTimeVOs) {
		if (tariffFreeTimeVOs != null) {
			TariffFreeTimeVO[] tmpVOs = new TariffFreeTimeVO[tariffFreeTimeVOs.length];
			System.arraycopy(tariffFreeTimeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tariffFreeTimeVOs = tmpVOs;
		}
	}

	public void setTariffGroupVO(TariffGroupVO tariffGroupVO) {
		this.tariffGroupVO = tariffGroupVO;
	}

	public void setTariffGroupVOs(TariffGroupVO[] tariffGroupVOs) {
		if (tariffGroupVOs != null) {
			TariffGroupVO[] tmpVOs = new TariffGroupVO[tariffGroupVOs.length];
			System.arraycopy(tariffGroupVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tariffGroupVOs = tmpVOs;
		}
	}

	public void setTariffRateVO(TariffRateVO tariffRateVO) {
		this.tariffRateVO = tariffRateVO;
	}

	public void setTariffRateVOs(TariffRateVO[] tariffRateVOs) {
		if (tariffRateVOs != null) {
			TariffRateVO[] tmpVOs = new TariffRateVO[tariffRateVOs.length];
			System.arraycopy(tariffRateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tariffRateVOs = tmpVOs;
		}
	}
	
}
