/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AdjustmentDBDAOUpdateReeferSpclTpSzMgmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentDBDAOUpdateReeferSpclTpSzMgmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Reefer/Special Type/Size Master]을 [저장]합니다.
	  * </pre>
	  */
	public AdjustmentDBDAOUpdateReeferSpclTpSzMgmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sqm_act_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_dg_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOUpdateReeferSpclTpSzMgmtUSQL").append("\n"); 
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
		query.append("UPDATE SQM_SPCL_CNTR_TP_SZ_MGMT " ).append("\n"); 
		query.append("   SET SQM_ACT_FLG      = DECODE(NVL(@[sqm_act_flg],'N'),1,'Y','N') " ).append("\n"); 
		query.append("      ,SPCL_TGT_CD      = @[spcl_tgt_cd]" ).append("\n"); 
		query.append("      ,SPCL_DG_CGO_FLG  = DECODE(NVL(@[spcl_dg_cgo_flg],'N'),'Y','Y','N') " ).append("\n"); 
		query.append("      ,RD_FLG           = DECODE(NVL(@[rd_flg],'N'),'Y','Y','N')        " ).append("\n"); 
		query.append("      ,UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT           = SYSDATE " ).append("\n"); 
		query.append(" WHERE CNTR_TPSZ_CD     = @[cntr_tpsz_cd]" ).append("\n"); 

	}
}