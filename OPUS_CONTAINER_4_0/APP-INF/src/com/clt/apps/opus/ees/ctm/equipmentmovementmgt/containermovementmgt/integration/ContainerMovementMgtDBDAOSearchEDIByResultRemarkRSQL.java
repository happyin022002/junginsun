/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchEDIByResultRemarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.04 김상수
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

public class ContainerMovementMgtDBDAOSearchEDIByResultRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchEDIByResultRemarkRSQL(){
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
		query.append("FileName : ContainerMovementMgtDBDAOSearchEDIByResultRemarkRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("TO_CHAR(CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS CRE_LOCL_DT," ).append("\n"); 
		query.append("CRNT_VSL_CD||CRNT_SKD_VOY_NO||CRNT_SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("EDI_GATE_IO_CD," ).append("\n"); 
		query.append("EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("EDI_RMK," ).append("\n"); 
		query.append("RTY_KNT," ).append("\n"); 
		query.append("EVNT_YD_CD" ).append("\n"); 
		query.append("FROM CTM_EDI_RSLT_RMK" ).append("\n"); 
		query.append("WHERE MVMT_EDI_MSG_AREA_CD = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("AND MVMT_EDI_MSG_SEQ = @[mvmt_edi_msg_seq]" ).append("\n"); 
		query.append("AND MVMT_EDI_MSG_TP_ID = @[mvmt_edi_msg_tp_id]" ).append("\n"); 
		query.append("AND MVMT_EDI_MSG_YRMONDY = @[mvmt_edi_msg_yrmondy]" ).append("\n"); 
		query.append("AND MVMT_EDI_TP_CD = @[mvmt_edi_tp_cd]" ).append("\n"); 
		query.append("ORDER BY RTY_KNT" ).append("\n"); 

	}
}