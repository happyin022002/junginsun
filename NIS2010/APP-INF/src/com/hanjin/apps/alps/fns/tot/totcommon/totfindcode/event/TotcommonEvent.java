/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TotcommonEvent.java
*@FileTitle : TOTCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.25 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.event;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.BackEndJobVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.MdmLaneVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeInfoVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TotStlClzVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

/**
 * TOTCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  TOTCommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see TOTCommonHTMLAction 참조
 * @since J2EE 1.6
 */

public class TotcommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotCodeParamVO totCodeParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TotCodeParamVO[] totCodeParamVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotCodeInfoVO totCodeInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TotCodeInfoVO[] totCodeInfoVOs = null;

	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotStlClzVO totStlClzVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TotStlClzVO[] totStlClzVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslVO vslVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VslVO[] vslVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmLaneVO mdmLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmLaneVO[] mdmLaneVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskVslPortSkdVO vskVslPortSkdVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BackEndJobVO backEndJobVO = null;
	
	public VskVslPortSkdVO getVskVslPortSkdVO() {
		return vskVslPortSkdVO;
	}

	public void setVskVslPortSkdVO(VskVslPortSkdVO vskVslPortSkdVO) {
		this.vskVslPortSkdVO = vskVslPortSkdVO;
	}

	private String stlYr = null;
	
	public TotcommonEvent(){}
	
	public void setTotStlClzVO(TotStlClzVO totStlClzVO){
		this. totStlClzVO = totStlClzVO;
	}

	public void setTotStlClzVOS(TotStlClzVO[] totStlClzVOs){
		if (totStlClzVOs != null) {
			TotStlClzVO[] tmpVOs = new TotStlClzVO[totStlClzVOs.length];
			System.arraycopy(totStlClzVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.totStlClzVOs = tmpVOs;
		}
	}
	public void setStlYr(String stlYr){
		this. stlYr = stlYr;
	}

	public void setVslVO(VslVO vslVO){
		this. vslVO = vslVO;
	}

	public void setVslVOS(VslVO[] vslVOs){
		if (vslVOs != null) {
			VslVO[] tmpVOs = new VslVO[vslVOs.length];
			System.arraycopy(vslVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vslVOs = tmpVOs;
		}
	}

	public TotStlClzVO getTotStlClzVO(){
		return totStlClzVO;
	}

	public TotStlClzVO[] getTotStlClzVOS(){
		TotStlClzVO[] rtnVOs = null;
		if (this.totStlClzVOs != null) {
			rtnVOs = new TotStlClzVO[totStlClzVOs.length];
			System.arraycopy(totStlClzVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public String getStlYr(){
		return stlYr;
	}

	public VslVO getVslVO(){
		return vslVO;
	}

	public VslVO[] getVslVOS(){
		VslVO[] rtnVOs = null;
		if (this.vslVOs != null) {
			rtnVOs = new VslVO[vslVOs.length];
			System.arraycopy(vslVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public TotCodeParamVO getTotCodeParamVO() {
		return totCodeParamVO;
	}

	public void setTotCodeParamVO(TotCodeParamVO totCodeParamVO) {
		this.totCodeParamVO = totCodeParamVO;
	}

	public TotCodeParamVO[] getTotCodeParamVOs() {
		TotCodeParamVO[] rtnVOs = null;
		if (this.totCodeParamVOs != null) {
			rtnVOs = new TotCodeParamVO[totCodeParamVOs.length];
			System.arraycopy(totCodeParamVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setTotCodeParamVOs(TotCodeParamVO[] totCodeParamVOs) {
		if (totCodeParamVOs != null) {
			TotCodeParamVO[] tmpVOs = new TotCodeParamVO[totCodeParamVOs.length];
			System.arraycopy(totCodeParamVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.totCodeParamVOs = tmpVOs;
		}
	}

	public TotCodeInfoVO getTotCodeInfoVO() {
		return totCodeInfoVO;
	}

	public void setTotCodeInfoVO(TotCodeInfoVO totCodeInfoVO) {
		this.totCodeInfoVO = totCodeInfoVO;
	}

	public TotCodeInfoVO[] getTotCodeInfoVOs() {
		TotCodeInfoVO[] rtnVOs = null;
		if (this.totCodeInfoVOs != null) {
			rtnVOs = new TotCodeInfoVO[totCodeInfoVOs.length];
			System.arraycopy(totCodeInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setTotCodeInfoVOs(TotCodeInfoVO[] totCodeInfoVOs) {
		if (totCodeInfoVOs != null) {
			TotCodeInfoVO[] tmpVOs = new TotCodeInfoVO[totCodeInfoVOs.length];
			System.arraycopy(totCodeInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.totCodeInfoVOs = tmpVOs;
		}
	}

	public MdmLaneVO getMdmLaneVO() {
		return mdmLaneVO;
	}

	public void setMdmLaneVO(MdmLaneVO mdmLaneVO) {
		this.mdmLaneVO = mdmLaneVO;
	}

	public MdmLaneVO[] getMdmLaneVOs() {
		MdmLaneVO[] rtnVOs = null;
		if (this.mdmLaneVOs != null) {
			rtnVOs = new MdmLaneVO[mdmLaneVOs.length];
			System.arraycopy(mdmLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setMdmLaneVOs(MdmLaneVO[] mdmLaneVOs) {
		if (mdmLaneVOs != null) {
			MdmLaneVO[] tmpVOs = new MdmLaneVO[mdmLaneVOs.length];
			System.arraycopy(mdmLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmLaneVOs = tmpVOs;
		}
	}


	public BackEndJobVO getBackEndJobVO() {
		return backEndJobVO;
	}


	public void setBackEndJobVO(BackEndJobVO backEndJobVO) {
		this.backEndJobVO = backEndJobVO;
	}
}