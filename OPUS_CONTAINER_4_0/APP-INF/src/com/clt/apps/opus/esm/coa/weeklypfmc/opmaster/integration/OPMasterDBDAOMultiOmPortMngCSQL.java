/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OPMasterDBDAOMultiOmPortMngCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOMultiOmPortMngCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public OPMasterDBDAOMultiOmPortMngCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOMultiOmPortMngCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_MON_VVD_PORT_EXPT B1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT '1' FROM DUAL " ).append("\n"); 
		query.append("	  ) B2	" ).append("\n"); 
		query.append("ON (     B1.EFF_FM_DT   = @[eff_fm_dt]  	--20150612.MOD		" ).append("\n"); 
		query.append("     AND B1.LOC_CD      = @[loc_cd]  " ).append("\n"); 
		query.append("     AND B1.RLANE_CD    = NVL(@[rlane_cd],'XXXXX')" ).append("\n"); 
		query.append("     AND B1.DIR_CD      = NVL(@[dir_cd],'X')" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE " ).append("\n"); 
		query.append("         SET EFF_TO_DT  = @[eff_to_dt]		--20150612.MOD	" ).append("\n"); 
		query.append("            ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("            ,UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("      INSERT (EFF_FM_DT       " ).append("\n"); 
		query.append("             ,EFF_TO_DT          " ).append("\n"); 
		query.append("             ,LOC_CD  " ).append("\n"); 
		query.append("             ,RLANE_CD      " ).append("\n"); 
		query.append("             ,DIR_CD    " ).append("\n"); 
		query.append("             ,CRE_USR_ID      " ).append("\n"); 
		query.append("             ,CRE_DT          " ).append("\n"); 
		query.append("             ,UPD_USR_ID      " ).append("\n"); 
		query.append("             ,UPD_DT) " ).append("\n"); 
		query.append("      VALUES (@[eff_fm_dt]         " ).append("\n"); 
		query.append("             ,NVL(@[eff_to_dt], '99991231')          " ).append("\n"); 
		query.append("             ,@[loc_cd]      " ).append("\n"); 
		query.append("             ,NVL(@[rlane_cd],'XXXXX')   " ).append("\n"); 
		query.append("             ,NVL(@[dir_cd],'X')" ).append("\n"); 
		query.append("             ,@[cre_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE" ).append("\n"); 
		query.append("             ,@[upd_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE)" ).append("\n"); 

	}
}