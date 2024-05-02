/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddCntrStatusHistorysByLostFoundDataCSQL.java
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

public class ContainerOnOffhireDBDAOAddCntrStatusHistorysByLostFoundDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCntrStatusHistorysByLostFoundData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOAddCntrStatusHistorysByLostFoundDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_onh_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_flg",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOAddCntrStatusHistorysByLostFoundDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" CNTR_NO" ).append("\n"); 
		query.append(",CNTR_STS_SEQ" ).append("\n"); 
		query.append(",CO_CD" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",SCC_CD" ).append("\n"); 
		query.append(",LCC_CD" ).append("\n"); 
		query.append(",ECC_CD" ).append("\n"); 
		query.append(",RCC_CD" ).append("\n"); 
		query.append(",AGMT_CTY_CD" ).append("\n"); 
		query.append(",AGMT_SEQ" ).append("\n"); 
		query.append(",CNTR_STS_CD" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append(",PRNR_YD_CD" ).append("\n"); 
		query.append(",PRNR_STS_SEQ" ).append("\n"); 
		query.append(",CNTR_STS_RMK" ).append("\n"); 
		query.append(",CNMV_STS_CD" ).append("\n"); 
		query.append(",CNTR_FULL_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  @[cntr_no]				AS CNTR_NO" ).append("\n"); 
		query.append(", MST_CNTR_STS_HIS_SEQ.NEXTVAL		AS CNTR_STS_SEQ" ).append("\n"); 
		query.append(",'H'						AS CO_CD" ).append("\n"); 
		query.append(", @[h_onh_yd_cd]					AS YD_CD" ).append("\n"); 
		query.append(", SUBSTR(@[h_onh_yd_cd], 1, 5)		AS LOC_CD" ).append("\n"); 
		query.append(", D.SCC_CD					AS SCC_CD" ).append("\n"); 
		query.append(", D.LCC_CD					AS LCC_CD" ).append("\n"); 
		query.append(", D.ECC_CD					AS ECC_CD" ).append("\n"); 
		query.append(", D.RCC_CD					AS RCC_CD" ).append("\n"); 
		query.append(", B.AGMT_CTY_CD				AS AGMT_CTY_CD" ).append("\n"); 
		query.append(", B.AGMT_SEQ				AS AGMT_SEQ" ).append("\n"); 
		query.append(", @[h_cntr_sts_cd]		AS CNTR_STS_CD" ).append("\n"); 
		query.append(", @[ofc_cd]					AS OFC_CD" ).append("\n"); 
		query.append(",TO_DATE(@[h_cnmv_evnt_dt],'YYYYMMDD')				AS CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append(",DECODE(@[h_cntr_sts_cd],'FND',C.PRNR_YD_CD   ,NULL)    AS PRNR_YD_CD" ).append("\n"); 
		query.append(",DECODE(@[h_cntr_sts_cd],'FND',C.PRNR_STS_SEQ ,NULL)    AS PRNR_STS_SEQ" ).append("\n"); 
		query.append(",@[cntr_rmk]		        AS CNTR_STS_RMK" ).append("\n"); 
		query.append(",@[cnmv_sts_cd]		        AS CNMV_STS_CD" ).append("\n"); 
		query.append(",DECODE(@[full_flg],'F','Y','M','N',NULL) AS CNTR_FULL_FLG" ).append("\n"); 
		query.append(",@[cre_usr_id]		        AS CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE					AS CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id]				AS UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE					AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL A, " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT AGMT_CTY_CD, AGMT_SEQ   " ).append("\n"); 
		query.append(" FROM MST_CONTAINER WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	 MAX(A.YD_CD)      			AS PRNR_YD_CD," ).append("\n"); 
		query.append("	 MAX(A.CNTR_STS_SEQ)    	AS PRNR_STS_SEQ " ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("				H.CNTR_STS_SEQ," ).append("\n"); 
		query.append("				H.YD_CD" ).append("\n"); 
		query.append("		FROM MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("		WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("		AND CNTR_STS_CD = 'LST'" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("		UNION " ).append("\n"); 
		query.append("		SELECT NULL CNTR_STS_SEQ, NULL YD_CD  FROM DUAL" ).append("\n"); 
		query.append("	) A" ).append("\n"); 
		query.append(") C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.SCC_CD," ).append("\n"); 
		query.append("       B.ECC_CD," ).append("\n"); 
		query.append("       B.LCC_CD," ).append("\n"); 
		query.append("       B.RCC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A," ).append("\n"); 
		query.append("     MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = SUBSTR(@[h_onh_yd_cd], 1, 5)" ).append("\n"); 
		query.append("AND   A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append(") D" ).append("\n"); 

	}
}