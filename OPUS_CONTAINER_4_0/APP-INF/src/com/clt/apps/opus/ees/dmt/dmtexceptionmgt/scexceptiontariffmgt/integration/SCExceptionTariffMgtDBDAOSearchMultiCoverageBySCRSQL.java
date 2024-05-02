/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchMultiCoverageBySCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchMultiCoverageBySCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C별 DEM/DET 등록된 특별 계약 내용 중 Multi Coverage 정보데이터를 조회하는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchMultiCoverageBySCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchMultiCoverageBySCRSQL").append("\n"); 
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
		query.append("SELECT	B.PROP_NO" ).append("\n"); 
		query.append("	,	B.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	,	B.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("	,	B.CVRG_SEQ" ).append("\n"); 
		query.append("	,	B.CNT_CD" ).append("\n"); 
		query.append("	,	B.RGN_CD" ).append("\n"); 
		query.append("	,	B.STE_CD" ).append("\n"); 
		query.append("	,	B.LOC_CD" ).append("\n"); 
		query.append("	,	B.CRE_USR_ID" ).append("\n"); 
		query.append("	,	B.CRE_DT" ).append("\n"); 
		query.append("	,	B.UPD_USR_ID" ).append("\n"); 
		query.append("	,	B.UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("            SELECT  PROP_NO, SC_EXPT_VER_SEQ, SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("            FROM    DMT_SC_EXPT_CVRG" ).append("\n"); 
		query.append("			WHERE	PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("				AND SC_EXPT_VER_SEQ = @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("				AND SC_EXPT_GRP_SEQ = @[sc_expt_grp_seq]" ).append("\n"); 
		query.append("            GROUP BY PROP_NO, SC_EXPT_VER_SEQ, SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("            HAVING COUNT(PROP_NO) > 1" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("	, 	DMT_SC_EXPT_CVRG B" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("WHERE	A.PROP_NO 			= B.PROP_NO" ).append("\n"); 
		query.append("	AND A.SC_EXPT_VER_SEQ 	= B.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	AND A.SC_EXPT_GRP_SEQ 	= B.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY SC_EXPT_GRP_SEQ, CVRG_SEQ" ).append("\n"); 

	}
}