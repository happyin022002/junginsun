/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialCargoIrregularMgtDBDAOIrregularVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.03.12 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoIrregularMgtDBDAOIrregularVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCL CGO Irregular 조회   
	  * </pre>
	  */
	public SpecialCargoIrregularMgtDBDAOIrregularVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("spcl_cgo_irr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoIrregularMgtDBDAOIrregularVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("SIR.VSL_CD" ).append("\n"); 
		query.append(",	SIR.SKD_VOY_NO" ).append("\n"); 
		query.append(",	SIR.SKD_DIR_CD" ).append("\n"); 
		query.append(",	SIR.SPCL_CGO_IRR_SEQ" ).append("\n"); 
		query.append(",	SIR.SPCL_CGO_IRR_TP_CD" ).append("\n"); 
		query.append(",	SIR.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	TO_CHAR(SIR.IRR_OCCR_DT,'YYYY-MM-DD') IRR_OCCR_DT" ).append("\n"); 
		query.append(",	SIR.CGO_OPR_CD" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT VCR.CRR_NM" ).append("\n"); 
		query.append("FROM MDM_CARRIER VCR" ).append("\n"); 
		query.append("WHERE NVL(VCR.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND VCR.CRR_CD = SIR.CGO_OPR_CD" ).append("\n"); 
		query.append(")   CGO_OPR_NM" ).append("\n"); 
		query.append(",	SIR.VSL_CRR_CD AS VSL_OPR_TP_CD" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT VCR.CRR_NM" ).append("\n"); 
		query.append("FROM MDM_CARRIER VCR" ).append("\n"); 
		query.append("WHERE NVL(VCR.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND VCR.CRR_CD = SIR.VSL_CRR_CD" ).append("\n"); 
		query.append(")   VSL_OPR_TP_NM" ).append("\n"); 
		query.append(",	SIR.IRR_SUBJ_NM" ).append("\n"); 
		query.append(",	SIR.SPCL_CGO_IRR_PLC_CD" ).append("\n"); 
		query.append(",	SIR.IRR_PLC_DESC" ).append("\n"); 
		query.append(",	SIR.IRR_SMRY_RMK" ).append("\n"); 
		query.append(",	SIR.IRR_RSN_RMK" ).append("\n"); 
		query.append(",	SIR.CMSR_DESC" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT COUNT(SIF.SPCL_CGO_IRR_FILE_SEQ)" ).append("\n"); 
		query.append("FROM SCG_IRR_FILE_LIST SIF" ).append("\n"); 
		query.append("WHERE SIF.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND SIF.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SIF.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND SIF.SPCL_CGO_IRR_SEQ = @[spcl_cgo_irr_seq]" ).append("\n"); 
		query.append(") FILE_CNT" ).append("\n"); 
		query.append(",	SIR.CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(SIR.CRE_DT,'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append(",	SIR.UPD_USR_ID" ).append("\n"); 
		query.append(",   TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SIR.UPD_DT,'GMT'), 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM SCG_IRREGULAR SIR" ).append("\n"); 
		query.append("WHERE	SIR.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	SIR.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SIR.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND SIR.SPCL_CGO_IRR_SEQ = @[spcl_cgo_irr_seq]" ).append("\n"); 

	}
}