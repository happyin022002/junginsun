/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtBC.java
*@FileTitle : Basic Tariff Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.BasicTariffVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionParamVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryListVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryParamVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentParamVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffGroupVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffMgtVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRateVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.ToDmtTariffTypeVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Dmtmasterdatamgt Business Logic Command Interface<br>
 * 
 * @author
 * @see reference Ui-dmt-1003EventResponse
 * @since J2EE 1.4
 */

public interface DemDetTariffMgtBC {
	/**
	 * search BasicTariffSummryList <br>
	 * 
	 * @param SearchBasicTariffSummaryParamVO searchBasicTariffSummaryParamVO
	 * @return List<SearchBasicTariffSummaryListVO>
	 * @exception EventException
	 */
	public List<SearchBasicTariffSummaryListVO> searchBasicTariffSummuryList(SearchBasicTariffSummaryParamVO searchBasicTariffSummaryParamVO) throws EventException;
	
	/**
	 *  search Basic Tariff Detail(s)<br>
	 * 
	 * @param SearchContinentParamVO searchContinentParamVO
	 * @return List<SearchContinentVO>
	 * @exception EventException
	 */
	public List<SearchContinentVO> searchBasicTariffDetailList(SearchContinentParamVO searchContinentParamVO) throws EventException;
	
    /**
     * [Basic Tariff Detail(s)] [search]<br>
     * 
     * @param SearchContinentParamVO searchContinentParamVO
     * @return List<SearchContinentVO>
     * @exception EventException
     */
    public List<SearchContinentVO> searchBasicTariffDetailList02(SearchContinentParamVO searchContinentParamVO) throws EventException;	
	
