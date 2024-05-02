/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SendEdiFromParnterLinesMgtDBDAOScgPrnrAproRqstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SendEdiFromParnterLinesMgtDBDAOScgPrnrAproRqstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public SendEdiFromParnterLinesMgtDBDAOScgPrnrAproRqstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_trsm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mapg_prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_trsm_spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_edi_trsm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_trsm_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_edi_snd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration").append("\n"); 
		query.append("FileName : SendEdiFromParnterLinesMgtDBDAOScgPrnrAproRqstUSQL").append("\n"); 
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
		query.append("UPDATE	SCG_VVD_APRO_RQST" ).append("\n"); 
		query.append("   SET	MAPG_TRSM_BND_CD             	= @[mapg_trsm_bnd_cd]" ).append("\n"); 
		query.append("     ,	MAPG_TRSM_DT                 	= TO_DATE(@[mapg_trsm_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append("     ,	MAPG_TRSM_SPCL_CGO_CATE_CD   	= @[mapg_trsm_spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("     ,	MAPG_PRNR_SPCL_CGO_SEQ       	= @[mapg_prnr_spcl_cgo_seq]" ).append("\n"); 
		query.append("     ,	MAPG_EDI_TRSM_STS_CD         	= @[mapg_edi_trsm_sts_cd]" ).append("\n"); 
		query.append("#if (${mapg_edi_trsm_sts_cd} == 'SX') " ).append("\n"); 
		query.append("     ,	CXL_EDI_SND_OFC_CD           	= NVL(@[cxl_edi_snd_ofc_cd],'AUTO_CXL')     " ).append("\n"); 
		query.append("     ,	CXL_EDI_SND_DT               	= SYSDATE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${edi_status} == 'EDI_AUTO_CXL')" ).append("\n"); 
		query.append("	,	EDI_AUTO_CXL_FLG       			= 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 	BKG_NO                       	= @[bkg_no]" ).append("\n"); 
		query.append("AND 	SPCL_CGO_APRO_RQST_SEQ       	= @[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("AND 	VSL_PRE_PST_CD               	= @[vsl_pre_pst_cd]" ).append("\n"); 
		query.append("AND 	VSL_SEQ                      	= @[vsl_seq]" ).append("\n"); 

	}
}