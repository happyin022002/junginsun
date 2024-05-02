/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchMissingOPByMvmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchMissingOPByMvmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OP 가 누락된 case 에 대해 OC / VL 처리 시 OC / VL 의 movement cycle no 또는 이전 no 로 OP 를 찾는다.
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchMissingOPByMvmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchMissingOPByMvmtRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO ," ).append("\n"); 
		query.append("  BKG_NO ," ).append("\n"); 
		query.append("  ACT_STS_MAPG_CD ," ).append("\n"); 
		query.append("  NOD_CD ," ).append("\n"); 
		query.append("  ACT_DT ," ).append("\n"); 
		query.append("  EDI_MSG_TP_CD ," ).append("\n"); 
		query.append("  CRE_TP_CD ," ).append("\n"); 
		query.append("  CRE_USR_ID ," ).append("\n"); 
		query.append("  VNDR_SEQ ," ).append("\n"); 
		query.append("  BND_VSKD_SEQ_CD ," ).append("\n"); 
		query.append("  ACT_DAT_RCV_DT ," ).append("\n"); 
		query.append("  VSL_CD ," ).append("\n"); 
		query.append("  SKD_VOY_NO ," ).append("\n"); 
		query.append("  SKD_DIR_CD ," ).append("\n"); 
		query.append("  UPD_USR_ID ," ).append("\n"); 
		query.append("  CLPT_IND_SEQ ," ).append("\n"); 
		query.append("  VSL_DLAY_RSN_CD ," ).append("\n"); 
		query.append("  VSL_DLAY_RSN_DESC ," ).append("\n"); 
		query.append("  VPS_LOC_CD ," ).append("\n"); 
		query.append("  ACT_CD ," ).append("\n"); 
		query.append("  RAIL_DEST_N1ST_ETA_DT ," ).append("\n"); 
		query.append("  ACT_GDT ," ).append("\n"); 
		query.append("  CNMV_YR ," ).append("\n"); 
		query.append("  CNMV_ID_NO ," ).append("\n"); 
		query.append("  CNMV_SEQ ," ).append("\n"); 
		query.append("  CNMV_SPLIT_NO ," ).append("\n"); 
		query.append("  CNMV_CYC_NO ," ).append("\n"); 
		query.append("  IMDT_EXT_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT TO_CHAR(A.CNTR_NO) CNTR_NO ," ).append("\n"); 
		query.append("      TO_CHAR(@[bkg_no]) BKG_NO ," ).append("\n"); 
		query.append("      TO_CHAR(A.MVMT_STS_CD) ACT_STS_MAPG_CD ," ).append("\n"); 
		query.append("      TO_CHAR(A.ORG_YD_CD) NOD_CD ," ).append("\n"); 
		query.append("      TO_CHAR(A.CNMV_EVNT_DT, 'YYYY/MM/DD HH24:MI:SS') ACT_DT ," ).append("\n"); 
		query.append("      TO_CHAR(" ).append("\n"); 
		query.append("                  CASE" ).append("\n"); 
		query.append("                    WHEN A.MVMT_EDI_MSG_TP_ID is null THEN (" ).append("\n"); 
		query.append("                          CASE" ).append("\n"); 
		query.append("                            WHEN A.MVMT_CRE_TP_CD in ('A'," ).append("\n"); 
		query.append("                  'C'," ).append("\n"); 
		query.append("                  'L'," ).append("\n"); 
		query.append("                  'N'," ).append("\n"); 
		query.append("                  'M'," ).append("\n"); 
		query.append("                  'U'," ).append("\n"); 
		query.append("                  'E') THEN 'SYSTEM'" ).append("\n"); 
		query.append("                            WHEN A.MVMT_CRE_TP_CD is null THEN SUBSTR(A.CRE_USR_ID, 1, 10)" ).append("\n"); 
		query.append("                          END )" ).append("\n"); 
		query.append("                    ELSE A.MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                  END) EDI_MSG_TP_CD ," ).append("\n"); 
		query.append("      TO_CHAR(A.MVMT_CRE_TP_CD) CRE_TP_CD ," ).append("\n"); 
		query.append("      'CrtByOPFnd' CRE_USR_ID ," ).append("\n"); 
		query.append("      TO_CHAR(A.VNDR_SEQ) VNDR_SEQ ," ).append("\n"); 
		query.append("      TO_CHAR(A.OB_CNTR_FLG) BND_VSKD_SEQ_CD ," ).append("\n"); 
		query.append("      TO_CHAR(A.UPD_DT, 'YYYY/MM/DD HH24:MI:SS') ACT_DAT_RCV_DT ," ).append("\n"); 
		query.append("      TO_CHAR(A.CRNT_VSL_CD) VSL_CD ," ).append("\n"); 
		query.append("      TO_CHAR(A.CRNT_SKD_VOY_NO) SKD_VOY_NO ," ).append("\n"); 
		query.append("      TO_CHAR(A.CRNT_SKD_DIR_CD) SKD_DIR_CD ," ).append("\n"); 
		query.append("      A.CRE_USR_ID AS UPD_USR_ID ," ).append("\n"); 
		query.append("      '' AS VPS_PORT_CD ," ).append("\n"); 
		query.append("      '' AS CLPT_IND_SEQ ," ).append("\n"); 
		query.append("      '' AS VSL_DLAY_RSN_CD ," ).append("\n"); 
		query.append("      '' AS VSL_DLAY_RSN_DESC ," ).append("\n"); 
		query.append("      '' AS VPS_LOC_CD ," ).append("\n"); 
		query.append("      '' AS ACT_CD ," ).append("\n"); 
		query.append("      NULL AS RAIL_DEST_N1ST_ETA_DT ," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("                  CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(A.ORG_YD_CD, 1, 5) IS NOT NULL THEN GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(A.ORG_YD_CD, 1, 5), A.CNMV_EVNT_DT, 'GMT')" ).append("\n"); 
		query.append("                  END) AS ACT_GDT ," ).append("\n"); 
		query.append("      A.CNMV_YR ," ).append("\n"); 
		query.append("      A.CNMV_ID_NO ," ).append("\n"); 
		query.append("      A.CNMV_SEQ ," ).append("\n"); 
		query.append("      A.CNMV_SPLIT_NO ," ).append("\n"); 
		query.append("      A.CNMV_CYC_NO ," ).append("\n"); 
		query.append("      A.imdt_ext_flg" ).append("\n"); 
		query.append("    FROM CTM_MOVEMENT A," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("			SELECT	" ).append("\n"); 
		query.append("					M.CNTR_NO," ).append("\n"); 
		query.append("					M.CNMV_YR," ).append("\n"); 
		query.append("					M.CNMV_ID_NO" ).append("\n"); 
		query.append("			FROM	CTM_MOVEMENT M" ).append("\n"); 
		query.append("			WHERE	M.CNTR_NO		=	@[cntr_no]  " ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			-- CHM-201323075 OP/OC/VL Cycle No. 상이시 Cycle -2 체크로직 추가 요청" ).append("\n"); 
		query.append("			-- CHM-201324675 : VL 검색 추가 -- AND		M.CNMV_CYC_NO	IN ( [cnmv_cyc_no] , [cnmv_cyc_no] - 1, [cnmv_cyc_no] - 2 ) " ).append("\n"); 
		query.append("			-- CHM-201324675 : VL 검색 추가 -- AND		M.MVMT_STS_CD	IN	( 'OP', 'OC' )" ).append("\n"); 
		query.append("			--- CHM-201324675 : VL 검색 추가 -------------------------------------------------->" ).append("\n"); 
		query.append("			AND		M.MVMT_STS_CD	IN	( 'OP', 'OC', 'TN', 'EN', 'VL', 'VD' ) -- CHM-201325966" ).append("\n"); 
		query.append("			AND		M.MVMT_STS_CD  <> @[act_sts_mapg_cd]	 -- // Current 가 VL 일때 같은 VL 검색되는것을 방지  " ).append("\n"); 
		query.append("			AND		(" ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							M.MVMT_STS_CD	IN	( 'OP', 'OC')" ).append("\n"); 
		query.append("							AND" ).append("\n"); 
		query.append("							M.CNMV_CYC_NO	IN ( @[cnmv_cyc_no] , @[cnmv_cyc_no] - 1, @[cnmv_cyc_no] - 2 )    " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("						( " ).append("\n"); 
		query.append("							M.MVMT_STS_CD	IN	( 'EN', 'TN', 'VL', 'VD' )  -- CHM-201325966 -- CHM-201325506 : VD시 OP/OC/VL 재매핑 로직상 Cycle -1 로직추가" ).append("\n"); 
		query.append("							AND" ).append("\n"); 
		query.append("							M.CNMV_CYC_NO	IN ( @[cnmv_cyc_no] , @[cnmv_cyc_no] - 1 ) " ).append("\n"); 
		query.append("							AND" ).append("\n"); 
		query.append("							M.OB_CNTR_FLG	=	'Y' " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					)       " ).append("\n"); 
		query.append("			--- CHM-201324675 : VL 검색 추가 ------------------------------------------------->" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			AND		NOT EXISTS	(" ).append("\n"); 
		query.append("									SELECT '1'" ).append("\n"); 
		query.append("									FROM	CTM_MOVEMENT	MM" ).append("\n"); 
		query.append("									WHERE	MM.CNTR_NO			=	M.CNTR_NO " ).append("\n"); 
		query.append("									AND		MM.CNMV_CYC_NO		=	M.CNMV_CYC_NO" ).append("\n"); 
		query.append("									AND		MM.MVMT_STS_CD		IN	( 'MT', 'ID' )				" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("           -- CHM-201324439 VL시 OP, OC Mapping 로직보완 START" ).append("\n"); 
		query.append("			AND		NOT EXISTS	(" ).append("\n"); 
		query.append("									SELECT 'A'" ).append("\n"); 
		query.append("									FROM    SCE_COP_HDR     H," ).append("\n"); 
		query.append("											SCE_COP_DTL     D" ).append("\n"); 
		query.append("									WHERE   H.CNTR_NO   =   @[cntr_no]  " ).append("\n"); 
		query.append("									AND     H.BKG_NO    =   @[bkg_no]" ).append("\n"); 
		query.append("									AND     H.COP_NO    =   D.COP_NO" ).append("\n"); 
		query.append("									AND     D.ACT_DT    IS NOT NULL" ).append("\n"); 
		query.append("									AND     D.ACT_STS_MAPG_CD   " ).append("\n"); 
		query.append("														=   M.MVMT_STS_CD" ).append("\n"); 
		query.append("								-- CHM-201324675 : VL 검색 추가 --	AND     D.NOD_CD    =   DECODE( M.MVMT_STS_CD, 'OP', D.NOD_CD, M.ORG_YD_CD	)" ).append("\n"); 
		query.append("								-- CHM-201324675 : VL 검색 추가" ).append("\n"); 
		query.append("									AND     D.NOD_CD    LIKE   DECODE( M.MVMT_STS_CD, 	'OP', D.NOD_CD," ).append("\n"); 
		query.append("																					 	'VL', SUBSTR(M.ORG_YD_CD,1,5)," ).append("\n"); 
		query.append("																						'VD', SUBSTR(M.ORG_YD_CD,1,5), -- CHM-201325966" ).append("\n"); 
		query.append("																						M.ORG_YD_CD	)||'%'    " ).append("\n"); 
		query.append("									AND     ROWNUM      =   1" ).append("\n"); 
		query.append("								)			" ).append("\n"); 
		query.append("			-- CHM-201324439 VL시 OP, OC Mapping 로직보완 END						" ).append("\n"); 
		query.append("		) B" ).append("\n"); 
		query.append("    WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("      AND A.CNMV_YR = B.CNMV_YR" ).append("\n"); 
		query.append("      AND A.CNMV_ID_NO = B.CNMV_ID_NO " ).append("\n"); 
		query.append("    ORDER BY B.CNTR_NO, B.CNMV_YR, B.CNMV_ID_NO       -- CHM-201323075 OP/OC/VL Cycle No. 상이시 Cycle -2 체크로직 추가 요청" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}