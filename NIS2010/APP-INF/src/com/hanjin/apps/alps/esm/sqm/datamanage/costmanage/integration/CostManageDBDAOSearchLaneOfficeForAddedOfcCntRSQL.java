/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostManageDBDAOSearchLaneOfficeForAddedOfcCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOSearchLaneOfficeForAddedOfcCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane Office에 사전데이터가 있는지 확인.
	  * 
	  * * History
	  *   2014.07.03 PEJ [CHM-201430932] RHQ Office Mapping에 Office 추가시 Sector Office 반영 요청
	  * </pre>
	  */
	public CostManageDBDAOSearchLaneOfficeForAddedOfcCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOSearchLaneOfficeForAddedOfcCntRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(1),0,'N','Y') AS CNT" ).append("\n"); 
		query.append("     , DECODE(NVL(sum(decode(rgn_ofc_cd, @[rgn_ofc_cd], 1, 0)),0),0,'N','Y') OFC_CNT" ).append("\n"); 
		query.append("#if (${tableNm} == 'OFC')" ).append("\n"); 
		query.append("  FROM SQM_QTA_LANE_OFC" ).append("\n"); 
		query.append("#elseif (${tableNm} == 'COST')" ).append("\n"); 
		query.append("  FROM SQM_QTA_LANE_OFC_COST" ).append("\n"); 
		query.append("#elseif (${tableNm} == 'SECTOR')" ).append("\n"); 
		query.append("  FROM SQM_SCTR_LANE_OFC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("  AND BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("  AND BSE_QTR_CD = DECODE(@[bse_tp_cd],'Y','00',@[bse_qtr_cd])" ).append("\n"); 

	}
}