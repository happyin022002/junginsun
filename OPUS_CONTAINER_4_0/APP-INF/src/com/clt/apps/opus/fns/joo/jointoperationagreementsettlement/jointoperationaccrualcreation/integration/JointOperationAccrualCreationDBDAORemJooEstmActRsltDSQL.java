/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAORemJooEstmActRsltDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.03 
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

public class JointOperationAccrualCreationDBDAORemJooEstmActRsltDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAORemJooEstmActRsltDSQL(){
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
		query.append("FileName : JointOperationAccrualCreationDBDAORemJooEstmActRsltDSQL").append("\n"); 
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
		query.append("DELETE JOO_ESTM_ACT_RSLT A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.EXE_YRMON = REPLACE(@[exe_yrmon],'-','') /*Condition Accrual Month*/" ).append("\n"); 
		query.append("#if(${jo_crr_cd} != '')" ).append("\n"); 
		query.append("   AND A.JO_CRR_CD = @[jo_crr_cd] /*Condition Partner*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd}!='')" ).append("\n"); 
		query.append("   /* Condition Trade */" ).append("\n"); 
		query.append("   AND EXISTS   (   SELECT 'X'" ).append("\n"); 
		query.append("                      FROM JOO_CARRIER CRR" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND CRR.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                       AND CRR.JO_CRR_CD        = A.JO_CRR_CD" ).append("\n"); 
		query.append("                       AND CRR.RLANE_CD         = A.RLANE_CD" ).append("\n"); 
		query.append("                       AND CRR.TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rlane_cd} != '')" ).append("\n"); 
		query.append("   AND A.RLANE_CD = @[rlane_cd] /*Condition Lane*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("   AND A.ACCT_CD LIKE DECODE(@[re_divr_cd],'R','4','E','5')||'%' /* Condition Rev,Exp*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cds} != '' && ${jo_stl_itm_cds} != 'ALL')" ).append("\n"); 
		query.append("   /* Condition Items */" ).append("\n"); 
		query.append("   AND A.JO_STL_ITM_CD IN ( #foreach($key IN ${jo_stl_itm_cds})#if($velocityCount < $jo_stl_itm_cds.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("   AND A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD || A.REV_DIR_CD LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}