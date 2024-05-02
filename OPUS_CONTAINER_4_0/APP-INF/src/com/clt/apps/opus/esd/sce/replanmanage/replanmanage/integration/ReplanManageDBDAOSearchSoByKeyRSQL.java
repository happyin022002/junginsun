/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReplanManageDBDAOSearchSoByKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.11
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.04.11 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchSoByKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO Key value 로 Cy/DOOR 및 Rail S/O 를 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchSoByKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration ").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchSoByKeyRSQL").append("\n"); 
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
		query.append("SELECT 'TRS_TRSP_RAIL_BIL_ORD' AS TABLE_NAME," ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_SO_SEQ," ).append("\n"); 
		query.append("TRSP_SO_STS_CD," ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("FM_NOD_CD," ).append("\n"); 
		query.append("TO_NOD_CD," ).append("\n"); 
		query.append("TRSP_BND_CD," ).append("\n"); 
		query.append("NVL(DELT_FLG, 'N') AS DELT_FLG," ).append("\n"); 
		query.append("NVL(TRSP_RQST_BKG_FLG, 'N') AS TRSP_RQST_BKG_FLG," ).append("\n"); 
		query.append("NVL(TRSP_FRST_FLG, 'N') AS TRSP_FRST_FLG" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'TRS_TRSP_SVC_ORD' AS TABLE_NAME," ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_SO_SEQ," ).append("\n"); 
		query.append("TRSP_SO_STS_CD," ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("FM_NOD_CD," ).append("\n"); 
		query.append("TO_NOD_CD," ).append("\n"); 
		query.append("TRSP_BND_CD," ).append("\n"); 
		query.append("NVL(DELT_FLG, 'N') AS DELT_FLG," ).append("\n"); 
		query.append("NVL(TRSP_RQST_BKG_FLG, 'N') AS TRSP_RQST_BKG_FLG," ).append("\n"); 
		query.append("NVL(TRSP_FRST_FLG, 'N') AS TRSP_FRST_FLG" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND TRSP_SO_TP_CD != 'S' -- supplement 가 아닌건" ).append("\n"); 

	}
}