/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301CntrDgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301CntrDgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301CntrDgInfo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301CntrDgInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301CntrDgInfoRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_DANGER'														      || CHR(10)" ).append("\n"); 
		query.append("|| 'UNBR:'			|| DG.IMDG_UN_NO                                          || CHR(10)" ).append("\n"); 
		query.append("|| 'CLAS:'			|| DG.IMDG_CLSS_CD									      || CHR(10)" ).append("\n"); 
		query.append("|| 'DESC:'			|| DG.PRP_SHP_NM								      	  || CHR(10)" ).append("\n"); 
		query.append("|| 'PHON:'			|| DG.EMER_CNTC_PHN_NO_CTNT								  || CHR(10)" ).append("\n"); 
		query.append("|| 'PAGE:'			                         								  || CHR(10)" ).append("\n"); 
		query.append("|| 'FPNT:'			|| DG.FLSH_PNT_CDO_TEMP									  || CHR(10)" ).append("\n"); 
		query.append("|| 'FPUN:'			|| 'C'												      || CHR(10)" ).append("\n"); 
		query.append("|| 'DG_REMARK:'		|| REPLACE(NVL(DG.DIFF_RMK, ' '),CHR(13)||CHR(10), ' ')   || CHR(10)" ).append("\n"); 
		query.append("|| 'EMSNO:'			|| NVL(DG.EMS_NO, ' ')		         					  || CHR(10)" ).append("\n"); 
		query.append("|| 'PSACLS:'		|| NVL(DG.PSA_NO, ' ')								      || CHR(10)" ).append("\n"); 
		query.append("|| 'PKGGRP:'		|| NVL(DG.IMDG_PCK_GRP_CD, ' ')							  || CHR(10)" ).append("\n"); 
		query.append("|| 'MFAG1:'			                                       					  || CHR(10)" ).append("\n"); 
		query.append("|| 'MFAG2:'			            							                  || CHR(10)" ).append("\n"); 
		query.append("|| 'MAR_POLL:'		|| NVL(DG.MRN_POLUT_FLG,' ')							  || CHR(10)" ).append("\n"); 
		query.append("|| 'LABEL_CD:'		|| NVL((select LBL.IMDG_SUBS_RSK_LBL_CD IMO_SRL" ).append("\n"); 
		query.append("from SCG_IMDG_SUBS_RSK_LBL LBL" ).append("\n"); 
		query.append("where DG.IMDG_UN_NO      = LBL.IMDG_UN_NO" ).append("\n"); 
		query.append("and DG.IMDG_UN_NO_SEQ = LBL.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("and rownum = 1), ' ') 						  || CHR(10)" ).append("\n"); 
		query.append("|| 'LABEL_DESC:'														      || CHR(10)" ).append("\n"); 
		query.append("|| 'D_PKG:'			|| NVL(DG.OUT_IMDG_PCK_QTY1, 0)							  || CHR(10)" ).append("\n"); 
		query.append("|| 'D_PKGUNIT:'		|| NVL(DG.OUT_IMDG_PCK_CD1, ' ')						  || CHR(10)" ).append("\n"); 
		query.append("|| 'NWGT:'			|| NVL(DG.NET_WGT, 0)								      || CHR(10)" ).append("\n"); 
		query.append("|| 'NWGT_UNIT:KGS'														      || CHR(10)" ).append("\n"); 
		query.append("|| 'GWGT:'			|| NVL(DG.GRS_WGT, 0)							          || CHR(10)" ).append("\n"); 
		query.append("|| 'GWGT_UNIT:'		|| NVL(DG.WGT_UT_CD, ' ')								  || CHR(10)" ).append("\n"); 
		query.append("|| 'MEA:'			|| NVL(DG.MEAS_QTY, 0)								      || CHR(10)" ).append("\n"); 
		query.append("|| 'MEA_UNIT:'		|| NVL(DG.MEAS_UT_CD, ' ')								  || CHR(10)" ).append("\n"); 
		query.append("|| 'HAZ_CONT:'		|| NVL(DG.HZD_DESC, ' ')							      || CHR(10)" ).append("\n"); 
		query.append("|| 'STWG:'			|| NVL(DG.SPCL_STWG_RQST_DESC, ' ')						  || CHR(10)" ).append("\n"); 
		query.append("|| 'LABEL:'			|| NVL((select LBL.IMDG_SUBS_RSK_LBL_CD IMO_SRL" ).append("\n"); 
		query.append("from SCG_IMDG_SUBS_RSK_LBL LBL" ).append("\n"); 
		query.append("where DG.IMDG_UN_NO      = LBL.IMDG_UN_NO" ).append("\n"); 
		query.append("and DG.IMDG_UN_NO_SEQ = LBL.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("and rownum = 1), ' ') 						  || CHR(10)" ).append("\n"); 
		query.append("|| 'IMO_LIMIT:'|| NVL(DG.IMDG_LMT_QTY_FLG, ' ')								  || CHR(10)" ).append("\n"); 
		query.append("|| '}CNTR_DANGER'				      										  || CHR(10) CNTR_DG_INFO" ).append("\n"); 
		query.append("FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("WHERE DG.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("AND DG.CNTR_TPSZ_CD is not null" ).append("\n"); 
		query.append("AND DG.DG_CNTR_SEQ   = @[dg_cntr_seq]" ).append("\n"); 
		query.append("ORDER BY DG.CNTR_CGO_SEQ" ).append("\n"); 

	}
}