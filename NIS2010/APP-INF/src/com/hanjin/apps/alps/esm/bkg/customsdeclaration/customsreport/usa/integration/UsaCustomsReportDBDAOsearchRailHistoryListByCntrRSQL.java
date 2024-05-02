/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchRailHistoryListByCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.16 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchRailHistoryListByCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 1037, outVO: RailHistoryDetailListVO
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchRailHistoryListByCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchRailHistoryListByCntrRSQL").append("\n"); 
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
		query.append("CR.CSTMS_CLR_CD c" ).append("\n"); 
		query.append(",CR.DSPO_CD code" ).append("\n"); 
		query.append(",DS.CSTMS_DSPO_NM code_desc" ).append("\n"); 
		query.append(",CR.CNTR_NO" ).append("\n"); 
		query.append(",CR.RAIL_REF_NO rail_ams_file_no" ).append("\n"); 
		query.append(",CR.CNTR_QTY qty" ).append("\n"); 
		query.append(",CR.ENTR_TP_NO entry_type" ).append("\n"); 
		query.append(",CR.ENTR_NO entry_number" ).append("\n"); 
		query.append(",TO_CHAR(CR.RCV_DT, 'YYYYMMDD HH24:MI') rcv_dt" ).append("\n"); 
		query.append(",RS.RCV_LOC_CD customs" ).append("\n"); 
		query.append(",RS.VSL_CD || RS.SKD_VOY_NO || RS.SKD_DIR_CD nvocc_vvd" ).append("\n"); 
		query.append(",RS.CSTMS_RMK1 remark" ).append("\n"); 
		query.append(",CR.CSTMS_BAT_NO batch" ).append("\n"); 
		query.append(",CD.INTG_CD_VAL_DESC c_desc" ).append("\n"); 
		query.append("-- 공통 vo RailHistoryDetailListVO 생성용 필드." ).append("\n"); 
		query.append(",'' f, '' o, '' vvd, '' vsl_nm, '' pol" ).append("\n"); 
		query.append(",'' pod, '' eta, '' del, '' hub, '' r" ).append("\n"); 
		query.append(",'' d, '' bl_no, '' wgt, '' qty_tp, '' wgt_ut" ).append("\n"); 
		query.append(",'' tmp1, '' tmp2, '' tmp3" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CSTMS_ADV_CNTR_RSLT CR" ).append("\n"); 
		query.append(",BKG_CSTMS_ADV_DSPO DS" ).append("\n"); 
		query.append(",BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append(",BKG_CSTMS_ADV_CNTR CT" ).append("\n"); 
		query.append(",BKG_CSTMS_ADV_NVOCC_FILE F" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append(",BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CR.CNT_CD   = 'US'" ).append("\n"); 
		query.append("AND CT.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND CR.DSPO_CD = DS.CSTMS_DSPO_CD(+)" ).append("\n"); 
		query.append("AND DS.CNT_CD(+) = 'US'" ).append("\n"); 
		query.append("AND CR.CNT_CD = RS.CNT_CD (+)" ).append("\n"); 
		query.append("AND CR.BL_NO = RS.BL_NO (+)" ).append("\n"); 
		query.append("AND CR.CSTMS_SEQ = RS.CSTMS_SEQ(+)" ).append("\n"); 
		query.append("AND CT.cnt_cd = 'CA'" ).append("\n"); 
		query.append("-- AND CR.CNT_CD = CT.CNT_CD" ).append("\n"); 
		query.append("AND CR.BL_NO = CT.BL_NO" ).append("\n"); 
		query.append("-- CR.CNTR_NO의 4자리 끝에 0이 붙는 경우, 혹은 번호 끝에 공백이 붙는 경우 체크." ).append("\n"); 
		query.append("-- CT.CNTR_NO의 끝자리는 checkDigit이므로 조인에서 제외." ).append("\n"); 
		query.append("AND CR.CNTR_NO LIKE SUBSTR(CT.CNTR_NO, 1, 4) || '%'" ).append("\n"); 
		query.append("AND CR.CNTR_NO LIKE '%' || SUBSTR(CT.CNTR_NO, 5, 6) || '%'" ).append("\n"); 
		query.append("AND F.SCAC_CD(+)  = SUBSTR(CT.RAIL_CRR_REF_NO, 1, 4)" ).append("\n"); 
		query.append("AND F.NVOCC_BL_ID(+) =  SUBSTR(CT.RAIL_CRR_REF_NO, 5)" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("F.SCAC_CD IS NULL" ).append("\n"); 
		query.append("OR F.SCAC_CD IN ('CNRU','CPRS')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CD.INTG_CD_ID(+) = 'CD02155'" ).append("\n"); 
		query.append("AND CR.CSTMS_CLR_CD = CD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("BL.MF_NO = @[bl_no]" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(BL.MF_NO IS NULL AND BL.BL_NO = @[bl_no])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CR.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("AND CR.CNT_CD = BL.CNT_CD" ).append("\n"); 

	}
}