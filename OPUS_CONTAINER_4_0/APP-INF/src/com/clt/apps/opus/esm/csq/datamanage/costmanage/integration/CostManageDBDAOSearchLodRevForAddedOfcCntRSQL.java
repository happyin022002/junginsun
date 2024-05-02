/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostManageDBDAOSearchLodRevForAddedOfcCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOSearchLodRevForAddedOfcCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sector쪽 Planning 데이터는 존재하면서 Freezing 하기 전인지 확인
	  * </pre>
	  */
	public CostManageDBDAOSearchLodRevForAddedOfcCntRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOSearchLodRevForAddedOfcCntRSQL").append("\n"); 
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
		query.append("SELECT NVL((SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("          FROM CSQ_SCTR_LOD_REV" ).append("\n"); 
		query.append("         WHERE BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("           AND BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("           AND BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("           AND ROWNUM     = 1" ).append("\n"); 
		query.append("        ), 0) AS CNF_CNT" ).append("\n"); 
		query.append("       ,NVL((SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("          FROM CSQ_SCTR_CFM_QTA" ).append("\n"); 
		query.append("         WHERE BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("           AND BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("           AND BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("           AND ROWNUM     = 1" ).append("\n"); 
		query.append("        ), 0) AS FRZ_CNT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}