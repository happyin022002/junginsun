/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderMainDBDAOAddTrsEdiUsaRcvRejectMsgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderMainDBDAOAddTrsEdiUsaRcvRejectMsgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderMainDBDAOAddTrsEdiUsaRcvRejectMsg
	  * </pre>
	  */
	public WorkOrderMainDBDAOAddTrsEdiUsaRcvRejectMsgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rjct_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_msg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderMainDBDAOAddTrsEdiUsaRcvRejectMsgCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_EDI_USA_RCV_MSG (" ).append("\n"); 
		query.append("     TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("    ,RCV_MSG_SEQ" ).append("\n"); 
		query.append("    ,RCV_MSG_SUB_SEQ" ).append("\n"); 
		query.append("    ,TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("    ,TRSP_WO_SEQ" ).append("\n"); 
		query.append("    ,RCV_MSG_STS_CD" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("    ,RCV_MSG_TP_CD" ).append("\n"); 
		query.append("    ,EDI_RJCT_RSN_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("   @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("  ,@[trsp_so_seq]" ).append("\n"); 
		query.append("  ,@[rcv_msg_seq]" ).append("\n"); 
		query.append("  ,NVL((SELECT MAX(RCV_MSG_SUB_SEQ) + 1 FROM TRS_EDI_USA_RCV_MSG WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd] AND TRSP_SO_SEQ = @[trsp_so_seq] AND RCV_MSG_SEQ = @[rcv_msg_seq]), 1)" ).append("\n"); 
		query.append("  ,@[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("  ,@[trsp_wo_seq]" ).append("\n"); 
		query.append("  ,@[rcv_msg_sts_cd]" ).append("\n"); 
		query.append("  ,'EDIUSER'" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,'EDIUSER'" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[rcv_msg_tp_cd]" ).append("\n"); 
		query.append("  ,@[edi_rjct_rsn_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}