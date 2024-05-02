/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOBlIssueDtHistoryUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOBlIssueDtHistoryUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlIssueDtHistory
	  * </pre>
	  */
	public BLIssuanceDBDAOBlIssueDtHistoryUSQL(){
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
		params.put("obl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_iss_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOBlIssueDtHistoryUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BL_ISS_HIS" ).append("\n"); 
		query.append("	SET OBL_ISS_DT = TO_DATE(NVL(@[obl_iss_dt_sd],@[obl_iss_dt]), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("       ,OBL_ISS_OFC_CD = DECODE(NVL(@[obl_iss_dt_sd], @[obl_iss_dt]), 'N', NULL, @[obl_iss_ofc_cd])" ).append("\n"); 
		query.append("	   ,OBL_ISS_USR_ID = DECODE(NVL(@[obl_iss_dt_sd], @[obl_iss_dt]), 'N', NULL, @[obl_iss_usr_id])" ).append("\n"); 
		query.append("	   ,OBL_ISS_FLG = NVL(@[obl_iss_flg], 'N')" ).append("\n"); 
		query.append("	   ,UPD_USR_ID = nvl(@[obl_iss_usr_id],@[upd_usr_id])" ).append("\n"); 
		query.append("	   ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	   ,ORG_PPD_RCV_CD = NVL(DECODE(NVL(@[credit_chk], 'N'), 'Y', 'C', ''), ORG_PPD_RCV_CD)" ).append("\n"); 
		query.append("	   ,ORG_PPD_RCV_UPD_OFC_CD = NVL(DECODE(NVL(@[credit_chk], 'N'), 'N', NULL, @[obl_iss_ofc_cd]), ORG_PPD_RCV_UPD_OFC_CD)" ).append("\n"); 
		query.append("	   ,ORG_PPD_RCV_UPD_USR_ID = NVL(DECODE(NVL(@[credit_chk], 'N'), 'N', NULL, @[obl_iss_usr_id]), ORG_PPD_RCV_UPD_USR_ID)" ).append("\n"); 
		query.append("	   ,ORG_PPD_RCV_UPD_DT = NVL(DECODE(NVL(@[credit_chk], 'N'), 'N', NULL, sysdate), ORG_PPD_RCV_UPD_DT)" ).append("\n"); 
		query.append("	   ,BL_ISS_TP_CD = NVL(@[bl_iss_tp_cd],'B')" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 

	}
}