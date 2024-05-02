/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgAproRefNoVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOScgAproRefNoVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_AUTHORIZATION APRO_REF_NO 수정(생성)
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgAproRefNoVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_pre_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgAproRefNoVOUSQL").append("\n"); 
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
		query.append("UPDATE SCG_AUTHORIZATION SET " ).append("\n"); 
		query.append("	APRO_REF_NO = (	SELECT  DECODE(COUNT(A.BKG_NO),  (" ).append("\n"); 
		query.append("								#if (${scg_flg} == 'DG1' || ${scg_flg} == 'DG2')" ).append("\n"); 
		query.append("								SELECT COUNT(BKG_NO) FROM " ).append("\n"); 
		query.append("									BKG_DG_CGO " ).append("\n"); 
		query.append("								WHERE BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("								AND   SPCL_CGO_APRO_CD NOT IN ('C','D')" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${scg_flg} == 'AWK')" ).append("\n"); 
		query.append("								SELECT COUNT(BKG_NO) FROM " ).append("\n"); 
		query.append("									BKG_AWK_CGO" ).append("\n"); 
		query.append("								WHERE BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("								AND   SPCL_CGO_APRO_CD NOT IN ('C','D')" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${scg_flg} == 'BB')" ).append("\n"); 
		query.append("								SELECT COUNT(BKG_NO) FROM " ).append("\n"); 
		query.append("									BKG_BB_CGO" ).append("\n"); 
		query.append("								WHERE BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("								AND   SPCL_CGO_APRO_CD NOT IN ('C','D')" ).append("\n"); 
		query.append("							    #end" ).append("\n"); 
		query.append("								#if (${scg_flg} == 'RF')" ).append("\n"); 
		query.append("								SELECT COUNT(BKG_NO) FROM " ).append("\n"); 
		query.append("									BKG_RF_CGO" ).append("\n"); 
		query.append("								WHERE BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("								AND   SPCL_CGO_APRO_CD NOT IN ('C','D')" ).append("\n"); 
		query.append("							    #end" ).append("\n"); 
		query.append("								#if (${scg_flg} == 'SS')" ).append("\n"); 
		query.append("									 COUNT (A.BKG_NO)" ).append("\n"); 
		query.append("							    #end" ).append("\n"); 
		query.append(" 								), " ).append("\n"); 
		query.append("								--2016-10-26 TimeOut Exception 발생 후 수정 처리" ).append("\n"); 
		query.append("								@[apro_ref_no]" ).append("\n"); 
		query.append("								--2016-10-26" ).append("\n"); 
		query.append("								, ''" ).append("\n"); 
		query.append("		        				) AS APRO_REF_NO " ).append("\n"); 
		query.append("					FROM SCG_AUTHORIZATION A" ).append("\n"); 
		query.append("					WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("					AND	SPCL_CGO_APRO_RQST_SEQ = @[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("					AND	VSL_PRE_PST_CD = @[vsl_pre_pst_cd]" ).append("\n"); 
		query.append("					AND	VSL_SEQ = @[vsl_seq]" ).append("\n"); 
		query.append("					AND SPCL_CGO_AUTH_CD = 'Y'" ).append("\n"); 
		query.append("					GROUP BY A.BKG_NO" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	SPCL_CGO_APRO_RQST_SEQ = @[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("AND	VSL_PRE_PST_CD = @[vsl_pre_pst_cd]" ).append("\n"); 
		query.append("AND	VSL_SEQ = @[vsl_seq]" ).append("\n"); 

	}
}