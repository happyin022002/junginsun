/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOSearchLaneMasterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSearchLaneMasterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Lane Master]을 [조회] 합니다.
	  * 2014.01.10 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발(IAS_SCTR_FLG 항목 추가)
	  * </pre>
	  */
	public BasicDataDBDAOSearchLaneMasterListRSQL(){
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
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_lane_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchLaneMasterListRSQL").append("\n"); 
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
		query.append("SELECT BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("	  ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,LANE_DIR_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(IAS_SCTR_FLG,'*'),'Y',1,'N',0,'') AS IAS_SCTR_FLG" ).append("\n"); 
		query.append("      ,DECODE(CSQ_ACT_FLG,'Y',1,0) AS CSQ_ACT_FLG" ).append("\n"); 
		query.append("	  ,BSE_TP_CD" ).append("\n"); 
		query.append(" FROM CSQ_QTA_LANE_MGMT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("	 AND BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("     AND TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("     AND SUB_TRD_CD     = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("     AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_lane_dir_cd} != '' && ${f_lane_dir_cd} != 'All')" ).append("\n"); 
		query.append("     AND LANE_DIR_CD = @[f_lane_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BSE_YR" ).append("\n"); 
		query.append("		,BSE_QTR_CD" ).append("\n"); 
		query.append("		,TRD_CD" ).append("\n"); 
		query.append("      	,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 

	}
}