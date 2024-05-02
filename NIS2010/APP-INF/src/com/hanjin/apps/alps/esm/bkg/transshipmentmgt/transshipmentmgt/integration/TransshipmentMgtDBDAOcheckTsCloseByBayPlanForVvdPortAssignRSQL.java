/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TransshipmentMgtDBDAOcheckTsCloseByBayPlanForVvdPortAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.22
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.04.22 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOcheckTsCloseByBayPlanForVvdPortAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group VVD / Port Assign화면에서 T/S Close 여부를 확인함
	  * </pre>
	  */
	public TransshipmentMgtDBDAOcheckTsCloseByBayPlanForVvdPortAssignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOcheckTsCloseByBayPlanForVvdPortAssignRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT VVD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("	SELECT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("	  FROM BKG_VVD VVD, BKG_TS_COFF_TM COFF" ).append("\n"); 
		query.append("	 WHERE BKG_NO IN " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("#foreach( ${bkgNo} in ${bkgNos}) " ).append("\n"); 
		query.append("	#if($velocityCount < $bkgNos.size()) '$bkgNo', #else '$bkgNo' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	   AND VVD.VSL_CD = COFF.VSL_CD" ).append("\n"); 
		query.append("	   AND VVD.SKD_VOY_NO = COFF.SKD_VOY_NO" ).append("\n"); 
		query.append("	   AND VVD.SKD_DIR_CD = COFF.SKD_DIR_CD" ).append("\n"); 
		query.append("	   AND VVD.POL_CD = COFF.POL_CD" ).append("\n"); 
		query.append("	   AND VVD.POL_CLPT_IND_SEQ = COFF.CLPT_IND_SEQ" ).append("\n"); 
		query.append("	   AND COFF.BKG_CLZ_STS_CD = 'C'" ).append("\n"); 
		query.append("	   AND VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD||VVD.POL_CD||VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	        NOT IN " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("#foreach( ${vvd} in ${vvds}) " ).append("\n"); 
		query.append("	#if($velocityCount < $vvds.size()) '$vvd', #else '$vvd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	 UNION" ).append("\n"); 
		query.append("	SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD" ).append("\n"); 
		query.append("	  FROM BKG_TS_COFF_TM" ).append("\n"); 
		query.append("	 WHERE BKG_CLZ_STS_CD = 'C'" ).append("\n"); 
		query.append("       AND VSL_CD||SKD_VOY_NO||SKD_DIR_CD||POL_CD||CLPT_IND_SEQ" ).append("\n"); 
		query.append("	        IN " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("#foreach( ${vvd} in ${vvds}) " ).append("\n"); 
		query.append("	#if($velocityCount < $vvds.size()) '$vvd', #else '$vvd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	   AND VSL_CD||SKD_VOY_NO||SKD_DIR_CD||POL_CD||CLPT_IND_SEQ" ).append("\n"); 
		query.append("	        NOT IN (SELECT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD||VVD.POL_CD||VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	                  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("	                 WHERE BKG_NO IN " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("#foreach( ${bkgNo} in ${bkgNos}) " ).append("\n"); 
		query.append("	#if($velocityCount < $bkgNos.size()) '$bkgNo', #else '$bkgNo' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}