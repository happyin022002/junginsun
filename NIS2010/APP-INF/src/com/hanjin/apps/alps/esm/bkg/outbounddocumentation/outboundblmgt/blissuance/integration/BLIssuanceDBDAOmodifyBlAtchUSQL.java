/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOmodifyBlAtchUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19 
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

public class BLIssuanceDBDAOmodifyBlAtchUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOmodifyBlAtchUSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOmodifyBlAtchUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("payr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("payr_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bl_chg_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOmodifyBlAtchUSQL").append("\n"); 
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
		query.append("UPDATE (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		 STO.FILE_NM AS IMG_FILE_NM" ).append("\n"); 
		query.append("		,STO.FILE_PATH_RMK AS IMG_FILE_PATH" ).append("\n"); 
		query.append("		,UPLD.FILE_UPLD_NM AS UPLD_FILE_NM" ).append("\n"); 
		query.append("		,UPLD.FILE_PATH_URL AS UPLD_FILE_PATH" ).append("\n"); 
		query.append("	FROM BKG_N3RD_PTY_BL_FILE_STO STO, COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("	WHERE STO.FILE_SAV_ID = UPLD.FILE_SAV_ID" ).append("\n"); 
		query.append("	  AND STO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND STO.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("      AND STO.N3PTY_OFC_CD = @[n3pty_ofc_cd]" ).append("\n"); 
		query.append("      AND STO.PAYR_CUST_CNT_CD = @[payr_cust_cnt_cd]" ).append("\n"); 
		query.append("      AND STO.PAYR_CUST_SEQ = @[payr_cust_seq]" ).append("\n"); 
		query.append("      AND STO.OBL_ISS_OFC_CD = @[obl_iss_ofc_cd]" ).append("\n"); 
		query.append("      AND STO.N3PTY_BL_CHG_TTL_AMT = @[n3pty_bl_chg_ttl_amt]" ).append("\n"); 
		query.append("      AND STO.FRT_TERM_CD = @[frt_term_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("IMG_FILE_NM = UPLD_FILE_NM," ).append("\n"); 
		query.append("IMG_FILE_PATH = UPLD_FILE_PATH" ).append("\n"); 

	}
}