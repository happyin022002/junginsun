/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOUpdateWoExeDtExecuteDateByCtmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOUpdateWoExeDtExecuteDateByCtmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USA404EDIStatusInquiryDBDAOUpdateWoExeDtExecuteDateByCtm
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOUpdateWoExeDtExecuteDateByCtmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("node_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_exe_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOUpdateWoExeDtExecuteDateByCtmUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("   SET" ).append("\n"); 
		query.append("#if(${mvmt_cre_tp_cd} == 'A')  " ).append("\n"); 
		query.append("       	SO.ORG_GATE_OUT_DT 	= (CASE WHEN @[mvmt_sts_cd] IN ('EN','TN','OP','ID') AND @[node_cd] = SO.FM_NOD_CD THEN TO_DATE(@[wo_exe_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                                  ELSE SO.ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("                               END) ," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("		SO.WO_EXE_DT       	= (CASE WHEN SO.TRSP_COST_DTL_MOD_CD <> 'DR' AND @[node_cd] = SO.FM_NOD_CD AND @[mvmt_sts_cd] IN ('EN','TN','OP','ID') THEN TO_DATE(@[wo_exe_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                               	  ELSE SO.WO_EXE_DT" ).append("\n"); 
		query.append("							   END) ,       " ).append("\n"); 
		query.append("       	SO.ORG_GATE_OUT_DT 	= (CASE WHEN @[mvmt_sts_cd] IN ('EN','TN','OP','ID') AND @[node_cd] = SO.FM_NOD_CD THEN TO_DATE(@[wo_exe_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                                  ELSE SO.ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("                               END) ," ).append("\n"); 
		query.append("       	SO.DEST_GATE_IN_DT 	= (CASE WHEN @[mvmt_sts_cd] IN ('OC','IC','MT') AND @[node_cd] = SO.TO_NOD_CD THEN TO_DATE(@[wo_exe_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                                  ELSE SO.DEST_GATE_IN_DT" ).append("\n"); 
		query.append("                               END),   " ).append("\n"); 
		query.append("#end							   " ).append("\n"); 
		query.append("       	SO.UPD_USR_ID      	= @[upd_usr_id]," ).append("\n"); 
		query.append("	   	SO.LOCL_UPD_DT	  	= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(SO.CRE_OFC_CD)," ).append("\n"); 
		query.append("	   	SO.UPD_DT          	= SYSDATE		" ).append("\n"); 
		query.append("WHERE ( SO.EQ_NO = @[cntr_no] OR SO.COP_NO = (SELECT COP_NO FROM SCE_COP_HDR WHERE BKG_NO=@[bkg_no] AND CNTR_NO =@[cntr_no]) )" ).append("\n"); 
		query.append("AND SO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND INSTR(SO.FM_NOD_CD||SO.TO_NOD_CD, @[node_cd] ) > 0" ).append("\n"); 
		query.append("AND SO.DELT_FLG = 'N'" ).append("\n"); 

	}
}