	/**
	 * [BasicTariff] [search]<br>
	 * 
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @exception EventException
	 */
	public List<BasicTariffVO> searchBasicTariff(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
    /**
     * [BasicTariff] [search]<br>
     * 
     * @param DmtTariffTypeVO dmtTariffTypeVO
     * @return List<BasicTariffVO>
     * @exception EventException
     */
    public List<SearchContinentVO> searchBasicTariffXSL(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	/**
	 * [BasicTariffFreeTime] [search]<br>
	 * 
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<TariffFreeTimeVO>
	 * @exception EventException
	 */
	public List<TariffFreeTimeVO> searchBasicTariffFreeTime(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	/**
	 * [BasicTariffRate] [search]<br>
	 * 
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<TariffRateVO>
	 * @exception EventException
	 */
	public List<TariffRateVO> searchBasicTariffRate(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	/**
	 * [BasicTariff] [confirm]<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void confirmBasicTariff(BasicTariffVO basicTariffVO) throws EventException;

	/**
	 * [BasicTariff] [confirmCancel]<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void confirmCancelBasicTariff(BasicTariffVO basicTariffVO) throws EventException;
	
	/**
	 * [BasicTariff] [confirmRgn]<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void confirmRgnBasicTariff(BasicTariffVO basicTariffVO) throws EventException;
	
	/**
	 * [BasicTariff] [confirmCancelRgn]<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void confirmCancelRgnBasicTariff(BasicTariffVO basicTariffVO) throws EventException;	
	
	/**
	 * [BasicTariff] [remove]<br>
	 * @param BasicTariffVO[] basicTariffVOs
	 * @throws EventException
	 */
	public void removeBasicTariff(BasicTariffVO[] basicTariffVOs) throws EventException;

//	/**
//	 * [TariffRegion] [remove]<br>
//	 * @param BasicTariffVO basicTariffVO
//	 * @throws EventException
//	 */
//	public void removeTariffRegion(BasicTariffVO basicTariffVO) throws EventException;
//	/**
//	 * [TariffGroup] [remove]<br>
//	 * @param BasicTariffVO basicTariffVO
//	 * @throws EventException
//	 */
//	public void removeTariffGroup(BasicTariffVO basicTariffVO) throws EventException;	
//	
//	/**
//	 * [TariffCombinations] [remove]<br>
//	 * @param BasicTariffVO basicTariffVO
//	 * @throws EventException
//	 */
//	public void removeTariffCombinations(BasicTariffVO basicTariffVO) throws EventException;	
//
//	/**
//	 * [TariffFreeTimes] [remove]<br>
//	 * @param BasicTariffVO basicTariffVO
//	 * @throws EventException
//	 */
//	public void removeTariffFreeTimes(BasicTariffVO basicTariffVO) throws EventException;	
//	
//	/**
//	 * [TariffRates] [remove]<br>
//	 * @param BasicTariffVO basicTariffVO
//	 * @throws EventException
//	 */
//	public void removeTariffRates(BasicTariffVO basicTariffVO) throws EventException;	
	
	
	/**
	 * [TrfRgnCfmHis] [add]<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void addTrfRgnCfmHis(BasicTariffVO basicTariffVO) throws EventException;	
	
	/**
	 * [TrfGrpCfmHis] [add]<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void addTrfGrpCfmHis(BasicTariffVO basicTariffVO) throws EventException;	
	
	/**
	 * [ MAX RGN_CFM_SEQ of DMT_TRF_RGN_CFM_HIS ] [search]<br>
	 * @param BasicTariffVO basicTariffVO
	 * @return int
	 * @throws EventException
	 */
	public int searchTrfRgnCfmSeq(BasicTariffVO basicTariffVO) throws EventException;
	
	/**
	 * search WeekEnd by Cnt_cd <br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws EventException
	 */
	public List<BasicTariffVO> searchWeekEnd(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	/**
	 * [CombinationSet] [search]<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws EventException
	 */
	public List<BasicTariffVO> searchCombinationSet(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	/**
	 * [Tariff Combination] [search]<br>
	 * @param BasicTariffVO basicTariffVO
	 * @return List<BasicTariffVO>
	 * @throws EventException
	 */
	public List<BasicTariffVO> searchTariffCombination(BasicTariffVO basicTariffVO) throws EventException;
	
	/**
	 * [Update CombinationSet] [search]<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws EventException
	 */
	public List<BasicTariffVO> searchUpdateCombinationSet(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	/**
	 * [DmtTrfGrp] [search]<br>
	 * @param BasicTariffVO basicTariffVO
	 * @return List<TariffGroupVO>
	 * @throws EventException
	 */
	public List<TariffGroupVO> searchDmtTrfGrp(BasicTariffVO basicTariffVO) throws EventException;
	
	/**
	 * [BasicTariff] [Create]<br>
	 * @param TariffMgtVO tariffMgtVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createBasicTariff(TariffMgtVO tariffMgtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [BasicTariff] [modify]<br>
	 * @param TariffMgtVO tariffMgtVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String modifyBasicTariff(TariffMgtVO tariffMgtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [BasicTariff] [Expire]<br>
	 * @param TariffMgtVO tariffMgtVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBasicTariffExpire(TariffMgtVO tariffMgtVO, SignOnUserAccount account) throws EventException;
	

	/**
	 * [BasicTariff] [copy]<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @param ToDmtTariffTypeVO toDmtTariffTypeVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String copyBasicTariff(DmtTariffTypeVO dmtTariffTypeVO, ToDmtTariffTypeVO toDmtTariffTypeVO, SignOnUserAccount account) throws EventException;
	

	/**
	 * [CommodityTariffList] [search]<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<CommodityTariffVO>
	 * @throws EventException
	 */
	public List<CommodityTariffVO> searchCommodityTariffList(DmtTariffTypeVO dmtTariffTypeVO) throws EventException;
	
	
	/**
	 * [CommodityTariff] [Create]<br>
	 * @param CommodityTariffVO[] CommodityTariffVOs
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyCommodityTariff(CommodityTariffVO[] CommodityTariffVOs, DmtTariffTypeVO dmtTariffTypeVO, SignOnUserAccount account) throws EventException;


	/**
	 * [CommodityTariffRegionList] [search]<br>
	 * @param CommodityTariffRegionParamVO commodityTariffRegionParamVO
	 * @return List<CommodityTariffRegionVO>
	 * @throws EventException
	 */
	public List<CommodityTariffRegionVO> searchCommodityTariffRegionList(CommodityTariffRegionParamVO commodityTariffRegionParamVO) throws EventException;

}
