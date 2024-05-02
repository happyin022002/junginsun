/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dangerous CGO Application Details for Partner Lines 의 No 생성
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstNoRSQL").append("\n"); 
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
		query.append("UPDATE SCG_PRNR_APRO_RQST_CGO CGO" ).append("\n"); 
		query.append("SET CGO.APRO_REF_NO = NVL (" ).append("\n"); 
		query.append("                             ( SELECT  MAX ( DECODE ( C.APRO_REF_NO, '0', NULL , C.APRO_REF_NO ) )" ).append("\n"); 
		query.append("                               FROM    SCG_PRNR_APRO_RQST_CGO C" ).append("\n"); 
		query.append("                               WHERE   C.BKG_REF_NO        = CGO.BKG_REF_NO" ).append("\n"); 
		query.append("                               AND     C.APRO_REF_NO       LIKE @[cgo_opr_cd]||SUBSTR( @[pol_cd], 3, 3 ) || TO_CHAR(SYSDATE,'YYMMDD' )||'___' )," ).append("\n"); 
		query.append("                             ( SELECT  @[cgo_opr_cd]||SUBSTR(@[pol_cd], 3, 3 ) ||TO_CHAR(SYSDATE,'YYMMDD') || " ).append("\n"); 
		query.append("                                       LPAD(NVL(MAX(TO_NUMBER(SUBSTR(D.APRO_REF_NO,LENGTH(D.APRO_REF_NO)-2,LENGTH(D.APRO_REF_NO)))),'0')+1,3,'0')" ).append("\n"); 
		query.append("                               FROM    SCG_PRNR_APRO_RQST_CGO D" ).append("\n"); 
		query.append("                               WHERE   D.APRO_REF_NO       LIKE @[cgo_opr_cd]||SUBSTR( @[pol_cd], 3, 3 ) || TO_CHAR(SYSDATE,'YYMMDD' )||'___' )" ).append("\n"); 
		query.append("/*			" ).append("\n"); 
		query.append("                             ( SELECT MAX(CGO.CGO_OPR_CD) || MAX(SUBSTR(B.POL_CD, 3, LENGTH(B.POL_CD))) || TO_CHAR(SYSDATE, 'YYMMDD')" ).append("\n"); 
		query.append("                                  ||LPAD(NVL(MAX(TO_NUMBER(SUBSTR(C.APRO_REF_NO,LENGTH(C.APRO_REF_NO)-2,LENGTH(C.APRO_REF_NO)))),'0')+1,3,'0')" ).append("\n"); 
		query.append("                               FROM SCG_PRNR_APRO_RQST B" ).append("\n"); 
		query.append("                                  , SCG_PRNR_APRO_RQST_CGO C" ).append("\n"); 
		query.append("                              WHERE B.CRR_CD            = CGO.CRR_CD" ).append("\n"); 
		query.append("                                AND B.BKG_REF_NO        = CGO.BKG_REF_NO" ).append("\n"); 
		query.append("                                AND B.SPCL_CGO_RQST_SEQ = CGO.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                AND B.CRR_CD            = C.CRR_CD" ).append("\n"); 
		query.append("                                AND B.BKG_REF_NO        = C.BKG_REF_NO" ).append("\n"); 
		query.append("                                AND C.CGO_OPR_CD        = CGO.CGO_OPR_CD )" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("                          ) " ).append("\n"); 
		query.append("   , CGO.AUTH_DT = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[auth_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append("   , CGO.AUTH_OFC_CD = @[auth_ofc_cd]" ).append("\n"); 
		query.append("   , CGO.AUTH_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("   , UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("   , UPD_DT      = SYSDATE" ).append("\n"); 
		query.append(" WHERE CGO.CRR_CD            = @[crr_cd]" ).append("\n"); 
		query.append("   AND CGO.BKG_REF_NO        = @[bkg_ref_no]" ).append("\n"); 
		query.append("   AND EXISTS (" ).append("\n"); 
		query.append("       SELECT 'Y'" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("              SELECT A.CRR_CD" ).append("\n"); 
		query.append("                   , A.BKG_REF_NO" ).append("\n"); 
		query.append("                   , A.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                   , A.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("                   , A.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                   , DECODE(NVL(A.APRO_REF_NO,'X'),'0','X',A.APRO_REF_NO) APRO_REF_NO" ).append("\n"); 
		query.append("                   , AVG(DECODE(A.AUTH_STS_CD,'Y',1,0)) OVER(PARTITION BY A.CRR_CD, A.BKG_REF_NO, A.SPCL_CGO_RQST_SEQ) STS_CT" ).append("\n"); 
		query.append("                FROM SCG_PRNR_APRO_RQST_CGO A" ).append("\n"); 
		query.append("         ) G" ).append("\n"); 
		query.append("        WHERE G.CRR_CD            = CGO.CRR_CD" ).append("\n"); 
		query.append("          AND G.BKG_REF_NO        = CGO.BKG_REF_NO" ).append("\n"); 
		query.append("          AND G.SPCL_CGO_RQST_SEQ = CGO.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("          AND G.SPCL_CNTR_SEQ     = CGO.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("          AND G.SPCL_CGO_SEQ      = CGO.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("          AND G.STS_CT            = 1" ).append("\n"); 
		query.append("          AND G.APRO_REF_NO       = 'X'" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}