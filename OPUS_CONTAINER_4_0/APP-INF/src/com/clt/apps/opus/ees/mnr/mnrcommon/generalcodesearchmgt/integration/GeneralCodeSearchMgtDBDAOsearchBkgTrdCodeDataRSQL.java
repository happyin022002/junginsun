/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchBkgTrdCodeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchBkgTrdCodeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchBkgTrdCodeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rslt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchBkgTrdCodeDataRSQL").append("\n"); 
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
		query.append("SELECT B.BKG_NO, " ).append("\n"); 
		query.append("       CASE WHEN SUBSTR(A.N1ST_FINC_VVD_CD, 1, 9) = B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD THEN A.N1ST_TRD_CD" ).append("\n"); 
		query.append("            WHEN SUBSTR(A.N2ND_FINC_VVD_CD, 1, 9) = B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD THEN A.N2ND_TRD_CD" ).append("\n"); 
		query.append("            WHEN SUBSTR(A.N3RD_FINC_VVD_CD, 1, 9) = B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD THEN A.N3RD_TRD_CD" ).append("\n"); 
		query.append("            WHEN SUBSTR(A.N4TH_FINC_VVD_CD, 1, 9) = B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD THEN A.N4TH_TRD_CD" ).append("\n"); 
		query.append("            ELSE NULL " ).append("\n"); 
		query.append("       END AS TRD_CD" ).append("\n"); 
		query.append("FROM COA_RGST_BKG A, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("  AND B.BKG_NO = (" ).append("\n"); 
		query.append("#if(${eq_type} == 'U')" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC (A XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("             A.BKG_NO" ).append("\n"); 
		query.append("#elseif(${eq_type} == 'Z')" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC (A XAK17CTM_MOVEMENT) */" ).append("\n"); 
		query.append("             A.BKG_NO" ).append("\n"); 
		query.append("#elseif(${eq_type} == 'G')" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC (A XAK20CTM_MOVEMENT) */" ).append("\n"); 
		query.append("             A.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT A, BKG_BOOKING B" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("		  #if(${pl} == 'P')" ).append("\n"); 
		query.append("	       AND TO_CHAR(A.CNMV_EVNT_DT, 'YYYYMMDD') <= @[rpr_rslt_dt]" ).append("\n"); 
		query.append("          #elseif(${pl} == 'L')" ).append("\n"); 
		query.append("           AND TO_CHAR(A.CNMV_EVNT_DT, 'YYYYMMDD') >= @[rpr_rslt_dt]" ).append("\n"); 
		query.append("           AND A.MVMT_STS_CD = 'OP'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("	      #if(${eq_type} == 'U')" ).append("\n"); 
		query.append("           AND A.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("		  #elseif(${eq_type} == 'Z')" ).append("\n"); 
		query.append("           AND A.CHSS_NO = @[eq_no]" ).append("\n"); 
		query.append("          #elseif(${eq_type} == 'G')" ).append("\n"); 
		query.append("           AND A.MGST_NO = @[eq_no]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if(${fm} == 'F')" ).append("\n"); 
		query.append("           AND A.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("          #elseif(${fm} == 'E')" ).append("\n"); 
		query.append("           AND A.BKG_CGO_TP_CD NOT IN ('F', 'R')  " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("           AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND B.VSL_CD NOT IN ('COXX', 'COYY', 'COZZ')" ).append("\n"); 
		query.append("           AND B.BKG_STS_CD = 'F'" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}