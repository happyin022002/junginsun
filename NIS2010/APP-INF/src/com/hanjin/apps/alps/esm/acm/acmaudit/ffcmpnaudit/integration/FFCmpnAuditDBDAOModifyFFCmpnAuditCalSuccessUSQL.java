/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAuditDBDAOModifyFFCmpnAuditCalSuccessUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.12
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.12 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnAuditDBDAOModifyFFCmpnAuditCalSuccessUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyFFCmpnAuditCalSuccess
	  * </pre>
	  */
	public FFCmpnAuditDBDAOModifyFFCmpnAuditCalSuccessUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.integration").append("\n"); 
		query.append("FileName : FFCmpnAuditDBDAOModifyFFCmpnAuditCalSuccessUSQL").append("\n"); 
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
		query.append("UPDATE ACM_FF_CMPN			" ).append("\n"); 
		query.append("       SET BKG_FF_CNT_CD   = @[bkg_ff_cnt_cd],			" ).append("\n"); 
		query.append("           BKG_FF_SEQ      = @[bkg_ff_seq],			" ).append("\n"); 
		query.append("           VNDR_CNT_CD     = @[vndr_cnt_cd],			" ).append("\n"); 
		query.append("           VNDR_SEQ        = @[vndr_seq],			" ).append("\n"); 
		query.append("	       FF_CMPN_STS_CD  = 'CM',		" ).append("\n"); 
		query.append("           FMC_NO          = @[fmc_no]," ).append("\n"); 
		query.append("	       FF_REF_NO       = @[ff_ref_no],		" ).append("\n"); 
		query.append("	       UPD_USR_ID      = @[usr_id],		" ).append("\n"); 
		query.append("	       UPD_DT          = SYSDATE		" ).append("\n"); 
		query.append("     WHERE BKG_NO          = @[bkg_no]			" ).append("\n"); 
		query.append("       AND FF_CMPN_SEQ          = @[ff_cmpn_seq]			" ).append("\n"); 
		query.append("       AND AP_OFC_CD        IS NOT NULL			" ).append("\n"); 
		query.append("       AND FF_CMPN_STS_CD != 'IF'" ).append("\n"); 

	}
}