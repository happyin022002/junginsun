/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchLseCoYardInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.14 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchLseCoYardInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 임대사  Yard combo box 정보를 검색
	  * * EES_EQR_059 TAB3
	  * </pre>
	  */
	public CommonDBDAOSearchLseCoYardInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locyard_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locyard_searchword",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchLseCoYardInfoRSQL").append("\n"); 
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
		query.append("LSE_CO_YD_CD YD_CD" ).append("\n"); 
		query.append(",REPLACE(LSE_CO_YD_NM, '''', ' ') YD_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_LSE_CO_YD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("LSE_CO_VNDR_SEQ1 = @[locyard_vndr_seq]" ).append("\n"); 
		query.append("OR LSE_CO_VNDR_SEQ2 = @[locyard_vndr_seq]" ).append("\n"); 
		query.append("OR LSE_CO_VNDR_SEQ3 = @[locyard_vndr_seq]" ).append("\n"); 
		query.append("OR LSE_CO_VNDR_SEQ4 = @[locyard_vndr_seq]" ).append("\n"); 
		query.append("OR LSE_CO_VNDR_SEQ5 = @[locyard_vndr_seq]" ).append("\n"); 
		query.append("OR LSE_CO_VNDR_SEQ6 = @[locyard_vndr_seq]" ).append("\n"); 
		query.append("OR LSE_CO_VNDR_SEQ7 = @[locyard_vndr_seq]" ).append("\n"); 
		query.append("OR LSE_CO_VNDR_SEQ8 = @[locyard_vndr_seq]" ).append("\n"); 
		query.append("OR LSE_CO_VNDR_SEQ9 = @[locyard_vndr_seq]" ).append("\n"); 
		query.append("OR LSE_CO_VNDR_SEQ10 = @[locyard_vndr_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- modified by shinyongchan 20070604" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SUBSTR(LSE_CO_YD_CD, 0, 5) IN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SCC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("ECC_CD LIKE @[locyard_searchword]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 20070723 added by shin yongchan" ).append("\n"); 
		query.append("--AND  DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("AND  DELT_FLG <> @[delt_flg]" ).append("\n"); 
		query.append("ORDER BY LSE_CO_YD_CD" ).append("\n"); 

	}
}