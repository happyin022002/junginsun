/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CODCorrectionDBDAOSearchCodCntrDgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOSearchCodCntrDgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cod 대상 cntr의 dg 정보를 조회한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOSearchCodCntrDgInfoRSQL(){
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
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOSearchCodCntrDgInfoRSQL").append("\n"); 
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
		query.append("SELECT COD_CNTR.CNTR_NO," ).append("\n"); 
		query.append("'Container SEQ : '   ||DG.DCGO_SEQ      ||'<BR>'||" ).append("\n"); 
		query.append("'Container No. : '   ||DG.cntr_no       ||'<BR>'||" ).append("\n"); 
		query.append("'EQ Type/Size : '    ||(SELECT substr(CNTR_TPSZ_DESC, 1, 4) from mdm_cntr_tp_sz where cntr_tpsz_cd = DG.CNTR_TPSZ_CD)||'<BR>'||" ).append("\n"); 
		query.append("'Cargo SEQ : '       ||CNTR_CGO_SEQ  ||'<BR>'||" ).append("\n"); 
		query.append("'UN No. : '          ||imdg_un_no    ||'<BR>'||" ).append("\n"); 
		query.append("'IMO Class : '       ||imdg_clss_cd  ||'<BR>'||" ).append("\n"); 
		query.append("'Net WGT/KG : '      ||net_wgt       ||'<BR>'||" ).append("\n"); 
		query.append("'Grs WGT/KG : '      ||grs_wgt       ||'<BR>'||" ).append("\n"); 
		query.append("'Proper Ship Name : '||prp_shp_nm    ||'<BR>'||" ).append("\n"); 
		query.append("'LTD QTY : '         ||imdg_lmt_qty_flg  ||'<BR>'||" ).append("\n"); 
		query.append("'HAZ. Contents : '   ||hzd_desc          ||'<BR>'||" ).append("\n"); 
		query.append("'Flash Point/Cel : ' ||flsh_pnt_cdo_temp ||'<BR>'||" ).append("\n"); 
		query.append("'Packing GRP : '     ||imdg_pck_grp_cd   ||'<BR>'||" ).append("\n"); 
		query.append("(CASE WHEN imdg_subs_rsk_lbl_cd1||imdg_subs_rsk_lbl_cd2||imdg_subs_rsk_lbl_cd3||imdg_subs_rsk_lbl_cd4 IS NULL THEN" ).append("\n"); 
		query.append("'Sub Label : <br>'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'Sub Label : '||imdg_subs_rsk_lbl_cd1||' / '||imdg_subs_rsk_lbl_cd2||' / '||imdg_subs_rsk_lbl_cd3||' / '||imdg_subs_rsk_lbl_cd4 END) ||'<BR>'||" ).append("\n"); 
		query.append("'Control Temp./Cel : '   ||ctrl_temp_ctnt    ||'<BR>'||" ).append("\n"); 
		query.append("'PSA GRP : '             ||psa_no            ||'<BR>'||" ).append("\n"); 
		query.append("'Marine Pollutant : '    ||mrn_polut_flg     ||'<BR>'||" ).append("\n"); 
		query.append("'Cargo Status : '        ||dcgo_sts_cd       ||'<BR>'||" ).append("\n"); 
		query.append("'EMS No : '              ||ems_no            ||'<BR>'||" ).append("\n"); 
		query.append("'ERG : '                 ||emer_rspn_gid_no  ||'<BR>'||" ).append("\n"); 
		query.append("'Emer. Temp./Cel : '     ||emer_temp_ctnt    ||'<BR>'||" ).append("\n"); 
		query.append("'Emergency Contact : '   ||emer_cntc_phn_no_ctnt ||'<BR>'||" ).append("\n"); 
		query.append("'Outer Pack 1 : '        ||out_imdg_pck_qty1     ||'<BR>'||" ).append("\n"); 
		query.append("'                    ' ||(SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD1)      ||'<BR>'||" ).append("\n"); 
		query.append("'Intermediate Pack 1 : ' ||intmd_imdg_pck_qty1   ||'<BR>'||" ).append("\n"); 
		query.append("'                    ' ||(SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = INTMD_IMDG_PCK_CD1)    ||'<BR>'||" ).append("\n"); 
		query.append("'Inner Pack 1 : '        ||in_imdg_pck_qty1      ||'<BR>'||" ).append("\n"); 
		query.append("'                    ' ||(SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = IN_IMDG_PCK_CD1)       ||'<BR>'||" ).append("\n"); 
		query.append("'Outer Pack 2 : '        ||out_imdg_pck_qty2     ||'<BR>'||" ).append("\n"); 
		query.append("'                    ' ||(SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD2)      ||'<BR>'||" ).append("\n"); 
		query.append("'Intermediate Pack 2 : ' ||intmd_imdg_pck_qty2   ||'<BR>'||" ).append("\n"); 
		query.append("'                    ' ||(SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = INTMD_IMDG_PCK_CD2)    ||'<BR>'||" ).append("\n"); 
		query.append("'Inner Pack 2 : '        ||in_imdg_pck_qty2      ||'<BR>'||" ).append("\n"); 
		query.append("'                    ' ||(SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = IN_IMDG_PCK_CD2)       ||'<BR>'||" ).append("\n"); 
		query.append("'Net Expolsive WGT/KG : '||net_explo_wgt         ||'<BR>'||" ).append("\n"); 
		query.append("'<BR>'||'----------------------------------------------------------------------------------------------------------------------------'||'<BR>' DG_INFO" ).append("\n"); 
		query.append("FROM BKG_DG_CGO DG, BKG_COD_CNTR COD_CNTR" ).append("\n"); 
		query.append("WHERE DG.BKG_NO  = COD_CNTR.BKG_NO" ).append("\n"); 
		query.append("AND DG.CNTR_NO = COD_CNTR.CNTR_NO" ).append("\n"); 
		query.append("AND COD_CNTR.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("AND COD_SLCT_FLG      = 'Y'" ).append("\n"); 
		query.append("AND @[bkg_no]       = cod_cntr.bkg_no" ).append("\n"); 
		query.append("AND @[cod_rqst_seq]  = cod_cntr.cod_rqst_seq" ).append("\n"); 

	}
}