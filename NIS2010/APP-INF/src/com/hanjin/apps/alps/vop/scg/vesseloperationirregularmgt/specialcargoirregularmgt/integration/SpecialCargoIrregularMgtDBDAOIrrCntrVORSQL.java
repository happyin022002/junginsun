/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SpecialCargoIrregularMgtDBDAOIrrCntrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoIrregularMgtDBDAOIrrCntrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCL CGO Irregular Container 조회
	  * </pre>
	  */
	public SpecialCargoIrregularMgtDBDAOIrrCntrVORSQL(){
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
		query.append("FileName : SpecialCargoIrregularMgtDBDAOIrrCntrVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	SIC.VSL_CD" ).append("\n"); 
		query.append(",	SIC.SKD_VOY_NO" ).append("\n"); 
		query.append(",	SIC.SKD_DIR_CD" ).append("\n"); 
		query.append(",	SIC.SPCL_CGO_IRR_SEQ" ).append("\n"); 
		query.append(",	SIC.SPCL_CGO_IRR_CNTR_SEQ" ).append("\n"); 
		query.append(",	DECODE(SIR.CGO_OPR_CD,'SML',SIC.BKG_NO,'SEN',SIC.BKG_NO,SIC.BKG_REF_NO) BKG_NO" ).append("\n"); 
		query.append(",   SIC.BL_REF_NO BL_NO" ).append("\n"); 
		query.append(",   SIC.POR_CD POR_CD" ).append("\n"); 
		query.append(", 	SIC.POL_CD POL_CD" ).append("\n"); 
		query.append(",   SIC.POD_CD POD_CD" ).append("\n"); 
		query.append(",   SIC.DEL_CD DEL_CD" ).append("\n"); 
		query.append(",   SIC.SHPR_NM S_CUST_NM" ).append("\n"); 
		query.append(",   SIC.FWRD_NM F_CUST_NM" ).append("\n"); 
		query.append(",   SIC.CNEE_NM C_CUST_NM" ).append("\n"); 
		query.append(",	DECODE(SIR.CGO_OPR_CD,'SML',SIC.CNTR_NO,'SEN',SIC.CNTR_NO,SIC.CNTR_REF_NO) CNTR_NO" ).append("\n"); 
		query.append(",	SIC.CGO_SEQ" ).append("\n"); 
		query.append(",	SIC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	SIC.IMDG_UN_NO" ).append("\n"); 
		query.append(",	SIC.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	SIC.IMDG_CLSS_CD" ).append("\n"); 
		query.append(",   SIC.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",	SIC.PRP_SHP_NM" ).append("\n"); 
		query.append(",	SIC.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	SIC.AWK_CGO_GRS_WGT" ).append("\n"); 
		query.append(",	SIC.AWK_CGO_NET_WGT" ).append("\n"); 
		query.append(",	SIC.DIM_LEN" ).append("\n"); 
		query.append(",	SIC.DIM_WDT" ).append("\n"); 
		query.append(",	SIC.DIM_HGT" ).append("\n"); 
		query.append(",	SIC.CMDT_DESC" ).append("\n"); 
		query.append(",	SIC.CELL_PSN_NO" ).append("\n"); 
		query.append(",	SIC.CRE_USR_ID" ).append("\n"); 
		query.append(",	SIC.CRE_DT" ).append("\n"); 
		query.append(",	SIC.UPD_USR_ID" ).append("\n"); 
		query.append(",   TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SIC.UPD_DT,'GMT'), 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM SCG_IRREGULAR SIR" ).append("\n"); 
		query.append("   , SCG_IRR_CNTR  SIC" ).append("\n"); 
		query.append("WHERE SIR.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	SIR.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SIR.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND SIR.SPCL_CGO_IRR_SEQ = @[spcl_cgo_irr_seq]" ).append("\n"); 
		query.append("AND SIR.VSL_CD = SIC.VSL_CD" ).append("\n"); 
		query.append("AND	SIR.SKD_VOY_NO = SIC.SKD_VOY_NO" ).append("\n"); 
		query.append("AND	SIR.SKD_DIR_CD = SIC.SKD_DIR_CD" ).append("\n"); 
		query.append("AND SIR.SPCL_CGO_IRR_SEQ = SIC.SPCL_CGO_IRR_SEQ" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("    DECODE(SIR.CGO_OPR_CD,'SML',SIC.BKG_NO,'SEN',SIC.BKG_NO,SIC.BKG_REF_NO)" ).append("\n"); 
		query.append("  , DECODE(SIR.CGO_OPR_CD,'SML',SIC.CNTR_NO,'SEN',SIC.CNTR_NO,SIC.CNTR_REF_NO)" ).append("\n"); 
		query.append("  , SIC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  , SIC.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("  , SIC.CELL_PSN_NO" ).append("\n"); 
		query.append("  , SIC.CGO_SEQ" ).append("\n"); 

	}
}