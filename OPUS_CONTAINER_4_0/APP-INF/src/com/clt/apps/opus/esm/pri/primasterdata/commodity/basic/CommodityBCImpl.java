/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityBCImpl.java
*@FileTitle : Commodity Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.commodity.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.commodity.integration.CommodityDBDAO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.CmdtParaVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltCmdtListVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltGrpCmdtListVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltRepCmdtListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * PRIMasterData Business Logic Basic Command implementation<br>
 * - handling biz logic about PRIMasterData<br>
 *
 * @author 
 * @see ESM_PRI_4027EventResponse,CommodityBC reference each DAO class
 * @since J2EE 1.4
 */

public class CommodityBCImpl extends BasicCommandSupport implements CommodityBC {

	// Database Access Object
	private transient CommodityDBDAO dbDao = null;

	/**
	 * CommodityBCImpl object creation<br>
	 * creating CommodityDBDAO<br>
	 */
	public CommodityBCImpl() {
		dbDao = new CommodityDBDAO();
	}
	
	/**
	 * Retrieving Commodity List <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltCmdtListVO> searchCommodityList(CmdtParaVO cmdtParaVo) throws EventException {
		try {
			return dbDao.searchCommodityList(cmdtParaVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Rep Commodity List <br>
	 * 
	 * @param CmdtParaVO cmdtParmVo
	 * @return List<RsltRepCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltRepCmdtListVO> searchRepCommodityList(CmdtParaVO cmdtParmVo) throws EventException {
		try {
			return dbDao.searchRepCommodityList(cmdtParmVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving SG Group Commodity List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSgGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchSgGroupCommodityList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving SG Group Commodity Detail List <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSgGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchSgGroupCommodityDetailList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving RG Group Commodity List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRgGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchRgGroupCommodityList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving RG Group Commodity Detail List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRgGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchRgGroupCommodityDetailList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving SP SCOPE Group Commodity List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSpScpGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchSpScpGroupCommodityList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving SP SCOPE Group Commodity Detail List <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSpScpGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchSpScpGroupCommodityDetailList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving RP SCOPE Group Commodity List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRpScpGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchRpScpGroupCommodityList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving RP SCOPE Group Commodity Detail List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRpScpGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchRpScpGroupCommodityDetailList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Surcharge Group Commodity List<br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSurchargeGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchSurchargeGroupCommodityList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Surcharge Group Commodity Detail List <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSurchargeGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchSurchargeGroupCommodityDetailList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
 
 
 
 
}