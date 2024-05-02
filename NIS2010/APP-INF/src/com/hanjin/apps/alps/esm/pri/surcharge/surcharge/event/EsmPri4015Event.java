/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4003Event.java
*@FileTitle : Surcharge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.06.04 김재연
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.event;

import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.CstPriScgRtVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgPrfVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgRtVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;


/**
 * ESM_PRI_4015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	private PriScgPrfVO priScgPrfVO = null;
	private PriScgRtVO priScgRtVO = null;
	private CstPriScgRtVO cstPriScgRtVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;
	private PriScgPrfVO[] priScgPrfVOs = null;
	private PriScgRtVO[] priScgRtVOs = null;
	private CstPriScgRtVO[] cstPriScgRtVOs = null;
	
	private String backendjobKey = null;
	
	public EsmPri4015Event(){}

	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO){
		this.comBakEndJbVO = comBakEndJbVO;
	}
	public void setComBakEndJbVOS(ComBakEndJbVO[] comBakEndJbVOs){
		if(comBakEndJbVOs != null){
			ComBakEndJbVO[] tmpVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.comBakEndJbVOs = tmpVOs;
		}
	}
	
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}
	public ComBakEndJbVO[] getComBakEndJbVOS(){
		ComBakEndJbVO[] rtnVOs = null;
		if (this.comBakEndJbVOs != null) {
			rtnVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	
	public void setPriScgPrfVO(PriScgPrfVO priScgPrfVO){
		this. priScgPrfVO = priScgPrfVO;
	}

	public void setPriScgPrfVOS(PriScgPrfVO[] priScgPrfVOs){
		if(priScgPrfVOs != null){
			PriScgPrfVO[] tmpVOs = new PriScgPrfVO[priScgPrfVOs.length];
			System.arraycopy(priScgPrfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgPrfVOs = tmpVOs;
		}
	}

	public PriScgPrfVO getPriScgPrfVO(){
		return priScgPrfVO;
	}

	public PriScgPrfVO[] getPriScgPrfVOS(){
		PriScgPrfVO[] rtnVOs = null;
		if (this.priScgPrfVOs != null) {
			rtnVOs = new PriScgPrfVO[priScgPrfVOs.length];
			System.arraycopy(priScgPrfVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setPriScgRtVO(PriScgRtVO priScgRtVO){
		this. priScgRtVO = priScgRtVO;
	}

	public void setPriScgRtVOS(PriScgRtVO[] priScgRtVOs){
		if(priScgRtVOs != null){
			PriScgRtVO[] tmpVOs = new PriScgRtVO[priScgRtVOs.length];
			System.arraycopy(priScgRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgRtVOs = tmpVOs;
		}
	}

	public PriScgRtVO getPriScgRtVO(){
		return priScgRtVO;
	}

	public PriScgRtVO[] getPriScgRtVOS(){
		PriScgRtVO[] rtnVOs = null;
		if (this.priScgRtVOs != null) {
			rtnVOs = new PriScgRtVO[priScgRtVOs.length];
			System.arraycopy(priScgRtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCstPriScgRtVO(CstPriScgRtVO cstPriScgRtVO){
		this. cstPriScgRtVO = cstPriScgRtVO;
	}

	public void setCstPriScgRtVOS(CstPriScgRtVO[] cstPriScgRtVOs){
		if(cstPriScgRtVOs != null){
			CstPriScgRtVO[] tmpVOs = new CstPriScgRtVO[cstPriScgRtVOs.length];
			System.arraycopy(cstPriScgRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cstPriScgRtVOs = tmpVOs;
		}
	}

	public CstPriScgRtVO getCstPriScgRtVO(){
		return cstPriScgRtVO;
	}

	public CstPriScgRtVO[] getCstPriScgRtVOS(){
		CstPriScgRtVO[] rtnVOs = null;
		if (this.cstPriScgRtVOs != null) {
			rtnVOs = new CstPriScgRtVO[cstPriScgRtVOs.length];
			System.arraycopy(cstPriScgRtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	
	/**
	 * @return the backendjobKey
	 */
	public String getBackendjobKey() {
		return backendjobKey;
	}

	/**
	 * @param backendjobKey the backendjobKey to set
	 */
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
	}	
}