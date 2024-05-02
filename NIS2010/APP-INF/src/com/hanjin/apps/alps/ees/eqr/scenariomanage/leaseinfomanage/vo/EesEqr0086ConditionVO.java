/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0086ConditionVO.java
*@FileTitle : EesEqr0086ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : chae Chang Ho
*@LastVersion : 1.0
* 2009.08.03  chae Chang Ho 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0086ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0086ConditionVO> models = new ArrayList<EesEqr0086ConditionVO>();
	
       /* Column Info */
   	private String yyyyww = null;
	
    /* Column Info */
   	private String seq = null;
   	
    /* Column Info */
   	private String loc = null;
   	
    /* Column Info */
   	private String loctype = null;
   	
    /* Column Info */
   	private String tpsz = null;
   	
    /* Column Info */
   	private String tpsztype = null;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	@SuppressWarnings("unused")
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	@SuppressWarnings("unused")
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0086ConditionVO() {}

	/* (non-Javadoc)
	 * @see com.hanjin.framework.component.common.AbstractValueObject#getColumnValues()
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hanjin.framework.component.common.AbstractValueObject#getFieldNames()
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		return null;
	}
	
	
	/**
	 * @return the yyyyww
	 */
	public String getYyyyww() {
		return yyyyww;
	}

	/**
	 * @param yyyyww the yyyyww to set
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}

	/**
	 * @return the seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}

	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}

	/**
	 * @return the loctype
	 */
	public String getLoctype() {
		return loctype;
	}

	/**
	 * @param loctype the loctype to set
	 */
	public void setLoctype(String loctype) {
		this.loctype = loctype;
	}

	/**
	 * @return the tpsz
	 */
	public String getTpsz() {
		return tpsz;
	}

	/**
	 * @param tpsz the tpsz to set
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}

	/**
	 * @return the tpsztype
	 */
	public String getTpsztype() {
		return tpsztype;
	}

	/**
	 * @param tpsztype the tpsztype to set
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}

	
	/**
	 * VO 배열을 반환
	 * @return EesEqr0086ConditionVO[]
	 */
	public EesEqr0086ConditionVO[] getEesEqr0086ConditionVOs(){
		EesEqr0086ConditionVO[] vos = (EesEqr0086ConditionVO[])models.toArray(new EesEqr0086ConditionVO[models.size()]);
		return vos;
	}

}
