/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOBlIssueDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOBlIssueDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public BLIssuanceDBDAOBlIssueDtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_dt_sd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("credit_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("obl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOBlIssueDtUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_BL_ISS A1" ).append("\n"); 
		query.append("USING (SELECT @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("			 ,TO_DATE(NVL(@[obl_iss_dt_sd],@[obl_iss_dt]), 'YYYY-MM-DD') AS OBL_ISS_DT" ).append("\n"); 
		query.append("			 ,DECODE(NVL(@[obl_iss_dt_sd], @[obl_iss_dt]), 'N', NULL, @[obl_iss_ofc_cd]) AS OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("			 ,DECODE(NVL(@[obl_iss_dt_sd], @[obl_iss_dt]), 'N', NULL, @[obl_iss_usr_id]) AS OBL_ISS_USR_ID" ).append("\n"); 
		query.append("			 ,NVL(@[obl_iss_flg], 'N') AS OBL_ISS_FLG" ).append("\n"); 
		query.append("			 ,DECODE(NVL(@[obl_iss_flg], 'N'), 'N', NULL, DECODE(@[bl_iss_tp_cd],'B',3,'W',1)) AS BL_CPY_KNT" ).append("\n"); 
		query.append("			 ,DECODE(NVL(@[credit_chk], 'N'), 'Y', 'C', '') AS ORG_PPD_RCV_CD" ).append("\n"); 
		query.append("			 ,DECODE(NVL(@[credit_chk], 'N'), 'N', NULL, @[obl_iss_ofc_cd]) AS ORG_PPD_RCV_UPD_OFC_CD" ).append("\n"); 
		query.append("			 ,DECODE(NVL(@[credit_chk], 'N'), 'N', NULL, @[obl_iss_usr_id]) AS ORG_PPD_RCV_UPD_USR_ID" ).append("\n"); 
		query.append("			 ,DECODE(NVL(@[credit_chk], 'N'), 'N', NULL, sysdate) AS ORG_PPD_RCV_UPD_DT" ).append("\n"); 
		query.append("			 ,NVL(@[bl_iss_tp_cd],'B') AS BL_ISS_TP_CD" ).append("\n"); 
		query.append("		 FROM DUAL" ).append("\n"); 
		query.append("	   ) A2" ).append("\n"); 
		query.append("   ON (A1.BKG_NO = A2.BKG_NO) " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT (A1.BKG_NO, A1.OBL_ISS_DT, A1.OBL_ISS_OFC_CD, A1.OBL_ISS_USR_ID, A1.OBL_ISS_FLG, A1.CRE_USR_ID, A1.CRE_DT, A1.UPD_USR_ID" ).append("\n"); 
		query.append(", A1.UPD_DT, A1.BL_CPY_KNT, A1.ORG_PPD_RCV_CD, A1.ORG_PPD_RCV_UPD_OFC_CD, A1.ORG_PPD_RCV_UPD_USR_ID, A1.ORG_PPD_RCV_UPD_DT, A1.BL_ISS_TP_CD)" ).append("\n"); 
		query.append("	VALUES (A2.BKG_NO, A2.OBL_ISS_DT, A2.OBL_ISS_OFC_CD, A2.OBL_ISS_USR_ID, A2.OBL_ISS_FLG, @[obl_iss_usr_id], SYSDATE, @[obl_iss_usr_id]" ).append("\n"); 
		query.append(", SYSDATE, A2.BL_CPY_KNT, A2.ORG_PPD_RCV_CD, A2.ORG_PPD_RCV_UPD_OFC_CD, A2.ORG_PPD_RCV_UPD_USR_ID, A2.ORG_PPD_RCV_UPD_DT, A2.BL_ISS_TP_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("            UPDATE" ).append("\n"); 
		query.append("               SET A1.OBL_ISS_DT = A2.OBL_ISS_DT" ).append("\n"); 
		query.append("				  ,A1.OBL_ISS_OFC_CD = A2.OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("				  ,A1.OBL_ISS_USR_ID = A2.OBL_ISS_USR_ID" ).append("\n"); 
		query.append("				  ,A1.OBL_ISS_FLG = A2.OBL_ISS_FLG" ).append("\n"); 
		query.append("				  ,A1.UPD_USR_ID = nvl(@[obl_iss_usr_id],@[upd_usr_id])" ).append("\n"); 
		query.append("				  ,A1.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("				  ,A1.ORG_PPD_RCV_CD = NVL(A2.ORG_PPD_RCV_CD, A1.ORG_PPD_RCV_CD)" ).append("\n"); 
		query.append("				  ,A1.ORG_PPD_RCV_UPD_OFC_CD = NVL(A2.ORG_PPD_RCV_UPD_OFC_CD, A1.ORG_PPD_RCV_UPD_OFC_CD)" ).append("\n"); 
		query.append("				  ,A1.ORG_PPD_RCV_UPD_USR_ID = NVL(A2.ORG_PPD_RCV_UPD_USR_ID, A1.ORG_PPD_RCV_UPD_USR_ID)" ).append("\n"); 
		query.append("				  ,A1.ORG_PPD_RCV_UPD_DT = NVL(A2.ORG_PPD_RCV_UPD_DT, A1.ORG_PPD_RCV_UPD_DT)" ).append("\n"); 
		query.append("				  ,A1.BL_ISS_TP_CD = A2.BL_ISS_TP_CD" ).append("\n"); 

	}
}