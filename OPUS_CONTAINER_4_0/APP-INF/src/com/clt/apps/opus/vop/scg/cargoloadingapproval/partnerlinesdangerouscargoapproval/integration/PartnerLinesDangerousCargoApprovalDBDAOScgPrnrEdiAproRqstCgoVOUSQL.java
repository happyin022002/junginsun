/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrEdiAproRqstCgoVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOScgPrnrEdiAproRqstCgoVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCL CGO APVL for Partner Lines 의 Request Cago 수정
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOScgPrnrEdiAproRqstCgoVOUSQL(){
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
		params.put("dcgo_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrEdiAproRqstCgoVOUSQL").append("\n"); 
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
		query.append("UPDATE 	SCG_PRNR_APRO_RQST_CGO 		X" ).append("\n"); 
		query.append("SET		X.AUTH_STS_CD 				= DECODE(X.AUTH_STS_CD,NULL,NULL,'C')	-- :2015-07-25 'C'-canceled << 'X': --" ).append("\n"); 
		query.append("     , 	X.UPD_USR_ID  				= @[upd_usr_id]" ).append("\n"); 
		query.append("     , 	X.UPD_DT      				= SYSDATE" ).append("\n"); 
		query.append("WHERE 	X.CRR_CD            		= COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND 	X.BKG_REF_NO        		= @[bkg_ref_no]" ).append("\n"); 
		query.append("--AND 	X.SPCL_CGO_RQST_SEQ 		= [spcl_cgo_rqst_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND 	X.DCGO_REF_NO       		= @[dcgo_ref_no]" ).append("\n"); 
		query.append("AND 	NVL(X.AUTH_STS_CD,'*') 		NOT IN ('Y','N')						-- ::2015-07-25 'C' << 'X': 'Y'-approved,'N'-rejected:: --" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   	X.CGO_OPR_CD            	= @[cgo_opr_cd] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   	EXISTS                  	(SELECT   ''" ).append("\n"); 
		query.append("                               		 FROM     SCG_PRNR_APRO_RQST   XX" ).append("\n"); 
		query.append("                               		 WHERE    XX.DG_FLG            = 'Y'" ).append("\n"); 
		query.append("                               		 AND      XX.CRR_CD            = X.CRR_CD" ).append("\n"); 
		query.append("                               		 AND      XX.BKG_REF_NO        = X.BKG_REF_NO" ).append("\n"); 
		query.append("                               		 AND      XX.SPCL_CGO_RQST_SEQ = X.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                               		 AND      XX.PRNR_CGO_RQST_SEQ = X.PRNR_CGO_RQST_SEQ  " ).append("\n"); 
		query.append("                               		 AND      XX.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("                               		 AND      XX.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("                               		 AND      XX.SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("                               		 ----AND      XX.POL_CD        = NVL([pol_cd],XX.POL_CD)" ).append("\n"); 
		query.append("                               		 ----AND      XX.POD_CD        = NVL([pod_cd],XX.POD_CD)" ).append("\n"); 
		query.append("									 AND	  XX.LST_RQST_DAT_FLG  = 'Y'" ).append("\n"); 
		query.append("									 AND	  XX.SRC_TP_CD		   = 'EDI'	-- ::'EDI','MNL':: --" ).append("\n"); 
		query.append("                               		)" ).append("\n"); 

	}
}