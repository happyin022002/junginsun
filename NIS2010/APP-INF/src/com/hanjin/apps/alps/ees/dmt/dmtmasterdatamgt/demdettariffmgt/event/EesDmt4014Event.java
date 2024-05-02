/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4014Event.java
*@FileTitle : Basic Tariff Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.04 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.BasicTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRateVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES-DMT-4014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES-DMT-4014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES-DMT-4014HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesDmt4014Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private BasicTariffVO basicTarriffVO = null;

	private BasicTariffVO[] basicTarriffVOs = null;
	
	private TariffFreeTimeVO tariffFrreeTimeVO = null;
	
	private TariffFreeTimeVO[] tariffFrreeTimeVOs = null;
	
	private TariffRateVO tariffRateVO = null;
	
	private TariffRateVO[] tariffRateVOs = null;
	
	private DmtTariffTypeVO dmtTariffTypeVO = null;
	
	private DmtTariffTypeVO[] dmtTariffTypeVOs = null;
	

	public EesDmt4014Event() {}

	public BasicTariffVO getBasicTarriffVO() {
		return basicTarriffVO;
	}

	public BasicTariffVO[] getBasicTarriffVOs() {
		return basicTarriffVOs;
	}

	public TariffFreeTimeVO getTariffFrreeTimeVO() {
		return tariffFrreeTimeVO;
	}

	public TariffFreeTimeVO[] getTariffFrreeTimeVOs() {
		return tariffFrreeTimeVOs;
	}

	public TariffRateVO getTariffRateVO() {
		return tariffRateVO;
	}

	public TariffRateVO[] getTariffRateVOs() {
		return tariffRateVOs;
	}
	

	public DmtTariffTypeVO getDmtTariffTypeVO() {
		return dmtTariffTypeVO;
	}

	public DmtTariffTypeVO[] getDmtTariffTypeVOs() {
		return dmtTariffTypeVOs;
	}

	public void setBasicTarriffVO(BasicTariffVO basicTarriffVO) {
		this.basicTarriffVO = basicTarriffVO;
	}

	public void setBasicTarriffVOs(BasicTariffVO[] basicTarriffVOs) {
		this.basicTarriffVOs = basicTarriffVOs;
	}

	public void setTariffFrreeTimeVO(TariffFreeTimeVO tariffFrreeTimeVO) {
		this.tariffFrreeTimeVO = tariffFrreeTimeVO;
	}

	public void setTariffFrreeTimeVOs(TariffFreeTimeVO[] tariffFrreeTimeVOs) {
		this.tariffFrreeTimeVOs = tariffFrreeTimeVOs;
	}

	public void setTariffRateVO(TariffRateVO tariffRateVO) {
		this.tariffRateVO = tariffRateVO;
	}

	public void setTariffRateVOs(TariffRateVO[] tariffRateVOs) {
		this.tariffRateVOs = tariffRateVOs;
	}

	public void setDmtTariffTypeVO(DmtTariffTypeVO dmtTariffTypeVO) {
		this.dmtTariffTypeVO = dmtTariffTypeVO;
	}

	public void setDmtTariffTypeVOs(DmtTariffTypeVO[] dmtTariffTypeVOs) {
		this.dmtTariffTypeVOs = dmtTariffTypeVOs;
	}



}
