/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAOmodifyRFSparePartInventoryDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReeferSparePartMgtDBDAOmodifyRFSparePartInventoryDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정
	  * </pre>
	  */
	public ReeferSparePartMgtDBDAOmodifyRFSparePartInventoryDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invt_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spr_chk_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dchg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_spl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration").append("\n"); 
		query.append("FileName : ReeferSparePartMgtDBDAOmodifyRFSparePartInventoryDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_RF_SPR_PRT_INVT SET" ).append("\n"); 
		query.append("SPR_TP_CD   = @[spr_tp_cd]" ).append("\n"); 
		query.append(",LANE_CD   = @[lane_cd]" ).append("\n"); 
		query.append(",SPR_SPL_DT  = TO_DATE(@[spr_spl_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",DCHG_DT     = TO_DATE(@[dchg_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",SPR_CHK_DT  = TO_DATE(@[spr_chk_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",INVT_RMK    = @[invt_rmk]" ).append("\n"); 
		query.append(",UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}