/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchEDIByContainerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.11.17 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchEDIByContainerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchEDIByContainerVORSQL(){
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
		params.put("mvmt_edi_msg_area_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt_edi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchEDIByContainerVORSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX CTM_MVMT_EDI_MSG XAK2CTM_MVMT_EDI_MSG */" ).append("\n"); 
		query.append("BKG_KNT," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("BKG_POD_CD," ).append("\n"); 
		query.append("BKG_POL_CD," ).append("\n"); 
		query.append("EDI_BL_NO AS BL_NO," ).append("\n"); 
		query.append("NVL(CALL_SGN_NO, LLOYD_NO) AS CALL_SGN_NO," ).append("\n"); 
		query.append("CHSS_NO," ).append("\n"); 
		query.append("CNMV_CO_CD," ).append("\n"); 
		query.append("CNTR_DMG_FLG," ).append("\n"); 
		query.append("CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_SEAL_NO," ).append("\n"); 
		query.append("CRNT_VSL_CD||CRNT_SKD_VOY_NO||CRNT_SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("DEST_YD_CD," ).append("\n"); 
		query.append("EDI_GATE_IO_CD," ).append("\n"); 
		query.append("EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("TO_CHAR(EVNT_DT, 'YYYY-MM-DD HH24:MI') AS EVNT_DT," ).append("\n"); 
		query.append("EVNT_YD_CD," ).append("\n"); 
		query.append("MGST_NO," ).append("\n"); 
		query.append("MVMT_EDI_MSG_AREA_CD||MVMT_EDI_MSG_YRMONDY||MVMT_EDI_MSG_SEQ AS MUID," ).append("\n"); 
		query.append("MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("PKUP_NO," ).append("\n"); 
		query.append("RTY_KNT AS EDI_RTY_KNT," ).append("\n"); 
		query.append("TML_NM," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("WBL_NO" ).append("\n"); 
		query.append("FROM CTM_MVMT_EDI_MSG" ).append("\n"); 
		query.append("WHERE MVMT_EDI_MSG_AREA_CD = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("AND MVMT_EDI_MSG_SEQ = @[mvmt_edi_msg_seq]" ).append("\n"); 
		query.append("AND MVMT_EDI_MSG_TP_ID = @[mvmt_edi_msg_tp_id]" ).append("\n"); 
		query.append("AND MVMT_EDI_MSG_YRMONDY = @[mvmt_edi_msg_yrmondy]" ).append("\n"); 
		query.append("AND MVMT_EDI_TP_CD = @[mvmt_edi_tp_cd]" ).append("\n"); 

	}
}