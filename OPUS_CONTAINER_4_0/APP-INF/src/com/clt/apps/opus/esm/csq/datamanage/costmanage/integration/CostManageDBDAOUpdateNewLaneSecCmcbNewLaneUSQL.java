/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostManageDBDAOUpdateNewLaneSecCmcbNewLaneUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.30
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2014.01.30 이혜민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOUpdateNewLaneSecCmcbNewLaneUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * New Lane Sector CMCB Copy Source Lane을 저장 합니다.
	  * </pre>
	  */
	public CostManageDBDAOUpdateNewLaneSecCmcbNewLaneUSQL(){
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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("src_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOUpdateNewLaneSecCmcbNewLaneUSQL").append("\n"); 
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
		query.append("UPDATE CSQ_SCTR_NEW_LANE" ).append("\n"); 
		query.append("SET  SRC_TRD_CD  = @[trd_cd]" ).append("\n"); 
		query.append("    ,SRC_RLANE_CD= @[src_rlane_cd]" ).append("\n"); 
		query.append("    ,SRC_DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("    ,UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("    ,UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BSE_TP_CD = @[bse_tp_cd]" ).append("\n"); 
		query.append("AND BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("AND BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND RLANE_CD = @[rlane_cd]" ).append("\n"); 

	}
}