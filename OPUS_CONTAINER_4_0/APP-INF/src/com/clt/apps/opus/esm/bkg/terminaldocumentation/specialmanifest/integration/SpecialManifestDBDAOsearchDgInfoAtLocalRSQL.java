/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchDgInfoAtLocalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.26
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.08.26 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchDgInfoAtLocalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주위험물 테이블들에서 데이타를 가져온다.
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchDgInfoAtLocalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bay_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_opr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo_oper_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchDgInfoAtLocalRSQL").append("\n"); 
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
		query.append("SELECT DENSE_RANK() OVER (ORDER BY POL_CD, POD_CD, BL_NO, CGO_OPR_CD) AS SEQ" ).append("\n"); 
		query.append("      ,CNTR_CNT            -- TOTAL CONTAINER COUNT" ).append("\n"); 
		query.append("      ,CGO_OPR_CD" ).append("\n"); 
		query.append("      ,BL_NO MERGE_BL_NO " ).append("\n"); 
		query.append("      ,BL_NO              -- BL_NO" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,POL_CD             -- POL_CD" ).append("\n"); 
		query.append("      ,POD_CD             -- POD_CD" ).append("\n"); 
		query.append("      ,CNTR_NO            -- Container No" ).append("\n"); 
		query.append("      ,CNTR_CGO_SEQ       -- Container Cargo Seq" ).append("\n"); 
		query.append("      #if(${auto_update}=='Y')" ).append("\n"); 
		query.append("      ,CASE WHEN CELL_PSN_NO = NVL(CELL_PSN_NO_OPF, CELL_PSN_NO) " ).append("\n"); 
		query.append("       THEN CELL_PSN_NO ELSE CELL_PSN_NO_OPF" ).append("\n"); 
		query.append("       END CELL_PSN_NO -- 저장 후 CELL_POSITION이 UPDATE되면 BAY_PLAN에 있는 CELL_POSITION을 가지고 온다." ).append("\n"); 
		query.append("      ,CASE WHEN NVL(CELL_PSN_NO,1) = NVL(CELL_PSN_NO_OPF, NVL(CELL_PSN_NO,1)) " ).append("\n"); 
		query.append("       THEN 1 ELSE 2 -- CELL POSITION UPDATE를 나타내기 위한 FLAG" ).append("\n"); 
		query.append("       END CELL_CHK" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("      ,CELL_PSN_NO" ).append("\n"); 
		query.append("      ,1 as CELL_CHK" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      ,IMDG_CLSS_CD       -- Class" ).append("\n"); 
		query.append("      ,IMDG_UN_NO         -- UN No." ).append("\n"); 
		query.append("      ,IMDG_UN_NO_SEQ     -- UN No SEQ." ).append("\n"); 
		query.append("      ,IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("      ,ANR_SPCL_TP_ID AS DG_SHORT_NM     -- S.D/G" ).append("\n"); 
		query.append("      ,FLSH_PNT_CDO_TEMP                  -- Flash Point" ).append("\n"); 
		query.append("      ,ANR_ROLE_DIV_CD AS AGENT          -- Agent" ).append("\n"); 
		query.append("      ,ANR_CRR_TP_CD AS C_TYPE             -- Carriage Type" ).append("\n"); 
		query.append("      ,FDR_SVC_RQST_NO    -- SSR(Feeder)" ).append("\n"); 
		query.append("      ,IMDG_PCK_GRP_CD    -- Package Group" ).append("\n"); 
		query.append("      ,OUT_IMDG_PCK_QTY1  -- Outer Package QTY" ).append("\n"); 
		query.append("      ,OUT_IMDG_PCK_CD1   -- Outer Package Code" ).append("\n"); 
		query.append("      ,EUR_OUTR_PCK_DESC  -- Outer Package Desc" ).append("\n"); 
		query.append("      ,IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("      ,IN_IMDG_PCK_CD1 " ).append("\n"); 
		query.append("      ,EUR_INR_PCK_DESC" ).append("\n"); 
		query.append("      ,EMS_NO             -- EMS" ).append("\n"); 
		query.append("      ,NET_WGT            -- Net Weight" ).append("\n"); 
		query.append("      ,GRS_WGT            -- Gross Weight" ).append("\n"); 
		query.append("      ,EUR_PCK_DESC AS PACKAGES                     -- Packages" ).append("\n"); 
		query.append("      ,PRP_SHP_NM                                 -- Substance" ).append("\n"); 
		query.append("      ,HZD_DESC                                   -- Hazardous Contents" ).append("\n"); 
		query.append("      ,ANR_FWRD_ID AS FWRD_ID                     -- Forwarder Code" ).append("\n"); 
		query.append("      ,FWRD_NM                                      -- Forwarder Name" ).append("\n"); 
		query.append("      ,EUR_DCGO_MRN_POLUT_CD                       -- Marine Pollutant" ).append("\n"); 
		query.append("      ,IMDG_LMT_QTY_FLG                            -- Limited quantity" ).append("\n"); 
		query.append("      ,FDR_VSL_NM           -- Feeder Name" ).append("\n"); 
		query.append("      ,FDR_VSL_LLOYD_NO     -- Feeder Lloyd No" ).append("\n"); 
		query.append("      ,FDR_VVD_ID           -- Feeder VVD" ).append("\n"); 
		query.append("      ,TO_CHAR(CRR_DT, 'YYYYMMDD')    CRR_DT       -- on carriage date" ).append("\n"); 
		query.append("      ,MSG_FUNC_ID SEND_TYPE" ).append("\n"); 
		query.append("      ,SCR_FILE_NO SCR_FILE_NO" ).append("\n"); 
		query.append("      ,MSG_SND_NO MSG_SND_NO" ).append("\n"); 
		query.append("      ,FIRST_MSG_SND_NO" ).append("\n"); 
		query.append("      ,COUNT(DISTINCT BL_NO) OVER(PARTITION BY FIRST_MSG_SND_NO ) AS GROUP_CNT" ).append("\n"); 
		query.append("      ,NET_EXPLO_WGT" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,CNTR_NO AS CNTR_NO_OLD" ).append("\n"); 
		query.append("      ,(SELECT DECODE(@[d_type], 'L', STUP.LOD_CD, 'T', STUP.TZ_CD, 'D', STUP.DCHG_CD, '') STUP_FLG" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_EUR_DG_SND_STUP STUP, MDM_VSL_CNTR CNTR" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND STUP.CRR_CD = CNTR.CRR_CD" ).append("\n"); 
		query.append("     AND CNTR.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("           AND STUP.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS STUP_FLG" ).append("\n"); 
		query.append("      ,CNTR_REF_NO" ).append("\n"); 
		query.append("      ,DCGO_REF_NO" ).append("\n"); 
		query.append("      ,EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append("      ,EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("      ,MFAG_NO" ).append("\n"); 
		query.append("      ,DIFF_RMK" ).append("\n"); 
		query.append("      ,HCDG_FLG" ).append("\n"); 
		query.append("      ,EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("      ,XTD_STAY_PRMT_NO" ).append("\n"); 
		query.append("      ,SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,SPCL_CGO_SEQ" ).append("\n"); 
		query.append("  FROM (SELECT A.VSL_CD" ).append("\n"); 
		query.append("              ,COUNT(DISTINCT A.CNTR_NO) OVER() CNTR_CNT" ).append("\n"); 
		query.append("              ,A.BL_NO              -- BL_NO" ).append("\n"); 
		query.append("              ,C.BKG_NO" ).append("\n"); 
		query.append("              ,A.POL_CD             -- POL_CD" ).append("\n"); 
		query.append("              ,A.POD_CD             -- POD_CD" ).append("\n"); 
		query.append("              ,A.CNTR_NO            -- Container No" ).append("\n"); 
		query.append("              ,A.CNTR_CGO_SEQ          -- Container Cargo Seq" ).append("\n"); 
		query.append("              ,A.EUR_OUTR_PCK_DESC" ).append("\n"); 
		query.append("              ,A.IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("              ,A.IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("              ,A.EUR_INR_PCK_DESC" ).append("\n"); 
		query.append("#if (${bay_pln_id} != '')" ).append("\n"); 
		query.append("              ,NVL(BAY.CELL_PSN_NO, A.CELL_PSN_NO) AS CELL_PSN_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              ,A.CELL_PSN_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ,A.IMDG_CLSS_CD       -- Class" ).append("\n"); 
		query.append("              ,A.IMDG_UN_NO         -- UN No." ).append("\n"); 
		query.append("              ,A.IMDG_UN_NO_SEQ     -- UN No SEQ." ).append("\n"); 
		query.append("              ,SIUN.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("              ,A.ANR_SPCL_TP_ID     -- S.D/G" ).append("\n"); 
		query.append("              ,A.FLSH_PNT_CDO_TEMP  -- Flash Point" ).append("\n"); 
		query.append("              ,A.ANR_ROLE_DIV_CD    -- Agent" ).append("\n"); 
		query.append("              ,A.ANR_CRR_TP_CD      -- Carriage Type" ).append("\n"); 
		query.append("              ,A.FDR_SVC_RQST_NO    -- SSR(Feeder)" ).append("\n"); 
		query.append("              ,A.IMDG_PCK_GRP_CD    -- Package Group" ).append("\n"); 
		query.append("              ,A.OUT_IMDG_PCK_QTY1  -- Outer Package QTY" ).append("\n"); 
		query.append("              ,A.OUT_IMDG_PCK_CD1   -- Outer Package Code" ).append("\n"); 
		query.append("              ,A.EMS_NO             -- EMS" ).append("\n"); 
		query.append("              ,A.NET_WGT            -- Net Weight" ).append("\n"); 
		query.append("              ,A.GRS_WGT            -- Gross Weight" ).append("\n"); 
		query.append("              ,A.EUR_PCK_DESC       -- Packages" ).append("\n"); 
		query.append("              ,A.PRP_SHP_NM         -- Substance" ).append("\n"); 
		query.append("              ,A.HZD_DESC           -- Hazardous Contents" ).append("\n"); 
		query.append("              ,A.ANR_FWRD_ID" ).append("\n"); 
		query.append("              ,B.FWRD_NM            -- Forwarder Name" ).append("\n"); 
		query.append("              ,A.EUR_DCGO_MRN_POLUT_CD" ).append("\n"); 
		query.append("              ,A.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("              ,A.FDR_VSL_NM           -- Feeder Name" ).append("\n"); 
		query.append("              ,A.FDR_VSL_LLOYD_NO     -- Feeder Lloyd No" ).append("\n"); 
		query.append("              ,A.FDR_VVD_ID           -- Feeder VVD" ).append("\n"); 
		query.append("              ,A.CRR_DT               -- on carriage date" ).append("\n"); 
		query.append("              ,DECODE(LOG.MSG_FUNC_ID, 'O', DECODE(LOG.ACK_RCV_STS_CD, 'R', '', LOG.MSG_FUNC_ID), LOG.MSG_FUNC_ID) MSG_FUNC_ID" ).append("\n"); 
		query.append("              ,LOG.MSG_SND_NO" ).append("\n"); 
		query.append("              ,F_LOG.SCR_FILE_NO" ).append("\n"); 
		query.append("              ,F_LOG.MSG_SND_NO   FIRST_MSG_SND_NO" ).append("\n"); 
		query.append("              ,A.NET_EXPLO_WGT" ).append("\n"); 
		query.append("              ,A.CGO_OPR_CD" ).append("\n"); 
		query.append("              ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,A.CNTR_REF_NO" ).append("\n"); 
		query.append("              ,A.DCGO_REF_NO" ).append("\n"); 
		query.append("              ,A.EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append("              ,A.EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("              ,A.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("              ,A.IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("              ,A.IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("              ,A.IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("              ,A.MFAG_NO" ).append("\n"); 
		query.append("              ,A.DIFF_RMK" ).append("\n"); 
		query.append("              ,A.HCDG_FLG" ).append("\n"); 
		query.append("              ,A.EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("              ,A.XTD_STAY_PRMT_NO" ).append("\n"); 
		query.append("              ,A.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("              ,A.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("              ,(SELECT LPAD(X.VSL_BAY_NO || X.VSL_ROW_NO || X.VSL_TR_NO, 7,0 )" ).append("\n"); 
		query.append("                FROM OPF_BAY_PLN_LDIS X, VSK_VSL_PORT_SKD PS" ).append("\n"); 
		query.append("                WHERE PS.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                AND PS.SKD_VOY_NO=SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                AND PS.SKD_DIR_CD =SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                AND X.VSL_CD = PS.VSL_CD" ).append("\n"); 
		query.append("                AND CASE WHEN PS.TURN_PORT_IND_CD IN ('Y','N') THEN PS.SKD_VOY_NO ELSE PS.TURN_SKD_VOY_NO END = X.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND CASE WHEN PS.TURN_PORT_IND_CD IN ('Y','N') THEN PS.SKD_DIR_CD ELSE PS.TURN_SKD_DIR_CD END = X.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND X.VPS_PORT_CD = PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                AND CASE WHEN PS.TURN_PORT_IND_CD IN ('Y','N') THEN PS.CLPT_IND_SEQ ELSE PS.TURN_CLPT_IND_SEQ END = X.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND X.CNTR_REF_NO =A.CNTR_NO" ).append("\n"); 
		query.append("                AND X.LODG_DCHG_IND_CD = 'C') AS CELL_PSN_NO_OPF" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("          FROM BKG_CSTMS_EUR_DG A" ).append("\n"); 
		query.append("              ,BKG_CSTMS_EUR_DG_FWRD B" ).append("\n"); 
		query.append("              ,SCG_IMDG_UN_NO SIUN" ).append("\n"); 
		query.append("              ,BKG_BOOKING C" ).append("\n"); 
		query.append("#if (${bay_pln_id} != '')" ).append("\n"); 
		query.append("              ,(SELECT A.BAY_PLN_ID" ).append("\n"); 
		query.append("                      ,A.VSL_CD" ).append("\n"); 
		query.append("                      ,A.ETA_DT" ).append("\n"); 
		query.append("                      ,A.ETD_DT" ).append("\n"); 
		query.append("                      ,B.EUR_DG_CNTR_ID CNTR_NO" ).append("\n"); 
		query.append("                      ,B.CELL_PSN_NO" ).append("\n"); 
		query.append("                      ,B.POL_CD" ).append("\n"); 
		query.append("                      ,B.POD_CD" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_DG_BAY_PLN A" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_EUR_DG_BAY_DTL B" ).append("\n"); 
		query.append("                 WHERE A.BAY_PLN_ID = B.BAY_PLN_ID" ).append("\n"); 
		query.append("                   AND A.VSL_CD            = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                   AND A.VSL_VOY_DIR_NO    = SUBSTR(@[vvd_cd], 5, 5)" ).append("\n"); 
		query.append("                   AND B.EUR_DG_CNTR_ID > ' '" ).append("\n"); 
		query.append("                   AND B.BAY_PLN_ID  = @[bay_pln_id]" ).append("\n"); 
		query.append("               ) BAY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ui_type} == 'ESM_BKG_0965')" ).append("\n"); 
		query.append("              ,(SELECT A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("                      ,A.VSL_CD" ).append("\n"); 
		query.append("                      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                      ,A.PORT_CD" ).append("\n"); 
		query.append("                      ,B.BL_NO" ).append("\n"); 
		query.append("                      ,B.CNTR_NO" ).append("\n"); 
		query.append("                      ,B.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("                      ,A.MSG_FUNC_ID" ).append("\n"); 
		query.append("                      ,B.MSG_SND_NO" ).append("\n"); 
		query.append("                      ,B.EDI_RSPN_SEQ" ).append("\n"); 
		query.append("                      ,C.ACK_RCV_STS_CD" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_EUR_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_EUR_DG_RCV C" ).append("\n"); 
		query.append("                 WHERE A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                   AND A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                   AND A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                   AND A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                   AND A.EUR_EDI_MSG_TP_ID = B.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                   AND A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("                   AND A.EUR_EDI_MSG_TP_ID= C.EUR_EDI_MSG_TP_ID(+)" ).append("\n"); 
		query.append("                   AND A.MSG_SND_NO = C.MSG_RCV_NO(+)" ).append("\n"); 
		query.append("                   AND (B.BL_NO, B.MSG_SND_NO) IN (SELECT B.BL_NO, MAX(B.MSG_SND_NO)" ).append("\n"); 
		query.append("                                                     FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                                         ,BKG_CSTMS_EUR_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                                                    WHERE A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                                                      AND A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                      AND A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                      AND A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                      AND A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                                                      AND A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                                                      AND A.EUR_EDI_MSG_TP_ID = B.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                                                      AND A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("                                                    GROUP BY A.EUR_EDI_MSG_TP_ID, B.BL_NO" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("               ) LOG" ).append("\n"); 
		query.append("              ,(SELECT A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("                      ,A.VSL_CD" ).append("\n"); 
		query.append("                      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                      ,A.PORT_CD" ).append("\n"); 
		query.append("                      ,B.BL_NO" ).append("\n"); 
		query.append("                      ,B.CNTR_NO" ).append("\n"); 
		query.append("                      ,B.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("                      ,A.MSG_FUNC_ID" ).append("\n"); 
		query.append("                      ,B.MSG_SND_NO" ).append("\n"); 
		query.append("                      ,B.EDI_RSPN_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT /*+ INDEX_DESC(BKG_CSTMS_EUR_DG_RCV XPKBKG_CSTMS_EUR_DG_RCV)*/ SCR_FILE_NO" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_EUR_DG_RCV" ).append("\n"); 
		query.append("                         WHERE EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("                           AND MSG_RCV_NO = A.MSG_SND_NO" ).append("\n"); 
		query.append("                           AND ROWNUM = 1" ).append("\n"); 
		query.append("                       ) SCR_FILE_NO" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_EUR_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                 WHERE A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                   AND A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                   AND A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                   AND A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                   AND A.EUR_EDI_MSG_TP_ID = B.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                   AND A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("                   AND A.MSG_FUNC_ID = 'O'" ).append("\n"); 
		query.append("                   AND (B.BL_NO, B.MSG_SND_NO) IN (SELECT B.BL_NO, MAX(B.MSG_SND_NO)" ).append("\n"); 
		query.append("                                                     FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                                         ,BKG_CSTMS_EUR_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                                                    WHERE A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                                                      AND A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                      AND A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                      AND A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                      AND A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                                                      AND A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                                                      AND A.EUR_EDI_MSG_TP_ID = B.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                                                      AND A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("                                                      AND A.MSG_FUNC_ID = 'O'" ).append("\n"); 
		query.append("                                                    GROUP BY A.EUR_EDI_MSG_TP_ID, B.BL_NO" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("               ) F_LOG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            -- 0966" ).append("\n"); 
		query.append("              ,(SELECT A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("                      ,A.VSL_CD" ).append("\n"); 
		query.append("                      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                      ,A.PORT_CD" ).append("\n"); 
		query.append("                      ,A.MSG_FUNC_ID" ).append("\n"); 
		query.append("                      ,A.MSG_SND_NO" ).append("\n"); 
		query.append("                      ,B.ACK_RCV_STS_CD" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_EUR_DG_RCV B" ).append("\n"); 
		query.append("                 WHERE A.EUR_EDI_MSG_TP_ID= B.EUR_EDI_MSG_TP_ID(+)" ).append("\n"); 
		query.append("                   AND A.MSG_SND_NO = B.MSG_RCV_NO(+)" ).append("\n"); 
		query.append("                   AND A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                   AND A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                   AND A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                   AND A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                   AND B.RCV_LOG_SEQ = (SELECT MAX(R.RCV_LOG_SEQ)" ).append("\n"); 
		query.append("                                          FROM BKG_CSTMS_EUR_DG_RCV R" ).append("\n"); 
		query.append("                                         WHERE R.EUR_EDI_MSG_TP_ID = B.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                                           AND R.MSG_RCV_NO        = B.MSG_RCV_NO" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                   AND A.MSG_SND_NO = (SELECT MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("                                       FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                       WHERE 1=1" ).append("\n"); 
		query.append("                                       AND A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                 				       AND A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                       AND A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                       AND A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                       AND A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                                       AND A.EUR_EDI_MSG_TP_ID ='IFD')" ).append("\n"); 
		query.append("               ) LOG" ).append("\n"); 
		query.append("             , (SELECT A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("                      ,A.VSL_CD" ).append("\n"); 
		query.append("                      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                      ,A.PORT_CD" ).append("\n"); 
		query.append("                      ,A.MSG_FUNC_ID" ).append("\n"); 
		query.append("                      ,A.MSG_SND_NO" ).append("\n"); 
		query.append("                      ,B.SCR_FILE_NO" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_EUR_DG_RCV B" ).append("\n"); 
		query.append("                 WHERE A.EUR_EDI_MSG_TP_ID= B.EUR_EDI_MSG_TP_ID(+)" ).append("\n"); 
		query.append("                   AND A.MSG_SND_NO = B.MSG_RCV_NO(+)" ).append("\n"); 
		query.append("                   AND A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                   AND A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                   AND A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                   AND A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                   AND B.RCV_LOG_SEQ = (SELECT MAX(R.RCV_LOG_SEQ)" ).append("\n"); 
		query.append("                                          FROM BKG_CSTMS_EUR_DG_RCV R" ).append("\n"); 
		query.append("                                         WHERE R.EUR_EDI_MSG_TP_ID = B.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                                           AND R.MSG_RCV_NO        = B.MSG_RCV_NO" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append(" 				   AND A.MSG_SND_NO = (SELECT MAX(MSG_SND_NO) " ).append("\n"); 
		query.append("                                       FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                       WHERE 1=1" ).append("\n"); 
		query.append("                                       AND A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                 				       AND A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                       AND A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                       AND A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                       AND A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                                       AND A.EUR_EDI_MSG_TP_ID ='IFD')" ).append("\n"); 
		query.append("               ) F_LOG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         WHERE A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("           AND A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("           AND A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("#if (${cgo_opr} != '')" ).append("\n"); 
		query.append("           AND A.CGO_OPR_CD = @[cgo_opr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND A.BL_NO         = C.BL_NO(+)" ).append("\n"); 
		query.append("           AND A.ANR_FWRD_ID = B.ANR_FWRD_ID(+)" ).append("\n"); 
		query.append("#if (${bay_pln_id} != '')" ).append("\n"); 
		query.append("           AND A.VSL_CD      = BAY.VSL_CD(+)" ).append("\n"); 
		query.append("           AND A.POL_CD      = BAY.POL_CD(+)" ).append("\n"); 
		query.append("           AND A.POD_CD      = BAY.POD_CD(+)" ).append("\n"); 
		query.append("           AND A.CNTR_NO     = BAY.CNTR_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND A.EUR_DG_DECL_TP_CD = LOG.EUR_DG_DECL_TP_CD(+)" ).append("\n"); 
		query.append("           AND A.VSL_CD      = LOG.VSL_CD(+)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO  = LOG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD  = LOG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND A.PORT_CD     = LOG.PORT_CD(+)" ).append("\n"); 
		query.append("           AND A.EUR_DG_DECL_TP_CD = F_LOG.EUR_DG_DECL_TP_CD(+)" ).append("\n"); 
		query.append("           AND A.VSL_CD      = F_LOG.VSL_CD(+)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO  = F_LOG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD  = F_LOG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND A.PORT_CD     = F_LOG.PORT_CD(+)" ).append("\n"); 
		query.append("           AND A.IMDG_UN_NO    =     SIUN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("           AND A.IMDG_UN_NO_SEQ = SIUN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("   		   #if(${cargo_oper_cd} != '')" ).append("\n"); 
		query.append("	       AND A.CGO_OPR_CD = @[cargo_oper_cd]" ).append("\n"); 
		query.append("	       #end" ).append("\n"); 
		query.append("  		   #if(${pol_code} != '')" ).append("\n"); 
		query.append("	       AND A.POL_CD = @[pol_code]" ).append("\n"); 
		query.append("	       #end" ).append("\n"); 
		query.append("	       #if(${pod_code} != '')" ).append("\n"); 
		query.append("	       AND A.POD_CD = @[pod_code]" ).append("\n"); 
		query.append("	       #end" ).append("\n"); 
		query.append("	       #if(${bl_number} != '')" ).append("\n"); 
		query.append("	       AND A.BL_NO = @[bl_number]" ).append("\n"); 
		query.append("	       #end" ).append("\n"); 
		query.append("#if (${ui_type} == 'ESM_BKG_0965')" ).append("\n"); 
		query.append("           AND A.BL_NO       = LOG.BL_NO(+)" ).append("\n"); 
		query.append("           AND A.CNTR_NO     = LOG.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND A.CNTR_CGO_SEQ = LOG.CNTR_CGO_SEQ(+)" ).append("\n"); 
		query.append("           AND A.BL_NO       = F_LOG.BL_NO(+)" ).append("\n"); 
		query.append("           AND A.CNTR_NO     = F_LOG.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND A.CNTR_CGO_SEQ = F_LOG.CNTR_CGO_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) SUB1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("ORDER BY   SEQ, POL_CD,POD_CD,BL_NO,DCGO_REF_NO,CGO_OPR_CD" ).append("\n"); 

	}
}