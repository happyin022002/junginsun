/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingBC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.18 김영출
 * 1.0 Creation
* 2012.04.26 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사
* 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가
* 2013.04.24 김진주 [CHM-201323001] [BKG/DOC - Revenud Audit System] S/C 적용 B/L 자동심사기능 개발
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargePercentBaseChargeListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-ScOftAutoRatingBC Business Logic Command Interface<br>
 * - NIS2010-ScOftAutoRatingBC 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author LEE JINSEO
 * @see Esm_bkg_0269EventResponse 참조
 * @since J2EE 1.6
 */

public interface ScOftAutoRatingBC {

	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 ScETCOft SC No에 대한 운임 산정 서비스호출
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String ScNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String audTpCd
 	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScETCOftAutoratingList(String bkgNo, String caFlag, String ScNo, String rtAplyDt, String scpCd ,String cmdtCd, String audTpCd) throws EventException;
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 SC No에 대한 운임 산정 서비스호출
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String ScNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String audTpCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScTAEOftAutoratingList(String bkgNo, String caFlag, String ScNo, String rtAplyDt, String scpCd ,String cmdtCd, String audTpCd) throws EventException;
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 ScTAWOft SC No에 대한 운임 산정 서비스호출
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String ScNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String audTpCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScTAWOftAutoratingList(String bkgNo, String caFlag, String ScNo, String rtAplyDt, String scpCd ,String cmdtCd, String audTpCd) throws EventException;
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 ScTPSOft  SC No에 대한 운임 산정 서비스호출
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String ScNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String audTpCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScTPSOftAutoratingList(String bkgNo, String caFlag, String ScNo, String rtAplyDt, String scpCd ,String cmdtCd, String audTpCd) throws EventException;
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 TPWOft SC No에 대한 운임 산정 서비스호출
	 *  
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String ctrtTpCd
	 * @param String rtAplyDt
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd ,String cmdtCd, String ctrtTpCd, String rtAplyDt ) throws EventException;
	/**
	 * EsmBkg0269 surchargeautorating 등록  이벤트 처리<br>
	 * surchargeautorating 등록
	 * 
	 * @author LEE JIN SEO
	 * @param ScOftAutoratingListVO vo
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchSurchargeAutoratingList(ScOftAutoratingListVO vo ) throws EventException;
	/**
	 * Tariff 만으로 계산된 Surcharge Rating 결과를 조회
     *
	 * @author LEE JIN SEO
	 * @param ScOftAutoratingListVO vo
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	
	public List<SearchScOftAutoratingListVO> searchTariffSurchargeAutoratingList(ScOftAutoratingListVO vo ) throws EventException;
	/**
	 * EsmBkg0269 surchargeautorating 등록  이벤트 처리<br>
	 * surchargeautorating 등록
	 * 
	 * @author LEE JIN SEO
	 * @param SearchScOftAutoratingListVO[] vo
	 * @param String usrID
	 * @exception EventException
	 */
	
	public void manageScInformList(SearchScOftAutoratingListVO[] vo, String usrId) throws EventException;
	
	/**
	 * EsmBkg0269 searchSurchargePercentBaseChargeList 조회 이벤트 처리<br>
	 * SurchargePercentBaseChargeList 조회
	 * 
	 * @author LEE JIN SEO
	 * @return List<SearchSurchargePercentBaseChargeListVO>
	 * @exception EventException
	 */
	public List<SearchSurchargePercentBaseChargeListVO> searchSurchargePercentBaseChargeList() throws EventException;
	
	/**
	 * EsmBkg007901 searchPreCheckRtAplyDt 조회 이벤트 처리
	 * SC OFT계산 가능 여부를 확인하기를 위해 Rate Application Date를 YYYYMMDD 형식으로 조회
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @throws EventException
	 */
	public String searchPreCheckRtAplyDt(String bkgNo ,String caFlg ) throws EventException;
	
	/**
	 * EsmBkg007901 checkOftRateMatch 조회 이벤트 처리
	 * SC OFT계산결과를 체크한다.
	 * @param String bkgNo
	 * @param String caFlg 
	 * @return String
	 * @throws EventException
	 */
	public String checkOftRateMatch(String bkgNo, String caFlg) throws EventException;
	
	/**
	 * EsmBkg0256 Re-Audit<br>
	 * Backend로 수행하기 위해 Global Temp 테이블을 삭제시켜줌.
	 * 
	 * @author JIN JOO KIM
	 * @exception EventException
	 */
	public void manageAutoratingTempTables() throws EventException;

}
	
