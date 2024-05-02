/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0056Event.java
 *@FileTitle : Inland Route 정보관리화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-04
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-04 jungsunyong
 * 1.0 최초 생성
 * 2012.10.17 김진승 [CHM-201220713][PRD] O5 CNTR 추가로 인한 PRD 상 변경사항
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event;

import java.util.Collection;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteMstVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchEmptyInlandRouteMasterListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PRD_INLND_ROUT_MST;

/**
 * ESD_PRD_056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jungsunyong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0056Event extends EventSupport{

	private static final long serialVersionUID = 1L;
	private SearchConditionVO searchConditionVO = null;
	private SearchEmptyInlandRouteMasterListVO searchEmptyInlandRouteMasterListVO = null;
	private SearchEmptyInlandRouteMasterListVO[] searchEmptyInlandRouteMasterListVOs = null;
	private InlandRouteDetVO inlandRouteDetVO = null;
	private InlandRouteDetVO[] inlandRouteDetVOs = null;
	private EmptySaveInlandRouteMstVO emptySaveInlandRouteMstVO = null;
	private EmptySaveInlandRouteMstVO[] emptySaveInlandRouteMstVOs = null;
	private EmptySaveInlandRouteDetVO emptySaveInlandRouteDetVO = null;
	private EmptySaveInlandRouteDetVO[] emptySaveInlandRouteDetVOs = null;

	/**
	 *
	 * @return
	 */
	public EmptySaveInlandRouteDetVO getEmptySaveInlandRouteDetVO(){
		return emptySaveInlandRouteDetVO;
	}

	/**
	 *
	 * @param emptySaveInlandRouteDetVO
	 */
	public void setEmptySaveInlandRouteDetVO(
			EmptySaveInlandRouteDetVO emptySaveInlandRouteDetVO){
		this.emptySaveInlandRouteDetVO = emptySaveInlandRouteDetVO;
	}

	/**
	 *
	 * @return
	 */
	public EmptySaveInlandRouteDetVO[] getEmptySaveInlandRouteDetVOs(){
		return emptySaveInlandRouteDetVOs;
	}

	/**
	 *
	 * @param emptySaveInlandRouteDetVOs
	 */
	public void setEmptySaveInlandRouteDetVOs(
			EmptySaveInlandRouteDetVO[] emptySaveInlandRouteDetVOs){
		this.emptySaveInlandRouteDetVOs = emptySaveInlandRouteDetVOs;
	}

	/**
	 *
	 * @return
	 */
	public EmptySaveInlandRouteMstVO getEmptySaveInlandRouteMstVO(){
		return emptySaveInlandRouteMstVO;
	}

	/**
	 *
	 * @param emptySaveInlandRouteMstVO
	 */
	public void setEmptySaveInlandRouteMstVO(
			EmptySaveInlandRouteMstVO emptySaveInlandRouteMstVO){
		this.emptySaveInlandRouteMstVO = emptySaveInlandRouteMstVO;
	}

	/**
	 *
	 * @return
	 */
	public EmptySaveInlandRouteMstVO[] getEmptySaveInlandRouteMstVOs(){
		return emptySaveInlandRouteMstVOs;
	}

	/**
	 *
	 * @param emptySaveInlandRouteMstVOs
	 */
	public void setEmptySaveInlandRouteMstVOs(
			EmptySaveInlandRouteMstVO[] emptySaveInlandRouteMstVOs){
		this.emptySaveInlandRouteMstVOs = emptySaveInlandRouteMstVOs;
	}

	/**
	 *
	 * @return
	 */
	public InlandRouteDetVO getInlandRouteDetVO(){
		return inlandRouteDetVO;
	}

	/**
	 *
	 * @param inlandRouteDetVO
	 */
	public void setInlandRouteDetVO(InlandRouteDetVO inlandRouteDetVO){
		this.inlandRouteDetVO = inlandRouteDetVO;
	}

	/**
	 *
	 * @return
	 */
	public InlandRouteDetVO[] getInlandRouteDetVOs(){
		return inlandRouteDetVOs;
	}

	/**
	 *
	 * @param inlandRouteDetVOs
	 */
	public void setInlandRouteDetVOs(InlandRouteDetVO[] inlandRouteDetVOs){
		this.inlandRouteDetVOs = inlandRouteDetVOs;
	}

	/**
	 *
	 * @return
	 */
	public SearchEmptyInlandRouteMasterListVO getSearchEmptyInlandRouteMasterListVO(){
		return searchEmptyInlandRouteMasterListVO;
	}

	/**
	 *
	 * @param searchEmptyInlandRouteMasterListVO
	 */
	public void setSearchEmptyInlandRouteMasterListVO(
			SearchEmptyInlandRouteMasterListVO searchEmptyInlandRouteMasterListVO){
		searchEmptyInlandRouteMasterListVO = searchEmptyInlandRouteMasterListVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchEmptyInlandRouteMasterListVO[] getSearchEmptyInlandRouteMasterListVOs(){
		return searchEmptyInlandRouteMasterListVOs;
	}

	/**
	 *
	 * @param searchEmptyInlandRouteMasterListVOs
	 */
	public void setSearchEmptyInlandRouteMasterListVOs(
			SearchEmptyInlandRouteMasterListVO[] searchEmptyInlandRouteMasterListVOs){
		this.searchEmptyInlandRouteMasterListVOs = searchEmptyInlandRouteMasterListVOs;
	}
	private String wrsFlg = "";
	private String wrsChk = "";
	private String fromCd = "";
	private String toCd = "";
	private String iSelRow = "";
	private String iInv = "";
	private String iRoutPlnCd = "";
	private String iRouteRmk = "";
	private String iRoutOrgNodCd = "";
	private String iRoutDestNodCd = "";
	private String iRoutSeq = "";
	private String iNewRouteCd = "";
	private String iD2Flg = "";
	private String iD4Flg = "";
	private String iD5Flg = "";
	private String iD7Flg = "";
	private String iO2Flg = "";
	private String iO4Flg = "";
	private String iO5Flg = ""; // added in 2012.10.17
	private String iA2Flg = "";
	private String iA4Flg = "";
	private String iR2Flg = "";
//    private String i_r4_flg = "";
	private String iR5Flg = "";
	private PRD_INLND_ROUT_MST prdInlandRoutMst = null;
	private Collection prdInlandRoutMsts = null;

	/**
	 *
	 * @return
	 */
	public String getWrsFlg(){
		return wrsFlg;
	}

	/**
	 *
	 * @param wrsFlg
	 */
	public void setWrsFlg(String wrsFlg){
		this.wrsFlg = wrsFlg;
	}

	/**
	 *
	 * @return
	 */
	public String getWrsChk(){
		return wrsChk;
	}

	/**
	 *
	 * @param wrsChk
	 */
	public void setWrsChk(String wrsChk){
		this.wrsChk = wrsChk;
	}

	/**
	 *
	 * @return
	 */
	public String getFromCd(){
		return fromCd;
	}

	/**
	 *
	 * @param fromCd
	 */
	public void setFromCd(String fromCd){
		this.fromCd = fromCd;
	}

	/**
	 *
	 * @return
	 */
	public String getToCd(){
		return toCd;
	}

	/**
	 *
	 * @param toCd
	 */
	public void setToCd(String toCd){
		this.toCd = toCd;
	}

	/**
	 *
	 * @return
	 */
	public String getISelRow(){
		return iSelRow;
	}

	/**
	 *
	 * @param row
	 */
	public void setISelRow(String row){
		iSelRow = row;
	}

	/**
	 *
	 * @return
	 */
	public String getIInv(){
		return iInv;
	}

	/**
	 *
	 * @param iInv
	 */
	public void setIInv(String iInv){
		this.iInv = iInv;
	}

	/**
	 *
	 * @return
	 */
	public String getIRoutPlnCd(){
		return iRoutPlnCd;
	}

	/**
	 *
	 * @param iRoutPlnCd
	 */
	public void setIRoutPlnCd(String iRoutPlnCd){
		this.iRoutPlnCd = iRoutPlnCd;
	}

	/**
	 *
	 * @return
	 */
	public String getIRouteRmk(){
		return iRouteRmk;
	}

	/**
	 *
	 * @param iRouteRmk
	 */
	public void setIRouteRmk(String iRouteRmk){
		this.iRouteRmk = iRouteRmk;
	}

	/**
	 *
	 * @return
	 */
	public String getIRoutOrgNodCd(){
		return iRoutOrgNodCd;
	}

	/**
	 *
	 * @param iRoutOrgNodCd
	 */
	public void setIRoutOrgNodCd(String iRoutOrgNodCd){
		this.iRoutOrgNodCd = iRoutOrgNodCd;
	}

	/**
	 *
	 * @return
	 */
	public String getIRoutDestNodCd(){
		return iRoutDestNodCd;
	}

	/**
	 *
	 * @param iRoutDestNodCd
	 */
	public void setIRoutDestNodCd(String iRoutDestNodCd){
		this.iRoutDestNodCd = iRoutDestNodCd;
	}

	/**
	 *
	 * @return
	 */
	public String getIRoutSeq(){
		return iRoutSeq;
	}

	/**
	 *
	 * @param iRoutSeq
	 */
	public void setIRoutSeq(String iRoutSeq){
		this.iRoutSeq = iRoutSeq;
	}

	/**
	 *
	 * @return
	 */
	public String getINewRouteCd(){
		return iNewRouteCd;
	}

	/**
	 *
	 * @param routeCd
	 */
	public void setINewRouteCd(String routeCd){
		iNewRouteCd = routeCd;
	}

	/**
	 *
	 * @return
	 */
	public String getID2Flg(){
		return iD2Flg;
	}

	/**
	 *
	 * @param iD2Flg
	 */
	public void setID2Flg(String iD2Flg){
		this.iD2Flg = iD2Flg;
	}

	/**
	 *
	 * @return
	 */
	public String getID4Flg(){
		return iD4Flg;
	}

	/**
	 *
	 * @param iD4Flg
	 */
	public void setID4Flg(String iD4Flg){
		this.iD4Flg = iD4Flg;
	}

	/**
	 *
	 * @return
	 */
	public String getID5Flg(){
		return iD5Flg;
	}

	/**
	 *
	 * @param iD5Flg
	 */
	public void setID5Flg(String iD5Flg){
		this.iD5Flg = iD5Flg;
	}

	/**
	 *
	 * @return
	 */
	public String getID7Flg(){
		return iD7Flg;
	}

	/**
	 *
	 * @param iD7Flg
	 */
	public void setID7Flg(String iD7Flg){
		this.iD7Flg = iD7Flg;
	}

	/**
	 *
	 * @return
	 */
	public String getIO2Flg(){
		return iO2Flg;
	}

	/**
	 *
	 * @param iO2Flg
	 */
	public void setIO2Flg(String iO2Flg){
		this.iO2Flg = iO2Flg;
	}

	/**
	 *
	 * @return
	 */
	public String getIO4Flg(){
		return iO4Flg;
	}

	/**
	 *
	 * @param iO4Flg
	 */
	public void setIO4Flg(String iO4Flg){
		this.iO4Flg = iO4Flg;
	}

	/**
	 *
	 * @return
	 */
	public String getIO5Flg(){
		return iO5Flg;
	}

	/**
	 *
	 * @param iO5Flg
	 */
	public void setIO5Flg(String iO5Flg){
		this.iO5Flg = iO5Flg;
	}
	
	/**
	 *
	 * @return
	 */
	public String getIA2Flg(){
		return iA2Flg;
	}

	/**
	 *
	 * @param iA2Flg
	 */
	public void setIA2Flg(String iA2Flg){
		this.iA2Flg = iA2Flg;
	}

	/**
	 *
	 * @return
	 */
	public String getIA4Flg(){
		return iA4Flg;
	}

	/**
	 *
	 * @param iA4Flg
	 */
	public void setIA4Flg(String iA4Flg){
		this.iA4Flg = iA4Flg;
	}

	/**
	 *
	 * @return
	 */
	public String getIR2Flg(){
		return iR2Flg;
	}

	/**
	 *
	 * @param iR2Flg
	 */
	public void setIR2Flg(String iR2Flg){
		this.iR2Flg = iR2Flg;
	}

	/**
	 *
	 * @return
	 */
	public String getIR5Flg(){
		return iR5Flg;
	}

	/**
	 *
	 * @param iR5Flg
	 */
	public void setIR5Flg(String iR5Flg){
		this.iR5Flg = iR5Flg;
	}

	/**
	 *
	 * @return
	 */
	public PRD_INLND_ROUT_MST getprdInlandRoutMst(){
		return prdInlandRoutMst;
	}

	/**
	 *
	 * @param prdInlandRoutMst
	 */
	public void setprdInlandRoutMst(PRD_INLND_ROUT_MST prdInlandRoutMst){
		this.prdInlandRoutMst = prdInlandRoutMst;
	}

	/**
	 *
	 * @return
	 */
	public Collection getPrdInlandRoutMsts(){
		return prdInlandRoutMsts;
	}

	/**
	 *
	 * @param prdInlandRoutMsts
	 */
	public void setPrdInlandRoutMsts(Collection prdInlandRoutMsts){
		this.prdInlandRoutMsts = prdInlandRoutMsts;
	}

	/**
	 *
	 * @return
	 */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

	/**
	 *
	 * @param searchConditionVO
	 */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}

	/**
	 *
	 * @param val
	 * @return
	 */
	public String getString(String val){
		return "";
	}

	/**
	 *
	 * @param val
	 * @return
	 */
	public String[] getObject(String val){
		String[] a = new String[1];
		return a;
	}
}
