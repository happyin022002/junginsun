/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AsiaInlandCostManageDBDAOConfirmInlandCostPreVerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.11
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.10.11 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaInlandCostManageDBDAOConfirmInlandCostPreVerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * confirmInlandCostPreVer
	  * </pre>
	  */
	public AsiaInlandCostManageDBDAOConfirmInlandCostPreVerUSQL(){
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
		params.put("in_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration").append("\n"); 
		query.append("FileName : AsiaInlandCostManageDBDAOConfirmInlandCostPreVerUSQL").append("\n"); 
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
		query.append("UPDATE AOC_CHN_INLND_TRF_HDR" ).append("\n"); 
		query.append("   SET EFF_TO_DT = TO_DATE(TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])-1, 'YYYYMMDD'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("      ,UPD_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append(" WHERE COST_TRF_NO IN (" ).append("\n"); 
		query.append("                       SELECT MAX(COST_TRF_NO)" ).append("\n"); 
		query.append("                         FROM AOC_CHN_INLND_TRF_HDR" ).append("\n"); 
		query.append("                        WHERE CNT_CD = @[in_cnt_cd]" ).append("\n"); 
		query.append("                          AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                          AND COST_TRF_STS_CD = 'C'" ).append("\n"); 
		query.append("                          AND COST_TRF_NO <> @[in_cost_trf_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}