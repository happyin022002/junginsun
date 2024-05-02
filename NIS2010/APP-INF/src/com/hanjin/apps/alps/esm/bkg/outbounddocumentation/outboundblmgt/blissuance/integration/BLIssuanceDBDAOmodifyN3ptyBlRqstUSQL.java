/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOmodifyN3ptyBlRqstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.18 
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

public class BLIssuanceDBDAOmodifyN3ptyBlRqstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOmodifyN3ptyBlRqstUSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOmodifyN3ptyBlRqstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bl_chg_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payr_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_bl_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_atch",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOmodifyN3ptyBlRqstUSQL").append("\n"); 
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
		query.append("UPDATE BKG_N3RD_PTY_BL_BIL_RQST" ).append("\n"); 
		query.append("   SET SHPR_CNTC_PHN_NO = @[shpr_cntc_phn_no] ," ).append("\n"); 
		query.append("       N3PTY_BL_STS_CD = @[n3pty_bl_sts_cd] ," ).append("\n"); 
		query.append("#if (${n3pty_bl_sts_cd} != 'R') " ).append("\n"); 
		query.append("       N3PTY_BL_STS_UPD_DT = DECODE(@[chg_flg],'Y',sysdate,TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS')) ," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("       N3PTY_BL_STS_UPD_DT = TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS')," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BL_RMK  = @[bl_rmk] ," ).append("\n"); 
		query.append("#if (${n3pty_bl_sts_cd} == 'R') " ).append("\n"); 
		query.append("       N3PTY_BL_STS_RQST_DT = DECODE(@[chg_flg],'Y',sysdate,TO_DATE(@[rqst_dt],'YYYY/MM/DD HH24:MI:SS')) ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       N3PTY_BL_STS_RQST_USR_ID = DECODE(@[chg_flg],'Y',@[upd_usr_id],@[usr_id]) ," ).append("\n"); 
		query.append("       BL_ATCH_RMK  = @[bl_atch] ," ).append("\n"); 
		query.append("       UPD_USR_ID = @[upd_usr_id] ," ).append("\n"); 
		query.append("       UPD_DT = sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("   AND N3PTY_OFC_CD = @[n3pty_ofc_cd]" ).append("\n"); 
		query.append("   AND PAYR_CUST_CNT_CD = SUBSTR(@[payr_cust_cd],0,2)" ).append("\n"); 
		query.append("   AND PAYR_CUST_SEQ = SUBSTR(@[payr_cust_cd],3)" ).append("\n"); 
		query.append("   AND FRT_TERM_CD = @[frt_term_cd]" ).append("\n"); 
		query.append("   AND N3PTY_BL_CHG_TTL_AMT = @[n3pty_bl_chg_ttl_amt]" ).append("\n"); 
		query.append("   AND OBL_ISS_OFC_CD = @[bl_iss_ofc_cd]" ).append("\n"); 

	}
}