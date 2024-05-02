/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ReplanManageDBDAOSearchPartialCopsCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchPartialCopsCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * partial 관계로 엮인 cop의 갯수를 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchPartialCopsCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration ").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchPartialCopsCountRSQL").append("\n"); 
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
		query.append("COUNT(*) CNT" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (CNTR_NO, TRNK_VSL_CD, TRNK_SKD_VOY_NO, TRNK_SKD_DIR_CD) IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CNTR_NO, TRNK_VSL_CD, TRNK_SKD_VOY_NO, TRNK_SKD_DIR_CD FROM SCE_COP_HDR WHERE (CNTR_NO, BKG_NO) = ((@[cntr_no], @[bkg_no]))" ).append("\n"); 
		query.append("#if (${sts_flg} == 'C')" ).append("\n"); 
		query.append("AND COP_STS_CD IN ('C','T')" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'F')" ).append("\n"); 
		query.append("AND COP_STS_CD = 'F'" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'A')" ).append("\n"); 
		query.append("AND COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'X')" ).append("\n"); 
		query.append("AND COP_STS_CD = 'X'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${sts_flg} == 'C' or ${sts_flg} == 'X')" ).append("\n"); 
		query.append("AND COP_STS_CD IN ('C','T')" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'F')" ).append("\n"); 
		query.append("AND COP_STS_CD = 'F'" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'A')" ).append("\n"); 
		query.append("AND COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}