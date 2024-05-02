/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchEdi301DgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : jklim
*@LastVersion : 1.0
* 2015.03.18 jklim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jklim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchEdi301DgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi301DgInfo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchEdi301DgInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchEdi301DgInfoRSQL").append("\n"); 
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
		query.append("    || 'CNTN:'			|| DG.CNTR_NO                                             || CHR(10)" ).append("\n"); 
		query.append("	|| 'UNBR:'			|| DG.IMDG_UN_NO                                          || CHR(10)" ).append("\n"); 
		query.append("    || 'CLAS:'			|| DG.imdg_clss_cd									      || CHR(10)" ).append("\n"); 
		query.append("	|| 'DESC:'			|| DG.PRP_SHP_NM								      	  || CHR(10)" ).append("\n"); 
		query.append("	|| 'PHON:'			|| DG.EMER_CNTC_PHN_NO_CTNT								  || CHR(10)" ).append("\n"); 
		query.append("    || 'EMG_PERSON:'    || DG.EMER_CNTC_PSON_NM 								  || CHR(10)" ).append("\n"); 
		query.append("    || 'PAGE:'			                         								  || CHR(10)" ).append("\n"); 
		query.append("	|| 'FPNT:'			|| DG.FLSH_PNT_CDO_TEMP									  || CHR(10)" ).append("\n"); 
		query.append("	|| 'FPUN:'			|| 'C'												      || CHR(10)" ).append("\n"); 
		query.append("	|| 'DG_REMARK:'		|| REPLACE(NVL(DG.DIFF_RMK, ' '),CHR(10), ' ')   || CHR(10)" ).append("\n"); 
		query.append("	|| 'EMSNO:'			|| NVL(dg.ems_no, ' ')		         					  || CHR(10)" ).append("\n"); 
		query.append("	|| 'PSACLS:'		|| NVL(dg.PSA_NO, ' ')								      || CHR(10)" ).append("\n"); 
		query.append("	|| 'PKGGRP:'		|| NVL(dg.IMDG_PCK_GRP_CD, ' ')							  || CHR(10)" ).append("\n"); 
		query.append("    || 'MFAG1:'			                                       					  || CHR(10)" ).append("\n"); 
		query.append("    || 'MFAG2:'			            							                  || CHR(10)" ).append("\n"); 
		query.append("	|| 'MAR_POLL:'		|| NVL(dg.MRN_POLUT_FLG,' ')							  || CHR(10)" ).append("\n"); 
		query.append("	|| 'LABEL_CD:'		|| NVL((select LBL.IMDG_SUBS_RSK_LBL_CD IMO_SRL" ).append("\n"); 
		query.append("                                  from SCG_IMDG_SUBS_RSK_LBL lbl " ).append("\n"); 
		query.append("                                 where DG.IMDG_UN_NO      = LBL.IMDG_UN_NO " ).append("\n"); 
		query.append("                                   and DG.IMDG_UN_NO_SEQ = LBL.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                                   and rownum = 1), ' ') 						  || CHR(10)" ).append("\n"); 
		query.append("	|| 'LABEL_DESC:'														      || CHR(10)" ).append("\n"); 
		query.append("	|| 'D_PKG:'			|| NVL(dg.OUT_IMDG_PCK_QTY1, 0)							  || CHR(10)" ).append("\n"); 
		query.append("	|| 'D_PKGUNIT:'		|| NVL(dg.OUT_IMDG_PCK_CD1, ' ')						  || CHR(10)" ).append("\n"); 
		query.append("	|| 'D_INNER_PKG:'	|| NVL(DG.IN_IMDG_PCK_QTY1, 0)				  			  || CHR(10)" ).append("\n"); 
		query.append("	|| 'D_INNER_PKGUNIT:' || NVL(dg.IN_IMDG_PCK_CD1, ' ')						  || CHR(10)" ).append("\n"); 
		query.append("	|| 'NWGT:'			|| NVL(dg.NET_WGT, 0)								      || CHR(10)" ).append("\n"); 
		query.append("	|| 'NWGT_UNIT:KGS'														      || CHR(10)" ).append("\n"); 
		query.append("	|| 'GWGT:'			|| NVL(dg.GRS_WGT, 0)							          || CHR(10)" ).append("\n"); 
		query.append("	|| 'GWGT_UNIT:'		|| NVL(dg.WGT_UT_CD, ' ')								  || CHR(10)" ).append("\n"); 
		query.append("	|| 'MEA:'			|| NVL(dg.MEAS_QTY, 0)								      || CHR(10)" ).append("\n"); 
		query.append("	|| 'MEA_UNIT:'		|| NVL(dg.MEAS_UT_CD, ' ')								  || CHR(10)" ).append("\n"); 
		query.append("	|| 'HAZ_CONT:'		|| NVL(dg.HZD_DESC, ' ')							      || CHR(10)" ).append("\n"); 
		query.append("	|| 'HAZ_CD_VERNO:'														      || CHR(10)" ).append("\n"); 
		query.append("	|| 'STWG:'			|| NVL(dg.SPCL_STWG_RQST_DESC, ' ')						  || CHR(10)" ).append("\n"); 
		query.append("    || 'LABEL:'			|| NVL((select LBL.IMDG_SUBS_RSK_LBL_CD IMO_SRL" ).append("\n"); 
		query.append("                                  from SCG_IMDG_SUBS_RSK_LBL lbl " ).append("\n"); 
		query.append("                                 where DG.IMDG_UN_NO      = LBL.IMDG_UN_NO " ).append("\n"); 
		query.append("                                   and DG.IMDG_UN_NO_SEQ = LBL.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                                   and rownum = 1), ' ') 						  || CHR(10)" ).append("\n"); 
		query.append("	|| 'PROPER_SHIP_NAME:'|| NVL(dg.PRP_SHP_NM, ' ')							  || CHR(10)" ).append("\n"); 
		query.append("	|| 'CONT_TPSZ:'		|| NVL(dg.cntr_tpsz_cd, ' ')							  || CHR(10)" ).append("\n"); 
		query.append("	|| 'CARGO_SEQ:'		|| dg.DCGO_SEQ            								  || CHR(10)" ).append("\n"); 
		query.append("	|| 'TERM_CARD_NO:'														      || CHR(10)" ).append("\n"); 
		query.append("	|| 'MARK_LABEL_NO1:'		|| NVL(DG.IMDG_SUBS_RSK_LBL_CD1, ' ')			  || CHR(10)" ).append("\n"); 
		query.append("	|| 'MARK_LABEL_NO2:'		|| NVL(DG.IMDG_SUBS_RSK_LBL_CD2, ' ')			  || CHR(10)" ).append("\n"); 
		query.append("	|| 'MARK_LABEL_NO3:'		|| NVL(DG.IMDG_SUBS_RSK_LBL_CD3, ' ')			  || CHR(10)" ).append("\n"); 
		query.append("	|| 'TECH_NAME:'				|| NVL(HZD_DESC, ' ')						  	  || CHR(10)" ).append("\n"); 
		query.append("	|| 'MFAG_PAGE_NO:'														      || CHR(10)" ).append("\n"); 
		query.append("	|| 'MFAG_TEXT:'															      || CHR(10)" ).append("\n"); 
		query.append("	|| 'HARZARD_UP_PT:'														      || CHR(10)" ).append("\n"); 
		query.append("	|| 'HARZARD_LOW_PT:'													      || CHR(10)" ).append("\n"); 
		query.append("	|| 'PKG_INS_CD:'														      || CHR(10)" ).append("\n"); 
		query.append("	|| 'LIMITED_QTY_IND:'		|| NVL(DG.IMDG_LMT_QTY_FLG, ' ')				  || CHR(10)" ).append("\n"); 
		query.append("	|| 'REP_QTY_IND:'														      || CHR(10)" ).append("\n"); 
		query.append("	|| 'NET_EXP_WGT_QTY:'		|| NVL(NET_EXPLO_WGT,0)							  || CHR(10)" ).append("\n"); 
		query.append("	|| 'NET_EXP_WGT_UNIT:KGS'												      || CHR(10)" ).append("\n"); 
		query.append("	|| 'CMD_SEQ:'		|| (SELECT CMF.CNTR_MF_SEQ FROM BKG_CNTR_MF_DESC CMF WHERE CMF.BKG_NO = DG.BKG_NO AND CMF.CNTR_NO = DG.CNTR_NO AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| '}CNTR_DANGER'				      										  || CHR(10) DG_INFO" ).append("\n"); 
		query.append("  FROM BKG_DG_CGO DG, BKG_BOOKING bk" ).append("\n"); 
		query.append(" WHERE DG.bkg_no		= @[bkg_no]" ).append("\n"); 
		query.append(" AND DG.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append(" AND BK.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append(" Order by dg.dcgo_seq" ).append("\n"); 

	}
}