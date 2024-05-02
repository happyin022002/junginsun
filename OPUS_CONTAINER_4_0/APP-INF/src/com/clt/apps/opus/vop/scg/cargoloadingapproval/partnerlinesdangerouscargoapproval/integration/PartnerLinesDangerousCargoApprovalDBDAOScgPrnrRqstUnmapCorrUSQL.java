/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrRqstUnmapCorrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
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

public class PartnerLinesDangerousCargoApprovalDBDAOScgPrnrRqstUnmapCorrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_PRNR_RQST_UNMAP 데이터 CORR UPDATE
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOScgPrnrRqstUnmapCorrUSQL(){
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
		params.put("prnr_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_unmap_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_unmap_corr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrRqstUnmapCorrUSQL").append("\n"); 
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
		query.append("UPDATE SCG_PRNR_RQST_UNMAP" ).append("\n"); 
		query.append("   SET EDI_UNMAP_CORR_RSLT_CD = 'Y' ," ).append("\n"); 
		query.append("       EDI_UNMAP_CORR_DT = sysdate," ).append("\n"); 
		query.append("       EDI_UNMAP_CORR_RMK  = @[edi_unmap_corr_rmk]" ).append("\n"); 
		query.append(" WHERE CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("   AND BKG_REF_NO = @[bkg_ref_no]" ).append("\n"); 
		query.append("   AND SPCL_CGO_RQST_SEQ = @[spcl_cgo_rqst_seq]" ).append("\n"); 
		query.append("   AND PRNR_CGO_RQST_SEQ = @[prnr_cgo_rqst_seq]" ).append("\n"); 
		query.append("   AND EDI_UNMAP_DTL_CD  = @[edi_unmap_dtl_cd]" ).append("\n"); 

	}
}