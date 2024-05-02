/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchBlIssRqstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchBlIssRqstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL Issue 관련 Data를 조회 한다
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchBlIssRqstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_rqst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_rct_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchBlIssRqstListRSQL").append("\n"); 
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
		query.append("SELECT WO_CCD2.CRE_DT" ).append("\n"); 
		query.append("       , XTER_RQST_NO" ).append("\n"); 
		query.append("       , XTER_RQST_SEQ" ).append("\n"); 
		query.append("       , BKG_NO" ).append("\n"); 
		query.append("       , BII_BL_NO                                                                                                       " ).append("\n"); 
		query.append("       , BII_VSL_NM                                                                     " ).append("\n"); 
		query.append("       , BII_VVD                     " ).append("\n"); 
		query.append("       , BL_ON_DT                                                   " ).append("\n"); 
		query.append("       , CUST_CNT_CD " ).append("\n"); 
		query.append("       , CUST_SEQ        " ).append("\n"); 
		query.append("       , BL_ISS_RQST_DT" ).append("\n"); 
		query.append("       , RQST_RCT_LOC_CD" ).append("\n"); 
		query.append("       , BL_NO" ).append("\n"); 
		query.append("       , BL_NO_TP " ).append("\n"); 
		query.append("       , DECODE(NVL(BL_ISS_ACT_DT,''),'',BL_ISS_RJCT_DT,BL_ISS_ACT_DT) BL_ISS_ACT_DT" ).append("\n"); 
		query.append("       , CCD2.INTG_CD_VAL_DESC RQST_BL_TP_CD" ).append("\n"); 
		query.append("       , WO_CCD2.INTG_CD_VAL_DESC BL_ISS_STS_CD" ).append("\n"); 
		query.append("       , BL_ISS_RMK" ).append("\n"); 
		query.append("       , RQST_CO_NM " ).append("\n"); 
		query.append("       , RQST_USR_EML" ).append("\n"); 
		query.append("       , RQST_ATND_NM" ).append("\n"); 
		query.append("       , RQST_PHN_NO" ).append("\n"); 
		query.append("       , BL_RQST_RMK" ).append("\n"); 
		query.append("       , ACT_SHPR_NM" ).append("\n"); 
		query.append("       , ACT_SHPR_RGST_NO" ).append("\n"); 
		query.append("       , TAX_INV_RCVR_CO_NM" ).append("\n"); 
		query.append("       , TAX_INV_RCVR_RGST_NO" ).append("\n"); 
		query.append("       , TAX_INV_RCVR_ATND_NM" ).append("\n"); 
		query.append("       , TAX_INV_RCVR_PHN_NO" ).append("\n"); 
		query.append("       , REMIT_CO_NM" ).append("\n"); 
		query.append("       , REMIT_KND_CD" ).append("\n"); 
		query.append("       , DELT_ID" ).append("\n"); 
		query.append("       , OBL_ISS_FLG" ).append("\n"); 
		query.append("       , VSL_CD" ).append("\n"); 
		query.append("       , SKD_VOY_NO" ).append("\n"); 
		query.append("       , SKD_DIR_CD" ).append("\n"); 
		query.append("       , VVD" ).append("\n"); 
		query.append("       , POL_CD" ).append("\n"); 
		query.append("       , RN" ).append("\n"); 
		query.append("       , VPS_ETD_DT" ).append("\n"); 
		query.append("	   , DECODE(NVL(BL_ISS_RQST_CD,'W'),'W','Web','M','Mobile','Web') BL_ISS_RQST_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT CCD1.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("         , WO_CCD1.*" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT SUB.* " ).append("\n"); 
		query.append("             , TO_CHAR(SKD.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                      SELECT EBL.CRE_DT" ).append("\n"); 
		query.append("                           , EBL.XTER_RQST_NO" ).append("\n"); 
		query.append("                           , EBL.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                           , B.BKG_NO" ).append("\n"); 
		query.append("                           , B.BL_NO BII_BL_NO                                                                                                       " ).append("\n"); 
		query.append("                           , MDM.VSL_ENG_NM BII_VSL_NM                                                                     " ).append("\n"); 
		query.append("                           , V.SKD_VOY_NO||V.SKD_DIR_CD BII_VVD                     " ).append("\n"); 
		query.append("                           , TO_CHAR(BBD.BL_OBRD_DT, 'YYYY-MM-DD') BL_ON_DT                                                   " ).append("\n"); 
		query.append("                           , C.CUST_CNT_CD " ).append("\n"); 
		query.append("                           , C.CUST_SEQ        " ).append("\n"); 
		query.append("                           , TO_CHAR(EBL.BL_ISS_RQST_DT, 'YYYY-MM-DD HH24:MI') BL_ISS_RQST_DT" ).append("\n"); 
		query.append("                           , EBL.RQST_RCT_LOC_CD" ).append("\n"); 
		query.append("                           , B.BL_NO" ).append("\n"); 
		query.append("                           , B.BL_NO_TP " ).append("\n"); 
		query.append("                           , TO_CHAR(EBL.BL_ISS_ACT_DT, 'YYYY-MM-DD HH24:MI') BL_ISS_ACT_DT" ).append("\n"); 
		query.append("                           , TO_CHAR(EBL.BL_ISS_RJCT_DT, 'YYYY-MM-DD HH24:MI') BL_ISS_RJCT_DT" ).append("\n"); 
		query.append("                           , EBL.RQST_BL_TP_CD" ).append("\n"); 
		query.append("                           , DECODE(B.BL_TP_CD,'W','A',EBL.BL_ISS_STS_CD) BL_ISS_STS_CD" ).append("\n"); 
		query.append("                           , EBL.BL_ISS_RMK" ).append("\n"); 
		query.append("                           , EBL.RQST_CO_NM " ).append("\n"); 
		query.append("                           , EBL.RQST_USR_EML" ).append("\n"); 
		query.append("                           , EBL.RQST_ATND_NM" ).append("\n"); 
		query.append("                           , EBL.RQST_PHN_NO" ).append("\n"); 
		query.append("                           , EBL.BL_RQST_RMK" ).append("\n"); 
		query.append("                           , EBL.ACT_SHPR_NM" ).append("\n"); 
		query.append("                           , EBL.ACT_SHPR_RGST_NO" ).append("\n"); 
		query.append("                           , EBL.TAX_INV_RCVR_CO_NM" ).append("\n"); 
		query.append("                           , EBL.TAX_INV_RCVR_RGST_NO" ).append("\n"); 
		query.append("                           , EBL.TAX_INV_RCVR_ATND_NM" ).append("\n"); 
		query.append("                           , EBL.TAX_INV_RCVR_PHN_NO" ).append("\n"); 
		query.append("                           , EBL.REMIT_CO_NM" ).append("\n"); 
		query.append("                           , EBL.REMIT_KND_CD" ).append("\n"); 
		query.append("                           , DECODE(EBL.DELT_FLG, 'Y',EBL.UPD_USR_ID,NULL) DELT_ID" ).append("\n"); 
		query.append("                           , ISS.OBL_ISS_FLG" ).append("\n"); 
		query.append("                           , V.VSL_CD" ).append("\n"); 
		query.append("                           , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                           , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                           , V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                           , V.POL_CD" ).append("\n"); 
		query.append("                           , DENSE_RANK() OVER (PARTITION BY V.BKG_NO ORDER BY V.VSL_PRE_PST_CD||V.VSL_SEQ) RN" ).append("\n"); 
		query.append("						   , EBL.BL_ISS_RQST_CD" ).append("\n"); 
		query.append("                      FROM  BKG_BOOKING B                                                                                " ).append("\n"); 
		query.append("                           , BKG_CUSTOMER C " ).append("\n"); 
		query.append("                           , BKG_BL_DOC BBD " ).append("\n"); 
		query.append("                           , BKG_VVD V " ).append("\n"); 
		query.append("                           , MDM_VSL_CNTR MDM " ).append("\n"); 
		query.append("                           , BKG_BL_ISS ISS" ).append("\n"); 
		query.append("                           , BKG_BL_ISS_RQST EBL" ).append("\n"); 
		query.append("                           #if (${ofc_cd} != '') " ).append("\n"); 
		query.append("                           , COM_USER USR" ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("                      WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                      AND B.BKG_NO = BBD.BKG_NO" ).append("\n"); 
		query.append("                      AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                      AND B.VSL_CD = MDM.VSL_CD" ).append("\n"); 
		query.append("                      #if (${ofc_cd} != '') " ).append("\n"); 
		query.append("                      AND EBL.BL_ISS_USR_ID = USR.USR_ID" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      AND B.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("                      AND B.BL_NO = EBL.BL_NO(+)" ).append("\n"); 
		query.append("                      AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                      #if (${rqst_from_dt} != '') " ).append("\n"); 
		query.append("                      AND EBL.BL_ISS_RQST_DT >= TO_DATE(@[rqst_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${rqst_to_dt} != '') " ).append("\n"); 
		query.append("                      AND EBL.BL_ISS_RQST_DT < TO_DATE(@[rqst_to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${bl_no} != '') " ).append("\n"); 
		query.append("                      AND EBL.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${rqst_rct_loc_cd} != '') " ).append("\n"); 
		query.append("                      AND EBL.RQST_RCT_LOC_CD = @[rqst_rct_loc_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${rqst_bl_tp_cd} != 'All' && ${rqst_bl_tp_cd} != '') " ).append("\n"); 
		query.append("                      AND EBL.RQST_BL_TP_CD = @[rqst_bl_tp_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${bl_iss_rqst_cd} != 'All' && ${bl_iss_rqst_cd} != '') " ).append("\n"); 
		query.append("                      AND EBL.BL_ISS_RQST_CD = @[bl_iss_rqst_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${vvd} != '') " ).append("\n"); 
		query.append("                      AND EBL.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                      AND EBL.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                      AND EBL.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${bl_iss_sts_cd} != 'All' && ${bl_iss_sts_cd} != '') " ).append("\n"); 
		query.append("                      AND DECODE(B.BL_TP_CD,'W','A',EBL.BL_ISS_STS_CD) LIKE @[bl_iss_sts_cd]||'%'" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${rqst_co_nm} != '') " ).append("\n"); 
		query.append("                      AND EBL.RQST_CO_NM LIKE '%'||@[rqst_co_nm]||'%'" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${delt_flg} != '') " ).append("\n"); 
		query.append("                      AND EBL.DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${pol_cd} != '') " ).append("\n"); 
		query.append("                      AND B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      #if (${ofc_cd} != '') " ).append("\n"); 
		query.append("                      AND USR.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      AND C.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                  ) SUB" ).append("\n"); 
		query.append("                    , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                  WHERE SUB.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("                    AND SUB.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND SUB.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND SUB.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                    AND SKD.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                    AND SUB.RN = 1" ).append("\n"); 
		query.append("        ) WO_CCD1" ).append("\n"); 
		query.append("        , COM_INTG_CD_DTL CCD1" ).append("\n"); 
		query.append("        WHERE CCD1.INTG_CD_ID = 'CD02808' " ).append("\n"); 
		query.append("        AND WO_CCD1.BL_ISS_STS_CD = CCD1.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("    ) WO_CCD2" ).append("\n"); 
		query.append("    , COM_INTG_CD_DTL CCD2" ).append("\n"); 
		query.append("WHERE CCD2.INTG_CD_ID = 'CD02807' AND" ).append("\n"); 
		query.append("WO_CCD2.RQST_BL_TP_CD = CCD2.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("ORDER BY CRE_DT ASC" ).append("\n"); 

	}
}