/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAManageDBDAOSearchCarrierItem2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchCarrierItem2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSAManageDBDAOSearchCarrierItem2
	  * </pre>
	  */
	public BSAManageDBDAOSearchCarrierItem2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchCarrierItem2RSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       CRR_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("      BSA_CRR_RGST" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("      APLY_FLG   = 'Y'" ).append("\n"); 
		query.append("#if (${bsa_op_cd} != '') " ).append("\n"); 
		query.append("  AND BSA_OP_CD  = @[bsa_op_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND CRR_CD    = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC" ).append("\n"); 
		query.append("  AND BSA_OP_JB_CD IN (SELECT " ).append("\n"); 
		query.append("                              BSA_OP_JB_CD" ).append("\n"); 
		query.append("                       FROM " ).append("\n"); 
		query.append("                            BSA_OP_JB" ).append("\n"); 
		query.append("                       WHERE " ).append("\n"); 
		query.append("                            BSA_OP_JB_CD IN ('001','002','003','004','005')/*** 컬럼삭제 에따른 코드 하드코딩 bsa_op_mgmt_cd = '1' */" ).append("\n"); 
		query.append("                       #if (${bsa_op_cd} != '') " ).append("\n"); 
		query.append("                         AND BSA_OP_CD  = @[bsa_op_cd]" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CRR_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       CRR_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("      BSA_CRR_RGST" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("      APLY_FLG   = 'Y'" ).append("\n"); 
		query.append("#if (${bsa_op_cd} != '') " ).append("\n"); 
		query.append("  AND BSA_OP_CD  = @[bsa_op_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND CRR_CD    != COM_ConstantMgr_PKG.COM_getCompanyCode_FNC" ).append("\n"); 
		query.append("  AND BSA_OP_JB_CD IN (SELECT " ).append("\n"); 
		query.append("                              BSA_OP_JB_CD" ).append("\n"); 
		query.append("                       FROM " ).append("\n"); 
		query.append("                            BSA_OP_JB" ).append("\n"); 
		query.append("                       WHERE " ).append("\n"); 
		query.append("                            BSA_OP_JB_CD IN ('001','002','003','004','005')/*** 컬럼삭제 에따른 코드 하드코딩 bsa_op_mgmt_cd = '1' */" ).append("\n"); 
		query.append("                       #if (${bsa_op_cd} != '') " ).append("\n"); 
		query.append("                         AND BSA_OP_CD  = @[bsa_op_cd]" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("ORDER BY CRR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}