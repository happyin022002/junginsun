/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OfficeMappingDBDAOSearchAddedNewLaneListCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.12
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.06.12 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOSearchAddedNewLaneListCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * new lane에 속한 Office에 CMCB정보가 생성되었는지 확인
	  * </pre>
	  */
	public OfficeMappingDBDAOSearchAddedNewLaneListCntRSQL(){
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.officemapping.integration ").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOSearchAddedNewLaneListCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append(" FROM CSQ_QTA_NEW_LANE LANE" ).append("\n"); 
		query.append("     ,CSQ_QTA_NEW_LANE_OFC_COST CO" ).append("\n"); 
		query.append("WHERE LANE.BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("  AND LANE.BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("  AND LANE.BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("  AND LANE.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("  AND LANE.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("  AND LANE.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("  AND LANE.BSE_TP_CD  = CO.BSE_TP_CD" ).append("\n"); 
		query.append("  AND LANE.BSE_YR     = CO.BSE_YR" ).append("\n"); 
		query.append("  AND LANE.BSE_QTR_CD = CO.BSE_QTR_CD" ).append("\n"); 
		query.append("  AND LANE.TRD_CD     = CO.TRD_CD" ).append("\n"); 
		query.append("  AND LANE.RLANE_CD   = CO.RLANE_CD" ).append("\n"); 
		query.append("  AND LANE.DIR_CD     = CO.DIR_CD" ).append("\n"); 

	}
}