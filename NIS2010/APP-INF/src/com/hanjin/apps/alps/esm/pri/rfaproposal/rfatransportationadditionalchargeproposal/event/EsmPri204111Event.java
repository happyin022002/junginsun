/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri204111Event.java
*@FileTitle : Amendment History - Arbitrary (For AEE/AEW)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.06.27
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 * 2012.06.27 서미진
 * 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRgArbVO;
import com.hanjin.syscommon.common.table.PriRpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.CstPriRpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltArbChgListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ChkFontStyleVO;


/**
 * ESM_PRI_2041_11 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2041_11HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chloe Mijin SEO
 * @see ESM_PRI_2041_11HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri204111Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpTrspAddChgVO priRpScpTrspAddChgVO = null;
	private CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO = null;
	private ChkFontStyleVO chkFontStyleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs = null;
	private CstPriRpScpTrspAddChgVO[] cstPriRpScpTrspAddChgVOs = null;
	private RsltArbChgListVO[] rsltArbChgListVOs = null;
	private PriRgArbVO[] priRgArbVOs = null;
	
	public EsmPri204111Event(){}
	
	public void setPriRpScpTrspAddChgVO(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO){
		this. priRpScpTrspAddChgVO = priRpScpTrspAddChgVO;
	}

	public void setPriRpScpTrspAddChgVOS(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs){
		if(priRpScpTrspAddChgVOs != null){
			PriRpScpTrspAddChgVO[] tmpVOs = new PriRpScpTrspAddChgVO[priRpScpTrspAddChgVOs.length];
			System.arraycopy(priRpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpTrspAddChgVOs = tmpVOs;
		}
	}
	
	public void setRsltArbChgListVOS(RsltArbChgListVO[] rsltArbChgListVOs){
		if(rsltArbChgListVOs != null){
			RsltArbChgListVO[] tmpVOs = new RsltArbChgListVO[rsltArbChgListVOs.length];
			System.arraycopy(rsltArbChgListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltArbChgListVOs = tmpVOs;
		}
	}
	
	public void setPriRgArbVOS(PriRgArbVO[] priRgArbVOs){
		if(priRgArbVOs != null){
			PriRgArbVO[] tmpVOs = new PriRgArbVO[priRgArbVOs.length];
			System.arraycopy(priRgArbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRgArbVOs = tmpVOs;
		}
	}
	
	public void setCstPriRpScpTrspAddChgVO(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO){
		this. cstPriRpScpTrspAddChgVO = cstPriRpScpTrspAddChgVO;
	}

	public void setCstPriRpScpTrspAddChgVOS(CstPriRpScpTrspAddChgVO[] cstPriRpScpTrspAddChgVOs){
		if(cstPriRpScpTrspAddChgVOs != null){
			CstPriRpScpTrspAddChgVO[] tmpVOs = new CstPriRpScpTrspAddChgVO[cstPriRpScpTrspAddChgVOs.length];
			System.arraycopy(cstPriRpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cstPriRpScpTrspAddChgVOs = tmpVOs;
		}
	}
	
	public CstPriRpScpTrspAddChgVO getCstPriRpScpTrspAddChgVO(){
		return cstPriRpScpTrspAddChgVO;
	}

	public CstPriRpScpTrspAddChgVO[] getCstPriRpScpTrspAddChgVOS(){
		CstPriRpScpTrspAddChgVO[] rtnVOs = null;
		if (this.cstPriRpScpTrspAddChgVOs != null) {
			rtnVOs = new CstPriRpScpTrspAddChgVO[cstPriRpScpTrspAddChgVOs.length];
			System.arraycopy(cstPriRpScpTrspAddChgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public PriRpScpTrspAddChgVO getPriRpScpTrspAddChgVO(){
		return priRpScpTrspAddChgVO;
	}

	public PriRpScpTrspAddChgVO[] getPriRpScpTrspAddChgVOS(){
		PriRpScpTrspAddChgVO[] rtnVOs = null;
		if (this.priRpScpTrspAddChgVOs != null) {
			rtnVOs = new PriRpScpTrspAddChgVO[priRpScpTrspAddChgVOs.length];
			System.arraycopy(priRpScpTrspAddChgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public RsltArbChgListVO[] getRsltArbChgListVOS(){
		RsltArbChgListVO[] rtnVOs = null;
		if (this.rsltArbChgListVOs != null) {
			rtnVOs = new RsltArbChgListVO[rsltArbChgListVOs.length];
			System.arraycopy(rsltArbChgListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public PriRgArbVO[] getPriRgArbVOS(){
		PriRgArbVO[] rtnVOs = null;
		if (this.priRgArbVOs != null) {
			rtnVOs = new PriRgArbVO[priRgArbVOs.length];
			System.arraycopy(priRgArbVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setChkFontStyleVO(ChkFontStyleVO chkFontStyleVO) {
		this. chkFontStyleVO = chkFontStyleVO;
	}
	
	public ChkFontStyleVO getChkFontStyleVO() {
		return chkFontStyleVO;
	}
}