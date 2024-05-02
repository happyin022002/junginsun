/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOUpdateCfmQtaStatusLaneUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOUpdateCfmQtaStatusLaneUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.12.10 PEJ [CHM-201328059] QTA Edit에서 Office Add 했을때 추가한 노선의 상태를 'M'으로 변경한다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOUpdateCfmQtaStatusLaneUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOUpdateCfmQtaStatusLaneUSQL").append("\n"); 
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
		query.append("UPDATE CSQ_CFM_QTA " ).append("\n"); 
		query.append("   SET CSQ_CNG_TP_CD = 'M'" ).append("\n"); 
		query.append("      ,UPD_USR_ID    = @[f_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT        = SYSDATE " ).append("\n"); 
		query.append(" WHERE BSE_TP_CD                  = 'Q'" ).append("\n"); 
		query.append("   AND BSE_YR                     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD                 = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("   AND OFC_VW_CD                  = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("   AND QTA_TGT_CD                 = 'D'" ).append("\n"); 
		query.append("   AND SUBSTR(QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("   AND TRD_CD                     = @[f_trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD                   = @[f_rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD                     = @[f_dir_cd]" ).append("\n"); 
		query.append("   AND CSQ_CNG_TP_CD              <>'A'" ).append("\n"); 

	}
}