/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim1023Event.java
 *@FileTitle : Location M/B by Logistics-Wise
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.20 박광석
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.QuantityByTypeSizeVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UI_CIM_1023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_CIM_1023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Myeong Jong Beum
 * @see UI_CIM_1023HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCim1023Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String cntrTpszCd = "";

	private String locLevel = "";

	private String locCD = "";

	/** Table Value Object 조회 조건 및 단건 처리 */
	private QuantityByTypeSizeVO qUantityByTypeSizeVO = null;

	/** Table Value Object Multi Data 처리 */
	private QuantityByTypeSizeVO[] qUantityByTypeSizeVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private MBSearchOptionInGereralVO mBSearchOptionInGereralVO = null;

	/** Table Value Object Multi Data 처리 */
	private MBSearchOptionInGereralVO[] mBSearchOptionInGereralVOs = null;

	public EesCim1023Event() {
	}

	public void setQuantityByTypeSizeVO(
			QuantityByTypeSizeVO qUantityByTypeSizeVO) {
		this.qUantityByTypeSizeVO = qUantityByTypeSizeVO;
	}

	public void setQuantityByTypeSizeVOS(
			QuantityByTypeSizeVO[] qUantityByTypeSizeVOs) {
		if (qUantityByTypeSizeVOs != null) {
			QuantityByTypeSizeVO[] tmpVOs = new QuantityByTypeSizeVO[qUantityByTypeSizeVOs.length];
			System.arraycopy(qUantityByTypeSizeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.qUantityByTypeSizeVOs = tmpVOs;
		}
	}

	public QuantityByTypeSizeVO getQuantityByTypeSizeVO() {
		return qUantityByTypeSizeVO;
	}

	public QuantityByTypeSizeVO[] getQuantityByTypeSizeVOS() {
		QuantityByTypeSizeVO[] tmpVOs = null;
		if (this.qUantityByTypeSizeVOs != null) {
			tmpVOs = new QuantityByTypeSizeVO[qUantityByTypeSizeVOs.length];
			System.arraycopy(qUantityByTypeSizeVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setMBSearchOptionInGereralVO(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) {
		this.mBSearchOptionInGereralVO = mBSearchOptionInGereralVO;
	}

	public void setMBSearchOptionInGereralVOS(
			MBSearchOptionInGereralVO[] mBSearchOptionInGereralVOs) {
		if (mBSearchOptionInGereralVOs != null) {
			MBSearchOptionInGereralVO[] tmpVOs = new MBSearchOptionInGereralVO[mBSearchOptionInGereralVOs.length];
			System.arraycopy(mBSearchOptionInGereralVOs, 0, tmpVOs, 0,
					tmpVOs.length);
			this.mBSearchOptionInGereralVOs = tmpVOs;
		}
		// this. mBSearchOptionInGereralVOs = mBSearchOptionInGereralVOs;
	}

	public MBSearchOptionInGereralVO getMBSearchOptionInGereralVO() {
		return mBSearchOptionInGereralVO;
	}

	public MBSearchOptionInGereralVO[] getMBSearchOptionInGereralVOS() {
		MBSearchOptionInGereralVO[] tmpVOs = null;
		if (this.mBSearchOptionInGereralVOs != null) {
			tmpVOs = new MBSearchOptionInGereralVO[mBSearchOptionInGereralVOs.length];
			System.arraycopy(mBSearchOptionInGereralVOs, 0, tmpVOs, 0,
					tmpVOs.length);
		}
		return tmpVOs;
	}

	/** Table Value Object 조회 조건 및 단건 처리 */
	private TypeSizeSequenceVO typeSizeSequenceVO = null;

	/** Table Value Object Multi Data 처리 */
	private TypeSizeSequenceVO[] typeSizeSequenceVOs = null;

	public void setTypeSizeSequenceVO(TypeSizeSequenceVO typeSizeSequenceVO) {
		this.typeSizeSequenceVO = typeSizeSequenceVO;
	}

	public void setTypeSizeSequenceVOS(TypeSizeSequenceVO[] typeSizeSequenceVOs) {
		if (typeSizeSequenceVOs != null) {
			TypeSizeSequenceVO[] tmpVOs = new TypeSizeSequenceVO[typeSizeSequenceVOs.length];
			System.arraycopy(typeSizeSequenceVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.typeSizeSequenceVOs = tmpVOs;
		}
	}

	public TypeSizeSequenceVO getTypeSizeSequenceVO() {
		return typeSizeSequenceVO;
	}

	public TypeSizeSequenceVO[] getTypeSizeSequenceVOS() {
		TypeSizeSequenceVO[] tmpVOs = null;
		if (this.typeSizeSequenceVOs != null) {
			tmpVOs = new TypeSizeSequenceVO[typeSizeSequenceVOs.length];
			System.arraycopy(typeSizeSequenceVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public String getCntrTpszCd() {
		return cntrTpszCd;
	}

	public void setLocLevel(String locLevel) {
		this.locLevel = locLevel;
	}

	public void setLocCD(String locCD) {
		this.locCD = locCD;
	}

	public String getLocLevel() {
		return locLevel;
	}

	public String getLocCD() {
		return locCD;
	}
}