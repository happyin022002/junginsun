/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BkgCopManageDBDAOAddSceEdiHisForVCLCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.18 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOAddSceEdiHisForVCLCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG에서 VVD 변경시 315 EDI Event 'VCL'을 발송하기 위해 SCE_EDI_HIS에 발송 대상 data를 insert 한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOAddSceEdiHisForVCLCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOAddSceEdiHisForVCLCSQL").append("\n"); 
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
		query.append("INSERT ALL " ).append("\n"); 
		query.append("WHEN 1=1" ).append("\n"); 
		query.append("AND EDI_STND_STS_CD IN  ('VCL') " ).append("\n"); 
		query.append("-- VL 이전에만 VCL을 전송한다." ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_COP_DTL D WHERE COP_NO_TMP = D.COP_NO AND D.COP_DTL_SEQ < 4000 AND D.ACT_STS_CD = 'C') " ).append("\n"); 
		query.append("THEN INTO SCE_EDI_HIS (EDI_RCV_DT, EDI_RCV_SEQ, EDI_STND_STS_CD, CUST_EDI_STS_CD, ACT_STS_MAPG_CD, COP_ACT_CD, BKG_NO, BL_NO, CNTR_NO, COP_NO, COP_DTL_SEQ, COST_ACT_GRP_SEQ , CRNT_VSL_CD, CRNT_SKD_VOY_NO , CRNT_SKD_DIR_CD, EDI_EVNT_DT, EVNT_YD_CD, CLPT_IND_SEQ, SRC_MDL_ID, EDI_IF_STS_CD, IF_RMK, EDI_CUST_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES (EDI_RCV_DT, SCE_EDI_HIS_SEQ.NEXTVAL, EDI_STND_STS_CD, CUST_EDI_STS_CD, ACT_STS_MAPG_CD, COP_ACT_CD, BKG_NO, BL_NO, CNTR_NO, COP_NO_TMP, COP_DTL_SEQ, COST_ACT_GRP_SEQ , CRNT_VSL_CD, CRNT_SKD_VOY_NO , CRNT_SKD_DIR_CD, EDI_EVNT_DT, EVNT_YD_CD, CLPT_IND_SEQ, SRC_MDL_ID, EDI_IF_STS_CD, IF_RMK, EDI_CUST_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN 1=1" ).append("\n"); 
		query.append("AND EDI_STND_STS_CD IN  ('VBE')" ).append("\n"); 
		query.append("-- VL 이후에만 VBE를 전송한다." ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_COP_DTL D WHERE COP_NO_TMP = D.COP_NO AND D.COP_DTL_SEQ BETWEEN 4000 AND 6000 AND D.ACT_STS_CD = 'C')" ).append("\n"); 
		query.append("THEN INTO SCE_EDI_HIS (EDI_RCV_DT, EDI_RCV_SEQ, EDI_STND_STS_CD, CUST_EDI_STS_CD, ACT_STS_MAPG_CD, COP_ACT_CD, BKG_NO, BL_NO, CNTR_NO, COP_NO, COP_DTL_SEQ, COST_ACT_GRP_SEQ , CRNT_VSL_CD, CRNT_SKD_VOY_NO , CRNT_SKD_DIR_CD, EDI_EVNT_DT, EVNT_YD_CD, CLPT_IND_SEQ, SRC_MDL_ID, EDI_IF_STS_CD, IF_RMK, EDI_CUST_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES (EDI_RCV_DT, SCE_EDI_HIS_SEQ.NEXTVAL, EDI_STND_STS_CD, CUST_EDI_STS_CD, ACT_STS_MAPG_CD, COP_ACT_CD, BKG_NO, BL_NO, CNTR_NO, COP_NO_TMP, COP_DTL_SEQ, COST_ACT_GRP_SEQ , CRNT_VSL_CD, CRNT_SKD_VOY_NO , CRNT_SKD_DIR_CD, EDI_EVNT_DT_ETB, EVNT_YD_CD_ETB, CLPT_IND_SEQ, SRC_MDL_ID, EDI_IF_STS_CD, IF_RMK, EDI_CUST_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN 1=1" ).append("\n"); 
		query.append("AND EDI_STND_STS_CD IN  ('VE')" ).append("\n"); 
		query.append("-- VL 이후에만 VE를 전송한다." ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_COP_DTL D WHERE COP_NO_TMP = D.COP_NO AND D.COP_DTL_SEQ BETWEEN 4000 AND 6000 AND D.ACT_STS_CD = 'C')" ).append("\n"); 
		query.append("THEN INTO SCE_EDI_HIS (EDI_RCV_DT, EDI_RCV_SEQ, EDI_STND_STS_CD, CUST_EDI_STS_CD, ACT_STS_MAPG_CD, COP_ACT_CD, BKG_NO, BL_NO, CNTR_NO, COP_NO, COP_DTL_SEQ, COST_ACT_GRP_SEQ , CRNT_VSL_CD, CRNT_SKD_VOY_NO , CRNT_SKD_DIR_CD, EDI_EVNT_DT, EVNT_YD_CD, CLPT_IND_SEQ, SRC_MDL_ID, EDI_IF_STS_CD, IF_RMK, EDI_CUST_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES (EDI_RCV_DT, SCE_EDI_HIS_SEQ.NEXTVAL, EDI_STND_STS_CD, CUST_EDI_STS_CD, ACT_STS_MAPG_CD, COP_ACT_CD, BKG_NO, BL_NO, CNTR_NO, COP_NO_TMP, COP_DTL_SEQ, COST_ACT_GRP_SEQ , CRNT_VSL_CD, CRNT_SKD_VOY_NO , CRNT_SKD_DIR_CD, EDI_EVNT_DT_ETA, EVNT_YD_CD_ETA, CLPT_IND_SEQ, SRC_MDL_ID, EDI_IF_STS_CD, IF_RMK, EDI_CUST_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	 TO_CHAR(SYSDATE,'YYYYMMDD')  EDI_RCV_DT" ).append("\n"); 
		query.append("--	,SCE_EDI_HIS_SEQ.NEXTVAL     EDI_RCV_SEQ " ).append("\n"); 
		query.append("    ,E.EDI_STND_STS_CD                  " ).append("\n"); 
		query.append("    ,E.CUST_EDI_STS_CD                  " ).append("\n"); 
		query.append("    ,'' AS ACT_STS_MAPG_CD" ).append("\n"); 
		query.append("    ,'' AS COP_ACT_CD" ).append("\n"); 
		query.append("    ,H.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("    ,H.BKG_NO AS BL_NO" ).append("\n"); 
		query.append("    ,H.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("    ,H.COP_NO AS COP_NO_TMP         " ).append("\n"); 
		query.append("    ,'' AS COP_DTL_SEQ" ).append("\n"); 
		query.append("    ,'' AS COST_ACT_GRP_SEQ    " ).append("\n"); 
		query.append("    ,'' AS CRNT_VSL_CD " ).append("\n"); 
		query.append("    ,'' AS CRNT_SKD_VOY_NO " ).append("\n"); 
		query.append("    ,'' AS CRNT_SKD_DIR_CD " ).append("\n"); 
		query.append("    ,SYSDATE AS EDI_EVNT_DT" ).append("\n"); 
		query.append("    ,S.POD_ETB AS EDI_EVNT_DT_ETB -- ETB 추가" ).append("\n"); 
		query.append("    ,S.POD_ETA AS EDI_EVNT_DT_ETA -- ETA 추가" ).append("\n"); 
		query.append("    ,H.POL_NOD_CD AS EVNT_YD_CD" ).append("\n"); 
		query.append("    ,H.POD_NOD_CD AS EVNT_YD_CD_ETB" ).append("\n"); 
		query.append("    ,H.POD_NOD_CD AS EVNT_YD_CD_ETA" ).append("\n"); 
		query.append("    ,'' AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,'BKG' AS SRC_MDL_ID" ).append("\n"); 
		query.append("    ,'00' AS EDI_IF_STS_CD          /* For running 'Edi315BatchSend' */" ).append("\n"); 
		query.append("    ,T.EDI_GRP_CD AS IF_RMK" ).append("\n"); 
		query.append("    ,T.EDI_GRP_CD AS EDI_CUST_RMK" ).append("\n"); 
		query.append("    ,'BKG_VVD_CHG' AS CRE_USR_ID" ).append("\n"); 
		query.append("    ,SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("    ,'BKG_VVD_CHG' AS UPD_USR_ID" ).append("\n"); 
		query.append("    ,SYSDATE   AS UPD_DT   " ).append("\n"); 
		query.append("    FROM    " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT  /*+ LEADING (BC) USE_NL ( BC EC EG ) +*/    -- /*+ USE_NL ( EC , EG ) +*/" ).append("\n"); 
		query.append("                		DISTINCT BC.BKG_NO,  EC.EDI_GRP_CD" ).append("\n"); 
		query.append("                FROM	EDI_GRP_CUST	EC," ).append("\n"); 
		query.append("                		EDI_GROUP		EG," ).append("\n"); 
		query.append("                		BKG_CUSTOMER	BC" ).append("\n"); 
		query.append("                WHERE	1 = 1" ).append("\n"); 
		query.append("                AND     EC.CGO_TRC_BAT_FLG	=	'Y'		/* Target data for Batch */" ).append("\n"); 
		query.append("                AND		EC.CGO_TRC_SVC_FLG	=	'Y'  " ).append("\n"); 
		query.append("                AND     EC.IB_SVC_FLG		=	'N'  " ).append("\n"); 
		query.append("                AND		EC.EDI_GRP_CD		=	EG.EDI_GRP_CD	" ).append("\n"); 
		query.append("                AND     EG.DELT_FLG			<>	'Y'  	" ).append("\n"); 
		query.append("                AND     EC.BKG_CTRT_DIV_CD  IS  NULL" ).append("\n"); 
		query.append("                AND     EC.CUST_CNT_CD      =   BC.CUST_CNT_CD  " ).append("\n"); 
		query.append("                AND     EC.CUST_SEQ         =   BC.CUST_SEQ " ).append("\n"); 
		query.append("                AND     NVL(EC.BKG_CUST_TP_DESC, BC.BKG_CUST_TP_CD) LIKE '%'||BC.BKG_CUST_TP_CD||'%'" ).append("\n"); 
		query.append("                AND     BC.BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                SELECT  /*+ USE_NL ( EC , EG ) +*/" ).append("\n"); 
		query.append("                		DISTINCT BK.BKG_NO, EC.EDI_GRP_CD  " ).append("\n"); 
		query.append("                FROM	EDI_GRP_CUST	EC," ).append("\n"); 
		query.append("                		EDI_GROUP		EG," ).append("\n"); 
		query.append("                		BKG_BOOKING		BK" ).append("\n"); 
		query.append("                WHERE	1 = 1" ).append("\n"); 
		query.append("                AND     EC.CGO_TRC_BAT_FLG	=	'Y'		/* Target data for Batch */" ).append("\n"); 
		query.append("                AND		EC.CGO_TRC_SVC_FLG	=	'Y'  " ).append("\n"); 
		query.append("                AND     EC.IB_SVC_FLG		=	'N'  " ).append("\n"); 
		query.append("                AND		EC.EDI_GRP_CD		=	EG.EDI_GRP_CD	" ).append("\n"); 
		query.append("                AND     EG.DELT_FLG			<>	'Y'  	" ).append("\n"); 
		query.append("                AND     EC.BKG_CTRT_DIV_CD  IS  NOT NULL" ).append("\n"); 
		query.append("                AND     (" ).append("\n"); 
		query.append("                			( EC.BKG_CTRT_DIV_CD = '1' AND ( EC.SC_NO =  BK.SC_NO ) )" ).append("\n"); 
		query.append("                			OR" ).append("\n"); 
		query.append("                			( EC.BKG_CTRT_DIV_CD = '2' AND ( EC.SC_NO =  BK.RFA_NO ) )" ).append("\n"); 
		query.append("                		) " ).append("\n"); 
		query.append("                AND     BK.BKG_NO=@[bkg_no]	" ).append("\n"); 
		query.append("            )               T," ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT  A.COP_NO," ).append("\n"); 
		query.append("						MAX(B.VPS_ETB_DT) POD_ETB," ).append("\n"); 
		query.append("                        MAX(B.VPS_ETA_DT) POD_ETA" ).append("\n"); 
		query.append("                FROM    SCE_COP_HDR HD," ).append("\n"); 
		query.append("                        SCE_COP_DTL A," ).append("\n"); 
		query.append("                        VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                        AND HD.BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("                        AND HD.COP_NO = A.COP_NO" ).append("\n"); 
		query.append("                        AND A.STND_EDI_STS_CD = 'UVD'" ).append("\n"); 
		query.append("                        AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                        AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND A.VPS_PORT_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND A.CLPT_IND_SEQ = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                GROUP BY A.COP_NO" ).append("\n"); 
		query.append("			)				S," ).append("\n"); 
		query.append("            BKG_BOOKING     B," ).append("\n"); 
		query.append("            SCE_COP_HDR     H," ).append("\n"); 
		query.append("            EDI_GRP_CGO     E" ).append("\n"); 
		query.append("    WHERE   1   =   1" ).append("\n"); 
		query.append("    AND     B.BKG_NO       =   T.BKG_NO" ).append("\n"); 
		query.append("    AND     B.BKG_NO       =   H.BKG_NO" ).append("\n"); 
		query.append("    AND     S.COP_NO 	   =   H.COP_NO" ).append("\n"); 
		query.append("    AND     H.COP_STS_CD   <> 'X'" ).append("\n"); 
		query.append("    AND     H.CNTR_NO      <> 'SMCU0000000'" ).append("\n"); 
		query.append("    AND     T.EDI_GRP_CD   =   E.EDI_GRP_CD" ).append("\n"); 
		query.append("--  AND     E.EDI_SND_FLG  =   'Y'" ).append("\n"); 

	}
}