/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffConditionManageBC.java
*@FileTitle : TariffConditionManageBC
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.06
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.03.06 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.TariffConditionManageSC;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.vo.ComTesTrfCondVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.syscommon.common.table.TesObjListVO;
import com.hanjin.syscommon.common.table.TesTrfCondVO;



/**
 * ALPS-TariffConditionManage Business Logic Command Interface<br>
 * - ALPS-TariffConditionManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 이혜민
 * @see TariffConditionManageSC  참조
 * @since J2EE 1.6
 */
public interface TariffConditionManageBC {

	/* TARIFF CONDITION USE TYPE */
	static final String TRF_COND_USE_TP_DISPLAY  	= "D";
	static final String TRF_COND_USE_TP_SYSTEM  	= "S";
	static final String TRF_COND_USE_TP_TEMP  		= "T";

	/* TARIFF CONDITION CREATION TYPE */
	static final String TRF_COND_CREATE_TP_SCREENINPUT	= "S";
	static final String TRF_COND_CREATE_TP_MANUAL	  	= "M";
	static final String TRF_COND_CREATE_TP_FILEUPLOAD	= "F";

	/* TARIFF CONDITION STATUS TYPE */
	static final String TRF_COND_STS_INITIAL	= "N";
	static final String TRF_COND_STS_CONFIRM  	= "C";
	static final String TRF_COND_STS_INVALID	= "X";
	static final String TRF_COND_STS_ERROR		= "E";
	
	/**
	 * Tariff Condition List를 조회한다.<br>
	 * @param ComTesTrfCondVO comTesTrfCondVO
	 * @return List<ComTesTrfCondVO>
	 * @exception EventException
	 */
	public List<ComTesTrfCondVO> searchTariffCond(ComTesTrfCondVO comTesTrfCondVO) throws EventException;
	
	/**
	 * Tariff Condition 항목 data를 조회한다.<br>
	 * @param tesTrfCondVO
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchTariffCondItem(TesTrfCondVO tesTrfCondVO) throws EventException;
	
	/**
	 * Tariff Object 항목을 조회한다.<br>
	 * @param tesObjListVO
	 * @return List<TesObjListVO>
	 * @throws EventException
	 */
	public List<TesObjListVO> searchTariffObjectList(TesObjListVO tesObjListVO) throws EventException;
	
	/**
	 * Tariff Object 항목을 조회한다.<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchTariffCondItem2(Event e) throws EventException;
	
	/**
	 * Tariff Condition 항목의 data을 관리한다.<br>
	 * @param e
	 * @throws EventException
	 */
	public void manageTariffCondDtlInfo(Event e) throws EventException;
	
	/**
	 * condition 참조 여부 확인
	 * @param e
	 * @return String
	 * @throws EventException
	 */
	public String checkTariffCondRef(Event e) throws EventException;
	
	/**
	 * condition 삭제
	 * @param e
	 * @throws EventException
	 */
	public void removeTariffCondInfo(Event e) throws EventException;
	
}