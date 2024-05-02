/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchCodCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.15
*@LastModifier : 문경일
*@LastVersion : 1.0
* 2015.10.15 문경일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYOUNGIL MOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOsearchCodCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_cod_cntr을 조회한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchCodCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("codRqstSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchCodCntrRSQL").append("\n"); 
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
		query.append("#if(${cod_sts_cd}=='')" ).append("\n"); 
		query.append("select rownum seq" ).append("\n"); 
		query.append("        , decode(NVL(cod_cntr.cod_slct_flg, 'N'), 'N', 'N', 'Y') chk" ).append("\n"); 
		query.append("        , cntr.cntr_no" ).append("\n"); 
		query.append("        , cntr.cntr_tpsz_cd " ).append("\n"); 
		query.append("        , to_char(cntr.cntr_wgt, '999,999,990.000') cntr_wgt" ).append("\n"); 
		query.append("        , cntr.wgt_ut_cd" ).append("\n"); 
		query.append("        , cntr.dcgo_flg" ).append("\n"); 
		query.append("        , cntr.bb_cgo_flg" ).append("\n"); 
		query.append("        , cntr.awk_cgo_flg" ).append("\n"); 
		query.append("        , cntr.rc_flg" ).append("\n"); 
		query.append("        , cntr.soc_flg" ).append("\n"); 
		query.append("        , cod_cntr.cntr_stwg_no" ).append("\n"); 
		query.append("		, nvl((select '1'" ).append("\n"); 
		query.append("                 from bkg_cod_cntr reserve_cntr, bkg_cod cod" ).append("\n"); 
		query.append("                where cntr.bkg_no       = COD.bkg_no" ).append("\n"); 
		query.append("                  and cntr.bkg_no       = reserve_cntr.bkg_no " ).append("\n"); 
		query.append("                  AND cntr.cntr_no      = RESERVE_CNTR.CNTR_NO --같은 cntr" ).append("\n"); 
		query.append("                  AND COD.COD_RQST_SEQ  = RESERVE_CNTR.COD_RQST_SEQ" ).append("\n"); 
		query.append("                  and cod.cod_rqst_seq  < NVL(cod_cntr.cod_rqst_seq, (SELECT MAX(COD_RQST_SEQ) + 1" ).append("\n"); 
		query.append("                                                                        FROM BKG_COD_CNTR MAX_SEQ" ).append("\n"); 
		query.append("                                                                       WHERE MAX_SEQ.BKG_NO = CNTR.BKG_NO))" ).append("\n"); 
		query.append("                  and cod.cod_sts_cd    in ('R', 'Y', 'W')" ).append("\n"); 
		query.append("                  and rownum            = 1" ).append("\n"); 
		query.append("               ),'0') reserved_cntr_flg" ).append("\n"); 
		query.append("		, (select CNMV_STS_CD" ).append("\n"); 
		query.append("			 from mst_container mst" ).append("\n"); 
		query.append("		    where mst.cntr_no  = cntr.cntr_no) mvmt_sts_cd" ).append("\n"); 
		query.append("		, '' DG_EML_CTNT" ).append("\n"); 
		query.append("		, (SELECT '<TR>'||" ).append("\n"); 
		query.append("			      '<td>'||rf.cntr_no||'</TD>'||" ).append("\n"); 
		query.append("			      '<td>'||replace((select cmdt.cmdt_nm from mdm_commodity cmdt where cmdt.cmdt_cd = rf.CMDT_CD), ';', '')||'</TD>'||" ).append("\n"); 
		query.append("			      '<td>'||(case when CDO_TEMP > 0 then '+' else '' end)||cdo_temp||'.C('||" ).append("\n"); 
		query.append("				          (case when FDO_TEMP > 0 then '+' else '' end)||FDO_TEMP||'.F)'||'</TD>'||" ).append("\n"); 
		query.append("			      '<TD>'||VENT_RTO||'%OPEN'||'</TD></tr>'" ).append("\n"); 
		query.append("		     FROM BKG_RF_CGO RF           " ).append("\n"); 
		query.append("            WHERE RF.BKG_NO  = COD_CNTR.BKG_NO" ).append("\n"); 
		query.append("              AND RF.CNTR_NO = COD_CNTR.CNTR_NO" ).append("\n"); 
		query.append("              AND COD_CNTR.RC_FLG = 'Y'" ).append("\n"); 
		query.append("              AND COD_SLCT_FLG      = 'Y') RF_EML_CTNT" ).append("\n"); 
		query.append("		, (SELECT M.CNTR_TPSZ_DESC FROM MDM_CNTR_TP_SZ M WHERE M.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD) AS CNTR_TPSZ_DESC" ).append("\n"); 
		query.append("  from bkg_container cntr, bkg_cod_cntr cod_cntr" ).append("\n"); 
		query.append(" where cntr.bkg_no  = cod_Cntr.bkg_no(+)" ).append("\n"); 
		query.append("   and cntr.cntr_no = cod_cntr.cntr_no(+)" ).append("\n"); 
		query.append("#if (${codRqstSeq} !='' )" ).append("\n"); 
		query.append("   and @[codRqstSeq]  = cod_cntr.cod_rqst_seq(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   and @[bkgNo] = cntr.bkg_no" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("select rownum seq" ).append("\n"); 
		query.append("        , decode(cod_cntr.cod_slct_flg, 'N', 'N', 'Y') chk" ).append("\n"); 
		query.append("        , cod_cntr.cntr_no" ).append("\n"); 
		query.append("        , cod_cntr.cntr_tpsz_cd " ).append("\n"); 
		query.append("        , to_char(cod_cntr.cntr_wgt, '999,999,990.000') cntr_wgt" ).append("\n"); 
		query.append("        , cod_cntr.wgt_ut_cd" ).append("\n"); 
		query.append("        , cod_cntr.dcgo_flg" ).append("\n"); 
		query.append("        , cod_cntr.bb_cgo_flg" ).append("\n"); 
		query.append("        , cod_cntr.awk_cgo_flg" ).append("\n"); 
		query.append("        , cod_cntr.rc_flg" ).append("\n"); 
		query.append("        , cod_cntr.soc_flg" ).append("\n"); 
		query.append("        , cod_cntr.cntr_stwg_no" ).append("\n"); 
		query.append("		, nvl((select '1'" ).append("\n"); 
		query.append("                 from bkg_cod_cntr reserve_cntr, bkg_cod cod" ).append("\n"); 
		query.append("                where cod_cntr.bkg_no       = COD.bkg_no" ).append("\n"); 
		query.append("                  and cod_cntr.bkg_no       = reserve_cntr.bkg_no " ).append("\n"); 
		query.append("                  AND cod_cntr.cntr_no      = RESERVE_CNTR.CNTR_NO --같은 cntr" ).append("\n"); 
		query.append("                  AND COD.COD_RQST_SEQ  = RESERVE_CNTR.COD_RQST_SEQ" ).append("\n"); 
		query.append("                  and cod.cod_rqst_seq  < NVL(cod_cntr.cod_rqst_seq, (SELECT MAX(COD_RQST_SEQ) + 1" ).append("\n"); 
		query.append("                                                                        FROM BKG_COD_CNTR MAX_SEQ" ).append("\n"); 
		query.append("                                                                       WHERE MAX_SEQ.BKG_NO = cod_cntr.BKG_NO))" ).append("\n"); 
		query.append("                  and cod.cod_sts_cd    in ('R', 'Y', 'W')" ).append("\n"); 
		query.append("                  and rownum            = 1" ).append("\n"); 
		query.append("               ),'0') reserved_cntr_flg" ).append("\n"); 
		query.append("		, (select CNMV_STS_CD" ).append("\n"); 
		query.append("			 from mst_container mst" ).append("\n"); 
		query.append("		    where mst.cntr_no = cod_cntr.cntr_no) mvmt_sts_cd" ).append("\n"); 
		query.append("		, '' DG_EML_CTNT" ).append("\n"); 
		query.append("		, (SELECT '<TR>'||" ).append("\n"); 
		query.append("			      '<td>'||rf.cntr_no||'</TD>'||" ).append("\n"); 
		query.append("			      '<td>'||replace((select cmdt.cmdt_nm from mdm_commodity cmdt where cmdt.cmdt_cd = rf.CMDT_CD), ';', '')||'</TD>'||" ).append("\n"); 
		query.append("			      '<td>'||(case when CDO_TEMP > 0 then '+' else '' end)||cdo_temp||'.C('||" ).append("\n"); 
		query.append("				          (case when FDO_TEMP > 0 then '+' else '' end)||FDO_TEMP||'.F)'||'</TD>'||" ).append("\n"); 
		query.append("			      '<TD>'||VENT_RTO||'%OPEN'||'</TD></tr>'" ).append("\n"); 
		query.append("		     FROM BKG_RF_CGO RF           " ).append("\n"); 
		query.append("            WHERE RF.BKG_NO  = COD_CNTR.BKG_NO" ).append("\n"); 
		query.append("              AND RF.CNTR_NO = COD_CNTR.CNTR_NO" ).append("\n"); 
		query.append("              AND COD_CNTR.RC_FLG = 'Y'" ).append("\n"); 
		query.append("              AND COD_SLCT_FLG      = 'Y') RF_EML_CTNT" ).append("\n"); 
		query.append("		,(SELECT M.CNTR_TPSZ_DESC FROM MDM_CNTR_TP_SZ M WHERE M.CNTR_TPSZ_CD = cod_cntr.CNTR_TPSZ_CD) AS CNTR_TPSZ_DESC" ).append("\n"); 
		query.append("  from bkg_cod_cntr cod_cntr" ).append("\n"); 
		query.append(" where @[bkgNo]       = cod_cntr.bkg_no" ).append("\n"); 
		query.append("   and @[codRqstSeq]  = cod_cntr.cod_rqst_seq" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}