/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RatingUnitDBDAOPriRatUtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.17 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.ratingunit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RatingUnitDBDAOPriRatUtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RatingUnitDBDAOPriRatUtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.ratingunit.integration").append("\n"); 
		query.append("FileName : RatingUnitDBDAOPriRatUtVORSQL").append("\n"); 
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
		query.append("RAT_UT_CD" ).append("\n"); 
		query.append(",	RAT_UT_DESC" ).append("\n"); 
		query.append(",	RAT_UT_GRP_CD" ).append("\n"); 
		query.append(",	CNTR_SZ_CD" ).append("\n"); 
		query.append(",	CNTR_LEN" ).append("\n"); 
		query.append(",	CNTR_WDT" ).append("\n"); 
		query.append(",	CNTR_HGT" ).append("\n"); 
		query.append(",	CNTR_WGT" ).append("\n"); 
		query.append(",	DECODE(CTRT_USE_ONY_FLG, 'N', '0', 'Y', '1') AS CTRT_USE_ONY_FLG" ).append("\n"); 
		query.append(",	TO_CHAR(CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",   DECODE(DELT_FLG, 'N', '0', 'Y', '1') AS DELT_FLG" ).append("\n"); 
		query.append("FROM PRI_RAT_UT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${delt_flg} == '')" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rat_ut_cd} != '')" ).append("\n"); 
		query.append("AND RAT_UT_CD LIKE '%' || @[rat_ut_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rat_ut_grp_cd} != '')" ).append("\n"); 
		query.append("AND RAT_UT_GRP_CD = @[rat_ut_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RAT_UT_CD" ).append("\n"); 

	}
}