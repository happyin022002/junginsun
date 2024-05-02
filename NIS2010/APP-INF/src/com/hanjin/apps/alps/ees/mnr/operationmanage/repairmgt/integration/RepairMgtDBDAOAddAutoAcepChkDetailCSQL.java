/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : RepairMgtDBDAOAddAutoAcepChkDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOAddAutoAcepChkDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACEP Check List Detail Auto Insert
	  * </pre>
	  */
	public RepairMgtDBDAOAddAutoAcepChkDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acep_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOAddAutoAcepChkDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_ACEP_CHK_LIST_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("         ACEP_SEQ" ).append("\n"); 
		query.append("       , ACEP_DTL_SEQ" ).append("\n"); 
		query.append("       , INSP_ITM_NO" ).append("\n"); 
		query.append("       , INSP_ITM_NM" ).append("\n"); 
		query.append("       , INSP_CHK_FLG" ).append("\n"); 
		query.append("       , CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   @[acep_seq] AS ACEP_SEQ" ).append("\n"); 
		query.append("       , ITM.HRD_CDG_ID_SEQ AS ACEP_DTL_SEQ" ).append("\n"); 
		query.append("       , ITM.ATTR_CTNT1 AS INSP_ITM_NO" ).append("\n"); 
		query.append("       , ITM.ATTR_CTNT2 AS INSP_ITM_NM" ).append("\n"); 
		query.append("       , 'Y' AS INSP_CHK_FLG" ).append("\n"); 
		query.append("       , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("       , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM     MNR_HRD_CDG_CTNT ITM" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      ITM.HRD_CDG_ID = 'ACEP_INSP_ITM'" ).append("\n"); 
		query.append("AND      ITM.ATTR_CTNT10 = 'Y'" ).append("\n"); 
		query.append("AND      EXISTS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   '1'" ).append("\n"); 
		query.append("           FROM     MNR_ACEP_CHK_LIST_HDR AM" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      AM.ACEP_SEQ = @[acep_seq]" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER(ITM.ATTR_CTNT9)" ).append("\n"); 

	}
}