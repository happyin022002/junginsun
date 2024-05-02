/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderDgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderDgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiFullCntrRlseOrderDgInfo
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderDgInfoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderDgInfoRSQL").append("\n"); 
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
		query.append("	|| 'UNNBR:'			|| DG.IMDG_UN_NO                                          || CHR(10)" ).append("\n"); 
		query.append("    || 'CLASS:'			|| DG.IMDG_CLSS_CD									      || CHR(10)" ).append("\n"); 
		query.append("	|| 'DG_DESC:'		|| DG.PRP_SHP_NM								      	  || CHR(10)" ).append("\n"); 
		query.append("	|| 'PHONE:'			|| DG.EMER_CNTC_PHN_NO_CTNT								  || CHR(10)" ).append("\n"); 
		query.append("    || 'PAGE:'			                         								  || CHR(10)" ).append("\n"); 
		query.append("	|| 'FLSH_TEMP:'		|| DG.FLSH_PNT_CDO_TEMP									  || CHR(10)" ).append("\n"); 
		query.append("	|| 'FLSH_UNIT:'		|| 'C'												      || CHR(10)" ).append("\n"); 
		query.append("	|| 'DG_REMARK:'		|| REPLACE(NVL(DG.DIFF_RMK, ' '),CHR(10), ' ')   || CHR(10)" ).append("\n"); 
		query.append("	|| 'EMSNO:'			|| NVL(DG.EMS_NO, ' ')		         					  || CHR(10)" ).append("\n"); 
		query.append("	|| 'PSACLS:'		|| NVL(DG.PSA_NO, ' ')								      || CHR(10)" ).append("\n"); 
		query.append("	|| 'PKGGRP:'		|| NVL(DG.IMDG_PCK_GRP_CD, ' ')							  || CHR(10)" ).append("\n"); 
		query.append("    || 'MFAG1:'			                                       					  || CHR(10)" ).append("\n"); 
		query.append("    || 'MFAG2:'			            							                  || CHR(10)" ).append("\n"); 
		query.append("	|| 'MAR_POLL:'		|| NVL(DG.MRN_POLUT_FLG,' ')							  || CHR(10)" ).append("\n"); 
		query.append("	|| 'LABEL_CD:'		|| NVL((SELECT LBL.IMDG_SUBS_RSK_LBL_CD IMO_SRL" ).append("\n"); 
		query.append("                                  FROM SCG_IMDG_SUBS_RSK_LBL LBL " ).append("\n"); 
		query.append("                                 WHERE DG.IMDG_UN_NO      = LBL.IMDG_UN_NO " ).append("\n"); 
		query.append("                                   AND DG.IMDG_UN_NO_SEQ = LBL.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1), ' ') 						  || CHR(10)" ).append("\n"); 
		query.append("	|| 'LABEL_DESC:'														      || CHR(10)" ).append("\n"); 
		query.append("	|| 'D_PKG:'			|| NVL(DG.OUT_IMDG_PCK_QTY1, '')						  || CHR(10)" ).append("\n"); 
		query.append("	|| 'D_PKGUNIT:'		|| NVL(DG.OUT_IMDG_PCK_CD1, ' ')						  || CHR(10)" ).append("\n"); 
		query.append("	|| 'NWGT:'			|| NVL(DG.NET_WGT, '')								      || CHR(10)" ).append("\n"); 
		query.append("	|| 'NWGT_UNIT:KGM'   												          || CHR(10)" ).append("\n"); 
		query.append("	|| 'GWGT:'			|| NVL(DG.GRS_WGT, '')							          || CHR(10)" ).append("\n"); 
		query.append("	|| 'GWGT_UNIT:'		|| NVL(DG.WGT_UT_CD, ' ')								  || CHR(10)" ).append("\n"); 
		query.append("	|| 'MEA:'			|| NVL(DG.MEAS_QTY, '')								      || CHR(10)" ).append("\n"); 
		query.append("	|| 'MEA_UNIT:'		|| NVL(DG.MEAS_UT_CD, ' ')								  || CHR(10)" ).append("\n"); 
		query.append("	|| 'HAZ_CONT:'		|| NVL(DG.HZD_DESC, ' ')							      || CHR(10)" ).append("\n"); 
		query.append("	|| 'STWG:'			|| NVL(DG.SPCL_STWG_RQST_DESC, ' ')						  || CHR(10)" ).append("\n"); 
		query.append("    || 'LABEL:'			|| NVL((SELECT LBL.IMDG_SUBS_RSK_LBL_CD IMO_SRL" ).append("\n"); 
		query.append("                                FROM SCG_IMDG_SUBS_RSK_LBL LBL " ).append("\n"); 
		query.append("                                WHERE DG.IMDG_UN_NO      = LBL.IMDG_UN_NO " ).append("\n"); 
		query.append("                                  AND DG.IMDG_UN_NO_SEQ = LBL.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                                  AND ROWNUM = 1), ' ') 						  || CHR(10)	" ).append("\n"); 
		query.append("    || 'IMO_LIMIT_QTY:' || NVL(DG.IMDG_LMT_QTY_FLG ,'N')                          || CHR(10)	" ).append("\n"); 
		query.append("	|| '}CNTR_DANGER'				      										  || CHR(10) " ).append("\n"); 
		query.append("    || '}CNTR_INFO'				      								              || CHR(10)" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BCNTR," ).append("\n"); 
		query.append("      BKG_DG_CGO DG" ).append("\n"); 
		query.append("WHERE BCNTR.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("  AND BCNTR.CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("  AND DG.BKG_NO(+)   = BCNTR.BKG_NO " ).append("\n"); 
		query.append("  AND DG.CNTR_NO(+)  = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("ORDER BY DG.DCGO_SEQ" ).append("\n"); 

	}
}