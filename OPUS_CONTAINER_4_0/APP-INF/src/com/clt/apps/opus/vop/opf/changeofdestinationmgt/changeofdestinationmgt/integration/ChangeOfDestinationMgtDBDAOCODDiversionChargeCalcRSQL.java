/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOCODDiversionChargeCalcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOCODDiversionChargeCalcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search DVC
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOCODDiversionChargeCalcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rhnd_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOCODDiversionChargeCalcRSQL").append("\n"); 
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
		query.append("SELECT 'DVC' AS CHG_CD" ).append("\n"); 
		query.append("     , 'USD' AS CURR_CD" ).append("\n"); 
		query.append("     , NVL(O.DVS_FEE_AMT,0) AS CHG_UT_AMT" ).append("\n"); 
		query.append("  FROM MDM_LOCATION M" ).append("\n"); 
		query.append("    ,  OPF_COD_DVS_FEE O" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND M.LOC_CD = SUBSTR( @[cod_rhnd_port_cd], 1, 5 )" ).append("\n"); 
		query.append("   AND M.CONTI_CD = O.CONTI_CD" ).append("\n"); 
		query.append("   AND O.DELT_FLG = 'N'" ).append("\n"); 

	}
}