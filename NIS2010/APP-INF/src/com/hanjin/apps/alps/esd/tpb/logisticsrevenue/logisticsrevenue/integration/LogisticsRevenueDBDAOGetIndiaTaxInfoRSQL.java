/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LogisticsRevenueDBDAOGetIndiaTaxInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LogisticsRevenueDBDAOGetIndiaTaxInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * India Tax 정보
	  * </pre>
	  */
	public LogisticsRevenueDBDAOGetIndiaTaxInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.integration").append("\n"); 
		query.append("FileName : LogisticsRevenueDBDAOGetIndiaTaxInfoRSQL").append("\n"); 
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
		query.append("SELECT IDA_TAX_SEQ" ).append("\n"); 
		query.append("      ,EXPN_TAX" ).append("\n"); 
		query.append("      ,EDU_TAX" ).append("\n"); 
		query.append("      ,HIGH_EDU_TAX" ).append("\n"); 
		query.append("      ,LOCL_TAX_RT" ).append("\n"); 
		query.append("      ,N2ND_LOCL_TAX_RT" ).append("\n"); 
		query.append("  FROM TPB_IDA_TAX" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND IDA_TAX_SEQ = ( SELECT MAX(IDA_TAX_SEQ) FROM TPB_IDA_TAX WHERE EFF_DT < SYSDATE AND NVL(DELT_FLG,'N') = 'N')" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND Exists ( SELECT 'X' FROM  MDM_ORGANIZATION B, MDM_LOCATION C" ).append("\n"); 
		query.append("                WHERE B.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                AND B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("                AND C.CNT_CD = 'IN' )" ).append("\n"); 

	}
}