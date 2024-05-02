/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOAddExpenseCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.29
*@LastModifier : 유재민
*@LastVersion : 1.0
* 2011.03.29 유재민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeMin YOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOAddExpenseCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일관적으로 비용코드를 조직별로 매핑 ( fmOfc -> toOfc )
	  * 
	  * =========================================
	  * 2011.03.23 유재민 CHM-201109669-01 Expense code matrix Per OFC 기능 누락 비용 코드 추가 반영 요청
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOAddExpenseCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOAddExpenseCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO GEM_OFC_MTX" ).append("\n"); 
		query.append("            (OFC_CD, GEN_EXPN_CD, DELT_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("    SELECT @[to_ofc_cd]" ).append("\n"); 
		query.append("          ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("          ,A.DELT_FLG" ).append("\n"); 
		query.append("          ,@[cre_usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("          ,@[upd_usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("    FROM   GEM_OFC_MTX A" ).append("\n"); 
		query.append("    WHERE  A.OFC_CD = @[from_ofc_cd]" ).append("\n"); 
		query.append("      AND  A.GEN_EXPN_CD IN ( SELECT GEN_EXPN_CD" ).append("\n"); 
		query.append("                                FROM GEM_EXPENSE" ).append("\n"); 
		query.append("                               WHERE GEN_EXPN_GRP_LVL = '4'" ).append("\n"); 
		query.append("                                -- AND SALY_FLG = 'N'" ).append("\n"); 
		query.append("                                 AND GEN_EXPN_SLS_DIV_CD IN (" ).append("\n"); 
		query.append("                                                               SELECT DECODE(FM_SLS_FLG, 'Y', DECODE(TO_SLS_FLG, 'Y', 'Y'), DECODE(TO_SLS_FLG, 'N', 'N'))" ).append("\n"); 
		query.append("                                                                 FROM " ).append("\n"); 
		query.append("                                                                     (" ).append("\n"); 
		query.append("                                                                      SELECT SLS_OFC_FLG AS FM_SLS_FLG" ).append("\n"); 
		query.append("                                                                        FROM GEM_OFFICE" ).append("\n"); 
		query.append("                                                                       WHERE OFC_CD = @[from_ofc_cd]" ).append("\n"); 
		query.append("                                                                     ) A" ).append("\n"); 
		query.append("                                                                    ,(  " ).append("\n"); 
		query.append("                                                                      SELECT SLS_OFC_FLG AS TO_SLS_FLG " ).append("\n"); 
		query.append("                                                                        FROM GEM_OFFICE" ).append("\n"); 
		query.append("                                                                       WHERE OFC_CD = @[to_ofc_cd]" ).append("\n"); 
		query.append("                                                                     ) B" ).append("\n"); 
		query.append("                                                                    UNION ALL" ).append("\n"); 
		query.append("                                                                    SELECT 'C' FROM DUAL" ).append("\n"); 
		query.append("                                                               )" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("    AND    A.GEN_EXPN_CD NOT IN (SELECT DISTINCT GEN_EXPN_CD" ).append("\n"); 
		query.append("                            	   FROM GEM_OFC_MTX" ).append("\n"); 
		query.append("                            	  WHERE OFC_CD = @[to_ofc_cd])" ).append("\n"); 

	}
}