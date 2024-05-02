/**
 * 
 */
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;

import java.util.HashMap;
import java.util.List;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * @author Administrator
 *
 */
public class CargoFlowMapSetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	/* Column Info */
	private List<QuantityByTypeSizeVO> quantitybytypesizevo = null;

	/* Column Info */
	private List<QuantityByTypeSizeVO> quantitybytypesizevo2 = null;
	
	public CargoFlowMapSetVO() {}
	


	/**
	 * @return the quantitybytypesizevo
	 */
	public List<QuantityByTypeSizeVO> getQuantitybytypesizevo() {
		return quantitybytypesizevo;
	}



	/**
	 * @param quantitybytypesizevo the quantitybytypesizevo to set
	 */
	public void setQuantitybytypesizevo(
			List<QuantityByTypeSizeVO> quantitybytypesizevo) {
		this.quantitybytypesizevo = quantitybytypesizevo;
	}



	/**
	 * @return the quantitybytypesizevo2
	 */
	public List<QuantityByTypeSizeVO> getQuantitybytypesizevo2() {
		return quantitybytypesizevo2;
	}



	/**
	 * @param quantitybytypesizevo2 the quantitybytypesizevo2 to set
	 */
	public void setQuantitybytypesizevo2(
			List<QuantityByTypeSizeVO> quantitybytypesizevo2) {
		this.quantitybytypesizevo2 = quantitybytypesizevo2;
	}



	/* (non-Javadoc)
	 * @see com.hanjin.framework.component.common.AbstractValueObject#getColumnValues()
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hanjin.framework.component.common.AbstractValueObject#getFieldNames()
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
