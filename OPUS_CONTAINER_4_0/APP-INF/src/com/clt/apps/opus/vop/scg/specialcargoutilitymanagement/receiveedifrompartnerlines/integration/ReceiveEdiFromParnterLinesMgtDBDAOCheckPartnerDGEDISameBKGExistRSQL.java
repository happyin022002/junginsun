/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOCheckPartnerDGEDISameBKGExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOCheckPartnerDGEDISameBKGExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partner SEQ 존재여부확인
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOCheckPartnerDGEDISameBKGExistRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOCheckPartnerDGEDISameBKGExistRSQL").append("\n"); 
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
		query.append("SELECT 	RQS.BKG_REF_NO" ).append("\n"); 
		query.append("FROM 	SCG_PRNR_APRO_RQST 		RQS" ).append("\n"); 
		query.append("	,	SCG_PRNR_APRO_RQST_CGO 	CGO" ).append("\n"); 
		query.append("WHERE 	RQS.CRR_CD 				= CGO.CRR_CD 				(+)" ).append("\n"); 
		query.append("AND 	RQS.BKG_REF_NO 			= CGO.BKG_REF_NO			(+)" ).append("\n"); 
		query.append("AND 	RQS.SPCL_CGO_RQST_SEQ 	= CGO.SPCL_CGO_RQST_SEQ		(+)" ).append("\n"); 
		query.append("AND 	RQS.PRNR_CGO_RQST_SEQ 	= CGO.PRNR_CGO_RQST_SEQ		(+)" ).append("\n"); 
		query.append("AND		RQS.CRR_CD				= COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("AND 	RQS.BKG_REF_NO        	= @[bkg_ref_no]" ).append("\n"); 
		query.append("AND 	CGO.CGO_OPR_CD 	(+)		= @[cgo_opr_cd]" ).append("\n"); 
		query.append("AND     RQS.DG_FLG              = 'Y'" ).append("\n"); 
		query.append("----AND 	CGO.SPCL_CGO_CATE_CD= [spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("AND		RQS.VSL_CD				= @[vsl_cd]" ).append("\n"); 
		query.append("AND		RQS.SKD_VOY_NO			= @[skd_voy_no]" ).append("\n"); 
		query.append("AND		RQS.SKD_DIR_CD			= @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("----AND 	(RQS.POL_CD 			= NVL(SUBSTR([pol_cd],1,5),RQS.POL_CD)" ).append("\n"); 
		query.append("----		 OR" ).append("\n"); 
		query.append("----		 RQS.POD_CD 			= NVL(SUBSTR([pod_cd],1,5),RQS.POD_CD)" ).append("\n"); 
		query.append("----		)" ).append("\n"); 

	}
}