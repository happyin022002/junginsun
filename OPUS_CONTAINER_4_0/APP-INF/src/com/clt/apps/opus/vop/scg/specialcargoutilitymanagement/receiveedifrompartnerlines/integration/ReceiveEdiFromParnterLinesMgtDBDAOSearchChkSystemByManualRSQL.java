/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOSearchChkSystemByManualRSQL.java
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

public class ReceiveEdiFromParnterLinesMgtDBDAOSearchChkSystemByManualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOSearchChkSystemByManualRSQL(){
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
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOSearchChkSystemByManualRSQL").append("\n"); 
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
		query.append("SELECT 		DECODE(A.SRC_TP_CD, 'MNL', 'M', 'EDI', DECODE(A.MAPG_EDI_TRSM_STS_CD, 'R', '', 'E'), '') SRC_TP_CD" ).append("\n"); 
		query.append("FROM 		SCG_PRNR_APRO_RQST 		A" ).append("\n"); 
		query.append("		,	SCG_PRNR_APRO_RQST_CGO	B" ).append("\n"); 
		query.append("WHERE 		1 = 1" ).append("\n"); 
		query.append("AND			A.CRR_CD				= B.CRR_CD" ).append("\n"); 
		query.append("AND			A.BKG_REF_NO			= B.BKG_REF_NO" ).append("\n"); 
		query.append("AND     	A.SPCL_CGO_RQST_SEQ 	= B.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("AND     	A.PRNR_CGO_RQST_SEQ 	= B.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND			B.CGO_OPR_CD			= @[cgo_opr_cd]" ).append("\n"); 
		query.append("AND			A.BKG_REF_NO            = @[bkg_ref_no]" ).append("\n"); 
		query.append("AND 		A.DG_FLG                = 'Y'	AND A.AWK_FLG			= 'N'" ).append("\n"); 
		query.append("AND 		(" ).append("\n"); 
		query.append("				(A.SRC_TP_CD        = 'EDI'	AND A.LST_RQST_DAT_FLG	= 'Y')" ).append("\n"); 
		query.append("         		 OR	 " ).append("\n"); 
		query.append("				 A.SRC_TP_CD       	<> 'EDI'" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   		A.VSL_CD             	= @[vsl_cd]" ).append("\n"); 
		query.append("AND   		A.SKD_VOY_NO         	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND   		A.SKD_DIR_CD         	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND   		A.POL_CD             	= @[pol_cd]" ).append("\n"); 
		query.append("AND   		A.POD_CD             	= NVL(@[pod_cd],A.POD_CD)	/* Empty in case of cancellation EDI */" ).append("\n"); 

	}
}