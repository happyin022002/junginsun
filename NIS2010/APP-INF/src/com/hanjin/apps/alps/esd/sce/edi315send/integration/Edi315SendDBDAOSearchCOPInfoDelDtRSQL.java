/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi315SendDBDAOSearchCOPInfoDelDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchCOPInfoDelDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCOPInfoDelDt
	  * </pre>
	  */
	public Edi315SendDBDAOSearchCOPInfoDelDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchCOPInfoDelDtRSQL").append("\n"); 
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
		query.append("TO_CHAR(E_T, 'YYYYMMDDHH24MI')                                                                                              DEL_ETA," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(E_T, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, E_T, 'GMT'), 'YYYYMMDDHH24MI')))      DEL_ETA_GMT ," ).append("\n"); 
		query.append("TO_CHAR(A_T, 'YYYYMMDDHH24MI')                                                                                              DEL_ATA," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(A_T, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, A_T, 'GMT'), 'YYYYMMDDHH24MI')))      DEL_ATA_GMT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  ESTM_DT		E_T," ).append("\n"); 
		query.append("CASE	WHEN ACT_DT IS NULL AND D.ACT_STS_CD = 'F' THEN ESTM_DT" ).append("\n"); 
		query.append("ELSE ACT_DT" ).append("\n"); 
		query.append("END			A_T ," ).append("\n"); 
		query.append("-- SUBSTR(H.DEL_NOD_CD, 0, 5) NOD ," ).append("\n"); 
		query.append("SUBSTR(D.NOD_CD, 0, 5)		NOD , -- CHM-201325206" ).append("\n"); 
		query.append("D.NOD_CD DEL_NOD" ).append("\n"); 
		query.append("FROM	SCE_COP_HDR			H," ).append("\n"); 
		query.append("PRD_PROD_CTL_MST	P,	  -- CHM-201325206" ).append("\n"); 
		query.append("SCE_COP_DTL			D" ).append("\n"); 
		query.append("WHERE	1	=	1" ).append("\n"); 
		query.append("AND		H.COP_NO		=	@[e_cop_no]" ).append("\n"); 
		query.append("AND		H.PCTL_NO		=	P.PCTL_NO" ).append("\n"); 
		query.append("AND		D.COP_NO		=	H.COP_NO" ).append("\n"); 
		query.append("AND		D.NOD_CD		=	-- CHM-201325206: csr-SCE USLGB/USLAX PEQ : DEL 지역 Plan 제거로 의해 VD 로 대체 -- By 장민지" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN P.POD_CD = 'USLAX' AND P.DEL_CD = 'USLGB' AND P.BKG_DE_TERM_CD = 'Y' THEN" ).append("\n"); 
		query.append("H.POD_NOD_CD" ).append("\n"); 
		query.append("WHEN P.POD_CD = 'USLGB' AND P.DEL_CD = 'USLAX' AND P.BKG_DE_TERM_CD = 'Y' THEN" ).append("\n"); 
		query.append("H.POD_NOD_CD" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("H.DEL_NOD_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND		SUBSTR(D.ACT_CD, 5, 1)	 -- CHM-201325206: csr-SCE USLGB/USLAX PEQ : DEL 지역 Plan 제거로 의해 VD 로 대체 -- By 장민지" ).append("\n"); 
		query.append("=	(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN P.POD_CD = 'USLAX' AND P.DEL_CD = 'USLGB' AND P.BKG_DE_TERM_CD = 'Y' THEN" ).append("\n"); 
		query.append("'U'" ).append("\n"); 
		query.append("WHEN P.POD_CD = 'USLGB' AND P.DEL_CD = 'USLAX' AND P.BKG_DE_TERM_CD = 'Y' THEN" ).append("\n"); 
		query.append("'U'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'A'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND		ROWNUM	=	1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}