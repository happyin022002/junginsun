/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MtyRepoSelectPopupDAOsearchMtyRepoSelectPopupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.07.27 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.mtyreposelectpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MtyRepoSelectPopupDAOsearchMtyRepoSelectPopupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMtyRepoSelectPopup
	  * </pre>
	  */
	public MtyRepoSelectPopupDAOsearchMtyRepoSelectPopupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.mtyreposelectpopup.integration").append("\n"); 
		query.append("FileName : MtyRepoSelectPopupDAOsearchMtyRepoSelectPopupRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("ROWNUM AS SEQ" ).append("\n"); 
		query.append(", C.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($code IN ${arrBkgno})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B1.CNTR_NO                 AS EQ_NO" ).append("\n"); 
		query.append(",   B1.CNTR_TPSZ_CD        AS EQ_TPSZ_CD" ).append("\n"); 
		query.append(",   A1.VVD                       AS VVD" ).append("\n"); 
		query.append(",   A1.BKG_NO                    AS BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER B1," ).append("\n"); 
		query.append("(SELECT A.BKG_NO                               AS BKG_NO" ).append("\n"); 
		query.append(",  A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("FROM BKG_BOOKING A" ).append("\n"); 
		query.append("WHERE 'X' <> A.BKG_STS_CD" ).append("\n"); 
		query.append("AND 'P' = A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(") A1" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = B1.BKG_NO (+)" ).append("\n"); 
		query.append("AND B1.BKG_NO = '$code'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B1.CNTR_NO                 AS EQ_NO" ).append("\n"); 
		query.append(",   B1.CNTR_TPSZ_CD        AS EQ_TPSZ_CD" ).append("\n"); 
		query.append(",   A1.VVD                       AS VVD" ).append("\n"); 
		query.append(",   A1.BKG_NO                    AS BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER B1," ).append("\n"); 
		query.append("(SELECT A.BKG_NO                               AS BKG_NO" ).append("\n"); 
		query.append(",  A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("FROM BKG_BOOKING A" ).append("\n"); 
		query.append("WHERE 'X' <> A.BKG_STS_CD" ).append("\n"); 
		query.append("AND 'P' = A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(") A1" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = B1.BKG_NO (+)" ).append("\n"); 
		query.append("AND B1.BKG_NO = '$code'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") C" ).append("\n"); 

	}
}