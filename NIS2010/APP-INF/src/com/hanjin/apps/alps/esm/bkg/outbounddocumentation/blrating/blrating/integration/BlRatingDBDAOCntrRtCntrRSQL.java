/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlRatingDBDAOCntrRtCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.05 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOCntrRtCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BlRatingDBDAOCntrRtCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOCntrRtCntrRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      NVL(A.MST_CVRD_BL_NO, A.BKG_NO) MST_CVRD_BL_NO" ).append("\n"); 
		query.append(",      B.CNTR_NO" ).append("\n"); 
		query.append(",      B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      B.PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD" ).append("\n"); 
		query.append(",      B.CNTR_WGT" ).append("\n"); 
		query.append(",      B.WGT_UT_CD" ).append("\n"); 
		query.append(",      B.MEAS_QTY" ).append("\n"); 
		query.append(",      B.MEAS_UT_CD" ).append("\n"); 
		query.append(",      B.RCV_TERM_CD" ).append("\n"); 
		query.append(",      B.DE_TERM_CD" ).append("\n"); 
		query.append(",      B.CNTR_PRT_FLG" ).append("\n"); 
		query.append(",      B.CNTR_PRT_SEQ" ).append("\n"); 
		query.append(",      B.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",      B.ADV_SHTG_CD" ).append("\n"); 
		query.append(",      B.CNTR_WFG_EXPT_FLG" ).append("\n"); 
		query.append(",      B.CSTMS_PRN_FLG" ).append("\n"); 
		query.append(",      B.CSTMS_EXP_DT" ).append("\n"); 
		query.append(",      B.DCGO_FLG" ).append("\n"); 
		query.append(",      B.RC_FLG" ).append("\n"); 
		query.append(",      B.BB_CGO_FLG" ).append("\n"); 
		query.append(",      B.AWK_CGO_FLG" ).append("\n"); 
		query.append(",      B.RD_CGO_FLG" ).append("\n"); 
		query.append(",      B.HNGR_FLG" ).append("\n"); 
		query.append(",      B.SOC_FLG" ).append("\n"); 
		query.append(",      B.EQ_SUBST_FLG" ).append("\n"); 
		query.append(",      NVL(B.EQ_SUBST_TPSZ_CD, B.CNTR_TPSZ_CD) EQ_SUBST_TPSZ_CD" ).append("\n"); 
		query.append(",      B.CGO_RCV_DT" ).append("\n"); 
		query.append(",      B.CGO_RCV_YD_CD" ).append("\n"); 
		query.append(",      B.OB_CY_GEN_DT" ).append("\n"); 
		query.append(",      B.OB_CY_AUTO_GEN_FLG" ).append("\n"); 
		query.append(",      B.CNMV_FLG" ).append("\n"); 
		query.append(",      B.CNMV_EVNT_DT" ).append("\n"); 
		query.append(",      B.CNTR_CFM_FLG" ).append("\n"); 
		query.append(",      B.MCNTR_BDL_NO" ).append("\n"); 
		query.append(",      B.cre_usr_id" ).append("\n"); 
		query.append(",      B.upd_usr_id" ).append("\n"); 
		query.append("FROM   BKG_BL_DOC A, BKG_CONTAINER B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#if (${mst_flag} == 'Y')" ).append("\n"); 
		query.append("AND    A.bkg_no in (SELECT a.bkg_no" ).append("\n"); 
		query.append("FROM   bkg_booking a, bkg_bl_doc b" ).append("\n"); 
		query.append(",      (SELECT NVL (b.mst_cvrd_bl_no, a.bl_no) mst_bl_no" ).append("\n"); 
		query.append("FROM   bkg_booking a, bkg_bl_doc b" ).append("\n"); 
		query.append("WHERE  a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("AND    a.bkg_no = @[bkg_no]) c" ).append("\n"); 
		query.append("WHERE  a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("AND    (a.bl_no = c.mst_bl_no OR b.mst_cvrd_bl_no = c.mst_bl_no))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    A.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    B.CNTR_DELT_FLG = 'N'" ).append("\n"); 

	}
}