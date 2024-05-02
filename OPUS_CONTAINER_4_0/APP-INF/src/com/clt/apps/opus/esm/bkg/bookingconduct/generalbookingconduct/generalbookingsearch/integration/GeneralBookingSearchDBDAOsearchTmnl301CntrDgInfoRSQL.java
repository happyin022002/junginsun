/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301CntrDgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		params.put("dg_cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
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
		query.append("    || 'PROPERNAME:'    || BKG_SPCLCHAR_CONV_FNC(DG.PRP_SHP_NM,'E')				  || CHR(10)" ).append("\n"); 
		query.append("    || 'TECHNAME:'      || BKG_SPCLCHAR_CONV_FNC(NVL(HZD_DESC, ' '),'E')	  	  || CHR(10)" ).append("\n"); 
		query.append("    || 'DG_APPROVAL:'   || (SELECT   SA.APRO_REF_NO" ).append("\n"); 
		query.append("							FROM     SCG_APRO_RQST      SAR" ).append("\n"); 
		query.append("							      ,  SCG_VVD_APRO_RQST  SVAR" ).append("\n"); 
		query.append("							      ,  SCG_AUTHORIZATION  SA" ).append("\n"); 
		query.append("							      ,  BKG_VVD BV" ).append("\n"); 
		query.append("							WHERE    1 = 1" ).append("\n"); 
		query.append("							AND      SAR.BKG_NO           = SVAR.BKG_NO" ).append("\n"); 
		query.append("							AND      SAR.BKG_NO           = BV.BKG_NO" ).append("\n"); 
		query.append("							AND      SAR.SPCL_CGO_APRO_RQST_SEQ = SVAR.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("							AND      SAR.SPCL_CGO_CATE_CD = 'DG'" ).append("\n"); 
		query.append("							AND      SAR.LST_RQST_DAT_FLG = 'Y'" ).append("\n"); 
		query.append("							AND      SVAR.BKG_NO           = SA.BKG_NO" ).append("\n"); 
		query.append("							AND      SVAR.SPCL_CGO_APRO_RQST_SEQ = SA.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("							AND      SVAR.BKG_NO           = DG.BKG_NO" ).append("\n"); 
		query.append("							AND      SVAR.VSL_CD           = BV.VSL_CD" ).append("\n"); 
		query.append("							AND      SVAR.SKD_VOY_NO       = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND      SVAR.SKD_DIR_CD       = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND      BV.VSL_PRE_PST_CD||BV.VSL_SEQ = (SELECT MIN(BV1.VSL_PRE_PST_CD||BV1.VSL_SEQ) FROM BKG_VVD BV1 WHERE BV1.BKG_NO = BV.BKG_NO)" ).append("\n"); 
		query.append("							AND      SA.SPCL_CGO_AUTH_SEQ= (SELECT   MAX(SAM.SPCL_CGO_AUTH_SEQ)" ).append("\n"); 
		query.append("                            							    FROM     SCG_AUTHORIZATION SAM" ).append("\n"); 
		query.append("                               								WHERE    SAM.BKG_NO         = SA.BKG_NO" ).append("\n"); 
		query.append("                               								AND      SAM.SPCL_CGO_APRO_RQST_SEQ = SA.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                               								)  " ).append("\n"); 
		query.append("                            AND      ROWNUM = 1) 													  || CHR(10)" ).append("\n"); 
		query.append("	|| 'UNBR:'			|| DG.IMDG_UN_NO                                          || CHR(10)" ).append("\n"); 
		query.append("    || 'CLAS:'			|| DG.IMDG_CLSS_CD									      || CHR(10)" ).append("\n"); 
		query.append("	|| 'DESC:'			|| BKG_SPCLCHAR_CONV_FNC(DG.PRP_SHP_NM,'E')		      	  || CHR(10)" ).append("\n"); 
		query.append("	|| 'PHON:'			|| DG.EMER_CNTC_PHN_NO_CTNT								  || CHR(10)" ).append("\n"); 
		query.append("    || 'PERSON:'		|| DG.EMER_CNTC_PSON_NM								  	  || CHR(10)" ).append("\n"); 
		query.append("    || 'PAGE:'			                         								  || CHR(10)" ).append("\n"); 
		query.append("	|| 'FPNT:'			|| DG.FLSH_PNT_CDO_TEMP									  || CHR(10)" ).append("\n"); 
		query.append("	|| 'FPUN:'			|| 'C'												      || CHR(10)" ).append("\n"); 
		query.append("	|| 'DG_REMARK:'		|| BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(DG.DIFF_RMK, ' '),CHR(10), ' '),'E')     || CHR(10)" ).append("\n"); 
		query.append("	|| 'EMSNO:'			|| NVL(DG.EMS_NO, ' ')		         					  || CHR(10)" ).append("\n"); 
		query.append("	|| 'PSACLS:'		|| NVL(DG.PSA_NO, ' ')								      || CHR(10)" ).append("\n"); 
		query.append("	|| 'PKGGRP:'		|| NVL(DG.IMDG_PCK_GRP_CD, ' ')							  || CHR(10)" ).append("\n"); 
		query.append("    || 'MFAG1:'			                                       					  || CHR(10)" ).append("\n"); 
		query.append("    || 'MFAG2:'			            							                  || CHR(10)" ).append("\n"); 
		query.append("	|| 'MAR_POLL:'		|| NVL(DG.MRN_POLUT_FLG,' ')							  || CHR(10)" ).append("\n"); 
		query.append("	|| 'LABEL_CD:'		|| NVL((select LBL.IMDG_SUBS_RSK_LBL_CD IMO_SRL" ).append("\n"); 
		query.append("                                  from SCG_IMDG_SUBS_RSK_LBL LBL " ).append("\n"); 
		query.append("                                 where DG.IMDG_UN_NO      = LBL.IMDG_UN_NO " ).append("\n"); 
		query.append("                                   and DG.IMDG_UN_NO_SEQ = LBL.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                                   and rownum = 1), ' ') 						  || CHR(10)" ).append("\n"); 
		query.append("	|| 'LABEL_DESC:'														      || CHR(10)" ).append("\n"); 
		query.append("	|| 'D_PKG:'			|| NVL(DG.OUT_IMDG_PCK_QTY1, 0)							  || CHR(10)" ).append("\n"); 
		query.append("	|| 'D_PKGUNIT:'		|| NVL(DG.OUT_IMDG_PCK_CD1, ' ')						  || CHR(10)" ).append("\n"); 
		query.append("	|| 'NWGT:'			|| NVL(DG.NET_WGT, 0)								      || CHR(10)" ).append("\n"); 
		query.append("	|| 'NWGT_UNIT:KGS'														      || CHR(10)" ).append("\n"); 
		query.append("	|| 'GWGT:'			|| NVL(DG.GRS_WGT, 0)							          || CHR(10)" ).append("\n"); 
		query.append("	|| 'GWGT_UNIT:'		|| NVL(DG.WGT_UT_CD, ' ')								  || CHR(10)" ).append("\n"); 
		query.append("	|| 'MEA:'			|| NVL(DG.MEAS_QTY, 0)								      || CHR(10)" ).append("\n"); 
		query.append("	|| 'MEA_UNIT:'		|| NVL(DG.MEAS_UT_CD, ' ')								  || CHR(10)" ).append("\n"); 
		query.append("	|| 'HAZ_CONT:'		|| NVL(DG.HZD_DESC, ' ')							      || CHR(10)" ).append("\n"); 
		query.append("	|| 'STWG:'			|| NVL(DG.SPCL_STWG_RQST_DESC, ' ')						  || CHR(10)" ).append("\n"); 
		query.append("    || 'LABEL1:'		|| NVL(DG.IMDG_SUBS_RSK_LBL_CD1, ' ')					  || CHR(10)" ).append("\n"); 
		query.append("    || 'LABEL2:'		|| NVL(DG.IMDG_SUBS_RSK_LBL_CD2, ' ')					  || CHR(10)" ).append("\n"); 
		query.append("    || 'LABEL3:'		|| NVL(DG.IMDG_SUBS_RSK_LBL_CD3, ' ')					  || CHR(10)" ).append("\n"); 
		query.append("	|| 'IMO_LIMIT:'     || NVL(DG.IMDG_LMT_QTY_FLG, ' ')						  || CHR(10)" ).append("\n"); 
		query.append("	|| '}CNTR_DANGER'				      										  || CHR(10) CNTR_DG_INFO" ).append("\n"); 
		query.append("  FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append(" WHERE DG.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("   AND DG.CNTR_TPSZ_CD is not null" ).append("\n"); 
		query.append("   AND DG.DG_CNTR_SEQ   = @[dg_cntr_seq]" ).append("\n"); 
		query.append(" ORDER BY DG.CNTR_CGO_SEQ" ).append("\n"); 

	}
}