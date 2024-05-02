/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchHblInfoByRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.05.24 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchHblInfoByRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchHblInfoByRefNo
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchHblInfoByRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchHblInfoByRefNoRSQL").append("\n"); 
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
		query.append("       ,H.CNTR_MF_NO AS BL_NO" ).append("\n"); 
		query.append("       ,B.BKG_NO" ).append("\n"); 
		query.append("       ,V.VSL_CD" ).append("\n"); 
		query.append("       ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,B.SLAN_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.VSL_ARR_DT,'YYYYMMDDHH24MISS') AS VSL_ARR_DT" ).append("\n"); 
		query.append("       ,V.POL_CD AS CSTMS_POL_CD   " ).append("\n"); 
		query.append("       ,V.POD_CD AS CSTMS_POD_CD" ).append("\n"); 
		query.append("       ,B.POR_CD    " ).append("\n"); 
		query.append("       ,B.POL_CD  " ).append("\n"); 
		query.append("       ,B.POD_CD" ).append("\n"); 
		query.append("       ,B.DEL_CD" ).append("\n"); 
		query.append("       ,L1.SCC_CD AS USA_LST_LOC_CD" ).append("\n"); 
		query.append("       ,L2.SCC_CD AS HUB_LOC_CD" ).append("\n"); 
		query.append("       ,DECODE(@[cstms_port_cd], NULL, V.POD_CD, @[cstms_port_cd]) CSTMS_PORT_CD" ).append("\n"); 
		query.append("       ,A.FROB_FLG" ).append("\n"); 
		query.append("       ,DECODE(A.MF_STS_CD, NULL, 'A', A.MF_STS_CD) AS MF_STS_CD" ).append("\n"); 
		query.append("       ,A.CSTMS_LOC_CD" ).append("\n"); 
		query.append("       ,H.PCK_QTY" ).append("\n"); 
		query.append("       ,NVL(P.USA_CSTMS_PCK_CD,'PKG') AS AMS_PCK_TP_CD" ).append("\n"); 
		query.append("       ,H.HBL_WGT AS CGO_WGT" ).append("\n"); 
		query.append("       --,DECODE(NVL(H.WGT_UT_CD,'KG'),'KGS','KG','LBS','LB','KG') AS WGT_UT_CD" ).append("\n"); 
		query.append("       ,NVL(D.WGT_UT_CD,'KGS') AS WGT_UT_CD" ).append("\n"); 
		query.append("       ,H.CMDT_MEAS_QTY AS MEAS_QTY" ).append("\n"); 
		query.append("       ,H.CMDT_MEAS_UT_CD AS MEAS_UT_CD" ).append("\n"); 
		query.append("       ,B.RCV_TERM_CD       " ).append("\n"); 
		query.append("       ,B.DE_TERM_CD" ).append("\n"); 
		query.append("       ,D.BDR_FLG     " ).append("\n"); 
		query.append("       ,TO_CHAR(D.BDR_DT,'YYYYMMDDHH24MISS') AS BDR_DT" ).append("\n"); 
		query.append("       ,'' AS BDR_OFC_CD" ).append("\n"); 
		query.append("	   ,A.BDR_IF_USR_ID ,A.BDR_IF_DT" ).append("\n"); 
		query.append("       ,A.CA_FLG, TO_CHAR(A.CA_ISS_DT,'YYYYMMDDHH24MISS'), A.CA_NO" ).append("\n"); 
		query.append("       ,B.SCAC_CD" ).append("\n"); 
		query.append("       ,NVL(B.USA_CSTMS_FILE_CD,'0') AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("       ,B.BL_NO AS MF_NO" ).append("\n"); 
		query.append("       ,B.BKG_CGO_TP_CD AS FULL_MTY_CD" ).append("\n"); 
		query.append("	   ,A.CSTMS_TRSM_STS_CD ,A.CSTMS_ACK_KEY_NO ,A.CSTMS_ACK_RCV_RSLT_CD " ).append("\n"); 
		query.append("	   ,A.CSTMS_ACK_PROC_RSLT_CD ,A.CSTMS_ACK_RJCT_CD ,A.CSTMS_ACK_RJCT_MSG " ).append("\n"); 
		query.append("	   ,TO_CHAR(A.CSTMS_ACK_RCV_DT,'YYYYMMDDHH24MISS') CSTMS_ACK_RCV_DT" ).append("\n"); 
		query.append("	   ,A.USR_CMT_CTNT" ).append("\n"); 
		query.append("	   ,A.IF_FLG " ).append("\n"); 
		query.append("	   ,TO_CHAR(A.IF_DT, 'YYYYMMDDHH24MISS') IF_DT" ).append("\n"); 
		query.append("	   ,A.DIFF_RMK" ).append("\n"); 
		query.append("	   ,A.TRSP_MOD_ID" ).append("\n"); 
		query.append("	   ,A.IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append("	   ,A.CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("	   ,TO_CHAR(A.MF_SND_DT, 'YYYYMMDDHH24MISS') MF_SND_DT" ).append("\n"); 
		query.append("	   ,TO_CHAR(A.AMDT_SND_DT, 'YYYYMMDDHH24MISS') AMDT_SND_DT" ).append("\n"); 
		query.append("	   ,H.ORG_CNTR_MF_NO AS PRE_MF_NO" ).append("\n"); 
		query.append("	   ,A.CSTMS_FILE_LOC_CD" ).append("\n"); 
		query.append("	   ,A.FAX_OFC_CD ,A.FAX_CNT_CD ,A.FAX_CUST_SEQ ,A.FAX_NO ,A.TRSP_TP_ID" ).append("\n"); 
		query.append("	   ,A.IN_TZ_YD_CD ,A.IN_TZ_YD_NM ,A.IN_TZ_YD_ADDR ,A.IN_TZ_YD_CTY_NM ,A.IN_TZ_YD_STE_CD ,A.IN_TZ_YD_CNT_CD ,A.IN_TZ_YD_ZIP_ID " ).append("\n"); 
		query.append("	   ,NVL(A.CRE_USR_ID, @[usr_id]) CRE_USR_ID" ).append("\n"); 
		query.append("	   ,TO_CHAR(A.CRE_DT, 'YYYYMMDDHH24MISS') CRE_DT" ).append("\n"); 
		query.append("	   ,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("       ,A.AVC_NOTE_TP_ID " ).append("\n"); 
		query.append("	   ,A.ACT_FILE_SKD_DIR_CD" ).append("\n"); 
		query.append("	   ,B.POD_NOD_CD" ).append("\n"); 
		query.append("	   ,B.DEL_NOD_CD" ).append("\n"); 
		query.append("	   ,TO_CHAR(A.BDR_GDT, 'YYYYMMDDHH24MISS') BDR_GDT " ).append("\n"); 
		query.append("	   ,TO_CHAR(A.BDR_IF_GDT, 'YYYYMMDDHH24MISS') BDR_IF_GDT " ).append("\n"); 
		query.append("	   ,TO_CHAR(A.IF_GDT, 'YYYYMMDDHH24MISS') IF_GDT " ).append("\n"); 
		query.append("	   ,TO_CHAR(A.MF_SND_GDT, 'YYYYMMDDHH24MISS') MF_SND_GDT " ).append("\n"); 
		query.append("	   ,TO_CHAR(A.AMDT_SND_GDT, 'YYYYMMDDHH24MISS') AMDT_SND_GDT " ).append("\n"); 
		query.append("	   ,A.CUST_TO_ORD_FLG " ).append("\n"); 
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
		query.append("FROM    BKG_BOOKING B" ).append("\n"); 
		query.append("       ,BKG_VVD V" ).append("\n"); 
		query.append("       ,BKG_BL_DOC D" ).append("\n"); 
		query.append("       ,BKG_HBL H" ).append("\n"); 
		query.append("       ,VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("       ,MDM_LOCATION L1" ).append("\n"); 
		query.append("       ,MDM_LOCATION L2" ).append("\n"); 
		query.append("       ,MDM_PCK_TP P" ).append("\n"); 
		query.append("	   ,(	-- 기 다운로드 되었을 경우 기존 데이터 보존하기 위해 사용" ).append("\n"); 
		query.append("			SELECT *" ).append("\n"); 
		query.append("			FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("			WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("			AND BL_NO = @[bl_no] " ).append("\n"); 
		query.append("		) A " ).append("\n"); 
		query.append("	,(	SELECT BKG_NO, IT_TYPE" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("			SELECT  B1.BKG_NO, DECODE(L1.SCC_CD, L2.SCC_CD, '', '61') AS IT_TYPE -- POD=US & DEL=US 이면서, POD's SCC 와 DEL's SCC 가 다른 경우" ).append("\n"); 
		query.append("			  FROM  MDM_LOCATION L1" ).append("\n"); 
		query.append("			       ,MDM_LOCATION L2" ).append("\n"); 
		query.append("			       ,BKG_BOOKING B1" ).append("\n"); 
		query.append("				   ,BKG_HBL H" ).append("\n"); 
		query.append("			 WHERE 1=1" ).append("\n"); 
		query.append("			   AND H.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("			   AND B1.BKG_NO   = 	H.BKG_NO" ).append("\n"); 
		query.append("			   AND L1.LOC_CD   =    B1.POD_CD" ).append("\n"); 
		query.append("			   AND L2.LOC_CD   =    B1.DEL_CD " ).append("\n"); 
		query.append("			   AND B1.POD_CD     LIKE 'US%'" ).append("\n"); 
		query.append("			   AND B1.DEL_CD     LIKE 'US%'" ).append("\n"); 
		query.append("			   AND L1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			   AND L2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("			SELECT B.BKG_NO, '62' -- POD=US, DEL <> US 인 경우" ).append("\n"); 
		query.append("			  FROM BKG_BOOKING B, BKG_HBL H" ).append("\n"); 
		query.append("			 WHERE 1=1" ).append("\n"); 
		query.append("			   AND H.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("			   AND B.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("			   AND B.POD_CD LIKE 'US%'" ).append("\n"); 
		query.append("			   AND B.DEL_CD NOT LIKE 'US%'" ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("			SELECT B.BKG_NO, '63' -- POD <> US & DEL <> US 이고, FROB 이 아닌 경우" ).append("\n"); 
		query.append("			  FROM BKG_BOOKING B, BKG_VVD V, BKG_HBL H" ).append("\n"); 
		query.append("			 WHERE 1=1" ).append("\n"); 
		query.append("			   AND H.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("			   AND B.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("			   AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("			   AND B.POD_CD NOT LIKE 'US%'" ).append("\n"); 
		query.append("			   AND B.DEL_CD NOT LIKE 'US%'" ).append("\n"); 
		query.append("			   AND V.POD_CD NOT LIKE 'CA%' --FROB_FLG = 'N'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	 ) I" ).append("\n"); 
		query.append("WHERE   B.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("AND     H.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("AND     B.BKG_NO     = V.BKG_NO  " ).append("\n"); 
		query.append("AND     B.BKG_NO     = D.BKG_NO  " ).append("\n"); 
		query.append("AND     B.BKG_NO     = H.BKG_NO " ).append("\n"); 
		query.append("AND     V.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND     V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND     V.VSL_CD     = S.VSL_CD(+)" ).append("\n"); 
		query.append("AND     V.SKD_VOY_NO = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND     V.SKD_DIR_CD = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND     V.POD_CD     = S.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND     S.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("AND     B.POD_CD     = L1.LOC_CD" ).append("\n"); 
		query.append("AND     B.DEL_CD     = L2.LOC_CD" ).append("\n"); 
		query.append("AND     D.PCK_TP_CD  = P.PCK_CD(+)" ).append("\n"); 
		query.append("AND   	B.BKG_NO     = A.BKG_NO(+)" ).append("\n"); 
		query.append("AND     B.BKG_NO     = I.BKG_NO(+)" ).append("\n"); 

	}
}