package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.TransmitDetailVO;
import com.hanjin.syscommon.common.table.BlSummaryVO;
import com.hanjin.syscommon.common.table.DateVO;


public class KorTransmitContainerVO extends TransmitDetailVO
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ErrorCode : 
	 * -1 - SQL Error
	 * 0 - 정상
	 * 1 - Mrn_No 없음
	 * 2 - 
	 */
	private int errorCode = 0;
	private int insertCount = 0;
	private int updateCount = 0;
	private int deleteCount = 0;
	private String sendCheck = null;
	
	// Structure Data
	private KorBkgCstmsVvdSmryVO searchMrnNoInKorNode = null;
	private KorSumVO searchSummaryInfoNode = null;
	private BlSummaryVO searchBlSummaryInfoNode = null;
	private KorBkgCstmsVvdSmryVO searchVVDInfoKorNode = null;
	private DateVO searchSendDateNode = null;
	
	private String searchVVDSeqKorNode = null;
	private String searchVVDSendCheckNode = null;
	private String searchExistCntKorNode = null;
	private String searchBondAreaCd = null;
	private String searchTransPreCntNode = null;
	
	private StringBuffer flatFileData = null;
	
	
	public KorTransmitContainerVO(){		
	}


	/**
	 * @return the searchMrnNoInKorNode
	 */
	public KorBkgCstmsVvdSmryVO getSearchMrnNoInKorNode() {
		return searchMrnNoInKorNode;
	}


	/**
	 * @param searchMrnNoInKorNode the searchMrnNoInKorNode to set
	 */
	public void setSearchMrnNoInKorNode(KorBkgCstmsVvdSmryVO searchMrnNoInKorNode) {
		this.searchMrnNoInKorNode = searchMrnNoInKorNode;
	}


	/**
	 * @return the searchSummaryInfoNode
	 */
	public KorSumVO getSearchSummaryInfoNode() {
		return searchSummaryInfoNode;
	}


	/**
	 * @param searchSummaryInfoNode the searchSummaryInfoNode to set
	 */
	public void setSearchSummaryInfoNode(KorSumVO searchSummaryInfoNode) {
		this.searchSummaryInfoNode = searchSummaryInfoNode;
	}


	/**
	 * @return the searchBlSummaryInfoNode
	 */
	public BlSummaryVO getSearchBlSummaryInfoNode() {
		return searchBlSummaryInfoNode;
	}


	/**
	 * @param searchBlSummaryInfoNode the searchBlSummaryInfoNode to set
	 */
	public void setSearchBlSummaryInfoNode(BlSummaryVO searchBlSummaryInfoNode) {
		this.searchBlSummaryInfoNode = searchBlSummaryInfoNode;
	}


	/**
	 * @return the searchVVDSeqKorNode
	 */
	public String getSearchVVDSeqKorNode() {
		return searchVVDSeqKorNode;
	}


	/**
	 * @param searchVVDSeqKorNode the searchVVDSeqKorNode to set
	 */
	public void setSearchVVDSeqKorNode(String searchVVDSeqKorNode) {
		this.searchVVDSeqKorNode = searchVVDSeqKorNode;
	}


	/**
	 * @return the searchVVDSendCheckNode
	 */
	public String getSearchVVDSendCheckNode() {
		return searchVVDSendCheckNode;
	}


	/**
	 * @param searchVVDSendCheckNode the searchVVDSendCheckNode to set
	 */
	public void setSearchVVDSendCheckNode(String searchVVDSendCheckNode) {
		this.searchVVDSendCheckNode = searchVVDSendCheckNode;
	}


	/**
	 * @return the searchExistCntKorNode
	 */
	public String getSearchExistCntKorNode() {
		return searchExistCntKorNode;
	}


	/**
	 * @param searchExistCntKorNode the searchExistCntKorNode to set
	 */
	public void setSearchExistCntKorNode(String searchExistCntKorNode) {
		this.searchExistCntKorNode = searchExistCntKorNode;
	}


	/**
	 * @return the searchBondAreaCd
	 */
	public String getSearchBondAreaCd() {
		return searchBondAreaCd;
	}


	/**
	 * @param searchBondAreaCd the searchBondAreaCd to set
	 */
	public void setSearchBondAreaCd(String searchBondAreaCd) {
		this.searchBondAreaCd = searchBondAreaCd;
	}


	/**
	 * @return the searchSendDateNode
	 */
	public DateVO getSearchSendDateNode() {
		return searchSendDateNode;
	}


	/**
	 * @param searchSendDateNode the searchSendDateNode to set
	 */
	public void setSearchSendDateNode(DateVO searchSendDateNode) {
		this.searchSendDateNode = searchSendDateNode;
	}


	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}


	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


	/**
	 * @return the insertCount
	 */
	public int getInsertCount() {
		return insertCount;
	}


	/**
	 * @param insertCount the insertCount to set
	 */
	public void setInsertCount(int insertCount) {
		this.insertCount = insertCount;
	}


	/**
	 * @return the updateCount
	 */
	public int getUpdateCount() {
		return updateCount;
	}


	/**
	 * @param deleteCount the deleteCount to set
	 */
	public void setUpdateCount(int updateCount) {
		this.updateCount = updateCount;
	}


	/**
	 * @param deleteCount the deleteCount to set
	 */
	public void setDeleteCount(int deleteCount){
		this.deleteCount = deleteCount;
	}
	
	
	/**
	 * @return the deleteCount
	 */
	public int getDeleteCount(){
		return this.deleteCount;
	}
	/**
	 * @return the searchTransPreCntNode
	 */
	public String getSearchTransPreCntNode() {
		return searchTransPreCntNode;
	}


	/**
	 * @param searchTransPreCntNode the searchTransPreCntNode to set
	 */
	public void setSearchTransPreCntNode(String searchTransPreCntNode) {
		this.searchTransPreCntNode = searchTransPreCntNode;
	}


	/**
	 * @return the searchVVDInfoKorNode
	 */
	public KorBkgCstmsVvdSmryVO getSearchVVDInfoKorNode() {
		return searchVVDInfoKorNode;
	}


	/**
	 * @param searchVVDInfoKorNode the searchVVDInfoKorNode to set
	 */
	public void setSearchVVDInfoKorNode(KorBkgCstmsVvdSmryVO searchVVDInfoKorNode) {
		this.searchVVDInfoKorNode = searchVVDInfoKorNode;
	}


	/**
	 * @return the flatFileData
	 */
	public StringBuffer getFlatFileData() {
		return flatFileData;
	}


	/**
	 * @param flatFileData the flatFileData to set
	 */
	public void setFlatFileData(StringBuffer flatFileData) {
		this.flatFileData = flatFileData;
	}


	/**
	 * @return the sendCheck
	 */
	public String getSendCheck() {
		return sendCheck;
	}


	/**
	 * @param sendCheck the sendCheck to set
	 */
	public void setSendCheck(String sendCheck) {
		this.sendCheck = sendCheck;
	}
	
}