/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CIMCommonDBDAOAddCtmMvmtEdiRsltDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.09
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.06.09 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOAddCtmMvmtEdiRsltDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mvmt 저장
	  * </pre>
	  */
	public CIMCommonDBDAOAddCtmMvmtEdiRsltDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_yrmondy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOAddCtmMvmtEdiRsltDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_EDI_RSLT_RMK (" ).append("\n"); 
		query.append("	MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("	MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("	MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("	MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("	MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("	RTY_KNT," ).append("\n"); 
		query.append("	EDI_RMK," ).append("\n"); 
		query.append("	CNTR_NO," ).append("\n"); 
		query.append("	EDI_GATE_IO_CD," ).append("\n"); 
		query.append("	CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("	CRNT_VSL_CD," ).append("\n"); 
		query.append("	CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("	CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("	BKG_NO," ).append("\n"); 
		query.append("	EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("	EVNT_YD_CD," ).append("\n"); 
		query.append("	CRE_LOCL_DT," ).append("\n"); 
		query.append("	UPD_LOCL_DT," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("	VALUES " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	@[mvmt_edi_tp_cd]," ).append("\n"); 
		query.append("	@[mvmt_edi_msg_tp_id]," ).append("\n"); 
		query.append("	@[mvmt_edi_msg_area_cd]," ).append("\n"); 
		query.append("	@[mvmt_edi_msg_yrmondy]," ).append("\n"); 
		query.append("    @[mvmt_edi_msg_seq]," ).append("\n"); 
		query.append("	NVL((" ).append("\n"); 
		query.append("	SELECT MAX(NVL(RTY_KNT, 0)) + 1" ).append("\n"); 
		query.append("	FROM CTM_EDI_RSLT_RMK WHERE " ).append("\n"); 
		query.append("	MVMT_EDI_TP_CD           = @[mvmt_edi_tp_cd]" ).append("\n"); 
		query.append("	AND MVMT_EDI_MSG_TP_ID   = @[mvmt_edi_msg_tp_id]" ).append("\n"); 
		query.append("	AND MVMT_EDI_MSG_AREA_CD = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("	AND MVMT_EDI_MSG_YRMONDY = @[mvmt_edi_msg_yrmondy]" ).append("\n"); 
		query.append("	AND MVMT_EDI_MSG_SEQ     = @[mvmt_edi_msg_seq]" ).append("\n"); 
		query.append("	), 1)," ).append("\n"); 
		query.append("	'OK.PROCESSED(Force Apply)'," ).append("\n"); 
		query.append("	@[cntr_no]," ).append("\n"); 
		query.append("	'I'," ).append("\n"); 
		query.append("	'M'," ).append("\n"); 
		query.append("	@[crnt_vsl_cd]," ).append("\n"); 
		query.append("	@[crnt_skd_voy_no]," ).append("\n"); 
		query.append("	@[crnt_skd_dir_cd]," ).append("\n"); 
		query.append("	@[bkg_no]," ).append("\n"); 
		query.append("	@[mvmt_sts_cd]," ).append("\n"); 
		query.append("	@[org_yd_cd]," ).append("\n"); 
		query.append("	GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR(@[org_yd_cd], 0, 5 ))," ).append("\n"); 
		query.append("	GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR(@[org_yd_cd], 0, 5 ))," ).append("\n"); 
		query.append("	'OPUSADM'," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	'OPUSADM'," ).append("\n"); 
		query.append("	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}