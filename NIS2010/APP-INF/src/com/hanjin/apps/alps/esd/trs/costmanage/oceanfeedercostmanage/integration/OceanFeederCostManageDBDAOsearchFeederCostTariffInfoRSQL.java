/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OceanFeederCostManageDBDAOsearchFeederCostTariffInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.20
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.06.20 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanFeederCostManageDBDAOsearchFeederCostTariffInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFeederCostTariffInfo
	  * </pre>
	  */
	public OceanFeederCostManageDBDAOsearchFeederCostTariffInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.integration").append("\n"); 
		query.append("FileName : OceanFeederCostManageDBDAOsearchFeederCostTariffInfoRSQL").append("\n"); 
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
		query.append("SELECT  A.COST_TRF_STS_CD" ).append("\n"); 
		query.append(",COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03047', A.COST_TRF_STS_CD) COST_TRF_STS_NM" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.EFF_FM_DT, 'YYYY-MM-DD') EFF_FM_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.LOCL_UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append(",(SELECT USR_NM FROM COM_USER" ).append("\n"); 
		query.append("WHERE USR_ID = A.UPD_USR_ID ) UPD_USR_ID" ).append("\n"); 
		query.append(",(SELECT DECODE(GUI_FLG, 'Y', 'Y', 'N', DECODE(TAR_FLG, 'Y', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(--Ocean Cost의 Tariff No.가 가장 최신인지 여부 확인" ).append("\n"); 
		query.append("SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("FROM TRS_FDR_COST_TRF_HDR" ).append("\n"); 
		query.append("WHERE RHQ_CD = TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(@[in_ofc_cd])" ).append("\n"); 
		query.append("AND COST_TRF_NO > @[in_cost_trf_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AS TAR_FLG," ).append("\n"); 
		query.append("(--Ocean Feeder Cost의 Guideline 존재 여부 확인" ).append("\n"); 
		query.append("SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("FROM PRI_TRF_FDR_COST_VER_MAPG" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND FDR_COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AS GUI_FLG" ).append("\n"); 
		query.append("FROM DUAL)) NEXT_TRF_FLG" ).append("\n"); 
		query.append(",A.RHQ_CD" ).append("\n"); 
		query.append("FROM TRS_FDR_COST_TRF_HDR A" ).append("\n"); 
		query.append("WHERE A.COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 

	}
}