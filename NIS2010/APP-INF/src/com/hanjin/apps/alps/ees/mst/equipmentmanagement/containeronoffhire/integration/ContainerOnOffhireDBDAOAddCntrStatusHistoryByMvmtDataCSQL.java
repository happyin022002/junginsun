/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddCntrStatusHistoryByMvmtDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOAddCntrStatusHistoryByMvmtDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addCntrStatusHistoryByMvmtData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOAddCntrStatusHistoryByMvmtDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOAddCntrStatusHistoryByMvmtDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_CNTR_STS_HIS (" ).append("\n"); 
		query.append("     CNTR_NO" ).append("\n"); 
		query.append("    ,CNTR_STS_SEQ" ).append("\n"); 
		query.append("    ,CO_CD" ).append("\n"); 
		query.append("    ,YD_CD" ).append("\n"); 
		query.append("    ,LOC_CD" ).append("\n"); 
		query.append("    ,SCC_CD" ).append("\n"); 
		query.append("    ,LCC_CD" ).append("\n"); 
		query.append("    ,ECC_CD" ).append("\n"); 
		query.append("    ,RCC_CD" ).append("\n"); 
		query.append("    ,AGMT_CTY_CD" ).append("\n"); 
		query.append("    ,AGMT_SEQ" ).append("\n"); 
		query.append("    ,CNTR_STS_CD" ).append("\n"); 
		query.append("    ,OFC_CD" ).append("\n"); 
		query.append("    ,CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("    ,PRNR_YD_CD" ).append("\n"); 
		query.append("    ,PRNR_STS_SEQ" ).append("\n"); 
		query.append("    ,CNTR_STS_RMK" ).append("\n"); 
		query.append("    ,CNMV_STS_CD" ).append("\n"); 
		query.append("    ,CNTR_FULL_FLG" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	A.CNTR_NO	," ).append("\n"); 
		query.append("	A.LST_STS_SEQ	AS CNTR_STS_SEQ	," ).append("\n"); 
		query.append("	'H'				AS CO_CD	," ).append("\n"); 
		query.append("	@[org_yd_cd]	AS YD_CD	," ).append("\n"); 
		query.append("	A.LOC_CD	," ).append("\n"); 
		query.append("	A.SCC_CD	," ).append("\n"); 
		query.append("	A.LCC_CD	," ).append("\n"); 
		query.append("	A.ECC_CD	," ).append("\n"); 
		query.append("	A.RCC_CD	," ).append("\n"); 
		query.append("	A.AGMT_CTY_CD	," ).append("\n"); 
		query.append("	A.AGMT_SEQ	," ).append("\n"); 
		query.append("	'LSO'			AS CNTR_STS_CD  ," ).append("\n"); 
		query.append("	@[ofc_cd]		AS OFC_CD	," ).append("\n"); 
		query.append("	TRUNC(TO_DATE(@[cnmv_evnt_dt],'YYYYMMDDHH24MI'))	AS CNTR_STS_EVNT_DT	,		" ).append("\n"); 
		query.append("	( SELECT  /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ A.YD_CD" ).append("\n"); 
		query.append("          FROM    MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("          WHERE   A.CNTR_NO = @[cntr_no] " ).append("\n"); 
		query.append("          AND     A.CNTR_STS_CD = 'LSI'" ).append("\n"); 
		query.append("          AND     ROWNUM =1                        " ).append("\n"); 
		query.append("        )			AS PRNR_YD_CD	," ).append("\n"); 
		query.append("	( SELECT  /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ A.CNTR_STS_SEQ" ).append("\n"); 
		query.append("          FROM    MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("          WHERE   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("          AND     A.CNTR_STS_CD = 'LSI'" ).append("\n"); 
		query.append("          AND     ROWNUM =1" ).append("\n"); 
		query.append("        )			AS PRNR_STS_SEQ ," ).append("\n"); 
		query.append("	'ID_XX'			AS CNTR_STS_RMK ," ).append("\n"); 
		query.append("	'ID'			AS CNMV_STS_CD	," ).append("\n"); 
		query.append("	'Y'				AS CNTR_FULL_FLG," ).append("\n"); 
		query.append("	@[cre_usr_id]	AS CRE_USR_ID	," ).append("\n"); 
		query.append("	SYSDATE			AS CRE_DT		," ).append("\n"); 
		query.append("	@[upd_usr_id]	AS UPD_USR_ID	," ).append("\n"); 
		query.append("	SYSDATE			AS UPD_DT" ).append("\n"); 
		query.append("FROM MST_CONTAINER A" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}