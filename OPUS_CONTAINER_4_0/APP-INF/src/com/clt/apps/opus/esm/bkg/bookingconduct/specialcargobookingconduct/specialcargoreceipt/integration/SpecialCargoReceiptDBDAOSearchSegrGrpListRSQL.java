/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchSegrGrpListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchSegrGrpListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Segration No 콤보 셋팅을 위해 SCG_IMDG_SEGR_GRP 데이터를 조회한다.
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchSegrGrpListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchSegrGrpListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
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
		query.append("SELECT IMDG_SEGR_GRP_NO AS VAL" ).append("\n"); 
		query.append("      ,IMDG_SEGR_GRP_NM AS NAME" ).append("\n"); 
		query.append("  FROM SCG_IMDG_SEGR_GRP" ).append("\n"); 
		query.append(" ORDER BY IMDG_SEGR_GRP_NO" ).append("\n"); 

	}
}