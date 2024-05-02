/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaBlDetailContainerVO.java
*@FileTitle : US AMS: B/L INQUIRY
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.06.05 이수빈
* 1.0 최초 생성
* -----------------------------------------------------
* History
* 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0210Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;

/**
 * HTTP Parser<br>
 * - 여러 개의 시트 정보를 담을 통합 컨테이너 VO<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Subin
 * @see EsmBkg0210Event 참조
 * @since J2EE 1.5
 */
public class UsaBlDetailContainerVO extends BlDetailVO {

	private static final long serialVersionUID = 1L;

	public UsaBlDetailContainerVO() {}
	
	String blNo = null;
	String divInd = null;
	String blCstms = null;

	UsaAiBlInfoVO oldAiBlInfoVO = null;
	UsaBlCustVO[] oldBlCustVOs = null;
	UsaBlCustomerSecondVO[] oldBlCustomerSecondVOs = null;
	UsaBlRemarkVO oldBlRemarkVO = null;

	UsaAiBlInfoVO newAiBlInfoVO = null;
	UsaBlCustVO[] newBlCustVOs = null;
	UsaBlCustomerSecondVO[] newBlCustomerSecondVOs = null;
	UsaBlRemarkVO newBlRemarkVO = null;
	
	UsaAiBlInfoVO usaAiBlInfoVO = null;
	List<UsaBlCustVO> usaBlCustVOs = null;
	List<UsaBlCustomerSecondVO> usaBlCustomerSecondVOs = null;
	List<UsaBlCustomsResultVO> usaBlCustomsResultVOs = null;
	List<UsaBlRemarkVO> usaBlRemarkVOs = null;
	List<UsaBlHistoryVO> usaBlHistoryVOs = null;
	List<UsaBlHblListVO> usaBlHblListVOs = null;
	List<UsaBlMultiBlListVO> usaBlMultiBlListVOs = null;
	//String commonUser = null;

	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	public String getDivInd() {
		return divInd;
	}
	public void setDivInd(String divInd) {
		this.divInd = divInd;
	}
	public String getBlCstms() {
		return blCstms;
	}
	public void setBlCstms(String blCstms) {
		this.blCstms = blCstms;
	}
	public UsaAiBlInfoVO getOldAiBlInfoVO() {
		return oldAiBlInfoVO;
	}
	public void setOldAiBlInfoVO(UsaAiBlInfoVO oldAiBlInfoVO) {
		this.oldAiBlInfoVO = oldAiBlInfoVO;
	}
	public UsaBlCustVO[] getOldBlCustVOs() {
		return oldBlCustVOs;
	}
	public void setOldBlCustVOs(UsaBlCustVO[] oldBlCustVOs) {
		this.oldBlCustVOs = oldBlCustVOs;
	}
	public UsaBlCustomerSecondVO[] getOldBlCustomerSecondVOs() {
		return oldBlCustomerSecondVOs;
	}
	public void setOldBlCustomerSecondVOs(
			UsaBlCustomerSecondVO[] oldBlCustomerSecondVOs) {
		this.oldBlCustomerSecondVOs = oldBlCustomerSecondVOs;
	}
	public UsaBlRemarkVO getOldBlRemarkVO() {
		return oldBlRemarkVO;
	}
	public void setOldBlRemarkVO(UsaBlRemarkVO oldBlRemarkVO) {
		this.oldBlRemarkVO = oldBlRemarkVO;
	}
	public UsaAiBlInfoVO getNewAiBlInfoVO() {
		return newAiBlInfoVO;
	}
	public void setNewAiBlInfoVO(UsaAiBlInfoVO newAiBlInfoVO) {
		this.newAiBlInfoVO = newAiBlInfoVO;
	}
	public UsaBlCustVO[] getNewBlCustVOs() {
		return newBlCustVOs;
	}
	public void setNewBlCustVOs(UsaBlCustVO[] newBlCustVOs) {
		this.newBlCustVOs = newBlCustVOs;
	}
	public UsaBlCustomerSecondVO[] getNewBlCustomerSecondVOs() {
		return newBlCustomerSecondVOs;
	}
	public void setNewBlCustomerSecondVOs(
			UsaBlCustomerSecondVO[] newBlCustomerSecondVOs) {
		this.newBlCustomerSecondVOs = newBlCustomerSecondVOs;
	}
	public UsaBlRemarkVO getNewBlRemarkVO() {
		return newBlRemarkVO;
	}
	public void setNewBlRemarkVO(UsaBlRemarkVO newBlRemarkVO) {
		this.newBlRemarkVO = newBlRemarkVO;
	}
	public UsaAiBlInfoVO getUsaAiBlInfoVO() {
		return usaAiBlInfoVO;
	}
	public void setUsaAiBlInfoVO(UsaAiBlInfoVO usaAiBlInfoVO) {
		this.usaAiBlInfoVO = usaAiBlInfoVO;
	}
	public List<UsaBlCustVO> getUsaBlCustVOs() {
		return usaBlCustVOs;
	}
	public void setUsaBlCustVOs(List<UsaBlCustVO> usaBlCustVOs) {
		this.usaBlCustVOs = usaBlCustVOs;
	}
	public List<UsaBlCustomerSecondVO> getUsaBlCustomerSecondVOs() {
		return usaBlCustomerSecondVOs;
	}
	public void setUsaBlCustomerSecondVOs(
			List<UsaBlCustomerSecondVO> usaBlCustomerSecondVOs) {
		this.usaBlCustomerSecondVOs = usaBlCustomerSecondVOs;
	}
	public List<UsaBlCustomsResultVO> getUsaBlCustomsResultVOs() {
		return usaBlCustomsResultVOs;
	}
	public void setUsaBlCustomsResultVOs(
			List<UsaBlCustomsResultVO> usaBlCustomsResultVOs) {
		this.usaBlCustomsResultVOs = usaBlCustomsResultVOs;
	}
	public List<UsaBlRemarkVO> getUsaBlRemarkVOs() {
		return usaBlRemarkVOs;
	}
	public void setUsaBlRemarkVOs(List<UsaBlRemarkVO> usaBlRemarkVOs) {
		this.usaBlRemarkVOs = usaBlRemarkVOs;
	}
	public List<UsaBlHistoryVO> getUsaBlHistoryVOs() {
		return usaBlHistoryVOs;
	}
	public void setUsaBlHistoryVOs(List<UsaBlHistoryVO> usaBlHistoryVOs) {
		this.usaBlHistoryVOs = usaBlHistoryVOs;
	}
	public List<UsaBlHblListVO> getUsaBlHblListVOs() {
		return usaBlHblListVOs;
	}
	public void setUsaBlHblListVOs(List<UsaBlHblListVO> usaBlHblListVOs) {
		this.usaBlHblListVOs = usaBlHblListVOs;
	}
	public List<UsaBlMultiBlListVO> getUsaBlMultiBlListVOs() {
		return usaBlMultiBlListVOs;
	}
	public void setUsaBlMultiBlListVOs(List<UsaBlMultiBlListVO> usaBlMultiBlListVOs) {
		this.usaBlMultiBlListVOs = usaBlMultiBlListVOs;
	}

}
