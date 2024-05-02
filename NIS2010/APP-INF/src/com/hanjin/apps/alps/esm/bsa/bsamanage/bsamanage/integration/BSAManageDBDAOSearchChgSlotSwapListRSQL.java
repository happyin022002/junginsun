/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOSearchChgSlotSwapListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.02 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchChgSlotSwapListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BSA_0024 화면의 POPUP  ESM_BSA-0122 화면  BSA_SPC_CTRL_SWAP 목록을 가져온다
	  * </pre>
	  */
	public BSAManageDBDAOSearchChgSlotSwapListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prlanecd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pvslcapa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ptrdcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pbsaopcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pbsaseq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pbsaopjbcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pvopcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pdircd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchChgSlotSwapListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("BSA_FM_CRR_CD," ).append("\n"); 
		query.append("CRR_SWAP_CAPA," ).append("\n"); 
		query.append("BSA_TO_CRR_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BSA_SPC_CTRL_SWAP" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("TRD_CD       = @[ptrdcd]" ).append("\n"); 
		query.append("AND RLANE_CD     = @[prlanecd]" ).append("\n"); 
		query.append("AND DIR_CD       = @[pdircd]" ).append("\n"); 
		query.append("AND VOP_CD       = @[pvopcd]" ).append("\n"); 
		query.append("AND VSL_CAPA     = @[pvslcapa]" ).append("\n"); 
		query.append("AND BSA_SEQ      = @[pbsaseq]" ).append("\n"); 
		query.append("AND BSA_OP_CD    = @[pbsaopcd]" ).append("\n"); 
		query.append("AND BSA_OP_JB_CD = @[pbsaopjbcd]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("BSA_FM_CRR_CD" ).append("\n"); 

	}
}