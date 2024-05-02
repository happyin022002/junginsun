/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOAddModelshipAcctAmendHisCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2014.03.31 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOAddModelshipAcctAmendHisCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규 버전 생성시 최신버전의 Amend 된 account 정보를 그대로 insert합니다.
	  * 2014.03.06 [CHM-20142960] SMP/Allocation control보완 요청 - Amend 기능 추가
	  * </pre>
	  */
	public ModelManageDBDAOAddModelshipAcctAmendHisCopyCSQL(){
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
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOAddModelshipAcctAmendHisCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_MDL_CUST_CTRL_HIS" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("       TRD_CD" ).append("\n"); 
		query.append("     , COST_YRWK" ).append("\n"); 
		query.append("     , VER_SEQ" ).append("\n"); 
		query.append("     , MODI_SEQ" ).append("\n"); 
		query.append("     , CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , CUST_GRP_ID" ).append("\n"); 
		query.append("     , SC_NO" ).append("\n"); 
		query.append("     , RFA_NO" ).append("\n"); 
		query.append("     , CUST_CTRL_CD" ).append("\n"); 
		query.append("     , WK_MQC_QTY" ).append("\n"); 
		query.append("     , CNG_ITM_NM" ).append("\n"); 
		query.append("     , OLD_CUST_GRP_ID" ).append("\n"); 
		query.append("     , OLD_CUST_CNT_CD" ).append("\n"); 
		query.append("     , OLD_CUST_SEQ" ).append("\n"); 
		query.append("     , OLD_SC_NO" ).append("\n"); 
		query.append("     , OLD_RFA_NO" ).append("\n"); 
		query.append("     , OLD_WK_MQC_QTY" ).append("\n"); 
		query.append("     , OLD_CUST_CTRL_CD" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , MODI_USR_ID" ).append("\n"); 
		query.append("     , MODI_GDT" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , SUB_TRD_CD" ).append("\n"); 
		query.append("     , PRE_SC_NO" ).append("\n"); 
		query.append("     , PRE_RFA_NO" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("SELECT /*+ INDEX (XPKSPC_MDL_CUST_CTRL_HIS) */" ).append("\n"); 
		query.append("       TRD_CD" ).append("\n"); 
		query.append("     , COST_YRWK" ).append("\n"); 
		query.append("     , @[ver_seq] AS VER_SEQ" ).append("\n"); 
		query.append("     , ROWNUM AS MODI_SEQ" ).append("\n"); 
		query.append("     , CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , CUST_GRP_ID" ).append("\n"); 
		query.append("     , SC_NO" ).append("\n"); 
		query.append("     , RFA_NO" ).append("\n"); 
		query.append("     , CUST_CTRL_CD" ).append("\n"); 
		query.append("     , WK_MQC_QTY" ).append("\n"); 
		query.append("     , CNG_ITM_NM" ).append("\n"); 
		query.append("     , OLD_CUST_GRP_ID" ).append("\n"); 
		query.append("     , OLD_CUST_CNT_CD" ).append("\n"); 
		query.append("     , OLD_CUST_SEQ" ).append("\n"); 
		query.append("     , OLD_SC_NO" ).append("\n"); 
		query.append("     , OLD_RFA_NO" ).append("\n"); 
		query.append("     , OLD_WK_MQC_QTY" ).append("\n"); 
		query.append("     , OLD_CUST_CTRL_CD" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , MODI_USR_ID" ).append("\n"); 
		query.append("     , MODI_GDT" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , SUB_TRD_CD" ).append("\n"); 
		query.append("     , PRE_SC_NO" ).append("\n"); 
		query.append("     , PRE_RFA_NO" ).append("\n"); 
		query.append("  FROM SPC_MDL_CUST_CTRL_HIS" ).append("\n"); 
		query.append(" WHERE TRD_CD      = @[trade]" ).append("\n"); 
		query.append("   AND COST_YRWK   = @[cost_yrwk]" ).append("\n"); 
		query.append("   AND VER_SEQ     = TO_NUMBER(@[ver_seq]) - 1" ).append("\n"); 
		query.append("   AND CNG_ITM_NM IN ('RFA UPDATE', 'S/C UPDATE')" ).append("\n"); 

	}
}