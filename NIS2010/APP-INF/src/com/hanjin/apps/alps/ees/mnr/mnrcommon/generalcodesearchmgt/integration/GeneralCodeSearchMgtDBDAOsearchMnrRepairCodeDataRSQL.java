/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchMnrRepairCodeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchMnrRepairCodeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMnrRepairCodeData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchMnrRepairCodeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchkey",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchMnrRepairCodeDataRSQL").append("\n"); 
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
		query.append("SELECT   A.CD_ID" ).append("\n"); 
		query.append("       , A.CD_DESC" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   MCR.TO_RLT_CD AS CD_ID" ).append("\n"); 
		query.append("                  , MCOD.EQ_CEDEX_OTR_CD_NM AS CD_DESC" ).append("\n"); 
		query.append("           FROM     MNR_CD_RLT MCR" ).append("\n"); 
		query.append("                  , MNR_CEDEX_OTR_CD MCOD" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      MCR.EQ_CEDEX_RLT_TP_CD = 'CTR'" ).append("\n"); 
		query.append("           AND      MCR.FM_RLT_CD = @[searchkey]  " ).append("\n"); 
		query.append("           AND      MCOD.EQ_CEDEX_OTR_TP_CD = 'RPR'" ).append("\n"); 
		query.append("           AND      MCR.TO_RLT_CD = MCOD.EQ_CEDEX_OTR_CD" ).append("\n"); 
		query.append("           UNION ALL" ).append("\n"); 
		query.append("           SELECT   ' ' AS CD_ID" ).append("\n"); 
		query.append("                  , ' ' AS CD_DESC" ).append("\n"); 
		query.append("           FROM     DUAL" ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append("ORDER BY CD_ID" ).append("\n"); 

	}
}