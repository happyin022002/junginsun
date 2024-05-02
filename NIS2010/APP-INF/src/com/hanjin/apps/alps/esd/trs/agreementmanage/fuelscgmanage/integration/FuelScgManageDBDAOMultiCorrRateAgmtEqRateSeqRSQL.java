/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FuelScgManageDBDAOMultiCorrRateAgmtEqRateSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.08
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.05.08 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FuelScgManageDBDAOMultiCorrRateAgmtEqRateSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Surcharge Rate Seqence 채번
	  * </pre>
	  */
	public FuelScgManageDBDAOMultiCorrRateAgmtEqRateSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration ").append("\n"); 
		query.append("FileName : FuelScgManageDBDAOMultiCorrRateAgmtEqRateSeqRSQL").append("\n"); 
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
		query.append("SELECT TRS_AGMT_SCG_RT_SEQ1.NEXTVAL AS EQ_RT_SEQ" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}