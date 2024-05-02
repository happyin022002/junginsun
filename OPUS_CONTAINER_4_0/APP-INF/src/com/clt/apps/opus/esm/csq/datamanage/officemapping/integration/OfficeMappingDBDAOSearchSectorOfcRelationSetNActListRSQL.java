/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OfficeMappingDBDAOSearchSectorOfcRelationSetNActListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.05
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2014.02.05 이혜민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOSearchSectorOfcRelationSetNActListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sector Office Relation Creation시 active된 pol-pod pair가 하나도 없는 lane/bound를 조회한다.
	  * </pre>
	  */
	public OfficeMappingDBDAOSearchSectorOfcRelationSetNActListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.officemapping.integration ").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOSearchSectorOfcRelationSetNActListRSQL").append("\n"); 
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
		query.append("SELECT RLANE_CD||'/'||DIR_CD N_ACT_LIST " ).append("\n"); 
		query.append("  FROM  CSQ_SCTR_PAIR_MGMT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("GROUP BY BSE_TP_CD,BSE_YR,BSE_QTR_CD,RLANE_CD,DIR_CD " ).append("\n"); 
		query.append("HAVING SUM(DECODE(CSQ_ACT_FLG, 'N', 0, 'Y', 1)) = 0" ).append("\n"); 
		query.append("ORDER BY RLANE_CD,DIR_CD" ).append("\n"); 

	}
}