/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOValidateDGSubLabelByUNNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOValidateDGSubLabelByUNNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UN No에 해당되는 SUB Label이 설정되지 않거나, 맞지 않은 값이 설정되었는지 
	  * 여부를 체크한다.
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOValidateDGSubLabelByUNNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOValidateDGSubLabelByUNNoRSQL").append("\n"); 
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
		query.append("SELECT dg.bkg_no," ).append("\n"); 
		query.append("       dg.cntr_no," ).append("\n"); 
		query.append("       dg.imdg_un_no," ).append("\n"); 
		query.append("       dg.imdg_un_no_seq," ).append("\n"); 
		query.append("       nvl(dg.imdg_subs_rsk_lbl_cd1, 'N') srl1," ).append("\n"); 
		query.append("       nvl(dg.imdg_subs_rsk_lbl_cd2, 'N') srl2," ).append("\n"); 
		query.append("       nvl(dg.imdg_subs_rsk_lbl_cd3, 'N') srl3," ).append("\n"); 
		query.append("       nvl(dg.imdg_subs_rsk_lbl_cd4, 'N') srl4," ).append("\n"); 
		query.append("       case when dg.imdg_subs_rsk_lbl_cd1 is null" ).append("\n"); 
		query.append("             and dg.imdg_subs_rsk_lbl_cd2 is null" ).append("\n"); 
		query.append("             and dg.imdg_subs_rsk_lbl_cd3 is null" ).append("\n"); 
		query.append("             and dg.imdg_subs_rsk_lbl_cd4 is null then bhcn.attr_ctnt5||'['||dg.imdg_clss_cd||']'||bhcn.attr_ctnt7" ).append("\n"); 
		query.append("       else bhcn.attr_ctnt6||bhcn.attr_ctnt7" ).append("\n"); 
		query.append("       end w_msg" ).append("\n"); 
		query.append("FROM bkg_dg_cgo dg" ).append("\n"); 
		query.append("     ,bkg_hrd_cdg_ctnt bhcn" ).append("\n"); 
		query.append("WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND BHCN.HRD_CDG_ID = 'DG_SUB_LABEL_CHECK'" ).append("\n"); 
		query.append("AND BHCN.ATTR_CTNT1 = 'Y'" ).append("\n"); 
		query.append("AND nvl(dg.spcl_cgo_apro_cd,'N') <> 'C'" ).append("\n"); 
		query.append("AND (nvl((SELECT IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("          FROM (SELECT ROW_NUMBER() OVER(PARTITION BY IMDG_UN_NO, IMDG_UN_NO_SEQ ORDER BY IMDG_SUBS_RSK_LBL_CD) RNUM," ).append("\n"); 
		query.append("                       IMDG_UN_NO," ).append("\n"); 
		query.append("                       IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("                       IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("                FROM SCG_IMDG_SUBS_RSK_LBL" ).append("\n"); 
		query.append("                WHERE IMDG_SUBS_RSK_LBL_CD <> 0)" ).append("\n"); 
		query.append("          WHERE IMDG_UN_NO = dg.IMDG_UN_NO" ).append("\n"); 
		query.append("          AND IMDG_UN_NO_SEQ = dg.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("          AND rnum = 1),'N') <> nvl(dg.imdg_subs_rsk_lbl_cd1, 'N')" ).append("\n"); 
		query.append("  or nvl((SELECT IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("          FROM (SELECT ROW_NUMBER() OVER(PARTITION BY IMDG_UN_NO, IMDG_UN_NO_SEQ ORDER BY IMDG_SUBS_RSK_LBL_CD) RNUM," ).append("\n"); 
		query.append("                       IMDG_UN_NO," ).append("\n"); 
		query.append("                       IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("                       IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("                FROM SCG_IMDG_SUBS_RSK_LBL" ).append("\n"); 
		query.append("                WHERE IMDG_SUBS_RSK_LBL_CD <> 0)" ).append("\n"); 
		query.append("          WHERE IMDG_UN_NO = dg.IMDG_UN_NO" ).append("\n"); 
		query.append("          AND IMDG_UN_NO_SEQ = dg.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("          AND rnum = 2),'N') <> nvl(dg.imdg_subs_rsk_lbl_cd2, 'N')" ).append("\n"); 
		query.append("  or nvl((SELECT IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("          FROM (SELECT ROW_NUMBER() OVER(PARTITION BY IMDG_UN_NO, IMDG_UN_NO_SEQ ORDER BY IMDG_SUBS_RSK_LBL_CD) RNUM," ).append("\n"); 
		query.append("                       IMDG_UN_NO," ).append("\n"); 
		query.append("                       IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("                       IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("                FROM SCG_IMDG_SUBS_RSK_LBL" ).append("\n"); 
		query.append("                WHERE IMDG_SUBS_RSK_LBL_CD <> 0)" ).append("\n"); 
		query.append("          WHERE IMDG_UN_NO = dg.IMDG_UN_NO" ).append("\n"); 
		query.append("          AND IMDG_UN_NO_SEQ = dg.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("          AND rnum = 3),'N') <> nvl(dg.imdg_subs_rsk_lbl_cd3, 'N')" ).append("\n"); 
		query.append("  or nvl((SELECT IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("          FROM (SELECT ROW_NUMBER() OVER(PARTITION BY IMDG_UN_NO, IMDG_UN_NO_SEQ ORDER BY IMDG_SUBS_RSK_LBL_CD) RNUM," ).append("\n"); 
		query.append("                       IMDG_UN_NO," ).append("\n"); 
		query.append("                       IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("                       IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("                FROM SCG_IMDG_SUBS_RSK_LBL" ).append("\n"); 
		query.append("                WHERE IMDG_SUBS_RSK_LBL_CD <> 0)" ).append("\n"); 
		query.append("          WHERE IMDG_UN_NO = dg.IMDG_UN_NO" ).append("\n"); 
		query.append("          AND IMDG_UN_NO_SEQ = dg.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("          AND rnum = 4),'N') <> nvl(dg.imdg_subs_rsk_lbl_cd4, 'N'))" ).append("\n"); 
		query.append("AND rownum = 1" ).append("\n"); 

	}
}