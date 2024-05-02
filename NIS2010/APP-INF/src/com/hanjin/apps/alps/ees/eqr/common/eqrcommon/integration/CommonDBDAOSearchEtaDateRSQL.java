/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchEtaDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.31 정은호
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

public class CommonDBDAOSearchEtaDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search eta date 검색
	  * INLAND(080), ON-OFF HIRE(081) 에서 사용함 
	  * item=R, fryard cnt=US||CA && toyard cnt= US||CA 인 경우는 다른 조회쿼리를 사용함.
	  * </pre>
	  */
	public CommonDBDAOSearchEtaDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fryard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("item",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toyard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchEtaDateRSQL").append("\n"); 
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
		query.append("-- RAIL-US 가 아닌 쿼리로 ETA 조회함" ).append("\n"); 
		query.append("#if(${railMode} == 'N')" ).append("\n"); 
		query.append("--SELECT TO_CHAR(TO_DATE(?)+ROUND(B.TZTM_HRS), 'YYYYMMDD') ETA" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[etd],'YYYYMMDD')+ROUND(B.TZTM_HRS/24), 'YYYYMMDD') ETA" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(TZTM_HRS, 0) TZTM_HRS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_EACH_LNK" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("LNK_ORG_NOD_CD = @[fryard]" ).append("\n"); 
		query.append("AND   LNK_DEST_NOD_CD= @[toyard]" ).append("\n"); 
		query.append("AND   SUBSTR(TRSP_MOD_CD, 0,1) = @[item]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${item} == 'W')" ).append("\n"); 
		query.append("-- item=W 인 경우만 적용됩니다." ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("-- ONLY WATER" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TZTM_HRS TZTM_HRS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_FDR_LNK" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("LNK_ORG_NOD_CD = @[fryard]" ).append("\n"); 
		query.append("AND   LNK_DEST_NOD_CD= @[toyard]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("-- RAIL-US 쿼리로 ETA 조회함" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[etd],'YYYYMMDD')+ROUND(SUM(L.TZTM_HRS)/24), 'YYYYMMDD') ETA" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL D," ).append("\n"); 
		query.append("PRD_INLND_ROUT_MST M," ).append("\n"); 
		query.append("PRD_INLND_EACH_LNK L" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("M.ROUT_ORG_NOD_CD  = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   M.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   M.ROUT_SEQ         = D.ROUT_SEQ" ).append("\n"); 
		query.append("AND   M.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("AND   M.PCTL_IO_BND_CD   = 'M'" ).append("\n"); 
		query.append("AND   M.ROUT_ORG_NOD_CD  = @[fryard]   -- FM YARD" ).append("\n"); 
		query.append("AND   M.ROUT_DEST_NOD_CD = @[toyard]   -- TO YARD" ).append("\n"); 
		query.append("AND   D.TRSP_MOD_CD      = 'RD'" ).append("\n"); 
		query.append("AND   D.LNK_ORG_NOD_CD   = L.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   D.LNK_DEST_NOD_CD  = L.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   D.TRSP_MOD_CD      = L.TRSP_MOD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}