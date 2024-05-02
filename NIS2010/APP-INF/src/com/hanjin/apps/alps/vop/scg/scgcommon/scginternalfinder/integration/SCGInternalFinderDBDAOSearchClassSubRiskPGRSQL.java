/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCGInternalFinderDBDAOSearchClassSubRiskPGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGInternalFinderDBDAOSearchClassSubRiskPGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IMDG UN NO, IMDG UN No Seq 별  Class, Sub Risk, PG
	  * </pre>
	  */
	public SCGInternalFinderDBDAOSearchClassSubRiskPGRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration").append("\n"); 
		query.append("FileName : SCGInternalFinderDBDAOSearchClassSubRiskPGRSQL").append("\n"); 
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
		query.append("SELECT	A.IMDG_CLSS_CD" ).append("\n"); 
		query.append("        , DECODE ( A.IMDG_PCK_GRP_CD, '1','I','2','II','3','III' ) AS IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("        , B.N1ST_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("        , B.N2ND_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("        , B.N3RD_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("        , B.N4TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("        , (DECODE(B.N1ST_IMDG_SUBS_RSK_LBL_CD,'0','',B.N1ST_IMDG_SUBS_RSK_LBL_CD)||DECODE(NVL(B.N2ND_IMDG_SUBS_RSK_LBL_CD,''),'','','0','','/')" ).append("\n"); 
		query.append("           ||DECODE(B.N2ND_IMDG_SUBS_RSK_LBL_CD,'0','',B.N2ND_IMDG_SUBS_RSK_LBL_CD)||DECODE(NVL(B.N3RD_IMDG_SUBS_RSK_LBL_CD,''),'','','0','','/')" ).append("\n"); 
		query.append("           ||DECODE(B.N3RD_IMDG_SUBS_RSK_LBL_CD,'0','',B.N3RD_IMDG_SUBS_RSK_LBL_CD)||DECODE(NVL(B.N4TH_IMDG_SUBS_RSK_LBL_CD,''),'','','0','','/')" ).append("\n"); 
		query.append("           ||DECODE(B.N4TH_IMDG_SUBS_RSK_LBL_CD,'0','',B.N4TH_IMDG_SUBS_RSK_LBL_CD)) AS IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("		, A.PRP_SHP_NM" ).append("\n"); 
		query.append("FROM	SCG_IMDG_UN_NO A, " ).append("\n"); 
		query.append("	(	SELECT  IMDG_UN_NO, IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                , MAX ( DECODE ( RNUM, 1, IMDG_SUBS_RSK_LBL_CD, NULL ) ) AS N1ST_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("                , MAX ( DECODE ( RNUM, 2, IMDG_SUBS_RSK_LBL_CD, NULL ) ) AS N2ND_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("                , MAX ( DECODE ( RNUM, 3, IMDG_SUBS_RSK_LBL_CD, NULL ) ) AS N3RD_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("                , MAX ( DECODE ( RNUM, 4, IMDG_SUBS_RSK_LBL_CD, NULL ) ) AS N4TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (       " ).append("\n"); 
		query.append("        SELECT  IMDG_UN_NO, IMDG_UN_NO_SEQ, IMDG_SUBS_RSK_LBL_CD, ROW_NUMBER () OVER ( ORDER BY IMDG_SUBS_RSK_LBL_CD ) RNUM" ).append("\n"); 
		query.append("        FROM    SCG_IMDG_SUBS_RSK_LBL" ).append("\n"); 
		query.append("        WHERE   IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("        AND     IMDG_UN_NO_SEQ = @[imdg_un_no_seq] ) " ).append("\n"); 
		query.append("        GROUP   BY   IMDG_UN_NO, IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("    )   B" ).append("\n"); 
		query.append("WHERE	A.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("AND		A.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("AND     A.IMDG_UN_NO = B.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND     A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ(+)" ).append("\n"); 

	}
}