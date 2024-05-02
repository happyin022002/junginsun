/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOEstmActRsltTotalByMonthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOEstmActRsltTotalByMonthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * By Month Total
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOEstmActRsltTotalByMonthRSQL(){
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOEstmActRsltTotalByMonthRSQL").append("\n"); 
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
		query.append("SELECT SUM(ROUND(A.ESTM_AMT,3)) AS ESTM_AMT" ).append("\n"); 
		query.append("     , SUM(ROUND(A.ACT_AMT,3)) AS ACT_AMT" ).append("\n"); 
		query.append("     , SUM(ROUND(A.ACCL_AMT,3)) AS ACCL_AMT" ).append("\n"); 
		query.append("     , SUM(1) AS DIFF_AMT" ).append("\n"); 
		query.append("  FROM JOO_ESTM_ACT_RSLT A" ).append("\n"); 
		query.append("     , JOO_CARRIER       B" ).append("\n"); 
		query.append(" WHERE A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD  = B.RLANE_CD" ).append("\n"); 
		query.append("   AND B.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("   AND A.EXE_YRMON = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("   AND A.ACCT_CD LIKE DECODE(@[re_divr_cd],'R','4','E','5')||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("   AND A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("   AND B.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("   AND A.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("   AND A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD || A.REV_DIR_CD LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_include} !='' && ${chk_include} != 'Y')" ).append("\n"); 
		query.append("   AND NVL(A.ACCL_AMT_CORR_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cds} !='')                                   " ).append("\n"); 
		query.append("   AND A.JO_STL_ITM_CD IN (" ).append("\n"); 
		query.append("       #foreach($key IN ${jo_stl_itm_cds})" ).append("\n"); 
		query.append("           #if($velocityCount < $jo_stl_itm_cds.size()) '$key', #else '$key' #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("   ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}