/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BasicDataDBDAOSearchLaneDirectionChangeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.10
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.06.10 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSearchLaneDirectionChangeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reverse Sailing 노선들의 Direction을 조회.
	  * </pre>
	  */
	public BasicDataDBDAOSearchLaneDirectionChangeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchLaneDirectionChangeListRSQL").append("\n"); 
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
		query.append("SELECT BSE_TP_CD" ).append("\n"); 
		query.append("       ,BSE_YR" ).append("\n"); 
		query.append("       ,BSE_QTR_CD" ).append("\n"); 
		query.append("       ,TRD_CD" ).append("\n"); 
		query.append("       ,RLANE_CD" ).append("\n"); 
		query.append("       ,DIR_CD" ).append("\n"); 
		query.append("       ,CONV_DIR_CD" ).append("\n"); 
		query.append(" FROM SQM_DIR_CONV" ).append("\n"); 
		query.append("WHERE BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("  AND TRD_CD = Decode(@[f_trd_cd],'All',TRD_CD,@[f_trd_cd])" ).append("\n"); 
		query.append("  AND RLANE_CD = Decode(@[f_rlane_cd],'All',RLANE_CD,@[f_rlane_cd])" ).append("\n"); 
		query.append("  AND DIR_CD = Decode(@[f_dir_cd],'All',DIR_CD,@[f_dir_cd])" ).append("\n"); 
		query.append("ORDER BY TRD_CD,RLANE_CD,DIR_CD,CONV_DIR_CD" ).append("\n"); 

	}
}