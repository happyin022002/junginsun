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
 * 2012.06.20 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
 * 2012.12.18 김진주 [CHM-201220395-04] Add-on management T/F
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgCntrVgmInfoListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * NIS2010-RfaOftAutoRating Business Logic Command Interface<br>
 * - NIS2010-RfaOftAutoRating 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author LEE JINSEO
 * @see Esm_bkg_0269EventResponse 참조
 * @since J2EE 1.6
 */

public interface RfaOftAutoRatingBC {

	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking RFA 화면에 대한  Surcharge 값을 구해옴 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String ctrtTpCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchRfaOftAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd, String cmdtCd, String ctrtTpCd) throws EventException;
	
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking RFA 화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 RFA No중에서 미주향발 Cargo에 대한 운임 산정 서비스호출

	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String rfaNo
 	 * @param String Rtaplydt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchRfaOftAutoratingListVO> searchRfaOftAutoratingList(String bkgNo, String caFlag,String rfaNo, String Rtaplydt, String scpCd, String cmdtCd) throws EventException;
	
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking RFA 화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 RFA No중에서 미주향발 Cargo에 대한 운임 산정 서비스호출

	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String rfaNo
 	 * @param String Rtaplydt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchRfaOftAutoratingListVO> searchRfaFICOftAutoratingList(String bkgNo, String caFlag,String rfaNo, String Rtaplydt, String scpCd, String cmdtCd) throws EventException;
	
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking RFA 화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 RFA No중에서 미주향발 Cargo에 대한 운임 산정 서비스호출 -- AEE Scope

	 * @author JJ
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String rfaNo
 	 * @param String Rtaplydt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchRfaOftAutoratingListVO> searchRfaAEEOftAutoratingList(String bkgNo, String caFlag,String rfaNo, String rtAplyDt, String scpCd, String cmdtCd) throws EventException;

	
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking RFA 화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 RFA No중에서 미주향발 Cargo에 대한 운임 산정 서비스호출 -- AEW Scope

	 * @author JJ
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String rfaNo
 	 * @param String Rtaplydt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchRfaOftAutoratingListVO> searchRfaAEWOftAutoratingList(String bkgNo, String caFlag,String rfaNo, String rtAplyDt, String scpCd, String cmdtCd) throws EventException;
	
	/**
	 * 구주 Hinterland 업무 개선 T/F 
	 * AEE, AEW Scope에 대해 신규 적용되는 Autorating 로직 적용 기준일자를 확인하여
	 * 신규 로직으로 Rating할지의 여부를 조회한다.
	 * @author JJ
 	 * @param String Rtaplydt
 	 * @param String bkgNo
 	 * @param String caFlg
	 * @return String
	 * @exception EventException
	 */
	public String searchHinterlandApplyFlag(String rtAplyDt, String bkgNo, String caFlg) throws EventException;	
	
	/**
	 * searchPreCheckRtAplyDt 조회 이벤트 처리
	 * RFA OFT계산 가능 여부를 확인하기를 위해 Rate Application Date를 YYYYMMDD 형식으로 조회
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @throws EventException
	 */
	public String searchPreCheckRtAplyDt(String bkgNo ,String caFlg) throws EventException;

	
	/**
	 * checkOftRateMatch 조회 이벤트 처리
	 * RFA OFT계산결과를 체크한다.
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @throws EventException
	 */
	public String checkOftRateMatch(String bkgNo, String caFlg) throws EventException;
	
	/**
     * RFA OFT 관련 운임 중 IHC 관련 VGM 확인 로직<br>
     * 현재는 India In/Out 관련 Route 에서만 확인하며, Rating 시에는 No Rate를 방지하기 위해 Audit일때만 한다.

     * @author Kim Dong Ho
     * @param List<SearchRfaOftAutoratingListVO> rfaOftList, List<BkgCntrVgmInfoListVO> bkgVGMList
     * @return List<SearchRfaOftAutoratingListVO>
     * @exception EventException
     */
    public List<SearchRfaOftAutoratingListVO> checkVGMForIHCCorrection(List<SearchRfaOftAutoratingListVO> rfaOftList, List<BkgCntrVgmInfoListVO> bkgVGMList) throws EventException;
}