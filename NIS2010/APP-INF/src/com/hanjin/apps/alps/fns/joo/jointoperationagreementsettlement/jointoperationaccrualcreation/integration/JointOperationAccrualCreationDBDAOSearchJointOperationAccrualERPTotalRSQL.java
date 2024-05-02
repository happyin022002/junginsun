/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOSearchJointOperationAccrualERPTotalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.04.14 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOSearchJointOperationAccrualERPTotalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 추정 건을 ERP보낸 보낸 후 총 합계
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOSearchJointOperationAccrualERPTotalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_vvd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOSearchJointOperationAccrualERPTotalRSQL").append("\n"); 
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
		query.append("SELECT SUM(ROUND(A.ESTM_AMT,2)) AS ESTM_AMT" ).append("\n"); 
		query.append("      ,SUM(ROUND(A.ACT_AMT, 2)) AS ACT_AMT" ).append("\n"); 
		query.append("      ,SUM(ROUND(A.ACCL_AMT,2)) AS ACCL_AMT" ).append("\n"); 
		query.append("      ,SUM(1) AS DIFF_AMT" ).append("\n"); 
		query.append("      ,CEIL(COUNT(1)/TO_NUMBER(@[pagerows])) AS TOT_PAGE_CNT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.SYS_SRC_ID = 'JOO'" ).append("\n"); 
		query.append("AND A.EXE_YRMON = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("           #if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("           AND A.ACCT_CD LIKE DECODE(@[re_divr_cd],'R','4','E','5')||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("           AND A.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${trd_cd} != '')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("           AND A.WO_NO  = @[rlane_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${vvd} != '')" ).append("\n"); 
		query.append("           AND A.VSL_CD 	= substr(@[vvd],1,4) " ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("           AND A.REV_DIR_CD = substr(@[vvd],10,1)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${acct_cd} != '')" ).append("\n"); 
		query.append("           AND A.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${estm_vvd_tp_cd} != '')" ).append("\n"); 
		query.append("           AND A.ESTM_VVD_TP_CD = @[estm_vvd_tp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${diff} != '')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${adjust} != '')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${rev_yrmon_to} != '' && ${rev_yrmon_fr} != '')" ).append("\n"); 
		query.append("		   AND A.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 

	}
}