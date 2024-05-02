/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostBatchDBDAOInsertFeederBatchQueueCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costbatch.costbatch.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostBatchDBDAOInsertFeederBatchQueueCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.21 변종건 [CHM-201217633] Ocean Feeder Cost Batch
	  * </pre>
	  */
	public CostBatchDBDAOInsertFeederBatchQueueCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costbatch.costbatch.integration ").append("\n"); 
		query.append("FileName : CostBatchDBDAOInsertFeederBatchQueueCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_COST_TRF_BAT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("COST_TRF_BAT_SEQ" ).append("\n"); 
		query.append(", PGM_NO" ).append("\n"); 
		query.append(", COST_TRF_BAT_ID" ).append("\n"); 
		query.append(", BAT_PROG_STS_CD" ).append("\n"); 
		query.append(", BAT_PROG_KNT" ).append("\n"); 
		query.append(", BAT_PROG_TTL_KNT" ).append("\n"); 
		query.append(", COST_TRF_BAT_ERR_VAL" ).append("\n"); 
		query.append(", COST_TRF_BAT_ERR_DESC" ).append("\n"); 
		query.append(", BAT_ST_DT" ).append("\n"); 
		query.append(", BAT_END_DT" ).append("\n"); 
		query.append(", RHQ_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("TRS_COST_TRF_BAT_SEQ1.NEXTVAL" ).append("\n"); 
		query.append(", 'ESD_TRS_B005'" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", 'W'" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", @[rhq_cd]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[usr_ofc_cd]" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}