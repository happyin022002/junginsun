/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCGInternalFinderDBDAOSearchUNNumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
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

public class SCGInternalFinderDBDAOSearchUNNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public SCGInternalFinderDBDAOSearchUNNumberRSQL(){
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
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration").append("\n"); 
		query.append("FileName : SCGInternalFinderDBDAOSearchUNNumberRSQL").append("\n"); 
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
		query.append("SELECT  ''iPage,S.IMDG_UN_NO                        ," ).append("\n"); 
		query.append("                S.IMDG_UN_NO_SEQ                    ," ).append("\n"); 
		query.append("                S.PRP_SHP_NM                        ," ).append("\n"); 
		query.append("                S.IMDG_CLSS_CD                      ," ).append("\n"); 
		query.append("                S.IMDG_COMP_GRP_CD                  ," ).append("\n"); 
		query.append("                S.IMDG_SUBS_RSK_LBL_RMK             ," ).append("\n"); 
		query.append("                S.IMDG_MRN_POLUT_CD                 ," ).append("\n"); 
		query.append("                S.IMDG_PCK_GRP_CD                   ," ).append("\n"); 
		query.append("                S.IMDG_LMT_QTY                      ," ).append("\n"); 
		query.append("                S.IMDG_LMT_QTY_MEAS_UT_CD           ," ).append("\n"); 
		query.append("                S.IMDG_EXPT_QTY_CD                  ," ).append("\n"); 
		query.append("                S.IMDG_EMER_NO                      ," ).append("\n"); 
		query.append("                S.IMDG_STWG_CATE_CD                 ," ).append("\n"); 
		query.append("                S.FLSH_PNT_TEMP_CTNT                ," ).append("\n"); 
		query.append("                S.EMER_RSPN_GID_NO                  ," ).append("\n"); 
		query.append("                S.EMER_RSPN_GID_CHR_NO              ," ).append("\n"); 
		query.append("                S.PSA_NO                            ," ).append("\n"); 
		query.append("                S.N1ST_BOM_PORT_TRST_NO             ," ).append("\n"); 
		query.append("                S.N2ND_BOM_PORT_TRST_NO             ," ).append("\n"); 
		query.append("                S.N3RD_BOM_PORT_TRST_NO             ," ).append("\n"); 
		query.append("                S.N4TH_BOM_PORT_TRST_NO             ," ).append("\n"); 
		query.append("                S.PKG_AUTH_NO                       ," ).append("\n"); 
		query.append("                S.LK_PORT_AUTH_NO                   ," ).append("\n"); 
		query.append("                S.IMDG_SBST_PPT_DESC                ," ).append("\n"); 
		query.append("                S.CFR_RPT_QTY                       ," ).append("\n"); 
		query.append("                S.CFR_PSN_INH_ZN_CD                 ," ).append("\n"); 
		query.append("                S.CFR_TOXC_CD                       ," ).append("\n"); 
		query.append("                S.CFR_DG_WET_CD                     ," ).append("\n"); 
		query.append("                S.CFR_RSTR_PORT_NM                  ," ).append("\n"); 
		query.append("                S.CFR_RSTR_OPR_NM                   ," ).append("\n"); 
		query.append("                S.CFR_XTD_CLSS_CD                   ," ).append("\n"); 
		query.append("                S.HCDG_FLG                          ," ).append("\n"); 
		query.append("                S.HCDG_DPND_QTY_FLG                 ," ).append("\n"); 
		query.append("                S.HCDG_RMK                          ," ).append("\n"); 
		query.append("                S.N1ST_IMDG_PCK_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N2ND_IMDG_PCK_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N3RD_IMDG_PCK_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N1ST_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N2ND_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N3RD_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N4TH_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N5TH_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N1ST_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N2ND_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N3RD_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N4TH_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N5TH_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N1ST_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N2ND_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N3RD_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N4TH_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N5TH_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N1ST_IMDG_UN_TNK_INSTR_CD         ," ).append("\n"); 
		query.append("                S.N2ND_IMDG_UN_TNK_INSTR_CD         ," ).append("\n"); 
		query.append("                S.N1ST_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                S.N2ND_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                S.N3RD_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                S.N4TH_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                S.N5TH_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                S.HCDG_PCK_RSTR_DESC                ," ).append("\n"); 
		query.append("                S.HCDG_INTMD_BC_RSTR_DESC           ," ).append("\n"); 
		query.append("                S.HCDG_TNK_RSTR_DESC                ," ).append("\n"); 
		query.append("                S.SEGR_DESC                         ," ).append("\n"); 
		query.append("                S.CLR_LIV_QTR_STWG_FLG              ," ).append("\n"); 
		query.append("                S.IMDG_FD_STUF_STWG_CD              ," ).append("\n"); 
		query.append("                S.IMDG_HT_SRC_STWG_CD               ," ).append("\n"); 
		query.append("                S.SEGR_AS_FOR_IMDG_CLSS_FLG         ," ).append("\n"); 
		query.append("                S.SEGR_AS_FOR_IMDG_CLSS_CD          ," ).append("\n"); 
		query.append("                S.AWAY_FM_IMDG_CLSS_FLG             ," ).append("\n"); 
		query.append("                S.SPRT_FM_IMDG_CLSS_FLG             ," ).append("\n"); 
		query.append("                S.AWAY_FM_IMDG_SEGR_GRP_FLG         ," ).append("\n"); 
		query.append("                S.SPRT_FM_IMDG_SEGR_GRP_FLG         ," ).append("\n"); 
		query.append("                S.IMDG_TBL_NO                       ," ).append("\n"); 
		query.append("                S.IMDG_UN_NO_HLD_FLG                ," ).append("\n"); 
		query.append("                S.IMDG_LMT_QTY_DESC                 ," ).append("\n"); 
		query.append("                S.IMDG_EXPT_QTY_DESC                ," ).append("\n"); 
		query.append("                S.CRE_USR_ID                        ," ).append("\n"); 
		query.append("                S.CRE_DT                            ," ).append("\n"); 
		query.append("                S.UPD_USR_ID                        ," ).append("\n"); 
		query.append("                S.UPD_DT							," ).append("\n"); 
		query.append("				S.IMDG_TEC_NM						," ).append("\n"); 
		query.append("                S.IMDG_CRR_RSTR_EXPT_CD				," ).append("\n"); 
		query.append("                S.IMDG_CRR_RSTR_EXPT_NM				," ).append("\n"); 
		query.append("				S.IMDG_CLSS_CD_DESC," ).append("\n"); 
		query.append("		        NVL(MAX(CASE  WHEN S.RN = 1 THEN S.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("        		NVL(MAX(CASE  WHEN S.RN = 2 THEN '/'||S.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("		        NVL(MAX(CASE  WHEN S.RN = 3 THEN '/'||S.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("        		NVL(MAX(CASE  WHEN S.RN = 4 THEN '/'||S.IMDG_SUBS_RSK_LBL_CD  END),'')  IMDG_SUBS_RSK_LBL_CD        " ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT    " ).append("\n"); 
		query.append("                A.IMDG_UN_NO                        ," ).append("\n"); 
		query.append("                A.IMDG_UN_NO_SEQ                    ," ).append("\n"); 
		query.append("                A.PRP_SHP_NM                        ," ).append("\n"); 
		query.append("                A.IMDG_CLSS_CD                      ," ).append("\n"); 
		query.append("                A.IMDG_COMP_GRP_CD                  ," ).append("\n"); 
		query.append("                A.IMDG_SUBS_RSK_LBL_RMK             ," ).append("\n"); 
		query.append("                A.IMDG_MRN_POLUT_CD                 ," ).append("\n"); 
		query.append("				CASE WHEN A.IMDG_PCK_GRP_CD='1' THEN  'I' " ).append("\n"); 
		query.append("				     WHEN A.IMDG_PCK_GRP_CD='2' THEN  'II'" ).append("\n"); 
		query.append("					 WHEN A.IMDG_PCK_GRP_CD='3' THEN  'III'  END IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("                A.IMDG_LMT_QTY                      ," ).append("\n"); 
		query.append("                A.IMDG_LMT_QTY_MEAS_UT_CD           ," ).append("\n"); 
		query.append("                A.IMDG_EXPT_QTY_CD                  ," ).append("\n"); 
		query.append("                A.IMDG_EMER_NO                      ," ).append("\n"); 
		query.append("                A.IMDG_STWG_CATE_CD                 ," ).append("\n"); 
		query.append("                A.FLSH_PNT_TEMP_CTNT                ," ).append("\n"); 
		query.append("                A.EMER_RSPN_GID_NO                  ," ).append("\n"); 
		query.append("                A.EMER_RSPN_GID_CHR_NO              ," ).append("\n"); 
		query.append("                A.PSA_NO                            ," ).append("\n"); 
		query.append("                A.N1ST_BOM_PORT_TRST_NO             ," ).append("\n"); 
		query.append("                A.N2ND_BOM_PORT_TRST_NO             ," ).append("\n"); 
		query.append("                A.N3RD_BOM_PORT_TRST_NO             ," ).append("\n"); 
		query.append("                A.N4TH_BOM_PORT_TRST_NO             ," ).append("\n"); 
		query.append("                A.PKG_AUTH_NO                       ," ).append("\n"); 
		query.append("                A.LK_PORT_AUTH_NO                   ," ).append("\n"); 
		query.append("                A.IMDG_SBST_PPT_DESC                ," ).append("\n"); 
		query.append("                A.CFR_RPT_QTY                       ," ).append("\n"); 
		query.append("                A.CFR_PSN_INH_ZN_CD                 ," ).append("\n"); 
		query.append("                A.CFR_TOXC_CD                       ," ).append("\n"); 
		query.append("                A.CFR_DG_WET_CD                     ," ).append("\n"); 
		query.append("                A.CFR_RSTR_PORT_NM                  ," ).append("\n"); 
		query.append("                A.CFR_RSTR_OPR_NM                   ," ).append("\n"); 
		query.append("                A.CFR_XTD_CLSS_CD                   ," ).append("\n"); 
		query.append("                A.HCDG_FLG                          ," ).append("\n"); 
		query.append("                A.HCDG_DPND_QTY_FLG                 ," ).append("\n"); 
		query.append("                A.HCDG_RMK                          ," ).append("\n"); 
		query.append("                A.N1ST_IMDG_PCK_INSTR_CD            ," ).append("\n"); 
		query.append("                A.N2ND_IMDG_PCK_INSTR_CD            ," ).append("\n"); 
		query.append("                A.N3RD_IMDG_PCK_INSTR_CD            ," ).append("\n"); 
		query.append("                A.N1ST_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                A.N2ND_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                A.N3RD_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                A.N4TH_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                A.N5TH_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                A.N1ST_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                A.N2ND_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                A.N3RD_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                A.N4TH_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                A.N5TH_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                A.N1ST_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                A.N2ND_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                A.N3RD_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                A.N4TH_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                A.N5TH_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                A.N1ST_IMDG_UN_TNK_INSTR_CD         ," ).append("\n"); 
		query.append("                A.N2ND_IMDG_UN_TNK_INSTR_CD         ," ).append("\n"); 
		query.append("                A.N1ST_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                A.N2ND_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                A.N3RD_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                A.N4TH_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                A.N5TH_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                A.HCDG_PCK_RSTR_DESC                ," ).append("\n"); 
		query.append("                A.HCDG_INTMD_BC_RSTR_DESC           ," ).append("\n"); 
		query.append("                A.HCDG_TNK_RSTR_DESC                ," ).append("\n"); 
		query.append("                A.SEGR_DESC                         ," ).append("\n"); 
		query.append("                A.CLR_LIV_QTR_STWG_FLG              ," ).append("\n"); 
		query.append("                A.IMDG_FD_STUF_STWG_CD              ," ).append("\n"); 
		query.append("                A.IMDG_HT_SRC_STWG_CD               ," ).append("\n"); 
		query.append("                A.SEGR_AS_FOR_IMDG_CLSS_FLG         ," ).append("\n"); 
		query.append("                A.SEGR_AS_FOR_IMDG_CLSS_CD          ," ).append("\n"); 
		query.append("                A.AWAY_FM_IMDG_CLSS_FLG             ," ).append("\n"); 
		query.append("                A.SPRT_FM_IMDG_CLSS_FLG             ," ).append("\n"); 
		query.append("                A.AWAY_FM_IMDG_SEGR_GRP_FLG         ," ).append("\n"); 
		query.append("                A.SPRT_FM_IMDG_SEGR_GRP_FLG         ," ).append("\n"); 
		query.append("                A.IMDG_TBL_NO                       ," ).append("\n"); 
		query.append("                A.IMDG_UN_NO_HLD_FLG                ," ).append("\n"); 
		query.append("                A.IMDG_LMT_QTY_DESC                 ," ).append("\n"); 
		query.append("                A.IMDG_EXPT_QTY_DESC                ," ).append("\n"); 
		query.append("                A.CRE_USR_ID                        ," ).append("\n"); 
		query.append("                A.CRE_DT                            ," ).append("\n"); 
		query.append("                A.UPD_USR_ID                        ," ).append("\n"); 
		query.append("                A.UPD_DT     						," ).append("\n"); 
		query.append("	        (	SELECT  B.IMDG_TEC_NM  " ).append("\n"); 
		query.append("				FROM 	SCG_IMDG_UN_NO_ORG_RACT B " ).append("\n"); 
		query.append("          		WHERE   A.IMDG_UN_NO_SEQ   = B.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("            	AND   	A.IMDG_UN_NO       = B.IMDG_UN_NO ) IMDG_TEC_NM," ).append("\n"); 
		query.append("				C.IMDG_CRR_RSTR_EXPT_CD				," ).append("\n"); 
		query.append("				C.IMDG_CRR_RSTR_EXPT_NM				," ).append("\n"); 
		query.append("        	(	SELECT  B.IMDG_CLSS_CD_DESC  " ).append("\n"); 
		query.append("				FROM 	SCG_IMDG_CLSS_CD B " ).append("\n"); 
		query.append("          		WHERE   A.IMDG_CLSS_CD = B.IMDG_CLSS_CD ) IMDG_CLSS_CD_DESC," ).append("\n"); 
		query.append("		        ROW_NUMBER()OVER(PARTITION BY A.IMDG_UN_NO,A.IMDG_UN_NO_SEQ ORDER BY  IMDG_SUBS_RSK_LBL_CD) RN," ).append("\n"); 
		query.append("				B.IMDG_SUBS_RSK_LBL_CD				," ).append("\n"); 
		query.append("				ROW_NUMBER() OVER (ORDER BY A.IMDG_UN_NO, A.IMDG_UN_NO_SEQ )  no " ).append("\n"); 
		query.append("        FROM  SCG_IMDG_UN_NO A, SCG_IMDG_SUBS_RSK_LBL B," ).append("\n"); 
		query.append("		(	SELECT 	IMDG_UN_NO" ).append("\n"); 
		query.append("				, 	IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("				,	SUBSTR(XMLAGG(XMLELEMENT(X, ', ' || IMDG_CRR_RSTR_EXPT_CD) ORDER BY IMDG_CRR_RSTR_EXPT_CD).EXTRACT('//text()'), 2) AS IMDG_CRR_RSTR_EXPT_CD" ).append("\n"); 
		query.append("				,	SUBSTR(XMLAGG(XMLELEMENT(X, ', ' || DECODE(IMDG_CRR_RSTR_EXPT_CD,	'P','Prohibited'," ).append("\n"); 
		query.append("																						'R','Restricted'," ).append("\n"); 
		query.append("																						'C','Excepted fm Class Prohibition'," ).append("\n"); 
		query.append("																						'T','T/S Prohibited'," ).append("\n"); 
		query.append("																						'L','Prohibited on '||SLAN_CD||' Lane') ) " ).append("\n"); 
		query.append("								  ORDER BY IMDG_CRR_RSTR_EXPT_CD).EXTRACT('//text()'), 2) AS IMDG_CRR_RSTR_EXPT_NM" ).append("\n"); 
		query.append("			FROM SCG_IMDG_CRR_RSTR " ).append("\n"); 
		query.append("			WHERE VSL_OPR_TP_CD = 'SML'" ).append("\n"); 
		query.append("			GROUP BY IMDG_UN_NO, IMDG_UN_NO_SEQ) C" ).append("\n"); 
		query.append("        WHERE 	1 = 1" ).append("\n"); 
		query.append("        AND   	A.IMDG_UN_NO     = B.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("        AND   	A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("		AND		A.IMDG_UN_NO 	 = C.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("		AND 	A.IMDG_UN_NO_SEQ = C.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("        #if (${imdg_un_no} != '') " ).append("\n"); 
		query.append("           AND   A.IMDG_UN_NO       = @[imdg_un_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${imdg_un_no_seq} != '')" ).append("\n"); 
		query.append("              AND   A.IMDG_UN_NO_SEQ   = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       )S" ).append("\n"); 
		query.append(" WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${startpart} != '')" ).append("\n"); 
		query.append("      AND no BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("GROUP BY        S.IMDG_UN_NO                        ," ).append("\n"); 
		query.append("                S.IMDG_UN_NO_SEQ                    ," ).append("\n"); 
		query.append("                S.PRP_SHP_NM                        ," ).append("\n"); 
		query.append("                S.IMDG_CLSS_CD                      ," ).append("\n"); 
		query.append("                S.IMDG_COMP_GRP_CD                  ," ).append("\n"); 
		query.append("                S.IMDG_SUBS_RSK_LBL_RMK             ," ).append("\n"); 
		query.append("                S.IMDG_MRN_POLUT_CD                 ," ).append("\n"); 
		query.append("                S.IMDG_PCK_GRP_CD                   ," ).append("\n"); 
		query.append("                S.IMDG_LMT_QTY                      ," ).append("\n"); 
		query.append("                S.IMDG_LMT_QTY_MEAS_UT_CD           ," ).append("\n"); 
		query.append("                S.IMDG_EXPT_QTY_CD                  ," ).append("\n"); 
		query.append("                S.IMDG_EMER_NO                      ," ).append("\n"); 
		query.append("                S.IMDG_STWG_CATE_CD                 ," ).append("\n"); 
		query.append("                S.FLSH_PNT_TEMP_CTNT                ," ).append("\n"); 
		query.append("                S.EMER_RSPN_GID_NO                  ," ).append("\n"); 
		query.append("                S.EMER_RSPN_GID_CHR_NO              ," ).append("\n"); 
		query.append("                S.PSA_NO                            ," ).append("\n"); 
		query.append("                S.N1ST_BOM_PORT_TRST_NO             ," ).append("\n"); 
		query.append("                S.N2ND_BOM_PORT_TRST_NO             ," ).append("\n"); 
		query.append("                S.N3RD_BOM_PORT_TRST_NO             ," ).append("\n"); 
		query.append("                S.N4TH_BOM_PORT_TRST_NO             ," ).append("\n"); 
		query.append("                S.PKG_AUTH_NO                       ," ).append("\n"); 
		query.append("                S.LK_PORT_AUTH_NO                   ," ).append("\n"); 
		query.append("                S.IMDG_SBST_PPT_DESC                ," ).append("\n"); 
		query.append("                S.CFR_RPT_QTY                       ," ).append("\n"); 
		query.append("                S.CFR_PSN_INH_ZN_CD                 ," ).append("\n"); 
		query.append("                S.CFR_TOXC_CD                       ," ).append("\n"); 
		query.append("                S.CFR_DG_WET_CD                     ," ).append("\n"); 
		query.append("                S.CFR_RSTR_PORT_NM                  ," ).append("\n"); 
		query.append("                S.CFR_RSTR_OPR_NM                   ," ).append("\n"); 
		query.append("                S.CFR_XTD_CLSS_CD                   ," ).append("\n"); 
		query.append("                S.HCDG_FLG                          ," ).append("\n"); 
		query.append("                S.HCDG_DPND_QTY_FLG                 ," ).append("\n"); 
		query.append("                S.HCDG_RMK                          ," ).append("\n"); 
		query.append("                S.N1ST_IMDG_PCK_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N2ND_IMDG_PCK_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N3RD_IMDG_PCK_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N1ST_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N2ND_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N3RD_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N4TH_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N5TH_IMDG_PCK_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N1ST_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N2ND_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N3RD_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N4TH_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N5TH_IMDG_IBC_INSTR_CD            ," ).append("\n"); 
		query.append("                S.N1ST_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N2ND_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N3RD_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N4TH_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N5TH_IMDG_IBC_PROVI_CD            ," ).append("\n"); 
		query.append("                S.N1ST_IMDG_UN_TNK_INSTR_CD         ," ).append("\n"); 
		query.append("                S.N2ND_IMDG_UN_TNK_INSTR_CD         ," ).append("\n"); 
		query.append("                S.N1ST_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                S.N2ND_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                S.N3RD_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                S.N4TH_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                S.N5TH_IMDG_TNK_INSTR_PROVI_CD      ," ).append("\n"); 
		query.append("                S.HCDG_PCK_RSTR_DESC                ," ).append("\n"); 
		query.append("                S.HCDG_INTMD_BC_RSTR_DESC           ," ).append("\n"); 
		query.append("                S.HCDG_TNK_RSTR_DESC                ," ).append("\n"); 
		query.append("                S.SEGR_DESC                         ," ).append("\n"); 
		query.append("                S.CLR_LIV_QTR_STWG_FLG              ," ).append("\n"); 
		query.append("                S.IMDG_FD_STUF_STWG_CD              ," ).append("\n"); 
		query.append("                S.IMDG_HT_SRC_STWG_CD               ," ).append("\n"); 
		query.append("                S.SEGR_AS_FOR_IMDG_CLSS_FLG         ," ).append("\n"); 
		query.append("                S.SEGR_AS_FOR_IMDG_CLSS_CD          ," ).append("\n"); 
		query.append("                S.AWAY_FM_IMDG_CLSS_FLG             ," ).append("\n"); 
		query.append("                S.SPRT_FM_IMDG_CLSS_FLG             ," ).append("\n"); 
		query.append("                S.AWAY_FM_IMDG_SEGR_GRP_FLG         ," ).append("\n"); 
		query.append("                S.SPRT_FM_IMDG_SEGR_GRP_FLG         ," ).append("\n"); 
		query.append("                S.IMDG_TBL_NO                       ," ).append("\n"); 
		query.append("                S.IMDG_UN_NO_HLD_FLG                ," ).append("\n"); 
		query.append("                S.IMDG_LMT_QTY_DESC                 ," ).append("\n"); 
		query.append("                S.IMDG_EXPT_QTY_DESC                ," ).append("\n"); 
		query.append("                S.CRE_USR_ID                        ," ).append("\n"); 
		query.append("                S.CRE_DT                            ," ).append("\n"); 
		query.append("                S.UPD_USR_ID                        ," ).append("\n"); 
		query.append("                S.UPD_DT							," ).append("\n"); 
		query.append("				S.IMDG_TEC_NM						," ).append("\n"); 
		query.append("                S.IMDG_CRR_RSTR_EXPT_CD				," ).append("\n"); 
		query.append("				S.IMDG_CRR_RSTR_EXPT_NM				," ).append("\n"); 
		query.append("				S.IMDG_CLSS_CD_DESC     " ).append("\n"); 
		query.append("         ORDER BY  S.IMDG_UN_NO,S.IMDG_UN_NO_SEQ" ).append("\n"); 

	}
}