/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialManifestDBDAOupdateSpclCgoListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.14
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.12.14 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOupdateSpclCgoListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_PRNR_APRO_RQST_CGO 테이블의 해당 CGO값을 제외처리한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOupdateSpclCgoListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOupdateSpclCgoListUSQL").append("\n"); 
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
		query.append("UPDATE SCG_PRNR_APRO_RQST_CGO SET" ).append("\n"); 
		query.append("		CSTMS_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("WHERE 1=1	" ).append("\n"); 
		query.append("AND	BKG_REF_NO = @[bl_no]" ).append("\n"); 
		query.append("AND SPCL_CNTR_SEQ = @[spcl_cntr_seq]" ).append("\n"); 
		query.append("AND SPCL_CGO_SEQ = @[spcl_cgo_seq]" ).append("\n"); 
		query.append("AND PRNR_CGO_RQST_SEQ = (SELECT A.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                         FROM SCG_PRNR_APRO_RQST A, SCG_PRNR_APRO_RQST_CGO B" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                         AND A.BKG_REF_NO = @[bl_no]" ).append("\n"); 
		query.append("                         AND A.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("                         AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("                         AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("	                     AND A.LST_RQST_DAT_FLG = 'Y'" ).append("\n"); 
		query.append("						 AND B.CGO_OPR_CD = @[cgo_opr_cd]" ).append("\n"); 
		query.append("                         AND A.BKG_REF_NO = B.BKG_REF_NO" ).append("\n"); 
		query.append("                         AND A.PRNR_CGO_RQST_SEQ = B.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                         AND A.SPCL_CGO_RQST_SEQ = B.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("						 )" ).append("\n"); 

	}
}