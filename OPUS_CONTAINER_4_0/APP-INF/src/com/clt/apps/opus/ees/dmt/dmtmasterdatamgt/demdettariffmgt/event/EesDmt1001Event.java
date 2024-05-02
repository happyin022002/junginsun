/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt1001Event.java
*@FileTitle : Basic Tariff Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.04 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.BasicTariffVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRateVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES-DMT-1001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES-DMT-1001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES-DMT-1001HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesDmt1001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private BasicTariffVO basicTarriffVO = null;

	private BasicTariffVO[] basicTarriffVOs = null;
	
	private TariffFreeTimeVO tariffFrreeTimeVO = null;
	
	private TariffFreeTimeVO[] tariffFrreeTimeVOs = null;
	
	private TariffRateVO tariffRateVO = null;
	
	private TariffRateVO[] tariffRateVOs = null;
	
	private DmtTariffTypeVO dmtTariffTypeVO = null;
	
	private DmtTariffTypeVO[] dmtTariffTypeVOs = null;
	

	public EesDmt1001Event() {}

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

	public TariffFreeTimeVO getTariffFrreeTimeVO() {
		return tariffFrreeTimeVO;
	}

	public TariffFreeTimeVO[] getTariffFrreeTimeVOs() {
		TariffFreeTimeVO[] tmpVOs = null;
		if (this.tariffFrreeTimeVOs != null) {
			tmpVOs = new TariffFreeTimeVO[tariffFrreeTimeVOs.length];
			System.arraycopy(tariffFrreeTimeVOs, 0, tmpVOs, 0, tmpVOs.length);
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

	public void setTariffFrreeTimeVO(TariffFreeTimeVO tariffFrreeTimeVO) {
		this.tariffFrreeTimeVO = tariffFrreeTimeVO;
	}

	public void setTariffFrreeTimeVOs(TariffFreeTimeVO[] tariffFrreeTimeVOs) {
		if (tariffFrreeTimeVOs != null) {
			TariffFreeTimeVO[] tmpVOs = new TariffFreeTimeVO[tariffFrreeTimeVOs.length];
			System.arraycopy(tariffFrreeTimeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tariffFrreeTimeVOs = tmpVOs;
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



}
