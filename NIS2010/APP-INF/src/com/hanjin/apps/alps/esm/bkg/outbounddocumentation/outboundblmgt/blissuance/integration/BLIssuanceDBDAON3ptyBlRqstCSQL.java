/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAON3ptyBlRqstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.10 
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

public class BLIssuanceDBDAON3ptyBlRqstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAON3ptyBlRqstCSQL
	  * </pre>
	  */
	public BLIssuanceDBDAON3ptyBlRqstCSQL(){
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
		params.put("payr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : BLIssuanceDBDAON3ptyBlRqstCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_N3RD_PTY_BL_BIL_RQST AA" ).append("\n"); 
		query.append("     USING (" ).append("\n"); 
		query.append("            SELECT @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("                  ,POL_CD " ).append("\n"); 
		query.append("                  ,@[n3pty_ofc_cd] AS N3PTY_OFC_CD" ).append("\n"); 
		query.append("                  ,@[payr_cust_cnt_cd] AS PAYR_CUST_CNT_CD" ).append("\n"); 
		query.append("                  ,@[payr_cust_seq] AS PAYR_CUST_SEQ" ).append("\n"); 
		query.append("                  ,@[frt_term_cd] as FRT_TERM_CD" ).append("\n"); 
		query.append("                  ,@[n3pty_bl_chg_ttl_amt] as N3PTY_BL_CHG_TTL_AMT" ).append("\n"); 
		query.append("                  ,NVL(REPLACE(@[bl_iss_ofc_cd],' ',''),'X') as OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("              FROM BKG_BOOKING" ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           ) BB" ).append("\n"); 
		query.append("        ON (    AA.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("            AND AA.POL_CD = BB.POL_CD " ).append("\n"); 
		query.append("            AND AA.N3PTY_OFC_CD = BB.N3PTY_OFC_CD" ).append("\n"); 
		query.append("            AND AA.PAYR_CUST_CNT_CD = BB.PAYR_CUST_CNT_CD " ).append("\n"); 
		query.append("            AND AA.PAYR_CUST_SEQ = BB.PAYR_CUST_SEQ " ).append("\n"); 
		query.append("            AND AA.FRT_TERM_CD = BB.FRT_TERM_CD " ).append("\n"); 
		query.append("            AND AA.N3PTY_BL_CHG_TTL_AMT = BB.N3PTY_BL_CHG_TTL_AMT " ).append("\n"); 
		query.append("            AND AA.OBL_ISS_OFC_CD = BB.OBL_ISS_OFC_CD " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT  (BKG_NO" ).append("\n"); 
		query.append("        ,POL_CD" ).append("\n"); 
		query.append("        ,N3PTY_OFC_CD" ).append("\n"); 
		query.append("        ,PAYR_CUST_CNT_CD" ).append("\n"); 
		query.append("        ,PAYR_CUST_SEQ" ).append("\n"); 
		query.append("        ,SHPR_CNTC_PHN_NO" ).append("\n"); 
		query.append("        ,N3PTY_BL_STS_CD" ).append("\n"); 
		query.append("        ,N3PTY_BL_STS_UPD_DT" ).append("\n"); 
		query.append("        ,N3PTY_BL_STS_RQST_USR_ID" ).append("\n"); 
		query.append("        ,BL_RMK" ).append("\n"); 
		query.append("        ,BL_ATCH_RMK " ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("        ,FRT_TERM_CD" ).append("\n"); 
		query.append("        ,N3PTY_BL_STS_RQST_DT" ).append("\n"); 
		query.append("        ,N3PTY_BL_CHG_TTL_AMT" ).append("\n"); 
		query.append("        ,OBL_ISS_OFC_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES(BB.BKG_NO" ).append("\n"); 
		query.append("      ,BB.POL_CD" ).append("\n"); 
		query.append("      ,BB.N3PTY_OFC_CD" ).append("\n"); 
		query.append("      ,BB.PAYR_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,BB.PAYR_CUST_SEQ" ).append("\n"); 
		query.append("      ,(SELECT PHN_NO FROM MDM_CUST_CNTC_PNT PNT WHERE BB.PAYR_CUST_CNT_CD=CUST_CNT_CD AND BB.PAYR_CUST_SEQ=CUST_SEQ)" ).append("\n"); 
		query.append("      ,'R'" ).append("\n"); 
		query.append("      ,null" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,''" ).append("\n"); 
		query.append("      ,''" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,BB.FRT_TERM_CD" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,BB.N3PTY_BL_CHG_TTL_AMT" ).append("\n"); 
		query.append("      ,BB.OBL_ISS_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}