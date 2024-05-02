/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCdlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCdlList
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_edi_rpt_msg_rcv_dt_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_ldis_dt_start",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_ldis_dt_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_tml_vvd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_edi_rpt_msg_rcv_dt_start",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_event_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlListRSQL").append("\n"); 
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
		query.append("EDI_SNDR_ID," ).append("\n"); 
		query.append("EVNT_YD_CD," ).append("\n"); 
		query.append("TML_VVD_ID," ).append("\n"); 
		query.append("POL_CD," ).append("\n"); 
		query.append("POD_CD," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CO_RPT_ID," ).append("\n"); 
		query.append("CALL_SGN_NO," ).append("\n"); 
		query.append("VSL_NM," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_SEAL_NO," ).append("\n"); 
		query.append("TO_CHAR(CNTR_LDIS_DT,'YYYY-MM-DD HH24:MI') CNTR_LDIS_DT," ).append("\n"); 
		query.append("STWG_CELL_NO," ).append("\n"); 
		query.append("TO_CHAR(EDI_RPT_MSG_RCV_DT,'YYYY-MM-DD HH24:MI') EDI_RPT_MSG_RCV_DT," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT," ).append("\n"); 
		query.append("DECODE(CRR_CD, NULL,CO_RPT_ID, CRR_CD) CRR_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_SEAL_NO2," ).append("\n"); 
		query.append("DECODE(CGO_STS_ID, '2','EXPORT', '3','IMPORT', '6','T/S', CGO_STS_ID) CGO_STS_ID," ).append("\n"); 
		query.append("N1ST_POD_CD," ).append("\n"); 
		query.append("GRS_WGT," ).append("\n"); 
		query.append("DECODE(CGO_TP_CD," ).append("\n"); 
		query.append("'0','NORMAL', '1','REEFER', '2','RF/IMO', '3','IMO', '9','EMPTY'," ).append("\n"); 
		query.append("CGO_TP_CD" ).append("\n"); 
		query.append(") CGO_TP_CD," ).append("\n"); 
		query.append("IMDG_CLSS_ID," ).append("\n"); 
		query.append("EUR_TML_DMG_ID," ).append("\n"); 
		query.append("DECODE(TRSP_MOD_ID, 'T','TRUCK', 'R','RAIL', 'F','FEEDER', TRSP_MOD_ID) TRSP_MOD_ID," ).append("\n"); 
		query.append("ORG_YD_CD," ).append("\n"); 
		query.append("DECODE(EXP_DT," ).append("\n"); 
		query.append("NULL,TO_CHAR(TO_DATE(CNTR_LDIS_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("TO_CHAR(EXP_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append(") EXP_DT," ).append("\n"); 
		query.append("CSTMS_DECL_NO," ).append("\n"); 
		query.append("CNTR_TARE_WGT," ).append("\n"); 
		query.append("TML_MSG_MTCH_ID MTCH_FLG," ).append("\n"); 
		query.append("CALL_SGN_NO" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_TML_EUR" ).append("\n"); 
		query.append("WHERE	TO_CHAR(EDI_RPT_MSG_RCV_DT, 'YYYY-MM-DD') BETWEEN TO_CHAR(TO_DATE(@[in_edi_rpt_msg_rcv_dt_start], 'YYYY-MM-DD'), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND TO_CHAR(TO_DATE(@[in_edi_rpt_msg_rcv_dt_end], 'YYYY-MM-DD'), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#if (${in_cntr_ldis_dt_start} != '' && ${in_cntr_ldis_dt_end} != '' )" ).append("\n"); 
		query.append("AND TO_CHAR(CNTR_LDIS_DT, 'YYYY-MM-DD') BETWEEN TO_CHAR(TO_DATE(@[in_cntr_ldis_dt_start], 'YYYY-MM-DD'), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND TO_CHAR(TO_DATE(@[in_cntr_ldis_dt_end], 'YYYY-MM-DD'), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_event_yd_cd} != '')" ).append("\n"); 
		query.append("AND EVNT_YD_CD	= @[in_event_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_pol_cd} != '')" ).append("\n"); 
		query.append("AND POL_CD	= @[in_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_pod_cd} != '')" ).append("\n"); 
		query.append("AND POD_CD	= @[in_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_tml_vvd_id} != '')" ).append("\n"); 
		query.append("AND TML_VVD_ID	= @[in_tml_vvd_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_call_sgn_no} != '')" ).append("\n"); 
		query.append("AND CALL_SGN_NO = @[in_call_sgn_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_vsl_nm} != '')" ).append("\n"); 
		query.append("AND VSL_NM	= @[in_vsl_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_cntr_no} != '')" ).append("\n"); 
		query.append("AND CNTR_NO = @[in_cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CNTR_LODG_DCHG_CD = 'D'" ).append("\n"); 
		query.append("ORDER BY EDI_RPT_MSG_RCV_DT" ).append("\n"); 

	}
}