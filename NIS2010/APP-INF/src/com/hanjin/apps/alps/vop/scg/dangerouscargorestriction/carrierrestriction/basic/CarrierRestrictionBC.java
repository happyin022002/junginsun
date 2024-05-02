/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierRestrictionBC.java
*@FileTitle : VSL OPR's Restriction on DG (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.09 장강철
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2012.04.20 서석진 [CHM-201216960-01] Vessl Operator내 파일첨부 기능 추가
* 처리내역 :첨부파일 팝업화면과 팝업화면에서 파일등록,삭제 기능 추가
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionOptionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.FileVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.PortRestrictionOptionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.ScgImdgCrrRstrVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Dangerouscargorestriction Business Logic Command Interface<br>
 * - ALPS-Dangerouscargorestriction에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jang kang cheol
 * @see Vop_scg_0009EventResponse 참조
 * @since J2EE 1.6
 */

public interface CarrierRestrictionBC {
 
 
	/**
	 * 
     * Carrier Restirction 메인 조회 <br>
     * 
	 * @param  CarrierRestrictionOptionVO carrierRestrictionOptionVO
	 * @return List<CarrierRestrictionVO>
     * @throws EventException
	 */
	public  List<CarrierRestrictionVO>  searchCarrierRestriction(CarrierRestrictionOptionVO carrierRestrictionOptionVO ) throws EventException;
 
 
    /**
     * 
     * VOP_SCG_0009 Carrier Restiction SAVE 처리 <br>
     * 
     * @param  CarrierRestrictionOptionVO carrierRestrictionOptionVO
     * @param  signOnUserAccount SignOnUserAccount 
     * @throws EventException
     */
	public void manageCarrierRestriction(  CarrierRestrictionOptionVO carrierRestrictionOptionVO,SignOnUserAccount signOnUserAccount) throws EventException;
 
	/**
	 * Port & VSL OPR’s Carrier Restriction En-route 메인 조회 <br>
     * 
     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<ScgImdgCrrRstrVO> 
     * @throws EventException
     */ 
	public List<ScgImdgCrrRstrVO> searchCarrierEnRouteList(PortRestrictionOptionVO portRestrictionOptionVO) throws EventException;	
	
	/**
	 * Port & VSL OPR’s Port Restriction En-route 메인 조회 <br>

     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<PortRestrictionOptionVO> 
     * @throws EventException
     */ 
	public List<PortRestrictionOptionVO> searchPortEnRouteList(PortRestrictionOptionVO portRestrictionOptionVO) throws EventException;	
	
	/**
	 * Port & VSL OPR’s Port Restriction En-route 메인 조회 <br>

     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<PortRestrictionOptionVO> 
     * @throws EventException
     */ 
	public List<PortRestrictionOptionVO> searchPortRotnSeq(PortRestrictionOptionVO portRestrictionOptionVO) throws EventException;	
	
	 /**
	 * Vessel Operator's Restriction on DG file 을 조회 합니다. <br>
	 * 
	 * @param  String vslOprTpCd
	 * @return List<FileVO>
	 * @exception EventException
	 */
	public List<FileVO> searchFileList(String vslOprTpCd) throws EventException;
	
	/**
	 * Vessel Operator's Restriction on DG file 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param FileVO[] fileVOs
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFile(FileVO[] fileVOs, List<String> keys, SignOnUserAccount account) throws EventException;
	

	/**
	 * 첨부파일 이름 검색<br>

	 * @param String crrCd
     * @return String
     * @throws EventException
     */
	public String searchFileName(String crrCd) throws EventException;
	
	/**
	 * 첨부파일의 max seq 값을 검색<br>

	 * @param String vslOprTpCd
     * @return String
     * @throws EventException
     */
	public String searchFileSeq(String vslOprTpCd) throws EventException;
	
 

}