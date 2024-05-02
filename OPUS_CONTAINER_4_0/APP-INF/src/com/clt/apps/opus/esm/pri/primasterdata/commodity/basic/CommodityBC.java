/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityBC.java
*@FileTitle : Commodity Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.commodity.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.CmdtParaVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltCmdtListVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltGrpCmdtListVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltRepCmdtListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - interface about Primasterdata biz logic<br>
 *
 * @author 
 * @see Esm_pri_4027EventResponse 
 * @since J2EE 1.4
 */

public interface CommodityBC {
	
	/**
	 * Retrieving Commodity List <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltCmdtListVO> searchCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Retrieving Rep Commodity List <br>
	 * 
	 * @param CmdtParaVO cmdtParmVo
	 * @return List<RsltRepCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltRepCmdtListVO> searchRepCommodityList(CmdtParaVO cmdtParmVo) throws EventException;
	
	/**
	 * Retrieving SG Group Commodity List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSgGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Retrieving SG Group Commodity Detail List <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSgGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Retrieving RG Group Commodity List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRgGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Retrieving RG Group Commodity Detail List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRgGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Retrieving SP SCOPE Group Commodity List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSpScpGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Retrieving SP SCOPE Group Commodity Detail List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSpScpGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Retrieving RP SCOPE Group Commodity List <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRpScpGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Retrieving RP SCOPE Group Commodity Detail List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRpScpGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Retrieving Surcharge Group Commodity List <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSurchargeGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException;
	
	/**
	 * Retrieving Surcharge Group Commodity Detail List  <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSurchargeGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException;

 
	
 
}