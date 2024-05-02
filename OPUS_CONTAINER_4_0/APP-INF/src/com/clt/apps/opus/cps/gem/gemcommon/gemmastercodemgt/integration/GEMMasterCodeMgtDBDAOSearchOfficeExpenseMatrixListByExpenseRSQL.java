/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchOfficeExpenseMatrixListByExpenseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.08.26 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchOfficeExpenseMatrixListByExpenseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 비용계획을 요청할수 있는 집행단위 조직이 사용할수 있는 비용코드(Expense Code)를 조회한다.
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchOfficeExpenseMatrixListByExpenseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_office_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lang",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_expn_group",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchOfficeExpenseMatrixListByExpenseRSQL").append("\n"); 
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
		query.append("SELECT A.OFC_CD OFC_CD" ).append("\n"); 
		query.append(",A.GEN_EXPN_CD GEN_EXPN_CD" ).append("\n"); 
		query.append(",DECODE (@[sch_lang], 'K', B.KRN_ABBR_NM, 'E', B.ENG_ABBR_NM) EXPN_NM" ).append("\n"); 
		query.append(",B.TIC_CD TIC_CD" ).append("\n"); 
		query.append(",A.DELT_FLG DELT_FLG" ).append("\n"); 
		query.append("FROM   GEM_OFC_MTX A, GEM_EXPENSE B" ).append("\n"); 
		query.append("WHERE  A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("#if(${hdn_ofc_cd} != '')" ).append("\n"); 
		query.append("AND    A.OFC_CD = @[hdn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'N')" ).append("\n"); 
		query.append("#if(${sch_office_code} != '')" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_CD like @[sch_office_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sch_expn_group} != '')" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_CD IN (SELECT L_4" ).append("\n"); 
		query.append("FROM   GEM_EXPN_LEVEL_V" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    L_1 like @[sch_expn_group]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_delt_flg} == 'Y')" ).append("\n"); 
		query.append("AND    A.DELT_FLG = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.GEN_EXPN_CD" ).append("\n"); 

	}
}