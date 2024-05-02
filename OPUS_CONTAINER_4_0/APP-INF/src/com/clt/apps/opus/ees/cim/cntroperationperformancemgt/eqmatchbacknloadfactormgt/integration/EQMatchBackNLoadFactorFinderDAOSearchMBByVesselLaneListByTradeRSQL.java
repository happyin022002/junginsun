/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EQMatchBackNLoadFactorFinderDAOSearchMBByVesselLaneListByTradeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorFinderDAOSearchMBByVesselLaneListByTradeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LANE LIST
	  * 2010.09.15 이병훈 [CHM-201005967-01] Match-Back by Vessel의 신규 Trade 및 노선 추가
	  * </pre>
	  */
	public EQMatchBackNLoadFactorFinderDAOSearchMBByVesselLaneListByTradeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorFinderDAOSearchMBByVesselLaneListByTradeRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("		SUBSTR(A.RLANE_CD,1,3)||'|'||A.RLANE_NM" ).append("\n"); 
		query.append("FROM	MDM_REV_LANE A, MDM_DTL_REV_LANE B, MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("WHERE	A.RLANE_CD		= B.RLANE_CD" ).append("\n"); 
		query.append("AND		A.VSL_TP_CD		= 'C'" ).append("\n"); 
		query.append("AND		B.DELT_FLG	IN ('N', NULL)" ).append("\n"); 
		query.append("AND		B.TRD_CD	<> 'COM'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == '' )" ).append("\n"); 
		query.append("AND		B.TRD_CD	= B.TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == 'IMS' )" ).append("\n"); 
		query.append("AND		B.TRD_CD	IN ( 'TAS','TPS' )" ).append("\n"); 
		query.append("AND		B.FM_CONTI_CD = 'M'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == 'IES' )" ).append("\n"); 
		query.append("AND		B.TRD_CD	IN ( 'AES','TAS' )" ).append("\n"); 
		query.append("AND		B.FM_CONTI_CD = 'E'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == 'AES' )" ).append("\n"); 
		query.append("AND		B.TRD_CD	=  'AES'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == 'TPS' )" ).append("\n"); 
		query.append("AND		B.TRD_CD	=  'TPS'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == 'TAS' )" ).append("\n"); 
		query.append("AND		B.TRD_CD	=  'TAS'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == 'EMS' )" ).append("\n"); 
		query.append("AND		B.TRD_CD	=  'EMS'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND		DECODE(C.VSL_SVC_TP_CD,'I',C.CO_CD,'1') = DECODE(C.VSL_SVC_TP_CD,'I','O','1')" ).append("\n"); 
		query.append("AND		C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        SUBSTR(A.RLANE_CD,1,3)||'|'||A.RLANE_NM" ).append("\n"); 

	}
}