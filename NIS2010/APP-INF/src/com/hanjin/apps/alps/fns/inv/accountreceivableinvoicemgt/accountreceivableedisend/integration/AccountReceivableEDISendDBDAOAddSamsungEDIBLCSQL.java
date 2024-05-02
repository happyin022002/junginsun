/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOAddSamsungEDIBLCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOAddSamsungEDIBLCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GERP BL 테이블에 insert.
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOAddSamsungEDIBLCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gerp_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gerp_crr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_d7_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_line_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_d2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_inv_no_org",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obrd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_d4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_cntr_grp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_d5_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_etc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_cbm_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOAddSamsungEDIBLCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO INV_AR_EDI_GERP_BL (MSG_ID, MSG_NO, BL_LINE_NO, BL_SRC_NO, FCTRY_CTNT, FCTRY_NM, DIV_CTNT, DIV_NM, SR_INV_NO, GERP_TRSP_CD, GERP_TRSP_NM, OBRD_DT, GERP_CRR_CTNT, GERP_CRR_NM, POR_CD, POL_CD, POD_CD, DEL_CD, ISS_DT, INV_EDI_D2_QTY, INV_EDI_D4_QTY, INV_EDI_D5_QTY, INV_EDI_D7_QTY, INV_EDI_ETC_QTY, INV_EDI_R2_QTY, INV_EDI_R4_QTY, INV_EDI_F4_QTY, GRS_CNTR_WGT, GRS_CBM_CAPA, SND_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, BL_CNTR_GRP_CTNT)" ).append("\n"); 
		query.append("VALUES (@[msg_id]," ).append("\n"); 
		query.append("      @[msg_no]," ).append("\n"); 
		query.append("      @[bl_line_no]," ).append("\n"); 
		query.append("      @[bl_src_no]," ).append("\n"); 
		query.append("      ( SELECT NVL(MAX(B.FCTRY_CTNT), ' ')" ).append("\n"); 
		query.append("        FROM   BKG_XTER_RQST_MISC B" ).append("\n"); 
		query.append("        WHERE  B.XTER_RQST_NO =  @[sr_inv_no_org] )," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT NVL(MAX(B.FCTRY_NM), ' ')" ).append("\n"); 
		query.append("        FROM   BKG_XTER_RQST_MISC B" ).append("\n"); 
		query.append("        WHERE  B.XTER_RQST_NO =  @[sr_inv_no_org] ) ," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT NVL(MAX(B.DIV_CTNT), ' ')" ).append("\n"); 
		query.append("        FROM   BKG_XTER_RQST_MISC B" ).append("\n"); 
		query.append("        WHERE  B.XTER_RQST_NO =  @[sr_inv_no_org] )," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT NVL(MAX(B.DIV_NM), ' ')" ).append("\n"); 
		query.append("        FROM   BKG_XTER_RQST_MISC B" ).append("\n"); 
		query.append("        WHERE  B.XTER_RQST_NO =  @[sr_inv_no_org] )," ).append("\n"); 
		query.append("      @[sr_inv_no]," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT NVL(MAX(B.TS_TP_CTNT ), '04')" ).append("\n"); 
		query.append("        FROM INV_AR_MN A," ).append("\n"); 
		query.append("          BKG_XTER_RQST_MISC B" ).append("\n"); 
		query.append("        WHERE A.BKG_REF_NO = B.XTER_RQST_NO" ).append("\n"); 
		query.append("          AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("          AND A.BKG_REF_NO = @[sr_inv_no_org]" ).append("\n"); 
		query.append("          AND ROWNUM = 1)," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT NVL(MAX(B.TS_NM ), 'SEA')" ).append("\n"); 
		query.append("        FROM INV_AR_MN A," ).append("\n"); 
		query.append("          BKG_XTER_RQST_MISC B" ).append("\n"); 
		query.append("        WHERE A.BKG_REF_NO = B.XTER_RQST_NO" ).append("\n"); 
		query.append("          AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("          AND A.BKG_REF_NO = @[sr_inv_no_org]" ).append("\n"); 
		query.append("          AND ROWNUM = 1)," ).append("\n"); 
		query.append("      @[obrd_dt]," ).append("\n"); 
		query.append("      @[gerp_crr_cd]," ).append("\n"); 
		query.append("      @[gerp_crr_nm]," ).append("\n"); 
		query.append("      @[por_cd]," ).append("\n"); 
		query.append("      @[pol_cd]," ).append("\n"); 
		query.append("      @[pod_cd]," ).append("\n"); 
		query.append("      @[del_cd]," ).append("\n"); 
		query.append("      (SELECT BIL_DT " ).append("\n"); 
		query.append("         FROM INV_AR_EDI_GERP_HDR " ).append("\n"); 
		query.append("        WHERE MSG_ID = @[msg_id]" ).append("\n"); 
		query.append("          AND MSG_NO = @[msg_no]), " ).append("\n"); 
		query.append("      @[inv_edi_d2_qty]," ).append("\n"); 
		query.append("      @[inv_edi_d4_qty]," ).append("\n"); 
		query.append("      @[inv_edi_d5_qty]," ).append("\n"); 
		query.append("      @[inv_edi_d7_qty]," ).append("\n"); 
		query.append("      @[inv_edi_etc_qty]," ).append("\n"); 
		query.append("      0," ).append("\n"); 
		query.append("      0," ).append("\n"); 
		query.append("      0," ).append("\n"); 
		query.append("      @[grs_cntr_wgt]," ).append("\n"); 
		query.append("      @[grs_cbm_capa]," ).append("\n"); 
		query.append("      'N'," ).append("\n"); 
		query.append("      @[cre_usr_id]," ).append("\n"); 
		query.append("      SYSDATE," ).append("\n"); 
		query.append("      @[upd_usr_id]," ).append("\n"); 
		query.append("      SYSDATE," ).append("\n"); 
		query.append("	  @[bl_cntr_grp_ctnt])" ).append("\n"); 

	}
}