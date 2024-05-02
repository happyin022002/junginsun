/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchOfficeMatrixListByOfficeRSQL.java
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

public class GEMMasterCodeMgtDBDAOSearchOfficeMatrixListByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Fm Office 에서 일반관리비 비용코드(Expense Code) 사용시 To Office로 집계 되도록 정의된 정보
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchOfficeMatrixListByOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchOfficeMatrixListByOfficeRSQL").append("\n"); 
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
		query.append("SELECT A.SND_OFC_CD SND_OFC_CD" ).append("\n"); 
		query.append(",A.RCV_OFC_CD RCV_OFC_CD" ).append("\n"); 
		query.append(", (SELECT DISTINCT L_1" ).append("\n"); 
		query.append("FROM            GEM_EXPN_LEVEL_V" ).append("\n"); 
		query.append("WHERE           L_4 = A.GEN_EXPN_CD) GEN_EXPN_CD_GRP" ).append("\n"); 
		query.append(",A.GEN_EXPN_CD GEN_EXPN_CD" ).append("\n"); 
		query.append(",(SELECT DECODE (@[sch_lang], 'K', KRN_ABBR_NM, 'E', ENG_ABBR_NM) FROM GEM_EXPENSE WHERE GEN_EXPN_CD = A.GEN_EXPN_CD) GEN_EXPN_NM" ).append("\n"); 
		query.append(",A.CRE_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append(",A.DELT_FLG DELT_FLG" ).append("\n"); 
		query.append("FROM   GEM_OFC_EXPT A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'Y')" ).append("\n"); 
		query.append("#if(${sch_office_code} != '')" ).append("\n"); 
		query.append("AND    A.SND_OFC_CD LIKE @[sch_office_code] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'N')" ).append("\n"); 
		query.append("#if(${sch_office_code} != '')" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_CD LIKE @[sch_office_code] || '%'" ).append("\n"); 
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
		query.append("AND A.DELT_FLG = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.SND_OFC_CD, A.RCV_OFC_CD" ).append("\n"); 

	}
}