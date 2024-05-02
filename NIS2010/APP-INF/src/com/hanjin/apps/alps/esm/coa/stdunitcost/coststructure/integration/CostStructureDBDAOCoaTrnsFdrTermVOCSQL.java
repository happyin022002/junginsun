/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostStructureDBDAOCoaTrnsFdrTermVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.11.05 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Yeong-seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOCoaTrnsFdrTermVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _TRNS_FDR_TERM 테이블의 데이터 업데이트
	  * </pre>
	  */
	public CostStructureDBDAOCoaTrnsFdrTermVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOCoaTrnsFdrTermVOCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_TRNS_FDR_TERM B1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT '1' FROM DUAL" ).append("\n"); 
		query.append(") B2" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("B1.ORG_LOC_CD  = @[org_loc_cd]" ).append("\n"); 
		query.append("AND B1.DEST_LOC_CD = @[dest_loc_cd]" ).append("\n"); 
		query.append("AND B1.FULL_MTY_CD = @[full_mty_cd])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET  B1.FDR_RCV_TERM_CD = @[fdr_rcv_term_cd]" ).append("\n"); 
		query.append(",B1.FDR_DE_TERM_CD  = @[fdr_de_term_cd]" ).append("\n"); 
		query.append(",B1.UPD_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append(",B1.UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT(" ).append("\n"); 
		query.append("ORG_LOC_CD" ).append("\n"); 
		query.append(",DEST_LOC_CD" ).append("\n"); 
		query.append(",FULL_MTY_CD" ).append("\n"); 
		query.append(",FDR_RCV_TERM_CD" ).append("\n"); 
		query.append(",FDR_DE_TERM_CD" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("@[org_loc_cd]" ).append("\n"); 
		query.append(",@[dest_loc_cd]" ).append("\n"); 
		query.append(",@[full_mty_cd]" ).append("\n"); 
		query.append(",@[fdr_rcv_term_cd]" ).append("\n"); 
		query.append(",@[fdr_de_term_cd]" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}