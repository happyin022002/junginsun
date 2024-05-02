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

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.BasicTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffCombinationVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffGroupVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRateVO;
import com.hanjin.framework.support.layer.event.EventSupport;

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
		return basicTarriffVOs;
	}

	public DmtTariffTypeVO getDmtTariffTypeVO() {
		return dmtTariffTypeVO;
	}

	public DmtTariffTypeVO[] getDmtTariffTypeVOs() {
		return dmtTariffTypeVOs;
	}

	public TariffCombinationVO getTariffCombinationVO() {
		return tariffCombinationVO;
	}

	public TariffCombinationVO[] getTariffCombinationVOs() {
		return tariffCombinationVOs;
	}

	public TariffFreeTimeVO getTariffFreeTimeVO() {
		return tariffFreeTimeVO;
	}

	public TariffFreeTimeVO[] getTariffFreeTimeVOs() {
		return tariffFreeTimeVOs;
	}

	public TariffGroupVO getTariffGroupVO() {
		return tariffGroupVO;
	}

	public TariffGroupVO[] getTariffGroupVOs() {
		return tariffGroupVOs;
	}

	public TariffRateVO getTariffRateVO() {
		return tariffRateVO;
	}

	public TariffRateVO[] getTariffRateVOs() {
		return tariffRateVOs;
	}

	public void setBasicTarriffVO(BasicTariffVO basicTarriffVO) {
		this.basicTarriffVO = basicTarriffVO;
	}

	public void setBasicTarriffVOs(BasicTariffVO[] basicTarriffVOs) {
		this.basicTarriffVOs = basicTarriffVOs;
	}

	public void setDmtTariffTypeVO(DmtTariffTypeVO dmtTariffTypeVO) {
		this.dmtTariffTypeVO = dmtTariffTypeVO;
	}

	public void setDmtTariffTypeVOs(DmtTariffTypeVO[] dmtTariffTypeVOs) {
		this.dmtTariffTypeVOs = dmtTariffTypeVOs;
	}

	public void setTariffCombinationVO(TariffCombinationVO tariffCombinationVO) {
		this.tariffCombinationVO = tariffCombinationVO;
	}

	public void setTariffCombinationVOs(TariffCombinationVO[] tariffCombinationVOs) {
		this.tariffCombinationVOs = tariffCombinationVOs;
	}

	public void setTariffFreeTimeVO(TariffFreeTimeVO tariffFreeTimeVO) {
		this.tariffFreeTimeVO = tariffFreeTimeVO;
	}

	public void setTariffFreeTimeVOs(TariffFreeTimeVO[] tariffFreeTimeVOs) {
		this.tariffFreeTimeVOs = tariffFreeTimeVOs;
	}

	public void setTariffGroupVO(TariffGroupVO tariffGroupVO) {
		this.tariffGroupVO = tariffGroupVO;
	}

	public void setTariffGroupVOs(TariffGroupVO[] tariffGroupVOs) {
		this.tariffGroupVOs = tariffGroupVOs;
	}

	public void setTariffRateVO(TariffRateVO tariffRateVO) {
		this.tariffRateVO = tariffRateVO;
	}

	public void setTariffRateVOs(TariffRateVO[] tariffRateVOs) {
		this.tariffRateVOs = tariffRateVOs;
	}
	
}
