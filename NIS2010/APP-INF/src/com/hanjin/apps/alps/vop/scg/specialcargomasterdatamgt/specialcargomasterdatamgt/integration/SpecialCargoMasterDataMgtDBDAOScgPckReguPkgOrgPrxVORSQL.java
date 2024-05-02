/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgPckReguPkgOrgPrxVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.05
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.05 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgPckReguPkgOrgPrxVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 데이터를 insert를 한다.
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgPckReguPkgOrgPrxVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("regu_dp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgPckReguPkgOrgPrxVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append(", IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append(", REGU_DP_NO     " ).append("\n"); 
		query.append(", SUB_SEQ         " ).append("\n"); 
		query.append(", IMDG_UN_NO  " ).append("\n"); 
		query.append(", ORG_PRX_DESC" ).append("\n"); 
		query.append(", IMDG_PCK_CD      " ).append("\n"); 
		query.append(", MAX_CAPA_QTY    " ).append("\n"); 
		query.append(", IMDG_CTRL_TEMP   " ).append("\n"); 
		query.append(", IMDG_EMER_TEMP   " ).append("\n"); 
		query.append(", DELT_FLG     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM SCG_PCK_REGU_ORG_PRX" ).append("\n"); 
		query.append("WHERE IMDG_PCK_INSTR_CD = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("AND   IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq]" ).append("\n"); 
		query.append("AND   REGU_DP_NO    = @[regu_dp_no]" ).append("\n"); 
		query.append("AND   DELT_FLG = 'N'" ).append("\n"); 

	}
}