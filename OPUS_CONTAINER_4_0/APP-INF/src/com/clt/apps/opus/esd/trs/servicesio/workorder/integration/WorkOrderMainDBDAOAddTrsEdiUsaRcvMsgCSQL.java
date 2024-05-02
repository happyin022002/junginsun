/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderMainDBDAOAddTrsEdiUsaRcvMsgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.04 
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

public class WorkOrderMainDBDAOAddTrsEdiUsaRcvMsgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderMainDBDAOAddTrsEdiUsaRcvMsg
	  * </pre>
	  */
	public WorkOrderMainDBDAOAddTrsEdiUsaRcvMsgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_msg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_rcv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fuel_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_msg_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_fuel_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_rcv_msg_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderMainDBDAOAddTrsEdiUsaRcvMsgCSQL").append("\n"); 
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
		query.append("#if (${chg_compare} == 'Y')" ).append("\n"); 
		query.append("insert into TRS_EDI_USA_RCV_MSG (" ).append("\n"); 
		query.append("   TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("  ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("  ,RCV_MSG_SEQ" ).append("\n"); 
		query.append("  ,RCV_MSG_SUB_SEQ" ).append("\n"); 
		query.append("  ,TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("  ,TRSP_WO_SEQ" ).append("\n"); 
		query.append("  ,LGS_COST_CD" ).append("\n"); 
		query.append("  ,CURR_CD" ).append("\n"); 
		query.append("  ,RCV_AMT" ).append("\n"); 
		query.append("  ,FUEL_RTO" ).append("\n"); 
		query.append("  ,RCV_MSG_STS_CD" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append("  ,RCV_MSG_TP_CD" ).append("\n"); 
		query.append("  ,EDI_RJCT_RSN_CD" ).append("\n"); 
		query.append("  ,RCV_MSG" ).append("\n"); 
		query.append("  ,RCV_MSG_DESC" ).append("\n"); 
		query.append("  ,OLD_RCV_AMT" ).append("\n"); 
		query.append("  ,OLD_FUEL_RTO" ).append("\n"); 
		query.append("  ,OLD_RCV_MSG_DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  select @[trsp_so_ofc_cty_cd] TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,@[trsp_so_seq] TRSP_SO_SEQ" ).append("\n"); 
		query.append("        ,@[rcv_msg_seq] RCV_MSG_SEQ" ).append("\n"); 
		query.append("        ,NVL((SELECT MAX(RCV_MSG_SUB_SEQ) + 1 FROM TRS_EDI_USA_RCV_MSG WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd] AND TRSP_SO_SEQ = @[trsp_so_seq] AND RCV_MSG_SEQ = @[rcv_msg_seq]), 1) RCV_MSG_SUB_SEQ" ).append("\n"); 
		query.append("        ,@[trsp_wo_ofc_cty_cd] TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,@[trsp_wo_seq] TRSP_WO_SEQ" ).append("\n"); 
		query.append("        ,@[lgs_cost_cd] LGS_COST_CD" ).append("\n"); 
		query.append("        ,@[curr_cd] CURR_CD" ).append("\n"); 
		query.append("        ,@[rcv_amt] RCV_AMT" ).append("\n"); 
		query.append("        ,@[fuel_rto] FUEL_RTO" ).append("\n"); 
		query.append("        ,@[rcv_msg_sts_cd] RCV_MSG_STS_CD" ).append("\n"); 
		query.append("        ,'EDIUSER' CRE_USR_ID" ).append("\n"); 
		query.append("        ,sysdate CRE_DT" ).append("\n"); 
		query.append("        ,'EDIUSER' UPD_USR_ID" ).append("\n"); 
		query.append("        ,sysdate UPD_DT" ).append("\n"); 
		query.append("        ,@[rcv_msg_tp_cd] RCV_MSG_TP_CD" ).append("\n"); 
		query.append("        ,@[edi_rjct_rsn_cd] EDI_RJCT_RSN_CD" ).append("\n"); 
		query.append("        ,@[rcv_msg] RCV_MSG" ).append("\n"); 
		query.append("        ,@[rcv_msg_desc] RCV_MSG_DESC" ).append("\n"); 
		query.append("	    ,nvl((select sum(o.scg_amt) from trs_trsp_scg_dtl o where o.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]	 and o.trsp_so_seq = @[trsp_so_seq]	 and o.lgs_cost_cd = @[lgs_cost_cd]), 0) OLD_RCV_AMT" ).append("\n"); 
		query.append("	    ,@[old_fuel_rto] OLD_FUEL_RTO" ).append("\n"); 
		query.append("	    ,@[old_rcv_msg_desc] OLD_RCV_MSG_DESC" ).append("\n"); 
		query.append("    from dual" ).append("\n"); 
		query.append("   where (select count(*) from (" ).append("\n"); 
		query.append("				select lgs_cost_cd cnt" ).append("\n"); 
		query.append("            		from trs_trsp_scg_dtl s" ).append("\n"); 
		query.append("           		where s.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("             	  and s.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("             	  and s.lgs_cost_cd = @[lgs_cost_cd]" ).append("\n"); 
		query.append("				 group by s.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("						 ,s.trsp_so_seq" ).append("\n"); 
		query.append("						 ,s.lgs_cost_cd" ).append("\n"); 
		query.append("			     having SUM(nvl(s.scg_amt, 0)) = @[rcv_amt])) = 0" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MERGE INTO TRS_EDI_USA_RCV_MSG T" ).append("\n"); 
		query.append("USING DUAL D" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("      T.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd] " ).append("\n"); 
		query.append("  AND T.TRSP_SO_SEQ = @[trsp_so_seq] " ).append("\n"); 
		query.append("  AND T.RCV_MSG_SEQ = @[rcv_msg_seq]" ).append("\n"); 
		query.append("  AND T.LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE SET " ).append("\n"); 
		query.append("	     T.RCV_AMT    = NVL(T.RCV_AMT, 0) + NVL(${rcv_amt}, 0)" ).append("\n"); 
		query.append("		,T.OLD_RCV_AMT = NVL((SELECT SUM(NVL(O.SCG_AMT, 0)) FROM TRS_TRSP_SCG_DTL O WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd] AND TRSP_SO_SEQ = @[trsp_so_seq] AND LGS_COST_CD = @[lgs_cost_cd]), 0)" ).append("\n"); 
		query.append("        ,T.UPD_USR_ID = 'EDIUSER'" ).append("\n"); 
		query.append("        ,T.UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT (" ).append("\n"); 
		query.append("     TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("    ,RCV_MSG_SEQ" ).append("\n"); 
		query.append("    ,RCV_MSG_SUB_SEQ" ).append("\n"); 
		query.append("    ,TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("    ,TRSP_WO_SEQ" ).append("\n"); 
		query.append("    ,LGS_COST_CD" ).append("\n"); 
		query.append("    ,CURR_CD" ).append("\n"); 
		query.append("    ,RCV_AMT" ).append("\n"); 
		query.append("    ,FUEL_RTO" ).append("\n"); 
		query.append("    ,RCV_MSG_STS_CD" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("    ,RCV_MSG_TP_CD" ).append("\n"); 
		query.append("    ,EDI_RJCT_RSN_CD" ).append("\n"); 
		query.append("	,RCV_MSG" ).append("\n"); 
		query.append("	,RCV_MSG_DESC" ).append("\n"); 
		query.append("	,OLD_RCV_AMT" ).append("\n"); 
		query.append("	,OLD_FUEL_RTO" ).append("\n"); 
		query.append("	,OLD_RCV_MSG_DESC" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("   @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("  ,@[trsp_so_seq]" ).append("\n"); 
		query.append("  ,@[rcv_msg_seq]" ).append("\n"); 
		query.append("  ,NVL((SELECT MAX(RCV_MSG_SUB_SEQ) + 1 FROM TRS_EDI_USA_RCV_MSG WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd] AND TRSP_SO_SEQ = @[trsp_so_seq] AND RCV_MSG_SEQ = @[rcv_msg_seq]), 1)" ).append("\n"); 
		query.append("  ,@[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("  ,@[trsp_wo_seq]" ).append("\n"); 
		query.append("  ,@[lgs_cost_cd]" ).append("\n"); 
		query.append("  ,@[curr_cd]" ).append("\n"); 
		query.append("  ,@[rcv_amt]" ).append("\n"); 
		query.append("  ,@[fuel_rto]" ).append("\n"); 
		query.append("  ,@[rcv_msg_sts_cd]" ).append("\n"); 
		query.append("  ,'EDIUSER'" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,'EDIUSER'" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[rcv_msg_tp_cd]" ).append("\n"); 
		query.append("  ,@[edi_rjct_rsn_cd]" ).append("\n"); 
		query.append("  ,@[rcv_msg]" ).append("\n"); 
		query.append("  ,@[rcv_msg_desc]" ).append("\n"); 
		query.append("  ,@[old_rcv_amt]" ).append("\n"); 
		query.append("  ,@[old_fuel_rto]" ).append("\n"); 
		query.append("  ,@[old_rcv_msg_desc]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}