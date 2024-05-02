/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityBC.java
*@FileTitle : Commodity Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.04.28 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.commodity.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.vo.CmdtParaVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.vo.RsltCmdtListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.vo.RsltGrpCmdtListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.vo.RsltRepCmdtListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * NIS2010-Primasterdata Business Logic Command Interface<br>
 * - NIS2010-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4027EventResponse 참조
 * @since J2EE 1.4
 */

public interface CommodityBC {
	
	/**
	 * Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltCmdtListVO> searchCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Rep Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParmVo
	 * @return List<RsltRepCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltRepCmdtListVO> searchRepCommodityList(CmdtParaVO cmdtParmVo) throws EventException;
	
	/**
	 * SG Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSgGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * SG Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSgGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * RG Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRgGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * RG Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRgGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * SP SCOPE Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSpScpGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * SP SCOPE Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSpScpGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * RP SCOPE Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRpScpGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * RP SCOPE Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRpScpGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Surcharge Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSurchargeGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Surcharge Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSurchargeGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Cmpb Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchCmpbGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Cmpb Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchCmpbGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * SQ Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSqGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * SQ Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSqGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * RQ Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRqGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * RQ Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRqGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;
}