/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchOfficeExpenseMatrixListByOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.24 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchOfficeExpenseMatrixListByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 비용계획을 요청할수 있는 집행단위 조직 코드 리스트 조회
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchOfficeExpenseMatrixListByOfficeRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lvl3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_hohq_gbn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sch_expn_group",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lvl1",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT A.OFC_CD ofc_cd" ).append("\n"); 
		query.append(",A.LOCL_CURR_CD locl_curr_cd" ).append("\n"); 
		query.append(",A.RQST_UT_VAL rqst_ut_val" ).append("\n"); 
		query.append(",B.USD_LOCL_XCH_RT usd_locl_xch_rt" ).append("\n"); 
		query.append(",DECODE(A.RQST_AUTH_FLG,    'Y','1','0') rqst_auth_flg" ).append("\n"); 
		query.append(",DECODE(A.RHQ_AUTH_FLG,     'Y','1','0') rhq_auth_flg" ).append("\n"); 
		query.append(",DECODE(A.TIC_AUTH_FLG,     'Y','1','0') tic_auth_flg" ).append("\n"); 
		query.append(",DECODE(A.CMIT_AUTH_FLG,    'Y','1','0') cmit_auth_flg" ).append("\n"); 
		query.append(",A.SLS_OFC_FLG sls_ofc_flg" ).append("\n"); 
		query.append("FROM   GEM_OFFICE A, GEM_XCH_RT B" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    B.ACCT_XCH_RT_YRMON = to_char(sysdate,'YYYY')||'00'" ).append("\n"); 
		query.append("AND    B.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("AND    A.LOCL_CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("AND    A.RQST_AUTH_FLG = 'Y'" ).append("\n"); 
		query.append("#if(${sch_hohq_gbn} != '')" ).append("\n"); 
		query.append("AND    A.OFC_CD in (" ).append("\n"); 
		query.append("SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("FROM   GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if(${sch_hohq_gbn} != '')" ).append("\n"); 
		query.append("AND RGN_OFC_FLG LIKE @[sch_hohq_gbn]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_lvl1} != '' && ${sch_lvl2} != '' && ${sch_lvl3} != '') AND L_4 LIKE @[sch_lvl3]||'%' #end" ).append("\n"); 
		query.append("#if(${sch_lvl1} != '' && ${sch_lvl2} != '' && ${sch_lvl3} == '') AND L_3 LIKE @[sch_lvl2]||'%' #end" ).append("\n"); 
		query.append("#if(${sch_lvl1} != '' && ${sch_lvl2} == '' && ${sch_lvl3} == '') AND L_2 LIKE @[sch_lvl1]||'%' #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'Y')" ).append("\n"); 
		query.append("#if(${sch_office_code} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD LIKE @[sch_office_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_delt_flg} == 'Y')" ).append("\n"); 
		query.append("AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    A.OFC_CD IN (" ).append("\n"); 
		query.append("SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("FROM   GEM_OFC_MTX" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'Y'" ).append("\n"); 
		query.append("#if(${sch_office_code} != '' || ${sch_expn_group} != '')" ).append("\n"); 
		query.append("AND    GEN_EXPN_CD IN (" ).append("\n"); 
		query.append("SELECT L_4" ).append("\n"); 
		query.append("FROM   GEM_EXPN_LEVEL_V" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'N')" ).append("\n"); 
		query.append("#if(${sch_office_code} != '')" ).append("\n"); 
		query.append("AND    L_4 LIKE @[sch_office_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_expn_group} != '')" ).append("\n"); 
		query.append("AND    L_1 LIKE @[sch_expn_group]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_office_code} != '' || ${sch_expn_group} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD IN (" ).append("\n"); 
		query.append("SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("FROM   GEM_OFC_MTX" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if(${sch_delt_flg} == 'Y')" ).append("\n"); 
		query.append("AND	   DELT_FLG = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	   DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	   GEN_EXPN_CD IN (" ).append("\n"); 
		query.append("SELECT L_4" ).append("\n"); 
		query.append("FROM   GEM_EXPN_LEVEL_V" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'N')" ).append("\n"); 
		query.append("#if(${sch_office_code} != '')" ).append("\n"); 
		query.append("AND    L_4 LIKE @[sch_office_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_expn_group} != '')" ).append("\n"); 
		query.append("AND    L_1 LIKE @[sch_expn_group]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.OFC_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchOfficeExpenseMatrixListByOfficeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}