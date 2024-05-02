/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddRuLabelHistoryTermChangeDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOAddRuLabelHistoryTermChangeDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Term Change Creatiion 시 Ru Label History Insert
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOAddRuLabelHistoryTermChangeDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOAddRuLabelHistoryTermChangeDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_CNTR_RSTR_USG_HIS (" ).append("\n"); 
		query.append("        CNTR_NO " ).append("\n"); 
		query.append("        ,RSTR_USG_HIS_SEQ" ).append("\n"); 
		query.append("        ,RSTR_USG_UPD_TP_CD " ).append("\n"); 
		query.append("        ,RSTR_USG_TP_CD " ).append("\n"); 
		query.append("        ,RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("        ,CNMV_YR" ).append("\n"); 
		query.append("        ,CNMV_ID_NO" ).append("\n"); 
		query.append("        ,CNMV_SEQ" ).append("\n"); 
		query.append("        ,CNMV_SPLIT_NO" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("        ,CNTR_RMK" ).append("\n"); 
		query.append("        ,EDW_UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("          HIS.CNTR_NO" ).append("\n"); 
		query.append("        , RSTR_USG_HIS_SEQ.NEXTVAL" ).append("\n"); 
		query.append("        , 'D' RSTR_USG_UPD_TP_CD" ).append("\n"); 
		query.append("        , HIS.RSTR_USG_TP_CD" ).append("\n"); 
		query.append("        , HIS.RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("        , MC.CNMV_YR" ).append("\n"); 
		query.append("        , MC.CNMV_ID_NO" ).append("\n"); 
		query.append("        , MC.CNMV_SEQ" ).append("\n"); 
		query.append("        , MC.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("        , @[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE CRE_DT" ).append("\n"); 
		query.append("        , @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE UPD_DT" ).append("\n"); 
		query.append("        , 'Deleted by TLC' CNTR_RMK" ).append("\n"); 
		query.append("        , HIS.EDW_UPD_DT" ).append("\n"); 
		query.append("FROM MST_CNTR_RSTR_USG_HIS HIS" ).append("\n"); 
		query.append("      ,  MST_CONTAINER MC" ).append("\n"); 
		query.append("WHERE HIS.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("AND    (HIS.CNTR_NO, HIS.RSTR_USG_TP_CD, HIS.RSTR_USG_HIS_SEQ)" ).append("\n"); 
		query.append("         IN (" ).append("\n"); 
		query.append("               SELECT SUB.CNTR_NO" ).append("\n"); 
		query.append("                       , SUB.RSTR_USG_TP_CD" ).append("\n"); 
		query.append("                       , DECODE(SUBSTR(MAX(TO_CHAR(SUB.RSTR_USG_HIS_SEQ, '000000000')||TRIM(SUB.RSTR_USG_UPD_TP_CD)), -1), 'D', 9999999, '')" ).append("\n"); 
		query.append("                        ||MAX(SUB.RSTR_USG_HIS_SEQ) RSTR_USG_HIS_SEQ" ).append("\n"); 
		query.append("                FROM MST_CNTR_RSTR_USG_HIS SUB" ).append("\n"); 
		query.append("               WHERE SUB.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                  AND SUB.RSTR_USG_TP_CD IN ('OFHR', 'ASST')" ).append("\n"); 
		query.append("               GROUP BY SUB.CNTR_NO, SUB.RSTR_USG_TP_CD    " ).append("\n"); 
		query.append("             )" ).append("\n"); 

	}
}