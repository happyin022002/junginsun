/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationTypeMgtDBDAOCalculationTypeParmVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationTypeMgtDBDAOCalculationTypeParmVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CalculationTypeParmVO update
	  * </pre>
	  */
	public DMTCalculationTypeMgtDBDAOCalculationTypeParmVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_calc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration").append("\n"); 
		query.append("FileName : DMTCalculationTypeMgtDBDAOCalculationTypeParmVOUSQL").append("\n"); 
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
		query.append("UPDATE DMT_CALC_TP" ).append("\n"); 
		query.append("SET CNT_CD	    =	NVL(@[cnt_cd],' ')" ).append("\n"); 
		query.append("    , RGN_CD	=	NVL(@[rgn_cd],' ')" ).append("\n"); 
		query.append("    , STE_CD	=	NVL(@[ste_cd],' ')" ).append("\n"); 
		query.append("    , LOC_CD	=	NVL(@[loc_cd],' ')" ).append("\n"); 
		query.append("    , IO_BND_CD	=	NVL(@[io_bnd_cd],' ')" ).append("\n"); 
		query.append("    , DMDT_CALC_TP_CD	=	NVL(@[dmdt_calc_tp_cd],' ')" ).append("\n"); 
		query.append("    , EFF_DT	=	TO_DATE(@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("    , EXP_DT	=	TO_DATE(@[exp_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("    , UPD_USR_ID	=	@[upd_usr_id]" ).append("\n"); 
		query.append("    , UPD_DT	=	SYSDATE" ).append("\n"); 
		query.append("    , UPD_OFC_CD	=	@[upd_ofc_cd]" ).append("\n"); 
		query.append("WHERE CNT_CD	=	NVL(@[cnt_cd],' ')" ).append("\n"); 
		query.append("  AND RGN_CD	=	NVL(@[rgn_cd],' ')" ).append("\n"); 
		query.append("  AND STE_CD	=	NVL(@[ste_cd],' ')" ).append("\n"); 
		query.append("  AND LOC_CD	=	NVL(@[loc_cd],' ')" ).append("\n"); 
		query.append("  AND IO_BND_CD	=	NVL(@[io_bnd_cd],' ')" ).append("\n"); 
		query.append("  AND DMDT_CALC_TP_CD	=	NVL(@[dmdt_calc_tp_cd],' ')" ).append("\n"); 

	}
}