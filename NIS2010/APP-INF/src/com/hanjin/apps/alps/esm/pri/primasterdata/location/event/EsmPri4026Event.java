/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4026Event.java
*@FileTitle : Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.04.28 최성민
* 1.0 Creation
=========================================================
* History
* 2011-07-15 서미진 [CHM-201112248] continent code, sub continent code도 조회 할 수 있도록 변경
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.location.event;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.continent.vo.ContinentVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltCntListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltLocListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltRgnListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltSteListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_4026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_4026HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri4026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSteListVO rsltSteListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltSteListVO[] rsltSteListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltCntListVO rsltCntListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltCntListVO[] rsltCntListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltRgnListVO rsltRgnListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltRgnListVO[] rsltRgnListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltLocListVO rsltLocListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltLocListVO[] rsltLocListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltGrpLocListVO rsltGrpLocListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltGrpLocListVO[] rsltGrpLocListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltCdListVO rsltCobCntListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltCdListVO[] rsltCobCntListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltGrpLocDtlListVO rsltGrpLocDtlListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltGrpLocDtlListVO[] rsltGrpLocDtlListVOs = null;
	
	private ContinentVO continentVO = null;
	
	

	public EsmPri4026Event(){}
	
	public void setRsltSteListVO(RsltSteListVO rsltSteListVO){
		this. rsltSteListVO = rsltSteListVO;
	}

	public void setRsltSteListVOS(RsltSteListVO[] rsltSteListVOs){
		if(rsltSteListVOs != null){
			RsltSteListVO[] tmpVOs = new RsltSteListVO[rsltSteListVOs.length];
			System.arraycopy(rsltSteListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSteListVOs = tmpVOs;
		}
	}

	public void setRsltCntListVO(RsltCntListVO rsltCntListVO){
		this. rsltCntListVO = rsltCntListVO;
	}

	public void setRsltCntListVOS(RsltCntListVO[] rsltCntListVOs){
		if(rsltCntListVOs != null){
			RsltCntListVO[] tmpVOs = new RsltCntListVO[rsltCntListVOs.length];
			System.arraycopy(rsltCntListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltCntListVOs = tmpVOs;
		}
	}

	public void setRsltRgnListVO(RsltRgnListVO rsltRgnListVO){
		this. rsltRgnListVO = rsltRgnListVO;
	}

	public void setRsltRgnListVOS(RsltRgnListVO[] rsltRgnListVOs){
		if(rsltRgnListVOs != null){
			RsltRgnListVO[] tmpVOs = new RsltRgnListVO[rsltRgnListVOs.length];
			System.arraycopy(rsltRgnListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRgnListVOs = tmpVOs;
		}
	}

	public void setRsltLocListVO(RsltLocListVO rsltLocListVO){
		this. rsltLocListVO = rsltLocListVO;
	}

	public void setRsltLocListVOS(RsltLocListVO[] rsltLocListVOs){
		if(rsltLocListVOs != null){
			RsltLocListVO[] tmpVOs = new RsltLocListVO[rsltLocListVOs.length];
			System.arraycopy(rsltLocListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltLocListVOs = tmpVOs;
		}
	}

	public void setRsltGrpLocListVO(RsltGrpLocListVO rsltGrpLocListVO){
		this. rsltGrpLocListVO = rsltGrpLocListVO;
	}

	public void setRsltGrpLocListVOS(RsltGrpLocListVO[] rsltGrpLocListVOs){
		if(rsltGrpLocListVOs != null){
			RsltGrpLocListVO[] tmpVOs = new RsltGrpLocListVO[rsltGrpLocListVOs.length];
			System.arraycopy(rsltGrpLocListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltGrpLocListVOs = tmpVOs;
		}
	}

	public RsltSteListVO getRsltSteListVO(){
		return rsltSteListVO;
	}

	public RsltSteListVO[] getRsltSteListVOS(){
		RsltSteListVO[] rtnVOs = null;
		if (this.rsltSteListVOs != null) {
			rtnVOs = new RsltSteListVO[rsltSteListVOs.length];
			System.arraycopy(rsltSteListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public RsltCntListVO getRsltCntListVO(){
		return rsltCntListVO;
	}

	public RsltCntListVO[] getRsltCntListVOS(){
		RsltCntListVO[] rtnVOs = null;
		if (this.rsltCntListVOs != null) {
			rtnVOs = new RsltCntListVO[rsltCntListVOs.length];
			System.arraycopy(rsltCntListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public RsltRgnListVO getRsltRgnListVO(){
		return rsltRgnListVO;
	}

	public RsltRgnListVO[] getRsltRgnListVOS(){
		RsltRgnListVO[] rtnVOs = null;
		if (this.rsltRgnListVOs != null) {
			rtnVOs = new RsltRgnListVO[rsltRgnListVOs.length];
			System.arraycopy(rsltRgnListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public RsltLocListVO getRsltLocListVO(){
		return rsltLocListVO;
	}

	public RsltLocListVO[] getRsltLocListVOS(){
		RsltLocListVO[] rtnVOs = null;
		if (this.rsltLocListVOs != null) {
			rtnVOs = new RsltLocListVO[rsltLocListVOs.length];
			System.arraycopy(rsltLocListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public RsltGrpLocListVO getRsltGrpLocListVO(){
		return rsltGrpLocListVO;
	}

	public RsltGrpLocListVO[] getRsltGrpLocListVOS(){
		RsltGrpLocListVO[] rtnVOs = null;
		if (this.rsltGrpLocListVOs != null) {
			rtnVOs = new RsltGrpLocListVO[rsltGrpLocListVOs.length];
			System.arraycopy(rsltGrpLocListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	
	public void setRsltCobCntListVOS(RsltCdListVO[] rsltCobCntListVOs){
		if(rsltCobCntListVOs != null){
			RsltCdListVO[] tmpVOs = new RsltCdListVO[rsltCobCntListVOs.length];
			System.arraycopy(rsltCobCntListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltCobCntListVOs = tmpVOs;
		}
	}
	
	public RsltCdListVO[] getRsltCobCntListVOS(){
		RsltCdListVO[] rtnVOs = null;
		if (this.rsltCobCntListVOs != null) {
			rtnVOs = new RsltCdListVO[rsltCobCntListVOs.length];
			System.arraycopy(rsltCobCntListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setRsltCobCntListVO(RsltCdListVO rsltCobCntListVO){
		this. rsltCobCntListVO = rsltCobCntListVO;
	}

	public RsltCdListVO getRsltCobCntListVO(){
		return rsltCobCntListVO;
	}

	public RsltGrpLocDtlListVO getRsltGrpLocDtlListVO() {
		return rsltGrpLocDtlListVO;
	}

	public void setRsltGrpLocDtlListVO(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) {
		this.rsltGrpLocDtlListVO = rsltGrpLocDtlListVO;
	}

	public RsltGrpLocDtlListVO[] getRsltGrpLocDtlListVOs() {
		RsltGrpLocDtlListVO[] rtnVOs = null;
		if (this.rsltGrpLocDtlListVOs != null) {
			rtnVOs = new RsltGrpLocDtlListVO[rsltGrpLocDtlListVOs.length];
			System.arraycopy(rsltGrpLocDtlListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltGrpLocDtlListVOs(RsltGrpLocDtlListVO[] rsltGrpLocDtlListVOs){
		if(rsltGrpLocDtlListVOs != null){
			RsltGrpLocDtlListVO[] tmpVOs = new RsltGrpLocDtlListVO[rsltGrpLocDtlListVOs.length];
			System.arraycopy(rsltGrpLocDtlListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltGrpLocDtlListVOs = tmpVOs;
		}
	}

	public ContinentVO getContinentVO() {
		return continentVO;
	}

	public void setContinentVO(ContinentVO continentVO) {
		this.continentVO = continentVO;
	}
	
}