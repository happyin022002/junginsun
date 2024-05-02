/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReplanManageBC.java
*@FileTitle : Replan 을 수행하는 공통 class 를 구동한다.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.09.01 김인수
* 1.0 Creation
* 2010.10.29 김진승 [소스품질 보완] arrangeMstCopNo 주석 보완
* 2010.11.07 김영철 [] R4J 주석보완 ( replanCopInclPrt )
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.vo.ReplanResultVO;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PrdBkgCopMapVO;
import com.clt.syscommon.common.table.SceCopHdrVO;
import com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO;
import com.clt.syscommon.common.table.TrsTrspRailBilOrdVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * Replanmanage Business Logic Command Interface<br>
 * - Replanmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim In-soo
 * @see ReplanResultVO , SingleTransportationVO 
 * @since J2EE 1.6
 */
public interface ReplanManageBC {

	/**
	 * <pre condition>
	 * split 이나 combine 등 cop 의 booking no 가 변동되는 case 가 완료 된 후 수행해야 한다.
	 * 
	 * <logic>
	 * container no  별로 partial 이 존재하는 지를 cop 에서 확인하고 
	 * partial 로 엮인 COP 간에 Master cop no 관계를 확인해 
	 * master cop no 가 1건 이상 존재하거나 partial 로 엮인 cop no 가 아닌 제 3의
	 * cop 가 match 되어 있을 경우 이를 정제하는 작업을 한다.
	 * 
	 * 1. master cop no 가 1건 이상 존재할 경우
	 * 해당 container 로 발행된 s/o 를 split booking, combine booking, original booking no
	 * 로 valid 한 S/O 를 모두 조회하여 발생건수가 가장 많은 Bkg no 를 취하여 해당 booking no 로
	 * 생성된 cop 를 찾고 
	 * 
	 * 2. master cop no 가 관련이 없는 것이 들어가 있을 경우
	 * master cop no 를 새로 선정하고 partial 로 엮인 booking 으로 생성된 so 를 모두 찾아 booking no 를 
	 * update 하고 mst_cop_no 역시 변경하여 준다.
	 * 
	 * @param cop_no TODO
	 */
	/**
	 * <pre condition>
	 * split 이나 combine 등 cop 의 booking no 가 변동되는 case 가 완료 된 후 수행해야 한다.
	 * 
	 * <logic>
	 * container no  별로 partial 이 존재하는 지를 cop 에서 확인하고 
	 * partial 로 엮인 COP 간에 Master cop no 관계를 확인해 
	 * master cop no 가 1건 이상 존재하거나 partial 로 엮인 cop no 가 아닌 제 3의
	 * cop 가 match 되어 있을 경우 이를 정제하는 작업을 한다.
	 * 
	 * 1. master cop no 가 1건 이상 존재할 경우
	 * 해당 container 로 발행된 s/o 를 split booking, combine booking, original booking no
	 * 로 valid 한 S/O 를 모두 조회하여 발생건수가 가장 많은 Bkg no 를 취하여 해당 booking no 로
	 * 생성된 cop 를 찾고 
	 * 
	 * 2. master cop no 가 관련이 없는 것이 들어가 있을 경우
	 * master cop no 를 새로 선정하고 partial 로 엮인 booking 으로 생성된 so 를 모두 찾아 booking no 를 
	 * update 하고 mst_cop_no 역시 변경하여 준다.
	 * 
	 * @param bkg_no
	 * @param cntr_no
	 * @param cop_no
	 * @return String
	 * @throws EventException
	 */
	public String arrangeMstCopNo(String bkg_no, String cntr_no, String cop_no) throws EventException;
	
	/**
	 * Master flag 를 fm_cop_no 에서 to_cop_no 로 이동시킨다.
	 * @param fm_cop_no
	 * @param to_cop_no
	 * @return int
	 * @throws EventException
	 */
	public int moveMstFlg(String fm_cop_no, String to_cop_no) throws EventException ;

	/**
	 * Booking 에서 event 가 넘어오는 splitBkg, updateBkg method call case (Split, Booking update)
	 * 에서 호출되며 PRD_BKG_COP_MAP 에 지정된 operation 을 수행한다.
	 * @param prdBkgCopMapVO
	 * @throws EventException
	 */
	public void replanCopByPrdMap(PrdBkgCopMapVO prdBkgCopMapVO) throws EventException;
	
