/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqYardOrzDBDAOSearchEQYARDManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.12.16 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.popup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Shin Han Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqYardOrzDBDAOSearchEQYARDManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEQYARDManage
	  * </pre>
	  */
	public EqYardOrzDBDAOSearchEQYARDManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_txt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_txt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_txt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_txt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.common.popup.integration").append("\n"); 
		query.append("FileName : EqYardOrzDBDAOSearchEQYARDManageRSQL").append("\n"); 
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
		query.append("#if (${dist} == 'rcc')" ).append("\n"); 
		query.append("select distinct(MC.RCC_CD) rcc_cd,DECODE(MC.DELT_FLG,'Y','RCC','N','RCC','','RCC') dist_cd" ).append("\n"); 
		query.append("from MDM_LOCATION ML, MDM_EQ_ORZ_CHT MC" ).append("\n"); 
		query.append("where ML.SCC_CD = MC.SCC_CD" ).append("\n"); 
		query.append("order by MC.RCC_CD" ).append("\n"); 
		query.append("#elseif (${dist} == 'lcc')" ).append("\n"); 
		query.append("select distinct(MC.LCC_CD) lcc_cd ,DECODE(MC.DELT_FLG,'Y','LCC','N','LCC','','LCC') dist_cd" ).append("\n"); 
		query.append("from MDM_LOCATION ML, MDM_EQ_ORZ_CHT MC" ).append("\n"); 
		query.append("where ML.SCC_CD = MC.SCC_CD" ).append("\n"); 
		query.append("#if (${rcc_txt} != '')" ).append("\n"); 
		query.append("and MC.RCC_CD= UPPER(@[rcc_txt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnt_txt} != '')" ).append("\n"); 
		query.append("and ML.CNT_CD= UPPER(@[cnt_txt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by MC.LCC_CD" ).append("\n"); 
		query.append("#elseif (${dist} == 'ecc')" ).append("\n"); 
		query.append("select distinct(MC.ECC_CD) ecc_cd ,DECODE(MC.DELT_FLG,'Y','ECC','N','ECC','','ECC') dist_cd" ).append("\n"); 
		query.append("from MDM_LOCATION ML, MDM_EQ_ORZ_CHT MC" ).append("\n"); 
		query.append("where ML.SCC_CD = MC.SCC_CD" ).append("\n"); 
		query.append("#if (${rcc_txt} != '')" ).append("\n"); 
		query.append("and MC.RCC_CD= UPPER(@[rcc_txt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lcc_txt} != '')" ).append("\n"); 
		query.append("and MC.LCC_CD= UPPER(@[lcc_txt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnt_txt} != '')" ).append("\n"); 
		query.append("and ML.CNT_CD= UPPER(@[cnt_txt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by MC.ECC_CD" ).append("\n"); 
		query.append("#elseif (${dist} == 'scc')" ).append("\n"); 
		query.append("select distinct(MC.SCC_CD) scc_cd ,DECODE(MC.DELT_FLG,'Y','SCC','N','SCC','','SCC') dist_cd" ).append("\n"); 
		query.append("from MDM_LOCATION ML, MDM_EQ_ORZ_CHT MC" ).append("\n"); 
		query.append("where ML.SCC_CD = MC.SCC_CD" ).append("\n"); 
		query.append("#if (${rcc_txt} != '')" ).append("\n"); 
		query.append("and MC.RCC_CD= UPPER(@[rcc_txt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lcc_txt} != '')" ).append("\n"); 
		query.append("and MC.LCC_CD= UPPER(@[lcc_txt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ecc_txt} != '')" ).append("\n"); 
		query.append("and MC.ECC_CD= UPPER(@[ecc_txt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnt_txt} != '')" ).append("\n"); 
		query.append("and ML.CNT_CD= UPPER(@[cnt_txt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by MC.SCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}