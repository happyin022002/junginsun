/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchExptListByExpenseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.08.14 최정미
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

public class GEMMasterCodeMgtDBDAOSearchExptListByExpenseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * From Office 에서 예산을 수립할 수 있는 일반관리비 비용코드, TO Office 에서 예산을 수립할 수 있는 일반관리비 비용코드 를 비교하여 같은 비용코드에 한하여 목록을 조회한다
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchExptListByExpenseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchExptListByExpenseRSQL").append("\n"); 
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
		query.append("#if(${gubun} == 'A')" ).append("\n"); 
		query.append("SELECT DISTINCT '2' SORT1" ).append("\n"); 
		query.append(",A.GEN_EXPN_CD" ).append("\n"); 
		query.append(",B.KRN_ABBR_NM" ).append("\n"); 
		query.append(",B.ENG_ABBR_NM" ).append("\n"); 
		query.append("FROM            (SELECT A.GEN_EXPN_CD" ).append("\n"); 
		query.append("FROM   (SELECT GEN_EXPN_CD" ).append("\n"); 
		query.append("FROM   GEM_OFC_MTX" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    OFC_CD = @[snd_ofc_cd]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", (SELECT GEN_EXPN_CD" ).append("\n"); 
		query.append("FROM   GEM_OFC_MTX" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${rcv_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("AND    OFC_CD = @[rcv_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE  A.GEN_EXPN_CD = B.GEN_EXPN_CD) A" ).append("\n"); 
		query.append(",GEM_EXPENSE B" ).append("\n"); 
		query.append("WHERE           A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("ORDER BY        1, 2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${gubun} == 'B')" ).append("\n"); 
		query.append("SELECT   '0' SORT1" ).append("\n"); 
		query.append(",' ' GEN_EXPN_CD" ).append("\n"); 
		query.append(",'' KRN_ABBR_NM" ).append("\n"); 
		query.append(",'' ENG_ABBR_NM" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${gubun} == 'C')" ).append("\n"); 
		query.append("SELECT   '0' SORT1" ).append("\n"); 
		query.append(",' ' GEN_EXPN_CD" ).append("\n"); 
		query.append(",'' KRN_ABBR_NM" ).append("\n"); 
		query.append(",'' ENG_ABBR_NM" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   '1' SORT1" ).append("\n"); 
		query.append(",'ALL' GEN_EXPN_CD" ).append("\n"); 
		query.append(",'전체' KRN_ABBR_NM" ).append("\n"); 
		query.append(",'ALL' ENG_ABBR_NM" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT '2' SORT1" ).append("\n"); 
		query.append(",A.GEN_EXPN_CD" ).append("\n"); 
		query.append(",B.KRN_ABBR_NM" ).append("\n"); 
		query.append(",B.ENG_ABBR_NM" ).append("\n"); 
		query.append("FROM            (SELECT A.GEN_EXPN_CD" ).append("\n"); 
		query.append("FROM   (SELECT GEN_EXPN_CD" ).append("\n"); 
		query.append("FROM   GEM_OFC_MTX" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    OFC_CD = @[snd_ofc_cd]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", (SELECT GEN_EXPN_CD" ).append("\n"); 
		query.append("FROM   GEM_OFC_MTX" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${rcv_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("AND    OFC_CD = @[rcv_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE  A.GEN_EXPN_CD = B.GEN_EXPN_CD) A" ).append("\n"); 
		query.append(",GEM_EXPENSE B" ).append("\n"); 
		query.append("WHERE           A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("ORDER BY        1, 2" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}