	/**
	 * COP 단건에 대한 replan 을 진행한다.
	 * @param sceCopHdrVO SceCopHdrVO
	 * @param cop_upd_rmk String
	 * @return boolean
	 * @throws EventException -
	 */
	public boolean replanCop(SceCopHdrVO sceCopHdrVO, String cop_upd_rmk) throws EventException;
	
	/**
	 * sce_cop_hdr 에 set 될 주요 정보를 포함한 SceCopHdrVO 정보로 COP 를 생성한다. 
	 * @param sceCopHdrVOs List<SceCopHdrVO>
	 * @throws EventException - 
	 */
	public void createNewCop(List<SceCopHdrVO> sceCopHdrVOs) throws EventException;
	
	/**
	 * Rail S/O 화면에서 call 
	 * 내부적으로 replanCop(HashMap) method 호출
	 * @param trsTrspRailBilOrdVO
	 * @return ReplanResultVO
	 * @throws EventException
	 */
	public ReplanResultVO replanCop (TrsTrspRailBilOrdVO trsTrspRailBilOrdVO) throws EventException ;
	
	/**
	 * Cy/Door S/O 화면에서 call
	 * 내부적으로 replanCop(HashMap) method 호출
	 * @param trsTrspSvcOrdVO
	 * @return ReplanResultVO
	 * @throws EventException
	 */
	public ReplanResultVO replanCop (TrsTrspSvcOrdVO trsTrspSvcOrdVO) throws EventException;
	
	
	/**
	 * TRS에서 통합 VO 인 sinngleTransportationVO 를 사용하여 call
	 * 내부적으로 replanCop(HashMap) method 호출 
	 * @param singleTransportationVO
	 * @return ReplanResultVO
	 * @throws EventException
	 */
	public ReplanResultVO replanCop (SingleTransportationVO singleTransportationVO) throws EventException;
	

	/**
	 * @param trsTrspEdiRailOrdVO
	 * @return ReplanResultVO
	 * @throws EventException
	 */
	public ReplanResultVO replanCop (TrsTrspEdiRailOrdVO trsTrspEdiRailOrdVO) throws EventException;
	
	
	/**
	 * Partial 관계에 있는 COP 를 모두 찾아 동일한 PC 로 replan 한다.
	 * COP 가 FINISH 되어 있다면 PARTIAL 을 찾지 않고 해당 건만 REPLAN 한다.
	 * PARTIAL 조회 후 replanCop(SceCopHdrVO) 를 호출하는 단순 구조
	 * @param sceCopHdrVO
	 * @param account
	 * @throws EventException
	 */
	public void replanCopInclPrt(SceCopHdrVO sceCopHdrVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * replan 이 필요없는 S/O 발행의 경우 단순히 trsp_so_sts_cd 의 update
	 * @param singleTransportationVO
	 * @return int
	 * @throws EventException
	 */
	public int modifySoList (SingleTransportationVO singleTransportationVO) throws EventException;
	
	/**
	 * replan 이 필요없는 S/O 발행의 경우 단순히 trsp_so_sts_cd 의 update
	 * @param trsTrspRailBilOrdVO TrsTrspRailBilOrdVO
	 * @return int
	 * @throws EventException -
	 */
	public int modifySoList (TrsTrspRailBilOrdVO trsTrspRailBilOrdVO) throws EventException;
	
	/**
	 * replan 이 필요없는 S/O 발행의 경우 단순히 trsp_so_sts_cd 의 update
	 * @param trsTrspEdiRailOrdVO
	 * @return int
	 * @throws EventException
	 */
	public int modifySoList (TrsTrspEdiRailOrdVO trsTrspEdiRailOrdVO) throws EventException;
	
	/**
	 * WRS 에서 call 하는 prov_cntr_no, prov_cntr_tpsz_cd 변경 metohd
	 * @param sceCopHdrVO
	 * @return int
	 * @throws EventException
	 */
	public int modifyProvCntrByWRS (SceCopHdrVO sceCopHdrVO) throws EventException;

	
	/**
	 * 임시 replan logic 을 관리 목적을 위하여 수행한다.
	 * @param sceCopHdrVO
	 * @throws EventException
	 */
	public void replanCopTmp (SceCopHdrVO sceCopHdrVO) throws EventException;
	
	/**
	 * @param sceCopHdrVO
	 * @throws EventException
	 */
	public void replanCopTmpVSK (SceCopHdrVO sceCopHdrVO) throws EventException;
}