/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOUpdateResultAsDelForMvmtEdiMsgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOUpdateResultAsDelForMvmtEdiMsgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOUpdateResultAsDelForMvmtEdiMsgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("mvmt_edi_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOUpdateResultAsDelForMvmtEdiMsgUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MVMT_EDI_MSG" ).append("\n"); 
		query.append("   SET MVMT_EDI_RSLT_CD = @[mvmt_edi_rslt_cd]" ).append("\n"); 
		query.append("     , CNMV_RMK = @[cnmv_rmk]" ).append("\n"); 
		query.append("     , RTY_KNT = NVL((" ).append("\n"); 
		query.append("                        SELECT MAX(A.RTY_KNT) RTY_KNT" ).append("\n"); 
		query.append("                          FROM CTM_EDI_RSLT_RMK A" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND A.MVMT_EDI_TP_CD = @[mvmt_edi_tp_cd]" ).append("\n"); 
		query.append("                           AND A.MVMT_EDI_MSG_TP_ID = @[mvmt_edi_msg_tp_id]" ).append("\n"); 
		query.append("                           AND A.MVMT_EDI_MSG_AREA_CD = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("						   AND A.MVMT_EDI_MSG_YRMONDY = @[mvmt_edi_msg_yrmondy]" ).append("\n"); 
		query.append("                           AND A.MVMT_EDI_MSG_SEQ = @[mvmt_edi_msg_seq]" ).append("\n"); 
		query.append("                    ), " ).append("\n"); 
		query.append("                    0)" ).append("\n"); 
		query.append("	, UPD_LOCL_DT = GLOBALDATE_PKG.TIME_LOCAL_FNC(DECODE (EVNT_YD_CD, '', DECODE (MVMT_EDI_MSG_AREA_CD, 'USA', 'USNYC', 'KOR', 'KRSEL', 'CHN', 'CHSHA', 'SWA', 'SGSIN', 'EUR', 'DEHAM', ''), SUBSTR(EVNT_YD_CD, 1, 5)))" ).append("\n"); 
		query.append("	, UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("	, UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND MVMT_EDI_TP_CD = @[mvmt_edi_tp_cd]" ).append("\n"); 
		query.append("   AND MVMT_EDI_MSG_TP_ID = @[mvmt_edi_msg_tp_id]" ).append("\n"); 
		query.append("   AND MVMT_EDI_MSG_AREA_CD = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("   AND MVMT_EDI_MSG_YRMONDY = @[mvmt_edi_msg_yrmondy]" ).append("\n"); 
		query.append("   AND MVMT_EDI_MSG_SEQ = @[mvmt_edi_msg_seq]" ).append("\n"); 

	}
}