/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : CommodityBCImpl.java
* @FileTitle : Commodity정보조회(공통 Popup)
* Open Issues :
* Change history :
* @LastModifyDate : 2006-08-03
* @LastModifier : sungseok, choi
* @LastVersion : 1.0
* 2006-08-03 sungseok, choi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.commodity.basic;

import java.util.List;

import com.hanjin.bizcommon.commodity.integration.CommodityDBDAO;
import com.hanjin.bizcommon.commodity.vo.SearchCommodityListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ENIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * ENIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @date		2006.08.03
 * @author 		sungseok, choi
 * @see 		COM_ENS_011EventResponse,CommodityBC 각 DAO 클래스 참조
 * @since 		J2EE 1.4
 */
public class CommodityBCImpl   extends BasicCommandSupport implements CommodityBC {
    /**
     * Add Title	: Database Access Object 
     * Add Date		: 2006.08.03
     * Add Author	: sungseok, choi
     * @return		
     */
    private transient CommodityDBDAO dbDao=null;

    /**
     * Add Title	: CommodityBCImpl Object Creation
     * 				: CommodityDBDAO Creation 
     * Add Date		: 2006.08.03
     * Add Author	: sungseok, choi
     * @return		
     */
    public CommodityBCImpl(){
        dbDao = new CommodityDBDAO();
    }

    /**
     * 조회 이벤트 처리<br>
     * Vessel화면에 대한 조회 이벤트 처리<br>
     * searchCommodityList
     * @param String cmdtCd
     * @param String repCmdtCd
     * @param String repImdgLvlCd
     * @param String cmdtNm
     * @param int iPage
     * @return List<SearchCommodityListVO>
     * @throws EventException
     */
    public List<SearchCommodityListVO> searchCommodityList(String cmdtCd, String repCmdtCd, String repImdgLvlCd, String cmdtNm, int iPage) throws EventException {
        /**
         * Add Title	: Database ResultSet Object Creation of Data Transport 
         * Add Date		: 2006.08.03
         * Add Author	: sungseok, choi
         * @return		: 
         */
        
        try {
			return dbDao.searchCommodityList(cmdtCd, repCmdtCd, repImdgLvlCd, cmdtNm, iPage);
        } catch (DAOException de) {
            log.error("err " + de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err " + e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
    }

    /**
     * Add Title	: BIZCOMMON 업무 시나리오 마감작업
     * 				: Commodity 업무 시나리오 종료 시 관련 내부 객체 해제 
     * Add Date		: 2006.08.03
     * Add Author	: sungseok, choi
     */
    public void doEnd() {
        dbDao = null;
    }
    
}