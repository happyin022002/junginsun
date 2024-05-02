/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOBkgBlNoVORSQL.java
*@FileTitle : Criteria of Out of Gauge Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.09 이병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Byung Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOBkgBlNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOBkgBlNoVORSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
	}

	public String getSQL(){
		return query.toString();
	}

	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n");
		query.append("FileName : SpecialCargoReceiptDBDAOBkgBlNoVORSQL").append("\n");
		query.append("*/").append("\n");
	}
}