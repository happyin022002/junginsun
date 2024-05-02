/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri200305Event.java
*@FileTitle : RFA Proposal Creation - Arbitrary(AEE/AEW)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.11
*@LastModifier : RYU HYUK
*@LastVersion : 1.0
* 2012.05.11 RYU HYUK
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.FicRouteGLineVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.GLineInfoByFICRouteVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_0003_05 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0005_05HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author RYU HYUK
 * @see ESM_PRI_2003_05HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri200305Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FicRouteGLineVO ficRouteGLineVO = null;
	private GLineInfoByFICRouteVO gLineInfoByFICRouteVO = null;
	
//	private PriRpScpTrspAddChgVO priRpScpTrspAddChgVO = null;
//	private CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO = null;
//	private ChkFontStyleVO chkFontStyleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private FicRouteGLineVO[] ficRouteGLineVOs = null;
	private GLineInfoByFICRouteVO[] gLineInfoByFICRouteVOs = null;
//	private PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs = null;
//	private CstPriRpScpTrspAddChgVO[] cstPriRpScpTrspAddChgVOs = null;
//	private RsltArbChgListVO[] rsltArbChgListVOs = null;
//	private PriRgArbVO[] priRgArbVOs = null;
	
	public EsmPri200305Event(){}

	public FicRouteGLineVO getFicRouteGLineVO() {
		return ficRouteGLineVO;
	}

	public void setFicRouteGLineVO(FicRouteGLineVO ficRouteGLineVO) {
		this.ficRouteGLineVO = ficRouteGLineVO;
	}

	public FicRouteGLineVO[] getFicRouteGLineVOs() {
		FicRouteGLineVO[] rtnVOs = null;
		if (this.ficRouteGLineVOs != null) {
			rtnVOs = new FicRouteGLineVO[ficRouteGLineVOs.length];
			System.arraycopy(ficRouteGLineVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFicRouteGLineVOs(FicRouteGLineVO[] ficRouteGLineVOs){
		if(ficRouteGLineVOs != null){
			FicRouteGLineVO[] tmpVOs = new FicRouteGLineVO[ficRouteGLineVOs.length];
			System.arraycopy(ficRouteGLineVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ficRouteGLineVOs = tmpVOs;
		}
	}

	public GLineInfoByFICRouteVO getGLineInfoByFICRouteVO() {
		return gLineInfoByFICRouteVO;
	}

	public void setGLineInfoByFICRouteVO(GLineInfoByFICRouteVO gLineInfoByFICRouteVO) {
		this.gLineInfoByFICRouteVO = gLineInfoByFICRouteVO;
	}

	public GLineInfoByFICRouteVO[] getGLineInfoByFICRouteVOs() {
		GLineInfoByFICRouteVO[] rtnVOs = null;
		if (this.gLineInfoByFICRouteVOs != null) {
			rtnVOs = new GLineInfoByFICRouteVO[gLineInfoByFICRouteVOs.length];
			System.arraycopy(gLineInfoByFICRouteVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setGLineInfoByFICRouteVOs(GLineInfoByFICRouteVO[] gLineInfoByFICRouteVOs){
		if(gLineInfoByFICRouteVOs != null){
			GLineInfoByFICRouteVO[] tmpVOs = new GLineInfoByFICRouteVO[gLineInfoByFICRouteVOs.length];
			System.arraycopy(gLineInfoByFICRouteVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.gLineInfoByFICRouteVOs = tmpVOs;
		}
	}
	
	
	
//	public void setPriRpScpTrspAddChgVO(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO){
//		this. priRpScpTrspAddChgVO = priRpScpTrspAddChgVO;
//	}
//
//	public void setPriRpScpTrspAddChgVOS(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs){
//		this. priRpScpTrspAddChgVOs = priRpScpTrspAddChgVOs;
//	}
//	
//	public void setRsltArbChgListVOS(RsltArbChgListVO[] rsltArbChgListVOs){
//		this. rsltArbChgListVOs = rsltArbChgListVOs;
//	}
//	
//	public void setPriRgArbVOS(PriRgArbVO[] priRgArbVOs){
//		this. priRgArbVOs = priRgArbVOs;
//	}
//	
//	public void setCstPriRpScpTrspAddChgVO(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO){
//		this. cstPriRpScpTrspAddChgVO = cstPriRpScpTrspAddChgVO;
//	}
//
//	public void setCstPriRpScpTrspAddChgVOS(CstPriRpScpTrspAddChgVO[] cstPriRpScpTrspAddChgVOs){
//		this. cstPriRpScpTrspAddChgVOs = cstPriRpScpTrspAddChgVOs;
//	}
//	
//	public CstPriRpScpTrspAddChgVO getCstPriRpScpTrspAddChgVO(){
//		return cstPriRpScpTrspAddChgVO;
//	}
//
//	public CstPriRpScpTrspAddChgVO[] getCstPriRpScpTrspAddChgVOS(){
//		return cstPriRpScpTrspAddChgVOs;
//	}
//	
//	public PriRpScpTrspAddChgVO getPriRpScpTrspAddChgVO(){
//		return priRpScpTrspAddChgVO;
//	}
//
//	public PriRpScpTrspAddChgVO[] getPriRpScpTrspAddChgVOS(){
//		return priRpScpTrspAddChgVOs;
//	}
//	
//	public RsltArbChgListVO[] getRsltArbChgListVOS(){
//		return rsltArbChgListVOs;
//	}
//	
//	public PriRgArbVO[] getPriRgArbVOS(){
//		return priRgArbVOs;
//	}
//	
//	public void setChkFontStyleVO(ChkFontStyleVO chkFontStyleVO) {
//		this. chkFontStyleVO = chkFontStyleVO;
//	}
//	
//	public ChkFontStyleVO getChkFontStyleVO() {
//		return chkFontStyleVO;
//	}
}