/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOUpdatePrnrAproRqstforDGCancellationUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.24 
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

public class ReceiveEdiFromParnterLinesMgtDBDAOUpdatePrnrAproRqstforDGCancellationUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DG EDI Cancellation
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOUpdatePrnrAproRqstforDGCancellationUSQL(){
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsm_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOUpdatePrnrAproRqstforDGCancellationUSQL").append("\n"); 
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
		query.append("UPDATE 		SCG_PRNR_APRO_RQST				X" ).append("\n"); 
		query.append("SET			X.MAPG_TRSM_BND_CD            	= @[trsm_bnd_cd] " ).append("\n"); 
		query.append("       	,  	X.MAPG_PRNR_SPCL_CGO_SEQ      	= @[prnr_spcl_cgo_seq]" ).append("\n"); 
		query.append("       	,  	X.MAPG_TRSM_SPCL_CGO_CATE_CD  	= 'DG'" ).append("\n"); 
		query.append("       	,  	X.MAPG_EDI_TRSM_STS_CD        	= 'R'" ).append("\n"); 
		query.append("     	, 	X.UPD_USR_ID           			= @[upd_usr_id]" ).append("\n"); 
		query.append("     	, 	X.UPD_DT               			= SYSDATE" ).append("\n"); 
		query.append("WHERE 		1 = 1" ).append("\n"); 
		query.append("AND 		X.LST_RQST_DAT_FLG     			= 'Y'" ).append("\n"); 
		query.append("----	AND 	X.MAPG_EDI_TRSM_STS_CD 	= 'R'	-- ['N':SEND, 'F':FAIL, 'S':SUCCESS, 'R':RECEIVED] --" ).append("\n"); 
		query.append("AND			X.CRR_CD               			= DECODE(@[crr_cd],NULL,COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(),@[crr_cd])" ).append("\n"); 
		query.append("AND 		X.BKG_REF_NO           			= @[bkg_ref_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   		X.VSL_CD           				= @[vsl_cd]		" ).append("\n"); 
		query.append("AND   		X.SKD_VOY_NO       				= @[skd_voy_no]	" ).append("\n"); 
		query.append("AND   		X.SKD_DIR_CD       				= @[skd_dir_cd]	" ).append("\n"); 
		query.append("AND   		X.POL_CD           				= @[pol_cd]		" ).append("\n"); 
		query.append("AND   		X.POD_CD           				= NVL(@[pod_cd],X.POD_CD)	/* Empty in case of cancellation EDI */		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     	EXISTS                			(	SELECT   ''" ).append("\n"); 
		query.append("                               	 				FROM     SCG_PRNR_APRO_RQST_CGO 	XX" ).append("\n"); 
		query.append("                               	 				WHERE    XX.CRR_CD              	= X.CRR_CD" ).append("\n"); 
		query.append("                               	 				AND      XX.BKG_REF_NO          	= X.BKG_REF_NO" ).append("\n"); 
		query.append("                               	 				AND      XX.SPCL_CGO_RQST_SEQ   	= X.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                               	 				AND      XX.PRNR_CGO_RQST_SEQ		= X.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                               	 				AND      XX.CGO_OPR_CD          	= @[cgo_opr_cd]" ).append("\n"); 
		query.append("                               				)" ).append("\n"); 

	}
}