/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOSearchRevenueVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.13
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.05.13 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOSearchRevenueVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revenue VVD 정보를 조회한다.
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOSearchRevenueVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrmon_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOSearchRevenueVvdListRSQL").append("\n"); 
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
		query.append("SELECT    SUBSTR(REV_YRMON, 1, 4) || '-' || SUBSTR(REV_YRMON, -2) AS REV_YRMON" ).append("\n"); 
		query.append("        , VSL_CD || SKD_VOY_NO || SKD_DIR_CD || RLANE_DIR_CD AS VVD" ).append("\n"); 
		query.append("        , SLAN_CD" ).append("\n"); 
		query.append("        , RLANE_CD" ).append("\n"); 
		query.append("        , REV_PORT_CD" ).append("\n"); 
		query.append("        , COM_VVD_FLG" ).append("\n"); 
		query.append("        , VVD_COM_LVL" ).append("\n"); 
		query.append("        , VOY_TP_CD" ).append("\n"); 
		query.append("        , DELT_FLG" ).append("\n"); 
		query.append("		, CRE_USR_ID" ).append("\n"); 
		query.append("        , TO_CHAR(CRE_DT     , 'YYYY-MM-DD HH24:MI:SS') AS CRE_DT" ).append("\n"); 
		query.append("        , TO_CHAR(EAI_EVNT_DT, 'YYYY-MM-DD HH24:MI:SS') AS EAI_EVNT_DT" ).append("\n"); 
		query.append("FROM    AR_MST_REV_VVD T" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("#if (${yrmon_fm} != '') " ).append("\n"); 
		query.append("AND     REV_YRMON      >= @[yrmon_fm]                 -- (입력파라메터 : Month FM)" ).append("\n"); 
		query.append("AND     REV_YRMON      <= @[yrmon_to]                 -- (입력파라메터 : Month TO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     DELT_FLG        = DECODE(@[del_cd], 'ALL', DELT_FLG, @[del_cd]) -- (입력파라메터 : DEL)" ).append("\n"); 
		query.append("#if (${s_vvd_cd} != '') " ).append("\n"); 
		query.append("-- VVD 정보가 입력될 경우" ).append("\n"); 
		query.append("AND		VSL_CD || SKD_VOY_NO || SKD_DIR_CD || RLANE_DIR_CD LIKE @[s_vvd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_slan_cd} != '') " ).append("\n"); 
		query.append("-- S/LANE 정보가 입력될 경우" ).append("\n"); 
		query.append("AND     SLAN_CD         LIKE @[s_slan_cd]||'%'               -- (입력파라메터 : S/LANE)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_rlane_cd} != '') " ).append("\n"); 
		query.append("-- S/LANE 정보가 입력될 경우" ).append("\n"); 
		query.append("AND     RLANE_CD        LIKE @[s_rlane_cd]||'%'              -- (입력파라메터 : R/LANE)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}