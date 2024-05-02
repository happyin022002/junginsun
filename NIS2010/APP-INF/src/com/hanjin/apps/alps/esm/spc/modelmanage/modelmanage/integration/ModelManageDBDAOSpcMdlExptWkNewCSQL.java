/*=========================================================
*Copyright(c) 2018 Hipluscard
*@FileName : ModelManageDBDAOSpcMdlExptWkNewCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.06
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.04.06 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOSpcMdlExptWkNewCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public ModelManageDBDAOSpcMdlExptWkNewCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSpcMdlExptWkNewCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_MDL_EXPT_WK (" ).append("\n"); 
		query.append("    TRD_CD, COST_YRWK, VER_SEQ, DTL_SEQ, EXPT_YRWK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TRD_CD" ).append("\n"); 
		query.append("     , COST_YRWK" ).append("\n"); 
		query.append("     , @[ver_seq]" ).append("\n"); 
		query.append("     , DTL_SEQ" ).append("\n"); 
		query.append("     , EXPT_YRWK" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("  FROM SPC_MDL_EXPT_WK " ).append("\n"); 
		query.append(" WHERE TRD_CD = @[trade]" ).append("\n"); 
		query.append("   AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("   AND VER_SEQ = DECODE(@[ver_seq], 1, 1, TO_NUMBER(@[ver_seq])-1)" ).append("\n"); 

	}
}