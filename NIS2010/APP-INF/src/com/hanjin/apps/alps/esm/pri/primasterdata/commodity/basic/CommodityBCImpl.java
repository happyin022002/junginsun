/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityBCImpl.java
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

import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.integration.CommodityDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.vo.CmdtParaVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.vo.RsltCmdtListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.vo.RsltGrpCmdtListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.vo.RsltRepCmdtListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-PRIMasterData Business Logic Basic Command implementation<br>
 * - NIS2010-PRIMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4027EventResponse,CommodityBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class CommodityBCImpl extends BasicCommandSupport implements CommodityBC {

	// Database Access Object
	private transient CommodityDBDAO dbDao = null;

	/**
	 * CommodityBCImpl 객체 생성<br>
	 * CommodityDBDAO를 생성한다.<br>
	 */
	public CommodityBCImpl() {
		dbDao = new CommodityDBDAO();
	}
	
	/**
	 * Commodity List를 조회한다. <br>
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
	 * Rep Commodity List를 조회한다. <br>
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
	 * SG Group Commodity List를 조회한다. <br>
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
	 * SG Group Commodity Detail List를 조회한다. <br>
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
	 * RG Group Commodity List를 조회한다. <br>
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
	 * RG Group Commodity Detail List를 조회한다. <br>
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
	 * SP SCOPE Group Commodity List를 조회한다. <br>
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
	 * SP SCOPE Group Commodity Detail List를 조회한다. <br>
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
	 * RP SCOPE Group Commodity List를 조회한다. <br>
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
	 * RP SCOPE Group Commodity Detail List를 조회한다. <br>
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
	 * Surcharge Group Commodity List를 조회한다. <br>
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
	 * Surcharge Group Commodity Detail List를 조회한다. <br>
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
	
	/**
	 * Cmpb Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchCmpbGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchCmpbGroupCommodityList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Cmpb Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchCmpbGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchCmpbGroupCommodityDetailList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SQ Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSqGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchSqGroupCommodityList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SQ Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchSqGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchSqGroupCommodityDetailList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * RQ Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRqGroupCommodityList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchRqGroupCommodityList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * RQ Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchRqGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws EventException {
		try {
			return dbDao.searchRqGroupCommodityDetailList(cmdtParaVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}