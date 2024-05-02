/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PRICommonDataDBDAOAddPercentBaseChargeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.04.19 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDataDBDAOAddPercentBaseChargeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * create PCT_BSE_CD
	  * </pre>
	  */
	public PRICommonDataDBDAOAddPercentBaseChargeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("patt_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pct_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration ").append("\n"); 
		query.append("FileName : PRICommonDataDBDAOAddPercentBaseChargeCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCG_PCT_BSE(" ).append("\n"); 
		query.append("            PCT_BSE_CD" ).append("\n"); 
		query.append("          , PATT_DESC" ).append("\n"); 
		query.append("          , DP_SEQ" ).append("\n"); 
		query.append("          , DELT_FLG" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT         )" ).append("\n"); 
		query.append("VALUES (    @[pct_bse_cd]              " ).append("\n"); 
		query.append("          , @[patt_desc]" ).append("\n"); 
		query.append("          , @[dp_seq]" ).append("\n"); 
		query.append("          , 'N'" ).append("\n"); 
		query.append("          , @[cre_usr_id]" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          , @[upd_usr_id]" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}