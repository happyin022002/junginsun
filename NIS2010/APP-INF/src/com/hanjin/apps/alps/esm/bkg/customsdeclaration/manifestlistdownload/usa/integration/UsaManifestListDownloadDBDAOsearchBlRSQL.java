/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaBlInfoVO 생성
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchBlRSQL").append("\n"); 
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
		query.append("SELECT  'US' AS CNT_CD" ).append("\n"); 
		query.append("       ,B.BL_NO" ).append("\n"); 
		query.append("       ,B.BKG_NO" ).append("\n"); 
		query.append("       ,V.VSL_CD" ).append("\n"); 
		query.append("       ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("	   ,CASE WHEN V.POL_CD = 'MXZLO' AND V.POD_CD = 'USLGB' THEN V.SLAN_CD" ).append("\n"); 
		query.append("			 ELSE B.SLAN_CD" ).append("\n"); 
		query.append("		END SLAN_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.VSL_ARR_DT,'YYYYMMDDHH24MISS') AS VSL_ARR_DT" ).append("\n"); 
		query.append("       ,V.POL_CD AS CSTMS_POL_CD   " ).append("\n"); 
		query.append("       ,V.POD_CD AS CSTMS_POD_CD" ).append("\n"); 
		query.append("       ,B.POR_CD  " ).append("\n"); 
		query.append("	   ,CASE WHEN V.POL_CD = 'MXZLO' AND V.POD_CD = 'USLGB' THEN 'MXZLO'" ).append("\n"); 
		query.append("			 ELSE B.POL_CD" ).append("\n"); 
		query.append("		END POL_CD" ).append("\n"); 
		query.append("	   ,CASE WHEN V.POL_CD = 'MXZLO' AND V.POD_CD = 'USLGB' THEN 'USLGB'" ).append("\n"); 
		query.append("			 ELSE B.POD_CD" ).append("\n"); 
		query.append("		END POD_CD" ).append("\n"); 
		query.append("       ,B.DEL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       -- 20100415 경종윤 " ).append("\n"); 
		query.append("       --  IT_TYPE = '62' 일 경우 USA_LST_LOC_CD = TRS_DMST_LST_CTY.LST_LOC_CD" ).append("\n"); 
		query.append("       -- 아니면  USA_LST_LOC_CD = NULL STRING      " ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("            CASE WHEN I.IT_TYPE = '62'" ).append("\n"); 
		query.append("                THEN (" ).append("\n"); 
		query.append("                    SELECT MAX(LST_LOC_CD) LST_LOC_CD " ).append("\n"); 
		query.append("                      FROM TRS_DMST_LST_CTY" ).append("\n"); 
		query.append("                     WHERE ORG_LOC_CD  = (" ).append("\n"); 
		query.append("                                            CASE WHEN V.POL_CD = 'MXZLO' AND V.POD_CD = 'USLGB' THEN 'USLGB'" ).append("\n"); 
		query.append("                                            ELSE B.POD_CD" ).append("\n"); 
		query.append("                                            END " ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("                       AND DEST_LOC_CD = B.DEL_CD" ).append("\n"); 
		query.append("                       AND DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                ELSE ''" ).append("\n"); 
		query.append("            END        " ).append("\n"); 
		query.append("        ) USA_LST_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       -- 20090424 JHPARK POD 가 USLAX 이고 DEL 의 SCC (it_hub) 가 USLGB 일 때 " ).append("\n"); 
		query.append("       -- Local Clear 라고 판단하기 때문에 it_hub 값에는 POD 의 SCC (USLAX) 가 " ).append("\n"); 
		query.append("       -- 삽입되어야 한다. 나중에 CT 전송시에 Event Yard 에 문제 있었음.       " ).append("\n"); 
		query.append("       -- USLAX 세관에서 Clear 되었는데 315 CT 는 USLGB 라고 전송됨.           " ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       ,CASE WHEN B.POD_CD = 'USLAX' AND L2.SCC_CD = 'USLGB' THEN L1.SCC_CD" ).append("\n"); 
		query.append("             WHEN B.POD_CD = 'USSEA' AND (L2.STE_CD LIKE 'ID%' OR L2.STE_CD LIKE 'MT%') THEN B.POD_CD" ).append("\n"); 
		query.append("             WHEN B.POD_CD = B.DEL_CD THEN B.POD_CD -- 2009.10.23 TO-BE 로직 추가" ).append("\n"); 
		query.append("      		 ELSE L2.SCC_CD" ).append("\n"); 
		query.append("        END HUB_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,DECODE(@[cstms_port_cd], NULL, V.POD_CD, @[cstms_port_cd]) CSTMS_PORT_CD" ).append("\n"); 
		query.append("	   ,A.FROB_FLG" ).append("\n"); 
		query.append("       ,DECODE(A.MF_STS_CD, NULL, 'A', A.MF_STS_CD) AS MF_STS_CD" ).append("\n"); 
		query.append("       ,CASE WHEN B.POD_CD = B.DEL_CD THEN B.POD_CD -- [TO-BE] 2009.10.23  로직 추가" ).append("\n"); 
		query.append("			 ELSE ''" ).append("\n"); 
		query.append("		END CSTMS_LOC_CD" ).append("\n"); 
		query.append("       ,D.PCK_QTY" ).append("\n"); 
		query.append("       ,NVL(P.USA_CSTMS_PCK_CD,'PKG') AS AMS_PCK_TP_CD" ).append("\n"); 
		query.append("       ,D.ACT_WGT AS CGO_WGT" ).append("\n"); 
		query.append("       --,DECODE(NVL(D.WGT_UT_CD,'KG'),'KGS','KG','LBS','LB','KG') AS WGT_UT_CD" ).append("\n"); 
		query.append("	   ,NVL(D.WGT_UT_CD,'KGS') AS WGT_UT_CD" ).append("\n"); 
		query.append("       ,D.MEAS_QTY      " ).append("\n"); 
		query.append("       ,D.MEAS_UT_CD" ).append("\n"); 
		query.append("       ,B.RCV_TERM_CD       " ).append("\n"); 
		query.append("       ,B.DE_TERM_CD" ).append("\n"); 
		query.append("       ,D.BDR_FLG     " ).append("\n"); 
		query.append("       ,TO_CHAR(D.BDR_DT,'YYYYMMDDHH24MISS') AS BDR_DT" ).append("\n"); 
		query.append("	   ,'' AS BDR_OFC_CD" ).append("\n"); 
		query.append("	   ,'' AS BDR_IF_USR_ID" ).append("\n"); 
		query.append("	   ,'' AS BDR_IF_DT" ).append("\n"); 
		query.append("       ,NVL(A.CA_FLG, 'Y') AS CA_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("	   -- C/A Report(I/B) View Down Cell" ).append("\n"); 
		query.append("	   -- 넘겨받은 CA_NO, CA_ISS_DT 데이터를 BL 테이블에 저장" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       ,DECODE(@[ca_iss_dt], NULL, C.CA_ISS_DT, @[ca_iss_dt]) CA_ISS_DT" ).append("\n"); 
		query.append("       ,DECODE(@[ca_no], NULL, C.CA_NO, @[ca_no]) CA_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,B.SCAC_CD" ).append("\n"); 
		query.append("       ,NVL(B.USA_CSTMS_FILE_CD,'3') AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("	   ,'' AS MF_NO" ).append("\n"); 
		query.append("       ,B.BKG_CGO_TP_CD AS FULL_MTY_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,A.CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append("	   ,A.CSTMS_ACK_KEY_NO" ).append("\n"); 
		query.append("	   ,A.CSTMS_ACK_RCV_RSLT_CD" ).append("\n"); 
		query.append("	   ,A.CSTMS_ACK_PROC_RSLT_CD" ).append("\n"); 
		query.append("	   ,A.CSTMS_ACK_RJCT_CD" ).append("\n"); 
		query.append("	   ,A.CSTMS_ACK_RJCT_MSG" ).append("\n"); 
		query.append("	   ,TO_CHAR(A.CSTMS_ACK_RCV_DT,'YYYYMMDDHH24MISS') CSTMS_ACK_RCV_DT" ).append("\n"); 
		query.append("	   ,A.USR_CMT_CTNT" ).append("\n"); 
		query.append("	   ,'' AS IF_FLG" ).append("\n"); 
		query.append("	   ,TO_CHAR(A.IF_DT, 'YYYYMMDDHH24MISS') IF_DT" ).append("\n"); 
		query.append("	   ,A.DIFF_RMK" ).append("\n"); 
		query.append("	   ,A.TRSP_MOD_ID" ).append("\n"); 
		query.append("	   ,A.IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append("	   ,A.CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("	   ,TO_CHAR(A.MF_SND_DT, 'YYYYMMDDHH24MISS') MF_SND_DT" ).append("\n"); 
		query.append("	   ,TO_CHAR(A.AMDT_SND_DT, 'YYYYMMDDHH24MISS') AMDT_SND_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("	   -- Split B/L 인 경우 Old B/L No 구하여 PRE_MF_NO에 세팅" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       ,(  SELECT BL_NO" ).append("\n"); 
		query.append("           FROM BKG_BOOKING" ).append("\n"); 
		query.append("           WHERE BKG_NO = ( SELECT DECODE(BKG_CRE_TP_CD, 'S', FM_BKG_NO, NULL) BKG_NO" ).append("\n"); 
		query.append("                              FROM BKG_BOOKING" ).append("\n"); 
		query.append("                             WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("       ) PRE_MF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,A.CSTMS_FILE_LOC_CD" ).append("\n"); 
		query.append("	   ,A.FAX_OFC_CD ,A.FAX_CNT_CD ,A.FAX_CUST_SEQ ,A.FAX_NO ,A.TRSP_TP_ID" ).append("\n"); 
		query.append("	   ,A.IN_TZ_YD_CD ,A.IN_TZ_YD_NM ,A.IN_TZ_YD_ADDR ,A.IN_TZ_YD_CTY_NM ,A.IN_TZ_YD_STE_CD ,A.IN_TZ_YD_CNT_CD ,A.IN_TZ_YD_ZIP_ID " ).append("\n"); 
		query.append("	   ,NVL(A.CRE_USR_ID, @[usr_id]) CRE_USR_ID" ).append("\n"); 
		query.append("	   ,TO_CHAR(A.CRE_DT, 'YYYYMMDDHH24MISS') CRE_DT" ).append("\n"); 
		query.append("	   ,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("       ,A.AVC_NOTE_TP_ID" ).append("\n"); 
		query.append("       ,A.ACT_FILE_SKD_DIR_CD" ).append("\n"); 
		query.append("	   ,B.POD_NOD_CD -- [TO-BE] 2009.09.11 요건 추가" ).append("\n"); 
		query.append("	   ,B.DEL_NOD_CD -- [TO-BE] 2009.09.11 요건 추가" ).append("\n"); 
		query.append("	   ,TO_CHAR(A.BDR_GDT, 'YYYYMMDDHH24MISS') BDR_GDT " ).append("\n"); 
		query.append("	   ,TO_CHAR(A.BDR_IF_GDT, 'YYYYMMDDHH24MISS') BDR_IF_GDT " ).append("\n"); 
		query.append("	   ,TO_CHAR(A.IF_GDT, 'YYYYMMDDHH24MISS') IF_GDT " ).append("\n"); 
		query.append("	   ,TO_CHAR(A.MF_SND_GDT, 'YYYYMMDDHH24MISS') MF_SND_GDT " ).append("\n"); 
		query.append("	   ,TO_CHAR(A.AMDT_SND_GDT, 'YYYYMMDDHH24MISS') AMDT_SND_GDT" ).append("\n"); 
		query.append("	   ,B.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("	   ,A.PRT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,CASE WHEN SUBSTR(V.POL_CD, 1, 2) IN ('CA', 'MX', 'BR') AND SUBSTR(V.POD_CD, 1, 2) <> 'US' THEN 'F'  -- FROB(F)" ).append("\n"); 
		query.append("			 WHEN SUBSTR(B.POD_CD, 1, 2) <> 'US' THEN 'V'  -- POD 가 'US%' 가 아니면 FROB(V)" ).append("\n"); 
		query.append("             WHEN SUBSTR(B.POD_CD, 1, 2) = 'MX' AND B.SLAN_CD = 'CAX' AND SUBSTR(V.POD_CD, 1, 2) = 'MX' THEN 'V' --20100408" ).append("\n"); 
		query.append("             WHEN SUBSTR(B.POD_CD, 1, 2) = 'US' AND SUBSTR(B.DEL_CD, 1, 2) <> 'US' THEN 'I' --20100524" ).append("\n"); 
		query.append("             WHEN B.POD_CD = 'USLGB' AND L2.SCC_CD = 'USLAX' THEN 'L'  -- 2003.6.27 POD : USLGB HUB : USLAX => LOCAL    " ).append("\n"); 
		query.append("             WHEN B.POD_CD = 'USLAX' AND L2.SCC_CD = 'USLGB' THEN 'L'  -- 20090424 JHPARK POD : USLAX HUB : USLGB => LOCAL  " ).append("\n"); 
		query.append("             WHEN B.POD_CD = 'USSEA' AND L2.SCC_CD = 'USTIW' THEN 'L'  -- 2003.7.11 POD:USSEA HUB:USTIW => LOCAL     " ).append("\n"); 
		query.append("             WHEN B.POD_CD = 'USOAK' AND L2.SCC_CD = 'USSFO' THEN 'L'  -- 2004.4.10 POD:USOAK HUB:USSFO => LOCAL " ).append("\n"); 
		query.append("             WHEN B.POD_CD = 'USLGB' AND L2.SCC_CD = 'USGAC' THEN 'L'  -- 2007.6.27 POD:USLGB HUB:USGAC => LOCAL " ).append("\n"); 
		query.append("      		 WHEN B.POD_CD = 'USSEA' AND (L2.STE_CD LIKE 'ID%' OR L2.STE_CD LIKE 'MT%') THEN 'L'  -- 2002.7.3 POD : USSEA or STATE : ID,MT => HUB = 'USSEA' & 'L'" ).append("\n"); 
		query.append("			 WHEN L1.SCC_CD = L2.SCC_CD AND SUBSTR(B.POD_CD, 1, 2) = SUBSTR(B.DEL_CD, 1, 2) THEN 'L'  -- 20050322 POD HUB와 IT HUB가 같고 && POD와 IT DEL이 같으면 Local 로 판단." ).append("\n"); 
		query.append("             ELSE 'I'" ).append("\n"); 
		query.append("        END LOCL_TRNS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("	   -- 1) 61 : POD=US & DEL=US 이면서, POD's SCC 와 DEL's SCC 가 다른 경우" ).append("\n"); 
		query.append("	   -- 2) 62 : POD=US, DEL <> US 인 경우" ).append("\n"); 
		query.append("	   -- 3) 63 : POD <> US & DEL <> US 이고, FROB 이 아닌 경우 (Pre 또는 Post 에 US 가 있는경우)" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       ,I.IT_TYPE AS IBD_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_BOOKING B" ).append("\n"); 
		query.append("    ,BKG_VVD V" ).append("\n"); 
		query.append("    ,BKG_BL_DOC D" ).append("\n"); 
		query.append("    ,VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("    ,MDM_LOCATION L1" ).append("\n"); 
		query.append("    ,MDM_LOCATION L2" ).append("\n"); 
		query.append("    ,MDM_PCK_TP P" ).append("\n"); 
		query.append("	,(  SELECT  BKG_NO" ).append("\n"); 
		query.append("	           ,CORR_NO AS CA_NO" ).append("\n"); 
		query.append("        	   ,TO_CHAR(CORR_DT,'YYYYMMDDHH24MISS') AS CA_ISS_DT" ).append("\n"); 
		query.append("        FROM   BKG_CORRECTION" ).append("\n"); 
		query.append("        WHERE  CORR_DT = ( SELECT MAX(CORR_DT)" ).append("\n"); 
		query.append("                           FROM   BKG_CORRECTION" ).append("\n"); 
		query.append("                           WHERE  BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                             AND  CORR_CXL_FLG = 'N' )" ).append("\n"); 
		query.append("        AND    BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("        AND    CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("     ) C" ).append("\n"); 
		query.append("	,(	SELECT BKG_NO, IT_TYPE" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("			SELECT  B1.BKG_NO, DECODE(L1.SCC_CD, L2.SCC_CD, '', '61') AS IT_TYPE -- POD=US & DEL=US 이면서, POD's SCC 와 DEL's SCC 가 다른 경우" ).append("\n"); 
		query.append("			  FROM  MDM_LOCATION L1" ).append("\n"); 
		query.append("			       ,MDM_LOCATION L2" ).append("\n"); 
		query.append("			       ,BKG_BOOKING B1" ).append("\n"); 
		query.append("			 WHERE 1=1" ).append("\n"); 
		query.append("			   AND L1.LOC_CD   =    B1.POD_CD" ).append("\n"); 
		query.append("			   AND L2.LOC_CD   =    B1.DEL_CD" ).append("\n"); 
		query.append("			   AND B1.BKG_NO   = 	@[bkg_no] " ).append("\n"); 
		query.append("			   AND B1.POD_CD     LIKE 'US%'" ).append("\n"); 
		query.append("			   AND B1.DEL_CD     LIKE 'US%'" ).append("\n"); 
		query.append("			   AND L1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			   AND L2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("			SELECT BKG_NO, '62' -- POD=US, DEL <> US 인 경우" ).append("\n"); 
		query.append("			  FROM BKG_BOOKING" ).append("\n"); 
		query.append("			 WHERE 1=1" ).append("\n"); 
		query.append("			   AND POD_CD LIKE 'US%'" ).append("\n"); 
		query.append("			   AND DEL_CD NOT LIKE 'US%'" ).append("\n"); 
		query.append("			   AND BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("			SELECT B.BKG_NO, '63' -- POD <> US & DEL <> US 이고, FROB 이 아닌 경우" ).append("\n"); 
		query.append("			  FROM BKG_BOOKING B, BKG_VVD V" ).append("\n"); 
		query.append("			 WHERE 1=1" ).append("\n"); 
		query.append("			   AND B.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("			   AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("			   AND B.POD_CD NOT LIKE 'US%'" ).append("\n"); 
		query.append("			   AND B.DEL_CD NOT LIKE 'US%'" ).append("\n"); 
		query.append("--			   AND V.POD_CD NOT LIKE 'CA%' --FROB_FLG = 'N' --20100416" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	 ) I" ).append("\n"); 
		query.append("	,(  SELECT 	BKG_NO," ).append("\n"); 
		query.append("           		CASE WHEN SUM_CNTR_PCK_QTY > PCK_QTY THEN SUM_CNTR_PCK_QTY" ).append("\n"); 
		query.append("                	 ELSE PCK_QTY" ).append("\n"); 
		query.append("           		END PCK_QTY," ).append("\n"); 
		query.append("           		CASE WHEN SUM_CNTR_WGT_QTY > ACT_WGT THEN SUM_CNTR_WGT_QTY " ).append("\n"); 
		query.append("                	 ELSE ACT_WGT" ).append("\n"); 
		query.append("           		END ACT_WGT" ).append("\n"); 
		query.append("    	FROM (" ).append("\n"); 
		query.append("        	SELECT 	MAX(D.BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("					NVL(SUM(C.PCK_QTY), 0) AS SUM_CNTR_PCK_QTY, " ).append("\n"); 
		query.append("               		NVL(SUM(C.CNTR_WGT), 0) AS SUM_CNTR_WGT_QTY," ).append("\n"); 
		query.append("               		MAX(D.PCK_QTY) AS PCK_QTY," ).append("\n"); 
		query.append("               		MAX(D.ACT_WGT) AS ACT_WGT" ).append("\n"); 
		query.append("          	  FROM BKG_CONTAINER C, BKG_BL_DOC D" ).append("\n"); 
		query.append("         	 WHERE 1=1" ).append("\n"); 
		query.append("           	   AND C.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           	   AND D.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("    	)" ).append("\n"); 
		query.append("	) W" ).append("\n"); 
		query.append("	,(	-- 기 다운로드 되었을 경우 기존 데이터 보존하기 위해 사용" ).append("\n"); 
		query.append("		SELECT *" ).append("\n"); 
		query.append("		FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("		WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("		AND BL_NO = @[bl_no] " ).append("\n"); 
		query.append("	) A " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND	  B.BKG_NO     = @[bkg_no] " ).append("\n"); 
		query.append("AND   V.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND   V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND   V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND   V.VSL_CD     = S.VSL_CD(+)" ).append("\n"); 
		query.append("AND   V.SKD_VOY_NO = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND   V.SKD_DIR_CD = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND   V.POD_CD     = S.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND   S.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("AND   B.BKG_NO     = V.BKG_NO  " ).append("\n"); 
		query.append("AND   B.BKG_NO     = D.BKG_NO(+) " ).append("\n"); 
		query.append("AND   B.POD_CD     = L1.LOC_CD" ).append("\n"); 
		query.append("AND   B.DEL_CD     = L2.LOC_CD" ).append("\n"); 
		query.append("AND   D.PCK_TP_CD  = P.PCK_CD(+)" ).append("\n"); 
		query.append("AND   B.BKG_NO     = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND   B.BKG_NO     = I.BKG_NO(+)" ).append("\n"); 
		query.append("AND   B.BKG_NO     = W.BKG_NO(+)" ).append("\n"); 
		query.append("AND   B.BKG_NO     = A.BKG_NO(+)" ).append("\n"); 

	}
}