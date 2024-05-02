/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SPCManageDBDAOMultiSpcSlotInfoByVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOMultiSpcSlotInfoByVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA_VVD_SWAP_INFO 테이블에 Company의 FREE ADDITION 정보를 업데이트 한다.
	  * </pre>
	  */
	public SPCManageDBDAOMultiSpcSlotInfoByVvdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("free_add_teu_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bsa_op_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("free_add_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOMultiSpcSlotInfoByVvdCSQL").append("\n"); 
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
		query.append("MERGE INTO BSA_VVD_SWAP_INFO A " ).append("\n"); 
		query.append("       USING(" ).append("\n"); 
		query.append("             SELECT @[trd_cd] AS TRD_CD," ).append("\n"); 
		query.append("                  @[rlane_cd] AS RLANE_CD," ).append("\n"); 
		query.append("                  @[vsl_cd] AS VSL_CD," ).append("\n"); 
		query.append("                  @[skd_voy_no] AS SKD_VOY_NO," ).append("\n"); 
		query.append("                  @[skd_dir_cd] AS SKD_DIR_CD," ).append("\n"); 
		query.append("                  @[bsa_op_jb_cd] AS BSA_OP_JB_CD," ).append("\n"); 
		query.append("                  @[free_add_teu_capa] AS FREE_ADD_TEU_CAPA," ).append("\n"); 
		query.append("                  @[free_add_wgt] AS FREE_ADD_WGT," ).append("\n"); 
		query.append("                  @[cre_usr_id] AS USR_ID, " ).append("\n"); 
		query.append("                  COM_ConstantMgr_PKG.COM_getCompanyCode_FNC AS CRR_CD" ).append("\n"); 
		query.append("             FROM DUAL" ).append("\n"); 
		query.append("            ) B" ).append("\n"); 
		query.append("       ON(" ).append("\n"); 
		query.append("               A.TRD_CD         = B.TRD_CD" ).append("\n"); 
		query.append("           AND A.RLANE_CD       = B.RLANE_CD" ).append("\n"); 
		query.append("           AND A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND A.BSA_OP_JB_CD   = B.BSA_OP_JB_CD" ).append("\n"); 
		query.append("           AND A.CRR_CD         = B.CRR_CD" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("       WHEN MATCHED THEN" ).append("\n"); 
		query.append("            UPDATE SET " ).append("\n"); 
		query.append("                   FREE_ADD_TEU_CAPA  = B.FREE_ADD_TEU_CAPA," ).append("\n"); 
		query.append("                   FREE_ADD_WGT       = B.FREE_ADD_WGT," ).append("\n"); 
		query.append("                   UPD_USR_ID         = B.USR_ID," ).append("\n"); 
		query.append("                   UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("       WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("            INSERT (TRD_CD, " ).append("\n"); 
		query.append("					RLANE_CD, " ).append("\n"); 
		query.append("					VSL_CD, " ).append("\n"); 
		query.append("					SKD_VOY_NO, " ).append("\n"); 
		query.append("					SKD_DIR_CD," ).append("\n"); 
		query.append("                    BSA_OP_JB_CD, " ).append("\n"); 
		query.append("					CRR_CD, " ).append("\n"); 
		query.append("					FREE_ADD_TEU_CAPA, " ).append("\n"); 
		query.append("					FREE_ADD_WGT," ).append("\n"); 
		query.append("                    CRE_USR_ID, " ).append("\n"); 
		query.append("					CRE_DT, " ).append("\n"); 
		query.append("					UPD_USR_ID, " ).append("\n"); 
		query.append("					UPD_DT)" ).append("\n"); 
		query.append("            VALUES( B.TRD_CD, " ).append("\n"); 
		query.append("					B.RLANE_CD, " ).append("\n"); 
		query.append("					B.VSL_CD, " ).append("\n"); 
		query.append("					B.SKD_VOY_NO, " ).append("\n"); 
		query.append("					B.SKD_DIR_CD, " ).append("\n"); 
		query.append("					B.BSA_OP_JB_CD," ).append("\n"); 
		query.append("                    B.CRR_CD, " ).append("\n"); 
		query.append("					B.FREE_ADD_TEU_CAPA, " ).append("\n"); 
		query.append("					B.FREE_ADD_WGT, " ).append("\n"); 
		query.append("					B.USR_ID, " ).append("\n"); 
		query.append("					SYSDATE, " ).append("\n"); 
		query.append("					B.USR_ID, " ).append("\n"); 
		query.append("					SYSDATE)" ).append("\n"); 

	}
}