/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderManagementDBDAOInsertTrsSubStsHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderManagementDBDAOInsertTrsSubStsHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderManagementDBDAOInsertTrsSubStsHis
	  * </pre>
	  */
	public WorkOrderManagementDBDAOInsertTrsSubStsHisCSQL(){
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
		params.put("wo_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt_cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration").append("\n"); 
		query.append("FileName : WorkOrderManagementDBDAOInsertTrsSubStsHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_SUB_STS_HIS (" ).append("\n"); 
		query.append("   TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("  ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("  ,HIS_SEQ" ).append("\n"); 
		query.append("  ,PRE_TRSP_SUB_STS_CD" ).append("\n"); 
		query.append("  ,CRNT_TRSP_SUB_STS_CD" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append(") SELECT TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("        ,TRS_SUB_STS_HIS_SEQ1.NEXTVAL AS HIS_SEQ" ).append("\n"); 
		query.append("        ,SO.TRS_SUB_STS_CD" ).append("\n"); 
		query.append("        ,(CASE WHEN @[mvmt_sts_cd] IN ('EN', 'TN', 'OP', 'ID') AND @[node_cd] = SO.FM_NOD_CD THEN 'ST'" ).append("\n"); 
		query.append("               WHEN @[mvmt_sts_cd] IN ('OC', 'IC', 'MT') AND @[node_cd] = SO.TO_NOD_CD THEN 'CM'" ).append("\n"); 
		query.append("               ELSE  SO.TRS_SUB_STS_CD" ).append("\n"); 
		query.append("         END)" ).append("\n"); 
		query.append("        ,@[upd_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[upd_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("    FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("   WHERE (SO.EQ_NO = @[cntr_no] OR SO.COP_NO = (SELECT COP_NO FROM SCE_COP_HDR WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no]))" ).append("\n"); 
		query.append("     AND SO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     AND NVL2(@[wo_no], SO.TRSP_WO_OFC_CTY_CD || SO.TRSP_WO_SEQ, 'XXX') = NVL(@[wo_no], 'XXX')" ).append("\n"); 
		query.append("     AND INSTR(SO.FM_NOD_CD || SO.TO_NOD_CD || SO.VIA_NOD_CD, @[node_cd]) > 0" ).append("\n"); 
		query.append("     AND SO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("     AND NVL(SO.TRS_SUB_STS_CD, 'XX') <> 'CM'" ).append("\n"); 
		query.append("     AND NVL(SO.TRS_SUB_STS_CD, 'X') <> NVL((CASE WHEN @[mvmt_sts_cd] IN ('EN', 'TN', 'OP', 'ID') AND @[node_cd] = SO.FM_NOD_CD THEN 'ST'" ).append("\n"); 
		query.append("                                                  WHEN @[mvmt_sts_cd] IN ('OC', 'IC', 'MT') AND @[node_cd] = SO.TO_NOD_CD THEN 'CM'" ).append("\n"); 
		query.append("                                                  ELSE  SO.TRS_SUB_STS_CD" ).append("\n"); 
		query.append("                                             END), 'X')" ).append("\n"); 
		query.append("	 AND NVL(@[mvmt_cre_tp_cd], 'X') <> 'A'" ).append("\n"); 

	}
}